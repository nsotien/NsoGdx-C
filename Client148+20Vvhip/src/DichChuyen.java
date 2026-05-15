// Decompiled with: Procyon 0.6.0
// Class Version: 8
public final class DichChuyen implements Runnable
{
    private final Item gameAA;
    
    DichChuyen(Item gameAA) {
        this.gameAA = gameAA;
    }
    
    public final void run() {
        try {
            GameScr.gI().gameBG();
             MyVector gameAH = Char.gameAH(454);
             int size = gameAH.size();
            GameScr.gameDD = this.gameAA;
            if (size >= 20) {
                GameScr.gameMM = true;
                GameScr.gameCW = new Item[24];
                int n = 0;
                for (int i = 0; i < 20; ++i) {
                     Item item = (Item)gameAH.elementAt(gameAH.size() - 1);
                    GameScr.gameCW[n++] = item;
                    Char.getMyChar().arrItemBag[item.indexUI] = null;
                    gameAH.removeElementAt(gameAH.size() - 1);
                }
                Service.gI().gameAD(GameScr.gameDD, GameScr.gameCW);
                Service.gI().gameAJ(Char.getMyChar().charFocus.cName);
                Auto.Sleep(2000L);
            }
        }
        catch (final Exception ex) {
            GameScr.gameAC("Xong or Lỗi !!");
        }
    }
}