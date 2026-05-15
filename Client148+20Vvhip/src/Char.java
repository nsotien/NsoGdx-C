
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Char extends MainObject {
    public String gameED = "";
    public Char gameAD;
    public Char gameAE;
    public boolean isHuman;
    public boolean isNhanban;
    public boolean isCaptcha;
    private int tickEffWolf = 0;
    private int timeBocdau = 0;
    public long lastUpdateTime;
    public ChatPopup chatPopup;
    public long cEXP;
    public long cExpDown;
    private int lcx;
    private int lcy;
    public int cx = 24;
    public int cy = 24;
    public int cvx;
    public int cvy;
    public int cp1;
    private int cp2;
    private int cp3;
    public int statusMe = 5;
    public int cdir = 1;
    public int charID;
    public int cgender;
    public int ctaskId;
    public int cspeed;
    public int cdame;
    public int cdameDown;
    public int clevel;
    public int cMP;
    public int cMaxMP;
    public int cHP;
    public int cHpNew;
    public int cMaxHP;
    private int gameHQ;
    public int eff5BuffHp;
    public int eff5BuffMp;
    public long autoUpHp;
    public int pPoint;
    public int sPoint;
    public int pointUydanh;
    public int pointNon;
    public int pointVukhi;
    public int pointAo;
    public int pointLien;
    public int pointGangtay;
    public int pointNhan;
    public int pointQuan;
    public int pointNgocboi;
    public int pointGiay;
    public int pointPhu;
    public int pointTinhTu;
    public int countFinishDay;
    public int countLoopBoos;
    public int limitTiemnangso;
    public int limitKynangso;
    public int limitPhongLoi;
    public int limitBangHoa;
    public int countPB;
    public int[] potential = new int[4];
    public String cName;
    public String cClanName = "";
    public byte ctypeClan;
    public static Clan clan;
    public int cw = 22;
    public int ch = 32;
    private int chw = 11;
    private int chh = 16;
    public boolean canJumpHigh = true;
    private boolean cmtoChar;
    public boolean me;
    public int cf;
    private int tick;
    public boolean isMoto = false;
    public boolean isWolf = false;
    public boolean gameCP;
    private boolean gameHV;
    public int xu;
    public int xuInBox;
    public int yen;
    public int luong;
    public NClass nClass;
    public MyVector vSkill = new MyVector();
    public MyVector vSkillFight = new MyVector();
    public MyVector vEff = new MyVector();
    private MyVector vDomsang = new MyVector();
    public Skill myskill;
    public Task taskMaint;
    private boolean paintName = true;
    public Item[] arrItemBag;
    public Item[] arrItemBox;
    public Item[] arrItemBody;
    public Item[] arrItemMounts = new Item[5];
    public Item[] arrItemViThu = new Item[5];
    public short cResFire;
    public short cResIce;
    public short cResWind;
    public short cMiss;
    public short cExactly;
    public short cFatal;
    public byte cPk;
    public byte cTypePk;
    public short cReactDame;
    public short sysUp;
    public short sysDown;
    public Mob mobFocus;
    public Mob mobMe;
    public Mob mobVithu;
    public Npc npcFocus;
    public Char charFocus;
    public ItemMap itemFocus;
    public MyVector focus = new MyVector();
    public Mob[] attMobs;
    public Char[] attChars;
    public short[] moveFast;
    public int testCharId = -9999;
    public int killCharId = -9999;
    public byte resultTest;
    public int countKill;
    public int countKillMax;
    public int tickCoat;
    private int tickEffmoto;
    private int tickEffFireW;
    public boolean isInvisible;
    public static boolean DungHp;
    public static boolean DungMp;
    public static boolean DungFood;
    public static boolean DungHoTro;
    public static boolean DungPhanThan;
    public static boolean KhienMana;
    public static boolean DotQuai;
    public static boolean NhatYen;
    public static boolean NhatHpMp;
    public static boolean NhatDa;
    public static boolean LuyenDa;
    public static boolean NhatTrangBi;
    public static boolean NhatTbLa;
    public static boolean NhatVpNV;
    public static boolean NhatVpSk;
    public static boolean NhatAll;
    public static boolean NhatSvc;
    public static boolean KhongNhat;
    public static boolean LuyenTTT;
    public static boolean LuyenTTC;
    public static boolean ReMap;
    public static boolean TsMapTrong;
    public static boolean AutoMuaFood;
    public static boolean DieHetMp;
    public static boolean ReConnect;
    public static boolean ChuyenMapHetQuai;
    public static boolean SanTaTl;
    public static boolean DanhQuai;
    public static boolean DanhTA;
    public static boolean DanhTL;
    public static boolean CongTN;
    public static boolean CongKN;
    public static boolean DanhNhom;
    public static boolean NePk;
    public static boolean DungCoLenh;
    public static boolean MuaCoLenh;
    public static boolean gameFR;
    public static boolean gameFS;
    public static int aHpValue;
    public static int aMpValue;
    public static int CapFood;
    public static int CapHpMp;
    public static int CapNhatDa;
    public static int LuyenDaMax;
    public static int CapTrangBi;
    public static int aCID;
    private long lastTimeUseSkill = 0L;
    public MyVector taskOrders = new MyVector();
    public static int pointPB;
    public static int pointChienTruong;
    private long timeSummon;
    public long timeChatReturn;
    public static int[][][] CharInfo;
    private static Char myChar;
    private int gameKD;
    public int cxSend;
    public int cySend;
    public int gameGI;
    public int gameGJ;
    public MyVector vMovePoints = new MyVector();
    public static boolean gameGL;
    public static boolean gameGM;
    public boolean isLockMove;
    public boolean isLockAttack;
    public boolean isBlinking;
    public MovePoint currentMovePoint;
    private int gameKE = 0;
    private boolean isEffBatTu;
    public long lastUseHP = System.currentTimeMillis();
    public int vitaWolf = 0;
    private long timeSendmove;
    private static boolean isSendMove;
    private int gameKI;
    private int gameKJ;
    private int gameKK;
    private long currMove = 0L;
    private boolean isLastMove = false;
    public static byte[] locate;
    private long timeLastCheck;
    private long timelastSendmove;
    private static short delaySendmove;
    public short head;
    public short leg;
    public short body;
    public short wp;
    public short coat = -1;
    public short glove = -1;
    private int indexEff = -1;
    public int indexEffTask = -1;
    private EffectCharPaint eff;
    public EffectCharPaint effTask;
    private int indexSkill;
    private int i0;
    private int i1;
    private int i2;
    private int dx0;
    private int dx1;
    private int dx2;
    private int dy0;
    private int dy1;
    private int dy2;
    private EffectCharPaint eff0 = null;
    private EffectCharPaint eff1 = null;
    private EffectCharPaint eff2 = null;
    public Arrow arr = null;
    public SkillPaint skillPaint;
    public EffectPaint[] effPaints;
    private int sType;
    private byte isInjure;
    private int gameMH = 0;
    private int gameMI = 0;
    private int gameMJ = 0;
    private int gameMK = 0;
    private int gameML = 0;
    private int[] idWolfW = new int[]{1715, 1737, 1714, 1738};
    public static boolean gameHF;
    public short wdx;
    public short wdy;
    public boolean isDirtyPostion;
    public Skill lastNormalSkill;
    public boolean gameHK;
    private int gameMN;
    private int gameMO;
    private int gameMP;
    private int gameMQ;
    private short gameMR = -1;
    public short gameHL;
    public static int speedGame;

    private static void loadData() {
        mFont[] var10000 = new mFont[]{mFont.tahoma_7_white, mFont.tahoma_7_blue1, mFont.tahoma_7b_purple, mFont.tahoma_7b_yellow};
        DungHoTro = true;
        DungPhanThan = true;
        KhienMana = false;
        DotQuai = false;
        NhatYen = true;
        NhatHpMp = true;
        NhatTbLa = false;
        NhatVpSk = true;
        LuyenTTT = false;
        LuyenTTC = false;
        ReMap = true;
        TsMapTrong = true;
        DieHetMp = true;
        ReConnect = true;
        ChuyenMapHetQuai = true;
        SanTaTl = true;
        DanhQuai = true;
        DanhTA = true;
        DanhTL = true;
        DanhNhom = true;
        NePk = false;
        DungCoLenh = false;
        MuaCoLenh = false;
        speedGame = 30;
        aHpValue = 20;
        aMpValue = 20;
        CapFood = 70;
        CapHpMp = 30;
        CapNhatDa = 3;
        LuyenDaMax = 5;
        CapTrangBi = 30;
        CharInfo = new int[][][]{{{0, -10, 32}, {1, -7, 7}, {1, -11, 15}, {1, -9, 45}}, {{0, -10, 33}, {1, -7, 7}, {1, -11, 16}, {1, -9, 46}}, {{1, -10, 33}, {2, -10, 11}, {2, -9, 16}, {1, -12, 49}}, {{1, -10, 32}, {3, -11, 9}, {3, -11, 16}, {1, -13, 47}}, {{1, -10, 34}, {4, -9, 9}, {4, -8, 16}, {1, -12, 47}}, {{1, -10, 34}, {5, -11, 11}, {5, -10, 17}, {1, -13, 49}}, {{1, -10, 33}, {6, -9, 9}, {6, -8, 16}, {1, -12, 47}}, {{0, -9, 36}, {7, -5, 15}, {7, -10, 21}, {1, -8, 49}}, {{4, -13, 26}, new int[3], new int[3], new int[3]}, {{5, -13, 25}, new int[3], new int[3], new int[3]}, {{6, -12, 26}, new int[3], new int[3], new int[3]}, {{7, -13, 25}, new int[3], new int[3], new int[3]}, {{0, -9, 35}, {8, -4, 13}, {8, -14, 27}, {1, -9, 49}}, {{0, -9, 31}, {9, -11, 8}, {10, -10, 17}, new int[3]}, {{2, -7, 33}, {9, -11, 8}, {11, -8, 15}, new int[3]}, {{2, -8, 32}, {9, -11, 8}, {12, -8, 14}, new int[3]}, {{2, -7, 32}, {9, -11, 8}, {13, -12, 15}, new int[3]}, {{0, -11, 31}, {9, -11, 8}, {14, -15, 18}, new int[3]}, {{2, -9, 32}, {9, -11, 8}, {15, -13, 19}, new int[3]}, {{2, -9, 31}, {9, -11, 8}, {16, -7, 22}, new int[3]}, {{2, -9, 32}, {9, -11, 8}, {17, -11, 18}, new int[3]}, {{3, -12, 34}, {8, -4, 13}, {8, -15, 25}, {1, -10, 46}}, {{0, -9, 32}, {8, -4, 9}, {10, -10, 18}, new int[3]}, {{2, -7, 34}, {8, -4, 9}, {11, -8, 16}, new int[3]}, {{2, -8, 33}, {8, -4, 9}, {12, -8, 15}, new int[3]}, {{2, -7, 33}, {8, -4, 9}, {13, -12, 16}, new int[3]}, {{0, -11, 32}, {7, -5, 9}, {14, -15, 19}, new int[3]}, {{2, -9, 33}, {7, -5, 9}, {15, -13, 20}, new int[3]}, {{2, -9, 32}, {7, -5, 9}, {16, -7, 23}, new int[3]}, {{2, -9, 33}, {7, -5, 9}, {17, -11, 19}, new int[3]}};
        isSendMove = true;
        locate = new byte[]{0, 0, 0, -1, -1, -1, -2, -2, -2, -1, -1, -1};
        delaySendmove = 250;
        gameHF = false;
        System.out.println("Load Auto");

        try {
            ByteArrayInputStream var0 = new ByteArrayInputStream(RMS.gameAB("V7Pro"));
            DataInputStream var1 = new DataInputStream(var0);
            DungHp = var1.readBoolean();
            aHpValue = var1.readInt();
            DungMp = var1.readBoolean();
            aMpValue = var1.readInt();
            DungFood = var1.readBoolean();
            CapFood = var1.readInt();
            DungHoTro = var1.readBoolean();
            KhienMana = var1.readBoolean();
            DotQuai = var1.readBoolean();
            DungPhanThan = var1.readBoolean();
            NhatYen = var1.readBoolean();
            NhatHpMp = var1.readBoolean();
            CapHpMp = var1.readInt();
            NhatDa = var1.readBoolean();
            CapNhatDa = var1.readInt();
            LuyenDa = var1.readBoolean();
            LuyenDaMax = var1.readInt();
            NhatTrangBi = var1.readBoolean();
            NhatTbLa = var1.readBoolean();
            CapTrangBi = var1.readInt();
            NhatVpNV = var1.readBoolean();
            NhatVpSk = var1.readBoolean();
            NhatAll = var1.readBoolean();
            NhatSvc = var1.readBoolean();
            KhongNhat = var1.readBoolean();
            ReMap = var1.readBoolean();
            TsMapTrong = var1.readBoolean();
            AutoMuaFood = var1.readBoolean();
            DieHetMp = var1.readBoolean();
            ReConnect = var1.readBoolean();
            ChuyenMapHetQuai = var1.readBoolean();
            NePk = var1.readBoolean();
            SanTaTl = var1.readBoolean();
            DanhQuai = var1.readBoolean();
            DanhTA = var1.readBoolean();
            DanhTL = var1.readBoolean();
            CongTN = var1.readBoolean();
            CongKN = var1.readBoolean();
            DanhNhom = var1.readBoolean();
            speedGame = var1.readInt();
            LuyenTTT = var1.readBoolean();
            LuyenTTC = var1.readBoolean();
            DungCoLenh = var1.readBoolean();
            MuaCoLenh = var1.readBoolean();
            Code.gameCR = var1.readBoolean();
            Code.HoiSinhLuong = var1.readBoolean();

            int varNhat1 = var1.readInt();
            System.out.println("lent: ".concat(String.valueOf(varNhat1)));
            if (Code.nhat.length < varNhat1) {
                Code.nhat = new short[10 * (varNhat1 / 10 + 1)];
            }

            int varNhat2;
            for (varNhat2 = 0; varNhat2 < varNhat1; ++varNhat2) {
                Code.nhat[varNhat2] = var1.readShort();
            }

            int varDell1 = var1.readInt();
            System.out.println("lentDel: ".concat(String.valueOf(varDell1)));
            if (Code.dell.length < varDell1) {
                Code.dell = new short[10 * (varDell1 / 10 + 1)];
            }

            int varDell2;
            for (varDell2 = 0; varDell2 < varDell1; ++varDell2) {
                Code.dell[varDell2] = var1.readShort();
            }
            int varThow1 = var1.readInt();
            System.out.println("lentThow: ".concat(String.valueOf(varThow1)));
            if (Code.thow.length < varThow1) {
                Code.thow = new short[10 * (varThow1 / 10 + 1)];
            }

            int varThow2;
            for (varThow2 = 0; varThow2 < varThow1; ++varThow2) {
                Code.thow[varThow2] = var1.readShort();
            }

            int v1 = var1.readInt();
            for (int v2 = 0; v2 < v1; ++v2) {
                Code.gameBA.addElement(new Integer(var1.readShort()));
                Code.gameBB.addElement(new Integer(var1.readInt()));
            }

            var0.close();
            var1.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public final void gameAA(short[] var1) {
        if (var1 != null) {
            this.gameMR = var1[5];
            if (this.gameMR > 3000) {
                short var10000 = this.gameMR;
                this.gameMR = -1;
            }
        }

    }

    public static void gameAC() {
        System.out.println("Save Auto");
        ByteArrayOutputStream var0 = new ByteArrayOutputStream();
        DataOutputStream var1 = new DataOutputStream(var0);

        try {
            var1.writeBoolean(DungHp);
            var1.writeInt(aHpValue);
            var1.writeBoolean(DungMp);
            var1.writeInt(aMpValue);
            var1.writeBoolean(DungFood);
            var1.writeInt(CapFood);
            var1.writeBoolean(DungHoTro);
            var1.writeBoolean(KhienMana);
            var1.writeBoolean(DotQuai);
            var1.writeBoolean(DungPhanThan);
            var1.writeBoolean(NhatYen);
            var1.writeBoolean(NhatHpMp);
            var1.writeInt(CapHpMp);
            var1.writeBoolean(NhatDa);
            var1.writeInt(CapNhatDa);
            var1.writeBoolean(LuyenDa);
            var1.writeInt(LuyenDaMax);
            var1.writeBoolean(NhatTrangBi);
            var1.writeBoolean(NhatTbLa);
            var1.writeInt(CapTrangBi);
            var1.writeBoolean(NhatVpNV);
            var1.writeBoolean(NhatVpSk);
            var1.writeBoolean(NhatAll);
            var1.writeBoolean(NhatSvc);
            var1.writeBoolean(KhongNhat);
            var1.writeBoolean(ReMap);
            var1.writeBoolean(TsMapTrong);
            var1.writeBoolean(AutoMuaFood);
            var1.writeBoolean(DieHetMp);
            var1.writeBoolean(ReConnect);
            var1.writeBoolean(ChuyenMapHetQuai);
            var1.writeBoolean(NePk);
            var1.writeBoolean(SanTaTl);
            var1.writeBoolean(DanhQuai);
            var1.writeBoolean(DanhTA);
            var1.writeBoolean(DanhTL);
            var1.writeBoolean(CongTN);
            var1.writeBoolean(CongKN);
            var1.writeBoolean(DanhNhom);
            var1.writeInt(speedGame);
            var1.writeBoolean(LuyenTTT);
            var1.writeBoolean(LuyenTTC);
            var1.writeBoolean(DungCoLenh);
            var1.writeBoolean(MuaCoLenh);
            var1.writeBoolean(Code.gameCR);
            var1.writeBoolean(Code.HoiSinhLuong);

            int varNhat1 = 0;
            int varNhat2;
            for (varNhat2 = 0; varNhat2 < Code.nhat.length; ++varNhat2) {
                if (Code.nhat[varNhat2] >= 0) {
                    ++varNhat1;
                }
            }
            System.out.println("lent: ".concat(String.valueOf(varNhat1)));
            var1.writeInt(varNhat1);

            for (varNhat2 = 0; varNhat2 < Code.nhat.length; ++varNhat2) {
                if (Code.nhat[varNhat2] >= 0) {
                    var1.writeShort(Code.nhat[varNhat2]);
                }
            }

            int varDell1 = 0;

            int varDell2;
            for (varDell2 = 0; varDell2 < Code.dell.length; ++varDell2) {
                if (Code.dell[varDell2] >= 0) {
                    ++varDell1;
                }
            }

            System.out.println("lentDel: ".concat(String.valueOf(varDell1)));
            var1.writeInt(varDell1);

            for (varDell2 = 0; varDell2 < Code.dell.length; ++varDell2) {
                if (Code.dell[varDell2] >= 0) {
                    var1.writeShort(Code.dell[varDell2]);
                }
            }

            int varThow1 = 0;
            int varThow2;
            for (varThow2 = 0; varThow2 < Code.thow.length; ++varThow2) {
                if (Code.thow[varThow2] >= 0) {
                    ++varThow1;
                }
            }
            System.out.println("lentThow: ".concat(String.valueOf(varThow1)));
            var1.writeInt(varThow1);
            for (varThow2 = 0; varThow2 < Code.thow.length; ++varThow2) {
                if (Code.thow[varThow2] >= 0) {
                    var1.writeShort(Code.thow[varThow2]);
                }
            }

            var1.writeInt(Code.gameBA.size());
            for (int avar3 = 0; avar3 < Code.gameBA.size(); ++avar3) {
                var1.writeShort(((Integer) Code.gameBA.elementAt(avar3)).intValue());
                var1.writeInt(((Integer) Code.gameBB.elementAt(avar3)).intValue());
            }

            var1.flush();
            var0.flush();
            RMS.gameAA("V7Pro", var0.toByteArray());
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public final int gameAD() {
        return this.myskill != null ? this.myskill.gameAB() : 0;
    }

    public final int gameAE() {
        return this.myskill != null ? this.myskill.gameAC() : 0;
    }

    public Char() {
        short[] var10000 = new short[]{2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        this.statusMe = 6;
    }

    public final int gameAF() {
        if (this.nClass.classId != 1 && this.nClass.classId != 2) {
            if (this.nClass.classId != 3 && this.nClass.classId != 4) {
                return this.nClass.classId != 5 && this.nClass.classId != 6 ? 0 : 3;
            } else {
                return 2;
            }
        } else {
            return 1;
        }
    }

    public final int gameAG() {
        if (Code.gameBG) {
            return Code.gameBH;
        } else {
            return !this.isWolf && !this.isMoto ? this.cspeed : this.cspeed + 2;
        }
    }

    public final boolean gameAH() {
        return this.nClass.classId == 2 || this.nClass.classId == 4 || this.nClass.classId == 6;
    }

    public static Char getMyChar() {
        if (myChar == null) {
            (myChar = new Char()).me = true;
            myChar.cmtoChar = true;
            myChar.timelastSendmove = System.currentTimeMillis();
        }

        return myChar;
    }

    public static void gameAJ() {
        gameFR = false;
        gameFS = false;
        myChar = null;
    }

    public final void gameAA(Message var1) {
        try {
            this.cspeed = var1.gameAB().readByte();
            this.cMaxHP = var1.gameAB().readInt();
            this.cMaxMP = var1.gameAB().readInt();
        } catch (Exception var2) {
            var2.printStackTrace();
            System.out.println("Char.readParam()");
        }
    }

    public final void gameAK() {
        try {
            MyVector var1 = new MyVector();

            int var2;
            Item var3;
            for (var2 = 0; var2 < this.arrItemBag.length; ++var2) {
                if ((var3 = this.arrItemBag[var2]) != null && var3.template.isUpToUp && !var3.isExpires) {
                    var1.addElement(var3);
                }
            }

            int var4;
            for (var2 = 0; var2 < var1.size(); ++var2) {
                if ((var3 = (Item) var1.elementAt(var2)) != null) {
                    for (var4 = var2 + 1; var4 < var1.size(); ++var4) {
                        Item var5;
                        if ((var5 = (Item) var1.elementAt(var4)) != null && var3.template.equals(var5.template) && var3.isLock == var5.isLock) {
                            var3.quantity += var5.quantity;
                            this.arrItemBag[var5.indexUI] = null;
                            var1.setElementAt((Object) null, var4);
                        }
                    }
                }
            }

            for (var2 = 0; var2 < this.arrItemBag.length; ++var2) {
                if (this.arrItemBag[var2] != null) {
                    for (var4 = 0; var4 <= var2; ++var4) {
                        if (this.arrItemBag[var4] == null) {
                            this.arrItemBag[var4] = this.arrItemBag[var2];
                            this.arrItemBag[var4].indexUI = var4;
                            this.arrItemBag[var2] = null;
                            break;
                        }
                    }
                }
            }

        } catch (Exception var6) {
            var6.printStackTrace();
            System.out.println("Char.bagSort()");
        }
    }

    public final void gameAL() {
        try {
            MyVector var1 = new MyVector();

            int var2;
            Item var3;
            for (var2 = 0; var2 < this.arrItemBox.length; ++var2) {
                if ((var3 = this.arrItemBox[var2]) != null && var3.template.isUpToUp && !var3.isExpires) {
                    var1.addElement(var3);
                }
            }

            int var4;
            for (var2 = 0; var2 < var1.size(); ++var2) {
                if ((var3 = (Item) var1.elementAt(var2)) != null) {
                    for (var4 = var2 + 1; var4 < var1.size(); ++var4) {
                        Item var5;
                        if ((var5 = (Item) var1.elementAt(var4)) != null && var3.template.equals(var5.template) && var3.isLock == var5.isLock) {
                            var3.quantity += var5.quantity;
                            this.arrItemBox[var5.indexUI] = null;
                            var1.setElementAt((Object) null, var4);
                        }
                    }
                }
            }

            for (var2 = 0; var2 < this.arrItemBox.length; ++var2) {
                if (this.arrItemBox[var2] != null) {
                    for (var4 = 0; var4 <= var2; ++var4) {
                        if (this.arrItemBox[var4] == null) {
                            this.arrItemBox[var4] = this.arrItemBox[var2];
                            this.arrItemBox[var4].indexUI = var4;
                            this.arrItemBox[var2] = null;
                            break;
                        }
                    }
                }
            }

        } catch (Exception var6) {
            var6.printStackTrace();
            System.out.println("Char.boxSort()");
        }
    }

    public final void gameAA(int var1) {
        Item var2;
        Item var3;
        int var5;
        if ((var2 = this.arrItemBag[var1]).gameAB()) {
            var2.isLock = true;
            var2.typeUI = 5;
            var3 = this.arrItemBody[var2.template.type];
            this.arrItemBag[var1] = null;
            if (var3 != null) {
                var3.typeUI = 3;
                this.arrItemBody[var2.template.type] = null;
                var3.indexUI = var1;
                this.arrItemBag[var1] = var3;
            }

            var2.indexUI = var2.template.type;
            this.arrItemBody[var2.indexUI] = var2;

            for (var5 = 0; var5 < this.arrItemBody.length; ++var5) {
                Item var4;
                if ((var4 = this.arrItemBody[var5]) != null) {
                    if (var4.template.type == 1) {
                        this.wp = var4.template.part;
                    } else if (var4.template.type == 2) {
                        this.body = var4.template.part;
                    } else if (var4.template.type == 6) {
                        this.leg = var4.template.part;
                    }
                }
            }
        } else if (var2.gameAC()) {
            var2.isLock = true;
            var2.typeUI = 41;
            this.arrItemBag[var1] = null;

            for (var5 = 0; var5 < this.arrItemMounts.length; ++var5) {
                int var6;
                if ((var6 = var2.template.type - 29) == var5) {
                    if ((var3 = this.arrItemMounts[var6]) != null) {
                        var3.typeUI = 41;
                        this.arrItemMounts[var6] = null;
                        var3.indexUI = var1;
                        this.arrItemBag[var1] = var3;
                    }

                    var2.indexUI = var2.template.type;
                    this.arrItemMounts[var6] = var2;
                    return;
                }
            }
        }

    }

    public final Skill gameAA(SkillTemplate var1) {
        for (int var2 = 0; var2 < this.vSkill.size(); ++var2) {
            Skill var3;
            if ((var3 = (Skill) this.vSkill.elementAt(var2)).template.equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    private boolean gameAA() {
        int var1 = TileMap.vGo.size();

        for (byte var2 = 0; var2 < var1; ++var2) {
            Waypoint var3 = (Waypoint) TileMap.vGo.elementAt(var2);
            if (this.cx >= var3.minX && this.cx <= var3.maxX && this.cy >= var3.minY && this.cy <= var3.maxY) {
                return true;
            }
        }

        return false;
    }

    public void gameAB() {
        this.gameKI = this.cx;
        this.gameKJ = this.cy;
        int var1;
        int var2;
        if (this.me && this.cHP > 0) {
            int var10000 = this.cx;
            var1 = Res.abs(this.cxSend - this.cx);
            var10000 = this.cy;
            var2 = Res.abs(this.cySend - this.cy);
            if ((var1 > 0 || var2 > 0) && System.currentTimeMillis() - this.timeSendmove >= 250L //&& !Code.gameBG
                    ) {
                isSendMove = true;
            }

            if (isSendMove) {
                isSendMove = false;
                if (!gameGL) {
                    Service.gI().gameAB(this.cx, this.cy);
                }

                this.timeSendmove = System.currentTimeMillis();
                this.cxSend = this.cx;
                this.cySend = this.cy;
            }
        }

        Mob var19;
        if (this.mobMe != null) {
            if (this.mobMe.templateId != 122 && this.mobMe.templateId != 70 && (this.mobMe.getTemplate() == null || this.mobMe.getTemplate().typeFly != 1)) {
                if (this.mobMe.status != 3) {
                    if (this.cdir == -1) {
                        this.mobMe.xFirst = this.cx + 20;
                        this.mobMe.yFirst = this.cy;
                        this.mobMe.dir = this.cdir;
                        this.mobMe.y = this.cy - 20;
                    } else {
                        this.mobMe.xFirst = this.cx - 20;
                        this.mobMe.yFirst = this.cy;
                        this.mobMe.dir = this.cdir;
                        this.mobMe.y = this.cy - 20;
                    }

                    var1 = this.mobMe.xFirst - this.mobMe.x;
                    var2 = this.mobMe.yFirst - this.mobMe.y;
                    if (var1 <= 50 && var1 >= -50) {
                        var19 = this.mobMe;
                        var19.x += var1;
                    } else {
                        var19 = this.mobMe;
                        var19.x += var1 / 10;
                    }

                    if (var2 > 50 || var2 < -50) {
                        var19 = this.mobMe;
                        var19.y += var2 / 10;
                    }
                }

                this.mobMe.gameAA();
            } else {
                if (this.mobMe.status != 3) {
                    this.mobMe.xFirst = this.cx + (3 - GameCanvas.gameTick % 6) * 6;
                    this.mobMe.yFirst = this.cy - 60;
                    var1 = this.mobMe.xFirst - this.mobMe.x;
                    var2 = this.mobMe.yFirst - this.mobMe.y;
                    if (var1 > 50 || var1 < -50) {
                        var19 = this.mobMe;
                        var19.x += var1 / 10;
                    }

                    if (var2 > 50 || var2 < -50) {
                        var19 = this.mobMe;
                        var19.y += var2 / 10;
                    }
                }

                this.mobMe.gameAA();
            }
        }

        if (this.mobVithu != null) {
            if (this.mobVithu.templateId == 122 || this.mobVithu.templateId == 70 || this.mobVithu.getTemplate() != null && this.mobVithu.getTemplate().typeFly == 1) {
                if (this.mobVithu.status != 3) {
                    this.mobVithu.xFirst = this.cx + (3 - GameCanvas.gameTick % 6) * 6;
                    this.mobVithu.yFirst = this.cy - 60;
                    var1 = this.mobVithu.xFirst - this.mobVithu.x;
                    var2 = this.mobVithu.yFirst - this.mobVithu.y;
                    if (var1 > 50 || var1 < -50) {
                        var19 = this.mobVithu;
                        var19.x += var1 / 10;
                    }

                    if (var2 > 50 || var2 < -50) {
                        var19 = this.mobVithu;
                        var19.y += var2 / 10;
                    }
                }

                this.mobVithu.gameAA();
            } else {
                if (this.mobVithu.status != 3) {
                    if (this.cdir == -1) {
                        this.mobVithu.xFirst = this.cx + 20;
                        this.mobVithu.yFirst = this.cy;
                        this.mobVithu.dir = this.cdir;
                        this.mobVithu.y = this.cy - 20;
                    } else {
                        this.mobVithu.xFirst = this.cx - 20;
                        this.mobVithu.yFirst = this.cy;
                        this.mobVithu.dir = this.cdir;
                        this.mobVithu.y = this.cy - 20;
                    }

                    var1 = this.mobVithu.xFirst - this.mobVithu.x;
                    var2 = this.mobVithu.yFirst - this.mobVithu.y;
                    if (var1 <= 50 && var1 >= -50) {
                        var19 = this.mobVithu;
                        var19.x += var1;
                    } else {
                        var19 = this.mobVithu;
                        var19.x += var1 / 10;
                    }

                    if (var2 > 50 || var2 < -50) {
                        var19 = this.mobVithu;
                        var19.y += var2 / 10;
                    }
                }

                this.mobVithu.gameAA();
            }
        }

        this.isEffBatTu = false;
        if (this.resultTest > 0 && GameCanvas.gameTick % 2 == 0) {
            --this.resultTest;
            if (this.resultTest == 30 || this.resultTest == 60) {
                this.resultTest = 0;
            }
        }

        if (this.myskill != null && (this.myskill.template.id == 77 || this.myskill.template.id == 73)) {
            this.gameBJ();
        }

        this.gameBJ();
        if (this.mobMe != null) {
            this.mobMe.gameAA();
        }

        if (this.mobVithu != null) {
            this.mobVithu.gameAA();
        }

        if (this.arr != null) {
            this.arr.gameAA();
        }

        if (this.arrItemMounts[4] != null && this.arrItemMounts[4].options != null) {
            for (var1 = 0; var1 < this.arrItemMounts[4].options.size(); ++var1) {
                ItemOption var7;
                if ((var7 = (ItemOption) this.arrItemMounts[4].options.elementAt(var1)).optionTemplate.id == 66) {
                    this.vitaWolf = var7.param;
                }
            }
        }

        if (this.isWolf && this.vitaWolf < 500) {
            this.isWolf = false;
        }

        DomSang var3;
        DomSang var8;
        if (this.isWolf) {
            if (this.arrItemMounts[4].template.id == 443 && this.arrItemMounts[4].sys >= 2) {
                if (this.idWolfW[1] == 1737) {
                    this.gameMO -= 5;
                }

                if (this.cdir != 1) {
                    var8 = new DomSang(this.gameMN - 4, this.gameMO, 0);
                    var3 = new DomSang(this.gameMN - 1, this.gameMO, 0);
                } else {
                    var8 = new DomSang(this.gameMN + 4, this.gameMO, 0);
                    var3 = new DomSang(this.gameMN + 1, this.gameMO, 0);
                }

                if (this.statusMe != 1 || this.statusMe != 6) {
                    this.vDomsang.addElement(var8);
                    this.vDomsang.addElement(var3);
                }
            }

            for (var1 = 0; var1 < this.vDomsang.size(); ++var1) {
                (var8 = (DomSang) this.vDomsang.elementAt(var1)).gameAA();
                if (var8.frame >= 6) {
                    this.vDomsang.removeElementAt(var1);
                }
            }
        } else if (this.isMoto) {
            if (this.arrItemMounts[4].template.id == 524 && this.arrItemMounts[4].sys >= 2) {
                if (this.cdir != 1) {
                    var8 = new DomSang(this.gameMN, this.gameMO, 1);
                    var3 = new DomSang(this.gameMP, this.gameMQ, 1);
                } else {
                    var8 = new DomSang(this.gameMN, this.gameMO, 1);
                    var3 = new DomSang(this.gameMP, this.gameMQ, 1);
                }

                if ((this.statusMe == 2 || this.statusMe == 10) && GameCanvas.gameTick % 3 == 0) {
                    this.vDomsang.addElement(var8);
                    this.vDomsang.addElement(var3);
                }
            }

            for (var1 = 0; var1 < this.vDomsang.size(); ++var1) {
                (var8 = (DomSang) this.vDomsang.elementAt(var1)).gameAA();
                if (var8.frame >= 6) {
                    this.vDomsang.removeElementAt(var1);
                }
            }
        }

        Item var14;
        if (this.me && DungHp && Code.gameAB == null && this.cHP < this.cMaxHP * aHpValue / 100 && System.currentTimeMillis() - this.lastUseHP > 3000L && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
            if (this.vEff.size() == 0) {
                for (var1 = 0; var1 < this.arrItemBag.length; ++var1) {
                    if ((var14 = this.arrItemBag[var1]) != null && var14.template.type == 16 && var14.template.level <= this.clevel) {
                        GameScr.gameAW();
                        this.lastUseHP = System.currentTimeMillis();
                        break;
                    }
                }
            } else {
                for (var1 = 0; var1 < this.vEff.size() && ((Effect) getMyChar().vEff.elementAt(var1)).template.type != 17; ++var1) {
                    if (var1 == this.vEff.size() - 1) {
                        GameScr.gameAW();
                        this.lastUseHP = System.currentTimeMillis();
                    }
                }
            }
        }

        if (this.me && (DungFood || Code.gameAB instanceof As10) && GameCanvas.gameTick % 10 == 0 && !GameScr.gameDN && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
            int var10 = Code.gameAB instanceof As10 ? (this.ctaskId >= 9 ? 10 : 1) : CapFood;
            if (this.vEff.size() == 0) {
                for (var1 = 0; var1 < this.arrItemBag.length; ++var1) {
                    if ((var14 = this.arrItemBag[var1]) != null && var14.template.type == 18 && var14.template.level == var10) {
                        Service.gI().useItem(var1);
                        break;
                    }
                }
            } else {
                for (var1 = 0; var1 < this.vEff.size() && ((Effect) getMyChar().vEff.elementAt(var1)).template.type != 0; ++var1) {
                    if (var1 == this.vEff.size() - 1) {
                        for (var2 = 0; var2 < this.arrItemBag.length; ++var2) {
                            Item var4;
                            if ((var4 = this.arrItemBag[var2]) != null && var4.template.type == 18 && var4.template.level == var10) {
                                Service.gI().useItem(var2);
                                break;
                            }
                        }
                    }
                }
            }
        }

        int var9;
        Effect var11;
        Skill var16;
        if (this.me && DungHoTro && Code.gameAB == null && !TileMap.gameBE && getMyChar().statusMe != 14 && getMyChar().statusMe != 5 && this.cHP > 0 && System.currentTimeMillis() - this.lastTimeUseSkill > 500L) {
            for (var1 = 0; var1 < this.vSkill.size(); ++var1) {
                boolean var5 = false;
                if (((var16 = (Skill) this.vSkill.elementAt(var1)).template.id < 67 || var16.template.id > 72) && var16 != null && var16.template.type == 2 && !var16.gameAA()) {
                    for (var9 = 0; var9 < this.vEff.size(); ++var9) {
                        if ((var11 = (Effect) this.vEff.elementAt(var9)) != null && var11.template.iconId == var16.template.iconId) {
                            var5 = true;
                            break;
                        }
                    }

                    if (!var5) {
                        GameScr.gI().gameAA(var16, true);
                        Service.gI().gameAR();
                        this.gameAM();
                        this.lastTimeUseSkill = System.currentTimeMillis();
                        break;
                    }
                }
            }
        }

        if (this.me && DungMp && Code.gameAB == null && this.cMP < this.cMaxMP * aMpValue / 100 && GameCanvas.gameTick % 4 == 0 && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
            GameScr.gameAV();
        }

        Char var12;
        if (this.me && gameFR && this.nClass.classId == 6 && aCID > 0 && getMyChar().statusMe != 14 && getMyChar().statusMe != 5 && (var12 = GameScr.gameAE(aCID)) != null && (var12.cHP <= 0 || var12.statusMe == 14 || var12.statusMe == 5 || gameFS)) {
            for (var1 = 0; var1 < this.vSkill.size(); ++var1) {
                if ((var16 = (Skill) getMyChar().vSkill.elementAt(var1)) != null && var16.template.type == 4) {
                    if (Res.abs(this.cx - var12.cx) < var16.gameAB() && Res.abs(this.cy - var12.cy) < var16.gameAC()) {
                        getMyChar().myskill = var16;
                        GameScr.gI().gameAG(aCID);
                        gameFS = false;
                        this.gameAM();
                    } else {
                        InfoMe.gameAA(mResources.gameWH, 20, mFont.tahoma_7_white);
                    }
                    break;
                }
            }
        }

        if (this.cHP > 0) {
            for (var1 = 0; var1 < this.vEff.size(); ++var1) {
                if ((var11 = (Effect) this.vEff.elementAt(var1)).template.type != 0 && var11.template.type != 12) {
                    if (var11.template.type != 4 && var11.template.type != 17) {
                        if (var11.template.type == 13) {
                            if (GameCanvas.gameAW) {
                                this.cHP -= this.cMaxHP * 3 / 100;
                                if (this.cHP <= 0) {
                                    this.cHP = 1;
                                }
                            }
                        } else if (var11.template.type == 7) {
                            this.isEffBatTu = true;
                        }
                    } else if (GameCanvas.gameAW) {
                        this.cHP += var11.param;
                    }
                } else if (GameCanvas.gameAW) {
                    this.cHP += var11.param;
                    this.cMP += var11.param;
                }
            }

            if (this.isEffBatTu) {
                ++this.gameKE;
            } else {
                this.gameKE = 0;
            }

            if (this.eff5BuffHp > 0 && GameCanvas.gameAX) {
                this.cHP += this.eff5BuffHp;
            }

            if (this.eff5BuffMp > 0 && GameCanvas.gameAX) {
                this.cMP += this.eff5BuffMp;
            }

            if (this.cHP > this.cMaxHP) {
                this.cHP = this.cMaxHP;
            }

            if (this.cMP > this.cMaxMP) {
                this.cMP = this.cMaxMP;
            }
        }

        if (this.cmtoChar) {
            GameScr.gameAK = this.cx - GameScr.gameAD + GameScr.gameAH * this.cdir;
            GameScr.gameAL = this.cy - GameScr.gameAE;
        }

        this.tick = (this.tick + 1) % 100;
        if (this.me) {
            if (this.charFocus != null && (this.charFocus.isNhanban || !GameScr.vCharInMap.contains(this.charFocus))) {
                this.charFocus = null;
            }

            if (this.cx < 10) {
                this.cvx = 0;
                this.cx = 10;
            } else if (this.cx > TileMap.pxw - 10) {
                this.cx = TileMap.pxw - 10;
                this.cvx = 0;
            }

            if (!gameGL && this.gameAA()) {
                gameGM = true;
                gameGL = true;
                Service.gI().gameAC();
                GameCanvas.gameAK();
                GameCanvas.gameAJ();
                return;
            }

            if (this.isBlinking) {
                this.isBlinking = System.currentTimeMillis() - this.timeSummon < 2000L;
            }

            if (this.isLockMove) {
                this.currentMovePoint = null;
            }

            if (this.currentMovePoint != null && (this.statusMe == 1 || this.statusMe == 2)) {
                this.statusMe = 2;
                if (this.cx - this.currentMovePoint.xEnd > 0) {
                    this.cdir = -1;
                    if (this.cx - this.currentMovePoint.xEnd <= 10) {
                        this.currentMovePoint = null;
                    }
                } else {
                    this.cdir = 1;
                    if (this.cx - this.currentMovePoint.xEnd >= -10) {
                        this.currentMovePoint = null;
                    }
                }

                if (this.currentMovePoint != null) {
                    this.cvx = this.gameAG() * this.cdir;
                    this.cvy = 0;
                }
            }

            this.gameBW();
            if (this.statusMe != 1 && this.statusMe != 6) {
                this.currMove = System.currentTimeMillis();
                this.isLastMove = true;
            } else if (System.currentTimeMillis() - this.currMove > 500L && this.isLastMove) {
                isSendMove = true;
                this.isLastMove = false;
                this.currMove = System.currentTimeMillis();
            }
        } else {
            if (GameCanvas.gameTick % 20 == 0 && this.charID >= 0) {
                this.paintName = true;

                for (var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
                    Char var13 = null;

                    try {
                        var13 = (Char) GameScr.vCharInMap.elementAt(var1);
                    } catch (Exception var6) {
                    }

                    if (var13 != null && !var13.equals(this) && (var13.cy == this.cy && Res.abs(var13.cx - this.cx) < 35 || this.cy - var13.cy < 32 && this.cy - var13.cy > 0 && Res.abs(var13.cx - this.cx) < 24)) {
                        this.paintName = false;
                    }
                }
            }

            if (this.statusMe == 1 || this.statusMe == 6) {
                boolean var15 = false;
                if (this.currentMovePoint != null) {
                    if (gameAN(this.currentMovePoint.xEnd - this.cx) < 4 && gameAN(this.currentMovePoint.yEnd - this.cy) < 4) {
                        this.cx = this.currentMovePoint.xEnd;
                        this.cy = this.currentMovePoint.yEnd;
                        this.currentMovePoint = null;
                        if ((TileMap.gameAA(this.cx, this.cy) & 2) == 2) {
                            this.gameBY();
                            GameCanvas.gameAB().gameAA(-1, this.cx - -8, this.cy);
                            GameCanvas.gameAB().gameAA(1, this.cx - 8, this.cy);
                        } else {
                            this.statusMe = 4;
                            this.cvy = 0;
                        }

                        var15 = true;
                    } else if (this.cy == this.currentMovePoint.yEnd) {
                        if (this.cx != this.currentMovePoint.xEnd) {
                            this.cx = (this.cx + this.currentMovePoint.xEnd) / 2;
                            this.cf = GameCanvas.gameTick % 5 + 2;
                        }
                    } else if (this.cy < this.currentMovePoint.yEnd) {
                        this.cf = 12;
                        this.cx = (this.cx + this.currentMovePoint.xEnd) / 2;
                        if (this.cvy < 0) {
                            this.cvy = 0;
                        }

                        this.cy += this.cvy;
                        if ((TileMap.gameAA(this.cx, this.cy) & 2) == 2) {
                            GameCanvas.gameAB().gameAA(-1, this.cx - -8, this.cy);
                            GameCanvas.gameAB().gameAA(1, this.cx - 8, this.cy);
                        }

                        ++this.cvy;
                        if (this.cvy > 16) {
                            this.cy = (this.cy + this.currentMovePoint.yEnd) / 2;
                        }
                    } else {
                        this.cf = 7;
                        this.cx = (this.cx + this.currentMovePoint.xEnd) / 2;
                        this.cy = (this.cy + this.currentMovePoint.yEnd) / 2;
                    }
                } else {
                    var15 = true;
                }

                if (var15 && this.vMovePoints.size() > 0) {
                    if (this.vMovePoints.size() > 5) {
                        this.currentMovePoint = (MovePoint) this.vMovePoints.lastElement();
                        this.vMovePoints.removeElementAt(0);
                        this.cx = this.currentMovePoint.xEnd;
                        this.cy = this.currentMovePoint.yEnd;
                        this.vMovePoints.removeAllElements();
                        this.statusMe = 6;
                        this.currentMovePoint = null;
                        return;
                    }

                    this.currentMovePoint = (MovePoint) this.vMovePoints.firstElement();
                    this.vMovePoints.removeElementAt(0);
                    if (this.currentMovePoint.dir == 2) {
                        this.statusMe = 2;
                        if (this.cx - this.currentMovePoint.xEnd > 0) {
                            this.cdir = -1;
                        } else if (this.cx - this.currentMovePoint.xEnd < 0) {
                            this.cdir = 1;
                        }

                        this.cvx = 5 * this.cdir;
                        this.cvy = 0;
                    } else if (this.currentMovePoint.dir == 3) {
                        this.statusMe = 3;
                        GameCanvas.gameAB().gameAA(-1, this.cx - -8, this.cy);
                        GameCanvas.gameAB().gameAA(1, this.cx - 8, this.cy);
                        if (this.cx - this.currentMovePoint.xEnd > 0) {
                            this.cdir = -1;
                        } else if (this.cx - this.currentMovePoint.xEnd < 0) {
                            this.cdir = 1;
                        }

                        this.cvx = gameAN(this.cx - this.currentMovePoint.xEnd) / 9 * this.cdir;
                        this.cvy = -10;
                    } else if (this.currentMovePoint.dir == 4) {
                        this.statusMe = 4;
                        if (this.cx - this.currentMovePoint.xEnd > 0) {
                            this.cdir = -1;
                        } else if (this.cx - this.currentMovePoint.xEnd < 0) {
                            this.cdir = 1;
                        }

                        this.cvx = gameAN(this.cx - this.currentMovePoint.xEnd) / 9 * this.cdir;
                        this.cvy = 0;
                    } else {
                        this.cx = this.currentMovePoint.xEnd;
                        this.cy = this.currentMovePoint.yEnd;
                        this.currentMovePoint = null;
                    }
                }

                if (this.statusMe == 6) {
                    if (this.cf >= 8 && this.cf <= 11) {
                        ++this.cf;
                        ++this.cp1;
                        if (this.cf > 11) {
                            this.cf = 8;
                        }

                        if (this.cp1 > 5) {
                            this.cf = 0;
                        }
                    }

                    if (this.cf <= 1) {
                        ++this.cp1;
                        if (this.cp1 > 6) {
                            this.cf = 0;
                        } else {
                            this.cf = 1;
                        }

                        if (this.cp1 > 10) {
                            this.cp1 = 0;
                        }
                    }
                }

                this.lcx = this.cx;
                this.lcy = this.cy;
                if (System.currentTimeMillis() - this.timeChatReturn > 7000L) {
                    if (!this.isWolf && this.gameAS() && this.vitaWolf >= 500) {
                        this.isWolf = true;
                        ServerEffect.gameAA(60, this, 1);
                    }

                    if (this.isMoto && this.gameAT()) {
                        this.isMoto = false;
                        this.gameCP = true;
                    }
                }
            }
        }

        if (this.isInjure > 0) {
            this.cf = 21;
            --this.isInjure;
        } else {
            switch (this.statusMe) {
                case 1:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            this.gameMN = this.cx + 21 + 4;
                            this.gameMO = this.cy - 15;
                        } else {
                            this.gameMN = this.cx - 24 - 4;
                            this.gameMO = this.cy - 15;
                        }
                    }

                    var12 = this;

                    for (var1 = 0; var1 < var12.vDomsang.size(); ++var1) {
                        (var3 = (DomSang) var12.vDomsang.elementAt(var1)).gameAA();
                        if (var3.frame >= 6) {
                            var12.vDomsang.removeElementAt(var1);
                        }
                    }

                    var12.cvx = 0;
                    var12.cvy = 0;
                    ++var12.cp1;
                    var12.lcx = var12.cx;
                    var12.lcy = var12.cy;
                    if (var12.cp1 > 30) {
                        var12.cp1 = 0;
                    }

                    if (var12.cp1 % 15 < 5) {
                        var12.cf = 0;
                    } else {
                        var12.cf = 1;
                    }

                    var12.gameBX();
                    if (System.currentTimeMillis() - var12.timeChatReturn > 7000L) {
                        if (!var12.isWolf && var12.gameAS() && var12.vitaWolf >= 500) {
                            var12.isWolf = true;
                            ServerEffect.gameAA(60, var12, 1);
                        }

                        if (var12.isMoto && var12.gameAT()) {
                            var12.isMoto = false;
                            var12.gameCP = true;
                        }
                    }
                    break;
                case 2:
                    if (this.isMoto) {
                        ++this.timeBocdau;
                        if (this.arrItemMounts[4].template.id == 485 && this.arrItemMounts[4].sys >= 4) {
                            this.gameHV = true;
                        }

                        if (this.timeBocdau > 20) {
                            this.gameHV = false;
                        }
                    }

                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            if (this.idWolfW[this.gameML] == 1737) {
                                this.gameMN = this.cx + 21 + 4;
                                this.gameMO = this.cy - 19;
                            } else {
                                this.gameMN = this.cx + 21 + 4;
                                this.gameMO = this.cy - 16;
                            }
                        } else if (this.idWolfW[this.gameML] == 1737) {
                            this.gameMN = this.cx - 24 - 4;
                            this.gameMO = this.cy - 19;
                        } else {
                            this.gameMN = this.cx - 24 - 4;
                            this.gameMO = this.cy - 16;
                        }
                    } else if (this.isMoto) {
                        if (this.cdir == 1) {
                            this.gameMN = this.cx + 15;
                            this.gameMP = this.cx - 25;
                            this.gameMO = this.cy;
                            this.gameMQ = this.cy;
                        } else {
                            this.gameMN = this.cx - 18;
                            this.gameMP = this.cx + 25;
                            this.gameMO = this.cy;
                            this.gameMQ = this.cy;
                        }
                    }

                    var1 = 0;
                    if (!this.me && this.currentMovePoint != null) {
                        var1 = gameAN(this.cx - this.currentMovePoint.xEnd);
                    }

                    ++this.cp1;
                    if (this.cp1 >= 10) {
                        this.cp1 = 0;
                    }

                    this.cf = (this.cp1 >> 1) + 2;
                    if ((TileMap.gameAA(this.cx, this.cy - 1) & 64) == 64) {
                        this.cx += this.cvx >> 1;
                    } else {
                        this.cx += this.cvx;
                    }

                    if (this.cdir == 1) {
                        if (GameScr.gameFW != 1) {
                            if (TileMap.gameAA(this.cx + this.chw, this.cy - this.chh, 4)) {
                                if (this.me) {
                                    this.cvx = 0;
                                    this.cx = TileMap.gameAC(this.cx + this.chw) - this.chw;
                                } else {
                                    this.gameBL();
                                }
                            }
                        } else if (TileMap.gameAA(this.cx + this.chw, this.cy - this.chh, 4)) {
                            if (this.me) {
                                this.statusMe = 3;
                                if (this.statusMe == 3) {
                                    this.cvy -= 10;
                                }
                            } else {
                                this.gameBL();
                            }
                        }
                    } else if (GameScr.gameFW != 1) {
                        if (TileMap.gameAA(this.cx - this.chw - 1, this.cy - this.chh, 8)) {
                            if (this.me) {
                                this.cvx = 0;
                                this.cx = TileMap.gameAC(this.cx - this.chw - 1) + TileMap.size + this.chw;
                            } else {
                                this.gameBL();
                            }
                        }
                    } else if (TileMap.gameAA(this.cx - this.chw - 1, this.cy - this.chh, 8)) {
                        if (this.me) {
                            this.statusMe = 3;
                            if (this.statusMe == 3) {
                                this.cvy -= 10;
                            }
                        } else {
                            this.gameBL();
                        }
                    }

                    if (!this.isMoto && this.gameAT()) {
                        this.isMoto = true;
                        this.gameCP = false;
                    }

                    if (!this.isWolf && this.gameAS() && this.vitaWolf >= 500) {
                        this.dx0 = Res.abs(this.cx - this.lcx);
                        this.dy0 = Res.abs(this.cy - this.lcy);
                        this.dx0 = this.dx0 > this.dy0 ? this.dx0 : this.dy0;
                        if (this.me && this.dx0 > 150 || !this.me && this.dx0 > 40) {
                            this.isWolf = true;
                            ServerEffect.gameAA(60, this, 1);
                        }

                        this.dx0 = this.dy0 = 0;
                    }

                    if (this.me) {
                        if (this.cvx > 0) {
                            --this.cvx;
                        } else if (this.cvx < 0) {
                            ++this.cvx;
                        } else {
                            this.gameBY();
                        }
                    }

                    if ((TileMap.gameAA(this.cx, this.cy) & 2) != 2) {
                        if (this.me) {
                            if ((this.cx - this.cxSend != 0 || this.cy - this.cySend != 0) && this.me) {
                                this.cf = 7;
                                this.statusMe = 4;
                                this.cvx = 3 * this.cdir;
                                this.cp2 = 0;
                            }
                        } else {
                            this.gameBL();
                        }
                    }

                    if (!this.me && this.currentMovePoint != null && gameAN(this.cx - this.currentMovePoint.xEnd) > var1) {
                        this.gameBL();
                    }

                    if (this.isMoto) {
                        if (GameCanvas.gameTick % 5 == 0) {
                            ServerEffect.gameAA(120, this.cx - (this.cdir << 5), this.cy, 0, (byte) this.cdir);
                        }
                    } else {
                        GameCanvas.gameAB().gameAA(this.cdir, this.cx - (this.cdir << 3), this.cy);
                    }

                    this.gameBX();
                    var9 = this.cx - (this.cdir << 4);
                    var2 = this.cy;
                    if (this.isWolf && this.arrItemMounts[4].sys >= 4 && this.gameAF() > 0 && GameCanvas.gameTick % 8 == 0) {
                        if (this.gameAF() == 1) {
                            ServerEffect.gameAA(116, var9, var2, 2);
                        } else if (this.gameAF() == 2) {
                            ServerEffect.gameAA(117, var9, var2, 2);
                        } else if (this.gameAF() == 3) {
                            ServerEffect.gameAA(118, var9, var2, 2);
                        }
                    }
                    break;
                case 3:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            this.gameMN = this.cx + 21 + 4;
                            this.gameMO = this.cy - 30;
                        } else {
                            this.gameMN = this.cx - 23 - 4;
                            this.gameMO = this.cy - 30;
                        }
                    }

                    if (GameScr.gameFW == 1) {
                        if (this.cdir == 1) {
                            this.cvx = 5;
                        } else {
                            this.cvx = -5;
                        }
                    }

                    if (this.gameAT()) {
                        this.isMoto = true;
                        this.gameCP = false;
                    }

                    this.cx += this.cvx;
                    this.cy += this.cvy;
                    if (this.cy < 0) {
                        this.cy = 0;
                        this.cvy = -1;
                    }

                    ++this.cvy;
                    if (!this.me && this.currentMovePoint != null) {
                        label1421:
                        {
                            if ((var1 = this.currentMovePoint.xEnd - this.cx) > 0) {
                                if (this.cvx > var1) {
                                    this.cvx = var1;
                                }

                                if (this.cvx >= 0) {
                                    break label1421;
                                }
                            } else if (var1 < 0) {
                                if (this.cvx < var1) {
                                    this.cvx = var1;
                                }

                                if (this.cvx <= 0) {
                                    break label1421;
                                }
                            }

                            this.cvx = var1;
                        }
                    }

                    if (this.cp1 == 0) {
                        this.cf = 7;
                    } else {
                        this.cf = 23;
                    }

                    if (this.canJumpHigh) {
                        if (this.cvy == -3) {
                            this.cf = 8;
                        } else if (this.cvy == -2) {
                            this.cf = 9;
                        } else if (this.cvy == -1) {
                            this.cf = 10;
                        } else if (this.cvy == 0) {
                            this.cf = 11;
                        }
                    }

                    if (this.cdir == 1) {
                        if ((TileMap.gameAA(this.cx + this.chw, this.cy - 1) & 4) == 4 && this.cx <= TileMap.gameAC(this.cx + this.chw) + 12) {
                            this.cx = TileMap.gameAC(this.cx + this.chw) - this.chw;
                            this.cvx = 0;
                        }
                    } else if ((TileMap.gameAA(this.cx - this.chw, this.cy - 1) & 8) == 8 && this.cx >= TileMap.gameAC(this.cx - this.chw) + 12) {
                        this.cx = TileMap.gameAC(this.cx + 24 - this.chw) + this.chw;
                        this.cvx = 0;
                    }

                    if (this.cvy == 0) {
                        if (this.me) {
                            this.gameHQ = this.cy;
                            this.statusMe = 4;
                            this.cp1 = 0;
                            if (this.canJumpHigh) {
                                this.cp2 = 1;
                            } else {
                                this.cp2 = 0;
                            }

                            this.cvy = 1;
                        } else {
                            this.gameBL();
                        }
                    }

                    if (this.me && !gameGL && this.gameAA()) {
                        gameGL = true;
                        gameGM = true;
                        Service.gI().gameAC();
                        GameCanvas.gameAK();
                        GameCanvas.gameAJ();
                    } else {
                        if (this.cp3 < 0) {
                            ++this.cp3;
                        }

                        if (this.cy > this.ch && TileMap.gameAA(this.cx, this.cy - this.ch, 8192)) {
                            if (this.me) {
                                this.statusMe = 4;
                                this.cp1 = 0;
                                this.cp2 = 0;
                                this.cvy = 1;
                            } else {
                                this.gameBL();
                            }
                        }

                        if (!this.me && this.currentMovePoint != null && this.cy < this.currentMovePoint.yEnd) {
                            this.gameBL();
                        }
                    }
                    break;
                case 4:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            this.gameMN = this.cx + 21 + 4;
                            this.gameMO = this.cy - 19;
                        } else {
                            this.gameMN = this.cx - 24;
                            this.gameMO = this.cy - 20;
                        }
                    }

                    this.gameBM();
                    break;
                case 5:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    ++this.cp1;
                    this.cx += (this.cp2 - this.cx) / 4;
                    if (this.cp1 > 7) {
                        this.cy += (this.cp3 - this.cy) / 4;
                    } else {
                        this.cy += this.cp1 - 10;
                    }

                    if (Res.abs(this.cp2 - this.cx) < 4 && Res.abs(this.cp3 - this.cy) < 10) {
                        this.cx = this.cp2;
                        this.cy = this.cp3;
                        this.statusMe = 14;
                        this.gameAO(60);
                        if (this.me) {
                            GameScr.gI().gameAU();
                        }
                    }

                    this.cf = 21;
                    break;
                case 6:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    if (this.cf == 21 && this.isInjure <= 0) {
                        this.cf = 0;
                    }
                case 7:
                case 8:
                default:
                    break;
                case 9:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    this.cx += this.cvx * this.cdir;
                    this.cy += this.gameKD;
                    ++this.gameKD;
                    if (this.cp1 == 0) {
                        this.cf = 7;
                    } else {
                        this.cf = 23;
                    }

                    if (this.canJumpHigh) {
                        if (this.gameKD == -3) {
                            this.cf = 8;
                        } else if (this.gameKD == -2) {
                            this.cf = 9;
                        } else if (this.gameKD == -1) {
                            this.cf = 10;
                        } else if (this.gameKD == 0) {
                            this.cf = 11;
                        }
                    }

                    if (this.gameKD == 0) {
                        this.statusMe = 6;
                        ((MovePoint) this.vMovePoints.firstElement()).dir = 4;
                        this.cp1 = 0;
                        this.cvy = 1;
                    }
                    break;
                case 10:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    if (!TileMap.gameAA(this.cx, this.cy, 64)) {
                        this.statusMe = 4;
                    }

                    ++this.cp1;
                    if (this.cp1 >= 5) {
                        this.cp1 = 0;
                    }

                    this.cf = this.cp1 + 2;
                    if (this.cdir == 1) {
                        if (TileMap.gameAA(this.cx + this.chw, this.cy - 1, 4)) {
                            this.cvx = 0;
                            this.cx = TileMap.gameAC(this.cx + this.chw) - this.chw;
                        }
                    } else if (TileMap.gameAA(this.cx - this.chw - 1, this.cy - 1, 8)) {
                        this.cvx = 0;
                        this.cx = TileMap.gameAC(this.cx - this.chw - 1) + TileMap.size + this.chw;
                    }

                    this.cx += this.cvx;
                    if (this.cvx > 0) {
                        --this.cvx;
                    } else if (this.cvx < 0) {
                        ++this.cvx;
                    } else if (this.cx - this.cxSend != 0) {
                        if (this.me && System.currentTimeMillis() - (this.timelastSendmove + (long) delaySendmove) >= 0L) {
                            isSendMove = true;
                        }

                        this.statusMe = 11;
                    }

                    GameCanvas.gameAB();
                    GameCanvas.gameAD(this.cx, this.cy);
                    GameCanvas.gameAB().gameAA(this.cdir, this.cx - (this.cdir << 3), this.cy);
                    break;
                case 11:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    this.gameBN();
                    break;
                case 12:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    this.gameBK();
                    break;
                case 13:
                    this.gameHV = false;
                    this.timeBocdau = 0;
                    break;
                case 14:
                    this.gameHV = false;
                    this.timeBocdau = 0;
            }
        }

        if (this.wdx != 0 || this.wdy != 0) {
            short var17 = this.wdy;
            short var18 = this.wdx;
            if (this.me) {
                gameGM = true;

                for (var2 = 0; var2 < GameScr.vCharInMap.size(); ++var2) {
                    ((Char) GameScr.vCharInMap.elementAt(var2)).killCharId = -9999;
                }
            }

            this.statusMe = 5;
            this.cp2 = var18;
            this.cp3 = var17;
            this.cp1 = 0;
            this.cHP = 0;
            this.testCharId = -9999;
            this.killCharId = -9999;
            this.wdx = 0;
            this.wdy = 0;
        }

        if (this.moveFast != null) {
            if (this.moveFast[0] == 0) {
                ++this.moveFast[0];
                ServerEffect.gameAA(60, this, 1);
            } else if (this.moveFast[0] < 10) {
                ++this.moveFast[0];
            } else {
                this.cx = this.moveFast[1];
                this.cy = this.moveFast[2];
                this.moveFast = null;
                ServerEffect.gameAA(60, this, 1);
                if (this.me) {
                    if ((TileMap.gameAA(this.cx, this.cy) & 2) != 2) {
                        this.statusMe = 4;
                        getMyChar().gameAB(GameScr.sks[38], 1);
                    } else {
                        getMyChar().gameAB(GameScr.sks[38], 0);
                    }
                }
            }
        }

        if (!this.me && this.vMovePoints.size() == 0 && this.gameGI != 0 && this.gameGJ != 0 && this.currentMovePoint == null) {
            if (this.gameGI != this.cx) {
                this.cx = this.gameGI;
            }

            if (this.gameGJ != this.cy) {
                this.cy = this.gameGJ;
            }

            if (this.cHP > 0) {
                this.statusMe = 6;
            }
        }

        ++this.tickEffWolf;
        if (this.tickEffWolf > 5) {
            this.tickEffWolf = 0;
        }

        this.gameBI();
        super.gameAA((byte) 0, this.statusMe);
    }

    private void gameBI() {
        if (!this.me) {
            if (this.cf == 12 && this.gameKI == this.cx && this.gameKJ == this.cy) {
                ++this.gameKK;
            } else if (this.cf == 0 && (TileMap.gameAA(this.cx, this.cy) & 2) != 2) {
                ++this.gameKK;
            } else {
                this.gameKK = 0;
            }

            if (this.gameKK > 1) {
                for (int var1 = this.cy; var1 < this.cy + 150; var1 += 24) {
                    if ((TileMap.gameAA(this.cx, var1) & 2) != 2) {
                        if ((var1 = TileMap.gameAB(var1) + 24) - this.cy > 24) {
                            this.cy += (var1 - this.cy) / 2;
                            if (!this.isMoto && !this.isWolf) {
                                this.cf = 12;
                            }

                            this.vMovePoints.removeAllElements();
                            this.currentMovePoint = null;
                        } else {
                            this.statusMe = 1;
                            this.vMovePoints.removeAllElements();
                            this.currentMovePoint = null;
                            this.cvx = 0;
                            this.cvy = 0;
                            this.cp1 = 0;
                            this.cp2 = 0;
                            this.cp3 = 0;
                            this.gameKK = 0;
                            this.gameGI = 0;
                            this.gameGJ = 0;
                            this.cy = var1;
                        }

                        this.lcy = this.cy;
                        return;
                    }
                }
            }
        }

    }

    private void gameBJ() {
        if (this.statusMe != 14 && this.statusMe != 5) {
            if (this.skillPaint != null && this.mobFocus != null && this.mobFocus.status == 0) {
                if (!this.me) {
                    if ((TileMap.gameAA(this.cx, this.cy) & 2) == 2) {
                        this.gameBY();
                    } else {
                        this.statusMe = 6;
                    }
                }

                this.indexSkill = 0;
                this.skillPaint = null;
                this.eff0 = this.eff1 = this.eff2 = null;
                this.i0 = this.i1 = this.i2 = 0;
                this.mobFocus = null;
                this.effPaints = null;
                this.arr = null;
            }

            if (this.skillPaint != null && this.arr == null && this.indexSkill >= this.gameBO().length) {
                if (!this.me) {
                    if ((TileMap.gameAA(this.cx, this.cy) & 2) == 2) {
                        this.gameBY();
                    } else {
                        this.statusMe = 6;
                    }
                }

                this.indexSkill = 0;
                this.skillPaint = null;
                this.eff0 = this.eff1 = this.eff2 = null;
                this.i0 = this.i1 = this.i2 = 0;
                this.arr = null;
            }

            SkillInfoPaint[] var1;
            if ((var1 = this.gameBO()) != null) {
                if (this.me && this.myskill.template.type == 2) {
                    if (this.indexSkill == var1.length - var1.length / 3) {
                        Service.gI().gameAR();
                        this.gameAM();
                        return;
                    }
                } else if ((this.mobFocus != null || !this.me && this.charFocus != null || this.me && this.charFocus != null && gameAB(this.charFocus)) && this.arr == null && this.indexSkill == var1.length - var1.length / 3) {
                    this.gameAR();
                    if (this.me) {
                        this.gameAM();
                    }
                }
            }
        }

    }

    public final void gameAM() {
        if (System.currentTimeMillis() - this.timeLastCheck > 500L) {
            if (this.lastNormalSkill != null && this.myskill.template.type != 1 && this.lastNormalSkill != null) {
                this.myskill = this.lastNormalSkill;
                Service.gI().gameAG(this.myskill.template.id);
            }

            if (this.gameHK) {
                if (this.lastNormalSkill != null) {
                    this.myskill = this.lastNormalSkill;
                    Service.gI().gameAG(this.myskill.template.id);
                }
            } else if (GameScr.gameFW != 1) {
                this.lastNormalSkill = this.myskill;
            }

            this.timeLastCheck = System.currentTimeMillis();
        }

    }

    private void gameBK() {
        ++this.cp1;
        if (this.cdir == 1) {
            if ((TileMap.gameAA(this.cx + this.chw, this.cy - this.chh) & 4) == 4) {
                this.cvx = 0;
            }
        } else if ((TileMap.gameAA(this.cx - this.chw, this.cy - this.chh) & 8) == 8) {
            this.cvx = 0;
        }

        if (this.cy > this.ch && TileMap.gameAA(this.cx, this.cy - this.ch, 8192)) {
            if (!TileMap.gameAA(this.cx, this.cy, 2)) {
                this.statusMe = 4;
                this.cp1 = 0;
                this.cp2 = 0;
                this.cvy = 1;
            } else {
                this.cy = TileMap.gameAB(this.cy);
            }
        }

        this.cx += this.cvx;
        this.cy += this.cvy;
        if (this.cy < 0) {
            this.cy = this.cvy = 0;
        }

        if (this.cvy == 0) {
            if ((TileMap.gameAA(this.cx, this.cy) & 2) != 2) {
                this.statusMe = 4;
                this.cvx = (this.gameAG() >> 1) * this.cdir;
                this.cp1 = this.cp2 = 0;
            }
        } else if (this.cvy < 0) {
            ++this.cvy;
            if (this.cvy == 0) {
                this.cvy = 1;
            }
        } else {
            if (this.cvy < 20 && this.cp1 % 5 == 0) {
                ++this.cvy;
            }

            if (this.cvy > 3) {
                this.cvy = 3;
            }

            if ((TileMap.gameAA(this.cx, this.cy + 3) & 2) == 2 && this.cy <= TileMap.gameAC(this.cy + 3)) {
                this.cvx = this.cvy = 0;
                this.cy = TileMap.gameAC(this.cy + 3);
            }

            if (TileMap.gameAA(this.cx, this.cy, 64) && this.cy % TileMap.size > 8) {
                this.statusMe = 10;
                this.cvx = this.cdir << 1;
                this.cvy >>= 2;
                this.cy = TileMap.gameAB(this.cy) + 12;
                this.statusMe = 11;
                return;
            }

            if (TileMap.gameAA(this.cx, this.cy, 2048)) {
                this.statusMe = 11;
                return;
            }
        }

        if (this.cvx > 0) {
            --this.cvx;
        } else {
            if (this.cvx < 0) {
                ++this.cvx;
            }

        }
    }

    private void gameBL() {
        this.statusMe = 6;
        this.cvx = 0;
        this.cvy = 0;
        this.cp1 = this.cp2 = 0;
    }

    private static int gameAN(int var0) {
        return var0 > 0 ? var0 : -var0;
    }

    private void gameBM() {
        if (this.cy + 4 >= TileMap.pxh) {
            this.gameBY();
            this.cvx = this.cvy = 0;
        } else {
            if (this.cy % 24 == 0 && (TileMap.gameAA(this.cx, this.cy) & 2) == 2) {
                if (this.me) {
                    this.cvx = this.cvy = 0;
                    this.cp1 = this.cp2 = 0;
                    this.gameBY();
                    return;
                }

                this.gameBL();
                this.cf = 0;
                GameCanvas.gameAB().gameAA(-1, this.cx - -8, this.cy);
                GameCanvas.gameAB().gameAA(1, this.cx - 8, this.cy);
            }

            this.cf = 12;
            this.cx += this.cvx;
            if (!this.me && this.currentMovePoint != null) {
                label106:
                {
                    int var1;
                    if ((var1 = this.currentMovePoint.xEnd - this.cx) > 0) {
                        if (this.cvx > var1) {
                            this.cvx = var1;
                        }

                        if (this.cvx >= 0) {
                            break label106;
                        }
                    } else if (var1 < 0) {
                        if (this.cvx < var1) {
                            this.cvx = var1;
                        }

                        if (this.cvx <= 0) {
                            break label106;
                        }
                    }

                    this.cvx = var1;
                }
            }

            this.cy += this.cvy;
            if (this.cvy < 20) {
                ++this.cvy;
            }

            if (this.cdir == 1) {
                if ((TileMap.gameAA(this.cx + this.chw, this.cy - 1) & 4) == 4 && this.cx <= TileMap.gameAC(this.cx + this.chw) + 12) {
                    this.cx = TileMap.gameAC(this.cx + this.chw) - this.chw;
                    this.cvx = 0;
                }
            } else if ((TileMap.gameAA(this.cx - this.chw, this.cy - 1) & 8) == 8 && this.cx >= TileMap.gameAC(this.cx - this.chw) + 12) {
                this.cx = TileMap.gameAC(this.cx + 24 - this.chw) + this.chw;
                this.cvx = 0;
            }

            if (this.cvy > 4 && (this.gameHQ == 0 || this.gameHQ <= TileMap.gameAB(this.cy + 3)) && (TileMap.gameAA(this.cx, this.cy + 3) & 2) == 2) {
                if (this.me) {
                    this.gameHQ = 0;
                    this.cvx = this.cvy = 0;
                    this.cp1 = this.cp2 = 0;
                    this.cy = TileMap.gameAC(this.cy + 3);
                    this.gameBY();
                    GameCanvas.gameAB().gameAA(-1, this.cx - -8, this.cy);
                    GameCanvas.gameAB().gameAA(1, this.cx - 8, this.cy);
                } else {
                    this.gameBL();
                    this.cy = TileMap.gameAC(this.cy + 3);
                    this.cf = 0;
                    GameCanvas.gameAB().gameAA(-1, this.cx - -8, this.cy);
                    GameCanvas.gameAB().gameAA(1, this.cx - 8, this.cy);
                }
            } else {
                if (this.cp2 == 1) {
                    if (this.cvy == 3) {
                        this.cf = 11;
                    } else if (this.cvy == 2) {
                        this.cf = 8;
                    } else if (this.cvy == 1) {
                        this.cf = 9;
                    } else if (this.cvy == 0) {
                        this.cf = 10;
                    }
                } else {
                    this.cf = 12;
                }

                if (this.cvy > 6 && TileMap.gameAA(this.cx, this.cy, 64) && this.cy % TileMap.size > 8) {
                    this.cy = TileMap.gameAB(this.cy) + 8;
                    this.statusMe = 10;
                    this.cvx = this.cdir << 1;
                    this.cvy >>= 2;
                    this.cy = TileMap.gameAB(this.cy) + 12;
                }

                if (!this.me) {
                    if ((TileMap.gameAA(this.cx, this.cy + 1) & 2) == 2) {
                        this.cf = 0;
                    }

                    if (this.currentMovePoint != null && this.cy > this.currentMovePoint.yEnd) {
                        this.gameBL();
                    }
                }

            }
        }
    }

    private void gameBN() {
        this.cy += this.cvy;
        if (this.cvy < 20 && GameCanvas.gameTick % 2 == 0) {
            ++this.cvy;
        }

        this.cf = 7;
        if (this.cy >= TileMap.pxh) {
            this.cHP = 0;
            this.statusMe = 5;
        } else if (TileMap.gameAA(this.cx, this.cy, 2)) {
            this.gameBY();
            this.cvx = this.cvy = 0;
            this.cp1 = this.cp2 = 0;
            this.cy = TileMap.gameAC(this.cy);
        } else {
            if (TileMap.gameAA(this.cx, this.cy, 2048)) {
                this.cHP = 0;
                this.statusMe = 5;
            }

        }
    }

    public final void setDefaultPart() {
        this.wp = 15;
        this.gameAP();
        this.gameAQ();
    }

    public final void gameAO() {
        this.wp = 15;
    }

    public static Part gameAB(int var0) {
        try {
            return var0 == 0 ? GameScr.parts[27] : GameScr.parts[2];
        } catch (Exception var1) {
            return null;
        }
    }

    public final void gameAP() {
        if (this.cgender == 0) {
            this.body = 10;
        } else {
            this.body = 1;
        }
    }

    public final void gameAQ() {
        if (this.cgender == 0) {
            this.leg = 9;
        } else {
            this.leg = 0;
        }
    }

    public final void gameAA(SkillPaint var1, int var2) {
        long var3 = System.currentTimeMillis();
        if (this.me) {
            if (var3 - this.myskill.lastTimeUseThisSkill < (long) this.myskill.coolDown) {
                this.myskill.paintCanNotUseSkill = true;
                return;
            }

            this.myskill.lastTimeUseThisSkill = var3;
            this.cMP -= this.myskill.manaUse;
            if (this.cMP < 0) {
                this.cMP = 0;
            }
        }

        this.gameAB(var1, var2);
    }

    public final void gameAB(SkillPaint var1, int var2) {
        this.skillPaint = var1;
        this.sType = var2;
        this.indexSkill = 0;
        this.i0 = this.i1 = this.i2 = this.dx0 = this.dx1 = this.dx2 = this.dy0 = this.dy1 = this.dy2 = 0;
        this.eff0 = null;
        this.eff1 = null;
        this.eff2 = null;
    }

    private SkillInfoPaint[] gameBO() {
        if (this.skillPaint == null) {
            return null;
        } else {
            return this.sType == 0 ? this.skillPaint.skillStand : this.skillPaint.skillfly;
        }
    }

    public final void gameAR() {
        try {
            int var1;
            MyVector var2;
            int var4;
            EPosition var11;
            if (this.me) {
                if (this.myskill.template.type == 2) {
                    return;
                }

                if (this.myskill.template.id == 42 && !this.myskill.gameAA()) {
                    this.isBlinking = true;
                    this.timeSummon = System.currentTimeMillis();
                }

                if (this.skillPaint != null && (this.mobFocus != null || this.charFocus != null && gameAB(this.charFocus))) {
                    if (Code.gameAB != null) {
                        Auto.gameAA(this.skillPaint);
                        return;
                    }

                    var1 = this.myskill.gameAB();
                    var4 = this.myskill.gameAC();
                    var2 = new MyVector();
                    MyVector var5 = new MyVector();
                    int var3;
                    Mob var6;
                    Char var10;
                    if (this.charFocus != null) {
                        var5.addElement(this.charFocus);

                        for (var3 = 0; var3 < GameScr.vCharInMap.size() && var2.size() + var5.size() < this.myskill.gameAD(); ++var3) {
                            if ((var10 = (Char) GameScr.vCharInMap.elementAt(var3)).statusMe != 14 && var10.statusMe != 5 && var10.statusMe != 15 && !var10.isInvisible && !var10.equals(this.charFocus) && gameAB(var10) && this.charFocus.cx - var1 <= var10.cx && var10.cx <= this.charFocus.cx + var1 && this.charFocus.cy - var4 <= var10.cy && var10.cy <= this.charFocus.cy + var4 && (this.cdir == -1 && var10.cx <= this.cx || this.cdir == 1 && var10.cx >= this.cx)) {
                                var5.addElement(var10);
                            }
                        }

                        for (var3 = 0; var3 < GameScr.vMob.size() && var2.size() + var5.size() < this.myskill.gameAD(); ++var3) {
                            if ((var6 = (Mob) GameScr.vMob.elementAt(var3)).status != 1 && var6.status != 0 && this.charFocus.cx - var1 <= var6.x && var6.x <= this.charFocus.cx + var1 && this.charFocus.cy - var4 <= var6.y && var6.y <= this.charFocus.cy + var4 && (this.cdir == -1 && var6.x <= this.cx || this.cdir == 1 && var6.x >= this.cx)) {
                                var2.addElement(var6);
                            }
                        }
                    } else if (this.mobFocus != null && this.mobFocus.status != 1 && this.mobFocus.status != 0) {
                        var2.addElement(this.mobFocus);

                        for (var3 = 0; var3 < GameScr.vMob.size() && var2.size() + var5.size() < this.myskill.gameAD(); ++var3) {
                            if ((var6 = (Mob) GameScr.vMob.elementAt(var3)).status != 1 && var6.status != 0 && !var6.equals(this.mobFocus) && this.mobFocus.x - 100 <= var6.x && var6.x <= this.mobFocus.x + 100 && this.mobFocus.y - 50 <= var6.y && var6.y <= this.mobFocus.y + 50) {
                                var2.addElement(var6);
                            }
                        }

                        for (var3 = 0; var3 < GameScr.vCharInMap.size() && var2.size() + var5.size() < this.myskill.gameAD(); ++var3) {
                            if ((var10 = (Char) GameScr.vCharInMap.elementAt(var3)).statusMe != 14 && var10.statusMe != 5 && var10.statusMe != 15 && !var10.isInvisible && (this.cTypePk == 4 && var10.cTypePk == 5 || this.cTypePk == 5 && var10.cTypePk == 4 || var10.cTypePk == 3 || this.cTypePk == 3 || var10.cTypePk == 1 && this.cTypePk == 1 || this.testCharId >= 0 && this.testCharId == var10.charID || this.killCharId >= 0 && this.killCharId == var10.charID) && this.mobFocus.x - var1 <= var10.cx && var10.cx <= this.mobFocus.x + var1 && this.mobFocus.y - var4 <= var10.cy && var10.cy <= this.mobFocus.y + var4 && (this.cdir == -1 && var10.cx <= this.cx || this.cdir == 1 && var10.cx >= this.cx)) {
                                var5.addElement(var10);
                            }
                        }
                    }

                    this.effPaints = new EffectPaint[var2.size() + var5.size()];

                    for (var3 = 0; var3 < var2.size(); ++var3) {
                        this.effPaints[var3] = new EffectPaint();
                        this.effPaints[var3].effCharPaint = GameScr.efs[this.skillPaint.id - 1];
                        this.effPaints[var3].eMob = (Mob) var2.elementAt(var3);
                    }

                    for (var3 = 0; var3 < var5.size(); ++var3) {
                        this.effPaints[var3 + var2.size()] = new EffectPaint();
                        this.effPaints[var3 + var2.size()].effCharPaint = GameScr.efs[this.skillPaint.id - 1];
                        this.effPaints[var3 + var2.size()].eChar = (Char) var5.elementAt(var3);
                    }

                    if (this.effPaints.length > 1) {
                        var11 = new EPosition();
                        if (this.effPaints[0].eMob != null) {
                            var11 = new EPosition(this.effPaints[0].eMob.x, this.effPaints[0].eMob.y);
                        } else if (this.effPaints[0].eChar != null) {
                            var11 = new EPosition(this.effPaints[0].eChar.cx, this.effPaints[0].eChar.cy);
                        }

                        MyVector var8 = new MyVector();

                        for (var1 = 1; var1 < this.effPaints.length; ++var1) {
                            if (this.effPaints[var1].eMob != null) {
                                var8.addElement(new EPosition(this.effPaints[var1].eMob.x, this.effPaints[var1].eMob.y));
                            } else if (this.effPaints[var1].eChar != null) {
                                var8.addElement(new EPosition(this.effPaints[var1].eChar.cx, this.effPaints[var1].eChar.cy));
                            }

                            if (var1 > 5) {
                                break;
                            }
                        }

                        Lightning.gameAA(var8, var11, true, this.gameAW());
                    }

                    byte var9 = 0;
                    if (this.mobFocus != null) {
                        var9 = 1;
                    } else if (this.charFocus != null) {
                        var9 = 2;
                    }

                    if (this.me) {
                        Service.gI().gameAA((MyVector) var2, (MyVector) var5, (int) var9);
                        return;
                    }

                    return;
                }
            } else if (this.skillPaint != null && (this.mobFocus != null || this.charFocus != null)) {
                label469:
                {
                    if (this.attMobs != null && this.attChars != null) {
                        this.effPaints = new EffectPaint[this.attMobs.length + this.attChars.length];

                        for (var1 = 0; var1 < this.attMobs.length; ++var1) {
                            this.effPaints[var1] = new EffectPaint();
                            this.effPaints[var1].effCharPaint = GameScr.efs[this.skillPaint.id - 1];
                            this.effPaints[var1].eMob = this.attMobs[var1];
                        }

                        for (var1 = 0; var1 < this.attChars.length; ++var1) {
                            this.effPaints[var1 + this.attMobs.length] = new EffectPaint();
                            this.effPaints[var1 + this.attMobs.length].effCharPaint = GameScr.efs[this.skillPaint.id - 1];
                            this.effPaints[var1 + this.attMobs.length].eChar = this.attChars[var1];
                        }

                        this.attMobs = null;
                    } else {
                        if (this.attMobs != null) {
                            this.effPaints = new EffectPaint[this.attMobs.length];

                            for (var1 = 0; var1 < this.attMobs.length; ++var1) {
                                this.effPaints[var1] = new EffectPaint();
                                this.effPaints[var1].effCharPaint = GameScr.efs[this.skillPaint.id - 1];
                                this.effPaints[var1].eMob = this.attMobs[var1];
                            }

                            this.attMobs = null;
                            break label469;
                        }

                        if (this.attChars == null) {
                            break label469;
                        }

                        this.effPaints = new EffectPaint[this.attChars.length];

                        for (var1 = 0; var1 < this.attChars.length; ++var1) {
                            this.effPaints[var1] = new EffectPaint();
                            this.effPaints[var1].effCharPaint = GameScr.efs[this.skillPaint.id - 1];
                            this.effPaints[var1].eChar = this.attChars[var1];
                        }
                    }

                    this.attChars = null;
                }

                if (this.effPaints.length > 1 && this.effPaints[0] != null) {
                    var11 = new EPosition();
                    if (this.effPaints[0].eMob != null) {
                        var11 = new EPosition(this.effPaints[0].eMob.x, this.effPaints[0].eMob.y);
                    } else if (this.effPaints[0].eChar != null) {
                        var11 = new EPosition(this.effPaints[0].eChar.cx, this.effPaints[0].eChar.cy);
                    }

                    var2 = new MyVector();

                    for (var4 = 1; var4 < this.effPaints.length; ++var4) {
                        if (this.effPaints[var4].eMob != null) {
                            var2.addElement(new EPosition(this.effPaints[var4].eMob.x, this.effPaints[var4].eMob.y));
                        } else if (this.effPaints[var4].eChar != null) {
                            var2.addElement(new EPosition(this.effPaints[var4].eChar.cx, this.effPaints[var4].eChar.cy));
                        }

                        if (var4 > 5) {
                            break;
                        }
                    }

                    Lightning.gameAA(var2, var11, true, this.gameAW());
                    return;
                }
            }

        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    public final boolean gameAS() {
        return this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && (this.arrItemMounts[4].template.id == 443 || this.arrItemMounts[4].template.id == 523);
    }

    public final boolean gameAT() {
        return this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && (this.arrItemMounts[4].template.id == 485 || this.arrItemMounts[4].template.id == 524);
    }

    public final boolean gameAU() {
        return this.cx >= GameScr.cmx && this.cx <= GameScr.cmx + GameScr.gW && this.cy >= GameScr.cmy && this.cy <= GameScr.cmy + GameScr.gH + 30;
    }

    public void gameAA(mGraphics var1) {
        if (!this.gameAU()) {
            if (this.skillPaint != null) {
                this.indexSkill = this.gameBO().length;
                this.skillPaint = null;
                this.effPaints = null;
                this.eff = null;
                this.effTask = null;
                this.indexEff = -1;
                this.indexEffTask = -1;
                return;
            }
        } else {
            this.gameAB(var1, this.cx, this.cy);
            if (this.statusMe != 15 && (this.moveFast == null || this.moveFast[0] <= 0)) {
                this.gameAC(var1);
                Char var2;
                if (this.skillPaint != null && this.indexSkill < this.gameBO().length) {
                    mGraphics var3 = var1;
                    var2 = this;

                    try {
                        SkillInfoPaint[] var4 = var2.gameBO();
                        var2.cf = var4[var2.indexSkill].status;
                        if (var4[var2.indexSkill].effS0Id != 0) {
                            var2.eff0 = GameScr.efs[var4[var2.indexSkill].effS0Id - 1];
                            var2.i0 = var2.dx0 = var2.dy0 = 0;
                        }

                        if (var4[var2.indexSkill].effS1Id != 0) {
                            var2.eff1 = GameScr.efs[var4[var2.indexSkill].effS1Id - 1];
                            var2.i1 = var2.dx1 = var2.dy1 = 0;
                        }

                        if (var4[var2.indexSkill].effS2Id != 0) {
                            var2.eff2 = GameScr.efs[var4[var2.indexSkill].effS2Id - 1];
                            var2.i2 = var2.dx2 = var2.dy2 = 0;
                        }

                        if (var4 != null && var4[var2.indexSkill] != null && var4[var2.indexSkill].arrowId != 0) {
                            var2.arr = new Arrow(var2, GameScr.gameAU[var4[var2.indexSkill].arrowId - 1]);
                            var2.arr.gameAA = 10;
                            var2.arr.gameAB = var2.cx + var4[var2.indexSkill].adx;
                            var2.arr.gameAC = var2.cy + var4[var2.indexSkill].ady;
                        }

                        var2.gameAD(var3);
                        if (var2.cdir == 1) {
                            if (var2.eff0 != null) {
                                if (var2.dx0 == 0) {
                                    var2.dx0 = var4[var2.indexSkill].e0dx;
                                }

                                if (var2.dy0 == 0) {
                                    var2.dy0 = var4[var2.indexSkill].e0dy;
                                }

                                SmallImage.gameAB(var3, var2.eff0.arrEfInfo[var2.i0].idImg, var2.cx + var2.dx0 + var2.eff0.arrEfInfo[var2.i0].dx, var2.cy + var2.dy0 + var2.eff0.arrEfInfo[var2.i0].dy, 0, 3);
                                ++var2.i0;
                                if (var2.i0 >= var2.eff0.arrEfInfo.length) {
                                    var2.eff0 = null;
                                    var2.i0 = var2.dx0 = var2.dy0 = 0;
                                }
                            }

                            if (var2.eff1 != null) {
                                if (var2.dx1 == 0) {
                                    var2.dx1 = var4[var2.indexSkill].e1dx;
                                }

                                if (var2.dy1 == 0) {
                                    var2.dy1 = var4[var2.indexSkill].e1dy;
                                }

                                SmallImage.gameAB(var3, var2.eff1.arrEfInfo[var2.i1].idImg, var2.cx + var2.dx1 + var2.eff1.arrEfInfo[var2.i1].dx, var2.cy + var2.dy1 + var2.eff1.arrEfInfo[var2.i1].dy, 0, 3);
                                ++var2.i1;
                                if (var2.i1 >= var2.eff1.arrEfInfo.length) {
                                    var2.eff1 = null;
                                    var2.i1 = var2.dx1 = var2.dy1 = 0;
                                }
                            }

                            if (var2.eff2 != null) {
                                if (var2.dx2 == 0) {
                                    var2.dx2 = var4[var2.indexSkill].e2dx;
                                }

                                if (var2.dy2 == 0) {
                                    var2.dy2 = var4[var2.indexSkill].e2dy;
                                }

                                SmallImage.gameAB(var3, var2.eff2.arrEfInfo[var2.i2].idImg, var2.cx + var2.dx2 + var2.eff2.arrEfInfo[var2.i2].dx, var2.cy + var2.dy2 + var2.eff2.arrEfInfo[var2.i2].dy, 0, 3);
                                ++var2.i2;
                                if (var2.eff2.arrEfInfo != null && var2.i2 >= var2.eff2.arrEfInfo.length) {
                                    var2.eff2 = null;
                                    var2.i2 = var2.dx2 = var2.dy2 = 0;
                                }
                            }
                        } else {
                            if (var2.eff0 != null) {
                                if (var2.dx0 == 0) {
                                    var2.dx0 = var4[var2.indexSkill].e0dx;
                                }

                                if (var2.dy0 == 0) {
                                    var2.dy0 = var4[var2.indexSkill].e0dy;
                                }

                                SmallImage.gameAB(var3, var2.eff0.arrEfInfo[var2.i0].idImg, var2.cx - var2.dx0 - var2.eff0.arrEfInfo[var2.i0].dx, var2.cy + var2.dy0 + var2.eff0.arrEfInfo[var2.i0].dy, 2, 3);
                                ++var2.i0;
                                if (var2.i0 >= var2.eff0.arrEfInfo.length) {
                                    var2.eff0 = null;
                                    var2.i0 = 0;
                                    var2.dx0 = 0;
                                    var2.dy0 = 0;
                                }
                            }

                            if (var2.eff1 != null) {
                                if (var2.dx1 == 0) {
                                    var2.dx1 = var4[var2.indexSkill].e1dx;
                                }

                                if (var2.dy1 == 0) {
                                    var2.dy1 = var4[var2.indexSkill].e1dy;
                                }

                                SmallImage.gameAB(var3, var2.eff1.arrEfInfo[var2.i1].idImg, var2.cx - var2.dx1 - var2.eff1.arrEfInfo[var2.i1].dx, var2.cy + var2.dy1 + var2.eff1.arrEfInfo[var2.i1].dy, 2, 3);
                                ++var2.i1;
                                if (var2.i1 >= var2.eff1.arrEfInfo.length) {
                                    var2.eff1 = null;
                                    var2.i1 = 0;
                                    var2.dx1 = 0;
                                    var2.dy1 = 0;
                                }
                            }

                            if (var2.eff2 != null) {
                                if (var2.dx2 == 0) {
                                    var2.dx2 = var4[var2.indexSkill].e2dx;
                                }

                                if (var2.dy2 == 0) {
                                    var2.dy2 = var4[var2.indexSkill].e2dy;
                                }

                                SmallImage.gameAB(var3, var2.eff2.arrEfInfo[var2.i2].idImg, var2.cx - var2.dx2 - var2.eff2.arrEfInfo[var2.i2].dx, var2.cy + var2.dy2 + var2.eff2.arrEfInfo[var2.i2].dy, 2, 3);
                                ++var2.i2;
                                if (var2.eff2.arrEfInfo != null && var2.i2 >= var2.eff2.arrEfInfo.length) {
                                    var2.eff2 = null;
                                    var2.i2 = 0;
                                    var2.dx2 = 0;
                                    var2.dy2 = 0;
                                }
                            }
                        }

                        ++var2.indexSkill;
                    } catch (Exception var6) {
                        System.out.println("loi paint charskill");
                    }
                } else {
                    this.gameAD(var1);
                }

                if (this.arr != null) {
                    this.arr.gameAA(var1);
                }

                int var8;
                if (this.effPaints != null) {
                    try {
                        for (var8 = 0; var8 < this.effPaints.length; ++var8) {
                            if (this.effPaints[var8] != null) {
                                if (this.effPaints[var8].eMob != null) {
                                    if (!this.effPaints[var8].isFly) {
                                        this.effPaints[var8].eMob.gameAB();
                                        this.effPaints[var8].eMob.gameBC = this;
                                        if (this.me) {
                                            getMyChar();
                                            gameAD(11);
                                        }

                                        if (this.effPaints[var8].eMob.templateId != 98 && this.effPaints[var8].eMob.templateId != 99) {
                                            GameScr.gameAA(this.effPaints[var8].eMob.x, this.effPaints[var8].eMob.y - (this.effPaints[var8].eMob.gameAL >> 1), this.cdir);
                                        }

                                        this.effPaints[var8].isFly = true;
                                    }

                                    SmallImage.gameAB(var1, this.effPaints[var8].gameAA(), this.effPaints[var8].eMob.x, this.effPaints[var8].eMob.y, 0, 33);
                                } else if (this.effPaints[var8].eChar != null) {
                                    if (!this.effPaints[var8].isFly) {
                                        if (this.effPaints[var8].eChar.charID >= 0) {
                                            (var2 = this.effPaints[var8].eChar).isInjure = 4;
                                            var2.gameAO(49);
                                        }

                                        GameScr.gameAA(this.effPaints[var8].eChar.cx, this.effPaints[var8].eChar.cy - (this.effPaints[var8].eChar.ch >> 1), this.cdir);
                                        this.effPaints[var8].isFly = true;
                                    }

                                    SmallImage.gameAB(var1, this.effPaints[var8].gameAA(), this.effPaints[var8].eChar.cx, this.effPaints[var8].eChar.cy, 0, 33);
                                }

                                if (++this.effPaints[var8].index >= this.effPaints[var8].effCharPaint.arrEfInfo.length) {
                                    this.effPaints[var8] = null;
                                }
                            }
                        }
                    } catch (Exception var7) {
                    }
                }

                if (this.indexEff >= 0 && this.eff != null) {
                    SmallImage.gameAB(var1, this.eff.arrEfInfo[this.indexEff].idImg, this.cx + this.eff.arrEfInfo[this.indexEff].dx, this.cy + this.eff.arrEfInfo[this.indexEff].dy, 0, 3);
                    if (GameCanvas.gameTick % 2 == 0) {
                        ++this.indexEff;
                        if (this.indexEff >= this.eff.arrEfInfo.length) {
                            this.indexEff = -1;
                            this.eff = null;
                        }
                    }
                }

                if (this.indexEffTask >= 0 && this.effTask != null) {
                    SmallImage.gameAB(var1, this.effTask.arrEfInfo[this.indexEffTask].idImg, this.cx + this.effTask.arrEfInfo[this.indexEffTask].dx, this.cy + this.effTask.arrEfInfo[this.indexEffTask].dy, 0, 3);
                    if (GameCanvas.gameTick % 2 == 0) {
                        ++this.indexEffTask;
                        if (this.indexEffTask >= this.effTask.arrEfInfo.length) {
                            this.indexEffTask = -1;
                            this.effTask = null;
                        }
                    }
                }

                if (this.isEffBatTu) {
                    if (this.gameKE < 2) {
                        SmallImage.gameAB(var1, 1366, this.cx, this.cy - this.chh, 0, 3);
                    } else if (this.gameKE < 4) {
                        SmallImage.gameAB(var1, 1367, this.cx, this.cy - this.chh, 0, 3);
                    } else if (this.gameKE < 8) {
                        SmallImage.gameAB(var1, 1368, this.cx, this.cy - this.chh, 0, 3);
                    } else if (GameCanvas.gameTick % 2 == 0) {
                        SmallImage.gameAB(var1, 1369, this.cx, this.cy - this.chh, 0, 3);
                    } else {
                        SmallImage.gameAB(var1, 1370, this.cx, this.cy - this.chh, 0, 3);
                    }
                }

                try {
                    if (this.mobMe != null) {
                        this.mobMe.gameAA(var1);
                    }

                    if (this.mobVithu != null) {
                        this.mobVithu.gameAA(var1);
                    }
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

                if (this.statusMe != 1 && this.statusMe != 6) {
                    for (var8 = 0; var8 < this.vDomsang.size(); ++var8) {
                        ((DomSang) this.vDomsang.elementAt(var8)).gameAA(var1);
                    }
                }

                this.gameAA(var1, this.cx, this.cy);
            }
        }

    }

    public final void gameAC(mGraphics var1, int var2, int var3) {
        int var4 = this.cHP * 26 / this.cMaxHP;
        if (this.statusMe != 5 && this.statusMe != 14 && var4 < 2) {
            var4 = 2;
        } else if (this.statusMe == 5 || this.statusMe == 14) {
            var4 = 0;
        }

        if (var4 > 26) {
            var4 = 0;
        }

        var1.gameAA(16777215);
        var1.gameAD(var2, var3, 26, 4);
        var1.gameAA(this.gameAW());
        var1.gameAD(var2, var3, var4, 4);
        var1.gameAA(0);
        var1.gameAC(var2, var3, 26, 4);
    }

    private int[] gameBP() {
        int[] var1 = null;
        if (this.isMoto && this.arrItemMounts[4].template.id == 485 && this.arrItemMounts[4].sys >= 3) {
            var1 = new int[]{2094, 2095, 2096};
        }

        return var1;
    }

    private int[] gameBQ() {
        int[] var1 = null;
        if (this.isMoto) {
            var1 = new int[]{2082, 2083, 2084, 2089};
        }

        return var1;
    }

    private int[] gameBR() {
        int[] var1 = null;
        if (this.isWolf) {
            var1 = new int[]{2085, 2086, 2087, 2088};
        }

        return var1;
    }

    public final int[] gameAV() {
        int[] var1 = null;
        short var2 = -1;
        if (this.me) {
            if (this.arrItemBody[12] != null) {
                var2 = this.arrItemBody[12].template.id;
            }
        } else {
            var2 = this.coat;
        }

        if (var2 == -1) {
            return null;
        } else {
            if (var2 == 420) {
                if (!this.isWolf && !this.isMoto) {
                    var1 = new int[]{1635, 1636, 1637, 1636};
                } else {
                    var1 = new int[]{2029, 2030, 2031, 2030};
                }
            } else if (var2 == 421) {
                if (!this.isWolf && !this.isMoto) {
                    var1 = new int[]{1652, 1653, 1654, 1653};
                } else {
                    var1 = new int[]{2035, 2036, 2037, 2036};
                }
            } else if (var2 == 422) {
                if (!this.isWolf && !this.isMoto) {
                    var1 = new int[]{1655, 1656, 1657, 1656};
                } else {
                    var1 = new int[]{2032, 2033, 2034, 2033};
                }
            }

            return var1;
        }
    }

    public final int gameAW() {
        int var1 = 9145227;
        if (this.nClass.classId != 1 && this.nClass.classId != 2) {
            if (this.nClass.classId != 3 && this.nClass.classId != 4) {
                if (this.nClass.classId == 5 || this.nClass.classId == 6) {
                    var1 = 7443811;
                }
            } else {
                var1 = 33023;
            }
        } else {
            var1 = 16711680;
        }

        return var1;
    }

    public final void gameAB(mGraphics var1) {
        if (this.gameAU()) {
            if (getMyChar().charFocus == null || !getMyChar().charFocus.equals(this)) {
                mFont.tahoma_7_yellow.gameAA(var1, this.cName, this.cx, this.cy - this.ch - mFont.tahoma_7_green.gameAC() - 5, 2, mFont.tahoma_7_grey);
                return;
            }

            if (getMyChar().charFocus != null && getMyChar().charFocus.equals(this)) {
                mFont.tahoma_7_yellow.gameAA(var1, this.cName, this.cx, this.cy - this.ch - mFont.tahoma_7_green.gameAC() - 10, 2, mFont.tahoma_7_grey);
            }
        }

    }

    public final void gameAC(mGraphics var1) {
        int var2 = this.ch + 5 + (!this.isWolf && !this.isMoto ? 0 : 15);
        if (!this.isInvisible || this.me) {
            boolean var3;
            label125:
            {
                var3 = false;
                if (this.me) {
                    GameScr.gI();
                    if (GameScr.gameFW != 1) {
                        if (this.npcFocus == null && this.charFocus == null && this.mobFocus == null && this.itemFocus == null) {
                            var3 = true;
                            var2 += mFont.tahoma_7.gameAC();
                            if (!this.isHuman) {
                                mFont.tahoma_7_blue1.gameAA(var1, this.cName, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                            } else {
                                mFont.tahoma_7_white.gameAA(var1, this.cName, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                            }

                            ++var2;
                        }
                        break label125;
                    }

                    if (!GameScr.gI().gameFX) {
                        var2 += mFont.tahoma_7.gameAC();
                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameBR, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                    } else {
                        var2 += mFont.tahoma_7.gameAC();
                        mFont.tahoma_7_yellow.gameAA(var1, mResources.gameBS, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                    }
                } else {
                    if (getMyChar().charFocus != null && getMyChar().charFocus.equals(this)) {
                        var3 = true;
                        var2 += 5;
                        this.gameAC(var1, this.cx - 13, this.cy - var2);
                        var2 += mFont.tahoma_7.gameAC();
                        if (!this.isHuman) {
                            mFont.tahoma_7_blue1.gameAA(var1, this.cName, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                        } else {
                            mFont.tahoma_7_white.gameAA(var1, this.cName, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                        }

                        ++var2;
                        break label125;
                    }

                    if (!this.paintName) {
                        break label125;
                    }

                    var3 = true;
                    var2 += mFont.tahoma_7.gameAC();
                    if (!this.isHuman) {
                        mFont.tahoma_7_blue1.gameAA(var1, this.cName, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                    } else {
                        mFont.tahoma_7_white.gameAA(var1, this.cName, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                    }
                }

                ++var2;
            }

            if (this.charID == -getMyChar().charID) {
                var2 += mFont.tahoma_7.gameAC();
                mFont.tahoma_7_yellow.gameAA(var1, mResources.gameBT + " " + getMyChar().cName + " " + mResources.gameEE, this.cx, this.cy - var2, 2, mFont.tahoma_7_grey);
                ++var2;
            }

            if (!this.cClanName.equals("") && var3) {
                var2 += mFont.tahoma_7.gameAC() - 1;
                byte var4 = 0;
                if (this.ctypeClan > 0) {
                    var4 = 5;
                }

                mFont.tahoma_7_white.gameAA(var1, this.cClanName, this.cx + var4, this.cy - var2, 2, mFont.tahoma_7_blue);
                if (this.ctypeClan == 3) {
                    SmallImage.gameAB(var1, 1215, this.cx - (mFont.tahoma_7_white.gameAA(this.cClanName) / 2 + (7 - var4)), this.cy - var2 + 1, 0, 17);
                } else if (this.ctypeClan == 4) {
                    SmallImage.gameAB(var1, 1216, this.cx - (mFont.tahoma_7_white.gameAA(this.cClanName) / 2 + (7 - var4)), this.cy - var2 + 1, 0, 17);
                } else if (this.ctypeClan == 2) {
                    SmallImage.gameAB(var1, 1217, this.cx - (mFont.tahoma_7_white.gameAA(this.cClanName) / 2 + (7 - var4)), this.cy - var2 + 1, 0, 17);
                }

                ++var2;
            }

            if (this.resultTest > 0 && this.resultTest < 30) {
                var2 += SmallImage.smallImg[1117][4];
                SmallImage.gameAB(var1, 1117, this.cx, this.cy - var2, 0, 17);
                return;
            }

            if (this.resultTest > 30 && this.resultTest < 60) {
                var2 += SmallImage.smallImg[1117][4];
                SmallImage.gameAB(var1, 1126, this.cx, this.cy - var2, 0, 17);
                return;
            }

            if (this.resultTest > 60 && this.resultTest < 90) {
                var2 += SmallImage.smallImg[1117][4];
                SmallImage.gameAB(var1, 1118, this.cx, this.cy - var2, 0, 17);
                return;
            }

            if (this.charID >= 0) {
                if (this.killCharId >= 0) {
                    var2 += SmallImage.smallImg[1122][4];
                    SmallImage.gameAB(var1, 1122, this.cx, this.cy - var2, 0, 17);
                    return;
                }

                if (this.cTypePk == 3) {
                    var2 += SmallImage.smallImg[1121][4];
                    SmallImage.gameAB(var1, 1121, this.cx, this.cy - var2, 0, 17);
                    return;
                }

                if (this.cTypePk == 2) {
                    var2 += SmallImage.smallImg[1124][4];
                    SmallImage.gameAB(var1, 1124, this.cx, this.cy - var2, 0, 17);
                    return;
                }

                if (this.cTypePk == 1) {
                    var2 += SmallImage.smallImg[1123][4];
                    SmallImage.gameAB(var1, 1123, this.cx, this.cy - var2, 0, 17);
                    return;
                }

                if (this.cTypePk == 4) {
                    var2 += SmallImage.smallImg[1240][4];
                    SmallImage.gameAB(var1, 1240, this.cx, this.cy - var2, 0, 17);
                    return;
                }

                if (this.cTypePk == 5) {
                    var2 += SmallImage.smallImg[1241][4];
                    SmallImage.gameAB(var1, 1241, this.cx, this.cy - var2, 0, 17);
                    return;
                }

                if (this.testCharId > 0) {
                    var2 += SmallImage.smallImg[1116][4];
                    SmallImage.gameAB(var1, 1116, this.cx, this.cy - var2, 0, 17);
                }
            }
        }

    }

    private void gameAD(mGraphics var1) {
        try {
            Part var2 = GameScr.parts[this.head];
            Part var3 = GameScr.parts[this.leg];
            Part var4 = GameScr.parts[this.body];
            Part var5 = GameScr.parts[this.wp];
            if (this.arrItemBody != null && this.arrItemBody[11] != null) {
                var2 = GameScr.parts[this.arrItemBody[11].template.part];
                this.head = this.arrItemBody[11].template.part;
            }

            int var6;
            if (var2.pi != null && var2.pi.length >= 8) {
                for (var6 = 0; var6 < var2.pi.length; ++var6) {
                    if (var2.pi[var6] == null || !SmallImage.gameAA(var2.pi[var6].id)) {
                        var2 = gameAB(this.cgender);
                        break;
                    }
                }
            } else {
                var2 = gameAB(this.cgender);
            }

            int[] var7 = var2.pi[CharInfo[this.cf][0][0]].id <= 4 ? null : (var2.pi[CharInfo[this.cf][0][0]].id <= 4 ? null : this.gameAV());
            if (((this.statusMe == 1 || this.statusMe == 6) && GameCanvas.gameTick % 10 == 0 || (this.statusMe == 2 || this.statusMe == 10) && GameCanvas.gameTick % 2 == 0 || GameCanvas.gameTick % 3 == 0 && (this.statusMe == 4 || this.statusMe == 3)) && var7 != null) {
                ++this.tickCoat;
                if (this.tickCoat >= var7.length) {
                    this.tickCoat = 0;
                }
            }

            if (this.statusMe == 14) {
                if (this.gameAT()) {
                    if (this.arrItemMounts[4].template.id == 485) {
                        if (this.arrItemMounts[4].sys < 2) {
                            SmallImage.gameAB(var1, 1800, this.lcx, this.lcy, 2, 33);
                        } else {
                            SmallImage.gameAB(var1, 2063, this.lcx, this.lcy, 2, 33);
                        }
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        if (this.arrItemMounts[4].sys < 2) {
                            SmallImage.gameAB(var1, 2064, this.lcx, this.lcy, 2, 33);
                        } else {
                            SmallImage.gameAB(var1, 2068, this.lcx, this.lcy, 2, 33);
                        }
                    }
                }

                SmallImage.gameAB(var1, 1040, this.cx, this.cy, 0, 33);
            } else if (this.isInvisible) {
                if (this.me) {
                    if (GameCanvas.gameTick % 50 != 48 && GameCanvas.gameTick % 50 != 90) {
                        SmallImage.gameAB(var1, 1195, this.cx, this.cy - 18, 0, 3);
                    } else {
                        SmallImage.gameAB(var1, 1196, this.cx, this.cy - 18, 0, 3);
                    }
                }
            } else {
                var6 = 0;
                int var8 = 0;
                int var9 = 0;
                byte var10 = 0;
                int[] var11;
                if ((var11 = this.gameBP()) != null) {
                    ++this.tickEffmoto;
                    if (this.tickEffmoto >= var11.length) {
                        this.tickEffmoto = 0;
                    }
                }

                if (this.isMoto) {
                    if (this.arrItemMounts[4].template.id == 485) {
                        if (this.arrItemMounts[4].sys < 2) {
                            if (this.statusMe != 1 && this.statusMe != 6) {
                                if (this.statusMe == 2 || this.statusMe == 10) {
                                    var6 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                }
                            } else {
                                var6 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                            }

                            if (this.statusMe == 3) {
                                var9 = -5 * this.cdir;
                            }

                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 1711, this.cx, this.cy + 2, 0, 33);
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 1709 : 1710, this.cx, this.cy, 0, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 0, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 0, 33);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 1711, this.cx, this.cy + 2, 2, 33);
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 1709 : 1710, this.cx, this.cy, 2, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 2, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 2, 33);
                            }
                        } else {
                            if (this.statusMe != 1 && this.statusMe != 6) {
                                if (this.statusMe == 2 || this.statusMe == 10) {
                                    var6 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                }
                            } else {
                                var6 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                            }

                            if (this.statusMe == 3) {
                                var9 = -5 * this.cdir;
                            }

                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2057, this.cx, this.cy + 2, 0, 33);
                                } else if (!this.gameHV) {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2056 : 2055, this.cx, this.cy, 0, 33);
                                } else {
                                    SmallImage.gameAB(var1, 2057, this.cx, this.cy, 0, 33);
                                }

                                if (this.statusMe == 2 && var11 != null) {
                                    SmallImage.gameAB(var1, var11[this.tickEffmoto], this.cx - 25, this.cy - 2, 0, 33);
                                }

                                if (!this.gameHV) {
                                    SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 0, 17);
                                    SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 0, 33);
                                } else {
                                    SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir - 3, this.cy - 1 - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 0, 17);
                                    SmallImage.gameAB(var1, this.gameBT(), this.cx - 3 + this.gameMJ * this.cdir, this.cy - 1 - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 0, 33);
                                }
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2057, this.cx, this.cy + 2, 2, 33);
                                } else if (!this.gameHV) {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2056 : 2055, this.cx, this.cy, 2, 33);
                                } else {
                                    SmallImage.gameAB(var1, 2057, this.cx, this.cy, 2, 33);
                                }

                                if (this.statusMe == 2 && var11 != null) {
                                    SmallImage.gameAB(var1, var11[this.tickEffmoto], this.cx + 25, this.cy - 2, 2, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 2, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 2, 33);
                            }
                        }
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        if (this.arrItemMounts[4].sys < 2) {
                            if (this.statusMe != 1 && this.statusMe != 6) {
                                if (this.statusMe == 2 || this.statusMe == 10) {
                                    var6 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                }
                            } else {
                                var6 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                            }

                            if (this.statusMe == 3) {
                                var9 = -5 * this.cdir;
                            }

                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2066, this.cx, this.cy + 2, 0, 33);
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2064 : 2065, this.cx, this.cy, 0, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 0, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 0, 33);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2066, this.cx, this.cy + 2, 2, 33);
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2064 : 2065, this.cx, this.cy, 2, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 2, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 2, 33);
                            }
                        } else if (this.arrItemMounts[4].sys >= 2 && this.arrItemMounts[4].sys < 4) {
                            if ((var7 = this.gameBQ()) != null) {
                                ++this.tickEffmoto;
                                if (this.tickEffmoto >= var7.length) {
                                    this.tickEffmoto = 0;
                                }
                            }

                            if (this.statusMe != 1 && this.statusMe != 6) {
                                if (this.statusMe == 2 || this.statusMe == 10) {
                                    var6 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                }
                            } else {
                                var6 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                            }

                            if (this.statusMe == 3) {
                                var9 = -5 * this.cdir;
                            }

                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2070, this.cx, this.cy + 2, 0, 33);
                                } else if (this.statusMe == 4) {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                } else if (this.statusMe != 2 && this.statusMe != 10) {
                                    if (this.statusMe == 1 || this.statusMe == 6) {
                                        SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                    }
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 0, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 0, 33);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2070, this.cx, this.cy + 2, 2, 33);
                                }

                                if (this.statusMe == 4) {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                } else if (this.statusMe != 2 && this.statusMe != 10) {
                                    if (this.statusMe == 1 || this.statusMe == 6) {
                                        SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                    }
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 2, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 2, 33);
                            }
                        } else {
                            if ((var7 = this.gameBQ()) != null) {
                                ++this.tickEffmoto;
                                if (this.tickEffmoto >= var7.length) {
                                    this.tickEffmoto = 0;
                                }
                            }

                            if (this.statusMe != 1 && this.statusMe != 6) {
                                if (this.statusMe == 2 || this.statusMe == 10) {
                                    var6 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                }
                            } else {
                                var6 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                            }

                            if (this.statusMe == 3) {
                                var9 = -5 * this.cdir;
                            }

                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2070, this.cx, this.cy + 2, 0, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 13, this.cy - 17, 0, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 24, this.cy + 2, 0, 33);
                                } else if (this.statusMe == 4) {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 15, this.cy, 0, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 27, this.cy, 0, 33);
                                } else if (this.statusMe != 2 && this.statusMe != 10) {
                                    if (this.statusMe == 1 || this.statusMe == 6) {
                                        SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                        SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 15, this.cy, 0, 33);
                                        SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 27, this.cy, 0, 33);
                                    }
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 15, this.cy, 0, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 27, this.cy, 0, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 0, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 0, 33);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2070, this.cx, this.cy + 2, 2, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 12, this.cy - 17, 2, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 25, this.cy + 3, 2, 33);
                                }

                                if (this.statusMe == 4) {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 15, this.cy, 2, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 27, this.cy, 2, 33);
                                } else if (this.statusMe != 2 && this.statusMe != 10) {
                                    if (this.statusMe == 1 || this.statusMe == 6) {
                                        SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                        SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 15, this.cy, 2, 33);
                                        SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 27, this.cy, 2, 33);
                                    }
                                } else {
                                    SmallImage.gameAB(var1, var6 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx - 15, this.cy, 2, 33);
                                    SmallImage.gameAB(var1, var7[this.tickEffmoto], this.cx + 27, this.cy, 2, 33);
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 + var6 + this.gameMI, 2, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 8 + var6 + this.gameMK, 2, 33);
                            }
                        }
                    }
                } else if (this.isWolf) {
                    if ((var7 = this.gameBR()) != null) {
                        ++this.tickEffFireW;
                        if (this.tickEffFireW >= var7.length) {
                            this.tickEffFireW = 0;
                        }
                    }

                    if (this.statusMe != 1 && this.statusMe != 6) {
                        if (this.statusMe == 2 || this.statusMe == 10) {
                            if (GameCanvas.gameTick % 12 <= 3) {
                                this.gameML = 0;
                            } else if (GameCanvas.gameTick % 12 <= 6) {
                                this.gameML = 1;
                                var8 = 2;
                            } else if (GameCanvas.gameTick % 12 <= 9) {
                                this.gameML = 2;
                                var8 = 4;
                            } else {
                                this.gameML = 3;
                                var8 = 2;
                            }
                        }
                    } else {
                        this.gameML = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                        var8 = -this.gameML;
                    }

                    var7 = new int[]{2050, 2053, 2049, 2052};
                    int[] var13 = new int[]{2075, 2078, 2074, 2079};
                    int[] var15 = new int[]{this.cy - 22, this.cy - 23, this.cy - 22, this.cy - 23};
                    int[] var17 = new int[]{this.cy - 22, this.cy - 23, this.cy - 22, this.cy - 22};
                    if (this.statusMe == 3) {
                        var9 = -5 * this.cdir;
                        var10 = 5;
                    } else {
                        var9 = -3 * this.cdir;
                    }

                    mGraphics var14;
                    int var10000;
                    int var16;
                    if (this.arrItemMounts[4].template.id == 523) {
                        if (this.cdir == 1) {
                            label690:
                            {
                                SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx + CharInfo[this.cf][3][1] + var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy - 10, 0, 0);
                                if (this.statusMe == 3) {
                                    var14 = var1;
                                    var10000 = 2051;
                                } else if (this.statusMe == 4) {
                                    var14 = var1;
                                    var10000 = 2052;
                                } else {
                                    if (this.statusMe != 1 && this.statusMe != 6) {
                                        if (this.statusMe == 2 || this.statusMe == 10) {
                                            SmallImage.gameAB(var1, var7[this.gameML], this.cx, this.cy - var8, 0, 33);
                                        }
                                        break label690;
                                    }

                                    var14 = var1;
                                    var10000 = this.gameML == 0 ? 2047 : 2048;
                                }

                                var16 = var10000;
                                SmallImage.gameAB(var14, var16, this.cx, this.cy, 0, 33);
                            }

                            SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 - var10 - var8 + this.gameMI, 0, 17);
                            SmallImage.gameAB(var1, this.gameBT(), this.cx + var9 + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 9 - var10 - var8 + this.gameMK, 0, 33);
                        } else {
                            label679:
                            {
                                SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx - CharInfo[this.cf][3][1] - var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy - 10, 2, 24);
                                if (this.statusMe == 3) {
                                    var14 = var1;
                                    var10000 = 2051;
                                } else if (this.statusMe == 4) {
                                    var14 = var1;
                                    var10000 = 2052;
                                } else {
                                    if (this.statusMe != 1 && this.statusMe != 6) {
                                        if (this.statusMe == 2 || this.statusMe == 10) {
                                            SmallImage.gameAB(var1, var7[this.gameML], this.cx, this.cy - var8, 2, 33);
                                        }
                                        break label679;
                                    }

                                    var14 = var1;
                                    var10000 = this.gameML == 0 ? 2047 : 2048;
                                }

                                var16 = var10000;
                                SmallImage.gameAB(var14, var16, this.cx, this.cy, 2, 33);
                            }

                            SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 - var10 - var8 + this.gameMI, 2, 17);
                            SmallImage.gameAB(var1, this.gameBT(), this.cx + var9 + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 9 - var10 - var8 + this.gameMK, 2, 33);
                        }
                    } else if (this.arrItemMounts[4].template.id == 443) {
                        if (this.arrItemMounts[4].sys >= 3) {
                            if (this.cdir == 1) {
                                SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx + CharInfo[this.cf][3][1] + var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy - 10, 0, 0);
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2077, this.cx, this.cy, 0, 33);
                                    var1.gameAA(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx + 21, this.cy - 30, 0);
                                } else {
                                    label936:
                                    {
                                        if (this.statusMe == 4) {
                                            var14 = var1;
                                            var10000 = 2076;
                                        } else {
                                            if (this.statusMe != 1 && this.statusMe != 6) {
                                                if (this.statusMe == 2 || this.statusMe == 10) {
                                                    SmallImage.gameAB(var1, var13[this.gameML], this.cx, this.cy - var8, 0, 33);
                                                    var1.gameAA(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx + 21, var15[this.gameML], 0);
                                                }
                                                break label936;
                                            }

                                            var14 = var1;
                                            var10000 = this.gameML == 0 ? 2073 : 2072;
                                        }

                                        var16 = var10000;
                                        SmallImage.gameAB(var14, var16, this.cx, this.cy, 0, 33);
                                        var1.gameAA(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx + 21, this.cy - 19, 0);
                                    }
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 - var10 - var8 + this.gameMI, 0, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + var9 + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 9 - var10 - var8 + this.gameMK, 0, 33);
                            } else {
                                SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx - CharInfo[this.cf][3][1] - var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy - 10, 2, 24);
                                if (this.statusMe == 3) {
                                    SmallImage.gameAB(var1, 2077, this.cx, this.cy, 2, 33);
                                    var1.gameAA(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx - 23, this.cy - 30, 0);
                                } else {
                                    label939:
                                    {
                                        if (this.statusMe == 4) {
                                            var14 = var1;
                                            var10000 = 2076;
                                        } else {
                                            if (this.statusMe != 1 && this.statusMe != 6) {
                                                if (this.statusMe == 2 || this.statusMe == 10) {
                                                    SmallImage.gameAB(var1, var13[this.gameML], this.cx, this.cy - var8, 2, 33);
                                                    var1.gameAA(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx - 24, var17[this.gameML], 0);
                                                }
                                                break label939;
                                            }

                                            var14 = var1;
                                            var10000 = this.gameML == 0 ? 2073 : 2072;
                                        }

                                        var16 = var10000;
                                        SmallImage.gameAB(var14, var16, this.cx, this.cy, 2, 33);
                                        var1.gameAA(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx - 24, this.cy - 20, 0);
                                    }
                                }

                                SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 - var10 - var8 + this.gameMI, 2, 17);
                                SmallImage.gameAB(var1, this.gameBT(), this.cx + var9 + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 9 - var10 - var8 + this.gameMK, 2, 33);
                            }
                        } else if (this.cdir == 1) {
                            label640:
                            {
                                SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx + CharInfo[this.cf][3][1] + var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy - 10, 0, 0);
                                if (this.statusMe == 3) {
                                    var14 = var1;
                                    var10000 = 1716;
                                } else if (this.statusMe == 4) {
                                    var14 = var1;
                                    var10000 = 1717;
                                } else {
                                    if (this.statusMe != 1 && this.statusMe != 6) {
                                        if (this.statusMe == 2 || this.statusMe == 10) {
                                            SmallImage.gameAB(var1, this.idWolfW[this.gameML], this.cx, this.cy - var8, 0, 33);
                                        }
                                        break label640;
                                    }

                                    var14 = var1;
                                    var10000 = this.gameML == 0 ? 1712 : 1713;
                                }

                                var16 = var10000;
                                SmallImage.gameAB(var14, var16, this.cx, this.cy, 0, 33);
                            }

                            SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 - var10 - var8 + this.gameMI, 0, 17);
                            SmallImage.gameAB(var1, this.gameBT(), this.cx + var9 + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 9 - var10 - var8 + this.gameMK, 0, 33);
                        } else {
                            label629:
                            {
                                SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx - CharInfo[this.cf][3][1] - var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy - 10, 2, 24);
                                if (this.statusMe == 3) {
                                    var14 = var1;
                                    var10000 = 1716;
                                } else if (this.statusMe == 4) {
                                    var14 = var1;
                                    var10000 = 1717;
                                } else {
                                    if (this.statusMe != 1 && this.statusMe != 6) {
                                        if (this.statusMe == 2 || this.statusMe == 10) {
                                            SmallImage.gameAB(var1, this.idWolfW[this.gameML], this.cx, this.cy - var8, 2, 33);
                                        }
                                        break label629;
                                    }

                                    var14 = var1;
                                    var10000 = this.gameML == 0 ? 1712 : 1713;
                                }

                                var16 = var10000;
                                SmallImage.gameAB(var14, var16, this.cx, this.cy, 2, 33);
                            }

                            SmallImage.gameAB(var1, this.gameBU(), this.cx + var9 + this.gameMH * this.cdir, this.cy - CharInfo[0][0][2] + var2.pi[CharInfo[0][0][0]].dy - 12 - var10 - var8 + this.gameMI, 2, 17);
                            SmallImage.gameAB(var1, this.gameBT(), this.cx + var9 + this.gameMJ * this.cdir, this.cy - SmallImage.gameAB(this.gameBS()) - 9 - var10 - var8 + this.gameMK, 2, 33);
                        }
                    }
                } else if (this.cdir == 1) {
                    if (this.gameCP && !this.isMoto && !this.isWolf) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            if (this.arrItemMounts[4].sys <= 1) {
                                SmallImage.gameAB(var1, 1800, this.lcx, this.lcy, 2, 33);
                            } else {
                                SmallImage.gameAB(var1, 2063, this.lcx, this.lcy, 2, 33);
                            }
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            if (this.arrItemMounts[4].sys <= 1) {
                                SmallImage.gameAB(var1, 2067, this.lcx, this.lcy, 2, 33);
                            } else {
                                SmallImage.gameAB(var1, 2071, this.lcx, this.lcy, 2, 33);
                            }
                        }
                    }

                    if (var7 != null) {
                        if (this.tickCoat == 0) {
                            SmallImage.gameAB(var1, var7[this.tickCoat], this.cx - 14, this.cy - 18, 0, 20);
                        } else if (this.tickCoat != 1 && this.tickCoat == 2) {
                            SmallImage.gameAB(var1, var7[this.tickCoat], this.cx - 25, this.cy - 18, 0, 20);
                        } else {
                            SmallImage.gameAB(var1, var7[this.tickCoat], this.cx - 22, this.cy - 18, 0, 20);
                        }
                    }

                    SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx + CharInfo[this.cf][3][1] + var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy, 0, 0);
                    SmallImage.gameAB(var1, var3.pi[CharInfo[this.cf][1][0]].id, this.cx + CharInfo[this.cf][1][1] + var3.pi[CharInfo[this.cf][1][0]].dx, this.cy - CharInfo[this.cf][1][2] + var3.pi[CharInfo[this.cf][1][0]].dy, 0, 0);
                    if (this.statusMe != 2) {
                        this.gameAD(var1, this.cx + 7, this.cy - 2);
                    }

                    SmallImage.gameAB(var1, var2.pi[CharInfo[this.cf][0][0]].id, this.cx + CharInfo[this.cf][0][1] + var2.pi[CharInfo[this.cf][0][0]].dx, this.cy - CharInfo[this.cf][0][2] + var2.pi[CharInfo[this.cf][0][0]].dy, 0, 0);
                    SmallImage.gameAB(var1, var4.pi[CharInfo[this.cf][2][0]].id, this.cx + CharInfo[this.cf][2][1] + var4.pi[CharInfo[this.cf][2][0]].dx, this.cy - CharInfo[this.cf][2][2] + var4.pi[CharInfo[this.cf][2][0]].dy, 0, 0);
                    if (this.statusMe == 2) {
                        this.gameAF(var1, this.cx - 14, this.cy - 2);
                        this.gameAE(var1, this.cx + 7, this.cy - 1);
                    } else {
                        this.gameAD(var1, this.cx - 7, this.cy - 2);
                        this.gameAE(var1, this.cx + 11, this.cy - 2);
                    }
                } else {
                    if (this.gameCP && !this.isMoto && !this.isWolf) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            if (this.arrItemMounts[4].sys <= 0) {
                                SmallImage.gameAB(var1, 1800, this.lcx, this.lcy, 2, 33);
                            } else {
                                SmallImage.gameAB(var1, 2063, this.lcx, this.lcy, 2, 33);
                            }
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            if (this.arrItemMounts[4].sys <= 0) {
                                SmallImage.gameAB(var1, 2067, this.lcx, this.lcy, 2, 33);
                            } else {
                                SmallImage.gameAB(var1, 2071, this.lcx, this.lcy, 2, 33);
                            }
                        }
                    }

                    if (var7 != null) {
                        SmallImage.gameAB(var1, var7[this.tickCoat], this.cx - 7, this.cy - 18, 2, 20);
                    }

                    SmallImage.gameAB(var1, var5.pi[CharInfo[this.cf][3][0]].id, this.cx - CharInfo[this.cf][3][1] - var5.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + var5.pi[CharInfo[this.cf][3][0]].dy, 2, 24);
                    SmallImage.gameAB(var1, var3.pi[CharInfo[this.cf][1][0]].id, this.cx - CharInfo[this.cf][1][1] - var3.pi[CharInfo[this.cf][1][0]].dx, this.cy - CharInfo[this.cf][1][2] + var3.pi[CharInfo[this.cf][1][0]].dy, 2, 24);
                    if (this.statusMe != 2) {
                        this.gameAD(var1, this.cx - 7, this.cy - 2);
                    }

                    SmallImage.gameAB(var1, var2.pi[CharInfo[this.cf][0][0]].id, this.cx - CharInfo[this.cf][0][1] - var2.pi[CharInfo[this.cf][0][0]].dx, this.cy - CharInfo[this.cf][0][2] + var2.pi[CharInfo[this.cf][0][0]].dy, 2, 24);
                    SmallImage.gameAB(var1, var4.pi[CharInfo[this.cf][2][0]].id, this.cx - CharInfo[this.cf][2][1] - var4.pi[CharInfo[this.cf][2][0]].dx, this.cy - CharInfo[this.cf][2][2] + var4.pi[CharInfo[this.cf][2][0]].dy, 2, 24);
                    if (this.statusMe == 2) {
                        this.gameAF(var1, this.cx + 14, this.cy - 2);
                        this.gameAE(var1, this.cx - 3, this.cy - 2);
                    } else {
                        this.gameAD(var1, this.cx + 5, this.cy - 2);
                        this.gameAE(var1, this.cx - 7, this.cy - 2);
                    }
                }
            }

            if (this.isLockAttack) {
                SmallImage.gameAB(var1, 290, this.cx, this.cy, 0, 33);
            }
        } catch (Exception var12) {
        }
    }

    private int gameBS() {
        switch (this.leg) {
            case 0:
                return 26;
            case 4:
                return 58;
            case 6:
                return 86;
            case 8:
                return 114;
            case 9:
                return 123;
            case 17:
                return 353;
            case 19:
                return 379;
            case 21:
                return 405;
            case 30:
                return 484;
            case 33:
                return 518;
            case 35:
                return 544;
            case 37:
                return 571;
            case 39:
                return 810;
            case 43:
                return 982;
            case 95:
                return 1156;
            case 142:
                return 1360;
            case 155:
                return 1494;
            case 157:
                return 1519;
            default:
                return 26;
        }
    }

    private int gameBT() {
        this.gameMJ = 0;
        this.gameMK = 0;
        if (this.statusMe == 3) {
            switch (this.body) {
                case 1:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -6;
                    }

                    return 13;
                case 3:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -6;
                    }

                    return 45;
                case 5:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 73;
                case 7:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 101;
                case 10:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 137;
                case 18:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 365;
                case 20:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 391;
                case 22:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 417;
                case 29:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -11;
                        this.gameMK = -6;
                    }

                    return 472;
                case 32:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -11;
                        this.gameMK = -6;
                    }

                    return 506;
                case 34:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 531;
                case 36:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 559;
                case 38:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 798;
                case 42:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 970;
                case 94:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -12;
                        this.gameMK = -7;
                    }

                    return 1142;
                case 141:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 1348;
                case 154:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -8;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -15;
                        this.gameMK = -3;
                    }

                    return 1487;
                case 156:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -7;
                    }

                    return 1507;
                case 157:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1812;
                case 173:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1838;
                case 180:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1959;
                case 183:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1987;
                case 186:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -14;
                        this.gameMK = -5;
                    }

                    return 2117;
                case 189:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -14;
                        this.gameMK = -5;
                    }

                    return 2144;
                case 197:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -5;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -6;
                    }

                    return 2342;
                case 199:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -5;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -6;
                    }

                    return 2373;
                case 206:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -5;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -6;
                    }

                    return 2459;
                default:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -7;
                        this.gameMK = -6;
                    }

                    return 13;
            }
        } else if (!this.gameHV) {
            switch (this.body) {
                case 1:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -2;
                    }

                    return 9;
                case 3:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -3;
                    }

                    return 41;
                case 5:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 70;
                case 7:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 97;
                case 10:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 133;
                case 18:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 369;
                case 20:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 395;
                case 22:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 421;
                case 29:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 468;
                case 32:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 502;
                case 34:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -2;
                    }

                    return 540;
                case 36:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -2;
                    }

                    return 555;
                case 38:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -2;
                    }

                    return 794;
                case 42:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -2;
                    }

                    return 966;
                case 94:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -2;
                    }

                    return 1139;
                case 141:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -7;
                        this.gameMK = -1;
                    }

                    return 1343;
                case 154:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = 1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -3;
                        this.gameMK = -1;
                    }

                    return 1479;
                case 156:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = 2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    }

                    return 1502;
                case 157:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 1808;
                case 173:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 1834;
                case 180:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 1955;
                case 183:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    }

                    return 1983;
                case 186:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -2;
                    }

                    return 2135;
                case 189:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -2;
                    }

                    return 2135;
                case 197:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -4;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -1;
                    }

                    return 2337;
                case 199:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -4;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -1;
                    }

                    return 2363;
                case 206:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -4;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -1;
                    }

                    return 2456;
                default:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 2;
                        this.gameMK = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -5;
                        this.gameMK = -2;
                    }

                    return 9;
            }
        } else {
            switch (this.body) {
                case 1:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -6;
                    }

                    return 13;
                case 3:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -6;
                    }

                    return 45;
                case 5:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 73;
                case 7:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 101;
                case 10:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 137;
                case 18:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 365;
                case 20:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 391;
                case 22:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 417;
                case 29:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -11;
                        this.gameMK = -6;
                    }

                    return 472;
                case 32:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -11;
                        this.gameMK = -6;
                    }

                    return 506;
                case 34:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 531;
                case 36:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 559;
                case 38:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 798;
                case 42:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 970;
                case 94:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 0;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 0;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -12;
                        this.gameMK = -7;
                    }

                    return 1142;
                case 141:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -9;
                        this.gameMK = -7;
                    }

                    return 1348;
                case 154:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -8;
                        this.gameMK = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -15;
                        this.gameMK = -3;
                    }

                    return 1487;
                case 156:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 1;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -4;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -7;
                    }

                    return 1507;
                case 157:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1812;
                case 173:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1838;
                case 180:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1959;
                case 183:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 4;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -8;
                        this.gameMK = -7;
                    }

                    return 1987;
                case 186:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -14;
                        this.gameMK = -5;
                    }

                    return 2117;
                case 189:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -3;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -6;
                        this.gameMK = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -14;
                        this.gameMK = -5;
                    }

                    return 2144;
                case 197:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -5;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -6;
                    }

                    return 2342;
                case 199:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -5;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -6;
                    }

                    return 2373;
                case 206:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = -1;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = -5;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -10;
                        this.gameMK = -6;
                    }

                    return 2459;
                default:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.gameMJ = 3;
                        this.gameMK = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.gameMJ = 0;
                        this.gameMK = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.gameMJ = -7;
                        this.gameMK = -6;
                    }

                    return 13;
            }
        }
    }

    private int gameBU() {
        this.gameMH = this.gameMI = 0;
        if (this.statusMe == 3) {
            switch (this.head) {
                case 2:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 33;
                case 11:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 147;
                case 23:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 427;
                case 24:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 430;
                case 25:
                    this.gameMH = 3;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 433;
                case 26:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 436;
                case 27:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 439;
                case 28:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 442;
                case 112:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 148;
                case 113:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 443;
                case 124:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1235;
                case 125:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1237;
                case 126:
                    this.gameMH = -1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1255;
                case 127:
                    this.gameMH = -1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1257;
                case 137:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1309;
                case 138:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1311;
                case 139:
                    this.gameMH = 2;
                    this.gameMI = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1315;
                case 140:
                    this.gameMH = 3;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1313;
                case 146:
                    this.gameMH = 1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1416;
                case 147:
                    this.gameMH = -2;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1418;
                case 148:
                    this.gameMH = 0;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1422;
                case 149:
                    this.gameMH = -2;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1424;
                case 150:
                    this.gameMH = 0;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1441;
                case 151:
                    this.gameMH = -2;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1439;
                case 152:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1447;
                case 153:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1445;
                case 158:
                    this.gameMH = -2;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1585;
                case 159:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1589;
                case 160:
                    this.gameMH = 2;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1587;
                case 161:
                    this.gameMH = 3;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1595;
                case 162:
                    this.gameMH = -5;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1597;
                case 163:
                    this.gameMH = -3;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1604;
                case 179:
                    this.gameMH = 3;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1978;
                case 182:
                    this.gameMH = 3;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2006;
                case 185:
                    this.gameMH = -4;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2129;
                case 188:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2156;
                case 205:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2451;
                case 210:
                    this.gameMH = 0;
                    this.gameMI = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2519;
                case 211:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2521;
                case 212:
                    this.gameMH = -2;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2523;
                case 213:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2525;
                case 214:
                    this.gameMH = 1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2526;
                default:
                    this.gameMH = 2;
                    this.gameMI = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 33;
            }
        } else if (!this.gameHV) {
            switch (this.head) {
                case 2:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 33;
                case 11:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 147;
                case 23:
                    this.gameMH = -1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 427;
                case 24:
                    this.gameMH = -1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 430;
                case 25:
                    this.gameMH = 1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 433;
                case 26:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 436;
                case 27:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 439;
                case 28:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 442;
                case 112:
                    this.gameMH = -1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 148;
                case 113:
                    this.gameMH = -3;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 443;
                case 124:
                    this.gameMH = -1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1235;
                case 125:
                    this.gameMH = -1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1237;
                case 126:
                    this.gameMH = -1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1255;
                case 127:
                    this.gameMH = -3;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1257;
                case 137:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1309;
                case 138:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1311;
                case 139:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1315;
                case 140:
                    this.gameMH = 1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1313;
                case 146:
                    this.gameMH = -1;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1416;
                case 147:
                    this.gameMH = -4;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1418;
                case 148:
                    this.gameMH = -2;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1422;
                case 149:
                    this.gameMH = -4;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1424;
                case 150:
                    this.gameMH = -2;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1441;
                case 151:
                    this.gameMH = -4;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1439;
                case 152:
                    this.gameMH = -1;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1447;
                case 153:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1445;
                case 158:
                    this.gameMH = -4;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1585;
                case 159:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1589;
                case 160:
                    this.gameMH = 0;
                    this.gameMI = 0;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1587;
                case 161:
                    this.gameMH = 1;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1595;
                case 162:
                    this.gameMH = -7;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1597;
                case 163:
                    this.gameMH = -5;
                    this.gameMI = 0;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1604;
                case 179:
                    this.gameMH = 1;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 1978;
                case 182:
                    this.gameMH = 1;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2006;
                case 185:
                    this.gameMH = -6;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2129;
                case 188:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2156;
                case 205:
                    this.gameMH = -2;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2451;
                case 210:
                    this.gameMH = -2;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2519;
                case 211:
                    this.gameMH = -3;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2521;
                case 212:
                    this.gameMH = -4;
                    this.gameMI = 0;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2523;
                case 213:
                    this.gameMH = 0;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2525;
                case 214:
                    this.gameMH = -1;
                    this.gameMI = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 2526;
                default:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 5;
                            --this.gameMI;
                        }
                    }

                    return 33;
            }
        } else {
            switch (this.head) {
                case 2:
                    this.gameMH = 2;
                    this.gameMI = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 33;
                case 11:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 147;
                case 23:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 427;
                case 24:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 430;
                case 25:
                    this.gameMH = 3;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 433;
                case 26:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 436;
                case 27:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 439;
                case 28:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 442;
                case 112:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 148;
                case 113:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 443;
                case 124:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1235;
                case 125:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1237;
                case 126:
                    this.gameMH = -1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1255;
                case 127:
                    this.gameMH = -1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1257;
                case 137:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1309;
                case 138:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1311;
                case 139:
                    this.gameMH = 2;
                    this.gameMI = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1315;
                case 140:
                    this.gameMH = 3;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1313;
                case 146:
                    this.gameMH = 1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1416;
                case 147:
                    this.gameMH = -2;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1418;
                case 148:
                    this.gameMH = 0;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1422;
                case 149:
                    this.gameMH = -2;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1424;
                case 150:
                    this.gameMH = 0;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1441;
                case 151:
                    this.gameMH = -2;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1439;
                case 152:
                    this.gameMH = 1;
                    this.gameMI = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1447;
                case 153:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1445;
                case 158:
                    this.gameMH = -2;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1585;
                case 159:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1589;
                case 160:
                    this.gameMH = 2;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1587;
                case 161:
                    this.gameMH = 3;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1595;
                case 162:
                    this.gameMH = -5;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1597;
                case 163:
                    this.gameMH = -3;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1604;
                case 179:
                    this.gameMH = 3;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 1978;
                case 182:
                    this.gameMH = 3;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2006;
                case 185:
                    this.gameMH = -4;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2129;
                case 188:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2156;
                case 205:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2451;
                case 210:
                    this.gameMH = 0;
                    this.gameMI = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2519;
                case 211:
                    this.gameMH = -1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2521;
                case 212:
                    this.gameMH = -2;
                    this.gameMI = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2523;
                case 213:
                    this.gameMH = 0;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2525;
                case 214:
                    this.gameMH = 1;
                    this.gameMI = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 2526;
                default:
                    this.gameMH = 2;
                    this.gameMI = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.gameMH -= 2;
                            ++this.gameMI;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.gameMH -= 7;
                            --this.gameMI;
                        }
                    }

                    return 33;
            }
        }
    }

    private int[] gameBV() {
        if (this.statusMe != 6 && this.statusMe != 1 && this.statusMe != 2 && this.statusMe != 10 && this.statusMe != 11) {
            return null;
        } else {
            int[] var1 = null;
            if (this.me) {
                if (this.arrItemBody[13] != null) {
                    if (this.arrItemBody[13].template.id == 425) {
                        var1 = new int[]{1687, 1688, 1689, 1690, 1691};
                    } else if (this.arrItemBody[13].template.id == 426) {
                        var1 = new int[]{1682, 1683, 1684, 1685, 1686};
                    } else if (this.arrItemBody[13].template.id == 427) {
                        var1 = new int[]{1677, 1678, 1679, 1680, 1681};
                    }
                }
            } else {
                if (this.glove == -1) {
                    return null;
                }

                if (this.glove == 425) {
                    var1 = new int[]{1687, 1688, 1689, 1690, 1691};
                } else if (this.glove == 426) {
                    var1 = new int[]{1682, 1683, 1684, 1685, 1686};
                } else if (this.glove == 427) {
                    var1 = new int[]{1677, 1678, 1679, 1680, 1681};
                }
            }

            return var1;
        }
    }

    public final void gameAD(mGraphics var1, int var2, int var3) {
        int[] var4;
        if ((var4 = this.gameBV()) != null) {
            int var5;
            if ((var5 = GameCanvas.gameTick % 13) > 9) {
                SmallImage.gameAB(var1, var4[0], var2, var3, 0, 33);
                return;
            }

            if (var5 > 6) {
                SmallImage.gameAB(var1, var4[1], var2, var3 + 2, 0, 33);
                return;
            }

            if (var5 > 3) {
                SmallImage.gameAB(var1, var4[2], var2 - 2, var3 + 1, 0, 33);
                return;
            }

            SmallImage.gameAB(var1, var4[3], var2 - 2, var3, 0, 33);
        }

    }

    private void gameAF(mGraphics var1, int var2, int var3) {
        int[] var4;
        if ((var4 = this.gameBV()) != null) {
            int var5 = this.cdir == 1 ? 6 : 5;
            int var6 = this.cdir == -1 ? 40 : 36;
            int var7;
            if ((var7 = GameCanvas.gameTick % 13) > 9) {
                SmallImage.gameAB(var1, var4[0], var2, var3, var5, var6);
                return;
            }

            if (var7 > 6) {
                SmallImage.gameAB(var1, var4[1], var2, var3, var5, var6);
                return;
            }

            if (var7 > 3) {
                SmallImage.gameAB(var1, var4[2], var2, var3, var5, var6);
                return;
            }

            SmallImage.gameAB(var1, var4[3], var2, var3, var5, var6);
        }

    }

    public final void gameAE(mGraphics var1, int var2, int var3) {
        int[] var4;
        if ((var4 = this.gameBV()) != null) {
            SmallImage.gameAB(var1, var4[4], var2 - 2, var3, 0, 33);
        }

    }

    private void gameAO(int var1) {
        this.indexEff = 0;
        this.eff = GameScr.efs[var1];
    }

    public final void gameAC(int var1) {
        this.indexEffTask = 0;
        this.effTask = GameScr.efs[var1];
    }

    public static int gameAD(int var0) {
        for (int var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
            if (((Char) GameScr.vCharInMap.elementAt(var1)).charID == var0) {
                return var1;
            }
        }

        return -1;
    }

    public final void gameAA(int var1, int var2) {
        byte var3 = 0;
        var1 -= this.cx;
        var2 -= this.cy;
        if (var1 == 0 && var2 == 0) {
            var3 = 1;
        } else if (var2 == 0) {
            var3 = 2;
            if (this.vMovePoints.size() > 0) {
                MovePoint var4 = null;

                try {
                    var4 = (MovePoint) this.vMovePoints.lastElement();
                } catch (Exception var5) {
                }

                if (var4 != null && TileMap.gameAA(var4.xEnd, var4.yEnd, 64) && var4.yEnd % TileMap.size > 8) {
                    var3 = 10;
                }
            }

            if (var1 < 0) {
            }
        } else if (var2 != 0) {
            if (var2 < 0) {
                var3 = 3;
            }

            if (var2 > 0) {
                var3 = 4;
            }
        }

        int var6 = this.cx + var1;
        var1 = this.cy + var2;
        this.vMovePoints.addElement(new MovePoint(var6, var1, var3));
        this.statusMe = 6;
    }

    private void gameBW() {
        if (this.charFocus != null && this.charFocus.isNhanban) {
            this.charFocus = null;
        }

        if (gameHF && this.charFocus != null && (this.charFocus.statusMe == 15 || this.charFocus.isInvisible)) {
            this.charFocus = null;
        }

        if (GameCanvas.gameTick % 2 != 0 && !gameAB(this.charFocus)) {
            byte var1 = 0;
            if (this.nClass.classId == 0 || this.nClass.classId == 1 || this.nClass.classId == 3 || this.nClass.classId == 5) {
                if (GameScr.gameFW != 1) {
                    var1 = 40;
                } else {
                    var1 = 0;
                }
            }

            int[] var2 = new int[]{-1, -1, -1, -1};
            int var3 = GameScr.cmx - 10;
            int var4 = GameScr.cmx + GameCanvas.w + 10;
            int var5 = GameScr.cmy;
            int var6 = GameScr.cmy + GameCanvas.h - GameScr.gameAG + 10;
            if (gameHF) {
                if (this.mobFocus != null && this.mobFocus.status != 1 && this.mobFocus.status != 8 && this.mobFocus.status != 0 && var3 <= this.mobFocus.x && this.mobFocus.x <= var4 && var5 <= this.mobFocus.y && this.mobFocus.y <= var6 || this.npcFocus != null && var3 <= this.npcFocus.cx && this.npcFocus.cx <= var4 && var5 <= this.npcFocus.cy && this.npcFocus.cy <= var6 || this.charFocus != null && var3 <= this.charFocus.cx && this.charFocus.cx <= var4 && var5 <= this.charFocus.cy && this.charFocus.cy <= var6 || this.itemFocus != null && var3 <= this.itemFocus.x && this.itemFocus.x <= var4 && var5 <= this.itemFocus.y && this.itemFocus.y <= var6) {
                    return;
                }

                gameHF = false;
            }

            int var7;
            ItemMap var8;
            int var9;
            int var10;
            int var11;
            if (this.itemFocus == null) {
                for (var7 = 0; var7 < GameScr.vItemMap.size(); ++var7) {
                    var8 = (ItemMap) GameScr.vItemMap.elementAt(var7);
                    var9 = Math.abs(getMyChar().cx - var8.x);
                    var10 = Math.abs(getMyChar().cy - var8.y);
                    var11 = var9 > var10 ? var9 : var10;
                    if (var9 <= 48 && var10 <= 48 && (this.itemFocus == null || var11 < var2[3])) {
                        if (GameScr.gameFW != 0 && GameScr.gameAG()) {
                            if (var8.template.type == 19) {
                                if (GameScr.gameFR) {
                                    this.itemFocus = null;
                                } else {
                                    this.itemFocus = var8;
                                }

                                var2[3] = var11;
                            }
                        } else if (!NhatYen && !NhatHpMp && !NhatDa && !NhatTrangBi && !NhatVpNV && !KhongNhat) {
                            if (GameScr.gameFR) {
                                this.itemFocus = null;
                            } else {
                                this.itemFocus = var8;
                            }

                            var2[3] = var11;
                        } else if (NhatYen && var8.template.type == 19 || NhatHpMp && (var8.template.type == 16 || var8.template.type == 17) || NhatDa && var8.template.type == 26 || NhatTrangBi && var8.template.gameAA() || NhatVpNV && var8.template.gameAB()) {
                            if (GameScr.gameFR) {
                                this.itemFocus = null;
                            } else {
                                this.itemFocus = var8;
                            }

                            var2[3] = var11;
                        }
                    }
                }
            } else {
                if (var3 <= this.itemFocus.x && this.itemFocus.x <= var4 && var5 <= this.itemFocus.y && this.itemFocus.y <= var6) {
                    this.gameAP(3);
                    return;
                }

                this.itemFocus = null;

                for (var7 = 0; var7 < GameScr.vItemMap.size(); ++var7) {
                    var8 = (ItemMap) GameScr.vItemMap.elementAt(var7);
                    var9 = Math.abs(getMyChar().cx - var8.x);
                    var10 = Math.abs(getMyChar().cy - var8.y);
                    var11 = var9 > var10 ? var9 : var10;
                    if (var3 <= var8.x && var8.x <= var4 && var5 <= var8.y && var8.y <= var6 && (this.itemFocus == null || var11 < var2[3])) {
                        GameScr.gI();
                        if (GameScr.gameFW != 0) {
                            GameScr.gI();
                            if (GameScr.gameAG()) {
                                if (var8.template.type == 19) {
                                    if (GameScr.gameFR) {
                                        this.itemFocus = null;
                                    } else {
                                        this.itemFocus = var8;
                                    }

                                    var2[3] = var11;
                                }
                                continue;
                            }
                        }

                        if (!NhatYen && !NhatHpMp && !NhatDa && !NhatTrangBi && !NhatVpNV && !KhongNhat) {
                            if (GameScr.gameFR) {
                                this.itemFocus = null;
                            } else {
                                this.itemFocus = var8;
                            }

                            var2[3] = var11;
                        } else if (NhatYen && var8.template.type == 19 || NhatHpMp && (var8.template.type == 16 || var8.template.type == 17) || NhatDa && var8.template.type == 26 || NhatTrangBi && var8.template.gameAA() || NhatVpNV && var8.template.gameAB()) {
                            if (GameScr.gameFR) {
                                this.itemFocus = null;
                            } else {
                                this.itemFocus = var8;
                            }

                            var2[3] = var11;
                        }
                    }
                }
            }

            Mob var12;
            Npc var13;
            Char var14;
            int var15;
            if (TileMap.gameAN != 3 && TileMap.mapID != 111) {
                var3 = getMyChar().cx - getMyChar().gameAD() - 10;
                var4 = getMyChar().cx + getMyChar().gameAD() + 10;
                var5 = getMyChar().cy - getMyChar().gameAE() - var1;
                if ((var6 = getMyChar().cy + getMyChar().gameAE()) > getMyChar().cy + 30) {
                    var6 = getMyChar().cy + 30;
                }

                if (this.mobFocus == null) {
                    for (var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                        var12 = (Mob) GameScr.vMob.elementAt(var7);
                        var9 = Math.abs(getMyChar().cx - var12.x);
                        var10 = Math.abs(getMyChar().cy - var12.y);
                        var11 = var9 > var10 ? var9 : var10;
                        if ((var12.templateId != 97 || getMyChar().cTypePk != 4) && (var12.templateId != 96 || getMyChar().cTypePk != 5) && (var12.templateId != 98 || getMyChar().cTypePk != 4) && (var12.templateId != 167 || getMyChar().cTypePk != 4) && (var12.templateId != 99 || getMyChar().cTypePk != 5) && (var12.templateId != 166 || getMyChar().cTypePk != 5) && (var12.templateId != 202 || var12.status != 8 || var12.gameAD()) && (!GameScr.gameFR || var12.levelBoss != 3) && var12.templateId != 202 && var3 <= var12.x && var12.x <= var4 && var5 <= var12.y && var12.y <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                            this.mobFocus = var12;
                            var2[0] = var11;
                        }
                    }
                } else {
                    if (this.mobFocus.status != 1 && this.mobFocus.status != 0 && var3 <= this.mobFocus.x && this.mobFocus.x <= var4 && var5 <= this.mobFocus.y && this.mobFocus.y <= var6) {
                        this.gameAP(0);
                        return;
                    }

                    this.mobFocus = null;

                    for (var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                        var12 = (Mob) GameScr.vMob.elementAt(var7);
                        var9 = Math.abs(getMyChar().cx - var12.x);
                        var10 = Math.abs(getMyChar().cy - var12.y);
                        var11 = var9 > var10 ? var9 : var10;
                        if ((var12.templateId != 97 || getMyChar().cTypePk != 4) && (var12.templateId != 96 || getMyChar().cTypePk != 5) && (var12.templateId != 98 || getMyChar().cTypePk != 4) && (var12.templateId != 167 || getMyChar().cTypePk != 4) && (var12.templateId != 99 || getMyChar().cTypePk != 5) && (var12.templateId != 166 || getMyChar().cTypePk != 5) && (var12.templateId != 202 || var12.status != 8 || var12.gameAD()) && (!GameScr.gameFR || var12.levelBoss != 3) && var12.templateId != 202 && var3 <= var12.x && var12.x <= var4 && var5 <= var12.y && var12.y <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                            this.mobFocus = var12;
                            var2[0] = var11;
                        }
                    }
                }

                var3 = getMyChar().cx - 80;
                var4 = getMyChar().cx + 80;
                var5 = getMyChar().cy - 30;
                var6 = getMyChar().cy + 30;
                if (this.npcFocus != null && this.npcFocus.template.npcTemplateId == 13) {
                    var3 = getMyChar().cx - 20;
                    var4 = getMyChar().cx + 20;
                    var5 = getMyChar().cy - 10;
                    var6 = getMyChar().cy + 10;
                }

                if (this.npcFocus == null) {
                    for (var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                        if ((var13 = (Npc) GameScr.vNpc.elementAt(var7)).statusMe != 15 && TileMap.gameAN != 1) {
                            var9 = Math.abs(getMyChar().cx - var13.cx);
                            var10 = Math.abs(getMyChar().cy - var13.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            var3 = getMyChar().cx - 80;
                            var4 = getMyChar().cx + 80;
                            var5 = getMyChar().cy - 30;
                            var6 = getMyChar().cy + 30;
                            if (var13.template.npcTemplateId == 13) {
                                var3 = getMyChar().cx - 20;
                                var4 = getMyChar().cx + 20;
                                var5 = getMyChar().cy - 10;
                                var6 = getMyChar().cy + 10;
                            }

                            if (var3 <= var13.cx && var13.cx <= var4 && var5 <= var13.cy && var13.cy <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                                if (GameScr.gameFR && GameScr.gameFW == 1) {
                                    break;
                                }

                                this.npcFocus = var13;
                                var2[1] = var11;
                            }
                        }
                    }
                } else {
                    if (var3 <= this.npcFocus.cx && this.npcFocus.cx <= var4 && var5 <= this.npcFocus.cy && this.npcFocus.cy <= var6) {
                        this.gameAP(1);
                        return;
                    }

                    this.gameAY();

                    for (var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                        if ((var13 = (Npc) GameScr.vNpc.elementAt(var7)).statusMe != 15 && TileMap.gameAN != 1) {
                            var9 = Math.abs(getMyChar().cx - var13.cx);
                            var10 = Math.abs(getMyChar().cy - var13.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            var3 = getMyChar().cx - 80;
                            var4 = getMyChar().cx + 80;
                            var5 = getMyChar().cy - 30;
                            var6 = getMyChar().cy + 30;
                            if (var13.template.npcTemplateId == 13) {
                                var3 = getMyChar().cx - 20;
                                var4 = getMyChar().cx + 20;
                                var5 = getMyChar().cy - 10;
                                var6 = getMyChar().cy + 10;
                            }

                            if (var3 <= var13.cx && var13.cx <= var4 && var5 <= var13.cy && var13.cy <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                                if (GameScr.gameFR && GameScr.gameFW == 1) {
                                    break;
                                }

                                this.npcFocus = var13;
                                var2[1] = var11;
                            }
                        }
                    }
                }

                if (this.charFocus == null) {
                    for (var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                        if (!(var14 = (Char) GameScr.vCharInMap.elementAt(var7)).isNhanban && var14.statusMe != 15 && !var14.isInvisible && var14.charID < -1 && this.wdx == 0 && this.wdy == 0 && var14.statusMe != 14 && var14.statusMe != 5) {
                            var9 = Math.abs(getMyChar().cx - var14.cx);
                            var10 = Math.abs(getMyChar().cy - var14.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            if (var3 <= var14.cx && var14.cx <= var4 && var5 <= var14.cy && var14.cy <= var6 && (this.charFocus == null || var11 < var2[2])) {
                                this.charFocus = var14;
                                var2[2] = var11;
                            }
                        }
                    }
                } else {
                    if (var3 <= this.charFocus.cx && this.charFocus.cx <= var4 && var5 <= this.charFocus.cy && this.charFocus.cy <= var6 && this.charFocus.statusMe != 15 && !this.charFocus.isInvisible) {
                        this.gameAP(2);
                        return;
                    }

                    this.charFocus = null;

                    for (var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                        if (!(var14 = (Char) GameScr.vCharInMap.elementAt(var7)).isNhanban && var14.statusMe != 15 && !var14.isInvisible && var14.charID < 0 && this.wdx == 0 && this.wdy == 0 && var14.statusMe != 14 && var14.statusMe != 5) {
                            var9 = Math.abs(getMyChar().cx - var14.cx);
                            var10 = Math.abs(getMyChar().cy - var14.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            if (var3 <= var14.cx && var14.cx <= var4 && var5 <= var14.cy && var14.cy <= var6 && (this.charFocus == null || var11 < var2[2])) {
                                this.charFocus = var14;
                                var2[2] = var11;
                            }
                        }
                    }
                }

                var7 = -1;

                for (var15 = 0; var15 < 4; ++var15) {
                    if (var7 == -1) {
                        if (var2[var15] != -1) {
                            var7 = var15;
                        }
                    } else if (var2[var15] < var2[var7] && var2[var15] != -1) {
                        var7 = var15;
                    }
                }

                if (GameScr.gameFR && GameScr.gameFW == 1 && !GameScr.gI().gameFX) {
                    GameScr.gameBL();
                }
            } else {
                var3 = getMyChar().cx - getMyChar().gameAD();
                var4 = getMyChar().cx + getMyChar().gameAD();
                var5 = getMyChar().cy - getMyChar().gameAE() - var1;
                if ((var6 = getMyChar().cy + getMyChar().gameAE()) > getMyChar().cy + 30) {
                    var6 = getMyChar().cy + 30;
                }

                if (this.mobFocus == null) {
                    for (var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                        var12 = (Mob) GameScr.vMob.elementAt(var7);
                        var9 = Math.abs(getMyChar().cx - var12.x);
                        var10 = Math.abs(getMyChar().cy - var12.y);
                        var11 = var9 > var10 ? var9 : var10;
                        if ((var12.templateId != 97 || getMyChar().cTypePk != 4) && (var12.templateId != 96 || getMyChar().cTypePk != 5) && (var12.templateId != 98 || getMyChar().cTypePk != 4) && (var12.templateId != 167 || getMyChar().cTypePk != 4) && (var12.templateId != 99 || getMyChar().cTypePk != 5) && (var12.templateId != 166 || getMyChar().cTypePk != 5) && var3 <= var12.x && var12.x <= var4 && var5 <= var12.y && var12.y <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                            this.mobFocus = var12;
                            var2[0] = var11;
                        }
                    }
                } else {
                    if (this.mobFocus.status != 1 && this.mobFocus.status != 0 && var3 <= this.mobFocus.x && this.mobFocus.x <= var4 && var5 <= this.mobFocus.y && this.mobFocus.y <= var6) {
                        this.gameAP(0);
                        return;
                    }

                    this.mobFocus = null;

                    for (var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                        var12 = (Mob) GameScr.vMob.elementAt(var7);
                        var9 = Math.abs(getMyChar().cx - var12.x);
                        var10 = Math.abs(getMyChar().cy - var12.y);
                        var11 = var9 > var10 ? var9 : var10;
                        if ((var12.templateId != 97 || getMyChar().cTypePk != 4) && (var12.templateId != 96 || getMyChar().cTypePk != 5) && (var12.templateId != 98 || getMyChar().cTypePk != 4) && (var12.templateId != 167 || getMyChar().cTypePk != 4) && (var12.templateId != 99 || getMyChar().cTypePk != 5) && (var12.templateId != 166 || getMyChar().cTypePk != 5) && var3 <= var12.x && var12.x <= var4 && var5 <= var12.y && var12.y <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                            this.mobFocus = var12;
                            var2[0] = var11;
                        }
                    }
                }

                var3 = getMyChar().cx - 80;
                var4 = getMyChar().cx + 80;
                var5 = getMyChar().cy - 30;
                var6 = getMyChar().cy + 30;
                if (this.npcFocus != null && this.npcFocus.template.npcTemplateId == 13) {
                    var3 = getMyChar().cx - 20;
                    var4 = getMyChar().cx + 20;
                    var5 = getMyChar().cy - 10;
                    var6 = getMyChar().cy + 10;
                }

                if (this.npcFocus == null) {
                    for (var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                        if ((var13 = (Npc) GameScr.vNpc.elementAt(var7)).statusMe != 15) {
                            var9 = Math.abs(getMyChar().cx - var13.cx);
                            var10 = Math.abs(getMyChar().cy - var13.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            var3 = getMyChar().cx - 80;
                            var4 = getMyChar().cx + 80;
                            var5 = getMyChar().cy - 30;
                            var6 = getMyChar().cy + 30;
                            if (var13.template.npcTemplateId == 13) {
                                var3 = getMyChar().cx - 20;
                                var4 = getMyChar().cx + 20;
                                var5 = getMyChar().cy - 10;
                                var6 = getMyChar().cy + 10;
                            }

                            if (var3 <= var13.cx && var13.cx <= var4 && var5 <= var13.cy && var13.cy <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                                if (GameScr.gameFR && GameScr.gameFW == 1) {
                                    break;
                                }

                                this.npcFocus = var13;
                                var2[1] = var11;
                            }
                        }
                    }
                } else {
                    if (var3 <= this.npcFocus.cx && this.npcFocus.cx <= var4 && var5 <= this.npcFocus.cy && this.npcFocus.cy <= var6) {
                        this.gameAP(1);
                        return;
                    }

                    this.gameAY();

                    for (var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                        if ((var13 = (Npc) GameScr.vNpc.elementAt(var7)).statusMe != 15) {
                            var9 = Math.abs(getMyChar().cx - var13.cx);
                            var10 = Math.abs(getMyChar().cy - var13.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            var3 = getMyChar().cx - 80;
                            var4 = getMyChar().cx + 80;
                            var5 = getMyChar().cy - 30;
                            var6 = getMyChar().cy + 30;
                            if (var13.template.npcTemplateId == 13) {
                                var3 = getMyChar().cx - 20;
                                var4 = getMyChar().cx + 20;
                                var5 = getMyChar().cy - 10;
                                var6 = getMyChar().cy + 10;
                            }

                            if (var3 <= var13.cx && var13.cx <= var4 && var5 <= var13.cy && var13.cy <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                                if (GameScr.gameFR && GameScr.gameFW == 1) {
                                    break;
                                }

                                this.npcFocus = var13;
                                var2[1] = var11;
                            }
                        }
                    }
                }

                var3 = getMyChar().cx - 40;
                var4 = getMyChar().cx + 40;
                var5 = getMyChar().cy - 30;
                var6 = getMyChar().cy + 30;
                if (this.charFocus == null) {
                    for (var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                        if (!(var14 = (Char) GameScr.vCharInMap.elementAt(var7)).isNhanban) {
                            if (TileMap.mapID != 111) {
                                if (var14.statusMe == 15 || var14.isInvisible || var14.cTypePk == myChar.cTypePk || this.wdx != 0 || this.wdy != 0 || var14.statusMe == 14 || var14.statusMe == 5) {
                                    continue;
                                }
                            } else {
                                if (var14.statusMe == 15 || var14.isInvisible || this.wdx != 0 || this.wdy != 0) {
                                    continue;
                                }

                                if (myChar.nClass.classId == 6) {
                                    if (myChar.cTypePk == var14.cTypePk) {
                                        if (var14.statusMe != 14 || var14.statusMe != 5) {
                                            continue;
                                        }
                                    } else if (var14.statusMe == 14 || var14.statusMe == 5) {
                                        continue;
                                    }
                                } else if (myChar.cTypePk == var14.cTypePk || var14.statusMe == 14 || var14.statusMe == 5) {
                                    continue;
                                }
                            }

                            var9 = Math.abs(getMyChar().cx - var14.cx);
                            var10 = Math.abs(getMyChar().cy - var14.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            if (var3 <= var14.cx && var14.cx <= var4 && var5 <= var14.cy && var14.cy <= var6 && (this.charFocus == null || var11 < var2[2])) {
                                this.charFocus = var14;
                                var2[2] = var11;
                            }
                        }
                    }
                } else {
                    if (var3 <= this.charFocus.cx && this.charFocus.cx <= var4 && var5 <= this.charFocus.cy && this.charFocus.cy <= var6 && this.charFocus.statusMe != 15 && !this.charFocus.isInvisible && this.charFocus.statusMe != 14 && this.charFocus.statusMe != 5) {
                        this.gameAP(2);
                        return;
                    }

                    this.charFocus = null;

                    for (var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                        if (!(var14 = (Char) GameScr.vCharInMap.elementAt(var7)).isNhanban) {
                            if (TileMap.mapID != 111) {
                                if (var14.statusMe == 15 || var14.isInvisible || var14.cTypePk == myChar.cTypePk || this.wdx != 0 || this.wdy != 0 || var14.statusMe == 14 || var14.statusMe == 5) {
                                    continue;
                                }
                            } else {
                                if (var14.statusMe == 15 || var14.isInvisible || this.wdx != 0 || this.wdy != 0) {
                                    continue;
                                }

                                if (myChar.nClass.classId == 6) {
                                    if (myChar.cTypePk == var14.cTypePk) {
                                        if (var14.statusMe != 14 || var14.statusMe != 5) {
                                            continue;
                                        }
                                    } else if (var14.statusMe == 14 || var14.statusMe == 5) {
                                        continue;
                                    }
                                } else if (myChar.cTypePk == var14.cTypePk || var14.statusMe == 14 || var14.statusMe == 5) {
                                    continue;
                                }
                            }

                            var9 = Math.abs(getMyChar().cx - var14.cx);
                            var10 = Math.abs(getMyChar().cy - var14.cy);
                            var11 = var9 > var10 ? var9 : var10;
                            if (var3 <= var14.cx && var14.cx <= var4 && var5 <= var14.cy && var14.cy <= var6 && (this.charFocus == null || var11 < var2[2])) {
                                this.charFocus = var14;
                                var2[2] = var11;
                            }
                        }
                    }
                }

                var7 = -1;

                for (var15 = 0; var15 < 4; ++var15) {
                    if (var7 == -1) {
                        if (var2[var15] != -1) {
                            var7 = var15;
                        }
                    } else if (var2[var15] < var2[var7] && var2[var15] != -1) {
                        var7 = var15;
                    }
                }
            }

            this.gameAP(var7);
        }

    }

    private void gameAP(int var1) {
        if (var1 == 0) {
            this.gameAY();
            this.charFocus = null;
            this.itemFocus = null;
        } else if (var1 == 1) {
            this.mobFocus = null;
            this.charFocus = null;
            this.itemFocus = null;
        } else if (var1 == 2) {
            this.mobFocus = null;
            this.gameAY();
            this.itemFocus = null;
        } else {
            if (var1 == 3) {
                this.mobFocus = null;
                this.gameAY();
                this.charFocus = null;
            }

        }
    }

    public static boolean gameAA(Char var0) {
        int var1 = GameScr.cmx;
        int var2 = GameScr.cmx + GameCanvas.w;
        int var3 = GameScr.cmy + 10;
        int var4 = GameScr.cmy + GameScr.gH;
        return var0.statusMe != 15 && !var0.isInvisible && var1 <= var0.cx && var0.cx <= var2 && var3 <= var0.cy && var0.cy <= var4;
    }

    public final void gameAX() {
        if (this.charFocus != null && this.charFocus.isNhanban) {
            this.charFocus = null;
        }

        if (getMyChar().skillPaint == null && getMyChar().arr == null) {
            this.focus.removeAllElements();
            int var1 = 0;
            int var2 = GameScr.cmx + 10;
            int var3 = GameScr.cmx + GameCanvas.w - 10;
            int var4 = GameScr.cmy + 10;
            int var5 = GameScr.cmy + GameScr.gH;
            int var6;
            Char var7;
            ItemMap var8;
            Mob var9;
            Npc var10;
            if (TileMap.gameAN != 3 && TileMap.mapID != 111) {
                for (var6 = 0; var6 < GameScr.vItemMap.size(); ++var6) {
                    var8 = (ItemMap) GameScr.vItemMap.elementAt(var6);
                    if (var2 <= var8.x && var8.x <= var3 && var4 <= var8.y && var8.y <= var5) {
                        this.focus.addElement(var8);
                        if (this.itemFocus != null && var8.equals(this.itemFocus)) {
                            var1 = this.focus.size();
                        }
                    }
                }

                for (var6 = 0; var6 < GameScr.vMob.size(); ++var6) {
                    if (((var9 = (Mob) GameScr.vMob.elementAt(var6)).templateId != 97 || getMyChar().cTypePk != 4) && (var9.templateId != 96 || getMyChar().cTypePk != 5) && (var9.templateId != 98 || getMyChar().cTypePk != 4) && (var9.templateId != 167 || getMyChar().cTypePk != 4) && (var9.templateId != 99 || getMyChar().cTypePk != 5) && (var9.templateId != 166 || getMyChar().cTypePk != 5) && (var9.templateId != 202 || var9.status != 8 || var9.gameAD()) && var9.status != 1 && var9.status != 0 && var2 <= var9.x && var9.x <= var3 && var4 <= var9.y && var9.y <= var5) {
                        this.focus.addElement(var9);
                        if (this.mobFocus != null && var9.equals(this.mobFocus)) {
                            var1 = this.focus.size();
                        }
                    }
                }

                for (var6 = 0; var6 < GameScr.vNpc.size(); ++var6) {
                    if ((var10 = (Npc) GameScr.vNpc.elementAt(var6)).statusMe != 15 && var2 <= var10.cx && var10.cx <= var3 && var4 <= var10.cy && var10.cy <= var5) {
                        this.focus.addElement(var10);
                        if (this.npcFocus != null && var10.equals(this.npcFocus)) {
                            var1 = this.focus.size();
                        }
                    }
                }

                for (var6 = 0; var6 < GameScr.vCharInMap.size(); ++var6) {
                    if (!(var7 = (Char) GameScr.vCharInMap.elementAt(var6)).isNhanban && var7.statusMe != 15 && !var7.isInvisible && var2 <= var7.cx && var7.cx <= var3 && var4 <= var7.cy && var7.cy <= var5) {
                        this.focus.addElement(var7);
                        if (this.charFocus != null && var7.equals(this.charFocus)) {
                            var1 = this.focus.size();
                        }
                    }
                }

                if (this.focus.size() <= 0) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.charFocus = null;
                    this.itemFocus = null;
                    gameHF = false;
                    return;
                }

                if (var1 >= this.focus.size()) {
                    var1 = 0;
                }

                if (this.focus.elementAt(var1) instanceof Mob) {
                    this.mobFocus = (Mob) this.focus.elementAt(var1);
                    this.gameAY();
                    this.charFocus = null;
                    this.itemFocus = null;
                    gameHF = true;
                    return;
                }

                if (this.focus.elementAt(var1) instanceof Npc) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.npcFocus = (Npc) this.focus.elementAt(var1);
                    this.charFocus = null;
                    this.itemFocus = null;
                    gameHF = true;
                    return;
                }

                if (this.focus.elementAt(var1) instanceof Char) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.charFocus = (Char) this.focus.elementAt(var1);
                    this.itemFocus = null;
                    gameHF = true;
                    return;
                }

                if (this.focus.elementAt(var1) instanceof ItemMap) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.charFocus = null;
                    this.itemFocus = (ItemMap) this.focus.elementAt(var1);
                    gameHF = true;
                    return;
                }
            } else {
                if (TileMap.mapID != 98 && TileMap.mapID != 104) {
                    for (var6 = 0; var6 < GameScr.vCharInMap.size(); ++var6) {
                        if (!(var7 = (Char) GameScr.vCharInMap.elementAt(var6)).isNhanban && var7.statusMe != 15 && !var7.isInvisible && var2 <= var7.cx && var7.cx <= var3 && var4 <= var7.cy && var7.cy <= var5) {
                            if (TileMap.mapID != 111) {
                                if (var7.cTypePk != getMyChar().cTypePk && var7.statusMe != 14 && var7.statusMe != 5) {
                                    this.focus.addElement(var7);
                                    if (this.charFocus != null && var7.equals(this.charFocus)) {
                                        var1 = this.focus.size();
                                    }
                                }
                            } else if (myChar.cTypePk == 0) {
                                this.focus.addElement(var7);
                                if (this.charFocus != null && var7.equals(this.charFocus)) {
                                    var1 = this.focus.size();
                                }
                            } else if (myChar.nClass.classId == 6) {
                                if (myChar.cTypePk == var7.cTypePk) {
                                    if (var7.statusMe == 14 || var7.statusMe == 5) {
                                        this.focus.addElement(var7);
                                        if (this.charFocus != null && var7.equals(this.charFocus)) {
                                            var1 = this.focus.size();
                                        }
                                    }
                                } else if ((myChar.cTypePk != 4 || var7.cTypePk == 5) && (myChar.cTypePk != 5 || var7.cTypePk == 4) && var7.statusMe != 14 && var7.statusMe != 5) {
                                    this.focus.addElement(var7);
                                    if (this.charFocus != null && var7.equals(this.charFocus)) {
                                        var1 = this.focus.size();
                                    }
                                }
                            } else if ((myChar.cTypePk != 4 || var7.cTypePk == 5) && (myChar.cTypePk != 5 || var7.cTypePk == 4) && var7.statusMe != 14 && var7.statusMe != 5) {
                                this.focus.addElement(var7);
                                if (this.charFocus != null && var7.equals(this.charFocus)) {
                                    var1 = this.focus.size();
                                }
                            }
                        }
                    }
                } else {
                    for (var6 = 0; var6 < GameScr.vCharInMap.size(); ++var6) {
                        if (!(var7 = (Char) GameScr.vCharInMap.elementAt(var6)).isNhanban && var7.statusMe != 15 && !var7.isInvisible && var2 <= var7.cx && var7.cx <= var3 && var4 <= var7.cy && var7.cy <= var5) {
                            this.focus.addElement(var7);
                            if (this.charFocus != null && var7.equals(this.charFocus)) {
                                var1 = this.focus.size();
                            }
                        }
                    }
                }

                for (var6 = 0; var6 < GameScr.vItemMap.size(); ++var6) {
                    var8 = (ItemMap) GameScr.vItemMap.elementAt(var6);
                    if (var2 <= var8.x && var8.x <= var3 && var4 <= var8.y && var8.y <= var5) {
                        this.focus.addElement(var8);
                        if (this.itemFocus != null && var8.equals(this.itemFocus)) {
                            var1 = this.focus.size();
                        }
                    }
                }

                for (var6 = 0; var6 < GameScr.vMob.size(); ++var6) {
                    if (((var9 = (Mob) GameScr.vMob.elementAt(var6)).templateId != 97 || getMyChar().cTypePk != 4) && (var9.templateId != 96 || getMyChar().cTypePk != 5) && (var9.templateId != 98 || getMyChar().cTypePk != 4) && (var9.templateId != 167 || getMyChar().cTypePk != 4) && (var9.templateId != 99 || getMyChar().cTypePk != 5) && (var9.templateId != 166 || getMyChar().cTypePk != 5) && var9.status != 1 && var9.status != 0 && var2 <= var9.x && var9.x <= var3 && var4 <= var9.y && var9.y <= var5) {
                        this.focus.addElement(var9);
                        if (this.mobFocus != null && var9.equals(this.mobFocus)) {
                            var1 = this.focus.size();
                        }
                    }
                }

                for (var6 = 0; var6 < GameScr.vNpc.size(); ++var6) {
                    if ((var10 = (Npc) GameScr.vNpc.elementAt(var6)).statusMe != 15 && var2 <= var10.cx && var10.cx <= var3 && var4 <= var10.cy && var10.cy <= var5) {
                        this.focus.addElement(var10);
                        if (this.npcFocus != null && var10.equals(this.npcFocus)) {
                            var1 = this.focus.size();
                        }
                    }
                }

                if (this.focus.size() <= 0) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.charFocus = null;
                    this.itemFocus = null;
                    gameHF = false;
                    return;
                }

                if (var1 >= this.focus.size()) {
                    var1 = 0;
                }

                if (this.focus.elementAt(var1) instanceof Char) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.charFocus = (Char) this.focus.elementAt(var1);
                    this.itemFocus = null;
                    gameHF = true;
                    return;
                }

                if (this.focus.elementAt(var1) instanceof Npc) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.npcFocus = (Npc) this.focus.elementAt(var1);
                    this.charFocus = null;
                    this.itemFocus = null;
                    gameHF = true;
                    return;
                }

                if (this.focus.elementAt(var1) instanceof Mob) {
                    this.mobFocus = (Mob) this.focus.elementAt(var1);
                    this.gameAY();
                    this.charFocus = null;
                    this.itemFocus = null;
                    gameHF = true;
                    return;
                }

                if (this.focus.elementAt(var1) instanceof ItemMap) {
                    this.mobFocus = null;
                    this.gameAY();
                    this.charFocus = null;
                    this.itemFocus = (ItemMap) this.focus.elementAt(var1);
                    gameHF = true;
                    return;
                }
            }
        }

    }

    public final void gameAY() {
        if (this.me && this.npcFocus != null) {
            this.npcFocus.chatPopup = null;
            this.npcFocus = null;
        }

    }

    private void gameBX() {
        if (!GameCanvas.gameAA) {
            if (TileMap.gameAA(this.cx, this.cy + 1, 1024)) {
                TileMap.gameAB(this.cx, this.cy + 1);
                TileMap.gameAB(this.cx, this.cy - 2);
            }

            if (TileMap.gameAA(this.cx - TileMap.size, this.cy + 1, 512)) {
                TileMap.gameAC(this.cx - TileMap.size, this.cy + 1);
                TileMap.gameAC(this.cx - TileMap.size, this.cy - 2);
            }

            if (TileMap.gameAA(this.cx + TileMap.size, this.cy + 1, 512)) {
                TileMap.gameAC(this.cx + TileMap.size, this.cy + 1);
                TileMap.gameAC(this.cx + TileMap.size, this.cy - 2);
            }
        }

    }

    public final void gameAB(Message var1) {
        try {
            this.gameAA(var1);
            getMyChar().eff5BuffHp = var1.gameAB().readShort();
            getMyChar().eff5BuffMp = var1.gameAB().readShort();
            int var2 = var1.gameAB().readUnsignedByte();
            Item var3;
            (var3 = this.arrItemMounts[var2]).typeUI = 3;
            this.arrItemMounts[var2] = null;
            var3.indexUI = var1.gameAB().readUnsignedByte();
            this.arrItemBag[var3.indexUI] = var3;
            if (var2 == 4) {
                this.isWolf = this.isMoto = this.gameCP = false;
            }

            GameScr.gameDK = false;
            GameScr.gI().gameBI();
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public final void gameAC(Message var1) {
        try {
            this.gameAA(var1);
            getMyChar().eff5BuffHp = var1.gameAB().readShort();
            getMyChar().eff5BuffMp = var1.gameAB().readShort();
            Item var2;
            (var2 = this.arrItemBody[var1.gameAB().readUnsignedByte()]).typeUI = 3;
            if (var2.indexUI == 1) {
                this.wp = 15;
            } else if (var2.indexUI == 2) {
                this.gameAP();
            } else if (var2.indexUI == 6) {
                this.gameAQ();
            }

            this.arrItemBody[var2.indexUI] = null;
            var2.indexUI = var1.gameAB().readUnsignedByte();
            getMyChar().head = var1.gameAB().readShort();
            this.arrItemBag[var2.indexUI] = var2;
            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().gameBI();
        } catch (Exception var3) {
            var3.printStackTrace();
            System.out.println("Char.itemBodyToBag()");
        }
    }

    public final void gameAD(Message var1) {
        try {
            int var2 = var1.gameAB().readUnsignedByte();
            int var5 = var1.gameAB().readUnsignedByte();
            Item var3;
            if ((var3 = this.arrItemBag[var2]) != null) {
                if (var3.template.type == 16) {
                    GameScr.gameAS -= var3.quantity;
                }

                if (var3.template.type == 17) {
                    GameScr.gameAR -= var3.quantity;
                }

                this.arrItemBag[var2] = null;
                if (this.arrItemBox[var5] == null) {
                    var3.indexUI = var5;
                    var3.typeUI = 4;
                    this.arrItemBox[var5] = var3;
                } else {
                    Item var10000 = this.arrItemBox[var5];
                    var10000.quantity += var3.quantity;
                }
            }

            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().gameBA();
        } catch (Exception var4) {
            var4.printStackTrace();
            System.out.println("Char.itemBagToBox()");
        }
    }

    public final void gameAE(Message var1) {
        try {
            int var2 = var1.gameAB().readUnsignedByte();
            int var5 = var1.gameAB().readUnsignedByte();
            Item var3;
            if ((var3 = this.arrItemBox[var2]) != null) {
                if (var3.template.type == 16) {
                    GameScr.gameAS += var3.quantity;
                }

                if (var3.template.type == 17) {
                    GameScr.gameAR += var3.quantity;
                }

                this.arrItemBox[var2] = null;
                if (this.arrItemBag[var5] == null) {
                    var3.indexUI = var5;
                    var3.typeUI = 3;
                    this.arrItemBag[var5] = var3;
                } else {
                    Item var10000 = this.arrItemBag[var5];
                    var10000.quantity += var3.quantity;
                }
            }

            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().gameBA();
        } catch (Exception var4) {
            var4.printStackTrace();
            System.out.println("Char.itemBoxToBag()");
        }
    }

    public static void gameAA(Message var0, boolean var1) {
        try {
            for (int var2 = 0; var2 < GameScr.gameCT.length; ++var2) {
                GameScr.gameCT[var2] = null;
            }

            byte var6 = var0.gameAB().readByte();
            Item var3;
            (var3 = new Item()).typeUI = 3;
            var3.indexUI = var0.gameAB().readByte();
            var3.template = ItemTemplates.gameAA(var0.gameAB().readShort());
            var3.isLock = var0.gameAB().readBoolean();
            var3.isExpires = var0.gameAB().readBoolean();
            var3.quantity = 1;
            if (var1) {
                getMyChar().xu = var0.gameAB().readInt();
            } else {
                getMyChar().yen = var0.gameAB().readInt();

                try {
                    getMyChar().xu = var0.gameAB().readInt();
                } catch (Exception var4) {
                }
            }

            GameScr.gameCT[0] = var3;
            GameScr.gameGG = GameScr.efs[53];
            GameScr.gameGF = 0;
            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().gameBB();
            GameCanvas.endDlg();
            if (var6 == 1) {
                getMyChar().arrItemBag[var3.indexUI] = var3;
                InfoMe.gameAA(mResources.gameFW + " " + var3.template.name);
            } else {
                InfoMe.gameAA(mResources.gameFV + " " + ItemTemplates.gameAA((short) (var3.template.id + 1)).name + " " + mResources.gameFY + " " + var3.template.name, 25, mFont.tahoma_7_red);
                GameScr.gameCT[0] = var3;
            }

            LockGame.gameAB();
        } catch (Exception var5) {
            var5.printStackTrace();
            System.out.println("Char.itemBagToBox()");
        }
    }

    private static void gameAA(Item var0, int var1) {
        int var2 = 0;
        if (var0 != null && var0.options != null) {
            for (int var3 = 0; var3 < var0.options.size(); ++var3) {
                ItemOption var4;
                (var4 = (ItemOption) var0.options.elementAt(var3)).active = 0;
                if (var4.optionTemplate.type == 2) {
                    if (var2 < var1) {
                        var4.active = 1;
                        ++var2;
                    }
                } else if (var4.optionTemplate.type == 3 && var0.upgrade >= 4) {
                    var4.active = 1;
                } else if (var4.optionTemplate.type == 4 && var0.upgrade >= 8) {
                    var4.active = 1;
                } else if (var4.optionTemplate.type == 5 && var0.upgrade >= 12) {
                    var4.active = 1;
                } else if (var4.optionTemplate.type == 6 && var0.upgrade >= 14) {
                    var4.active = 1;
                } 
//                else if (var4.optionTemplate.type == 7 && var0.upgrade >= 16) {
//                    var4.active = 1;
//                }
                else if (var4.optionTemplate.type == 7 && var0.upgrade >= 20) {
                    var4.active = 1;
                }
            }
        }

    }

    public final void gameAZ() {
        int var1 = 2;
        int var2 = 2;
        int var3 = 2;
        if (this.arrItemBody[0] == null) {
            --var1;
        }

        if (this.arrItemBody[6] == null) {
            --var1;
        }

        if (this.arrItemBody[5] == null) {
            --var1;
        }

        gameAA(this.arrItemBody[0], var1);
        gameAA(this.arrItemBody[6], var1);
        gameAA(this.arrItemBody[5], var1);
        if (this.arrItemBody[2] == null) {
            --var2;
        }

        if (this.arrItemBody[8] == null) {
            --var2;
        }

        if (this.arrItemBody[7] == null) {
            --var2;
        }

        gameAA(this.arrItemBody[2], var2);
        gameAA(this.arrItemBody[8], var2);
        gameAA(this.arrItemBody[7], var2);
        if (this.arrItemBody[4] == null) {
            --var3;
        }

        if (this.arrItemBody[3] == null) {
            --var3;
        }

        if (this.arrItemBody[9] == null) {
            --var3;
        }

        if (this.arrItemBody[1] != null) {
            ItemOption var4;
            if (this.arrItemBody[1].sys == this.gameAF()) {
                if (this.arrItemBody[1].options != null) {
                    for (var1 = 0; var1 < this.arrItemBody[1].options.size(); ++var1) {
                        if ((var4 = (ItemOption) this.arrItemBody[1].options.elementAt(var1)).optionTemplate.type == 2) {
                            var4.active = 1;
                        }
                    }
                }
            } else if (this.arrItemBody[1].options != null) {
                for (var1 = 0; var1 < this.arrItemBody[1].options.size(); ++var1) {
                    if ((var4 = (ItemOption) this.arrItemBody[1].options.elementAt(var1)).optionTemplate.type == 2) {
                        var4.active = 0;
                    }
                }
            }
        }

        gameAA(this.arrItemBody[4], var3);
        gameAA(this.arrItemBody[3], var3);
        gameAA(this.arrItemBody[9], var3);
    }

    public final void gameAA(int var1, int var2, boolean var3, int var4) {
        this.cHP -= var1;
        this.cMP -= var2;
        if (!this.me) {
            this.cHP = this.cHpNew;
        }

        if (this.cHP < 0) {
            this.cHP = 0;
        }

        if (this.cMP < 0) {
            this.cMP = 0;
        }

        if (this.cHP <= 0 && this.statusMe != 14 && this.statusMe != 5) {
            this.cHP = 1;
        }

        if (var1 <= 0) {
            if (this.me) {
                GameScr.gameAA("", this.cx, this.cy - this.ch, 7);
            } else {
                GameScr.gameAA("", this.cx, this.cy - this.ch, 4);
            }
        } else {
            GameScr.gameAA("-".concat(String.valueOf(var1)), this.cx, this.cy - this.ch, 0);
        }

        if (var1 > 0) {
            this.isInjure = 4;
        }

        if (var3) {
            if (var4 == 114) {
                ServerEffect.gameAA(32, this.cx, this.cy - this.chh, 1);
                return;
            }

            if (var4 == 115) {
                ServerEffect.gameAA(85, this.cx, this.cy, 1);
                return;
            }

            if (var4 == 139) {
                GameScr.gameFU = 1;
                GameScr.gameFV = 0;
                ServerEffect.gameAA(91, this, 2);
                return;
            }

            if (var4 == 144) {
                ServerEffect.gameAA(91, this, 1);
                return;
            }
        } else {
            this.gameAO(49);
        }

    }

    public final void gameAA(short var1, short var2) {
        this.wdx = var1;
        this.wdy = var2;
    }

    private void gameBY() {
        this.timeBocdau = 0;
        this.statusMe = 1;
        this.timeChatReturn = System.currentTimeMillis();
    }

    public final void gameBA() {
        this.cHP = this.cMaxHP;
        this.cMP = this.cMaxMP;
        this.gameBY();
        this.cp1 = this.cp2 = this.cp3 = 0;
        ServerEffect.gameAA(20, this, 2);
        GameScr.gI().center = null;
    }

    public final boolean gameAE(int var1) {
        if (this.arrItemBag == null) {
            return false;
        } else {
            for (int var2 = 0; var2 < this.arrItemBag.length; ++var2) {
                if (this.arrItemBag[var2] != null && this.arrItemBag[var2].template.type == var1 && this.arrItemBag[var2].template.level <= myChar.clevel) {
                    Service.gI().useItem(var2);
                    return true;
                }
            }

            return false;
        }
    }

    private static boolean gameBZ() {
        return TileMap.mapID == 1 || TileMap.mapID == 27 || TileMap.mapID == 72 || TileMap.mapID == 10 || TileMap.mapID == 17 || TileMap.mapID == 22 || TileMap.mapID == 32 || TileMap.mapID == 38 || TileMap.mapID == 43 || TileMap.mapID == 48;
    }

    public static boolean gameAB(Char var0) {
        if ((var0 == null || !var0.isNhanban) && var0 != null && getMyChar().myskill != null && getMyChar().myskill.template.type != 2 && getMyChar().myskill.template.type != 3 && (getMyChar().myskill.template.type != 4 || var0.statusMe == 14 || var0.statusMe == 5)) {
            if ((getMyChar().cTypePk == 4 && var0.cTypePk == 5 || getMyChar().cTypePk == 5 && var0.cTypePk == 4) && !gameAC(var0) && !gameBZ() || var0.cTypePk == 3 && !gameAC(var0) && !gameBZ() || getMyChar().cTypePk == 3 && !gameAC(var0) && !gameBZ() || getMyChar().cTypePk == 1 && var0.cTypePk == 1 && !gameAC(var0) && !gameBZ() || getMyChar().testCharId >= 0 && getMyChar().testCharId == var0.charID || getMyChar().killCharId >= 0 && getMyChar().killCharId == var0.charID && !gameBZ() || var0.killCharId >= 0 && var0.killCharId == getMyChar().charID && !gameBZ()) {
                return var0.statusMe != 14 && var0.statusMe != 5;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean gameAC(Char var0) {
        for (int var1 = 0; var1 < GameScr.vParty.size(); ++var1) {
            Party var2 = (Party) GameScr.vParty.elementAt(var1);
            if (var0.charID == var2.charId) {
                return true;
            }
        }

        return false;
    }

    public static void gameBB() {
        getMyChar().gameAC(21);
        getMyChar().taskMaint = null;

        for (int var0 = 0; var0 < getMyChar().arrItemBag.length; ++var0) {
            if (getMyChar().arrItemBag[var0] != null && (getMyChar().arrItemBag[var0].template.type == 25 || getMyChar().arrItemBag[var0].template.type == 23 || getMyChar().arrItemBag[var0].template.type == 24)) {
                getMyChar().arrItemBag[var0] = null;
            }
        }

        Npc.gameAA();
    }

    public static int gameBC() {
        if (pointChienTruong >= 4000) {
            return 4;
        } else if (pointChienTruong >= 1500) {
            return 3;
        } else if (pointChienTruong >= 600) {
            return 2;
        } else {
            return pointChienTruong >= 200 ? 1 : 0;
        }
    }

    public final boolean gameBD() {
        return this.isHuman;
    }

    public final boolean gameBE() {
        return this.isNhanban;
    }

    public static int reAA() {
        Item[] var0 = getMyChar().arrItemBag;
        int var1 = 0;

        for (int var2 = 0; var2 < var0.length; ++var2) {
            Item var3;
            if ((var3 = var0[var2]) != null && var3.template.type == 26 && var3.template.id <= 4) {
                var1 += GameScr.upClothe[var3.template.id];
            }
        }

        return var1;
    }

    public static Item gameAB(int var0, int var1) {
        Item[] var2 = getMyChar().arrItemBag;

        for (int var3 = 0; var3 < var2.length; ++var3) {
            Item var4;
            if ((var4 = var2[var3]) != null && var4.template.id == var0 && var4.quantity == var1) {
                return var4;
            }
        }

        return null;
    }

    public static Item gameAF(int var0) {
        Item[] var1 = getMyChar().arrItemBag;

        for (int var2 = 0; var2 < var1.length; ++var2) {
            Item var3;
            if ((var3 = var1[var2]) != null && var3.template.id == var0) {
                return var3;
            }
        }

        return null;
    }

    public static Item gameAG(int var0) {
        Item[] var1 = getMyChar().arrItemBag;

        for (int var2 = 0; var2 < var1.length; ++var2) {
            Item var3;
            if ((var3 = var1[var2]) != null && var3.template.id == var0 && !var3.isLock) {
                return var3;
            }
        }

        return null;
    }

    public static MyVector gameAH(int var0) {
        Item[] var1 = getMyChar().arrItemBag;
        MyVector var2 = new MyVector();

        for (int var3 = 0; var3 < var1.length; ++var3) {
            Item var4;
            if ((var4 = var1[var3]) != null && var4.template.id == var0) {
                var2.addElement(var4);
            }
        }

        return var2;
    }

    public static int gameAI(int var0) {
        Item[] var1 = getMyChar().arrItemBag;

        for (int var2 = 0; var2 < var1.length; ++var2) {
            if (var1[var2] != null && var1[var2].template.id == var0) {
                return var2;
            }
        }

        return -1;
    }

    public static boolean gameAJ(int var0) {
        Item[] var1 = getMyChar().arrItemBag;

        for (int var2 = 0; var2 < var1.length; ++var2) {
            if (var1[var2] != null && var1[var2].template.id == var0) {
                return true;
            }
        }

        return false;
    }

    public static int gameAK(int var0) {
        Item[] var1 = getMyChar().arrItemBag;
        int var2 = 0;

        for (int var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3] != null && var1[var3].template.id == var0) {
                if (var1[var3].template.isUpToUp) {
                    var2 += var1[var3].quantity;
                } else {
                    ++var2;
                }
            }
        }

        return var2;
    }

    public static int gameBG() {
        Item[] var0 = getMyChar().arrItemBag;
        int var1 = 0;

        for (int var2 = 0; var2 < var0.length; ++var2) {
            if (var0[var2] == null) {
                ++var1;
            }
        }

        return var1;
    }

    public static int gameBH() {
        Item[] var0 = getMyChar().arrItemBox;
        int var1 = 0;
        if (var0 != null) {
            for (int var2 = 0; var2 < var0.length; ++var2) {
                if (var0[var2] == null) {
                    ++var1;
                }
            }
        }

        return var1;
    }

    public static Item gameAL(int var0) {
        if (getMyChar().arrItemBox == null) {
            Service.gI().gameAI(4);
            LockGame.gameAS();
            System.out.println("Get box " + getMyChar().arrItemBox);
        }

        Item[] var1 = getMyChar().arrItemBox;

        for (int var2 = 0; var2 < var1.length; ++var2) {
            Item var3;
            if ((var3 = var1[var2]) != null && var3.template.id == var0) {
                return var3;
            }
        }

        return null;
    }

    public static TaskOrder gameAM(int var0) {
        for (int var1 = 0; var1 < getMyChar().taskOrders.size(); ++var1) {
            TaskOrder var2;
            if ((var2 = (TaskOrder) getMyChar().taskOrders.elementAt(var1)) != null && var2.taskId == var0) {
                return var2;
            }
        }

        return null;
    }

    public static boolean gameAC(int var0, int var1) {
        Char var2 = getMyChar();
        if (var0 == -1) {
            var0 = var2.cx;
        }

        if (var1 == -1) {
            var1 = var2.cy;
        }

        if (var0 == var2.cx && var1 == var2.cy) {
            return false;
        } else {
            int var3 = 0;
            int var4 = var2.cx;
            int var5 = TileMap.gameAA(var0, var1 - 12, 64) ? TileMap.gameAB(var1) - 24 : var1;
            int var6;
            if (var0 > var4) {
                while (true) {
                    var4 += 50;
                    if (var4 >= var0) {
                        break;
                    }

                    var6 = TileMap.gameAE(var4, var5);
                    Service.gI().gameAB(var4, var6);
                    ++var3;
                    if (var3 > 50) {
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException var8) {
                            var8.printStackTrace();
                        }
                    }
                }
            } else {
                while (true) {
                    var4 -= 50;
                    if (var4 <= var0) {
                        break;
                    }

                    var6 = TileMap.gameAE(var4, var5);
                    Service.gI().gameAB(var4, var6);
                    ++var3;
                    if (var3 > 50) {
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
            }

            Service.gI().gameAB(var0, var1);
            var2.timeSendmove = System.currentTimeMillis();
            var2.cx = var2.cxSend = var0;
            var2.cy = var2.cySend = var1;
            return true;
        }
    }

    public static boolean gameAD(int var0, int var1) {
        if (var0 == -1) {
            var0 = myChar.cx;
        }

        if (var1 == -1) {
            var1 = myChar.cy;
        }

        int[] var2 = new int[2];
        return !TileMap.gameAA(var0, var1, var2) ? false : gameAC(var2[0], var2[1]);
    }

    public static void gameAE(int var0, int var1) {
        int var2 = Res.abs(var0 - myChar.cx) / 50;
        int var3 = Res.abs(var1 - myChar.cy) / 10;
        int var4 = myChar.cx;
        int var5 = myChar.cy;
        if (var3 < 3) {
            Service.gI().gameAB(myChar.cx, var5 = var1 - 60);
            var3 = 3;
        }

        int var6;
        for (var6 = 0; var6 < var2; ++var6) {
            if (var0 > myChar.cx) {
                var4 += 50;
            } else {
                var4 -= 50;
            }

            Service.gI().gameAB(var4, var5);
        }

        Service.gI().gameAB(var0, var5);

        for (var6 = 0; var6 < var3; ++var6) {
            if (var1 > myChar.cy) {
                var5 += 10;
            } else {
                var5 -= 10;
            }

            Service.gI().gameAB(var0, var5);
        }

        Service.gI().gameAB(var0, var1);
        myChar.timeSendmove = System.currentTimeMillis();
        myChar.cx = myChar.cxSend = var0;
        myChar.cy = myChar.cySend = var1;
    }

    public static MyVector CheckItemBox(int var0) {
        Item[] var1 = getMyChar().arrItemBox;
        MyVector var2 = new MyVector();

        for (int var3 = 0; var3 < var1.length; ++var3) {
            Item var4;
            if ((var4 = var1[var3]) != null && var4.template.id == var0) {
                var2.addElement(var4);
            }
        }

        return var2;
    }

    static {
        loadData();
    }
}
