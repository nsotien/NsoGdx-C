package com.monkey.nso;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Source C stub — bypass API verify, read server list from Nso/server_config.txt.
 * TODO: replace with real LicenseVerifier after Source C stable.
 */
public final class LicenseVerifier {

    public static String serverList = "";
    public static String errorMessage = "";
    public static volatile boolean isVerified = false;

    public static String announcement1 = "";
    public static String announcement2 = "";
    public static String announcement3 = "";
    public static String hdsdContent = "";
    public static String banquyenContent = "";
    public static String updateNoticeMsg = "";
    public static String updateNoticeLink = "";

    public static final String CLIENT_VERSION = "1.0.0";
    public static final String BUILD_HASH = "source-c";
    public static final String BUILD_TIME = "2026-05-15";

    /**
     * Read server list from Nso/server_config.txt and set serverList.
     * Called from NSO.create() before GameMidlet is created.
     * Format: "Name:IP:Port:Type:Lang" one per line (# = comment).
     */
    public static void loadFromConfig() {
        try {
            FileHandle file = Gdx.files.internal("Nso/server_config.txt");
            if (!file.exists()) {
                serverList = "NinjaSchool:127.0.0.1:14444:0:0";
                isVerified = true;
                return;
            }
            String content = file.readString("UTF-8");
            StringBuilder sb = new StringBuilder();
            String[] lines = content.split("\n");
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                if (sb.length() > 0) sb.append(",");
                sb.append(line);
            }
            serverList = sb.length() > 0 ? sb.toString() : "NinjaSchool:127.0.0.1:14444:0:0";
            isVerified = true;
        } catch (Exception e) {
            serverList = "NinjaSchool:127.0.0.1:14444:0:0";
            isVerified = true;
        }
    }

    public static final String WORKER_URL_ENC_FOR_REPORTER = "";

    public static boolean verify() {
        loadFromConfig();
        return true;
    }

    public static String fetchServer(int sid) {
        return null;
    }

    public static String readKey() {
        return "source-c-test";
    }

    public static String getPlatform() {
        try {
            com.badlogic.gdx.Application.ApplicationType t = com.badlogic.gdx.Gdx.app.getType();
            if (t == com.badlogic.gdx.Application.ApplicationType.Android) return "android";
            if (t == com.badlogic.gdx.Application.ApplicationType.iOS) return "ios";
            return "desktop";
        } catch (Throwable e) { return "unknown"; }
    }
}
