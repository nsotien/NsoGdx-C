package com.monkey.nso;

/**
 * String Cipher — AES-CBC + HMAC-SHA256 (encrypt-then-MAC).
 *
 * Lý do dùng CBC+HMAC thay GCM: RoboVM/iOS không support AES/GCM/NoPadding,
 * trong khi AES/CBC/PKCS5Padding hoạt động ổn định trên cả Android, PC, iOS.
 * Security tương đương GCM (cùng họ AEAD encrypt-then-MAC).
 *
 * Format: Base64( [16-byte IV] [N-byte ciphertext] [32-byte HMAC-SHA256] )
 *   - HMAC tính trên (IV || ciphertext) với macKey = SHA-256(K)
 *   - AES key = K (32 bytes, AES-256)
 *
 * Encode: build-tool/server.js scEncryptAesCbcHmac()
 * Decode: Bridge.d() trong game (runtime)
 */
public final class Bridge {

    // K — 32 bytes AES-256 key. Build Tool overwrite array literal nay truoc moi build.
    private static final byte[] K = {
        (byte)0x54, (byte)0x7C, (byte)0x52, (byte)0x85, (byte)0x6E, (byte)0x53, (byte)0xA2, (byte)0x83,
        (byte)0xBC, (byte)0xBD, (byte)0x6B, (byte)0x38, (byte)0xAF, (byte)0x30, (byte)0xA7, (byte)0xEE,
        (byte)0xC0, (byte)0xE5, (byte)0x2B, (byte)0x32, (byte)0xF9, (byte)0xD2, (byte)0x92, (byte)0xDD,
        (byte)0x50, (byte)0x68, (byte)0x4C, (byte)0x45, (byte)0x17, (byte)0x03, (byte)0xA2, (byte)0xAB,
    };

    private static final int IV_LEN = 16;   // AES-CBC block size
    private static final int HMAC_LEN = 32; // HMAC-SHA256

    public static String d(String encoded) {
        try {
            byte[] data = b64decode(encoded);
            if (data.length < IV_LEN + HMAC_LEN + 1) return "";

            int ctLen = data.length - IV_LEN - HMAC_LEN;
            byte[] iv = new byte[IV_LEN];
            System.arraycopy(data, 0, iv, 0, IV_LEN);
            byte[] ciphertext = new byte[ctLen];
            System.arraycopy(data, IV_LEN, ciphertext, 0, ctLen);
            byte[] tag = new byte[HMAC_LEN];
            System.arraycopy(data, IV_LEN + ctLen, tag, 0, HMAC_LEN);

            // 1. Verify HMAC (encrypt-then-MAC: check tag truoc khi decrypt)
            byte[] macKey = java.security.MessageDigest.getInstance("SHA-256").digest(K);
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
            mac.init(new javax.crypto.spec.SecretKeySpec(macKey, "HmacSHA256"));
            mac.update(iv);
            mac.update(ciphertext);
            byte[] expected = mac.doFinal();
            if (!constantTimeEquals(expected, tag)) return "";

            // 2. AES-CBC decrypt
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            javax.crypto.spec.SecretKeySpec keySpec = new javax.crypto.spec.SecretKeySpec(K, "AES");
            javax.crypto.spec.IvParameterSpec ivSpec = new javax.crypto.spec.IvParameterSpec(iv);
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] plain = cipher.doFinal(ciphertext);
            return new String(plain, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    private static boolean constantTimeEquals(byte[] a, byte[] b) {
        if (a == null || b == null || a.length != b.length) return false;
        int r = 0;
        for (int i = 0; i < a.length; i++) r |= (a[i] ^ b[i]);
        return r == 0;
    }

    /**
     * Base64 decode — tu viet (J2ME compatible, khong dung java.util.Base64).
     */
    private static byte[] b64decode(String s) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        s = s.replace("\n", "").replace("\r", "").replace(" ", "");
        int pad = 0;
        if (s.endsWith("==")) pad = 2;
        else if (s.endsWith("=")) pad = 1;

        int len = (s.length() * 3) / 4 - pad;
        byte[] result = new byte[len];
        int idx = 0;

        for (int i = 0; i < s.length(); i += 4) {
            int a = s.charAt(i) == '=' ? 0 : chars.indexOf(s.charAt(i));
            int b = (i + 1 < s.length() && s.charAt(i + 1) != '=') ? chars.indexOf(s.charAt(i + 1)) : 0;
            int c = (i + 2 < s.length() && s.charAt(i + 2) != '=') ? chars.indexOf(s.charAt(i + 2)) : 0;
            int d = (i + 3 < s.length() && s.charAt(i + 3) != '=') ? chars.indexOf(s.charAt(i + 3)) : 0;

            int triple = (a << 18) | (b << 12) | (c << 6) | d;

            if (idx < len) result[idx++] = (byte) ((triple >> 16) & 0xFF);
            if (idx < len) result[idx++] = (byte) ((triple >> 8) & 0xFF);
            if (idx < len) result[idx++] = (byte) (triple & 0xFF);
        }
        return result;
    }
}
