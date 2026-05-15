
public final class LoiLoss extends Auto {

    private static boolean gameAV = false;
    private static boolean gameAW = false;
    private long gameAX = 0L;
    private long gameAY;

    public final void gameAL() {
        super.gameAC();
        gameAV = false;
        gameAW = false;
        this.gameAY = System.currentTimeMillis();
    }

    public final void gameAK() {
        if (reAC()) {
            if (TileMap.mapID == 160) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException var2) {
                }
            } else {
                Auto.gameAA(true);
            }
        } else {
            if (System.currentTimeMillis() - this.gameAY >= 30000L) {
                Code var10000 = Code.gameAA;
                Code.gameAH("chao e. a dung day tu chieu");
                this.gameAY = System.currentTimeMillis();
            }

            Code.gameAO();
            if (!gameAV && !gameAW) {
                if (TileMap.mapID == 110) {
                    gameAV = true;
                    gameAW = false;
                    return;
                }

                if (TileMap.mapID != FormDanhVong.MapLD) {
                    if (TileMap.mapID != 160 && TileMap.mapID != 129 && TileMap.mapID != 149) {
                        this.gameAA(FormDanhVong.MapLD, FormDanhVong.KhuLD, -1, -1);
                        return;
                    }

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var3) {
                    }

                    Auto.reAD();
                    return;
                }

                if (TileMap.zoneID != FormDanhVong.KhuLD) {
                    Auto.gameAA(FormDanhVong.KhuLD);
                    return;
                }
            } else if (gameAV && !gameAW) {
                if (TileMap.mapID == 160) {
                    gameAV = true;
                    gameAW = true;
                    return;
                }

                if (TileMap.mapID == 110) {
                    Npc var1 = GameScr.gameAI(0);
                    if (Char.getMyChar().cx == var1.cx && Char.getMyChar().cy == var1.cy) {
                        if (System.currentTimeMillis() - this.gameAX >= 2000L) {
                            GameScr.gameAH(0);
                            GameScr.PickNpc(0, 1, 0);
                            Service.gI().gameAA((short) 11212, (String) "1000");
                            GameCanvas.endDlg();

                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException var4) {
                            }

                            this.gameAX = System.currentTimeMillis();
                        }

                        return;
                    }

                    Char.gameAC(var1.cx, var1.cy);

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var5) {
                    }

                    this.gameAX = System.currentTimeMillis();
                    return;
                }
            } else if (gameAV && gameAW && TileMap.mapID != 160) {
                gameAV = false;
                gameAW = false;
            }

        }
    }

    public final String toString() {
        return "Lôi lose";
    }
}
