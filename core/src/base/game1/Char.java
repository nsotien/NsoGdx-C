package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;

public class Char extends MainObject {
   public Char chuthan;
   public Char pthan;
   public boolean isHuman;
   public boolean isNhanban;
   public boolean d;
   private int fm;
   private int fn;
   public long e;
   public ChatPopup f;
   public long cEXP;
   public long cExpDown;
   private int fo;
   private int fp;
   public int cx1;
   public int cy1;
   public int k;
   public int l;
   public int m;
   private int fq;
   private int fr;
   public int statusMe;
   public int cdir;
   public int idChar;
   public int cgender;
   public int ctaskId;
   public int cBonusSpeed;
   public int cspeed;
   public int cdame;
   public int cdameDown;
   public int cLevel;
   public int cMP;
   public int cMaxMP;
   public int cHP;
   public int cHpNew;
   public int cMaxHP;
   private int fs;
   public int eff5BuffHp;
   public int eff5BuffMp;
   public long ae;
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
   public int as;
   public int countFinishDay;
   public int countLoopBoos;
   public int limitTiemnangso;
   public int limitKynangso;
   public int ax;
   public int ay;
   public int countPB;
   public int[] potential;
   public String cName;
   public String cClanName;
   public byte ctypeClan;
   public static Clan be;
   public int bf;
   public int bg;
   public int bh;
   public int bi;
   public boolean bj;
   private boolean cmtoChar;
   public boolean bk;
   public boolean bl;
   private boolean fu;
   public int bm;
   private int fv;
   public boolean bn;
   public boolean bo;
   public boolean bp;
   private boolean fw;
   public boolean bq;
   public int xu;
   public int bs;
   public int yen;
   public int luong;
   public NClass nClass;
   public MyVector vSkill;
   public MyVector vSkillFight;
   public MyVector by;
   private MyVector fx;
   public Skill myskill;
   public Task ca;
   private boolean fy;
   public Item[] arrItemBag;
   public Item[] arrItemBox;
   public Item[] arrItemBody;
   public Item[] arrItemMounts;
   public Item[] cf;
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
   public MyVector focus;
   public Mob[] attMobs;
   public Char[] attChars;
   public short[] moveFast;
   public int db;
   public int dc;
   public byte dd;
   public int de;
   public int df;
   public int dg;
   private int fz;
   private int ga;
   public boolean dh;
   public static boolean dunghp = true;
   public static boolean dungmp = true;
   public static boolean dungthucan = true;
   public static boolean dunghotro;
   public static boolean dm;
   public static boolean dn;
   public static boolean doa;
   public static boolean dp;
   public static boolean dq;
   public static boolean dr;
   public static int ds = 50;
   public static int dt = 20;
   public static int du = 50;
   public static int dv;
   private long gb;
   public MyVector dw;
   public static int dx;
   public static int dy;
   private long gc;
   public long dz;
   public static final int[][][] ea = new int[][][]{{{0, -10, 32}, {1, -7, 7}, {1, -11, 15}, {1, -9, 45}}, {{0, -10, 33}, {1, -7, 7}, {1, -11, 16}, {1, -9, 46}}, {{1, -10, 33}, {2, -10, 11}, {2, -9, 16}, {1, -12, 49}}, {{1, -10, 32}, {3, -11, 9}, {3, -11, 16}, {1, -13, 47}}, {{1, -10, 34}, {4, -9, 9}, {4, -8, 16}, {1, -12, 47}}, {{1, -10, 34}, {5, -11, 11}, {5, -10, 17}, {1, -13, 49}}, {{1, -10, 33}, {6, -9, 9}, {6, -8, 16}, {1, -12, 47}}, {{0, -9, 36}, {7, -5, 15}, {7, -10, 21}, {1, -8, 49}}, {{4, -13, 26}, new int[3], new int[3], new int[3]}, {{5, -13, 25}, new int[3], new int[3], new int[3]}, {{6, -12, 26}, new int[3], new int[3], new int[3]}, {{7, -13, 25}, new int[3], new int[3], new int[3]}, {{0, -9, 35}, {8, -4, 13}, {8, -14, 27}, {1, -9, 49}}, {{0, -9, 31}, {9, -11, 8}, {10, -10, 17}, new int[3]}, {{2, -7, 33}, {9, -11, 8}, {11, -8, 15}, new int[3]}, {{2, -8, 32}, {9, -11, 8}, {12, -8, 14}, new int[3]}, {{2, -7, 32}, {9, -11, 8}, {13, -12, 15}, new int[3]}, {{0, -11, 31}, {9, -11, 8}, {14, -15, 18}, new int[3]}, {{2, -9, 32}, {9, -11, 8}, {15, -13, 19}, new int[3]}, {{2, -9, 31}, {9, -11, 8}, {16, -7, 22}, new int[3]}, {{2, -9, 32}, {9, -11, 8}, {17, -11, 18}, new int[3]}, {{3, -12, 34}, {8, -4, 13}, {8, -15, 25}, {1, -10, 46}}, {{0, -9, 32}, {8, -4, 9}, {10, -10, 18}, new int[3]}, {{2, -7, 34}, {8, -4, 9}, {11, -8, 16}, new int[3]}, {{2, -8, 33}, {8, -4, 9}, {12, -8, 15}, new int[3]}, {{2, -7, 33}, {8, -4, 9}, {13, -12, 16}, new int[3]}, {{0, -11, 32}, {7, -5, 9}, {14, -15, 19}, new int[3]}, {{2, -9, 33}, {7, -5, 9}, {15, -13, 20}, new int[3]}, {{2, -9, 32}, {7, -5, 9}, {16, -7, 23}, new int[3]}, {{2, -9, 33}, {7, -5, 9}, {17, -11, 19}, new int[3]}};
   private static Char myChar;
   private int ge;
   public int eb;
   public int ec;
   public int ed;
   public int ee;
   public MyVector ef;
   public static boolean eg;
   public static boolean eh;
   public boolean ei;
   public boolean ej;
   public boolean ek;
   public MovePoint el;
   private int gf;
   private boolean gg;
   public long gh;
   public int em;
   private long gi;
   private static boolean gj;
   private int gk;
   private int gl;
   private int gm;
   private int gn;
   private long go;
   private boolean gp;
   public static byte[] en;
   private long gq;
   private long timelastSendmove;
   private static short gs;
   public short head;
   public short leg;
   public short body;
   public short weapon;
   public short es;
   public short et;
   private int gt;
   public int eu;
   private EffectCharPaint gu;
   public EffectCharPaint ev;
   private int gv;
   private int gw;
   private int gx;
   private int gy;
   private int gz;
   private int ha;
   private int hb;
   private int hc;
   private int hd;
   private int he;
   private EffectCharPaint hf;
   private EffectCharPaint hg;
   private EffectCharPaint hh;
   public Arrow ew;
   public SkillPaint ex;
   public EffectPaint[] hi;
   private int hj;
   private byte hk;
   private static mHashtable hl;
   private int hm;
   private int hn;
   private int ho;
   private int hp;
   private int hq;
   private int hr;
   private int hs;
   private int ht;
   private int hu;
   private int[] hv;
   private int hw;
   private int hx;
   private int hy;
   private int hz;
   private int ia;
   private int ib;
   private int ic;
   private int id;
   private int ie;
   private int ifa;
   private int ig;
   private int ih;
   private int ii;
   private int ij;
   private int ik;
   private int il;
   private int im;
   private int in;
   public short ID_Body;
   public short ID_PP;
   public short ID_HAIR;
   public short ID_LEG;
   public short ID_HORSE;
   private short ID_NAME;
   private short ID_RANK;
   public short ID_MAT_NA;
   private short ID_Bien_Hinh;
   public short ID_WEA_PONE;
   public short ff;
   private byte ColorName;
   private static mFont[] is;
   private int it;
   private int iu;
   private int iv;
   private int iw;
   private byte[] ix;
   private int iy;
   private int iz;
   private short[] ja;
   private int jb;
   private int jc;
   private int jd;
   private int je;
   private byte jf;
   private byte jg;
   private int jh;
   private int ji;
   private byte jj;
   public static boolean fg;
   public static boolean autocl = false;
   public static boolean quaithuong = true;
   public static boolean quaitinhanh = true;
   public static boolean quaithulinh = true;
   public static boolean nepk;
   public static boolean chuyenmap = true;
   public static boolean danhtheonhom = true;
   public static boolean santatl = true;
   public static boolean tusathetmp = true;
   public static boolean automuathucan = true;
   public static boolean nhat_hpmp = true;
   public static boolean nhat_da;
   public static int lv_hpmp = 30;
   public static int lv_da = 5;
   public static boolean nhat_yen = true;
   public static int lv_luyenda = 7;
   public static boolean luyen_da;
   public static int lv_tbi;
   public static boolean nhat_tbi;
   public static boolean nhat_vpnv;
   public static boolean nhat_svc;
   public static boolean nhat_all = false;
   public static boolean remap = true;
   public static boolean reconnect = true;
   public static boolean dung_pthan = true;
   public static boolean autoCongTiemNang;
   public static boolean autoCongKyNang;
   public static boolean autottt;
   public static boolean autottc;
   public static boolean automuacl;
   public short fh;
   public short fi;
   public boolean fj;
   public Skill fk;
   public boolean fl;
   private int jk;
   private int jl;
   private int jm;
   private int jn;
   private int[][] jo;
   private int jp;
   private int jq;
   private int jr;

   public int ae() {
      return this.myskill != null ? this.myskill.ngang() : 0;
   }

   public int af() {
      return this.myskill != null ? this.myskill.cao() : 0;
   }

   public Char() {
      short[] var10000 = new short[]{-1, -1, -1, -1};
      this.fm = 0;
      this.fn = 0;
      this.cx1 = 24;
      this.cy1 = 24;
      this.statusMe = 5;
      this.cdir = 1;
      this.potential = new int[4];
      new MyVector();
      this.cClanName = "";
      this.bf = 22;
      this.bg = 32;
      this.bh = 11;
      this.bi = 16;
      this.bj = true;
      this.bn = false;
      this.bo = false;
      this.fw = false;
      this.bq = false;
      this.vSkill = new MyVector();
      this.vSkillFight = new MyVector();
      this.by = new MyVector();
      this.fx = new MyVector();
      this.fy = true;
      this.arrItemMounts = new Item[5];
      this.cf = new Item[5];
      this.focus = new MyVector();
      this.db = -9999;
      this.dc = -9999;
      this.gb = 0L;
      this.dw = new MyVector();
      this.ef = new MyVector();
      this.gf = 0;
      this.gh = System.currentTimeMillis();
      this.em = 0;
      this.go = 0L;
      this.gp = false;
      this.es = -1;
      this.et = -1;
      this.gt = -1;
      this.eu = -1;
      this.hf = null;
      this.hg = null;
      this.hh = null;
      this.ew = null;
      this.hm = 0;
      this.hn = 0;
      this.ho = 0;
      this.hp = 0;
      this.hq = 0;
      this.hr = 0;
      this.hs = 0;
      this.ht = 0;
      this.hu = 0;
      this.hv = new int[]{1715, 1737, 1714, 1738};
      this.ID_Body = -1;
      this.ID_PP = -1;
      this.ID_HAIR = -1;
      this.ID_LEG = -1;
      this.ID_HORSE = -1;
      this.ID_NAME = -1;
      this.ID_RANK = -1;
      this.ID_MAT_NA = -1;
      this.ID_Bien_Hinh = -1;
      this.ID_WEA_PONE = -1;
      this.ff = -1;
      this.ColorName = 0;
      this.ja = new short[]{2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
      this.jh = 0;
      this.ji = 0;
      this.jj = 2;
      this.jo = new int[][]{{3049, 3050}, {3051, 3051, 3052, 3052, 3053, 3053}, {3054}, {3055}, {3056}, {3049, 3049, 3049, 3050, 3050, 3050}};
      this.statusMe = 6;
   }

   public final int a() {
      if (this.nClass.a != 1 && this.nClass.a != 2) {
         if (this.nClass.a != 3 && this.nClass.a != 4) {
            return this.nClass.a != 5 && this.nClass.a != 6 ? 0 : 3;
         } else {
            return 2;
         }
      } else {
         return 1;
      }
   }

   public final int b() {
      if (Code.isFakeRun) {
         return Code.fakeRun;
      } else {
         return !this.bo && !this.bn ? this.cspeed : this.cspeed + 2;
      }
   }

   public final boolean c() {
      return this.nClass.a == 2 || this.nClass.a == 4 || this.nClass.a == 6;
   }

   public static Char getMyChar() {
      if (myChar == null) {
         (myChar = new Char()).bk = true;
         myChar.cmtoChar = true;
         myChar.timelastSendmove = System.currentTimeMillis();
      }

      return myChar;
   }

   public static void e() {
      dq = false;
      doa = false;
      dn = false;
      dm = false;
      dp = false;
      dr = false;
      myChar = null;
   }

   public final void a(Message var1) {
      try {
         this.cspeed = var1.b().readByte();
         this.cMaxHP = var1.b().readInt();
         this.cMaxMP = var1.b().readInt();
      } catch (Exception var3) {
         ;
         ;
      }

   }

   public static int getQuantityItem(int var0) {
      Item[] var1 = getMyChar().arrItemBag;
      int var2 = 0;

      for(int var3 = 0; var3 < var1.length; ++var3) {
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

   public final int getIndexBag(int paramInt) {
      for(int i1 = 0; i1 < this.arrItemBag.length; ++i1) {
         if (this.arrItemBag[i1] != null && this.arrItemBag[i1].template.id == paramInt) {
            return i1;
         }
      }

      return -1;
   }

   public static Item getItem(int var0) {
      Item[] var1 = getMyChar().arrItemBag;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Item var3;
         if ((var3 = var1[var2]) != null && var3.template.id == var0) {
            return var3;
         }
      }

      return null;
   }

   public final void f() {
      try {
         MyVector var1 = new MyVector();

         int var2;
         Item var3;
         for(var2 = 0; var2 < this.arrItemBag.length; ++var2) {
            if ((var3 = this.arrItemBag[var2]) != null && var3.template.isUpToUp && !var3.isExpires) {
               var1.addElement(var3);
            }
         }

         int var7;
         for(var2 = 0; var2 < var1.size(); ++var2) {
            if ((var3 = (Item)var1.elementAt(var2)) != null) {
               for(var7 = var2 + 1; var7 < var1.size(); ++var7) {
                  Item var5;
                  if ((var5 = (Item)var1.elementAt(var7)) != null && var3.template.equals(var5.template) && var3.isLock == var5.isLock) {
                     var3.quantity += var5.quantity;
                     this.arrItemBag[var5.indexUI] = null;
                     var1.setElementAt((Object)null, var7);
                  }
               }
            }
         }

         for(var2 = 0; var2 < this.arrItemBag.length; ++var2) {
            if (this.arrItemBag[var2] != null) {
               for(var7 = 0; var7 <= var2; ++var7) {
                  if (this.arrItemBag[var7] == null) {
                     this.arrItemBag[var7] = this.arrItemBag[var2];
                     this.arrItemBag[var7].indexUI = var7;
                     this.arrItemBag[var2] = null;
                     break;
                  }
               }
            }
         }
      } catch (Exception var6) {
         ;
         ;
      }

   }

   public final void g() {
      try {
         MyVector var1 = new MyVector();

         int var2;
         Item var3;
         for(var2 = 0; var2 < this.arrItemBox.length; ++var2) {
            if ((var3 = this.arrItemBox[var2]) != null && var3.template.isUpToUp && !var3.isExpires) {
               var1.addElement(var3);
            }
         }

         int var7;
         for(var2 = 0; var2 < var1.size(); ++var2) {
            if ((var3 = (Item)var1.elementAt(var2)) != null) {
               for(var7 = var2 + 1; var7 < var1.size(); ++var7) {
                  Item var5;
                  if ((var5 = (Item)var1.elementAt(var7)) != null && var3.template.equals(var5.template) && var3.isLock == var5.isLock) {
                     var3.quantity += var5.quantity;
                     this.arrItemBox[var5.indexUI] = null;
                     var1.setElementAt((Object)null, var7);
                  }
               }
            }
         }

         for(var2 = 0; var2 < this.arrItemBox.length; ++var2) {
            if (this.arrItemBox[var2] != null) {
               for(var7 = 0; var7 <= var2; ++var7) {
                  if (this.arrItemBox[var7] == null) {
                     this.arrItemBox[var7] = this.arrItemBox[var2];
                     this.arrItemBox[var7].indexUI = var7;
                     this.arrItemBox[var2] = null;
                     break;
                  }
               }
            }
         }
      } catch (Exception var6) {
         ;
         ;
      }

   }

   public final void a(int var1) {
      Item var2;
      int var3;
      Item var5;
      if ((var2 = this.arrItemBag[var1]).b()) {
         var2.isLock = true;
         var2.typeUI = 5;
         var5 = this.arrItemBody[var2.template.type];
         this.arrItemBag[var1] = null;
         if (var5 != null) {
            var5.typeUI = 3;
            this.arrItemBody[var2.template.type] = null;
            var5.indexUI = var1;
            this.arrItemBag[var1] = var5;
         }

         var2.indexUI = var2.template.type;
         this.arrItemBody[var2.indexUI] = var2;

         for(var3 = 0; var3 < this.arrItemBody.length; ++var3) {
            Item var6;
            if ((var6 = this.arrItemBody[var3]) != null) {
               if (var6.template.type == 1) {
                  this.weapon = var6.template.part;
               } else if (var6.template.type == 2) {
                  this.body = var6.template.part;
               } else if (var6.template.type == 6) {
                  this.leg = var6.template.part;
               }
            }
         }
      } else if (var2.c()) {
         var2.isLock = true;
         var2.typeUI = 41;
         this.arrItemBag[var1] = null;

         for(var3 = 0; var3 < this.arrItemMounts.length; ++var3) {
            int var4;
            if ((var4 = var2.template.type - 29) == var3) {
               if ((var5 = this.arrItemMounts[var4]) != null) {
                  var5.typeUI = 41;
                  this.arrItemMounts[var4] = null;
                  var5.indexUI = var1;
                  this.arrItemBag[var1] = var5;
               }

               var2.indexUI = var2.template.type;
               this.arrItemMounts[var4] = var2;
               return;
            }
         }
      }

   }

   public final Skill a(SkillTemplate var1) {
      for(int var2 = 0; var2 < this.vSkill.size(); ++var2) {
         Skill var3;
         if ((var3 = (Skill)this.vSkill.elementAt(var2)).template.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   public Skill findSkillById(int id) {
      for (int i = 0; i < vSkill.size(); i++) {
         Skill s = (Skill) vSkill.elementAt(i);
         if (s.template.id == id) return s;
      }
      return null;
   }

   private boolean ag() {
      int var1 = TileMap.t.size();

      for(byte var2 = 0; var2 < var1; ++var2) {
         Waypoint var3 = (Waypoint)TileMap.t.elementAt(var2);
         if (this.cx1 >= var3.a && this.cx1 <= var3.c && this.cy1 >= var3.b && this.cy1 <= var3.d) {
            return true;
         }
      }

      return false;
   }

   private static int b(int var0, int var1) {
      return Res.e(var0 - var1);
   }

   private void ah() {
      if (this.ID_HORSE == -1) {
         this.jh = 0;
         this.ji = 0;
      } else {
         DataSkillEff var1;
         if ((var1 = a(this.ID_HORSE, true)) != null && var1.d) {
            if (this.ix == null) {
               this.ix = var1.g;
            }

            this.jh = var1.p + var1.m[this.aw()];
            this.ji = var1.o + var1.l[this.aw()];
            if (this.cdir == 1) {
               this.ji = -this.ji;
            }

            if (this.statusMe != 1 && this.statusMe != 6) {
               if (this.statusMe != 2 && this.statusMe != 10) {
                  if (this.statusMe == 4) {
                     this.ix = var1.j;
                  } else if (this.statusMe == 3) {
                     this.ix = var1.i;
                  } else {
                     this.ix = var1.g;
                  }
               } else {
                  this.ix = var1.h;
               }
            } else {
               this.ix = var1.g;
            }

            if (GameCanvas.w % 3 == 0) {
               this.iw = (this.iw + 1) % this.ix.length;
               this.gm = var1.k[this.aw()];
            }

            this.bm = this.gm;
         }
      }

   }

   public void h() {
      DataSkillEff var2;
      if (this.ID_NAME > -1 && (var2 = a(this.ID_NAME, false)) != null && var2.c != null) {
         ++this.hx;
         if (this.hx > var2.c.length - 1) {
            this.hx = 0;
         }

         this.hw = var2.c[this.hx];
      }

      if (this.ID_RANK > -1 && (var2 = a(this.ID_RANK, false)) != null && var2.c != null) {
         ++this.hz;
         if (this.hz > var2.c.length - 1) {
            this.hz = 0;
         }

         this.hy = var2.c[this.hz];
      }

      if (this.ff > -1 && (var2 = a(this.ff, false)) != null && var2.c != null) {
         ++this.ih;
         if (this.ih > var2.c.length - 1) {
            this.ih = 0;
         }

         this.ig = var2.c[this.ih];
      }

      this.gk = this.cx1;
      this.gl = this.cy1;
      if (GameCanvas.w % 3 == 0 && (var2 = a(this.ID_HORSE, true)) != null && var2.d) {
         this.iz = (this.iz + 1) % var2.g.length;
      }

      if (this.arrItemBody != null && this.arrItemBody[10] == null && this.mobMe != null) {
         this.mobMe = null;
      }

      if (this.ID_Bien_Hinh > -1) {
         this.id = (this.id + 1) % 10;
      }

      if (this.ID_MAT_NA > -1) {
         this.ib = (this.ib + 1) % 9;
      }

      if (this.ID_WEA_PONE > -1) {
         this.ifa = (this.ifa + 1) % 10;
      }

      if (this.ID_LEG > -1) {
         this.ij = (this.ij + 1) % 10;
      }

      if (this.ID_Body > -1) {
         this.il = (this.il + 1) % 10;
      }

      if (this.ID_HAIR > -1) {
         this.in = (this.in + 1) % 10;
      }

      if (this.ID_PP > -1) {
         this.iu = (this.iu + 1) % 10;
      }

      int var3;
      int var7;
      if (this.bk && this.cHP > 0) {
         var7 = b(this.eb, this.cx1);
         var3 = b(this.ec, this.cy1);
         if ((var7 > 0 || var3 > 0) && (System.currentTimeMillis() - this.gi >= 250L || Code.isFakeRun)) {
            gj = true;
         }

         if (gj) {
            gj = false;
            if (!eg) {
               Service.gI().b(this.cx1, this.cy1);
            }

            this.gi = System.currentTimeMillis();
            this.eb = this.cx1;
            this.ec = this.cy1;
         }
      }

      if (this.ID_HORSE <= 0) {
         this.ji = 0;
         this.jh = 0;
      }

      Mob var10000;
      if (this.mobVithu != null) {
         if (this.mobVithu != null) {
            this.mobVithu.ab = this;
         }

         if (this.mobVithu.c() != null && this.mobVithu.c().d == 1) {
            if (Mob.a(this.mobVithu.x1, this.mobVithu.y1, this.cx1, this.cy1) > Mob.b[this.mobVithu.s].a + 100) {
               this.mobVithu.i = this.cx1 + (3 - GameCanvas.w % 6) * 6;
               this.mobVithu.j = this.cy1 - 60;
               var7 = this.mobVithu.i - this.mobVithu.x1;
               var3 = this.mobVithu.j - this.mobVithu.y1;
               if (var7 > 50 || var7 < -50) {
                  var10000 = this.mobVithu;
                  var10000.x1 += var7 / 10;
               }

               if (var3 > 50 || var3 < -50) {
                  var10000 = this.mobVithu;
                  var10000.y1 += var3 / 10;
               }
            }

            this.mobVithu.a();
         } else {
            if (this.mobVithu.status != 3) {
               if (this.cdir == -1) {
                  this.mobVithu.i = this.cx1 + 20;
                  this.mobVithu.j = this.cy1;
                  this.mobVithu.dir = this.cdir;
                  this.mobVithu.y1 = this.cy1 - 20;
               } else {
                  this.mobVithu.i = this.cx1 - 20;
                  this.mobVithu.j = this.cy1;
                  this.mobVithu.dir = this.cdir;
                  this.mobVithu.y1 = this.cy1 - 20;
               }

               var7 = this.mobVithu.i - this.mobVithu.x1;
               var3 = this.mobVithu.j - this.mobVithu.y1;
               if (var7 <= 50 && var7 >= -50) {
                  var10000 = this.mobVithu;
                  var10000.x1 += var7;
               } else {
                  var10000 = this.mobVithu;
                  var10000.x1 += var7 / 10;
               }

               if (var3 > 50 || var3 < -50) {
                  var10000 = this.mobVithu;
                  var10000.y1 += var3 / 10;
               }
            }

            this.mobVithu.a();
         }
      }

      if (this.mobMe != null) {
         if (this.mobMe != null && this.mobMe.s >= 236) {
            if (this.mobMe != null) {
               this.mobMe.ab = this;
            }

            if (this.mobMe.s != 122 && this.mobMe.s != 70 && (this.mobMe.c() == null || this.mobMe.c().d != 1)) {
               if (this.mobMe.status != 3) {
                  if (this.cdir == -1) {
                     this.mobMe.i = this.cx1 + 20;
                     this.mobMe.j = this.cy1;
                     this.mobMe.dir = this.cdir;
                     this.mobMe.y1 = this.cy1 - 20;
                  } else {
                     this.mobMe.i = this.cx1 - 20;
                     this.mobMe.j = this.cy1;
                     this.mobMe.dir = this.cdir;
                     this.mobMe.y1 = this.cy1 - 20;
                  }

                  var7 = this.mobMe.i - this.mobMe.x1;
                  var3 = this.mobMe.j - this.mobMe.y1;
                  if (var7 <= 50 && var7 >= -50) {
                     var10000 = this.mobMe;
                     var10000.x1 += var7;
                  } else {
                     var10000 = this.mobMe;
                     var10000.x1 += var7 / 10;
                  }

                  if (var3 > 50 || var3 < -50) {
                     var10000 = this.mobMe;
                     var10000.y1 += var3 / 10;
                  }
               }

               this.mobMe.a();
            } else {
               if (this.mobMe.status != 3) {
                  this.mobMe.i = this.cx1 + (3 - GameCanvas.w % 6) * 6;
                  this.mobMe.j = this.cy1 - 60;
               }

               this.mobMe.a();
            }
         } else if (this.mobMe.s == 122 || this.mobMe.s == 70 || this.mobMe.c() != null && this.mobMe.c().d == 1) {
            if (this.mobMe.status != 3) {
               this.mobMe.i = this.cx1 + (3 - GameCanvas.w % 6) * 6;
               this.mobMe.j = this.cy1 - 60;
               var7 = this.mobMe.i - this.mobMe.x1;
               var3 = this.mobMe.j - this.mobMe.y1;
               if (var7 > 50 || var7 < -50) {
                  var10000 = this.mobMe;
                  var10000.x1 += var7 / 10;
               }

               if (var3 > 50 || var3 < -50) {
                  var10000 = this.mobMe;
                  var10000.y1 += var3 / 10;
               }
            }

            this.mobMe.a();
         } else {
            if (this.mobMe.status != 3) {
               if (this.cdir == -1) {
                  this.mobMe.i = this.cx1 + 20;
                  this.mobMe.j = this.cy1;
                  this.mobMe.dir = this.cdir;
                  this.mobMe.y1 = this.cy1 - 20;
               } else {
                  this.mobMe.i = this.cx1 - 20;
                  this.mobMe.j = this.cy1;
                  this.mobMe.dir = this.cdir;
                  this.mobMe.y1 = this.cy1 - 20;
               }

               var7 = this.mobMe.i - this.mobMe.x1;
               var3 = this.mobMe.j - this.mobMe.y1;
               if (var7 <= 50 && var7 >= -50) {
                  var10000 = this.mobMe;
                  var10000.x1 += var7;
               } else {
                  var10000 = this.mobMe;
                  var10000.x1 += var7 / 10;
               }

               if (var3 > 50 || var3 < -50) {
                  var10000 = this.mobMe;
                  var10000.y1 += var3 / 10;
               }
            }

            this.mobMe.a();
         }
      }

      this.gg = false;
      if (this.dd > 0 && GameCanvas.w % 2 == 0) {
         --this.dd;
         if (this.dd == 30 || this.dd == 60) {
            this.dd = 0;
         }
      }

      if (this.myskill != null && (this.myskill.template.id == 77 || this.myskill.template.id == 73)) {
         this.aj();
      }

      this.aj();
      if (this.mobMe != null) {
         this.mobMe.a();
      }

      if (this.mobVithu != null) {
         this.mobVithu.a();
      }

      if (this.ew != null) {
         this.ew.a();
      }

      int var1;
      if (this.arrItemMounts[4] != null && this.arrItemMounts[4].options != null) {
         for(var1 = 0; var1 < this.arrItemMounts[4].options.size(); ++var1) {
            ItemOption var10;
            if ((var10 = (ItemOption)this.arrItemMounts[4].options.elementAt(var1)).c.a == 66) {
               this.em = var10.a;
            }
         }
      }

      if (this.bo && this.em < 500) {
         this.bo = false;
      }

      Domsang var11;
      Domsang var9;
      if (this.bo) {
         if (this.arrItemMounts[4].template.id == 443 && this.arrItemMounts[4].sys >= 2) {
            if (this.hv[1] == 1737) {
               int var20 = this.cdir;
               boolean var10001 = true;
               this.jl -= 5;
            }

            if (this.cdir != 1) {
               var11 = new Domsang(this.jk - 4, this.jl, 0);
               var9 = new Domsang(this.jk - 1, this.jl, 0);
            } else {
               var11 = new Domsang(this.jk + 4, this.jl, 0);
               var9 = new Domsang(this.jk + 1, this.jl, 0);
            }

            if (this.statusMe != 1 || this.statusMe != 6) {
               this.fx.addElement(var11);
               this.fx.addElement(var9);
            }
         }

         for(var1 = 0; var1 < this.fx.size(); ++var1) {
            (var11 = (Domsang)this.fx.elementAt(var1)).a();
            if (var11.a >= 6) {
               this.fx.removeElementAt(var1);
            }
         }
      } else if (this.bn) {
         if (this.arrItemMounts[4].template.id == 524 && this.arrItemMounts[4].sys >= 2) {
            if (this.cdir != 1) {
               var11 = new Domsang(this.jk, this.jl, 1);
               var9 = new Domsang(this.jm, this.jn, 1);
            } else {
               var11 = new Domsang(this.jk, this.jl, 1);
               var9 = new Domsang(this.jm, this.jn, 1);
            }

            if ((this.statusMe == 2 || this.statusMe == 10) && GameCanvas.w % 3 == 0) {
               this.fx.addElement(var11);
               this.fx.addElement(var9);
            }
         }

         for(var1 = 0; var1 < this.fx.size(); ++var1) {
            (var11 = (Domsang)this.fx.elementAt(var1)).a();
            if (var11.a >= 6) {
               this.fx.removeElementAt(var1);
            }
         }
      } else {
         for(var1 = 0; var1 < this.fx.size(); ++var1) {
            (var11 = (Domsang)this.fx.elementAt(var1)).a();
            if (var11.a >= 6) {
               this.fx.removeElementAt(var1);
            }
         }
      }

      Item var14;
      if (this.bk && dunghp && Code.mode == null && this.cHP < this.cMaxHP * ds / 100 && System.currentTimeMillis() - this.gh > 2000L && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
         if (this.by.size() == 0) {
            for(var1 = 0; var1 < this.arrItemBag.length; ++var1) {
               if ((var14 = this.arrItemBag[var1]) != null && var14.template.type == 16 && var14.template.level == ds) {
                  GameScr.gI();
                  GameScr.x();
                  this.gh = System.currentTimeMillis();
                  break;
               }
            }
         } else {
            for(var1 = 0; var1 < this.by.size() && ((Effect)getMyChar().by.elementAt(var1)).e.b != 17; ++var1) {
               if (var1 == this.by.size() - 1) {
                  GameScr.gI();
                  GameScr.x();
                  this.gh = System.currentTimeMillis();
               }
            }
         }
      }

      if (this.bk && dungthucan && GameCanvas.w % 10 == 0 && !GameScr.ct && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
         if (this.by.size() == 0) {
            for(var1 = 0; var1 < this.arrItemBag.length; ++var1) {
               if ((var14 = this.arrItemBag[var1]) != null && var14.template.type == 18 && var14.template.level == du) {
                  Service.gI().useItem(var1);
                  break;
               }
            }
         } else {
            for(var1 = 0; var1 < this.by.size() && ((Effect)getMyChar().by.elementAt(var1)).e.b != 0; ++var1) {
               if (var1 == this.by.size() - 1) {
                  for(var3 = 0; var3 < this.arrItemBag.length; ++var3) {
                     Item var4;
                     if ((var4 = this.arrItemBag[var3]) != null && var4.template.type == 18 && var4.template.level == du) {
                        Service.gI().useItem(var3);
                        break;
                     }
                  }
               }
            }
         }
      }

      int var19;
      Skill var13;
      if (this.bk && dunghotro && !TileMap.phong_ae && Code.mode == null && getMyChar().statusMe != 14 && getMyChar().statusMe != 5 && this.cHP > 0 && System.currentTimeMillis() - this.gb > 500L) {
         for(var1 = 0; var1 < this.vSkill.size(); ++var1) {
            boolean var16 = false;
            if (((var13 = (Skill)this.vSkill.elementAt(var1)).template.id < 67 || var13.template.id > 72) && var13.template.id != 6 && var13.template.id != 15 && var13 != null && var13.template.type == 2 && !var13.a()) {
               for(var19 = 0; var19 < this.by.size(); ++var19) {
                  Effect var5;
                  if ((var5 = (Effect)this.by.elementAt(var19)) != null && var5.e.c == var13.template.e) {
                     var16 = true;
                     break;
                  }
               }

               if (!var16) {
                  GameScr.gI().a(var13, true, false);
                  Service.gI().r();
                  this.i();
                  this.gb = System.currentTimeMillis();
                  break;
               }
            }
         }
      }

      if (this.bk && dungmp && Code.mode == null && this.cMP < this.cMaxMP * dt / 100 && GameCanvas.w % 4 == 0 && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
         GameScr.gI();
         GameScr.w();
      }

      Char var12;
      if (this.bk && dq && this.nClass.a == 6 && dv > 0 && getMyChar().statusMe != 14 && getMyChar().statusMe != 5 && (var12 = GameScr.e(dv)) != null && (var12.cHP <= 0 || var12.statusMe == 14 || var12.statusMe == 5 || dr)) {
         for(var7 = 0; var7 < this.vSkill.size(); ++var7) {
            if ((var13 = (Skill)getMyChar().vSkill.elementAt(var7)) != null && var13.template.type == 4) {
               if (Res.e(this.cx1 - var12.cx1) < var13.ngang() && Res.e(this.cy1 - var12.cy1) < var13.cao()) {
                  getMyChar().myskill = var13;
                  GameScr.gI().g(dv);
                  dr = false;
                  this.i();
               } else {
                  InfoMe.a(TextGame.rc, 20, mFont.i);
               }
               break;
            }
         }
      }

      if (this.cHP > 0) {
         for(var1 = 0; var1 < this.by.size(); ++var1) {
            Effect var17;
            if ((var17 = (Effect)this.by.elementAt(var1)).e.b != 0 && var17.e.b != 12) {
               if (var17.e.b != 4 && var17.e.b != 17) {
                  if (var17.e.b == 13) {
                     if (GameCanvas.y) {
                        this.cHP -= this.cMaxHP * 3 / 100;
                        if (this.cHP < 1) {
                           this.cHP = 1;
                        }
                     }
                  } else if (var17.e.b == 7) {
                     this.gg = true;
                  } else if (var17.e.b == 1) {
                     this.cHP = this.cHP;
                  }
               } else if (GameCanvas.y) {
                  this.cHP += var17.d;
               }
            } else if (GameCanvas.y) {
               this.cHP += var17.d;
               this.cMP += var17.d;
            }
         }

         if (this.gg) {
            ++this.gf;
         } else {
            this.gf = 0;
         }

         if (this.eff5BuffHp > 0 && GameCanvas.z) {
            this.cHP += this.eff5BuffHp;
         }

         if (this.eff5BuffMp > 0 && GameCanvas.z) {
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
         GameScr.r = this.cx1 - GameScr.k + GameScr.o * this.cdir;
         GameScr.s = this.cy1 - GameScr.l;
      }

      this.fv = (this.fv + 1) % 100;
      if (this.bk) {
         if (this.charFocus != null && (this.charFocus.ab() || !GameScr.vCharInMap.contains(this.charFocus))) {
            this.charFocus = null;
         }

         if (this.cx1 < 10) {
            this.k = 0;
            this.cx1 = 10;
         } else if (this.cx1 > TileMap.pxw - 10) {
            this.cx1 = TileMap.pxw - 10;
            this.k = 0;
         }

         if (!eg && this.ag()) {
            gj = true;
            Service.gI().c();
            eh = true;
            eg = true;
            GameCanvas.i();
            GameCanvas.h();
            return;
         }

         if (this.ek) {
            this.ek = System.currentTimeMillis() - this.gc < 2000L;
         }

         if (this.ei) {
            this.el = null;
         }

         if (this.el != null && (this.statusMe == 1 || this.statusMe == 2)) {
            this.statusMe = 2;
            if (this.cx1 - this.el.a > 0) {
               this.cdir = -1;
               if (this.cx1 - this.el.a <= 10) {
                  this.el = null;
               }
            } else {
               this.cdir = 1;
               if (this.cx1 - this.el.a >= -10) {
                  this.el = null;
               }
            }

            if (this.el != null) {
               this.k = this.b() * this.cdir;
               this.l = 0;
            }
         }

         if (Code.mode == null) {
            this.bl();
         }

         if (this.statusMe != 1 && this.statusMe != 6) {
            this.go = System.currentTimeMillis();
            this.gp = true;
         } else if (System.currentTimeMillis() - this.go > 500L && this.gp) {
            gj = true;
            this.gp = false;
            this.go = System.currentTimeMillis();
         }
      } else {
         if (GameCanvas.w % 20 == 0 && this.idChar >= 0) {
            for(var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
               Char var18 = null;

               try {
                  var18 = (Char)GameScr.vCharInMap.elementAt(var1);
               } catch (Exception var131) {
               }

               if (var18 != null) {
                  var18.equals(this);
               }
            }
         }

         if (this.statusMe == 1 || this.statusMe == 6) {
            boolean var15 = false;
            if (this.el != null) {
               if (f(this.el.a - this.cx1) < 4 && f(this.el.b - this.cy1) < 4) {
                  this.cx1 = this.el.a;
                  this.cy1 = this.el.b;
                  this.el = null;
                  if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) == 2) {
                     this.bn();
                     GameCanvas.gI().a(-1, this.cx1 - -8, this.cy1);
                     GameCanvas.gI().a(1, this.cx1 - 8, this.cy1);
                  } else {
                     this.statusMe = 4;
                     this.l = 0;
                  }

                  var15 = true;
               } else if (this.cy1 == this.el.b) {
                  if (this.cx1 != this.el.a) {
                     this.cx1 = (this.cx1 + this.el.a) / 2;
                     this.bm = GameCanvas.w % 5 + 2;
                  }
               } else if (this.cy1 < this.el.b) {
                  this.bm = 12;
                  this.cx1 = (this.cx1 + this.el.a) / 2;
                  if (this.l < 0) {
                     this.l = 0;
                  }

                  this.cy1 += this.l;
                  if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) == 2) {
                     GameCanvas.gI().a(-1, this.cx1 - -8, this.cy1);
                     GameCanvas.gI().a(1, this.cx1 - 8, this.cy1);
                  }

                  ++this.l;
                  if (this.l > 16) {
                     this.cy1 = (this.cy1 + this.el.b) / 2;
                  }
               } else {
                  this.bm = 7;
                  this.cx1 = (this.cx1 + this.el.a) / 2;
                  this.cy1 = (this.cy1 + this.el.b) / 2;
               }
            } else {
               var15 = true;
            }

            if (var15 && this.ef.size() > 0) {
               if (this.ef.size() > 5) {
                  this.el = (MovePoint)this.ef.lastElement();
                  this.ef.removeElementAt(0);
                  this.cx1 = this.el.a;
                  this.cy1 = this.el.b;
                  this.ef.removeAllElements();
                  this.statusMe = 6;
                  this.el = null;
                  return;
               }

               this.el = (MovePoint)this.ef.firstElement();
               this.ef.removeElementAt(0);
               if (this.el.c == 2) {
                  this.statusMe = 2;
                  if (this.cx1 - this.el.a > 0) {
                     this.cdir = -1;
                  } else if (this.cx1 - this.el.a < 0) {
                     this.cdir = 1;
                  }

                  this.k = 5 * this.cdir;
                  this.l = 0;
               } else if (this.el.c == 3) {
                  this.statusMe = 3;
                  GameCanvas.gI().a(-1, this.cx1 - -8, this.cy1);
                  GameCanvas.gI().a(1, this.cx1 - 8, this.cy1);
                  if (this.cx1 - this.el.a > 0) {
                     this.cdir = -1;
                  } else if (this.cx1 - this.el.a < 0) {
                     this.cdir = 1;
                  }

                  this.k = f(this.cx1 - this.el.a) / 9 * this.cdir;
                  this.l = -10;
               } else if (this.el.c == 4) {
                  this.statusMe = 4;
                  if (this.cx1 - this.el.a > 0) {
                     this.cdir = -1;
                  } else if (this.cx1 - this.el.a < 0) {
                     this.cdir = 1;
                  }

                  this.k = f(this.cx1 - this.el.a) / 9 * this.cdir;
                  this.l = 0;
               } else {
                  this.cx1 = this.el.a;
                  this.cy1 = this.el.b;
                  this.el = null;
               }
            }

            if (this.statusMe == 6) {
               if (this.bm >= 8 && this.bm <= 11) {
                  ++this.bm;
                  ++this.m;
                  if (this.bm > 11) {
                     this.bm = 8;
                  }

                  if (this.m > 5) {
                     this.bm = 0;
                  }
               }

               if (this.bm <= 1) {
                  ++this.m;
                  if (this.m > 6) {
                     this.bm = 0;
                  } else {
                     this.bm = 1;
                  }

                  if (this.m > 10) {
                     this.m = 0;
                  }
               }
            }

            this.fo = this.cx1;
            this.fp = this.cy1;
            if (System.currentTimeMillis() - this.dz > 7000L) {
               if (!this.bo && this.o() && this.em >= 500) {
                  this.bo = true;
                  ServerEffect.a(60, this, 1);
               }

               if (this.bn && this.p()) {
                  this.bn = false;
                  this.bp = true;
               }
            }
         }
      }

      if (this.hk > 0) {
         this.bm = 21;
         --this.hk;
      } else {
         switch (this.statusMe) {
            case 1:
               this.fw = false;
               this.fn = 0;
               if (this.bo) {
                  if (this.cdir == 1) {
                     this.jk = this.cx1 + 21 + 4;
                     this.jl = this.cy1 - 15;
                  } else {
                     this.jk = this.cx1 - 24 - 4;
                     this.jl = this.cy1 - 15;
                  }
               }

               var12 = this;

               for(var7 = 0; var7 < var12.fx.size(); ++var7) {
                  (var9 = (Domsang)var12.fx.elementAt(var7)).a();
                  if (var9.a >= 6) {
                     var12.fx.removeElementAt(var7);
                  }
               }

               var12.bl = false;
               var12.fu = false;
               var12.k = 0;
               var12.l = 0;
               ++var12.m;
               var12.fo = var12.cx1;
               var12.fp = var12.cy1;
               if (var12.m > 30) {
                  var12.m = 0;
               }

               if (var12.m % 15 < 5) {
                  var12.bm = 0;
               } else {
                  var12.bm = 1;
               }

               var12.bm();
               if (System.currentTimeMillis() - var12.dz > 7000L) {
                  if (!var12.bo && var12.o() && var12.em >= 500) {
                     var12.bo = true;
                     ServerEffect.a(60, var12, 1);
                  }

                  if (var12.bn && var12.p()) {
                     var12.bn = false;
                     var12.bp = true;
                  }
               }
               break;
            case 2:
               if (this.bn) {
                  ++this.fn;
                  if (this.arrItemMounts[4].template.id == 485 && this.arrItemMounts[4].sys >= 4) {
                     this.fw = true;
                  }

                  if (this.fn > 20) {
                     this.fw = false;
                  }
               }

               if (this.bo) {
                  if (this.cdir == 1) {
                     if (this.hv[this.hr] == 1737) {
                        this.jk = this.cx1 + 21 + 4;
                        this.jl = this.cy1 - 19;
                     } else {
                        this.jk = this.cx1 + 21 + 4;
                        this.jl = this.cy1 - 16;
                     }
                  } else if (this.hv[this.hr] == 1737) {
                     this.jk = this.cx1 - 24 - 4;
                     this.jl = this.cy1 - 19;
                  } else {
                     this.jk = this.cx1 - 24 - 4;
                     this.jl = this.cy1 - 16;
                  }
               } else if (this.bn) {
                  if (this.cdir == 1) {
                     this.jk = this.cx1 + 15;
                     this.jm = this.cx1 - 25;
                     this.jl = this.cy1;
                     this.jn = this.cy1;
                  } else {
                     this.jk = this.cx1 - 18;
                     this.jm = this.cx1 + 25;
                     this.jl = this.cy1;
                     this.jn = this.cy1;
                  }
               }

               var7 = 0;
               if (!this.bk && this.el != null) {
                  var7 = f(this.cx1 - this.el.a);
               }

               ++this.m;
               if (this.m >= 10) {
                  this.m = 0;
                  this.cBonusSpeed = 0;
               }

               this.bm = (this.m >> 1) + 2;
               if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1 - 1) & 64) == 64) {
                  this.cx1 += this.k >> 1;
               } else {
                  this.cx1 += this.k;
               }

               if (this.cdir == 1) {
                  if (GameScr.fb != 1) {
                     if (TileMap.tileTypeAt(this.cx1 + this.bh, this.cy1 - this.bi, 4)) {
                        if (this.bk) {
                           this.k = 0;
                           this.cx1 = TileMap.tileXofPixel(this.cx1 + this.bh) - this.bh;
                        } else {
                           this.an();
                        }
                     }
                  } else if (TileMap.tileTypeAt(this.cx1 + this.bh, this.cy1 - this.bi, 4)) {
                     if (this.bk) {
                        this.statusMe = 3;
                        if (this.statusMe == 3) {
                           this.l -= 10;
                        }
                     } else {
                        this.an();
                     }
                  }
               } else if (GameScr.fb != 1) {
                  if (TileMap.tileTypeAt(this.cx1 - this.bh - 1, this.cy1 - this.bi, 8)) {
                     if (this.bk) {
                        this.k = 0;
                        this.cx1 = TileMap.tileXofPixel(this.cx1 - this.bh - 1) + TileMap.size + this.bh;
                     } else {
                        this.an();
                     }
                  }
               } else if (TileMap.tileTypeAt(this.cx1 - this.bh - 1, this.cy1 - this.bi, 8)) {
                  if (this.bk) {
                     this.statusMe = 3;
                     if (this.statusMe == 3) {
                        this.l -= 10;
                     }
                  } else {
                     this.an();
                  }
               }

               if (!this.bq && this.ad()) {
                  this.bq = true;
                  this.bp = false;
               }

               if (!this.bn && this.p()) {
                  this.bn = true;
                  this.bp = false;
               }

               if (!this.bo && this.o() && this.em >= 500) {
                  this.gz = Res.e(this.cx1 - this.fo);
                  this.hc = Res.e(this.cy1 - this.fp);
                  this.gz = this.gz > this.hc ? this.gz : this.hc;
                  if (this.bk && this.gz > 150 || !this.bk && this.gz > 40) {
                     this.bo = true;
                     ServerEffect.a(60, this, 1);
                  }

                  this.gz = this.hc = 0;
               }

               if (this.bk) {
                  if (this.k > 0) {
                     --this.k;
                  } else if (this.k < 0) {
                     ++this.k;
                  } else {
                     this.bn();
                     this.cBonusSpeed = 0;
                  }
               }

               if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) != 2) {
                  if (this.bk) {
                     if ((this.cx1 - this.eb != 0 || this.cy1 - this.ec != 0) && this.bk) {
                        this.bm = 7;
                        this.statusMe = 4;
                        this.k = 3 * this.cdir;
                        this.fq = 0;
                     }
                  } else {
                     this.an();
                  }
               }

               if (!this.bk && this.el != null && f(this.cx1 - this.el.a) > var7) {
                  this.an();
               }

               if (!this.bn && !this.bq) {
                  GameCanvas.gI().a(this.cdir, this.cx1 - (this.cdir << 3), this.cy1);
               } else if (GameCanvas.w % 5 == 0) {
                  ServerEffect.a(120, this.cx1 - (this.cdir << 5), this.cy1, 0, (byte)this.cdir);
               }

               this.bm();
               var19 = this.cx1 - (this.cdir << 4);
               var3 = this.cy1;
               if (this.bo && this.arrItemMounts[4].sys >= 4 && this.a() > 0 && GameCanvas.w % 8 == 0) {
                  if (this.a() == 1) {
                     ServerEffect.a(116, var19, var3, 2);
                  } else if (this.a() == 2) {
                     ServerEffect.a(117, var19, var3, 2);
                  } else if (this.a() == 3) {
                     ServerEffect.a(118, var19, var3, 2);
                  }
               }
               break;
            case 3:
               this.fw = false;
               this.fn = 0;
               if (this.bo) {
                  if (this.cdir == 1) {
                     this.jk = this.cx1 + 21 + 4;
                     this.jl = this.cy1 - 30;
                  } else {
                     this.jk = this.cx1 - 23 - 4;
                     this.jl = this.cy1 - 30;
                  }
               }

               this.ao();
               break;
            case 4:
               this.fw = false;
               this.fn = 0;
               if (this.bo) {
                  if (this.cdir == 1) {
                     this.jk = this.cx1 + 21 + 4;
                     this.jl = this.cy1 - 19;
                  } else {
                     this.jk = this.cx1 - 24;
                     this.jl = this.cy1 - 20;
                  }
               }

               this.ap();
               break;
            case 5:
               this.fw = false;
               this.fn = 0;
               this.ak();
               break;
            case 6:
               this.fw = false;
               this.fn = 0;
               if (this.bm == 21 && this.hk <= 0) {
                  this.bm = 0;
               }
            case 7:
            case 8:
            default:
               break;
            case 9:
               this.fw = false;
               this.fn = 0;
               this.am();
               break;
            case 10:
               this.fw = false;
               this.fn = 0;
               this.aq();
               break;
            case 11:
               this.fw = false;
               this.fn = 0;
               this.ar();
               break;
            case 12:
               this.fw = false;
               this.fn = 0;
               this.al();
               break;
            case 13:
               this.fw = false;
               this.fn = 0;
               break;
            case 14:
               this.fw = false;
               this.fn = 0;
         }
      }

      if (this.fh != 0 || this.fi != 0) {
         this.b(this.fh, this.fi);
         this.fh = 0;
         this.fi = 0;
      }

      if (this.moveFast != null) {
         if (this.moveFast[0] == 0) {
            ++this.moveFast[0];
            ServerEffect.a(60, this, 1);
         } else if (this.moveFast[0] < 10) {
            ++this.moveFast[0];
         } else {
            this.cx1 = this.moveFast[1];
            this.cy1 = this.moveFast[2];
            this.moveFast = null;
            ServerEffect.a(60, this, 1);
            if (this.bk) {
               if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) != 2) {
                  this.statusMe = 4;
                  getMyChar().b(GameScr.aa[38], 1);
               } else {
                  getMyChar().b(GameScr.aa[38], 0);
               }
            }
         }
      }

      if (!this.bk && this.ef.size() == 0 && this.ed != 0 && this.ee != 0 && this.el == null) {
         if (this.ed != this.cx1) {
            this.cx1 = this.ed;
         }

         if (this.ee != this.cy1) {
            this.cy1 = this.ee;
         }

         if (this.cHP > 0) {
            this.statusMe = 6;
         }
      }

      ++this.fm;
      if (this.fm > 5) {
         this.fm = 0;
      }

      this.ai();
      this.a1((byte)0, this.statusMe);
      if (this.ID_HORSE > 0) {
         this.bq = false;
         this.bn = false;
         this.bo = false;
      }

      this.bp();
      this.ah();
   }

   private void ai() {
      if (!this.bk) {
         if (this.bm == 12 && this.gk == this.cx1 && this.gl == this.cy1) {
            ++this.gn;
         } else if (this.bm == 0 && (TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) != 2) {
            ++this.gn;
         } else {
            this.gn = 0;
         }

         if (this.gn > 1) {
            for(int var1 = this.cy1; var1 < this.cy1 + 150; var1 += 24) {
               if ((TileMap.tileTypeAtPixel(this.cx1, var1) & 2) != 2) {
                  if ((var1 = TileMap.tileYofPixel(var1) + 24) - this.cy1 > 24) {
                     this.cy1 += (var1 - this.cy1) / 2;
                     if (!this.bn && !this.bo && !this.bq) {
                        this.bm = 12;
                     }

                     this.ef.removeAllElements();
                     this.el = null;
                  } else {
                     this.statusMe = 1;
                     this.ef.removeAllElements();
                     this.el = null;
                     this.k = 0;
                     this.l = 0;
                     this.m = 0;
                     this.fq = 0;
                     this.fr = 0;
                     this.gn = 0;
                     this.ed = 0;
                     this.ee = 0;
                     this.cy1 = var1;
                  }

                  this.fp = this.cy1;
                  return;
               }
            }
         }
      }

   }

   private void aj() {
      if (this.statusMe != 14 && this.statusMe != 5) {
         if (this.ex != null && this.mobFocus != null && this.mobFocus.status == 0) {
            if (!this.bk) {
               if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) == 2) {
                  this.bn();
               } else {
                  this.statusMe = 6;
               }
            }

            this.gv = 0;
            this.ex = null;
            this.hf = this.hg = this.hh = null;
            this.gw = this.gx = this.gy = 0;
            this.mobFocus = null;
            this.hi = null;
            this.ew = null;
         }

         if (this.ex != null && this.ew == null && this.gv >= this.as().length) {
            if (!this.bk) {
               if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) == 2) {
                  this.bn();
               } else {
                  this.statusMe = 6;
               }
            }

            this.gv = 0;
            this.ex = null;
            this.hf = this.hg = this.hh = null;
            this.gw = this.gx = this.gy = 0;
            this.ew = null;
         }

         SkillInfoPaint[] var1;
         if ((var1 = this.as()) != null) {
            if (this.bk && this.myskill.template.type == 2) {
               if (this.gv == var1.length - var1.length / 3) {
                  Service.gI().r();
                  this.i();
                  return;
               }
            } else if ((this.mobFocus != null || !this.bk && this.charFocus != null || this.bk && this.charFocus != null && this.b(this.charFocus)) && this.ew == null && this.gv == var1.length - var1.length / 3) {
               this.n();
               if (this.bk) {
                  this.i();
               }
            }
         }
      }

   }

   public final void i() {
      if (System.currentTimeMillis() - this.gq > 500L) {
         if (this.myskill.template.type != 1 && this.fk != null) {
            this.myskill = this.fk;
            Service.gI().selectSkill(this.myskill.template.id);
         }

         if (this.fl) {
            if (this.fk != null) {
               this.myskill = this.fk;
               Service.gI().selectSkill(this.myskill.template.id);
            }
         } else if (GameScr.fb != 1) {
            this.fk = this.myskill;
         }

         this.gq = System.currentTimeMillis();
      }

   }

   private void ak() {
      ++this.m;
      this.cx1 += (this.fq - this.cx1) / 4;
      if (this.m > 7) {
         this.cy1 += (this.fr - this.cy1) / 4;
      } else {
         this.cy1 += this.m - 10;
      }

      if (Res.e(this.fq - this.cx1) < 4 && Res.e(this.fr - this.cy1) < 10) {
         this.cx1 = this.fq;
         this.cy1 = this.fr;
         this.statusMe = 14;
         this.n(60);
         if (this.bk) {
            GameScr.gI().v();
         }
      }

      this.bm = 21;
   }

   private void al() {
      ++this.m;
      if (this.cdir == 1) {
         if ((TileMap.tileTypeAtPixel(this.cx1 + this.bh, this.cy1 - this.bi) & 4) == 4) {
            this.k = 0;
         }
      } else if ((TileMap.tileTypeAtPixel(this.cx1 - this.bh, this.cy1 - this.bi) & 8) == 8) {
         this.k = 0;
      }

      if (this.cy1 > this.bg && TileMap.tileTypeAt(this.cx1, this.cy1 - this.bg, 8192)) {
         if (!TileMap.tileTypeAt(this.cx1, this.cy1, 2)) {
            this.statusMe = 4;
            this.m = 0;
            this.fq = 0;
            this.l = 1;
         } else {
            this.cy1 = TileMap.tileYofPixel(this.cy1);
         }
      }

      this.cx1 += this.k;
      this.cy1 += this.l;
      if (this.cy1 < 0) {
         this.cy1 = this.l = 0;
      }

      if (this.l == 0) {
         if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) != 2) {
            this.statusMe = 4;
            this.k = (this.b() >> 1) * this.cdir;
            this.m = this.fq = 0;
         }
      } else if (this.l < 0) {
         ++this.l;
         if (this.l == 0) {
            this.l = 1;
         }
      } else {
         if (this.l < 20 && this.m % 5 == 0) {
            ++this.l;
         }

         if (this.l > 3) {
            this.l = 3;
         }

         if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1 + 3) & 2) == 2 && this.cy1 <= TileMap.tileXofPixel(this.cy1 + 3)) {
            this.k = this.l = 0;
            this.cy1 = TileMap.tileXofPixel(this.cy1 + 3);
         }

         if (TileMap.tileTypeAt(this.cx1, this.cy1, 64) && this.cy1 % TileMap.size > 8) {
            this.statusMe = 10;
            this.k = this.cdir << 1;
            this.l >>= 2;
            this.cy1 = TileMap.tileYofPixel(this.cy1) + 12;
            this.statusMe = 11;
            return;
         }

         if (TileMap.tileTypeAt(this.cx1, this.cy1, 2048)) {
            this.statusMe = 11;
            return;
         }
      }

      if (this.k > 0) {
         --this.k;
      } else if (this.k < 0) {
         ++this.k;
      }

   }

   private void am() {
      this.cx1 += this.k * this.cdir;
      this.cy1 += this.ge;
      ++this.ge;
      if (this.m == 0) {
         this.bm = 7;
      } else {
         this.bm = 23;
      }

      if (this.bj) {
         if (this.ge == -3) {
            this.bm = 8;
         } else if (this.ge == -2) {
            this.bm = 9;
         } else if (this.ge == -1) {
            this.bm = 10;
         } else if (this.ge == 0) {
            this.bm = 11;
         }
      }

      if (this.ge == 0) {
         this.statusMe = 6;
         ((MovePoint)this.ef.firstElement()).c = 4;
         this.m = 0;
         this.l = 1;
      }

   }

   private void an() {
      this.statusMe = 6;
      this.k = 0;
      this.l = 0;
      this.m = this.fq = 0;
   }

   private static int f(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   private void ao() {
      if (GameScr.fb == 1) {
         if (this.cdir == 1) {
            this.k = 5;
         } else {
            this.k = -5;
         }
      }

      if (this.ad()) {
         this.bq = true;
         this.bp = false;
      }

      if (this.p()) {
         this.bn = true;
         this.bp = false;
      }

      this.cx1 += this.k;
      this.cy1 += this.l;
      if (this.cy1 < 0) {
         this.cy1 = 0;
         this.l = -1;
      }

      ++this.l;
      if (!this.bk && this.el != null) {
         label115: {
            int var1;
            if ((var1 = this.el.a - this.cx1) > 0) {
               if (this.k > var1) {
                  this.k = var1;
               }

               if (this.k >= 0) {
                  break label115;
               }
            } else if (var1 < 0) {
               if (this.k < var1) {
                  this.k = var1;
               }

               if (this.k <= 0) {
                  break label115;
               }
            }

            this.k = var1;
         }
      }

      if (this.m == 0) {
         this.bm = 7;
      } else {
         this.bm = 23;
      }

      if (this.bj) {
         if (this.l == -3) {
            this.bm = 8;
         } else if (this.l == -2) {
            this.bm = 9;
         } else if (this.l == -1) {
            this.bm = 10;
         } else if (this.l == 0) {
            this.bm = 11;
         }
      }

      if (this.cdir == 1) {
         if ((TileMap.tileTypeAtPixel(this.cx1 + this.bh, this.cy1 - 1) & 4) == 4 && this.cx1 <= TileMap.tileXofPixel(this.cx1 + this.bh) + 12) {
            this.cx1 = TileMap.tileXofPixel(this.cx1 + this.bh) - this.bh;
            this.k = 0;
         }
      } else if ((TileMap.tileTypeAtPixel(this.cx1 - this.bh, this.cy1 - 1) & 8) == 8 && this.cx1 >= TileMap.tileXofPixel(this.cx1 - this.bh) + 12) {
         this.cx1 = TileMap.tileXofPixel(this.cx1 + 24 - this.bh) + this.bh;
         this.k = 0;
      }

      if (this.l == 0) {
         if (this.bk) {
            this.fs = this.cy1;
            this.statusMe = 4;
            this.m = 0;
            if (this.bj) {
               this.fq = 1;
            } else {
               this.fq = 0;
            }

            this.l = 1;
         } else {
            this.an();
         }
      }

      if (this.bk && !eg && this.ag()) {
         eg = true;
         gj = true;
         Service.gI().c();
         eh = true;
         GameCanvas.i();
         GameCanvas.h();
      } else {
         if (this.fr < 0) {
            ++this.fr;
         }

         if (this.cy1 > this.bg && TileMap.tileTypeAt(this.cx1, this.cy1 - this.bg, 8192)) {
            if (this.bk) {
               this.statusMe = 4;
               this.m = 0;
               this.fq = 0;
               this.l = 1;
            } else {
               this.an();
            }
         }

         if (!this.bk && this.el != null && this.cy1 < this.el.b) {
            this.an();
         }
      }

   }

   private void ap() {
      if (this.cy1 + 4 >= TileMap.pxh) {
         this.bn();
         this.k = this.l = 0;
      } else {
         if (this.cy1 % 24 == 0 && (TileMap.tileTypeAtPixel(this.cx1, this.cy1) & 2) == 2) {
            if (this.bk) {
               this.k = this.l = 0;
               this.m = this.fq = 0;
               this.bn();
               return;
            }

            this.an();
            this.bm = 0;
            GameCanvas.gI().a(-1, this.cx1 - -8, this.cy1);
            GameCanvas.gI().a(1, this.cx1 - 8, this.cy1);
         }

         this.bm = 12;
         this.cx1 += this.k;
         if (!this.bk && this.el != null) {
            label118: {
               int var1;
               if ((var1 = this.el.a - this.cx1) > 0) {
                  if (this.k > var1) {
                     this.k = var1;
                  }

                  if (this.k >= 0) {
                     break label118;
                  }
               } else if (var1 < 0) {
                  if (this.k < var1) {
                     this.k = var1;
                  }

                  if (this.k <= 0) {
                     break label118;
                  }
               }

               this.k = var1;
            }
         }

         this.cy1 += this.l;
         if (this.l < 20) {
            ++this.l;
         }

         if (this.cdir == 1) {
            if ((TileMap.tileTypeAtPixel(this.cx1 + this.bh, this.cy1 - 1) & 4) == 4 && this.cx1 <= TileMap.tileXofPixel(this.cx1 + this.bh) + 12) {
               this.cx1 = TileMap.tileXofPixel(this.cx1 + this.bh) - this.bh;
               this.k = 0;
            }
         } else if ((TileMap.tileTypeAtPixel(this.cx1 - this.bh, this.cy1 - 1) & 8) == 8 && this.cx1 >= TileMap.tileXofPixel(this.cx1 - this.bh) + 12) {
            this.cx1 = TileMap.tileXofPixel(this.cx1 + 24 - this.bh) + this.bh;
            this.k = 0;
         }

         if (this.l > 4 && (this.fs == 0 || this.fs <= TileMap.tileYofPixel(this.cy1 + 3)) && (TileMap.tileTypeAtPixel(this.cx1, this.cy1 + 3) & 2) == 2) {
            if (this.bk) {
               this.fs = 0;
               this.k = this.l = 0;
               this.m = this.fq = 0;
               this.cy1 = TileMap.tileXofPixel(this.cy1 + 3);
               this.bn();
               GameCanvas.gI().a(-1, this.cx1 - -8, this.cy1);
               GameCanvas.gI().a(1, this.cx1 - 8, this.cy1);
            } else {
               this.an();
               this.cy1 = TileMap.tileXofPixel(this.cy1 + 3);
               this.bm = 0;
               GameCanvas.gI().a(-1, this.cx1 - -8, this.cy1);
               GameCanvas.gI().a(1, this.cx1 - 8, this.cy1);
            }
         } else {
            if (this.fq == 1) {
               if (this.l == 3) {
                  this.bm = 11;
               } else if (this.l == 2) {
                  this.bm = 8;
               } else if (this.l == 1) {
                  this.bm = 9;
               } else if (this.l == 0) {
                  this.bm = 10;
               }
            } else {
               this.bm = 12;
            }

            if (this.l > 6 && TileMap.tileTypeAt(this.cx1, this.cy1, 64) && this.cy1 % TileMap.size > 8) {
               this.cy1 = TileMap.tileYofPixel(this.cy1) + 8;
               this.statusMe = 10;
               this.k = this.cdir << 1;
               this.l >>= 2;
               this.cy1 = TileMap.tileYofPixel(this.cy1) + 12;
            }

            if (!this.bk) {
               if ((TileMap.tileTypeAtPixel(this.cx1, this.cy1 + 1) & 2) == 2) {
                  this.bm = 0;
               }

               if (this.el != null && this.cy1 > this.el.b) {
                  this.an();
               }
            }
         }
      }

   }

   private void aq() {
      if (!TileMap.tileTypeAt(this.cx1, this.cy1, 64)) {
         this.statusMe = 4;
      }

      ++this.m;
      if (this.m >= 5) {
         this.m = 0;
         this.cBonusSpeed = 0;
      }

      this.bm = this.m + 2;
      if (this.cdir == 1) {
         if (TileMap.tileTypeAt(this.cx1 + this.bh, this.cy1 - 1, 4)) {
            this.k = 0;
            this.cx1 = TileMap.tileXofPixel(this.cx1 + this.bh) - this.bh;
         }
      } else if (TileMap.tileTypeAt(this.cx1 - this.bh - 1, this.cy1 - 1, 8)) {
         this.k = 0;
         this.cx1 = TileMap.tileXofPixel(this.cx1 - this.bh - 1) + TileMap.size + this.bh;
      }

      this.cx1 += this.k;
      if (this.k > 0) {
         --this.k;
      } else if (this.k < 0) {
         ++this.k;
      } else if (this.cx1 - this.eb != 0) {
         if (this.bk && System.currentTimeMillis() - (this.timelastSendmove + (long)gs) >= 0L) {
            gj = true;
         }

         this.statusMe = 11;
         this.cBonusSpeed = 0;
      }

      GameCanvas.gI();
      GameCanvas.d(this.cx1, this.cy1);
      GameCanvas.gI().a(this.cdir, this.cx1 - (this.cdir << 3), this.cy1);
   }

   private void ar() {
      this.cy1 += this.l;
      if (this.l < 20 && GameCanvas.w % 2 == 0) {
         ++this.l;
      }

      this.bm = 7;
      if (this.cy1 >= TileMap.pxh) {
         this.cHP = 0;
         this.statusMe = 5;
      } else if (TileMap.tileTypeAt(this.cx1, this.cy1, 2)) {
         this.bn();
         this.k = this.l = 0;
         this.m = this.fq = 0;
         this.cy1 = TileMap.tileXofPixel(this.cy1);
      } else if (TileMap.tileTypeAt(this.cx1, this.cy1, 2048)) {
         this.cHP = 0;
         this.statusMe = 5;
      }

   }

   public final void j() {
      this.weapon = 15;
      this.l();
      this.m();
   }

   public final void k() {
      this.weapon = 15;
   }

   public static Part b(int var0) {
      try {
         return var0 == 0 ? GameScr.ac[27] : GameScr.ac[2];
      } catch (Exception var2) {
         return null;
      }
   }

   public final void l() {
      if (this.cgender == 0) {
         this.body = 10;
      } else {
         this.body = 1;
      }

   }

   public final void m() {
      if (this.cgender == 0) {
         this.leg = 9;
      } else {
         this.leg = 0;
      }

   }

   public final void a(SkillPaint var1, int var2) {
      long var3 = System.currentTimeMillis();
      if (this.bk) {
         if (var3 - this.myskill.lastTimeUseThisSkill < (long)this.myskill.coolDown) {
            this.myskill.l = true;
            return;
         }

         this.myskill.lastTimeUseThisSkill = var3;
         this.cMP -= this.myskill.manaUse;
         if (this.cMP < 0) {
            this.cMP = 0;
         }
      }

      this.b(var1, var2);
   }

   public void b(SkillPaint var1, int var2) {
      // [FIX 12] Bỏ chặn global dongbang_skill ở đây.
      // Auto.* đã guard if (!dongbang_skill) trước khi gọi → auto vẫn đúng.
      // Manual attack không bị corrupt state nữa → đánh tay hoạt động khi fz/bang bật.
      this.ex = var1;
      this.hj = var2;
      this.gv = 0;
      this.gw = this.gx = this.gy = this.gz = this.ha = this.hb = this.hc = this.hd = this.he = 0;
      this.hf = null;
      this.hg = null;
      this.hh = null;
   }

   public final void clearSkillVisualOnly() {
      this.hi = null;
      this.hf = null;
      this.hg = null;
      this.hh = null;
      this.ew = null;
      this.gu = null;
      this.ev = null;
      this.gt = -1;
      this.eu = -1;
   }

   private SkillInfoPaint[] as() {
      if (this.ex == null) {
         return null;
      } else {
         return this.hj == 0 ? this.ex.b : this.ex.c;
      }
   }

   public final void n() {
      try {
         int var1;
         MyVector var3;
         if (this.bk) {
            if (this.myskill.template.type == 2) {
               return;
            }

            if (this.myskill.template.id == 42 && !this.myskill.a()) {
               this.ek = true;
               this.gc = System.currentTimeMillis();
            }

            if (this.ex != null && (this.mobFocus != null || this.charFocus != null && this.b(this.charFocus))) {
               if (Code.mode != null) {
                  Auto.kobiet(this.ex);
                  return;
               }

               this.c();
               var1 = this.myskill.ngang();
               int var2 = this.myskill.cao();
               var3 = new MyVector();
               MyVector var4 = new MyVector();
               int var5;
               Mob var6;
               Char var11;
               if (this.charFocus != null) {
                  var4.addElement(this.charFocus);

                  for(var5 = 0; var5 < GameScr.vCharInMap.size() && var3.size() + var4.size() < this.myskill.maxFight; ++var5) {
                     if ((var11 = (Char)GameScr.vCharInMap.elementAt(var5)).statusMe != 14 && var11.statusMe != 5 && var11.statusMe != 15 && !var11.dh && !var11.equals(this.charFocus) && this.b(var11) && this.charFocus.cx1 - var1 <= var11.cx1 && var11.cx1 <= this.charFocus.cx1 + var1 && this.charFocus.cy1 - var2 <= var11.cy1 && var11.cy1 <= this.charFocus.cy1 + var2 && (this.cdir == -1 && var11.cx1 <= this.cx1 || this.cdir == 1 && var11.cx1 >= this.cx1)) {
                        var4.addElement(var11);
                     }
                  }

                  for(var5 = 0; var5 < GameScr.vMob.size() && var3.size() + var4.size() < this.myskill.maxFight; ++var5) {
                     if ((var6 = (Mob)GameScr.vMob.elementAt(var5)).status != 1 && var6.status != 0 && this.charFocus.cx1 - var1 <= var6.x1 && var6.x1 <= this.charFocus.cx1 + var1 && this.charFocus.cy1 - var2 <= var6.y1 && var6.y1 <= this.charFocus.cy1 + var2 && (this.cdir == -1 && var6.x1 <= this.cx1 || this.cdir == 1 && var6.x1 >= this.cx1)) {
                        var3.addElement(var6);
                     }
                  }
               } else if (this.mobFocus != null && this.mobFocus.status != 1 && this.mobFocus.status != 0) {
                  var3.addElement(this.mobFocus);

                  for(var5 = 0; var5 < GameScr.vMob.size() && var3.size() + var4.size() < this.myskill.maxFight; ++var5) {
                     if ((var6 = (Mob)GameScr.vMob.elementAt(var5)).status != 1 && var6.status != 0 && !var6.equals(this.mobFocus) && this.mobFocus.x1 - 100 <= var6.x1 && var6.x1 <= this.mobFocus.x1 + 100 && this.mobFocus.y1 - 50 <= var6.y1 && var6.y1 <= this.mobFocus.y1 + 50) {
                        var3.addElement(var6);
                     }
                  }

                  for(var5 = 0; var5 < GameScr.vCharInMap.size() && var3.size() + var4.size() < this.myskill.maxFight; ++var5) {
                     if ((var11 = (Char)GameScr.vCharInMap.elementAt(var5)).statusMe != 14 && var11.statusMe != 5 && var11.statusMe != 15 && !var11.dh && (this.cTypePk >= 4 && this.cTypePk <= 6 && var11.cTypePk >= 4 && var11.cTypePk <= 6 && this.cTypePk != var11.cTypePk || var11.cTypePk == 3 || this.cTypePk == 3 || var11.cTypePk == 1 && this.cTypePk == 1 || this.db >= 0 && this.db == var11.idChar || this.dc >= 0 && this.dc == var11.idChar) && this.mobFocus.x1 - var1 <= var11.cx1 && var11.cx1 <= this.mobFocus.x1 + var1 && this.mobFocus.y1 - var2 <= var11.cy1 && var11.cy1 <= this.mobFocus.y1 + var2 && (this.cdir == -1 && var11.cx1 <= this.cx1 || this.cdir == 1 && var11.cx1 >= this.cx1)) {
                        var4.addElement(var11);
                     }
                  }
               }

               this.hi = new EffectPaint[var3.size() + var4.size()];

               for(var5 = 0; var5 < var3.size(); ++var5) {
                  this.hi[var5] = new EffectPaint();
                  this.hi[var5].d = GameScr.ad[this.ex.a - 1];
                  this.hi[var5].b = (Mob)var3.elementAt(var5);
               }

               for(var5 = 0; var5 < var4.size(); ++var5) {
                  this.hi[var5 + var3.size()] = new EffectPaint();
                  this.hi[var5 + var3.size()].d = GameScr.ad[this.ex.a - 1];
                  this.hi[var5 + var3.size()].c = (Char)var4.elementAt(var5);
               }

               if (this.hi.length > 1) {
                  EPosition var13 = new EPosition();
                  if (this.hi[0].b != null) {
                     var13 = new EPosition(this.hi[0].b.x1, this.hi[0].b.y1);
                  } else if (this.hi[0].c != null) {
                     var13 = new EPosition(this.hi[0].c.cx1, this.hi[0].c.cy1);
                  }

                  MyVector var12 = new MyVector();

                  for(var1 = 1; var1 < this.hi.length; ++var1) {
                     if (this.hi[var1].b != null) {
                        var12.addElement(new EPosition(this.hi[var1].b.x1, this.hi[var1].b.y1));
                     } else if (this.hi[var1].c != null) {
                        var12.addElement(new EPosition(this.hi[var1].c.cx1, this.hi[var1].c.cy1));
                     }

                     if (var1 > 5) {
                        break;
                     }
                  }

                  Lightning.a(var12, var13, true, this.t());
               }

               byte var14 = 0;
               if (this.mobFocus != null) {
                  var14 = 1;
               } else if (this.charFocus != null) {
                  var14 = 2;
               }

               if (this.bk) {
                  Service.gI().sendPlayerAttack(var3, var4, var14);
                  return;
               }
            }
         } else if (this.ex != null && (this.mobFocus != null || this.charFocus != null)) {
            if (this.attMobs != null && this.attChars != null) {
               this.hi = new EffectPaint[this.attMobs.length + this.attChars.length];

               for(var1 = 0; var1 < this.attMobs.length; ++var1) {
                  this.hi[var1] = new EffectPaint();
                  this.hi[var1].d = GameScr.ad[this.ex.a - 1];
                  this.hi[var1].b = this.attMobs[var1];
               }

               for(var1 = 0; var1 < this.attChars.length; ++var1) {
                  this.hi[var1 + this.attMobs.length] = new EffectPaint();
                  this.hi[var1 + this.attMobs.length].d = GameScr.ad[this.ex.a - 1];
                  this.hi[var1 + this.attMobs.length].c = this.attChars[var1];
               }

               this.attMobs = null;
               this.attChars = null;
            } else if (this.attMobs != null) {
               this.hi = new EffectPaint[this.attMobs.length];

               for(var1 = 0; var1 < this.attMobs.length; ++var1) {
                  this.hi[var1] = new EffectPaint();
                  this.hi[var1].d = GameScr.ad[this.ex.a - 1];
                  this.hi[var1].b = this.attMobs[var1];
               }

               this.attMobs = null;
            } else if (this.attChars != null) {
               this.hi = new EffectPaint[this.attChars.length];

               for(var1 = 0; var1 < this.attChars.length; ++var1) {
                  this.hi[var1] = new EffectPaint();
                  this.hi[var1].d = GameScr.ad[this.ex.a - 1];
                  this.hi[var1].c = this.attChars[var1];
               }

               this.attChars = null;
            }

            if (this.hi.length > 1 && this.hi[0] != null) {
               EPosition var10 = new EPosition();
               if (this.hi[0].b != null) {
                  var10 = new EPosition(this.hi[0].b.x1, this.hi[0].b.y1);
               } else if (this.hi[0].c != null) {
                  var10 = new EPosition(this.hi[0].c.cx1, this.hi[0].c.cy1);
               }

               var3 = new MyVector();

               for(int var9 = 1; var9 < this.hi.length; ++var9) {
                  if (this.hi[var9].b != null) {
                     var3.addElement(new EPosition(this.hi[var9].b.x1, this.hi[var9].b.y1));
                  } else if (this.hi[var9].c != null) {
                     var3.addElement(new EPosition(this.hi[var9].c.cx1, this.hi[var9].c.cy1));
                  }

                  if (var9 > 5) {
                     break;
                  }
               }

               Lightning.a(var3, var10, true, this.t());
               return;
            }
         }
      } catch (Exception var10) {
         ;
      }

   }

   public final boolean o() {
      if (this.ID_HORSE > -1) {
         return false;
      } else {
         return this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && (this.arrItemMounts[4].template.id == 443 || this.arrItemMounts[4].template.id == 523);
      }
   }

   public final boolean p() {
      if (this.ID_HORSE > -1) {
         return false;
      } else {
         return this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && (this.arrItemMounts[4].template.id == 485 || this.arrItemMounts[4].template.id == 524);
      }
   }

   public final boolean q() {
      if (this.cx1 < GameScr.p) {
         return false;
      } else if (this.cx1 > GameScr.p + GameScr.i) {
         return false;
      } else if (this.cy1 < GameScr.q) {
         return false;
      } else {
         return this.cy1 <= GameScr.q + GameScr.j + 30;
      }
   }

   private static DataSkillEff a(short var0, boolean var1) {
      if (var0 == -1) {
         return null;
      } else {
         DataSkillEff var2;
         if ((var2 = (DataSkillEff)hl.a(String.valueOf(var0))) == null) {
            var2 = new DataSkillEff(var0, var1);
            hl.a(String.valueOf(var0), var2);
            var2.a = (long)((int)(System.currentTimeMillis() / 1000L));
            debugFashion("effectCacheMiss id=" + var0 + " horseProfile=" + var1);
         } else {
            var2.a = System.currentTimeMillis();
            if (!var2.d) {
               debugFashion("effectCacheHitNotReady id=" + var0 + " horseProfile=" + var1 + " -> recheck()");
               var2.recheck();
            }
         }

         return var2;
      }
   }

   private static final boolean DEBUG_FASHION = false;

   private static void debugFashion(String var0) {
      if (DEBUG_FASHION) {
         ;
      }
   }

   public static void r() {
      Enumeration var0 = hl.a.keys();

      while(var0.hasMoreElements()) {
         String var1 = (String)var0.nextElement();
         DataSkillEff var2 = (DataSkillEff)hl.a(var1);
         if ((System.currentTimeMillis() - var2.a) / 1000L > 200L) {
            hl.a.remove(var1);
         }
      }

   }

   public void a(mGraphics var1) {
      if (!this.q()) {
         if (this.ex != null) {
            this.gv = this.as().length;
            this.ex = null;
            this.hi = null;
            this.gu = null;
            this.ev = null;
            this.gt = -1;
            this.eu = -1;
         }
      } else {
         this.b(var1, this.cx1, this.cy1 - this.bg(), -this.hm);
         if (this.statusMe != 15 && (this.moveFast == null || this.moveFast[0] <= 0)) {
            this.c(var1);
            if (Code.isDongBangSkillEffective()) {
               this.clearSkillVisualOnly();
               this.f(var1);
               SkillInfoPaint[] var9 = this.as();
               if (var9 != null && this.gv < var9.length) {
                  ++this.gv;
               }
            } else if (this.ex != null && this.gv < this.as().length) {
               mGraphics var2 = var1;
               Char var3 = this;

               try {
                  SkillInfoPaint[] var4 = var3.as();
                  var3.bm = var4[var3.gv].a;
                  if (var4[var3.gv].b != 0) {
                     var3.hf = GameScr.ad[var4[var3.gv].b - 1];
                     var3.gw = var3.gz = var3.hc = 0;
                  }

                  if (var4[var3.gv].e != 0) {
                     var3.hg = GameScr.ad[var4[var3.gv].e - 1];
                     var3.gx = var3.ha = var3.hd = 0;
                  }

                  if (var4[var3.gv].h != 0) {
                     var3.hh = GameScr.ad[var4[var3.gv].h - 1];
                     var3.gy = var3.hb = var3.he = 0;
                  }

                  if (var4 != null && var4[var3.gv] != null && var4[var3.gv].k != 0) {
                     var3.ew = new Arrow(var3, GameScr.ab[var4[var3.gv].k - 1]);
                     var3.ew.a = 10;
                     var3.ew.b = var3.cx1 + var4[var3.gv].l;
                     var3.ew.c = var3.cy1 + var4[var3.gv].m;
                  }

                  var3.f(var2);
                  if (var3.cdir == 1) {
                     if (var3.hf != null) {
                        if (var3.gz == 0) {
                           var3.gz = var4[var3.gv].c;
                        }

                        if (var3.hc == 0) {
                           var3.hc = var4[var3.gv].d;
                        }

                        SmallImage.a(var2, var3.hf.b[var3.gw].c, var3.cx1 + var3.gz + var3.hf.b[var3.gw].a, var3.cy1 + var3.hc + var3.hf.b[var3.gw].b, 0, 3);
                        ++var3.gw;
                        if (var3.gw >= var3.hf.b.length) {
                           var3.hf = null;
                           var3.gw = var3.gz = var3.hc = 0;
                        }
                     }

                     if (var3.hg != null) {
                        if (var3.ha == 0) {
                           var3.ha = var4[var3.gv].f;
                        }

                        if (var3.hd == 0) {
                           var3.hd = var4[var3.gv].g;
                        }

                        SmallImage.a(var2, var3.hg.b[var3.gx].c, var3.cx1 + var3.ha + var3.hg.b[var3.gx].a, var3.cy1 + var3.hd + var3.hg.b[var3.gx].b, 0, 3);
                        ++var3.gx;
                        if (var3.gx >= var3.hg.b.length) {
                           var3.hg = null;
                           var3.gx = var3.ha = var3.hd = 0;
                        }
                     }

                     if (var3.hh != null) {
                        if (var3.hb == 0) {
                           var3.hb = var4[var3.gv].i;
                        }

                        if (var3.he == 0) {
                           var3.he = var4[var3.gv].j;
                        }

                        SmallImage.a(var2, var3.hh.b[var3.gy].c, var3.cx1 + var3.hb + var3.hh.b[var3.gy].a, var3.cy1 + var3.he + var3.hh.b[var3.gy].b, 0, 3);
                        ++var3.gy;
                        if (var3.hh.b != null && var3.gy >= var3.hh.b.length) {
                           var3.hh = null;
                           var3.gy = var3.hb = var3.he = 0;
                        }
                     }
                  } else {
                     if (var3.hf != null) {
                        if (var3.gz == 0) {
                           var3.gz = var4[var3.gv].c;
                        }

                        if (var3.hc == 0) {
                           var3.hc = var4[var3.gv].d;
                        }

                        SmallImage.a(var2, var3.hf.b[var3.gw].c, var3.cx1 - var3.gz - var3.hf.b[var3.gw].a, var3.cy1 + var3.hc + var3.hf.b[var3.gw].b, 2, 3);
                        ++var3.gw;
                        if (var3.gw >= var3.hf.b.length) {
                           var3.hf = null;
                           var3.gw = 0;
                           var3.gz = 0;
                           var3.hc = 0;
                        }
                     }

                     if (var3.hg != null) {
                        if (var3.ha == 0) {
                           var3.ha = var4[var3.gv].f;
                        }

                        if (var3.hd == 0) {
                           var3.hd = var4[var3.gv].g;
                        }

                        SmallImage.a(var2, var3.hg.b[var3.gx].c, var3.cx1 - var3.ha - var3.hg.b[var3.gx].a, var3.cy1 + var3.hd + var3.hg.b[var3.gx].b, 2, 3);
                        ++var3.gx;
                        if (var3.gx >= var3.hg.b.length) {
                           var3.hg = null;
                           var3.gx = 0;
                           var3.ha = 0;
                           var3.hd = 0;
                        }
                     }

                     if (var3.hh != null) {
                        if (var3.hb == 0) {
                           var3.hb = var4[var3.gv].i;
                        }

                        if (var3.he == 0) {
                           var3.he = var4[var3.gv].j;
                        }

                        SmallImage.a(var2, var3.hh.b[var3.gy].c, var3.cx1 - var3.hb - var3.hh.b[var3.gy].a, var3.cy1 + var3.he + var3.hh.b[var3.gy].b, 2, 3);
                        ++var3.gy;
                        if (var3.hh.b != null && var3.gy >= var3.hh.b.length) {
                           var3.hh = null;
                           var3.gy = 0;
                           var3.hb = 0;
                           var3.he = 0;
                        }
                     }
                  }

                  ++var3.gv;
               } catch (Exception var6) {
                  ;
               }
            } else {
               this.f(var1);
            }

            if (this.ew != null) {
               this.ew.a(var1);
            }

            int var8;
            if (this.hi != null) {
               for(var8 = 0; var8 < this.hi.length; ++var8) {
                  if (this.hi[var8] != null) {
                     if (this.hi[var8].b != null) {
                        if (!this.hi[var8].e) {
                           this.hi[var8].b.b();
                           this.hi[var8].b.ac = this;
                           if (this.bk) {
                              getMyChar();
                              NinjaUtil.a(11);
                           }

                           if (this.hi[var8].b.s != 98 && this.hi[var8].b.s != 99) {
                              GameScr.a(this.hi[var8].b.x1, this.hi[var8].b.y1 - (this.hi[var8].b.l >> 1), this.cdir);
                           }

                           this.hi[var8].e = true;
                        }

                        SmallImage.a(var1, this.hi[var8].a(), this.hi[var8].b.x1, this.hi[var8].b.y1, 0, 33);
                     } else if (this.hi[var8].c != null) {
                        if (!this.hi[var8].e) {
                           if (this.hi[var8].c.idChar >= 0) {
                              this.hi[var8].c.hk = 4;
                           }

                           GameScr.a(this.hi[var8].c.cx1, this.hi[var8].c.cy1 - (this.hi[var8].c.bg >> 1), this.cdir);
                           this.hi[var8].e = true;
                        }

                        SmallImage.a(var1, this.hi[var8].a(), this.hi[var8].c.cx1, this.hi[var8].c.cy1, 0, 33);
                     }

                     ++this.hi[var8].a;
                     if (this.hi[var8].a >= this.hi[var8].d.b.length) {
                        this.hi[var8] = null;
                     }
                  }
               }
            }

            if (this.gt >= 0 && this.gu != null) {
               SmallImage.a(var1, this.gu.b[this.gt].c, this.cx1 + this.gu.b[this.gt].a, this.cy1 + this.gu.b[this.gt].b, 0, 3);
               if (GameCanvas.w % 2 == 0) {
                  ++this.gt;
                  if (this.gt >= this.gu.b.length) {
                     this.gt = -1;
                     this.gu = null;
                  }
               }
            }

            if (this.eu >= 0 && this.ev != null) {
               SmallImage.a(var1, this.ev.b[this.eu].c, this.cx1 + this.ev.b[this.eu].a, this.cy1 + this.ev.b[this.eu].b, 0, 3);
               if (GameCanvas.w % 2 == 0) {
                  ++this.eu;
                  if (this.eu >= this.ev.b.length) {
                     this.eu = -1;
                     this.ev = null;
                  }
               }
            }

            if (this.gg) {
               if (this.gf < 2) {
                  SmallImage.a(var1, 1366, this.cx1, this.cy1 - this.bi, 0, 3);
               } else if (this.gf < 4) {
                  SmallImage.a(var1, 1367, this.cx1, this.cy1 - this.bi, 0, 3);
               } else if (this.gf < 8) {
                  SmallImage.a(var1, 1368, this.cx1, this.cy1 - this.bi, 0, 3);
               } else if (GameCanvas.w % 2 == 0) {
                  SmallImage.a(var1, 1369, this.cx1, this.cy1 - this.bi, 0, 3);
               } else {
                  SmallImage.a(var1, 1370, this.cx1, this.cy1 - this.bi, 0, 3);
               }
            }

            try {
               if (this.mobMe != null) {
                  this.mobMe.a(var1);
               }
            } catch (Exception var5) {
               ;
            }

            if (this.mobVithu != null) {
               this.mobVithu.a(var1);
            }

            if (this.statusMe != 1 && this.statusMe != 6) {
               for(var8 = 0; var8 < this.fx.size(); ++var8) {
                  ((Domsang)this.fx.elementAt(var8)).a(var1);
               }
            }

            this.a(var1, this.cx1, this.cy1 - this.bg(), -this.hm);
         }
      }

   }

   public final void a(mGraphics var1, int var2, int var3) {
      int var4 = this.cHP * 26 / this.cMaxHP;
      if (this.statusMe != 5 && this.statusMe != 14 && var4 < 2) {
         var4 = 2;
      } else if (this.statusMe == 5 || this.statusMe == 14) {
         var4 = 0;
      }

      if (var4 > 26) {
         var4 = 0;
      }

      var1.a(16777215);
      var1.c(var2, var3, 26, 4);
      var1.a(this.t());
      var1.c(var2, var3, var4, 4);
      var1.a(0);
      var1.b(var2, var3, 26, 4);
   }

   private int[] at() {
      int[] var1 = null;
      if (this.bn && this.arrItemMounts[4].template.id == 485 && this.arrItemMounts[4].sys >= 3) {
         var1 = new int[]{2094, 2095, 2096};
      }

      return var1;
   }

   private int[] au() {
      int[] var1 = null;
      if (this.bn) {
         var1 = new int[]{2082, 2082, 2083, 2083, 2084, 2084, 2089, 2089, 2082, 2082, 2083, 2083};
      }

      return var1;
   }

   private int[] av() {
      int[] var1 = null;
      if (this.bo) {
         var1 = new int[]{2085, 2086, 2087, 2088};
      }

      return var1;
   }

   public final int[] s() {
      int[] var1 = null;
      short var2 = -1;
      if (this.bk) {
         if (this.arrItemBody[12] != null) {
            var2 = this.arrItemBody[12].template.id;
         }
      } else {
         var2 = this.es;
      }

      if (var2 == -1) {
         return null;
      } else {
         if (var2 == 420) {
            if (!this.bo && !this.bn && !this.bq) {
               var1 = new int[]{1635, 1636, 1637, 1636};
            } else {
               var1 = new int[]{2029, 2030, 2031, 2030};
            }
         } else if (var2 == 421) {
            if (!this.bo && !this.bn && !this.bq) {
               var1 = new int[]{1652, 1653, 1654, 1653};
            } else {
               var1 = new int[]{2035, 2036, 2037, 2036};
            }
         } else if (var2 == 422) {
            if (!this.bo && !this.bn && !this.bq) {
               var1 = new int[]{1655, 1656, 1657, 1656};
            } else {
               var1 = new int[]{2032, 2033, 2034, 2033};
            }
         }

         return var1;
      }
   }

   public final int t() {
      int var1 = 9145227;
      if (this.nClass.a != 1 && this.nClass.a != 2) {
         if (this.nClass.a != 3 && this.nClass.a != 4) {
            if (this.nClass.a == 5 || this.nClass.a == 6) {
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

   public final String displayName() {
      Char my = getMyChar();
      return (ChatManager.hideIngameName && my != null && this == my) ? "nsotientv" : this.cName;
   }

   public final void b(mGraphics var1) {
      if (this.q()) {
         if (getMyChar().charFocus == null || !getMyChar().charFocus.equals(this)) {
            mFont.j.a(var1, this.displayName(), this.cx1, this.cy1 - this.bg - mFont.n.c() - 5, 2, mFont.k);
            return;
         }

         if (getMyChar().charFocus != null && getMyChar().charFocus.equals(this)) {
            mFont.j.a(var1, this.displayName(), this.cx1, this.cy1 - this.bg - mFont.n.c() - 10, 2, mFont.k);
         }
      }

   }

   public final void c(mGraphics var1) {
      this.hm = this.bg + 5;
      this.hm += !this.bo && !this.bn && !this.bq ? 0 : 15;
      DataSkillEff var2;
      if (this.ID_HORSE > -1 && (var2 = a(this.ID_HORSE, true)) != null && var2.d) {
         this.hm += var2.p;
      }

      if (!this.dh || this.bk) {
         boolean var4;
         label153: {
            var4 = false;
            if (this.bk) {
               GameScr.gI();
               if (GameScr.fb != 1) {
                  if (this.ColorName > 0) {
                     var4 = true;
                     this.hm += mFont.g.c();
                     if (!this.isHuman) {
                        mFont.h.a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
                     } else {
                        is[this.ColorName].a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
                     }

                     ++this.hm;
                  } else if (this.npcFocus == null && this.charFocus == null && this.mobFocus == null && this.itemFocus == null) {
                     var4 = true;
                     this.hm += mFont.g.c();
                     if (!this.isHuman) {
                        mFont.h.a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
                     } else {
                        is[this.ColorName].a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
                     }

                     ++this.hm;
                  }
                  break label153;
               }

               if (!GameScr.gI().fc) {
                  this.hm += mFont.g.c();
                  mFont.j.a(var1, TextGame.aj, this.cx1, this.cy1 - this.hm, 2, mFont.k);
               } else {
                  this.hm += mFont.g.c();
                  mFont.j.a(var1, TextGame.ak, this.cx1, this.cy1 - this.hm, 2, mFont.k);
               }
            } else {
               if (getMyChar().charFocus != null && getMyChar().charFocus.equals(this)) {
                  var4 = true;
                  this.hm += 5;
                  this.a(var1, this.cx1 - 13, this.cy1 - this.hm);
                  this.hm += mFont.g.c();
                  if (!this.isHuman) {
                     mFont.h.a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
                  } else {
                     is[this.ColorName].a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
                  }

                  ++this.hm;
                  break label153;
               }

               if (!this.fy) {
                  break label153;
               }

               var4 = true;
               this.hm += mFont.g.c();
               if (!this.isHuman) {
                  mFont.h.a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
               } else {
                  is[this.ColorName].a(var1, this.displayName(), this.cx1, this.cy1 - this.hm, 2, mFont.k);
               }
            }

            ++this.hm;
         }

         if (this.idChar == -getMyChar().idChar) {
            this.hm += is[this.ColorName].c();
            is[this.ColorName].a(var1, TextGame.al + " " + getMyChar().displayName() + " " + TextGame.cx, this.cx1, this.cy1 - this.hm, 2, mFont.k);
            ++this.hm;
         }

         if (!this.cClanName.equals("") && var4) {
            this.hm += mFont.g.c() - 1;
            byte var5 = 0;
            if (this.ctypeClan > 0) {
               var5 = 5;
            }

            mFont.i.a(var1, this.cClanName, this.cx1 + var5, this.cy1 - this.hm, 2, mFont.m);
            if (this.ctypeClan == 3) {
               SmallImage.a(var1, 1215, this.cx1 - (mFont.i.a(this.cClanName) / 2 + (7 - var5)), this.cy1 - this.hm + 1, 0, 17);
            } else if (this.ctypeClan == 4) {
               SmallImage.a(var1, 1216, this.cx1 - (mFont.i.a(this.cClanName) / 2 + (7 - var5)), this.cy1 - this.hm + 1, 0, 17);
            } else if (this.ctypeClan == 2) {
               SmallImage.a(var1, 1217, this.cx1 - (mFont.i.a(this.cClanName) / 2 + (7 - var5)), this.cy1 - this.hm + 1, 0, 17);
            }

            ++this.hm;
         }

         if (this.dd > 0 && this.dd < 30) {
            this.hm += SmallImage.a[1117][4];
            SmallImage.a(var1, 1117, this.cx1, this.cy1 - this.hm, 0, 17);
            ++this.hm;
         } else if (this.dd > 30 && this.dd < 60) {
            this.hm += SmallImage.a[1117][4];
            SmallImage.a(var1, 1126, this.cx1, this.cy1 - this.hm, 0, 17);
            ++this.hm;
         } else if (this.dd > 60 && this.dd < 90) {
            this.hm += SmallImage.a[1117][4];
            SmallImage.a(var1, 1118, this.cx1, this.cy1 - this.hm, 0, 17);
            ++this.hm;
         } else if (this.idChar >= 0) {
            if (this.dc >= 0) {
               this.hm += SmallImage.a[1122][4];
               SmallImage.a(var1, 1122, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.cTypePk == 3) {
               this.hm += SmallImage.a[1121][4];
               SmallImage.a(var1, 1121, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.cTypePk == 2) {
               this.hm += SmallImage.a[1124][4];
               SmallImage.a(var1, 1124, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.cTypePk == 1) {
               this.hm += SmallImage.a[1123][4];
               SmallImage.a(var1, 1123, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.cTypePk == 4) {
               this.hm += SmallImage.a[1240][4];
               SmallImage.a(var1, 1240, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.cTypePk == 5) {
               this.hm += SmallImage.a[1241][4];
               SmallImage.a(var1, 1241, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.cTypePk == 6) {
               this.hm += SmallImage.a[1241][4];
               SmallImage.a(var1, 1123, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.cTypePk == 7) {
               this.hm += SmallImage.a[1241][4];
               SmallImage.a(var1, 3410, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
               return;
            }

            if (this.db > 0) {
               this.hm += SmallImage.a[1116][4];
               SmallImage.a(var1, 1116, this.cx1, this.cy1 - this.hm, 0, 17);
               ++this.hm;
            }
         }
      }

   }

   private byte aw() {
      DataSkillEff var1;
      if ((var1 = a(this.ID_HORSE, true)) != null && var1.d) {
         if (this.statusMe != 1 && this.statusMe != 6) {
            if (this.statusMe != 2 && this.statusMe != 10) {
               if (this.statusMe == 4) {
                  this.ix = var1.j;
               } else if (this.statusMe == 3) {
                  this.ix = var1.i;
               } else {
                  this.ix = var1.g;
               }
            } else {
               this.ix = var1.h;
            }
         } else {
            this.ix = var1.g;
         }

         return this.iw >= this.ix.length ? (byte)(this.ix[this.ix.length - 1] + this.iv * var1.n) : (byte)(this.ix[this.iw] + this.iv * var1.n);
      } else {
         return 0;
      }
   }

   private int g(int var1) {
      return var1 + this.iy * 30;
   }

   public final void b(mGraphics var1, int var2, int var3) {
      DataSkillEff var4;
      if ((var4 = a(this.ID_HORSE, true)) != null && var4.d) {
         if (GameCanvas.w % 10 == 0) {
            int var5;
            if ((var5 = var4.b.size() / var4.c.length) == 0) {
               var5 = 1;
            }

            this.iy = (byte)((this.iy + 1) % var5);
         }

         var4.a(var1, var2, var3, this.g(var4.g[this.iz]), 2);
         var4.b(var1, var2, var3, this.g(var4.g[this.iz]), 2);
      }

   }

   private int ax() {
      if (!this.bn && !this.bo && !this.bq && this.ID_HORSE <= -1) {
         return this.bm + this.ic * 30;
      } else {
         return this.statusMe != 1 && this.statusMe != 6 ? this.ja[this.id] + this.ic * 30 : this.bm + this.ic * 30;
      }
   }

   private int ay() {
      if (!this.bn && !this.bo && !this.bq && this.ID_HORSE <= -1) {
         return this.bm + this.ii * 30;
      } else {
         return this.statusMe != 1 && this.statusMe != 6 ? this.ja[this.ij] + this.ii * 30 : this.bm + this.ii * 30;
      }
   }

   private int az() {
      if (!this.bn && !this.bo && !this.bq) {
         return this.bm + this.ia * 30;
      } else {
         return this.statusMe != 1 && this.statusMe != 6 ? this.ja[this.ib] + this.ia * 30 : this.bm + this.ia * 30;
      }
   }

   private int ba() {
      if (!this.bn && !this.bo && !this.bq) {
         return this.bm + this.ie * 30;
      } else {
         return this.statusMe != 1 && this.statusMe != 6 ? this.ja[this.ifa] + this.ie * 30 : this.bm + this.ie * 30;
      }
   }

   private int bb() {
      if (!this.bn && !this.bo && !this.bq) {
         return this.bm + this.ik * 30;
      } else {
         return this.statusMe != 1 && this.statusMe != 6 ? this.ja[this.il] + this.ik * 30 : this.bm + this.ik * 30;
      }
   }

   private int bc() {
      if (!this.bn && !this.bo && !this.bq) {
         return this.bm + this.im * 30;
      } else {
         return this.statusMe != 1 && this.statusMe != 6 ? this.ja[this.in] + this.im * 30 : this.bm + this.im * 30;
      }
   }

   private int bd() {
      if (!this.bn && !this.bo && !this.bq && this.ID_HORSE <= -1) {
         return this.bm + this.it * 30;
      } else {
         return this.statusMe != 1 && this.statusMe != 6 ? this.ja[this.iu] + this.it * 30 : this.bm + this.it * 30;
      }
   }

   private int h(int var1) {
      return var1 + this.je * 30;
   }

   private int i(int var1) {
      return var1 + this.jd * 30;
   }

   private int j(int var1) {
      return var1 + this.jb * 30;
   }

   private int k(int var1) {
      return var1 + this.jc * 30;
   }

   public final void c(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_PP, false)) != null) {
         var5.a(var1, var2, var3, this.h(var4), 0);
      }

   }

   public final void d(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_PP, false)) != null) {
         if (GameCanvas.w % 10 == 0) {
            int var6;
            if ((var6 = var5.b.size() / 30) == 0) {
               var6 = 1;
            }

            this.je = (byte)((this.je + 1) % var6);
         }

         var5.b(var1, var2, var3, this.h(var4), 0);
      }

   }

   private int l(int var1) {
      return var1 + this.jf * 30;
   }

   private int m(int var1) {
      return var1 + this.jg * 30;
   }

   public final void e(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_MAT_NA, false)) != null) {
         if (GameCanvas.w % 6 == 0) {
            int var6;
            if ((var6 = var5.b.size() / 30) == 0) {
               var6 = 1;
            }

            this.jg = (byte)((this.jg + 1) % var6);
         }

         var5.b(var1, var2, var3, this.m(var4), 0);
         var5.a(var1, var2, var3, this.m(var4), 0);
      }

   }

   public final void f(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_WEA_PONE, false)) != null) {
         if (GameCanvas.w % 6 == 0) {
            int var6;
            if ((var6 = var5.b.size() / 30) == 0) {
               var6 = 1;
            }

            this.jf = (byte)((this.jf + 1) % var6);
         }

         var5.b(var1, var2, var3, this.l(var4), 0);
      }

   }

   public final void g(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_WEA_PONE, false)) != null) {
         if (GameCanvas.w % 6 == 0) {
            int var6;
            if ((var6 = var5.b.size() / 30) == 0) {
               var6 = 1;
            }

            this.jf = (byte)((this.jf + 1) % var6);
         }

         var5.a(var1, var2, var3, this.l(var4), 0);
      }

   }

   public final void h(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_HAIR, false)) != null) {
         if (GameCanvas.w % 6 == 0) {
            int var6;
            if ((var6 = var5.b.size() / 30) == 0) {
               var6 = 1;
            }

            this.jd = (byte)((this.jd + 1) % var6);
         }

         var5.a(var1, var2, var3, this.i(var4), 0);
         var5.b(var1, var2, var3, this.i(var4), 0);
      }

   }

   public final void i(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_LEG, false)) != null) {
         if (GameCanvas.w % 6 == 0) {
            int var6;
            if ((var6 = var5.b.size() / 30) == 0) {
               var6 = 1;
            }

            this.jc = (byte)((this.jc + 1) % var6);
         }

         var5.a(var1, var2, var3, this.k(var4), 0);
         var5.b(var1, var2, var3, this.k(var4), 0);
      }

   }

   public final void j(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5;
      if ((var5 = a(this.ID_Body, false)) != null) {
         if (GameCanvas.w % 6 == 0) {
            int var6;
            if ((var6 = var5.b.size() / 30) == 0) {
               var6 = 1;
            }

            this.jb = (byte)((this.jb + 1) % var6);
         }

         var5.a(var1, var2, var3, this.j(var4), 0);
         var5.b(var1, var2, var3, this.j(var4), 0);
      }

   }

   private void a(mGraphics var1, int var2, int var3, int var4, DataSkillEff var5) {
      var4 = 0;
      if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
         var4 = this.bm << 1;
      }

      if (var5 != null) {
         if (this.bq) {
            byte var6 = -2;
            if (this.cdir == 1) {
               var6 = 2;
            }

            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm;
            }

            var5.a(var1, var2 + this.bf() + var6, var3 + var4 - this.bg() + this.jr - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ie * 30 : this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         if (this.bo) {
            var5.a(var1, var2 + this.bf(), var3 + var4 - this.bg() - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ie * 30 : this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         if (this.bn) {
            var5.a(var1, var2 + this.bf(), var3 + var4 - this.bg() - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ie * 30 : this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         if (this.ID_HORSE > -1) {
            var5.a(var1, var2 + this.bf() + this.ji, var3 - this.be() - this.bg(), this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         var5.a(var1, var2 + this.bf(), var3 - this.be(), this.ba(), this.cdir == 1 ? 0 : 2);
      }

   }

   private void b(mGraphics var1, int var2, int var3, int var4, DataSkillEff var5) {
      var4 = 0;
      if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
         var4 = this.bm << 1;
      }

      if (var5 != null) {
         if (this.bq) {
            byte var6 = -2;
            if (this.cdir == 1) {
               var6 = 2;
            }

            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm;
            }

            var5.b(var1, var2 + this.bf() + var6, var3 + var4 - this.bg() + this.jr - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ie * 30 : this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         if (this.bo) {
            var5.b(var1, var2 + this.bf(), var3 + var4 - this.bg() - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ie * 30 : this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         if (this.bn) {
            var5.b(var1, var2 + this.bf(), var3 + var4 - this.bg() - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ie * 30 : this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         if (this.ID_HORSE > -1) {
            var5.b(var1, var2 + this.bf() + this.ji, var3 - this.be() - this.bg(), this.ba(), this.cdir == 1 ? 0 : 2);
            return;
         }

         var5.b(var1, var2 + this.bf(), var3 - this.be(), this.ba(), this.cdir == 1 ? 0 : 2);
      }

   }

   private void k(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5 = a(this.ID_Body, false);
      int var6 = 0;
      if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
         var6 = this.bm * var4;
      }

      if (var5 != null) {
         var5.a(var1, var2 + this.bf(), var3 + var6 - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ik * 30 : this.bb(), this.cdir == 1 ? 0 : 2);
         var5.b(var1, var2 + this.bf(), var3 + var6 - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ik * 30 : this.bb(), this.cdir == 1 ? 0 : 2);
      }

   }

   private int be() {
      byte var1 = 0;
      if (this.bn) {
         if (this.arrItemMounts[4].template.id == 485) {
            var1 = 4;
         } else {
            var1 = 6;
         }
      }

      if (this.bq) {
         var1 = 2;
         if (this.statusMe == 3) {
            var1 = 4;
         }
      }

      return var1;
   }

   private int bf() {
      byte var1 = 0;
      if (this.bo) {
         var1 = 3;
         if (this.cdir == 1) {
            var1 = -3;
         }
      }

      if (this.bn) {
         if (this.arrItemMounts[4].template.id == 485) {
            var1 = 4;
            if (this.cdir == 1) {
               var1 = -4;
            }
         } else {
            var1 = 7;
            if (this.cdir == 1) {
               var1 = -7;
            }
         }
      }

      if (this.bq) {
         var1 = 1;
         if (this.cdir == 1) {
            var1 = -1;
         }
      }

      return var1;
   }

   private void l(mGraphics var1, int var2, int var3, int var4) {
      DataSkillEff var5 = a(this.ID_HAIR, false);
      int var6 = 0;
      if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
         var6 = this.bm * var4;
      }

      if (var5 != null) {
         var5.a(var1, var2 + this.bf(), var3 + var6 - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.im * 30 : this.bc(), this.cdir == 1 ? 0 : 2);
         var5.b(var1, var2 + this.bf(), var3 + var6 - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.im * 30 : this.bc(), this.cdir == 1 ? 0 : 2);
      }

   }

   private void m(mGraphics var1, int var2, int var3, int var4) {
      if (this.ID_MAT_NA >= 0) {
         DataSkillEff var5 = a(this.ID_MAT_NA, false);
         int var6 = 0;
         if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
            var6 = this.bm * var4;
         }

         if (var5 != null) {
            if (this.bo && (this.arrItemMounts[4].template.id == 443 || this.arrItemMounts[4].template.id == 523)) {
               byte var8 = -2;
               if (this.statusMe == 1 || this.statusMe == 6) {
                  var8 = 0;
               }

               byte var7 = 0;
               if (this.cgender == 1) {
                  var7 = 3;
               }

               if (this.statusMe == 1 || this.statusMe == 6) {
                  var7 = 0;
               }

               var5.a(var1, var2 + var8, var3 + var6 - this.be() - var7, this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ia * 30 : this.az(), this.cdir == 1 ? 0 : 2);
               var5.b(var1, var2 + var8, var3 + var6 - this.be() - var7, this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ia * 30 : this.az(), this.cdir == 1 ? 0 : 2);
               return;
            }

            var5.a(var1, var2 + this.bf(), var3 + var6 - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ia * 30 : this.az(), this.cdir == 1 ? 0 : 2);
            var5.b(var1, var2 + this.bf(), var3 + var6 - this.be(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.ia * 30 : this.az(), this.cdir == 1 ? 0 : 2);
         }
      }

   }

   private void d(mGraphics var1) {
      DataSkillEff var2 = a(this.ID_PP, false);
      boolean var3 = false;
      int var4 = 0;
      byte var5;
      if (this.bn) {
         if (this.arrItemMounts[4].template.id == 485) {
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            if (var2 != null) {
               var2.a(var1, this.cx1 + this.bf(), this.cy1 - 9 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
            }
         }

         if (this.arrItemMounts[4].template.id == 524) {
            var5 = 2;
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            if (this.cdir == 1) {
               var5 = -2;
            }

            if (var2 != null) {
               var2.a(var1, this.cx1 + var5 + this.bf(), this.cy1 - 12 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
               return;
            }
         }
      } else if (this.bo) {
         if (this.arrItemMounts[4].template.id == 523) {
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            var5 = 2;
            if (this.cdir == 1) {
               var5 = -2;
            }

            if (var2 != null) {
               var2.a(var1, this.cx1 + var5 + this.bf(), this.cy1 - 15 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
               return;
            }
         } else if (this.arrItemMounts[4].template.id == 443) {
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            var5 = 2;
            if (this.cdir == 1) {
               var5 = -2;
            }

            if (var2 != null) {
               var2.a(var1, this.cx1 + var5 + this.bf(), this.cy1 - 15 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
               return;
            }
         }
      } else if (this.bq) {
         var5 = -4;
         if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
            var4 = this.bm;
         }

         if (this.cdir == 1) {
            var5 = 4;
         }

         if (var2 != null) {
            var2.a(var1, this.cx1 + var5 + this.bf(), this.cy1 - 18 + this.jr + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
            return;
         }
      } else if (var2 != null) {
         var2.a(var1, this.cx1 + this.ji + this.bf(), this.cy1 - this.jh - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
      }

   }

   private void e(mGraphics var1) {
      DataSkillEff var2 = a(this.ID_PP, false);
      boolean var3 = false;
      int var4 = 0;
      byte var5;
      if (this.bn) {
         if (this.arrItemMounts[4].template.id == 485) {
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            if (var2 != null) {
               var2.b(var1, this.cx1 + this.bf(), this.cy1 - 9 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
            }
         }

         if (this.arrItemMounts[4].template.id == 524) {
            var5 = 2;
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            if (this.cdir == 1) {
               var5 = -2;
            }

            if (var2 != null) {
               var2.b(var1, this.cx1 + var5 + this.bf(), this.cy1 - 12 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
               return;
            }
         }
      } else if (this.bo) {
         if (this.arrItemMounts[4].template.id == 523) {
            var5 = 2;
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            if (this.cdir == 1) {
               var5 = -2;
            }

            if (var2 != null) {
               var2.b(var1, this.cx1 + var5 + this.bf(), this.cy1 - 15 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
               return;
            }
         } else if (this.arrItemMounts[4].template.id == 443) {
            if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
               var4 = this.bm << 1;
            }

            var5 = 2;
            if (this.cdir == 1) {
               var5 = -2;
            }

            if (var2 != null) {
               var2.b(var1, this.cx1 + var5 + this.bf(), this.cy1 - 15 + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
               return;
            }
         }
      } else if (this.bq) {
         var5 = -4;
         if ((this.statusMe == 1 || this.statusMe == 6) && this.bm <= 1) {
            var4 = this.bm;
         }

         if (this.cdir == 1) {
            var5 = 4;
         }

         if (var2 != null) {
            var2.b(var1, this.cx1 + var5 + this.bf(), this.cy1 - 18 + this.jr + var4 - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
            return;
         }
      } else if (var2 != null) {
         var2.b(var1, this.cx1 + this.ji + this.bf(), this.cy1 - this.jh - this.be(), this.bd(), this.cdir == 1 ? 0 : 2);
      }

   }

   private int bg() {
      DataSkillEff var1;
      if (this.ID_HORSE > -1 && (var1 = a(this.ID_HORSE, true)) != null && var1.d) {
         return var1.p + var1.m[this.aw()];
      } else {
         return !this.bo && !this.bn && !this.bq ? 0 : 12;
      }
   }

   private void f(mGraphics var1) {
      try {
         DataSkillEff var2;
         if ((var2 = a(this.ID_WEA_PONE, false)) != null && GameCanvas.w % 3 == 0) {
            int var3;
            if ((var3 = var2.b.size() / 30) == 0) {
               var3 = 1;
            }

            this.ie = (byte)((this.ie + 1) % var3);
         }

         DataSkillEff var20;
         if ((var20 = a(this.ID_Bien_Hinh, false)) != null && GameCanvas.w % 6 == 0) {
            int var4;
            if ((var4 = var20.b.size() / 30) == 0) {
               var4 = 1;
            }

            this.ic = (byte)((this.ic + 1) % var4);
         }

         DataSkillEff var23;
         if ((var23 = a(this.ID_MAT_NA, false)) != null && GameCanvas.w % 6 == 0) {
            int var5;
            if ((var5 = var23.b.size() / 30) == 0) {
               var5 = 1;
            }

            this.ia = (byte)((this.ia + 1) % var5);
         }

         DataSkillEff var25 = a(this.ff, false);
         DataSkillEff var6 = a(this.ID_RANK, false);
         DataSkillEff var7 = a(this.ID_NAME, false);
         DataSkillEff var8;
         if ((var8 = a(this.ID_LEG, false)) != null && GameCanvas.w % 6 == 0) {
            int var9;
            if ((var9 = var8.b.size() / 30) == 0) {
               var9 = 1;
            }

            this.ii = (byte)((this.ii + 1) % var9);
         }

         DataSkillEff var27;
         if ((var27 = a(this.ID_HORSE, true)) != null && var27.d && GameCanvas.w % 10 == 0) {
            int var10;
            if ((var10 = var27.b.size() / var27.c.length) == 0) {
               var10 = 1;
            }

            this.iv = (byte)((this.iv + 1) % var10);
         }

         DataSkillEff var28;
         if ((var28 = a(this.ID_Body, false)) != null && GameCanvas.w % 6 == 0) {
            int var11;
            if ((var11 = var28.b.size() / 30) == 0) {
               var11 = 1;
            }

            this.ik = (byte)((this.ik + 1) % var11);
         }

         DataSkillEff var29;
         if ((var29 = a(this.ID_HAIR, false)) != null && GameCanvas.w % 6 == 0) {
            int var12;
            if ((var12 = var29.b.size() / 30) == 0) {
               var12 = 1;
            }

            this.im = (byte)((this.im + 1) % var12);
         }

         DataSkillEff var30;
         if ((var30 = a(this.ID_PP, false)) != null && GameCanvas.w % 6 == 0) {
            int var13;
            if ((var13 = var30.b.size() / 30) == 0) {
               var13 = 1;
            }

            this.it = (byte)((this.it + 1) % var13);
         }

         Object var31 = null;
         Part var14 = GameScr.ac[this.head];
         Part var15 = GameScr.ac[this.leg];
         Part var16 = GameScr.ac[this.body];
         Part var17 = GameScr.ac[this.weapon];
         if (var2 != null) {
            var17 = null;
         }

         if (this.arrItemBody != null && this.arrItemBody[11] != null) {
            var14 = GameScr.ac[this.arrItemBody[11].template.part];
            this.head = this.arrItemBody[11].template.part;
         }

         int var18;
         if (var14.a != null && var14.a.length >= 8) {
            for(var18 = 0; var18 < var14.a.length; ++var18) {
               if (var14.a[var18] == null || !SmallImage.a(var14.a[var18].a)) {
                  var14 = b(this.cgender);
                  break;
               }
            }
         } else {
            var14 = b(this.cgender);
         }

         int[] var33 = var14.a[ea[this.bm][0][0]].a <= 4 ? null : this.s();
         if (((this.statusMe == 1 || this.statusMe == 6) && GameCanvas.w % 10 == 0 || (this.statusMe == 2 || this.statusMe == 10) && GameCanvas.w % 2 == 0 || (this.statusMe == 4 || this.statusMe == 3) && GameCanvas.w % 3 == 0) && var33 != null) {
            ++this.dg;
            if (this.dg > var33.length - 1) {
               this.dg = 0;
            }
         }

         if (this.statusMe == 14) {
            if (this.ad()) {
               this.g(var1);
            } else if (this.p()) {
               if (this.arrItemMounts[4].template.id == 485) {
                  if (this.arrItemMounts[4].sys < 2) {
                     SmallImage.a(var1, 1800, this.fo, this.fp, 2, 33);
                  } else {
                     SmallImage.a(var1, 2063, this.fo, this.fp, 2, 33);
                  }
               } else if (this.arrItemMounts[4].template.id == 524) {
                  if (this.arrItemMounts[4].sys < 2) {
                     SmallImage.a(var1, 2064, this.fo, this.fp, 2, 33);
                  } else {
                     SmallImage.a(var1, 2068, this.fo, this.fp, 2, 33);
                  }
               }
            }

            SmallImage.a(var1, 1040, this.cx1, this.cy1, 0, 33);
         } else if (this.dh) {
            if (this.bk) {
               if (GameCanvas.w % 50 != 48 && GameCanvas.w % 50 != 90) {
                  SmallImage.a(var1, 1195, this.cx1, this.cy1 - 18, 0, 3);
               } else {
                  SmallImage.a(var1, 1196, this.cx1, this.cy1 - 18, 0, 3);
               }
            }
         } else {
            if (var25 != null) {
               var25.a(var1, this.cx1, this.cy1 - this.bg(), this.ig, this.cdir == 1 ? 0 : 2);
            }

            if (var2 != null) {
               this.a(var1, this.cx1, this.cy1, 2, var2);
            }

            if (var20 != null) {
               var20.a(var1, this.cx1, this.cy1, this.ax(), this.cdir == 1 ? 0 : 2);
               var20.b(var1, this.cx1, this.cy1, this.ax(), this.cdir == 1 ? 0 : 2);
            }

            if (var27 != null) {
               var27.a(var1, this.cx1, this.cy1, this.aw(), this.cdir == 1 ? 2 : 0);
            }

            if (var6 != null) {
               var6.a(var1, this.cx1, this.cy1 - this.bg(), this.hy, this.cdir == 1 ? 0 : 2);
            }

            if (var7 != null) {
               var7.a(var1, this.cx1, this.cy1 - this.bg(), this.hw, 0);
            }

            this.d(var1);
            int[] var22;
            int[] var35;
            if (this.bn) {
               var18 = 0;
               boolean var21 = false;
               int var26 = 0;
               boolean var34 = false;
               if ((var35 = this.at()) != null) {
                  ++this.fz;
                  if (this.fz >= var35.length) {
                     this.fz = 0;
                  }
               }

               int var10000;
               if (this.arrItemMounts[4].template.id == 485) {
                  if (this.arrItemMounts[4].sys < 2) {
                     label1654: {
                        if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe != 2 && this.statusMe != 10) {
                              break label1654;
                           }

                           var10000 = GameCanvas.w % 6 > 3 ? 1 : 0;
                        } else {
                           var18 = GameCanvas.w % 20 > 12 ? 1 : 0;
                           if (var30 == null && var28 == null && var29 == null && var2 == null && var23 == null || this.bm > 1) {
                              break label1654;
                           }

                           var10000 = this.bm;
                        }

                        var18 = var10000;
                     }

                     if (this.statusMe == 3) {
                        var26 = -5 * this.cdir;
                     }

                     if (this.cdir == 1) {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 1711, this.cx1, this.cy1 + 2, 0, 33);
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 1709 : 1710, this.cx1, this.cy1, 0, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 0, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 0, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     } else {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 1711, this.cx1, this.cy1 + 2, 2, 33);
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 1709 : 1710, this.cx1, this.cy1, 2, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 2, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 2, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     }
                  } else {
                     label1655: {
                        if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe != 2 && this.statusMe != 10) {
                              break label1655;
                           }

                           var10000 = GameCanvas.w % 6 > 3 ? 1 : 0;
                        } else {
                           var18 = GameCanvas.w % 20 > 12 ? 1 : 0;
                           if (var30 == null && var28 == null && var29 == null && var2 == null && var23 == null || this.bm > 1) {
                              break label1655;
                           }

                           var10000 = this.bm;
                        }

                        var18 = var10000;
                     }

                     if (this.statusMe == 3) {
                        var26 = -5 * this.cdir;
                     }

                     if (this.cdir == 1) {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2057, this.cx1, this.cy1 + 2, 0, 33);
                        } else if (!this.fw) {
                           SmallImage.a(var1, var18 == 0 ? 2056 : 2055, this.cx1, this.cy1, 0, 33);
                        } else {
                           SmallImage.a(var1, 2057, this.cx1, this.cy1, 0, 33);
                        }

                        if (this.statusMe == 2 && var35 != null) {
                           SmallImage.a(var1, var35[this.fz], this.cx1 - 25, this.cy1 - 2, 0, 33);
                        }

                        if (!this.fw) {
                           if (var29 != null) {
                              this.l(var1, this.cx1, this.cy1 - 8, 2);
                           } else {
                              SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 0, 17);
                           }

                           if (var28 != null) {
                              this.k(var1, this.cx1, this.cy1 - 8, 2);
                           } else {
                              SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 0, 33);
                           }

                           this.m(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           if (var29 != null) {
                              this.l(var1, this.cx1, this.cy1 - 8, 2);
                           } else {
                              SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir - 3, this.cy1 - 1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 0, 17);
                           }

                           if (var28 != null) {
                              this.k(var1, this.cx1, this.cy1 - 8, 2);
                           } else {
                              SmallImage.a(var1, this.bi(), this.cx1 - 3 + this.hp * this.cdir, this.cy1 - 1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 0, 33);
                           }

                           this.m(var1, this.cx1, this.cy1 - 8, 2);
                        }
                     } else {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2057, this.cx1, this.cy1 + 2, 2, 33);
                        } else if (!this.fw) {
                           SmallImage.a(var1, var18 == 0 ? 2056 : 2055, this.cx1, this.cy1, 2, 33);
                        } else {
                           SmallImage.a(var1, 2057, this.cx1, this.cy1, 2, 33);
                        }

                        if (this.statusMe == 2 && var35 != null) {
                           SmallImage.a(var1, var35[this.fz], this.cx1 + 25, this.cy1 - 2, 2, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 2, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 2, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     }
                  }
               } else if (this.arrItemMounts[4].template.id == 524) {
                  if (this.arrItemMounts[4].sys < 2) {
                     label1656: {
                        if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe != 2 && this.statusMe != 10) {
                              break label1656;
                           }

                           var10000 = GameCanvas.w % 6 > 3 ? 1 : 0;
                        } else {
                           var18 = GameCanvas.w % 20 > 12 ? 1 : 0;
                           if (var30 == null && var28 == null && var29 == null && var2 == null && var23 == null || this.bm > 1) {
                              break label1656;
                           }

                           var10000 = this.bm;
                        }

                        var18 = var10000;
                     }

                     if (this.statusMe == 3) {
                        var26 = -5 * this.cdir;
                     }

                     if (this.cdir == 1) {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2066, this.cx1, this.cy1 + 2, 0, 33);
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 2064 : 2065, this.cx1, this.cy1, 0, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 0, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 0, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     } else {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2066, this.cx1, this.cy1 + 2, 2, 33);
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 2064 : 2065, this.cx1, this.cy1, 2, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 2, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 2, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     }
                  } else if (this.arrItemMounts[4].sys >= 2 && this.arrItemMounts[4].sys < 4) {
                     if ((var22 = this.au()) != null) {
                        ++this.fz;
                        if (this.fz >= var22.length) {
                           this.fz = 0;
                        }
                     }

                     label1657: {
                        if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe != 2 && this.statusMe != 10) {
                              break label1657;
                           }

                           var10000 = GameCanvas.w % 6 > 3 ? 1 : 0;
                        } else {
                           var18 = GameCanvas.w % 20 > 12 ? 1 : 0;
                           if (var30 == null && var28 == null && var29 == null && var2 == null && var23 == null || this.bm > 1) {
                              break label1657;
                           }

                           var10000 = this.bm;
                        }

                        var18 = var10000;
                     }

                     if (this.statusMe == 3) {
                        var26 = -5 * this.cdir;
                     }

                     if (this.cdir == 1) {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2070, this.cx1, this.cy1 + 2, 0, 33);
                        } else if (this.statusMe == 4) {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 0, 33);
                        } else if (this.statusMe != 2 && this.statusMe != 10) {
                           if (this.statusMe == 1 || this.statusMe == 6) {
                              SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 0, 33);
                           }
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 0, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 0, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 0, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     } else {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2070, this.cx1, this.cy1 + 2, 2, 33);
                        }

                        if (this.statusMe == 4) {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 2, 33);
                        } else if (this.statusMe != 2 && this.statusMe != 10) {
                           if (this.statusMe == 1 || this.statusMe == 6) {
                              SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 2, 33);
                           }
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 2, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 2, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 2, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     }
                  } else {
                     if ((var22 = this.au()) != null) {
                        ++this.fz;
                        if (this.fz >= var22.length) {
                           this.fz = 0;
                        }
                     }

                     label1658: {
                        if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe != 2 && this.statusMe != 10) {
                              break label1658;
                           }

                           var10000 = GameCanvas.w % 6 > 3 ? 1 : 0;
                        } else {
                           var18 = GameCanvas.w % 20 > 12 ? 1 : 0;
                           if (var30 == null && var28 == null && var29 == null && var2 == null && var23 == null || this.bm > 1) {
                              break label1658;
                           }

                           var10000 = this.bm;
                        }

                        var18 = var10000;
                     }

                     if (this.statusMe == 3) {
                        var26 = -5 * this.cdir;
                     }

                     if (this.cdir == 1) {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2070, this.cx1, this.cy1 + 2, 0, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 + 13, this.cy1 - 17, 0, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 - 24, this.cy1 + 2, 0, 33);
                        } else if (this.statusMe == 4) {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 0, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 + 15, this.cy1, 0, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 - 27, this.cy1, 0, 33);
                        } else if (this.statusMe != 2 && this.statusMe != 10) {
                           if (this.statusMe == 1 || this.statusMe == 6) {
                              SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 0, 33);
                              SmallImage.a(var1, var22[this.fz], this.cx1 + 15, this.cy1, 0, 33);
                              SmallImage.a(var1, var22[this.fz], this.cx1 - 27, this.cy1, 0, 33);
                           }
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 0, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 + 15, this.cy1, 0, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 - 27, this.cy1, 0, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 0, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 0, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     } else {
                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2070, this.cx1, this.cy1 + 2, 2, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 - 12, this.cy1 - 17, 2, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 + 25, this.cy1 + 3, 2, 33);
                        }

                        if (this.statusMe == 4) {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 2, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 - 15, this.cy1, 2, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 + 27, this.cy1, 2, 33);
                        } else if (this.statusMe != 2 && this.statusMe != 10) {
                           if (this.statusMe == 1 || this.statusMe == 6) {
                              SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 2, 33);
                              SmallImage.a(var1, var22[this.fz], this.cx1 - 15, this.cy1, 2, 33);
                              SmallImage.a(var1, var22[this.fz], this.cx1 + 27, this.cy1, 2, 33);
                           }
                        } else {
                           SmallImage.a(var1, var18 == 0 ? 2068 : 2069, this.cx1, this.cy1, 2, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 - 15, this.cy1, 2, 33);
                           SmallImage.a(var1, var22[this.fz], this.cx1 + 27, this.cy1, 2, 33);
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + var26 + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 + var18 + this.ho, 2, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1, this.cy1 - 8, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 8 + var18 + this.hq, 2, 33);
                        }

                        this.m(var1, this.cx1, this.cy1 - 8, 2);
                     }
                  }
               }
            } else {
               byte var24;
               if (this.bo) {
                  int[] var36;
                  if ((var36 = this.av()) != null) {
                     ++this.ga;
                     if (this.ga >= var36.length) {
                        this.ga = 0;
                     }
                  }

                  if (this.statusMe != 1 && this.statusMe != 6) {
                     if (this.statusMe == 2 || this.statusMe == 10) {
                        if (GameCanvas.w % 12 <= 3) {
                           this.hr = 0;
                        } else if (GameCanvas.w % 12 <= 6) {
                           this.hr = 1;
                           this.hs = 2;
                        } else if (GameCanvas.w % 12 <= 9) {
                           this.hr = 2;
                           this.hs = 4;
                        } else {
                           this.hr = 3;
                           this.hs = 2;
                        }
                     }
                  } else {
                     this.hr = GameCanvas.w % 20 > 12 ? 1 : 0;
                     if ((var30 != null || var28 != null || var29 != null || var2 != null || var23 != null) && this.bm <= 1) {
                        this.hr = this.bm;
                     }

                     this.hs = -this.hr;
                  }

                  var22 = new int[]{2050, 2053, 2049, 2052};
                  int[] var32 = new int[]{2075, 2078, 2074, 2079};
                  var33 = new int[]{this.cy1 - 22, this.cy1 - 23, this.cy1 - 22, this.cy1 - 23};
                  var35 = new int[]{this.cy1 - 22, this.cy1 - 23, this.cy1 - 22, this.cy1 - 22};
                  if (this.statusMe == 3) {
                     this.ht = -5 * this.cdir;
                     this.hu = 0;
                  } else {
                     this.ht = -3 * this.cdir;
                     this.hu = 0;
                  }

                  if (this.arrItemMounts[4].template.id == 523) {
                     if (this.cdir == 1) {
                        if (var17 != null) {
                           SmallImage.a(var1, var17.a[ea[this.bm][3][0]].a, this.cx1 + ea[this.bm][3][1] + var17.a[ea[this.bm][3][0]].b, this.cy1 - ea[this.bm][3][2] + var17.a[ea[this.bm][3][0]].c - 10, 0, 0);
                        }

                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2051, this.cx1, this.cy1, 0, 33);
                        } else if (this.statusMe == 4) {
                           SmallImage.a(var1, 2052, this.cx1, this.cy1, 0, 33);
                        } else if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe == 2 || this.statusMe == 10) {
                              SmallImage.a(var1, var22[this.hr], this.cx1, this.cy1 - this.hs, 0, 33);
                           }
                        } else {
                           SmallImage.a(var1, this.hr == 0 ? 2047 : 2048, this.cx1, this.cy1, 0, 33);
                        }

                        var24 = 2;
                        if (this.cdir == 1) {
                           var24 = -2;
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1 + var24, this.cy1 - 15, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + this.ht + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 - this.hs + this.ho, 0, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1 + var24, this.cy1 - 15, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.ht + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 9 - this.hs + this.hq, 0, 33);
                        }

                        this.m(var1, this.cx1 + var24, this.cy1 - 15, 2);
                     } else {
                        if (var17 != null) {
                           SmallImage.a(var1, var17.a[ea[this.bm][3][0]].a, this.cx1 - ea[this.bm][3][1] - var17.a[ea[this.bm][3][0]].b, this.cy1 - ea[this.bm][3][2] + var17.a[ea[this.bm][3][0]].c - 10, 2, 24);
                        }

                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 2051, this.cx1, this.cy1, 2, 33);
                        } else if (this.statusMe == 4) {
                           SmallImage.a(var1, 2052, this.cx1, this.cy1, 2, 33);
                        } else if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe == 2 || this.statusMe == 10) {
                              SmallImage.a(var1, var22[this.hr], this.cx1, this.cy1 - this.hs, 2, 33);
                           }
                        } else {
                           SmallImage.a(var1, this.hr == 0 ? 2047 : 2048, this.cx1, this.cy1, 2, 33);
                        }

                        var24 = 2;
                        if (this.cdir == 1) {
                           var24 = -2;
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1 + var24, this.cy1 - 15, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + this.ht + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 - this.hs + this.ho, 2, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1 + var24, this.cy1 - 15, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.ht + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 9 - this.hs + this.hq, 2, 33);
                        }

                        this.m(var1, this.cx1 + var24, this.cy1 - 15, 2);
                     }
                  } else if (this.arrItemMounts[4].template.id == 443) {
                     if (this.arrItemMounts[4].sys >= 3) {
                        if (this.cdir == 1) {
                           if (var17 != null) {
                              SmallImage.a(var1, var17.a[ea[this.bm][3][0]].a, this.cx1 + ea[this.bm][3][1] + var17.a[ea[this.bm][3][0]].b, this.cy1 - ea[this.bm][3][2] + var17.a[ea[this.bm][3][0]].c - 10, 0, 0);
                           }

                           if (this.statusMe == 3) {
                              SmallImage.a(var1, 2077, this.cx1, this.cy1, 0, 33);
                              var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 + 21, this.cy1 - 30, 0);
                           } else if (this.statusMe == 4) {
                              SmallImage.a(var1, 2076, this.cx1, this.cy1, 0, 33);
                              var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 + 21, this.cy1 - 19, 0);
                           } else if (this.statusMe != 1 && this.statusMe != 6) {
                              if (this.statusMe == 2 || this.statusMe == 10) {
                                 SmallImage.a(var1, var32[this.hr], this.cx1, this.cy1 - this.hs, 0, 33);
                                 var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 + 21, var33[this.hr], 0);
                              }
                           } else {
                              SmallImage.a(var1, this.hr == 0 ? 2073 : 2072, this.cx1, this.cy1, 0, 33);
                              var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 + 21, this.cy1 - 19, 0);
                           }

                           var24 = 2;
                           if (this.cdir == 1) {
                              var24 = -2;
                           }

                           if (var29 != null) {
                              this.l(var1, this.cx1 + var24, this.cy1 - 15, 2);
                           } else {
                              SmallImage.a(var1, this.bj(), this.cx1 + this.ht + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 - this.hs + this.ho, 0, 17);
                           }

                           if (var28 != null) {
                              this.k(var1, this.cx1 + var24, this.cy1 - 15, 2);
                           } else {
                              SmallImage.a(var1, this.bi(), this.cx1 + this.ht + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 9 - this.hs + this.hq, 0, 33);
                           }

                           this.m(var1, this.cx1 + var24, this.cy1 - 15, 2);
                        } else {
                           if (var17 != null) {
                              SmallImage.a(var1, var17.a[ea[this.bm][3][0]].a, this.cx1 - ea[this.bm][3][1] - var17.a[ea[this.bm][3][0]].b, this.cy1 - ea[this.bm][3][2] + var17.a[ea[this.bm][3][0]].c - 10, 2, 24);
                           }

                           if (this.statusMe == 3) {
                              SmallImage.a(var1, 2077, this.cx1, this.cy1, 2, 33);
                              var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 - 23, this.cy1 - 30, 0);
                           } else if (this.statusMe == 4) {
                              SmallImage.a(var1, 2076, this.cx1, this.cy1, 2, 33);
                              var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 - 24, this.cy1 - 20, 0);
                           } else if (this.statusMe != 1 && this.statusMe != 6) {
                              if (this.statusMe == 2 || this.statusMe == 10) {
                                 SmallImage.a(var1, var32[this.hr], this.cx1, this.cy1 - this.hs, 2, 33);
                                 var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 - 24, var35[this.hr], 0);
                              }
                           } else {
                              SmallImage.a(var1, this.hr == 0 ? 2073 : 2072, this.cx1, this.cy1, 2, 33);
                              var1.a(GameScr.ec, 0, this.fm * 3, 3, 3, 0, this.cx1 - 24, this.cy1 - 20, 0);
                           }

                           var24 = 2;
                           if (this.cdir == 1) {
                              var24 = -2;
                           }

                           if (var29 != null) {
                              this.l(var1, this.cx1 + var24, this.cy1 - 15, 2);
                           } else {
                              SmallImage.a(var1, this.bj(), this.cx1 + this.ht + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 - this.hs + this.ho, 2, 17);
                           }

                           if (var28 != null) {
                              this.k(var1, this.cx1 + var24, this.cy1 - 15, 2);
                           } else {
                              SmallImage.a(var1, this.bi(), this.cx1 + this.ht + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 9 - this.hs + this.hq, 2, 33);
                           }

                           this.m(var1, this.cx1 + var24, this.cy1 - 15, 2);
                        }
                     } else if (this.cdir == 1) {
                        if (var17 != null) {
                           SmallImage.a(var1, var17.a[ea[this.bm][3][0]].a, this.cx1 + ea[this.bm][3][1] + var17.a[ea[this.bm][3][0]].b, this.cy1 - ea[this.bm][3][2] + var17.a[ea[this.bm][3][0]].c - 10, 0, 0);
                        }

                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 1716, this.cx1, this.cy1, 0, 33);
                        } else if (this.statusMe == 4) {
                           SmallImage.a(var1, 1717, this.cx1, this.cy1, 0, 33);
                        } else if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe == 2 || this.statusMe == 10) {
                              SmallImage.a(var1, this.hv[this.hr], this.cx1, this.cy1 - this.hs, 0, 33);
                           }
                        } else {
                           SmallImage.a(var1, this.hr == 0 ? 1712 : 1713, this.cx1, this.cy1, 0, 33);
                        }

                        var24 = 2;
                        if (this.cdir == 1) {
                           var24 = -2;
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1 + var24, this.cy1 - 14, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + this.ht + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 - this.hs + this.ho, 0, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1 + var24, this.cy1 - 14, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.ht + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 9 - this.hs + this.hq, 0, 33);
                        }

                        this.m(var1, this.cx1 + var24, this.cy1 - 14, 2);
                     } else {
                        if (var17 != null) {
                           SmallImage.a(var1, var17.a[ea[this.bm][3][0]].a, this.cx1 - ea[this.bm][3][1] - var17.a[ea[this.bm][3][0]].b, this.cy1 - ea[this.bm][3][2] + var17.a[ea[this.bm][3][0]].c - 10, 2, 24);
                        }

                        if (this.statusMe == 3) {
                           SmallImage.a(var1, 1716, this.cx1, this.cy1, 2, 33);
                        } else if (this.statusMe == 4) {
                           SmallImage.a(var1, 1717, this.cx1, this.cy1, 2, 33);
                        } else if (this.statusMe != 1 && this.statusMe != 6) {
                           if (this.statusMe == 2 || this.statusMe == 10) {
                              SmallImage.a(var1, this.hv[this.hr], this.cx1, this.cy1 - this.hs, 2, 33);
                           }
                        } else {
                           SmallImage.a(var1, this.hr == 0 ? 1712 : 1713, this.cx1, this.cy1, 2, 33);
                        }

                        var24 = 2;
                        if (this.cdir == 1) {
                           var24 = -2;
                        }

                        if (var29 != null) {
                           this.l(var1, this.cx1 - var24, this.cy1 - 14, 2);
                        } else {
                           SmallImage.a(var1, this.bj(), this.cx1 + this.ht + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var14.a[ea[0][0][0]].c - 12 - this.hs + this.ho, 2, 17);
                        }

                        if (var28 != null) {
                           this.k(var1, this.cx1 + var24, this.cy1 - 14, 2);
                        } else {
                           SmallImage.a(var1, this.bi(), this.cx1 + this.ht + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 9 - this.hs + this.hq, 2, 33);
                        }

                        this.m(var1, this.cx1 + var24, this.cy1 - 14, 2);
                     }
                  }
               } else {
                  byte var37 = 2;
                  var24 = 24;
                  if (this.cdir == 1) {
                     var37 = 0;
                     var24 = 0;
                  }

                  if (this.bq) {
                     this.a(var1, var17, var14, var33);
                     if (var25 != null) {
                        var25.b(var1, this.cx1, this.cy1 - this.bg(), this.ig, this.cdir == 1 ? 0 : 2);
                     }

                     this.e(var1);
                     if (var7 != null) {
                        var7.b(var1, this.cx1, this.cy1 - this.bg(), this.hw, 0);
                     }

                     if (var6 != null) {
                        var6.b(var1, this.cx1, this.cy1 - this.bg(), this.hy, this.cdir == 1 ? 0 : 2);
                     }

                     if (var2 != null) {
                        this.b(var1, this.cx1, this.cy1, 2, var2);
                     }

                     return;
                  }

                  if (this.bp) {
                     if (this.ad()) {
                        this.g(var1);
                     } else if (!this.bn && !this.bo) {
                        if (this.arrItemMounts[4].template.id == 485) {
                           if (this.arrItemMounts[4].sys <= 1) {
                              SmallImage.a(var1, 1800, this.fo, this.fp, 2, 33);
                           } else {
                              SmallImage.a(var1, 2063, this.fo, this.fp, 2, 33);
                           }
                        } else if (this.arrItemMounts[4].template.id == 524) {
                           if (this.arrItemMounts[4].sys <= 1) {
                              SmallImage.a(var1, 2067, this.fo, this.fp, 2, 33);
                           } else {
                              SmallImage.a(var1, 2071, this.fo, this.fp, 2, 33);
                           }
                        }
                     }
                  }

                  if (var33 != null && var30 == null) {
                     SmallImage.a(var1, var33[this.dg], this.cx1 + this.ji - 7 * this.cdir, this.cy1 - this.jh - 18, var37, 17);
                  }

                  if (var17 != null) {
                     SmallImage.a(var1, var17.a[ea[this.bm][3][0]].a, this.cx1 + this.ji + (ea[this.bm][3][1] + var17.a[ea[this.bm][3][0]].b) * this.cdir, this.cy1 - this.jh - ea[this.bm][3][2] + var17.a[ea[this.bm][3][0]].c, var37, var24);
                  }

                  if (var27 == null) {
                     if (var8 != null) {
                        var8.a(var1, this.cx1, this.cy1, this.ay(), this.cdir == 1 ? 0 : 2);
                        var8.b(var1, this.cx1, this.cy1, this.ay(), this.cdir == 1 ? 0 : 2);
                     } else {
                        SmallImage.a(var1, var15.a[ea[this.bm][1][0]].a, this.cx1 + (ea[this.bm][1][1] + var15.a[ea[this.bm][1][0]].b) * this.cdir, this.cy1 - ea[this.bm][1][2] + var15.a[ea[this.bm][1][0]].c, var37, var24);
                     }
                  }

                  if (this.statusMe != 2) {
                     this.c(var1, this.cx1 + 7 * this.cdir, this.cy1 - 2 - this.bg());
                  }

                  if (this.statusMe != 1 && this.statusMe != 6) {
                     if (var29 != null) {
                        var29.a(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.bc(), this.cdir == 1 ? 0 : 2);
                        var29.b(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.bc(), this.cdir == 1 ? 0 : 2);
                     } else {
                        SmallImage.a(var1, var14.a[ea[this.bm][0][0]].a, this.cx1 + this.ji + (ea[this.bm][0][1] + var14.a[ea[this.bm][0][0]].b) * this.cdir, this.cy1 - this.jh - ea[this.bm][0][2] + var14.a[ea[this.bm][0][0]].c, var37, var24);
                     }
                  }

                  if (var28 != null) {
                     var28.a(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.bb(), this.cdir == 1 ? 0 : 2);
                     var28.b(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.bb(), this.cdir == 1 ? 0 : 2);
                  } else {
                     SmallImage.a(var1, var16.a[ea[this.bm][2][0]].a, this.cx1 + this.ji + (ea[this.bm][2][1] + var16.a[ea[this.bm][2][0]].b) * this.cdir, this.cy1 - ea[this.bm][2][2] + var16.a[ea[this.bm][2][0]].c - this.jh, var37, var24);
                  }

                  if (this.statusMe == 1 || this.statusMe == 6) {
                     if (var29 != null) {
                        var29.a(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.bc(), this.cdir == 1 ? 0 : 2);
                        var29.b(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.bc(), this.cdir == 1 ? 0 : 2);
                     } else {
                        SmallImage.a(var1, var14.a[ea[this.bm][0][0]].a, this.cx1 + this.ji + (ea[this.bm][0][1] + var14.a[ea[this.bm][0][0]].b) * this.cdir, this.cy1 - this.jh - ea[this.bm][0][2] + var14.a[ea[this.bm][0][0]].c, var37, var24);
                     }
                  }

                  if (var23 != null) {
                     var23.a(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.az(), this.cdir == 1 ? 0 : 2);
                     var23.b(var1, this.cx1 + this.ji, this.cy1 - this.jh, this.az(), this.cdir == 1 ? 0 : 2);
                  }

                  if (this.statusMe == 2) {
                     this.e(var1, this.cx1 - 14 * this.cdir, this.cy1 - 2 - this.bg());
                     this.d(var1, this.cx1 + 7 * this.cdir, this.cy1 - 2 - this.bg());
                  } else {
                     this.c(var1, this.cx1 - 7 * this.cdir, this.cy1 - 2 - this.bg());
                     this.d(var1, this.cx1 + 11 * this.cdir, this.cy1 - 2 - this.bg());
                  }
               }
            }

            if (var27 != null) {
               var27.b(var1, this.cx1, this.cy1, this.aw(), this.cdir == 1 ? 2 : 0);
            }

            if (var25 != null) {
               var25.b(var1, this.cx1, this.cy1 - this.bg(), this.ig, this.cdir == 1 ? 0 : 2);
            }

            this.e(var1);
            if (var7 != null) {
               var7.b(var1, this.cx1, this.cy1 - this.bg(), this.hw, 0);
            }

            if (var6 != null) {
               var6.b(var1, this.cx1, this.cy1 - this.bg(), this.hy, this.cdir == 1 ? 0 : 2);
            }

            if (var2 != null) {
               this.b(var1, this.cx1, this.cy1, 2, var2);
            }
         }

         if (this.ej) {
            SmallImage.a(var1, 290, this.cx1, this.cy1, 0, 33);
            return;
         }
      } catch (Exception var26) {
      }

   }

   private int bh() {
      CharPartInfo var1;
      if ((var1 = (CharPartInfo)CharPartInfo.a.a(String.valueOf(this.leg))) != null) {
         return var1.k;
      } else {
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
   }

   private int bi() {
      this.hp = 0;
      this.hq = 0;
      CharPartInfo var1 = null;
      Part var2 = GameScr.ac[this.body];
      CharPartInfo var3;
      if (this.statusMe == 3) {
         if ((var1 = (CharPartInfo)CharPartInfo.d.a(String.valueOf(this.body))) != null && (var3 = (CharPartInfo)var1.g.a(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
            this.hp = var3.i;
            this.hq = var3.j;
            return var2 != null ? var2.a[this.jj].a : var1.k;
         } else {
            switch (this.body) {
               case 1:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -6;
                  }

                  return 13;
               case 3:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -6;
                  }

                  return 45;
               case 5:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -7;
                  }

                  return 73;
               case 7:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -7;
                  }

                  return 101;
               case 10:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -7;
                  }

                  return 137;
               case 18:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -7;
                  }

                  return 365;
               case 20:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -7;
                  }

                  return 391;
               case 22:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -7;
                  }

                  return 417;
               case 29:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 1;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 1;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -11;
                     this.hq = -6;
                  }

                  return 472;
               case 32:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 1;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 1;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -11;
                     this.hq = -6;
                  }

                  return 506;
               case 34:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 531;
               case 36:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 559;
               case 38:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 798;
               case 42:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 970;
               case 94:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -12;
                     this.hq = -7;
                  }

                  return 1142;
               case 141:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 3;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 3;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -7;
                  }

                  return 1348;
               case 154:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -8;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -15;
                     this.hq = -3;
                  }

                  return 1487;
               case 156:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 1;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 1;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -4;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -10;
                     this.hq = -7;
                  }

                  return 1507;
               case 157:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 1812;
               case 173:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 1838;
               case 180:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 1959;
               case 183:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 4;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -7;
                  }

                  return 1987;
               case 186:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -3;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -3;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -6;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -14;
                     this.hq = -5;
                  }

                  return 2117;
               case 189:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -3;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -3;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -6;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -14;
                     this.hq = -5;
                  }

                  return 2144;
               case 197:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -5;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -10;
                     this.hq = -6;
                  }

                  return 2342;
               case 199:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -5;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -10;
                     this.hq = -6;
                  }

                  return 2373;
               case 206:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -1;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -5;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -10;
                     this.hq = -6;
                  }

                  return 2459;
               default:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 3;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -4;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -7;
                     this.hq = -6;
                  }

                  return 13;
            }
         }
      } else if (!this.fw) {
         if ((var1 = (CharPartInfo)CharPartInfo.e.a(String.valueOf(this.body))) != null && (var3 = (CharPartInfo)var1.g.a(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
            this.hp = var3.i;
            this.hq = var3.j;
            return var2 != null ? var2.a[this.jj].a : var1.k;
         } else {
            switch (this.body) {
               case 1:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -2;
                  }

                  return 9;
               case 3:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -3;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -3;
                  }

                  return 41;
               case 5:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 70;
               case 7:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 97;
               case 10:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 133;
               case 18:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 369;
               case 20:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 395;
               case 22:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 421;
               case 29:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 468;
               case 32:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 502;
               case 34:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -2;
                  }

                  return 540;
               case 36:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -2;
                  }

                  return 555;
               case 38:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -2;
                  }

                  return 794;
               case 42:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -2;
                  }

                  return 966;
               case 94:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -2;
                  }

                  return 1139;
               case 141:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -7;
                     this.hq = -1;
                  }

                  return 1343;
               case 154:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = 1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -3;
                     this.hq = -1;
                  }

                  return 1479;
               case 156:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 3;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 3;
                     this.hq = -2;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = 2;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -3;
                     this.hq = 0;
                  }

                  return 1502;
               case 157:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 1808;
               case 173:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 1834;
               case 180:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 1955;
               case 183:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -1;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -6;
                     this.hq = -2;
                  }

                  return 1983;
               case 186:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -2;
                  }

                  return 2135;
               case 189:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 0;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -8;
                     this.hq = -2;
                  }

                  return 2135;
               case 197:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -4;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -1;
                  }

                  return 2337;
               case 199:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -4;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -1;
                  }

                  return 2363;
               case 206:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = -3;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = -4;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -9;
                     this.hq = -1;
                  }

                  return 2456;
               default:
                  if (this.arrItemMounts[4].template.id == 443) {
                     this.hp = 2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 523) {
                     this.hp = 2;
                     this.hq = -1;
                  } else if (this.arrItemMounts[4].template.id == 485) {
                     this.hp = 0;
                     this.hq = 0;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hp = -5;
                     this.hq = -2;
                  }

                  return 9;
            }
         }
      } else if ((var1 = (CharPartInfo)CharPartInfo.f.a(String.valueOf(this.body))) != null && (var3 = (CharPartInfo)var1.g.a(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
         this.hp = var3.i;
         this.hq = var3.j;
         return var2 != null ? var2.a[this.jj].a : var1.k;
      } else {
         switch (this.body) {
            case 1:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 3;
                  this.hq = -3;
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 3;
                  this.hq = -3;
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -6;
               }

               return 13;
            case 3:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -6;
               }

               return 45;
            case 5:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -9;
                  this.hq = -7;
               }

               return 73;
            case 7:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -9;
                  this.hq = -7;
               }

               return 101;
            case 10:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -9;
                  this.hq = -7;
               }

               return 137;
            case 18:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -9;
                  this.hq = -7;
               }

               return 365;
            case 20:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -9;
                  this.hq = -7;
               }

               return 391;
            case 22:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -9;
                  this.hq = -7;
               }

               return 417;
            case 29:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 1;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 1;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -11;
                  this.hq = -6;
               }

               return 472;
            case 32:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 1;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 1;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -11;
                  this.hq = -6;
               }

               return 506;
            case 34:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 531;
            case 36:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 559;
            case 38:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 798;
            case 42:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 970;
            case 94:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 0;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 0;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -12;
                  this.hq = -7;
               }

               return 1142;
            case 141:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 3;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 3;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -9;
                  this.hq = -7;
               }

               return 1348;
            case 154:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = -3;
                  this.hq = 0;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = -3;
                  this.hq = 0;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -8;
                  this.hq = 0;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -15;
                  this.hq = -3;
               }

               return 1487;
            case 156:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 1;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 1;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -4;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -10;
                  this.hq = -7;
               }

               return 1507;
            case 157:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 1812;
            case 173:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 1838;
            case 180:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 1959;
            case 183:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 4;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -8;
                  this.hq = -7;
               }

               return 1987;
            case 186:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = -3;
                  this.hq = -2;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = -3;
                  this.hq = -2;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -6;
                  this.hq = -2;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -14;
                  this.hq = -5;
               }

               return 2117;
            case 189:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = -3;
                  this.hq = -2;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = -3;
                  this.hq = -2;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -6;
                  this.hq = -2;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -14;
                  this.hq = -5;
               }

               return 2144;
            case 197:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -5;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -10;
                  this.hq = -6;
               }

               return 2342;
            case 199:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -5;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -10;
                  this.hq = -6;
               }

               return 2373;
            case 206:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = -1;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = -5;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -10;
                  this.hq = -6;
               }

               return 2459;
            default:
               if (this.arrItemMounts[4].template.id == 443) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 523) {
                  this.hp = 3;
                  this.hq = -3;
               } else if (this.arrItemMounts[4].template.id == 485) {
                  this.hp = 0;
                  this.hq = -4;
               } else if (this.arrItemMounts[4].template.id == 524) {
                  this.hp = -7;
                  this.hq = -6;
               }

               return 13;
         }
      }
   }

   private int bj() {
      this.hn = this.ho = 0;
      Part var1 = GameScr.ac[this.head];
      CharPartInfo var2 = null;
      CharPartInfo var3;
      if (this.statusMe == 3) {
         if ((var2 = (CharPartInfo)CharPartInfo.a.a(String.valueOf(this.head))) != null && (var3 = (CharPartInfo)var2.g.a(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
            this.hn = var3.i;
            this.ho = var3.j;
            return var1 != null ? var1.a[this.jj].a : var2.k;
         } else {
            switch (this.head) {
               case 2:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 33;
               case 11:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 147;
               case 23:
                  this.hn = 1;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 427;
               case 24:
                  this.hn = 1;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 430;
               case 25:
                  this.hn = 3;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 433;
               case 26:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 436;
               case 27:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 439;
               case 28:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 442;
               case 112:
                  this.hn = 1;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 148;
               case 113:
                  this.hn = -1;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 443;
               case 124:
                  this.hn = 1;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1235;
               case 125:
                  this.hn = -1;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1237;
               case 126:
                  this.hn = -1;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1255;
               case 127:
                  this.hn = -1;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1257;
               case 137:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1309;
               case 138:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1311;
               case 139:
                  this.hn = 2;
                  this.ho = -5;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1315;
               case 140:
                  this.hn = 3;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1313;
               case 146:
                  this.hn = 1;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1416;
               case 147:
                  this.hn = -2;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1418;
               case 148:
                  this.hn = 0;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1422;
               case 149:
                  this.hn = -2;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1424;
               case 150:
                  this.hn = 0;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1441;
               case 151:
                  this.hn = -2;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1439;
               case 152:
                  this.hn = 1;
                  this.ho = -4;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1447;
               case 153:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1445;
               case 158:
                  this.hn = -2;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1585;
               case 159:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1589;
               case 160:
                  this.hn = 2;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1587;
               case 161:
                  this.hn = 3;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1595;
               case 162:
                  this.hn = -5;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1597;
               case 163:
                  this.hn = -3;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1604;
               case 179:
                  this.hn = 3;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 1978;
               case 182:
                  this.hn = 3;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2006;
               case 185:
                  this.hn = -4;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2129;
               case 188:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2156;
               case 205:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2451;
               case 210:
                  this.hn = 0;
                  this.ho = -5;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2519;
               case 211:
                  this.hn = -1;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2521;
               case 212:
                  this.hn = -2;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2523;
               case 213:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2525;
               case 214:
                  this.hn = 1;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 2526;
               default:
                  this.hn = 2;
                  this.ho = -5;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        this.hn -= 2;
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 7;
                        --this.ho;
                     }
                  }

                  return 33;
            }
         }
      } else if (!this.fw) {
         if ((var2 = (CharPartInfo)CharPartInfo.b.a(String.valueOf(this.head))) != null && (var3 = (CharPartInfo)var2.g.a(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
            this.hn = var3.i;
            this.ho = var3.j;
            return var1 != null ? var1.a[this.jj].a : var2.k;
         } else {
            switch (this.head) {
               case 2:
                  this.hn = -1;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 33;
               case 11:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 147;
               case 23:
                  this.hn = -1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 427;
               case 24:
                  this.hn = -1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 430;
               case 25:
                  this.hn = 1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 433;
               case 26:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 436;
               case 27:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 439;
               case 28:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 442;
               case 112:
                  this.hn = -1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 148;
               case 113:
                  this.hn = -3;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 443;
               case 124:
                  this.hn = -1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1235;
               case 125:
                  this.hn = -1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1237;
               case 126:
                  this.hn = -1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1255;
               case 127:
                  this.hn = -3;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1257;
               case 137:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1309;
               case 138:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1311;
               case 139:
                  this.hn = 0;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1315;
               case 140:
                  this.hn = 1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1313;
               case 146:
                  this.hn = -1;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1416;
               case 147:
                  this.hn = -4;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1418;
               case 148:
                  this.hn = -2;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1422;
               case 149:
                  this.hn = -4;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1424;
               case 150:
                  this.hn = -2;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1441;
               case 151:
                  this.hn = -4;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1439;
               case 152:
                  this.hn = -1;
                  this.ho = -2;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1447;
               case 153:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1445;
               case 158:
                  this.hn = -4;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1585;
               case 159:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1589;
               case 160:
                  this.hn = 0;
                  this.ho = 0;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1587;
               case 161:
                  this.hn = 1;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1595;
               case 162:
                  this.hn = -7;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1597;
               case 163:
                  this.hn = -5;
                  this.ho = 0;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1604;
               case 179:
                  this.hn = 1;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 1978;
               case 182:
                  this.hn = 1;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2006;
               case 185:
                  this.hn = -6;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2129;
               case 188:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2156;
               case 205:
                  this.hn = -2;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2451;
               case 210:
                  this.hn = -2;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2519;
               case 211:
                  this.hn = -3;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2521;
               case 212:
                  this.hn = -4;
                  this.ho = 0;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2523;
               case 213:
                  this.hn = 0;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2525;
               case 214:
                  this.hn = -1;
                  this.ho = -1;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 2526;
               default:
                  this.hn = -1;
                  this.ho = -3;
                  if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                     if (this.arrItemMounts[4].template.id == 485) {
                        ++this.ho;
                     } else if (this.arrItemMounts[4].template.id == 524) {
                        this.hn -= 5;
                        --this.ho;
                     }
                  }

                  return 33;
            }
         }
      } else if ((var2 = (CharPartInfo)CharPartInfo.c.a(String.valueOf(this.head))) != null && (var3 = (CharPartInfo)var2.g.a(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
         this.hn = var3.i;
         this.ho = var3.j;
         return var1 != null ? var1.a[this.jj].a : var2.k;
      } else {
         switch (this.head) {
            case 2:
               this.hn = 2;
               this.ho = -5;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 33;
            case 11:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 147;
            case 23:
               this.hn = 1;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 427;
            case 24:
               this.hn = 1;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 430;
            case 25:
               this.hn = 3;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 433;
            case 26:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 436;
            case 27:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 439;
            case 28:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 442;
            case 112:
               this.hn = 1;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 148;
            case 113:
               this.hn = -1;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 443;
            case 124:
               this.hn = 1;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1235;
            case 125:
               this.hn = -1;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1237;
            case 126:
               this.hn = -1;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1255;
            case 127:
               this.hn = -1;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1257;
            case 137:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1309;
            case 138:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1311;
            case 139:
               this.hn = 2;
               this.ho = -5;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1315;
            case 140:
               this.hn = 3;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1313;
            case 146:
               this.hn = 1;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1416;
            case 147:
               this.hn = -2;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1418;
            case 148:
               this.hn = 0;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1422;
            case 149:
               this.hn = -2;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1424;
            case 150:
               this.hn = 0;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1441;
            case 151:
               this.hn = -2;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1439;
            case 152:
               this.hn = 1;
               this.ho = -4;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1447;
            case 153:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1445;
            case 158:
               this.hn = -2;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1585;
            case 159:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1589;
            case 160:
               this.hn = 2;
               this.ho = -2;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1587;
            case 161:
               this.hn = 3;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1595;
            case 162:
               this.hn = -5;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1597;
            case 163:
               this.hn = -3;
               this.ho = -2;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1604;
            case 179:
               this.hn = 3;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 1978;
            case 182:
               this.hn = 3;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2006;
            case 185:
               this.hn = -4;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2129;
            case 188:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2156;
            case 205:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2451;
            case 210:
               this.hn = 0;
               this.ho = -5;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2519;
            case 211:
               this.hn = -1;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2521;
            case 212:
               this.hn = -2;
               this.ho = -2;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2523;
            case 213:
               this.hn = 0;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2525;
            case 214:
               this.hn = 1;
               this.ho = -3;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 2526;
            default:
               this.hn = 2;
               this.ho = -5;
               if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                  if (this.arrItemMounts[4].template.id == 485) {
                     this.hn -= 2;
                     ++this.ho;
                  } else if (this.arrItemMounts[4].template.id == 524) {
                     this.hn -= 7;
                     --this.ho;
                  }
               }

               return 33;
         }
      }
   }

   private int[] bk() {
      if (this.statusMe != 6 && this.statusMe != 1 && this.statusMe != 2 && this.statusMe != 10 && this.statusMe != 11) {
         return null;
      } else {
         int[] var1 = null;
         if (this.bk) {
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
            if (this.et == -1) {
               return null;
            }

            if (this.et == 425) {
               var1 = new int[]{1687, 1688, 1689, 1690, 1691};
            } else if (this.et == 426) {
               var1 = new int[]{1682, 1683, 1684, 1685, 1686};
            } else if (this.et == 427) {
               var1 = new int[]{1677, 1678, 1679, 1680, 1681};
            }
         }

         return var1;
      }
   }

   public final void c(mGraphics var1, int var2, int var3) {
      int[] var5;
      if ((var5 = this.bk()) != null) {
         int var4;
         if ((var4 = GameCanvas.w % 13) > 9) {
            SmallImage.a(var1, var5[0], var2, var3, 0, 33);
         } else if (var4 > 6) {
            SmallImage.a(var1, var5[1], var2, var3 + 2, 0, 33);
         } else if (var4 > 3) {
            SmallImage.a(var1, var5[2], var2 - 2, var3 + 1, 0, 33);
         } else {
            SmallImage.a(var1, var5[3], var2 - 2, var3, 0, 33);
         }
      }

   }

   private void e(mGraphics var1, int var2, int var3) {
      int[] var4;
      if ((var4 = this.bk()) != null) {
         int var5 = this.cdir == 1 ? 6 : 5;
         int var7 = this.cdir == -1 ? 40 : 36;
         int var6;
         if ((var6 = GameCanvas.w % 13) > 9) {
            SmallImage.a(var1, var4[0], var2, var3, var5, var7);
         } else if (var6 > 6) {
            SmallImage.a(var1, var4[1], var2, var3, var5, var7);
         } else if (var6 > 3) {
            SmallImage.a(var1, var4[2], var2, var3, var5, var7);
         } else {
            SmallImage.a(var1, var4[3], var2, var3, var5, var7);
         }
      }

   }

   public final void d(mGraphics var1, int var2, int var3) {
      int[] var4;
      if ((var4 = this.bk()) != null) {
         SmallImage.a(var1, var4[4], var2 - 2, var3, 0, 33);
      }

   }

   private void n(int var1) {
      this.gt = 0;
      this.gu = GameScr.ad[var1];
   }

   public final void c(int var1) {
      this.eu = 0;
      this.ev = GameScr.ad[var1];
   }

   public static int d(int var0) {
      for(int var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
         if (((Char)GameScr.vCharInMap.elementAt(var1)).idChar == var0) {
            return var1;
         }
      }

      return -1;
   }

   public final void a(int var1, int var2) {
      byte var3 = 0;
      byte var4 = 0;
      var1 -= this.cx1;
      var2 -= this.cy1;
      if (var1 == 0 && var2 == 0) {
         var4 = 1;
      } else if (var2 == 0) {
         var4 = 2;
         if (this.ef.size() > 0) {
            MovePoint var5 = null;

            try {
               var5 = (MovePoint)this.ef.lastElement();
            } catch (Exception var9) {
            }

            if (var5 != null && TileMap.tileTypeAt(var5.a, var5.b, 64) && var5.b % TileMap.size > 8) {
               var4 = 10;
            }
         }

         if (var1 > 0) {
            var3 = 1;
         }

         if (var1 < 0) {
            var3 = -1;
         }
      } else if (var2 != 0) {
         if (var2 < 0) {
            var4 = 3;
         }

         if (var2 > 0) {
            var4 = 4;
         }

         if (var1 < 0) {
            var3 = -1;
         }

         if (var1 > 0) {
            var3 = 1;
         }
      }

      boolean var8 = false;
      boolean var6 = false;
      int var9 = this.cx1 + var1;
      int var10 = this.cy1 + var2;
      this.ef.addElement(new MovePoint(var9, var10, var4, var3));
      this.statusMe = 6;
   }

   private void bl() {
      if (this.charFocus != null && this.charFocus.isNhanban) {
         this.charFocus = null;
      }

      if (fg && this.charFocus != null && (this.charFocus.statusMe == 15 || this.charFocus.dh)) {
         this.charFocus = null;
      }

      if (GameCanvas.w % 2 != 0 && !this.b(this.charFocus)) {
         byte var1 = 0;
         if (this.nClass.a == 0 || this.nClass.a == 1 || this.nClass.a == 3 || this.nClass.a == 5) {
            if (GameScr.fb != 1) {
               var1 = 40;
            } else {
               var1 = 0;
            }
         }

         int[] var2 = new int[]{-1, -1, -1, -1};
         int var3 = GameScr.p - 10;
         int var4 = GameScr.p + GameCanvas.aa + 10;
         int var5 = GameScr.q;
         int var6 = GameScr.q + GameCanvas.ab - GameScr.n + 10;
         if (fg) {
            if (this.mobFocus != null && this.mobFocus.status != 1 && this.mobFocus.status != 8 && this.mobFocus.status != 0 && var3 <= this.mobFocus.x1 && this.mobFocus.x1 <= var4 && var5 <= this.mobFocus.y1 && this.mobFocus.y1 <= var6 || this.npcFocus != null && var3 <= this.npcFocus.cx1 && this.npcFocus.cx1 <= var4 && var5 <= this.npcFocus.cy1 && this.npcFocus.cy1 <= var6 || this.charFocus != null && var3 <= this.charFocus.cx1 && this.charFocus.cx1 <= var4 && var5 <= this.charFocus.cy1 && this.charFocus.cy1 <= var6 || this.itemFocus != null && var3 <= this.itemFocus.x && this.itemFocus.x <= var4 && var5 <= this.itemFocus.y && this.itemFocus.y <= var6) {
               return;
            }

            fg = false;
         }

         int var7;
         ItemMap var8;
         int var9;
         int var10;
         int var11;
         if (this.itemFocus == null) {
            for(var7 = 0; var7 < GameScr.vItemMap.size(); ++var7) {
               var8 = (ItemMap)GameScr.vItemMap.elementAt(var7);
               var9 = Math.abs(getMyChar().cx1 - var8.x);
               var10 = Math.abs(getMyChar().cy1 - var8.y);
               var11 = var9 > var10 ? var9 : var10;
               if (var9 <= 48 && var10 <= 48 && (this.itemFocus == null || var11 < var2[3])) {
                  GameScr.gI();
                  if (GameScr.fb != 0) {
                     GameScr.gI();
                     if (GameScr.i()) {
                        if (var8.template.type == 19) {
                           if (GameScr.ex) {
                              this.itemFocus = null;
                           } else {
                              this.itemFocus = var8;
                           }

                           var2[3] = var11;
                        }
                        continue;
                     }
                  }

                  if (!dm && !dn && !doa && !dp) {
                     if (GameScr.ex) {
                        this.itemFocus = null;
                     } else {
                        this.itemFocus = var8;
                     }

                     var2[3] = var11;
                  } else if (dm && var8.template.type == 19 || dn && (var8.template.type == 19 || var8.template.type == 16 || var8.template.type == 17) || doa && (var8.template.type == 19 || var8.template.type == 16 || var8.template.type == 17 || var8.template.type == 26)) {
                     if (GameScr.ex) {
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
               this.o(3);
               return;
            }

            this.itemFocus = null;

            for(var7 = 0; var7 < GameScr.vItemMap.size(); ++var7) {
               var8 = (ItemMap)GameScr.vItemMap.elementAt(var7);
               var9 = Math.abs(getMyChar().cx1 - var8.x);
               var10 = Math.abs(getMyChar().cy1 - var8.y);
               var11 = var9 > var10 ? var9 : var10;
               if (var3 <= var8.x && var8.x <= var4 && var5 <= var8.y && var8.y <= var6 && (this.itemFocus == null || var11 < var2[3])) {
                  GameScr.gI();
                  if (GameScr.fb != 0) {
                     GameScr.gI();
                     if (GameScr.i()) {
                        if (var8.template.type == 19) {
                           if (GameScr.ex) {
                              this.itemFocus = null;
                           } else {
                              this.itemFocus = var8;
                           }

                           var2[3] = var11;
                        }
                        continue;
                     }
                  }

                  if (!dm && !dn && !doa && !dp) {
                     if (GameScr.ex) {
                        this.itemFocus = null;
                     } else {
                        this.itemFocus = var8;
                     }

                     var2[3] = var11;
                  } else if (dm && var8.template.type == 19 || dn && (var8.template.type == 19 || var8.template.type == 16 || var8.template.type == 17) || doa && (var8.template.type == 19 || var8.template.type == 16 || var8.template.type == 17 || var8.template.type == 26)) {
                     if (GameScr.ex) {
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
         if (TileMap.bgID != 3 && TileMap.mapID != 111) {
            var3 = getMyChar().cx1 - getMyChar().ae() - 10;
            var4 = getMyChar().cx1 + getMyChar().ae() + 10;
            var5 = getMyChar().cy1 - getMyChar().af() - var1;
            if ((var6 = getMyChar().cy1 + getMyChar().af()) > getMyChar().cy1 + 30) {
               var6 = getMyChar().cy1 + 30;
            }

            if (this.mobFocus == null) {
               for(var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                  var12 = (Mob)GameScr.vMob.elementAt(var7);
                  var9 = Math.abs(getMyChar().cx1 - var12.x1);
                  var10 = Math.abs(getMyChar().cy1 - var12.y1);
                  var11 = var9 > var10 ? var9 : var10;
                  if ((var12.s != 97 || getMyChar().cTypePk != 4) && (var12.s != 98 || getMyChar().cTypePk != 4) && (var12.s != 167 || getMyChar().cTypePk != 4) && (var12.s != 99 || getMyChar().cTypePk != 5) && (var12.s != 96 || getMyChar().cTypePk != 5) && (var12.s != 166 || getMyChar().cTypePk != 5) && (var12.s != 200 || getMyChar().cTypePk != 4) && (var12.s != 199 || getMyChar().cTypePk != 5) && (var12.s != 198 || getMyChar().cTypePk != 6) && (var12.s != 202 || var12.status != 8 || var12.d()) && (!GameScr.ex || var12.levelBoss != 3) && var12.s != 202 && var3 <= var12.x1 && var12.x1 <= var4 && var5 <= var12.y1 && var12.y1 <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                     this.mobFocus = var12;
                     var2[0] = var11;
                  }
               }
            } else {
               if (this.mobFocus.status != 1 && this.mobFocus.status != 0 && var3 <= this.mobFocus.x1 && this.mobFocus.x1 <= var4 && var5 <= this.mobFocus.y1 && this.mobFocus.y1 <= var6) {
                  this.o(0);
                  return;
               }

               this.mobFocus = null;

               for(var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                  var12 = (Mob)GameScr.vMob.elementAt(var7);
                  var9 = Math.abs(getMyChar().cx1 - var12.x1);
                  var10 = Math.abs(getMyChar().cy1 - var12.y1);
                  var11 = var9 > var10 ? var9 : var10;
                  if ((var12.s != 97 || getMyChar().cTypePk != 4) && (var12.s != 96 || getMyChar().cTypePk != 5) && (var12.s != 98 || getMyChar().cTypePk != 4) && (var12.s != 167 || getMyChar().cTypePk != 4) && (var12.s != 99 || getMyChar().cTypePk != 5) && (var12.s != 166 || getMyChar().cTypePk != 5) && (var12.s != 96 || getMyChar().cTypePk != 6) && (var12.s != 99 || getMyChar().cTypePk != 6) && (var12.s != 166 || getMyChar().cTypePk != 6) && (var12.s != 202 || var12.status != 8 || var12.d()) && (!GameScr.ex || var12.levelBoss != 3) && var12.s != 202 && var3 <= var12.x1 && var12.x1 <= var4 && var5 <= var12.y1 && var12.y1 <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                     this.mobFocus = var12;
                     var2[0] = var11;
                  }
               }
            }

            var3 = getMyChar().cx1 - 80;
            var4 = getMyChar().cx1 + 80;
            var5 = getMyChar().cy1 - 30;
            var6 = getMyChar().cy1 + 30;
            if (this.npcFocus != null && this.npcFocus.npcTemplate.npcTemplateId == 13) {
               var3 = getMyChar().cx1 - 20;
               var4 = getMyChar().cx1 + 20;
               var5 = getMyChar().cy1 - 10;
               var6 = getMyChar().cy1 + 10;
            }

            if (this.npcFocus == null) {
               for(var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                  if ((var13 = (Npc)GameScr.vNpc.elementAt(var7)).statusMe != 15 && TileMap.bgID != 1) {
                     var9 = Math.abs(getMyChar().cx1 - var13.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var13.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     var3 = getMyChar().cx1 - 80;
                     var4 = getMyChar().cx1 + 80;
                     var5 = getMyChar().cy1 - 30;
                     var6 = getMyChar().cy1 + 30;
                     if (var13.npcTemplate.npcTemplateId == 13) {
                        var3 = getMyChar().cx1 - 20;
                        var4 = getMyChar().cx1 + 20;
                        var5 = getMyChar().cy1 - 10;
                        var6 = getMyChar().cy1 + 10;
                     }

                     if (var3 <= var13.cx1 && var13.cx1 <= var4 && var5 <= var13.cy1 && var13.cy1 <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                        if (GameScr.ex && GameScr.fb == 1) {
                           break;
                        }

                        this.npcFocus = var13;
                        var2[1] = var11;
                     }
                  }
               }
            } else {
               if (var3 <= this.npcFocus.cx1 && this.npcFocus.cx1 <= var4 && var5 <= this.npcFocus.cy1 && this.npcFocus.cy1 <= var6) {
                  this.o(1);
                  return;
               }

               this.v();

               for(var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                  if ((var13 = (Npc)GameScr.vNpc.elementAt(var7)).statusMe != 15 && TileMap.bgID != 1) {
                     var9 = Math.abs(getMyChar().cx1 - var13.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var13.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     var3 = getMyChar().cx1 - 80;
                     var4 = getMyChar().cx1 + 80;
                     var5 = getMyChar().cy1 - 30;
                     var6 = getMyChar().cy1 + 30;
                     if (var13.npcTemplate.npcTemplateId == 13) {
                        var3 = getMyChar().cx1 - 20;
                        var4 = getMyChar().cx1 + 20;
                        var5 = getMyChar().cy1 - 10;
                        var6 = getMyChar().cy1 + 10;
                     }

                     if (var3 <= var13.cx1 && var13.cx1 <= var4 && var5 <= var13.cy1 && var13.cy1 <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                        if (GameScr.ex && GameScr.fb == 1) {
                           break;
                        }

                        this.npcFocus = var13;
                        var2[1] = var11;
                     }
                  }
               }
            }

            if (this.charFocus == null) {
               for(var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                  if (!(var14 = (Char)GameScr.vCharInMap.elementAt(var7)).isNhanban && var14.statusMe != 15 && !var14.dh && var14.idChar < -1 && this.fh == 0 && this.fi == 0 && var14.statusMe != 14 && var14.statusMe != 5) {
                     var9 = Math.abs(getMyChar().cx1 - var14.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var14.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     if (var3 <= var14.cx1 && var14.cx1 <= var4 && var5 <= var14.cy1 && var14.cy1 <= var6 && (this.charFocus == null || var11 < var2[2])) {
                        this.charFocus = var14;
                        var2[2] = var11;
                     }
                  }
               }
            } else {
               if (var3 <= this.charFocus.cx1 && this.charFocus.cx1 <= var4 && var5 <= this.charFocus.cy1 && this.charFocus.cy1 <= var6 && this.charFocus.statusMe != 15 && !this.charFocus.dh) {
                  this.o(2);
                  return;
               }

               this.charFocus = null;

               for(var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                  if (!(var14 = (Char)GameScr.vCharInMap.elementAt(var7)).isNhanban && var14.statusMe != 15 && !var14.dh && var14.idChar < 0 && this.fh == 0 && this.fi == 0 && var14.statusMe != 14 && var14.statusMe != 5) {
                     var9 = Math.abs(getMyChar().cx1 - var14.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var14.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     if (var3 <= var14.cx1 && var14.cx1 <= var4 && var5 <= var14.cy1 && var14.cy1 <= var6 && (this.charFocus == null || var11 < var2[2])) {
                        this.charFocus = var14;
                        var2[2] = var11;
                     }
                  }
               }
            }

            var7 = -1;

            for(var15 = 0; var15 < var2.length; ++var15) {
               if (var7 == -1) {
                  if (var2[var15] != -1) {
                     var7 = var15;
                  }
               } else if (var2[var15] < var2[var7] && var2[var15] != -1) {
                  var7 = var15;
               }
            }

            if (GameScr.ex && GameScr.fb == 1 && !GameScr.gI().fc) {
               GameScr.am();
            }
         } else {
            var3 = getMyChar().cx1 - getMyChar().ae();
            var4 = getMyChar().cx1 + getMyChar().ae();
            var5 = getMyChar().cy1 - getMyChar().af() - var1;
            if ((var6 = getMyChar().cy1 + getMyChar().af()) > getMyChar().cy1 + 30) {
               var6 = getMyChar().cy1 + 30;
            }

            if (this.mobFocus == null) {
               for(var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                  var12 = (Mob)GameScr.vMob.elementAt(var7);
                  var9 = Math.abs(getMyChar().cx1 - var12.x1);
                  var10 = Math.abs(getMyChar().cy1 - var12.y1);
                  var11 = var9 > var10 ? var9 : var10;
                  if ((var12.s != 97 || getMyChar().cTypePk != 4) && (var12.s != 96 || getMyChar().cTypePk != 5) && (var12.s != 98 || getMyChar().cTypePk != 4) && (var12.s != 167 || getMyChar().cTypePk != 4) && (var12.s != 99 || getMyChar().cTypePk != 5) && (var12.s != 166 || getMyChar().cTypePk != 5) && (var12.s != 200 || getMyChar().cTypePk != 4) && (var12.s != 199 || getMyChar().cTypePk != 5) && (var12.s != 198 || getMyChar().cTypePk != 6) && (var12.s != 202 || var12.status != 8 || var12.d()) && (!GameScr.ex || var12.levelBoss != 3) && var3 <= var12.x1 && var12.x1 <= var4 && var5 <= var12.y1 && var12.y1 <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                     this.mobFocus = var12;
                     var2[0] = var11;
                  }
               }
            } else {
               if (this.mobFocus.status != 1 && this.mobFocus.status != 0 && var3 <= this.mobFocus.x1 && this.mobFocus.x1 <= var4 && var5 <= this.mobFocus.y1 && this.mobFocus.y1 <= var6) {
                  this.o(0);
                  return;
               }

               this.mobFocus = null;

               for(var7 = 0; var7 < GameScr.vMob.size(); ++var7) {
                  var12 = (Mob)GameScr.vMob.elementAt(var7);
                  var9 = Math.abs(getMyChar().cx1 - var12.x1);
                  var10 = Math.abs(getMyChar().cy1 - var12.y1);
                  var11 = var9 > var10 ? var9 : var10;
                  if ((var12.s != 97 || getMyChar().cTypePk != 4) && (var12.s != 96 || getMyChar().cTypePk != 5) && (var12.s != 98 || getMyChar().cTypePk != 4) && (var12.s != 167 || getMyChar().cTypePk != 4) && (var12.s != 99 || getMyChar().cTypePk != 5) && (var12.s != 166 || getMyChar().cTypePk != 5) && (var12.s != 200 || getMyChar().cTypePk != 4) && (var12.s != 199 || getMyChar().cTypePk != 5) && (var12.s != 198 || getMyChar().cTypePk != 6) && (var12.s != 202 || var12.status != 8 || var12.d()) && (!GameScr.ex || var12.levelBoss != 3) && var3 <= var12.x1 && var12.x1 <= var4 && var5 <= var12.y1 && var12.y1 <= var6 && var12.status != 0 && var12.status != 1 && (this.mobFocus == null || var11 < var2[0])) {
                     this.mobFocus = var12;
                     var2[0] = var11;
                  }
               }
            }

            var3 = getMyChar().cx1 - 80;
            var4 = getMyChar().cx1 + 80;
            var5 = getMyChar().cy1 - 30;
            var6 = getMyChar().cy1 + 30;
            if (this.npcFocus != null && this.npcFocus.npcTemplate.npcTemplateId == 13) {
               var3 = getMyChar().cx1 - 20;
               var4 = getMyChar().cx1 + 20;
               var5 = getMyChar().cy1 - 10;
               var6 = getMyChar().cy1 + 10;
            }

            if (this.npcFocus == null) {
               for(var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                  if ((var13 = (Npc)GameScr.vNpc.elementAt(var7)).statusMe != 15) {
                     var9 = Math.abs(getMyChar().cx1 - var13.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var13.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     var3 = getMyChar().cx1 - 80;
                     var4 = getMyChar().cx1 + 80;
                     var5 = getMyChar().cy1 - 30;
                     var6 = getMyChar().cy1 + 30;
                     if (var13.npcTemplate.npcTemplateId == 13) {
                        var3 = getMyChar().cx1 - 20;
                        var4 = getMyChar().cx1 + 20;
                        var5 = getMyChar().cy1 - 10;
                        var6 = getMyChar().cy1 + 10;
                     }

                     if (var3 <= var13.cx1 && var13.cx1 <= var4 && var5 <= var13.cy1 && var13.cy1 <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                        if (GameScr.ex && GameScr.fb == 1) {
                           break;
                        }

                        this.npcFocus = var13;
                        var2[1] = var11;
                     }
                  }
               }
            } else {
               if (var3 <= this.npcFocus.cx1 && this.npcFocus.cx1 <= var4 && var5 <= this.npcFocus.cy1 && this.npcFocus.cy1 <= var6) {
                  this.o(1);
                  return;
               }

               this.v();

               for(var7 = 0; var7 < GameScr.vNpc.size(); ++var7) {
                  if ((var13 = (Npc)GameScr.vNpc.elementAt(var7)).statusMe != 15) {
                     var9 = Math.abs(getMyChar().cx1 - var13.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var13.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     var3 = getMyChar().cx1 - 80;
                     var4 = getMyChar().cx1 + 80;
                     var5 = getMyChar().cy1 - 30;
                     var6 = getMyChar().cy1 + 30;
                     if (var13.npcTemplate.npcTemplateId == 13) {
                        var3 = getMyChar().cx1 - 20;
                        var4 = getMyChar().cx1 + 20;
                        var5 = getMyChar().cy1 - 10;
                        var6 = getMyChar().cy1 + 10;
                     }

                     if (var3 <= var13.cx1 && var13.cx1 <= var4 && var5 <= var13.cy1 && var13.cy1 <= var6 && (this.npcFocus == null || var11 < var2[1])) {
                        if (GameScr.ex && GameScr.fb == 1) {
                           break;
                        }

                        this.npcFocus = var13;
                        var2[1] = var11;
                     }
                  }
               }
            }

            var3 = getMyChar().cx1 - 40;
            var4 = getMyChar().cx1 + 40;
            var5 = getMyChar().cy1 - 30;
            var6 = getMyChar().cy1 + 30;
            if (this.charFocus == null) {
               for(var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                  if (!(var14 = (Char)GameScr.vCharInMap.elementAt(var7)).isNhanban) {
                     if (TileMap.mapID != 111) {
                        if (var14.statusMe == 15 || var14.dh || var14.cTypePk == myChar.cTypePk || this.fh != 0 || this.fi != 0 || var14.statusMe == 14 || var14.statusMe == 5) {
                           continue;
                        }
                     } else {
                        if (var14.statusMe == 15 || var14.dh || this.fh != 0 || this.fi != 0) {
                           continue;
                        }

                        if (myChar.nClass.a == 6) {
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

                     var9 = Math.abs(getMyChar().cx1 - var14.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var14.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     if (var3 <= var14.cx1 && var14.cx1 <= var4 && var5 <= var14.cy1 && var14.cy1 <= var6 && (this.charFocus == null || var11 < var2[2])) {
                        this.charFocus = var14;
                        var2[2] = var11;
                     }
                  }
               }
            } else {
               if (var3 <= this.charFocus.cx1 && this.charFocus.cx1 <= var4 && var5 <= this.charFocus.cy1 && this.charFocus.cy1 <= var6 && this.charFocus.statusMe != 15 && !this.charFocus.dh && this.charFocus.statusMe != 14 && this.charFocus.statusMe != 5) {
                  this.o(2);
                  return;
               }

               this.charFocus = null;

               for(var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
                  if (!(var14 = (Char)GameScr.vCharInMap.elementAt(var7)).isNhanban) {
                     if (TileMap.mapID != 111) {
                        if (var14.statusMe == 15 || var14.dh || var14.cTypePk == myChar.cTypePk || this.fh != 0 || this.fi != 0 || var14.statusMe == 14 || var14.statusMe == 5) {
                           continue;
                        }
                     } else {
                        if (var14.statusMe == 15 || var14.dh || this.fh != 0 || this.fi != 0) {
                           continue;
                        }

                        if (myChar.nClass.a == 6) {
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

                     var9 = Math.abs(getMyChar().cx1 - var14.cx1);
                     var10 = Math.abs(getMyChar().cy1 - var14.cy1);
                     var11 = var9 > var10 ? var9 : var10;
                     if (var3 <= var14.cx1 && var14.cx1 <= var4 && var5 <= var14.cy1 && var14.cy1 <= var6 && (this.charFocus == null || var11 < var2[2])) {
                        this.charFocus = var14;
                        var2[2] = var11;
                     }
                  }
               }
            }

            var7 = -1;

            for(var15 = 0; var15 < var2.length; ++var15) {
               if (var7 == -1) {
                  if (var2[var15] != -1) {
                     var7 = var15;
                  }
               } else if (var2[var15] < var2[var7] && var2[var15] != -1) {
                  var7 = var15;
               }
            }
         }

         this.o(var7);
      }

   }

   private void o(int var1) {
      if (var1 == 0) {
         this.v();
         this.charFocus = null;
         this.itemFocus = null;
      } else if (var1 == 1) {
         this.mobFocus = null;
         this.charFocus = null;
         this.itemFocus = null;
      } else if (var1 == 2) {
         this.mobFocus = null;
         this.v();
         this.itemFocus = null;
      } else if (var1 == 3) {
         this.mobFocus = null;
         this.v();
         this.charFocus = null;
      }

   }

   public static boolean a(Char var0) {
      int var1 = GameScr.p;
      int var2 = GameScr.p + GameCanvas.aa;
      int var3 = GameScr.q + 10;
      int var4 = GameScr.q + GameScr.j;
      return var0.statusMe != 15 && !var0.dh && var1 <= var0.cx1 && var0.cx1 <= var2 && var3 <= var0.cy1 && var0.cy1 <= var4;
   }

   public final void u() {
      if (this.charFocus != null && this.charFocus.isNhanban) {
         this.charFocus = null;
      }

      if (getMyChar().ex == null && getMyChar().ew == null) {
         this.focus.removeAllElements();
         int var1 = 0;
         int var2 = GameScr.p + 10;
         int var3 = GameScr.p + GameCanvas.aa - 10;
         int var4 = GameScr.q + 10;
         int var5 = GameScr.q + GameScr.j;
         int var6;
         Char var7;
         ItemMap var9;
         Mob var10;
         Npc var11;
         if (TileMap.bgID != 3 && TileMap.mapID != 111) {
            for(var6 = 0; var6 < GameScr.vItemMap.size(); ++var6) {
               var9 = (ItemMap)GameScr.vItemMap.elementAt(var6);
               if (var2 <= var9.x && var9.x <= var3 && var4 <= var9.y && var9.y <= var5) {
                  this.focus.addElement(var9);
                  if (this.itemFocus != null && var9.equals(this.itemFocus)) {
                     var1 = this.focus.size();
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.vMob.size(); ++var6) {
               if (((var10 = (Mob)GameScr.vMob.elementAt(var6)).s != 97 || getMyChar().cTypePk != 4) && (var10.s != 96 || getMyChar().cTypePk != 5) && (var10.s != 98 || getMyChar().cTypePk != 4) && (var10.s != 167 || getMyChar().cTypePk != 4) && (var10.s != 99 || getMyChar().cTypePk != 5) && (var10.s != 166 || getMyChar().cTypePk != 5) && (var10.s != 200 || getMyChar().cTypePk != 4) && (var10.s != 199 || getMyChar().cTypePk != 5) && (var10.s != 198 || getMyChar().cTypePk != 6) && (var10.s != 202 || var10.status != 8 || var10.d()) && var10.status != 1 && var10.status != 0 && var2 <= var10.x1 && var10.x1 <= var3 && var4 <= var10.y1 && var10.y1 <= var5) {
                  this.focus.addElement(var10);
                  if (this.mobFocus != null && var10.equals(this.mobFocus)) {
                     var1 = this.focus.size();
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.vNpc.size(); ++var6) {
               if ((var11 = (Npc)GameScr.vNpc.elementAt(var6)).statusMe != 15 && var2 <= var11.cx1 && var11.cx1 <= var3 && var4 <= var11.cy1 && var11.cy1 <= var5) {
                  this.focus.addElement(var11);
                  if (this.npcFocus != null && var11.equals(this.npcFocus)) {
                     var1 = this.focus.size();
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.vCharInMap.size(); ++var6) {
               if (!(var7 = (Char)GameScr.vCharInMap.elementAt(var6)).isNhanban && var7.statusMe != 15 && !var7.dh && var2 <= var7.cx1 && var7.cx1 <= var3 && var4 <= var7.cy1 && var7.cy1 <= var5) {
                  this.focus.addElement(var7);
                  if (this.charFocus != null && var7.equals(this.charFocus)) {
                     var1 = this.focus.size();
                  }
               }
            }

            if (this.focus.size() > 0) {
               if (var1 >= this.focus.size()) {
                  var1 = 0;
               }

               if (this.focus.elementAt(var1) instanceof Mob) {
                  this.mobFocus = (Mob)this.focus.elementAt(var1);
                  this.v();
                  this.charFocus = null;
                  this.itemFocus = null;
                  fg = true;
                  return;
               }

               if (this.focus.elementAt(var1) instanceof Npc) {
                  this.mobFocus = null;
                  this.v();
                  this.npcFocus = (Npc)this.focus.elementAt(var1);
                  this.charFocus = null;
                  this.itemFocus = null;
                  fg = true;
                  return;
               }

               if (this.focus.elementAt(var1) instanceof Char) {
                  this.mobFocus = null;
                  this.v();
                  this.charFocus = (Char)this.focus.elementAt(var1);
                  this.itemFocus = null;
                  fg = true;
                  return;
               }

               if (this.focus.elementAt(var1) instanceof ItemMap) {
                  this.mobFocus = null;
                  this.v();
                  this.charFocus = null;
                  this.itemFocus = (ItemMap)this.focus.elementAt(var1);
                  fg = true;
                  return;
               }
            } else {
               this.mobFocus = null;
               this.v();
               this.charFocus = null;
               this.itemFocus = null;
               fg = false;
            }
         } else {
            if (TileMap.mapID != 98 && TileMap.mapID != 104) {
               for(var6 = 0; var6 < GameScr.vCharInMap.size(); ++var6) {
                  if (!(var7 = (Char)GameScr.vCharInMap.elementAt(var6)).isNhanban && var7.statusMe != 15 && !var7.dh && var2 <= var7.cx1 && var7.cx1 <= var3 && var4 <= var7.cy1 && var7.cy1 <= var5) {
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
                     } else if (myChar.nClass.a == 6) {
                        if (myChar.cTypePk == var7.cTypePk) {
                           if (var7.statusMe == 14 || var7.statusMe == 5) {
                              this.focus.addElement(var7);
                              if (this.charFocus != null && var7.equals(this.charFocus)) {
                                 var1 = this.focus.size();
                              }
                           }
                        } else if ((myChar.cTypePk != 4 || var7.cTypePk == 5 || var7.cTypePk == 6 || var7.cTypePk == 7) && (myChar.cTypePk != 5 || var7.cTypePk == 4 || var7.cTypePk == 6 || var7.cTypePk == 7) && (myChar.cTypePk != 6 || var7.cTypePk == 4 || var7.cTypePk == 5 || var7.cTypePk == 7) && (myChar.cTypePk != 7 || var7.cTypePk == 4 || var7.cTypePk == 5 || var7.cTypePk == 6) && var7.statusMe != 14 && var7.statusMe != 5) {
                           this.focus.addElement(var7);
                           if (this.charFocus != null && var7.equals(this.charFocus)) {
                              var1 = this.focus.size();
                           }
                        }
                     } else if ((myChar.cTypePk != 4 || var7.cTypePk == 5 || var7.cTypePk == 6 || var7.cTypePk == 7) && (myChar.cTypePk != 5 || var7.cTypePk == 4 || var7.cTypePk == 6 || var7.cTypePk == 7) && (myChar.cTypePk != 6 || var7.cTypePk == 4 || var7.cTypePk == 5 || var7.cTypePk == 7) && (myChar.cTypePk != 7 || var7.cTypePk == 4 || var7.cTypePk == 5 || var7.cTypePk == 6) && var7.statusMe != 14 && var7.statusMe != 5) {
                        this.focus.addElement(var7);
                        if (this.charFocus != null && var7.equals(this.charFocus)) {
                           var1 = this.focus.size();
                        }
                     }
                  }
               }
            } else {
               for(var6 = 0; var6 < GameScr.vCharInMap.size(); ++var6) {
                  if (!(var7 = (Char)GameScr.vCharInMap.elementAt(var6)).isNhanban && var7.statusMe != 15 && !var7.dh && var2 <= var7.cx1 && var7.cx1 <= var3 && var4 <= var7.cy1 && var7.cy1 <= var5) {
                     this.focus.addElement(var7);
                     if (this.charFocus != null && var7.equals(this.charFocus)) {
                        var1 = this.focus.size();
                     }
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.vItemMap.size(); ++var6) {
               var9 = (ItemMap)GameScr.vItemMap.elementAt(var6);
               if (var2 <= var9.x && var9.x <= var3 && var4 <= var9.y && var9.y <= var5) {
                  this.focus.addElement(var9);
                  if (this.itemFocus != null && var9.equals(this.itemFocus)) {
                     var1 = this.focus.size();
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.vMob.size(); ++var6) {
               if (((var10 = (Mob)GameScr.vMob.elementAt(var6)).s != 97 || getMyChar().cTypePk != 4) && (var10.s != 98 || getMyChar().cTypePk != 4) && (var10.s != 167 || getMyChar().cTypePk != 4) && (var10.s != 96 || getMyChar().cTypePk != 5) && (var10.s != 99 || getMyChar().cTypePk != 5) && (var10.s != 166 || getMyChar().cTypePk != 5) && (var10.s != 200 || getMyChar().cTypePk != 4) && (var10.s != 199 || getMyChar().cTypePk != 5) && (var10.s != 198 || getMyChar().cTypePk != 6) && (var10.s != 202 || var10.status != 8 || var10.d()) && var10.status != 1 && var10.status != 0 && var2 <= var10.x1 && var10.x1 <= var3 && var4 <= var10.y1 && var10.y1 <= var5) {
                  this.focus.addElement(var10);
                  if (this.mobFocus != null && var10.equals(this.mobFocus)) {
                     var1 = this.focus.size();
                  }
               }
            }

            for(var6 = 0; var6 < GameScr.vNpc.size(); ++var6) {
               if ((var11 = (Npc)GameScr.vNpc.elementAt(var6)).statusMe != 15 && var2 <= var11.cx1 && var11.cx1 <= var3 && var4 <= var11.cy1 && var11.cy1 <= var5) {
                  this.focus.addElement(var11);
                  if (this.npcFocus != null && var11.equals(this.npcFocus)) {
                     var1 = this.focus.size();
                  }
               }
            }

            if (this.focus.size() <= 0) {
               this.mobFocus = null;
               this.v();
               this.charFocus = null;
               this.itemFocus = null;
               fg = false;
               return;
            }

            if (var1 >= this.focus.size()) {
               var1 = 0;
            }

            if (this.focus.elementAt(var1) instanceof Char) {
               this.mobFocus = null;
               this.v();
               this.charFocus = (Char)this.focus.elementAt(var1);
               this.itemFocus = null;
               fg = true;
               return;
            }

            if (this.focus.elementAt(var1) instanceof Npc) {
               this.mobFocus = null;
               this.v();
               this.npcFocus = (Npc)this.focus.elementAt(var1);
               this.charFocus = null;
               this.itemFocus = null;
               fg = true;
               return;
            }

            if (this.focus.elementAt(var1) instanceof Mob) {
               this.mobFocus = (Mob)this.focus.elementAt(var1);
               this.v();
               this.charFocus = null;
               this.itemFocus = null;
               fg = true;
               return;
            }

            if (this.focus.elementAt(var1) instanceof ItemMap) {
               this.mobFocus = null;
               this.v();
               this.charFocus = null;
               this.itemFocus = (ItemMap)this.focus.elementAt(var1);
               fg = true;
               return;
            }
         }
      }

   }

   public final void v() {
      if (this.bk && this.npcFocus != null) {
         ;
         this.npcFocus.f = null;
         this.npcFocus = null;
      }

   }

   private void bm() {
      if (!GameCanvas.a) {
         if (TileMap.tileTypeAt(this.cx1, this.cy1 + 1, 1024)) {
            TileMap.setTileTypeAtPixel(this.cx1, this.cy1 + 1, 512);
            TileMap.setTileTypeAtPixel(this.cx1, this.cy1 - 2, 512);
         }

         if (TileMap.tileTypeAt(this.cx1 - TileMap.size, this.cy1 + 1, 512)) {
            TileMap.c(this.cx1 - TileMap.size, this.cy1 + 1, 512);
            TileMap.c(this.cx1 - TileMap.size, this.cy1 - 2, 512);
         }

         if (TileMap.tileTypeAt(this.cx1 + TileMap.size, this.cy1 + 1, 512)) {
            TileMap.c(this.cx1 + TileMap.size, this.cy1 + 1, 512);
            TileMap.c(this.cx1 + TileMap.size, this.cy1 - 2, 512);
         }
      }

   }

   public final void b(Message var1) {
      try {
         this.a(var1);
         getMyChar().eff5BuffHp = var1.b().readShort();
         getMyChar().eff5BuffMp = var1.b().readShort();
         int var2 = var1.b().readUnsignedByte();
         Item var3;
         (var3 = this.arrItemMounts[var2]).typeUI = 3;
         this.arrItemMounts[var2] = null;
         var3.indexUI = var1.b().readUnsignedByte();
         this.arrItemBag[var3.indexUI] = var3;
         if (var2 == 4) {
            this.bq = this.bo = this.bn = this.bp = false;
         }

         GameScr.cq = false;
         GameScr.gI().aj();
      } catch (Exception var4) {
         ;
      }

   }

   public final void c(Message var1) {
      try {
         this.a(var1);
         getMyChar().eff5BuffHp = var1.b().readShort();
         getMyChar().eff5BuffMp = var1.b().readShort();
         Item var2;
         (var2 = this.arrItemBody[var1.b().readUnsignedByte()]).typeUI = 3;
         if (var2.indexUI == 1) {
            this.weapon = 15;
         } else if (var2.indexUI == 2) {
            this.l();
         } else if (var2.indexUI == 6) {
            this.m();
         }

         this.arrItemBody[var2.indexUI] = null;
         var2.indexUI = var1.b().readUnsignedByte();
         getMyChar().head = var1.b().readShort();
         this.arrItemBag[var2.indexUI] = var2;
         // Auto đập đồ hook — bắt sự kiện server unequip thành công (port TGAME)
         if (Code.isADapDo && Code.dapDoWaitingUnequip) {
            Code.advCH = var2.indexUI;
            Code.dapDoWaitingUnequip = false;
            LockGame.advAR();
         }
         GameScr.gI().a = GameScr.gI().b = null;
         GameScr.gI().aj();
      } catch (Exception var3) {
         ;
         ;
      }

   }

   public final void d(Message var1) {
      try {
         int var2 = var1.b().readUnsignedByte();
         int var5 = var1.b().readUnsignedByte();
         Item var3;
         if ((var3 = this.arrItemBag[var2]) != null) {
            if (var3.template.type == 16) {
               GameScr.mpPotion -= var3.quantity;
            }

            if (var3.template.type == 17) {
               GameScr.hpPotion -= var3.quantity;
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

         GameScr.gI().a = GameScr.gI().b = null;
         GameScr.gI().ab();
      } catch (Exception var6) {
         ;
         ;
      }

   }

   public final void e(Message var1) {
      try {
         int var2 = var1.b().readUnsignedByte();
         int var5 = var1.b().readUnsignedByte();
         Item var3;
         if ((var3 = this.arrItemBox[var2]) != null) {
            if (var3.template.type == 16) {
               GameScr.mpPotion += var3.quantity;
            }

            if (var3.template.type == 17) {
               GameScr.hpPotion += var3.quantity;
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

         GameScr.gI().a = GameScr.gI().b = null;
         GameScr.gI().ab();
      } catch (Exception var6) {
         ;
         ;
      }

   }

   public static void a(Message var0, boolean var1) {
      try {
         for(int var2 = 0; var2 < GameScr.bz.length; ++var2) {
            GameScr.bz[var2] = null;
         }

         byte var6 = var0.b().readByte();
         Item var3;
         (var3 = new Item()).typeUI = 3;
         var3.indexUI = var0.b().readByte();
         var3.template = ItemTemplates.a(var0.b().readShort());
         var3.isLock = var0.b().readBoolean();
         var3.isExpires = var0.b().readBoolean();
         var3.quantity = 1;
         if (var1) {
            getMyChar().xu = var0.b().readInt();
         } else {
            getMyChar().yen = var0.b().readInt();

            try {
               getMyChar().xu = var0.b().readInt();
            } catch (Exception var5) {
            }
         }

         GameScr.bz[0] = var3;
         GameScr.fi = GameScr.ad[53];
         GameScr.fh = 0;
         GameScr.gI().a = GameScr.gI().b = null;
         GameScr.gI().ac();
         GameCanvas.j();
         if (var6 == 1) {
            ChatManager.showNotify(TextGame.ep + " " + var3.template.name);
         } else {
            ChatManager.showNotify(TextGame.eo + " " + ItemTemplates.a((short)(var3.template.id + 1)).name + " " + TextGame.er + " " + var3.template.name, 25, mFont.l);
         }
      } catch (Exception var6) {
         ;
         ;
      }

   }

   private static void a(Item var0, int var1) {
      int var2 = 0;
      if (var0 != null && var0.options != null) {
         for(int var3 = 0; var3 < var0.options.size(); ++var3) {
            ItemOption var4;
            (var4 = (ItemOption)var0.options.elementAt(var3)).b = 0;
            if (var4.c.c == 2) {
               if (var2 < var1) {
                  var4.b = 1;
                  ++var2;
               }
            } else if (var4.c.c == 3 && var0.upgrade >= 4) {
               var4.b = 1;
            } else if (var4.c.c == 4 && var0.upgrade >= 8) {
               var4.b = 1;
            } else if (var4.c.c == 5 && var0.upgrade >= 12) {
               var4.b = 1;
            } else if (var4.c.c == 6 && var0.upgrade >= 14) {
               var4.b = 1;
            } else if (var4.c.c == 7 && var0.upgrade >= 16) {
               var4.b = 1;
            }
         }
      }

   }

   public final void w() {
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

      a(this.arrItemBody[0], var1);
      a(this.arrItemBody[6], var1);
      a(this.arrItemBody[5], var1);
      if (this.arrItemBody[2] == null) {
         --var2;
      }

      if (this.arrItemBody[8] == null) {
         --var2;
      }

      if (this.arrItemBody[7] == null) {
         --var2;
      }

      a(this.arrItemBody[2], var2);
      a(this.arrItemBody[8], var2);
      a(this.arrItemBody[7], var2);
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
         if (this.arrItemBody[1].sys == this.a()) {
            if (this.arrItemBody[1].options != null) {
               for(var1 = 0; var1 < this.arrItemBody[1].options.size(); ++var1) {
                  if ((var4 = (ItemOption)this.arrItemBody[1].options.elementAt(var1)).c.c == 2) {
                     var4.b = 1;
                  }
               }
            }
         } else if (this.arrItemBody[1].options != null) {
            for(var1 = 0; var1 < this.arrItemBody[1].options.size(); ++var1) {
               if ((var4 = (ItemOption)this.arrItemBody[1].options.elementAt(var1)).c.c == 2) {
                  var4.b = 0;
               }
            }
         }
      }

      a(this.arrItemBody[4], var3);
      a(this.arrItemBody[3], var3);
      a(this.arrItemBody[9], var3);
   }

   public final void a(int var1, int var2, boolean var3, int var4) {
      this.cHP -= var1;
      this.cMP -= var2;
      if (!this.bk) {
         this.cHP = this.cHpNew;
      }

      if (this.cHP < 0) {
         this.cHP = 0;
      }

      if (this.cMP < 0) {
         this.cMP = 0;
      }

      if (this.cHP < 1 && this.statusMe != 14 && this.statusMe != 5) {
         this.cHP = 1;
      }

      if (var1 <= 0) {
         if (this.bk) {
            GameScr.a("", this.cx1, this.cy1 - this.bg, 0, -2, 7);
         } else {
            GameScr.a("", this.cx1, this.cy1 - this.bg, 0, -2, 4);
         }
      } else {
         GameScr.a("-" + var1, this.cx1, this.cy1 - this.bg, 0, -2, 0);
      }

      if (var1 > 0) {
         this.hk = 4;
      }

      if (var3) {
         if (var4 == 114) {
            ServerEffect.a(32, this.cx1, this.cy1 - this.bi, 1);
            return;
         }

         if (var4 == 115) {
            ServerEffect.a(85, this.cx1, this.cy1, 1);
            return;
         }

         if (var4 == 139) {
            GameScr.ez = 1;
            GameScr.fa = 0;
            ServerEffect.a(91, this, 2);
            return;
         }

         if (var4 == 144) {
            ServerEffect.a(91, this, 1);
            return;
         }
      }

   }

   private void b(short var1, short var2) {
      if (this.bk) {
         eh = true;

         for(int var3 = 0; var3 < GameScr.vCharInMap.size(); ++var3) {
            ((Char)GameScr.vCharInMap.elementAt(var3)).dc = -9999;
         }
      }

      this.statusMe = 5;
      this.fq = var1;
      this.fr = var2;
      this.m = 0;
      this.cHP = 0;
      this.db = -9999;
      this.dc = -9999;
   }

   public final void a(short var1, short var2) {
      this.fh = var1;
      this.fi = var2;
   }

   private void bn() {
      this.fn = 0;
      this.statusMe = 1;
      this.dz = System.currentTimeMillis();
   }

   public final void x() {
      this.cHP = this.cMaxHP;
      this.cMP = this.cMaxMP;
      this.bn();
      this.m = this.fq = this.fr = 0;
      ServerEffect.a(20, this, 2);
      GameScr.gI().b = null;
   }

   public final boolean e(int var1) {
      if (this.arrItemBag == null) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.arrItemBag.length; ++var2) {
            if (this.arrItemBag[var2] != null && this.arrItemBag[var2].template.type == var1 && this.arrItemBag[var2].template.level <= myChar.cLevel) {
               Service.gI().useItem(var2);
               return true;
            }
         }

         return false;
      }
   }

   private static boolean bo() {
      return TileMap.mapID == 1 || TileMap.mapID == 27 || TileMap.mapID == 72 || TileMap.mapID == 10 || TileMap.mapID == 17 || TileMap.mapID == 22 || TileMap.mapID == 32 || TileMap.mapID == 38 || TileMap.mapID == 43 || TileMap.mapID == 48;
   }

   public final boolean b(Char var1) {
      if (var1 != null && var1.isNhanban) {
         return false;
      } else if (var1 == null || getMyChar().myskill == null || getMyChar().myskill.template.type == 2 || getMyChar().myskill.template.type == 3 || getMyChar().myskill.template.type == 4 && var1.statusMe != 14 && var1.statusMe != 5) {
         return false;
      } else {
         label159: {
            if (getMyChar().cTypePk == 7 && (var1.cTypePk == 6 || var1.cTypePk == 4 || var1.cTypePk == 5) || getMyChar().cTypePk == 6 && (var1.cTypePk == 7 || var1.cTypePk == 4 || var1.cTypePk == 5) || getMyChar().cTypePk == 4 && (var1.cTypePk == 7 || var1.cTypePk == 5 || var1.cTypePk == 6) || getMyChar().cTypePk == 5 && (var1.cTypePk == 7 || var1.cTypePk == 4 || var1.cTypePk == 6)) {
               getMyChar();
               if (!c(var1) && !bo()) {
                  break label159;
               }
            }

            if (var1.cTypePk == 3) {
               getMyChar();
               if (!c(var1) && !bo()) {
                  break label159;
               }
            }

            if (getMyChar().cTypePk == 3) {
               getMyChar();
               if (!c(var1) && !bo()) {
                  break label159;
               }
            }

            if (getMyChar().cTypePk == 1 && var1.cTypePk == 1) {
               getMyChar();
               if (!c(var1) && !bo()) {
                  break label159;
               }
            }

            if ((getMyChar().db < 0 || getMyChar().db != var1.idChar) && (getMyChar().dc < 0 || getMyChar().dc != var1.idChar || bo()) && (var1.dc < 0 || var1.dc != getMyChar().idChar || bo())) {
               return false;
            }
         }

         if (var1.statusMe != 14 && var1.statusMe != 5) {
            return true;
         } else {
            return false;
         }
      }
   }

   private static boolean c(Char var0) {
      for(int var1 = 0; var1 < GameScr.vParty.size(); ++var1) {
         Party var2 = (Party)GameScr.vParty.elementAt(var1);
         if (var0.idChar == var2.a) {
            return true;
         }
      }

      return false;
   }

   public static void y() {
      getMyChar().c(21);
      getMyChar().ca = null;

      for(int var0 = 0; var0 < getMyChar().arrItemBag.length; ++var0) {
         if (getMyChar().arrItemBag[var0] != null && (getMyChar().arrItemBag[var0].template.type == 25 || getMyChar().arrItemBag[var0].template.type == 23 || getMyChar().arrItemBag[var0].template.type == 24)) {
            getMyChar().arrItemBag[var0] = null;
         }
      }

      Npc.phong_ae();
   }

   public static int z() {
      if (dy >= 4000) {
         return 4;
      } else if (dy >= 1500) {
         return 3;
      } else if (dy >= 600) {
         return 2;
      } else {
         return dy >= 200 ? 1 : 0;
      }
   }

   public final boolean aa() {
      return this.isHuman;
   }

   public final boolean ab() {
      return this.isNhanban;
   }

   public final void ac() {
      this.jo = (int[][])((int[][])CharPartInfo.h.a(String.valueOf(this.arrItemMounts[4].template.id)));
   }

   public final boolean ad() {
      if (this.ID_HORSE > -1) {
         return false;
      } else {
         return this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523 && this.arrItemMounts[4].template.id != 485 && this.arrItemMounts[4].template.id != 524;
      }
   }

   private void bp() {
      if (this.ID_HORSE <= -1 && this.bq && this.jo != null) {
         ++this.jp;
         if (this.bp) {
            this.jq = 5;
         } else if (this.statusMe != 1 && this.statusMe != 6) {
            if (this.statusMe != 2 && this.statusMe != 10) {
               if (this.statusMe == 3) {
                  this.jq = 2;
               } else if (this.statusMe == 4) {
                  this.jq = 3;
               } else if (this.statusMe == 14) {
                  this.jq = 4;
               }
            } else {
               this.jq = 1;
               int var1 = this.jo[this.jq].length / 3;
               if (this.jp < var1) {
                  this.jr = 0;
               } else if (this.jp < var1 << 1) {
                  this.jr = 1;
               } else {
                  this.jr = 2;
               }
            }
         } else {
            this.jq = 0;
            this.jp = GameCanvas.w % 20 > 12 ? 1 : 0;
            if (this.ID_PP > -1) {
               this.jp = this.bm;
            }

            this.jr = this.jp;
         }

         if (this.jp > this.jo[this.jq].length - 1) {
            this.jp = 0;
         }
      }

   }

   private void g(mGraphics var1) {
      byte var2 = 2;
      if (this.cdir == 1) {
         var2 = 0;
      }

      SmallImage.a(var1, this.jo[this.jq][this.jp], this.cx1, this.cy1, var2, 33);
   }

   private void a(mGraphics var1, Part var2, Part var3, int[] var4) {
      byte var5 = 2;
      byte var6 = 24;
      if (this.cdir == 1) {
         var5 = 0;
         var6 = 0;
      }

      if (var2 != null) {
         SmallImage.a(var1, var2.a[ea[this.bm][3][0]].a, this.cx1 + (ea[this.bm][3][1] + var2.a[ea[this.bm][3][0]].b) * this.cdir, this.cy1 - ea[this.bm][3][2] + var2.a[ea[this.bm][3][0]].c - 10 + this.jr, var5, var6);
      }

      if (var4 != null && this.ID_PP == -1) {
         SmallImage.a(var1, var4[this.dg], this.cx1 + this.ht + (this.hp + -7) * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 19 + this.hq + this.jr, var5, 17);
      }

      byte var7 = -4;
      if (this.cdir == 1) {
         var7 = 4;
      }

      SmallImage.a(var1, this.jo[this.jq][this.jp], this.cx1, this.cy1, var5, 33);
      if (this.ID_Body > -1) {
         this.k(var1, this.cx1 + var7 + this.bf(), this.cy1 - 18 + this.jr - this.be(), 1);
      } else {
         SmallImage.a(var1, this.bi(), this.cx1 + this.ht + this.hp * this.cdir, this.cy1 - SmallImage.b(this.bh()) - 9 + this.hq + this.jr, var5, 33);
      }

      if (this.ID_HAIR > -1) {
         this.l(var1, this.cx1 + var7 + this.bf(), this.cy1 - 18 + this.jr - this.be(), 1);
      } else {
         SmallImage.a(var1, this.bj(), this.cx1 + this.ht + this.hn * this.cdir, this.cy1 - ea[0][0][2] + var3.a[ea[0][0][0]].c - 12 + this.ho + this.jr, var5, 17);
      }

      if (this.ID_MAT_NA > -1) {
         this.m(var1, this.cx1 + var7 + this.bf(), this.cy1 - 18 + this.jr - this.be(), 1);
      }

   }

   public final void setThoiTrang(short[] var1) {
      this.ID_HAIR = var1[0];
      this.ID_Body = var1[1];
      this.ID_LEG = var1[2];
      this.ID_WEA_PONE = var1[3];
      this.ID_PP = var1[4];
      this.ID_NAME = var1[5];
      this.ID_HORSE = var1[6];
      this.ID_RANK = var1[7];
      this.ID_MAT_NA = var1[8];
      this.ID_Bien_Hinh = var1[9];
      this.ColorName = 0;
      if (this.ID_NAME > 3000) {
         this.ColorName = (byte)(this.ID_NAME - 3000);
         this.ID_NAME = -1;
      }

      debugFashion("setThoiTrang charId=" + this.idChar + " name=" + this.cName + " values=[" + var1[0] + "," + var1[1] + "," + var1[2] + "," + var1[3] + "," + var1[4] + "," + var1[5] + "," + var1[6] + "," + var1[7] + "," + var1[8] + "," + var1[9] + "] current(body/hair/mask)=" + this.ID_Body + "/" + this.ID_HAIR + "/" + this.ID_MAT_NA + " ff=" + this.ff);

   }

   public static boolean move(int var0, int var1) {
      Char var2 = getMyChar();
      if (var0 == -1) {
         var0 = var2.cx1;
      }

      if (var1 == -1) {
         var1 = var2.cy1;
      }

      if (var0 == var2.cx1 && var1 == var2.cy1) {
         return false;
      } else {
         int var3 = 0;
         int var4 = var2.cx1;
         int var5 = TileMap.tileTypeAt(var0, var1 - 12, 64) ? TileMap.tileYofPixel(var1) - 24 : var1;
         int var6;
         if (var0 > var4) {
            while(true) {
               var4 += 50;
               if (var4 >= var0) {
                  break;
               }

               var6 = TileMap.e(var4, var5);
               Service.gI().b(var4, var6);
               ++var3;
            }
         } else {
            while(true) {
               var4 -= 50;
               if (var4 <= var0) {
                  break;
               }

               var6 = TileMap.e(var4, var5);
               Service.gI().b(var4, var6);
               ++var3;
            }
         }

         Service.gI().b(var0, var1);
         phong.sleep(5L);
         Service.gI().b(var0, var1);
         var2.gi = System.currentTimeMillis();
         var2.cx1 = var2.eb = var0;
         var2.cy1 = var2.ec = var1;
         return true;
      }
   }

   public static boolean d(int var0, int var1) {
      if (var0 == -1) {
         var0 = myChar.cx1;
      }

      if (var1 == -1) {
         var1 = myChar.cy1;
      }

      int[] var2 = new int[2];
      return !TileMap.a(var0, var1, var2) ? false : move(var2[0], var2[1]);
   }

   public static void e(int var0, int var1) {
      int var4 = Res.e(var0 - myChar.cx1) / 50;
      int var3 = Res.e(var1 - myChar.cy1) / 10;
      int var2 = myChar.cx1;
      int var5 = myChar.cy1;
      if (var3 < 3) {
         Service.gI().b(myChar.cx1, var5 = var1 - 60);
         var3 = 3;
      }

      int var6;
      for(var6 = 0; var6 < var4; ++var6) {
         if (var0 > myChar.cx1) {
            var2 += 50;
         } else {
            var2 -= 50;
         }

         Service.gI().b(var2, var5);
      }

      Service.gI().b(var0, var5);

      for(var6 = 0; var6 < var3; ++var6) {
         if (var1 > myChar.cy1) {
            var5 += 10;
         } else {
            var5 -= 10;
         }

         Service.gI().b(var0, var5);
      }

      Service.gI().b(var0, var1);
      myChar.gi = System.currentTimeMillis();
      myChar.cx1 = myChar.eb = var0;
      myChar.cy1 = myChar.ec = var1;
      Service.gI().b(myChar.cx1, myChar.cy1);
   }

   public static TaskOrder get_nvhn(int var0) {
      for(int var1 = 0; var1 < getMyChar().dw.size(); ++var1) {
         TaskOrder var2;
         if ((var2 = (TaskOrder)getMyChar().dw.elementAt(var1)) != null && var2.a == var0) {
            return var2;
         }
      }

      return null;
   }

   static {
      phong.load_auto();
      int[] var10000 = new int[]{-2, -6, 22, 21, 19, 22, 10, -2, -2, 5, 19};
      var10000 = new int[]{9, 22, 25, 17, 26, 37, 36, 49, 50, 52, 36};
      gj = true;
      en = new byte[]{0, 0, 0, -1, -1, -1, -2, -2, -2, -1, -1, -1};
      gs = 250;
      hl = new mHashtable();
      is = new mFont[]{mFont.i, mFont.h, mFont.c, mFont.d};
      fg = false;
   }
}
