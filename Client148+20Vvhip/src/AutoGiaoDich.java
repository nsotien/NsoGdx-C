// Decompiled with: Procyon 0.6.0
// Class Version: 8

public final class AutoGiaoDich extends Auto {

    private String gameAB;
    private boolean gameAC;
    public static short gameAA;

    public AutoGiaoDich(final String gameAB) {
        super.gameAC();
        this.gameAB = gameAB;
    }

    public static void gameAA(final String anObject) {
        final Char mychar = Char.getMyChar();
        int i = 0;
        while (true) {
            while (i < GameScr.vCharInMap.size()) {
                final Char achar;
                if ((achar = (Char) GameScr.vCharInMap.elementAt(i)).cName.equals(anObject)) {
                    final Char achar3;
                    final Char achar2 = achar3 = achar;
                    final Char achar4 = achar3;
                    if (achar2 == null) {
                        AutoGuiDo.gameAC = true;
                        return;
                    }
                    do {
                        if (Res.gameAA(mychar.cx, mychar.cy, achar4.cx, achar4.cy) >= 50) {
                            Char.gameAC(achar4.cx, achar4.cy);
                            Auto.Sleep(1000L);
                        } else {
                            Service.gI().gameAS(achar4.charID);
                        }
                    } while (!GameScr.isPaintTrade && !LockGame.LockAA(1000L));
                    final Item[] gameCS = new Item[12];
                    int n = 0;
                    for (int j = 0; j < mychar.arrItemBag.length; ++j) {
                        final Item item = mychar.arrItemBag[j];
                        if (n < 12 && item != null && item.template.id == AutoGiaoDich.gameAA && !item.isLock) {
                            gameCS[n++] = item;
                        }
                    }
                    GameScr.gI().gameEE = 0;
                    GameScr.gameCW = gameCS;
                    Service.gI().gameAA(0, gameCS);
                    GameScr.gI().gameEC = 1;
                    final long currentTimeMillis = System.currentTimeMillis();
                    while (GameScr.gI().typeTradeOrder != 1) {
                        if (AutoSell.gameAV || System.currentTimeMillis() - currentTimeMillis >= 20000L) {
                            Service.gI().gameAI();

                            return;
                        }
                        Auto.Sleep(200L);
                    }
                    while (System.currentTimeMillis() - System.currentTimeMillis() < 5000L) {
                        if (AutoSell.gameAV) {
                            return;
                        }
                        Auto.Sleep(200L);
                    }
                    Service.gI().gameAJ();
                    while (GameScr.gI().typeTradeOrder != 2) {
                        if (AutoSell.gameAV || System.currentTimeMillis() - currentTimeMillis >= 5000L) {
                            Service.gI().gameAI();
                            return;
                        }

                        Auto.Sleep(200L);
                    }
                    if (LockGame.LockAA(20000L)) {
                        for (int k = 0; k < 12; ++k) {
                            if (gameCS[k] != null) {
                                Char.getMyChar().arrItemBag[gameCS[k].indexUI] = null;
                            }
                        }
                    }
                    return;
                } else {
                    ++i;
                }
            }
            Char achar3;
            final Char achar2 = achar3 = null;
            continue;
        }
    }

    public final void gameAK() {
        if (Char.getMyChar().cHP <= 0) {
            Auto.gameAA(true);
            return;
        }
        if (this.gameAC) {
            return;
        }
        AutoSell.gameAV = false;
        while (agameAE() > 0) {
            gameAA(this.gameAB);
            if (AutoGuiDo.gameAA) {
                break;
            }
            if (agameAE() <= 0) {
                GameScr.gameAC("Hết!");
                break;
            }
            for (int i = 0; i < 30; ++i) {
                Auto.Sleep(1000L);
                GameScr.gameAC("Chờ " + (30 - i) + " s để gd tiếp !");
            }
        }
        GameScr.gameAC("Hành trang đối phương không còn đủ chỗ trống!");
        if (!AutoGuiDo.gameAA) {
            GameScr.gameAC("Đã hết vp cần gd trong hành trang, Hoặc đối phương k có trong khu vực này ! !");
        }
        this.gameAC = true;
        final Code gameAA = Code.gameAA;
        Code.gameAC();
    }

    public final String toString() {
        return "Auto GD";
    }

    public static int agameAE() {
        final Item[] arritembag = Char.getMyChar().arrItemBag;
        int n = 0;
        for (int i = 0; i < arritembag.length; ++i) {
            final Item item;
            if ((item = arritembag[i]) != null && item.template.id == AutoGiaoDich.gameAA && !item.isLock) {
                ++n;
            }
        }
        return n;
    }
}
