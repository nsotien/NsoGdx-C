
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Image;

public final class Controller implements IMessageHandler {

    private static Controller me;
    private Message messWait;
    private static String[] gameAC = new String[]{"Bạn chỉ có thể vào lại game sau ", " giây nữa"};
    private static String gameAD = "Bạn chưa thể đi đến khu vực này.Hãy hoàn thành nhiệm vụ trước.";
    private static String gameAE = "Cửa này vẫn chưa được mở.";
    private static String gameAF = "Cửa này chỉ chứa được tối đa 2 người.";
    private static String gameAG = "Số nhóm của khu vực này";
    private static String gameAH = "Khu vực này đã đầy.";
    private static String gameAI = "Thao tác quá nhanh.";

    public static Controller gameAD() {
        if (me == null) {
            me = new Controller();
        }

        return me;
    }

    public final void onConnectOK() {
        System.out.println("Connect ok");
    }

    public final void gameAA() {
        if (Char.ReConnect && Code.gameAB != null) {
            Session_ME.gameAA().gameAD();
        } else {
            GameCanvas.gameAA(mResources.gameFF, 8884);
        }
    }

    public final void onDisconnected() {
        System.out.println("Disconnected");
        Code.gameAB();
        if (Code.gameAB instanceof Stanima && Res.gameAB().get(11) == 3) {
            Stanima.gameAY = true;
        }

        if (Char.ReConnect && Code.gameAB != null) {
            Session_ME.gameAA().gameAD();
        } else {
            GameCanvas.instance.gameAP();
        }
    }

    private static void gameAB(Message var0) {
        try {
            int var1 = var0.gameAB().readUnsignedByte();
            Item var4;
            (var4 = GameScr.currentCharViewInfo.arrItemBody[var1]).expires = var0.gameAB().readLong();
            var4.saleCoinLock = var0.gameAB().readInt();
            var4.sys = var0.gameAB().readByte();
            var4.options = new MyVector();

            try {
                while (true) {
                    var4.options.addElement(new ItemOption(var0.gameAB().readUnsignedByte(), var0.gameAB().readInt()));
                }
            } catch (Exception var2) {
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    private static void gameAC(Message var0) {
        try {
            Item var1 = null;
            int var2 = var0.gameAB().readInt();

            for (int var3 = 0; var3 < GameScr.arrItemStands.length; ++var3) {
                if (GameScr.arrItemStands[var3].item.itemId == var2) {
                    var1 = GameScr.arrItemStands[var3].item;
                    break;
                }
            }

            var1.typeUI = 37;
            var1.expires = -1L;
            var1.saleCoinLock = var0.gameAB().readInt();
            if (var1.gameAB() || var1.gameAD()) {
                var1.options = new MyVector();

                try {
                    var1.upgrade = var0.gameAB().readByte();
                    var1.sys = var0.gameAB().readByte();

                    while (true) {
                        var1.options.addElement(new ItemOption(var0.gameAB().readUnsignedByte(), var0.gameAB().readInt()));
                    }
                } catch (Exception var4) {
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public final void gameAA(Message paramMessage) {
        try {
            String var188;
            Char char_4;
            byte b5;
            Char char_3;
            int i1;
            ItemMap itemMap;
            byte b4;
            String str5;
            int n;
            String str4;
            byte b3;
            String str3;
            int m;
            Char char_2;
            byte b2;
            Friend friend1;
            int k;
            String str2;
            int j;
            Char char_1;
            byte b1;
            String str1;
            int i6;
            String str8;
            int i5;
            Mob mob6;
            byte b;
            Item item4;
            byte b13;
            Item item3;
            byte b12;
            Mob mob5;
            byte b11;
            Char char_8;
            String[] arrayOfString;
            Mob mob4;
            String str7;
            byte b10;
            Char char_7;
            int i4;
            BuNhin buNhin;
            Mob mob3;
            int i3;
            Mob mob2;
            int i2;
            Mob mob1;
            byte b9;
            Char char_6;
            byte b8;
            Item item2;
            byte b7;
            Char char_5;
            Item item1;
            byte b6;
            boolean bool1;
            String str11;
            Char[] arrayOfChar2;
            byte b14;
            String str10;
            Char[] arrayOfChar1;
            int i8;
            Mob mob7;
            String str9;
            int i7;
            short s2;
            int i10;
            short[] arrayOfShort;
            short s1;
            Char char_9;
            Short short_;
            int i9;
            int i12;
            String str15;
            byte b15;
            String str14;
            Item[] arrayOfItem;
            MyVector myVector3;
            String str13;
            MyVector myVector2;
            int i11;
            MyVector myVector1;
            String str12;
            Char char_12;
            String str17;
            Char char_11;
            String str16;
            Char char_10;
            byte b18;
            int i14;
            byte[] arrayOfByte;
            Integer integer;
            byte b17;
            short s3;
            Mob[] arrayOfMob;
            byte b16;
            short s6;
            Char char_13;
            short s5;
            boolean bool2;
            short s4;
            short s7;
            Friend friend2;
            long l;
            switch (paramMessage.gameAA) {
                case -30:
                    gameAG(paramMessage);
                    return;
                case -29:
                    gameAF(paramMessage);
                    return;
                case -28:
                    gameAE(paramMessage);
                    return;
                default:
                    return;
                case -26:
                    GameCanvas.gameAA(var188 = paramMessage.gameAB().readUTF());
                    bool1 = false;
                    i6 = 0;
                    if (var188.startsWith(gameAC[0])) {
                        i6 = 0;
                        try {
                            i6 = Integer.parseInt(var188.substring(gameAC[0].length(), var188.indexOf(gameAC[1])).trim());
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        Session_ME.gameAA().gameAB();
                        Session_ME.gameAP = false;
                        Session_ME.gameAE();
                        GameCanvas.gameBT = i6;
                        GameCanvas.gameBV = GameCanvas.gameBU = System.currentTimeMillis();
                        return;
                    }
                    if (var188.equals(gameAI)) {
                        LockGame.gameAR();
                    } else {
                        boolean bool;
                        if (TileMap.gameBF && (var188.equals(gameAD) || (bool1 = var188.equals(gameAE)) || (bool = var188.equals(gameAF)) || var188.equals(gameAH) || var188.startsWith(gameAG))) {
                            if (Code.gameAB != null && TileMap.gameAG(TileMap.mapID)) {
                                int i13;
                                boolean var106 = false;
                                if (bool1) {
                                    if ((i13 = TileMap.gameAI(Code.gameAB.mapID)) > 0) {
                                        Code.gameAB.mapID = i13;
                                    }
                                    Code.gameAB.gameAE = -1;
                                } else if (var106) {
                                    if ((i13 = TileMap.gameAH(Code.gameAB.mapID)) > 0) {
                                        Code.gameAB.mapID = i13;
                                    }
                                    Code.gameAB.gameAE = -1;
                                }
                            }
                            if (TileMap.gameBE) {
                                TileMap.gameBE = false;
                            } else {
                                GameCanvas.endDlg();
                            }
                            TileMap.gameAG();
                            return;
                        }
                    }
                    return;
                case -25:
                    Info.gameAA(var188 = paramMessage.gameAB().readUTF(), 150, mFont.tahoma_7b_yellow);
                    ChatManager.gameAD().gameAA(mResources.GLOBALCHAT[0], mResources.gameVT, var188);
                    if (Code.gameAB instanceof Stanima) {
                        Code.gameAC.gameAA(var188);
                    }
                    if (Code.gameAB instanceof ChoBoss) {
                        ((ChoBoss) Code.gameAB).gameAA(var188);
                    }
                    return;
                case -24:
                    if ((str11 = paramMessage.gameAB().readUTF()).indexOf("đang đứng nhìn bạn") > 0) {
                        Code.gameAG(str11.substring(0, str11.indexOf("đang đứng nhìn bạn")).trim());
                    } else if (Char.DieHetMp && Code.gameAB != null && str11.equals("Không đủ MP để sử dụng")) {
                        Auto.gameAM = true;
                    } else if (LockGame.gameAB && str11.equals("Vật phẩm của người khác")) {
                        LockGame.gameAD();
                        ItemMap itemMap1;
                        if ((itemMap1 = (Char.getMyChar()).itemFocus) != null) {
                            itemMap1.gameAK = true;
                        }
                    } else if (Code.gameAB instanceof AutoGuiDo) {
                        if (str11.endsWith("không đủ chỗ trống trong hành trang")) {
                            AutoGuiDo.gameAA = true;
                        }
                    } else if (Code.gameAB instanceof AutoNhan) {
                        if (str11.endsWith("Bạn không đủ chỗ trống trong hành trang")) {
                            AutoGuiDo.gameAB = true;
                        }
                    } else if (Code.gameAB instanceof AutoGiaoDich) {
                        if (str11.endsWith("không đủ chỗ trống trong hành trang")) {
                            AutoGuiDo.gameAA = true;
                        }
                    } else if (Code.gameAB instanceof Stanima) {
                        if (Code.gameAC.gameAV == 2 && str11.equals("Cửa hang động đã được khép lại.")) {
                            Stanima.gameAY = true;
                        } else if (Code.gameAC.gameAV == 4 && str11.equals("Chiến trường đã khép lại, xem kết quả tại Npc Rikudou.")) {
                            TileMap.gameAG();
                        }
                    } else if (!str11.equals("Bạn không đủ chỗ trống trong hành trang")) {
                        if (Code.gameAH != null && !Code.gameAH.equals((Char.getMyChar()).cName) && str11.equals("Đối phương đang ở trong nhóm khác.")) {
                            Service.gI().gameAT();
                        }
                        if (Code.gameAB instanceof DanhVong) {
                            DanhVong.gameAB(str11);
                        }
                    } else {
                        if (Char.gameBH() > 0 && Code.gameAB instanceof AutoSell) {
                            GameScr.gI().gameAD((int) 4);

                            for (int var10 = 0; var10 < Char.getMyChar().arrItemBag.length; ++var10) {
                                Item var213 = Char.getMyChar().arrItemBag[var10];
                                if (var213 != null) {
                                    Service.gI().gameAE(var213.indexUI);
                                }
                            }
                        }

                        AutoGuiDo.gameAB = true;

                    }
                    InfoMe.gameAA(str11, 50, mFont.tahoma_7_yellow);
                    return;
                case -23:
                    i12 = paramMessage.gameAB().readInt();
                    var188 = paramMessage.gameAB().readUTF();
                    if ((Char.getMyChar()).charID == i12) {
                        char_12 = Char.getMyChar();
                    } else {
                        char_12 = GameScr.gameAE(i12);
                    }
                    if (char_12 == null) {
                        return;
                    }
                    ChatPopup.gameAA(var188, 100, char_12);
                    ChatManager.gameAD().gameAA(mResources.PUBLICCHAT[0], char_12.cName, var188);
                    return;
                case -22:
                    String var154 = paramMessage.gameAB().readUTF();
                    String vara94 = paramMessage.gameAB().readUTF();
                    ChatManager.gameAD().gameAA(var154, var154, vara94);
                    if ((!GameScr.isPaintMessage || !ChatManager.gameAD().gameAE().ownerName.equals(var154)) && !ChatManager.blockPrivateChat) {
                        ChatManager.gameAD().gameAC(var154);
                    }

                    Code var160 = Code.gameAA;
                    Code.gameAB(var154, vara94);
                    return;
                case -21:
                    var188 = paramMessage.gameAB().readUTF();
                    str8 = paramMessage.gameAB().readUTF();
                    ChatManager.gameAD().gameAA(mResources.GLOBALCHAT[0], var188, str8);
                    if (!ChatManager.blockGlobalChat) {
                        Info.gameAA(var188 + ": " + str8, 80, mFont.tahoma_7b_yellow);
                    }
                    return;
                case -20:
                    str15 = paramMessage.gameAB().readUTF();
                    str11 = paramMessage.gameAB().readUTF();
                    ChatManager.gameAD().gameAA(mResources.PARTYCHAT[0], str15, str11);
                    if (!GameScr.isPaintMessage || (ChatManager.gameAD().gameAE()).type != 1) {
                        ChatManager.isMessagePt = true;
                    }
                    Code.gameAD(str15, str11);
                    return;
                case -19:
                    str15 = paramMessage.gameAB().readUTF();
                    var188 = paramMessage.gameAB().readUTF();
                    ChatManager.gameAD().gameAA(mResources.CLANCHAT[0], str15, var188);
                    if (!GameScr.isPaintMessage || (ChatManager.gameAD().gameAE()).type != 4) {
                        ChatManager.isMessageClan = true;
                    }
                    return;
                case -18:
                    GameCanvas.isLoading = true;
                    GameScr.gameAA();
                    TileMap.vGo.removeAllElements();
                    System.gc();
                    TileMap.mapID = (short) paramMessage.gameAB().readUnsignedByte();
                    TileMap.gameAE = paramMessage.gameAB().readByte();
                    TileMap.bgID = paramMessage.gameAB().readByte();
                    TileMap.gameAN = paramMessage.gameAB().readByte();
                    TileMap.mapName = paramMessage.gameAB().readUTF();
                    TileMap.zoneID = paramMessage.gameAB().readByte();
                    TileMap.gameAJ();
                    try {
                        TileMap.gameAH();
                    } catch (Exception exception) {
                        Service.gI().gameAY(TileMap.mapID);
                        this.messWait = paramMessage;
                        return;
                    }
                    gameAD(paramMessage);
                    if ((Char.getMyChar()).mobMe != null) {
                        (Char.getMyChar()).mobMe.x = (Char.getMyChar()).cx;
                        (Char.getMyChar()).mobMe.y = (Char.getMyChar()).cy - 40;
                    }
                    return;
                case -16:
                    Char.gameGM = true;
                    Char.gameGL = true;
                    (GameScr.gI()).gameFC = 0;
                    (GameScr.gI()).gameFB = 0;
                    (Char.getMyChar()).mobFocus = null;
                    (Char.getMyChar()).npcFocus = null;
                    (Char.getMyChar()).charFocus = null;
                    (Char.getMyChar()).itemFocus = null;
                    (Char.getMyChar()).focus.removeAllElements();
                    (Char.getMyChar()).testCharId = -9999;
                    (Char.getMyChar()).killCharId = -9999;
                    GameScr.gameAA();
                    GameCanvas.gameAH();
                    if (GameScr.vParty.size() <= 1) {
                        GameScr.vParty.removeAllElements();
                    }
                    GameScr.gI().gameAU();
                    (GameScr.gI()).center = null;
                    return;
                case -15:
                    s2 = paramMessage.gameAB().readShort();
                    for (i5 = 0; i5 < GameScr.vItemMap.size(); i5++) {
                        if (((ItemMap) GameScr.vItemMap.elementAt(i5)).itemMapID == s2) {
                            GameScr.vItemMap.removeElementAt(i5);
                            return;
                        }
                    }
                    return;
                case -14:
                    (Char.getMyChar()).itemFocus = null;
                    s2 = paramMessage.gameAB().readShort();
                    for (i5 = 0; i5 < GameScr.vItemMap.size(); i5++) {
                        ItemMap itemMap1;
                        if ((itemMap1 = (ItemMap) GameScr.vItemMap.elementAt(i5)).itemMapID == s2) {
                            itemMap1.gameAA((Char.getMyChar()).cx, (Char.getMyChar()).cy - 10);
                            itemMap1.gameAK = true;
                            if (itemMap1.template.type == 19) {
                                i5 = paramMessage.gameAB().readUnsignedShort();
                                Char char_;
                                (char_ = Char.getMyChar()).yen += i5;
                                if (itemMap1.template.id == 238) {
                                    return;
                                }
                                InfoMe.gameAA(mResources.gamePQ + " " + i5 + " " + mResources.gamePF);
                                return;
                            }
                            if (itemMap1.template.type == 25 && itemMap1.template.id != 238) {
                                InfoMe.gameAA(mResources.gamePQ + " " + itemMap1.template.name, 15, mFont.tahoma_7_yellow);
                                return;
                            }
                            return;
                        }
                    }
                    LockGame.gameAD();
                    return;
                case -13:
                    s2 = paramMessage.gameAB().readShort();
                    for (i5 = 0; i5 < GameScr.vItemMap.size(); i5++) {
                        ItemMap itemMap1;
                        if ((itemMap1 = (ItemMap) GameScr.vItemMap.elementAt(i5)).itemMapID == s2) {
                            if ((char_12 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                                return;
                            }
                            itemMap1.gameAA(char_12.cx, char_12.cy - 10);
                            if (itemMap1.x < char_12.cx) {
                                char_12.cdir = -1;
                            } else if (itemMap1.x > char_12.cx) {
                                char_12.cdir = 1;
                            }
                            if (itemMap1 == (Char.getMyChar()).itemFocus) {
                                itemMap1.gameAK = true;
                                LockGame.gameAD();
                            }
                            return;
                        }
                    }
                    return;
                case -12:
                    i5 = paramMessage.gameAB().readByte();
                    GameScr.vItemMap.addElement(new ItemMap(paramMessage.gameAB().readShort(), ((Char.getMyChar()).arrItemBag[i5]).template.id, (Char.getMyChar()).cx, (Char.getMyChar()).cy, paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort()));
                    (Char.getMyChar()).arrItemBag[i5] = null;
                    return;
                case -11:
                    (Char.getMyChar()).cPk = paramMessage.gameAB().readByte();
                    Char.getMyChar().gameAA(paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort());
                    try {
                        (Char.getMyChar()).cEXP = paramMessage.gameAB().readLong();
                        GameScr.gameAA((Char.getMyChar()).cEXP);
                    } catch (Exception exception) {
                    }
                    (Char.getMyChar()).countKill = 0;
                    return;
                case -10:
                    if ((Char.getMyChar()).wdx != 0 || (Char.getMyChar()).wdy != 0) {
                        (Char.getMyChar()).cx = (Char.getMyChar()).wdx;
                        (Char.getMyChar()).cy = (Char.getMyChar()).wdy;
                        (Char.getMyChar()).wdx = (Char.getMyChar()).wdy = 0;
                    }
                    Char.getMyChar().gameBA();
                    Char.gameGM = false;
                    return;
                case -8:
                    i5 = paramMessage.gameAB().readInt();
                    (char_4 = Char.getMyChar()).yen += i5;
                    (GameScr.gI()).gameFG = i5;
                    GameScr.gameAA((i5 > 0) ? "+".concat(String.valueOf(i5)) : String.valueOf(i5), (Char.getMyChar()).cx, (Char.getMyChar()).cy - (Char.getMyChar()).ch - 10, 1);
                    return;
                case -7:
                    i5 = paramMessage.gameAB().readInt();
                    (char_4 = Char.getMyChar()).xu += i5;
                    (char_4 = Char.getMyChar()).yen -= i5;
                    GameScr.gameAA("+".concat(String.valueOf(i5)), (Char.getMyChar()).cx, (Char.getMyChar()).cy - (Char.getMyChar()).ch - 10, 1);
                    return;
                case -6:
                    if ((char_12 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    GameScr.vItemMap.addElement(new ItemMap(paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), char_12.cx, char_12.cy, paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort()));
                    return;
                case -5:
                    try {
                        (mob4 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte())).sys = paramMessage.gameAB().readByte();
                        mob4.levelBoss = (short) paramMessage.gameAB().readByte();
                        mob4.x = mob4.xFirst;
                        mob4.y = mob4.yFirst;
                        mob4.status = 5;
                        mob4.gameBD = false;
                        mob4.hp = paramMessage.gameAB().readInt();
                        mob4.maxHp = mob4.hp;
                        if ((mob4.getTemplate()).mobTemplateId == 202) {
                            ServerEffect.gameAA(148, mob4.x, mob4.y, 0);
                        } else {
                            ServerEffect.gameAA(60, mob4.x, mob4.y, 1);
                        }
                        Auto.gameAA(mob4);
                    } catch (Exception exception2) {
                        exception2.printStackTrace();
                    }
                    return;
                case -4:
                    mob6 = null;
                    try {
                        mob6 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    } catch (Exception exception) {
                    }
                    if (mob6 != null && mob6.status != 0 && mob6.status != 0) {
                        try {
                            int i13;
                            if ((i13 = paramMessage.gameAB().readInt()) < 0) {
                                i13 = Res.abs(i13) + 32767;
                            }
                            if (paramMessage.gameAB().readBoolean()) {
                                GameScr.gameAA("-".concat(String.valueOf(i13)), mob6.x, mob6.y - mob6.gameAL, 3);
                            } else {
                                GameScr.gameAA("-".concat(String.valueOf(i13)), mob6.x, mob6.y - mob6.gameAL, 5);
                            }
                            ItemMap itemMap1 = new ItemMap(paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), mob6.x, mob6.y, paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort());
                            GameScr.vItemMap.addElement(itemMap1);
                            if (Res.abs(itemMap1.y - (Char.getMyChar()).cy) < 24 && Res.abs(itemMap1.x - (Char.getMyChar()).cx) < 24) {
                                (Char.getMyChar()).charFocus = null;
                            }
                        } catch (Exception exception) {
                        }
                        mob6.gameAF();
                    }
                    return;
                case -3:
                    mob6 = null;
                    try {
                        mob6 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    } catch (Exception exception) {
                        System.out.println("----err null:NPC_ATTACK_ME");
                    }
                    if (mob6 != null) {
                        int i13 = paramMessage.gameAB().readInt();
                        try {
                            i14 = paramMessage.gameAB().readInt();
                        } catch (Exception exception) {
                            i14 = 0;
                        }
                        if (mob6.isBusyAttackSomeOne) {
                            Char.getMyChar().gameAA(i13, i14, false, -1);
                            mob6.gameAG();
                        } else {
                            mob6.dame = i13;
                            mob6.dameMp = i14;
                            mob6.gameAA(Char.getMyChar());
                        }
                        short s = paramMessage.gameAB().readShort();
                        byte b19 = paramMessage.gameAB().readByte();
                        byte b20 = paramMessage.gameAB().readByte();
                        mob6.gameAA(s, b19, b20);
                        if ((Char.getMyChar()).cHP < (Char.getMyChar()).cMaxHP / 2) {
                            if (mob6.isBoss) {
                                System.out.println("Bi Quai TG Danh");
                                return;
                            }
                            if (mob6.levelBoss == 1) {
                                System.out.println("Bi TA Danh");
                            } else if (mob6.levelBoss == 2) {
                                System.out.println("Bi TL Danh");
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case -2:
                    mob6 = null;
                    try {
                        mob6 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    } catch (Exception exception) {
                    }
                    if (mob6 == null) {
                        return;
                    }
                    if ((char_12 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    i10 = paramMessage.gameAB().readInt();
                    mob6.dame = char_12.cHP - i10;
                    char_12.cHpNew = i10;
                    try {
                        char_12.cMP = paramMessage.gameAB().readInt();
                    } catch (Exception exception) {
                    }
                    if (mob6.isBusyAttackSomeOne) {
                        char_12.gameAA(mob6.dame, 0, false, -1);
                        mob6.gameAG();
                    } else {
                        mob6.gameAA(char_12);
                    }
                    s6 = paramMessage.gameAB().readShort();
                    b5 = paramMessage.gameAB().readByte();
                    b18 = paramMessage.gameAB().readByte();
                    mob6.gameAA(s6, b5, b18);
                    return;
                case -1:
                    mob6 = null;
                    try {
                        mob6 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    } catch (Exception exception) {
                    }
                    if (mob6 != null) {
                        mob6.hp = paramMessage.gameAB().readInt();
                        int i13;
                        if ((i13 = paramMessage.gameAB().readInt()) < 0) {
                            i13 = Res.abs(i13) + 32767;
                        }
                        boolean bool = paramMessage.gameAB().readBoolean();
                        try {
                            mob6.levelBoss = (short) paramMessage.gameAB().readByte();
                            mob6.maxHp = paramMessage.gameAB().readInt();
                            Auto.gameAA(mob6);
                        } catch (Exception exception) {
                        }
                        if (bool) {
                            GameScr.gameAA("-".concat(String.valueOf(i13)), mob6.x, mob6.y - mob6.gameAL, 3);
                        } else {
                            GameScr.gameAA("-".concat(String.valueOf(i13)), mob6.x, mob6.y - mob6.gameAL, 5);
                        }
                        return;
                    }
                    return;
                case 0:
                    if ((char_12 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_12.cPk = paramMessage.gameAB().readByte();
                    if (char_12.charID == Char.aCID) {
                        Char.gameFS = true;
                    }
                    char_12.gameAA(paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort());
                    if ((Char.getMyChar()).charFocus == char_12) {
                        (Char.getMyChar()).charFocus = null;
                    }
                    return;
                case 1:
                    Char var104;
                    i10 = paramMessage.gameAB().readInt();
                    for (b15 = 0; b15 < GameScr.vCharInMap.size(); b15++) {
                        var104 = null;
                        try {
                            var104 = (Char) GameScr.vCharInMap.elementAt(b15);
                        } catch (Exception exception) {
                            System.out.println("Char null");
                        }
                        if (var104 == null) {
                            return;
                        }
                        if (var104.charID == i10) {
                            var104.gameGI = paramMessage.gameAB().readShort();
                            var104.gameGJ = paramMessage.gameAB().readShort();
                            var104.gameAA(var104.gameGI, var104.gameGJ);
                            var104.lastUpdateTime = System.currentTimeMillis();
                            return;
                        }
                    }
                    return;
                case 2:
                    i10 = paramMessage.gameAB().readInt();
                    for (b15 = 0; b15 < GameScr.vCharInMap.size(); b15++) {
                        if ((char_7 = (Char) GameScr.vCharInMap.elementAt(b15)) != null && char_7.charID == i10) {
                            if (!char_7.isInvisible && char_7.isHuman && !char_7.isNhanban) {
                                ServerEffect.gameAA(60, char_7.cx, char_7.cy, 1);
                            } else if (!char_7.isInvisible && char_7.gameBE() && !char_7.isHuman) {
                                ServerEffect.gameAA(141, char_7.cx, char_7.cy, 0);
                            }
                            GameScr.vCharInMap.removeElementAt(b15);
                            Party.gameAA(i10);
                            if (!char_7.gameBD() && char_7.cName.equals((Char.getMyChar()).cName)) {
                                (Char.getMyChar()).gameAD = null;
                            }
                            return;
                        }
                    }
                    return;
                case 3:
                    (char_12 = new Char()).charID = paramMessage.gameAB().readInt();
                    if (gameAA(char_12, paramMessage)) {
                        GameScr.vCharInMap.addElement(char_12);
                        Auto.gameAA(char_12);
                        if (!char_12.gameBD() && char_12.cName.equals((Char.getMyChar()).cName)) {
                            (Char.getMyChar()).gameAD = char_12;
                            LockGame.gameBD();
                        }
                        if (char_12.charID == -(Char.getMyChar()).charID) {
                            (Char.getMyChar()).gameAE = char_12;
                        }
                        if (Code.gameAB(char_12.cName) && !Code.gameAC.gameAM()) {
                            Service.gI().gameAF(char_12.cName);
                            return;
                        }
                    }
                    return;
                case 4:
                    if ((char_12 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    if ((TileMap.gameAA(char_12.cx, char_12.cy) & 0x2) == 2) {
                        char_12.gameAA(GameScr.sks[paramMessage.gameAB().readByte()], 0);
                    } else {
                        char_12.gameAA(GameScr.sks[paramMessage.gameAB().readByte()], 1);
                    }
                    if (char_12.isWolf) {
                        char_12.isWolf = false;
                        char_12.timeChatReturn = System.currentTimeMillis();
                        ServerEffect.gameAA(60, char_12, 1);
                    }
                    if (char_12.isMoto) {
                        char_12.isMoto = false;
                        char_12.gameCP = true;
                    }
                    b5 = paramMessage.gameAB().readByte();
                    char_12.attMobs = new Mob[b5];
                    for (i10 = 0; i10 < char_12.attMobs.length; i10++) {
                        Mob mob = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                        char_12.attMobs[i10] = mob;
                        if (i10 == 0) {
                            if (char_12.cx <= mob.x) {
                                char_12.cdir = 1;
                            } else {
                                char_12.cdir = -1;
                            }
                        }
                    }
                    char_12.mobFocus = char_12.attMobs[0];
                    arrayOfChar2 = new Char[10];
                    b = 0;
                    try {
                        for (b = 0; b < 10; b++) {
                            Char char_;
                            int i13;
                            if ((i13 = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                                char_ = Char.getMyChar();
                            } else {
                                char_ = GameScr.gameAE(i13);
                            }
                            arrayOfChar2[b] = char_;
                            if (b == 0) {
                                if (char_12.cx <= char_.cx) {
                                    char_12.cdir = 1;
                                } else {
                                    char_12.cdir = -1;
                                }
                            }
                        }
                    } catch (Exception exception) {
                    }
                    if (b > 0) {
                        char_12.attChars = new Char[b];
                        for (b = 0; b < char_12.attChars.length; b++) {
                            char_12.attChars[b] = arrayOfChar2[b];
                        }
                        char_12.charFocus = char_12.attChars[0];
                    }
                    return;
                case 5:
                    l = paramMessage.gameAB().readLong();
                    (Char.getMyChar()).cExpDown = 0L;
                    (char_3 = Char.getMyChar()).cEXP += l;
                    i1 = (Char.getMyChar()).clevel;
                    GameScr.gameAA((Char.getMyChar()).cEXP);
                    if (i1 != (Char.getMyChar()).clevel) {
                        ServerEffect.gameAA(58, Char.getMyChar(), 1);
                    }
                    GameScr.gameAA("+".concat(String.valueOf(l)), (Char.getMyChar()).cx, (Char.getMyChar()).cy - (Char.getMyChar()).ch, 2);
                    if (l >= 1000000L) {
                        InfoMe.gameAA(mResources.gamePQ + " " + l + " " + mResources.gameKF, 20, mFont.tahoma_7_yellow);
                    }
                    return;
                case 6:
                    itemMap = new ItemMap(paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort());
                    if ((arrayOfByte = NinjaUtil.gameAA(paramMessage)) != null && arrayOfByte.length > 0) {
                        itemMap.imgCaptcha = new MyImage();
                        itemMap.imgCaptcha.img = gameAA(arrayOfByte);
                    }
                    GameScr.vItemMap.addElement(itemMap);
                    return;
                case 7:
                    ((Char.getMyChar()).arrItemBag[paramMessage.gameAB().readByte()]).quantity = paramMessage.gameAB().readShort();
                    return;
                case 8:
                    b = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).arrItemBag[b] = new Item();
                    ((Char.getMyChar()).arrItemBag[b]).typeUI = 3;
                    ((Char.getMyChar()).arrItemBag[b]).indexUI = b;
                    ((Char.getMyChar()).arrItemBag[b]).template = ItemTemplates.gameAA(paramMessage.gameAB().readShort());
                    ((Char.getMyChar()).arrItemBag[b]).isLock = paramMessage.gameAB().readBoolean();
                    if ((Char.getMyChar()).arrItemBag[b].gameAB() || (Char.getMyChar()).arrItemBag[b].gameAD()) {
                        ((Char.getMyChar()).arrItemBag[b]).upgrade = paramMessage.gameAB().readByte();
                    }
                    ((Char.getMyChar()).arrItemBag[b]).isExpires = paramMessage.gameAB().readBoolean();
                    try {
                        ((Char.getMyChar()).arrItemBag[b]).quantity = paramMessage.gameAB().readUnsignedShort();
                    } catch (Exception exception) {
                        ((Char.getMyChar()).arrItemBag[b]).quantity = 1;
                    }
                    if (((Char.getMyChar()).arrItemBag[b]).template.type == 16) {
                        GameScr.gameAS += ((Char.getMyChar()).arrItemBag[b]).quantity;
                    }
                    if (((Char.getMyChar()).arrItemBag[b]).template.type == 17) {
                        GameScr.gameAR += ((Char.getMyChar()).arrItemBag[b]).quantity;
                    }
                    if (((Char.getMyChar()).arrItemBag[b]).template.id == 340) {
                        GameScr gameScr;
                        (gameScr = GameScr.gI()).gameDB += ((Char.getMyChar()).arrItemBag[b]).quantity;
                    }
                    if (GameScr.isPaintTrade) {
                        if ((GameScr.gI()).gameFA.equals("")) {
                            GameScr.gI().gameFA += ((Char.getMyChar()).arrItemBag[b]).template.name;
                        } else {
                            GameScr gameScr;
                            GameScr.gI().gameFA += ", " + ((Char.getMyChar()).arrItemBag[b]).template.name;
                        }
                        return;
                    }
                    if (((Char.getMyChar()).arrItemBag[b]).template.type != 20) {
                        InfoMe.gameAA(mResources.gamePQ + " " + ((Char.getMyChar()).arrItemBag[b]).template.name);
                        LockGame.gameAT();
                        return;
                    }
                    return;
                case 9:
                    item4 = (Char.getMyChar()).arrItemBag[paramMessage.gameAB().readUnsignedByte()];
                    try {
                        i10 = paramMessage.gameAB().readShort();
                    } catch (Exception exception) {
                        i10 = 1;
                    }
                    item4.quantity += i10;
                    if (item4.template.type == 16) {
                        GameScr.gameAS += i10;
                    }
                    if (item4.template.type == 17) {
                        GameScr.gameAR += i10;
                    }
                    if (item4.template.id == 340) {
                        GameScr gameScr;
                        (gameScr = GameScr.gI()).gameDB += i10;
                    }
                    GameCanvas.endDlg();
                    if (GameScr.isPaintTrade) {
                        if ((GameScr.gI()).gameFA.equals("")) {
                            GameScr gameScr;
                            GameScr.gI().gameFA += item4.template.name;
                        } else {
                            GameScr gameScr;
                            GameScr.gI().gameFA += ", " + item4.template.name;
                        }
                        return;
                    }
                    if (item4.template.type != 20) {
                        InfoMe.gameAA(mResources.gamePQ + " " + item4.template.name);
                        return;
                    }
                    return;
                case 10:
                    b13 = paramMessage.gameAB().readByte();
                    if (((Char.getMyChar()).arrItemBag[b13]).template.type == 16) {
                        GameScr.gameAS -= ((Char.getMyChar()).arrItemBag[b13]).quantity;
                    }
                    if (((Char.getMyChar()).arrItemBag[b13]).template.type == 17) {
                        GameScr.gameAR -= ((Char.getMyChar()).arrItemBag[b13]).quantity;
                    }
                    (Char.getMyChar()).arrItemBag[b13] = null;
                    if (GameScr.gameAZ()) {
                        (GameScr.gI()).left = (GameScr.gI()).center = null;
                    } else {
                        GameScr.gI().gameAU();
                    }
                    return;
                case 11:
                    b13 = paramMessage.gameAB().readByte();
                    if (((Char.getMyChar()).arrItemBag[b13]).template.type == 24) {
                        InfoDlg.gameAD();
                    }
                    Char.getMyChar().gameAA(b13);
                    Char.getMyChar().gameAA(paramMessage);
                    (Char.getMyChar()).eff5BuffHp = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).eff5BuffMp = paramMessage.gameAB().readShort();
                    GameScr.gI().gameBI();
                    LockGame.gameAR();
                    return;
                case 13:
                    (Char.getMyChar()).xu = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).yen = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).luong = paramMessage.gameAB().readInt();
                    LockGame.gameAH();
                    GameCanvas.endDlg();
                    return;
                case 14:
                    item3 = (Char.getMyChar()).arrItemBag[paramMessage.gameAB().readByte()];
                    (Char.getMyChar()).yen = paramMessage.gameAB().readInt();
                    try {
                        i10 = paramMessage.gameAB().readShort();
                    } catch (Exception exception) {
                        i10 = 1;
                    }
                    item3.quantity -= i10;
                    if (item3.template.type == 16) {
                        GameScr.gameAS -= i10;
                    }
                    if (item3.template.type == 17) {
                        GameScr.gameAR -= i10;
                    }
                    if (item3.quantity <= 0) {
                        (Char.getMyChar()).arrItemBag[item3.indexUI] = null;
                    }
                    if (GameScr.gameAZ()) {
                        (GameScr.gI()).left = (GameScr.gI()).center = null;
                        GameScr.gI().gameBB();
                    }
                    GameCanvas.endDlg();
                    LockGame.gameAT();
                    return;
                case 15:
                    Char.getMyChar().gameAC(paramMessage);
                    LockGame.gameAR();
                    return;
                case 16:
                    Char.getMyChar().gameAE(paramMessage);
                    return;
                case 17:
                    Char.getMyChar().gameAD(paramMessage);
                    return;
                case 18:
                    b12 = paramMessage.gameAB().readByte();
                    i10 = 1;
                    try {
                        i10 = paramMessage.gameAB().readShort();
                    } catch (Exception exception) {
                    }
                    if (((Char.getMyChar()).arrItemBag[b12]).template.type == 24) {
                        InfoDlg.gameAD();
                    }
                    if (((Char.getMyChar()).arrItemBag[b12]).template.type == 16) {
                        GameScr.gameAS--;
                    }
                    if (((Char.getMyChar()).arrItemBag[b12]).template.type == 17) {
                        GameScr.gameAR--;
                    }
                    if (((Char.getMyChar()).arrItemBag[b12]).quantity > i10) {
                        Item item;
                        (item = (Char.getMyChar()).arrItemBag[b12]).quantity -= i10;
                    } else {
                        (Char.getMyChar()).arrItemBag[b12] = null;
                    }
                    if (GameScr.gameDL) {
                        GameScr.gI().gameBI();
                    }
                    return;
                case 19:
                    Char.getMyChar();
                    Char.gameAA(paramMessage, true);
                    return;
                case 20:
                    Char.getMyChar();
                    Char.gameAA(paramMessage, false);
                    return;
                case 21:
                    b4 = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).luong = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).xu = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).yen = paramMessage.gameAB().readInt();
                    if (GameScr.arritemup != null) {
                        GameScr.arritemup.upgrade = paramMessage.gameAB().readByte();
                        GameScr.arritemup.isLock = true;
                        GameScr.arritemup.gameAG();
                        if (b4 == 1) {
                            GameScr.gameGG = GameScr.efs[53];
                            GameScr.gameGF = 0;
                        }
                    }
                    if (GameScr.upitem != null) {
                        for (byte b19 = 0; b19 < GameScr.upitem.length; b19++) {
                            GameScr.upitem[b19] = null;
                        }
                    }
                    if (b4 == 5 || b4 == 6) {
                        if (GameScr.gameDD != null && b4 == 5) {
                            GameScr.gameDD = null;
                        }
                        if (GameScr.gameCV != null) {
                            for (byte b19 = 0; b19 < GameScr.gameCV.length; b19++) {
                                GameScr.gameCV[b19] = null;
                            }
                        }
                    }
                    (GameScr.gI()).left = (GameScr.gI()).center = null;
                    GameScr.gI().gameBA();
                    GameCanvas.endDlg();
                    if (b4 == 5) {
                        InfoMe.gameAA(mResources.gamePY[0], 20, mFont.tahoma_7_white);
                        return;
                    }
                    if (b4 == 6) {
                        InfoMe.gameAA(mResources.gamePY[1], 20, mFont.tahoma_7_red);
                        return;
                    }
                    if (b4 == 1) {
                        InfoMe.gameAA(mResources.gamePX[0] + GameScr.arritemup.upgrade, 20, mFont.tahoma_7_white);
                    } else {
                        InfoMe.gameAA(mResources.gamePX[1] + GameScr.arritemup.upgrade, 20, mFont.tahoma_7_red);
                    }
                    return;
                case 22:
                    b4 = paramMessage.gameAB().readByte();
                    str14 = mResources.gameCO;
                    for (b12 = 0; b12 < GameScr.gameCV.length; b12++) {
                        GameScr.gameCV[b12] = null;
                    }
                    for (b12 = 0; b12 < b4; b12++) {
                        Item item;
                        (item = new Item()).typeUI = 3;
                        item.indexUI = paramMessage.gameAB().readByte();
                        item.template = ItemTemplates.gameAA(paramMessage.gameAB().readShort());
                        item.expires = -1L;
                        item.quantity = 1;
                        item.isLock = GameScr.gameDD.isLock;
                        (Char.getMyChar()).arrItemBag[item.indexUI] = item;
                        str14 = str14 + item.template.name;
                        if (b12 < b4 - 1) {
                            str14 = str14 + ", ";
                        }
                    }
                    GameScr.gameDD.upgrade = 0;
                    GameScr.gameDD.gameAG();
                    (GameScr.gI()).left = (GameScr.gI()).center = null;
                    GameScr.gI().gameBB();
                    GameCanvas.endDlg();
                    InfoMe.gameAA(str14);
                    GameScr.gameGG = GameScr.efs[66];
                    GameScr.gameGF = 0;
                    LockGame.gameAR();
                    return;
                case 23:
                    if (Code.gameAC(str5 = paramMessage.gameAB().readUTF())) {
                        Service.gI().gameAI(str5);
                    } else {
                        GameCanvas.gameAA(str5 + " " + mResources.gameRE, 8889, str5, 8882, (Object) null);
                    }
                    return;
                case 25:
                    b14 = paramMessage.gameAB().readByte();
                    for (i10 = 0; i10 < b14; i10++) {
                        int is14 = paramMessage.gameAB().readInt();
                        short s8 = paramMessage.gameAB().readShort();
                        short s9 = paramMessage.gameAB().readShort();
                        int i13 = paramMessage.gameAB().readInt();
                        if ((char_12 = GameScr.gameAE(is14)) != null) {
                            char_12.cx = s8;
                            char_12.cy = s9;
                            char_12.cHP = i13;
                            char_12.lastUpdateTime = System.currentTimeMillis();
                        }
                    }
                    return;
                case 26:
                    (Char.getMyChar()).countKill = paramMessage.gameAB().readUnsignedShort();
                    (Char.getMyChar()).countKillMax = paramMessage.gameAB().readUnsignedShort();
                    return;
                case 27:
                    mob5 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    if ((n = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                        char_12 = Char.getMyChar();
                    } else {
                        char_12 = GameScr.gameAE(n);
                    }
                    char_12.moveFast = new short[3];
                    char_12.moveFast[0] = 0;
                    char_12.moveFast[1] = (short) mob5.x;
                    char_12.moveFast[2] = (short) mob5.y;
                    char_12.isBlinking = false;
                    return;
                case 30:
                    GameScr.gI().gameAD(paramMessage.gameAB().readByte());
                    LockGame.gameAR();
                    return;
                case 31:
                    (Char.getMyChar()).xuInBox = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).arrItemBox = new Item[paramMessage.gameAB().readUnsignedByte()];
                    for (b11 = 0; b11 < (Char.getMyChar()).arrItemBox.length; b11++) {
                        short s;
                        if ((s = paramMessage.gameAB().readShort()) != -1) {
                            (Char.getMyChar()).arrItemBox[b11] = new Item();
                            ((Char.getMyChar()).arrItemBox[b11]).typeUI = 4;
                            ((Char.getMyChar()).arrItemBox[b11]).indexUI = b11;
                            ((Char.getMyChar()).arrItemBox[b11]).template = ItemTemplates.gameAA(s);
                            ((Char.getMyChar()).arrItemBox[b11]).isLock = paramMessage.gameAB().readBoolean();
                            if ((Char.getMyChar()).arrItemBox[b11].gameAB() || (Char.getMyChar()).arrItemBox[b11].gameAD()) {
                                ((Char.getMyChar()).arrItemBox[b11]).upgrade = paramMessage.gameAB().readByte();
                            }
                            ((Char.getMyChar()).arrItemBox[b11]).isExpires = paramMessage.gameAB().readBoolean();
                            ((Char.getMyChar()).arrItemBox[b11]).quantity = paramMessage.gameAB().readShort();
                        }
                    }
                    LockGame.gameAT();
                    return;
                case 33:
                    n = paramMessage.gameAB().readByte();
                    System.out.println("TypeI=".concat(String.valueOf(n)));
                    arrayOfItem = new Item[paramMessage.gameAB().readByte()];
                    for (b11 = 0; b11 < arrayOfItem.length; b11++) {
                        arrayOfItem[b11] = new Item();
                        (arrayOfItem[b11]).typeUI = n;
                        (arrayOfItem[b11]).indexUI = paramMessage.gameAB().readUnsignedByte();
                        (arrayOfItem[b11]).template = ItemTemplates.gameAA(paramMessage.gameAB().readShort());
                    }
                    if (n == 14) {
                        GameScr.gameCO = arrayOfItem;
                    } else if (n == 15) {
                        GameScr.gameCR = arrayOfItem;
                    } else if (n == 32) {
                        GameScr.gameCS = arrayOfItem;
                    } else if (n == 34) {
                        GameScr.gameCQ = arrayOfItem;
                    } else if (n == 35) {
                        GameScr.gameCP = arrayOfItem;
                    } else if (n == 20) {
                        GameScr.gameBV = arrayOfItem;
                    } else if (n == 21) {
                        GameScr.gameBW = arrayOfItem;
                    } else if (n == 22) {
                        GameScr.gameBX = arrayOfItem;
                    } else if (n == 23) {
                        GameScr.gameBY = arrayOfItem;
                    } else if (n == 24) {
                        GameScr.gameBZ = arrayOfItem;
                    } else if (n == 25) {
                        GameScr.gameCA = arrayOfItem;
                    } else if (n == 26) {
                        GameScr.gameCB = arrayOfItem;
                    } else if (n == 27) {
                        GameScr.gameCC = arrayOfItem;
                    } else if (n == 28) {
                        GameScr.gameCD = arrayOfItem;
                    } else if (n == 29) {
                        GameScr.gameCE = arrayOfItem;
                    } else if (n == 16) {
                        GameScr.gameCF = arrayOfItem;
                    } else if (n == 17) {
                        GameScr.gameCG = arrayOfItem;
                    } else if (n == 18) {
                        GameScr.gameCH = arrayOfItem;
                    } else if (n == 19) {
                        GameScr.gameCI = arrayOfItem;
                    } else if (n == 2) {
                        GameScr.gameCJ = arrayOfItem;
                    } else if (n == 6) {
                        GameScr.gameCK = arrayOfItem;
                    } else if (n == 7) {
                        GameScr.gameCL = arrayOfItem;
                    } else if (n == 8) {
                        GameScr.gameCM = arrayOfItem;
                    } else if (n == 9) {
                        GameScr.gameCN = arrayOfItem;
                    }
                    LockGame.notifyDV();
                    return;
                case 34:
                    myVector3 = new MyVector();
                    if (!(str4 = paramMessage.gameAB().readUTF()).equals("")) {
                        GameScr.gI().gameAA((String) null, str4, true);
                    }
                    b3 = paramMessage.gameAB().readByte();
                    for (b14 = 0; b14 < b3; b14++) {
                        String str = paramMessage.gameAB().readUTF();
                        Short short_1 = new Short(paramMessage.gameAB().readShort());
                        myVector3.addElement(new Command(str, GameCanvas.instance, 88819, short_1));
                    }
                    GameCanvas.menu.gameAA(myVector3);
                    return;
                case 36:
                    GameScr.gI().gameAA(paramMessage);
                    LockGame.gameAF();
                    return;
                case 37:
                    (GameScr.gI()).gameEZ = paramMessage.gameAB().readUTF();
                    GameScr.gI().gameAT();
                    LockGame.gameBB();
                    return;
                case 38:
                    i10 = paramMessage.gameAB().readShort();
                    for (b11 = 0; b11 < GameScr.vNpc.size(); b11++) {
                        Npc npc;
                        if ((npc = (Npc) GameScr.vNpc.elementAt(b11)).template.npcTemplateId == i10 && npc.equals((Char.getMyChar()).npcFocus)) {
                            String str;
                            ChatPopup.gameAA(str = paramMessage.gameAB().readUTF(), npc);
                            if (npc.template.npcTemplateId == 0) {
                                if (str.equals("Số lần vào trong hang hôm nay của con đã hết.")) {
                                    Stanima.gameAZ = true;
                                    if (Code.gameAB instanceof Stanima) {
                                        Stanima.gameAY = true;
                                    }
                                    if (Code.gameAB instanceof Hd9x) {
                                        Code.gameAC();
                                    }
                                    TileMap.gameAG();
                                    return;
                                }
                                return;
                            }
                            if (npc.template.npcTemplateId == 5) {
                                if (str.equals("Tốt lắm, ngươi đã chọn nơi này làm nơi trở về khi bị trọng thương")) {
                                    LockGame.gameAZ();
                                    return;
                                }
                            } else if (npc.template.npcTemplateId == 25) {
                                if (Code.gameAB == Code.gameAD) {
                                    AutoNvhn.gameAA(str);
                                } else if (str.equals("Hôm nay con đã làm hết nhiệm vụ ta giao. Hãy quay lại vào ngày hôm sau.")) {
                                    Stanima.gameAX = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 39:
                    i10 = paramMessage.gameAB().readShort();
                    for (b11 = 0; b11 < GameScr.vNpc.size(); b11++) {
                        Npc npc;
                        if ((npc = (Npc) GameScr.vNpc.elementAt(b11)).template.npcTemplateId == i10 && npc.equals((Char.getMyChar()).npcFocus)) {
                            ChatPopup.gameAA(paramMessage.gameAB().readUTF(), 1000, npc);
                            String[] arrayOfString1 = new String[paramMessage.gameAB().readByte()];
                            for (i10 = 0; i10 < arrayOfString1.length; i10++) {
                                arrayOfString1[i10] = paramMessage.gameAB().readUTF();
                            }
                            GameScr.gI();
                            GameScr.gameAA(arrayOfString1, npc);
                            return;
                        }
                    }
                    return;
                case 40:
                    InfoDlg.gameAD();
                    GameCanvas.gameAK();
                    GameCanvas.gameAJ();
                    myVector3 = new MyVector();
                    try {
                        while (true) {
                            myVector3.addElement(new Command(paramMessage.gameAB().readUTF(), GameCanvas.instance, 88822, null));
                        }
                    } catch (Exception exception) {
                        if ((Char.getMyChar()).npcFocus == null) {
                            return;
                        }
                        if ((Char.getMyChar()).npcFocus.charID == 25) {
                            GameScr.gameGP = myVector3.size();
                        }
                        for (b14 = 0; b14 < (Char.getMyChar()).npcFocus.template.menu.length; b14++) {
                            String[] arrayOfString1 = (Char.getMyChar()).npcFocus.template.menu[b14];
                            myVector3.addElement(new Command(arrayOfString1[0], GameCanvas.instance, 88820, arrayOfString1));
                        }
                        GameCanvas.menu.gameAA(myVector3);
                        return;
                    }
                case 42:
                    gameAH(paramMessage);
                    return;
                case 43:
                    if ((char_8 = GameScr.gameAE((integer = new Integer(paramMessage.gameAB().readInt())).intValue())) != null) {
                        if (Code.gameAB instanceof AutoNhan) {
                            Service.gI().gameAL(integer.intValue());
                            LockGame.gameBB();
                            return;
                        }
                        if (Code.gameAB instanceof AutoSell) {
                            Code.gameAF.gameAA(char_8.cName, integer.intValue());
                        } else {
                            GameCanvas.gameAA(char_8.cName + " " + mResources.gameQY, 88810, integer, 88811, (Object) null);
                        }
                        return;
                    }
                    return;
                case 45:
                    (GameScr.gI()).typeTradeOrder = 1;
                    (GameScr.gI()).gameEF = paramMessage.gameAB().readInt();
                    GameScr.gameCX = new Item[12];
                    b17 = paramMessage.gameAB().readByte();
                    for (i10 = 0; i10 < b17; i10++) {
                        GameScr.gameCX[i10] = new Item();
                        (GameScr.gameCX[i10]).typeUI = 3;
                        (GameScr.gameCX[i10]).indexUI = i10;
                        (GameScr.gameCX[i10]).template = ItemTemplates.gameAA(paramMessage.gameAB().readShort());
                        (GameScr.gameCX[i10]).isLock = false;
                        if (GameScr.gameCX[i10].gameAB() || GameScr.gameCX[i10].gameAD()) {
                            (GameScr.gameCX[i10]).upgrade = paramMessage.gameAB().readByte();
                        }
                        (GameScr.gameCX[i10]).isExpires = paramMessage.gameAB().readBoolean();
                        (GameScr.gameCX[i10]).quantity = paramMessage.gameAB().readShort();
                    }
                    if ((GameScr.gI()).gameEC == 1 && (GameScr.gI()).typeTradeOrder == 1) {
                        (GameScr.gI()).gameEG = (int) (System.currentTimeMillis() / 1000L + 5L);
                    }
                    return;
                case 46:
                    (GameScr.gI()).typeTradeOrder = 2;
                    if ((GameScr.gI()).gameEC >= 2 && (GameScr.gI()).typeTradeOrder >= 2) {
                        InfoDlg.gameAB();
                        LockGame.gameBB();
                    }
                    return;
                case 47:
                    GameCanvas.gameAV = 150;
                    paramMessage.gameAB().readShort();
                    b17 = paramMessage.gameAB().readByte();
                    str10 = paramMessage.gameAB().readUTF();
                    str13 = paramMessage.gameAB().readUTF();
                    arrayOfShort = new short[(arrayOfString = new String[paramMessage.gameAB().readByte()]).length];
                    s6 = -1;
                    for (b3 = 0; b3 < arrayOfString.length; b3++) {
                        String str = paramMessage.gameAB().readUTF();
                        arrayOfShort[b3] = -1;
                        if (!str.equals("")) {
                            arrayOfString[b3] = str;
                        }
                    }
                    try {
                        s6 = paramMessage.gameAB().readShort();
                        for (b3 = 0; b3 < arrayOfString.length; b3++) {
                            arrayOfShort[b3] = paramMessage.gameAB().readShort();
                        }
                    } catch (Exception exception) {
                    }
                    (Char.getMyChar()).taskMaint = new Task(b17, str10, str13, arrayOfString, arrayOfShort, s6);
                    Char.getMyChar().gameAC(21);
                    if ((Char.getMyChar()).npcFocus != null) {
                        Npc.gameAA();
                    }
                    LockGame.gameAP();
                    return;
                case 48:
                    if ((Char.getMyChar()).taskMaint != null) {
                        GameCanvas.gameAV = 100;
                        (Char.getMyChar()).taskMaint.index++;
                        (Char.getMyChar()).taskMaint.count = 0;
                        if ((Char.getMyChar()).npcFocus != null && (Char.getMyChar()).npcFocus.chatPopup != null && (Char.getMyChar()).taskMaint.index >= 2) {
                            (Char.getMyChar()).npcFocus.chatPopup = null;
                        }
                        if ((Char.getMyChar()).taskMaint.index >= (Char.getMyChar()).taskMaint.subNames.length - 1) {
                            Char.getMyChar().gameAC(61);
                        } else {
                            Char.getMyChar().gameAC(21);
                        }
                        Npc.gameAA();
                    }
                    LockGame.gameAP();
                    return;
                case 49:
                    (Char.getMyChar()).ctaskId++;
                    Char.getMyChar();
                    Char.gameBB();
                    return;
                case 50:
                    GameCanvas.gameAV = 50;
                    (Char.getMyChar()).taskMaint.count = paramMessage.gameAB().readShort();
                    if ((Char.getMyChar()).npcFocus != null) {
                        Npc.gameAA();
                    }
                    return;
                case 51:
                    mob4 = null;
                    try {
                        mob4 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    } catch (Exception exception) {
                    }
                    if (mob4 != null) {
                        mob4.hp = paramMessage.gameAB().readInt();
                        GameScr.gameAA("", mob4.x, mob4.y - mob4.gameAL, 4);
                    }
                    return;
                case 52:
                    Char.gameGL = false;
                    Char.gameGM = false;
                    (Char.getMyChar()).cx = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).cy = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).cxSend = (Char.getMyChar()).cx;
                    (Char.getMyChar()).cySend = (Char.getMyChar()).cy;
                    return;
                case 53:
                    GameScr.gI().gameAU();
                    if (!(str3 = paramMessage.gameAB().readUTF()).equals("typemoi")) {
                        str13 = paramMessage.gameAB().readUTF();
                        if (Code.gameAB instanceof DanhVong) {
                            DanhVong.gameAA(str13);
                        } else {
                            GameScr.gI().gameAA(str3, str13, false);
                        }
                        return;
                    }
                    str13 = paramMessage.gameAB().readUTF();
                    s1 = paramMessage.gameAB().readShort();
                    str7 = paramMessage.gameAB().readUTF();
                    s7 = paramMessage.gameAB().readShort();
                    str10 = paramMessage.gameAB().readUTF();
                    s3 = paramMessage.gameAB().readShort();
                    str3 = paramMessage.gameAB().readUTF();
                    byte as6 = paramMessage.gameAB().readByte();
                    str17 = paramMessage.gameAB().readUTF();
                    GameScr.gI().gameAA(str13, s1, str7, s7, str10, s3, str3, str17, as6);
                    return;
                case 54:
                    GameCanvas.gameAB().gameAA(paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF());
                    return;
                case 55:
                    GameCanvas.gameAB().gameAA(paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF());
                    return;
                case 57:
                    GameCanvas.endDlg();
                    GameScr.gI().gameAU();
                    AutoSell.gameAV = true;
                    LockGame.gameBB();
                    return;
                case 58:
                    GameScr.gameCW = null;
                    GameScr.gameCX = null;
                    if ((GameScr.gI()).gameEF > 0) {
                        GameScr.gI().gameFA += ", " + GameScr.gI().gameEF + " " + mResources.gamePE;
                        GameScr.gameAA("+" + (GameScr.gI()).gameEF, (Char.getMyChar()).cx, (Char.getMyChar()).cy - (Char.getMyChar()).ch - 10, 6);
                    }
                    (GameScr.gI()).gameEE = (GameScr.gI()).gameEF = 0;
                    GameScr.gI().gameAU();
                    (Char.getMyChar()).xu = paramMessage.gameAB().readInt();
                    InfoDlg.gameAD();
                    if (!(GameScr.gI()).gameFA.equals("")) {
                        InfoMe.gameAA(mResources.gamePQ + " " + (GameScr.gI()).gameFA);
                    }
                    LockGame.gameBB();
                    return;
                case 59:
                    str13 = paramMessage.gameAB().readUTF();
                    friend2 = new Friend(str13, (byte) 4);
                    GameScr.vFriendWait.addElement(friend2);
                    InfoMe.gameAA(str13 + " " + mResources.gameMN, 20, mFont.tahoma_7_white);
                    if (GameScr.gameDJ) {
                        boolean bool = false;
                        for (s1 = 0; s1 < GameScr.vFriend.size(); s1++) {
                            if (((Friend) GameScr.vFriend.elementAt(s1)).friendName.equals(str13)) {
                                bool = true;
                                break;
                            }
                        }
                        if (!bool) {
                            GameScr.vFriend.addElement(friend2);
                            GameScr.gI();
                            GameScr.gameAC(0);
                            GameScr.indexRow = 0;
                            GameScr.gameBU.gameAA();
                            return;
                        }
                    }
                    return;
                case 60:
                    if ((char_11 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        Mob.interestChar = char_11;
                    }
                    if (char_11 == null) {
                        return;
                    }
                    if ((TileMap.gameAA(char_11.cx, char_11.cy) & 0x2) == 2) {
                        char_11.gameAA(GameScr.sks[paramMessage.gameAB().readByte()], 0);
                    } else {
                        char_11.gameAA(GameScr.sks[paramMessage.gameAB().readByte()], 1);
                    }
                    if (char_11.isWolf && char_11.vitaWolf >= 500) {
                        char_11.isWolf = false;
                        char_11.timeChatReturn = System.currentTimeMillis();
                        ServerEffect.gameAA(60, char_11, 1);
                    }
                    if (char_11.isMoto) {
                        char_11.isMoto = false;
                        char_11.gameCP = true;
                        if (char_11.vitaWolf > 500) {
                            ServerEffect.gameAA(60, char_11, 1);
                        }
                    }
                    arrayOfMob = new Mob[10];
                    b10 = 0;
                    try {
                        for (b10 = 0; b10 < 10; b10++) {
                            Mob mob = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                            arrayOfMob[b10] = mob;
                            if (b10 == 0) {
                                if (char_11.cx <= mob.x) {
                                    char_11.cdir = 1;
                                } else {
                                    char_11.cdir = -1;
                                }
                            }
                        }
                    } catch (Exception exception) {
                    }
                    if (b10 > 0) {
                        char_11.attMobs = new Mob[b10];
                        for (b10 = 0; b10 < char_11.attMobs.length; b10++) {
                            char_11.attMobs[b10] = arrayOfMob[b10];
                        }
                        char_11.mobFocus = char_11.attMobs[0];
                    }
                    return;
                case 61:
                    if ((char_11 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    if ((TileMap.gameAA(char_11.cx, char_11.cy) & 0x2) == 2) {
                        char_11.gameAA(GameScr.sks[paramMessage.gameAB().readByte()], 0);
                    } else {
                        char_11.gameAA(GameScr.sks[paramMessage.gameAB().readByte()], 1);
                    }
                    if (char_11.isWolf) {
                        char_11.isWolf = false;
                        char_11.timeChatReturn = System.currentTimeMillis();
                        if (char_11.vitaWolf >= 500) {
                            ServerEffect.gameAA(60, char_11, 1);
                        }
                    }
                    if (char_11.isMoto) {
                        char_11.isMoto = false;
                        char_11.gameCP = true;
                        ServerEffect.gameAA(60, char_11, 1);
                    }
                    arrayOfChar1 = new Char[10];
                    b10 = 0;
                    try {
                        for (b10 = 0; b10 < 10; b10++) {
                            Char char_;
                            int i13;
                            if ((i13 = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                                char_ = Char.getMyChar();
                            } else {
                                char_ = GameScr.gameAE(i13);
                            }
                            arrayOfChar1[b10] = char_;
                            if (b10 == 0) {
                                if (char_11.cx <= char_.cx) {
                                    char_11.cdir = 1;
                                } else {
                                    char_11.cdir = -1;
                                }
                            }
                        }
                    } catch (Exception exception) {
                    }
                    if (b10 > 0) {
                        char_11.attChars = new Char[b10];
                        for (b10 = 0; b10 < char_11.attChars.length; b10++) {
                            char_11.attChars[b10] = arrayOfChar1[b10];
                        }
                        char_11.charFocus = char_11.attChars[0];
                    }
                    return;
                case 62:
                    if ((m = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                        (char_11 = Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                        m = paramMessage.gameAB().readInt();
                        int i13 = 0;
                        try {
                            char_11.cMP = paramMessage.gameAB().readInt();
                            i13 = paramMessage.gameAB().readInt();
                        } catch (Exception exception) {
                        }
                        if ((m += i13) == 0) {
                            GameScr.gameAA("", char_11.cx, char_11.cy - char_11.ch, 7);
                        } else if (m < 0) {
                            GameScr.gameAA("-" + -m, char_11.cx, char_11.cy - char_11.ch, 8);
                        } else {
                            GameScr.gameAA("-".concat(String.valueOf(m)), char_11.cx, char_11.cy - char_11.ch, 0);
                        }
                        if ((Char.getMyChar()).cHP < (Char.getMyChar()).cMaxHP / 2) {
                            System.out.println("Bi PK: ".concat(String.valueOf(m)));
                        }
                        return;
                    }
                    if ((char_11 = GameScr.gameAE(m)) == null) {
                        return;
                    }
                    char_11.cHP = paramMessage.gameAB().readInt();
                    m = paramMessage.gameAB().readInt();
                    i8 = 0;
                    try {
                        char_11.cMP = paramMessage.gameAB().readInt();
                        i8 = paramMessage.gameAB().readInt();
                    } catch (Exception exception) {
                    }
                    if ((m += i8) == 0) {
                        GameScr.gameAA("", char_11.cx, char_11.cy - char_11.ch, 4);
                        return;
                    }
                    if (m < 0) {
                        GameScr.gameAA("-" + -m, char_11.cx, char_11.cy - char_11.ch, 3);
                    } else {
                        GameScr.gameAA("-".concat(String.valueOf(m)), char_11.cx, char_11.cy - char_11.ch, 5);
                    }
                    return;
                case 63:
                    myVector2 = new MyVector();
                    try {
                        while (true) {
                            myVector2.addElement(new Command(paramMessage.gameAB().readUTF(), GameCanvas.instance, 88817, null));
                        }
                    } catch (Exception exception) {
                        GameCanvas.menu.gameAA(myVector2);
                        return;
                    }
                case 64:
                    if ((m = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                        char_7 = Char.getMyChar();
                    } else {
                        char_7 = GameScr.gameAE(m);
                    }
                    char_7.moveFast = new short[3];
                    char_7.moveFast[0] = 0;
                    s6 = paramMessage.gameAB().readShort();
                    s1 = paramMessage.gameAB().readShort();
                    char_7.moveFast[1] = s6;
                    char_7.moveFast[2] = s1;
                    char_7.isBlinking = false;
                    try {
                        if ((m = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                            char_7 = Char.getMyChar();
                        } else {
                            char_7 = GameScr.gameAE(m);
                        }
                        char_7.cx = s6;
                        char_7.cy = s1;
                    } catch (Exception exception2) {
                        Exception exception1;
                        (exception1 = null).printStackTrace();
                    }
                    return;
                case 65:
                    if ((char_7 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        GameCanvas.gameAA(char_7.cName + " " + mResources.gameRB, 88812, char_7, 8882, (Object) null);
                    }
                    return;
                case 66:
                    i4 = paramMessage.gameAB().readInt();
                    m = paramMessage.gameAB().readInt();
                    if (i4 != (Char.getMyChar()).charID && m != (Char.getMyChar()).charID) {
                        (GameScr.gameAE(i4)).testCharId = m;
                        (GameScr.gameAE(m)).testCharId = i4;
                        return;
                    }
                    if (i4 == (Char.getMyChar()).charID) {
                        (Char.getMyChar()).testCharId = m;
                        (Char.getMyChar()).npcFocus = null;
                        (Char.getMyChar()).mobFocus = null;
                        (Char.getMyChar()).itemFocus = null;
                        (Char.getMyChar()).charFocus = GameScr.gameAE((Char.getMyChar()).testCharId);
                        (Char.getMyChar()).charFocus.testCharId = (Char.getMyChar()).charID;
                        (GameScr.gI()).gameEI = (GameScr.gI()).gameEH;
                        (GameScr.gI()).gameEH = m;
                        Char.gameHF = true;
                    } else if (m == (Char.getMyChar()).charID) {
                        (Char.getMyChar()).testCharId = i4;
                        (Char.getMyChar()).npcFocus = null;
                        (Char.getMyChar()).mobFocus = null;
                        (Char.getMyChar()).itemFocus = null;
                        (Char.getMyChar()).charFocus = GameScr.gameAE((Char.getMyChar()).testCharId);
                        (Char.getMyChar()).charFocus.testCharId = (Char.getMyChar()).charID;
                        (GameScr.gI()).gameEI = (GameScr.gI()).gameEH;
                        (GameScr.gI()).gameEH = i4;
                        Char.gameHF = true;
                        return;
                    }
                    return;
                case 67:
                    i4 = paramMessage.gameAB().readInt();
                    m = paramMessage.gameAB().readInt();
                    i8 = 0;
                    try {
                        i8 = paramMessage.gameAB().readInt();
                    } catch (Exception exception) {
                    }
                    if (i4 == (Char.getMyChar()).charID) {
                        char_11 = GameScr.gameAE(m);
                        if (i8 > 0) {
                            InfoMe.gameAA(mResources.gameAA(mResources.gameNC, char_11.cName));
                            (Char.getMyChar()).cHP = i8;
                            (Char.getMyChar()).resultTest = 29;
                            if (char_11 != null) {
                                char_11.resultTest = 89;
                            }
                        } else {
                            if (char_11 != null) {
                                char_11.resultTest = 59;
                            }
                            (Char.getMyChar()).resultTest = 59;
                            InfoMe.gameAA(mResources.gameAA(mResources.gameND, char_11.cName));
                        }
                        (Char.getMyChar()).testCharId = -9999;
                        (Char.getMyChar()).charFocus = null;
                        if ((GameScr.gI()).gameEI >= 0) {
                            (GameScr.gI()).gameEH = (GameScr.gI()).gameEI;
                            (GameScr.gI()).gameEI = -1;
                        } else {
                            (GameScr.gI()).gameEH = -1;
                        }
                        if (char_11 != null) {
                            char_11.testCharId = -9999;
                            return;
                        }
                        return;
                    }
                    if (m == (Char.getMyChar()).charID) {
                        char_11 = GameScr.gameAE(i4);
                        if (i8 > 0) {
                            if (char_11 != null) {
                                char_11.cHP = i8;
                            }
                            if (char_11 != null) {
                                char_11.resultTest = 29;
                            }
                            (Char.getMyChar()).resultTest = 89;
                            InfoMe.gameAA(mResources.gameAA(mResources.gameNB, char_11.cName));
                        } else {
                            if (char_11 != null) {
                                char_11.resultTest = 59;
                            }
                            (Char.getMyChar()).resultTest = 59;
                            InfoMe.gameAA(mResources.gameAA(mResources.gameND, char_11.cName));
                        }
                        if (char_11 != null) {
                            char_11.testCharId = -9999;
                        }
                        (Char.getMyChar()).testCharId = -9999;
                        (Char.getMyChar()).charFocus = null;
                        if ((GameScr.gI()).gameEI >= 0) {
                            (GameScr.gI()).gameEH = (GameScr.gI()).gameEI;
                            (GameScr.gI()).gameEI = -1;
                        } else {
                            (GameScr.gI()).gameEH = -1;
                        }
                        return;
                    }
                    char_9 = GameScr.gameAE(i4);
                    char_13 = GameScr.gameAE(m);
                    if (i8 > 0) {
                        if (char_9 != null) {
                            char_9.cHP = i8;
                        }
                        if (char_9 != null) {
                            char_9.resultTest = 29;
                        }
                        if (char_13 != null) {
                            char_13.resultTest = 89;
                        }
                    } else {
                        if (char_9 != null) {
                            char_9.resultTest = 59;
                        }
                        if (char_13 != null) {
                            char_13.resultTest = 59;
                        }
                    }
                    if (char_9 != null) {
                        char_9.testCharId = -9999;
                    }
                    if (char_13 != null) {
                        char_13.testCharId = -9999;
                        return;
                    }
                    return;
                case 68:
                    if ((char_11 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        char_11.killCharId = (Char.getMyChar()).charID;
                        Auto.gameAA(char_11);
                        (Char.getMyChar()).npcFocus = null;
                        (Char.getMyChar()).mobFocus = null;
                        (Char.getMyChar()).itemFocus = null;
                        (Char.getMyChar()).charFocus = char_11;
                        Char.gameHF = true;
                        InfoMe.gameAA(char_11.cName + mResources.gameNF, 20, mFont.tahoma_7_red);
                    }
                    return;
                case 69:
                    (Char.getMyChar()).killCharId = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).npcFocus = null;
                    (Char.getMyChar()).mobFocus = null;
                    (Char.getMyChar()).itemFocus = null;
                    (Char.getMyChar()).charFocus = GameScr.gameAE((Char.getMyChar()).killCharId);
                    Char.gameHF = true;
                    return;
                case 70:
                    char_11 = Char.getMyChar();
                    try {
                        char_11 = GameScr.gameAE(paramMessage.gameAB().readInt());
                    } catch (Exception exception) {
                    }
                    char_11.killCharId = -9999;
                    return;
                case 71:
                    l = paramMessage.gameAB().readLong();
                    (char_2 = Char.getMyChar()).cExpDown -= l;
                    GameScr.gameAA("+".concat(String.valueOf(l)), (Char.getMyChar()).cx, (Char.getMyChar()).cy - (Char.getMyChar()).ch, 2);
                    return;
                case 72:
                    (Char.getMyChar()).cPk = paramMessage.gameAB().readByte();
                    Char.getMyChar().gameAA(paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort());
                    (Char.getMyChar()).cEXP = GameScr.gameAB((Char.getMyChar()).clevel - 1);
                    (Char.getMyChar()).cExpDown = paramMessage.gameAB().readLong();
                    GameScr.gameAA((Char.getMyChar()).cEXP);
                    return;
                case 75:
                    buNhin = new BuNhin(paramMessage.gameAB().readUTF(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort());
                    GameScr.gameBJ.addElement(buNhin);
                    ServerEffect.gameAA(60, buNhin.gameAA, buNhin.gameAB, 1);
                    return;
                case 76:
                    if ((mob7 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte())) == null) {
                        return;
                    }
                    if ((buNhin = GameScr.gameAF(paramMessage.gameAB().readShort())) == null) {
                        return;
                    }
                    s5 = paramMessage.gameAB().readShort();
                    b2 = paramMessage.gameAB().readByte();
                    b16 = paramMessage.gameAB().readByte();
                    mob7.gameAA(buNhin);
                    mob7.gameAA(s5, b2, b16);
                    return;
                case 77:
                    buNhin = (BuNhin) GameScr.gameBJ.elementAt(paramMessage.gameAB().readShort());
                    GameScr.gameBJ.removeElement(buNhin);
                    ServerEffect.gameAA(60, buNhin.gameAA, buNhin.gameAB, 1);
                    return;
                case 78:
                    mob3 = null;
                    try {
                        mob3 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    } catch (Exception exception) {
                    }
                    if (mob3 != null && mob3.status != 0 && mob3.status != 0) {
                        mob3.status = 0;
                        ServerEffect.gameAA(60, mob3.x, mob3.y, 1);
                        ItemMap itemMap1 = new ItemMap(paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), mob3.x, mob3.y, paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort());
                        GameScr.vItemMap.addElement(itemMap1);
                        if (Res.abs(itemMap1.y - (Char.getMyChar()).cy) < 24 && Res.abs(itemMap1.x - (Char.getMyChar()).cx) < 24) {
                            (Char.getMyChar()).charFocus = null;
                            return;
                        }
                    }
                    return;
                case 79:
                    i3 = paramMessage.gameAB().readInt();
                    if (((str9 = paramMessage.gameAB().readUTF()).equals(Code.gameAH) || Code.gameAC(str9)) && !Code.gameAC.gameAM()) {
                        Service.gI().gameAT(i3);
                        return;
                    }
                    GameCanvas.gameAA(str9 + " " + mResources.gameRD, 8887, new Integer(i3), 8888, new Integer(i3));
                    return;
                case 82:
                    GameScr.vParty.removeAllElements();
                    bool2 = paramMessage.gameAB().readBoolean();
                    try {
                        for (byte b19 = 0; b19 < 6; b19++) {
                            GameScr.vParty.addElement(new Party(paramMessage.gameAB().readInt(), paramMessage.gameAB().readByte(), paramMessage.gameAB().readUTF(), bool2));
                        }
                    } catch (Exception exception) {
                    }
                    GameScr.gI().gameAS();
                    str16 = ((Party) GameScr.vParty.firstElement()).name;
                    if (Code.gameAH == null) {
                        Code.gameAH = str16;
                    } else if (!str16.equals(Code.gameAH)) {
                        Service.gI().gameAT();
                        return;
                    }
                    return;
                case 83:
                    GameScr.vParty.removeAllElements();
                    GameScr.gI().gameAS();
                    return;
                case 84:
                    friend1 = new Friend(paramMessage.gameAB().readUTF(), paramMessage.gameAB().readByte());
                    GameScr.gI();
                    GameScr.gameAB(friend1.friendName);
                    if (friend1.type == 0) {
                        InfoMe.gameAA(mResources.gameMO + " " + friend1.friendName + " " + mResources.gameMP);
                        GameScr.vFriend.addElement(friend1);
                    } else if (friend1.type == 1) {
                        for (i3 = 0; i3 < GameScr.vFriend.size(); i3++) {
                            if (((Friend) GameScr.vFriend.elementAt(i3)).friendName.equals(friend1.friendName)) {
                                GameScr.vFriend.removeElementAt(i3);
                                break;
                            }
                        }
                        InfoMe.gameAA(mResources.gameMQ + " " + friend1.friendName + " " + mResources.gameFJ);
                        friend1.type = 3;
                        GameScr.vFriend.insertElementAt(friend1, 0);
                    }
                    if (GameScr.gameDJ) {
                        GameScr.gI();
                        GameScr.gameAC(0);
                        GameScr.indexRow = 0;
                        GameScr.gameBU.gameAA();
                    }
                    return;
                case 85:
                    if ((mob2 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte())) != null) {
                        mob2.isDisable = paramMessage.gameAB().readBoolean();
                    }
                    return;
                case 86:
                    if ((mob2 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte())) != null) {
                        mob2.isDontMove = paramMessage.gameAB().readBoolean();
                    }
                    return;
                case 87:
                    if ((k = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                        char_10 = Char.getMyChar();
                    } else {
                        char_10 = GameScr.gameAE(k);
                    }
                    if (char_10 == null) {
                        return;
                    }
                    i2 = paramMessage.gameAB().readUnsignedByte();
                    s4 = paramMessage.gameAB().readShort();
                    byte ak = paramMessage.gameAB().readByte();
                    b16 = paramMessage.gameAB().readByte();
                    i7 = 0;
                    i11 = -1;
                    try {
                        if ((i7 = paramMessage.gameAB().readByte()) == 1) {
                            i11 = paramMessage.gameAB().readInt();
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if (char_10.mobMe != null) {
                        if (i7 == 0) {
                            Mob mob = Mob.gameAA(i2);
                            char_10.mobMe.gameAA(mob);
                        } else {
                            Char char_ = GameScr.gameAE(i11);
                            char_10.mobMe.gameAB(char_);
                        }
                    }
                    char_10.mobMe.gameAA(s4, ak, b16);
                    return;
                case 88:
                    if ((k = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                        char_10 = Char.getMyChar();
                    } else if ((char_10 = GameScr.gameAE(k)) == null) {
                        return;
                    }
                    char_10.cHP = char_10.cMaxHP;
                    char_10.cMP = char_10.cMaxMP;
                    char_10.cx = paramMessage.gameAB().readShort();
                    char_10.cy = paramMessage.gameAB().readShort();
                    char_10.gameBA();
                    return;
                case 89:
                    if ((mob1 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte())) != null) {
                        mob1.isFire = paramMessage.gameAB().readBoolean();
                    }
                    return;
                case 90:
                    if ((mob1 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte())) != null) {
                        mob1.isIce = paramMessage.gameAB().readBoolean();
                        if (!mob1.isIce) {
                            ServerEffect.gameAA(77, mob1.x, mob1.y - 9, 1);
                            return;
                        }
                    }
                    return;
                case 91:
                    if ((mob1 = Mob.gameAA(paramMessage.gameAB().readUnsignedByte())) != null) {
                        mob1.isWind = paramMessage.gameAB().readBoolean();
                    }
                    return;
                case 92:
                    str2 = paramMessage.gameAB().readUTF();
                    short_ = new Short(paramMessage.gameAB().readShort());
                    GameCanvas.inputDlg.gameAA(str2, new Command(mResources.ACCEPT, GameCanvas.instance, 88818, short_), 0);
                    return;
                case 93:
                    j = paramMessage.gameAB().readInt();
                    GameScr.currentCharViewInfo = new Char();
                    if ((Char.getMyChar()).charID == j) {
                        GameScr.currentCharViewInfo = Char.getMyChar();
                    } else {
                        if ((char_10 = GameScr.gameAE(j)) == null) {
                            GameScr.currentCharViewInfo = new Char();
                        } else {
                            GameScr.currentCharViewInfo = char_10;
                        }
                        GameScr.currentCharViewInfo.charID = j;
                        GameScr.currentCharViewInfo.statusMe = 1;
                        GameScr.gI().gameBK();
                    }
                    GameScr.currentCharViewInfo.cName = paramMessage.gameAB().readUTF();
                    GameScr.currentCharViewInfo.head = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cgender = paramMessage.gameAB().readByte();
                    j = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.nClass = GameScr.nClasss[j];
                    GameScr.currentCharViewInfo.cPk = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.cHP = paramMessage.gameAB().readInt();
                    GameScr.currentCharViewInfo.cMaxHP = paramMessage.gameAB().readInt();
                    GameScr.currentCharViewInfo.cMP = paramMessage.gameAB().readInt();
                    GameScr.currentCharViewInfo.cMaxMP = paramMessage.gameAB().readInt();
                    GameScr.currentCharViewInfo.cspeed = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.cResFire = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cResIce = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cResWind = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cdame = paramMessage.gameAB().readInt();
                    GameScr.currentCharViewInfo.cdameDown = paramMessage.gameAB().readInt();
                    GameScr.currentCharViewInfo.cExactly = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cMiss = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cFatal = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cReactDame = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.sysUp = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.sysDown = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.clevel = paramMessage.gameAB().readUnsignedByte();
                    GameScr.currentCharViewInfo.pointUydanh = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.cClanName = paramMessage.gameAB().readUTF();
                    if (!GameScr.currentCharViewInfo.cClanName.equals("")) {
                        GameScr.currentCharViewInfo.ctypeClan = paramMessage.gameAB().readByte();
                    }
                    GameScr.currentCharViewInfo.pointUydanh = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointNon = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointAo = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointGangtay = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointQuan = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointGiay = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointVukhi = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointLien = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointNhan = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointNgocboi = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.pointPhu = paramMessage.gameAB().readShort();
                    GameScr.currentCharViewInfo.countFinishDay = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.countLoopBoos = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.countPB = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.limitTiemnangso = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.limitKynangso = paramMessage.gameAB().readByte();
                    GameScr.currentCharViewInfo.arrItemBody = new Item[32];
                    try {
                        GameScr.currentCharViewInfo.setDefaultPart();
                        for (int num56 = 0; num56 < 16; num56++) {
                            short num57 = paramMessage.gameAB().readShort();
                            if (num57 > -1) {
                                ItemTemplate itemTemplate = ItemTemplates.gameAA(num57);
                                int num8 = itemTemplate.type;
                                GameScr.currentCharViewInfo.arrItemBody[num8] = new Item();
                                GameScr.currentCharViewInfo.arrItemBody[num8].indexUI = num8;
                                GameScr.currentCharViewInfo.arrItemBody[num8].typeUI = 5;
                                GameScr.currentCharViewInfo.arrItemBody[num8].template = itemTemplate;
                                GameScr.currentCharViewInfo.arrItemBody[num8].isLock = true;
                                GameScr.currentCharViewInfo.arrItemBody[num8].upgrade = paramMessage.gameAB().readByte();
                                GameScr.currentCharViewInfo.arrItemBody[num8].sys = paramMessage.gameAB().readByte();
                                switch (num8) {
                                    case 1:
                                        GameScr.currentCharViewInfo.wp = GameScr.currentCharViewInfo.arrItemBody[num8].template.part;
                                        break;
                                    case 2:
                                        GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[num8].template.part;
                                        break;
                                    case 6:
                                        GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[num8].template.part;
                                        break;
                                }
                            }
                        }
                    } catch (Exception exception1) {
                    }
                    try {
                        for (int num58 = 0; num58 < 16; num58++) {
                            short num59 = paramMessage.gameAB().readShort();
                            if (num59 > -1) {
                                ItemTemplate itemTemplate2 = ItemTemplates.gameAA(num59);
                                int num8 = itemTemplate2.type + 16;
                                GameScr.currentCharViewInfo.arrItemBody[num8] = new Item();
                                GameScr.currentCharViewInfo.arrItemBody[num8].indexUI = num8;
                                GameScr.currentCharViewInfo.arrItemBody[num8].typeUI = 5;
                                GameScr.currentCharViewInfo.arrItemBody[num8].template = itemTemplate2;
                                GameScr.currentCharViewInfo.arrItemBody[num8].isLock = true;
                                GameScr.currentCharViewInfo.arrItemBody[num8].upgrade = paramMessage.gameAB().readByte();
                                GameScr.currentCharViewInfo.arrItemBody[num8].sys = paramMessage.gameAB().readByte();
                                switch (num8) {
                                    case 1:
                                        GameScr.currentCharViewInfo.wp = GameScr.currentCharViewInfo.arrItemBody[num8].template.part;
                                        break;
                                    case 2:
                                        GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[num8].template.part;
                                        break;
                                    case 6:
                                        GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[num8].template.part;
                                        break;
                                }
                            }
                        }
                    } catch (Exception exception) {
                        return;
                    }
                case 94:
                    gameAB(paramMessage);
                    return;
                case 95:
                    i9 = paramMessage.gameAB().readInt();
                    (char_1 = Char.getMyChar()).xu += i9;
                    GameScr.gameAA((i9 > 0) ? "+".concat(String.valueOf(i9)) : String.valueOf(i9), (Char.getMyChar()).cx, (Char.getMyChar()).cy - (Char.getMyChar()).ch - 10, 1);
                    return;
                case 96:
                    (Char.getMyChar()).taskOrders.addElement(new TaskOrder(paramMessage.gameAB().readByte(), paramMessage.gameAB().readInt(), paramMessage.gameAB().readInt(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUnsignedByte(), paramMessage.gameAB().readUnsignedByte()));
                    Char.getMyChar().gameAC(21);
                    LockGame.gameAL();
                    return;
                case 97:
                    b1 = paramMessage.gameAB().readByte();
                    for (b9 = 0; b9 < (Char.getMyChar()).taskOrders.size(); b9++) {
                        TaskOrder taskOrder;
                        if ((taskOrder = (TaskOrder) (Char.getMyChar()).taskOrders.elementAt(b9)).taskId == b1) {
                            taskOrder.count = paramMessage.gameAB().readInt();
                            if (taskOrder.count == taskOrder.maxCount) {
                                Char.getMyChar().gameAC(61);
                            }
                            if (taskOrder.taskId == 0) {
                                AutoNvhn.gameAV = true;
                            }
                            return;
                        }
                    }
                    return;
                case 98:
                    b1 = paramMessage.gameAB().readByte();
                    for (b9 = 0; b9 < (Char.getMyChar()).taskOrders.size(); b9++) {
                        if (((TaskOrder) (Char.getMyChar()).taskOrders.elementAt(b9)).taskId == b1) {
                            (Char.getMyChar()).taskOrders.removeElementAt(b9);
                            break;
                        }
                    }
                    Char.getMyChar().gameAC(21);
                    LockGame.gameAN();
                    return;
                case 99:
                    if ((char_6 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    } else {
                        if (Code.gameAB instanceof LoiLoss) {
                            for (int ask = 0; ask < Code.gameAC(FormDanhVong.TenDoiThu, ",").length; ++ask) {
                                if (char_6.cName.equals(Code.gameAC(FormDanhVong.TenDoiThu, ",")[ask])) {
                                    Service.gI().gameAM(char_6.charID);
                                }
                            }

                            return;
                        }

                        GameCanvas.gameAA(char_6.cName + " " + mResources.gameRC, 88840, char_6, 8882, (Object) null);
                        return;
                    }

                case 100:
                    GameScr.vList.removeAllElements();
                    b1 = paramMessage.gameAB().readByte();
                    for (b8 = 0; b8 < b1; b8++) {
                        try {
                            DunItem dunItem;
                            (dunItem = new DunItem()).id = paramMessage.gameAB().readByte();
                            dunItem.name1 = paramMessage.gameAB().readUTF();
                            dunItem.name2 = paramMessage.gameAB().readUTF();
                            GameScr.vList.addElement(dunItem);
                        } catch (Exception exception) {
                        }
                    }
                    GameScr.gI().gameAQ();
                    return;
                case 101:
                    try {
                        GameScr.currentCharViewInfo.pointTinhTu = paramMessage.gameAB().readInt();
                        GameScr.currentCharViewInfo.limitPhongLoi = paramMessage.gameAB().readByte();
                        GameScr.currentCharViewInfo.limitBangHoa = paramMessage.gameAB().readByte();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    return;
                case 102:
                    if ((item2 = (Char.getMyChar()).arrItemBag[paramMessage.gameAB().readByte()]) != null) {
                        GameScr.gameDE = item2;
                    }
                    (Char.getMyChar()).xu = paramMessage.gameAB().readInt();
                    if (GameScr.gameDE != null) {
                        if (GameScr.gameDE.template.type == 16) {
                            GameScr.gameAS -= GameScr.gameDE.quantity;
                        }
                        if (GameScr.gameDE.template.type == 17) {
                            GameScr.gameAR -= GameScr.gameDE.quantity;
                        }
                        (Char.getMyChar()).arrItemBag[GameScr.gameDE.indexUI] = null;
                        GameScr.gameDE = null;
                        GameScr.gI().gameAU();
                        InfoMe.gameAA(mResources.gameVJ);
                    }
                    GameCanvas.endDlg();
                    return;
                case 103:
                    GameScr.gameBP = paramMessage.gameAB().readByte();
                    GameScr.arrItemStands = new ItemStands[paramMessage.gameAB().readInt()];

                    for (int ala = 0; ala < GameScr.arrItemStands.length; ala++) {
                        GameScr.arrItemStands[ala] = new ItemStands();
                        GameScr.arrItemStands[ala].item = new Item();
                        GameScr.arrItemStands[ala].item.itemId = paramMessage.gameAB().readInt();
                        GameScr.arrItemStands[ala].timeStart = (int) (System.currentTimeMillis() / 1000);
                        GameScr.arrItemStands[ala].timeEnd = paramMessage.gameAB().readInt();
                        GameScr.arrItemStands[ala].item.quantity = paramMessage.gameAB().readUnsignedShort();
                        GameScr.arrItemStands[ala].seller = paramMessage.gameAB().readUTF();
                        GameScr.arrItemStands[ala].price = paramMessage.gameAB().readInt();
                        GameScr.arrItemStands[ala].item.template = ItemTemplates.gameAA(paramMessage.gameAB().readShort());
                    }
                    GameScr.gI().gameAD((int) 37);
                    return;
                case 104:
                    gameAC(paramMessage);
                    return;
                case 106:
                    if ((char_5 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        GameCanvas.gameAA(char_5.cName + " " + mResources.gameVX, 88841, char_5, 8882, (Object) null);
                    }
                    return;
                case 107:
                    b16 = paramMessage.gameAB().readByte();
                    GameCanvas.gameAA(paramMessage.gameAB().readUTF(), 8890, new Integer(b16), 8882, (Object) null);
                    return;
                case 108:
                    Char.getMyChar().gameAB(paramMessage);
                    return;
                case 109:
                    InfoDlg.gameAD();
                    GameCanvas.gameAK();
                    GameCanvas.gameAJ();
                    myVector1 = new MyVector();
                    try {
                        b1 = paramMessage.gameAB().readByte();
                        for (byte b19 = 0; b19 < b1; b19++) {
                            String[] arrayOfString1 = new String[paramMessage.gameAB().readByte()];
                            for (i9 = 0; i9 < arrayOfString1.length; i9++) {
                                arrayOfString1[i9] = paramMessage.gameAB().readUTF();
                            }
                            myVector1.addElement(new Command(arrayOfString1[0], GameCanvas.instance, 88820, arrayOfString1));
                        }
                    } catch (Exception exception) {
                    }
                    if ((Char.getMyChar()).npcFocus == null) {
                        return;
                    }
                    GameCanvas.menu.gameAA(myVector1);
                    return;
                case 112:
                    (item1 = (Char.getMyChar()).arrItemBag[paramMessage.gameAB().readByte()]).upgrade = paramMessage.gameAB().readByte();
                    item1.expires = 0L;
                    return;
                case 114:
                    (GameScr.gI()).gameFH = paramMessage.gameAB().readByte();
                    return;
                case 116:
                    if ((char_10 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        gameAA(char_10, paramMessage);
                    }
                    return;
                case 117:
                    if (GameCanvas.gameAA) {
                        return;
                    }
                    try {
                        if ((b1 = paramMessage.gameAB().readByte()) == -1) {
                            GameCanvas.gameBY.gameAA(paramMessage);
                            return;
                        }
                        Mob.vEggMonter.removeAllElements();
                        TileMap.gameAX.clear();
                        GameScr.gameFK.removeAllElements();
                        GameScr.gameFL.removeAllElements();
                        GameScr.gameFJ.removeAllElements();
                        int var94;
                        byte b19;
                        for (b19 = 0; b19 < b1; b19++) {
                            String str = String.valueOf(paramMessage.gameAB().readShort());
                            byte[] arrayOfByte1 = new byte[paramMessage.gameAB().readInt()];
                            paramMessage.gameAB().read(arrayOfByte1);
                            Image image = gameAA(arrayOfByte1);
                            TileMap.gameAX.put(str, image);
                        }
                        int i13 = paramMessage.gameAB().readUnsignedByte();
                        for (b19 = 0; b19 < i13; b19++) {
                            i7 = paramMessage.gameAB().readUnsignedByte();
                            i9 = paramMessage.gameAB().readUnsignedByte();
                            var94 = paramMessage.gameAB().readUnsignedByte();
                            ItemTree itemTree;
                            (itemTree = new ItemTree(i9, var94)).idTree = i7;
                            GameScr.gameFK.addElement(itemTree);
                        }
                        i13 = paramMessage.gameAB().readUnsignedByte();
                        for (b19 = 0; b19 < i13; b19++) {
                            i7 = paramMessage.gameAB().readUnsignedByte();
                            i9 = paramMessage.gameAB().readUnsignedByte();
                            var94 = paramMessage.gameAB().readUnsignedByte();
                            ItemTree itemTree;
                            (itemTree = new ItemTree(i9, var94)).idTree = i7;
                            GameScr.gameFL.addElement(itemTree);
                        }
                        i13 = paramMessage.gameAB().readUnsignedByte();
                        for (b19 = 0; b19 < i13; b19++) {
                            i7 = paramMessage.gameAB().readUnsignedByte();
                            i9 = paramMessage.gameAB().readUnsignedByte();
                            var94 = paramMessage.gameAB().readUnsignedByte();
                            ItemTree itemTree;
                            (itemTree = new ItemTree(i9, var94)).idTree = i7;
                            GameScr.gameFJ.addElement(itemTree);
                        }
                        return;
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        return;
                    }
                case 118:
                    str1 = paramMessage.gameAB().readUTF();
                    RMS.gameAA("acc", str1);
                    str12 = paramMessage.gameAB().readUTF();
                    RMS.gameAA("pass", str12);
                    SelectServerScr.uname = str1;
                    SelectServerScr.pass = str12;
                    SelectServerScr.unameChange = "";
                    SelectServerScr.passChange = "";
                    if (!str1.startsWith("tmpusr")) {
                        GameScr.gI().gameAB();
                    }
                    Session_ME.gameAE();
                    return;
                case 119:
                    if ((b16 = paramMessage.gameAB().readByte()) == -1) {
                        GameScr.gameFR = true;
                        GameScr.gameAA(true);
                        if ((GameScr.gameGK = paramMessage.gameAB().readInt()) > 360) {
                            GameScr.gameFS = true;
                        } else {
                            GameScr.gameFS = false;
                            GameScr.gameGI = (Char.getMyChar()).cx;
                            GameScr.gameGJ = (Char.getMyChar()).cy;
                        }
                        return;
                    }
                    if (b16 == 0) {
                        if ((char_10 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                            ServerEffect.gameAA(141, char_10.cx, char_10.cy, 2);
                            i9 = paramMessage.gameAB().readShort();
                            char_10.gameGI = i9;
                            i9 = paramMessage.gameAB().readShort();
                            char_10.gameGJ = i9;
                            ServerEffect.gameAA(141, char_10.cx, char_10.cy, 2);
                            return;
                        }
                    } else {
                        GameScr.gameFR = false;
                        GameScr.gameFW = 0;
                    }
                    return;
                case 121:
                    GameScr.vList.removeAllElements();
                    int var6 = paramMessage.gameAB().readUnsignedByte();
                    for (b6 = 0; b6 < var6; b6++) {
                        try {
                            Ranked ranked;
                            (ranked = new Ranked()).name = paramMessage.gameAB().readUTF();
                            ranked.id = paramMessage.gameAB().readInt();
                            ranked.stt = paramMessage.gameAB().readUTF();
                            GameScr.vList.addElement(ranked);
                        } catch (Exception exception) {
                        }
                    }
                    GameScr.gI().gameAP();
                    return;
                case 122:
                    byte ba1;
                    if ((ba1 = paramMessage.gameAB().readByte()) == 0) {
                        gameAI(paramMessage);
                        return;
                    }
                    if (ba1 == 1) {
                        gameAJ(paramMessage);
                        return;
                    }
                    if (ba1 == 2) {
                        gameAL(paramMessage);
                    } else if (ba1 == 3) {
                        gameAK(paramMessage);
                        return;
                    }
                    return;
                case 123:
                    paramMessage.gameAB().readByte();
                    return;
                case 124:
                    gameAM(paramMessage);
                    return;
                case 125:
                    byte ba2;

                    if ((ba2 = paramMessage.gameAB().readByte()) == 0) {
                        gameAN(paramMessage);
                        return;
                    }
                    if (ba2 == 1) {
                        gameAO(paramMessage);
                    } else if (ba2 == 2) {
                        gameAP(paramMessage);
                        return;
                    }
                    return;
                case 126:
                    break;
            }
            int i = paramMessage.gameAB().readByte();
            GameCanvas.endDlg();
            if (i == 0) {
                GameScr.instance.gameAU();
            }
            return;
        } catch (Exception exception) {
            System.out.println("ERROR COMAND: " + paramMessage.gameAA);
            exception.printStackTrace();
            return;
        } finally {
            paramMessage.gameAD();
        }
    }

    private static void gameAA(DataInputStream var0) {
        try {
            GameScr.gameEO = var0.readByte();
            GameScr.gameBR = new ItemOptionTemplate[var0.readUnsignedByte()];

            for (int var1 = 0; var1 < GameScr.gameBR.length; ++var1) {
                GameScr.gameBR[var1] = new ItemOptionTemplate();
                GameScr.gameBR[var1].id = var1;
                GameScr.gameBR[var1].name = var0.readUTF();
                GameScr.gameBR[var1].type = var0.readByte();
            }

            short var4 = var0.readShort();

            for (int var2 = 0; var2 < var4; ++var2) {
                ItemTemplates.gameAA(new ItemTemplate((short) var2, var0.readByte(), var0.readByte(), var0.readUTF(), var0.readUTF(), var0.readByte(), var0.readShort(), var0.readShort(), var0.readBoolean()));
            }

        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    private static void gameAB(DataInputStream var0) {
        try {
            GameScr.gameEN = var0.readByte();
            GameScr.gameBS = new SkillOptionTemplate[var0.readByte()];

            int var1;
            for (var1 = 0; var1 < GameScr.gameBS.length; ++var1) {
                GameScr.gameBS[var1] = new SkillOptionTemplate();
                GameScr.gameBS[var1].id = var1;
                GameScr.gameBS[var1].name = var0.readUTF();
            }

            GameScr.nClasss = new NClass[var0.readUnsignedByte()];

            for (var1 = 0; var1 < GameScr.nClasss.length; ++var1) {
                GameScr.nClasss[var1] = new NClass();
                GameScr.nClasss[var1].classId = var1;
                GameScr.nClasss[var1].name = var0.readUTF();
                GameScr.nClasss[var1].skillTemplates = new SkillTemplate[var0.readByte()];

                for (int var2 = 0; var2 < GameScr.nClasss[var1].skillTemplates.length; ++var2) {
                    GameScr.nClasss[var1].skillTemplates[var2] = new SkillTemplate();
                    GameScr.nClasss[var1].skillTemplates[var2].id = var0.readByte();
                    GameScr.nClasss[var1].skillTemplates[var2].name = var0.readUTF();
                    GameScr.nClasss[var1].skillTemplates[var2].maxPoint = var0.readByte();
                    GameScr.nClasss[var1].skillTemplates[var2].type = var0.readByte();
                    GameScr.nClasss[var1].skillTemplates[var2].iconId = var0.readShort();
                    short var3 = 150;
                    if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
                        var3 = 100;
                    }

                    GameScr.nClasss[var1].skillTemplates[var2].description = mFont.tahoma_7_white.gameAB(var0.readUTF(), var3);
                    GameScr.nClasss[var1].skillTemplates[var2].skills = new Skill[var0.readByte()];

                    for (int var6 = 0; var6 < GameScr.nClasss[var1].skillTemplates[var2].skills.length; ++var6) {
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6] = new Skill();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].skillId = var0.readShort();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].template = GameScr.nClasss[var1].skillTemplates[var2];
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].point = var0.readByte();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].level = var0.readByte();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].manaUse = var0.readShort();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].coolDown = var0.readInt();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].dx = var0.readShort();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].dy = var0.readShort();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].maxFight = var0.readByte();
                        GameScr.nClasss[var1].skillTemplates[var2].skills[var6].options = new SkillOption[var0.readByte()];

                        for (int var4 = 0; var4 < GameScr.nClasss[var1].skillTemplates[var2].skills[var6].options.length; ++var4) {
                            GameScr.nClasss[var1].skillTemplates[var2].skills[var6].options[var4] = new SkillOption();
                            GameScr.nClasss[var1].skillTemplates[var2].skills[var6].options[var4].param = var0.readShort();
                            GameScr.nClasss[var1].skillTemplates[var2].skills[var6].options[var4].optionTemplate = GameScr.gameBS[var0.readByte()];
                        }

                        Skills.gameAA(GameScr.nClasss[var1].skillTemplates[var2].skills[var6]);
                    }
                }
            }

        } catch (IOException var5) {
            var5.printStackTrace();
        }
    }

    private static void gameAC(DataInputStream var0) {
        try {
            GameScr.gameEM = var0.readByte();
            TileMap.mapNames = new String[var0.readUnsignedByte()];

            int var1;
            for (var1 = 0; var1 < TileMap.mapNames.length; ++var1) {
                TileMap.mapNames[var1] = var0.readUTF();
            }

            Npc.arrNpcTemplate = new NpcTemplate[var0.readByte()];

            int var2;
            for (byte var5 = 0; var5 < Npc.arrNpcTemplate.length; ++var5) {
                Npc.arrNpcTemplate[var5] = new NpcTemplate();
                Npc.arrNpcTemplate[var5].npcTemplateId = var5;
                Npc.arrNpcTemplate[var5].name = var0.readUTF();
                Npc.arrNpcTemplate[var5].headId = var0.readShort();
                Npc.arrNpcTemplate[var5].bodyId = var0.readShort();
                Npc.arrNpcTemplate[var5].legId = var0.readShort();
                Npc.arrNpcTemplate[var5].menu = new String[var0.readByte()][];

                for (var2 = 0; var2 < Npc.arrNpcTemplate[var5].menu.length; ++var2) {
                    Npc.arrNpcTemplate[var5].menu[var2] = new String[var0.readByte()];

                    for (int var3 = 0; var3 < Npc.arrNpcTemplate[var5].menu[var2].length; ++var3) {
                        Npc.arrNpcTemplate[var5].menu[var2][var3] = var0.readUTF();
                    }
                }
            }

            Mob.arrMobTemplate = new MobTemplate[var1 = var0.readUnsignedByte()];

            for (var2 = 0; var2 < var1; ++var2) {
                Mob.arrMobTemplate[var2] = new MobTemplate();
                Mob.arrMobTemplate[var2].mobTemplateId = (short) var2;
                Mob.arrMobTemplate[var2].type = var0.readByte();
                Mob.arrMobTemplate[var2].name = var0.readUTF();
                Mob.arrMobTemplate[var2].hp = var0.readInt();
                Mob.arrMobTemplate[var2].rangeMove = var0.readByte();
                Mob.arrMobTemplate[var2].speed = var0.readByte();
            }

        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }

    private static void gameAD(DataInputStream var0) {
        try {
            GameScr.gameEL = var0.readByte();
            RMS.gameAA("nj_arrow", NinjaUtil.gameAA(var0));
            RMS.gameAA("nj_effect", NinjaUtil.gameAA(var0));
            RMS.gameAA("nj_image", NinjaUtil.gameAA(var0));
            RMS.gameAA("nj_part", NinjaUtil.gameAA(var0));
            RMS.gameAA("nj_skill", NinjaUtil.gameAA(var0));
            GameScr.gameEK = new byte[(GameScr.gameEJ = new byte[var0.readByte()][]).length][];

            int var1;
            for (var1 = 0; var1 < GameScr.gameEJ.length; ++var1) {
                GameScr.gameEJ[var1] = new byte[var0.readByte()];
                GameScr.gameEK[var1] = new byte[GameScr.gameEJ[var1].length];

                for (int var2 = 0; var2 < GameScr.gameEJ[var1].length; ++var2) {
                    GameScr.gameEJ[var1][var2] = var0.readByte();
                    GameScr.gameEK[var1][var2] = var0.readByte();
                }
            }

            GameScr.exps = new long[var0.readUnsignedByte()];

            for (var1 = 0; var1 < GameScr.exps.length; ++var1) {
                GameScr.exps[var1] = var0.readLong();
            }

            GameScr.crystals = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.crystals.length; ++var1) {
                GameScr.crystals[var1] = var0.readInt();
            }

            GameScr.upClothe = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.upClothe.length; ++var1) {
                GameScr.upClothe[var1] = var0.readInt();
            }

            GameScr.upAdorn = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.upAdorn.length; ++var1) {
                GameScr.upAdorn[var1] = var0.readInt();
            }

            GameScr.upWeapon = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.upWeapon.length; ++var1) {
                GameScr.upWeapon[var1] = var0.readInt();
            }

            GameScr.coinUpCrystals = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.coinUpCrystals.length; ++var1) {
                GameScr.coinUpCrystals[var1] = var0.readInt();
            }

            GameScr.coinUpClothes = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.coinUpClothes.length; ++var1) {
                GameScr.coinUpClothes[var1] = var0.readInt();
            }

            GameScr.coinUpAdorns = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.coinUpAdorns.length; ++var1) {
                GameScr.coinUpAdorns[var1] = var0.readInt();
            }

            GameScr.coinUpWeapons = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.coinUpWeapons.length; ++var1) {
                GameScr.coinUpWeapons[var1] = var0.readInt();
            }

            GameScr.goldUps = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.goldUps.length; ++var1) {
                GameScr.goldUps[var1] = var0.readInt();
            }

            GameScr.maxPercents = new int[var0.readByte()];

            for (var1 = 0; var1 < GameScr.maxPercents.length; ++var1) {
                GameScr.maxPercents[var1] = var0.readInt();
            }

            Effect.effTemplates = new EffectTemplate[var0.readByte()];

            for (var1 = 0; var1 < Effect.effTemplates.length; ++var1) {
                Effect.effTemplates[var1] = new EffectTemplate();
                Effect.effTemplates[var1].id = var0.readByte();
                Effect.effTemplates[var1].type = var0.readByte();
                EffectTemplate[] var10000 = Effect.effTemplates;
                var0.readUTF();
                Effect.effTemplates[var1].iconId = var0.readShort();
            }

        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public static Image gameAA(byte[] var0) {
        try {
            return Image.createImage(var0, 0, var0.length);
        } catch (Exception var1) {
            return null;
        }
    }

    private static void gameAD(Message var0) {
        try {
            Auto.gameAA();
            Auto.gameAB();
            Auto.gameAM = false;
            Char var1;
            (var1 = Char.getMyChar()).gameAE = null;
            var1.cx = var1.cxSend = var0.gameAB().readShort();
            var1.cy = var1.cySend = var0.gameAB().readShort();
            byte var9 = var0.gameAB().readByte();

            int var2;
            for (var2 = 0; var2 < var9; ++var2) {
                TileMap.vGo.addElement(new Waypoint(var0.gameAB().readShort(), var0.gameAB().readShort(), var0.gameAB().readShort(), var0.gameAB().readShort()));
            }

            Auto.gameAA();
            var9 = var0.gameAB().readByte();

            byte var3;
            for (var3 = 0; var3 < var9; ++var3) {
                GameScr.gameAA((Mob) (new Mob((short) var3, var0.gameAB().readBoolean(), var0.gameAB().readBoolean(), var0.gameAB().readBoolean(), var0.gameAB().readBoolean(), var0.gameAB().readBoolean(), var0.gameAB().readUnsignedByte(), var0.gameAB().readByte(), var0.gameAB().readInt(), var0.gameAB().readUnsignedByte(), var0.gameAB().readInt(), var0.gameAB().readShort(), var0.gameAB().readShort(), var0.gameAB().readByte(), var0.gameAB().readByte(), var0.gameAB().readBoolean(), false)), (int) var3);
            }

            var9 = var0.gameAB().readByte();

            for (var3 = 0; var3 < var9; ++var3) {
                GameScr.gameBJ.addElement(new BuNhin(var0.gameAB().readUTF(), var0.gameAB().readShort(), var0.gameAB().readShort()));
            }

            var9 = var0.gameAB().readByte();

            for (var2 = 0; var2 < var9; ++var2) {
                GameScr.vNpc.addElement(new Npc(var0.gameAB().readByte(), var0.gameAB().readShort(), var0.gameAB().readShort(), var0.gameAB().readByte()));
            }

            var9 = var0.gameAB().readByte();

            for (var2 = 0; var2 < var9; ++var2) {
                ItemMap var10 = new ItemMap(var0.gameAB().readShort(), var0.gameAB().readShort(), var0.gameAB().readShort(), var0.gameAB().readShort());
                boolean var4 = false;

                for (int var5 = 0; var5 < GameScr.vItemMap.size(); ++var5) {
                    if (((ItemMap) GameScr.vItemMap.elementAt(var5)).itemMapID == var10.itemMapID) {
                        var4 = true;
                        break;
                    }
                }

                if (!var4) {
                    GameScr.vItemMap.addElement(var10);
                }
            }

            GameScr.gameAA(false);

            try {
                TileMap.gameAJ = null;
                TileMap.mapName = TileMap.gameAJ = var0.gameAB().readUTF();
            } catch (Exception var6) {
            }

            try {
                TileMap.gameAW.clear();
                var2 = var0.gameAB().readUnsignedByte();

                for (int var11 = 0; var11 < var2; ++var11) {
                    int var12 = var0.gameAB().readUnsignedByte();
                    String var13 = String.valueOf((short) (var0.gameAB().readUnsignedByte() * TileMap.tmw + var12));
                    TileMap.gameAW.put(var13, "location");
                }
            } catch (Exception var7) {
                var7.printStackTrace();
            }

            TileMap.gameAA(TileMap.gameAE);
            Char.getMyChar().cvx = 0;
            Char.getMyChar().statusMe = 4;
            GameScr.gI().gameAO();
            GameCanvas.gameAC(TileMap.bgID);
            Char.gameGM = false;
            Char.gameGL = false;
            GameCanvas.gameAK();
            GameCanvas.gameAJ();
            if (!TileMap.gameBE || TileMap.gameBD == TileMap.mapID) {
                GameScr.gI().gameAB();
                InfoDlg.gameAD();
                InfoDlg.gameAA(TileMap.mapName, mResources.gameRH + " " + TileMap.zoneID, 30);
                Party.gameAA();
                GameCanvas.endDlg();
            }

            Session_ME.gameAE();
            GameCanvas.isLoading = false;
        } catch (Exception var8) {
        }

        TileMap.gameAG();
    }

    private void gameAE(Message var1) {
        try {
            int var2;
            byte var3;
            short var4;
            Char var34;
            String var35;
            int var36;
            byte[] var48;
            switch (var1.gameAB().readByte()) {
                case -126:
                    var3 = var1.gameAB().readByte();
                    LoginScr.isLoggingIn = false;
                    SelectCharScr var51;
                    (var51 = SelectCharScr.gameAA()).name = new String[3];
                    var51.parthead = new int[3];
                    var51.partleg = new int[3];
                    var51.partbody = new int[3];
                    var51.partWp = new int[3];
                    var51.level = new int[3];
                    var51.phai = new String[3];
                    var51.gender = new byte[3];
                    if (GameCanvas.isTouch) {
                        var51.indexSelect = -1;
                    } else {
                        var51.indexSelect = 0;
                    }

                    GameScr.gI();
                    GameScr.gameAI();
                    SmallImage.gameAD();
                    byte var38 = 0;

                    for (; var38 < var3; ++var38) {
                        SelectCharScr.gameAA().gender[var38] = var1.gameAB().readByte();
                        SelectCharScr.gameAA().name[var38] = var1.gameAB().readUTF();
                        SelectCharScr.gameAA().phai[var38] = var1.gameAB().readUTF();
                        SelectCharScr.gameAA().level[var38] = var1.gameAB().readUnsignedByte();
                        SelectCharScr.gameAA().parthead[var38] = var1.gameAB().readShort();
                        SelectCharScr.gameAA().partWp[var38] = var1.gameAB().readShort();
                        SelectCharScr.gameAA().partbody[var38] = var1.gameAB().readShort();
                        SelectCharScr.gameAA().partleg[var38] = var1.gameAB().readShort();
                        if (SelectCharScr.gameAA().partWp[var38] == -1) {
                            SelectCharScr.gameAA().partWp[var38] = 15;
                        }

                        if (SelectCharScr.gameAA().partbody[var38] == -1) {
                            if (SelectCharScr.gameAA().gender[var38] == 0) {
                                SelectCharScr.gameAA().partbody[var38] = 10;
                            } else {
                                SelectCharScr.gameAA().partbody[var38] = 1;
                            }
                        }

                        if (SelectCharScr.gameAA().partleg[var38] == -1) {
                            if (SelectCharScr.gameAA().gender[var38] == 0) {
                                SelectCharScr.gameAA().partleg[var38] = 9;
                            } else {
                                SelectCharScr.gameAA().partleg[var38] = 0;
                            }
                        }
                    }

                    SelectCharScr.gameAA().gameAB();
                    GameCanvas.endDlg();
                    Session_ME.gameAE();
                    return;
                case -125:
                case -124:
                case -118:
                case -110:
                case -107:
                case -105:
                case -104:
                case -103:
                case -102:
                case -101:
                case -100:
                case -94:
                case -92:
                case -91:
                case -89:
                case -87:
                case -85:
                case -82:
                case -79:
                case -78:
                case -76:
                case -75:
                case -74:
                case -73:
                case -71:
                case -69:
                case -68:
                case -65:
                case -64:
                case -63:
                default:
                    return;
                case -123:
                    GameScr.gameEP = var1.gameAB().readByte();
                    GameScr.gameEQ = var1.gameAB().readByte();
                    GameScr.gameER = var1.gameAB().readByte();
                    GameScr.gameES = var1.gameAB().readByte();
                    System.out.println("****** DATA VERSION: Server " + GameScr.gameEP + " Client " + GameScr.gameEL);
                    System.out.println("****** MAP VERSION: Server " + GameScr.gameEQ + " Client " + GameScr.gameEM);
                    System.out.println("****** SKILL VERSION: Server " + GameScr.gameER + " Client " + GameScr.gameEN);
                    System.out.println("****** ITEM VERSION: Server " + GameScr.gameES + " Client " + GameScr.gameEO);
                    if (GameScr.gameEP != GameScr.gameEL) {
                        Service.gI().gameAM();
                    } else {
                        try {
                            gameAD(new DataInputStream(new ByteArrayInputStream(RMS.gameAB("data"))));
                        } catch (Exception var30) {
                            GameScr.gameEL = -1;
                            Service.gI().gameAM();
                        }
                    }

                    if (GameScr.gameEQ != GameScr.gameEM) {
                        Service.gI().gameAN();
                    } else {
                        try {
                            gameAC(new DataInputStream(new ByteArrayInputStream(RMS.gameAB("map"))));
                        } catch (Exception var29) {
                            GameScr.gameEM = -1;
                            Service.gI().gameAN();
                        }
                    }

                    if (GameScr.gameER != GameScr.gameEN) {
                        Service.gI().gameAO();
                    } else {
                        try {
                            gameAB(new DataInputStream(new ByteArrayInputStream(RMS.gameAB("skill"))));
                        } catch (Exception var28) {
                            GameScr.gameEN = -1;
                            Service.gI().gameAO();
                        }
                    }

                    if (GameScr.gameES != GameScr.gameEO) {
                        Service.gI().gameAP();
                    } else {
                        try {
                            gameAA(new DataInputStream(new ByteArrayInputStream(RMS.gameAB("item"))));
                        } catch (Exception var27) {
                            GameScr.gameEO = -1;
                            Service.gI().gameAP();
                        }
                    }

                    if (GameScr.gameEP == GameScr.gameEL && GameScr.gameEQ == GameScr.gameEM && GameScr.gameER == GameScr.gameEN && GameScr.gameES == GameScr.gameEO) {
                        GameScr.gI();
                        GameScr.gameAJ();
                        GameScr.gI();
                        GameScr.gameAK();
                        GameScr.gI();
                        GameScr.gameAL();
                        Service.gI().gameAQ();
                    }

                    return;
                case -122:
                    System.out.println("GET UPDATE_DATA " + var1.gameAB().available() + " bytes");
                    var1.gameAB().mark(100000);
                    gameAD(var1.gameAB());
                    var1.gameAB().reset();
                    var48 = new byte[var1.gameAB().available()];
                    var1.gameAB().readFully(var48);
                    RMS.gameAA("data", var48);
                    var48 = new byte[]{GameScr.gameEL};
                    RMS.gameAA("dataVersion", var48);
                    if (GameScr.gameEP == GameScr.gameEL && GameScr.gameEQ == GameScr.gameEM && GameScr.gameER == GameScr.gameEN && GameScr.gameES == GameScr.gameEO) {
                        GameScr.gI();
                        GameScr.gameAJ();
                        GameScr.gI();
                        GameScr.gameAK();
                        GameScr.gI();
                        GameScr.gameAL();
                        Service.gI().gameAQ();
                        return;
                    }

                    return;
                case -121:
                    System.out.println("GET UPDATE_MAP " + var1.gameAB().available() + " bytes");
                    var1.gameAB().mark(100000);
                    gameAC(var1.gameAB());
                    var1.gameAB().reset();
                    var48 = new byte[var1.gameAB().available()];
                    var1.gameAB().readFully(var48);
                    RMS.gameAA("map", var48);
                    var48 = new byte[]{GameScr.gameEM};
                    RMS.gameAA("mapVersion", var48);
                    if (GameScr.gameEP != GameScr.gameEL || GameScr.gameEQ != GameScr.gameEM || GameScr.gameER != GameScr.gameEN || GameScr.gameES != GameScr.gameEO) {
                        return;
                    }

                    GameScr.gameAJ();
                    GameScr.gameAK();
                    GameScr.gameAL();
                    Service.gI().gameAQ();
                    return;
                case -120:
                    System.out.println("GET UPDATE_SKILL " + var1.gameAB().available() + " bytes");
                    var1.gameAB().mark(100000);
                    gameAB(var1.gameAB());
                    var1.gameAB().reset();
                    var48 = new byte[var1.gameAB().available()];
                    var1.gameAB().readFully(var48);
                    if (Char.getMyChar().isHuman) {
                        RMS.gameAA("skill", var48);
                    } else {
                        RMS.gameAA("skillnhanban", var48);
                    }

                    var48 = new byte[]{GameScr.gameEN};
                    RMS.gameAA("skillVersion", var48);
                    if (GameScr.gameEP != GameScr.gameEL || GameScr.gameEQ != GameScr.gameEM || GameScr.gameER != GameScr.gameEN || GameScr.gameES != GameScr.gameEO) {
                        return;
                    }

                    GameScr.gameAJ();
                    GameScr.gameAK();
                    GameScr.gameAL();
                    Service.gI().gameAQ();
                    return;
                case -119:
                    System.out.println("GET UPDATE_ITEM " + var1.gameAB().available() + " bytes");
                    var1.gameAB().mark(100000);
                    gameAA(var1.gameAB());
                    var1.gameAB().reset();
                    var48 = new byte[var1.gameAB().available()];
                    var1.gameAB().readFully(var48);
                    RMS.gameAA("item", var48);
                    var48 = new byte[]{GameScr.gameEO};
                    RMS.gameAA("itemVersion", var48);
                    if (GameScr.gameEP == GameScr.gameEL && GameScr.gameEQ == GameScr.gameEM && GameScr.gameER == GameScr.gameEN && GameScr.gameES == GameScr.gameEO) {
                        GameScr.gameAJ();
                        GameScr.gameAK();
                        GameScr.gameAL();
                        Service.gI().gameAQ();
                        return;
                    }
                case -117:
                    break;
                case -116:
                    Char.getMyChar().xu = var1.gameAB().readInt();
                    Char.clan.coin = var1.gameAB().readInt();
                    return;
                case -115:
                    var2 = var1.gameAB().readInt();
                    byte[] var37 = NinjaUtil.gameAB(var1);
                    SmallImage.gameAA(var2, var37);
                    return;
                case -114:
                    if (Char.clan == null) {
                        Char.clan = new Clan();
                    }

                    Char.clan.gameAA(var1.gameAB().readUTF());
                    return;
                case -113:
                    if (Char.clan == null) {
                        Char.clan = new Clan();
                    }

                    Char.clan.name = var1.gameAB().readUTF();
                    Char.clan.gameAJ = var1.gameAB().readUTF();
                    var1.gameAB().readUTF();
                    Char.clan.gameAN = var1.gameAB().readShort();
                    Char.clan.icon = var1.gameAB().readByte();
                    Char.clan.level = var1.gameAB().readByte();
                    Char.clan.exp = var1.gameAB().readInt();
                    Char.clan.expNext = var1.gameAB().readInt();
                    Char.clan.coin = var1.gameAB().readInt();
                    Char.clan.freeCoin = var1.gameAB().readInt();
                    Char.clan.coinUp = var1.gameAB().readInt();
                    Char.clan.gameAK = var1.gameAB().readUTF();
                    Char.clan.gameAM = var1.gameAB().readUTF();
                    Char.clan.gameAO = var1.gameAB().readInt();
                    Char.clan.itemLevel = var1.gameAB().readByte();
                    return;
                case -112:
                    GameScr.vClan.removeAllElements();
                    var4 = var1.gameAB().readShort();

                    for (var36 = 0; var36 < var4; ++var36) {
                        GameScr.vClan.addElement(new Member(var1.gameAB().readByte(), var1.gameAB().readByte(), var1.gameAB().readByte(), var1.gameAB().readUTF(), var1.gameAB().readInt(), var1.gameAB().readBoolean()));
                    }

                    try {
                        for (var36 = 0; var36 < var4; ++var36) {
                            ((Member) GameScr.vClan.elementAt(var36)).gameAG = var1.gameAB().readInt();
                        }
                    } catch (Exception var31) {
                    }

                    GameScr.gI();
                    GameScr.gameAX();
                    return;
                case -111:
                    Char.clan.items = new Item[30];
                    var3 = var1.gameAB().readByte();

                    for (var2 = 0; var2 < var3; ++var2) {
                        Char.clan.items[var2] = new Item();
                        Char.clan.items[var2].typeUI = 39;
                        Char.clan.items[var2].indexUI = var2;
                        Char.clan.items[var2].quantity = var1.gameAB().readShort();
                        Char.clan.items[var2].template = ItemTemplates.gameAA(var1.gameAB().readShort());
                    }

                    GameScr.gI().gameBO();
                    byte var5 = var1.gameAB().readByte();

                    for (var36 = 0; var36 < var5; ++var36) {
                        String var41 = var1.gameAB().readUTF();
                        var4 = var1.gameAB().readShort();
                        short var40 = var1.gameAB().readShort();
                        int var43 = var1.gameAB().readInt();
                        var35 = "";
                        MyVector var44 = new MyVector();
                        int var45 = -1;
                        int var47 = -1;
                        byte var49 = var1.gameAB().readByte();
                        if (var43 >= 0) {
                            var35 = var1.gameAB().readUTF();
                        } else {
                            for (int var13 = 0; var13 < var49; ++var13) {
                                String var46 = var1.gameAB().readUTF();
                                var44.addElement(var46);
                            }

                            var45 = var1.gameAB().readInt();
                            var47 = var1.gameAB().readInt();
                        }

                        byte var50 = var1.gameAB().readByte();
                        GameScr.gI().gameAA(new Clan_ThanThu(var41, var50, var4, var40, var43, var35, var44, var45, var47));
                    }

                    return;
                case -109:
                    try {
                        GameCanvas.isLoading = true;
                        TileMap.gameAF = null;
                        TileMap.gameAG = null;
                        System.gc();
                        TileMap.gameAA(TileMap.mapID, var1.gameAB());
                        TileMap.gameAH();
                        gameAD(this.messWait);
                    } catch (Exception var26) {
                        var26.printStackTrace();
                    }

                    var1.gameAD();
                    this.messWait.gameAD();
                    this.messWait = null;
                    var1 = null;
                    return;
                case -108:
                    var4 = var1.gameAB().readShort();

                    try {
                        var3 = var1.gameAB().readByte();
                        Mob.arrMobTemplate[var4].typeFly = var3;
                    } catch (Exception var25) {
                    }

                    var3 = var1.gameAB().readByte();
                    Mob.arrMobTemplate[var4].imgs = new Image[var3];
                    if (var4 != 98 && var4 != 99) {
                        for (var36 = 0; var36 < Mob.arrMobTemplate[var4].imgs.length; ++var36) {
                            Mob.arrMobTemplate[var4].imgs[var36] = gameAA(NinjaUtil.gameAB(var1));
                        }

                        if (var4 == 219) {
                            GameScr.gI().gameAA(Mob.arrMobTemplate[var4].imgs[0]);
                        }
                    } else {
                        Mob.arrMobTemplate[var4].imgs = new Image[3];
                        Image var6 = gameAA(NinjaUtil.gameAB(var1));

                        for (var2 = 0; var2 < Mob.arrMobTemplate[var4].imgs.length; ++var2) {
                            Mob.arrMobTemplate[var4].imgs[var2] = var6;
                        }
                    }

                    int var39;
                    if (var1.gameAB().readBoolean()) {
                        var3 = var1.gameAB().readByte();
                        Mob.arrMobTemplate[var4].frameBossMove = new byte[var3];

                        for (var2 = 0; var2 < var3; ++var2) {
                            Mob.arrMobTemplate[var4].frameBossMove[var2] = var1.gameAB().readByte();
                        }

                        var3 = var1.gameAB().readByte();
                        Mob.arrMobTemplate[var4].frameBossAttack = new byte[var3][];

                        for (var2 = 0; var2 < var3; ++var2) {
                            Mob.arrMobTemplate[var4].frameBossAttack[var2] = new byte[var1.gameAB().readByte()];

                            for (var39 = 0; var39 < Mob.arrMobTemplate[var4].frameBossAttack[var2].length; ++var39) {
                                Mob.arrMobTemplate[var4].frameBossAttack[var2][var39] = var1.gameAB().readByte();
                            }
                        }
                    }

                    if (var1.gameAB().readInt() <= 0) {
                        return;
                    }

                    Mob.arrMobTemplate[var4].imginfo = new ImageInfo[var1.gameAB().readByte()];

                    for (var39 = 0; var39 < Mob.arrMobTemplate[var4].imginfo.length; ++var39) {
                        Mob.arrMobTemplate[var4].imginfo[var39] = new ImageInfo();
                        var1.gameAB().readByte();
                        Mob.arrMobTemplate[var4].imginfo[var39].x0 = var1.gameAB().readUnsignedByte();
                        Mob.arrMobTemplate[var4].imginfo[var39].y0 = var1.gameAB().readUnsignedByte();
                        Mob.arrMobTemplate[var4].imginfo[var39].w = var1.gameAB().readUnsignedByte();
                        Mob.arrMobTemplate[var4].imginfo[var39].h = var1.gameAB().readUnsignedByte();
                    }

                    Mob.arrMobTemplate[var4].frameBoss = new Frame[var1.gameAB().readShort()];

                    for (var39 = 0; var39 < Mob.arrMobTemplate[var4].frameBoss.length; ++var39) {
                        Mob.arrMobTemplate[var4].frameBoss[var39] = new Frame();
                        var3 = var1.gameAB().readByte();
                        Mob.arrMobTemplate[var4].frameBoss[var39].dx = new short[var3];
                        Mob.arrMobTemplate[var4].frameBoss[var39].dy = new short[var3];
                        Mob.arrMobTemplate[var4].frameBoss[var39].idImg = new byte[var3];

                        for (var2 = 0; var2 < var3; ++var2) {
                            Mob.arrMobTemplate[var4].frameBoss[var39].dx[var2] = var1.gameAB().readShort();
                            Mob.arrMobTemplate[var4].frameBoss[var39].dy[var2] = var1.gameAB().readShort();
                            Mob.arrMobTemplate[var4].frameBoss[var39].idImg[var2] = var1.gameAB().readByte();
                        }
                    }

                    var4 = var1.gameAB().readShort();

                    for (var36 = 0; var36 < var4; ++var36) {
                        var1.gameAB().readShort();
                    }

                    return;
                case -106:
                    GameScr.gameFD = var1.gameAB().readByte();
                    return;
                case -99:
                    GameCanvas.gameBL.gameAA(mResources.gameBW, mResources.gameBX);
                    var35 = var1.gameAB().readUTF();
                    GameCanvas.gameBL.gameAA(var35, new Command(mResources.CLOSE, GameCanvas.instance, 8882, (Object) null), new Command(mResources.gameCB, GameCanvas.instance, 88816, (Object) null), 0, 1);
                    return;
                case -98:
                    Char.getMyChar();
                    Char.gameBB();
                    return;
                case -97:
                    GameCanvas.isLoading = false;
                    GameCanvas.endDlg();
                    Integer var7 = new Integer(var1.gameAB().readInt());
                    GameCanvas.inputDlg.gameAA(mResources.gameFE, new Command(mResources.OK, GameCanvas.instance, 88829, var7), 0);
                    return;
                case -96:
                    Char.getMyChar().cClanName = var1.gameAB().readUTF();
                    Char.getMyChar().ctypeClan = 4;
                    Char.getMyChar().luong = var1.gameAB().readInt();
                    Char.getMyChar().gameAC(21);
                    return;
                case -95:
                    if (Char.clan != null) {
                        Char.clan.gameAM = var1.gameAB().readUTF();
                    }

                    return;
                case -93:
                    if ((var2 = var1.gameAB().readInt()) == Char.getMyChar().charID) {
                        GameScr.vClan.removeAllElements();
                        Char.getMyChar().cClanName = "";
                        Char.getMyChar().ctypeClan = -1;
                        Char.clan = null;
                    } else {
                        GameScr.vClan.removeAllElements();
                        Char var42;
                        (var42 = GameScr.gameAE(var2)).cClanName = "";
                        var42.ctypeClan = -1;
                    }

                    return;
                case -90:
                    Char.getMyChar().xu = var1.gameAB().readInt();
                    GameScr.gI().gameAU();
                    return;
                case -88:
                    GameScr.gI().gameAU();
                    Item var8;
                    (var8 = Char.getMyChar().arrItemBag[var1.gameAB().readByte()]).gameAG();
                    var8.isLock = true;
                    var8.upgrade = var1.gameAB().readByte();
                    (var8 = Char.getMyChar().arrItemBag[var1.gameAB().readByte()]).gameAG();
                    var8.isLock = true;
                    var8.upgrade = var1.gameAB().readByte();
                    Info.gameAA(mResources.gameRF, 20, mFont.tahoma_7b_yellow);
                    return;
                case -86:
                    GameCanvas.endDlg();
                    GameScr.gI().gameAU();
                    InfoMe.gameAA(var1.gameAB().readUTF(), 20, mFont.tahoma_7_yellow);
                    return;
                case -84:
                    Char.pointPB = var1.gameAB().readShort();
                    return;
                case -83:
                    short var9 = var1.gameAB().readShort();
                    var4 = var1.gameAB().readShort();
                    byte var10 = var1.gameAB().readByte();
                    short var11 = var1.gameAB().readShort();
                    if (var9 == 0) {
                        GameScr.gI().gameAA(mResources.gameFA, "          " + mResources.gameST, false);
                    } else {
                        var35 = mResources.gameEO + ": " + var9 + "\n\n";
                        if (var4 == 0) {
                            var35 = var35 + mResources.gameES + "\n\n";
                        } else {
                            var35 = var35 + mResources.gameET + ": " + NinjaUtil.gameAB(var4) + "\n\n";
                        }

                        var35 = var35 + mResources.gameEU + ": " + var10 + "\n\n";
                        var35 = var35 + mResources.gameFM + ": " + var11 + " " + mResources.gameFN + "\n\n";
                        GameScr.gI().gameAA(mResources.gameFA, var35, false);
                        if (var11 > 0) {
                            GameScr.gI().left = new Command(mResources.gameFM, 1000);
                            return;
                        }
                    }

                    return;
                case -81:
                    Char.pointChienTruong = var1.gameAB().readShort();
                    return;
                case -80:
                    GameScr.gI().gameAA(mResources.gameEZ, var1.gameAB().readUTF(), false);
                    if (var1.gameAB().readBoolean()) {
                        GameScr.gI().left = new Command(mResources.gameFM, 2000);
                        LockGame.gameAZ();
                    }

                    return;
                case -77:
                    GameCanvas.gameAC(TileMap.bgID = var1.gameAB().readByte());
                    return;
                case -72:
                    GameScr.gI().gameFI = new String[9];
                    GameScr.gameDA = new short[9];
                    if (GameScr.gameBM < 0 || GameScr.gameBM > 8) {
                        GameScr.gameBQ = 0;
                        GameScr.gameBM = 0;
                    }

                    for (var2 = 0; var2 < 9; ++var2) {
                        GameScr.gameDA[var2] = var1.gameAB().readShort();
                        GameScr.gI().gameFI[var2] = GameScr.gI().gameFF[NinjaUtil.gameAA(9)];
                    }

                    GameScr.gI().left = new Command(mResources.gameCG, (IActionListener) null, 1506, (Object) null);
                    GameScr.gI().gameFE = System.currentTimeMillis();
                    --GameScr.gI().gameDB;
                    GameCanvas.endDlg();
                    return;
                case -70:
                    var35 = var1.gameAB().readUTF();
                    GameCanvas.gameAA(NinjaUtil.gameAA(mResources.gameWB, "#", var35), new Command(mResources.YES, GameCanvas.instance, 88842, (Object) null), new Command(mResources.NO, GameCanvas.instance, 8882, (Object) null));
                    return;
                case -67:
                    Mob var12 = null;

                    try {
                        var12 = Mob.gameAA(var1.gameAB().readUnsignedByte());
                    } catch (Exception var24) {
                    }

                    if (var12 == null) {
                        return;
                    }

                    if ((var2 = var1.gameAB().readInt()) == Char.getMyChar().charID) {
                        GameScr.vMobSoul.addElement(new MobSoul(var12.x, var12.y, Char.getMyChar()));
                        return;
                    }

                    if ((var34 = GameScr.gameAE(var2)) == null) {
                        return;
                    }

                    GameScr.vMobSoul.addElement(new MobSoul(var12.x, var12.y, var34));
                    return;
                case -66:
                    var2 = var1.gameAB().readInt();
                    if (Char.getMyChar().charID == var2) {
                        GameScr.vMobSoul.addElement(new MobSoul(Char.getMyChar().cx, Char.getMyChar().cy));
                        return;
                    }

                    if ((var34 = GameScr.gameAE(var2)) == null) {
                        return;
                    }

                    GameScr.vMobSoul.addElement(new MobSoul(var34.cx, var34.cy));
                    return;
                case -62:
                    Char.clan.itemLevel = var1.gameAB().readByte();
                    return;
            }

            Char.getMyChar().cPk = var1.gameAB().readByte();
            Info.gameAA(mResources.gameMJ + " " + Char.getMyChar().cPk, 15, mFont.tahoma_7_yellow);
            Char.getMyChar().gameAC(21);
        } catch (Exception var32) {
        } finally {
            if (var1 != null) {
                var1.gameAD();
            }

        }
    }

    private static void gameAF(Message var0) {
        try {
            byte var1 = var0.gameAB().readByte();
            System.out.println("subcmd Notlogin: ".concat(String.valueOf(var1)));
            switch (var1) {
                case -124:
                    System.out.println("SEND SMS");
                    String var6 = var0.gameAB().readUTF();
                    SMS.gameAA(var0.gameAB().readUTF(), "sms://".concat(String.valueOf(var6)), new Command("", GameCanvas.gameAB(), 88825, (Object) null), new Command("", GameCanvas.gameAB(), 88826, (Object) null));
                    return;
                case 2:
                    RMS.gameAE();
            }
        } catch (Exception var4) {
        } finally {
            if (var0 != null) {
                var0.gameAD();
            }

        }
    }

    private static void gameAG(Message paramMessage) {
        try {
            byte b4;
            int i;
            Effect effect;
            Item[] arrayOfItem;
            byte b3;
            Party party;
            byte b;
            Mob mob;
            byte b2;
            String str1;
            Integer integer;
            byte b1;
            short[] arrayOfShort1;
            byte b6;
            Skill skill;
            EffectTemplate effectTemplate;
            byte b5;
            String str2;
            int j;
            byte[] arrayOfByte;
            byte b8;
            short[] arrayOfShort2;
            Char char_2;
            byte b7;
            Char char_1;
            short s;
            int m;
            Npc npc;
            int k;
            Char char_3;
            switch (paramMessage.gameAB().readByte()) {
                case 111:
                    if ((b4 = paramMessage.gameAB().readByte()) == 0) {
                        nameDQ nameDQ = new nameDQ(paramMessage.gameAB().readInt(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF());
                        short s1 = paramMessage.gameAB().readShort();
                        for (b4 = 0; b4 < s1; b4++) {
                            nameDQ.gameAA(new nameDP(paramMessage.gameAB().readInt(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readByte(), paramMessage.gameAB().readUTF()));
                        }
                        nameDQ.gameAB();
                    }
                    break;
                case -128:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    char_3.clevel = paramMessage.gameAB().readUnsignedByte();
                    return;
                case -127:
                    GameScr.vCharInMap.removeAllElements();
                    GameScr.vItemMap.removeAllElements();
                    GameScr.gameBC();
                    GameScr.currentCharViewInfo = Char.getMyChar();
                    (Char.getMyChar()).charID = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cClanName = paramMessage.gameAB().readUTF();
                    if (!(Char.getMyChar()).cClanName.equals("")) {
                        (Char.getMyChar()).ctypeClan = paramMessage.gameAB().readByte();
                    }
                    (Char.getMyChar()).ctaskId = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cgender = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).head = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).cspeed = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cName = paramMessage.gameAB().readUTF();
                    (Char.getMyChar()).cPk = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cTypePk = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cMaxHP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cMaxMP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cMP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cEXP = paramMessage.gameAB().readLong();
                    (Char.getMyChar()).cExpDown = paramMessage.gameAB().readLong();
                    GameScr.gameAA((Char.getMyChar()).cEXP);
                    (Char.getMyChar()).eff5BuffHp = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).eff5BuffMp = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).nClass = GameScr.nClasss[paramMessage.gameAB().readByte()];
                    (Char.getMyChar()).pPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[0] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[1] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[2] = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).potential[3] = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).sPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).vSkill.removeAllElements();
                    (Char.getMyChar()).vSkillFight.removeAllElements();
                    b4 = paramMessage.gameAB().readByte();
                    for (b8 = 0; b8 < b4; b8 = (byte) (b8 + 1)) {
                        Skill skill1 = Skills.gameAA(paramMessage.gameAB().readShort());
                        if ((Char.getMyChar()).myskill == null) {
                            (Char.getMyChar()).myskill = skill1;
                        }
                        if (Code.gameAB != null && Auto.skill1 != null && skill1.template.id == Auto.skill1.template.id) {
                            Auto.skill1 = skill1;
                        }
                        (Char.getMyChar()).vSkill.addElement(skill1);
                        if ((skill1.template.type == 1 || skill1.template.type == 4 || skill1.template.type == 2 || skill1.template.type == 3) && (skill1.template.maxPoint == 0 || (skill1.template.maxPoint > 0 && skill1.point > 0))) {
                            if (skill1.template.id == 0) {
                                Service.gI().gameAG(0);
                            }
                            (Char.getMyChar()).vSkillFight.addElement(skill1);
                        }
                    }
                    GameScr.gameAY();
                    (Char.getMyChar()).xu = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).yen = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).luong = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).arrItemBag = new Item[paramMessage.gameAB().readUnsignedByte()];
                    GameScr.gameAR = 0;
                    GameScr.gameAS = 0;
                    for (b6 = 0; b6 < (Char.getMyChar()).arrItemBag.length; b6++) {
                        short s1;
                        if ((s1 = paramMessage.gameAB().readShort()) != -1) {
                            (Char.getMyChar()).arrItemBag[b6] = new Item();
                            ((Char.getMyChar()).arrItemBag[b6]).typeUI = 3;
                            ((Char.getMyChar()).arrItemBag[b6]).indexUI = b6;
                            ((Char.getMyChar()).arrItemBag[b6]).template = ItemTemplates.gameAA(s1);
                            ((Char.getMyChar()).arrItemBag[b6]).isLock = paramMessage.gameAB().readBoolean();
                            if ((Char.getMyChar()).arrItemBag[b6].gameAB() || (Char.getMyChar()).arrItemBag[b6].gameAC() || (Char.getMyChar()).arrItemBag[b6].gameAD()) {
                                ((Char.getMyChar()).arrItemBag[b6]).upgrade = paramMessage.gameAB().readByte();
                            }
                            ((Char.getMyChar()).arrItemBag[b6]).isExpires = paramMessage.gameAB().readBoolean();
                            ((Char.getMyChar()).arrItemBag[b6]).quantity = paramMessage.gameAB().readUnsignedShort();
                            if (((Char.getMyChar()).arrItemBag[b6]).template.type == 16) {
                                GameScr.gameAS += ((Char.getMyChar()).arrItemBag[b6]).quantity;
                            }
                            if (((Char.getMyChar()).arrItemBag[b6]).template.type == 17) {
                                GameScr.gameAR += ((Char.getMyChar()).arrItemBag[b6]).quantity;
                            }
                            if (((Char.getMyChar()).arrItemBag[b6]).template.id == 340) {
                                GameScr gameScr;
                                (gameScr = GameScr.gI()).gameDB += ((Char.getMyChar()).arrItemBag[b6]).quantity;
                            }
                        }
                    }
                    Code.gameAJ();
                    (Char.getMyChar()).arrItemBody = new Item[32];
                    try {
                        Char.getMyChar().setDefaultPart();
                        for (int sm = 0; sm < 16; sm++) {
                            short num2 = paramMessage.gameAB().readShort();
                            if (num2 != -1) {
                                ItemTemplate itemTemplate = ItemTemplates.gameAA(num2);
                                int num3 = itemTemplate.type;
                                Char.getMyChar().arrItemBody[num3] = new Item();
                                Char.getMyChar().arrItemBody[num3].indexUI = num3;
                                Char.getMyChar().arrItemBody[num3].typeUI = 5;
                                Char.getMyChar().arrItemBody[num3].template = itemTemplate;
                                Char.getMyChar().arrItemBody[num3].isLock = true;
                                Char.getMyChar().arrItemBody[num3].upgrade = paramMessage.gameAB().readByte();
                                Char.getMyChar().arrItemBody[num3].sys = paramMessage.gameAB().readByte();
                                switch (num3) {
                                    case 1:
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[num3].template.part;
                                        break;
                                    case 2:
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[num3].template.part;
                                        break;
                                    case 6:
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[num3].template.part;
                                        break;
                                }
                            }
                        }
                    } catch (Exception exception2) {
                        exception2.printStackTrace();
                    }
                    (Char.getMyChar()).isHuman = paramMessage.gameAB().readBoolean();
                    (Char.getMyChar()).isNhanban = paramMessage.gameAB().readBoolean();
                    if ((arrayOfShort2 = new short[]{paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort()})[0] >= 0) {
                        (Char.getMyChar()).head = arrayOfShort2[0];
                    }
                    if (arrayOfShort2[1] >= 0) {
                        (Char.getMyChar()).wp = arrayOfShort2[1];
                    }
                    if (arrayOfShort2[2] >= 0) {
                        (Char.getMyChar()).body = arrayOfShort2[2];
                    }
                    if (arrayOfShort2[3] >= 0) {
                        (Char.getMyChar()).leg = arrayOfShort2[3];
                    }

                    short[] array2 = new short[10];
                    try {
                        for (int n = 0; n < 10; n++) {
                            array2[n] = paramMessage.gameAB().readShort();
                        }
                    } catch (Exception ra) {
                        array2 = null;
                    }
                    if (array2 != null) {
                    }

                    if ((Char.getMyChar()).isHuman) {
                        GameScr.gameAE();
                    } else if ((Char.getMyChar()).isNhanban) {
                        GameScr.gameAF();
                    }
                    (Char.getMyChar()).statusMe = 4;
                    GameScr.gameDF = (RMS.gameAD((Char.getMyChar()).cName + "vci") > 0);

                    try {
                        for (int num4 = 0; num4 < 16; num4++) {
                            short num5 = paramMessage.gameAB().readShort();
                            if (num5 != -1) {
                                ItemTemplate itemTemplate2 = ItemTemplates.gameAA(num5);
                                int num6 = itemTemplate2.type + 16;
                                Char.getMyChar().arrItemBody[num6] = new Item();
                                Char.getMyChar().arrItemBody[num6].indexUI = num6;
                                Char.getMyChar().arrItemBody[num6].typeUI = 5;
                                Char.getMyChar().arrItemBody[num6].template = itemTemplate2;
                                Char.getMyChar().arrItemBody[num6].isLock = true;
                                Char.getMyChar().arrItemBody[num6].upgrade = paramMessage.gameAB().readByte();
                                Char.getMyChar().arrItemBody[num6].sys = paramMessage.gameAB().readByte();
                                switch (num6) {
                                    case 1:
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[num6].template.part;
                                        break;
                                    case 2:
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[num6].template.part;
                                        break;
                                    case 6:
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[num6].template.part;
                                        break;
                                }
                            }
                        }
                    } catch (Exception ex2) {
                    }
                    short num7 = -1;
                    try {
                        num7 = paramMessage.gameAB().readShort();
                    } catch (Exception ex1) {
                        num7 = -1;
                    }
                    return;
                case -126:
                    Char.getMyChar().gameAA(paramMessage);
                    (Char.getMyChar()).potential[0] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[1] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[2] = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).potential[3] = paramMessage.gameAB().readInt();
                    Char.getMyChar().gameAC(61);
                    (Char.getMyChar()).nClass = GameScr.nClasss[paramMessage.gameAB().readByte()];
                    (Char.getMyChar()).sPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).pPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).vSkill.removeAllElements();
                    (Char.getMyChar()).vSkillFight.removeAllElements();
                    (Char.getMyChar()).myskill = null;
                    return;
                case -125:
                    Char.getMyChar().gameAA(paramMessage);
                    if ((Char.getMyChar()).statusMe != 14 && (Char.getMyChar()).statusMe != 5) {
                        (Char.getMyChar()).cHP = (Char.getMyChar()).cMaxHP;
                        (Char.getMyChar()).cMP = (Char.getMyChar()).cMaxMP;
                    }
                    try {
                        (Char.getMyChar()).sPoint = paramMessage.gameAB().readShort();
                        (Char.getMyChar()).vSkill.removeAllElements();
                        (Char.getMyChar()).vSkillFight.removeAllElements();
                        b4 = paramMessage.gameAB().readByte();
                        for (b6 = 0; b6 < b4; b6 = (byte) (b6 + 1)) {
                            Skill skill1 = Skills.gameAA(paramMessage.gameAB().readShort());
                            if ((Char.getMyChar()).myskill == null) {
                                (Char.getMyChar()).myskill = skill1;
                            } else if (skill1.template.equals((Char.getMyChar()).myskill.template)) {
                                (Char.getMyChar()).myskill = skill1;
                            }
                            if (Code.gameAB != null && Auto.skill1 != null && skill1.template.id == Auto.skill1.template.id) {
                                Auto.skill1 = skill1;
                            }
                            (Char.getMyChar()).vSkill.addElement(skill1);
                            if ((skill1.template.type == 1 || skill1.template.type == 4 || skill1.template.type == 2 || skill1.template.type == 3) && (skill1.template.maxPoint == 0 || (skill1.template.maxPoint > 0 && skill1.point > 0))) {
                                Char.getMyChar();
                                if (skill1.template.id == 0) {
                                    Service service = Service.gI();
                                    Char.getMyChar();
                                    service.gameAG(0);
                                }
                                (Char.getMyChar()).vSkillFight.addElement(skill1);
                            }
                        }
                        GameScr.gameAY();
                        if (GameScr.gameDL) {
                            GameScr.indexRow = -1;
                            GameScr.gI().gameBI();
                        }
                        System.out.println("LOAD XONG ME LOAD SKILL " + (Char.getMyChar()).vSkill.size());
                    } catch (Exception exception2) {
                        Exception exception1;
                        (exception1 = null).printStackTrace();
                    }
                    LockGame.gameAV();
                    return;
                case -124:
                    Char.getMyChar().gameAA(paramMessage);
                    (Char.getMyChar()).cEXP = paramMessage.gameAB().readLong();
                    GameScr.gameAA((Char.getMyChar()).cEXP);
                    (Char.getMyChar()).sPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).pPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[0] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[1] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[2] = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).potential[3] = paramMessage.gameAB().readInt();
                    return;
                case -123:
                    (Char.getMyChar()).xu = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).yen = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).luong = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cMP = paramMessage.gameAB().readInt();
                    if (paramMessage.gameAB().readByte() == 1) {
                        GameScr.gI().gameBN();
                        (Char.getMyChar()).isCaptcha = true;
                    } else {
                        (Char.getMyChar()).isCaptcha = false;
                        LockGame.gameAJ();
                    }
                    return;
                case -122:
                    (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                    return;
                case -121:
                    (Char.getMyChar()).cMP = paramMessage.gameAB().readInt();
                    return;
                case -120:
                    System.out.println("PLAYER LOAD ALL");
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        gameAA(char_3, paramMessage);
                    }
                    return;
                case -119:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    return;
                case -117:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    char_3.eff5BuffHp = paramMessage.gameAB().readShort();
                    char_3.eff5BuffMp = paramMessage.gameAB().readShort();
                    char_3.wp = paramMessage.gameAB().readShort();
                    if (char_3.wp == -1) {
                        char_3.gameAO();
                    }
                    return;
                case -116:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    char_3.eff5BuffHp = paramMessage.gameAB().readShort();
                    char_3.eff5BuffMp = paramMessage.gameAB().readShort();
                    char_3.body = paramMessage.gameAB().readShort();
                    if (char_3.body == -1) {
                        char_3.gameAP();
                    }
                    return;
                case -113:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    char_3.eff5BuffHp = paramMessage.gameAB().readShort();
                    char_3.eff5BuffMp = paramMessage.gameAB().readShort();
                    char_3.leg = paramMessage.gameAB().readShort();
                    if (char_3.leg == -1) {
                        char_3.gameAQ();
                    }
                    return;
                case -112:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        char_3.cHP = paramMessage.gameAB().readInt();
                        char_3.cMaxHP = paramMessage.gameAB().readInt();
                        char_3.eff5BuffHp = paramMessage.gameAB().readShort();
                        char_3.eff5BuffMp = paramMessage.gameAB().readShort();
                        return;
                    }
                    return;
                case -111:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    return;
                case -110:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    char_3.cx = char_3.gameGI = paramMessage.gameAB().readShort();
                    char_3.cy = char_3.gameGJ = paramMessage.gameAB().readShort();
                    char_3.statusMe = 1;
                    ServerEffect.gameAA(20, char_3, 2);
                    return;
                case -109:
                    Char.getMyChar().gameAA(paramMessage);
                    if ((Char.getMyChar()).statusMe != 14 && (Char.getMyChar()).statusMe != 5) {
                        (Char.getMyChar()).cHP = (Char.getMyChar()).cMaxHP;
                        (Char.getMyChar()).cMP = (Char.getMyChar()).cMaxMP;
                    }
                    (Char.getMyChar()).pPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[0] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[1] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[2] = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).potential[3] = paramMessage.gameAB().readInt();
                    LockGame.gameAX();
                    return;
                case -107:
                    Char.getMyChar().gameAK();
                    return;
                case -106:
                    Char.getMyChar().gameAL();
                    return;
                case -105:
                    i = paramMessage.gameAB().readInt();
                    (char_2 = Char.getMyChar()).xu -= i;
                    (char_2 = Char.getMyChar()).xuInBox += i;
                    return;
                case -104:
                    m = paramMessage.gameAB().readInt();
                    (char_2 = Char.getMyChar()).xuInBox -= m;
                    (char_2 = Char.getMyChar()).xu += m;
                    return;
                case -102:
                    (Char.getMyChar()).arrItemBag[paramMessage.gameAB().readByte()] = null;
                    skill = Skills.gameAA(paramMessage.gameAB().readShort());
                    (Char.getMyChar()).vSkill.addElement(skill);
                    if ((skill.template.type == 1 || skill.template.type == 4 || skill.template.type == 2 || skill.template.type == 3) && (skill.template.maxPoint == 0 || (skill.template.maxPoint > 0 && skill.point > 0))) {
                        Char.getMyChar();
                        if (skill.template.id == 0) {
                            Service service = Service.gI();
                            Char.getMyChar();
                            service.gameAG(0);
                        }
                        (Char.getMyChar()).vSkillFight.addElement(skill);
                    }
                    GameScr.gameAY();
                    GameScr.gI();
                    GameScr.gameAA(skill);
                    GameScr.gI().gameBI();
                    InfoMe.gameAA(mResources.gameUK + " " + skill.template.name);
                    return;
                case -101:
                    effect = new Effect(paramMessage.gameAB().readByte(), (int) (System.currentTimeMillis() / 1000L) - paramMessage.gameAB().readInt(), paramMessage.gameAB().readInt(), paramMessage.gameAB().readShort());
                    (Char.getMyChar()).vEff.addElement(effect);
                    if (effect.template.type == 7) {
                        (char_2 = Char.getMyChar()).cMiss = (short) ((char_2 = Char.getMyChar()).cMiss + effect.param);
                        return;
                    }
                    if (effect.template.type != 12 && effect.template.type != 11) {
                        if (effect.template.type == 14) {
                            GameCanvas.gameAJ();
                            GameCanvas.gameAK();
                            (Char.getMyChar()).cx = paramMessage.gameAB().readShort();
                            (Char.getMyChar()).cy = paramMessage.gameAB().readShort();
                            (Char.getMyChar()).statusMe = 1;
                            (Char.getMyChar()).isLockMove = true;
                            ServerEffect.gameAA(76, Char.getMyChar(), effect.timeLenght);
                            return;
                        }
                        if (effect.template.type == 1) {
                            ServerEffect.gameAA(48, Char.getMyChar(), effect.timeLenght);
                            return;
                        }
                        if (effect.template.type == 2) {
                            GameCanvas.gameAJ();
                            GameCanvas.gameAK();
                            (Char.getMyChar()).cx = paramMessage.gameAB().readShort();
                            (Char.getMyChar()).cy = paramMessage.gameAB().readShort();
                            (Char.getMyChar()).statusMe = 1;
                            (Char.getMyChar()).isLockMove = true;
                            (Char.getMyChar()).isLockAttack = true;
                        } else if (effect.template.type == 3) {
                            GameCanvas.gameAJ();
                            GameCanvas.gameAK();
                            (Char.getMyChar()).cx = paramMessage.gameAB().readShort();
                            (Char.getMyChar()).cy = paramMessage.gameAB().readShort();
                            (Char.getMyChar()).statusMe = 1;
                            Char.gameGM = true;
                            ServerEffect.gameAA(43, Char.getMyChar(), effect.timeLenght);
                            return;
                        }
                        return;
                    }
                    (Char.getMyChar()).isInvisible = true;
                    ServerEffect.gameAA(60, (Char.getMyChar()).cx, (Char.getMyChar()).cy, 1);
                    return;
                case -100:
                    effectTemplate = Effect.effTemplates[paramMessage.gameAB().readByte()];
                    for (m = 0; m < (Char.getMyChar()).vEff.size(); m++) {
                        if ((effect = (Effect) (Char.getMyChar()).vEff.elementAt(m)).template.type == effectTemplate.type) {
                            if (effect.template.type == 7) {
                                (char_2 = Char.getMyChar()).cMiss = (short) ((char_2 = Char.getMyChar()).cMiss - effect.param);
                            }
                            effect.template = effectTemplate;
                            effect.timeStart = (int) (System.currentTimeMillis() / 1000L) - paramMessage.gameAB().readInt();
                            effect.timeLenght = paramMessage.gameAB().readInt() / 1000;
                            effect.param = paramMessage.gameAB().readShort();
                            if (effect.template.type == 7) {
                                (char_2 = Char.getMyChar()).cMiss = (short) ((char_2 = Char.getMyChar()).cMiss + effect.param);
                            }
                            break;
                        }
                    }
                    if (!GameScr.gameDL) {
                        GameScr.gI().gameAU();
                    }
                    return;
                case -99:
                    b7 = paramMessage.gameAB().readByte();
                    effect = null;
                    for (m = 0; m < (Char.getMyChar()).vEff.size(); m++) {
                        if ((effect = (Effect) (Char.getMyChar()).vEff.elementAt(m)).template.id == b7) {
                            if (effect.template.type == 7) {
                                Char char_;
                                (char_ = Char.getMyChar()).cMiss = (short) ((char_ = Char.getMyChar()).cMiss - effect.param);
                            }
                            (Char.getMyChar()).vEff.removeElementAt(m);
                            break;
                        }
                    }
                    if (effect.template.type != 0 && effect.template.type != 12) {
                        if (effect.template.type != 4 && effect.template.type != 13 && effect.template.type != 17) {
                            if (effect.template.type == 23) {
                                (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                                (Char.getMyChar()).cMaxHP = paramMessage.gameAB().readInt();
                                return;
                            }
                            if (effect.template.type == 11) {
                                (Char.getMyChar()).isInvisible = false;
                                ServerEffect.gameAA(60, (Char.getMyChar()).cx, (Char.getMyChar()).cy, 1);
                                return;
                            }
                            if (effect.template.type == 14) {
                                (Char.getMyChar()).isLockMove = false;
                                return;
                            }
                            if (effect.template.type == 2) {
                                (Char.getMyChar()).isLockMove = false;
                                (Char.getMyChar()).isLockAttack = false;
                                ServerEffect.gameAA(77, (Char.getMyChar()).cx, (Char.getMyChar()).cy - 9, 1);
                            } else if (effect.template.type == 3) {
                                Char.gameGM = false;
                                return;
                            }
                            return;
                        }
                        (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                        return;
                    }
                    (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cMP = paramMessage.gameAB().readInt();
                    if (effect.template.type == 0) {
                        InfoMe.gameAA(mResources.gameSC);
                    } else if (effect.template.type == 12) {
                        (Char.getMyChar()).isInvisible = false;
                        ServerEffect.gameAA(60, (Char.getMyChar()).cx, (Char.getMyChar()).cy, 1);
                        return;
                    }
                    return;
                case -98:
                    try {
                        if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                            return;
                        }
                        effect = new Effect(paramMessage.gameAB().readByte(), (int) (System.currentTimeMillis() / 1000L) - paramMessage.gameAB().readInt(), paramMessage.gameAB().readInt(), paramMessage.gameAB().readShort());
                        char_3.vEff.addElement(effect);
                        if (effect.template.type != 12 && effect.template.type != 11) {
                            if (effect.template.type == 14) {
                                char_3.cx = char_3.gameGI = paramMessage.gameAB().readShort();
                                char_3.cy = char_3.gameGJ = paramMessage.gameAB().readShort();
                                char_3.statusMe = 1;
                                ServerEffect.gameAA(76, char_3, effect.timeLenght);
                                return;
                            }
                            if (effect.template.type == 1) {
                                ServerEffect.gameAA(48, char_3, effect.timeLenght);
                                return;
                            }
                            if (effect.template.type == 2) {
                                char_3.cx = char_3.gameGI = paramMessage.gameAB().readShort();
                                char_3.cy = char_3.gameGJ = paramMessage.gameAB().readShort();
                                char_3.statusMe = 1;
                                char_3.isLockAttack = true;
                            } else if (effect.template.type == 3) {
                                char_3.cx = char_3.gameGI = paramMessage.gameAB().readShort();
                                char_3.cy = char_3.gameGJ = paramMessage.gameAB().readShort();
                                char_3.statusMe = 1;
                                ServerEffect.gameAA(43, char_3, effect.timeLenght);
                                return;
                            }
                            return;
                        }
                        char_3.isInvisible = true;
                        ServerEffect.gameAA(60, char_3.cx, char_3.cy, 1);
                    } catch (Exception exception) {
                    }
                    return;
                case -97:
                    try {
                        if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                            return;
                        }
                        effectTemplate = Effect.effTemplates[paramMessage.gameAB().readByte()];
                        for (m = 0; m < char_3.vEff.size(); m++) {
                            effect = (Effect) char_3.vEff.elementAt(m);
                            if (effectTemplate.type == effectTemplate.type) {
                                effect.template = effectTemplate;
                                effect.timeStart = (int) (System.currentTimeMillis() / 1000L) - paramMessage.gameAB().readInt();
                                effect.timeLenght = paramMessage.gameAB().readInt() / 1000;
                                effect.param = paramMessage.gameAB().readShort();
                                return;
                            }
                        }
                        return;
                    } catch (Exception exception) {
                        return;
                    }
                case -96:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    b7 = paramMessage.gameAB().readByte();
                    effect = null;
                    for (b5 = 0; b5 < char_3.vEff.size(); b5++) {
                        if ((effect = (Effect) char_3.vEff.elementAt(b5)).template.id == b7) {
                            char_3.vEff.removeElementAt(b5);
                            break;
                        }
                    }
                    if (effect != null) {
                        if (effect.template.type == 0) {
                            char_3.cHP = paramMessage.gameAB().readInt();
                            char_3.cMP = paramMessage.gameAB().readInt();
                            return;
                        }
                        if (effect.template.type == 11) {
                            char_3.cx = char_3.gameGI = paramMessage.gameAB().readUnsignedShort();
                            char_3.cy = char_3.gameGJ = paramMessage.gameAB().readUnsignedShort();
                            char_3.isInvisible = false;
                            ServerEffect.gameAA(60, char_3.cx, char_3.cy, 1);
                            return;
                        }
                        if (effect.template.type == 12) {
                            char_3.cHP = paramMessage.gameAB().readInt();
                            char_3.cMP = paramMessage.gameAB().readInt();
                            char_3.isInvisible = false;
                            ServerEffect.gameAA(60, char_3.cx, char_3.cy, 1);
                            return;
                        }
                        if (effect.template.type != 4 && effect.template.type != 13 && effect.template.type != 17) {
                            if (effect.template.type == 23) {
                                (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                                (Char.getMyChar()).cMaxHP = paramMessage.gameAB().readInt();
                            } else if (effect.template.type == 2) {
                                char_3.isLockAttack = false;
                                ServerEffect.gameAA(77, char_3.cx, char_3.cy - 9, 1);
                                return;
                            }
                            return;
                        }
                        char_3.cHP = paramMessage.gameAB().readInt();
                        return;
                    }
                    return;
                case -95:
                    (GameScr.gI()).gameFB = paramMessage.gameAB().readInt();
                    (GameScr.gI()).gameFC = (int) (System.currentTimeMillis() / 1000L);
                    return;
                case -94:
                    b7 = paramMessage.gameAB().readByte();
                    (npc = (Npc) GameScr.vNpc.elementAt(b7)).statusMe = paramMessage.gameAB().readByte();
                    if (npc.template.npcTemplateId == 31 && npc.statusMe == 15) {
                        GameScr.gameAA(npc.cx, npc.cy);
                    }
                    return;
                case -92:
                    if ((k = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                        char_3 = Char.getMyChar();
                    } else {
                        char_3 = GameScr.gameAE(k);
                    }
                    if (char_3 != null) {
                        char_3.cTypePk = paramMessage.gameAB().readByte();
                        Auto.gameAA(char_3);
                        if (char_3 == Char.getMyChar()) {
                            if (char_3.cTypePk == 4) {
                                GameScr.gameGQ = true;
                            } else if (char_3.cTypePk == 5) {
                                GameScr.gameGQ = false;
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case -91:
                    arrayOfItem = new Item[paramMessage.gameAB().readUnsignedByte()];
                    for (k = 0; k < (Char.getMyChar()).arrItemBag.length; k++) {
                        arrayOfItem[k] = (Char.getMyChar()).arrItemBag[k];
                    }
                    (Char.getMyChar()).arrItemBag = arrayOfItem;
                    (Char.getMyChar()).arrItemBag[paramMessage.gameAB().readUnsignedByte()] = null;
                    InfoMe.gameAA(mResources.gameFO + " " + (Char.getMyChar()).arrItemBag.length + " " + mResources.gameGI);
                    return;
                case -90:
                    for (k = 0; k < GameScr.vNpc.size(); k++) {
                        Npc npc1;
                        if ((npc1 = (Npc) GameScr.vNpc.elementAt(k)).statusMe == 15) {
                            npc1.statusMe = 1;
                            break;
                        }
                    }
                    if ((b3 = paramMessage.gameAB().readByte()) == 1) {
                        InfoMe.gameAA(mResources.gameFP, 20, mFont.tahoma_7_yellow);
                    } else if (b3 == 2) {
                        InfoMe.gameAA(mResources.gameFQ, 20, mFont.tahoma_7_yellow);
                        return;
                    }
                    return;
                case -89:
                    GameCanvas.isLoading = false;
                    try {
                        InfoMe.gameAA(paramMessage.gameAB().readUTF(), 20, mFont.tahoma_7_yellow);
                    } catch (Exception exception) {
                    }
                    InfoDlg.gameAD();
                    GameCanvas.endDlg();
                    return;
                case -87:
                    b5 = paramMessage.gameAB().readByte();
                    party = (Party) GameScr.vParty.elementAt(b5);
                    GameScr.vParty.setElementAt(GameScr.vParty.elementAt(0), b5);
                    GameScr.vParty.setElementAt(party, 0);
                    GameScr.gI().gameAS();
                    InfoMe.gameAA(party.name + mResources.gameTD, 20, mFont.tahoma_7_yellow);
                    return;
                case -86:
                    GameScr.vParty.removeAllElements();
                    GameScr.gI().gameAS();
                    InfoMe.gameAA(mResources.gameTE, 20, mFont.tahoma_7_yellow);
                    Code.gameAH = null;
                    return;
                case -85:
                    GameScr.vFriend.removeAllElements();
                    try {
                        while (true) {
                            GameScr.vFriend.addElement(new Friend(paramMessage.gameAB().readUTF(), paramMessage.gameAB().readByte()));
                        }
                    } catch (Exception exception) {
                        for (k = 0; k < GameScr.vFriendWait.size(); k++) {
                            GameScr.vFriend.addElement(GameScr.vFriendWait.elementAt(k));
                        }
                        GameScr.gI();
                        GameScr.gameAC(0);
                        return;
                    }
                case -84:
                    GameScr.vEnemies.removeAllElements();
                    try {
                        while (true) {
                            GameScr.vEnemies.addElement(new Friend(paramMessage.gameAB().readUTF(), paramMessage.gameAB().readByte()));
                        }
                    } catch (Exception exception) {
                        GameScr.gI();
                        GameScr.gameAC(1);
                        return;
                    }
                case -83:
                    str2 = paramMessage.gameAB().readUTF();
                    for (b = 0; b < GameScr.vFriend.size(); b++) {
                        if (((Friend) GameScr.vFriend.elementAt(b)).friendName.equals(str2)) {
                            GameScr.indexRow = 0;
                            GameScr.vFriend.removeElementAt(b);
                            GameScr.gI();
                            GameScr.gameAB(str2);
                            break;
                        }
                    }
                    if (GameScr.gameDJ) {
                        GameScr.gI();
                        GameScr.gameAC(0);
                        GameScr.indexRow = 0;
                        GameScr.gameBU.gameAA();
                    }
                    return;
                case -82:
                    str2 = paramMessage.gameAB().readUTF();
                    for (b = 0; b < GameScr.vEnemies.size(); b++) {
                        if (((Friend) GameScr.vEnemies.elementAt(b)).friendName.equals(str2)) {
                            GameScr.indexRow = 0;
                            GameScr.vEnemies.removeElementAt(b);
                            break;
                        }
                    }
                    GameScr.gI();
                    GameScr.gameAC(1);
                    return;
                case -81:
                    (Char.getMyChar()).cPk = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).charFocus = null;
                    return;
                case -80:
                    (Char.getMyChar()).arrItemBody[paramMessage.gameAB().readByte()] = null;
                    return;
                case -78:
                    ServerEffect.gameAA(paramMessage.gameAB().readShort(), (Char.getMyChar()).cx, (Char.getMyChar()).cy, 1);
                    return;
                case -77:
                    try {
                        GameScr.vPtMap.removeAllElements();
                        while (true) {
                            GameScr.vPtMap.addElement(new Party(paramMessage.gameAB().readByte(), paramMessage.gameAB().readUnsignedByte(), paramMessage.gameAB().readUTF(), paramMessage.gameAB().readByte()));
                        }
                    } catch (Exception exception) {
                        GameScr.gI().gameAR();
                        return;
                    }
                case -76:
                    ((Party) GameScr.vParty.firstElement()).isLock = paramMessage.gameAB().readBoolean();
                    return;
                case -75:
                    (Char.getMyChar()).arrItemBox[paramMessage.gameAB().readByte()] = null;
                    return;
                case -74:
                    InfoDlg.gameAA(paramMessage.gameAB().readUTF());
                    return;
                case -73:
                    mob = Mob.gameAA(paramMessage.gameAB().readUnsignedByte());
                    ServerEffect.gameAA(67, mob.x, mob.y, 1);
                    return;
                case -72:
                    (Char.getMyChar()).luong = paramMessage.gameAB().readInt();
                    return;
                case -71:
                    k = paramMessage.gameAB().readInt();
                    (char_1 = Char.getMyChar()).luong += k;
                    GameScr.gameAA("+".concat(String.valueOf(k)), (Char.getMyChar()).cx, (Char.getMyChar()).cy - (Char.getMyChar()).ch - 10, 6);
                    InfoMe.gameAA(mResources.gamePQ + " " + k + " " + mResources.gameKT, 20, mFont.tahoma_7_yellow);
                    return;
                case -69:
                    j = paramMessage.gameAB().readUnsignedByte();
                    b2 = paramMessage.gameAB().readByte();
                    if (j > 0) {
                        short var40 = (short) (Char.getMyChar()).cx;
                        short s1 = (short) ((Char.getMyChar()).cy - 40);
                        (Char.getMyChar()).mobMe = new Mob((short) -1, false, false, false, false, false, j, 1, 0, 0, 0, var40, s1, (byte) 4, (byte) 0, (b2 != 0), false);
                        (Char.getMyChar()).mobMe.status = 5;
                    } else {
                        (Char.getMyChar()).mobMe = null;
                    }
                    return;
                case -68:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    j = paramMessage.gameAB().readUnsignedByte();
                    b2 = paramMessage.gameAB().readByte();
                    if (j > 0) {
                        short s1 = (short) char_3.cx;
                        short var40 = (short) (char_3.cy - 40);
                        char_3.mobMe = new Mob((short) -1, false, false, false, false, false, j, 1, 0, 0, 0, s1, var40, (byte) 4, (byte) 0, (b2 != 0), false);
                        char_3.mobMe.status = 5;
                    } else {
                        char_3.mobMe = null;
                    }
                    return;
                case -65:
                    str1 = paramMessage.gameAB().readUTF();
                    arrayOfByte = new byte[paramMessage.gameAB().readInt()];
                    paramMessage.gameAB().read(arrayOfByte);
                    if (arrayOfByte.length == 0) {
                        arrayOfByte = null;
                    }
                    try {
                        paramMessage.gameAB().readByte();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if (str1.equals("KSkill")) {
                        GameScr.gI();
                        GameScr.gameAB(arrayOfByte);
                        return;
                    }
                    if (str1.equals("OSkill")) {
                        GameScr.gI();
                        GameScr.gameAA(arrayOfByte);
                    } else if (str1.equals("CSkill")) {
                        GameScr.gI();
                        GameScr.gameAC(arrayOfByte);
                        return;
                    }
                    return;
                case -64:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) == null) {
                        return;
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    char_3.eff5BuffHp = paramMessage.gameAB().readShort();
                    char_3.eff5BuffMp = paramMessage.gameAB().readShort();
                    char_3.head = paramMessage.gameAB().readShort();
                    return;
                case -63:
                    if ((char_3 = GameScr.gameAE((integer = new Integer(paramMessage.gameAB().readInt())).intValue())) != null) {
                        GameCanvas.gameAA(char_3.cName + " " + mResources.gameAA(mResources.gameQZ, paramMessage.gameAB().readUTF()), 88830, integer, 88811, (Object) null);
                    }
                    return;
                case -62:
                    k = paramMessage.gameAB().readInt();
                    if ((Char.getMyChar()).charID == k) {
                        (Char.getMyChar()).cClanName = paramMessage.gameAB().readUTF();
                        (Char.getMyChar()).ctypeClan = paramMessage.gameAB().readByte();
                        Char.getMyChar().gameAC(21);
                    } else {
                        (char_3 = GameScr.gameAE(k)).cClanName = paramMessage.gameAB().readUTF();
                        char_3.ctypeClan = paramMessage.gameAB().readByte();
                    }
                    return;
                case -61:
                    if (GameScr.gameDF && (char_3 = GameScr.gameAE((integer = new Integer(paramMessage.gameAB().readInt())).intValue())) != null) {
                        GameCanvas.gameAA(char_3.cName + " " + mResources.gameRA, 88831, integer, 88811, (Object) null);
                    }
                    return;
                case -59:
                    if ((k = paramMessage.gameAB().readInt()) == (Char.getMyChar()).charID) {
                        char_3 = Char.getMyChar();
                    } else {
                        char_3 = GameScr.gameAE(k);
                    }
                    char_3.cHP = paramMessage.gameAB().readInt();
                    char_3.cMaxHP = paramMessage.gameAB().readInt();
                    return;
                case -58:
                    GameScr.gI().gameAU();
                    GameCanvas.gameBM = 70;
                    GameCanvas.gameAD = true;
                    ServerEffect.gameAA(119, GameScr.gameAD + GameScr.cmx, GameScr.gameAF + GameScr.cmy, 1);
                    return;
                case -57:
                    GameCanvas.gameBM = 40;
                    GameCanvas.gameAD = true;
                    return;
                case -56:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        char_3.cHP = paramMessage.gameAB().readInt();
                        char_3.cMaxHP = paramMessage.gameAB().readInt();
                        char_3.coat = (short) paramMessage.gameAB().readUnsignedShort();
                    }
                    return;
                case -55:
                    if ((char_3 = GameScr.gameAE(paramMessage.gameAB().readInt())) != null) {
                        char_3.cHP = paramMessage.gameAB().readInt();
                        char_3.cMaxHP = paramMessage.gameAB().readInt();
                        char_3.glove = (short) paramMessage.gameAB().readUnsignedShort();
                    }
                    return;
                case -54:
                    k = paramMessage.gameAB().readInt();
                    if ((Char.getMyChar()).charID == k) {
                        char_3 = Char.getMyChar();
                    } else {
                        char_3 = GameScr.gameAE(k);
                    }
                    if (char_3 != null) {
                        char_3.arrItemMounts = new Item[5];
                        char_3.isWolf = char_3.isMoto = char_3.gameCP = false;
                        for (k = 0; k < char_3.arrItemMounts.length; k++) {
                            short s1;
                            if ((s1 = paramMessage.gameAB().readShort()) != -1) {
                                char_3.arrItemMounts[k] = new Item();
                                (char_3.arrItemMounts[k]).typeUI = 41;
                                (char_3.arrItemMounts[k]).indexUI = k;
                                (char_3.arrItemMounts[k]).template = ItemTemplates.gameAA(s1);
                                (char_3.arrItemMounts[k]).upgrade = paramMessage.gameAB().readByte();
                                (char_3.arrItemMounts[k]).expires = paramMessage.gameAB().readLong();
                                (char_3.arrItemMounts[k]).sys = paramMessage.gameAB().readByte();
                                (char_3.arrItemMounts[k]).isLock = true;
                                if (k == 4) {
                                    if ((char_3.arrItemMounts[k]).template.id != 485 && (char_3.arrItemMounts[k]).template.id != 524) {
                                        if ((char_3.arrItemMounts[k]).template.id == 443 || (char_3.arrItemMounts[k]).template.id == 523) {
                                            char_3.isWolf = true;
                                        }
                                    } else {
                                        char_3.gameCP = true;
                                    }
                                }
                                s1 = paramMessage.gameAB().readByte();
                                (char_3.arrItemMounts[k]).options = new MyVector();
                                for (byte b9 = 0; b9 < s1; b9++) {
                                    (char_3.arrItemMounts[k]).options.addElement(new ItemOption(paramMessage.gameAB().readUnsignedByte(), paramMessage.gameAB().readInt()));
                                }
                            }
                        }
                    }
                    return;
                case 115:
                    System.out.println("UPDATE INFO ME");
                    GameScr.currentCharViewInfo = Char.getMyChar();
                    (Char.getMyChar()).lastNormalSkill = null;
                    (Char.getMyChar()).charID = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cClanName = paramMessage.gameAB().readUTF();
                    if (!(Char.getMyChar()).cClanName.equals("")) {
                        (Char.getMyChar()).ctypeClan = paramMessage.gameAB().readByte();
                    }
                    (Char.getMyChar()).ctaskId = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cgender = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).head = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).cspeed = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cName = paramMessage.gameAB().readUTF();
                    (Char.getMyChar()).cPk = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cTypePk = paramMessage.gameAB().readByte();
                    (Char.getMyChar()).cMaxHP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cHP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cMaxMP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cMP = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).cEXP = paramMessage.gameAB().readLong();
                    (Char.getMyChar()).cExpDown = paramMessage.gameAB().readLong();
                    GameScr.gameAA((Char.getMyChar()).cEXP);
                    (Char.getMyChar()).eff5BuffHp = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).eff5BuffMp = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).nClass = GameScr.nClasss[paramMessage.gameAB().readByte()];
                    (Char.getMyChar()).pPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[0] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[1] = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).potential[2] = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).potential[3] = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).sPoint = paramMessage.gameAB().readShort();
                    (Char.getMyChar()).vSkill.removeAllElements();
                    (Char.getMyChar()).vSkillFight.removeAllElements();
                    b1 = paramMessage.gameAB().readByte();
                    for (s = 0; s < b1; s = (byte) (s + 1)) {
                        Skill skill1 = Skills.gameAA(paramMessage.gameAB().readShort());
                        if ((Char.getMyChar()).myskill == null) {
                            (Char.getMyChar()).myskill = skill1;
                        }
                        if (Code.gameAB != null && Auto.skill1 != null && skill1.template.id == Auto.skill1.template.id) {
                            Auto.skill1 = skill1;
                        }
                        (Char.getMyChar()).vSkill.addElement(skill1);
                        if ((skill1.template.type == 1 || skill1.template.type == 4 || skill1.template.type == 2 || skill1.template.type == 3) && (skill1.template.maxPoint == 0 || (skill1.template.maxPoint > 0 && skill1.point > 0))) {
                            if (skill1.template.id == 0) {
                                Service.gI().gameAG(0);
                            }
                            (Char.getMyChar()).vSkillFight.addElement(skill1);
                        }
                    }
                    GameScr.gameAY();
                    (Char.getMyChar()).xu = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).yen = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).luong = paramMessage.gameAB().readInt();
                    (Char.getMyChar()).arrItemBag = new Item[paramMessage.gameAB().readUnsignedByte()];
                    GameScr.gameAR = 0;
                    GameScr.gameAS = 0;
                    for (k = 0; k < (Char.getMyChar()).arrItemBag.length; k++) {
                        if ((s = paramMessage.gameAB().readShort()) != -1) {
                            (Char.getMyChar()).arrItemBag[k] = new Item();
                            ((Char.getMyChar()).arrItemBag[k]).typeUI = 3;
                            ((Char.getMyChar()).arrItemBag[k]).indexUI = k;
                            ((Char.getMyChar()).arrItemBag[k]).template = ItemTemplates.gameAA(s);
                            ((Char.getMyChar()).arrItemBag[k]).isLock = paramMessage.gameAB().readBoolean();
                            if ((Char.getMyChar()).arrItemBag[k].gameAB() || (Char.getMyChar()).arrItemBag[k].gameAC() || (Char.getMyChar()).arrItemBag[k].gameAD()) {
                                ((Char.getMyChar()).arrItemBag[k]).upgrade = paramMessage.gameAB().readByte();
                            }
                            ((Char.getMyChar()).arrItemBag[k]).isExpires = paramMessage.gameAB().readBoolean();
                            ((Char.getMyChar()).arrItemBag[k]).quantity = paramMessage.gameAB().readUnsignedShort();
                            if (((Char.getMyChar()).arrItemBag[k]).template.type == 16) {
                                GameScr.gameAS += ((Char.getMyChar()).arrItemBag[k]).quantity;
                            }
                            if (((Char.getMyChar()).arrItemBag[k]).template.type == 17) {
                                GameScr.gameAR += ((Char.getMyChar()).arrItemBag[k]).quantity;
                            }
                            if (((Char.getMyChar()).arrItemBag[k]).template.id == 340) {
                                GameScr gameScr;
                                (gameScr = GameScr.gI()).gameDB += ((Char.getMyChar()).arrItemBag[k]).quantity;
                            }
                        }
                    }
                    Code.gameAJ();
                    (Char.getMyChar()).arrItemBody = new Item[32];
                    try {
                        Char.getMyChar().setDefaultPart();
                        for (int num29 = 0; num29 < 16; num29++) {
                            short num30 = paramMessage.gameAB().readShort();
                            if (num30 != -1) {
                                ItemTemplate itemTemplate3 = ItemTemplates.gameAA(num30);
                                int num31 = itemTemplate3.type;
                                Char.getMyChar().arrItemBody[num31] = new Item();
                                Char.getMyChar().arrItemBody[num31].indexUI = num31;
                                Char.getMyChar().arrItemBody[num31].typeUI = 5;
                                Char.getMyChar().arrItemBody[num31].template = itemTemplate3;
                                Char.getMyChar().arrItemBody[num31].isLock = true;
                                Char.getMyChar().arrItemBody[num31].upgrade = paramMessage.gameAB().readByte();
                                Char.getMyChar().arrItemBody[num31].sys = paramMessage.gameAB().readByte();
                                switch (num31) {
                                    case 1:
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[num31].template.part;
                                        break;
                                    case 2:
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[num31].template.part;
                                        break;
                                    case 6:
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[num31].template.part;
                                        break;
                                }
                            }
                        }
                    } catch (Exception exception2) {
                        exception2.printStackTrace();
                    }
                    (Char.getMyChar()).isHuman = paramMessage.gameAB().readBoolean();
                    (Char.getMyChar()).isNhanban = paramMessage.gameAB().readBoolean();
                    if ((arrayOfShort1 = new short[]{paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort(), paramMessage.gameAB().readShort()})[0] >= 0) {
                        (Char.getMyChar()).head = arrayOfShort1[0];
                    }
                    if (arrayOfShort1[1] >= 0) {
                        (Char.getMyChar()).wp = arrayOfShort1[1];
                    }
                    if (arrayOfShort1[2] >= 0) {
                        (Char.getMyChar()).body = arrayOfShort1[2];
                    }
                    if (arrayOfShort1[3] >= 0) {
                        (Char.getMyChar()).leg = arrayOfShort1[3];
                    }
                    GameScr.gI();
                    GameScr.gameAY();
                    if ((Char.getMyChar()).isHuman) {
                        GameScr.gI();
                        GameScr.gameAE();
                    } else if ((Char.getMyChar()).isNhanban) {
                        GameScr.gI();
                        GameScr.gameAF();
                    }
                    (Char.getMyChar()).statusMe = 4;
                    GameScr.gameDF = (RMS.gameAD((Char.getMyChar()).cName + "vci") > 0);

                    short[] array5 = new short[10];
                    try {
                        for (int num32 = 0; num32 < 10; num32++) {
                            array5[num32] = paramMessage.gameAB().readShort();
                        }
                    } catch (Exception ex4) {
                        array5 = null;
                    }
                    if (array5 != null) {
                    }
                    try {
                        for (int num33 = 0; num33 < 16; num33++) {
                            short num34 = paramMessage.gameAB().readShort();
                            if (num34 != -1) {
                                ItemTemplate itemTemplate4 = ItemTemplates.gameAA(num34);
                                int num35 = itemTemplate4.type + 16;
                                Char.getMyChar().arrItemBody[num35] = new Item();
                                Char.getMyChar().arrItemBody[num35].indexUI = num35;
                                Char.getMyChar().arrItemBody[num35].typeUI = 5;
                                Char.getMyChar().arrItemBody[num35].template = itemTemplate4;
                                Char.getMyChar().arrItemBody[num35].isLock = true;
                                Char.getMyChar().arrItemBody[num35].upgrade = paramMessage.gameAB().readByte();
                                Char.getMyChar().arrItemBody[num35].sys = paramMessage.gameAB().readByte();
                                switch (num35) {
                                    case 1:
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[num35].template.part;
                                        break;
                                    case 2:
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[num35].template.part;
                                        break;
                                    case 6:
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[num35].template.part;
                                        break;
                                }
                            }
                        }
                    } catch (Exception ex3) {
                    }
                    short num36 = -1;
                    try {
                        num36 = paramMessage.gameAB().readShort();
                    } catch (Exception ex4) {
                        num36 = -1;
                    }

                    break;
            }
            if (paramMessage != null) {
                return;
            }
        } catch (Exception exception) {

        } finally {
            if (paramMessage != null) {
                paramMessage.gameAD();
            }
        }
    }

    private static boolean gameAA(Char var0, Message var1) {
        try {
            var0.cClanName = var1.gameAB().readUTF();
            if (!var0.cClanName.equals("")) {
                var0.ctypeClan = var1.gameAB().readByte();
            }

            var0.isInvisible = var1.gameAB().readBoolean();
            var0.cTypePk = var1.gameAB().readByte();
            var0.nClass = GameScr.nClasss[var1.gameAB().readByte()];
            var0.cgender = var1.gameAB().readByte();
            var0.head = var1.gameAB().readShort();
            var0.cName = var1.gameAB().readUTF();
            var0.cHP = var1.gameAB().readInt();
            var0.cMaxHP = var1.gameAB().readInt();
            var0.clevel = var1.gameAB().readUnsignedByte();
            var0.wp = var1.gameAB().readShort();
            var0.body = var1.gameAB().readShort();
            var0.leg = var1.gameAB().readShort();
            byte var2 = var1.gameAB().readByte();
            if (var0.wp == -1) {
                var0.wp = 15;
            }

            if (var0.body == -1) {
                var0.gameAP();
            }

            if (var0.leg == -1) {
                var0.gameAQ();
            }

            short var3;
            if (var2 == -1) {
                var0.mobMe = null;
            } else {
                var3 = (short) var0.cx;
                short var4 = (short) (var0.cy - 40);
                var0.mobMe = new Mob((short) -1, false, false, false, false, false, var2, 1, 0, 0, 0, var3, var4, (byte) 4, (byte) 0, false, false);
                var0.mobMe.status = 5;
            }

            var0.cx = var0.gameGI = var1.gameAB().readShort();
            var0.cy = var0.gameGJ = var1.gameAB().readShort();
            var0.eff5BuffHp = var1.gameAB().readShort();
            var0.eff5BuffMp = var1.gameAB().readShort();
            byte var12 = var1.gameAB().readByte();

            int var15;
            for (var15 = 0; var15 < var12; ++var15) {
                Effect var9 = new Effect(var1.gameAB().readByte(), var1.gameAB().readInt(), var1.gameAB().readInt(), var1.gameAB().readShort());
                var0.vEff.addElement(var9);
                if (var9.template.type == 12 || var9.template.type == 11) {
                    var0.isInvisible = true;
                }
            }

            if (!var0.isInvisible) {
                ServerEffect.gameAA(60, var0, 1);
            }

            if (var0.cHP == 0) {
                var0.statusMe = 14;
                if (Char.getMyChar().charID == var0.charID) {
                    GameScr.gI().gameAU();
                }
            }

            if (var0.charID == -Char.getMyChar().charID) {
                for (var15 = 0; var15 < GameScr.vNpc.size(); ++var15) {
                    Npc var10;
                    if ((var10 = (Npc) GameScr.vNpc.elementAt(var15)).template.name.equals(var0.cName)) {
                        var10.statusMe = 15;
                        var10.chatPopup = null;
                        break;
                    }
                }
            }

            var0.isHuman = var1.gameAB().readBoolean();
            var0.isNhanban = var1.gameAB().readBoolean();
            if (var0.isNhanban) {
                ServerEffect.gameAA(141, var0.cx, var0.cy, 0);
            }

            short[] var11;
            if ((var11 = new short[]{var1.gameAB().readShort(), var1.gameAB().readShort(), var1.gameAB().readShort(), var1.gameAB().readShort()})[0] >= 0) {
                var0.head = var11[0];
            }

            if (var11[1] >= 0) {
                var0.wp = var11[1];
            }

            if (var11[2] >= 0) {
                var0.body = var11[2];
            }

            if (var11[3] >= 0) {
                var0.leg = var11[3];
            }

            var11 = new short[10];

            try {
                for (int var13 = 0; var13 < 10; ++var13) {
                    var11[var13] = var1.gameAB().readShort();
                }
            } catch (Exception var6) {
            }

            var0.gameAA(var11);

            try {
                var3 = var1.gameAB().readShort();
            } catch (Exception var5) {
                var3 = -1;
            }

            var0.gameHL = var3;

            for (int var8 = 0; var8 < GameScr.vParty.size(); ++var8) {
                Party var14;
                if ((var14 = (Party) GameScr.vParty.elementAt(var8)).charId == var0.charID) {
                    var14.c = var0;
                    break;
                }
            }

            return true;
        } catch (Exception var7) {
            return false;
        }
    }

    private static void gameAH(Message var0) {
        try {
            byte var1;
            Item var3;
            var1 = var0.gameAB().readByte();
            int var2 = var0.gameAB().readUnsignedByte();
            var3 = null;
            label188:
            switch (var1) {
                case 2:
                    var3 = GameScr.gameCJ[var2];
                    break;
                case 3:
                    if ((var3 = Char.getMyChar().arrItemBag[var2]) != null) {
                        break;
                    }

                    if (GameScr.gameDD != null && GameScr.gameDD.indexUI == var2) {
                        var3 = GameScr.gameDD;
                    }

                    if (GameScr.arritemup != null && GameScr.arritemup.indexUI == var2) {
                        var3 = GameScr.arritemup;
                    }

                    if (GameScr.gameDE != null && GameScr.gameDE.indexUI == var2) {
                        var3 = GameScr.gameDE;
                    }

                    int var4;
                    if (var3 == null && GameScr.upitem != null) {
                        for (var4 = 0; var4 < GameScr.upitem.length; ++var4) {
                            if (GameScr.upitem[var4] != null && GameScr.upitem[var4].indexUI == var2) {
                                var3 = GameScr.upitem[var4];
                                break;
                            }
                        }
                    }

                    if (var3 == null && GameScr.gameCY != null) {
                        for (var4 = 0; var4 < GameScr.gameCY.length; ++var4) {
                            if (GameScr.gameCY[var4] != null && GameScr.gameCY[var4].indexUI == var2) {
                                var3 = GameScr.gameCY[var4];
                                break;
                            }
                        }
                    }

                    if (var3 == null && GameScr.gameCT != null) {
                        for (var4 = 0; var4 < GameScr.gameCT.length; ++var4) {
                            if (GameScr.gameCT[var4] != null && GameScr.gameCT[var4].indexUI == var2) {
                                var3 = GameScr.gameCT[var4];
                                break;
                            }
                        }
                    }

                    if (var3 == null && GameScr.gameCW != null) {
                        for (var4 = 0; var4 < GameScr.gameCW.length; ++var4) {
                            if (GameScr.gameCW[var4] != null && GameScr.gameCW[var4].indexUI == var2) {
                                var3 = GameScr.gameCW[var4];
                                break;
                            }
                        }
                    }

                    if (var3 != null || GameScr.gameCV == null) {
                        break;
                    }

                    var4 = 0;

                    while (true) {
                        if (var4 >= GameScr.gameCV.length) {
                            break label188;
                        }

                        if (GameScr.gameCV[var4] != null && GameScr.gameCV[var4].indexUI == var2) {
                            var3 = GameScr.gameCV[var4];
                            break label188;
                        }

                        ++var4;
                    }
                case 4:
                    var3 = Char.getMyChar().arrItemBox[var2];
                    break;
                case 5:
                    var3 = Char.getMyChar().arrItemBody[var2];
                    break;
                case 6:
                    var3 = GameScr.gameCK[var2];
                    break;
                case 7:
                    var3 = GameScr.gameCL[var2];
                    break;
                case 8:
                    var3 = GameScr.gameCM[var2];
                    break;
                case 9:
                    var3 = GameScr.gameCN[var2];
                case 10:
                case 11:
                case 12:
                case 13:
                case 31:
                case 33:
                case 36:
                case 37:
                case 38:
                default:
                    break;
                case 14:
                    var3 = GameScr.gameCO[var2];
                    break;
                case 15:
                    var3 = GameScr.gameCR[var2];
                    break;
                case 16:
                    var3 = GameScr.gameCF[var2];
                    break;
                case 17:
                    var3 = GameScr.gameCG[var2];
                    break;
                case 18:
                    var3 = GameScr.gameCH[var2];
                    break;
                case 19:
                    var3 = GameScr.gameCI[var2];
                    break;
                case 20:
                    var3 = GameScr.gameBV[var2];
                    break;
                case 21:
                    var3 = GameScr.gameBW[var2];
                    break;
                case 22:
                    var3 = GameScr.gameBX[var2];
                    break;
                case 23:
                    var3 = GameScr.gameBY[var2];
                    break;
                case 24:
                    var3 = GameScr.gameBZ[var2];
                    break;
                case 25:
                    var3 = GameScr.gameCA[var2];
                    break;
                case 26:
                    var3 = GameScr.gameCB[var2];
                    break;
                case 27:
                    var3 = GameScr.gameCC[var2];
                    break;
                case 28:
                    var3 = GameScr.gameCD[var2];
                    break;
                case 29:
                    var3 = GameScr.gameCE[var2];
                    break;
                case 30:
                    var3 = GameScr.gameCX[var2];
                    break;
                case 32:
                    var3 = GameScr.gameCS[var2];
                    break;
                case 34:
                    var3 = GameScr.gameCQ[var2];
                    break;
                case 35:
                    var3 = GameScr.gameCP[var2];
                    break;
                case 39:
                    var3 = Char.clan.items[GameScr.gameBM];
            }

            var3.expires = var0.gameAB().readLong();
            if (var3.gameAH()) {
                var3.saleCoinLock = var0.gameAB().readInt();
            } else if (var3.gameAJ() || var3.gameAK() || var3.gameAL() || var3.gameAM() || var3.gameAN() || var3.gameAO()) {
                var3.buyCoin = var0.gameAB().readInt();
                var3.buyCoinLock = var0.gameAB().readInt();
                var3.buyGold = var0.gameAB().readInt();
            }

            if (!var3.gameAB() && !var3.gameAC() && !var3.gameAD()) {
                if (var3.template.id == 233) {
                    var3.img = gameAA(NinjaUtil.gameAB(var0));
                } else if (var3.template.id == 234) {
                    var3.img = gameAA(NinjaUtil.gameAB(var0));
                } else if (var3.template.id == 235) {
                    var3.img = gameAA(NinjaUtil.gameAB(var0));
                }
            } else {
                var3.sys = var0.gameAB().readByte();
                var3.options = new MyVector();

                try {
                    while (true) {
                        var3.options.addElement(new ItemOption(var0.gameAB().readUnsignedByte(), var0.gameAB().readInt()));
                    }
                } catch (Exception var5) {
                }
            }

            if (var1 == 5) {
                Char.getMyChar().gameAZ();
                return;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            System.out.println("Controller.requestItemInfo()");
        }

        LockGame.gameAT();
    }

    private static void gameAI(Message var0) {
        try {
            byte var1 = var0.gameAB().readByte();

            for (byte var2 = 0; var2 < var1; ++var2) {
                short var3 = (short) var0.gameAB().readUnsignedByte();
                boolean var4 = var0.gameAB().readBoolean();
                boolean var5 = var0.gameAB().readBoolean();
                boolean var6 = var0.gameAB().readBoolean();
                boolean var7 = var0.gameAB().readBoolean();
                boolean var8 = var0.gameAB().readBoolean();
                int var9 = var0.gameAB().readUnsignedByte();
                byte var10 = var0.gameAB().readByte();
                int var11 = var0.gameAB().readInt();
                int var12 = var0.gameAB().readUnsignedByte();
                int var13 = var0.gameAB().readInt();
                short var14 = var0.gameAB().readShort();
                short var15 = var0.gameAB().readShort();
                byte var16 = var0.gameAB().readByte();
                byte var17 = var0.gameAB().readByte();
                boolean var18 = var0.gameAB().readBoolean();
                GameScr.gameAA((Mob) (new Mob(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, true)), (int) var2);
            }

        } catch (Exception var19) {
            var19.printStackTrace();
            System.out.println("err addMob");
        }
    }

    private static void gameAJ(Message var0) {
        try {
            short var1 = (short) var0.gameAB().readUnsignedByte();
            short var2 = var0.gameAB().readShort();
            short var3 = var0.gameAB().readShort();
            byte var4 = var0.gameAB().readByte();
            short var6 = var0.gameAB().readShort();
            EffectAuto.gameAA(var1, var2, var3, var4, var6, 1);
        } catch (Exception var5) {
            var5.printStackTrace();
            System.out.println("err add effAuto");
        }
    }

    private static void gameAK(Message var0) {
        try {
            short var1 = (short) var0.gameAB().readUnsignedByte();
            short var2 = var0.gameAB().readShort();
            byte[] var3 = null;
            if (var2 > 0) {
                var3 = new byte[var2];
                var0.gameAB().read(var3);
            }

            EffectAuto.gameAA(var1, var3);
        } catch (Exception var4) {
            var4.printStackTrace();
            System.out.println("err add effAuto");
        }
    }

    private static void gameAL(Message var0) {
        try {
            byte var1 = (byte) var0.gameAB().readUnsignedByte();
            byte[] var3 = NinjaUtil.gameAA(var0);
            EffectAuto.gameAA(var1, var3);
        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("err getImgEffAuto");
        }
    }

    private static void gameAM(Message var0) {
        try {
            byte var1 = var0.gameAB().readByte();
            Char.getMyChar().luong = var0.gameAB().readInt();
            Char.getMyChar().xu = var0.gameAB().readInt();
            Char.getMyChar().yen = var0.gameAB().readInt();
            int var3;
            if (var1 == 0) {
                if (GameScr.gameDD != null) {
                    GameScr.gameDD = null;
                }

                if (GameScr.gameCV != null) {
                    for (var3 = 0; var3 < GameScr.gameCV.length; ++var3) {
                        GameScr.gameCV[var3] = null;
                    }
                }
            } else if (var1 == 1) {
                if (GameScr.gameDD != null) {
                    GameScr.gameDD.isLock = true;
                    GameScr.gameDD.upgrade = var0.gameAB().readByte();
                    GameScr.gameGG = GameScr.efs[53];
                    GameScr.gameGF = 0;
                }

                if (GameScr.gameCV != null) {
                    for (var3 = 0; var3 < GameScr.gameCV.length; ++var3) {
                        GameScr.gameCV[var3] = null;
                    }
                }
            } else if ((var1 == 2 || var1 == 3) && GameScr.gameCV != null) {
                for (var3 = 0; var3 < GameScr.gameCV.length; ++var3) {
                    GameScr.gameCV[var3] = null;
                }
            }

            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().gameBA();
            GameCanvas.endDlg();
        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("err getImgEffAuto");
        }
    }

    private static void gameAN(Message var0) {
        try {
            Object var1;
            int var2;
            if (var0.gameAE.readByte() == 1) {
                var1 = Mob.gameAA(var0.gameAE.readUnsignedByte());
            } else if ((var2 = var0.gameAE.readInt()) == Char.getMyChar().charID) {
                var1 = Char.getMyChar();
            } else {
                var1 = GameScr.gameAE(var2);
            }

            if (var1 != null) {
                short var3 = var0.gameAE.readShort();
                int var4 = var0.gameAE.readInt();
                byte var10 = var0.gameAE.readByte();
                long var5 = (long) var4 + System.currentTimeMillis();
                var2 = var10 * 1000;
                short var11 = var3;

                DataSkillEff var12;
                for (var4 = 0; var4 < ((MainObject) var1).vecEFfect.size(); ++var4) {
                    if ((var12 = (DataSkillEff) ((MainObject) var1).vecEFfect.elementAt(var4)) != null && var12.gameAE == var11) {
                        var12.gameAG = var5;
                        var12.gameAH = var2;
                        return;
                    }
                }

                var12 = new DataSkillEff(var11, var5, var2);
                ((MainObject) var1).vecEFfect.addElement(var12);
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }
    }

    private static void gameAO(Message var0) {
        try {
            short var1 = (short) var0.gameAB().readUnsignedByte();
            byte[] var4 = NinjaUtil.gameAA(var0);
            GameData.gameAA(var1, var4);
            ImageIcon var2;
            if ((var2 = (ImageIcon) GameData.listImgIcon.get(String.valueOf(var1))) == null) {
                var2 = new ImageIcon();
                GameData.listImgIcon.put(String.valueOf(var1), var2);
            }

            var2.img = gameAA(var4);
            if (GameMidlet.CLIENT_TYPE != 1) {
                RMS.gameAA("ImgEffect ".concat(String.valueOf(var1)), var4);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("err getImgEffect");
        }
    }

    private static void gameAP(Message var0) {
        try {
            short var1 = (short) var0.gameAB().readUnsignedByte();
            short var2 = var0.gameAB().readShort();
            byte[] var3 = null;
            if (var2 > 0) {
                var3 = new byte[var2];
                var0.gameAB().read(var3);
            }

            EffectData var5;
            if ((var5 = (EffectData) GameData.listbyteData.get(String.valueOf(var1))) != null) {
                if (!var5.isLoad) {
                    DataSkillEff var6;
                    (var6 = new DataSkillEff()).gameAA(var3);
                    var5.gameAA = var6.gameAA;
                    var5.smallImage = var6.smallImage;
                    var5.fw = var6.gameAJ;
                    var5.fh = var6.gameAK;
                    var5.sequence = var6.sequence;
                    var5.indexStartSkill = var6.gameAF;
                    var5.frameChar = var6.frameChar;
                    var5.isLoad = true;
                }

            }
        } catch (Exception var4) {
            var4.printStackTrace();
            System.out.println("err getDataEffect ");
        }
    }
}
