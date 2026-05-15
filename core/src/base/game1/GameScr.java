package base.game1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class GameScr extends mScreen implements IActionListener {
   public static GameScr instance;
   public static int i;
   public static int j;
   public static int k;
   private static int fq;
   private static int fr;
   public static int l;
   public static int m;
   private static int fs;
   public static int n;
   public static int o;
   public static int p;
   public static int q;
   private static int ft;
   private static int fu;
   private static int fv;
   private static int fw;
   public static int r;
   public static int s;
   private static int fx;
   private static int fy;
   public static int gssx;
   public static int gssy;
   public static int gssxe;
   public static int gssye;
   public static MyVector x = new MyVector();
   private Command1 fz;
   private Command1 ga;
   private Command1 gb;
   private Command1 gc;
   private Command1 gd;
   private Command1 ge;
   private Command1 gf;
   private Command1 gg;
   public static int hpPotion;
   public static int mpPotion;
   public static SkillPaint[] aa;
   public static Arrowpaint[] ab;
   public static Part[] ac;
   public static EffectCharPaint[] ad;
   private int gh = 0;
   private boolean gi = false;
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
   public static MyVector vMobAttack = new MyVector();
   public static MyVector vSet = new MyVector();
   public static MyVector vMob = new MyVector();
   public static MyVector vNpc = new MyVector();
   public static MyVector vBuNhin = new MyVector();
   private static MyVector vLanterns = new MyVector();
   public static NClass[] nClasss;
   private static int indexSize = 28;
   private static int indexTitle = 0;
   public static int indexSelect = 0;
   public static int av = -1;
   private static int gm;
   public static int aw = 0;
   public static int ax = -1;
   private Item gn;
   public static ItemOptionTemplate[] ay;
   public static SkillOptionTemplate[] az;
   private static Scroll go = new Scroll();
   public static Scroll ba = new Scroll();
   public static Item[] bb;
   public static Item[] bc;
   public static Item[] bd;
   public static Item[] be;
   public static Item[] bf;
   public static Item[] bg;
   public static Item[] bh;
   public static Item[] bi;
   public static Item[] bj;
   public static Item[] bk;
   public static Item[] bl;
   public static Item[] bm;
   public static Item[] bn;
   public static Item[] bo;
   public static Item[] bp;
   public static Item[] bq;
   public static Item[] br;
   public static Item[] bs;
   public static Item[] bt;
   public static Item[] bu;
   public static Item[] bv;
   public static Item[] bw;
   public static Item[] bx;
   public static Item[] by;
   public static Item[] bz;
   public static Item[] ca;
   public static Item[] cb;
   public static Item[] cc;
   public static Item[] cd;
   public static Item[] ce;
   public static ItemStands[] cf;
   public static short[] cg;
   public int ch;
   public static Item ci;
   public static Item cj;
   public static Item ck;
   private static boolean gp;
   private static boolean gq;
   private static boolean gr;
   private static boolean gs;
   public static boolean cl;
   private static boolean gt;
   public static boolean cm;
   private static boolean gu;
   public static boolean cn;
   public static boolean co;
   private static boolean gv;
   private static boolean gw;
   private static boolean gx;
   public static boolean cp;
   private static boolean gy;
   private static boolean gz;
   public static boolean cq;
   private static boolean ha;
   public static boolean cr;
   private static boolean hb;
   private static boolean hc;
   private static boolean hd;
   private static boolean he;
   private static boolean hf;
   private static boolean hg;
   private static boolean hh;
   private static boolean hi;
   private static boolean hj;
   private static boolean hk;
   private static boolean hl;
   private static boolean hm;
   private static boolean hn;
   private static boolean ho;
   private static boolean hp;
   private static boolean hq;
   private static boolean hr;
   private static boolean hs;
   private static boolean ht;
   private static boolean hu;
   private static boolean hv;
   private static boolean hw;
   private static boolean hx;
   private static boolean hy;
   private static boolean hz;
   private static boolean ia;
   private static boolean ib;
   private static boolean ic;
   public static boolean cs;
   private static boolean id;
   public static boolean ct;
   public static boolean cu;
   private static boolean ie;
   private static boolean ifa;
   private static boolean ig;
   private static boolean ih;
   private static boolean ii;
   private static boolean ij;
   private static boolean ik;
   private static boolean il;
   private static boolean im;
   private static boolean in;
   private static boolean io;
   private static boolean ip;
   private static boolean iq;
   private static boolean ir;
   public static Char currentCharViewInfo;
   public static long[] exps;
   public static int[] cx;
   public static int[] cy;
   public static int[] cz;
   public static int[] da;
   public static int[] db;
   public static int[] dc;
   public static int[] dd;
   public static int[] de;
   public static int[] df;
   public static int[] dg;
   private static int[] is;
   private int it = 6;
   public int[] iu;
   private int[] iv;
   public int dh = 0;
   public int di = 0;
   public int dj = 0;
   public int dk = 0;
   public int dl = 0;
   private int iw = 0;
   private int ix = 0;
   private int iy = 0;
   private int iz = -1;
   public int dm = -1;
   public int dn = -1;
   private boolean ja;
   public static byte[][] doa;
   public static byte[][] dp;
   private MyVector jb;
   private String jc;
   private TField jd = null;
   public static byte dq;
   public static byte dr;
   public static byte ds;
   public static byte dt;
   public static byte du;
   public static byte dv;
   public static byte dw;
   public static byte dx;
   private static Image je;
   private static Image jf;
   private static Image jg;
   private static Image jh;
   public static Image imgAnalog1;
   public static Image imgAnalog2;
   public static GamePad gamePad;
   private static Image ji;
   private static Image jj;
   private static Image jk;
   private static Image jl;
   private static Image jm;
   private static Image jn;
   private static Image jo;
   private static Image jp;
   private static Image jq;
   private static Image jr;
   public static Image dy;
   public static Image dz;
   public static Image ea;
   public static Image eb;
   private static Image js;
   public static Image ec;
   public static Image ed;
   public String ee = "";
   public String ef = "";
   public int eg;
   public int eh;
   private static byte jt;
   public static byte ei;
   private int[] ju = new int[2];
   private int[] jv = new int[2];
   private int[] jw;
   private int[] jx;
   public long ej;
   public String[] ek = new String[]{"10000", "20000", "30000", "50000", "100000", "200000", "500000", "1000000", "5000000"};
   public int el;
   public int em;
   public String[] en;
   public static MyVector eo;
   public static MyVector ep;
   public static MyVector eq;
   public static Image er;
   public static Image es;
   public static Image et;
   public static Image eu;
   public static Image ev;
   public static Image ew;
   public static boolean ex;
   public static boolean ey;
   private static Skill[] jy;
   private static Skill[] jz;
   private Command1 ka;
   private Command1 kb;
   private Command1 kc;
   private Command1 kd;
   private Command1 ke;
   private Command1 kf;
   private static byte kg;
   static int ez;
   static int fa;
   private long kh;
   public static int fb;
   public boolean fc = false;
   private int ki = 0;
   private int kj = -1;
   private long kk;
   private int kl = 0;
   private static int km;
   private static int kn;
   private static int ko;
   private static int kp;
   private static int kq;
   private static int kr;
   private static int ks;
   private static int kt;
   private static int ku;
   private static int kv;
   private static int kw;
   private static int kx;
   private static int ky;
   private static int kz;
   private static int la;
   private static int lb;
   private static int lc;
   private static int ld;
   private static int[] le;
   private static int[] lf;
   private static int lg;
   private static int lh;
   private static int li;
   private static String[] lj;
   private static int[] lk;
   private static int[] ll;
   private static int[] lm;
   private static int[] ln;
   private static int[] lo;
   private static int[] lp;
   private static int[] lq;
   private static int[] lr;
   private static int[] ls;
   private static int[] lt;
   private static int[] lu;
   private static Image[] lv;
   private static int lw;
   private static int lx;
   private static int ly;
   private static int lz;
   private static int ma;
   private static int mb;
   private static int mc;
   private static int md;
   private static int me;
   private static int mf;
   private static int mg;
   private static int mh;
   private static Image[] mi;
   public static int fd;
   public static int fe;
   public static Command1 btnDoiTab;
   private static int mj;
   private static boolean mk;
   private int ml;
   private String[] mm;
   private String[] mn;
   private int mo;
   private Command1 mp;
   private Command1 mq;
   private Command1 mr;
   private Command1 ms;
   private Command1 mt;
   private Command1 mu;
   private Command1 mv;
   private Command1 mw;
   private Command1 mx;
   private Command1 my;
   private Command1 mz;
   private Command1 na;
   private Command1 nb;
   private Command1 nc;
   private Command1 nd;
   public Command1 ne;
   private Command1 nf;
   private Command1 ng;
   private Command1 nh;
   private Command1 ni;
   private Command1 nj;
   private Command1 nk;
   private Command1 nl;
   private Command1 nm;
   private Command1 nn;
   private Command1 no;
   private Command1 np;
   private Command1 nq;
   private Command1 nr;
   private Command1 ns;
   private Command1 nt;
   private Command1 nu;
   private Command1 nv;
   private Command1 nw;
   private Command1 nx;
   private Command1 ny;
   private Command1 nz;
   private Command1 oa;
   private String ob;
   private String oc;
   private static int od;
   private static int oe;
   public static int ff;
   public static int fg;
   private static int of;
   private static int og;
   private static int oh;
   private static int oi;
   private static int oj;
   private static int ok;
   private int ol;
   private int[] om;
   private int[][] on;
   private int[] oo;
   private static String op;
   public static int fh;
   public static EffectCharPaint fi;
   private static int oq;
   private static int or;
   private static int os;
   private static int ot;
   private static long lastJavaDocBagLogMs;
   private static long lastJavaDocCrLogMs;
   public Command1 fj;
   private Command1 ou;
   private Command1 ov;
   private Command1 ow;
   private Command1 ox;
   private Command1 oy;
   private Command1 oz;
   private Command1 pa;
   public static String fk;
   public static String fl;
   private int pb;
   private int pc;
   private String pd;
   private long pe;
   private static long pf;
   private static int pg;
   private static int[] ph;
   private static int[] pi;
   private static boolean pj;
   public static int fm;
   public static int fn;
   public static int fo;
   private short pk;
   private short pl;
   private short pm;
   private String pn;
   private String po;
   private String pp;
   private String pq;
   private String pr;
   private long ps;
   private boolean pt;
   public static byte fp;
   private mFont pu;
   private byte[] pv;
   private byte pw;
   private MyVector px;
   private int py;
   private int pz;
   private int qa;
   private int qb;
   private int qc;
   private int qd;
   private int qe;
   private int qf;
   private int qg;
   private int qh;
   private int qi;
   private int qj;
   private int qk;
   private int ql;
   private int qm;
   private int qn;
   private String qo;
   private int[] qp;
   private int[] qq;
   private int qr;
   private int[][] qs;
   private static int qt;
   public static boolean tilemap_fi = true;
   public static int phong_tilemap = 1;

   public static long b(int var0) {
      long var1 = 0L;

      for(int var3 = 0; var3 <= var0; ++var3) {
         var1 += exps[var3];
      }

      return var1;
   }

   public static void f() {
      vCharInMap.removeAllElements();
      vItemMap.removeAllElements();
      vMobSoul.removeAllElements();
      Effect2.a.removeAllElements();
      Effect2.d.removeAllElements();
      Effect2.c.removeAllElements();
      vMobAttack.removeAllElements();
      vSet.removeAllElements();
      vMob.removeAllElements();
      vNpc.removeAllElements();
      vBuNhin.removeAllElements();
      Char.getMyChar().ef.removeAllElements();
   }

   public static void loadSkillShortcut() {
      Service.gI().m("KSkill");
      Service.gI().m("OSkill");
      Service.gI().m("CSkill");
   }

   public static void loadSkillShortcutNhanban() {
      Service.gI().m("KSkill");
      Service.gI().m("OSkill");
      Service.gI().m("CSkill");
   }

   public final void a(byte[] var1) {
      jz = new Skill[5];
      int var4;
      if (var1 == null) {
         for(var4 = 0; var4 < jz.length && var4 < Char.getMyChar().vSkillFight.size(); ++var4) {
            Skill var5 = (Skill)Char.getMyChar().vSkillFight.elementAt(var4);
            jz[var4] = var5;
         }

         ap();
      } else {
         for(var4 = 0; var4 < var1.length; ++var4) {
            for(int var2 = 0; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
               Skill var3;
               if ((var3 = (Skill)Char.getMyChar().vSkillFight.elementAt(var2)).template.id == var1[var4]) {
                  jz[var4] = var3;
                  break;
               }
            }
         }
      }

   }

   public static Skill getFightSkillShortcut(int var0) {
      return jz != null && var0 >= 0 && var0 < jz.length ? jz[var0] : null;
   }

   public final void b(byte[] var1) {
      jy = new Skill[3];
      int var4;
      if (var1 == null) {
         for(var4 = 0; var4 < jy.length && var4 < Char.getMyChar().vSkillFight.size(); ++var4) {
            Skill var5 = (Skill)Char.getMyChar().vSkillFight.elementAt(var4);
            jy[var4] = var5;
         }

         aq();
      } else {
         for(var4 = 0; var4 < var1.length; ++var4) {
            for(int var2 = 0; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
               Skill var3;
               if ((var3 = (Skill)Char.getMyChar().vSkillFight.elementAt(var2)).template.id == var1[var4]) {
                  jy[var4] = var3;
                  break;
               }
            }
         }
      }

   }

   public final void c(byte[] var1) {
      if (var1 != null && var1.length != 0) {
         for(int var3 = 0; var3 < Char.getMyChar().vSkillFight.size(); ++var3) {
            Skill var2;
            if ((var2 = (Skill)Char.getMyChar().vSkillFight.elementAt(var3)).template.id == var1[0]) {
               Char.getMyChar().myskill = var2;
               Char.getMyChar().fk = var2;
               break;
            }
         }
      } else if (Char.getMyChar().vSkillFight.size() > 0) {
         Char.getMyChar().myskill = (Skill)Char.getMyChar().vSkillFight.elementAt(0);
      }

      if (Char.getMyChar().myskill != null) {
         Service.gI().selectSkill(Char.getMyChar().myskill.template.id);
         Char.getMyChar();
      }

   }

   private static void a(SkillTemplate var0) {
      Skill var5 = Char.getMyChar().a(var0);
      MyVector var1 = new MyVector();

      for(int var2 = 0; var2 < 5; ++var2) {
         boolean var3 = false;
         if (jz[var2] == null) {
            var3 = true;
         }

         Object[] var4;
         (var4 = new Object[2])[0] = var5;
         var4[1] = String.valueOf(var2);
         var1.addElement(new Command1(TextGame.fc + " " + (var2 + 1), 11120, var4));
         if (var3) {
            break;
         }
      }

      GameCanvas.af.a(var1);
   }

   private static void b(SkillTemplate var0) {
      Skill var5 = Char.getMyChar().a(var0);
      String[] var1 = TField.h ? TextGame.fd : TextGame.fe;
      MyVector var2 = new MyVector();

      for(int var3 = 0; var3 < 3; ++var3) {
         Object[] var4;
         (var4 = new Object[2])[0] = var5;
         var4[1] = String.valueOf(var3);
         var2.addElement(new Command1(var1[var3], 11121, var4));
      }

      GameCanvas.af.a(var2);
   }

   private static void ap() {
      byte[] var0 = new byte[jz.length];

      for(int var1 = 0; var1 < jz.length; ++var1) {
         if (jz[var1] == null) {
            var0[var1] = -1;
         } else {
            var0[var1] = jz[var1].template.id;
         }
      }

      if (Char.getMyChar().aa()) {
         Service.gI().a("OSkill", (byte[])((byte[])var0), (byte)0);
      } else {
         Service.gI().a("OSkill", (byte[])((byte[])var0), (byte)1);
      }

   }

   private static void aq() {
      byte[] var0 = new byte[jy.length];

      for(int var1 = 0; var1 < jy.length; ++var1) {
         if (jy[var1] == null) {
            var0[var1] = -1;
         } else {
            var0[var1] = jy[var1].template.id;
         }
      }

      if (Char.getMyChar().aa()) {
         Service.gI().a("KSkill", (byte[])((byte[])var0), (byte)0);
      } else {
         Service.gI().a("KSkill", (byte[])((byte[])var0), (byte)1);
      }

   }

   public final void a(Skill var1) {
      if (var1.template.type != 0) {
         int var2;
         for(var2 = 0; var2 < jz.length; ++var2) {
            if (jz[var2] == null) {
               jz[var2] = var1;
               break;
            }
         }

         for(var2 = 0; var2 < jy.length; ++var2) {
            if (jy[var2] == null) {
               jy[var2] = var1;
               break;
            }
         }

         if (Char.getMyChar().myskill == null) {
            Char.getMyChar().myskill = var1;
            if (Code.mode instanceof AutoNv20) {
               Auto.my_skill = var1;
            }
         }

         aq();
         ap();
      }

   }

   public static boolean i() {
      for(int var0 = Char.getMyChar().arrItemBag.length - 1; var0 >= 0; --var0) {
         if (Char.getMyChar().arrItemBag[var0] == null) {
            return false;
         }
      }

      return true;
   }

   public static void a(String[] var0, Npc var1) {
      MyVector var2 = new MyVector();

      for(int var3 = 0; var3 < var0.length; ++var3) {
         var2.addElement(new Command1(var0[var3], 11057, var1));
      }

      GameCanvas.af.a(var2);
      GameCanvas.af.selectFirstNpcMenu();
   }

   public void ar() {
      currentCharViewInfo = Char.getMyChar();
      aw = 0;
      this.be();
   }

   private void as() {
      currentCharViewInfo = Char.getMyChar();
      aw = 1;
      this.be();
   }

   private void at() {
      currentCharViewInfo = Char.getMyChar();
      aw = 2;
      this.be();
   }

   private void au() {
      currentCharViewInfo = Char.getMyChar();
      aw = 3;
      this.be();
   }

   private void av() {
      currentCharViewInfo = Char.getMyChar();
      aw = 4;
      this.be();
   }

   private void aw() {
      currentCharViewInfo = Char.getMyChar();
      aw = 5;
      this.be();
   }

   private void ax() {
      currentCharViewInfo = Char.getMyChar();
      aw = 6;
      qt = 0;
      this.be();
   }

   private void ay() {
      currentCharViewInfo = Char.getMyChar();
      aw = 6;
      qt = 1;
      this.be();
   }

   private void az() {
      currentCharViewInfo = Char.getMyChar();
      aw = 6;
      qt = 2;
      this.be();
   }

   public static void j() {
      DataInputStream var0 = null;

      try {
         short var1;
         ac = new Part[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.a("nj_part")))).readShort()];

         for(int var2 = 0; var2 < var1; ++var2) {
            int var3 = var0.readByte();
            ac[var2] = new Part(var3);

            for(var3 = 0; var3 < ac[var2].a.length; ++var3) {
               ac[var2].a[var3] = new PartImage();
               ac[var2].a[var3].a = var0.readShort();
               ac[var2].a[var3].b = var0.readByte();
               ac[var2].a[var3].c = var0.readByte();
            }
         }
      } catch (Exception var12) {
         ;
      } finally {
         try {
            var0.close();
         } catch (IOException var11) {
            ;
         }

      }

   }

   public static void k() {
      DataInputStream var0 = null;

      try {
         short var1;
         ad = new EffectCharPaint[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.a("nj_effect")))).readShort()];

         for(int var2 = 0; var2 < var1; ++var2) {
            ad[var2] = new EffectCharPaint();
            ad[var2].a = var0.readShort();
            ad[var2].b = new EffectInfoPaint[var0.readByte()];

            for(int var3 = 0; var3 < ad[var2].b.length; ++var3) {
               ad[var2].b[var3] = new EffectInfoPaint();
               ad[var2].b[var3].c = var0.readShort();
               ad[var2].b[var3].a = var0.readByte();
               ad[var2].b[var3].b = var0.readByte();
            }
         }
      } catch (Exception var12) {
         ;
      } finally {
         try {
            var0.close();
         } catch (IOException var11) {
            ;
         }

      }

   }

   public static void l() {
      DataInputStream var0 = null;

      try {
         short var1;
         ab = new Arrowpaint[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.a("nj_arrow")))).readShort()];

         for(int var2 = 0; var2 < var1; ++var2) {
            ab[var2] = new Arrowpaint();
            var0.readShort();
            ab[var2].a[0] = var0.readShort();
            ab[var2].a[1] = var0.readShort();
            ab[var2].a[2] = var0.readShort();
         }
      } catch (Exception var11) {
         ;
      } finally {
         try {
            var0.close();
         } catch (IOException var10) {
            ;
         }

      }

   }

   public static void m() {
      DataInputStream var0 = null;

      try {
         short var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.a("nj_skill")))).readShort();
         int var2 = 0;

         int var3;
         for(var3 = 0; var3 < nClasss.length; ++var3) {
            var2 += nClasss[var3].c.length;
         }

         aa = new SkillPaint[var2 + 10]; // extra buffer to avoid index out of bounds

         for(var3 = 0; var3 < var1; ++var3) {
            short var12 = var0.readShort();
            if (var12 >= aa.length) { var0.readShort(); var0.readByte(); int _skip = var0.readByte(); for(int _s=0;_s<_skip;_s++){var0.readByte();var0.readByte();var0.readByte();var0.readShort();var0.readShort();var0.readShort();var0.readShort();var0.readShort();} continue; }
            aa[var12] = new SkillPaint();
            aa[var12].a = var0.readShort();
            var0.readByte();
            aa[var12].b = new SkillInfoPaint[var0.readByte()];

            int var4;
            for(var4 = 0; var4 < aa[var12].b.length; ++var4) {
               aa[var12].b[var4] = new SkillInfoPaint();
               aa[var12].b[var4].a = var0.readByte();
               aa[var12].b[var4].b = var0.readShort();
               aa[var12].b[var4].c = var0.readShort();
               aa[var12].b[var4].d = var0.readShort();
               aa[var12].b[var4].e = var0.readShort();
               aa[var12].b[var4].f = var0.readShort();
               aa[var12].b[var4].g = var0.readShort();
               aa[var12].b[var4].h = var0.readShort();
               aa[var12].b[var4].i = var0.readShort();
               aa[var12].b[var4].j = var0.readShort();
               aa[var12].b[var4].k = var0.readShort();
               aa[var12].b[var4].l = var0.readShort();
               aa[var12].b[var4].m = var0.readShort();
            }

            aa[var12].c = new SkillInfoPaint[var0.readByte()];

            for(var4 = 0; var4 < aa[var12].c.length; ++var4) {
               aa[var12].c[var4] = new SkillInfoPaint();
               aa[var12].c[var4].a = var0.readByte();
               aa[var12].c[var4].b = var0.readShort();
               aa[var12].c[var4].c = var0.readShort();
               aa[var12].c[var4].d = var0.readShort();
               aa[var12].c[var4].e = var0.readShort();
               aa[var12].c[var4].f = var0.readShort();
               aa[var12].c[var4].g = var0.readShort();
               aa[var12].c[var4].h = var0.readShort();
               aa[var12].c[var4].i = var0.readShort();
               aa[var12].c[var4].j = var0.readShort();
               aa[var12].c[var4].k = var0.readShort();
               aa[var12].c[var4].l = var0.readShort();
               aa[var12].c[var4].m = var0.readShort();
            }
         }
      } catch (Exception var14) {
         ;
      } finally {
         try {
            var0.close();
         } catch (IOException var13) {
            ;
         }

      }

   }

   public static void setLevel_Exp(long var0, boolean var2) {
      long var6 = var0;
      boolean var8 = false;

      int var9;
      for(var9 = 0; var9 < exps.length && var6 >= exps[var9]; ++var9) {
         var6 -= exps[var9];
      }

      long[] var10 = new long[]{(long)var9, var6};
      Char.getMyChar().cLevel = (int)var10[0];
      Char.getMyChar().ae = var10[1];
   }

   public static GameScr gI() {
      if (instance == null) {
         instance = new GameScr();
      }

      return instance;
   }

   public static void o() {
      instance = null;
      cd = null;
      cc = null;
      cb = null;
      ca = null;
      bz = null;
      cj = null;
      ci = null;
   }

   public final void p() {
      if (lv == null) {
         lv = new Image[3];

         for(int var1 = 0; var1 < 3; ++var1) {
            lv[var1] = GameCanvas.c("/e/sp" + var1 + ".png");
         }
      }

      lq = new int[2];
      lr = new int[2];
      ls = new int[2];
      lt = new int[2];
      lu = new int[2];
      ls[0] = ls[1] = -1;
      this.bt();
      Res.a();
   }

   public GameScr() {
      int[] var10000 = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
      this.ml = 0;
      this.mm = null;
      this.mn = null;
      this.mo = 0;
      this.ol = 0;
      this.om = new int[]{0, 0, 0, 0, 600841, 600841, 667658, 667658, 3346944, 3346688, 4199680, 5052928, 3276851, 3932211, 4587571, 5046280, 6684682, 3359744};
      this.on = new int[][]{{18687, 16869, 15052, 13235, 11161, 9344}, {45824, 39168, 32768, 26112, 19712, 13056}, {16744192, 15037184, 13395456, 11753728, 10046464, 8404992}, {13500671, 12058853, 10682572, 9371827, 7995545, 6684800}, {16711705, 15007767, 13369364, 11730962, 10027023, 8388621}};
      this.oo = new int[]{2, 1, 1, 1, 1, 1};
      if (btnDoiTab == null) {
         btnDoiTab = new Command1("Tab", GameCanvas.instance, 13000712, (Object)null);
      }
      this.fj = new Command1(TextGame.ne[0], 11038);
      this.pb = 30;
      this.pc = 0;
      this.pd = "";
      this.pu = mFont.d;
      this.pv = new byte[]{-1, -1, -1, -1, -1, -1};
      this.pw = 0;
      this.px = new MyVector();
      this.qo = "";
      this.qs = new int[][]{new int[2], {200, 10}, {500, 20}, {1000, 50}, {2000, 100}, {5000, 200}, {10000, 500}, {20000, 1000}, {50000, 2000}, {100000, 5000}, {100000, 10000}};
      if (GameCanvas.aa == 128 || GameCanvas.ab <= 208) {
         indexSize = 20;
      }

      this.ke = new Command1(TextGame.gz, 5043);
      this.kf = new Command1(TextGame.gz, 5053);
      this.kd = new Command1(TextGame.dc, 11002);
      this.kc = new Command1(TextGame.gz, 11003);
      this.oa = new Command1(GameCanvas.g ? TextGame.ax : "", 11004);
      this.nz = new Command1(TextGame.bs, 11005);
      this.kb = new Command1(TextGame.gz, 11006);
      this.ny = new Command1(GameCanvas.g ? TextGame.ax : "", 11007);
      this.nx = new Command1(TextGame.bs, 11008);
      this.nw = new Command1(GameCanvas.g ? TextGame.ax : "", 11009);
      this.nv = new Command1(TextGame.bs, 11010);
      this.nu = new Command1(GameCanvas.g ? TextGame.ax : "", 11011);
      this.nt = new Command1(TextGame.bs, 11012);
      this.ns = new Command1(GameCanvas.g ? TextGame.ax : "", 11013);
      this.nr = new Command1(TextGame.bs, 11014);
      this.nq = new Command1(GameCanvas.g ? TextGame.ax : "", 11015);
      this.np = new Command1(TextGame.bs, 11016);
      this.nm = new Command1(GameCanvas.g ? TextGame.ax : "", 11017);
      this.no = new Command1(GameCanvas.g ? TextGame.ax : "", 13001);
      this.nl = new Command1(TextGame.bs, 11018);
      this.nn = new Command1(TextGame.bs, 13002);
      this.ni = new Command1(GameCanvas.g ? TextGame.ax : "", 11019);
      this.nh = new Command1(TextGame.bs, 11020);
      this.nf = new Command1(TextGame.bs, 14022);
      this.ng = new Command1(GameCanvas.g ? TextGame.ax : "", 14023);
      this.nk = new Command1(GameCanvas.g ? TextGame.ax : "", 14018);
      this.nj = new Command1(TextGame.bs, 14019);
      this.ne = new Command1(TextGame.ah, 11021);
      this.pa = new Command1(TextGame.doa, 11022);
      this.oz = new Command1(GameCanvas.g ? TextGame.ax : "", 11023);
      this.ox = new Command1(TextGame.be, 11024);
      this.oy = new Command1(TextGame.bf, 110244);
      this.ow = new Command1(TextGame.ah, 11025);
      this.ou = new Command1(TextGame.bc, 11026);
      this.ov = new Command1(TextGame.bd, 110221);
      this.nd = new Command1(TextGame.doa, 11027);
      this.nc = new Command1(TextGame.doa, 11028);
      this.nb = new Command1(TextGame.doa, 11029);
      this.na = new Command1(GameCanvas.g ? TextGame.ax : "", 11030);
      new Command1(TextGame.ee, 11021);
      this.ka = new Command1(TextGame.aa, 11000);
      this.ge = new Command1("Focus", 11001);
      this.mq = new Command1(TextGame.gr, 11032);
      this.mr = new Command1(TextGame.dc, 11033);
      this.mv = new Command1(TextGame.bj, 11034);
      this.mw = new Command1(TextGame.bj, 14014);
      this.mx = new Command1(TextGame.bj, 11035);
      this.my = new Command1(TextGame.bm, 11036);
      this.mz = new Command1(TextGame.bj, 11037);
      this.ms = new Command1(TextGame.bj, 339);
      this.mt = new Command1(TextGame.bj, 340);
      this.mu = new Command1(TextGame.bj, 343);
      this.mp = new Command1(TextGame.bj, 402);
      new Command1("240", 110381);
      new Command1("360", 1103911);
      new Command1("Toàn Map", 110401);
      this.gg = new Command1(TextGame.sj, 2003);
      this.gg.f = GameCanvas.aa / 2 - mScreen.e / 2;
      this.gg.g = GameCanvas.ab - 25;
      if (GameCanvas.g && GameCanvas.h) {
         this.ka.f = i - 135;
         this.ka.g = 6;
         this.ka.e = jj;
         this.ge.f = i;
         this.ge.g = j;
         if (GameCanvas.i) {
            this.ka.f = i / 2 - 38;
            this.ka.g = j - 34;
         }
      }

      this.ge.e = GameCanvas.c("/u/fc.png");
      super.a = this.ka;
      super.c = this.ge;
      if ((km = GameCanvas.ab / 5) > 100) {
         km = 100;
      }

   }

   private void ba() {
      cq = false;
      gq = false;
      if (aa()) {
         this.ac();
         super.c = this.ne;
      } else {
         this.aj();
      }

   }

   private void bb() {
      if (indexTitle > 0 && indexTitle <= 4 || GameCanvas.g) {
         GameCanvas.al.a(TextGame.jw, this.kb, 1);
      }

   }

   private void bc() {
      if (indexTitle > 0 && indexTitle <= 4) {
         GameCanvas.al.a(TextGame.jw, this.kc, 1);
      }

   }

   private void bd() {
      if (cp) {
         GameCanvas.al.a(TextGame.eb, this.kd, 0);
      }

   }

   private void be() {
      cr = true;
      b(175, 200);
      if (GameCanvas.aa >= 320) {
         if (aw == 3) {
            ff = Math.min(GameCanvas.aa - 10, 300);
            if (ff < 300) {
               ff = 300;
            }
         } else if (aw == 4) {
            ff = Math.min(GameCanvas.aa - 10, 340);
            if (ff < 300) {
               ff = 300;
            }
         }

         if (aw == 3 || aw == 4) {
            fe = i / 2 - ff / 2;
         }
      }

      logJavaDocCrLayout("be");
      this.aj();
      if (aw == 3 && currentCharViewInfo.idChar == Char.getMyChar().idChar) {
         Service.gI().a((String)currentCharViewInfo.cName, 0);
      }

      if (aw == 5) {
         this.jw = new int[5];
         this.jx = new int[5];
         od = fe + 5;
         oe = fd + 35;
         this.jw[0] = od + 5;
         this.jx[0] = oe + 35;
         this.jw[1] = od + 5;
         this.jx[1] = oe + 70;
         this.jw[2] = od + 131;
         this.jx[2] = oe + 35;
         this.jw[3] = od + 131;
         this.jx[3] = oe + 70;
         this.jw[4] = this.jw[0] + indexSize + 7;
         this.jx[4] = this.jx[0] - 5;
      }

      if (aw == 6) {
         this.jw = new int[5];
         this.jx = new int[5];
         od = fe + 5;
         oe = fd + 35;
         this.jw[0] = od + 5;
         this.jx[0] = oe + 35;
         this.jw[1] = od + 5;
         this.jx[1] = oe + 70;
         this.jw[2] = od + 131;
         this.jx[2] = oe + 35;
         this.jw[3] = od + 131;
         this.jx[3] = oe + 70;
         this.jw[4] = this.jw[0] + indexSize + 7;
         this.jx[4] = this.jx[0] - 5;
      }

      super.c = new Command1(TextGame.ee, 11060);
   }

   private void bf() {
      ba.a();
      go.a();
      gq = false;
      this.fz = new Command1(TextGame.fg[0], 1100011);
      this.ga = new Command1(TextGame.fg[1], 1100012);
      this.gb = new Command1(TextGame.fg[2], 1100013);
      this.gd = new Command1(TextGame.fg[3], 1100014);
      this.gc = new Command1(TextGame.fg[4], 1100015);
      this.gf = new Command1(TextGame.fg[6], 1100017);
      MyVector var1;
      (var1 = new MyVector()).addElement(this.fz);
      var1.addElement(this.ga);
      var1.addElement(this.gb);
      var1.addElement(this.gd);
      var1.addElement(this.gc);
      var1.addElement(new Command1(TextGame.fg[5], 1100016));
      var1.addElement(this.gf);
      GameCanvas.af.a(var1);
      GameCanvas.af.b = 0;
   }

   private static void bg() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.ns[0], 110002));
      var0.addElement(new Command1(TextGame.ns[1], 1100032));
      var0.addElement(new Command1(TextGame.ns[2], 1100033));
      var0.addElement(new Command1(TextGame.s, 1100034));
      var0.addElement(new Command1(TextGame.av, LoginScr.f(), 1004, (Object)null));
      GameCanvas.af.a(var0);
   }

   private static void bh() {
      if (kg <= 0) {
         Command1 var0 = new Command1(TextGame.in[1], 110001);
         Command1 var1 = new Command1(TextGame.in[3], 110003);
         Command1 var2 = new Command1(TextGame.in[4], 110004);
         new Command1(TextGame.in[0], 110005);
         Command1 var3 = new Command1(TextGame.in[6], 110006);
         new Command1(TextGame.in[7], 110007);
         new Command1(TextGame.in[8], 110008);
         new Command1(TextGame.in[9], 110009);
         new Command1(TextGame.in[10], 110010);
         new Command1(TextGame.in[11], 110011);
         new Command1(TextGame.in[12], 110012);
         new Command1(TextGame.in[13], 110013);
         new Command1(TextGame.in[14], 110014);
         new Command1(TextGame.in[15], 110015);
         new Command1(TextGame.in[16], 110016);
         new Command1(TextGame.in[17], 110017);
         Command1 var4 = new Command1(TextGame.in[18], 110018);
         Command1 var5 = new Command1("Xác thực tài khoản", 1100181);
         MyVector var6 = new MyVector();
         if (Char.getMyChar().cLevel >= 3 && SelectServerScr.g()) {
            var6.addElement(var5);
         }

         var6.addElement(var0);
         var6.addElement(new Command1("Menu up", 100));
         var6.addElement(new Command1("Menu vip", 1800));
         var6.addElement(new Command1("Menu pk", 127));
         var6.addElement(new Command1("Menu nvct", 1217));
         var6.addElement(new Command1("Menu phụ", 1272));
         var6.addElement(new Command1("Hướng dẫn", 155));
         var6.addElement(var1);
         var6.addElement(var3);
         var6.addElement(var4);
         var6.addElement(new Command1("Khu vực", 120));
         var6.addElement(new Command1("Thủ khố", 99));
         var6.addElement(new Command1("Tự sát", 110020));
         var6.addElement(var2);
         GameCanvas.af.a(var6);
         GameCanvas.af.b = Char.getMyChar().cLevel >= 3 && SelectServerScr.g() ? 1 : 0;
      }

   }

   private void bi() {
      this.v();
      gv = true;
      aw = this.gh;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
      super.a = new Command1(TextGame.in[2], 110002);
      super.b = new Command1(TextGame.fa, 110019);
   }

   public static String getContentFromUrl(String urlStr) {
      StringBuilder content = new StringBuilder();
      try {
         java.net.URL url = new java.net.URL(urlStr);
         java.io.BufferedReader in = new java.io.BufferedReader(
                 new java.io.InputStreamReader(url.openStream(), "UTF-8"));

         String inputLine;
         while ((inputLine = in.readLine()) != null)
            content.append(inputLine).append("\n");
         in.close();
      } catch (Exception e) {
         content.append("Không thể tải nội dung từ web.");
      }
      return content.toString();
   }


   public static String readFileinJar(String var1) {
      InputStream var5 = RMS.fieldAA("/" + var1);

      String var3;
      try {
         if (var5 == null) return "";
         byte[] var4 = new byte[var5.available()];
         var5.read(var4);
         var3 = new String(var4, "UTF-8");
      } catch (Exception var4) {
         var3 = "";
      }

      return var3;
   }

   private void bj() {
      this.v();
      gx = true;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
      Service.gI().d();
      this.s();
   }

   private void bk() {
      this.v();
      if (this.dm > 0) {
         av = Char.d(this.dm);
      } else {
         av = 0;
         this.dm = -1;
      }

      ic = true;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
   }

   private void bl() {
      this.v();
      gw = true;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
      this.t();
   }

   public final void q() {
      this.v();
      gu = true;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
      super.a = super.b = null;
      av = 0;
   }

   public final void r() {
      this.v();
      gy = true;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
      super.a = super.b = null;
      av = 0;
   }

   private void bm() {
      this.v();
      cp = true;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
      super.a = new Command1(TextGame.de, 11044);
      super.b = null;
      av = 0;
      Service.gI().u();
   }

   private void bn() {
      this.v();
      gz = true;
      this.ja = true;
      b(175, 200);
      super.c = this.ne;
      super.a = new Command1(TextGame.de, 14017);
      super.b = null;
      av = 0;
      Service.gI().v();
   }

   public final void s() {
      if (gx) {
         super.a = super.b = null;
         super.a = new Command1(TextGame.aa, 11045);
         Party var1;
         if (vPtMap.size() > 0 && av >= 0 && av < vPtMap.size() && (var1 = (Party)vPtMap.elementAt(av)) != null && !Char.getMyChar().cName.equals(var1.d)) {
            super.b = new Command1(TextGame.doa, 11046);
         }
      }

   }

   public final void t() {
      if (gw) {
         super.a = super.b = null;
         av = 0;
         if (vParty.size() == 0) {
            super.b = null;
            super.a = new Command1(TextGame.aa, 11047);
            return;
         }

         Party var1;
         if ((var1 = (Party)vParty.firstElement()).a == Char.getMyChar().idChar) {
            super.a = new Command1(TextGame.ni, 11070, var1);
            return;
         }

         super.a = new Command1(TextGame.nh, 11071);
      }

   }

   private static void bo() {
      if (TileMap.bgID != 1) {
         MapScr.f().a();
      }

   }

   public final void a(Message var1) {
      InfoDlg.b();

      try {
         byte var2;
         if ((var2 = var1.b().readByte()) > 0) {
            this.iu = new int[var2];
            this.iv = new int[this.iu.length];

            for(var2 = 0; var2 < this.iu.length; ++var2) {
               this.iu[var2] = var1.b().readByte();
               this.iv[var2] = var1.b().readByte();
            }

            id = true;
            indexSelect = TileMap.zoneID;
            b(175, 200);
            super.a = new Command1(TextGame.doa, 11067);
            super.b = new Command1("", 11067);
            super.c = this.ne;
         }
      } catch (Exception var3) {
         ;
      }

   }

   public final void u() {
      try {
         this.v();
         this.ef = "";
         this.dh = 0;
         this.dh = this.di = this.dj = this.dk = 0;
         cs = true;
         cc = new Item[12];
         cd = new Item[12];
         aw = 0;
         b(175, 200);
         super.c = this.ne;
      } catch (Exception var2) {
      }

   }

   public static final void a(boolean var0) {
      i = GameCanvas.aa;
      if (GameCanvas.g && (!GameCanvas.g || GameCanvas.h)) {
         n = 8;
      } else {
         n = 36;
         if (GameCanvas.g) {
            n += 3;
         }
      }

      j = GameCanvas.ab - n - 20;
      if (var0) {
         j = GameCanvas.ab;
      }

      if (GameCanvas.g && GameCanvas.h) {
         j = GameCanvas.ab;
      }

      if (GameCanvas.ab == 160) {
         j = 150;
      }

      ly = i;
      if (GameCanvas.aa > 176) {
         ly -= 50;
      }

      lw = 0;
      lx = GameCanvas.ab - Paint.f - n;
      if ((fs = GameCanvas.ab / 6) < 48) {
         fs = 48;
      }

      k = i >> 1;
      m = j >> 1;
      l = 2 * j / 3;
      o = i / 6;
      fq = i / TileMap.size + 2;
      fr = j / TileMap.size + 2;
      if (i % 24 != 0) {
         ++fq;
      }

      fx = (TileMap.tmw - 1) * TileMap.size - i;
      fy = (TileMap.tmh - 1) * TileMap.size - j;
      if (GameCanvas.g && GameCanvas.h) {
         fy += 60;
      }

      p = r = Char.getMyChar().cx1 - k + o * Char.getMyChar().cdir;
      q = s = Char.getMyChar().cy1 - l;
      if (p < 24) {
         p = 24;
      }

      if (p > fx) {
         p = fx;
      }

      if (q < 0) {
         q = 0;
      }

      if (q > fy) {
         q = fy;
      }

      if ((gssx = p / TileMap.size - 1) < 0) {
         gssx = 0;
      }

      gssy = q / TileMap.size;
      gssxe = gssx + fq;
      gssye = gssy + fr;
      if (gssy < 0) {
         gssy = 0;
      }

      if (gssye > TileMap.tmh - 1) {
         gssye = TileMap.tmh - 1;
      }

      if ((TileMap.ac = gssxe - gssx << 2) > TileMap.tmw) {
         TileMap.ac = TileMap.tmw;
      }

      if ((TileMap.ad = gssye - gssy << 2) > TileMap.tmh) {
         TileMap.ad = TileMap.tmh;
      }

      if ((TileMap.y = (Char.getMyChar().cx1 - 2 * i) / TileMap.size) < 0) {
         TileMap.y = 0;
      }

      if ((TileMap.z = TileMap.y + TileMap.ac) > TileMap.tmw) {
         TileMap.z = TileMap.tmw;
      }

      if ((TileMap.aa = (Char.getMyChar().cy1 - 2 * j) / TileMap.size) < 0) {
         TileMap.aa = 0;
      }

      if ((TileMap.ab = TileMap.aa + TileMap.ad) > TileMap.tmh) {
         TileMap.ab = TileMap.tmh;
      }

      ChatTextField.a().c = instance;
      ChatTextField.a().a.b = GameCanvas.ab - 35 - ChatTextField.a().a.d;
      if (!GameCanvas.g || GameCanvas.g && !GameCanvas.h) {
         TileMap.setPosMiniMap(GameCanvas.aa - 51, lx - 4, 50, 40);
      } else {
         TileMap.setPosMiniMap(GameCanvas.aa - 60, 0, 60, 42);
      }

      if (GameCanvas.g) {
         kn = j - 88;
         kq = i - 100;
         kr = 2;
         if (GameCanvas.i) {
            kq = i / 2 - 2;
            kr = kn + 50;
         }

         ko = 1;
         kp = kn + 50;
         ks = 42;
         kt = kn + 50;
         ku = i - 50;
         kv = kn + 35;
         kw = 22;
         kx = kn + 19;
         ky = i - 74;
         kz = kn + 13;
         la = i - 85;
         lb = kn + 50;
         lc = i - 37;
         ld = kn - 1;
         if (GameCanvas.aa >= 450) {
            kx -= 15;
            kw += 28;
            ks += 45;
            ko += 10;
            ld -= 12;
            kz -= 7;
            ku -= 18;
            lc -= 10;
            ky -= 17;
            la -= 24;
         } else if (GameCanvas.aa >= 360) {
            kx -= 5;
            kw += 6;
            ks += 12;
            ld -= 2;
            kz -= 2;
            ky -= 2;
            la -= 2;
         }
      }

      le = new int[jz.length];
      lf = new int[jz.length];
      int var1;
      if (GameCanvas.g) {
         if (GameCanvas.i) {
            lg = 2;
            lh = 55;
            li = 5;

            for(var1 = 0; var1 < le.length; ++var1) {
               le[var1] = var1 * (25 + li);
               lf[var1] = lh;
            }
         } else {
            if (GameCanvas.aa <= 320) {
               lg = k - jz.length * 25 / 2 - 15;
            } else {
               lg = k - jz.length * 25 / 2;
            }

            lh = kn + 58;
            li = 5;

            for(var1 = 0; var1 < le.length; ++var1) {
               le[var1] = var1 * (25 + li);
               lf[var1] = lh;
            }
         }
      } else {
         lg = 0;

         for(var1 = 0; var1 < lf.length; ++var1) {
            le[var1] = 2;
            lf[var1] = 2 + var1 * 25;
         }
      }

   }

   private static boolean bp() {
      if (Char.getMyChar().myskill != null && Char.getMyChar().cMP < Char.getMyChar().myskill.manaUse) {
         InfoMe.a(TextGame.je);
         return false;
      } else if (Char.getMyChar().myskill != null && (Char.getMyChar().myskill.template.maxPoint <= 0 || Char.getMyChar().myskill.point != 0)) {
         if (Char.getMyChar().arrItemBody[1] == null) {
            GameCanvas.a(TextGame.ms);
            return false;
         } else {
            return true;
         }
      } else {
         GameCanvas.a(TextGame.mr);
         return false;
      }
   }

   public final void v() {
      if (DebugLog.DEBUG) {
         StringBuilder sb = new StringBuilder();
         sb.append("v() CALLED thread=").append(Thread.currentThread().getName());
         sb.append(" aa=").append(aa()).append(" cg=").append(cg());
         sb.append(" hb=").append(hb).append(" cn=").append(cn).append(" hx=").append(hx).append(" ih=").append(ih);
         sb.append(" isItemPick=").append(phong2.isItemPick).append(" isItemDel=").append(phong2.isItemDel);
         sb.append("\n  super.a=").append(super.a == this.ka ? "ka" : (super.a == null ? "null" : super.a.toString()));
         sb.append(" super.b=").append(super.b == null ? "null" : super.b.toString());
         StackTraceElement[] st = Thread.currentThread().getStackTrace();
         int lim = Math.min(st.length, 10);
         for (int i = 2; i < lim; i++) sb.append("\n  at ").append(st[i]);
         DebugLog.log("V-CALL", sb.toString());
      }
      if (Char.getMyChar().arrItemBag != null) {
         int var10001;
         int var1;
         if ((hz || ii) && bz != null) {
            for(var1 = 0; var1 < bz.length; ++var1) {
               if (bz[var1] != null) {
                  var10001 = bz[var1].indexUI;
                  Char.getMyChar().arrItemBag[var10001] = bz[var1];
                  bz[var1] = null;
               }
            }
         }

         if (hw) {
            if (ci != null) {
               Char.getMyChar().arrItemBag[ci.indexUI] = ci;
               ci = null;
            }

            if (ca != null) {
               for(var1 = 0; var1 < ca.length; ++var1) {
                  if (ca[var1] != null) {
                     var10001 = ca[var1].indexUI;
                     Char.getMyChar().arrItemBag[var10001] = ca[var1];
                     ca[var1] = null;
                  }
               }
            }
         }

         if (im) {
            if (ci != null) {
               Char.getMyChar().arrItemBag[ci.indexUI] = ci;
               ci = null;
            }

            if (cj != null) {
               Char.getMyChar().arrItemBag[cj.indexUI] = cj;
               cj = null;
            }

            if (ca != null) {
               for(var1 = 0; var1 < ca.length; ++var1) {
                  if (ca[var1] != null) {
                     var10001 = ca[var1].indexUI;
                     Char.getMyChar().arrItemBag[var10001] = ca[var1];
                     ca[var1] = null;
                  }
               }
            }
         }

         if (iq && ca != null) {
            for(var1 = 0; var1 < ca.length; ++var1) {
               if (ca[var1] != null) {
                  var10001 = ca[var1].indexUI;
                  Char.getMyChar().arrItemBag[var10001] = ca[var1];
                  ca[var1] = null;
               }
            }
         }

         if (cn && ck != null) {
            Char.getMyChar().arrItemBag[ck.indexUI] = ck;
            ck = null;
         }

         if (hx && ce != null) {
            for(var1 = 0; var1 < ce.length; ++var1) {
               if (ce[var1] != null) {
                  var10001 = ce[var1].indexUI;
                  Char.getMyChar().arrItemBag[var10001] = ce[var1];
                  ce[var1] = null;
               }
            }
         }

         if (ib || ik || ij || il || ir) {
            if (cj != null) {
               Char.getMyChar().arrItemBag[cj.indexUI] = cj;
               cj = null;
            }

            if (cb != null) {
               for(var1 = 0; var1 < cb.length; ++var1) {
                  if (cb[var1] != null) {
                     if (ij || ik || il || ir) {
                        var10001 = cb[var1].indexUI;
                        Char.getMyChar().arrItemBag[var10001] = cb[var1];
                     }

                     cb[var1] = null;
                  }
               }
            }
         }

         if (iq && cb != null) {
            for(var1 = 0; var1 < cb.length; ++var1) {
               if (cb[var1] != null) {
                  var10001 = cb[var1].indexUI;
                  Char.getMyChar().arrItemBag[var10001] = cb[var1];
                  cb[var1] = null;
               }
            }
         }

         if (cs) {
            InfoDlg.b();
            if (this.dj > 0) {
               Char var10000 = Char.getMyChar();
               var10000.xu += this.dj;
            }

            if (cc != null) {
               for(var1 = 0; var1 < cc.length; ++var1) {
                  if (cc[var1] != null) {
                     var10001 = cc[var1].indexUI;
                     Char.getMyChar().arrItemBag[var10001] = cc[var1];
                     cc[var1] = null;
                  }
               }
            }

            if (cd != null) {
               for(var1 = 0; var1 < cd.length; ++var1) {
                  cd[var1] = null;
               }
            }
         }

         if ((in || io) && cj != null) {
            Char.getMyChar().arrItemBag[cj.indexUI] = cj;
            cj = null;
         }
      }

      if (ct || phong2.isItemDel || phong2.isItemPick) {
         phong.save_auto();
      }

      if (cs) {
         Service.gI().i();
      }

      GameCanvas.af.a = false;
      ChatTextField var2;
      (var2 = ChatTextField.a()).a.a("");
      var2.b = false;
      ChatTextField.a().f = null;
      if (!GameCanvas.g) {
         ha = false;
      }

      phong2.isItemDel = false;
      phong2.isItemPick = false;
      cm = false;
      hy = false;
      this.ja = false;
      id = false;
      ct = false;
      cr = false;
      cq = false;
      gv = false;
      gw = false;
      cu = false;
      ie = false;
      ig = false;
      ifa = false;
      ic = false;
      gx = false;
      cp = false;
      ih = false;
      gy = false;
      gu = false;
      gz = false;
      co = false;
      ip = false;
      this.dh = 0;
      hb = false;
      hc = false;
      hd = false;
      he = false;
      hf = false;
      hg = false;
      hh = false;
      hi = false;
      hj = false;
      hk = false;
      hl = false;
      hm = false;
      hn = false;
      ho = false;
      hp = false;
      hq = false;
      hr = false;
      hs = false;
      ht = false;
      hu = false;
      hv = false;
      hw = false;
      cn = false;
      hx = false;
      ik = false;
      ij = false;
      ib = false;
      cs = false;
      ii = false;
      hz = false;
      ia = false;
      im = false;
      il = false;
      ir = false;
      iq = false;
      in = false;
      io = false;
      aw = 0;
      indexSelect = 0;
      this.iz = -1;
      av = -1;
      gm = 0;
      indexTitle = 0;
      this.dh = this.di = 0;
      super.a = this.ka;
      super.c = this.ge;
      this.jw = this.jx = null;
      super.b = null;
      if (Char.getMyChar().cHP <= 0 || Char.getMyChar().statusMe == 14 || Char.getMyChar().statusMe == 5) {
         if (GameCanvas.i) {
            this.fj.a = "";
         }

         super.b = this.fj;
      }

      ba.a();
   }

   public final void a(int var1) {
      if (this.jd != null && this.jd.e) {
         this.jd.a(var1);
      }

      super.a(var1);
   }

   public final void e() {
      // Nút đổi tab — check touch (chỉ khi menu chưa mở)
      if (!GameCanvas.af.a && btnDoiTab != null && btnDoiTab.f > 0 && btnDoiTab.b()) {
         GameCanvas.q = false;
         GameCanvas.r = false;
         GameCanvas.instance.a(13000712, (Object)null);
         return;
      }
      // Shinwa tab arrow click — fire EARLY trước mọi touch consumer khác.
      // Pattern giống Goosho header: hitbox 42px wide quanh mỗi arrow, yêu cầu q=true (tap).
      // Drag > 10px sẽ làm q=false → không trigger → user drag info panel an toàn.
      if (GameCanvas.g && ih && !GameCanvas.af.a && GameCanvas.aj == null
            && GameCanvas.r && GameCanvas.q) {
         int titleW = mFont.o.a(TextGame.qn[aw]);
         // Left arrow: center ~k - titleW/2 - 22, hitbox 42 wide
         if (GameCanvas.b(k - titleW / 2 - 38, fd, 42, this.pb + 18)) {
            this.shinwaChangeTab(-1);
            GameCanvas.r = false;
            GameCanvas.q = false;
            return;
         }
         // Right arrow: center ~k + titleW/2 + 20, hitbox 42 wide
         if (GameCanvas.b(k + titleW / 2 + 2, fd, 42, this.pb + 18)) {
            this.shinwaChangeTab(1);
            GameCanvas.r = false;
            GameCanvas.q = false;
            return;
         }
      }
      if (!GameCanvas.af.a) {
         if (!InfoDlg.c) {
            boolean var3;
            int var4;
            int var5;
            int var7;
            int var10001;
            if (GameCanvas.g && !ChatTextField.a().b && !GameCanvas.af.a) {
               GameScr var2 = this;
               var4 = -1;
               if (GameCanvas.q) {
                  for(var5 = 0; var5 < var2.ju.length; ++var5) {
                     if (GameCanvas.b(var2.ju[var5], var2.jv[var5], 100, 12) && GameCanvas.r) {
                        var4 = var5;
                        break;
                     }
                  }
               }

               if (var4 != -1 && !cg() && !aa() && !ci()) {
                  if (var4 != 0) {
                     if (ChatManager.f) {
                        ChatManager.d().a(1);
                     } else if (ChatManager.e) {
                        ChatManager.d().a(3);
                     }

                     this.fk();
                     this.ju[1] = this.jv[1] = -1;
                  } else if (ChatManager.d().g.size() > 0) {
                     ChatManager var10 = ChatManager.d();
                     var5 = 3;

                     label1516:
                     while(true) {
                        if (var5 >= var10.a.size()) {
                           var10001 = -1;
                           break;
                        }

                        ChatTab var6 = (ChatTab)var10.a.elementAt(var5);

                        for(var7 = 0; var7 < var10.g.size(); ++var7) {
                           if (var6.b.equals(var10.g.elementAt(var7).toString())) {
                              var10001 = var5;
                              break label1516;
                           }
                        }

                        ++var5;
                     }

                     ChatManager.d().a(var10001);
                     this.fk();
                     this.ju[0] = this.jv[0] = -1;
                  }
               }

               var3 = false;
               mScreen.g = -1;
               if (GameCanvas.b(TileMap.posMiniMapX, TileMap.posMiniMapY, TileMap.wMiniMap, TileMap.hMiniMap) && GameCanvas.q && GameCanvas.r) {
                  bo();
                  var3 = true;
               }

               if (GameCanvas.g && (!GameCanvas.af.a || !GameCanvas.i) && GameCanvas.aj == null && ChatPopup.f == null && !GameCanvas.af.a && !cg()) {
                  if (GameCanvas.b(kq, kr, 34, 34)) {
                     mScreen.g = 15;
                     if (GameCanvas.q && GameCanvas.r) {
                        ChatTextField.a().a(TextGame.oi[0]);
                        var3 = true;
                        GameCanvas.r = false;
                        GameCanvas.q = false;
                     }
                  }

                  if (!this.ch()) {
                     if (!Char.getMyChar().d) {
                        if (GameCanvas.isAnalog) {
                           if (gamePad == null) {
                              gamePad = new GamePad();
                           }
                           gamePad.update();
                           if (GameCanvas.o[1] || GameCanvas.o[2] || GameCanvas.o[3] || GameCanvas.o[4] || GameCanvas.o[6]) {
                              this.bq();
                              var3 = true;
                           }
                        } else {
                           if (GameCanvas.b(kw, kx, 34, 34)) {
                              mScreen.g = 3;
                              GameCanvas.o[2] = true;
                              this.bq();
                              var3 = true;
                           } else if (GameCanvas.p) {
                              GameCanvas.o[2] = false;
                           }

                           if (GameCanvas.b(kw - 30, kx, 30, 34)) {
                              GameCanvas.o[1] = true;
                              this.bq();
                              var3 = true;
                           } else if (GameCanvas.p) {
                              GameCanvas.o[1] = false;
                           }

                           if (GameCanvas.b(kw + 34, kx, 30, 34)) {
                              GameCanvas.o[3] = true;
                              this.bq();
                              var3 = true;
                           } else if (GameCanvas.p) {
                              GameCanvas.o[3] = false;
                           }

                           if (GameCanvas.b(ko, kp, 34, 34)) {
                              mScreen.g = 4;
                              GameCanvas.o[4] = true;
                              this.bq();
                              var3 = true;
                           } else if (GameCanvas.p) {
                              GameCanvas.o[4] = false;
                           }

                           if (GameCanvas.b(ks - 5, kt, 40, 34)) {
                              mScreen.g = 6;
                              GameCanvas.o[6] = true;
                              this.bq();
                              var3 = true;
                           } else if (GameCanvas.p) {
                              GameCanvas.o[6] = false;
                           }
                        }

                        if (GameCanvas.b(ku, kv, 54, 54)) {
                           GameCanvas.o[5] = true;
                           mScreen.g = 5;
                           if (GameCanvas.r) {
                              GameCanvas.n[5] = true;
                              var3 = true;
                           }
                        }
                     } else {
                        if (GameCanvas.c(ko, kp, 34, 34) && GameCanvas.r) {
                           this.e((byte)0);
                           GameCanvas.i();
                        }

                        if (GameCanvas.c(kw, kx, 34, 34) && GameCanvas.r) {
                           this.e((byte)1);
                           GameCanvas.i();
                        }

                        if (GameCanvas.c(ks - 5, kt, 40, 34) && GameCanvas.r) {
                           this.e((byte)2);
                           GameCanvas.i();
                        }
                     }

                     if (Char.getMyChar().ctaskId > 1) {
                        if (GameCanvas.b(la, lb, 34, 34)) {
                           mScreen.g = 11;
                           if (GameCanvas.q && GameCanvas.r) {
                              GameCanvas.n[11] = true;
                              var3 = true;
                           }
                        }

                        if (GameCanvas.b(ky, kz, 34, 34)) {
                           mScreen.g = 10;
                           if (GameCanvas.q && GameCanvas.r) {
                              GameCanvas.n[10] = true;
                              var3 = true;
                           }
                        }

                        if (GameCanvas.b(lc, ld, 34, 34)) {
                           mScreen.g = 13;
                           if (GameCanvas.q && GameCanvas.r) {
                              GameCanvas.r = false;
                              GameCanvas.q = false;
                              Char.getMyChar().u();
                              var3 = true;
                           }
                        }
                     }

                     if (Char.getMyChar().vSkill.size() >= 2 && (GameCanvas.b(lg + le[0], lf[0], jz.length * 30, 30) || !GameCanvas.h && GameCanvas.b(lg + le[0], lf[0], 30, jz.length * 25)) && GameCanvas.q && GameCanvas.r) {
                        if (!GameCanvas.h) {
                           var4 = (GameCanvas.v - (lh + lf[0])) / 25;
                        } else {
                           var4 = (GameCanvas.u - (lg + le[0])) / 30;
                        }

                        this.kj = var4;
                        if (indexSelect < 0) {
                           indexSelect = 0;
                        }

                        if (this.kj > jz.length - 1) {
                           this.kj = jz.length - 1;
                        }

                        var3 = true;
                        Skill var12 = jz[this.kj];
                        this.a(var12, false, true);
                        this.gi = true;
                     }

                     if (GameCanvas.r) {
                        GameCanvas.o[1] = false;
                        GameCanvas.o[2] = false;
                        GameCanvas.o[3] = false;
                        GameCanvas.o[4] = false;
                        GameCanvas.o[6] = false;
                     }

                     if (!var3 && !cg() && !aa() && !ci() && GameCanvas.q) {
                        var4 = 0;

                        label1464:
                        while(true) {
                           if (var4 >= vMob.size()) {
                              for(var4 = 0; var4 < vNpc.size(); ++var4) {
                                 Npc var16;
                                 if ((var16 = (Npc)vNpc.elementAt(var4)).q() && GameCanvas.a(var16.cx1 - var16.bf / 2, var16.cy1 - var16.bg, var16.bf, var16.bg) && GameCanvas.r) {
                                    Char.getMyChar().mobFocus = null;
                                    Char.getMyChar().v();
                                    Char.getMyChar().npcFocus = var16;
                                    Char.getMyChar().charFocus = null;
                                    Char.getMyChar().itemFocus = null;
                                    Char.fg = true;
                                    break label1464;
                                 }
                              }

                              for(var4 = 0; var4 < vCharInMap.size(); ++var4) {
                                 Char var17;
                                 if ((var17 = (Char)vCharInMap.elementAt(var4)).q() && !var17.ab() && GameCanvas.a(var17.cx1 - var17.bf / 2, var17.cy1 - var17.bg, var17.bf, var17.bg) && GameCanvas.r) {
                                    Char.getMyChar().mobFocus = null;
                                    Char.getMyChar().v();
                                    Char.getMyChar().charFocus = var17;
                                    Char.getMyChar().itemFocus = null;
                                    Char.fg = true;
                                    break label1464;
                                 }
                              }

                              var4 = 0;

                              while(true) {
                                 if (var4 >= vItemMap.size()) {
                                    break label1464;
                                 }

                                 ItemMap var18;
                                 if (GameCanvas.a((var18 = (ItemMap)vItemMap.elementAt(var4)).x - 12, var18.y - 24, 24, 24) && GameCanvas.r) {
                                    Char.getMyChar().mobFocus = null;
                                    Char.getMyChar().v();
                                    Char.getMyChar().charFocus = null;
                                    Char.getMyChar().itemFocus = var18;
                                    Char.fg = true;
                                    break label1464;
                                 }

                                 ++var4;
                              }
                           }

                           Mob var14;
                           if ((var14 = (Mob)vMob.elementAt(var4)).d() && GameCanvas.a(var14.x1 - var14.k / 2, var14.y1 - var14.l, var14.k, var14.l) && GameCanvas.r) {
                              Char.getMyChar().mobFocus = var14;
                              Char.getMyChar().v();
                              Char.getMyChar().charFocus = null;
                              Char.getMyChar().itemFocus = null;
                              Char.fg = true;
                              break;
                           }

                           ++var4;
                        }
                     }
                  }
               }
            }

            if (TileMap.mapID != 130 && !br()) {
               label1651: {
                  long var19 = System.currentTimeMillis();
                  if (GameCanvas.n[2] || GameCanvas.n[4] || GameCanvas.n[6] || GameCanvas.n[1] || GameCanvas.n[3]) {
                     fb = 0;
                     if (this.fc) {
                        Char.getMyChar().ei = false;
                        this.fc = false;
                     }
                  }

                  if (GameCanvas.n[5] && !cg()) {
                     if (fb == 0) {
                        if (var19 - this.kh < 800L && (Char.getMyChar().myskill == null || Char.getMyChar().cMP >= Char.getMyChar().myskill.manaUse) && Char.getMyChar().myskill != null && (Char.getMyChar().myskill.template.maxPoint <= 0 || Char.getMyChar().myskill.point != 0) && Char.getMyChar().arrItemBody[1] != null && Char.getMyChar().mobFocus != null) {
                           fb = 10;
                           GameCanvas.n[5] = false;
                        }
                     } else {
                        if (!this.fc && Char.getMyChar().statusMe != 14) {
                           this.fc = !this.fc;
                           Char.getMyChar().ei = !Char.getMyChar().ei;
                           this.kh = var19;
                           break label1651;
                        }

                        fb = 0;
                        if (this.fc) {
                           Char.getMyChar().ei = false;
                           this.fc = false;
                        }

                        GameCanvas.n[4] = GameCanvas.n[6] = false;
                     }

                     this.kh = var19;
                  }

                  if (GameCanvas.w % 10 == 0 && fb > 0 && (Char.getMyChar().mobFocus != null || Char.getMyChar().itemFocus != null)) {
                     this.b(true);
                  }

                  if (fb > 1) {
                     --fb;
                  }
               }
            }

            if (GameCanvas.g) {
               if (GameCanvas.p && !GameCanvas.r && GameCanvas.b(lc, ld, 34, 34) && !ic && GameCanvas.q && GameCanvas.g()) {
                  this.bk();
               }
            } else if (GameCanvas.o[13] && !ic && GameCanvas.g()) {
               this.bk();
            }

            if (ChatPopup.f != null) {
               Command1 var1 = ChatPopup.f.e;
               if ((GameCanvas.n[5] || mScreen.a(var1)) && var1 != null) {
                  GameCanvas.r = false;
                  GameCanvas.n[5] = false;
                  mScreen.g = -1;
                  if (var1 != null) {
                     var1.a();
                  }
               }
            } else if (!ChatTextField.a().b) {
               if (mScreen.g != -1 && GameCanvas.b(ko, kp, 34, 34)) {
                  GameCanvas.r = false;
               }

               if (mScreen.g != -1 && GameCanvas.b(ks, kt, 34, 34)) {
                  GameCanvas.r = false;
               }

               if (mScreen.g != -1 && GameCanvas.b(kw, kx, 34, 34)) {
                  GameCanvas.r = false;
               }

               if ((GameCanvas.n[12] || mScreen.a(GameCanvas.currentScreen.a)) && super.a != null) {
                  GameCanvas.r = false;
                  GameCanvas.q = false;
                  GameCanvas.n[12] = false;
                  mScreen.g = -1;
                  if (super.a != null) {
                     super.a.a();
                  }
               }

               if ((GameCanvas.n[13] || mScreen.a(GameCanvas.currentScreen.c)) && super.c != null) {
                  GameCanvas.r = false;
                  GameCanvas.q = false;
                  GameCanvas.n[13] = false;
                  mScreen.g = -1;
                  if (super.c != null) {
                     super.c.a();
                  }
               }

               if ((GameCanvas.n[5] || mScreen.a(GameCanvas.currentScreen.b)) && super.b != null) {
                  GameCanvas.r = false;
                  GameCanvas.n[5] = false;
                  mScreen.g = -1;
                  if (super.b != null) {
                     super.b.a();
                  }
               }
            } else {
               if (ChatTextField.a().d != null && (GameCanvas.n[12] || mScreen.a(ChatTextField.a().d)) && ChatTextField.a().d != null) {
                  ChatTextField.a().d.a();
               }

               if (ChatTextField.a().e != null && (GameCanvas.n[13] || mScreen.a(ChatTextField.a().e)) && ChatTextField.a().e != null) {
                  ChatTextField.a().e.a();
               }

               if (ChatTextField.a().f != null && (GameCanvas.n[5] || mScreen.a(ChatTextField.a().f)) && ChatTextField.a().f != null) {
                  ChatTextField.a().f.a();
               }
            }

            ScrollResult var20;
            if (id && GameCanvas.aj == null) {
               var3 = false;
               if (GameCanvas.n[4]) {
                  if (--indexSelect < 0) {
                     indexSelect = this.iu.length - 1;
                  }

                  var3 = true;
               } else if (GameCanvas.n[6]) {
                  if (++indexSelect >= this.iu.length) {
                     indexSelect = 0;
                  }

                  var3 = true;
               } else if (GameCanvas.n[8]) {
                  if (indexSelect + this.it <= this.iu.length - 1) {
                     indexSelect += this.it;
                  }

                  var3 = true;
               } else if (GameCanvas.n[2]) {
                  if (indexSelect - this.it >= 0) {
                     indexSelect -= this.it;
                  }

                  var3 = true;
               }

               if (var3) {
                  ba.a(indexSelect / oj * ba.h);
                  GameCanvas.i();
                  GameCanvas.h();
               }

               if (GameCanvas.g && ((var20 = ba.b()).a || var20.c)) {
                  indexSelect = var20.b;
               }
            }

            if (gu || gw || gx || cp || gz || ic || gy || ih) {
               if (ih) {
                  ScrollResult var21;
                  if (ih && ((var21 = ba.b()).a || var21.c)) {
                     if ((indexSelect = var21.b) >= cf.length) {
                        indexSelect = -1;
                     }

                     if (indexSelect >= 0) {
                        indexTitle = 1;
                     }

                     this.ac();
                  }
               } else {
                  label1643: {
                     if (gw) {
                        if (vParty.size() == 0) {
                           break label1643;
                        }

                        if (GameCanvas.n[8]) {
                           if (++av >= vParty.size()) {
                              av = vParty.size() - 1;
                           }

                           ba.a(av * ba.h);
                        } else if (GameCanvas.n[2]) {
                           if (--av < 0) {
                              av = 0;
                           }

                           ba.a(av * ba.h);
                        }

                        this.cf();
                     } else if (gx) {
                        if (GameCanvas.n[8]) {
                           if (++av >= vPtMap.size()) {
                              av = vPtMap.size() - 1;
                           }

                           ba.a(av * ba.h);
                        } else if (GameCanvas.n[2]) {
                           if (--av < 0) {
                              av = 0;
                           }

                           ba.a(av * ba.h);
                        }

                        this.s();
                     } else if (cp) {
                        if (GameCanvas.n[8]) {
                           if (++av >= gm) {
                              av = 0;
                           }

                           ba.a(av * ba.h);
                        } else if (GameCanvas.n[2]) {
                           if (--av < 0) {
                              av = gm - 1;
                           }

                           ba.a(av * ba.h);
                        }

                        this.ce();
                     } else if (gz) {
                        if (GameCanvas.n[8]) {
                           if (++av >= gm) {
                              av = 0;
                           }

                           ba.a(av * ba.h);
                        } else if (GameCanvas.n[2]) {
                           if (--av < 0) {
                              av = gm - 1;
                           }

                           ba.a(av * ba.h);
                        }

                        this.cd();
                     } else if (ic) {
                        if (GameCanvas.n[8]) {
                           if (++av >= vCharInMap.size()) {
                              av = vCharInMap.size() - 1;
                           }

                           ba.a(av * ba.h);
                        } else if (GameCanvas.n[2]) {
                           if (--av < 0) {
                              av = 0;
                           }

                           ba.a(av * ba.h);
                        }

                        if (this.dm > 0 && !GameCanvas.g) {
                           ba.a(av * ba.h);
                        }

                        this.ca();
                     } else if (gy) {
                        if (GameCanvas.n[8]) {
                           if (++av >= vList.size()) {
                              av = vList.size() - 1;
                           }

                           ba.a(av * ba.h);
                        } else if (GameCanvas.n[2]) {
                           if (--av < 0) {
                              av = 0;
                           }

                           ba.a(av * ba.h);
                        }

                        this.cc();
                     } else if (gu) {
                        if (GameCanvas.n[8]) {
                           if (++av >= vList.size()) {
                              av = vList.size() - 1;
                           }

                           ba.a(av * ba.h);
                        } else if (GameCanvas.n[2]) {
                           if (--av < 0) {
                              av = 0;
                           }

                           ba.a(av * ba.h);
                        }

                        this.cb();
                     }

                     if (GameCanvas.g && GameCanvas.aj == null && !GameCanvas.af.a) {
                        MyVector var22 = null;
                        if (gw) {
                           var22 = vParty;
                        } else if (cp) {
                           var22 = vFriend;
                        } else if (gz) {
                           var22 = vEnemies;
                        } else if (gx) {
                           var22 = vPtMap;
                        } else if (ic) {
                           var22 = vCharInMap;
                        } else if (gy) {
                           var22 = vList;
                        } else if (gu) {
                           var22 = vList;
                        }

                        if ((var20 = ba.b()).a || var20.c) {
                           if ((av = var20.b) >= var22.size()) {
                              av = -1;
                           }

                           if (gw) {
                              this.cf();
                           } else if (cp) {
                              this.ce();
                           } else if (gz) {
                              this.cd();
                           } else if (ic) {
                              this.ca();
                           } else if (gy) {
                              this.cc();
                           } else if (gu) {
                              this.cb();
                           }
                        }
                     }

                     GameCanvas.i();
                     GameCanvas.h();
                  }
               }
            }

            this.ab();
            this.bv();
            int var8;
            if (ie) {
               if (indexTitle == 0) {
                  if (GameCanvas.n[8]) {
                     if (Char.be == null) {
                        indexTitle = 0;
                     } else {
                        indexTitle = 1;
                     }

                     indexSelect = 0;
                     av = -1;
                     if (aw == 0) {
                        indexSelect = Char.be.e;
                     }

                     ba.a();
                     go.a();
                  }

                  if (GameCanvas.n[4]) {
                     indexSelect = 0;
                     av = -1;
                     --aw;
                     ba.a();
                     go.a();
                     if (aw < 0) {
                        aw = TextGame.mh.length - 1;
                     }

                     if (aw >= TextGame.mh.length) {
                        aw = 0;
                     }

                     if (aw == 1 && ifa) {
                        Service.gI().x();
                        ifa = false;
                     } else if (aw == 2) {
                        Service.gI().y();
                     } else if (aw == 3) {
                        Service.gI().z();
                     } else if (aw == 4) {
                        Service.gI().y();
                     }

                     b(175, 200);
                  }

                  if (GameCanvas.n[6]) {
                     indexSelect = 0;
                     av = -1;
                     ++aw;
                     ba.a();
                     go.a();
                     if (aw < 0) {
                        aw = TextGame.mh.length - 1;
                     }

                     if (aw >= TextGame.mh.length) {
                        aw = 0;
                     }

                     if (aw == 1 && ifa) {
                        Service.gI().x();
                        ifa = false;
                     } else if (aw == 2) {
                        Service.gI().y();
                     } else if (aw == 3) {
                        Service.gI().z();
                     } else if (aw == 4) {
                        Service.gI().y();
                     }

                     b(175, 200);
                  }

                  this.bx();
               } else if (cq) {
                  if (GameCanvas.n[2]) {
                     if (--av < 0) {
                        av = gm - 1;
                     }

                     go.a(av * go.h);
                  } else if (GameCanvas.n[8]) {
                     if (++av >= gm) {
                        av = 0;
                     }

                     go.a(av * go.h);
                  }
               } else {
                  if (av < 0) {
                     av = 0;
                  }

                  if (aw == 2) {
                     if (Char.be != null && Char.be.p != null) {
                        if (GameCanvas.n[4]) {
                           if (--indexSelect < 0) {
                              indexSelect = Char.be.p.length - 1;
                           }
                        } else if (GameCanvas.n[6]) {
                           if (++indexSelect >= Char.be.p.length) {
                              indexSelect = 0;
                           }
                        } else if (GameCanvas.n[8]) {
                           if (indexSelect + oj <= Char.be.p.length - 1) {
                              indexSelect += oj;
                           }
                        } else if (GameCanvas.n[2]) {
                           if (indexSelect >= 0 && indexSelect < oj) {
                              indexTitle = 0;
                              indexSelect = 0;
                           } else if (indexSelect - oj >= 0) {
                              indexSelect -= oj;
                           }
                        }

                        ba.a(indexSelect / oj * ba.h);
                     }
                  } else if (aw == 0 && indexTitle == 1) {
                     if (GameCanvas.n[8]) {
                        ++indexTitle;
                     } else if (GameCanvas.n[2]) {
                        --indexTitle;
                     }
                  } else if (aw == 4) {
                     if (GameCanvas.n[2]) {
                        if (av == 0) {
                           --indexTitle;
                           av = -1;
                        } else {
                           --av;
                        }

                        ba.a(av * ba.h);
                     } else if (GameCanvas.n[8]) {
                        if (++av >= gm) {
                           av = 0;
                        }

                        ba.a(av * ba.h);
                     } else if (GameCanvas.n[4]) {
                        --this.pw;
                        if (this.pw < 0) {
                           this.pw = 0;
                        }
                     } else if (GameCanvas.n[6]) {
                        ++this.pw;
                        if (this.pw > this.px.size() - 1) {
                           this.pw = (byte)(this.px.size() - 1);
                        }
                     }
                  } else if (GameCanvas.n[2]) {
                     if (av == 0) {
                        --indexTitle;
                        av = -1;
                     } else {
                        --av;
                     }

                     ba.a(av * ba.h);
                     if (aw == 1 && ifa) {
                        Service.gI().x();
                        ifa = false;
                     }
                  } else if (GameCanvas.n[8]) {
                     if (++av >= gm) {
                        av = 0;
                     }

                     ba.a(av * ba.h);
                  }

                  this.bx();
               }

               if (GameCanvas.g && GameCanvas.aj == null && !GameCanvas.af.a) {
                  label1617: {
                     if (GameCanvas.r) {
                        if (GameCanvas.b(fe, fd, ff, this.pb) && (!cq || GameCanvas.aa >= 320) && GameCanvas.q) {
                           if (GameCanvas.b(k - 90, fd + 5, 60, 40)) {
                              indexSelect = 0;
                              --aw;
                              av = 0;
                           }

                           if (GameCanvas.b(k + 20, fd + 5, 60, 40)) {
                              indexSelect = 0;
                              ++aw;
                              av = 0;
                           }

                           cq = false;
                           ba.a();
                           go.a();
                           if (aw < 0) {
                              aw = TextGame.mh.length - 1;
                           }

                           if (aw > TextGame.mh.length - 1) {
                              aw = 0;
                           }

                           indexTitle = 1;
                           if (aw == 1 && ifa) {
                              Service.gI().x();
                              ifa = false;
                           } else if (aw == 2 && Char.be != null && Char.be.p == null) {
                              Service.gI().y();
                           }

                           if (aw == 3) {
                              Service.gI().z();
                           }

                           if (aw == 4) {
                              Service.gI().y();
                           }

                           b(175, 200);
                           this.bx();
                        }

                        if (aw == 4) {
                           var4 = this.qg - this.qi / 2;
                           var5 = this.qh - this.qi / 2;
                           var10001 = (this.qi + 5) * this.px.size();
                           var7 = this.qi;
                           if (GameCanvas.b(var4, var5, var10001, var7) && (var8 = (GameCanvas.s - var4) / (this.qi + 5)) >= 0 && var8 < this.px.size()) {
                              this.pw = (byte)var8;
                           }
                        }
                     }

                     if (cq) {
                        if ((var20 = go.b()).a || var20.c) {
                           av = var20.b;
                           indexTitle = 1;
                        }

                        if (GameCanvas.i) {
                           break label1617;
                        }
                     }

                     if (aw == 2) {
                        if ((var20 = ba.b()).a || var20.c) {
                           indexSelect = var20.b;
                           indexTitle = 1;
                           this.b(1509, (Object)null);
                        }
                     } else if (aw == 0 && GameCanvas.b(fe + 18, fd + 32, 5 * indexSize, indexSize) && GameCanvas.r && GameCanvas.q) {
                        if (Char.be != null) {
                           indexSelect = Char.be.e;
                           indexTitle = 1;
                        }
                     } else if (aw != 0 && aw != 3) {
                        if (aw == 1 && vClan.size() != 0 && ((var20 = ba.b()).a || var20.c)) {
                           av = var20.b;
                           this.ac();
                        }
                     } else if (!cq && ((var20 = ba.b()).a || var20.c)) {
                        av = var20.b;
                        indexTitle = aw == 0 ? 2 : 1;
                        if (var20.c) {
                           ba.a(av * ba.h);
                        }
                     }
                  }
               }

               GameCanvas.i();
               GameCanvas.h();
            }

            if (gv) {
               if (indexTitle == 0) {
                  if (indexTitle == 0 && GameCanvas.n[8]) {
                     indexTitle = 1;
                     av = -1;
                     ba.a();
                     go.a();
                  }
               } else {
                  if (av < 0) {
                     av = 0;
                  }

                  if (GameCanvas.n[2]) {
                     if (av == 0) {
                        --indexTitle;
                        av = -1;
                     } else {
                        --av;
                     }

                     ba.a(av * ba.h);
                  } else if (GameCanvas.n[8]) {
                     if (++av >= gm) {
                        av = 0;
                     }

                     ba.a(av * ba.h);
                  }
               }

               ScrollResult var9;
               if (GameCanvas.g && ((var9 = ba.b()).a || var9.c)) {
                  av = var9.b;
                  indexTitle = 1;
               }
            }

            this.by();
            this.bz();
            if (Char.getMyChar().el != null) {
               for(var8 = 0; var8 < GameCanvas.n.length; ++var8) {
                  if (GameCanvas.n[var8]) {
                     Char.getMyChar().el = null;
                     break;
                  }
               }
            }

            if (ChatTextField.a().b && GameCanvas.au != 0) {
               ChatTextField var24 = ChatTextField.a();
               int var23 = GameCanvas.au;
               if (var24.b) {
                  if (com.badlogic.gdx.Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.Desktop) {
                     var24.a.e(var23);
                  } else {
                     var24.a.a(var23);
                  }
               }

               var24.e.a = TextGame.ah;

               GameCanvas.au = 0;
            }

            if (this.ja) {
               GameCanvas.i();
               GameCanvas.h();
            } else if (!GameCanvas.af.a && !ci() && !Char.eh) {
               if (GameCanvas.n[10]) {
                  GameCanvas.n[10] = false;
                  x();
                  GameCanvas.h();
               }

               if (GameCanvas.n[11]) {
                  GameCanvas.n[11] = false;
                  w();
                  GameCanvas.h();
               }

               if (GameCanvas.au != 0 && TField.h) {
                  if (GameCanvas.au == 32) {
                     x();
                     GameCanvas.au = 0;
                     GameCanvas.h();
                  } else if (GameCanvas.au == 64) {
                     w();
                     GameCanvas.au = 0;
                     GameCanvas.h();
                  } else if (GameCanvas.au == 48) {
                     w();
                     GameCanvas.au = 0;
                     GameCanvas.h();
                  } else if (GameCanvas.au == 63) {
                     w();
                     GameCanvas.au = 0;
                     GameCanvas.h();
                  }
               }

               if (Char.getMyChar().ex == null) {
                  if (!Char.getMyChar().d) {
                     if (Char.getMyChar().statusMe == 1) {
                        if (GameCanvas.n[5]) {
                           GameCanvas.n[5] = false;
                           this.b(false);
                        } else if (GameCanvas.o[2]) {
                           if (!Char.getMyChar().ei && !Char.getMyChar().ek) {
                              h(0);
                           }
                        } else if (GameCanvas.o[1]) {
                           Char.getMyChar().cdir = -1;
                           if (!Char.getMyChar().ei && !Char.getMyChar().ek) {
                              h(-4);
                           }
                        } else if (GameCanvas.o[3]) {
                           Char.getMyChar().cdir = 1;
                           if (!Char.getMyChar().ei && !Char.getMyChar().ek) {
                              h(4);
                           }
                        } else if (GameCanvas.o[4]) {
                           Char.getMyChar().bl = false;
                           if (Char.getMyChar().cdir == 1) {
                              Char.getMyChar().cdir = -1;
                           } else if (!Char.getMyChar().ei && !Char.getMyChar().ek) {
                              Char.getMyChar().statusMe = 2;
                              Char.getMyChar().k = -Char.getMyChar().b();
                           }
                        } else if (GameCanvas.o[6]) {
                           Char.getMyChar().bl = false;
                           if (Char.getMyChar().cdir == -1) {
                              Char.getMyChar().cdir = 1;
                           } else if (!Char.getMyChar().ei && !Char.getMyChar().ek) {
                              Char.getMyChar().statusMe = 2;
                              Char.getMyChar().k = Char.getMyChar().b();
                           }
                        }
                     } else if (Char.getMyChar().statusMe == 2) {
                        if (GameCanvas.n[5]) {
                           GameCanvas.n[5] = false;
                           this.b(false);
                        } else if (GameCanvas.o[2]) {
                           Char.getMyChar().l = Char.getMyChar().bj ? -10 : -8;
                           Char.getMyChar().statusMe = 3;
                           Char.getMyChar().m = 0;
                        } else if (GameCanvas.o[1]) {
                           Char.getMyChar().cdir = -1;
                           Char.getMyChar().l = Char.getMyChar().bj ? -10 : -8;
                           Char.getMyChar().k = -4;
                           Char.getMyChar().statusMe = 3;
                           Char.getMyChar().m = 0;
                        } else if (GameCanvas.o[3]) {
                           Char.getMyChar().cdir = 1;
                           Char.getMyChar().l = Char.getMyChar().bj ? -10 : -8;
                           Char.getMyChar().k = 4;
                           Char.getMyChar().statusMe = 3;
                           Char.getMyChar().m = 0;
                        } else {
                           Char var25;
                           if (GameCanvas.o[4]) {
                              if (Char.getMyChar().cdir == 1) {
                                 Char.getMyChar().cdir = -1;
                              } else {
                                 var25 = Char.getMyChar();
                                 var10001 = -Char.getMyChar().b();
                                 Char.getMyChar();
                                 var25.k = var10001;
                              }
                           } else if (GameCanvas.o[6]) {
                              if (Char.getMyChar().cdir == -1) {
                                 Char.getMyChar().cdir = 1;
                              } else {
                                 var25 = Char.getMyChar();
                                 var10001 = Char.getMyChar().b();
                                 Char.getMyChar();
                                 var25.k = var10001;
                              }
                           }
                        }
                     } else if (Char.getMyChar().statusMe == 3) {
                        if (GameCanvas.n[5]) {
                           GameCanvas.n[5] = false;
                           this.b(false);
                        }

                        if (!GameCanvas.o[4] && !GameCanvas.o[1]) {
                           if (GameCanvas.o[6] || GameCanvas.o[3]) {
                              if (Char.getMyChar().cdir == -1) {
                                 Char.getMyChar().cdir = 1;
                              } else {
                                 Char.getMyChar().k = Char.getMyChar().b();
                              }
                           }
                        } else if (Char.getMyChar().cdir == 1) {
                           Char.getMyChar().cdir = -1;
                        } else {
                           Char.getMyChar().k = -Char.getMyChar().b();
                        }

                        if ((GameCanvas.o[2] || GameCanvas.o[1] || GameCanvas.o[3]) && Char.getMyChar().bj && Char.getMyChar().m == 0 && Char.getMyChar().l > -4) {
                           ++Char.getMyChar().m;
                           Char.getMyChar().l = -7;
                        }
                     } else if (Char.getMyChar().statusMe == 4) {
                        if (GameCanvas.n[5]) {
                           GameCanvas.n[5] = false;
                           this.b(false);
                        }

                        if (GameCanvas.n[2]) {
                           GameCanvas.h();
                        }

                        if (GameCanvas.o[4]) {
                           if (Char.getMyChar().cdir == 1) {
                              Char.getMyChar().cdir = -1;
                           } else {
                              Char.getMyChar().k = -Char.getMyChar().b();
                           }
                        } else if (GameCanvas.o[6]) {
                           if (Char.getMyChar().cdir == -1) {
                              Char.getMyChar().cdir = 1;
                           } else {
                              Char.getMyChar().k = Char.getMyChar().b();
                           }
                        }
                     } else if (Char.getMyChar().statusMe == 10) {
                        if (GameCanvas.n[5]) {
                           GameCanvas.n[5] = false;
                           this.b(false);
                        }

                        if (GameCanvas.o[2]) {
                           Char.getMyChar().l = -10;
                           Char.getMyChar().statusMe = 3;
                           Char.getMyChar().m = 0;
                        } else if (GameCanvas.o[4]) {
                           if (Char.getMyChar().cdir == 1) {
                              Char.getMyChar().cdir = -1;
                           } else {
                              Char.getMyChar().k = -5;
                           }
                        } else if (GameCanvas.o[6]) {
                           if (Char.getMyChar().cdir == -1) {
                              Char.getMyChar().cdir = 1;
                           } else {
                              Char.getMyChar().k = 5;
                           }
                        }
                     } else if (Char.getMyChar().statusMe == 7) {
                        if (GameCanvas.n[5]) {
                           GameCanvas.n[5] = false;
                        }

                        if (GameCanvas.o[4]) {
                           if (Char.getMyChar().cdir == 1) {
                              Char.getMyChar().cdir = -1;
                           } else {
                              Char.getMyChar().k = -Char.getMyChar().b() + 2;
                           }
                        } else if (GameCanvas.o[6]) {
                           if (Char.getMyChar().cdir == -1) {
                              Char.getMyChar().cdir = 1;
                           } else {
                              Char.getMyChar().k = Char.getMyChar().b() - 2;
                           }
                        }
                     } else if (Char.getMyChar().statusMe == 11) {
                        if (GameCanvas.n[5]) {
                           GameCanvas.n[5] = false;
                           this.b(false);
                        }

                        if (GameCanvas.o[2]) {
                           Char.getMyChar().l = -10;
                           Char.getMyChar().statusMe = 3;
                           Char.getMyChar().m = 0;
                        }
                     }

                     if (GameCanvas.n[8] && GameCanvas.au != 56) {
                        GameCanvas.n[8] = false;
                        this.bs();
                     }
                  } else {
                     this.hj();
                  }

                  if (GameCanvas.au != 0) {
                     if (TField.h) {
                        ChatTextField.a().a(GameCanvas.au, this, TextGame.oi[0]);
                     } else if (!GameCanvas.c) {
                        ChatTextField.a().a(GameCanvas.au, this, TextGame.oi[0]);
                     } else if (GameCanvas.au == 55) {
                        this.gi = true;
                        if (jy[0] != null) {
                           this.a(jy[0], true, true);
                        }
                     } else if (GameCanvas.au == 56) {
                        this.gi = true;
                        if (jy[1] != null) {
                           this.a(jy[1], true, true);
                        }
                     } else if (GameCanvas.au == 57) {
                        this.gi = true;
                        if (jy[2] != null) {
                           this.a(jy[2], true, true);
                        }
                     } else if (GameCanvas.au == 48) {
                        ChatTextField.a().a(TextGame.oi[0]);
                     }

                     GameCanvas.au = 0;
                  }
               }
            }
         }

         // Auto-focus chat khi auto đang chạy: block xử lý chat phía trên nằm trong
         // `if (ex == null && !d)` → đánh skill có ex != null → block bị skip → gõ phím
         // không lên chat. Block độc lập này đảm bảo phím chữ luôn mở chat trên map auto.
         if (GameCanvas.au >= 65 && GameCanvas.au <= 122
                 && !ChatTextField.a().b && !aa() && GameCanvas.aj == null
                 && ChatPopup.f == null && !GameCanvas.af.a) {
            ChatTextField.a().a(GameCanvas.au, this, TextGame.oi[0]);
            GameCanvas.au = 0;
         }

         GameCanvas.h();
      }

   }

   private void bq() {
      fb = 0;
      this.fc = Char.getMyChar().ei = false;
   }

   public static void w() {
      if (!Char.getMyChar().e(17)) {
         for(int var0 = 0; var0 < Char.getMyChar().arrItemBag.length; ++var0) {
            if (Char.getMyChar().arrItemBag[var0] != null && Char.getMyChar().arrItemBag[var0].template.type == 17) {
               InfoMe.a(TextGame.my);
               return;
            }
         }

         if (fb != 1) {
            InfoMe.a(TextGame.mz);
         }
      }

   }

   public static void x() {
      int var0 = (int)(System.currentTimeMillis() / 1000L);

      int var1;
      for(var1 = 0; var1 < Char.getMyChar().by.size(); ++var1) {
         Effect var2;
         if ((var2 = (Effect)Char.getMyChar().by.elementAt(var1)).e.a == 21 && var2.c - (var0 - var2.b) >= 2) {
            return;
         }
      }

      if (!Char.getMyChar().e(16)) {
         for(var1 = 0; var1 < Char.getMyChar().arrItemBag.length; ++var1) {
            if (Char.getMyChar().arrItemBag[var1] != null && Char.getMyChar().arrItemBag[var1].template.type == 16) {
               InfoMe.a(TextGame.my);
               return;
            }
         }

         if (fb != 1) {
            InfoMe.a(TextGame.na);
         }
      }

   }

   private static boolean br() {
      if (Char.getMyChar().mobFocus == null) {
         return false;
      } else {
         return Char.getMyChar().mobFocus.c().e == 142 && Char.getMyChar().cTypePk == 4 || Char.getMyChar().mobFocus.c().e == 143 && Char.getMyChar().cTypePk == 5 || Char.getMyChar().mobFocus.c().e == 143 && Char.getMyChar().cTypePk == 6;
      }
   }

   private void b(boolean var1) {
      if (Char.getMyChar().statusMe != 14) {
         boolean var10000;
         if (!InfoDlg.c && !Char.getMyChar().ej && !Char.eh && !Char.getMyChar().ek) {
            if (Char.getMyChar().mobFocus == null || (Char.getMyChar().mobFocus.s != 97 || Char.getMyChar().cTypePk != 4) && (Char.getMyChar().mobFocus.s != 98 || Char.getMyChar().cTypePk != 4) && (Char.getMyChar().mobFocus.s != 96 || Char.getMyChar().cTypePk != 5) && (Char.getMyChar().mobFocus.s != 99 || Char.getMyChar().cTypePk != 5) && (Char.getMyChar().mobFocus.s != 200 || Char.getMyChar().cTypePk != 4) && (Char.getMyChar().mobFocus.s != 199 || Char.getMyChar().cTypePk != 5) && (Char.getMyChar().mobFocus.s != 198 || Char.getMyChar().cTypePk != 6)) {
               if (Char.getMyChar().myskill != null && Char.getMyChar().myskill.template.type == 2 && Char.getMyChar().npcFocus == null) {
                  var10000 = bp();
               } else if (Char.getMyChar().ex != null || Char.getMyChar().charFocus != null && Char.getMyChar().charFocus.ab() || Char.getMyChar().mobFocus == null && Char.getMyChar().npcFocus == null && Char.getMyChar().charFocus == null && Char.getMyChar().itemFocus == null) {
                  var10000 = false;
               } else {
                  label443: {
                     int var2;
                     int var3;
                     if (Char.getMyChar().mobFocus != null) {
                        label402: {
                           if (Char.getMyChar().myskill == null) {
                              var10000 = false;
                              break label443;
                           }

                           if (Char.getMyChar().arrItemBody[1] == null) {
                              InfoMe.a(TextGame.oc);
                              var10000 = false;
                              break label443;
                           }

                           if (Char.getMyChar().mobFocus.status != 1 && Char.getMyChar().mobFocus.status != 0 && Char.getMyChar().myskill.template.type != 4) {
                              if (!bp()) {
                                 var10000 = false;
                                 break label443;
                              }

                              if (Char.getMyChar().cx1 < Char.getMyChar().mobFocus.x1) {
                                 Char.getMyChar().cdir = 1;
                              } else {
                                 Char.getMyChar().cdir = -1;
                              }

                              var2 = Math.abs(Char.getMyChar().cx1 - Char.getMyChar().mobFocus.x1);
                              var3 = Math.abs(Char.getMyChar().cy1 - Char.getMyChar().mobFocus.y1);
                              Char.getMyChar().k = 0;
                              if (Char.getMyChar().c()) {
                                 if (var2 > Char.getMyChar().myskill.ngang() || var3 > Char.getMyChar().myskill.cao()) {
                                    Char.getMyChar().el = new MovePoint(Char.getMyChar().mobFocus.x1, Char.getMyChar().cy1);
                                    GameCanvas.i();
                                    GameCanvas.h();
                                    var10000 = false;
                                    break label443;
                                 }

                                 GameCanvas.i();
                                 GameCanvas.h();
                                 break label402;
                              }

                              if ((Char.getMyChar().myskill.template.id == 24 || Char.getMyChar().myskill.template.id == 40 || Char.getMyChar().myskill.template.id == 42) && var2 <= Char.getMyChar().myskill.ngang() && var3 <= Char.getMyChar().myskill.cao()) {
                                 GameCanvas.i();
                                 GameCanvas.h();
                                 Char.getMyChar().k = 0;
                                 break label402;
                              }

                              if (var2 <= Char.getMyChar().myskill.ngang() && var3 <= Char.getMyChar().myskill.cao() && Char.getMyChar().cy1 >= Char.getMyChar().mobFocus.y1 - 10) {
                                 GameCanvas.i();
                                 GameCanvas.h();
                                 Char.getMyChar().k = 0;
                                 break label402;
                              }

                              Char.getMyChar().el = new MovePoint(Char.getMyChar().mobFocus.x1 + Char.getMyChar().mobFocus.dir * 12, Char.getMyChar().cy1);
                              GameCanvas.i();
                              GameCanvas.h();
                              var10000 = false;
                              break label443;
                           }

                           var10000 = false;
                           break label443;
                        }
                     } else {
                        if (Char.getMyChar().npcFocus != null) {
                           if (Char.getMyChar().cx1 < Char.getMyChar().npcFocus.cx1) {
                              Char.getMyChar().cdir = 1;
                           } else {
                              Char.getMyChar().cdir = -1;
                           }

                           if (Char.getMyChar().cx1 < Char.getMyChar().npcFocus.cx1) {
                              Char.getMyChar().npcFocus.cdir = -1;
                           } else {
                              Char.getMyChar().npcFocus.cdir = 1;
                           }

                           var2 = Math.abs(Char.getMyChar().cx1 - Char.getMyChar().npcFocus.cx1);
                           var3 = Math.abs(Char.getMyChar().cy1 - Char.getMyChar().npcFocus.cy1);
                           if (var2 < 60 && var3 < 40) {
                              GameCanvas.i();
                              GameCanvas.h();
                              if (Code.isZoneNpc(Char.getMyChar().npcFocus)) {
                                 Service.gI().e();
                              } else {
                                 Service.gI().openMenu(Char.getMyChar().npcFocus.npcTemplate.npcTemplateId);
                              }
                              InfoDlg.a();
                           } else {
                              Char.getMyChar().el = new MovePoint(Char.getMyChar().npcFocus.cx1, Char.getMyChar().cy1);
                              GameCanvas.i();
                              GameCanvas.h();
                           }

                           var10000 = false;
                           break label443;
                        }

                        if (Char.getMyChar().charFocus != null) {
                           if (Char.getMyChar().cx1 < Char.getMyChar().charFocus.cx1) {
                              Char.getMyChar().cdir = 1;
                           } else {
                              Char.getMyChar().cdir = -1;
                           }

                           var2 = Math.abs(Char.getMyChar().cx1 - Char.getMyChar().charFocus.cx1);
                           var3 = Math.abs(Char.getMyChar().cy1 - Char.getMyChar().charFocus.cy1);
                           if (!Char.getMyChar().b(Char.getMyChar().charFocus)) {
                              if (var2 < 60 && var3 < 40 && Char.getMyChar().charFocus.idChar >= 0) {
                                 GameCanvas.i();
                                 if (Char.getMyChar().charFocus.statusMe != 14 && Char.getMyChar().charFocus.statusMe != 5 && TileMap.bgID == 1) {
                                    var10000 = false;
                                    break label443;
                                 }

                                 if (!this.gi) {
                                    MyVector var5;
                                    (var5 = new MyVector()).addElement(new Command1(TextGame.nb[6], 110397));
                                    var5.addElement(new Command1(TextGame.nb[4], 110391));
                                    if ((Char.getMyChar().ctypeClan == 4 || Char.getMyChar().ctypeClan == 3 || Char.getMyChar().ctypeClan == 2) && Char.getMyChar().charFocus.cClanName.equals("")) {
                                       var5.addElement(new Command1(TextGame.nb[8], 110398));
                                    }

                                    if ((Char.getMyChar().charFocus.ctypeClan == 4 || Char.getMyChar().charFocus.ctypeClan == 3 || Char.getMyChar().charFocus.ctypeClan == 2) && Char.getMyChar().cClanName.equals("")) {
                                       var5.addElement(new Command1(TextGame.nb[9], 110399));
                                    }

                                    var5.addElement(new Command1(TextGame.nb[7], 12004, Char.getMyChar().charFocus.cName));
                                    if (Char.getMyChar().nClass.a == 6) {
                                       var5.addElement(new Command1(TextGame.nb[11] + ": " + (!Char.dq ? TextGame.aq : TextGame.ar), 1103991));
                                    }

                                    if (Char.getMyChar().charFocus.statusMe != 14 && Char.getMyChar().charFocus.statusMe != 5) {
                                       var5.addElement(new Command1(TextGame.nb[0], 110392));
                                       var5.addElement(new Command1(TextGame.nb[1], 110393));
                                       var5.addElement(new Command1(TextGame.nb[2], 110394));
                                    } else if (Char.getMyChar().myskill.template.type == 4) {
                                       var5.addElement(new Command1(TextGame.nb[5], 110395));
                                    }

                                    var5.addElement(new Command1(TextGame.nb[3], 110396));
                                    GameCanvas.af.a(var5);
                                    GameCanvas.af.e = 5;
                                 }

                                 this.gi = false;
                              } else {
                                 Char.getMyChar().el = new MovePoint(Char.getMyChar().charFocus.cx1, Char.getMyChar().cy1);
                                 GameCanvas.i();
                                 GameCanvas.h();
                              }

                              var10000 = false;
                              break label443;
                           }

                           if (Char.getMyChar().myskill == null) {
                              var10000 = false;
                              break label443;
                           }

                           if (Char.getMyChar().arrItemBody[1] == null) {
                              InfoMe.a(TextGame.oc);
                              var10000 = false;
                              break label443;
                           }

                           if (!bp()) {
                              var10000 = false;
                              break label443;
                           }

                           if (Char.getMyChar().cx1 < Char.getMyChar().charFocus.cx1) {
                              Char.getMyChar().cdir = 1;
                           } else {
                              Char.getMyChar().cdir = -1;
                           }

                           Char.getMyChar().k = 0;
                           if (Char.getMyChar().c()) {
                              if (var2 > Char.getMyChar().myskill.ngang() || var3 > Char.getMyChar().myskill.cao()) {
                                 Char.getMyChar().el = new MovePoint(Char.getMyChar().charFocus.cx1, Char.getMyChar().cy1);
                                 GameCanvas.i();
                                 GameCanvas.h();
                                 var10000 = false;
                                 break label443;
                              }

                              GameCanvas.i();
                              GameCanvas.h();
                           } else if ((Char.getMyChar().myskill.template.id == 24 || Char.getMyChar().myskill.template.id == 40 || Char.getMyChar().myskill.template.id == 42) && var2 <= Char.getMyChar().myskill.ngang() && var3 <= Char.getMyChar().myskill.cao()) {
                              GameCanvas.i();
                              GameCanvas.h();
                              Char.getMyChar().k = 0;
                           } else {
                              if (var2 > Char.getMyChar().myskill.ngang() || var3 > Char.getMyChar().myskill.cao() || Char.getMyChar().cy1 < Char.getMyChar().charFocus.cy1) {
                                 Char.getMyChar().el = new MovePoint(Char.getMyChar().charFocus.cx1 + Char.getMyChar().charFocus.cdir * 12, Char.getMyChar().cy1);
                                 GameCanvas.i();
                                 GameCanvas.h();
                                 var10000 = false;
                                 break label443;
                              }

                              GameCanvas.i();
                              GameCanvas.h();
                              Char.getMyChar().k = 0;
                           }
                        } else if (Char.getMyChar().itemFocus != null) {
                           if (Char.getMyChar().statusMe != 1) {
                              var10000 = false;
                              break label443;
                           }

                           if (Char.getMyChar().cx1 < Char.getMyChar().itemFocus.x) {
                              Char.getMyChar().cdir = 1;
                           } else {
                              Char.getMyChar().cdir = -1;
                           }

                           var2 = Math.abs(Char.getMyChar().cx1 - Char.getMyChar().itemFocus.x);
                           var3 = Math.abs(Char.getMyChar().cy1 - Char.getMyChar().itemFocus.y);
                           if (var2 <= 35 && var3 < 35 || fb != 0 && var2 <= 48 && var3 <= 48) {
                              GameCanvas.i();
                              GameCanvas.h();
                              Service.gI().pickItem(Char.getMyChar().itemFocus.itemMapID);
                           } else {
                              Char.getMyChar().el = new MovePoint(Char.getMyChar().itemFocus.x, Char.getMyChar().cy1);
                              GameCanvas.i();
                              GameCanvas.h();
                           }

                           var10000 = false;
                           break label443;
                        }
                     }

                     var10000 = true;
                  }
               }
            } else {
               var10000 = false;
            }
         } else {
            var10000 = false;
         }

         if (var10000) {
            MyVector var4;
            if (br()) {
               (var4 = new MyVector()).addElement(new Command1(TextGame.ru, 151301));
               GameCanvas.af.a(var4);
               return;
            }

            if (Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.c().e == 144 && TileMap.mapID == 130) {
               (var4 = new MyVector()).addElement(new Command1(TextGame.ry, 151301));
               GameCanvas.af.a(var4);
               return;
            }

            int skillAnim;
            if (Code.fakeSkill && Code.fakeSkillId > 0
                  && Code.fakeSkillId < aa.length
                  && !Code.dongbang_skill) {
               skillAnim = Code.fakeSkillId;
            } else {
               skillAnim = Char.getMyChar().myskill.template.id;
            }
            Char.getMyChar().a((SkillPaint)aa[skillAnim], 0);
            Char.getMyChar().fl = var1;
            if (Char.getMyChar().bo) {
               Char.getMyChar().bo = false;
               Char.getMyChar().dz = System.currentTimeMillis();
               if (Char.getMyChar().em >= 500) {
                  ServerEffect.a(60, Char.getMyChar(), 1);
               }
            }

            if (Char.getMyChar().p() && !Char.getMyChar().bp) {
               Char.getMyChar().bn = false;
               Char.getMyChar().bp = true;
               ServerEffect.a(60, Char.getMyChar(), 1);
            }

            if (Char.getMyChar().ad() && !Char.getMyChar().bp) {
               Char.getMyChar().bq = false;
               Char.getMyChar().bp = true;
               ServerEffect.a(60, Char.getMyChar(), 1);
            }
         }
      }

      if (!var1) {
         Char.getMyChar().fk = Char.getMyChar().myskill;
      }

   }

   private void bs() {
      this.ki = 0;

      int var1;
      for(var1 = 0; var1 < jz.length; ++var1) {
         if (jz[var1] != null) {
            ++this.ki;
         }
      }

      if (this.ki <= 1) {
         InfoMe.b();
      } else {
         if (!ha || this.kj == -1) {
            ha = true;

            for(var1 = 0; var1 < jz.length; ++var1) {
               if (jz[var1] == Char.getMyChar().myskill) {
                  this.kj = var1;
                  break;
               }
            }
         }

         ++this.kj;
         if (this.kj >= jz.length) {
            this.kj = 0;
         }

         if (jz[this.kj] == null) {
            this.kj = 0;
         }

         super.b = new Command1("", 11059);
      }

   }

   public final void a(Skill var1, boolean var2, boolean var3) {
      this.kj = -1;
      if (var1 != null) {
         if (var1.template.type == 4 && Char.getMyChar().charFocus != null) {
            if (Char.getMyChar().charFocus.ab()) {
               return;
            }

            if (Char.getMyChar().charFocus.statusMe == 14 || Char.getMyChar().charFocus.statusMe == 5) {
               Service.gI().x(Char.getMyChar().charFocus.idChar);
               if ((TileMap.tileTypeAtPixel(Char.getMyChar().cx1, Char.getMyChar().cy1) & 2) == 2) {
                  Char.getMyChar().a((SkillPaint)aa[49], 0);
               } else {
                  Char.getMyChar().a((SkillPaint)aa[49], 1);
               }
            }
         } else {
            Service.gI().selectSkill(var1.template.id);
         }
      }

      if (var1.template.type != 2) {
         this.v();
      }

      if (var1 != null) {
         Char.getMyChar().myskill = var1;
         if (var1.template.type == 1 && Code.mode != null) {
            Auto.my_skill = var1;
         }

         if (Char.getMyChar().npcFocus == null && var1.template.type != 4) {
            this.b(var2);
         }
      }

   }

   public static void c(int var0) {
      MyVector var6 = var0 == 0 ? vFriend : vEnemies;

      for(int var1 = 0; var1 < var6.size() - 1; ++var1) {
         Friend var2 = (Friend)var6.elementAt(var1);

         for(int var3 = var1 + 1; var3 < var6.size(); ++var3) {
            Friend var4;
            Friend var5;
            if ((var4 = (Friend)var6.elementAt(var3)).b > var2.b) {
               var5 = var4;
               var4 = var2;
               var2 = var5;
               var6.setElementAt(var5, var1);
               var6.setElementAt(var4, var3);
            } else if (var4.b == var2.b && var2.a.compareTo(var4.a) > 0) {
               var5 = var4;
               var4 = var2;
               var2 = var5;
               var6.setElementAt(var5, var1);
               var6.setElementAt(var4, var3);
            }
         }
      }

   }

   public static void y() {
      for(int var0 = 0; var0 < vClan.size() - 1; ++var0) {
         Member var1 = (Member)vClan.elementAt(var0);

         for(int var2 = var0 + 1; var2 < vClan.size(); ++var2) {
            Member var3 = (Member)vClan.elementAt(var2);
            Member var4;
            if (gr && !gs) {
               if (var3.e && !var1.e) {
                  var4 = var3;
                  var3 = var1;
                  var1 = var4;
                  vClan.setElementAt(var4, var0);
                  vClan.setElementAt(var3, var2);
               } else if (var3.e && var1.e) {
                  if (var3.c > var1.c) {
                     var4 = var3;
                     var3 = var1;
                     var1 = var4;
                     vClan.setElementAt(var4, var0);
                     vClan.setElementAt(var3, var2);
                  } else if (var3.c == var1.c) {
                     if (var3.f > var1.f) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                     } else if (var1.f == var3.f) {
                        if (var3.g > var1.g) {
                           var4 = var3;
                           var3 = var1;
                           var1 = var4;
                           vClan.setElementAt(var4, var0);
                           vClan.setElementAt(var3, var2);
                        } else if (var1.g == var3.g) {
                           if (var3.b > var1.b) {
                              var4 = var3;
                              var3 = var1;
                              var1 = var4;
                              vClan.setElementAt(var4, var0);
                              vClan.setElementAt(var3, var2);
                           } else if (var1.b == var3.b && var1.d.compareTo(var3.d) > 0) {
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
            } else if (gs) {
               if (gr) {
                  if (var3.e && !var1.e) {
                     var4 = var3;
                     var3 = var1;
                     var1 = var4;
                     vClan.setElementAt(var4, var0);
                     vClan.setElementAt(var3, var2);
                  } else if (var3.e && var1.e) {
                     if (var3.g > var1.g) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                     } else if (var1.g == var3.g) {
                        if (var3.f > var1.f) {
                           var4 = var3;
                           var3 = var1;
                           var1 = var4;
                           vClan.setElementAt(var4, var0);
                           vClan.setElementAt(var3, var2);
                        } else if (var1.f == var3.f) {
                           if (var3.c > var1.c) {
                              var4 = var3;
                              var3 = var1;
                              var1 = var4;
                              vClan.setElementAt(var4, var0);
                              vClan.setElementAt(var3, var2);
                           } else if (var3.c == var1.c && var1.b == var3.b && var1.d.compareTo(var3.d) > 0) {
                              var4 = var3;
                              var3 = var1;
                              var1 = var4;
                              vClan.setElementAt(var4, var0);
                              vClan.setElementAt(var3, var2);
                           }
                        }
                     }
                  }
               } else if (var3.g > var1.g) {
                  var4 = var3;
                  var3 = var1;
                  var1 = var4;
                  vClan.setElementAt(var4, var0);
                  vClan.setElementAt(var3, var2);
               } else if (var1.g == var3.g) {
                  if (var3.f > var1.f) {
                     var4 = var3;
                     var3 = var1;
                     var1 = var4;
                     vClan.setElementAt(var4, var0);
                     vClan.setElementAt(var3, var2);
                  } else if (var1.f == var3.f) {
                     if (var3.c > var1.c) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                     } else if (var3.c == var1.c && var1.b == var3.b && var1.d.compareTo(var3.d) > 0) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                     }
                  }
               }
            } else if (var3.c > var1.c) {
               var4 = var3;
               var3 = var1;
               var1 = var4;
               vClan.setElementAt(var4, var0);
               vClan.setElementAt(var3, var2);
            } else if (var3.c == var1.c) {
               if (var3.f > var1.f) {
                  var4 = var3;
                  var3 = var1;
                  var1 = var4;
                  vClan.setElementAt(var4, var0);
                  vClan.setElementAt(var3, var2);
               } else if (var1.f == var3.f) {
                  if (var3.g > var1.g) {
                     var4 = var3;
                     var3 = var1;
                     var1 = var4;
                     vClan.setElementAt(var4, var0);
                     vClan.setElementAt(var3, var2);
                  } else if (var1.g == var3.g) {
                     if (var3.b > var1.b) {
                        var4 = var3;
                        var3 = var1;
                        var1 = var4;
                        vClan.setElementAt(var4, var0);
                        vClan.setElementAt(var3, var2);
                     } else if (var1.b == var3.b && var1.d.compareTo(var3.d) > 0) {
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

   public static void sortSkill() {
      for(int var0 = 0; var0 < Char.getMyChar().vSkillFight.size() - 1; ++var0) {
         Skill var1 = (Skill)Char.getMyChar().vSkillFight.elementAt(var0);

         for(int var2 = var0 + 1; var2 < Char.getMyChar().vSkillFight.size(); ++var2) {
            Skill var3;
            if ((var3 = (Skill)Char.getMyChar().vSkillFight.elementAt(var2)).template.id < var1.template.id) {
               Skill var4 = var3;
               var3 = var1;
               var1 = var4;
               Char.getMyChar().vSkillFight.setElementAt(var4, var0);
               Char.getMyChar().vSkillFight.setElementAt(var3, var2);
            }
         }
      }

   }

   private static void h(int var0) {
      Char.getMyChar().l = Char.getMyChar().bj ? -10 : -8;
      Char.getMyChar().k = var0;
      Char.getMyChar().statusMe = 3;
      Char.getMyChar().m = 0;
   }

   public final void d() {
      int var3;
      for(var3 = 0; var3 < x.size(); ++var3) {
         Class_es var2;
         if ((var2 = (Class_es)x.elementAt(var3)) != null) {
            var2.a();
            if (var2.c) {
               x.removeElement(var2);
            }
         }
      }

      if (aw == 4 && GameCanvas.g && mScreen.a(this.gg) && this.gg != null && super.b == null && !cq) {
         GameCanvas.r = false;
         GameCanvas.n[5] = false;
         mScreen.g = -1;
         this.gg.a();
      }

      if (GameCanvas.w % 200 == 0) {
         Char.r();
      }

      if (ez != 0 && !GameCanvas.a) {
         if (Code.mode == null) {
            p += NinjaUtil.a(-7, 7);
            if (++fa > 20) {
               ez = 0;
               fa = 0;
            }
         } else {
            ez = 0;
            fa = 0;
         }
      } else if (p != r || q != s) {
         if (Code.mode == null) {
            if (!ex) {
               fv = r - p << 2;
               fw = s - q << 2;
            } else {
               fv = r - p << 1;
               fw = s - q << 2;
            }

            ft += fv;
            p += ft >> 4;
            ft &= 15;
            fu += fw;
            q += fu >> 4;
            fu &= 15;
         } else {
            p = r;
            q = s;
         }

         if (p < 24) {
            p = 24;
         }

         if (p > fx) {
            p = fx;
         }

         if (q < 0) {
            q = 0;
         }

         if (q > fy) {
            q = fy;
         }
      }

      if ((gssx = p / TileMap.size - 1) < 0) {
         gssx = 0;
      }

      gssy = q / TileMap.size;
      gssxe = gssx + fq;
      gssye = gssy + fr;
      if (gssy < 0) {
         gssy = 0;
      }

      if (gssye > TileMap.tmh - 1) {
         gssye = TileMap.tmh - 1;
      }

      if ((TileMap.y = (Char.getMyChar().cx1 - 2 * i) / TileMap.size) < 0) {
         TileMap.y = 0;
      }

      if ((TileMap.z = TileMap.y + TileMap.ac) > TileMap.tmw) {
         TileMap.y = (TileMap.z = TileMap.tmw) - TileMap.ac;
      }

      if ((TileMap.aa = (Char.getMyChar().cy1 - 2 * j) / TileMap.size) < 0) {
         TileMap.aa = 0;
      }

      if ((TileMap.ab = TileMap.aa + TileMap.ad) > TileMap.tmh) {
         TileMap.aa = (TileMap.ab = TileMap.tmh) - TileMap.ad;
      }

      ba.c();
      go.c();
      ChatTextField var10;
      if ((var10 = ChatTextField.a()).b) {
         var10.a.c();
         if (var10.a.ij) {
            var10.a.ij = false;
            var10.c.a(var10.a.d(), var10.i);
            var10.a.a("");
            var10.e.a = "Đóng";
         }
      }

      if (kg >= 0) {
         --kg;
      }

      TileMap.updateCmMiniMap();
      TileMap.e1();
      GameCanvas.gI();
      GameCanvas.d();
      int var1;
      if (GameCanvas.d) {
         MyVector var6 = new MyVector();
         long var12 = System.currentTimeMillis();

         for(var1 = 0; var1 < vCharInMap.size(); ++var1) {
            Char var5;
            (var5 = (Char)vCharInMap.elementAt(var1)).h();
            if (var5.q()) {
               if (var5.fj && var12 - var5.e > 10000L && var12 - this.kk > 10000L) {
                  var5.fj = false;
                  var5.e = var12;
                  var6.addElement(var5);
               }
            } else {
               var5.e = var12;
               var5.fj = true;
            }
         }

         if (var6.size() > 0) {
            Service.gI().a(var6);
            this.kk = var12;
         }
      } else {
         for(var1 = 0; var1 < vCharInMap.size(); ++var1) {
            ((Char)vCharInMap.elementAt(var1)).h();
         }
      }

      Char.getMyChar().h();
      if (Char.getMyChar().cHP <= 0 && TileMap.phong_af && !phong1.a) {
         TileMap.g();
      }

      if (Char.getMyChar().statusMe == 1 && GameCanvas.w % 100 == 0) {
         System.gc();
      }

      for(var1 = 0; var1 < vMob.size(); ++var1) {
         ((Mob)vMob.elementAt(var1)).a();
      }

      for(var1 = 0; var1 < vNpc.size(); ++var1) {
         ((Npc)vNpc.elementAt(var1)).h();
      }

      GameCanvas.gI().m();

      int[] var10000;
      for(var3 = 0; var3 < 5; ++var3) {
         if (lo[var3] != -1) {
            var10000 = lo;
            var10000[var3] += Res.e(ln[var3]);
            if (lo[var3] > 30) {
               lo[var3] = -1;
            }

            var10000 = lk;
            var10000[var3] += lm[var3];
            var10000 = ll;
            var10000[var3] += ln[var3];
         }
      }

      for(var3 = 0; var3 < vLanterns.size(); ++var3) {
         Lanterns var7;
         Lanterns var16 = var7 = (Lanterns)vLanterns.elementAt(var3);
         var16.b -= var7.c;
         if (var7.d - var7.b > 150) {
            var7.e = true;
         }

         if (((Lanterns)vLanterns.elementAt(var3)).e) {
            vLanterns.removeElementAt(var3);
         }
      }

      for(var3 = 0; var3 < 2; ++var3) {
         if (ls[var3] != -1) {
            int var10003 = ls[var3]++;
            var10000 = lq;
            var10000[var3] += lu[var3] << 2;
            var10003 = lr[var3]--;
            if (ls[var3] >= 6) {
               ls[var3] = -1;
            } else {
               lt[var3] = (ls[var3] >> 1) % 3;
            }
         }
      }

      if (aw != -1) {
         if (of != og) {
            oi = og - of << 2;
            oh += oi;
            of += oh >> 4;
            oh &= 15;
         }

         if (Math.abs(og - of) < 15 && of < 0) {
            og = 0;
         }

         if (Math.abs(og - of) < 15 && of > 0) {
            og = 0;
         }
      }

      GameCanvas.e();

      for(var1 = 0; var1 < vMobAttack.size(); ++var1) {
         ((MobAttack)vMobAttack.elementAt(var1)).a();
      }

      for(var1 = 0; var1 < vItemMap.size(); ++var1) {
         ItemMap var13;
         if ((var13 = (ItemMap)vItemMap.elementAt(var1)).status == 2 && var13.x == var13.xEnd && var13.y == var13.yEnd) {
            vItemMap.removeElement(var13);
            if (Char.getMyChar().itemFocus != null && Char.getMyChar().itemFocus.equals(var13)) {
               Char.getMyChar().itemFocus = null;
            }
         } else if (var13.status <= 0) {
            var13.status = (byte)(var13.status - 4);
            if (var13.status < -12) {
               var13.y -= 12;
               var13.status = 1;
            }
         } else {
            if (var13.vx == 0) {
               var13.x = var13.xEnd;
            }

            if (var13.vy == 0) {
               var13.y = var13.yEnd;
            }

            if (var13.x != var13.xEnd) {
               var13.x += var13.vx;
               if (var13.vx > 0 && var13.x > var13.xEnd || var13.vx < 0 && var13.x < var13.xEnd) {
                  var13.x = var13.xEnd;
               }
            }

            if (var13.y != var13.yEnd) {
               var13.y += var13.vy;
               if (var13.vy > 0 && var13.y > var13.yEnd || var13.vy < 0 && var13.y < var13.yEnd) {
                  var13.y = var13.yEnd;
               }
            }
         }

         if (var13.k && System.currentTimeMillis() - var13.l >= 12000L) {
            var13.k = false;
         }
      }

      for(var1 = 0; var1 < vMobSoul.size(); ++var1) {
         ((MobSoul)vMobSoul.elementAt(var1)).a();
      }

      if ((TileMap.tmw * TileMap.sizeMiniMap >= TileMap.wMiniMap || TileMap.tmh * TileMap.sizeMiniMap >= TileMap.hMiniMap) && System.currentTimeMillis() / 100L > 20L) {
         TileMap.updateMiniMap();
      }

      for(var1 = Effect2.b.size() - 1; var1 >= 0; --var1) {
         Effect2.a.removeElement(Effect2.b.elementAt(var1));
         Effect2.b.removeElementAt(var1);
      }

      for(var1 = 0; var1 < Effect2.a.size(); ++var1) {
         ((Effect2)Effect2.a.elementAt(var1)).a();
      }

      for(var1 = 0; var1 < Effect2.c.size(); ++var1) {
         ((Effect2)Effect2.c.elementAt(var1)).a();
      }

      for(var1 = 0; var1 < Effect2.d.size(); ++var1) {
         ((Effect2)Effect2.d.elementAt(var1)).a();
      }

      for(var1 = 0; var1 < Mob.vEggMonter.size(); ++var1) {
         EggMonters var9;
         if ((var9 = (EggMonters)Mob.vEggMonter.elementAt(var1)) != null) {
            if (var9.a()) {
               if (var9.d == 0) {
                  ++var9.e;
                  var9.b += var9.e;
                  ++var9.c;
                  if (var9.c > 3) {
                     var9.c = 0;
                  }

                  if ((TileMap.tileTypeAtPixel(var9.a, var9.b) & 2) == 2) {
                     var9.d = 1;
                     var9.e = 0;
                  }
               } else if (var9.d == 1) {
                  ++var9.c;
                  if (var9.c > 6) {
                     var9.c = 6;
                     EggMonters.f.status = 5;
                  }
               }
            }

            if (var9.c == 6) {
               if (EggMonters.f != null) {
                  EggMonters.f.status = 5;
               }

               Mob.vEggMonter.removeElementAt(var1);
            }
         }
      }

      SmallImage.a();
      if (this.dm >= 0 && vCharInMap.size() > 0) {
         int var11;
         if ((var11 = Char.d(this.dm)) >= 0 && var11 < vCharInMap.size()) {
            Char var15;
            if ((var15 = (Char)vCharInMap.elementAt(var11)) != null && Char.a(var15) && !var15.ab()) {
               Char.getMyChar().mobFocus = null;
               Char.getMyChar().v();
               Char.getMyChar().itemFocus = null;
               Char.getMyChar();
               Char.fg = true;
               Char.getMyChar().charFocus = var15;
            }
         } else {
            this.dm = -1;
            Char.getMyChar().charFocus = null;
         }
      } else {
         this.dm = -1;
      }

      Info.a();
      InfoMe.a();
      if (currentCharViewInfo != null && currentCharViewInfo.idChar != Char.getMyChar().idChar) {
         currentCharViewInfo.h();
      }

      ++this.kl;
      if (this.kl > 3) {
         this.kl = 0;
      }

      if (gu) {
         indexSize = 40;
      } else {
         indexSize = 28;
      }

      EffectAuto.b();
      EffectAuto.c();
   }

   private static void c(mGraphics var0) {
      for(int var1 = 0; var1 < x.size(); ++var1) {
         Class_es var2;
         if ((var2 = (Class_es)x.elementAt(var1)) != null) {
            var2.a(var0, GameCanvas.aa, km + var1 * 18 + 15);
         }
      }

   }

   private static int _paintCounter = 0;
   private static int _paintTripCounter = 0;
   public final void a(mGraphics var1) {
      // P2 A1#2: g2 cross-check moi 128 frame paint — fail thi clear myChar.charFocus (next click crash).
      if (com.monkey.nso.LicenseGuard.isVerifyStarted() && (_paintCounter++ & 0x7F) == 0
              && !com.monkey.nso.LicenseGuard.g2()) {
         try { Char mc = Char.getMyChar(); if (mc != null) mc.charFocus = null; } catch (Throwable ignored) {}
      }
      // P2 N6 T3: tripwire moi 500 frame — invariant cross-check.
      if (++_paintTripCounter > 500) {
         _paintTripCounter = 0;
         if (com.monkey.nso.LicenseVerifier.isVerified
                 && com.monkey.nso.LicenseGuard.isVerifyStarted()
                 && !com.monkey.nso.LicenseGuard.g1()) {
            com.monkey.nso.LicenseGuard.fireTripwire(3);
         }
      }
      // P2 N6 D4: shouldDegrade -> 0.1% flicker do screen 1 frame (rare bug visual).
      if (com.monkey.nso.LicenseGuard.shouldDegrade() && Math.random() < 0.001) {
         try {
            var1.a(0xFF0000);
            var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
         } catch (Throwable ignored) {}
      }
      if (Char.eg) {
         var1.a(0);
         var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
         mFont.d.a(var1, TextGame.ed, GameCanvas.ac, GameCanvas.ad + 20, 2);
         GameCanvas.a(GameCanvas.ac, GameCanvas.ad, var1, false);
      } else {
         GameCanvas.a(var1);
         var1.a(-p, -q);

         int var2;
         for(var2 = 0; var2 < ep.size(); ++var2) {
            ((ItemTree)ep.elementAt(var2)).a(var1);
         }

         TileMap.paintTilemapLOW(var1);

         for(var2 = 0; var2 < eq.size(); ++var2) {
            ((ItemTree)eq.elementAt(var2)).a(var1);
         }

         for(var2 = 0; var2 < vMob.size(); ++var2) {
            ((Mob)vMob.elementAt(var2)).a(var1);
         }

         for(var2 = 0; var2 < Mob.vEggMonter.size(); ++var2) {
            EggMonters var3;
            if ((var3 = (EggMonters)Mob.vEggMonter.elementAt(var2)).a()) {
               var1.a(er, 0, var3.c << 5, 32, 32, 0, var3.a, var3.b, 33);
            }
         }

         for(var2 = 0; var2 < vBuNhin.size(); ++var2) {
            BuNhin var13;
            BuNhin var5;
            if ((var5 = var13 = (BuNhin)vBuNhin.elementAt(var2)).a >= p && var5.a <= p + GameScr.i && var5.b >= q && var5.b <= q + j + 30) {
               mFont.j.a(var1, var13.c, var13.a, var13.b - 32, 2, mFont.k);
               SmallImage.a(var1, 1180, var13.a, var13.b, 0, 33);
               if (var13.d) {
                  SmallImage.a(var1, 288, var13.a, var13.b, 0, 33);
                  var13.d = false;
               }
            }
         }

         for(var2 = 0; var2 < vNpc.size(); ++var2) {
            ((Npc)vNpc.elementAt(var2)).a(var1);
         }

         mGraphics var4 = var1;
         GameScr var14 = this;

         int var7;
         int var9;
         int var18;
         for(var9 = 0; var9 < TileMap.t.size(); ++var9) {
            Waypoint var10;
            if ((var10 = (Waypoint)TileMap.t.elementAt(var9)).b != 0 && var10.d < TileMap.pxh - 24) {
               if (var10.c <= TileMap.pxw / 2) {
                  if (!GameCanvas.g) {
                     SmallImage.a(var4, 1213, var10.c + 12 + var14.kl, var10.d - 12, 2, StaticObj.g);
                  } else {
                     SmallImage.a(var4, 1213, var10.c + 12 + var14.kl, var10.d - 32, 2, StaticObj.g);
                  }
               } else if (var10.a >= TileMap.pxw / 2) {
                  if (!GameCanvas.g) {
                     SmallImage.a(var4, 1213, var10.a - 12 - var14.kl, var10.d - 12, 0, StaticObj.g);
                  } else {
                     SmallImage.a(var4, 1213, var10.a - 12 - var14.kl, var10.d - 32, 0, StaticObj.g);
                  }
               }
            } else if (var10.d <= TileMap.pxh / 2) {
               var18 = var10.a + (var10.c - var10.a) / 2;
               var7 = var10.b + (var10.d - var10.b) / 2 + var14.kl;
               if (GameCanvas.g) {
                  var7 = var10.d + (var10.d - var10.b) + var14.kl + 10;
               }

               SmallImage.a(var4, 1213, var18, var7, 6, StaticObj.g);
            } else if (var10.b >= TileMap.pxh / 2) {
               SmallImage.a(var4, 1213, var10.a + (var10.c - var10.a) / 2, var10.b - 12 - var14.kl, 4, StaticObj.g);
            }
         }

         var1.d(0, -200, GameCanvas.aa - var1.a(), 200 + GameCanvas.ab - var1.b());
         GameCanvas.gI().b(var1);

         for(var2 = 0; var2 < vCharInMap.size(); ++var2) {
            Char var15 = null;

            try {
               var15 = (Char)vCharInMap.elementAt(var2);
            } catch (Exception var16) {
            }

            if (var15 != null) {
               if (TileMap.mapID == 111 && var2 > 19) {
                  var15.c(var1);
               } else {
                  var15.a(var1);
               }
            }
         }

         for(var2 = 0; var2 < vParty.size(); ++var2) {
            Party var17;
            if ((var17 = (Party)vParty.elementAt(var2)).f != null && var17.f != Char.getMyChar()) {
               var17.f.b(var1);
            }
         }

         mGraphics var19 = var1;

         int var16;
         for(var16 = 0; var16 < 5; ++var16) {
            if (lo[var16] != -1 && GameCanvas.e(lk[var16], ll[var16])) {
               if (lp[var16] == 0) {
                  mFont.q.a(var19, lj[var16], lk[var16], ll[var16], 2);
               } else if (lp[var16] == 1) {
                  mFont.p.a(var19, lj[var16], lk[var16], ll[var16], 2);
               } else if (lp[var16] == 2) {
                  mFont.r.a(var19, lj[var16], lk[var16], ll[var16], 2);
               } else if (lp[var16] == 3) {
                  mFont.d.a(var19, lj[var16], lk[var16], ll[var16], 2, mFont.b);
               } else if (lp[var16] == 8) {
                  mFont.e.a(var19, lj[var16], lk[var16], ll[var16], 2, mFont.b);
               } else if (lp[var16] == 4) {
                  SmallImage.a(var19, 1062, lk[var16], ll[var16], 0, 3);
               } else if (lp[var16] == 5) {
                  mFont.t.a(var19, lj[var16], lk[var16], ll[var16], 2);
               } else if (lp[var16] == 6) {
                  mFont.j.a(var19, lj[var16], lk[var16], ll[var16], 2, mFont.l);
               } else if (lp[var16] == 7) {
                  SmallImage.a(var19, 655, lk[var16], ll[var16], 0, 3);
               }
            }
         }

         var19 = var1;

         for(var16 = 0; var16 < vLanterns.size(); ++var16) {
            Lanterns var20 = (Lanterns)vLanterns.elementAt(var16);
            if (GameCanvas.w % 10 < 8) {
               SmallImage.a(var19, 1292, var20.a, var20.b, 0, 3);
            } else {
               SmallImage.a(var19, 1291, var20.a, var20.b, 0, 3);
            }
         }

         var19 = var1;

         for(var16 = 0; var16 < 2; ++var16) {
            if (ls[var16] != -1) {
               if (lu[var16] == 1) {
                  var19.a(lv[lt[var16]], lq[var16], lr[var16], 3);
               } else {
                  var19.a(lv[lt[var16]], 0, 0, mGraphics.a(lv[lt[var16]]), mGraphics.b(lv[lt[var16]]), 2, lq[var16], lr[var16], 3);
               }
            }
         }

         Char.getMyChar().a(var1);
         var4 = var1;
         var14 = this;
         if (Char.getMyChar().d) {
            for(var18 = 0; var18 < var14.pv.length; ++var18) {
               if (var14.pv[var18] != -1) {
                  byte var24 = 0;
                  if (var14.pv[var18] == 0) {
                     var24 = 2;
                  } else if (var14.pv[var18] == 1) {
                     var24 = 6;
                  } else if (var14.pv[var18] == 2) {
                     var24 = 0;
                  }

                  SmallImage.a(var4, 989, Char.getMyChar().cx1 + var18 * 10 - (var14.pv.length - 1) * 10 / 2, Char.getMyChar().cy1 - 40, var24, 3);
               }
            }
         }

         for(var2 = 0; var2 < vSet.size(); ++var2) {
            Class_eg var27 = (Class_eg)vSet.elementAt(var2);
         }

         byte var22;
         for(var2 = 0; var2 < vItemMap.size(); ++var2) {
            ItemMap var21;
            if ((var21 = (ItemMap)vItemMap.elementAt(var2)).imgCaptcha != null && var21.imgCaptcha.a != null) {
               var22 = 0;
               if (var21.status <= 0) {
                  var22 = var21.status;
               }

               var1.a(var21.imgCaptcha.a, var21.x, var21.y + var22, 33);
            } else {
               var22 = 0;
               if (var21.status <= 0) {
                  var22 = var21.status;
               }

               SmallImage.a(var1, var21.template.iconID, var21.x, var21.y + var22, 0, 33);
               if (Char.getMyChar().itemFocus != null && Char.getMyChar().itemFocus.equals(var21) && var21.status != 2) {
                  SmallImage.a(var1, 988, var21.x, var21.y - 20, 0, 3);
               }
            }
         }

         for(var2 = 0; var2 < vMobSoul.size(); ++var2) {
            ((MobSoul)vMobSoul.elementAt(var2)).a(var1);
         }

         TileMap.paintOutTilemap(var1);
         if (Code.x_dcvt[TileMap.mapID].size() > 0 && Code.show_dcvt) {
            Image img = GameCanvas.c("/dvt.png");

            for(int i = 0; i < Code.x_dcvt[TileMap.mapID].size(); ++i) {
               var1.a(img, (Integer)Code.x_dcvt[TileMap.mapID].elementAt(i) - img.getWidth() / 2, (Integer)Code.y_dcvt[TileMap.mapID].elementAt(i), 0);
            }
         }

         if (Code.kcts > 0) {
            var1.a(16711680);
            var1.c(Code.x_kts - Code.kcts, Code.y_kts - Code.kcts, Code.kcts << 1, Code.kcts << 1, 0, 360);
         }

         if (Code.kc_nhat > 0) {
            var1.a(65280);
            var1.c(Char.getMyChar().cx1 - Code.kc_nhat, Char.getMyChar().cy1 - Code.kc_nhat, Code.kc_nhat << 1, Code.kc_nhat << 1, 0, 360);
         }

         for(var2 = 0; var2 < Effect2.a.size(); ++var2) {
            ((Effect2)Effect2.a.elementAt(var2)).a(var1);
         }

         for(var2 = 0; var2 < eo.size(); ++var2) {
            ((ItemTree)eo.elementAt(var2)).a(var1);
         }

         if (!GameCanvas.a) {
            for(var2 = 0; var2 < Effect2.d.size(); ++var2) {
               ((Effect2)Effect2.d.elementAt(var2)).a(var1);
            }
         }

         for(var2 = 0; var2 < vMobAttack.size(); ++var2) {
            vMobAttack.elementAt(var2);
         }

         var4 = var1;

         int var23;
         int var8;
         try {
            if ((var22 = af()) != -1) {
               Npc var25 = null;

               for(var8 = 0; var8 < vNpc.size(); ++var8) {
                  Npc var26;
                  if ((var26 = (Npc)vNpc.elementAt(var8)).npcTemplate.npcTemplateId == var22) {
                     if (var25 == null) {
                        var25 = var26;
                     } else if (Res.e(var26.cx1 - Char.getMyChar().cx1) < Res.e(var25.cx1 - Char.getMyChar().cx1)) {
                        var25 = var26;
                     }
                  }
               }

               if (var25 != null && var25.statusMe != 15 && (var25.cx1 <= p || var25.cx1 >= p + GameScr.i || var25.cy1 <= q || var25.cy1 >= q + j) && GameCanvas.w % 10 >= 5) {
                  var8 = var25.cx1 - Char.getMyChar().cx1;
                  var9 = var25.cy1 - Char.getMyChar().cy1;
                  int var27 = 0;
                  var2 = 0;
                  var23 = 0;
                  if (var8 > 0 && var9 >= 0) {
                     if (Res.e(var8) >= Res.e(var9)) {
                        var27 = GameScr.i - 10;
                        var2 = j / 2 + 30;
                        if (GameCanvas.g) {
                           var2 = j / 2 + 10;
                        }

                        var23 = 0;
                     } else {
                        var27 = GameScr.i / 2;
                        var2 = j - 10;
                        var23 = 5;
                     }
                  } else if (var8 >= 0 && var9 < 0) {
                     if (Res.e(var8) >= Res.e(var9)) {
                        var27 = GameScr.i - 10;
                        var2 = j / 2 + 30;
                        if (GameCanvas.g) {
                           var2 = j / 2 + 10;
                        }

                        var23 = 0;
                     } else {
                        var27 = GameScr.i / 2;
                        var2 = 10;
                        var23 = 6;
                     }
                  }

                  if (var8 < 0 && var9 >= 0) {
                     if (Res.e(var8) >= Res.e(var9)) {
                        var27 = 10;
                        var2 = j / 2 + 30;
                        if (GameCanvas.g) {
                           var2 = j / 2 + 10;
                        }

                        var23 = 3;
                     } else {
                        var27 = GameScr.i / 2;
                        var2 = j - 10;
                        var23 = 5;
                     }
                  } else if (var8 <= 0 && var9 < 0) {
                     if (Res.e(var8) >= Res.e(var9)) {
                        var27 = 10;
                        var2 = j / 2 + 30;
                        if (GameCanvas.g) {
                           var2 = j / 2 + 10;
                        }

                        var23 = 3;
                     } else {
                        var27 = GameScr.i / 2;
                        var2 = 10;
                        var23 = 6;
                     }
                  }

                  b(var4);
                  SmallImage.a(var4, 992, var27, var2, var23, StaticObj.g);
               }
            }
         } catch (Exception var17) {
         }

         var4 = var1;
         long var29;
         if (GameCanvas.g) {
            b(var1);
            this.bu();
            var18 = Char.getMyChar().cHP * me / Char.getMyChar().cMaxHP;
            var7 = Char.getMyChar().cMP * mf / Char.getMyChar().cMaxMP;
            var8 = (int)(Char.getMyChar().ae * (long)mg / exps[Char.getMyChar().cLevel]);
            if (var18 > me) {
               var18 = 0;
            }

            var1.a(-10585344);
            var1.c(0, md - 10, mg, 3);
            var1.a(-10427136);
            var1.c(0, md - 10, var8, 3);
            var1.a(-9756672);
            var1.c(0, md - 10, mg, 1);
            var1.c(0, md - 7, mg, 1);

            for(var9 = 0; var9 < 10; ++var9) {
               var4.c(var9 * mg / 10 - 1, md - 10, 1, 3);
            }

            var4.a(-1769452);
            var4.a(jf, mc - 1, md, 0);
            var4.c(mc, md, var18, 9);
            var4.a(-16755227);
            var4.a(jf, mc - 28, md + 13, 0);
            var4.c(mc, md + 16, var7, 7);
            var4.a(je, 0, md - 7, 0);
            mFont.s.a(var4, "" + Char.getMyChar().cHP, mc + me / 2 - 30, md + 1, 0);
            mFont.s.a(var4, "" + Char.getMyChar().cMP, mc + me / 2 - 30, md + 15, 0);
            mFont.o.a(var4, "" + Char.getMyChar().cLevel, mc - 27, md + 1, 2);
            var29 = 0L;
            if (Char.getMyChar().cExpDown > 0L) {
               var29 = Char.getMyChar().cExpDown * 10000L / exps[Char.getMyChar().cLevel];
            } else {
               var29 = Char.getMyChar().ae * 10000L / exps[Char.getMyChar().cLevel];
            }

            var2 = (int)(var29 % 100L);
            mFont.i.a(var4, (Char.getMyChar().cExpDown > 0L ? "-" + var29 / 100L : "" + var29 / 100L) + "." + (var2 < 10 ? "0" + var2 : "" + var2) + "%", mc - 27, md + 13, 2);
         }

         if (!Char.getMyChar().d) {
            this.h(var1);
            b(var1);
            this.g(var1);
            b(var1);
            TileMap.paintMiniMap(var1);
            // vị trí nút tab
            if (btnDoiTab != null) {
               int tw = 30;
               int th = 15;
               int tx = GameCanvas.aa - tw - 150;
               int ty = TileMap.posMiniMapY + TileMap.hMiniMap - 30;
               btnDoiTab.f = tx;
               btnDoiTab.g = ty;
               btnDoiTab.h = tw;
               btnDoiTab.i = th;
               var1.a(0x442200);
var1.c(tx, ty, tw, th);       // fillRect
var1.a(0x886633);
var1.b(tx, ty, tw, th);       // drawRect
               mFont.j.a(var1, "Tab", tx + tw / 2, ty + 3, 2);
            }
            var1.a(-var1.a(), -var1.b());
            if (!GameCanvas.g || GameCanvas.g && !GameCanvas.h) {
               var1.d(0, lx - 4, GameCanvas.aa, 100);
               var1.a(3612190);
               var1.c(mc - 44, md, 19, 19);
               var1.a(265220);
               var1.c(lz, lx + 35, mb, 1);
               var1.c(lz, lx + 33, mb, 1);
               var1.c(lz, lx + 30, mb, 1);
               var1.c(lz, lx + 28, mb, 1);
               var1.c(lz, lx + 26, mb, 1);
               var1.c(lz, lx + 12, mb, 1);
               var1.c(lz, lx + 24, mb, 1);
               var1.c(lz, lx + 18, mb, 1);
               var1.c(lz, lx + 16, mb, 1);
               var1.c(lz, lx + 2, mb, 1);
               var1.c(lz, lx + 4, mb, 1);
               var1.c(lz, lx + 6, mb, 1);
               var1.c(lz, lx + 14, mb, 1);
               var1.a(12562018);
               var1.c(lz, lx + 5, mb, 1);
               var1.c(lz, lx + 17, mb, 1);
               var1.c(lz, lx + 34, mb, 1);
               var1.c(lz, lx + 29, mb, 1);
               var1.a(14667167);
               var1.c(lz, lx + 3, mb, 1);
               var1.c(lz, lx + 15, mb, 1);
               var1.c(lz, lx + 27, mb, 1);
               var1.a(3355443);
               var1.c(lz, lx + 7, mb, 5);
               var1.c(lz, lx + 19, mb, 5);
               var1.c(lz, lx + 31, mb, 2);
               var1.a(12281361);
               var1.c(lz, lx + 25, mb, 1);
               var1.c(lz, lx + 13, mb, 1);
               var1.a(mi[0], 0, lx + 2, 0);
               var1.a(mi[1], 0 + ly, lx - 4, 24);
               if ((var16 = Char.getMyChar().cHP * me / Char.getMyChar().cMaxHP) > me) {
                  var16 = 0;
               }

               var1.a(7798784);
               var1.c(mc, md, var16, 2);
               var1.a(13369344);
               var1.c(mc, md + 1, var16, 4);
               if ((var16 = Char.getMyChar().cMP * me / Char.getMyChar().cMaxMP) > me) {
                  var16 = 0;
               }

               var1.a(4488);
               var1.c(mc, md + 12, var16, 2);
               var1.a(4573);
               var1.c(mc, md + 14, var16, mh - 2);
               var18 = (int)(Char.getMyChar().ae * (long)mg / exps[Char.getMyChar().cLevel]);
               var1.a(94373);
               var1.c(46, lx + 31, var18, 1);
               var1.a(65535);
               var1.c(46, lx + 32, var18, 1);
               mFont.p.a(var1, "" + Char.getMyChar().cLevel, 28, lx + 9, 2);
               var29 = 0L;
               if (Char.getMyChar().cExpDown > 0L) {
                  var29 = Char.getMyChar().cExpDown * 10000L / exps[Char.getMyChar().cLevel];
               } else {
                  var29 = Char.getMyChar().ae * 10000L / exps[Char.getMyChar().cLevel];
               }

               var9 = (int)(var29 % 100L);
               mFont.i.a(var1, (Char.getMyChar().cExpDown > 0L ? "-" + var29 / 100L : "" + var29 / 100L) + "." + (var9 < 10 ? "0" + var9 : "" + var9) + "%", 24, lx + 23, 2);
               mFont.r.a(var1, "" + mpPotion, ly - 11, lx + 6, 2);
               mFont.r.a(var1, "" + hpPotion, ly - 11, lx + 18, 2);
               mFont.s.a(var1, "" + Char.getMyChar().cHP, mc + me / 2, lx + 6, 2);
               mFont.s.a(var1, "" + Char.getMyChar().cMP, mc + me / 2, lx + 18, 2);
               if (Char.getMyChar().vSkillFight.size() > 0 && Char.getMyChar().myskill != null) {
                  var23 = lz - 28;
                  int var10002 = md + 7;
                  Char.getMyChar().myskill.a(var23, var10002, var1);
               }

               var1.a(9463099);
               var1.c(0, lx + 35, GameCanvas.aa, 1);
            } else {
               Paint.a(var1);
            }

            if (GameCanvas.g) {
               ha = true;
            }

            b(var1);
            this.j(var1);
            b(var1);
            var1.d(0, 0, GameCanvas.aa, GameCanvas.ab);

            for(var2 = 0; var2 < Effect2.c.size(); ++var2) {
               ((Effect2)Effect2.c.elementAt(var2)).a(var1);
            }

            b(var1);
            if (cr) {
               if (aw == 0) {
                  this.a(var1, TextGame.fg);
               }

               this.o(var1);
               this.ae(var1);
               if (aw == 3) {
                  label840: {
                     b(var1);
                     Paint.a(fe, fd, ff, fg, var1);
                     if (indexTitle == 1) {
                        var1.a(Paint.c);
                        var1.c(fe + 7, fd + 32, ff - 14, fg - 40);
                        var1.a(16777215);
                     } else {
                        var1.a(10249521);
                     }

                     var1.b(fe + 7, fd + 32, ff - 14, fg - 40);
                     a(var1, TextGame.fg[aw], true);
                     od = fe + 17;
                     oe = fd + 34;
                     mFont var30;
                     String var31;
                     if (GameCanvas.aa >= 320) {
                        gm = 20;
                        ba.a(gm, 12, fe, fd + 35, ff, fg - 44, true, 1);
                        ba.a(var1);
                        if (currentCharViewInfo == null) {
                           break label840;
                        }
                        int odLeft = fe + 10;
                        int odRight = fe + ff / 2 + 5;
                        var18 = oe;
                        mFont.e.a(var1, TextGame.ip[0] + currentCharViewInfo.displayName(), odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[1] + currentCharViewInfo.cPk, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[2] + currentCharViewInfo.cLevel, odLeft, var18, 0);
                        var18 += 12; mFont.h.a(var1, TextGame.ip[3] + currentCharViewInfo.nClass.b, odLeft, var18, 0);
                        var18 += 12; mFont.h.a(var1, TextGame.ip[4] + TextGame.kk[currentCharViewInfo.a()], odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[5] + currentCharViewInfo.cHP + "/" + currentCharViewInfo.cMaxHP, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[6] + currentCharViewInfo.cMP + "/" + currentCharViewInfo.cMaxMP, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[7] + currentCharViewInfo.b(), odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[8] + (currentCharViewInfo.cdame - currentCharViewInfo.cdame / 10) + "-" + currentCharViewInfo.cdame, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[9] + currentCharViewInfo.cResFire, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[10] + currentCharViewInfo.cResIce, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[11] + currentCharViewInfo.cResWind, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[12] + currentCharViewInfo.cdameDown, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[13] + currentCharViewInfo.cExactly, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[14] + currentCharViewInfo.cMiss, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[15] + currentCharViewInfo.cFatal, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[16] + currentCharViewInfo.cReactDame, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[17] + currentCharViewInfo.sysUp, odLeft, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.ip[18] + currentCharViewInfo.sysDown, odLeft, var18, 0);
                        var18 = oe;
                        mFont.e.a(var1, TextGame.is[15] + (currentCharViewInfo.cClanName.equals("") ? TextGame.hp : currentCharViewInfo.cClanName), odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[0] + currentCharViewInfo.pointUydanh, odRight, var18, 0);
                        var18 += 12; mFont.h.a(var1, TextGame.is[11] + currentCharViewInfo.countFinishDay + "/20", odRight, var18, 0);
                        var18 += 12; mFont.h.a(var1, TextGame.is[12] + currentCharViewInfo.countLoopBoos + TextGame.iq, odRight, var18, 0);
                        var18 += 12; mFont.h.a(var1, TextGame.is[16] + currentCharViewInfo.countPB + TextGame.iq, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[13] + currentCharViewInfo.limitTiemnangso, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[14] + currentCharViewInfo.limitKynangso, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[18] + currentCharViewInfo.ax + TextGame.iq, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[19] + currentCharViewInfo.ay + TextGame.iq, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[17] + currentCharViewInfo.as, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[1] + currentCharViewInfo.pointVukhi, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[2] + currentCharViewInfo.pointLien, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[3] + currentCharViewInfo.pointNhan, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[4] + currentCharViewInfo.pointNgocboi, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[5] + currentCharViewInfo.pointPhu, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[6] + currentCharViewInfo.pointNon, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[7] + currentCharViewInfo.pointAo, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[8] + currentCharViewInfo.pointGangtay, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[9] + currentCharViewInfo.pointQuan, odRight, var18, 0);
                        var18 += 12; mFont.i.a(var1, TextGame.is[10] + currentCharViewInfo.pointGiay, odRight, var18, 0);
                        var1.a(10249521);
                        var1.b(fe + ff / 2, fd + 32, 1, fg - 40);
                     } else {
                        ba.a(gm, 12, fe, fd + 35, ff, fg - 44, true, 1);
                        ba.a(var1);
                        if (jt == 0) {
                           gm = 19;
                           var18 = oe;
                           if (currentCharViewInfo == null) {
                              break label840;
                           }
                           mFont.e.a(var1, TextGame.ip[0] + currentCharViewInfo.displayName(), od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[1] + currentCharViewInfo.cPk; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[2] + currentCharViewInfo.cLevel; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.h; var31 = TextGame.ip[3] + currentCharViewInfo.nClass.b; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.h; var31 = TextGame.ip[4] + TextGame.kk[currentCharViewInfo.a()]; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[5] + currentCharViewInfo.cHP + "/" + currentCharViewInfo.cMaxHP; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[6] + currentCharViewInfo.cMP + "/" + currentCharViewInfo.cMaxMP; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[7] + currentCharViewInfo.b(); var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[8] + (currentCharViewInfo.cdame - currentCharViewInfo.cdame / 10) + "-" + currentCharViewInfo.cdame; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[9] + currentCharViewInfo.cResFire; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[10] + currentCharViewInfo.cResIce; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[11] + currentCharViewInfo.cResWind; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[12] + currentCharViewInfo.cdameDown; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[13] + currentCharViewInfo.cExactly; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[14] + currentCharViewInfo.cMiss; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[15] + currentCharViewInfo.cFatal; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[16] + currentCharViewInfo.cReactDame; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[17] + currentCharViewInfo.sysUp; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.ip[18] + currentCharViewInfo.sysDown; var18 += 12; var30.a(var1, var31, od, var18, 0);
                        } else if (jt == 1) {
                           gm = 20;
                           var18 = oe;
                           if (currentCharViewInfo == null) {
                              break label840;
                           }
                           mFont.e.a(var1, TextGame.is[15] + (currentCharViewInfo.cClanName.equals("") ? TextGame.hp : currentCharViewInfo.cClanName), od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[0] + currentCharViewInfo.pointUydanh; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.h; var31 = TextGame.is[11] + currentCharViewInfo.countFinishDay + "/20"; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.h; var31 = TextGame.is[12] + currentCharViewInfo.countLoopBoos + TextGame.iq; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.h; var31 = TextGame.is[16] + currentCharViewInfo.countPB + TextGame.iq; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[13] + currentCharViewInfo.limitTiemnangso; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[14] + currentCharViewInfo.limitKynangso; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[18] + currentCharViewInfo.ax + TextGame.iq; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[19] + currentCharViewInfo.ay + TextGame.iq; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[17] + currentCharViewInfo.as; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[1] + currentCharViewInfo.pointVukhi; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[2] + currentCharViewInfo.pointLien; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[3] + currentCharViewInfo.pointNhan; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[4] + currentCharViewInfo.pointNgocboi; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[5] + currentCharViewInfo.pointPhu; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[6] + currentCharViewInfo.pointNon; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[7] + currentCharViewInfo.pointAo; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[8] + currentCharViewInfo.pointGangtay; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[9] + currentCharViewInfo.pointQuan; var18 += 12; var30.a(var1, var31, od, var18, 0);
                           var30 = mFont.i; var31 = TextGame.is[10] + currentCharViewInfo.pointGiay; var18 += 12; var30.a(var1, var31, od, var18, 0);
                        }
                        if (indexTitle == 1 && av >= 0) {
                           SmallImage.a(var1, 942, od - 8, oe + 2 + av * 12, 0, StaticObj.b);
                        }
                     }
                  }
               }

               this.k(var1);
               this.l(var1);
               this.ax(var1);
            } else if (aa()) {
               if (hb) {
                  if (aw == 0) {
                     this.a(var1, TextGame.gb, bu);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.gb, bx);
                  } else if (aw == 2) {
                     this.a(var1, TextGame.gb, by);
                  } else if (aw == 3) {
                     this.a(var1, TextGame.gb, bw);
                  } else if (aw == 52) {
                     this.b(var1, by);
                  }
               }

               if (hd) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bb);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fi);
                  }
               }

               if (he) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bc);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fi);
                  }
               }

               if (hf) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bd);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fj);
                  }
               }

               if (hg) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, be);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fj);
                  }
               }

               if (hh) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bf);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fk);
                  }
               }

               if (hi) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bg);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fk);
                  }
               }

               if (hj) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bh);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fl);
                  }
               }

               if (hk) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fl, bi);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fl);
                  }
               }

               if (hl) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bj);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fm);
                  }
               }

               if (hm) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fh, bk);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fm);
                  }
               }

               if (hn) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fn, bl);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fn);
                  }
               }

               if (ho) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fo, bm);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fo);
                  }
               }

               if (hp) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fp, bn);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fp);
                  }
               }

               if (hq) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fq, bo);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fq);
                  }
               }

               if (hr) {
                  if (aw == 0) {
                     this.a(var1, TextGame.fr, bp);
                  } else if (aw == 1) {
                     this.a(var1, TextGame.fr);
                  }
               }

               if (hc) {
                  this.a(var1, TextGame.gc, bv);
               }

               this.p(var1);
               this.q(var1);
               this.r(var1);
               this.s(var1);
               this.t(var1);
               this.u(var1);
               this.v(var1);
               this.aj(var1);
               this.w(var1);
               this.x(var1);
               this.y(var1);
               this.z(var1);
               this.ab(var1);
               this.ac(var1);
               this.ad(var1);
               this.aa(var1);
               this.ar(var1);
               this.as(var1);
               this.at(var1);
               this.aw(var1);
               this.au(var1);
               this.av(var1);
               this.drawItemDel(var1);
               this.drawItemPick(var1);
            } else if (id) {
               this.af(var1);
            }

            this.d(var1);
            this.al(var1);
            this.f(var1);
            this.ai(var1);
            this.ah(var1);
            this.ak(var1);
            this.e(var1);
            this.m(var1);
            this.am(var1);
            this.ao(var1);
            b(var1);
            if (GameCanvas.g && GameCanvas.aa >= 320) {
               if (super.a != null && super.a != this.ka) {
                  super.a.f = GameCanvas.aa / 2 - 160;
                  super.a.g = GameCanvas.ab - 26;
               }

               if (super.b != null) {
                  super.b.f = GameCanvas.aa / 2 - 35;
                  super.b.g = GameCanvas.ab - 26;
               }

               if (super.c != null && super.c != this.ge) {
                  super.c.f = GameCanvas.aa / 2 + 88;
                  super.c.g = GameCanvas.ab - 26;
               }
            }
         }

         super.a(var1);
         if (GameCanvas.g && GameCanvas.h) {
            this.i(var1);
            ha = true;
         }

         c(var1);
         b(var1);
         this.ag(var1);
         b(var1);
         this.ap(var1);
         b(var1);
         Info.a(var1);
         b(var1);
         ChatTextField.a().a(var1);
         b(var1);
         InfoMe.a(var1);
      }

   }

   private void d(mGraphics var1) {
      if (ct) {
         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         if (indexTitle == 1) {
            var1.a(Paint.c);
            var1.c(fe + 7, fd + 32, ff - 14, fg - 55);
            var1.a(16777215);
         } else {
            var1.a(10249521);
         }

         var1.b(fe + 7, fd + 32, ff - 14, fg - 55);
         a(var1, TextGame.nr[7], false);
         od = fe + 17;
         oe = fd + 45;
         gm = 30;
         ba.a(gm, 30, fe, fd + 39, ff, fg - 63, true, 1);
         ba.a(var1);
         int var2 = oe;
         a(var1, TextGame.qz[0], Char.dunghp, Char.ds + "%", od, var2);
         var2 += 30;
         a(var1, TextGame.qz[1], Char.dungmp, Char.dt + "%", od, var2);
         var2 += 30;
         a(var1, TextGame.qz[2], Char.dungthucan, String.valueOf(Char.du), od, var2);
         var2 += 30;
         a(var1, TextGame.qz[3], Char.dunghotro, "", od, var2);
         var2 += 30;
         a(var1, "Nhặt yên", Char.nhat_yen, "", od, var2);
         var2 += 30;
         a(var1, "Nhặt HP, MP", Char.nhat_hpmp, "LV: " + Char.lv_hpmp, od, var2);
         var2 += 30;
         a(var1, "Nhặt đá", Char.nhat_da, "LV: " + Char.lv_da, od, var2);
         var2 += 30;
         a(var1, "Luyện đá", Char.luyen_da, "LV: " + Char.lv_luyenda, od, var2);
         var2 += 30;
         a(var1, "Nhặt Trang bị", Char.nhat_tbi, "LV: " + Char.lv_tbi, od, var2);
         var2 += 30;
         a(var1, "Nhặt VP nhiệm vụ", Char.nhat_vpnv, "", od, var2);
         var2 += 30;
         a(var1, "Nhặt SVC", Char.nhat_svc, "", od, var2);
         var2 += 30;
         a(var1, "Nhặt tất cả", Char.nhat_all, "", od, var2);
         var2 += 30;
         a(var1, "Remap", Char.remap, "", od, var2);
         var2 += 30;
         a(var1, "Auto mua thức ăn", Char.automuathucan, "", od, var2);
         var2 += 30;
         a(var1, "Tự sát hết MP", Char.tusathetmp, "", od, var2);
         var2 += 30;
         a(var1, "Auto Reconnect", Char.reconnect, "", od, var2);
         var2 += 30;
         a(var1, "Chuyển map hết boss", Char.chuyenmap, "", od, var2);
         var2 += 30;
         a(var1, "Săn TATL", Char.santatl, "", od, var2);
         var2 += 30;
         a(var1, "Đánh quái thường", Char.quaithuong, "", od, var2);
         var2 += 30;
         a(var1, "Đánh tinh anh", Char.quaitinhanh, "", od, var2);
         var2 += 30;
         a(var1, "Đánh thủ lĩnh", Char.quaithulinh, "", od, var2);
         var2 += 30;
         a(var1, "Né PK", Char.nepk, "", od, var2);
         var2 += 30;
         a(var1, "Đánh theo nhóm", Char.danhtheonhom, "", od, var2);
         var2 += 30;
         a(var1, "Luyện TTTT", Char.autottt, "", od, var2);
         var2 += 30;
         a(var1, "Luyện TTTC", Char.autottc, "", od, var2);
         var2 += 30;
         a(var1, "Auto cổ lệnh", Char.autocl, "", od, var2);
         var2 += 30;
         a(var1, "Auto mua cổ lệnh", Char.automuacl, "", od, var2);
         var2 += 30;
         a(var1, "Dùng phân thân", Char.dung_pthan, "", od, var2);
         var2 += 30;
         a(var1, "C\u1ed9ng ti\u1ec1m n\u0103ng", Char.autoCongTiemNang, "", od, var2);
         var2 += 30;
         a(var1, "C\u1ed9ng k\u1ef9 n\u0103ng", Char.autoCongKyNang, "", od, var2);
         if (indexTitle == 1 && av >= 0 && !GameCanvas.g) {
            SmallImage.a(var1, 942, od - 8, oe + 2 + av * 30, 0, StaticObj.b);
         }

         b(var1);
         mFont.n.a(var1, GameCanvas.g ? TextGame.rb : TextGame.ra, fe + ff / 2, fd + fg - 17, 2);
      }

   }

   private static void a(mGraphics var0, String var1, boolean var2, String var3, int var4, int var5) {
      var0.a(16777215);
      var0.c(var4, var5, 12, 12);
      if (var2) {
         var0.a(9650442);
         var0.a(var4 + 2, var5 + 2, var4 + 2 + 7, var5 + 2 + 7);
         var0.a(var4 + 2, var5 + 2 + 7, var4 + 2 + 7, var5 + 2);
      }

      mFont var6;
      (var6 = var2 ? mFont.i : mFont.k).a(var0, var1, var4 + 18, var5, 0);
      if (!var3.equals("")) {
         var0.a(Paint.b);
         var0.c(var4 + 115, var5 - 3, 30, 20);
         var0.a(var2 ? 16777215 : 0);
         var0.b(var4 + 115, var5 - 3, 30, 20);
         var6.a(var0, var3, var4 + 133, var5 + 2, 2);
      }

   }

   private void e(mGraphics var1) {
      if (gy) {
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.de, false);
         od = fe + 5;
         oe = fd + 40;
         if (vList.size() == 0) {
            mFont.i.a(var1, TextGame.no, fe + ff / 2, fd + 40, 2);
            return;
         }

         var1.a(-16770791);
         var1.c(od - 2, oe - 2, ff - 6, indexSize * 5 + 8);
         b(var1);
         ba.a(vList.size(), indexSize, od, oe, ff - 3, indexSize * 5 + 4, true, 1);
         ba.a(var1, od, oe, ff - 3, indexSize * 5 + 6);
         gm = vList.size();

         for(int var4 = 0; var4 < vList.size(); ++var4) {
            DunItem var2 = null;

            try {
               var2 = (DunItem)vList.elementAt(var4);
            } catch (Exception var5) {
            }

            if (var2 != null) {
               if (av == var4) {
                  var1.a(Paint.b);
                  var1.c(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(16777215);
                  var1.b(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
               } else {
                  var1.a(Paint.a);
                  var1.c(od + 2, oe + var4 * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(13932896);
                  var1.b(od + 2, oe + var4 * indexSize + 2, ff - 15, indexSize - 4);
               }

               mFont.j.a(var1, var2.b, od + (ff - 10) / 2 - ff / 4, oe + var4 * indexSize + indexSize / 2 - 6, 2);
               mFont.a.a(var1, " vs ", od + (ff - 10) / 2, oe + var4 * indexSize + indexSize / 2 - 6, 2);
               mFont.j.a(var1, var2.c, od + (ff - 10) / 2 + ff / 4, oe + var4 * indexSize + indexSize / 2 - 6, 2);
            }
         }

         n(var1);
      }

   }

   private void f(mGraphics var1) {
      if (ic) {
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.de, false);
         od = fe + 5;
         oe = fd + 40;
         if (vCharInMap.size() == 0) {
            mFont.i.a(var1, TextGame.lg, fe + ff / 2, fd + 40, 2);
            return;
         }

         var1.a(-16770791);
         var1.c(od - 2, oe - 2, ff - 6, indexSize * 5 + 8);
         b(var1);
         ba.a(vCharInMap.size(), indexSize, od, oe, ff - 3, indexSize * 5 + 4, true, 1);
         ba.a(var1, od, oe, ff - 3, indexSize * 5 + 6);
         gm = vCharInMap.size();

         for(int var2 = 0; var2 < vCharInMap.size(); ++var2) {
            Char var3 = null;

            try {
               if ((var3 = (Char)vCharInMap.elementAt(var2)).ab()) {
                  continue;
               }
            } catch (Exception var5) {
            }

            if (var3 != null) {
               if (av == var2) {
                  var1.a(Paint.b);
                  var1.c(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(16777215);
                  var1.b(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
               } else {
                  var1.a(Paint.a);
                  var1.c(od + 2, oe + var2 * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(13932896);
                  var1.b(od + 2, oe + var2 * indexSize + 2, ff - 15, indexSize - 4);
               }

               SmallImage.a(var1, 647, od + 12, oe + var2 * indexSize + indexSize / 2, 0, 3);
               if (this.dm > 0 && this.dm == var3.idChar) {
                  mFont.j.a(var1, var3.displayName() + " - " + TextGame.dv + ": " + var3.cLevel, od + 22, oe + var2 * indexSize + indexSize / 2 - 6, 0);
               } else if (var3.statusMe == 14) {
                  mFont.k.a(var1, var3.displayName() + " - " + TextGame.dv + ": " + var3.cLevel, od + 22, oe + var2 * indexSize + indexSize / 2 - 6, 0);
               } else {
                  mFont.n.a(var1, var3.displayName() + " - " + TextGame.dv + ": " + var3.cLevel, od + 22, oe + var2 * indexSize + indexSize / 2 - 6, 0);
               }
            }
         }

         n(var1);
      }

   }

   private void g(mGraphics var1) {
      try {
         int var2 = (int)(System.currentTimeMillis() / 1000L);
         int var4 = 5;
         if (GameCanvas.g && GameCanvas.h) {
            var4 = 45 + Info.a;
         }

         if (GameCanvas.i && Char.getMyChar().vSkillFight.size() > 4) {
            var4 += 25;
         }

         b(var1);
         int var8;
         if (!GameCanvas.j) {
            for(int var5 = 0; var5 < Char.getMyChar().by.size(); ++var5) {
               Effect var7 = (Effect)Char.getMyChar().by.elementAt(var5);
               SmallImage.a(var1, var7.e.c, GameCanvas.aa - 13 - (var5 * 13 << 1), var4 + 14, 0, 33);
               if ((var8 = var7.c - (var2 - var7.b)) >= 0) {
                  mFont.i.a(var1, NinjaUtil.b(var8), GameCanvas.aa - 13 - (var5 * 13 << 1), var4 + 15, 2, mFont.k);
               }
            }

            var8 = this.eg - (var2 - this.eh);
            if (Char.getMyChar().by.size() > 0) {
               var4 += 27;
            }

            if (var8 > 0) {
               mFont.i.a(var1, TextGame.df + ": " + NinjaUtil.b(var8), GameCanvas.aa - 2, var4, 1, mFont.k);
               var4 += 12;
            }

            if (TileMap.bgID == 1) {
               mFont.i.a(var1, TextGame.dg + ": " + Char.getMyChar().de, GameCanvas.aa - 2, var4, 1, mFont.k);
               var4 += 12;
               mFont.i.a(var1, TextGame.dh + ": " + Char.getMyChar().df, GameCanvas.aa - 2, var4, 1, mFont.k);
               var4 += 12;
            } else if (TileMap.bgID != 2 && TileMap.mapID != 114 && TileMap.mapID != 115 && TileMap.mapID != 116) {
               if (TileMap.bgID == 3) {
                  mFont.i.a(var1, TextGame.di + ": " + Char.dy, GameCanvas.aa - 2, var4, 1, mFont.k);
                  var4 += 12;
                  mFont.i.a(var1, TextGame.ir[Char.z()], GameCanvas.aa - 2, var4, 1, mFont.k);
                  var4 += 12;
               }
            } else {
               mFont.i.a(var1, TextGame.di + ": " + Char.dx, GameCanvas.aa - 2, var4, 1, mFont.k);
               var4 += 12;
            }
         }

         if (vParty.size() > 0 && GameCanvas.aa > 128 && !aa()) {
            var4 -= 18;

            for(var8 = 0; var8 < vParty.size(); ++var8) {
               Party var9;
               if ((var9 = (Party)vParty.elementAt(var8)).f != null) {
                  mFont var10000 = mFont.i;
                  String var10002 = ChatManager.hideAuthor(var9.d) + "(" + var9.f.cLevel + ")";
                  int var10003 = GameCanvas.aa - 14;
                  var4 += 18;
                  var10000.a(var1, var10002, var10003, var4, 1, mFont.k);
                  var9.f.a(var1, GameCanvas.aa - 41, var4 + 12);
                  SmallImage.a(var1, var9.c, GameCanvas.aa - 7, var4 + 9, 0, 3);
               } else {
                  var4 += 16;
                  mFont.n.a(var1, var9.d, GameCanvas.aa - 14, var4 + 5, 1, mFont.k);
                  SmallImage.a(var1, var9.c, GameCanvas.aa - 7, var4 + 11, 0, 3);
               }
            }

            return;
         }
      } catch (Exception var9) {
      }

   }

   public static void b(mGraphics var0) {
      var0.a(-var0.a(), -var0.b());
      var0.d(0, -200, GameCanvas.aa, 200 + GameCanvas.ab);
   }

   private void h(mGraphics var1) {
      try {
         if (!GameCanvas.af.a && !InfoDlg.a && !cg()) {
            int var3 = -7;
            int var2 = 3;
            if ((!GameCanvas.g || GameCanvas.g && !GameCanvas.h) && ha) {
               var2 += 30;
            }

            if (GameCanvas.g) {
               var3 = 38 + Info.a;
               if (GameCanvas.i) {
                  var3 += 35;
               }
            }

            var1.a(-var1.a(), -var1.b());
            int var9;
            mFont var10000;
            String var10002;
            int var6;
            if (GameCanvas.j) {
               int var4 = (int)(System.currentTimeMillis() / 1000L);

               for(var6 = 0; var6 < Char.getMyChar().by.size(); ++var6) {
                  Effect var5 = (Effect)Char.getMyChar().by.elementAt(var6);
                  SmallImage.a(var1, var5.e.c, var2 + 13 + (var6 * 13 << 1), var3 + 27, 0, 33);
                  if ((var9 = var5.c - (var4 - var5.b)) >= 0) {
                     mFont.i.a(var1, NinjaUtil.b(var9), var2 + 13 + (var6 * 13 << 1), var3 + 28, 2, mFont.k);
                  }
               }

               var9 = this.eg - (var4 - this.eh);
               if (Char.getMyChar().by.size() > 0) {
                  var3 += 27;
               }

               if (var9 > 0) {
                  var10000 = mFont.i;
                  var10002 = TextGame.df + ": " + NinjaUtil.b(var9);
                  var3 += 12;
                  var10000.a(var1, var10002, var2, var3, 0, mFont.k);
               }
            }

            String var8;
            if (Char.getMyChar().cLevel <= 20) {
               if (Char.getMyChar().pPoint > 0) {
                  var8 = "+" + Char.getMyChar().pPoint + " " + TextGame.da;
                  var3 += 12;
                  mFont.j.a(var1, var8, var2, var3, 0, mFont.k);
               }

               if (Char.getMyChar().sPoint > 0) {
                  var8 = "+" + Char.getMyChar().sPoint + " " + TextGame.db;
                  var3 += 12;
                  mFont.j.a(var1, var8, var2, var3, 0, mFont.k);
               }
            }

if (Code.mode != null) {
                  var3 += 12;
               String modeLine = Code.mode instanceof AutoBuff ? "ĐANG AUTO BUFF" : Code.mode.toString().toUpperCase();
               mFont.j.a(var1, modeLine, var2, var3, 0, mFont.k);
               if (AutoMapKhu.showUpInfo) {
                  long yenTotal = (long)Char.getMyChar().yen - (long)Code.mode.yen_before;
                  int elapsedSec = (int)((System.currentTimeMillis() - Code.mode.time_start_auto) / 1000L);
                  int totalMin = elapsedSec / 60;
                  long yenPerH = elapsedSec > 0 ? yenTotal * 3600L / elapsedSec : 0L;
                  int pctPerHx100 = 0;
                  if (elapsedSec > 0 && exps[Char.getMyChar().cLevel] > 0L) {
                     long expDelta = Char.getMyChar().cEXP - Code.mode.level_before;
                     long expPerH = expDelta * 3600L / elapsedSec;
                     pctPerHx100 = (int)(expPerH * 10000L / exps[Char.getMyChar().cLevel]);
                  }
                  String s = formatDot(yenPerH) + "/h - "
                          + (pctPerHx100 / 100) + "." + pad2(pctPerHx100 % 100) + "%/h - "
                          + formatDot(yenTotal) + "/" + totalMin + "p";
                  int infoY = md + 25;
                  mFont.h.a(var1, s, mc, infoY, 0, mFont.k);
                  // [FIX 15] hiển thị ngưỡng HP remap ngay dưới dòng info up
                  if (MenuPro.hpOffPk > 0) {
                     mFont.m.a(var1, "HP Off PK: " + MenuPro.hpOffPk + "%", mc, infoY + 12, 0, mFont.k);
                  }
               }
            } else if (Code.giuKetNoi) {
               var3 += 12;
               if (Code.giuKetNoiMode == 1) {
                  long elapsed = System.currentTimeMillis() - Code.lastGknKeepAlive;
                  long remaining = 600000L - elapsed;
                  if (remaining < 0) remaining = 0;
                  int totalSec = (int)(remaining / 1000L);
                  int mins = totalSec / 60;
                  int secs = totalSec % 60;
                  String countdownStr = mins > 0 ? mins + "p" + secs + "s" : secs + "s";
                  mFont.j.a(var1, "AUTO KẾT NỐI " + countdownStr, var2, var3, 0, mFont.k);
               } else {
                  mFont.j.a(var1, "AUTO KẾT NỐI (TẠI CHỖ)", var2, var3, 0, mFont.k);
               }
            }

            if (Code.pkam) {
               var3 += 12;
               String pkamLabel = "AUTO PK ÂM: ";
               mFont.j.a(var1, pkamLabel, var2, var3, 0, mFont.k);
               mFont.l.a(var1, menu_pkam.ptpk + "%", var2 + mFont.j.a(pkamLabel), var3, 0, mFont.k);
            }
            if (MenuHangDong.autohd) {
               var3 += 12;
               mFont.j.a(var1, "AUTO HD: " + MenuHangDong.gio_hd + "h" + MenuHangDong.phut_hd + "p/" + (MenuHangDong.autohd_lbhd ? MenuHangDong.gio_hd_lbhd + "h" + MenuHangDong.phut_hd_lbhd + "p" : "TẮT") + (MenuHangDong.layRuong ? " [RƯƠNG]" : "") + (MenuHangDong.theoNhom ? " [NHÓM]" : ""), var2, var3, 0, mFont.k);
            }
            if (KichYen.active) {
               var3 += 12;
               mFont.j.a(var1, "KÍCH YÊN: BẬT", var2, var3, 0, mFont.k);
            }
            if (CaiGom.enabled) {
               String gomLine = "AUTO GOM: " + CaiGom.gioNhan + "h" + CaiGom.phutNhan + "p";
               if (Code.mode instanceof AutoGom) gomLine += " [ĐI GOM]";
               else if (Code.mode instanceof AutoGomNhan) gomLine += " [NHẬN]";
               var3 += 12;
               mFont.j.a(var1, gomLine, var2, var3, 0, mFont.k);
            }
            if (Code.danhTheoID) {
               var3 += 12;
               String ids = "";
               for (int qi = 0; qi < Code.mobIDFilter.length; qi++) {
                  if (Code.mobIDFilter[qi] > 0) {
                     if (ids.length() > 0) ids += ",";
                     ids += Code.mobIDFilter[qi];
                  }
               }
               if (ids.length() == 0) ids = "KHÔNG ƯU TIÊN";
               mFont.j.a(var1, "QUÁI ƯU TIÊN(ID): " + ids, var2, var3, 0, mFont.k);
            }
            // Hien thi trang thai Danh Vong
            if (FormDanhVong.isADanhVong && !(Code.mode instanceof AutoDanhVong)) {
               var3 += 12;
               String dvTime = (FormDanhVong.advAH < 10 ? "0" : "") + FormDanhVong.advAH
                             + "h" + (FormDanhVong.advAI < 10 ? "0" : "") + FormDanhVong.advAI;
               mFont.j.a(var1, "AUTO DV: " + dvTime, var2, var3, 0, mFont.k);
            }
            if (Code.isAutoNVHN && !(Code.mode instanceof AutoNVHN)) {
               var3 += 12;
               String nvhnTime = (Code.nvhnHour < 10 ? "0" : "") + Code.nvhnHour
                               + "h" + (Code.nvhnMin < 10 ? "0" : "") + Code.nvhnMin;
               mFont.j.a(var1, "AUTO NVHN: " + nvhnTime, var2, var3, 0, mFont.k);
            }
            if (Code.autoMuaItem) {
               var3 += 12;
               String muaName = "";
               if (Code.muaItemID > 0) {
                  ItemTemplate tpl = ItemTemplates.a((short) Code.muaItemID);
                  if (tpl != null && tpl.name != null) muaName = tpl.name;
               }
               mFont.j.a(var1, "AUTO MUA: " + (muaName.length() > 0 ? muaName : Code.muaItemID), var2, var3, 0, mFont.k);
            }
            if (Code.autoOnOff) {
               var3 += 12;
               String offT = (Code.onoffOffHour < 10 ? "0" : "") + Code.onoffOffHour + "h" + (Code.onoffOffMin < 10 ? "0" : "") + Code.onoffOffMin;
               String onT = (Code.onoffOnHour < 10 ? "0" : "") + Code.onoffOnHour + "h" + (Code.onoffOnMin < 10 ? "0" : "") + Code.onoffOnMin;
               mFont.j.a(var1, "AUTO ON/OFF: " + onT + "/" + offT, var2, var3, 0, mFont.k);
            }
            if (Code.isADapDo) {
               var3 += 12;
               String hudDapDo = "AUTO ĐẬP ĐỒ: +" + Code.CapDoValue;
               if (Code.dapDoHoldActive) {
                  long elapsed = (System.currentTimeMillis() - Code.dapDoLastProgressTime) / 1000L;
                  hudDapDo += " | HOLD " + elapsed + "s";
               }
               mFont.j.a(var1, hudDapDo, var2, var3, 0, mFont.k);
            }
            if (Code.dcvt) {
               var3 += 12;
               mFont.j.a(var1, "VỊ TRÍ: " + (Code.index_dcvt + 1) + "/" + Code.x_dcvt[TileMap.mapID].size(), var2, var3, 0, mFont.k);
            }

            if (ChatManager.d().g.size() > 0) {
               this.ju[0] = var2;
               this.jv[0] = var3 + 12;
               var8 = "+" + ChatManager.d().g.size() + " " + TextGame.cv;
               if (GameCanvas.w % 10 > 4) {
                  var3 += 12;
                  mFont.l.a(var1, var8, var2, var3, 0, mFont.k);
               } else {
                  var3 += 12;
                  mFont.j.a(var1, var8, var2, var3, 0, mFont.k);
               }
            }

            if (ChatManager.e || ChatManager.f) {
               var8 = "";
               this.ju[1] = var2;
               this.jv[1] = var3 + 12;
               if (ChatManager.e && ChatManager.f) {
                  var8 = TextGame.cw[0];
               } else if (ChatManager.e) {
                  var8 = TextGame.cw[1];
               } else if (ChatManager.f) {
                  var8 = TextGame.cw[2];
               }

               if (GameCanvas.w % 10 > 7) {
                  var3 += 12;
                  mFont.l.a(var1, var8, var2, var3, 0, mFont.k);
               } else {
                  var3 += 12;
                  mFont.j.a(var1, var8, var2, var3, 0, mFont.k);
               }
            }

            if (TileMap.bgID == 3) {
               if (Char.getMyChar().charFocus != null) {
                  if (Char.getMyChar().charFocus.cTypePk == 4) {
                     var3 += 12;
                     mFont.i.a(var1, TextGame.hz, var2, var3, 0, mFont.k);
                  } else if (Char.getMyChar().charFocus.cTypePk == 5) {
                     var3 += 12;
                     mFont.i.a(var1, TextGame.ia, var2, var3, 0, mFont.k);
                  } else if (Char.getMyChar().charFocus.cTypePk == 6) {
                     var3 += 12;
                     mFont.i.a(var1, TextGame.ib, var2, var3, 0, mFont.k);
                  }
               } else if (Char.getMyChar().mobFocus != null) {
                  if (Char.getMyChar().mobFocus.s == 96) {
                     var3 += 12;
                     mFont.i.a(var1, TextGame.ia, var2, var3, 0, mFont.k);
                  } else if (Char.getMyChar().mobFocus.s == 97) {
                     var3 += 12;
                     mFont.i.a(var1, TextGame.hz, var2, var3, 0, mFont.k);
                  } else if (Char.getMyChar().mobFocus.s == 93) {
                     var3 += 12;
                     mFont.i.a(var1, TextGame.ib, var2, var3, 0, mFont.k);
                  } else {
                     var3 += 12;
                     mFont.i.a(var1, TextGame.ic, var2, var3, 0, mFont.k);
                  }
               }
            } else if (Char.getMyChar().aa()) {
               if (Char.getMyChar().ca == null) {
                  byte var11;
                  if ((var11 = ae()) >= 0) {
                     var10000 = mFont.i;
                     var10002 = TextGame.hy + " " + TileMap.u[var11];
                     var3 += 12;
                     var10000.a(var1, var10002, var2, var3, 0, mFont.k);
                  }
               } else {
                  var8 = Char.getMyChar().ca.e[Char.getMyChar().ca.a];

                  for(var9 = 0; var8 == null; var8 = Char.getMyChar().ca.e[Char.getMyChar().ca.a - var9]) {
                     ++var9;
                  }

                  if (Char.getMyChar().ca.b[Char.getMyChar().ca.a] != -1) {
                     var8 = var8 + " " + Char.getMyChar().ca.f + "/" + Char.getMyChar().ca.b[Char.getMyChar().ca.a];
                  }

                  if (GameCanvas.x > 0 && GameCanvas.w % 10 > 4) {
                     var3 += 12;
                     mFont.j.a(var1, var8, var2, var3, 0, mFont.k);
                  } else {
                     var3 += 12;
                     mFont.i.a(var1, var8, var2, var3, 0, mFont.k);
                  }
               }
            }

            if (Char.getMyChar().mobFocus != null) {
               MobTemplate var12 = Char.getMyChar().mobFocus.c();
               String var10 = var12.g + " id:" + Char.getMyChar().mobFocus.s + " lv" + Char.getMyChar().mobFocus.level;
               if (Char.getMyChar().mobFocus.s != 0 && Char.getMyChar().mobFocus.s != 142 && Char.getMyChar().mobFocus.s != 143) {
                  var10 = var10 + ": " + Char.getMyChar().mobFocus.hp + "/" + Char.getMyChar().mobFocus.maxHp;
               }

               var1.a(Char.getMyChar().mobFocus.e());
               var3 += 12;
               var1.c(var2, var3 + 3, 5, 5);
               var1.a(0);
               var1.b(var2, var3 + 3, 5, 5);
               mFont.i.a(var1, var10, var2 + 12, var3, 0, mFont.k);
            } else if (Char.getMyChar().npcFocus != null) {
               var3 += 12;
               mFont.j.a(var1, Char.getMyChar().npcFocus.npcTemplate.name, var2, var3, 0, mFont.k);
            } else if (Char.getMyChar().charFocus != null) {
               var1.a(Char.getMyChar().charFocus.t());
               var3 += 12;
               var1.c(var2, var3 + 3, 5, 5);
               var1.a(0);
               var1.b(var2, var3 + 3, 5, 5);
               mFont.i.a(var1, Char.getMyChar().charFocus.cName + " lv" + Char.getMyChar().charFocus.cLevel + ": " + Char.getMyChar().charFocus.cHP + "/" + Char.getMyChar().charFocus.cMaxHP, var2 + 12, var3, 0, mFont.k);
            }

            if (GameCanvas.j) {
               if (TileMap.bgID == 1) {
                  var10000 = mFont.i;
                  var10002 = TextGame.dg + ": " + Char.getMyChar().de;
                  var3 += 12;
                  var10000.a(var1, var10002, var2, var3, 0, mFont.k);
                  var10000 = mFont.i;
                  var10002 = TextGame.dh + ": " + Char.getMyChar().df;
                  var3 += 12;
                  var10000.a(var1, var10002, var2, var3, 0, mFont.k);
               } else if (TileMap.bgID != 2 && TileMap.mapID != 114 && TileMap.mapID != 115 && TileMap.mapID != 116) {
                  if (TileMap.bgID == 3) {
                     var10000 = mFont.i;
                     var10002 = TextGame.di + ": " + Char.dy;
                     var3 += 12;
                     var10000.a(var1, var10002, var2, var3, 0, mFont.k);
                     var10000 = mFont.i;
                     var10002 = TextGame.ir[Char.z()];
                     var3 += 12;
                     var10000.a(var1, var10002, var2, var3, 0, mFont.k);
                  }
               } else {
                  var10000 = mFont.i;
                  var10002 = TextGame.di + ": " + Char.dx;
                  var3 += 12;
                  var10000.a(var1, var10002, var2, var3, 0, mFont.k);
               }
            }

            var1.a(-var1.a(), -var1.b());
         }
      } catch (Exception var16) {
      }

   }

   private static long cgStuckSince = 0;
   private static long stateLastLog = 0;
   private void i(mGraphics var1) {
      // Periodic state snapshot: 1s/lần khi panel/popup đang mở
      if (DebugLog.DEBUG && (cg() || aa() || GameCanvas.aj != null) && System.currentTimeMillis() - stateLastLog > 1000) {
         stateLastLog = System.currentTimeMillis();
         DebugLog.log("STATE",
            "aa="+aa()+" cg="+cg()
            +" hb="+hb+" cn="+cn+" hx="+hx+" ih="+ih+" hr="+hr+" cs="+cs+" ib="+ib
            +" cq="+cq+" cr="+cr+" id="+id+" ct="+ct+" co="+co+" ig="+ig
            +" gu="+gu+" gw="+gw+" ie="+ie+" gx="+gx+" gv="+gv+" cp="+cp+" gy="+gy+" gz="+gz+" ic="+ic+" cu="+cu+" ip="+ip
            +" isItemDel="+phong2.isItemDel+" isItemPick="+phong2.isItemPick
            +" super.a="+(super.a==this.ka?"ka":(super.a==null?"null":super.a.toString()))
            +" super.b="+(super.b==null?"null":super.b.toString())
            +" aj="+(GameCanvas.aj==null?"null":"NotNull")
            +" af.a="+GameCanvas.af.a);
      }
      // Self-heal v1: cg() (transient) kẹt > 5s mà aa() đã clear + KHÔNG đang xem popup info (cr).
      // cr = cờ "đang xem popup info char/item" (set bởi be()/al()), KHÔNG phải transient kẹt.
      // Nếu để v1 clear cr → popup info tự đóng sau 5s — đây là bug trước đó.
      if (cg() && !aa() && !cr && GameCanvas.aj == null && ChatPopup.f == null && !GameCanvas.af.a) {
         if (cgStuckSince == 0) cgStuckSince = System.currentTimeMillis();
         else if (System.currentTimeMillis() - cgStuckSince > 5000L) {
            DebugLog.log("CG-HEAL", "Flag stuck >5s, force reset."
               +" id="+id+" cq="+cq+" co="+co+" gw="+gw+" ie="+ie+" gu="+gu
               +" ct="+ct+" cp="+cp+" gx="+gx+" gv="+gv+" gy="+gy+" gz="+gz
               +" ic="+ic+" cu="+cu+" ip="+ip+" ig="+ig);
            id = false; cq = false; co = false; gw = false; ie = false; gu = false;
            ct = false; cp = false; gx = false; gv = false; gy = false; gz = false;
            ic = false; cu = false; ip = false; ig = false;
            cgStuckSince = 0;
         }
      } else {
         cgStuckSince = 0;
      }
if (GameCanvas.g && (!GameCanvas.af.a || !GameCanvas.i) && GameCanvas.aj == null && ChatPopup.f == null && !GameCanvas.af.a && !cg()) {
         b(var1);
         if (!ChatTextField.a().b) {
            var1.a(ji, kq + 17, kr + 17, 3);
         }

         if (!this.ch()) {
            if (GameCanvas.isAnalog) {
               if (gamePad == null) {
                  gamePad = new GamePad();
               }
               gamePad.paint(var1);
            } else {
               var1.a(jl, ko, kp, 0);
               var1.a(jg, 0, 0, mGraphics.a(jg), mGraphics.b(jg), 3, ko + 15, kp + 16, 3);
               if (mScreen.g == 4) {
                  var1.a(jm, ko, kp, 0);
                  var1.a(jh, 0, 0, mGraphics.a(jg), mGraphics.b(jg), 3, ko + 15, kp + 16, 3);
               }

               var1.a(jl, ks, kt, 0);
               var1.a(jg, 0, 0, mGraphics.a(jg), mGraphics.b(jg), 0, ks + 17, kt + 16, 3);
               if (mScreen.g == 6) {
                  var1.a(jm, ks, kt, 0);
                  var1.a(jh, 0, 0, mGraphics.a(jg), mGraphics.b(jg), 0, ks + 17, kt + 16, 3);
               }

               var1.a(jl, kw, kx, 0);
               var1.a(jg, 0, 0, mGraphics.a(jg), mGraphics.b(jg), 7, kw + 17, kx + 14, 3);
               if (mScreen.g == 3) {
                  var1.a(jm, kw, kx, 0);
                  var1.a(jh, 0, 0, mGraphics.a(jg), mGraphics.b(jg), 7, kw + 17, kx + 14, 3);
               }
            }

            if (Char.getMyChar().ctaskId > 1) {
               var1.a(jl, ky, kz, 0);
               if (mScreen.g == 10) {
                  var1.a(jm, ky, kz, 0);
               }

               var1.a(jn, ky + 16, kz + 15, 3);
               mFont.s.a(var1, "" + mpPotion, ky + 22, kz + 20, 1);
               var1.a(jl, la, lb, 0);
               if (mScreen.g == 11) {
                  var1.a(jm, la, lb, 0);
               }

               var1.a(jo, la + 16, lb + 15, 3);
               mFont.s.a(var1, "" + hpPotion, la + 22, lb + 20, 1);
               var1.a(jl, lc, ld, 0);
               if (mScreen.g == 13) {
                  var1.a(jm, lc, ld, 0);
               }

               var1.a(jk, lc + 16, ld + 16, 3);
            }

            var1.a(jp, ku, kv, 0);
            if (mScreen.g == 5) {
               var1.a(jq, ku, kv, 0);
            }
         }
      }

   }

   private void j(mGraphics var1) {
      if (GameCanvas.aj == null && ChatPopup.f == null && !GameCanvas.af.a && !cg() && super.b != this.fj && (!GameCanvas.g || Char.getMyChar().vSkill.size() >= 2) && ha) {
         for(int var2 = 0; var2 < jz.length; ++var2) {
            if (GameCanvas.i) {
               if (Info.a > 0) {
                  lf[var2] = 55 + Info.a;
               } else {
                  lf[var2] = 55;
               }
            }

            if (GameCanvas.g && GameCanvas.h) {
               var1.a(jr, lg + le[var2] - 1, lf[var2] - 1, 0);
            } else {
               var1.a(16764040);
               var1.b(lg + le[var2] - 1, lf[var2] - 1, 25, 25);
            }

            Skill var3 = jz[var2];
            if (var2 == this.kj && !aa() && GameCanvas.w % 10 > 5) {
               var1.a(16777215);
               var1.c(lg + le[var2] + 1, lf[var2] + 1, 22, 22);
            } else if (!GameCanvas.g) {
               var1.a(0);
               var1.c(lg + le[var2], lf[var2], 24, 24);
            }

            if (var3 != null) {
               if (var3 == Char.getMyChar().myskill) {
                  var1.a(16711680);
                  var1.b(lg + le[var2] - 1, lf[var2] - 1, 25, 25);
               }

               var3.a(lg + le[var2] + 12, lf[var2] + 12, var1);
            }
         }
      }

   }

   public static final void a(String var0, int var1, int var2, int var3, int var4, int var5) {
      var3 = -1;

      for(var4 = 0; var4 < 5; ++var4) {
         if (lo[var4] == -1) {
            var3 = var4;
            break;
         }
      }

      if (var3 != -1) {
         lp[var3] = var5;
         lj[var3] = var0;
         lk[var3] = var1;
         ll[var3] = var2;
         lm[var3] = 0;
         ln[var3] = -2;
         lo[var3] = 0;
      }

   }

   public static final void a(int var0, int var1) {
      vLanterns.addElement(new Lanterns(var0, var1));
   }

   public static final boolean a(int var0, int var1, int var2) {
      int var3 = ls[0] == -1 ? 0 : 1;
      if (ls[var3] != -1) {
         return false;
      } else {
         ls[var3] = 0;
         lu[var3] = var2;
         lq[var3] = var0;
         lr[var3] = var1;
         return true;
      }
   }

   private void bt() {
      if (mi == null) {
         mi = new Image[2];

         for(int var1 = 0; var1 < 2; ++var1) {
            mi[var1] = GameCanvas.c("/u/c" + var1 + ".png");
         }
      }

      lz = mGraphics.a(mi[0]);
      ma = mGraphics.a(mi[1]);
      mb = i - lz - ma + 1;
      mc = 63;
      md = lx + 7;
      me = i - 84 - 30 + 15;
      mg = i - 44 - 4;
      mh = 5;
      if (GameCanvas.aa > 176) {
         mb -= 50;
         me -= 50;
         mg -= 50;
         mc += 15;
         me -= 15;
      }

      this.bu();
   }

   private void bu() {
      if (GameCanvas.g) {
         me = 82;
         mf = 57;
         mc = 52;
         md = GameCanvas.av ? 25 : 10 + Info.a;
         mg = i - 61;
         if (GameCanvas.i) {
            kq = i / 2 - 2;
            kr = kn + 50;
         } else {
            this.ka.g = 6 + Info.a;
            kq = i - 100;
            kr = 2 + Info.a;
         }

         TileMap.setPosMiniMap(GameCanvas.aa - 60, GameCanvas.av ? 16 : Info.a, 60, 42);
      }

   }

   private void k(mGraphics var1) {
      if (aw == 4) {
         var1.a(-var1.a(), -var1.b());
         Paint.a(fe, fd, ff, fg, var1);
         var1.a(Paint.a);
         a(var1, TextGame.fg[aw], true);
         if (currentCharViewInfo.arrItemBody == null) {
            GameCanvas.a(fe + 90, fd + 75, var1, false);
            mFont.e.a(var1, TextGame.y, fe + ff / 2, fd + 90, 2);
         } else {
            int gridW = (cr && GameCanvas.aa >= 320) ? 175 : ff;
            var1.a(13606712);
            var1.b(fe + 33, fd + 87, gridW - 67, 76);
            int var2 = indexSize - 2;
            int var3 = 0;

            int var4;
            int var5;
            int var6;
            for(var4 = 0; var4 < 16; ++var4) {
               if (var4 != 0 && var4 != 2 && var4 != 4 && var4 != 6 && var4 != 8) {
                  if (var4 != 1 && var4 != 3 && var4 != 5 && var4 != 7 && var4 != 9) {
                     if (var4 == 9 || var4 == 10 || var4 == 11 || var4 == 12 || var4 == 13 || var4 == 14 || var4 == 15) {
                        var5 = fe + 4 + 1 + var3 * (var2 + 2);
                        var6 = fd + 35 + var2 * 5 + 1;
                        var1.a(0);
                        var1.c(var5, fd + 35 + var2 * 5 + 1, var2 - 1, var2 - 1);
                        if (mj == 0) {
                           if (TextGame.kj[var4].length > 1) {
                              mFont.k.a(var1, TextGame.kj[var4][0], var5 + var2 / 2, var6 + 2, 2);
                              mFont.k.a(var1, TextGame.kj[var4][1], var5 + var2 / 2, var6 + 2 + 9, 2);
                           } else {
                              mFont.k.a(var1, TextGame.kj[var4][0], var5 + var2 / 2, var6 + 2 + 5, 2);
                           }
                        }

                        ++var3;
                     }
                  } else {
                     var1.a(0);
                     var1.c(fe + gridW - var2 - 4, fd + 35 + var4 / 2 * var2 + 1, var2 - 1, var2 - 1);
                     if (mj == 0) {
                        if (TextGame.kj[var4].length > 1) {
                           mFont.k.a(var1, TextGame.kj[var4][0], fe + gridW - var2 / 2 - 4, fd + 36 + var4 / 2 * var2 + 2, 2);
                           mFont.k.a(var1, TextGame.kj[var4][1], fe + gridW - var2 / 2 - 4, fd + 36 + var4 / 2 * var2 + 2 + 9, 2);
                        } else {
                           mFont.k.a(var1, TextGame.kj[var4][0], fe + gridW - var2 / 2 - 4, fd + 36 + var4 / 2 * var2 + 2 + 5, 2);
                        }
                     }
                  }
               } else {
                  var1.a(0);
                  var1.c(fe + 4 + 1, fd + 35 + var4 / 2 * var2 + 1, var2 - 1, var2 - 1);
                  if (mj == 0) {
                     if (TextGame.kj[var4].length > 1) {
                        mFont.k.a(var1, TextGame.kj[var4][0], fe + 7 + 11, fd + 36 + var4 / 2 * var2 + 2, 2);
                        mFont.k.a(var1, TextGame.kj[var4][1], fe + 7 + 11, fd + 36 + var4 / 2 * var2 + 2 + 9, 2);
                     } else {
                        mFont.k.a(var1, TextGame.kj[var4][0], fe + 7 + 11, fd + 36 + var4 / 2 * var2 + 2 + 5, 2);
                     }
                  }
               }
            }

            int var7;
            Item var10;
            int lvTL;
            if (mj == 0) {
               for(var4 = 0; var4 < 16; ++var4) {
                  if ((var10 = currentCharViewInfo.arrItemBody[var4]) != null) {
                     if (var10.eff == null) {
                        var10.eff = ad[56];
                     }

                     lvTL = var10.lvTL();
                     if (var10.indexUI != 0 && var10.indexUI != 2 && var10.indexUI != 4 && var10.indexUI != 6 && var10.indexUI != 8 && var10.indexUI != 10) {
                        if (var10.indexUI != 1 && var10.indexUI != 3 && var10.indexUI != 5 && var10.indexUI != 7 && var10.indexUI != 9) {
                           if (var10.indexUI == 11 || var10.indexUI == 12 || var10.indexUI == 13 || var10.indexUI == 14 || var10.indexUI == 15) {
                              if (var10.indexUI == 10) {
                                 var3 = 1;
                              } else if (var10.indexUI == 11) {
                                 var3 = 2;
                              } else if (var10.indexUI == 12) {
                                 var3 = 3;
                              } else if (var10.indexUI == 13) {
                                 var3 = 4;
                              } else if (var10.indexUI == 14) {
                                 var3 = 5;
                              } else if (var10.indexUI == 15) {
                                 var3 = 6;
                              }

                              var6 = fe + 2 + 1 + var3 * (var2 + 2) - var2;
                              var7 = fd + 35 + var2 * 5;
                              this.a(var1, var10, var6 - 2, var7 - 1, 0, 1);
                              if (Code.isShowTL) {
                                 if (var10.indexUI == 12) {
                                    mFont.e.a(var1, "TL" + lvTL, var6 + 1, var7 + 25, 0);
                                 } else {
                                    mFont.e.a(var1, "+" + var10.upgrade, var6 + 3, var7 + 25, 0);
                                 }
                              }
                           }
                        } else {
                           var6 = fe + gridW - var2 - 5;
                           var7 = fd + 35 + var10.indexUI / 2 * var2;
                           this.a(var1, var10, var6 - 1, var7 - 1, 0, 1);
                           if (Code.isShowTL) {
                              mFont.e.a(var1, "+" + var10.upgrade + ",TL" + lvTL, var6 - 35, var7 + 10, 0);
                           }
                        }
                     } else {
                        var6 = fe + 4;
                        var7 = fd + 34 + var10.indexUI / 2 * var2;
                        this.a(var1, var10, var6 - 1, var7, 0, 1);
                        if (Code.isShowTL) {
                           if (var10.indexUI != 10) {
                              mFont.e.a(var1, "+" + var10.upgrade + ",TL" + lvTL, var6 + 30, var7 + 10, 0);
                           } else {
                              mFont.e.a(var1, "+" + var10.upgrade, var6 + 3, var7 + 25, 0);
                           }
                        }
                     }

                     if (GameCanvas.w % 4 == 0) {
                        ++var10.indexEff;
                        if (var10.indexEff >= var10.eff.b.length) {
                           var10.indexEff = 0;
                        }
                     }
                  }
               }
            }

            if (mj > 0) {
               for(var4 = 0; var4 < 16; ++var4) {
                  if ((var10 = currentCharViewInfo.arrItemBody[var4 + mj]) != null) {
                     var6 = var10.indexUI - 16;
                     if (var10.eff == null) {
                        var10.eff = ad[56];
                     }

                     if (var6 != 0 && var6 != 2 && var6 != 4 && var6 != 6 && var6 != 8 && var6 != 10) {
                        if (var6 != 1 && var6 != 3 && var6 != 5 && var6 != 7 && var6 != 9) {
                           if (var6 == 11 || var6 == 12 || var6 == 13 || var6 == 14 || var6 == 15) {
                              if (var6 == 10) {
                                 var3 = 1;
                              } else if (var6 == 11) {
                                 var3 = 2;
                              } else if (var6 == 12) {
                                 var3 = 3;
                              } else if (var6 == 13) {
                                 var3 = 4;
                              } else if (var6 == 14) {
                                 var3 = 5;
                              } else if (var6 == 15) {
                                 var3 = 6;
                              }

                              var7 = fe + 2 + 1 + var3 * (var2 + 2) - var2;
                              lvTL = fd + 35 + var2 * 5;
                              this.a(var1, var10, var7 - 2, lvTL - 1, 0, 1);
                           }
                        } else {
                           var7 = fe + gridW - var2 - 5;
                           lvTL = fd + 35 + var6 / 2 * var2;
                           this.a(var1, var10, var7 - 1, lvTL - 1, 0, 1);
                        }
                     } else {
                        var7 = fe + 4;
                        lvTL = fd + 34 + var6 / 2 * var2;
                        this.a(var1, var10, var7 - 1, lvTL, 0, 1);
                     }

                     if (GameCanvas.w % 4 == 0) {
                        ++var10.indexEff;
                        if (var10.indexEff >= var10.eff.b.length) {
                           var10.indexEff = 0;
                        }
                     }
                  }
               }
            }

            for(var4 = 0; var4 < 16; ++var4) {
               if (indexTitle == 1 && var4 == indexSelect) {
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

                           var5 = fe + 2 + 1 + var3 * (var2 + 2) - var2;
                           var6 = fd + 35 + var2 * 5;
                           var1.a(16777215);
                           var1.b(var5 - 1, var6, var2, var2);
                           a(var5 - 2, var6 - 1, var1);
                        }
                     } else {
                        var1.a(16777215);
                        var1.b(fe + gridW - var2 - 4 - 1, fd + 35 + var4 / 2 * var2, var2, var2);
                        a(fe + gridW - var2 - 4 - 2, fd + 35 + var4 / 2 * var2 - 1, var1);
                     }
                  } else {
                     var1.a(16777215);
                     var1.b(fe + 4, fd + 35 + var4 / 2 * var2, var2, var2);
                     a(fe + 5 - 2, fd + 35 + var4 / 2 * var2 - 1, var1);
                  }
               }
            }

            int charX = fe + gridW / 2;
            int charY = fd + fg / 2;
            var4 = -25;
            Part var11 = ac[currentCharViewInfo.head];
            Part var12 = ac[currentCharViewInfo.leg];
            Part var13 = ac[currentCharViewInfo.body];
            Part var14 = ac[currentCharViewInfo.weapon];
            if (currentCharViewInfo.arrItemBody != null && currentCharViewInfo.arrItemBody[11] != null) {
               var11 = ac[currentCharViewInfo.arrItemBody[11].template.part];
            }

            if (var11.a != null && var11.a.length >= 8) {
               for(var2 = 0; var2 < var11.a.length; ++var2) {
                  if (var11.a[var2] == null || !SmallImage.a(var11.a[var2].a)) {
                     Char.getMyChar();
                     var11 = Char.b(Char.getMyChar().cgender);
                     break;
                  }
               }
            } else {
               Char.getMyChar();
               var11 = Char.b(Char.getMyChar().cgender);
            }

            var2 = currentCharViewInfo.m % 15 < 5 ? 0 : 1;
            int[] var15 = currentCharViewInfo.s();
            if (currentCharViewInfo.ID_WEA_PONE > -1) {
               currentCharViewInfo.g(var1, charX, charY - 24, var2);
            }

            if (currentCharViewInfo.ID_PP > -1) {
               currentCharViewInfo.c(var1, charX, charY - 24, var2);
            }

            if (var15 != null && currentCharViewInfo.ID_PP == -1) {
               if (Char.getMyChar().dg == 0) {
                  SmallImage.a(var1, var15[Char.getMyChar().dg], charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][1] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].b - 2, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][2] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].c + 16, 0, 0);
               } else if (Char.getMyChar().dg == 1) {
                  SmallImage.a(var1, var15[Char.getMyChar().dg], charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][1] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].b - 9, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][2] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].c + 16, 0, 0);
               } else if (Char.getMyChar().dg == 2) {
                  SmallImage.a(var1, var15[Char.getMyChar().dg], charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][1] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].b - 12, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][2] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].c + 16, 0, 0);
               } else {
                  SmallImage.a(var1, var15[Char.getMyChar().dg], charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][1] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].b - 9, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][2] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].c + 16, 0, 0);
               }
            }

            currentCharViewInfo.c(var1, charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][1] + var13.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][0]].b + 18, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][2] + var12.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][0]].c + 5);
            if (currentCharViewInfo.ID_WEA_PONE == -1) {
               SmallImage.a(var1, var14.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][3][0]].a, charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][3][1] + var14.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][3][0]].b, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][3][2] + var14.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][3][0]].c, 0, 0);
            }

            if (currentCharViewInfo.ID_LEG > -1) {
               currentCharViewInfo.i(var1, charX, charY - 24, var2);
            } else {
               SmallImage.a(var1, var12.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][0]].a, charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][1] + var12.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][0]].b, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][2] + var12.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][0]].c, 0, 0);
            }

            if (currentCharViewInfo.ID_Body > -1) {
               currentCharViewInfo.j(var1, charX, charY - 24, var2);
            } else {
               SmallImage.a(var1, var13.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][0]].a, charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][1] + var13.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][0]].b, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][2] + var13.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][0]].c, 0, 0);
            }

            if (currentCharViewInfo.ID_HAIR > -1) {
               currentCharViewInfo.h(var1, charX, charY - 24, var2);
            } else {
               SmallImage.a(var1, var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].a, charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][1] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].b, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][2] + var11.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][0][0]].c, 0, 0);
            }

            if (currentCharViewInfo.ID_MAT_NA > -1) {
               currentCharViewInfo.e(var1, charX, charY - 24, var2);
            }

            currentCharViewInfo.c(var1, charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][1] + var13.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][0]].b + 5, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][2] + var12.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][0]].c + 5);
            currentCharViewInfo.d(var1, charX + Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][1] + var13.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][2][0]].b + 22, charY + var4 - Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][2] + var12.a[Char.ea[currentCharViewInfo.m % 15 < 5 ? 0 : 1][1][0]].c + 5);
            if (currentCharViewInfo.ID_PP > -1) {
               currentCharViewInfo.d(var1, charX, charY - 24, var2);
            }

            if (currentCharViewInfo.ID_WEA_PONE > -1) {
               currentCharViewInfo.f(var1, charX, charY - 24, var2);
            }

            if (this.gg != null && GameCanvas.g && super.b == null && !cq) {
               Command1 var9;
               if (!(var9 = this.gg).j) {
                  var1.a(ea, var9.f, var9.g, 0);
               } else {
                  var1.a(eb, var9.f, var9.g, 0);
               }

               mFont.d.a(var1, var9.a, var9.f + 36, var9.g + 6, 2);
            }
         }
      }

   }

   private void l(mGraphics var1) {
      if (aw == 5) {
         var1.a(-var1.a(), -var1.b());
         Paint.a(fe, fd, ff, fg, var1);
         var1.a(Paint.a);
         a(var1, TextGame.fg[aw], true);
         b(var1);
         var1.a(0);
         var1.c(fe + 2, fd + 31, 171, fg - 34);
         var1.a(13606712);
         var1.b(fe + 3, fd + 32, 168, fg - 37);
         var1.a(Paint.a);
         var1.c(fe + 4, fd + 34, 166, fg - 39);
         int var2;
         int var3;
         if (currentCharViewInfo.arrItemMounts[4] != null) {
            mFont.e.a(var1, currentCharViewInfo.arrItemMounts[4].template.name, fe + 90, oe + 2, 2);
            var2 = currentCharViewInfo.arrItemMounts[4].sys + 1;

            for(var3 = 0; var3 < var2; ++var3) {
               SmallImage.a(var1, 628, fe + 90 + var3 * 12 - var2 * 6, oe + 20, 0, 3);
            }
         } else {
            mFont.e.a(var1, TextGame.rh, fe + 90, oe + 2, 2);
         }

         for(var2 = 0; var2 < currentCharViewInfo.arrItemMounts.length - 1; ++var2) {
            if (currentCharViewInfo.arrItemMounts[var2] != null) {
               this.a(var1, currentCharViewInfo.arrItemMounts[var2], this.jw[var2], this.jx[var2]);
               if (Code.isShowTL) {
                  mFont.e.a(var1, "TL" + currentCharViewInfo.arrItemMounts[var2].lvTL(), this.jw[var2] + 7, this.jx[var2] + (var2 % 2 == 0 ? -10 : 30), 0);
               }
            } else {
               var1.a(6425);
               var1.c(this.jw[var2] - 1, this.jx[var2] - 1, indexSize + 3, indexSize + 3);
               if (var2 == 0) {
                  if (currentCharViewInfo.p()) {
                     mFont.k.a(var1, TextGame.kj[22][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[22][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  } else {
                     mFont.k.a(var1, TextGame.kj[19][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[19][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  }
               } else if (var2 == 1) {
                  if (currentCharViewInfo.p()) {
                     mFont.k.a(var1, TextGame.kj[20][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[20][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  } else {
                     mFont.k.a(var1, TextGame.kj[16][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[16][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  }
               } else if (var2 == 2) {
                  if (currentCharViewInfo.p()) {
                     mFont.k.a(var1, TextGame.kj[21][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[21][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  } else {
                     mFont.k.a(var1, TextGame.kj[17][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[17][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  }
               } else if (var2 == 3) {
                  if (currentCharViewInfo.p()) {
                     mFont.k.a(var1, TextGame.kj[23][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[23][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  } else {
                     mFont.k.a(var1, TextGame.kj[18][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
                     mFont.k.a(var1, TextGame.kj[18][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
                  }
               }
            }

            if (indexSelect == var2 && indexTitle == 1 && indexSelect < 4) {
               var1.a(16777215);
            } else {
               var1.a(12281361);
            }

            var1.b(this.jw[var2], this.jx[var2], indexSize, indexSize);
         }

         var2 = this.jw[0] + indexSize + 7;
         var3 = this.jx[0] - 5;
         var1.a(6425);
         var1.c(var2, var3, 84, 75);
         if (indexSelect == 4) {
            var1.a(16777215);
         } else {
            var1.a(12281361);
         }

         var1.b(var2, var3, 84, 75);
         int var9 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if (currentCharViewInfo.ID_HORSE > -1) {
            currentCharViewInfo.b(var1, var2 + 35, var3 + 55);
         }

         int var11;
         if (currentCharViewInfo.arrItemMounts[4] != null) {
            if (currentCharViewInfo.ad()) {
               int[][] var8 = (int[][])((int[][])CharPartInfo.h.a(String.valueOf(currentCharViewInfo.arrItemMounts[4].template.id)));
               if (GameCanvas.w % 20 > 15) {
                  SmallImage.a(var1, var8[0][0], var2 + 45 - 10, var3 + 35, 0, 3);
               } else {
                  SmallImage.a(var1, var8[0][1], var2 + 45 - 10, var3 + 35, 0, 3);
               }
            } else if (currentCharViewInfo.p()) {
               if (currentCharViewInfo.arrItemMounts[4].template.id == 485) {
                  if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                     SmallImage.a(var1, 1800, var2 + 45, var3 + 35, 0, 3);
                  } else {
                     SmallImage.a(var1, 2063, var2 + 45, var3 + 35, 0, 3);
                  }
               } else if (currentCharViewInfo.arrItemMounts[4].template.id == 524) {
                  if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                     SmallImage.a(var1, 2067, var2 + 45, var3 + 35, 0, 3);
                  } else {
                     SmallImage.a(var1, 2071, var2 + 45, var3 + 35, 0, 3);
                  }
               }
            } else if (currentCharViewInfo.o()) {
               if (currentCharViewInfo.arrItemMounts[4].template.id == 443) {
                  if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                     if (GameCanvas.w % 20 > 15) {
                        SmallImage.a(var1, 1801, var2 + 45, var3 + 35, 0, 3);
                     } else {
                        SmallImage.a(var1, 1802, var2 + 45, var3 + 35, 0, 3);
                     }
                  } else if (GameCanvas.w % 20 > 15) {
                     SmallImage.a(var1, 2080, var2 + 45, var3 + 35, 0, 3);
                  } else {
                     SmallImage.a(var1, 2081, var2 + 45, var3 + 35, 0, 3);
                  }
               } else if (currentCharViewInfo.arrItemMounts[4].template.id == 523) {
                  if (GameCanvas.w % 20 > 15) {
                     SmallImage.a(var1, 2062, var2 + 45, var3 + 35, 0, 3);
                  } else {
                     SmallImage.a(var1, 2061, var2 + 45, var3 + 35, 0, 3);
                  }
               }
            }

            if (currentCharViewInfo.arrItemMounts[4].options != null) {
               for(var11 = 0; var11 < currentCharViewInfo.arrItemMounts[4].options.size(); ++var11) {
                  ItemOption var10;
                  if ((var10 = (ItemOption)currentCharViewInfo.arrItemMounts[4].options.elementAt(var11)).c.a == 65) {
                     var9 = var10.a;
                  } else if (var10.c.a == 66) {
                     var4 = var10.a;
                  }
               }
            }

            var5 = var9 * 85 / 1000;
            var6 = var4 * 85 / 1000;
            var7 = currentCharViewInfo.arrItemMounts[4].upgrade + 1;
         }

         var11 = od + 5;
         var2 = oe + 112;
         mFont.e.a(var1, TextGame.du + ": ", var11, var2, 0);
         mFont.e.a(var1, String.valueOf(var7), var11 + 70, var2, 0);
         String var10002;
         mFont var10000;
         if (currentCharViewInfo.p()) {
            var10000 = mFont.e;
            var10002 = TextGame.rw + ": ";
            var2 += 15;
            var10000.a(var1, var10002, var11, var2, 0);
         } else {
            var10000 = mFont.e;
            var10002 = TextGame.ha + ": ";
            var2 += 15;
            var10000.a(var1, var10002, var11, var2, 0);
         }

         var1.a(6425);
         var1.c(var11 + 70, var2, 85, 14);
         var1.a(371981);
         var1.c(var11 + 70, var2, var5, 14);
         var1.a(5131338);
         var1.b(var11 + 70, var2, 85, 14);
         mFont.i.a(var1, var9 + "/" + 1000, var11 + 113, var2 + 2, 2);
         if (currentCharViewInfo.p()) {
            var10000 = mFont.e;
            var10002 = TextGame.rx + ": ";
            var2 += 17;
            var10000.a(var1, var10002, var11, var2, 0);
         } else {
            var10000 = mFont.e;
            var10002 = TextGame.rg + ": ";
            var2 += 17;
            var10000.a(var1, var10002, var11, var2, 0);
         }

         var1.a(6425);
         var1.c(var11 + 70, var2, 85, 14);
         var1.a(16711680);
         var1.c(var11 + 70, var2, var6, 14);
         var1.a(5131338);
         var1.b(var11 + 70, var2, 85, 14);
         mFont.i.a(var1, var4 + "/" + 1000, var11 + 113, var2 + 2, 2);
      }

   }

   private void m(mGraphics var1) {
      if (ie) {
         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.mh[aw], true);
         if (aw == 0) {
            if (Char.be != null && Char.be.a != null && !Char.be.a.equals("")) {
               int[] var6 = new int[]{1692, 1693, 1694, 1695, 1696};

               for(int var4 = 0; var4 < var6.length; ++var4) {
                  var1.a(6425);
                  var1.c(fe + var4 * indexSize + 18, fd + 32, indexSize - 2, indexSize - 2);
                  if (indexTitle == 1 && var4 == indexSelect) {
                     var1.a(16777215);
                  } else {
                     var1.a(12281361);
                  }

                  var1.b(fe + var4 * indexSize + 18, fd + 32, indexSize - 2, indexSize - 2);
                  if (var4 > Char.be.e - 1) {
                     SmallImage.a(var1, 1697, fe + var4 * indexSize + 18 + indexSize / 2, fd + 32 + indexSize / 2, 0, 3);
                  } else {
                     SmallImage.a(var1, var6[var4], fe + var4 * indexSize + 18 + indexSize / 2, fd + 32 + indexSize / 2, 0, 3);
                  }
               }

               if (indexTitle == 2) {
                  var1.a(Paint.c);
                  var1.c(fe + 7, fd + 60, ff - 14, fg - 68);
                  var1.a(16777215);
               } else {
                  var1.a(10249521);
               }

               var1.b(fe + 7, fd + 60, ff - 14, fg - 68);
               od = fe + 17;
               oe = fd + 62;
               gm = 12;
               ba.a(gm, 12, fe, fd + 62, ff, fg - 72, true, 1);
               ba.a(var1);
               mFont.d.a(var1, TextGame.mi[0] + Char.be.a, od, oe, 0);
               mFont.h.a(var1, TextGame.mi[1] + Char.be.j, od, oe += 12, 0);
               mFont.i.a(var1, TextGame.mi[2] + Char.be.n + "/" + (Char.be.d * 5 + 45), od, oe += 12, 0);
               mFont.i.a(var1, TextGame.mi[3] + Char.be.d, od, oe += 12, 0);
               mFont.i.a(var1, TextGame.mi[4] + Char.be.b + "/" + Char.be.c, od, oe += 12, 0);
               mFont.i.a(var1, TextGame.mi[5] + NinjaUtil.a(String.valueOf(Char.be.g)) + " " + TextGame.ka, od, oe += 12, 0);
               mFont.i.a(var1, TextGame.mi[8] + NinjaUtil.a(String.valueOf(Char.be.h)) + " " + TextGame.ka, od, oe += 12, 0);
               mFont.i.a(var1, TextGame.mi[9] + NinjaUtil.a(String.valueOf(Char.be.i)) + " " + TextGame.ka, od, oe += 12, 0);
               if (mFont.i.a(TextGame.mi[10] + Char.be.f + " " + TextGame.mg) > os - 10) {
                  this.a(var1, mFont.i, TextGame.mi[10] + Char.be.f + " " + TextGame.mg, od, oe += 12, 0, ff - 20);
               } else {
                  mFont.i.a(var1, TextGame.mi[10] + Char.be.f + " " + TextGame.mg, od, oe += 12, 0);
               }

               if (mFont.i.a(TextGame.mi[12] + Char.be.o + " " + TextGame.mg) > os - 10) {
                  this.a(var1, mFont.i, TextGame.mi[12] + Char.be.o + " " + TextGame.mg, od, oe += 12, 0, ff - 20);
               } else {
                  mFont.i.a(var1, TextGame.mi[12] + Char.be.o + " " + TextGame.mg, od, oe += 12, 0);
               }

               mFont.i.a(var1, TextGame.mi[6] + Char.be.k, od, oe += 12, 0);
               if (this.mm == null) {
                  this.mm = a(mFont.j, Char.be.m);
               }

               this.a(var1, mFont.j, (String[])((String[])this.mm), od, oe += 12, 0);
               if (indexTitle == 2 && av >= 0) {
                  SmallImage.a(var1, 942, od - 8, fd + 62 + 2 + av * 12, 0, StaticObj.b);
               }

               ba.a(gm, 12, fe, fd + 62, ff, fg - 72, true, 1);
            } else {
               gm = 1;
               mFont.i.a(var1, TextGame.no, fe + ff / 2, fd + 40, 2);
            }
         } else if (aw == 1) {
            od = fe + 5;
            oe = fd + 32;
            if (vClan.size() == 0) {
               mFont.i.a(var1, TextGame.no, fe + ff / 2, fd + 40, 2);
            } else {
               var1.a(6425);
               var1.c(od - 2, oe - 2, ff - 6, indexSize * 5 + 8);
               b(var1);
               ba.a(var1, od, oe, ff - 3, indexSize * 5 + 6);
               this.ml = 0;

               for(int var5 = 0; var5 < vClan.size(); ++var5) {
                  Member var3 = (Member)vClan.elementAt(var5);
                  if (!gr || var3.e) {
                     if (var5 * (indexSize + indexSize / 2) >= ba.b - (indexSize + indexSize / 2) && var5 * (indexSize + indexSize / 2) < ba.b + indexSize * 5 + 8) {
                        if (av == this.ml) {
                           var1.a(Paint.b);
                           var1.c(od + 2, oe + av * (indexSize + indexSize / 2) + 2, ff - 15, indexSize + indexSize / 2 - 4);
                           var1.a(16777215);
                           var1.b(od + 2, oe + av * (indexSize + indexSize / 2) + 2, ff - 15, indexSize + indexSize / 2 - 4);
                        } else {
                           var1.a(Paint.a);
                           var1.c(od + 2, oe + this.ml * (indexSize + indexSize / 2) + 2, ff - 15, indexSize + indexSize / 2 - 4);
                           var1.a(13932896);
                           var1.b(od + 2, oe + this.ml * (indexSize + indexSize / 2) + 2, ff - 15, indexSize + indexSize / 2 - 4);
                        }

                        SmallImage.a(var1, var3.a, od + 12, oe + this.ml * (indexSize + indexSize / 2) + 13, 0, 3);
                        if (var3.c == 4) {
                           SmallImage.a(var1, 1216, od + 12, oe + this.ml * (indexSize + indexSize / 2) + 30, 0, 3);
                           if (var3.e) {
                              mFont.j.a(var1, TextGame.nu[0] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0, mFont.k);
                              mFont.i.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.n.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.h.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           } else {
                              mFont.k.a(var1, TextGame.nu[0] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.k.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           }
                        } else if (var3.c == 3) {
                           SmallImage.a(var1, 1215, od + 12, oe + this.ml * (indexSize + indexSize / 2) + 30, 0, 3);
                           if (var3.e) {
                              mFont.j.a(var1, TextGame.nu[1] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0, mFont.k);
                              mFont.i.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.n.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.h.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           } else {
                              mFont.k.a(var1, TextGame.nu[1] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.k.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           }
                        } else if (var3.c == 2) {
                           SmallImage.a(var1, 1217, od + 12, oe + this.ml * (indexSize + indexSize / 2) + 30, 0, 3);
                           if (var3.e) {
                              mFont.j.a(var1, TextGame.nu[2] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0, mFont.k);
                              mFont.i.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.n.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.h.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           } else {
                              mFont.k.a(var1, TextGame.nu[2] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.k.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           }
                        } else if (var3.c == 1) {
                           SmallImage.a(var1, 1214, od + 12, oe + this.ml * (indexSize + indexSize / 2) + 30, 0, 3);
                           if (var3.e) {
                              mFont.j.a(var1, TextGame.nu[3] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0, mFont.k);
                              mFont.i.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.n.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.h.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           } else {
                              mFont.k.a(var1, TextGame.nu[3] + " ", od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 45, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                              mFont.k.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                              mFont.k.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                           }
                        } else if (var3.e) {
                           mFont.i.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                           mFont.n.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                           mFont.h.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                        } else {
                           mFont.k.a(var1, var3.d + " - " + TextGame.dv + ": " + var3.b, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 5, 0);
                           mFont.k.a(var1, TextGame.mi[7] + var3.f, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 16, 0);
                           mFont.k.a(var1, TextGame.mi[11] + var3.g, od + 22, oe + this.ml * (indexSize + indexSize / 2) + 26, 0);
                        }
                     }

                     ++this.ml;
                  }
               }

               ba.a(this.ml, indexSize + indexSize / 2, od, oe, ff - 3, indexSize * 5 + 4, true, 1);
               gm = this.ml;
               n(var1);
            }
         } else if (aw != 2) {
            if (aw == 3) {
               if (Char.be != null && Char.be.a != null && !Char.be.a.equals("") && !Char.be.l.equals("")) {
                  gm = 1;
                  od = fe + 17;
                  oe = fd + 34;
                  os = ff - 30;
                  ba.a(var1);
                  if (this.mn == null) {
                     this.mn = a(mFont.i, Char.be.l);
                  }

                  this.a(var1, mFont.i, (String[])((String[])this.mn), od, oe, 0);
                  if (indexTitle == 1 && av >= 0) {
                     SmallImage.a(var1, 942, od - 8, fd + 34 + 2 + av * 12, 0, StaticObj.b);
                  }

                  ba.a(gm, 12, fe, fd + 35, ff, fg - 44, true, 1);
               } else {
                  gm = 1;
                  mFont.i.a(var1, TextGame.no, fe + ff / 2, fd + 40, 2);
               }
            } else if (aw == 4) {
               this.aq(var1);
            }
         } else {
            od = fe + 3;
            oe = fd + 32;
            var1.a(6425);
            var1.c(od - 1, oe - 1, oj * indexSize + 3, 5 * indexSize + 3);
            Item[] var2 = null;
            if (Char.be != null && Char.be.p != null) {
               var2 = Char.be.p;
            } else {
               var2 = new Item[30];
            }

            this.a(var1, var2);
         }
      }

   }

   private static void n(mGraphics var0) {
      b(var0);
      int var1 = av;
      if (ih) {
         var1 = indexSelect;
      }

      if (var1 >= 0 && gm > 0) {
         var1 = var1 + 1 < gm ? var1 + 1 : gm;
         mFont.j.a(var0, var1 + "/" + gm, fe + ff / 2, fd + fg - 12, 2, mFont.k);
      }

   }

   private void bv() {
      if (cr && aw != -1 && GameCanvas.aj == null) {
         if (aw == 0 && indexTitle > 0 && indexSelect >= 0 && indexSelect < Char.getMyChar().arrItemBag.length && Char.getMyChar().arrItemBag[indexSelect] != null) {
            if (!cq) {
               this.showItemInfoSplit(3, Char.getMyChar().arrItemBag[indexSelect]);
            }
            super.a = this.pa;
         } else if (aw == 0 && indexTitle > 0 && (indexSelect < 0 || indexSelect >= Char.getMyChar().arrItemBag.length || Char.getMyChar().arrItemBag[indexSelect] == null)) {
            cq = false;
            super.a = new Command1(TextGame.bd, 110221);
         }

         int var1;
         if (indexTitle == 0) {
            super.a = super.b = null;
            if (aw == 0) {
               super.a = new Command1(TextGame.bd, 110221);
            }

            if (GameCanvas.n[8]) {
               indexTitle = 1;
               indexSelect = 0;
               av = 0;
               ba.a();
               go.a();
            }

            if (GameCanvas.n[4]) {
               indexSelect = 0;
               av = -1;
               --aw;
               ba.a();
               go.a();
               if (currentCharViewInfo.idChar != Char.getMyChar().idChar) {
                  if (aw < 3) {
                     aw = 5;
                  }
               } else if (aw < 0) {
                  aw = TextGame.fg.length - 1;
               }

               this.be();
            }

            if (GameCanvas.n[6]) {
               indexSelect = 0;
               av = -1;
               ++aw;
               ba.a();
               go.a();
               if (currentCharViewInfo.idChar != Char.getMyChar().idChar) {
                  if (aw > 5) {
                     aw = 3;
                  }
               } else if (aw > TextGame.fg.length - 1) {
                  aw = 0;
               }

               this.be();
            }

            this.aj();
         } else if (cq && aw != 0 && aw != 4) {
            if (GameCanvas.n[2]) {
               if (--av < 0) {
                  av = gm - 1;
               }

               go.a(av * go.h);
            } else if (GameCanvas.n[8]) {
               if (++av >= gm) {
                  av = 0;
               }

               go.a(av * go.h);
            }
         } else if (aw == 0) {
            if (GameCanvas.n[4]) {
               if (--indexSelect < 0) {
                  indexSelect = Char.getMyChar().arrItemBag.length - 1;
               }

               super.a = super.b = null;
               this.aj();
               ba.a(indexSelect / oj * ba.h);
            } else if (GameCanvas.n[6]) {
               if (++indexSelect >= Char.getMyChar().arrItemBag.length) {
                  indexSelect = 0;
               }

               super.a = super.b = null;
               this.aj();
               ba.a(indexSelect / oj * ba.h);
            } else if (GameCanvas.n[8]) {
               if (indexSelect + oj <= Char.getMyChar().arrItemBag.length - 1) {
                  indexSelect += oj;
               }

               super.a = super.b = null;
               this.aj();
               ba.a(indexSelect / oj * ba.h);
            } else if (GameCanvas.n[2]) {
               if (indexSelect >= 0 && indexSelect < oj) {
                  indexTitle = 0;
                  indexSelect = 0;
               } else if (indexSelect - oj >= 0) {
                  indexSelect -= oj;
               }

               super.a = super.b = null;
               this.aj();
               ba.a(indexSelect / oj * ba.h);
            }
         } else if (aw == 1) {
            if (!GameCanvas.n[2]) {
               if (GameCanvas.n[8]) {
                  if (indexTitle == 0) {
                     ++indexTitle;
                  } else if (indexTitle == 1) {
                     if (++av >= gm) {
                        av = 0;
                     }

                     go.a(av * go.h);
                  }

                  super.a = super.b = null;
                  this.aj();
               } else if (GameCanvas.n[4]) {
                  av = -1;
                  if (indexTitle == 1 && --indexSelect < 0) {
                     indexSelect = Char.getMyChar().nClass.c.length - 1;
                  }

                  super.a = super.b = null;
                  this.aj();
                  ba.a(indexSelect * ba.h);
                  go.a();
                  av = 0;
               } else if (GameCanvas.n[6]) {
                  av = -1;
                  if (indexTitle == 1 && ++indexSelect >= Char.getMyChar().nClass.c.length) {
                     indexSelect = 0;
                  }

                  super.a = super.b = null;
                  this.aj();
                  ba.a(indexSelect * ba.h);
                  go.a();
                  av = 0;
               }
            } else {
               if (indexTitle == 1 && av == -1) {
                  --indexTitle;
               } else if (indexTitle == 1 && av >= 0) {
                  --av;
               }

               go.a(av * go.h);
            }
         } else if (aw == 2) {
            if (GameCanvas.n[2]) {
               --indexTitle;
            } else if (GameCanvas.n[8]) {
               if (++indexTitle >= 5) {
                  indexTitle = 1;
               }

               super.a = super.b = null;
               this.aj();
            }
         } else if (aw == 3) {
            if (av < 0) {
               av = 0;
            }

            if (GameCanvas.n[2]) {
               if (av == 0) {
                  --indexTitle;
                  av = -1;
               } else {
                  --av;
               }

               ba.a(av * ba.h);
            } else if (GameCanvas.n[8]) {
               if (++av >= gm) {
                  av = 0;
               }

               ba.a(av * ba.h);
            }
         } else if (aw == 4) {
            var1 = indexSelect;
            if (indexSelect != 11 && indexSelect != 12 && indexSelect != 13 && indexSelect != 14) {
               if (indexSelect == 9) {
                  if (GameCanvas.n[2]) {
                     indexSelect -= 2;
                  } else if (GameCanvas.n[8]) {
                     indexSelect = 15;
                  } else if (GameCanvas.n[4]) {
                     --indexSelect;
                  } else if (GameCanvas.n[6]) {
                     ++indexSelect;
                  }
               } else if (indexSelect == 10) {
                  if (GameCanvas.n[2]) {
                     indexSelect -= 2;
                  } else if (GameCanvas.n[4]) {
                     --indexSelect;
                  } else if (GameCanvas.n[6] || GameCanvas.n[8]) {
                     ++indexSelect;
                  }
               } else if (indexSelect == 15) {
                  if (GameCanvas.n[2]) {
                     indexSelect = 9;
                  } else if (GameCanvas.n[4]) {
                     --indexSelect;
                  } else if (GameCanvas.n[8] || GameCanvas.n[6]) {
                     indexSelect = 0;
                  }
               } else if (GameCanvas.n[2]) {
                  if (indexSelect <= 1) {
                     indexSelect = 0;
                     indexTitle = 0;
                  } else {
                     indexSelect -= 2;
                  }
               } else if (GameCanvas.n[8]) {
                  if ((indexSelect += 2) > 15) {
                     indexSelect = 0;
                  }
               } else if (GameCanvas.n[4]) {
                  if (--indexSelect < 0) {
                     indexSelect = 15;
                  }
               } else if (GameCanvas.n[6] && ++indexSelect > 11) {
                  indexSelect = 0;
               }
            } else if (!GameCanvas.n[2] && !GameCanvas.n[4]) {
               if (GameCanvas.n[6] || GameCanvas.n[8]) {
                  ++indexSelect;
               }
            } else {
               --indexSelect;
            }

            if (var1 != indexSelect) {
               super.a = super.b = null;
               this.aj();
            }
         } else if (aw == 5) {
            if (GameCanvas.n[2]) {
               if (indexSelect == 4) {
                  indexSelect = 0;
                  --indexTitle;
               } else if (--indexSelect < 0) {
                  indexSelect = 0;
                  --indexTitle;
               }

               this.aj();
            } else if (!GameCanvas.n[4]) {
               if (GameCanvas.n[6]) {
                  if (indexSelect < 2) {
                     indexSelect = 4;
                  } else {
                     indexSelect = 2;
                  }

                  this.aj();
               } else if (GameCanvas.n[8]) {
                  if (++indexSelect >= 4) {
                     indexSelect = 0;
                  }

                  this.aj();
               }
            } else {
               if (indexSelect >= 2 && indexSelect != 4) {
                  indexSelect = 4;
               } else {
                  indexSelect = 0;
               }

               this.aj();
            }
         } else if (aw == 6) {
            if (qt == 0) {
               if (GameCanvas.n[2]) {
                  if (indexSelect == 4) {
                     indexSelect = 0;
                     --indexTitle;
                  } else if (--indexSelect < 0) {
                     indexSelect = 0;
                     --indexTitle;
                  }

                  this.aj();
               } else if (!GameCanvas.n[4]) {
                  if (GameCanvas.n[6]) {
                     if (indexSelect < 2) {
                        indexSelect = 4;
                     } else {
                        indexSelect = 2;
                     }

                     this.aj();
                  } else if (GameCanvas.n[8]) {
                     if (++indexSelect >= 4) {
                        indexSelect = 0;
                     }

                     this.aj();
                  }
               } else {
                  if (indexSelect >= 2 && indexSelect != 4) {
                     indexSelect = 4;
                  } else {
                     indexSelect = 0;
                  }

                  this.aj();
               }
            } else if (qt == 1) {
               if (GameCanvas.n[2]) {
                  --indexTitle;
               } else if (GameCanvas.n[8]) {
                  if (++indexTitle >= 5) {
                     indexTitle = 1;
                  }

                  super.a = super.b = null;
                  this.aj();
               }
            } else if (!GameCanvas.n[2]) {
               if (GameCanvas.n[8]) {
                  if (indexTitle == 0) {
                     ++indexTitle;
                  } else if (indexTitle == 1) {
                     if (++av >= gm) {
                        av = 0;
                     }

                     go.a(av * go.h);
                  }

                  super.a = super.b = null;
                  this.aj();
               } else if (GameCanvas.n[4]) {
                  av = -1;
                  if (indexTitle == 1 && --indexSelect < 0) {
                     indexSelect = Char.getMyChar().nClass.c.length - 1;
                  }

                  super.a = super.b = null;
                  this.aj();
                  ba.a(indexSelect * ba.h);
                  go.a();
                  av = 0;
               } else if (GameCanvas.n[6]) {
                  av = -1;
                  if (indexTitle == 1 && ++indexSelect >= Char.getMyChar().nClass.c.length) {
                     indexSelect = 0;
                  }

                  super.a = super.b = null;
                  this.aj();
                  ba.a(indexSelect * ba.h);
                  go.a();
                  av = 0;
               }
            } else {
               if (indexTitle == 1 && av == -1) {
                  --indexTitle;
               } else if (indexTitle == 1 && av >= 0) {
                  --av;
               }

               go.a(av * go.h);
            }
         }

         if (GameCanvas.g) {
            GameScr var3 = this;
            if (!GameCanvas.af.a && GameCanvas.aj == null) {
               label745: {
                  if (GameCanvas.r && GameCanvas.b(fe, fd, ff, this.pb) && (!cq || GameCanvas.aa >= 320) && GameCanvas.q) {
                     if (GameCanvas.b(k - 90, fd + 5, 60, 40)) {
                        indexSelect = 0;
                        --aw;
                     }

                     if (GameCanvas.b(k + 20, fd + 5, 60, 40)) {
                        indexSelect = 0;
                        ++aw;
                     }

                     cq = false;
                     ba.a();
                     go.a();
                     if (currentCharViewInfo.idChar != Char.getMyChar().idChar) {
                        if (aw < 3) {
                           aw = TextGame.fg.length - 1;
                        }

                        if (aw > TextGame.fg.length - 1) {
                           aw = 3;
                        }
                     } else {
                        if (aw < 0) {
                           aw = TextGame.fg.length - 1;
                        }

                        if (aw > TextGame.fg.length - 1) {
                           aw = 0;
                        }
                     }

                     indexTitle = 1;
                     indexSelect = -1;
                     this.be();
                  }

                  ScrollResult var4;
                  if (cq) {
                     if ((var4 = go.b()).a || var4.c) {
                        av = var4.b;
                        indexTitle = 1;
                     }

                     if (GameCanvas.i) {
                        break label745;
                     }
                  }

                  if (aw == 0) {
                     if ((var4 = ba.b()).a || var4.c) {
                        if (indexSelect != var4.b) {
                           indexSelect = var4.b;
                           if (indexSelect >= 0 && indexSelect < Char.getMyChar().arrItemBag.length && Char.getMyChar().arrItemBag[indexSelect] != null) {
                              this.showItemInfoSplit(3, Char.getMyChar().arrItemBag[indexSelect]);
                           } else {
                              cq = false;
                              super.a = super.b = null;
                           }
                        }

                        indexTitle = 1;
                     }
                  } else if (aw == 1) {
                     if (!(var4 = ba.b()).a && !var4.c) {
                        if (((var4 = go.b()).a || var4.c) && av != var4.b) {
                           av = var4.b;
                        }
                     } else {
                        if (indexSelect != var4.b) {
                           if ((indexSelect = var4.b) >= Char.getMyChar().nClass.c.length) {
                              indexSelect = -1;
                           }

                           super.a = super.b = null;
                           this.aj();
                           go.a();
                           av = 0;
                        }

                        indexTitle = 1;
                     }
                  } else if (aw == 2) {
                     if (GameCanvas.r && GameCanvas.b(fe + 5, fd + 52, ff - 10, 130) && GameCanvas.q) {
                        var1 = (GameCanvas.t - (fd + 52)) / 32;
                        ++var1;
                        if (var1 == this.mo) {
                           MyVector var2;
                           (var2 = new MyVector()).addElement(new Command1(TextGame.cy, 11064));
                           var2.addElement(new Command1(TextGame.cz, 11065));
                           GameCanvas.af.a(var2);
                        }

                        indexTitle = var1;
                        this.mo = var1;
                        this.aj();
                     }
                  } else if (aw == 3) {
                     if ((var4 = ba.b()).a || var4.c) {
                        av = var4.b;
                        indexTitle = 1;
                     }
                  } else if (aw == 4) {
                     if (GameCanvas.r) {
                        int gw = (cr && GameCanvas.aa >= 320) ? 175 : ff;
                        indexTitle = 1;
                        if (GameCanvas.b(fe + 4, fd + 35, indexSize, 130)) {
                           indexSelect = (GameCanvas.t - (fd + 35)) / indexSize << 1;
                           super.a = super.b = null;
                           this.aj();
                        }

                        if (GameCanvas.b(fe + gw - 30, fd + 35, indexSize, 130)) {
                           indexSelect = ((GameCanvas.v - (fd + 35)) / indexSize << 1) + 1;
                           super.a = super.b = null;
                           this.aj();
                        }

                        if (GameCanvas.b(fe + 4, fd + 165, gw - 8, indexSize)) {
                           var1 = (GameCanvas.u - (fe + 4)) / indexSize;
                           var1 += 10;
                           indexSelect = var1;
                           super.a = super.b = null;
                           this.aj();
                        }
                     }
                  } else if (aw == 5) {
                     if (GameCanvas.r) {
                        for(var1 = 0; var1 < var3.jw.length; ++var1) {
                           if (var1 == 4) {
                              if (GameCanvas.b(var3.jw[var1], var3.jx[var1], 84, 75) && GameCanvas.q) {
                                 indexTitle = 1;
                                 indexSelect = 4;
                                 var3.aj();
                                 if (!GameCanvas.i) {
                                    if (currentCharViewInfo.arrItemMounts[indexSelect] != null) {
                                       if (GameCanvas.j) {
                                          if (var3.b != null) {
                                             var3.b(var3.b.d, var3.b.k);
                                          }
                                       } else if (!cq || var3.gn != currentCharViewInfo.arrItemMounts[indexSelect]) {
                                          var3.showItemInfoSplit(41, currentCharViewInfo.arrItemMounts[indexSelect]);
                                       }
                                    } else {
                                       cq = false;
                                    }
                                 }
                              }
                           } else if (GameCanvas.b(var3.jw[var1], var3.jx[var1], indexSize, indexSize) && GameCanvas.q) {
                              indexTitle = 1;
                              indexSelect = var1;
                              var3.aj();
                              if (!GameCanvas.i) {
                                 if (currentCharViewInfo.arrItemMounts[indexSelect] != null) {
                                    if (GameCanvas.j) {
                                       if (var3.b != null) {
                                          var3.b(var3.b.d, var3.b.k);
                                       }
                                    } else if (!cq || var3.gn != currentCharViewInfo.arrItemMounts[indexSelect]) {
                                       var3.showItemInfoSplit(41, currentCharViewInfo.arrItemMounts[indexSelect]);
                                    }
                                 } else {
                                    cq = false;
                                 }
                              }
                           }
                        }
                     }
                  } else if (aw == 6) {
                     if (qt == 0) {
                        if (GameCanvas.r) {
                           for(var1 = 0; var1 < var3.jw.length; ++var1) {
                              if (var1 == 4) {
                                 if (GameCanvas.b(var3.jw[var1], var3.jx[var1], 84, 75) && GameCanvas.q) {
                                    indexTitle = 1;
                                    indexSelect = 4;
                                    var3.aj();
                                    if (!GameCanvas.i) {
                                       if (currentCharViewInfo.cf[indexSelect] != null) {
                                          if (GameCanvas.j) {
                                             if (var3.b != null) {
                                                var3.b(var3.b.d, var3.b.k);
                                             }
                                          } else if (!cq || var3.gn != currentCharViewInfo.cf[indexSelect]) {
                                             var3.showItemInfoSplit(51, currentCharViewInfo.cf[indexSelect]);
                                          }
                                       } else {
                                          cq = false;
                                       }
                                    }
                                 }
                              } else if (GameCanvas.b(var3.jw[var1], var3.jx[var1], indexSize, indexSize) && GameCanvas.q) {
                                 indexTitle = 1;
                                 indexSelect = var1;
                                 var3.aj();
                                 if (!GameCanvas.i) {
                                    if (currentCharViewInfo.cf[indexSelect] != null) {
                                       if (GameCanvas.j) {
                                          if (var3.b != null) {
                                             var3.b(var3.b.d, var3.b.k);
                                          }
                                       } else if (!cq || var3.gn != currentCharViewInfo.cf[indexSelect]) {
                                          var3.showItemInfoSplit(51, currentCharViewInfo.cf[indexSelect]);
                                       }
                                    } else {
                                       cq = false;
                                    }
                                 }
                              }
                           }
                        }
                     } else if (qt == 1) {
                        if (GameCanvas.r && GameCanvas.b(fe + 5, fd + 52, ff - 10, 130) && GameCanvas.q) {
                           var1 = (GameCanvas.t - (fd + 52)) / 32;
                           ++var1;
                           if (var1 == this.mo) {
                              hu();
                           }

                           indexTitle = var1;
                           this.mo = var1;
                           this.aj();
                        }
                     } else if (!(var4 = ba.b()).a && !var4.c) {
                        if (((var4 = go.b()).a || var4.c) && av != var4.b) {
                           av = var4.b;
                        }
                     } else {
                        if (indexSelect != var4.b) {
                           if ((indexSelect = var4.b) >= Char.getMyChar().nClass.c.length) {
                              indexSelect = -1;
                           }

                           super.a = super.b = null;
                           this.aj();
                           go.a();
                           av = 0;
                        }

                        indexTitle = 1;
                     }
                  }
               }
            }
         }

         GameCanvas.i();
         GameCanvas.h();
      }

   }

   private static Member bw() {
      return (Member)vClan.elementAt(av);
   }

   private void bx() {
      if (!cq) {
         super.a = super.b = null;
         if (aw == 0) {
            if (Char.getMyChar().ctypeClan == 4) {
               super.a = new Command1(TextGame.nt[0], 14004);
            }

            if (Char.getMyChar().ctypeClan == 3) {
               super.a = new Command1(TextGame.nt[1], 14004);
            }

            if (Char.getMyChar().ctypeClan == 2) {
               super.a = new Command1(TextGame.nt[2], 14004);
            }

            if (!Char.getMyChar().cClanName.equals("")) {
               if (indexTitle == 1) {
                  super.b = new Command1(TextGame.ax, 140101);
                  return;
               }

               super.b = new Command1(TextGame.nv[3], 14010);
               return;
            }
         } else if (aw == 1) {
            Member var1;
            if (vClan.size() > 0 && av >= 0 && av < vClan.size() && (var1 = bw()) != null) {
               if (Char.getMyChar().ctypeClan == 4) {
                  super.a = new Command1(TextGame.nt[0], 14005);
               }

               if (Char.getMyChar().ctypeClan == 3) {
                  super.a = new Command1(TextGame.nt[1], 14005);
               }

               if (Char.getMyChar().ctypeClan != 4 && Char.getMyChar().ctypeClan != 3) {
                  super.a = new Command1(TextGame.nt[4], 14005);
               }

               if (!var1.d.equals(Char.getMyChar().cName) && (!gr || this.ml != 0)) {
                  super.b = new Command1(TextGame.doa, 14006, var1.d);
                  return;
               }
            }
         } else if (aw == 2 && indexTitle == 1) {
            if (Char.be == null || Char.be.p == null) {
               return;
            }

            super.a = new Command1(TextGame.doa, 1508);
            if (!GameCanvas.j) {
               super.b = new Command1(GameCanvas.g ? TextGame.ax : "", 1509);
            }
         }
      }

   }

   private void by() {
      if (co && GameCanvas.aj == null) {
         boolean var1 = false;
         if (GameCanvas.n[8]) {
            if (++av >= this.jb.size()) {
               av = 0;
            }

            var1 = true;
         } else if (GameCanvas.n[2]) {
            if (--av < 0) {
               av = this.jb.size() - 1;
            }

            var1 = true;
         }

         if (var1) {
            ba.a(av * ba.h);
            GameCanvas.i();
            GameCanvas.h();
         }

         ScrollResult var2;
         if (GameCanvas.g && ((var2 = ba.b()).a || var2.c)) {
            av = var2.b;
            var1 = true;
         }

         ChatTab var5;
         if (cu && !GameCanvas.g && (var5 = ChatManager.d().e()).a == 2 && av == 0) {
            ChatTextField.a().f = new Command1(TextGame.ai, 120051, var5);
         }

         if (var1 && av >= 0 && av < this.jb.size()) {
            String var6 = (String)this.jb.elementAt(av);
            var1 = false;
            this.oc = null;
            this.ob = null;
            super.b = null;
            ChatTextField.a().f = null;
            int var7;
            if ((var7 = var6.indexOf("http://")) >= 0) {
               this.ob = var6.substring(var7);
               super.b = new Command1(TextGame.as, 12000);
               if (!GameCanvas.g) {
                  ChatTextField.a().f = new Command1(TextGame.as, (IActionListener)null, 12000, (Object)null);
                  return;
               }
            } else if (var6.indexOf("@") >= 0) {
               var7 = (var6 = var6.substring(2).trim()).indexOf("@");
               String var3 = var6.substring(var7);
               int var8;
               if ((var8 = var3.indexOf(" ")) <= 0) {
                  var8 = var7 + var3.length();
               } else {
                  var8 += var7;
               }

               this.oc = var6.substring(var7 + 1, var8);
               if (!this.oc.equals("") && !this.oc.equals(Char.getMyChar().cName) && !this.oc.equals(TextGame.qo.substring(0, 5)) && !this.oc.equals(TextGame.qo)) {
                  super.b = new Command1(TextGame.doa, 12009, this.oc);
                  if (!GameCanvas.g) {
                     ChatTextField.a().f = new Command1(TextGame.doa, (IActionListener)null, 12009, this.oc);
                     return;
                  }
               } else {
                  this.oc = null;
                  super.b = null;
               }
            }
         }
      }

   }

   private void bz() {
      if (cu) {
         boolean var1 = false;
         if (GameCanvas.n[4]) {
            var1 = true;
            ChatManager.d().b();
         } else if (GameCanvas.n[6]) {
            var1 = true;
            ChatManager.d().a();
         }

         if (var1) {
            this.fk();
         }

         if (GameCanvas.g && GameCanvas.b(fe, fd, ff, this.pb) && (!cq || GameCanvas.aa >= 320) && GameCanvas.q && GameCanvas.r) {
            if (GameCanvas.b(k - 90, fd + 5, 60, 40)) {
               ChatManager.d().b();
               this.fk();
            }

            if (GameCanvas.b(k + 20, fd + 5, 60, 40)) {
               ChatManager.d().a();
               this.fk();
            }
         }
      }

   }

   private void ca() {
      if (av >= 0 && vCharInMap.size() > 0) {
         if (Char.d(this.dm) == av) {
            super.a = new Command1(TextGame.dp, 14002);
         } else {
            super.a = new Command1(TextGame.doa, 14003);
            super.b = new Command1("Dịch chuyển", 1400343);
            super.c = this.ne;
         }
      } else {
         super.a = super.b = null;
      }

   }

   private void cb() {
      if (vList.size() > 0 && av >= 0 && gm > 0) {
         super.b = new Command1(TextGame.v, 14024);
         super.a = new Command1(TextGame.w, 14025);
      } else {
         super.b = null;
         super.a = null;
      }

   }

   private void cc() {
      if (vList.size() > 0 && av >= 0 && gm > 0) {
         super.b = new Command1(TextGame.doa, 14021);
      } else {
         super.b = null;
      }

   }

   private void cd() {
      if (vEnemies.size() > 0 && av >= 0 && gm > 0) {
         super.b = new Command1(TextGame.doa, 11078);
      } else {
         super.b = null;
      }

   }

   private void ce() {
      if (vFriend.size() > 0 && av >= 0 && gm > 0 && av < vFriend.size()) {
         vFriend.elementAt(av);
         super.b = new Command1(TextGame.doa, 11079);
      } else {
         super.b = null;
      }

   }

   private void cf() {
      super.b = null;
      if (av != -1) {
         Party var1;
         if (((Party)vParty.elementAt(0)).a == Char.getMyChar().idChar) {
            if ((var1 = (Party)vParty.elementAt(av)).a != Char.getMyChar().idChar) {
               super.b = new Command1(TextGame.doa, 11080, var1.d);
               return;
            }
         } else if ((var1 = (Party)vParty.elementAt(av)).a != Char.getMyChar().idChar) {
            super.b = new Command1(TextGame.doa, 12009, var1.d);
         }
      }

   }

   private static long cgLastLog = 0;
   private static boolean cg() {
      boolean result = gu || ig || cq || cr || hb || hc || ih || hr || hd || he || hf || hg || hh || hi || hj || hk || hl || hm || hn || ho || hp || hq || hs || ht || hu || hv || hw || cn || hx || ib || ij || ik || hz || ii || ia || cs || co || id || ct || gw || ie || gx || gv || cp || gy || gz || ic || cu || ip || il || ir || im || iq || in || io || phong2.isItemDel || phong2.isItemPick;
      if (result && System.currentTimeMillis() - cgLastLog > 2000) {
         cgLastLog = System.currentTimeMillis();
         DebugLog.log("CG-HIDE",
            "gu="+gu+" ig="+ig+" cq="+cq+" cr="+cr+" co="+co+" id="+id+" ct="+ct
            +" gw="+gw+" ie="+ie+" gx="+gx+" gv="+gv+" cp="+cp+" gy="+gy+" gz="+gz
            +" ic="+ic+" cu="+cu+" ip="+ip+" il="+il+" ir="+ir+" im="+im+" iq="+iq+" in="+in+" io="+io
            +" hb="+hb+" hc="+hc+" hr="+hr+" cn="+cn+" hx="+hx+" ih="+ih+" ia="+ia+" cs="+cs
            +" ib="+ib+" ij="+ij+" ik="+ik+" hz="+hz+" ii="+ii
            +" isItemDel="+phong2.isItemDel+" isItemPick="+phong2.isItemPick);
      }
      return result;
   }

   private boolean ch() {
      if (GameCanvas.g && !Char.eg && !id && !ct) {
         if (ChatTextField.a().b) {
            return true;
         } else if (super.b == this.fj && GameCanvas.j) {
            return true;
         } else {
            return GameCanvas.aj != null || ChatPopup.f != null || GameCanvas.af.a || cg();
         }
      } else {
         return true;
      }
   }

   public static boolean aa() {
      return ct || hb || ig || hc || hr || hd || he || hf || hg || hh || hi || hj || hk || hl || hm || hn || ho || hp || hq || hs || ht || hu || hv || hw || ih || cn || hx || ib || ij || ik || hz || ii || ia || cs || il || ir || im || iq || in || io || phong2.isItemDel || phong2.isItemPick;
   }

   // Helper cho auto luyện ngọc: true nếu có UI khác (ngoài luyện ngọc) đang mở → auto skip
   public static boolean isOtherUIOpen_luyenngoc() {
      return ij || ik || ir || im || hw || hb || hc || ig || ib || iq;
   }

   private static boolean ci() {
      return ct || cq || ig || cr || hb || hc || hr || hd || he || hf || hg || hh || hi || hj || hk || hl || hm || hn || ho || hp || hq || hs || ht || hu || hv || hw || ih || cn || hx || ib || ij || ik || hz || ii || ia || cs || il || ir || im || iq || in || io || phong2.isItemDel || phong2.isItemPick;
   }

   private static boolean cj() {
      return gu || cr && aw == 6 && qt != 0 || cr && aw > 0 && aw < 5 || ct || id || ie && (aw == 0 || aw == 1 || aw == 3 || aw == 4) || ic || gw || gx || cp || gy || gz || gv || cu || co || ip;
   }

   private static boolean javaDocCompactUi() {
      return com.monkey.nso.NSO.lockedTypeClient == 2 && GameCanvas.aa < GameCanvas.ab;
   }

   private static boolean javaDocBagLayout() {
      return javaDocCompactUi() && cr && aw == 0;
   }

   private static void clampJavaDocScroll(Scroll var0) {
      if (javaDocCompactUi() && var0 != null && var0.b < 0) {
         var0.b = 0;
      }
   }

   private static void applyJavaDocGridClipOrScroll(mGraphics var0, int var1, int var2, int var3, int var4) {
      if (javaDocCompactUi()) {
         ba.a = 0;
         var0.d(var1, var2, var3, var4);
         var0.a(-var0.a(), -var0.b());
      } else {
         ba.a(var0, var1, var2, var3, var4);
      }
   }

   private static int javaDocBagFirstRow() {
      return javaDocCompactUi() ? Math.max(0, ba.b / indexSize) : 0;
   }

   private static int javaDocBagRowLimit(int var0) {
      if (!javaDocCompactUi()) {
         return var0;
      }

      int var1 = javaDocBagFirstRow();
      int var2 = javaDocBagVisibleRows(var0) + (ba.b % indexSize == 0 ? 0 : 1);
      return Math.min(var0, var1 + var2);
   }

   private static boolean javaDocBagRowVisible(int var0, int var1) {
      return !javaDocCompactUi() || var0 >= javaDocBagFirstRow() && var0 < javaDocBagRowLimit(var1);
   }

   private static int javaDocBagRowY(int var0) {
      return oe + var0 * indexSize - (javaDocCompactUi() ? ba.b : 0);
   }

   private static int javaDocBagGridTopOffset() {
      return javaDocBagLayout() ? 24 : 32;
   }

   private static int javaDocBagVisibleRows(int var0) {
      return javaDocBagLayout() ? Math.min(var0, 9) : 5;
   }

   private static int javaDocBagViewportHeight(int var0) {
      return javaDocBagVisibleRows(var0) * indexSize;
   }

   private static int javaDocBagFrameRows() {
      return javaDocBagLayout() ? 9 : 5;
   }

   private static int javaDocBagCurrentRows() {
      Item[] var0 = Char.getMyChar().arrItemBag;
      if (var0 == null || var0.length <= 30) {
         return 5;
      }

      int var1 = var0.length / oj;
      if (var0.length % oj > 0) {
         ++var1;
      }

      return Math.min(var1, 9);
   }

   private static int javaDocBagPanelHeight() {
      return javaDocBagGridTopOffset() + javaDocBagCurrentRows() * indexSize + 44;
   }

   private static int javaDocPanelHeightLimit(int var0) {
      int var1 = GameCanvas.ab - 20;
      return var1 < var0 ? var0 : var1;
   }

   private static int javaDocCrPanelHeight(int var0) {
      if (!javaDocCompactUi() || !cr) {
         return var0;
      }

      int var1 = var0;
      if (aw == 0) {
         var1 = javaDocBagPanelHeight();
      } else if (aw == 3 || aw == 4) {
         var1 = 320;
      }

      var1 = Math.max(var0, var1);
      return Math.min(var1, javaDocPanelHeightLimit(var0));
   }

   private static void logJavaDocBagLayout(mGraphics var0, String var1) {
      if (!javaDocCompactUi()) {
         return;
      }

      long var2 = System.currentTimeMillis();
      if (var2 - lastJavaDocBagLogMs < 2500L) {
         return;
      }

      lastJavaDocBagLogMs = var2;
      try {

      } catch (Throwable ignore) {}
   }

   private static void logJavaDocCrLayout(String var0) {
      if (!javaDocCompactUi() || !cr) {
         return;
      }

      long var1 = System.currentTimeMillis();
      if (var1 - lastJavaDocCrLogMs < 2500L) {
         return;
      }

      lastJavaDocCrLogMs = var1;
      try {

      } catch (Throwable ignore) {}
   }

   private static void a(Item var0) {
      Command1 var1 = new Command1(TextGame.dc, 11055, var0);
      GameCanvas.al.a(TextGame.jy, var1, 1);
   }

   private static void b(Item var0) {
      if (var0.quantity > 1) {
         Command1 var1 = new Command1(TextGame.dc, 110562, var0);
         GameCanvas.al.a(TextGame.jy, var1, 1);
      } else {
         GameCanvas.a(TextGame.ki, new Command1(TextGame.bh, 11061, var0), new Command1(TextGame.bu, 1));
      }

   }

   private static void ck() {
      Command1 var0 = new Command1(TextGame.dc, 11042);
      GameCanvas.al.a(TextGame.jx, var0, 1);
   }

   private static void cl() {
      Command1 var0 = new Command1(TextGame.dc, 110361);
      GameCanvas.al.a(TextGame.jx, var0, 1);
   }

   private static void cm() {
      Command1 var0 = new Command1(TextGame.dc, 11043);
      GameCanvas.al.a(TextGame.jx, var0, 1);
   }

   public final void ab() {
      if (GameCanvas.aj == null && aa()) {
         GameScr var1;
         int var3;
         int var4;
         int var5;
         int var6;
         int var11;
         if (indexTitle == 0) {
            var1 = this;
            super.a = super.b = null;
            if (!ig) {
               if (ia) {
                  if (fk.equals("")) {
                     if (aw == 0) {
                        super.a = new Command1(TextGame.aa, 11115);
                     } else if (aw == 1) {
                        super.a = new Command1(TextGame.aa, 11116);
                     }
                  } else {
                     super.a = null;
                  }
               } else if (aw == 1 && cs && this.dh == 0) {
                  super.a = this.my;
               } else if (aw == 1 && !hb && !hc && !hz && !ii && !hw && !hx && !ib && !ij && !ik && !cs && !ih && !cn && !il && !ir && !im && !iq && !in && !io) {
                  super.a = new Command1(TextGame.bd, 110221);
               }

               Item var2;
               if (ii && aw == 0) {
                  var11 = 0;
                  var3 = 0;
                  var4 = 0;
                  var5 = 0;

                  for(var6 = 0; var6 < bz.length; ++var6) {
                     if ((var2 = bz[var6]) != null) {
                        if (var2.template.id == 455) {
                           ++var11;
                        } else if (var2.template.id == 456) {
                           ++var3;
                        } else if (var2.template.type == 26) {
                           ++var4;
                           var5 = var2.template.id;
                        }
                     }
                  }

                  if (var11 >= 9 || var3 >= 9 || var5 >= 10 && var11 >= 3 && var4 == 1 || var5 >= 11 && var3 >= 3 && var4 == 1) {
                     super.a = new Command1(TextGame.ev, 1600);
                  }
               } else if (ij) {
                  try {
                     if (aw == 0) {
                        if (indexTitle == 1) {
                           if (cj != null) {
                              var1.a = new Command1(TextGame.doa, 11103);
                           } else {
                              cq = false;
                           }

                           if (GameCanvas.j) {
                              var1.a((int)3, (Item)cj);
                           } else {
                              var1.b = new Command1(GameCanvas.g ? TextGame.ax : "", 11104, cj);
                           }
                        } else if (indexTitle == 2) {
                           if ((var2 = cb[indexSelect]) != null) {
                              if (GameCanvas.j) {
                                 var1.a((int)3, (Item)var2);
                              } else {
                                 var1.b = new Command1(GameCanvas.g ? TextGame.ax : "", 11104, var2);
                              }

                              var1.a = new Command1(TextGame.bj, 1605);
                           } else {
                              cq = false;
                           }

                           if (cj != null) {
                              var1.a = new Command1(TextGame.doa, 1604);
                           }
                        }
                     } else if (aw == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                           var1.a = null;
                           cq = false;
                        } else {
                           var1.a = new Command1(TextGame.doa, 11106);
                        }
                     }
                  } catch (Exception var9) {
                  }
               } else if (ik) {
                  if (aw == 0) {
                     if (indexTitle != 1) {
                        if (indexTitle == 2) {
                           if ((var2 = cb[indexSelect]) != null) {
                              if (GameCanvas.j) {
                                 this.a((int)3, (Item)var2);
                              } else {
                                 super.b = new Command1(GameCanvas.g ? TextGame.ax : "", 11104, var2);
                              }
                           } else {
                              cq = false;
                           }

                           if (cj != null && cj.upgrade > 13) {
                              super.a = new Command1(TextGame.doa, 1604);
                           }
                        }
                     } else {
                        if (cj != null && cj.upgrade > 13) {
                           super.a = new Command1(TextGame.doa, 11103);
                        } else if (cj != null) {
                           super.a = this.mx;
                        } else {
                           cq = false;
                        }

                        if (GameCanvas.j) {
                           this.a((int)3, (Item)cj);
                        } else {
                           super.b = new Command1(GameCanvas.g ? TextGame.ax : "", 11104, cj);
                        }
                     }
                  } else if (aw == 1) {
                     if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                        super.a = null;
                        cq = false;
                     } else {
                        super.a = new Command1(TextGame.doa, 1606);
                     }
                  }
               }

               if (hz && aw == 0) {
                  var11 = 0;

                  for(var3 = 0; var3 < bz.length; ++var3) {
                     if (bz[var3] != null) {
                        ++var11;
                        if (var11 >= 2) {
                           super.a = new Command1(TextGame.ev, 11062);
                           break;
                        }
                     }
                  }
               }

               if (hw && aw == 0 && ci != null) {
                  for(var11 = 0; var11 < ca.length; ++var11) {
                     if (ca[var11] != null) {
                        super.b = new Command1("", 110981);
                        super.a = new Command1(TextGame.ev, 110981);
                        break;
                     }
                  }
               }

               if (im && aw == 0 && ci != null && cj != null) {
                  for(var11 = 0; var11 < ca.length; ++var11) {
                     if (ca[var11] != null) {
                        super.b = new Command1("", 341);
                        super.a = new Command1(TextGame.ev, 341);
                        break;
                     }
                  }
               }

               if (cn && aw == 0 && ck != null && this.jd != null && !this.jd.d().equals("") && Char.getMyChar().xu >= 5000) {
                  super.a = new Command1(TextGame.bo, 15002);
               }

               if (hx && aw == 0 && indexTitle == 0) {
                  for(var11 = 0; var11 < ce.length; ++var11) {
                     if (ce[var11] == null) {
                        var1.a = null;
                        break;
                     }

                     if (var11 == ce.length - 1) {
                        var1.a = new Command1(TextGame.ev, 140131);
                     }
                  }
               }

               if (ib && aw == 0 && cj != null && cj.upgrade > 0) {
                  var1.a = new Command1(TextGame.ev, 11105);
               }

               if (cs && aw == 0) {
                  if (var1.dh == 0) {
                     var1.a = var1.mq;
                  } else if (var1.dh == 1 && var1.di >= 1 && (long)var1.dl - System.currentTimeMillis() / 1000L <= 0L) {
                     var1.a = var1.mr;
                  }
               }

               if (GameCanvas.n[8]) {
                  indexTitle = 1;
                  indexSelect = 0;
                  av = -1;
                  ba.a();
                  go.a();
                  var1.ac();
               }

               if (GameCanvas.n[4]) {
                  indexSelect = 0;
                  av = -1;
                  --aw;
                  ba.a();
                  go.a();
                  if (ih) {
                     if (aw < 0) {
                        aw = TextGame.qn.length - 1;
                     }

                     Service.gI().menu((byte)0, 28, 0, aw);
                     cf = null;
                     indexSelect = -1;
                  } else if (!hc && !ct) {
                     if (aw < 0) {
                        if (hb) {
                           aw = TextGame.gb.length - 1;
                        } else {
                           aw = 1;
                        }
                     }
                  } else {
                     aw = 0;
                  }

                  var1.a = var1.b = null;
                  if (hb) {
                     co();
                  }

                  if (hc && bv == null && aw == 0) {
                     Service.gI().i(35);
                  }
               }

               if (GameCanvas.n[6]) {
                  indexSelect = 0;
                  av = -1;
                  ++aw;
                  ba.a();
                  go.a();
                  if (ih) {
                     if (aw > TextGame.qn.length - 1) {
                        aw = 0;
                     }

                     Service.gI().menu((byte)0, 28, 0, aw);
                     cf = null;
                     indexSelect = -1;
                  } else if (!hc && !ct) {
                     if (hb) {
                        if (aw > TextGame.gb.length - 1) {
                           aw = 0;
                        }
                     } else if (aw > 1) {
                        aw = 0;
                     }
                  } else {
                     aw = 0;
                  }

                  var1.a = var1.b = null;
                  if (hb) {
                     co();
                  }

                  if (hc && bv == null && aw == 0) {
                     Service.gI().i(35);
                  }
               }
            }
         } else if (indexTitle >= 1) {
            // Phím mũi tên: ia (Rương đồ) vẫn cần điều hướng lưới -> giữ nguyên exclude ia.
            if (cq && !ia && aw != 4 && !aa()) {
               if (GameCanvas.n[2]) {
                  if (--av < 0) {
                     av = gm - 1;
                  }

                  go.a(av * go.h);
               } else if (GameCanvas.n[8]) {
                  if (++av >= gm) {
                     av = 0;
                  }

                  go.a(av * go.h);
               }
            } else {
               if (ct) {
                  if (GameCanvas.n[2]) {
                     if (--av < 0) {
                        av = gm;
                     }

                     ba.a(av * ba.h);
                  } else if (GameCanvas.n[4]) {
                     if (av == 0) {
                        if ((Char.ds -= 10) < 10) {
                           Char.ds = 10;
                        }
                     } else if (av == 1) {
                        if ((Char.dt -= 10) < 10) {
                           Char.dt = 10;
                        }
                     } else if (av == 2 && (Char.du -= 10) <= 0) {
                        Char.du = 1;
                     } else if (av == 5 && (Char.lv_hpmp -= 20) <= 0) {
                        Char.lv_hpmp = 1;
                     } else if (av == 6 && --Char.lv_da <= 0) {
                        Char.lv_da = 1;
                     } else if (av == 7 && --Char.lv_luyenda <= 4) {
                        Char.lv_luyenda = 4;
                     } else if (av == 8 && --Char.lv_tbi < 0) {
                        Char.lv_tbi = 0;
                     }
                  } else if (GameCanvas.n[6]) {
                     if (av == 0) {
                        if ((Char.ds += 10) > 90) {
                           Char.ds = 90;
                        }
                     } else if (av == 1) {
                        if ((Char.dt += 10) > 90) {
                           Char.dt = 90;
                        }
                     } else if (av == 2) {
                        if (Char.du == 1) {
                           Char.du = 10;
                        } else if ((Char.du += 10) > 70) {
                           Char.du = 70;
                        }
                     } else if (av == 5) {
                        if (Char.lv_hpmp == 1) {
                           Char.lv_hpmp = 10;
                        } else if ((Char.du += 20) > 70) {
                           Char.lv_hpmp = 70;
                        }
                     } else if (av == 6) {
                        if (Char.lv_da++ > 7) {
                           Char.lv_da = 7;
                        }
                     } else if (av == 7) {
                        if (Char.lv_luyenda++ > 10) {
                           Char.lv_da = 10;
                        }
                     } else if (av == 8 && ++Char.lv_tbi > 7) {
                        Char.lv_tbi = 7;
                     }
                  } else if (GameCanvas.n[8]) {
                     if (++av > gm) {
                        av = 0;
                     }

                     ba.a(av * ba.h);
                  }

                  if (!GameCanvas.g) {
                     GameCanvas.i();
                     GameCanvas.h();
                  }
               } else if (cs && aw == 0) {
                  if (indexTitle == 1) {
                     if (GameCanvas.n[4]) {
                        if (--indexSelect < 0) {
                           indexSelect = 11;
                        }

                        super.a = super.b = null;
                        this.ac();
                     } else if (GameCanvas.n[6]) {
                        if (indexSelect == 2) {
                           indexTitle = 2;
                           indexSelect = 0;
                        } else if (indexSelect == 5) {
                           indexTitle = 2;
                           indexSelect = 3;
                        } else if (indexSelect == 8) {
                           indexTitle = 2;
                           indexSelect = 6;
                        } else if (indexSelect == 11) {
                           indexTitle = 2;
                           indexSelect = 9;
                        } else if (indexSelect == 14) {
                           indexTitle = 2;
                           indexSelect = 12;
                        } else if (++indexSelect >= 12) {
                           indexSelect = 0;
                        }

                        super.a = super.b = null;
                        this.ac();
                     } else if (GameCanvas.n[8]) {
                        if (indexSelect + 3 <= 11) {
                           indexSelect += 3;
                        }

                        super.a = super.b = null;
                        this.ac();
                     } else if (GameCanvas.n[2]) {
                        if (indexSelect >= 0 && indexSelect < 3) {
                           indexTitle = 0;
                           indexSelect = 0;
                        } else if (indexSelect - 3 >= 0) {
                           indexSelect -= 3;
                        }

                        super.a = super.b = null;
                        this.ac();
                     }
                  } else if (indexTitle == 2) {
                     if (GameCanvas.n[4]) {
                        if (indexSelect == 0) {
                           indexTitle = 1;
                           indexSelect = 2;
                        } else if (indexSelect == 3) {
                           indexTitle = 1;
                           indexSelect = 5;
                        } else if (indexSelect == 6) {
                           indexTitle = 1;
                           indexSelect = 8;
                        } else if (indexSelect == 9) {
                           indexTitle = 1;
                           indexSelect = 11;
                        } else if (indexSelect == 12) {
                           indexTitle = 1;
                           indexSelect = 14;
                        } else if (--indexSelect < 0) {
                           indexSelect = 11;
                        }

                        super.a = super.b = null;
                        this.ac();
                     } else if (GameCanvas.n[6]) {
                        if (++indexSelect >= 12) {
                           indexSelect = 0;
                        }

                        super.a = super.b = null;
                        this.ac();
                     } else if (GameCanvas.n[8]) {
                        if (indexSelect + 3 <= 11) {
                           indexSelect += 3;
                        }

                        super.a = super.b = null;
                        this.ac();
                     } else if (GameCanvas.n[2]) {
                        if (indexSelect >= 0 && indexSelect < 3) {
                           indexTitle = 0;
                           indexSelect = 0;
                        } else if (indexSelect - 3 >= 0) {
                           indexSelect -= 3;
                        }

                        super.a = super.b = null;
                        this.ac();
                     }
                  }

                  if (!GameCanvas.g) {
                     GameCanvas.i();
                     GameCanvas.h();
                  }
               } else if (ig) {
                  if (GameCanvas.n[4]) {
                     if (--indexSelect < 0) {
                        indexSelect = 8;
                     }
                  } else if (GameCanvas.n[6]) {
                     if (++indexSelect > 8) {
                        indexSelect = 0;
                     }
                  } else if (GameCanvas.n[8]) {
                     if (indexSelect + 3 < 9) {
                        indexSelect += 3;
                     }
                  } else if (GameCanvas.n[2] && indexSelect - 3 >= 0) {
                     indexSelect -= 3;
                  }

                  if (!GameCanvas.g) {
                     GameCanvas.i();
                     GameCanvas.h();
                  }
               } else if (cn && aw == 0) {
                  if (GameCanvas.n[2]) {
                     if (--indexTitle < 0) {
                        indexTitle = 0;
                     }
                  } else if (GameCanvas.n[8] && ++indexTitle > 2) {
                     indexTitle = 2;
                  }

                  this.ac();
               } else if (ih) {
                  if (GameCanvas.n[4]) {
                     if (cf != null) {
                        if ((indexSelect -= 5) < 0) {
                           indexSelect = cf.length - 1;
                        }

                        ba.a(indexSelect * ba.h);
                        this.ac();
                     }
                  } else if (GameCanvas.n[6]) {
                     if (cf != null) {
                        if ((indexSelect += 5) >= cf.length) {
                           indexSelect = 0;
                        }

                        ba.a(indexSelect * ba.h);
                        this.ac();
                     }
                  } else if (GameCanvas.n[8]) {
                     if (cf != null) {
                        if (++indexSelect >= cf.length) {
                           indexSelect = 0;
                        }

                        ba.a(indexSelect * ba.h);
                        this.ac();
                     }
                  } else if (GameCanvas.n[2] && cf != null) {
                     if (--indexSelect < 0) {
                        indexTitle = 0;
                     }

                     ba.a(indexSelect * ba.h);
                     this.ac();
                  }

                  GameCanvas.i();
                  GameCanvas.h();
               } else if ((iq || im || hw || hx) && indexTitle == 1 && aw == 0) {
                  if (GameCanvas.n[4]) {
                     if (--indexSelect < 0) {
                        indexSelect = 1;
                     }

                     super.a = super.b = null;
                     this.ac();
                  } else if (GameCanvas.n[6]) {
                     if (++indexSelect > 1) {
                        indexSelect = 0;
                     }

                     super.a = super.b = null;
                     this.ac();
                  } else if (GameCanvas.n[8]) {
                     indexTitle = 2;
                     indexSelect = 0;
                     super.a = super.b = null;
                     this.ac();
                  } else if (GameCanvas.n[2]) {
                     indexTitle = 0;
                     indexSelect = 0;
                     super.a = super.b = null;
                     this.ac();
                  }

                  if (!GameCanvas.g) {
                     GameCanvas.i();
                     GameCanvas.h();
                  }
               } else if ((ib || ij || ik || il || ir) && indexTitle == 1 && aw == 0) {
                  if (GameCanvas.n[8]) {
                     indexTitle = 2;
                     indexSelect = 0;
                     super.a = super.b = null;
                     this.ac();
                  } else if (GameCanvas.n[2]) {
                     indexTitle = 0;
                     indexSelect = 0;
                     super.a = super.b = null;
                     this.ac();
                  }

                  GameCanvas.i();
                  GameCanvas.h();
               } else if ((in || io) && aw == 0) {
                  if (GameCanvas.n[2]) {
                     if (--indexTitle < 0) {
                        indexTitle = 0;
                     }
                  } else if (GameCanvas.n[8] && ++indexTitle > 1) {
                     indexTitle = 1;
                  }

                  this.ac();
               }

               int var10 = cn();
               if (GameCanvas.n[4]) {
                  if (--indexSelect < 0) {
                     indexSelect = var10 - 1;
                  }

                  super.a = super.b = null;
                  this.ac();
                  ba.a(indexSelect / oj * ba.h);
               } else if (GameCanvas.n[6]) {
                  if (++indexSelect >= var10) {
                     indexSelect = 0;
                  }

                  super.a = super.b = null;
                  this.ac();
                  ba.a(indexSelect / oj * ba.h);
               } else if (GameCanvas.n[8]) {
                  if (indexSelect + oj <= var10 - 1) {
                     indexSelect += oj;
                  }

                  super.a = super.b = null;
                  this.ac();
                  ba.a(indexSelect / oj * ba.h);
               } else if (GameCanvas.n[2]) {
                  if (indexSelect >= 0 && indexSelect < oj) {
                     indexTitle = 0;
                     indexSelect = 0;
                     if ((im || hw || ib || ij || ik || hx || il || ir) && aw == 0) {
                        indexTitle = 1;
                     }
                  } else if (indexSelect - oj >= 0) {
                     indexSelect -= oj;
                  }

                  super.a = super.b = null;
                  this.ac();
                  ba.a(indexSelect / oj * ba.h);
               }
            }
         }

         if (GameCanvas.g) {
            var1 = this;
            if (!GameCanvas.af.a && GameCanvas.aj == null) {
               label1755: {
                  // Shinwa tab click đã được handle ở đầu e() (return sớm). Generic header click below.
                  if (GameCanvas.r && GameCanvas.b(fe, fd, ff, this.pb) && (!cq || GameCanvas.aa >= 320) && GameCanvas.q) {
                     if (GameCanvas.b(k - 80, fd + 5, 60, 40)) {
                        indexSelect = 0;
                        --aw;
                        this.ac();
                     }

                     if (GameCanvas.b(k + 10, fd + 5, 60, 40)) {
                        indexSelect = 0;
                        ++aw;
                        this.ac();
                     }

                     indexTitle = 0;
                     if (!aa()) {
                        if (aw < 0) {
                           aw = TextGame.fg.length - 1;
                        }

                        if (aw > TextGame.fg.length - 1) {
                           aw = 0;
                        }
                     } else {
                        if (hb) {
                           if (aw < 0) {
                              aw = TextGame.gb.length - 1;
                           } else if (aw > TextGame.gb.length - 1) {
                              aw = 0;
                           }

                           co();
                        } else if (ih) {
                           this.shinwaChangeTab(0);
                        } else if (!hc && !ct) {
                           if (aw < 0) {
                              aw = 1;
                           } else if (aw > 1) {
                              aw = 0;
                           }
                        } else {
                           aw = 0;
                        }

                        if (hc) {
                           aw = 0;
                        }
                     }

                     cq = false;
                     ba.a();
                  }

                  ScrollResult var13;
                  // NPC mode (aa()=true: Rương đồ, shop, ghép đồ, cải trang, trao đổi...):
                  // Với split-layout màn bé, cần chặn luôn grid bên dưới khi đang scroll info.
                  if (cq && aa() && aw != 4) {
                     if ((var13 = go.b()).a || var13.c) {
                        av = var13.b;
                        indexTitle = 1;
                        break label1755;
                     }
                  }

                  if (cq && !aa() && aw != 4) {
                     if ((var13 = go.b()).a || var13.c) {
                        av = var13.b;
                        indexTitle = 1;
                     }

                     if (!GameCanvas.j) {
                        break label1755;
                     }
                  }

                  if (ct) {
                     if (((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                        indexTitle = 1;
                        av = var13.b;
                        this.ac();
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 5, 16, 16, ba) && GameCanvas.q) {
                        Char.dunghp = !Char.dunghp;
                        if (ei == 1) {
                           Char.dunghp = false;
                           InfoMe.a(TextGame.rf, 20, mFont.j);
                        }

                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 35, 16, 16, ba) && GameCanvas.q) {
                        Char.dungmp = !Char.dungmp;
                        if (ei == 1) {
                           Char.dungmp = false;
                           InfoMe.a(TextGame.rf, 20, mFont.j);
                        }

                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 65, 16, 16, ba) && GameCanvas.q) {
                        Char.dungthucan = !Char.dungthucan;
                        if (ei == 1) {
                           Char.dungthucan = false;
                           InfoMe.a(TextGame.rf, 20, mFont.j);
                        }

                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 95, 16, 16, ba) && GameCanvas.q) {
                        Char.dunghotro = !Char.dunghotro;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 125, 16, 16, ba) && GameCanvas.q) {
                        Char.nhat_yen = !Char.nhat_yen;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 155, 16, 16, ba) && GameCanvas.q) {
                        Char.nhat_hpmp = !Char.nhat_hpmp;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 185, 16, 16, ba) && GameCanvas.q) {
                        Char.nhat_da = !Char.nhat_da;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 215, 16, 16, ba) && GameCanvas.q) {
                        Char.luyen_da = !Char.luyen_da;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 245, 16, 16, ba) && GameCanvas.q) {
                        Char.nhat_tbi = !Char.nhat_tbi;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 275, 16, 16, ba) && GameCanvas.q) {
                        Char.nhat_vpnv = !Char.nhat_vpnv;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 305, 16, 16, ba) && GameCanvas.q) {
                        Char.nhat_svc = !Char.nhat_svc;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 335, 16, 16, ba) && GameCanvas.q) {
                        Char.nhat_all = !Char.nhat_all;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 365, 16, 16, ba) && GameCanvas.q) {
                        Char.remap = !Char.remap;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 395, 16, 16, ba) && GameCanvas.q) {
                        Char.automuathucan = !Char.automuathucan;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 425, 16, 16, ba) && GameCanvas.q) {
                        Char.tusathetmp = !Char.tusathetmp;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 455, 16, 16, ba) && GameCanvas.q) {
                        Char.reconnect = !Char.reconnect;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 485, 16, 16, ba) && GameCanvas.q) {
                        Char.chuyenmap = !Char.chuyenmap;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 515, 16, 16, ba) && GameCanvas.q) {
                        Char.santatl = !Char.santatl;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 545, 16, 16, ba) && GameCanvas.q) {
                        Char.quaithuong = !Char.quaithuong;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 575, 16, 16, ba) && GameCanvas.q) {
                        Char.quaitinhanh = !Char.quaitinhanh;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 605, 16, 16, ba) && GameCanvas.q) {
                        Char.quaithulinh = !Char.quaithulinh;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 635, 16, 16, ba) && GameCanvas.q) {
                        Char.nepk = !Char.nepk;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 665, 16, 16, ba) && GameCanvas.q) {
                        Char.danhtheonhom = !Char.danhtheonhom;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 695, 16, 16, ba) && GameCanvas.q) {
                        Char.autottt = !Char.autottt;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 725, 16, 16, ba) && GameCanvas.q) {
                        Char.autottc = !Char.autottc;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 755, 16, 16, ba) && GameCanvas.q) {
                        Char.autocl = !Char.autocl;
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 16, ba.d + 785, 16, 16, ba) && GameCanvas.q) {
                        Char.automuacl = !Char.automuacl;
                        GameCanvas.p = false;
                     }

                      if (GameCanvas.a(ba.c + 16, ba.d + 815, 16, 16, ba) && GameCanvas.q) {
                         Char.dung_pthan = !Char.dung_pthan;
                         GameCanvas.p = false;
                      }

                      if (GameCanvas.a(ba.c + 16, ba.d + 845, 16, 16, ba) && GameCanvas.q) {
                         Char.autoCongTiemNang = !Char.autoCongTiemNang;
                         GameCanvas.p = false;
                      }

                      if (GameCanvas.a(ba.c + 16, ba.d + 875, 16, 16, ba) && GameCanvas.q) {
                         Char.autoCongKyNang = !Char.autoCongKyNang;
                         GameCanvas.p = false;
                      }

                      if (GameCanvas.a(ba.c + 131, ba.d + 2, 30, 20, ba) && GameCanvas.q && Char.dunghp) {
                        GameCanvas.al.a(TextGame.rd, new Command1(TextGame.bx, 1511), 1);
                        GameCanvas.p = false;
                     }

                     if (GameCanvas.a(ba.c + 131, ba.d + 32, 30, 20, ba) && GameCanvas.q && Char.dungmp) {
                        GameCanvas.al.a(TextGame.rd, new Command1(TextGame.bx, 1512), 1);
                        GameCanvas.p = false;
                     }

                     MyVector var12;
                     if (GameCanvas.a(ba.c + 131, ba.d + 62, 30, 20, ba) && GameCanvas.q && Char.dungthucan) {
                        (var12 = new MyVector()).addElement(new Command1(TextGame.re[0], 15130));
                        var12.addElement(new Command1(TextGame.re[1], 15131));
                        var12.addElement(new Command1(TextGame.re[2], 15132));
                        var12.addElement(new Command1(TextGame.re[3], 15133));
                        var12.addElement(new Command1(TextGame.re[4], 15134));
                        var12.addElement(new Command1(TextGame.re[5], 15135));
                        var12.addElement(new Command1(TextGame.re[6], 15136));
                        var12.addElement(new Command1(TextGame.re[7], 15137));
                        var12.addElement(new Command1(TextGame.re[8], 15138));
                        GameCanvas.af.a(var12);
                        GameCanvas.af.c = true;
                     }

                     if (GameCanvas.a(ba.c + 131, ba.d + 152, 30, 20, ba) && GameCanvas.q && Char.nhat_hpmp) {
                        (var12 = new MyVector()).addElement(new Command1("Cấp 1", 15150));
                        var12.addElement(new Command1("Cấp 10", 15151));
                        var12.addElement(new Command1("Cấp 30", 15152));
                        var12.addElement(new Command1("Cấp 50", 15153));
                        var12.addElement(new Command1("Cấp 70", 15154));
                        GameCanvas.af.a(var12);
                        GameCanvas.af.c = true;
                     }

                     if (GameCanvas.a(ba.c + 131, ba.d + 182, 30, 20, ba) && GameCanvas.q && Char.nhat_da) {
                        (var12 = new MyVector()).addElement(new Command1("Cấp 1", 15161));
                        var12.addElement(new Command1("Cấp 2", 15162));
                        var12.addElement(new Command1("Cấp 3", 15163));
                        var12.addElement(new Command1("Cấp 4", 15164));
                        var12.addElement(new Command1("Cấp 5", 15165));
                        var12.addElement(new Command1("Cấp 6", 15166));
                        var12.addElement(new Command1("Cấp 7", 15167));
                        GameCanvas.af.a(var12);
                        GameCanvas.af.c = true;
                     }

                     if (GameCanvas.a(ba.c + 131, ba.d + 212, 30, 20, ba) && GameCanvas.q && Char.luyen_da) {
                        (var12 = new MyVector()).addElement(new Command1("Cấp 5", 15174));
                        var12.addElement(new Command1("Cấp 6", 15175));
                        var12.addElement(new Command1("Cấp 7", 15176));
                        var12.addElement(new Command1("Cấp 8", 15177));
                        var12.addElement(new Command1("Cấp 9", 15178));
                        var12.addElement(new Command1("Cấp 10", 15179));
                        GameCanvas.af.a(var12);
                        GameCanvas.af.c = true;
                     }

                     if (GameCanvas.a(ba.c + 131, ba.d + 242, 30, 20, ba) && GameCanvas.q && Char.nhat_tbi) {
                        (var12 = new MyVector()).addElement(new Command1("Cấp 1", 15140));
                        var12.addElement(new Command1("Cấp 10", 15141));
                        var12.addElement(new Command1("Cấp 20", 15142));
                        var12.addElement(new Command1("Cấp 30", 15143));
                        var12.addElement(new Command1("Cấp 40", 15144));
                        var12.addElement(new Command1("Cấp 50", 15145));
                        var12.addElement(new Command1("Cấp 60", 15146));
                        GameCanvas.af.a(var12);
                        GameCanvas.af.c = true;
                     }
                  } else if (ih) {
                     if ((var13 = ba.b()).c || var13.a) {
                        if (indexSelect != var13.b || !cq) {
                           indexSelect = var13.b;
                           indexTitle = 1;
                           this.ac();
                        }
                     }
                  } else if (!hc && !hb && !ia && !hu && !hv && !hs && !ht && !hd && !he && !hf && !hg && !hh && !hi && !hj && !hk && !hl && !hm && !hr && !hn && !ho && !hp && !hq && !phong2.isItemDel && !phong2.isItemPick) {
                     if (cs) {
                        if (aw == 0) {
                           this.a(fe + 4, fd + this.pb + 15, 3, 4, 1);
                           this.a(fe + ff - 3 - 3 * indexSize, fd + this.pb + 15, 3, 4, 2);
                        } else if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                           indexTitle = 1;
                           indexSelect = var13.b;
                           this.ac();
                        }
                     } else if (!hz && !ii) {
                        if (!ib && !ij && !ik && !il) {
                           if (!hw && !hx && !im) {
                              if (iq) {
                                 if (aw == 0) {
                                    if (((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                                       indexTitle = 1;
                                       indexSelect = var13.b;
                                       super.a = super.b = null;
                                       cq = false;
                                       this.ac();
                                    }
                                 } else if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                                    indexTitle = 1;
                                    indexSelect = var13.b;
                                    this.ac();
                                 }
                              } else if (cn) {
                                 if (aw == 0) {
                                    if (GameCanvas.b(fe + 75, fd + 69, indexSize, indexSize)) {
                                       if (GameCanvas.q && GameCanvas.r) {
                                          indexTitle = 1;
                                          this.ac();
                                       }
                                    } else if (GameCanvas.b(this.jd.a, this.jd.b, this.jd.c, this.jd.d) && GameCanvas.q && GameCanvas.r) {
                                       indexTitle = 2;
                                       this.jd.a();
                                       this.ac();
                                    }
                                 } else if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                                    indexTitle = 1;
                                    indexSelect = var13.b;
                                    this.ac();
                                 }
                              } else if (ig) {
                                 if (GameCanvas.b(od, oe, 120, 120) && GameCanvas.r && GameCanvas.q) {
                                    indexSelect = (GameCanvas.u - od) / 40 + (GameCanvas.v - oe) / 40 * 3;
                                    indexTitle = 1;
                                    this.ac();
                                    this.cy();
                                 }
                              } else if (!in && !io) {
                                 if (ir) {
                                    if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                                       indexTitle = 1;
                                       indexSelect = var13.b;
                                       this.ac();
                                    }

                                    if (aw == 0) {
                                       for(var11 = 0; var11 < var1.qp.length; ++var11) {
                                          if (GameCanvas.b(var1.qp[var11], var1.qq[var11], indexSize, indexSize) && GameCanvas.q && GameCanvas.r) {
                                             var1.qr = var11;
                                          }
                                       }
                                    }
                                 }
                              } else if (aw == 0) {
                                 if (GameCanvas.b(fe + 75, fd + 69, indexSize, indexSize) && GameCanvas.q && GameCanvas.r) {
                                    indexTitle = 1;
                                    this.ac();
                                 }
                              } else if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                                 indexTitle = 1;
                                 indexSelect = var13.b;
                                 this.ac();
                              }
                           } else if (aw == 0) {
                              var3 = fe + 45;
                              var4 = fd + 32;
                              var5 = fe + 100;
                              if (GameCanvas.r) {
                                 if (GameCanvas.b(var3, var4, 29, 29)) {
                                    indexTitle = 1;
                                    indexSelect = 0;
                                    this.ac();
                                 }

                                 if (GameCanvas.b(var5, var4, 29, 29)) {
                                    indexTitle = 1;
                                    indexSelect = 1;
                                    this.ac();
                                    if (hz && aw == 0) {
                                       for(var6 = 0; var6 < bz.length; ++var6) {
                                          if (bz[var6] != null) {
                                             super.b = new Command1(TextGame.dc, 11062);
                                             break;
                                          }
                                       }
                                    }
                                 }

                                 if (GameCanvas.b(fe, fd + 2 * this.pb + 5, ff, fg - this.pb * 3)) {
                                    this.a(fe, fd + 2 * this.pb + 5, 6, 3, 2);
                                 }
                              }
                           } else if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                              indexTitle = 1;
                              indexSelect = var13.b;
                              this.ac();
                           }
                        } else if (aw == 0) {
                           if (GameCanvas.b(fe + 74, oe - indexSize - 3, indexSize, indexSize)) {
                              indexTitle = 1;
                              indexSelect = 0;
                              this.ac();
                           }

                           this.a(fe + 4, fd + 2 * this.pb + 5, 6, 4, 2);
                        } else if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                           indexTitle = 1;
                           indexSelect = var13.b;
                           this.ac();
                        }
                     } else if (aw == 0) {
                        this.a(fe + 4, fd + this.pb + 3, 6, 4, 1);
                     } else if (aw == 1 && ((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                        indexTitle = 1;
                        indexSelect = var13.b;
                        this.ac();
                     }
                  } else if (((var13 = ba.b()).c || var13.a) && indexSelect != var13.b) {
                     indexTitle = 1;
                     indexSelect = var13.b;
                     super.a = super.b = null;
                     cq = false;
                     this.ac();
                  }
               }
            }
         }

         GameCanvas.i();
         GameCanvas.h();
      }

   }

   private static int cn() {
      int var0 = 0;

      try {
         if (hc) {
            if (bv.length % oj == 0) {
               var0 = bv.length;
            } else {
               var0 = (bv.length / oj + 1) * oj;
            }
         } else if (hb) {
            if (aw == 0) {
               if (bu.length % oj == 0) {
                  var0 = bu.length;
               } else {
                  var0 = (bu.length / oj + 1) * oj;
               }
            } else if (aw == 1) {
               if (bx.length % oj == 0) {
                  var0 = bx.length;
               } else {
                  var0 = (bx.length / oj + 1) * oj;
               }
            } else if (aw == 2) {
               if (by.length % oj == 0) {
                  var0 = by.length;
               } else {
                  var0 = (by.length / oj + 1) * oj;
               }
            } else if (aw == 52) {
               if (by.length % oj == 0) {
                  var0 = by.length;
               } else {
                  var0 = (by.length / oj + 1) * oj;
               }
            }
         } else if (hd) {
            if (bb.length % oj == 0) {
               var0 = bb.length;
            } else {
               var0 = (bb.length / oj + 1) * oj;
            }
         } else if (he) {
            if (bc.length % oj == 0) {
               var0 = bc.length;
            } else {
               var0 = (bc.length / oj + 1) * oj;
            }
         } else if (hf) {
            if (bd.length % oj == 0) {
               var0 = bd.length;
            } else {
               var0 = (bd.length / oj + 1) * oj;
            }
         } else if (hg) {
            if (be.length % oj == 0) {
               var0 = be.length;
            } else {
               var0 = (be.length / oj + 1) * oj;
            }
         } else if (hh) {
            if (bf.length % oj == 0) {
               var0 = bf.length;
            } else {
               var0 = (bf.length / oj + 1) * oj;
            }
         } else if (hi) {
            if (bg.length % oj == 0) {
               var0 = bg.length;
            } else {
               var0 = (bg.length / oj + 1) * oj;
            }
         } else if (hj) {
            if (bh.length % oj == 0) {
               var0 = bh.length;
            } else {
               var0 = (bh.length / oj + 1) * oj;
            }
         } else if (hk) {
            if (bi.length % oj == 0) {
               var0 = bi.length;
            } else {
               var0 = (bi.length / oj + 1) * oj;
            }
         } else if (hl) {
            if (bj.length % oj == 0) {
               var0 = bj.length;
            } else {
               var0 = (bj.length / oj + 1) * oj;
            }
         } else if (hm) {
            if (bk.length % oj == 0) {
               var0 = bk.length;
            } else {
               var0 = (bk.length / oj + 1) * oj;
            }
         } else if (hn) {
            if (bl.length % oj == 0) {
               var0 = bl.length;
            } else {
               var0 = (bl.length / oj + 1) * oj;
            }
         } else if (ho) {
            if (bm.length % oj == 0) {
               var0 = bm.length;
            } else {
               var0 = (bm.length / oj + 1) * oj;
            }
         } else if (hp) {
            if (bn.length % oj == 0) {
               var0 = bn.length;
            } else {
               var0 = (bn.length / oj + 1) * oj;
            }
         } else if (hq) {
            if (bo.length % oj == 0) {
               var0 = bo.length;
            } else {
               var0 = (bo.length / oj + 1) * oj;
            }
         } else if (hr) {
            if (bp.length % oj == 0) {
               var0 = bp.length;
            } else {
               var0 = (bp.length / oj + 1) * oj;
            }
         } else if (hs) {
            if (bq.length % oj == 0) {
               var0 = bq.length;
            } else {
               var0 = (bq.length / oj + 1) * oj;
            }
         } else if (ht) {
            if (br.length % oj == 0) {
               var0 = br.length;
            } else {
               var0 = (br.length / oj + 1) * oj;
            }
         } else if (hu) {
            if (bs.length % oj == 0) {
               var0 = bs.length;
            } else {
               var0 = (bs.length / oj + 1) * oj;
            }
         } else if (hv) {
            if (bt.length % oj == 0) {
               var0 = bt.length;
            } else {
               var0 = (bt.length / oj + 1) * oj;
            }
         }

         if (ia) {
            var0 = Char.getMyChar().arrItemBox.length;
         }

         if (aw == 1 && !hb) {
            var0 = Char.getMyChar().arrItemBag.length;
         }
      } catch (Exception var2) {
         ;
      }

      if ((hz || ii || ib || ij || ik || il || ir) && aw == 0) {
         var0 = 24;
      } else if ((im || hw || hx) && aw == 0) {
         var0 = 18;
      } else if (var0 < 30) {
         var0 = 30;
      }

      return var0;
   }

   private static void co() {
      if (aw == 0) {
         Service.gI().i(14);
      } else if (aw == 1) {
         Service.gI().i(15);
      } else if (aw == 2) {
         Service.gI().i(32);
      } else if (aw == 3) {
         Service.gI().i(34);
      } else if (aw == 52) {
         Service.gI().i(32);
      }

   }

   private void cp() {
      if (Char.getMyChar().arrItemBag[indexSelect].quantity > 1) {
         super.a = new Command1(TextGame.bo, 11072);
      } else {
         super.a = new Command1(TextGame.bo, 11073);
      }

   }

   public final void ac() {
      super.a = super.b = null;
      if (indexSelect >= 0) {
         if (ct) {
            if (indexTitle == 1 && !GameCanvas.g) {
               super.a = new Command1(TextGame.doa, 1510);
            }
         } else if (ig) {
            if (indexTitle == 1) {
               super.a = new Command1(TextGame.doa, 1506);
               super.b = new Command1("", 1507);
            }
         } else if (hc) {
            if (aw == 0 && k(35) != null) {
               super.a = this.nf;
               if (!cq || this.gn != k(35)) {
                  this.showItemInfoSplit(35, k(35));
               }
               return;
            }
         } else if (hb) {
            if (aw == 52) {
               if (k(32) != null) {
                  super.a = this.nn;
                  if (!cq || this.gn != k(32)) {
                     this.showItemInfoSplit(32, k(32));
                  }
                  return;
               }
            } else if (aw == 0) {
               if (k(14) != null) {
                  super.a = this.nh;
                  if (!cq || this.gn != k(14)) {
                     this.showItemInfoSplit(14, k(14));
                  }
                  return;
               }
            } else if (aw == 1) {
               if (k(15) != null) {
                  super.a = this.nl;
                  if (!cq || this.gn != k(15)) {
                     this.showItemInfoSplit(15, k(15));
                  }
                  return;
               }
            } else if (aw == 2) {
               if (k(32) != null) {
                  super.a = this.nn;
                  if (!cq || this.gn != k(32)) {
                     this.showItemInfoSplit(32, k(32));
                  }
                  return;
               }
            } else if (aw == 3 && k(34) != null) {
               super.a = this.nj;
               if (!cq || this.gn != k(34)) {
                  this.showItemInfoSplit(34, k(34));
               }
            }
         } else {
            if (hd) {
               if (aw == 0) {
                  if (k(20) != null) {
                     super.a = this.np;
                     if (!cq || this.gn != k(20)) {
                        this.showItemInfoSplit(20, k(20));
                     }
                  }
               } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                  this.cp();
               }
            } else if (he) {
               if (aw == 0) {
                  if (k(21) != null) {
                     super.a = this.nr;
                     if (!cq || this.gn != k(21)) {
                        this.showItemInfoSplit(21, k(21));
                     }
                  }
               } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                  this.cp();
               }
            } else if (hf) {
               if (aw == 0) {
                  if (k(22) != null) {
                     super.a = this.nt;
                     if (!cq || this.gn != k(22)) {
                        this.showItemInfoSplit(22, k(22));
                     }
                  }
               } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                  this.cp();
               }
            } else if (hg) {
               if (aw == 0) {
                  if (k(23) != null) {
                     super.a = this.nv;
                     if (!cq || this.gn != k(23)) {
                        this.showItemInfoSplit(23, k(23));
                     }
                  }
               } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                  this.cp();
               }
            } else if (hh) {
               if (aw == 0) {
                  if (k(24) != null) {
                     super.a = this.nx;
                     if (!cq || this.gn != k(24)) {
                        this.showItemInfoSplit(24, k(24));
                     }
                  }
               } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                  this.cp();
               }
            } else if (hi) {
               if (aw == 0) {
                  if (k(25) != null) {
                     super.a = this.nz;
                     if (!cq || this.gn != k(25)) {
                        this.showItemInfoSplit(25, k(25));
                     }
                  }
               } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                  this.cp();
               }
            } else {
               Item var1;
               if (hj) {
                  if (aw == 0) {
                     if ((var1 = k(26)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(26, var1);
                        }
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hk) {
                  if (aw == 0) {
                     if ((var1 = k(27)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(27, var1);
                        }
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hl) {
                  if (aw == 0) {
                     if ((var1 = k(28)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(28, var1);
                        }
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hm) {
                  if (aw == 0) {
                     if ((var1 = k(29)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(29, var1);
                        }
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hn) {
                  if (aw == 0) {
                     if ((var1 = k(16)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(16, var1);
                        }
                     } else {
                        cq = false;
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (ho) {
                  if (aw == 0) {
                     if ((var1 = k(17)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(17, var1);
                        }
                     } else {
                        cq = false;
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hp) {
                  if (aw == 0) {
                     if ((var1 = k(18)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(18, var1);
                        }
                     } else {
                        cq = false;
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hq) {
                  if (aw == 0) {
                     if ((var1 = k(19)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(19, var1);
                        }
                     } else {
                        cq = false;
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hr) {
                  if (aw == 0) {
                     if ((var1 = k(2)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(2, var1);
                        }
                     } else {
                        cq = false;
                     }
                  } else if (aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                     this.cp();
                  }
               } else if (hs) {
                  if (aw == 0) {
                     if ((var1 = k(6)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(6, var1);
                        }
                     }
                  } else if (aw == 1) {
                     if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.cp();
                     } else {
                        super.a = this.ov;
                     }
                  }
               } else if (ht) {
                  if (aw == 0) {
                     if ((var1 = k(7)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(7, var1);
                        }
                     }
                  } else if (aw == 1) {
                     if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.cp();
                     } else {
                        super.a = this.ov;
                     }
                  }
               } else if (hu) {
                  if (aw == 0) {
                     if ((var1 = k(8)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(8, var1);
                        }
                     }
                  } else if (aw == 1) {
                     if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.cp();
                     } else {
                        super.a = this.ov;
                     }
                  }
               } else if (hv) {
                  if (aw == 0) {
                     if ((var1 = k(9)) != null) {
                        super.a = new Command1(TextGame.bs, 11092, var1);
                        if (!cq || this.gn != var1) {
                           this.showItemInfoSplit(9, var1);
                        }
                     }
                  } else if (aw == 1) {
                     if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.cp();
                     } else {
                        super.a = this.ov;
                     }
                  }
               } else {
                  int var2;
                  if (hw) {
                     if (aw == 0) {
                        if (indexTitle == 1) {
                           if (ci != null) {
                              if (indexSelect == 0) {
                                 super.a = new Command1(TextGame.doa, 11098);
                                 if (!cq || this.gn != ci) {
                                    this.showItemInfoSplit(3, ci);
                                 }
                              } else if (indexSelect == 1 && !ci.p()) {
                                 if (!cq || this.gn != ci) {
                                    this.showItemInfoSplit(3, ci);
                                 }
                              }
                           } else {
                              cq = false;
                           }
                        } else if (indexTitle == 2) {
                           var1 = k(10);
                           gq = false;
                           if (var1 != null) {
                              super.a = new Command1(TextGame.doa, 11100);
                              if (!cq || this.gn != var1) {
                                 this.showItemInfoSplit(10, var1);
                              }
                           } else {
                              super.a = null;
                              cq = false;
                              if (ci != null) {
                                 for(var2 = 0; var2 < ca.length; ++var2) {
                                    if (ca[var2] != null) {
                                       super.a = new Command1(TextGame.ev, 110981);
                                       break;
                                    }
                                 }
                              }
                           }
                        }
                     } else if (aw == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                           super.a = new Command1(TextGame.doa, 11102);
                        } else {
                           super.a = null;
                        }
                     }
                  } else {
                     int var3;
                     if (hx) {
                        if (aw != 0) {
                           if (aw == 1) {
                              if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                 super.a = new Command1(TextGame.doa, 14012);
                              } else {
                                 super.a = null;
                              }
                           }
                        } else if (indexTitle == 1) {
                           if (indexSelect == 0) {
                              if (ce[0] != null) {
                                 super.a = new Command1(TextGame.doa, 14013);
                                 if (!cq || this.gn != ce[0]) {
                                    this.showItemInfoSplit(3, ce[0]);
                                 }
                              }
                           } else if (indexSelect == 1) {
                              if (ce[1] != null) {
                                 super.a = new Command1(TextGame.doa, 14013);
                                 if (!cq || this.gn != ce[1]) {
                                    this.showItemInfoSplit(3, ce[1]);
                                 }
                              }
                           } else {
                              cq = false;
                           }
                        } else if (indexTitle == 2) {
                           var1 = null;
                           if ((var2 = indexSelect + 2) <= ce.length - 1) {
                              var1 = ce[var2];
                           }

                           if (var1 != null) {
                              super.a = new Command1(TextGame.bj, 140151);
                              if (!cq || this.gn != var1) {
                                 this.showItemInfoSplit(3, var1);
                              }
                           } else {
                              super.a = new Command1(TextGame.ev, 140131);

                              for(var3 = 0; var3 < ce.length; ++var3) {
                                 if (ce[var3] == null) {
                                    super.a = null;
                                    break;
                                 }
                              }

                              cq = false;
                           }
                        }
                     } else {
                        int var13;
                        if (cn) {
                           if (aw == 0) {
                              if (indexTitle == 2) {
                                 this.jd.e = true;
                                 super.c = this.jd.l;
                              } else {
                                 this.jd.e = false;
                                 super.c = this.ne;
                              }

                              var13 = 0;

                              try {
                                 var13 = Integer.parseInt(this.jd.d());
                              } catch (Exception var11) {
                              }

                              if (ck != null && var13 > 0 && Char.getMyChar().xu >= 5000) {
                                 super.a = new Command1(TextGame.bo, 15002);
                              }

                              if (indexTitle == 1 && ck != null) {
                                 super.a = new Command1(TextGame.doa, 1500);
                                 if (!cq || this.gn != ck) {
                                    this.showItemInfoSplit(3, ck);
                                 }
                              }
                           } else if (aw == 1) {
                              super.c = this.ne;
                              if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                 super.a = new Command1(TextGame.doa, 1503);
                              } else {
                                 super.a = null;
                                 cq = false;
                              }
                           }
                        } else {
                           if (ih) {
                              if (indexTitle == 1 && cf != null && indexSelect >= 0 && indexSelect < cf.length && cf[indexSelect] != null) {
                                 super.a = new Command1(TextGame.doa, 1504);
                                 if (GameCanvas.j) {
                                    this.b(1505, (Object)null);
                                    return;
                                 }

                                 if (this.useSplitItemInfoCenterButton()) {
                                    super.b = new Command1(GameCanvas.g ? TextGame.ax : "", 1505);
                                 } else {
                                    super.b = null;
                                    if (!cq || this.gn != cf[indexSelect].a) {
                                       this.showItemInfoSplit(3, cf[indexSelect].a);
                                    }
                                 }
                              }

                              return;
                           }

                           if (ib) {
                              if (aw == 0) {
                                 if (indexTitle != 1) {
                                    if (indexTitle == 2) {
                                       if ((var1 = cb[indexSelect]) != null) {
                                          if (!cq || this.gn != var1) {
                                             this.showItemInfoSplit(3, var1);
                                          }
                                       } else {
                                          cq = false;
                                       }

                                       if (cj != null && cj.upgrade > 0) {
                                          super.a = new Command1(TextGame.ev, 11105);
                                       }
                                    }
                                 } else {
                                    if (cj != null && cj.upgrade > 0) {
                                       super.a = new Command1(TextGame.doa, 11103);
                                    } else if (cj != null) {
                                       super.a = this.mx;
                                    } else {
                                       cq = false;
                                    }

                                    if (!cq || this.gn != cj) {
                                       this.showItemInfoSplit(3, cj);
                                    }
                                 }
                              } else if (aw == 1) {
                                 if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                    super.a = null;
                                    cq = false;
                                 } else {
                                    super.a = new Command1(TextGame.doa, 11106);
                                 }
                              }
                           } else if (ij) {
                              try {
                                 if (aw == 0) {
                                    if (indexTitle == 1) {
                                       if (cj != null) {
                                          super.a = new Command1(TextGame.doa, 11103);
                                       } else {
                                          cq = false;
                                       }

                                       if (!cq || this.gn != cj) {
                                          this.showItemInfoSplit(3, cj);
                                       }
                                    } else if (indexTitle == 2) {
                                       if ((var1 = cb[indexSelect]) != null) {
                                          if (!cq || this.gn != var1) {
                                             this.showItemInfoSplit(3, var1);
                                          }

                                          super.a = new Command1(TextGame.bj, 1605);
                                       } else {
                                          cq = false;
                                       }

                                       if (cj != null) {
                                          super.a = new Command1(TextGame.doa, 1604);
                                       }
                                    }
                                 } else if (aw == 1) {
                                    if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                       super.a = null;
                                       cq = false;
                                    } else {
                                       super.a = new Command1(TextGame.doa, 11106);
                                    }
                                 }
                              } catch (Exception var10) {
                              }
                           } else if (ik) {
                              if (aw == 0) {
                                 if (indexTitle != 1) {
                                    if (indexTitle == 2) {
                                       if ((var1 = cb[indexSelect]) != null) {
                                          if (!cq || this.gn != var1) {
                                             this.showItemInfoSplit(3, var1);
                                          }
                                       } else {
                                          cq = false;
                                       }

                                       if (cj != null && cj.upgrade > 11) {
                                          super.a = new Command1(TextGame.doa, 1604);
                                       }
                                    }
                                 } else {
                                    if (cj != null && cj.upgrade > 11) {
                                       super.a = new Command1(TextGame.doa, 11103);
                                    } else if (cj != null) {
                                       super.a = this.mx;
                                    } else {
                                       cq = false;
                                    }

                                    if (!cq || this.gn != cj) {
                                       this.showItemInfoSplit(3, cj);
                                    }
                                 }
                              } else if (aw == 1) {
                                 if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                    super.a = null;
                                    cq = false;
                                 } else {
                                    super.a = new Command1(TextGame.doa, 1606);
                                 }
                              }
                           } else {
                              Item var10;
                              if (hz) {
                                 if (aw != 0) {
                                    if (aw == 1) {
                                       if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                          super.a = new Command1(TextGame.doa, 11109);
                                       } else {
                                          cq = false;
                                          super.a = null;
                                       }
                                    }
                                 } else {
                                    var13 = 0;

                                    for(var2 = 0; var2 < bz.length; ++var2) {
                                       if (bz[var2] != null) {
                                          ++var13;
                                          if (var13 >= 2) {
                                             break;
                                          }
                                       }
                                    }

                                    if ((var10 = k(11)) != null) {
                                       if (var13 >= 2) {
                                          super.a = new Command1(TextGame.doa, 11107);
                                       } else {
                                          super.a = new Command1(TextGame.bj, 111071);
                                       }

                                       if (!cq || this.gn != var10) {
                                          this.showItemInfoSplit(11, var10);
                                       }
                                    } else {
                                       cq = false;
                                       if (var13 >= 2) {
                                          super.a = new Command1(TextGame.ev, 11062);
                                       }
                                    }
                                 }
                              } else if (!ii) {
                                 if (cs) {
                                    if (aw == 0) {
                                       if (indexTitle == 1) {
                                          if (cc[indexSelect] != null) {
                                             if (this.dh == 0) {
                                                super.a = this.nd;
                                             } else if (this.dh == 1 && this.di >= 1 && (long)this.dl - System.currentTimeMillis() / 1000L <= 0L) {
                                                super.a = this.mr;
                                             }

                                             if (!cq || this.gn != cc[indexSelect]) {
                                                this.showItemInfoSplit(3, cc[indexSelect]);
                                             }
                                          } else {
                                             cq = false;
                                             if (this.dh == 0) {
                                                super.a = this.mq;
                                             } else if (this.dh == 1 && this.di >= 1 && (long)this.dl - System.currentTimeMillis() / 1000L <= 0L) {
                                                super.a = this.mr;
                                             }
                                          }
                                       }

                                       if (indexTitle == 2) {
                                          if (cd[indexSelect] != null) {
                                             if (!cq || this.gn != cd[indexSelect]) {
                                                this.showItemInfoSplit(30, cd[indexSelect]);
                                             }
                                          } else {
                                             cq = false;
                                          }
                                       }
                                    } else if (aw == 1 && this.dh == 0) {
                                       if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                          super.a = this.nc;
                                       } else {
                                          super.a = this.my;
                                       }
                                    }
                                 } else if (ia) {
                                    if (aw == 0) {
                                       if ((var1 = k(4)) != null) {
                                          String var12 = TextGame.bi;
                                          if (!fk.equals("")) {
                                             var12 = fl;
                                          }

                                          super.a = new Command1(var12, 111101);
                                          if (GameCanvas.j) {
                                             this.a((int)4, (Item)var1);
                                          } else {
                                             if (!cq || this.gn != var1) {
                                                this.showItemInfoSplit(4, var1);
                                             }
                                          }
                                       } else if (fk.equals("")) {
                                          super.a = new Command1(TextGame.bd, 11112);
                                          cq = false;
                                       }
                                    } else if (aw == 1) {
                                       if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                          super.a = new Command1(TextGame.bn, 11113);
                                          if (!cq || this.gn != Char.getMyChar().arrItemBag[indexSelect]) {
                                             this.showItemInfoSplit(3, Char.getMyChar().arrItemBag[indexSelect]);
                                          }
                                       } else {
                                          super.a = this.ov;
                                          cq = false;
                                       }
                                    }
                                 } else if (phong2.isItemPick) {
                                    if (aw == 0) {
                                       if (indexSelect >= 0 && indexSelect <= Code.arrItemNhat.length && Code.arrItemNhat[indexSelect] > 0) {
                                          this.a = new Command1("Xoá", 1191);
                                       } else {
                                          this.a = new Command1("Sắp xếp", 1192);
                                       }
                                    } else if (aw == 1) {
                                       if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                          this.a = new Command1("Thêm", 1193);
                                       } else {
                                          this.a = this.ov;
                                       }
                                    }
                                 } else if (phong2.isItemDel) {
                                    if (aw == 0) {
                                       if (indexSelect >= 0 && indexSelect <= Code.arrItemDel.length && Code.arrItemDel[indexSelect] > 0) {
                                          this.a = new Command1("Xoá", 1181);
                                       } else {
                                          this.a = new Command1("Sắp xếp", 1182);
                                       }
                                    } else if (aw == 1) {
                                       if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                          this.a = new Command1("Thêm", 1183);
                                       } else {
                                          this.a = this.ov;
                                       }
                                    }
                                 } else if (!ir) {
                                    if (il) {
                                       GameScr var14 = this;

                                       try {
                                          if (aw == 0) {
                                             if (indexTitle == 1) {
                                                if (cj != null) {
                                                   var14.a = new Command1(TextGame.doa, 11103);
                                                } else {
                                                   cq = false;
                                                }

                                                if (GameCanvas.j) {
                                                   var14.a((int)3, (Item)cj);
                                                } else {
                                                   var14.b = new Command1(GameCanvas.g ? TextGame.ax : "", 11104, cj);
                                                }
                                             } else if (indexTitle == 2) {
                                                if ((var10 = cb[indexSelect]) != null) {
                                                   if (GameCanvas.j) {
                                                      var14.a((int)3, (Item)var10);
                                                   } else {
                                                      var14.b = new Command1(GameCanvas.g ? TextGame.ax : "", 11104, var10);
                                                   }

                                                   var14.a = new Command1(TextGame.bj, 1605);
                                                } else {
                                                   cq = false;
                                                }

                                                if (cj != null) {
                                                   var14.a = new Command1(TextGame.doa, 1604);
                                                }
                                             }
                                          } else if (aw == 1) {
                                             if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                                var14.a = null;
                                                cq = false;
                                             } else {
                                                var14.a = new Command1(TextGame.doa, 222);
                                             }
                                          }
                                       } catch (Exception var9) {
                                       }
                                    } else if (im) {
                                       if (aw == 0) {
                                          if (indexTitle == 1) {
                                             if (cj != null && indexSelect == 0) {
                                                super.a = new Command1(TextGame.doa, 338);
                                                if (!cq || this.gn != cj) {
                                                   this.showItemInfoSplit(3, cj);
                                                }
                                             }

                                             if (ci != null && indexSelect == 1) {
                                                super.a = new Command1(TextGame.doa, 344);
                                                if (!cq || this.gn != ci) {
                                                   this.showItemInfoSplit(3, ci);
                                                }
                                             }

                                             if (cj == null && ci == null) {
                                                cq = false;
                                             }
                                          } else if (indexTitle == 2) {
                                             var10 = k(47);
                                             gq = false;
                                             if (var10 != null) {
                                                super.a = new Command1(TextGame.doa, 345);
                                                if (!cq || this.gn != var10) {
                                                   this.showItemInfoSplit(47, var10);
                                                }
                                             } else {
                                                super.a = null;
                                                cq = false;
                                                if (ci != null && cj != null) {
                                                   for(var2 = 0; var2 < ca.length; ++var2) {
                                                      if (ca[var2] != null) {
                                                         super.a = new Command1(TextGame.ev, 341);
                                                         break;
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       } else if (aw == 1) {
                                          if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                             super.a = new Command1(TextGame.doa, 337);
                                          } else {
                                             super.a = null;
                                          }
                                       }
                                    } else if (iq) {
                                       if (aw == 0) {
                                          var10 = k(48);
                                          gq = false;
                                          if (var10 != null) {
                                             super.a = new Command1(TextGame.doa, 401);
                                             if (!cq || this.gn != var10) {
                                                this.showItemInfoSplit(48, var10);
                                             }
                                          } else {
                                             for(var2 = 0; var2 < cb.length; ++var2) {
                                                if (cb[var2] != null) {
                                                   super.a = new Command1(TextGame.gl[0], 403);
                                                   break;
                                                }
                                             }
                                          }
                                       } else if (aw == 1) {
                                          if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                             super.a = new Command1(TextGame.doa, 400);
                                          } else {
                                             super.a = null;
                                          }
                                       }
                                    } else if (in || io) {
                                       if (aw == 0) {
                                          if (cj != null) {
                                             super.a = new Command1(TextGame.doa, 11103);
                                          } else {
                                             cq = false;
                                          }

                                          if (!cq || this.gn != cj) {
                                             this.showItemInfoSplit(3, cj);
                                          }
                                       } else if (aw == 1) {
                                          if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                             super.a = null;
                                             cq = false;
                                          } else {
                                             super.a = new Command1(TextGame.doa, 405);
                                          }
                                       }
                                    }
                                 }
                              } else if (aw != 0) {
                                 if (aw == 1) {
                                    if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                       super.a = new Command1(TextGame.doa, 1603);
                                    } else {
                                       cq = false;
                                       super.a = null;
                                    }
                                 }
                              } else {
                                 var13 = 0;
                                 var2 = 0;
                                 var3 = 0;
                                 short var4 = 0;

                                 for(int var5 = 0; var5 < bz.length; ++var5) {
                                    Item var6;
                                    if ((var6 = bz[var5]) != null) {
                                       if (var6.template.id == 455) {
                                          ++var13;
                                       } else if (var6.template.id == 456) {
                                          ++var2;
                                       } else if (var6.template.type == 26) {
                                          var4 = var6.template.id;
                                          ++var3;
                                       }
                                    }

                                    if (var13 >= 9 || var2 >= 9 || var4 == 10 && var13 >= 3 || var4 == 11 && var2 >= 3) {
                                       break;
                                    }
                                 }

                                 Item var11;
                                 if ((var11 = k(43)) == null) {
                                    cq = false;
                                    if (var13 >= 9 || var2 >= 9 || var4 >= 10 && (var13 >= 3 || var2 >= 3)) {
                                       super.a = new Command1(TextGame.ev, 1600);
                                    }
                                 } else {
                                    if (var13 == 9 || var2 == 9 || var4 == 10 && var13 == 3 && var3 == 1 || var4 == 11 && var2 == 3 && var3 == 1) {
                                       super.a = new Command1(TextGame.doa, 1601);
                                    } else {
                                       super.a = new Command1(TextGame.bj, 111071);
                                    }

                                    if (!cq || this.gn != var11) {
                                       this.showItemInfoSplit(43, var11);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            if (!ia && aa() && aw == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
               if (!cq || this.gn != Char.getMyChar().arrItemBag[indexSelect]) {
                  this.showItemInfoSplit(3, Char.getMyChar().arrItemBag[indexSelect]);
               }
            }
         }
      }

   }

   public static void b(int var0, int var1) {
      if (var0 == 175 && var1 == 200) {
         var1 = javaDocCrPanelHeight(var1);
      }

      if (GameCanvas.aa == 128 || GameCanvas.ab <= 208) {
         var0 = 126;
         var1 = 160;
      }

      ff = var0;
      fg = var1;
      fe = k - var0 / 2;
      fd = m - var1 / 2;
      if (GameCanvas.ab <= 250) {
         fd -= 10;
      }

      if (GameCanvas.aa >= 320 && !cj() && GameCanvas.currentScreen instanceof GameScr) {
         ff = 310;
         fe = i / 2 - ff / 2;
      }

      if (fd < -10) {
         fd = -10;
      }

      if (GameCanvas.ab > 208 && fd < 0) {
         fd = 0;
      }

      if (GameCanvas.ab == 208 && fd < 10) {
         fd = 10;
      }

   }

   private void a(mGraphics var1, Skill var2) {
      if (Char.getMyChar().cLevel >= var2.level) {
         mFont.i.a(var1, TextGame.hu + " " + var2.level, od + 5, this.ol += 12, 0);
      } else {
         mFont.l.a(var1, TextGame.hu + " " + var2.level, od + 5, this.ol += 12, 0);
      }

      if (var2.template.type != 0) {
         gm += 4;
         mFont.i.a(var1, TextGame.la + ": " + var2.maxFight, od + 5, this.ol += 12, 0);
         mFont.i.a(var1, TextGame.lc + ": " + var2.manaUse, od + 5, this.ol += 12, 0);
         mFont.i.a(var1, TextGame.lb + ": " + var2.ngang(), od + 5, this.ol += 12, 0);
         mFont var10000 = mFont.i;
         StringBuffer var10002 = (new StringBuffer(String.valueOf(TextGame.ld))).append(": ");
         String var10003;
         if (var2.coolDown % 1000 == 0) {
            var10003 = String.valueOf(var2.coolDown / 1000);
         } else {
            int var4 = var2.coolDown % 1000;
            var10003 = var2.coolDown / 1000 + "." + (var4 % 100 == 0 ? var4 / 100 : var4 / 10);
         }

         var10000.a(var1, var10002.append(var10003).append(" ").append(TextGame.ky).toString(), od + 5, this.ol += 12, 0);
      }

      ++gm;
   }

   private void b(mGraphics var1, Skill var2) {
      SkillOption[] var6 = var2.k;

      for(int var3 = 0; var3 < var6.length; ++var3) {
         SkillOption var4 = var6[var3];
         if (mFont.i.a(var4.a()) > 145) {
            MyVector var7 = mFont.i.a(var4.a(), 145);

            for(int var5 = 0; var5 < var7.size(); ++var5) {
               mFont.i.a(var1, var7.elementAt(var5).toString(), od + 5, this.ol += 12, 0);
               ++gm;
            }
         } else {
            mFont.i.a(var1, var4.a(), od + 5, this.ol += 12, 0);
            ++gm;
         }
      }

   }

   private void drawItemDel(mGraphics var1) {
      if (phong2.isItemDel) {
         if (aw == 0) {
            b(var1);
            this.a(var1, new String[]{"Item Del", "Hành Trang"}, false);
            this.showitem(var1, Code.arrItemDel);
            return;
         }

         if (aw == 1) {
            this.a(var1, new String[]{"Item Del", "Hành Trang"});
         }
      }

   }

   private void drawItemPick(mGraphics var1) {
      if (phong2.isItemPick) {
         if (aw == 0) {
            b(var1);
            this.a(var1, new String[]{"Item Nhặt", "Hành Trang"}, false);
            this.showitem(var1, Code.arrItemNhat);
            return;
         }

         if (aw == 1) {
            this.a(var1, new String[]{"Item Nhặt", "Hành Trang"});
         }
      }

   }

   private void o(mGraphics var1) {
      if (aw == 1) {
         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.fg[aw], true);
         mFont.e.a(var1, TextGame.jd, fe + 10, fd + 32, 0);
         mFont.e.a(var1, "" + Char.getMyChar().sPoint, fe + ff - 10, fd + 32, 1);
         var1.a(0);
         var1.c(fe + 4, fd + 44, ff - 7, indexSize + 3);
         var1.a(12281361);
         var1.b(fe + 5, fd + 45, ff - 10, indexSize);
         if (indexTitle >= 1) {
            var1.a(Paint.d);
            var1.b(fe + 5, fd + 48 + indexSize, ff - 10, fg - 64 - indexSize);
         }

         int var2 = Char.getMyChar().nClass.c.length;
         od = fe + 5;
         oe = fd + 45;
         ba.a(var2, indexSize + 2, od + 1, oe, ff - 12, indexSize + 2, false, 1);
         ba.a(var1);

         for(int var3 = 0; var3 < var2; ++var3) {
            int var10002 = od + var3 * (indexSize + 2) + indexSize / 2;
            SmallImage.a(var1, Char.getMyChar().nClass.c[var3].e, var10002, oe + indexSize / 2, 0, 3);
            if (indexTitle == 1 && var3 == indexSelect) {
               var1.a(16777215);
               var1.b(od + var3 * (indexSize + 2) + 2, oe + 2, indexSize - 4, indexSize - 4);
               a(od + var3 * (indexSize + 2), oe, var1);
            }
         }

         od += 8;
         oe += 6;
         if (indexTitle == 1 && indexSelect >= 0) {
            b(var1);
            SkillTemplate var10 = Char.getMyChar().nClass.c[indexSelect];
            gm = 4 + var10.f.length;
            Skill var9 = Char.getMyChar().a(var10);
            int var4 = fe;
            int var5 = oe + indexSize + 2;
            int var6 = ff - 6;
            int var7 = fg - 70 - indexSize;
            go.a(var1, var4, var5, var6, var7);
            this.ol = oe + 18;
            int var8;
            if (var9 == null) {
               var9 = var10.g.length > 1 ? var10.g[1] : var10.g[0];
               mFont.a.a(var1, var10.b, od + 5, this.ol += 12, 0);
               mFont.i.a(var1, "ID: " + var10.id + ", TYPE: " + var10.type, od + 5, this.ol += 12, 0);

               for(var8 = 0; var8 < var10.f.length; ++var8) {
                  mFont.i.a(var1, var10.f[var8], od + 5, this.ol += 12, 0);
               }

               mFont.i.a(var1, TextGame.io[var10.type], od + 5, this.ol += 12, 0);
               mFont.i.a(var1, TextGame.hs + ": " + var10.maxPoint, od + 5, this.ol += 12, 0);
               mFont.l.a(var1, TextGame.a(TextGame.hq, String.valueOf(var9.point)), od + 5, this.ol += 12, 0);
               this.a(var1, var9);
               this.b(var1, var9);
            } else {
               mFont.e.a(var1, var10.b, od + 5, this.ol += 12, 0);
               mFont.i.a(var1, "ID: " + var10.id + ", TYPE: " + var10.type, od + 5, this.ol += 12, 0);

               for(var8 = 0; var8 < var10.f.length; ++var8) {
                  mFont.i.a(var1, var10.f[var8], od + 5, this.ol += 12, 0);
               }

               mFont.i.a(var1, TextGame.io[var10.type], od + 5, this.ol += 12, 0);
               mFont.i.a(var1, TextGame.hs + ": " + var10.maxPoint, od + 5, this.ol += 12, 0);
               if (var9.point == var10.maxPoint) {
                  mFont.m.a(var1, TextGame.ht, od + 5, this.ol += 12, 0);
                  this.a(var1, var9);
                  this.b(var1, var9);
               } else {
                  mFont.m.a(var1, TextGame.a(TextGame.hr, String.valueOf(var9.point)), od + 5, this.ol += 12, 0);
                  this.a(var1, var9);
                  this.b(var1, var9);

                  for(var8 = 0; var8 < var10.g.length; ++var8) {
                     if (var10.g[var8].equals(var9)) {
                        ++var8;
                        break;
                     }
                  }

                  mFont.l.a(var1, TextGame.a(TextGame.hq, String.valueOf(var10.g[var8].point)), od + 5, this.ol += 12, 0);
                  this.a(var1, var10.g[var8]);
                  ++gm;
                  this.b(var1, var10.g[var8]);
               }
            }

            go.a(gm, 12, var4, var5, var6, var7, true, 1);
            if (av >= 0) {
               SmallImage.a(var1, 942, od + 2, oe + 32 + av * 12, 0, StaticObj.c);
            }
         }
      }

   }

   private void a(mGraphics var1, String[] var2) {
      try {
         b(var1);
         this.a(var1, var2, true);
         this.a(var1, Char.getMyChar().arrItemBag);
      } catch (Exception var4) {
         ;
      }

   }

   private void a(mGraphics var1, Item[] var2) {
      ok = var2.length / oj;
      ba.a(ok, indexSize, od, oe, oj * indexSize, javaDocBagViewportHeight(ok), true, 6);
      clampJavaDocScroll(ba);
      applyJavaDocGridClipOrScroll(var1, od, oe, ba.e + 2, ba.f + 2);
      logJavaDocBagLayout(var1, "a_ItemArray");

      int var3;
      int var4;
      int var8 = javaDocBagRowLimit(ok);
      for(var3 = javaDocBagFirstRow(); var3 < var8; ++var3) {
         for(var4 = 0; var4 < oj; ++var4) {
            SmallImage.a(var1, 154, od + var4 * indexSize + indexSize / 2, javaDocBagRowY(var3) + indexSize / 2, 0, 3);
            var1.a(12281361);
            var1.b(od + var4 * indexSize, javaDocBagRowY(var3), indexSize, indexSize);
         }
      }

      for(var3 = 0; var3 < var2.length; ++var3) {
         Item var7;
         if ((var7 = var2[var3]) != null) {
            int var5 = var7.indexUI / oj;
            int var6 = var7.indexUI - var5 * oj;
            if (javaDocBagRowVisible(var5, ok)) {
               this.a(var1, var7, od + var6 * indexSize, javaDocBagRowY(var5));
               if (var7.quantity > 1) {
                  mFont.p.a(var1, "" + var7.quantity, od + var6 * indexSize + indexSize, javaDocBagRowY(var5) + indexSize - mFont.p.c(), 1);
               }
            }
         }
      }

      if (indexTitle > 0 && indexSelect >= 0) {
         var3 = indexSelect / oj;
         var4 = indexSelect - var3 * oj;
         if (javaDocBagRowVisible(var3, ok)) {
            var1.a(16777215);
            var1.b(od + var4 * indexSize, javaDocBagRowY(var3), indexSize, indexSize);
            a(od + var4 * indexSize, javaDocBagRowY(var3), var1);
         }
      }

   }

   private void showitem(mGraphics var1, short[] var2) {
      ok = var2.length / oj;
      ba.a(ok, indexSize, od, oe, oj * indexSize, 5 * indexSize, true, 6);
      ba.a(var1, od, oe, ba.e + 2, ba.f + 2);

      int var3;
      int var4;
      for(var3 = 0; var3 < ok; ++var3) {
         for(var4 = 0; var4 < oj; ++var4) {
            SmallImage.a(var1, 154, od + var4 * indexSize + indexSize / 2, oe + var3 * indexSize + indexSize / 2, 0, 3);
            var1.a(12281361);
            var1.b(od + var4 * indexSize, oe + var3 * indexSize, indexSize, indexSize);
         }
      }

      for(var3 = 0; var3 < var2.length; ++var3) {
         short var7;
         if ((var7 = var2[var3]) > 0) {
            int var5 = var3 / oj;
            int var6 = var3 - var5 * oj;
            ItemTemplate local = ItemTemplates.a(var7);
            if (local != null) {
               SmallImage.a(var1, local.iconID, od + var6 * indexSize + indexSize / 2, oe + var5 * indexSize + indexSize / 2, 0, 3);
            }
         }
      }

      if (indexTitle > 0 && indexSelect >= 0) {
         var3 = indexSelect / oj;
         var4 = indexSelect - var3 * oj;
         var1.a(16777215);
         var1.b(od + var4 * indexSize, oe + var3 * indexSize, indexSize, indexSize);
         a(od + var4 * indexSize, oe + var3 * indexSize, var1);
      }

   }

   private static void a(int var0, int var1, mGraphics var2) {
      var2.a(js, var0 - 5, var1 - 5, 0);
   }

   private static int i(int var0) {
      int var1 = indexSize - 2;
      if ((var0 %= var1 * 4) >= 0 && var0 < var1) {
         return 0;
      } else if (var1 <= var0 && var0 < var1 << 1) {
         return var0 % var1;
      } else {
         return var1 << 1 <= var0 && var0 < var1 * 3 ? var1 : var1 - var0 % var1;
      }
   }

   private static int j(int var0) {
      int var1 = indexSize - 2;
      if ((var0 %= var1 * 4) >= 0 && var0 < var1) {
         return var0 % var1;
      } else if (var1 <= var0 && var0 < var1 << 1) {
         return var1;
      } else {
         return var1 << 1 <= var0 && var0 < var1 * 3 ? var1 - var0 % var1 : 0;
      }
   }

   private void b(mGraphics var1, Item[] var2) {
      try {
         b(var1);
         String var4 = op;
         Paint.a(fe, fd, ff, fg, var1);
         mFont.i.a(var1, TextGame.ka + ": " + NinjaUtil.a(String.valueOf(Char.getMyChar().xu)), fe + 6, fd + fg - 26, 0);
         mFont.i.a(var1, TextGame.kb + ": " + NinjaUtil.a(String.valueOf(Char.getMyChar().yen)), fe + ff - 6, fd + fg - 26, 1);
         if (cs) {
            if (GameCanvas.w % 10 > 4) {
               mFont.j.a(var1, TextGame.ey, fe + ff / 2, fd + fg - 14, 2);
            }
         } else if (hz) {
            if (GameCanvas.w % 10 > 4) {
               mFont.j.a(var1, TextGame.ew, fe + ff / 2, fd + fg - 14, 2);
            }
         } else if (ib) {
            if (GameCanvas.w % 10 > 4) {
               mFont.j.a(var1, TextGame.ex, fe + ff / 2, fd + fg - 14, 2);
            }
         } else {
            mFont.j.a(var1, TextGame.kc + ": " + NinjaUtil.a(String.valueOf(Char.getMyChar().luong)), fe + ff / 2, fd + fg - 14, 2);
         }

         a(var1, var4, false);
         od = fe + 3;
         oe = fd + javaDocBagGridTopOffset();
         var1.a(6425);
         var1.c(od - 1, oe - 1, oj * indexSize + 3, javaDocBagFrameRows() * indexSize + 3);
         if (var2 == null) {
            GameCanvas.a(fe + 90, fd + 75, var1, false);
            mFont.e.a(var1, TextGame.y, fe + 90, fd + 90, 2);
            return;
         }

         if (var2.length <= 30) {
            ok = 5;
         } else if (var2.length % oj == 0) {
            ok = var2.length / oj;
         } else {
            ok = var2.length / oj + 1;
         }

         ba.a(ok, indexSize, od, oe, oj * indexSize, javaDocBagViewportHeight(ok), true, 6);
         clampJavaDocScroll(ba);
         applyJavaDocGridClipOrScroll(var1, od, oe, ba.e + 2, ba.f + 2);
         logJavaDocBagLayout(var1, "b_ItemArray");

         int var3;
         int var8;
         int var11 = javaDocBagRowLimit(ok);
         for(var8 = javaDocBagFirstRow(); var8 < var11; ++var8) {
            for(var3 = 0; var3 < oj; ++var3) {
               SmallImage.a(var1, 154, od + var3 * indexSize + indexSize / 2, javaDocBagRowY(var8) + indexSize / 2, 0, 3);
               var1.a(12281361);
               var1.b(od + var3 * indexSize, javaDocBagRowY(var8), indexSize, indexSize);
            }
         }

         for(var8 = 0; var8 < var2.length; ++var8) {
            Item var9;
            if ((var9 = var2[var8]) != null) {
               int var10 = var9.indexUI / oj;
               int var5 = var9.indexUI - var10 * oj;
               if (javaDocBagRowVisible(var10, ok)) {
                  if (!var9.isLock) {
                     var1.a(12083);
                     var1.c(od + var5 * indexSize + 1, javaDocBagRowY(var10) + 1, indexSize - 1, indexSize - 1);
                     SmallImage.a(var1, 154, od + var5 * indexSize + indexSize / 2, javaDocBagRowY(var10) + indexSize / 2, 0, 3);
                  }

                  SmallImage.a(var1, var9.template.iconID, od + var5 * indexSize + indexSize / 2, javaDocBagRowY(var10) + indexSize / 2, 0, 3);
               }
            }
         }

         if (indexTitle > 0 && indexSelect >= 0) {
            var8 = indexSelect / oj;
            var3 = indexSelect - var8 * oj;
            if (javaDocBagRowVisible(var8, ok)) {
               var1.a(16777215);
               var1.b(od + var3 * indexSize, javaDocBagRowY(var8), indexSize, indexSize);
               a(od + var3 * indexSize, javaDocBagRowY(var8), var1);
            }
            return;
         }
      } catch (Exception var9) {
      }

   }

   private void a(mGraphics var1, String[] var2, Item[] var3) {
      try {
         b(var1);
         this.a(var1, var2, true);
         if (var3 == null) {
            GameCanvas.a(fe + 90, fd + 75, var1, false);
            mFont.e.a(var1, TextGame.y, fe + 90, fd + 90, 2);
            return;
         }

         if (var3.length <= 30) {
            ok = 5;
         } else if (var3.length % oj == 0) {
            ok = var3.length / oj;
         } else {
            ok = var3.length / oj + 1;
         }

         ba.a(ok, indexSize, od, oe, oj * indexSize, javaDocBagViewportHeight(ok), true, 6);
         clampJavaDocScroll(ba);
         applyJavaDocGridClipOrScroll(var1, od, oe, ba.e + 2, ba.f + 2);
         logJavaDocBagLayout(var1, "a_StringItemArray");

         int var7;
         int var8;
         int var10 = javaDocBagRowLimit(ok);
         for(var7 = javaDocBagFirstRow(); var7 < var10; ++var7) {
            for(var8 = 0; var8 < oj; ++var8) {
               SmallImage.a(var1, 154, od + var8 * indexSize + indexSize / 2, javaDocBagRowY(var7) + indexSize / 2, 0, 3);
               var1.a(12281361);
               var1.b(od + var8 * indexSize, javaDocBagRowY(var7), indexSize, indexSize);
            }
         }

         for(var7 = 0; var7 < var3.length; ++var7) {
            Item var9;
            if ((var9 = var3[var7]) != null) {
               int var4 = var9.indexUI / oj;
               int var5 = var9.indexUI - var4 * oj;
               if (javaDocBagRowVisible(var4, ok)) {
                  if (!var9.isLock) {
                     var1.a(12083);
                     var1.c(od + var5 * indexSize + 1, javaDocBagRowY(var4) + 1, indexSize - 1, indexSize - 1);
                     SmallImage.a(var1, 154, od + var5 * indexSize + indexSize / 2, javaDocBagRowY(var4) + indexSize / 2, 0, 3);
                  }

                  if (GameCanvas.w % 6 == 0) {
                     var9.indexFrame = (var9.indexFrame + 1) % 3;
                  }

                  if (var9.u()) {
                     var1.a(GameCanvas.ay, od + var5 * indexSize + indexSize / 2, javaDocBagRowY(var4) + indexSize / 2, 3);
                  }

                  SmallImage.a(var1, var9.template.iconID, od + var5 * indexSize + indexSize / 2, javaDocBagRowY(var4) + indexSize / 2, 0, 3, var9.indexFrame);
               }
            }
         }

         if (indexTitle > 0 && indexSelect >= 0) {
            var7 = indexSelect / oj;
            var8 = indexSelect - var7 * oj;
            if (javaDocBagRowVisible(var7, ok)) {
               var1.a(16777215);
               var1.b(od + var8 * indexSize, javaDocBagRowY(var7), indexSize, indexSize);
               a(od + var8 * indexSize, javaDocBagRowY(var7), var1);
            }
            return;
         }
      } catch (Exception var9) {
      }

   }

   private void a(mGraphics var1, String[] var2, boolean var3) {
      Paint.a(fe, fd, ff, fg, var1);
      if (var3) {
         mFont.i.a(var1, TextGame.ka + ": " + NinjaUtil.a(String.valueOf(Char.getMyChar().xu)), fe + 6, fd + fg - 26, 0);
         mFont.i.a(var1, TextGame.kb + ": " + NinjaUtil.a(String.valueOf(Char.getMyChar().yen)), fe + ff - 6, fd + fg - 26, 1);
         if (cs) {
            if (GameCanvas.w % 10 > 4) {
               mFont.j.a(var1, TextGame.ey, fe + ff / 2, fd + fg - 14, 2);
            }
         } else if (hz) {
            if (GameCanvas.w % 10 > 4) {
               mFont.j.a(var1, TextGame.ew, fe + ff / 2, fd + fg - 14, 2);
            }
         } else if (ib) {
            if (GameCanvas.w % 10 > 4) {
               mFont.j.a(var1, TextGame.ex, fe + ff / 2, fd + fg - 14, 2);
            }
         } else {
            mFont.j.a(var1, TextGame.kc + ": " + NinjaUtil.a(String.valueOf(Char.getMyChar().luong)), fe + ff / 2, fd + fg - 14, 2);
         }
      }

      a(var1, var2[aw], var2.length > 1);
      od = fe + 3;
      oe = fd + javaDocBagGridTopOffset();
      var1.a(6425);
      var1.c(od - 1, oe - 1, oj * indexSize + 3, javaDocBagFrameRows() * indexSize + 3);
   }

   private void a(mGraphics var1, Item var2, int var3, int var4) {
      this.a(var1, var2, var3, var4, 0, 0);
   }

   private void a(mGraphics var1, Item var2, int var3, int var4, int var5, int var6) {
      if (!var2.c()) {
         if ((var5 += var2.upgrade) > 0) {
            if (var5 >= 4) {
               var1.a(this.om[var5 > 16 ? 16 : var5]);
               var1.c(var3 + 1 + var6, var4 + 1 + var6, indexSize - 1 - var6 * 2, indexSize - 1 - var6 * 2);
               SmallImage.a(var1, 154, var3 + indexSize / 2, var4 + indexSize / 2, 0, 3);
            } else {
               a(var1, var2, var3, var4, var6);
            }

            if (var5 >= 1) {
               int var10001 = var3 + indexSize / 2;
               int var10002 = var4 + indexSize / 2;
               mGraphics var8 = var1;
               int var7 = var5;
               var6 = var10002;
               var5 = var10001;
               GameScr var14 = this;
               int var9 = indexSize - 2;
               int var10 = var7 < 4 ? 0 : (var7 < 8 ? 1 : (var7 < 12 ? 2 : (var7 <= 14 ? 3 : 4)));

               int var11;
               int var12;
               int var13;
               for(var11 = 0; var11 < var14.oo.length; ++var11) {
                  var12 = var5 - var9 / 2 + j(GameCanvas.w - (var11 << 2));
                  var13 = var6 - var9 / 2 + i(GameCanvas.w - (var11 << 2));
                  var8.a(var14.on[var10][var11]);
                  var8.c(var12 - var14.oo[var11] / 2, var13 - var14.oo[var11] / 2, var14.oo[var11], var14.oo[var11]);
               }

               if (var7 == 4 || var7 == 8) {
                  for(var11 = 0; var11 < var14.oo.length; ++var11) {
                     var12 = var5 - var9 / 2 + j(GameCanvas.w - (var9 << 1) - (var11 << 2));
                     var13 = var6 - var9 / 2 + i(GameCanvas.w - (var9 << 1) - (var11 << 2));
                     var8.a(var14.on[var10 - 1][var11]);
                     var8.c(var12 - var14.oo[var11] / 2, var13 - var14.oo[var11] / 2, var14.oo[var11], var14.oo[var11]);
                  }
               }

               if (var7 != 1 && var7 != 4 && var7 != 8) {
                  for(var11 = 0; var11 < var14.oo.length; ++var11) {
                     var12 = var5 - var9 / 2 + j(GameCanvas.w - (var9 << 1) - (var11 << 2));
                     var13 = var6 - var9 / 2 + i(GameCanvas.w - (var9 << 1) - (var11 << 2));
                     var8.a(var14.on[var10][var11]);
                     var8.c(var12 - var14.oo[var11] / 2, var13 - var14.oo[var11] / 2, var14.oo[var11], var14.oo[var11]);
                  }
               }

               if (var7 != 1 && var7 != 4 && var7 != 8 && var7 != 12 && var7 != 2 && var7 != 5 && var7 != 9) {
                  for(var11 = 0; var11 < var14.oo.length; ++var11) {
                     var12 = var5 - var9 / 2 + j(GameCanvas.w - var9 - (var11 << 2));
                     var13 = var6 - var9 / 2 + i(GameCanvas.w - var9 - (var11 << 2));
                     var8.a(var14.on[var10][var11]);
                     var8.c(var12 - var14.oo[var11] / 2, var13 - var14.oo[var11] / 2, var14.oo[var11], var14.oo[var11]);
                  }
               }

               if (var7 != 1 && var7 != 4 && var7 != 8 && var7 != 12 && var7 != 2 && var7 != 5 && var7 != 9 && var7 != 13 && var7 != 3 && var7 != 6 && var7 != 10 && var7 != 15) {
                  for(var11 = 0; var11 < var14.oo.length; ++var11) {
                     var12 = var5 - var9 / 2 + j(GameCanvas.w - var9 * 3 - (var11 << 2));
                     var13 = var6 - var9 / 2 + i(GameCanvas.w - var9 * 3 - (var11 << 2));
                     var8.a(var14.on[var10][var11]);
                     var8.c(var12 - var14.oo[var11] / 2, var13 - var14.oo[var11] / 2, var14.oo[var11], var14.oo[var11]);
                  }
               }
            }
         } else {
            a(var1, var2, var3, var4, var6);
         }
      }

      if (GameCanvas.w % 6 == 0) {
         var2.indexFrame = (var2.indexFrame + 1) % 3;
      }

      if (var2.u()) {
         var1.a(GameCanvas.ay, var3 + indexSize / 2, var4 + indexSize / 2, 3);
      }

      SmallImage.a(var1, var2.template.iconID, var3 + indexSize / 2, var4 + indexSize / 2, 0, 3, var2.indexFrame);
   }

   private static void a(mGraphics var0, Item var1, int var2, int var3, int var4) {
      if (!var1.isLock) {
         var0.a(12083);
      } else {
         var0.a(6425);
      }

      var0.c(var2 + 1 + var4, var3 + 1 + var4, indexSize - 2 - var4 * 2, indexSize - 2 - var4 * 2);
      SmallImage.a(var0, 154, var2 + indexSize / 2, var3 + indexSize / 2, 0, 3);
   }

   private void b(mGraphics var1, String[] var2) {
      try {
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, var2[aw], var2.length > 1);
         od = fe + 3;
         oe = fd + 34 + indexSize;
         int var10 = fe + 74;
         int var3 = oe - indexSize - 3;
         ok = 4;
         if (cj != null) {
            this.a(var1, cj, var10, var3);
         } else {
            var1.a(6425);
            var1.c(var10 - 1, var3 - 1, indexSize + 3, indexSize + 3);
            SmallImage.a(var1, 154, var10 + indexSize / 2, var3 + indexSize / 2, 0, 3);
         }

         var1.a(12281361);
         var1.b(var10, var3, indexSize, indexSize);
         var1.a(6425);
         var1.c(od - 1, oe - 1, indexSize * oj + 3, indexSize * ok + 3);

         int var4;
         int var8;
         for(var8 = 0; var8 < ok; ++var8) {
            for(var4 = 0; var4 < oj; ++var4) {
               SmallImage.a(var1, 154, od + var4 * indexSize + indexSize / 2, oe + var8 * indexSize + indexSize / 2, 0, 3);
               var1.a(12281361);
               var1.b(od + var4 * indexSize, oe + var8 * indexSize, indexSize, indexSize);
            }
         }

         for(var8 = 0; var8 < cb.length; ++var8) {
            Item var11;
            if ((var11 = cb[var8]) != null) {
               int var5 = var8 / oj;
               int var6 = var8 - var5 * oj;
               if (!var11.isLock) {
                  var1.a(12083);
                  var1.c(od + var6 * indexSize + 1, oe + var5 * indexSize + 1, indexSize - 1, indexSize - 1);
               }

               SmallImage.a(var1, var11.template.iconID, od + var6 * indexSize + indexSize / 2, oe + var5 * indexSize + indexSize / 2, 0, 3);
            }
         }

         if (indexTitle == 1) {
            var1.a(16777215);
            var1.b(var10, var3, indexSize, indexSize);
         } else if (indexTitle == 2) {
            var8 = indexSelect / oj;
            var4 = indexSelect - var8 * oj;
            var1.a(16777215);
            var1.b(od + var4 * indexSize, oe + var8 * indexSize, indexSize, indexSize);
         }

         if (fi != null) {
            SmallImage.a(var1, fi.b[fh].c, var10 + indexSize / 2 + fi.b[fh].a, var3 + indexSize / 2 + fi.b[fh].b, 0, 3);
            if (GameCanvas.w % 2 == 0 && ++fh >= fi.b.length) {
               fh = 0;
               fi = null;
            }
         }

         if (ij && cj != null) {
            ItemOption var9 = null;

            for(var4 = 0; var4 < cj.options.size() && (var9 = (ItemOption)cj.options.elementAt(var4)).c.a != 85; ++var4) {
               var9 = null;
            }

            if (var9 != null) {
               int[] var13 = new int[]{60, 45, 34, 26, 20, 15, 11, 8, 6};
               int[] var12 = new int[]{150000, 247500, 408375, 673819, 1111801, 2056832, 4010822, 7420021, 12243035};
               byte[] var14 = new byte[]{3, 5, 9, 4, 7, 10, 5, 7, 9};
               mFont.j.a(var1, TextGame.rv + ": " + NinjaUtil.a(String.valueOf(var9.a + 1)), od + 1, oe + 114, 0);
               mFont.j.a(var1, TextGame.gx + var13[var9.a] + "%)", od + 70, oe + 114, 0);
               mFont.j.a(var1, TextGame.ab + ": " + NinjaUtil.a(String.valueOf(var12[var9.a])) + " " + TextGame.kb + ", " + var14[var9.a] + " " + (var9.a < 3 ? TextGame.rz[1] : (var9.a < 6 ? TextGame.rz[2] : TextGame.rz[3])), od + 1, oe + 126, 0);
               return;
            }

            mFont.l.a(var1, TextGame.rr, od + 1, oe + 120, 0);
            return;
         }
      } catch (Exception var11) {
         ;
      }

   }

   private void c(mGraphics var1, String[] var2) {
      try {
         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, var2[aw], var2.length > 1);
         od = fe + 3;
         oe = fd + 32;
         var1.a(6425);
         ok = 4;
         int var3;
         int var7;
         int var8;
         int var5;
         if (!hz) {
            mFont.i.a(var1, TextGame.ri[0], od + 3, oe + ok * indexSize + 9, 0);
            mFont.i.a(var1, TextGame.ri[1], od + 3, oe + ok * indexSize + 21, 0);
            mFont.i.a(var1, TextGame.ri[2], od + 3, oe + ok * indexSize + 33, 0);
         } else {
            var7 = 0;
            var8 = 0;
            var3 = 0;
            boolean var4 = false;

            for(var5 = 0; var5 < bz.length; ++var5) {
               if (bz[var5] != null) {
                  if (bz[var5].isLock) {
                     var4 = true;
                  }

                  var7 += cx[bz[var5].template.id];
                  ++var8;
               }
            }

            if (var7 > 0) {
               for(var3 = cx.length - 1; var3 >= 0 && var7 <= cx[var3]; --var3) {
               }
            }

            if (var3 >= cx.length - 1) {
               var3 = cx.length - 2;
            }

            if (gp) {
               if (var8 > 1) {
                  mFont.j.a(var1, TextGame.gs + " " + (var3 + 2) + " " + (var4 ? TextGame.am : ""), od + 3, oe + ok * indexSize + 9, 0);
                  if (db[var3 + 1] > Char.getMyChar().xu) {
                     mFont.l.a(var1, TextGame.a(TextGame.gv, NinjaUtil.a(String.valueOf(db[var3 + 1]))), od + 3, oe + ok * indexSize + 21, 0);
                  } else {
                     mFont.j.a(var1, TextGame.a(TextGame.gv, NinjaUtil.a(String.valueOf(db[var3 + 1]))), od + 3, oe + ok * indexSize + 21, 0);
                  }

                  mFont.j.a(var1, TextGame.gw + ": " + var7 * 100 / cx[var3 + 1] + "%", od + 3, oe + ok * indexSize + 33, 0);
               } else {
                  for(var5 = 1; var5 <= 2; ++var5) {
                     mFont.i.a(var1, TextGame.go[var5], od + 3, oe + ok * indexSize + 5 + (var5 - 1) * 12, 0);
                  }
               }
            } else if (var8 > 1) {
               mFont.j.a(var1, TextGame.gs + " " + (var3 + 2) + " " + TextGame.am, od + 3, oe + ok * indexSize + 9, 0);
               if (db[var3 + 1] > Char.getMyChar().xu + Char.getMyChar().yen) {
                  mFont.l.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(db[var3 + 1]))), od + 3, oe + ok * indexSize + 21, 0);
               } else {
                  mFont.j.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(db[var3 + 1]))), od + 3, oe + ok * indexSize + 21, 0);
               }

               mFont.j.a(var1, TextGame.gw + ": " + var7 * 100 / cx[var3 + 1] + "%", od + 3, oe + ok * indexSize + 33, 0);
            } else {
               for(var5 = 0; var5 < 3; ++var5) {
                  mFont.i.a(var1, TextGame.go[var5], od + 3, oe + ok * indexSize + 5 + var5 * 12, 0);
               }
            }
         }

         var1.a(0);
         var1.c(od, oe, oj * indexSize + 1, ok * indexSize + 1);

         for(var7 = 0; var7 < ok; ++var7) {
            for(var8 = 0; var8 < oj; ++var8) {
               SmallImage.a(var1, 154, od + var8 * indexSize + indexSize / 2, oe + var7 * indexSize + indexSize / 2, 0, 3);
               var1.a(12281361);
               var1.b(od + var8 * indexSize, oe + var7 * indexSize, indexSize, indexSize);
            }
         }

         for(var7 = 0; var7 < bz.length; ++var7) {
            Item var9;
            if ((var9 = bz[var7]) != null) {
               var3 = var7 / oj;
               var5 = var7 - var3 * oj;
               if (!var9.isLock) {
                  var1.a(4543829);
                  var1.c(od + var5 * indexSize + 1, oe + var3 * indexSize + 1, indexSize - 1, indexSize - 1);
               }

               SmallImage.a(var1, var9.template.iconID, od + var5 * indexSize + indexSize / 2, oe + var3 * indexSize + indexSize / 2, 0, 3);
            }
         }

         if (indexTitle > 0) {
            var7 = indexSelect / oj;
            var8 = indexSelect - var7 * oj;
            var1.a(16777215);
            var1.b(od + var8 * indexSize, oe + var7 * indexSize, indexSize, indexSize);
         }

         if (fi != null) {
            SmallImage.a(var1, fi.b[fh].c, od + indexSize / 2 + fi.b[fh].a + 1, oe + indexSize / 2 + 9 + fi.b[fh].b, 0, 3);
            if (GameCanvas.w % 2 == 0 && ++fh >= fi.b.length) {
               fh = 0;
               fi = null;
               return;
            }
         }
      } catch (Exception var8) {
         ;
      }

   }

   private void p(mGraphics var1) {
      if (ig) {
         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         int var2 = ff;
         if (GameCanvas.j) {
            var2 = ff / 2 + 20;
         }

         var1.a(0);
         var1.c(fe + 7, fd + 31, var2 - 14, fg - 58);
         var1.a(-3170504);
         var1.b(fe + 8, fd + 32, var2 - 16, fg - 60);
         var1.a(Paint.a);
         var1.c(fe + 9, fd + 33, var2 - 18, fg - 62);
         a(var1, TextGame.qq, false);
         od = fe + 33;
         oe = fd + 40;

         int var3;
         for(var2 = 0; var2 < 3; ++var2) {
            for(var3 = 0; var3 < 3; ++var3) {
               var1.a(Paint.c);
               var1.c(od + var3 * 40, oe + 10 + var2 * 40, 29, 29);
               var1.a(-6527695);
               var1.b(od + var3 * 40, oe + 10 + var2 * 40, 29, 29);
               var1.a(-6737152);
               var1.c(od + var3 * 40 + 2, oe + 12 + var2 * 40, 26, 26);
               var1.a(Paint.c);
               var1.c(od + var3 * 40 + 4, oe + 14 + var2 * 40, 22, 22);
               SmallImage.a(var1, 1414, od + var3 * 40 + 20 - 5, oe + var2 * 40 + 20 + 4, 0, StaticObj.g);
            }
         }

         for(var2 = 0; var2 < 9; ++var2) {
            mGraphics var10000;
            int var10001;
            int var4;
            label77: {
               var3 = var2 / 3;
               var4 = var2 - var3 * 3;
               if (cg != null) {
                  var1.a(-16770791);
                  var1.c(od + var4 * 40 + 4, oe + 14 + var3 * 40, 22, 22);
                  var1.a(var2 == indexSelect ? -1 : -6527695);
                  var1.b(od + var4 * 40 + 4, oe + 14 + var3 * 40, 21, 21);
                  SmallImage.a(var1, 154, od + var4 * 40 + 17 - 3, oe + 7 + var3 * 40 + 17, 0, 3);
                  if (System.currentTimeMillis() - this.ej < 1000L) {
                     if (var2 == ax) {
                        SmallImage.a(var1, ItemTemplates.b(cg[ax]), od + var4 * 40 + 17 - 3, oe + 7 + var3 * 40 + 17, 0, 3);
                     } else {
                        SmallImage.a(var1, 1414, od + var4 * 40 + 17 - 2, oe + 7 + var3 * 40 + 17, 0, StaticObj.g);
                     }
                  } else if (cg[var2] >= 0 && cg[var2] < ItemTemplates.a.a.size()) {
                     SmallImage.a(var1, ItemTemplates.b(cg[var2]), od + var4 * 40 + 17 - 3, oe + 7 + var3 * 40 + 17, 0, 3);
                  } else {
                     SmallImage.a(var1, ItemTemplates.b((short)242), od + var4 * 40 + 17 - 3, oe + 7 + var3 * 40 + 17, 0, 3);
                  }

                  if (ax == var2 && this.el > 0) {
                     this.en[var2] = String.valueOf(this.el);
                  }

                  if (indexTitle != 1) {
                     continue;
                  }

                  if (ax == var2 && GameCanvas.w % 10 > 4) {
                     var10000 = var1;
                     var10001 = -3368653;
                     break label77;
                  }

                  if (var2 == indexSelect) {
                     var10000 = var1;
                     var10001 = -1;
                     break label77;
                  }

                  var10000 = var1;
               } else {
                  if (indexTitle != 1) {
                     continue;
                  }

                  var10000 = var1;
                  if (var2 == indexSelect) {
                     var10001 = -1;
                     break label77;
                  }
               }

               var10001 = Paint.b;
            }

            var10000.a(var10001);
            var1.b(od + var4 * 40, oe + 10 + var3 * 40, 29, 29);
         }

         mFont.j.a(var1, TextGame.qr + this.ch, fe + ff / 2, fd + fg - 20, 2);
      }

   }

   private void q(mGraphics var1) {
      if (hs) {
         if (aw == 0) {
            this.a(var1, TextGame.fs, bq);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.fs);
         }
      }

   }

   private void r(mGraphics var1) {
      if (ht) {
         if (aw == 0) {
            this.a(var1, TextGame.ft, br);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.ft);
         }
      }

   }

   private void s(mGraphics var1) {
      if (hu) {
         if (aw == 0) {
            this.a(var1, TextGame.fu, bs);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.fu);
         }
      }

   }

   private void t(mGraphics var1) {
      if (hv) {
         if (aw == 0) {
            this.a(var1, TextGame.fv, bt);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.fv);
         }
      }

   }

   private void u(mGraphics var1) {
      if (hw) {
         if (aw == 0) {
            String[] var2 = TextGame.fw;
            GameScr var8 = this;

            try {
               ok = 3;
               Paint.a(fe, fd, ff, fg, var1);
               a(var1, var2[aw], var2.length > 1);
               od = fe + 3;
               oe = fd + 34 + indexSize;
               int var10 = fe + 45;
               int var3 = fe + 100;
               int var4 = oe - indexSize - 3;
               if (ci != null) {
                  var8.a(var1, ci, var10, var4);
                  var1.a(12281361);
                  var1.b(var10, var4, indexSize, indexSize);
                  mFont.j.a(var1, "(+" + ci.upgrade + ")", var10 - 5, var4 + indexSize / 2 - 5, 1);
               } else {
                  var1.a(6425);
                  var1.c(var10 - 1, var4 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var10 + indexSize / 2, var4 + indexSize / 2, 0, 3);
                  var1.a(12281361);
                  var1.b(var10, var4, indexSize, indexSize);
               }

               SmallImage.a(var1, 942, var10 + 43, oe - 15, 0, StaticObj.g);
               if (ci != null && !ci.p()) {
                  var8.a(var1, ci, var3, var4, 1, 0);
                  var1.a(12281361);
                  var1.b(var3, var4, indexSize, indexSize);
                  mFont.j.a(var1, "(+" + (ci.upgrade + 1) + ")", var3 + indexSize + 10, var4 + indexSize / 2 - 5, 0);
               } else {
                  var1.a(6425);
                  var1.c(var3 - 1, var4 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var3 + indexSize / 2, var4 + indexSize / 2, 0, 3);
                  var1.a(12281361);
                  var1.b(var3, var4, indexSize, indexSize);
               }

               if (indexTitle == 1) {
                  if (indexSelect == 0) {
                     var1.a(16777215);
                     var1.b(var10, var4, indexSize, indexSize);
                  }

                  if (indexSelect == 1) {
                     var1.a(16777215);
                     var1.b(var3, var4, indexSize, indexSize);
                  }
               }

               int var5;
               int var9;
               if (ci == null) {
                  for(var9 = 0; var9 < 3; ++var9) {
                     mFont.i.a(var1, TextGame.gp[var9], od, oe + ok * indexSize + 5 + var9 * 12, 0);
                  }
               } else if (ci.p()) {
                  if (!GameCanvas.j) {
                     mFont.j.a(var1, TextGame.gp[3], fe + ff / 2, oe + ok * indexSize + 5, 2);
                  } else {
                     mFont.j.a(var1, TextGame.gp[3], fe + 7, oe + ok * indexSize + 5, 0);
                  }
               } else {
                  var9 = 0;

                  for(var3 = 0; var3 < ca.length; ++var3) {
                     if (ca[var3] != null && ca[var3].template.type == 26) {
                        var9 += cx[ca[var3].template.id];
                     }
                  }

                  var5 = 0;
                  if (ci.r()) {
                     if ((var3 = var9 * 100 / cy[ci.upgrade]) > df[ci.upgrade]) {
                        var3 = df[ci.upgrade];
                     }

                     if (hy) {
                        var3 = (int)((double)var3 * 1.5);
                        var5 = dg[ci.upgrade];
                     }

                     if (dc[ci.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                        mFont.l.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(dc[ci.upgrade]))), od, oe + ok * indexSize + 5, 0);
                     } else {
                        mFont.j.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(dc[ci.upgrade]))), od, oe + ok * indexSize + 5, 0);
                     }

                     if (var5 > Char.getMyChar().luong) {
                        mFont.l.a(var1, TextGame.a(TextGame.gu, String.valueOf(var5)), od, oe + ok * indexSize + 17, 0);
                     } else {
                        mFont.j.a(var1, TextGame.a(TextGame.gu, String.valueOf(var5)), od, oe + ok * indexSize + 17, 0);
                     }

                     mFont.j.a(var1, TextGame.gw + ": " + var3 + "%", od, oe + ok * indexSize + 29, 0);
                  } else if (ci.s()) {
                     if ((var3 = var9 * 100 / cz[ci.upgrade]) > df[ci.upgrade]) {
                        var3 = df[ci.upgrade];
                     }

                     if (hy) {
                        var3 = (int)((double)var3 * 1.5);
                        var5 = dg[ci.upgrade];
                     }

                     if (dd[ci.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                        mFont.l.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(dd[ci.upgrade]))), od, oe + ok * indexSize + 5, 0);
                     } else {
                        mFont.j.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(dd[ci.upgrade]))), od, oe + ok * indexSize + 5, 0);
                     }

                     if (var5 > Char.getMyChar().luong) {
                        mFont.l.a(var1, TextGame.a(TextGame.gu, String.valueOf(var5)), od, oe + ok * indexSize + 17, 0);
                     } else {
                        mFont.j.a(var1, TextGame.a(TextGame.gu, String.valueOf(var5)), od, oe + ok * indexSize + 17, 0);
                     }

                     mFont.j.a(var1, TextGame.gw + ": " + var3 + "%", od, oe + ok * indexSize + 29, 0);
                  } else if (ci.t()) {
                     if ((var3 = var9 * 100 / da[ci.upgrade]) > df[ci.upgrade]) {
                        var3 = df[ci.upgrade];
                     }

                     if (hy) {
                        var3 = (int)((double)var3 * 1.5);
                        var5 = dg[ci.upgrade];
                     }

                     if (de[ci.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                        mFont.l.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(de[ci.upgrade]))), od, oe + ok * indexSize + 5, 0);
                     } else {
                        mFont.j.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(de[ci.upgrade]))), od, oe + ok * indexSize + 5, 0);
                     }

                     if (var5 > Char.getMyChar().luong) {
                        mFont.l.a(var1, TextGame.a(TextGame.gu, String.valueOf(var5)), od, oe + ok * indexSize + 17, 0);
                     } else {
                        mFont.j.a(var1, TextGame.a(TextGame.gu, String.valueOf(var5)), od, oe + ok * indexSize + 17, 0);
                     }

                     mFont.j.a(var1, TextGame.gw + ": " + var3 + "%", od, oe + ok * indexSize + 29, 0);
                  }
               }

               var1.a(0);
               var1.c(od - 1, oe - 1, oj * indexSize + 3, ok * indexSize + 3);
               var9 = 0;

               while(true) {
                  if (var9 >= ok) {
                     if (indexTitle == 2) {
                        var9 = indexSelect / oj;
                        var3 = indexSelect - var9 * oj;
                        var1.a(16777215);
                        var1.b(od + var3 * indexSize, oe + var9 * indexSize, indexSize, indexSize);
                     }

                     for(var9 = 0; var9 < ca.length; ++var9) {
                        Item var11;
                        if ((var11 = ca[var9]) != null) {
                           var5 = var9 / oj;
                           int var6 = var9 - var5 * oj;
                           if (!var11.isLock) {
                              var1.a(12083);
                              var1.c(od + var6 * indexSize + 1, oe + var5 * indexSize + 1, indexSize - 1, indexSize - 1);
                           }

                           SmallImage.a(var1, var11.template.iconID, od + var6 * indexSize + indexSize / 2, oe + var5 * indexSize + indexSize / 2, 0, 3);
                        }
                     }

                     if (fi == null) {
                        return;
                     }

                     SmallImage.a(var1, fi.b[fh].c, var10 + indexSize / 2 + fi.b[fh].a + 1, var4 + indexSize / 2 + 9 + fi.b[fh].b, 0, 3);
                     if (GameCanvas.w % 2 == 0 && ++fh >= fi.b.length) {
                        fh = 0;
                        fi = null;
                        break;
                     }

                     return;
                  }

                  for(var3 = 0; var3 < oj; ++var3) {
                     SmallImage.a(var1, 154, od + var3 * indexSize + indexSize / 2, oe + var9 * indexSize + indexSize / 2, 0, 3);
                     var1.a(12281361);
                     var1.b(od + var3 * indexSize, oe + var9 * indexSize, indexSize, indexSize);
                  }

                  ++var9;
               }
            } catch (Exception var11) {
               ;
               return;
            }
         } else if (aw == 1) {
            this.a(var1, TextGame.fw);
         }
      }

   }

   private void v(mGraphics var1) {
      if (cn) {
         if (aw == 0) {
            String[] var2 = TextGame.fx;
            GameScr var5 = this;

            try {
               ok = 5;
               Paint.a(fe, fd, ff, fg, var1);
               var5.a(var1, var2, false);
               var1.a(6693376);
               var1.c(fe + 3, fd + 32, 168, 140);
               var1.a(13408563);
               var1.b(fe + 3, fd + 32, 168, 140);
               int var6 = fe + 74;
               int var3 = fd + 40 + indexSize;
               mFont.i.a(var1, TextGame.mu, var6 + indexSize / 2, var3 - indexSize / 2 - 4, 2);
               if (ck != null) {
                  var1.a(6425);
                  var1.c(var6 - 1, var3 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var6 + indexSize / 2, var3 + indexSize / 2, 0, 3);
                  var5.a(var1, ck, var6, var3);
                  if (ck.quantity > 1) {
                     mFont.p.a(var1, String.valueOf(ck.quantity), var6 + indexSize, var3 + indexSize / 2 + 6, 1);
                  }

                  var1.a(indexTitle == 1 ? 16777215 : 12281361);
                  var1.b(var6, var3, indexSize, indexSize);
               } else {
                  var1.a(6425);
                  var1.c(var6 - 1, var3 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var6 + indexSize / 2, var3 + indexSize / 2, 0, 3);
                  var1.a(12281361);
                  var1.b(var6, var3, indexSize, indexSize);
               }

               mFont.i.a(var1, TextGame.mv, var6 + indexSize / 2, var3 + 3 * indexSize / 2 + 2, 2);
               if (Char.getMyChar().xu < 5000) {
                  mFont.l.a(var1, TextGame.qf, var6 + indexSize / 2, fd + fg - 25, 2);
                  mFont.l.a(var1, TextGame.qg, var6 + indexSize / 2, fd + fg - 13, 2);
               } else {
                  mFont.i.a(var1, TextGame.qf, var6 + indexSize / 2, fd + fg - 25, 2);
                  mFont.i.a(var1, TextGame.qg, var6 + indexSize / 2, fd + fg - 13, 2);
               }

               var5.jd.a = fe + 40;
               var5.jd.b = fd + 130;
               var5.jd.a(var1);
            } catch (Exception var6) {
               ;
               return;
            }
         } else if (aw == 1) {
            this.a(var1, TextGame.fx);
         }
      }

   }

   private void w(mGraphics var1) {
      if (hx) {
         if (aw == 0) {
            String[] var2 = TextGame.fy;
            GameScr var7 = this;

            try {
               ok = 3;
               Paint.a(fe, fd, ff, fg, var1);
               a(var1, var2[aw], var2.length > 1);
               od = fe + 3;
               oe = fd + 34 + indexSize;
               int var9 = fe + 45;
               int var3 = fe + 100;
               int var4 = oe - indexSize - 3;
               if (ce[0] != null) {
                  var7.a(var1, ce[0], var9, var4);
                  var1.a(12281361);
                  var1.b(var9, var4, indexSize, indexSize);
                  mFont.j.a(var1, "(+" + ce[0].upgrade + ")", var9 - 5, var4 + indexSize / 2 - 5, 1);
               } else {
                  var1.a(6425);
                  var1.c(var9 - 1, var4 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var9 + indexSize / 2, var4 + indexSize / 2, 0, 3);
                  var1.a(12281361);
                  var1.b(var9, var4, indexSize, indexSize);
               }

               SmallImage.a(var1, 942, var9 + 43, oe - 15, 0, StaticObj.g);
               Item var5;
               if (ce[1] != null) {
                  var5 = ce[1].a();
                  if (ce[0] != null && ce[0].template.type == var5.template.type && ce[1].template.level >= ce[0].template.level) {
                     var5.upgrade = ce[0].upgrade;
                  }

                  var7.a(var1, var5, var3, var4);
                  var1.a(12281361);
                  var1.b(var3, var4, indexSize, indexSize);
                  mFont.j.a(var1, "(+" + var5.upgrade + ")", var3 + indexSize + 10, var4 + indexSize / 2 - 5, 0);
               } else {
                  var1.a(6425);
                  var1.c(var3 - 1, var4 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var3 + indexSize / 2, var4 + indexSize / 2, 0, 3);
                  var1.a(12281361);
                  var1.b(var3, var4, indexSize, indexSize);
               }

               if (indexTitle == 1) {
                  if (indexSelect == 0) {
                     var1.a(16777215);
                     var1.b(var9, var4, indexSize, indexSize);
                  }

                  if (indexSelect == 1) {
                     var1.a(16777215);
                     var1.b(var3, var4, indexSize, indexSize);
                  }
               }

               var1.a(0);
               var1.c(od - 1, oe - 1, oj * indexSize + 3, ok * indexSize + 3);

               int var8;
               for(int var10 = 0; var10 < ok; ++var10) {
                  for(var8 = 0; var8 < oj; ++var8) {
                     SmallImage.a(var1, 154, od + var8 * indexSize + indexSize / 2, oe + var10 * indexSize + indexSize / 2, 0, 3);
                     var1.a(12281361);
                     var1.b(od + var8 * indexSize, oe + var10 * indexSize, indexSize, indexSize);
                  }
               }

               if ((var5 = ce[2]) != null) {
                  var8 = 0 / oj;
                  var9 = 0 - var8 * oj;
                  if (!var5.isLock) {
                     var1.a(12083);
                     var1.c(od + var9 * indexSize + 1, oe + var8 * indexSize + 1, indexSize - 1, indexSize - 1);
                  }

                  SmallImage.a(var1, var5.template.iconID, od + var9 * indexSize + indexSize / 2, oe + var8 * indexSize + indexSize / 2, 0, 3);
               }

               mFont.i.a(var1, "- " + TextGame.eq[0], od, oe + ok * indexSize + 10, 0);
               mFont.i.a(var1, "  " + TextGame.eq[1], od, oe + ok * indexSize + 22, 0);
               mFont.i.a(var1, "- " + TextGame.eq[2], od, oe + ok * indexSize + 34, 0);
               if (indexTitle != 2) {
                  return;
               }

               var8 = indexSelect / oj;
               var9 = indexSelect - var8 * oj;
               var1.a(16777215);
               var1.b(od + var9 * indexSize, oe + var8 * indexSize, indexSize, indexSize);
            } catch (Exception var10) {
               ;
               return;
            }
         } else if (aw == 1) {
            this.a(var1, TextGame.fw);
         }
      }

   }

   private void x(mGraphics var1) {
      if (ib) {
         if (aw == 0) {
            this.b(var1, TextGame.gd);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gd);
         }
      }

   }

   private void y(mGraphics var1) {
      if (ik) {
         if (aw == 0) {
            this.b(var1, TextGame.gg);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gg);
         }
      }

   }

   private void z(mGraphics var1) {
      if (ij) {
         if (aw == 0) {
            this.b(var1, TextGame.gh);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gh);
         }
      }

   }

   private void aa(mGraphics var1) {
      if (cs) {
         if (aw == 0) {
            String[] var2 = TextGame.ge;
            GameScr var7 = this;

            try {
               Paint.a(fe, fd, ff, fg, var1);
               a(var1, var2[aw], var2.length > 1);
               od = fe + 3;
               oe = fd + 45;
               ok = 4;
               int var10003 = od + 1;
               int var10004 = oe - 12;
               mFont.j.a(var1, Char.getMyChar().displayName(), var10003, var10004, 0);
               int var8 = od;

               int var3;
               for(var3 = 0; var3 < 3; ++var3) {
                  if (var3 == var7.dh) {
                     mFont.h.a(var1, String.valueOf(var3 + 1), var8 + 2 + var3 * 20, oe + ok * (indexSize + 3) + 8, 0);
                  } else {
                     mFont.k.a(var1, String.valueOf(var3 + 1), var8 + 2 + var3 * 20, oe + ok * (indexSize + 3) + 8, 0);
                  }

                  if (var3 < 2) {
                     SmallImage.a(var1, 942, var8 + 14 + var3 * 20, oe + ok * (indexSize + 3) + 13, 0, StaticObj.g);
                  }
               }

               mFont.i.a(var1, NinjaUtil.a(String.valueOf(var7.dj)) + " " + TextGame.ka, od, oe + ok * indexSize + 4, 0);
               if (var7.dh == 0) {
                  var1.a(0);
               }

               if (var7.dh == 1) {
                  var1.a(210986);
               }

               if (var7.dh == 2) {
                  var1.a(805690);
               }

               var1.c(od - 1, oe - 1, indexSize * 3 + 3, (indexSize << 2) + 3);

               for(var3 = 0; var3 < ok; ++var3) {
                  for(var8 = 0; var8 < 3; ++var8) {
                     SmallImage.a(var1, 154, od + var8 * indexSize + indexSize / 2, oe + var3 * indexSize + indexSize / 2, 0, 3);
                     var1.a(12281361);
                     var1.b(od + var8 * indexSize, oe + var3 * indexSize, indexSize, indexSize);
                  }
               }

               if (indexTitle == 1) {
                  var3 = indexSelect / 3;
                  var8 = indexSelect - var3 * 3;
                  var1.a(16777215);
                  var1.b(od + var8 * indexSize, oe + var3 * indexSize, indexSize, indexSize);
               }

               int var4;
               int var5;
               Item var9;
               if (cc != null) {
                  for(var3 = 0; var3 < cc.length; ++var3) {
                     if ((var9 = cc[var3]) != null) {
                        var4 = var3 / 3;
                        var5 = var3 - var4 * 3;
                        if (!var9.isLock) {
                           var1.a(12083);
                           var1.c(od + var5 * indexSize + 1, oe + var4 * indexSize + 1, indexSize - 1, indexSize - 1);
                        }

                        if (GameCanvas.w % 6 == 0) {
                           var9.indexFrame = (var9.indexFrame + 1) % 3;
                        }

                        if (var9.u()) {
                           var1.a(GameCanvas.ay, od + var5 * indexSize + indexSize / 2, oe + var4 * indexSize + indexSize / 2, 3);
                        }

                        SmallImage.a(var1, var9.template.iconID, od + var5 * indexSize + indexSize / 2, oe + var4 * indexSize + indexSize / 2, 0, 3, var9.indexFrame);
                        if (var9.quantity > 1) {
                           mFont.p.a(var1, String.valueOf(var9.quantity), od + var5 * indexSize + indexSize, oe + var4 * indexSize + indexSize - mFont.p.c(), 1);
                        }

                        if (var9.quantity > 1) {
                           mFont.p.a(var1, String.valueOf(var9.quantity), od + var5 * indexSize + indexSize, oe + var4 * indexSize + indexSize - mFont.p.c(), 1);
                        }
                     }
                  }
               }

               od = fe + ff - 2 - indexSize * 3;
               ok = 4;
               mFont.j.a(var1, var7.ee, fe + ff - 2, oe - 12, 1);
               var8 = fe + ff - 3 - 60;

               for(var3 = 0; var3 < 3; ++var3) {
                  if (var3 == var7.di) {
                     mFont.h.a(var1, String.valueOf(var3 + 1), var8 + 2 + var3 * 20, oe + ok * (indexSize + 3) + 8, 0);
                  } else {
                     mFont.k.a(var1, String.valueOf(var3 + 1), var8 + 2 + var3 * 20, oe + ok * (indexSize + 3) + 8, 0);
                  }

                  if (var3 < 2) {
                     SmallImage.a(var1, 942, var8 + 14 + var3 * 20, oe + ok * (indexSize + 3) + 13, 0, StaticObj.g);
                  }
               }

               mFont.i.a(var1, NinjaUtil.a(String.valueOf(var7.dk)) + " " + TextGame.ka, fe + ff - 2, oe + ok * indexSize + 4, 1);
               if (var7.di == 0) {
                  var1.a(0);
               }

               if (var7.di == 1) {
                  var1.a(210986);
               }

               if (var7.di == 2) {
                  var1.a(805690);
               }

               var1.c(od - 1, oe - 1, indexSize * 3 + 3, (indexSize << 2) + 3);

               for(var3 = 0; var3 < ok; ++var3) {
                  for(var8 = 0; var8 < 3; ++var8) {
                     SmallImage.a(var1, 154, od + var8 * indexSize + indexSize / 2, oe + var3 * indexSize + indexSize / 2, 0, 3);
                     var1.a(12281361);
                     var1.b(od + var8 * indexSize, oe + var3 * indexSize, indexSize, indexSize);
                  }
               }

               if (indexTitle == 2) {
                  var3 = indexSelect / 3;
                  var8 = indexSelect - var3 * 3;
                  var1.a(16777215);
                  var1.b(od + var8 * indexSize, oe + var3 * indexSize, indexSize, indexSize);
               }

               if (cd != null) {
                  for(var3 = 0; var3 < cd.length; ++var3) {
                     if ((var9 = cd[var3]) != null) {
                        var4 = var3 / 3;
                        var5 = var3 - var4 * 3;
                        if (!var9.isLock) {
                           var1.a(12083);
                           var1.c(od + var5 * indexSize + 1, oe + var4 * indexSize + 1, indexSize - 1, indexSize - 1);
                        }

                        if (GameCanvas.w % 6 == 0) {
                           var9.indexFrame = (var9.indexFrame + 1) % 3;
                        }

                        if (var9.u()) {
                           var1.a(GameCanvas.ay, od + var5 * indexSize + indexSize / 2, oe + var4 * indexSize + indexSize / 2, 3);
                        }

                        SmallImage.a(var1, var9.template.iconID, od + var5 * indexSize + indexSize / 2, oe + var4 * indexSize + indexSize / 2, 0, 3, var9.indexFrame);
                        if (var9.quantity > 1) {
                           mFont.p.a(var1, String.valueOf(var9.quantity), od + var5 * indexSize + indexSize, oe + var4 * indexSize + indexSize - mFont.p.c(), 1);
                        }

                        if (var9.quantity > 1) {
                           mFont.p.a(var1, String.valueOf(var9.quantity), od + var5 * indexSize + indexSize, oe + var4 * indexSize + indexSize - mFont.p.c(), 1);
                        }
                     }
                  }
               }

               var3 = (int)(System.currentTimeMillis() / 1000L);
               if (var7.dl - var3 > 0 && var7.dh == 1 && var7.di == 1) {
                  mFont.i.a(var1, TextGame.z + " " + (var7.dl - var3) + " " + TextGame.ky, fe + ff / 2, fd + fg - 13, 2);
               } else {
                  if (var7.dh != 0) {
                     return;
                  }

                  mFont.i.a(var1, TextGame.ez, fe + ff / 2, fd + fg - 13, 2);
               }
            } catch (Exception var11) {
               ;
               return;
            }
         } else if (aw == 1) {
            this.a(var1, TextGame.ge);
         }
      }

   }

   private void ab(mGraphics var1) {
      if (hz) {
         if (aw == 0) {
            this.c(var1, TextGame.fz);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.fz);
         }
      }

   }

   private void ac(mGraphics var1) {
      if (ii) {
         if (aw == 0) {
            this.c(var1, TextGame.gf);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gf);
         }
      }

   }

   private void ad(mGraphics var1) {
      if (ia) {
         if (aw == 0) {
            String[] var2 = TextGame.ga;
            GameScr var4 = this;

            try {
               b(var1);
               var4.a(var1, var2, false);
               if (Char.getMyChar().arrItemBox == null) {
                  GameCanvas.a(fe + 90, fd + 75, var1, false);
                  mFont.e.a(var1, TextGame.y, fe + 90, fd + 90, 2);
               } else {
                  mFont.i.a(var1, TextGame.eu + ": " + NinjaUtil.a(String.valueOf(Char.getMyChar().bs)), fe + ff / 2, fd + fg - 18, 2);
                  var4.a(var1, Char.getMyChar().arrItemBox);
               }
            } catch (Exception var5) {
               ;
               return;
            }
         } else if (aw == 1) {
            this.a(var1, TextGame.ga);
         }
      }

   }

   private void ae(mGraphics var1) {
      if (aw == 2) {
         var1.a(-var1.a(), -var1.b());
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.fg[aw], true);
         mFont.o.a(var1, TextGame.jc, fe + 10, fd + 33, 0);
         mFont.o.a(var1, "" + Char.getMyChar().pPoint, fe + ff - 10, fd + 33, 1);
         int var3 = (fg - 80) / 5;

         for(int var2 = 0; var2 < Char.getMyChar().potential.length; ++var2) {
            var1.a(Paint.d);
            if (indexTitle > 0 && indexTitle - 1 == var2) {
               var1.a(Paint.c);
               var1.c(fe + 5, fd + 52 + var2 * (var3 + 4), ff - 10, var3);
               var1.a(Paint.e);
            }

            var1.b(fe + 5, fd + 52 + var2 * (var3 + 4), ff - 10, var3);
            mFont.e.a(var1, "" + Char.getMyChar().potential[var2], fe + ff - 10, fd + 52 + (var3 - 10) / 2 + var2 * (var3 + 4), 1);
            mFont.e.a(var1, TextGame.iv[var2], fe + 10, fd + 52 + (var3 - 10) / 2 + var2 * (var3 + 4), 0);
         }

         if (indexTitle > 0) {
            switch (Char.getMyChar().nClass.a) {
               case 0:
                  mFont.n.a(var1, TextGame.oe[0], fe + 10, fd + 52 + (var3 - 10) / 2 + 4 * (var3 + 4), 0);
                  return;
               case 1:
               case 3:
               case 5:
                  mFont.n.a(var1, TextGame.of[indexTitle - 1], fe + 10, fd + 52 + (var3 - 10) / 2 + 4 * (var3 + 4), 0);
                  return;
               case 2:
               case 4:
               case 6:
                  mFont.n.a(var1, TextGame.og[indexTitle - 1], fe + 10, fd + 52 + (var3 - 10) / 2 + 4 * (var3 + 4), 0);
            }
         }
      }

   }

   public static Item k(int var0) {
      try {
         if (indexSelect < 0) {
            return null;
         }

         switch (var0) {
            case 2:
               if (bp.length > indexSelect) {
                  return bp[indexSelect];
               }

               return null;
            case 3:
               return Char.getMyChar().arrItemBag[indexSelect];
            case 4:
               return Char.getMyChar().arrItemBox[indexSelect];
            case 5:
               return currentCharViewInfo.arrItemBody[indexSelect + mj];
            case 6:
               if (bq.length > indexSelect) {
                  return bq[indexSelect];
               }

               return null;
            case 7:
               if (br.length > indexSelect) {
                  return br[indexSelect];
               }

               return null;
            case 8:
               if (bs.length > indexSelect) {
                  return bs[indexSelect];
               }

               return null;
            case 9:
               if (bt.length > indexSelect) {
                  return bt[indexSelect];
               }

               return null;
            case 10:
               return ca[indexSelect];
            case 11:
               return bz[indexSelect];
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
            case 49:
            case 50:
            case 51:
            default:
               break;
            case 14:
               if (bu.length > indexSelect) {
                  return bu[indexSelect];
               }

               return null;
            case 15:
               if (bx.length > indexSelect) {
                  return bx[indexSelect];
               }

               return null;
            case 16:
               if (bl.length > indexSelect) {
                  return bl[indexSelect];
               }

               return null;
            case 17:
               if (bm.length > indexSelect) {
                  return bm[indexSelect];
               }

               return null;
            case 18:
               if (bn.length > indexSelect) {
                  return bn[indexSelect];
               }

               return null;
            case 19:
               if (bo.length > indexSelect) {
                  return bo[indexSelect];
               }

               return null;
            case 20:
               if (bb.length > indexSelect) {
                  return bb[indexSelect];
               }

               return null;
            case 21:
               if (bc.length > indexSelect) {
                  return bc[indexSelect];
               }

               return null;
            case 22:
               if (bd.length > indexSelect) {
                  return bd[indexSelect];
               }

               return null;
            case 23:
               if (be.length > indexSelect) {
                  return be[indexSelect];
               }

               return null;
            case 24:
               if (bf.length > indexSelect) {
                  return bf[indexSelect];
               }

               return null;
            case 25:
               if (bg.length > indexSelect) {
                  return bg[indexSelect];
               }

               return null;
            case 26:
               if (bh.length > indexSelect) {
                  return bh[indexSelect];
               }

               return null;
            case 27:
               if (bi.length > indexSelect) {
                  return bi[indexSelect];
               }

               return null;
            case 28:
               if (bj.length > indexSelect) {
                  return bj[indexSelect];
               }

               return null;
            case 29:
               if (bk.length > indexSelect) {
                  return bk[indexSelect];
               }

               return null;
            case 32:
               if (by.length > indexSelect) {
                  return by[indexSelect];
               }

               return null;
            case 34:
               if (bw.length > indexSelect) {
                  return bw[indexSelect];
               }

               return null;
            case 35:
               if (bv.length > indexSelect) {
                  return bv[indexSelect];
               }

               return null;
            case 43:
               return bz[indexSelect];
            case 44:
               return cb[indexSelect];
            case 45:
               return cb[indexSelect];
            case 46:
               return cb[indexSelect];
            case 47:
               return ca[indexSelect];
            case 48:
               return cb[indexSelect];
            case 52:
               if (by.length > indexSelect) {
                  return by[indexSelect];
               }

               return null;
         }
      } catch (Exception var2) {
      }

      return null;
   }

   public static void ad() {
      TileMap.loadTileImage();
   }

   private static void a(mGraphics var0, String var1, boolean var2) {
      if (!fk.equals("")) {
         var1 = fk;
      }

      int var4 = i / 2;
      var0.a(Paint.c);
      var0.b(var4 - mFont.o.a(var1) / 2 - 12, fd + 4, mFont.o.a(var1) + 22, 24, 6, 6);
      if ((indexTitle == 0 || GameCanvas.g) && var2) {
         SmallImage.a(var0, 989, var4 - mFont.o.a(var1) / 2 - 15 - 7 - (GameCanvas.w % 8 <= 3 ? 2 : 0), fd + 16, 2, StaticObj.g);
         SmallImage.a(var0, 989, var4 + mFont.o.a(var1) / 2 + 15 + 5 + (GameCanvas.w % 8 <= 3 ? 2 : 0), fd + 16, 0, StaticObj.g);
      }

      if (indexTitle == 0) {
         var0.a(Paint.e);
      } else {
         var0.a(Paint.d);
      }

      var0.a(var4 - mFont.o.a(var1) / 2 - 12, fd + 4, mFont.o.a(var1) + 22, 24, 6, 6);
      mFont.o.a(var0, var1, var4, fd + 9, 2);
   }

   private void af(mGraphics var1) {
      if (id) {
         b(var1);
         this.a(var1, new String[]{TextGame.mc}, false);
         mFont.j.a(var1, TileMap.mapName, fe + ff / 2, fd + fg - 25, 2);
         if (indexSelect >= 0 && indexSelect < this.iu.length) {
            mFont.i.a(var1, TextGame.md + ": " + this.iu[indexSelect] + ", " + TextGame.me + ": " + this.iv[indexSelect], fe + ff / 2, fd + fg - 13, 2);
         }

         int var2 = indexSelect / this.it;
         int var3 = indexSelect % this.it;
         ok = this.iu.length / this.it;
         if (this.iu.length % this.it > 0) {
            ++ok;
         }

         if (ok < 5) {
            ok = 5;
         }

         ba.a(ok, indexSize, od, oe, oj * indexSize + 2, 5 * indexSize + 2, true, 6);
         ba.a(var1);
         int var4 = 0;

         for(int var5 = 0; var5 < ok; ++var5) {
            for(int var6 = 0; var6 < this.it; ++var6) {
               var1.a(12281361);
               var1.b(od + var6 * indexSize, oe + var5 * indexSize, indexSize, indexSize);
               if (var4 < this.iu.length) {
                  SmallImage.a(var1, 154, od + var6 * indexSize + indexSize / 2, oe + var5 * indexSize + indexSize / 2, 0, 3);
                  if (this.iu[var4] >= 20) {
                     mFont.a.a(var1, "" + var4, od + var6 * indexSize + indexSize / 2, oe + var5 * indexSize + indexSize / 2 - 4, 2);
                  } else if (this.iu[var4] >= 15) {
                     mFont.d.a(var1, "" + var4, od + var6 * indexSize + indexSize / 2, oe + var5 * indexSize + indexSize / 2 - 4, 2);
                  } else {
                     mFont.e.a(var1, "" + var4, od + var6 * indexSize + indexSize / 2, oe + var5 * indexSize + indexSize / 2 - 4, 2);
                  }

                  ++var4;
               }
            }
         }

         if (indexSelect >= 0) {
            var1.a(16777215);
            var1.b(od + var3 * indexSize, oe + var2 * indexSize, indexSize, indexSize);
         }
      }

   }

   private static void cq() {
      int var0 = 0;
      int var1 = 0;
      boolean var2 = false;
      boolean var3 = false;

      int var4;
      for(var4 = 0; var4 < bz.length; ++var4) {
         if (bz[var4] != null) {
            ++var0;
            var1 += cx[bz[var4].template.id];
            if (bz[var4].template.id == 11) {
               GameCanvas.ak.a(TextGame.li, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
               GameCanvas.aj = GameCanvas.ak;
               return;
            }
         }

         if (bz[var4] != null && bz[var4].isLock) {
            var2 = true;
         }

         if (bz[var4] != null && !bz[var4].isLock) {
            var3 = true;
         }
      }

      if (var0 <= 1) {
         GameCanvas.ak.a(TextGame.le, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      } else {
         for(var4 = cx.length - 1; var4 >= 0 && var1 <= cx[var4]; --var4) {
         }

         if (var4 >= cx.length - 1) {
            var4 = cx.length - 2;
         }

         if (gp) {
            if (db[var4 + 1] > Char.getMyChar().xu) {
               GameCanvas.ak.a(TextGame.lk, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
               GameCanvas.aj = GameCanvas.ak;
            } else if (var2) {
               GameCanvas.a(TextGame.lj, 88813, bz, 8882, (Object)null);
            } else {
               Service.gI().a(bz);
            }
         } else if (db[var4 + 1] > Char.getMyChar().xu + Char.getMyChar().yen) {
            GameCanvas.ak.a(TextGame.lk, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
            GameCanvas.aj = GameCanvas.ak;
         } else if (var3) {
            GameCanvas.a(TextGame.lj, 88814, bz, 8882, (Object)null);
         } else {
            Service.gI().b(bz);
         }
      }

   }

   private static void cr() {
      int var0 = 0;
      int var1 = 0;
      int var2 = 0;
      short var3 = 0;

      for(int var4 = 0; var4 < bz.length; ++var4) {
         Item var5;
         if ((var5 = bz[var4]) != null) {
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
         GameCanvas.a(TextGame.rl);
      } else if (var0 <= 9 && var1 <= 9 && (var3 < 10 || var0 <= 3 && var1 <= 3)) {
         if (var0 + var1 < 3) {
            GameCanvas.a(TextGame.rp);
         } else if (var3 == 10 && var1 == 3 || var3 == 11 && var0 == 3) {
            GameCanvas.a(TextGame.rm);
         } else {
            Service.gI().c(bz);
         }
      } else {
         GameCanvas.a(TextGame.rq);
      }

   }

   public static byte ae() {
      if (Char.getMyChar().ctaskId >= doa.length) {
         return -3;
      } else {
         byte var1;
         if (Char.getMyChar().ca == null) {
            var1 = dp[Char.getMyChar().ctaskId][0];
         } else {
            var1 = dp[Char.getMyChar().ctaskId][Char.getMyChar().ca.a + 1];
         }

         if (var1 == -1) {
            if (Char.getMyChar().nClass.a == 0 && Char.getMyChar().ctaskId == 9) {
               var1 = -2;
            } else if (Char.getMyChar().nClass.a != 0 && Char.getMyChar().nClass.a != 1 && Char.getMyChar().nClass.a != 2) {
               if (Char.getMyChar().nClass.a != 3 && Char.getMyChar().nClass.a != 4) {
                  if (Char.getMyChar().nClass.a == 5 || Char.getMyChar().nClass.a == 6) {
                     var1 = 27;
                  }
               } else {
                  var1 = 72;
               }
            } else {
               var1 = 1;
            }
         }

         return var1;
      }
   }

   public static byte af() {
      try {
         if (Char.getMyChar().ctaskId >= doa.length) {
            return -3;
         } else {
            byte var2;
            if (Char.getMyChar().ca == null) {
               var2 = doa[Char.getMyChar().ctaskId][0];
            } else {
               var2 = doa[Char.getMyChar().ctaskId][Char.getMyChar().ca.a + 1];
            }

            if (var2 == -1) {
               if (Char.getMyChar().nClass.a == 0 && Char.getMyChar().ctaskId == 9) {
                  var2 = -2;
               } else if (Char.getMyChar().nClass.a != 0 && Char.getMyChar().nClass.a != 1 && Char.getMyChar().nClass.a != 2) {
                  if (Char.getMyChar().nClass.a != 3 && Char.getMyChar().nClass.a != 4) {
                     if (Char.getMyChar().nClass.a == 5 || Char.getMyChar().nClass.a == 6) {
                        var2 = 11;
                     }
                  } else {
                     var2 = 10;
                  }
               } else {
                  var2 = 9;
               }
            }

            return var2;
         }
      } catch (Exception var1) {
         return -1;
      }
   }

   private void cs() {
      int var4 = 0;

      for(int var1 = 0; var1 < ca.length; ++var1) {
         if (ca[var1] != null && ca[var1].template.type == 26) {
            var4 += cx[ca[var1].template.id];
         }
      }

      boolean var5 = false;
      boolean var2 = false;
      int var3 = 0;
      if (ci.r()) {
         if (dc[ci.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
            var5 = true;
         }

         var3 = var4 * 100 / cy[ci.upgrade];
      } else if (ci.s()) {
         if (dd[ci.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
            var5 = true;
         }

         var3 = var4 * 100 / cz[ci.upgrade];
      } else if (ci.t()) {
         if (de[ci.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
            var5 = true;
         }

         var3 = var4 * 100 / da[ci.upgrade];
      }

      if (hy && dg[ci.upgrade] > Char.getMyChar().luong) {
         var2 = true;
      }

      if (var5) {
         InfoMe.a(TextGame.lm, 15, mFont.l);
      } else if (var2) {
         InfoMe.a(TextGame.ll, 15, mFont.l);
      } else if (var3 > 250) {
         GameCanvas.a(TextGame.ln, 88815, (Object)null, 8882, (Object)null);
      } else {
         ag();
      }

   }

   public static void ag() {
      if (!ci.isLock) {
         GameCanvas.a(TextGame.lo, new Command1(TextGame.bh, 11063), new Command1(TextGame.bu, 1));
      } else {
         Service.gI().a(ci, ca, hy);
      }

   }

   private static void ct() {
      if (!ir) {
         if (il) {
            Service.gI().a((byte)1, (Item)null, cj, cb);
            return;
         }

         if (ij) {
            Service.gI().a(cj, cb);
            ;
            return;
         }

         if (ik) {
            Service.gI().b(cj, cb);
            return;
         }

         if (cj.upgrade == 0) {
            GameCanvas.ak.a(TextGame.lp, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
            GameCanvas.aj = GameCanvas.ak;
            return;
         }

         int var0 = -1;
         int var1 = 0;

         int var2;
         for(var2 = 0; var2 < Char.getMyChar().arrItemBag.length; ++var2) {
            if (Char.getMyChar().arrItemBag[var2] == null) {
               ++var0;
            }
         }

         for(var2 = 0; var2 < cb.length; ++var2) {
            if (cb[var2] != null) {
               ++var1;
            }
         }

         if (var1 > var0) {
            GameCanvas.ak.a(TextGame.lq, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
            GameCanvas.aj = GameCanvas.ak;
            return;
         }

         GameCanvas.a(TextGame.lr, new Command1(TextGame.bh, 11087, cj), new Command1(TextGame.bu, 1));
      }

   }

   private void a(int var1, Item var2, Command1 var3, Command1 var4) {
      this.a((int)3, (Item)var2);
      if (var3 != null) {
         super.a = new Command1(var3.a, 11040);
      }

   }

   private static boolean allowShowItemInfo = true;

   private void a(int var1, Item var2) {
      if (cr && aw == 0 && !allowShowItemInfo) {
         return;
      }
      allowShowItemInfo = false;
      if (var2 != null) {
         this.gn = var2;
         os = 120;
         ot = 120;
         if (GameCanvas.g && !GameCanvas.i) {
            ot += 18;
         }

         cq = true;
         go.a();
         av = 0;
         if (var2.expires == 0L) {
            if (ij || ik || il || ir || im || io || in) {
               Service.gI().c(var2.typeUI, var2.indexUI);
            }

            if (ih) {
               Service.gI().ao(var2.itemId);
            } else if (currentCharViewInfo.idChar == Char.getMyChar().idChar) {
               Service.gI().c(var1, var2.indexUI);
            } else {
               Service.gI().d(currentCharViewInfo.idChar, var2.indexUI);
            }
         }

         if (var1 == 5) {
            Char.getMyChar().w();
         }

         super.b = this.ow;
         super.c = null;
         super.a = null;
         GameCanvas.i();
         GameCanvas.h();
      }

   }

   private void showItemInfoSplit(int var1, Item var2) {
      if (var2 != null) {
         this.gn = var2;
         os = 120;
         ot = 120;
         if (GameCanvas.g && !GameCanvas.i) {
            ot += 18;
         }
         cq = true;
         go.a();
         av = 0;
         if (var2.expires == 0L) {
            if (ih) {
               Service.gI().ao(var2.itemId);
            } else if (currentCharViewInfo.idChar == Char.getMyChar().idChar) {
               Service.gI().c(var1, var2.indexUI);
            } else {
               Service.gI().d(currentCharViewInfo.idChar, var2.indexUI);
            }
         }
      }
   }

   private boolean useSplitItemInfoCenterButton() {
      return !GameCanvas.j && (GameCanvas.g && GameCanvas.aa < 320 || !GameCanvas.g);
   }

   private boolean shouldAutoShowItemInfo() {
      return !useSplitItemInfoCenterButton();
   }

   private void shinwaChangeTab(int var1) {
      aw += var1;
      if (aw < 0) {
         aw = TextGame.qn.length - 1;
      } else if (aw > TextGame.qn.length - 1) {
         aw = 0;
      }
      indexTitle = 0;
      indexSelect = -1;
      cf = null;
      cq = false;
      ba.a();
      go.a();
      super.a = super.b = null;
      Service.gI().menu((byte)0, 28, 0, aw);
   }

   public final void a(String var1, String var2, boolean var3) {
      InfoDlg.b();
      co = true;
      this.ja = true;
      av = 0;
      b(175, 200);
      if (var3) {
         fg -= 60;
      }

      super.c = new Command1(TextGame.ah, 3);
      super.a = super.b = null;
      this.jc = var1;
      this.jb = mFont.g.a(var2, ff - 30);
   }

   public final void ah() {
      co = false;
      this.jc = null;
      this.jb = null;
      super.b = null;
      this.v();
   }

   public final void ai() {
      gm = this.jb.size();
      ba.a(gm, 12, fe, oe + 12, ff, fg - 42 - (this.jc != null ? 10 : 0), true, 1);
      av = this.jb.size() - 1;
      ba.a(av * ba.h);
   }

   private void ag(mGraphics var1) {
      if (this.jb != null && co) {
         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         if (this.jc != null) {
            a(var1, this.jc, cu);
         }

         od = fe + 15;
         oe = fd + 15;
         if (this.jc != null) {
            oe += 10;
         }

         gm = this.jb.size();
         ba.a(gm, 12, fe, oe + 12, ff, fg - 42 - (this.jc != null ? 10 : 0), true, 1);
         ba.a(var1);
         this.ol = oe;
         mFont var2 = mFont.i;

         String var4;
         for(int var3 = 0; var3 < this.jb.size() && (var4 = (String)this.jb.elementAt(var3)) != null && this.jb != null && var2 != null; ++var3) {
            if (var4.startsWith("c")) {
               if (var4.startsWith("c0")) {
                  var4 = var4.substring(2);
                  var2 = mFont.i;
               } else if (var4.startsWith("c1")) {
                  var4 = var4.substring(2);
                  var2 = mFont.d;
               } else if (var4.startsWith("c2")) {
                  var4 = var4.substring(2);
                  var2 = mFont.e;
               } else if (var4.startsWith("c3")) {
                  var4 = var4.substring(2);
                  var2 = mFont.j;
               } else if (var4.startsWith("c4")) {
                  var4 = var4.substring(2);
                  var2 = mFont.a;
               } else if (var4.startsWith("c5")) {
                  var4 = var4.substring(2);
                  var2 = mFont.l;
               } else if (var4.startsWith("c6")) {
                  var4 = var4.substring(2);
                  var2 = mFont.k;
               } else if (var4.startsWith("c7")) {
                  var4 = var4.substring(2);
                  var2 = mFont.b;
               } else if (var4.startsWith("c8")) {
                  var4 = var4.substring(2);
                  var2 = mFont.m;
               } else if (var4.startsWith("c9")) {
                  var4 = var4.substring(2);
                  var2 = mFont.n;
               }
            }

            var2.a(var1, var4, od + 5, this.ol += 12, 0);
         }

         if (av >= 0) {
            SmallImage.a(var1, 942, od - 5, oe + 12 + 1 + av * 12, 0, StaticObj.b);
         }
      }

   }

   private void ah(mGraphics var1) {
      if (gx) {
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.ie, false);
         od = fe + 5;
         oe = fd + 40;
         if (vPtMap.size() == 0) {
            mFont.i.a(var1, TextGame.np, fe + ff / 2, fd + 40, 2);
         } else {
            var1.a(6425);
            var1.c(od - 2, oe - 2, ff - 6, indexSize * 5 + 8);
            b(var1);
            ba.a(vPtMap.size(), indexSize, od, oe, ff - 3, indexSize * 5 + 4, true, 1);
            ba.a(var1, od, oe, ff - 3, indexSize * 5 + 6);
            gm = vPtMap.size();

            for(int var3 = 0; var3 < vPtMap.size(); ++var3) {
               Party var2 = (Party)vPtMap.elementAt(var3);
               if (av == var3) {
                  var1.a(Paint.b);
                  var1.c(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(16777215);
                  var1.b(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
               } else {
                  var1.a(Paint.a);
                  var1.c(od + 2, oe + var3 * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(13932896);
                  var1.b(od + 2, oe + var3 * indexSize + 2, ff - 15, indexSize - 4);
               }

               SmallImage.a(var1, 647, od + 12, oe + var3 * indexSize + indexSize / 2, 0, 3);
               mFont.i.a(var1, ChatManager.hideAuthor(var2.d) + " - " + TextGame.dv + ": " + var2.b + " (" + var2.g + ")", od + 22, oe + var3 * indexSize + indexSize / 2 - 6, 0);
            }
         }

         n(var1);
      }

   }

   private void ai(mGraphics var1) {
      if (gw) {
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.id, false);
         od = fe + 5;
         oe = fd + 40;
         if (vParty.size() == 0) {
            mFont.i.a(var1, TextGame.nn, fe + ff / 2, fd + 40, 2);
         } else {
            var1.a(6425);
            var1.c(od - 2, oe - 2, ff - 6, indexSize * 5 + 8);
            b(var1);
            ba.a(vParty.size(), indexSize, od, oe, ff - 3, indexSize * 5 + 4, true, 1);
            ba.a(var1, od, oe, ff - 3, indexSize * 5 + 6);
            gm = vParty.size();

            for(int var3 = 0; var3 < vParty.size(); ++var3) {
               Party var2 = (Party)vParty.elementAt(var3);
               if (av == var3) {
                  var1.a(Paint.b);
                  var1.c(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(16777215);
                  var1.b(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
               } else {
                  var1.a(Paint.a);
                  var1.c(od + 2, oe + var3 * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(13932896);
                  var1.b(od + 2, oe + var3 * indexSize + 2, ff - 15, indexSize - 4);
               }

               SmallImage.a(var1, var2.c, od + 12, oe + var3 * indexSize + indexSize / 2, 0, 3);
               if (var2.f == null) {
                  mFont.n.a(var1, ChatManager.hideAuthor(var2.d), od + 22, oe + var3 * indexSize + indexSize / 2 - 6, 0);
               } else if (var3 == 0) {
                  mFont.j.a(var1, ChatManager.hideAuthor(var2.d) + " - " + TextGame.dv + ": " + var2.f.cLevel, od + 22, oe + var3 * indexSize + indexSize / 2 - 6, 0);
               } else {
                  mFont.i.a(var1, ChatManager.hideAuthor(var2.d) + " - " + TextGame.dv + ": " + var2.f.cLevel, od + 22, oe + var3 * indexSize + indexSize / 2 - 6, 0);
               }
            }
         }

         n(var1);
      }

   }

   private void aj(mGraphics var1) {
      if (ih) {
         int var6 = ff;
         if (GameCanvas.j) {
            var6 = ff / 2 + 20;
         } else if (this.shouldAutoShowItemInfo()) {
            // Info panel start at fe+175. var6=175 đủ — Scroll.b() đã được fix để chỉ pickup
            // khi touch DOWN (q=true) trong area, không pickup mid-drag.
            var6 = 175;
            if (var6 > ff) {
               var6 = ff;
            }
         }

         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.qn[aw], GameCanvas.g ? true : indexTitle == 0);
         var1.a(6425);
         var1.c(od - 2, oe - 2, var6 - 6, indexSize * 5 + 4);
         if (cf == null) {
            GameCanvas.a(fe + 90, fd + 75, var1, false);
            mFont.e.a(var1, TextGame.y, fe + 90, fd + 90, 2);
            return;
         }

         ItemStands[] var2 = cf;
         od = fe + 5;
         oe = fd + 33;
         if (var2.length > 0) {
            gm = var2.length;
            b(var1);
            ba.a(gm, indexSize, od, oe, var6 - 3, indexSize * 5, true, 1);
            ba.a(var1, od, oe, var6 - 3, indexSize * 5 + 2);

            for(int var4 = 0; var4 < var2.length; ++var4) {
               ItemStands var5;
               if ((var5 = var2[var4]) != null && var5.a != null && var5.a.template != null) {
                  int var3 = (int)(System.currentTimeMillis() / 1000L);
                  if (var4 * indexSize >= ba.b - indexSize && var4 * indexSize < ba.b + indexSize * 5 + 4) {
                     if (indexSelect == var4) {
                        var1.a(Paint.b);
                        var1.c(od + 2, oe + indexSelect * indexSize + 2, var6 - 15, indexSize - 4);
                        var1.a(16777215);
                        var1.b(od + 2, oe + indexSelect * indexSize + 2, var6 - 15, indexSize - 4);
                     } else {
                        var1.a(Paint.a);
                        var1.c(od + 2, oe + var4 * indexSize + 2, var6 - 15, indexSize - 4);
                        var1.a(13932896);
                        var1.b(od + 2, oe + var4 * indexSize + 2, var6 - 15, indexSize - 4);
                     }

                     var1.a(0);
                     var1.c(od + 4, oe + var4 * indexSize + 4, indexSize - 1, indexSize - 8);
                     var1.a(indexSelect == var4 ? 16777215 : 12281361);
                     var1.b(od + 4, oe + var4 * indexSize + 4, indexSize - 1, indexSize - 8);
                     if (GameCanvas.w % 6 == 0) {
                        var5.a.indexFrame = (var5.a.indexFrame + 1) % 3;
                     }

                     var1.a(11403519);
                     if (var5.a.u()) {
                        var1.b(od + 5, oe + var4 * indexSize + 5, indexSize - 3, indexSize - 10);
                     }

                     SmallImage.a(var1, var5.a.template.iconID, od + indexSize / 2, oe + var4 * indexSize + indexSize / 2, 0, 3, var5.a.indexFrame);
                     if (var5.a.quantity > 1) {
                        mFont.p.a(var1, String.valueOf(var5.a.quantity), od + indexSize, oe + var4 * indexSize + indexSize / 2 + 2, 1);
                     }

                     var3 = var5.c - (var3 - var5.d);
                     mFont.i.a(var1, TextGame.qj + ": " + var5.e, od + indexSize + 7, oe + var4 * indexSize + indexSize / 2 - mFont.p.c() - 2, 0);
                     mFont.i.a(var1, TextGame.br + ": " + NinjaUtil.a(String.valueOf(var5.b)) + " " + TextGame.ka, od + indexSize + 7, oe + var4 * indexSize + indexSize / 2 - mFont.p.c() + 9, 0);
                     if (var3 < 60) {
                        mFont.m.a(var1, TextGame.ql, od + var6 - 30, oe + var4 * indexSize + indexSize / 2 - mFont.p.c() - 2, 2);
                        mFont.m.a(var1, TextGame.qm, od + var6 - 30, oe + var4 * indexSize + indexSize / 2 - mFont.p.c() + 9, 2);
                     } else {
                        mFont.n.a(var1, TextGame.qk, od + var6 - 30, oe + var4 * indexSize + indexSize / 2 - mFont.p.c() - 2, 2);
                        mFont.n.a(var1, NinjaUtil.b(var3), od + var6 - 30, oe + var4 * indexSize + indexSize / 2 - mFont.p.c() + 9, 2);
                     }
                  }
               }
            }
         } else {
            gm = var2.length;
            mFont.i.a(var1, TextGame.no, fe + var6 / 2, fd + 40, 2);
         }

         n(var1);
      }

   }

   private void ak(mGraphics var1) {
      if (cp || gz) {
         String var6 = cp ? TextGame.ig[0] : TextGame.ig[1];
         MyVector var2 = cp ? vFriend : vEnemies;
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, var6, false);
         if (var2.size() <= 0) {
            mFont.i.a(var1, cp ? TextGame.ih : TextGame.iw, fe + ff / 2, fd + 40, 2);
         } else {
            od = fe + 5;
            oe = fd + 40;
            var1.a(6425);
            var1.c(od - 2, oe - 2, ff - 6, indexSize * 5 + 8);
            b(var1);
            ba.a(var2.size(), indexSize, od, oe, ff - 3, indexSize * 5 + 4, true, 1);
            ba.a(var1, od, oe, ff - 3, indexSize * 5 + 6);
            gm = var2.size();
            int var7 = 0;
            int var3 = 0;

            while(true) {
               if (var3 >= var2.size()) {
                  gm = var7;
                  ba.a(var7, indexSize, od, oe, ff - 3, indexSize * 5 + 4, true, 1);
                  break;
               }

               Friend var4 = (Friend)var2.elementAt(var3);
               if (!gr || var4.b == 3) {
                  mFont var5 = mFont.k;
                  if (var4.b != 1 && var4.b != 2) {
                     if (var4.b == 3) {
                        var5 = mFont.i;
                     } else if (var4.b == 4) {
                        var5 = mFont.l;
                     }
                  } else {
                     var5 = mFont.n;
                  }

                  if (var3 * indexSize >= ba.b - indexSize && var3 * indexSize < ba.b + indexSize * 5 + 8) {
                     if (av == var3) {
                        var1.a(Paint.b);
                        var1.c(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
                        var1.a(16777215);
                        var1.b(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
                     } else {
                        var1.a(Paint.a);
                        var1.c(od + 2, oe + var3 * indexSize + 2, ff - 15, indexSize - 4);
                        var1.a(13932896);
                        var1.b(od + 2, oe + var3 * indexSize + 2, ff - 15, indexSize - 4);
                     }

                     if (var4.b == 4) {
                        if (GameCanvas.w % 10 > 7) {
                           var5.a(var1, var4.a, od + 8, oe + var3 * indexSize + indexSize / 2 - 6, 0);
                        } else {
                           mFont.j.a(var1, var4.a, od + 8, oe + var3 * indexSize + indexSize / 2 - 6, 0);
                        }

                        mFont.m.a(var1, TextGame.ii, od + ff - 15, oe + var3 * indexSize + indexSize / 2 - 6, 1);
                     } else {
                        var5.a(var1, var4.a, od + 8, oe + var3 * indexSize + indexSize / 2 - 6, 0);
                     }
                  }

                  ++var7;
               }

               ++var3;
            }
         }

         n(var1);
      }

   }

   private void al(mGraphics var1) {
      if (gv) {
         gm = 0;
         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.hw[aw], false);
         od = fe + 10;
         oe = fd + 32;
         int var2;
         String var4;
         if (aw == 0) {
            boolean var7 = false;
            ba.a(gm, 12, fe, fd + 32, ff, fg - 40, true, 1);
            ba.a(var1);
            int var8;
            int var10;
            if (Char.getMyChar().ca != null) {
               for(var8 = 0; var8 < Char.getMyChar().ca.c.length; ++var8) {
                  mFont.e.a(var1, Char.getMyChar().ca.c[var8], od, this.ol = oe, 0);
                  ++gm;
               }

               var8 = 0;
               var4 = null;

               for(var10 = 0; var10 < Char.getMyChar().ca.e.length; ++var10) {
                  mFont var9;
                  if (Char.getMyChar().ca.e[var10] != null) {
                     var8 = var10;
                     var4 = "- " + Char.getMyChar().ca.e[var10];
                     if (Char.getMyChar().ca.b[var10] != -1) {
                        if (Char.getMyChar().ca.a == var10) {
                           var4 = var4 + " " + Char.getMyChar().ca.f + "/" + Char.getMyChar().ca.b[var10];
                           if (Char.getMyChar().ca.f == Char.getMyChar().ca.b[var10]) {
                              mFont.i.a(var1, var4, od + 5, this.ol += 12, 0);
                           } else {
                              var9 = mFont.k;
                              if (!var7) {
                                 var7 = true;
                                 var9 = mFont.j;
                              }

                              var9.a(var1, var4, od + 5, this.ol += 12, 0);
                           }
                        } else if (Char.getMyChar().ca.a > var10) {
                           var4 = var4 + " " + Char.getMyChar().ca.b[var10] + "/" + Char.getMyChar().ca.b[var10];
                           mFont.i.a(var1, var4, od + 5, this.ol += 12, 0);
                        } else {
                           var4 = var4 + " 0/" + Char.getMyChar().ca.b[var10];
                           var9 = mFont.k;
                           if (!var7) {
                              var7 = true;
                              var9 = mFont.j;
                           }

                           var9.a(var1, var4, od + 5, this.ol += 12, 0);
                        }
                     } else if (Char.getMyChar().ca.a > var10) {
                        mFont.i.a(var1, var4, od + 5, this.ol += 12, 0);
                     } else {
                        var9 = mFont.k;
                        if (!var7) {
                           var7 = true;
                           var9 = mFont.j;
                        }

                        var9.a(var1, var4, od + 5, this.ol += 12, 0);
                     }

                     ++gm;
                  } else if (Char.getMyChar().ca.a <= var10) {
                     var4 = "- " + Char.getMyChar().ca.e[var8];
                     var9 = mFont.k;
                     if (!var7) {
                        var7 = true;
                        var9 = mFont.j;
                     }

                     var9.a(var1, var4, od + 5, this.ol, 0);
                  }
               }

               this.ol += 5;

               for(var10 = 0; var10 < Char.getMyChar().ca.d.length; ++var10) {
                  mFont.i.a(var1, Char.getMyChar().ca.d[var10], od, this.ol += 12, 0);
                  ++gm;
               }
            } else {
               var8 = ae();
               var10 = af();
               String var5 = null;
               if (var8 != -3 && var10 != -3) {
                  if (Char.getMyChar().ca == null && Char.getMyChar().ctaskId == 9 && Char.getMyChar().nClass.a == 0) {
                     var5 = TextGame.nf;
                  } else {
                     if (var10 < 0 || var8 < 0) {
                        return;
                     }

                     var5 = TextGame.nd[0] + Npc.arrNpcTemplate[var10].name + TextGame.nd[1] + TileMap.u[var8] + TextGame.nd[2];
                  }
               } else {
                  var5 = TextGame.nd[3];
               }

               String[] var6 = mFont.i.b(var5, 150);

               for(var2 = 0; var2 < var6.length; ++var2) {
                  if (var2 == 0) {
                     mFont.i.a(var1, var6[var2], od + 5, this.ol = oe, 0);
                  } else {
                     mFont.i.a(var1, var6[var2], od + 5, this.ol += 12, 0);
                  }

                  ++gm;
               }
            }

            if (indexTitle == 1 && av >= 0 && gm > 0) {
               SmallImage.a(var1, 942, od - 8, oe + 2 + av * 12, 0, StaticObj.b);
            }

            ba.a(gm, 12, fe, fd + 32, ff, fg - 44, true, 1);
            return;
         }

         if (aw == 1) {
            this.ol = oe - 12;
            ba.a(Char.getMyChar().dw.size(), 12, fe, fd + 32, ff, fg - 44, true, 1);
            ba.a(var1);
            gm = 0;

            for(var2 = 0; var2 < Char.getMyChar().dw.size(); ++var2) {
               TaskOrder var3 = (TaskOrder)Char.getMyChar().dw.elementAt(var2);
               mFont.e.a(var1, var3.d, od + 5, this.ol += 12, 0);
               var4 = "";
               if (var3.a != 0 && var3.a != 3) {
                  if (var3.a == 1) {
                     var4 = TextGame.hd + " " + Mob.b[var3.f].g;
                  } else if (var3.a == 2) {
                     var4 = TextGame.qp;
                  } else if (var3.a == 4) {
                     var4 = TextGame.he + " " + Mob.b[var3.f].g;
                  } else if (var3.a == 5) {
                     var4 = TextGame.hf + " " + Mob.b[var3.f].g;
                  } else if (var3.a == 6) {
                     var4 = TextGame.hg;
                  }
               } else {
                  var4 = TextGame.hc + " " + Mob.b[var3.f].g;
               }

               if (var3.a == 6) {
                  if (var3.b == var3.c) {
                     mFont.i.a(var1, var4, od + 5, this.ol += 12, 0);
                  } else {
                     mFont.j.a(var1, var4, od + 5, this.ol += 12, 0);
                  }
               } else if (var3.b == var3.c) {
                  mFont.i.a(var1, var4 + " " + var3.b + "/" + var3.c, od + 5, this.ol += 12, 0);
               } else {
                  mFont.j.a(var1, var4 + " " + var3.b + "/" + var3.c, od + 5, this.ol += 12, 0);
               }

               gm += 3;
               os = ff - 25;
               this.a(var1, mFont.i, (String)var3.e, od + 5, this.ol += 12, 0);
               this.ol += 12;
            }

            if (this.em > 0) {
               mFont.i.a(var1, TextGame.e, od + 5, this.ol += 12, 0);
               switch (this.em) {
                  case 1:
                     mFont.i.a(var1, TextGame.f, od + 5, this.ol += 12, 0);
                     break;
                  case 2:
                     mFont.i.a(var1, TextGame.g, od + 5, this.ol += 12, 0);
                     break;
                  case 3:
                     mFont.i.a(var1, TextGame.h, od + 5, this.ol += 12, 0);
                     break;
                  case 4:
                     mFont.i.a(var1, TextGame.i, od + 5, this.ol += 12, 0);
                     break;
                  case 5:
                     mFont.i.a(var1, TextGame.j, od + 5, this.ol += 12, 0);
                     break;
                  case 6:
                     mFont.i.a(var1, TextGame.k, od + 5, this.ol += 12, 0);
                     break;
                  case 7:
                     mFont.i.a(var1, TextGame.l, od + 5, this.ol += 12, 0);
                     break;
                  case 8:
                     mFont.i.a(var1, TextGame.m, od + 5, this.ol += 12, 0);
               }
            }

            if (indexTitle == 1 && av >= 0 && gm > 0) {
               SmallImage.a(var1, 942, od - 8, oe + 2 + av * 12, 0, StaticObj.b);
            }

            ++gm;
            ba.a(gm, 12, fe, fd + 32, ff, fg - 44, true, 1);
         }
      }

   }

   private static String[] a(mFont var0, String var1) {
      return var0.b(var1, ff - 20);
   }

   private void a(mGraphics var1, mFont var2, String[] var3, int var4, int var5, int var6) {
      var6 = var5;

      for(int var7 = 0; var7 < var3.length; ++var7) {
         String var8;
         if ((var8 = var3[var7]).startsWith("c")) {
            if (var8.startsWith("c0")) {
               var8 = var8.substring(2);
               var2 = mFont.i;
            } else if (var8.startsWith("c1")) {
               var8 = var8.substring(2);
               var2 = mFont.j;
            } else if (var8.startsWith("c2")) {
               var8 = var8.substring(2);
               var2 = mFont.n;
            }
         }

         if (var7 == 0) {
            var2.a(var1, var8, var4, var5, 0);
         } else {
            if (var7 * ba.h + var6 >= ba.b - 12 && var7 * ba.h < ba.b + fg - 44) {
               var5 += 12;
               var2.a(var1, var8, var4, var5, 0);
            } else {
               var5 += 12;
            }

            this.ol += 12;
            ++gm;
         }
      }

   }

   private void a(mGraphics var1, mFont var2, String var3, int var4, int var5, int var6) {
      try {
         int var7 = GameCanvas.g && GameCanvas.aa >= 320 ? 20 : 10;
         String[] var10 = var2.b(var3, os - var7);

         for(var7 = 0; var7 < var10.length; ++var7) {
            if (var7 == 0) {
               var2.a(var1, var10[var7], var4, var5, var6);
            } else {
               // [WRAP-FIX] always draw subsequent lines; visibility clipped by go.a() scroll around info panel.
               // Cũ: check ba.h/ba.b (grid scroll) -> line 2 bị skip khi user scroll grid -> mất "+16".
               var5 += 12;
               var2.a(var1, var10[var7], var4, var5, var6);
               this.ol += 12;
               ++gm;
            }
         }
      } catch (Exception var11) {
         ;
      }

   }

   private void a(mGraphics var1, mFont var2, String var3, int var4, int var5, int var6, int var7) {
      var6 = var5;
      String[] var8 = var2.b(var3, var7);

      for(var7 = 0; var7 < var8.length; ++var7) {
         if (var7 == 0) {
            var2.a(var1, var8[var7], var4, var5, 0);
         } else {
            if (var7 * ba.h + var6 >= ba.b - 12 && var7 * ba.h < ba.b + fg - 44) {
               String var10002 = var8[var7];
               var5 += 12;
               var2.a(var1, var10002, var4, var5, 0);
               this.ol += 12;
            } else {
               var5 += 12;
            }

            ++gm;
         }
      }

   }

   private void am(mGraphics var1) {
      if (GameCanvas.j && !cj() && (ci() || cg() || aa())) {
         cu();
         an(var1);
         b(var1);
         this.a(var1, mFont.i, (String)TextGame.dq, oq + os / 2, or + ot / 2 - 20, 2);
      }

      if (cq && this.gn != null && this.gn.template != null) {
         Item var2 = this.gn;
         if (gq && !this.gn.p() && aw == 0) {
            var2 = this.gn.a(this.gn.upgrade + 1);
         }

         if (hx && aw == 0 && indexTitle == 1 && var2.b() && var2.upgrade == 0 && ce[0] != null && ce[0].template.type == ce[1].template.type && ce[1].template.level >= ce[0].template.level) {
            var2 = this.gn.a(ce[0].upgrade);
         }

         b(var1);
         int var3;
         int var4;
         if (var2.expires != 0L && var2.options != null && var2.options.size() > 0) {
            for(var4 = 0; var4 < var2.options.size(); ++var4) {
               if ((var3 = ((ItemOption)var2.options.elementAt(var4)).a().length() * 5) > os && !GameCanvas.j) {
                  os = var3;
               }
            }
         }

         if ((var3 = mFont.e.a(var2.template.name) + 10) > os && !GameCanvas.j) {
            os = var3;
         }

         if (os > GameCanvas.aa - 4) {
            os = GameCanvas.aa - 4;
         }

         if (ot > GameCanvas.ab - 4) {
            os = GameCanvas.ab - 4;
         }

         oq = i / 2 - os / 2;
         or = j / 2 - ot / 2;
         cu();
         if (oq < 2) {
            oq = 2;
         }

         if (or < 2) {
            or = 2;
         }

         an(var1);
         if (ie && aw == 0) {
            if (Char.be != null) {
               this.ol = or - 9;
               gm = 2;
               go.a(var1, oq, or + 2, os, ot - 2);
               os = mFont.i.a(TextGame.qy[Char.be.e][1]) + 10;

               for(var4 = 0; var4 < 2; ++var4) {
                  mFont.i.a(var1, TextGame.qy[Char.be.e][var4], oq + 8, this.ol += 12, 0);
               }

               if (av >= 0 && (!GameCanvas.g || GameCanvas.g && GameCanvas.aa < 320)) {
                  SmallImage.a(var1, 942, oq + 1, or + 5 + av * 12, 0, StaticObj.b);
               }

               go.a(gm, 12, oq, or + 2, os, ot - 4, true, 1);
            }
         } else {
            go.a(var1, oq, or + 2, os, ot - 2);
            gm = 3;
            this.ol = or + 3;
            // [ITEM-FONT-UNIFY] split layout (cq=true) luôn dùng font nhỏ, đồng bộ aw==4 (Trang bị).
            // Trước: aw != 4 dùng mFont.e/b/f/d/a (to) -> overflow + cắt tên trong panel hẹp.
            mFont var9 = mFont.i;
            if (var2.c()) {
               if (var2.sys >= 1 && var2.sys < 4) {
                  var9 = mFont.m;
               } else if (var2.sys >= 4 && var2.sys < 8) {
                  var9 = mFont.n;
               } else if (var2.sys >= 8 && var2.sys < 12) {
                  var9 = mFont.j;
               } else if (var2.sys >= 12 && var2.sys < 15) {
                  var9 = mFont.c;
               } else if (var2.sys >= 15) {
                  var9 = mFont.l;
               }
            } else if (var2.upgrade >= 1 && var2.upgrade < 4) {
               var9 = mFont.m;
            } else if (var2.upgrade >= 4 && var2.upgrade < 8) {
               var9 = mFont.n;
            } else if (var2.upgrade >= 8 && var2.upgrade < 12) {
               var9 = mFont.j;
            } else if (var2.upgrade >= 12 && var2.upgrade < 15) {
               var9 = mFont.c;
            } else if (var2.upgrade >= 15) {
               var9 = mFont.l;
            }

            if (DebugLog.DEBUG) {
               ;
            }

            if (var2.img != null) {
               var1.a(var2.img, 0, 0, mGraphics.a(var2.img), mGraphics.b(var2.img), 0, oq + os / 2, this.ol + ot - 10, 33);
            }

            if (var2.c()) {
               this.a(var1, var9, (String)(var2.template.name + " + " + (var2.sys + 1)), oq + 8, this.ol, 0);
            } else {
               this.a(var1, var9, (String)(var2.template.name + (var2.upgrade > 0 ? " +" + var2.upgrade : "")), oq + 8, this.ol, 0);
            }

            int var5;
            if (!var2.b()) {
               if (var2.c()) {
                  this.ol += 12;
                  var5 = var2.sys + 1;

                  for(var4 = 0; var4 < var5; ++var4) {
                     SmallImage.a(var1, 633, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                  }
               }
            } else {
               this.ol += 12;
               ++gm;
               if (gt && GameCanvas.w % 5 == 0) {
                  gt = !gt;
               } else if (!gt && GameCanvas.w % 5 == 0) {
                  gt = !gt;
               }

               var5 = var2.upgrade / 2 + 1;
               if (var2.upgrade == 0) {
                  for(var4 = 0; var4 < var5; ++var4) {
                     SmallImage.a(var1, 633, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                  }
               } else if (var2.upgrade >= 1 && var2.upgrade < 4) {
                  for(var4 = 0; var4 < var5; ++var4) {
                     SmallImage.a(var1, 625, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                  }

                  if (var2.upgrade == 3) {
                     SmallImage.a(var1, 635, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                  }
               } else if (var2.upgrade >= 4 && var2.upgrade < 8) {
                  for(var4 = 0; var4 < var5; ++var4) {
                     SmallImage.a(var1, 626, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                  }

                  if (var2.upgrade % 2 != 0) {
                     SmallImage.a(var1, 636, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                  }
               } else if (var2.upgrade >= 8 && var2.upgrade < 12) {
                  for(var4 = 0; var4 < var5; ++var4) {
                     if (gt) {
                        SmallImage.a(var1, 627, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                     } else {
                        SmallImage.a(var1, 628, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                     }
                  }

                  if (var2.upgrade % 2 != 0) {
                     if (gt) {
                        SmallImage.a(var1, 637, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                     } else {
                        SmallImage.a(var1, 638, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                     }
                  }
               } else if (var2.upgrade >= 12 && var2.upgrade < 15) {
                  for(var4 = 0; var4 < var5; ++var4) {
                     if (gt) {
                        SmallImage.a(var1, 629, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                     } else {
                        SmallImage.a(var1, 630, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                     }
                  }

                  if (var2.upgrade % 2 != 0) {
                     if (gt) {
                        SmallImage.a(var1, 639, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                     } else {
                        SmallImage.a(var1, 640, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                     }
                  }
               } else {
                  for(var4 = 0; var4 < var5; ++var4) {
                     if (gt) {
                        SmallImage.a(var1, 631, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                     } else {
                        SmallImage.a(var1, 632, oq + 12 + var4 * 10, this.ol + 5, 0, StaticObj.g);
                     }
                  }

                  if (var2.upgrade % 2 != 0) {
                     if (gt) {
                        SmallImage.a(var1, 641, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                     } else {
                        SmallImage.a(var1, 642, oq + 12 + var5 * 10, this.ol + 5, 0, StaticObj.g);
                     }
                  }
               }
            }

            mFont.i.a(var1, var2.isLock ? TextGame.hb : TextGame.hh, oq + 8, this.ol += 12, 0);
            String var10;
            if ((var2.b() || var2.c()) && (var10 = var2.template.type == 12 ? TextGame.en : (var2.template.level >= 10 && var2.template.type < 10 ? (var2.upgrade == 0 ? TextGame.el : null) : TextGame.em)) != null) {
               this.a(var1, mFont.i, (String)var10, oq + 8, this.ol += 12, 0);
               ++gm;
            }

            if (var2.template.gender == 0 || var2.template.gender == 1) {
               if (var2.template.gender == Char.getMyChar().cgender) {
                  mFont.i.a(var1, TextGame.mb[var2.template.gender], oq + 8, this.ol += 12, 0);
                  ++gm;
               } else {
                  mFont.l.a(var1, TextGame.mb[var2.template.gender], oq + 8, this.ol += 12, 0);
                  ++gm;
               }
            }

            if (Char.getMyChar().cLevel != -1) {
               if (Char.getMyChar().cLevel >= var2.template.level) {
                  this.a(var1, mFont.i, (String)(TextGame.hu + " " + var2.template.level), oq + 8, this.ol += 12, 0);
               } else {
                  this.a(var1, mFont.l, (String)(TextGame.hu + " " + var2.template.level), oq + 8, this.ol += 12, 0);
               }
            }

            boolean var11;
            if ((var2.template.id < 40 || var2.template.id > 48) && var2.template.id != 311 && var2.template.id != 375 && var2.template.id != 397 && var2.template.id != 552 && var2.template.id != 558) {
               if ((var2.template.id < 49 || var2.template.id > 57) && var2.template.id != 312 && var2.template.id != 376 && var2.template.id != 398 && var2.template.id != 553 && var2.template.id != 559) {
                  if ((var2.template.id < 58 || var2.template.id > 66) && var2.template.id != 313 && var2.template.id != 377 && var2.template.id != 399 && var2.template.id != 554 && var2.template.id != 560) {
                     if ((var2.template.id < 67 || var2.template.id > 75) && var2.template.id != 314 && var2.template.id != 378 && var2.template.id != 400 && var2.template.id != 555 && var2.template.id != 561) {
                        if ((var2.template.id < 76 || var2.template.id > 84) && var2.template.id != 315 && var2.template.id != 379 && var2.template.id != 401 && var2.template.id != 556 && var2.template.id != 562) {
                           if (var2.template.id >= 85 && var2.template.id <= 93 || var2.template.id == 316 || var2.template.id == 380 || var2.template.id == 402 || var2.template.id == 557 || var2.template.id == 563) {
                              var11 = false;
                              if (Char.getMyChar().nClass.a == 6) {
                                 mFont.i.a(var1, TextGame.hv + " " + nClasss[6].b, oq + 8, this.ol += 12, 0);
                              } else {
                                 mFont.l.a(var1, TextGame.hv + " " + nClasss[6].b, oq + 8, this.ol += 12, 0);
                              }

                              ++gm;
                           }
                        } else {
                           var11 = false;
                           if (Char.getMyChar().nClass.a == 5) {
                              mFont.i.a(var1, TextGame.hv + " " + nClasss[5].b, oq + 8, this.ol += 12, 0);
                           } else {
                              mFont.l.a(var1, TextGame.hv + " " + nClasss[5].b, oq + 8, this.ol += 12, 0);
                           }

                           ++gm;
                        }
                     } else {
                        var11 = false;
                        if (Char.getMyChar().nClass.a == 4) {
                           mFont.i.a(var1, TextGame.hv + " " + nClasss[4].b, oq + 8, this.ol += 12, 0);
                        } else {
                           mFont.l.a(var1, TextGame.hv + " " + nClasss[4].b, oq + 8, this.ol += 12, 0);
                        }

                        ++gm;
                     }
                  } else {
                     var11 = false;
                     if (Char.getMyChar().nClass.a == 3) {
                        mFont.i.a(var1, TextGame.hv + " " + nClasss[3].b, oq + 8, this.ol += 12, 0);
                     } else {
                        mFont.l.a(var1, TextGame.hv + " " + nClasss[3].b, oq + 8, this.ol += 12, 0);
                     }

                     ++gm;
                  }
               } else {
                  var11 = false;
                  if (Char.getMyChar().nClass.a == 2) {
                     mFont.i.a(var1, TextGame.hv + " " + nClasss[2].b, oq + 8, this.ol += 12, 0);
                  } else {
                     mFont.l.a(var1, TextGame.hv + " " + nClasss[2].b, oq + 8, this.ol += 12, 0);
                  }

                  ++gm;
               }
            } else {
               var11 = false;
               if (Char.getMyChar().nClass.a == 1) {
                  mFont.i.a(var1, TextGame.hv + " " + nClasss[1].b, oq + 8, this.ol += 12, 0);
               } else {
                  mFont.l.a(var1, TextGame.hv + " " + nClasss[1].b, oq + 8, this.ol += 12, 0);
               }

               ++gm;
            }

            if (!var2.c()) {
               if (var2.template.id == 420) {
                  if (Char.getMyChar().nClass.a != 1 && Char.getMyChar().nClass.a != 2) {
                     mFont.l.a(var1, TextGame.kl[1], oq + 8, this.ol += 12, 0);
                  } else {
                     mFont.i.a(var1, TextGame.kl[1], oq + 8, this.ol += 12, 0);
                  }

                  ++gm;
               } else if (var2.template.id == 421) {
                  if (Char.getMyChar().nClass.a != 3 && Char.getMyChar().nClass.a != 4) {
                     mFont.l.a(var1, TextGame.kl[2], oq + 8, this.ol += 12, 0);
                  } else {
                     mFont.i.a(var1, TextGame.kl[2], oq + 8, this.ol += 12, 0);
                  }

                  ++gm;
               } else if (var2.template.id == 422) {
                  if (Char.getMyChar().nClass.a != 5 && Char.getMyChar().nClass.a != 6) {
                     mFont.l.a(var1, TextGame.kl[3], oq + 8, this.ol += 12, 0);
                  } else {
                     mFont.i.a(var1, TextGame.kl[3], oq + 8, this.ol += 12, 0);
                  }

                  ++gm;
               }
            }

            if (var2.expires > 0L) {
               if (!var2.j() && !var2.k() && !var2.l() && !var2.m() && !var2.n() && !var2.o() && var2.typeUI != 39) {
                  if ((var3 = mFont.g.a(TextGame.hi + ": " + var2.e()) + 10) > os && !GameCanvas.j) {
                     os = var3;
                  }

                  this.a(var1, mFont.j, (String)(TextGame.hi + ": " + var2.e()), oq + 8, this.ol += 12, 0);
               } else {
                  if ((var3 = mFont.g.a(TextGame.hi + ": " + var2.f()) + 10) > os && !GameCanvas.j) {
                     os = var3;
                  }

                  this.a(var1, mFont.j, (String)(TextGame.hi + ": " + var2.f()), oq + 8, this.ol += 12, 0);
               }

               ++gm;
            }

            if (!var2.template.description.equals("")) {
               this.a(var1, mFont.i, (String)var2.template.description, oq + 8, this.ol += 12, 0);
               ++gm;
            }

            if (!var2.h() && var2.typeUI != 37) {
               if (var2.j() || var2.k() || var2.l() || var2.m() || var2.n() || var2.o()) {
                  if (var2.buyCoin > 0) {
                     if (var2.o()) {
                        if ((var3 = mFont.g.a(TextGame.a(TextGame.hl, NinjaUtil.a(String.valueOf(var2.buyCoin)))) + 10) > os && !GameCanvas.j) {
                           os = var3;
                        }

                        mFont.j.a(var1, TextGame.a(TextGame.hl, NinjaUtil.a(String.valueOf(var2.buyCoin))), oq + 8, this.ol += 12, 0);
                     } else {
                        mFont.j.a(var1, TextGame.a(TextGame.hk, NinjaUtil.a(String.valueOf(var2.buyCoin))), oq + 8, this.ol += 12, 0);
                     }

                     ++gm;
                  } else if (var2.buyCoinLock > 0) {
                     mFont.j.a(var1, TextGame.a(TextGame.hm, NinjaUtil.a(String.valueOf(var2.buyCoinLock))), oq + 8, this.ol += 12, 0);
                     ++gm;
                  } else if (var2.buyGold > 0) {
                     mFont.j.a(var1, TextGame.a(TextGame.hn, NinjaUtil.a(String.valueOf(var2.buyGold))), oq + 8, this.ol += 12, 0);
                     ++gm;
                  }
               }
            } else {
               mFont.j.a(var1, TextGame.a(TextGame.hj, NinjaUtil.a(String.valueOf(var2.saleCoinLock))), oq + 8, this.ol += 12, 0);
               ++gm;
            }

            if (var2.template.type == 33) {
               mFont.j.a(var1, TextGame.du + ": " + (var2.upgrade + 1), oq + 8, this.ol += 12, 0);
               ++gm;
            }

            if (var2.b() && var2.sys != 0) {
               mFont.h.a(var1, TextGame.kl[var2.sys], oq + 8, this.ol += 12, 0);
               ++gm;
            }

            if (var2.expires != 0L && var2.options != null && var2.options.size() > 0) {
               var11 = false;
               boolean var12 = false;

               for(int var6 = 0; var6 < var2.options.size(); ++var6) {
                  ItemOption var7 = (ItemOption)var2.options.elementAt(var6);
                  if (!var11 && var7.c.c == 2) {
                     var11 = true;
                     String var8 = TextGame.mo[0] + ": ";
                     if (var2.template.type == 1) {
                        var8 = var8 + TextGame.mn[var2.template.type] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 0) {
                        var8 = var8 + TextGame.mn[6] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[5] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 6) {
                        var8 = var8 + TextGame.mn[0] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[5] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 5) {
                        var8 = var8 + TextGame.mn[0] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[6] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 2) {
                        var8 = var8 + TextGame.mn[8] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[7] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 8) {
                        var8 = var8 + TextGame.mn[2] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[7] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 7) {
                        var8 = var8 + TextGame.mn[2] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[8] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 4) {
                        var8 = var8 + TextGame.mn[3] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[9] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 3) {
                        var8 = var8 + TextGame.mn[4] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[9] + "(" + TextGame.mp[this.gn.sys] + ")";
                     } else if (var2.template.type == 9) {
                        var8 = var8 + TextGame.mn[4] + "(" + TextGame.mp[this.gn.sys] + "), " + TextGame.mn[3] + "(" + TextGame.mp[this.gn.sys] + ")";
                     }

                     if ((var3 = mFont.i.a(var8) + 15) > os && !GameCanvas.j) {
                        os = var3;
                     }

                     this.a(var1, mFont.i, (String)var8, oq + 8, this.ol += 12, 0);
                     ++gm;
                  }

                  if (!var12 && var7.c.c > 2 && var7.c.c < 8) {
                     var12 = true;
                     mFont.i.a(var1, TextGame.mo[1], oq + 8, this.ol += 12, 0);
                     ++gm;
                  }

                  if (var7.c.a == 65) {
                     this.a(var1, mFont.m, (String)(var2.template.id == 485 ? NinjaUtil.a(var7.a(), TextGame.ha, TextGame.rw) : var7.a()), oq + 8, this.ol += 12, 0);
                  } else if (var7.c.a == 66) {
                     this.a(var1, mFont.h, (String)(var2.template.id == 485 ? NinjaUtil.a(var7.a(), TextGame.rg, TextGame.rx) : var7.a()), oq + 8, this.ol += 12, 0);
                  } else if (var7.c.c == 0) {
                     this.a(var1, mFont.h, (String)(var2.i() ? var7.b() : var7.a()), oq + 8, this.ol += 12, 0);
                  } else if (var7.c.c == 1) {
                     this.a(var1, mFont.n, (String)(var2.i() ? var7.b() : var7.a()), oq + 8, this.ol += 12, 0);
                  } else if (var7.c.c == 8) {
                     if (var7.c.a == 85) {
                        this.a(var1, mFont.j, (String)(var2.i() ? var7.b() : NinjaUtil.a(var7.c.b, "#", String.valueOf(var7.a))), oq + 8, this.ol += 12, 0);
                     } else {
                        mFont var10002 = mFont.b;
                        var2.i();
                        this.a(var1, var10002, (String)var7.b(), oq + 8, this.ol += 12, 0);
                     }
                  } else if (var7.c.c == 2 && var2.typeUI == 5 && var7.b == 1 || var7.c.c == 3 && var2.upgrade >= 4 || var7.c.c == 4 && var2.upgrade >= 8 || var7.c.c == 5 && var2.upgrade >= 12 || var7.c.c == 6 && var2.upgrade >= 14 || var7.c.c == 7 && var2.upgrade >= 16) {
                     this.a(var1, mFont.n, (String)(var2.i() ? var7.b() : var7.a()), oq + 8, this.ol += 12, 0);
                  } else {
                     this.a(var1, mFont.k, (String)(var2.i() ? var7.b() : var7.a()), oq + 8, this.ol += 12, 0);
                  }

                  ++gm;
               }
            }

            if (ig) {
               if (var2.template.id == 12) {
                  mFont.l.a(var1, NinjaUtil.a(this.en[indexSelect]) + " " + TextGame.kb, oq + 8, this.ol += 12, 0);
               }

               if (var2.template.type >= 0 && var2.template.type <= 9) {
                  mFont.j.a(var1, TextGame.qt, oq + 8, this.ol += 12, 0);
               }

               ++gm;
            }

            if (av >= 0 && (!GameCanvas.g || GameCanvas.g && GameCanvas.aa < 320)) {
               SmallImage.a(var1, 942, oq + 1, or + 5 + av * 12, 0, StaticObj.b);
            }

            go.a(gm, 12, oq, or + 2, os, ot - 4, true, 1);
         }
      } else if (!cq && GameCanvas.aa >= 320 && (cr && (aw == 0 || aw == 4 || aw == 5 || aw == 6 && (qt == 0 || qt == 1 || qt == 2)) || ia && (aw == 0 || aw == 1) || aa() && !ct && !ig && !phong2.isItemDel && !phong2.isItemPick)) {
         b(var1);
         cu();
         if (oq < 2) {
            oq = 2;
         }

         if (or < 2) {
            or = 2;
         }

         an(var1);
         int msgBoxW = os - 18;
         if (msgBoxW < 120) {
            msgBoxW = 120;
         }

         int msgBoxH = 38;
         int msgBoxX = oq + (os - msgBoxW) / 2;
         int msgBoxY = or + ot / 2 - msgBoxH / 2;
         var1.a(10249521);
         var1.b(msgBoxX, msgBoxY, msgBoxW, msgBoxH);
         mFont.i.a(var1, "Chọn vật phẩm để xem", oq + os / 2, msgBoxY + 10, 2);
      }

   }

   private static void an(mGraphics var0) {
      b(var0);
      var0.a(0);
      var0.c(oq - 2, or - 2, os + 5, ot + 5);
      var0.a(13606712);
      var0.b(oq - 1, or - 1, os + 2, ot + 2);
      var0.a(Paint.a);
      var0.c(oq, or, os, ot);
   }

   private static void cu() {
      if (GameCanvas.aa >= 320 && (!ie || aw != 0)) {
         if (javaDocBagLayout()) {
            int var0 = oj * indexSize;
            oq = fe + 3 + var0 + 4;
            or = fd + javaDocBagGridTopOffset();
            os = ff - (oq - fe) - 7;
            if (os < 80) {
               os = 80;
            }

            ot = javaDocBagCurrentRows() * indexSize;
            return;
         }

         oq = fe + 175;
         os = ff - 179;
         or = fd + 33;
         ot = 138;
         if (cs && aw == 0) {
            oq = fe + 6 + 3 * indexSize;
            os = ff - (11 + 6 * indexSize);
         }

         if (cr) {
            if (aw == 4) {
               int gridW = 175;
               oq = fe + gridW + 4;
               or = fd + 33;
               os = ff - gridW - 8;
               ot = fg - 40;
               return;
            }

             if (aw == 5 || aw == 6) {
               ot = 161;
            }
         }
      }

   }

   public final void aj() {
      super.b = null;
      if (indexTitle != 0 || aw != 1 && aw != 3 && aw != 4) {
         SkillTemplate var1;
         Skill var2;
         switch (aw) {
            case 0:
               if (indexTitle != 1) {
                  break;
               }

               if (k(3) == null) {
                  cq = false;
                  super.a = this.ov;
               } else {
                  super.a = this.pa;
                  if (GameCanvas.g && GameCanvas.aa < 320 || !GameCanvas.g) {
                     super.b = this.oz;
                  }

                  if (!GameCanvas.j && (!cq || this.gn != k(3))) {
                     this.showItemInfoSplit(3, k(3));
                  }
               }
               break;
            case 1:
               if (indexTitle != 1) {
                  break;
               }

               super.a = null;
               if (indexSelect < 0) {
                  break;
               }

               var1 = Char.getMyChar().nClass.c[indexSelect];
               if ((var2 = Char.getMyChar().a(var1)) == null) {
                  break;
               }

               if (var2.point < var1.maxPoint) {
                  super.a = new Command1(TextGame.cy, 14001);
               }

               if (var2.template.type != 1 && var2.template.type != 4 && var2.template.type != 2 && var2.template.type != 3) {
                  super.b = null;
                  break;
               }

               super.b = new Command1(TextGame.dr, 11081);
               break;
            case 2:
               if (indexTitle >= 1) {
                  super.a = new Command1(TextGame.cy, 11084);
                  super.b = new Command1("", 11084);
               }
               break;
            case 3:
               super.a = null;
               if (GameCanvas.aa < 320) {
                  super.b = new Command1(TextGame.fa, 110854);
               }
               break;
            case 4:
               if (indexTitle == 1) {
                  super.a = null;
                  Item var3;
                  if ((var3 = k(5)) != null) {
                     if (currentCharViewInfo.idChar == Char.getMyChar().idChar) {
                        super.a = new Command1(TextGame.doa, 11082);
                        if (GameCanvas.j) {
                           this.a((int)5, (Item)var3);
                        } else {
                           if (!cq || this.gn != var3) {
                              this.showItemInfoSplit(5, var3);
                           }
                        }
                     } else if (GameCanvas.j) {
                        this.a((int)5, (Item)var3);
                     } else {
                        if (!cq || this.gn != var3) {
                           this.showItemInfoSplit(5, var3);
                        }
                     }
                  } else {
                     cq = false;
                     if (!GameCanvas.g && mj > 0) {
                        super.a = new Command1(TextGame.si, 2003);
                     }
                  }
               }
               break;
            case 5:
               super.a = null;
               if (indexTitle == 1 && indexSelect >= 0 && currentCharViewInfo.arrItemMounts[indexSelect] != null) {
                  if (Char.getMyChar().idChar == currentCharViewInfo.idChar) {
                     super.a = new Command1(TextGame.bj, 1516);
                  }

                  if (GameCanvas.j) {
                     super.b = new Command1(TextGame.ax, 1515);
                  }
               }
               break;
            case 6:
               if (qt == 0) {
                  super.a = null;
                  if (indexTitle == 1 && indexSelect >= 0 && currentCharViewInfo.cf[indexSelect] != null) {
                     if (Char.getMyChar().idChar == currentCharViewInfo.idChar) {
                        super.a = new Command1(TextGame.bj, 508);
                     }

                     if (GameCanvas.j) {
                        super.b = new Command1(TextGame.ax, 503);
                     }
                  }
               } else if (qt == 1) {
                  if (indexTitle >= 1) {
                     super.a = new Command1(TextGame.cy, 504);
                  }
               } else {
                  if (indexTitle == 1) {
                     super.a = null;
                     if (indexSelect >= 0) {
                        var1 = Char.getMyChar().nClass.c[indexSelect];
                        if ((var2 = Char.getMyChar().a(var1)) != null) {
                           if (var2.point < var1.maxPoint) {
                              super.a = new Command1(TextGame.cy, 14001);
                           }

                           if (var2.template.type != 1 && var2.template.type != 4 && var2.template.type != 2 && var2.template.type != 3) {
                              super.b = null;
                           } else {
                              super.b = new Command1(TextGame.dr, 11081);
                           }
                        }
                     }
                  }

                  if (indexTitle == 1) {
                     super.a = null;
                     if (indexSelect >= 0) {
                        var1 = Char.getMyChar().nClass.c[indexSelect];
                        if ((var2 = Char.getMyChar().a(var1)) != null) {
                           if (var2.point < var1.maxPoint) {
                              super.a = new Command1(TextGame.cy, 505);
                           }

                           super.b = null;
                        }
                     }
                  }
               }
         }

         if (aw != 6 && currentCharViewInfo.idChar == Char.getMyChar().idChar) {
            super.c = new Command1(TextGame.ee, 11086);
         } else {
            super.c = this.ne;
         }
      } else {
         super.a = null;
      }

   }

   public final void doOpenUI(int var1) {
      ;
      indexTitle = 0;
      super.c = this.ne;
      switch (var1) {
         case 2:
            aw = 0;
            hr = true;
            if (bp == null) {
               Service.gI().i(2);
            } else {
               LockGame.notifyDV();
            }
         case 3:
         case 5:
         case 30:
         case 39:
         case 41:
         case 42:
         case 51:
         default:
            break;
         case 4:
            aw = 0;
            ia = true;
            if (Char.getMyChar().arrItemBox == null) {
               Service.gI().i(4);
            }
            break;
         case 6:
            aw = 0;
            hs = true;
            if (bq == null) {
               Service.gI().i(6);
            }
            break;
         case 7:
            aw = 0;
            ht = true;
            if (br == null) {
               Service.gI().i(7);
            }
            break;
         case 8:
            aw = 0;
            hu = true;
            if (bs == null) {
               Service.gI().i(8);
            }
            break;
         case 9:
            aw = 0;
            hv = true;
            if (bt == null) {
               Service.gI().i(9);
            }
            break;
         case 10:
            aw = 0;
            hw = true;
            ca = new Item[18];
            break;
         case 11:
            aw = 0;
            hz = true;
            gp = true;
            bz = new Item[24];
            break;
         case 12:
            aw = 0;
            hz = true;
            gp = false;
            bz = new Item[24];
            break;
         case 13:
            aw = 0;
            ib = true;
            cb = new Item[24];
            break;
         case 14:
            hb = true;
            aw = 0;
            if (bu == null) {
               Service.gI().i(14);
            }
            break;
         case 15:
            hb = true;
            aw = 1;
            if (bx == null) {
               Service.gI().i(15);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 16:
            aw = 0;
            hn = true;
            if (bl == null) {
               Service.gI().i(16);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 17:
            aw = 0;
            ho = true;
            if (bm == null) {
               Service.gI().i(17);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 18:
            aw = 0;
            hp = true;
            if (bn == null) {
               Service.gI().i(18);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 19:
            aw = 0;
            hq = true;
            if (bo == null) {
               Service.gI().i(19);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 20:
            aw = 0;
            hd = true;
            if (bb == null) {
               Service.gI().i(20);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 21:
            aw = 0;
            he = true;
            if (bc == null) {
               Service.gI().i(21);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 22:
            aw = 0;
            hf = true;
            if (bd == null) {
               Service.gI().i(22);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 23:
            aw = 0;
            hg = true;
            if (be == null) {
               Service.gI().i(23);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 24:
            aw = 0;
            hh = true;
            if (bf == null) {
               Service.gI().i(24);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 25:
            aw = 0;
            hi = true;
            if (bg == null) {
               Service.gI().i(25);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 26:
            aw = 0;
            hj = true;
            if (bh == null) {
               Service.gI().i(26);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 27:
            aw = 0;
            hk = true;
            if (bi == null) {
               Service.gI().i(27);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 28:
            aw = 0;
            hl = true;
            if (bj == null) {
               Service.gI().i(28);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 29:
            aw = 0;
            hm = true;
            if (bk == null) {
               Service.gI().i(29);
            } else {
               LockGame.notifyDV();
            }
            break;
         case 31:
            aw = 0;
            hw = true;
            hy = true;
            ca = new Item[18];
            break;
         case 32:
            hb = true;
            aw = 2;
            if (by == null) {
               Service.gI().i(32);
            }
            break;
         case 33:
            aw = 0;
            hx = true;
            ce = new Item[3];
            break;
         case 34:
            hb = true;
            aw = 3;
            if (bw == null) {
               Service.gI().i(34);
            }
            break;
         case 35:
            hc = true;
            aw = 0;
            if (bv == null) {
               Service.gI().i(35);
            }
            break;
         case 36:
            aw = 0;
            cn = true;
            ck = null;
            this.jd = new TField();
            this.jd.b(9);
            this.jd.c(1);
            this.jd.c = 100;
            this.jd.d = mScreen.d + 2;
            break;
         case 37:
            ih = true;
            this.ac();
            break;
         case 38:
            cg = null;
            ig = true;
            indexTitle = 1;
            this.ac();
            break;
         case 40:
            ct = true;
            indexTitle = 1;
            av = 0;
            this.ac();
            break;
         case 43:
            aw = 0;
            ii = true;
            bz = new Item[24];
            break;
         case 44:
            aw = 0;
            ij = true;
            cb = new Item[24];
            break;
         case 45:
            aw = 0;
            ik = true;
            cb = new Item[24];
            break;
         case 46:
            aw = 0;
            il = true;
            cb = new Item[24];
            break;
         case 47:
            aw = 0;
            im = true;
            ca = new Item[18];
            break;
         case 48:
            aw = 0;
            iq = true;
            cb = new Item[18];
            break;
         case 49:
            aw = 0;
            in = true;
            cj = null;
            break;
         case 50:
            aw = 0;
            io = true;
            cj = null;
            break;
         case 52:
            hb = true;
            aw = 52;
            Service.gI().i(52);
            break;
         case 53:
            aw = 0;
            ir = true;
            cb = new Item[24];
      }

      b(175, 200);
      this.qp = new int[9];
      this.qq = new int[9];
      int var3 = fe + 3;
      int var2 = fd + 34 + indexSize;
      this.qp[0] = fe + 74;
      this.qq[0] = var2 + 4;
      this.qp[1] = var3 + 1;
      this.qq[1] = var2 - indexSize;
      this.qp[2] = var3 + ff / 2 - indexSize / 2 - 2;
      this.qq[2] = var2 - indexSize;
      this.qp[3] = this.qp[1];
      this.qp[4] = this.qp[0];
      this.qp[5] = this.qp[2];
      this.qq[3] = this.qq[1] + indexSize * 3 - 2;
      this.qq[4] = this.qq[1] + indexSize * 3 - 2;
      this.qq[5] = this.qq[1] + indexSize * 3 - 2;
      this.qp[6] = this.qp[1];
      this.qp[7] = this.qp[0];
      this.qp[8] = this.qp[2];
      this.qq[6] = this.qq[1] + (indexSize << 2) + 10;
      this.qq[7] = this.qq[1] + (indexSize << 2) + 10;
      this.qq[8] = this.qq[1] + (indexSize << 2) + 10;
   }

   public static Char e(int var0) {
      for(int var1 = 0; var1 < vCharInMap.size(); ++var1) {
         Char var2;
         if ((var2 = (Char)vCharInMap.elementAt(var1)).idChar == var0) {
            return var2;
         }
      }

      return null;
   }

   public static BuNhin f(int var0) {
      return vBuNhin.size() > 0 ? (BuNhin)vBuNhin.elementAt(var0) : null;
   }

   public final void a(String var1, String var2) {
      if (!cu || GameCanvas.g) {
         ChatTextField.a().b = false;
      }

      kg = 5;
      if (!var1.equals("")) {
         if (var2.equals(TextGame.oi[0])) {
            if (!Code.lenhchat(var1)) {
               Service.gI().c(var1);
            }
         } else if (var2.equals(TextGame.oj[0])) {
            if (vParty.size() == 0) {
               ChatManager.d().e().a(TextGame.mf);
            } else {
               Service.gI().j(var1);
            }
         } else if (var2.equals(TextGame.ok[0])) {
            Service.gI().k(var1);
         } else if (var2.equals(TextGame.ol[0])) {
            if (Char.getMyChar().cClanName.equals("")) {
               ChatManager.d().e().a(TextGame.mk);
            } else {
               Service.gI().l(var1);
            }
         } else {
            ChatManager.d().a(var2, Char.getMyChar().displayName(), var1);
            Service.gI().a(var2, var1);
         }

      }

   }

   public final void ak() {
      if (cu) {
         this.ah();
         cu = false;
         ChatTextField.a().f = null;
      }

   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      if (hz || ii || ij || ik || ib || cs || hw || hx || cn || il || ir || im || in || io) {
         int var6 = var3 * indexSize;
         var4 *= indexSize;
         ba.a();
         if (GameCanvas.b(var1, var2, var6, var4)) {
            indexTitle = var5;
            if (GameCanvas.q) {
               if ((var1 = (GameCanvas.u - var1) / indexSize + (GameCanvas.v - var2) / indexSize * var3) / oj < ok) {
                  indexSelect = var1;
               }

               super.a = super.b = null;
               if (cs) {
                  if (indexSelect < 0) {
                     indexSelect = 11;
                  }

                  if (indexSelect > 11) {
                     indexSelect = 11;
                  }
               }

               this.ac();
            }
         }
      }

   }

   public final void b(int var1, Object var2) {
      String var3 = null;
      var3 = null;
      MyVector var4 = null;
      if (!phong2.gI().game_perform(var1, var2)) {
         Member var9;
         Item var10;
         Npc var12;
         ChatTab var14;
         Object[] var15;
         int var16;
         Skill var17;
         Item var20;
         switch (var1) {
            case 1:
               GameCanvas.j();
               return;
            case 2:
               GameCanvas.j();
               super.a = super.b = null;
               this.ac();
               return;
            case 3:
               this.ah();
               return;
            case 222:
               this.hk();
               return;
            case 333:
               this.doOpenUI(47);
               return;
            case 334:
               this.ej();
               return;
            case 335:
               gq = false;
               this.a((int)3, (Item)cj);
               return;
            case 336:
               gq = false;
               this.a((int)3, (Item)ci);
               return;
            case 337:
               this.hl();
               return;
            case 338:
               this.o(0);
               return;
            case 339:
               this.p(0);
               return;
            case 340:
               this.p(1);
               return;
            case 341:
               this.hm();
               return;
            case 342:
               hn();
               return;
            case 343:
               this.p(2);
               return;
            case 344:
               this.o(1);
               return;
            case 345:
               this.o(2);
               return;
            case 400:
               this.hp();
               return;
            case 401:
               this.hq();
               return;
            case 402:
               this.hr();
               return;
            case 403:
               hs();
               return;
            case 405:
               ho();
               return;
            case 500:
               this.ht();
               return;
            case 501:
               Service.gI().c(indexSelect);
               return;
            case 502:
               this.ax();
               return;
            case 503:
               if (GameCanvas.j) {
                  this.a((int)51, (Item)currentCharViewInfo.cf[indexSelect]);
               } else {
                  this.showItemInfoSplit(51, currentCharViewInfo.cf[indexSelect]);
               }
               return;
            case 504:
               hu();
               return;
            case 505:
               hx();
               return;
            case 508:
               Service.gI().as(indexSelect);
               return;
            case 999:
               this.doOpenUI(35);
               return;
            case 1000:
               Service.gI().af();
               this.v();
               return;
            case 1500:
               (var4 = new MyVector()).addElement(new Command1(TextGame.bj, 15001));
               if (Char.getMyChar().xu >= 5000) {
                  var4.addElement(new Command1(TextGame.bo, 15002));
               }

               GameCanvas.af.a(var4);
               return;
            case 1501:
               this.a((int)3, (Item)ck);
               return;
            case 1502:
               this.jd.a();
               return;
            case 1503:
               dd();
               return;
            case 1504:
               db();
               return;
            case 1505:
               this.a((int)3, (Item)cf[indexSelect].a);
               return;
            case 1506:
               if (cg != null) {
                  this.el = 0;
                  cq = false;
                  ax = -1;
                  cg = null;
                  gI().a = new Command1(TextGame.doa, 1506);
                  return;
               }

               ax = indexSelect;
               Service.gI().selectCard();
               GameCanvas.l();
               return;
            case 1507:
               this.cy();
               return;
            case 1508:
               var4 = new MyVector();
               if ((var20 = Char.be.p[indexSelect]) != null) {
                  if (var20.template.id == 281) {
                     var4.addElement(new Command1(TextGame.bc, 15081));
                  } else {
                     var4.addElement(new Command1(TextGame.ml, 15082));
                  }

                  GameCanvas.af.a(var4);
                  return;
               }
               break;
            case 1509:
               if (indexSelect >= 0 && Char.be != null) {
                  this.a((int)39, (Item)Char.be.p[indexSelect]);
                  return;
               }

               cq = false;
               return;
            case 1510:
               cx();
               return;
            case 1511:
               var3 = GameCanvas.al.a.d();
               GameCanvas.j();

               try {
                  if (var3.equals("")) {
                     GameCanvas.a(TextGame.pz);
                     return;
                  }

                  if ((var16 = Integer.parseInt(var3)) >= 10 && var16 <= 90) {
                     Char.ds = var16;
                     return;
                  }

                  GameCanvas.a(TextGame.pz);
                  return;
               } catch (Exception var23) {
                  GameCanvas.a(TextGame.pz);
                  return;
               }
            case 1512:
               var3 = GameCanvas.al.a.d();
               GameCanvas.j();

               try {
                  if (var3.equals("")) {
                     GameCanvas.a(TextGame.pz);
                     return;
                  }

                  if ((var16 = Integer.parseInt(var3)) >= 10 && var16 <= 90) {
                     Char.dt = var16;
                     return;
                  }

                  GameCanvas.a(TextGame.pz);
                  return;
               } catch (Exception var22) {
                  GameCanvas.a(TextGame.pz);
                  return;
               }
            case 1515:
               if (GameCanvas.j) {
                  this.a((int)41, (Item)currentCharViewInfo.arrItemMounts[indexSelect]);
               } else {
                  this.showItemInfoSplit(41, currentCharViewInfo.arrItemMounts[indexSelect]);
               }
               return;
            case 1516:
               Service.gI().c(indexSelect);
               return;
            case 1600:
               cr();
               return;
            case 1601:
               ef();
               return;
            case 1602:
               var20 = k(43);
               this.a((int)3, (Item)var20);
               return;
            case 1603:
               this.ec();
               return;
            case 1604:
               var4 = new MyVector();
               if (cb[indexSelect] != null) {
                  var4.addElement(new Command1(TextGame.bj, 1605));
               }

               var4.addElement(new Command1(TextGame.ev, 11105));
               GameCanvas.af.a(var4);
               return;
            case 1605:
               this.cw();
               return;
            case 1606:
               this.cv();
               return;
            case 1700:
               this.hg();
               return;
            case 1701:
               hh();
               return;
            case 1702:
               this.hi();
               return;
            case 2000:
               Service.gI().ag();
               this.v();
               return;
            case 2001:
               Service.gI().r(indexSelect);
               return;
            case 2002:
               GameCanvas.j();
               return;
            case 2003:
               if (mj == 0) {
                  mj = 16;
                  this.gg.a = TextGame.si;
                  return;
               }

               mj = 0;
               this.gg.a = TextGame.sj;
               if (!GameCanvas.g) {
                  super.a = new Command1(TextGame.doa, 11082);
                  return;
               }
               break;
            case 2004:
               return;
            case 5021:
               this.ay();
               return;
            case 5022:
               this.az();
               return;
            case 5041:
               Service.gI().e(indexTitle - 1, 1);
               this.aj();
               return;
            case 5042:
               this.hv();
               return;
            case 5043:
               hw();
               return;
            case 5051:
               Service.gI().f(Char.getMyChar().nClass.c[indexSelect].id, 1);
               this.aj();
               return;
            case 5052:
               this.hy();
               return;
            case 5053:
               hz();
               break;
            case 9999:
               this.doOpenUI(37);
               return;
            case 11000:
               bh();
               return;
            case 11001:
               Char.getMyChar().u();
               return;
            case 11002:
               he();
               return;
            case 11003:
               hd();
               return;
            case 11004:
               this.d((byte)25);
               return;
            case 11005:
               hb();
               return;
            case 11006:
               hc();
               return;
            case 11007:
               this.d((byte)24);
               return;
            case 11008:
               ha();
               return;
            case 11009:
               this.d((byte)23);
               return;
            case 11010:
               gz();
               return;
            case 11011:
               this.d((byte)22);
               return;
            case 11012:
               gy();
               return;
            case 11013:
               this.d((byte)21);
               return;
            case 11014:
               gx();
               return;
            case 11015:
               this.d((byte)20);
               return;
            case 11016:
               gw();
               return;
            case 11017:
               this.d((byte)15);
               return;
            case 11018:
               gu();
               return;
            case 11019:
               this.d((byte)14);
               return;
            case 11020:
               gt();
               return;
            case 11021:
               fk = "";
               fl = "";
               this.v();
               return;
            case 11022:
               this.gr();
               return;
            case 11023:
               this.gq();
               return;
            case 11024:
               gp();
               return;
            case 11025:
               this.ba();
               return;
            case 11026:
               gn();
               return;
            case 11000807:
               if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                  ;
                  new Thread(new DichChuyenItem(Char.getMyChar().arrItemBag[indexSelect])).start();
               }
               return;
            case 11000792: {
               Item itLN = k(3);
               if (itLN != null) {
                  Code.addLuyenNgoc(itLN);
                  Code.popup_chat("Da them vao ds luyen ngoc");
                  ;
               }
               return;
            }
            case 11000793: {
               Item itLN = k(3);
               if (itLN != null) {
                  Code.removeLuyenNgoc(itLN);
                  Code.popup_chat("Da bo luyen ngoc");
                  ;
               }
               return;
            }
            case 11027:
               this.gm();
               return;
            case 11028:
               this.gl();
               return;
            case 11029:
               this.gk();
               return;
            case 11030:
               this.gj();
               return;
            case 11032:
               this.gi();
               return;
            case 11033:
               this.gh();
               return;
            case 11034:
               this.gf();
               return;
            case 11035:
               this.ge();
               return;
            case 11036:
               cl();
               return;
            case 11037:
               this.gd();
               return;
            case 11038:
               gb();
               return;
            case 11040:
               this.fy();
               return;
            case 11041:
               this.fx();
               return;
            case 11042:
               fu();
               return;
            case 11043:
               fs();
               return;
            case 11044:
               dj();
               return;
            case 11045:
               dp();
               return;
            case 11046:
               doa();
               return;
            case 11047:
               dl();
               return;
            case 11048:
               fo();
               return;
            case 11049:
               ck();
               return;
            case 11050:
               cm();
               return;
            case 11051:
               fn();
               return;
            case 11052:
               var10 = (Item)var2;
               Service.gI().h(var10.indexUI, GameCanvas.af.b);
               return;
            case 11053:
               g(var10 = (Item)var2);
               return;
            case 11054:
               this.fh();
               return;
            case 11055:
               f(var10 = (Item)var2);
               return;
            case 11057:
               Npc var22 = (Npc)var2;
               Service.gI().b(var22.npcTemplate.npcTemplateId, GameCanvas.af.b, -1);
               return;
            case 11058:
               var10 = (Item)var2;
               GameCanvas.j();
               Service.gI().g(var10.indexUI, Integer.parseInt(GameCanvas.al.a.d()));
               return;
            case 11059:
               this.fg();
               return;
            case 11060:
               this.ff();
               return;
            case 11061:
               d(var10 = (Item)var2);
               return;
            case 11062:
               cq();
               return;
            case 11063:
               fe();
               return;
            case 11064:
               Service.gI().e(indexTitle - 1, 1);
               this.aj();
               return;
            case 11065:
               this.bb();
               return;
            case 11066:
               this.ah();
               cu = false;
               cm = false;
               ChatTextField.a().f = null;
               return;
            case 11067:
               if (TileMap.zoneID != indexSelect) {
                  Service.gI().a(indexSelect, this.iz);
                  id = false;
                  return;
               }

               InfoMe.a(TextGame.nc);
               id = false;
               return;
            case 11068:
               var3 = (String)var2;
               this.f(var3);
               return;
            case 11069:
               this.fd();
               return;
            case 11070:
               Party var21;
               a(var21 = (Party)var2);
               return;
            case 11071:
               Service.gI().t();
               return;
            case 11072:
               fc();
               return;
            case 11073:
               b(Char.getMyChar().arrItemBag[indexSelect]);
               return;
            case 11074:
               MyVector var18;
               short var11 = Short.parseShort(String.valueOf((var18 = (MyVector)var2).elementAt(0)));
               String var19 = String.valueOf(var18.elementAt(1));
               this.a(var11, var19);
               return;
            case 11075:
               this.fb();
               return;
            case 11076:
               var3 = (String)var2;
               Service.gI().f(var3);
               return;
            case 11077:
               e(var3 = (String)var2);
               return;
            case 11078:
               fa();
               return;
            case 11079:
               ey();
               return;
            case 11080:
               c(var3 = (String)var2);
               return;
            case 11081:
               ew();
               return;
            case 11082:
               ev();
               return;
            case 11083:
               this.d((byte)5);
               return;
            case 11084:
               eu();
               return;
            case 11085:
               et();
               return;
            case 11086:
               this.es();
               return;
            case 11087:
               var10 = (Item)var2;
               GameCanvas.j();
               Service.gI().a(var10);
               return;
            case 11088:
               this.d((byte)26);
               return;
            case 11089:
               this.d((byte)27);
               return;
            case 11090:
               this.d((byte)28);
               return;
            case 11091:
               this.d((byte)29);
               return;
            case 11092:
               c(var10 = (Item)var2);
               return;
            case 11093:
               this.d((byte)2);
               return;
            case 11094:
               this.d((byte)6);
               return;
            case 11095:
               this.d((byte)7);
               return;
            case 11096:
               this.d((byte)8);
               return;
            case 11097:
               this.d((byte)9);
               return;
            case 11098:
               this.eq();
               return;
            case 11099:
               gq = false;
               this.a((int)3, (Item)ci);
               return;
            case 11100:
               eo();
               return;
            case 11101:
               var20 = k(10);
               this.a((int)3, (Item)var20);
               return;
            case 11102:
               this.ej();
               return;
            case 11103:
               this.ei();
               return;
            case 11104:
               this.a((int)3, (Item)((Item)var2));
               return;
            case 11105:
               ct();
               return;
            case 11106:
               this.eh();
               return;
            case 11107:
               eg();
               return;
            case 11108:
               this.d((byte)3);
               return;
            case 11109:
               this.ed();
               return;
            case 11110:
               var20 = cd[indexSelect];
               this.a((int)30, (Item)var20);
               return;
            case 11111:
               var20 = k(4);
               this.a((int)4, (Item)var20);
               return;
            case 11112:
               Service.gI().g();
               return;
            case 11113:
               Service.gI().e(Char.getMyChar().arrItemBag[indexSelect].indexUI);
               return;
            case 11114:
               allowShowItemInfo = true;
               this.a((int)3, (Item)Char.getMyChar().arrItemBag[indexSelect]);
               return;
            case 11115:
               eb();
               return;
            case 11116:
               ea();
               return;
            case 11120:
               var17 = (Skill)(var15 = (Object[])((Object[])var2))[0];
               var16 = Integer.parseInt((String)var15[1]);
               jz[var16] = var17;
               ap();
               return;
            case 11121:
               var17 = (Skill)(var15 = (Object[])((Object[])var2))[0];
               var16 = Integer.parseInt((String)var15[1]);
               jy[var16] = var17;
               aq();
               return;
            case 12000:
               this.fm();
               return;
            case 12001:
               ChatManager.d().a((Integer)var2);
               this.fk();
               return;
            case 12002:
            case 12004:
               var3 = (String)var2;
               if ((var14 = ChatManager.d().a(var3)) == null) {
                  ChatManager.d().b(var3);
                  ChatManager.d().c();
               } else {
                  ChatManager.d().a(var14);
               }

               this.fk();
               gx = false;
               ie = false;
               gz = false;
               cp = false;
               gw = false;
               ChatTextField.a().f = null;
               return;
            case 12003:
               this.bm();
               return;
            case 12005:
               this.fl();
               return;
            case 12006:
               fi();
               return;
            case 12007:
               this.pc = 1;
               this.pd = "";
               this.dg();
               return;
            case 12008:
               df();
               return;
            case 12009:
               var3 = (String)var2;
               MyVector var13;
               (var13 = new MyVector()).addElement(new Command1(TextGame.nb[7], 12002, var3));
               var13.addElement(new Command1(TextGame.nx[2], 110803, var3));
               if (gw) {
                  var13.addElement(new Command1(TextGame.nb[6], 110804));
               }

               if (cu) {
                  var13.addElement(new Command1(TextGame.ac, 14020, var3));
                  var13.addElement(new Command1(TextGame.nb[6], 1108041, var3));
               }

               GameCanvas.af.a(var13);
               return;
            case 13001:
               this.d((byte)32);
               return;
            case 13002:
               gv();
               return;
            case 14001:
               ex();
               return;
            case 14002:
               this.dw();
               return;
            case 14003:
               this.dx();
               return;
            case 1400343:
               if (av >= 0 && av < vCharInMap.size()) {
                  Char pl = (Char) vCharInMap.elementAt(av);
                  if (pl != null && pl != Char.getMyChar()) {
                     Char.move(pl.cx1, TileMap.d(pl.cx1, pl.cy1));
                     Char.getMyChar().charFocus = pl;
                     Code.popup_chat("Dịch chuyển tới " + pl.cName);
                  }
               }
               ic = false;
               this.v();
               return;
            case 14004:
               dn();
               return;
            case 14005:
               this.ds();
               return;
            case 14006:
               b(var3 = (String)var2);
               return;
            case 14007:
               dh();
               return;
            case 14008:
               GameCanvas.a(TextGame.kg, new Command1(TextGame.bh, 140081), new Command1(TextGame.bu, 1));
               return;
            case 14009:
               dq();
               return;
            case 14010:
               GameCanvas.al.a(TextGame.pi, new Command1(TextGame.dc, GameCanvas.instance, 88833, (Object)null), 1);
               return;
            case 14011:
               cm = false;
               return;
            case 14012:
               this.ek();
               return;
            case 14013:
               this.ep();
               return;
            case 14014:
               this.gg();
               return;
            case 14015:
               this.em();
               return;
            case 14016:
               this.a((int)3, (Item)ce[indexSelect]);
               return;
            case 14017:
               di();
               return;
            case 14018:
               this.d((byte)34);
               return;
            case 14019:
               de();
               return;
            case 14020:
               if (dt()) {
                  var3 = (String)var2;
                  Service.gI().a((short)1, (String)var3);
                  return;
               }

               GameCanvas.a(TextGame.ov);
               return;
            case 14021:
               ez();
               return;
            case 14022:
               gs();
               return;
            case 14023:
               this.d((byte)35);
               return;
            case 14024:
               this.a((byte)1);
               return;
            case 14025:
               this.a((byte)0);
               return;
            case 15001:
               this.dc();
               return;
            case 15002:
               try {
                  if ((var1 = Integer.parseInt(this.jd.d())) <= 0) {
                     GameCanvas.a(TextGame.pz);
                  }

                  GameCanvas.a(TextGame.a(TextGame.qh, NinjaUtil.a(String.valueOf(var1))), new Command1(TextGame.bh, 150021), new Command1(TextGame.bu, 1));
                  return;
               } catch (Exception var211) {
                  GameCanvas.a(TextGame.pz);
                  return;
               }
            case 15041:
               da();
               return;
            case 15042:
               GameCanvas.a(TextGame.a(TextGame.qi, NinjaUtil.a(String.valueOf(cf[indexSelect].b))), new Command1(TextGame.bh, 150421), new Command1(TextGame.bu, 1));
               return;
            case 15081:
               Service.gI().ai();
               return;
            case 15082:
               GameCanvas.al.a(TextGame.qx, new Command1(TextGame.bx, GameCanvas.instance, 88843, new Integer(indexSelect)), 0);
               return;
            case 15130:
               Char.du = 1;
               return;
            case 15131:
               Char.du = 10;
               return;
            case 15132:
               Char.du = 20;
               return;
            case 15133:
               Char.du = 30;
               return;
            case 15134:
               Char.du = 40;
               return;
            case 15135:
               Char.du = 50;
               return;
            case 15136:
               Char.du = 60;
               return;
            case 15137:
               Char.du = 70;
               return;
            case 15138:
               Char.du = 90;
               return;
            case 110001:
              this.bf();
               return;
            case 110002:
               bo();
               return;
            case 110003:
               bg();
               return;
            case 110004:
               ga();
               return;
            case 110005:
               this.doOpenUI(14);
               return;
            case 110006:
               fw();
               return;
            case 110007:
               this.doOpenUI(7);
               return;
            case 110008:
               this.doOpenUI(6);
               return;
            case 110009:
               this.doOpenUI(9);
               return;
            case 110010:
               this.doOpenUI(8);
               return;
            case 110011:
               this.doOpenUI(10);
               return;
            case 110012:
               this.doOpenUI(11);
               return;
            case 110013:
               this.doOpenUI(12);
               return;
            case 110014:
               this.doOpenUI(4);
               return;
            case 110015:
               this.doOpenUI(13);
               return;
            case 110016:
               Service.gI().e();
               return;
            case 110017:
               this.u();
               return;
            case 110018:
               fj();
               return;
            case 110019:
               this.dy();
               return;
            case 110051:
               b((byte)25);
               return;
            case 110052:
               this.c((byte)25);
               return;
            case 110081:
               b((byte)24);
               return;
            case 110082:
               this.c((byte)24);
               return;
            case 110101:
               b((byte)23);
               return;
            case 110102:
               this.c((byte)23);
               return;
            case 110121:
               b((byte)22);
               return;
            case 110122:
               this.c((byte)22);
               return;
            case 110141:
               b((byte)21);
               return;
            case 110142:
               this.c((byte)21);
               return;
            case 110161:
               b((byte)20);
               return;
            case 110162:
               this.c((byte)20);
               return;
            case 110181:
               b((byte)15);
               return;
            case 110182:
               this.c((byte)15);
               return;
            case 110201:
               b((byte)14);
               return;
            case 110202:
               this.c((byte)14);
               return;
            case 110221:
               gc();
               return;
            case 110244:
               go();
               return;
            case 110361:
               this.ft();
               return;
            case 110382:
               Service.gI().k();
               return;
            case 110383:
               Service.gI().l();
               return;
            case 110391:
               this.n(1);
               return;
            case 110392:
               this.n(2);
               return;
            case 110393:
               this.n(3);
               return;
            case 110394:
               this.n(4);
               return;
            case 110395:
               this.n(5);
               return;
            case 110396:
               this.n(6);
               return;
            case 110397:
               this.n(7);
               return;
            case 110398:
               this.n(8);
               return;
            case 110399:
               this.n(9);
               return;
            case 110441:
               this.bd();
               return;
            case 110451:
               fr();
               return;
            case 110452:
               fq();
               return;
            case 110471:
               fp();
               return;
            case 110531:
               var10 = (Item)var2;
               Service.gI().h(var10.indexUI, GameCanvas.af.b + 3);
               return;
            case 110561:
               GameCanvas.j();
               this.ac();
               return;
            case 110562:
               e(var10 = (Item)var2);
               return;
            case 110701:
               Service.gI().t();
               return;
            case 110702:
               Service.gI().a(true);
               return;
            case 110703:
               Service.gI().a(false);
               return;
            case 110721:
               Service.gI().g(indexSelect, 1);
               return;
            case 110722:
               b(Char.getMyChar().arrItemBag[indexSelect]);
               return;
            case 110723:
               Service.gI().g(indexSelect, Char.getMyChar().arrItemBag[indexSelect].quantity);
               return;
            case 110771:
               var3 = (String)var2;
               GameCanvas.j();
               Service.gI().g(var3);
               return;
            case 110791:
               var3 = (String)var2;
               Service.gI().f(var3);
               return;
            case 110792:
               d(var3 = (String)var2);
               return;
            case 110801:
               Service.gI().ab(av);
               return;
            case 110802:
               Service.gI().aa(av);
               return;
            case 110803:
               var3 = (String)var2;
               Service.gI().e(var3);
               return;
            case 110804:
               dz();
               return;
            case 110805:
               this.dr();
               return;
            case 110811:
               b(Char.getMyChar().nClass.c[indexSelect]);
               return;
            case 110812:
               a(Char.getMyChar().nClass.c[indexSelect]);
               return;
            case 110821:
               Service.gI().b(indexSelect + mj);
               return;
            case 110841:
               Service.gI().e(indexTitle - 1, 1);
               this.aj();
               return;
            case 110842:
               this.bb();
               return;
            case 110851:
               var10 = (Item)var2;
               Service.gI().a(var10.typeUI, var10.indexUI, 1);
               return;
            case 110852:
               a(var10 = (Item)var2);
               return;
            case 110854:
               er();
               return;
            case 110921:
               var10 = (Item)var2;
               Service.gI().a(var10.typeUI, var10.indexUI, 1);
               return;
            case 110922:
               a(var10 = (Item)var2);
               return;
            case 110923:
               this.d((byte)16);
               return;
            case 110924:
               this.d((byte)17);
               return;
            case 110925:
               this.d((byte)18);
               return;
            case 110926:
               this.d((byte)19);
               return;
            case 110981:
               this.cs();
               return;
            case 110991:
               gq = true;
               this.a((int)3, (Item)ci);
               return;
            case 111001:
               this.en();
               return;
            case 111031:
               if (ij) {
                  Service.gI().a(cj, cb);
                  ;
                  return;
               }

               if (ik) {
                  Service.gI().b(cj, cb);
                  return;
               }

               if (il) {
                  Service.gI().a((byte)1, (Item)null, cj, cb);
                  return;
               }

               if (in) {
                  Service.gI().a((byte)2, (Item)null, cj, (Item[])null);
                  return;
               }

               if (io) {
                  Service.gI().a((byte)3, (Item)null, cj, (Item[])null);
                  return;
               }

               return;
            case 111071:
               this.ee();
               return;
            case 111101:
               var20 = k(4);
               Service.gI().d(var20.indexUI);
               return;
            case 120051:
               var14 = (ChatTab)var2;
               ChatManager.d().a.removeElement(var14);
               if (ChatManager.d().b > ChatManager.d().a.size() - 1) {
                  ChatManager.d().b();
               }

               if (ChatManager.d().e() != null) {
                  this.fk();
                  return;
               }

               ChatTextField.a().b = false;
               this.v();
               return;
            case 120061:
               ChatManager.c = !ChatManager.c;
               GameCanvas.a(TextGame.om + (ChatManager.c ? TextGame.aq : TextGame.ar));
               return;
            case 120062:
               ChatManager.d = !ChatManager.d;
               GameCanvas.a(TextGame.on + (ChatManager.d ? TextGame.aq : TextGame.ar));
               return;
            case 120063:
               ChatManager.blockPublic = !ChatManager.blockPublic;
               GameCanvas.a("Chặn công cộng: " + (ChatManager.blockPublic ? TextGame.aq : TextGame.ar));
               return;
            case 120065:
               ChatManager.blockNotify = !ChatManager.blockNotify;
               GameCanvas.a("Chặn thông báo: " + (ChatManager.blockNotify ? TextGame.aq : TextGame.ar));
               return;
            case 120064:
               ChatManager.hideIngameName = !ChatManager.hideIngameName;
               GameCanvas.a("Ẩn ingame: " + (ChatManager.hideIngameName ? TextGame.aq : TextGame.ar));
               return;
            case 120066:
               ChatManager.setBlockAll(!ChatManager.isBlockAll());
               GameCanvas.a("Ch\u1eb7n all: " + (ChatManager.isBlockAll() ? TextGame.aq : TextGame.ar));
               return;
            case 120071:
               this.pc = 2;
               if (GameCanvas.am.a.d().equals("")) {
                  GameCanvas.a(TextGame.jr);
                  return;
               }

               if (GameCanvas.am.b.d().equals("")) {
                  GameCanvas.a(TextGame.js);
                  return;
               }

               this.pd = "Loại thẻ: " + GameCanvas.am.a.d();
               this.pd = this.pd + ", Mệnh giá: " + GameCanvas.am.b.d();
               GameCanvas.j();
               this.dg();
               return;
            case 120072:
               if (GameCanvas.am.a.d().equals("")) {
                  GameCanvas.a(TextGame.jt);
                  return;
               }

               if (GameCanvas.am.b.d().equals("")) {
                  GameCanvas.a(TextGame.ju);
                  return;
               }

               this.pd = this.pd + ", Số seri: " + GameCanvas.am.a.d();
               this.pd = this.pd + ", Khoảng thời gian nạp: " + GameCanvas.am.b.d();
               Service.gI().d(this.pd);
               GameCanvas.j();
               return;
            case 120081:
               GameCanvas.al.a.b(11);
               GameCanvas.al.a(TextGame.oy, new Command1("OK", (IActionListener)null, 120082, (Object)null), 1);
               return;
            case 120082:
               if ((var3 = GameCanvas.al.a.d()).equals("")) {
                  GameCanvas.a(TextGame.oz);
                  return;
               }

               Service.gI().d("Số điện thoại đăng ký: " + var3);
               GameCanvas.j();
               return;
            case 130011:
               var12 = (Npc)var2;
               Service.gI().b(var12.npcTemplate.npcTemplateId, 0, -1);
               var12.f = null;
               this.v();
               return;
            case 130012:
               (var12 = (Npc)var2).f = null;
               this.v();
               return;
            case 130021:
               b((byte)32);
               return;
            case 130022:
               this.c((byte)32);
               return;
            case 140011:
               Service.gI().f(Char.getMyChar().nClass.c[indexSelect].id, 1);
               this.aj();
               return;
            case 140012:
               this.bc();
               return;
            case 140041:
               GameCanvas.al.a.b(180);
               GameCanvas.al.a(TextGame.pg, new Command1(TextGame.dc, GameCanvas.instance, 88832, (Object)null), 0);
               return;
            case 140042:
               Service.gI().ab();
               return;
            case 140043:
               GameCanvas.al.a(TextGame.ph, new Command1(TextGame.dc, GameCanvas.instance, 88834, (Object)null), 0);
               return;
            case 140044:
               Service.gI().ae();
               return;
            case 140071:
               av = 0;
               indexSelect = 0;
               ba.a();
               gr = !gr;
               y();
               return;
            case 140072:
               av = 0;
               indexSelect = 0;
               ba.a();
               gs = !gs;
               y();
               return;
            case 140081:
               Service.gI().aa();
               GameCanvas.j();
               return;
            case 140091:
               Service.gI().c(((Member)vClan.elementAt(av)).d, 3);
               return;
            case 140092:
               Service.gI().c(((Member)vClan.elementAt(av)).d, 2);
               return;
            case 140093:
               GameCanvas.a(TextGame.ke, new Command1(TextGame.bh, 1400931), new Command1(TextGame.bu, 1));
               return;
            case 140094:
               GameCanvas.a(TextGame.kf, new Command1(TextGame.bh, 1400941), new Command1(TextGame.bu, 1));
               return;
            case 140095:
               var9 = (Member)vClan.elementAt(av);
               Service.gI().p(var9.d);
               return;
            case 140096:
               (var4 = new MyVector()).addElement(new Command1(TextGame.qu, 1400961));
               var4.addElement(new Command1(TextGame.qv, 1400962));
               GameCanvas.af.a(var4);
               return;
            case 140101:
               (var20 = new Item()).template = ItemTemplates.a((short)0);
               var20.expires = -1L;
               this.a((int)39, (Item)var20);
               return;
            case 140131:
               GameCanvas.a(TextGame.ls, new Command1(TextGame.bh, 140132), new Command1(TextGame.bu, 1));
               return;
            case 140132:
               dm();
               return;
            case 140151:
               this.el();
               return;
            case 140161:
               this.a((int)3, (Item)ce[2]);
               return;
            case 140191:
               b((byte)34);
               return;
            case 140192:
               this.c((byte)34);
               return;
            case 140221:
               b((byte)35);
               return;
            case 140222:
               this.c((byte)35);
               return;
            case 150021:
               GameCanvas.k();
               var1 = 0;

               try {
                  var1 = Integer.parseInt(this.jd.d());
               } catch (Exception var201) {
               }

               Service.gI().a(ck, var1);
               return;
            case 150411:
               this.ix = 0;
               this.iy = 0;
               if (this.iw == 0) {
                  this.iw = 1;
               } else if (this.iw == 1) {
                  this.iw = 2;
               } else if (this.iw == 2) {
                  this.iw = 1;
               }

               this.cz();
               return;
            case 150412:
               this.ix = 0;
               this.iw = 0;
               if (this.iy == 0) {
                  this.iy = 1;
               } else if (this.iy == 1) {
                  this.iy = 2;
               } else if (this.iy == 2) {
                  this.iy = 1;
               }

               this.cz();
               return;
            case 150413:
               this.iw = 0;
               this.iy = 0;
               if (this.ix == 0) {
                  this.ix = 1;
               } else if (this.ix == 1) {
                  this.ix = 2;
               } else if (this.ix == 2) {
                  this.ix = 1;
               }

               this.cz();
               return;
            case 150421:
               GameCanvas.j();
               Service.gI().ap(cf[indexSelect].a.itemId);
               return;
            case 151301:
               Service.gI().aq(Char.getMyChar().mobFocus.c().e);
               return;
            case 909090:
               this.doOpenUI(38);
               return;
            case 1100011:
               this.ar();
               return;
            case 1100012:
               this.as();
               return;
            case 1100013:
               this.at();
               return;
            case 1100014:
               this.au();
               return;
            case 1100015:
               this.av();
               return;
            case 1100016:
               this.aw();
               return;
            case 1100017:
               this.ax();
               return;
            case 1100032:
               this.bi();
               return;
            case 1100033:
               dv();
               return;
            case 1100034:
               hf();
               return;
            case 1100041:
               fz();
               return;
            case 1100061:
               this.bj();
               return;
            case 1100062:
               this.bl();
               return;
            case 1100063:
               this.bm();
               return;
            case 1100064:
               this.bn();
               return;
            case 1100065:
               fv();
               return;
            case 1100067:
               dk();
               return;
            case 1100068:
               this.doOpenUI(40);
               return;
            case 1100181:
               GameCanvas.a(TextGame.d, new Command1(TextGame.sg, 1100182), new Command1(TextGame.bu, GameCanvas.instance, 8882, (Object)null));
               return;
            case 1100182:
               GameCanvas.aj = null;
               GameCanvas.ah.a(true);
               return;
            case 1103991:
               this.n(10);
               return;
            case 1107921:
               var3 = (String)var2;
               GameCanvas.j();
               Service.gI().g(var3);
               a(var3);
               return;
            case 1107931:
               var3 = (String)var2;
               Service.gI().e(var3);
               return;
            case 1107932:
               a(var3 = (String)var2);
               return;
            case 1108041:
               var3 = (String)var2;
               Service.gI().a((String)var3, 0);
               gI().v();
               return;
            case 1400931:
               Service.gI().c(((Member)vClan.elementAt(av)).d, 0);
               GameCanvas.j();
               return;
            case 1400941:
               Service.gI().o(((Member)vClan.elementAt(av)).d);
               GameCanvas.j();
               return;
            case 1400961:
               var9 = (Member)vClan.elementAt(av);
               Service.gI().q(var9.d);
               return;
            case 1400962:
               Service.gI().ad();
               return;
            case 11000651:
               m(1);
               return;
            case 11000652:
               m(2);
               return;
            case 11000653:
               m(3);
               return;
            case 11000661:
               aw = 0;
               this.du();
               return;
            case 11000662:
               aw = 1;
               this.du();
               Service.gI().x();
               return;
            case 11000663:
               aw = 2;
               this.du();
               Service.gI().y();
               return;
            case 11000664:
               aw = 3;
               this.du();
               Service.gI().z();
               return;
            case 11000665:
               if (cl = !cl) {
                  RMS.a(Char.getMyChar().cName + "vci", 1);
                  return;
               }

               RMS.a(Char.getMyChar().cName + "vci", 0);
               return;
            case 11000666:
               aw = 4;
               this.du();
               Service.gI().y();
               return;
            case 11000671:
               GameCanvas.a(TextGame.ow, 88836, (Object)null, 8882, (Object)null);
               return;
            case 11000672:
               GameCanvas.al.a.b(6);
               GameCanvas.al.a(TextGame.ox, new Command1(TextGame.dc, GameCanvas.instance, 88837, (Object)null), 1);
               return;
            case 11000673:
               GameCanvas.am.a(TextGame.pd, TextGame.pe);
               GameCanvas.am.a.b(6);
               GameCanvas.am.b.b(6);
               GameCanvas.am.a(TextGame.ox, new Command1(TextGame.ah, GameCanvas.instance, 8882, (Object)null), new Command1(TextGame.dc, GameCanvas.instance, 88838, (Object)null), 1, 1);
               return;
            case 11000674:
               GameCanvas.al.a.b(6);
               GameCanvas.al.a(TextGame.ox, new Command1(TextGame.dc, GameCanvas.instance, 88839, (Object)null), 1);
               return;
         }

      }
   }

   private void cv() {
      try {
         if (Char.getMyChar().arrItemBag[indexSelect].template.id == 454) {
            if (cb == null) {
               cb = new Item[24];
            }

            for(int var3 = 0; var3 < cb.length; ++var3) {
               if (var3 == 20) {
                  GameCanvas.a(TextGame.jo);
                  return;
               }

               if (cb[var3] == null) {
                  cb[var3] = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
                  super.a = super.b = null;
                  this.ac();
                  return;
               }
            }
         } else if (Char.getMyChar().arrItemBag[indexSelect].upgrade > 11) {
            if (cj == null) {
               cj = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
            } else {
               Item var1 = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               Char.getMyChar().arrItemBag[cj.indexUI] = cj;
               cj = var1;
            }

            Service.gI().c(cj.typeUI, cj.indexUI);
         } else {
            GameCanvas.a(TextGame.rt);
         }
      } catch (Exception var2) {
         ;
      }

   }

   private void cw() {
      Item var1 = k(44);
      cb[indexSelect] = null;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      super.a = super.b = null;
      this.ac();
   }

   private static void cx() {
      switch (av) {
         case 0:
            Char.dunghp = !Char.dunghp;
            if (ei == 1) {
               Char.dunghp = false;
               InfoMe.a(TextGame.rf, 20, mFont.j);
               return;
            }
         case 1:
            Char.dungmp = !Char.dungmp;
            if (ei == 1) {
               Char.dungmp = false;
               InfoMe.a(TextGame.rf, 20, mFont.j);
               return;
            }
         case 2:
            Char.dungthucan = !Char.dungthucan;
            if (ei == 1) {
               Char.dungthucan = false;
               InfoMe.a(TextGame.rf, 20, mFont.j);
               return;
            }
         case 3:
            Char.dunghotro = !Char.dunghotro;
            return;
         case 4:
            Char.nhat_yen = !Char.nhat_yen;
            return;
         case 5:
            Char.nhat_hpmp = !Char.nhat_hpmp;
            return;
         case 6:
            Char.nhat_da = !Char.nhat_da;
            return;
         case 7:
            Char.luyen_da = !Char.luyen_da;
            return;
         case 8:
            Char.nhat_tbi = !Char.nhat_tbi;
            return;
         case 9:
            Char.nhat_vpnv = !Char.nhat_vpnv;
            return;
         case 10:
            Char.nhat_svc = !Char.nhat_svc;
            return;
         case 11:
            Char.nhat_all = !Char.nhat_all;
            return;
         case 12:
            Char.remap = !Char.remap;
            return;
         case 13:
            Char.automuathucan = !Char.automuathucan;
            return;
         case 14:
            Char.tusathetmp = !Char.tusathetmp;
            return;
         case 15:
            Char.reconnect = !Char.reconnect;
            return;
         case 16:
            Char.chuyenmap = !Char.chuyenmap;
            return;
         case 17:
            Char.santatl = !Char.santatl;
            return;
         case 18:
            Char.quaithuong = !Char.quaithuong;
            return;
         case 19:
            Char.quaitinhanh = !Char.quaitinhanh;
            return;
         case 20:
            Char.quaithulinh = !Char.quaithulinh;
            return;
         case 21:
            Char.nepk = !Char.nepk;
            return;
         case 22:
            Char.danhtheonhom = !Char.danhtheonhom;
            return;
         case 23:
            Char.autottt = !Char.autottt;
            return;
         case 24:
            Char.autottc = !Char.autottc;
            return;
         case 25:
            Char.autocl = !Char.autocl;
            return;
         case 26:
            Char.automuacl = !Char.automuacl;
            return;
         case 27:
            Char.dung_pthan = !Char.dung_pthan;
            return;
         case 28:
            Char.autoCongTiemNang = !Char.autoCongTiemNang;
            return;
         case 29:
            Char.autoCongKyNang = !Char.autoCongKyNang;
            return;
         default:
      }
   }

   private void cy() {
      if (cg != null) {
         Item var1;
         (var1 = new Item()).template = ItemTemplates.a(cg[indexSelect]);
         this.a((int)38, (Item)var1);
      }

   }

   private void cz() {
      if (this.ix != 0 || this.iw != 0 || this.iy != 0) {
         for(int var1 = 0; var1 < cf.length - 1; ++var1) {
            for(int var2 = var1 + 1; var2 < cf.length; ++var2) {
               ItemStands var3;
               if (this.iw == 1) {
                  if (cf[var1].b < cf[var2].b) {
                     var3 = cf[var1];
                     cf[var1] = cf[var2];
                     cf[var2] = var3;
                  }
               } else if (this.iw == 2 && cf[var1].b > cf[var2].b) {
                  var3 = cf[var1];
                  cf[var1] = cf[var2];
                  cf[var2] = var3;
               }

               if (this.iy == 1) {
                  if (!cf[var1].a.template.name.equals(cf[var2].a.template.name) && cf[var1].a.template.name.compareTo(cf[var2].a.template.name) > 0) {
                     var3 = cf[var1];
                     cf[var1] = cf[var2];
                     cf[var2] = var3;
                  }
               } else if (this.iy == 2 && !cf[var1].a.template.name.equals(cf[var2].a.template.name) && cf[var1].a.template.name.compareTo(cf[var2].a.template.name) < 0) {
                  var3 = cf[var1];
                  cf[var1] = cf[var2];
                  cf[var2] = var3;
               }

               if (this.ix == 1) {
                  if (cf[var1].a.template.level < cf[var2].a.template.level) {
                     var3 = cf[var1];
                     cf[var1] = cf[var2];
                     cf[var2] = var3;
                  }
               } else if (this.ix == 2 && cf[var1].a.template.level > cf[var2].a.template.level) {
                  var3 = cf[var1];
                  cf[var1] = cf[var2];
                  cf[var2] = var3;
               }
            }
         }
      }

   }

   private static void da() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.qb, 150411));
      var0.addElement(new Command1(TextGame.qd, 150412));
      var0.addElement(new Command1(TextGame.qc, 150413));
      GameCanvas.af.a(var0);
   }

   private static void db() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bd, 15041));
      var0.addElement(new Command1(TextGame.bs, 15042));
      GameCanvas.af.a(var0);
   }

   private void dc() {
      Char.getMyChar().arrItemBag[ck.indexUI] = ck;
      ck = null;
      super.a = super.b = null;
   }

   private static void dd() {
      Item var0;
      if ((var0 = Char.getMyChar().arrItemBag[indexSelect]) != null) {
         if (!var0.isLock && !var0.isExpires) {
            if (ck == null) {
               ck = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
            } else {
               var0 = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               Char.getMyChar().arrItemBag[ck.indexUI] = ck;
               ck = var0;
            }
         } else {
            GameCanvas.a(TextGame.jg);
         }
      }

   }

   private static void de() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 140191));
      var0.addElement(new Command1(TextGame.bt, 140192));
      GameCanvas.af.a(var0);
   }

   private static void df() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.az, (IActionListener)null, 120081, (Object)null));
      var0.addElement(new Command1(TextGame.ba, (IActionListener)null, 12007, (Object)null));
      GameCanvas.af.a(var0);
   }

   private void dg() {
      if (this.pc == 1) {
         GameCanvas.am.a(TextGame.pn, TextGame.pm);
         GameCanvas.am.a(TextGame.pj, new Command1(TextGame.ah, GameCanvas.gI(), 8882, (Object)null), new Command1(TextGame.bb, (IActionListener)null, 120071, (Object)null), 0, 0);
      } else {
         GameCanvas.am.a(TextGame.po, TextGame.pp);
         GameCanvas.am.a(TextGame.pk, new Command1(TextGame.ah, GameCanvas.gI(), 8882, (Object)null), new Command1(TextGame.bx, (IActionListener)null, 120072, (Object)null), 0, 0);
      }

   }

   public static void a(String var0) {
      int var1;
      for(var1 = 0; var1 < vFriend.size(); ++var1) {
         Friend var2;
         if ((var2 = (Friend)vFriend.elementAt(var1)).a.equals(var0) && var2.b == 4) {
            vFriend.removeElementAt(var1);
            break;
         }
      }

      for(var1 = 0; var1 < vFriendWait.size(); ++var1) {
         if (((Friend)vFriendWait.elementAt(var1)).a.equals(var0)) {
            vFriendWait.removeElementAt(var1);
            return;
         }
      }

   }

   private static void dh() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.nv[0] + ": " + (gr ? TextGame.ar : TextGame.aq), 140071));
      var0.addElement(new Command1(TextGame.nw, 140072));
      GameCanvas.af.a(var0);
   }

   private static void di() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.nv[0] + ": " + (gr ? TextGame.ar : TextGame.aq), 140071));
      GameCanvas.af.a(var0);
   }

   private static void dj() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.ob, 110441));
      var0.addElement(new Command1(TextGame.nv[0] + ": " + (gr ? TextGame.ar : TextGame.aq), 140071));
      GameCanvas.af.a(var0);
   }

   private static void dk() {
      MyVector var0 = new MyVector();
      if (ei == 0) {
         var0.addElement(new Command1(TextGame.au, 11000671));
      } else if (ei == 1) {
         var0.addElement(new Command1(TextGame.an, 11000672));
      }

      if (ei == 1 || ei == 2) {
         var0.addElement(new Command1(TextGame.pc, 11000674));
         var0.addElement(new Command1(TextGame.pb, 11000673));
      }

      GameCanvas.af.a(var0);
   }

   private static void dl() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.ng, 110471));
      var0.addElement(new Command1(TextGame.nr[4], 1100061));
      GameCanvas.af.a(var0);
   }

   private static void dm() {
      GameCanvas.j();
      Service.gI().c(ce[0].indexUI, ce[1].indexUI, ce[2].indexUI);
   }

   private static void dn() {
      MyVector var0 = new MyVector();
      if (Char.getMyChar().ctypeClan == 3 || Char.getMyChar().ctypeClan == 4) {
         if (indexTitle == 1) {
            var0.addElement(new Command1(TextGame.nv[8], 140044));
         }

         var0.addElement(new Command1(TextGame.nv[2], 140041));
         var0.addElement(new Command1(TextGame.nv[5], 140042));
         if (Char.getMyChar().ctypeClan == 4) {
            var0.addElement(new Command1(TextGame.nv[4], 140043));
         }

         var0.addElement(new Command1(TextGame.nb[10] + ": " + (cl ? TextGame.ar : TextGame.aq), 11000665));
      }

      GameCanvas.af.a(var0);
   }

   private static void doa() {
      Party var0;
      if ((var0 = (Party)vPtMap.elementAt(av)) != null && !Char.getMyChar().cName.equals(var0.d)) {
         MyVector var1;
         (var1 = new MyVector()).addElement(new Command1(TextGame.nb[6], 1108041, var0.d));
         var1.addElement(new Command1(TextGame.bw, 12002, var0.d));
         var1.addElement(new Command1(TextGame.nx[2], 110803, var0.d));
         GameCanvas.af.a(var1);
      }

   }

   private static void dp() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.nm, 110452));
      if (vPtMap.size() > 0) {
         var0.addElement(new Command1(TextGame.nl, 110451));
      }

      GameCanvas.af.a(var0);
   }

   private static void dq() {
      Member var0 = (Member)vClan.elementAt(av);
      MyVector var1;
      (var1 = new MyVector()).addElement(new Command1(TextGame.nt[1], 140091, var0.d));
      var1.addElement(new Command1(TextGame.nt[2], 140092, var0.d));
      GameCanvas.af.a(var1);
   }

   private void dr() {
      Member var1;
      if (av >= 0 && av < vClan.size() && (var1 = bw()) != null && !var1.d.equals("")) {
         Service.gI().a((String)var1.d, 0);
         ie = false;
         gI().v();
      }

   }

   private void ds() {
      Member var2 = bw();
      MyVector var1 = new MyVector();
      if (Char.getMyChar().ctypeClan == 4) {
         if (var2.c != 4) {
            if (var2.c != 3 && var2.c != 2) {
               var1.addElement(new Command1(TextGame.oo, 14009, var2.d));
            } else {
               var1.addElement(new Command1(TextGame.op, 140093, var2.d));
            }

            if (TileMap.mapID != 98 && TileMap.mapID != 104) {
               var1.addElement(new Command1(TextGame.nv[6], 140095, var2.d));
            } else {
               var1.addElement(new Command1(TextGame.nv[7], 140096, var2.d));
            }

            var1.addElement(new Command1(TextGame.oq, 140094, var2.d));
         }

         var1.addElement(new Command1(TextGame.av, 14007));
      } else if (Char.getMyChar().ctypeClan == 3) {
         if (var2.c != 4 && !var2.d.equals(Char.getMyChar().cName)) {
            var1.addElement(new Command1(TextGame.oq, 140094, var2.d));
            if (TileMap.mapID != 98 && TileMap.mapID != 104) {
               var1.addElement(new Command1(TextGame.nv[6], 140095, var2.d));
            } else {
               var1.addElement(new Command1(TextGame.nv[7], 140096, var2.d));
            }
         }

         var1.addElement(new Command1(TextGame.av, 14007));
         var1.addElement(new Command1(TextGame.nv[1], 14008, var2.d));
      } else {
         var1.addElement(new Command1(TextGame.av, 14007));
         var1.addElement(new Command1(TextGame.nv[1], 14008, var2.d));
      }

      GameCanvas.af.a(var1);
   }

   private static boolean dt() {
      for(int var0 = 0; var0 < Char.getMyChar().arrItemBag.length; ++var0) {
         Item var1;
         if ((var1 = Char.getMyChar().arrItemBag[var0]) != null && var1.template.id == 279 && var1.template.level <= Char.getMyChar().cLevel) {
            return true;
         }
      }

      return false;
   }

   private static void b(String var0) {
      MyVector var1;
      (var1 = new MyVector()).addElement(new Command1(TextGame.nb[6], 110805));
      var1.addElement(new Command1(TextGame.bw, 12002, var0));
      var1.addElement(new Command1(TextGame.oa, 110791, var0));
      var1.addElement(new Command1(TextGame.ac, 14020, var0));
      var1.addElement(new Command1(TextGame.nx[2], 110803, var0));
      GameCanvas.af.a(var1);
   }

   private void du() {
      ie = true;
      ifa = true;
      gs = false;
      this.mm = this.mn = null;
      b(175, 200);
      this.ac();
      super.c = this.ne;
      Service.gI().w();
   }

   private static void dv() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.mh[0], 11000661));
      var0.addElement(new Command1(TextGame.mh[1], 11000662));
      var0.addElement(new Command1(TextGame.mh[2], 11000663));
      var0.addElement(new Command1(TextGame.mh[3], 11000664));
      var0.addElement(new Command1(TextGame.mh[4], 11000666));
      GameCanvas.af.a(var0);
   }

   private void dw() {
      Char.getMyChar().charFocus = null;
      Char.fg = false;
      this.dm = -1;
      ic = false;
      this.v();
   }

   private void dx() {
      Char var1;
      if (!(var1 = (Char)vCharInMap.elementAt(av)).ab()) {
         this.dm = var1.idChar;
         Char.getMyChar().mobFocus = null;
         Char.getMyChar().v();
         Char.getMyChar().itemFocus = null;
         Char.getMyChar();
         Char.fg = true;
         ic = false;
         Char.getMyChar().charFocus = var1;
      }

      this.v();
   }

   private void dy() {
      if (aw == 0) {
         aw = 1;
      } else {
         aw = 0;
      }

      av = 0;
      this.gh = aw;
   }

   private static void dz() {
      Party var0;
      if ((var0 = (Party)vParty.elementAt(av)).f != null && var0.f != Char.getMyChar()) {
         Service.gI().a((String)var0.f.cName, 0);
         gw = false;
         gI().v();
      }

   }

   private static void ea() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bd, 110221));
      var0.addElement(new Command1(TextGame.bl, 11050));
      GameCanvas.af.a(var0);
   }

   private static void eb() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bd, 11048));
      var0.addElement(new Command1(TextGame.bk, 11049));
      GameCanvas.af.a(var0);
   }

   private void ec() {
      if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26 && Char.getMyChar().arrItemBag[indexSelect].template.id != 455 && Char.getMyChar().arrItemBag[indexSelect].template.id != 456) {
         if (Char.getMyChar().arrItemBag[indexSelect].template.id == 457) {
            GameCanvas.ak.a(TextGame.rj, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         } else {
            GameCanvas.ak.a(TextGame.rk, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         }
      } else {
         if (Char.getMyChar().arrItemBag[indexSelect].template.type == 26 && Char.getMyChar().arrItemBag[indexSelect].template.id < 10) {
            GameCanvas.a(TextGame.rn);
            return;
         }

         short var1 = 0;
         int var2 = 0;
         boolean var3 = bz[12] != null;

         int var4;
         for(var4 = 0; var4 < bz.length; ++var4) {
            if (bz[var4] != null && bz[var4].template.type != 26) {
               var1 = bz[var4].template.id;
               ++var2;
            }
         }

         for(var4 = 0; var4 < bz.length; ++var4) {
            if (bz[var4] == null) {
               if (Char.getMyChar().arrItemBag[indexSelect].template.type == 26) {
                  if (bz[12] == null) {
                     bz[12] = Char.getMyChar().arrItemBag[indexSelect];
                     Char.getMyChar().arrItemBag[indexSelect] = null;
                  } else {
                     Item var5 = Char.getMyChar().arrItemBag[indexSelect];
                     Char.getMyChar().arrItemBag[indexSelect] = null;
                     Char.getMyChar().arrItemBag[bz[12].indexUI] = bz[12];
                     bz[12] = var5;
                  }
               } else if (var1 > 0 && Char.getMyChar().arrItemBag[indexSelect].template.id != var1) {
                  GameCanvas.a(TextGame.ro);
               } else if ((!var3 || var2 < 3) && var2 < 9) {
                  bz[var4] = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
               } else {
                  GameCanvas.a(TextGame.rq);
               }

               super.a = super.b = null;
               this.ac();
               return;
            }
         }

         GameCanvas.ak.a(TextGame.jo, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
      }

      GameCanvas.aj = GameCanvas.ak;
   }

   private void ed() {
      if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26) {
         GameCanvas.ak.a(TextGame.jh, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      } else {
         for(int var1 = 0; var1 < bz.length; ++var1) {
            if (bz[var1] == null) {
               bz[var1] = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               super.a = super.b = null;
               this.ac();
               return;
            }
         }

         GameCanvas.ak.a(TextGame.jo, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      }

   }

   private void ee() {
      Item var1 = k(11);
      bz[indexSelect] = null;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      super.a = super.b = null;
      this.ac();
   }

   private static void ef() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bj, 111071));

      for(int var1 = 0; var1 < bz.length; ++var1) {
         if (bz[var1] != null) {
            var0.addElement(new Command1(TextGame.ev, 1600));
            break;
         }
      }

      GameCanvas.af.a(var0);
   }

   private static void eg() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bj, 111071));

      for(int var1 = 0; var1 < bz.length; ++var1) {
         if (bz[var1] != null) {
            var0.addElement(new Command1(TextGame.ev, 11062));
            break;
         }
      }

      GameCanvas.af.a(var0);
   }

   private void eh() {
      try {
         int var2;
         int var5;
         if (ij) {
            if (!Char.getMyChar().arrItemBag[indexSelect].b() && !Char.getMyChar().arrItemBag[indexSelect].c() && Char.getMyChar().arrItemBag[indexSelect].template.id != 455 && Char.getMyChar().arrItemBag[indexSelect].template.id != 456 && Char.getMyChar().arrItemBag[indexSelect].template.id != 457) {
               GameCanvas.ak.a(TextGame.rr, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
               GameCanvas.aj = GameCanvas.ak;
            } else if (Char.getMyChar().arrItemBag[indexSelect].template.id != 455 && Char.getMyChar().arrItemBag[indexSelect].template.id != 456 && Char.getMyChar().arrItemBag[indexSelect].template.id != 457) {
               ItemOption var6 = null;

               for(var2 = 0; var2 < Char.getMyChar().arrItemBag[indexSelect].options.size() && (var6 = (ItemOption)Char.getMyChar().arrItemBag[indexSelect].options.elementAt(var2)).c.a != 85; ++var2) {
                  var6 = null;
               }

               if (var6 != null && var6.a >= 9) {
                  GameCanvas.a(TextGame.sa);
               } else {
                  if (cj == null) {
                     cj = Char.getMyChar().arrItemBag[indexSelect];
                     Char.getMyChar().arrItemBag[indexSelect] = null;
                  } else {
                     Item var7 = Char.getMyChar().arrItemBag[indexSelect];
                     Char.getMyChar().arrItemBag[indexSelect] = null;
                     Char.getMyChar().arrItemBag[cj.indexUI] = cj;
                     cj = var7;
                  }

                  Service.gI().c(cj.typeUI, cj.indexUI);
               }
            } else {
               if (cb == null) {
                  cb = new Item[24];
               }

               for(var5 = 0; var5 < cb.length; ++var5) {
                  if (cb[var5] == null) {
                     cb[var5] = Char.getMyChar().arrItemBag[indexSelect];
                     Char.getMyChar().arrItemBag[indexSelect] = null;
                     super.a = super.b = null;
                     this.ac();
                     return;
                  }

                  if (var5 == cb.length - 1) {
                     GameCanvas.a(TextGame.jo);
                  }
               }
            }
         } else if (Char.getMyChar().arrItemBag[indexSelect].b() && Char.getMyChar().arrItemBag[indexSelect].upgrade > 0) {
            if (cj == null) {
               cj = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
            } else {
               Item var1 = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               Char.getMyChar().arrItemBag[cj.indexUI] = cj;
               cj = var1;
            }

            if (cj != null) {
               var5 = 0;
               if (cj.r()) {
                  for(var2 = 0; var2 < cj.upgrade; ++var2) {
                     var5 += cy[var2];
                  }
               } else if (cj.s()) {
                  for(var2 = 0; var2 < cj.upgrade; ++var2) {
                     var5 += cz[var2];
                  }
               } else if (cj.t()) {
                  for(var2 = 0; var2 < cj.upgrade; ++var2) {
                     var5 += da[var2];
                  }
               }

               var5 /= 2;
               var2 = 0;
               cb = new Item[24];

               for(int var3 = cx.length - 1; var3 >= 0; --var3) {
                  if (var5 >= cx[var3]) {
                     cb[var2] = new Item();
                     cb[var2].typeUI = 3;
                     cb[var2].template = ItemTemplates.a((short)var3);
                     cb[var2].isLock = cj.isLock;
                     cb[var2].expires = -1L;
                     var5 -= cx[var3];
                     ++var3;
                     ++var2;
                  }
               }
            }

            super.a = super.b = null;
            this.ac();
         } else {
            GameCanvas.ak.a(TextGame.jm, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
            GameCanvas.aj = GameCanvas.ak;
         }
      } catch (Exception var5) {
         GameCanvas.ak.a(TextGame.rr, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      }

   }

   private void ei() {
      MyVector var1;
      (var1 = new MyVector()).addElement(this.mx);
      if (cj != null) {
         var1.addElement(new Command1(TextGame.ev, 111031));
      }

      GameCanvas.af.a(var1);
   }

   private void ej() {
      if (Char.getMyChar().arrItemBag[indexSelect].b()) {
         if (Char.getMyChar().arrItemBag[indexSelect].template.level >= 10 && Char.getMyChar().arrItemBag[indexSelect].template.type < 10) {
            if (Char.getMyChar().arrItemBag[indexSelect].upgrade >= Char.getMyChar().arrItemBag[indexSelect].q()) {
               GameCanvas.ak.a(TextGame.jl, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
               GameCanvas.aj = GameCanvas.ak;
            } else {
               if (ci == null) {
                  ci = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
               } else {
                  Item var3 = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
                  Char.getMyChar().arrItemBag[ci.indexUI] = ci;
                  ci = var3;
               }

               super.a = super.b = null;
               this.ac();
            }
         } else {
            GameCanvas.ak.a(TextGame.jk, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
            GameCanvas.aj = GameCanvas.ak;
         }
      } else if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26 && Char.getMyChar().arrItemBag[indexSelect].template.type != 28) {
         GameCanvas.ak.a(TextGame.ji, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      } else {
         int var1;
         if (Char.getMyChar().arrItemBag[indexSelect].template.type == 28) {
            for(var1 = 0; var1 < ca.length; ++var1) {
               if (ca[var1] != null && ca[var1].template.type == 28) {
                  Item var2 = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
                  int var10001 = ca[var1].indexUI;
                  Char.getMyChar().arrItemBag[var10001] = ca[var1];
                  ca[var1] = var2;
                  return;
               }
            }
         }

         for(var1 = 0; var1 < ca.length; ++var1) {
            if (ca[var1] == null) {
               ca[var1] = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               super.a = super.b = null;
               this.ac();
               return;
            }
         }

         GameCanvas.ak.a(TextGame.jo, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      }

   }

   private void l(int var1) {
      if (ce[var1] == null) {
         ce[var1] = Char.getMyChar().arrItemBag[indexSelect];
         Char.getMyChar().arrItemBag[indexSelect] = null;
      } else {
         Item var2 = Char.getMyChar().arrItemBag[indexSelect];
         Char.getMyChar().arrItemBag[indexSelect] = null;
         int var10001 = ce[var1].indexUI;
         Char.getMyChar().arrItemBag[var10001] = ce[var1];
         ce[var1] = var2;
      }

      super.a = super.b = null;
      this.ac();
   }

   private void ek() {
      if (Char.getMyChar().arrItemBag[indexSelect].b()) {
         if (Char.getMyChar().arrItemBag[indexSelect].upgrade > 0) {
            this.l(0);
         } else {
            this.l(1);
         }
      } else if (Char.getMyChar().arrItemBag[indexSelect].template.id != 269 && Char.getMyChar().arrItemBag[indexSelect].template.id != 270 && Char.getMyChar().arrItemBag[indexSelect].template.id != 271) {
         GameCanvas.ak.a(TextGame.jj, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      } else {
         this.l(2);
      }

   }

   private void el() {
      Item var1 = null;
      var1 = ce[2];
      ce[2] = null;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      super.a = super.b = null;
      this.ac();
   }

   private void em() {
      Item var1 = null;
      var1 = ce[indexSelect];
      ce[indexSelect] = null;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      super.a = super.b = null;
      this.ac();
   }

   private void en() {
      Item var1 = k(10);
      ca[indexSelect] = null;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      super.a = super.b = null;
      this.ac();
   }

   private static void eo() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bj, 111001));
      if (ci != null) {
         for(int var1 = 0; var1 < ca.length; ++var1) {
            if (ca[var1] != null) {
               var0.addElement(new Command1(TextGame.ev, 110981));
               break;
            }
         }
      }

      GameCanvas.af.a(var0);
   }

   private void ep() {
      MyVector var1;
      (var1 = new MyVector()).addElement(this.mw);

      for(int var2 = 0; var2 < ce.length; ++var2) {
         if (ce[var2] == null) {
            super.a = null;
            break;
         }

         if (var2 == ce.length - 1) {
            var1.addElement(new Command1(TextGame.ev, 140131));
         }
      }

      GameCanvas.af.a(var1);
   }

   private void eq() {
      MyVector var1;
      (var1 = new MyVector()).addElement(this.mv);

      for(int var2 = 0; var2 < ca.length; ++var2) {
         if (ca[var2] != null) {
            var1.addElement(new Command1(TextGame.ev, 110981));
            break;
         }
      }

      GameCanvas.af.a(var1);
   }

   private static void c(Item var0) {
      MyVector var1;
      (var1 = new MyVector()).addElement(new Command1(TextGame.bs, 110921, var0));
      var1.addElement(new Command1(TextGame.bt, 110922, var0));
      GameCanvas.af.a(var1);
   }

   private static void er() {
      av = 0;
      ba.a();
      if (jt == 0) {
         jt = 1;
      } else {
         jt = 0;
      }

   }

   private void es() {
      aw = 0;
      cr = false;
      super.a = this.ka;
      super.c = this.ge;
      super.b = null;
      System.gc();
      this.v();
      this.bf();
   }

   private static void et() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110851));
      var0.addElement(new Command1(TextGame.bt, 110852));
      GameCanvas.af.a(var0);
   }

   private static void eu() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.cy, 110841));
      var0.addElement(new Command1(TextGame.cz, 110842));
      GameCanvas.af.a(var0);
   }

   private static void ev() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.kd, 110821));
      if (!GameCanvas.g) {
         if (mj == 0) {
            var0.addElement(new Command1(TextGame.sj, 2003));
         } else {
            var0.addElement(new Command1(TextGame.si, 2003));
         }
      }

      GameCanvas.af.a(var0);
   }

   private static void ew() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.ps[0], 110811));
      var0.addElement(new Command1(TextGame.ps[1], 110812));
      GameCanvas.af.a(var0);
   }

   private static void c(String var0) {
      MyVector var1;
      (var1 = new MyVector()).addElement(new Command1(TextGame.nx[0], 110801));
      var1.addElement(new Command1(TextGame.nx[1], 110802));
      var1.addElement(new Command1(TextGame.nx[2], 110803, var0));
      var1.addElement(new Command1(TextGame.nb[7], 12002, var0));
      var1.addElement(new Command1(TextGame.nb[6], 110804));
      GameCanvas.af.a(var1);
   }

   private static void ex() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.cy, 140011));
      var0.addElement(new Command1(TextGame.cz, 140012));
      GameCanvas.af.a(var0);
   }

   private static void d(String var0) {
      GameCanvas.a(TextGame.od, new Command1(TextGame.bh, 1107921, var0), new Command1(TextGame.bu, 1));
   }

   private static void ey() {
      Friend var0 = (Friend)vFriend.elementAt(av);
      MyVector var1;
      (var1 = new MyVector()).addElement(new Command1(TextGame.nb[6], 1108041, var0.a));
      var1.addElement(new Command1(TextGame.bw, 12002, var0.a));
      if (var0.b == 4) {
         var1.addElement(new Command1(TextGame.dc, 1107931, var0.a));
         var1.addElement(new Command1(TextGame.dd, 1107932, var0.a));
      } else {
         var1.addElement(new Command1(TextGame.oa, 110791, var0.a));
         var1.addElement(new Command1(TextGame.ac, 14020, var0.a));
         var1.addElement(new Command1(TextGame.aw, 110792, var0.a));
      }

      GameCanvas.af.a(var1);
   }

   private void a(byte var1) {
      if (av >= 0 && av < vList.size()) {
         Ranked var2 = null;

         try {
            var2 = (Ranked)vList.elementAt(av);
            String var3 = null;
            if (var2 != null) {
               var3 = var2.b;
            } else {
               var3 = "raned=null";
            }

            Service.gI().a(var1, var3);
            this.v();
         } catch (Exception var4) {
         }
      }

   }

   private static void ez() {
      if (av >= 0 && av < vList.size()) {
         int var0 = ((DunItem)vList.elementAt(av)).a;
         Service.gI().ac(var0);
      }

   }

   private static void fa() {
      Friend var0 = (Friend)vEnemies.elementAt(av);
      MyVector var1;
      (var1 = new MyVector()).addElement(new Command1(TextGame.nb[6], 1108041, var0.a));
      var1.addElement(new Command1(TextGame.bw, 12002, var0.a));
      var1.addElement(new Command1(TextGame.oa, 11076, var0.a));
      var1.addElement(new Command1(TextGame.ac, 14020, var0.a));
      var1.addElement(new Command1(TextGame.aw, 11077, var0.a));
      GameCanvas.af.a(var1);
   }

   private static void e(String var0) {
      GameCanvas.a(TextGame.od, new Command1(TextGame.bh, 110771, var0), new Command1(TextGame.bu, 1));
   }

   private void fb() {
      co = false;
      this.jc = null;
      this.jb = null;
      super.b = null;
      this.v();
   }

   private void a(short var1, String var2) {
      NinjaUtil.a(var2, var1);
      co = false;
      this.jc = null;
      this.jb = null;
      super.b = null;
      this.v();
   }

   private static void fc() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bo, 110721));
      var0.addElement(new Command1(TextGame.bp, 110722));
      var0.addElement(new Command1(TextGame.bq, 110723));
      GameCanvas.af.a(var0);
   }

   private static void a(Party var0) {
      MyVector var1;
      (var1 = new MyVector()).addElement(new Command1(TextGame.nh, 110701));
      if (!var0.e) {
         var1.addElement(new Command1(TextGame.nj, 110702));
      } else {
         var1.addElement(new Command1(TextGame.nk, 110703));
      }

      GameCanvas.af.a(var1);
   }

   private void fd() {
      co = false;
      this.jc = null;
      this.jb = null;
      super.b = null;
      this.v();
   }

   private void f(String var1) {
      NinjaUtil.b(var1);
      co = false;
      this.jc = null;
      this.jb = null;
      super.b = null;
      this.v();
   }

   private static void fe() {
      GameCanvas.j();
      Service.gI().a(ci, ca, hy);
   }

   private static void d(Item var0) {
      GameCanvas.j();
      Service.gI().g(var0.indexUI, 1);
   }

   private void ff() {
      aw = 0;
      cr = false;
      this.v();
      if (currentCharViewInfo.idChar == Char.getMyChar().idChar) {
         this.bf();
      }

   }

   private void fg() {
      if (this.kj >= 0 && this.kj < jz.length) {
         Skill var1 = jz[this.kj];
         this.a(var1, false, true);
      }

   }

   private static void e(Item var0) {
      String var1;
      if (!(var1 = GameCanvas.al.a.d()).trim().equals("")) {
         int var4;
         try {
            var4 = Integer.parseInt(var1);
         } catch (Exception var41) {
            GameCanvas.j();
            return;
         }

         if (var4 <= 0) {
            GameCanvas.j();
         } else if (var4 > var0.quantity) {
            GameCanvas.a(TextGame.kr);
         } else {
            GameCanvas.j();
            GameCanvas.a(TextGame.ki, new Command1(TextGame.bh, 11058, var0), new Command1(TextGame.bu, 1));
         }
      }

   }

   private static void f(Item var0) {
      String var1;
      if ((var1 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.ak.a(TextGame.kn, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      } else {
         int var4;
         try {
            var4 = Integer.parseInt(var1);
         } catch (Exception var42) {
            GameCanvas.j();
            return;
         }

         if (var4 <= 0) {
            GameCanvas.j();
         } else {
            Service.gI().a(var0.typeUI, var0.indexUI, var4);
            GameCanvas.j();
         }
      }

   }

   public void fh() {
      int var1 = indexSelect;
      this.v();
      this.iz = var1;
      Service.gI().e();
   }

   private static void g(Item var0) {
      MyVector var1 = new MyVector();

      for(int var2 = 1; var2 < TextGame.mm[3].length; ++var2) {
         var1.addElement(new Command1(TextGame.mm[3][var2], 110531, var0));
      }

      GameCanvas.af.a(var1);
   }

   private static void fi() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1("Ch\u1eb7n all: " + (ChatManager.isBlockAll() ? TextGame.aq : TextGame.ar), 120066));
      var0.addElement(new Command1(TextGame.om + (ChatManager.c ? TextGame.aq : TextGame.ar), 120061));
      var0.addElement(new Command1(TextGame.on + (ChatManager.d ? TextGame.aq : TextGame.ar), 120062));
      // Port TGAME: nút chặn thông báo EXP/Yên/item nhận được
      var0.addElement(new Command1("Chặn thông báo: " + (ChatManager.blockNotify ? TextGame.aq : TextGame.ar), 120065));
      var0.addElement(new Command1("Ẩn ingame: " + (ChatManager.hideIngameName ? TextGame.aq : TextGame.ar), 120064));
      var0.addElement(new Command1("Chặn công cộng: " + (ChatManager.blockPublic ? TextGame.aq : TextGame.ar), 120063));
      GameCanvas.af.a(var0);
   }

   private static void fj() {
      MyVector var0 = new MyVector();

      for(int var1 = 0; var1 < ChatManager.d().a.size(); ++var1) {
         ChatTab var2 = (ChatTab)ChatManager.d().a.elementAt(var1);
         var0.addElement(new Command1(var2.b, 12001, new Integer(var1)));
      }

      var0.addElement(new Command1(TextGame.pr, 12008));
      GameCanvas.af.a(var0);
      cm = true;
   }

   private void fk() {
      ChatTab var1 = ChatManager.d().e();
      co = true;
      cu = true;
      this.ja = true;
      b(175, 200);
      if (GameCanvas.ab - fg < 40 && !GameCanvas.g) {
         fg -= 52;
      }

      super.c = new Command1(TextGame.ah, 11066);
      super.a = super.b = null;
      if (!GameCanvas.g) {
         this.fl();
      } else {
         super.a = new Command1(TextGame.bw, 12005);
      }

      if (var1.a == 2) {
         super.b = new Command1(TextGame.ai, 120051, var1);
      }

      ChatTextField.a().f = null;
      this.jc = var1.b;
      this.jb = var1.c;
      ChatManager.d().e(var1.b);
      if (var1.a == 1) {
         ChatManager.f = false;
      }

      if (var1.a == 4) {
         ChatManager.e = false;
      }

      this.ai();
   }

   private void fl() {
      ChatTab var1;
      if ((var1 = ChatManager.d().e()).a == 0) {
         ChatTextField.a().a(TextGame.oi[0]);
      }

      if (var1.a == 1) {
         ChatTextField.a().a(TextGame.oj[0]);
      }

      if (var1.a == 2) {
         ChatTextField.a().a(var1.b);
      }

      if (var1.a == 3) {
         ChatTextField.a().a(TextGame.ok[0]);
      }

      if (var1.a == 4) {
         ChatTextField.a().a(TextGame.ol[0]);
      }

   }

   private void fm() {
      try {
         GameMidlet.g.platformRequest(this.ob);
      } catch (Exception var2) {
         ;
      }

   }

   private static void fn() {
      GameCanvas.j();
      Service.gI().useItem(indexSelect);
   }

   private static void fo() {
      Service.gI().g();
   }

   private static void fp() {
      Service.gI().s();
   }

   private static void fq() {
      av = 0;
      Service.gI().d();
   }

   private static void fr() {
      Party var0;
      if (av >= 0 && av < vPtMap.size() && (var0 = (Party)vPtMap.elementAt(av)) != null) {
         Service.gI().h(var0.d);
      }

   }

   private static void m(int var0) {
      switch (var0) {
         case 1:
            Service.gI().z(0);
            return;
         case 2:
            Service.gI().z(1);
            return;
         case 3:
            Service.gI().z(3);
         default:
      }
   }

   private static void fs() {
      String var0;
      if ((var0 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.j();
      } else {
         int var3;
         try {
            var3 = Integer.parseInt(var0);
         } catch (Exception var311) {
            GameCanvas.j();
            return;
         }

         if (var3 <= 0) {
            GameCanvas.j();
         } else if (Char.getMyChar().xu != 0 && var3 <= Char.getMyChar().xu) {
            Service.gI().j(var3);
            GameCanvas.j();
         } else {
            GameCanvas.a(TextGame.kp);
         }
      }

   }

   private void ft() {
      String var1;
      if ((var1 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.j();
      } else {
         int var4;
         try {
            var4 = Integer.parseInt(var1);
         } catch (Exception var411) {
            GameCanvas.j();
            return;
         }

         if (var4 <= 0) {
            GameCanvas.j();
         } else if (Char.getMyChar().xu != 0 && var4 <= Char.getMyChar().xu) {
            this.dj += var4;
            Char var10000 = Char.getMyChar();
            var10000.xu -= var4;
            GameCanvas.j();
         } else {
            GameCanvas.a(TextGame.ko);
         }
      }

   }

   private static void fu() {
      String var0;
      if ((var0 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.j();
      } else {
         int var3;
         try {
            var3 = Integer.parseInt(var0);
         } catch (Exception var3243) {
            GameCanvas.j();
            return;
         }

         if (var3 <= 0) {
            GameCanvas.j();
         } else if (Char.getMyChar().bs != 0 && var3 <= Char.getMyChar().bs) {
            Service.gI().k(var3);
            GameCanvas.j();
         } else {
            GameCanvas.a(TextGame.kq);
         }
      }

   }

   private static void fv() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.nq[0], 11000651));
      var0.addElement(new Command1(TextGame.nq[1], 11000652));
      var0.addElement(new Command1(TextGame.nq[3], 11000653));
      GameCanvas.af.a(var0);
   }

   private static void fw() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.nr[6], 1100067));
      var0.addElement(new Command1(TextGame.nr[3], 1100062));
      var0.addElement(new Command1(TextGame.nr[1], 1100063));
      var0.addElement(new Command1(TextGame.nr[2], 1100064));
      var0.addElement(new Command1(TextGame.nr[0], 1100065));
      var0.addElement(new Command1(TextGame.nr[7], 1100068));
      GameCanvas.af.a(var0);
   }

   private void fx() {
      this.ba();
      if (super.c != null) {
         super.c.a();
      }

   }

   private void fy() {
      this.ba();
      if (super.a != null) {
         super.a.a();
      }

   }

   private void n(int var1) {
      if (Char.getMyChar().charFocus != null && !Char.getMyChar().charFocus.ab()) {
         switch (var1) {
            case 1:
               Service.gI().f(Char.getMyChar().charFocus.cName);
               return;
            case 2:
               Service.gI().s(Char.getMyChar().charFocus.idChar);
               return;
            case 3:
               Service.gI().v(Char.getMyChar().charFocus.idChar);
               return;
            case 4:
               Service.gI().w(Char.getMyChar().charFocus.idChar);
               return;
            case 5:
               this.g(Char.getMyChar().charFocus.idChar);
               return;
            case 6:
               Service.gI().e(Char.getMyChar().charFocus.cName);
               return;
            case 7:
               Service.gI().a((String)Char.getMyChar().charFocus.cName, 0);
               gI().v();
               return;
            case 8:
               Service.gI().af(Char.getMyChar().charFocus.idChar);
               return;
            case 9:
               Service.gI().ag(Char.getMyChar().charFocus.idChar);
               return;
            case 10:
               Char.dq = !Char.dq;
               Char.dv = Char.getMyChar().charFocus.idChar;
         }
      }

   }

   public final void g(int var1) {
      if (System.currentTimeMillis() - this.pe > 500L) {
         Service.gI().x(var1);
         this.pe = System.currentTimeMillis();
      }

      if ((TileMap.tileTypeAtPixel(Char.getMyChar().cx1, Char.getMyChar().cy1) & 2) == 2) {
         Char.getMyChar().a((SkillPaint)aa[49], 0);
      } else {
         Char.getMyChar().a((SkillPaint)aa[49], 1);
      }

   }

   private static void fz() {
      GameCanvas.k();
      ChatManager.d();
      ChatManager.f();
      Session_ME.a().c();
      long var2 = 1000L;
      Timer.a = 9999;
      Timer.b = System.currentTimeMillis() + var2;
      Timer.c = true;
   }

   private static void ga() {
      GameCanvas.a(TextGame.dw, new Command1(TextGame.bh, 1100041), new Command1(TextGame.bu, 1));
   }

   private static void gb() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.ne[1], 110381));
      var0.addElement(new Command1(TextGame.ne[2], 110382));
      var0.addElement(new Command1(TextGame.ne[3], 110383));
      GameCanvas.af.a(var0);
   }

   private static void gc() {
      Service.gI().f();
   }

   private void gd() {
      Item var1 = cc[indexSelect];
      cc[indexSelect] = null;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      super.a = super.b = null;
      this.ac();
   }

   private void ge() {
      Item var1 = cj;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      cj = null;
      if (!ij && !ik && !il && !ir && cb != null) {
         for(int var2 = 0; var2 < cb.length; ++var2) {
            cb[var2] = null;
         }
      }

      super.a = super.b = null;
      this.ac();
   }

   private void gf() {
      Item var1 = ci;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      ci = null;
      super.a = super.b = null;
      this.ac();
   }

   private void gg() {
      Item var1 = ce[indexSelect];
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      ce[indexSelect] = null;
      super.a = super.b = null;
      this.ac();
   }

   private void gh() {
      Service.gI().j();
      this.dh = 2;
      if (gI().dh >= 2 && gI().di >= 2) {
         InfoDlg.a();
      }

   }

   private void gi() {
      Service.gI().a(this.dj, cc);
      this.dh = 1;
      if (gI().dh == 1 && gI().di == 1) {
         gI().dl = (int)(System.currentTimeMillis() / 1000L - 1L);
      }

      super.a = this.mr;
   }

   private void gj() {
      Item var1 = cc[indexSelect];
      this.a((int)3, (Item)var1);
   }

   private void gk() {
      if (Char.getMyChar().arrItemBag[indexSelect].isLock) {
         GameCanvas.ak.a(TextGame.jf, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      } else {
         for(int var1 = 0; var1 < cc.length; ++var1) {
            if (cc[var1] == null) {
               cc[var1] = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               super.a = super.b = null;
               this.ac();
               return;
            }
         }

         GameCanvas.ak.a(TextGame.jn, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      }

   }

   private void gl() {
      MyVector var1;
      (var1 = new MyVector()).addElement(this.nb);
      var1.addElement(this.my);
      GameCanvas.af.a(var1);
   }

   private void gm() {
      MyVector var1;
      (var1 = new MyVector()).addElement(this.mz);
      if (this.dh == 0) {
         var1.addElement(this.mq);
      } else if (this.dh == 1 && this.di >= 1 && (long)this.dl - System.currentTimeMillis() / 1000L <= 0L) {
         var1.addElement(this.mr);
      }

      GameCanvas.af.a(var1);
   }

   private static void gn() {
      try {
         Item var0;
         if ((var0 = k(3)).template.gender != 2 && var0.template.gender != Char.getMyChar().cgender) {
            GameCanvas.ak.a(TextGame.lf, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
            GameCanvas.aj = GameCanvas.ak;
         } else if (var0.template.level > Char.getMyChar().cLevel) {
            GameCanvas.ak.a(TextGame.lh, (Command1)null, new Command1(TextGame.ah, 1), (Command1)null);
            GameCanvas.aj = GameCanvas.ak;
         } else if ((var0.b() || var0.c()) && !var0.isLock) {
            GameCanvas.a(TextGame.kh, new Command1(TextGame.bh, 11051, (Object)null), new Command1(TextGame.bu, 1));
         } else if (var0.template.id != 35 && var0.template.id != 37) {
            if (var0.template.id == 514) {
               GameCanvas.am.a("Đến: ", "Lời chúc: ");
               GameCanvas.am.a("Chúc tết", new Command1(TextGame.ah, GameCanvas.instance, 8882, (Object)null), new Command1("Gửi", GameCanvas.instance, 1608, (Object)null), 0, 0);
            } else if (var0.template.id == 515) {
               GameCanvas.am.a("Đến: ", "Lời chúc: ");
               GameCanvas.am.a("Chúc tết", new Command1(TextGame.ah, GameCanvas.instance, 8882, (Object)null), new Command1("Gửi", GameCanvas.instance, 16081, (Object)null), 0, 0);
            } else {
               Service.gI().useItem(indexSelect);
            }
         } else {
            MyVector var1 = new MyVector();

            for(int var2 = 0; var2 < 3; ++var2) {
               var1.addElement(new Command1(TextGame.mm[var2][0], 11052, var0));
            }

            var1.addElement(new Command1(TextGame.mm[3][0], 11053, var0));
            var1.addElement(new Command1(TextGame.mm[4][0], 11054));
            GameCanvas.af.a(var1);
         }
      } catch (Exception var3) {
      }

   }

   private static void go() {
      if (Char.getMyChar().arrItemBag[indexSelect] != null && Char.getMyChar().arrItemBag[indexSelect].quantity > 1) {
         GameCanvas.al.a(TextGame.pl, new Command1(TextGame.bx, GameCanvas.instance, 88835, String.valueOf(indexSelect)), 1);
      }

   }

   private static void gp() {
      if (Char.getMyChar().arrItemBag[indexSelect] != null) {
         if (Char.getMyChar().arrItemBag[indexSelect].isLock) {
            InfoMe.a(TextGame.mt);
         } else {
            GameCanvas.a(TextGame.gy, new Command1(TextGame.bh, 2001), new Command1(TextGame.bu, 2002));
         }
      }

   }

   private void gq() {
      if (indexTitle == 1) {
         Item var1 = k(3);
         if (GameCanvas.j) {
            this.a(3, var1, this.ou, (Command1)null);
            return;
         }

         this.a(3, var1, (Command1)null, (Command1)null);
      }

   }

   private void gr() {
      MyVector var1;
      (var1 = new MyVector()).addElement(this.ou);
      if (Char.getMyChar().arrItemBag[indexSelect] != null) {
         Item var2 = Char.getMyChar().arrItemBag[indexSelect];
         if (Code.tudung_check(Char.getMyChar().arrItemBag[indexSelect].template.id)) {
            var1.addElement(new Command1("Tắt Tự Dùng", 109));
         } else {
            var1.addElement(new Command1("Tự Dùng", 110));
         }

         if (var2.upgrade >= 12 && var2.lvTL() == -1) {
            var1.addElement(new Command1("Dịch Chuyển", 11000807));
         }

         // Auto luyện ngọc — port NSOZ
         if (Code.isLuyenNgoc(var2)) {
            var1.addElement(new Command1("Tắt Luyện Ngọc", 11000793));
         } else if ((var2.template.id == 652 || var2.template.id == 653
                  || var2.template.id == 654 || var2.template.id == 655)
                  && var2.upgrade >= 2) {
            var1.addElement(new Command1("Luyện Ngọc", 11000792));
         }

         if (Code.check_tinhluyen(Char.getMyChar().arrItemBag[indexSelect])) {
            var1.addElement(new Command1("Tắt Tự TL", 144));
         } else if (Char.getMyChar().arrItemBag[indexSelect].lvTL() >= 0 && Char.getMyChar().arrItemBag[indexSelect].lvTL() < 9) {
            var1.addElement(new Command1("Tự TL", 143));
         }

         if (Char.getMyChar().arrItemBag[indexSelect].quantity > 1) {
            var1.addElement(new Command1("Mở all", 111));
            var1.addElement(new Command1("Mở theo sl", 149));
         }

         var1.addElement(new Command1("Bán", 131));
      }

      if (Char.getMyChar().arrItemBag[indexSelect] != null && Char.getMyChar().arrItemBag[indexSelect].quantity > 1) {
         var1.addElement(this.oy);
      }

      var1.addElement(this.ox);
      var1.addElement(new Command1(TextGame.bd, 110221));
      if (Char.getMyChar().arrItemBag[indexSelect] != null) {
         if (!Code.checkItemInNhat(Char.getMyChar().arrItemBag[indexSelect].template.id)) {
            var1.addElement(new Command1("Thêm vào ds nhặt", 145));
         } else {
            var1.addElement(new Command1("Xoá khỏi ds nhặt", 146));
         }

         if (!Code.checkItemInDel(Char.getMyChar().arrItemBag[indexSelect].template.id)) {
            var1.addElement(new Command1("Thêm vào ds del", 147));
         } else {
            var1.addElement(new Command1("Xoá khỏi ds del", 148));
         }
      }

      GameCanvas.af.a(var1);
      if (GameCanvas.g) {
    GameCanvas.af.b = 0;
}
   }

   private static void gs() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 140221));
      var0.addElement(new Command1(TextGame.bt, 140222));
      GameCanvas.af.a(var0);
   }

   private static void gt() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110201));
      var0.addElement(new Command1(TextGame.bt, 110202));
      GameCanvas.af.a(var0);
   }

   private static void gu() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110181));
      var0.addElement(new Command1(TextGame.bt, 110182));
      GameCanvas.af.a(var0);
   }

   private static void gv() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 130021));
      var0.addElement(new Command1(TextGame.bt, 130022));
      GameCanvas.af.a(var0);
   }

   private static void gw() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110161));
      var0.addElement(new Command1(TextGame.bt, 110162));
      GameCanvas.af.a(var0);
   }

   private static void gx() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110141));
      var0.addElement(new Command1(TextGame.bt, 110142));
      GameCanvas.af.a(var0);
   }

   private static void gy() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110121));
      var0.addElement(new Command1(TextGame.bt, 110122));
      GameCanvas.af.a(var0);
   }

   private static void gz() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110101));
      var0.addElement(new Command1(TextGame.bt, 110102));
      GameCanvas.af.a(var0);
   }

   private static void ha() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110081));
      var0.addElement(new Command1(TextGame.bt, 110082));
      GameCanvas.af.a(var0);
   }

   private static void hb() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.bs, 110051));
      var0.addElement(new Command1(TextGame.bt, 110052));
      GameCanvas.af.a(var0);
   }

   private static void b(byte var0) {
      Item var1 = k(var0);
      Service.gI().a(var1.typeUI, var1.indexUI, 1);
   }

   private void c(byte var1) {
      a(k(var1));
   }

   private void d(byte var1) {
      Item var2 = k(var1);
      this.a(var2.typeUI, var2);
   }

   private static void hc() {
      String var0;
      if ((var0 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.a(TextGame.jq);
      } else {
         int var3;
         try {
            var3 = Integer.parseInt(var0);
         } catch (Exception var123) {
            GameCanvas.j();
            return;
         }

         if (var3 <= 0) {
            GameCanvas.j();
         } else if (Char.getMyChar().pPoint != 0 && var3 <= Char.getMyChar().pPoint) {
            Service.gI().e(indexTitle - 1, var3);
            GameCanvas.j();
         } else {
            GameCanvas.a(TextGame.jp);
         }
      }

   }

   private static void hd() {
      String var0;
      if ((var0 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.a(TextGame.jq);
      } else {
         int var3;
         try {
            var3 = Integer.parseInt(var0);
         } catch (Exception var133) {
            GameCanvas.j();
            return;
         }

         if (Char.getMyChar().sPoint != 0 && var3 <= Char.getMyChar().sPoint) {
            Service.gI().f(Char.getMyChar().nClass.c[indexSelect].id, var3);
            GameCanvas.j();
         } else {
            GameCanvas.a(TextGame.jq);
            GameCanvas.aj = GameCanvas.ak;
         }
      }

   }

   private static void he() {
      String var0;
      if ((var0 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.a(TextGame.jv);
      } else {
         Service.gI().e(var0);
         GameCanvas.j();
      }

   }

   public final void a(int var1, Object var2) {
      if (var1 == 9999) {
         GameCanvas.instance.n();
      }

   }

   public final void al() {
      this.aj();
      aw = 3;
      cr = true;
      b(175, 200);
      int ffBefore = ff;
      if (GameCanvas.aa >= 320) {
         ff = Math.min(GameCanvas.aa - 10, 300);
         if (ff < 300) {
            ff = 300;
         }
         fe = i / 2 - ff / 2;
      }
      if (DebugLog.DEBUG) {
         ;
      }
      super.c = this.ne;
   }

   public static Npc getNpc(int paramInt) {
      Char mychar = Char.getMyChar();
      int i1 = -1;
      Npc localObject = null;

      for(int i2 = 0; i2 < vNpc.size(); ++i2) {
         Npc npc;
         if ((npc = (Npc)vNpc.elementAt(i2)) != null && paramInt == npc.npcTemplate.npcTemplateId) {
            int i3 = Res.a(mychar.cx1, mychar.cy1, npc.cx1, npc.cy1);
            if (i1 == -1 || i3 < i1) {
               i1 = i3;
               localObject = npc;
            }
         }
      }

      return localObject;
   }

   public static void am() {
      ph = new int[vMob.size()];
      pi = new int[vMob.size()];

      int var0;
      Mob var1;
      for(var0 = 0; var0 < vMob.size(); ++var0) {
         if (var0 != pg) {
            var1 = (Mob)vMob.elementAt(var0);
            int var2;
            int var3;
            if (!ey) {
               var2 = Math.abs(var1.i - fm);
               ph[var0] = var2;
               var3 = Math.abs(var1.j - fn);
               pi[var0] = var3;
            } else {
               var2 = Math.abs(var1.i - Char.getMyChar().cx1);
               ph[var0] = var2;
               var3 = Math.abs(var1.j - Char.getMyChar().cy1);
               pi[var0] = var3;
               fo = 700;
            }
         }
      }

      if (fb == 1 && Char.getMyChar().mobFocus == null && Char.getMyChar().npcFocus == null && Char.getMyChar().mobFocus == null && Char.getMyChar().statusMe != 14 && Char.getMyChar().cMP > 0 && Char.getMyChar().itemFocus == null && System.currentTimeMillis() - pf + 2000L >= 0L) {
         if (!ey && Char.getMyChar().mobFocus != null && (Char.getMyChar().cx1 < fm - fo || Char.getMyChar().cy1 > fm + fo || Char.getMyChar().cy1 < fn - fo || Char.getMyChar().cy1 > fn + fo)) {
            Char.getMyChar().cx1 = fm;
            Char.getMyChar().cy1 = fn;
         }

         for(var0 = 0; var0 < vMob.size(); ++var0) {
            if (var0 != pg && ph[var0] < fo && pi[var0] < fo && Char.getMyChar().mobFocus == null && (var1 = (Mob)vMob.elementAt(var0)).status != 0 && var1.status != 1 && var1.levelBoss != 3) {
               ServerEffect.a(141, Char.getMyChar().cx1, Char.getMyChar().cy1, 2);
               Char.getMyChar().cx1 = var1.i;
               Char.getMyChar().cy1 = var1.j;
               Char.getMyChar().statusMe = 4;
               Char.getMyChar().mobFocus = var1;
               ServerEffect.a(141, Char.getMyChar().cx1, Char.getMyChar().cy1, 2);
               Char.getMyChar().eb = var1.i;
               Char.getMyChar().ec = var1.j;
               Service.gI().b(var1.m);
               pg = var0;
               pf = System.currentTimeMillis();
            }
         }
      }

   }

   private void ao(mGraphics var1) {
      if (gu) {
         Paint.a(fe, fd, ff, fg, var1);
         a(var1, TextGame.v, false);
         od = fe + 5;
         oe = fd + 40;
         if (vList.size() == 0) {
            mFont.i.a(var1, TextGame.no, fe + ff / 2, fd + 40, 2);
            return;
         }

         var1.a(-16770791);
         var1.c(od - 2, oe - 2, ff - 6, indexSize * 3 + 8);
         b(var1);
         ba.a(vList.size(), indexSize, od, oe, ff - 3, indexSize * 3 + 4, true, 1);
         ba.a(var1, od, oe, ff - 3, indexSize * 3 + 6);
         gm = vList.size();

         for(int var4 = 0; var4 < vList.size(); ++var4) {
            Ranked var2 = null;

            try {
               var2 = (Ranked)vList.elementAt(var4);
            } catch (Exception var5) {
            }

            if (var2 != null) {
               if (av == var4) {
                  var1.a(Paint.b);
                  var1.c(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(16777215);
                  var1.b(od + 2, oe + av * indexSize + 2, ff - 15, indexSize - 4);
               } else {
                  var1.a(Paint.a);
                  var1.c(od + 2, oe + var4 * indexSize + 2, ff - 15, indexSize - 4);
                  var1.a(13932896);
                  var1.b(od + 2, oe + var4 * indexSize + 2, ff - 15, indexSize - 4);
               }

               mFont.j.a(var1, var2.b, od + (ff - 10) / 2 - ff / 4, oe + var4 * indexSize + indexSize / 2 - 10, 2);
               mFont.j.a(var1, "-", od + (ff - 10) / 2, oe + var4 * indexSize + indexSize / 2 - 10, 2);
               mFont.j.a(var1, TextGame.u + ": " + var2.a, od + (ff - 10) / 2 + ff / 4, oe + var4 * indexSize + indexSize / 2 - 10, 2);
               mFont.i.a(var1, var2.c, od + ff / 2, oe + var4 * indexSize + indexSize / 2 + 5, 2);
            }
         }
      }

   }

   private static void hf() {
      Service.gI().a((short)102, "", fp);
   }

   private void hg() {
      this.pt = true;
      Service.gI().a((short)101, "", fp);
   }

   private static void hh() {
      Short var0 = new Short((short)1);
      GameCanvas.al.a(TextGame.s, new Command1(TextGame.t, GameCanvas.instance, 1700, var0), 1);
   }

   public final void a(String var1, short var2, String var3, short var4, String var5, short var6, String var7, String var8, byte var9) {
      InfoDlg.b();
      ip = true;
      this.ja = true;
      av = 0;
      b(175, 200);
      super.a = null;
      super.b = new Command1(TextGame.t, 1701);
      super.c = new Command1(TextGame.ah, 1702);
      fp = var9;
      this.jc = var1;
      this.pk = var2;
      this.po = var3;
      this.pl = var4;
      this.pp = var5;
      this.pm = var6;
      this.pq = var7;
      this.pr = var8;
      var1 = this.pr == "" ? "" : TextGame.q + this.pr + TextGame.ka;
      var1 = "c3" + this.po + "\n" + TextGame.r + var6 + "\n" + var1 + "\n\nc0" + this.pq;
      this.jb = mFont.g.a(var1, ff - 30);
      this.ps = System.currentTimeMillis();
      this.pn = a(this.ps, this.pk);
      this.pt = false;
   }

   private static String a(long var0, int var2) {
      long var4;
      if ((var4 = (var0 + (long)(var2 * 1000) - System.currentTimeMillis()) / 1000L) <= 0L) {
         return "";
      } else {
         long var6 = var4 / 60L;
         return var6 > 0L ? (var6 < 10L ? (var4 % 60L >= 0L && var4 % 60L < 10L ? "0" + var6 + ":0" + var4 % 60L : "0" + var6 + ":" + var4 % 60L) : (var4 % 60L >= 0L && var4 % 60L < 10L ? var6 + ":0" + var4 % 60L : var6 + ":" + var4 % 60L)) : (var4 < 10L ? "0" + var4 + "s" : var4 + "s");
      }
   }

   private void hi() {
      ip = false;
      this.jc = null;
      this.jb = null;
      super.b = null;
      super.a = null;
      super.c = null;
      this.v();
   }

   private void ap(mGraphics var1) {
      if (this.jb != null && ip) {
         if (!this.pt) {
            if (this.pm > 1) {
               this.pn = a(this.ps, this.pk);
            }

            if (this.pn == "") {
               this.hg();
            }

            long var6;
            if ((var6 = (this.ps + (long)(this.pk * 1000) - System.currentTimeMillis()) / 1000L) > 8L && var6 % 5L == 0L) {
               this.hg();
            }

            if (var6 <= 10L) {
               super.b = null;
            }

            if (var6 <= 20L) {
               this.pu = mFont.a;
            } else {
               this.pu = mFont.d;
            }
         }

         b(var1);
         Paint.a(fe, fd, ff, fg, var1);
         if (this.jc != null) {
            a(var1, this.jc, cu);
         }

         od = fe + 15;
         oe = fd + 15;
         if (this.jc != null) {
            oe += 10;
         }

         this.pu.a(var1, this.pn, fe + ff / 2, oe + 12, 2);
         mFont.j.a(var1, TextGame.p, fe + ff / 2, oe + 30, 2);
         short var10001 = this.pl;
         int var10002 = fe + ff / 2;
         int var10003 = oe + 42;
         int var10004 = ff / 2;
         String var5 = this.pl + "." + this.pp + "%";
         var1.a(0);
         var1.c(var10002 - var10004 / 2, var10003, var10004, 12);
         int var10;
         if ((var10 = var10001 * var10004 / 100) < 1) {
            var10 = 1;
         }

         var1.d(var10002 - var10004 / 2, var10003, var10, 12);
         var1.a(16711680);
         var1.c(var10002 - var10004 / 2, var10003, var10004, 12);
         b(var1);
         mFont.j.a(var1, var5, fe + ff / 2, var10003, 2);
         gm = this.jb.size();
         ba.a(gm, 12, fe, oe + 48, ff, fg - 42 - (this.jc != null ? 10 : 0), true, 1);
         ba.a(var1);
         this.ol = oe + 48;
         mFont var8 = mFont.i;

         String var9;
         for(int var3 = 0; var3 < this.jb.size() && (var9 = (String)this.jb.elementAt(var3)) != null && this.jb != null && var8 != null; ++var3) {
            if (var9.startsWith("c")) {
               if (var9.startsWith("c0")) {
                  var9 = var9.substring(2);
                  var8 = mFont.i;
               } else if (var9.startsWith("c1")) {
                  var9 = var9.substring(2);
                  var8 = mFont.d;
               } else if (var9.startsWith("c2")) {
                  var9 = var9.substring(2);
                  var8 = mFont.e;
               } else if (var9.startsWith("c3")) {
                  var9 = var9.substring(2);
                  var8 = mFont.j;
               } else if (var9.startsWith("c4")) {
                  var9 = var9.substring(2);
                  var8 = mFont.a;
               } else if (var9.startsWith("c5")) {
                  var9 = var9.substring(2);
                  var8 = mFont.l;
               } else if (var9.startsWith("c6")) {
                  var9 = var9.substring(2);
                  var8 = mFont.k;
               } else if (var9.startsWith("c7")) {
                  var9 = var9.substring(2);
                  var8 = mFont.b;
               } else if (var9.startsWith("c8")) {
                  var9 = var9.substring(2);
                  var8 = mFont.m;
               } else if (var9.startsWith("c9")) {
                  var9 = var9.substring(2);
                  var8 = mFont.n;
               }
            }

            var8.a(var1, var9, fe + ff / 2, this.ol += 12, 2);
         }
      }

   }

   public final void a() {
      Code.get_code.start();
      phong.isDisconnect = false;
      TileMap.phong_ae = false;
      super.a();
   }

   public final void an() {
      this.pv = new byte[]{-1, -1, -1, -1, -1, -1};
   }

   private void hj() {
      if (GameCanvas.o[4]) {
         this.e((byte)0);
         GameCanvas.i();
      } else if (GameCanvas.o[2]) {
         this.e((byte)1);
         GameCanvas.i();
      } else if (GameCanvas.o[6]) {
         this.e((byte)2);
         GameCanvas.i();
      }

   }

   private void e(byte var1) {
      for(int var2 = 0; var2 < this.pv.length; ++var2) {
         if (var2 != this.pv.length - 1) {
            this.pv[var2] = this.pv[var2 + 1];
         } else {
            this.pv[var2] = var1;
            Service.gI().a(var1);
         }
      }

   }

   private void aq(mGraphics var1) {
      try {
         gm = 1;
         this.qa = ff;
         this.qb = fg;
         this.py = fe;
         this.pz = fd;
         this.qj = this.py + 25;
         this.qk = this.pz + 60;
         this.ql = this.qa - 50;
         this.qm = 70;
         this.qe = this.qa - 49;
         this.qf = 10;
         this.qc = GameCanvas.ac - this.qe / 2;
         this.qd = this.qk + this.qm - this.qf;
         this.qi = 18;
         this.qg = GameCanvas.ac - (this.px.size() - 1) * ((this.qi + 5) / 2);
         this.qh = this.pz + this.qb - this.qi / 2 - 5;
         Clan_ThanThu var2;
         if (this.px.size() > 0 && this.pw <= this.px.size()) {
            var2 = (Clan_ThanThu)this.px.elementAt(this.pw);
         } else {
            var2 = null;
         }

         if (var2 == null) {
            var1.a(13606712);
            var1.b(this.qj - 1, this.qk - 1, this.ql + 1, this.qm + 1);
            var1.d(this.qj, this.qk, this.ql, this.qm);
            var1.a(6425);
            var1.c(this.qj, this.qk, this.ql, this.qm);
         } else {
            mFont.e.a(var1, var2.a, GameCanvas.ac, this.pz + 35, 2);
            var1.a(13606712);
            var1.b(this.qj - 1, this.qk - 1, this.ql + 1, this.qm + 1);
            var1.d(this.qj, this.qk, this.ql, this.qm);
            var1.a(6425);
            var1.c(this.qj, this.qk, this.ql, this.qm);
            SmallImage.a(var1, var2.d, this.qj + this.ql / 2, this.qk + this.qm / 2 - 10, 0, 3);
            b(var1);
            int var3;
            if (var2.e >= 0) {
               this.qo = Res.a(var2.j, var2.e);
               if (!this.qo.equals("")) {
                  mFont.j.a(var1, var2.f + " " + this.qo, this.qj, this.qd + 15, 0);
               } else {
                  --this.qn;
                  if (this.qn <= 0) {
                     Service.gI().y();
                     this.qn = 100;
                  }
               }
            } else {
               for(var3 = 0; var3 < var2.b; ++var3) {
                  SmallImage.a(var1, 628, this.py + 95 + var3 * 12 - var2.b * 6, this.pz + 50, 0, 3);
               }

               var3 = var2.h * this.qe / var2.i;
               var1.a(2506246);
               var1.c(this.qc, this.qd, this.qe, this.qf);
               var1.a(371981);
               var1.c(this.qc, this.qd, var3, this.qf);
               var1.a(13606712);
               var1.b(this.qc, this.qd, this.qe, this.qf);
               mFont.i.a(var1, var2.h + "/" + var2.i, this.qc + this.qe / 2, this.qd, 2);

               for(int var4 = 0; var4 < var2.g.size(); ++var4) {
                  String var6 = (String)var2.g.elementAt(var4);
                  mFont.j.a(var1, var6, this.qj + this.ql / 2, this.qd + 15 + var4 * 10, 2);
               }
            }

            for(var3 = 0; var3 < this.px.size(); ++var3) {
               Clan_ThanThu var7;
               if (this.px.size() > 0 && var3 <= this.px.size()) {
                  var7 = (Clan_ThanThu)this.px.elementAt(var3);
               } else {
                  var7 = null;
               }

               if (var7 != null) {
                  var1.a(0);
                  var1.c(this.qg + var3 * (this.qi + 5) - this.qi / 2, this.qh - this.qi / 2, this.qi, this.qi);
                  SmallImage.a(var1, 154, this.qg + var3 * (this.qi + 5), this.qh, 0, 3);
                  var1.a(12281361);
                  var1.b(this.qg + var3 * (this.qi + 5) - this.qi / 2, this.qh - this.qi / 2, this.qi, this.qi);
                  SmallImage.a(var1, var7.c, this.qg + var3 * (this.qi + 5), this.qh, 0, 3);
               }
            }

            var1.a(16777215);
            var1.b(this.qg + this.pw * (this.qi + 5) - this.qi / 2, this.qh - this.qi / 2, this.qi, this.qi);
         }
      } catch (Exception var6) {
         ;
      }

   }

   public final void a(Clan_ThanThu var1) {
      this.px.addElement(var1);
   }

   public final void ao() {
      this.px.removeAllElements();
   }

   private void hk() {
      try {
         if (il && Char.getMyChar().arrItemBag[indexSelect].d()) {
            if (cj == null) {
               if (Char.getMyChar().arrItemBag[indexSelect].upgrade < 10) {
                  cj = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
                  return;
               }

               GameCanvas.ak.a(TextGame.b, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
               GameCanvas.aj = GameCanvas.ak;
               return;
            }

            if (cb == null) {
               cb = new Item[24];
            }

            for(int var1 = 0; var1 < cb.length; ++var1) {
               if (cb[var1] == null) {
                  cb[var1] = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
                  super.a = super.b = null;
                  this.ac();
                  return;
               }

               if (var1 == cb.length - 1) {
                  GameCanvas.a(TextGame.jo);
               }
            }

            return;
         }
      } catch (Exception var2) {
         GameCanvas.ak.a(TextGame.b, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
         ;
      }

   }

   private void hl() {
      Item var3;
      if (Char.getMyChar().arrItemBag[indexSelect].d()) {
         if (cj == null) {
            cj = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
         } else {
            var3 = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
            Char.getMyChar().arrItemBag[cj.indexUI] = cj;
            cj = var3;
         }

         super.a = super.b = null;
         this.ac();
      } else if (Char.getMyChar().arrItemBag[indexSelect].b()) {
         if (ci == null) {
            ci = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
         } else {
            var3 = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
            Char.getMyChar().arrItemBag[ci.indexUI] = ci;
            ci = var3;
         }

         super.a = super.b = null;
         this.ac();
      } else if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26 && Char.getMyChar().arrItemBag[indexSelect].template.type != 28) {
         GameCanvas.ak.a(TextGame.ji, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      } else {
         int var1;
         if (Char.getMyChar().arrItemBag[indexSelect].template.type == 28) {
            for(var1 = 0; var1 < ca.length; ++var1) {
               if (ca[var1] != null && ca[var1].template.type == 28) {
                  Item var2 = Char.getMyChar().arrItemBag[indexSelect];
                  Char.getMyChar().arrItemBag[indexSelect] = null;
                  int var10001 = ca[var1].indexUI;
                  Char.getMyChar().arrItemBag[var10001] = ca[var1];
                  ca[var1] = var2;
                  return;
               }
            }
         }

         for(var1 = 0; var1 < ca.length; ++var1) {
            if (ca[var1] == null) {
               ca[var1] = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               super.a = super.b = null;
               this.ac();
               return;
            }
         }

         GameCanvas.ak.a(TextGame.jo, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      }

   }

   private void o(int var1) {
      MyVector var2 = new MyVector();
      if (var1 == 0) {
         var2.addElement(this.ms);
      } else if (var1 == 1) {
         var2.addElement(this.mt);
      } else if (var1 == 2) {
         var2.addElement(this.mu);
      }

      if (ci != null && cj != null) {
         for(int var3 = 0; var3 < ca.length; ++var3) {
            if (ca[var3] != null) {
               var2.addElement(new Command1(TextGame.ev, 341));
               break;
            }
         }
      }

      GameCanvas.af.a(var2);
   }

   private void p(int var1) {
      Item var2 = cj;
      if (var1 == 1) {
         var2 = ci;
         ci = null;
      } else if (var1 == 2) {
         var2 = k(47);
         ca[indexSelect] = null;
      } else {
         cj = null;
      }

      Char.getMyChar().arrItemBag[var2.indexUI] = var2;
      super.a = super.b = null;
      this.ac();
   }

   private void hm() {
      int var3 = 0;

      for(int var1 = 0; var1 < ca.length; ++var1) {
         if (ca[var1] != null && ca[var1].template.type == 26) {
            var3 += cx[ca[var1].template.id];
         }
      }

      boolean var4 = false;
      int var2 = 0;
      if (cj != null) {
         if (de[cj.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
            var4 = true;
         }

         var2 = var3 * 100 / da[cj.upgrade];
      }

      if (var4) {
         InfoMe.a(TextGame.lm, 15, mFont.l);
      } else if (var2 > 250) {
         GameCanvas.a(TextGame.ln, new Command1(TextGame.bh, 342), new Command1(TextGame.bu, 1));
      } else if (cj != null && ci != null && ca.length > 0) {
         if (!ci.isLock) {
            GameCanvas.a(TextGame.lo, new Command1(TextGame.bh, 342), new Command1(TextGame.bu, 1));
            return;
         }

         Service.gI().a((byte)0, ci, cj, ca);
      }

   }

   private static void hn() {
      GameCanvas.j();
      if (cj != null && ci != null && ca.length > 0) {
         Service.gI().a((byte)0, ci, cj, ca);
      }

   }

   private void ar(mGraphics var1) {
      if (il) {
         if (aw == 0) {
            String[] var2 = TextGame.gj;
            GameScr var14 = this;

            try {
               Paint.a(fe, fd, ff, fg, var1);
               a(var1, var2[aw], var2.length > 1);
               od = fe + 3;
               oe = fd + 34 + indexSize;
               int var15 = fe + 74;
               int var3 = oe - indexSize - 3;
               ok = 4;
               int var7;
               int var10002;
               if (cj == null) {
                  var1.a(6425);
                  var1.c(var15 - 1, var3 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var15 + indexSize / 2, var3 + indexSize / 2, 0, 3);
               } else {
                  var14.a(var1, cj, var15, var3);
                  var10002 = var15 + 35;
                  var7 = var3 + 25;
                  GameScr var4 = var14;
                  int var8 = var14.qs[cj.upgrade][0];
                  int var9 = 0;
                  ItemOption var10 = null;
                  int var11;
                  if (cj.options != null) {
                     for(var11 = 0; var11 < cj.options.size(); ++var11) {
                        if ((var10 = (ItemOption)cj.options.elementAt(var11)).c.a == 104) {
                           var9 = var10.a;
                        }
                     }
                  }

                  var11 = 0;

                  int var18;
                  for(var18 = 0; var18 < cb.length; ++var18) {
                     Item var12;
                     if ((var12 = cb[var18]) != null) {
                        var11 += var4.qs[var12.upgrade][1];
                     }
                  }

                  var1.a(0);
                  var1.c(var10002, var7 - 5, 60, 5);
                  if ((var18 = var9 * 60 / var8) <= 0) {
                     var18 = 0;
                  } else if (var18 > 60) {
                     var18 = 60;
                  }

                  var1.a(-16711936);
                  var1.c(var10002, var7 - 5, var18, 5);
                  int var20;
                  if ((var20 = var11 * 60 / var8) >= 60 - var18) {
                     var20 = 60 - var18;
                  }

                  var1.a(-16346586);
                  var1.c(var10002 + var18, var7 - 5, var20, 5);
                  mFont.j.a(var1, var11 + var9 + "/" + var8, var10002 + 30, var7 - 5 - 15, 2);
               }

               var1.a(12281361);
               var1.b(var15, var3, indexSize, indexSize);
               var1.a(6425);
               var1.c(od - 1, oe - 1, indexSize * oj + 3, indexSize * ok + 3);

               int var5;
               for(var10002 = 0; var10002 < ok; ++var10002) {
                  for(var5 = 0; var5 < oj; ++var5) {
                     SmallImage.a(var1, 154, od + var5 * indexSize + indexSize / 2, oe + var10002 * indexSize + indexSize / 2, 0, 3);
                     var1.a(12281361);
                     var1.b(od + var5 * indexSize, oe + var10002 * indexSize, indexSize, indexSize);
                  }
               }

               for(var10002 = 0; var10002 < cb.length; ++var10002) {
                  Item var17;
                  if ((var17 = cb[var10002]) != null) {
                     int var6 = var10002 / oj;
                     var7 = var10002 - var6 * oj;
                     if (!var17.isLock) {
                        var1.a(12083);
                        var1.c(od + var7 * indexSize + 1, oe + var6 * indexSize + 1, indexSize - 1, indexSize - 1);
                     }

                     var14.a(var1, var17, od + var7 * indexSize, oe + var6 * indexSize);
                     if (var17.quantity > 1) {
                        mFont.p.a(var1, String.valueOf(var17.quantity), od + var7 * indexSize + indexSize, oe + var6 * indexSize + indexSize - mFont.p.c(), 1);
                     }
                  }
               }

               if (indexTitle == 1) {
                  var1.a(16777215);
                  var1.b(var15, var3, indexSize, indexSize);
                  return;
               }

               if (indexTitle == 2) {
                  var10002 = indexSelect / oj;
                  var5 = indexSelect - var10002 * oj;
                  var1.a(16777215);
                  var1.b(od + var5 * indexSize, oe + var10002 * indexSize, indexSize, indexSize);
                  return;
               }
            } catch (Exception var16) {
               ;
            }

            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gj);
         }
      }

   }

   private void as(mGraphics var1) {
      if (ir) {
         if (aw == 0) {
            String[] var2 = TextGame.gk;
            GameScr var9 = this;

            try {
               Paint.a(fe, fd, ff, fg, var1);
               a(var1, var2[aw], var2.length > 1);
               od = fe + 3;
               oe = fd + 34 + indexSize;
               int var10 = fe + 74;
               int var3 = oe - indexSize - 3;
               ok = 4;

               int var4;
               for(var4 = 0; var4 < var9.qp.length; ++var4) {
                  var1.a(6425);
                  var1.c(var9.qp[var4] - 1, var9.qq[var4] - 1, indexSize + 3, indexSize + 3);
                  var1.a(12281361);
                  var1.b(var9.qp[var4], var9.qq[var4], indexSize, indexSize);
                  SmallImage.a(var1, 154, var9.qp[var4] + indexSize / 2, var9.qq[var4] + indexSize / 2, 0, 3);
               }

               for(var4 = 0; var4 < cb.length; ++var4) {
                  Item var5;
                  if ((var5 = cb[var4]) != null) {
                     int var6 = var4 / oj;
                     int var7 = var4 - var6 * oj;
                     if (!var5.isLock) {
                        var1.a(12083);
                        var1.c(od + var7 * indexSize + 1, oe + var6 * indexSize + 1, indexSize - 1, indexSize - 1);
                     }

                     var9.a(var1, var5, od + var7 * indexSize, oe + var6 * indexSize);
                     if (var5.quantity > 1) {
                        mFont.p.a(var1, String.valueOf(var5.quantity), od + var7 * indexSize + indexSize, oe + var6 * indexSize + indexSize - mFont.p.c(), 1);
                     }
                  }
               }

               if (aw == 0 && var9.qr >= 0) {
                  var1.a(16777215);
                  var1.b(var9.qp[var9.qr], var9.qq[var9.qr], indexSize, indexSize);
               }

               if (indexTitle != 1) {
                  return;
               }

               var1.a(16777215);
               var1.b(var10, var3, indexSize, indexSize);
            } catch (Exception var10) {
               ;
               return;
            }
         } else if (aw == 1) {
            this.a(var1, TextGame.gk);
         }
      }

   }

   private void at(mGraphics var1) {
      if (im) {
         if (aw == 0) {
            String[] var2 = TextGame.gi;
            var1 = var1;
            GameScr var9 = this;

            try {
               ok = 3;
               Paint.a(fe, fd, ff, fg, var1);
               a(var1, var2[aw], var2.length > 1);
               od = fe + 3;
               oe = fd + 34 + indexSize;
               int var11 = fe + 45;
               int var3 = fe + 100;
               int var4 = oe - indexSize - 3;
               if (cj != null) {
                  var9.a(var1, cj, var11, var4);
               } else {
                  var1.a(6425);
                  var1.c(var11 - 1, var4 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var11 + indexSize / 2, var4 + indexSize / 2, 0, 3);
               }

               var1.a(12281361);
               var1.b(var11, var4, indexSize, indexSize);
               if (ci != null) {
                  var9.a(var1, ci, var3, var4);
               } else {
                  var1.a(6425);
                  var1.c(var3 - 1, var4 - 1, indexSize + 3, indexSize + 3);
                  SmallImage.a(var1, 154, var3 + indexSize / 2, var4 + indexSize / 2, 0, 3);
               }

               var1.a(12281361);
               var1.b(var11, var4, indexSize, indexSize);
               var1.b(var3, var4, indexSize, indexSize);
               mFont.d.a(var1, "+", var11 + indexSize + 15, var4 + indexSize / 2 - 5, 2);
               if (indexTitle == 1) {
                  if (indexSelect == 0) {
                     var1.a(16777215);
                     var1.b(var11, var4, indexSize, indexSize);
                  }

                  if (indexSelect == 1) {
                     var1.a(16777215);
                     var1.b(var3, var4, indexSize, indexSize);
                  }
               }

               int var10 = 0;

               while(true) {
                  if (var10 >= ok) {
                     if (indexTitle == 2) {
                        var10 = indexSelect / oj;
                        var11 = indexSelect - var10 * oj;
                        var1.a(16777215);
                        var1.b(od + var11 * indexSize, oe + var10 * indexSize, indexSize, indexSize);
                     }

                     int var6;
                     int var7;
                     for(var10 = 0; var10 < ca.length; ++var10) {
                        Item var12;
                        if ((var12 = ca[var10]) != null) {
                           var7 = var10 / oj;
                           var6 = var10 - var7 * oj;
                           if (!var12.isLock) {
                              var1.a(12083);
                              var1.c(od + var6 * indexSize + 1, oe + var7 * indexSize + 1, indexSize - 1, indexSize - 1);
                           }

                           SmallImage.a(var1, var12.template.iconID, od + var6 * indexSize + indexSize / 2, oe + var7 * indexSize + indexSize / 2, 0, 3);
                        }
                     }

                     if (ci != null && cj != null) {
                        var10 = 0;

                        for(var11 = 0; var11 < ca.length; ++var11) {
                           if (ca[var11] != null && ca[var11].template.type == 26) {
                              var10 += cx[ca[var11].template.id];
                           }
                        }

                        if ((var11 = var10 * 100 / da[cj.upgrade]) > df[cj.upgrade]) {
                           var11 = df[cj.upgrade];
                        }

                        if (hy) {
                           var11 = (int)((double)var11 * 1.5);
                        }

                        mFont var14 = mFont.j;
                        var6 = 0;
                        var9 = null;
                        if (cj.options != null) {
                           for(var7 = 0; var7 < cj.options.size(); ++var7) {
                              ItemOption var13;
                              if ((var13 = (ItemOption)cj.options.elementAt(var7)).c.a == 123) {
                                 var6 = var13.a;
                              }
                           }
                        } else {
                           Service.gI().c(cj.typeUI, cj.indexUI);
                        }

                        if (var6 > Char.getMyChar().xu + Char.getMyChar().yen) {
                           var14 = mFont.l;
                        }

                        var14.a(var1, TextGame.a(TextGame.gt, NinjaUtil.a(String.valueOf(var6))), od, oe + ok * indexSize + 5, 0);
                        mFont.j.a(var1, TextGame.gw + ": " + var11 + "%", od, oe + ok * indexSize + 17, 0);
                     } else {
                        for(var10 = 0; var10 < TextGame.gq.length; ++var10) {
                           mFont.i.a(var1, TextGame.gq[var10], od, oe + ok * indexSize + 5 + var10 * 12, 0);
                        }
                     }

                     if (fi == null) {
                        return;
                     }

                     SmallImage.a(var1, fi.b[fh].c, var3 + indexSize / 2 + fi.b[fh].a + 1, var4 + indexSize / 2 + 9 + fi.b[fh].b, 0, 3);
                     if (GameCanvas.w % 2 == 0 && ++fh >= fi.b.length) {
                        fh = 0;
                        fi = null;
                        break;
                     }

                     return;
                  }

                  for(var11 = 0; var11 < oj; ++var11) {
                     var1.a(6425);
                     var1.c(od + var11 * indexSize, oe + var10 * indexSize, indexSize + 3, indexSize + 3);
                     SmallImage.a(var1, 154, od + var11 * indexSize + indexSize / 2, oe + var10 * indexSize + indexSize / 2, 0, 3);
                     var1.a(12281361);
                     var1.b(od + var11 * indexSize, oe + var10 * indexSize, indexSize, indexSize);
                  }

                  ++var10;
               }
            } catch (Exception var12) {
               ;
               return;
            }
         } else if (aw == 1) {
            this.a(var1, TextGame.gi);
         }
      }

   }

   private void au(mGraphics var1) {
      if (in) {
         if (aw == 0) {
            this.a(var1, TextGame.gm, (byte)0);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gm);
         }
      }

   }

   private void av(mGraphics var1) {
      if (io) {
         if (aw == 0) {
            this.a(var1, TextGame.gn, (byte)1);
            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gn);
         }
      }

   }

   private void a(mGraphics var1, String[] var2, byte var3) {
      try {
         ok = 5;
         Paint.a(fe, fd, ff, fg, var1);
         this.a(var1, var2, false);
         var1.a(6693376);
         var1.c(fe + 3, fd + 32, 168, 140);
         var1.a(13408563);
         var1.b(fe + 3, fd + 32, 168, 140);
         int var11 = fe + 74;
         int var4 = fd + 40 + indexSize;
         if (cj != null) {
            var1.a(6425);
            var1.c(var11 - 1, var4 - 1, indexSize + 3, indexSize + 3);
            SmallImage.a(var1, 154, var11 + indexSize / 2, var4 + indexSize / 2, 0, 3);
            this.a(var1, cj, var11, var4);
            if (cj.quantity > 1) {
               mFont.p.a(var1, "" + cj.quantity, var11 + indexSize, var4 + indexSize / 2 + 6, 1);
            }

            var1.a(indexTitle == 1 ? 16777215 : 12281361);
            var1.b(var11, var4, indexSize, indexSize);
         } else {
            var1.a(6425);
            var1.c(var11 - 1, var4 - 1, indexSize + 3, indexSize + 3);
            SmallImage.a(var1, 154, var11 + indexSize / 2, var4 + indexSize / 2, 0, 3);
            var1.a(12281361);
            var1.b(var11, var4, indexSize, indexSize);
         }

         if (cj != null) {
            int var8 = 0;
            ItemOption var5 = null;
            if (cj.options != null) {
               for(int var6 = 0; var6 < cj.options.size(); ++var6) {
                  if ((var5 = (ItemOption)cj.options.elementAt(var6)).c.a == 122) {
                     var8 = var5.a;
                  }
               }
            } else {
               Service.gI().c(cj.typeUI, cj.indexUI);
            }

            String var13 = TextGame.mw;
            String var9 = var8 + TextGame.kb;
            String var12 = TextGame.o;
            if (var3 == 0) {
               var13 = TextGame.mv;
               var9 = is[cj.upgrade] + TextGame.ka;
               var12 = TextGame.n;
            }

            mFont.i.a(var1, var13, var11 + indexSize / 2, var4 + 3 * indexSize / 2 + 2, 2);
            mFont.j.a(var1, var9, var11 + indexSize / 2, var4 + 3 * indexSize / 2 + 14, 2);
            String[] var10 = mFont.i.b(var12, 130);

            for(var3 = 0; var3 < var10.length; ++var3) {
               mFont.i.a(var1, var10[var3], var11 + indexSize / 2, fd + fg - 25 + var3 * 12 - 2, 2);
            }

            return;
         }
      } catch (Exception var12) {
         ;
      }

   }

   private static void ho() {
      try {
         if (in) {
            if (Char.getMyChar().arrItemBag[indexSelect].d()) {
               cj = Char.getMyChar().arrItemBag[indexSelect];
               Char.getMyChar().arrItemBag[indexSelect] = null;
               return;
            }
         } else if (io && Char.getMyChar().arrItemBag[indexSelect].b()) {
            cj = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
            return;
         }
      } catch (Exception var1) {
         GameCanvas.ak.a(TextGame.c, (Command1)null, new Command1(TextGame.ah, 2), (Command1)null);
         GameCanvas.aj = GameCanvas.ak;
      }

   }

   private void aw(mGraphics var1) {
      if (iq) {
         if (aw == 0) {
            Item[] var3 = cb;
            String[] var2 = TextGame.gl;
            GameScr var7 = this;

            try {
               b(var1);
               var7.a(var1, var2, true);
               if (var3 == null) {
                  GameCanvas.a(fe + 90, fd + 75, var1, false);
                  mFont.e.a(var1, TextGame.y, fe + 90, fd + 90, 2);
                  return;
               }

               if (var3.length <= 30) {
                  ok = 5;
               } else if (var3.length % oj == 0) {
                  ok = var3.length / oj;
               } else {
                  ok = var3.length / oj + 1;
               }

               ba.a(ok, indexSize, od, oe, oj * indexSize, 5 * indexSize, true, 6);
               ba.a(var1, od, oe, ba.e + 2, ba.f + 2);

               int var8;
               int var9;
               for(var8 = 0; var8 < ok; ++var8) {
                  for(var9 = 0; var9 < oj; ++var9) {
                     SmallImage.a(var1, 154, od + var9 * indexSize + indexSize / 2, oe + var8 * indexSize + indexSize / 2, 0, 3);
                     var1.a(12281361);
                     var1.b(od + var9 * indexSize, oe + var8 * indexSize, indexSize, indexSize);
                  }
               }

               for(var8 = 0; var8 < var3.length; ++var8) {
                  Item var10;
                  if ((var10 = var3[var8]) != null) {
                     int var4 = var8 / oj;
                     int var5 = var8 - var4 * oj;
                     if (!var10.isLock) {
                        var1.a(12083);
                        var1.c(od + var5 * indexSize + 1, oe + var4 * indexSize + 1, indexSize - 1, indexSize - 1);
                        SmallImage.a(var1, 154, od + var5 * indexSize + indexSize / 2, oe + var4 * indexSize + indexSize / 2, 0, 3);
                     }

                     SmallImage.a(var1, var10.template.iconID, od + var5 * indexSize + indexSize / 2, oe + var4 * indexSize + indexSize / 2, 0, 3);
                  }
               }

               if (indexTitle > 0 && indexSelect >= 0) {
                  var8 = indexSelect / oj;
                  var9 = indexSelect - var8 * oj;
                  var1.a(16777215);
                  var1.b(od + var9 * indexSize, oe + var8 * indexSize, indexSize, indexSize);
                  a(od + var9 * indexSize, oe + var8 * indexSize, var1);
                  return;
               }
            } catch (Exception var10) {
            }

            return;
         }

         if (aw == 1) {
            this.a(var1, TextGame.gl);
         }
      }

   }

   private void hp() {
      for(int var1 = 0; var1 < cb.length; ++var1) {
         if (cb[var1] == null) {
            cb[var1] = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
            super.a = super.b = null;
            this.ac();
            return;
         }
      }

   }

   private void hq() {
      MyVector var1 = new MyVector();

      for(int var2 = 0; var2 < cb.length; ++var2) {
         if (cb[var2] != null) {
            var1.addElement(this.mp);
            break;
         }
      }

      if (cb.length > 0) {
         var1.addElement(new Command1(TextGame.gl[0], 403));
      }

      GameCanvas.af.a(var1);
   }

   private void hr() {
      Item var1 = k(48);
      cb[indexSelect] = null;
      Char.getMyChar().arrItemBag[var1.indexUI] = var1;
      super.a = super.b = null;
      this.ac();
   }

   private static void hs() {
      Service.gI().d(cb);
   }

   private void ax(mGraphics var1) {
      if (aw == 6) {
         var1.a(-var1.a(), -var1.b());
         Paint.a(fe, fd, ff, fg, var1);
         var1.a(Paint.a);
         a(var1, TextGame.fg[aw], true);
         b(var1);
         var1.a(0);
         var1.c(fe + 2, fd + 31, 171, fg - 34);
         var1.a(13606712);
         var1.b(fe + 3, fd + 32, 168, fg - 37);
         var1.a(Paint.a);
         var1.c(fe + 4, fd + 34, 166, fg - 39);
         int var2;
         int var3;
         if (currentCharViewInfo.cf[4] != null) {
            mFont.e.a(var1, currentCharViewInfo.cf[4].template.name, fe + 90, oe + 2, 2);
            var2 = currentCharViewInfo.cf[4].sys + 1;

            for(var3 = 0; var3 < var2; ++var3) {
               SmallImage.a(var1, 628, fe + 90 + var3 * 12 - var2 * 6, oe + 20, 0, 3);
            }
         }

         for(var2 = 0; var2 < currentCharViewInfo.cf.length - 1; ++var2) {
            if (currentCharViewInfo.cf[var2] != null) {
               this.a(var1, currentCharViewInfo.cf[var2], this.jw[var2], this.jx[var2]);
            } else {
               var1.a(6425);
               var1.c(this.jw[var2] - 1, this.jx[var2] - 1, indexSize + 3, indexSize + 3);
               mFont.k.a(var1, TextGame.kj[var2 + 24][0], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 - 10, 2);
               mFont.k.a(var1, TextGame.kj[var2 + 24][1], this.jw[var2] + indexSize / 2, this.jx[var2] + indexSize / 2 + 2, 2);
            }

            if (indexSelect == var2 && indexTitle == 1 && indexSelect < 4) {
               var1.a(16777215);
            } else {
               var1.a(12281361);
            }

            var1.b(this.jw[var2], this.jx[var2], indexSize, indexSize);
         }

         var2 = this.jw[0] + indexSize + 7;
         var3 = this.jx[0] - 5;
         var1.a(6425);
         var1.c(var2, var3, 84, 75);
         if (indexSelect == 4) {
            var1.a(16777215);
         } else {
            var1.a(12281361);
         }

         var1.b(var2, var3, 84, 75);
         if (currentCharViewInfo.mobVithu != null) {
            currentCharViewInfo.mobVithu.b(var1, var2 + 35, var3 + 55);
            currentCharViewInfo.mobVithu.a(var1, var2 + 35, var3 + 55);
         }

         int var6 = 0;
         var2 = 0;
         var3 = 0;
         int var4;
         if (currentCharViewInfo.cf[4] != null) {
            if (currentCharViewInfo.cf[4].options != null) {
               for(var4 = 0; var4 < currentCharViewInfo.cf[4].options.size(); ++var4) {
                  ItemOption var5;
                  if ((var5 = (ItemOption)currentCharViewInfo.cf[4].options.elementAt(var4)).c.a == 151) {
                     var6 = var5.a;
                  } else if (var5.c.a == 150) {
                     var2 = var5.a;
                  }
               }
            }

            var3 = currentCharViewInfo.cf[4].upgrade;
         }

         var4 = od + 5;
         int var7 = oe + 112;
         mFont.e.a(var1, TextGame.du + ": ", var4, var7, 0);
         mFont.e.a(var1, String.valueOf(var3), var4 + 70, var7, 0);
         mFont var10000 = mFont.e;
         String var10002 = TextGame.iv[2] + ": ";
         var7 += 15;
         var10000.a(var1, var10002, var4, var7, 0);
         mFont.e.a(var1, String.valueOf(var2), var4 + 70, var7, 0);
         var10000 = mFont.e;
         var10002 = TextGame.ha + ": ";
         var7 += 17;
         var10000.a(var1, var10002, var4, var7, 0);
         mFont.e.a(var1, String.valueOf(var6), var4 + 70, var7, 0);
      }

   }

   private void ht() {
      MyVector var1 = new MyVector();
      if (qt == 0) {
         var1.addElement(new Command1(TextGame.jc, 5021));
         var1.addElement(new Command1(TextGame.fg[1], 5022));
         var1.addElement(this.ne);
      } else if (qt == 1) {
         var1.addElement(new Command1(TextGame.fg[aw], 502));
         var1.addElement(new Command1(TextGame.fg[1], 5022));
         var1.addElement(this.ne);
      } else if (qt == 2) {
         var1.addElement(new Command1(TextGame.fg[aw], 502));
         var1.addElement(new Command1(TextGame.jc, 5021));
         var1.addElement(this.ne);
      }

      GameCanvas.af.a(var1);
   }

   private static void hu() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.cy, 5041));
      var0.addElement(new Command1(TextGame.cz, 5042));
      GameCanvas.af.a(var0);
   }

   private void hv() {
      if (indexTitle > 0 && indexTitle <= 4 || GameCanvas.g) {
         GameCanvas.al.a(TextGame.jw, this.ke, 1);
      }

   }

   private static void hw() {
      String var0;
      if ((var0 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.a(TextGame.jq);
      } else {
         boolean var1 = false;

         int var3;
         try {
            var3 = Integer.parseInt(var0);
         } catch (Exception var4) {
            GameCanvas.j();
            return;
         }

         if (var3 <= 0) {
            GameCanvas.j();
         } else if (Char.getMyChar().pPoint != 0 && var3 <= Char.getMyChar().pPoint) {
            Service.gI().e(indexTitle - 1, var3);
            GameCanvas.j();
         } else {
            GameCanvas.a(TextGame.jp);
         }
      }

   }

   private static void hx() {
      MyVector var0;
      (var0 = new MyVector()).addElement(new Command1(TextGame.cy, 5051));
      var0.addElement(new Command1(TextGame.cz, 5052));
      GameCanvas.af.a(var0);
   }

   private void hy() {
      if (indexTitle > 0 && indexTitle <= 4) {
         GameCanvas.al.a(TextGame.jw, this.kf, 1);
      }

   }

   private static void hz() {
      String var0;
      if ((var0 = GameCanvas.al.a.d()).trim().equals("")) {
         GameCanvas.a(TextGame.jq);
      } else {
         boolean var1 = false;

         int var3;
         try {
            var3 = Integer.parseInt(var0);
         } catch (Exception var4) {
            GameCanvas.j();
            return;
         }

         if (Char.getMyChar().sPoint != 0 && var3 <= Char.getMyChar().sPoint) {
            Service.gI().f(Char.getMyChar().nClass.c[indexSelect].id, var3);
            GameCanvas.j();
         } else {
            GameCanvas.a(TextGame.jq);
            GameCanvas.aj = GameCanvas.ak;
         }
      }

   }

   public static void npc_h(int var0) {
      Npc var1;
      if ((var1 = npc_i(var0)) != null) {
         Char.move(var1.cx1, var1.cy1);
         Char.getMyChar().npcFocus = var1;
         Service.gI().openMenu(var1.npcTemplate.npcTemplateId);
      }

   }

   public static void npc_b(int var0, int var1, int var2) {
      if (System.currentTimeMillis() < 500L) {
         phong.sleep(500L - System.currentTimeMillis());
      }

      Npc var3;
      if ((var3 = npc_i(var0)) != null) {
         Char.move(var3.cx1, var3.cy1);
         Char.getMyChar().npcFocus = var3;
         Service.gI().menu((byte)0, var0, var1, var2);
      }

   }

   public static void pickNPC(int npcId, int menu1, int menu2) {
      if (System.currentTimeMillis() < 500L) {
         phong.sleep(500L - System.currentTimeMillis());
      }

      Npc npc;
      if ((npc = npc_i(npcId)) != null) {
         Char.move(npc.cx1, npc.cy1);
         Char.getMyChar().npcFocus = npc;
         // V8 server: 1 call duy nhat (giong npc_b pattern)
         Service.gI().menu((byte) 0, npcId, menu1, menu2);
         if (FormDanhVong.DEBUG_DV) ;
      }
   }

   public static Npc npc_i(int var0) {
      Char var1 = Char.getMyChar();
      MyVector var2 = vNpc;
      int var3 = -1;
      Npc var4 = null;

      for(int var5 = 0; var5 < var2.size(); ++var5) {
         Npc var6;
         if ((var6 = (Npc)var2.elementAt(var5)) != null && var0 == var6.npcTemplate.npcTemplateId) {
            int var7 = Res.a(var1.cx1, var1.cy1, var6.cx1, var6.cy1);
            if (var3 == -1 || var7 < var3) {
               var3 = var7;
               var4 = var6;
            }
         }
      }

      return var4;
   }

   static {
      new MyVector();
      gr = false;
      gs = false;
      cl = true;
      cm = false;
      gu = false;
      cn = false;
      co = false;
      gv = false;
      gw = false;
      gx = false;
      cp = false;
      gy = false;
      gz = false;
      cq = false;
      ha = false;
      cr = false;
      hb = false;
      hc = false;
      hd = false;
      he = false;
      hf = false;
      hg = false;
      hh = false;
      hi = false;
      hj = false;
      hk = false;
      hl = false;
      hm = false;
      hn = false;
      ho = false;
      hp = false;
      hq = false;
      hr = false;
      hs = false;
      ht = false;
      hu = false;
      hv = false;
      hw = false;
      hx = false;
      hy = false;
      hz = false;
      ia = false;
      ib = false;
      ic = false;
      cs = false;
      id = false;
      ct = false;
      cu = false;
      ie = false;
      ifa = false;
      ig = false;
      ih = false;
      ip = false;
      iq = false;
      ir = false;
      is = new int[]{0, 5000, 40000, 135000, 320000, 625000, 1080000, 1715000, 2560000, 3645000, 5000000};
      jt = 0;
      ei = 0;
      eo = new MyVector();
      ep = new MyVector();
      eq = new MyVector();
      ex = false;
      ey = false;
      (GameCanvas.az = new Image[2])[0] = GameCanvas.c("/m1.png");
      GameCanvas.az[1] = GameCanvas.c("/m2.png");
      GameCanvas.ax = GameCanvas.c("/plus12.png");
      GameCanvas.ay = GameCanvas.c("/Big4.png");
      er = GameCanvas.c("/trung1.png");
      js = GameCanvas.c("/u/select.png");
      dy = GameCanvas.c("/hd/tf.png");
      es = GameCanvas.c("/eff/g132.png");
      et = GameCanvas.c("/eff/g10.png");
      eu = GameCanvas.c("/eff/g6.png");
      ev = GameCanvas.c("/eff/g99.png");
      ew = GameCanvas.c("/eff/g9.png");
      if (GameCanvas.g) {
         jl = GameCanvas.c("/hd/button.png");
         jm = GameCanvas.c("/hd/button2.png");
         jn = GameCanvas.c("/hd/hpp.png");
         jo = GameCanvas.c("/hd/mpp.png");
         jp = GameCanvas.c("/hd/right.png");
         jq = GameCanvas.c("/hd/right2.png");
         jr = GameCanvas.c("/hd/skill.png");
         eb = GameCanvas.c("/hd/btnlf.png");
         jg = GameCanvas.c("/hd/arrow.png");
         jh = GameCanvas.c("/hd/arrow2.png");
         imgAnalog1 = GameCanvas.c("/hd/analog1.png");
         imgAnalog2 = GameCanvas.c("/hd/analog2.png");
         if (gamePad == null) {
            gamePad = new GamePad();
         }
         ji = GameCanvas.c("/hd/chat.png");
         jk = GameCanvas.c("/hd/focus.png");
         jj = GameCanvas.c("/hd/menu.png");
         je = GameCanvas.c("/hd/topbar.png");
         jf = GameCanvas.c("/hd/transparent.png");
         dz = GameCanvas.c("/hd/mapborder.png");
         ea = GameCanvas.c("/hd/btnl.png");
      }

      ec = GameCanvas.c("/hd/mat.png");
      ed = GameCanvas.c("/hd/lua.png");
      byte[] var0 = RMS.a("dataVersion");
      byte[] var1 = RMS.a("mapVersion");
      byte[] var2 = RMS.a("skillVersion");
      byte[] var3 = RMS.a("itemVersion");
      if (var0 != null) {
         dq = var0[0];
      }

      if (var1 != null) {
         dr = var1[0];
      }

      if (var2 != null) {
         ds = var2[0];
      }

      if (var3 != null) {
         dt = var3[0];
      }

      jy = new Skill[3];
      jz = new Skill[5];
      fa = 0;
      lk = new int[5];
      ll = new int[5];
      lm = new int[5];
      ln = new int[5];
      lo = new int[5];
      lj = new String[5];
      lp = new int[8];

      for(int var4 = 0; var4 < 5; ++var4) {
         lo[var4] = -1;
      }

      mk = false;
      ff = 140;
      fg = 160;
      oj = 6;
      op = "Shop Online";
      new MyVector();
      fh = 0;
      fk = "";
      fl = "";
      pj = false;
      fp = 0;
      qt = 0;
   }

   private static String formatDot(long n) {
      if (n < 0) return "-" + formatDot(-n);
      String s = String.valueOf(n);
      if (s.length() <= 3) return s;
      StringBuffer sb = new StringBuffer();
      int firstGroup = s.length() % 3;
      if (firstGroup > 0) { sb.append(s.substring(0, firstGroup)); }
      for (int i = firstGroup; i < s.length(); i += 3) {
         if (sb.length() > 0) sb.append('.');
         sb.append(s.substring(i, i + 3));
      }
      return sb.toString();
   }

   private static String pad2(int n) {
      return n < 10 ? "0" + n : String.valueOf(n);
   }
}
