package com.monkey.nso;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Remote server configuration loader.
 * Fetches server IP list from a remote URL so all client versions
 * auto-update without rebuilding.
 *
 * Format of remote file:
 *   ServerName1:IP1:Port1:ServerLogin1:Language1,ServerName2:IP2:Port2:ServerLogin2:Language2
 * Example:
 *   NinjaSchool:103.45.67.89:14444:0:0,NinjaSchool2:103.45.67.90:14444:1:0
 */
public class RemoteConfig {

    // ============================================================
    // THAY DOI URL NAY THANH URL HOSTING CUA BAN
    // Change this URL to your hosting URL where server_config.txt is hosted
    // ============================================================
    private static final String CONFIG_URL = "https://gist.githubusercontent.com/cuongcxz1010-hue/4da50f5f4a564abfb30464a1840197e6/raw/server_config.txt";

    // Fallback IP khi khong ket noi duoc remote
    private static final String FALLBACK_CONFIG = "Local:127.0.0.1:14444:0:0";

    // Cache ket qua, chia se giua tat ca game module
    private static String cachedConfig = null;
    private static boolean hasFetched = false;

    /**
     * Lay danh sach server tu remote URL.
     * - Neu da fetch roi thi tra ve cache (tranh goi nhieu lan)
     * - Neu fetch that bai thi dung fallback
     *
     * @return Server config string, format: "name:ip:port:login:lang,name:ip:port:login:lang"
     */
    public static synchronized String getServerConfig() {
        if (hasFetched && cachedConfig != null && !cachedConfig.isEmpty()) {
            return cachedConfig;
        }

        String remoteConfig = fetchFromUrl(CONFIG_URL);

        if (remoteConfig != null && !remoteConfig.trim().isEmpty()) {
            // Thanh cong - luu cache
            cachedConfig = remoteConfig.trim();
            hasFetched = true;
            System.out.println("[RemoteConfig] Loaded from remote: " + cachedConfig);
            return cachedConfig;
        }

        // Fetch that bai - dung fallback
        System.out.println("[RemoteConfig] Remote fetch failed, using fallback");
        cachedConfig = FALLBACK_CONFIG;
        hasFetched = true;
        return cachedConfig;
    }

    /**
     * Xoa cache de lan goi tiep theo se fetch lai tu remote.
     * Goi ham nay khi muon force refresh danh sach server.
     */
    public static synchronized void clearCache() {
        cachedConfig = null;
        hasFetched = false;
    }

    /**
     * Lay URL hien tai dang dung de fetch config.
     */
    public static String getConfigUrl() {
        return CONFIG_URL;
    }

    /**
     * Fetch noi dung tu URL bang HttpURLConnection.
     * Timeout: 5 giay connect, 5 giay read.
     */
    private static String fetchFromUrl(String urlStr) {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (NSOClient) AppleWebKit/537.36");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("[RemoteConfig] HTTP error: " + responseCode);
                return null;
            }

            reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                // Bo qua dong comment (bat dau bang #) va dong trong
                if (!trimmed.isEmpty() && !trimmed.startsWith("#")) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(trimmed);
                }
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println("[RemoteConfig] Fetch error: " + e.getMessage());
            return null;
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (Exception ignored) {}
            if (conn != null) conn.disconnect();
        }
    }
}
