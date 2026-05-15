package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import base.game2.screen.ScreenManager;
import base.game2.screen.ScreenQLTK;

public final class SelectServerScr extends mScreen implements IActionListener {
   private int l;
   private int m;
   private int n;
   private int o;
   private int p = -1;
   private static String[] q;
   public static String h = RMS.b("acc");
   public static String i = RMS.b("pass");
   public static String j = "";
   public static String k = "";
   private static Command1 r = null;
   private static Command1 s = null;
   private static Command1 t = null;
   private static Command1 u = null;
   private static Command1 v = null;
   private static Command1[][] w = (Command1[][])null;
   private static int x;

   public static void f() {
      String savedName = RMS.b("serverName");
      int found = -1;
      if (savedName != null && !savedName.isEmpty()) {
         for (int i = 0; i < GameMidlet.l.length; i++) {
            if (GameMidlet.l[i].equals(savedName)) {
               found = i;
               break;
            }
         }
      }
      if (found < 0) {
         if ((x = RMS.c("indServer")) >= 0 && x <= GameMidlet.l.length - 1) {
            found = x;
         } else {
            found = 0;
         }
      }
      applyServer(found);
   }

   private static void applyServer(int var0) {
      if (Session_ME.a().b()) {
         Session_ME.a().c();
      }
      x = var0;
      RMS.a("indServer", var0);
      // P3D N2 lazy fetch
      Client.ensureServerLoaded(x);
      GameMidlet.d = GameMidlet.m[x];
      GameMidlet.c = GameMidlet.n[x];
      GameMidlet.h = GameMidlet.o[x];
      TextGame.a(0);
      if (GameCanvas.af != null) {
         GameCanvas.af.b = GameMidlet.q[x];
      }
   }

   public static void b(int var0) {
      applyServer(var0);
      RMS.a("serverName", GameMidlet.l[x]);
   }

   public final void a() {
      // Tự động set typeClient theo tab 1 (tránh popup khi đổi tab)
      if (RMS.c("typeClient") < 0) {
         int tab1Type = base.game1.RMS.c("typeClient");
         RMS.a("typeClient", tab1Type >= 0 ? tab1Type : com.monkey.nso.NSO.enabledClientTypes[0]);
      }
      GameScr.j = GameCanvas.ab;
      if (GameCanvas.at == 2) {
         GameCanvas.b(0);
      } else {
         GameCanvas.b(TileMap.versionMap);
      }

      super.a();
      if (GameScr.instance != null) {
         GameScr.instance = null;
      }

      if ((TileMap.versionMap = (byte)((int)(System.currentTimeMillis() % 9L))) == 5 || TileMap.versionMap == 6) {
         TileMap.versionMap = 4;
      }

      GameScr.a(true);
      GameScr.p = 100;
      this.l = 170;
      this.m = 175;
      if (GameCanvas.aa == 128 || GameCanvas.ab <= 208) {
         this.l = 126;
         this.m = 160;
      }

      // Tính height động theo số dòng (4+1 hoặc 5+1, cộng dòng "+ Thêm SV").
      int menuRows = (h.equals("") && j.equals("")) ? 5 : 6;
      int needM = 50 + menuRows * 35 + 14;
      if (this.m < needM) this.m = needM;

      this.n = GameCanvas.aa / 2 - this.l / 2;
      this.o = GameCanvas.ab / 2 - this.m / 2;
      if (GameCanvas.ab <= 250) {
         this.o -= 10;
      }
      int bottomLimit = GameCanvas.ab - 30;
      if (this.o + this.m > bottomLimit) {
         this.o = bottomLimit - this.m;
         if (this.o < 4) this.o = 4;
      }

      super.c = new Command1("Thoát", GameCanvas.instance, 8885, (Object)null);
      super.a = null;
      super.b = new Command1("QLTK", this, 2006, (Object)null);
      this.p = -1;
      if (!GameCanvas.g) {
         this.p = 0;
      }

      if (GameCanvas.g && GameCanvas.aa >= 320) {
         super.c.f = GameCanvas.aa / 2 + 88;
      }

      if (r == null) {
         r = new Command1(GameCanvas.g ? "" : TextGame.bx, this, 1000, (Object)null);
         s = new Command1(GameCanvas.g ? "" : TextGame.bx, this, 1001, (Object)null);
         u = new Command1(GameCanvas.g ? "" : TextGame.bx, this, 1002, (Object)null);
         t = new Command1(GameCanvas.g ? "" : TextGame.bx, this, 1003, (Object)null);
         Command1 doiTabCmd = new Command1(GameCanvas.g ? "" : TextGame.bx, GameCanvas.instance, 13000712, (Object)null);
         // [FIX 3] Nút thêm server tự thêm — action 2007
         Command1 themSvCmd = new Command1(GameCanvas.g ? "" : TextGame.bx, this, 2007, (Object)null);
         w = new Command1[][]{{r, s, u, doiTabCmd, themSvCmd}, {t, r, s, u, doiTabCmd, themSvCmd}};
      }

      if ((h == null || h.equals("")) && j.equals("")) {
         q = new String[]{TextGame.sc, TextGame.se, TextGame.sf, "Đổi tab", "+ Thêm SV"};
      } else {
         q = new String[]{TextGame.sd, TextGame.sc, TextGame.se, TextGame.sf, "Đổi tab", "+ Thêm SV"};
      }

      f();

      if (RMS.b("random") == null) {
         RMS.a("random", h());
      }

   }

   public final void a(mGraphics var1) {
      var1.a(0);
      var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
      GameCanvas.a(var1);
      if (LoginScr.h != null) {
         var1.a(LoginScr.h, GameCanvas.ac - LoginScr.h.getWidth() / 2, this.o + 10 - LoginScr.h.getHeight() / 2, 0);
      }
      if (!GameCanvas.g && GameCanvas.af.b == -1) {
         GameCanvas.af.b = 0;
      }

      int var2 = this.o + 50;

      for(int var3 = 0; var3 < q.length; ++var3) {
         var1.a(Paint.c);
         var1.c(this.n + 10, var2 + var3 * 35, this.l - 20, 28);
         Paint.b(this.n + 10, var2 + var3 * 35, this.l - 20, 28, var1);
         if (var3 == this.p) {
            var1.a(Paint.b);
            var1.c(this.n + 10, var2 + var3 * 35, this.l - 20, 28);
            Paint.b(this.n + 10, var2 + var3 * 35, this.l - 20, 28, var1);
         }

         if (var3 < q.length) {
            String var4;
            if (h.equals("") && j.equals("")) {
               if (var3 == 2) {
                  var4 = GameMidlet.l[RMS.c("indServer")];
                  mFont.e.a(var1, q[var3] + var4, this.n + this.l / 2, var2 + var3 * 35 + 8, 2);
               } else {
                  mFont.e.a(var1, q[var3], this.n + this.l / 2, var2 + var3 * 35 + 8, 2);
               }
            } else if (var3 == 0) {
               mFont.e.a(var1, q[var3] + (!j.equals("") ? ": " + j : (h.startsWith("tmpusr") ? "" : ": " + h)), this.n + this.l / 2, var2 + var3 * 35 + 8, 2);
            } else if (var3 == 3) {
               var4 = GameMidlet.l[RMS.c("indServer")];
               mFont.e.a(var1, q[var3] + var4, this.n + this.l / 2, var2 + var3 * 35 + 8, 2);
            } else {
               mFont.e.a(var1, q[var3], this.n + this.l / 2, var2 + var3 * 35 + 8, 2);
            }
         }
      }

      if (GameCanvas.aj == null) {
         Paint.a(var1, super.a, super.b, super.c);
      }

      super.a(var1);
   }

   public final void d() {
      if (h.equals("") && j.equals("")) {
         if (this.p > -1 && this.p < w[0].length) {
            v = w[0][this.p];
         }
      } else if (this.p > -1 && this.p < w[1].length) {
         v = w[1][this.p];
      }

      if (++GameScr.p > GameCanvas.aa * 3 + 100) {
         GameScr.p = 100;
      }

      super.d();
   }

   public final void e() {
      if (!GameCanvas.n[2] && !GameCanvas.n[4]) {
         if (GameCanvas.n[8] || GameCanvas.n[6]) {
            ++this.p;
            if (this.p > q.length - 1) {
               this.p = 0;
            }
         }
      } else {
         --this.p;
         if (this.p < 0) {
            this.p = q.length - 1;
         }
      }

      if (GameCanvas.r && GameCanvas.b(this.n + 10, this.o + 45, this.l - 10, q.length * 35)) {
         if (GameCanvas.q) {
            this.p = (GameCanvas.t - (this.o + 45)) / 35;
         }

         if (h.equals("") && j.equals("")) {
            if (this.p > -1 && this.p < w[0].length) {
               w[0][this.p].a();
            }
         } else if (this.p > -1 && this.p < w[1].length) {
            w[1][this.p].a();
         }
      }

      // Phím Enter (n[5] = KEY_FIRE -5/10) = thực hiện menu item đang highlight.
      // Tiêu thụ TRƯỚC super.e() để parent không fire super.b (= QLTK).
      // KHÔNG guard !GameCanvas.g vì PC iOS V8 có g=true vẫn nhận keyboard Enter.
      if (GameCanvas.n[5] && v != null) {
         v.a();
         GameCanvas.n[5] = false;
      }
      super.e();
      GameCanvas.h();
   }

   private void i() {
      if (!Session_ME.a().f) {
         GameCanvas.a(5);
      }

      GameCanvas.k();
   }

   public static boolean g() {
      return h != null && (h.startsWith("tmpusr") || h.equals(""));
   }

   public static String h() {
      String var0 = "";

      for(int var1 = 0; var1 < 12; ++var1) {
         String var2 = Integer.toString(Res.d(0, 9));
         var0 = var0 + var2;
      }

      return var0;
   }

   public final void a(int var1, Object var2) {
      if (var1 >= 20000) {
         if (Session_ME.a().b()) {
            Session_ME.a().c();
         }

         int var3 = var1 - 20000;
         GameCanvas.af.a = false;
         // P3D N2 lazy fetch
         Client.ensureServerLoaded(var3);
         GameMidlet.d = GameMidlet.m[var3];
         GameMidlet.c = GameMidlet.n[var3];
         GameMidlet.h = GameMidlet.o[var3];
         RMS.a("indServer", var3);
         RMS.a("serverName", GameMidlet.l[var3]);
         GameCanvas.af.b = var3;
      } else {
         switch (var1) {
            case 2006:
               ScreenManager.showOnGL(new Runnable() {
                  public void run() {
                     if (ScreenManager.screenQLTK == null) {
                        ScreenManager.screenQLTK = new ScreenQLTK();
                     }
                     ScreenManager.show(ScreenManager.screenQLTK);
                  }
               });
               return;
            case 2007:
               // [FIX 3] Mở màn quản lý server tự thêm (dùng chung file Nso/SharedCustomServers)
               ScreenManager.showOnGL(new Runnable() {
                  public void run() {
                     if (ScreenManager.screenCustomServer == null) {
                        ScreenManager.screenCustomServer = new base.game2.screen.ScreenCustomServer();
                     }
                     ScreenManager.show(ScreenManager.screenCustomServer);
                  }
               });
               return;
            case 1000:
               if (g() && !h.equals("")) {
                  GameCanvas.a(TextGame.sb, new Command1(TextGame.sd, this, 10001, (Object)null), new Command1(TextGame.bu, GameCanvas.instance, 8882, (Object)null));
                  return;
               }

               this.i();
               Service.gI().login("-1", "12345", "2.5.1");
               return;
            case 1001:
               if (g() && !h.equals("") && j.equals("")) {
                  GameCanvas.a(TextGame.sb, new Command1(TextGame.sg, this, 10004, (Object)null), new Command1(TextGame.bu, GameCanvas.instance, 8882, (Object)null));
                  return;
               }

               GameCanvas.ah.a();
               return;
            case 1002:
               SelectServerScr var4 = this;
               MyVector var5 = new MyVector();

               for(int var6 = 0; var6 < GameMidlet.l.length; ++var6) {
                  var5.addElement(new Command1(GameMidlet.l[var6], var4, var6 + 20000, (Object)null));
               }

               GameCanvas.af.a(var5);
               if (RMS.c("indServer") != -1 && !GameCanvas.g) {
                  GameCanvas.af.b = GameMidlet.q[RMS.c("indServer")];
               }

               return;
            case 1003:
               this.i();
               if (!j.equals("")) {
                  h = j;
                  i = k;
                  j = "";
                  k = "";
                  RMS.a("acc", h);
                  RMS.a("pass", i);
               }

               Service.gI().login(h, i, "2.5.1");
               return;
            case 10001:
               this.i();
               Service.gI().login("-1", "12345", "2.5.1");
               if (!j.equals("")) {
                  h = j;
                  i = k;
                  j = "";
                  k = "";
                  RMS.a("acc", h);
                  RMS.a("pass", i);
                  return;
               }
            default:
               return;
            case 10004:
               GameCanvas.aj = null;
               GameCanvas.ah.a();
         }
      }
   }

   static {
      if (h == null) {
         h = "";
      }

      if (i == null) {
         i = "";
      }
   }
}
