package com.monkey.nso;

import com.badlogic.gdx.Gdx;

import java.util.Hashtable;
import java.util.TimeZone;

/**
 * Snapshot moi truong client de gan kem moi error report.
 * Cache 60s — khong overhead khi client OK (khong report gi).
 */
final class ClientContext {

    private static volatile Hashtable cached = null;
    private static volatile long cachedAt = 0L;
    private static final long CACHE_MS = 60_000L;

    private ClientContext() {}

    static Hashtable snapshot() {
        try {
            long now = System.currentTimeMillis();
            Hashtable c = cached;
            if (c != null && now - cachedAt < CACHE_MS) {
                return (Hashtable) c.clone();
            }
            Hashtable h = build();
            cached = h;
            cachedAt = now;
            return (Hashtable) h.clone();
        } catch (Throwable t) {
            return new Hashtable();
        }
    }

    private static Hashtable build() {
        Hashtable h = new Hashtable();
        try { h.put("os_name", safe(System.getProperty("os.name"))); } catch (Throwable t) {}
        try { h.put("os_version", safe(System.getProperty("os.version"))); } catch (Throwable t) {}
        try { h.put("java_vm", safe(System.getProperty("java.vm.name"))); } catch (Throwable t) {}
        try { h.put("app_type", LicenseVerifier.getPlatform()); } catch (Throwable t) {}
        try { h.put("client_tz", TimeZone.getDefault().getID()); } catch (Throwable t) {}

        // Build constants — fill boi Build Tool (server.js) truoc compile
        try { h.put("build_hash", LicenseVerifier.BUILD_HASH); } catch (Throwable t) {}
        try { h.put("build_time", LicenseVerifier.BUILD_TIME); } catch (Throwable t) {}

        // Screen
        try {
            if (Gdx.graphics != null) {
                h.put("screen", Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight());
            }
        } catch (Throwable t) {}

        // Memory
        try {
            Runtime rt = Runtime.getRuntime();
            h.put("memory_free", new Long(rt.freeMemory()));
            h.put("memory_total", new Long(rt.totalMemory()));
        } catch (Throwable t) {}

        // Native lib
        try { h.put("native_loaded", new Boolean(NativeGuard.isLoaded())); } catch (Throwable t) {}

        // License guard derived state — 4 bit snapshot
        try {
            int s1 = LicenseGuard.s1Snapshot();
            int s2 = LicenseGuard.s2Snapshot();
            h.put("license_guard_state", "s1=" + s1 + ",s2=" + s2);
        } catch (Throwable t) {
            // snapshot getter co the chua expose tat ca — bo qua
        }

        // Network type — best effort
        try {
            String nt = detectNetworkType();
            if (nt != null) h.put("network_type", nt);
        } catch (Throwable t) {}

        return h;
    }

    private static String detectNetworkType() {
        // J2ME khong co API chuan. Phan biet android/ios qua Gdx.app.getType — chi tra "unknown" cho an toan.
        // Co the bo sung native bridge sau (Phase 2).
        return "unknown";
    }

    private static String safe(String s) {
        return s == null ? "" : s;
    }
}
