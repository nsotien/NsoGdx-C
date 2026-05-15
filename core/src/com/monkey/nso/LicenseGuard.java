package com.monkey.nso;

/**
 * Phase 2 (A1 + N5 + N6): replace boolean isVerified single point voi:
 *   - 8 derived state (s1..s8) + cross-check tinh tu license key + timestamp
 *   - 10 method g1()..g10() — moi method 1 cong thuc kiem tra khac, KHONG share helper
 *   - tripwire(): phat hien cracker patch isVerified=true (decoy) qua invariant check
 *   - shouldDegrade(): tra true sau 2h ke tu khi tripwire fired -> caller corrupt gameplay
 *
 * Cracker patch:
 *   - 1 method g1() return true -> 9 method khac van fail neu state sai -> 9/10 callsite detect
 *   - tat ca g1..g10 return true -> can patch dung markVerified de set s1..s8 nhat quan + sync native
 *   - patch isVerified=true (decoy) -> tripwire fire trong 30s -> 2h sau game lag/corrupt
 *
 * Phu thuoc: NativeGuard (Phase 3 N1) — Phase 2 chi co stub fallback Java.
 *
 * Doc map cong thuc:
 *   formula A: s3 == s1 + s2                       (g1)
 *   formula B: s4 == s1 ^ s2 ^ s3                  (g2)
 *   formula C: s5 == s1 * 31 + s2                  (g3)
 *   formula D: s7 == (s2 - s1) ^ 0x12345678        (g4)
 *   formula E: (s3 ^ s4) == (s1 ^ s2)              (g5) — derived: s4=s1^s2^s3 -> s4^s3=s1^s2
 *   formula F: (s6 ^ s4) == rotateLeft(s1, 7)      (g6)
 *   formula G: s8 - s7 == s5 + s6                  (g7)
 *   formula H: (s1 ^ s2 ^ s3 ^ s4) == 0            (g8) — derived: s4=s1^s2^s3 -> XOR all 4 = 0
 *   formula I: ((s5+s7) & 0xFFFF) == ...           (g9)
 *   formula J: ((s7 ^ 0x12345678) + s1) == s2      (g10) — rearranged form D
 */
public final class LicenseGuard {

    private LicenseGuard() {}

    // H3 Phase 6: Release build flag — Build Tool inject "true" khi build release.
    // Dev build local giu nguyen "false" -> native absent KHONG fire tripwire (tranh false-positive).
    // KHONG sua tay — Build Tool regex replace: false -> true qua placeholder BUILD_TOOL_REPLACE.
    private static final boolean IS_RELEASE_BUILD = true;

    // 8 derived state — package-private cho phep callsite inline read trong cung package
    // Cross-package callsite dung snapshot getter.
    static int s1, s2, s3, s4, s5, s6, s7, s8;
    static long ts;

    private static volatile boolean verifyStarted = false;

    // N6 tripwire state
    private static volatile boolean tripwireFired = false;
    private static volatile long tripwireTime = 0L;

    // H3: rieng cho native-absent tripwire (tranh double-fire cung tripwireFired chung)
    private static volatile boolean nativeAbsentTripwireFired = false;

    // ============================================================
    // markVerified — goi 1 lan tu NSO.java sau khi LicenseVerifier.verify() thanh cong
    // ============================================================
    public static void markVerified(String key) {
        int h = (key == null) ? 0 : key.hashCode();
        long t = System.currentTimeMillis();
        s1 = h ^ 0xCAFEBABE;
        s2 = (int)(t / 1000L) ^ s1;
        s3 = s1 + s2;
        s4 = s1 ^ s2 ^ s3;
        s5 = (s1 * 31) + s2;
        s6 = Integer.rotateLeft(s1, 7) ^ s4;
        s7 = (s2 - s1) ^ 0x12345678;
        s8 = s5 + s6 + s7;
        ts = t;
        verifyStarted = true;
        // Sync native (N1 Phase 3) — neu native chua co thi NativeGuard.isLoaded() = false
        try {
            if (NativeGuard.isLoaded()) {
                NativeGuard.markVerifiedNative(h);
            }
        } catch (Throwable ignored) {}
    }

    public static boolean isVerifyStarted() { return verifyStarted; }

    /** Reset state — goi khi heartbeat fail / TTL expire (chua dung trong Phase 2). */
    public static void invalidate() {
        s1 = 0; s2 = 0; s3 = 0; s4 = 0; s5 = 0; s6 = 0; s7 = 0; s8 = 0;
        ts = 0L;
    }

    /** Backward-compat: F0e van goi ensureReady — delegate sang fallback Java. */
    public static boolean ensureReady() {
        return ensureReadyJavaFallback();
    }

    // ============================================================
    // 10 GATE METHOD — moi method cong thuc khac, KHONG goi nhau, KHONG share helper.
    // Inline cho phep cracker patch 1 method khong bypass duoc 9 method con lai.
    // ============================================================

    /** Vi tri 1 — Service.login() */
    public static boolean g1() {
        if (!verifyStarted) return true;
        if (s1 == 0 || s2 == 0) return false;
        if (s3 != s1 + s2) return false; // formula A
        if (System.currentTimeMillis() - ts > 86400000L) return false;
        return checkNative(0xA1);
    }

    /** Vi tri 2 — GameScr paint frame % 100 */
    public static boolean g2() {
        if (!verifyStarted) return true;
        if (s1 == 0 || s4 == 0) return false;
        if (s4 != (s1 ^ s2 ^ s3)) return false; // formula B
        if (s6 != (Integer.rotateLeft(s1, 7) ^ s4)) return false;
        return checkNative(0xB2);
    }

    /** Vi tri 3 — Code.run() % 50 */
    public static boolean g3() {
        if (!verifyStarted) return true;
        if (s5 == 0) return false;
        if (s5 != (s1 * 31 + s2)) return false; // formula C
        if (System.currentTimeMillis() - ts > 86400000L) return false;
        return checkNative(0xC3);
    }

    /** Vi tri 4 — Session_ME packet send */
    public static boolean g4() {
        if (!verifyStarted) return true;
        if (s7 == 0) return false;
        if (s7 != ((s2 - s1) ^ 0x12345678)) return false; // formula D
        if (s8 != s5 + s6 + s7) return false;
        return checkNative(0xD4);
    }

    /** Vi tri 5 — phong.start_relogin() */
    public static boolean g5() {
        if (!verifyStarted) return true;
        if (s1 == 0) return false;
        // Formula E: s4 = s1^s2^s3 -> s4^s3 = s1^s2 (always holds neu state hop le)
        if ((s3 ^ s4) != (s1 ^ s2)) return false;
        return checkNative(0xE5);
    }

    /** Vi tri 6 — GameCanvas.run init */
    public static boolean g6() {
        if (!verifyStarted) return true;
        if (s2 == 0 || s6 == 0) return false;
        if ((s6 ^ s4) != Integer.rotateLeft(s1, 7)) return false; // formula F
        if (System.currentTimeMillis() - ts > 86400000L) return false;
        return checkNative(0xF6);
    }

    /** Vi tri 7 — Controller -27 (login response) */
    public static boolean g7() {
        if (!verifyStarted) {
            base.game1.DebugLog.trace("G7", "verifyStarted=false → return true (OK)");
            return true;
        }
        if (s3 == 0 || s8 == 0) {
            base.game1.DebugLog.trace("G7", "FAIL: s3=" + s3 + " s8=" + s8 + " (zero state — markVerified chưa chạy đúng?)");
            return false;
        }
        if (s8 - s7 != s5 + s6) {
            base.game1.DebugLog.trace("G7", "FAIL: formula G — s8=" + s8 + " s7=" + s7 + " s5=" + s5 + " s6=" + s6
                + " (s8-s7=" + (s8 - s7) + " != s5+s6=" + (s5 + s6) + ")");
            return false;
        }
        boolean r = checkNative(0x17);
        base.game1.DebugLog.trace("G7", "checkNative=" + r + " s3=" + s3 + " s5=" + s5 + " s7=" + s7 + " s8=" + s8);
        return r;
    }

    /** Vi tri 8 — TileMap.i() lan dau vao map */
    public static boolean g8() {
        if (!verifyStarted) return true;
        if (s4 == 0) return false;
        // Formula H: s4 = s1^s2^s3 -> s1^s2^s3^s4 = 0 (cross-check XOR identity)
        if ((s1 ^ s2 ^ s3 ^ s4) != 0) return false;
        return checkNative(0x28);
    }

    /** Vi tri 9 — phong2.menu_vip() */
    public static boolean g9() {
        if (!verifyStarted) return true;
        if (s5 == 0 || s7 == 0) return false;
        int lhs = (s5 + s7) & 0xFFFF;
        int rhs = (s1 * 31 + s2 + ((s2 - s1) ^ 0x12345678)) & 0xFFFF;
        if (lhs != rhs) return false; // formula I
        return checkNative(0x39);
    }

    /** Vi tri 10 — Auto.changeZone() */
    public static boolean g10() {
        if (!verifyStarted) return true;
        if (s6 == 0 || s8 == 0) return false;
        // Formula J: rearranged form D — s7 = (s2-s1)^0x12345678 -> (s7^0x12345678)+s1 = s2
        if (((s7 ^ 0x12345678) + s1) != s2) return false;
        return checkNative(0x4A);
    }

    // ============================================================
    // Native helper — Phase 3 N1 wire vao thuc su.
    // Phase 2: NativeGuard.isLoaded() = false -> fallback Java cross-check 8 state.
    // ============================================================
    private static boolean checkNative(int ctx) {
        try {
            if (!NativeGuard.isLoaded()) {
                return ensureReadyJavaFallback();
            }
            long token = NativeGuard.gateState(ctx);
            // Phase 3A sentinel: -1L = "native loaded nhung gate impl chua co" -> Java fallback.
            if (token == -1L) {
                return ensureReadyJavaFallback();
            }
            // Phase 3C: token != 0 va high 32-bit != 0 -> OK.
            return token != 0L && (int)(token >>> 32) != 0;
        } catch (Throwable t) {
            return ensureReadyJavaFallback();
        }
    }

    /** Fallback Java khi native chua co (Phase 2) — cross-check 8 state co ban.
     *  H3: neu IS_RELEASE_BUILD va native absent -> fire tripwire (degrade sau 2-6h).
     *  Dev build: IS_RELEASE_BUILD = false -> skip tripwire (tranh false-positive). */
    private static boolean ensureReadyJavaFallback() {
        // H3: chi fire khi release build + native chua load + chua fire lan nao
        if (IS_RELEASE_BUILD && !NativeGuard.isLoaded() && !nativeAbsentTripwireFired) {
            nativeAbsentTripwireFired = true;
            try { fireTripwire("NATIVE_ABSENT"); } catch (Throwable ignore) {}
        }
        if (!verifyStarted) return true;
        if (s1 == 0 || s2 == 0) return false;
        if (s3 != s1 + s2) return false;
        if (s4 != (s1 ^ s2 ^ s3)) return false;
        if (System.currentTimeMillis() - ts > 86400000L) return false;
        return true;
    }

    // ============================================================
    // Snapshot getters — cho N6 tripwire callsite cross-package read state
    // ma KHONG can mo public 8 field (giu encapsulation, ClassObfuscator rename method de hon field).
    // ============================================================
    public static int s1Snapshot() { return s1; }
    public static int s2Snapshot() { return s2; }
    public static int s5Snapshot() { return s5; }
    public static int s7Snapshot() { return s7; }

    // ============================================================
    // N6 tripwire — phat hien invariant violated (LicenseVerifier.isVerified=true && s1=0)
    // ============================================================

    /** Set tripwire 1 lan, ghi timestamp. KHONG log de cracker khong thay stack trace. */
    public static void fireTripwire(int reason) {
        if (tripwireFired) return;
        tripwireFired = true;
        tripwireTime = System.currentTimeMillis();
        // reason chi de debug build (silent in release)
    }

    /** Overload String cho H3 NATIVE_ABSENT tripwire — delegate int version. */
    public static void fireTripwire(String reason) {
        fireTripwire(0);
    }

    public static boolean isTripwireFired() { return tripwireFired; }

    /** Tripwire fired va da qua 2h -> caller bat dau corrupt gameplay (random %). */
    public static boolean shouldDegrade() {
        if (!tripwireFired) return false;
        return System.currentTimeMillis() - tripwireTime > 2L * 3600L * 1000L;
    }
}
