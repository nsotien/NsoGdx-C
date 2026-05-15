/**
 * CuongNSO Version Manager - Node.js Backend Server
 * Runs on http://localhost:3399
 * Requirements: Node.js 14+, sharp
 */

const http = require('http');
const fs = require('fs');
const path = require('path');
const { spawn, exec } = require('child_process');
const url = require('url');

let sharp;
try {
    sharp = require('sharp');
} catch (e) {
    sharp = null;
    console.warn('[WARN] sharp not installed. Logo resize will be disabled.');
}

// ── Config ─────────────────────────────────────────────
const PORT = 3399;
const PROJECT_ROOT = path.resolve(__dirname, '..', '..');
const ANDROID_BUILD_GRADLE = path.join(PROJECT_ROOT, 'android', 'build.gradle');
const GAME_VARIANTS = ['game1', 'game2', 'game3', 'game4', 'game5', 'game6'];
const TOOL_DIR = __dirname;
const JPACKAGE_PATHS = [
    'C:\\Program Files\\Java\\jdk-17\\bin\\jpackage.exe',
    'C:\\Program Files\\Java\\jdk-21\\bin\\jpackage.exe',
    'C:\\Program Files\\Java\\jdk-20\\bin\\jpackage.exe',
    'C:\\Program Files\\Java\\jdk-19\\bin\\jpackage.exe',
    'C:\\Program Files\\Java\\jdk-18\\bin\\jpackage.exe',
];

// ── SSE clients ────────────────────────────────────────
const sseClients = [];
let currentBuildProc = null;

// ── Static files ───────────────────────────────────────
const STATIC_FILES = {
    '/': { file: 'index.html', type: 'text/html; charset=utf-8' },
    '/index.html': { file: 'index.html', type: 'text/html; charset=utf-8' },
    '/style.css': { file: 'style.css', type: 'text/css; charset=utf-8' },
    '/app.js': { file: 'app.js', type: 'application/javascript; charset=utf-8' },
};

// ── Utility: Send SSE event to all clients ─────────────
function logToClients(msg, logType = 'log') {
    const now = new Date().toLocaleTimeString('vi-VN', { hour12: false });
    const line = `[${now}] ${msg}`;
    const payload = JSON.stringify({ type: logType, msg: line });
    broadcast(payload);
    console.log(line);
}

function doneToClients(success) {
    const payload = JSON.stringify({ type: 'done', success });
    broadcast(payload);
}

function outputToClients(filePath) {
    try {
        const stats = fs.statSync(filePath);
        const sizeMb = (stats.size / (1024 * 1024)).toFixed(1);
        const folder = path.dirname(filePath);
        const filename = path.basename(filePath);
        const payload = JSON.stringify({
            type: 'output',
            path: filePath,
            folder,
            filename,
            size: `${sizeMb} MB`,
        });
        broadcast(payload);
    } catch (e) {
        // ignore
    }
}

function broadcast(payload) {
    const dead = [];
    for (let i = 0; i < sseClients.length; i++) {
        try {
            sseClients[i].write(`data: ${payload}\n\n`);
        } catch (e) {
            dead.push(i);
        }
    }
    // Remove dead clients (reverse order)
    for (let i = dead.length - 1; i >= 0; i--) {
        sseClients.splice(dead[i], 1);
    }
}

// ── Config helpers ─────────────────────────────────────
function readAndroidVersion() {
    const content = fs.readFileSync(ANDROID_BUILD_GRADLE, 'utf-8');
    const codeMatch = content.match(/versionCode\s+(\d+)/);
    const nameMatch = content.match(/versionName\s+"([^"]+)"/);
    return {
        versionCode: codeMatch ? parseInt(codeMatch[1]) : 1,
        versionName: nameMatch ? nameMatch[1] : '1.0',
    };
}

function writeAndroidVersion(versionCode, versionName) {
    let content = fs.readFileSync(ANDROID_BUILD_GRADLE, 'utf-8');
    content = content.replace(/versionCode\s+\d+/, `versionCode ${versionCode}`);
    content = content.replace(/versionName\s+"[^"]*"/, `versionName "${versionName}"`);
    fs.writeFileSync(ANDROID_BUILD_GRADLE, content, 'utf-8');
}

function parseServerString(s) {
    const servers = [];
    if (!s || !s.trim()) return servers;
    for (const entry of s.trim().split(',')) {
        const trimmed = entry.trim();
        if (!trimmed) continue;
        const parts = trimmed.split(':');
        servers.push({
            name: parts[0] || '',
            ip: parts[1] || '',
            port: parts[2] || '14444',
            loginType: parts[3] || '0',
            lang: parts[4] || '0',
        });
    }
    return servers;
}

function buildServerString(servers) {
    return servers.map(s => `${s.name}:${s.ip}:${s.port}:${s.loginType}:${s.lang}`).join(',');
}

function readServerList() {
    const filePath = path.join(PROJECT_ROOT, 'core', 'src', 'base', 'game1', 'GameMidlet.java');
    const content = fs.readFileSync(filePath, 'utf-8');
    const m = content.match(/private static String java\s*=\s*"([^"]*)"/);
    return m ? parseServerString(m[1]) : [];
}

function writeServerList(servers) {
    const serverStr = buildServerString(servers);
    const errors = [];
    for (const variant of GAME_VARIANTS) {
        const filePath = path.join(PROJECT_ROOT, 'core', 'src', 'base', variant, 'GameMidlet.java');
        try {
            let content = fs.readFileSync(filePath, 'utf-8');
            content = content.replace(
                /private static String java\s*=\s*"[^"]*"/,
                `private static String java = "${serverStr}"`
            );
            content = content.replace(
                /private static String smartPhone\s*=\s*"[^"]*"/,
                `private static String smartPhone = "${serverStr}"`
            );
            fs.writeFileSync(filePath, content, 'utf-8');
        } catch (e) {
            errors.push(`${variant}: ${e.message}`);
        }
    }
    return errors;
}

// ── Gradle Build ───────────────────────────────────────
function findOutputFile(task) {
    try {
        if (task.includes('android')) {
            const apkDir = path.join(PROJECT_ROOT, 'android', 'build', 'outputs', 'apk');
            return findNewestFile(apkDir, '.apk');
        } else if (task.includes('desktop')) {
            const jarDir = path.join(PROJECT_ROOT, 'desktop', 'build', 'libs');
            return findNewestFile(jarDir, '.jar', ['sources', 'javadoc']);
        }
    } catch (e) {
        // ignore
    }
    return null;
}

function findNewestFile(dir, ext, excludePatterns = []) {
    if (!fs.existsSync(dir)) return null;
    const candidates = [];
    walkDir(dir, (filePath) => {
        if (!filePath.endsWith(ext)) return;
        const lower = filePath.toLowerCase();
        for (const pat of excludePatterns) {
            if (lower.includes(pat)) return;
        }
        candidates.push(filePath);
    });
    if (candidates.length === 0) return null;
    return candidates.reduce((newest, f) => {
        return fs.statSync(f).mtimeMs > fs.statSync(newest).mtimeMs ? f : newest;
    });
}

function walkDir(dir, callback) {
    try {
        const entries = fs.readdirSync(dir, { withFileTypes: true });
        for (const entry of entries) {
            const fullPath = path.join(dir, entry.name);
            if (entry.isDirectory()) {
                walkDir(fullPath, callback);
            } else {
                callback(fullPath);
            }
        }
    } catch (e) {
        // ignore permission errors etc.
    }
}

function findJpackage() {
    for (const p of JPACKAGE_PATHS) {
        if (fs.existsSync(p)) return p;
    }
    // Try to find it dynamically
    try {
        const javaPath = require('child_process').execSync('where java', { encoding: 'utf-8' }).trim().split('\n')[0].trim();
        // Navigate from java.exe to jpackage.exe in same JDK
        const binDir = path.dirname(javaPath);
        const jpackagePath = path.join(binDir, 'jpackage.exe');
        if (fs.existsSync(jpackagePath)) return jpackagePath;
    } catch (e) { }
    return null;
}

function spawnProcess(cmd, args, cwd) {
    return new Promise((resolve, reject) => {
        const proc = spawn(cmd, args, {
            cwd,
            stdio: ['ignore', 'pipe', 'pipe'],
        });

        currentBuildProc = proc;

        let stdoutBuf = '';
        proc.stdout.on('data', (data) => {
            stdoutBuf += data.toString('utf-8');
            const lines = stdoutBuf.split(/\r?\n/);
            stdoutBuf = lines.pop();
            for (const line of lines) {
                if (line.trim()) logToClients(line);
            }
        });

        let stderrBuf = '';
        proc.stderr.on('data', (data) => {
            stderrBuf += data.toString('utf-8');
            const lines = stderrBuf.split(/\r?\n/);
            stderrBuf = lines.pop();
            for (const line of lines) {
                if (line.trim()) logToClients(line);
            }
        });

        proc.on('close', (code) => {
            currentBuildProc = null;
            if (stdoutBuf.trim()) logToClients(stdoutBuf);
            if (stderrBuf.trim()) logToClients(stderrBuf);
            resolve(code);
        });

        proc.on('error', (err) => {
            currentBuildProc = null;
            reject(err);
        });
    });
}

// ── GitHub API Helper ──────────────────────────────────
function httpGet(apiUrl, token) {
    return new Promise((resolve, reject) => {
        const https = require('https');
        const parsed = new URL(apiUrl);
        const options = {
            hostname: parsed.hostname,
            path: parsed.pathname + parsed.search,
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Accept': 'application/vnd.github+json',
                'User-Agent': 'CuongNSO-VersionManager/1.0',
                'X-GitHub-Api-Version': '2022-11-28',
            },
        };
        const req = https.request(options, (res) => {
            let data = '';
            res.on('data', (chunk) => data += chunk);
            res.on('end', () => resolve(data));
        });
        req.on('error', reject);
        req.setTimeout(15000, () => { req.destroy(); reject(new Error('Timeout')); });
        req.end();
    });
}

function httpPost(apiUrl, token, bodyStr) {
    return new Promise((resolve, reject) => {
        const https = require('https');
        const parsed = new URL(apiUrl);
        const bodyBuf = Buffer.from(bodyStr || '', 'utf-8');
        const options = {
            hostname: parsed.hostname,
            path: parsed.pathname + parsed.search,
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Accept': 'application/vnd.github+json',
                'User-Agent': 'CuongNSO-VersionManager/1.0',
                'X-GitHub-Api-Version': '2022-11-28',
                'Content-Type': 'application/json',
                'Content-Length': bodyBuf.length,
            },
        };
        const req = https.request(options, (res) => {
            let data = '';
            res.on('data', (chunk) => data += chunk);
            res.on('end', () => {
                if (res.statusCode >= 200 && res.statusCode < 300) {
                    resolve(data);
                } else {
                    reject(new Error(`HTTP ${res.statusCode}: ${data}`));
                }
            });
        });
        req.on('error', reject);
        req.setTimeout(15000, () => { req.destroy(); reject(new Error('Timeout')); });
        req.write(bodyBuf);
        req.end();
    });
}

// ── Last iOS artifact info (for download) ────────────
let lastIosArtifact = null; // { artifactId, repo, token, name }

// ── Poll GitHub Actions Run Status ────────────────────
function pollRunStatus(repo, runId, token, runUrl) {
    let lastStatus = '';
    const interval = setInterval(async () => {
        try {
            const response = await httpGet(
                `https://api.github.com/repos/${repo}/actions/runs/${runId}`,
                token
            );
            const run = JSON.parse(response);
            const status = run.status;       // queued, in_progress, completed
            const conclusion = run.conclusion; // success, failure, cancelled, null

            if (status !== lastStatus) {
                lastStatus = status;
                const statusText = status === 'completed'
                    ? (conclusion === 'success' ? '✅ Thành công!' : `❌ ${conclusion}`)
                    : status === 'in_progress' ? '⚙️ Đang build...' : '⏳ Đang chờ...';
                logToClients(`🍎 iOS Build: ${statusText}`, 'log');
                broadcast(JSON.stringify({ type: 'ios_status', status, conclusion, runUrl }));
            }

            if (status === 'completed') {
                clearInterval(interval);
                const success = conclusion === 'success';

                if (success) {
                    // Fetch artifacts info
                    try {
                        const artResp = await httpGet(
                            `https://api.github.com/repos/${repo}/actions/runs/${runId}/artifacts`,
                            token
                        );
                        const artData = JSON.parse(artResp);
                        if (artData.artifacts && artData.artifacts.length > 0) {
                            const art = artData.artifacts[0];
                            const sizeKb = (art.size_in_bytes / 1024).toFixed(0);
                            logToClients(`📦 Artifact: ${art.name} (${sizeKb} KB)`, 'log');
                            logToClients(`⬇️ Nhấn nút "Tải về máy" trong UI để tải về!`, 'log');
                            // Save download info for /api/build/ios-download
                            lastIosArtifact = { artifactId: art.id, repo, token, name: art.name };
                            broadcast(JSON.stringify({
                                type: 'ios_artifact',
                                name: art.name,
                                size: `${sizeKb} KB`,
                                runUrl,
                                artifactId: art.id,
                            }));
                        }
                    } catch (e) { /* ignore */ }
                    logToClients('✅ iOS Build hoàn tất! Vào GitHub Actions để tải file về.', 'log');
                } else {
                    logToClients(`❌ iOS Build thất bại! Kết quả: ${conclusion}`, 'log');
                    logToClients(`🔗 Xem log: ${runUrl}`, 'log');
                }
                doneToClients(success);
            }
        } catch (e) {
            // Network error - retry
        }
    }, 10000); // Poll every 10 seconds
}

function runGradle(task) {
    if (currentBuildProc) {
        logToClients('⚠️  Đang có tiến trình build khác đang chạy. Vui lòng chờ...');
        return;
    }

    const gradlew = path.join(PROJECT_ROOT, 'gradlew.bat');
    logToClients(`▶ Bắt đầu build: gradlew.bat ${task}`);
    logToClients(`📁 Thư mục project: ${PROJECT_ROOT}`);

    spawnProcess('cmd', ['/c', gradlew, task, '--build-cache'], PROJECT_ROOT)
        .then((code) => {
            if (code === 0) {
                logToClients('✅ Build thành công!');
                const outFile = findOutputFile(task);
                if (outFile) {
                    logToClients(`📦 File output: ${outFile}`);
                    outputToClients(outFile);
                }
                doneToClients(true);
            } else {
                logToClients(`❌ Build thất bại! Exit code: ${code}`);
                doneToClients(false);
            }
        })
        .catch((err) => {
            logToClients(`❌ Lỗi: ${err.message}`);
            doneToClients(false);
        });
}

async function generateIcoFromPng(pngPath, icoPath) {
    if (!sharp) {
        // Fallback: just copy the png as icon won't be available
        logToClients('⚠️ sharp không khả dụng, bỏ qua tạo icon .ico');
        return false;
    }
    try {
        const sizes = [256, 128, 64, 48, 32, 16];
        const images = [];
        for (const size of sizes) {
            const buf = await sharp(pngPath)
                .resize(size, size, { fit: 'fill' })
                .png()
                .toBuffer();
            images.push({ size, buf });
        }

        // Build ICO file (simple uncompressed format with PNG entries)
        const numImages = images.length;
        const headerSize = 6;
        const dirEntrySize = 16;
        const dirSize = dirEntrySize * numImages;
        let dataOffset = headerSize + dirSize;

        const entries = images.map(({ size, buf }) => {
            const entry = { size: size >= 256 ? 0 : size, offset: dataOffset, data: buf };
            dataOffset += buf.length;
            return entry;
        });

        const totalSize = dataOffset;
        const ico = Buffer.alloc(totalSize);
        // ICO Header
        ico.writeUInt16LE(0, 0);     // Reserved
        ico.writeUInt16LE(1, 2);     // Type: ICO
        ico.writeUInt16LE(numImages, 4);

        let offset = headerSize;
        for (const entry of entries) {
            ico.writeUInt8(entry.size, offset);       // Width
            ico.writeUInt8(entry.size, offset + 1);   // Height
            ico.writeUInt8(0, offset + 2);            // Color palette
            ico.writeUInt8(0, offset + 3);            // Reserved
            ico.writeUInt16LE(1, offset + 4);         // Color planes
            ico.writeUInt16LE(32, offset + 6);        // Bits per pixel
            ico.writeUInt32LE(entry.data.length, offset + 8);  // Size
            ico.writeUInt32LE(entry.offset, offset + 12);      // Offset
            offset += dirEntrySize;
        }

        for (const entry of entries) {
            entry.data.copy(ico, entry.offset);
        }

        fs.writeFileSync(icoPath, ico);
        return true;
    } catch (e) {
        logToClients(`⚠️ Không thể tạo file .ico: ${e.message}`);
        return false;
    }
}

async function runGradleThenPackage(appName) {
    if (currentBuildProc) {
        logToClients('⚠️  Đang có tiến trình build khác đang chạy. Vui lòng chờ...');
        return;
    }

    const jpackageExe = findJpackage();
    if (!jpackageExe) {
        logToClients('❌ Không tìm thấy jpackage.exe! Cần JDK 17+ để đóng gói.');
        logToClients('💡 Cài đặt JDK 17 từ: https://www.oracle.com/java/technologies/downloads/');
        doneToClients(false);
        return;
    }
    logToClients(`🔧 Tìm thấy jpackage: ${jpackageExe}`);

    // Step 1: Build JAR via Gradle
    const gradlew = path.join(PROJECT_ROOT, 'gradlew.bat');
    logToClients('▶ Bước 1/2: Build JAR...');
    logToClients(`📁 Thư mục project: ${PROJECT_ROOT}`);

    try {
        const gradleCode = await spawnProcess(
            'cmd', ['/c', gradlew, 'desktop:dist', '--build-cache'],
            PROJECT_ROOT
        );

        if (gradleCode !== 0) {
            logToClients(`❌ Build JAR thất bại! Exit code: ${gradleCode}`);
            doneToClients(false);
            return;
        }

        logToClients('✅ Build JAR thành công!');

        // Find the JAR file
        const jarDir = path.join(PROJECT_ROOT, 'desktop', 'build', 'libs');
        const jarFile = findNewestFile(jarDir, '.jar', ['sources', 'javadoc']);
        if (!jarFile) {
            logToClients('❌ Không tìm thấy file JAR sau khi build!');
            doneToClients(false);
            return;
        }
        logToClients(`📦 JAR: ${jarFile}`);

        // Step 2: Package with jpackage
        logToClients('▶ Bước 2/2: Đóng gói thành phiên bản hoàn chỉnh (jpackage)...');

        // Read version for output naming
        const version = readAndroidVersion();
        const finalName = appName || `NSO_v${version.versionName}`;

        // Output directory
        const outputDir = path.join(PROJECT_ROOT, 'desktop', 'build', 'package');
        const packageDir = path.join(outputDir, finalName);

        // Clean old package
        if (fs.existsSync(packageDir)) {
            logToClients(`🗑️ Xóa package cũ: ${packageDir}`);
            fs.rmSync(packageDir, { recursive: true, force: true });
        }
        fs.mkdirSync(outputDir, { recursive: true });

        // Generate .ico from iconapp.png if exists
        const iconPng = path.join(PROJECT_ROOT, 'iconapp.png');
        const iconIco = path.join(TOOL_DIR, '_temp_icon.ico');
        let hasIco = false;
        if (fs.existsSync(iconPng)) {
            logToClients('🖼️ Đang tạo icon .ico từ iconapp.png...');
            hasIco = await generateIcoFromPng(iconPng, iconIco);
            if (hasIco) logToClients('✅ Đã tạo icon .ico');
        }

        // Build jpackage arguments
        const jpArgs = [
            '--type', 'app-image',
            '--name', finalName,
            '--input', path.dirname(jarFile),
            '--main-jar', path.basename(jarFile),
            '--main-class', 'com.monkey.nso.DesktopLauncher',
            '--dest', outputDir,
            '--app-version', version.versionName || '1.0',
        ];

        if (hasIco) {
            jpArgs.push('--icon', iconIco);
        }

        logToClients(`🚀 Chạy jpackage: ${finalName}`);

        const jpCode = await spawnProcess(
            jpackageExe, jpArgs, PROJECT_ROOT
        );

        // Cleanup temp icon
        try { if (fs.existsSync(iconIco)) fs.unlinkSync(iconIco); } catch (e) { }

        if (jpCode !== 0) {
            logToClients(`❌ Đóng gói thất bại! Exit code: ${jpCode}`);
            doneToClients(false);
            return;
        }

        logToClients('✅ Đóng gói thành công!');

        // Verify the package
        if (fs.existsSync(packageDir)) {
            const exeFile = path.join(packageDir, `${finalName}.exe`);
            if (fs.existsSync(exeFile)) {
                const exeSize = (fs.statSync(exeFile).size / 1024).toFixed(0);
                logToClients(`📦 File EXE: ${exeFile} (${exeSize} KB)`);
            }

            // Count files in package
            let fileCount = 0;
            walkDir(packageDir, () => fileCount++);
            logToClients(`📂 Thư mục output: ${packageDir}`);
            logToClients(`📊 Tổng cộng ${fileCount} file trong package`);

            outputToClients(packageDir);
        } else {
            logToClients(`📂 Output: ${outputDir}`);
            outputToClients(outputDir);
        }

        doneToClients(true);

    } catch (err) {
        logToClients(`❌ Lỗi: ${err.message}`);
        doneToClients(false);
    }
}

// ── Logo Management ────────────────────────────────────
const LOGO_TARGETS = [
    // Desktop
    ['iconapp.png', 256, 256],
    // Android Playstore
    ['android/ic_launcher-playstore.png', 1024, 1024],
    // Mipmap - regular
    ['android/res/mipmap-mdpi/ic_launcher.png', 48, 48],
    ['android/res/mipmap-hdpi/ic_launcher.png', 72, 72],
    ['android/res/mipmap-xhdpi/ic_launcher.png', 96, 96],
    ['android/res/mipmap-xxhdpi/ic_launcher.png', 144, 144],
    ['android/res/mipmap-xxxhdpi/ic_launcher.png', 192, 192],
    // Mipmap - round
    ['android/res/mipmap-mdpi/ic_launcher_round.png', 48, 48],
    ['android/res/mipmap-hdpi/ic_launcher_round.png', 72, 72],
    ['android/res/mipmap-xhdpi/ic_launcher_round.png', 96, 96],
    ['android/res/mipmap-xxhdpi/ic_launcher_round.png', 144, 144],
    ['android/res/mipmap-xxxhdpi/ic_launcher_round.png', 192, 192],
];

function getLogoPreview() {
    const logoPath = path.join(PROJECT_ROOT, 'iconapp.png');
    if (!fs.existsSync(logoPath)) return null;
    const data = fs.readFileSync(logoPath);
    return data.toString('base64');
}

async function applyLogo(imageB64) {
    if (!sharp) {
        return { replaced: [], errors: ['Thiếu thư viện sharp. Chạy: npm install sharp'] };
    }

    let srcBuffer;
    try {
        srcBuffer = Buffer.from(imageB64, 'base64');
    } catch (e) {
        return { replaced: [], errors: [`Không thể đọc ảnh: ${e.message}`] };
    }

    const replaced = [];
    const errors = [];

    for (const [relPath, w, h] of LOGO_TARGETS) {
        const absPath = path.join(PROJECT_ROOT, ...relPath.split('/'));
        try {
            const dir = path.dirname(absPath);
            fs.mkdirSync(dir, { recursive: true });
            await sharp(srcBuffer)
                .resize(w, h, { fit: 'fill' })
                .png()
                .toFile(absPath);
            replaced.push(relPath);
        } catch (e) {
            errors.push(`${relPath}: ${e.message}`);
        }
    }

    return { replaced, errors };
}

// ── HTTP Request Body Parser ───────────────────────────
function readBody(req) {
    return new Promise((resolve, reject) => {
        const chunks = [];
        req.on('data', (chunk) => chunks.push(chunk));
        req.on('end', () => {
            const raw = Buffer.concat(chunks).toString('utf-8');
            try {
                resolve(raw ? JSON.parse(raw) : {});
            } catch (e) {
                resolve({});
            }
        });
        req.on('error', reject);
    });
}

// ── HTTP Response Helpers ──────────────────────────────
function sendJson(res, data, status = 200) {
    const body = JSON.stringify(data);
    res.writeHead(status, {
        'Content-Type': 'application/json; charset=utf-8',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'GET, POST, OPTIONS',
        'Access-Control-Allow-Headers': 'Content-Type',
        'Content-Length': Buffer.byteLength(body),
    });
    res.end(body);
}

function sendCors(res, status = 204) {
    res.writeHead(status, {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'GET, POST, OPTIONS',
        'Access-Control-Allow-Headers': 'Content-Type',
    });
    res.end();
}

// ── HTTP Server ────────────────────────────────────────
const server = http.createServer(async (req, res) => {
    const parsed = url.parse(req.url);
    const pathname = parsed.pathname;

    // CORS preflight
    if (req.method === 'OPTIONS') {
        return sendCors(res);
    }

    // ── GET Routes ──
    if (req.method === 'GET') {

        // SSE stream
        if (pathname === '/api/build/stream') {
            res.writeHead(200, {
                'Content-Type': 'text/event-stream',
                'Cache-Control': 'no-cache',
                'X-Accel-Buffering': 'no',
                'Connection': 'keep-alive',
                'Access-Control-Allow-Origin': '*',
            });
            res.write(': connected\n\n');
            sseClients.push(res);

            // Keep alive ping
            const pingInterval = setInterval(() => {
                try {
                    res.write(': ping\n\n');
                } catch (e) {
                    clearInterval(pingInterval);
                }
            }, 15000);

            req.on('close', () => {
                clearInterval(pingInterval);
                const idx = sseClients.indexOf(res);
                if (idx !== -1) sseClients.splice(idx, 1);
            });
            return;
        }

        // GET /api/config
        if (pathname === '/api/config') {
            try {
                const version = readAndroidVersion();
                const servers = readServerList();
                return sendJson(res, { success: true, version, servers });
            } catch (e) {
                return sendJson(res, { success: false, error: e.message }, 500);
            }
        }

        // GET /api/logo/preview
        if (pathname === '/api/logo/preview') {
            try {
                const image = getLogoPreview();
                return sendJson(res, { success: true, image, hasPillow: !!sharp });
            } catch (e) {
                return sendJson(res, { success: false, error: e.message }, 500);
            }
        }

        // GET /api/ios-settings — load saved token/repo/branch
        if (pathname === '/api/ios-settings') {
            try {
                const settingsPath = path.join(TOOL_DIR, 'ios-settings.json');
                if (fs.existsSync(settingsPath)) {
                    const data = JSON.parse(fs.readFileSync(settingsPath, 'utf-8'));
                    return sendJson(res, data);
                }
                return sendJson(res, {});
            } catch (e) {
                return sendJson(res, {});
            }
        }

        // Static files
        if (STATIC_FILES[pathname]) {
            const { file, type } = STATIC_FILES[pathname];
            const filePath = path.join(TOOL_DIR, file);
            try {
                const data = fs.readFileSync(filePath);
                res.writeHead(200, {
                    'Content-Type': type,
                    'Content-Length': data.length,
                    'Access-Control-Allow-Origin': '*',
                });
                res.end(data);
            } catch (e) {
                res.writeHead(404);
                res.end('Not Found');
            }
            return;
        }

        res.writeHead(404);
        res.end('Not Found');
        return;
    }

    // ── POST Routes ──
    if (req.method === 'POST') {

        // POST /api/config
        if (pathname === '/api/config') {
            try {
                const body = await readBody(req);
                if (body.version) {
                    writeAndroidVersion(
                        body.version.versionCode || 1,
                        body.version.versionName || '1.0'
                    );
                }
                let srvErrors = [];
                if (body.servers) {
                    srvErrors = writeServerList(body.servers);
                }
                const msg = srvErrors.length === 0
                    ? 'Đã lưu thành công!'
                    : `Có lỗi: ${srvErrors.join('; ')}`;
                return sendJson(res, { success: true, serverErrors: srvErrors, message: msg });
            } catch (e) {
                return sendJson(res, { success: false, error: e.message }, 500);
            }
        }

        // POST /api/build/apk
        if (pathname === '/api/build/apk') {
            sendJson(res, { success: true, message: 'Đang build APK...' });
            runGradle('android:assembleDebug');
            return;
        }

        // POST /api/build/pc
        if (pathname === '/api/build/pc') {
            sendJson(res, { success: true, message: 'Đang build Desktop (PC)...' });
            runGradle('desktop:dist');
            return;
        }

        // POST /api/build/pc-full - Build complete package with jpackage
        if (pathname === '/api/build/pc-full') {
            try {
                const body = await readBody(req);
                const appName = (body.appName || '').trim();
                sendJson(res, { success: true, message: 'Đang build phiên bản hoàn chỉnh...' });
                runGradleThenPackage(appName);
            } catch (e) {
                sendJson(res, { success: false, error: e.message }, 500);
            }
            return;
        }

        // ── iOS GitHub Actions ─────────────────────────────────────────────────

        // POST /api/ios-settings — save token/repo/branch to disk
        if (pathname === '/api/ios-settings') {
            try {
                const body = await readBody(req);
                const settingsPath = path.join(TOOL_DIR, 'ios-settings.json');
                fs.writeFileSync(settingsPath, JSON.stringify(body, null, 2), 'utf-8');
                return sendJson(res, { success: true });
            } catch (e) {
                return sendJson(res, { success: false, error: e.message }, 500);
            }
        }

        // POST /api/build/ios — trigger GitHub Actions via workflow_dispatch
        if (pathname === '/api/build/ios') {
            try {
                const body = await readBody(req);
                const settingsPath = path.join(TOOL_DIR, 'ios-settings.json');
                let settings = {};
                if (fs.existsSync(settingsPath)) {
                    settings = JSON.parse(fs.readFileSync(settingsPath, 'utf-8'));
                }

                const token = body.token || settings.token || '';
                const repo = body.repo || settings.repo || '';
                const branch = body.branch || settings.branch || 'main';
                const workflowFile = 'build-ios.yml';

                if (!token || !repo) {
                    return sendJson(res, { success: false, error: 'Cần nhập GitHub Token và Repository!' }, 400);
                }

                sendJson(res, { success: true, message: 'Đang trigger iOS build...' });

                logToClients('🍎 ===== Bắt đầu Build iOS =====', 'log');

                // Step 1: Push latest code (empty commit if nothing changed)
                logToClients('📤 Bước 1/3: Đồng bộ code lên GitHub...', 'log');
                const gitExe = 'C:\\Program Files\\Git\\bin\\git.exe';
                const remoteUrl = `https://cuongcxz1010-hue:${token}@github.com/${repo}.git`;
                const localBranch = 'fresh-main';

                // Create empty commit to ensure push triggers workflow
                try {
                    // Stage all changes first
                    await spawnProcess(gitExe, ['-C', PROJECT_ROOT, 'add', '-A'], PROJECT_ROOT);
                    // Create an empty commit with timestamp (always creates a new push)
                    await spawnProcess(gitExe, [
                        '-C', PROJECT_ROOT, 'commit', '--allow-empty',
                        '-m', `[iOS Build] ${new Date().toISOString()}`
                    ], PROJECT_ROOT);
                    logToClients('✅ Tạo commit thành công', 'log');
                } catch (e) {
                    logToClients(`⚠️ Commit: ${e.message}`, 'log');
                }

                try {
                    const gitCode = await spawnProcess(
                        gitExe,
                        ['-C', PROJECT_ROOT, 'push', remoteUrl, `${localBranch}:${branch}`],
                        PROJECT_ROOT
                    );
                    if (gitCode === 0) {
                        logToClients('✅ Push code thành công!', 'log');
                    } else {
                        logToClients(`⚠️ Push exit code: ${gitCode}`, 'log');
                    }
                } catch (gitErr) {
                    logToClients(`⚠️ Push lỗi: ${gitErr.message}`, 'log');
                }

                // Step 2: Also trigger via workflow_dispatch as backup
                logToClients('🚀 Bước 2/3: Gửi lệnh trigger GitHub Actions...', 'log');
                const triggerTime = Date.now();
                try {
                    const dispatchUrl = `https://api.github.com/repos/${repo}/actions/workflows/${workflowFile}/dispatches`;
                    await httpPost(dispatchUrl, token, JSON.stringify({ ref: branch }));
                    logToClients('✅ Đã trigger workflow_dispatch!', 'log');
                } catch (dispatchErr) {
                    logToClients(`⚠️ workflow_dispatch: ${dispatchErr.message} (push sẽ trigger thay thế)`, 'log');
                }

                // Step 3: Poll for new run
                logToClients('⏳ Bước 3/3: Đang chờ GitHub Actions khởi động...', 'log');
                let runId = null;
                let runUrl = null;
                const maxWaitMs = 3 * 60 * 1000; // 3 minutes
                let attempts = 0;

                const pollForRun = setInterval(async () => {
                    attempts++;
                    try {
                        const apiUrl = `https://api.github.com/repos/${repo}/actions/runs?branch=${branch}&per_page=5`;
                        const response = await httpGet(apiUrl, token);
                        const data = JSON.parse(response);
                        if (data.workflow_runs && data.workflow_runs.length > 0) {
                            // Look for a run created after we triggered (within last 3 min)
                            const cutoff = triggerTime - 10000; // 10s grace before trigger
                            for (const run of data.workflow_runs) {
                                const runCreatedAt = new Date(run.created_at).getTime();
                                if (runCreatedAt >= cutoff) {
                                    runId = run.id;
                                    runUrl = run.html_url;
                                    clearInterval(pollForRun);
                                    logToClients(`✅ Run #${run.run_number} đã khởi động!`, 'log');
                                    logToClients(`🔗 Link: ${runUrl}`, 'log');
                                    broadcast(JSON.stringify({ type: 'ios_run', runId, runUrl, repo }));
                                    pollRunStatus(repo, runId, token, runUrl);
                                    return;
                                }
                            }
                        }
                        if (Date.now() - triggerTime > maxWaitMs) {
                            clearInterval(pollForRun);
                            // Use latest run even if older
                            if (data.workflow_runs && data.workflow_runs.length > 0) {
                                const run = data.workflow_runs[0];
                                runId = run.id;
                                runUrl = run.html_url;
                                logToClients(`⚠️ Dùng run gần nhất: #${run.run_number}`, 'log');
                                broadcast(JSON.stringify({ type: 'ios_run', runId, runUrl, repo }));
                                pollRunStatus(repo, runId, token, runUrl);
                            } else {
                                logToClients('❌ Không tìm thấy run. Kiểm tra GitHub Actions tab.', 'log');
                                doneToClients(false);
                            }
                        }
                    } catch (e) {
                        // retry
                    }
                }, 5000);

            } catch (e) {
                return sendJson(res, { success: false, error: e.message }, 500);
            }
            return;
        }

        // POST /api/build/ios-download — download artifact ZIP from GitHub to local disk
        if (pathname === '/api/build/ios-download') {
            if (!lastIosArtifact) {
                return sendJson(res, { success: false, error: 'Chưa có artifact nào. Hãy build iOS trước!' }, 400);
            }
            const { artifactId, repo: artRepo, token: artToken, name: artName } = lastIosArtifact;
            const outputDir = path.join(PROJECT_ROOT, 'desktop', 'build', 'ios-output');
            fs.mkdirSync(outputDir, { recursive: true });
            const zipPath = path.join(outputDir, `${artName}.zip`);

            sendJson(res, { success: true, message: 'Đang tải artifact về máy...' });
            logToClients(`⬇️ Bắt đầu tải: ${artName}...`, 'log');

            // GitHub artifact download requires following a redirect
            (async () => {
                try {
                    const https = require('https');
                    // Step 1: Get redirect URL from GitHub API
                    const downloadApiUrl = `https://api.github.com/repos/${artRepo}/actions/artifacts/${artifactId}/zip`;
                    const redirectUrl = await new Promise((resolve, reject) => {
                        const options = {
                            hostname: 'api.github.com',
                            path: `/repos/${artRepo}/actions/artifacts/${artifactId}/zip`,
                            method: 'GET',
                            headers: {
                                'Authorization': `Bearer ${artToken}`,
                                'Accept': 'application/vnd.github+json',
                                'User-Agent': 'CuongNSO-VersionManager/1.0',
                                'X-GitHub-Api-Version': '2022-11-28',
                            },
                        };
                        const req = https.request(options, (r) => {
                            if (r.statusCode === 302 || r.statusCode === 301) {
                                resolve(r.headers.location);
                            } else {
                                reject(new Error(`Unexpected status: ${r.statusCode}`));
                            }
                            r.resume();
                        });
                        req.on('error', reject);
                        req.end();
                    });

                    // Step 2: Download from redirect URL
                    await new Promise((resolve, reject) => {
                        const file = fs.createWriteStream(zipPath);
                        const redirectParsed = new URL(redirectUrl);
                        const dlOptions = {
                            hostname: redirectParsed.hostname,
                            path: redirectParsed.pathname + redirectParsed.search,
                            method: 'GET',
                            headers: { 'User-Agent': 'CuongNSO-VersionManager/1.0' },
                        };
                        const dlReq = https.request(dlOptions, (dlRes) => {
                            dlRes.pipe(file);
                            file.on('finish', () => { file.close(); resolve(); });
                        });
                        dlReq.on('error', (e) => { fs.unlink(zipPath, () => { }); reject(e); });
                        dlReq.end();
                    });

                    const sizeMb = (fs.statSync(zipPath).size / (1024 * 1024)).toFixed(1);
                    logToClients(`✅ Tải xong! File: ${zipPath} (${sizeMb} MB)`, 'log');
                    logToClients(`📂 Mở thư mục để lấy file ZIP...`, 'log');
                    broadcast(JSON.stringify({ type: 'ios_downloaded', path: zipPath, folder: outputDir, size: `${sizeMb} MB` }));
                    exec(`explorer "${outputDir}"`);
                } catch (err) {
                    logToClients(`❌ Tải thất bại: ${err.message}`, 'log');
                    broadcast(JSON.stringify({ type: 'ios_download_error', error: err.message }));
                }
            })();
            return;
        }

        // POST /api/build/stop
        if (pathname === '/api/build/stop') {
            if (currentBuildProc) {
                try {
                    // Kill the process tree on Windows
                    exec(`taskkill /pid ${currentBuildProc.pid} /T /F`, () => { });
                } catch (e) {
                    // fallback
                    try { currentBuildProc.kill(); } catch (_) { }
                }
                currentBuildProc = null;
                logToClients('🛑 Đã dừng build.');
            }
            return sendJson(res, { success: true });
        }

        // POST /api/open-folder
        if (pathname === '/api/open-folder') {
            try {
                const body = await readBody(req);
                const folder = body.folder || '';
                if (folder && fs.existsSync(folder)) {
                    exec(`explorer "${folder}"`);
                    return sendJson(res, { success: true });
                } else {
                    return sendJson(res, { success: false, error: 'Folder not found' }, 404);
                }
            } catch (e) {
                return sendJson(res, { success: false, error: e.message }, 500);
            }
        }

        // POST /api/logo/apply
        if (pathname === '/api/logo/apply') {
            try {
                const body = await readBody(req);
                const imageB64 = body.image || '';
                if (!imageB64) {
                    return sendJson(res, { success: false, error: 'Không có dữ liệu ảnh' }, 400);
                }
                const { replaced, errors } = await applyLogo(imageB64);
                const msg = `Đã cập nhật ${replaced.length} file icon!`;
                return sendJson(res, {
                    success: errors.length === 0 || replaced.length > 0,
                    replaced,
                    errors,
                    message: msg,
                });
            } catch (e) {
                return sendJson(res, { success: false, error: e.message }, 500);
            }
        }

        res.writeHead(404);
        res.end('Not Found');
        return;
    }

    res.writeHead(405);
    res.end('Method Not Allowed');
});

// ── Start Server ───────────────────────────────────────
server.listen(PORT, '127.0.0.1', () => {
    console.log(`\n[*] CuongNSO Version Manager dang chay tai: http://localhost:${PORT}`);
    console.log(`[*] Project root: ${PROJECT_ROOT}`);
    console.log('[*] Nhan Ctrl+C de dung server.\n');
});
