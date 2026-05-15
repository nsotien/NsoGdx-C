package base.game2;

/**
 * Log gọn nhẹ — mặc định DEBUG=false, mọi method no-op (bytecode sạch).
 * Khi cần debug: bật DEBUG=true rồi gọi DebugLog.log("Tag", "msg") ở chỗ cần track.
 */
public final class DebugLog {
    // tắt log
    public static boolean DEBUG = false;

    public static void init() {
        // No-op khi DEBUG=false. Cần redirect stream/uncaught handler thì code lại sau.
    }

    public static void log(String msg) {
        if (DEBUG) System.out.println("[GAME] " + msg);
    }

    public static void log(String tag, String msg) {
        if (DEBUG) System.out.println("[" + tag + "] " + msg);
    }

    public static void error(String msg, Exception e) {
        if (DEBUG) {
            System.out.println("[ERROR] " + msg);
            if (e != null) e.printStackTrace(System.out);
        }
    }

    public static void error(String msg, Throwable e) {
        if (DEBUG) {
            System.out.println("[ERROR] " + msg);
            if (e != null) e.printStackTrace(System.out);
        }
    }
}
