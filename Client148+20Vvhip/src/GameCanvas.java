
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class GameCanvas extends GameGraphics implements IActionListener {

    public static boolean gameAA = false;
    public static boolean gameAB = true;
    public static boolean isGPRS = true;
    public static boolean gameAD = false;
    public static boolean isLoading;
    public static boolean isTouch = false;
    public static boolean gameAG;
    public static boolean gameAH;
    public static boolean gameAI;
    public static GameCanvas instance;
    public static boolean[] keyPressedz = new boolean[14];
    private static boolean[] keyReleasedz = new boolean[14];
    public static boolean[] keyHold = new boolean[14];
    public static boolean isPointerDown;
    public static boolean isPointerClick;
    public static boolean isPointerJustRelease;
    public static int px;
    public static int py;
    public static int pxLast;
    public static int pyLast;
    public static Position[] arrPos = new Position[4];
    public static int gameTick;
    public static int gameAV;
    public static boolean gameAW;
    public static boolean gameAX;
    private static long gameCA;
    private static long gameCB;
    public static boolean gameAY;
    public static int w;
    public static int h;
    public static int hw;
    public static int hh;
    public static mScreen currentScreen;
    public static Menu menu = new Menu();
    public static SelectServerScr selectsvScr;
    public static LoginScr loginScr;
    public static LanguageScr languageScr;
    public static Dialog currentDialog;
    public static MsgDlg msgdlg;
    public static InputDlg inputDlg;
    public static Input2Dlg gameBL;
    private static Image[] gameCC;
    private static int gameCD;
    private static int gameCE = 0;
    public static int gameBM;
    private static int[] gameCF;
    private mGraphics gameCG = new mGraphics();
    private static boolean gameCH;
    private static int gameCI;
    private static int gameCJ;
    private static int gameCK;
    private static int gameCL;
    private static int gameCM;
    private static int gameCN;
    private static int gameCO;
    private static Image gameCP;
    private static Image gameCQ;
    public static Image[] imgBorder = new Image[2];
    public static int borderConnerW;
    public static int borderConnerH;
    private static int[] gameCR;
    private static int[] gameCS;
    private static int gameCT;
    private static int gameCU;
    public static int typeBg = -1;
    private static long gameCV = 0L;
    public static int gameBR;
    private static int[] gameCW;
    private int[] gameCX;
    private int[] gameCY;
    private int[] gameCZ;
    private static int[] gameDA;
    private static int[] gameDB;
    private static int[] gameDC;
    private static Image[] gameDD;
    private static Image gameDE;
    private static Image[][] gameDF;
    private boolean gameDG;
    public static boolean gameBS;
    private static Image[][] gameDH = new Image[4][];
    private static Image[] gameDI = new Image[4];
    private static Image[] gameDJ = new Image[2];
    public static int gameBT;
    public static long gameBU;
    public static long gameBV;
    public static Image gameBW;
    public static Image gameBX;
    public static nameBQ gameBY;

    public static Image imgBGitem;
    public static Image imgBGitem0;
    public static Image imgBGitem1;
    public static Image imgBGitem2;
    public static Image imgBGitem3;
    public static Image imgBGitem4;
    public static Image bgitem1x1, bgitem1x2, bgitem1x3, bgitem1x4;
    public static Image bgitem2x1, bgitem2x2, bgitem2x3, bgitem2x4;
    public static Image bgitem3x1, bgitem3x2, bgitem3x3, bgitem3x4;
    public static Image bgitem4x1, bgitem4x2, bgitem4x3, bgitem4x4;
    public static Image bgitem5x1, bgitem5x2, bgitem5x3, bgitem5x4;
    public static Image bgitem6x1, bgitem6x2, bgitem6x3, bgitem6x4;
    public static Image bgitem7x1, bgitem7x2, bgitem7x3, bgitem7x4;
    public static Image bgitem8x1, bgitem8x2, bgitem8x3, bgitem8x4;
    public static Image bgitem9x1, bgitem9x2, bgitem9x3, bgitem9x4;

    public GameCanvas() {
        MotherCanvas var1;
        (var1 = MotherCanvas.gI()).setFullScreenMode(true);
        var1.gameAB = this;
        w = var1.gameAC();
        h = var1.gameAB();
        hw = w / 2;
        hh = h / 2;
        gameAY = System.getProperty("microedition.platform").indexOf("RIM") == 0;
        if (MotherCanvas.instance.hasPointerEvents()) {
            isTouch = true;
            if (w >= 240) {
                gameAG = true;
            }

            if (w < 320) {
                gameAH = true;
            }

            if (w >= 320) {
                gameAI = true;
            }
        }

        gameBY = new nameBQ();
        int var3;
        if ((var3 = RMS.gameAD("indLanguage")) < 0) {
            mResources.languageID = 0;
        } else {
            mResources.languageID = var3;
        }

        mResources.gameAB();
        msgdlg = new MsgDlg();
        if (h <= 160) {
            Paint.hTab = 15;
            mScreen.cmdH = 17;
        }

        instance = this;
        System.gc();
        new Paint();
        gameDH[0] = new Image[17];

        for (var3 = 0; var3 < 17; ++var3) {
            gameDH[0][var3] = gameAC("/bg/bg0" + var3 + ".png");
        }

        gameDH[1] = new Image[17];

        for (var3 = 0; var3 < 17; ++var3) {
            gameDH[1][var3] = gameAC("/bg/bg1" + var3 + ".png");
        }

        gameDH[2] = new Image[17];

        for (var3 = 0; var3 < 17; ++var3) {
            gameDH[2][var3] = gameAC("/bg/bg2" + var3 + ".png");
        }

        gameDH[3] = new Image[15];

        for (var3 = 0; var3 < 15; ++var3) {
            gameDH[3][var3] = gameAC("/bg/bg3" + var3 + ".png");
        }

        for (var3 = 0; var3 < 4; ++var3) {
            gameDI[var3] = gameAC("/bg/cl" + var3 + ".png");
        }

        gameDJ[0] = gameAC("/bg/sun0.png");
        gameDJ[1] = gameAC("/bg/sun1.png");
        TileMap.gameAI();
        if (!gameAA) {
            if (gameDF == null) {
                gameDF = new Image[2][5];

                for (var3 = 0; var3 < 2; ++var3) {
                    for (int var2 = 0; var2 < 5; ++var2) {
                        gameDF[var3][var2] = gameAC("/e/d" + var3 + var2 + ".png");
                    }
                }
            }

            this.gameCX = new int[2];
            this.gameCY = new int[2];
            this.gameCZ = new int[2];
            this.gameCZ[0] = this.gameCZ[1] = -1;
        }

        gameAQ();
        gameDE = gameAC("/u/f.png");
        if (isTouch) {
            for (var3 = 0; var3 < 2; ++var3) {
                imgBorder[var3] = gameAC("/hd/bd" + var3 + ".png");
            }

            borderConnerW = mGraphics.gameAA(imgBorder[0]);
            borderConnerH = mGraphics.gameAB(imgBorder[0]);
            mGraphics.gameAA(imgBorder[1]);
            mGraphics.gameAB(imgBorder[1]);
        } else if (RMS.gameAD("lowGraphic") == 1) {
            gameAA = true;
        }

        SmallImage.gameAC();
        mScreen.gameBP();
        languageScr = new LanguageScr();
    }

    public static GameCanvas gameAB() {
        if (instance == null) {
            instance = new GameCanvas();
        }

        return instance;
    }

    public static void gameAC() {
        Session_ME.gameAA().gameAA(GameMidlet.IP, GameMidlet.PORT);
    }

    public static void gameAD() {
        w = MotherCanvas.instance.gameAC();
        h = MotherCanvas.instance.gameAB();
        hw = w / 2;
        hh = h / 2;
        loginScr = new LoginScr();
        selectsvScr = new SelectServerScr();
        new RegisterScr();
        inputDlg = new InputDlg();
        gameBL = new Input2Dlg();
    }

    public final void gameAA() {
        if (gameBT > 0) {
            if ((gameBV = System.currentTimeMillis()) - gameBU >= 1000L) {
                if (--gameBT == 0) {
                    Session_ME.gameAA().gameAD();
                }

                gameBU = gameBV;
            }
        } else if (Session_ME.gameAA().gameAF && System.currentTimeMillis() - Session_ME.gameAA().gameAJ > 300000L) {
            Session_ME.gameAA().gameAD();
        }

        long var1;
        if ((var1 = System.currentTimeMillis()) - gameCA >= 780L && !gameAW) {
            gameCA = var1;
            gameAW = true;
        } else {
            gameAW = false;
        }

        if (var1 - gameCB >= 7800L && !gameAX) {
            gameCB = var1;
            gameAX = true;
        } else {
            gameAX = false;
        }

        if (gameAV > 0) {
            --gameAV;
        }

        if (++gameTick > 10000) {
            gameTick = 0;
        }

        if (currentScreen != null) {
            if (currentDialog != null) {
                currentDialog.gameAA();
            } else if (menu.showMenu) {
                menu.gameAB();
                menu.gameAA();
            }

            if (!isLoading) {
                currentScreen.gameAC();
            }

            currentScreen.gameAD();
        }

        long var3 = System.currentTimeMillis();
        if (RMS.gameAK && var3 > RMS.gameAJ) {
            RMS.gameAK = false;

            try {
                if (RMS.gameAI > 0) {
                    GameScr.gI().perform((int) RMS.gameAI, (Object) null);
                }
            } catch (Exception var5) {
            }
        }

        InfoDlg.gameAC();
        if (this.gameDG) {
            this.gameAE();
        }

        MotherCanvas.instance.repaint();
        MotherCanvas.instance.serviceRepaints();
    }

    public final void gameAE() {
        this.gameDG = false;
        selectsvScr.gameAB();

        try {
            Char.gameAJ();
            GameScr.gameAN();
            GameScr.gameAA();
            endDlg();
            InfoDlg.gameAD();
            GameScr.gameAA(true);
            GameScr.cmx = 100;
            gameAC(TileMap.bgID);
            GameScr.vParty.removeAllElements();
            GameScr.vClan.removeAllElements();
            GameScr.vFriend.removeAllElements();
            GameScr.vEnemies.removeAllElements();
            Char.clan = null;
        } catch (Exception var2) {
        }
    }

    public static void gameAF() {
        if (gameAD && --gameBM < 0) {
            gameAD = false;
        }

    }

    public static void gameAG() {
        if (!gameAA && gameCP != null) {
            for (int var0 = 0; var0 < gameCR.length; ++var0) {
                if (gameTick % (var0 + 2 << 3) == 0) {
                    int var10002 = gameCR[var0]++;
                    if (gameCR[var0] > GameScr.gW + (mGraphics.gameAA(gameCP) >> 1)) {
                        gameCR[var0] = -(mGraphics.gameAA(gameCP) >> 1);
                    }
                }
            }
        }

    }

    public static void gameAA(mGraphics var0) {
        if (gameAD) {
            if (gameTick % 10 > 7) {
                var0.gameAA(16777215);
            } else {
                var0.gameAA(0);
            }

            var0.gameAD(0, 0, GameScr.gW, GameScr.gH);
        } else if (gameCH && !gameAA && gameCC != null) {
            var0.gameAA(gameCD);
            var0.gameAD(0, 0, GameScr.gW, gameCI);
            int var1;
            if (typeBg >= 0 && typeBg <= 1) {
                if (gameCC[0] != null) {
                    for (var1 = -((GameScr.cmx >> 1) % 24); var1 < GameScr.gW; var1 += 24) {
                        var0.gameAA(gameCC[0], var1, gameCJ, 0);
                    }
                }

                if (gameCC[1] != null) {
                    for (var1 = -((GameScr.cmx >> 2) % 24); var1 < GameScr.gW; var1 += 24) {
                        var0.gameAA(gameCC[1], var1, gameCK, 0);
                    }
                }

                if (gameCC[3] != null) {
                    for (var1 = -((GameScr.cmx >> 4) % 64); var1 < GameScr.gW; var1 += 64) {
                        var0.gameAA(gameCC[3], var1, gameCM, 0);
                    }
                }

                if (gameCQ != null) {
                    var0.gameAA(gameCQ, gameCT, gameCU, 3);
                }

                if (gameCP != null) {
                    for (var1 = 0; var1 < 2; ++var1) {
                        var0.gameAA(gameCP, gameCR[var1], gameCS[var1], 3);
                    }
                }

                if (gameCC[2] != null) {
                    for (var1 = -((GameScr.cmx >> 3) % 192); var1 < GameScr.gW; var1 += 192) {
                        var0.gameAA(gameCC[2], var1, gameCL, 0);
                    }

                    return;
                }
            } else if (typeBg >= 2 && typeBg <= 6) {
                if (gameCQ != null) {
                    var0.gameAA(gameCQ, gameCT, gameCU, 3);
                }

                if (gameCP != null) {
                    for (var1 = 0; var1 < gameCR.length; ++var1) {
                        var0.gameAA(gameCP, gameCR[var1], gameCS[var1], 3);
                    }
                }

                if (typeBg != 2) {
                    if (gameCC[3] != null) {
                        for (var1 = -((GameScr.cmx >> gameCW[3]) % gameCF[3]); var1 < GameScr.gW; var1 += gameCF[3]) {
                            var0.gameAA(gameCC[3], var1, gameCM, 0);
                        }
                    }

                    if (gameCC[2] != null) {
                        for (var1 = -((GameScr.cmx >> gameCW[2]) % gameCF[2]); var1 < GameScr.gW; var1 += gameCF[2]) {
                            var0.gameAA(gameCC[2], var1, gameCL, 0);
                        }
                    }

                    if (gameCC[1] != null) {
                        for (var1 = -((GameScr.cmx >> gameCW[1]) % gameCF[1]); var1 < GameScr.gW; var1 += gameCF[1]) {
                            var0.gameAA(gameCC[1], var1, gameCO, 0);
                        }
                    }

                    if (gameCC[0] != null) {
                        for (var1 = -((GameScr.cmx >> gameCW[0]) % gameCF[0]); var1 < GameScr.gW; var1 += gameCF[0]) {
                            var0.gameAA(gameCC[0], var1, gameCN, 0);
                        }

                        return;
                    }
                }
            } else if (typeBg >= 7 && typeBg <= 16) {
                var0.gameAA(gameCD);
                var0.gameAD(0, 0, GameScr.gW, GameScr.gH);
                if (typeBg != 8 && gameCC[3] != null) {
                    for (var1 = -((GameScr.cmx >> gameCW[3]) % gameCF[3]); var1 < GameScr.gW; var1 += gameCF[3]) {
                        if (typeBg != 11 && typeBg != 12) {
                            var0.gameAA(gameCC[3], var1, gameCM, 0);
                        } else {
                            var0.gameAA(gameCC[3], var1, GameScr.gH - mGraphics.gameAB(gameCC[3]), 0);
                        }
                    }
                }

                if (typeBg != 8 && typeBg != 11 && typeBg != 12 && gameCC[2] != null) {
                    if (TileMap.mapID == 45) {
                        var0.gameAA(gameCC[2], GameScr.gW, gameCL, 0);
                    } else {
                        for (var1 = -((GameScr.cmx >> gameCW[2]) % gameCF[2]); var1 < GameScr.gW; var1 += gameCF[2]) {
                            if (typeBg == 14) {
                                var0.gameAA(gameCC[2], var1, gameCL + 12, 0);
                            } else {
                                var0.gameAA(gameCC[2], var1, gameCL, 0);
                            }
                        }
                    }
                }

                if (typeBg != 11 && typeBg != 12 && gameCC[1] != null && TileMap.mapID != 52) {
                    for (var1 = -((GameScr.cmx >> gameCW[1]) % gameCF[1]); var1 < GameScr.gW; var1 += gameCF[1]) {
                        var0.gameAA(gameCC[1], var1, gameCO, 0);
                    }
                }

                if (TileMap.mapID == 45 || TileMap.mapID == 55) {
                    var0.gameAA(1114112);
                    var0.gameAD(0, gameCN + 20, GameScr.gW, GameScr.gH);
                }

                if (gameCC[0] != null) {
                    for (var1 = -((GameScr.cmx >> gameCW[0]) % gameCF[0]); var1 < GameScr.gW; var1 += gameCF[0]) {
                        var0.gameAA(gameCC[0], var1, gameCN, 0);
                    }
                }

                if (gameCP != null) {
                    if (typeBg != 13 && typeBg != 15) {
                        for (var1 = 0; var1 < 2; ++var1) {
                            var0.gameAA(gameCP, gameCR[var1], gameCS[var1], 3);
                        }

                        return;
                    }

                    for (var1 = 0; var1 < 2; ++var1) {
                        var0.gameAA(gameCP, gameCR[var1], gameCS[var1] - 130, 3);
                    }

                    return;
                }
            }

        } else {
            var0.gameAA(gameCD);
            var0.gameAD(0, 0, GameScr.gW, GameScr.gH);
        }
    }

    public static void gameAH() {
        gameCC = null;
        gameCP = null;
        gameCQ = null;
    }

    public static void gameAC(int var0) {
        byte var1;
        byte var2;
        byte var3;
        label218:
        {
            var1 = 0;
            var2 = 0;
            var3 = 0;
            typeBg = var0;
            switch (var0) {
                case 2:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 3:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 4:
                    var1 = 9;
                    var2 = 6;
                    break;
                case 5:
                    gameCW = new int[]{1, 1, 1, 1};
                    break label218;
                case 6:
                    var1 = 12;
                    break;
                case 7:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 8:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 9:
                    var1 = 16;
                    var2 = 10;
                    var3 = 6;
                    break;
                case 10:
                    gameCW = new int[]{1, 1, 1, 1};
                    break label218;
                case 11:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 12:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 13:
                    var1 = 60;
                    break;
                case 14:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 15:
                    gameCW = new int[]{1, 2, 3, 4};
                    break label218;
                case 16:
                    break;
                default:
                    break label218;
            }

            gameCW = new int[]{1, 2, 3, 4};
        }

        gameCD = StaticObj.SKYCOLOR[typeBg];

        int var4;
        try {
            if (!gameAA) {
                gameCC = new Image[4];
                gameCF = new int[4];

                for (var4 = 0; var4 < 4; ++var4) {
                    try {
                        if (StaticObj.TYPEBG[typeBg][var4] != -1) {
                            gameCC[var4] = gameDH[var4][StaticObj.TYPEBG[typeBg][var4]];
                        }
                    } catch (Exception var6) {
                    }

                    if (gameCC[var4] != null) {
                        gameCF[var4] = mGraphics.gameAA(gameCC[var4]);
                    }
                }

                if (typeBg == 10) {
                    gameCC[1] = gameDH[0][9];
                    gameCC[2] = gameDH[0][9];
                    gameCF[1] = mGraphics.gameAA(gameCC[1]);
                    gameCF[2] = mGraphics.gameAA(gameCC[2]);
                }

                if (typeBg == 12) {
                    gameCC[3] = gameDH[3][9];
                    gameCF[3] = mGraphics.gameAA(gameCC[3]);
                }

                if (typeBg == 14) {
                    if (isTouch) {
                        gameCO = (gameCN = h - mGraphics.gameAB(gameCC[0])) - mGraphics.gameAB(gameCC[1]);
                    } else {
                        gameCO = (gameCN = h - mGraphics.gameAB(gameCC[0]) - 45) - mGraphics.gameAB(gameCC[1]);
                    }
                }

                if (typeBg == 15 && isTouch) {
                    gameCO = (gameCN = h - mGraphics.gameAB(gameCC[0])) - mGraphics.gameAB(gameCC[1]) + 100;
                }

                if (typeBg == 16) {
                    if (isTouch) {
                        gameCO = (gameCN = h - mGraphics.gameAB(gameCC[0])) - mGraphics.gameAB(gameCC[1]) + 100;
                    } else {
                        gameCO = (gameCN = h - mGraphics.gameAB(gameCC[0]) - 40) - mGraphics.gameAB(gameCC[1]) + 100;
                    }
                }
            }

            if (typeBg >= 0 && typeBg <= 1) {
                gameCP = gameDI[0];
                gameCQ = gameDJ[0];
            } else {
                gameCP = null;
                gameCQ = null;
            }

            if (typeBg == 2) {
                gameCP = gameDI[1];
                gameCQ = gameDJ[1];
            }

            if (typeBg == 7 || typeBg == 11 || typeBg == 12) {
                if (TileMap.mapID == 20) {
                    gameCP = null;
                } else {
                    gameCP = gameDI[0];
                }
            }

            if (var0 == 13 || var0 == 15) {
                gameCP = gameDI[2];
            }
        } catch (Exception var7) {
        }

        gameCH = false;
        if (!gameAA) {
            gameCH = true;
            if (gameCC[0] != null && gameCC[1] != null && gameCC[2] != null) {
                gameCI = GameScr.gH - (mGraphics.gameAB(gameCC[0]) + mGraphics.gameAB(gameCC[1]) + mGraphics.gameAB(gameCC[2])) + 11;
            }

            if (gameCC[0] != null) {
                gameCJ = GameScr.gH - mGraphics.gameAB(gameCC[0]);
            }

            if (gameCC[1] != null) {
                gameCK = gameCJ - mGraphics.gameAB(gameCC[1]);
            }

            if (gameCC[2] != null) {
                gameCL = gameCK - mGraphics.gameAB(gameCC[2]);
            }

            if (gameCC[3] != null) {
                gameCM = gameCK - mGraphics.gameAB(gameCC[3]) - 10;
            }

            if (typeBg >= 2 && typeBg <= 13) {
                gameCN = var4 = GameScr.gH - mGraphics.gameAB(gameCC[0]);
                if (gameCC[1] != null) {
                    var4 = var4 - mGraphics.gameAB(gameCC[1]) + var1;
                }

                gameCO = var4;
                if (gameCC[3] != null) {
                    var4 = var4 - mGraphics.gameAB(gameCC[3]) + var3;
                }

                gameCM = var4;
                gameCI = var4;
                if (gameCC[2] != null) {
                    gameCL = gameCO - mGraphics.gameAB(gameCC[2]) + var2;
                }

                if (typeBg == 2) {
                    gameCI = h;
                }
            }
        }

        if (typeBg >= 2 && typeBg <= 12) {
            var4 = 2 * GameScr.gH / 3 - gameCO;
        } else {
            var4 = 2 * GameScr.gH / 3 - gameCK;
        }

        if (var4 < 0) {
            var4 = 0;
        }

        if (TileMap.mapID == 48 && TileMap.mapID == 51) {
            gameCN += var4;
        }

        if (typeBg >= 2 && typeBg <= 6) {
            gameCO += var4;
        }

        gameCI += var4;
        gameCJ += var4;
        gameCK += var4;
        gameCL += var4;
        gameCM += var4;
        gameCT = 3 * GameScr.gW / 4;
        gameCU = gameCI / 3;
        gameCR = new int[2];
        gameCS = new int[2];
        gameCR[0] = GameScr.gW / 3;
        gameCS[0] = gameCI / 2 - 8;
        gameCR[1] = 2 * GameScr.gW / 3;
        gameCS[1] = gameCI / 2 + 8;
        if (typeBg == 2) {
            gameCU = gameCI / 5;
            gameCR = new int[5];
            gameCS = new int[5];
            gameCR[0] = GameScr.gW / 3;
            gameCS[0] = gameCI / 3 - 35;
            gameCR[1] = 3 * GameScr.gW / 4;
            gameCS[1] = gameCI / 3 + 12;
            gameCR[2] = GameScr.gW / 3 - 15;
            gameCS[2] = gameCI / 3 + 12;
            gameCR[3] = GameScr.gW / 15;
            gameCS[3] = gameCI / 2 + 12;
            gameCR[4] = 2 * GameScr.gW / 3 + 25;
            gameCS[4] = gameCI / 3 + 12;
        }

        if (!gameAA) {
            if (typeBg == 8) {
                gameCN = gameCO = GameScr.gameAF - 50;
            }

            if (typeBg == 10 && gameCC[3] != null) {
                gameCM = gameCL - mGraphics.gameAB(gameCC[3]);
            }

            if (typeBg == 11 || typeBg == 12) {
                gameCM = 0;
            }
        }

    }

    protected final void gameAA(int var1) {
        gameCV = System.currentTimeMillis();
        if (var1 >= 48 && var1 <= 57 || var1 >= 65 && var1 <= 122 || var1 == 10 || var1 == 8 || var1 == 13 || var1 == 32) {
            gameBR = var1;
        }

        if (currentDialog != null) {
            currentDialog.gameAA(var1);
            gameBR = 0;
        } else {
            currentScreen.gameAA(var1);
            switch (var1) {
                case -39:
                case -2:
                    keyHold[8] = true;
                    keyPressedz[8] = true;
                    return;
                case -38:
                case -1:
                    keyHold[2] = true;
                    keyPressedz[2] = true;
                    return;
                case -37:
                case -36:
                case -35:
                case -34:
                case -33:
                case -32:
                case -31:
                case -30:
                case -29:
                case -28:
                case -27:
                case -26:
                case -25:
                case -24:
                case -23:
                case -20:
                case -19:
                case -18:
                case -17:
                case -16:
                case -15:
                case -14:
                case -13:
                case -12:
                case -11:
                case -10:
                case -9:
                case -8:
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                default:
                    return;
                case -22:
                case -7:
                    keyHold[13] = true;
                    keyPressedz[13] = true;
                    return;
                case -21:
                case -6:
                    keyHold[12] = true;
                    keyPressedz[12] = true;
                    return;
                case -5:
                case 10:
                    keyHold[5] = true;
                    keyPressedz[5] = true;
                    return;
                case -4:
                    keyHold[6] = true;
                    keyPressedz[6] = true;
                    return;
                case -3:
                    keyHold[4] = true;
                    keyPressedz[4] = true;
                    return;
                case 35:
                    keyHold[11] = true;
                    keyPressedz[11] = true;
                    return;
                case 42:
                    keyHold[10] = true;
                    keyPressedz[10] = true;
                    return;
                case 48:
                    keyHold[0] = true;
                    keyPressedz[0] = true;
                    return;
                case 49:
                    if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                        keyHold[1] = true;
                        keyPressedz[1] = true;
                    }

                    return;
                case 50:
                    if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow && !GameScr.gameDH) {
                        keyHold[2] = true;
                        keyPressedz[2] = true;
                    }

                    return;
                case 51:
                    if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                        keyHold[3] = true;
                        keyPressedz[3] = true;
                    }

                    return;
                case 52:
                    if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow && !GameScr.gameDH) {
                        keyHold[4] = true;
                        keyPressedz[4] = true;
                    }

                    return;
                case 53:
                    if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow && !GameScr.gameDH) {
                        keyHold[5] = true;
                        keyPressedz[5] = true;
                    }

                    return;
                case 54:
                    if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow && !GameScr.gameDH) {
                        keyHold[6] = true;
                        keyPressedz[6] = true;
                    }

                    return;
                case 55:
                    keyHold[7] = true;
                    keyPressedz[7] = true;
                    return;
                case 56:
                    if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow && !GameScr.gameDH) {
                        keyHold[8] = true;
                        keyPressedz[8] = true;
                    }

                    return;
                case 57:
                    keyHold[9] = true;
                    keyPressedz[9] = true;
            }
        }
    }

    protected final void gameAB(int var1) {
        gameBR = 0;
        switch (var1) {
            case -39:
            case -2:
                keyHold[8] = false;
                return;
            case -38:
            case -1:
                keyHold[2] = false;
                return;
            case -37:
            case -36:
            case -35:
            case -34:
            case -33:
            case -32:
            case -31:
            case -30:
            case -29:
            case -28:
            case -27:
            case -26:
            case -25:
            case -24:
            case -23:
            case -20:
            case -19:
            case -18:
            case -17:
            case -16:
            case -15:
            case -14:
            case -13:
            case -12:
            case -11:
            case -10:
            case -9:
            case -8:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            default:
                return;
            case -22:
            case -7:
                keyHold[13] = false;
                keyReleasedz[13] = true;
                return;
            case -21:
            case -6:
                keyHold[12] = false;
                keyReleasedz[12] = true;
                return;
            case -5:
            case 10:
                keyHold[5] = false;
                keyReleasedz[5] = true;
                return;
            case -4:
                keyHold[6] = false;
                return;
            case -3:
                keyHold[4] = false;
                return;
            case 35:
                keyHold[11] = false;
                keyReleasedz[11] = true;
                return;
            case 42:
                keyHold[10] = false;
                keyReleasedz[10] = true;
                return;
            case 48:
                keyHold[0] = false;
                keyReleasedz[0] = true;
                return;
            case 49:
                if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                    keyHold[1] = false;
                    keyReleasedz[1] = true;
                }

                return;
            case 50:
                if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                    keyHold[2] = false;
                    keyReleasedz[2] = true;
                }

                return;
            case 51:
                if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                    keyHold[3] = false;
                    keyReleasedz[3] = true;
                }

                return;
            case 52:
                if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                    keyHold[4] = false;
                    keyReleasedz[4] = true;
                }

                return;
            case 53:
                if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                    keyHold[5] = false;
                    keyReleasedz[5] = true;
                }

                return;
            case 54:
                if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                    keyHold[6] = false;
                    keyReleasedz[6] = true;
                }

                return;
            case 55:
                keyHold[7] = false;
                keyReleasedz[7] = true;
                return;
            case 56:
                if (currentScreen == GameScr.instance && gameAB && !ChatTextField.gameAA().isShow) {
                    keyHold[8] = false;
                    keyReleasedz[8] = true;
                }

                return;
            case 57:
                keyHold[9] = false;
                keyReleasedz[9] = true;
        }
    }

    protected final void setSize(int var1, int var2) {
        if (Res.abs(var1 - pxLast) >= 10 || Res.abs(var2 - pyLast) >= 10) {
            isPointerClick = false;
        }

        px = var1;
        py = var2;
        if (++gameCE > 3) {
            gameCE = 0;
        }

        arrPos[gameCE] = new Position(var1, var2);
    }

    public static boolean gameAI() {
        return System.currentTimeMillis() - gameCV >= 800L;
    }

    protected final void gameAA(int var1, int var2) {
        isPointerDown = true;
        isPointerClick = true;
        gameCV = System.currentTimeMillis();
        pxLast = var1;
        pyLast = var2;
        px = var1;
        py = var2;
    }

    protected final void gameAC(int var1, int var2) {
        isPointerDown = false;
        isPointerJustRelease = true;
        mScreen.keyTouch = -1;
        px = var1;
        py = var2;
    }

    public static boolean gameAA(int var0, int var1, int var2, int var3) {
        int var4 = px + GameScr.cmx;
        int var5 = GameScr.cmy + py;
        return (isPointerDown || isPointerJustRelease) && var4 >= var0 && var4 <= var0 + var2 && var5 >= var1 && var5 <= var1 + var3;
    }

    public static boolean gameAA(int var0, int var1, int var2, int var3, Scroll var4) {
        int var5 = px + var4.cmx;
        int var6 = var4.cmy + py;
        return (isPointerDown || isPointerJustRelease) && var5 >= var0 && var5 <= var0 + var2 && var6 >= var1 && var6 <= var1 + var3;
    }

    public static boolean gameAB(int var0, int var1, int var2, int var3) {
        return (isPointerDown || isPointerJustRelease) && px >= var0 && px <= var0 + var2 && py >= var1 && py <= var1 + var3;
    }

    public static void gameAJ() {
        for (int var0 = 0; var0 < 14; ++var0) {
            keyPressedz[var0] = false;
        }

        isPointerJustRelease = false;
    }

    public static void gameAK() {
        for (int var0 = 0; var0 < 14; ++var0) {
            keyHold[var0] = false;
        }

    }

    protected final void gameAA(Graphics var1) {
        this.gameCG.gameAA = var1;

        try {
            if (currentScreen != null && !isLoading) {
                currentScreen.gameAA(this.gameCG);
                this.gameCG.gameAE(0, 0, w, h);
            }

            this.gameCG.gameAA(-this.gameCG.gameAA(), -this.gameCG.gameAB());
            this.gameCG.gameAE(0, 0, w, h);
            InfoDlg.gameAA(this.gameCG);
            if (currentDialog != null) {
                currentDialog.gameAA(this.gameCG);
            } else if (menu.showMenu) {
                menu.gameAA(this.gameCG);
            }

            GameScr.gameAB(this.gameCG);
            if (gameBT > 0) {
                Paint.gameAA(30, h - 118, w - 60, 80, this.gameCG);
                gameAA(hw, h - 98, this.gameCG);
                mFont.tahoma_8b.gameAA(this.gameCG, "Xin chờ " + gameBT + "s...", hw, h - 78, 2);
            }
        } catch (Exception var2) {
        }
    }

    public static void endDlg() {
        inputDlg.tfInput.gameAB(500);
        gameBL.tfInput.gameAB(500);
        gameBL.tfInput2.gameAB(500);
        currentDialog = null;
    }

    public static void gameAA(String var0) {
        msgdlg.gameAA(var0, (Command) null, new Command(mResources.OK, instance, 8882, (Object) null), (Command) null);
        currentDialog = msgdlg;
    }

    public static void gameAB(String var0) {
        msgdlg.gameAA(var0, (Command) null, new Command(mResources.CANCEL, instance, 8882, (Object) null), (Command) null);
        currentDialog = msgdlg;
        msgdlg.isWait = true;
    }

    public static void gameAM() {
        gameAB(mResources.gameBG);
    }

    public static void gameAN() {
        msgdlg.timeShow = 500;
        msgdlg.gameAA(mResources.gameBG, (Command) null, (Command) null, (Command) null);
        currentDialog = msgdlg;
        msgdlg.isWait = true;
    }

    public final void gameAA(String var1, String var2, String var3, String var4) {
        msgdlg.gameAA(var4, new Command(var1, this, 8881, var3), (Command) null, new Command(var2, this, 8882, (Object) null));
        currentDialog = msgdlg;
    }

    public final void gameAA(String var1, String var2, short var3, String var4, String var5) {
        MyVector var6;
        (var6 = new MyVector()).addElement(new Short(var3));
        var6.addElement(var4);
        msgdlg.gameAA(var5, new Command(var1, this, 8883, var6), (Command) null, new Command(var2, this, 8882, (Object) null));
        currentDialog = msgdlg;
    }

    public static void gameAA(String var0, int var1) {
        msgdlg.gameAA(var0, (Command) null, new Command(mResources.OK, instance, var1, w / 2 - 35, h - 50), (Command) null);
        currentDialog = msgdlg;
    }
    public static void gameAAaz(String var0, int var1, Object var2) {
        msgdlg.gameAA(var0, (Command) null, new Command(mResources.OK, instance, var1, (Object) null, w / 2 - 35, h - 50), (Command) null);
        currentDialog = msgdlg;
    }

    public static void gameAA(String var0, int var1, Object var2, int var3, Object var4) {
        msgdlg.gameAA(var0, new Command(mResources.YES, instance, var1, var2), new Command("", instance, var1, var2), new Command(mResources.NO, instance, var3, var4));
        currentDialog = msgdlg;
    }

    public static void gameAA(String var0, Command var1, Command var2) {
        msgdlg.gameAA(var0, var1, (Command) null, var2);
        currentDialog = msgdlg;
    }

    public static Image gameAC(String var0) {
        var0 = "/x" + mGraphics.zoomLevel + var0;

        try {
            return Image.createImage(var0);
        } catch (Exception var1) {
            return null;
        }
    }

    public final boolean gameAA(int var1, int var2, int var3) {
        if (gameAA) {
            return false;
        } else {
            var1 = var1 == 1 ? 0 : 1;
            if (this.gameCZ[var1] != -1) {
                return false;
            } else {
                this.gameCZ[var1] = 0;
                this.gameCX[var1] = var2;
                this.gameCY[var1] = var3;
                return true;
            }
        }
    }

    private static void gameAQ() {
        if (!gameAA) {
            gameDD = new Image[3];

            for (int var0 = 0; var0 < 3; ++var0) {
                gameDD[var0] = gameAC("/e/w" + var0 + ".png");
            }

            gameDA = new int[2];
            gameDB = new int[2];
            (gameDC = new int[2])[0] = gameDC[1] = -1;
        }

    }

    public static boolean gameAD(int var0, int var1) {
        if (gameAA) {
            return false;
        } else {
            int var2 = gameDC[0] == -1 ? 0 : 1;
            if (gameDC[var2] != -1) {
                return false;
            } else {
                gameDC[var2] = 0;
                gameDA[var2] = var0;
                gameDB[var2] = var1;
                return true;
            }
        }
    }

    public final void gameAO() {
        if (!gameAA) {
            for (int var1 = 0; var1 < 2; ++var1) {
                if (this.gameCZ[var1] != -1) {
                    int var10002 = this.gameCZ[var1]++;
                    if (this.gameCZ[var1] >= 5) {
                        this.gameCZ[var1] = -1;
                    }

                    if (var1 == 0) {
                        var10002 = this.gameCX[var1]--;
                    } else {
                        var10002 = this.gameCX[var1]++;
                    }

                    var10002 = this.gameCY[var1]--;
                }
            }
        }

    }

    public static boolean gameAE(int var0, int var1) {
        return var0 >= GameScr.cmx && var0 <= GameScr.cmx + GameScr.gW && var1 >= GameScr.cmy && var1 <= GameScr.cmy + GameScr.gH + 30;
    }

    public final void gameAB(mGraphics var1) {
        if (!gameAA) {
            for (int var2 = 0; var2 < 2; ++var2) {
                if (this.gameCZ[var2] != -1 && gameAE(this.gameCX[var2], this.gameCY[var2])) {
                    var1.gameAA(gameDF[var2][this.gameCZ[var2]], this.gameCX[var2], this.gameCY[var2], 3);
                }
            }
        }

    }

    public static void gameAA(int var0, int var1, mGraphics var2) {
        int var3 = gameTick % 3;
        var2.gameAA(gameDE, 0, var3 << 4, 16, 16, 0, var0, var1, 3);
    }

    public final void gameAP() {
        isLoading = false;
        this.gameDG = true;
    }

    public static boolean gameAC(int var0, int var1, int var2, int var3) {
        return (isPointerDown || isPointerJustRelease) && px >= var0 && px <= var0 + var2 && py >= var1 && py <= var1 + var3;
    }

    public final void perform(int var1, Object var2) {
        String var16;
        Item[] var18;
        String var12;
        short var13;
        Char var14;
        int var15;
        switch (var1) {
            case 1608:
                Service.gI().gameAA((String) gameBL.tfInput.gameAD(), (String) gameBL.tfInput2.gameAD(), (byte) 0);
                endDlg();
                return;
            case 1700:
                Service.gI().gameAA((short) 100, inputDlg.tfInput.gameAD(), GameScr.gameGL);
                endDlg();
                return;
            case 8881:
                NinjaUtil.gameAB((String) var2);
                currentDialog = null;
                return;
            case 8882:
                currentDialog = null;
                return;
            case 8883:
                var13 = ((Short) ((MyVector) var2).elementAt(0)).shortValue();
                NinjaUtil.gameAA((String) ((MyVector) var2).elementAt(0), var13);
                currentDialog = null;
                return;
            case 8884:
                endDlg();
                selectsvScr.gameAB();
                return;
            case 8885:
                GameMidlet.instance.notifyDestroyed();
                return;
            case 8887:
                endDlg();
                var1 = ((Integer) var2).intValue();
                Service.gI().gameAT(var1);
                return;
            case 8888:
                var1 = ((Integer) var2).intValue();
                Service.gI().gameAU(var1);
                endDlg();
                return;
            case 8889:
                var12 = (String) var2;
                endDlg();
                Service.gI().gameAI(var12);
                return;
            case 8890:
                endDlg();
                Service.gI().gameAO(((Integer) var2).intValue());
                return;
            case 16081:
                Service.gI().gameAA((String) gameBL.tfInput.gameAD(), (String) gameBL.tfInput2.gameAD(), (byte) 1);
                endDlg();
                return;
            case 88810:
                var1 = ((Integer) var2).intValue();
                endDlg();
                Service.gI().gameAL(var1);
                return;
            case 88811:
                endDlg();
                Service.gI().gameAH();
                return;
            case 88812:
                var14 = (Char) var2;
                endDlg();
                Service.gI().gameAP(var14.charID);
                return;
            case 88813:
                endDlg();
                var18 = (Item[]) var2;
                Service.gI().gameAA(var18);
                return;
            case 88814:
                var18 = (Item[]) var2;
                endDlg();
                Service.gI().gameAB(var18);
                return;
            case 88815:
                GameScr.gI();
                GameScr.gameBF();
                return;
            case 88816:
                Service.gI().gameAB(gameBL.tfInput.gameAD(), gameBL.tfInput2.gameAD());
                endDlg();
                return;
            case 88817:
                if (Char.getMyChar().npcFocus != null) {
                    Service.gI().gameAC(Char.getMyChar().npcFocus.template.npcTemplateId, menu.menuSelectedItem, 0);
                    return;
                }

                Service.gI().gameAC(0, menu.menuSelectedItem, 0);
                return;
            case 88818:
                var13 = ((Short) var2).shortValue();
                Service.gI().gameAA(var13, inputDlg.tfInput.gameAD());
                endDlg();
                return;
            case 88819:
                var13 = ((Short) var2).shortValue();
                Service.gI().gameAA(var13);
                GameScr.gI().gameBG();
                return;
            case 88820:
                String[] var17 = (String[]) var2;
                if (Char.getMyChar().npcFocus == null) {
                    return;
                }

                Integer var3 = new Integer(menu.menuSelectedItem);
                if (var17.length <= 1) {
                    ChatPopup.gameAA("", 1, Char.getMyChar().npcFocus);
                    Service.gI().gameAC(Char.getMyChar().npcFocus.template.npcTemplateId, var3.intValue(), 0);
                    return;
                }

                MyVector var4 = new MyVector();

                for (var1 = 0; var1 < var17.length - 1; ++var1) {
                    var4.addElement(new Command(var17[var1 + 1], instance, 88821, var3));
                }

                menu.gameAA(var4);
                return;
            case 88821:
                var1 = ((Integer) var2).intValue();
                ChatPopup.gameAA("", 1, Char.getMyChar().npcFocus);
                Service.gI().gameAC(Char.getMyChar().npcFocus.template.npcTemplateId, var1, menu.menuSelectedItem);
                return;
            case 88822:
                ChatPopup.gameAA("", 1, Char.getMyChar().npcFocus);
                Service.gI().gameAC(Char.getMyChar().npcFocus.template.npcTemplateId, menu.menuSelectedItem, 0);
                return;
            case 88823:
                gameAA(mResources.gameFZ);
                return;
            case 88824:
                gameAA(mResources.gameGA);
                return;
            case 88825:
                gameAA(mResources.gameUY);
                return;
            case 88826:
                gameAA(mResources.gameVA);
                return;
            case 88827:
                gameAA(mResources.gameUZ);
                return;
            case 88828:
                gameAA(mResources.gameVB);
                return;
            case 88829:
                if ((var12 = inputDlg.tfInput.gameAD()).equals("")) {
                    return;
                }

                Service.gI().gameAA(var12, ((Integer) var2).intValue());
                gameAB(mResources.gameBG);
                return;
            case 88830:
                var1 = ((Integer) var2).intValue();
                endDlg();
                Service.gI().gameBG(var1);
                return;
            case 88831:
                var1 = ((Integer) var2).intValue();
                endDlg();
                Service.gI().gameBH(var1);
                return;
            case 88832:
                var12 = inputDlg.tfInput.gameAD();
                endDlg();
                if (!var12.equals("")) {
                    Service.gI().gameAO(var12);
                    return;
                }
                break;
            case 88833:
                var12 = inputDlg.tfInput.gameAD();
                endDlg();
                if (!var12.equals("")) {
                    try {
                        var1 = Integer.parseInt(var12);
                        if (Char.getMyChar().xu >= var1 && var1 >= 0) {
                            Service.gI().gameBI(var1);
                            return;
                        }

                        InfoMe.gameAA(mResources.gameVC, 20, mFont.tahoma_7_yellow);
                        return;
                    } catch (Exception var11) {
                        return;
                    }
                }
                break;
            case 88834:
                var12 = inputDlg.tfInput.gameAD();
                endDlg();
                if (!var12.equals("")) {
                    try {
                        if ((var1 = Integer.parseInt(var12)) <= 0) {
                            return;
                        }

                        Service.gI().gameBJ(var1);
                        return;
                    } catch (Exception var10) {
                        return;
                    }
                }
                break;
            case 88835:
                var1 = Integer.parseInt((String) var2);
                var15 = Integer.parseInt(inputDlg.tfInput.gameAD());
                currentDialog = null;
                if (var15 > 0 && var15 < Char.getMyChar().arrItemBag[var1].quantity) {
                    Service.gI().gameAK(var1, var15);
                    return;
                }

                gameAA(mResources.gameVD);
                return;
            case 88836:
                inputDlg.tfInput.gameAB(6);
                inputDlg.gameAA(mResources.gameUC, new Command(mResources.ACCEPT, instance, 888361, (Object) null), 1);
                return;
            case 88837:
                var12 = inputDlg.tfInput.gameAD();
                endDlg();

                try {
                    Service.gI().gameBM(Integer.parseInt(var12.trim()));
                    return;
                } catch (Exception var9) {
                    return;
                }
            case 88838:
                var12 = gameBL.tfInput.gameAD().trim();
                var16 = gameBL.tfInput2.gameAD().trim();
                endDlg();
                if (var12.length() >= 6 && var16.length() >= 6) {
                    try {
                        var1 = Integer.parseInt(var12);
                        var15 = Integer.parseInt(var16);
                        if (var1 >= 99999 && var15 >= 99999) {
                            Service.gI().gameAL(var1, var15);
                            return;
                        }

                        gameAA(mResources.gameTY);
                        return;
                    } catch (Exception var8) {
                        gameAA(mResources.gameTX);
                        return;
                    }
                }

                gameAA(mResources.gameTW);
                return;
            case 88839:
                var12 = inputDlg.tfInput.gameAD();
                endDlg();

                try {
                    gameAA(mResources.gameVF, 888391, var12, 8882, (Object) null);
                    return;
                } catch (Exception var7) {
                    InfoMe.gameAA(mResources.gameTZ, 20, mFont.tahoma_7_yellow);
                    return;
                }
            case 88840:
                var14 = (Char) var2;
                endDlg();
                Service.gI().gameAM(var14.charID);
                return;
            case 88841:
                var14 = (Char) var2;
                endDlg();
                Service.gI().gameAN(var14.charID);
                return;
            case 88842:
                Service.gI().gameBC();
                return;
            case 88843:
                var16 = inputDlg.tfInput.gameAD();
                endDlg();
                if (var16.equals("")) {
                    gameAA(mResources.gameVE);
                    return;
                }

                Service.gI().gameAS(var16);
                return;
            case 888181:
                var13 = ((Short) var2).shortValue();
                Service.gI().gameAB(var13, inputDlg.tfInput.gameAD());
                endDlg();
                return;
            case 888361:
                var12 = inputDlg.tfInput.gameAD();
                endDlg();
                if (var12.length() >= 6 && !var12.equals("")) {
                    try {
                        Service.gI().gameBK(Integer.parseInt(var12));
                        return;
                    } catch (Exception var6) {
                        gameAA(mResources.gameTX);
                        return;
                    }
                }

                gameAA(mResources.gameTW);
                return;
            case 888391:
                try {
                    endDlg();
                    var15 = Integer.parseInt((String) var2);
                    Service.gI().gameBL(var15);
                    return;
                } catch (Exception var5) {
                    return;
                }
        }

    }
}
