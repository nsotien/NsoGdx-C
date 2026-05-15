package base.game2;

public final class AutoLoiLoss extends Auto {

    private static boolean flagInMap110 = false;
    private static boolean flagInArena = false;
    private long timeLastBetXu = 0L;
    private long timeIn110;
    public boolean advAA;
    public int advAB;
    public boolean advAC;
    private long timeSelfAttack;
    private long timeChatMsg;
    private NLWatchdog watchdog = new NLWatchdog("nl");

    public final void reset() {
        super.reset();
        flagInMap110 = false;
        flagInArena = false;
        this.advAB = -1;
        this.advAA = false;
        this.advAC = false;
        this.timeChatMsg = System.currentTimeMillis();
        this.watchdog.reset();
        if (FormDanhVong.DEBUG_DV) ;
    }

    protected final void auto() {
        this.watchdog.tick();
        if (FormDanhVong.DEBUG_DV) ;
        if (isDead()) {
            if (TileMap.mapID == 111) {
                if (FormDanhVong.advAQ && this.advAA) {
                    this.advAA = false;
                    flagInMap110 = false;
                    flagInArena = false;
                    if (FormDanhVong.DEBUG_DV) ;
                    Relogin.time[0] = -1;
                    Session_ME.a().c();
                    phong.start_relogin();
                }

            } else {
                hoisinh(true);
                if (FormDanhVong.DEBUG_DV) ;
            }
        } else {
            if (System.currentTimeMillis() - this.timeChatMsg >= 30000L) {
                Service.gI().j("chao e. a dung day tu chieu");
                this.timeChatMsg = System.currentTimeMillis();
            }

            // Self-attack every 60s to stay "active"
            if (System.currentTimeMillis() - this.timeSelfAttack > 60000L) {
                this.timeSelfAttack = System.currentTimeMillis();
                MyVector var1 = new MyVector();
                var1.addElement(Char.getMyChar());
                Service.gI().sendPlayerAttack(new MyVector(), var1, 2);
                if (FormDanhVong.DEBUG_DV) ;
            }

            if (!flagInMap110 && !flagInArena) {
                if (TileMap.mapID == 110) {
                    flagInMap110 = true;
                    flagInArena = false;
                    this.timeIn110 = System.currentTimeMillis();
                    if (FormDanhVong.DEBUG_DV) ;
                    return;
                }

                if (TileMap.mapID != FormDanhVong.advAC || TileMap.zoneID != FormDanhVong.advAD) {
                    if (TileMap.mapID != 111 && TileMap.mapID != 129 && TileMap.mapID != 149) {
                        if (FormDanhVong.DEBUG_DV) ;
                        this.remap(FormDanhVong.advAC, FormDanhVong.advAD, -1, -1);
                        return;
                    } else {
                        phong.sleep(1000L);
                        tusat_vdmq();
                        return;
                    }
                }

                if (!this.advAC) {
                    GameScr.pickNPC(5, 1, 0);
                    if (LockGame.advAY()) {
                        this.advAC = true;
                        phong.sleep(1000L);
                        if (FormDanhVong.DEBUG_DV) ;
                    }
                }

                if (this.advAB > 0) {
                    if (FormDanhVong.DEBUG_DV) ;
                    Service.gI().m(this.advAB);
                    this.advAB = -1;
                    return;
                }

            } else if (flagInMap110 && !flagInArena) {
                if (TileMap.mapID == 111) {
                    flagInMap110 = true;
                    flagInArena = true;
                    if (FormDanhVong.DEBUG_DV) ;
                    return;
                }

                if (TileMap.mapID == 110) {
                    Npc var1 = GameScr.npc_i(0);
                    if (var1 != null && Char.getMyChar().cx1 == var1.cx1 && Char.getMyChar().cy1 == var1.cy1) {
                        if (System.currentTimeMillis() - this.timeLastBetXu >= 2000L) {
                            if (FormDanhVong.DEBUG_DV) ;
                            GameScr.pickNPC(0, 1, 0);
                            Service.gI().a((short) 3, String.valueOf(FormDanhVong.advAG));
                            phong.sleep(3000L);
                            this.timeLastBetXu = System.currentTimeMillis();
                        }

                        return;
                    }

                    if (var1 != null) {
                        Char.move(var1.cx1, var1.cy1);
                    }
                    phong.sleep(1000L);
                    this.timeLastBetXu = System.currentTimeMillis();
                    return;
                }

                if (System.currentTimeMillis() - this.timeIn110 > 30000L) {
                    flagInMap110 = false;
                    flagInArena = false;
                    if (FormDanhVong.DEBUG_DV) ;
                    return;
                }
            } else if (flagInMap110 && flagInArena && TileMap.mapID != 111) {
                flagInMap110 = false;
                flagInArena = false;
                phong.sleep(1000L);
                if (FormDanhVong.DEBUG_DV) ;
            }

        }
    }

    public final String toString() {
        return "AUTO LOSE";
    }
}
