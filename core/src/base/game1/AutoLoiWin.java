package base.game1;

public final class AutoLoiWin extends Auto {

    private static boolean flagInMap110 = false;
    private static boolean flagInArena = false;
    private long timeEnterArena;
    private long timeLastInvite;
    private long timeLastBetXu = 0L;
    private long timeMoveToPK;
    private long timeIn110;
    private NLWatchdog watchdog = new NLWatchdog("nw");

    public final void reset() {
        super.reset();
        flagInMap110 = false;
        flagInArena = false;
        this.watchdog.reset();
        if (FormDanhVong.DEBUG_DV) ;
    }

    protected final void auto() {
        this.watchdog.tick();
        if (FormDanhVong.DEBUG_DV) ;
        if (isDead()) {
            if (TileMap.mapID != 111) {
                hoisinh(true);
                if (FormDanhVong.DEBUG_DV) ;
            }
        } else {
            int win1;
            Char aChar;
            Npc npc;
            if (!flagInMap110 && !flagInArena) {
                if (TileMap.mapID == 110) {
                    flagInMap110 = true;
                    flagInArena = false;
                    this.timeIn110 = System.currentTimeMillis();
                    if (FormDanhVong.DEBUG_DV) ;
                } else if (TileMap.mapID == FormDanhVong.advAC && TileMap.zoneID == FormDanhVong.advAD) {

                    npc = GameScr.npc_i(0);
                    if (npc != null && Char.getMyChar().cx1 == npc.cx1 && Char.getMyChar().cy1 == npc.cy1) {
                        for (win1 = 0; win1 < GameScr.vCharInMap.size(); ++win1) {
                            aChar = (Char) GameScr.vCharInMap.elementAt(win1);
                            if (FormDanhVong.advAB.equals(aChar.cName) && System.currentTimeMillis() - this.timeLastInvite >= 5000L) {
                                if (FormDanhVong.DEBUG_DV) ;
                                Service.gI().a((short) 2, FormDanhVong.advAB);
                                this.timeLastInvite = System.currentTimeMillis();
                            }
                        }
                        return;
                    } else {
                        if (npc != null) {
                            Char.move(npc.cx1, npc.cy1);
                        }
                        phong.sleep(1000L);
                    }

                } else if (TileMap.mapID != 111 && TileMap.mapID != 129 && TileMap.mapID != 149) {
                    if (FormDanhVong.DEBUG_DV) ;
                    this.remap(FormDanhVong.advAC, FormDanhVong.advAD, -1, -1);
                } else {
                    phong.sleep(1000L);
                    tusat_vdmq();
                }
            } else {
                if (flagInMap110 && !flagInArena) {
                    if (TileMap.mapID == 111) {
                        flagInMap110 = true;
                        flagInArena = true;
                        this.timeEnterArena = System.currentTimeMillis();
                        if (FormDanhVong.DEBUG_DV) ;
                        return;
                    }

                    if (TileMap.mapID == 110) {
                        npc = GameScr.npc_i(0);
                        if (npc != null && Char.getMyChar().cx1 == npc.cx1 && Char.getMyChar().cy1 == npc.cy1) {
                            if (System.currentTimeMillis() - this.timeLastBetXu >= 3000L) {
                                if (FormDanhVong.DEBUG_DV) ;
                                GameScr.pickNPC(0, 1, 0);
                                Service.gI().a((short) 3, String.valueOf(FormDanhVong.advAG));

                                phong.sleep(3000L);
                                this.timeLastBetXu = System.currentTimeMillis();
                            }

                            return;
                        }

                        if (npc != null) {
                            Char.move(npc.cx1, npc.cy1);
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
                } else if (flagInMap110 && flagInArena) {
                    if (TileMap.mapID != 111) {
                        flagInMap110 = false;
                        flagInArena = false;
                        this.timeEnterArena = System.currentTimeMillis();
                        phong.sleep(2000L);
                        if (FormDanhVong.DEBUG_DV) ;
                        return;
                    }

                    if (System.currentTimeMillis() - this.timeEnterArena >= 59000L) {
                        aChar = null;

                        for (win1 = 0; win1 < GameScr.vCharInMap.size(); ++win1) {
                            Char aChar1;
                            if ((aChar1 = (Char) GameScr.vCharInMap.elementAt(win1)).cName.equals(FormDanhVong.advAB)) {
                                aChar = aChar1;
                                break;
                            }
                        }

                        if (aChar == null) {
                            if (FormDanhVong.DEBUG_DV) ;
                            // No timeLengthMap/timeStartMap in V8 -- use simple timeout
                            if (System.currentTimeMillis() - this.timeEnterArena > 300000L) {
                                flagInMap110 = false;
                                flagInArena = false;
                                this.timeEnterArena = System.currentTimeMillis();
                                phong.sleep(2000L);
                                if (FormDanhVong.DEBUG_DV) ;
                            }

                            return;
                        }

                        if (FormDanhVong.DEBUG_DV) ;
                        if (Auto.my_skill != null && aChar.cHP > 0) {
                            Skill var6 = Auto.my_skill;
                            Char var4 = Char.getMyChar();
                            if (var6.template.type == 2) {
                                Service.gI().selectSkill(var6.template.id);
                                Service.gI().r();
                            } else {
                                if ((var6.template.type == 1 || var6.template.type == 3) && (Res.e(var4.cx1 - aChar.cx1) > var6.dx + 30 || Res.e(var4.cy1 - aChar.cy1) > var6.dy + 30) && System.currentTimeMillis() - this.timeMoveToPK > 1500L) {
                                    Char.move(aChar.cx1, aChar.cy1);
                                    this.timeMoveToPK = System.currentTimeMillis();
                                }

                                Auto.vect_mons.removeAllElements();
                                Auto.vect_player.removeAllElements();
                                Auto.vect_player.addElement(aChar);
                                Service.gI().selectSkill(var6.template.id);
                                Service.gI().sendPlayerAttack(Auto.vect_mons, Auto.vect_player, 2);
                            }

                            if (System.currentTimeMillis() - var6.lastTimeUseThisSkill >= (long) var6.coolDown + 50L) {
                                var6.lastTimeUseThisSkill = System.currentTimeMillis();
                                var6.l = true;
                                if (!Code.dongbang_skill) {
                                    var4.b(GameScr.aa[var6.template.id], 0);
                                }
                            }

                            this.s = System.currentTimeMillis();
                        }
                    }
                }

            }
        }
    }

    public final String toString() {
        return "AUTO WIN";
    }
}
