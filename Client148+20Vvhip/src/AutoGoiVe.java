// Decompiled with: CFR 0.152
// Class Version: 8
public final class AutoGoiVe
implements Runnable {
    public final int gameAA;
    public static boolean gameAB;
    public static boolean gameAC;

    AutoGoiVe(int n) {
        this.gameAA = n;
    }

    public final void run() {
        int n;
        if (gameAB) {
            for (n = 0; n < Code.gameAC(AutoNhan.nguoinhan, ",").length; ++n) {
                 Service.gI().gameAA(Code.gameAC(AutoNhan.nguoinhan, ",")[n], "cutve " + TileMap.mapID + " " + TileMap.zoneID + " " + this.gameAA);
                Service.gI().gameAC("Đang Gọi: " + Code.gameAC(AutoNhan.nguoinhan, ",")[n] + " Về Gom Đồ !");
                Auto.Sleep(5000L);
            }
            gameAB = false;
        }
        if (gameAC) {
            for (n = 0; n < Code.gameAC(AutoNhan.nguoinhan, ",").length; ++n) {
                Service.gI().gameAA(Code.gameAC(AutoNhan.nguoinhan, ",")[n], "check");
            }
            gameAC = false;
        }
    }
}
