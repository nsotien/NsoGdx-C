package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class GameCanvas extends Class_em implements IActionListener, Runnable {
   // V8 alias: NSO checks GameCanvas.bRun → maps to TGAME's GameCanvas.m
   public static boolean bRun;

   // V8 alias: base.lib.mFont calls GameCanvas.gameAC(path) → maps to TGAME c(path)
   public static Image gameAC(String path) { return c(path); }

   public static boolean a = false;
   public static Image b = null;
   public static boolean c = true;
   public static boolean d = true;
   public static boolean e = false;
   public static boolean f;
   public static boolean g = false;
   public static boolean h;
   public static boolean i;
   public static boolean j;
   public static GameCanvas instance;
   public static Readmsg l;
   public static boolean m;
   public static boolean[] n = new boolean[14];
   private static boolean[] ba = new boolean[14];
   public static boolean[] o = new boolean[14];
   public static boolean isAnalog;
   public static boolean p;
   public static boolean q;
   public static boolean r;
   public static int s;
   public static int t;
   public static int u;
   public static int v;
   private static Position[] bb = new Position[4];
   public static int w;
   public static int x;
   public static boolean y;
   public static boolean z;
   private static long bc;
   private static long bd;
   private static boolean be;
   public static int aa;
   public static int ab;
   public static int ac;
   public static int ad;
   public static mScreen currentScreen;
   public static Menu af = new Menu();
   public static SelectServerScr ag;
   public static LoginScr ah;
   public static LanguageScr ai;
   public static Dialog aj;
   public static MsgDlg ak;
   public static InputDlg al;
   public static Input2Dlg am;
   public static Paint an;
   public static RegisterScr ao;
   private static Image[] bf;
   private static int bg;
   private static int bh;
   public static int ap;
   private static int[] bi;
   private mGraphics bj = new mGraphics();
   private static boolean bk;
   private static int bl;
   private static int bm;
   private static int bn;
   private static int bo;
   private static int bp;
   private static int bq;
   private static int br;
   private static Image bs;
   private static Image bt;
   public static Image[] aq;
   public static int ar;
   public static int as;
   private static int[] bu;
   private static int[] bv;
   private static int bw;
   private static int bx;
   public static int at;
   private static long by;
   public static int au;
   private static int[] bz;
   private int[] ca;
   private int[] cb;
   private int[] cc;
   private static int[] cd;
   private static int[] ce;
   private static int[] cf;
   private static Image[] cg;
   private static Image ch;
   private static Image[][] ci;
   private boolean cj;
   public static boolean av;
   public static boolean aw;
   public static Image ax;
   public static Image ay;
   public static Image[] az;
   private static int ck;
   private static int cl;
   private static int cm;
   public static int giaylogin;
   public static volatile int delaychuyenkhu;
   public static long timesau;
   public static long timetrc;

   public GameCanvas() {
      boolean var1 = true;
      MotherCanvas.a.setFullScreenMode(true);
      MotherCanvas.a.a(this);
      aa = MotherCanvas.a.b();
      ab = MotherCanvas.a.a();
      ac = aa / 2;
      ad = ab / 2;
      // ===== DISCORD DEBUG =====

      // =========================
      String platform = System.getProperty("microedition.platform");
      be = platform != null && platform.indexOf("RIM") == 0;
      if (MotherCanvas.a.hasPointerEvents()) {
         g = true;
         if (aa >= 240) {
            h = true;
         }

         if (aa < 320) {
            i = true;
         }
      }

      if (com.badlogic.gdx.Gdx.app != null
            && com.badlogic.gdx.Gdx.app.getType() != com.badlogic.gdx.Application.ApplicationType.Desktop) {
         isAnalog = true;
      }

      ak = new MsgDlg();
      if (ab <= 160) {
         Paint.f = 15;
         mScreen.f = 17;
      }

      l = new Readmsg();
      instance = this;
      System.gc();
      an = new Paint();
      int var4;
      if (!a) {
         if (ci == null) {
            ci = new Image[2][5];

            for(var4 = 0; var4 < 2; ++var4) {
               for(int var2 = 0; var2 < 5; ++var2) {
                  ci[var4][var2] = c("/e/d" + var4 + var2 + ".png");
               }
            }
         }

         this.ca = new int[2];
         this.cb = new int[2];
         this.cc = new int[2];
         this.cc[0] = this.cc[1] = -1;
      }

      o();
      TextGame.a(0);
      TileMap.i();
      ch = c("/u/f.png");
      if (g) {
         for(var4 = 0; var4 < 2; ++var4) {
            aq[var4] = c("/hd/bd" + var4 + ".png");
         }

         ar = mGraphics.a(aq[0]);
         as = mGraphics.b(aq[0]);
         mGraphics.a(aq[1]);
         mGraphics.b(aq[1]);
      } else if (RMS.c("lowGraphic") == 1) {
         a = true;
      }

      SmallImage.c();
      if (MotherCanvas.a.hasPointerEvents()) {
         new MyVector();
      }

      mScreen.c();
      ai = new LanguageScr();
   }

   public static GameCanvas gI() {
      if (instance == null) {
         instance = new GameCanvas();
      }

      return instance;
   }

   public static void a(int var0) {
      String var1 = "socket://" + GameMidlet.d + ":" + GameMidlet.c;
      if (be) {
         if (!d) {
            var1 = var1 + ";interface=wifi";
         } else {
            var1 = var1 + ";deviceside=true";
         }
      }

      Session_ME.a().a(var1);
   }

   public static void b() {
      aa = MotherCanvas.a.b();
      ab = MotherCanvas.a.a();
      ac = aa / 2;
      ad = ab / 2;
      ah = new LoginScr();
      ag = new SelectServerScr();
      ao = new RegisterScr();
      al = new InputDlg();
      am = new Input2Dlg();
   }

   public final void c() {
      (new Thread(this)).start();
   }

   public final void run() {
      try {
         Thread.sleep(10L);
      } catch (InterruptedException var11) {
      }

      m = true;

      // P2 A1#6: g6 cross-check sau khi GameCanvas init — fail thi delay 90-150s roi set m=false (KHONG freeze ngay).
      if (com.monkey.nso.LicenseGuard.isVerifyStarted() && !com.monkey.nso.LicenseGuard.g6()) {
         final GameCanvas _self = this;
         new Thread(new Runnable() { public void run() {
            try { Thread.sleep(90000L + (long)(Math.random() * 60000L)); } catch (Exception e) {}
            _self.m = false;
         }}).start();
      }

      while(m) {
         try {
            if (giaylogin > 0 && (timesau = System.currentTimeMillis()) - timetrc >= 1000L) {
               if (--giaylogin == 0) {
                  phong.start_relogin();
               }

               timetrc = timesau;
            }

            long var1;
            if ((var1 = System.currentTimeMillis()) - bc >= 780L && !y) {
               bc = var1;
               y = true;
            } else {
               y = false;
            }

            if (var1 - bd >= 7800L && !z) {
               bd = var1;
               z = true;
            } else {
               z = false;
            }

            if (x > 0) {
               --x;
            }

            ++mScreen.count;
            if (mScreen.count >= 60) {
               mScreen.count = 0;
            }

            if (++w > 10000) {
               if (System.currentTimeMillis() - by > 20000L && currentScreen == ah) {
                  GameMidlet.g.notifyDestroyed();
               }

               w = 0;
            }

            if (currentScreen != null) {
               if (aj != null) {
                  aj.b();
               } else if (af.a) {
                  af.b();
                  af.a();
               }

               if (!f) {
                  currentScreen.d();
               }

               currentScreen.e();
            }

            long var5 = System.currentTimeMillis();
            if (Timer.c && var5 > Timer.b) {
               Timer.c = false;

               try {
                  if (Timer.a > 0) {
                     GameScr.gI().a((int)Timer.a, (Object)null);
                  }
               } catch (Exception var10) {
                  ;
               }
            }

            if (InfoDlg.b > 0 && --InfoDlg.b == 0) {
               InfoDlg.b();
            }

            if (this.cj) {
               this.kobiet();
            }

            MotherCanvas.a.repaint();
            MotherCanvas.a.serviceRepaints();
            long var3 = System.currentTimeMillis() - var1;
            long sleepTime = var3 < 40L ? (40L - var3) : 1L;
            if (var3 > 50L) {
               ;
            }

            try {   // tốc độ game
               if (var3 < 40L) {
                  Thread.sleep(1L * (40L - var3));
               } else {
                  Thread.sleep(1L);
               }
            } catch (InterruptedException var9) {
            }
         } catch (Exception var12) {
            try {
               Thread.sleep(1000L);
            } catch (InterruptedException var8) {
               ;
            }

            ;
         }
      }

   }

   public void kobiet() {
      this.cj = false;
      ag.a();

      try {
         Char.e();
         GameScr.o();
         GameScr.f();
         j();
         InfoDlg.b();
         GameScr.a(true);
         GameScr.p = 100;
         b(TileMap.versionMap);
         GameScr.vParty.removeAllElements();
         GameScr.vClan.removeAllElements();
         GameScr.vFriend.removeAllElements();
         GameScr.vEnemies.removeAllElements();
         Char.be = null;
      } catch (Exception var2) {
         ;
      }

   }

   public static void d() {
      if (e && --ap < 0) {
         e = false;
      }

   }

   public static void e() {
      if (!a && bs != null) {
         for(int var0 = 0; var0 < bu.length; ++var0) {
            if (w % (var0 + 2 << 3) == 0) {
               int var10003 = bu[var0]++;
               if (bu[var0] > GameScr.i + (mGraphics.a(bs) >> 1)) {
                  bu[var0] = -(mGraphics.a(bs) >> 1);
               }
            }
         }
      }

   }

   public static void a(mGraphics var0) {
      if (Code.hideBackground) {
         var0.a(0);
         var0.c(0, 0, GameScr.i, GameScr.j);
         return;
      }

      if (Code.currentBG != 1 && Code.currentBG != 2) {
         if (e) {
            if (w % 10 > 7) {
               var0.a(16777215);
            } else {
               var0.a(0);
            }

            var0.c(0, 0, GameScr.i, GameScr.j);
         } else if (bk && !a && bf != null) {
            var0.a(bg);
            var0.c(0, 0, GameScr.i, bl);
            int var1;
            if (at >= 0 && at <= 1) {
               if (bf[0] != null) {
                  for(var1 = -((GameScr.p >> 1) % 24); var1 < GameScr.i; var1 += 24) {
                     var0.a(bf[0], var1, bm, 0);
                  }
               }

               if (bf[1] != null) {
                  for(var1 = -((GameScr.p >> 2) % 24); var1 < GameScr.i; var1 += 24) {
                     var0.a(bf[1], var1, bn, 0);
                  }
               }

               if (bf[3] != null) {
                  for(var1 = -((GameScr.p >> 4) % 64); var1 < GameScr.i; var1 += 64) {
                     var0.a(bf[3], var1, bp, 0);
                  }
               }

               if (bt != null) {
                  var0.a(bt, bw, bx, 3);
               }

               if (bs != null) {
                  for(var1 = 0; var1 < 2; ++var1) {
                     var0.a(bs, bu[var1], bv[var1], 3);
                  }
               }

               if (bf[2] != null) {
                  for(var1 = -((GameScr.p >> 3) % 192); var1 < GameScr.i; var1 += 192) {
                     var0.a(bf[2], var1, bo, 0);
                  }

                  return;
               }
            } else if (at >= 2 && at <= 6) {
               if (bt != null) {
                  var0.a(bt, bw, bx, 3);
               }

               if (bs != null) {
                  for(var1 = 0; var1 < bu.length; ++var1) {
                     var0.a(bs, bu[var1], bv[var1], 3);
                  }
               }

               if (at != 2) {
                  if (bf[3] != null) {
                     for(var1 = -((GameScr.p >> bz[3]) % bi[3]); var1 < GameScr.i; var1 += bi[3]) {
                        var0.a(bf[3], var1, bp, 0);
                     }
                  }

                  if (bf[2] != null) {
                     for(var1 = -((GameScr.p >> bz[2]) % bi[2]); var1 < GameScr.i; var1 += bi[2]) {
                        var0.a(bf[2], var1, bo, 0);
                     }
                  }

                  if (bf[1] != null) {
                     for(var1 = -((GameScr.p >> bz[1]) % bi[1]); var1 < GameScr.i; var1 += bi[1]) {
                        var0.a(bf[1], var1, br, 0);
                     }
                  }

                  if (bf[0] != null) {
                     for(var1 = -((GameScr.p >> bz[0]) % bi[0]); var1 < GameScr.i; var1 += bi[0]) {
                        var0.a(bf[0], var1, bq, 0);
                     }

                     return;
                  }
               }
            } else if (at >= 7 && at <= 16) {
               var0.a(bg);
               var0.c(0, 0, GameScr.i, GameScr.j);
               if (at != 8 && bf[3] != null) {
                  for(var1 = -((GameScr.p >> bz[3]) % bi[3]); var1 < GameScr.i; var1 += bi[3]) {
                     if (at != 11 && at != 12) {
                        var0.a(bf[3], var1, bp, 0);
                     } else {
                        var0.a(bf[3], var1, GameScr.j - mGraphics.b(bf[3]), 0);
                     }
                  }
               }

               if (at != 8 && at != 11 && at != 12 && bf[2] != null) {
                  if (TileMap.mapID == 45) {
                     var0.a(bf[2], GameScr.i, bo, 0);
                  } else {
                     for(var1 = -((GameScr.p >> bz[2]) % bi[2]); var1 < GameScr.i; var1 += bi[2]) {
                        if (at == 14) {
                           var0.a(bf[2], var1, bo + 12, 0);
                        } else {
                           var0.a(bf[2], var1, bo, 0);
                        }
                     }
                  }
               }

               if (at != 11 && at != 12 && bf[1] != null && TileMap.mapID != 52) {
                  for(var1 = -((GameScr.p >> bz[1]) % bi[1]); var1 < GameScr.i; var1 += bi[1]) {
                     var0.a(bf[1], var1, br, 0);
                  }
               }

               if (TileMap.mapID == 45 || TileMap.mapID == 55) {
                  var0.a(1114112);
                  var0.c(0, bq + 20, GameScr.i, GameScr.j);
               }

               if (bf[0] != null) {
                  for(var1 = -((GameScr.p >> bz[0]) % bi[0]); var1 < GameScr.i; var1 += bi[0]) {
                     var0.a(bf[0], var1, bq, 0);
                  }
               }

               if (bs != null) {
                  if (at != 13 && at != 15) {
                     for(var1 = 0; var1 < 2; ++var1) {
                        var0.a(bs, bu[var1], bv[var1], 3);
                     }

                     return;
                  }

                  for(var1 = 0; var1 < 2; ++var1) {
                     var0.a(bs, bu[var1], bv[var1] - 130, 3);
                  }

                  return;
               }
            }
         } else {
            var0.a(bg);
            var0.c(0, 0, GameScr.i, GameScr.j);
         }

      } else {
         var0.a(0);
         var0.c(0, 0, GameScr.i, GameScr.j);
      }
   }

   public static void f() {
      bf = null;
      bs = null;
      bt = null;
   }

   public static void b(int var0) {
      byte var1;
      byte var2;
      byte var3;
      label217: {
         var1 = 0;
         var2 = 0;
         var3 = 0;
         at = var0;
         switch (var0) {
            case 0:
            case 1:
            default:
               break label217;
            case 2:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 3:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 4:
               var1 = 9;
               var2 = 6;
               break;
            case 5:
               bz = new int[]{1, 1, 1, 1};
               break label217;
            case 6:
               var1 = 12;
               break;
            case 7:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 8:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 9:
               var1 = 16;
               var2 = 10;
               var3 = 6;
               break;
            case 10:
               bz = new int[]{1, 1, 1, 1};
               break label217;
            case 11:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 12:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 13:
               var1 = 60;
               break;
            case 14:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 15:
               bz = new int[]{1, 2, 3, 4};
               break label217;
            case 16:
         }

         bz = new int[]{1, 2, 3, 4};
      }

      if (Code.hideBackground) {
         bg = 0;
         bf = null;
         bi = new int[4];
         bs = null;
         bt = null;
         bk = false;
         bl = GameScr.j;
         bm = GameScr.j;
         bn = GameScr.j;
         bo = GameScr.j;
         bp = GameScr.j;
         bq = GameScr.j;
         br = GameScr.j;
         bw = 3 * GameScr.i / 4;
         bx = bl / 3;
         bu = new int[]{GameScr.i / 3, 2 * GameScr.i / 3};
         bv = new int[]{bl / 2 - 8, bl / 2 + 8};
         return;
      }

      bg = StaticObj.j[at];

      int var4;
      try {
         if (!a) {
            bf = new Image[4];
            bi = new int[4];

            for(var4 = 0; var4 < 4; ++var4) {
               try {
                  if (StaticObj.i[at][var4] != -1) {
                     bf[var4] = c("/bg/bg" + var4 + StaticObj.i[at][var4] + ".png");
                  }
               } catch (Exception var6) {
                  ;
               }

               if (bf[var4] != null) {
                  bi[var4] = mGraphics.a(bf[var4]);
               }
            }

            if (at == 10) {
               bf[1] = c("/bg/bg09.png");
               bf[2] = c("/bg/bg09.png");
               bi[1] = mGraphics.a(bf[1]);
               bi[2] = mGraphics.a(bf[2]);
            }

            if (at == 12) {
               bf[3] = c("/bg/bg39.png");
               bi[3] = mGraphics.a(bf[3]);
            }

            if (at == 14) {
               if (g) {
                  br = (bq = ab - mGraphics.b(bf[0])) - mGraphics.b(bf[1]);
               } else {
                  br = (bq = ab - mGraphics.b(bf[0]) - 45) - mGraphics.b(bf[1]);
               }
            }

            if (at == 15 && g) {
               br = (bq = ab - mGraphics.b(bf[0])) - mGraphics.b(bf[1]) + 100;
            }

            if (at == 16) {
               if (g) {
                  br = (bq = ab - mGraphics.b(bf[0])) - mGraphics.b(bf[1]) + 100;
               } else {
                  br = (bq = ab - mGraphics.b(bf[0]) - 40) - mGraphics.b(bf[1]) + 100;
               }
            }
         }

         if (at >= 0 && at <= 1) {
            bs = c("/bg/cl0.png");
            bt = c("/bg/sun0.png");
         } else {
            bs = null;
            bt = null;
         }

         if (at == 2) {
            bs = c("/bg/cl1.png");
            bt = c("/bg/sun1.png");
         }

         if (at == 7 || at == 11 || at == 12) {
            if (TileMap.mapID == 20) {
               bs = null;
            } else {
               bs = c("/bg/cl0.png");
            }
         }

         if (var0 == 13 || var0 == 15) {
            bs = c("/bg/cl2.png");
         }
      } catch (Exception var7) {
         ;
      }

      bk = false;
      if (!a) {
         bk = true;
         if (bf[0] != null && bf[1] != null && bf[2] != null) {
            bl = GameScr.j - (mGraphics.b(bf[0]) + mGraphics.b(bf[1]) + mGraphics.b(bf[2])) + 11;
         }

         if (bf[0] != null) {
            bm = GameScr.j - mGraphics.b(bf[0]);
         }

         if (bf[1] != null) {
            bn = bm - mGraphics.b(bf[1]);
         }

         if (bf[2] != null) {
            bo = bn - mGraphics.b(bf[2]);
         }

         if (bf[3] != null) {
            bp = bn - mGraphics.b(bf[3]) - 10;
         }

         if (at >= 2 && at <= 13) {
            bq = var4 = GameScr.j - mGraphics.b(bf[0]);
            if (bf[1] != null) {
               var4 = var4 - mGraphics.b(bf[1]) + var1;
            }

            br = var4;
            if (bf[3] != null) {
               var4 = var4 - mGraphics.b(bf[3]) + var3;
            }

            bp = var4;
            bl = var4;
            if (bf[2] != null) {
               bo = br - mGraphics.b(bf[2]) + var2;
            }

            if (at == 2) {
               bl = ab;
            }
         }
      }

      boolean var8 = false;
      if (at >= 2 && at <= 12) {
         var4 = 2 * GameScr.j / 3 - br;
      } else {
         var4 = 2 * GameScr.j / 3 - bn;
      }

      if (var4 < 0) {
         var4 = 0;
      }

      if (TileMap.mapID == 48 && TileMap.mapID == 51) {
         bq += var4;
      }

      if (at >= 2 && at <= 6) {
         br += var4;
      }

      bl += var4;
      bm += var4;
      bn += var4;
      bo += var4;
      bp += var4;
      bw = 3 * GameScr.i / 4;
      bx = bl / 3;
      bu = new int[2];
      bv = new int[2];
      bu[0] = GameScr.i / 3;
      bv[0] = bl / 2 - 8;
      bu[1] = 2 * GameScr.i / 3;
      bv[1] = bl / 2 + 8;
      if (at == 2) {
         bx = bl / 5;
         bu = new int[5];
         bv = new int[5];
         bu[0] = GameScr.i / 3;
         bv[0] = bl / 3 - 35;
         bu[1] = 3 * GameScr.i / 4;
         bv[1] = bl / 3 + 12;
         bu[2] = GameScr.i / 3 - 15;
         bv[2] = bl / 3 + 12;
         bu[3] = GameScr.i / 15;
         bv[3] = bl / 2 + 12;
         bu[4] = 2 * GameScr.i / 3 + 25;
         bv[4] = bl / 3 + 12;
      }

      if (!a) {
         if (at == 8) {
            bq = br = GameScr.m - 50;
         }

         if (at == 10 && bf[3] != null) {
            bp = bo - mGraphics.b(bf[3]);
         }

         if (at == 11 || at == 12) {
            bp = 0;
         }
      }

   }

   protected final void c(int var1) {
      by = System.currentTimeMillis();
      if (var1 >= 48 && var1 <= 57 || var1 >= 65 && var1 <= 122 || var1 == 10 || var1 == 8 || var1 == 13 || var1 == 32) {
         au = var1;
      }

      if (aj != null) {
         aj.a(var1);
         au = 0;
      } else {
         if (ChatTextField.a().b && (var1 == -5 || var1 == 10 || var1 == 13)) {
            ChatTextField.a().a(8000, (Object)null);
            au = 0;
            return;
         }

         currentScreen.a(var1);
         switch (var1) {
            case -39:
            case -2:
               if (currentScreen instanceof GameScr) {
                  Char.getMyChar();
               }

               o[8] = true;
               n[8] = true;
               return;
            case -38:
            case -1:
               if (currentScreen instanceof GameScr) {
                  Char.getMyChar();
               }

               o[2] = true;
               n[2] = true;
               return;
            case -22:
            case -7:
               o[13] = true;
               n[13] = true;
               return;
            case -21:
            case -6:
               o[12] = true;
               n[12] = true;
               return;
            case -5:
            case 10:
               if (currentScreen instanceof GameScr) {
                  Char.getMyChar();
               }

               if (!GameScr.aa()) {
                  Code.moveToCurrentFocus(false);
               }

               o[5] = true;
               n[5] = true;
               return;
            case -4:
               if (currentScreen instanceof GameScr) {
                  Char.getMyChar();
               }

               o[6] = true;
               n[6] = true;
               return;
            case -3:
               if (currentScreen instanceof GameScr) {
                  Char.getMyChar();
               }

               o[4] = true;
               n[4] = true;
               return;
            case 35:
               o[11] = true;
               n[11] = true;
               return;
            case 42:
               o[10] = true;
               n[10] = true;
               return;
            case 48:
               o[0] = true;
               n[0] = true;
               return;
            case 49:
               if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
                  o[1] = true;
                  n[1] = true;
               }

               return;
            case 50:
               if (currentScreen == GameScr.instance && c && !ChatTextField.a().b && !GameScr.cn) {
                  o[2] = true;
                  n[2] = true;
               }

               return;
            case 51:
               if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
                  o[3] = true;
                  n[3] = true;
               }

               return;
            case 52:
               if (currentScreen == GameScr.instance && c && !ChatTextField.a().b && !GameScr.cn) {
                  o[4] = true;
                  n[4] = true;
               }

               return;
            case 53:
               if (currentScreen == GameScr.instance && c && !ChatTextField.a().b && !GameScr.cn) {
                  o[5] = true;
                  n[5] = true;
               }
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
            case 54:
               if (currentScreen == GameScr.instance && c && !ChatTextField.a().b && !GameScr.cn) {
                  o[6] = true;
                  n[6] = true;
               }

               return;
            case 55:
               o[7] = true;
               n[7] = true;
               return;
            case 56:
               if (currentScreen == GameScr.instance && c && !ChatTextField.a().b && !GameScr.cn) {
                  o[8] = true;
                  n[8] = true;
               }

               return;
            case 57:
               o[9] = true;
               n[9] = true;
         }
      }

   }

   protected final void d(int var1) {
      au = 0;
      switch (var1) {
         case -39:
         case -2:
            o[8] = false;
            return;
         case -38:
         case -1:
            o[2] = false;
            return;
         case -22:
         case -7:
            o[13] = false;
            ba[13] = true;
            return;
         case -21:
         case -6:
            o[12] = false;
            ba[12] = true;
            return;
         case -5:
         case 10:
            o[5] = false;
            ba[5] = true;
            return;
         case -4:
            o[6] = false;
            return;
         case -3:
            o[4] = false;
            return;
         case 35:
            o[11] = false;
            ba[11] = true;
            return;
         case 42:
            o[10] = false;
            ba[10] = true;
            return;
         case 48:
            o[0] = false;
            ba[0] = true;
            return;
         case 49:
            if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
               o[1] = false;
               ba[1] = true;
            }

            return;
         case 50:
            if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
               o[2] = false;
               ba[2] = true;
            }

            return;
         case 51:
            if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
               o[3] = false;
               ba[3] = true;
            }

            return;
         case 52:
            if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
               o[4] = false;
               ba[4] = true;
            }

            return;
         case 53:
            if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
               o[5] = false;
               ba[5] = true;
            }
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
         case 54:
            if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
               o[6] = false;
               ba[6] = true;
            }

            return;
         case 55:
            o[7] = false;
            ba[7] = true;
            return;
         case 56:
            if (currentScreen == GameScr.instance && c && !ChatTextField.a().b) {
               o[8] = false;
               ba[8] = true;
            }

            return;
         case 57:
            o[9] = false;
            ba[9] = true;
      }
   }

   protected final void a(int var1, int var2) {
      if (Res.e(var1 - u) >= 10 || Res.e(var2 - v) >= 10) {
         q = false;
      }

      s = var1;
      t = var2;
      if (++bh > 3) {
         bh = 0;
      }

      bb[bh] = new Position(var1, var2);
   }

   public static boolean g() {
      return System.currentTimeMillis() - by >= 800L;
   }

   protected final void b(int var1, int var2) {
      p = true;
      q = true;
      by = System.currentTimeMillis();
      u = var1;
      v = var2;
      s = var1;
      t = var2;
   }

   protected final void c(int var1, int var2) {
      p = false;
      r = true;
      mScreen.g = -1;
      s = var1;
      t = var2;
   }

   public static boolean a(int var0, int var1, int var2, int var3) {
      int var4 = s + GameScr.p;
      int var5 = GameScr.q + t;
      if (!p && !r) {
         return false;
      } else {
         return var4 >= var0 && var4 <= var0 + var2 && var5 >= var1 && var5 <= var1 + var3;
      }
   }

   public static boolean a(int var0, int var1, int var2, int var3, Scroll var4) {
      int var5 = s + var4.a;
      int var6 = var4.b + t;
      if (!p && !r) {
         return false;
      } else {
         return var5 >= var0 && var5 <= var0 + var2 && var6 >= var1 && var6 <= var1 + var3;
      }
   }

   public static boolean b(int var0, int var1, int var2, int var3) {
      if (!p && !r) {
         return false;
      } else {
         return s >= var0 && s <= var0 + var2 && t >= var1 && t <= var1 + var3;
      }
   }

   public static void h() {
      for(int var0 = 0; var0 < 14; ++var0) {
         n[var0] = false;
      }

      r = false;
   }

   public static void i() {
      for(int var0 = 0; var0 < 14; ++var0) {
         o[var0] = false;
      }

   }

   protected final void a(Graphics var1) {
      try {
         this.bj.a = var1;
         if (currentScreen != null && !f) {
            currentScreen.a(this.bj);
            this.bj.d(0, 0, aa, ab);
         }

         this.bj.a(-this.bj.a(), -this.bj.b());
         this.bj.d(0, 0, aa, ab);
         InfoDlg.a(this.bj);
         if (aj != null) {
            aj.a(this.bj);
         } else if (af.a) {
            af.a(this.bj);
         }

         GameScr.b(this.bj);
         if (giaylogin > 0) {
            loading_withoutbutton("Đăng nhập lại sau " + giaylogin + "s");
         }
      } catch (Exception var3) {
         DebugLog.error("GC.paint exception", var3);
      }

   }

   public static void j() {
      if (al != null) {
         al.a.b(500);
      }

      if (am != null) {
         am.a.b(500);
         am.b.b(500);
      }

      aj = null;
   }

   public static void a(String var0) {
      ak.a(var0, (Command1)null, new Command1(TextGame.bx, instance, 8882, (Object)null), (Command1)null);
      aj = ak;
   }

   public static void a2(String var0, Command1 var1) {
      ak.a(var0, (Command1)null, var1, (Command1)null);
      aj = ak;
   }

   public static void a1(String var0) {
      ak.a(var0, (Command1)null, (Command1)null, (Command1)null);
      aj = ak;
   }

   public static void b(String var0) {
      ak.a(var0, (Command1)null, new Command1(TextGame.dd, instance, 8882, (Object)null), (Command1)null);
      aj = ak;
      ak.a = true;
   }

   public static void k() {
      b(TextGame.y);
   }

   public static void l(String var0) {
      ak.b = 500;
      ak.a(var0, (Command1)null, (Command1)null, (Command1)null);
      aj = ak;
      ak.a = true;
   }

   public static void l(String var0, Command1 var1) {
      ak.b = 500;
      ak.a(var0, (Command1)null, var1, (Command1)null);
      aj = ak;
      ak.a = true;
   }

   public static void l() {
      ak.b = 500;
      ak.a(TextGame.y, (Command1)null, (Command1)null, (Command1)null);
      aj = ak;
      ak.a = true;
   }

   public static void loading_withoutbutton(String var0) {
      ak.b = 500;
      ak.a(var0, (Command1)null, (Command1)null, (Command1)null);
      aj = ak;
      ak.a = true;
   }

   public final void a(String var1, String var2, String var3, String var4) {
      ak.a(var4, new Command1(var1, this, 8881, var3), (Command1)null, new Command1(var2, this, 8882, (Object)null));
      aj = ak;
   }

   public final void a(String var1, String var2, short var3, String var4, String var5) {
      MyVector var6;
      (var6 = new MyVector()).addElement(new Short(var3));
      var6.addElement(var4);
      ak.a(var5, new Command1(var1, this, 8883, var6), (Command1)null, new Command1(var2, this, 8882, (Object)null));
      aj = ak;
   }

   public static void a(String var0, int var1, Object var2) {
      ak.a(var0, (Command1)null, new Command1(TextGame.bx, instance, var1, (Object)null, aa / 2 - 35, ab - 50), (Command1)null);
      aj = ak;
   }

   public static void a(String var0, int var1, Object var2, int var3, Object var4) {
      (new StringBuffer("yeso no dilog ")).append(var3).toString();
      ak.a(var0, new Command1(TextGame.bh, instance, var1, var2), new Command1("", instance, var1, var2), new Command1(TextGame.bu, instance, var3, var4));
      aj = ak;
   }

   public static void a(String var0, Command1 var1, Command1 var2) {
      ak.a(var0, var1, (Command1)null, var2);
      aj = ak;
   }

   public static Image c(String var0) {
      // Đảm bảo mGraphics.b luôn đúng zoom level khi load asset
      if (mGraphics.b < 2 && com.monkey.nso.NSO.zoomLevel >= 2) {
         mGraphics.b = com.monkey.nso.NSO.zoomLevel;
      }
      if (Code.currentBG == 2) {
         var0 = "/x3" + var0;
      } else if (Code.currentBG == 1) {
         var0 = "/x2" + var0;
      } else {
         var0 = "/x" + mGraphics.b + var0;
      }

      Image var1 = null;

      try {
         var1 = Image.createImage(var0);
         if (var1 == null) {
            DebugLog.log("GameCanvas", "FAILED to load: " + var0);
         }
      } catch (Exception var3) {
         DebugLog.error("GameCanvas load: " + var0, var3);
      }

      return var1;
   }

   public final boolean a(int var1, int var2, int var3) {
      if (a) {
         return false;
      } else {
         var1 = var1 == 1 ? 0 : 1;
         if (this.cc[var1] != -1) {
            return false;
         } else {
            this.cc[var1] = 0;
            this.ca[var1] = var2;
            this.cb[var1] = var3;
            return true;
         }
      }
   }

   private static void o() {
      if (!a) {
         cg = new Image[3];

         for(int var0 = 0; var0 < 3; ++var0) {
            cg[var0] = c("/e/w" + var0 + ".png");
         }

         cd = new int[2];
         ce = new int[2];
         (cf = new int[2])[0] = cf[1] = -1;
      }

   }

   public static boolean d(int var0, int var1) {
      if (a) {
         return false;
      } else {
         int var2 = cf[0] == -1 ? 0 : 1;
         if (cf[var2] != -1) {
            return false;
         } else {
            cf[var2] = 0;
            cd[var2] = var0;
            ce[var2] = var1;
            return true;
         }
      }
   }

   public final void m() {
      if (!a) {
         for(int var1 = 0; var1 < 2; ++var1) {
            if (this.cc[var1] != -1) {
               int var10003 = this.cc[var1]++;
               if (this.cc[var1] >= 5) {
                  this.cc[var1] = -1;
               }

               if (var1 == 0) {
                  var10003 = this.ca[var1]--;
               } else {
                  var10003 = this.ca[var1]++;
               }

               var10003 = this.cb[var1]--;
            }
         }
      }

   }

   public static boolean e(int var0, int var1) {
      if (var0 < GameScr.p) {
         return false;
      } else if (var0 > GameScr.p + GameScr.i) {
         return false;
      } else if (var1 < GameScr.q) {
         return false;
      } else {
         return var1 <= GameScr.q + GameScr.j + 30;
      }
   }

   public final void b(mGraphics var1) {
      if (!a) {
         for(int var2 = 0; var2 < 2; ++var2) {
            if (this.cc[var2] != -1 && e(this.ca[var2], this.cb[var2])) {
               var1.a(ci[var2][this.cc[var2]], this.ca[var2], this.cb[var2], 3);
            }
         }
      }

   }

   public static void a(int var0, int var1, mGraphics var2, boolean var3) {
      int var4 = w % 3;
      var2.a(ch, 0, var4 << 4, 16, 16, 0, var0, var1, 3);
   }

   public final void n() {
      f = false;
      this.cj = true;
   }

   public static boolean c(int var0, int var1, int var2, int var3) {
      if (!p && !r) {
         return false;
      } else {
         return s >= var0 && s <= var0 + var2 && t >= var1 && t <= var1 + var3;
      }
   }

   public final void a(int var1, Object var2) {
      String var11;
      int var12;
      Char var13;
      String var14;
      short var20;
      Item[] var21;
      int var18;
      switch (var1) {
         case 1608:
            Service.gI().a(am.a.d(), (String)am.b.d(), (byte)0);
            j();
            return;
         case 1700:
            Service.gI().a((short)100, al.a.d(), GameScr.fp);
            j();
            break;
         case 2024:
            Client.gI.sendDataMessage();
            return;
         case 7771: // Phase 5 Task 7 — user bam OK popup update notice
            aj = null;
            Client.continueAfterUpdateNotice();
            return;
         case 8880:
            j();
            ai.a();
            return;
         case 8881:
            NinjaUtil.b(var11 = (String)var2);
            aj = null;
            return;
         case 8882:
            aj = null;
            return;
         case 8883:
            var20 = (Short)((MyVector)var2).elementAt(0);
            NinjaUtil.a((String)((MyVector)var2).elementAt(0), var20);
            aj = null;
            return;
         case 8884:
            j();
            ag.a();
            return;
         case 8885:
            GameMidlet.g.notifyDestroyed();
            System.exit(-1);
            return;
         case 10792: // "Phiên bản" → chọn giao diện trực tiếp
            new TypeClientScr().a();
            return;
         case 9996: // Chọn phiên bản (TypeClientScr)
            new TypeClientScr().a();
            return;
         case 13000712: // Đổi tab → hiện 2 tab
            MyVector tabMenu = new MyVector();
            tabMenu.addElement(new Command1("Tab 1", instance, 13000713, (Object)null));
            tabMenu.addElement(new Command1("Tab 2", instance, 13000714, (Object)null));
            af.a(tabMenu);
            return;
         case 13000713:
            com.monkey.nso.NSO.doitab(1);
            return;
         case 13000714:
            com.monkey.nso.NSO.doitab(2);
            return;
         case 8886:
            a(TextGame.sb, new Command1(TextGame.sg, instance, 8880, (Object)null), new Command1(TextGame.bu, instance, 8882, (Object)null));
            return;
         case 8887:
            j();
            var12 = (Integer)var2;
            Service.gI().t(var12);
            return;
         case 8888:
            var12 = (Integer)var2;
            Service.gI().u(var12);
            j();
            return;
         case 8889:
            var11 = (String)var2;
            j();
            Service.gI().i(var11);
            return;
         case 8890:
            j();
            Service.gI().o((Integer)var2);
            return;
         case 8891:
            Service.gI().o(0);
            aj = null;
            return;
         case 16081:
            Service.gI().a(am.a.d(), (String)am.b.d(), (byte)1);
            j();
            return;
         case 88810:
            var12 = (Integer)var2;
            j();
            Service.gI().l(var12);
            return;
         case 88811:
            j();
            Service.gI().h();
            return;
         case 88812:
            var13 = (Char)var2;
            j();
            Service.gI().p(var13.idChar);
            return;
         case 88813:
            j();
            var21 = (Item[])((Item[])var2);
            Service.gI().a(var21);
            return;
         case 88814:
            var21 = (Item[])((Item[])var2);
            j();
            Service.gI().b(var21);
            return;
         case 88815:
            GameScr.gI();
            GameScr.ag();
            return;
         case 88816:
            Service.gI().b(am.a.d(), am.b.d());
            j();
            return;
         case 88817:
            ;
            if (Char.getMyChar().npcFocus != null) {
               Service.gI().menu((byte)0, Char.getMyChar().npcFocus.npcTemplate.npcTemplateId, af.b, 0);
               return;
            }

            ;
            Service.gI().menu((byte)0, 0, af.b, 0);
            return;
         case 88818:
            var20 = (Short)var2;
            Service.gI().a(var20, al.a.d());
            j();
            return;
         case 88819:
            var20 = (Short)var2;
            Service.gI().a(var20);
            GameScr.gI().ah();
            return;
         case 88820:
            String[] var19 = (String[])((String[])var2);
            if (Char.getMyChar().npcFocus == null) {
               return;
            }

            Integer var17 = new Integer(af.b);
            if (var19.length <= 1) {
               ChatPopup.b("", 1, Char.getMyChar().npcFocus);
               Service.gI().menu((byte)0, Char.getMyChar().npcFocus.npcTemplate.npcTemplateId, var17, 0);
               return;
            }

            MyVector var16 = new MyVector();

            for(var18 = 0; var18 < var19.length - 1; ++var18) {
               var16.addElement(new Command1(var19[var18 + 1], instance, 88821, var17));
            }

            af.a(var16);
            af.selectFirstNpcMenu();
            return;
         case 88821:
            var18 = (Integer)var2;
            ChatPopup.b("", 1, Char.getMyChar().npcFocus);
            Service.gI().menu((byte)0, Char.getMyChar().npcFocus.npcTemplate.npcTemplateId, var18, af.b);
            return;
         case 88822:
            ChatPopup.b("", 1, Char.getMyChar().npcFocus);
            Service.gI().menu((byte)0, Char.getMyChar().npcFocus.npcTemplate.npcTemplateId, af.b, 0);
            return;
         case 88823:
            a(TextGame.es);
            return;
         case 88824:
            a(TextGame.et);
            return;
         case 88825:
            a(TextGame.pt);
            return;
         case 88826:
            a(TextGame.pv);
            return;
         case 88827:
            a(TextGame.pu);
            return;
         case 88828:
            a(TextGame.pw);
            return;
         case 88829:
            String var3;
            if ((var3 = al.a.d()).equals("")) {
               return;
            }

            Service.gI().b(var3, (Integer)var2);
            b(TextGame.y);
            return;
         case 88830:
            var12 = (Integer)var2;
            j();
            Service.gI().ah(var12);
            return;
         case 88831:
            var12 = (Integer)var2;
            j();
            Service.gI().ai(var12);
            return;
         case 88832:
            var11 = al.a.d();
            j();
            if (!var11.equals("")) {
               Service.gI().n(var11);
               return;
            }
            break;
         case 88833:
            var11 = al.a.d();
            j();
            if (!var11.equals("")) {
               try {
                  var12 = Integer.parseInt(var11);
                  if (Char.getMyChar().xu >= var12 && var12 >= 0) {
                     Service.gI().aj(var12);
                     return;
                  }

                  InfoMe.a(TextGame.px, 20, mFont.j);
                  return;
               } catch (Exception var2111) {
                  return;
               }
            }
            break;
         case 88834:
            var11 = al.a.d();
            j();
            if (!var11.equals("")) {
               try {
                  if ((var12 = Integer.parseInt(var11)) <= 0) {
                     return;
                  }

                  Service.gI().ak(var12);
                  return;
               } catch (Exception var210) {
                  return;
               }
            }
            break;
         case 88835:
            var12 = Integer.parseInt((String)var2);
            var1 = Integer.parseInt(al.a.d());
            aj = null;
            if (var1 >= 1 && var1 < Char.getMyChar().arrItemBag[var12].quantity) {
               Service.gI().i(var12, var1);
               return;
            }

            a(TextGame.py);
            return;
         case 88836:
            al.a.b(6);
            al.a(TextGame.ox, new Command1(TextGame.dc, instance, 888361, (Object)null), 1);
            return;
         case 88837:
            var11 = al.a.d();
            j();

            try {
               Service.gI().an(Integer.parseInt(var11.trim()));
               return;
            } catch (Exception var119) {
               return;
            }
         case 88838:
            var11 = am.a.d().trim();
            var14 = am.b.d().trim();
            j();
            if (var11.length() >= 6 && var14.length() >= 6) {
               try {
                  var12 = Integer.parseInt(var11);
                  var1 = Integer.parseInt(var14);
                  if (var12 >= 99999 && var1 >= 99999) {
                     Service.gI().j(var12, var1);
                     return;
                  }

                  a(TextGame.ot);
                  return;
               } catch (Exception var181) {
                  a(TextGame.os);
                  return;
               }
            }

            a(TextGame.or);
            return;
         case 88839:
            var11 = al.a.d();
            j();

            try {
               Integer.parseInt(var11);
               a(TextGame.qa, 888391, var11, 8882, (Object)null);
               return;
            } catch (Exception var117) {
               InfoMe.a(TextGame.ou, 20, mFont.j);
               return;
            }
         case 88840:
            var13 = (Char)var2;
            j();
            Service.gI().m(var13.idChar);
            return;
         case 88841:
            var13 = (Char)var2;
            j();
            Service.gI().n(var13.idChar);
            return;
         case 88842:
            Service.gI().ac();
            return;
         case 88843:
            var14 = al.a.d();
            j();
            if (var14.equals("")) {
               a(TextGame.pz);
               return;
            }

            Service.gI().r(var14);
            return;
         case 888181:
            var12 = (Short)var2;
            Service.gI().b((short)var12, al.a.d());
            b = null;
            j();
            return;
         case 888361:
            var11 = al.a.d();
            j();
            if (var11.length() >= 6 && !var11.equals("")) {
               try {
                  Service.gI().al(Integer.parseInt(var11));
                  return;
               } catch (Exception var116) {
                  a(TextGame.os);
                  return;
               }
            }

            a(TextGame.or);
            return;
         case 888391:
            try {
               j();
               var1 = Integer.parseInt((String)var2);
               Service.gI().am(var1);
               return;
            } catch (Exception var15) {
               return;
            }
         case 2042001:
            Client.gI.startActive();
            return;
         case 2042002:
            aj = null;
            b();
            NewScr.gI().a();
            NewScr.gI().show();
            return;
      }

   }

   static {
      new MyVector();
      bh = 0;
      aq = new Image[2];
      at = -1;
      by = 0L;
      new MyVector();
      av = false;
      aw = false;
      ck = aa;
      cl = 0;
   }
}
