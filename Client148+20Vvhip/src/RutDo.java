// Decompiled with: Procyon 0.6.0
// Class Version: 8
public final class RutDo implements Runnable
{
    public final int gameAA;
    public static boolean gameAB;
    public static boolean gameAC;
    
    RutDo(final int gameAA) {
        this.gameAA = gameAA;
    }
    
    public static int gameAA() {
        final Item[] arritembox = Char.getMyChar().arrItemBox;
        int n = 0;
        for (int i = 0; i < arritembox.length; ++i) {
            if (arritembox[i] == null) {
                ++n;
            }
        }
        return n;
    }
    
    public static int gameAB() {
        final Item[] arritembag = Char.getMyChar().arrItemBag;
        int n = 0;
        for (int i = 0; i < arritembag.length; ++i) {
            if (arritembag[i] == null) {
                ++n;
            }
        }
        return n;
    }
    
    public final void run() {
        final int gameAA = gameAA();
        final int size = Char.gameAH(this.gameAA).size();
        final int size2 = Char.CheckItemBox(this.gameAA).size();
        final int gameAB = gameAB();
        if (RutDo.gameAB && gameAA > 0 && size > 0) {
            GameScr.gI().gameAD(4);
            for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
                final Item item = Char.getMyChar().arrItemBag[i];
                if (item != null && item.template.id == this.gameAA) {
                    Service.gI().gameAE(item.indexUI);
                }
            }
            RutDo.gameAB = false;
        }
        if (RutDo.gameAC && size2 > 0 && gameAB > 0) {
            GameScr.gI().gameAD(4);
            for (int j = 0; j < Char.getMyChar().arrItemBox.length; ++j) {
                final Item item2 = Char.getMyChar().arrItemBox[j];
                if (item2 != null && item2.template.id == this.gameAA) {
                    Service.gI().gameAD(item2.indexUI);
                }
            }
            RutDo.gameAC = false;
        }
    }
}
