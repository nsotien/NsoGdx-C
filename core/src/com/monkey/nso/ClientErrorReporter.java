package com.monkey.nso;

import base.game1.DebugLog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Debug Log — fire-and-forget reporter gui log loi ve Worker /pb/client-error.
 * - KHONG block, KHONG throw ra ngoai (tat ca exception phai swallow).
 * - Throttle (stage+code): 60s/1 lan -> khong spam khi user retry.
 * - MAX_INFLIGHT=5 -> drop neu qua.
 * - Detail cap 14KB.
 * - Kill switch: ENABLED=false revert toan bo flow ve nhu cu.
 * - Network fail -> fallback ghi vao Nso/pending_errors.jsonl, lan sau verify OK se flush.
 */
public final class ClientErrorReporter {

    /** Kill switch — set false neu can revert tuc thi. */
    public static volatile boolean ENABLED = true;

    private static final int  DETAIL_CAP    = 14_000;
    private static final long THROTTLE_MS   = 60_000L;
    private static final int  MAX_INFLIGHT  = 5;
    private static final int  BUFFER_FILE_CAP = 100; // 100 dong ~ 1.4MB toi da
    private static final String BUFFER_PATH   = "Nso/pending_errors.jsonl";

    private static final HashMap lastSent = new HashMap();
    private static final AtomicInteger inflight = new AtomicInteger(0);

    private ClientErrorReporter() {}

    /**
     * Bao cao loi — fire and forget. Khong bao gio block caller, khong bao gio throw.
     * @param stage 'verify' | 'fakeStart' | 'lazy_fetch' | 'runtime' | 'guard'
     * @param code  ma loi ngan (RSA_FAIL, NETWORK_FAIL...) — fillable enum o web admin.
     * @param ctx   context bo sung (co the null). Cac field hay dung: server_message, exception_class,
     *              exception_message, stack_trace, http_code, response_preview, request_payload_preview,
     *              user_message_shown, last_user_action.
     */
    public static void report(String stage, String code, Hashtable ctx) {
        try {
            if (!ENABLED) return;
            if (stage == null || code == null) return;

            // Throttle (stage+code)
            String tkey = stage + "|" + code;
            long now = System.currentTimeMillis();
            synchronized (lastSent) {
                Object last = lastSent.get(tkey);
                if (last instanceof Long && now - ((Long) last).longValue() < THROTTLE_MS) return;
                lastSent.put(tkey, new Long(now));
            }

            if (inflight.get() >= MAX_INFLIGHT) return;
            inflight.incrementAndGet();

            final String fStage = stage;
            final String fCode  = code;
            final Hashtable fCtx = ctx != null ? ctx : new Hashtable();

            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        sendNow(fStage, fCode, fCtx);
                    } catch (Throwable th) {
                        // swallow
                    } finally {
                        inflight.decrementAndGet();
                    }
                }
            });
            t.setDaemon(true);
            t.setName("ClientErrorReporter");
            t.start();
        } catch (Throwable th) {
            // Reporter chet im lang
        }
    }

    /** Overload tien cho exception. */
    public static void reportException(String stage, String code, Throwable ex, Hashtable ctx) {
        try {
            if (ctx == null) ctx = new Hashtable();
            if (ex != null) {
                ctx.put("exception_class", ex.getClass().getName());
                ctx.put("exception_message", ex.getMessage() != null ? ex.getMessage() : "");
                ctx.put("stack_trace", ReporterUtil.stackTrace(ex));
            }
            report(stage, code, ctx);
        } catch (Throwable th) {
            // swallow
        }
    }

    // ================================================================
    // Send (background thread)
    // ================================================================

    private static void sendNow(String stage, String code, Hashtable ctx) {
        String json = null;
        try {
            json = buildPayload(stage, code, ctx);
            if (json == null) return;

            String workerUrl = Bridge.d(LicenseVerifier.WORKER_URL_ENC_FOR_REPORTER);
            if (workerUrl == null || workerUrl.length() == 0) return;

            boolean ok = postPlain(workerUrl + "/pb/client-error", json);
            if (!ok) {
                bufferToFile(json);
            }
        } catch (Throwable th) {
            // swallow + buffer if we have json
            if (json != null) try { bufferToFile(json); } catch (Throwable t2) {}
        }
    }

    private static String buildPayload(String stage, String code, Hashtable ctx) {
        try {
            // Get key + device_id — best effort, khong crash neu fail
            String key = "";
            String deviceId = "";
            try { key = LicenseVerifier.readKey(); } catch (Throwable t) {}
            try { deviceId = base.game1.DeviceID.get(); } catch (Throwable t) {}
            if (key == null) key = "";
            if (deviceId == null) deviceId = "";

            String platform = LicenseVerifier.getPlatform();
            String version  = LicenseVerifier.CLIENT_VERSION;
            long ts = System.currentTimeMillis() / 1000L;

            // Merge ctx + ClientContext snapshot
            Hashtable detail = ClientContext.snapshot();
            if (ctx != null) {
                Enumeration en = ctx.keys();
                while (en.hasMoreElements()) {
                    Object k = en.nextElement();
                    Object v = ctx.get(k);
                    detail.put(k, v);
                }
            }
            String detailJson = ReporterUtil.toJsonObject(detail);
            if (detailJson.length() > DETAIL_CAP) {
                detailJson = detailJson.substring(0, DETAIL_CAP - 30) + "\"__truncated__\":true}";
            }

            StringBuffer sb = new StringBuffer(512);
            sb.append('{');
            sb.append("\"key\":\"").append(ReporterUtil.esc(key)).append("\",");
            sb.append("\"device_id\":\"").append(ReporterUtil.esc(deviceId)).append("\",");
            sb.append("\"platform\":\"").append(ReporterUtil.esc(platform)).append("\",");
            sb.append("\"version\":\"").append(ReporterUtil.esc(version)).append("\",");
            sb.append("\"stage\":\"").append(ReporterUtil.esc(stage)).append("\",");
            sb.append("\"code\":\"").append(ReporterUtil.esc(code)).append("\",");
            sb.append("\"ts\":").append(ts).append(',');
            sb.append("\"detail\":").append(detailJson);
            sb.append('}');
            return sb.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean postPlain(String urlStr, String jsonBody) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            os.write(jsonBody.getBytes("UTF-8"));
            os.flush();
            os.close();

            int code = conn.getResponseCode();
            return code >= 200 && code < 300;
        } catch (Throwable th) {
            return false;
        } finally {
            if (conn != null) try { conn.disconnect(); } catch (Throwable t) {}
        }
    }

    // ================================================================
    // Local file buffer (offline fallback)
    // ================================================================

    private static synchronized void bufferToFile(String jsonLine) {
        try {
            if (Gdx.files == null) return;
            FileHandle fh;
            try { fh = Gdx.files.external(BUFFER_PATH); }
            catch (Throwable t) { fh = Gdx.files.local(BUFFER_PATH); }
            if (fh == null) return;

            // Cap dong (don gian: neu file qua to thi rotate)
            try {
                if (fh.exists() && fh.length() > 2_000_000L) {
                    fh.delete();
                }
            } catch (Throwable t) {}

            // Append 1 dong
            String line = jsonLine + "\n";
            try {
                fh.writeString(line, true, "UTF-8");
            } catch (Throwable t) {
                // some platforms don't support append on internal — best effort
            }
        } catch (Throwable th) {
            // swallow
        }
    }

    /** Goi sau khi verify() return true — flush buffer file len worker, xoa neu OK. */
    public static void flushPending() {
        try {
            if (!ENABLED) return;
            if (Gdx.files == null) return;
            final FileHandle fh;
            try { fh = Gdx.files.external(BUFFER_PATH); }
            catch (Throwable t) { return; }
            if (fh == null || !fh.exists()) return;

            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        String content = fh.readString("UTF-8");
                        if (content == null || content.length() == 0) { try { fh.delete(); } catch (Throwable th) {} return; }

                        String workerUrl = Bridge.d(LicenseVerifier.WORKER_URL_ENC_FOR_REPORTER);
                        if (workerUrl == null || workerUrl.length() == 0) return;
                        String endpoint = workerUrl + "/pb/client-error";

                        String[] lines = content.split("\n");
                        int sent = 0;
                        for (int i = 0; i < lines.length && i < BUFFER_FILE_CAP; i++) {
                            String l = lines[i];
                            if (l == null || l.length() == 0) continue;
                            if (postPlain(endpoint, l)) sent++;
                            else break; // mat mang lai -> stop
                        }
                        if (sent == lines.length || sent >= BUFFER_FILE_CAP) {
                            try { fh.delete(); } catch (Throwable th) {}
                        }
                    } catch (Throwable th) {
                        // swallow
                    }
                }
            });
            t.setDaemon(true);
            t.setName("ClientErrorReporter-Flush");
            t.start();
        } catch (Throwable th) {
            // swallow
        }
    }

    // ================================================================
    // Convenience helper — ctx tu key-value pair
    // ================================================================

    /** Tao Hashtable nhanh tu cac cap (key, value). Vd: ctx("http_code", 500, "url", "..."). */
    public static Hashtable ctx(Object... kv) {
        Hashtable h = new Hashtable();
        try {
            for (int i = 0; i + 1 < kv.length; i += 2) {
                if (kv[i] != null && kv[i + 1] != null) {
                    h.put(kv[i].toString(), kv[i + 1]);
                }
            }
        } catch (Throwable t) {}
        return h;
    }
}
