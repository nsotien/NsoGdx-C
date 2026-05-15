
public final class LoiWin extends Auto {

    private static boolean gameAV = false;
    private static boolean gameAW = false;
    private long gameAX;
    private long gameAY;
    private long gameAZ = 0L;
    private long gameBA;

    public final void gameAL() {
        super.gameAC();
        gameAV = false;
        gameAW = false;
    }

    public final void gameAK() {
        if (reAC()) {
            if (TileMap.mapID == 160) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException var4) {
                }
            } else {
                Auto.gameAA(true);
            }
        } else {
            int var1;
            Char var2;
            Npc var10;
            if (!gameAV && !gameAW) {
                if (TileMap.mapID == 110) {
                    gameAV = true;
                    gameAW = false;
                    return;
                }

                if (TileMap.mapID == FormDanhVong.MapLD && TileMap.zoneID == FormDanhVong.KhuLD) {
                    var10 = GameScr.gameAI(0);
                    if (Char.getMyChar().cx == var10.cx && Char.getMyChar().cy == var10.cy) {
                        for (var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
                            String[] s = Code.gameAC(FormDanhVong.TenDoiThu, ",");
                            for (int l = 0; l < s.length; ++l) {
                                var2 = (Char) GameScr.vCharInMap.elementAt(var1);
                                if (s[l].equals(var2.cName) && System.currentTimeMillis() - this.gameAY >= 5000L) {
                                    GameScr.gameAH(0);

                                    GameScr.PickNpc(0, 3, 0);
                                    Service.gI().gameAA((short) 11211, (String) s[l]);
                                    GameCanvas.endDlg();
                                    this.gameAY = System.currentTimeMillis();
                                }
                            }
                        }
                        return;
                    }

                    Char.gameAC(var10.cx, var10.cy);

                    try {
                        Thread.sleep(1000L);
                        return;
                    } catch (InterruptedException var5) {
                        return;
                    }
                }

                if (TileMap.mapID != FormDanhVong.MapLD) {
                    if (TileMap.mapID != 160 && TileMap.mapID != 129 && TileMap.mapID != 149) {
                        this.gameAA(FormDanhVong.MapLD, FormDanhVong.KhuLD, -1, -1);
                        return;
                    }

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var6) {
                    }

                    Auto.reAD();
                    return;
                }

                Auto.gameAA(FormDanhVong.KhuLD);
                return;
            } else if (gameAV && !gameAW) {
                if (TileMap.mapID == 160) {
                    this.gameAX = System.currentTimeMillis();
                    gameAV = true;
                    gameAW = true;
                    return;
                }

                if (TileMap.mapID == 110) {
                    var10 = GameScr.gameAI(0);
                    if (Char.getMyChar().cx != var10.cx || Char.getMyChar().cy != var10.cy) {
                        Char.gameAC(var10.cx, var10.cy);

                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException var8) {
                        }

                        this.gameAZ = System.currentTimeMillis();
                        return;
                    }

                    if (System.currentTimeMillis() - this.gameAZ >= 3000L) {
                        GameScr.gameAH(0);
                        GameScr.PickNpc(0, 1, 0);
                        Service.gI().gameAA((short) 11212, (String) "1000");
                        GameCanvas.endDlg();

                        try {
                            Thread.sleep(3000L);
                        } catch (InterruptedException var7) {
                        }

                        this.gameAZ = System.currentTimeMillis();
                        return;
                    }
                }
            } else if (gameAV && gameAW) {
                if (TileMap.mapID != 160) {
                    gameAV = false;
                    gameAW = false;
                    this.gameAX = System.currentTimeMillis();
                    return;
                }

                if (System.currentTimeMillis() - this.gameAX >= 59000L) {
                    var2 = null;

                    for (var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
                        String[] s = Code.gameAC(FormDanhVong.TenDoiThu, ",");
                        for (int l = 0; l < s.length; ++l) {
                            Char var3;
                            if ((var3 = (Char) GameScr.vCharInMap.elementAt(var1)).cName.equals(s[l])) {
                                var2 = var3;
                                break;
                            }
                        }
                    }

                    if (var2 == null) {
                        gameAV = false;
                        gameAW = false;
                        this.gameAX = System.currentTimeMillis();
                        return;
                    }

                    if (Auto.skill1 != null && var2.cHP > 0) {
                        Skill var11 = Auto.skill1;
                        Char var9 = Char.getMyChar();
                        if (var11.template.type == 2) {
                            Service.gI().gameAG(var11.template.id);
                            Service.gI().gameAR();
                        } else {
                            if ((var11.template.type == 1 || var11.template.type == 3) && (Res.abs(var9.cx - var2.cx) > var11.dx + 30 || Res.abs(var9.cy - var2.cy) > var11.dy + 30) && System.currentTimeMillis() - this.gameBA > 1500L) {
                                Auto.gameAC(var2);
                                this.gameBA = System.currentTimeMillis();
                            }

                            Auto.reAE.removeAllElements();
                            Auto.reAF.removeAllElements();
                            Auto.reAF.addElement(var2);
                            Service.gI().gameAG(var11.template.id);
                            Service.gI().gameAA((MyVector) Auto.reAE, (MyVector) Auto.reAF, (int) 2);
                        }

                        if (System.currentTimeMillis() - var11.lastTimeUseThisSkill >= (long) var11.coolDown + 50L) {
                            var11.lastTimeUseThisSkill = System.currentTimeMillis();
                            var11.paintCanNotUseSkill = true;
                            if (!Code.timBG) {
                                var9.gameAB(GameScr.sks[var11.template.id], 0);
                            }
                        }

                        super.gameAR = System.currentTimeMillis();
                    }
                }
            }

        }
    }

    public final String toString() {
        return "Lôi win";
    }
}
