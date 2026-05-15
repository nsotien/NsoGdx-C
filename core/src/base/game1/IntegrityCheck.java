package base.game1;

import com.badlogic.gdx.Gdx;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * SHA-256 hash of the game file for integrity verification.
 * - APK: hash of the APK file
 * - EXE: hash of the EXE file
 * - iOS: skip (return null)
 */
public final class IntegrityCheck {

    private static String cachedHash = null;

    /**
     * Get SHA-256 hash of game file.
     * Returns null on iOS or if hash cannot be computed.
     */
    public static String getHash() {
        if (cachedHash != null) return cachedHash;

        try {
            // Desktop: hash the JAR/EXE file
            if (Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.Desktop) {
                String jarPath = IntegrityCheck.class.getProtectionDomain()
                        .getCodeSource().getLocation().toURI().getPath();
                cachedHash = sha256File(jarPath);
                return cachedHash;
            }

            // Android: hash the APK file
            if (Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.Android) {
                // APK path set by AndroidLauncher
                String apkPath = System.getProperty("integrity.apk.path");
                if (apkPath != null) {
                    cachedHash = sha256File(apkPath);
                    return cachedHash;
                }
            }

            // iOS: skip
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String sha256File(String path) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(new File(path));
        byte[] buffer = new byte[8192];
        int read;
        while ((read = fis.read(buffer)) != -1) {
            digest.update(buffer, 0, read);
        }
        fis.close();

        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
