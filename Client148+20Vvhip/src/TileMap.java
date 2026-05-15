
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Image;

public final class TileMap {

    public static int tmw;
    public static int tmh;
    public static int pxw;
    public static int pxh;
    public static int gameAE;
    public static char[] gameAF;
    public static int[] gameAG;
    private static Image gameBG;
    private static Image gameBH;
    public static Image imgMiniMap;
    private static Image imgWaterfall;
    private static Image imgTopWaterfall;
    private static Image imgWaterflow;
    private static Image imgUnderWater;
    private static Image imgflowRiver;
    public static byte size = 24;
    private static int gameBN;
    private static int gameBO;
    public static String gameAJ = null;
    public static String mapName = "";
    public static byte zoneID;
    public static byte bgID;
    public static byte gameAN;
    public static short mapID;
    public static short gameAP;
    private static int cmtoYmini;
    private static int cmyMini;
    private static int cmdyMini;
    private static int cmvyMini;
    private static int cmtoXMini;
    private static int cmxMini;
    private static int cmdxMini;
    private static int cmvxMini;
    public static int wMiniMap;
    public static int hMiniMap;
    public static int posMiniMapX;
    public static int posMiniMapY;
    public static MyVector vGo = new MyVector();
    public static String[] mapNames;
    public static mHashtable gameAW = new mHashtable();
    public static mHashtable gameAX = new mHashtable();
    private static int gameBX;
    public static int sizeMiniMap = 2;
    public static int gameAZ;
    public static int gameBA;
    public static int gameBB;
    public static int gameBC;
    private static int[] colorMini = new int[]{5257738, 8807192};
    public static short[][] gameBZ = new short[160][];
    private static boolean[] gameCA = new boolean[160];
    private static int[] gameCB = new int[160];
    private static short[] gameCC = new short[160];
    public static int gameBD;
    public static boolean gameBE;
    public static boolean gameBF;
    private static Object gameCD;
    private static byte[][] gameCE;
    private static Image[] gameCF;
    private static Image[] gameCG;

    public static void gameAA(int var0, int var1, int var2, int var3) {
        wMiniMap = var2;
        hMiniMap = var3;
        posMiniMapX = var0;
        posMiniMapY = var1;
    }

    public static void gameAA() {
        cmtoXMini = Char.getMyChar().cx / 12;
        cmtoYmini = Char.getMyChar().cy / 12;
        if (cmtoXMini > tmw * sizeMiniMap - wMiniMap / 2) {
            cmtoXMini = tmw * sizeMiniMap - wMiniMap;
        } else if (cmtoXMini < wMiniMap / 2) {
            cmtoXMini = 0;
        } else {
            cmtoXMini -= wMiniMap / 2;
        }

        if (cmtoYmini < hMiniMap / 2) {
            cmtoYmini = 0;
        } else {
            cmtoYmini -= hMiniMap / 2;
        }

        if (cmtoYmini > tmh * sizeMiniMap - hMiniMap) {
            cmtoYmini = tmh * sizeMiniMap - hMiniMap;
        }

    }

    public static void gameAB() {
        if (tmw * sizeMiniMap >= wMiniMap || tmh * sizeMiniMap >= hMiniMap) {
            if (cmyMini != cmtoYmini) {
                cmvyMini = cmtoYmini - cmyMini << 2;
                cmdyMini += cmvyMini;
                cmyMini += cmdyMini >> 4;
                cmdyMini &= 15;
            }

            if (cmxMini != cmtoXMini) {
                cmvxMini = cmtoXMini - cmxMini << 2;
                cmdxMini += cmvxMini;
                cmxMini += cmdxMini >> 4;
                cmdxMini &= 15;
            }
        }

    }

    public static void gameAC() {
        gameBG = null;
        System.gc();
    }

    static final void gameAD() {
        if (imgUnderWater == null) {
            imgUnderWater = GameCanvas.gameAC("/t/uwt.png");
        }

        if (imgWaterfall == null) {
            imgWaterfall = GameCanvas.gameAC("/t/wtf.png");
        }

        if (imgTopWaterfall == null) {
            imgTopWaterfall = GameCanvas.gameAC("/t/twtf.png");
        }

        if (imgWaterflow == null) {
            imgWaterflow = GameCanvas.gameAC("/t/wts.png");
        }

        if (imgflowRiver == null) {
            imgflowRiver = GameCanvas.gameAC("/t/wts1.png");
        }

        System.gc();
    }

    public static void gameAA(int var0) {
        pxh = tmh * size;
        pxw = tmw * size;

        try {
            for (int var1 = 0; var1 < tmw * tmh; ++var1) {
                int[] var10000;
                if (gameAW != null && gameAW.get(String.valueOf(var1)) != null) {
                    var10000 = gameAG;
                    var10000[var1] |= 2;
                }

                if (var0 == 4) {
                    if (gameAF[var1] == 1 || gameAF[var1] == 2 || gameAF[var1] == 3 || gameAF[var1] == 4 || gameAF[var1] == 5 || gameAF[var1] == 6 || gameAF[var1] == '\t' || gameAF[var1] == '\n' || gameAF[var1] == 'O' || gameAF[var1] == 'P' || gameAF[var1] == '\r' || gameAF[var1] == 14 || gameAF[var1] == '+' || gameAF[var1] == ',' || gameAF[var1] == '-' || gameAF[var1] == '2') {
                        var10000 = gameAG;
                        var10000[var1] |= 2;
                    }

                    if (gameAF[var1] == '\t' || gameAF[var1] == 11) {
                        var10000 = gameAG;
                        var10000[var1] |= 4;
                    }

                    if (gameAF[var1] == '\n' || gameAF[var1] == '\f') {
                        var10000 = gameAG;
                        var10000[var1] |= 8;
                    }

                    if (gameAF[var1] == '\r' || gameAF[var1] == 14) {
                        var10000 = gameAG;
                        var10000[var1] |= 1024;
                    }

                    if (gameAF[var1] == 'L' || gameAF[var1] == 'M') {
                        var10000 = gameAG;
                        var10000[var1] |= 64;
                        if (gameAF[var1] == 'N') {
                            var10000 = gameAG;
                            var10000[var1] |= 4096;
                        }
                    }
                }

                if (var0 == 1) {
                    if (gameAF[var1] == 22) {
                        gameBX = gameAF[var1] - 1;
                    }

                    if (gameAF[var1] == 1 || gameAF[var1] == 2 || gameAF[var1] == 3 || gameAF[var1] == 4 || gameAF[var1] == 5 || gameAF[var1] == 6 || gameAF[var1] == 7 || gameAF[var1] == '$' || gameAF[var1] == '%' || gameAF[var1] == '6' || gameAF[var1] == '[' || gameAF[var1] == '\\' || gameAF[var1] == ']' || gameAF[var1] == '^' || gameAF[var1] == 'I' || gameAF[var1] == 'J' || gameAF[var1] == 'a' || gameAF[var1] == 'b' || gameAF[var1] == 't' || gameAF[var1] == 'u' || gameAF[var1] == 'v' || gameAF[var1] == 'x' || gameAF[var1] == '=') {
                        var10000 = gameAG;
                        var10000[var1] |= 2;
                    }

                    if (gameAF[var1] == 2 || gameAF[var1] == 3 || gameAF[var1] == 4 || gameAF[var1] == 5 || gameAF[var1] == 6 || gameAF[var1] == 20 || gameAF[var1] == 21 || gameAF[var1] == 22 || gameAF[var1] == 23 || gameAF[var1] == '$' || gameAF[var1] == '%' || gameAF[var1] == '&' || gameAF[var1] == '\'' || gameAF[var1] == '=') {
                        var10000 = gameAG;
                        var10000[var1] |= 4096;
                    }

                    if (gameAF[var1] == '\b' || gameAF[var1] == '\t' || gameAF[var1] == '\n' || gameAF[var1] == '\f' || gameAF[var1] == '\r' || gameAF[var1] == 14 || gameAF[var1] == 30) {
                        var10000 = gameAG;
                        var10000[var1] |= 16;
                    }

                    if (gameAF[var1] == 17) {
                        var10000 = gameAG;
                        var10000[var1] |= 32;
                    }

                    if (gameAF[var1] == 18) {
                        var10000 = gameAG;
                        var10000[var1] |= 128;
                    }

                    if (gameAF[var1] == '%' || gameAF[var1] == '&' || gameAF[var1] == '=') {
                        var10000 = gameAG;
                        var10000[var1] |= 4;
                    }

                    if (gameAF[var1] == '$' || gameAF[var1] == '\'' || gameAF[var1] == '=') {
                        var10000 = gameAG;
                        var10000[var1] |= 8;
                    }

                    if (gameAF[var1] == 19) {
                        var10000 = gameAG;
                        var10000[var1] |= 64;
                        if ((gameAG[var1 - tmw] & 4096) == 4096) {
                            var10000 = gameAG;
                            var10000[var1] |= 4096;
                        }
                    }

                    if (gameAF[var1] == '#') {
                        var10000 = gameAG;
                        var10000[var1] |= 2048;
                    }

                    if (gameAF[var1] == 7) {
                        var10000 = gameAG;
                        var10000[var1] |= 1024;
                    }

                    if (gameAF[var1] == ' ' || gameAF[var1] == '!' || gameAF[var1] == '"') {
                        var10000 = gameAG;
                        var10000[var1] |= 256;
                    }
                }

                if (var0 == 2) {
                    if (gameAF[var1] == 22 || gameAF[var1] == 'g' || gameAF[var1] == 'o') {
                        gameBX = gameAF[var1] - 1;
                    }

                    if (gameAF[var1] == 1 || gameAF[var1] == 2 || gameAF[var1] == 3 || gameAF[var1] == 4 || gameAF[var1] == 5 || gameAF[var1] == 6 || gameAF[var1] == 7 || gameAF[var1] == '$' || gameAF[var1] == '%' || gameAF[var1] == '6' || gameAF[var1] == '=' || gameAF[var1] == 'I' || gameAF[var1] == 'L' || gameAF[var1] == 'M' || gameAF[var1] == 'N' || gameAF[var1] == 'O' || gameAF[var1] == 'R' || gameAF[var1] == 'S' || gameAF[var1] == 'b' || gameAF[var1] == 'c' || gameAF[var1] == 'd' || gameAF[var1] == 'f' || gameAF[var1] == 'g' || gameAF[var1] == 'l' || gameAF[var1] == 'm' || gameAF[var1] == 'n' || gameAF[var1] == 'p' || gameAF[var1] == 'q' || gameAF[var1] == 't' || gameAF[var1] == 'u' || gameAF[var1] == '}' || gameAF[var1] == '~' || gameAF[var1] == 127 || gameAF[var1] == 129 || gameAF[var1] == 130) {
                        var10000 = gameAG;
                        var10000[var1] |= 2;
                    }

                    if (gameAF[var1] == 1 || gameAF[var1] == 3 || gameAF[var1] == 4 || gameAF[var1] == 5 || gameAF[var1] == 6 || gameAF[var1] == 20 || gameAF[var1] == 21 || gameAF[var1] == 22 || gameAF[var1] == 23 || gameAF[var1] == '$' || gameAF[var1] == '%' || gameAF[var1] == '&' || gameAF[var1] == '\'' || gameAF[var1] == '7' || gameAF[var1] == 'm' || gameAF[var1] == 'o' || gameAF[var1] == 'p' || gameAF[var1] == 'q' || gameAF[var1] == 'r' || gameAF[var1] == 's' || gameAF[var1] == 't' || gameAF[var1] == 127 || gameAF[var1] == 129 || gameAF[var1] == 130) {
                        var10000 = gameAG;
                        var10000[var1] |= 4096;
                    }

                    if (gameAF[var1] == '\b' || gameAF[var1] == '\t' || gameAF[var1] == '\n' || gameAF[var1] == '\f' || gameAF[var1] == '\r' || gameAF[var1] == 14 || gameAF[var1] == 30 || gameAF[var1] == 135) {
                        var10000 = gameAG;
                        var10000[var1] |= 16;
                    }

                    if (gameAF[var1] == 17) {
                        var10000 = gameAG;
                        var10000[var1] |= 32;
                    }

                    if (gameAF[var1] == 18) {
                        var10000 = gameAG;
                        var10000[var1] |= 128;
                    }

                    if (gameAF[var1] == '=' || gameAF[var1] == '%' || gameAF[var1] == '&' || gameAF[var1] == 127 || gameAF[var1] == 130 || gameAF[var1] == 131) {
                        var10000 = gameAG;
                        var10000[var1] |= 4;
                    }

                    if (gameAF[var1] == '=' || gameAF[var1] == '$' || gameAF[var1] == '\'' || gameAF[var1] == 127 || gameAF[var1] == 129 || gameAF[var1] == 132) {
                        var10000 = gameAG;
                        var10000[var1] |= 8;
                    }

                    if (gameAF[var1] == 19) {
                        var10000 = gameAG;
                        var10000[var1] |= 64;
                        if ((gameAG[var1 - tmw] & 4096) == 4096) {
                            var10000 = gameAG;
                            var10000[var1] |= 4096;
                        }
                    }

                    if (gameAF[var1] == 134) {
                        var10000 = gameAG;
                        var10000[var1] |= 64;
                        if ((gameAG[var1 - tmw] & 4096) == 4096) {
                            var10000 = gameAG;
                            var10000[var1] |= 4096;
                        }
                    }

                    if (gameAF[var1] == '#') {
                        var10000 = gameAG;
                        var10000[var1] |= 2048;
                    }

                    if (gameAF[var1] == 7) {
                        var10000 = gameAG;
                        var10000[var1] |= 1024;
                    }

                    if (gameAF[var1] == ' ' || gameAF[var1] == '!' || gameAF[var1] == '"') {
                        var10000 = gameAG;
                        var10000[var1] |= 256;
                    }

                    if (gameAF[var1] == '=' || gameAF[var1] == 127) {
                        var10000 = gameAG;
                        var10000[var1] |= 8192;
                    }
                }

                if (var0 == 3) {
                    if (gameAF[var1] == '\f' || gameAF[var1] == '3' || gameAF[var1] == 'X' || gameAF[var1] == 't' || gameAF[var1] == 128) {
                        gameBX = gameAF[var1] - 1;
                    }

                    if (gameAF[var1] == 'm' || gameAF[var1] == 'n') {
                        gameBX = gameAF[var1];
                    }

                    if (gameAF[var1] == 1 || gameAF[var1] == 2 || gameAF[var1] == 3 || gameAF[var1] == 4 || gameAF[var1] == 5 || gameAF[var1] == 6 || gameAF[var1] == 7 || gameAF[var1] == 11 || gameAF[var1] == 14 || gameAF[var1] == 17 || gameAF[var1] == '+' || gameAF[var1] == '3' || gameAF[var1] == '?' || gameAF[var1] == 'A' || gameAF[var1] == 'C' || gameAF[var1] == 'D' || gameAF[var1] == 'G' || gameAF[var1] == 'H' || gameAF[var1] == 'S' || gameAF[var1] == 'T' || gameAF[var1] == 'U' || gameAF[var1] == 'W' || gameAF[var1] == '[' || gameAF[var1] == '^' || gameAF[var1] == 'a' || gameAF[var1] == 'b' || gameAF[var1] == 'j' || gameAF[var1] == 'k' || gameAF[var1] == 'o' || gameAF[var1] == 'q' || gameAF[var1] == 'u' || gameAF[var1] == 'v' || gameAF[var1] == 'w' || gameAF[var1] == '}' || gameAF[var1] == '~' || gameAF[var1] == 129 || gameAF[var1] == 130 || gameAF[var1] == 131 || gameAF[var1] == 133 || gameAF[var1] == 136 || gameAF[var1] == 138 || gameAF[var1] == 139 || gameAF[var1] == 142) {
                        var10000 = gameAG;
                        var10000[var1] |= 2;
                    }

                    if (gameAF[var1] == '|' || gameAF[var1] == 't' || gameAF[var1] == '{' || gameAF[var1] == ',' || gameAF[var1] == '\f' || gameAF[var1] == 15 || gameAF[var1] == 16 || gameAF[var1] == '-' || gameAF[var1] == '\n' || gameAF[var1] == '\t') {
                        var10000 = gameAG;
                        var10000[var1] |= 4096;
                    }

                    if (gameAF[var1] == 23) {
                        var10000 = gameAG;
                        var10000[var1] |= 32;
                    }

                    if (gameAF[var1] == 24) {
                        var10000 = gameAG;
                        var10000[var1] |= 128;
                    }

                    if (gameAF[var1] == 6 || gameAF[var1] == 15 || gameAF[var1] == '3' || gameAF[var1] == '_' || gameAF[var1] == 'a' || gameAF[var1] == 'j' || gameAF[var1] == 'o' || gameAF[var1] == '{' || gameAF[var1] == '}' || gameAF[var1] == 138 || gameAF[var1] == 140) {
                        var10000 = gameAG;
                        var10000[var1] |= 4;
                    }

                    if (gameAF[var1] == 7 || gameAF[var1] == 16 || gameAF[var1] == '3' || gameAF[var1] == '`' || gameAF[var1] == 'b' || gameAF[var1] == 'k' || gameAF[var1] == 'o' || gameAF[var1] == '|' || gameAF[var1] == '~' || gameAF[var1] == 139 || gameAF[var1] == 141) {
                        var10000 = gameAG;
                        var10000[var1] |= 8;
                    }

                    if (gameAF[var1] == 25) {
                        var10000 = gameAG;
                        var10000[var1] |= 64;
                        if ((gameAG[var1 - tmw] & 4096) == 4096) {
                            var10000 = gameAG;
                            var10000[var1] |= 4096;
                        }
                    }

                    if (gameAF[var1] == '"') {
                        var10000 = gameAG;
                        var10000[var1] |= 2048;
                    }

                    if (gameAF[var1] == 17) {
                        var10000 = gameAG;
                        var10000[var1] |= 1024;
                    }

                    if (gameAF[var1] == '!' || gameAF[var1] == 'g' || gameAF[var1] == 'h' || gameAF[var1] == 'i' || gameAF[var1] == 26 || gameAF[var1] == '!') {
                        var10000 = gameAG;
                        var10000[var1] |= 256;
                    }

                    if (gameAF[var1] == '3' || gameAF[var1] == 'o' || gameAF[var1] == 'D') {
                        var10000 = gameAG;
                        var10000[var1] |= 8192;
                    }

                    if (gameAF[var1] == 'R' || gameAF[var1] == 'n' || gameAF[var1] == 143) {
                        var10000 = gameAG;
                        var10000[var1] |= 16384;
                    }

                    if (gameAF[var1] == 'q') {
                        var10000 = gameAG;
                        var10000[var1] |= 65536;
                    }

                    if (gameAF[var1] == 142) {
                        var10000 = gameAG;
                        var10000[var1] |= 32768;
                    }

                    if (gameAF[var1] == '(' || gameAF[var1] == ')') {
                        var10000 = gameAG;
                        var10000[var1] |= 131072;
                    }

                    if (gameAF[var1] == 'n') {
                        var10000 = gameAG;
                        var10000[var1] |= 262144;
                    }

                    if (gameAF[var1] == 143) {
                        var10000 = gameAG;
                        var10000[var1] |= 524288;
                    }
                }
            }

            imgMiniMap = Image.createImage(tmw * sizeMiniMap * mGraphics.zoomLevel, tmh * sizeMiniMap * mGraphics.zoomLevel);
            mGraphics var5;
            (var5 = new mGraphics(imgMiniMap.getGraphics())).gameAA(0);
            var5.gameAD(0, 0, tmw * sizeMiniMap, tmh * sizeMiniMap);

            for (var0 = 0; var0 < tmw; ++var0) {
                for (int var6 = 0; var6 < tmh; ++var6) {
                    int var3;
                    if ((var3 = gameAF[var6 * tmw + var0] - 1) != -1) {
                        var5.gameAA(gameBH, 0, var3 * sizeMiniMap, sizeMiniMap, sizeMiniMap, 0, var0 * sizeMiniMap, var6 * sizeMiniMap, 0);
                    }
                }
            }

            if (!GameCanvas.gameAA) {
                if (mapID == 0 || mapID <= 4 || mapID >= 16 && mapID <= 18 || mapID >= 24 && mapID <= 27 || mapID == 22 || mapID == 33 || mapID == 34 || mapID == 38 || mapID == 57 || mapID == 58 || mapID == 60 || mapID == 68 || mapID >= 70 && mapID <= 75 || mapID == 81) {
                    Effect2.vAnimateEffect.addElement(new AnimateEffect((byte) 1, 10));
                }

                if (mapID >= 39 && mapID <= 44 || mapID >= 46 && mapID <= 48 || mapID == 56 || mapID >= 62 && mapID <= 65) {
                    Effect2.vAnimateEffect.addElement(new AnimateEffect((byte) 3, Res.gameAB(150, 200)));
                    return;
                }
            }

        } catch (Exception var4) {
            System.out.println("Error Load Map");
            var4.printStackTrace();
            GameMidlet var2 = GameMidlet.instance;
            MotherCanvas.gameAC = false;
            System.gc();
            var2.notifyDestroyed();
        }
    }

    public static final void gameAA(mGraphics var0) {
        for (int var1 = GameScr.gssx; var1 < GameScr.gssxe; ++var1) {
            for (int var2 = GameScr.gameAN; var2 < GameScr.gssye; ++var2) {
                int var3 = gameAF[var2 * tmw + var1] - 1;
                if ((gameAG(var1, var2) & 256) != 256) {
                    if (gameAE == 4 && (gameAG(var1, var2) & 64) == 64) {
                        var3 = var2 - 1;
                        if ((var3 = gameAF[var3 * tmw + var1] - 1) == 15) {
                            var0.gameAA(gameBG, 0, 17 * size, 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if (var3 == 5) {
                            var0.gameAA(gameBG, 0, 7 * size, 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if (var3 == 18 || var3 == 22 || var3 == 15) {
                            var0.gameAA(gameBG, 0, 17 * size, 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if (var3 == 44 || var3 == 52 || var3 == 51) {
                            var0.gameAA(gameBG, 0, 56 * size, 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if (var3 == 24 || var3 == 23 || var3 == 20 || var3 == 21 || var3 == 19 || var3 == 12 || var3 == 13) {
                            continue;
                        }

                        if (var3 != -1) {
                            var0.gameAA(gameBG, 0, var3 * size, 24, 24, 0, var1 * size, var2 * size, 0);
                        } else if (var3 == -1) {
                            continue;
                        }
                    }

                    if (gameAE == 1) {
                        if ((gameAG(var1, var2) & 32) == 32) {
                            var0.gameAA(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if ((gameAG(var1, var2) & 64) == 64 || (gameAG(var1, var2) & 2048) == 2048) {
                            if ((gameAG(var1, var2 - 1) & 32) == 32) {
                                var0.gameAA(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, var1 * size, var2 * size, 0);
                                continue;
                            }

                            if ((gameAG(var1, var2 - 1) & 4096) == 4096) {
                                var0.gameAA(gameBG, 0, 504, 24, 24, 0, var1 * size, var2 * size, 0);
                                continue;
                            }
                        }
                    }

                    if (gameAE == 2) {
                        if ((gameAG(var1, var2) & 32) == 32) {
                            var0.gameAA(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if (var3 == 17) {
                            var0.gameAA(imgTopWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if (var3 == 133) {
                            var0.gameAA(gameBG, 0, 132 * size, 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if ((gameAG(var1, var2) & 64) == 64 || (gameAG(var1, var2) & 2048) == 2048) {
                            if ((gameAG(var1, var2 - 1) & 32) == 32) {
                                var0.gameAA(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, var1 * size, var2 * size, 0);
                                continue;
                            }

                            if ((gameAG(var1, var2 - 1) & 4096) == 4096) {
                                if ((var3 = gameAF(var1, var2 - 1)) == 55) {
                                    var3 = 54;
                                } else if (var3 != 19 && var3 != 35) {
                                    if (var3 < 40) {
                                        var3 = 21;
                                    } else {
                                        var3 = 110;
                                    }
                                } else if ((var3 = gameAF(var1, var2 - 2)) == 55) {
                                    var3 = 54;
                                } else if (var3 < 40) {
                                    var3 = 21;
                                }

                                var0.gameAA(gameBG, 0, var3 * 24, 24, 24, 0, var1 * size, var2 * size, 0);
                                continue;
                            }
                        }
                    }

                    if (gameAE == 3) {
                        if ((gameAG(var1, var2) & 32) == 32) {
                            var0.gameAA(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if (var3 == 23) {
                            var0.gameAA(imgTopWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, var1 * size, var2 * size, 0);
                            continue;
                        }

                        if ((gameAG(var1, var2) & 64) == 64 || (gameAG(var1, var2) & 2048) == 2048) {
                            if ((gameAG(var1, var2 - 1) & 32) == 32) {
                                var0.gameAA(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, var1 * size, var2 * size, 0);
                                continue;
                            }

                            if ((gameAG(var1, var2 - 1) & 4096) == 4096) {
                                if ((var3 = gameAF(var1, var2 - 1)) == 25) {
                                    var3 = gameAF(var1, var2 - 2);
                                }

                                if (var3 == 45) {
                                    var3 = 44;
                                }

                                --var3;
                                var0.gameAA(gameBG, 0, var3 * 24, 24, 24, 0, var1 * size, var2 * size, 0);
                                continue;
                            }
                        }
                    }

                    if ((gameAG(var1, var2) & 16) == 16) {
                        gameBN = var1 * size - GameScr.cmx - GameScr.gameAD;
                        gameBO = (size - 2) * gameBN / size + GameScr.gameAD;
                        var0.gameAA(gameBG, 0, var3 * size, 24, 24, 0, gameBO + GameScr.cmx, var2 * size, 0);
                    } else if ((gameAG(var1, var2) & 512) == 512) {
                        if (var3 != -1) {
                            var0.gameAA(gameBG, 0, var3 * size, 24, 1, 0, var1 * size, var2 * size, 0);
                            var0.gameAA(gameBG, 0, var3 * size, 24, 24, 0, var1 * size, var2 * size + 1, 0);
                        }
                    } else if (var3 != -1) {
                        var0.gameAA(gameBG, 0, var3 * size, 24, 24, 0, var1 * size, var2 * size, 0);
                    }
                }
            }
        }

    }

    public static final void gameAB(mGraphics var0) {
        if (GameCanvas.w > 176) {
            Res.gameAA(var0);
            var0.gameAA(posMiniMapX + 1, posMiniMapY + 2);
            var0.gameAA(0);
            var0.gameAD(-2, -2, wMiniMap + 2, hMiniMap);
            var0.gameAE(-2, -2, wMiniMap + 4, hMiniMap + 4);

            int var1;
            for (var1 = 0; var1 < 2; ++var1) {
                var0.gameAA(colorMini[var1]);
                var0.gameAC(var1 - 2, var1 - 2, wMiniMap + 2 - (var1 << 1), hMiniMap - (var1 << 1));
            }

            var0.gameAE(0, 0, wMiniMap - 2, hMiniMap - 3);
            if (mGraphics.gameAA(imgMiniMap) > wMiniMap || mGraphics.gameAB(imgMiniMap) > hMiniMap) {
                var0.gameAA(-cmxMini, -cmyMini);
            }

            var0.gameAA(imgMiniMap, 0, 0, 0);

            int var2;
            int var3;
            for (var2 = 0; var2 < Auto.gameAN.size(); ++var2) {
                Mob var4;
                var1 = (var4 = (Mob) Auto.gameAN.elementAt(var2)).x / 12;
                var3 = var4.y / 12;
                if (var1 < cmvxMini) {
                    var1 = cmvxMini;
                }

                if (var3 < cmvyMini) {
                    var3 = cmvyMini;
                }

                if (var1 > cmvxMini + wMiniMap) {
                    var1 = cmvxMini + wMiniMap;
                }

                if (var3 > cmvyMini + hMiniMap) {
                    var3 = cmvyMini + hMiniMap;
                }

                if (GameCanvas.gameTick % 10 < 8) {
                    var0.gameAA(16777215);
                    var0.gameAD(var1 - 2, var3 - 2, 5, 5);
                    var0.gameAA(var4.levelBoss == 1 ? 255 : (var4.levelBoss == 2 ? 16711935 : '\uffff'));
                    var0.gameAD(var1 - 1, var3 - 1, 3, 3);
                }
            }

            var1 = Char.getMyChar().cx / 12;
            var3 = Char.getMyChar().cy / 12;
            var0.gameAA(16777215);
            var0.gameAD(var1 - 2, var3 - 2, 5, 5);
            var0.gameAA(16711680);
            var0.gameAD(var1 - 1, var3 - 1, 3, 3);
            if (Code.gameAR) {
                for (var2 = 0; var2 < Code.gameAT.size(); ++var2) {
                    var1 = ((Integer) Code.gameAT.elementAt(var2)).intValue() / 12;
                    var3 = ((Integer) Code.gameAU.elementAt(var2)).intValue() / 12;
                    if (Code.gameAS == var2) {
                        var0.gameAA(16777215);
                        var0.gameAD(var1 - 2, var3 - 2, 5, 5);
                    }

                    var0.gameAA(16777215);
                    var0.gameAD(var1 - 1, var3 - 1, 3, 3);
                }
            }

            for (var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
                Party var5;
                if ((var5 = (Party) GameScr.vParty.elementAt(var2)).c != null && var5.c != Char.getMyChar()) {
                    var1 = var5.c.cx / 12;
                    var3 = var5.c.cy / 12;
                    if (var1 < cmvxMini) {
                        var1 = cmvxMini;
                    }

                    if (var3 < cmvyMini) {
                        var3 = cmvyMini;
                    }

                    if (var1 > cmvxMini + wMiniMap) {
                        var1 = cmvxMini + wMiniMap;
                    }

                    if (var3 > cmvyMini + hMiniMap) {
                        var3 = cmvyMini + hMiniMap;
                    }

                    if (GameCanvas.gameTick % 10 < 8) {
                        var0.gameAA(16777215);
                        var0.gameAD(var1 - 2, var3 - 2, 5, 5);
                        var0.gameAA(65280);
                        var0.gameAD(var1 - 1, var3 - 1, 3, 3);
                    }
                }
            }

            Res.gameAA(var0);
            if (GameCanvas.isTouch) {
                var0.gameAA(GameScr.gameEU, posMiniMapX - 1, posMiniMapY, 0);
                if (SetAuto.idmap) {
                    mFont.tahoma_7_yellow.gameAA(var0, "Map : " + mapID, posMiniMapX - 1, posMiniMapY, 0, mFont.tahoma_7);
                    mFont.tahoma_7_yellow.gameAA(var0, "Khu : " + zoneID, posMiniMapX - 1, posMiniMapY += 12, 0, mFont.tahoma_7);
                    mFont.tahoma_7_yellow.gameAA(var0, "XY: " + Char.getMyChar().cx + "-" + Char.getMyChar().cy, posMiniMapX - 1, posMiniMapY += 12, 0, mFont.tahoma_7);
                }
            }
        }

    }

    public static final void gameAC(mGraphics var0) {
        if (!GameCanvas.gameAA) {
            int var1;
            int var2;
            for (var1 = GameScr.gssx; var1 < GameScr.gssxe; ++var1) {
                for (var2 = GameScr.gameAN; var2 < GameScr.gssye; ++var2) {
                    Image var3;
                    if (gameAE == 4) {
                        var3 = imgflowRiver;
                    } else {
                        var3 = imgWaterflow;
                    }

                    if ((gameAG(var1, var2) & 2048) == 2048) {
                        var0.gameAA(imgUnderWater, var1, var2, 0);
                    }

                    if ((gameAG(var1, var2) & 64) == 64) {
                        var0.gameAA(var3, 0, (GameCanvas.gameTick % 8 >> 2) * 24, 24, 24, 0, var1 * size, var2 * size, 0);
                    }

                    if ((gameAG(var1, var2) & 256) == 256) {
                        var0.gameAA(gameBG, 0, (gameAF[var2 * tmw + var1] - 1) * size, 24, 24, 0, var1 * size, var2 * size, 0);
                    }
                }
            }

            if (gameAE != 4 && GameCanvas.isTouch && GameCanvas.gameAG && GameScr.gssye >= tmh - 2) {
                for (var1 = GameScr.gssx; var1 < GameScr.gssxe; ++var1) {
                    var2 = tmh - 2;
                    int var5 = gameAF[var2 * tmw + var1] - 1;
                    int var4;
                    if ((gameAG(var1, var2) & 32) == 32) {
                        for (var4 = 1; var4 <= 4; ++var4) {
                            var0.gameAA(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, var1 * size, (var2 + var4) * size, 0);
                        }
                    } else {
                        if (mapID == 64) {
                            gameBX = 115;
                        }

                        if ((gameAG(var1, var2) & 2) == 2 || (gameAG(var1, var2) & 64) == 64) {
                            var5 = gameBX;
                        }

                        if (var5 >= 0) {
                            for (var4 = 1; var4 <= 4; ++var4) {
                                var0.gameAA(gameBG, 0, var5 * size, 24, 24, 0, var1 * size, (var2 + var4) * size, 0);
                            }
                        }
                    }
                }
            }
        }

    }

    private static int gameAF(int var0, int var1) {
        try {
            return gameAF[var1 * tmw + var0];
        } catch (Exception var2) {
            return 1000;
        }
    }

    private static int gameAG(int var0, int var1) {
        try {
            return gameAG[var1 * tmw + var0];
        } catch (Exception var2) {
            return 1000;
        }
    }

    public static final int gameAA(int var0, int var1) {
        try {
            return gameAG[var1 / size * tmw + var0 / size];
        } catch (Exception var2) {
            return 1000;
        }
    }

    public static final boolean gameAA(int var0, int var1, int var2) {
        try {
            return (gameAG[var1 / size * tmw + var0 / size] & var2) == var2;
        } catch (Exception var3) {
            return false;
        }
    }

    public static final void gameAB(int var0, int var1) {
        int[] var10000 = gameAG;
        int var10001 = var1 / size * tmw + var0 / size;
        var10000[var10001] |= 512;
    }

    public static final void gameAC(int var0, int var1) {
        int[] var10000 = gameAG;
        int var10001 = var1 / size * tmw + var0 / size;
        var10000[var10001] &= -513;
    }

    public static final int gameAB(int var0) {
        return var0 / size * size;
    }

    public static final int gameAC(int var0) {
        return var0 / size * size;
    }

    public static void gameAE() {
        if (GameCanvas.gameTick % 700 == 0 && mapID != 0 && mapID > 4 && (mapID < 16 || mapID > 18) && (mapID < 24 || mapID > 27) && mapID != 22 && mapID != 33 && mapID != 34 && mapID != 38 && mapID != 57 && mapID != 58 && mapID != 60 && mapID != 68 && (mapID < 70 || mapID > 75) && mapID != 81 && (mapID < 39 || mapID > 44) && (mapID < 46 || mapID > 48) && mapID != 56 && (mapID < 62 || mapID > 65) && mapID != 29 && mapID != 35 && mapID != 50 && mapID != 51 && mapID != 52 && mapID == 64) {
            Res.gameAB(0, 8);
        }

    }

    public static boolean gameAD(int var0) {
        return var0 == 10 || var0 == 17 || var0 == 22 || var0 == 32 || var0 == 38 || var0 == 43 || var0 == 48 || var0 == 138;
    }

    public static boolean isLangCo(int var0) {
        return var0 >= 134 && var0 <= 138;
    }

    public static boolean gameAF(int var0) {
        return var0 == 1 || var0 == 27 || var0 == 72;
    }

    public static boolean gameAG(int var0) {
        return var0 == 91 || var0 == 92 || var0 == 93 || var0 == 94 || var0 == 95 || var0 == 96 || var0 == 97 || var0 == 105 || var0 == 106 || var0 == 107 || var0 == 108 || var0 == 109 || var0 == 114 || var0 == 115 || var0 == 116 || var0 == 125 || var0 == 126 || var0 == 127 || var0 == 128 || var0 == 157 || var0 == 158 || var0 == 159;
    }

    public static int gameAH(int var0) {
        if (gameAG(var0)) {
            switch (var0) {
                case 91:
                    return 92;
                case 92:
                    return 93;
                case 93:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 155:
                case 156:
                default:
                    break;
                case 94:
                    return 95;
                case 95:
                    return 96;
                case 96:
                    return 97;
                case 105:
                    return 106;
                case 106:
                    return 107;
                case 107:
                    return 108;
                case 108:
                    return 109;
                case 114:
                    return 115;
                case 115:
                    return 116;
                case 125:
                    return 126;
                case 126:
                    return 127;
                case 127:
                    return 128;
                case 157:
                    return 158;
                case 158:
                    return 159;
                case 159:
                    return 157;
            }
        }

        return -1;
    }

    public static int gameAI(int var0) {
        if (gameAG(var0)) {
            switch (var0) {
                case 92:
                    return 91;
                case 93:
                    return 92;
                case 94:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                default:
                    break;
                case 95:
                    return 94;
                case 96:
                    return 95;
                case 97:
                    return 96;
                case 106:
                    return 105;
                case 107:
                    return 106;
                case 108:
                    return 107;
                case 109:
                    return 108;
                case 115:
                    return 114;
                case 116:
                    return 115;
                case 126:
                    return 125;
                case 127:
                    return 126;
                case 128:
                    return 127;
                case 158:
                    return 157;
                case 159:
                    return 158;
            }
        }

        return -1;
    }

    public static void gameAJ(int var0) {
        try {
            Waypoint var4;
            int var1 = (var4 = (Waypoint) vGo.elementAt(var0)).minX;
            int var2 = var4.minY;
            if (var4.minY != 0 && var4.maxY < pxh - 24) {
                if (var4.maxX <= pxw / 2) {
                    var1 = var4.maxX + 12;
                    var2 = var4.maxY;
                } else if (var4.minX >= pxw / 2) {
                    var1 = var4.minX - 12;
                    var2 = var4.maxY;
                }
            } else if (var4.maxY <= pxh / 2) {
                var1 = (var4.maxX + var4.minX) / 2;
                var2 = var4.maxY + 24;
            } else if (var4.minY >= pxh / 2) {
                var1 = (var4.maxX + var4.minX) / 2 + 24;
                var2 = var4.maxY - 48;
            }

            if (mapID != 114 && mapID != 115 && mapID != 116) {
                Char.gameAC(var1, var2);
            } else {
                Char.gameAE(var1, var2);
            }

            Thread.sleep(10L);
            Service.gI().gameAC();
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }
    }

    public static void gameAF() {
        gameBF = true;
        Object var10000 = gameCD;
        synchronized (gameCD) {
            try {
                gameCD.wait(10000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAG() {
        if (gameBF) {
            gameBF = false;
            Object var10000 = gameCD;
            synchronized (gameCD) {
                gameCD.notifyAll();
            }
        }
    }

    public static boolean GoMap(int var0) {
        short var1 = mapID;
        gameBD = var0;
        int var2;
        int var3;
        int var5;
        MyVector var10;
        int var13;
        if (var1 >= 0 && var1 < gameBZ.length && var0 >= 0 && var0 < gameBZ.length && gameBZ[var1].length > 0) {
            TaskOrder var6 = Char.gameAM(0);

            for (var2 = 0; var2 < gameCA.length; ++var2) {
                gameCA[var2] = true;
                gameCB[var2] = -1;
                gameCC[var2] = -1;
            }

            gameCB[var1] = 0;

            label382:
            while (true) {
                short var7;
                do {
                    do {
                        if (!gameCA[var0]) {
                            MyVector var16;
                            (var16 = new MyVector()).addElement(new Integer(var0));

                            for (var5 = var0; var5 != var1; var5 = gameCC[var5]) {
                                byte var12;
                                int var18;
                                if (gameAD(var18 = gameCC[var5])) {
                                    if (gameAD(var5) && var5 != 138) {
                                        var12 = 1;
                                        if (var5 == 10) {
                                            var12 = 1;
                                        } else if (var5 == 17) {
                                            var12 = 2;
                                        } else if (var5 == 22) {
                                            var12 = 3;
                                        } else if (var5 == 32) {
                                            var12 = 4;
                                        } else if (var5 == 38) {
                                            var12 = 5;
                                        } else if (var5 == 43) {
                                            var12 = 6;
                                        } else if (var5 == 48) {
                                            var12 = 7;
                                        }

                                        var18 = var18 | Integer.MIN_VALUE | 117440512 | var12 << 20 & 15728640;
                                    } else if (var5 == 139) {
                                        var18 = var18 | Integer.MIN_VALUE | 83886080 | 2097152;
                                    }
                                } else if (gameAF(var18)) {
                                    if (gameAF(var5)) {
                                        var12 = 0;
                                        if (var5 == 1) {
                                            var12 = 0;
                                        } else if (var5 == 27) {
                                            var12 = 1;
                                        } else if (var5 == 72) {
                                            var12 = 2;
                                        }

                                        var18 = var18 | Integer.MIN_VALUE | 134217728 | var12 << 20 & 15728640;
                                    } else if (var6 != null && var5 == var6.mapId) {
                                        var13 = GameScr.gameGP;
                                        var18 = var18 | Integer.MIN_VALUE | 419430400 | var13 << 20 & 15728640 | 196608;
                                    } else {
                                        switch (var5) {
                                            case 80:
                                                var18 = var18 | Integer.MIN_VALUE | 1048576 | 65536;
                                                break;
                                            case 91:
                                                var18 = var18 | Integer.MIN_VALUE | 2097152 | 65536;
                                                break;
                                            case 94:
                                                var18 = var18 | Integer.MIN_VALUE | 2097152 | 131072;
                                                break;
                                            case 98:
                                                var13 = GameScr.gameGP + 2;
                                                var18 = var18 | Integer.MIN_VALUE | 419430400 | var13 << 20 & 15728640;
                                                break;
                                            case 104:
                                                var13 = GameScr.gameGP + 2;
                                                var18 = var18 | Integer.MIN_VALUE | 419430400 | var13 << 20 & 15728640 | 65536;
                                                break;
                                            case 105:
                                                var18 = var18 | Integer.MIN_VALUE | 2097152 | 196608;
                                                break;
                                            case 113:
                                                var13 = GameScr.gameGP + 3;
                                                var18 = var18 | Integer.MIN_VALUE | 419430400 | var13 << 20 & 15728640;
                                                break;
                                            case 114:
                                                var18 = var18 | Integer.MIN_VALUE | 2097152 | 262144;
                                                break;
                                            case 125:
                                                var18 = var18 | Integer.MIN_VALUE | 2097152 | 327680;
                                                break;
                                            case 139:
                                                var18 = var18 | Integer.MIN_VALUE | 83886080 | 2097152;
                                                break;
                                            case 157:
                                                var18 = var18 | Integer.MIN_VALUE | 2097152 | 393216;
                                        }
                                    }
                                }

                                var16.addElement(new Integer(var18));
                            }

                            MyVector var19 = new MyVector();

                            for (var2 = var16.size() - 1; var2 >= 0; --var2) {
                                var19.addElement(var16.elementAt(var2));
                            }

                            var10 = var19;
                            break label382;
                        }

                        var3 = -1;
                        var7 = -1;

                        for (var2 = 0; var2 < gameBZ.length; ++var2) {
                            if (gameCA[var2] && gameCB[var2] != -1 && (gameCB[var2] < var3 || var3 == -1)) {
                                var3 = gameCB[var2];
                                var7 = (short) var2;
                            }
                        }

                        if (var7 == -1) {
                            var10 = null;
                            break label382;
                        }

                        gameCA[var7] = false;
                        boolean var11 = gameAF(var7);
                        short[] var8 = gameBZ[var7];

                        short var4;
                        for (var2 = 0; var2 < var8.length; ++var2) {
                            var4 = var8[var2];
                            if (gameCA[var4]) {
                                boolean var14;
                                label346:
                                {
                                    if (Char.getMyChar().isHuman) {
                                        var5 = Char.getMyChar().ctaskId;
                                        if ((var4 == 1 || var4 == 27 || var4 == 72) && var5 < 6) {
                                            var14 = false;
                                            break label346;
                                        }

                                        if ((var4 == 10 || var4 == 32 || var4 == 48) && var5 < 17) {
                                            var14 = false;
                                            break label346;
                                        }

                                        if (var4 == 38 && var5 < 28) {
                                            var14 = false;
                                            break label346;
                                        }

                                        if (var4 == 43 && var5 < 33) {
                                            var14 = false;
                                            break label346;
                                        }

                                        if (var4 == 17 && var5 < 38) {
                                            var14 = false;
                                            break label346;
                                        }

                                        if (var4 == 7 && var5 < 15) {
                                            var14 = false;
                                            break label346;
                                        }
                                    }

                                    var14 = true;
                                }

                                if (var14 && (!var11 || !gameAF(var4) || Char.getMyChar().ctaskId >= 9) && (gameCB[var4] == -1 || gameCB[var4] > gameCB[var7] + 1)) {
                                    gameCB[var4] = gameCB[var7] + 1;
                                    gameCC[var4] = var7;
                                }
                            }
                        }

                        if (var11 && var6 != null && gameCA[var6.mapId] && (gameCB[var6.mapId] == -1 || gameCB[var6.mapId] > gameCB[var7] + 1)) {
                            gameCB[var6.mapId] = gameCB[var7] + 1;
                            gameCC[var6.mapId] = var7;
                        }

                        if (var11) {
                            var4 = (short) (GameScr.gameGQ ? 98 : 104);
                            if (gameCB[var4] == -1 || gameCB[var4] > gameCB[var7] + 1) {
                                gameCB[var4] = gameCB[var7] + 1;
                                gameCC[var4] = var7;
                            }
                        }
                    } while (!Char.DungCoLenh);
                } while (gameCB[138] != -1 && gameCB[138] <= gameCB[var7] + 1);

                gameCB[138] = gameCB[var7] + 1;
                gameCC[138] = var7;
            }
        } else {
            var10 = null;
        }

        MyVector var15 = var10;
        if (var10 == null) {
            InfoMe.gameAA("Không thể chuyển map!", 50, mFont.tahoma_7_yellow);
            return false;
        } else {
            gameBE = true;

            try {
                var5 = mapID;

                for (var13 = 1; var13 < var15.size() && gameBE && var5 == mapID; ++var13) {
                    var3 = ((Integer) var15.elementAt(var13 - 1)).intValue();
                    var5 = ((Integer) var15.elementAt(var13)).intValue() & '\uffff';
                    int var17;
                    if (var3 < 0) {
                        var17 = var3 >> 24 & 127;
                        var2 = var3 >> 20 & 15;
                        var3 = var3 >> 16 & 15;
                        GameScr.gameAB(var17, var2, var3);
                    } else if ((var3 < 134 || var3 > 138) && var5 == 138) {
                        if (Char.getMyChar().cPk > 0) {
                            InfoMe.gameAA("Hiếu chiến quá cao!", 50, mFont.tahoma_7_yellow);
                            return false;
                        }

                        Item var21;
                        if ((var21 = Char.gameAF(490)) == null || var21.template.id != 490) {
                            if (Char.MuaCoLenh && Char.getMyChar().luong >= 10) {
                                Service.gI().gameAB(14, 28, 2);
                                LockGame.gameAG();
                                return false;
                            }

                            InfoMe.gameAA("Không đủ cổ lệnh!", 50, mFont.tahoma_7_yellow);
                            return false;
                        }

                        System.out.println("Dung co lenh");
                        Service.gI().useItem(var21.indexUI);
                    } else if (var3 != 0 && var3 != 56 && var3 != 73) {
                        var2 = -1;

                        for (var17 = 0; var17 < gameBZ[var3].length; ++var17) {
                            if (gameBZ[var3][var17] == var5) {
                                var2 = var17;
                                break;
                            }
                        }

                        if (var2 == -1) {
                            InfoMe.gameAA("Không thể chuyển map!", 50, mFont.tahoma_7_yellow);
                            return false;
                        }

                        gameAJ(var2);
                    } else {
                        Npc var20;
                        if ((var20 = (Npc) GameScr.vNpc.elementAt(0)) != null && var20.statusMe != 15) {
                            Char.gameAC(var20.cx, var20.cy);
                            Char.getMyChar().npcFocus = var20;
                            Service.gI().gameAI(var20.template.npcTemplateId);
                            Service.gI().gameAC(var20.template.npcTemplateId, 0, 0);
                            Service.gI().gameAJ(var20.template.npcTemplateId, 0);
                        }
                    }

                    if (mapID != var5) {
                        gameAF();
                        Thread.sleep(100L);
                    } else {
                        Thread.sleep(100L);
                    }
                }
            } catch (Exception var9) {
                var9.printStackTrace();
                return false;
            }

            gameBE = false;
            return mapID == var0;
        }
    }

    public static void gameAL(int var0) {
        GameCanvas.gameAN();
        (new Thread(new GoMap(var0))).start();
    }

    public static void gameAM(int var0) {
        GameCanvas.gameAN();
        (new Thread(new NextMap(var0))).start();
    }

    public static int gameAD(int var0, int var1) {
        var1 = gameAB(var1);
        if (!gameAA(var0, var1, 2)) {
            for (int var2 = 0; var2 < 7; ++var2) {
                int var3;
                if ((var3 = var1 - 48 + var2 * 24) > 0 && var3 < pxh && gameAA(var0, var3, 2)) {
                    return var3;
                }
            }
        }

        return var1;
    }

    public static int gameAE(int var0, int var1) {
        if ((gameAA(var0, var1 - 16) & 16386) != 0) {
            var1 = gameAB(var1);

            int var2;
            int var3;
            for (var2 = 24; var2 < 240; var2 += 24) {
                var3 = gameAA(var0, var1 - var2);
                if (var1 - var2 > 0 && (var3 & 16386) == 0) {
                    return var1 - var2 + 24;
                }
            }

            for (var2 = 24; var2 < 120; var2 += 24) {
                var3 = gameAA(var0, var1 + var2);
                if (var1 + var2 < pxh && (var3 & 16386) == 0) {
                    return var1 + var2;
                }
            }
        }

        return var1;
    }

    public static boolean gameAA(int var0, int var1, int[] var2) {
        var1 = gameAB(var1);
        if (gameAA(var0, var1, 2)) {
            var2[0] = var0;
            var2[1] = var1;
            return true;
        } else {
            for (int var3 = 0; var3 < 5; ++var3) {
                int var4 = var1 + var3 * 24;

                for (int var5 = 0; var5 < 5; ++var5) {
                    int var6 = var0 - 48 + var5 * 24;
                    if (var4 < pxh && var6 > 24 && var6 < pxw - 24 && gameAA(var6, var4, 2)) {
                        var2[0] = var6;
                        var2[1] = var4;
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static void gameAA(int var0, InputStream var1) {
        try {
            if (gameCE.length <= var0) {
                byte[][] var2 = new byte[var0 + 10][];
                System.arraycopy(gameCE, 0, var2, 0, gameCE.length);
                gameCE = var2;
            }

            gameCE[var0] = new byte[var1.available()];
            var1.read(gameCE[var0]);
        } catch (Exception var3) {
        }
    }

    public static void gameAH() {
        try {
            ByteArrayInputStream var0 = new ByteArrayInputStream(gameCE[mapID]);
            DataInputStream var3;
            tmw = (char) (var3 = new DataInputStream(var0)).readUnsignedByte();
            tmh = (char) var3.readUnsignedByte();
            gameAF = new char[var3.available()];

            for (int var1 = 0; var1 < tmw * tmh; ++var1) {
                gameAF[var1] = (char) var3.readUnsignedByte();
            }

            gameAG = new int[gameAF.length];
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public static void gameAI() {
        for (int var0 = 1; var0 < gameCF.length; ++var0) {
            gameCF[var0] = GameCanvas.gameAC("/t/" + var0 + ".png");
            gameCG[var0] = GameCanvas.gameAC("/t/mini_" + var0 + ".png");
        }

    }

    public static void gameAJ() {
        gameBG = null;
        System.gc();
        gameBG = gameCF[gameAE];
        gameBH = gameCG[gameAE];
    }

    static {
        gameBZ[0] = new short[]{27};
        gameBZ[1] = new short[]{2, 3, 27, 72, 91, 94, 105, 114, 125, 157, 139, 113, 80};
        gameBZ[2] = new short[]{6, 1};
        gameBZ[3] = new short[]{1, 4};
        gameBZ[4] = new short[]{3, 5};
        gameBZ[5] = new short[]{7, 4};
        gameBZ[6] = new short[]{7, 2, 20, 21};
        gameBZ[7] = new short[]{6, 5, 8};
        gameBZ[8] = new short[]{7, 9};
        gameBZ[9] = new short[]{8, 10};
        gameBZ[10] = new short[]{9, 11, 17, 22, 32, 38, 43, 48, 139};
        gameBZ[11] = new short[]{12, 10};
        gameBZ[12] = new short[]{11, 57};
        gameBZ[13] = new short[]{57, 14};
        gameBZ[14] = new short[]{13, 15};
        gameBZ[15] = new short[]{14, 16};
        gameBZ[16] = new short[]{15, 17};
        gameBZ[17] = new short[]{16, 18, 10, 22, 32, 38, 43, 48, 139};
        gameBZ[18] = new short[]{17, 19};
        gameBZ[19] = new short[]{18, 58};
        gameBZ[20] = new short[]{6};
        gameBZ[21] = new short[]{22, 6};
        gameBZ[22] = new short[]{23, 21, 10, 17, 32, 38, 43, 48, 139};
        gameBZ[23] = new short[]{22, 69, 25};
        gameBZ[24] = new short[]{59, 36};
        gameBZ[25] = new short[]{23, 26};
        gameBZ[26] = new short[]{27, 25};
        gameBZ[27] = new short[]{26, 28, 1, 72, 91, 94, 105, 114, 125, 157, 139, 113, 80};
        gameBZ[28] = new short[]{27, 60};
        gameBZ[29] = new short[]{60, 30};
        gameBZ[30] = new short[]{29, 31};
        gameBZ[31] = new short[]{32, 30};
        gameBZ[32] = new short[]{31, 61, 10, 17, 22, 38, 43, 48, 139};
        gameBZ[33] = new short[]{61, 34};
        gameBZ[34] = new short[]{35, 33};
        gameBZ[35] = new short[]{34, 66};
        gameBZ[36] = new short[]{37, 24};
        gameBZ[37] = new short[]{36};
        gameBZ[38] = new short[]{67, 68, 10, 17, 22, 32, 43, 48, 139};
        gameBZ[39] = new short[]{72, 46, 40};
        gameBZ[40] = new short[]{39, 65, 41};
        gameBZ[41] = new short[]{42, 40, 43};
        gameBZ[42] = new short[]{62, 41};
        gameBZ[43] = new short[]{41, 44, 10, 17, 22, 32, 38, 48, 139};
        gameBZ[44] = new short[]{43, 45};
        gameBZ[45] = new short[]{44, 53};
        gameBZ[46] = new short[]{63, 39, 47};
        gameBZ[47] = new short[]{46, 48};
        gameBZ[48] = new short[]{47, 50, 10, 17, 22, 32, 38, 43, 139};
        gameBZ[49] = new short[]{50, 51};
        gameBZ[50] = new short[]{48, 49};
        gameBZ[51] = new short[]{52, 49};
        gameBZ[52] = new short[]{51, 64};
        gameBZ[53] = new short[]{54, 45};
        gameBZ[54] = new short[]{55, 53};
        gameBZ[55] = new short[]{54};
        gameBZ[56] = new short[]{72};
        gameBZ[57] = new short[]{12, 13};
        gameBZ[58] = new short[]{19};
        gameBZ[59] = new short[]{68, 24};
        gameBZ[60] = new short[]{28, 29};
        gameBZ[61] = new short[]{33, 32};
        gameBZ[62] = new short[]{42};
        gameBZ[63] = new short[]{46};
        gameBZ[64] = new short[]{52};
        gameBZ[65] = new short[]{40};
        gameBZ[66] = new short[]{67, 35};
        gameBZ[67] = new short[]{66, 38};
        gameBZ[68] = new short[]{59, 38};
        gameBZ[69] = new short[]{70, 23};
        gameBZ[70] = new short[]{69, 71};
        gameBZ[71] = new short[]{72, 70};
        gameBZ[72] = new short[]{71, 39, 1, 27, 91, 94, 105, 114, 125, 157, 139, 113, 80};
        gameBZ[73] = new short[]{1};
        gameBZ[74] = new short[0];
        gameBZ[75] = new short[0];
        gameBZ[76] = new short[0];
        gameBZ[77] = new short[0];
        gameBZ[78] = new short[0];
        gameBZ[79] = new short[0];
        gameBZ[80] = new short[]{81, 82, 83};
        gameBZ[81] = new short[]{80, 84};
        gameBZ[82] = new short[]{80, 85};
        gameBZ[83] = new short[]{80, 86};
        gameBZ[84] = new short[]{81, 87};
        gameBZ[85] = new short[]{82, 88};
        gameBZ[86] = new short[]{83, 89};
        gameBZ[87] = new short[]{84, 90};
        gameBZ[88] = new short[]{85, 90};
        gameBZ[89] = new short[]{86, 90};
        gameBZ[90] = new short[0];
        gameBZ[91] = new short[]{92};
        gameBZ[92] = new short[]{91, 93};
        gameBZ[93] = new short[]{92};
        gameBZ[94] = new short[]{95};
        gameBZ[95] = new short[]{94, 96};
        gameBZ[96] = new short[]{95, 97};
        gameBZ[97] = new short[]{96};
        gameBZ[98] = new short[]{99};
        gameBZ[99] = new short[]{98, 101, 100, 102};
        gameBZ[100] = new short[]{99, 103};
        gameBZ[101] = new short[]{99, 103};
        gameBZ[102] = new short[]{99, 103};
        gameBZ[103] = new short[]{101, 102, 104, 100};
        gameBZ[104] = new short[]{103};
        gameBZ[105] = new short[]{107, 106, 108};
        gameBZ[106] = new short[]{105, 109};
        gameBZ[107] = new short[]{105, 109};
        gameBZ[108] = new short[]{105, 109};
        gameBZ[109] = new short[]{106, 107, 108};
        gameBZ[110] = new short[0];
        gameBZ[111] = new short[0];
        gameBZ[112] = new short[]{113};
        gameBZ[113] = new short[]{112};
        gameBZ[114] = new short[]{115};
        gameBZ[115] = new short[]{114, 116};
        gameBZ[116] = new short[]{115};
        gameBZ[117] = new short[0];
        gameBZ[118] = new short[0];
        gameBZ[119] = new short[0];
        gameBZ[120] = new short[0];
        gameBZ[121] = new short[0];
        gameBZ[122] = new short[0];
        gameBZ[123] = new short[0];
        gameBZ[124] = new short[0];
        gameBZ[125] = new short[]{126};
        gameBZ[126] = new short[]{125, 127};
        gameBZ[127] = new short[]{126, 128};
        gameBZ[128] = new short[]{127};
        gameBZ[129] = new short[0];
        gameBZ[130] = new short[0];
        gameBZ[131] = new short[0];
        gameBZ[132] = new short[0];
        gameBZ[133] = new short[0];
        gameBZ[134] = new short[]{138};
        gameBZ[135] = new short[]{138};
        gameBZ[136] = new short[]{138};
        gameBZ[137] = new short[]{138};
        gameBZ[138] = new short[]{134, 135, 136, 137};
        gameBZ[139] = new short[]{140};
        gameBZ[140] = new short[]{139, 141};
        gameBZ[141] = new short[]{140, 142};
        gameBZ[142] = new short[]{141, 143};
        gameBZ[143] = new short[]{142, 144};
        gameBZ[144] = new short[]{143, 145};
        gameBZ[145] = new short[]{144, 146};
        gameBZ[146] = new short[]{145, 147};
        gameBZ[147] = new short[]{146, 148};
        gameBZ[148] = new short[]{147};
        gameBZ[149] = new short[0];
        gameBZ[150] = new short[0];
        gameBZ[151] = new short[0];
        gameBZ[152] = new short[0];
        gameBZ[153] = new short[0];
        gameBZ[154] = new short[0];
        gameBZ[155] = new short[0];
        gameBZ[156] = new short[0];
        gameBZ[157] = new short[]{158, 159};
        gameBZ[158] = new short[]{159, 157};
        gameBZ[159] = new short[]{157, 158};
        gameBD = -1;
        gameBE = false;
        gameBF = false;
        gameCD = new Object();
        gameCE = new byte[160][];

        for (int var0 = 0; var0 < 160; ++var0) {
            int var1 = var0;
            InputStream var2 = null;

            try {
                var2 = "".getClass().getResourceAsStream("/map/".concat(String.valueOf(var1)));
                gameCE[var1] = new byte[var2.available()];
                var2.read(gameCE[var1]);
                var2.close();
            } catch (Exception var9) {
                var9.printStackTrace();
            } finally {
                try {
                    var2.close();
                } catch (Exception var8) {
                }

            }
        }

        gameCF = new Image[5];
        gameCG = new Image[5];
    }

    public static boolean truongandlang(int var0) {
        return var0 == 10 || var0 == 17 || var0 == 22 || var0 == 32 || var0 == 38 || var0 == 43 || var0 == 48 || var0 == 138 || var0 == 1 || var0 == 27 || var0 == 72;
    }
}
