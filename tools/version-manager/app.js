/**
 * CuongNSO Version Manager - Frontend Logic
 */

const API = 'http://localhost:3399';

// ── State ──────────────────────────────────────────────
let servers = [];
let editingIndex = -1;
let isBuilding = false;
let progressInterval = null;
let progressValue = 0;
let buildTimerInterval = null;
let buildStartTime = 0;

// ── Elements ───────────────────────────────────────────
const $ = id => document.getElementById(id);

// ── Init ───────────────────────────────────────────────
document.addEventListener('DOMContentLoaded', () => {
    loadConfig();
    setupSSE();
    setupEventListeners();
    setupLogoTab();
});

// ── Load Config from server ────────────────────────────
async function loadConfig() {
    setStatus('loading');
    try {
        const res = await fetch(`${API}/api/config`);
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const data = await res.json();

        if (data.success) {
            // Fill version inputs
            $('versionCode').value = data.version.versionCode;
            $('versionName').value = data.version.versionName;
            $('versionBadge').textContent = `v${data.version.versionName} (${data.version.versionCode})`;

            // Load servers
            servers = data.servers || [];
            renderServerTable();
            setStatus('online');
            appendLog('✅ Đã kết nối và tải cấu hình thành công.', 'success');
            appendLog(`📌 Phiên bản: ${data.version.versionName} (code: ${data.version.versionCode})`, 'info');
            appendLog(`🌐 Tổng cộng ${servers.length} máy chủ được cấu hình.`, 'info');
        }
    } catch (e) {
        setStatus('error');
        appendLog(`❌ Không thể kết nối tới server! Hãy chạy start.bat trước.`, 'error');
        appendLog(`   Lỗi: ${e.message}`, 'error');
    }
}

// ── SSE: Real-time build log ───────────────────────────
function setupSSE() {
    const source = new EventSource(`${API}/api/build/stream`);
    source.onmessage = (e) => {
        try {
            const data = JSON.parse(e.data);
            if (data.type === 'log') {
                appendLog(data.msg, classifyLog(data.msg));
            } else if (data.type === 'done') {
                isBuilding = false;
                stopProgressAnimation();
                setBuildStatus(data.success ? 'success' : 'error',
                    data.success ? '✅ Thành công' : '❌ Thất bại');
                setBuildButtons(true);
                $('btnStopBuild').style.display = 'none';
                $('progressWrap').style.display = 'none';
                showToast(data.success ? '✅ Build thành công!' : '❌ Build thất bại!',
                    data.success ? 'success' : 'error');
            } else if (data.type === 'output') {
                showOutputCard(data);
            }
            // ── iOS Events ──
            else if (data.type === 'ios_run') {
                $('iosStatusPanel').style.display = 'block';
                $('iosStatusIcon').textContent = '⏳';
                $('iosStatusText').textContent = `Run đang chạy...`;
                $('iosProgressFill').style.width = '20%';
                const link = $('iosActionsLink');
                link.href = data.runUrl;
                link.style.display = 'inline';
            } else if (data.type === 'ios_status') {
                const panel = $('iosStatusPanel');
                panel.style.display = 'block';
                if (data.status === 'in_progress') {
                    $('iosStatusIcon').textContent = '⚙️';
                    $('iosStatusText').textContent = 'Đang build trên máy Mac...';
                    $('iosProgressFill').style.width = '60%';
                } else if (data.status === 'completed') {
                    const ok = data.conclusion === 'success';
                    $('iosStatusIcon').textContent = ok ? '✅' : '❌';
                    $('iosStatusText').textContent = ok ? 'Build thành công!' : `Build thất bại: ${data.conclusion}`;
                    $('iosProgressFill').style.width = ok ? '100%' : '100%';
                    $('iosProgressFill').style.background = ok ? 'var(--color-success)' : 'var(--color-error, #ef4444)';
                }
            } else if (data.type === 'ios_artifact') {
                const detail = $('iosStatusDetail');
                detail.innerHTML =
                    `<span style="font-weight:600">📦 ${data.name}</span> <span style="opacity:.7">(${data.size})</span>
                    <div style="margin-top:8px;display:flex;gap:8px;flex-wrap:wrap">
                        <button onclick="downloadIosArtifact()" style="background:var(--color-accent);color:#fff;border:none;padding:7px 16px;border-radius:6px;cursor:pointer;font-weight:600">⬇️ Tải về máy</button>
                        <a href="${data.runUrl}" target="_blank" style="background:rgba(255,255,255,.1);color:#fff;padding:7px 14px;border-radius:6px;text-decoration:none">🔗 Mở GitHub</a>
                    </div>`;
            } else if (data.type === 'ios_downloaded') {
                // Show like a regular output card
                $('outputIcon').textContent = '🌐';
                $('outputTitle').textContent = 'iOS Build đã tải về!';
                $('outputSize').textContent = data.size;
                $('outputFilename').textContent = data.path.split('\\').pop();
                $('outputPath').textContent = data.folder;
                $('outputPath').title = data.folder;
                lastOutputFolder = data.folder;
                const card = $('outputCard');
                card.style.display = 'block';
                card.classList.remove('output-anim');
                void card.offsetWidth;
                card.classList.add('output-anim');
                appendLog(`📦 iOS artifact đã tải về: ${data.path} (${data.size})`, 'success');
                showToast('✅ Tải iOS build thành công!', 'success');
            } else if (data.type === 'ios_download_error') {
                showToast('❌ Tải thất bại: ' + data.error, 'error');
                appendLog('❌ Tải iOS artifact thất bại: ' + data.error, 'error');
            }
        } catch (_) { }
    };
    source.onerror = () => {
        // Will retry automatically
    };
}

function classifyLog(msg) {
    if (msg.includes('✅') || msg.includes('BUILD SUCCESSFUL')) return 'success';
    if (msg.includes('❌') || msg.includes('FAILED') || msg.includes('ERROR')) return 'error';
    if (msg.includes('⚠') || msg.includes('warning') || msg.includes('Warning')) return 'warn';
    if (msg.includes('▶') || msg.includes('🔨') || msg.includes('📁') || msg.includes('🛑')) return 'system';
    return 'info';
}

// ── Event Listeners ────────────────────────────────────
function setupEventListeners() {
    // Save version
    $('btnSaveVersion').addEventListener('click', saveVersion);

    // Save servers
    $('btnSaveServers').addEventListener('click', saveServers);

    // Build APK
    $('btnBuildApk').addEventListener('click', () => startBuild('apk'));

    // Build PC
    $('btnBuildPc').addEventListener('click', () => startBuild('pc'));

    // Build PC Full Package
    $('btnBuildPcFull').addEventListener('click', () => startBuild('pc-full'));

    // Build iOS
    $('btnBuildIos').addEventListener('click', startIosBuild);
    $('btnSaveIosSettings').addEventListener('click', saveIosSettings);

    // Build Java VIP clients (Ant + ProGuard)
    $('btnBuildClient148').addEventListener('click', () => startBuild('java-148'));
    $('btnBuildClient217').addEventListener('click', () => startBuild('java-217'));

    // Java IP editor
    $('javaClientTarget').addEventListener('change', loadJavaServers);
    $('btnSaveJavaServers').addEventListener('click', saveJavaServers);
    loadJavaServers();

    // Load iOS settings from server on startup
    loadIosSettings();

    // Stop build
    $('btnStopBuild').addEventListener('click', stopBuild);

    // Clear log
    $('btnClearLog').addEventListener('click', () => {
        $('logTerminal').innerHTML = '<div class="log-line system">🗑 Log đã được xóa.</div>';
    });

    // Add server toggle
    $('btnAddServer').addEventListener('click', () => {
        const form = $('addServerForm');
        if (form.style.display === 'none') {
            editingIndex = -1;
            $('addFormTitle').textContent = '➕ Thêm máy chủ mới';
            clearAddForm();
            form.style.display = 'block';
            $('newServerName').focus();
        } else {
            form.style.display = 'none';
        }
    });

    // Confirm add/edit server
    $('btnConfirmAdd').addEventListener('click', confirmAddServer);

    // Cancel add
    $('btnCancelAdd').addEventListener('click', () => {
        $('addServerForm').style.display = 'none';
        editingIndex = -1;
    });

    // Edit modal
    $('btnEditSave').addEventListener('click', saveEditModal);
    $('btnEditCancel').addEventListener('click', closeEditModal);
    $('btnEditModalClose').addEventListener('click', closeEditModal);
    $('editModal').addEventListener('click', (e) => {
        if (e.target === $('editModal')) closeEditModal();
    });

    // Enter key in add form
    [$('newServerName'), $('newServerIp'), $('newServerPort')].forEach(el => {
        el.addEventListener('keydown', e => {
            if (e.key === 'Enter') confirmAddServer();
        });
    });

    // Output card buttons
    $('btnOpenFolder').addEventListener('click', openOutputFolder);
    $('btnCopyPath').addEventListener('click', copyOutputPath);
}

// ── Fetch with timeout ─────────────────────────────────
function fetchWithTimeout(url, options = {}, timeoutMs = 10000) {
    const controller = new AbortController();
    const timer = setTimeout(() => controller.abort(), timeoutMs);
    return fetch(url, { ...options, signal: controller.signal })
        .finally(() => clearTimeout(timer));
}

// ── Version Management ─────────────────────────────────
async function saveVersion() {
    const versionCode = parseInt($('versionCode').value);
    const versionName = $('versionName').value.trim();

    if (!versionName || isNaN(versionCode) || versionCode < 1) {
        showToast('⚠️ Vui lòng nhập version hợp lệ!', 'error');
        return;
    }

    const btn = $('btnSaveVersion');
    btn.disabled = true;
    btn.textContent = '⏳ Đang lưu...';

    try {
        const res = await fetchWithTimeout(`${API}/api/config`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ version: { versionCode, versionName } })
        });
        const data = await res.json();
        if (data.success) {
            $('versionBadge').textContent = `v${versionName} (${versionCode})`;
            showToast('✅ Đã lưu phiên bản thành công!', 'success');
            appendLog(`💾 Đã cập nhật phiên bản: ${versionName} (code: ${versionCode})`, 'success');
        } else {
            showToast(`❌ Lỗi: ${data.error}`, 'error');
        }
    } catch (e) {
        const msg = e.name === 'AbortError' ? '⏱️ Hết thời gian chờ (10s). Kiểm tra server!' : `❌ Lỗi kết nối: ${e.message}`;
        showToast(msg, 'error');
        appendLog(msg, 'error');
    } finally {
        btn.disabled = false;
        btn.innerHTML = '<span class="btn-icon">💾</span> Lưu phiên bản';
    }
}

// ── Server Management ──────────────────────────────────
function renderServerTable() {
    const tbody = $('serverTableBody');
    $('serverCount').textContent = `${servers.length} server`;

    if (servers.length === 0) {
        tbody.innerHTML = `<tr><td colspan="6" class="table-empty">Chưa có máy chủ nào.</td></tr>`;
        return;
    }

    tbody.innerHTML = servers.map((s, i) => `
        <tr>
            <td class="td-name">${escapeHtml(s.name)}</td>
            <td class="td-ip">${escapeHtml(s.ip)}</td>
            <td class="td-port">${escapeHtml(s.port)}</td>
            <td>
                <span class="login-badge ${s.loginType === '0' || s.loginType === 0 ? 'zero' : 'one'}">
                    ${s.loginType === '0' || s.loginType === 0 ? 'Thường' : 'Login'}
                </span>
            </td>
            <td>
                <span class="lang-badge ${s.lang === '0' || s.lang === 0 ? 'vi' : 'en'}">
                    ${s.lang === '0' || s.lang === 0 ? 'VI' : 'EN'}
                </span>
            </td>
            <td>
                <button class="btn-tbl btn-edit" onclick="openEditModal(${i})">✏️ Sửa</button>
                &nbsp;
                <button class="btn-tbl btn-delete" onclick="deleteServer(${i})">🗑 Xóa</button>
            </td>
        </tr>
    `).join('');
}

function clearAddForm() {
    $('newServerName').value = '';
    $('newServerIp').value = '';
    $('newServerPort').value = '14444';
    $('newServerLogin').value = '0';
    $('newServerLang').value = '0';
}

function confirmAddServer() {
    const name = $('newServerName').value.trim();
    const ip = $('newServerIp').value.trim();
    const port = $('newServerPort').value.trim() || '14444';
    const loginType = $('newServerLogin').value;
    const lang = $('newServerLang').value;

    if (!name || !ip) {
        showToast('⚠️ Tên và IP không được để trống!', 'error');
        $('newServerName').focus();
        return;
    }

    if (editingIndex >= 0) {
        servers[editingIndex] = { name, ip, port, loginType, lang };
        appendLog(`✏️ Đã chỉnh sửa máy chủ: ${name} (${ip}:${port})`, 'info');
    } else {
        servers.push({ name, ip, port, loginType, lang });
        appendLog(`➕ Đã thêm máy chủ: ${name} (${ip}:${port})`, 'info');
    }

    renderServerTable();
    clearAddForm();
    $('addServerForm').style.display = 'none';
    editingIndex = -1;
    showToast('✅ Đã cập nhật danh sách! Nhớ nhấn "Lưu danh sách".', 'info');
}

function deleteServer(index) {
    const s = servers[index];
    if (!confirm(`Bạn có chắc muốn xóa máy chủ "${s.name}" (${s.ip})?`)) return;
    appendLog(`🗑 Đã xóa máy chủ: ${s.name}`, 'warn');
    servers.splice(index, 1);
    renderServerTable();
    showToast('Đã xóa máy chủ. Nhớ nhấn "Lưu danh sách".', 'info');
}

// Edit Modal
function openEditModal(index) {
    const s = servers[index];
    editingIndex = index;
    $('editName').value = s.name;
    $('editIp').value = s.ip;
    $('editPort').value = s.port;
    $('editLogin').value = String(s.loginType);
    $('editLang').value = String(s.lang);
    $('editModal').style.display = 'flex';
}

function closeEditModal() {
    $('editModal').style.display = 'none';
    editingIndex = -1;
}

function saveEditModal() {
    if (editingIndex < 0) return;
    const name = $('editName').value.trim();
    const ip = $('editIp').value.trim();
    const port = $('editPort').value.trim();
    const loginType = $('editLogin').value;
    const lang = $('editLang').value;

    if (!name || !ip) {
        showToast('⚠️ Tên và IP không được để trống!', 'error');
        return;
    }

    servers[editingIndex] = { name, ip, port, loginType, lang };
    renderServerTable();
    closeEditModal();
    appendLog(`✏️ Đã chỉnh sửa máy chủ [${editingIndex}]: ${name} → ${ip}:${port}`, 'info');
    showToast('✅ Đã chỉnh sửa! Nhớ nhấn "Lưu danh sách".', 'info');
}

async function saveServers() {
    if (servers.length === 0) {
        showToast('⚠️ Không có máy chủ nào!', 'error');
        return;
    }

    const btn = $('btnSaveServers');
    btn.disabled = true;
    btn.textContent = '⏳ Đang lưu...';

    try {
        const res = await fetchWithTimeout(`${API}/api/config`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ servers })
        });
        const data = await res.json();
        if (data.success) {
            showToast(`✅ ${data.message || 'Đã lưu thành công!'}`, 'success');
            appendLog(`💾 Đã lưu ${servers.length} máy chủ vào tất cả 6 file GameMidlet.java`, 'success');
            if (data.serverErrors && data.serverErrors.length > 0) {
                data.serverErrors.forEach(err => appendLog(`   ⚠ ${err}`, 'warn'));
            }
        } else {
            showToast(`❌ Lỗi: ${data.error}`, 'error');
        }
    } catch (e) {
        const msg = e.name === 'AbortError' ? '⏱️ Hết thời gian chờ (10s). Kiểm tra server!' : `❌ Lỗi kết nối: ${e.message}`;
        showToast(msg, 'error');
        appendLog(msg, 'error');
    } finally {
        btn.disabled = false;
        btn.innerHTML = '<span class="btn-icon">💾</span> Lưu danh sách';
    }
}

// ── Build ──────────────────────────────────────────────
async function startBuild(type) {
    if (isBuilding) {
        showToast('⚠️ Đang có build đang chạy!', 'error');
        return;
    }

    isBuilding = true;
    buildStartTime = Date.now();
    setBuildStatus('building', '⏳ Đang build...');
    setBuildButtons(false);
    $('btnStopBuild').style.display = 'inline-flex';
    $('progressWrap').style.display = 'flex';
    startProgressAnimation();

    const LABELS = {
        'apk': 'APK Android',
        'pc': 'Desktop (PC)',
        'pc-full': 'Full Package (PC)',
        'java-148': 'Client 148 VIP (Java + ProGuard)',
        'java-217': 'Client 217 VIP (Java + ProGuard)',
    };
    const label = LABELS[type] || type;
    appendLog(`\n🔨 ===== Bắt đầu Build ${label} =====`, 'system');

    try {
        let endpoint, fetchOpts;
        if (type === 'pc-full') {
            const appName = $('appNameInput').value.trim();
            endpoint = `${API}/api/build/pc-full`;
            fetchOpts = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ appName }),
            };
        } else if (type === 'java-148' || type === 'java-217') {
            endpoint = `${API}/api/build/java-client`;
            fetchOpts = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ variant: type === 'java-148' ? '148' : '217' }),
            };
        } else {
            endpoint = type === 'apk' ? `${API}/api/build/apk` : `${API}/api/build/pc`;
            fetchOpts = { method: 'POST' };
        }
        await fetch(endpoint, fetchOpts);
    } catch (e) {
        appendLog(`❌ Không thể gửi lệnh build: ${e.message}`, 'error');
        isBuilding = false;
        stopProgressAnimation();
        setBuildStatus('error', '❌ Lỗi');
        setBuildButtons(true);
        $('btnStopBuild').style.display = 'none';
        $('progressWrap').style.display = 'none';
    }
}

async function stopBuild() {
    try {
        await fetch(`${API}/api/build/stop`, { method: 'POST' });
        isBuilding = false;
        stopProgressAnimation();
        setBuildStatus('ready', 'Sẵn sàng');
        setBuildButtons(true);
        $('btnStopBuild').style.display = 'none';
        $('progressWrap').style.display = 'none';
        showToast('🛑 Đã dừng build.', 'info');
    } catch (e) { }
}

function setBuildButtons(enabled) {
    $('btnBuildApk').disabled = !enabled;
    $('btnBuildPc').disabled = !enabled;
    $('btnBuildPcFull').disabled = !enabled;
    $('btnBuildIos').disabled = !enabled;
    const c148 = $('btnBuildClient148'); if (c148) c148.disabled = !enabled;
    const c217 = $('btnBuildClient217'); if (c217) c217.disabled = !enabled;
}

function setBuildStatus(state, text) {
    const tag = $('buildStatusTag');
    tag.textContent = text;
    tag.className = 'build-status-tag';
    if (state === 'building') tag.classList.add('building');
    else if (state === 'success') tag.classList.add('success');
    else if (state === 'error') tag.classList.add('error');
}

function startProgressAnimation() {
    progressValue = 0;
    buildStartTime = Date.now();
    $('progressFill').style.width = '5%';
    // Progress bar animation
    progressInterval = setInterval(() => {
        if (progressValue < 85) {
            progressValue += Math.random() * 3;
            $('progressFill').style.width = Math.min(progressValue, 85) + '%';
        }
    }, 800);
    // Real-time timer
    buildTimerInterval = setInterval(() => {
        const elapsed = Math.floor((Date.now() - buildStartTime) / 1000);
        const m = Math.floor(elapsed / 60);
        const s = String(elapsed % 60).padStart(2, '0');
        const timeStr = m > 0 ? `${m}:${s}` : `${elapsed}s`;
        $('progressLabel').textContent = `⏱ Đang build... ${timeStr}`;
        // Also update badge
        $('buildStatusTag').textContent = `⏳ ${timeStr}`;
    }, 1000);
}

function stopProgressAnimation() {
    clearInterval(progressInterval);
    clearInterval(buildTimerInterval);
    buildTimerInterval = null;
    $('progressFill').style.width = '100%';
    setTimeout(() => {
        $('progressFill').style.width = '0%';
        $('progressLabel').textContent = 'Đang build...';
    }, 600);
}

// ── Build Output Card ──────────────────────────────────
let lastOutputFolder = '';

function showOutputCard(data) {
    lastOutputFolder = data.folder || '';
    const isApk = data.filename.endsWith('.apk');

    $('outputIcon').textContent = isApk ? '📱' : '🖥️';
    $('outputTitle').textContent = isApk ? 'APK Android đã build xong!' : 'Desktop JAR đã build xong!';
    $('outputSize').textContent = data.size;
    $('outputFilename').textContent = data.filename;
    $('outputPath').textContent = data.folder;
    $('outputPath').title = data.path;

    const card = $('outputCard');
    card.style.display = 'block';
    card.classList.remove('output-anim');
    // Trigger reflow for animation restart
    void card.offsetWidth;
    card.classList.add('output-anim');

    appendLog(`📦 Output → ${data.path} (${data.size})`, 'success');
}

async function openOutputFolder() {
    if (!lastOutputFolder) return;
    try {
        await fetch(`${API}/api/open-folder`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ folder: lastOutputFolder })
        });
    } catch (e) {
        showToast('❌ Không thể mở thư mục: ' + e.message, 'error');
    }
}

function copyOutputPath() {
    const path = $('outputPath').title || $('outputPath').textContent;
    if (!path) return;
    if (navigator.clipboard) {
        navigator.clipboard.writeText(path).then(() => {
            showToast('📋 Đã copy đường dẫn!', 'success');
        });
    } else {
        // Fallback
        const ta = document.createElement('textarea');
        ta.value = path;
        document.body.appendChild(ta);
        ta.select();
        document.execCommand('copy');
        ta.remove();
        showToast('📋 Đã copy đường dẫn!', 'success');
    }
}

// ── Log ────────────────────────────────────────────────
function appendLog(msg, type = 'info') {
    const terminal = $('logTerminal');
    const line = document.createElement('div');
    line.className = `log-line ${type}`;
    line.textContent = msg;
    terminal.appendChild(line);
    terminal.scrollTop = terminal.scrollHeight;
}

// ── Status ─────────────────────────────────────────────
function setStatus(state) {
    const dot = $('statusDot');
    const text = $('statusText');
    dot.className = 'status-dot';

    if (state === 'online') {
        dot.classList.add('online');
        text.textContent = 'Đã kết nối';
    } else if (state === 'error') {
        dot.classList.add('error');
        text.textContent = 'Lỗi kết nối';
    } else {
        text.textContent = 'Đang kết nối...';
    }
}

// ── Toast ──────────────────────────────────────────────
function showToast(message, type = 'info') {
    const container = $('toastContainer');
    const toast = document.createElement('div');
    toast.className = `toast ${type}`;
    toast.innerHTML = `<span>${message}</span>`;
    container.appendChild(toast);
    setTimeout(() => {
        toast.style.animation = 'slide-out 0.3s ease-in forwards';
        setTimeout(() => toast.remove(), 300);
    }, 4000);
}

// ── Utils ──────────────────────────────────────────────
function escapeHtml(str) {
    return String(str)
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/"/g, '&quot;');
}

// ── Tab Switching ─────────────────────────────────────────
function switchTab(tab) {
    const isConfig = tab === 'config';
    $('tabConfig').classList.toggle('active', isConfig);
    $('tabLogo').classList.toggle('active', !isConfig);
    document.querySelector('.main').style.display = isConfig ? 'grid' : 'none';
    $('logoTab').style.display = isConfig ? 'none' : 'block';
    if (!isConfig) loadLogoPreview();
}

// ── Logo Tab ───────────────────────────────────────────
let logoImageB64 = null;   // base64 of selected image

function setupLogoTab() {
    const dropZone = $('dropZone');
    const fileInput = $('logoFileInput');

    // Click to open file picker
    dropZone.addEventListener('click', (e) => {
        if (e.target === $('btnLogoReset') || e.target === $('logoPreviewImg')) return;
        fileInput.click();
    });

    fileInput.addEventListener('change', () => {
        if (fileInput.files[0]) handleLogoFile(fileInput.files[0]);
    });

    // Drag & Drop
    dropZone.addEventListener('dragover', (e) => {
        e.preventDefault();
        dropZone.classList.add('drag-over');
    });
    dropZone.addEventListener('dragleave', () => {
        dropZone.classList.remove('drag-over');
    });
    dropZone.addEventListener('drop', (e) => {
        e.preventDefault();
        dropZone.classList.remove('drag-over');
        const file = e.dataTransfer.files[0];
        if (file && file.type.startsWith('image/')) handleLogoFile(file);
        else showToast('⚠️ Chỉ chấp nhận file ảnh!', 'error');
    });

    // Reset button
    $('btnLogoReset').addEventListener('click', (e) => {
        e.stopPropagation();
        resetLogoSelection();
    });

    // Apply button
    $('btnApplyLogo').addEventListener('click', applyLogo);
}

function handleLogoFile(file) {
    const reader = new FileReader();
    reader.onload = (e) => {
        const result = e.target.result; // data:image/png;base64,...
        logoImageB64 = result.split(',')[1]; // strip prefix

        // Show preview
        const preview = $('logoPreviewImg');
        preview.src = result;
        preview.style.display = 'block';
        $('dropZoneContent').style.display = 'none';

        // Show meta
        $('logoFilenameBadge').textContent = '📄 ' + file.name;
        $('logoUploadMeta').style.display = 'flex';
        $('btnApplyLogo').disabled = false;
        $('logoResult').style.display = 'none';
    };
    reader.readAsDataURL(file);
}

function resetLogoSelection() {
    logoImageB64 = null;
    $('logoPreviewImg').style.display = 'none';
    $('dropZoneContent').style.display = 'flex';
    $('logoUploadMeta').style.display = 'none';
    $('btnApplyLogo').disabled = true;
    $('logoResult').style.display = 'none';
    $('logoFileInput').value = '';
}

async function loadLogoPreview() {
    try {
        const res = await fetch(`${API}/api/logo/preview`);
        const data = await res.json();

        // Pillow status badge
        const badge = $('logoPillowBadge');
        if (data.hasPillow) {
            badge.textContent = '✅ Pillow sẵn sàng';
            badge.style.background = 'rgba(34,197,94,0.2)';
            badge.style.color = '#22c55e';
        } else {
            badge.textContent = '⚠️ Thiếu Pillow';
            badge.style.background = 'rgba(234,179,8,0.2)';
            badge.style.color = '#eab308';
        }

        // Show current logo
        if (data.image) {
            $('logoCurrentImg').src = 'data:image/png;base64,' + data.image;
            $('logoCurrentImg').style.display = 'block';
            $('logoNoImg').style.display = 'none';
        } else {
            $('logoCurrentImg').style.display = 'none';
            $('logoNoImg').style.display = 'flex';
        }
    } catch (e) {
        console.error('Cannot load logo preview:', e);
    }
}

async function applyLogo() {
    if (!logoImageB64) return;

    const btn = $('btnApplyLogo');
    btn.disabled = true;
    btn.innerHTML = '⏳ Đang áp dụng...';

    const result = $('logoResult');
    result.style.display = 'none';

    try {
        const res = await fetch(`${API}/api/logo/apply`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ image: logoImageB64 })
        });
        const data = await res.json();

        result.style.display = 'block';
        if (data.success) {
            const errHtml = data.errors && data.errors.length
                ? `<div class="logo-result-errors">⚠️ Lỗi: ${data.errors.join(', ')}</div>` : '';
            result.innerHTML = `
                <div class="logo-result-ok">
                    ✅ Đã cập nhật <strong>${data.replaced.length}</strong> file icon thành công!
                    ${errHtml}
                </div>
                <div class="logo-result-list">${data.replaced.map(f => `<code>${f}</code>`).join('')}</div>
            `;
            showToast(`✅ Đã thay logo: ${data.replaced.length} files!`, 'success');
            appendLog(`🖼️ Đã thay logo: ${data.replaced.length} file icon.`, 'success');
            // Refresh current preview
            loadLogoPreview();
        } else {
            result.innerHTML = `<div class="logo-result-error">❌ Lỗi: ${data.error || data.errors?.join(', ')}</div>`;
            showToast('❌ Không thể áp dụng logo!', 'error');
        }
    } catch (e) {
        result.style.display = 'block';
        result.innerHTML = `<div class="logo-result-error">❌ Lỗi kết nối: ${e.message}</div>`;
        showToast('❌ Lỗi kết nối!', 'error');
    } finally {
        btn.disabled = false;
        btn.innerHTML = '<span class="btn-icon">✅</span> Áp dụng tất cả (12 files)';
    }
}

// ── iOS Build Functions ─────────────────────────────────

async function loadIosSettings() {
    try {
        const res = await fetch(`${API}/api/ios-settings`);
        if (!res.ok) return;
        const data = await res.json();
        if (data.token) $('githubToken').value = data.token;
        if (data.repo) $('githubRepo').value = data.repo;
        if (data.branch) $('githubBranch').value = data.branch;
    } catch (e) { /* server may not have settings yet */ }
}

async function saveIosSettings() {
    const token = $('githubToken').value.trim();
    const repo = $('githubRepo').value.trim();
    const branch = $('githubBranch').value.trim() || 'main';

    if (!token || !repo) {
        showToast('⚠️ Vui lòng nhập Token và Repository!', 'error');
        return;
    }

    try {
        await fetch(`${API}/api/ios-settings`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ token, repo, branch })
        });
        showToast('✅ Đã lưu cài đặt iOS!', 'success');
        appendLog('💾 Đã lưu cài đặt GitHub Actions.', 'info');
    } catch (e) {
        showToast('❌ Không thể lưu cài đặt!', 'error');
    }
}

function toggleIosSettings() {
    const body = $('iosSettingsBody');
    const arrow = $('iosSettingsArrow');
    const isHidden = body.style.display === 'none';
    body.style.display = isHidden ? 'block' : 'none';
    arrow.textContent = isHidden ? '▲' : '▼';
}

async function downloadIosArtifact() {
    try {
        const res = await fetch(`${API}/api/build/ios-download`, { method: 'POST' });
        const data = await res.json();
        if (data.success) {
            appendLog('⬇️ Đang tải artifact iOS về máy... Chờ một chút!', 'info');
            showToast('⬇️ Đang tải về máy...', 'info');
        } else {
            showToast(`❌ ${data.error}`, 'error');
            appendLog(`❌ ${data.error}`, 'error');
        }
    } catch (e) {
        showToast(`❌ Lỗi kết nối: ${e.message}`, 'error');
    }
}

async function startIosBuild() {
    const token = $('githubToken').value.trim();
    const repo = $('githubRepo').value.trim();
    const branch = $('githubBranch').value.trim() || 'main';

    if (!token || !repo) {
        // Auto-open settings panel
        $('iosSettingsBody').style.display = 'block';
        $('iosSettingsArrow').textContent = '▲';
        showToast('⚠️ Vui lòng nhập Token và Repository trước!', 'error');
        $('githubToken').focus();
        return;
    }

    if (isBuilding) {
        showToast('⚠️ Đang có build đang chạy!', 'error');
        return;
    }

    isBuilding = true;
    buildStartTime = Date.now();
    setBuildStatus('building', '⏳ iOS Build...');
    setBuildButtons(false);
    $('btnStopBuild').style.display = 'none'; // iOS can't be stopped locally
    $('progressWrap').style.display = 'flex';
    startProgressAnimation();

    // Reset iOS status panel
    $('iosStatusPanel').style.display = 'block';
    $('iosStatusIcon').textContent = '📤';
    $('iosStatusText').textContent = 'Đang push code lên GitHub...';
    $('iosProgressFill').style.width = '10%';
    $('iosProgressFill').style.background = '';
    $('iosActionsLink').style.display = 'none';
    $('iosStatusDetail').innerHTML = '';

    appendLog('\n🍎 ===== Bắt đầu Build iOS (GitHub Actions) =====', 'system');
    appendLog(`📦 Repo: ${repo} | Branch: ${branch}`, 'info');

    try {
        await fetch(`${API}/api/build/ios`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ token, repo, branch })
        });
    } catch (e) {
        appendLog(`❌ Không thể gửi lệnh iOS build: ${e.message}`, 'error');
        isBuilding = false;
        stopProgressAnimation();
        setBuildStatus('error', '❌ Lỗi');
        setBuildButtons(true);
        $('progressWrap').style.display = 'none';
    }
}

// ── Java client IP editor (148 / 217) ─────────────────────
async function loadJavaServers() {
    const variant = $('javaClientTarget').value;
    try {
        const res = await fetch(`${API}/api/java-servers?variant=${variant}`);
        const data = await res.json();
        const servers = data.servers || [];
        const lines = servers.map(s =>
            `${s.name}:${s.ip}:${s.port}:${s.loginType}:${s.lang}`
        );
        $('javaServersText').value = lines.join('\n');
        $('javaIpBadge').textContent = `${servers.length} server`;
    } catch (e) {
        showToast(`❌ Lỗi đọc IP list: ${e.message}`, 'error');
    }
}

async function saveJavaServers() {
    const variant = $('javaClientTarget').value;
    const text = $('javaServersText').value;
    const servers = [];
    const lines = text.split('\n');
    for (let i = 0; i < lines.length; i++) {
        const line = lines[i].trim();
        if (!line || line.startsWith('#')) continue;
        const parts = line.split(':');
        if (parts.length < 4) {
            showToast(`❌ Dòng ${i + 1} sai format (cần ít nhất Name:IP:Port:Login)`, 'error');
            return;
        }
        servers.push({
            name: parts[0].trim(),
            ip: parts[1].trim(),
            port: (parts[2] || '14444').trim(),
            loginType: (parts[3] || '0').trim(),
            lang: (parts[4] || '0').trim(),
        });
    }
    if (servers.length === 0) {
        showToast('❌ Phải có ít nhất 1 server', 'error');
        return;
    }

    try {
        const res = await fetch(`${API}/api/java-servers`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ variant, servers }),
        });
        const data = await res.json();
        if (data.success) {
            showToast(`✅ Đã lưu ${servers.length} server cho Client ${variant} VIP`, 'success');
            $('javaIpBadge').textContent = `${servers.length} server`;
        } else {
            showToast(`❌ ${data.error || 'Lưu thất bại'}`, 'error');
        }
    } catch (e) {
        showToast(`❌ Lỗi lưu: ${e.message}`, 'error');
    }
}
