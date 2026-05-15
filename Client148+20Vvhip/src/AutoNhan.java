
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Calendar;
import java.util.Random;

public final class AutoNhan extends Auto {

    public static String nguoinhan;
    public static byte gionhan;
    public static byte phutnhan;
    public static int mapnhan;
    public static byte khunhan;
    public static boolean gameAF;
    public static boolean gameAG;
    public static Random gameAH;

    public AutoNhan() {
        super.gameAC();
        super.mapID = TileMap.mapID;
        super.zoneID = TileMap.zoneID;
    }

    public static boolean gameAE() {
        Calendar var0;
        return nguoinhan != null && (var0 = Res.gameAB()).get(11) == gionhan && var0.get(12) == phutnhan;
    }

    private static void gameAO() {
        try {
            ByteArrayInputStream var7 = new ByteArrayInputStream(RMS.gameAB("V6Rec"));
            DataInputStream var8;
            if ((nguoinhan = (var8 = new DataInputStream(var7)).readUTF()).equals("")) {
                nguoinhan = null;
            }

            if ((SetGomDo.itemgd = var8.readUTF()).equals("")) {
                SetGomDo.itemgd = null;
            }

            if ((SetGomDo.itemcat = var8.readUTF()).equals("")) {
                SetGomDo.itemcat = null;
            }

            gionhan = var8.readByte();
            phutnhan = var8.readByte();
            mapnhan = var8.readInt();
            khunhan = var8.readByte();
            var8.close();
            var7.close();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    public static void gameaAF() {
        try {
            ByteArrayInputStream var9 = new ByteArrayInputStream(RMS.gameAB("V6Rec"));
            DataInputStream var10;
            if ((nguoinhan = (var10 = new DataInputStream(var9)).readUTF()).equals("")) {
                nguoinhan = null;
            }

            if ((SetGomDo.itemgd = var10.readUTF()).equals("")) {
                SetGomDo.itemgd = null;
            }

            if ((SetGomDo.itemcat = var10.readUTF()).equals("")) {
                SetGomDo.itemcat = null;
            }

            gionhan = var10.readByte();
            phutnhan = var10.readByte();
            mapnhan = var10.readInt();
            khunhan = var10.readByte();
            var10.close();
            var9.close();
        } catch (Exception var11) {
        }

    }

    public static void gameaAG() {
        ByteArrayOutputStream var9 = new ByteArrayOutputStream();
        DataOutputStream var10 = new DataOutputStream(var9);

        try {
            var10.writeUTF(nguoinhan == null ? "" : nguoinhan);
            var10.writeUTF(SetGomDo.itemgd == null ? "" : SetGomDo.itemgd);
            var10.writeUTF(SetGomDo.itemcat == null ? "" : SetGomDo.itemcat);
            var10.writeByte(gionhan);
            var10.writeByte(phutnhan);
            var10.writeInt(mapnhan);
            var10.writeByte(khunhan);
            var10.flush();
            var9.flush();
            RMS.gameAA("V6Rec", var9.toByteArray());
        } catch (Exception var11) {
            var11.printStackTrace();
        }

    }

    public final void gameAK() {
        if (Char.ReMap) {
            Auto.gameAA(true);
        } else if (super.mapID == TileMap.mapID && super.zoneID == TileMap.zoneID) {
            LockGame.LockAA(-1L);
            AutoSell.gameAV = false;
            long var1 = System.currentTimeMillis();

            while (GameScr.gI().typeTradeOrder != 1) {
                if (AutoSell.gameAV || System.currentTimeMillis() - var1 >= 20000L) {
                    return;
                }

                Auto.Sleep(200L);
            }

            GameScr.gI().gameEE = 0;
            GameScr.gameCW = new Item[12];
            Service.gI().gameAA((int) 0, (Item[]) GameScr.gameCW);
            GameScr.gI().gameEC = 1;
            Auto.Sleep(5000L);
            Service.gI().gameAJ();
            LockGame.LockAA(20000L);
        } else {
            this.gameAA(super.mapID, super.zoneID, -1, -1);
        }
    }

    public final String toString() {
        return "Auto Nhận";
    }

    static {
        gameaAF();
    }

    public static void gameAA(String var0) {
        Char var1 = Char.getMyChar();
        int var2 = 0;

        Char var10000;
        while (true) {
            if (var2 >= GameScr.vCharInMap.size()) {
                var10000 = null;
                break;
            }

            Char var3;
            if ((var3 = (Char) GameScr.vCharInMap.elementAt(var2)).cName.equals(var0)) {
                var10000 = var3;
                break;
            }

            ++var2;
        }

        Char var8 = var10000;
        if (var10000 == null) {
            AutoGuiDo.gameAC = true;
        } else {
            do {
                if (Res.gameAA(var1.cx, var1.cy, var8.cx, var8.cy) >= 50) {
                    Char.gameAC(var8.cx, var8.cy);
                    Auto.Sleep(1000L);
                } else {
                    Service.gI().gameAS(var8.charID);
                }
            } while (!GameScr.isPaintTrade && !LockGame.LockAA((long) (gameAH.nextInt(1500) + 1000)));

            Item[] var9 = new Item[12];
            var2 = 0;

            for (int var7 = 0; var7 < Code.gameAC(SetGomDo.itemgd, ",").length; ++var7) {
                for (int var4 = 0; var4 < var1.arrItemBag.length; ++var4) {
                    Item var5 = var1.arrItemBag[var4];
                    if (var2 < 12 && var5 != null && var5.template.id == Integer.parseInt(Code.gameAC(SetGomDo.itemgd, ",")[var7]) && !var5.isLock) {
                        var9[var2++] = var5;
                    }
                }
            }

            GameScr.gI().gameEE = 0;
            GameScr.gameCW = var9;
            Service.gI().gameAA(Char.getMyChar().xu, var9);
            GameScr.gI().gameEC = 1;
            long var11 = System.currentTimeMillis();

            while (GameScr.gI().typeTradeOrder != 1) {
                if (AutoSell.gameAV || System.currentTimeMillis() - var11 >= 2000L) {
                    Service.gI().gameAI();
                    return;
                }

                Auto.Sleep(200L);
            }

            var11 = System.currentTimeMillis();

            while (System.currentTimeMillis() - var11 < 2000L) {
                if (AutoSell.gameAV) {
                    return;
                }

                Auto.Sleep(200L);
            }

            Service.gI().gameAJ();
            var11 = System.currentTimeMillis();

            while (GameScr.gI().typeTradeOrder != 2) {
                if (AutoSell.gameAV || System.currentTimeMillis() - var11 >= 5000L) {
                    Service.gI().gameAI();
                    return;
                }

                Auto.Sleep(200L);
            }

            if (LockGame.LockAA(2000L)) {
                for (int var10 = 0; var10 < 12; ++var10) {
                    if (var9[var10] != null) {
                        int var10001 = var9[var10].indexUI;
                        Char.getMyChar().arrItemBag[var10001] = null;
                    }
                }
            }

        }
    }
}
