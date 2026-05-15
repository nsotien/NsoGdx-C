
public final class DanhVong extends Auto {

    private static int dieukien;
    private static int gameBB;
    private static int gameBC;
    private static int danhduoc;
    private static int candanh;
    private static int captb;
    private static boolean gameBF;
    public static ItemTemplate itemTemplate;
    public static ItemTemplate itemTemplateup;
    private static Item itemas;
    private static Item itempos;
    private static boolean hoanthanh;
    private static boolean endauto;
    private static String khongthanh;
    private static String gameBL;
    private static boolean gameBM;
    private static int dadanh;
    private static boolean usedvp;
    private static int phaidanh;
    public static boolean tsmt;
    private long time;
    private static int htnv;

    public final void gameAC() {
        super.gameAC();
        dieukien = -2;
        gameBB = 0;
        gameBC = 0;
        itemas = null;
        itempos = null;
        hoanthanh = false;
        endauto = false;
        gameBM = false;
    }

    public final void gameAD() {
        super.gameAD();
        if (itempos != null) {
            if (itempos.typeUI == 5) {
                itempos = Char.getMyChar().arrItemBody[itempos.template.type];
            } else if (itempos.typeUI == 3) {
                itempos = Char.getMyChar().arrItemBag[itempos.indexUI];
            } else if (itempos.typeUI == 4) {
                itempos = Char.getMyChar().arrItemBox[itempos.indexUI];
            } else {
                System.out.println("Loi reset itemNV");
            }
        }

        if (itemas != null) {
            if (itemas.typeUI == 5) {
                itemas = Char.getMyChar().arrItemBody[itemas.template.type];
                return;
            }

            if (itemas.typeUI == 3) {
                itemas = Char.getMyChar().arrItemBag[itemas.indexUI];
                return;
            }

            System.out.println("Loi reset itemBody");
        }

    }

    public static void gameAA(String obj) {
        System.out.println("Text: ".concat(String.valueOf(obj)));
        if (dieukien >= 0) {
            System.out.println("A1");
            if (obj.startsWith("-") || obj.startsWith("Đã hủy nhiệm vụ ")) {
                System.out.println("A2");
                itemTemplate = null;
                hoanthanh = false;
                dieukien = -1;
                LockGame.notifyDV();
            }

            if (obj.startsWith("Trường học") && dieukien == 5) {
                dieukien = -2;
            }
        } else {
            if (obj.startsWith("Trường học")) {
                dieukien = -2;
                LockGame.notifyDV();
                return;
            }

            if (dieukien == -2) {
                System.out.println("B1");
                if (obj.startsWith("- Có thể nhận thêm ")) {
                    System.out.println("B2");
                    itemTemplate = null;
                    dieukien = -1;
                    LockGame.notifyDV();
                    return;
                }
            }

            System.out.println("C1");
            hoanthanh = false;
            String[] gameAC = Code.gameAC(obj, "\n");
            System.out.println("Nhiệm vụ: " + gameAC[0]);
            int n14;
            Item nameEM2;
            if (gameAC[0].equals("Tiêu diệt quái")) {
                Char.DanhQuai = true;
                Char.DanhTA = false;
                Char.DanhTL = false;

                for (n14 = 0; n14 < Char.getMyChar().arrItemBag.length; ++n14) {
                    nameEM2 = Char.getMyChar().arrItemBag[n14];
                    if (nameEM2 != null && nameEM2.template.type == 26 && nameEM2.template.id <= 3) {
                        Service.gI().gameAH(nameEM2.indexUI, 1);
                    }
                }

                dieukien = 1;
            } else if (gameAC[0].equals("Tiêu diệt tinh anh") && !FormDanhVong.tinhanh) {
                Char.DanhQuai = true;
                Char.DanhTA = true;
                Char.DanhTL = false;

                for (n14 = 0; n14 < Char.getMyChar().arrItemBag.length; ++n14) {
                    nameEM2 = Char.getMyChar().arrItemBag[n14];
                    if (nameEM2 != null && nameEM2.template.type == 26 && nameEM2.template.id <= 3) {
                        Service.gI().gameAH(nameEM2.indexUI, 1);
                    }
                }

                dieukien = 2;
            } else if (gameAC[0].equals("Tiêu diệt thủ lĩnh")&& !FormDanhVong.thulinh) {
                Char.DanhQuai = true;
                Char.DanhTA = false;
                Char.DanhTL = true;

                for (n14 = 0; n14 < Char.getMyChar().arrItemBag.length; ++n14) {
                    nameEM2 = Char.getMyChar().arrItemBag[n14];
                    if (nameEM2 != null && nameEM2.template.type == 26 && nameEM2.template.id <= 3) {
                        Service.gI().gameAH(nameEM2.indexUI, 1);
                    }
                }

                dieukien = 3;
            } else if (gameAC[0].equals("Nâng cấp vật phẩm")&& !FormDanhVong.nangcap) {
                for (n14 = 0; n14 < Char.getMyChar().arrItemBag.length; ++n14) {
                    nameEM2 = Char.getMyChar().arrItemBag[n14];
                    if (nameEM2 != null && nameEM2.template.type == 26 && nameEM2.template.id <= 3) {
                        Service.gI().gameAH(nameEM2.indexUI, 1);
                    }
                }

                dieukien = 4;
            } else if (gameAC[0].equals("Chiến thắng lôi đài")&& !FormDanhVong.loidai) {
                String[] s = Code.gameAC(FormDanhVong.TenDoiThu, ",");

                for (int k = 0; k < s.length; ++k) {
                    Code.gameAA(s[k], "lodai");
                }

                for (int k = 0; k < Char.getMyChar().arrItemBag.length; ++k) {
                    Item nameEM3 = Char.getMyChar().arrItemBag[k];
                    if (nameEM3 != null && nameEM3.template.type == 26 && nameEM3.template.id <= 3) {
                        Service.gI().gameAH(nameEM3.indexUI, 1);
                    }
                }

                dieukien = 5;
            } else if (gameAC[0].equals("Nông dân chăm chỉ")&& !FormDanhVong.kiemyen) {
                Char.DanhQuai = true;
                Char.DanhTA = true;
                Char.DanhTL = true;

                for (n14 = 0; n14 < Char.getMyChar().arrItemBag.length; ++n14) {
                    nameEM2 = Char.getMyChar().arrItemBag[n14];
                    if (nameEM2 != null && nameEM2.template.type == 26 && nameEM2.template.id <= 3) {
                        Service.gI().gameAH(nameEM2.indexUI, 1);
                    }
                }

                dieukien = 6;
            } else if (gameAC[0].equals("Cừu sát người khác")&& !FormDanhVong.cuusat) {
                String[] s = Code.gameAC(FormDanhVong.TenDoiThu, ",");

                for (int k = 0; k < s.length; ++k) {
                    Code.gameAA(s[k], "cusat");
                }

                for (int k = 0; k < Char.getMyChar().arrItemBag.length; ++k) {
                    Item nameEM3 = Char.getMyChar().arrItemBag[k];
                    if (nameEM3 != null && nameEM3.template.type == 26 && nameEM3.template.id <= 3) {
                        Service.gI().gameAH(nameEM3.indexUI, 1);
                    }
                }

                dieukien = 7;
            } else {
                dieukien = 0;
            }

            if (dieukien != 0) {
                String substring;
                String trim;
                String substring2;
                String substring3;
                int index;
                if (dieukien < 4) {
                    if (gameAC[1].startsWith("- Sử dụng ") && gameAC[2].startsWith("- Tiêu diệt ")) {
                        Char.NhatDa = false;
                        substring = gameAC[1].substring(10, gameAC[1].length());
                        trim = gameAC[2].substring(12).trim();
                        index = trim.indexOf(47);
                        substring2 = trim.substring(0, index);
                        substring3 = trim.substring(index + 1, trim.indexOf(32));
                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            System.out.println("TB=" + substring + " gender=" + Char.getMyChar().cgender);
                            itemTemplate = ItemTemplates.gameAA(substring, (byte) Char.getMyChar().cgender);
                            if (itemTemplate == null) {
                                throw new Exception();
                            }
                            System.out.println("Equip=" + itemTemplate.id + " type=" + itemTemplate.type + " name=" + itemTemplate.name + " mumb: " + substring2 + " max: " + substring3);
                            if (gameAC.length >= 4 && gameAC[3].equals("- Hoàn thành nhiệm vụ. Hãy gặp Ameji để trả nhiệm vụ")) {
                                hoanthanh = true;
                            }
                        } catch (Exception var11) {
                            GameScr.gameAC("Dừng Auto!");
                            endauto = true;
                        }
                    } else {
                        GameScr.gameAC("Dừng Auto!");
                        endauto = true;
                    }
                } else if (dieukien == 4) {
                    if (gameAC[1].startsWith("- Sử dụng ") && gameAC[2].startsWith("- Nâng cấp ")) {
                        Char.NhatDa = true;
                        Char.CapNhatDa = 4;
                        substring = gameAC[1].substring(10, gameAC[1].length());
                        trim = gameAC[2].substring(11).trim();
                        index = trim.indexOf(47);
                        substring2 = trim.substring(0, index);
                        substring3 = trim.substring(index + 1, trim.indexOf(32));
                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            System.out.println("TB=" + substring + " gender=" + Char.getMyChar().cgender);
                            itemTemplate = ItemTemplates.gameAA(substring, (byte) Char.getMyChar().cgender);
                            if (itemTemplate == null) {
                                throw new Exception();
                            }
                            itemTemplateup = ItemTemplates.gameAA("Giày Thô Ma", (byte) Char.getMyChar().cgender);
                            if (itemTemplateup == null) {
                                throw new Exception();
                            }
                            System.out.println("Equip=" + itemTemplate.id + " type=" + itemTemplate.type + " name=" + itemTemplate.name + " mumb: " + substring2 + " max: " + substring3);
                            if (gameAC.length >= 4 && gameAC[3].equals("- Hoàn thành nhiệm vụ. Hãy gặp Ameji để trả nhiệm vụ")) {
                                hoanthanh = true;
                            }
                        } catch (Exception var10) {
                            GameScr.gameAC("Dừng Auto!");
                            endauto = true;
                        }
                    } else {
                        GameScr.gameAC("Dừng Auto!");
                        endauto = true;
                    }
                } else if (dieukien == 5) {
                    label267:
                    {
                        Char.NhatDa = false;
                        if (gameAC[1].startsWith("- Sử dụng ") && gameAC[2].startsWith("- Chiến thắng ")) {
                            substring = gameAC[1].substring(10, gameAC[1].length());
                            index = (trim = gameAC[2].substring(14).trim()).indexOf(47);
                            substring2 = trim.substring(0, index);
                            substring3 = trim.substring(index + 1, trim.indexOf(32));

                            try {
                                danhduoc = Integer.parseInt(substring2);
                                candanh = Integer.parseInt(substring3);
                                System.out.println("TB=" + substring + " gender=" + Char.getMyChar().cgender);
                                if ((itemTemplate = ItemTemplates.gameAA(substring, (byte) Char.getMyChar().cgender)) == null) {
                                    throw new Exception();
                                }

                                System.out.println("Equip=" + itemTemplate.id + " type=" + itemTemplate.type + " name=" + itemTemplate.name + " mumb: " + substring2 + " max: " + substring3);
                                if (gameAC.length >= 4 && gameAC[3].equals("- Hoàn thành nhiệm vụ. Hãy gặp Ameji để trả nhiệm vụ")) {
                                    hoanthanh = true;
                                } else {
                                    Code.gameAG.gameAL();
                                }
                                break label267;
                            } catch (Exception var12) {
                            }
                        }

                        GameScr.gameAC("Dừng Auto!");
                        endauto = true;
                    }
                } else if (dieukien == 6) {
                    if (gameAC[1].startsWith("- Sử dụng ") && gameAC[2].startsWith("- Kiếm ")) {
                        Char.NhatDa = false;
                        substring = gameAC[1].substring(10, gameAC[1].length());
                        index = (trim = gameAC[2].substring(6).trim()).indexOf(47);
                        substring2 = trim.substring(0, index);
                        substring3 = trim.substring(index + 1, trim.indexOf(32));

                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            System.out.println("TB=" + substring + " gender=" + Char.getMyChar().cgender);
                            if ((itemTemplate = ItemTemplates.gameAA(substring, (byte) Char.getMyChar().cgender)) == null) {
                                throw new Exception();
                            }

                            System.out.println("Đã đánh " + dadanh + " Phải đánh " + phaidanh + "Equip=" + itemTemplate.id + " type=" + itemTemplate.type + " name=" + itemTemplate.name + " mumb: " + substring2 + " max: " + substring3);
                            if (gameAC.length >= 4 && gameAC[3].equals("- Hoàn thành nhiệm vụ. Hãy gặp Ameji để trả nhiệm vụ")) {
                                hoanthanh = true;
                            }
                        } catch (Exception var9) {
                            GameScr.gameAC("Dừng Auto!");
                            endauto = true;
                        }
                    } else {
                        GameScr.gameAC("Dừng Auto!");
                        endauto = true;
                    }
                } else if (dieukien == 7) {
                    if (gameAC[1].startsWith("- Sử dụng ") && gameAC[2].startsWith("- Cừu sát ")) {
                        Char.NhatDa = false;
                        substring = gameAC[1].substring(10, gameAC[1].length());
                        index = (trim = gameAC[2].substring(9).trim()).indexOf(47);
                        substring2 = trim.substring(0, index);
                        substring3 = trim.substring(index + 1, trim.indexOf(32));

                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            System.out.println("TB=" + substring + " gender=" + Char.getMyChar().cgender);
                            if ((itemTemplate = ItemTemplates.gameAA(substring, (byte) Char.getMyChar().cgender)) == null) {
                                throw new Exception();
                            }

                            System.out.println("Equip=" + itemTemplate.id + " type=" + itemTemplate.type + " name=" + itemTemplate.name + " mumb: " + substring2 + " max: " + substring3);
                            if (gameAC.length >= 4 && gameAC[3].equals("- Hoàn thành nhiệm vụ. Hãy gặp Ameji để trả nhiệm vụ")) {
                                hoanthanh = true;
                            }
                        } catch (Exception var8) {
                            GameScr.gameAC("Dừng Auto!");
                            endauto = true;
                        }
                    } else {
                        GameScr.gameAC("Dừng Auto!");
                        endauto = true;
                    }
                }

                if (itemTemplate != null && itemTemplate.level > Char.getMyChar().clevel) {
                    dieukien = 0;
                }
            }

            LockGame.notifyDV();
        }

    }

    public static boolean gameAB(String substring) {
        if (substring.equals(gameBL)) {
            gameBM = true;
            return true;
        } else {
            if (substring.startsWith(khongthanh)) {
                if (dieukien >= 4 && dieukien != 6) {
                    if (dieukien == 4) {
                        Service.gI().gameAJ(Char.getMyChar().cName);
                        LockGame.gameAQ();

                        for (int n15 = 0; n15 < Char.getMyChar().arrItemBag.length; ++n15) {
                            Item gameDI2 = Char.getMyChar().arrItemBag[n15];
                            if (gameDI2 != null && gameDI2.upgrade == 8 && (Char.getMyChar().arrItemBag[n15].template.id == 126 || Char.getMyChar().arrItemBag[n15].template.id == 127)) {
                                Service.gI().gameAA(gameDI2);
                                LockGame.gameAQ();
                                Service.gI().gameAJ(Char.getMyChar().cName);
                                LockGame.gameAQ();
                                break;
                            }
                        }

                        hoanthanh = true;
                    } else {
                        hoanthanh = true;
                    }
                } else {
                    danhduoc = candanh;
                }
            }

            if (substring.startsWith("Đã hết số lần dùng trong ngày hôm nay rồi.")) {
                usedvp = true;
            }

            if (substring.indexOf("Kiếm") != -1 && dieukien == 6) {
                substring = substring.substring(substring.indexOf("Kiếm ") + 4, substring.indexOf(47));
                GameScr.gameAC("Yên: " + substring + " / " + candanh);

                try {
                    danhduoc = Integer.parseInt(substring);
                } catch (NumberFormatException var6) {
                }
            }

            if (substring.indexOf("Cừu sát ") != -1 && dieukien == 7) {
                substring = substring.substring(substring.indexOf("Cừu sát ") + 7, substring.indexOf(47));
                GameScr.gameAC("Cừu Sát: " + substring + " / " + candanh);

                try {
                    danhduoc = Integer.parseInt(substring);
                } catch (NumberFormatException var5) {
                }

                if (danhduoc < candanh) {
                    Session_ME.gameAA.gameAC();
                    Controller.gameAD().onDisconnected();
                }
            }

            if (substring.indexOf("Chiến thắng ") != -1 && dieukien == 5) {
                substring = substring.substring(substring.indexOf("Chiến thắng ") + 12, substring.indexOf(47));
                GameScr.gameAC("Chiến Thắng : " + substring + " / " + candanh + " trận");

                try {
                    danhduoc = Integer.parseInt(substring);
                } catch (NumberFormatException var4) {
                }

                if (danhduoc < candanh) {
                    Session_ME.gameAA.gameAC();
                    Controller.gameAD().onDisconnected();
                }
            }

            if (substring.indexOf("Tiêu diệt ") != -1 && dieukien < 4) {
                System.out.println("+1 kill ");
                substring = substring.substring(substring.indexOf("Tiêu diệt") + 10, substring.indexOf(47));

                try {
                    dadanh = Integer.parseInt(substring);
                } catch (NumberFormatException var3) {
                }
            }

            return true;
        }
    }

    private static Item[] gameAC(int var0, int var1) {
        switch (var0) {
            case 0:
                if (var1 == 1) {
                    return GameScr.gameBV;
                }

                return GameScr.gameBW;
            case 1:
                return GameScr.gameCJ;
            case 2:
                if (var1 == 1) {
                    return GameScr.gameBX;
                }

                return GameScr.gameBY;
            case 3:
                return GameScr.gameCF;
            case 4:
                if (var1 == 1) {
                    return GameScr.gameBZ;
                }

                return GameScr.gameCA;
            case 5:
                return GameScr.gameCG;
            case 6:
                if (var1 == 1) {
                    return GameScr.gameCB;
                }

                return GameScr.gameCC;
            case 7:
                return GameScr.gameCH;
            case 8:
                if (var1 == 1) {
                    return GameScr.gameCD;
                }

                return GameScr.gameCE;
            case 9:
                return GameScr.gameCI;
            default:
                return null;
        }
    }

    private boolean gameAL() {
        if (itemTemplate.level >= 50) {
            return true;
        } else if (!TileMap.gameAF(TileMap.mapID)) {
            this.gameAA(FormDanhVong.MapLD, -2, -1, -1);
            return false;
        } else {
            System.out.println("Buy " + itemTemplate.name);
            Item[] array = gameAC(itemTemplate.type, Char.getMyChar().cgender);
            if (itemTemplate.type == 1) {
                GameScr.PickNpc(0, 0, 0);
            } else if (itemTemplate.type == 8) {
                GameScr.PickNpc(1, 0, 4);
            } else if (itemTemplate.type == 6) {
                GameScr.PickNpc(1, 0, 3);
            } else if (itemTemplate.type == 4) {
                GameScr.PickNpc(1, 0, 2);
            } else if (itemTemplate.type == 2) {
                GameScr.PickNpc(1, 0, 1);
            } else if (itemTemplate.type == 0) {
                GameScr.PickNpc(1, 0, 0);
            } else if (itemTemplate.type == 9) {
                GameScr.PickNpc(2, 0, 3);
            } else if (itemTemplate.type == 7) {
                GameScr.PickNpc(2, 0, 2);
            } else if (itemTemplate.type == 5) {
                GameScr.PickNpc(2, 0, 1);
            } else if (itemTemplate.type == 3) {
                GameScr.PickNpc(2, 0, 0);
            }

            if (array == null) {
                LockGame.waitDV();
                array = gameAC(itemTemplate.type, Char.getMyChar().cgender);
            }

            if (array != null) {
                Item nameEM = null;

                for (int i = 0; i < array.length; ++i) {
                    if (array[i].template.id == itemTemplate.id) {
                        nameEM = array[i];
                        break;
                    }
                }

                if (nameEM != null) {
                    Service.gI().gameAB(nameEM.typeUI, nameEM.indexUI, 1);
                    LockGame.gameAG();
                }
            } else {
                System.out.println("BuyER: " + itemTemplate.type);
            }

            return false;
        }
    }

    public void nangcap(Item tb, int cap) {
        int n4 = 0;
        int n5 = 0;
        if (tb.gameAR()) {
            n4 = GameScr.upClothe[tb.upgrade] / 3;
            n5 = GameScr.coinUpClothes[tb.upgrade];
        } else if (tb.gameAS()) {
            n4 = GameScr.upAdorn[tb.upgrade] / 3;
            n5 = GameScr.coinUpAdorns[tb.upgrade];
        } else if (tb.gameAT()) {
            n4 = GameScr.upWeapon[tb.upgrade] / 3;
            n5 = GameScr.coinUpWeapons[tb.upgrade];
        }

        int gameAI2;
        int n7;
        if (n4 << 1 <= Char.reAA() && n5 << 1 <= Char.getMyChar().yen && tb.upgrade < cap) {
            if (TileMap.mapID != 22) {
                if (!TileMap.truongandlang(TileMap.mapID) && Char.getMyChar().ctaskId < 42) {
                    Auto.reAD();
                }
                this.gameAA(22, -2, -1, -1);
                return;
            }
            gameAI2 = tb.upgrade;
            GameScr.gameAH(6);
            GameScr.gI().gameAD((int) 10);
            GameScr.arritemup = tb;

            for (int n6 = 0; n6 < 1 && tb.upgrade == gameAI2; ++n6) {
                GameScr.upitem = new Item[18];
                n7 = 0;
                int n8 = 0;

                for (int n9 = 0; n9 < Char.getMyChar().arrItemBag.length && n8 < n4; ++n9) {
                    Item nameEM = Char.getMyChar().arrItemBag[n9];
                    if (tb.upgrade == 6  && FormDanhVong.baohiem7) {
                        if (Char.gameAI(242) < 0) {
                            if (Char.getMyChar().luong >= 10) {
                                Service.gI().gameAB(14, 22, 1);
                                LockGame.gameAG();
                            } else {
                                GameScr.gameAC("Hết Lượng Mua BHSC");
                            }
                        } else {
                            GameScr.upitem[2] = chonitem(242);
                        }
                    }

                    if (tb.upgrade == 7 && FormDanhVong.baohiem8) {
                        if (Char.gameAI(242) < 0) {
                            if (Char.getMyChar().luong >= 10) {
                                Service.gI().gameAB(14, 22, 1);
                                LockGame.gameAG();
                            } else {
                                GameScr.gameAC("Hết Lượng Mua BHSC");
                            }
                        } else {
                            GameScr.upitem[6] = chonitem(242);
                        }
                    }

                    if (nameEM != null && nameEM.template.type == 26 && nameEM.template.id <= 6) {
                        Char.getMyChar().arrItemBag[n9] = null;
                        GameScr.upitem[n7++] = nameEM;
                        n8 += GameScr.upClothe[nameEM.template.id];
                    }
                }

                do {
                    try {
                        Thread.sleep(1500L);
                    } catch (InterruptedException var11) {
                    }

                    Service.gI().gameAA(tb, GameScr.upitem);
                    Service.gI().gameAJ(Char.getMyChar().cName);
                    LockGame.gameAQ();
                } while (GameScr.upitem[0] != null);
            }

            GameScr.arritemup = null;
        } else {
            TaskOrder gameAM2;
            n7 = FormDanhVong.MapDV > 0 ? (gameAI2 = FormDanhVong.MapDV) : ((gameAM2 = Char.gameAM(0)) != null ? (gameAI2 = gameAM2.mapId) : (gameAI2 = -1));
            short n12 = (short) gameAI2;
            if (n7 <= 0) {
                GameScr.gameAC("Chưa đặt map hoặc k có nvhn");
                endauto = true;
                return;
            }

            if (TileMap.mapID == n12) {
                Char.CapNhatDa = 5;
                Code.gameAQ = false;
                Char.DanhQuai = false;
                Char.DanhTA = false;
                Char.DanhTL = false;
                this.gameAC(-2);
                this.gameAB(-1, 1);
                return;
            }

            this.gameAA(n12, FormDanhVong.KhuDV, -1, -1);
            Char.NhatDa = true;
        }

    }

    private boolean muaitemup() {
        if (!TileMap.gameAF(TileMap.mapID)) {
            this.gameAA(FormDanhVong.MapLD, -2, -1, -1);
            return false;
        } else {
            System.out.println("Buy Item Up" + itemTemplateup.name);
            Item[] array = gameAC(itemTemplateup.type, Char.getMyChar().cgender);
            if (itemTemplateup.type == 8) {
                GameScr.PickNpc(1, 0, 4);
            }

            if (array == null) {
                LockGame.waitDV();
                array = gameAC(itemTemplateup.type, Char.getMyChar().cgender);
            }

            if (array != null) {
                Item nameEM = null;

                for (int i = 0; i < array.length; ++i) {
                    if (array[i].template.id == itemTemplateup.id) {
                        nameEM = array[i];
                        break;
                    }
                }

                if (nameEM != null) {
                    Service.gI().gameAB(nameEM.typeUI, nameEM.indexUI, 1);
                    LockGame.gameAG();
                }
            } else {
                System.out.println("BuyER: " + itemTemplateup.type);
            }

            return false;
        }
    }

    private boolean useitem() {
        if (itempos == null) {
            if ((itempos = Char.gameAF(itemTemplate.id)) == null) {
                if ((itempos = Char.gameAL(itemTemplate.id)) == null) {
                    return this.gameAL();
                }

                System.out.println("ItemNV box type=" + itempos.typeUI + " index=" + itempos.indexUI);
                gameBF = true;
            } else {
                System.out.println("ItemNV bag type=" + itempos.typeUI + " index=" + itempos.indexUI);
            }

            return false;
        } else {
            if (itempos.typeUI == 4) {
                GameScr.PickNpc(5, 0, 0);
                if (Char.gameBG() > 0) {
                    Service.gI().gameAC(itempos.indexUI);

                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException var2) {
                    }
                }
            } else {
                if (itemas == null) {
                    itemas = Char.getMyChar().arrItemBody[itemTemplate.type];
                }

                if (itemas != null) {
                    System.out.println("ItemBody type=" + itemas.typeUI + " index=" + itemas.indexUI);
                }

                if (itempos.upgrade >= 0) {
                    Service.gI().useItem(itempos.indexUI);
                    LockGame.gameAQ();
                }
            }

            return false;
        }
    }

    public final void gameAK() {
        if (Auto.reAC()) {
            Auto.gameAA(false);
        } else if (gameBM) {
            GameScr.gameAC("Xong");
            if (super.reAB != null && !(super.reAB instanceof DanhVong)) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException var7) {
                }

                Code.gameAC();
            } else {
                Code.gameAF();
            }
        } else {
            int n4;
            if (dieukien > 0 && !hoanthanh && !endauto) {
                short n3;
                TaskOrder gameAM;
                int n;
                if (dieukien < 4) {
                    if (Char.getMyChar().arrItemBody[itemTemplate.type] != null && Char.getMyChar().arrItemBody[itemTemplate.type].template.id == itemTemplate.id) {
                        n = FormDanhVong.MapDV > 0 ? (n4 = FormDanhVong.MapDV) : ((gameAM = Char.gameAM(0)) != null ? (n4 = gameAM.mapId) : (n4 = -1));
                        n3 = (short) n4;
                        if (n <= 0) {
                            GameScr.gameAC("Chưa đặt map hoặc k có nvhn");
                            endauto = true;
                            return;
                        }

                        if (TileMap.mapID != n3) {
                            this.gameAA(n3, FormDanhVong.KhuDV, -1, -1);
                            return;
                        }

                        if (danhduoc < candanh) {
                            this.gameAB(-1, dieukien == 2 ? 3 : (dieukien == 3 ? 5 : 1));
                            this.gameAC(-1);
                            return;
                        }

                        hoanthanh = true;
                        Auto.reAD();
                    } else if (this.useitem()) {
                        GameScr.gameAC("Thiếu item: " + itemTemplate.name);
                        endauto = true;
                    }
                } else {
                    Item iteminbag;
                    if (dieukien == 4) {
                        if (Char.getMyChar().arrItemBody[itemTemplate.type] != null && Char.getMyChar().arrItemBody[itemTemplate.type].template.id == itemTemplate.id) {
                            if ((n4 = Char.gameAI(itemTemplateup.id)) < 0) {
                                if (this.muaitemup()) {
                                    GameScr.gameAC("Thiếu item: " + itemTemplateup.name);
                                    endauto = true;
                                }
                            } else if (danhduoc < candanh) {
                                iteminbag = Char.getMyChar().arrItemBag[n4];
                                if (iteminbag.upgrade == 8) {
                                    Service.gI().gameAA(iteminbag);
                                    LockGame.gameAQ();
                                    Service.gI().gameAJ(Char.getMyChar().cName);
                                    LockGame.gameAQ();
                                }

                                this.nangcap(iteminbag, 8);
                            }
                        } else if (this.useitem()) {
                            GameScr.gameAC("Thiếu item: " + itemTemplate.name);
                            endauto = true;
                        }
                    }

                    if (dieukien == 5) {
                        String[] s = Code.gameAC(FormDanhVong.TenDoiThu, ",");

                        for (int k = 0; k < s.length; ++k) {
                            if (s[k] == null || s[k].length() == 0) {
                                GameScr.gameAC("Hãy chat ld để set thông tin");
                                endauto = true;
                                return;
                            }

                            if (Char.getMyChar().arrItemBody[itemTemplate.type] != null && Char.getMyChar().arrItemBody[itemTemplate.type].template.id == itemTemplate.id) {
                                if (danhduoc < candanh) {
                                    Code.gameAG.gameAK();
                                }
                            } else if (this.useitem()) {
                                GameScr.gameAC("Thiếu item: " + itemTemplate.name);
                                endauto = true;
                            }
                        }
                    }

                    if (dieukien == 6) {
                        if (Char.getMyChar().arrItemBody[itemTemplate.type] != null && Char.getMyChar().arrItemBody[itemTemplate.type].template.id == itemTemplate.id) {
                            n = FormDanhVong.MapDV > 0 ? (n4 = FormDanhVong.MapDV) : ((gameAM = Char.gameAM(0)) != null ? (n4 = gameAM.mapId) : (n4 = -1));
                            n3 = (short) n4;
                            if (n <= 0) {
                                GameScr.gameAC("Chưa đặt map hoặc k có nvhn");
                                endauto = true;
                                return;
                            }

                            if (TileMap.mapID != n3) {
                                this.gameAA(n3, FormDanhVong.KhuDV, -1, -1);
                                return;
                            }

                            if (danhduoc < candanh) {
                                this.gameAB(-1, this.gameAA(Char.DanhQuai, Char.DanhTA, Char.DanhTL));
                                this.gameAC(-1);
                                return;
                            }

                            hoanthanh = true;
                            Auto.reAD();
                        } else if (this.useitem()) {
                            GameScr.gameAC("Thiếu item: " + itemTemplate.name);
                            endauto = true;
                        }
                    }

                    if (dieukien == 7) {
                        if (Char.getMyChar().arrItemBody[itemTemplate.type] != null && Char.getMyChar().arrItemBody[itemTemplate.type].template.id == itemTemplate.id) {
                            if (TileMap.mapID != FormDanhVong.MapCS) {
                                this.gameAA(FormDanhVong.MapCS, FormDanhVong.KhuCS, -1, -1);
                                return;
                            }

                            if (danhduoc < candanh) {
                                for (n4 = 0; n4 < GameScr.vCharInMap.size(); ++n4) {

                                    Char ychar = (Char) GameScr.vCharInMap.elementAt(n4);
                                    if (Char.getMyChar().clevel - 10 <= ychar.clevel && ychar.clevel <= Char.getMyChar().clevel + 10 && ychar.cHP > 0) {
                                        if (System.currentTimeMillis() - this.time >= 1500L) {
                                            Char.gameAC(ychar.cx, ychar.cy);
                                            this.time = System.currentTimeMillis();
                                        }

                                        if (Char.getMyChar().cTypePk != 3) {
                                            Service.gI().gameAZ(3);
                                        }

                                        if (Char.getMyChar().cPk >= 5 && (iteminbag = Char.gameAF(257)) != null && iteminbag.template.id == 257) {
                                            Service.gI().useItem(iteminbag.indexUI);
                                        }

                                        Auto.reAE.removeAllElements();
                                        Auto.reAF.removeAllElements();
                                        Auto.reAF.addElement(ychar);
                                        Service.gI().gameAG(skill1.template.id);
                                        Service.gI().gameAA((MyVector) Auto.reAE, (MyVector) Auto.reAF, (int) 2);
                                        if (System.currentTimeMillis() - skill1.lastTimeUseThisSkill >= (long) skill1.coolDown + 50L) {
                                            skill1.lastTimeUseThisSkill = System.currentTimeMillis();
                                            skill1.paintCanNotUseSkill = true;
                                            if (!Code.timBG) {
                                                Char.getMyChar().gameAB(GameScr.sks[skill1.template.id], 0);
                                            }
                                        }
                                    }
                                }

                                return;
                            }

                            hoanthanh = true;
                            Auto.reAD();
                        } else if (this.useitem()) {
                            GameScr.gameAC("Thiếu item: " + itemTemplate.name);
                            endauto = true;
                        }

                    }
                }
            } else {
                if (!TileMap.gameAF(TileMap.mapID)) {
                    this.gameAA(FormDanhVong.MapLD, -2, -1, -1);
                    return;
                }

                if (dieukien == -2) {
                    System.out.println("InfoNV");
                    GameScr.gameAC("Xem Info NVDV " + (gameBB + 1));

                    GameScr.gameAH(2);
                    GameScr.PickNpc(2, 1, 6);
                    LockGame.waitDV();
                    return;
                }

                if (dieukien == -1) {
                    System.out.println("NhanNV");
                    GameScr.gameAC("Nhận NVDV " + (gameBB + 1));

                    GameScr.gameAH(2);
                    GameScr.PickNpc(2, 1, 0);
                    macdo12();
                    LockGame.waitDV();
                    return;
                }

                if (dieukien == 0) {
                    System.out.println("HuyNV");
                    GameScr.gameAC("Hủy NVDV " + (gameBB + 1));
                    GameScr.PickNpc(2, 1, 2);
                    GameScr.gameAH(2);
                    Service.gI().gameAO(4);
                    LockGame.waitDV();
                    ++gameBB;
                    dieukien = -1;
                    return;
                }

                if (endauto || hoanthanh) {
                    if (itemas != null) {
                        if (itemas.typeUI != 5) {
                            System.out.println("Mac TB: " + itemas.template.name + " index=" + itemas.indexUI);
                            Service.gI().useItem(itemas.indexUI);
                            LockGame.gameAQ();
                            itemas = null;
                            return;
                        }

                        if (Char.getMyChar().arrItemBody[itemas.template.type].upgrade < 12) {
                            System.out.println("Loi item: " + itemas.template.type);
                        }

                        itemas = null;
                    } else if (itempos != null) {
                        if (!gameBF) {
                            itempos = null;
                            return;
                        }

                        if (itempos.typeUI == 3) {
                            System.out.println("Cat item " + itempos.template.name + " vao ruong");
                            GameScr.PickNpc(5, 0, 0);
                            if (Char.gameBH() > 0) {
                                Service.gI().gameAE(itempos.typeUI);

                                try {
                                    Thread.sleep(1000L);
                                    return;
                                } catch (InterruptedException var5) {
                                    return;
                                }
                            }

                            itempos = null;
                            return;
                        }

                        itempos = null;
                    } else if (hoanthanh) {
                        if (Char.gameBG() <= 0) {
                            GameScr.gameAC("Hành trang đầy");
                            return;
                        }

                        System.out.println("HoanThanhNV");
                        if (Char.getMyChar().cTypePk == 3) {
                            Service.gI().gameAZ(0);
                        }

                        GameScr.gameAC("Hoàn thành NVDV " + (gameBB + 1));
                        GameScr.gameAH(2);

                        GameScr.PickNpc(2, 1, 1);

                        macdo12();
                        LockGame.waitDV();
                        ++gameBB;
                        ++gameBC;
                        ++htnv;
                    } else if (super.reAB != null && !(super.reAB instanceof DanhVong)) {
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException var6) {
                        }

                        Code.gameAC();
                    }
                }
            }

        }
    }

    public static void macdo12() {
        for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
            Item nameEM2 = Char.getMyChar().arrItemBag[i];
            if (nameEM2 != null && nameEM2.template.type < 10 && nameEM2.upgrade >= 12) {
                Service.gI().useItem(nameEM2.indexUI);
            }
        }

    }

    public final String toString() {
        if (dieukien == 1) {
            return " - Đánh quái thường: " + dadanh + "/" + phaidanh + " | Đã làm : " + htnv + " NV";
        } else if (dieukien == 2) {
            return " - Đánh tinh anh: " + dadanh + "/" + phaidanh + " | Đã làm : " + htnv + " NV";
        } else if (dieukien == 3) {
            return " - Đánh thủ lĩnh: " + dadanh + "/" + phaidanh + " | Đã làm : " + htnv + " NV";
        } else if (dieukien == 4) {
            return " - Nâng cấp: " + dadanh + "/" + phaidanh + " | Đã làm : " + htnv + " NV";
        } else if (dieukien == 5) {
            return " - Lôi đài | Đã làm : " + htnv + " NV";
        } else if (dieukien == 6) {
            return " - Kiếm: " + phaidanh + " Yên | Đã làm : " + htnv + " NV";
        } else {
            return dieukien == 7 ? " - Cừ sát: " + danhduoc + "/" + phaidanh + " người | Đã làm : " + htnv + " NV" : "NVDV ";
        }
    }

    public static Item chonitem(int id) {
        for (int n9 = 0; n9 < Char.getMyChar().arrItemBag.length; ++n9) {
            Item nameEM = Char.getMyChar().arrItemBag[n9];
            if (nameEM != null && nameEM.template.type == 28 && nameEM.template.id == id) {
                return nameEM;
            }
        }

        return null;
    }

    static {
        dadanh = 0;
        phaidanh = 0;
        dieukien = -2;
        gameBB = -1;
        gameBC = -1;
        danhduoc = -1;
        candanh = -1;
        gameBF = false;
        hoanthanh = false;
        endauto = false;
        gameBM = false;
        khongthanh = "Hoàn thành nhiệm vụ. Hãy gặp Ameji để trả nhiệm vụ";
        gameBL = "Con đã hoàn thành đủ số nhiệm vụ cho ngày hôm nay rồi";
    }

}
