package base.game2;

import com.badlogic.gdx.Gdx;
import com.monkey.nso.NSO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.microedition.midlet.MIDlet;

/**
 * Hybrid GameMidlet: TGAME logic + V8 LibGDX bridge.
 * TGAME field names (a, c, d, g, h, l, m, n, o, q) preserved for compatibility.
 * V8 named aliases added for NSO.java.
 */
public class GameMidlet extends MIDlet {
    // TGAME fields
    public static byte a = 1;        // CLIENT_TYPE
    public static int c = 14444;     // PORT
    public static String d = "";     // IP
    public static GameMidlet g;      // singleton (TGAME name)
    public static byte h = 0;        // serverLogin
    public static String[] l;        // nameServer
    public static String[] m;        // ipList
    public static short[] n;         // portList
    public static byte[] o;          // serverLoginList
    public static int[] q;           // server order

    // V8 aliases (for NSO.java compatibility)
    public static GameMidlet instance;
    public static byte CLIENT_TYPE = 1;
    public static byte indexClient = 0;
    public static int PORT = 14444;
    public static String IP = "";
    public static byte userProvider = 0;
    public static String clientAgent;
    public static int version;
    public static String[] nameServer;
    public static String[] ipList;
    public static short[] portList;
    public static byte[] serverLoginList;
    public static byte[] language;
    public static byte[] serverST;
    public static boolean isPlaySound = false;
    public static String latitude = "";
    public static String longitude = "";

    // TGAME no-arg constructor
    public GameMidlet() {
        this(0);
    }

    // V8 constructor (called by NSO.doitab(1))
    public GameMidlet(int ver) {
        try {
            DebugLog.log("GameMidlet", "Constructor start, ver=" + ver);
            if (!GameCanvas.m) {
                this.version = ver;
                DebugLog.log("GameMidlet", "Session_ME init...");
                Session_ME.a().a(Controller.a());
                g = this;
                instance = this;
                DebugLog.log("GameMidlet", "Creating GameCanvas...");
                (new GameCanvas()).c();
                DebugLog.log("GameMidlet", "GameCanvas OK");

                clientAgent = readFileText("agent.txt");
                try {
                    userProvider = Byte.parseByte(readFileText("provider.txt"));
                } catch (Exception e) {
                    userProvider = 0;
                }

                SplashScr.splashScrStat = 0;
                GameCanvas.currentScreen = new NewScr_1();
                gameAC();
                com.monkey.nso.SleepManager.registerProvider(2, new SleepInfoProvider());
                DebugLog.log("GameMidlet", "Init complete");
            }
            startApp();
        } catch (Exception e) {
            DebugLog.error("GameMidlet init failed", e);
        }
    }

    protected void destroyApp(boolean var1) {
    }

    protected void pauseApp() {
    }

    protected void startApp() {
        // Wire to NSO (V8 bridge)
        NSO.gameCanvas = MotherCanvas.gI();
    }

    // TGAME: GameMidlet.a() — exit
    public final void a() {
        GameCanvas.m = false;
        System.gc();
        this.notifyDestroyed();
    }

    // TGAME: GameMidlet.a(url) — open URL
    public static void a(String var0) {
        // platformRequest not available in LibGDX
    }

    // TGAME: GameMidlet.b(filename) — read file text
    public static String b(String var1) {
        return readFileText(var1);
    }

    private static String readFileText(String var0) {
        InputStream var3 = RMS.fieldAA("/" + var0);
        try {
            byte[] var1 = new byte[var3.available()];
            var3.read(var1);
            return new String(var1, "UTF-8");
        } catch (Exception var2) {
            return "";
        }
    }

    // TGAME: GameMidlet.g() — save server config
    public static void g() {
        ByteArrayOutputStream var0 = new ByteArrayOutputStream();
        DataOutputStream var1 = new DataOutputStream(var0);
        try {
            var1.writeByte(l.length);
            for (int var2 = 0; var2 < l.length; ++var2) {
                var1.writeUTF(l[var2]);
                var1.writeUTF(m[var2]);
                var1.writeShort(n[var2]);
                var1.writeByte(o[var2]);
                var1.writeInt(q[var2]);
                var1.writeByte(language != null && var2 < language.length ? language[var2] : 0);
            }
            RMS.a("NJlink", var0.toByteArray());
            var1.close();
            // [FIX 3] Append custom servers (file Nso/SharedCustomServers) TRƯỚC khi reload UI.
            // Custom CHỈ in-memory + file riêng — KHÔNG vào NJlink, license hash intact.
            CustomServerStore.load();
            CustomServerStore.merge();
            SelectServerScr.f();
        } catch (Exception var3) {
            ;
        }
    }

    // V8 alias
    public static void gameAG() { g(); }

    // TGAME: GameMidlet.c(url) — HTTP fetch (disabled, use local config)
    private static String c(String var0) {
        // HttpConnection not available in LibGDX, use HttpURLConnection
        HttpURLConnection var1 = null;
        BufferedReader var2 = null;
        String var3 = "";
        try {
            (var1 = (HttpURLConnection) (new URL(var0)).openConnection()).setConnectTimeout(3000);
            var1.setReadTimeout(3000);
            for (var2 = new BufferedReader(new InputStreamReader(var1.getInputStream(), "UTF-8"));
                 (var0 = var2.readLine()) != null; var3 = var3 + var0 + "\r\n") {
            }
        } catch (Exception var5) {
            var3 = null;
        } finally {
            try { if (var2 != null) var2.close(); } catch (Exception e) {}
            if (var1 != null) var1.disconnect();
        }
        return var3;
    }

    // V8: gameAC() — no-op. Server list nạp từ license API qua Client.fakeStart().
    public static void gameAC() {
    }

    // V8: gameAD() — load from cached RMS
    public static void gameAD() {
        byte[] var0;
        if ((var0 = RMS.a("NJlink")) == null) {
            gameAC();
        } else {
            ByteArrayInputStream var4 = new ByteArrayInputStream(var0);
            DataInputStream var5 = new DataInputStream(var4);
            try {
                byte var1 = var5.readByte();
                l = nameServer = new String[var1];
                m = ipList = new String[var1];
                n = portList = new short[var1];
                o = serverLoginList = new byte[var1];
                q = new int[var1];
                language = new byte[var1];
                serverST = new byte[var1];

                for (int var2 = 0; var2 < var1; ++var2) {
                    l[var2] = nameServer[var2] = var5.readUTF();
                    m[var2] = ipList[var2] = var5.readUTF();
                    n[var2] = portList[var2] = var5.readShort();
                    o[var2] = serverLoginList[var2] = var5.readByte();
                    q[var2] = var5.readInt();
                }
                var5.close();
                SelectServerScr.f();
            } catch (IOException var3) {
                ;
            }
        }
    }

    // V8 alias
    public final void gameAA() { a(); }
    public static void gameAA(String url) { a(url); }
    public final void gameAB() {
        // sendGPS not available in TGAME Service
    }

    public static int gameAE() {
        byte soundState = isPlaySound ? (byte) 1 : 0;
        if (language != null) {
            for (int i = 0; i < language.length; i++) {
                if (language[i] == soundState) return i;
            }
        }
        return 0;
    }

    public static int gameAF() {
        if (language != null) {
            for (int i = 0; i < language.length; i++) {
                if (language[i] == 1) return i - 1;
            }
            return language.length - 1;
        }
        return 0;
    }
}
