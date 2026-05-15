"""
CuongNSO Version Manager - Native Desktop Launcher
Starts the local HTTP backend and opens the UI inside a pywebview window
(native Edge WebView2 on Windows). No browser, no Node.js.
"""

import sys
import threading
import time
import urllib.error
import urllib.request

try:
    import webview
except ImportError:
    print('[ERROR] Thieu thu vien pywebview. Chay: pip install pywebview')
    sys.exit(1)

import server


def wait_for_server(url: str, timeout_s: float = 10.0):
    deadline = time.time() + timeout_s
    while time.time() < deadline:
        try:
            with urllib.request.urlopen(url, timeout=1) as resp:
                if resp.status == 200:
                    return True
        except (urllib.error.URLError, ConnectionError, OSError):
            time.sleep(0.1)
    return False


def main():
    # Start HTTP server on background thread
    t = threading.Thread(target=server.start_server, daemon=True)
    t.start()

    url = f'http://127.0.0.1:{server.PORT}/'
    if not wait_for_server(url, timeout_s=10):
        print(f'[ERROR] Server khong khoi dong duoc tai {url}')
        sys.exit(2)

    webview.create_window(
        title='CuongNSO Version Manager',
        url=url,
        width=1440,
        height=920,
        min_size=(1100, 720),
        resizable=True,
        text_select=True,
    )
    webview.start(debug=False)


if __name__ == '__main__':
    main()
