
import java.io.IOException;

public final class Service {

    private ISession session = Session_ME.gameAA();
    private static Service instance;
    private int gameAC;
    private int gameAD;

    public static Service gI() {
        if (instance == null) {
            instance = new Service();
        }

        return instance;
    }

    private static Message gameAB(byte var0) {
        try {
            Message var1;
            (var1 = new Message((byte) -29)).gameAC().writeByte(var0);
            return var1;
        } catch (IOException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private static Message gameAC(byte var0) {
        try {
            Message var1;
            (var1 = new Message((byte) -28)).gameAC().writeByte(var0);
            return var1;
        } catch (IOException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private static Message gameAD(byte var0) {
        try {
            Message var1;
            (var1 = new Message((byte) -30)).gameAC().writeByte(var0);
            return var1;
        } catch (IOException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public final void gameAB() {
        try {
            Message var1;
            (var1 = gameAB((byte) -125)).gameAC().writeByte(GameMidlet.CLIENT_TYPE);
            var1.gameAC().writeByte(mGraphics.zoomLevel);
            var1.gameAC().writeBoolean(GameCanvas.isGPRS);
            var1.gameAC().writeInt(GameCanvas.w);
            var1.gameAC().writeInt(GameCanvas.h);
            var1.gameAC().writeBoolean(TField.isQwerty);
            var1.gameAC().writeBoolean(GameCanvas.isTouch);
            var1.gameAC().writeUTF(System.getProperty("microedition.platform"));
            var1.gameAC().writeByte(0);
            var1.gameAC().writeInt(0);
            var1.gameAC().writeByte(mResources.languageID);
            var1.gameAC().writeInt(GameMidlet.userProvider);
            var1.gameAC().writeUTF(GameMidlet.clientAgent);
            this.session.sendMessage(var1);
            var1.gameAD();
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public final void gameAA(String var1, String var2, String var3) {
        this.gameAB();

        try {
            Message var4;
            (var4 = gameAB((byte) -127)).gameAC().writeUTF(var1);
            var4.gameAC().writeUTF(var2);
            var4.gameAC().writeUTF(var3);
            var4.gameAC().writeUTF("");
            var4.gameAC().writeUTF("");
            var4.gameAC().writeUTF(RMS.gameAC("random"));
            var4.gameAC().writeByte(GameMidlet.serverLogin);
            
            String clientAuthKey = "VALID_CLIENT_KEY"; // code giới hạn đăng nhập
            var4.gameAC().writeUTF(clientAuthKey);
            
            this.session.sendMessage(var4);
            var4.gameAD();
        } catch (IOException var5) {
            var5.printStackTrace();
        }
    }

    public final void gameAB(String var1, String var2, String var3) {
        try {
            Message var4;
            (var4 = new Message((byte) 118)).gameAC().writeUTF(var1);
            var4.gameAC().writeUTF(var2);
            var4.gameAC().writeUTF(var3);
            this.session.sendMessage(var4);
            var4.gameAD();
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public final void gameAA(String var1) {
        try {
            Message var2;
            (var2 = gameAB((byte) -122)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            var2.gameAD();
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public final void gameAC() {
        Message var1 = new Message((byte) -17);
        this.session.sendMessage(var1);
        var1.gameAD();
    }

    public final void gameAA(int var1, int var2) {
        Message var3 = new Message((byte) 28);

        try {
            var3.gameAC().writeByte(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            var3.gameAD();
        } catch (Exception var4) {
        }
    }

    public final void gameAB(int var1, int var2) {
        try {
            if (var1 - this.gameAC != 0 || var2 - this.gameAD != 0) {
                Message var3;
                (var3 = new Message((byte) 1)).gameAC().writeShort(var1);
                var3.gameAC().writeShort(var2);
                this.gameAC = var1;
                this.gameAD = var2;
                this.session.sendMessage(var3);
                var3.gameAD();
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public final void gameAB(String var1) {
        Message var2 = new Message((byte) -28);

        try {
            var2.gameAC().writeByte(-126);
            var2.gameAC().writeUTF(var1);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        this.session.sendMessage(var2);
    }

    public final void gameAA(String var1, int var2, int var3) {
        Message var4 = new Message((byte) -28);

        try {
            var4.gameAC().writeByte(-125);
            var4.gameAC().writeUTF(var1);
            var4.gameAC().writeByte(var2);
            var4.gameAC().writeByte(var3);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        this.session.sendMessage(var4);
    }

    public final void gameAA(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -108)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAC(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 42)).gameAC().writeByte(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAD(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 94)).gameAC().writeInt(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAE(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = gameAD((byte) -109)).gameAC().writeByte(var1);
            var3.gameAC().writeShort(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAF(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = gameAD((byte) -108)).gameAC().writeShort(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAB(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 15)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAC(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 108)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAD(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 16)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAE(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 17)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void useItem(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 11)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var2.gameAD();
        }

        if (Char.getMyChar().arrItemBag[var1] != null && Char.getMyChar().arrItemBag[var1].template.type == 24) {
            GameScr.gI().gameAU();
            InfoDlg.gameAA("");
        }

    }

    public final void gameAG(int var1, int var2) {
        GameCanvas.msgdlg.gameAB();
        Message var3 = null;

        try {
            (var3 = new Message((byte) 14)).gameAC().writeByte(var1);
            if (var2 > 1) {
                var3.gameAC().writeInt(var2);
            }

            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAH(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 14)).gameAC().writeByte(var1);
            if (var2 > 1) {
                var3.gameAC().writeInt(var2);
            }

            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAA(int var1, int var2, int var3) {
        GameCanvas.msgdlg.gameAB();
        Message var4 = null;

        try {
            (var4 = new Message((byte) 13)).gameAC().writeByte(var1);
            var4.gameAC().writeByte(var2);
            if (var3 > 1) {
                var4.gameAC().writeShort(var3);
            }

            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAB(int var1, int var2, int var3) {
        Message var4 = null;

        try {
            (var4 = new Message((byte) 13)).gameAC().writeByte(var1);
            var4.gameAC().writeByte(var2);
            if (var3 > 1) {
                var4.gameAC().writeShort(var3);
            }

            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAG(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 41)).gameAC().writeShort(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAD() {
        Message var1 = null;

        try {
            var1 = gameAD((byte) -77);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAE() {
        Message var1 = null;

        try {
            var1 = new Message((byte) 36);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAI(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 12)).gameAC().writeByte(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAH(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 40)).gameAC().writeShort(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAC(int var1, int var2, int var3) {
        Message var4 = null;

        try {
            (var4 = new Message((byte) 29)).gameAC().writeByte(var1);
            var4.gameAC().writeByte(var2);
            var4.gameAC().writeByte(var3);
            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAA(short var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 34)).gameAC().writeShort(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(short var1, String var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 92)).gameAC().writeShort(var1);
            var3.gameAC().writeUTF(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAI(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -103)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAF() {
        Message var1 = null;

        try {
            var1 = gameAD((byte) -107);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAG() {
        Message var1 = null;

        try {
            var1 = gameAD((byte) -106);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAJ(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -105)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAK(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -104)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(Item[] var1) {
        GameCanvas.msgdlg.gameAB();
        Message var2 = null;

        try {
            var2 = new Message((byte) 19);

            for (int var3 = 0; var3 < var1.length; ++var3) {
                if (var1[var3] != null) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                }
            }

            this.session.sendMessage(var2);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(Item var1, Item[] var2, boolean var3) {
        GameCanvas.msgdlg.gameAB();
        Message var4 = null;

        try {
            (var4 = new Message((byte) 21)).gameAC().writeBoolean(var3);
            var4.gameAC().writeByte(var1.indexUI);

            for (int var9 = 0; var9 < var2.length; ++var9) {
                if (var2[var9] != null) {
                    var4.gameAC().writeByte(var2[var9].indexUI);
                }
            }

            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAA(Item var1, Item[] var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 21)).gameAC().writeBoolean(false);
            var3.gameAC().writeByte(var1.indexUI);

            for (int var8 = 0; var8 < var2.length; ++var8) {
                if (var2[var8] != null) {
                    var3.gameAC().writeByte(var2[var8].indexUI);
                }
            }

            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAB(Item[] var1) {
        GameCanvas.msgdlg.gameAB();
        Message var2 = null;

        try {
            var2 = new Message((byte) 20);

            for (int var3 = 0; var3 < var1.length; ++var3) {
                if (var1[var3] != null) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                }
            }

            this.session.sendMessage(var2);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAC(Item[] var1) {
        Message var2 = null;

        try {
            var2 = new Message((byte) 20);

            for (int var3 = 0; var3 < var1.length; ++var3) {
                if (var1[var3] != null) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                }
            }

            this.session.sendMessage(var2);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(Item var1) {
        GameCanvas.msgdlg.gameAB();
        Message var2 = null;

        try {
            (var2 = new Message((byte) 22)).gameAC().writeByte(var1.indexUI);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAL(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 44)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAM(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 99)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAN(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 106)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAO(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 107)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAP(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 66)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAH() {
        Message var1 = null;

        try {
            var1 = new Message((byte) 56);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAI() {
        Message var1 = null;

        try {
            var1 = new Message((byte) 57);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAJ() {
        Message var1 = null;

        try {
            var1 = new Message((byte) 46);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAA(int var1, Item[] var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 45)).gameAC().writeInt(var1);
            var1 = 0;

            int var4;
            for (var4 = 0; var4 < var2.length; ++var4) {
                if (var2[var4] != null) {
                    ++var1;
                }
            }

            var3.gameAC().writeByte(var1);

            for (var4 = 0; var4 < var2.length; ++var4) {
                if (var2[var4] != null) {
                    var3.gameAC().writeByte(var2[var4].indexUI);
                }
            }

            this.session.sendMessage(var3);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAA(MyVector var1, MyVector var2, int var3) {
        Message var4 = null;
        if (var3 != 0) {
            try {
                Mob var5;
                Char var7;
                if (var1.size() > 0 && var2.size() > 0) {
                    switch (var3) {
                        case 1:
                            var4 = new Message((byte) 4);
                            break;
                        case 2:
                            var4 = new Message((byte) 73);
                    }

                    var4.gameAC().writeByte(var1.size());

                    for (var3 = 0; var3 < var1.size(); ++var3) {
                        var5 = (Mob) var1.elementAt(var3);
                        var4.gameAC().writeByte(var5.mobId);
                    }

                    for (var3 = 0; var3 < var2.size(); ++var3) {
                        if ((var7 = (Char) var2.elementAt(var3)) != null) {
                            var4.gameAC().writeInt(var7.charID);
                        } else {
                            var4.gameAC().writeInt(-1);
                        }
                    }
                } else if (var1.size() > 0) {
                    var4 = new Message((byte) 60);

                    for (var3 = 0; var3 < var1.size(); ++var3) {
                        var5 = (Mob) var1.elementAt(var3);
                        var4.gameAC().writeByte(var5.mobId);
                    }
                } else if (var2.size() > 0) {
                    var4 = new Message((byte) 61);

                    for (var3 = 0; var3 < var2.size(); ++var3) {
                        var7 = (Char) var2.elementAt(var3);
                        var4.gameAC().writeInt(var7.charID);
                    }
                }

                if (var4 != null) {
                    this.session.sendMessage(var4);
                }

            } catch (Exception var6) {
                System.out.println("loi send attt " + var6.getMessage());
                var6.printStackTrace();
            }
        }
    }

    public final void gameAQ(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) -14)).gameAC().writeShort(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAR(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) -12)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAK() {
        Message var1 = null;

        try {
            var1 = new Message((byte) -9);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAL() {
        Message var1 = null;

        try {
            var1 = new Message((byte) -10);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAJ(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 47)).gameAC().writeByte(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAC(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) -23)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAD(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -78)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAM() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -122);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAN() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -121);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAO() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -120);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAP() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -119);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAQ() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -101);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAS(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 43)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAE(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 59)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAT(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 80)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAU(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 81)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAV(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 65)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAW(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 68)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAX(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -79)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAF(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 79)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAY(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -109)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAZ(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -93)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBA(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -87)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBB(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -86)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAR() {
        Message var1 = null;

        try {
            (var1 = new Message((byte) 74)).gameAC().writeByte(Char.getMyChar().cdir);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAS() {
        Message var1 = null;

        try {
            var1 = gameAD((byte) -88);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAA(boolean var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -76)).gameAC().writeBoolean(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAT() {
        Message var1 = null;

        try {
            var1 = new Message((byte) 83);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAU() {
        Message var1 = null;

        try {
            var1 = gameAD((byte) -85);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameBC(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 100)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(MyVector var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 25)).gameAC().writeByte(var1.size());

            for (int var3 = 0; var3 < var1.size(); ++var3) {
                Char var4 = (Char) var1.elementAt(var3);
                var2.gameAC().writeInt(var4.charID);
            }

            this.session.sendMessage(var2);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAV() {
        Message var1 = null;

        try {
            var1 = gameAD((byte) -84);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAG(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -83)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAH(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 23)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAI(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 24)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAJ(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 93)).gameAC().writeUTF(var1);
            var2.gameAC().writeByte(0);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAK(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) -20)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAL(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) -21)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(String var1, String var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) -22)).gameAC().writeUTF(var1);
            var3.gameAC().writeUTF(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAM(String var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) -19)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAB(String var1, String var2) {
        Message var3 = null;

        try {
            (var3 = gameAC((byte) -99)).gameAC().writeUTF(var1);
            var3.gameAC().writeUTF(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAA(String var1, byte[] var2, byte var3) {
        Message var4 = null;

        try {
            (var4 = gameAD((byte) -67)).gameAC().writeUTF(var1);
            var4.gameAC().writeInt(var2.length);
            var4.gameAC().write(var2);
            var4.gameAC().writeByte(var3);
            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAN(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -65)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(String var1, int var2) {
        Message var3 = null;

        try {
            (var3 = gameAC((byte) -97)).gameAC().writeInt(var2);
            var3.gameAC().writeUTF(var1);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameBD(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -115)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAW() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -113);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAX() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -112);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAY() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -111);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAZ() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -114);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameBE(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -63)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBF(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -61)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBG(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -62)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBH(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAD((byte) -60)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAO(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -95)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAB(String var1, int var2) {
        Message var3 = null;

        try {
            (var3 = gameAC((byte) -94)).gameAC().writeUTF(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAP(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -93)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBA() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -92);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameBI(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -90)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBJ(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -89)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBB() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -91);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAD(int var1, int var2, int var3) {
        Message var4 = null;

        try {
            (var4 = gameAC((byte) -88)).gameAC().writeByte(var1);
            var4.gameAC().writeByte(var2);
            var4.gameAC().writeByte(var3);
            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAQ(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -87)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAR(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -70)).gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBC() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -68);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameBD() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -69);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameBE() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -62);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAK(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = gameAC((byte) -85)).gameAC().writeByte(var1);
            var3.gameAC().writeInt(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameBK(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -105)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBL(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -102)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAL(int var1, int var2) {
        Message var3 = null;

        try {
            (var3 = gameAC((byte) -104)).gameAC().writeInt(var1);
            var3.gameAC().writeInt(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameBM(int var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -103)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBF() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -82);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameBG() {
        Message var1 = null;

        try {
            var1 = gameAC((byte) -79);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAA(Item var1, int var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 102)).gameAC().writeByte(var1.indexUI);
            var3.gameAC().writeInt(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameBN(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 104)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBO(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 105)).gameAC().writeInt(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBH() {
        Message var1 = null;

        try {
            (var1 = gameAC((byte) -72)).gameAC().writeByte(GameScr.gameBM);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAS(String var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) -61)).gameAC().writeByte(GameScr.gameBM);
            var2.gameAC().writeUTF(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBI() {
        Message var1 = null;

        try {
            (var1 = gameAC((byte) -60)).gameAC().writeByte(GameScr.gameBM);
            this.session.sendMessage(var1);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var1.gameAD();
        }

    }

    public final void gameAD(Item[] var1) {
        GameCanvas.msgdlg.gameAB();
        Message var2 = null;

        try {
            var2 = new Message((byte) 110);

            int var3;
            for (var3 = 0; var3 < var1.length; ++var3) {
                if (var1[var3] != null && (var1[var3].template.id == 10 || var1[var3].template.id == 11)) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                    break;
                }
            }

            for (var3 = 0; var3 < var1.length; ++var3) {
                if (var1[var3] != null && (var1[var3].template.id == 455 || var1[var3].template.id == 456)) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                }
            }

            this.session.sendMessage(var2);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAE(Item[] var1) {
        Message var2 = null;

        try {
            var2 = new Message((byte) 110);

            int var3;
            for (var3 = 0; var3 < 24; ++var3) {
                if (var1[var3] != null && (var1[var3].template.id == 10 || var1[var3].template.id == 11)) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                    break;
                }
            }

            for (var3 = 0; var3 < 24; ++var3) {
                if (var1[var3] != null && (var1[var3].template.id == 455 || var1[var3].template.id == 456)) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                }
            }

            this.session.sendMessage(var2);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAB(Item var1, Item[] var2) {
        GameCanvas.msgdlg.gameAB();
        Message var3 = null;

        try {
            (var3 = new Message((byte) 111)).gameAC().writeByte(var1.indexUI);

            for (int var8 = 0; var8 < var2.length; ++var8) {
                if (var2[var8] != null && (var2[var8].template.id == 455 || var2[var8].template.id == 456 || var2[var8].template.id == 457)) {
                    var3.gameAC().writeByte(var2[var8].indexUI);
                }
            }

            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAC(Item var1, Item[] var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 111)).gameAC().writeByte(var1.indexUI);

            for (int var8 = 0; var8 < 24; ++var8) {
                if (var2[var8] != null && (var2[var8].template.id == 455 || var2[var8].template.id == 456 || var2[var8].template.id == 457)) {
                    var3.gameAC().writeByte(var2[var8].indexUI);
                }
            }

            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAD(Item var1, Item[] var2) {
        GameCanvas.msgdlg.gameAB();
        Message var3 = null;

        try {
            (var3 = new Message((byte) 112)).gameAC().writeByte(var1.indexUI);
            int var9 = 0;

            for (int var4 = 0; var4 < var2.length; ++var4) {
                if (var2[var4] != null && var2[var4].template.id == 454) {
                    var3.gameAC().writeByte(var2[var4].indexUI);
                    ++var9;
                }
            }

            if (var9 >= 20) {
                this.session.sendMessage(var3);
                return;
            }

            GameCanvas.gameAA(mResources.gameWY);
        } catch (Exception var7) {
            var7.printStackTrace();
            return;
        } finally {
            var3.gameAD();
        }

    }

    public final void gameBP(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 113)).gameAC().writeShort(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(String var1, String var2, byte var3) {
        Message var4 = null;
        var1 = var1 + " " + var2;

        try {
            (var4 = new Message((byte) -21)).gameAC().writeUTF(var1);
            var4.gameAC().writeByte(var3);
            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAB(short var1, String var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 118)).gameAC().writeUTF(var2);
            var3.gameAC().writeShort(var1);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAB(short var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 119)).gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAC(String var1, String var2, String var3) {
        try {
            Message var4;
            (var4 = gameAB((byte) -123)).gameAC().writeUTF(var1);
            var4.gameAC().writeUTF(var2);
            var4.gameAC().writeUTF(var3);
            this.session.sendMessage(var4);
            var4.gameAD();
        } catch (IOException var5) {
            var5.printStackTrace();
        }
    }

    public final void gameAA(byte var1, String var2) {
        Message var3 = null;

        try {
            (var3 = new Message((byte) 121)).gameAC().writeByte(var1);
            var3.gameAC().writeUTF(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAA(byte var1, short var2) {
        Message var3 = null;

        try {
            (var3 = gameAC((byte) 122)).gameAC().writeByte(var1);
            var3.gameAC().writeByte(var2);
            this.session.sendMessage(var3);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var3.gameAD();
        }

    }

    public final void gameAA(short var1, String var2, byte var3) {
        Message var4 = null;

        try {
            (var4 = new Message((byte) 92)).gameAC().writeShort(var1);
            var4.gameAC().writeUTF(var2);
            var4.gameAC().writeByte(var3);
            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }

    public final void gameAA(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        try {
            Message var8;
            (var8 = new Message((byte) 123)).gameAC().writeUTF(var1);
            var8.gameAC().writeUTF(var2);
            var8.gameAC().writeUTF(var3);
            var8.gameAC().writeUTF(var4);
            var8.gameAC().writeUTF(var5);
            var8.gameAC().writeUTF(var6);
            var8.gameAC().writeUTF(var7);
            this.session.sendMessage(var8);
            var8.gameAD();
        } catch (Exception var9) {
            var9.printStackTrace();
        }
    }

    public final void gameAA(byte var1) {
        Message var2 = null;

        try {
            (var2 = gameAC((byte) 122)).gameAC().writeByte(4);
            var2.gameAC().writeByte(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAA(byte var1, Item var2, Item var3, Item[] var4) {
        GameCanvas.msgdlg.gameAB();
        Message var5 = null;

        try {
            (var5 = new Message((byte) 124)).gameAC().writeByte(var1);
            int var10;
            if (var1 == 0) {
                var5.gameAC().writeByte(var2.indexUI);
                var5.gameAC().writeByte(var3.indexUI);

                for (var10 = 0; var10 < var4.length; ++var10) {
                    if (var4[var10] != null) {
                        var5.gameAC().writeByte(var4[var10].indexUI);
                    }
                }
            } else if (var1 == 1) {
                var5.gameAC().writeByte(var3.indexUI);

                for (var10 = 0; var10 < var4.length; ++var10) {
                    if (var4[var10] != null) {
                        var5.gameAC().writeByte(var4[var10].indexUI);
                    }
                }
            } else if (var1 == 2 || var1 == 3) {
                var5.gameAC().writeByte(var3.indexUI);
            }

            this.session.sendMessage(var5);
            return;
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            var5.gameAD();
        }

    }

    public final void gameAF(Item[] var1) {
        GameCanvas.msgdlg.gameAB();
        Message var2 = null;

        try {
            var2 = new Message((byte) 126);

            for (int var3 = 0; var3 < var1.length; ++var3) {
                if (var1[var3] != null) {
                    var2.gameAC().writeByte(var1[var3].indexUI);
                }
            }

            this.session.sendMessage(var2);
            return;
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAC(short var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 125)).gameAC().writeByte(1);
            var2.gameAC().writeShort(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameBQ(int var1) {
        Message var2 = null;

        try {
            (var2 = new Message((byte) 125)).gameAC().writeByte(2);
            var2.gameAC().writeShort(var1);
            this.session.sendMessage(var2);
            return;
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            var2.gameAD();
        }

    }

    public final void gameAE(int var1, int var2, int var3) {
        Message var4 = null;

        try {
            (var4 = gameAD((byte) 111)).gameAC().writeByte(var1);
            var4.gameAC().writeInt(var2);
            var4.gameAC().writeInt(var3);
            this.session.sendMessage(var4);
            return;
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            var4.gameAD();
        }

    }
}
