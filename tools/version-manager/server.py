
"""
CuongNSO Version Manager - Python Backend Server
Runs on http://localhost:3399
Requirements: Python 3.6+, Pillow
"""

import base64
import http.server
import io
import json
import os
import re
import shutil
import ssl
import struct
import subprocess
import sys
import threading
import time
import urllib.error
import urllib.request
from datetime import datetime
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer
from urllib.parse import urlparse

try:
    from PIL import Image
    HAS_PILLOW = True
except ImportError:
    HAS_PILLOW = False

# Fix Windows console encoding
if sys.platform == 'win32':
    try:
        sys.stdout.reconfigure(encoding='utf-8')
        sys.stderr.reconfigure(encoding='utf-8')
    except Exception:
        pass

PORT = 3399
PROJECT_ROOT = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', '..'))
TOOL_DIR = os.path.dirname(os.path.abspath(__file__))
ANDROID_BUILD_GRADLE = os.path.join(PROJECT_ROOT, 'android', 'build.gradle')
GAME_VARIANTS = ['game1', 'game2', 'game3', 'game4', 'game5', 'game6']
IOS_SETTINGS_PATH = os.path.join(TOOL_DIR, 'ios-settings.json')
GIT_EXE = r'C:\Program Files\Git\bin\git.exe'
JPACKAGE_PATHS = [
    r'C:\Program Files\Java\jdk-17\bin\jpackage.exe',
    r'C:\Program Files\Java\jdk-21\bin\jpackage.exe',
    r'C:\Program Files\Java\jdk-20\bin\jpackage.exe',
    r'C:\Program Files\Java\jdk-19\bin\jpackage.exe',
    r'C:\Program Files\Java\jdk-18\bin\jpackage.exe',
]
ANT_PATHS = [
    r'C:\Program Files\NetBeans-17\netbeans\extide\ant\bin\ant.bat',
    r'C:\Program Files (x86)\NetBeans 8.2\extide\ant\bin\ant.bat',
    r'C:\Program Files\apache-ant\bin\ant.bat',
    r'C:\apache-ant\bin\ant.bat',
]

# Java MIDlet client variants (ant-based NetBeans projects)
# 'proguard_jar'/'proguard_pro' set -> run java -jar directly (skip .bat's `pause`)
JAVA_CLIENTS = {
    '148': {
        'dir': os.path.join(PROJECT_ROOT, 'Client148+20Vvhip'),
        'name': 'Client 148 VIP',
        'ant_target': 'jar',
        'raw_jar': os.path.join(PROJECT_ROOT, 'Client148+20Vvhip', 'dist', 'NinjaSchool148.jar'),
        'proguard_jar': os.path.join(PROJECT_ROOT, 'Client148+20Vvhip', 'proguard-7.6.0', 'lib', 'proguard.jar'),
        'proguard_pro': 'ProGuardVIP.pro',
        'obf_jar': os.path.join(PROJECT_ROOT, 'Client148+20Vvhip', 'NSO148.jar'),
    },
    '217': {
        'dir': os.path.join(PROJECT_ROOT, 'CLient217VIP'),
        'name': 'Client 217 VIP',
        'ant_target': None,  # default target already runs ProGuard via -post-jar
        'raw_jar': None,
        'proguard_jar': None,  # Ant handles proguard via post-jar target
        'proguard_pro': None,
        # Output name follows `tenphienban` in configbuild.txt (NSO217VIP_Obf.jar)
        'obf_jar': os.path.join(PROJECT_ROOT, 'CLient217VIP', 'dist', 'NSO217VIP_Obf.jar'),
    },
}

# Where in UpdateServer.java the tool writes the IP list for each Java client.
# 'encode': 'plain' = write raw string, 'base64' = Base64-encode first.
JAVA_CLIENT_FIELD = {
    '148': {
        'path': os.path.join(PROJECT_ROOT, 'Client148+20Vvhip', 'src', 'UpdateServer.java'),
        'regex': r'(SERVER_LIST\s*=\s*")([^"]*)(")',
        'encode': 'plain',
    },
    '217': {
        'path': os.path.join(PROJECT_ROOT, 'CLient217VIP', 'src', 'UpdateServer.java'),
        'regex': r'(\bm\s*=\s*")([^"]*)(";)',
        'encode': 'base64',
    },
}

# SSE clients and build state
sse_clients = []
sse_lock = threading.Lock()
current_build_proc = None
build_lock = threading.Lock()
last_ios_artifact = None  # {'artifact_id': int, 'repo': str, 'token': str, 'name': str}


def log_to_clients(msg, log_type='log'):
    now = time.strftime('%H:%M:%S')
    line = f'[{now}] {msg}'
    payload = json.dumps({'type': log_type, 'msg': line})
    with sse_lock:
        dead = []
        for client in sse_clients:
            try:
                client.wfile.write(f'data: {payload}\n\n'.encode('utf-8'))
                client.wfile.flush()
            except Exception:
                dead.append(client)
        for d in dead:
            sse_clients.remove(d)
    print(line)


def done_to_clients(success: bool):
    broadcast({'type': 'done', 'success': success})


def broadcast(payload_dict: dict):
    payload = json.dumps(payload_dict, ensure_ascii=False)
    with sse_lock:
        dead = []
        for client in sse_clients:
            try:
                client.wfile.write(f'data: {payload}\n\n'.encode('utf-8'))
                client.wfile.flush()
            except Exception:
                dead.append(client)
        for d in dead:
            sse_clients.remove(d)


# ── GitHub API helpers ─────────────────────────────────

GH_USER_AGENT = 'CuongNSO-VersionManager/1.0'


def _gh_request(url: str, token: str, method: str = 'GET', body: bytes = None,
                extra_headers: dict = None, follow_redirect: bool = False):
    headers = {
        'Authorization': f'Bearer {token}',
        'Accept': 'application/vnd.github+json',
        'User-Agent': GH_USER_AGENT,
        'X-GitHub-Api-Version': '2022-11-28',
    }
    if extra_headers:
        headers.update(extra_headers)
    req = urllib.request.Request(url, data=body, method=method, headers=headers)
    try:
        with urllib.request.urlopen(req, timeout=30) as resp:
            return resp.status, resp.read(), dict(resp.headers)
    except urllib.error.HTTPError as e:
        if follow_redirect and e.code in (301, 302, 307, 308):
            loc = e.headers.get('Location')
            return e.code, b'', {'Location': loc}
        return e.code, e.read() if hasattr(e, 'read') else b'', {}


def gh_get_json(url: str, token: str):
    status, body, _ = _gh_request(url, token, 'GET')
    if status >= 400:
        raise RuntimeError(f'GitHub GET {url} -> {status}: {body[:200].decode(errors="replace")}')
    return json.loads(body.decode('utf-8'))


def gh_post_json(url: str, token: str, payload: dict):
    body = json.dumps(payload).encode('utf-8')
    status, resp_body, _ = _gh_request(
        url, token, 'POST', body,
        extra_headers={'Content-Type': 'application/json'}
    )
    if status >= 400:
        raise RuntimeError(f'GitHub POST {url} -> {status}: {resp_body[:200].decode(errors="replace")}')
    return resp_body


def gh_download_artifact(repo: str, artifact_id: int, token: str, dest_path: str):
    """Download artifact zip. First API call returns 302 with redirect URL."""
    api_url = f'https://api.github.com/repos/{repo}/actions/artifacts/{artifact_id}/zip'
    # GitHub sends 302 with pre-signed URL. urllib auto-follows by default,
    # but we need to strip Authorization header for the redirect (Azure blob).
    # Easiest: disable auto-redirect via custom opener.
    class NoRedirect(urllib.request.HTTPRedirectHandler):
        def redirect_request(self, req, fp, code, msg, headers, newurl):
            return None
    opener = urllib.request.build_opener(NoRedirect)
    req = urllib.request.Request(
        api_url, method='GET',
        headers={
            'Authorization': f'Bearer {token}',
            'Accept': 'application/vnd.github+json',
            'User-Agent': GH_USER_AGENT,
            'X-GitHub-Api-Version': '2022-11-28',
        }
    )
    try:
        opener.open(req, timeout=30)
        raise RuntimeError('Expected 302 redirect from GitHub artifact API')
    except urllib.error.HTTPError as e:
        if e.code not in (301, 302, 307, 308):
            raise RuntimeError(f'Artifact API returned {e.code}')
        redirect_url = e.headers.get('Location')
        if not redirect_url:
            raise RuntimeError('No Location header in redirect')

    # Download from pre-signed URL (no auth header)
    dl_req = urllib.request.Request(redirect_url, headers={'User-Agent': GH_USER_AGENT})
    with urllib.request.urlopen(dl_req, timeout=600) as resp:
        with open(dest_path, 'wb') as f:
            shutil.copyfileobj(resp, f, length=1024 * 1024)


# ── jpackage / ICO ─────────────────────────────────────

def find_jpackage():
    for p in JPACKAGE_PATHS:
        if os.path.exists(p):
            return p
    # Try to infer from java on PATH
    java = shutil.which('java')
    if java:
        jp = os.path.join(os.path.dirname(java), 'jpackage.exe')
        if os.path.exists(jp):
            return jp
    return None


def find_ant():
    for p in ANT_PATHS:
        if os.path.exists(p):
            return p
    on_path = shutil.which('ant.bat') or shutil.which('ant')
    return on_path


def find_newest_file(dir_path: str, ext: str, excludes=None):
    excludes = [e.lower() for e in (excludes or [])]
    if not os.path.exists(dir_path):
        return None
    best = None
    best_mtime = -1
    for root, _, files in os.walk(dir_path):
        for f in files:
            if not f.endswith(ext):
                continue
            low = f.lower()
            if any(ex in low for ex in excludes):
                continue
            full = os.path.join(root, f)
            try:
                mt = os.path.getmtime(full)
            except OSError:
                continue
            if mt > best_mtime:
                best_mtime = mt
                best = full
    return best


def generate_ico_from_png(png_path: str, ico_path: str) -> bool:
    """Create multi-size .ico from a PNG using Pillow. Returns True on success."""
    if not HAS_PILLOW:
        return False
    try:
        sizes = [(256, 256), (128, 128), (64, 64), (48, 48), (32, 32), (16, 16)]
        src = Image.open(png_path).convert('RGBA')
        src.save(ico_path, format='ICO', sizes=sizes)
        return True
    except Exception as e:
        log_to_clients(f'⚠️ Không thể tạo .ico: {e}')
        return False


# ── Config helpers ─────────────────────────────────────

def read_android_version():
    with open(ANDROID_BUILD_GRADLE, 'r', encoding='utf-8') as f:
        content = f.read()
    code_m = re.search(r'versionCode\s+(\d+)', content)
    name_m = re.search(r'versionName\s+"([^"]+)"', content)
    return {
        'versionCode': int(code_m.group(1)) if code_m else 1,
        'versionName': name_m.group(1) if name_m else '1.0'
    }


def write_android_version(version_code, version_name):
    with open(ANDROID_BUILD_GRADLE, 'r', encoding='utf-8') as f:
        content = f.read()
    content = re.sub(r'versionCode\s+\d+', f'versionCode {version_code}', content)
    content = re.sub(r'versionName\s+"[^"]*"', f'versionName "{version_name}"', content)
    with open(ANDROID_BUILD_GRADLE, 'w', encoding='utf-8') as f:
        f.write(content)


def parse_server_string(s: str):
    servers = []
    if not s or not s.strip():
        return servers
    for entry in s.strip().split(','):
        entry = entry.strip()
        if not entry:
            continue
        parts = entry.split(':')
        servers.append({
            'name':      parts[0] if len(parts) > 0 else '',
            'ip':        parts[1] if len(parts) > 1 else '',
            'port':      parts[2] if len(parts) > 2 else '14444',
            'loginType': parts[3] if len(parts) > 3 else '0',
            'lang':      parts[4] if len(parts) > 4 else '0',
        })
    return servers


def build_server_string(servers: list) -> str:
    return ','.join(
        f"{s['name']}:{s['ip']}:{s['port']}:{s['loginType']}:{s['lang']}"
        for s in servers
    )


def read_server_list():
    path = os.path.join(PROJECT_ROOT, 'core', 'src', 'base', 'game1', 'GameMidlet.java')
    with open(path, 'r', encoding='utf-8') as f:
        content = f.read()
    m = re.search(r'private static String java\s*=\s*"([^"]*)"', content)
    return parse_server_string(m.group(1)) if m else []


def write_server_list(servers: list):
    server_str = build_server_string(servers)
    errors = []
    for variant in GAME_VARIANTS:
        path = os.path.join(PROJECT_ROOT, 'core', 'src', 'base', variant, 'GameMidlet.java')
        try:
            with open(path, 'r', encoding='utf-8') as f:
                content = f.read()
            content = re.sub(
                r'private static String java\s*=\s*"[^"]*"',
                f'private static String java = "{server_str}"',
                content
            )
            content = re.sub(
                r'private static String smartPhone\s*=\s*"[^"]*"',
                f'private static String smartPhone = "{server_str}"',
                content
            )
            with open(path, 'w', encoding='utf-8') as f:
                f.write(content)
        except Exception as e:
            errors.append(f'{variant}: {e}')
    return errors


# ── IP list cho Client Java (148 / 217) ────────────────

def read_java_servers(variant: str) -> list:
    """Doc danh sach server dang luu trong UpdateServer.java cua Client 148/217."""
    cfg = JAVA_CLIENT_FIELD[variant]
    with open(cfg['path'], 'r', encoding='utf-8') as f:
        text = f.read()
    m = re.search(cfg['regex'], text)
    if not m:
        return []
    raw = m.group(2)
    if cfg['encode'] == 'base64':
        try:
            raw = base64.b64decode(raw).decode('utf-8')
        except Exception:
            return []
    return parse_server_string(raw)


def write_java_servers(variant: str, servers: list) -> None:
    """Ghi danh sach server vao UpdateServer.java cua Client 148/217."""
    cfg = JAVA_CLIENT_FIELD[variant]
    raw = build_server_string(servers)
    value = raw
    if cfg['encode'] == 'base64':
        value = base64.b64encode(raw.encode('utf-8')).decode('ascii')

    with open(cfg['path'], 'r', encoding='utf-8') as f:
        text = f.read()

    def _replace(match):
        return match.group(1) + value + match.group(3)

    new_text = re.sub(cfg['regex'], _replace, text, count=1)
    with open(cfg['path'], 'w', encoding='utf-8') as f:
        f.write(new_text)


# ── Gradle build ───────────────────────────────────────

def find_output_file(task: str):
    """Find the built output file (APK or JAR) after a successful build."""
    if 'android' in task:
        # APK output directory
        apk_dir = os.path.join(PROJECT_ROOT, 'android', 'build', 'outputs', 'apk')
        candidates = []
        for root, dirs, files in os.walk(apk_dir):
            for f in files:
                if f.endswith('.apk'):
                    candidates.append(os.path.join(root, f))
        if candidates:
            # Pick the newest
            return max(candidates, key=os.path.getmtime)
    elif 'desktop' in task:
        # JAR output directory
        jar_dir = os.path.join(PROJECT_ROOT, 'desktop', 'build', 'libs')
        candidates = []
        if os.path.exists(jar_dir):
            for f in os.listdir(jar_dir):
                if f.endswith('.jar') and 'sources' not in f.lower() and 'javadoc' not in f.lower():
                    candidates.append(os.path.join(jar_dir, f))
        if candidates:
            return max(candidates, key=os.path.getmtime)
    return None


def output_to_clients(file_path: str):
    """Broadcast output file info to all SSE clients."""
    if os.path.isdir(file_path):
        size_mb = 0
        folder = file_path
        filename = os.path.basename(file_path)
    else:
        size_mb = os.path.getsize(file_path) / (1024 * 1024) if os.path.exists(file_path) else 0
        folder = os.path.dirname(file_path)
        filename = os.path.basename(file_path)
    broadcast({
        'type': 'output',
        'path': file_path,
        'folder': folder,
        'filename': filename,
        'size': f'{size_mb:.1f} MB' if size_mb else '',
    })

def run_gradle(task: str):
    global current_build_proc
    with build_lock:
        if current_build_proc and current_build_proc.poll() is None:
            log_to_clients('⚠️  Đang có tiến trình build khác đang chạy. Vui lòng chờ...')
            return

    gradlew = os.path.join(PROJECT_ROOT, 'gradlew.bat')
    log_to_clients(f'▶ Bắt đầu build: gradlew.bat {task}')
    log_to_clients(f'📁 Thư mục project: {PROJECT_ROOT}')

    def _run():
        global current_build_proc
        try:
            proc = subprocess.Popen(
                ['cmd', '/c', gradlew, task, '--build-cache', '--offline'],
                cwd=PROJECT_ROOT,
                stdout=subprocess.PIPE,
                stderr=subprocess.STDOUT,
                text=True,
                encoding='utf-8',
                errors='replace'
            )
            current_build_proc = proc
            for line in proc.stdout:
                line = line.rstrip()
                if line:
                    log_to_clients(line)
            proc.wait()
            current_build_proc = None
            if proc.returncode == 0:
                log_to_clients('✅ Build thành công!')
                # Find and broadcast output file
                out_file = find_output_file(task)
                if out_file:
                    log_to_clients(f'📦 File output: {out_file}')
                    output_to_clients(out_file)
                done_to_clients(True)
            else:
                log_to_clients(f'❌ Build thất bại! Exit code: {proc.returncode}')
                done_to_clients(False)
        except Exception as e:
            current_build_proc = None
            log_to_clients(f'❌ Lỗi: {e}')
            done_to_clients(False)

    threading.Thread(target=_run, daemon=True).start()


# ── Full Package Build (jpackage) ──────────────────────

def run_gradle_then_package(app_name: str):
    global current_build_proc
    with build_lock:
        if current_build_proc and current_build_proc.poll() is None:
            log_to_clients('⚠️  Đang có tiến trình build khác đang chạy. Vui lòng chờ...')
            return

    jpackage_exe = find_jpackage()
    if not jpackage_exe:
        log_to_clients('❌ Không tìm thấy jpackage.exe! Cần JDK 17+ để đóng gói.')
        log_to_clients('💡 Cài đặt JDK 17: https://www.oracle.com/java/technologies/downloads/')
        done_to_clients(False)
        return
    log_to_clients(f'🔧 Tìm thấy jpackage: {jpackage_exe}')

    gradlew = os.path.join(PROJECT_ROOT, 'gradlew.bat')
    log_to_clients('▶ Bước 1/2: Build JAR...')
    log_to_clients(f'📁 Thư mục project: {PROJECT_ROOT}')

    def _run():
        global current_build_proc
        try:
            proc = subprocess.Popen(
                ['cmd', '/c', gradlew, 'desktop:dist', '--build-cache'],
                cwd=PROJECT_ROOT, stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                text=True, encoding='utf-8', errors='replace'
            )
            current_build_proc = proc
            for line in proc.stdout:
                line = line.rstrip()
                if line:
                    log_to_clients(line)
            proc.wait()
            current_build_proc = None

            if proc.returncode != 0:
                log_to_clients(f'❌ Build JAR thất bại! Exit code: {proc.returncode}')
                done_to_clients(False)
                return

            log_to_clients('✅ Build JAR thành công!')

            jar_file = find_newest_file(
                os.path.join(PROJECT_ROOT, 'desktop', 'build', 'libs'),
                '.jar', ['sources', 'javadoc']
            )
            if not jar_file:
                log_to_clients('❌ Không tìm thấy file JAR sau khi build!')
                done_to_clients(False)
                return
            log_to_clients(f'📦 JAR: {jar_file}')

            version = read_android_version()
            final_name = (app_name or '').strip() or f"NSO_v{version['versionName']}"

            output_dir = os.path.join(PROJECT_ROOT, 'desktop', 'build', 'package')
            package_dir = os.path.join(output_dir, final_name)
            if os.path.exists(package_dir):
                log_to_clients(f'🗑️ Xóa package cũ: {package_dir}')
                shutil.rmtree(package_dir, ignore_errors=True)
            os.makedirs(output_dir, exist_ok=True)

            # Generate .ico
            icon_png = os.path.join(PROJECT_ROOT, 'iconapp.png')
            icon_ico = os.path.join(TOOL_DIR, '_temp_icon.ico')
            has_ico = False
            if os.path.exists(icon_png):
                log_to_clients('🖼️ Đang tạo icon .ico từ iconapp.png...')
                has_ico = generate_ico_from_png(icon_png, icon_ico)
                if has_ico:
                    log_to_clients('✅ Đã tạo icon .ico')

            jp_args = [
                jpackage_exe,
                '--type', 'app-image',
                '--name', final_name,
                '--input', os.path.dirname(jar_file),
                '--main-jar', os.path.basename(jar_file),
                '--main-class', 'com.monkey.nso.DesktopLauncher',
                '--dest', output_dir,
                '--app-version', version['versionName'] or '1.0',
            ]
            if has_ico:
                jp_args.extend(['--icon', icon_ico])

            log_to_clients('▶ Bước 2/2: Đóng gói (jpackage)...')
            log_to_clients(f'🚀 Chạy jpackage: {final_name}')

            proc2 = subprocess.Popen(
                jp_args, cwd=PROJECT_ROOT,
                stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                text=True, encoding='utf-8', errors='replace'
            )
            current_build_proc = proc2
            for line in proc2.stdout:
                line = line.rstrip()
                if line:
                    log_to_clients(line)
            proc2.wait()
            current_build_proc = None

            try:
                if os.path.exists(icon_ico):
                    os.unlink(icon_ico)
            except Exception:
                pass

            if proc2.returncode != 0:
                log_to_clients(f'❌ Đóng gói thất bại! Exit code: {proc2.returncode}')
                done_to_clients(False)
                return

            log_to_clients('✅ Đóng gói thành công!')

            if os.path.exists(package_dir):
                exe_file = os.path.join(package_dir, f'{final_name}.exe')
                if os.path.exists(exe_file):
                    exe_size = os.path.getsize(exe_file) / 1024
                    log_to_clients(f'📦 File EXE: {exe_file} ({exe_size:.0f} KB)')
                file_count = sum(len(files) for _, _, files in os.walk(package_dir))
                log_to_clients(f'📂 Thư mục output: {package_dir}')
                log_to_clients(f'📊 Tổng cộng {file_count} file')
                output_to_clients(package_dir)
            else:
                output_to_clients(output_dir)

            done_to_clients(True)
        except Exception as e:
            current_build_proc = None
            log_to_clients(f'❌ Lỗi: {e}')
            done_to_clients(False)

    threading.Thread(target=_run, daemon=True).start()


# ── iOS GitHub Actions Build ───────────────────────────

def poll_run_status(repo: str, run_id: int, token: str, run_url: str):
    """Poll GitHub Actions run status every 10s in background thread."""
    def _poll():
        global last_ios_artifact
        last_status = ''
        while True:
            time.sleep(10)
            try:
                run = gh_get_json(
                    f'https://api.github.com/repos/{repo}/actions/runs/{run_id}', token
                )
                status = run.get('status')
                conclusion = run.get('conclusion')

                if status != last_status:
                    last_status = status
                    if status == 'completed':
                        text = '✅ Thành công!' if conclusion == 'success' else f'❌ {conclusion}'
                    elif status == 'in_progress':
                        text = '⚙️ Đang build...'
                    else:
                        text = '⏳ Đang chờ...'
                    log_to_clients(f'🍎 iOS Build: {text}')
                    broadcast({'type': 'ios_status', 'status': status,
                               'conclusion': conclusion, 'runUrl': run_url})

                if status == 'completed':
                    success = conclusion == 'success'
                    if success:
                        try:
                            art_data = gh_get_json(
                                f'https://api.github.com/repos/{repo}/actions/runs/{run_id}/artifacts',
                                token
                            )
                            arts = art_data.get('artifacts') or []
                            if arts:
                                art = arts[0]
                                size_kb = art['size_in_bytes'] / 1024
                                log_to_clients(f'📦 Artifact: {art["name"]} ({size_kb:.0f} KB)')
                                log_to_clients('⬇️ Nhấn "Tải về máy" trong UI để tải artifact!')
                                last_ios_artifact = {
                                    'artifact_id': art['id'], 'repo': repo,
                                    'token': token, 'name': art['name']
                                }
                                broadcast({
                                    'type': 'ios_artifact',
                                    'name': art['name'],
                                    'size': f'{size_kb:.0f} KB',
                                    'runUrl': run_url,
                                    'artifactId': art['id'],
                                })
                        except Exception:
                            pass
                        log_to_clients('✅ iOS Build hoàn tất!')
                    else:
                        log_to_clients(f'❌ iOS Build thất bại: {conclusion}')
                        log_to_clients(f'🔗 Log: {run_url}')
                    done_to_clients(success)
                    return
            except Exception:
                continue  # transient errors, retry

    threading.Thread(target=_poll, daemon=True).start()


def trigger_ios_build(token: str, repo: str, branch: str):
    """Push code (which triggers workflow via `on: push`) + poll. Runs in background thread."""
    def _run():
        log_to_clients('🍎 ===== Bắt đầu Build iOS =====')

        # Step 1: git push — đây là trigger DUY NHẤT cho workflow.
        # Không gọi workflow_dispatch song song vì build-ios.yml có
        # `concurrency.cancel-in-progress: true` — 2 trigger sẽ huỷ lẫn nhau.
        log_to_clients('📤 Bước 1/2: Đồng bộ code lên GitHub...')
        remote_url = f'https://cuongcxz1010-hue:{token}@github.com/{repo}.git'
        local_branch = 'fresh-main'
        trigger_time_ms = int(time.time() * 1000)

        try:
            subprocess.run(
                [GIT_EXE, '-C', PROJECT_ROOT, 'add', '-A'],
                check=False, capture_output=True
            )
            subprocess.run(
                [GIT_EXE, '-C', PROJECT_ROOT, 'commit', '--allow-empty',
                 '-m', f'[iOS Build] {datetime.utcnow().isoformat()}Z'],
                check=False, capture_output=True
            )
            log_to_clients('✅ Tạo commit')
        except Exception as e:
            log_to_clients(f'⚠️ Commit: {e}')

        try:
            push = subprocess.run(
                [GIT_EXE, '-C', PROJECT_ROOT, 'push', remote_url, f'{local_branch}:{branch}'],
                capture_output=True, text=True, encoding='utf-8', errors='replace'
            )
            if push.returncode == 0:
                log_to_clients('✅ Push code thành công!')
            else:
                log_to_clients(f'⚠️ Push exit code: {push.returncode}')
                if push.stderr:
                    log_to_clients(push.stderr.strip()[:500])
        except Exception as e:
            log_to_clients(f'⚠️ Push lỗi: {e}')

        # Step 2: Poll for new run
        log_to_clients('⏳ Bước 2/2: Đang chờ GitHub Actions khởi động...')
        max_wait_ms = 3 * 60 * 1000
        start = time.time() * 1000
        while True:
            time.sleep(5)
            elapsed = time.time() * 1000 - start
            try:
                data = gh_get_json(
                    f'https://api.github.com/repos/{repo}/actions/runs?branch={branch}&per_page=5',
                    token
                )
                runs = data.get('workflow_runs') or []
                cutoff = trigger_time_ms - 10_000
                chosen = None
                for r in runs:
                    created = int(datetime.fromisoformat(
                        r['created_at'].replace('Z', '+00:00')
                    ).timestamp() * 1000)
                    if created >= cutoff:
                        chosen = r
                        break
                if chosen:
                    run_id = chosen['id']
                    run_url = chosen['html_url']
                    log_to_clients(f'✅ Run #{chosen["run_number"]} đã khởi động!')
                    log_to_clients(f'🔗 Link: {run_url}')
                    broadcast({'type': 'ios_run', 'runId': run_id,
                               'runUrl': run_url, 'repo': repo})
                    poll_run_status(repo, run_id, token, run_url)
                    return
                if elapsed > max_wait_ms:
                    if runs:
                        r = runs[0]
                        log_to_clients(f'⚠️ Dùng run gần nhất: #{r["run_number"]}')
                        broadcast({'type': 'ios_run', 'runId': r['id'],
                                   'runUrl': r['html_url'], 'repo': repo})
                        poll_run_status(repo, r['id'], token, r['html_url'])
                    else:
                        log_to_clients('❌ Không tìm thấy run. Kiểm tra GitHub Actions tab.')
                        done_to_clients(False)
                    return
            except Exception:
                continue

    threading.Thread(target=_run, daemon=True).start()


def download_ios_artifact():
    """Download the last iOS artifact zip. Runs in background thread."""
    global last_ios_artifact
    if not last_ios_artifact:
        return False, 'Chưa có artifact nào. Hãy build iOS trước!'

    art = last_ios_artifact
    output_dir = os.path.join(PROJECT_ROOT, 'desktop', 'build', 'ios-output')
    os.makedirs(output_dir, exist_ok=True)
    zip_path = os.path.join(output_dir, f"{art['name']}.zip")

    def _run():
        try:
            log_to_clients(f'⬇️ Bắt đầu tải: {art["name"]}...')
            gh_download_artifact(art['repo'], art['artifact_id'], art['token'], zip_path)
            size_mb = os.path.getsize(zip_path) / (1024 * 1024)
            log_to_clients(f'✅ Tải xong! File: {zip_path} ({size_mb:.1f} MB)')
            log_to_clients('📂 Mở thư mục để lấy file ZIP...')
            broadcast({
                'type': 'ios_downloaded',
                'path': zip_path, 'folder': output_dir,
                'size': f'{size_mb:.1f} MB',
            })
            try:
                subprocess.Popen(['explorer', output_dir])
            except Exception:
                pass
        except Exception as e:
            log_to_clients(f'❌ Tải thất bại: {e}')
            broadcast({'type': 'ios_download_error', 'error': str(e)})

    threading.Thread(target=_run, daemon=True).start()
    return True, 'Đang tải artifact về máy...'


# ── Java MIDlet client build (Ant + ProGuard) ──────────

def build_java_client(variant: str):
    """Build + encrypt a Java MIDlet client variant ('148' or '217')."""
    global current_build_proc

    cfg = JAVA_CLIENTS.get(variant)
    if not cfg:
        log_to_clients(f'❌ Client không hợp lệ: {variant}')
        done_to_clients(False)
        return

    with build_lock:
        if current_build_proc and current_build_proc.poll() is None:
            log_to_clients('⚠️  Đang có tiến trình build khác đang chạy. Vui lòng chờ...')
            return

    if not os.path.isdir(cfg['dir']):
        log_to_clients(f'❌ Không thấy thư mục: {cfg["dir"]}')
        done_to_clients(False)
        return

    ant_exe = find_ant()
    if not ant_exe:
        log_to_clients('❌ Không tìm thấy ant.bat! Cần NetBeans hoặc Apache Ant.')
        log_to_clients('💡 Cài NetBeans tại: https://netbeans.apache.org/')
        done_to_clients(False)
        return

    log_to_clients(f'🔧 Ant: {ant_exe}')
    log_to_clients(f'▶ Bắt đầu build {cfg["name"]}')
    log_to_clients(f'📁 Thư mục: {cfg["dir"]}')

    def _run():
        global current_build_proc
        try:
            # Step 1: run Ant (clean + jar)
            ant_args = ['cmd', '/c', ant_exe, 'clean']
            if cfg['ant_target']:
                ant_args.append(cfg['ant_target'])
            log_to_clients(f'▶ Bước 1: {" ".join(ant_args[2:])}')
            proc = subprocess.Popen(
                ant_args, cwd=cfg['dir'],
                stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                text=True, encoding='utf-8', errors='replace'
            )
            current_build_proc = proc
            for line in proc.stdout:
                line = line.rstrip()
                if line:
                    log_to_clients(line)
            proc.wait()
            if proc.returncode != 0:
                current_build_proc = None
                log_to_clients(f'❌ Ant clean thất bại! Exit code: {proc.returncode}')
                done_to_clients(False)
                return

            ant_args2 = ['cmd', '/c', ant_exe]
            if cfg['ant_target']:
                ant_args2.append(cfg['ant_target'])
            log_to_clients(f'▶ Bước 2: {" ".join(ant_args2[2:]) or "(default)"}')
            proc = subprocess.Popen(
                ant_args2, cwd=cfg['dir'],
                stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                text=True, encoding='utf-8', errors='replace'
            )
            current_build_proc = proc
            for line in proc.stdout:
                line = line.rstrip()
                if line:
                    log_to_clients(line)
            proc.wait()
            current_build_proc = None
            if proc.returncode != 0:
                log_to_clients(f'❌ Ant build thất bại! Exit code: {proc.returncode}')
                done_to_clients(False)
                return

            log_to_clients('✅ Ant build thành công!')

            # Step 3: ProGuard (only if client needs external obfuscation)
            if cfg['proguard_jar']:
                if not os.path.exists(cfg['proguard_jar']):
                    log_to_clients(f'❌ Không thấy {cfg["proguard_jar"]}')
                    done_to_clients(False)
                    return
                log_to_clients('▶ Bước 3: Mã hoá với ProGuard...')
                # Run java -jar directly (skip .bat's `pause` that hangs Popen)
                proc = subprocess.Popen(
                    ['java', '-jar', cfg['proguard_jar'], '@' + cfg['proguard_pro']],
                    cwd=cfg['dir'],
                    stdout=subprocess.PIPE, stderr=subprocess.STDOUT,
                    text=True, encoding='utf-8', errors='replace'
                )
                current_build_proc = proc
                for line in proc.stdout:
                    line = line.rstrip()
                    if line:
                        log_to_clients(line)
                proc.wait()
                current_build_proc = None
                if proc.returncode != 0:
                    log_to_clients(f'❌ ProGuard thất bại! Exit code: {proc.returncode}')
                    done_to_clients(False)
                    return
                log_to_clients('✅ Mã hoá thành công!')

            # Report output
            out = cfg['obf_jar']
            if os.path.exists(out):
                size_kb = os.path.getsize(out) / 1024
                log_to_clients(f'📦 File đã mã hoá: {out} ({size_kb:.0f} KB)')
                output_to_clients(out)
            else:
                log_to_clients(f'⚠️ Không thấy file output: {out}')

            done_to_clients(True)
        except Exception as e:
            current_build_proc = None
            log_to_clients(f'❌ Lỗi: {e}')
            done_to_clients(False)

    threading.Thread(target=_run, daemon=True).start()


# ── Logo Management ────────────────────────────────────

# Tất cả các file icon cần thay thế: (relative_path, (width, height))
LOGO_TARGETS = [
    # Desktop
    ('iconapp.png',                                           (256, 256)),
    # Runtime assets (loaded by game)
    ('assets/iconapp.png',                                    (256,  256)),
    ('assets/Nso/iconapp.png',                                (1024, 1024)),
    ('assets/Nso/icon.png',                                   (16,   16)),
    # Client VIP source icons
    ('Client148+20Vvhip/src/icon.png',                        (32,   32)),
    ('CLient217VIP/src/icon.png',                             (32,   32)),
    ('CLient217VIP/bak/src0/icon.png',                        (32,   32)),
    # Android Playstore
    ('android/ic_launcher-playstore.png',                     (1024, 1024)),
    # Mipmap - regular
    ('android/res/mipmap-mdpi/ic_launcher.png',               (48,  48)),
    ('android/res/mipmap-hdpi/ic_launcher.png',               (72,  72)),
    ('android/res/mipmap-xhdpi/ic_launcher.png',              (96,  96)),
    ('android/res/mipmap-xxhdpi/ic_launcher.png',             (144, 144)),
    ('android/res/mipmap-xxxhdpi/ic_launcher.png',            (192, 192)),
    # Mipmap - round
    ('android/res/mipmap-mdpi/ic_launcher_round.png',         (48,  48)),
    ('android/res/mipmap-hdpi/ic_launcher_round.png',         (72,  72)),
    ('android/res/mipmap-xhdpi/ic_launcher_round.png',        (96,  96)),
    ('android/res/mipmap-xxhdpi/ic_launcher_round.png',       (144, 144)),
    ('android/res/mipmap-xxxhdpi/ic_launcher_round.png',      (192, 192)),
    # iOS AppIcon.appiconset
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-notification-icon-20@2x.png',        (40,   40)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-notification-icon-20@3x.png',        (60,   60)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-spotlight-settings-icon-29@2x.png',  (58,   58)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-spotlight-settings-icon-29@3x.png',  (87,   87)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-spotlight-icon-40@2x.png',           (80,   80)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-spotlight-icon-40@3x.png',           (120,  120)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-app-icon-60@2x.png',                 (120,  120)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/iphone-app-icon-60@3x.png',                 (180,  180)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-notifications-icon-20@1x.png',         (20,   20)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-notifications-icon-20@2x.png',         (40,   40)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-settings-icon-29@1x.png',              (29,   29)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-settings-icon-29@2x.png',              (58,   58)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-spotlight-icon-40@1x.png',             (40,   40)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-spotlight-icon-40@2x.png',             (80,   80)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-app-icon-76@1x.png',                   (76,   76)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-app-icon-76@2x.png',                   (152,  152)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/ipad-pro-app-icon-83.5@2x.png',             (167,  167)),
    ('ios/data/Media.xcassets/AppIcon.appiconset/app-store-icon-1024@1x.png',                (1024, 1024)),
]


def get_logo_preview():
    """Return base64-encoded current iconapp.png (or None)."""
    path = os.path.join(PROJECT_ROOT, 'iconapp.png')
    if not os.path.exists(path):
        return None
    with open(path, 'rb') as f:
        data = f.read()
    return base64.b64encode(data).decode('utf-8')


def apply_logo(image_b64: str):
    """Resize and copy image to all logo targets. Returns (replaced, errors)."""
    if not HAS_PILLOW:
        return [], ['Thiếu thư viện Pillow. Chạy: pip install Pillow']

    try:
        raw = base64.b64decode(image_b64)
        src_img = Image.open(io.BytesIO(raw)).convert('RGBA')
    except Exception as e:
        return [], [f'Không thể đọc ảnh: {e}']

    replaced = []
    errors = []
    for rel_path, (w, h) in LOGO_TARGETS:
        abs_path = os.path.join(PROJECT_ROOT, rel_path.replace('/', os.sep))
        try:
            resized = src_img.resize((w, h), Image.LANCZOS)
            # Convert to RGBA then save as PNG
            os.makedirs(os.path.dirname(abs_path), exist_ok=True)
            resized.save(abs_path, 'PNG')
            replaced.append(rel_path)
        except Exception as e:
            errors.append(f'{rel_path}: {e}')
    return replaced, errors


# ── HTTP Handler ───────────────────────────────────────

STATIC_FILES = {
    '/':           ('index.html', 'text/html; charset=utf-8'),
    '/index.html': ('index.html', 'text/html; charset=utf-8'),
    '/style.css':  ('style.css',  'text/css; charset=utf-8'),
    '/app.js':     ('app.js',     'application/javascript; charset=utf-8'),
}


class Handler(BaseHTTPRequestHandler):
    def log_message(self, fmt, *args):
        pass  # Silence default access log

    def _cors(self):
        self.send_header('Access-Control-Allow-Origin', '*')
        self.send_header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS')
        self.send_header('Access-Control-Allow-Headers', 'Content-Type')

    def do_OPTIONS(self):
        self.send_response(204)
        self._cors()
        self.end_headers()

    def _json(self, data: dict, status=200):
        body = json.dumps(data, ensure_ascii=False).encode('utf-8')
        self.send_response(status)
        self._cors()
        self.send_header('Content-Type', 'application/json; charset=utf-8')
        self.send_header('Content-Length', str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def _read_body(self):
        length = int(self.headers.get('Content-Length', 0))
        if length == 0:
            return {}
        raw = self.rfile.read(length).decode('utf-8')
        try:
            return json.loads(raw)
        except Exception:
            return {}

    def do_GET(self):
        path = urlparse(self.path).path

        # SSE stream
        if path == '/api/build/stream':
            self.send_response(200)
            self._cors()
            self.send_header('Content-Type', 'text/event-stream')
            self.send_header('Cache-Control', 'no-cache')
            self.send_header('X-Accel-Buffering', 'no')
            self.send_header('Connection', 'keep-alive')
            self.end_headers()
            self.wfile.write(b': connected\n\n')
            self.wfile.flush()
            with sse_lock:
                sse_clients.append(self)
            # Keep open until client disconnects
            try:
                while True:
                    time.sleep(15)
                    self.wfile.write(b': ping\n\n')
                    self.wfile.flush()
            except Exception:
                with sse_lock:
                    if self in sse_clients:
                        sse_clients.remove(self)
            return

        # GET /api/config
        if path == '/api/config':
            try:
                version = read_android_version()
                servers = read_server_list()
                self._json({'success': True, 'version': version, 'servers': servers})
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # GET /api/logo/preview
        if path == '/api/logo/preview':
            try:
                b64 = get_logo_preview()
                self._json({'success': True, 'image': b64, 'hasPillow': HAS_PILLOW})
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # GET /api/java-servers?variant=148|217
        if path == '/api/java-servers':
            try:
                q = urlparse(self.path).query
                variant = ''
                for pair in q.split('&'):
                    if pair.startswith('variant='):
                        variant = pair.split('=', 1)[1]
                        break
                if variant not in JAVA_CLIENT_FIELD:
                    self._json({'success': False, 'error': 'variant phai la 148 hoac 217'}, 400)
                    return
                servers = read_java_servers(variant)
                self._json({'success': True, 'servers': servers})
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # GET /api/ios-settings
        if path == '/api/ios-settings':
            try:
                if os.path.exists(IOS_SETTINGS_PATH):
                    with open(IOS_SETTINGS_PATH, 'r', encoding='utf-8') as f:
                        data = json.load(f)
                    self._json(data)
                else:
                    self._json({})
            except Exception:
                self._json({})
            return

        # Static files
        if path in STATIC_FILES:
            fname, ctype = STATIC_FILES[path]
            fpath = os.path.join(TOOL_DIR, fname)
            try:
                with open(fpath, 'rb') as f:
                    data = f.read()
                self.send_response(200)
                self._cors()
                self.send_header('Content-Type', ctype)
                self.send_header('Content-Length', str(len(data)))
                self.end_headers()
                self.wfile.write(data)
            except Exception:
                self.send_response(404)
                self.end_headers()
            return

        self.send_response(404)
        self.end_headers()

    def do_POST(self):
        path = urlparse(self.path).path

        # POST /api/config
        if path == '/api/config':
            try:
                body = self._read_body()
                if 'version' in body:
                    v = body['version']
                    write_android_version(v.get('versionCode', 1), v.get('versionName', '1.0'))
                srv_errors = []
                if 'servers' in body:
                    srv_errors = write_server_list(body['servers'])
                msg = 'Đã lưu thành công!' if not srv_errors else f"Có lỗi: {'; '.join(srv_errors)}"
                self._json({'success': True, 'serverErrors': srv_errors, 'message': msg})
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # POST /api/build/apk
        if path == '/api/build/apk':
            self._json({'success': True, 'message': 'Đang build APK...'})
            run_gradle('android:assembleDebug')
            return

        # POST /api/build/pc
        if path == '/api/build/pc':
            self._json({'success': True, 'message': 'Đang build Desktop (PC)...'})
            run_gradle('desktop:dist')
            return

        # POST /api/java-servers  { variant: '148'|'217', servers: [...] }
        if path == '/api/java-servers':
            try:
                body = self._read_body()
                variant = str(body.get('variant') or '').strip()
                if variant not in JAVA_CLIENT_FIELD:
                    self._json({'success': False, 'error': 'variant phai la 148 hoac 217'}, 400)
                    return
                servers = body.get('servers') or []
                write_java_servers(variant, servers)
                self._json({'success': True, 'message': 'Da luu IP list!'})
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # POST /api/build/java-client  { variant: '148' | '217' }
        if path == '/api/build/java-client':
            try:
                body = self._read_body()
                variant = str(body.get('variant') or '').strip()
                if variant not in JAVA_CLIENTS:
                    self._json({'success': False, 'error': f'variant phải là 148 hoặc 217'}, 400)
                    return
                self._json({'success': True, 'message': f'Đang build Client {variant} VIP...'})
                build_java_client(variant)
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # POST /api/build/pc-full
        if path == '/api/build/pc-full':
            try:
                body = self._read_body()
                app_name = (body.get('appName') or '').strip()
                self._json({'success': True, 'message': 'Đang build phiên bản hoàn chỉnh...'})
                run_gradle_then_package(app_name)
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # POST /api/ios-settings
        if path == '/api/ios-settings':
            try:
                body = self._read_body()
                with open(IOS_SETTINGS_PATH, 'w', encoding='utf-8') as f:
                    json.dump(body, f, indent=2, ensure_ascii=False)
                self._json({'success': True})
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # POST /api/build/ios
        if path == '/api/build/ios':
            try:
                body = self._read_body()
                settings = {}
                if os.path.exists(IOS_SETTINGS_PATH):
                    try:
                        with open(IOS_SETTINGS_PATH, 'r', encoding='utf-8') as f:
                            settings = json.load(f)
                    except Exception:
                        settings = {}
                token = body.get('token') or settings.get('token') or ''
                repo = body.get('repo') or settings.get('repo') or ''
                branch = body.get('branch') or settings.get('branch') or 'main'

                if not token or not repo:
                    self._json({'success': False, 'error': 'Cần nhập GitHub Token và Repository!'}, 400)
                    return

                self._json({'success': True, 'message': 'Đang trigger iOS build...'})
                trigger_ios_build(token, repo, branch)
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # POST /api/build/ios-download
        if path == '/api/build/ios-download':
            ok, msg = download_ios_artifact()
            self._json({'success': ok, 'message' if ok else 'error': msg}, 200 if ok else 400)
            return

        # POST /api/build/stop
        if path == '/api/build/stop':
            global current_build_proc
            p = current_build_proc
            if p and p.poll() is None:
                p.terminate()
                current_build_proc = None
                log_to_clients('🛑 Đã dừng build.')
            self._json({'success': True})
            return

        # POST /api/open-folder - open Windows Explorer to output folder
        if path == '/api/open-folder':
            try:
                body = self._read_body()
                folder = body.get('folder', '')
                if folder and os.path.exists(folder):
                    subprocess.Popen(['explorer', folder])
                    self._json({'success': True})
                else:
                    self._json({'success': False, 'error': 'Folder not found'}, 404)
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        # POST /api/logo/apply
        if path == '/api/logo/apply':
            try:
                body = self._read_body()
                image_b64 = body.get('image', '')
                if not image_b64:
                    self._json({'success': False, 'error': 'Không có dữ liệu ảnh'}, 400)
                    return
                replaced, errors = apply_logo(image_b64)
                msg = f'Đã cập nhật {len(replaced)} file icon!'
                self._json({'success': len(errors) == 0 or len(replaced) > 0,
                            'replaced': replaced, 'errors': errors, 'message': msg})
            except Exception as e:
                self._json({'success': False, 'error': str(e)}, 500)
            return

        self.send_response(404)
        self.end_headers()



# ── Main ───────────────────────────────────────────────

def start_server():
    """Start the HTTP server (blocking). Used by launch.py via thread."""
    server = ThreadingHTTPServer(('127.0.0.1', PORT), Handler)
    print(f'[*] CuongNSO Version Manager dang chay tai: http://localhost:{PORT}')
    print(f'[*] Project root: {PROJECT_ROOT}')
    server.serve_forever()


if __name__ == '__main__':
    try:
        print('[*] Nhan Ctrl+C de dung server.\n')
        start_server()
    except KeyboardInterrupt:
        print('\n[*] Server da dung.')

