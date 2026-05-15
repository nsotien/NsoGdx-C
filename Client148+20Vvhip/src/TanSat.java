
import java.util.Calendar;

public final class TanSat extends Auto {

    public int templateId;
    public static int mapid = 134;
    public static long timenvhn;

    public final void gameAA(int var1, int var2, int var3) {
        super.gameAC();
        super.mapID = var2;
        super.zoneID = var3;
        super.gameAD = TileMap.gameAG(var2);
        this.templateId = var1;
    }

    public final void gameAK() {
        Calendar calendar = Res.gameAB();
        int n = calendar.get(11);
        int n2 = calendar.get(12);
        if (super.mapID == 134 || super.mapID == 135 || super.mapID == 136 || super.mapID == 137) {
            mapid = super.mapID;
        }

        if (Auto.reAC()) {
            if (Char.ReMap) {
                Auto.gameAA(true);
                return;
            }
        } else {
            if (!Auto.gameAK && Char.getMyChar().isHuman) {
                this.gameAI();
                return;
            }

//            if (SetAuto.nvhn && n == SetAuto.gionvhn && n2 == SetAuto.phutnvhn && System.currentTimeMillis() - timenvhn >= 5000L) {
//                if (TileMap.mapID != 1) {
//                    if (!TileMap.truongandlang(TileMap.mapID)) {
//                        Auto.reAD();
//                    }
//                    TileMap.gameAL(1);
//                } else {
//                    Auto.Sleep(3000L);
//                    GameScr.gameAB(5, 1, 0);
//                    Auto.Sleep(2000L);
//                    GameScr.gameAB(25, 1, 0);
//                    Code.gameAA.gameAD();
//                }
//                GameScr.gameAC("Làm NVHN xong rồi!,nghỉ ngơi 1 phút rồi úp tiếp !");
//                Auto.Sleep(60000L);
//                timenvhn = System.currentTimeMillis();
//                return;
//            }

            if (super.mapID == TileMap.mapID && (super.gameAD || super.zoneID == TileMap.zoneID)) {
                if (Char.LuyenDa && Code.gameAH() && Char.gameBG() < 5 && !TileMap.isLangCo(TileMap.mapID)) {
                    Auto.reAD();
                    return;
                }

                this.gameAB(this.templateId, this.gameAA(Char.DanhQuai, Char.DanhTA, Char.DanhTL));
                this.gameAC(-1);
                return;
            } else if (this.mapID != TileMap.mapID && SetAuto.vbl) {
                AutoVBL.usevbl();
            } else {
                this.gameAA(super.mapID, super.zoneID, super.gameAE, super.gameAF);
            }
        }

    }

    public final String toString() {
        return this.templateId >= 0 && this.templateId < Mob.arrMobTemplate.length ? "Tàn sát " + Mob.arrMobTemplate[this.templateId].name : "Tàn sát";
    }
}
