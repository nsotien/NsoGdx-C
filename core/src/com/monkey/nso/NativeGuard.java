package com.monkey.nso;

/**
 * Phase 3 N1 native module wrapper.
 *
 * Phase 3A (current): scaffold — chi co isLoaded() = true neu System.loadLibrary thanh cong.
 *                     gateState() van return 0 -> LicenseGuard.checkNative fall back Java.
 * Phase 3C: implement markVerifiedNativeImpl + gateStateImpl trong nsoguard.cpp -> gateState non-zero.
 * Phase 3D: Build Tool inject __NS_K1..K4__ random per-build truoc khi compile.
 *
 * Native lib name: nsoguard
 *   - Android: libnsoguard.so trong /lib/<ABI>/ (auto-loaded tu APK)
 *   - Desktop Windows: nsoguard.dll trong java.library.path (set boi Build Tool / jpackage)
 *
 * Loading:
 *   - System.loadLibrary("nsoguard") trong static init.
 *   - Try/catch UnsatisfiedLinkError -> isLoaded = false -> fall back Java.
 *   - KHONG throw exception lua user — Phase 2 Java cross-check du chong amateur cracker.
 */
public final class NativeGuard {

    private NativeGuard() {}

    private static final boolean LOADED;

    static {
        boolean ok = false;
        try {
            // Android: lib auto-load tu /lib/<ABI>/libnsoguard.so qua System.loadLibrary
            // Desktop (PC): extract /native/nsoguard.dll tu JAR resource ra tmp file roi System.load(absPath)
            if (extractAndLoad()) {
                ok = isLoadedNative();
            } else {
                System.loadLibrary("nsoguard");
                ok = isLoadedNative();
            }
        } catch (Throwable t) {
            ok = false;
        }
        LOADED = ok;
    }

    private static boolean extractAndLoad() {
        String os = System.getProperty("os.name", "").toLowerCase();
        String resPath;
        String suffix;
        if (os.contains("win")) { resPath = "/native/nsoguard.dll"; suffix = ".dll"; }
        else if (os.contains("mac")) { resPath = "/native/libnsoguard.dylib"; suffix = ".dylib"; }
        else if (os.contains("linux")) { resPath = "/native/libnsoguard.so"; suffix = ".so"; }
        else { return false; }
        java.io.InputStream is = NativeGuard.class.getResourceAsStream(resPath);
        if (is == null) return false;
        java.io.File tmp = null;
        java.io.FileOutputStream fos = null;
        try {
            tmp = java.io.File.createTempFile("nsoguard", suffix);
            tmp.deleteOnExit();
            fos = new java.io.FileOutputStream(tmp);
            byte[] buf = new byte[8192];
            int n;
            while ((n = is.read(buf)) > 0) fos.write(buf, 0, n);
            fos.close(); fos = null;
            is.close();
            System.load(tmp.getAbsolutePath());
            return true;
        } catch (Throwable t) {
            return false;
        } finally {
            try { if (fos != null) fos.close(); } catch (Throwable ignored) {}
            try { is.close(); } catch (Throwable ignored) {}
        }
    }

    /** Phase 3A: tra true neu native lib load + JNI symbol resolved. */
    public static boolean isLoaded() {
        return LOADED;
    }

    /** Phase 3C: sync hash key sang native side sau khi LicenseGuard.markVerified. */
    public static void markVerifiedNative(int keyHash) {
        if (!LOADED) return;
        try {
            markVerifiedNativeImpl(keyHash);
        } catch (Throwable ignored) {}
    }

    /**
     * Phase 3C: native cross-check return token 64-bit.
     * High 32-bit != 0 = OK. Phase 3A nsoguard.cpp van return 0 -> Java fallback.
     */
    public static long gateState(int ctx) {
        if (!LOADED) return 0L;
        try {
            return gateStateImpl(ctx);
        } catch (Throwable ignored) {
            return 0L;
        }
    }

    /**
     * Phase 3B: derive AES key tu (deviceId, licenseKey, nonce, salt) qua SHA-256
     * + AES-256-CBC decrypt base64Data. Tra plaintext hoac null neu fail.
     *
     * Native side dung crypto rieng (sha256.c + aes.c) — KHONG goi javax.crypto.
     * Cracker decompile bytecode khong thay AES key derivation logic.
     *
     * Fallback: neu native chua load -> caller (LicenseVerifier) tu derive Java side.
     */
    public static String verifyResponse(String base64Data, String deviceId, String licenseKey, String nonce, String salt) {
        if (!LOADED) return null;
        try {
            return verifyResponseImpl(base64Data, deviceId, licenseKey, nonce, salt);
        } catch (Throwable ignored) {
            return null;
        }
    }

    // ============================================================
    // JNI declarations — implement trong core-native/src/nsoguard.cpp
    // ============================================================

    private static native boolean isLoadedNative();
    private static native void markVerifiedNativeImpl(int keyHash);
    private static native long gateStateImpl(int ctx);
    private static native String verifyResponseImpl(String base64Data, String deviceId, String licenseKey, String nonce, String salt);
}
