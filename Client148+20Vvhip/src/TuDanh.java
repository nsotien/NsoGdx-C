
public final class TuDanh extends Auto {

    public final void gameAC() {
        super.gameAC();
        super.mapID = TileMap.mapID;
        super.zoneID = TileMap.zoneID;
        super.gameAE = Char.getMyChar().cx;
        super.gameAF = Char.getMyChar().cy;
    }

    public final void gameAK() {
        if (super.mapID == 134 || super.mapID == 135 || super.mapID == 136 || super.mapID == 137) {
            TanSat.mapid = super.mapID;
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

            if (super.mapID == TileMap.mapID && (super.gameAD || super.zoneID == TileMap.zoneID)) {
                this.gameAC(-1);
                this.gameAB(-1, -1);
                return;
            }
            if (this.mapID != TileMap.mapID && SetAuto.vbl) {
                AutoVBL.usevbl();
            }
            if (Char.ReMap) {
                this.gameAA(super.mapID, super.zoneID, super.gameAE, super.gameAF);
            }
        }

    }

    protected final Mob gameAA(Char var1, int var2, int var3, Char var4, boolean var5) {
        if (Code.gameAR && Code.gameAT.size() > 0) {
            this.gameAA(var3, var5);
            return Auto.gameAA(var1.cx, var1.cy);
        } else {
            return Auto.gameAA(var1.cx, var1.cy);
        }
    }

    public final String toString() {
        return "Tự đánh";
    }
}
