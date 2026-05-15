
public abstract class Auto {

    public boolean gameAA;
    public int mapID;
    public int zoneID;
    public boolean gameAD;
    public int gameAE;
    public int gameAF;
    private int gameAV;
    private int gameAW;
    public int gameAG;
    public long gameAH;
    public long gameAI;
    public Auto reAB;
    public static boolean gameAK;
    public static Skill skill1;
    public static boolean gameAM;
    public static MyVector gameAN = new MyVector();
    private static MyVector gameAX = new MyVector();
    public static int gameAO = 0;
    private static boolean gameAY = false;
    private static long gameAZ = -1L;
    public static MyVector reAE = new MyVector();
    public static MyVector reAF = new MyVector();
    protected long gameAR = 0L;
    protected long gameAS = 0L;
    protected long gameAT = 0L;
    protected boolean gameAU = false;
    private static MyVector gameBA = new MyVector();
    private static long gameBB = 0L;
    public static Skill skill5;
    public static Skill skill2;
    public static Skill skill3;
    public static Skill skill4;

    public static void gameAA(Mob var0) {
        if (var0.isBoss || var0.status != 0 && var0.levelBoss != 3 && var0.maxHp != var0.getTemplate().hp) {
            if (!var0.isBoss && var0.levelBoss == 0) {
                if (var0.maxHp == 10 * var0.getTemplate().hp) {
                    var0.levelBoss = 1;
                } else {
                    if (var0.maxHp != 100 * var0.getTemplate().hp && var0.templateId != 89) {
                        return;
                    }

                    var0.levelBoss = 2;
                }
            }

            if (!gameAN.contains(var0)) {
                gameAN.addElement(var0);
            }
        }

    }

    public static void gameAB(Mob var0) {
        gameAN.removeElement(var0);
    }

    public static void gameAA() {
        gameAN.removeAllElements();
    }

    public static void gameAA(Char var0) {
        if (var0 != Char.getMyChar()) {
            if (gameAX.contains(var0)) {
                if (var0.cTypePk != 3 && var0.killCharId != Char.getMyChar().charID) {
                    gameAX.removeElement(var0);
                    return;
                }
            } else if (var0.cTypePk == 3 || var0.killCharId == Char.getMyChar().charID) {
                gameAX.addElement(var0);
                if (LockGame.gameAB && Res.abs(Char.getMyChar().cx - var0.cx) <= 300 && Res.abs(Char.getMyChar().cy - var0.cy) <= 300) {
                    LockGame.gameAD();
                }
            }
        }

    }

    public static void gameAB() {
        gameAX.removeAllElements();
    }

    public void gameAC() {
        this.mapID = -1;
        this.zoneID = -1;
        this.gameAD = false;
        this.reAB = null;
        this.gameAG = Char.getMyChar().yen;
        this.gameAH = Char.getMyChar().cEXP;
        this.gameAI = System.currentTimeMillis();
        this.gameAA = false;
        Code.gameAS = -1;
        Code.gameAW = 0;
        gameAK = Char.getMyChar().isHuman;
        skill1 = Char.getMyChar().myskill;
        this.gameAD();
    }

    public void gameAD() {
        gameAM = false;
        Code.gameBC = System.currentTimeMillis();
    }

    protected static boolean gameAB(Char var0) {
        return var0.cHP <= 0 || var0.statusMe == 14 || var0.statusMe == 5;
    }

    protected static boolean reAC() {
        return gameAB(Char.getMyChar());
    }

    public static void Sleep(long var0) {
        try {
            Thread.sleep(var0);
        } catch (InterruptedException var2) {
        }
    }

    protected final void gameAA(int var1, int var2, int var3, int var4) {
        if ((var1 < 139 || var1 > 148) && TileMap.mapID >= 139 && TileMap.mapID <= 148) {
            reAD();
        } else {

            if (TileMap.mapID != var1) {
                if (!TileMap.GoMap(var1)) {
                    if (TileMap.isLangCo(var1)) {
                        try {
                            Thread.sleep(100L);
                            return;
                        } catch (InterruptedException var7) {
                        }
                    }

                    return;
                }

                if (var2 >= -1 && TileMap.zoneID != var2) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException var6) {
                    }
                } else {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException var5) {
                    }
                }
            }

            if (var2 == -1) {
                if (Code.gameAV) {
                    int[] var8 = Code.gameAX;
                    Code.gameAW = 0;
                    gameAA(this.zoneID = var8[0]);
                } else {
                    this.gameAB(var2);
                }
            } else if (var2 >= 0) {
                gameAA(var2);
            }

            if (TileMap.zoneID == this.zoneID && var3 > 0 && var4 > 0 && Char.getMyChar().cx != var3 && Char.getMyChar().cy != var4) {
                if (this instanceof TuDanh || this instanceof PkBoss) {
                    Char.gameAC(var3, var4);
                    return;
                }

                this.gameAC(gameAA(var3, var4));
            }

        }
    }

    public static void reAD() {
        Char var0 = Char.getMyChar();
        if (!Char.gameAJ(37) && !Char.gameAJ(35)) {
            Npc var1;
            if ((var1 = GameScr.gameAI(13)) != null && Math.abs(var1.cx - var0.cx) <= 400 && Math.abs(var1.cy - var0.cy) <= 400) {
                Char.gameAC(var1.cx > 400 ? var1.cx - 400 : var1.cx + 400, var1.cy);
            }

            Service.gI().gameAE();
        } else {
            Char.gameAC(var0.cx, TileMap.pxh);
        }

        long var4 = System.currentTimeMillis();

        while (var0.cHP > 0 && System.currentTimeMillis() - var4 < 0L) {
            try {
                Thread.sleep(0L);
            } catch (InterruptedException var3) {
            }
        }

    }

    protected static void gameAA(boolean var0) {
        Char var1 = Char.getMyChar();
        if (var0) {
            if (gameAY) {
                if (System.currentTimeMillis() - gameAZ < 200L) {
                    return;
                }

                gameAY = false;
            } else if (Char.DanhNhom && GameScr.vParty.size() > 0) {
                for (int var5 = 0; var5 < GameScr.vParty.size(); ++var5) {
                    Party var2;
                    if ((var2 = (Party) GameScr.vParty.elementAt(var5)).charId != var1.charID && var2.c != null && var2.c.cHP > 0 && var2.c.nClass.classId == 6) {
                        GameScr.gameAC("Chờ hồi sinh!");
                        gameAZ = System.currentTimeMillis();
                        gameAY = true;
                        return;
                    }
                }
            }
        }

        try {
            Thread.sleep(50L);
        } catch (InterruptedException var4) {
        }

        gameAN.removeAllElements();
        gameAM = false;
        LockGame.gameAA = true;
        if (Code.HoiSinhLuong && Char.getMyChar().luong > 0) {
            Service.gI().gameAL();
        } else {
            Service.gI().gameAK();
            TileMap.gameAF();
        }
        LockGame.gameAA = false;

        try {
            Thread.sleep(50L);
        } catch (InterruptedException var3) {
        }
    }

    protected static void gameAA(int var0) {
        if (TileMap.zoneID != var0) {
            Npc var1 = GameScr.gameAI(13);
            int var2 = -1;
            if (var1 != null && var1.statusMe != 15) {
                if (Math.abs(var1.cx - Char.getMyChar().cx) > 22 || Math.abs(var1.cy - Char.getMyChar().cy) > 22) {
                    Char.gameAC(var1.cx, var1.cy);

                    try {
                        Thread.sleep(0L);
                    } catch (InterruptedException var3) {
                    }
                }
            } else {
                if (TileMap.mapID != 99 && TileMap.mapID != 103 && TileMap.mapID != 134 && TileMap.mapID != 135 && TileMap.mapID != 136 && TileMap.mapID != 137) {
                    return;
                }

                if ((var2 = Char.gameAI(37)) < 0 && (var2 = Char.gameAI(35)) < 0) {
                    return;
                }
            }

            if (System.currentTimeMillis() - gameBB < 0L) {
                return;
            }

            Service.gI().gameAA(var0, var2);
            TileMap.gameAF();
            gameBB = System.currentTimeMillis();

            try {
                Thread.sleep(0L);
                return;
            } catch (InterruptedException var4) {
            }
        }

    }

    protected final void gameAB(int var1) {
        if (!this.gameAA || Code.gameAH == null || Char.getMyChar().cName.equals(Code.gameAH)) {
            GameScr var2 = GameScr.gI();
            Npc var3 = GameScr.gameAI(13);
            int var4 = -1;
            if (var3 != null && var3.statusMe != 15) {
                if (Math.abs(var3.cx - Char.getMyChar().cx) > 22 || Math.abs(var3.cy - Char.getMyChar().cy) > 22) {
                    Char.gameAC(var3.cx, var3.cy);

                    try {
                        Thread.sleep(0L);
                    } catch (InterruptedException var7) {
                    }
                }
            } else {
                if (TileMap.mapID != 99 && TileMap.mapID != 103 && TileMap.mapID != 134 && TileMap.mapID != 135 && TileMap.mapID != 136 && TileMap.mapID != 137) {
                    this.zoneID = TileMap.zoneID;
                    gameBB = System.currentTimeMillis();
                    return;
                }

                if ((var4 = Char.gameAI(37)) < 0 && (var4 = Char.gameAI(35)) < 0) {
                    this.zoneID = TileMap.zoneID;
                    gameBB = System.currentTimeMillis();
                    return;
                }
            }

            if (System.currentTimeMillis() - gameBB < 0L) {
                return;
            }

            Service.gI().gameAE();
            LockGame.gameAE();
            int var9 = -1;
            if (var1 < 0) {
                var1 = var2.zones.length - 1;
            } else if (var1 >= var2.zones.length) {
                var1 = 0;
            }

            if (this instanceof TaThu) {
                var9 = (var1 / 5 + 1) * 5 % var2.zones.length;
            } else if (!Char.DanhQuai) {
                var9 = (var1 + 1) % var2.zones.length;
            } else {
                int var5 = -1;

                for (int var6 = (var1 + 1) % var2.zones.length; var6 != var1; var6 = (var6 + 1) % var2.zones.length) {
                    if (var5 == -1 || var2.zones[var6] < var5) {
                        var9 = var6;
                        var5 = var2.zones[var6];
                    }
                }
            }

            Service.gI().gameAA(var9, var4);
            this.zoneID = var9;
            TileMap.gameAF();
            if (this.gameAL()) {
                Service.gI().gameAK("khu " + var9);
            }

            gameBB = System.currentTimeMillis();

            try {
                Thread.sleep(0L);
                return;
            } catch (InterruptedException var8) {
            }
        }

    }

    private static boolean gameAA(Mob var0, int var1) {
        return (var0.templateId != 202 || var0.status != 8) && (var1 < 0 || var0.templateId == var1);
    }

    private static boolean gameAC(int var0, int var1) {
        return var1 < 0 || var0 == 0 && (var1 & 1) > 0 || var0 == 1 && (var1 & 2) > 0 || var0 == 2 && (var1 & 4) > 0 || var0 == 3 && (var1 & 8) > 0;
    }

    public final int gameAA(boolean var1, boolean var2, boolean var3) {
        if (this.gameAD) {
            return -1;
        } else {
            int var4 = 0;
            if (var1) {
                var4 = 1;
            }

            if (var2) {
                var4 |= 2;
            }

            if (var3) {
                var4 |= 4;
            }

            return var4;
        }
    }

    protected static boolean gameAA(Char var0, Char var1) {
        return var1.statusMe != 14 && var1.statusMe != 5 && var1.statusMe != 15 && (var1.cTypePk == 3 || var0.cTypePk == 3 || var1.cTypePk == 1 && var0.cTypePk == 1 || var1.cTypePk == 5 && var0.cTypePk == 4 || var1.cTypePk == 4 && var0.cTypePk == 5 || var0.killCharId >= 0 && var0.killCharId == var1.charID || var0.testCharId >= 0 && var0.testCharId == var1.charID || var1.killCharId >= 0 && var1.killCharId == var0.charID);
    }

    protected final void gameAC(Mob var1) {
        if (var1 != null) {
            int var2 = var1.xFirst;
            int var3 = var1.yFirst;
            Char var4 = Char.getMyChar();
            if (TileMap.mapID == 35) {
                if (var1.xFirst == 1428 && var1.yFirst == 528) {
                    var2 = 1452;
                    var3 = 552;
                } else if (var1.xFirst == 1284 && var1.yFirst == 528) {
                    var2 = 1308;
                    var3 = 552;
                } else if (var1.xFirst == 1836 && var1.yFirst == 648) {
                    var2 = 1812;
                    var3 = 672;
                }
            } else if (TileMap.mapID == 37) {
                if ((var1.xFirst == 876 || var1.xFirst == 900) && var1.yFirst == 408) {
                    var2 = 900;
                    var3 = 432;
                } else if ((var1.xFirst == 828 || var1.xFirst == 852) && var1.yFirst == 360) {
                    var2 = 852;
                    var3 = 384;
                } else if ((var1.xFirst == 924 || var1.xFirst == 876) && var1.yFirst == 624) {
                    var2 = 924;
                    var3 = 648;
                } else if (var1.xFirst == 732 && var1.yFirst == 600 || var1.xFirst == 756 && var1.yFirst == 576) {
                    var2 = 756;
                    var3 = 600;
                }
            }

            if (Char.gameAD(var2, var3)) {
                this.gameAV = this.gameAE;
                this.gameAW = this.gameAF;
                this.gameAE = var4.cx;
                this.gameAF = var4.cy;
                var4.mobFocus = var1;

                try {
                    Thread.sleep(0L);
                    return;
                } catch (InterruptedException var5) {
                    return;
                }
            }

            var4.mobFocus = null;
        }

    }

    protected static void gameAC(Char var0) {
        if (var0 != null) {
            Char var1 = Char.getMyChar();
            Char.gameAC(var0.cx, TileMap.gameAD(var0.cx, var0.cy));
            var1.charFocus = var0;

            try {
                Thread.sleep(1L);
                return;
            } catch (InterruptedException var2) {
            }
        }

    }

    public static void gameAA(SkillPaint var0) {
        if (reAE.size() > 0 || reAF.size() > 0) {
            EffectPaint[] var1 = new EffectPaint[reAE.size() + reAF.size()];

            int var2;
            for (var2 = 0; var2 < reAE.size(); ++var2) {
                var1[var2] = new EffectPaint();
                var1[var2].effCharPaint = GameScr.efs[var0.id - 1];
                var1[var2].eMob = (Mob) reAE.elementAt(var2);
            }

            for (var2 = 0; var2 < reAF.size(); ++var2) {
                var1[var2 + reAE.size()] = new EffectPaint();
                var1[var2 + reAE.size()].effCharPaint = GameScr.efs[var0.id - 1];
                var1[var2 + reAE.size()].eChar = (Char) reAF.elementAt(var2);
            }

            if (var1.length > 1) {
                EPosition var4 = new EPosition();
                if (var1[0].eMob != null) {
                    var4 = new EPosition(var1[0].eMob.x, var1[0].eMob.y);
                } else if (var1[0].eChar != null) {
                    var4 = new EPosition(var1[0].eChar.cx, var1[0].eChar.cy);
                }

                MyVector var5 = new MyVector();

                for (int var3 = 1; var3 < var1.length; ++var3) {
                    if (var1[var3].eMob != null) {
                        var5.addElement(new EPosition(var1[var3].eMob.x, var1[var3].eMob.y));
                    } else if (var1[var3].eChar != null) {
                        var5.addElement(new EPosition(var1[var3].eChar.cx, var1[var3].eChar.cy));
                    }

                    if (var3 > 5) {
                        break;
                    }
                }

                Lightning.gameAA(var5, var4, true, Char.getMyChar().gameAW());
            }

            Char.getMyChar().effPaints = var1;
        }

    }

    private boolean gameAL() {
        return this.gameAA && GameScr.vParty.size() > 0 && ((Party) GameScr.vParty.firstElement()).charId == Char.getMyChar().charID;
    }

    protected final boolean gameAG() {
        return this.gameAA && GameScr.vParty.size() > 0 && ((Party) GameScr.vParty.firstElement()).charId != Char.getMyChar().charID;
    }

    private void gameAM() {
        if (Code.gameAV) {
            gameAA(this.zoneID = Code.gameAX[Code.gameAW = (Code.gameAW + 1) % Code.gameAX.length]);
            if (this.gameAL()) {
                Service.gI().gameAK("khu " + this.zoneID);
                return;
            }
        } else {
            this.gameAB(TileMap.zoneID);
        }

    }

    private boolean gameAA(int var1, int var2, int var3) {
        if (var1 >= 4) {
            return false;
        } else {
            for (int var4 = 0; var4 < gameAN.size(); ++var4) {
                Mob var5;
                if ((var5 = (Mob) gameAN.elementAt(var4)).levelBoss != 0 && var5.hp > 0 && var5.status != 0) {
                    boolean var6;
                    label71:
                    {
                        if (var5.levelBoss == 3) {
                            if (this instanceof TaThu || this instanceof TuDanh) {
                                var6 = false;
                                break label71;
                            }
                        } else if ((!var5.isBoss || (var1 & 6) == 6) && (var5.levelBoss != 1 || (var1 & 2) != 0) && (var5.levelBoss != 2 || (var1 & 4) != 0)) {
                            var6 = false;
                            break label71;
                        }

                        var6 = true;
                    }

                    if (var6 && Res.abs(var2 - var5.xFirst) <= 200 && Res.abs(var3 - var5.yFirst) <= 100) {
                        return true;
                    }
                } else {
                    gameAN.removeElement(var5);
                    --var4;
                }
            }

            return false;
        }
    }

    private boolean gameAD(int var1, int var2) {
        if (Char.NePk && !(this instanceof TaThu)) {
            for (int var3 = 0; var3 < gameAX.size(); ++var3) {
                Char var4;
                if (!gameAB(var4 = (Char) gameAX.elementAt(var3)) && Res.abs(var1 - var4.cx) <= 300 && Res.abs(var2 - var4.cy) <= 300) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    protected static Mob gameAA(int var0, int var1) {
        Mob var2 = null;
        Char var3 = Char.getMyChar();
        int var4 = var0 - var3.gameAD() - 10;
        int var5 = var0 + var3.gameAD() + 10;
        int var6 = var1 - var3.gameAE() - (var3.nClass.classId != 0 && var3.nClass.classId != 1 && var3.nClass.classId != 3 && var3.nClass.classId != 5 ? 0 : 40);
        int var12;
        if ((var12 = var1 + var3.gameAE()) > var1 + 30) {
            var12 = var1 + 30;
        }

        int var7 = -1;

        for (int var8 = 0; var8 < GameScr.vMob.size(); ++var8) {
            Mob var9 = (Mob) GameScr.vMob.elementAt(var8);
            int var10 = Math.abs(var0 - var9.x);
            int var11 = Math.abs(var1 - var9.y);
            var10 = var10 > var11 ? var10 : var11;
            if (var4 <= var9.x && var9.x <= var5 && var6 <= var9.y && var9.y <= var12 && var9.status != 0 && var9.status != 1 && (var7 == -1 || var10 < var7)) {
                var2 = var9;
                var7 = var10;
            }
        }

        return var2;
    }

    protected final void gameAA(int var1, boolean var2) {
        if (Code.gameAS < 0 || Code.gameAS >= Code.gameAT.size()) {
            Code.gameAS = 0;
        }

        while (true) {
            int var3 = ((Integer) Code.gameAT.elementAt(Code.gameAS)).intValue();
            int var4 = ((Integer) Code.gameAU.elementAt(Code.gameAS)).intValue();
            Mob var5 = gameAA(var3, var4);
            if (!this.gameAA(var1, var3, var4) && !this.gameAD(var3, var4) && var5 != null && !this.gameAA(var1, var5.x, var5.y)) {
                this.gameAV = Char.getMyChar().cx;
                this.gameAW = Char.getMyChar().cy;
                Char.gameAC(var3, var4);
                Char.getMyChar().mobFocus = var5;
                Service.gI().gameAB(var5.mobId);

                try {
                    Thread.sleep(1L);
                    return;
                } catch (InterruptedException var6) {
                    return;
                }
            }

            if (++Code.gameAS == Code.gameAT.size()) {
                Code.gameAS = 0;
                if (Char.ChuyenMapHetQuai && var2) {
                    this.gameAM();
                }
            }
        }
    }

    protected Mob gameAA(Char var1, int var2, int var3, Char var4, boolean var5) {
        if (Code.gameAR && Code.gameAT.size() > 0) {
            this.gameAA(var3, var5);
            return gameAA(var1.cx, var1.cy);
        } else {
            int var6 = var3;
            int var7 = var2;
            var3 = var1.cy;
            var2 = var1.cx;
            Auto var21 = this;
            int var8 = -1;
            int var9 = -1;
            int var10 = -1;
            Mob var11 = null;
            MyVector var12 = GameScr.vMob;
            int var13 = 0;

            Mob var22;
            while (true) {
                if (var13 >= var12.size()) {
                    var22 = var11;
                    break;
                }

                Mob var14;
                if ((var14 = (Mob) var12.elementAt(var13)) != null && var14.hp > 0 && var14.status != 0 && var14.status != 1 && gameAA(var14, var7) && gameAC(var14.levelBoss, var6) && (var4 == null || var4.charID == Char.getMyChar().charID || Res.gameAA(var14.xFirst, var14.yFirst, var4.cx, var4.cy) <= 1000) && !var21.gameAA(var6, var14.x, var14.y) && !var21.gameAD(var14.x, var14.y)) {
                    if (var21.gameAD) {
                        if (var21.mapID != 157 && var21.mapID != 158 && var21.mapID != 159) {
                            if (var8 == -1 || var14.levelBoss < var10 || var14.yFirst < var8 || var14.yFirst == var8 && var14.xFirst < var9) {
                                var10 = var14.levelBoss;
                                var8 = var14.yFirst;
                                var9 = var14.xFirst;
                                var11 = var14;
                            }
                        } else if (var14.isBoss) {
                            var22 = var14;
                            break;
                        }
                    } else if (Code.gameAN == -1 || Res.gameAA(Code.gameAO, Code.gameAP, var14.xFirst, var14.yFirst) <= Code.gameAN) {
                        MyVector var15 = var12;
                        Mob var16 = var14;
                        int var17 = 0;

                        int var18;
                        for (var18 = 0; var18 < var15.size(); ++var18) {
                            Mob var19;
                            if ((var19 = (Mob) var15.elementAt(var18)) != null && var19.hp > 0 && var19.status != 0 && var19.status != 1 && gameAA(var16, var7) && gameAC(var16.levelBoss, var6) && Res.abs(var19.x - var16.x) <= 100 && Res.abs(var19.y - var16.y) <= 50) {
                                ++var17;
                            }
                        }

                        if (var17 > skill1.maxFight) {
                            var17 = skill1.maxFight;
                        }

                        var17 = var16.levelBoss << 4 | var17 & 15;
                        var18 = var4 != null && var4.charID != Char.getMyChar().charID ? Res.gameAA(var4.cx, var4.cy, var14.xFirst, var14.yFirst) : Res.gameAA(var2, var3, var14.xFirst, var14.yFirst);
                        if (var17 > var10 || var17 == var10 && var18 < var8) {
                            var10 = var17;
                            var8 = var18;
                            var11 = var14;
                        }
                    }
                }

                ++var13;
            }

            if (var22 != null) {
                this.gameAC(var22);
                return var22;
            } else {
                if (System.currentTimeMillis() - this.gameAR > 100L && !this.gameAH()) {
                    if (this.gameAD) {
                        int var23;
                        if ((var23 = TileMap.gameAH(TileMap.mapID)) >= 0) {
                            this.mapID = var23;
                        }

                        this.gameAE = this.gameAF = -1;

                        try {
                            Thread.sleep(5L);
                        } catch (InterruptedException var20) {
                        }
                    } else if (var5 && Char.ChuyenMapHetQuai) {
                        this.gameAM();
                    }
                }

                return null;
            }
        }
    }

    protected final Char gameAA(Char var1, int var2) {
        for (int var3 = 0; var3 < GameScr.vCharInMap.size(); ++var3) {
            Char var4;
            if ((var4 = (Char) GameScr.vCharInMap.elementAt(var3)) != null && !gameAB(var4) && !this.gameAA(var2, var4.cx, var4.cy) && !this.gameAD(var4.cx, var4.cy) && !Code.gameAD(var4.cName) && SavePk.gameAC(var4.cName) && (var4.cTypePk == 1 || var4.killCharId == var1.charID || var1.cPk < 15)) {
                return var4;
            }
        }

        return null;
    }

    protected static Char gameAD(Char var0) {
        Char var1 = var0;
        int var2 = var0.cy;
        int var3 = var0.cx;
        var0 = null;
        Char var4 = Char.getMyChar();
        int var5 = var3 - var4.gameAD() - 10;
        int var6 = var3 + var4.gameAD() + 10;
        int var7 = var2 - var4.gameAE() - (var4.nClass.classId != 0 && var4.nClass.classId != 1 && var4.nClass.classId != 3 && var4.nClass.classId != 5 ? 0 : 40);
        int var8 = var2 + var4.gameAE() + (var4.nClass.classId != 0 && var4.nClass.classId != 1 && var4.nClass.classId != 3 && var4.nClass.classId != 5 ? 0 : 40);
        int var9 = -1;

        for (int var10 = 0; var10 < GameScr.vCharInMap.size(); ++var10) {
            Char var11 = (Char) GameScr.vCharInMap.elementAt(var10);
            int var12 = Math.abs(var3 - var11.cx);
            int var13 = Math.abs(var2 - var11.cy);
            var12 = var12 > var13 ? var12 : var13;
            if (var5 <= var11.cx && var11.cx <= var6 && var7 <= var11.cy && var11.cy <= var8 && !gameAB(var11) && gameAA(var4, var11) && !Code.gameAD(var11.cName) && (var9 == -1 || var12 < var9)) {
                var0 = var11;
                var9 = var12;
            }
        }

        return var1.charFocus = var0;
    }

    protected final void gameAB(int var1, int var2) {
        Char var3 = Char.getMyChar();
        if (!gameAJ()) {
            Char var4 = this.gameAA && GameScr.vParty.size() > 0 ? ((Party) GameScr.vParty.firstElement()).c : null;
            boolean var5 = !this.gameAA || Code.gameAH == null || var3.cName.equals(Code.gameAH) && LockGame.gameBH();
            Mob var6 = var3.mobFocus;
            Char var7 = var3.charFocus;
            if (Code.gameBO && (var7 == null || Code.gameAD(var7.cName) || !SavePk.gameAC(var7.cName) && !gameAA(var3, var7)) && (var7 = this.gameAA(var3, var2)) == null) {
                var7 = gameAD(var3);
            }

            boolean var8 = var7 != null && SavePk.gameAC(var7.cName);
            if (var7 == null && this.gameAU) {
                Service.gI().gameAZ(0);
                this.gameAU = false;
            }

            if (Code.gameBO && var3.cPk >= 5 && System.currentTimeMillis() - this.gameAT > 5000L) {
                Item var9;
                if ((var9 = Char.gameAF(257)) != null && var9.template.id == 257) {
                    Service.gI().useItem(var9.indexUI);
                }

                this.gameAT = System.currentTimeMillis();
            }

            if (Code.gameAR && Code.gameAT.size() > 0 && Code.gameAS < 0) {
                this.gameAA(var2, var5);
                return;
            }

            boolean var21 = false;
            if (this.gameAA(var2, var3.cx, var3.cy) || this.gameAD(var3.cx, var3.cy) || var6 != null && this.gameAA(var2, var6.x, var6.y)) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException var16) {
                }

                GameScr.gameAC("Né");
                if (Char.ChuyenMapHetQuai && var5) {
                    this.gameAM();
                    var21 = true;
                } else {
                    var21 = false;
                }

                if (var21) {
                    return;
                }

                var21 = true;
                var6 = null;
            }

            if (var6 == null || var6.status == 0 || !gameAA(var6, var1) || !gameAC(var6.levelBoss, var2) || System.currentTimeMillis() - this.gameAR > 5000L) {
                var6 = this.gameAA(var3, var1, var2, var4, var5);
            }

            if (var6 == null && var21 && this.gameAV > 0 && this.gameAW > 0) {
                Char.gameAC(this.gameAV, this.gameAW);
            }

            int var17;
            Char var18;
            if (Char.DanhNhom && GameScr.vParty.size() > 0 && var3.nClass.classId == 6 && var3.cHP > 0) {
                for (int var24 = 0; var24 < var3.vSkillFight.size(); ++var24) {
                    Skill var10;
                    if ((var10 = (Skill) var3.vSkillFight.elementAt(var24)) != null && var10.template.type == 4) {
                        if (!var10.gameAA()) {
                            for (var17 = 0; var17 < GameScr.vParty.size(); ++var17) {
                                Party var11;
                                if ((var11 = (Party) GameScr.vParty.elementAt(var17)).charId != var3.charID && var11.c != null && var11.c.cHP <= 0) {
                                    var18 = var11.c;
                                    if (Math.abs(var3.cx - var18.cx) > 50 || Math.abs(var3.cy - var18.cy) > 50) {
                                        Char.gameAC(var18.cx, var18.cy);
                                    }

                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException var14) {
                                    }

                                    Service.gI().gameAX(var11.charId);
                                    var10.lastTimeUseThisSkill = System.currentTimeMillis();
                                    var10.paintCanNotUseSkill = true;
                                    var3.gameAB(GameScr.sks[var10.template.id], 0);

                                    try {
                                        Thread.sleep(100L);
                                        return;
                                    } catch (InterruptedException var13) {
                                        return;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }

            if (Char.SanTaTl && !this.gameAD && (var6 == null || var6.levelBoss == 0 && (var2 & 6) != 0)) {
                var21 = (var2 & 2) != 0;
                var5 = (var2 & 4) != 0;

                for (var17 = 0; var17 < gameAN.size(); ++var17) {
                    Mob var22;
                    if ((var22 = (Mob) gameAN.elementAt(var17)).hp > 0 && var22.status != 0 && var22.status != 1 && !this.gameAA(var2, var22.x, var22.y) && !this.gameAD(var22.x, var22.y) && gameAA(var22, var1) && (var21 && var22.levelBoss == 1 || var5 && var22.levelBoss == 2)) {
                        var6 = var22;
                        this.gameAC(var22);
                        break;
                    }
                }
            }

            if (skill1 != null) {
                Skill var26 = skill1;

                int var23;
                int var25;
                if (var26.gameAA() && (Char.DungHoTro || this instanceof As20)) {
                    label800:
                    {
                        var25 = 0;

                        Skill var19;
                        label608:
                        while (true) {
                            if (var25 >= var3.vSkillFight.size()) {
                                break label800;
                            }
                            if ((var19 = (Skill) var3.vSkillFight.elementAt(var25)) != null && System.currentTimeMillis() - var19.lastTimeUseThisSkill >= (long) var19.coolDown - 300L) {
                                if (var19.template.type == 2) {
                                    if ((var3.gameAD == null && Char.DungPhanThan || var19.template.id < 67 || var19.template.id > 72) && (Char.KhienMana || var19.template.id != 31) && (var19.template.id != 15 || !Char.DotQuai || var3.cHP < var3.cMaxHP * Char.aHpValue / 100 && var3.isHuman) && (var19.template.id != 6 || var3.isHuman)) {
                                        var23 = (int) (System.currentTimeMillis() / 1000L);
                                        var17 = 0;
                                        while (true) {
                                            if (var17 >= var3.vEff.size()) {
                                                break label608;
                                            }
                                            Effect var12;
                                            if ((var12 = (Effect) var3.vEff.elementAt(var17)) != null && (var12.template.iconId == var19.template.iconId || var19.template.id == 58 && var12.template.type == 7) && var12.timeLenght - (var23 - var12.timeStart) >= 2) {
                                                break;
                                            }
                                            ++var17;
                                        }
                                    }
                                } else if (var19.template.type == 3 && var6 != null && var6.levelBoss == 0 && var6.hp > var6.maxHp / 2) {
                                    if (var19.template.id != 4 || Char.DotQuai && var3.cHP < var3.cMaxHP * Char.aHpValue / 100) {
                                        break;
                                    }
                                } else if ((var19.template.id == 7 || var19.template.id == 16 || var19.template.id == 25 || var19.template.id == 34 || var19.template.id == 43) && var6 != null && (var6.levelBoss != 0 || var6.hp >= var6.maxHp / 2) && (var19.template.id != 7 && var19.template.id != 16 || !var6.isFire) && (var19.template.id != 25 && var19.template.id != 34 || var6.isIce) && (var19.template.id != 43 || var6.isWind)) {
                                    break;
                                }
                            }

                            ++var25;
                        }

                        var26 = var19;

                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException var15) {
                        }
                    }
                }

                if (var26.template.type == 2) {
                    if (System.currentTimeMillis() - var26.lastTimeUseThisSkill >= (long) (var26.coolDown )) {
                        var26.lastTimeUseThisSkill = System.currentTimeMillis();
                        Service.gI().gameAG(var26.template.id);
                        Service.gI().gameAR();
                        if (!Code.timBG) {
                            var3.gameAB(GameScr.sks[var26.template.id], 0);
                        }
                    } else {
                        var26.paintCanNotUseSkill = true;
                    }
                } else {
                    Mob var20;
                    if (!Code.gameBO || var7 == null || gameAB(var7) || !var8 && !gameAA(var3, var7)) {
                        if (var6 == null || var1 != -1 && var6.templateId != var1 || !gameAC(var6.levelBoss, var2)) {
                            return;
                        }

                        if ((var26.template.type == 1 || var26.template.type == 3) && (Res.abs(var3.cx - var6.xFirst) > var26.dx + 30 || Res.abs(var3.cy - var6.yFirst) > var26.dy + 30)) {
                            var3.mobFocus = null;
                            return;
                        }

                        var25 = var26.dx;
                        var17 = var26.dy;
                        reAE.removeAllElements();
                        reAF.removeAllElements();
                        reAE.addElement(var6);

                        for (var23 = 0; var23 < GameScr.vMob.size() && reAE.size() + reAF.size() < var26.maxFight; ++var23) {
                            if ((var20 = (Mob) GameScr.vMob.elementAt(var23)).status != 0 && var20.status != 1 && !var20.equals(var6) && var6.xFirst - 100 <= var20.xFirst && var20.xFirst <= var6.xFirst + 100 && var6.yFirst - 50 <= var20.yFirst && var20.yFirst <= var6.yFirst + 50 && gameAC(var20.levelBoss, var2) && (var1 == -1 || var20.templateId == var1)) {
                                reAE.addElement(var20);
                            }
                        }

                        for (var23 = 0; var23 < GameScr.vCharInMap.size() && reAE.size() + reAF.size() < var26.maxFight; ++var23) {
                            if ((var18 = (Char) GameScr.vCharInMap.elementAt(var23)).cHP > 0 && var18.statusMe != 14 && var18.statusMe != 5 && var18.statusMe != 15 && (var18.cTypePk == 3 || var3.cTypePk == 3 || var18.cTypePk == 1 && var3.cTypePk == 1 || var3.killCharId >= 0 && var3.killCharId == var18.charID || var3.testCharId >= 0 && var3.testCharId == var18.charID || var18.killCharId == var3.charID) && !Code.gameAD(var18.cName) && var6.x - var25 <= var18.cx && var18.cx <= var6.x + var25 && var6.y - var17 <= var18.cy && var18.cy <= var6.y + var17) {
                                reAF.addElement(var18);
                            }
                        }

                        if (System.currentTimeMillis() - var26.lastTimeUseThisSkill >= (long) (var26.coolDown)) {
                            var26.lastTimeUseThisSkill = System.currentTimeMillis();
                            Service.gI().gameAG(var26.template.id);
                            Service.gI().gameAA((MyVector) reAE, (MyVector) reAF, (int) 1);
                            if (!Code.timBG) {
                                var3.gameAB(GameScr.sks[var26.template.id], 0);
                            }
                        } else {
                            var26.paintCanNotUseSkill = true;
                        }
                    } else {
                        if (var8) {
                            if ((var26.template.type == 1 || var26.template.type == 3) && (Res.abs(var3.cx - var7.cx) > var26.dx + 30 || Res.abs(var3.cy - var7.cy) > var26.dy + 30) && System.currentTimeMillis() - this.gameAS > 1500L) {
                                gameAC(var7);
                                this.gameAS = System.currentTimeMillis();
                            }

                            if (var7.killCharId != var3.charID && var7.cTypePk != 3) {
                                this.gameAU = true;
                                Service.gI().gameAZ(3);
                            }
                        }

                        var25 = var26.dx;
                        var17 = var26.dy;
                        reAE.removeAllElements();
                        reAF.removeAllElements();
                        reAF.addElement(var7);

                        for (var23 = 0; var23 < GameScr.vCharInMap.size() && reAE.size() + reAF.size() < var26.maxFight; ++var23) {
                            if ((var18 = (Char) GameScr.vCharInMap.elementAt(var23)).cHP > 0 && var18.statusMe != 14 && var18.statusMe != 5 && var18.statusMe != 15 && !var18.equals(var7) && (var18.cTypePk == 3 || var3.cTypePk == 3 || var18.cTypePk == 1 && var3.cTypePk == 1 || var3.killCharId >= 0 && var3.killCharId == var18.charID || var3.testCharId >= 0 && var3.testCharId == var18.charID || var18.killCharId == var3.charID) && !Code.gameAD(var18.cName) && var7.cx - var25 <= var18.cx && var18.cx <= var7.cx + var25 && var7.cy - var17 <= var18.cy && var18.cy <= var7.cy + var17) {
                                reAF.addElement(var18);
                            }
                        }

                        for (var23 = 0; var23 < GameScr.vMob.size() && reAE.size() + reAF.size() < var26.maxFight; ++var23) {
                            if ((var20 = (Mob) GameScr.vMob.elementAt(var23)).status != 0 && var20.status != 1 && var7.cx - var25 <= var20.x && var20.x <= var7.cx + var25 && var7.cy - var17 <= var20.y && var20.y <= var7.cy + var17 && gameAC(var20.levelBoss, var2) && (var1 == -1 || var20.templateId == var1)) {
                                reAE.addElement(var20);
                            }
                        }

                        if (System.currentTimeMillis() - var26.lastTimeUseThisSkill >= (long) (var26.coolDown )) {
                            var26.lastTimeUseThisSkill = System.currentTimeMillis();
                            Service.gI().gameAG(var26.template.id);
                            Service.gI().gameAA((MyVector) reAE, (MyVector) reAF, (int) 2);
                            if (!Code.timBG) {
                                var3.gameAB(GameScr.sks[var26.template.id], 0);
                            }
                        } else {
                            var26.paintCanNotUseSkill = true;
                        }
                    }
                }

                this.gameAR = System.currentTimeMillis();
            }
        }

    }

    protected boolean gameAH() {
        if (!(this instanceof TaThu) && !Code.gameAQ) {
            Char var1 = Char.getMyChar();
            int var2 = Code.gameAM < 0 ? -1 : Code.gameAM;

            for (int var3 = 0; var3 < GameScr.vItemMap.size(); ++var3) {
                ItemMap var4;
                if (!(var4 = (ItemMap) GameScr.vItemMap.elementAt(var3)).gameAK && (var1.nClass.classId == 1 && var4.template.id == 218 || var4.template.type == 19 || Code.gameAA(var4.template) && (Char.gameBG() > 2 || var4.template.isUpToUp && Char.gameAJ(var4.template.id))) && (var2 < 0 || Res.gameAA(var1.cx, var1.cy, var4.xEnd, var4.yEnd) < var2) && !this.gameAD(var4.x, var4.y)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    protected final void gameAC(int var1) {
        if (!Code.gameAQ) {
            Char var2 = Char.getMyChar();
            if (!gameAJ()) {
                gameBA.removeAllElements();
                int var3 = this.gameAA(Char.DanhQuai, Char.DanhTA, Char.DanhTL);

                int var4;
                for (var4 = 0; var4 < GameScr.vItemMap.size(); ++var4) {
                    ItemMap var5;
                    if (!(var5 = (ItemMap) GameScr.vItemMap.elementAt(var4)).gameAK && (var2.nClass.classId == 1 && var5.template.id == 218 || (Code.gameAA(var5.template) || var5.template.id == var1) && (Char.gameBG() > 2 || var5.template.type == 19 || var5.template.isUpToUp && Char.gameAJ(var5.template.id))) && !this.gameAA(var3, var5.xEnd, var5.yEnd) && !this.gameAD(var5.xEnd, var5.yEnd) && (Code.gameAM < 0 || Res.gameAA(var2.cx, var2.cy, var5.xEnd, var5.yEnd) < Code.gameAM)) {
                        gameBA.addElement(var5);
                    }
                }

                if (gameBA.size() > 0) {
                    var4 = var2.cx;
                    int var11 = var2.cy;
                    Mob var10 = var2.mobFocus;

                    label69:
                    for (var3 = 0; var3 < gameBA.size(); ++var3) {
                        try {
                            Thread.sleep(1L);
                        } catch (InterruptedException var9) {
                        }

                        ItemMap var6;
                        Char.gameAC((var6 = (ItemMap) gameBA.elementAt(var3)).xEnd, TileMap.gameAD(var6.xEnd, var6.yEnd));
                        var2.itemFocus = var6;

                        for (int var7 = 0; var7 < 4 && var6.status != 2 && !var6.gameAK; ++var7) {
                            Service.gI().gameAQ(var6.itemMapID);
                            if (LockGame.gameAC()) {
                                break;
                            }

                            if (this.gameAD(var2.cx, var2.cy) || var2.cHP <= 0) {
                                break label69;
                            }
                        }

                        var6.gameAK = true;
                        var6.gameAL = System.currentTimeMillis();
                    }

                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException var8) {
                    }

                    Char.gameAC(var4, var11);
                    var2.mobFocus = var10;
                }
            }
        }

    }

    protected final void gameAI() {
        if (TileMap.mapID != 22) {
            this.gameAA(22, -2, -1, -1);
            return;
        }
        Char char_ = Char.getMyChar();
        if (char_.gameAD != null) {
            for (int i = 0; i < char_.vSkillFight.size(); ++i) {
                Skill skill = (Skill) char_.vSkillFight.elementAt(i);
                if (skill == null || skill.gameAA() || skill.template.id < 67 || skill.template.id > 72) {
                    continue;
                }
                Service.gI().gameAG(skill.template.id);
                Service.gI().gameAR();
                LockGame.gameBC();
                break;
            }
            GameScr.gameAH(12);
            Service.gI().gameAJ(12, 3);
            LockGame.gameBC();
            return;
        }
    }

    protected static boolean gameAJ() {
        Char var0;
        if ((var0 = Char.getMyChar()).isHuman && var0.cHP < var0.cMaxHP) {
            for (int var1 = 0; var1 < var0.vEff.size(); ++var1) {
                Effect var2;
                if ((var2 = (Effect) var0.vEff.elementAt(var1)) != null && var2.template.type == 12) {
                    return true;
                }
            }
        }

        return false;
    }

    public abstract void gameAK();

    public String toString() {
        return "";
    }
}
