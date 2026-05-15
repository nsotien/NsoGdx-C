
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Image;

public final class GameScr extends mScreen implements IActionListener, IChatable {

    public static int indextabTrangbi;
    public static GameScr instance;
    public static int gW;
    public static int gH;
    public static int gameAD;
    private static int gameGZ;
    private static int gameHA;
    public static int gameAE;
    public static int gameAF;
    public static int gameAG;
    public static int gameAH;
    public static int cmx;
    public static int cmy;
    private static int gameHB;
    private static int gameHC;
    private static int gameHD;
    private static int gameHE;
    public static int gameAK;
    public static int gameAL;
    private static int gameHF;
    private static int gameHG;
    public static int gssx;
    public static int gameAN;
    public static int gssxe;
    public static int gssye;
    public static boolean gameAQ;
    private Command gameHH;
    private Command gameHI;
    private Command gameHJ;
    private Command gameHK;
    private Command gameHL;
    private Command gameHM;
    public static int gameAR;
    public static int gameAS;
    public static SkillPaint[] sks;
    public static mResources[] gameAU;
    public static Part[] parts;
    public static EffectCharPaint[] efs;
    private int gameHN = 0;
    private boolean gameHO = false;
    public static MyVector vMobSoul = new MyVector();
    public static MyVector vClan = new MyVector();
    public static MyVector vParty = new MyVector();
    public static MyVector vPtMap = new MyVector();
    public static MyVector vFriend = new MyVector();
    public static MyVector vList = new MyVector();
    public static MyVector vFriendWait = new MyVector();
    public static MyVector vEnemies = new MyVector();
    public static MyVector vCharInMap = new MyVector();
    public static MyVector vItemMap = new MyVector();
    public static MyVector vMob = new MyVector();
    public static MyVector vNpc = new MyVector();
    public static MyVector gameBJ = new MyVector();
    private static MyVector gameHP = new MyVector();
    public static NClass[] nClasss;
    public static int gameBL = 28;
    private static int gameHQ = 0;
    public static int gameBM = 0;
    public static int indexRow = -1;
    public static int gameBO;
    public static int gameBP = 0;
    public static int gameBQ = -1;
    private Item gameHR;
    public static ItemOptionTemplate[] gameBR;
    public static SkillOptionTemplate[] gameBS;
    public static Scroll gameBT = new Scroll();
    public static Scroll gameBU = new Scroll();
    public static Item[] gameBV;
    public static Item[] gameBW;
    public static Item[] gameBX;
    public static Item[] gameBY;
    public static Item[] gameBZ;
    public static Item[] gameCA;
    public static Item[] gameCB;
    public static Item[] gameCC;
    public static Item[] gameCD;
    public static Item[] gameCE;
    public static Item[] gameCF;
    public static Item[] gameCG;

    public static Item[] gameCH;
    public static Item[] gameCI;
    public static Item[] gameCJ;
    public static Item[] gameCK;
    public static Item[] gameCL;
    public static Item[] gameCM;
    public static Item[] gameCN;
    public static Item[] gameCO;
    public static Item[] gameCP;
    public static Item[] gameCQ;
    public static Item[] gameCR;
    public static Item[] gameCS;
    public static Item[] gameCT;
    public static Item[] upitem;
    public static Item[] gameCV;
    public static Item[] gameCW;
    public static Item[] gameCX;
    public static Item[] gameCY;
    public static ItemStands[] arrItemStands;
    public static short[] gameDA;
    public int gameDB;
    public static Item arritemup;
    public static Item gameDD;
    public static Item gameDE;
    private static boolean gameHS;
    private static boolean gameHT;
    private static boolean gameHU = false;
    private static boolean gameHV = false;
    public static boolean gameDF = true;
    private static boolean gameHW;
    public static boolean gameDG = false;
    private static boolean gameHX = false;
    public static boolean gameDH = false;
    public static boolean gameDI = false;
    private static boolean gameHY = false;
    private static boolean gameHZ = false;
    private static boolean gameKA = false;
    public static boolean gameDJ = false;
    private static boolean gameKB = false;
    private static boolean gameKC = false;
    public static boolean gameDK = false;
    private static boolean gameKD = false;
    public static boolean gameDL = false;
    private static boolean gameKE = false;
    private static boolean gameKF = false;
    private static boolean gameKG = false;
    private static boolean gameKH = false;
    private static boolean gameKI = false;
    private static boolean gameKJ = false;
    private static boolean gameKK = false;
    private static boolean gameKL = false;
    private static boolean gameKM = false;
    private static boolean gameKN = false;
    private static boolean gameKO = false;
    private static boolean gameKP = false;
    private static boolean gameKQ = false;
    private static boolean gameKR = false;
    private static boolean gameKS = false;
    private static boolean gameKT = false;
    private static boolean gameKU = false;
    private static boolean gameKV = false;
    private static boolean gameKW = false;
    private static boolean gameKX = false;
    private static boolean gameKY = false;
    private static boolean gameKZ = false;
    private static boolean gameMA = false;
    private static boolean gameMB = false;
    private static boolean gameMC = false;
    private static boolean gameMD = false;
    private static boolean gameME = false;
    private static boolean gameMF = false;
    public static boolean isPaintTrade = false;
    private static boolean gameMG = false;
    public static boolean gameDN = false;
    public static boolean isPaintMessage = false;
    private static boolean gameMH = false;
    private static boolean gameMI = false;
    private static boolean gameMJ = false;
    private static boolean gameMK = false;
    private static boolean gameML;
    public static boolean gameMM;
    private static boolean gameMN;
    private static boolean gameMO;
    private static boolean gameMP;
    private static boolean gameMQ;
    private static boolean gameMR;
    private static boolean gameMS = false;
    private static boolean gameMT = false;
    public static Char currentCharViewInfo;
    public static long[] exps;
    public static int[] crystals;
    public static int[] upClothe;
    public static int[] upAdorn;
    public static int[] upWeapon;
    public static int[] coinUpCrystals;
    public static int[] coinUpClothes;
    public static int[] coinUpAdorns;
    public static int[] coinUpWeapons;
    public static int[] maxPercents;
    public static int[] goldUps;
    private static int[] coinGotngoc = new int[]{0, 5000, 40000, 135000, 320000, 625000, 1080000, 1715000, 2560000, 3645000, 5000000};
    private int gameMV = 6;
    public int[] zones;
    private int[] gameMW;
    public int gameEC = 0;
    public int typeTradeOrder = 0;
    public int gameEE = 0;
    public int gameEF = 0;
    public int gameEG = 0;
    private int gameMX = 0;
    private int gameMY = 0;
    private int gameMZ = 0;
    private int gameNA = -1;
    public int gameEH = -1;
    public int gameEI = -1;
    private boolean gameNB;
    public static byte[][] gameEJ;
    public static byte[][] gameEK;
    private MyVector gameNC;
    private String gameND;
    private TField gameNE = null;
    public static byte gameEL;
    public static byte gameEM;
    public static byte gameEN;
    public static byte gameEO;
    public static byte gameEP;
    public static byte gameEQ;
    public static byte gameER;
    public static byte gameES;
    private static Image gameNF;
    private static Image gameNG;
    private static Image gameNH;
    private static Image gameNI;
    private static Image gameNJ;
    private static Image gameNK;
    private static Image gameNL;
    private static Image gameNM;
    private static Image gameNN;
    private static Image gameNO;
    private static Image gameNP;
    private static Image gameNQ;
    private static Image gameNR;
    private static Image gameNS;
    public static Image imgTf;
    public static Image gameEU;
    public static Image imgLbtn;
    public static Image imgLbtnFocus;
    private static Image gameNT;
    public static Image imgMatcho;
    public static Image imgFiremoto;
    public String gameEZ = "";
    public String gameFA = "";
    public int gameFB;
    public int gameFC;
    private static byte gameNU = 0;
    public static byte gameFD = 0;
    private int[] gameNV = new int[2];
    private int[] gameNW = new int[2];
    private int[] gameNX;
    private int[] gameNY;
    public long gameFE;
    public String[] gameFF = new String[]{"10000", "20000", "30000", "50000", "100000", "200000", "500000", "1000000", "5000000"};
    public int gameFG;
    public int gameFH;
    public String[] gameFI;
    public static MyVector gameFJ = new MyVector();
    public static MyVector gameFK = new MyVector();
    public static MyVector gameFL = new MyVector();
    private static Image gameNZ;
    public static Image gameFM;
    public static Image imgEffMob1;
    public static Image imgEffMob2;
    public static Image imgEffMob3;
    public static Image imgsmokeFollow;
    public static boolean gameFR = false;
    public static boolean gameFS = false;
    private static Skill[] gamePA;
    public static Skill[] gamePB;
    private static byte[] gamePC;
    private static byte[] gamePD;
    public Command gameFT;
    private Command gamePE;
    private Command gamePF;
    private Command gamePG;
    public static int gameFU;
    public static int gameFV;
    private long gamePH;
    public static int gameFW;
    public boolean gameFX = false;
    private int gamePI = 0;
    private int gamePJ = -1;
    private long gamePK;
    private int gamePL = 0;
    private static int gamePM;
    private static int gamePN;
    private static int gamePO;
    private static int gamePP;
    private static int gamePQ;
    private static int gamePR;
    private static int gamePS;
    private static int gamePT;
    private static int gamePU;
    private static int gamePV;
    private static int gamePW;
    private static int gamePX;
    private static int gamePY;
    private static int gamePZ;
    private static int gameQA;
    private static int gameQB;
    private static int gameQC;
    private static int[] gameQD;
    private static int[] gameQE;
    private static int gameQF;
    private static int gameQG;
    private static int gameQH;
    private static String[] gameQI;
    private static int[] gameQJ;
    private static int[] gameQK;
    private static int[] gameQL;
    private static int[] gameQM;
    private static int[] gameQN;
    private static int[] gameQO;
    private static int[] gameQP;
    private static int[] gameQQ;
    private static int[] gameQR;
    private static int[] gameQS;
    private static int[] gameQT;
    private static Image[] gameQU;
    private static int gameQV;
    private static int gameQW;
    private static int gameQX;
    private static int gameQY;
    private static int gameQZ;
    private static int gameRA;
    private static int gameRB;
    private static int gameRC;
    private static int gameRD;
    private static int gameRE;
    private static int gameRF;
    private static Image[] gameRG;
    public static int popupY;
    public static int popupX;
    private int gameRH = 0;
    private String[] gameRI = null;
    private String[] gameRJ = null;
    private int gameRK = 0;
    private Command gameRL;
    private Command gameRM;
    private Command gameRN;
    private Command gameRO;
    private Command gameRP;
    private Command gameRQ;
    private Command gameRR;
    private Command gameRS;
    private Command gameRT;
    private Command gameRU;
    private Command gameRV;
    private Command gameRW;
    private Command gameRX;
    private Command gameRY;
    private Command gameRZ;
    private Command gameSA;
    private Command gameSB;
    private Command gameSC;
    private Command gameSD;
    private Command gameSE;
    private Command gameSF;
    private Command gameSG;
    private Command gameSH;
    private Command gameSI;
    private Command gameSJ;
    private Command gameSK;
    private Command gameSL;
    private Command gameSM;
    private Command gameSN;
    private Command gameSO;
    private Command gameSP;
    private Command gameSQ;
    private Command gameSR;
    private Command gameSS;
    private Command gameST;
    private Command gameSU;
    private Command gameSV;
    private Command gameSW;
    private String gameSX;
    private String gameSY;
    public static int gameGA;
    public static int gameGB;
    public static int gameGC;
    public static int gameGD;
    private static int gameSZ;
    private static int gameTA;
    private static int gameTB;
    private static int gameTC;
    private static int gameTD;
    public int gameGE = 0;
    private int[] gameTE = new int[]{0, 0, 0, 0, 600841, 600841, 667658, 667658, 3346944, 3346688, 4199680, 5052928, 3276851, 3932211, 4587571, 5046280, 6684682, 3359744, 1234567, 16776960, 16753920, 16711935, 8421504};
    private int[][] gameTF = new int[][]{{18687, 16869, 15052, 13235, 11161, 9344},
    {45824, 39168, 32768, 26112, 19712, 13056},
    {16744192, 15037184, 13395456, 11753728, 10046464, 8404992},
    {13500671, 12058853, 10682572, 9371827, 7995545, 6684800},
    {16711705, 15007767, 13369364, 11730962, 10027023, 8388621},
    {0xFF6347, 0x4682B4, 0x32CD32, 0xFFD700, 0x8A2BE2, 0xD2691E}
    };
    private int[] gameTG = new int[]{2, 1, 1, 1, 1, 1};
    public static int gameGF;
    public static EffectCharPaint gameGG;
    private static int gameTH;
    private static int gameTI;
    private static int gameTJ;
    private static int gameTK;
    public Command gameGH;
    private Command gameTL;
    private Command gameTM;
    private Command gameTN;
    private Command gameTO;
    private Command gameTP;
    private Command gameTQ;
    private Command gameTR;
    private int gameTS;
    private int gameTT;
    private String gameTU;
    private long gameTV;
    private static long gameTW;
    private static int gameTX;
    private static int[] gameTY;
    private static int[] gameTZ;
    public static int gameGI;
    public static int gameGJ;
    public static int gameGK;
    private short gameUA;
    private short gameUB;
    private short gameUC;
    private String gameUD;
    private String gameUE;
    private String gameUF;
    private String gameUG;
    private String gameUH;
    private long gameUI;
    private boolean gameUJ;
    public static byte gameGL;
    private mFont gameUK;
    private byte[] gameUL;
    private byte gameUM;
    private MyVector gameUN;
    private int gameUO;
    private int gameUP;
    private int gameUQ;
    private int gameUR;
    private int gameUS;
    private int gameUT;
    private int gameUU;
    private int gameUV;
    private int gameUW;
    private int gameUX;
    private int gameUY;
    private int gameUZ;
    private int gameVA;
    private int gameVB;
    private int gameVC;
    private int gameVD;
    private String gameVE;
    private int[][] gameVF;
    public static boolean isTouchKey = true;
    private static InfoDlg gameVG = new InfoDlg();
    public String[] gameGN = new String[]{"LEFT", "UP", "RIGHT"};
    public int[] gameGO = new int[600];
    private static boolean gameVH = false;
    private static boolean itemDell = false;
    private static boolean itemThow = false;

    private static MyVector gameVJ;
    public static int gameGP;
    public static boolean gameGQ;
    public nameDQ gameGR;

    public static long gameAB(int var0) {
        long var1 = 0L;

        for (int var3 = 0; var3 <= var0; ++var3) {
            var1 += exps[var3];
        }

        return var1;
    }

    public static void gameAA() {
        vCharInMap.removeAllElements();
        vItemMap.removeAllElements();
        vMobSoul.removeAllElements();
        Effect2.vEffect2.removeAllElements();
        Effect2.vAnimateEffect.removeAllElements();
        Effect2.vEffect2Outside.removeAllElements();
        vMob.removeAllElements();
        vNpc.removeAllElements();
        gameBJ.removeAllElements();
        Char.getMyChar().vMovePoints.removeAllElements();
    }

    public static void gameAE() {
        Service.gI().gameAN("KSkill");
        Service.gI().gameAN("OSkill");
        Service.gI().gameAN("CSkill");
    }

    public static void gameAF() {
        Service.gI().gameAN("KSkill");
        Service.gI().gameAN("OSkill");
        Service.gI().gameAN("CSkill");
    }

    public static void gameAA(byte[] var0) {
        gamePB = new Skill[5];
        int var1;
        int var2;
        Skill var3;
        if (var0 == null) {
            if (gamePC != null) {
                for (var1 = 0; var1 < gamePC.length; ++var1) {
                    for (var2 = 0; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
                        if ((var3 = (Skill) Char.getMyChar().vSkillFight.elementAt(var2)).template.id == gamePC[var1]) {
                            gamePB[var1] = var3;
                            break;
                        }
                    }
                }
            } else {
                for (var1 = 0; var1 < gamePB.length && var1 < Char.getMyChar().vSkillFight.size(); ++var1) {
                    Skill var4 = (Skill) Char.getMyChar().vSkillFight.elementAt(var1);
                    gamePB[var1] = var4;
                }
            }

            gameBQ();
        } else {
            for (var1 = 0; var1 < var0.length; ++var1) {
                for (var2 = 0; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
                    if ((var3 = (Skill) Char.getMyChar().vSkillFight.elementAt(var2)).template.id == var0[var1]) {
                        gamePB[var1] = var3;
                        break;
                    }
                }
            }

        }
    }

    public static void gameAB(byte[] var0) {
        gamePA = new Skill[3];
        int var1;
        int var2;
        Skill var3;
        if (var0 == null) {
            if (gamePD != null) {
                for (var1 = 0; var1 < gamePD.length; ++var1) {
                    for (var2 = 0; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
                        if ((var3 = (Skill) Char.getMyChar().vSkillFight.elementAt(var2)).template.id == gamePD[var1]) {
                            gamePA[var1] = var3;
                            break;
                        }
                    }
                }
            } else {
                for (var1 = 0; var1 < gamePA.length && var1 < Char.getMyChar().vSkillFight.size(); ++var1) {
                    Skill var4 = (Skill) Char.getMyChar().vSkillFight.elementAt(var1);
                    gamePA[var1] = var4;
                }
            }

            gameBR();
        } else {
            for (var1 = 0; var1 < var0.length; ++var1) {
                for (var2 = 0; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
                    if ((var3 = (Skill) Char.getMyChar().vSkillFight.elementAt(var2)).template.id == var0[var1]) {
                        gamePA[var1] = var3;
                        break;
                    }
                }
            }

        }
    }

    public static void gameAC(byte[] var0) {
        if (var0 != null && var0.length != 0) {
            for (int var1 = 0; var1 < Char.getMyChar().vSkillFight.size(); ++var1) {
                Skill var2;
                if ((var2 = (Skill) Char.getMyChar().vSkillFight.elementAt(var1)).template.id == var0[0]) {
                    Char.getMyChar().myskill = var2;
                    Char.getMyChar().lastNormalSkill = var2;
                    break;
                }
            }
        } else if (Char.getMyChar().vSkillFight.size() > 0) {
            Char.getMyChar().myskill = (Skill) Char.getMyChar().vSkillFight.elementAt(0);
        }

        if (Char.getMyChar().myskill != null) {
            Service.gI().gameAG(Char.getMyChar().myskill.template.id);
            Char.getMyChar();
        }

    }

    private static void gameAA(SkillTemplate var0) {
        Skill var5 = Char.getMyChar().gameAA(var0);
        MyVector var1 = new MyVector();

        for (int var2 = 0; var2 < 5; ++var2) {
            boolean var3 = false;
            if (gamePB[var2] == null) {
                var3 = true;
            }

            Object[] var4;
            (var4 = new Object[2])[0] = var5;
            var4[1] = String.valueOf(var2);
            var1.addElement(new Command(mResources.gameGJ + " " + (var2 + 1), 11120, var4));
            if (var3) {
                break;
            }
        }

        GameCanvas.menu.gameAA(var1);
    }

    private static void gameAB(SkillTemplate var0) {
        Skill var5 = Char.getMyChar().gameAA(var0);
        String[] var1 = TField.isQwerty ? mResources.gameGK : mResources.gameGL;
        MyVector var2 = new MyVector();

        for (int var3 = 0; var3 < 3; ++var3) {
            Object[] var4;
            (var4 = new Object[2])[0] = var5;
            var4[1] = String.valueOf(var3);
            var2.addElement(new Command(var1[var3], 11121, var4));
        }

        GameCanvas.menu.gameAA(var2);
    }

    private static void gameBQ() {
        byte[] var0 = new byte[gamePB.length];

        for (int var1 = 0; var1 < gamePB.length; ++var1) {
            if (gamePB[var1] == null) {
                var0[var1] = -1;
            } else {
                var0[var1] = gamePB[var1].template.id;
            }
        }

        if (Char.getMyChar().isHuman) {
            Service.gI().gameAA((String) "OSkill", (byte[]) var0, (byte) 0);
        } else {
            Service.gI().gameAA((String) "OSkill", (byte[]) var0, (byte) 1);
        }
    }

    private static void gameBR() {
        byte[] var0 = new byte[gamePA.length];

        for (int var1 = 0; var1 < gamePA.length; ++var1) {
            if (gamePA[var1] == null) {
                var0[var1] = -1;
            } else {
                var0[var1] = gamePA[var1].template.id;
            }
        }

        if (Char.getMyChar().isHuman) {
            Service.gI().gameAA((String) "KSkill", (byte[]) var0, (byte) 0);
        } else {
            Service.gI().gameAA((String) "KSkill", (byte[]) var0, (byte) 1);
        }
    }

    public static void gameAA(Skill var0) {
        if (var0.template.type != 0) {
            int var1;
            for (var1 = 0; var1 < gamePB.length; ++var1) {
                if (gamePB[var1] == null) {
                    gamePB[var1] = var0;
                    break;
                }
            }

            for (var1 = 0; var1 < gamePA.length; ++var1) {
                if (gamePA[var1] == null) {
                    gamePA[var1] = var0;
                    break;
                }
            }

            if (Char.getMyChar().myskill == null) {
                Char.getMyChar().myskill = var0;
                if (Code.gameAB instanceof As20) {
                    Auto.skill1 = var0;
                }
            }

            gameBR();
            gameBQ();
        }

    }

    public static boolean gameAG() {
        for (int var0 = Char.getMyChar().arrItemBag.length - 1; var0 >= 0; --var0) {
            if (Char.getMyChar().arrItemBag[var0] == null) {
                return false;
            }
        }

        return true;
    }

    public static void gameAA(String[] var0, Npc var1) {
        MyVector var2 = new MyVector();

        for (int var3 = 0; var3 < var0.length; ++var3) {
            var2.addElement(new Command(var0[var3], 11057, var1));
        }

        GameCanvas.menu.gameAA(var2);
    }

    public final void gameAH() {
        currentCharViewInfo = Char.getMyChar();
        gameBP = 0;
        this.gameCB();
    }

    private void gameBS() {
        currentCharViewInfo = Char.getMyChar();
        gameBP = 1;
        this.gameCB();
    }

    private void gameBT() {
        currentCharViewInfo = Char.getMyChar();
        gameBP = 2;
        this.gameCB();
    }

    private void gameBU() {
        currentCharViewInfo = Char.getMyChar();
        gameBP = 3;
        this.gameCB();
    }

    private void gameBV() {
        currentCharViewInfo = Char.getMyChar();
        gameBP = 4;
        this.gameCB();
    }

    private void gameBW() {
        currentCharViewInfo = Char.getMyChar();
        gameBP = 5;
        this.gameCB();
    }

    public static void gameAI() {
        DataInputStream var0 = null;
        boolean var9 = false;

        label96:
        {
            try {
                var9 = true;
                short var1;
                parts = new Part[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.gameAB("nj_part")))).readShort()];

                for (int var2 = 0; var2 < var1; ++var2) {
                    byte var3 = var0.readByte();
                    parts[var2] = new Part(var3);

                    for (int var15 = 0; var15 < parts[var2].pi.length; ++var15) {
                        parts[var2].pi[var15] = new PartImage();
                        parts[var2].pi[var15].id = var0.readShort();
                        parts[var2].pi[var15].dx = var0.readByte();
                        parts[var2].pi[var15].dy = var0.readByte();
                    }
                }

                var9 = false;
                break label96;
            } catch (Exception var13) {
                var13.printStackTrace();
                var9 = false;
            } finally {
                if (var9) {
                    try {
                        var0.close();
                    } catch (IOException var10) {
                        var10.printStackTrace();
                    }

                }
            }

            try {
                var0.close();
                return;
            } catch (IOException var11) {
                var11.printStackTrace();
                return;
            }
        }

        try {
            var0.close();
        } catch (IOException var12) {
            var12.printStackTrace();
        }
    }

    public static void gameAJ() {
        DataInputStream var0 = null;
        boolean var9 = false;

        label96:
        {
            try {
                var9 = true;
                short var1;
                efs = new EffectCharPaint[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.gameAB("nj_effect")))).readShort()];

                for (int var2 = 0; var2 < var1; ++var2) {
                    efs[var2] = new EffectCharPaint();
                    efs[var2].idEf = var0.readShort();
                    efs[var2].arrEfInfo = new EffectInfoPaint[var0.readByte()];

                    for (int var3 = 0; var3 < efs[var2].arrEfInfo.length; ++var3) {
                        efs[var2].arrEfInfo[var3] = new EffectInfoPaint();
                        efs[var2].arrEfInfo[var3].idImg = var0.readShort();
                        efs[var2].arrEfInfo[var3].dx = var0.readByte();
                        efs[var2].arrEfInfo[var3].dy = var0.readByte();
                    }
                }

                var9 = false;
                break label96;
            } catch (Exception var13) {
                var13.printStackTrace();
                var9 = false;
            } finally {
                if (var9) {
                    try {
                        var0.close();
                    } catch (IOException var10) {
                        var10.printStackTrace();
                    }

                }
            }

            try {
                var0.close();
                return;
            } catch (IOException var11) {
                var11.printStackTrace();
                return;
            }
        }

        try {
            var0.close();
        } catch (IOException var12) {
            var12.printStackTrace();
        }
    }

    public static void gameAK() {
        DataInputStream var0 = null;
        boolean var8 = false;

        label77:
        {
            try {
                var8 = true;
                short var1;
                gameAU = new mResources[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.gameAB("nj_arrow")))).readShort()];

                for (int var2 = 0; var2 < var1; ++var2) {
                    gameAU[var2] = new mResources();
                    var0.readShort();
                    gameAU[var2].imgId[0] = var0.readShort();
                    gameAU[var2].imgId[1] = var0.readShort();
                    gameAU[var2].imgId[2] = var0.readShort();
                }

                var8 = false;
                break label77;
            } catch (Exception var12) {
                var12.printStackTrace();
                var8 = false;
            } finally {
                if (var8) {
                    try {
                        var0.close();
                    } catch (IOException var9) {
                        var9.printStackTrace();
                    }

                }
            }

            try {
                var0.close();
                return;
            } catch (IOException var10) {
                var10.printStackTrace();
                return;
            }
        }

        try {
            var0.close();
        } catch (IOException var11) {
            var11.printStackTrace();
        }
    }

    public static void gameAL() {
        DataInputStream var0 = null;
        boolean var10 = false;

        label133:
        {
            try {
                var10 = true;
                short var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.gameAB("nj_skill")))).readShort();
                int var2 = 0;

                int var3;
                for (var3 = 0; var3 < nClasss.length; ++var3) {
                    var2 += nClasss[var3].skillTemplates.length;
                }

                sks = new SkillPaint[var2];

                for (var3 = 0; var3 < var1; ++var3) {
                    short var16 = var0.readShort();
                    sks[var16] = new SkillPaint();
                    sks[var16].id = var0.readShort();
                    var0.readByte();
                    sks[var16].skillStand = new SkillInfoPaint[var0.readByte()];

                    int var4;
                    for (var4 = 0; var4 < sks[var16].skillStand.length; ++var4) {
                        sks[var16].skillStand[var4] = new SkillInfoPaint();
                        sks[var16].skillStand[var4].status = var0.readByte();
                        sks[var16].skillStand[var4].effS0Id = var0.readShort();
                        sks[var16].skillStand[var4].e0dx = var0.readShort();
                        sks[var16].skillStand[var4].e0dy = var0.readShort();
                        sks[var16].skillStand[var4].effS1Id = var0.readShort();
                        sks[var16].skillStand[var4].e1dx = var0.readShort();
                        sks[var16].skillStand[var4].e1dy = var0.readShort();
                        sks[var16].skillStand[var4].effS2Id = var0.readShort();
                        sks[var16].skillStand[var4].e2dx = var0.readShort();
                        sks[var16].skillStand[var4].e2dy = var0.readShort();
                        sks[var16].skillStand[var4].arrowId = var0.readShort();
                        sks[var16].skillStand[var4].adx = var0.readShort();
                        sks[var16].skillStand[var4].ady = var0.readShort();
                    }

                    sks[var16].skillfly = new SkillInfoPaint[var0.readByte()];

                    for (var4 = 0; var4 < sks[var16].skillfly.length; ++var4) {
                        sks[var16].skillfly[var4] = new SkillInfoPaint();
                        sks[var16].skillfly[var4].status = var0.readByte();
                        sks[var16].skillfly[var4].effS0Id = var0.readShort();
                        sks[var16].skillfly[var4].e0dx = var0.readShort();
                        sks[var16].skillfly[var4].e0dy = var0.readShort();
                        sks[var16].skillfly[var4].effS1Id = var0.readShort();
                        sks[var16].skillfly[var4].e1dx = var0.readShort();
                        sks[var16].skillfly[var4].e1dy = var0.readShort();
                        sks[var16].skillfly[var4].effS2Id = var0.readShort();
                        sks[var16].skillfly[var4].e2dx = var0.readShort();
                        sks[var16].skillfly[var4].e2dy = var0.readShort();
                        sks[var16].skillfly[var4].arrowId = var0.readShort();
                        sks[var16].skillfly[var4].adx = var0.readShort();
                        sks[var16].skillfly[var4].ady = var0.readShort();
                    }
                }

                var10 = false;
                break label133;
            } catch (Exception var14) {
                var10 = false;
            } finally {
                if (var10) {
                    try {
                        var0.close();
                    } catch (IOException var11) {
                    }

                }
            }

            try {
                var0.close();
                return;
            } catch (IOException var12) {
                return;
            }
        }

        try {
            var0.close();
        } catch (IOException var13) {
        }
    }

    public static void gameAA(long var0) {
        long var2 = var0;

        int var4;
        for (var4 = 0; var4 < exps.length && var2 >= exps[var4]; ++var4) {
            var2 -= exps[var4];
        }

        long[] var5 = new long[]{(long) var4, var2};
        Char.getMyChar().clevel = (int) var5[0];
        Char.getMyChar().autoUpHp = var5[1];
    }

    public static GameScr gI() {
        if (instance == null) {
            instance = new GameScr();
        }

        return instance;
    }

    public static void gameAN() {
        instance = null;
        gameCX = null;
        gameCW = null;
        gameCV = null;
        upitem = null;
        gameCT = null;
        gameDD = null;
        arritemup = null;
    }

    public final void gameAO() {
        if (gameQU == null) {
            gameQU = new Image[3];

            for (int var1 = 0; var1 < 3; ++var1) {
                gameQU[var1] = GameCanvas.gameAC("/e/sp" + var1 + ".png");
            }
        }

        gameQP = new int[2];
        gameQQ = new int[2];
        gameQR = new int[2];
        gameQS = new int[2];
        gameQT = new int[2];
        gameQR[0] = gameQR[1] = -1;
        this.gameCR();
        Res.gameAA();
    }

    public GameScr() {
        this.gameGH = new Command(mResources.gameSJ[0], 11038);
        this.gameTS = 30;
        this.gameTT = 0;
        this.gameTU = "";
        this.gameUK = mFont.tahoma_7b_yellow;
        this.gameUL = new byte[]{-1, -1, -1, -1, -1, -1};
        this.gameUM = 0;
        this.gameUN = new MyVector();
        this.gameVE = "";
        this.gameVF = new int[][]{new int[2], {200, 10}, {500, 20}, {1000, 50}, {2000, 100}, {5000, 200}, {10000, 500}, {20000, 1000}, {50000, 2000}, {100000, 5000}, {100000, 10000}};
        if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
            gameBL = 20;
        }

        this.gamePG = new Command(mResources.ACCEPT, 11002);
        this.gamePF = new Command(mResources.gameKE, 11003);
        this.gameSW = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11004);
        this.gameSV = new Command(mResources.gameDA, 11005);
        this.gamePE = new Command(mResources.gameKE, 11006);
        this.gameSU = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11007);
        this.gameST = new Command(mResources.gameDA, 11008);
        this.gameSS = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11009);
        this.gameSR = new Command(mResources.gameDA, 11010);
        this.gameSQ = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11011);
        this.gameSP = new Command(mResources.gameDA, 11012);
        this.gameSO = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11013);
        this.gameSN = new Command(mResources.gameDA, 11014);
        this.gameSM = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11015);
        this.gameSL = new Command(mResources.gameDA, 11016);
        this.gameSI = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11017);
        this.gameSK = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 13001);
        this.gameSH = new Command(mResources.gameDA, 11018);
        this.gameSJ = new Command(mResources.gameDA, 13002);
        this.gameSE = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11019);
        this.gameSD = new Command(mResources.gameDA, 11020);
        this.gameSB = new Command(mResources.gameDA, 14022);
        this.gameSC = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 14023);
        this.gameSG = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 14018);
        this.gameSF = new Command(mResources.gameDA, 14019);
        this.gameSA = new Command(mResources.CLOSE, 11021);
        this.gameTR = new Command(mResources.SELECT, 11022);
        this.gameTQ = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11023);
        this.gameTO = new Command(mResources.gameCM, 11024);
        this.gameTP = new Command(mResources.gameCN, 110244);
        this.gameTN = new Command(mResources.CLOSE, 11025);
        this.gameTL = new Command(mResources.gameCK, 11026);
        this.gameTM = new Command(mResources.gameCL, 110221);
        this.gameRZ = new Command(mResources.SELECT, 11027);
        this.gameRY = new Command(mResources.SELECT, 11028);
        this.gameRX = new Command(mResources.SELECT, 11029);
        this.gameRW = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11030);
        new Command(mResources.gameFL, 11021);
        this.gameFT = new Command(mResources.gameBI, 11000);
        this.gameHM = new Command("Focus", 11001);
        this.gameRM = new Command(mResources.gameHX, 11032);
        this.gameRN = new Command(mResources.ACCEPT, 11033);
        this.gameRR = new Command(mResources.gameCR, 11034);
        this.gameRS = new Command(mResources.gameCR, 14014);
        this.gameRT = new Command(mResources.gameCR, 11035);
        this.gameRU = new Command(mResources.gameCU, 11036);
        this.gameRV = new Command(mResources.gameCR, 11037);
        this.gameRO = new Command(mResources.gameCR, 339);
        this.gameRP = new Command(mResources.gameCR, 340);
        this.gameRQ = new Command(mResources.gameCR, 343);
        this.gameRL = new Command(mResources.gameCR, 402);
        new Command("240", 110381);
        new Command("360", 1103911);
        new Command("Toàn Map", 110401);
        if (GameCanvas.isTouch && GameCanvas.gameAG) {
            this.gameFT.x = gW - 135;
            this.gameFT.y = 6;
            this.gameFT.img = gameNK;
            this.gameHM.x = gW;
            this.gameHM.y = gH;
            if (GameCanvas.gameAH) {
                this.gameFT.x = gW / 2 - 38;
                this.gameFT.y = gH - 34;
            }
        }

        this.gameHM.img = GameCanvas.gameAC("/u/fc.png");
        super.left = this.gameFT;
        super.right = this.gameHM;
    }

    private void gameBX() {
        if (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.w < 320 || gameDL && gameBP > 0 || gameMH && gameBP == 0) {
            gameDK = false;
        }

        gameHT = false;
        if (gameAZ()) {
            this.gameBB();
            super.right = this.gameSA;
        } else {
            this.gameBI();
        }
    }

    private void gameBY() {
        if (gameHQ > 0 && gameHQ <= 4 || GameCanvas.isTouch) {
            GameCanvas.inputDlg.gameAA(mResources.gamePA, this.gamePE, 1);
        }

    }

    private void gameBZ() {
        if (gameHQ > 0 && gameHQ <= 4) {
            GameCanvas.inputDlg.gameAA(mResources.gamePA, this.gamePF, 1);
        }

    }

    private void gameCA() {
        if (gameDJ) {
            GameCanvas.inputDlg.gameAA(mResources.gameFI, this.gamePG, 0);
        }

    }

    private void gameCB() {
        gameDL = true;
        setSize(175, 200);
        this.gameBI();
        if (gameBP == 3 && currentCharViewInfo.charID == Char.getMyChar().charID) {
            Service.gI().gameAJ(currentCharViewInfo.cName);
        }

        if (gameBP == 5) {
            this.gameNX = new int[5];
            this.gameNY = new int[5];
            gameGA = popupX + 5;
            gameGB = popupY + 35;
            this.gameNX[0] = gameGA + 5;
            this.gameNY[0] = gameGB + 35;
            this.gameNX[1] = gameGA + 5;
            this.gameNY[1] = gameGB + 70;
            this.gameNX[2] = gameGA + 131;
            this.gameNY[2] = gameGB + 35;
            this.gameNX[3] = gameGA + 131;
            this.gameNY[3] = gameGB + 70;
            this.gameNX[4] = this.gameNX[0] + gameBL + 7;
            this.gameNY[4] = this.gameNY[0] - 5;
        }

        super.right = new Command(mResources.gameFL, 11060);
    }

    private void gameCC() {
        gameBU.gameAA();
        gameBT.gameAA();
        gameHT = false;
        this.gameHH = new Command(mResources.gameGN[0], 1100011);
        this.gameHI = new Command(mResources.gameGN[1], 1100012);
        this.gameHJ = new Command(mResources.gameGN[2], 1100013);
        this.gameHL = new Command(mResources.gameGN[3], 1100014);
        this.gameHK = new Command(mResources.gameGN[4], 1100015);
        MyVector var1;
        (var1 = new MyVector()).addElement(this.gameHH);
        var1.addElement(this.gameHI);
        var1.addElement(this.gameHJ);
        var1.addElement(this.gameHL);
        var1.addElement(this.gameHK);
        var1.addElement(new Command(mResources.gameGN[5], 1100016));
        GameCanvas.menu.gameAA(var1);
    }

    private static void gameCD() {
        MyVector var0 = new MyVector();
        if (Code.gameAB != null) {
            var0.addElement(new Command("Tắt Auto", 1100073));
        } else {
            if (TileMap.mapID == 1 || TileMap.mapID == 27 || TileMap.mapID == 72) {
                var0.addElement(new Command("Auto NV", 1100074));
            }

            var0.addElement(new Command("Tàn sát", 1100069));
            var0.addElement(new Command("Auto Tà Thú", 1100075));
        }

        var0.addElement(new Command("NPC", 1100071));
        var0.addElement(new Command("DS PK", 1100093));
        var0.addElement(new Command("DS HS", 1100094));
        var0.addElement(new Command("Item Sell", 1100091));
        var0.addElement(new Command("Item Nhặt", 1100076));
        var0.addElement(new Command("Item Del", 11000761));
        var0.addElement(new Command("Item Vứt Đất", 11000792));
        var0.addElement(new Command("Item SW", 1100092));
        var0.addElement(new Command(Code.gameAQ ? "Hút VP" : "Nhặt Xa", 1100080));
        var0.addElement(new Command(Code.gameAM > 0 ? "KC Nhặt: " + Code.gameAM : "Nhặt Full", 1100081));
        var0.addElement(new Command(Code.gameAN > 0 ? "KCTS: " + Code.gameAN : "TS Full", 1100082));
        var0.addElement(new Command("Đánh CVT: " + (Code.gameAR ? "Bật" : "Tắt"), 1100083));
        var0.addElement(new Command("Đánh CK: " + (Code.gameAV ? "Bật" : "Tắt"), 1100089));
        var0.addElement(new Command("Giữ Lvl: " + (Code.gameAY ? "Bật" : "Tắt"), 1100084));
        var0.addElement(new Command("SPGame: " + Char.speedGame, 1100087));
        var0.addElement(new Command(mResources.gameSW[7], 1100068));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameCE() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameSX[0], 110002));
        var0.addElement(new Command(mResources.gameSX[1], 1100032));
        var0.addElement(new Command(mResources.gameSX[2], 1100033));
        var0.addElement(new Command(mResources.gameAZ, 1100034));
        var0.addElement(new Command(mResources.gameCD, LoginScr.gameAF(), 1004, (Object) null));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameCF() {
        MyVector var0 = new MyVector();
        if (Char.getMyChar().clevel >= 3 && SelectServerScr.gameAA()) {
            var0.addElement(new Command("Xác thực tài khoản", 1100181));
        }

        var0.addElement(new Command(mResources.gameMR[1], 110001));
        var0.addElement(new Command("MenuAuto", 110021));
        var0.addElement(new Command("Cài Đặt", 11000805));

        var0.addElement(new Command("Hướng dẫn", 110022));
        var0.addElement(new Command(mResources.gameMR[3], 110003));
        var0.addElement(new Command(mResources.gameMR[6], 110006));
        var0.addElement(new Command(mResources.gameMR[18], 110018));
        var0.addElement(new Command(mResources.gameMR[14], 110014));
        var0.addElement(new Command("Tự sát", 110020));
        var0.addElement(new Command(mResources.gameMR[16], 110016));
        var0.addElement(new Command(mResources.gameMR[4], 110004));
        GameCanvas.menu.gameAA(var0);
    }

    private void gameCG() {
        this.gameAU();
        gameHY = true;
        gameBP = this.gameHN;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
        super.left = new Command(mResources.gameMR[2], 110002);
        super.center = new Command(mResources.CHANGE, 110019);
    }

    private void gameCH() {
        this.gameAU();
        gameKA = true;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
        Service.gI().gameAD();
        this.gameAR();
    }

    private void gameCI() {
        this.gameAU();
        if (this.gameEH > 0) {
            indexRow = Char.gameAD(this.gameEH);
        } else {
            indexRow = 0;
            this.gameEH = -1;
        }

        gameMF = true;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
    }

    private void gameCJ() {
        this.gameAU();
        gameHZ = true;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
        this.gameAS();
    }

    public final void gameAP() {
        this.gameAU();
        gameHX = true;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
        super.left = super.center = null;
        indexRow = 0;
    }

    public final void gameAQ() {
        this.gameAU();
        gameKB = true;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
        super.left = super.center = null;
        indexRow = 0;
    }

    private void gameCK() {
        this.gameAU();
        gameDJ = true;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
        super.left = new Command(mResources.gameEK, 11044);
        super.center = null;
        indexRow = 0;
        Service.gI().gameAU();
    }

    private void gameCL() {
        this.gameAU();
        gameKC = true;
        this.gameNB = true;
        setSize(175, 200);
        super.right = this.gameSA;
        super.left = new Command(mResources.gameEK, 14017);
        super.center = null;
        indexRow = 0;
        Service.gI().gameAV();
    }

    public final void gameAR() {
        if (gameKA) {
            super.left = super.center = null;
            super.left = new Command(mResources.gameBI, 11045);
            Party var1;
            if (vPtMap.size() > 0 && indexRow >= 0 && indexRow < vPtMap.size() && (var1 = (Party) vPtMap.elementAt(indexRow)) != null && !Char.getMyChar().cName.equals(var1.name)) {
                super.center = new Command(mResources.SELECT, 11046);
            }
        }

    }

    public final void gameAS() {
        if (gameHZ) {
            super.left = super.center = null;
            indexRow = 0;
            if (vParty.size() == 0) {
                super.center = null;
                super.left = new Command(mResources.gameBI, 11047);
                return;
            }

            Party var1;
            if ((var1 = (Party) vParty.firstElement()).charId == Char.getMyChar().charID) {
                super.left = new Command(mResources.gameSN, 11070, var1);
                return;
            }

            super.left = new Command(mResources.gameSM, 11071);
        }

    }

    private static void gameCM() {
        if (TileMap.gameAN != 1) {
            MapScr.gameAA().gameAB();
        }

    }

    public final void gameAA(Message var1) {
        InfoDlg.gameAD();

        try {
            this.zones = new int[var1.gameAB().readByte()];
            this.gameMW = new int[this.zones.length];

            for (int var2 = 0; var2 < this.zones.length; ++var2) {
                this.zones[var2] = var1.gameAB().readByte();
                this.gameMW[var2] = var1.gameAB().readByte();
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        gameMG = true;
        gameBM = TileMap.zoneID;
        setSize(175, 200);
        super.left = new Command(mResources.SELECT, 11067);
        super.center = new Command("", 11067);
        super.right = this.gameSA;
    }

    public final void gameAT() {
        try {
            this.gameAU();
            this.gameFA = "";
            this.gameEC = 0;
            this.gameEC = this.typeTradeOrder = this.gameEE = this.gameEF = 0;
            isPaintTrade = true;
            gameCW = new Item[12];
            gameCX = new Item[12];
            gameBP = 0;
            setSize(175, 200);
            super.right = this.gameSA;
        } catch (Exception var1) {
        }
    }

    public static final void gameAA(boolean var0) {
        gW = GameCanvas.w;
        if (!GameCanvas.isTouch || GameCanvas.isTouch && !GameCanvas.gameAG) {
            gameAG = 36;
            if (GameCanvas.isTouch) {
                gameAG += 3;
            }
        } else {
            gameAG = 8;
        }

        gH = GameCanvas.h - gameAG - 20;
        if (var0) {
            gH = GameCanvas.h;
        }

        if (GameCanvas.isTouch && GameCanvas.gameAG) {
            gH = GameCanvas.h;
        }

        if (GameCanvas.h == 160) {
            gH = 150;
        }

        gameQW = gW;
        if (GameCanvas.w > 176) {
            gameQW -= 50;
        }

        gameQV = GameCanvas.h - Paint.hTab - gameAG;
        gameAD = gW >> 1;
        gameAF = gH >> 1;
        gameAE = 2 * gH / 3;
        gameAH = gW / 6;
        gameGZ = gW / TileMap.size + 2;
        gameHA = gH / TileMap.size + 2;
        if (gW % 24 != 0) {
            ++gameGZ;
        }

        gameHF = (TileMap.tmw - 1) * TileMap.size - gW;
        gameHG = (TileMap.tmh - 1) * TileMap.size - gH;
        if (GameCanvas.isTouch && GameCanvas.gameAG) {
            gameHG += 60;
        }

        cmx = gameAK = Char.getMyChar().cx - gameAD + gameAH * Char.getMyChar().cdir;
        cmy = gameAL = Char.getMyChar().cy - gameAE;
        if (cmx < 24) {
            cmx = 24;
        }

        if (cmx > gameHF) {
            cmx = gameHF;
        }

        if (cmy < 0) {
            cmy = 0;
        }

        if (cmy > gameHG) {
            cmy = gameHG;
        }

        if ((gssx = cmx / TileMap.size - 1) < 0) {
            gssx = 0;
        }

        gameAN = cmy / TileMap.size;
        gssxe = gssx + gameGZ;
        gssye = gameAN + gameHA;
        if (gameAN < 0) {
            gameAN = 0;
        }

        if (gssye > TileMap.tmh - 1) {
            gssye = TileMap.tmh - 1;
        }

        if ((TileMap.gameBB = gssxe - gssx << 2) > TileMap.tmw) {
            TileMap.gameBB = TileMap.tmw;
        }

        if ((TileMap.gameBC = gssye - gameAN << 2) > TileMap.tmh) {
            TileMap.gameBC = TileMap.tmh;
        }

        if ((TileMap.gameAZ = (Char.getMyChar().cx - 2 * gW) / TileMap.size) < 0) {
            TileMap.gameAZ = 0;
        }

        if ((TileMap.gameBA = (Char.getMyChar().cy - 2 * gH) / TileMap.size) < 0) {
            TileMap.gameBA = 0;
        }

        ChatTextField.gameAA().parentScreen = instance;
        ChatTextField.gameAA().tfChat.y = GameCanvas.h - 35 - ChatTextField.gameAA().tfChat.height;
        if (!GameCanvas.isTouch || GameCanvas.isTouch && !GameCanvas.gameAG) {
            TileMap.gameAA(GameCanvas.w - 51, gameQV - 4, 50, 40);
        } else {
            TileMap.gameAA(GameCanvas.w - 60, 0, 60, 42);
        }

        if (GameCanvas.isTouch) {
            gamePM = gH - 88;
            gamePP = gW - 100;
            gamePQ = 2;
            if (GameCanvas.gameAH) {
                gamePP = gW / 2 - 2;
                gamePQ = gamePM + 50;
            }

            gamePN = 1;
            gamePO = gamePM + 50;
            gamePR = 42;
            gamePS = gamePM + 50;
            gamePT = gW - 50;
            gamePU = gamePM + 35;
            gamePV = 22;
            gamePW = gamePM + 19;
            gamePX = gW - 74;
            gamePY = gamePM + 13;
            gamePZ = gW - 85;
            gameQA = gamePM + 50;
            gameQB = gW - 37;
            gameQC = gamePM - 1;
            if (GameCanvas.w >= 450) {
                gamePW -= 15;
                gamePV += 28;
                gamePR += 45;
                gamePN += 10;
                gameQC -= 12;
                gamePY -= 7;
                gamePT -= 18;
                gameQB -= 10;
                gamePX -= 17;
                gamePZ -= 24;
            } else if (GameCanvas.w >= 360) {
                gamePW -= 5;
                gamePV += 6;
                gamePR += 12;
                gameQC -= 2;
                gamePY -= 2;
                gamePX -= 2;
                gamePZ -= 2;
            }
        }

        gameQD = new int[gamePB.length];
        gameQE = new int[gamePB.length];
        int var1;
        if (GameCanvas.isTouch) {
            if (GameCanvas.gameAH) {
                gameQF = 2;
                gameQG = 55;
                gameQH = 5;

                for (var1 = 0; var1 < gameQD.length; ++var1) {
                    gameQD[var1] = var1 * (25 + gameQH);
                    gameQE[var1] = gameQG;
                }
            } else {
                if (GameCanvas.w <= 320) {
                    gameQF = gameAD - gamePB.length * 25 / 2 - 15;
                } else {
                    gameQF = gameAD - gamePB.length * 25 / 2;
                }

                gameQG = gamePM + 58;
                gameQH = 5;

                for (var1 = 0; var1 < gameQD.length; ++var1) {
                    gameQD[var1] = var1 * (25 + gameQH);
                    gameQE[var1] = gameQG;
                }
            }
        } else {
            gameQF = 0;

            for (var1 = 0; var1 < gameQE.length; ++var1) {
                gameQD[var1] = 2;
                gameQE[var1] = 2 + var1 * 25;
            }
        }

    }

    private static boolean gameCN() {
        if (Char.getMyChar().myskill != null && Char.getMyChar().cMP < Char.getMyChar().myskill.manaUse) {
            InfoMe.gameAA(mResources.gameNI);
            return false;
        } else if (Char.getMyChar().myskill != null && (Char.getMyChar().myskill.template.maxPoint <= 0 || Char.getMyChar().myskill.point != 0)) {
            if (Char.getMyChar().arrItemBody[1] == null) {
                GameCanvas.gameAA(mResources.gameRX);
                return false;
            } else {
                return true;
            }
        } else {
            GameCanvas.gameAA(mResources.gameRW);
            return false;
        }
    }

    public final void gameAU() {
        if (Char.getMyChar().arrItemBag != null) {
            int var1;
            int var2;
            if ((gameMC || gameML) && gameCT != null) {
                for (var2 = 0; var2 < gameCT.length; ++var2) {
                    if (gameCT[var2] != null) {
                        var1 = gameCT[var2].indexUI;
                        Char.getMyChar().arrItemBag[var1] = gameCT[var2];
                        gameCT[var2] = null;
                    }
                }
            }

            if (gameKZ) {
                if (arritemup != null) {
                    Char.getMyChar().arrItemBag[arritemup.indexUI] = arritemup;
                    arritemup = null;
                }

                if (upitem != null) {
                    for (var2 = 0; var2 < upitem.length; ++var2) {
                        if (upitem[var2] != null) {
                            var1 = upitem[var2].indexUI;
                            Char.getMyChar().arrItemBag[var1] = upitem[var2];
                            upitem[var2] = null;
                        }
                    }
                }
            }

            if (gameMP) {
                if (arritemup != null) {
                    Char.getMyChar().arrItemBag[arritemup.indexUI] = arritemup;
                    arritemup = null;
                }

                if (gameDD != null) {
                    Char.getMyChar().arrItemBag[gameDD.indexUI] = gameDD;
                    gameDD = null;
                }

                if (upitem != null) {
                    for (var2 = 0; var2 < upitem.length; ++var2) {
                        if (upitem[var2] != null) {
                            var1 = upitem[var2].indexUI;
                            Char.getMyChar().arrItemBag[var1] = upitem[var2];
                            upitem[var2] = null;
                        }
                    }
                }
            }

            if (gameMT && upitem != null) {
                for (var2 = 0; var2 < upitem.length; ++var2) {
                    if (upitem[var2] != null) {
                        var1 = upitem[var2].indexUI;
                        Char.getMyChar().arrItemBag[var1] = upitem[var2];
                        upitem[var2] = null;
                    }
                }
            }

            if (gameDH && gameDE != null) {
                Char.getMyChar().arrItemBag[gameDE.indexUI] = gameDE;
                gameDE = null;
            }

            if (gameMA && gameCY != null) {
                for (var2 = 0; var2 < gameCY.length; ++var2) {
                    if (gameCY[var2] != null) {
                        var1 = gameCY[var2].indexUI;
                        Char.getMyChar().arrItemBag[var1] = gameCY[var2];
                        gameCY[var2] = null;
                    }
                }
            }

            if (gameME || gameMN || gameMM || gameMO) {
                if (gameDD != null) {
                    Char.getMyChar().arrItemBag[gameDD.indexUI] = gameDD;
                    gameDD = null;
                }

                if (gameCV != null) {
                    for (var2 = 0; var2 < gameCV.length; ++var2) {
                        if (gameCV[var2] != null) {
                            if (gameMM || gameMN || gameMO) {
                                var1 = gameCV[var2].indexUI;
                                Char.getMyChar().arrItemBag[var1] = gameCV[var2];
                            }

                            gameCV[var2] = null;
                        }
                    }
                }
            }

            if (gameMT && gameCV != null) {
                for (var2 = 0; var2 < gameCV.length; ++var2) {
                    if (gameCV[var2] != null) {
                        var1 = gameCV[var2].indexUI;
                        Char.getMyChar().arrItemBag[var1] = gameCV[var2];
                        gameCV[var2] = null;
                    }
                }
            }

            if (isPaintTrade) {
                InfoDlg.gameAD();
                if (this.gameEE > 0) {
                    Char var10000 = Char.getMyChar();
                    var10000.xu += this.gameEE;
                }

                if (gameCW != null) {
                    for (var2 = 0; var2 < gameCW.length; ++var2) {
                        if (gameCW[var2] != null) {
                            var1 = gameCW[var2].indexUI;
                            Char.getMyChar().arrItemBag[var1] = gameCW[var2];
                            gameCW[var2] = null;
                        }
                    }
                }

                if (gameCX != null) {
                    for (var2 = 0; var2 < gameCX.length; ++var2) {
                        gameCX[var2] = null;
                    }
                }
            }

            if ((gameMQ || gameMR) && gameDD != null) {
                Char.getMyChar().arrItemBag[gameDD.indexUI] = gameDD;
                gameDD = null;
            }
        }

        if (gameDN || gameVH || itemDell || itemThow) {
            if (Char.DanhNhom) {
                Service.gI().gameAK("setup " + Char.DungHp + " " + Char.aHpValue + " " + Char.DungMp + " " + Char.aMpValue + " " + Char.DungFood + " " + Char.CapFood + " " + Char.DungHoTro + " " + Char.DungPhanThan + " " + Char.KhienMana + " " + Char.DotQuai + " " + Char.NhatYen + " " + Char.NhatHpMp + " " + Char.CapHpMp + " " + Char.NhatDa + " " + Char.CapNhatDa + " " + Char.LuyenDa + " " + Char.LuyenDaMax + " " + Char.NhatTrangBi + " " + Char.CapTrangBi + " " + Char.NhatTbLa + " " + Char.NhatVpNV + " " + Char.NhatVpSk + " " + Char.NhatAll + " " + Char.NhatSvc + " " + Char.KhongNhat + " " + Char.LuyenTTT + " " + Char.LuyenTTC + " " + Char.ReMap + " " + Char.TsMapTrong + " " + Char.AutoMuaFood + " " + Char.DieHetMp + " " + Char.ReConnect + " " + Char.ChuyenMapHetQuai + " " + Char.SanTaTl + " " + Char.DanhQuai + " " + Char.DanhTA + " " + Char.DanhTL + " " + Char.CongTN + " " + Char.CongKN + " " + Char.DanhNhom + " " + Char.NePk + " " + Char.DungCoLenh + " " + Char.MuaCoLenh);
            }
            Char.gameAC();
        }

        if (isPaintTrade) {
            Service.gI().gameAI();
        }

        GameCanvas.menu.showMenu = false;
        ChatTextField var3;
        (var3 = ChatTextField.gameAA()).tfChat.gameAA("");
        var3.isShow = false;
        ChatTextField.gameAA().gameAF = null;
        if (!GameCanvas.isTouch) {
            gameKD = false;
        }

        gameDG = false;
        gameMB = false;
        this.gameNB = false;
        gameMG = false;
        gameDN = false;
        gameDL = false;
        gameDK = false;
        gameHY = false;
        gameHZ = false;
        isPaintMessage = false;
        gameMH = false;
        gameMJ = false;
        gameMI = false;
        gameMF = false;
        gameKA = false;
        gameDJ = false;
        gameMK = false;
        gameKB = false;
        gameHX = false;
        gameKC = false;
        gameDI = false;
        gameMS = false;
        this.gameEC = 0;
        gameKE = false;
        gameKF = false;
        gameKG = false;
        gameKH = false;
        gameKI = false;
        gameKJ = false;
        gameKK = false;
        gameKL = false;
        gameKM = false;
        gameKN = false;
        gameKO = false;
        gameKP = false;
        gameKQ = false;
        gameKR = false;
        gameKS = false;
        gameKT = false;
        gameKU = false;
        gameKV = false;
        gameKW = false;
        gameKX = false;
        gameKY = false;
        gameKZ = false;
        gameDH = false;
        gameMA = false;
        gameMN = false;
        gameMM = false;
        gameME = false;
        isPaintTrade = false;
        gameML = false;
        gameMC = false;
        gameMD = false;
        gameVH = false;
        itemDell = false;
        itemThow = false;
        gameMP = false;
        gameMO = false;
        gameMT = false;
        gameMQ = false;
        gameMR = false;
        gameBP = 0;
        gameBM = 0;
        this.gameNA = -1;
        indexRow = -1;
        gameBO = 0;
        gameHQ = 0;
        this.gameEC = this.typeTradeOrder = 0;
        super.left = this.gameFT;
        super.right = this.gameHM;
        this.gameNX = this.gameNY = null;
        super.center = null;
        if (Char.getMyChar().cHP <= 0 || Char.getMyChar().statusMe == 14 || Char.getMyChar().statusMe == 5) {
            if (GameCanvas.gameAH) {
                this.gameGH.caption = "";
            }

            super.center = this.gameGH;
        }

        gameBU.gameAA();
    }

    public final void gameAA(int var1) {
        if (this.gameNE != null && this.gameNE.isFocus) {
            this.gameNE.gameAA(var1);
        }

        super.gameAA(var1);
    }

    public final void gameAD() {
        if (!GameCanvas.menu.showMenu && !InfoDlg.gameAF) {
            int var1;
            boolean var5;
            if (GameCanvas.isTouch && !ChatTextField.gameAA().isShow && !GameCanvas.menu.showMenu) {
                GameScr var3 = this;
                int var4 = -1;
                if (GameCanvas.isPointerClick) {
                    for (var1 = 0; var1 < var3.gameNV.length; ++var1) {
                        if (GameCanvas.gameAB(var3.gameNV[var1], var3.gameNW[var1], 100, 12) && GameCanvas.isPointerJustRelease) {
                            var4 = var1;
                            break;
                        }
                    }
                }

                if (var4 != -1 && !gameDF() && !gameAZ() && !gameDH()) {
                    if (var4 != 0) {
                        if (ChatManager.isMessagePt) {
                            ChatManager.gameAD().gameAA(1);
                        } else if (ChatManager.isMessageClan) {
                            ChatManager.gameAD().gameAA(3);
                        }

                        this.gameGJ();
                        this.gameNV[1] = this.gameNW[1] = -1;
                    } else if (ChatManager.gameAD().waitList.size() > 0) {
                        ChatManager var2 = ChatManager.gameAD();
                        var1 = 3;

                        int var11;
                        label1504:
                        while (true) {
                            if (var1 >= var2.chatTabs.size()) {
                                var11 = -1;
                                break;
                            }

                            ChatTab var9 = (ChatTab) var2.chatTabs.elementAt(var1);

                            for (var4 = 0; var4 < var2.waitList.size(); ++var4) {
                                if (var9.ownerName.equals(var2.waitList.elementAt(var4).toString())) {
                                    var11 = var1;
                                    break label1504;
                                }
                            }

                            ++var1;
                        }

                        ChatManager.gameAD().gameAA(var11);
                        this.gameGJ();
                        this.gameNV[0] = this.gameNW[0] = -1;
                    }
                }

                var5 = false;
                mScreen.keyTouch = -1;
                if (GameCanvas.gameAB(TileMap.posMiniMapX, TileMap.posMiniMapY, TileMap.wMiniMap, TileMap.hMiniMap) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                    gameCM();
                    var5 = true;
                }

                if (GameCanvas.isTouch && (!GameCanvas.menu.showMenu || !GameCanvas.gameAH) && GameCanvas.currentDialog == null && ChatPopup.currentMultilineChatPopup == null && !GameCanvas.menu.showMenu && !gameDF()) {
                    if (GameCanvas.gameAB(gamePP, gamePQ, 34, 34)) {
                        mScreen.keyTouch = 15;
                        if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                            ChatTextField.gameAA().gameAA(mResources.PUBLICCHAT[0]);
                            var5 = true;
                            GameCanvas.isPointerJustRelease = false;
                            GameCanvas.isPointerClick = false;
                        }
                    }

                    if (!this.gameDG()) {
                        if (!Char.getMyChar().isCaptcha) {
                            if (isTouchKey) {
                                if (GameCanvas.gameAB(gamePV, gamePW, 34, 34)) {
                                    mScreen.keyTouch = 3;
                                    GameCanvas.keyHold[2] = true;
                                    this.gameCO();
                                    var5 = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[2] = false;
                                }

                                if (GameCanvas.gameAB(gamePV - 30, gamePW, 30, 34)) {
                                    GameCanvas.keyHold[1] = true;
                                    this.gameCO();
                                    var5 = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[1] = false;
                                }

                                if (GameCanvas.gameAB(gamePV + 34, gamePW, 30, 34)) {
                                    GameCanvas.keyHold[3] = true;
                                    this.gameCO();
                                    var5 = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[3] = false;
                                }

                                if (GameCanvas.gameAB(gamePN, gamePO, 34, 34)) {
                                    mScreen.keyTouch = 4;
                                    GameCanvas.keyHold[4] = true;
                                    this.gameCO();
                                    var5 = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[4] = false;
                                }

                                if (GameCanvas.gameAB(gamePR - 5, gamePS, 40, 34)) {
                                    mScreen.keyTouch = 6;
                                    GameCanvas.keyHold[6] = true;
                                    this.gameCO();
                                    var5 = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[6] = false;
                                }
                            } else {
                                gameVG.gameAA();
                            }

                            if (GameCanvas.gameAB(gamePT, gamePU, 54, 54)) {
                                GameCanvas.keyHold[5] = true;
                                mScreen.keyTouch = 5;
                                if (GameCanvas.isPointerJustRelease) {
                                    GameCanvas.keyPressedz[5] = true;
                                    var5 = true;
                                }
                            }
                        } else {
                            if (GameCanvas.gameAC(gamePN, gamePO, 34, 34) && GameCanvas.isPointerJustRelease) {
                                this.gameAE((byte) 0);
                                GameCanvas.gameAK();
                            }

                            if (GameCanvas.gameAC(gamePV, gamePW, 34, 34) && GameCanvas.isPointerJustRelease) {
                                this.gameAE((byte) 1);
                                GameCanvas.gameAK();
                            }

                            if (GameCanvas.gameAC(gamePR - 5, gamePS, 40, 34) && GameCanvas.isPointerJustRelease) {
                                this.gameAE((byte) 2);
                                GameCanvas.gameAK();
                            }
                        }

                        if (Char.getMyChar().ctaskId > 1) {
                            if (GameCanvas.gameAB(gamePZ, gameQA, 34, 34)) {
                                mScreen.keyTouch = 11;
                                if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                    GameCanvas.keyPressedz[11] = true;
                                    var5 = true;
                                }
                            }

                            if (GameCanvas.gameAB(gamePX, gamePY, 34, 34)) {
                                mScreen.keyTouch = 10;
                                if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                    GameCanvas.keyPressedz[10] = true;
                                    var5 = true;
                                }
                            }

                            if (GameCanvas.gameAB(gameQB, gameQC, 34, 34)) {
                                mScreen.keyTouch = 13;
                                if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                    Char.getMyChar().gameAX();
                                    var5 = true;
                                }
                            }
                        }

                        if (Char.getMyChar().vSkill.size() >= 2 && (GameCanvas.gameAB(gameQF + gameQD[0], gameQE[0], gamePB.length * 30, 30) || !GameCanvas.gameAG && GameCanvas.gameAB(gameQF + gameQD[0], gameQE[0], 30, gamePB.length * 25)) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                            if (!GameCanvas.gameAG) {
                                var4 = (GameCanvas.pyLast - (gameQG + gameQE[0])) / 25;
                            } else {
                                var4 = (GameCanvas.pxLast - (gameQF + gameQD[0])) / 30;
                            }

                            this.gamePJ = var4;
                            if (gameBM < 0) {
                                gameBM = 0;
                            }

                            if (this.gamePJ > gamePB.length - 1) {
                                this.gamePJ = gamePB.length - 1;
                            }

                            var5 = true;
                            Skill var6 = gamePB[this.gamePJ];
                            this.gameAA(var6, false);
                            this.gameHO = true;
                        }

                        if (GameCanvas.isPointerJustRelease) {
                            GameCanvas.keyHold[1] = false;
                            GameCanvas.keyHold[2] = false;
                            GameCanvas.keyHold[3] = false;
                            GameCanvas.keyHold[4] = false;
                            GameCanvas.keyHold[6] = false;
                        }

                        if (!var5 && !gameDF() && !gameAZ() && !gameDH() && GameCanvas.isPointerClick) {
                            var1 = 0;

                            label1452:
                            while (true) {
                                if (var1 >= vMob.size()) {
                                    for (var1 = 0; var1 < vNpc.size(); ++var1) {
                                        Npc var8;
                                        if ((var8 = (Npc) vNpc.elementAt(var1)).gameAU() && GameCanvas.gameAA(var8.cx - var8.cw / 2, var8.cy - var8.ch, var8.cw, var8.ch) && GameCanvas.isPointerJustRelease) {
                                            Char.getMyChar().mobFocus = null;
                                            Char.getMyChar().gameAY();
                                            Char.getMyChar().npcFocus = var8;
                                            Char.getMyChar().charFocus = null;
                                            Char.getMyChar().itemFocus = null;
                                            Char.gameHF = true;
                                            break label1452;
                                        }
                                    }

                                    for (var1 = 0; var1 < vCharInMap.size(); ++var1) {
                                        Char var10;
                                        if ((var10 = (Char) vCharInMap.elementAt(var1)).gameAU() && !var10.gameBE() && GameCanvas.gameAA(var10.cx - var10.cw / 2, var10.cy - var10.ch, var10.cw, var10.ch) && GameCanvas.isPointerJustRelease) {
                                            Char.getMyChar().mobFocus = null;
                                            Char.getMyChar().gameAY();
                                            Char.getMyChar().charFocus = var10;
                                            Char.getMyChar().itemFocus = null;
                                            Char.gameHF = true;
                                            break label1452;
                                        }
                                    }

                                    var1 = 0;

                                    while (true) {
                                        if (var1 >= vItemMap.size()) {
                                            break label1452;
                                        }

                                        ItemMap var12;
                                        if (GameCanvas.gameAA((var12 = (ItemMap) vItemMap.elementAt(var1)).x - 12, var12.y - 24, 24, 24) && GameCanvas.isPointerJustRelease) {
                                            Char.getMyChar().mobFocus = null;
                                            Char.getMyChar().gameAY();
                                            Char.getMyChar().charFocus = null;
                                            Char.getMyChar().itemFocus = var12;
                                            Char.gameHF = true;
                                            break label1452;
                                        }

                                        ++var1;
                                    }
                                }

                                Mob var7;
                                if ((var7 = (Mob) vMob.elementAt(var1)).gameAD() && GameCanvas.gameAA(var7.x - var7.gameAK / 2, var7.y - var7.gameAL, var7.gameAK, var7.gameAL) && GameCanvas.isPointerJustRelease) {
                                    Char.getMyChar().mobFocus = var7;
                                    Char.getMyChar().gameAY();
                                    Char.getMyChar().charFocus = null;
                                    Char.getMyChar().itemFocus = null;
                                    Char.gameHF = true;
                                    break;
                                }

                                ++var1;
                            }
                        }
                    }
                }
            }

            if (TileMap.mapID != 130 && !gameCP()) {
                label1626:
                {
                    long var14 = System.currentTimeMillis();
                    if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[4] || GameCanvas.keyPressedz[6] || GameCanvas.keyPressedz[1] || GameCanvas.keyPressedz[3]) {
                        gameFW = 0;
                        if (this.gameFX) {
                            Char.getMyChar().isLockMove = false;
                            this.gameFX = false;
                        }
                    }

                    if (GameCanvas.keyPressedz[5] && !gameDF()) {
                        if (gameFW == 0) {
                            if (var14 - this.gamePH < 800L && (Char.getMyChar().myskill == null || Char.getMyChar().cMP >= Char.getMyChar().myskill.manaUse) && Char.getMyChar().myskill != null && (Char.getMyChar().myskill.template.maxPoint <= 0 || Char.getMyChar().myskill.point != 0) && Char.getMyChar().arrItemBody[1] != null && Char.getMyChar().mobFocus != null) {
                                gameFW = 10;
                                GameCanvas.keyPressedz[5] = false;
                            }
                        } else {
                            if (!this.gameFX && Char.getMyChar().statusMe != 14) {
                                this.gameFX = !this.gameFX;
                                Char.getMyChar().isLockMove = !Char.getMyChar().isLockMove;
                                this.gamePH = var14;
                                break label1626;
                            }

                            gameFW = 0;
                            if (this.gameFX) {
                                Char.getMyChar().isLockMove = false;
                                this.gameFX = false;
                            }

                            GameCanvas.keyPressedz[4] = GameCanvas.keyPressedz[6] = false;
                        }

                        this.gamePH = var14;
                    }

                    if (GameCanvas.gameTick % 10 == 0 && gameFW > 0 && (Char.getMyChar().mobFocus != null || Char.getMyChar().itemFocus != null)) {
                        this.gameAB(true);
                    }

                    if (gameFW > 1) {
                        --gameFW;
                    }
                }
            }

            if (GameCanvas.isTouch) {
                if (GameCanvas.isPointerDown && !GameCanvas.isPointerJustRelease && GameCanvas.gameAB(gameQB, gameQC, 34, 34) && !gameMF && GameCanvas.isPointerClick && GameCanvas.gameAI()) {
                    this.gameCI();
                }
            } else if (GameCanvas.keyHold[13] && !gameMF && GameCanvas.gameAI()) {
                this.gameCI();
            }

            if (ChatPopup.currentMultilineChatPopup != null) {
                Command var15 = ChatPopup.currentMultilineChatPopup.cmdNextLine;
                if ((GameCanvas.keyPressedz[5] || mScreen.gameAA(var15)) && var15 != null) {
                    GameCanvas.isPointerJustRelease = false;
                    GameCanvas.keyPressedz[5] = false;
                    mScreen.keyTouch = -1;
                    if (var15 != null) {
                        var15.gameAA();
                    }
                }
            } else if (!ChatTextField.gameAA().isShow) {
                if ((GameCanvas.keyPressedz[12] || mScreen.gameAA(GameCanvas.currentScreen.left)) && super.left != null) {
                    GameCanvas.isPointerJustRelease = false;
                    GameCanvas.isPointerClick = false;
                    GameCanvas.keyPressedz[12] = false;
                    mScreen.keyTouch = -1;
                    if (super.left != null) {
                        super.left.gameAA();
                    }
                }

                if ((GameCanvas.keyPressedz[13] || mScreen.gameAA(GameCanvas.currentScreen.right)) && super.right != null) {
                    GameCanvas.isPointerJustRelease = false;
                    GameCanvas.isPointerClick = false;
                    GameCanvas.keyPressedz[13] = false;
                    mScreen.keyTouch = -1;
                    if (super.right != null) {
                        super.right.gameAA();
                    }
                }

                if ((GameCanvas.keyPressedz[5] || mScreen.gameAA(GameCanvas.currentScreen.center)) && super.center != null) {
                    GameCanvas.isPointerJustRelease = false;
                    GameCanvas.keyPressedz[5] = false;
                    mScreen.keyTouch = -1;
                    if (super.center != null) {
                        super.center.gameAA();
                    }
                }
            } else {
                if (ChatTextField.gameAA().left != null && (GameCanvas.keyPressedz[12] || mScreen.gameAA(ChatTextField.gameAA().left)) && ChatTextField.gameAA().left != null) {
                    ChatTextField.gameAA().left.gameAA();
                }

                if (ChatTextField.gameAA().right != null && (GameCanvas.keyPressedz[13] || mScreen.gameAA(ChatTextField.gameAA().right)) && ChatTextField.gameAA().right != null) {
                    ChatTextField.gameAA().right.gameAA();
                }

                if (ChatTextField.gameAA().gameAF != null && (GameCanvas.keyPressedz[5] || mScreen.gameAA(ChatTextField.gameAA().gameAF)) && ChatTextField.gameAA().gameAF != null) {
                    ChatTextField.gameAA().gameAF.gameAA();
                }
            }

            ScrollResult var16;
            if (gameMG && GameCanvas.currentDialog == null) {
                var5 = false;
                if (GameCanvas.keyPressedz[4]) {
                    if (--gameBM < 0) {
                        gameBM = this.zones.length - 1;
                    }

                    var5 = true;
                } else if (GameCanvas.keyPressedz[6]) {
                    if (++gameBM >= this.zones.length) {
                        gameBM = 0;
                    }

                    var5 = true;
                } else if (GameCanvas.keyPressedz[8]) {
                    if (gameBM + this.gameMV <= this.zones.length - 1) {
                        gameBM += this.gameMV;
                    }

                    var5 = true;
                } else if (GameCanvas.keyPressedz[2]) {
                    if (gameBM - this.gameMV >= 0) {
                        gameBM -= this.gameMV;
                    }

                    var5 = true;
                }

                if (var5) {
                    gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    GameCanvas.gameAK();
                    GameCanvas.gameAJ();
                }

                if (GameCanvas.isTouch && ((var16 = gameBU.gameAB()).isDowning || var16.isFinish)) {
                    gameBM = var16.selected;
                }
            }

            ScrollResult var19;
            if (gameHX || gameHZ || gameKA || gameDJ || gameKC || gameMF || gameKB || gameMK) {
                if (gameMK) {
                    if (gameMK && ((var19 = gameBU.gameAB()).isDowning || var19.isFinish)) {
                        gameBM = var19.selected;
                        if (var19.selected >= arrItemStands.length) {
                            gameBM = -1;
                        }

                        if (gameBM >= 0) {
                            gameHQ = 1;
                        }

                        this.gameBB();
                    }
                } else {
                    label1620:
                    {
                        if (gameHZ) {
                            if (vParty.size() == 0) {
                                break label1620;
                            }

                            if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= vParty.size()) {
                                    indexRow = vParty.size() - 1;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (--indexRow < 0) {
                                    indexRow = 0;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            this.gameDE();
                        } else if (gameKA) {
                            if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= vPtMap.size()) {
                                    indexRow = vPtMap.size() - 1;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (--indexRow < 0) {
                                    indexRow = 0;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            this.gameAR();
                        } else if (gameDJ) {
                            if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= gameBO) {
                                    indexRow = 0;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (--indexRow < 0) {
                                    indexRow = gameBO - 1;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            this.gameDD();
                        } else if (gameKC) {
                            if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= gameBO) {
                                    indexRow = 0;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (--indexRow < 0) {
                                    indexRow = gameBO - 1;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            this.gameDC();
                        } else if (gameMF) {
                            if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= vCharInMap.size()) {
                                    indexRow = vCharInMap.size() - 1;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (--indexRow < 0) {
                                    indexRow = 0;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            if (this.gameEH > 0 && !GameCanvas.isTouch) {
                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            this.gameCZ();
                        } else if (gameKB) {
                            if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= vList.size()) {
                                    indexRow = vList.size() - 1;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (--indexRow < 0) {
                                    indexRow = 0;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            this.gameDB();
                        } else if (gameHX) {
                            if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= vList.size()) {
                                    indexRow = vList.size() - 1;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (--indexRow < 0) {
                                    indexRow = 0;
                                }

                                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                            }

                            this.gameDA();
                        }

                        if (GameCanvas.isTouch && GameCanvas.currentDialog == null && !GameCanvas.menu.showMenu) {
                            MyVector var13 = null;
                            if (gameHZ) {
                                var13 = vParty;
                            } else if (gameDJ) {
                                var13 = vFriend;
                            } else if (gameKC) {
                                var13 = vEnemies;
                            } else if (gameKA) {
                                var13 = vPtMap;
                            } else if (gameMF) {
                                var13 = vCharInMap;
                            } else if (gameKB) {
                                var13 = vList;
                            } else if (gameHX) {
                                var13 = vList;
                            }

                            if ((var16 = gameBU.gameAB()).isDowning || var16.isFinish) {
                                indexRow = var16.selected;
                                if (var16.selected >= var13.size()) {
                                    indexRow = -1;
                                }

                                if (gameHZ) {
                                    this.gameDE();
                                } else if (gameDJ) {
                                    this.gameDD();
                                } else if (gameKC) {
                                    this.gameDC();
                                } else if (gameMF) {
                                    this.gameCZ();
                                } else if (gameKB) {
                                    this.gameDB();
                                } else if (gameHX) {
                                    this.gameDA();
                                }
                            }
                        }

                        GameCanvas.gameAK();
                        GameCanvas.gameAJ();
                    }
                }
            }

            this.gameBA();
            if (gameDL && gameBP != -1 && GameCanvas.currentDialog == null) {
                if (gameHQ == 0) {
                    super.left = super.center = null;
                    if (gameBP == 0) {
                        super.left = new Command(mResources.gameCL, 110221);
                    }

                    if (GameCanvas.keyPressedz[8]) {
                        gameHQ = 1;
                        gameBM = 0;
                        indexRow = 0;
                        gameBU.gameAA();
                        gameBT.gameAA();
                    }

                    if (GameCanvas.keyPressedz[4]) {
                        gameBM = 0;
                        indexRow = -1;
                        --gameBP;
                        gameBU.gameAA();
                        gameBT.gameAA();
                        if (currentCharViewInfo.charID != Char.getMyChar().charID) {
                            if (gameBP < 3) {
                                gameBP = 5;
                            }
                        } else if (gameBP < 0) {
                            gameBP = mResources.gameGN.length - 1;
                        }

                        this.gameCB();
                    }

                    if (GameCanvas.keyPressedz[6]) {
                        gameBM = 0;
                        indexRow = -1;
                        ++gameBP;
                        gameBU.gameAA();
                        gameBT.gameAA();
                        if (currentCharViewInfo.charID != Char.getMyChar().charID) {
                            if (gameBP > 5) {
                                gameBP = 3;
                            }
                        } else if (gameBP > mResources.gameGN.length - 1) {
                            gameBP = 0;
                        }

                        this.gameCB();
                    }

                    this.gameBI();
                } else if (gameDK) {
                    if (GameCanvas.keyPressedz[2]) {
                        if (--indexRow < 0) {
                            indexRow = gameBO - 1;
                        }

                        gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (++indexRow >= gameBO) {
                            indexRow = 0;
                        }

                        gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                    }
                } else if (gameBP == 0) {
                    if (GameCanvas.keyPressedz[4]) {
                        if (--gameBM < 0) {
                            gameBM = Char.getMyChar().arrItemBag.length - 1;
                        }

                        super.left = super.center = null;
                        this.gameBI();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[6]) {
                        if (++gameBM >= Char.getMyChar().arrItemBag.length) {
                            gameBM = 0;
                        }

                        super.left = super.center = null;
                        this.gameBI();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (gameBM + gameTC <= Char.getMyChar().arrItemBag.length - 1) {
                            gameBM += gameTC;
                        }

                        super.left = super.center = null;
                        this.gameBI();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[2]) {
                        if (gameBM >= 0 && gameBM < gameTC) {
                            gameHQ = 0;
                            gameBM = 0;
                        } else if (gameBM - gameTC >= 0) {
                            gameBM -= gameTC;
                        }

                        super.left = super.center = null;
                        this.gameBI();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    }
                } else {
                    label1600:
                    {
                        if (gameBP == 1) {
                            if (GameCanvas.keyPressedz[2]) {
                                if (gameHQ == 1 && indexRow == -1) {
                                    --gameHQ;
                                } else if (gameHQ == 1 && indexRow >= 0) {
                                    --indexRow;
                                }

                                gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                                break label1600;
                            }

                            if (!GameCanvas.keyPressedz[8]) {
                                if (GameCanvas.keyPressedz[4]) {
                                    indexRow = -1;
                                    if (gameHQ == 1 && --gameBM < 0) {
                                        gameBM = Char.getMyChar().nClass.skillTemplates.length - 1;
                                    }

                                    super.left = super.center = null;
                                    this.gameBI();
                                    gameBU.gameAA(gameBM * gameBU.ITEM_SIZE);
                                    gameBT.gameAA();
                                    indexRow = 0;
                                } else if (GameCanvas.keyPressedz[6]) {
                                    indexRow = -1;
                                    if (gameHQ == 1 && ++gameBM >= Char.getMyChar().nClass.skillTemplates.length) {
                                        gameBM = 0;
                                    }

                                    super.left = super.center = null;
                                    this.gameBI();
                                    gameBU.gameAA(gameBM * gameBU.ITEM_SIZE);
                                    gameBT.gameAA();
                                    indexRow = 0;
                                }
                                break label1600;
                            }

                            if (gameHQ == 0) {
                                ++gameHQ;
                            } else if (gameHQ == 1) {
                                if (++indexRow >= gameBO) {
                                    indexRow = 0;
                                }

                                gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                            }

                            super.left = super.center = null;
                        } else if (gameBP == 2) {
                            if (GameCanvas.keyPressedz[2]) {
                                --gameHQ;
                                break label1600;
                            }

                            if (!GameCanvas.keyPressedz[8]) {
                                break label1600;
                            }

                            if (++gameHQ >= 5) {
                                gameHQ = 1;
                            }

                            super.left = super.center = null;
                        } else {
                            if (gameBP == 3) {
                                if (indexRow < 0) {
                                    indexRow = 0;
                                }

                                if (GameCanvas.keyPressedz[2]) {
                                    if (indexRow == 0) {
                                        --gameHQ;
                                        indexRow = -1;
                                    } else {
                                        --indexRow;
                                    }

                                    gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= gameBO) {
                                        indexRow = 0;
                                    }

                                    gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                                }
                                break label1600;
                            }

                            if (gameBP == 4) {
                                label1630:
                                {
                                    var1 = gameBM;
                                    if (gameBM != 11 && gameBM != 12 && gameBM != 13 && gameBM != 14) {
                                        if (gameBM == 9) {
                                            if (GameCanvas.keyPressedz[2]) {
                                                gameBM -= 2;
                                                break label1630;
                                            }

                                            if (GameCanvas.keyPressedz[8]) {
                                                gameBM = 15;
                                                break label1630;
                                            }

                                            if (!GameCanvas.keyPressedz[4]) {
                                                if (GameCanvas.keyPressedz[6]) {
                                                    ++gameBM;
                                                }
                                                break label1630;
                                            }
                                        } else if (gameBM == 10) {
                                            if (GameCanvas.keyPressedz[2]) {
                                                gameBM -= 2;
                                                break label1630;
                                            }

                                            if (!GameCanvas.keyPressedz[4]) {
                                                if (GameCanvas.keyPressedz[6] || GameCanvas.keyPressedz[8]) {
                                                    ++gameBM;
                                                }
                                                break label1630;
                                            }
                                        } else {
                                            if (gameBM != 15) {
                                                if (GameCanvas.keyPressedz[2]) {
                                                    if (gameBM <= 1) {
                                                        gameBM = 0;
                                                        gameHQ = 0;
                                                    } else {
                                                        gameBM -= 2;
                                                    }
                                                } else if (GameCanvas.keyPressedz[8]) {
                                                    if ((gameBM += 2) > 15) {
                                                        gameBM = 0;
                                                    }
                                                } else if (GameCanvas.keyPressedz[4]) {
                                                    if (--gameBM < 0) {
                                                        gameBM = 15;
                                                    }
                                                } else if (GameCanvas.keyPressedz[6] && ++gameBM > 11) {
                                                    gameBM = 0;
                                                }
                                                break label1630;
                                            }

                                            if (GameCanvas.keyPressedz[2]) {
                                                gameBM = 9;
                                                break label1630;
                                            }

                                            if (!GameCanvas.keyPressedz[4]) {
                                                if (GameCanvas.keyPressedz[8] || GameCanvas.keyPressedz[6]) {
                                                    gameBM = 0;
                                                }
                                                break label1630;
                                            }
                                        }
                                    } else if (!GameCanvas.keyPressedz[2] && !GameCanvas.keyPressedz[4]) {
                                        if (GameCanvas.keyPressedz[6] || GameCanvas.keyPressedz[8]) {
                                            ++gameBM;
                                        }
                                        break label1630;
                                    }

                                    --gameBM;
                                }

                                if (var1 == gameBM) {
                                    break label1600;
                                }

                                super.left = super.center = null;
                            } else {
                                if (gameBP != 5) {
                                    break label1600;
                                }

                                if (GameCanvas.keyPressedz[2]) {
                                    if (gameBM == 4) {
                                        gameBM = 0;
                                        --gameHQ;
                                    } else if (--gameBM < 0) {
                                        gameBM = 0;
                                        --gameHQ;
                                    }

                                    this.gameBI();
                                    break label1600;
                                }

                                if (GameCanvas.keyPressedz[4]) {
                                    if (gameBM >= 2 && gameBM != 4) {
                                        gameBM = 4;
                                    } else {
                                        gameBM = 0;
                                    }

                                    this.gameBI();
                                    break label1600;
                                }

                                if (GameCanvas.keyPressedz[6]) {
                                    if (gameBM < 2) {
                                        gameBM = 4;
                                    } else {
                                        gameBM = 2;
                                    }

                                    this.gameBI();
                                    break label1600;
                                }

                                if (!GameCanvas.keyPressedz[8]) {
                                    break label1600;
                                }

                                if (++gameBM >= 4) {
                                    gameBM = 0;
                                }
                            }
                        }

                        this.gameBI();
                    }
                }

                if (GameCanvas.isTouch) {
                    this.gameCT();
                }

                GameCanvas.gameAK();
                GameCanvas.gameAJ();
            }

            if (gameAQ) {
                this.gameGR.gameAA();
            }

            this.gameCU();
            if (gameHY) {
                if (gameHQ == 0) {
                    if (gameHQ == 0 && GameCanvas.keyPressedz[8]) {
                        gameHQ = 1;
                        indexRow = -1;
                        gameBU.gameAA();
                        gameBT.gameAA();
                    }
                } else {
                    if (indexRow < 0) {
                        indexRow = 0;
                    }

                    if (GameCanvas.keyPressedz[2]) {
                        if (indexRow == 0) {
                            --gameHQ;
                            indexRow = -1;
                        } else {
                            --indexRow;
                        }

                        gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (++indexRow >= gameBO) {
                            indexRow = 0;
                        }

                        gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                    }
                }

                if (GameCanvas.isTouch && ((var19 = gameBU.gameAB()).isDowning || var19.isFinish)) {
                    indexRow = var19.selected;
                    gameHQ = 1;
                }
            }

            this.gameCX();
            this.gameCY();
            int var20;
            if (Char.getMyChar().currentMovePoint != null) {
                for (var20 = 0; var20 < GameCanvas.keyPressedz.length; ++var20) {
                    if (GameCanvas.keyPressedz[var20]) {
                        Char.getMyChar().currentMovePoint = null;
                        break;
                    }
                }
            }

            if (ChatTextField.gameAA().isShow && GameCanvas.gameBR != 0) {
                ChatTextField var17 = ChatTextField.gameAA();
                var1 = GameCanvas.gameBR;
                if (var17.isShow) {
                    var17.tfChat.gameAA(var1);
                }

                if (var17.tfChat.gameAD().equals("")) {
                    var17.right.caption = mResources.CLOSE;
                } else {
                    var17.right.caption = mResources.DELETE;
                }

                GameCanvas.gameBR = 0;
            }

            if (this.gameNB) {
                GameCanvas.gameAK();
            } else {
                if (GameCanvas.menu.showMenu || gameDH() || Char.gameGM) {
                    return;
                }

                if (GameCanvas.keyPressedz[10]) {
                    GameCanvas.keyPressedz[10] = false;
                    gameAW();
                    GameCanvas.gameAJ();
                }

                if (GameCanvas.keyPressedz[11]) {
                    GameCanvas.keyPressedz[11] = false;
                    gameAV();
                    GameCanvas.gameAJ();
                }

                if (GameCanvas.gameBR != 0 && TField.isQwerty) {
                    if (GameCanvas.gameBR == 32) {
                        gameAW();
                        GameCanvas.gameBR = 0;
                        GameCanvas.gameAJ();
                    } else if (GameCanvas.gameBR == 64) {
                        gameAV();
                        GameCanvas.gameBR = 0;
                        GameCanvas.gameAJ();
                    } else if (GameCanvas.gameBR == 48) {
                        gameAV();
                        GameCanvas.gameBR = 0;
                        GameCanvas.gameAJ();
                    } else if (GameCanvas.gameBR == 63) {
                        gameAV();
                        GameCanvas.gameBR = 0;
                        GameCanvas.gameAJ();
                    }
                }

                if (Char.getMyChar().skillPaint != null) {
                    return;
                }

                if (Char.getMyChar().isCaptcha) {
                    if (GameCanvas.keyHold[4]) {
                        this.gameAE((byte) 0);
                        GameCanvas.gameAK();
                    } else if (GameCanvas.keyHold[2]) {
                        this.gameAE((byte) 1);
                        GameCanvas.gameAK();
                    } else if (GameCanvas.keyHold[6]) {
                        this.gameAE((byte) 2);
                        GameCanvas.gameAK();
                    }
                } else {
                    if (Char.getMyChar().statusMe == 1) {
                        if (GameCanvas.keyPressedz[5]) {
                            GameCanvas.keyPressedz[5] = false;
                            this.gameAB(false);
                        } else if (GameCanvas.keyHold[2]) {
                            if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                gameAK(0);
                            }
                        } else if (GameCanvas.keyHold[1]) {
                            Char.getMyChar().cdir = -1;
                            if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                gameAK(-4);
                            }
                        } else if (GameCanvas.keyHold[3]) {
                            Char.getMyChar().cdir = 1;
                            if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                gameAK(4);
                            }
                        } else if (GameCanvas.keyHold[4]) {
                            Char.getMyChar();
                            if (Char.getMyChar().cdir == 1) {
                                Char.getMyChar().cdir = -1;
                            } else if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                Char.getMyChar().statusMe = 2;
                                Char.getMyChar().cvx = -Char.getMyChar().gameAG();
                            }
                        } else if (GameCanvas.keyHold[6]) {
                            Char.getMyChar();
                            if (Char.getMyChar().cdir == -1) {
                                Char.getMyChar().cdir = 1;
                            } else if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                Char.getMyChar().statusMe = 2;
                                Char.getMyChar().cvx = Char.getMyChar().gameAG();
                            }
                        }
                    } else if (Char.getMyChar().statusMe == 2) {
                        if (GameCanvas.keyPressedz[5]) {
                            GameCanvas.keyPressedz[5] = false;
                            this.gameAB(false);
                        } else if (GameCanvas.keyHold[2]) {
                            Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
                            Char.getMyChar().statusMe = 3;
                            Char.getMyChar().cp1 = 0;
                        } else if (GameCanvas.keyHold[1]) {
                            Char.getMyChar().cdir = -1;
                            Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
                            Char.getMyChar().cvx = -4;
                            Char.getMyChar().statusMe = 3;
                            Char.getMyChar().cp1 = 0;
                        } else if (GameCanvas.keyHold[3]) {
                            Char.getMyChar().cdir = 1;
                            Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
                            Char.getMyChar().cvx = 4;
                            Char.getMyChar().statusMe = 3;
                            Char.getMyChar().cp1 = 0;
                        } else {
                            Char var18;
                            if (GameCanvas.keyHold[4]) {
                                if (Char.getMyChar().cdir == 1) {
                                    Char.getMyChar().cdir = -1;
                                } else {
                                    var18 = Char.getMyChar();
                                    var20 = -Char.getMyChar().gameAG();
                                    Char.getMyChar();
                                    var18.cvx = var20;
                                }
                            } else if (GameCanvas.keyHold[6]) {
                                if (Char.getMyChar().cdir == -1) {
                                    Char.getMyChar().cdir = 1;
                                } else {
                                    var18 = Char.getMyChar();
                                    var20 = Char.getMyChar().gameAG();
                                    Char.getMyChar();
                                    var18.cvx = var20;
                                }
                            }
                        }
                    } else if (Char.getMyChar().statusMe == 3) {
                        if (GameCanvas.keyPressedz[5]) {
                            GameCanvas.keyPressedz[5] = false;
                            this.gameAB(false);
                        }

                        if (!GameCanvas.keyHold[4] && !GameCanvas.keyHold[1]) {
                            if (GameCanvas.keyHold[6] || GameCanvas.keyHold[3]) {
                                if (Char.getMyChar().cdir == -1) {
                                    Char.getMyChar().cdir = 1;
                                } else {
                                    Char.getMyChar().cvx = Char.getMyChar().gameAG();
                                }
                            }
                        } else if (Char.getMyChar().cdir == 1) {
                            Char.getMyChar().cdir = -1;
                        } else {
                            Char.getMyChar().cvx = -Char.getMyChar().gameAG();
                        }

                        if ((GameCanvas.keyHold[2] || GameCanvas.keyHold[1] || GameCanvas.keyHold[3]) && Char.getMyChar().canJumpHigh && Char.getMyChar().cp1 == 0 && Char.getMyChar().cvy > -4) {
                            ++Char.getMyChar().cp1;
                            Char.getMyChar().cvy = -7;
                        }
                    } else if (Char.getMyChar().statusMe == 4) {
                        if (GameCanvas.keyPressedz[5]) {
                            GameCanvas.keyPressedz[5] = false;
                            this.gameAB(false);
                        }

                        if (GameCanvas.keyPressedz[2]) {
                            GameCanvas.gameAJ();
                        }

                        if (GameCanvas.keyHold[4]) {
                            if (Char.getMyChar().cdir == 1) {
                                Char.getMyChar().cdir = -1;
                            } else {
                                Char.getMyChar().cvx = -Char.getMyChar().gameAG();
                            }
                        } else if (GameCanvas.keyHold[6]) {
                            if (Char.getMyChar().cdir == -1) {
                                Char.getMyChar().cdir = 1;
                            } else {
                                Char.getMyChar().cvx = Char.getMyChar().gameAG();
                            }
                        }
                    } else if (Char.getMyChar().statusMe == 10) {
                        if (GameCanvas.keyPressedz[5]) {
                            GameCanvas.keyPressedz[5] = false;
                            this.gameAB(false);
                        }

                        if (GameCanvas.keyHold[2]) {
                            Char.getMyChar().cvy = -10;
                            Char.getMyChar().statusMe = 3;
                            Char.getMyChar().cp1 = 0;
                        } else if (GameCanvas.keyHold[4]) {
                            if (Char.getMyChar().cdir == 1) {
                                Char.getMyChar().cdir = -1;
                            } else {
                                Char.getMyChar().cvx = -5;
                            }
                        } else if (GameCanvas.keyHold[6]) {
                            if (Char.getMyChar().cdir == -1) {
                                Char.getMyChar().cdir = 1;
                            } else {
                                Char.getMyChar().cvx = 5;
                            }
                        }
                    } else if (Char.getMyChar().statusMe == 7) {
                        if (GameCanvas.keyPressedz[5]) {
                            GameCanvas.keyPressedz[5] = false;
                        }

                        if (GameCanvas.keyHold[4]) {
                            if (Char.getMyChar().cdir == 1) {
                                Char.getMyChar().cdir = -1;
                            } else {
                                Char.getMyChar().cvx = -Char.getMyChar().gameAG() + 2;
                            }
                        } else if (GameCanvas.keyHold[6]) {
                            if (Char.getMyChar().cdir == -1) {
                                Char.getMyChar().cdir = 1;
                            } else {
                                Char.getMyChar().cvx = Char.getMyChar().gameAG() - 2;
                            }
                        }
                    } else if (Char.getMyChar().statusMe == 11) {
                        if (GameCanvas.keyPressedz[5]) {
                            GameCanvas.keyPressedz[5] = false;
                            this.gameAB(false);
                        }

                        if (GameCanvas.keyHold[2]) {
                            Char.getMyChar().cvy = -10;
                            Char.getMyChar().statusMe = 3;
                            Char.getMyChar().cp1 = 0;
                        }
                    }

                    if (GameCanvas.keyPressedz[8] && GameCanvas.gameBR != 56) {
                        GameCanvas.keyPressedz[8] = false;
                        this.gameCQ();
                    }
                }

                if (GameCanvas.gameBR != 0) {
                    if (TField.isQwerty) {
                        if (GameCanvas.gameBR == 113) {
                            this.gameHO = true;
                            if (gamePA[0] != null) {
                                this.gameAA(gamePA[0], true);
                            }
                        } else if (GameCanvas.gameBR == 119) {
                            this.gameHO = true;
                            if (gamePA[1] != null) {
                                this.gameAA(gamePA[1], true);
                            }
                        } else if (GameCanvas.gameBR == 101) {
                            this.gameHO = true;
                            if (gamePA[2] != null) {
                                this.gameAA(gamePA[2], true);
                            }
                        } else {
                            ChatTextField.gameAA().gameAA(GameCanvas.gameBR, this, mResources.PUBLICCHAT[0]);
                        }
                    } else if (!GameCanvas.gameAB) {
                        ChatTextField.gameAA().gameAA(GameCanvas.gameBR, this, mResources.PUBLICCHAT[0]);
                    } else if (GameCanvas.gameBR == 55) {
                        this.gameHO = true;
                        if (gamePA[0] != null) {
                            this.gameAA(gamePA[0], true);
                        }
                    } else if (GameCanvas.gameBR == 56) {
                        this.gameHO = true;
                        if (gamePA[1] != null) {
                            this.gameAA(gamePA[1], true);
                        }
                    } else if (GameCanvas.gameBR == 57) {
                        this.gameHO = true;
                        if (gamePA[2] != null) {
                            this.gameAA(gamePA[2], true);
                        }
                    } else if (GameCanvas.gameBR == 48) {
                        ChatTextField.gameAA().gameAA(mResources.PUBLICCHAT[0]);
                    }

                    GameCanvas.gameBR = 0;
                }
            }

            GameCanvas.gameAJ();
        }

    }

    private void gameCO() {
        gameFW = 0;
        this.gameFX = Char.getMyChar().isLockMove = false;
    }

    public static void gameAV() {
        if (!Char.getMyChar().gameAE(17)) {
            for (int var0 = 0; var0 < Char.getMyChar().arrItemBag.length; ++var0) {
                if (Char.getMyChar().arrItemBag[var0] != null && Char.getMyChar().arrItemBag[var0].template.type == 17) {
                    InfoMe.gameAA(mResources.gameSD);
                    return;
                }
            }

            if (gameFW != 1) {
                InfoMe.gameAA(mResources.gameSE);
            }
        }

    }

    public static void gameAW() {
        int var0 = (int) (System.currentTimeMillis() / 1000L);

        int var1;
        for (var1 = 0; var1 < Char.getMyChar().vEff.size(); ++var1) {
            Effect var2;
            if ((var2 = (Effect) Char.getMyChar().vEff.elementAt(var1)).template.id == 21 && var2.timeLenght - (var0 - var2.timeStart) >= 2) {
                return;
            }
        }

        if (!Char.getMyChar().gameAE(16)) {
            for (var1 = 0; var1 < Char.getMyChar().arrItemBag.length; ++var1) {
                if (Char.getMyChar().arrItemBag[var1] != null && Char.getMyChar().arrItemBag[var1].template.type == 16) {
                    InfoMe.gameAA(mResources.gameSD);
                    return;
                }
            }

            if (gameFW != 1) {
                InfoMe.gameAA(mResources.gameSF);
            }
        }

    }

    private static boolean gameCP() {
        return Char.getMyChar().mobFocus != null && (Char.getMyChar().mobFocus.getTemplate().mobTemplateId == 142 && Char.getMyChar().cTypePk == 4 || Char.getMyChar().mobFocus.getTemplate().mobTemplateId == 143 && Char.getMyChar().cTypePk == 5);
    }

    private void gameAB(boolean var1) {
        if (Char.getMyChar().statusMe != 14) {
            boolean var4;
            MyVector var5;
            label438:
            {
                label411:
                {
                    if (!InfoDlg.gameAF && !Char.getMyChar().isLockAttack && !Char.gameGM && !Char.getMyChar().isBlinking) {
                        label439:
                        {
                            if (Char.getMyChar().mobFocus != null && (Char.getMyChar().mobFocus.templateId == 97 && Char.getMyChar().cTypePk == 4 || Char.getMyChar().mobFocus.templateId == 98 && Char.getMyChar().cTypePk == 4 || Char.getMyChar().mobFocus.templateId == 96 && Char.getMyChar().cTypePk == 5 || Char.getMyChar().mobFocus.templateId == 99 && Char.getMyChar().cTypePk == 5)) {
                                var4 = false;
                                break label438;
                            }

                            if (Char.getMyChar().myskill != null && Char.getMyChar().myskill.template.type == 2 && Char.getMyChar().npcFocus == null) {
                                var4 = gameCN();
                                break label438;
                            }

                            if (Char.getMyChar().skillPaint != null || Char.getMyChar().charFocus != null && Char.getMyChar().charFocus.isNhanban || Char.getMyChar().mobFocus == null && Char.getMyChar().npcFocus == null && Char.getMyChar().charFocus == null && Char.getMyChar().itemFocus == null) {
                                var4 = false;
                                break label438;
                            }

                            int var2;
                            int var3;
                            if (Char.getMyChar().mobFocus != null) {
                                if (Char.getMyChar().myskill == null) {
                                    break label439;
                                }

                                if (Char.getMyChar().arrItemBody[1] == null) {
                                    InfoMe.gameAA(mResources.gameTH);
                                    break label439;
                                }

                                if (Char.getMyChar().mobFocus.status == 1 || Char.getMyChar().mobFocus.status == 0 || Char.getMyChar().myskill.template.type == 4) {
                                    var4 = false;
                                    break label438;
                                }

                                if (!gameCN()) {
                                    break label439;
                                }

                                if (Char.getMyChar().cx < Char.getMyChar().mobFocus.x) {
                                    Char.getMyChar().cdir = 1;
                                } else {
                                    Char.getMyChar().cdir = -1;
                                }

                                var2 = Math.abs(Char.getMyChar().cx - Char.getMyChar().mobFocus.x);
                                var3 = Math.abs(Char.getMyChar().cy - Char.getMyChar().mobFocus.y);
                                Char.getMyChar().cvx = 0;
                                if (Char.getMyChar().gameAH()) {
                                    if (var2 > Char.getMyChar().myskill.gameAB() || var3 > Char.getMyChar().myskill.gameAC()) {
                                        Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().mobFocus.x, Char.getMyChar().cy);
                                        GameCanvas.gameAK();
                                        GameCanvas.gameAJ();
                                        break label439;
                                    }

                                    GameCanvas.gameAK();
                                    GameCanvas.gameAJ();
                                } else if ((Char.getMyChar().myskill.template.id == 24 || Char.getMyChar().myskill.template.id == 40 || Char.getMyChar().myskill.template.id == 42) && var2 <= Char.getMyChar().myskill.gameAB() && var3 <= Char.getMyChar().myskill.gameAC()) {
                                    GameCanvas.gameAK();
                                    GameCanvas.gameAJ();
                                    Char.getMyChar().cvx = 0;
                                } else {
                                    if (var2 > Char.getMyChar().myskill.gameAB() || var3 > Char.getMyChar().myskill.gameAC() || Char.getMyChar().cy < Char.getMyChar().mobFocus.y - 10) {
                                        Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().mobFocus.x + Char.getMyChar().mobFocus.dir * 12, Char.getMyChar().cy);
                                        GameCanvas.gameAK();
                                        GameCanvas.gameAJ();
                                        break label439;
                                    }

                                    GameCanvas.gameAK();
                                    GameCanvas.gameAJ();
                                    Char.getMyChar().cvx = 0;
                                }
                            } else {
                                if (Char.getMyChar().npcFocus != null) {
                                    if (Char.getMyChar().cx < Char.getMyChar().npcFocus.cx) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cdir = -1;
                                    }

                                    if (Char.getMyChar().cx < Char.getMyChar().npcFocus.cx) {
                                        Char.getMyChar().npcFocus.cdir = -1;
                                    } else {
                                        Char.getMyChar().npcFocus.cdir = 1;
                                    }

                                    var2 = Math.abs(Char.getMyChar().cx - Char.getMyChar().npcFocus.cx);
                                    var3 = Math.abs(Char.getMyChar().cy - Char.getMyChar().npcFocus.cy);
                                    if (var2 < 60 && var3 < 40) {
                                        GameCanvas.gameAK();
                                        GameCanvas.gameAJ();
                                        if (Char.getMyChar().npcFocus.template.npcTemplateId == 13) {
                                            InfoDlg.gameAB();
                                            Service.gI().gameAE();
                                        } else {
                                            Service.gI().gameAH(Char.getMyChar().npcFocus.template.npcTemplateId);
                                            InfoDlg.gameAB();
                                        }
                                    } else {
                                        Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().npcFocus.cx, Char.getMyChar().cy);
                                        GameCanvas.gameAK();
                                        GameCanvas.gameAJ();
                                    }

                                    var4 = false;
                                    break label438;
                                }

                                if (Char.getMyChar().charFocus != null) {
                                    if (Char.getMyChar().cx < Char.getMyChar().charFocus.cx) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cdir = -1;
                                    }

                                    var2 = Math.abs(Char.getMyChar().cx - Char.getMyChar().charFocus.cx);
                                    var3 = Math.abs(Char.getMyChar().cy - Char.getMyChar().charFocus.cy);
                                    Char.getMyChar();
                                    if (!Char.gameAB(Char.getMyChar().charFocus)) {
                                        if (var2 >= 60 || var3 >= 40 || Char.getMyChar().charFocus.charID < 0) {
                                            Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().charFocus.cx, Char.getMyChar().cy);
                                            GameCanvas.gameAK();
                                            GameCanvas.gameAJ();
                                            break label411;
                                        }

                                        GameCanvas.gameAK();
                                        if (Char.getMyChar().charFocus.statusMe == 14 || Char.getMyChar().charFocus.statusMe == 5 || TileMap.gameAN != 1) {
                                            if (!this.gameHO) {
                                                (var5 = new MyVector()).addElement(new Command(mResources.gameSG[6], 110397));
                                                var5.addElement(new Command(mResources.gameSG[4], 110391));
                                                if ((Char.getMyChar().ctypeClan == 4 || Char.getMyChar().ctypeClan == 3 || Char.getMyChar().ctypeClan == 2) && Char.getMyChar().charFocus.cClanName.equals("")) {
                                                    var5.addElement(new Command(mResources.gameSG[8], 110398));
                                                }

                                                if ((Char.getMyChar().charFocus.ctypeClan == 4 || Char.getMyChar().charFocus.ctypeClan == 3 || Char.getMyChar().charFocus.ctypeClan == 2) && Char.getMyChar().cClanName.equals("")) {
                                                    var5.addElement(new Command(mResources.gameSG[9], 110399));
                                                }

                                                var5.addElement(new Command(mResources.gameSG[7], 12004, Char.getMyChar().charFocus.cName));
                                                if (Char.getMyChar().nClass.classId == 6) {
                                                    var5.addElement(new Command(mResources.gameSG[11] + ": " + (!Char.gameFR ? mResources.gameBY : mResources.gameBZ), 1103991));
                                                }

                                                if (Char.getMyChar().charFocus.statusMe != 14 && Char.getMyChar().charFocus.statusMe != 5) {
                                                    var5.addElement(new Command(mResources.gameSG[0], 110392));
                                                    var5.addElement(new Command(mResources.gameSG[1], 110393));
                                                    var5.addElement(new Command(mResources.gameSG[2], 110394));
                                                } else if (Char.getMyChar().myskill.template.type == 4) {
                                                    var5.addElement(new Command(mResources.gameSG[5], 110395));
                                                }

                                                var5.addElement(new Command(mResources.gameSG[3], 110396));
                                                GameCanvas.menu.gameAA(var5);
                                            }

                                            this.gameHO = false;
                                            break label411;
                                        }
                                        break label439;
                                    }

                                    if (Char.getMyChar().myskill == null) {
                                        break label439;
                                    }

                                    if (Char.getMyChar().arrItemBody[1] == null) {
                                        InfoMe.gameAA(mResources.gameTH);
                                        break label439;
                                    }

                                    if (!gameCN()) {
                                        break label439;
                                    }

                                    if (Char.getMyChar().cx < Char.getMyChar().charFocus.cx) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cdir = -1;
                                    }

                                    Char.getMyChar().cvx = 0;
                                    if (Char.getMyChar().gameAH()) {
                                        if (var2 > Char.getMyChar().myskill.gameAB() || var3 > Char.getMyChar().myskill.gameAC()) {
                                            Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().charFocus.cx, Char.getMyChar().cy);
                                            GameCanvas.gameAK();
                                            GameCanvas.gameAJ();
                                            break label439;
                                        }

                                        GameCanvas.gameAK();
                                        GameCanvas.gameAJ();
                                    } else if ((Char.getMyChar().myskill.template.id == 24 || Char.getMyChar().myskill.template.id == 40 || Char.getMyChar().myskill.template.id == 42) && var2 <= Char.getMyChar().myskill.gameAB() && var3 <= Char.getMyChar().myskill.gameAC()) {
                                        GameCanvas.gameAK();
                                        GameCanvas.gameAJ();
                                        Char.getMyChar().cvx = 0;
                                    } else {
                                        if (var2 > Char.getMyChar().myskill.gameAB() || var3 > Char.getMyChar().myskill.gameAC() || Char.getMyChar().cy < Char.getMyChar().charFocus.cy) {
                                            Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().charFocus.cx + Char.getMyChar().charFocus.cdir * 12, Char.getMyChar().cy);
                                            GameCanvas.gameAK();
                                            GameCanvas.gameAJ();
                                            break label439;
                                        }

                                        GameCanvas.gameAK();
                                        GameCanvas.gameAJ();
                                        Char.getMyChar().cvx = 0;
                                    }
                                } else if (Char.getMyChar().itemFocus != null) {
                                    if (Char.getMyChar().statusMe == 1) {
                                        if (Char.getMyChar().cx < Char.getMyChar().itemFocus.x) {
                                            Char.getMyChar().cdir = 1;
                                        } else {
                                            Char.getMyChar().cdir = -1;
                                        }

                                        var2 = Math.abs(Char.getMyChar().cx - Char.getMyChar().itemFocus.x);
                                        var3 = Math.abs(Char.getMyChar().cy - Char.getMyChar().itemFocus.y);
                                        if (var2 <= 35 && var3 < 35 || gameFW != 0 && var2 <= 48 && var3 <= 48) {
                                            GameCanvas.gameAK();
                                            GameCanvas.gameAJ();
                                            Service.gI().gameAQ(Char.getMyChar().itemFocus.itemMapID);
                                        } else {
                                            Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().itemFocus.x, Char.getMyChar().cy);
                                            GameCanvas.gameAK();
                                            GameCanvas.gameAJ();
                                        }

                                        var4 = false;
                                        break label438;
                                    }
                                    break label439;
                                }
                            }

                            var4 = true;
                            break label438;
                        }
                    }

                    var4 = false;
                    break label438;
                }

                var4 = false;
            }

            if (var4) {
                if (gameCP()) {
                    (var5 = new MyVector()).addElement(new Command(mResources.gameXA, 151301));
                    GameCanvas.menu.gameAA(var5);
                    return;
                }

                if (Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.getTemplate().mobTemplateId == 144 && TileMap.mapID == 130) {
                    (var5 = new MyVector()).addElement(new Command(mResources.gameXE, 151301));
                    GameCanvas.menu.gameAA(var5);
                    return;
                }

                Char.getMyChar().gameAA((SkillPaint) sks[Char.getMyChar().myskill.template.id], 0);
                Char.getMyChar().gameHK = var1;
                if (Char.getMyChar().isWolf) {
                    Char.getMyChar().isWolf = false;
                    Char.getMyChar().timeChatReturn = System.currentTimeMillis();
                    if (Char.getMyChar().vitaWolf >= 500) {
                        ServerEffect.gameAA(60, Char.getMyChar(), 1);
                    }
                }

                if (Char.getMyChar().gameAT() && !Char.getMyChar().gameCP) {
                    Char.getMyChar().isMoto = false;
                    Char.getMyChar().gameCP = true;
                    ServerEffect.gameAA(60, Char.getMyChar(), 1);
                }
            }
        }

        if (!var1) {
            Char.getMyChar().lastNormalSkill = Char.getMyChar().myskill;
        }

    }

    private void gameCQ() {
        this.gamePI = 0;

        int var1;
        for (var1 = 0; var1 < gamePB.length; ++var1) {
            if (gamePB[var1] != null) {
                ++this.gamePI;
            }
        }

        if (this.gamePI <= 1) {
            InfoMe.gameAB();
        } else {
            if (!gameKD || this.gamePJ == -1) {
                gameKD = true;

                for (var1 = 0; var1 < gamePB.length; ++var1) {
                    if (gamePB[var1] == Char.getMyChar().myskill) {
                        this.gamePJ = var1;
                        break;
                    }
                }
            }

            ++this.gamePJ;
            if (this.gamePJ >= gamePB.length) {
                this.gamePJ = 0;
            }

            if (gamePB[this.gamePJ] == null) {
                this.gamePJ = 0;
            }

            super.center = new Command("", 11059);
        }
    }

    public final void gameAA(Skill var1, boolean var2) {
        this.gamePJ = -1;
        if (var1 != null) {
            if (var1.template.type == 4 && Char.getMyChar().charFocus != null) {
                if (Char.getMyChar().charFocus.isNhanban) {
                    return;
                }

                if (Char.getMyChar().charFocus.statusMe == 14 || Char.getMyChar().charFocus.statusMe == 5) {
                    Service.gI().gameAX(Char.getMyChar().charFocus.charID);
                    if ((TileMap.gameAA(Char.getMyChar().cx, Char.getMyChar().cy) & 2) == 2) {
                        Char.getMyChar().gameAA((SkillPaint) sks[49], 0);
                    } else {
                        Char.getMyChar().gameAA((SkillPaint) sks[49], 1);
                    }
                }
            } else {
                Service.gI().gameAG(var1.template.id);
            }
        }

        if (var1.template.type != 2) {
            this.gameAU();
        }

        if (var1 != null) {
            Char.getMyChar().myskill = var1;
            if (var1.template.type == 1 && Code.gameAB != null) {
                Auto.skill1 = var1;
            }

            if (Char.getMyChar().npcFocus == null && var1.template.type != 4) {
                this.gameAB(var2);
            }
        }

    }

    public static void gameAC(int var0) {
        MyVector var6 = var0 == 0 ? vFriend : vEnemies;

        for (int var1 = 0; var1 < var6.size() - 1; ++var1) {
            Friend var2 = (Friend) var6.elementAt(var1);

            for (int var3 = var1 + 1; var3 < var6.size(); ++var3) {
                Friend var4;
                Friend var5;
                if ((var4 = (Friend) var6.elementAt(var3)).type > var2.type) {
                    var5 = var4;
                    var4 = var2;
                    var2 = var5;
                    var6.setElementAt(var5, var1);
                    var6.setElementAt(var4, var3);
                } else if (var4.type == var2.type && var2.friendName.compareTo(var4.friendName) > 0) {
                    var5 = var4;
                    var4 = var2;
                    var2 = var5;
                    var6.setElementAt(var5, var1);
                    var6.setElementAt(var4, var3);
                }
            }
        }

    }

    public static void gameAX() {
        for (int var0 = 0; var0 < vClan.size() - 1; ++var0) {
            Member var1 = (Member) vClan.elementAt(var0);

            for (int var2 = var0 + 1; var2 < vClan.size(); ++var2) {
                Member var3 = (Member) vClan.elementAt(var2);
                Member var4;
                if (gameHU && !gameHV) {
                    if (var3.gameAE && !var1.gameAE) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                    } else if (var3.gameAE && var1.gameAE) {
                        if (var3.gameAC > var1.gameAC) {
                            var4 = var3;
                            var3 = var1;
                            var1 = var4;
                            vClan.setElementAt(var4, var0);
                            vClan.setElementAt(var3, var2);
                        } else if (var3.gameAC == var1.gameAC) {
                            if (var3.gameAF > var1.gameAF) {
                                var4 = var3;
                                var3 = var1;
                                var1 = var4;
                                vClan.setElementAt(var4, var0);
                                vClan.setElementAt(var3, var2);
                            } else if (var1.gameAF == var3.gameAF) {
                                if (var3.gameAG > var1.gameAG) {
                                    var4 = var3;
                                    var3 = var1;
                                    var1 = var4;
                                    vClan.setElementAt(var4, var0);
                                    vClan.setElementAt(var3, var2);
                                } else if (var1.gameAG == var3.gameAG) {
                                    if (var3.gameAB > var1.gameAB) {
                                        var4 = var3;
                                        var3 = var1;
                                        var1 = var4;
                                        vClan.setElementAt(var4, var0);
                                        vClan.setElementAt(var3, var2);
                                    } else if (var1.gameAB == var3.gameAB && var1.gameAD.compareTo(var3.gameAD) > 0) {
                                        var4 = var3;
                                        var3 = var1;
                                        var1 = var4;
                                        vClan.setElementAt(var4, var0);
                                        vClan.setElementAt(var3, var2);
                                    }
                                }
                            }
                        }
                    }
                } else if (gameHV) {
                    if (gameHU) {
                        if (var3.gameAE && !var1.gameAE) {
                            var4 = var3;
                            var3 = var1;
                            var1 = var4;
                            vClan.setElementAt(var4, var0);
                            vClan.setElementAt(var3, var2);
                        } else if (var3.gameAE && var1.gameAE) {
                            if (var3.gameAG > var1.gameAG) {
                                var4 = var3;
                                var3 = var1;
                                var1 = var4;
                                vClan.setElementAt(var4, var0);
                                vClan.setElementAt(var3, var2);
                            } else if (var1.gameAG == var3.gameAG) {
                                if (var3.gameAF > var1.gameAF) {
                                    var4 = var3;
                                    var3 = var1;
                                    var1 = var4;
                                    vClan.setElementAt(var4, var0);
                                    vClan.setElementAt(var3, var2);
                                } else if (var1.gameAF == var3.gameAF) {
                                    if (var3.gameAC > var1.gameAC) {
                                        var4 = var3;
                                        var3 = var1;
                                        var1 = var4;
                                        vClan.setElementAt(var4, var0);
                                        vClan.setElementAt(var3, var2);
                                    } else if (var3.gameAC == var1.gameAC && var1.gameAB == var3.gameAB && var1.gameAD.compareTo(var3.gameAD) > 0) {
                                        var4 = var3;
                                        var3 = var1;
                                        var1 = var4;
                                        vClan.setElementAt(var4, var0);
                                        vClan.setElementAt(var3, var2);
                                    }
                                }
                            }
                        }
                    } else if (var3.gameAG > var1.gameAG) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                    } else if (var1.gameAG == var3.gameAG) {
                        if (var3.gameAF > var1.gameAF) {
                            var4 = var3;
                            var3 = var1;
                            var1 = var4;
                            vClan.setElementAt(var4, var0);
                            vClan.setElementAt(var3, var2);
                        } else if (var1.gameAF == var3.gameAF) {
                            if (var3.gameAC > var1.gameAC) {
                                var4 = var3;
                                var3 = var1;
                                var1 = var4;
                                vClan.setElementAt(var4, var0);
                                vClan.setElementAt(var3, var2);
                            } else if (var3.gameAC == var1.gameAC && var1.gameAB == var3.gameAB && var1.gameAD.compareTo(var3.gameAD) > 0) {
                                var4 = var3;
                                var3 = var1;
                                var1 = var4;
                                vClan.setElementAt(var4, var0);
                                vClan.setElementAt(var3, var2);
                            }
                        }
                    }
                } else if (var3.gameAC > var1.gameAC) {
                    var4 = var3;
                    var3 = var1;
                    var1 = var4;
                    vClan.setElementAt(var4, var0);
                    vClan.setElementAt(var3, var2);
                } else if (var3.gameAC == var1.gameAC) {
                    if (var3.gameAF > var1.gameAF) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                    } else if (var1.gameAF == var3.gameAF) {
                        if (var3.gameAG > var1.gameAG) {
                            var4 = var3;
                            var3 = var1;
                            var1 = var4;
                            vClan.setElementAt(var4, var0);
                            vClan.setElementAt(var3, var2);
                        } else if (var1.gameAG == var3.gameAG) {
                            if (var3.gameAB > var1.gameAB) {
                                var4 = var3;
                                var3 = var1;
                                var1 = var4;
                                vClan.setElementAt(var4, var0);
                                vClan.setElementAt(var3, var2);
                            } else if (var1.gameAB == var3.gameAB && var1.gameAD.compareTo(var3.gameAD) > 0) {
                                var4 = var3;
                                var3 = var1;
                                var1 = var4;
                                vClan.setElementAt(var4, var0);
                                vClan.setElementAt(var3, var2);
                            }
                        }
                    }
                }
            }
        }

    }

    public static void gameAY() {
        for (int var0 = 0; var0 < Char.getMyChar().vSkillFight.size() - 1; ++var0) {
            Skill var1 = (Skill) Char.getMyChar().vSkillFight.elementAt(var0);

            for (int var2 = var0 + 1; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
                Skill var3;
                if ((var3 = (Skill) Char.getMyChar().vSkillFight.elementAt(var2)).template.id < var1.template.id) {
                    Skill var4 = var3;
                    var3 = var1;
                    var1 = var4;
                    Char.getMyChar().vSkillFight.setElementAt(var4, var0);
                    Char.getMyChar().vSkillFight.setElementAt(var3, var2);
                }
            }
        }

    }

    private static void gameAK(int var0) {
        Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
        Char.getMyChar().cvx = var0;
        Char.getMyChar().statusMe = 3;
        Char.getMyChar().cp1 = 0;
    }

    public final void gameAC() {
        if (gameFU != 0 && !GameCanvas.gameAA) {
            cmx += NinjaUtil.gameAA();
            if (++gameFV > 20) {
                gameFU = 0;
                gameFV = 0;
            }
        } else if (cmx != gameAK || cmy != gameAL) {
            if (!gameFR) {

                if (SetAuto.dcvt) {
                    gameHD = gameAK - cmx << 4;
                    gameHE = gameAL - cmy << 4;
                } else {

                    gameHD = gameAK - cmx << 2;
                    gameHE = gameAL - cmy << 2;
                }
            } else {
                gameHD = gameAK - cmx << 1;
                gameHE = gameAL - cmy << 2;
            }

            gameHB += gameHD;
            cmx += gameHB >> 4;
            gameHB &= 15;
            gameHC += gameHE;
            cmy += gameHC >> 4;
            gameHC &= 15;
            if (cmx < 24) {
                cmx = 24;
            }

            if (cmx > gameHF) {
                cmx = gameHF;
            }

            if (cmy < 0) {
                cmy = 0;
            }

            if (cmy > gameHG) {
                cmy = gameHG;
            }
        }

        if ((gssx = cmx / TileMap.size - 1) < 0) {
            gssx = 0;
        }

        gameAN = cmy / TileMap.size;
        gssxe = gssx + gameGZ;
        gssye = gameAN + gameHA;
        if (gameAN < 0) {
            gameAN = 0;
        }

        if (gssye > TileMap.tmh - 1) {
            gssye = TileMap.tmh - 1;
        }

        if ((TileMap.gameAZ = (Char.getMyChar().cx - 2 * gW) / TileMap.size) < 0) {
            TileMap.gameAZ = 0;
        }

        if (TileMap.gameAZ + TileMap.gameBB > TileMap.tmw) {
            TileMap.gameAZ = TileMap.tmw - TileMap.gameBB;
        }

        if ((TileMap.gameBA = (Char.getMyChar().cy - 2 * gH) / TileMap.size) < 0) {
            TileMap.gameBA = 0;
        }

        if (TileMap.gameBA + TileMap.gameBC > TileMap.tmh) {
            TileMap.gameBA = TileMap.tmh - TileMap.gameBC;
        }

        gameBU.gameAC();
        gameBT.gameAC();
        ChatTextField var1;
        if ((var1 = ChatTextField.gameAA()).isShow) {
            var1.tfChat.gameAC();
            if (var1.tfChat.gameAI) {
                var1.tfChat.gameAI = false;
                var1.parentScreen.onChatFromMe(var1.tfChat.gameAD(), var1.to);
                var1.tfChat.gameAA("");
                var1.right.caption = mResources.CLOSE;
            }
        }

        TileMap.gameAB();
        TileMap.gameAE();
        GameCanvas.gameAF();
        int var6;
        if (GameCanvas.isGPRS) {
            MyVector var2 = new MyVector();
            long var4 = System.currentTimeMillis();

            for (var6 = 0; var6 < vCharInMap.size(); ++var6) {
                Char var3;
                (var3 = (Char) vCharInMap.elementAt(var6)).gameAB();
                if (var3.gameAU()) {
                    if (var3.isDirtyPostion && var4 - var3.lastUpdateTime > 10000L && var4 - this.gamePK > 10000L) {
                        var3.isDirtyPostion = false;
                        var3.lastUpdateTime = var4;
                        var2.addElement(var3);
                    }
                } else {
                    var3.lastUpdateTime = var4;
                    var3.isDirtyPostion = true;
                }
            }

            if (var2.size() > 0) {
                Service.gI().gameAA(var2);
                this.gamePK = var4;
            }
        } else {
            for (var6 = 0; var6 < vCharInMap.size(); ++var6) {
                ((Char) vCharInMap.elementAt(var6)).gameAB();
            }
        }

        Char.getMyChar().gameAB();
        if (Char.getMyChar().cHP <= 0 && TileMap.gameBF && !LockGame.gameAA) {
            TileMap.gameAG();
        }

        if (Char.getMyChar().statusMe == 1 && GameCanvas.gameTick % 100 == 0) {
            System.gc();
        }

        for (var6 = 0; var6 < vMob.size(); ++var6) {
            ((Mob) vMob.elementAt(var6)).gameAA();
        }

        for (var6 = 0; var6 < vNpc.size(); ++var6) {
            ((Npc) vNpc.elementAt(var6)).gameAB();
        }

        GameCanvas.gameAB().gameAO();

        int var7;
        int[] var10000;
        for (var7 = 0; var7 < 5; ++var7) {
            if (gameQN[var7] != -1) {
                var10000 = gameQN;
                var10000[var7] += Res.abs(gameQM[var7]);
                if (gameQN[var7] > 30) {
                    gameQN[var7] = -1;
                }

                var10000 = gameQJ;
                var10000[var7] += gameQL[var7];
                var10000 = gameQK;
                var10000[var7] += gameQM[var7];
            }
        }

        for (var7 = 0; var7 < gameHP.size(); ++var7) {
            Lanterns var8;
            Lanterns var13 = var8 = (Lanterns) gameHP.elementAt(var7);
            var13.y -= var8.dy;
            if (var8.yStart - var8.y > 150) {
                var8.isEnd = true;
            }

            if (((Lanterns) gameHP.elementAt(var7)).isEnd) {
                gameHP.removeElementAt(var7);
            }
        }

        for (var7 = 0; var7 < 2; ++var7) {
            if (gameQR[var7] != -1) {
                int var10002 = gameQR[var7]++;
                var10000 = gameQP;
                var10000[var7] += gameQT[var7] << 2;
                var10002 = gameQQ[var7]--;
                if (gameQR[var7] >= 6) {
                    gameQR[var7] = -1;
                } else {
                    gameQS[var7] = (gameQR[var7] >> 1) % 3;
                }
            }
        }

        if (gameBP != -1 && gameSZ != 0) {
            gameTB = 0 - gameSZ << 2;
            gameTA += gameTB;
            gameSZ += gameTA >> 4;
            gameTA &= 15;
        }

        GameCanvas.gameAG();

        for (var6 = 0; var6 < vItemMap.size(); ++var6) {
            ItemMap var9;
            if ((var9 = (ItemMap) vItemMap.elementAt(var6)).status == 2 && var9.x == var9.xEnd && var9.y == var9.yEnd) {
                vItemMap.removeElement(var9);
                if (Char.getMyChar().itemFocus != null && Char.getMyChar().itemFocus.equals(var9)) {
                    Char.getMyChar().itemFocus = null;
                }
            } else if (var9.status <= 0) {
                var9.status = (byte) (var9.status - 4);
                if (var9.status < -12) {
                    var9.y -= 12;
                    var9.status = 1;
                }
            } else {
                if (var9.vx == 0) {
                    var9.x = var9.xEnd;
                }

                if (var9.vy == 0) {
                    var9.y = var9.yEnd;
                }

                if (var9.x != var9.xEnd) {
                    var9.x += var9.vx;
                    if (var9.vx > 0 && var9.x > var9.xEnd || var9.vx < 0 && var9.x < var9.xEnd) {
                        var9.x = var9.xEnd;
                    }
                }

                if (var9.y != var9.yEnd) {
                    var9.y += var9.vy;
                    if (var9.vy > 0 && var9.y > var9.yEnd || var9.vy < 0 && var9.y < var9.yEnd) {
                        var9.y = var9.yEnd;
                    }
                }
            }

            if (var9.gameAK && System.currentTimeMillis() - var9.gameAL >= 10000L) {
                var9.gameAK = false;
            }
        }

        for (var6 = 0; var6 < vMobSoul.size(); ++var6) {
            ((MobSoul) vMobSoul.elementAt(var6)).gameAA();
        }

        if ((TileMap.tmw * TileMap.sizeMiniMap >= TileMap.wMiniMap || TileMap.tmh * TileMap.sizeMiniMap >= TileMap.hMiniMap) && System.currentTimeMillis() / 100L > 20L) {
            TileMap.gameAA();
        }

        for (var6 = Effect2.vRemoveEffect2.size() - 1; var6 >= 0; --var6) {
            Effect2.vEffect2.removeElement(Effect2.vRemoveEffect2.elementAt(var6));
            Effect2.vRemoveEffect2.removeElementAt(var6);
        }

        for (var6 = 0; var6 < Effect2.vEffect2.size(); ++var6) {
            ((Effect2) Effect2.vEffect2.elementAt(var6)).gameAA();
        }

        for (var6 = 0; var6 < Effect2.vEffect2Outside.size(); ++var6) {
            ((Effect2) Effect2.vEffect2Outside.elementAt(var6)).gameAA();
        }

        for (var6 = 0; var6 < Effect2.vAnimateEffect.size(); ++var6) {
            ((Effect2) Effect2.vAnimateEffect.elementAt(var6)).gameAA();
        }

        for (var6 = 0; var6 < Mob.vEggMonter.size(); ++var6) {
            EggMonters var5;
            EggMonters var10;
            if ((var5 = var10 = (EggMonters) Mob.vEggMonter.elementAt(var6)).gameAA()) {
                if (var5.status == 0) {
                    ++var5.vy;
                    var5.y += var5.vy;
                    ++var5.frame;
                    if (var5.frame > 3) {
                        var5.frame = 0;
                    }

                    if ((TileMap.gameAA(var5.x, var5.y) & 2) == 2) {
                        var5.status = 1;
                        var5.vy = 0;
                    }
                } else if (var5.status == 1) {
                    ++var5.frame;
                    if (var5.frame > 6) {
                        var5.frame = 6;
                        EggMonters.ownerEgg.status = 5;
                    }
                }
            }

            if (var10.frame == 6) {
                Mob.vEggMonter.removeElementAt(var6);
            }
        }

        SmallImage.gameAA();
        if (this.gameEH >= 0 && vCharInMap.size() > 0) {
            int var11;
            if ((var11 = Char.gameAD(this.gameEH)) >= 0 && var11 < vCharInMap.size()) {
                Char var12;
                if ((var12 = (Char) vCharInMap.elementAt(var11)) != null && Char.gameAA(var12) && !var12.isNhanban) {
                    Char.getMyChar().mobFocus = null;
                    Char.getMyChar().gameAY();
                    Char.getMyChar().itemFocus = null;
                    Char.getMyChar();
                    Char.gameHF = true;
                    Char.getMyChar().charFocus = var12;
                }
            } else {
                this.gameEH = -1;
                Char.getMyChar().charFocus = null;
            }
        } else {
            this.gameEH = -1;
        }

        Info.gameAA();
        InfoMe.gameAA();
        if (currentCharViewInfo != null && currentCharViewInfo.charID != Char.getMyChar().charID) {
            currentCharViewInfo.gameAB();
        }

        ++this.gamePL;
        if (this.gamePL > 3) {
            this.gamePL = 0;
        }

        if (gameHX) {
            gameBL = 40;
        } else {
            gameBL = 28;
        }

        EffectAuto.gameAB();
        EffectAuto.gameAC();
    }

    public final void gameAA(mGraphics var1) {
        if (Char.gameGL) {
            var1.gameAA(0);
            var1.gameAD(0, 0, GameCanvas.w, GameCanvas.h);
            mFont.tahoma_7b_yellow.gameAA(var1, mResources.gameFK, GameCanvas.hw, GameCanvas.hh + 20, 2);
            GameCanvas.gameAA(GameCanvas.hw, GameCanvas.hh, var1);
        } else {
            GameCanvas.gameAA(var1);
            var1.gameAA(-cmx, -cmy);

            int var2;
            for (var2 = 0; var2 < gameFK.size(); ++var2) {
                ((ItemTree) gameFK.elementAt(var2)).gameAA(var1);
            }

            TileMap.gameAA(var1);

            for (var2 = 0; var2 < gameFL.size(); ++var2) {
                ((ItemTree) gameFL.elementAt(var2)).gameAA(var1);
            }

            for (var2 = 0; var2 < vMob.size(); ++var2) {
                ((Mob) vMob.elementAt(var2)).gameAA(var1);
            }

            for (var2 = 0; var2 < Mob.vEggMonter.size(); ++var2) {
                EggMonters var3;
                if ((var3 = (EggMonters) Mob.vEggMonter.elementAt(var2)).gameAA()) {
                    var1.gameAA(gameNZ, 0, var3.frame << 5, 32, 32, 0, var3.x, var3.y, 33);
                }
            }

            for (var2 = 0; var2 < gameBJ.size(); ++var2) {
                BuNhin var4;
                BuNhin var12;
                if ((var4 = var12 = (BuNhin) gameBJ.elementAt(var2)).gameAA >= cmx && var4.gameAA <= cmx + gW && var4.gameAB >= cmy && var4.gameAB <= cmy + gH + 30) {
                    mFont.tahoma_7_yellow.gameAA(var1, var12.gameAC, var12.gameAA, var12.gameAB - 32, 2, mFont.tahoma_7);
                    SmallImage.gameAB(var1, 1180, var12.gameAA, var12.gameAB, 0, 33);
                    if (var12.gameAD) {
                        SmallImage.gameAB(var1, 288, var12.gameAA, var12.gameAB, 0, 33);
                        var12.gameAD = false;
                    }
                }
            }

            for (var2 = 0; var2 < vNpc.size(); ++var2) {
                ((Npc) vNpc.elementAt(var2)).gameAA(var1);
            }

            int var13;
            int var14;
            for (var13 = 0; var13 < TileMap.vGo.size(); ++var13) {
                Waypoint var5;
                if ((var5 = (Waypoint) TileMap.vGo.elementAt(var13)).minY != 0 && var5.maxY < TileMap.pxh - 24) {
                    if (var5.maxX <= TileMap.pxw / 2) {
                        if (!GameCanvas.isTouch) {
                            SmallImage.gameAB(var1, 1213, var5.maxX + 12 + gI().gamePL, var5.maxY - 12, 2, StaticObj.VCENTER_HCENTER);
                        } else {
                            SmallImage.gameAB(var1, 1213, var5.maxX + 12 + gI().gamePL, var5.maxY - 32, 2, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (var5.minX >= TileMap.pxw / 2) {
                        if (!GameCanvas.isTouch) {
                            SmallImage.gameAB(var1, 1213, var5.minX - 12 - gI().gamePL, var5.maxY - 12, 0, StaticObj.VCENTER_HCENTER);
                        } else {
                            SmallImage.gameAB(var1, 1213, var5.minX - 12 - gI().gamePL, var5.maxY - 32, 0, StaticObj.VCENTER_HCENTER);
                        }
                    }
                } else if (var5.maxY <= TileMap.pxh / 2) {
                    var14 = var5.minX + (var5.maxX - var5.minX) / 2;
                    var2 = var5.minY + (var5.maxY - var5.minY) / 2 + gI().gamePL;
                    if (GameCanvas.isTouch) {
                        var2 = var5.maxY + (var5.maxY - var5.minY) + gI().gamePL + 10;
                    }

                    SmallImage.gameAB(var1, 1213, var14, var2, 6, StaticObj.VCENTER_HCENTER);
                } else if (var5.minY >= TileMap.pxh / 2) {
                    SmallImage.gameAB(var1, 1213, var5.minX + (var5.maxX - var5.minX) / 2, var5.minY - 12 - gI().gamePL, 4, StaticObj.VCENTER_HCENTER);
                }
            }

            var1.gameAE(0, -200, GameCanvas.w - var1.gameAA(), 200 + GameCanvas.h - var1.gameAB());
            GameCanvas.gameAB().gameAB(var1);

            for (var2 = 0; var2 < vCharInMap.size(); ++var2) {
                Char var17 = null;

                try {
                    var17 = (Char) vCharInMap.elementAt(var2);
                } catch (Exception var10) {
                }

                if (var17 != null) {
                    if (TileMap.mapID == 111 && var2 > 19) {
                        var17.gameAC(var1);
                    } else {
                        var17.gameAA(var1);
                    }
                }
            }

            for (var2 = 0; var2 < vParty.size(); ++var2) {
                Party var18;
                if ((var18 = (Party) vParty.elementAt(var2)).c != null && var18.c != Char.getMyChar()) {
                    var18.c.gameAB(var1);
                }
            }

            mGraphics var20 = var1;

            for (var2 = 0; var2 < 5; ++var2) {
                if (gameQN[var2] != -1 && GameCanvas.gameAE(gameQJ[var2], gameQK[var2])) {
                    if (gameQO[var2] == 0) {
                        mFont.number_red.gameAA(var20, gameQI[var2], gameQJ[var2], gameQK[var2], 2);
                    } else if (gameQO[var2] == 1) {
                        mFont.number_yellow.gameAA(var20, gameQI[var2], gameQJ[var2], gameQK[var2], 2);
                    } else if (gameQO[var2] == 2) {
                        mFont.number_green.gameAA(var20, gameQI[var2], gameQJ[var2], gameQK[var2], 2);
                    } else if (gameQO[var2] == 3) {
                        mFont.tahoma_7b_yellow.gameAA(var20, gameQI[var2], gameQJ[var2], gameQK[var2], 2, mFont.tahoma_7b_blue);
                    } else if (gameQO[var2] == 8) {
                        mFont.tahoma_7b_white.gameAA(var20, gameQI[var2], gameQJ[var2], gameQK[var2], 2, mFont.tahoma_7b_blue);
                    } else if (gameQO[var2] == 4) {
                        SmallImage.gameAB(var20, 1062, gameQJ[var2], gameQK[var2], 0, 3);
                    } else if (gameQO[var2] == 5) {
                        mFont.number_orange.gameAA(var20, gameQI[var2], gameQJ[var2], gameQK[var2], 2);
                    } else if (gameQO[var2] == 6) {
                        mFont.tahoma_7_yellow.gameAA(var20, gameQI[var2], gameQJ[var2], gameQK[var2], 2, mFont.tahoma_7_red);
                    } else if (gameQO[var2] == 7) {
                        SmallImage.gameAB(var20, 655, gameQJ[var2], gameQK[var2], 0, 3);
                    }
                }
            }

            var20 = var1;

            for (var2 = 0; var2 < gameHP.size(); ++var2) {
                Lanterns var15 = (Lanterns) gameHP.elementAt(var2);
                if (GameCanvas.gameTick % 10 < 8) {
                    SmallImage.gameAB(var20, 1292, var15.x, var15.y, 0, 3);
                } else {
                    SmallImage.gameAB(var20, 1291, var15.x, var15.y, 0, 3);
                }
            }

            var20 = var1;

            for (var2 = 0; var2 < 2; ++var2) {
                if (gameQR[var2] != -1) {
                    if (gameQT[var2] == 1) {
                        var20.gameAA(gameQU[gameQS[var2]], gameQP[var2], gameQQ[var2], 3);
                    } else {
                        var20.gameAA(gameQU[gameQS[var2]], 0, 0, mGraphics.gameAA(gameQU[gameQS[var2]]), mGraphics.gameAB(gameQU[gameQS[var2]]), 2, gameQP[var2], gameQQ[var2], 3);
                    }
                }
            }

            Char.getMyChar().gameAA(var1);
            if (Char.getMyChar().isCaptcha) {
                for (var14 = 0; var14 < gI().gameUL.length; ++var14) {
                    if (gI().gameUL[var14] != -1) {
                        byte var16 = 0;
                        if (gI().gameUL[var14] == 0) {
                            var16 = 2;
                        } else if (gI().gameUL[var14] == 1) {
                            var16 = 6;
                        } else if (gI().gameUL[var14] == 2) {
                            var16 = 0;
                        }

                        SmallImage.gameAB(var1, 989, Char.getMyChar().cx + var14 * 10 - (gI().gameUL.length - 1) * 10 / 2, Char.getMyChar().cy - 40, var16, 3);
                    }
                }
            }

            byte var19;
            for (var2 = 0; var2 < vItemMap.size(); ++var2) {
                ItemMap var21;
                if ((var21 = (ItemMap) vItemMap.elementAt(var2)).imgCaptcha != null && var21.imgCaptcha.img != null) {
                    var19 = 0;
                    if (var21.status <= 0) {
                        var19 = var21.status;
                    }

                    var1.gameAA(var21.imgCaptcha.img, var21.x, var21.y + var19, 33);
                } else {
                    var19 = 0;
                    if (var21.status <= 0) {
                        var19 = var21.status;
                    }

                    SmallImage.gameAB(var1, var21.template.iconID, var21.x, var21.y + var19, 0, 33);
                    if (Char.getMyChar().itemFocus != null && Char.getMyChar().itemFocus.equals(var21) && var21.status != 2) {
                        SmallImage.gameAB(var1, 988, var21.x, var21.y - 20, 0, 3);
                    }
                }
            }

            for (var2 = 0; var2 < vMobSoul.size(); ++var2) {
                ((MobSoul) vMobSoul.elementAt(var2)).gameAA(var1);
            }

            TileMap.gameAC(var1);
            if (Code.gameAN > 0) {
                var1.gameAA(16711680);
                var1.gameAA(Code.gameAO - Code.gameAN, Code.gameAP - Code.gameAN, Code.gameAN << 1, Code.gameAN << 1);
            }

            if (Code.gameAM > 0) {
                var1.gameAA(65280);
                var1.gameAA(Char.getMyChar().cx - Code.gameAM, Char.getMyChar().cy - Code.gameAM, Code.gameAM << 1, Code.gameAM << 1);
            }

            for (var2 = 0; var2 < Effect2.vEffect2.size(); ++var2) {
                ((Effect2) Effect2.vEffect2.elementAt(var2)).gameAA(var1);
            }

            for (var2 = 0; var2 < gameFJ.size(); ++var2) {
                ((ItemTree) gameFJ.elementAt(var2)).gameAA(var1);
            }

            if (!GameCanvas.gameAA) {
                for (var2 = 0; var2 < Effect2.vAnimateEffect.size(); ++var2) {
                    ((Effect2) Effect2.vAnimateEffect.elementAt(var2)).gameAA(var1);
                }
            }

            int var22;
            try {
                if ((var19 = gameBE()) != -1) {
                    Npc var8 = null;

                    for (var22 = 0; var22 < vNpc.size(); ++var22) {
                        Npc var9;
                        if ((var9 = (Npc) vNpc.elementAt(var22)).template.npcTemplateId == var19) {
                            if (var8 == null) {
                                var8 = var9;
                            } else if (Res.abs(var9.cx - Char.getMyChar().cx) < Res.abs(var8.cx - Char.getMyChar().cx)) {
                                var8 = var9;
                            }
                        }
                    }

                    if (var8 != null && var8.statusMe != 15 && (var8.cx <= cmx || var8.cx >= cmx + gW || var8.cy <= cmy || var8.cy >= cmy + gH) && GameCanvas.gameTick % 10 >= 5) {
                        var22 = var8.cx - Char.getMyChar().cx;
                        var13 = var8.cy - Char.getMyChar().cy;
                        var14 = 0;
                        var2 = 0;
                        byte var24 = 0;
                        if (var22 > 0 && var13 >= 0) {
                            if (Res.abs(var22) >= Res.abs(var13)) {
                                var14 = gW - 10;
                                var2 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    var2 = gH / 2 + 10;
                                }

                                var24 = 0;
                            } else {
                                var14 = gW / 2;
                                var2 = gH - 10;
                                var24 = 5;
                            }
                        } else if (var22 >= 0 && var13 < 0) {
                            if (Res.abs(var22) >= Res.abs(var13)) {
                                var14 = gW - 10;
                                var2 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    var2 = gH / 2 + 10;
                                }

                                var24 = 0;
                            } else {
                                var14 = gW / 2;
                                var2 = 10;
                                var24 = 6;
                            }
                        }

                        if (var22 < 0 && var13 >= 0) {
                            if (Res.abs(var22) >= Res.abs(var13)) {
                                var14 = 10;
                                var2 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    var2 = gH / 2 + 10;
                                }

                                var24 = 3;
                            } else {
                                var14 = gW / 2;
                                var2 = gH - 10;
                                var24 = 5;
                            }
                        } else if (var22 <= 0 && var13 < 0) {
                            if (Res.abs(var22) >= Res.abs(var13)) {
                                var14 = 10;
                                var2 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    var2 = gH / 2 + 10;
                                }

                                var24 = 3;
                            } else {
                                var14 = gW / 2;
                                var2 = 10;
                                var24 = 6;
                            }
                        }

                        gameAB(var1);
                        SmallImage.gameAB(var1, 992, var14, var2, var24, StaticObj.VCENTER_HCENTER);
                    }
                }
            } catch (Exception var11) {
            }

            long var23;
            if (GameCanvas.isTouch) {
                gameAB(var1);
                this.gameCS();
                var14 = Char.getMyChar().cHP * gameRC / Char.getMyChar().cMaxHP;
                var2 = Char.getMyChar().cMP * gameRD / Char.getMyChar().cMaxMP;
                var22 = (int) (Char.getMyChar().autoUpHp * (long) gameRE / exps[Char.getMyChar().clevel]);
                if (var14 > gameRC) {
                    var14 = 0;
                }

                var1.gameAA(-10585344);
                var1.gameAD(0, gameRB - 10, gameRE, 3);
                var1.gameAA(-10427136);
                var1.gameAD(0, gameRB - 10, var22, 3);
                var1.gameAA(-9756672);
                var1.gameAD(0, gameRB - 10, gameRE, 1);
                var1.gameAD(0, gameRB - 7, gameRE, 1);

                for (var13 = 0; var13 < 10; ++var13) {
                    var1.gameAD(var13 * gameRE / 10 - 1, gameRB - 10, 1, 3);
                }

                var1.gameAA(-1769452);
                var1.gameAA(gameNG, gameRA - 1, gameRB, 0);
                var1.gameAD(gameRA, gameRB, var14, 9);
                var1.gameAA(-16755227);
                var1.gameAA(gameNG, gameRA - 28, gameRB + 13, 0);
                var1.gameAD(gameRA, gameRB + 16, var2, 7);
                var1.gameAA(gameNF, 0, gameRB - 7, 0);
                mFont.number_white.gameAA(var1, "" + Char.getMyChar().cHP, gameRA + gameRC / 2 - 30, gameRB + 1, 0);
                mFont.number_white.gameAA(var1, "" + Char.getMyChar().cMP, gameRA + gameRC / 2 - 30, gameRB + 15, 0);
                mFont.tahoma_8b.gameAA(var1, "" + Char.getMyChar().clevel, gameRA - 27, gameRB + 1, 2);
                if (Char.getMyChar().cExpDown > 0L) {
                    var23 = Char.getMyChar().cExpDown * 10000L / exps[Char.getMyChar().clevel];
                } else {
                    var23 = Char.getMyChar().autoUpHp * 10000L / exps[Char.getMyChar().clevel];
                }
                if (SetAuto.idmap) {
                    this.gameNV[0] = gameRB;
                    this.gameNW[0] = gameRA + 12;
                    if (GameCanvas.gameTick % 10 > 4) {
                        mFont.tahoma_7b_white.gameAA(var1, "CUONGNSO", gameRA + 90, gameRB, 0, mFont.tahoma_7);
                    } else {
                        mFont.tahoma_7b_yellow.gameAA(var1, "CUONGNSO", gameRA + 90, gameRB, 0, mFont.tahoma_7);
                    }

                    mFont.tahoma_7_yellow.gameAA(var1, Res.gameAB().get(11) + ":" + Res.gameAB().get(12) + ":" + Res.gameAB().get(13), gameRA + 97, gameRB + 12, 0, mFont.tahoma_7_red);
                }
                var2 = (int) (var23 % 100L);
                mFont.tahoma_7_white.gameAA(var1, (Char.getMyChar().cExpDown > 0L ? "-" + var23 / 100L : "" + var23 / 100L) + "." + (var2 < 10 ? "0".concat(String.valueOf(var2)) : String.valueOf(var2)) + "%", gameRA - 27, gameRB + 13, 2);
            }

            if (!Char.getMyChar().isCaptcha) {
                this.gameAG(var1);
                gameAB(var1);
                this.gameAF(var1);
                gameAB(var1);
                TileMap.gameAB(var1);
                var1.gameAA(-var1.gameAA(), -var1.gameAB());
                if (!GameCanvas.isTouch || GameCanvas.isTouch && !GameCanvas.gameAG) {
                    var1.gameAE(0, gameQV - 4, GameCanvas.w, 100);
                    var1.gameAA(3612190);
                    var1.gameAD(gameRA - 44, gameRB, 19, 19);
                    var1.gameAA(265220);
                    var1.gameAD(gameQX, gameQV + 35, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 33, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 30, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 28, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 26, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 12, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 24, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 18, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 16, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 2, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 4, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 6, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 14, gameQZ, 1);
                    var1.gameAA(12562018);
                    var1.gameAD(gameQX, gameQV + 5, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 17, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 34, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 29, gameQZ, 1);
                    var1.gameAA(14667167);
                    var1.gameAD(gameQX, gameQV + 3, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 15, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 27, gameQZ, 1);
                    var1.gameAA(3355443);
                    var1.gameAD(gameQX, gameQV + 7, gameQZ, 5);
                    var1.gameAD(gameQX, gameQV + 19, gameQZ, 5);
                    var1.gameAD(gameQX, gameQV + 31, gameQZ, 2);
                    var1.gameAA(12281361);
                    var1.gameAD(gameQX, gameQV + 25, gameQZ, 1);
                    var1.gameAD(gameQX, gameQV + 13, gameQZ, 1);
                    var1.gameAA(gameRG[0], 0, gameQV + 2, 0);
                    var1.gameAA(gameRG[1], 0 + gameQW, gameQV - 4, 24);
                    if ((var14 = Char.getMyChar().cHP * gameRC / Char.getMyChar().cMaxHP) > gameRC) {
                        var14 = 0;
                    }

                    var1.gameAA(7798784);
                    var1.gameAD(gameRA, gameRB, var14, 2);
                    var1.gameAA(13369344);
                    var1.gameAD(gameRA, gameRB + 1, var14, 4);
                    if ((var14 = Char.getMyChar().cMP * gameRC / Char.getMyChar().cMaxMP) > gameRC) {
                        var14 = 0;
                    }

                    var1.gameAA(4488);
                    var1.gameAD(gameRA, gameRB + 12, var14, 2);
                    var1.gameAA(4573);
                    var1.gameAD(gameRA, gameRB + 14, var14, gameRF - 2);
                    var2 = (int) (Char.getMyChar().autoUpHp * (long) gameRE / exps[Char.getMyChar().clevel]);
                    var1.gameAA(94373);
                    var1.gameAD(46, gameQV + 31, var2, 1);
                    var1.gameAA(65535);
                    var1.gameAD(46, gameQV + 32, var2, 1);
                    mFont.number_yellow.gameAA(var1, "" + Char.getMyChar().clevel, 28, gameQV + 9, 2);
                    if (Char.getMyChar().cExpDown > 0L) {
                        var23 = Char.getMyChar().cExpDown * 10000L / exps[Char.getMyChar().clevel];
                    } else {
                        var23 = Char.getMyChar().autoUpHp * 10000L / exps[Char.getMyChar().clevel];
                    }

                    var14 = (int) (var23 % 100L);
                    mFont.tahoma_7_white.gameAA(var1, (Char.getMyChar().cExpDown > 0L ? "-" + var23 / 100L : "" + var23 / 100L) + "." + (var14 < 10 ? "0".concat(String.valueOf(var14)) : String.valueOf(var14)) + "%", 24, gameQV + 23, 2);
                    mFont.number_green.gameAA(var1, "" + gameAS, gameQW - 11, gameQV + 6, 2);
                    mFont.number_green.gameAA(var1, "" + gameAR, gameQW - 11, gameQV + 18, 2);
                    mFont.number_white.gameAA(var1, "" + Char.getMyChar().cHP, gameRA + gameRC / 2, gameQV + 6, 2);
                    mFont.number_white.gameAA(var1, "" + Char.getMyChar().cMP, gameRA + gameRC / 2, gameQV + 18, 2);
                    if (Char.getMyChar().vSkillFight.size() > 0 && Char.getMyChar().myskill != null) {
                        var2 = gameQX - 28;
                        var13 = gameRB + 7;
                        Char.getMyChar().myskill.gameAA(var2, var13, var1);
                    }

                    var1.gameAA(9463099);
                    var1.gameAD(0, gameQV + 35, GameCanvas.w, 1);
                } else {
                    Paint.gameAA(var1);
                }

                if (GameCanvas.isTouch) {
                    gameKD = true;
                }

                gameAB(var1);
                this.gameAI(var1);
                gameAB(var1);
                var1.gameAE(0, 0, GameCanvas.w, GameCanvas.h);

                for (var2 = 0; var2 < Effect2.vEffect2Outside.size(); ++var2) {
                    ((Effect2) Effect2.vEffect2Outside.elementAt(var2)).gameAA(var1);
                }

                gameAB(var1);
                if (gameDL) {
                    if (gameBP == 0) {
                        this.gameAA(var1, mResources.gameGN);
                    }

                    this.gameAN(var1);
                    gameBE(var1);
                    if (gameBP == 3) {
                        label777:
                        {
                            gameAB(var1);
                            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
                            if (gameHQ == 1) {
                                var1.gameAA(Paint.COLORDARK);
                                var1.gameAD(popupX + 7, popupY + 32, gameGC - 14, gameGD - 40);
                                var1.gameAA(16777215);
                            } else {
                                var1.gameAA(10249521);
                            }

                            var1.gameAC(popupX + 7, popupY + 32, gameGC - 14, gameGD - 40);
                            gameAA(var1, mResources.gameGN[gameBP], true);
                            gameGA = popupX + 17;
                            gameGB = popupY + 34;
                            gameBU.gameAA(gameBO, 12, popupX, popupY + 35, gameGC, gameGD - 44, true, 1);
                            gameBU.gameAA(var1);
                            String var25;
                            if (gameNU == 0) {
                                gameBO = 19;
                                var14 = gameGB;
                                if (currentCharViewInfo == null) {
                                    break label777;
                                }

                                mFont.tahoma_7b_white.gameAA(var1, mResources.gameMT[0] + currentCharViewInfo.cName, gameGA, var14, 0);
                                var25 = mResources.gameMT[1] + currentCharViewInfo.cPk;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[2] + currentCharViewInfo.clevel;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[3] + currentCharViewInfo.nClass.name;
                                var14 += 12;
                                mFont.tahoma_7_blue1.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[4] + mResources.gamePO[currentCharViewInfo.gameAF()];
                                var14 += 12;
                                mFont.tahoma_7_blue1.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[5] + currentCharViewInfo.cHP + "/" + currentCharViewInfo.cMaxHP;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[6] + currentCharViewInfo.cMP + "/" + currentCharViewInfo.cMaxMP;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[7] + currentCharViewInfo.gameAG();
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[8] + (currentCharViewInfo.cdame - currentCharViewInfo.cdame / 10) + "-" + currentCharViewInfo.cdame;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[9] + currentCharViewInfo.cResFire;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[10] + currentCharViewInfo.cResIce;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[11] + currentCharViewInfo.cResWind;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[12] + currentCharViewInfo.cdameDown;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[13] + currentCharViewInfo.cExactly;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[14] + currentCharViewInfo.cMiss;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[15] + currentCharViewInfo.cFatal;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[16] + currentCharViewInfo.cReactDame;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[17] + currentCharViewInfo.sysUp;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMT[18] + currentCharViewInfo.sysDown;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                            } else if (gameNU == 1) {
                                gameBO = 20;
                                var14 = gameGB;
                                if (currentCharViewInfo == null) {
                                    break label777;
                                }

                                mFont.tahoma_7b_white.gameAA(var1, mResources.gameMW[15] + (currentCharViewInfo.cClanName.equals("") ? mResources.gameKU : currentCharViewInfo.cClanName), gameGA, var14, 0);
                                var25 = mResources.gameMW[0] + currentCharViewInfo.pointUydanh;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[11] + currentCharViewInfo.countFinishDay + "/20";
                                var14 += 12;
                                mFont.tahoma_7_blue1.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[12] + currentCharViewInfo.countLoopBoos + mResources.gameMU;
                                var14 += 12;
                                mFont.tahoma_7_blue1.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[16] + currentCharViewInfo.countPB + mResources.gameMU;
                                var14 += 12;
                                mFont.tahoma_7_blue1.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[13] + currentCharViewInfo.limitTiemnangso;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[14] + currentCharViewInfo.limitKynangso;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[18] + currentCharViewInfo.limitPhongLoi + mResources.gameMU;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[19] + currentCharViewInfo.limitBangHoa + mResources.gameMU;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[17] + currentCharViewInfo.pointTinhTu;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[1] + currentCharViewInfo.pointVukhi;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[2] + currentCharViewInfo.pointLien;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[3] + currentCharViewInfo.pointNhan;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[4] + currentCharViewInfo.pointNgocboi;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[5] + currentCharViewInfo.pointPhu;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[6] + currentCharViewInfo.pointNon;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[7] + currentCharViewInfo.pointAo;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[8] + currentCharViewInfo.pointGangtay;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[9] + currentCharViewInfo.pointQuan;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                                var25 = mResources.gameMW[10] + currentCharViewInfo.pointGiay;
                                var14 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var25, gameGA, var14, 0);
                            }

                            if (gameHQ == 1 && indexRow >= 0) {
                                SmallImage.gameAB(var1, 942, gameGA - 8, gameGB + 2 + indexRow * 12, 0, StaticObj.gameAB);
                            }
                        }
                    }

                    this.gameAJ(var1);
                    this.gameAK(var1);
                } else if (gameAZ()) {
                    if (gameKE) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameHI, gameCO);
                        } else if (gameBP == 1) {
                            gameAA(var1, mResources.gameHI, gameCR);
                        } else if (gameBP == 2) {
                            gameAA(var1, mResources.gameHI, gameCS);
                        } else if (gameBP == 3) {
                            gameAA(var1, mResources.gameHI, gameCQ);
                        }
                    }

                    if (gameKG) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameBV);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGP);
                        }
                    }

                    if (gameKH) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameBW);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGP);
                        }
                    }

                    if (gameKI) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameBX);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGQ);
                        }
                    }

                    if (gameKJ) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameBY);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGQ);
                        }
                    }

                    if (gameKK) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameBZ);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGR);
                        }
                    }

                    if (gameKL) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameCA);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGR);
                        }
                    }

                    if (gameKM) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameCB);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGS);
                        }
                    }

                    if (gameKN) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGS, gameCC);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGS);
                        }
                    }

                    if (gameKO) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameCD);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGT);
                        }
                    }

                    if (gameKP) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGO, gameCE);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGT);
                        }
                    }

                    if (gameKQ) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGU, gameCF);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGU);
                        }
                    }

                    if (gameKR) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGV, gameCG);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGV);
                        }
                    }

                    if (gameKS) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGW, gameCH);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGW);
                        }
                    }

                    if (gameKT) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGX, gameCI);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGX);
                        }
                    }

                    if (gameKU) {
                        if (gameBP == 0) {
                            gameAA(var1, mResources.gameGY, gameCJ);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameGY);
                        }
                    }

                    if (gameKF) {
                        gameAA(var1, mResources.gameHJ, gameCP);
                    }

                    this.gameAO(var1);
                    this.gameAP(var1);
                    this.gameAQ(var1);
                    this.gameAR(var1);
                    this.gameAS(var1);
                    if (gameKZ) {
                        if (gameBP == 0) {
                            this.gameAB(var1, mResources.gameHD);
                        } else if (gameBP == 1) {
                            this.gameAA(var1, mResources.gameHD);
                        }
                    }

                    this.gameAT(var1);
                    gameBJ(var1);
                    this.gameAU(var1);
                    this.gameAV(var1);
                    this.gameAW(var1);
                    this.gameAX(var1);
                    this.gameAZ(var1);
                    this.gameBA(var1);
                    this.gameBB(var1);
                    this.gameAY(var1);
                    this.gameBR(var1);
                    this.gameBS(var1);
                    this.gameBV(var1);
                    this.gameBT(var1);
                    this.gameBU(var1);
                    this.gameBC(var1);
                    this.gameBD(var1);
                    this.thowBD(var1);

                } else if (gameMG) {
                    this.gameBF(var1);
                } else if (gameAQ) {
                    this.gameGR.gameAA(var1);
                }

                gameAC(var1);
                this.gameBL(var1);
                this.gameAE(var1);
                gameBI(var1);
                gameBH(var1);
                gameBK(var1);
                gameAD(var1);
                this.gameAL(var1);
                this.gameBM(var1);
                gameBO(var1);
                gameAB(var1);
                if (GameCanvas.isTouch && GameCanvas.w >= 320) {
                    if (super.left != null && super.left != this.gameFT) {
                        super.left.x = GameCanvas.w / 2 - 160;
                        super.left.y = GameCanvas.h - 26;
                    }

                    if (super.center != null) {
                        super.center.x = GameCanvas.w / 2 - 35;
                        super.center.y = GameCanvas.h - 26;
                    }

                    if (super.right != null && super.right != this.gameHM) {
                        super.right.x = GameCanvas.w / 2 + 88;
                        super.right.y = GameCanvas.h - 26;
                    }
                }
            }

            super.gameAA(var1);
            if (GameCanvas.isTouch && GameCanvas.gameAG) {
                this.gameAH(var1);
                gameKD = true;
            }

            gameAB(var1);
            this.gameBG(var1);
            gameAB(var1);
            this.gameBP(var1);
            gameAB(var1);
            Info.gameAA(var1);
            gameAB(var1);
            ChatTextField.gameAA().gameAA(var1);
            gameAB(var1);
            InfoMe.gameAA(var1);
        }
    }

    private static void gameAC(mGraphics var0) {
        if (gameDN) {
            gameAB(var0);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            if (gameHQ == 1) {
                var0.gameAA(Paint.COLORDARK);
                var0.gameAD(popupX + 7, popupY + 32, gameGC - 14, gameGD - 55);
                var0.gameAA(16777215);
            } else {
                var0.gameAA(10249521);
            }

            var0.gameAC(popupX + 7, popupY + 32, gameGC - 14, gameGD - 55);
            gameAA(var0, mResources.gameSW[7], false);
            gameGA = popupX + 17;
            gameGB = popupY + 45;
            gameBO = 36;
            gameBU.gameAA(gameBO, 30, popupX, popupY + 39, gameGC, gameGD - 63, true, 1);
            gameBU.gameAA(var0);
            int var1 = gameGB;
            gameAA(var0, mResources.gameWE[0], Char.DungHp, Char.aHpValue + "%", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[1], Char.DungMp, Char.aMpValue + "%", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[2], Char.DungFood, String.valueOf(Char.CapFood), gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[3], Char.DungHoTro, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[4], Char.KhienMana, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[5], Char.DotQuai, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[6], Char.DungPhanThan, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[7], Char.NhatYen, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[8], Char.NhatHpMp, "LV: " + Char.CapHpMp, gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[9], Char.NhatDa, "LV: " + Char.CapNhatDa, gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[10], Char.LuyenDa, "LV: " + Char.LuyenDaMax, gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[11], Char.NhatTrangBi, "LV: " + Char.CapTrangBi, gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[12], Char.NhatTbLa, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[13], Char.NhatVpNV, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[14], Char.NhatVpSk, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[15], Char.NhatAll, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[16], Char.NhatSvc, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[17], Char.KhongNhat, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[18], Char.LuyenTTT, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[19], Char.LuyenTTC, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[20], Char.ReMap, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[21], Char.TsMapTrong, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[22], Char.AutoMuaFood, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[23], Char.DieHetMp, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[24], Char.ReConnect, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[25], Char.ChuyenMapHetQuai, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[26], Char.SanTaTl, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[27], Char.DanhQuai, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[28], Char.DanhTA, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[29], Char.DanhTL, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[30], Char.CongTN, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[31], Char.CongKN, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[32], Char.DanhNhom, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[33], Char.NePk, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[34], Char.DungCoLenh, "", gameGA, var1);
            var1 += 30;
            gameAA(var0, mResources.gameWE[35], Char.MuaCoLenh, "", gameGA, var1);
            if (gameHQ == 1 && indexRow >= 0 && !GameCanvas.isTouch) {
                SmallImage.gameAB(var0, 942, gameGA - 8, gameGB + 2 + indexRow * 30, 0, StaticObj.gameAB);
            }

            gameAB(var0);
            mFont.tahoma_7_green.gameAA(var0, GameCanvas.isTouch ? mResources.gameWG : mResources.gameWF, popupX + gameGC / 2, popupY + gameGD - 17, 2);
        }

    }

    private static void gameAA(mGraphics var0, String var1, boolean var2, String var3, int var4, int var5) {
        var0.gameAA(16777215);
        var0.gameAD(var4, var5, 12, 12);
        if (var2) {
            var0.gameAA(9650442);
            var0.gameAB(var4 + 2, var5 + 2, var4 + 2 + 7, var5 + 2 + 7);
            var0.gameAB(var4 + 2, var5 + 2 + 7, var4 + 2 + 7, var5 + 2);
        }

        mFont var6;
        (var6 = var2 ? mFont.tahoma_7_white : mFont.tahoma_7_grey).gameAA(var0, var1, var4 + 18, var5, 0);
        if (!var3.equals("")) {
            var0.gameAA(Paint.COLORLIGHT);
            var0.gameAD(var4 + 115, var5 - 3, 30, 20);
            var0.gameAA(var2 ? 16777215 : 0);
            var0.gameAC(var4 + 115, var5 - 3, 30, 20);
            var6.gameAA(var0, var3, var4 + 133, var5 + 2, 2);
        }

    }

    private static void gameAD(mGraphics var0) {
        if (gameKB) {
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, mResources.gameEK, false);
            gameGA = popupX + 5;
            gameGB = popupY + 40;
            if (vList.size() == 0) {
                mFont.tahoma_7_white.gameAA(var0, mResources.gameST, popupX + gameGC / 2, popupY + 40, 2);
                return;
            }

            var0.gameAA(-16770791);
            var0.gameAD(gameGA - 2, gameGB - 2, gameGC - 6, gameBL * 5 + 8);
            gameAB(var0);
            gameBU.gameAA(vList.size(), gameBL, gameGA, gameGB, gameGC - 3, gameBL * 5 + 4, true, 1);
            gameBU.gameAA(var0, gameGA, gameGB, gameGC - 3, gameBL * 5 + 6);
            gameBO = vList.size();

            for (int var1 = 0; var1 < vList.size(); ++var1) {
                DunItem var2 = null;

                try {
                    var2 = (DunItem) vList.elementAt(var1);
                } catch (Exception var3) {
                }

                if (var2 != null) {
                    if (indexRow == var1) {
                        var0.gameAA(Paint.COLORLIGHT);
                        var0.gameAD(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(16777215);
                        var0.gameAC(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                    } else {
                        var0.gameAA(Paint.COLORBACKGROUND);
                        var0.gameAD(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(13932896);
                        var0.gameAC(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                    }

                    mFont.tahoma_7_yellow.gameAA(var0, var2.name1, gameGA + (gameGC - 10) / 2 - gameGC / 4, gameGB + var1 * gameBL + gameBL / 2 - 6, 2);
                    mFont.tahoma_7b_red.gameAA(var0, " vs ", gameGA + (gameGC - 10) / 2, gameGB + var1 * gameBL + gameBL / 2 - 6, 2);
                    mFont.tahoma_7_yellow.gameAA(var0, var2.name2, gameGA + (gameGC - 10) / 2 + gameGC / 4, gameGB + var1 * gameBL + gameBL / 2 - 6, 2);
                }
            }

            gameAM(var0);
        }

    }

    private void gameAE(mGraphics var1) {
        if (gameMF) {
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            gameAA(var1, mResources.gameEK, false);
            gameGA = popupX + 5;
            gameGB = popupY + 40;
            if (vCharInMap.size() == 0) {
                mFont.tahoma_7_white.gameAA(var1, mResources.gameQL, popupX + gameGC / 2, popupY + 40, 2);
                return;
            }

            var1.gameAA(-16770791);
            var1.gameAD(gameGA - 2, gameGB - 2, gameGC - 6, gameBL * 5 + 8);
            gameAB(var1);
            gameBU.gameAA(vCharInMap.size(), gameBL, gameGA, gameGB, gameGC - 3, gameBL * 5 + 4, true, 1);
            gameBU.gameAA(var1, gameGA, gameGB, gameGC - 3, gameBL * 5 + 6);
            gameBO = vCharInMap.size();

            for (int var2 = 0; var2 < vCharInMap.size(); ++var2) {
                Char var3 = null;

                try {
                    if ((var3 = (Char) vCharInMap.elementAt(var2)).isNhanban) {
                        continue;
                    }
                } catch (Exception var4) {
                }

                if (var3 != null) {
                    if (indexRow == var2) {
                        var1.gameAA(Paint.COLORLIGHT);
                        var1.gameAD(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                        var1.gameAA(16777215);
                        var1.gameAC(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                    } else {
                        var1.gameAA(Paint.COLORBACKGROUND);
                        var1.gameAD(gameGA + 2, gameGB + var2 * gameBL + 2, gameGC - 15, gameBL - 4);
                        var1.gameAA(13932896);
                        var1.gameAC(gameGA + 2, gameGB + var2 * gameBL + 2, gameGC - 15, gameBL - 4);
                    }

                    SmallImage.gameAB(var1, 647, gameGA + 12, gameGB + var2 * gameBL + gameBL / 2, 0, 3);
                    if (this.gameEH > 0 && this.gameEH == var3.charID) {
                        mFont.tahoma_7_yellow.gameAA(var1, var3.cName + " - " + mResources.gameFC + ": " + var3.clevel, gameGA + 22, gameGB + var2 * gameBL + gameBL / 2 - 6, 0);
                    } else if (var3.statusMe == 14) {
                        mFont.tahoma_7_grey.gameAA(var1, var3.cName + " - " + mResources.gameFC + ": " + var3.clevel, gameGA + 22, gameGB + var2 * gameBL + gameBL / 2 - 6, 0);
                    } else {
                        mFont.tahoma_7_green.gameAA(var1, var3.cName + " - " + mResources.gameFC + ": " + var3.clevel, gameGA + 22, gameGB + var2 * gameBL + gameBL / 2 - 6, 0);
                    }
                }
            }

            gameAM(var1);
        }

    }

    private void gameAF(mGraphics var1) {
        try {
            int var2 = (int) (System.currentTimeMillis() / 1000L);
            int var3 = 5;
            if (GameCanvas.isTouch && GameCanvas.gameAG) {
                var3 = 45 + Info.hI;
            }

            if (GameCanvas.gameAH && Char.getMyChar().vSkillFight.size() > 4) {
                var3 += 25;
            }

            gameAB(var1);
            if (!GameCanvas.gameAI) {
                int var4;
                for (int var5 = 0; var5 < Char.getMyChar().vEff.size(); ++var5) {
                    Effect var6 = (Effect) Char.getMyChar().vEff.elementAt(var5);
                    SmallImage.gameAB(var1, var6.template.iconId, GameCanvas.w - 13 - (var5 * 13 << 1), var3 + 14, 0, 33);
                    var4 = var2 - var6.timeStart;
                    int var7 = var6.timeLenght - (var2 - var6.timeStart);
                    var4 = var6.timeLenght - var4;
                    if (var7 >= 0) {
                        mFont.tahoma_7_white.gameAA(var1, NinjaUtil.gameAB(var4), GameCanvas.w - 13 - (var5 * 13 << 1), var3 + 15, 2, mFont.tahoma_7);
                    }
                }

                var4 = this.gameFB - (var2 - this.gameFC);
                if (Char.getMyChar().vEff.size() > 0) {
                    var3 += 27;
                }

                if (var4 > 0) {
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameEL + ": " + NinjaUtil.gameAB(var4), GameCanvas.w - 2, var3, 1, mFont.tahoma_7);
                    var3 += 12;
                }

                if (TileMap.gameAN == 1) {
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameEM + ": " + Char.getMyChar().countKill, GameCanvas.w - 2, var3, 1, mFont.tahoma_7);
                    var3 += 12;
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameEN + ": " + Char.getMyChar().countKillMax, GameCanvas.w - 2, var3, 1, mFont.tahoma_7);
                    var3 += 12;
                } else if (TileMap.gameAN != 2 && TileMap.mapID != 114 && TileMap.mapID != 115 && TileMap.mapID != 116) {
                    if (TileMap.gameAN == 3) {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameEO + ": " + Char.pointChienTruong, GameCanvas.w - 2, var3, 1, mFont.tahoma_7);
                        var3 += 12;
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameMV[Char.gameBC()], GameCanvas.w - 2, var3, 1, mFont.tahoma_7);
                        var3 += 12;
                    }
                } else {
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameEO + ": " + Char.pointPB, GameCanvas.w - 2, var3, 1, mFont.tahoma_7);
                    var3 += 12;
                }
            }

            if (vParty.size() > 0 && GameCanvas.w > 128 && !gameAZ()) {
                var3 -= 18;

                for (var2 = 0; var2 < vParty.size(); ++var2) {
                    Party var9;
                    if ((var9 = (Party) vParty.elementAt(var2)).c != null) {
                        String var10 = var9.name + "(" + var9.c.clevel + ")";
                        int var11 = GameCanvas.w - 14;
                        var3 += 18;
                        mFont.tahoma_7_white.gameAA(var1, var10, var11, var3, 1, mFont.tahoma_7);
                        var9.c.gameAC(var1, GameCanvas.w - 41, var3 + 12);
                        SmallImage.gameAB(var1, var9.iconId, GameCanvas.w - 7, var3 + 9, 0, 3);
                    } else {
                        var3 += 16;
                        mFont.tahoma_7_green.gameAA(var1, var9.name, GameCanvas.w - 14, var3 + 5, 1, mFont.tahoma_7);
                        SmallImage.gameAB(var1, var9.iconId, GameCanvas.w - 7, var3 + 11, 0, 3);
                    }
                }

            }
        } catch (Exception var8) {
        }
    }

    public static void gameAB(mGraphics var0) {
        var0.gameAA(-var0.gameAA(), -var0.gameAB());
        var0.gameAE(0, -200, GameCanvas.w, 200 + GameCanvas.h);
    }

    private void gameAG(mGraphics var1) {
        try {
            if (!GameCanvas.menu.showMenu && !InfoDlg.gameAE && !gameDF()) {
                int var2 = -7;
                int var3 = 3;
                if ((!GameCanvas.isTouch || GameCanvas.isTouch && !GameCanvas.gameAG) && gameKD) {
                    var3 += 30;
                }

                if (GameCanvas.isTouch) {
                    var2 = 38 + Info.hI;
                    if (GameCanvas.gameAH) {
                        var2 += 35;
                    }
                }

                var1.gameAA(-var1.gameAA(), -var1.gameAB());
                int var10;
                String var11;
                if (GameCanvas.gameAI) {
                    int var5 = (int) (System.currentTimeMillis() / 1000L);

                    for (int var6 = 0; var6 < Char.getMyChar().vEff.size(); ++var6) {
                        Effect var4 = (Effect) Char.getMyChar().vEff.elementAt(var6);
                        SmallImage.gameAB(var1, var4.template.iconId, var3 + 13 + (var6 * 13 << 1), var2 + 27, 0, 33);
                        int var7 = var5 - var4.timeStart;
                        int var8 = var4.timeLenght - (var5 - var4.timeStart);
                        var10 = var4.timeLenght - var7;
                        if (var8 >= 0) {
                            mFont.tahoma_7_white.gameAA(var1, NinjaUtil.gameAB(var10), var3 + 13 + (var6 * 13 << 1), var2 + 28, 2, mFont.tahoma_7_grey);
                        }
                    }

                    var10 = this.gameFB - (var5 - this.gameFC);
                    if (Char.getMyChar().vEff.size() > 0) {
                        var2 += 27;
                    }

                    if (var10 > 0) {
                        var11 = mResources.gameEL + ": " + NinjaUtil.gameAB(var10);
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, var11, var3, var2, 0, mFont.tahoma_7_grey);
                    }
                }

                String var12;
                if (Char.getMyChar().clevel <= 20) {
                    if (Char.getMyChar().pPoint > 0) {
                        var12 = "+" + Char.getMyChar().pPoint + " " + mResources.gameEH;
                        var2 += 12;
                        mFont.tahoma_7_yellow.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                    }

                    if (Char.getMyChar().sPoint > 0) {
                        var12 = "+" + Char.getMyChar().sPoint + " " + mResources.gameNH;
                        var2 += 12;
                        mFont.tahoma_7_yellow.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                    }
                }

                if (Code.gameAB != null) {
                    var2 += 12;
                    (GameCanvas.gameTick % 10 > 7 ? mFont.tahoma_7_red : mFont.tahoma_7_yellow).gameAA(var1, Code.gameAB.toString(), var3, var2, 0, mFont.tahoma_7);

                    int avar5 = Char.getMyChar().yen - Code.gameAB.gameAG;
                    int avar21 = (int) ((System.currentTimeMillis() - Code.gameAB.gameAI) / 1000L);
                    long avar12;
                    float avar24 = (float) ((avar12 = Char.getMyChar().cEXP - Code.gameAB.gameAH) * 10000L / exps[Char.getMyChar().clevel]) / 100.0F;
                    int avar8 = (int) ((System.currentTimeMillis() - Code.gameAB.gameAI) / 1000L);
                    long avar16 = avar12 * 3600L / (long) avar8;
                    if (SetAuto.hienexp) {
                        mFont.tahoma_7_blue1.gameAA(var1, "up " + avar5 + " yên trong " + NinjaUtil.gameAB(avar21) + " 1h được " + avar5 / avar21 * 3600, var3, var2 + 100, 0, mFont.tahoma_7);
                        mFont.tahoma_7_blue1.gameAA(var1, "up " + avar24 + "% trong " + NinjaUtil.gameAB(avar8) + " 1h được " + (float) (avar16 * 10000L / exps[Char.getMyChar().clevel]) / 100.0F + "%", var3, var2 + 112, 0, mFont.tahoma_7);
                    }
                }
                var2 += 12;
                mFont.tahoma_7_yellow.gameAA(var1, "HS lượng: " + (Code.HoiSinhLuong ? "Bật" : "Tắt"), var3, var2, 0, mFont.tahoma_7);

                var2 += 12;
                mFont.tahoma_7_yellow.gameAA(var1, "Lọc Đồ: " + (Code.gameCR ? "Bật" : "Tắt"), var3, var2, 0, mFont.tahoma_7);

                if (SetAuto.vbl) {
                    var2 += 12;
                    mFont.tahoma_7_yellow.gameAA(var1, "VBL: " + SetAuto.tenVBL, var3, var2, 0, mFont.tahoma_7);
                }
                if (Code.gameAR) {
                    var2 += 12;
                    mFont.tahoma_7_yellow.gameAA(var1, "Vị trí: " + (Code.gameAS + 1) + "/" + Code.gameAT.size(), var3, var2, 0, mFont.tahoma_7);
                }

                if (Code.gameBD > 0L) {
                    var2 += 12;
                    mFont.tahoma_7_yellow.gameAA(var1, "Up Còn: " + NinjaUtil.gameAB((int) (Code.gameBD / 1000L)), var3, var2, 0, mFont.tahoma_7);
                }

                if (ChatManager.gameAD().waitList.size() > 0) {
                    this.gameNV[0] = var3;
                    this.gameNW[0] = var2 + 12;
                    var12 = "+" + ChatManager.gameAD().waitList.size() + " " + mResources.gameEC;
                    if (GameCanvas.gameTick % 10 > 4) {
                        var2 += 12;
                        mFont.tahoma_7_red.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                    } else {
                        var2 += 12;
                        mFont.tahoma_7_yellow.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                    }
                }

                if (ChatManager.isMessageClan || ChatManager.isMessagePt) {
                    var12 = "";
                    this.gameNV[1] = var3;
                    this.gameNW[1] = var2 + 12;
                    if (ChatManager.isMessageClan && ChatManager.isMessagePt) {
                        var12 = mResources.gameED[0];
                    } else if (ChatManager.isMessageClan) {
                        var12 = mResources.gameED[1];
                    } else if (ChatManager.isMessagePt) {
                        var12 = mResources.gameED[2];
                    }

                    if (GameCanvas.gameTick % 10 > 7) {
                        var2 += 12;
                        mFont.tahoma_7_red.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                    } else {
                        var2 += 12;
                        mFont.tahoma_7_yellow.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                    }
                }

                if (TileMap.gameAN != 3) {
                    if (Char.getMyChar().isHuman) {
                        if (Char.getMyChar().taskMaint != null) {
                            var12 = Char.getMyChar().taskMaint.subNames[Char.getMyChar().taskMaint.index];

                            for (var10 = 0; var12 == null; var12 = Char.getMyChar().taskMaint.subNames[Char.getMyChar().taskMaint.index - var10]) {
                                ++var10;
                            }

                            if (Char.getMyChar().taskMaint.counts[Char.getMyChar().taskMaint.index] != -1) {
                                var12 = var12 + " " + Char.getMyChar().taskMaint.count + "/" + Char.getMyChar().taskMaint.counts[Char.getMyChar().taskMaint.index];
                            }

                            if (GameCanvas.gameAV > 0 && GameCanvas.gameTick % 10 > 4) {
                                var2 += 12;
                                mFont.tahoma_7_yellow.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                            } else {
                                var2 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var12, var3, var2, 0, mFont.tahoma_7);
                            }
                        } else {
                            byte var13;
                            if ((var13 = gameBD()) >= 0) {
                                var11 = mResources.gameMD + " " + TileMap.mapNames[var13];
                                var2 += 12;
                                mFont.tahoma_7_white.gameAA(var1, var11, var3, var2, 0, mFont.tahoma_7);
                            }
                        }
                    }
                } else if (Char.getMyChar().charFocus != null) {
                    if (Char.getMyChar().charFocus.cTypePk == 4) {
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameME, var3, var2, 0, mFont.tahoma_7);
                    } else if (Char.getMyChar().charFocus.cTypePk == 5) {
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameMF, var3, var2, 0, mFont.tahoma_7);
                    }
                } else if (Char.getMyChar().mobFocus != null) {
                    if (Char.getMyChar().mobFocus.templateId == 96) {
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameMF, var3, var2, 0, mFont.tahoma_7);
                    } else if (Char.getMyChar().mobFocus.templateId == 97) {
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameME, var3, var2, 0, mFont.tahoma_7);
                    } else {
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameMG, var3, var2, 0, mFont.tahoma_7);
                    }
                }

                if (Char.getMyChar().mobFocus != null) {
                    MobTemplate var14 = Char.getMyChar().mobFocus.getTemplate();
                    var11 = var14.name + " lv" + Char.getMyChar().mobFocus.level;
                    if (Char.getMyChar().mobFocus.templateId != 0 && Char.getMyChar().mobFocus.templateId != 142 && Char.getMyChar().mobFocus.templateId != 143) {
                        var11 = "Id: " + var14.mobTemplateId + " " + var11 + ": " + Char.getMyChar().mobFocus.hp + "/" + Char.getMyChar().mobFocus.maxHp;
                    }

                    var1.gameAA(Char.getMyChar().mobFocus.gameAE());
                    var2 += 12;
                    var1.gameAD(var3, var2 + 3, 5, 5);
                    var1.gameAA(0);
                    var1.gameAC(var3, var2 + 3, 5, 5);
                    mFont.tahoma_7_white.gameAA(var1, var11, var3 + 12, var2, 0, mFont.tahoma_7);
                } else if (Char.getMyChar().npcFocus != null) {
                    var2 += 12;
                    mFont.tahoma_7_yellow.gameAA(var1, Char.getMyChar().npcFocus.template.name, var3, var2, 0, mFont.tahoma_7);
                } else if (Char.getMyChar().charFocus != null) {
                    var1.gameAA(Char.getMyChar().charFocus.gameAW());
                    var2 += 12;
                    var1.gameAD(var3, var2 + 3, 5, 5);
                    var1.gameAA(0);
                    var1.gameAC(var3, var2 + 3, 5, 5);
                    mFont.tahoma_7_white.gameAA(var1, Char.getMyChar().charFocus.cName + " lv" + Char.getMyChar().charFocus.clevel + ": " + Char.getMyChar().charFocus.cHP + "/" + Char.getMyChar().charFocus.cMaxHP, var3 + 12, var2, 0, mFont.tahoma_7);
                }

                if (GameCanvas.gameAI) {
                    if (TileMap.gameAN == 1) {
                        var11 = mResources.gameEM + ": " + Char.getMyChar().countKill;
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, var11, var3, var2, 0, mFont.tahoma_7);
                        var11 = mResources.gameEN + ": " + Char.getMyChar().countKillMax;
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, var11, var3, var2, 0, mFont.tahoma_7);
                    } else if (TileMap.gameAN != 2 && TileMap.mapID != 114 && TileMap.mapID != 115 && TileMap.mapID != 116) {
                        if (TileMap.gameAN == 3) {
                            var11 = mResources.gameEO + ": " + Char.pointChienTruong;
                            var2 += 12;
                            mFont.tahoma_7_white.gameAA(var1, var11, var3, var2, 0, mFont.tahoma_7);
                            var11 = mResources.gameMV[Char.gameBC()];
                            var2 += 12;
                            mFont.tahoma_7_white.gameAA(var1, var11, var3, var2, 0, mFont.tahoma_7);
                        }
                    } else {
                        var11 = mResources.gameEO + ": " + Char.pointPB;
                        var2 += 12;
                        mFont.tahoma_7_white.gameAA(var1, var11, var3, var2, 0, mFont.tahoma_7);
                    }
                }

                var1.gameAA(-var1.gameAA(), -var1.gameAB());
            }
        } catch (Exception var9) {
        }
    }

    private void gameAH(mGraphics var1) {
        if (GameCanvas.isTouch && (!GameCanvas.menu.showMenu || !GameCanvas.gameAH) && GameCanvas.currentDialog == null && ChatPopup.currentMultilineChatPopup == null && !GameCanvas.menu.showMenu && !gameDF()) {
            gameAB(var1);
            if (!ChatTextField.gameAA().isShow) {
                var1.gameAA(gameNJ, gamePP + 17, gamePQ + 17, 3);
            }

            if (!this.gameDG()) {
                if (!isTouchKey) {
                    InfoDlg var2 = gameVG;
                    var1.gameAA((Image) null, var2.gameAA, var2.gameAB, 3);
                    var1.gameAA((Image) null, var2.gameAC, var2.gameAD, 3);
                } else {
                    var1.gameAA(gameNM, gamePN, gamePO, 0);
                    var1.gameAA(gameNH, 0, 0, mGraphics.gameAA(gameNH), mGraphics.gameAB(gameNH), 3, gamePN + 15, gamePO + 16, 3);
                    if (mScreen.keyTouch == 4) {
                        var1.gameAA(gameNN, gamePN, gamePO, 0);
                        var1.gameAA(gameNI, 0, 0, mGraphics.gameAA(gameNH), mGraphics.gameAB(gameNH), 3, gamePN + 15, gamePO + 16, 3);
                    }

                    var1.gameAA(gameNM, gamePR, gamePS, 0);
                    var1.gameAA(gameNH, 0, 0, mGraphics.gameAA(gameNH), mGraphics.gameAB(gameNH), 0, gamePR + 17, gamePS + 16, 3);
                    if (mScreen.keyTouch == 6) {
                        var1.gameAA(gameNN, gamePR, gamePS, 0);
                        var1.gameAA(gameNI, 0, 0, mGraphics.gameAA(gameNH), mGraphics.gameAB(gameNH), 0, gamePR + 17, gamePS + 16, 3);
                    }

                    var1.gameAA(gameNM, gamePV, gamePW, 0);
                    var1.gameAA(gameNH, 0, 0, mGraphics.gameAA(gameNH), mGraphics.gameAB(gameNH), 7, gamePV + 17, gamePW + 14, 3);
                    if (mScreen.keyTouch == 3) {
                        var1.gameAA(gameNN, gamePV, gamePW, 0);
                        var1.gameAA(gameNI, 0, 0, mGraphics.gameAA(gameNH), mGraphics.gameAB(gameNH), 7, gamePV + 17, gamePW + 14, 3);
                    }
                }

                if (Char.getMyChar().ctaskId > 1) {
                    var1.gameAA(gameNM, gamePX, gamePY, 0);
                    if (mScreen.keyTouch == 10) {
                        var1.gameAA(gameNN, gamePX, gamePY, 0);
                    }

                    var1.gameAA(gameNO, gamePX + 16, gamePY + 15, 3);
                    mFont.number_white.gameAA(var1, "" + gameAS, gamePX + 22, gamePY + 20, 1);
                    var1.gameAA(gameNM, gamePZ, gameQA, 0);
                    if (mScreen.keyTouch == 11) {
                        var1.gameAA(gameNN, gamePZ, gameQA, 0);
                    }

                    var1.gameAA(gameNP, gamePZ + 16, gameQA + 15, 3);
                    mFont.number_white.gameAA(var1, "" + gameAR, gamePZ + 22, gameQA + 20, 1);
                    var1.gameAA(gameNM, gameQB, gameQC, 0);
                    if (mScreen.keyTouch == 13) {
                        var1.gameAA(gameNN, gameQB, gameQC, 0);
                    }

                    var1.gameAA(gameNL, gameQB + 16, gameQC + 16, 3);
                }

                var1.gameAA(gameNQ, gamePT, gamePU, 0);
                if (mScreen.keyTouch == 5) {
                    var1.gameAA(gameNR, gamePT, gamePU, 0);
                }
            }
        }

    }

    private void gameAI(mGraphics var1) {
        if (GameCanvas.currentDialog == null && ChatPopup.currentMultilineChatPopup == null && !GameCanvas.menu.showMenu && !gameDF() && super.center != this.gameGH && (!GameCanvas.isTouch || Char.getMyChar().vSkill.size() >= 2) && gameKD) {
            for (int var2 = 0; var2 < gamePB.length; ++var2) {
                if (GameCanvas.gameAH) {
                    if (Info.hI > 0) {
                        gameQE[var2] = 55 + Info.hI;
                    } else {
                        gameQE[var2] = 55;
                    }
                }

                if (GameCanvas.isTouch && GameCanvas.gameAG) {
                    var1.gameAA(gameNS, gameQF + gameQD[var2] - 1, gameQE[var2] - 1, 0);
                } else {
                    var1.gameAA(16764040);
                    var1.gameAC(gameQF + gameQD[var2] - 1, gameQE[var2] - 1, 25, 25);
                }

                Skill var3 = gamePB[var2];
                if (var2 == this.gamePJ && !gameAZ() && GameCanvas.gameTick % 10 > 5) {
                    var1.gameAA(16777215);
                    var1.gameAD(gameQF + gameQD[var2] + 1, gameQE[var2] + 1, 22, 22);
                } else if (!GameCanvas.isTouch) {
                    var1.gameAA(0);
                    var1.gameAD(gameQF + gameQD[var2], gameQE[var2], 24, 24);
                }

                if (var3 != null) {
                    if (var3 == Char.getMyChar().myskill) {
                        var1.gameAA(16711680);
                        var1.gameAC(gameQF + gameQD[var2] - 1, gameQE[var2] - 1, 25, 25);
                    }

                    var3.gameAA(gameQF + gameQD[var2] + 12, gameQE[var2] + 12, var1);
                }
            }
        }

    }

    public static final void gameAA(String var0, int var1, int var2, int var3) {
        int var4 = -1;

        for (int var5 = 0; var5 < 5; ++var5) {
            if (gameQN[var5] == -1) {
                var4 = var5;
                break;
            }
        }

        if (var4 != -1) {
            gameQO[var4] = var3;
            gameQI[var4] = var0;
            gameQJ[var4] = var1;
            gameQK[var4] = var2;
            gameQL[var4] = 0;
            gameQM[var4] = -2;
            gameQN[var4] = 0;
        }

    }

    public static final void gameAA(int var0, int var1) {
        gameHP.addElement(new Lanterns(var0, var1));
    }

    public static final boolean gameAA(int var0, int var1, int var2) {
        int var3 = gameQR[0] == -1 ? 0 : 1;
        if (gameQR[var3] != -1) {
            return false;
        } else {
            gameQR[var3] = 0;
            gameQT[var3] = var2;
            gameQP[var3] = var0;
            gameQQ[var3] = var1;
            return true;
        }
    }

    private void gameCR() {
        if (gameRG == null) {
            gameRG = new Image[2];

            for (int var1 = 0; var1 < 2; ++var1) {
                gameRG[var1] = GameCanvas.gameAC("/u/c" + var1 + ".png");
            }
        }

        gameQX = mGraphics.gameAA(gameRG[0]);
        gameQY = mGraphics.gameAA(gameRG[1]);
        gameQZ = gW - gameQX - gameQY + 1;
        gameRA = 63;
        gameRB = gameQV + 7;
        gameRC = gW - 84 - 30 + 15;
        gameRE = gW - 44 - 4;
        gameRF = 5;
        if (GameCanvas.w > 176) {
            gameQZ -= 50;
            gameRC -= 50;
            gameRE -= 50;
            gameRA += 15;
            gameRC -= 15;
        }

        this.gameCS();
    }

    private void gameCS() {
        if (GameCanvas.isTouch) {
            gameRC = 82;
            gameRD = 57;
            gameRA = 52;
            gameRB = 10 + Info.hI;
            gameRE = gW - 61;
            if (GameCanvas.gameAH) {
                gamePP = gW / 2 - 2;
                gamePQ = gamePM + 50;
            } else {
                this.gameFT.y = 6 + Info.hI;
                gamePP = gW - 100;
                gamePQ = 2 + Info.hI;
            }

            TileMap.gameAA(GameCanvas.w - 60, Info.hI, 60, 42);
        }

    }

    private void gameAJ(mGraphics var1) {
        if (gameBP == 4) {
            var1.gameAA(-var1.gameAA(), -var1.gameAB());
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            var1.gameAA(Paint.COLORBACKGROUND);
            gameAA(var1, mResources.gameGN[gameBP], true);
            if (currentCharViewInfo.arrItemBody == null) {
                GameCanvas.gameAA(popupX + 90, popupY + 75, var1);
                mFont.tahoma_7b_white.gameAA(var1, mResources.gameBG, popupX + gameGC / 2, popupY + 90, 2);
                return;
            }

            var1.gameAA(13606712);
            var1.gameAC(popupX + 33, popupY + (GameCanvas.gameAI ? 87 : 34), gameGC - 67, GameCanvas.gameAI ? 76 : 128);
            int var2 = gameBL - 2;
            int var3 = 0;

            int var4;
            int var5;
            int var6;
            for (var4 = 0; var4 < 16; ++var4) {
                if (var4 != 0 && var4 != 2 && var4 != 4 && var4 != 6 && var4 != 8) {
                    if (var4 != 1 && var4 != 3 && var4 != 5 && var4 != 7 && var4 != 9) {
                        if (var4 == 9 || var4 == 10 || var4 == 11 || var4 == 12 || var4 == 13 || var4 == 14 || var4 == 15) {
                            var5 = popupX + 4 + 1 + var3 * (var2 + 2);
                            var6 = popupY + 35 + var2 * 5 + 1;
                            var1.gameAA(0);
                            var1.gameAD(var5, popupY + 35 + var2 * 5 + 1, var2 - 1, var2 - 1);
                            if (indextabTrangbi == 0) {
                                if (mResources.gamePN[var4].length > 1) {
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][0], var5 + var2 / 2, var6 + 2, 2);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][1], var5 + var2 / 2, var6 + 2 + 9, 2);
                                } else {
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][0], var5 + var2 / 2, var6 + 2 + 5, 2);
                                }
                            }
                            ++var3;
                        }
                    } else {
                        var1.gameAA(0);
                        var1.gameAD(popupX + gameGC - var2 - 4, popupY + 35 + var4 / 2 * var2 + 1, var2 - 1, var2 - 1);
                        if (indextabTrangbi == 0) {
                            if (mResources.gamePN[var4].length > 1) {
                                mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][0], popupX + gameGC - var2 / 2 - 4, popupY + 36 + var4 / 2 * var2 + 2, 2);
                                mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][1], popupX + gameGC - var2 / 2 - 4, popupY + 36 + var4 / 2 * var2 + 2 + 9, 2);
                            } else {
                                mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][0], popupX + gameGC - var2 / 2 - 4, popupY + 36 + var4 / 2 * var2 + 2 + 5, 2);
                            }
                        }
                    }
                } else {
                    var1.gameAA(0);
                    var1.gameAD(popupX + 4 + 1, popupY + 35 + var4 / 2 * var2 + 1, var2 - 1, var2 - 1);
                    if (indextabTrangbi == 0) {
                        if (mResources.gamePN[var4].length > 1) {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][0], popupX + 7 + 11, popupY + 36 + var4 / 2 * var2 + 2, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][1], popupX + 7 + 11, popupY + 36 + var4 / 2 * var2 + 2 + 9, 2);
                        } else {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[var4][0], popupX + 7 + 11, popupY + 36 + var4 / 2 * var2 + 2 + 5, 2);
                        }
                    }
                }
            }
            if (indextabTrangbi == 0) {
                for (var4 = 0; var4 < 16; ++var4) {
                    Item var9;
                    if ((var9 = currentCharViewInfo.arrItemBody[var4]) != null) {
                        if (var9.eff == null) {
                            var9.eff = efs[56];
                        }

                        int var7;
                        if (var9.indexUI != 0 && var9.indexUI != 2 && var9.indexUI != 4 && var9.indexUI != 6 && var9.indexUI != 8 && var9.indexUI != 10) {
                            if (var9.indexUI != 1 && var9.indexUI != 3 && var9.indexUI != 5 && var9.indexUI != 7 && var9.indexUI != 9) {
                                if (var9.indexUI == 11 || var9.indexUI == 12 || var9.indexUI == 13 || var9.indexUI == 14 || var9.indexUI == 15) {
                                    if (var9.indexUI == 10) {
                                        var3 = 1;
                                    } else if (var9.indexUI == 11) {
                                        var3 = 2;
                                    } else if (var9.indexUI == 12) {
                                        var3 = 3;
                                    } else if (var9.indexUI == 13) {
                                        var3 = 4;
                                    } else if (var9.indexUI == 14) {
                                        var3 = 5;
                                    } else if (var9.indexUI == 15) {
                                        var3 = 6;
                                    }

                                    var6 = popupX + 2 + 1 + var3 * (var2 + 2) - var2;
                                    var7 = popupY + 35 + var2 * 5;
                                    this.gameAA(var1, var9, var6 - 2, var7 - 1, 0, 1);
                                }
                            } else {
                                var6 = popupX + gameGC - var2 - 5;
                                var7 = popupY + 35 + var9.indexUI / 2 * var2;
                                this.gameAA(var1, var9, var6 - 1, var7 - 1, 0, 1);
                            }
                        } else {
                            var6 = popupX + 4;
                            var7 = popupY + 34 + var9.indexUI / 2 * var2;
                            this.gameAA(var1, var9, var6 - 1, var7, 0, 1);
                        }

                        if (GameCanvas.gameTick % 4 == 0) {
                            ++var9.indexEff;
                            if (var9.indexEff >= var9.eff.arrEfInfo.length) {
                                var9.indexEff = 0;
                            }
                        }
                    }
                }
            }

            if (indextabTrangbi > 0) {
                for (var4 = 0; var4 < 16; ++var4) {
                    Item var9;

                    if ((var9 = currentCharViewInfo.arrItemBody[var4 + indextabTrangbi]) != null) {
                        int num10 = var9.indexUI - 16;

                        if (var9.eff == null) {
                            var9.eff = efs[56];
                        }

                        int var7;
                        if (num10 != 0 && num10 != 2 && num10 != 4 && num10 != 6 && num10 != 8 && num10 != 10) {
                            if (num10 != 1 && num10 != 3 && num10 != 5 && num10 != 7 && num10 != 9) {
                                if (num10 == 11 || num10 == 12 || num10 == 13 || num10 == 14 || num10 == 15) {
                                    if (num10 == 10) {
                                        var3 = 1;
                                    } else if (num10 == 11) {
                                        var3 = 2;
                                    } else if (num10 == 12) {
                                        var3 = 3;
                                    } else if (num10 == 13) {
                                        var3 = 4;
                                    } else if (num10 == 14) {
                                        var3 = 5;
                                    } else if (num10 == 15) {
                                        var3 = 6;
                                    }

                                    var6 = popupX + 2 + 1 + var3 * (var2 + 2) - var2;
                                    var7 = popupY + 35 + var2 * 5;
                                    this.gameAA(var1, var9, var6 - 2, var7 - 1, 0, 1);
                                }
                            } else {
                                var6 = popupX + gameGC - var2 - 5;
                                var7 = popupY + 35 + num10 / 2 * var2;
                                this.gameAA(var1, var9, var6 - 1, var7 - 1, 0, 1);
                            }
                        } else {
                            var6 = popupX + 4;
                            var7 = popupY + 34 + num10 / 2 * var2;
                            this.gameAA(var1, var9, var6 - 1, var7, 0, 1);
                        }

                        if (GameCanvas.gameTick % 4 == 0) {
                            ++var9.indexEff;
                            if (var9.indexEff >= var9.eff.arrEfInfo.length) {
                                var9.indexEff = 0;
                            }
                        }
                    }
                }
            }

            for (var4 = 0; var4 < 16; ++var4) {
                if (gameHQ == 1 && var4 == gameBM) {
                    if (var4 != 0 && var4 != 2 && var4 != 4 && var4 != 6 && var4 != 8) {
                        if (var4 != 1 && var4 != 3 && var4 != 5 && var4 != 7 && var4 != 9) {
                            if (var4 == 9 || var4 == 10 || var4 == 11 || var4 == 12 || var4 == 13 || var4 == 14 || var4 == 15) {
                                if (var4 == 9) {
                                    var3 = 0;
                                } else if (var4 == 10) {
                                    var3 = 1;
                                } else if (var4 == 11) {
                                    var3 = 2;
                                } else if (var4 == 12) {
                                    var3 = 3;
                                } else if (var4 == 13) {
                                    var3 = 4;
                                } else if (var4 == 14) {
                                    var3 = 5;
                                } else if (var4 == 15) {
                                    var3 = 6;
                                }

                                var5 = popupX + 2 + 1 + var3 * (var2 + 2) - var2;
                                var6 = popupY + 35 + var2 * 5;
                                var1.gameAA(16777215);
                                var1.gameAC(var5 - 1, var6, var2, var2);
                                gameAA(var5 - 2, var6 - 1, var1);
                            }
                        } else {
                            var1.gameAA(16777215);
                            var1.gameAC(popupX + gameGC - var2 - 4 - 1, popupY + 35 + var4 / 2 * var2, var2, var2);
                            gameAA(popupX + gameGC - var2 - 4 - 2, popupY + 35 + var4 / 2 * var2 - 1, var1);
                        }
                    } else {
                        var1.gameAA(16777215);
                        var1.gameAC(popupX + 4, popupY + 35 + var4 / 2 * var2, var2, var2);
                        gameAA(popupX + 5 - 2, popupY + 35 + var4 / 2 * var2 - 1, var1);
                    }
                }
            }

            var4 = GameCanvas.gameAI ? -25 : 16;
            Part var10 = parts[currentCharViewInfo.head];
            Part var12 = parts[currentCharViewInfo.leg];
            Part var8 = parts[currentCharViewInfo.body];
            Part var11 = parts[currentCharViewInfo.wp];
            if (currentCharViewInfo.arrItemBody != null && currentCharViewInfo.arrItemBody[11] != null) {
                var10 = parts[currentCharViewInfo.arrItemBody[11].template.part];
            }

            label437:
            {
                if (var10.pi != null && var10.pi.length >= 8) {
                    var3 = 0;

                    while (true) {
                        if (var3 >= var10.pi.length) {
                            break label437;
                        }

                        if (var10.pi[var3] == null || !SmallImage.gameAA(var10.pi[var3].id)) {
                            Char.getMyChar();
                            break;
                        }

                        ++var3;
                    }
                }

                var10 = Char.gameAB(Char.getMyChar().cgender);
            }

            int[] var13;
            if ((var13 = currentCharViewInfo.gameAV()) != null) {
                if (Char.getMyChar().tickCoat == 0) {
                    SmallImage.gameAB(var1, var13[Char.getMyChar().tickCoat], gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 2, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                } else if (Char.getMyChar().tickCoat == 1) {
                    SmallImage.gameAB(var1, var13[Char.getMyChar().tickCoat], gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 9, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                } else if (Char.getMyChar().tickCoat == 2) {
                    SmallImage.gameAB(var1, var13[Char.getMyChar().tickCoat], gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 12, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                } else {
                    SmallImage.gameAB(var1, var13[Char.getMyChar().tickCoat], gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 9, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                }
            }

            currentCharViewInfo.gameAD(var1, gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + var8.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx + 18, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + var12.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy + 5);
            SmallImage.gameAB(var1, var11.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][0]].id, gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][1] + var11.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][0]].dx, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][2] + var11.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][0]].dy, 0, 0);
            SmallImage.gameAB(var1, var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].id, gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + var10.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy, 0, 0);
            SmallImage.gameAB(var1, var12.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].id, gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][1] + var12.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dx, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + var12.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy, 0, 0);
            SmallImage.gameAB(var1, var8.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].id, gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + var8.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][2] + var8.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dy, 0, 0);
            currentCharViewInfo.gameAD(var1, gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + var8.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx + 5, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + var12.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy + 5);
            currentCharViewInfo.gameAE(var1, gameAD + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + var8.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx + 22, gameAF + var4 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + var12.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy + 5);
        }

    }

    private void gameAK(mGraphics var1) {
        if (gameBP == 5) {
            var1.gameAA(-var1.gameAA(), -var1.gameAB());
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            var1.gameAA(Paint.COLORBACKGROUND);
            gameAA(var1, mResources.gameGN[gameBP], true);
            gameAB(var1);
            var1.gameAA(0);
            var1.gameAD(popupX + 2, popupY + 31, 171, gameGD - 34);
            var1.gameAA(13606712);
            var1.gameAC(popupX + 3, popupY + 32, 168, gameGD - 37);
            var1.gameAA(Paint.COLORBACKGROUND);
            var1.gameAD(popupX + 4, popupY + 34, 166, gameGD - 39);
            int var2;
            int var3;
            if (currentCharViewInfo.arrItemMounts[4] != null) {
                mFont.tahoma_7b_white.gameAA(var1, currentCharViewInfo.arrItemMounts[4].template.name, popupX + 90, gameGB + 2, 2);
                var2 = currentCharViewInfo.arrItemMounts[4].sys + 1;

                for (var3 = 0; var3 < var2; ++var3) {
                    SmallImage.gameAB(var1, 628, popupX + 90 + var3 * 12 - var2 * 6, gameGB + 20, 0, 3);
                }
            } else {
                mFont.tahoma_7b_white.gameAA(var1, mResources.gameWN, popupX + 90, gameGB + 2, 2);
            }

            for (var2 = 0; var2 < currentCharViewInfo.arrItemMounts.length - 1; ++var2) {
                if (currentCharViewInfo.arrItemMounts[var2] != null) {
                    this.gameAA(var1, currentCharViewInfo.arrItemMounts[var2], this.gameNX[var2], this.gameNY[var2]);
                } else {
                    var1.gameAA(6425);
                    var1.gameAD(this.gameNX[var2] - 1, this.gameNY[var2] - 1, gameBL + 3, gameBL + 3);
                    if (var2 == 0) {
                        if (currentCharViewInfo.gameAT()) {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[22][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[22][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[19][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[19][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        }
                    } else if (var2 == 1) {
                        if (currentCharViewInfo.gameAT()) {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[20][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[20][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[16][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[16][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        }
                    } else if (var2 == 2) {
                        if (currentCharViewInfo.gameAT()) {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[21][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[21][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[17][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[17][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        }
                    } else if (var2 == 3) {
                        if (currentCharViewInfo.gameAT()) {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[23][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[23][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[18][0], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 - 10, 2);
                            mFont.tahoma_7_grey.gameAA(var1, mResources.gamePN[18][1], this.gameNX[var2] + gameBL / 2, this.gameNY[var2] + gameBL / 2 + 2, 2);
                        }
                    }
                }

                if (gameBM == var2 && gameHQ == 1 && gameBM < 4) {
                    var1.gameAA(16777215);
                } else {
                    var1.gameAA(12281361);
                }

                var1.gameAC(this.gameNX[var2], this.gameNY[var2], gameBL, gameBL);
            }

            var2 = this.gameNX[0] + gameBL + 7;
            var3 = this.gameNY[0] - 5;
            var1.gameAA(6425);
            var1.gameAD(var2, var3, 84, 75);
            if (gameBM == 4) {
                var1.gameAA(16777215);
            } else {
                var1.gameAA(12281361);
            }

            var1.gameAC(var2, var3, 84, 75);
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            int var8 = 0;
            if (currentCharViewInfo.arrItemMounts[4] != null) {
                if (currentCharViewInfo.gameAT()) {
                    if (currentCharViewInfo.arrItemMounts[4].template.id == 485) {
                        if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                            SmallImage.gameAB(var1, 1800, var2 + 45, var3 + 35, 0, 3);
                        } else {
                            SmallImage.gameAB(var1, 2063, var2 + 45, var3 + 35, 0, 3);
                        }
                    } else if (currentCharViewInfo.arrItemMounts[4].template.id == 524) {
                        if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                            SmallImage.gameAB(var1, 2067, var2 + 45, var3 + 35, 0, 3);
                        } else {
                            SmallImage.gameAB(var1, 2071, var2 + 45, var3 + 35, 0, 3);
                        }
                    }
                } else if (currentCharViewInfo.gameAS()) {
                    if (currentCharViewInfo.arrItemMounts[4].template.id == 443) {
                        if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                            if (GameCanvas.gameTick % 20 > 15) {
                                SmallImage.gameAB(var1, 1801, var2 + 45, var3 + 35, 0, 3);
                            } else {
                                SmallImage.gameAB(var1, 1802, var2 + 45, var3 + 35, 0, 3);
                            }
                        } else if (GameCanvas.gameTick % 20 > 15) {
                            SmallImage.gameAB(var1, 2080, var2 + 45, var3 + 35, 0, 3);
                        } else {
                            SmallImage.gameAB(var1, 2081, var2 + 45, var3 + 35, 0, 3);
                        }
                    } else if (currentCharViewInfo.arrItemMounts[4].template.id == 523) {
                        if (GameCanvas.gameTick % 20 > 15) {
                            SmallImage.gameAB(var1, 2062, var2 + 45, var3 + 35, 0, 3);
                        } else {
                            SmallImage.gameAB(var1, 2061, var2 + 45, var3 + 35, 0, 3);
                        }
                    }
                }

                if (currentCharViewInfo.arrItemMounts[4].options != null) {
                    for (var2 = 0; var2 < currentCharViewInfo.arrItemMounts[4].options.size(); ++var2) {
                        ItemOption var9;
                        if ((var9 = (ItemOption) currentCharViewInfo.arrItemMounts[4].options.elementAt(var2)).optionTemplate.id == 65) {
                            var4 = var9.param;
                        } else if (var9.optionTemplate.id == 66) {
                            var5 = var9.param;
                        }
                    }
                }

                var6 = var4 * 85 / 1000;
                var7 = var5 * 85 / 1000;
                var8 = currentCharViewInfo.arrItemMounts[4].upgrade + 1;
            }

            var2 = gameGA + 5;
            var3 = gameGB + 112;
            mFont.tahoma_7b_white.gameAA(var1, mResources.gameFB + ": ", var2, var3, 0);
            mFont.tahoma_7b_white.gameAA(var1, String.valueOf(var8), var2 + 70, var3, 0);
            String var10;
            if (currentCharViewInfo.gameAT()) {
                var10 = mResources.gameXC + ": ";
                var3 += 15;
                mFont.tahoma_7b_white.gameAA(var1, var10, var2, var3, 0);
            } else {
                var10 = mResources.gameKF + ": ";
                var3 += 15;
                mFont.tahoma_7b_white.gameAA(var1, var10, var2, var3, 0);
            }

            var1.gameAA(6425);
            var1.gameAD(var2 + 70, var3, 85, 14);
            var1.gameAA(371981);
            var1.gameAD(var2 + 70, var3, var6, 14);
            var1.gameAA(5131338);
            var1.gameAC(var2 + 70, var3, 85, 14);
            mFont.tahoma_7_white.gameAA(var1, var4 + "/1000", var2 + 113, var3 + 2, 2);
            if (currentCharViewInfo.gameAT()) {
                var10 = mResources.gameXD + ": ";
                var3 += 17;
                mFont.tahoma_7b_white.gameAA(var1, var10, var2, var3, 0);
            } else {
                var10 = mResources.gameWM + ": ";
                var3 += 17;
                mFont.tahoma_7b_white.gameAA(var1, var10, var2, var3, 0);
            }

            var1.gameAA(6425);
            var1.gameAD(var2 + 70, var3, 85, 14);
            var1.gameAA(16711680);
            var1.gameAD(var2 + 70, var3, var7, 14);
            var1.gameAA(5131338);
            var1.gameAC(var2 + 70, var3, 85, 14);
            mFont.tahoma_7_white.gameAA(var1, var5 + "/1000", var2 + 113, var3 + 2, 2);
        }

    }

    private void gameAL(mGraphics var1) {
        if (gameMH) {
            gameAB(var1);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            gameAA(var1, mResources.gameRM[gameBP], true);
            if (gameBP == 0) {
                if (Char.clan != null && Char.clan.name != null && !Char.clan.name.equals("")) {
                    int[] var6 = new int[]{1692, 1693, 1694, 1695, 1696};

                    for (int var5 = 0; var5 < 5; ++var5) {
                        var1.gameAA(6425);
                        var1.gameAD(popupX + var5 * gameBL + 18, popupY + 32, gameBL - 2, gameBL - 2);
                        if (gameHQ == 1 && var5 == gameBM) {
                            var1.gameAA(16777215);
                        } else {
                            var1.gameAA(12281361);
                        }

                        var1.gameAC(popupX + var5 * gameBL + 18, popupY + 32, gameBL - 2, gameBL - 2);
                        if (var5 > Char.clan.itemLevel - 1) {
                            SmallImage.gameAB(var1, 1697, popupX + var5 * gameBL + 18 + gameBL / 2, popupY + 32 + gameBL / 2, 0, 3);
                        } else {
                            SmallImage.gameAB(var1, var6[var5], popupX + var5 * gameBL + 18 + gameBL / 2, popupY + 32 + gameBL / 2, 0, 3);
                        }
                    }

                    if (gameHQ == 2) {
                        var1.gameAA(Paint.COLORDARK);
                        var1.gameAD(popupX + 7, popupY + 60, gameGC - 14, gameGD - 68);
                        var1.gameAA(16777215);
                    } else {
                        var1.gameAA(10249521);
                    }

                    var1.gameAC(popupX + 7, popupY + 60, gameGC - 14, gameGD - 68);
                    gameGA = popupX + 17;
                    gameGB = popupY + 62;
                    gameBO = 12;
                    gameBU.gameAA(gameBO, 12, popupX, popupY + 62, gameGC, gameGD - 72, true, 1);
                    gameBU.gameAA(var1);
                    mFont.tahoma_7b_yellow.gameAA(var1, mResources.gameRN[0] + Char.clan.name, gameGA, gameGB, 0);
                    mFont.tahoma_7_blue1.gameAA(var1, mResources.gameRN[1] + Char.clan.gameAJ, gameGA, gameGB += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[2] + Char.clan.gameAN + "/" + (Char.clan.level * 5 + 45), gameGA, gameGB += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[3] + Char.clan.level, gameGA, gameGB += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[4] + Char.clan.exp + "/" + Char.clan.expNext, gameGA, gameGB += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[5] + NinjaUtil.gameAA(String.valueOf(Char.clan.coin)) + " " + mResources.gamePE, gameGA, gameGB += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[8] + NinjaUtil.gameAA(String.valueOf(Char.clan.freeCoin)) + " " + mResources.gamePE, gameGA, gameGB += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[9] + NinjaUtil.gameAA(String.valueOf(Char.clan.coinUp)) + " " + mResources.gamePE, gameGA, gameGB += 12, 0);
                    if (mFont.tahoma_7_white.gameAA(mResources.gameRN[10] + Char.clan.icon + " " + mResources.gameRL) > gameTJ - 10) {
                        this.gameAB(var1, mFont.tahoma_7_white, mResources.gameRN[10] + Char.clan.icon + " " + mResources.gameRL, gameGA, gameGB += 12, gameGC - 20);
                    } else {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[10] + Char.clan.icon + " " + mResources.gameRL, gameGA, gameGB += 12, 0);
                    }

                    if (mFont.tahoma_7_white.gameAA(mResources.gameRN[12] + Char.clan.gameAO + " " + mResources.gameRL) > gameTJ - 10) {
                        this.gameAB(var1, mFont.tahoma_7_white, mResources.gameRN[12] + Char.clan.gameAO + " " + mResources.gameRL, gameGA, gameGB += 12, gameGC - 20);
                    } else {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[12] + Char.clan.gameAO + " " + mResources.gameRL, gameGA, gameGB += 12, 0);
                    }

                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRN[6] + Char.clan.gameAK, gameGA, gameGB += 12, 0);
                    if (this.gameRI == null) {
                        this.gameRI = gameAA(mFont.tahoma_7_yellow, Char.clan.gameAM);
                    }

                    this.gameAA(var1, mFont.tahoma_7_yellow, this.gameRI, gameGA, gameGB += 12);
                    if (gameHQ == 2 && indexRow >= 0) {
                        SmallImage.gameAB(var1, 942, gameGA - 8, popupY + 62 + 2 + indexRow * 12, 0, StaticObj.gameAB);
                    }

                    gameBU.gameAA(gameBO, 12, popupX, popupY + 62, gameGC, gameGD - 72, true, 1);
                    return;
                }

                gameBO = 1;
                mFont.tahoma_7_white.gameAA(var1, mResources.gameST, popupX + gameGC / 2, popupY + 40, 2);
                return;
            }

            if (gameBP == 1) {
                gameGA = popupX + 5;
                gameGB = popupY + 32;
                if (vClan.size() == 0) {
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameST, popupX + gameGC / 2, popupY + 40, 2);
                    return;
                }

                var1.gameAA(6425);
                var1.gameAD(gameGA - 2, gameGB - 2, gameGC - 6, gameBL * 5 + 8);
                gameAB(var1);
                gameBU.gameAA(var1, gameGA, gameGB, gameGC - 3, gameBL * 5 + 6);
                this.gameRH = 0;

                for (int var4 = 0; var4 < vClan.size(); ++var4) {
                    Member var3 = (Member) vClan.elementAt(var4);
                    if (!gameHU || var3.gameAE) {
                        if (var4 * (gameBL + gameBL / 2) >= gameBU.cmy - (gameBL + gameBL / 2) && var4 * (gameBL + gameBL / 2) < gameBU.cmy + gameBL * 5 + 8) {
                            if (indexRow == this.gameRH) {
                                var1.gameAA(Paint.COLORLIGHT);
                                var1.gameAD(gameGA + 2, gameGB + indexRow * (gameBL + gameBL / 2) + 2, gameGC - 15, gameBL + gameBL / 2 - 4);
                                var1.gameAA(16777215);
                                var1.gameAC(gameGA + 2, gameGB + indexRow * (gameBL + gameBL / 2) + 2, gameGC - 15, gameBL + gameBL / 2 - 4);
                            } else {
                                var1.gameAA(Paint.COLORBACKGROUND);
                                var1.gameAD(gameGA + 2, gameGB + this.gameRH * (gameBL + gameBL / 2) + 2, gameGC - 15, gameBL + gameBL / 2 - 4);
                                var1.gameAA(13932896);
                                var1.gameAC(gameGA + 2, gameGB + this.gameRH * (gameBL + gameBL / 2) + 2, gameGC - 15, gameBL + gameBL / 2 - 4);
                            }

                            SmallImage.gameAB(var1, var3.gameAA, gameGA + 12, gameGB + this.gameRH * (gameBL + gameBL / 2) + 13, 0, 3);
                            if (var3.gameAC == 4) {
                                SmallImage.gameAB(var1, 1216, gameGA + 12, gameGB + this.gameRH * (gameBL + gameBL / 2) + 30, 0, 3);
                                if (var3.gameAE) {
                                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameSZ[0] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0, mFont.tahoma_7_grey);
                                    mFont.tahoma_7_white.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_green.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_blue1.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                } else {
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameSZ[0] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                }
                            } else if (var3.gameAC == 3) {
                                SmallImage.gameAB(var1, 1215, gameGA + 12, gameGB + this.gameRH * (gameBL + gameBL / 2) + 30, 0, 3);
                                if (var3.gameAE) {
                                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameSZ[1] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0, mFont.tahoma_7_grey);
                                    mFont.tahoma_7_white.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_green.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_blue1.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                } else {
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameSZ[1] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                }
                            } else if (var3.gameAC == 2) {
                                SmallImage.gameAB(var1, 1217, gameGA + 12, gameGB + this.gameRH * (gameBL + gameBL / 2) + 30, 0, 3);
                                if (var3.gameAE) {
                                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameSZ[2] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0, mFont.tahoma_7_grey);
                                    mFont.tahoma_7_white.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_green.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_blue1.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                } else {
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameSZ[2] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                }
                            } else if (var3.gameAC == 1) {
                                SmallImage.gameAB(var1, 1214, gameGA + 12, gameGB + this.gameRH * (gameBL + gameBL / 2) + 30, 0, 3);
                                if (var3.gameAE) {
                                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameSZ[3] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0, mFont.tahoma_7_grey);
                                    mFont.tahoma_7_white.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_green.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_blue1.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                } else {
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameSZ[3] + " ", gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 45, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                    mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                                }
                            } else if (var3.gameAE) {
                                mFont.tahoma_7_white.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                mFont.tahoma_7_green.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                mFont.tahoma_7_blue1.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                            } else {
                                mFont.tahoma_7_grey.gameAA(var1, var3.gameAD + " - " + mResources.gameFC + ": " + var3.gameAB, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 5, 0);
                                mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[7] + var3.gameAF, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 16, 0);
                                mFont.tahoma_7_grey.gameAA(var1, mResources.gameRN[11] + var3.gameAG, gameGA + 22, gameGB + this.gameRH * (gameBL + gameBL / 2) + 26, 0);
                            }
                        }

                        ++this.gameRH;
                    }
                }

                gameBU.gameAA(this.gameRH, gameBL + gameBL / 2, gameGA, gameGB, gameGC - 3, gameBL * 5 + 4, true, 1);
                gameBO = this.gameRH;
                gameAM(var1);
                return;
            }

            if (gameBP != 2) {
                if (gameBP == 3) {
                    if (Char.clan != null && Char.clan.name != null && !Char.clan.name.equals("") && !Char.clan.log.equals("")) {
                        gameBO = 1;
                        gameGA = popupX + 17;
                        gameGB = popupY + 34;
                        gameTJ = gameGC - 30;
                        gameBU.gameAA(var1);
                        if (this.gameRJ == null) {
                            this.gameRJ = gameAA(mFont.tahoma_7_white, Char.clan.log);
                        }

                        this.gameAA(var1, mFont.tahoma_7_white, this.gameRJ, gameGA, gameGB);
                        if (gameHQ == 1 && indexRow >= 0) {
                            SmallImage.gameAB(var1, 942, gameGA - 8, popupY + 34 + 2 + indexRow * 12, 0, StaticObj.gameAB);
                        }

                        gameBU.gameAA(gameBO, 12, popupX, popupY + 35, gameGC, gameGD - 44, true, 1);
                        return;
                    }

                    gameBO = 1;
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameST, popupX + gameGC / 2, popupY + 40, 2);
                    return;
                }

                if (gameBP == 4) {
                    this.gameBQ(var1);
                    return;
                }
            } else {
                gameGA = popupX + 3;
                gameGB = popupY + 32;
                var1.gameAA(6425);
                var1.gameAD(gameGA - 1, gameGB - 1, gameTC * gameBL + 3, 5 * gameBL + 3);
                Item[] var2;
                if (Char.clan != null && Char.clan.items != null) {
                    var2 = Char.clan.items;
                } else {
                    var2 = new Item[30];
                }

                this.gameAA(var1, var2);
            }
        }

    }

    private static void gameAM(mGraphics var0) {
        gameAB(var0);
        int var1 = indexRow;
        if (gameMK) {
            var1 = gameBM;
        }

        if (var1 >= 0 && gameBO > 0) {
            var1 = var1 + 1 < gameBO ? var1 + 1 : gameBO;
            mFont.tahoma_7_yellow.gameAA(var0, var1 + "/" + gameBO, popupX + gameGC / 2, popupY + gameGD - 12, 2, mFont.tahoma_7_grey);
        }

    }

    private void gameCT() {
        if (!GameCanvas.menu.showMenu && GameCanvas.currentDialog == null) {
            if (GameCanvas.isPointerJustRelease && GameCanvas.gameAB(popupX, popupY, gameGC, this.gameTS) && (!gameDK || GameCanvas.w >= 320) && GameCanvas.isPointerClick) {
                if (GameCanvas.gameAB(gameAD - 90, popupY + 5, 60, 40)) {
                    gameBM = 0;
                    --gameBP;
                }

                if (GameCanvas.gameAB(gameAD + 20, popupY + 5, 60, 40)) {
                    gameBM = 0;
                    ++gameBP;
                }

                gameDK = false;
                gameBU.gameAA();
                gameBT.gameAA();
                if (currentCharViewInfo.charID != Char.getMyChar().charID) {
                    if (gameBP < 3) {
                        gameBP = mResources.gameGN.length - 1;
                    }

                    if (gameBP > mResources.gameGN.length - 1) {
                        gameBP = 3;
                    }
                } else {
                    if (gameBP < 0) {
                        gameBP = mResources.gameGN.length - 1;
                    }

                    if (gameBP > mResources.gameGN.length - 1) {
                        gameBP = 0;
                    }
                }

                gameHQ = 1;
                gameBM = -1;
                this.gameCB();
            }

            ScrollResult var1;
            if (gameDK) {
                if ((var1 = gameBT.gameAB()).isDowning || var1.isFinish) {
                    indexRow = var1.selected;
                    gameHQ = 1;
                }

                if (GameCanvas.gameAH) {
                    return;
                }
            }

            if (gameBP == 0) {
                if ((var1 = gameBU.gameAB()).isDowning || var1.isFinish) {
                    if (gameBM != var1.selected) {
                        gameBM = var1.selected;
                        super.left = super.center = null;
                        if (GameCanvas.gameAH) {
                            this.gameBI();
                        } else if (gameAN(3) != null) {
                            this.gameHQ();
                        } else {
                            gameDK = false;
                            super.left = this.gameTM;
                        }
                    }

                    gameHQ = 1;
                    return;
                }
            } else if (gameBP == 1) {
                if ((var1 = gameBU.gameAB()).isDowning || var1.isFinish) {
                    if (gameBM != var1.selected) {
                        gameBM = var1.selected;
                        if (var1.selected >= Char.getMyChar().nClass.skillTemplates.length) {
                            gameBM = -1;
                        }

                        super.left = super.center = null;
                        this.gameBI();
                        gameBT.gameAA();
                        indexRow = 0;
                    }

                    gameHQ = 1;
                    return;
                }

                if (((var1 = gameBT.gameAB()).isDowning || var1.isFinish) && indexRow != var1.selected) {
                    indexRow = var1.selected;
                    return;
                }
            } else {
                int var3;
                if (gameBP == 2) {
                    if (GameCanvas.isPointerJustRelease && GameCanvas.gameAB(popupX + 5, popupY + 52, gameGC - 10, 130) && GameCanvas.isPointerClick) {
                        var3 = (GameCanvas.py - (popupY + 52)) / 32;
                        ++var3;
                        if (var3 == this.gameRK) {
                            MyVector var2;
                            (var2 = new MyVector()).addElement(new Command(mResources.gameEF, 11064));
                            var2.addElement(new Command(mResources.gameEG, 11065));
                            GameCanvas.menu.gameAA(var2);
                        }

                        gameHQ = var3;
                        this.gameRK = var3;
                        this.gameBI();
                        return;
                    }
                } else if (gameBP == 3) {
                    if ((var1 = gameBU.gameAB()).isDowning || var1.isFinish) {
                        indexRow = var1.selected;
                        gameHQ = 1;
                        return;
                    }
                } else if (gameBP == 4) {
                    if (GameCanvas.isPointerJustRelease) {
                        gameHQ = 1;
                        if (GameCanvas.gameAB(popupX + 4, popupY + 35, gameBL, 130)) {
                            gameBM = (GameCanvas.py - (popupY + 35)) / gameBL << 1;
                            super.left = super.center = null;
                            this.gameBI();
                        }

                        if (GameCanvas.gameAB(popupX + gameGC - 30, popupY + 35, gameBL, 130)) {
                            gameBM = ((GameCanvas.pyLast - (popupY + 35)) / gameBL << 1) + 1;
                            super.left = super.center = null;
                            this.gameBI();
                        }

                        if (GameCanvas.gameAB(popupX + 4, popupY + 165, gameGC - 8, gameBL)) {
                            var3 = (GameCanvas.pxLast - (popupX + 4)) / gameBL;
                            var3 += 10;
                            gameBM = var3;
                            super.left = super.center = null;
                            this.gameBI();
                            return;
                        }
                    }
                } else if (gameBP == 5 && GameCanvas.isPointerJustRelease) {
                    for (var3 = 0; var3 < this.gameNX.length; ++var3) {
                        if (var3 == 4) {
                            if (GameCanvas.gameAB(this.gameNX[var3], this.gameNY[var3], 84, 75) && GameCanvas.isPointerClick) {
                                gameHQ = 1;
                                gameBM = 4;
                                this.gameBI();
                                if (!GameCanvas.gameAH && super.center != null) {
                                    this.gameAB(super.center.idAction, super.center.p);
                                }
                            }
                        } else if (GameCanvas.gameAB(this.gameNX[var3], this.gameNY[var3], gameBL, gameBL) && GameCanvas.isPointerClick) {
                            gameHQ = 1;
                            gameBM = var3;
                            this.gameBI();
                            if (!GameCanvas.gameAH) {
                                if (currentCharViewInfo.arrItemMounts[gameBM] != null) {
                                    this.gameAB(super.center.idAction, super.center.p);
                                } else {
                                    gameDK = false;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private void gameCU() {
        if (gameMH) {
            if (gameHQ == 0) {
                if (GameCanvas.keyPressedz[8]) {
                    if (Char.clan == null) {
                        gameHQ = 0;
                    } else {
                        gameHQ = 1;
                    }

                    gameBM = 0;
                    indexRow = -1;
                    if (gameBP == 0) {
                        gameBM = Char.clan.itemLevel;
                    }

                    gameBU.gameAA();
                    gameBT.gameAA();
                }

                if (GameCanvas.keyPressedz[4]) {
                    gameBM = 0;
                    indexRow = -1;
                    --gameBP;
                    gameBU.gameAA();
                    gameBT.gameAA();
                    if (gameBP < 0) {
                        gameBP = mResources.gameRM.length - 1;
                    }

                    if (gameBP >= mResources.gameRM.length) {
                        gameBP = 0;
                    }

                    if (gameBP == 1 && gameMI) {
                        Service.gI().gameAX();
                        gameMI = false;
                    } else if (gameBP == 2) {
                        Service.gI().gameAY();
                    } else if (gameBP == 3) {
                        Service.gI().gameAZ();
                    } else if (gameBP == 4) {
                        Service.gI().gameAY();
                    }

                    setSize(175, 200);
                }

                if (GameCanvas.keyPressedz[6]) {
                    gameBM = 0;
                    indexRow = -1;
                    ++gameBP;
                    gameBU.gameAA();
                    gameBT.gameAA();
                    if (gameBP < 0) {
                        gameBP = mResources.gameRM.length - 1;
                    }

                    if (gameBP >= mResources.gameRM.length) {
                        gameBP = 0;
                    }

                    if (gameBP == 1 && gameMI) {
                        Service.gI().gameAX();
                        gameMI = false;
                    } else if (gameBP == 2) {
                        Service.gI().gameAY();
                    } else if (gameBP == 3) {
                        Service.gI().gameAZ();
                    } else if (gameBP == 4) {
                        Service.gI().gameAY();
                    }

                    setSize(175, 200);
                }

                this.gameCW();
            } else if (gameDK) {
                if (GameCanvas.keyPressedz[2]) {
                    if (--indexRow < 0) {
                        indexRow = gameBO - 1;
                    }

                    gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[8]) {
                    if (++indexRow >= gameBO) {
                        indexRow = 0;
                    }

                    gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                }
            } else {
                if (indexRow < 0) {
                    indexRow = 0;
                }

                if (gameBP == 2) {
                    if (Char.clan != null && Char.clan.items != null) {
                        if (GameCanvas.keyPressedz[4]) {
                            if (--gameBM < 0) {
                                gameBM = Char.clan.items.length - 1;
                            }
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (++gameBM >= Char.clan.items.length) {
                                gameBM = 0;
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (gameBM + gameTC <= Char.clan.items.length - 1) {
                                gameBM += gameTC;
                            }
                        } else if (GameCanvas.keyPressedz[2]) {
                            if (gameBM >= 0 && gameBM < gameTC) {
                                gameHQ = 0;
                                gameBM = 0;
                            } else if (gameBM - gameTC >= 0) {
                                gameBM -= gameTC;
                            }
                        }

                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    }
                } else if (gameBP == 0 && gameHQ == 1) {
                    if (GameCanvas.keyPressedz[8]) {
                        ++gameHQ;
                    } else if (GameCanvas.keyPressedz[2]) {
                        --gameHQ;
                    }
                } else if (gameBP == 4) {
                    if (GameCanvas.keyPressedz[2]) {
                        if (indexRow == 0) {
                            --gameHQ;
                            indexRow = -1;
                        } else {
                            --indexRow;
                        }

                        gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (++indexRow >= gameBO) {
                            indexRow = 0;
                        }

                        gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[4]) {
                        --this.gameUM;
                        if (this.gameUM < 0) {
                            this.gameUM = 0;
                        }
                    } else if (GameCanvas.keyPressedz[6]) {
                        ++this.gameUM;
                        if (this.gameUM > this.gameUN.size() - 1) {
                            this.gameUM = (byte) (this.gameUN.size() - 1);
                        }
                    }
                } else if (GameCanvas.keyPressedz[2]) {
                    if (indexRow == 0) {
                        --gameHQ;
                        indexRow = -1;
                    } else {
                        --indexRow;
                    }

                    gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                    if (gameBP == 1 && gameMI) {
                        Service.gI().gameAX();
                        gameMI = false;
                    }
                } else if (GameCanvas.keyPressedz[8]) {
                    if (++indexRow >= gameBO) {
                        indexRow = 0;
                    }

                    gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                }

                this.gameCW();
            }

            if (GameCanvas.isTouch && GameCanvas.currentDialog == null && !GameCanvas.menu.showMenu) {
                label367:
                {
                    if (GameCanvas.isPointerJustRelease) {
                        if (GameCanvas.gameAB(popupX, popupY, gameGC, this.gameTS) && (!gameDK || GameCanvas.w >= 320) && GameCanvas.isPointerClick) {
                            if (GameCanvas.gameAB(gameAD - 90, popupY + 5, 60, 40)) {
                                gameBM = 0;
                                --gameBP;
                                indexRow = 0;
                            }

                            if (GameCanvas.gameAB(gameAD + 20, popupY + 5, 60, 40)) {
                                gameBM = 0;
                                ++gameBP;
                                indexRow = 0;
                            }

                            gameDK = false;
                            gameBU.gameAA();
                            gameBT.gameAA();
                            if (gameBP < 0) {
                                gameBP = mResources.gameRM.length - 1;
                            }

                            if (gameBP > mResources.gameRM.length - 1) {
                                gameBP = 0;
                            }

                            gameHQ = 1;
                            if (gameBP == 1 && gameMI) {
                                Service.gI().gameAX();
                                gameMI = false;
                            } else if (gameBP == 2 && Char.clan != null && Char.clan.items == null) {
                                Service.gI().gameAY();
                            }

                            if (gameBP == 3) {
                                Service.gI().gameAZ();
                            }

                            if (gameBP == 4) {
                                Service.gI().gameAY();
                            }

                            setSize(175, 200);
                            this.gameCW();
                        }

                        if (gameBP == 4) {
                            int var1 = this.gameUW - this.gameUY / 2;
                            int var2 = this.gameUX - this.gameUY / 2;
                            int var3 = (this.gameUY + 5) * this.gameUN.size();
                            int var4 = this.gameUY;
                            if (GameCanvas.gameAB(var1, var2, var3, var4) && (var1 = (GameCanvas.px - var1) / (this.gameUY + 5)) >= 0 && var1 < this.gameUN.size()) {
                                this.gameUM = (byte) var1;
                            }
                        }
                    }

                    ScrollResult var5;
                    if (gameDK) {
                        if ((var5 = gameBT.gameAB()).isDowning || var5.isFinish) {
                            indexRow = var5.selected;
                            gameHQ = 1;
                        }

                        if (GameCanvas.gameAH) {
                            break label367;
                        }
                    }

                    if (gameBP == 2) {
                        if ((var5 = gameBU.gameAB()).isDowning || var5.isFinish) {
                            gameBM = var5.selected;
                            gameHQ = 1;
                            this.gameAB(1509, (Object) null);
                        }
                    } else if (gameBP == 0 && GameCanvas.gameAB(popupX + 18, popupY + 32, 5 * gameBL, gameBL) && GameCanvas.isPointerJustRelease && GameCanvas.isPointerClick) {
                        if (Char.clan != null) {
                            gameBM = Char.clan.itemLevel;
                            gameHQ = 1;
                        }
                    } else if (gameBP != 0 && gameBP != 3) {
                        if (gameBP == 1 && vClan.size() != 0 && ((var5 = gameBU.gameAB()).isDowning || var5.isFinish)) {
                            indexRow = var5.selected;
                            this.gameBB();
                        }
                    } else if (!gameDK && ((var5 = gameBU.gameAB()).isDowning || var5.isFinish)) {
                        indexRow = var5.selected;
                        gameHQ = gameBP == 0 ? 2 : 1;
                        if (var5.isFinish) {
                            gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                        }
                    }
                }
            }

            GameCanvas.gameAK();
            GameCanvas.gameAJ();
        }

    }

    private static Member gameCV() {
        return (Member) vClan.elementAt(indexRow);
    }

    private void gameCW() {
        if (!gameDK) {
            super.left = super.center = null;
            if (gameBP == 0) {
                if (Char.getMyChar().ctypeClan == 4) {
                    super.left = new Command(mResources.gameSY[0], 14004);
                }

                if (Char.getMyChar().ctypeClan == 3) {
                    super.left = new Command(mResources.gameSY[1], 14004);
                }

                if (Char.getMyChar().ctypeClan == 2) {
                    super.left = new Command(mResources.gameSY[2], 14004);
                }

                if (!Char.getMyChar().cClanName.equals("")) {
                    if (gameHQ == 1) {
                        super.center = new Command(mResources.gameCF, 140101);
                        return;
                    }

                    super.center = new Command(mResources.gameTA[3], 14010);
                    return;
                }
            } else {
                if (gameBP == 1) {
                    Member var1;
                    if (vClan.size() > 0 && indexRow >= 0 && indexRow < vClan.size() && (var1 = gameCV()) != null) {
                        if (Char.getMyChar().ctypeClan == 4) {
                            super.left = new Command(mResources.gameSY[0], 14005);
                        }

                        if (Char.getMyChar().ctypeClan == 3) {
                            super.left = new Command(mResources.gameSY[1], 14005);
                        }

                        if (Char.getMyChar().ctypeClan != 4 && Char.getMyChar().ctypeClan != 3) {
                            super.left = new Command(mResources.gameSY[4], 14005);
                        }

                        if (!var1.gameAD.equals(Char.getMyChar().cName) && (!gameHU || this.gameRH != 0)) {
                            super.center = new Command(mResources.SELECT, 14006, var1.gameAD);
                            return;
                        }
                    }

                    return;
                }

                if (gameBP == 2 && gameHQ == 1) {
                    if (Char.clan == null || Char.clan.items == null) {
                        return;
                    }

                    super.left = new Command(mResources.SELECT, 1508);
                    if (!GameCanvas.gameAI) {
                        super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 1509);
                    }
                }
            }
        }

    }

    private void gameCX() {
        if (gameDI && GameCanvas.currentDialog == null) {
            boolean var1 = false;
            if (GameCanvas.keyPressedz[8]) {
                if (++indexRow >= this.gameNC.size()) {
                    indexRow = 0;
                }

                var1 = true;
            } else if (GameCanvas.keyPressedz[2]) {
                if (--indexRow < 0) {
                    indexRow = this.gameNC.size() - 1;
                }

                var1 = true;
            }

            if (var1) {
                gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                GameCanvas.gameAK();
                GameCanvas.gameAJ();
            }

            ScrollResult var2;
            if (GameCanvas.isTouch && ((var2 = gameBU.gameAB()).isDowning || var2.isFinish)) {
                indexRow = var2.selected;
                var1 = true;
            }

            ChatTab var5;
            if (isPaintMessage && !GameCanvas.isTouch && (var5 = ChatManager.gameAD().gameAE()).type == 2 && indexRow == 0) {
                ChatTextField.gameAA().gameAF = new Command(mResources.gameBQ, 120051, var5);
            }

            if (var1 && indexRow >= 0 && indexRow < this.gameNC.size()) {
                String var7 = (String) this.gameNC.elementAt(indexRow);
                this.gameSY = null;
                this.gameSX = null;
                super.center = null;
                ChatTextField.gameAA().gameAF = null;
                int var6;
                if ((var6 = var7.indexOf("http://")) >= 0) {
                    this.gameSX = var7.substring(var6);
                    super.center = new Command(mResources.gameCA, 12000);
                    if (!GameCanvas.isTouch) {
                        ChatTextField.gameAA().gameAF = new Command(mResources.gameCA, (IActionListener) null, 12000, (Object) null);
                        return;
                    }
                } else if (var7.indexOf("@") >= 0) {
                    var6 = (var7 = var7.substring(2).trim()).indexOf("@");
                    String var3;
                    int var4;
                    if ((var4 = (var3 = var7.substring(var6)).indexOf(" ")) <= 0) {
                        var4 = var6 + var3.length();
                    } else {
                        var4 += var6;
                    }

                    this.gameSY = var7.substring(var6 + 1, var4);
                    if (!this.gameSY.equals("") && !this.gameSY.equals(Char.getMyChar().cName) && !this.gameSY.equals(mResources.gameVT.substring(0, 5)) && !this.gameSY.equals(mResources.gameVT)) {
                        super.center = new Command(mResources.SELECT, 12009, this.gameSY);
                        if (!GameCanvas.isTouch) {
                            ChatTextField.gameAA().gameAF = new Command(mResources.SELECT, (IActionListener) null, 12009, this.gameSY);
                            return;
                        }
                    } else {
                        this.gameSY = null;
                        super.center = null;
                    }
                }
            }
        }

    }

    private void gameCY() {
        if (isPaintMessage) {
            boolean var1 = false;
            if (GameCanvas.keyPressedz[4]) {
                var1 = true;
                ChatManager.gameAD().gameAB();
            } else if (GameCanvas.keyPressedz[6]) {
                var1 = true;
                ChatManager.gameAD().gameAA();
            }

            if (var1) {
                this.gameGJ();
            }

            if (GameCanvas.isTouch && GameCanvas.gameAB(popupX, popupY, gameGC, this.gameTS) && (!gameDK || GameCanvas.w >= 320) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                if (GameCanvas.gameAB(gameAD - 90, popupY + 5, 60, 40)) {
                    ChatManager.gameAD().gameAB();
                    this.gameGJ();
                }

                if (GameCanvas.gameAB(gameAD + 20, popupY + 5, 60, 40)) {
                    ChatManager.gameAD().gameAA();
                    this.gameGJ();
                }
            }
        }

    }

    private void gameCZ() {
        if (indexRow >= 0 && vCharInMap.size() > 0) {
            if (Char.gameAD(this.gameEH) == indexRow) {
                super.left = new Command(mResources.gameEW, 14002);
            } else {
                super.left = new Command(mResources.SELECT, 14003);
                super.center = new Command("", 14003);
            }
        } else {
            super.left = super.center = null;
        }
    }

    private void gameDA() {
        if (vList.size() > 0 && indexRow >= 0 && gameBO > 0) {
            super.center = new Command(mResources.gameBC, 14024);
            super.left = new Command(mResources.gameBD, 14025);
        } else {
            super.center = null;
            super.left = null;
        }
    }

    private void gameDB() {
        if (vList.size() > 0 && indexRow >= 0 && gameBO > 0) {
            super.center = new Command(mResources.SELECT, 14021);
        } else {
            super.center = null;
        }
    }

    private void gameDC() {
        if (vEnemies.size() > 0 && indexRow >= 0 && gameBO > 0) {
            super.center = new Command(mResources.SELECT, 11078);
        } else {
            super.center = null;
        }
    }

    private void gameDD() {
        if (vFriend.size() > 0 && indexRow >= 0 && gameBO > 0 && indexRow < vFriend.size()) {
            vFriend.elementAt(indexRow);
            super.center = new Command(mResources.SELECT, 11079);
        } else {
            super.center = null;
        }
    }

    private void gameDE() {
        super.center = null;
        if (indexRow != -1) {
            Party var1;
            if (((Party) vParty.elementAt(0)).charId == Char.getMyChar().charID) {
                if ((var1 = (Party) vParty.elementAt(indexRow)).charId != Char.getMyChar().charID) {
                    super.center = new Command(mResources.SELECT, 11080, var1.name);
                    return;
                }
            } else if ((var1 = (Party) vParty.elementAt(indexRow)).charId != Char.getMyChar().charID) {
                super.center = new Command(mResources.SELECT, 12009, var1.name);
            }
        }

    }

    private static boolean gameDF() {
        return gameHX || gameAQ || gameMJ || gameDK || gameDL || gameKE || gameKF || gameMK || gameKU || gameKG || gameKH || gameKI || gameKJ || gameKK || gameKL || gameKM || gameKN || gameKO || gameKP || gameKQ || gameKR || gameKS || gameKT || gameKV || gameKW || gameKX || gameKY || gameKZ || gameDH || gameMA || gameME || gameMM || gameMN || gameMC || gameML || gameMD || gameVH || itemDell || itemThow || isPaintTrade || gameDI || gameMG || gameDN || gameHZ || gameMH || gameKA || gameHY || gameDJ || gameKB || gameKC || gameMF || isPaintMessage || gameMS || gameMO || gameMP || gameMT || gameMQ || gameMR;
    }

    private boolean gameDG() {
        if (!GameCanvas.isTouch || Char.gameGL || gameMG || gameDN || ChatTextField.gameAA().isShow || super.center == this.gameGH && GameCanvas.gameAI) {
            return true;
        } else {
            return GameCanvas.currentDialog != null || ChatPopup.currentMultilineChatPopup != null || GameCanvas.menu.showMenu || gameDF();
        }
    }

    public static boolean gameAZ() {
        return gameDN || gameKE || gameMJ || gameKF || gameKU || gameKG || gameKH || gameKI || gameKJ || gameKK || gameKL || gameKM || gameKN || gameKO || gameKP || gameKQ || gameKR || gameKS || gameKT || gameKV || gameKW || gameKX || gameKY || gameKZ || gameMK || gameDH || gameMA || gameME || gameMM || gameMN || gameMC || gameML || gameMD || gameVH || itemDell || itemThow || isPaintTrade || gameMO || gameMP || gameMT || gameMQ || gameMR;
    }

    private static boolean gameDH() {
        return gameDN || gameAQ || gameDK || gameMJ || gameDL || gameKE || gameKF || gameKU || gameKG || gameKH || gameKI || gameKJ || gameKK || gameKL || gameKM || gameKN || gameKO || gameKP || gameKQ || gameKR || gameKS || gameKT || gameKV || gameKW || gameKX || gameKY || gameKZ || gameMK || gameDH || gameMA || gameME || gameMM || gameMN || gameMC || gameML || gameMD || gameVH || itemDell || itemThow || isPaintTrade || gameMO || gameMP || gameMT || gameMQ || gameMR;
    }

    private static boolean gameDI() {
        return gameHX || gameAQ || gameDL && gameBP > 0 && gameBP < 5 || gameDN || gameMG || gameMH && (gameBP == 0 || gameBP == 1 || gameBP == 3 || gameBP == 4) || gameMF || gameHZ || gameKA || gameDJ || gameKB || gameKC || gameHY || isPaintMessage || gameDI || gameMS;
    }

    private static void gameAA(Item var0) {
        Command var1 = new Command(mResources.ACCEPT, 11055, var0);
        GameCanvas.inputDlg.gameAA(mResources.gamePC, var1, 1);
    }

    private static void gameAB(Item var0) {
        if (var0.upgrade > 0 && var0.gameAB()) {
            GameCanvas.msgdlg.gameAA(mResources.gamePS, (Command) null, new Command(mResources.CLOSE, 110561), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else if (var0.quantity > 1) {
            Command var1 = new Command(mResources.ACCEPT, 110562, var0);
            GameCanvas.inputDlg.gameAA(mResources.gamePC, var1, 1);
        } else {
            GameCanvas.gameAA(mResources.gamePM, new Command(mResources.YES, 11061, var0), new Command(mResources.NO, 1));
        }
    }

    private static void gameDJ() {
        Command var0 = new Command(mResources.ACCEPT, 11042);
        GameCanvas.inputDlg.gameAA(mResources.gamePB, var0, 1);
    }

    private static void gameDK() {
        Command var0 = new Command(mResources.ACCEPT, 110361);
        GameCanvas.inputDlg.gameAA(mResources.gamePB, var0, 1);
    }

    private static void gameDL() {
        Command var0 = new Command(mResources.ACCEPT, 11043);
        GameCanvas.inputDlg.gameAA(mResources.gamePB, var0, 1);
    }

    public final void gameBA() {
        if (GameCanvas.currentDialog == null && gameAZ()) {
            int var1;
            int var2;
            int var3;
            if (gameHQ == 0) {
                GameScr var8 = this;
                super.left = super.center = null;
                if (!gameMJ) {
                    if (gameMD) {
                        if (gameBP == 0) {
                            super.left = new Command(mResources.gameBI, 11115);
                        } else if (gameBP == 1) {
                            super.left = new Command(mResources.gameBI, 11116);
                        }
                    } else if (gameBP == 1 && isPaintTrade && this.gameEC == 0) {
                        super.left = this.gameRU;
                    } else if (gameBP == 1 && !gameKE && !gameKF && !gameMC && !gameML && !gameKZ && !gameMA && !gameME && !gameMM && !gameMN && !isPaintTrade && !gameMK && !gameDH && !gameMO && !gameMP && !gameMT && !gameMQ && !gameMR) {
                        super.left = new Command(mResources.gameCL, 110221);
                    }

                    if (gameML && gameBP == 0) {
                        var1 = 0;
                        var2 = 0;
                        var3 = 0;
                        short var5 = 0;

                        for (int var6 = 0; var6 < gameCT.length; ++var6) {
                            Item var7;
                            if ((var7 = gameCT[var6]) != null) {
                                if (var7.template.id == 455) {
                                    ++var1;
                                } else if (var7.template.id == 456) {
                                    ++var2;
                                } else if (var7.template.type == 26) {
                                    ++var3;
                                    var5 = var7.template.id;
                                }
                            }
                        }

                        if (var1 >= 9 || var2 >= 9 || var5 >= 10 && var1 >= 3 && var3 == 1 || var5 >= 11 && var2 >= 3 && var3 == 1) {
                            super.left = new Command(mResources.gameGC, 1600);
                        }
                    }

                    if (gameMC && gameBP == 0) {
                        var1 = 0;

                        for (var2 = 0; var2 < gameCT.length; ++var2) {
                            if (gameCT[var2] != null) {
                                ++var1;
                                if (var1 >= 2) {
                                    super.left = new Command(mResources.gameGC, 11062);
                                    break;
                                }
                            }
                        }
                    }

                    if (gameKZ && gameBP == 0 && arritemup != null) {
                        for (var1 = 0; var1 < upitem.length; ++var1) {
                            if (upitem[var1] != null) {
                                super.center = new Command("", 110981);
                                super.left = new Command(mResources.gameGC, 110981);
                                break;
                            }
                        }
                    }

                    if (gameMP && gameBP == 0 && arritemup != null && gameDD != null) {
                        for (var1 = 0; var1 < upitem.length; ++var1) {
                            if (upitem[var1] != null) {
                                super.center = new Command("", 341);
                                super.left = new Command(mResources.gameGC, 341);
                                break;
                            }
                        }
                    }

                    if (gameDH && gameBP == 0 && gameDE != null && this.gameNE != null && !this.gameNE.gameAD().equals("") && Char.getMyChar().xu >= 5000) {
                        super.left = new Command(mResources.gameCW, 15002);
                    }

                    if (gameMA && gameBP == 0 && gameHQ == 0) {
                        for (var1 = 0; var1 < gameCY.length; ++var1) {
                            if (gameCY[var1] == null) {
                                var8.left = null;
                                break;
                            }

                            if (var1 == gameCY.length - 1) {
                                var8.left = new Command(mResources.gameGC, 140131);
                            }
                        }
                    }

                    if (gameME && gameBP == 0 && gameDD != null && gameDD.upgrade > 0) {
                        var8.left = new Command(mResources.gameGC, 11105);
                    }

                    if (isPaintTrade && gameBP == 0) {
                        if (var8.gameEC == 0) {
                            var8.left = var8.gameRM;
                        } else if (var8.gameEC == 1 && var8.typeTradeOrder > 0 && (long) var8.gameEG - System.currentTimeMillis() / 1000L <= 0L) {
                            var8.left = var8.gameRN;
                        }
                    }

                    if (GameCanvas.keyPressedz[8]) {
                        gameHQ = 1;
                        gameBM = 0;
                        indexRow = -1;
                        gameBU.gameAA();
                        gameBT.gameAA();
                        var8.gameBB();
                    }

                    if (GameCanvas.keyPressedz[4]) {
                        gameBM = 0;
                        indexRow = -1;
                        --gameBP;
                        gameBU.gameAA();
                        gameBT.gameAA();
                        if (gameMK) {
                            if (gameBP < 0) {
                                gameBP = mResources.gameVS.length - 1;
                            }

                            Service.gI().gameAC(28, 0, gameBP);
                            arrItemStands = null;
                            gameBM = -1;
                        } else if (!gameKF && !gameDN) {
                            if (gameBP < 0) {
                                if (gameKE) {
                                    gameBP = mResources.gameHI.length - 1;
                                } else {
                                    gameBP = 1;
                                }
                            }
                        } else {
                            gameBP = 0;
                        }

                        var8.left = var8.center = null;
                        if (gameKE) {
                            gameDN();
                        }

                        if (gameKF && gameCP == null && gameBP == 0) {
                            Service.gI().gameAI(35);
                        }
                    }

                    if (GameCanvas.keyPressedz[6]) {
                        gameBM = 0;
                        indexRow = -1;
                        ++gameBP;
                        gameBU.gameAA();
                        gameBT.gameAA();
                        if (gameMK) {
                            if (gameBP > mResources.gameVS.length - 1) {
                                gameBP = 0;
                            }

                            Service.gI().gameAC(28, 0, gameBP);
                            arrItemStands = null;
                            gameBM = -1;
                        } else {
                            label1475:
                            {
                                if (!gameKF && !gameDN) {
                                    if (gameKE) {
                                        if (gameBP <= mResources.gameHI.length - 1) {
                                            break label1475;
                                        }
                                    } else if (gameBP <= 1) {
                                        break label1475;
                                    }
                                }

                                gameBP = 0;
                            }
                        }

                        var8.left = var8.center = null;
                        if (gameKE) {
                            gameDN();
                        }

                        if (gameKF && gameCP == null && gameBP == 0) {
                            Service.gI().gameAI(35);
                        }
                    }
                }
            } else if (gameHQ > 0) {
                if (gameDK) {
                    if (GameCanvas.keyPressedz[2]) {
                        if (--indexRow < 0) {
                            indexRow = gameBO - 1;
                        }

                        gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (++indexRow >= gameBO) {
                            indexRow = 0;
                        }

                        gameBT.gameAA(indexRow * gameBT.ITEM_SIZE);
                    }
                } else {
                    if (gameDN) {
                        if (GameCanvas.keyPressedz[2]) {
                            if (--indexRow < 0) {
                                indexRow = gameBO;
                            }

                            gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                        } else if (GameCanvas.keyPressedz[4]) {
                            if (indexRow == 0) {
                                if (Char.aHpValue <= 10) {
                                    if (--Char.aHpValue <= 0) {
                                        Char.aHpValue = 1;
                                    }
                                } else {
                                    Char.aHpValue -= 10;
                                }
                            } else if (indexRow == 1) {
                                if (Char.aMpValue <= 10) {
                                    if (--Char.aMpValue <= 0) {
                                        Char.aMpValue = 1;
                                    }
                                } else {
                                    Char.aMpValue -= 10;
                                }
                            } else if (indexRow == 2) {
                                if ((Char.CapFood -= 10) <= 0) {
                                    Char.CapFood = 1;
                                }
                            } else if (indexRow == 8) {
                                if ((Char.CapHpMp -= 20) <= 0) {
                                    Char.CapHpMp = 1;
                                }
                            } else if (indexRow == 9) {
                                if (--Char.CapNhatDa <= 0) {
                                    Char.CapNhatDa = 1;
                                }
                            } else if (indexRow == 10) {
                                if (--Char.LuyenDaMax <= 4) {
                                    Char.LuyenDaMax = 4;
                                }
                            } else if (indexRow == 11 && (Char.CapTrangBi -= 10) <= 0) {
                                Char.CapTrangBi = 1;
                            }
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (indexRow == 0) {
                                if (Char.aHpValue >= 90) {
                                    if (++Char.aHpValue >= 100) {
                                        Char.aHpValue = 99;
                                    }
                                } else {
                                    Char.aHpValue += 10;
                                }
                            } else if (indexRow == 1) {
                                if (Char.aMpValue >= 90) {
                                    if (++Char.aMpValue >= 100) {
                                        Char.aMpValue = 99;
                                    }
                                } else {
                                    Char.aMpValue += 10;
                                }
                            } else if (indexRow == 2) {
                                if (Char.CapFood == 1) {
                                    Char.CapFood = 10;
                                } else if ((Char.CapFood += 10) > 70) {
                                    Char.CapFood = 70;
                                }
                            } else if (indexRow == 8) {
                                if (Char.CapHpMp == 1) {
                                    Char.CapHpMp = 10;
                                } else if ((Char.CapHpMp += 20) > 70) {
                                    Char.CapHpMp = 70;
                                }
                            } else if (indexRow == 9) {
                                if (++Char.CapNhatDa > 7) {
                                    Char.CapNhatDa = 7;
                                }
                            } else if (indexRow == 10) {
                                if (++Char.LuyenDaMax > 12) {
                                    Char.LuyenDaMax = 12;
                                }
                            } else if (indexRow == 11) {
                                if (Char.CapTrangBi == 1) {
                                    Char.CapTrangBi = 10;
                                } else if ((Char.CapTrangBi += 10) > 70) {
                                    Char.CapTrangBi = 70;
                                }
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (++indexRow > gameBO) {
                                indexRow = 0;
                            }

                            gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
                        }

                        if (!GameCanvas.isTouch) {
                            GameCanvas.gameAK();
                            GameCanvas.gameAJ();
                        }
                    } else if (isPaintTrade && gameBP == 0) {
                        if (gameHQ == 1) {
                            if (GameCanvas.keyPressedz[4]) {
                                if (--gameBM < 0) {
                                    gameBM = 11;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            } else if (GameCanvas.keyPressedz[6]) {
                                if (gameBM == 2) {
                                    gameHQ = 2;
                                    gameBM = 0;
                                } else if (gameBM == 5) {
                                    gameHQ = 2;
                                    gameBM = 3;
                                } else if (gameBM == 8) {
                                    gameHQ = 2;
                                    gameBM = 6;
                                } else if (gameBM == 11) {
                                    gameHQ = 2;
                                    gameBM = 9;
                                } else if (gameBM == 14) {
                                    gameHQ = 2;
                                    gameBM = 12;
                                } else if (++gameBM >= 12) {
                                    gameBM = 0;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            } else if (GameCanvas.keyPressedz[8]) {
                                if (gameBM + 3 <= 11) {
                                    gameBM += 3;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (gameBM >= 0 && gameBM < 3) {
                                    gameHQ = 0;
                                    gameBM = 0;
                                } else if (gameBM - 3 >= 0) {
                                    gameBM -= 3;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            }
                        } else if (gameHQ == 2) {
                            if (GameCanvas.keyPressedz[4]) {
                                if (gameBM == 0) {
                                    gameHQ = 1;
                                    gameBM = 2;
                                } else if (gameBM == 3) {
                                    gameHQ = 1;
                                    gameBM = 5;
                                } else if (gameBM == 6) {
                                    gameHQ = 1;
                                    gameBM = 8;
                                } else if (gameBM == 9) {
                                    gameHQ = 1;
                                    gameBM = 11;
                                } else if (gameBM == 12) {
                                    gameHQ = 1;
                                    gameBM = 14;
                                } else if (--gameBM < 0) {
                                    gameBM = 11;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            } else if (GameCanvas.keyPressedz[6]) {
                                if (++gameBM >= 12) {
                                    gameBM = 0;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            } else if (GameCanvas.keyPressedz[8]) {
                                if (gameBM + 3 <= 11) {
                                    gameBM += 3;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (gameBM >= 0 && gameBM < 3) {
                                    gameHQ = 0;
                                    gameBM = 0;
                                } else if (gameBM - 3 >= 0) {
                                    gameBM -= 3;
                                }

                                super.left = super.center = null;
                                this.gameBB();
                            }
                        }

                        if (!GameCanvas.isTouch) {
                            GameCanvas.gameAK();
                            GameCanvas.gameAJ();
                        }
                    } else if (gameMJ) {
                        if (GameCanvas.keyPressedz[4]) {
                            if (--gameBM < 0) {
                                gameBM = 8;
                            }
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (++gameBM > 8) {
                                gameBM = 0;
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (gameBM + 3 < 9) {
                                gameBM += 3;
                            }
                        } else if (GameCanvas.keyPressedz[2] && gameBM - 3 >= 0) {
                            gameBM -= 3;
                        }

                        if (!GameCanvas.isTouch) {
                            GameCanvas.gameAK();
                            GameCanvas.gameAJ();
                        }
                    } else if (gameDH && gameBP == 0) {
                        if (GameCanvas.keyPressedz[2]) {
                            if (--gameHQ < 0) {
                                gameHQ = 0;
                            }
                        } else if (GameCanvas.keyPressedz[8] && ++gameHQ > 2) {
                            gameHQ = 2;
                        }

                        this.gameBB();
                    } else if (gameMK) {
                        if (GameCanvas.keyPressedz[4]) {
                            if (arrItemStands != null) {
                                if ((gameBM -= 5) < 0) {
                                    gameBM = arrItemStands.length - 1;
                                }

                                gameBU.gameAA(gameBM * gameBU.ITEM_SIZE);
                                this.gameBB();
                            }
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (arrItemStands != null) {
                                if ((gameBM += 5) >= arrItemStands.length) {
                                    gameBM = 0;
                                }

                                gameBU.gameAA(gameBM * gameBU.ITEM_SIZE);
                                this.gameBB();
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (arrItemStands != null) {
                                if (++gameBM >= arrItemStands.length) {
                                    gameBM = 0;
                                }

                                gameBU.gameAA(gameBM * gameBU.ITEM_SIZE);
                                this.gameBB();
                            }
                        } else if (GameCanvas.keyPressedz[2] && arrItemStands != null) {
                            if (--gameBM < 0) {
                                gameHQ = 0;
                            }

                            gameBU.gameAA(gameBM * gameBU.ITEM_SIZE);
                            this.gameBB();
                        }

                        GameCanvas.gameAK();
                        GameCanvas.gameAJ();
                    } else if ((gameMT || gameMP || gameKZ || gameMA) && gameHQ == 1 && gameBP == 0) {
                        if (GameCanvas.keyPressedz[4]) {
                            if (--gameBM < 0) {
                                gameBM = 1;
                            }

                            super.left = super.center = null;
                            this.gameBB();
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (++gameBM > 1) {
                                gameBM = 0;
                            }

                            super.left = super.center = null;
                            this.gameBB();
                        } else if (GameCanvas.keyPressedz[8]) {
                            gameHQ = 2;
                            gameBM = 0;
                            super.left = super.center = null;
                            this.gameBB();
                        } else if (GameCanvas.keyPressedz[2]) {
                            gameHQ = 0;
                            gameBM = 0;
                            super.left = super.center = null;
                            this.gameBB();
                        }

                        if (!GameCanvas.isTouch) {
                            GameCanvas.gameAK();
                            GameCanvas.gameAJ();
                        }
                    } else if ((gameME || gameMM || gameMN || gameMO) && gameHQ == 1 && gameBP == 0) {
                        if (GameCanvas.keyPressedz[8]) {
                            gameHQ = 2;
                            gameBM = 0;
                            super.left = super.center = null;
                            this.gameBB();
                        } else if (GameCanvas.keyPressedz[2]) {
                            gameHQ = 0;
                            gameBM = 0;
                            super.left = super.center = null;
                            this.gameBB();
                        }

                        GameCanvas.gameAK();
                        GameCanvas.gameAJ();
                    } else if ((gameMQ || gameMR) && gameBP == 0) {
                        if (GameCanvas.keyPressedz[2]) {
                            if (--gameHQ < 0) {
                                gameHQ = 0;
                            }
                        } else if (GameCanvas.keyPressedz[8] && ++gameHQ > 1) {
                            gameHQ = 1;
                        }

                        this.gameBB();
                    }

                    int var4 = gameDM();
                    if (GameCanvas.keyPressedz[4]) {
                        if (--gameBM < 0) {
                            gameBM = var4 - 1;
                        }

                        super.left = super.center = null;
                        this.gameBB();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[6]) {
                        if (++gameBM >= var4) {
                            gameBM = 0;
                        }

                        super.left = super.center = null;
                        this.gameBB();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (gameBM + gameTC <= var4 - 1) {
                            gameBM += gameTC;
                        }

                        super.left = super.center = null;
                        this.gameBB();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[2]) {
                        if (gameBM >= 0 && gameBM < gameTC) {
                            gameHQ = 0;
                            gameBM = 0;
                            if ((gameMP || gameKZ || gameME || gameMM || gameMN || gameMA || gameMO) && gameBP == 0) {
                                gameHQ = 1;
                            }
                        } else if (gameBM - gameTC >= 0) {
                            gameBM -= gameTC;
                        }

                        super.left = super.center = null;
                        this.gameBB();
                        gameBU.gameAA(gameBM / gameTC * gameBU.ITEM_SIZE);
                    }
                }
            }

            if (GameCanvas.isTouch && !GameCanvas.menu.showMenu && GameCanvas.currentDialog == null) {
                label1717:
                {
                    if (GameCanvas.isPointerJustRelease && GameCanvas.gameAB(popupX, popupY, gameGC, this.gameTS) && (!gameDK || GameCanvas.w >= 320) && GameCanvas.isPointerClick) {
                        if (GameCanvas.gameAB(gameAD - 80, popupY + 5, 60, 40)) {
                            gameBM = 0;
                            --gameBP;
                            this.gameBB();
                        }

                        if (GameCanvas.gameAB(gameAD + 10, popupY + 5, 60, 40)) {
                            gameBM = 0;
                            ++gameBP;
                            this.gameBB();
                        }

                        gameHQ = 0;
                        if (!gameAZ()) {
                            if (gameBP < 0) {
                                gameBP = mResources.gameGN.length - 1;
                            }

                            if (gameBP > mResources.gameGN.length - 1) {
                                gameBP = 0;
                            }
                        } else {
                            if (gameKE) {
                                if (gameBP < 0) {
                                    gameBP = mResources.gameHI.length - 1;
                                } else if (gameBP > mResources.gameHI.length - 1) {
                                    gameBP = 0;
                                }

                                gameDN();
                            } else if (gameMK) {
                                if (gameBP < 0) {
                                    gameBP = mResources.gameVS.length - 1;
                                } else if (gameBP > mResources.gameVS.length - 1) {
                                    gameBP = 0;
                                }

                                Service.gI().gameAC(28, 0, gameBP);
                                gameBM = -1;
                            } else {
                                label1442:
                                {
                                    if (!gameKF && !gameDN) {
                                        if (gameBP < 0) {
                                            gameBP = 1;
                                            break label1442;
                                        }

                                        if (gameBP <= 1) {
                                            break label1442;
                                        }
                                    }

                                    gameBP = 0;
                                }
                            }

                            if (gameKF) {
                                gameBP = 0;
                            }
                        }

                        gameDK = false;
                        gameBU.gameAA();
                    }

                    ScrollResult var9;
                    if (gameDK) {
                        if ((var9 = gameBT.gameAB()).isDowning || var9.isFinish) {
                            indexRow = var9.selected;
                            gameHQ = 1;
                        }

                        if (!GameCanvas.gameAI) {
                            break label1717;
                        }
                    }

                    if (gameDN) {
                        if (((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                            gameHQ = 1;
                            indexRow = var9.selected;
                            this.gameBB();
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 5, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DungHp = !Char.DungHp;
                            if (gameFD == 1) {
                                Char.DungHp = false;
                                InfoMe.gameAA(mResources.gameWL, 20, mFont.tahoma_7_yellow);
                            }

                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 35, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DungMp = !Char.DungMp;
                            if (gameFD == 1) {
                                Char.DungMp = false;
                                InfoMe.gameAA(mResources.gameWL, 20, mFont.tahoma_7_yellow);
                            }

                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 65, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DungFood = !Char.DungFood;
                            if (gameFD == 1) {
                                Char.DungFood = false;
                                InfoMe.gameAA(mResources.gameWL, 20, mFont.tahoma_7_yellow);
                            }

                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 95, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DungHoTro = !Char.DungHoTro;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 125, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.KhienMana = !Char.KhienMana;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 155, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DotQuai = !Char.DotQuai;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 185, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DungPhanThan = !Char.DungPhanThan;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 215, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatYen = !Char.NhatYen;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatYen) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 245, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatHpMp = !Char.NhatHpMp;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatHpMp) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 275, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatDa = !Char.NhatDa;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatDa) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 305, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.LuyenDa = !Char.LuyenDa;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 335, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatTrangBi = !Char.NhatTrangBi;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatTrangBi) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 365, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatTbLa = !Char.NhatTbLa;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatTbLa) {
                                Char.NhatTrangBi = true;
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 395, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatVpNV = !Char.NhatVpNV;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatVpNV) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 425, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatVpSk = !Char.NhatVpSk;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatVpSk) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 455, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatAll = !Char.NhatAll;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatAll) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 485, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NhatSvc = !Char.NhatSvc;
                            GameCanvas.isPointerDown = false;
                            if (Char.NhatSvc) {
                                Char.KhongNhat = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 515, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.KhongNhat = !Char.KhongNhat;
                            GameCanvas.isPointerDown = false;
                            if (Char.KhongNhat) {
                                Char.NhatDa = false;
                                Char.NhatHpMp = false;
                                Char.NhatYen = false;
                                Char.NhatTrangBi = false;
                                Char.NhatTbLa = false;
                                Char.NhatVpNV = false;
                                Char.NhatVpSk = false;
                                Char.NhatAll = false;
                                Char.NhatSvc = false;
                            }
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 545, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.LuyenTTT = !Char.LuyenTTT;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 575, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.LuyenTTC = !Char.LuyenTTC;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 605, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.ReMap = !Char.ReMap;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 635, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.TsMapTrong = !Char.TsMapTrong;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 665, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.AutoMuaFood = !Char.AutoMuaFood;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 695, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DieHetMp = !Char.DieHetMp;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 725, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.ReConnect = !Char.ReConnect;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 755, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.ChuyenMapHetQuai = !Char.ChuyenMapHetQuai;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 785, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.SanTaTl = !Char.SanTaTl;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 815, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DanhQuai = !Char.DanhQuai;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 845, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DanhTA = !Char.DanhTA;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 875, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DanhTL = !Char.DanhTL;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 905, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.CongTN = !Char.CongTN;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 935, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.CongKN = !Char.CongKN;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 965, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DanhNhom = !Char.DanhNhom;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 995, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.NePk = !Char.NePk;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 1025, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.DungCoLenh = !Char.DungCoLenh;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 16, gameBU.yPos + 1055, 16, 16, gameBU) && GameCanvas.isPointerClick) {
                            Char.MuaCoLenh = !Char.MuaCoLenh;
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 131, gameBU.yPos + 2, 30, 20, gameBU) && GameCanvas.isPointerClick && Char.DungHp) {
                            GameCanvas.inputDlg.gameAA(mResources.gameWI, new Command(mResources.OK, 1511), 1);
                            GameCanvas.isPointerDown = false;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 131, gameBU.yPos + 32, 30, 20, gameBU) && GameCanvas.isPointerClick && Char.DungMp) {
                            GameCanvas.inputDlg.gameAA(mResources.gameWI, new Command(mResources.OK, 1512), 1);
                            GameCanvas.isPointerDown = false;
                        }

                        MyVector var11;
                        if (GameCanvas.gameAA(gameBU.xPos + 131, gameBU.yPos + 62, 30, 20, gameBU) && GameCanvas.isPointerClick && Char.DungFood) {
                            (var11 = new MyVector()).addElement(new Command(mResources.gameWJ[0], 15130));
                            var11.addElement(new Command(mResources.gameWJ[1], 15131));
                            var11.addElement(new Command(mResources.gameWJ[2], 15132));
                            var11.addElement(new Command(mResources.gameWJ[3], 15133));
                            var11.addElement(new Command(mResources.gameWJ[4], 15134));
                            var11.addElement(new Command(mResources.gameWJ[5], 15135));
                            var11.addElement(new Command(mResources.gameWJ[6], 15136));
                            var11.addElement(new Command(mResources.gameWJ[7], 15137));
                            GameCanvas.menu.gameAA(var11);
                            GameCanvas.menu.gameAC = true;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 131, gameBU.yPos + 242, 30, 20, gameBU) && GameCanvas.isPointerClick && Char.NhatHpMp) {
                            (var11 = new MyVector()).addElement(new Command(mResources.gameWJ[0], 15150));
                            var11.addElement(new Command(mResources.gameWJ[1], 15151));
                            var11.addElement(new Command(mResources.gameWJ[3], 15153));
                            var11.addElement(new Command(mResources.gameWJ[5], 15155));
                            var11.addElement(new Command(mResources.gameWJ[7], 15157));
                            GameCanvas.menu.gameAA(var11);
                            GameCanvas.menu.gameAC = true;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 131, gameBU.yPos + 272, 30, 20, gameBU) && GameCanvas.isPointerClick && Char.NhatDa) {
                            (var11 = new MyVector()).addElement(new Command(mResources.gameWK[0], 15161));
                            var11.addElement(new Command(mResources.gameWK[1], 15162));
                            var11.addElement(new Command(mResources.gameWK[2], 15163));
                            var11.addElement(new Command(mResources.gameWK[3], 15164));
                            var11.addElement(new Command(mResources.gameWK[4], 15165));
                            var11.addElement(new Command(mResources.gameWK[5], 15166));
                            var11.addElement(new Command(mResources.gameWK[6], 15167));
                            GameCanvas.menu.gameAA(var11);
                            GameCanvas.menu.gameAC = true;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 131, gameBU.yPos + 302, 30, 20, gameBU) && GameCanvas.isPointerClick && Char.LuyenDa) {
                            (var11 = new MyVector()).addElement(new Command(mResources.gameWK[3], 15174));
                            var11.addElement(new Command(mResources.gameWK[4], 15175));
                            var11.addElement(new Command(mResources.gameWK[5], 15176));
                            var11.addElement(new Command(mResources.gameWK[6], 15177));
                            var11.addElement(new Command(mResources.gameWK[7], 15178));
                            var11.addElement(new Command(mResources.gameWK[8], 15179));
                            var11.addElement(new Command(mResources.gameWK[9], 151710));
                            var11.addElement(new Command(mResources.gameWK[10], 151711));
                            var11.addElement(new Command(mResources.gameWK[11], 151712));
                            GameCanvas.menu.gameAA(var11);
                            GameCanvas.menu.gameAC = true;
                        }

                        if (GameCanvas.gameAA(gameBU.xPos + 131, gameBU.yPos + 332, 30, 20, gameBU) && GameCanvas.isPointerClick && Char.NhatTrangBi) {
                            (var11 = new MyVector()).addElement(new Command(mResources.gameWJ[0], 15130));
                            var11.addElement(new Command(mResources.gameWJ[1], 15141));
                            var11.addElement(new Command(mResources.gameWJ[2], 15142));
                            var11.addElement(new Command(mResources.gameWJ[3], 15143));
                            var11.addElement(new Command(mResources.gameWJ[4], 15144));
                            var11.addElement(new Command(mResources.gameWJ[5], 15145));
                            var11.addElement(new Command(mResources.gameWJ[6], 15146));
                            var11.addElement(new Command(mResources.gameWJ[7], 15147));
                            GameCanvas.menu.gameAA(var11);
                            GameCanvas.menu.gameAC = true;
                        }
                    } else if (!gameKF && !gameKE && !gameMD && !gameVH && !itemDell && !itemThow && !gameKX && !gameKY && !gameKV && !gameKW && !gameKG && !gameKH && !gameKI && !gameKJ && !gameKK && !gameKL && !gameKM && !gameKN && !gameKO && !gameKP && !gameKU && !gameKQ && !gameKR && !gameKS && !gameKT) {
                        if (isPaintTrade) {
                            if (gameBP == 0) {
                                this.gameAA(popupX + 4, popupY + this.gameTS + 15, 3, 4, 1);
                                this.gameAA(popupX + gameGC - 3 - 3 * gameBL, popupY + this.gameTS + 15, 3, 4, 2);
                            } else if (gameBP == 1 && ((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                                gameHQ = 1;
                                gameBM = var9.selected;
                                this.gameBB();
                            }
                        } else if (!gameMC && !gameML) {
                            if (!gameME && !gameMM && !gameMN && !gameMO) {
                                if (!gameKZ && !gameMA && !gameMP) {
                                    if (gameMT) {
                                        if (gameBP == 0) {
                                            if (((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                                                gameHQ = 1;
                                                gameBM = var9.selected;
                                                super.left = super.center = null;
                                                gameDK = false;
                                                this.gameBB();
                                            }
                                        } else if (gameBP == 1 && ((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                                            gameHQ = 1;
                                            gameBM = var9.selected;
                                            this.gameBB();
                                        }
                                    } else if (gameDH) {
                                        if (gameBP == 0) {
                                            if (GameCanvas.gameAB(popupX + 75, popupY + 69, gameBL, gameBL)) {
                                                if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                                    gameHQ = 1;
                                                    this.gameBB();
                                                }
                                            } else if (GameCanvas.gameAB(this.gameNE.x, this.gameNE.y, this.gameNE.width, this.gameNE.height) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                                gameHQ = 2;
                                                this.gameNE.gameAA();
                                                this.gameBB();
                                            }
                                        } else if (gameBP == 1 && ((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                                            gameHQ = 1;
                                            gameBM = var9.selected;
                                            this.gameBB();
                                        }
                                    } else if (gameMJ) {
                                        if (GameCanvas.gameAB(gameGA, gameGB, 120, 120) && GameCanvas.isPointerJustRelease && GameCanvas.isPointerClick) {
                                            gameBM = (GameCanvas.pxLast - gameGA) / 40 + (GameCanvas.pyLast - gameGB) / 40 * 3;
                                            gameHQ = 1;
                                            this.gameBB();
                                            this.gameDX();
                                        }
                                    } else if (gameMQ || gameMR) {
                                        if (gameBP == 0) {
                                            if (GameCanvas.gameAB(popupX + 75, popupY + 69, gameBL, gameBL) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                                gameHQ = 1;
                                                this.gameBB();
                                            }
                                        } else if (gameBP == 1 && ((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                                            gameHQ = 1;
                                            gameBM = var9.selected;
                                            this.gameBB();
                                        }
                                    }
                                } else if (gameBP == 0) {
                                    var1 = popupX + 45;
                                    var2 = popupY + 32;
                                    var3 = popupX + 100;
                                    if (GameCanvas.isPointerJustRelease) {
                                        if (GameCanvas.gameAB(var1, var2, 29, 29)) {
                                            gameHQ = 1;
                                            gameBM = 0;
                                            this.gameBB();
                                        }

                                        if (GameCanvas.gameAB(var3, var2, 29, 29)) {
                                            gameHQ = 1;
                                            gameBM = 1;
                                            this.gameBB();
                                            if (gameMC && gameBP == 0) {
                                                for (int var10 = 0; var10 < gameCT.length; ++var10) {
                                                    if (gameCT[var10] != null) {
                                                        super.center = new Command(mResources.ACCEPT, 11062);
                                                        break;
                                                    }
                                                }
                                            }
                                        }

                                        if (GameCanvas.gameAB(popupX, popupY + 2 * this.gameTS + 5, gameGC, gameGD - this.gameTS * 3)) {
                                            this.gameAA(popupX, popupY + 2 * this.gameTS + 5, 6, 3, 2);
                                        }
                                    }
                                } else if (gameBP == 1 && ((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                                    gameHQ = 1;
                                    gameBM = var9.selected;
                                    this.gameBB();
                                }
                            } else if (gameBP == 0) {
                                if (GameCanvas.gameAB(popupX + 74, gameGB - gameBL - 3, gameBL, gameBL)) {
                                    gameHQ = 1;
                                    gameBM = 0;
                                    this.gameBB();
                                }

                                this.gameAA(popupX + 4, popupY + 2 * this.gameTS + 5, 6, 4, 2);
                            } else if (gameBP == 1 && ((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                                gameHQ = 1;
                                gameBM = var9.selected;
                                this.gameBB();
                            }
                        } else if (gameBP == 0) {
                            this.gameAA(popupX + 4, popupY + this.gameTS + 3, 6, 4, 1);
                        } else if (gameBP == 1 && ((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                            gameHQ = 1;
                            gameBM = var9.selected;
                            this.gameBB();
                        }
                    } else if (((var9 = gameBU.gameAB()).isFinish || var9.isDowning) && gameBM != var9.selected) {
                        gameHQ = 1;
                        gameBM = var9.selected;
                        super.left = super.center = null;
                        gameDK = false;
                        this.gameBB();
                    }
                }
            }

            GameCanvas.gameAK();
            GameCanvas.gameAJ();
        }

    }

    private static int gameDM() {
        int var0 = 0;

        try {
            if (gameKF) {
                if (gameCP.length % gameTC == 0) {
                    var0 = gameCP.length;
                } else {
                    var0 = (gameCP.length / gameTC + 1) * gameTC;
                }
            } else if (gameKE) {
                if (gameBP == 0) {
                    if (gameCO.length % gameTC == 0) {
                        var0 = gameCO.length;
                    } else {
                        var0 = (gameCO.length / gameTC + 1) * gameTC;
                    }
                } else if (gameBP == 1) {
                    if (gameCR.length % gameTC == 0) {
                        var0 = gameCR.length;
                    } else {
                        var0 = (gameCR.length / gameTC + 1) * gameTC;
                    }
                } else if (gameBP == 2) {
                    if (gameCS.length % gameTC == 0) {
                        var0 = gameCS.length;
                    } else {
                        var0 = (gameCS.length / gameTC + 1) * gameTC;
                    }
                }
            } else if (gameKG) {
                if (gameBV.length % gameTC == 0) {
                    var0 = gameBV.length;
                } else {
                    var0 = (gameBV.length / gameTC + 1) * gameTC;
                }
            } else if (gameKH) {
                if (gameBW.length % gameTC == 0) {
                    var0 = gameBW.length;
                } else {
                    var0 = (gameBW.length / gameTC + 1) * gameTC;
                }
            } else if (gameKI) {
                if (gameBX.length % gameTC == 0) {
                    var0 = gameBX.length;
                } else {
                    var0 = (gameBX.length / gameTC + 1) * gameTC;
                }
            } else if (gameKJ) {
                if (gameBY.length % gameTC == 0) {
                    var0 = gameBY.length;
                } else {
                    var0 = (gameBY.length / gameTC + 1) * gameTC;
                }
            } else if (gameKK) {
                if (gameBZ.length % gameTC == 0) {
                    var0 = gameBZ.length;
                } else {
                    var0 = (gameBZ.length / gameTC + 1) * gameTC;
                }
            } else if (gameKL) {
                if (gameCA.length % gameTC == 0) {
                    var0 = gameCA.length;
                } else {
                    var0 = (gameCA.length / gameTC + 1) * gameTC;
                }
            } else if (gameKM) {
                if (gameCB.length % gameTC == 0) {
                    var0 = gameCB.length;
                } else {
                    var0 = (gameCB.length / gameTC + 1) * gameTC;
                }
            } else if (gameKN) {
                if (gameCC.length % gameTC == 0) {
                    var0 = gameCC.length;
                } else {
                    var0 = (gameCC.length / gameTC + 1) * gameTC;
                }
            } else if (gameKO) {
                if (gameCD.length % gameTC == 0) {
                    var0 = gameCD.length;
                } else {
                    var0 = (gameCD.length / gameTC + 1) * gameTC;
                }
            } else if (gameKP) {
                if (gameCE.length % gameTC == 0) {
                    var0 = gameCE.length;
                } else {
                    var0 = (gameCE.length / gameTC + 1) * gameTC;
                }
            } else if (gameKQ) {
                if (gameCF.length % gameTC == 0) {
                    var0 = gameCF.length;
                } else {
                    var0 = (gameCF.length / gameTC + 1) * gameTC;
                }
            } else if (gameKR) {
                if (gameCG.length % gameTC == 0) {
                    var0 = gameCG.length;
                } else {
                    var0 = (gameCG.length / gameTC + 1) * gameTC;
                }
            } else if (gameKS) {
                if (gameCH.length % gameTC == 0) {
                    var0 = gameCH.length;
                } else {
                    var0 = (gameCH.length / gameTC + 1) * gameTC;
                }
            } else if (gameKT) {
                if (gameCI.length % gameTC == 0) {
                    var0 = gameCI.length;
                } else {
                    var0 = (gameCI.length / gameTC + 1) * gameTC;
                }
            } else if (gameKU) {
                if (gameCJ.length % gameTC == 0) {
                    var0 = gameCJ.length;
                } else {
                    var0 = (gameCJ.length / gameTC + 1) * gameTC;
                }
            } else if (gameKV) {
                if (gameCK.length % gameTC == 0) {
                    var0 = gameCK.length;
                } else {
                    var0 = (gameCK.length / gameTC + 1) * gameTC;
                }
            } else if (gameKW) {
                if (gameCL.length % gameTC == 0) {
                    var0 = gameCL.length;
                } else {
                    var0 = (gameCL.length / gameTC + 1) * gameTC;
                }
            } else if (gameKX) {
                if (gameCM.length % gameTC == 0) {
                    var0 = gameCM.length;
                } else {
                    var0 = (gameCM.length / gameTC + 1) * gameTC;
                }
            } else if (gameKY) {
                if (gameCN.length % gameTC == 0) {
                    var0 = gameCN.length;
                } else {
                    var0 = (gameCN.length / gameTC + 1) * gameTC;
                }
            }

            if (gameMD) {
                var0 = Char.getMyChar().arrItemBox.length;
            }

            if (gameBP == 1 && !gameKE) {
                var0 = Char.getMyChar().arrItemBag.length;
            }
        } catch (Exception var1) {
        }

        if ((gameMC || gameML || gameME || gameMM || gameMN || gameMO) && gameBP == 0) {
            var0 = 24;
        } else if ((gameMP || gameKZ || gameMA) && gameBP == 0) {
            var0 = 18;
        } else if (var0 < 30) {
            var0 = 30;
        }

        return var0;
    }

    private static void gameDN() {
        if (gameBP == 0) {
            Service.gI().gameAI(14);
        } else if (gameBP == 1) {
            Service.gI().gameAI(15);
        } else if (gameBP == 2) {
            Service.gI().gameAI(32);
        } else {
            if (gameBP == 3) {
                Service.gI().gameAI(34);
            }

        }
    }

    private void gameDO() {
        if (Char.getMyChar().arrItemBag[gameBM].quantity > 1) {
            super.left = new Command(mResources.gameCW, 11072);
        } else {
            super.left = new Command(mResources.gameCW, 11073);
        }
    }

    public final void gameBB() {
        super.left = super.center = null;
        if (gameBM >= 0) {
            if (gameDN) {
                if (gameHQ == 1 && !GameCanvas.isTouch) {
                    super.left = new Command(mResources.SELECT, 1510);
                    return;
                }
            } else if (gameMJ) {
                if (gameHQ == 1) {
                    super.left = new Command(mResources.SELECT, 1506);
                    super.center = new Command("", 1507);
                    return;
                }
            } else if (gameKF) {
                if (gameBP == 0 && gameAN(35) != null) {
                    super.left = this.gameSB;
                    if (!GameCanvas.gameAI) {
                        super.center = this.gameSC;
                        return;
                    }

                    this.gameAD((byte) 35);
                    return;
                }
            } else if (gameKE) {
                if (gameBP == 0) {
                    if (gameAN(14) != null) {
                        super.left = this.gameSD;
                        if (!GameCanvas.gameAI) {
                            super.center = this.gameSE;
                            return;
                        }

                        this.gameAD((byte) 14);
                        return;
                    }
                } else if (gameBP == 1) {
                    if (gameAN(15) != null) {
                        super.left = this.gameSH;
                        if (!GameCanvas.gameAI) {
                            super.center = this.gameSI;
                            return;
                        }

                        this.gameAD((byte) 15);
                        return;
                    }
                } else if (gameBP == 2) {
                    if (gameAN(32) != null) {
                        super.left = this.gameSJ;
                        if (!GameCanvas.gameAI) {
                            super.center = this.gameSK;
                            return;
                        }

                        this.gameAD((byte) 32);
                        return;
                    }
                } else if (gameBP == 3 && gameAN(34) != null) {
                    super.left = this.gameSF;
                    if (!GameCanvas.gameAI) {
                        super.center = this.gameSG;
                        return;
                    }

                    this.gameAD((byte) 34);
                    return;
                }
            } else {
                if (gameKG) {
                    if (gameBP == 0) {
                        if (gameAN(20) != null) {
                            super.left = this.gameSL;
                            if (!GameCanvas.gameAI) {
                                super.center = this.gameSM;
                            } else {
                                this.gameAD((byte) 20);
                            }
                        }
                    } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                        this.gameDO();
                    }
                } else if (gameKH) {
                    if (gameBP == 0) {
                        if (gameAN(21) != null) {
                            super.left = this.gameSN;
                            if (!GameCanvas.gameAI) {
                                super.center = this.gameSO;
                            } else {
                                this.gameAD((byte) 21);
                            }
                        }
                    } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                        this.gameDO();
                    }
                } else if (gameKI) {
                    if (gameBP == 0) {
                        if (gameAN(22) != null) {
                            super.left = this.gameSP;
                            if (!GameCanvas.gameAI) {
                                super.center = this.gameSQ;
                            } else {
                                this.gameAD((byte) 22);
                            }
                        }
                    } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                        this.gameDO();
                    }
                } else if (gameKJ) {
                    if (gameBP == 0) {
                        if (gameAN(23) != null) {
                            super.left = this.gameSR;
                            if (!GameCanvas.gameAI) {
                                super.center = this.gameSS;
                            } else {
                                this.gameAD((byte) 23);
                            }
                        }
                    } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                        this.gameDO();
                    }
                } else if (gameKK) {
                    if (gameBP == 0) {
                        if (gameAN(24) != null) {
                            super.left = this.gameST;
                            if (!GameCanvas.gameAI) {
                                super.center = this.gameSU;
                            } else {
                                this.gameAD((byte) 24);
                            }
                        }
                    } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                        this.gameDO();
                    }
                } else if (gameKL) {
                    if (gameBP == 0) {
                        if (gameAN(25) != null) {
                            super.left = this.gameSV;
                            if (!GameCanvas.gameAI) {
                                super.center = this.gameSW;
                            } else {
                                this.gameAD((byte) 25);
                            }
                        }
                    } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                        this.gameDO();
                    }
                } else {
                    Item var10;
                    if (gameKM) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(26)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (!GameCanvas.gameAI) {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11088, var10);
                                } else {
                                    this.gameAA((int) 26, (Item) var10);
                                }
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKN) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(27)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (!GameCanvas.gameAI) {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11089);
                                } else {
                                    this.gameAA((int) 27, (Item) var10);
                                }
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKO) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(28)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (!GameCanvas.gameAI) {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11090);
                                } else {
                                    this.gameAA((int) 28, (Item) var10);
                                }
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKP) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(29)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (!GameCanvas.gameAI) {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11091);
                                } else {
                                    this.gameAA((int) 29, (Item) var10);
                                }
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKQ) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(16)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 16, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 110923);
                                }
                            } else {
                                gameDK = false;
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKR) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(17)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 17, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 110924);
                                }
                            } else {
                                gameDK = false;
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKS) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(18)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 18, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 110925);
                                }
                            } else {
                                gameDK = false;
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKT) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(19)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 19, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 110926);
                                }
                            } else {
                                gameDK = false;
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKU) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(2)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 2, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11093);
                                }
                            } else {
                                gameDK = false;
                            }
                        } else if (gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                            this.gameDO();
                        }
                    } else if (gameKV) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(6)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 6, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11094);
                                }
                            }
                        } else if (gameBP == 1) {
                            if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                this.gameDO();
                            } else {
                                super.left = this.gameTM;
                            }
                        }
                    } else if (gameKW) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(7)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 7, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11095);
                                }
                            }
                        } else if (gameBP == 1) {
                            if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                this.gameDO();
                            } else {
                                super.left = this.gameTM;
                            }
                        }
                    } else if (gameKX) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(8)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 8, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11096);
                                }
                            }
                        } else if (gameBP == 1) {
                            if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                this.gameDO();
                            } else {
                                super.left = this.gameTM;
                            }
                        }
                    } else if (gameKY) {
                        if (gameBP == 0) {
                            if ((var10 = gameAN(9)) != null) {
                                super.left = new Command(mResources.gameDA, 11092, var10);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 9, (Item) var10);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11097);
                                }
                            }
                        } else if (gameBP == 1) {
                            if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                this.gameDO();
                            } else {
                                super.left = this.gameTM;
                            }
                        }
                    } else {
                        int var2;
                        if (gameKZ) {
                            if (gameBP == 0) {
                                if (gameHQ == 1) {
                                    if (arritemup != null) {
                                        if (gameBM == 0) {
                                            super.left = new Command(mResources.SELECT, 11098);
                                            if (GameCanvas.gameAI) {
                                                gameHT = false;
                                                this.gameAA((int) 3, (Item) arritemup);
                                            } else {
                                                super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11099);
                                            }
                                        } else if (gameBM == 1 && !arritemup.gameAP()) {
                                            if (GameCanvas.gameAI) {
                                                gameHT = true;
                                                this.gameAA((int) 3, (Item) arritemup);
                                            } else {
                                                super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 110991);
                                            }
                                        }
                                    } else {
                                        gameDK = false;
                                    }
                                } else if (gameHQ == 2) {
                                    var10 = gameAN(10);
                                    gameHT = false;
                                    if (var10 != null) {
                                        super.left = new Command(mResources.SELECT, 11100);
                                        if (GameCanvas.gameAI) {
                                            this.gameAA((int) 3, (Item) var10);
                                        } else {
                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11101);
                                        }
                                    } else {
                                        super.left = null;
                                        gameDK = false;
                                        if (arritemup != null) {
                                            for (var2 = 0; var2 < upitem.length; ++var2) {
                                                if (upitem[var2] != null) {
                                                    super.left = new Command(mResources.gameGC, 110981);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (gameBP == 1) {
                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                    super.left = new Command(mResources.SELECT, 11102);
                                } else {
                                    super.left = null;
                                }
                            }
                        } else {
                            int var1;
                            if (gameMA) {
                                if (gameBP != 0) {
                                    if (gameBP == 1) {
                                        if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                            super.left = new Command(mResources.SELECT, 14012);
                                        } else {
                                            super.left = null;
                                        }
                                    }
                                } else if (gameHQ == 1) {
                                    if (gameBM == 0) {
                                        if (gameCY[0] != null) {
                                            super.left = new Command(mResources.SELECT, 14013);
                                            if (GameCanvas.gameAI) {
                                                this.gameAA((int) 3, (Item) gameCY[gameBM]);
                                            } else {
                                                super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 14016);
                                            }
                                        }
                                    } else if (gameBM == 1) {
                                        if (gameCY[1] != null) {
                                            super.left = new Command(mResources.SELECT, 14013);
                                            if (GameCanvas.gameAI) {
                                                this.gameAA((int) 3, (Item) gameCY[gameBM]);
                                            } else {
                                                super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 14016);
                                            }
                                        }
                                    } else {
                                        gameDK = false;
                                    }
                                } else if (gameHQ == 2) {
                                    var10 = null;
                                    if ((var2 = gameBM + 2) <= gameCY.length - 1) {
                                        var10 = gameCY[var2];
                                    }

                                    if (var10 != null) {
                                        super.left = new Command(mResources.gameCR, 140151);
                                        if (GameCanvas.gameAI) {
                                            this.gameAA((int) 3, (Item) var10);
                                        } else {
                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 140161);
                                        }
                                    } else {
                                        super.left = new Command(mResources.gameGC, 140131);

                                        for (var1 = 0; var1 < gameCY.length; ++var1) {
                                            if (gameCY[var1] == null) {
                                                super.left = null;
                                                break;
                                            }
                                        }

                                        gameDK = false;
                                    }
                                }
                            } else {
                                int var3;
                                if (gameDH) {
                                    if (gameBP == 0) {
                                        if (gameHQ == 2) {
                                            this.gameNE.isFocus = true;
                                            super.right = this.gameNE.cmdClear;
                                        } else {
                                            this.gameNE.isFocus = false;
                                            super.right = this.gameSA;
                                        }

                                        var3 = 0;

                                        try {
                                            var3 = Integer.parseInt(this.gameNE.gameAD());
                                        } catch (Exception var9) {
                                        }

                                        if (gameDE != null && var3 > 0 && Char.getMyChar().xu >= 5000) {
                                            super.left = new Command(mResources.gameCW, 15002);
                                        }

                                        if (gameHQ == 1 && gameDE != null) {
                                            super.left = new Command(mResources.SELECT, 1500);
                                            if (GameCanvas.gameAI) {
                                                this.gameAA((int) 3, (Item) gameDE);
                                            } else {
                                                super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 1501);
                                            }
                                        }
                                    } else if (gameBP == 1) {
                                        super.right = this.gameSA;
                                        if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                            super.left = new Command(mResources.SELECT, 1503);
                                        } else {
                                            super.left = null;
                                            gameDK = false;
                                        }
                                    }
                                } else {
                                    if (gameMK) {
                                        if (gameHQ == 1 && arrItemStands != null && gameBM >= 0 && gameBM < arrItemStands.length && arrItemStands[gameBM] != null) {
                                            super.left = new Command(mResources.SELECT, 1504);
                                            if (GameCanvas.gameAI) {
                                                this.gameAB(1505, (Object) null);
                                                return;
                                            }

                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 1505);
                                        }

                                        return;
                                    }

                                    if (gameME) {
                                        if (gameBP == 0) {
                                            if (gameHQ != 1) {
                                                if (gameHQ == 2) {
                                                    if ((var10 = gameCV[gameBM]) != null) {
                                                        if (GameCanvas.gameAI) {
                                                            this.gameAA((int) 3, (Item) var10);
                                                        } else {
                                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, var10);
                                                        }
                                                    } else {
                                                        gameDK = false;
                                                    }

                                                    if (gameDD != null && gameDD.upgrade > 0) {
                                                        super.left = new Command(mResources.gameGC, 11105);
                                                    }
                                                }
                                            } else {
                                                if (gameDD != null && gameDD.upgrade > 0) {
                                                    super.left = new Command(mResources.SELECT, 11103);
                                                } else if (gameDD != null) {
                                                    super.left = this.gameRT;
                                                } else {
                                                    gameDK = false;
                                                }

                                                if (GameCanvas.gameAI) {
                                                    this.gameAA((int) 3, (Item) gameDD);
                                                } else {
                                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, gameDD);
                                                }
                                            }
                                        } else if (gameBP == 1) {
                                            if (Char.getMyChar().arrItemBag[gameBM] == null) {
                                                super.left = null;
                                                gameDK = false;
                                            } else {
                                                super.left = new Command(mResources.SELECT, 11106);
                                            }
                                        }
                                    } else if (gameMM) {
                                        try {
                                            if (gameBP == 0) {
                                                if (gameHQ == 1) {
                                                    if (gameDD != null) {
                                                        super.left = new Command(mResources.SELECT, 11103);
                                                    } else {
                                                        gameDK = false;
                                                    }

                                                    if (GameCanvas.gameAI) {
                                                        this.gameAA((int) 3, (Item) gameDD);
                                                    } else {
                                                        super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, gameDD);
                                                    }
                                                } else if (gameHQ == 2) {
                                                    if ((var10 = gameCV[gameBM]) != null) {
                                                        if (GameCanvas.gameAI) {
                                                            this.gameAA((int) 3, (Item) var10);
                                                        } else {
                                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, var10);
                                                        }

                                                        super.left = new Command(mResources.gameCR, 1605);
                                                    } else {
                                                        gameDK = false;
                                                    }

                                                    if (gameDD != null) {
                                                        super.left = new Command(mResources.SELECT, 1604);
                                                    }
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] == null) {
                                                    super.left = null;
                                                    gameDK = false;
                                                } else {
                                                    super.left = new Command(mResources.SELECT, 11106);
                                                }
                                            }
                                        } catch (Exception var8) {
                                        }
                                    } else if (gameMN) {
                                        if (gameBP == 0) {
                                            if (gameHQ != 1) {
                                                if (gameHQ == 2) {
                                                    if ((var10 = gameCV[gameBM]) != null) {
                                                        if (GameCanvas.gameAI) {
                                                            this.gameAA((int) 3, (Item) var10);
                                                        } else {
                                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, var10);
                                                        }
                                                    } else {
                                                        gameDK = false;
                                                    }

                                                    if (gameDD != null && gameDD.upgrade > 11) {
                                                        super.left = new Command(mResources.SELECT, 1604);
                                                    }
                                                }
                                            } else {
                                                if (gameDD != null && gameDD.upgrade > 11) {
                                                    super.left = new Command(mResources.SELECT, 11103);
                                                } else if (gameDD != null) {
                                                    super.left = this.gameRT;
                                                } else {
                                                    gameDK = false;
                                                }

                                                if (GameCanvas.gameAI) {
                                                    this.gameAA((int) 3, (Item) gameDD);
                                                } else {
                                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, gameDD);
                                                }
                                            }
                                        } else if (gameBP == 1) {
                                            if (Char.getMyChar().arrItemBag[gameBM] == null) {
                                                super.left = null;
                                                gameDK = false;
                                            } else {
                                                super.left = new Command(mResources.SELECT, 1606);
                                            }
                                        }
                                    } else if (gameMC) {
                                        if (gameBP != 0) {
                                            if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = new Command(mResources.SELECT, 11109);
                                                } else {
                                                    gameDK = false;
                                                    super.left = null;
                                                }
                                            }
                                        } else {
                                            var3 = 0;

                                            for (var2 = 0; var2 < gameCT.length; ++var2) {
                                                if (gameCT[var2] != null) {
                                                    ++var3;
                                                    if (var3 >= 2) {
                                                        break;
                                                    }
                                                }
                                            }

                                            if ((var10 = gameAN(11)) != null) {
                                                if (var3 >= 2) {
                                                    super.left = new Command(mResources.SELECT, 11107);
                                                } else {
                                                    super.left = new Command(mResources.gameCR, 111071);
                                                }

                                                if (GameCanvas.gameAI) {
                                                    this.gameAA((int) 3, (Item) var10);
                                                } else {
                                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11108);
                                                }
                                            } else {
                                                gameDK = false;
                                                if (var3 >= 2) {
                                                    super.left = new Command(mResources.gameGC, 11062);
                                                }
                                            }
                                        }
                                    } else if (!gameML) {
                                        if (isPaintTrade) {
                                            if (gameBP == 0) {
                                                if (gameHQ == 1) {
                                                    if (gameCW[gameBM] != null) {
                                                        if (this.gameEC == 0) {
                                                            super.left = this.gameRZ;
                                                        } else if (this.gameEC == 1 && this.typeTradeOrder > 0 && (long) this.gameEG - System.currentTimeMillis() / 1000L <= 0L) {
                                                            super.left = this.gameRN;
                                                        }

                                                        if (GameCanvas.gameAI) {
                                                            var10 = gameCW[gameBM];
                                                            this.gameAA((int) 3, (Item) var10);
                                                        } else {
                                                            super.center = this.gameRW;
                                                        }
                                                    } else {
                                                        gameDK = false;
                                                        if (this.gameEC == 0) {
                                                            super.left = this.gameRM;
                                                        } else if (this.gameEC == 1 && this.typeTradeOrder > 0 && (long) this.gameEG - System.currentTimeMillis() / 1000L <= 0L) {
                                                            super.left = this.gameRN;
                                                        }
                                                    }
                                                }

                                                if (gameHQ == 2) {
                                                    if (gameCX[gameBM] != null) {
                                                        if (GameCanvas.gameAI) {
                                                            var10 = gameCX[gameBM];
                                                            this.gameAA((int) 30, (Item) var10);
                                                        } else {
                                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11110);
                                                        }
                                                    } else {
                                                        gameDK = false;
                                                    }
                                                }
                                            } else if (gameBP == 1 && this.gameEC == 0) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = this.gameRY;
                                                } else {
                                                    super.left = this.gameRU;
                                                }
                                            }
                                        } else if (gameMD) {
                                            if (gameBP == 0) {
                                                if ((var10 = gameAN(4)) != null) {
                                                    super.left = new Command(mResources.gameCQ, 111101);
                                                    if (GameCanvas.gameAI) {
                                                        this.gameAA((int) 4, (Item) var10);
                                                    } else {
                                                        super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11111);
                                                    }
                                                } else {
                                                    super.left = new Command(mResources.gameCL, 11112);
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = new Command(mResources.gameCV, 11113);
                                                } else {
                                                    super.left = this.gameTM;
                                                }
                                            }
                                        } else if (gameVH) {
                                            if (gameBP == 0) {
                                                if (gameBM >= 0 && gameBM <= Code.nhat.length && Code.nhat[gameBM] > 0) {
                                                    super.left = new Command(mResources.gameXO, 1100077);
                                                } else {
                                                    super.left = new Command(mResources.gameCL, 1100078);
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = new Command(mResources.gameXP, 1100079);
                                                } else {
                                                    super.left = this.gameTM;
                                                }
                                            }
                                        } else if (itemDell) {
                                            if (gameBP == 0) {
                                                if (gameBM >= 0 && gameBM <= Code.dell.length && Code.dell[gameBM] > 0) {
                                                    super.left = new Command(mResources.gameXO, 11000771);
                                                } else {
                                                    super.left = new Command(mResources.gameCL, 11000781);
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = new Command(mResources.gameXP, 11000791);
                                                } else {
                                                    super.left = this.gameTM;
                                                }
                                            }
                                        } else if (itemThow) {
                                            if (gameBP == 0) {
                                                if (gameBM >= 0 && gameBM <= Code.thow.length && Code.thow[gameBM] > 0) {
                                                    super.left = new Command(mResources.gameXO, 11000793);
                                                } else {
                                                    super.left = new Command(mResources.gameCL, 11000794);
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = new Command(mResources.gameXP, 11000795);
                                                } else {
                                                    super.left = this.gameTM;
                                                }
                                            }
                                        } else if (gameMO) {
                                            GameScr var12 = this;

                                            try {
                                                if (gameBP == 0) {
                                                    if (gameHQ == 1) {
                                                        if (gameDD != null) {
                                                            var12.left = new Command(mResources.SELECT, 11103);
                                                        } else {
                                                            gameDK = false;
                                                        }

                                                        if (GameCanvas.gameAI) {
                                                            var12.gameAA((int) 3, (Item) gameDD);
                                                        } else {
                                                            var12.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, gameDD);
                                                        }
                                                    } else if (gameHQ == 2) {
                                                        if ((var10 = gameCV[gameBM]) != null) {
                                                            if (GameCanvas.gameAI) {
                                                                var12.gameAA((int) 3, (Item) var10);
                                                            } else {
                                                                var12.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, var10);
                                                            }

                                                            var12.left = new Command(mResources.gameCR, 1605);
                                                        } else {
                                                            gameDK = false;
                                                        }

                                                        if (gameDD != null) {
                                                            var12.left = new Command(mResources.SELECT, 1604);
                                                        }
                                                    }
                                                } else if (gameBP == 1) {
                                                    if (Char.getMyChar().arrItemBag[gameBM] == null) {
                                                        var12.left = null;
                                                        gameDK = false;
                                                    } else {
                                                        var12.left = new Command(mResources.SELECT, 222);
                                                    }
                                                }
                                            } catch (Exception var7) {
                                            }
                                        } else if (gameMP) {
                                            if (gameBP == 0) {
                                                if (gameHQ == 1) {
                                                    if (gameDD != null && gameBM == 0) {
                                                        super.left = new Command(mResources.SELECT, 338);
                                                        if (GameCanvas.gameAI) {
                                                            gameHT = false;
                                                            this.gameAA((int) 3, (Item) gameDD);
                                                        } else {
                                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 335);
                                                        }
                                                    }

                                                    if (arritemup != null && gameBM == 1) {
                                                        super.left = new Command(mResources.SELECT, 344);
                                                        if (GameCanvas.gameAI) {
                                                            gameHT = false;
                                                            this.gameAA((int) 3, (Item) arritemup);
                                                        } else {
                                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 336);
                                                        }
                                                    }

                                                    if (gameDD == null && arritemup == null) {
                                                        gameDK = false;
                                                    }
                                                } else if (gameHQ == 2) {
                                                    var10 = gameAN(47);
                                                    gameHT = false;
                                                    if (var10 != null) {
                                                        super.left = new Command(mResources.SELECT, 345);
                                                        if (GameCanvas.gameAI) {
                                                            this.gameAA((int) 3, (Item) var10);
                                                        } else {
                                                            super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11101);
                                                        }
                                                    } else {
                                                        super.left = null;
                                                        gameDK = false;
                                                        if (arritemup != null && gameDD != null) {
                                                            for (var2 = 0; var2 < upitem.length; ++var2) {
                                                                if (upitem[var2] != null) {
                                                                    super.left = new Command(mResources.gameGC, 341);
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = new Command(mResources.SELECT, 337);
                                                } else {
                                                    super.left = null;
                                                }
                                            }
                                        } else if (gameMT) {
                                            if (gameBP == 0) {
                                                var10 = gameAN(48);
                                                gameHT = false;
                                                if (var10 != null) {
                                                    super.left = new Command(mResources.SELECT, 401);
                                                    if (GameCanvas.gameAI) {
                                                        this.gameAA((int) 3, (Item) var10);
                                                    } else {
                                                        super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11101);
                                                    }
                                                } else {
                                                    for (var2 = 0; var2 < gameCV.length; ++var2) {
                                                        if (gameCV[var2] != null) {
                                                            super.left = new Command(mResources.gameHR[0], 403);
                                                            break;
                                                        }
                                                    }
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                    super.left = new Command(mResources.SELECT, 400);
                                                } else {
                                                    super.left = null;
                                                }
                                            }
                                        } else if (gameMQ || gameMR) {
                                            if (gameBP == 0) {
                                                if (gameDD != null) {
                                                    super.left = new Command(mResources.SELECT, 11103);
                                                } else {
                                                    gameDK = false;
                                                }

                                                if (GameCanvas.gameAI) {
                                                    this.gameAA((int) 3, (Item) gameDD);
                                                } else {
                                                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11104, gameDD);
                                                }
                                            } else if (gameBP == 1) {
                                                if (Char.getMyChar().arrItemBag[gameBM] == null) {
                                                    super.left = null;
                                                    gameDK = false;
                                                } else {
                                                    super.left = new Command(mResources.SELECT, 405);
                                                }
                                            }
                                        }
                                    } else if (gameBP != 0) {
                                        if (gameBP == 1) {
                                            if (Char.getMyChar().arrItemBag[gameBM] != null) {
                                                super.left = new Command(mResources.SELECT, 1603);
                                            } else {
                                                gameDK = false;
                                                super.left = null;
                                            }
                                        }
                                    } else {
                                        var3 = 0;
                                        var2 = 0;
                                        var1 = 0;
                                        short var4 = 0;

                                        for (int var5 = 0; var5 < gameCT.length; ++var5) {
                                            Item var6;
                                            if ((var6 = gameCT[var5]) != null) {
                                                if (var6.template.id == 455) {
                                                    ++var3;
                                                } else if (var6.template.id == 456) {
                                                    ++var2;
                                                } else if (var6.template.type == 26) {
                                                    var4 = var6.template.id;
                                                    ++var1;
                                                }
                                            }

                                            if (var3 >= 9 || var2 >= 9 || var4 == 10 && var3 >= 3 || var4 == 11 && var2 >= 3) {
                                                break;
                                            }
                                        }

                                        Item var11;
                                        if ((var11 = gameAN(43)) == null) {
                                            gameDK = false;
                                            if (var3 >= 9 || var2 >= 9 || var4 >= 10 && (var3 >= 3 || var2 >= 3)) {
                                                super.left = new Command(mResources.gameGC, 1600);
                                            }
                                        } else {
                                            if (var3 == 9 || var2 == 9 || var4 == 10 && var3 == 3 && var1 == 1 || var4 == 11 && var2 == 3 && var1 == 1) {
                                                super.left = new Command(mResources.SELECT, 1601);
                                            } else {
                                                super.left = new Command(mResources.gameCR, 111071);
                                            }

                                            if (GameCanvas.gameAI) {
                                                this.gameAA((int) 43, (Item) var11);
                                            } else {
                                                super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 1602);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (gameAZ() && gameBP == 1 && Char.getMyChar().arrItemBag[gameBM] != null) {
                    if (GameCanvas.gameAI) {
                        this.gameAA((int) 3, (Item) Char.getMyChar().arrItemBag[gameBM]);
                        return;
                    }

                    super.center = new Command(GameCanvas.isTouch ? mResources.gameCF : "", 11114);
                }
            }
        }

    }

    public static void setSize(int var0, int var1) {
        if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
            var0 = 126;
            var1 = 160;
        }

        gameGC = var0;
        gameGD = var1;
        popupX = gameAD - var0 / 2;
        popupY = gameAF - var1 / 2;
        if (GameCanvas.h <= 250) {
            popupY -= 10;
        }

        if (GameCanvas.gameAI && !gameDI() && GameCanvas.currentScreen instanceof GameScr) {
            gameGC = 310;
            popupX = gW / 2 - gameGC / 2;
        }

        if (popupY < -10) {
            popupY = -10;
        }

        if (GameCanvas.h > 208 && popupY < 0) {
            popupY = 0;
        }

        if (GameCanvas.h == 208 && popupY < 10) {
            popupY = 10;
        }

    }

    private void gameAA(mGraphics var1, Skill var2) {
        if (Char.getMyChar().clevel >= var2.level) {
            mFont.tahoma_7_white.gameAA(var1, mResources.gameKZ + " " + var2.level, gameGA + 5, this.gameGE += 12, 0);
        } else {
            mFont.tahoma_7_red.gameAA(var1, mResources.gameKZ + " " + var2.level, gameGA + 5, this.gameGE += 12, 0);
        }

        if (var2.template.type != 0) {
            gameBO += 4;
            mFont.tahoma_7_white.gameAA(var1, mResources.gameQF + ": " + var2.gameAD(), gameGA + 5, this.gameGE += 12, 0);
            mFont.tahoma_7_white.gameAA(var1, mResources.gameQH + ": " + var2.manaUse, gameGA + 5, this.gameGE += 12, 0);
            mFont.tahoma_7_white.gameAA(var1, mResources.gameQG + ": " + var2.gameAB(), gameGA + 5, this.gameGE += 12, 0);
            StringBuffer var3 = (new StringBuffer(String.valueOf(mResources.gameQI))).append(": ");
            Skill var4 = var2;
            String var5;
            if (var2.coolDown % 1000 == 0) {
                var5 = String.valueOf(var2.coolDown / 1000);
            } else {
                int var6 = var2.coolDown % 1000;
                var5 = var4.coolDown / 1000 + "." + (var6 % 100 == 0 ? var6 / 100 : var6 / 10);
            }

            mFont.tahoma_7_white.gameAA(var1, var3.append(var5).append(" ").append(mResources.gameQD).toString(), gameGA + 5, this.gameGE += 12, 0);
        }

        ++gameBO;
    }

    private void gameAB(mGraphics var1, Skill var2) {
        SkillOption[] var6 = var2.options;

        for (int var3 = 0; var3 < var6.length; ++var3) {
            SkillOption var4 = var6[var3];
            if (mFont.tahoma_7_white.gameAA(var4.gameAA()) > 145) {
                MyVector var7 = mFont.tahoma_7_white.gameAA(var4.gameAA(), 145);

                for (int var5 = 0; var5 < var7.size(); ++var5) {
                    mFont.tahoma_7_white.gameAA(var1, var7.elementAt(var5).toString(), gameGA + 5, this.gameGE += 12, 0);
                    ++gameBO;
                }
            } else {
                mFont.tahoma_7_white.gameAA(var1, var4.gameAA(), gameGA + 5, this.gameGE += 12, 0);
                ++gameBO;
            }
        }

    }

    private void gameAN(mGraphics var1) {
        if (gameBP == 1) {
            gameAB(var1);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            gameAA(var1, mResources.gameGN[gameBP], true);
            mFont.tahoma_7b_white.gameAA(var1, mResources.gameNH, popupX + 10, popupY + 32, 0);
            mFont.tahoma_7b_white.gameAA(var1, "" + Char.getMyChar().sPoint, popupX + gameGC - 10, popupY + 32, 1);
            var1.gameAA(0);
            var1.gameAD(popupX + 4, popupY + 44, gameGC - 7, gameBL + 3);
            var1.gameAA(12281361);
            var1.gameAC(popupX + 5, popupY + 45, gameGC - 10, gameBL);
            if (gameHQ > 0) {
                var1.gameAA(Paint.COLORBORDER);
                var1.gameAC(popupX + 5, popupY + 48 + gameBL, gameGC - 10, gameGD - 64 - gameBL);
            }

            int var2 = Char.getMyChar().nClass.skillTemplates.length;
            gameGA = popupX + 5;
            gameGB = popupY + 45;
            gameBU.gameAA(var2, gameBL + 2, gameGA + 1, gameGB, gameGC - 12, gameBL + 2, false, 1);
            gameBU.gameAA(var1);

            for (int var3 = 0; var3 < var2; ++var3) {
                int var4 = gameGA + var3 * (gameBL + 2) + gameBL / 2;
                SmallImage.gameAB(var1, Char.getMyChar().nClass.skillTemplates[var3].iconId, var4, gameGB + gameBL / 2, 0, 3);
                if (gameHQ == 1 && var3 == gameBM) {
                    var1.gameAA(16777215);
                    var1.gameAC(gameGA + var3 * (gameBL + 2) + 2, gameGB + 2, gameBL - 4, gameBL - 4);
                    gameAA(gameGA + var3 * (gameBL + 2), gameGB, var1);
                }
            }

            gameGA += 8;
            gameGB += 6;
            if (gameHQ == 1 && gameBM >= 0) {
                gameAB(var1);
                SkillTemplate var9 = Char.getMyChar().nClass.skillTemplates[gameBM];
                gameBO = 4 + var9.description.length;
                Skill var10 = Char.getMyChar().gameAA(var9);
                var2 = popupX;
                int var5 = gameGB + gameBL + 2;
                int var6 = gameGC - 6;
                int var7 = gameGD - 70 - gameBL;
                gameBT.gameAA(var1, var2, var5, var6, var7);
                this.gameGE = gameGB + 18;
                int var8;
                if (var10 == null) {
                    var10 = var9.skills.length > 1 ? var9.skills[1] : var9.skills[0];
                    mFont.tahoma_7b_red.gameAA(var1, var9.name, gameGA + 5, this.gameGE += 12, 0);

                    for (var8 = 0; var8 < var9.description.length; ++var8) {
                        mFont.tahoma_7_white.gameAA(var1, var9.description[var8], gameGA + 5, this.gameGE += 12, 0);
                    }

                    mFont.tahoma_7_white.gameAA(var1, mResources.gameMS[var9.type], gameGA + 5, this.gameGE += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameKX + ": " + var9.maxPoint, gameGA + 5, this.gameGE += 12, 0);
                    mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameKV, String.valueOf(var10.point)), gameGA + 5, this.gameGE += 12, 0);
                    this.gameAA(var1, var10);
                    this.gameAB(var1, var10);
                } else {
                    mFont.tahoma_7b_white.gameAA(var1, var9.name, gameGA + 5, this.gameGE += 12, 0);

                    for (var8 = 0; var8 < var9.description.length; ++var8) {
                        mFont.tahoma_7_white.gameAA(var1, var9.description[var8], gameGA + 5, this.gameGE += 12, 0);
                    }

                    mFont.tahoma_7_white.gameAA(var1, mResources.gameMS[var9.type], gameGA + 5, this.gameGE += 12, 0);
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameKX + ": " + var9.maxPoint, gameGA + 5, this.gameGE += 12, 0);
                    if (var10.point == var9.maxPoint) {
                        mFont.tahoma_7_blue.gameAA(var1, mResources.gameKY, gameGA + 5, this.gameGE += 12, 0);
                        this.gameAA(var1, var10);
                        this.gameAB(var1, var10);
                    } else {
                        mFont.tahoma_7_blue.gameAA(var1, mResources.gameAA(mResources.gameKW, String.valueOf(var10.point)), gameGA + 5, this.gameGE += 12, 0);
                        this.gameAA(var1, var10);
                        this.gameAB(var1, var10);

                        for (var8 = 0; var8 < var9.skills.length; ++var8) {
                            if (var9.skills[var8].equals(var10)) {
                                ++var8;
                                break;
                            }
                        }

                        mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameKV, String.valueOf(var9.skills[var8].point)), gameGA + 5, this.gameGE += 12, 0);
                        this.gameAA(var1, var9.skills[var8]);
                        ++gameBO;
                        this.gameAB(var1, var9.skills[var8]);
                    }
                }

                gameBT.gameAA(gameBO, 12, var2, var5, var6, var7, true, 1);
                if (indexRow >= 0) {
                    SmallImage.gameAB(var1, 942, gameGA + 2, gameGB + 32 + indexRow * 12, 0, StaticObj.TOP_RIGHT);
                }
            }
        }

    }

    private void gameAA(mGraphics var1, String[] var2) {
        try {
            gameAB(var1);
            gameAA(var1, var2, true);
            this.gameAA(var1, Char.getMyChar().arrItemBag);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    private void gameAA(mGraphics var1, Item[] var2) {
        gameTD = var2.length / gameTC;
        gameBU.gameAA(gameTD, gameBL, gameGA, gameGB, gameTC * gameBL, 5 * gameBL, true, 6);
        gameBU.gameAA(var1, gameGA, gameGB, gameBU.width + 2, gameBU.height + 2);

        int var3;
        int var4;
        for (var3 = 0; var3 < gameTD; ++var3) {
            for (var4 = 0; var4 < gameTC; ++var4) {
                SmallImage.gameAB(var1, 154, gameGA + var4 * gameBL + gameBL / 2, gameGB + var3 * gameBL + gameBL / 2, 0, 3);
                var1.gameAA(12281361);
                var1.gameAC(gameGA + var4 * gameBL, gameGB + var3 * gameBL, gameBL, gameBL);
            }
        }

        for (var3 = 0; var3 < var2.length; ++var3) {
            Item var7;
            if ((var7 = var2[var3]) != null) {
                int var5 = var7.indexUI / gameTC;
                int var6 = var7.indexUI - var5 * gameTC;
                this.gameAA(var1, var7, gameGA + var6 * gameBL, gameGB + var5 * gameBL);
                if (var7.quantity > 1) {
                    mFont.number_yellow.gameAA(var1, "" + var7.quantity, gameGA + var6 * gameBL + gameBL, gameGB + var5 * gameBL + gameBL - mFont.number_yellow.gameAC(), 1);
                }
            }
        }

        if (gameHQ > 0 && gameBM >= 0) {
            var3 = gameBM / gameTC;
            var4 = gameBM - var3 * gameTC;
            var1.gameAA(16777215);
            var1.gameAC(gameGA + var4 * gameBL, gameGB + var3 * gameBL, gameBL, gameBL);
            gameAA(gameGA + var4 * gameBL, gameGB + var3 * gameBL, var1);
        }

    }

    private static void gameAA(mGraphics var0, short[] var1) {
        gameTD = var1.length / gameTC;
        gameBU.gameAA(gameTD, gameBL, gameGA, gameGB, gameTC * gameBL, 5 * gameBL, true, 6);
        gameBU.gameAA(var0, gameGA, gameGB, gameBU.width + 2, gameBU.height + 2);

        int var2;
        int var3;
        for (var2 = 0; var2 < gameTD; ++var2) {
            for (var3 = 0; var3 < gameTC; ++var3) {
                SmallImage.gameAB(var0, 154, gameGA + var3 * gameBL + gameBL / 2, gameGB + var2 * gameBL + gameBL / 2, 0, 3);
                var0.gameAA(12281361);
                var0.gameAC(gameGA + var3 * gameBL, gameGB + var2 * gameBL, gameBL, gameBL);
            }
        }

        for (var2 = 0; var2 < var1.length; ++var2) {
            short var6;
            if ((var6 = var1[var2]) > 0) {
                int var4 = var2 / gameTC;
                int var5 = var2 - var4 * gameTC;
                ItemTemplate var7;
                if ((var7 = ItemTemplates.gameAA(var6)) != null) {
                    SmallImage.gameAB(var0, var7.iconID, gameGA + var5 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 0, 3);
                }
            }
        }

        if (gameHQ > 0 && gameBM >= 0) {
            var2 = gameBM / gameTC;
            var3 = gameBM - var2 * gameTC;
            var0.gameAA(16777215);
            var0.gameAC(gameGA + var3 * gameBL, gameGB + var2 * gameBL, gameBL, gameBL);
            gameAA(gameGA + var3 * gameBL, gameGB + var2 * gameBL, var0);
        }

    }

    public static void gameAA(int var0, int var1, mGraphics var2) {
        var2.gameAA(gameNT, var0 - 5, var1 - 5, 0);
    }

    private static int gameAL(int var0) {
        int var1 = gameBL - 2;
        if ((var0 %= var1 << 2) >= 0 && var0 < var1) {
            return 0;
        } else if (var1 <= var0 && var0 < var1 << 1) {
            return var0 % var1;
        } else {
            return var1 << 1 <= var0 && var0 < var1 * 3 ? var1 : var1 - var0 % var1;
        }
    }

    private static int gameAM(int var0) {
        int var1 = gameBL - 2;
        if ((var0 %= var1 << 2) >= 0 && var0 < var1) {
            return var0 % var1;
        } else if (var1 <= var0 && var0 < var1 << 1) {
            return var1;
        } else {
            return var1 << 1 <= var0 && var0 < var1 * 3 ? var1 - var0 % var1 : 0;
        }
    }

    private static void gameAA(mGraphics var0, String[] var1, Item[] var2) {
        try {
            gameAB(var0);
            gameAA(var0, var1, true);
            if (var2 == null) {
                GameCanvas.gameAA(popupX + 90, popupY + 75, var0);
                mFont.tahoma_7b_white.gameAA(var0, mResources.gameBG, popupX + 90, popupY + 90, 2);
            } else {
                if (var2.length <= 30) {
                    gameTD = 5;
                } else if (var2.length % gameTC == 0) {
                    gameTD = var2.length / gameTC;
                } else {
                    gameTD = var2.length / gameTC + 1;
                }

                gameBU.gameAA(gameTD, gameBL, gameGA, gameGB, gameTC * gameBL, 5 * gameBL, true, 6);
                gameBU.gameAA(var0, gameGA, gameGB, gameBU.width + 2, gameBU.height + 2);

                int var3;
                int var7;
                for (var7 = 0; var7 < gameTD; ++var7) {
                    for (var3 = 0; var3 < gameTC; ++var3) {
                        SmallImage.gameAB(var0, 154, gameGA + var3 * gameBL + gameBL / 2, gameGB + var7 * gameBL + gameBL / 2, 0, 3);
                        var0.gameAA(12281361);
                        var0.gameAC(gameGA + var3 * gameBL, gameGB + var7 * gameBL, gameBL, gameBL);
                    }
                }

                for (var7 = 0; var7 < var2.length; ++var7) {
                    Item var8;
                    if ((var8 = var2[var7]) != null) {
                        int var4 = var8.indexUI / gameTC;
                        int var5 = var8.indexUI - var4 * gameTC;
                        if (!var8.isLock) {
                            var0.gameAA(12083);
                            var0.gameAD(gameGA + var5 * gameBL + 1, gameGB + var4 * gameBL + 1, gameBL - 1, gameBL - 1);
                            SmallImage.gameAB(var0, 154, gameGA + var5 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 0, 3);
                        }

                        if (var8.gameAV()) {
                            var0.gameAA(GameCanvas.gameBX, gameGA + var5 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 3);
                        }

                        SmallImage.gameAA(var0, var8.template.iconID, gameGA + var5 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 0, 3);
                    }
                }

                if (gameHQ > 0 && gameBM >= 0) {
                    var7 = gameBM / gameTC;
                    var3 = gameBM - var7 * gameTC;
                    var0.gameAA(16777215);
                    var0.gameAC(gameGA + var3 * gameBL, gameGB + var7 * gameBL, gameBL, gameBL);
                    gameAA(gameGA + var3 * gameBL, gameGB + var7 * gameBL, var0);
                }
            }
        } catch (Exception var6) {
        }
    }

    private static void gameAA(mGraphics var0, String[] var1, boolean var2) {
        Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
        if (var2) {
            mFont.tahoma_7_white.gameAA(var0, mResources.gamePE + ": " + NinjaUtil.gameAA(String.valueOf(Char.getMyChar().xu)), popupX + 6, popupY + gameGD - 26, 0);
            mFont.tahoma_7_white.gameAA(var0, mResources.gamePF + ": " + NinjaUtil.gameAA(String.valueOf(Char.getMyChar().yen)), popupX + gameGC - 6, popupY + gameGD - 26, 1);
            if (isPaintTrade) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.gameAA(var0, mResources.gameGF, popupX + gameGC / 2, popupY + gameGD - 14, 2);
                }
            } else if (gameMC) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.gameAA(var0, mResources.gameGD, popupX + gameGC / 2, popupY + gameGD - 14, 2);
                }
            } else if (gameME) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.gameAA(var0, mResources.gameGE, popupX + gameGC / 2, popupY + gameGD - 14, 2);
                }
            } else {
                mFont.tahoma_7_yellow.gameAA(var0, mResources.gamePG + ": " + NinjaUtil.gameAA(String.valueOf(Char.getMyChar().luong)), popupX + gameGC / 2, popupY + gameGD - 14, 2);
            }
        }

        gameAA(var0, var1[gameBP], var1.length > 1);
        gameGA = popupX + 3;
        gameGB = popupY + 32;
        var0.gameAA(6425);
        var0.gameAD(gameGA - 1, gameGB - 1, gameTC * gameBL + 3, 5 * gameBL + 3);
    }

    private void gameAB(mGraphics var1, String[] var2) {
        try {
            gameTD = 3;
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            gameAA(var1, var2[gameBP], var2.length > 1);
            gameGA = popupX + 3;
            gameGB = popupY + 34 + gameBL;
            int var9 = popupX + 45;
            int var3 = popupX + 100;
            int var4 = gameGB - gameBL - 3;
            if (arritemup != null) {
                this.gameAA(var1, arritemup, var9, var4);
                var1.gameAA(12281361);
                var1.gameAC(var9, var4, gameBL, gameBL);
                mFont.tahoma_7_yellow.gameAA(var1, "(+" + arritemup.upgrade + ")", var9 - 5, var4 + gameBL / 2 - 5, 1);
            } else {
                var1.gameAA(6425);
                var1.gameAD(var9 - 1, var4 - 1, gameBL + 3, gameBL + 3);
                SmallImage.gameAB(var1, 154, var9 + gameBL / 2, var4 + gameBL / 2, 0, 3);
                var1.gameAA(12281361);
                var1.gameAC(var9, var4, gameBL, gameBL);
            }

            SmallImage.gameAB(var1, 942, var9 + 43, gameGB - 15, 0, StaticObj.VCENTER_HCENTER);
            if (arritemup != null && !arritemup.gameAP()) {
                this.gameAA(var1, arritemup, var3, var4, 1, 0);
                var1.gameAA(12281361);
                var1.gameAC(var3, var4, gameBL, gameBL);
                mFont.tahoma_7_yellow.gameAA(var1, "(+" + (arritemup.upgrade + 1) + ")", var3 + gameBL + 10, var4 + gameBL / 2 - 5, 0);
            } else {
                var1.gameAA(6425);
                var1.gameAD(var3 - 1, var4 - 1, gameBL + 3, gameBL + 3);
                SmallImage.gameAB(var1, 154, var3 + gameBL / 2, var4 + gameBL / 2, 0, 3);
                var1.gameAA(12281361);
                var1.gameAC(var3, var4, gameBL, gameBL);
            }

            if (gameHQ == 1) {
                if (gameBM == 0) {
                    var1.gameAA(16777215);
                    var1.gameAC(var9, var4, gameBL, gameBL);
                }

                if (gameBM == 1) {
                    var1.gameAA(16777215);
                    var1.gameAC(var3, var4, gameBL, gameBL);
                }
            }

            int var5;
            int var6;
            if (arritemup != null) {
                if (arritemup.gameAP()) {
                    if (!GameCanvas.gameAI) {
                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameHV[3], popupX + gameGC / 2, gameGB + gameTD * gameBL + 5, 2);
                    } else {
                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameHV[3], popupX + 7, gameGB + gameTD * gameBL + 5, 0);
                    }
                } else {
                    var3 = 0;

                    for (var5 = 0; var5 < upitem.length; ++var5) {
                        if (upitem[var5] != null && upitem[var5].template.type == 26) {
                            var3 += crystals[upitem[var5].template.id];
                        }
                    }

                    var6 = 0;
                    if (arritemup.gameAR()) {
                        if ((var5 = var3 * 100 / upClothe[arritemup.upgrade]) > maxPercents[arritemup.upgrade]) {
                            var5 = maxPercents[arritemup.upgrade];
                        }

                        if (gameMB) {
                            var5 = (int) ((double) var5 * 5.30239915E-315D);
                            var6 = goldUps[arritemup.upgrade];
                        }

                        if (coinUpClothes[arritemup.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpClothes[arritemup.upgrade]))), gameGA, gameGB + gameTD * gameBL + 5, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpClothes[arritemup.upgrade]))), gameGA, gameGB + gameTD * gameBL + 5, 0);
                        }

                        if (var6 > Char.getMyChar().luong) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameKA, String.valueOf(var6)), gameGA, gameGB + gameTD * gameBL + 17, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKA, String.valueOf(var6)), gameGA, gameGB + gameTD * gameBL + 17, 0);
                        }

                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameKC + ": " + var5 + "%", gameGA, gameGB + gameTD * gameBL + 29, 0);
                    } else if (arritemup.gameAS()) {
                        if ((var5 = var3 * 100 / upAdorn[arritemup.upgrade]) > maxPercents[arritemup.upgrade]) {
                            var5 = maxPercents[arritemup.upgrade];
                        }

                        if (gameMB) {
                            var5 = (int) ((double) var5 * 5.30239915E-315D);
                            var6 = goldUps[arritemup.upgrade];
                        }

                        if (coinUpAdorns[arritemup.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpAdorns[arritemup.upgrade]))), gameGA, gameGB + gameTD * gameBL + 5, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpAdorns[arritemup.upgrade]))), gameGA, gameGB + gameTD * gameBL + 5, 0);
                        }

                        if (var6 > Char.getMyChar().luong) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameKA, String.valueOf(var6)), gameGA, gameGB + gameTD * gameBL + 17, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKA, String.valueOf(var6)), gameGA, gameGB + gameTD * gameBL + 17, 0);
                        }

                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameKC + ": " + var5 + "%", gameGA, gameGB + gameTD * gameBL + 29, 0);
                    } else if (arritemup.gameAT()) {
                        if ((var5 = var3 * 100 / upWeapon[arritemup.upgrade]) > maxPercents[arritemup.upgrade]) {
                            var5 = maxPercents[arritemup.upgrade];
                        }

                        if (gameMB) {
                            var5 = (int) ((double) var5 * 5.30239915E-315D);
                            var6 = goldUps[arritemup.upgrade];
                        }

                        if (coinUpWeapons[arritemup.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpWeapons[arritemup.upgrade]))), gameGA, gameGB + gameTD * gameBL + 5, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpWeapons[arritemup.upgrade]))), gameGA, gameGB + gameTD * gameBL + 5, 0);
                        }

                        if (var6 > Char.getMyChar().luong) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gameAA(mResources.gameKA, String.valueOf(var6)), gameGA, gameGB + gameTD * gameBL + 17, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKA, String.valueOf(var6)), gameGA, gameGB + gameTD * gameBL + 17, 0);
                        }

                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameKC + ": " + var5 + "%", gameGA, gameGB + gameTD * gameBL + 29, 0);
                    }
                }
            } else {
                for (var3 = 0; var3 < 3; ++var3) {
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameHV[var3], gameGA, gameGB + gameTD * gameBL + 5 + var3 * 12, 0);
                }
            }

            var1.gameAA(0);
            var1.gameAD(gameGA - 1, gameGB - 1, gameTC * gameBL + 3, gameTD * gameBL + 3);

            for (var3 = 0; var3 < gameTD; ++var3) {
                for (var5 = 0; var5 < gameTC; ++var5) {
                    SmallImage.gameAB(var1, 154, gameGA + var5 * gameBL + gameBL / 2, gameGB + var3 * gameBL + gameBL / 2, 0, 3);
                    var1.gameAA(12281361);
                    var1.gameAC(gameGA + var5 * gameBL, gameGB + var3 * gameBL, gameBL, gameBL);
                }
            }

            if (gameHQ == 2) {
                var3 = gameBM / gameTC;
                var5 = gameBM - var3 * gameTC;
                var1.gameAA(16777215);
                var1.gameAC(gameGA + var5 * gameBL, gameGB + var3 * gameBL, gameBL, gameBL);
            }

            for (var3 = 0; var3 < upitem.length; ++var3) {
                Item var10;
                if ((var10 = upitem[var3]) != null) {
                    var6 = var3 / gameTC;
                    int var7 = var3 - var6 * gameTC;
                    if (!var10.isLock) {
                        var1.gameAA(12083);
                        var1.gameAD(gameGA + var7 * gameBL + 1, gameGB + var6 * gameBL + 1, gameBL - 1, gameBL - 1);
                    }

                    SmallImage.gameAB(var1, var10.template.iconID, gameGA + var7 * gameBL + gameBL / 2, gameGB + var6 * gameBL + gameBL / 2, 0, 3);
                }
            }

            if (gameGG != null) {
                SmallImage.gameAB(var1, gameGG.arrEfInfo[gameGF].idImg, var9 + gameBL / 2 + gameGG.arrEfInfo[gameGF].dx + 1, var4 + gameBL / 2 + 9 + gameGG.arrEfInfo[gameGF].dy, 0, 3);
                if (GameCanvas.gameTick % 2 == 0 && ++gameGF >= gameGG.arrEfInfo.length) {
                    gameGF = 0;
                    gameGG = null;
                    return;
                }
            }

        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    private void gameAA(mGraphics var1, Item var2, int var3, int var4) {
        this.gameAA(var1, var2, var3, var4, 0, 0);
    }

    private void gameAA(mGraphics var1, Item var2, int var3, int var4, int var5, int var6) {
        if (!var2.gameAC()) {
            if ((var5 += var2.upgrade) > 0) {
                if (var5 >= 1) {
                    Image[][] bgItems = {
                        {GameCanvas.bgitem1x1, GameCanvas.bgitem1x2, GameCanvas.bgitem1x3, GameCanvas.bgitem1x4}, // cấp 1-3
                        {GameCanvas.bgitem2x1, GameCanvas.bgitem2x2, GameCanvas.bgitem2x3, GameCanvas.bgitem2x4}, // cấp 4-7
                        {GameCanvas.bgitem3x1, GameCanvas.bgitem3x2, GameCanvas.bgitem3x3, GameCanvas.bgitem3x4}, // cấp 8-11
                        {GameCanvas.bgitem4x1, GameCanvas.bgitem4x2, GameCanvas.bgitem4x3, GameCanvas.bgitem4x4}, // cấp 12-14
                        {GameCanvas.bgitem5x1, GameCanvas.bgitem5x2, GameCanvas.bgitem5x3, GameCanvas.bgitem5x4}, // cấp 15-16
                        {GameCanvas.bgitem6x1, GameCanvas.bgitem6x2, GameCanvas.bgitem6x3, GameCanvas.bgitem6x4}, // cấp 17
                        {GameCanvas.bgitem7x1, GameCanvas.bgitem7x2, GameCanvas.bgitem7x3, GameCanvas.bgitem7x4}, // cấp 18
                        {GameCanvas.bgitem8x1, GameCanvas.bgitem8x2, GameCanvas.bgitem8x3, GameCanvas.bgitem8x4}, // cấp 19
                        {GameCanvas.bgitem9x1, GameCanvas.bgitem9x2, GameCanvas.bgitem9x3, GameCanvas.bgitem9x4} // cấp 20
                
                    };
                    int index = (var5 >= 20) ? 8 :(var5 >= 19) ? 7 :(var5 >= 18) ? 6 :(var5 >= 17) ? 5 : (var5 >= 15) ? 4 : (var5 >= 12) ? 3
                            : (var5 >= 8) ? 2 : (var5 >= 4) ? 1 : 0;
                    MyImage var10 = new MyImage();
                    if (GameCanvas.gameTick % 6 == 0) {
                        var10.indexFrame = (byte)((var10.indexFrame + 1) % 4);
                    }
                    if (index < bgItems.length && var10.indexFrame < bgItems[index].length) {
                        var1.gameAA(bgItems[index][var10.indexFrame], 0, 0, gameBL - 2 * var6, gameBL - 2 * var6,
                            0, var3 + var6, var4 + var6, mGraphics.TOP | mGraphics.LEFT);

                    var1.drawRect(var3 + 1 + var6, var4 + 1 + var6, gameBL - 1 - 2 * var6, gameBL - 1 - 2 * var6);
                    }
                } else {
                    gameAA(var1, var2, var3, var4, var6);
                }

                if (var5 > 0) {
                    this.gameAA(var3 + gameBL / 2, var4 + gameBL / 2, var5, var1);
                }
            } else {
                gameAA(var1, var2, var3, var4, var6);
            }
        }

        if (var2.gameAV()) {
            var1.gameAA(GameCanvas.gameBX, var3 + gameBL / 2, var4 + gameBL / 2, 3);
        }

        SmallImage.gameAA(var1, var2.template.iconID, var3 + gameBL / 2, var4 + gameBL / 2, 0, mGraphics.gameAD | mGraphics.gameAC);
    }

    public final void gameAA(int var1, int var2, int var3, mGraphics var4) {
        int var5 = gameBL - 2;
        int var6 = var3 >= 4
                ? (var3 < 8 ? 1
                        : (var3 < 12 ? 2
                                : (var3 > 14
                                        ? (var3 > 16 ? 5 : 4) : 3))) : 0;
        int var7;
        int var8;
        int var9;
        for (var7 = 0; var7 < this.gameTG.length; ++var7) {
            var8 = var1 - var5 / 2 + gameAM(GameCanvas.gameTick - (var7 << 2));
            var9 = var2 - var5 / 2 + gameAL(GameCanvas.gameTick - (var7 << 2));
            var4.gameAA(this.gameTF[var6][var7]);
            var4.gameAD(var8 - this.gameTG[var7] / 2, var9 - this.gameTG[var7] / 2, this.gameTG[var7], this.gameTG[var7]);
        }

        if (var3 == 4 || var3 == 8) {
            for (var7 = 0; var7 < this.gameTG.length; ++var7) {
                var8 = var1 - var5 / 2 + gameAM(GameCanvas.gameTick - (var5 << 1) - (var7 << 2));
                var9 = var2 - var5 / 2 + gameAL(GameCanvas.gameTick - (var5 << 1) - (var7 << 2));
                var4.gameAA(this.gameTF[var6 - 1][var7]);
                var4.gameAD(var8 - this.gameTG[var7] / 2, var9 - this.gameTG[var7] / 2, this.gameTG[var7], this.gameTG[var7]);
            }
        }

        if (var3 != 1 && var3 != 4 && var3 != 8) {
            for (var7 = 0; var7 < this.gameTG.length; ++var7) {
                var8 = var1 - var5 / 2 + gameAM(GameCanvas.gameTick - (var5 << 1) - (var7 << 2));
                var9 = var2 - var5 / 2 + gameAL(GameCanvas.gameTick - (var5 << 1) - (var7 << 2));
                var4.gameAA(this.gameTF[var6][var7]);
                var4.gameAD(var8 - this.gameTG[var7] / 2, var9 - this.gameTG[var7] / 2, this.gameTG[var7], this.gameTG[var7]);
            }
        }

        if (var3 != 1 && var3 != 4 && var3 != 8 && var3 != 12 && var3 != 2 && var3 != 5 && var3 != 9) {
            for (var7 = 0; var7 < this.gameTG.length; ++var7) {
                var8 = var1 - var5 / 2 + gameAM(GameCanvas.gameTick - var5 - (var7 << 2));
                var9 = var2 - var5 / 2 + gameAL(GameCanvas.gameTick - var5 - (var7 << 2));
                var4.gameAA(this.gameTF[var6][var7]);
                var4.gameAD(var8 - this.gameTG[var7] / 2, var9 - this.gameTG[var7] / 2, this.gameTG[var7], this.gameTG[var7]);
            }
        }

        if (var3 != 1 && var3 != 4 && var3 != 8 && var3 != 12 && var3 != 2 && var3 != 5 && var3 != 9 && var3 != 13 && var3 != 3 && var3 != 6 && var3 != 10 && var3 != 15) {
            for (var7 = 0; var7 < this.gameTG.length; ++var7) {
                var8 = var1 - var5 / 2 + gameAM(GameCanvas.gameTick - var5 * 3 - (var7 << 2));
                var9 = var2 - var5 / 2 + gameAL(GameCanvas.gameTick - var5 * 3 - (var7 << 2));
                var4.gameAA(this.gameTF[var6][var7]);
                var4.gameAD(var8 - this.gameTG[var7] / 2, var9 - this.gameTG[var7] / 2, this.gameTG[var7], this.gameTG[var7]);
            }
        }

    }

    private static void gameAA(mGraphics var0, Item var1, int var2, int var3, int var4) {
        if (!var1.isLock) {
            var0.gameAA(12083);
        } else {
            var0.gameAA(6425);
        }

        var0.gameAD(var2 + 1 + var4, var3 + 1 + var4, gameBL - 2 - (var4 << 1), gameBL - 2 - (var4 << 1));
        SmallImage.gameAB(var0, 154, var2 + gameBL / 2, var3 + gameBL / 2, 0, 3);
    }

    private void gameAC(mGraphics var1, String[] var2) {
        try {
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            gameAA(var1, var2[gameBP], var2.length > 1);
            gameGA = popupX + 3;
            gameGB = popupY + 34 + gameBL;
            int var9 = popupX + 74;
            int var3 = gameGB - gameBL - 3;
            gameTD = 4;
            if (gameDD != null) {
                this.gameAA(var1, gameDD, var9, var3);
            } else {
                var1.gameAA(6425);
                var1.gameAD(var9 - 1, var3 - 1, gameBL + 3, gameBL + 3);
                SmallImage.gameAB(var1, 154, var9 + gameBL / 2, var3 + gameBL / 2, 0, 3);
            }

            var1.gameAA(12281361);
            var1.gameAC(var9, var3, gameBL, gameBL);
            var1.gameAA(6425);
            var1.gameAD(gameGA - 1, gameGB - 1, gameBL * gameTC + 3, gameBL * gameTD + 3);

            int var4;
            int var5;
            for (var4 = 0; var4 < gameTD; ++var4) {
                for (var5 = 0; var5 < gameTC; ++var5) {
                    SmallImage.gameAB(var1, 154, gameGA + var5 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 0, 3);
                    var1.gameAA(12281361);
                    var1.gameAC(gameGA + var5 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
                }
            }

            for (var4 = 0; var4 < gameCV.length; ++var4) {
                Item var6;
                if ((var6 = gameCV[var4]) != null) {
                    var5 = var4 / gameTC;
                    int var7 = var4 - var5 * gameTC;
                    if (!var6.isLock) {
                        var1.gameAA(12083);
                        var1.gameAD(gameGA + var7 * gameBL + 1, gameGB + var5 * gameBL + 1, gameBL - 1, gameBL - 1);
                    }

                    SmallImage.gameAB(var1, var6.template.iconID, gameGA + var7 * gameBL + gameBL / 2, gameGB + var5 * gameBL + gameBL / 2, 0, 3);
                }
            }

            if (gameHQ == 1) {
                var1.gameAA(16777215);
                var1.gameAC(var9, var3, gameBL, gameBL);
            } else if (gameHQ == 2) {
                var4 = gameBM / gameTC;
                var5 = gameBM - var4 * gameTC;
                var1.gameAA(16777215);
                var1.gameAC(gameGA + var5 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
            }

            if (gameGG != null) {
                SmallImage.gameAB(var1, gameGG.arrEfInfo[gameGF].idImg, var9 + gameBL / 2 + gameGG.arrEfInfo[gameGF].dx, var3 + gameBL / 2 + gameGG.arrEfInfo[gameGF].dy, 0, 3);
                if (GameCanvas.gameTick % 2 == 0 && ++gameGF >= gameGG.arrEfInfo.length) {
                    gameGF = 0;
                    gameGG = null;
                }
            }

            if (gameMM && gameDD != null) {
                ItemOption var12 = null;

                for (var5 = 0; var5 < gameDD.options.size() && (var12 = (ItemOption) gameDD.options.elementAt(var5)).optionTemplate.id != 85; ++var5) {
                    var12 = null;
                }

                if (var12 != null) {
                    int[] var13 = new int[]{60, 45, 34, 26, 20, 15, 11, 8, 6};
                    int[] var10 = new int[]{150000, 247500, 408375, 673819, 1111801, 2056832, 4010822, 7420021, 12243035};
                    byte[] var11 = new byte[]{3, 5, 9, 4, 7, 10, 5, 7, 9};
                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameXB + ": " + NinjaUtil.gameAA(String.valueOf(var12.param + 1)), gameGA + 1, gameGB + 114, 0);
                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameKD + var13[var12.param] + "%)", gameGA + 70, gameGB + 114, 0);
                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameBJ + ": " + NinjaUtil.gameAA(String.valueOf(var10[var12.param])) + " " + mResources.gamePF + ", " + var11[var12.param] + " " + (var12.param < 3 ? mResources.gameXF[1] : (var12.param < 6 ? mResources.gameXF[2] : mResources.gameXF[3])), gameGA + 1, gameGB + 126, 0);
                } else {
                    mFont.tahoma_7_red.gameAA(var1, mResources.gameWX, gameGA + 1, gameGB + 120, 0);
                }
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    private static void gameAD(mGraphics var0, String[] var1) {
        try {
            gameAB(var0);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, var1[gameBP], var1.length > 1);
            gameGA = popupX + 3;
            gameGB = popupY + 32;
            var0.gameAA(6425);
            gameTD = 4;
            int var2;
            int var3;
            int var4;
            int var7;
            if (gameMC) {
                var7 = 0;
                var4 = 0;
                var2 = 0;
                boolean var5 = false;

                for (var3 = 0; var3 < gameCT.length; ++var3) {
                    if (gameCT[var3] != null) {
                        if (gameCT[var3].isLock) {
                            var5 = true;
                        }

                        var7 += crystals[gameCT[var3].template.id];
                        ++var4;
                    }
                }

                if (var7 > 0) {
                    for (var2 = crystals.length - 1; var2 >= 0 && var7 <= crystals[var2]; --var2) {
                    }
                }

                if (var2 >= crystals.length - 1) {
                    var2 = crystals.length - 2;
                }

                if (gameHS) {
                    if (var4 > 1) {
                        mFont.tahoma_7_yellow.gameAA(var0, mResources.gameHY + " " + (var2 + 2) + " " + (var5 ? mResources.gameBU : ""), gameGA + 3, gameGB + gameTD * gameBL + 9, 0);
                        if (coinUpCrystals[var2 + 1] > Char.getMyChar().xu) {
                            mFont.tahoma_7_red.gameAA(var0, mResources.gameAA(mResources.gameKB, NinjaUtil.gameAA(String.valueOf(coinUpCrystals[var2 + 1]))), gameGA + 3, gameGB + gameTD * gameBL + 21, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var0, mResources.gameAA(mResources.gameKB, NinjaUtil.gameAA(String.valueOf(coinUpCrystals[var2 + 1]))), gameGA + 3, gameGB + gameTD * gameBL + 21, 0);
                        }

                        mFont.tahoma_7_yellow.gameAA(var0, mResources.gameKC + ": " + var7 * 100 / crystals[var2 + 1] + "%", gameGA + 3, gameGB + gameTD * gameBL + 33, 0);
                    } else {
                        for (var3 = 1; var3 <= 2; ++var3) {
                            mFont.tahoma_7_white.gameAA(var0, mResources.gameHU[var3], gameGA + 3, gameGB + gameTD * gameBL + 5 + (var3 - 1) * 12, 0);
                        }
                    }
                } else if (var4 > 1) {
                    mFont.tahoma_7_yellow.gameAA(var0, mResources.gameHY + " " + (var2 + 2) + " " + mResources.gameBU, gameGA + 3, gameGB + gameTD * gameBL + 9, 0);
                    if (coinUpCrystals[var2 + 1] > Char.getMyChar().xu + Char.getMyChar().yen) {
                        mFont.tahoma_7_red.gameAA(var0, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpCrystals[var2 + 1]))), gameGA + 3, gameGB + gameTD * gameBL + 21, 0);
                    } else {
                        mFont.tahoma_7_yellow.gameAA(var0, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(coinUpCrystals[var2 + 1]))), gameGA + 3, gameGB + gameTD * gameBL + 21, 0);
                    }

                    mFont.tahoma_7_yellow.gameAA(var0, mResources.gameKC + ": " + var7 * 100 / crystals[var2 + 1] + "%", gameGA + 3, gameGB + gameTD * gameBL + 33, 0);
                } else {
                    for (var3 = 0; var3 < 3; ++var3) {
                        mFont.tahoma_7_white.gameAA(var0, mResources.gameHU[var3], gameGA + 3, gameGB + gameTD * gameBL + 5 + var3 * 12, 0);
                    }
                }
            } else {
                mFont.tahoma_7_white.gameAA(var0, mResources.gameWO[0], gameGA + 3, gameGB + gameTD * gameBL + 9, 0);
                mFont.tahoma_7_white.gameAA(var0, mResources.gameWO[1], gameGA + 3, gameGB + gameTD * gameBL + 21, 0);
                mFont.tahoma_7_white.gameAA(var0, mResources.gameWO[2], gameGA + 3, gameGB + gameTD * gameBL + 33, 0);
            }

            var0.gameAA(0);
            var0.gameAD(gameGA, gameGB, gameTC * gameBL + 1, gameTD * gameBL + 1);

            for (var7 = 0; var7 < gameTD; ++var7) {
                for (var4 = 0; var4 < gameTC; ++var4) {
                    SmallImage.gameAB(var0, 154, gameGA + var4 * gameBL + gameBL / 2, gameGB + var7 * gameBL + gameBL / 2, 0, 3);
                    var0.gameAA(12281361);
                    var0.gameAC(gameGA + var4 * gameBL, gameGB + var7 * gameBL, gameBL, gameBL);
                }
            }

            for (var7 = 0; var7 < gameCT.length; ++var7) {
                Item var8;
                if ((var8 = gameCT[var7]) != null) {
                    var2 = var7 / gameTC;
                    var3 = var7 - var2 * gameTC;
                    if (!var8.isLock) {
                        var0.gameAA(4543829);
                        var0.gameAD(gameGA + var3 * gameBL + 1, gameGB + var2 * gameBL + 1, gameBL - 1, gameBL - 1);
                    }

                    SmallImage.gameAB(var0, var8.template.iconID, gameGA + var3 * gameBL + gameBL / 2, gameGB + var2 * gameBL + gameBL / 2, 0, 3);
                }
            }

            if (gameHQ > 0) {
                var7 = gameBM / gameTC;
                var4 = gameBM - var7 * gameTC;
                var0.gameAA(16777215);
                var0.gameAC(gameGA + var4 * gameBL, gameGB + var7 * gameBL, gameBL, gameBL);
            }

            if (gameGG != null) {
                SmallImage.gameAB(var0, gameGG.arrEfInfo[gameGF].idImg, gameGA + gameBL / 2 + gameGG.arrEfInfo[gameGF].dx + 1, gameGB + gameBL / 2 + 9 + gameGG.arrEfInfo[gameGF].dy, 0, 3);
                if (GameCanvas.gameTick % 2 == 0 && ++gameGF >= gameGG.arrEfInfo.length) {
                    gameGF = 0;
                    gameGG = null;
                    return;
                }
            }

        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    private void gameAO(mGraphics var1) {
        if (gameMJ) {
            gameAB(var1);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            int var2 = gameGC;
            if (GameCanvas.gameAI) {
                var2 = gameGC / 2 + 20;
            }

            var1.gameAA(0);
            var1.gameAD(popupX + 7, popupY + 31, var2 - 14, gameGD - 58);
            var1.gameAA(-3170504);
            var1.gameAC(popupX + 8, popupY + 32, var2 - 16, gameGD - 60);
            var1.gameAA(Paint.COLORBACKGROUND);
            var1.gameAD(popupX + 9, popupY + 33, var2 - 18, gameGD - 62);
            gameAA(var1, mResources.gameVV, false);
            gameGA = popupX + 33;
            gameGB = popupY + 40;

            int var3;
            for (var2 = 0; var2 < 3; ++var2) {
                for (var3 = 0; var3 < 3; ++var3) {
                    var1.gameAA(Paint.COLORDARK);
                    var1.gameAD(gameGA + var3 * 40, gameGB + 10 + var2 * 40, 29, 29);
                    var1.gameAA(-6527695);
                    var1.gameAC(gameGA + var3 * 40, gameGB + 10 + var2 * 40, 29, 29);
                    var1.gameAA(-6737152);
                    var1.gameAD(gameGA + var3 * 40 + 2, gameGB + 12 + var2 * 40, 26, 26);
                    var1.gameAA(Paint.COLORDARK);
                    var1.gameAD(gameGA + var3 * 40 + 4, gameGB + 14 + var2 * 40, 22, 22);
                    SmallImage.gameAB(var1, 1414, gameGA + var3 * 40 + 20 - 5, gameGB + var2 * 40 + 20 + 4, 0, StaticObj.VCENTER_HCENTER);
                }
            }

            for (var2 = 0; var2 < 9; ++var2) {
                int var4;
                int var5;
                mGraphics var6;
                label75:
                {
                    var3 = var2 / 3;
                    var4 = var2 - var3 * 3;
                    if (gameDA != null) {
                        var1.gameAA(-16770791);
                        var1.gameAD(gameGA + var4 * 40 + 4, gameGB + 14 + var3 * 40, 22, 22);
                        var1.gameAA(var2 == gameBM ? -1 : -6527695);
                        var1.gameAC(gameGA + var4 * 40 + 4, gameGB + 14 + var3 * 40, 21, 21);
                        SmallImage.gameAB(var1, 154, gameGA + var4 * 40 + 17 - 3, gameGB + 7 + var3 * 40 + 17, 0, 3);
                        if (System.currentTimeMillis() - this.gameFE < 1000L) {
                            if (var2 == gameBQ) {
                                SmallImage.gameAB(var1, ItemTemplates.gameAB(gameDA[gameBQ]), gameGA + var4 * 40 + 17 - 3, gameGB + 7 + var3 * 40 + 17, 0, 3);
                            } else {
                                SmallImage.gameAB(var1, 1414, gameGA + var4 * 40 + 17 - 2, gameGB + 7 + var3 * 40 + 17, 0, StaticObj.VCENTER_HCENTER);
                            }
                        } else if (gameDA[var2] >= 0 && gameDA[var2] < ItemTemplates.itemTemplates.size()) {
                            SmallImage.gameAB(var1, ItemTemplates.gameAB(gameDA[var2]), gameGA + var4 * 40 + 17 - 3, gameGB + 7 + var3 * 40 + 17, 0, 3);
                        } else {
                            SmallImage.gameAB(var1, ItemTemplates.gameAB((short) 242), gameGA + var4 * 40 + 17 - 3, gameGB + 7 + var3 * 40 + 17, 0, 3);
                        }

                        if (gameBQ == var2 && this.gameFG > 0) {
                            this.gameFI[var2] = String.valueOf(this.gameFG);
                        }

                        if (gameHQ != 1) {
                            continue;
                        }

                        if (gameBQ == var2 && GameCanvas.gameTick % 10 > 4) {
                            var6 = var1;
                            var5 = -3368653;
                            break label75;
                        }

                        if (var2 == gameBM) {
                            var6 = var1;
                            var5 = -1;
                            break label75;
                        }

                        var6 = var1;
                    } else {
                        if (gameHQ != 1) {
                            continue;
                        }

                        var6 = var1;
                        if (var2 == gameBM) {
                            var5 = -1;
                            break label75;
                        }
                    }

                    var5 = Paint.COLORLIGHT;
                }

                var6.gameAA(var5);
                var1.gameAC(gameGA + var4 * 40, gameGB + 10 + var3 * 40, 29, 29);
            }

            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameVW + this.gameDB, popupX + gameGC / 2, popupY + gameGD - 20, 2);
        }

    }

    private void gameAP(mGraphics var1) {
        if (gameKV) {
            if (gameBP == 0) {
                gameAA(var1, mResources.gameGZ, gameCK);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameGZ);
            }
        }

    }

    private void gameAQ(mGraphics var1) {
        if (gameKW) {
            if (gameBP == 0) {
                gameAA(var1, mResources.gameHA, gameCL);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHA);
            }
        }

    }

    private void gameAR(mGraphics var1) {
        if (gameKX) {
            if (gameBP == 0) {
                gameAA(var1, mResources.gameHB, gameCM);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHB);
            }
        }

    }

    private void gameAS(mGraphics var1) {
        if (gameKY) {
            if (gameBP == 0) {
                gameAA(var1, mResources.gameHC, gameCN);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHC);
            }
        }

    }

    private void gameAT(mGraphics var1) {
        if (gameDH) {
            if (gameBP == 0) {
                String[] var2 = mResources.gameHE;
                GameScr var3 = this;

                try {
                    gameTD = 5;
                    Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
                    gameAA(var1, var2, false);
                    var1.gameAA(6693376);
                    var1.gameAD(popupX + 3, popupY + 32, 168, 140);
                    var1.gameAA(13408563);
                    var1.gameAC(popupX + 3, popupY + 32, 168, 140);
                    int var6 = popupX + 74;
                    int var4 = popupY + 40 + gameBL;
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameRZ, var6 + gameBL / 2, var4 - gameBL / 2 - 4, 2);
                    if (gameDE != null) {
                        var1.gameAA(6425);
                        var1.gameAD(var6 - 1, var4 - 1, gameBL + 3, gameBL + 3);
                        SmallImage.gameAB(var1, 154, var6 + gameBL / 2, var4 + gameBL / 2, 0, 3);
                        var3.gameAA(var1, gameDE, var6, var4);
                        if (gameDE.quantity > 1) {
                            mFont.number_yellow.gameAA(var1, String.valueOf(gameDE.quantity), var6 + gameBL, var4 + gameBL / 2 + 6, 1);
                        }

                        var1.gameAA(gameHQ == 1 ? 16777215 : 12281361);
                        var1.gameAC(var6, var4, gameBL, gameBL);
                    } else {
                        var1.gameAA(6425);
                        var1.gameAD(var6 - 1, var4 - 1, gameBL + 3, gameBL + 3);
                        SmallImage.gameAB(var1, 154, var6 + gameBL / 2, var4 + gameBL / 2, 0, 3);
                        var1.gameAA(12281361);
                        var1.gameAC(var6, var4, gameBL, gameBL);
                    }

                    mFont.tahoma_7_white.gameAA(var1, mResources.gameSA, var6 + gameBL / 2, var4 + 3 * gameBL / 2 + 2, 2);
                    if (Char.getMyChar().xu < 5000) {
                        mFont.tahoma_7_red.gameAA(var1, mResources.gameVK, var6 + gameBL / 2, popupY + gameGD - 25, 2);
                        mFont.tahoma_7_red.gameAA(var1, mResources.gameVL, var6 + gameBL / 2, popupY + gameGD - 13, 2);
                    } else {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameVK, var6 + gameBL / 2, popupY + gameGD - 25, 2);
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameVL, var6 + gameBL / 2, popupY + gameGD - 13, 2);
                    }

                    var3.gameNE.x = popupX + 40;
                    var3.gameNE.y = popupY + 130;
                    var3.gameNE.gameAA(var1);
                    return;
                } catch (Exception var5) {
                    var5.printStackTrace();
                    return;
                }
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHE);
            }
        }

    }

    private void gameAU(mGraphics var1) {
        if (gameMA) {
            if (gameBP == 0) {
                String[] var2 = mResources.gameHF;
                GameScr var3 = this;

                try {
                    gameTD = 3;
                    Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
                    gameAA(var1, var2[gameBP], var2.length > 1);
                    gameGA = popupX + 3;
                    gameGB = popupY + 34 + gameBL;
                    int var8 = popupX + 45;
                    int var4 = popupX + 100;
                    int var5 = gameGB - gameBL - 3;
                    if (gameCY[0] != null) {
                        var3.gameAA(var1, gameCY[0], var8, var5);
                        var1.gameAA(12281361);
                        var1.gameAC(var8, var5, gameBL, gameBL);
                        mFont.tahoma_7_yellow.gameAA(var1, "(+" + gameCY[0].upgrade + ")", var8 - 5, var5 + gameBL / 2 - 5, 1);
                    } else {
                        var1.gameAA(6425);
                        var1.gameAD(var8 - 1, var5 - 1, gameBL + 3, gameBL + 3);
                        SmallImage.gameAB(var1, 154, var8 + gameBL / 2, var5 + gameBL / 2, 0, 3);
                        var1.gameAA(12281361);
                        var1.gameAC(var8, var5, gameBL, gameBL);
                    }

                    SmallImage.gameAB(var1, 942, var8 + 43, gameGB - 15, 0, StaticObj.VCENTER_HCENTER);
                    Item var6;
                    if (gameCY[1] != null) {
                        var6 = gameCY[1].gameAA();
                        if (gameCY[0] != null && gameCY[0].template.type == var6.template.type && gameCY[1].template.level >= gameCY[0].template.level) {
                            var6.upgrade = gameCY[0].upgrade;
                        }

                        var3.gameAA(var1, var6, var4, var5);
                        var1.gameAA(12281361);
                        var1.gameAC(var4, var5, gameBL, gameBL);
                        mFont.tahoma_7_yellow.gameAA(var1, "(+" + var6.upgrade + ")", var4 + gameBL + 10, var5 + gameBL / 2 - 5, 0);
                    } else {
                        var1.gameAA(6425);
                        var1.gameAD(var4 - 1, var5 - 1, gameBL + 3, gameBL + 3);
                        SmallImage.gameAB(var1, 154, var4 + gameBL / 2, var5 + gameBL / 2, 0, 3);
                        var1.gameAA(12281361);
                        var1.gameAC(var4, var5, gameBL, gameBL);
                    }

                    if (gameHQ == 1) {
                        if (gameBM == 0) {
                            var1.gameAA(16777215);
                            var1.gameAC(var8, var5, gameBL, gameBL);
                        }

                        if (gameBM == 1) {
                            var1.gameAA(16777215);
                            var1.gameAC(var4, var5, gameBL, gameBL);
                        }
                    }

                    var1.gameAA(0);
                    var1.gameAD(gameGA - 1, gameGB - 1, gameTC * gameBL + 3, gameTD * gameBL + 3);

                    int var9;
                    for (var8 = 0; var8 < gameTD; ++var8) {
                        for (var9 = 0; var9 < gameTC; ++var9) {
                            SmallImage.gameAB(var1, 154, gameGA + var9 * gameBL + gameBL / 2, gameGB + var8 * gameBL + gameBL / 2, 0, 3);
                            var1.gameAA(12281361);
                            var1.gameAC(gameGA + var9 * gameBL, gameGB + var8 * gameBL, gameBL, gameBL);
                        }
                    }

                    if ((var6 = gameCY[2]) != null) {
                        var9 = 0 / gameTC;
                        var8 = 0 - var9 * gameTC;
                        if (!var6.isLock) {
                            var1.gameAA(12083);
                            var1.gameAD(gameGA + var8 * gameBL + 1, gameGB + var9 * gameBL + 1, gameBL - 1, gameBL - 1);
                        }

                        SmallImage.gameAB(var1, var6.template.iconID, gameGA + var8 * gameBL + gameBL / 2, gameGB + var9 * gameBL + gameBL / 2, 0, 3);
                    }

                    mFont.tahoma_7_white.gameAA(var1, "- " + mResources.gameFX[0], gameGA, gameGB + gameTD * gameBL + 10, 0);
                    mFont.tahoma_7_white.gameAA(var1, "  " + mResources.gameFX[1], gameGA, gameGB + gameTD * gameBL + 22, 0);
                    mFont.tahoma_7_white.gameAA(var1, "- " + mResources.gameFX[2], gameGA, gameGB + gameTD * gameBL + 34, 0);
                    if (gameHQ == 2) {
                        var9 = gameBM / gameTC;
                        var8 = gameBM - var9 * gameTC;
                        var1.gameAA(16777215);
                        var1.gameAC(gameGA + var8 * gameBL, gameGB + var9 * gameBL, gameBL, gameBL);
                        return;
                    }

                    return;
                } catch (Exception var7) {
                    var7.printStackTrace();
                    return;
                }
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHD);
            }
        }

    }

    private void gameAV(mGraphics var1) {
        if (gameME) {
            if (gameBP == 0) {
                this.gameAC(var1, mResources.gameHK);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHK);
            }
        }

    }

    private void gameAW(mGraphics var1) {
        if (gameMN) {
            if (gameBP == 0) {
                this.gameAC(var1, mResources.gameHN);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHN);
            }
        }

    }

    private void gameAX(mGraphics var1) {
        if (gameMM) {
            if (gameBP == 0) {
                this.gameAC(var1, mResources.gameHO);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHO);
            }
        }

    }

    private void gameAY(mGraphics var1) {
        if (isPaintTrade) {
            if (gameBP == 0) {
                String[] var2 = mResources.gameHL;
                GameScr var3 = this;

                try {
                    Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
                    gameAA(var1, var2[gameBP], var2.length > 1);
                    gameGA = popupX + 3;
                    gameGB = popupY + 45;
                    gameTD = 4;
                    int var8 = gameGA + 1;
                    int var4 = gameGB - 12;
                    mFont.tahoma_7_yellow.gameAA(var1, Char.getMyChar().cName, var8, var4, 0);
                    var8 = gameGA;

                    for (var4 = 0; var4 < 3; ++var4) {
                        if (var4 == var3.gameEC) {
                            mFont.tahoma_7_blue1.gameAA(var1, String.valueOf(var4 + 1), var8 + 2 + var4 * 20, gameGB + gameTD * (gameBL + 3) + 8, 0);
                        } else {
                            mFont.tahoma_7_grey.gameAA(var1, String.valueOf(var4 + 1), var8 + 2 + var4 * 20, gameGB + gameTD * (gameBL + 3) + 8, 0);
                        }

                        if (var4 < 2) {
                            SmallImage.gameAB(var1, 942, var8 + 14 + var4 * 20, gameGB + gameTD * (gameBL + 3) + 13, 0, StaticObj.VCENTER_HCENTER);
                        }
                    }

                    mFont.tahoma_7_white.gameAA(var1, NinjaUtil.gameAA(String.valueOf(var3.gameEE)) + " " + mResources.gamePE, gameGA, gameGB + gameTD * gameBL + 4, 0);
                    if (var3.gameEC == 0) {
                        var1.gameAA(0);
                    }

                    if (var3.gameEC == 1) {
                        var1.gameAA(210986);
                    }

                    if (var3.gameEC == 2) {
                        var1.gameAA(805690);
                    }

                    var1.gameAD(gameGA - 1, gameGB - 1, gameBL * 3 + 3, (gameBL << 2) + 3);

                    for (var4 = 0; var4 < gameTD; ++var4) {
                        for (var8 = 0; var8 < 3; ++var8) {
                            SmallImage.gameAB(var1, 154, gameGA + var8 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 0, 3);
                            var1.gameAA(12281361);
                            var1.gameAC(gameGA + var8 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
                        }
                    }

                    if (gameHQ == 1) {
                        var4 = gameBM / 3;
                        var8 = gameBM - var4 * 3;
                        var1.gameAA(16777215);
                        var1.gameAC(gameGA + var8 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
                    }

                    Item var5;
                    int var6;
                    if (gameCW != null) {
                        for (var4 = 0; var4 < gameCW.length; ++var4) {
                            if ((var5 = gameCW[var4]) != null) {
                                var8 = var4 / 3;
                                var6 = var4 - var8 * 3;
                                if (!var5.isLock) {
                                    var1.gameAA(12083);
                                    var1.gameAD(gameGA + var6 * gameBL + 1, gameGB + var8 * gameBL + 1, gameBL - 1, gameBL - 1);
                                }

                                if (var5.gameAV()) {
                                    var1.gameAA(GameCanvas.gameBX, gameGA + var6 * gameBL + gameBL / 2, gameGB + var8 * gameBL + gameBL / 2, 3);
                                }

                                SmallImage.gameAA(var1, var5.template.iconID, gameGA + var6 * gameBL + gameBL / 2, gameGB + var8 * gameBL + gameBL / 2, 0, 3);
                                if (var5.quantity > 1) {
                                    mFont.number_yellow.gameAA(var1, String.valueOf(var5.quantity), gameGA + var6 * gameBL + gameBL, gameGB + var8 * gameBL + gameBL - mFont.number_yellow.gameAC(), 1);
                                }

                                if (var5.quantity > 1) {
                                    mFont.number_yellow.gameAA(var1, String.valueOf(var5.quantity), gameGA + var6 * gameBL + gameBL, gameGB + var8 * gameBL + gameBL - mFont.number_yellow.gameAC(), 1);
                                }
                            }
                        }
                    }

                    gameGA = popupX + gameGC - 2 - gameBL * 3;
                    gameTD = 4;
                    mFont.tahoma_7_yellow.gameAA(var1, var3.gameEZ, popupX + gameGC - 2, gameGB - 12, 1);
                    var8 = popupX + gameGC - 3 - 60;

                    for (var4 = 0; var4 < 3; ++var4) {
                        if (var4 == var3.typeTradeOrder) {
                            mFont.tahoma_7_blue1.gameAA(var1, String.valueOf(var4 + 1), var8 + 2 + var4 * 20, gameGB + gameTD * (gameBL + 3) + 8, 0);
                        } else {
                            mFont.tahoma_7_grey.gameAA(var1, String.valueOf(var4 + 1), var8 + 2 + var4 * 20, gameGB + gameTD * (gameBL + 3) + 8, 0);
                        }

                        if (var4 < 2) {
                            SmallImage.gameAB(var1, 942, var8 + 14 + var4 * 20, gameGB + gameTD * (gameBL + 3) + 13, 0, StaticObj.VCENTER_HCENTER);
                        }
                    }

                    mFont.tahoma_7_white.gameAA(var1, NinjaUtil.gameAA(String.valueOf(var3.gameEF)) + " " + mResources.gamePE, popupX + gameGC - 2, gameGB + gameTD * gameBL + 4, 1);
                    if (var3.typeTradeOrder == 0) {
                        var1.gameAA(0);
                    }

                    if (var3.typeTradeOrder == 1) {
                        var1.gameAA(210986);
                    }

                    if (var3.typeTradeOrder == 2) {
                        var1.gameAA(805690);
                    }

                    var1.gameAD(gameGA - 1, gameGB - 1, gameBL * 3 + 3, (gameBL << 2) + 3);

                    for (var4 = 0; var4 < gameTD; ++var4) {
                        for (var8 = 0; var8 < 3; ++var8) {
                            SmallImage.gameAB(var1, 154, gameGA + var8 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 0, 3);
                            var1.gameAA(12281361);
                            var1.gameAC(gameGA + var8 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
                        }
                    }

                    if (gameHQ == 2) {
                        var4 = gameBM / 3;
                        var8 = gameBM - var4 * 3;
                        var1.gameAA(16777215);
                        var1.gameAC(gameGA + var8 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
                    }

                    if (gameCX != null) {
                        for (var4 = 0; var4 < gameCX.length; ++var4) {
                            if ((var5 = gameCX[var4]) != null) {
                                var8 = var4 / 3;
                                var6 = var4 - var8 * 3;
                                if (!var5.isLock) {
                                    var1.gameAA(12083);
                                    var1.gameAD(gameGA + var6 * gameBL + 1, gameGB + var8 * gameBL + 1, gameBL - 1, gameBL - 1);
                                }

                                if (var5.gameAV()) {
                                    var1.gameAA(GameCanvas.gameBX, gameGA + var6 * gameBL + gameBL / 2, gameGB + var8 * gameBL + gameBL / 2, 3);
                                }

                                SmallImage.gameAA(var1, var5.template.iconID, gameGA + var6 * gameBL + gameBL / 2, gameGB + var8 * gameBL + gameBL / 2, 0, 3);
                                if (var5.quantity > 1) {
                                    mFont.number_yellow.gameAA(var1, String.valueOf(var5.quantity), gameGA + var6 * gameBL + gameBL, gameGB + var8 * gameBL + gameBL - mFont.number_yellow.gameAC(), 1);
                                }

                                if (var5.quantity > 1) {
                                    mFont.number_yellow.gameAA(var1, String.valueOf(var5.quantity), gameGA + var6 * gameBL + gameBL, gameGB + var8 * gameBL + gameBL - mFont.number_yellow.gameAC(), 1);
                                }
                            }
                        }
                    }

                    var4 = (int) (System.currentTimeMillis() / 1000L);
                    if (var3.gameEG - var4 > 0 && var3.gameEC == 1 && var3.typeTradeOrder == 1) {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameBH + " " + (var3.gameEG - var4) + " " + mResources.gameQD, popupX + gameGC / 2, popupY + gameGD - 13, 2);
                        return;
                    }

                    if (var3.gameEC == 0) {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameGG, popupX + gameGC / 2, popupY + gameGD - 13, 2);
                        return;
                    }

                    return;
                } catch (Exception var7) {
                    var7.printStackTrace();
                    return;
                }
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHL);
            }
        }

    }

    private void gameAZ(mGraphics var1) {
        if (gameMC) {
            if (gameBP == 0) {
                gameAD(var1, mResources.gameHG);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHG);
            }
        }

    }

    private void gameBA(mGraphics var1) {
        if (gameML) {
            if (gameBP == 0) {
                gameAD(var1, mResources.gameHM);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHM);
            }
        }

    }

    private void gameBB(mGraphics var1) {
        if (gameMD) {
            if (gameBP == 0) {
                String[] var2 = mResources.gameHH;

                try {
                    gameAB(var1);
                    gameAA(var1, var2, false);
                    if (Char.getMyChar().arrItemBox == null) {
                        GameCanvas.gameAA(popupX + 90, popupY + 75, var1);
                        mFont.tahoma_7b_white.gameAA(var1, mResources.gameBG, popupX + 90, popupY + 90, 2);
                        return;
                    }

                    mFont.tahoma_7_white.gameAA(var1, mResources.gameGB + ": " + NinjaUtil.gameAA(String.valueOf(Char.getMyChar().xuInBox)), popupX + gameGC / 2, popupY + gameGD - 18, 2);
                    this.gameAA(var1, Char.getMyChar().arrItemBox);
                    return;
                } catch (Exception var3) {
                    var3.printStackTrace();
                    return;
                }
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHH);
            }
        }

    }

    private void gameBC(mGraphics var1) {
        if (gameVH) {
            if (gameBP == 0) {
                gameAB(var1);
                gameAA(var1, mResources.gameXN, false);
                gameAA(var1, Code.nhat);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameXN);
            }
        }

    }

    private void gameBD(mGraphics var1) {
        if (itemDell) {
            if (gameBP == 0) {
                gameAB(var1);
                gameAA(var1, mResources.gameXN, false);
                gameAA(var1, Code.dell);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameXN);
            }
        }

    }

    private void thowBD(mGraphics var1) {
        if (itemThow) {
            if (gameBP == 0) {
                gameAB(var1);
                gameAA(var1, mResources.gameXN, false);
                gameAA(var1, Code.thow);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameXN);
            }
        }

    }

    private static void gameBE(mGraphics var0) {
        if (gameBP == 2) {
            var0.gameAA(-var0.gameAA(), -var0.gameAB());
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, mResources.gameGN[gameBP], true);
            mFont.tahoma_8b.gameAA(var0, mResources.gameNG, popupX + 10, popupY + 33, 0);
            mFont.tahoma_8b.gameAA(var0, "" + Char.getMyChar().pPoint, popupX + gameGC - 10, popupY + 33, 1);
            int var1 = (gameGD - 80) / 5;

            for (int var2 = 0; var2 < Char.getMyChar().potential.length; ++var2) {
                var0.gameAA(Paint.COLORBORDER);
                if (gameHQ > 0 && gameHQ - 1 == var2) {
                    var0.gameAA(Paint.COLORDARK);
                    var0.gameAD(popupX + 5, popupY + 52 + var2 * (var1 + 4), gameGC - 10, var1);
                    var0.gameAA(Paint.COLORFOCUS);
                }

                var0.gameAC(popupX + 5, popupY + 52 + var2 * (var1 + 4), gameGC - 10, var1);
                mFont.tahoma_7b_white.gameAA(var0, "" + Char.getMyChar().potential[var2], popupX + gameGC - 10, popupY + 52 + (var1 - 10) / 2 + var2 * (var1 + 4), 1);
                mFont.tahoma_7b_white.gameAA(var0, mResources.gameMZ[var2], popupX + 10, popupY + 52 + (var1 - 10) / 2 + var2 * (var1 + 4), 0);
            }

            if (gameHQ > 0) {
                switch (Char.getMyChar().nClass.classId) {
                    case 0:
                        mFont.tahoma_7_green.gameAA(var0, mResources.gameTJ[0], popupX + 10, popupY + 52 + (var1 - 10) / 2 + 4 * (var1 + 4), 0);
                        return;
                    case 1:
                    case 3:
                    case 5:
                        mFont.tahoma_7_green.gameAA(var0, mResources.gameTK[gameHQ - 1], popupX + 10, popupY + 52 + (var1 - 10) / 2 + 4 * (var1 + 4), 0);
                        return;
                    case 2:
                    case 4:
                    case 6:
                        mFont.tahoma_7_green.gameAA(var0, mResources.gameTL[gameHQ - 1], popupX + 10, popupY + 52 + (var1 - 10) / 2 + 4 * (var1 + 4), 0);
                }
            }
        }

    }

    private static Item gameAN(int var0) {
        try {
            if (gameBM < 0) {
                return null;
            }

            switch (var0) {
                case 2:
                    if (gameCJ.length > gameBM) {
                        return gameCJ[gameBM];
                    }

                    return null;
                case 3:
                    return Char.getMyChar().arrItemBag[gameBM];
                case 4:
                    return Char.getMyChar().arrItemBox[gameBM];
                case 5:
                    return currentCharViewInfo.arrItemBody[gameBM + indextabTrangbi];
                case 6:
                    if (gameCK.length > gameBM) {
                        return gameCK[gameBM];
                    }

                    return null;
                case 7:
                    if (gameCL.length > gameBM) {
                        return gameCL[gameBM];
                    }

                    return null;
                case 8:
                    if (gameCM.length > gameBM) {
                        return gameCM[gameBM];
                    }

                    return null;
                case 9:
                    if (gameCN.length > gameBM) {
                        return gameCN[gameBM];
                    }

                    return null;
                case 10:
                    return upitem[gameBM];
                case 11:
                    return gameCT[gameBM];
                case 12:
                case 13:
                case 30:
                case 31:
                case 33:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                default:
                    break;
                case 14:
                    if (gameCO.length > gameBM) {
                        return gameCO[gameBM];
                    }

                    return null;
                case 15:
                    if (gameCR.length > gameBM) {
                        return gameCR[gameBM];
                    }

                    return null;
                case 16:
                    if (gameCF.length > gameBM) {
                        return gameCF[gameBM];
                    }

                    return null;
                case 17:
                    if (gameCG.length > gameBM) {
                        return gameCG[gameBM];
                    }

                    return null;
                case 18:
                    if (gameCH.length > gameBM) {
                        return gameCH[gameBM];
                    }

                    return null;
                case 19:
                    if (gameCI.length > gameBM) {
                        return gameCI[gameBM];
                    }

                    return null;
                case 20:
                    if (gameBV.length > gameBM) {
                        return gameBV[gameBM];
                    }

                    return null;
                case 21:
                    if (gameBW.length > gameBM) {
                        return gameBW[gameBM];
                    }

                    return null;
                case 22:
                    if (gameBX.length > gameBM) {
                        return gameBX[gameBM];
                    }

                    return null;
                case 23:
                    if (gameBY.length > gameBM) {
                        return gameBY[gameBM];
                    }

                    return null;
                case 24:
                    if (gameBZ.length > gameBM) {
                        return gameBZ[gameBM];
                    }

                    return null;
                case 25:
                    if (gameCA.length > gameBM) {
                        return gameCA[gameBM];
                    }

                    return null;
                case 26:
                    if (gameCB.length > gameBM) {
                        return gameCB[gameBM];
                    }

                    return null;
                case 27:
                    if (gameCC.length > gameBM) {
                        return gameCC[gameBM];
                    }

                    return null;
                case 28:
                    if (gameCD.length > gameBM) {
                        return gameCD[gameBM];
                    }

                    return null;
                case 29:
                    if (gameCE.length > gameBM) {
                        return gameCE[gameBM];
                    }

                    return null;
                case 32:
                    if (gameCS.length > gameBM) {
                        return gameCS[gameBM];
                    }

                    return null;
                case 34:
                    if (gameCQ.length > gameBM) {
                        return gameCQ[gameBM];
                    }

                    return null;
                case 35:
                    if (gameCP.length > gameBM) {
                        return gameCP[gameBM];
                    }

                    return null;
                case 43:
                    return gameCT[gameBM];
                case 44:
                    return gameCV[gameBM];
                case 45:
                    return gameCV[gameBM];
                case 46:
                    return gameCV[gameBM];
                case 47:
                    return upitem[gameBM];
                case 48:
                    return gameCV[gameBM];
            }
        } catch (Exception var1) {
        }

        return null;
    }

    public static void gameBC() {
        TileMap.gameAD();
    }

    private static void gameAA(mGraphics var0, String var1, boolean var2) {
        int var3 = gW / 2;
        var0.gameAA(Paint.COLORDARK);
        var0.gameAB(var3 - mFont.tahoma_8b.gameAA(var1) / 2 - 12, popupY + 4, mFont.tahoma_8b.gameAA(var1) + 22, 24, 6, 6);
        if ((gameHQ == 0 || GameCanvas.isTouch) && var2) {
            SmallImage.gameAB(var0, 989, var3 - mFont.tahoma_8b.gameAA(var1) / 2 - 15 - 7 - (GameCanvas.gameTick % 8 <= 3 ? 2 : 0), popupY + 16, 2, StaticObj.VCENTER_HCENTER);
            SmallImage.gameAB(var0, 989, var3 + mFont.tahoma_8b.gameAA(var1) / 2 + 15 + 5 + (GameCanvas.gameTick % 8 <= 3 ? 2 : 0), popupY + 16, 0, StaticObj.VCENTER_HCENTER);
        }

        if (gameHQ == 0) {
            var0.gameAA(Paint.COLORFOCUS);
        } else {
            var0.gameAA(Paint.COLORBORDER);
        }

        var0.gameAA(var3 - mFont.tahoma_8b.gameAA(var1) / 2 - 12, popupY + 4, mFont.tahoma_8b.gameAA(var1) + 22, 24, 6, 6);
        mFont.tahoma_8b.gameAA(var0, var1, var3, popupY + 9, 2);
    }

    private void gameBF(mGraphics var1) {
        if (gameMG) {
            gameAB(var1);
            gameAA(var1, new String[]{mResources.gameRH}, false);
            mFont.tahoma_7_yellow.gameAA(var1, TileMap.mapName, popupX + gameGC / 2, popupY + gameGD - 25, 2);
            if (gameBM >= 0 && gameBM < this.zones.length) {
                mFont.tahoma_7_white.gameAA(var1, mResources.gameRI + ": " + this.zones[gameBM] + ", " + mResources.gameRJ + ": " + this.gameMW[gameBM], popupX + gameGC / 2, popupY + gameGD - 13, 2);
            }

            int var2 = gameBM / this.gameMV;
            int var3 = gameBM % this.gameMV;
            gameTD = this.zones.length / this.gameMV;
            if (this.zones.length % this.gameMV > 0) {
                ++gameTD;
            }

            if (gameTD < 5) {
                gameTD = 5;
            }

            gameBU.gameAA(gameTD, gameBL, gameGA, gameGB, gameTC * gameBL + 2, 5 * gameBL + 2, true, 6);
            gameBU.gameAA(var1);
            int var4 = 0;

            for (int var5 = 0; var5 < gameTD; ++var5) {
                for (int var6 = 0; var6 < this.gameMV; ++var6) {
                    var1.gameAA(12281361);
                    var1.gameAC(gameGA + var6 * gameBL, gameGB + var5 * gameBL, gameBL, gameBL);
                    if (var4 < this.zones.length) {
                        SmallImage.gameAB(var1, 154, gameGA + var6 * gameBL + gameBL / 2, gameGB + var5 * gameBL + gameBL / 2, 0, 3);
                        if (this.zones[var4] >= 20) {
                            mFont.tahoma_7b_red.gameAA(var1, String.valueOf(var4), gameGA + var6 * gameBL + gameBL / 2, gameGB + var5 * gameBL + gameBL / 2 - 4, 2);
                        } else if (this.zones[var4] >= 15) {
                            mFont.tahoma_7b_yellow.gameAA(var1, String.valueOf(var4), gameGA + var6 * gameBL + gameBL / 2, gameGB + var5 * gameBL + gameBL / 2 - 4, 2);
                        } else {
                            mFont.tahoma_7b_white.gameAA(var1, String.valueOf(var4), gameGA + var6 * gameBL + gameBL / 2, gameGB + var5 * gameBL + gameBL / 2 - 4, 2);
                        }

                        ++var4;
                    }
                }
            }

            if (gameBM >= 0) {
                var1.gameAA(16777215);
                var1.gameAC(gameGA + var3 * gameBL, gameGB + var2 * gameBL, gameBL, gameBL);
            }
        }

    }

    private static void gameDP() {
        int var0 = 0;
        int var1 = 0;
        boolean var2 = false;
        boolean var3 = false;

        int var4;
        for (var4 = 0; var4 < gameCT.length; ++var4) {
            if (gameCT[var4] != null) {
                ++var0;
                var1 += crystals[gameCT[var4].template.id];
                if (gameCT[var4].template.id == 11) {
                    GameCanvas.msgdlg.gameAA(mResources.gameQN, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                    return;
                }
            }

            if (gameCT[var4] != null && gameCT[var4].isLock) {
                var2 = true;
            }

            if (gameCT[var4] != null && !gameCT[var4].isLock) {
                var3 = true;
            }
        }

        if (var0 <= 1) {
            GameCanvas.msgdlg.gameAA(mResources.gameQJ, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            for (var4 = crystals.length - 1; var4 >= 0 && var1 <= crystals[var4]; --var4) {
            }

            if (var4 >= crystals.length - 1) {
                var4 = crystals.length - 2;
            }

            if (gameHS) {
                if (coinUpCrystals[var4 + 1] > Char.getMyChar().xu) {
                    GameCanvas.msgdlg.gameAA(mResources.gameQP, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                } else if (var2) {
                    GameCanvas.gameAA(mResources.gameQO, 88813, gameCT, 8882, (Object) null);
                } else {
                    Service.gI().gameAA(gameCT);
                }
            } else if (coinUpCrystals[var4 + 1] > Char.getMyChar().xu + Char.getMyChar().yen) {
                GameCanvas.msgdlg.gameAA(mResources.gameQP, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            } else if (var3) {
                GameCanvas.gameAA(mResources.gameQO, 88814, gameCT, 8882, (Object) null);
            } else {
                Service.gI().gameAB(gameCT);
            }
        }
    }

    private static void gameDQ() {
        int var0 = 0;
        int var1 = 0;
        int var2 = 0;
        short var3 = 0;

        for (int var4 = 0; var4 < gameCT.length; ++var4) {
            Item var5;
            if ((var5 = gameCT[var4]) != null) {
                if (var5.template.id == 455) {
                    ++var0;
                } else if (var5.template.id == 456) {
                    ++var1;
                } else if (var5.template.type == 26) {
                    ++var2;
                    var3 = var5.template.id;
                }
            }
        }

        if (var2 > 1) {
            GameCanvas.gameAA(mResources.gameWR);
        } else if (var0 > 9 || var1 > 9 || var3 >= 10 && (var0 > 3 || var1 > 3)) {
            GameCanvas.gameAA(mResources.gameWW);
        } else if (var0 + var1 < 3) {
            GameCanvas.gameAA(mResources.gameWV);
        } else if (var3 == 10 && var1 == 3 || var3 == 11 && var0 == 3) {
            GameCanvas.gameAA(mResources.gameWS);
        } else {
            Service.gI().gameAD(gameCT);
        }
    }

    public static byte gameBD() {
        if (Char.getMyChar().ctaskId >= gameEJ.length) {
            return -3;
        } else {
            byte var0;
            if (Char.getMyChar().taskMaint == null) {
                var0 = gameEK[Char.getMyChar().ctaskId][0];
            } else {
                var0 = gameEK[Char.getMyChar().ctaskId][Char.getMyChar().taskMaint.index + 1];
            }

            if (var0 == -1) {
                if (Char.getMyChar().nClass.classId == 0 && Char.getMyChar().ctaskId == 9) {
                    var0 = -2;
                } else if (Char.getMyChar().nClass.classId != 0 && Char.getMyChar().nClass.classId != 1 && Char.getMyChar().nClass.classId != 2) {
                    if (Char.getMyChar().nClass.classId != 3 && Char.getMyChar().nClass.classId != 4) {
                        if (Char.getMyChar().nClass.classId == 5 || Char.getMyChar().nClass.classId == 6) {
                            var0 = 27;
                        }
                    } else {
                        var0 = 72;
                    }
                } else {
                    var0 = 1;
                }
            }

            return var0;
        }
    }

    public static byte gameBE() {
        try {
            if (Char.getMyChar().ctaskId >= gameEJ.length) {
                return -3;
            } else {
                byte var0;
                if (Char.getMyChar().taskMaint == null) {
                    var0 = gameEJ[Char.getMyChar().ctaskId][0];
                } else {
                    var0 = gameEJ[Char.getMyChar().ctaskId][Char.getMyChar().taskMaint.index + 1];
                }

                if (var0 == -1) {
                    if (Char.getMyChar().nClass.classId == 0 && Char.getMyChar().ctaskId == 9) {
                        var0 = -2;
                    } else if (Char.getMyChar().nClass.classId != 0 && Char.getMyChar().nClass.classId != 1 && Char.getMyChar().nClass.classId != 2) {
                        if (Char.getMyChar().nClass.classId != 3 && Char.getMyChar().nClass.classId != 4) {
                            if (Char.getMyChar().nClass.classId == 5 || Char.getMyChar().nClass.classId == 6) {
                                var0 = 11;
                            }
                        } else {
                            var0 = 10;
                        }
                    } else {
                        var0 = 9;
                    }
                }

                return var0;
            }
        } catch (Exception var1) {
            return -1;
        }
    }

    private static void gameDR() {
        int var0 = 0;

        for (int var1 = 0; var1 < upitem.length; ++var1) {
            if (upitem[var1] != null && upitem[var1].template.type == 26) {
                var0 += crystals[upitem[var1].template.id];
            }
        }

        boolean var4 = false;
        boolean var2 = false;
        int var3 = 0;
        if (arritemup.gameAR()) {
            if (coinUpClothes[arritemup.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                var4 = true;
            }

            var3 = var0 * 100 / upClothe[arritemup.upgrade];
        } else if (arritemup.gameAS()) {
            if (coinUpAdorns[arritemup.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                var4 = true;
            }

            var3 = var0 * 100 / upAdorn[arritemup.upgrade];
        } else if (arritemup.gameAT()) {
            if (coinUpWeapons[arritemup.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                var4 = true;
            }

            var3 = var0 * 100 / upWeapon[arritemup.upgrade];
        }

        if (gameMB && goldUps[arritemup.upgrade] > Char.getMyChar().luong) {
            var2 = true;
        }

        if (var4) {
            InfoMe.gameAA(mResources.gameQR, 15, mFont.tahoma_7_red);
        } else if (var2) {
            InfoMe.gameAA(mResources.gameQQ, 15, mFont.tahoma_7_red);
        } else if (var3 > 250) {
            GameCanvas.gameAA(mResources.gameQS, 88815, (Object) null, 8882, (Object) null);
        } else {
            gameBF();
        }
    }

    public static void gameBF() {
        if (!arritemup.isLock) {
            GameCanvas.gameAA(mResources.gameQT, new Command(mResources.YES, 11063), new Command(mResources.NO, 1));
        } else {
            Service.gI().gameAA(arritemup, upitem, gameMB);
        }
    }

    private static void gameDS() {
        if (gameMO) {
            Service.gI().gameAA((byte) 1, (Item) null, gameDD, gameCV);
        } else if (gameMM) {
            Service.gI().gameAB(gameDD, gameCV);
        } else if (gameMN) {
            Service.gI().gameAD(gameDD, gameCV);
        } else if (gameDD.upgrade == 0) {
            GameCanvas.msgdlg.gameAA(mResources.gameQU, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            int var0 = -1;
            int var1 = 0;

            int var2;
            for (var2 = 0; var2 < Char.getMyChar().arrItemBag.length; ++var2) {
                if (Char.getMyChar().arrItemBag[var2] == null) {
                    ++var0;
                }
            }

            for (var2 = 0; var2 < gameCV.length; ++var2) {
                if (gameCV[var2] != null) {
                    ++var1;
                }
            }

            if (var1 > var0) {
                GameCanvas.msgdlg.gameAA(mResources.gameQV, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            } else {
                GameCanvas.gameAA(mResources.gameQW, new Command(mResources.YES, 11087, gameDD), new Command(mResources.NO, 1));
            }
        }
    }

    private void gameAA(Item var1, Command var2) {
        this.gameAA((int) 3, (Item) var1);
        if (var2 != null) {
            super.left = new Command(var2.caption, 11040);
        }

    }

    private void gameAA(int var1, Item var2) {
        if (var2 != null) {
            this.gameHR = var2;
            gameTJ = 120;
            gameTK = 120;
            if (GameCanvas.isTouch && !GameCanvas.gameAH) {
                gameTK += 18;
            }

            gameDK = true;
            gameBT.gameAA();
            indexRow = 0;
            if (var2.expires == 0L) {
                if (gameMM || gameMN || gameMO || gameMP || gameMR || gameMQ) {
                    Service.gI().gameAC(var2.typeUI, var2.indexUI);
                }

                if (gameMK) {
                    Service.gI().gameBN(var2.itemId);
                } else if (currentCharViewInfo.charID == Char.getMyChar().charID) {
                    Service.gI().gameAC(var1, var2.indexUI);
                } else {
                    Service.gI().gameAD(currentCharViewInfo.charID, var2.indexUI);
                }
            }

            if (var1 == 5) {
                Char.getMyChar().gameAZ();
            }

            if (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.gameAH || gameDL && gameBP > 0 && gameBP < 4 || gameMH && gameBP == 0) {
                super.center = this.gameTN;
                super.right = null;
                super.left = null;
            }

            GameCanvas.gameAK();
            GameCanvas.gameAJ();
        }

    }

    public final void gameAA(String var1, String var2, boolean var3) {
        InfoDlg.gameAD();
        gameDI = true;
        this.gameNB = true;
        indexRow = 0;
        setSize(175, 200);
        if (var3) {
            gameGD -= 60;
        }

        super.right = new Command(mResources.CLOSE, 3);
        super.left = super.center = null;
        this.gameND = var1;
        this.gameNC = mFont.tahoma_7.gameAA(var2, gameGC - 30);
    }

    public final void gameBG() {
        gameDI = false;
        this.gameND = null;
        this.gameNC = null;
        super.center = null;
        this.gameAU();
    }

    public final void gameBH() {
        gameBO = this.gameNC.size();
        gameBU.gameAA(gameBO, 12, popupX, gameGB + 12, gameGC, gameGD - 42 - (this.gameND != null ? 10 : 0), true, 1);
        indexRow = this.gameNC.size() - 1;
        gameBU.gameAA(indexRow * gameBU.ITEM_SIZE);
    }

    private void gameBG(mGraphics var1) {
        if (this.gameNC != null && gameDI) {
            gameAB(var1);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            if (this.gameND != null) {
                gameAA(var1, this.gameND, isPaintMessage);
            }

            gameGA = popupX + 15;
            gameGB = popupY + 15;
            if (this.gameND != null) {
                gameGB += 10;
            }

            gameBO = this.gameNC.size();
            gameBU.gameAA(gameBO, 12, popupX, gameGB + 12, gameGC, gameGD - 42 - (this.gameND != null ? 10 : 0), true, 1);
            gameBU.gameAA(var1);
            this.gameGE = gameGB;
            mFont var2 = mFont.tahoma_7_white;

            String var3;
            for (int var4 = 0; var4 < this.gameNC.size() && (var3 = (String) this.gameNC.elementAt(var4)) != null && this.gameNC != null && var2 != null; ++var4) {
                if (var3.startsWith("c")) {
                    if (var3.startsWith("c0")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7_white;
                    } else if (var3.startsWith("c1")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7b_yellow;
                    } else if (var3.startsWith("c2")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7b_white;
                    } else if (var3.startsWith("c3")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7_yellow;
                    } else if (var3.startsWith("c4")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7b_red;
                    } else if (var3.startsWith("c5")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7_red;
                    } else if (var3.startsWith("c6")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7_grey;
                    } else if (var3.startsWith("c7")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7b_blue;
                    } else if (var3.startsWith("c8")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7_blue;
                    } else if (var3.startsWith("c9")) {
                        var3 = var3.substring(2);
                        var2 = mFont.tahoma_7_green;
                    }
                }

                var2.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
            }

            if (indexRow >= 0) {
                SmallImage.gameAB(var1, 942, gameGA - 5, gameGB + 12 + 1 + indexRow * 12, 0, StaticObj.gameAB);
            }
        }

    }

    private static void gameBH(mGraphics var0) {
        if (gameKA) {
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, mResources.gameMI, false);
            gameGA = popupX + 5;
            gameGB = popupY + 40;
            if (vPtMap.size() == 0) {
                mFont.tahoma_7_white.gameAA(var0, mResources.gameSU, popupX + gameGC / 2, popupY + 40, 2);
            } else {
                var0.gameAA(6425);
                var0.gameAD(gameGA - 2, gameGB - 2, gameGC - 6, gameBL * 5 + 8);
                gameAB(var0);
                gameBU.gameAA(vPtMap.size(), gameBL, gameGA, gameGB, gameGC - 3, gameBL * 5 + 4, true, 1);
                gameBU.gameAA(var0, gameGA, gameGB, gameGC - 3, gameBL * 5 + 6);
                gameBO = vPtMap.size();

                for (int var1 = 0; var1 < vPtMap.size(); ++var1) {
                    Party var2 = (Party) vPtMap.elementAt(var1);
                    if (indexRow == var1) {
                        var0.gameAA(Paint.COLORLIGHT);
                        var0.gameAD(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(16777215);
                        var0.gameAC(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                    } else {
                        var0.gameAA(Paint.COLORBACKGROUND);
                        var0.gameAD(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(13932896);
                        var0.gameAC(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                    }

                    SmallImage.gameAB(var0, 647, gameGA + 12, gameGB + var1 * gameBL + gameBL / 2, 0, 3);
                    mFont.tahoma_7_white.gameAA(var0, var2.name + " - " + mResources.gameFC + ": " + var2.level + " (" + var2.size + ")", gameGA + 22, gameGB + var1 * gameBL + gameBL / 2 - 6, 0);
                }
            }

            gameAM(var0);
        }

    }

    private static void gameBI(mGraphics var0) {
        if (gameHZ) {
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, mResources.gameMH, false);
            gameGA = popupX + 5;
            gameGB = popupY + 40;
            if (vParty.size() == 0) {
                mFont.tahoma_7_white.gameAA(var0, mResources.gameSS, popupX + gameGC / 2, popupY + 40, 2);
            } else {
                var0.gameAA(6425);
                var0.gameAD(gameGA - 2, gameGB - 2, gameGC - 6, gameBL * 5 + 8);
                gameAB(var0);
                gameBU.gameAA(vParty.size(), gameBL, gameGA, gameGB, gameGC - 3, gameBL * 5 + 4, true, 1);
                gameBU.gameAA(var0, gameGA, gameGB, gameGC - 3, gameBL * 5 + 6);
                gameBO = vParty.size();

                for (int var1 = 0; var1 < vParty.size(); ++var1) {
                    Party var2 = (Party) vParty.elementAt(var1);
                    if (indexRow == var1) {
                        var0.gameAA(Paint.COLORLIGHT);
                        var0.gameAD(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(16777215);
                        var0.gameAC(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                    } else {
                        var0.gameAA(Paint.COLORBACKGROUND);
                        var0.gameAD(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(13932896);
                        var0.gameAC(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                    }

                    SmallImage.gameAB(var0, var2.iconId, gameGA + 12, gameGB + var1 * gameBL + gameBL / 2, 0, 3);
                    if (var2.c == null) {
                        mFont.tahoma_7_green.gameAA(var0, var2.name, gameGA + 22, gameGB + var1 * gameBL + gameBL / 2 - 6, 0);
                    } else if (var1 == 0) {
                        mFont.tahoma_7_yellow.gameAA(var0, var2.name + " - " + mResources.gameFC + ": " + var2.c.clevel, gameGA + 22, gameGB + var1 * gameBL + gameBL / 2 - 6, 0);
                    } else {
                        mFont.tahoma_7_white.gameAA(var0, var2.name + " - " + mResources.gameFC + ": " + var2.c.clevel, gameGA + 22, gameGB + var1 * gameBL + gameBL / 2 - 6, 0);
                    }
                }
            }

            gameAM(var0);
        }

    }

    private static void gameBJ(mGraphics var0) {
        if (gameMK) {
            int var1 = gameGC;
            if (GameCanvas.gameAI) {
                var1 = gameGC / 2 + 20;
            }

            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, mResources.gameVS[gameBP], GameCanvas.isTouch ? true : gameHQ == 0);
            var0.gameAA(6425);
            var0.gameAD(gameGA - 2, gameGB - 2, var1 - 6, gameBL * 5 + 4);
            if (arrItemStands == null) {
                GameCanvas.gameAA(popupX + 90, popupY + 75, var0);
                mFont.tahoma_7b_white.gameAA(var0, mResources.gameBG, popupX + 90, popupY + 90, 2);
                return;
            }

            ItemStands[] var2 = arrItemStands;
            gameGA = popupX + 5;
            gameGB = popupY + 33;
            if (var2.length > 0) {
                gameBO = var2.length;
                gameAB(var0);
                gameBU.gameAA(gameBO, gameBL, gameGA, gameGB, var1 - 3, gameBL * 5, true, 1);
                gameBU.gameAA(var0, gameGA, gameGB, var1 - 3, gameBL * 5 + 2);

                for (int var3 = 0; var3 < var2.length; ++var3) {
                    ItemStands var4;
                    if ((var4 = var2[var3]) != null && var4.item != null && var4.item.template != null) {
                        int var5 = (int) (System.currentTimeMillis() / 1000L);
                        if (var3 * gameBL >= gameBU.cmy - gameBL && var3 * gameBL < gameBU.cmy + gameBL * 5 + 4) {
                            if (gameBM == var3) {
                                var0.gameAA(Paint.COLORLIGHT);
                                var0.gameAD(gameGA + 2, gameGB + gameBM * gameBL + 2, var1 - 15, gameBL - 4);
                                var0.gameAA(16777215);
                                var0.gameAC(gameGA + 2, gameGB + gameBM * gameBL + 2, var1 - 15, gameBL - 4);
                            } else {
                                var0.gameAA(Paint.COLORBACKGROUND);
                                var0.gameAD(gameGA + 2, gameGB + var3 * gameBL + 2, var1 - 15, gameBL - 4);
                                var0.gameAA(13932896);
                                var0.gameAC(gameGA + 2, gameGB + var3 * gameBL + 2, var1 - 15, gameBL - 4);
                            }

                            var0.gameAA(0);
                            var0.gameAD(gameGA + 4, gameGB + var3 * gameBL + 4, gameBL - 1, gameBL - 8);
                            var0.gameAA(gameBM == var3 ? 16777215 : 12281361);
                            var0.gameAC(gameGA + 4, gameGB + var3 * gameBL + 4, gameBL - 1, gameBL - 8);
                            SmallImage.gameAB(var0, var4.item.template.iconID, gameGA + gameBL / 2, gameGB + var3 * gameBL + gameBL / 2, 0, 3);
                            if (var4.item.quantity > 1) {
                                mFont.number_yellow.gameAA(var0, String.valueOf(var4.item.quantity), gameGA + gameBL, gameGB + var3 * gameBL + gameBL / 2 + 2, 1);
                            }

                            var5 = var4.timeEnd - (var5 - var4.timeStart);
                            mFont.tahoma_7_white.gameAA(var0, mResources.gameVO + ": " + var4.seller, gameGA + gameBL + 7, gameGB + var3 * gameBL + gameBL / 2 - mFont.number_yellow.gameAC() - 2, 0);
                            mFont.tahoma_7_white.gameAA(var0, mResources.gameCZ + ": " + NinjaUtil.gameAA(String.valueOf(var4.price)) + " " + mResources.gamePE, gameGA + gameBL + 7, gameGB + var3 * gameBL + gameBL / 2 - mFont.number_yellow.gameAC() + 9, 0);
                            if (var5 < 60) {
                                mFont.tahoma_7_blue.gameAA(var0, mResources.gameVQ, gameGA + var1 - 30, gameGB + var3 * gameBL + gameBL / 2 - mFont.number_yellow.gameAC() - 2, 2);
                                mFont.tahoma_7_blue.gameAA(var0, mResources.gameVR, gameGA + var1 - 30, gameGB + var3 * gameBL + gameBL / 2 - mFont.number_yellow.gameAC() + 9, 2);
                            } else {
                                mFont.tahoma_7_green.gameAA(var0, mResources.gameVP, gameGA + var1 - 30, gameGB + var3 * gameBL + gameBL / 2 - mFont.number_yellow.gameAC() - 2, 2);
                                mFont.tahoma_7_green.gameAA(var0, NinjaUtil.gameAB(var5), gameGA + var1 - 30, gameGB + var3 * gameBL + gameBL / 2 - mFont.number_yellow.gameAC() + 9, 2);
                            }
                        }
                    }
                }
            } else {
                gameBO = var2.length;
                mFont.tahoma_7_white.gameAA(var0, mResources.gameST, popupX + var1 / 2, popupY + 40, 2);
            }

            gameAM(var0);
        }

    }

    private static void gameBK(mGraphics var0) {
        if (gameDJ || gameKC) {
            String var1 = gameDJ ? mResources.gameMK[0] : mResources.gameMK[1];
            MyVector var2 = gameDJ ? vFriend : vEnemies;
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, var1, false);
            if (var2.size() <= 0) {
                mFont.tahoma_7_white.gameAA(var0, gameDJ ? mResources.gameML : mResources.gameNA, popupX + gameGC / 2, popupY + 40, 2);
            } else {
                gameGA = popupX + 5;
                gameGB = popupY + 40;
                var0.gameAA(6425);
                var0.gameAD(gameGA - 2, gameGB - 2, gameGC - 6, gameBL * 5 + 8);
                gameAB(var0);
                gameBU.gameAA(var2.size(), gameBL, gameGA, gameGB, gameGC - 3, gameBL * 5 + 4, true, 1);
                gameBU.gameAA(var0, gameGA, gameGB, gameGC - 3, gameBL * 5 + 6);
                gameBO = var2.size();
                int var6 = 0;
                int var3 = 0;

                while (true) {
                    if (var3 >= var2.size()) {
                        gameBO = var6;
                        gameBU.gameAA(var6, gameBL, gameGA, gameGB, gameGC - 3, gameBL * 5 + 4, true, 1);
                        break;
                    }

                    Friend var4 = (Friend) var2.elementAt(var3);
                    if (!gameHU || var4.type == 3) {
                        mFont var5 = mFont.tahoma_7_grey;
                        if (var4.type != 1 && var4.type != 2) {
                            if (var4.type == 3) {
                                var5 = mFont.tahoma_7_white;
                            } else if (var4.type == 4) {
                                var5 = mFont.tahoma_7_red;
                            }
                        } else {
                            var5 = mFont.tahoma_7_green;
                        }

                        if (var3 * gameBL >= gameBU.cmy - gameBL && var3 * gameBL < gameBU.cmy + gameBL * 5 + 8) {
                            if (indexRow == var3) {
                                var0.gameAA(Paint.COLORLIGHT);
                                var0.gameAD(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                                var0.gameAA(16777215);
                                var0.gameAC(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                            } else {
                                var0.gameAA(Paint.COLORBACKGROUND);
                                var0.gameAD(gameGA + 2, gameGB + var3 * gameBL + 2, gameGC - 15, gameBL - 4);
                                var0.gameAA(13932896);
                                var0.gameAC(gameGA + 2, gameGB + var3 * gameBL + 2, gameGC - 15, gameBL - 4);
                            }

                            if (var4.type == 4) {
                                if (GameCanvas.gameTick % 10 > 7) {
                                    var5.gameAA(var0, var4.friendName, gameGA + 8, gameGB + var3 * gameBL + gameBL / 2 - 6, 0);
                                } else {
                                    mFont.tahoma_7_yellow.gameAA(var0, var4.friendName, gameGA + 8, gameGB + var3 * gameBL + gameBL / 2 - 6, 0);
                                }

                                mFont.tahoma_7_blue.gameAA(var0, mResources.gameMM, gameGA + gameGC - 15, gameGB + var3 * gameBL + gameBL / 2 - 6, 1);
                            } else {
                                var5.gameAA(var0, var4.friendName, gameGA + 8, gameGB + var3 * gameBL + gameBL / 2 - 6, 0);
                            }
                        }

                        ++var6;
                    }

                    ++var3;
                }
            }

            gameAM(var0);
        }

    }

    private void gameBL(mGraphics var1) {
        if (gameHY) {
            gameBO = 0;
            gameAB(var1);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            gameAA(var1, mResources.gameMB[gameBP], false);
            gameGA = popupX + 10;
            gameGB = popupY + 32;
            int var2;
            String var3;
            if (gameBP == 0) {
                boolean var8 = false;
                gameBU.gameAA(gameBO, 12, popupX, popupY + 32, gameGC, gameGD - 40, true, 1);
                gameBU.gameAA(var1);
                if (Char.getMyChar().taskMaint != null) {
                    for (var2 = 0; var2 < Char.getMyChar().taskMaint.names.length; ++var2) {
                        mFont.tahoma_7b_white.gameAA(var1, Char.getMyChar().taskMaint.names[var2], gameGA, this.gameGE = gameGB, 0);
                        ++gameBO;
                    }

                    var2 = 0;

                    int var9;
                    for (var9 = 0; var9 < Char.getMyChar().taskMaint.subNames.length; ++var9) {
                        mFont var10;
                        if (Char.getMyChar().taskMaint.subNames[var9] != null) {
                            var2 = var9;
                            var3 = "- " + Char.getMyChar().taskMaint.subNames[var9];
                            if (Char.getMyChar().taskMaint.counts[var9] != -1) {
                                if (Char.getMyChar().taskMaint.index == var9) {
                                    var3 = var3 + " " + Char.getMyChar().taskMaint.count + "/" + Char.getMyChar().taskMaint.counts[var9];
                                    if (Char.getMyChar().taskMaint.count == Char.getMyChar().taskMaint.counts[var9]) {
                                        mFont.tahoma_7_white.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                                    } else {
                                        var10 = mFont.tahoma_7_grey;
                                        if (!var8) {
                                            var8 = true;
                                            var10 = mFont.tahoma_7_yellow;
                                        }

                                        var10.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                                    }
                                } else if (Char.getMyChar().taskMaint.index > var9) {
                                    var3 = var3 + " " + Char.getMyChar().taskMaint.counts[var9] + "/" + Char.getMyChar().taskMaint.counts[var9];
                                    mFont.tahoma_7_white.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                                } else {
                                    var3 = var3 + " 0/" + Char.getMyChar().taskMaint.counts[var9];
                                    var10 = mFont.tahoma_7_grey;
                                    if (!var8) {
                                        var8 = true;
                                        var10 = mFont.tahoma_7_yellow;
                                    }

                                    var10.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                                }
                            } else if (Char.getMyChar().taskMaint.index > var9) {
                                mFont.tahoma_7_white.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                            } else {
                                var10 = mFont.tahoma_7_grey;
                                if (!var8) {
                                    var8 = true;
                                    var10 = mFont.tahoma_7_yellow;
                                }

                                var10.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                            }

                            ++gameBO;
                        } else if (Char.getMyChar().taskMaint.index <= var9) {
                            var3 = "- " + Char.getMyChar().taskMaint.subNames[var2];
                            var10 = mFont.tahoma_7_grey;
                            if (!var8) {
                                var8 = true;
                                var10 = mFont.tahoma_7_yellow;
                            }

                            var10.gameAA(var1, var3, gameGA + 5, this.gameGE, 0);
                        }
                    }

                    this.gameGE += 5;

                    for (var9 = 0; var9 < Char.getMyChar().taskMaint.details.length; ++var9) {
                        mFont.tahoma_7_white.gameAA(var1, Char.getMyChar().taskMaint.details[var9], gameGA, this.gameGE += 12, 0);
                        ++gameBO;
                    }
                } else {
                    byte var5 = gameBD();
                    byte var6 = gameBE();
                    String var7;
                    if (var5 != -3 && var6 != -3) {
                        if (Char.getMyChar().taskMaint == null && Char.getMyChar().ctaskId == 9 && Char.getMyChar().nClass.classId == 0) {
                            var7 = mResources.gameSK;
                        } else {
                            if (var6 < 0 || var5 < 0) {
                                return;
                            }

                            var7 = mResources.gameSI[0] + Npc.arrNpcTemplate[var6].name + mResources.gameSI[1] + TileMap.mapNames[var5] + mResources.gameSI[2];
                        }
                    } else {
                        var7 = mResources.gameSI[3];
                    }

                    String[] var11 = mFont.tahoma_7_white.gameAB(var7, 150);

                    for (var2 = 0; var2 < var11.length; ++var2) {
                        if (var2 == 0) {
                            mFont.tahoma_7_white.gameAA(var1, var11[var2], gameGA + 5, this.gameGE = gameGB, 0);
                        } else {
                            mFont.tahoma_7_white.gameAA(var1, var11[var2], gameGA + 5, this.gameGE += 12, 0);
                        }

                        ++gameBO;
                    }
                }

                if (gameHQ == 1 && indexRow >= 0 && gameBO > 0) {
                    SmallImage.gameAB(var1, 942, gameGA - 8, gameGB + 2 + indexRow * 12, 0, StaticObj.gameAB);
                }

                gameBU.gameAA(gameBO, 12, popupX, popupY + 32, gameGC, gameGD - 44, true, 1);
                return;
            }

            if (gameBP == 1) {
                this.gameGE = gameGB - 12;
                gameBU.gameAA(Char.getMyChar().taskOrders.size(), 12, popupX, popupY + 32, gameGC, gameGD - 44, true, 1);
                gameBU.gameAA(var1);
                gameBO = 0;

                for (var2 = 0; var2 < Char.getMyChar().taskOrders.size(); ++var2) {
                    TaskOrder var4 = (TaskOrder) Char.getMyChar().taskOrders.elementAt(var2);
                    mFont.tahoma_7b_white.gameAA(var1, var4.name, gameGA + 5, this.gameGE += 12, 0);
                    var3 = "";
                    if (var4.taskId != 0 && var4.taskId != 3) {
                        if (var4.taskId == 1) {
                            var3 = mResources.gameKI + " " + Mob.arrMobTemplate[var4.killId].name;
                        } else if (var4.taskId == 2) {
                            var3 = mResources.gameVU;
                        } else if (var4.taskId == 4) {
                            var3 = mResources.gameKJ + " " + Mob.arrMobTemplate[var4.killId].name;
                        } else if (var4.taskId == 5) {
                            var3 = mResources.gameKK + " " + Mob.arrMobTemplate[var4.killId].name;
                        } else if (var4.taskId == 6) {
                            var3 = mResources.gameKL;
                        }
                    } else {
                        var3 = mResources.gameKH + " " + Mob.arrMobTemplate[var4.killId].name;
                    }

                    if (var4.taskId == 6) {
                        if (var4.count == var4.maxCount) {
                            mFont.tahoma_7_white.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                        } else {
                            mFont.tahoma_7_yellow.gameAA(var1, var3, gameGA + 5, this.gameGE += 12, 0);
                        }
                    } else if (var4.count == var4.maxCount) {
                        mFont.tahoma_7_white.gameAA(var1, var3 + " " + var4.count + "/" + var4.maxCount, gameGA + 5, this.gameGE += 12, 0);
                    } else {
                        mFont.tahoma_7_yellow.gameAA(var1, var3 + " " + var4.count + "/" + var4.maxCount, gameGA + 5, this.gameGE += 12, 0);
                    }

                    gameBO += 3;
                    gameTJ = gameGC - 25;
                    this.gameAA(var1, mFont.tahoma_7_white, var4.description, gameGA + 5, this.gameGE += 12, 0);
                    this.gameGE += 12;
                }

                if (this.gameFH > 0) {
                    mFont.tahoma_7_white.gameAA(var1, mResources.gameAL, gameGA + 5, this.gameGE += 12, 0);
                    switch (this.gameFH) {
                        case 1:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAM, gameGA + 5, this.gameGE += 12, 0);
                            break;
                        case 2:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAN, gameGA + 5, this.gameGE += 12, 0);
                            break;
                        case 3:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAO, gameGA + 5, this.gameGE += 12, 0);
                            break;
                        case 4:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAP, gameGA + 5, this.gameGE += 12, 0);
                            break;
                        case 5:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAQ, gameGA + 5, this.gameGE += 12, 0);
                            break;
                        case 6:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAR, gameGA + 5, this.gameGE += 12, 0);
                            break;
                        case 7:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAS, gameGA + 5, this.gameGE += 12, 0);
                            break;
                        case 8:
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameAT, gameGA + 5, this.gameGE += 12, 0);
                    }
                }

                if (gameHQ == 1 && indexRow >= 0 && gameBO > 0) {
                    SmallImage.gameAB(var1, 942, gameGA - 8, gameGB + 2 + indexRow * 12, 0, StaticObj.gameAB);
                }

                ++gameBO;
                gameBU.gameAA(gameBO, 12, popupX, popupY + 32, gameGC, gameGD - 44, true, 1);
            }
        }

    }

    private static String[] gameAA(mFont var0, String var1) {
        return var0.gameAB(var1, gameGC - 20);
    }

    private void gameAA(mGraphics var1, mFont var2, String[] var3, int var4, int var5) {
        int var6 = var5;

        for (int var7 = 0; var7 < var3.length; ++var7) {
            String var8;
            if ((var8 = var3[var7]).startsWith("c")) {
                if (var8.startsWith("c0")) {
                    var8 = var8.substring(2);
                    var2 = mFont.tahoma_7_white;
                } else if (var8.startsWith("c1")) {
                    var8 = var8.substring(2);
                    var2 = mFont.tahoma_7_yellow;
                } else if (var8.startsWith("c2")) {
                    var8 = var8.substring(2);
                    var2 = mFont.tahoma_7_green;
                }
            }

            if (var7 == 0) {
                var2.gameAA(var1, var8, var4, var5, 0);
            } else {
                if (var7 * gameBU.ITEM_SIZE + var6 >= gameBU.cmy - 12 && var7 * gameBU.ITEM_SIZE < gameBU.cmy + gameGD - 44) {
                    var5 += 12;
                    var2.gameAA(var1, var8, var4, var5, 0);
                } else {
                    var5 += 12;
                }

                this.gameGE += 12;
                ++gameBO;
            }
        }

    }

    private void gameAA(mGraphics var1, mFont var2, String var3, int var4, int var5, int var6) {
        int var7 = GameCanvas.isTouch && GameCanvas.w >= 320 ? 20 : 10;
        int var8 = var5;
        String[] var10 = var2.gameAB(var3, gameTJ - var7);

        for (var7 = 0; var7 < var10.length; ++var7) {
            if (var7 == 0) {
                var2.gameAA(var1, var10[var7], var4, var5, var6);
            } else {
                if (var7 * gameBU.ITEM_SIZE + var8 >= gameBU.cmy - 12 && var7 * gameBU.ITEM_SIZE < gameBU.cmy + gameGD - 44) {
                    String var9 = var10[var7];
                    var5 += 12;
                    var2.gameAA(var1, var9, var4, var5, var6);
                    this.gameGE += 12;
                } else {
                    var5 += 12;
                }

                ++gameBO;
            }
        }

    }

    private void gameAB(mGraphics var1, mFont var2, String var3, int var4, int var5, int var6) {
        int var7 = var5;
        String[] var9 = var2.gameAB(var3, var6);

        for (var6 = 0; var6 < var9.length; ++var6) {
            if (var6 == 0) {
                var2.gameAA(var1, var9[var6], var4, var5, 0);
            } else {
                if (var6 * gameBU.ITEM_SIZE + var7 >= gameBU.cmy - 12 && var6 * gameBU.ITEM_SIZE < gameBU.cmy + gameGD - 44) {
                    String var8 = var9[var6];
                    var5 += 12;
                    var2.gameAA(var1, var8, var4, var5, 0);
                    this.gameGE += 12;
                } else {
                    var5 += 12;
                }

                ++gameBO;
            }
        }

    }

    private void gameBM(mGraphics var1) {
        if (GameCanvas.gameAI && !gameDI() && (gameDH() || gameDF() || gameAZ())) {
            gameDT();
            gameBN(var1);
            gameAB(var1);
            this.gameAA(var1, mFont.tahoma_7_white, mResources.gameEX, gameTH + gameTJ / 2, gameTI + gameTK / 2 - 20, 2);
        }

        if (gameDK && this.gameHR != null && this.gameHR.template != null) {
            Item var2 = this.gameHR;
            if (gameHT && !this.gameHR.gameAP() && gameBP == 0) {
                var2 = this.gameHR.gameAA(this.gameHR.upgrade + 1);
            }

            if (gameMA && gameBP == 0 && gameHQ == 1 && var2.gameAB() && var2.upgrade == 0 && gameCY[0] != null && gameCY[0].template.type == gameCY[1].template.type && gameCY[1].template.level >= gameCY[0].template.level) {
                var2 = this.gameHR.gameAA(gameCY[0].upgrade);
            }

            gameAB(var1);
            int var3;
            int var4;
            if (var2.expires != 0L && var2.options != null && var2.options.size() > 0) {
                for (var3 = 0; var3 < var2.options.size(); ++var3) {
                    if ((var4 = ((ItemOption) var2.options.elementAt(var3)).gameAA().length() * 5) > gameTJ && !GameCanvas.gameAI) {
                        gameTJ = var4;
                    }
                }
            }

            if ((var4 = mFont.tahoma_7b_white.gameAA(var2.template.name) + 10) > gameTJ && !GameCanvas.gameAI) {
                gameTJ = var4;
            }

            if (gameTJ > GameCanvas.w - 4) {
                gameTJ = GameCanvas.w - 4;
            }

            if (gameTK > GameCanvas.h - 4) {
                gameTJ = GameCanvas.h - 4;
            }

            gameTH = gW / 2 - gameTJ / 2;
            gameTI = gH / 2 - gameTK / 2;
            gameDT();
            if (gameTH < 2) {
                gameTH = 2;
            }

            if (gameTI < 2) {
                gameTI = 2;
            }

            gameBN(var1);
            if (gameMH && gameBP == 0) {
                if (Char.clan != null) {
                    this.gameGE = gameTI - 9;
                    gameBO = 2;
                    gameBT.gameAA(var1, gameTH, gameTI + 2, gameTJ, gameTK - 2);
                    gameTJ = mFont.tahoma_7_white.gameAA(mResources.gameWD[Char.clan.itemLevel][1]) + 10;

                    for (var3 = 0; var3 < 2; ++var3) {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameWD[Char.clan.itemLevel][var3], gameTH + 8, this.gameGE += 12, 0);
                    }

                    if (indexRow >= 0 && (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.w < 320)) {
                        SmallImage.gameAB(var1, 942, gameTH + 1, gameTI + 5 + indexRow * 12, 0, StaticObj.gameAB);
                    }

                    gameBT.gameAA(gameBO, 12, gameTH, gameTI + 2, gameTJ, gameTK - 4, true, 1);
                    return;
                }
            } else {
                gameBT.gameAA(var1, gameTH, gameTI + 2, gameTJ, gameTK - 2);
                gameBO = 3;
                this.gameGE = gameTI + 3;
                mFont var10 = mFont.tahoma_7b_white;
                if (!var2.gameAC()) {
                    if (var2.upgrade > 0 && var2.upgrade < 4) {
                        var10 = mFont.tahoma_7b_blue;
                    } else if (var2.upgrade >= 4 && var2.upgrade < 8) {
                        var10 = mFont.tahoma_7b_green;
                    } else if (var2.upgrade >= 8 && var2.upgrade < 12) {
                        var10 = mFont.tahoma_7b_yellow;
                    } else if (var2.upgrade >= 12 && var2.upgrade < 15) {
                        var10 = mFont.tahoma_7b_purple;
                    } else if (var2.upgrade >= 15) {
                        var10 = mFont.tahoma_7b_red;
                    }
                }

                if (var2.img != null) {
                    var1.gameAA(var2.img, 0, 0, mGraphics.gameAA(var2.img), mGraphics.gameAB(var2.img), 0, gameTH + gameTJ / 2, this.gameGE + gameTK - 10, 33);
                }

                if (var2.gameAC()) {
                    this.gameAA(var1, var10, "[" + var2.template.id + "]" + var2.template.name, gameTH + 8, this.gameGE, 0);
                } else {
                    this.gameAA(var1, var10, "[" + var2.template.id + "]" + var2.template.name + (var2.upgrade > 0 ? " +" + var2.upgrade : ""), gameTH + 8, this.gameGE, 0);
                }

                if (var2.upgrade >= 15 && !gameHW && !var2.gameAC()) {
                    if (var10.gameAB("[" + var2.template.id + "]" + var2.template.name + (var2.upgrade > 0 ? " +" + var2.upgrade : ""), gameTJ - (GameCanvas.isTouch && GameCanvas.w >= 320 ? 20 : 10)).length > 1) {
                        this.gameGE -= 12;
                    }

                    if (var2.gameAC()) {
                        this.gameAA(var1, mFont.tahoma_7b_white, "[" + var2.template.id + "]" + var2.template.name, gameTH + 8, this.gameGE, 0);
                    } else {
                        this.gameAA(var1, mFont.tahoma_7b_white, "[" + var2.template.id + "]" + var2.template.name + (var2.upgrade > 0 ? " +" + var2.upgrade : ""), gameTH + 8, this.gameGE, 0);
                    }
                }

                if (!var2.gameAB()) {
                    if (var2.gameAC() && Char.getMyChar().arrItemMounts[4] != null) {
                        this.gameGE += 12;
                        var4 = Char.getMyChar().arrItemMounts[4].sys + 1;

                        for (var3 = 0; var3 < var4; ++var3) {
                            SmallImage.gameAB(var1, 633, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                    }
                } else {
                    this.gameGE += 12;
                    ++gameBO;
                    if (gameHW && GameCanvas.gameTick % 5 == 0) {
                        gameHW = !gameHW;
                    } else if (!gameHW && GameCanvas.gameTick % 5 == 0) {
                        gameHW = !gameHW;
                    }

                    var4 = var2.upgrade / 2 + 1;
                    if (var2.upgrade == 0) {
                        for (var3 = 0; var3 < var4; ++var3) {
                            SmallImage.gameAB(var1, 633, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (var2.upgrade > 0 && var2.upgrade < 4) {
                        for (var3 = 0; var3 < var4; ++var3) {
                            SmallImage.gameAB(var1, 625, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                        }

                        if (var2.upgrade == 3) {
                            SmallImage.gameAB(var1, 635, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (var2.upgrade >= 4 && var2.upgrade < 8) {
                        for (var3 = 0; var3 < var4; ++var3) {
                            SmallImage.gameAB(var1, 626, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                        }

                        if (var2.upgrade % 2 != 0) {
                            SmallImage.gameAB(var1, 636, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (var2.upgrade >= 8 && var2.upgrade < 12) {
                        for (var3 = 0; var3 < var4; ++var3) {
                            if (gameHW) {
                                SmallImage.gameAB(var1, 627, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.gameAB(var1, 628, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }

                        if (var2.upgrade % 2 != 0) {
                            if (gameHW) {
                                SmallImage.gameAB(var1, 637, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.gameAB(var1, 638, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                    } else if (var2.upgrade >= 12 && var2.upgrade < 15) {
                        for (var3 = 0; var3 < var4; ++var3) {
                            if (gameHW) {
                                SmallImage.gameAB(var1, 629, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.gameAB(var1, 630, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }

                        if (var2.upgrade % 2 != 0) {
                            if (gameHW) {
                                SmallImage.gameAB(var1, 639, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.gameAB(var1, 640, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                    } else {
                        for (var3 = 0; var3 < var4; ++var3) {
                            if (gameHW) {
                                SmallImage.gameAB(var1, 631, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.gameAB(var1, 632, gameTH + 12 + var3 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }

                        if (var2.upgrade % 2 != 0) {
                            if (gameHW) {
                                SmallImage.gameAB(var1, 641, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.gameAB(var1, 642, gameTH + 12 + var4 * 10, this.gameGE + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                    }
                }

                mFont.tahoma_7_white.gameAA(var1, var2.isLock ? mResources.gameKG : mResources.gameKM, gameTH + 8, this.gameGE += 12, 0);
                String var13;
                if ((var2.gameAB() || var2.gameAC()) && (var13 = var2.template.type == 12 ? mResources.gameFU : (var2.template.level >= 10 && var2.template.type < 10 ? (var2.upgrade == 0 ? mResources.gameFS : null) : mResources.gameFT)) != null) {
                    this.gameAA(var1, mFont.tahoma_7_white, var13, gameTH + 8, this.gameGE += 12, 0);
                    ++gameBO;
                }

                if (var2.template.gender == 0 || var2.template.gender == 1) {
                    if (var2.template.gender == Char.getMyChar().cgender) {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameRG[var2.template.gender], gameTH + 8, this.gameGE += 12, 0);
                        ++gameBO;
                    } else {
                        mFont.tahoma_7_red.gameAA(var1, mResources.gameRG[var2.template.gender], gameTH + 8, this.gameGE += 12, 0);
                        ++gameBO;
                    }
                }

                if (Char.getMyChar().clevel != -1) {
                    if (Char.getMyChar().clevel >= var2.template.level) {
                        this.gameAA(var1, mFont.tahoma_7_white, mResources.gameKZ + " " + var2.template.level, gameTH + 8, this.gameGE += 12, 0);
                    } else {
                        this.gameAA(var1, mFont.tahoma_7_red, mResources.gameKZ + " " + var2.template.level, gameTH + 8, this.gameGE += 12, 0);
                    }
                }

                if ((var2.template.id < 40 || var2.template.id > 48) && var2.template.id != 311 && var2.template.id != 375 && var2.template.id != 397 && var2.template.id != 552 && var2.template.id != 558) {
                    if ((var2.template.id < 49 || var2.template.id > 57) && var2.template.id != 312 && var2.template.id != 376 && var2.template.id != 398 && var2.template.id != 553 && var2.template.id != 559) {
                        if ((var2.template.id < 58 || var2.template.id > 66) && var2.template.id != 313 && var2.template.id != 377 && var2.template.id != 399 && var2.template.id != 554 && var2.template.id != 560) {
                            if ((var2.template.id < 67 || var2.template.id > 75) && var2.template.id != 314 && var2.template.id != 378 && var2.template.id != 400 && var2.template.id != 555 && var2.template.id != 561) {
                                if ((var2.template.id < 76 || var2.template.id > 84) && var2.template.id != 315 && var2.template.id != 379 && var2.template.id != 401 && var2.template.id != 556 && var2.template.id != 562) {
                                    if (var2.template.id >= 85 && var2.template.id <= 93 || var2.template.id == 316 || var2.template.id == 380 || var2.template.id == 402 || var2.template.id == 557 || var2.template.id == 563) {
                                        if (Char.getMyChar().nClass.classId == 6) {
                                            mFont.tahoma_7_white.gameAA(var1, mResources.gameMA + " " + nClasss[6].name, gameTH + 8, this.gameGE += 12, 0);
                                        } else {
                                            mFont.tahoma_7_red.gameAA(var1, mResources.gameMA + " " + nClasss[6].name, gameTH + 8, this.gameGE += 12, 0);
                                        }

                                        ++gameBO;
                                    }
                                } else {
                                    if (Char.getMyChar().nClass.classId == 5) {
                                        mFont.tahoma_7_white.gameAA(var1, mResources.gameMA + " " + nClasss[5].name, gameTH + 8, this.gameGE += 12, 0);
                                    } else {
                                        mFont.tahoma_7_red.gameAA(var1, mResources.gameMA + " " + nClasss[5].name, gameTH + 8, this.gameGE += 12, 0);
                                    }

                                    ++gameBO;
                                }
                            } else {
                                if (Char.getMyChar().nClass.classId == 4) {
                                    mFont.tahoma_7_white.gameAA(var1, mResources.gameMA + " " + nClasss[4].name, gameTH + 8, this.gameGE += 12, 0);
                                } else {
                                    mFont.tahoma_7_red.gameAA(var1, mResources.gameMA + " " + nClasss[4].name, gameTH + 8, this.gameGE += 12, 0);
                                }

                                ++gameBO;
                            }
                        } else {
                            if (Char.getMyChar().nClass.classId == 3) {
                                mFont.tahoma_7_white.gameAA(var1, mResources.gameMA + " " + nClasss[3].name, gameTH + 8, this.gameGE += 12, 0);
                            } else {
                                mFont.tahoma_7_red.gameAA(var1, mResources.gameMA + " " + nClasss[3].name, gameTH + 8, this.gameGE += 12, 0);
                            }

                            ++gameBO;
                        }
                    } else {
                        if (Char.getMyChar().nClass.classId == 2) {
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameMA + " " + nClasss[2].name, gameTH + 8, this.gameGE += 12, 0);
                        } else {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gameMA + " " + nClasss[2].name, gameTH + 8, this.gameGE += 12, 0);
                        }

                        ++gameBO;
                    }
                } else {
                    if (Char.getMyChar().nClass.classId == 1) {
                        mFont.tahoma_7_white.gameAA(var1, mResources.gameMA + " " + nClasss[1].name, gameTH + 8, this.gameGE += 12, 0);
                    } else {
                        mFont.tahoma_7_red.gameAA(var1, mResources.gameMA + " " + nClasss[1].name, gameTH + 8, this.gameGE += 12, 0);
                    }

                    ++gameBO;
                }

                if (!var2.gameAC()) {
                    if (var2.template.id == 420) {
                        if (Char.getMyChar().nClass.classId != 1 && Char.getMyChar().nClass.classId != 2) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gamePP[1], gameTH + 8, this.gameGE += 12, 0);
                        } else {
                            mFont.tahoma_7_white.gameAA(var1, mResources.gamePP[1], gameTH + 8, this.gameGE += 12, 0);
                        }

                        ++gameBO;
                    } else if (var2.template.id == 421) {
                        if (Char.getMyChar().nClass.classId != 3 && Char.getMyChar().nClass.classId != 4) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gamePP[2], gameTH + 8, this.gameGE += 12, 0);
                        } else {
                            mFont.tahoma_7_white.gameAA(var1, mResources.gamePP[2], gameTH + 8, this.gameGE += 12, 0);
                        }

                        ++gameBO;
                    } else if (var2.template.id == 422) {
                        if (Char.getMyChar().nClass.classId != 5 && Char.getMyChar().nClass.classId != 6) {
                            mFont.tahoma_7_red.gameAA(var1, mResources.gamePP[3], gameTH + 8, this.gameGE += 12, 0);
                        } else {
                            mFont.tahoma_7_white.gameAA(var1, mResources.gamePP[3], gameTH + 8, this.gameGE += 12, 0);
                        }

                        ++gameBO;
                    }
                }

                if (var2.expires > 0L) {
                    if (!var2.gameAJ() && !var2.gameAK() && !var2.gameAL() && !var2.gameAM() && !var2.gameAN() && !var2.gameAO() && var2.typeUI != 39) {
                        if ((var4 = mFont.tahoma_7.gameAA(mResources.gameKN + ": " + var2.gameAE()) + 10) > gameTJ && !GameCanvas.gameAI) {
                            gameTJ = var4;
                        }

                        this.gameAA(var1, mFont.tahoma_7_yellow, mResources.gameKN + ": " + var2.gameAE(), gameTH + 8, this.gameGE += 12, 0);
                    } else {
                        if ((var4 = mFont.tahoma_7.gameAA(mResources.gameKN + ": " + var2.gameAF()) + 10) > gameTJ && !GameCanvas.gameAI) {
                            gameTJ = var4;
                        }

                        this.gameAA(var1, mFont.tahoma_7_yellow, mResources.gameKN + ": " + var2.gameAF(), gameTH + 8, this.gameGE += 12, 0);
                    }

                    ++gameBO;
                }

                if (!var2.template.description.equals("")) {
                    this.gameAA(var1, mFont.tahoma_7_white, var2.template.description, gameTH + 8, this.gameGE += 12, 0);
                    ++gameBO;
                }

                if (!var2.gameAH() && var2.typeUI != 37) {
                    if (var2.gameAJ() || var2.gameAK() || var2.gameAL() || var2.gameAM() || var2.gameAN() || var2.gameAO()) {
                        if (var2.buyCoin > 0) {
                            if (var2.gameAO()) {
                                if ((var4 = mFont.tahoma_7.gameAA(mResources.gameAA(mResources.gameKQ, NinjaUtil.gameAA(String.valueOf(var2.buyCoin)))) + 10) > gameTJ && !GameCanvas.gameAI) {
                                    gameTJ = var4;
                                }

                                mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKQ, NinjaUtil.gameAA(String.valueOf(var2.buyCoin))), gameTH + 8, this.gameGE += 12, 0);
                            } else {
                                mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKP, NinjaUtil.gameAA(String.valueOf(var2.buyCoin))), gameTH + 8, this.gameGE += 12, 0);
                            }

                            ++gameBO;
                        } else if (var2.buyCoinLock > 0) {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKR, NinjaUtil.gameAA(String.valueOf(var2.buyCoinLock))), gameTH + 8, this.gameGE += 12, 0);
                            ++gameBO;
                        } else if (var2.buyGold > 0) {
                            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKS, NinjaUtil.gameAA(String.valueOf(var2.buyGold))), gameTH + 8, this.gameGE += 12, 0);
                            ++gameBO;
                        }
                    }
                } else {
                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAA(mResources.gameKO, NinjaUtil.gameAA(String.valueOf(var2.saleCoinLock))), gameTH + 8, this.gameGE += 12, 0);
                    ++gameBO;
                }

                if (var2.template.type == 33) {
                    mFont.tahoma_7_yellow.gameAA(var1, mResources.gameFB + ": " + (var2.upgrade + 1), gameTH + 8, this.gameGE += 12, 0);
                    ++gameBO;
                }

                if (var2.gameAB() && var2.sys != 0) {
                    mFont.tahoma_7_blue1.gameAA(var1, mResources.gamePP[var2.sys], gameTH + 8, this.gameGE += 12, 0);
                    ++gameBO;
                }

                if (var2.expires != 0L && var2.options != null && var2.options.size() > 0) {
                    boolean var14 = false;
                    boolean var5 = false;

                    for (int var6 = 0; var6 < var2.options.size(); ++var6) {
                        ItemOption var7 = (ItemOption) var2.options.elementAt(var6);
                        if (!var14 && var7.optionTemplate.type == 2) {
                            var14 = true;
                            String var8 = mResources.gameRT[0] + ": ";
                            if (var2.template.type == 1) {
                                var8 = var8 + mResources.gameRS[var2.template.type] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 0) {
                                var8 = var8 + mResources.gameRS[6] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[5] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 6) {
                                var8 = var8 + mResources.gameRS[0] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[5] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 5) {
                                var8 = var8 + mResources.gameRS[0] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[6] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 2) {
                                var8 = var8 + mResources.gameRS[8] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[7] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 8) {
                                var8 = var8 + mResources.gameRS[2] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[7] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 7) {
                                var8 = var8 + mResources.gameRS[2] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[8] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 4) {
                                var8 = var8 + mResources.gameRS[3] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[9] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 3) {
                                var8 = var8 + mResources.gameRS[4] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[9] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            } else if (var2.template.type == 9) {
                                var8 = var8 + mResources.gameRS[4] + "(" + mResources.gameRU[this.gameHR.sys] + "), " + mResources.gameRS[3] + "(" + mResources.gameRU[this.gameHR.sys] + ")";
                            }

                            if ((var4 = mFont.tahoma_7_white.gameAA(var8) + 15) > gameTJ && !GameCanvas.gameAI) {
                                gameTJ = var4;
                            }

                            this.gameAA(var1, mFont.tahoma_7_white, var8, gameTH + 8, this.gameGE += 12, 0);
                            ++gameBO;
                        }

                        if (!var5 && var7.optionTemplate.type > 2 && var7.optionTemplate.type < 8) {
                            var5 = true;
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameRT[1], gameTH + 8, this.gameGE += 12, 0);
                            ++gameBO;
                        }

                        if (var7.optionTemplate.id == 65) {
                            this.gameAA(var1, mFont.tahoma_7_blue, var2.template.id == 485 ? NinjaUtil.gameAA(var7.gameAA(), mResources.gameKF, mResources.gameXC) : var7.gameAA(), gameTH + 8, this.gameGE += 12, 0);
                        } else if (var7.optionTemplate.id == 66) {
                            this.gameAA(var1, mFont.tahoma_7_blue1, var2.template.id == 485 ? NinjaUtil.gameAA(var7.gameAA(), mResources.gameWM, mResources.gameXD) : var7.gameAA(), gameTH + 8, this.gameGE += 12, 0);
                        } else if (var7.optionTemplate.type == 0) {
                            this.gameAA(var1, mFont.tahoma_7_blue1, var2.gameAI() ? var7.gameAB() : var7.gameAA(), gameTH + 8, this.gameGE += 12, 0);
                        } else if (var7.optionTemplate.type == 1) {
                            this.gameAA(var1, mFont.tahoma_7_green, var2.gameAI() ? var7.gameAB() : var7.gameAA(), gameTH + 8, this.gameGE += 12, 0);
                        } else {
                            label961:
                            {
                                mFont var9;
                                mGraphics var11;
                                GameScr var15;
                                String var10000;
                                if (var7.optionTemplate.type == 8) {
                                    if (var7.optionTemplate.id == 85) {
                                        this.gameAA(var1, mFont.tahoma_7_yellow, var2.gameAI() ? var7.gameAB() : NinjaUtil.gameAA(var7.optionTemplate.name, "#", String.valueOf(var7.param)), gameTH + 8, this.gameGE += 12, 0);
                                        break label961;
                                    }

                                    var15 = this;
                                    var11 = var1;
                                    var9 = mFont.tahoma_7b_blue;
                                    var10000 = var7.gameAB();
                                } else {
                                    if ((var7.optionTemplate.type != 2 || var2.typeUI != 5 || var7.active != 1) && (var7.optionTemplate.type != 3 || var2.upgrade < 4) && (var7.optionTemplate.type != 4 || var2.upgrade < 8) && (var7.optionTemplate.type != 5 || var2.upgrade < 12) && (var7.optionTemplate.type != 6 || var2.upgrade < 14) && (var7.optionTemplate.type != 7 || var2.upgrade < 16)) {
                                        this.gameAA(var1, mFont.tahoma_7_grey, var2.gameAI() ? var7.gameAB() : var7.gameAA(), gameTH + 8, this.gameGE += 12, 0);
                                        break label961;
                                    }

                                    var15 = this;
                                    var11 = var1;
                                    var9 = mFont.tahoma_7_green;
                                    var10000 = var2.gameAI() ? var7.gameAB() : var7.gameAA();
                                }

                                String var12 = var10000;
                                var15.gameAA(var11, var9, var12, gameTH + 8, this.gameGE += 12, 0);
                            }
                        }

                        ++gameBO;
                    }
                }

                if (gameMJ) {
                    if (var2.template.id == 12) {
                        mFont.tahoma_7_red.gameAA(var1, NinjaUtil.gameAA(this.gameFI[gameBM]) + " " + mResources.gamePF, gameTH + 8, this.gameGE += 12, 0);
                    }

                    if (var2.template.type >= 0 && var2.template.type <= 9) {
                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameVY, gameTH + 8, this.gameGE += 12, 0);
                    }

                    ++gameBO;
                }

                if (indexRow >= 0 && (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.w < 320)) {
                    SmallImage.gameAB(var1, 942, gameTH + 1, gameTI + 5 + indexRow * 12, 0, StaticObj.gameAB);
                }

                gameBT.gameAA(gameBO, 12, gameTH, gameTI + 2, gameTJ, gameTK - 4, true, 1);
            }
        }

    }

    private static void gameBN(mGraphics var0) {
        gameAB(var0);
        var0.gameAA(0);
        var0.gameAD(gameTH - 2, gameTI - 2, gameTJ + 5, gameTK + 5);
        var0.gameAA(13606712);
        var0.gameAC(gameTH - 1, gameTI - 1, gameTJ + 2, gameTK + 2);
        var0.gameAA(Paint.COLORBACKGROUND);
        var0.gameAD(gameTH, gameTI, gameTJ, gameTK);
    }

    private static void gameDT() {
        if (GameCanvas.gameAI && (!gameMH || gameBP != 0)) {
            gameTH = popupX + 175;
            gameTJ = gameGC - 179;
            gameTI = popupY + 33;
            gameTK = 138;
            if (isPaintTrade && gameBP == 0) {
                gameTH = popupX + 6 + 3 * gameBL;
                gameTJ = gameGC - (11 + 6 * gameBL);
            }

            if (gameDL) {
                if (gameBP == 4) {
                    gameTH = popupX + 33;
                    gameTI = popupY + 87;
                    gameTJ = gameGC - 67;
                    gameTK = 75;
                    return;
                }

                if (gameBP == 5) {
                    gameTK = 161;
                }
            }
        }

    }

    public final void gameBI() {
        super.center = null;
        if (gameHQ != 0 || gameBP != 1 && gameBP != 3 && gameBP != 4) {
            switch (gameBP) {
                case 0:
                    if (gameHQ == 1) {
                        if (gameAN(3) != null) {
                            super.left = this.gameTR;
                            if (GameCanvas.isTouch && GameCanvas.w < 320 || !GameCanvas.isTouch) {
                                super.center = this.gameTQ;
                            }
                        } else {
                            gameDK = false;
                            super.left = this.gameTM;
                        }
                    }
                    break;
                case 1:
                    if (gameHQ == 1) {
                        super.left = null;
                        if (gameBM >= 0) {
                            SkillTemplate var3 = Char.getMyChar().nClass.skillTemplates[gameBM];
                            Skill var2;
                            if ((var2 = Char.getMyChar().gameAA(var3)) != null) {
                                if (var2.point < var3.maxPoint) {
                                    super.left = new Command(mResources.gameEF, 14001);
                                }

                                if (var2.template.type != 1 && var2.template.type != 4 && var2.template.type != 2 && var2.template.type != 3) {
                                    super.center = null;
                                } else {
                                    super.center = new Command(mResources.gameEY, 11081);
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    if (gameHQ > 0) {
                        super.left = new Command(mResources.gameEF, 11084);
                        super.center = new Command("", 11084);
                    }
                    break;
                case 3:
                    super.left = null;
                    super.center = new Command(mResources.CHANGE, 110854);
                    break;
                case 4:
                    if (gameHQ == 1) {
                        super.left = null;
                        super.center = new Command(indextabTrangbi > 0 ? "Tbi 1" : "Tbi 2", 2003);

                        Item var1;
                        if ((var1 = gameAN(5)) != null) {
                            if (currentCharViewInfo.charID == Char.getMyChar().charID) {
                                super.left = new Command(mResources.SELECT, 11082);
                                if (GameCanvas.gameAI) {
                                    this.gameAA((int) 5, (Item) var1);
                                } else {
                                    super.center = new Command(mResources.gameCF, 11083);
                                }
                            } else if (GameCanvas.gameAI) {
                                this.gameAA((int) 5, (Item) var1);
                            } else {
                                super.center = new Command(mResources.gameCF, 11083);
                            }
                        } else {
                            gameDK = false;
                        }
                    }
                    break;
                case 5:
                    super.left = null;
                    if (gameHQ == 1 && gameBM >= 0 && currentCharViewInfo.arrItemMounts[gameBM] != null) {
                        if (Char.getMyChar().charID == currentCharViewInfo.charID) {
                            super.left = new Command(mResources.gameCR, 1516);
                        }

                        super.center = new Command(GameCanvas.gameAI ? "" : mResources.gameCF, 1515);
                    }
            }

            if (currentCharViewInfo.charID == Char.getMyChar().charID) {
                super.right = new Command(mResources.gameFL, 11086);
            } else {
                super.right = this.gameSA;
            }
        } else {
            super.left = null;
        }
    }

    public final void gameAD(int var1) {
        gameHQ = 0;
        super.right = this.gameSA;
        switch (var1) {
            case 2:
                gameBP = 0;
                gameKU = true;
                if (gameCJ == null) {
                    Service.gI().gameAI(2);
                }
            case 3:
            case 5:
            case 30:
            case 39:
            case 41:
            case 42:
            default:
                break;
            case 4:
                gameBP = 0;
                gameMD = true;
                if (Char.getMyChar().arrItemBox == null) {
                    Service.gI().gameAI(4);
                }
                break;
            case 6:
                gameBP = 0;
                gameKV = true;
                if (gameCK == null) {
                    Service.gI().gameAI(6);
                }
                break;
            case 7:
                gameBP = 0;
                gameKW = true;
                if (gameCL == null) {
                    Service.gI().gameAI(7);
                }
                break;
            case 8:
                gameBP = 0;
                gameKX = true;
                if (gameCM == null) {
                    Service.gI().gameAI(8);
                }
                break;
            case 9:
                gameBP = 0;
                gameKY = true;
                if (gameCN == null) {
                    Service.gI().gameAI(9);
                }
                break;
            case 10:
                gameBP = 0;
                gameKZ = true;
                upitem = new Item[18];
                break;
            case 11:
                gameBP = 0;
                gameMC = true;
                gameHS = true;
                gameCT = new Item[24];
                break;
            case 12:
                gameBP = 0;
                gameMC = true;
                gameHS = false;
                gameCT = new Item[24];
                break;
            case 13:
                gameBP = 0;
                gameME = true;
                gameCV = new Item[24];
                break;
            case 14:
                gameKE = true;
                gameBP = 0;
                if (gameCO == null) {
                    Service.gI().gameAI(14);
                }
                break;
            case 15:
                gameKE = true;
                gameBP = 1;
                if (gameCR == null) {
                    Service.gI().gameAI(15);
                }
                break;
            case 16:
                gameBP = 0;
                gameKQ = true;
                if (gameCF == null) {
                    Service.gI().gameAI(16);
                }
                break;
            case 17:
                gameBP = 0;
                gameKR = true;
                if (gameCG == null) {
                    Service.gI().gameAI(17);
                }
                break;
            case 18:
                gameBP = 0;
                gameKS = true;
                if (gameCH == null) {
                    Service.gI().gameAI(18);
                }
                break;
            case 19:
                gameBP = 0;
                gameKT = true;
                if (gameCI == null) {
                    Service.gI().gameAI(19);
                }
                break;
            case 20:
                gameBP = 0;
                gameKG = true;
                if (gameBV == null) {
                    Service.gI().gameAI(20);
                }
                break;
            case 21:
                gameBP = 0;
                gameKH = true;
                if (gameBW == null) {
                    Service.gI().gameAI(21);
                }
                break;
            case 22:
                gameBP = 0;
                gameKI = true;
                if (gameBX == null) {
                    Service.gI().gameAI(22);
                }
                break;
            case 23:
                gameBP = 0;
                gameKJ = true;
                if (gameBY == null) {
                    Service.gI().gameAI(23);
                }
                break;
            case 24:
                gameBP = 0;
                gameKK = true;
                if (gameBZ == null) {
                    Service.gI().gameAI(24);
                }
                break;
            case 25:
                gameBP = 0;
                gameKL = true;
                if (gameCA == null) {
                    Service.gI().gameAI(25);
                }
                break;
            case 26:
                gameBP = 0;
                gameKM = true;
                if (gameCB == null) {
                    Service.gI().gameAI(26);
                }
                break;
            case 27:
                gameBP = 0;
                gameKN = true;
                if (gameCC == null) {
                    Service.gI().gameAI(27);
                }
                break;
            case 28:
                gameBP = 0;
                gameKO = true;
                if (gameCD == null) {
                    Service.gI().gameAI(28);
                }
                break;
            case 29:
                gameBP = 0;
                gameKP = true;
                if (gameCE == null) {
                    Service.gI().gameAI(29);
                }
                break;
            case 31:
                gameBP = 0;
                gameKZ = true;
                gameMB = true;
                upitem = new Item[18];
                break;
            case 32:
                gameKE = true;
                gameBP = 2;
                if (gameCS == null) {
                    Service.gI().gameAI(32);
                }
                break;
            case 33:
                gameBP = 0;
                gameMA = true;
                gameCY = new Item[3];
                break;
            case 34:
                gameKE = true;
                gameBP = 3;
                if (gameCQ == null) {
                    Service.gI().gameAI(34);
                }
                break;
            case 35:
                gameKF = true;
                gameBP = 0;
                if (gameCP == null) {
                    Service.gI().gameAI(35);
                }
                break;
            case 36:
                gameBP = 0;
                gameDH = true;
                gameDE = null;
                this.gameNE = new TField();
                this.gameNE.gameAB(9);
                this.gameNE.gameAC(1);
                this.gameNE.width = 100;
                this.gameNE.height = mScreen.ITEM_HEIGHT + 2;
                break;
            case 37:
                gameMK = true;
                this.gameBB();
                break;
            case 38:
                gameDA = null;
                gameMJ = true;
                gameHQ = 1;
                this.gameBB();
                break;
            case 40:
                gameDN = true;
                gameHQ = 1;
                indexRow = 0;
                this.gameBB();
                break;
            case 43:
                gameBP = 0;
                gameML = true;
                gameCT = new Item[24];
                break;
            case 44:
                gameBP = 0;
                gameMM = true;
                gameCV = new Item[24];
                break;
            case 45:
                gameBP = 0;
                gameMN = true;
                gameCV = new Item[24];
                break;
            case 46:
                gameBP = 0;
                gameMO = true;
                gameCV = new Item[24];
                break;
            case 47:
                gameBP = 0;
                gameMP = true;
                upitem = new Item[18];
                break;
            case 48:
                gameBP = 0;
                gameMT = true;
                gameCV = new Item[18];
                break;
            case 49:
                gameBP = 0;
                gameMQ = true;
                gameDD = null;
                break;
            case 50:
                gameBP = 0;
                gameMR = true;
                gameDD = null;
        }

        setSize(175, 200);
    }

    public static Char gameAE(int var0) {
        for (int var1 = 0; var1 < vCharInMap.size(); ++var1) {
            Char var2;
            if ((var2 = (Char) vCharInMap.elementAt(var1)).charID == var0) {
                return var2;
            }
        }

        return null;
    }

    public static Char gameAA(String var0) {
        for (int var1 = 0; var1 < vCharInMap.size(); ++var1) {
            Char var2;
            if ((var2 = (Char) vCharInMap.elementAt(var1)).cName.equals(var0)) {
                return var2;
            }
        }

        return null;
    }

    public static BuNhin gameAF(int var0) {
        return gameBJ.size() > 0 ? (BuNhin) gameBJ.elementAt(var0) : null;
    }

    public final void onChatFromMe(String var1, String var2) {
        if (!isPaintMessage || GameCanvas.isTouch) {
            ChatTextField.gameAA().isShow = false;
        }

        if (!var1.equals("")) {
            if (var2.equals(mResources.PUBLICCHAT[0])) {
                Code var10000 = Code.gameAA;
                if (!Code.gameAF(var1)) {
                    Service.gI().gameAC(var1);
                    return;
                }

                return;
            }

            if (var2.equals(mResources.PARTYCHAT[0])) {
                if (vParty.size() == 0) {
                    ChatManager.gameAD().gameAE().gameAA(mResources.gameRK);
                    return;
                }

                Service.gI().gameAK(var1);
                return;
            }

            if (var2.equals(mResources.GLOBALCHAT[0])) {
                Service.gI().gameAL(var1);
                return;
            }

            if (var2.equals(mResources.CLANCHAT[0])) {
                if (Char.getMyChar().cClanName.equals("")) {
                    ChatManager.gameAD().gameAE().gameAA(mResources.gameRP);
                    return;
                }

                Service.gI().gameAM(var1);
                return;
            }

            ChatManager.gameAD().gameAA(var2, Char.getMyChar().cName, var1);
            Service.gI().gameAA(var2, var1);
        }

    }

    public final void onCancelChat() {
        if (isPaintMessage) {
            this.gameBG();
            isPaintMessage = false;
            ChatTextField.gameAA().gameAF = null;
        }

    }

    private void gameAA(int var1, int var2, int var3, int var4, int var5) {
        if (gameMC || gameML || gameMM || gameMN || gameME || isPaintTrade || gameKZ || gameMA || gameDH || gameMO || gameMP || gameMQ || gameMR) {
            int var6 = var3 * gameBL;
            var4 *= gameBL;
            gameBU.gameAA();
            if (GameCanvas.gameAB(var1, var2, var6, var4)) {
                gameHQ = var5;
                if (GameCanvas.isPointerClick) {
                    if ((var1 = (GameCanvas.pxLast - var1) / gameBL + (GameCanvas.pyLast - var2) / gameBL * var3) / gameTC < gameTD) {
                        gameBM = var1;
                    }

                    super.left = super.center = null;
                    if (isPaintTrade) {
                        if (gameBM < 0) {
                            gameBM = 11;
                        }

                        if (gameBM > 11) {
                            gameBM = 11;
                        }
                    }

                    this.gameBB();
                }
            }
        }

    }

    public final void gameAB(int var1, Object var2) {
        if (var1 / 10000 == 99 && gameAQ) {
            this.gameGR.gameAA(var1, var2);
        } else {
            Npc var4;
            Member var14;
            String var15;
            int var16;
            MobTemplate var17;
            MyVector var18;
            MyVector var19;
            Item var21;
            Skill var23;
            Npc var24;
            Object[] var26;
            switch (var1) {
                case 1:
                    GameCanvas.endDlg();
                    return;
                case 2:
                    GameCanvas.endDlg();
                    super.left = super.center = null;
                    this.gameBB();
                    return;
                case 3:
                    this.gameBG();
                    return;
                case 222:
                    this.gameKJ();
                    return;
                case 333:
                    this.gameAD((int) 47);
                    return;
                case 334:
                    this.gameFI();
                    return;
                case 335:
                    gameHT = false;
                    this.gameAA((int) 3, (Item) gameDD);
                    return;
                case 336:
                    gameHT = false;
                    this.gameAA((int) 3, (Item) arritemup);
                    return;
                case 337:
                    this.gameKK();
                    return;
                case 338:
                    this.gameAR(0);
                    return;
                case 339:
                    this.gameAS(0);
                    return;
                case 340:
                    this.gameAS(1);
                    return;
                case 341:
                    gameKL();
                    return;
                case 342:
                    gameKM();
                    return;
                case 343:
                    this.gameAS(2);
                    return;
                case 344:
                    this.gameAR(1);
                    return;
                case 345:
                    this.gameAR(2);
                    return;
                case 400:
                    this.gameKO();
                    return;
                case 401:
                    this.gameKP();
                    return;
                case 402:
                    this.gameKQ();
                    return;
                case 403:
                    gameKR();
                    return;
                case 405:
                    gameKN();
                    return;
                case 999:
                    this.gameAD((int) 35);
                    return;
                case 1000:
                    Service.gI().gameBF();
                    this.gameAU();
                    return;
                case 1500:
                    (var18 = new MyVector()).addElement(new Command(mResources.gameCR, 15001));
                    if (Char.getMyChar().xu >= 5000) {
                        var18.addElement(new Command(mResources.gameCW, 15002));
                    }

                    GameCanvas.menu.gameAA(var18);
                    return;
                case 1501:
                    this.gameAA((int) 3, (Item) gameDE);
                    return;
                case 1502:
                    this.gameNE.gameAA();
                    return;
                case 1503:
                    gameEC();
                    return;
                case 1504:
                    gameEA();
                    return;
                case 1505:
                    this.gameAA((int) 3, (Item) arrItemStands[gameBM].item);
                    return;
                case 1506:
                    if (gameDA != null) {
                        this.gameFG = 0;
                        gameDK = false;
                        gameBQ = -1;
                        gameDA = null;
                        gI().left = new Command(mResources.SELECT, 1506);
                        return;
                    }

                    gameBQ = gameBM;
                    Service.gI().gameBH();
                    GameCanvas.gameAN();
                    return;
                case 1507:
                    this.gameDX();
                    return;
                case 1508:
                    var18 = new MyVector();
                    if ((var21 = Char.clan.items[gameBM]) != null) {
                        if (var21.template.id == 281) {
                            var18.addElement(new Command(mResources.gameCK, 15081));
                        } else {
                            var18.addElement(new Command(mResources.gameRQ, 15082));
                        }

                        GameCanvas.menu.gameAA(var18);
                        return;
                    }
                    break;
                case 1509:
                    if (gameBM >= 0 && Char.clan != null) {
                        this.gameAA((int) 39, (Item) Char.clan.items[gameBM]);
                        return;
                    }

                    gameDK = false;
                    return;
                case 1510:
                    gameDW();
                    return;
                case 1511:
                    var15 = GameCanvas.inputDlg.tfInput.gameAD();
                    GameCanvas.endDlg();

                    try {
                        if (var15.equals("")) {
                            GameCanvas.gameAA(mResources.gameVE);
                            return;
                        }

                        if ((var1 = (Integer.valueOf(var15)).intValue()) > 0 && var1 < 100) {
                            Char.aHpValue = var1;
                            return;
                        }

                        GameCanvas.gameAA(mResources.gameVE);
                        return;
                    } catch (Exception var13) {
                        GameCanvas.gameAA(mResources.gameVE);
                        return;
                    }
                case 1512:
                    var15 = GameCanvas.inputDlg.tfInput.gameAD();
                    GameCanvas.endDlg();

                    try {
                        if (var15.equals("")) {
                            GameCanvas.gameAA(mResources.gameVE);
                            return;
                        }

                        if ((var1 = (Integer.valueOf(var15)).intValue()) >= 10 && var1 <= 90) {
                            Char.aMpValue = var1;
                            return;
                        }

                        GameCanvas.gameAA(mResources.gameVE);
                        return;
                    } catch (Exception var12) {
                        GameCanvas.gameAA(mResources.gameVE);
                        return;
                    }
                case 1515:
                    this.gameAA((int) 41, (Item) currentCharViewInfo.arrItemMounts[gameBM]);
                    return;
                case 1516:
                    Service.gI().gameAC(gameBM);
                    return;
                case 1600:
                    gameDQ();
                    return;
                case 1601:
                    gameFE();
                    return;
                case 1602:
                    var21 = gameAN(43);
                    this.gameAA((int) 3, (Item) var21);
                    return;
                case 1603:
                    this.gameFB();
                    return;
                case 1604:
                    var18 = new MyVector();
                    if (gameCV[gameBM] != null) {
                        var18.addElement(new Command(mResources.gameCR, 1605));
                    }

                    var18.addElement(new Command(mResources.gameGC, 11105));
                    GameCanvas.menu.gameAA(var18);
                    return;
                case 1605:
                    this.gameDV();
                    return;
                case 1606:
                    this.gameDU();
                    return;
                case 1700:
                    this.gameKG();
                    return;
                case 1701:
                    gameKH();
                    return;
                case 1702:
                    this.gameKI();
                    return;
                case 2000:
                    Service.gI().gameBG();
                    this.gameAU();
                    return;
                case 2003:
                    if (indextabTrangbi == 0) {
                        indextabTrangbi = 16;
                        this.center.caption = "Tbi 1";
                        return;
                    }

                    indextabTrangbi = 0;
                    this.center.caption = "Tbi 2";
                    if (!GameCanvas.isTouch) {
                        super.right = new Command("....", 11082);
                        return;
                    }
                    break;
                case 11000:
                    gameCF();
                    return;
                case 11001:
                    Char.getMyChar().gameAX();
                    return;
                case 11002:
                    gameKE();
                    return;
                case 11003:
                    gameKD();
                    return;
                case 11004:
                    this.gameAD((byte) 25);
                    return;
                case 11005:
                    gameKB();
                    return;
                case 11006:
                    gameKC();
                    return;
                case 11007:
                    this.gameAD((byte) 24);
                    return;
                case 11008:
                    gameKA();
                    return;
                case 11009:
                    this.gameAD((byte) 23);
                    return;
                case 11010:
                    gameHZ();
                    return;
                case 11011:
                    this.gameAD((byte) 22);
                    return;
                case 11012:
                    gameHY();
                    return;
                case 11013:
                    this.gameAD((byte) 21);
                    return;
                case 11014:
                    gameHX();
                    return;
                case 11015:
                    this.gameAD((byte) 20);
                    return;
                case 11016:
                    gameHW();
                    return;
                case 11017:
                    this.gameAD((byte) 15);
                    return;
                case 11018:
                    gameHU();
                    return;
                case 11019:
                    this.gameAD((byte) 14);
                    return;
                case 11020:
                    gameHT();
                    return;
                case 11021:
                    this.gameAU();
                    return;
                case 11022:
                    this.gameHR();
                    return;
                case 11023:
                    this.gameHQ();
                    return;
                case 11024:
                    gameHP();
                    return;
                case 11025:
                    this.gameBX();
                    return;
                case 11026:
                    gameHM();
                    return;
                case 11027:
                    this.gameHL();
                    return;
                case 11028:
                    this.gameHK();
                    return;
                case 11029:
                    this.gameHJ();
                    return;
                case 11030:
                    this.gameHI();
                    return;
                case 11032:
                    this.gameHH();
                    return;
                case 11033:
                    this.gameHG();
                    return;
                case 11034:
                    this.gameHE();
                    return;
                case 11035:
                    this.gameHD();
                    return;
                case 11036:
                    gameDK();
                    return;
                case 11037:
                    this.gameHC();
                    return;
                case 11038:
                    gameHA();
                    return;
                case 11040:
                    this.gameGX();
                    return;
                case 11041:
                    this.gameGW();
                    return;
                case 11042:
                    gameGT();
                    return;
                case 11043:
                    gameGR();
                    return;
                case 11044:
                    gameEI();
                    return;
                case 11045:
                    gameEO();
                    return;
                case 11046:
                    gameEN();
                    return;
                case 11047:
                    gameEK();
                    return;
                case 11048:
                    gameGN();
                    return;
                case 11049:
                    gameDJ();
                    return;
                case 11050:
                    gameDL();
                    return;
                case 11051:
                    gameGM();
                    return;
                case 11052:
                    var21 = (Item) var2;
                    Service.gI().gameAI(var21.indexUI, GameCanvas.menu.menuSelectedItem);
                    return;
                case 11053:
                    gameAG((Item) var2);
                    return;
                case 11054:
                    this.gameGG();
                    return;
                case 11055:
                    gameAF((Item) var2);
                    return;
                case 11057:
                    var24 = (Npc) var2;
                    Service.gI().gameAJ(var24.template.npcTemplateId, GameCanvas.menu.menuSelectedItem);
                    return;
                case 11058:
                    var21 = (Item) var2;
                    GameCanvas.endDlg();
                    Service.gI().gameAG(var21.indexUI, Integer.parseInt(GameCanvas.inputDlg.tfInput.gameAD()));
                    return;
                case 11059:
                    this.gameGF();
                    return;
                case 11060:
                    this.gameGE();
                    return;
                case 11061:
                    gameAD((Item) var2);
                    return;
                case 11062:
                    gameDP();
                    return;
                case 11063:
                    gameGD();
                    return;
                case 11064:
                    Service.gI().gameAE(gameHQ - 1, 1);
                    this.gameBI();
                    return;
                case 11065:
                    this.gameBY();
                    return;
                case 11066:
                    this.gameBG();
                    isPaintMessage = false;
                    gameDG = false;
                    ChatTextField.gameAA().gameAF = null;
                    return;
                case 11067:
                    if (TileMap.zoneID != gameBM) {
                        Service.gI().gameAA(gameBM, this.gameNA);
                        InfoDlg.gameAB();
                        return;
                    }

                    InfoMe.gameAA(mResources.gameSH);
                    return;
                case 11068:
                    var15 = (String) var2;
                    this.gameAH(var15);
                    return;
                case 11069:
                    this.gameGC();
                    return;
                case 11070:
                    gameAA((Party) var2);
                    return;
                case 11071:
                    Service.gI().gameAT();
                    return;
                case 11072:
                    gameGB();
                    return;
                case 11073:
                    gameAB(Char.getMyChar().arrItemBag[gameBM]);
                    return;
                case 11074:
                    short var20 = Short.parseShort(String.valueOf((var18 = (MyVector) var2).elementAt(0)));
                    var15 = String.valueOf(var18.elementAt(1));
                    this.gameAA(var20, var15);
                    return;
                case 11075:
                    this.gameGA();
                    return;
                case 11076:
                    var15 = (String) var2;
                    Service.gI().gameAF(var15);
                    return;
                case 11077:
                    gameAG((String) var2);
                    return;
                case 11078:
                    gameFZ();
                    return;
                case 11079:
                    gameFX();
                    return;
                case 11080:
                    gameAE((String) var2);
                    return;
                case 11081:
                    gameFV();
                    return;
                case 11082:
                    gameFU();
                    return;
                case 11083:
                    this.gameAD((byte) 5);
                    return;
                case 11084:
                    gameFT();
                    return;
                case 11085:
                    gameFS();
                    return;
                case 11086:
                    this.gameFR();
                    return;
                case 11087:
                    var21 = (Item) var2;
                    GameCanvas.endDlg();
                    Service.gI().gameAA(var21);
                    return;
                case 11088:
                    this.gameAD((byte) 26);
                    return;
                case 11089:
                    this.gameAD((byte) 27);
                    return;
                case 11090:
                    this.gameAD((byte) 28);
                    return;
                case 11091:
                    this.gameAD((byte) 29);
                    return;
                case 11092:
                    gameAC((Item) var2);
                    return;
                case 11093:
                    this.gameAD((byte) 2);
                    return;
                case 11094:
                    this.gameAD((byte) 6);
                    return;
                case 11095:
                    this.gameAD((byte) 7);
                    return;
                case 11096:
                    this.gameAD((byte) 8);
                    return;
                case 11097:
                    this.gameAD((byte) 9);
                    return;
                case 11098:
                    this.gameFP();
                    return;
                case 11099:
                    gameHT = false;
                    this.gameAA((int) 3, (Item) arritemup);
                    return;
                case 11100:
                    gameFN();
                    return;
                case 11101:
                    var21 = gameAN(10);
                    this.gameAA((int) 3, (Item) var21);
                    return;
                case 11102:
                    this.gameFI();
                    return;
                case 11103:
                    this.gameFH();
                    return;
                case 11104:
                    this.gameAA((int) 3, (Item) ((Item) var2));
                    return;
                case 11105:
                    gameDS();
                    return;
                case 11106:
                    this.gameFG();
                    return;
                case 11107:
                    gameFF();
                    return;
                case 11108:
                    this.gameAD((byte) 3);
                    return;
                case 11109:
                    this.gameFC();
                    return;
                case 11110:
                    var21 = gameCX[gameBM];
                    this.gameAA((int) 30, (Item) var21);
                    return;
                case 11111:
                    var21 = gameAN(4);
                    this.gameAA((int) 4, (Item) var21);
                    return;
                case 11112:
                    Service.gI().gameAG();
                    return;
                case 11113:
                    Service.gI().gameAE(Char.getMyChar().arrItemBag[gameBM].indexUI);
                    return;
                case 11114:
                    this.gameAA((int) 3, (Item) Char.getMyChar().arrItemBag[gameBM]);
                    return;
                case 11115:
                    gameFA();
                    return;
                case 11116:
                    gameEZ();
                    return;
                case 11120:
                    var23 = (Skill) (var26 = (Object[]) var2)[0];
                    var1 = Integer.parseInt((String) var26[1]);
                    gamePB[var1] = var23;
                    gameBQ();
                    return;
                case 11121:
                    var23 = (Skill) (var26 = (Object[]) var2)[0];
                    var1 = Integer.parseInt((String) var26[1]);
                    gamePA[var1] = var23;
                    gameBR();
                    return;
                case 12000:
                    this.gameGL();
                    return;
                case 12001:
                    ChatManager.gameAD().gameAA(((Integer) var2).intValue());
                    this.gameGJ();
                    return;
                case 12002:
                case 12004:
                    var15 = (String) var2;
                    ChatTab var22;
                    if ((var22 = ChatManager.gameAD().gameAA(var15)) == null) {
                        ChatManager.gameAD().gameAB(var15);
                        ChatManager.gameAD().gameAC();
                    } else {
                        ChatManager.gameAD().gameAA(var22);
                    }

                    this.gameGJ();
                    gameKA = false;
                    gameMH = false;
                    gameKC = false;
                    gameDJ = false;
                    gameHZ = false;
                    ChatTextField.gameAA().gameAF = null;
                    return;
                case 12003:
                    this.gameCK();
                    return;
                case 12005:
                    gameGK();
                    return;
                case 12006:
                    gameGH();
                    return;
                case 12007:
                    this.gameTT = 1;
                    this.gameTU = "";
                    this.gameEF();
                    return;
                case 12008:
                    gameEE();
                    return;
                case 12009:
                    var15 = (String) var2;
                    (var18 = new MyVector()).addElement(new Command(mResources.gameSG[7], 12002, var15));
                    var18.addElement(new Command(mResources.gameTC[2], 110803, var15));
                    if (gameHZ) {
                        var18.addElement(new Command(mResources.gameSG[6], 110804));
                    }

                    if (isPaintMessage) {
                        var18.addElement(new Command(mResources.gameBK, 14020, var15));
                        var18.addElement(new Command(mResources.gameSG[6], 1108041, var15));
                    }

                    GameCanvas.menu.gameAA(var18);
                    return;
                case 13001:
                    this.gameAD((byte) 32);
                    return;
                case 13002:
                    gameHV();
                    return;
                case 14001:
                    gameFW();
                    return;
                case 14002:
                    this.gameEV();
                    return;
                case 14003:
                    this.gameEW();
                    return;
                case 14004:
                    gameEM();
                    return;
                case 14005:
                    gameER();
                    return;
                case 14006:
                    gameAD((String) var2);
                    return;
                case 14007:
                    gameEG();
                    return;
                case 14008:
                    GameCanvas.gameAA(mResources.gamePK, new Command(mResources.YES, 140081), new Command(mResources.NO, 1));
                    return;
                case 14009:
                    gameEP();
                    return;
                case 14010:
                    GameCanvas.inputDlg.gameAA(mResources.gameUN, new Command(mResources.ACCEPT, GameCanvas.instance, 88833, (Object) null), 1);
                    return;
                case 14011:
                    gameDG = false;
                    return;
                case 14012:
                    this.gameFJ();
                    return;
                case 14013:
                    this.gameFO();
                    return;
                case 14014:
                    this.gameHF();
                    return;
                case 14015:
                    this.gameFL();
                    return;
                case 14016:
                    this.gameAA((int) 3, (Item) gameCY[gameBM]);
                    return;
                case 14017:
                    gameEH();
                    return;
                case 14018:
                    this.gameAD((byte) 34);
                    return;
                case 14019:
                    gameED();
                    return;
                case 14020:
                    if (gameES()) {
                        var15 = (String) var2;
                        Service.gI().gameAA((short) 1, (String) var15);
                        return;
                    }

                    GameCanvas.gameAA(mResources.gameUA);
                    return;
                case 14021:
                    gameFY();
                    return;
                case 14022:
                    gameHS();
                    return;
                case 14023:
                    this.gameAD((byte) 35);
                    return;
                case 14024:
                    this.gameAA((byte) 1);
                    return;
                case 14025:
                    this.gameAA((byte) 0);
                    return;
                case 15001:
                    this.gameEB();
                    return;
                case 15002:
                    try {
                        if ((var1 = Integer.parseInt(this.gameNE.gameAD())) <= 0) {
                            GameCanvas.gameAA(mResources.gameVE);
                        }

                        GameCanvas.gameAA(mResources.gameAA(mResources.gameVM, NinjaUtil.gameAA(String.valueOf(var1))), new Command(mResources.YES, 150021), new Command(mResources.NO, 1));
                        return;
                    } catch (Exception var11) {
                        GameCanvas.gameAA(mResources.gameVE);
                        return;
                    }
                case 15041:
                    gameDZ();
                    return;
                case 15042:
                    GameCanvas.gameAA(mResources.gameAA(mResources.gameVN, NinjaUtil.gameAA(String.valueOf(arrItemStands[gameBM].price))), new Command(mResources.YES, 150421), new Command(mResources.NO, 1));
                    return;
                case 15081:
                    Service.gI().gameBI();
                    return;
                case 15082:
                    GameCanvas.inputDlg.gameAA(mResources.gameWC, new Command(mResources.OK, GameCanvas.instance, 88843, new Integer(gameBM)), 0);
                    return;
                case 15130:
                    Char.CapFood = 1;
                    return;
                case 15131:
                    Char.CapFood = 10;
                    return;
                case 15132:
                    Char.CapFood = 20;
                    return;
                case 15133:
                    Char.CapFood = 30;
                    return;
                case 15134:
                    Char.CapFood = 40;
                    return;
                case 15135:
                    Char.CapFood = 50;
                    return;
                case 15136:
                    Char.CapFood = 60;
                    return;
                case 15137:
                    Char.CapFood = 70;
                    return;
                case 15140:
                    Char.CapTrangBi = 1;
                    return;
                case 15141:
                    Char.CapTrangBi = 10;
                    return;
                case 15142:
                    Char.CapTrangBi = 20;
                    return;
                case 15143:
                    Char.CapTrangBi = 30;
                    return;
                case 15144:
                    Char.CapTrangBi = 40;
                    return;
                case 15145:
                    Char.CapTrangBi = 50;
                    return;
                case 15146:
                    Char.CapTrangBi = 60;
                    return;
                case 15147:
                    Char.CapTrangBi = 70;
                    return;
                case 15150:
                    Char.CapHpMp = 1;
                    return;
                case 15151:
                    Char.CapHpMp = 10;
                    return;
                case 15153:
                    Char.CapHpMp = 30;
                    return;
                case 15155:
                    Char.CapHpMp = 50;
                    return;
                case 15157:
                    Char.CapHpMp = 70;
                    return;
                case 15161:
                    Char.CapNhatDa = 1;
                    return;
                case 15162:
                    Char.CapNhatDa = 2;
                    return;
                case 15163:
                    Char.CapNhatDa = 3;
                    return;
                case 15164:
                    Char.CapNhatDa = 4;
                    return;
                case 15165:
                    Char.CapNhatDa = 5;
                    return;
                case 15166:
                    Char.CapNhatDa = 6;
                    return;
                case 15167:
                    Char.CapNhatDa = 7;
                    return;
                case 15174:
                    Char.LuyenDaMax = 4;
                    return;
                case 15175:
                    Char.LuyenDaMax = 5;
                    return;
                case 15176:
                    Char.LuyenDaMax = 6;
                    return;
                case 15177:
                    Char.LuyenDaMax = 7;
                    return;
                case 15178:
                    Char.LuyenDaMax = 8;
                    return;
                case 15179:
                    Char.LuyenDaMax = 9;
                    return;
                case 110001:
                    this.gameCC();
                    return;
                case 110002:
                    gameCM();
                    return;
                case 110003:
                    gameCE();
                    return;
                case 110004:
                    gameGZ();
                    return;
                case 110005:
                    this.gameAD((int) 14);
                    return;
                case 110006:
                    gameGV();
                    return;
                case 110007:
                    this.gameAD((int) 7);
                    return;
                case 110008:
                    this.gameAD((int) 6);
                    return;
                case 110009:
                    this.gameAD((int) 9);
                    return;
                case 110010:
                    this.gameAD((int) 8);
                    return;
                case 110011:
                    this.gameAD((int) 10);
                    return;
                case 110012:
                    this.gameAD((int) 11);
                    return;
                case 110013:
                    this.gameAD((int) 12);
                    return;
                case 110014:
                    if ((var24 = gameAI(5)) != null && (Math.abs(var24.cx - Char.getMyChar().cx) > 22 || Math.abs(var24.cy - Char.getMyChar().cy) > 22)) {
                        Char.gameAC(var24.cx, var24.cy);
                    }

                    this.gameAD((int) 4);
                    return;
                case 110015:
                    this.gameAD((int) 13);
                    return;
                case 110016:
                    if ((var24 = gameAI(13)) != null && var24.statusMe != 15) {
                        if (Math.abs(var24.cx - Char.getMyChar().cx) > 22 || Math.abs(var24.cy - Char.getMyChar().cy) > 22) {
                            Char.gameAC(var24.cx, var24.cy);
                        }

                        Service.gI().gameAE();
                        return;
                    }

                    if ((var1 = Char.gameAI(37)) < 0) {
                        var1 = Char.gameAI(35);
                    }

                    if (var1 >= 0) {
                        this.gameNA = var1;
                        Service.gI().gameAE();
                    }

                    return;
                case 110017:
                    this.gameAT();
                    return;
                case 110018:
                    gameGI();
                    return;
                case 110019:
                    this.gameEX();
                    return;
                case 110020:
                    Code.gameAN();
                    return;
                case 110021:
                    gameCD();
                    return;
                case 110022:
                    mResources.gameAA();
                    return;
                case 110051:
                    gameAB((byte) 25);
                    return;
                case 110052:
                    gameAC((byte) 25);
                    return;
                case 110081:
                    gameAB((byte) 24);
                    return;
                case 110082:
                    gameAC((byte) 24);
                    return;
                case 110101:
                    gameAB((byte) 23);
                    return;
                case 110102:
                    gameAC((byte) 23);
                    return;
                case 110121:
                    gameAB((byte) 22);
                    return;
                case 110122:
                    gameAC((byte) 22);
                    return;
                case 110141:
                    gameAB((byte) 21);
                    return;
                case 110142:
                    gameAC((byte) 21);
                    return;
                case 110161:
                    gameAB((byte) 20);
                    return;
                case 110162:
                    gameAC((byte) 20);
                    return;
                case 110181:
                    gameAB((byte) 15);
                    return;
                case 110182:
                    gameAC((byte) 15);
                    return;
                case 110201:
                    gameAB((byte) 14);
                    return;
                case 110202:
                    gameAC((byte) 14);
                    return;
                case 110221:
                    gameHB();
                    return;
                case 110244:
                    gameHO();
                    return;
                case 110261:
                    gameHN();
                    return;
                case 110262:
                    if ((var21 = gameAN(3)) != null) {
                        Code.gameAB((int) var21.template.id);
                    }

                    return;
                case 110263:
                    if ((var21 = gameAN(3)) != null) {
                        Code.gameAC((int) var21.template.id);
                    }

                    return;
                case 110264:
                    if ((var21 = gameAN(3)) != null) {
                        Code.gameAB(var21);
                    }

                    return;
                case 110265:
                    if ((var21 = gameAN(3)) != null) {
                        Code.gameAC(var21);
                    }

                    return;
                case 110266:
                    GameCanvas.inputDlg.gameAA("Giá bán", new Command("Đặt", 110268), 1);
                    GameCanvas.inputDlg.tfInput.gameAA("5000");
                    return;
                case 110267:
                    if ((var21 = gameAN(3)) != null) {
                        Code.gameAF(var21.template.id);
                    }

                    return;
                case 110268:
                    if ((var21 = gameAN(3)) != null) {
                        var16 = 5000;

                        try {
                            var16 = Integer.parseInt(GameCanvas.inputDlg.tfInput.gameAD());
                        } catch (Exception var10) {
                        }

                        if (var16 < 5000) {
                            gameAC("Giá > 5000k");
                        } else {
                            Code.gameAB(var21.template.id, var16);
                        }
                    }

                    GameCanvas.endDlg();
                    return;
                case 110361:
                    this.gameGS();
                    return;
                case 110382:
                    Service.gI().gameAK();
                    return;
                case 110383:
                    Service.gI().gameAL();
                    return;
                case 110391:
                    this.gameAQ(1);
                    return;
                case 110392:
                    this.gameAQ(2);
                    return;
                case 110393:
                    this.gameAQ(3);
                    return;
                case 110394:
                    this.gameAQ(4);
                    return;
                case 110395:
                    this.gameAQ(5);
                    return;
                case 110396:
                    this.gameAQ(6);
                    return;
                case 110397:
                    this.gameAQ(7);
                    return;
                case 110398:
                    this.gameAQ(8);
                    return;
                case 110399:
                    this.gameAQ(9);
                    return;
                case 110441:
                    this.gameCA();
                    return;
                case 110451:
                    gameGQ();
                    return;
                case 110452:
                    gameGP();
                    return;
                case 110471:
                    gameGO();
                    return;
                case 110531:
                    var21 = (Item) var2;
                    Service.gI().gameAI(var21.indexUI, GameCanvas.menu.menuSelectedItem + 3);
                    return;
                case 110561:
                    GameCanvas.endDlg();
                    this.gameBB();
                    return;
                case 110562:
                    gameAE((Item) var2);
                    return;
                case 110701:
                    Service.gI().gameAT();
                    return;
                case 110702:
                    Service.gI().gameAA(true);
                    return;
                case 110703:
                    Service.gI().gameAA(false);
                    return;
                case 110721:
                    Service.gI().gameAG(gameBM, 1);
                    return;
                case 110722:
                    gameAB(Char.getMyChar().arrItemBag[gameBM]);
                    return;
                case 110723:
                    Service.gI().gameAG(gameBM, Char.getMyChar().arrItemBag[gameBM].quantity);
                    return;
                case 110771:
                    var15 = (String) var2;
                    GameCanvas.endDlg();
                    Service.gI().gameAG(var15);
                    return;
                case 110791:
                    var15 = (String) var2;
                    Service.gI().gameAF(var15);
                    return;
                case 110792:
                    gameAF((String) var2);
                    return;
                case 110801:
                    Service.gI().gameBB(indexRow);
                    return;
                case 110802:
                    Service.gI().gameBA(indexRow);
                    return;
                case 110803:
                    var15 = (String) var2;
                    Service.gI().gameAE(var15);
                    return;
                case 110804:
                    gameEY();
                    return;
                case 110805:
                    gameEQ();
                    return;
                case 110811:
                    gameAB(Char.getMyChar().nClass.skillTemplates[gameBM]);
                    return;
                case 110812:
                    gameAA(Char.getMyChar().nClass.skillTemplates[gameBM]);
                    return;
                case 110821:
                    Service.gI().gameAB(gameBM + indextabTrangbi);
                    return;
                case 110841:
                    Service.gI().gameAE(gameHQ - 1, 1);
                    this.gameBI();
                    return;
                case 110842:
                    this.gameBY();
                    return;
                case 110851:
                    var21 = (Item) var2;
                    Service.gI().gameAA(var21.typeUI, var21.indexUI, 1);
                    return;
                case 110852:
                    gameAA((Item) var2);
                    return;
                case 110854:
                    gameFQ();
                    return;
                case 110921:
                    var21 = (Item) var2;
                    Service.gI().gameAA(var21.typeUI, var21.indexUI, 1);
                    return;
                case 110922:
                    gameAA((Item) var2);
                    return;
                case 110923:
                    this.gameAD((byte) 16);
                    return;
                case 110924:
                    this.gameAD((byte) 17);
                    return;
                case 110925:
                    this.gameAD((byte) 18);
                    return;
                case 110926:
                    this.gameAD((byte) 19);
                    return;
                case 110981:
                    gameDR();
                    return;
                case 110991:
                    gameHT = true;
                    this.gameAA((int) 3, (Item) arritemup);
                    return;
                case 111001:
                    this.gameFM();
                    return;
                case 111031:
                    if (gameMM) {
                        Service.gI().gameAB(gameDD, gameCV);
                        return;
                    }

                    if (gameMN) {
                        Service.gI().gameAD(gameDD, gameCV);
                        return;
                    }

                    if (gameMO) {
                        Service.gI().gameAA((byte) 1, (Item) null, gameDD, gameCV);
                        return;
                    }

                    if (gameMQ) {
                        Service.gI().gameAA((byte) 2, (Item) null, gameDD, (Item[]) null);
                        return;
                    }

                    if (gameMR) {
                        Service.gI().gameAA((byte) 3, (Item) null, gameDD, (Item[]) null);
                        return;
                    }
                    break;
                case 111071:
                    this.gameFD();
                    return;
                case 111101:
                    var21 = gameAN(4);
                    Service.gI().gameAD(var21.indexUI);
                    return;
                case 120051:
                    ChatTab var25 = (ChatTab) var2;
                    ChatManager.gameAD().chatTabs.removeElement(var25);
                    if (ChatManager.gameAD().currentTabIndex > ChatManager.gameAD().chatTabs.size() - 1) {
                        ChatManager.gameAD().gameAB();
                    }

                    if (ChatManager.gameAD().gameAE() != null) {
                        this.gameGJ();
                        return;
                    }

                    ChatTextField.gameAA().isShow = false;
                    this.gameAU();
                    return;
                case 120061:
                    ChatManager.blockGlobalChat = !ChatManager.blockGlobalChat;
                    GameCanvas.gameAA(mResources.gameTR + (ChatManager.blockGlobalChat ? mResources.gameBY : mResources.gameBZ));
                    return;
                case 120062:
                    ChatManager.blockPrivateChat = !ChatManager.blockPrivateChat;
                    GameCanvas.gameAA(mResources.gameTS + (ChatManager.blockPrivateChat ? mResources.gameBY : mResources.gameBZ));
                    return;
                case 120071:
                    this.gameTT = 2;
                    if (GameCanvas.gameBL.tfInput.gameAD().equals("")) {
                        GameCanvas.gameAA(mResources.gameNV);
                        return;
                    }

                    if (GameCanvas.gameBL.tfInput2.gameAD().equals("")) {
                        GameCanvas.gameAA(mResources.gameNW);
                        return;
                    }

                    this.gameTU = "Loại thẻ: " + GameCanvas.gameBL.tfInput.gameAD();
                    this.gameTU = this.gameTU + ", Mệnh giá: " + GameCanvas.gameBL.tfInput2.gameAD();
                    GameCanvas.endDlg();
                    this.gameEF();
                    return;
                case 120072:
                    if (GameCanvas.gameBL.tfInput.gameAD().equals("")) {
                        GameCanvas.gameAA(mResources.gameNX);
                        return;
                    }

                    if (GameCanvas.gameBL.tfInput2.gameAD().equals("")) {
                        GameCanvas.gameAA(mResources.gameNY);
                        return;
                    }

                    this.gameTU = this.gameTU + ", Số seri: " + GameCanvas.gameBL.tfInput.gameAD();
                    this.gameTU = this.gameTU + ", Khoảng thời gian nạp: " + GameCanvas.gameBL.tfInput2.gameAD();
                    Service.gI().gameAD(this.gameTU);
                    GameCanvas.endDlg();
                    return;
                case 120081:
                    GameCanvas.inputDlg.tfInput.gameAB(11);
                    GameCanvas.inputDlg.gameAA(mResources.gameUD, new Command("OK", (IActionListener) null, 120082, (Object) null), 1);
                    return;
                case 120082:
                    if ((var15 = GameCanvas.inputDlg.tfInput.gameAD()).equals("")) {
                        GameCanvas.gameAA(mResources.gameUE);
                        return;
                    }

                    Service.gI().gameAD("Số điện thoại đăng ký: ".concat(String.valueOf(var15)));
                    GameCanvas.endDlg();
                    return;
                case 130011:
                    var24 = (Npc) var2;
                    Service.gI().gameAJ(var24.template.npcTemplateId, 0);
                    var24.chatPopup = null;
                    this.gameAU();
                    return;
                case 130012:
                    ((Npc) var2).chatPopup = null;
                    this.gameAU();
                    return;
                case 130021:
                    gameAB((byte) 32);
                    return;
                case 130022:
                    gameAC((byte) 32);
                    return;
                case 140011:
                    Service.gI().gameAF(Char.getMyChar().nClass.skillTemplates[gameBM].id, 1);
                    this.gameBI();
                    return;
                case 140012:
                    this.gameBZ();
                    return;
                case 140041:
                    GameCanvas.inputDlg.tfInput.gameAB(180);
                    GameCanvas.inputDlg.gameAA(mResources.gameUL, new Command(mResources.ACCEPT, GameCanvas.instance, 88832, (Object) null), 0);
                    return;
                case 140042:
                    Service.gI().gameBB();
                    return;
                case 140043:
                    GameCanvas.inputDlg.gameAA(mResources.gameUM, new Command(mResources.ACCEPT, GameCanvas.instance, 88834, (Object) null), 0);
                    return;
                case 140044:
                    Service.gI().gameBE();
                    return;
                case 140071:
                    indexRow = 0;
                    gameBM = 0;
                    gameBU.gameAA();
                    gameHU = !gameHU;
                    gameAX();
                    return;
                case 140072:
                    indexRow = 0;
                    gameBM = 0;
                    gameBU.gameAA();
                    gameHV = !gameHV;
                    gameAX();
                    return;
                case 140081:
                    Service.gI().gameBA();
                    GameCanvas.endDlg();
                    return;
                case 140091:
                    Service.gI().gameAB(((Member) vClan.elementAt(indexRow)).gameAD, 3);
                    return;
                case 140092:
                    Service.gI().gameAB(((Member) vClan.elementAt(indexRow)).gameAD, 2);
                    return;
                case 140093:
                    GameCanvas.gameAA(mResources.gamePI, new Command(mResources.YES, 1400931), new Command(mResources.NO, 1));
                    return;
                case 140094:
                    GameCanvas.gameAA(mResources.gamePJ, new Command(mResources.YES, 1400941), new Command(mResources.NO, 1));
                    return;
                case 140095:
                    var14 = (Member) vClan.elementAt(indexRow);
                    Service.gI().gameAQ(var14.gameAD);
                    return;
                case 140096:
                    (var18 = new MyVector()).addElement(new Command(mResources.gameVZ, 1400961));
                    var18.addElement(new Command(mResources.gameWA, 1400962));
                    GameCanvas.menu.gameAA(var18);
                    return;
                case 140101:
                    (var21 = new Item()).template = ItemTemplates.gameAA((short) 0);
                    var21.expires = -1L;
                    this.gameAA((int) 39, (Item) var21);
                    return;
                case 140131:
                    GameCanvas.gameAA(mResources.gameQX, new Command(mResources.YES, 140132), new Command(mResources.NO, 1));
                    return;
                case 140132:
                    gameEL();
                    return;
                case 140151:
                    this.gameFK();
                    return;
                case 140161:
                    this.gameAA((int) 3, (Item) gameCY[2]);
                    return;
                case 140191:
                    gameAB((byte) 34);
                    return;
                case 140192:
                    gameAC((byte) 34);
                    return;
                case 140221:
                    gameAB((byte) 35);
                    return;
                case 140222:
                    gameAC((byte) 35);
                    return;
                case 150021:
                    GameCanvas.gameAM();
                    var1 = 0;

                    try {
                        var1 = Integer.parseInt(this.gameNE.gameAD());
                    } catch (Exception var9) {
                    }

                    Service.gI().gameAA(gameDE, var1);
                    return;
                case 150411:
                    this.gameMY = 0;
                    this.gameMZ = 0;
                    if (this.gameMX == 0) {
                        this.gameMX = 1;
                    } else if (this.gameMX == 1) {
                        this.gameMX = 2;
                    } else if (this.gameMX == 2) {
                        this.gameMX = 1;
                    }

                    this.gameDY();
                    return;
                case 150412:
                    this.gameMY = 0;
                    this.gameMX = 0;
                    if (this.gameMZ == 0) {
                        this.gameMZ = 1;
                    } else if (this.gameMZ == 1) {
                        this.gameMZ = 2;
                    } else if (this.gameMZ == 2) {
                        this.gameMZ = 1;
                    }

                    this.gameDY();
                    return;
                case 150413:
                    this.gameMX = 0;
                    this.gameMZ = 0;
                    if (this.gameMY == 0) {
                        this.gameMY = 1;
                    } else if (this.gameMY == 1) {
                        this.gameMY = 2;
                    } else if (this.gameMY == 2) {
                        this.gameMY = 1;
                    }

                    this.gameDY();
                    return;
                case 150421:
                    GameCanvas.endDlg();
                    Service.gI().gameBO(arrItemStands[gameBM].item.itemId);
                    return;
                case 151301:
                    Service.gI().gameBP(Char.getMyChar().mobFocus.getTemplate().mobTemplateId);
                    return;
                case 151710:
                    Char.LuyenDaMax = 10;
                    return;
                case 151711:
                    Char.LuyenDaMax = 11;
                    return;
                case 151712:
                    Char.LuyenDaMax = 12;
                    return;
                case 909090:
                    this.gameAD((int) 38);
                    return;
                case 1100011:
                    this.gameAH();
                    return;
                case 1100012:
                    this.gameBS();
                    return;
                case 1100013:
                    this.gameBT();
                    return;
                case 1100014:
                    this.gameBU();
                    return;
                case 1100015:
                    this.gameBV();
                    return;
                case 1100016:
                    this.gameBW();
                    return;
                case 1100032:
                    this.gameCG();
                    return;
                case 1100033:
                    gameEU();
                    return;
                case 1100034:
                    gameKF();
                    return;
                case 1100041:
                    gameGY();
                    return;
                case 1100061:
                    this.gameCH();
                    return;
                case 1100062:
                    this.gameCJ();
                    return;
                case 1100063:
                    this.gameCK();
                    return;
                case 1100064:
                    this.gameCL();
                    return;
                case 1100065:
                    gameGU();
                    return;
                case 1100067:
                    gameEJ();
                    return;
                case 1100068:
                    this.gameAD((int) 40);
                    return;
                case 1100069:
                    (var19 = new MyVector()).addElement(new Command("Tàn sát all", 1100070, (Object) null));

                    for (var16 = 0; var16 < gameVJ.size(); ++var16) {
                        var17 = (MobTemplate) gameVJ.elementAt(var16);
                        var19.addElement(new Command(var17.name, 1100070, var17));
                    }

                    GameCanvas.menu.gameAA(var19);
                    return;
                case 1100070:
                    Code.gameAA((var17 = (MobTemplate) var2) != null ? var17.mobTemplateId : -1, TileMap.mapID);
                    return;
                case 1100071:
                    MyVector var3 = new MyVector();
                    var19 = new MyVector();

                    for (var16 = 0; var16 < vNpc.size(); ++var16) {
                        var4 = (Npc) vNpc.elementAt(var16);
                        if (!var19.contains(var4.template)) {
                            var19.addElement(var4.template);
                            var3.addElement(new Command(var4.template.name, 1100072, var4));
                        }
                    }

                    GameCanvas.menu.gameAA(var3);
                    return;
                case 1100072:
                    if ((var4 = (Npc) var2) != null) {
                        if (Math.abs(var4.cx - Char.getMyChar().cx) > 22) {
                            Char.gameAC(var4.cx, var4.cy);
                        }

                        Service.gI().gameAH(var4.template.npcTemplateId);
                    }

                    return;
                case 1100073:
                    Code.gameAF();
                    return;
                case 1100074:
                    Code.gameAD();
                    return;
                case 1100075:
                    Code.gameAE();
                    return;
                case 1100076:
                    super.right = this.gameSA;
                    gameBP = 0;
                    gameVH = true;
                    setSize(175, 200);
                    return;
                case 1100077:
                    Code.gameAB(Code.nhat[gameBM]);
                    return;
                case 1100078:
                    Code.gameAL();
                    return;
                case 1100079:
                    Code.gameAA(Char.getMyChar().arrItemBag[gameBM].template.id);
                    return;
                case 1100080:
                    Code.gameAQ = !Code.gameAQ;
                    return;
                case 1100081:
                    GameCanvas.inputDlg.gameAA("KC Nhặt", new Command("Đặt", 1100085), 1);
                    GameCanvas.inputDlg.tfInput.gameAA(String.valueOf(Code.gameAM));
                    return;
                case 1100082:
                    GameCanvas.inputDlg.gameAA("KC Tàn sát", new Command("Đặt", 1100086), 1);
                    GameCanvas.inputDlg.tfInput.gameAA(String.valueOf(Code.gameAN));
                    return;
                case 1100083:
                    Code.gameAR = !Code.gameAR;
                    return;
                case 1100084:
                    Code.gameAY = !Code.gameAY;
                    return;
                case 1100085:
                    try {
                        Code.gameAM = Integer.parseInt(GameCanvas.inputDlg.tfInput.gameAD());
                    } catch (Exception var8) {
                    }

                    GameCanvas.endDlg();
                    return;
                case 1100086:
                    try {
                        Code.gameAN = Integer.parseInt(GameCanvas.inputDlg.tfInput.gameAD());
                    } catch (Exception var7) {
                    }

                    GameCanvas.endDlg();
                    return;
                case 1100087:
                    GameCanvas.inputDlg.gameAA("Độ Trễ", new Command("Đặt", 1100088), 1);
                    GameCanvas.inputDlg.tfInput.gameAA(String.valueOf(Char.speedGame));
                    return;
                case 1100088:
                    int varSpeed = Char.speedGame;

                    try {
                        varSpeed = Integer.parseInt(GameCanvas.inputDlg.tfInput.gameAD());
                    } catch (Exception var6) {
                    }

                    if (varSpeed >= 0 && varSpeed < 100) {
                        Char.speedGame = varSpeed;
                    } else {
                        gameAC("Tốc độ game từ 0 đến 99");
                    }

                    GameCanvas.endDlg();
                    return;
                case 1100089:
                    if (Code.gameAV = !Code.gameAV) {
                        GameCanvas.inputDlg.gameAA("Khu-Mỗi khu cách nhau bằng dấu cách", new Command("Đặt", 1100090), 0);
                        GameCanvas.inputDlg.tfInput.gameAA(Code.gameAK());
                    }

                    return;
                case 1100090:
                    Code.gameAE(GameCanvas.inputDlg.tfInput.gameAD());
                    GameCanvas.endDlg();
                    return;
                case 1100091:
                    InfoDlg.gameAD();
                    gameDI = true;
                    this.gameNB = true;
                    indexRow = 0;
                    setSize(175, 200);
                    super.right = new Command(mResources.CLOSE, 3);
                    super.left = super.center = null;
                    this.gameND = "Danh sách mua bán";
                    this.gameNC = ChatSell.gameAA();
                    return;
                case 1100092:
                    InfoDlg.gameAD();
                    gameDI = true;
                    this.gameNB = true;
                    indexRow = 0;
                    setSize(175, 200);
                    super.right = new Command(mResources.CLOSE, 3);
                    super.left = super.center = null;
                    this.gameND = "Danh sách shinwa";
                    this.gameNC = Code.gameAI();
                    return;
                case 1100093:
                    InfoDlg.gameAD();
                    gameDI = true;
                    this.gameNB = true;
                    indexRow = 0;
                    setSize(175, 200);
                    super.right = new Command(mResources.CLOSE, 3);
                    super.left = super.center = null;
                    this.gameND = "Danh sách PK";
                    this.gameNC = SavePk.gameAA();
                    return;
                case 1100094:
                    InfoDlg.gameAD();
                    gameDI = true;
                    this.gameNB = true;
                    indexRow = 0;
                    setSize(175, 200);
                    super.right = new Command(mResources.CLOSE, 3);
                    super.left = super.center = null;
                    this.gameND = "Danh sách HS";
                    this.gameNC = Code.gameAG();
                    return;
                case 1100181:
                    GameCanvas.gameAA(mResources.gameAK, new Command(mResources.COUNTINUE, 1100182), new Command(mResources.NO, GameCanvas.instance, 8882, (Object) null));
                    return;
                case 1100182:
                    GameCanvas.currentDialog = null;
                    GameCanvas.loginScr.gameAE();
                    return;
                case 1102211:
                    try {
                        GameCanvas.inputDlg.gameAA("Đặt giá" + (gameAN(3) != null ? " " + gameAN(3).template.name : ""), new Command("Đặt", 1102212), 1);
                        GameCanvas.inputDlg.tfInput.gameAA(ChatSell.gameAA(gameAN(3).template.id).gameAD());
                        return;
                    } catch (Exception var5) {
                        return;
                    }
                case 1102212:
                    if (gameAN(3) != null) {
                        ChatSell.gameAA(gameAN(3).template, GameCanvas.inputDlg.tfInput.gameAD());
                    }

                    GameCanvas.endDlg();
                    return;
                case 1102213:
                    if (gameAN(3) != null) {
                        ChatSell.gameAA(gameAN(3).template);
                    }

                    return;
                case 1103991:
                    this.gameAQ(10);
                    return;
                case 1107921:
                    var15 = (String) var2;
                    GameCanvas.endDlg();
                    Service.gI().gameAG(var15);
                    gameAB(var15);
                    return;
                case 1107931:
                    var15 = (String) var2;
                    Service.gI().gameAE(var15);
                    return;
                case 1107932:
                    gameAB((String) var2);
                    return;
                case 1108041:
                    var15 = (String) var2;
                    Service.gI().gameAJ(var15);
                    gI().gameAU();
                    return;
                case 1400931:
                    Service.gI().gameAB(((Member) vClan.elementAt(indexRow)).gameAD, 0);
                    GameCanvas.endDlg();
                    return;
                case 1400941:
                    Service.gI().gameAP(((Member) vClan.elementAt(indexRow)).gameAD);
                    GameCanvas.endDlg();
                    return;
                case 1400961:
                    var14 = (Member) vClan.elementAt(indexRow);
                    Service.gI().gameAR(var14.gameAD);
                    return;
                case 1400962:
                    Service.gI().gameBD();
                    return;
                case 11000601:
                    this.gameAD((int) 36);
                    return;
                case 11000602:
                    this.gameAD((int) 43);
                    return;
                case 11000603:
                    this.gameAD((int) 44);
                    return;
                case 11000604:
                    this.gameAD((int) 45);
                    return;
                case 11000651:
                    gameAP(1);
                    return;
                case 11000652:
                    gameAP(2);
                    return;
                case 11000653:
                    gameAP(3);
                    return;
                case 11000661:
                    gameBP = 0;
                    this.gameET();
                    return;
                case 11000662:
                    gameBP = 1;
                    this.gameET();
                    Service.gI().gameAX();
                    return;
                case 11000663:
                    gameBP = 2;
                    this.gameET();
                    Service.gI().gameAY();
                    return;
                case 11000664:
                    gameBP = 3;
                    this.gameET();
                    Service.gI().gameAZ();
                    return;
                case 11000665:
                    if (gameDF = !gameDF) {
                        RMS.gameAA(Char.getMyChar().cName + "vci", 1);
                        return;
                    }

                    RMS.gameAA(Char.getMyChar().cName + "vci", 0);
                    return;
                case 11000666:
                    gameBP = 4;
                    this.gameET();
                    Service.gI().gameAY();
                    return;
                case 11000671:
                    GameCanvas.gameAA(mResources.gameUB, 88836, (Object) null, 8882, (Object) null);
                    return;
                case 11000672:
                    GameCanvas.inputDlg.tfInput.gameAB(6);
                    GameCanvas.inputDlg.gameAA(mResources.gameUC, new Command(mResources.ACCEPT, GameCanvas.instance, 88837, (Object) null), 1);
                    return;
                case 11000673:
                    GameCanvas.gameBL.gameAA(mResources.gameUI, mResources.gameUJ);
                    GameCanvas.gameBL.tfInput.gameAB(6);
                    GameCanvas.gameBL.tfInput2.gameAB(6);
                    GameCanvas.gameBL.gameAA(mResources.gameUC, new Command(mResources.CLOSE, GameCanvas.instance, 8882, (Object) null), new Command(mResources.ACCEPT, GameCanvas.instance, 88838, (Object) null), 1, 1);
                    return;
                case 11000674:
                    GameCanvas.inputDlg.tfInput.gameAB(6);
                    GameCanvas.inputDlg.gameAA(mResources.gameUC, new Command(mResources.ACCEPT, GameCanvas.instance, 88839, (Object) null), 1);
                    return;
                case 11000761:
                    super.right = this.gameSA;
                    gameBP = 0;
                    itemDell = true;
                    setSize(175, 200);
                    return;
                case 11000771:
                    Code.gameAD(Code.dell[gameBM]);
                    return;
                case 11000781:
                    Code.gameAM();
                    return;
                case 11000791:
                    Code.gameAC(Char.getMyChar().arrItemBag[gameBM].template.id);
                    return;

                case 11000792:
                    super.right = this.gameSA;
                    gameBP = 0;
                    itemThow = true;
                    setSize(175, 200);
                    return;
                case 11000793:
                    Code.thowAD(Code.thow[gameBM]);
                    return;
                case 11000794:
                    Code.thowAM();
                    return;
                case 11000795:
                    Code.thowAC(Char.getMyChar().arrItemBag[gameBM].template.id);
                    return;

                case 11000800:
                    GameCanvas.inputDlg.gameAA("Nhập số phiếu cần lật", new Command("OK", 11000801), 1);
                    return;
                case 11000801:
                    LatHinh.lap = Integer.parseInt(GameCanvas.inputDlg.tfInput.gameAD());
                    (new Thread(new LatHinh(LatHinh.lap))).start();
                    gameAC("Auto Lật " + LatHinh.lap + " Phiếu");
                    GameCanvas.endDlg();
                    return;
                case 11000802:
                    GameCanvas.inputDlg.gameAA("Tốc Độ Lật Hình", new Command("OK", 11000803), 1);
                    return;
                case 11000803:
                    LatHinh.time = (long) Integer.parseInt(GameCanvas.inputDlg.tfInput.gameAD());
                    gameAC("Tốc độ lật hình của bạn là:" + LatHinh.time);
                    GameCanvas.endDlg();
                    return;
                case 11000804:
                    lathinh();
                    return;
                case 11000805:
                    caidat();
                    return;
                case 11000806:
                    (new SetAuto()).select();
                    return;
                case 11000807:
                    new SetGomDo().gameAA();
                    return;
                case 11000808:
                    new Thread(new DichChuyen(gameAN(3))).start();
                    return;
                case 11000809:
                    new FormDanhVong().select();
                    return;
            }

        }
    }

    public static void lathinh() {
        MyVector var0 = new MyVector();
        var0.addElement(new Command("Lật Hình", 11000800));
        var0.addElement(new Command("Set Time Lật", 11000802));
        GameCanvas.menu.gameAA(var0);
    }

    public static void caidat() {
        MyVector var0 = new MyVector();
        var0.addElement(new Command("Cài đặt chung", 11000806));
        var0.addElement(new Command("Cài Danh Vọng", 11000809));
        var0.addElement(new Command("Cài Gom", 11000807));
        var0.addElement(new Command("Lật Hình", 11000804));
        GameCanvas.menu.gameAA(var0);
    }

    private void gameDU() {
        try {
            if (Char.getMyChar().arrItemBag[gameBM].template.id == 454) {
                if (gameCV == null) {
                    gameCV = new Item[24];
                }

                for (int var1 = 0; var1 < gameCV.length; ++var1) {
                    if (var1 == 20) {
                        GameCanvas.gameAA(mResources.gameNS);
                        return;
                    }

                    if (gameCV[var1] == null) {
                        gameCV[var1] = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                        super.left = super.center = null;
                        this.gameBB();
                        return;
                    }
                }
            } else {
                if (Char.getMyChar().arrItemBag[gameBM].upgrade <= 11) {
                    GameCanvas.gameAA(mResources.gameWZ);
                    return;
                }

                if (gameDD == null) {
                    gameDD = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                } else {
                    Item var3 = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                    Char.getMyChar().arrItemBag[gameDD.indexUI] = gameDD;
                    gameDD = var3;
                }

                Service.gI().gameAC(gameDD.typeUI, gameDD.indexUI);
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void gameDV() {
        Item var1 = gameAN(44);
        gameCV[gameBM] = null;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        super.left = super.center = null;
        this.gameBB();
    }

    private static void gameDW() {
        switch (indexRow) {
            case 0:
                Char.DungHp = !Char.DungHp;
                if (gameFD == 1) {
                    Char.DungHp = false;
                    InfoMe.gameAA(mResources.gameWL, 20, mFont.tahoma_7_yellow);
                }

                return;
            case 1:
                Char.DungMp = !Char.DungMp;
                if (gameFD == 1) {
                    Char.DungMp = false;
                    InfoMe.gameAA(mResources.gameWL, 20, mFont.tahoma_7_yellow);
                }

                return;
            case 2:
                Char.DungFood = !Char.DungFood;
                if (gameFD == 1) {
                    Char.DungFood = false;
                    InfoMe.gameAA(mResources.gameWL, 20, mFont.tahoma_7_yellow);
                }

                return;
            case 3:
                Char.DungHoTro = !Char.DungHoTro;
                return;
            case 4:
                Char.KhienMana = !Char.KhienMana;
                return;
            case 5:
                Char.DotQuai = !Char.DotQuai;
                return;
            case 6:
                Char.DungPhanThan = !Char.DungPhanThan;
                return;
            case 7:
                if (Char.NhatYen = !Char.NhatYen) {
                    Char.KhongNhat = false;
                }

                return;
            case 8:
                if (Char.NhatHpMp = !Char.NhatHpMp) {
                    Char.KhongNhat = false;
                }

                return;
            case 9:
                if (Char.NhatDa = !Char.NhatDa) {
                    Char.KhongNhat = false;
                }

                return;
            case 10:
                Char.LuyenDa = !Char.LuyenDa;
                return;
            case 11:
                if (Char.NhatTrangBi = !Char.NhatTrangBi) {
                    Char.KhongNhat = false;
                }

                return;
            case 12:
                if (Char.NhatTbLa = !Char.NhatTbLa) {
                    Char.NhatTrangBi = true;
                    Char.KhongNhat = false;
                }

                return;
            case 13:
                if (Char.NhatVpNV = !Char.NhatVpNV) {
                    Char.KhongNhat = false;
                }

                return;
            case 14:
                if (Char.NhatVpSk = !Char.NhatVpSk) {
                    Char.KhongNhat = false;
                }

                return;
            case 15:
                if (Char.NhatAll = !Char.NhatAll) {
                    Char.KhongNhat = false;
                }

                return;
            case 16:
                if (Char.NhatSvc = !Char.NhatSvc) {
                    Char.KhongNhat = false;
                }

                return;
            case 17:
                if (Char.KhongNhat = !Char.KhongNhat) {
                    Char.NhatDa = false;
                    Char.NhatHpMp = false;
                    Char.NhatYen = false;
                    Char.NhatTrangBi = false;
                    Char.NhatTbLa = false;
                    Char.NhatVpNV = false;
                    Char.NhatVpSk = false;
                    Char.NhatAll = false;
                    Char.NhatSvc = false;
                }

                return;
            case 18:
                Char.LuyenTTT = !Char.LuyenTTT;
                return;
            case 19:
                Char.LuyenTTC = !Char.LuyenTTC;
                return;
            case 20:
                Char.ReMap = !Char.ReMap;
                return;
            case 21:
                Char.TsMapTrong = !Char.TsMapTrong;
                return;
            case 22:
                Char.AutoMuaFood = !Char.AutoMuaFood;
                return;
            case 23:
                Char.DieHetMp = !Char.DieHetMp;
                return;
            case 24:
                Char.ReConnect = !Char.ReConnect;
                return;
            case 25:
                Char.ChuyenMapHetQuai = !Char.ChuyenMapHetQuai;
                return;
            case 26:
                Char.SanTaTl = !Char.SanTaTl;
                return;
            case 27:
                Char.DanhQuai = !Char.DanhQuai;
                return;
            case 28:
                Char.DanhTA = !Char.DanhTA;
                return;
            case 29:
                Char.DanhTL = !Char.DanhTL;
                return;
            case 30:
                Char.CongTN = !Char.CongTN;
                return;
            case 31:
                Char.CongKN = !Char.CongKN;
                return;
            case 32:
                Char.DanhNhom = !Char.DanhNhom;
                return;
            case 33:
                Char.NePk = !Char.NePk;
                return;
            case 34:
                Char.DungCoLenh = !Char.DungCoLenh;
                return;
            case 35:
                Char.MuaCoLenh = !Char.MuaCoLenh;
                return;
            default:
        }
    }

    private void gameDX() {
        if (gameDA != null) {
            Item var1;
            (var1 = new Item()).template = ItemTemplates.gameAA(gameDA[gameBM]);
            this.gameAA((int) 38, (Item) var1);
        }

    }

    private void gameDY() {
        if (this.gameMY != 0 || this.gameMX != 0 || this.gameMZ != 0) {
            for (int var1 = 0; var1 < arrItemStands.length - 1; ++var1) {
                for (int var2 = var1 + 1; var2 < arrItemStands.length; ++var2) {
                    ItemStands var3;
                    if (this.gameMX == 1) {
                        if (arrItemStands[var1].price < arrItemStands[var2].price) {
                            var3 = arrItemStands[var1];
                            arrItemStands[var1] = arrItemStands[var2];
                            arrItemStands[var2] = var3;
                        }
                    } else if (this.gameMX == 2 && arrItemStands[var1].price > arrItemStands[var2].price) {
                        var3 = arrItemStands[var1];
                        arrItemStands[var1] = arrItemStands[var2];
                        arrItemStands[var2] = var3;
                    }

                    if (this.gameMZ == 1) {
                        if (!arrItemStands[var1].item.template.name.equals(arrItemStands[var2].item.template.name) && arrItemStands[var1].item.template.name.compareTo(arrItemStands[var2].item.template.name) > 0) {
                            var3 = arrItemStands[var1];
                            arrItemStands[var1] = arrItemStands[var2];
                            arrItemStands[var2] = var3;
                        }
                    } else if (this.gameMZ == 2 && !arrItemStands[var1].item.template.name.equals(arrItemStands[var2].item.template.name) && arrItemStands[var1].item.template.name.compareTo(arrItemStands[var2].item.template.name) < 0) {
                        var3 = arrItemStands[var1];
                        arrItemStands[var1] = arrItemStands[var2];
                        arrItemStands[var2] = var3;
                    }

                    if (this.gameMY == 1) {
                        if (arrItemStands[var1].item.template.level < arrItemStands[var2].item.template.level) {
                            var3 = arrItemStands[var1];
                            arrItemStands[var1] = arrItemStands[var2];
                            arrItemStands[var2] = var3;
                        }
                    } else if (this.gameMY == 2 && arrItemStands[var1].item.template.level > arrItemStands[var2].item.template.level) {
                        var3 = arrItemStands[var1];
                        arrItemStands[var1] = arrItemStands[var2];
                        arrItemStands[var2] = var3;
                    }
                }
            }
        }

    }

    private static void gameDZ() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameVG, 150411));
        var0.addElement(new Command(mResources.gameVI, 150412));
        var0.addElement(new Command(mResources.gameVH, 150413));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEA() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCL, 15041));
        var0.addElement(new Command(mResources.gameDA, 15042));
        GameCanvas.menu.gameAA(var0);
    }

    private void gameEB() {
        Char.getMyChar().arrItemBag[gameDE.indexUI] = gameDE;
        gameDE = null;
        super.left = super.center = null;
    }

    private static void gameEC() {
        Item var0;
        if ((var0 = Char.getMyChar().arrItemBag[gameBM]) != null) {
            if (!var0.isLock && !var0.isExpires) {
                if (gameDE == null) {
                    gameDE = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                    return;
                }

                var0 = Char.getMyChar().arrItemBag[gameBM];
                Char.getMyChar().arrItemBag[gameBM] = null;
                Char.getMyChar().arrItemBag[gameDE.indexUI] = gameDE;
                gameDE = var0;
                return;
            }

            GameCanvas.gameAA(mResources.gameNK);
        }

    }

    private static void gameED() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 140191));
        var0.addElement(new Command(mResources.gameDB, 140192));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEE() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCH, (IActionListener) null, 120081, (Object) null));
        var0.addElement(new Command(mResources.gameCI, (IActionListener) null, 12007, (Object) null));
        GameCanvas.menu.gameAA(var0);
    }

    private void gameEF() {
        if (this.gameTT == 1) {
            GameCanvas.gameBL.gameAA(mResources.gameUS, mResources.gameUR);
            GameCanvas.gameBL.gameAA(mResources.gameUO, new Command(mResources.CLOSE, GameCanvas.gameAB(), 8882, (Object) null), new Command(mResources.gameCJ, (IActionListener) null, 120071, (Object) null), 0, 0);
        } else {
            GameCanvas.gameBL.gameAA(mResources.gameUT, mResources.gameUU);
            GameCanvas.gameBL.gameAA(mResources.gameUP, new Command(mResources.CLOSE, GameCanvas.gameAB(), 8882, (Object) null), new Command(mResources.OK, (IActionListener) null, 120072, (Object) null), 0, 0);
        }
    }

    public static void gameAB(String var0) {
        int var1;
        for (var1 = 0; var1 < vFriend.size(); ++var1) {
            Friend var2;
            if ((var2 = (Friend) vFriend.elementAt(var1)).friendName.equals(var0) && var2.type == 4) {
                vFriend.removeElementAt(var1);
                break;
            }
        }

        for (var1 = 0; var1 < vFriendWait.size(); ++var1) {
            if (((Friend) vFriendWait.elementAt(var1)).friendName.equals(var0)) {
                vFriendWait.removeElementAt(var1);
                return;
            }
        }

    }

    private static void gameEG() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameTA[0] + ": " + (gameHU ? mResources.gameBZ : mResources.gameBY), 140071));
        var0.addElement(new Command(mResources.gameTB, 140072));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEH() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameTA[0] + ": " + (gameHU ? mResources.gameBZ : mResources.gameBY), 140071));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEI() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameTG, 110441));
        var0.addElement(new Command(mResources.gameTA[0] + ": " + (gameHU ? mResources.gameBZ : mResources.gameBY), 140071));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEJ() {
        MyVector var0 = new MyVector();
        if (gameFD == 0) {
            var0.addElement(new Command(mResources.gameCC, 11000671));
        } else if (gameFD == 1) {
            var0.addElement(new Command(mResources.gameBV, 11000672));
        }

        if (gameFD == 1 || gameFD == 2) {
            var0.addElement(new Command(mResources.gameUH, 11000674));
            var0.addElement(new Command(mResources.gameUG, 11000673));
        }

        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEK() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameSL, 110471));
        var0.addElement(new Command(mResources.gameSW[4], 1100061));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEL() {
        GameCanvas.endDlg();
        Service.gI().gameAD(gameCY[0].indexUI, gameCY[1].indexUI, gameCY[2].indexUI);
    }

    private static void gameEM() {
        MyVector var0 = new MyVector();
        if (Char.getMyChar().ctypeClan == 3 || Char.getMyChar().ctypeClan == 4) {
            if (gameHQ == 1) {
                var0.addElement(new Command(mResources.gameTA[8], 140044));
            }

            var0.addElement(new Command(mResources.gameTA[2], 140041));
            var0.addElement(new Command(mResources.gameTA[5], 140042));
            if (Char.getMyChar().ctypeClan == 4) {
                var0.addElement(new Command(mResources.gameTA[4], 140043));
            }

            var0.addElement(new Command(mResources.gameSG[10] + ": " + (gameDF ? mResources.gameBZ : mResources.gameBY), 11000665));
        }

        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEN() {
        Party var0;
        if ((var0 = (Party) vPtMap.elementAt(indexRow)) != null && !Char.getMyChar().cName.equals(var0.name)) {
            MyVector var1;
            (var1 = new MyVector()).addElement(new Command(mResources.gameSG[6], 1108041, var0.name));
            var1.addElement(new Command(mResources.CHAT, 12002, var0.name));
            var1.addElement(new Command(mResources.gameTC[2], 110803, var0.name));
            GameCanvas.menu.gameAA(var1);
        }

    }

    private static void gameEO() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameSR, 110452));
        if (vPtMap.size() > 0) {
            var0.addElement(new Command(mResources.gameSQ, 110451));
        }

        GameCanvas.menu.gameAA(var0);
    }

    private static void gameEP() {
        Member var0 = (Member) vClan.elementAt(indexRow);
        MyVector var1;
        (var1 = new MyVector()).addElement(new Command(mResources.gameSY[1], 140091, var0.gameAD));
        var1.addElement(new Command(mResources.gameSY[2], 140092, var0.gameAD));
        GameCanvas.menu.gameAA(var1);
    }

    private static void gameEQ() {
        Member var0;
        if (indexRow >= 0 && indexRow < vClan.size() && (var0 = gameCV()) != null && !var0.gameAD.equals("")) {
            Service.gI().gameAJ(var0.gameAD);
            gameMH = false;
            gI().gameAU();
        }

    }

    private static void gameER() {
        Member var0 = gameCV();
        MyVector var1 = new MyVector();
        if (Char.getMyChar().ctypeClan == 4) {
            if (var0.gameAC != 4) {
                if (var0.gameAC != 3 && var0.gameAC != 2) {
                    var1.addElement(new Command(mResources.gameTT, 14009, var0.gameAD));
                } else {
                    var1.addElement(new Command(mResources.gameTU, 140093, var0.gameAD));
                }

                if (TileMap.mapID != 98 && TileMap.mapID != 104) {
                    var1.addElement(new Command(mResources.gameTA[6], 140095, var0.gameAD));
                } else {
                    var1.addElement(new Command(mResources.gameTA[7], 140096, var0.gameAD));
                }

                var1.addElement(new Command(mResources.gameTV, 140094, var0.gameAD));
            }

            var1.addElement(new Command(mResources.gameCD, 14007));
        } else if (Char.getMyChar().ctypeClan == 3) {
            if (var0.gameAC != 4 && !var0.gameAD.equals(Char.getMyChar().cName)) {
                var1.addElement(new Command(mResources.gameTV, 140094, var0.gameAD));
                if (TileMap.mapID != 98 && TileMap.mapID != 104) {
                    var1.addElement(new Command(mResources.gameTA[6], 140095, var0.gameAD));
                } else {
                    var1.addElement(new Command(mResources.gameTA[7], 140096, var0.gameAD));
                }
            }

            var1.addElement(new Command(mResources.gameCD, 14007));
            var1.addElement(new Command(mResources.gameTA[1], 14008, var0.gameAD));
        } else {
            var1.addElement(new Command(mResources.gameCD, 14007));
            var1.addElement(new Command(mResources.gameTA[1], 14008, var0.gameAD));
        }

        GameCanvas.menu.gameAA(var1);
    }

    private static boolean gameES() {
        for (int var0 = 0; var0 < Char.getMyChar().arrItemBag.length; ++var0) {
            Item var1;
            if ((var1 = Char.getMyChar().arrItemBag[var0]) != null && var1.template.id == 279 && var1.template.level <= Char.getMyChar().clevel) {
                return true;
            }
        }

        return false;
    }

    private static void gameAD(String var0) {
        MyVector var1;
        (var1 = new MyVector()).addElement(new Command(mResources.gameSG[6], 110805));
        var1.addElement(new Command(mResources.CHAT, 12002, var0));
        var1.addElement(new Command(mResources.gameTF, 110791, var0));
        var1.addElement(new Command(mResources.gameBK, 14020, var0));
        var1.addElement(new Command(mResources.gameTC[2], 110803, var0));
        GameCanvas.menu.gameAA(var1);
    }

    private void gameET() {
        gameMH = true;
        gameMI = true;
        gameHV = false;
        this.gameRI = this.gameRJ = null;
        setSize(175, 200);
        this.gameBB();
        super.right = this.gameSA;
        Service.gI().gameAW();
    }

    private static void gameEU() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameRM[0], 11000661));
        var0.addElement(new Command(mResources.gameRM[1], 11000662));
        var0.addElement(new Command(mResources.gameRM[2], 11000663));
        var0.addElement(new Command(mResources.gameRM[3], 11000664));
        var0.addElement(new Command(mResources.gameRM[4], 11000666));
        GameCanvas.menu.gameAA(var0);
    }

    private void gameEV() {
        Char.getMyChar().charFocus = null;
        Char.gameHF = false;
        this.gameEH = -1;
        gameMF = false;
        this.gameAU();
    }

    private void gameEW() {
        Char var1;
        if (!(var1 = (Char) vCharInMap.elementAt(indexRow)).isNhanban) {
            this.gameEH = var1.charID;
            Char.getMyChar().mobFocus = null;
            Char.getMyChar().gameAY();
            Char.getMyChar().itemFocus = null;
            Char.getMyChar();
            Char.gameHF = true;
            gameMF = false;
            Char.getMyChar().charFocus = var1;
        }

        this.gameAU();
    }

    private void gameEX() {
        if (gameBP == 0) {
            gameBP = 1;
        } else {
            gameBP = 0;
        }

        indexRow = 0;
        this.gameHN = gameBP;
    }

    private static void gameEY() {
        Party var0;
        if ((var0 = (Party) vParty.elementAt(indexRow)).c != null && var0.c != Char.getMyChar()) {
            Service.gI().gameAJ(var0.c.cName);
            gameHZ = false;
            gI().gameAU();
        }

    }

    private static void gameEZ() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCL, 110221));
        var0.addElement(new Command(mResources.gameCT, 11050));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameFA() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCL, 11048));
        var0.addElement(new Command(mResources.gameCS, 11049));
        GameCanvas.menu.gameAA(var0);
    }

    private void gameFB() {
        if (Char.getMyChar().arrItemBag[gameBM].template.type != 26 && Char.getMyChar().arrItemBag[gameBM].template.id != 455 && Char.getMyChar().arrItemBag[gameBM].template.id != 456) {
            if (Char.getMyChar().arrItemBag[gameBM].template.id == 457) {
                GameCanvas.msgdlg.gameAA(mResources.gameWP, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            } else {
                GameCanvas.msgdlg.gameAA(mResources.gameWQ, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            }
        } else {
            if (Char.getMyChar().arrItemBag[gameBM].template.type == 26 && Char.getMyChar().arrItemBag[gameBM].template.id < 10) {
                GameCanvas.gameAA(mResources.gameWT);
                return;
            }

            short var1 = 0;
            int var2 = 0;
            boolean var3 = gameCT[12] != null;

            int var4;
            for (var4 = 0; var4 < gameCT.length; ++var4) {
                if (gameCT[var4] != null && gameCT[var4].template.type != 26) {
                    var1 = gameCT[var4].template.id;
                    ++var2;
                }
            }

            for (var4 = 0; var4 < gameCT.length; ++var4) {
                if (gameCT[var4] == null) {
                    if (Char.getMyChar().arrItemBag[gameBM].template.type == 26) {
                        if (gameCT[12] == null) {
                            gameCT[12] = Char.getMyChar().arrItemBag[gameBM];
                            Char.getMyChar().arrItemBag[gameBM] = null;
                        } else {
                            Item var5 = Char.getMyChar().arrItemBag[gameBM];
                            Char.getMyChar().arrItemBag[gameBM] = null;
                            Char.getMyChar().arrItemBag[gameCT[12].indexUI] = gameCT[12];
                            gameCT[12] = var5;
                        }
                    } else if (var1 > 0 && Char.getMyChar().arrItemBag[gameBM].template.id != var1) {
                        GameCanvas.gameAA(mResources.gameWU);
                    } else if ((!var3 || var2 < 3) && var2 < 9) {
                        gameCT[var4] = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                    } else {
                        GameCanvas.gameAA(mResources.gameWW);
                    }

                    super.left = super.center = null;
                    this.gameBB();
                    return;
                }
            }

            GameCanvas.msgdlg.gameAA(mResources.gameNS, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
        }

        GameCanvas.currentDialog = GameCanvas.msgdlg;
    }

    private void gameFC() {
        if (Char.getMyChar().arrItemBag[gameBM].template.type != 26) {
            GameCanvas.msgdlg.gameAA(mResources.gameNL, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            for (int var1 = 0; var1 < gameCT.length; ++var1) {
                if (gameCT[var1] == null) {
                    gameCT[var1] = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                    super.left = super.center = null;
                    this.gameBB();
                    return;
                }
            }

            GameCanvas.msgdlg.gameAA(mResources.gameNS, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void gameFD() {
        Item var1 = gameAN(11);
        gameCT[gameBM] = null;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        super.left = super.center = null;
        this.gameBB();
    }

    private static void gameFE() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCR, 111071));

        for (int var1 = 0; var1 < gameCT.length; ++var1) {
            if (gameCT[var1] != null) {
                var0.addElement(new Command(mResources.gameGC, 1600));
                break;
            }
        }

        GameCanvas.menu.gameAA(var0);
    }

    private static void gameFF() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCR, 111071));

        for (int var1 = 0; var1 < gameCT.length; ++var1) {
            if (gameCT[var1] != null) {
                var0.addElement(new Command(mResources.gameGC, 11062));
                break;
            }
        }

        GameCanvas.menu.gameAA(var0);
    }

    private void gameFG() {
        try {
            int var1;
            int var2;
            if (gameMM) {
                if (!Char.getMyChar().arrItemBag[gameBM].gameAB() && !Char.getMyChar().arrItemBag[gameBM].gameAC() && Char.getMyChar().arrItemBag[gameBM].template.id != 455 && Char.getMyChar().arrItemBag[gameBM].template.id != 456 && Char.getMyChar().arrItemBag[gameBM].template.id != 457) {
                    GameCanvas.msgdlg.gameAA(mResources.gameWX, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                    return;
                }

                if (Char.getMyChar().arrItemBag[gameBM].template.id != 455 && Char.getMyChar().arrItemBag[gameBM].template.id != 456 && Char.getMyChar().arrItemBag[gameBM].template.id != 457) {
                    ItemOption var3 = null;

                    for (var1 = 0; var1 < Char.getMyChar().arrItemBag[gameBM].options.size() && (var3 = (ItemOption) Char.getMyChar().arrItemBag[gameBM].options.elementAt(var1)).optionTemplate.id != 85; ++var1) {
                        var3 = null;
                    }

                    if (var3 == null || var3.param < 9) {
                        if (gameDD == null) {
                            gameDD = Char.getMyChar().arrItemBag[gameBM];
                            Char.getMyChar().arrItemBag[gameBM] = null;
                        } else {
                            Item var5 = Char.getMyChar().arrItemBag[gameBM];
                            Char.getMyChar().arrItemBag[gameBM] = null;
                            Char.getMyChar().arrItemBag[gameDD.indexUI] = gameDD;
                            gameDD = var5;
                        }

                        Service.gI().gameAC(gameDD.typeUI, gameDD.indexUI);
                        return;
                    }

                    GameCanvas.gameAA(mResources.gameXG);
                } else {
                    if (gameCV == null) {
                        gameCV = new Item[24];
                    }

                    for (var2 = 0; var2 < gameCV.length; ++var2) {
                        if (gameCV[var2] == null) {
                            gameCV[var2] = Char.getMyChar().arrItemBag[gameBM];
                            Char.getMyChar().arrItemBag[gameBM] = null;
                            super.left = super.center = null;
                            this.gameBB();
                            return;
                        }

                        if (var2 == gameCV.length - 1) {
                            GameCanvas.gameAA(mResources.gameNS);
                        }
                    }
                }
            } else {
                if (Char.getMyChar().arrItemBag[gameBM].gameAB() && Char.getMyChar().arrItemBag[gameBM].upgrade > 0) {
                    if (gameDD == null) {
                        gameDD = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                    } else {
                        Item var6 = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                        Char.getMyChar().arrItemBag[gameDD.indexUI] = gameDD;
                        gameDD = var6;
                    }

                    if (gameDD != null) {
                        var2 = 0;
                        if (gameDD.gameAR()) {
                            for (var1 = 0; var1 < gameDD.upgrade; ++var1) {
                                var2 += upClothe[var1];
                            }
                        } else if (gameDD.gameAS()) {
                            for (var1 = 0; var1 < gameDD.upgrade; ++var1) {
                                var2 += upAdorn[var1];
                            }
                        } else if (gameDD.gameAT()) {
                            for (var1 = 0; var1 < gameDD.upgrade; ++var1) {
                                var2 += upWeapon[var1];
                            }
                        }

                        var2 /= 2;
                        var1 = 0;
                        gameCV = new Item[24];

                        for (int var7 = crystals.length - 1; var7 >= 0; --var7) {
                            if (var2 >= crystals[var7]) {
                                gameCV[var1] = new Item();
                                gameCV[var1].typeUI = 3;
                                gameCV[var1].template = ItemTemplates.gameAA((short) var7);
                                gameCV[var1].isLock = gameDD.isLock;
                                gameCV[var1].expires = -1L;
                                var2 -= crystals[var7];
                                ++var7;
                                ++var1;
                            }
                        }
                    }

                    super.left = super.center = null;
                    this.gameBB();
                    return;
                }

                GameCanvas.msgdlg.gameAA(mResources.gameNQ, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            }

        } catch (Exception var4) {
            GameCanvas.msgdlg.gameAA(mResources.gameWX, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void gameFH() {
        MyVector var1;
        (var1 = new MyVector()).addElement(this.gameRT);
        if (gameDD != null) {
            var1.addElement(new Command(mResources.gameGC, 111031));
        }

        GameCanvas.menu.gameAA(var1);
    }

    private void gameFI() {
        if (Char.getMyChar().arrItemBag[gameBM].gameAB()) {
            if (Char.getMyChar().arrItemBag[gameBM].template.level >= 10 && Char.getMyChar().arrItemBag[gameBM].template.type < 10) {
                if (Char.getMyChar().arrItemBag[gameBM].upgrade >= Char.getMyChar().arrItemBag[gameBM].gameAQ()) {
                    GameCanvas.msgdlg.gameAA(mResources.gameNP, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                } else {
                    if (arritemup == null) {
                        arritemup = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                    } else {
                        Item var4 = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                        Char.getMyChar().arrItemBag[arritemup.indexUI] = arritemup;
                        arritemup = var4;
                    }

                    super.left = super.center = null;
                    this.gameBB();
                }
            } else {
                GameCanvas.msgdlg.gameAA(mResources.gameNO, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            }
        } else if (Char.getMyChar().arrItemBag[gameBM].template.type != 26 && Char.getMyChar().arrItemBag[gameBM].template.type != 28) {
            GameCanvas.msgdlg.gameAA(mResources.gameNM, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            int var1;
            if (Char.getMyChar().arrItemBag[gameBM].template.type == 28) {
                for (var1 = 0; var1 < upitem.length; ++var1) {
                    if (upitem[var1] != null && upitem[var1].template.type == 28) {
                        Item var2 = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                        int var3 = upitem[var1].indexUI;
                        Char.getMyChar().arrItemBag[var3] = upitem[var1];
                        upitem[var1] = var2;
                        return;
                    }
                }
            }

            for (var1 = 0; var1 < upitem.length; ++var1) {
                if (upitem[var1] == null) {
                    upitem[var1] = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                    super.left = super.center = null;
                    this.gameBB();
                    return;
                }
            }

            GameCanvas.msgdlg.gameAA(mResources.gameNS, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void gameAO(int var1) {
        if (gameCY[var1] == null) {
            gameCY[var1] = Char.getMyChar().arrItemBag[gameBM];
            Char.getMyChar().arrItemBag[gameBM] = null;
        } else {
            Item var2 = Char.getMyChar().arrItemBag[gameBM];
            Char.getMyChar().arrItemBag[gameBM] = null;
            int var3 = gameCY[var1].indexUI;
            Char.getMyChar().arrItemBag[var3] = gameCY[var1];
            gameCY[var1] = var2;
        }

        super.left = super.center = null;
        this.gameBB();
    }

    private void gameFJ() {
        if (Char.getMyChar().arrItemBag[gameBM].gameAB()) {
            if (Char.getMyChar().arrItemBag[gameBM].upgrade > 0) {
                this.gameAO(0);
            } else {
                this.gameAO(1);
            }
        } else if (Char.getMyChar().arrItemBag[gameBM].template.id != 269 && Char.getMyChar().arrItemBag[gameBM].template.id != 270 && Char.getMyChar().arrItemBag[gameBM].template.id != 271) {
            GameCanvas.msgdlg.gameAA(mResources.gameNN, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            this.gameAO(2);
        }
    }

    private void gameFK() {
        Item var1 = gameCY[2];
        gameCY[2] = null;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        super.left = super.center = null;
        this.gameBB();
    }

    private void gameFL() {
        Item var1 = gameCY[gameBM];
        gameCY[gameBM] = null;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        super.left = super.center = null;
        this.gameBB();
    }

    private void gameFM() {
        Item var1 = gameAN(10);
        upitem[gameBM] = null;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        super.left = super.center = null;
        this.gameBB();
    }

    private static void gameFN() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCR, 111001));
        if (arritemup != null) {
            for (int var1 = 0; var1 < upitem.length; ++var1) {
                if (upitem[var1] != null) {
                    var0.addElement(new Command(mResources.gameGC, 110981));
                    break;
                }
            }
        }

        GameCanvas.menu.gameAA(var0);
    }

    private void gameFO() {
        MyVector var1;
        (var1 = new MyVector()).addElement(this.gameRS);

        for (int var2 = 0; var2 < gameCY.length; ++var2) {
            if (gameCY[var2] == null) {
                super.left = null;
                break;
            }

            if (var2 == gameCY.length - 1) {
                var1.addElement(new Command(mResources.gameGC, 140131));
            }
        }

        GameCanvas.menu.gameAA(var1);
    }

    private void gameFP() {
        MyVector var1;
        (var1 = new MyVector()).addElement(this.gameRR);

        for (int var2 = 0; var2 < upitem.length; ++var2) {
            if (upitem[var2] != null) {
                var1.addElement(new Command(mResources.gameGC, 110981));
                break;
            }
        }

        GameCanvas.menu.gameAA(var1);
    }

    private static void gameAC(Item var0) {
        MyVector var1;
        (var1 = new MyVector()).addElement(new Command(mResources.gameDA, 110921, var0));
        var1.addElement(new Command(mResources.gameDB, 110922, var0));
        GameCanvas.menu.gameAA(var1);
    }

    private static void gameFQ() {
        indexRow = 0;
        gameBU.gameAA();
        if (gameNU == 0) {
            gameNU = 1;
        } else {
            gameNU = 0;
        }
    }

    private void gameFR() {
        gameBP = 0;
        gameDL = false;
        super.left = this.gameFT;
        super.right = this.gameHM;
        super.center = null;
        System.gc();
        this.gameAU();
        this.gameCC();
    }

    private static void gameFS() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110851));
        var0.addElement(new Command(mResources.gameDB, 110852));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameFT() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameEF, 110841));
        var0.addElement(new Command(mResources.gameEG, 110842));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameFU() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gamePH, 110821));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameFV() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameUX[0], 110811));
        var0.addElement(new Command(mResources.gameUX[1], 110812));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameAE(String var0) {
        MyVector var1;
        (var1 = new MyVector()).addElement(new Command(mResources.gameTC[0], 110801));
        var1.addElement(new Command(mResources.gameTC[1], 110802));
        var1.addElement(new Command(mResources.gameTC[2], 110803, var0));
        var1.addElement(new Command(mResources.gameSG[7], 12002, var0));
        var1.addElement(new Command(mResources.gameSG[6], 110804));
        GameCanvas.menu.gameAA(var1);
    }

    private static void gameFW() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameEF, 140011));
        var0.addElement(new Command(mResources.gameEG, 140012));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameAF(String var0) {
        GameCanvas.gameAA(mResources.gameTI, new Command(mResources.YES, 1107921, var0), new Command(mResources.NO, 1));
    }

    private static void gameFX() {
        Friend var0 = (Friend) vFriend.elementAt(indexRow);
        MyVector var1;
        (var1 = new MyVector()).addElement(new Command(mResources.gameSG[6], 1108041, var0.friendName));
        var1.addElement(new Command(mResources.CHAT, 12002, var0.friendName));
        if (var0.type == 4) {
            var1.addElement(new Command(mResources.ACCEPT, 1107931, var0.friendName));
            var1.addElement(new Command(mResources.CANCEL, 1107932, var0.friendName));
        } else {
            var1.addElement(new Command(mResources.gameTF, 110791, var0.friendName));
            var1.addElement(new Command(mResources.gameBK, 14020, var0.friendName));
            var1.addElement(new Command(mResources.DELETE, 110792, var0.friendName));
        }

        GameCanvas.menu.gameAA(var1);
    }

    private void gameAA(byte var1) {
        if (indexRow >= 0 && indexRow < vList.size()) {
            try {
                Ranked var2;
                String var4;
                if ((var2 = (Ranked) vList.elementAt(indexRow)) != null) {
                    var4 = var2.name;
                } else {
                    var4 = "raned=null";
                }

                Service.gI().gameAA(var1, var4);
                this.gameAU();
                return;
            } catch (Exception var3) {
            }
        }

    }

    private static void gameFY() {
        if (indexRow >= 0 && indexRow < vList.size()) {
            int var0 = ((DunItem) vList.elementAt(indexRow)).id;
            Service.gI().gameBC(var0);
        }

    }

    private static void gameFZ() {
        Friend var0 = (Friend) vEnemies.elementAt(indexRow);
        MyVector var1;
        (var1 = new MyVector()).addElement(new Command(mResources.gameSG[6], 1108041, var0.friendName));
        var1.addElement(new Command(mResources.CHAT, 12002, var0.friendName));
        var1.addElement(new Command(mResources.gameTF, 11076, var0.friendName));
        var1.addElement(new Command(mResources.gameBK, 14020, var0.friendName));
        var1.addElement(new Command(mResources.DELETE, 11077, var0.friendName));
        GameCanvas.menu.gameAA(var1);
    }

    private static void gameAG(String var0) {
        GameCanvas.gameAA(mResources.gameTI, new Command(mResources.YES, 110771, var0), new Command(mResources.NO, 1));
    }

    private void gameGA() {
        gameDI = false;
        this.gameND = null;
        this.gameNC = null;
        super.center = null;
        this.gameAU();
    }

    private void gameAA(short var1, String var2) {
        NinjaUtil.gameAA(var2, var1);
        gameDI = false;
        this.gameND = null;
        this.gameNC = null;
        super.center = null;
        this.gameAU();
    }

    private static void gameGB() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameCW, 110721));
        var0.addElement(new Command(mResources.gameCX, 110722));
        var0.addElement(new Command(mResources.gameCY, 110723));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameAA(Party var0) {
        MyVector var1;
        (var1 = new MyVector()).addElement(new Command(mResources.gameSM, 110701));
        if (!var0.isLock) {
            var1.addElement(new Command(mResources.gameSO, 110702));
        } else {
            var1.addElement(new Command(mResources.gameSP, 110703));
        }

        GameCanvas.menu.gameAA(var1);
    }

    private void gameGC() {
        gameDI = false;
        this.gameND = null;
        this.gameNC = null;
        super.center = null;
        this.gameAU();
    }

    private void gameAH(String var1) {
        NinjaUtil.gameAB(var1);
        gameDI = false;
        this.gameND = null;
        this.gameNC = null;
        super.center = null;
        this.gameAU();
    }

    private static void gameGD() {
        GameCanvas.endDlg();
        Service.gI().gameAA(arritemup, upitem, gameMB);
    }

    private static void gameAD(Item var0) {
        GameCanvas.endDlg();
        Service.gI().gameAG(var0.indexUI, 1);
    }

    private void gameGE() {
        gameBP = 0;
        gameDL = false;
        this.gameAU();
        if (currentCharViewInfo.charID == Char.getMyChar().charID) {
            this.gameCC();
        }

    }

    private void gameGF() {
        if (this.gamePJ >= 0 && this.gamePJ < gamePB.length) {
            Skill var1 = gamePB[this.gamePJ];
            this.gameAA(var1, false);
        }

    }

    private static void gameAE(Item var0) {
        String var1;
        if (!(var1 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            int var3;
            try {
                var3 = Integer.parseInt(var1);
            } catch (Exception var2) {
                GameCanvas.endDlg();
                return;
            }

            if (var3 <= 0) {
                GameCanvas.endDlg();
                return;
            }

            if (var3 > var0.quantity) {
                GameCanvas.gameAA(mResources.gamePW);
                return;
            }

            GameCanvas.endDlg();
            GameCanvas.gameAA(mResources.gamePM, new Command(mResources.YES, 11058, var0), new Command(mResources.NO, 1));
        }

    }

    private static void gameAF(Item var0) {
        String var1;
        if ((var1 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            GameCanvas.msgdlg.gameAA(mResources.gamePR, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            int var3;
            try {
                var3 = Integer.parseInt(var1);
            } catch (Exception var2) {
                GameCanvas.endDlg();
                return;
            }

            if (var3 <= 0) {
                GameCanvas.endDlg();
            } else {
                Service.gI().gameAA(var0.typeUI, var0.indexUI, var3);
                GameCanvas.endDlg();
            }
        }
    }

    private void gameGG() {
        int var1 = gameBM;
        this.gameAU();
        this.gameNA = var1;
        Service.gI().gameAE();
    }

    private static void gameAG(Item var0) {
        MyVector var1 = new MyVector();

        for (int var2 = 1; var2 < mResources.gameRR[3].length; ++var2) {
            var1.addElement(new Command(mResources.gameRR[3][var2], 110531, var0));
        }

        GameCanvas.menu.gameAA(var1);
    }

    private static void gameGH() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameTR + (ChatManager.blockGlobalChat ? mResources.gameBY : mResources.gameBZ), 120061));
        var0.addElement(new Command(mResources.gameTS + (ChatManager.blockPrivateChat ? mResources.gameBY : mResources.gameBZ), 120062));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameGI() {
        MyVector var0 = new MyVector();

        for (int var1 = 0; var1 < ChatManager.gameAD().chatTabs.size(); ++var1) {
            ChatTab var2 = (ChatTab) ChatManager.gameAD().chatTabs.elementAt(var1);
            var0.addElement(new Command(var2.ownerName, 12001, new Integer(var1)));
        }

        var0.addElement(new Command(mResources.gameUV, 12006));
        var0.addElement(new Command(mResources.gameUW, 12008));
        GameCanvas.menu.gameAA(var0);
        gameDG = true;
    }

    private void gameGJ() {
        ChatTab var1 = ChatManager.gameAD().gameAE();
        gameDI = true;
        isPaintMessage = true;
        this.gameNB = true;
        setSize(175, 200);
        if (GameCanvas.h - gameGD < 40 && !GameCanvas.isTouch) {
            gameGD -= 52;
        }

        super.right = new Command(mResources.CLOSE, 11066);
        super.left = super.center = null;
        if (!GameCanvas.isTouch) {
            gameGK();
        } else {
            super.left = new Command(mResources.CHAT, 12005);
        }

        if (var1.type == 2) {
            super.center = new Command(mResources.gameBQ, 120051, var1);
        }

        ChatTextField.gameAA().gameAF = null;
        this.gameND = var1.ownerName;
        this.gameNC = var1.contents;
        ChatManager.gameAD().gameAE(var1.ownerName);
        if (var1.type == 1) {
            ChatManager.isMessagePt = false;
        }

        if (var1.type == 4) {
            ChatManager.isMessageClan = false;
        }

        this.gameBH();
    }

    private static void gameGK() {
        ChatTab var0;
        if ((var0 = ChatManager.gameAD().gameAE()).type == 0) {
            ChatTextField.gameAA().gameAA(mResources.PUBLICCHAT[0]);
        }

        if (var0.type == 1) {
            ChatTextField.gameAA().gameAA(mResources.PARTYCHAT[0]);
        }

        if (var0.type == 2) {
            ChatTextField.gameAA().gameAA(var0.ownerName);
        }

        if (var0.type == 3) {
            ChatTextField.gameAA().gameAA(mResources.GLOBALCHAT[0]);
        }

        if (var0.type == 4) {
            ChatTextField.gameAA().gameAA(mResources.CLANCHAT[0]);
        }

    }

    private void gameGL() {
        try {
            GameMidlet.instance.platformRequest(this.gameSX);
        } catch (ConnectionNotFoundException var2) {
            var2.printStackTrace();
        }
    }

    private static void gameGM() {
        GameCanvas.endDlg();
        Service.gI().useItem(gameBM);
    }

    private static void gameGN() {
        Service.gI().gameAG();
    }

    private static void gameGO() {
        Service.gI().gameAS();
    }

    private static void gameGP() {
        indexRow = 0;
        Service.gI().gameAD();
    }

    private static void gameGQ() {
        Party var0;
        if (indexRow >= 0 && indexRow < vPtMap.size() && (var0 = (Party) vPtMap.elementAt(indexRow)) != null) {
            Service.gI().gameAH(var0.name);
        }

    }

    private static void gameAP(int var0) {
        switch (var0) {
            case 1:
                Service.gI().gameAZ(0);
                return;
            case 2:
                Service.gI().gameAZ(1);
                return;
            case 3:
                Service.gI().gameAZ(3);
            default:
        }
    }

    private static void gameGR() {
        String var0;
        if ((var0 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            GameCanvas.endDlg();
        } else {
            int var2;
            try {
                var2 = Integer.parseInt(var0);
            } catch (Exception var1) {
                GameCanvas.endDlg();
                return;
            }

            if (var2 <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().xu != 0 && var2 <= Char.getMyChar().xu) {
                Service.gI().gameAJ(var2);
                GameCanvas.endDlg();
            } else {
                GameCanvas.gameAA(mResources.gamePU);
            }
        }
    }

    private void gameGS() {
        String var1;
        if ((var1 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            GameCanvas.endDlg();
        } else {
            int var4;
            try {
                var4 = Integer.parseInt(var1);
            } catch (Exception var3) {
                GameCanvas.endDlg();
                return;
            }

            if (var4 <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().xu != 0 && var4 <= Char.getMyChar().xu) {
                this.gameEE += var4;
                Char var10000 = Char.getMyChar();
                var10000.xu -= var4;
                GameCanvas.endDlg();
            } else {
                GameCanvas.gameAA(mResources.gamePT);
            }
        }
    }

    private static void gameGT() {
        String var0;
        if ((var0 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            GameCanvas.endDlg();
        } else {
            int var2;
            try {
                var2 = Integer.parseInt(var0);
            } catch (Exception var1) {
                GameCanvas.endDlg();
                return;
            }

            if (var2 <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().xuInBox != 0 && var2 <= Char.getMyChar().xuInBox) {
                Service.gI().gameAK(var2);
                GameCanvas.endDlg();
            } else {
                GameCanvas.gameAA(mResources.gamePV);
            }
        }
    }

    private static void gameGU() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameSV[0], 11000651));
        var0.addElement(new Command(mResources.gameSV[1], 11000652));
        var0.addElement(new Command(mResources.gameSV[3], 11000653));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameGV() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameSW[6], 1100067));
        var0.addElement(new Command(mResources.gameSW[3], 1100062));
        var0.addElement(new Command(mResources.gameSW[1], 1100063));
        var0.addElement(new Command(mResources.gameSW[2], 1100064));
        var0.addElement(new Command(mResources.gameSW[0], 1100065));
        var0.addElement(new Command(mResources.gameSW[8], 11000601));
        var0.addElement(new Command(mResources.gameSW[9], 11000602));
        var0.addElement(new Command(mResources.gameSW[10], 11000603));
        var0.addElement(new Command(mResources.gameSW[11], 11000604));
        var0.addElement(new Command(mResources.gameSW[7], 1100068));
        GameCanvas.menu.gameAA(var0);
    }

    private void gameGW() {
        this.gameBX();
        if (super.right != null) {
            super.right.gameAA();
        }

    }

    private void gameGX() {
        this.gameBX();
        if (super.left != null) {
            super.left.gameAA();
        }

    }

    private void gameAQ(int var1) {
        if (Char.getMyChar().charFocus != null && !Char.getMyChar().charFocus.isNhanban) {
            switch (var1) {
                case 1:
                    Service.gI().gameAF(Char.getMyChar().charFocus.cName);
                    return;
                case 2:
                    Service.gI().gameAS(Char.getMyChar().charFocus.charID);
                    return;
                case 3:
                    Service.gI().gameAV(Char.getMyChar().charFocus.charID);
                    return;
                case 4:
                    Service.gI().gameAW(Char.getMyChar().charFocus.charID);
                    return;
                case 5:
                    this.gameAG(Char.getMyChar().charFocus.charID);
                    return;
                case 6:
                    Service.gI().gameAE(Char.getMyChar().charFocus.cName);
                    return;
                case 7:
                    Service.gI().gameAJ(Char.getMyChar().charFocus.cName);
                    gI().gameAU();
                    return;
                case 8:
                    Service.gI().gameBE(Char.getMyChar().charFocus.charID);
                    return;
                case 9:
                    Service.gI().gameBF(Char.getMyChar().charFocus.charID);
                    return;
                case 10:
                    Char.gameFR = !Char.gameFR;
                    Char.aCID = Char.getMyChar().charFocus.charID;
            }
        }

    }

    public final void gameAG(int var1) {
        if (System.currentTimeMillis() - this.gameTV > 500L) {
            Service.gI().gameAX(var1);
            this.gameTV = System.currentTimeMillis();
        }

        if ((TileMap.gameAA(Char.getMyChar().cx, Char.getMyChar().cy) & 2) == 2) {
            Char.getMyChar().gameAA((SkillPaint) sks[49], 0);
        } else {
            Char.getMyChar().gameAA((SkillPaint) sks[49], 1);
        }
    }

    private static void gameGY() {
        GameCanvas.gameAM();
        ChatManager.gameAF();
        Session_ME.gameAA().gameAB();
        RMS.gameAI = 9999;
        RMS.gameAJ = System.currentTimeMillis() + 1000L;
        RMS.gameAK = true;
    }

    private static void gameGZ() {
        GameCanvas.gameAA(mResources.gameFD, new Command(mResources.YES, 1100041), new Command(mResources.NO, 1));
    }

    private static void gameHA() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameSJ[1], 110381));
        var0.addElement(new Command(mResources.gameSJ[2], 110382));
        var0.addElement(new Command(mResources.gameSJ[3], 110383));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHB() {
        Service.gI().gameAF();
    }

    private void gameHC() {
        Item var1 = gameCW[gameBM];
        gameCW[gameBM] = null;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        super.left = super.center = null;
        this.gameBB();
    }

    private void gameHD() {
        Item var1 = gameDD;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        gameDD = null;
        if (!gameMM && !gameMN && !gameMO && gameCV != null) {
            for (int var2 = 0; var2 < gameCV.length; ++var2) {
                gameCV[var2] = null;
            }
        }

        super.left = super.center = null;
        this.gameBB();
    }

    private void gameHE() {
        Item var1 = arritemup;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        arritemup = null;
        super.left = super.center = null;
        this.gameBB();
    }

    private void gameHF() {
        Item var1 = gameCY[gameBM];
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        gameCY[gameBM] = null;
        super.left = super.center = null;
        this.gameBB();
    }

    private void gameHG() {
        Service.gI().gameAJ();
        this.gameEC = 2;
        if (gI().gameEC >= 2 && gI().typeTradeOrder >= 2) {
            InfoDlg.gameAB();
        }

    }

    private void gameHH() {
        Service.gI().gameAA(this.gameEE, gameCW);
        this.gameEC = 1;
        if (gI().gameEC == 1 && gI().typeTradeOrder == 1) {
            gI().gameEG = (int) (System.currentTimeMillis() / 1000L + 5L);
        }

        super.left = this.gameRN;
    }

    private void gameHI() {
        Item var1 = gameCW[gameBM];
        this.gameAA((int) 3, (Item) var1);
    }

    private void gameHJ() {
        if (Char.getMyChar().arrItemBag[gameBM].isLock) {
            GameCanvas.msgdlg.gameAA(mResources.gameNJ, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            for (int var1 = 0; var1 < gameCW.length; ++var1) {
                if (gameCW[var1] == null) {
                    gameCW[var1] = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                    super.left = super.center = null;
                    this.gameBB();
                    return;
                }
            }

            GameCanvas.msgdlg.gameAA(mResources.gameNR, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void gameHK() {
        MyVector var1;
        (var1 = new MyVector()).addElement(this.gameRX);
        var1.addElement(this.gameRU);
        GameCanvas.menu.gameAA(var1);
    }

    private void gameHL() {
        MyVector var1;
        (var1 = new MyVector()).addElement(this.gameRV);
        if (this.gameEC == 0) {
            var1.addElement(this.gameRM);
        } else if (this.gameEC == 1 && this.typeTradeOrder > 0 && (long) this.gameEG - System.currentTimeMillis() / 1000L <= 0L) {
            var1.addElement(this.gameRN);
        }

        GameCanvas.menu.gameAA(var1);
    }

    private static void gameHM() {
        try {
            Item var0;
            if ((var0 = gameAN(3)).template.gender != 2 && var0.template.gender != Char.getMyChar().cgender) {
                GameCanvas.msgdlg.gameAA(mResources.gameQK, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            } else if (var0.template.level > Char.getMyChar().clevel) {
                GameCanvas.msgdlg.gameAA(mResources.gameQM, (Command) null, new Command(mResources.CLOSE, 1), (Command) null);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            } else if ((var0.gameAB() || var0.gameAC()) && !var0.isLock) {
                GameCanvas.gameAA(mResources.gamePL, new Command(mResources.YES, 11051, (Object) null), new Command(mResources.NO, 1));
            } else {
                if (var0.template.id == 35 || var0.template.id == 37) {
                    MyVector var1 = new MyVector();

                    for (int var2 = 0; var2 < 3; ++var2) {
                        var1.addElement(new Command(mResources.gameRR[var2][0], 11052, var0));
                    }

                    var1.addElement(new Command(mResources.gameRR[3][0], 11053, var0));
                    var1.addElement(new Command(mResources.gameRR[4][0], 11054));
                    GameCanvas.menu.gameAA(var1);
                    return;
                }

                if (var0.template.id == 514) {
                    GameCanvas.gameBL.gameAA("Đến: ", "Lời chúc: ");
                    GameCanvas.gameBL.gameAA("Chúc tết", new Command(mResources.CLOSE, GameCanvas.instance, 8882, (Object) null), new Command("Gửi", GameCanvas.instance, 1608, (Object) null), 0, 0);
                } else if (var0.template.id == 515) {
                    GameCanvas.gameBL.gameAA("Đến: ", "Lời chúc: ");
                    GameCanvas.gameBL.gameAA("Chúc tết", new Command(mResources.CLOSE, GameCanvas.instance, 8882, (Object) null), new Command("Gửi", GameCanvas.instance, 16081, (Object) null), 0, 0);
                } else {
                    Service.gI().useItem(gameBM);
                }
            }
        } catch (Exception var3) {
        }

    }

    private static void gameHN() {
        Item var0;
        if ((var0 = gameAN(3)) != null) {
            if (var0.template.level > Char.getMyChar().clevel) {
                GameCanvas.msgdlg.gameAA(mResources.gamePS, (Command) null, new Command(mResources.gameBE, 1), (Command) null);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
                return;
            }

            (new Thread(new MoAll(var0))).start();
        }

    }

    private static void gameHO() {
        if (Char.getMyChar().arrItemBag[gameBM] != null && Char.getMyChar().arrItemBag[gameBM].quantity > 1) {
            GameCanvas.inputDlg.gameAA(mResources.gameUQ, new Command(mResources.OK, GameCanvas.instance, 88835, String.valueOf(gameBM)), 1);
        }

    }

    private static void gameHP() {
        if (Char.getMyChar().arrItemBag[gameBM] != null) {
            if (Char.getMyChar().arrItemBag[gameBM].isLock) {
                InfoMe.gameAA(mResources.gameRY);
                return;
            }

            Service.gI().gameAR(gameBM);
        }

    }

    private void gameHQ() {
        if (gameHQ == 1) {
            Item var1 = gameAN(3);
            if (GameCanvas.gameAI) {
                this.gameAA(var1, this.gameTL);
                return;
            }

            this.gameAA((Item) var1, (Command) null);
        }

    }

    private void gameHR() {
        MyVector var1;
        (var1 = new MyVector()).addElement(this.gameTL);
        if (Char.getMyChar().arrItemBag[gameBM] != null) {
            Item var2;
            if (Code.gameAA((int) (var2 = Char.getMyChar().arrItemBag[gameBM]).template.id)) {
                var1.addElement(new Command("Tắt Tự Dùng", 110263));
            } else {
                var1.addElement(new Command("Tự Dùng", 110262));
            }
            if (var2.upgrade >= 12) {
                var1.addElement(new Command("Dịch Chuyển", 11000808));
            }
            if (Code.gameAA(var2)) {
                var1.addElement(new Command("Tắt Tự TL", 110265));
            } else if (var2.gameAU() >= 0 && var2.gameAU() < 9) {
                var1.addElement(new Command("Tự TL", 110264));
            }

//            if (Code.gameAD((int) var2.template.id)) {
//                var1.addElement(new Command("Tắt Tự Shinwa " + Code.gameAE(var2.template.id), 110267));
//            } else {
//                var1.addElement(new Command("Tự Bán Shinwa", 110266));
//            }
        }

        if (Char.getMyChar().arrItemBag[gameBM] != null && Char.getMyChar().arrItemBag[gameBM].quantity > 1) {
            var1.addElement(new Command("Mở all", 110261));
            var1.addElement(this.gameTP);
        }

        var1.addElement(new Command(mResources.gameCW, Char.getMyChar().arrItemBag[gameBM].quantity > 1 ? 11072 : 11073));
        var1.addElement(this.gameTO);
        if (Char.getMyChar().arrItemBag[gameBM] != null) {
            RMS var3 = ChatSell.gameAA(Char.getMyChar().arrItemBag[gameBM].template.id);
            var1.addElement(new Command(var3 == null ? "Đặt giá" : var3.gameAB, 1102211));
            if (var3 != null) {
                var1.addElement(new Command("Hủy Mua Bán", 1102213));
            }
        }

        //var1.addElement(new Command(mResources.gameCL, 110221));
        GameCanvas.menu.gameAA(var1);
    }

    private static void gameHS() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 140221));
        var0.addElement(new Command(mResources.gameDB, 140222));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHT() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110201));
        var0.addElement(new Command(mResources.gameDB, 110202));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHU() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110181));
        var0.addElement(new Command(mResources.gameDB, 110182));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHV() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 130021));
        var0.addElement(new Command(mResources.gameDB, 130022));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHW() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110161));
        var0.addElement(new Command(mResources.gameDB, 110162));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHX() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110141));
        var0.addElement(new Command(mResources.gameDB, 110142));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHY() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110121));
        var0.addElement(new Command(mResources.gameDB, 110122));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameHZ() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110101));
        var0.addElement(new Command(mResources.gameDB, 110102));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameKA() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110081));
        var0.addElement(new Command(mResources.gameDB, 110082));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameKB() {
        MyVector var0;
        (var0 = new MyVector()).addElement(new Command(mResources.gameDA, 110051));
        var0.addElement(new Command(mResources.gameDB, 110052));
        GameCanvas.menu.gameAA(var0);
    }

    private static void gameAB(byte var0) {
        Item var1 = gameAN(var0);
        Service.gI().gameAA(var1.typeUI, var1.indexUI, 1);
    }

    private static void gameAC(byte var0) {
        gameAA(gameAN(var0));
    }

    private void gameAD(byte var1) {
        Item var2 = gameAN(var1);
        this.gameAA(var2.typeUI, var2);
    }

    private static void gameKC() {
        String var0;
        if ((var0 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            GameCanvas.gameAA(mResources.gameNU);
        } else {
            int var2;
            try {
                var2 = Integer.parseInt(var0);
            } catch (Exception var1) {
                GameCanvas.endDlg();
                return;
            }

            if (var2 <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().pPoint != 0 && var2 <= Char.getMyChar().pPoint) {
                Service.gI().gameAE(gameHQ - 1, var2);
                GameCanvas.endDlg();
            } else {
                GameCanvas.gameAA(mResources.gameNT);
            }
        }
    }

    private static void gameKD() {
        String var0;
        if ((var0 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            GameCanvas.gameAA(mResources.gameNU);
        } else {
            int var2;
            try {
                var2 = Integer.parseInt(var0);
            } catch (Exception var1) {
                GameCanvas.endDlg();
                return;
            }

            if (Char.getMyChar().sPoint != 0 && var2 <= Char.getMyChar().sPoint) {
                Service.gI().gameAF(Char.getMyChar().nClass.skillTemplates[gameBM].id, var2);
                GameCanvas.endDlg();
            } else {
                GameCanvas.gameAA(mResources.gameNU);
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            }
        }
    }

    private static void gameKE() {
        String var0;
        if ((var0 = GameCanvas.inputDlg.tfInput.gameAD()).trim().equals("")) {
            GameCanvas.gameAA(mResources.gameNZ);
        } else {
            Service.gI().gameAE(var0);
            GameCanvas.endDlg();
        }
    }

    public final void perform(int var1, Object var2) {
        GameCanvas.instance.gameAP();
    }

    public final void gameBK() {
        this.gameBI();
        gameBP = 3;
        gameDL = true;
        setSize(175, 200);
        super.right = this.gameSA;
    }

    public static void gameBL() {
        gameTY = new int[vMob.size()];
        gameTZ = new int[vMob.size()];

        int var0;
        Mob var1;
        for (var0 = 0; var0 < vMob.size(); ++var0) {
            if (var0 != gameTX) {
                var1 = (Mob) vMob.elementAt(var0);
                int var2;
                int var3;
                if (!gameFS) {
                    var2 = Math.abs(var1.xFirst - gameGI);
                    gameTY[var0] = var2;
                    var3 = Math.abs(var1.yFirst - gameGJ);
                    gameTZ[var0] = var3;
                } else {
                    var2 = Math.abs(var1.xFirst - Char.getMyChar().cx);
                    gameTY[var0] = var2;
                    var3 = Math.abs(var1.yFirst - Char.getMyChar().cy);
                    gameTZ[var0] = var3;
                    gameGK = 700;
                }
            }
        }

        if (gameFW == 1 && Char.getMyChar().mobFocus == null && Char.getMyChar().npcFocus == null && Char.getMyChar().mobFocus == null && Char.getMyChar().statusMe != 14 && Char.getMyChar().cMP > 0 && Char.getMyChar().itemFocus == null && System.currentTimeMillis() - gameTW + 2000L >= 0L) {
            if (!gameFS && Char.getMyChar().mobFocus != null && (Char.getMyChar().cx < gameGI - gameGK || Char.getMyChar().cy > gameGI + gameGK || Char.getMyChar().cy < gameGJ - gameGK || Char.getMyChar().cy > gameGJ + gameGK)) {
                Char.getMyChar().cx = gameGI;
                Char.getMyChar().cy = gameGJ;
            }

            for (var0 = 0; var0 < vMob.size(); ++var0) {
                if (var0 != gameTX && gameTY[var0] < gameGK && gameTZ[var0] < gameGK && Char.getMyChar().mobFocus == null && (var1 = (Mob) vMob.elementAt(var0)).status != 0 && var1.status != 1 && var1.levelBoss != 3) {
                    ServerEffect.gameAA(141, Char.getMyChar().cx, Char.getMyChar().cy, 2);
                    Char.getMyChar().cx = var1.xFirst;
                    Char.getMyChar().cy = var1.yFirst;
                    Char.getMyChar().statusMe = 4;
                    Char.getMyChar().mobFocus = var1;
                    ServerEffect.gameAA(141, Char.getMyChar().cx, Char.getMyChar().cy, 2);
                    Char.getMyChar().cxSend = var1.xFirst;
                    Char.getMyChar().cySend = var1.yFirst;
                    Service.gI().gameAB(var1.mobId);
                    gameTX = var0;
                    gameTW = System.currentTimeMillis();
                }
            }
        }

    }

    private static void gameBO(mGraphics var0) {
        if (gameHX) {
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var0);
            gameAA(var0, mResources.gameBC, false);
            gameGA = popupX + 5;
            gameGB = popupY + 40;
            if (vList.size() == 0) {
                mFont.tahoma_7_white.gameAA(var0, mResources.gameST, popupX + gameGC / 2, popupY + 40, 2);
                return;
            }

            var0.gameAA(-16770791);
            var0.gameAD(gameGA - 2, gameGB - 2, gameGC - 6, gameBL * 3 + 8);
            gameAB(var0);
            gameBU.gameAA(vList.size(), gameBL, gameGA, gameGB, gameGC - 3, gameBL * 3 + 4, true, 1);
            gameBU.gameAA(var0, gameGA, gameGB, gameGC - 3, gameBL * 3 + 6);
            gameBO = vList.size();

            for (int var1 = 0; var1 < vList.size(); ++var1) {
                Ranked var2 = null;

                try {
                    var2 = (Ranked) vList.elementAt(var1);
                } catch (Exception var3) {
                }

                if (var2 != null) {
                    if (indexRow == var1) {
                        var0.gameAA(Paint.COLORLIGHT);
                        var0.gameAD(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(16777215);
                        var0.gameAC(gameGA + 2, gameGB + indexRow * gameBL + 2, gameGC - 15, gameBL - 4);
                    } else {
                        var0.gameAA(Paint.COLORBACKGROUND);
                        var0.gameAD(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                        var0.gameAA(13932896);
                        var0.gameAC(gameGA + 2, gameGB + var1 * gameBL + 2, gameGC - 15, gameBL - 4);
                    }

                    mFont.tahoma_7_yellow.gameAA(var0, var2.name, gameGA + (gameGC - 10) / 2 - gameGC / 4, gameGB + var1 * gameBL + gameBL / 2 - 10, 2);
                    mFont.tahoma_7_yellow.gameAA(var0, "-", gameGA + (gameGC - 10) / 2, gameGB + var1 * gameBL + gameBL / 2 - 10, 2);
                    mFont.tahoma_7_yellow.gameAA(var0, mResources.gameBB + ": " + var2.id, gameGA + (gameGC - 10) / 2 + gameGC / 4, gameGB + var1 * gameBL + gameBL / 2 - 10, 2);
                    mFont.tahoma_7_white.gameAA(var0, var2.stt, gameGA + gameGC / 2, gameGB + var1 * gameBL + gameBL / 2 + 5, 2);
                }
            }
        }

    }

    private static void gameKF() {
        Service.gI().gameAA((short) 102, "", gameGL);
    }

    private void gameKG() {
        this.gameUJ = true;
        Service.gI().gameAA((short) 101, "", gameGL);
    }

    private static void gameKH() {
        Short var0 = new Short((short) 1);
        GameCanvas.inputDlg.gameAA(mResources.gameAZ, new Command(mResources.gameBA, GameCanvas.instance, 1700, var0), 1);
    }

    public final void gameAA(String var1, short var2, String var3, short var4, String var5, short var6, String var7, String var8, byte var9) {
        InfoDlg.gameAD();
        gameMS = true;
        this.gameNB = true;
        indexRow = 0;
        setSize(175, 200);
        super.left = null;
        super.center = new Command(mResources.gameBA, 1701);
        super.right = new Command(mResources.CLOSE, 1702);
        gameGL = var9;
        this.gameND = var1;
        this.gameUA = var2;
        this.gameUE = var3;
        this.gameUB = var4;
        this.gameUF = var5;
        this.gameUC = var6;
        this.gameUG = var7;
        this.gameUH = var8;
        var1 = this.gameUH == "" ? "" : mResources.gameAX + this.gameUH + mResources.gamePE;
        var1 = "c3" + this.gameUE + "\n" + mResources.gameAY + var6 + "\n" + var1 + "\n\nc0" + this.gameUG;
        this.gameNC = mFont.tahoma_7.gameAA(var1, gameGC - 30);
        this.gameUI = System.currentTimeMillis();
        this.gameUD = gameAA(this.gameUI, this.gameUA);
        this.gameUJ = false;
    }

    private static String gameAA(long var0, int var2) {
        long var3;
        if ((var3 = (var0 + (long) (var2 * 1000) - System.currentTimeMillis()) / 1000L) <= 0L) {
            return "";
        } else {
            long var5;
            if ((var5 = var3 / 60L) > 0L) {
                if (var5 < 10L) {
                    return var3 % 60L >= 0L && var3 % 60L < 10L ? "0" + var5 + ":0" + var3 % 60L : "0" + var5 + ":" + var3 % 60L;
                } else {
                    return var3 % 60L >= 0L && var3 % 60L < 10L ? var5 + ":0" + var3 % 60L : var5 + ":" + var3 % 60L;
                }
            } else {
                return var3 < 10L ? "0" + var3 + "s" : var3 + "s";
            }
        }
    }

    private void gameKI() {
        gameMS = false;
        this.gameND = null;
        this.gameNC = null;
        super.center = null;
        super.left = null;
        super.right = null;
        this.gameAU();
    }

    private void gameBP(mGraphics var1) {
        if (this.gameNC != null && gameMS) {
            if (!this.gameUJ) {
                if (this.gameUC > 1) {
                    this.gameUD = gameAA(this.gameUI, this.gameUA);
                }

                if (this.gameUD == "") {
                    this.gameKG();
                }

                long var2;
                if ((var2 = (this.gameUI + (long) (this.gameUA * 1000) - System.currentTimeMillis()) / 1000L) > 8L && var2 % 5L == 0L) {
                    this.gameKG();
                }

                if (var2 <= 10L) {
                    super.center = null;
                }

                if (var2 <= 20L) {
                    this.gameUK = mFont.tahoma_7b_red;
                } else {
                    this.gameUK = mFont.tahoma_7b_yellow;
                }
            }

            gameAB(var1);
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            if (this.gameND != null) {
                gameAA(var1, this.gameND, isPaintMessage);
            }

            gameGA = popupX + 15;
            gameGB = popupY + 15;
            if (this.gameND != null) {
                gameGB += 10;
            }

            this.gameUK.gameAA(var1, this.gameUD, popupX + gameGC / 2, gameGB + 12, 2);
            mFont.tahoma_7_yellow.gameAA(var1, mResources.gameAW, popupX + gameGC / 2, gameGB + 30, 2);
            int var7 = popupX + gameGC / 2;
            int var3 = gameGB + 42;
            int var4 = gameGC / 2;
            String var5 = this.gameUB + "." + this.gameUF + "%";
            short var6 = this.gameUB;
            var1.gameAA(0);
            var1.gameAD(var7 - var4 / 2, var3, var4, 12);
            int var10;
            if ((var10 = var6 * var4 / 100) <= 0) {
                var10 = 1;
            }

            var1.gameAE(var7 - var4 / 2, var3, var10, 12);
            var1.gameAA(16711680);
            var1.gameAD(var7 - var4 / 2, var3, var4, 12);
            gameAB(var1);
            mFont.tahoma_7_yellow.gameAA(var1, var5, popupX + gameGC / 2, var3, 2);
            gameBO = this.gameNC.size();
            gameBU.gameAA(gameBO, 12, popupX, gameGB + 48, gameGC, gameGD - 42 - (this.gameND != null ? 10 : 0), true, 1);
            gameBU.gameAA(var1);
            this.gameGE = gameGB + 48;
            mFont var8 = mFont.tahoma_7_white;

            String var9;
            for (var3 = 0; var3 < this.gameNC.size() && (var9 = (String) this.gameNC.elementAt(var3)) != null && this.gameNC != null && var8 != null; ++var3) {
                if (var9.startsWith("c")) {
                    if (var9.startsWith("c0")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7_white;
                    } else if (var9.startsWith("c1")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7b_yellow;
                    } else if (var9.startsWith("c2")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7b_white;
                    } else if (var9.startsWith("c3")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7_yellow;
                    } else if (var9.startsWith("c4")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7b_red;
                    } else if (var9.startsWith("c5")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7_red;
                    } else if (var9.startsWith("c6")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7_grey;
                    } else if (var9.startsWith("c7")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7b_blue;
                    } else if (var9.startsWith("c8")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7_blue;
                    } else if (var9.startsWith("c9")) {
                        var9 = var9.substring(2);
                        var8 = mFont.tahoma_7_green;
                    }
                }

                var8.gameAA(var1, var9, popupX + gameGC / 2, this.gameGE += 12, 2);
            }
        }

    }

    public final void gameAB() {
        Session_ME.gameAP = false;
        Session_ME.gameAE();
        TileMap.gameBE = false;
        Code.gameAA.gameAA();
        super.gameAB();
    }

    public final void gameBM() {
        gamePD = new byte[this.gameNW.length];

        int var1;
        for (var1 = 0; var1 < this.gameNW.length; ++var1) {
            gamePD[var1] = gamePA[var1] == null ? -1 : gamePA[var1].template.id;
        }

        gamePC = new byte[this.gameNV.length];

        for (var1 = 0; var1 < this.gameNV.length; ++var1) {
            gamePC[var1] = gamePB[var1] == null ? -1 : gamePB[var1].template.id;
        }

    }

    public final void gameBN() {
        this.gameUL = new byte[]{-1, -1, -1, -1, -1, -1};
    }

    public final void gameAA(Image var1) {
        var1.getRGB(this.gameGO, 0, 60, 0, 15, 60, 10);
        (new Thread(new DietMa(this))).start();
    }

    private void gameAE(byte var1) {
        for (int var2 = 0; var2 < this.gameUL.length; ++var2) {
            if (var2 != this.gameUL.length - 1) {
                this.gameUL[var2] = this.gameUL[var2 + 1];
            } else {
                this.gameUL[var2] = var1;
                Service.gI().gameAA(var1);
            }
        }

    }

    private void gameBQ(mGraphics var1) {
        try {
            gameBO = 1;
            this.gameUQ = gameGC;
            this.gameUR = gameGD;
            this.gameUO = popupX;
            this.gameUP = popupY;
            this.gameUZ = this.gameUO + 25;
            this.gameVA = this.gameUP + 60;
            this.gameVB = this.gameUQ - 50;
            this.gameVC = 70;
            this.gameUU = this.gameUQ - 49;
            this.gameUV = 10;
            this.gameUS = GameCanvas.hw - this.gameUU / 2;
            this.gameUT = this.gameVA + this.gameVC - this.gameUV;
            this.gameUY = 18;
            this.gameUW = GameCanvas.hw - (this.gameUN.size() - 1) * ((this.gameUY + 5) / 2);
            this.gameUX = this.gameUP + this.gameUR - this.gameUY / 2 - 5;
            Clan_ThanThu var2;
            if (this.gameUN.size() > 0 && this.gameUM <= this.gameUN.size()) {
                var2 = (Clan_ThanThu) this.gameUN.elementAt(this.gameUM);
            } else {
                var2 = null;
            }

            if (var2 != null) {
                mFont.tahoma_7b_white.gameAA(var1, var2.name, GameCanvas.hw, this.gameUP + 35, 2);
                var1.gameAA(13606712);
                var1.gameAC(this.gameUZ - 1, this.gameVA - 1, this.gameVB + 1, this.gameVC + 1);
                var1.gameAE(this.gameUZ, this.gameVA, this.gameVB, this.gameVC);
                var1.gameAA(6425);
                var1.gameAD(this.gameUZ, this.gameVA, this.gameVB, this.gameVC);
                SmallImage.gameAB(var1, var2.idThanThu, this.gameUZ + this.gameVB / 2, this.gameVA + this.gameVC / 2 - 10, 0, 3);
                gameAB(var1);
                int var3;
                if (var2.time_aptrung >= 0) {
                    this.gameVE = Res.gameAA(var2.timeStartThanThu, var2.time_aptrung);
                    if (!this.gameVE.equals("")) {
                        mFont.tahoma_7_yellow.gameAA(var1, var2.str_trungno + " " + this.gameVE, this.gameUZ, this.gameUT + 15, 0);
                    } else {
                        --this.gameVD;
                        if (this.gameVD <= 0) {
                            Service.gI().gameAY();
                            this.gameVD = 100;
                        }
                    }
                } else {
                    for (var3 = 0; var3 < var2.stars; ++var3) {
                        SmallImage.gameAB(var1, 628, this.gameUO + 95 + var3 * 12 - var2.stars * 6, this.gameUP + 50, 0, 3);
                    }

                    var3 = var2.curExp * this.gameUU / var2.maxExp;
                    var1.gameAA(2506246);
                    var1.gameAD(this.gameUS, this.gameUT, this.gameUU, this.gameUV);
                    var1.gameAA(371981);
                    var1.gameAD(this.gameUS, this.gameUT, var3, this.gameUV);
                    var1.gameAA(13606712);
                    var1.gameAC(this.gameUS, this.gameUT, this.gameUU, this.gameUV);
                    mFont.tahoma_7_white.gameAA(var1, var2.curExp + "/" + var2.maxExp, this.gameUS + this.gameUU / 2, this.gameUT, 2);

                    for (int var4 = 0; var4 < var2.vecInfo.size(); ++var4) {
                        String var6 = (String) var2.vecInfo.elementAt(var4);
                        mFont.tahoma_7_yellow.gameAA(var1, var6, this.gameUZ + this.gameVB / 2, this.gameUT + 15 + var4 * 10, 2);
                    }
                }

                for (var3 = 0; var3 < this.gameUN.size(); ++var3) {
                    Clan_ThanThu var7;
                    if (this.gameUN.size() > 0 && var3 <= this.gameUN.size()) {
                        var7 = (Clan_ThanThu) this.gameUN.elementAt(var3);
                    } else {
                        var7 = null;
                    }

                    if (var7 != null) {
                        var1.gameAA(0);
                        var1.gameAD(this.gameUW + var3 * (this.gameUY + 5) - this.gameUY / 2, this.gameUX - this.gameUY / 2, this.gameUY, this.gameUY);
                        SmallImage.gameAB(var1, 154, this.gameUW + var3 * (this.gameUY + 5), this.gameUX, 0, 3);
                        var1.gameAA(12281361);
                        var1.gameAC(this.gameUW + var3 * (this.gameUY + 5) - this.gameUY / 2, this.gameUX - this.gameUY / 2, this.gameUY, this.gameUY);
                        SmallImage.gameAB(var1, var7.idIconItem, this.gameUW + var3 * (this.gameUY + 5), this.gameUX, 0, 3);
                    }
                }

                var1.gameAA(16777215);
                var1.gameAC(this.gameUW + this.gameUM * (this.gameUY + 5) - this.gameUY / 2, this.gameUX - this.gameUY / 2, this.gameUY, this.gameUY);
                return;
            }

            var1.gameAA(13606712);
            var1.gameAC(this.gameUZ - 1, this.gameVA - 1, this.gameVB + 1, this.gameVC + 1);
            var1.gameAE(this.gameUZ, this.gameVA, this.gameVB, this.gameVC);
            var1.gameAA(6425);
            var1.gameAD(this.gameUZ, this.gameVA, this.gameVB, this.gameVC);
        } catch (Exception var5) {
            System.out.println("e:" + var5.toString());
        }

    }

    public final void gameAA(Clan_ThanThu var1) {
        this.gameUN.addElement(var1);
    }

    public final void gameBO() {
        this.gameUN.removeAllElements();
    }

    private void gameKJ() {
        try {
            if (gameMO && Char.getMyChar().arrItemBag[gameBM].gameAD()) {
                if (gameDD == null) {
                    if (Char.getMyChar().arrItemBag[gameBM].upgrade < 10) {
                        gameDD = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                    } else {
                        GameCanvas.msgdlg.gameAA(mResources.gameAI, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
                        GameCanvas.currentDialog = GameCanvas.msgdlg;
                    }
                } else {
                    if (gameCV == null) {
                        gameCV = new Item[24];
                    }

                    for (int var1 = 0; var1 < gameCV.length; ++var1) {
                        if (gameCV[var1] == null) {
                            gameCV[var1] = Char.getMyChar().arrItemBag[gameBM];
                            Char.getMyChar().arrItemBag[gameBM] = null;
                            super.left = super.center = null;
                            this.gameBB();
                            return;
                        }

                        if (var1 == gameCV.length - 1) {
                            GameCanvas.gameAA(mResources.gameNS);
                        }
                    }

                }
            }
        } catch (Exception var2) {
            GameCanvas.msgdlg.gameAA(mResources.gameAI, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
            var2.printStackTrace();
        }
    }

    private void gameKK() {
        Item var4;
        if (Char.getMyChar().arrItemBag[gameBM].gameAD()) {
            if (gameDD == null) {
                gameDD = Char.getMyChar().arrItemBag[gameBM];
                Char.getMyChar().arrItemBag[gameBM] = null;
            } else {
                var4 = Char.getMyChar().arrItemBag[gameBM];
                Char.getMyChar().arrItemBag[gameBM] = null;
                Char.getMyChar().arrItemBag[gameDD.indexUI] = gameDD;
                gameDD = var4;
            }

            super.left = super.center = null;
            this.gameBB();
        } else if (Char.getMyChar().arrItemBag[gameBM].gameAB()) {
            if (arritemup == null) {
                arritemup = Char.getMyChar().arrItemBag[gameBM];
                Char.getMyChar().arrItemBag[gameBM] = null;
            } else {
                var4 = Char.getMyChar().arrItemBag[gameBM];
                Char.getMyChar().arrItemBag[gameBM] = null;
                Char.getMyChar().arrItemBag[arritemup.indexUI] = arritemup;
                arritemup = var4;
            }

            super.left = super.center = null;
            this.gameBB();
        } else if (Char.getMyChar().arrItemBag[gameBM].template.type != 26 && Char.getMyChar().arrItemBag[gameBM].template.type != 28) {
            GameCanvas.msgdlg.gameAA(mResources.gameNM, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            int var1;
            if (Char.getMyChar().arrItemBag[gameBM].template.type == 28) {
                for (var1 = 0; var1 < upitem.length; ++var1) {
                    if (upitem[var1] != null && upitem[var1].template.type == 28) {
                        Item var2 = Char.getMyChar().arrItemBag[gameBM];
                        Char.getMyChar().arrItemBag[gameBM] = null;
                        int var3 = upitem[var1].indexUI;
                        Char.getMyChar().arrItemBag[var3] = upitem[var1];
                        upitem[var1] = var2;
                        return;
                    }
                }
            }

            for (var1 = 0; var1 < upitem.length; ++var1) {
                if (upitem[var1] == null) {
                    upitem[var1] = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                    super.left = super.center = null;
                    this.gameBB();
                    return;
                }
            }

            GameCanvas.msgdlg.gameAA(mResources.gameNS, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void gameAR(int var1) {
        MyVector var2 = new MyVector();
        if (var1 == 0) {
            var2.addElement(this.gameRO);
        } else if (var1 == 1) {
            var2.addElement(this.gameRP);
        } else if (var1 == 2) {
            var2.addElement(this.gameRQ);
        }

        if (arritemup != null && gameDD != null) {
            for (var1 = 0; var1 < upitem.length; ++var1) {
                if (upitem[var1] != null) {
                    var2.addElement(new Command(mResources.gameGC, 341));
                    break;
                }
            }
        }

        GameCanvas.menu.gameAA(var2);
    }

    private void gameAS(int var1) {
        Item var2 = gameDD;
        if (var1 == 1) {
            var2 = arritemup;
            arritemup = null;
        } else if (var1 == 2) {
            var2 = gameAN(47);
            upitem[gameBM] = null;
        } else {
            gameDD = null;
        }

        Char.getMyChar().arrItemBag[var2.indexUI] = var2;
        super.left = super.center = null;
        this.gameBB();
    }

    private static void gameKL() {
        int var0 = 0;

        for (int var1 = 0; var1 < upitem.length; ++var1) {
            if (upitem[var1] != null && upitem[var1].template.type == 26) {
                var0 += crystals[upitem[var1].template.id];
            }
        }

        boolean var3 = false;
        int var2 = 0;
        if (gameDD != null) {
            if (coinUpWeapons[gameDD.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                var3 = true;
            }

            var2 = var0 * 100 / upWeapon[gameDD.upgrade];
        }

        if (var3) {
            InfoMe.gameAA(mResources.gameQR, 15, mFont.tahoma_7_red);
        } else if (var2 > 250) {
            GameCanvas.gameAA(mResources.gameQS, new Command(mResources.YES, 342), new Command(mResources.NO, 1));
        } else {
            if (gameDD != null && arritemup != null && upitem.length > 0) {
                if (!arritemup.isLock) {
                    GameCanvas.gameAA(mResources.gameQT, new Command(mResources.YES, 342), new Command(mResources.NO, 1));
                    return;
                }

                Service.gI().gameAA((byte) 0, arritemup, gameDD, upitem);
            }

        }
    }

    private static void gameKM() {
        GameCanvas.endDlg();
        if (gameDD != null && arritemup != null && upitem.length > 0) {
            Service.gI().gameAA((byte) 0, arritemup, gameDD, upitem);
        }

    }

    private void gameBR(mGraphics var1) {
        if (gameMO) {
            if (gameBP == 0) {
                String[] var2 = mResources.gameHQ;
                GameScr var3 = this;

                try {
                    Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
                    gameAA(var1, var2[gameBP], var2.length > 1);
                    gameGA = popupX + 3;
                    gameGB = popupY + 34 + gameBL;
                    int var14 = popupX + 74;
                    int var4 = gameGB - gameBL - 3;
                    gameTD = 4;
                    int var5;
                    int var6;
                    if (gameDD != null) {
                        var3.gameAA(var1, gameDD, var14, var4);
                        var5 = var14 + 35;
                        var6 = var4 + 25;
                        GameScr var7 = var3;
                        int var8 = var3.gameVF[gameDD.upgrade][0];
                        int var9 = 0;
                        int var10;
                        if (gameDD.options != null) {
                            for (var10 = 0; var10 < gameDD.options.size(); ++var10) {
                                ItemOption var11;
                                if ((var11 = (ItemOption) gameDD.options.elementAt(var10)).optionTemplate.id == 104) {
                                    var9 = var11.param;
                                }
                            }
                        }

                        var10 = 0;

                        int var17;
                        for (var17 = 0; var17 < gameCV.length; ++var17) {
                            Item var12;
                            if ((var12 = gameCV[var17]) != null) {
                                var10 += var7.gameVF[var12.upgrade][1];
                            }
                        }

                        var1.gameAA(0);
                        var1.gameAD(var5, var6 - 5, 60, 5);
                        if ((var17 = var9 * 60 / var8) <= 0) {
                            var17 = 0;
                        } else if (var17 > 60) {
                            var17 = 60;
                        }

                        var1.gameAA(-16711936);
                        var1.gameAD(var5, var6 - 5, var17, 5);
                        int var18;
                        if ((var18 = var10 * 60 / var8) >= 60 - var17) {
                            var18 = 60 - var17;
                        }

                        var1.gameAA(-16346586);
                        var1.gameAD(var5 + var17, var6 - 5, var18, 5);
                        mFont.tahoma_7_yellow.gameAA(var1, var10 + var9 + "/" + var8, var5 + 30, var6 - 5 - 15, 2);
                    } else {
                        var1.gameAA(6425);
                        var1.gameAD(var14 - 1, var4 - 1, gameBL + 3, gameBL + 3);
                        SmallImage.gameAB(var1, 154, var14 + gameBL / 2, var4 + gameBL / 2, 0, 3);
                    }

                    var1.gameAA(12281361);
                    var1.gameAC(var14, var4, gameBL, gameBL);
                    var1.gameAA(6425);
                    var1.gameAD(gameGA - 1, gameGB - 1, gameBL * gameTC + 3, gameBL * gameTD + 3);

                    int var15;
                    for (var15 = 0; var15 < gameTD; ++var15) {
                        for (var5 = 0; var5 < gameTC; ++var5) {
                            SmallImage.gameAB(var1, 154, gameGA + var5 * gameBL + gameBL / 2, gameGB + var15 * gameBL + gameBL / 2, 0, 3);
                            var1.gameAA(12281361);
                            var1.gameAC(gameGA + var5 * gameBL, gameGB + var15 * gameBL, gameBL, gameBL);
                        }
                    }

                    for (var15 = 0; var15 < gameCV.length; ++var15) {
                        Item var16;
                        if ((var16 = gameCV[var15]) != null) {
                            var5 = var15 / gameTC;
                            var6 = var15 - var5 * gameTC;
                            if (!var16.isLock) {
                                var1.gameAA(12083);
                                var1.gameAD(gameGA + var6 * gameBL + 1, gameGB + var5 * gameBL + 1, gameBL - 1, gameBL - 1);
                            }

                            var3.gameAA(var1, var16, gameGA + var6 * gameBL, gameGB + var5 * gameBL);
                            if (var16.quantity > 1) {
                                mFont.number_yellow.gameAA(var1, String.valueOf(var16.quantity), gameGA + var6 * gameBL + gameBL, gameGB + var5 * gameBL + gameBL - mFont.number_yellow.gameAC(), 1);
                            }
                        }
                    }

                    if (gameHQ == 1) {
                        var1.gameAA(16777215);
                        var1.gameAC(var14, var4, gameBL, gameBL);
                        return;
                    }

                    if (gameHQ == 2) {
                        var15 = gameBM / gameTC;
                        var5 = gameBM - var15 * gameTC;
                        var1.gameAA(16777215);
                        var1.gameAC(gameGA + var5 * gameBL, gameGB + var15 * gameBL, gameBL, gameBL);
                        return;
                    }

                    return;
                } catch (Exception var13) {
                    var13.printStackTrace();
                    return;
                }
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHQ);
            }
        }

    }

    private void gameBS(mGraphics var1) {
        if (gameMP) {
            if (gameBP == 0) {
                String[] var2 = mResources.gameHP;
                GameScr var3 = this;

                try {
                    gameTD = 3;
                    Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
                    gameAA(var1, var2[gameBP], var2.length > 1);
                    gameGA = popupX + 3;
                    gameGB = popupY + 34 + gameBL;
                    int var10 = popupX + 45;
                    int var4 = popupX + 100;
                    int var5 = gameGB - gameBL - 3;
                    if (gameDD != null) {
                        var3.gameAA(var1, gameDD, var10, var5);
                    } else {
                        var1.gameAA(6425);
                        var1.gameAD(var10 - 1, var5 - 1, gameBL + 3, gameBL + 3);
                        SmallImage.gameAB(var1, 154, var10 + gameBL / 2, var5 + gameBL / 2, 0, 3);
                    }

                    var1.gameAA(12281361);
                    var1.gameAC(var10, var5, gameBL, gameBL);
                    if (arritemup != null) {
                        var3.gameAA(var1, arritemup, var4, var5);
                    } else {
                        var1.gameAA(6425);
                        var1.gameAD(var4 - 1, var5 - 1, gameBL + 3, gameBL + 3);
                        SmallImage.gameAB(var1, 154, var4 + gameBL / 2, var5 + gameBL / 2, 0, 3);
                    }

                    var1.gameAA(12281361);
                    var1.gameAC(var10, var5, gameBL, gameBL);
                    var1.gameAC(var4, var5, gameBL, gameBL);
                    mFont.tahoma_7b_yellow.gameAA(var1, "+", var10 + gameBL + 15, var5 + gameBL / 2 - 5, 2);
                    if (gameHQ == 1) {
                        if (gameBM == 0) {
                            var1.gameAA(16777215);
                            var1.gameAC(var10, var5, gameBL, gameBL);
                        }

                        if (gameBM == 1) {
                            var1.gameAA(16777215);
                            var1.gameAC(var4, var5, gameBL, gameBL);
                        }
                    }

                    int var11;
                    for (var11 = 0; var11 < gameTD; ++var11) {
                        for (var10 = 0; var10 < gameTC; ++var10) {
                            var1.gameAA(6425);
                            var1.gameAD(gameGA + var10 * gameBL, gameGB + var11 * gameBL, gameBL + 3, gameBL + 3);
                            SmallImage.gameAB(var1, 154, gameGA + var10 * gameBL + gameBL / 2, gameGB + var11 * gameBL + gameBL / 2, 0, 3);
                            var1.gameAA(12281361);
                            var1.gameAC(gameGA + var10 * gameBL, gameGB + var11 * gameBL, gameBL, gameBL);
                        }
                    }

                    if (gameHQ == 2) {
                        var11 = gameBM / gameTC;
                        var10 = gameBM - var11 * gameTC;
                        var1.gameAA(16777215);
                        var1.gameAC(gameGA + var10 * gameBL, gameGB + var11 * gameBL, gameBL, gameBL);
                    }

                    int var6;
                    int var7;
                    for (var11 = 0; var11 < upitem.length; ++var11) {
                        Item var8;
                        if ((var8 = upitem[var11]) != null) {
                            var6 = var11 / gameTC;
                            var7 = var11 - var6 * gameTC;
                            if (!var8.isLock) {
                                var1.gameAA(12083);
                                var1.gameAD(gameGA + var7 * gameBL + 1, gameGB + var6 * gameBL + 1, gameBL - 1, gameBL - 1);
                            }

                            SmallImage.gameAB(var1, var8.template.iconID, gameGA + var7 * gameBL + gameBL / 2, gameGB + var6 * gameBL + gameBL / 2, 0, 3);
                        }
                    }

                    if (arritemup != null && gameDD != null) {
                        var11 = 0;

                        for (var10 = 0; var10 < upitem.length; ++var10) {
                            if (upitem[var10] != null && upitem[var10].template.type == 26) {
                                var11 += crystals[upitem[var10].template.id];
                            }
                        }

                        if ((var10 = var11 * 100 / upWeapon[gameDD.upgrade]) > maxPercents[gameDD.upgrade]) {
                            var10 = maxPercents[gameDD.upgrade];
                        }

                        if (gameMB) {
                            var10 = (int) ((double) var10 * 5.30239915E-315D);
                        }

                        mFont var13 = mFont.tahoma_7_yellow;
                        var7 = 0;
                        if (gameDD.options != null) {
                            for (var6 = 0; var6 < gameDD.options.size(); ++var6) {
                                ItemOption var12;
                                if ((var12 = (ItemOption) gameDD.options.elementAt(var6)).optionTemplate.id == 123) {
                                    var7 = var12.param;
                                }
                            }
                        } else {
                            Service.gI().gameAC(gameDD.typeUI, gameDD.indexUI);
                        }

                        if (var7 > Char.getMyChar().xu + Char.getMyChar().yen) {
                            var13 = mFont.tahoma_7_red;
                        }

                        var13.gameAA(var1, mResources.gameAA(mResources.gameHZ, NinjaUtil.gameAA(String.valueOf(var7))), gameGA, gameGB + gameTD * gameBL + 5, 0);
                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameKC + ": " + var10 + "%", gameGA, gameGB + gameTD * gameBL + 17, 0);
                    } else {
                        for (var11 = 0; var11 < mResources.gameHW.length; ++var11) {
                            mFont.tahoma_7_white.gameAA(var1, mResources.gameHW[var11], gameGA, gameGB + gameTD * gameBL + 5 + var11 * 12, 0);
                        }
                    }

                    if (gameGG != null) {
                        SmallImage.gameAB(var1, gameGG.arrEfInfo[gameGF].idImg, var4 + gameBL / 2 + gameGG.arrEfInfo[gameGF].dx + 1, var5 + gameBL / 2 + 9 + gameGG.arrEfInfo[gameGF].dy, 0, 3);
                        if (GameCanvas.gameTick % 2 == 0 && ++gameGF >= gameGG.arrEfInfo.length) {
                            gameGF = 0;
                            gameGG = null;
                            return;
                        }
                    }

                    return;
                } catch (Exception var9) {
                    var9.printStackTrace();
                    return;
                }
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHP);
            }
        }

    }

    private void gameBT(mGraphics var1) {
        if (gameMQ) {
            if (gameBP == 0) {
                this.gameAA(var1, mResources.gameHS, (byte) 0);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHS);
            }
        }

    }

    private void gameBU(mGraphics var1) {
        if (gameMR) {
            if (gameBP == 0) {
                this.gameAA(var1, mResources.gameHT, (byte) 1);
                return;
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHT);
            }
        }

    }

    private void gameAA(mGraphics var1, String[] var2, byte var3) {
        try {
            gameTD = 5;
            Paint.gameAA(popupX, popupY, gameGC, gameGD, var1);
            gameAA(var1, var2, false);
            var1.gameAA(6693376);
            var1.gameAD(popupX + 3, popupY + 32, 168, 140);
            var1.gameAA(13408563);
            var1.gameAC(popupX + 3, popupY + 32, 168, 140);
            int var9 = popupX + 74;
            int var4 = popupY + 40 + gameBL;
            if (gameDD != null) {
                var1.gameAA(6425);
                var1.gameAD(var9 - 1, var4 - 1, gameBL + 3, gameBL + 3);
                SmallImage.gameAB(var1, 154, var9 + gameBL / 2, var4 + gameBL / 2, 0, 3);
                this.gameAA(var1, gameDD, var9, var4);
                if (gameDD.quantity > 1) {
                    mFont.number_yellow.gameAA(var1, "" + gameDD.quantity, var9 + gameBL, var4 + gameBL / 2 + 6, 1);
                }

                var1.gameAA(gameHQ == 1 ? 16777215 : 12281361);
                var1.gameAC(var9, var4, gameBL, gameBL);
            } else {
                var1.gameAA(6425);
                var1.gameAD(var9 - 1, var4 - 1, gameBL + 3, gameBL + 3);
                SmallImage.gameAB(var1, 154, var9 + gameBL / 2, var4 + gameBL / 2, 0, 3);
                var1.gameAA(12281361);
                var1.gameAC(var9, var4, gameBL, gameBL);
            }

            if (gameDD != null) {
                int var5 = 0;
                if (gameDD.options != null) {
                    for (int var6 = 0; var6 < gameDD.options.size(); ++var6) {
                        ItemOption var7;
                        if ((var7 = (ItemOption) gameDD.options.elementAt(var6)).optionTemplate.id == 122) {
                            var5 = var7.param;
                        }
                    }
                } else {
                    Service.gI().gameAC(gameDD.typeUI, gameDD.indexUI);
                }

                String var12 = mResources.gameSB;
                String var13 = var5 + mResources.gamePF;
                String var11 = mResources.gameAV;
                if (var3 == 0) {
                    var12 = mResources.gameSA;
                    var13 = coinGotngoc[gameDD.upgrade] + mResources.gamePE;
                    var11 = mResources.gameAU;
                }

                mFont.tahoma_7_white.gameAA(var1, var12, var9 + gameBL / 2, var4 + 3 * gameBL / 2 + 2, 2);
                mFont.tahoma_7_yellow.gameAA(var1, var13, var9 + gameBL / 2, var4 + 3 * gameBL / 2 + 14, 2);
                String[] var10 = mFont.tahoma_7_white.gameAB(var11, 130);

                for (var4 = 0; var4 < var10.length; ++var4) {
                    mFont.tahoma_7_white.gameAA(var1, var10[var4], var9 + gameBL / 2, popupY + gameGD - 25 + var4 * 12 - 2, 2);
                }

            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    private static void gameKN() {
        try {
            if (gameMQ) {
                if (Char.getMyChar().arrItemBag[gameBM].gameAD()) {
                    gameDD = Char.getMyChar().arrItemBag[gameBM];
                    Char.getMyChar().arrItemBag[gameBM] = null;
                    return;
                }
            } else if (gameMR && Char.getMyChar().arrItemBag[gameBM].gameAB()) {
                gameDD = Char.getMyChar().arrItemBag[gameBM];
                Char.getMyChar().arrItemBag[gameBM] = null;
                return;
            }

        } catch (Exception var0) {
            GameCanvas.msgdlg.gameAA(mResources.gameAJ, (Command) null, new Command(mResources.CLOSE, 2), (Command) null);
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void gameBV(mGraphics var1) {
        if (gameMT) {
            if (gameBP == 0) {
                Item[] var2 = gameCV;
                String[] var3 = mResources.gameHR;

                try {
                    gameAB(var1);
                    gameAA(var1, var3, true);
                    if (var2 == null) {
                        GameCanvas.gameAA(popupX + 90, popupY + 75, var1);
                        mFont.tahoma_7b_white.gameAA(var1, mResources.gameBG, popupX + 90, popupY + 90, 2);
                        return;
                    }

                    if (var2.length <= 30) {
                        gameTD = 5;
                    } else if (var2.length % gameTC == 0) {
                        gameTD = var2.length / gameTC;
                    } else {
                        gameTD = var2.length / gameTC + 1;
                    }

                    gameBU.gameAA(gameTD, gameBL, gameGA, gameGB, gameTC * gameBL, 5 * gameBL, true, 6);
                    gameBU.gameAA(var1, gameGA, gameGB, gameBU.width + 2, gameBU.height + 2);

                    int var4;
                    int var8;
                    for (var4 = 0; var4 < gameTD; ++var4) {
                        for (var8 = 0; var8 < gameTC; ++var8) {
                            SmallImage.gameAB(var1, 154, gameGA + var8 * gameBL + gameBL / 2, gameGB + var4 * gameBL + gameBL / 2, 0, 3);
                            var1.gameAA(12281361);
                            var1.gameAC(gameGA + var8 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
                        }
                    }

                    for (var4 = 0; var4 < var2.length; ++var4) {
                        Item var9;
                        if ((var9 = var2[var4]) != null) {
                            int var5 = var4 / gameTC;
                            int var6 = var4 - var5 * gameTC;
                            if (!var9.isLock) {
                                var1.gameAA(12083);
                                var1.gameAD(gameGA + var6 * gameBL + 1, gameGB + var5 * gameBL + 1, gameBL - 1, gameBL - 1);
                                SmallImage.gameAB(var1, 154, gameGA + var6 * gameBL + gameBL / 2, gameGB + var5 * gameBL + gameBL / 2, 0, 3);
                            }

                            SmallImage.gameAB(var1, var9.template.iconID, gameGA + var6 * gameBL + gameBL / 2, gameGB + var5 * gameBL + gameBL / 2, 0, 3);
                        }
                    }

                    if (gameHQ > 0 && gameBM >= 0) {
                        var4 = gameBM / gameTC;
                        var8 = gameBM - var4 * gameTC;
                        var1.gameAA(16777215);
                        var1.gameAC(gameGA + var8 * gameBL, gameGB + var4 * gameBL, gameBL, gameBL);
                        gameAA(gameGA + var8 * gameBL, gameGB + var4 * gameBL, var1);
                        return;
                    }

                    return;
                } catch (Exception var7) {
                    return;
                }
            }

            if (gameBP == 1) {
                this.gameAA(var1, mResources.gameHR);
            }
        }

    }

    private void gameKO() {
        for (int var1 = 0; var1 < gameCV.length; ++var1) {
            if (gameCV[var1] == null) {
                gameCV[var1] = Char.getMyChar().arrItemBag[gameBM];
                Char.getMyChar().arrItemBag[gameBM] = null;
                super.left = super.center = null;
                this.gameBB();
                return;
            }
        }

    }

    private void gameKP() {
        MyVector var1 = new MyVector();

        for (int var2 = 0; var2 < gameCV.length; ++var2) {
            if (gameCV[var2] != null) {
                var1.addElement(this.gameRL);
                break;
            }
        }

        if (gameCV.length > 0) {
            var1.addElement(new Command(mResources.gameHR[0], 403));
        }

        GameCanvas.menu.gameAA(var1);
    }

    private void gameKQ() {
        Item var1 = gameAN(48);
        gameCV[gameBM] = null;
        Char.getMyChar().arrItemBag[var1.indexUI] = var1;
        super.left = super.center = null;
        this.gameBB();
    }

    private static void gameKR() {
        Service.gI().gameAF(gameCV);
    }

    public static void gameAA(Mob var0, int var1) {
        MobTemplate var2;
        if ((var2 = Mob.arrMobTemplate[var0.templateId]).type != 0) {
            var0.dir = var1 % 3 == 0 ? -1 : 1;
            var0.x += 10 - var1 % 20;
        }

        Auto.gameAA(var0);
        if (!gameVJ.contains(var2) && !var0.isBoss && (var0.templateId != 179 && var0.templateId != 175 && var0.templateId != 202 || var0.status != 8)) {
            gameVJ.addElement(var2);
        }

        vMob.addElement(var0);
    }

    public static void gameAH(int var0) {
        Npc var1;
        if ((var1 = gameAI(var0)) != null) {
            Char.gameAC(var1.cx, var1.cy);
            Char.getMyChar().npcFocus = var1;
            Service.gI().gameAH(var1.template.npcTemplateId);
        }

    }

    public static void gameAB(int var0, int var1, int var2) {
        if (System.currentTimeMillis() < 500L) {
            try {
                Thread.sleep(500L - System.currentTimeMillis());
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }
        }

        Npc var3;
        if ((var3 = gameAI(var0)) != null) {
            Char.gameAC(var3.cx, var3.cy);
            Char.getMyChar().npcFocus = var3;
            Service.gI().gameAC(var0, var1, var2);
        }

    }

    public static void PickNpc(int var0, int var1, int var2) {
        if (System.currentTimeMillis() < 500L) {
            try {
                Thread.sleep(500L - System.currentTimeMillis());
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }
        }

        Npc var3;
        if ((var3 = gameAI(var0)) != null) {
            Char.gameAC(var3.cx, var3.cy);
            Char.getMyChar().npcFocus = var3;
            if (var0 == 8) {
                Service.gI().gameAC(var0, var1, var2);
            } else {
                Service.gI().gameAC(var0, var1, 0);
                Service.gI().gameAC(var0, var2, 0);
            }
        }

    }

    public static Npc gameAI(int var0) {
        Char var1 = Char.getMyChar();
        MyVector var2 = vNpc;
        int var3 = -1;
        Npc var4 = null;

        for (int var5 = 0; var5 < var2.size(); ++var5) {
            Npc var6;
            if ((var6 = (Npc) var2.elementAt(var5)) != null && var0 == var6.template.npcTemplateId) {
                int var7 = Res.gameAA(var1.cx, var1.cy, var6.cx, var6.cy);
                if (var3 == -1 || var7 < var3) {
                    var3 = var7;
                    var4 = var6;
                }
            }
        }

        return var4;
    }

    public static void gameAC(String var0) {
        ChatPopup.gameAA("[" + mResources.nameHienThi + "] " + var0, Char.getMyChar());
    }

    public static void gameAJ(int var0) {
        (new Thread(new DoiKhu(var0))).start();
    }

    public static void gameAA(GameScr var0, byte var1) {
        var0.gameAE(var1);
    }

    static {
        GameCanvas.gameBX = GameCanvas.gameAC("/Big4.png");
        GameCanvas.gameBW = GameCanvas.gameAC("/plus12.png");
        GameCanvas.imgBGitem = GameCanvas.gameAC("/bgitem.png");
        GameCanvas.imgBGitem0 = GameCanvas.gameAC("/bgitem0.png");
        GameCanvas.imgBGitem1 = GameCanvas.gameAC("/bgitem1.png");
        GameCanvas.imgBGitem2 = GameCanvas.gameAC("/bgitem2.png");
        GameCanvas.imgBGitem3 = GameCanvas.gameAC("/bgitem3.png");
        GameCanvas.imgBGitem4 = GameCanvas.gameAC("/bgitem4.png");
        GameCanvas.bgitem1x1 = GameCanvas.gameAC("/bgitem4x1.png");
        GameCanvas.bgitem1x2 = GameCanvas.gameAC("/bgitem4x2.png");
        GameCanvas.bgitem1x3 = GameCanvas.gameAC("/bgitem4x3.png");
        GameCanvas.bgitem1x4 = GameCanvas.gameAC("/bbgitem4x4.png");

        GameCanvas.bgitem2x1 = GameCanvas.gameAC("/bgitem8x1.png");
        GameCanvas.bgitem2x2 = GameCanvas.gameAC("/bgitem8x2.png");
        GameCanvas.bgitem2x3 = GameCanvas.gameAC("/bgitem8x3.png");
        GameCanvas.bgitem2x4 = GameCanvas.gameAC("/bgitem8x4.png");

        GameCanvas.bgitem3x1 = GameCanvas.gameAC("/bgitem11x1.png");
        GameCanvas.bgitem3x2 = GameCanvas.gameAC("/bgitem11x2.png");
        GameCanvas.bgitem3x3 = GameCanvas.gameAC("/bgitem11x3.png");
        GameCanvas.bgitem3x4 = GameCanvas.gameAC("/bgitem11x4.png");

        GameCanvas.bgitem4x1 = GameCanvas.gameAC("/bgitem14x1.png");
        GameCanvas.bgitem4x2 = GameCanvas.gameAC("/bgitem14x2.png");
        GameCanvas.bgitem4x3 = GameCanvas.gameAC("/bgitem14x3.png");
        GameCanvas.bgitem4x4 = GameCanvas.gameAC("/bgitem14x4.png");

        GameCanvas.bgitem5x1 = GameCanvas.gameAC("/bgitem16x1.png");
        GameCanvas.bgitem5x2 = GameCanvas.gameAC("/bgitem16x2.png");
        GameCanvas.bgitem5x3 = GameCanvas.gameAC("/bgitem16x3.png");
        GameCanvas.bgitem5x4 = GameCanvas.gameAC("/bgitem16x4.png");

        GameCanvas.bgitem6x1 = GameCanvas.gameAC("/bgitem17x1.png");
        GameCanvas.bgitem6x2 = GameCanvas.gameAC("/bgitem17x2.png");
        GameCanvas.bgitem6x3 = GameCanvas.gameAC("/bgitem17x3.png");
        GameCanvas.bgitem6x4 = GameCanvas.gameAC("/bgitem17x4.png");
        
        GameCanvas.bgitem7x1 = GameCanvas.gameAC("/bgitem18x1.png");
        GameCanvas.bgitem7x2 = GameCanvas.gameAC("/bgitem18x2.png");
        GameCanvas.bgitem7x3 = GameCanvas.gameAC("/bgitem18x3.png");
        GameCanvas.bgitem7x4 = GameCanvas.gameAC("/bgitem18x4.png");
        
        GameCanvas.bgitem8x1 = GameCanvas.gameAC("/bgitem19x1.png");
        GameCanvas.bgitem8x2 = GameCanvas.gameAC("/bgitem19x2.png");
        GameCanvas.bgitem8x3 = GameCanvas.gameAC("/bgitem19x3.png");
        GameCanvas.bgitem8x4 = GameCanvas.gameAC("/bgitem19x4.png");
        
        GameCanvas.bgitem9x1 = GameCanvas.gameAC("/bgitem20x1.png");
        GameCanvas.bgitem9x2 = GameCanvas.gameAC("/bgitem20x2.png");
        GameCanvas.bgitem9x3 = GameCanvas.gameAC("/bgitem20x3.png");
        GameCanvas.bgitem9x4 = GameCanvas.gameAC("/bgitem20x4.png");
        
        gameNZ = GameCanvas.gameAC("/trung1.png");
        gameNT = GameCanvas.gameAC("/u/select.png");
        imgTf = GameCanvas.gameAC("/hd/tf.png");
        gameFM = GameCanvas.gameAC("/eff/g132.png");
        imgEffMob1 = GameCanvas.gameAC("/eff/g10.png");
        imgEffMob2 = GameCanvas.gameAC("/eff/g6.png");
        imgEffMob3 = GameCanvas.gameAC("/eff/g99.png");
        imgsmokeFollow = GameCanvas.gameAC("/eff/g9.png");
        if (GameCanvas.isTouch) {
            gameNM = GameCanvas.gameAC("/hd/button.png");
            gameNN = GameCanvas.gameAC("/hd/button2.png");
            gameNO = GameCanvas.gameAC("/hd/hpp.png");
            gameNP = GameCanvas.gameAC("/hd/mpp.png");
            gameNQ = GameCanvas.gameAC("/hd/right.png");
            gameNR = GameCanvas.gameAC("/hd/right2.png");
            gameNS = GameCanvas.gameAC("/hd/skill.png");
            imgLbtn = GameCanvas.gameAC("/hd/btnl.png");
            imgLbtnFocus = GameCanvas.gameAC("/hd/btnlf.png");
            gameNH = GameCanvas.gameAC("/hd/arrow.png");
            gameNI = GameCanvas.gameAC("/hd/arrow2.png");
            gameNJ = GameCanvas.gameAC("/hd/chat.png");
            gameNL = GameCanvas.gameAC("/hd/focus.png");
            gameNK = GameCanvas.gameAC("/hd/menu.png");
            gameNF = GameCanvas.gameAC("/hd/topbar.png");
            gameNG = GameCanvas.gameAC("/hd/transparent.png");
            gameEU = GameCanvas.gameAC("/hd/mapborder.png");
        }

        imgMatcho = GameCanvas.gameAC("/hd/mat.png");
        imgFiremoto = GameCanvas.gameAC("/hd/lua.png");
        byte[] var0 = RMS.gameAB("dataVersion");
        byte[] var1 = RMS.gameAB("mapVersion");
        byte[] var2 = RMS.gameAB("skillVersion");
        byte[] var3 = RMS.gameAB("itemVersion");
        if (var0 != null) {
            gameEL = var0[0];
        }

        if (var1 != null) {
            gameEM = var1[0];
        }

        if (var2 != null) {
            gameEN = var2[0];
        }

        if (var3 != null) {
            gameEO = var3[0];
        }

        gamePA = new Skill[3];
        gamePB = new Skill[5];
        gameFV = 0;
        gameQJ = new int[5];
        gameQK = new int[5];
        gameQL = new int[5];
        gameQM = new int[5];
        gameQN = new int[5];
        gameQI = new String[5];
        gameQO = new int[8];

        for (int var4 = 0; var4 < 5; ++var4) {
            gameQN[var4] = -1;
        }

        gameGC = 140;
        gameGD = 160;
        gameTC = 6;
        gameGF = 0;
        gameGL = 0;
        gameVJ = new MyVector();
        gameGP = 1;
        gameGQ = true;
    }
}
