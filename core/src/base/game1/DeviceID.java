package base.game1;

/**
 * Platform-specific Device ID.
 * Set by platform launcher before game starts:
 *   - Desktop: DesktopLauncher sets via wmic disk+cpu+installdate → SHA-256
 *   - Android: AndroidLauncher sets via Settings.Secure.ANDROID_ID
 *   - iOS: không dùng (empty string)
 */
public final class DeviceID {

    private static String deviceId = "";

    /**
     * Called by platform-specific launcher at startup.
     */
    public static void set(String id) {
        deviceId = (id != null) ? id : "";
    }

    /**
     * Get device ID. Returns empty string if not set (iOS).
     */
    public static String get() {
        return deviceId;
    }
}
