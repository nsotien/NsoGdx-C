
import javax.microedition.lcdui.Image;

public final class SelectServerScr extends mScreen implements IActionListener {

    private int popupW;
    private int popupH;
    private int popupX;
    private int popupY;
    private int indexRow = -1;
    private static String[] menu;
    public static String uname = RMS.gameAC("acc");
    public static String pass = RMS.gameAC("pass");
    public static String unameChange = "";
    public static String passChange = "";
    private static Command cmdChoiMoi = null;
    private static Command cmdDoiTaiKhoan = null;
    private static Command cmdChoiTiep = null;
    private static Command cmdChonServer = null;
    private static Command cmdUpdLinkSv = null;
    private static Command[][] cmd = null;

//    public SelectServerScr() {
//        GameCanvas.menu.menuSelectedItem = mResources.serverST[0];
//        GameMidlet.IP = mResources.listIP[GameCanvas.menu.menuSelectedItem];
//        int var1 = RMS.gameAD("indServer");
//
//        for (int var2 = 0; var2 < mResources.serverST.length; ++var2) {
//            if (var1 == mResources.serverST[var2]) {
//                GameCanvas.menu.menuSelectedItem = mResources.serverST[var2];
//                GameMidlet.IP = mResources.listIP[var2];
//                return;
//            }
//        }
//
//    }
    public SelectServerScr() {
        GameCanvas.menu.menuSelectedItem = UpdateServer.serverST[0];
        GameMidlet.IP = UpdateServer.listIP[GameCanvas.menu.menuSelectedItem];
        int var1 = RMS.gameAD("indServer");

        for (int var2 = 0; var2 < UpdateServer.serverST.length; ++var2) {
            if (var1 == UpdateServer.serverST[var2]) {
                GameCanvas.menu.menuSelectedItem = UpdateServer.serverST[var2];
                GameMidlet.IP = UpdateServer.listIP[var2];
                return;
            }
        }

    }

    public final void gameAB() {
        GameScr.gH = GameCanvas.h;
        if (GameCanvas.typeBg == 2) {
            GameCanvas.gameAC(0);
        } else {
            GameCanvas.gameAC(TileMap.bgID);
        }

        super.gameAB();
        if (GameScr.instance != null) {
            GameScr.instance = null;
        }

        if ((TileMap.bgID = (byte) ((int) (System.currentTimeMillis() % 9L))) == 5 || TileMap.bgID == 6) {
            TileMap.bgID = 4;
        }

        GameScr.gameAA(true);
        GameScr.cmx = 100;
        this.popupW = 170;
        this.popupH = 175;
        if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
            this.popupW = 126;
            this.popupH = 160;
        }

        this.popupX = GameCanvas.w / 2 - this.popupW / 2;
        this.popupY = GameCanvas.h / 2 - this.popupH / 2;
        if (GameCanvas.h <= 250) {
            this.popupY -= 10;
        }

        super.right = new Command(mResources.EXIT, GameCanvas.instance, 8885, (Object) null);
        this.indexRow = -1;
        if (!GameCanvas.isTouch) {
            this.indexRow = 0;
        }

        if (GameCanvas.isTouch && GameCanvas.w >= 320) {
            super.right.x = GameCanvas.w / 2 + 88;
        }

        if (cmdChoiMoi == null) {
            cmdChoiMoi = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1000, (Object) null);
            cmdDoiTaiKhoan = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1001, (Object) null);
            cmdChonServer = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1002, (Object) null);
            cmdChoiTiep = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1003, (Object) null);
            cmdUpdLinkSv = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1004,(Object) null);
            
            cmd = new Command[][]{{cmdChoiMoi, cmdDoiTaiKhoan, cmdChonServer, cmdUpdLinkSv}, {cmdChoiTiep, cmdChoiMoi, cmdDoiTaiKhoan, cmdChonServer, cmdUpdLinkSv}};
//         cmd = new Command[][]{{cmdChoiMoi, cmdDoiTaiKhoan, cmdChonServer}, {cmdChoiTiep, cmdChoiMoi, cmdDoiTaiKhoan, cmdChonServer}};
        }

        if ((uname == null || uname.equals("")) && unameChange.equals("")) {
            menu = new String[]{mResources.NEW_PLAY, mResources.CHANGE_ACC, mResources.SERVER, mResources.gameXK};
        } else {
            menu = new String[]{mResources.COUNTINUE_PLAY, mResources.NEW_PLAY, mResources.CHANGE_ACC, mResources.SERVER, mResources.gameXK};
        }
        GameCanvas.menu.menuSelectedItem = UpdateServer.serverST[0];
        GameMidlet.IP = UpdateServer.listIP[GameCanvas.menu.menuSelectedItem];
        int var1 = RMS.gameAD("indServer");

        for (int var2 = 0; var2 < UpdateServer.serverST.length; ++var2) {
            if (var1 == UpdateServer.serverST[var2]) {
                GameCanvas.menu.menuSelectedItem = UpdateServer.serverST[var2];
                GameMidlet.IP = UpdateServer.listIP[var2];
                return;
            }
        }

//        GameCanvas.menu.menuSelectedItem = mResources.serverST[0];
//        GameMidlet.IP = mResources.listIP[0];
//
//        for (int var1 = 0; var1 < mResources.serverST.length; ++var1) {
//            if (RMS.gameAD("indServer") == mResources.serverST[var1]) {
//                GameCanvas.menu.menuSelectedItem = mResources.serverST[var1];
//                GameMidlet.IP = mResources.listIP[var1];
//                break;
//            }
//        }
        if (RMS.gameAC("random") == null) {
            RMS.gameAA("random", gameAE());
        }

    }

    public final void gameAA(mGraphics var1) {
        var1.gameAA(0);
        var1.gameAD(0, 0, GameCanvas.w, GameCanvas.h);
        GameCanvas.gameAA(var1);
        Image var2 = LoginScr.gameAA();
        var1.gameAA(var2, GameCanvas.hw - var2.getWidth() / 2, this.popupY - var2.getHeight() / 2 - 20, 0);
        if (GameCanvas.menu.menuSelectedItem == -1) {
            GameCanvas.menu.menuSelectedItem = 0;
        }

        int var4 = this.popupY + 50;

        for (int var3 = 0; var3 < menu.length; ++var3) {
            var1.gameAA(Paint.COLORDARK);
            var1.gameAD(this.popupX + 10, var4 + var3 * 35, this.popupW - 20, 28);
            Paint.gameAB(this.popupX + 10, var4 + var3 * 35, this.popupW - 20, 28, var1);
            if (var3 == this.indexRow) {
                var1.gameAA(Paint.COLORLIGHT);
                var1.gameAD(this.popupX + 10, var4 + var3 * 35, this.popupW - 20, 28);
                Paint.gameAB(this.popupX + 10, var4 + var3 * 35, this.popupW - 20, 28, var1);
            }

//            if (var3 < menu.length) {
//                if (uname.equals("") && unameChange.equals("")) {
//                    if (var3 == 2) {
//                        mFont.tahoma_7b_white.gameAA(var1, menu[var3] + mResources.listName[GameCanvas.menu.menuSelectedItem], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
//                    } else {
//                        mFont.tahoma_7b_white.gameAA(var1, menu[var3], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
//                    }
//                } else if (var3 == 0) {
//                    mFont.tahoma_7b_white.gameAA(var1, menu[var3] + (!unameChange.equals("") ? ": " + unameChange : (uname.startsWith("tmpusr") ? "" : ": " + uname)), this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
//                } else if (var3 == 3) {
//                    mFont.tahoma_7b_white.gameAA(var1, menu[var3] + mResources.listName[GameCanvas.menu.menuSelectedItem], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
//                } else {
//                    mFont.tahoma_7b_white.gameAA(var1, menu[var3], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
//                }
//            }
            if (var3 < menu.length) {
                if (uname.equals("") && unameChange.equals("")) {
                    if (var3 == 2) {
                        mFont.tahoma_7b_white.gameAA(var1, menu[var3] + UpdateServer.listName[GameCanvas.menu.menuSelectedItem], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
                    } else {
                        mFont.tahoma_7b_white.gameAA(var1, menu[var3], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
                    }
                } else if (var3 == 0) {
                    mFont.tahoma_7b_white.gameAA(var1, menu[var3] + (!unameChange.equals("") ? ": " + unameChange : (uname.startsWith("tmpusr") ? "" : ": " + uname)), this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
                } else if (var3 == 3) {
                    mFont.tahoma_7b_white.gameAA(var1, menu[var3] + UpdateServer.listName[GameCanvas.menu.menuSelectedItem], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
                } else {
                    mFont.tahoma_7b_white.gameAA(var1, menu[var3], this.popupX + this.popupW / 2, var4 + var3 * 35 + 8, 2);
                }
            }
        }

        if (GameCanvas.currentDialog == null) {
            Paint.gameAA(var1, super.left, super.center, super.right);
        }

        super.gameAA(var1);
    }

    public final void gameAC() {
        if (uname.equals("") && unameChange.equals("")) {
            if (this.indexRow >= 0 && this.indexRow < cmd[0].length) {
                super.center = cmd[0][this.indexRow];
            }
        } else if (this.indexRow >= 0 && this.indexRow < cmd[1].length) {
            super.center = cmd[1][this.indexRow];
        }

        if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
            GameScr.cmx = 100;
        }

        super.gameAC();
    }

    public final void gameAD() {
        if (!GameCanvas.keyPressedz[2] && !GameCanvas.keyPressedz[4]) {
            if (GameCanvas.keyPressedz[8] || GameCanvas.keyPressedz[6]) {
                ++this.indexRow;
                if (this.indexRow > menu.length - 1) {
                    this.indexRow = 0;
                }
            }
        } else {
            --this.indexRow;
            if (this.indexRow < 0) {
                this.indexRow = menu.length - 1;
            }
        }

        if (GameCanvas.isPointerJustRelease && GameCanvas.gameAB(this.popupX + 10, this.popupY + 45, this.popupW - 10, 140)) {
            if (GameCanvas.isPointerClick) {
                this.indexRow = (GameCanvas.py - (this.popupY + 45)) / 35;
            }

            if (uname.equals("") && unameChange.equals("")) {
                if (this.indexRow >= 0 && this.indexRow < cmd[0].length) {
                    cmd[0][this.indexRow].gameAA();
                }
            } else if (this.indexRow >= 0 && this.indexRow < cmd[1].length) {
                cmd[1][this.indexRow].gameAA();
            }
        }

        super.gameAD();
        GameCanvas.gameAJ();
    }

    private static void gameAF() {
        if (!Session_ME.gameAA().gameAF) {
            GameCanvas.gameAC();
        }

        GameCanvas.gameAM();
    }

    public static boolean gameAA() {
        return uname != null && (uname.startsWith("tmpusr") || uname.equals(""));
    }

    public static String gameAE() {
        String var0 = "";

        for (int var1 = 0; var1 < 12; ++var1) {
            String var2 = Integer.toString(Res.gameAB(0, 9));
            var0 = var0 + var2;
        }

        return var0;
    }

    public final void perform(int var1, Object var2) {
        int var4;
        switch (var1) {
            case 1000:
                if (gameAA() && !uname.equals("")) {
                    GameCanvas.gameAA(mResources.NEW_ACC_ARLET, new Command(mResources.COUNTINUE_PLAY, this, 10001, (Object) null), new Command(mResources.NO, GameCanvas.instance, 8882, (Object) null));
                    return;
                }

                gameAF();
                Service.gI().gameAA("-1", "12345", "1.8.8");
                return;
            case 1001:
                if (gameAA() && !uname.equals("") && unameChange.equals("")) {
                    GameCanvas.gameAA(mResources.NEW_ACC_ARLET, new Command(mResources.COUNTINUE, this, 10004, (Object) null), new Command(mResources.NO, GameCanvas.instance, 8882, (Object) null));
                    return;
                }

                GameCanvas.loginScr.gameAB();
                return;
//            case 1002:
//                MyVector var3 = new MyVector();
//
//                for (var4 = 0; var4 < mResources.serverST.length; ++var4) {
//                    var3.addElement(new Command(mResources.listName[mResources.serverST[var4]], this, var4 + 20000, (Object) null));
//                }
//
//                GameCanvas.menu.gameAA(var3);
//                if (RMS.gameAD("indServer") != -1 && !GameCanvas.isTouch) {
//                    GameCanvas.menu.menuSelectedItem = RMS.gameAD("indServer");
//                }
//
//                return;
            case 1002:
                MyVector var3 = new MyVector();

                for (var4 = 0; var4 < UpdateServer.serverST.length; ++var4) {
                    var3.addElement(new Command(UpdateServer.listName[UpdateServer.serverST[var4]], this, var4 + 20000, (Object) null));
                }

                GameCanvas.menu.gameAA(var3);
                if (RMS.gameAD("indServer") != -1 && !GameCanvas.isTouch) {
                    GameCanvas.menu.menuSelectedItem = RMS.gameAD("indServer");
                }

                return;
            case 1003:
                gameAF();
                if (!unameChange.equals("")) {
                    uname = unameChange;
                    pass = passChange;
                    unameChange = "";
                    passChange = "";
                    RMS.gameAA("acc", uname);
                    RMS.gameAA("pass", pass);
                }

                Service.gI().gameAA(uname, pass, "1.8.8");
                return;
            case 1004:// nhận qua https
                boolean bl2 = UpdateServer.a();
                Session_ME.gameAA().gameAC();
                GameCanvas.gameAB();
                GameCanvas.gameAJ();
                GameCanvas.gameAA(bl2 ? new String(new char[]{'U', 'p', 'd', 'a', 't', 'e', ' ', 'O', 'K'})
                        : new String(new char[]{'e', 'r', 'r', 'o', 'r', ' ', '!', '!', ' ', 'V', 'u', 'i', ' ', 'L', 'ò', 'n', 'g', ' ', 'K', 'i', 'ể', 'm', ' ',
                    'T', 'r', 'a', ' ', 'L', 'ạ', 'i', ' ', 'K', 'ế', 't', ' ', 'N', 'ố', 'i'}), 8882);
                return;
//            case 1004:// nhận ip  
//                boolean bl2 = UpdateServer.b1();
//                Session_ME.gameAA().gameAC();
//                GameCanvas.gameAB();
//                GameCanvas.gameAJ();
//                GameCanvas.gameAAa(bl2 ? new String(new char[]{'U', 'p', 'd', 'a', 't', 'e', ' ', 'O', 'K'})
//                        : new String(new char[]{'e', 'r', 'r', 'o', 'r', ' ', '!', '!', ' ', 'V', 'u', 'i', ' ', 'L', 'ò', 'n', 'g', ' ', 'K', 'i', 'ể', 'm', ' ',
//                    'T', 'r', 'a', ' ', 'L', 'ạ', 'i', ' ', 'K', 'ế', 't', ' ', 'N', 'ố', 'i'}), 8882, (Object) null);
//                return;
            case 10001:
                gameAF();
                Service.gI().gameAA("-1", "12345", "1.8.8");
                if (!unameChange.equals("")) {
                    uname = unameChange;
                    pass = passChange;
                    unameChange = "";
                    passChange = "";
                    RMS.gameAA("acc", uname);
                    RMS.gameAA("pass", pass);
                    return;
                }
            case 10004:
                GameCanvas.currentDialog = null;
                GameCanvas.loginScr.gameAB();
                return;
            default:
//                if (var1 >= 20000 && var1 < 20000 + mResources.serverST.length) {
//                    var4 = mResources.serverST[var1 - 20000];
//                    GameCanvas.menu.showMenu = false;
//                    GameMidlet.IP = mResources.listIP[var4];
//                    GameMidlet.PORT = mResources.listPort[var4];
//                    GameMidlet.serverLogin = mResources.serverLoginList[var4];
//                    RMS.gameAA("indServer", mResources.serverST[var4]);
//                }
                if (var1 >= 20000 && var1 < 20000 + UpdateServer.serverST.length) {
                    var4 = UpdateServer.serverST[var1 - 20000];
                    GameCanvas.menu.showMenu = false;
                    GameMidlet.IP = UpdateServer.listIP[var4];
                    GameMidlet.PORT = UpdateServer.listPort[var4];
                    GameMidlet.serverLogin = UpdateServer.serverLoginList[var4];
                    RMS.gameAA("indServer", UpdateServer.serverST[var4]);
                }
        }
    }

    static {
        if (uname == null) {
            uname = "";
        }

        if (pass == null) {
            pass = "";
        }

    }
}
