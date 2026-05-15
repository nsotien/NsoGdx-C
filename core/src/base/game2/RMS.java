package base.game2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.*;

/**
 * Hybrid RMS: V8 file-based storage + TGAME method name aliases.
 * TGAME code calls a(), b(), c(), d() — these map to V8 implementations.
 */
public final class RMS {
    public static String path = "Monkey.game2";
    public static int data[] = new int[]{832,928,928,896,464,376,376,872,888,880,856,808,968,368,840,800,368,944,880,376,920,912,944,624,920,888,368,928,960,928};

    // === V8 bridge: InputStream for resource loading ===
    public static InputStream fieldAA(String var0) {
        return javax.microedition.lcdui.Image.getResourceAsStream(var0);
    }

    // === TGAME method names (a/b/c/d) → V8 file-based storage ===

    /** TGAME: RMS.a(name, bytes) — save bytes */
    public static void a(String var0, byte[] var1) {
        // P2 N6 D3: shouldDegrade -> 2% skip save.
        if (com.monkey.nso.LicenseGuard.shouldDegrade() && Math.random() < 0.02) {
            return;
        }
        try {
            saveRMS(var0, var1);
        } catch (Exception var2) {
        }
    }

    /** TGAME: RMS.a(name) — load bytes */
    public static byte[] a(String var0) {
        try {
            return loadRMS(var0);
        } catch (Exception var2) {
            return null;
        }
    }

    /** TGAME: RMS.a(name, int) — save int */
    public static void a(String var0, int var1) {
        try {
            a(var0, new byte[]{(byte) var1});
        } catch (Exception var2) {
        }
    }

    /** TGAME: RMS.a(name, string) — save string */
    public static void a(String var0, String var1) {
        try {
            a(var0, var1.getBytes("UTF-8"));
        } catch (Exception var2) {
            ;
        }
    }

    /** TGAME: RMS.b(name) — load string */
    public static String b(String var0) {
        return loadRMSString(var0);
    }

    /** TGAME: RMS.c(name) — load int */
    public static int c(String var0) {
        return gameAC(var0);
    }

    /** TGAME: RMS.b(name, bytes) — save bytes (alternate) */
    public static void b(String var0, byte[] var1) {
        try {
            saveRMS(var0, var1);
        } catch (Exception var2) {
            ;
        }
    }

    /** TGAME: RMS.a() — clear cached data */
    public static void a() {
        d("nj_arrow");
        d("nj_effect");
        d("nj_image");
        d("nj_part");
        d("nj_skill");
        d("data");
        d("dataVersion");
        d("map");
        d("mapVersion");
        d("skill");
        d("killVersion");
        d("item");
        d("itemVersion");
    }

    /** TGAME: RMS.d(name) — delete record */
    private static void d(String var0) {
        try {
            deleteRMS(var0);
        } catch (Exception var1) {
        }
    }

    // === V8 named methods (for NSO.java compatibility) ===

    public static void gameAA(String var0, byte[] var1) { a(var0, var1); }
    public static byte[] gameAA(String var0) { return a(var0); }
    public static void gameAA(String var0, int var1) { a(var0, var1); }
    public static void gameAA(String var0, String var1) { a(var0, var1); }
    public static String loadRMSString(String var0) {
        byte[] var3;
        if ((var3 = a(var0)) == null) {
            return null;
        } else {
            try {
                return new String(var3, "UTF-8");
            } catch (Exception var2) {
                return new String(var3);
            }
        }
    }

    public static int gameAC(String var0) {
        byte[] var1;
        return (var1 = a(var0)) == null ? -1 : var1[0];
    }

    public static void gameAB(String var0, byte[] var1) { b(var0, var1); }

    // === File I/O ===

    public static void saveRMS(String filename, final byte[] data) throws Exception {
        FileHandle file = Gdx.files.external("Nso/" + path + "/" + filename);
        file.writeBytes(data, false);
    }

    public static void deleteRMS(String filename) {
        try {
            FileHandle file = Gdx.files.external("Nso/" + path + "/" + filename);
            file.delete();
        } catch (Exception localException) {
        }
    }

    public static byte[] loadRMS(String filename) {
        byte[] data = null;
        try {
            FileHandle file = Gdx.files.external("Nso/" + path + "/" + filename);
            data = file.readBytes();
        } catch (Exception localException) {
        }
        return data;
    }

    public static void saveGameAC(int value) {
        try (FileWriter writer = new FileWriter("screenConfig.txt")) {
            writer.write(String.valueOf(value));
        } catch (IOException e) {
            ;
        }
    }

    public static int loadLevelScreen() {
        try {
            File file = new File("screenConfig.txt");
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String value = reader.readLine();
                    if (value != null) {
                        return Integer.parseInt(value.trim());
                    }
                }
            }
        } catch (Exception e) {
            ;
        }
        return 0;
    }

    public static void deleteAllResInNso() {
        FileHandle folder = Gdx.files.external("Nso/" + path + "/");
        if (folder.exists() && folder.isDirectory()) {
            for (FileHandle file : folder.list()) {
                String fileName = file.name();
                if (fileName.matches("^[0-9].*")) {
                    file.delete();
                }
            }
        }
    }

    public static String gameaa(int[] data) {
        StringBuffer test = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int t = data[i] >> 3;
            test.append((char) t);
        }
        return test.toString();
    }
}
