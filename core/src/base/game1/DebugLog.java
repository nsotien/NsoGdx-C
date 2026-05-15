package base.game1;

/**
 * Log gọn nhẹ — mặc định DEBUG=false, mọi method no-op (bytecode sạch).
 * Khi cần debug: bật DEBUG=true rồi gọi DebugLog.log("Tag", "msg") ở chỗ cần track.
 */
public final class DebugLog {
    // tắt log
    public static boolean DEBUG = false;

    private static boolean __redirected = false;
    private static synchronized void __ensureRedirect() {
        if (__redirected) return;
        __redirected = true;
        try {
            java.io.File f = new java.io.File("desktop/build/libs/debug_log.txt");
            if (f.getParentFile() != null) f.getParentFile().mkdirs();
            java.io.PrintStream ps = new java.io.PrintStream(new java.io.FileOutputStream(f, true), true, "UTF-8");
            System.setOut(ps);
            System.setErr(ps);
            System.out.println("===== log start " + new java.util.Date() + " =====");
        } catch (Throwable __t) {}
    }

    public static void init() {
        // No-op khi DEBUG=false. Cần redirect stream/uncaught handler thì code lại sau.
    }

    public static void log(String msg) {
        if (DEBUG) { __ensureRedirect(); System.out.println("[GAME] " + msg); }
    }

    public static void log(String tag, String msg) {
        if (DEBUG) { __ensureRedirect(); System.out.println("[" + tag + "] " + msg); }
    }

    public static void error(String msg, Exception e) {
        if (DEBUG) {
            __ensureRedirect();
            System.out.println("[ERROR] " + msg);
            if (e != null) e.printStackTrace(System.out);
        }
    }

    public static void error(String msg, Throwable e) {
        if (DEBUG) {
            __ensureRedirect();
            System.out.println("[ERROR] " + msg);
            if (e != null) e.printStackTrace(System.out);
        }
    }

    /** Log với timestamp ms — dùng để trace luồng chọn nhân vật / loading */
    public static void trace(String tag, String msg) {
        if (DEBUG) {
            __ensureRedirect();
            System.out.println("[" + tag + "][" + System.currentTimeMillis() + "] " + msg);
        }
    }

    /** Dump trạng thái LicenseGuard ra log */
    public static void dumpLicense() {
        if (!DEBUG) return;
        __ensureRedirect();
        System.out.println("[LICENSE_DUMP] isVerified=" + com.monkey.nso.LicenseVerifier.isVerified
            + " verifyStarted=" + com.monkey.nso.LicenseGuard.isVerifyStarted()
            + " tripwire=" + com.monkey.nso.LicenseGuard.isTripwireFired()
            + " s1=" + com.monkey.nso.LicenseGuard.s1Snapshot()
            + " s2=" + com.monkey.nso.LicenseGuard.s2Snapshot()
            + " s5=" + com.monkey.nso.LicenseGuard.s5Snapshot()
            + " s7=" + com.monkey.nso.LicenseGuard.s7Snapshot());
    }
}
