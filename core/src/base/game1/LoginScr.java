package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class LoginScr extends mScreen implements IActionListener {
   private TField j;
   private TField k;
   private TField l;
   private TField m;
   private static LoginScr n;
   private int o;
   private int p;
   private int q;
   private int r;
   private boolean s = false;
   private boolean t = false;
   private Command1 u;
   private Command1 v;
   private Command1 w;
   private Command1 x;
   public static Image h;
   private int y;
   private String[] z;
   private int aa = -1;
   private int ab = 2;
   private int ac = 0;
   private int ad = -40;
   private int ae = 1;
   public static boolean i;
   private String af = "";
   public static String version = "2.5.1";

   public final void a() {
      if (RMS.b("random") == null) {
         RMS.a("random", SelectServerScr.h());
      }

      this.q = -50;
      this.t = false;
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

      if (GameCanvas.af != null) {
         GameCanvas.af = new Menu();
      }

      GameCanvas.d = false;
      super.a = this.x = new Command1(TextGame.cj, this, 2005, (Object)null);
      GameScr.x.removeAllElements();
   }

   public final void a(boolean var1) {
      this.t = true;
      this.q = -50;
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

      if (GameCanvas.af != null) {
         GameCanvas.af = new Menu();
      }

      GameCanvas.d = false;
      super.a = this.x = new Command1("Hủy", this, 20051, (Object)null);
   }

   public LoginScr() {
      n = this;
      this.t = false;
      if ((TileMap.versionMap = (byte)((int)(System.currentTimeMillis() % 9L))) == 5 || TileMap.versionMap == 6) {
         TileMap.versionMap = 4;
      }

      GameScr.a(true);
      GameScr.p = 100;
      if (GameCanvas.ab > 200) {
         this.r = GameCanvas.ad - 80;
      } else {
         this.r = GameCanvas.ad - 65;
      }

      this.q = -50;
      this.p = GameCanvas.aa - 30;
      if (this.p < 135) {
         this.p = 135;
      }

      if (this.p > 155) {
         this.p = 155;
      }

      this.y = GameCanvas.ad - mScreen.d - 5;
      if (GameCanvas.ab <= 160) {
         this.y = 20;
      }

      this.j = new TField();
      this.j.k = TextGame.by;
      this.j.a = GameCanvas.ac - 20 - 57;
      this.j.b = this.y;
      this.j.c = this.p;
      this.j.d = mScreen.d + 2;
      this.j.e = true;
      this.j.c(3);
      TField.j = GameMidlet.g;
      TField.i = MotherCanvas.a;
      this.k = new TField();
      this.k.k = TextGame.bz;
      this.k.a = GameCanvas.ac - 20 - 57;
      this.k.b = this.y += 35;
      this.k.c = this.p;
      this.k.d = mScreen.d + 2;
      this.k.e = false;
      this.k.c(2);
      this.l = new TField();
      this.l.k = TextGame.cf;
      this.l.a = GameCanvas.ac - 20 - 57;
      this.l.b = this.y += 35;
      this.l.c = this.p;
      this.l.d = mScreen.d + 2;
      this.l.e = false;
      this.l.c(2);
      this.m = new TField();
      this.m.k = "Email/Số di động";
      this.m.a = GameCanvas.ac - 20 - 57;
      this.m.b = this.y += 35;
      this.m.c = this.p;
      this.m.d = mScreen.d + 2;
      this.m.e = false;
      this.m.c(3);
      this.s = true;
      if (SelectServerScr.h != null) {
         if (SelectServerScr.h.startsWith("tmpusr")) {
            this.j.a("");
            this.k.a("");
         } else {
            this.j.a(SelectServerScr.h);
            this.k.a(SelectServerScr.i);
         }
      }

      this.o = 0;
      this.u = new Command1(TextGame.bx, this, 2000, (Object)null);
      this.v = new Command1(TextGame.cg, this, 2001, (Object)null);
      this.w = new Command1(TextGame.ci, this, 2002, (Object)null);
      new Command1(TextGame.cj, this, 2004, (Object)null);
      if (!this.t) {
         super.a = this.x = new Command1(TextGame.cj, this, 2005, (Object)null);
      } else {
         super.a = this.x = new Command1(TextGame.dd, this, 20051, (Object)null);
      }

      if (GameCanvas.g && GameCanvas.aa >= 320) {
         super.b = null;
         super.c = this.u;
      } else {
         super.b = this.u;
         super.c = this.j.l;
      }

   }

   public static LoginScr f() {
      return n;
   }

   private static void b(boolean var0) {
      GameCanvas.d = var0;
      RMS.a("isGPRS", var0 ? 1 : 2);
   }

   private void a(String var1) {
      Client.ensureServerLoaded(0); GameMidlet.d = GameMidlet.m[0];
      GameCanvas.b(TextGame.dj);
      GameCanvas.a(3);
      GameCanvas.b(TextGame.dk);
      Service.gI().setClientType();
      Service.gI().requestRegisterNew(var1, this.k.d(), this.m.d());
   }

   public final void d() {
      if (++GameScr.p > GameCanvas.aa * 3 + 100) {
         GameScr.p = 100;
      }

      this.j.c();
      this.k.c();
      if (this.t) {
         this.l.c();
         this.m.c();
      }

      if (this.r != this.q) {
         this.q += this.r - this.q >> 1;
      }

      if (GameCanvas.g) {
         super.b = null;
         if (this.t) {
            super.c = this.w;
         } else {
            super.c = this.u;
         }
      } else if (this.t) {
         super.b = this.w;
      } else if (this.o == 2) {
         super.b = this.v;
         if (this.s) {
            super.b.a = TextGame.ch;
         } else {
            super.b.a = TextGame.cg;
         }
      } else {
         super.b = this.u;
      }

      if (this.ac >= 0) {
         this.ad += this.ae * this.ac;
         this.ac += this.ae * this.ab;
         if (this.ac <= 0) {
            this.ae = -this.ae;
         }

         if (this.ad > 0) {
            this.ae = -this.ae;
            this.ac -= 2 * this.ab;
         }
      }

      if (this.aa >= 0 && GameCanvas.w % 100 == 0) {
         ++this.aa;
         if (this.aa >= TextGame.x.length) {
            this.aa = 0;
         }

         this.z = mFont.i.b(TextGame.x[this.aa], GameCanvas.aa - 40);
      }

   }

   public final void a(int var1) {
      if (this.j.e) {
         this.j.a(var1);
      } else if (this.k.e) {
         this.k.a(var1);
      } else if (this.t && this.l.e) {
         this.l.a(var1);
      } else if (this.t && this.m.e) {
         this.m.a(var1);
      }

      super.a(var1);
   }

   public final void b() {
      super.b();
   }

   public final void a(mGraphics var1) {
      var1.a(0);
      var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
      GameCanvas.a(var1);
      int var2 = this.j.b - 45;
      if (GameCanvas.ab <= 220) {
         var2 += 5;
      }

      if (GameCanvas.aj == null) {
         if (this.t) {
            Paint.a(GameCanvas.ac - 85, this.j.b - 15, 170, 150, var1);
         } else {
            Paint.a(GameCanvas.ac - 85, this.j.b - 15, 170, 90, var1);
         }

         if (GameCanvas.ab > 160 && h != null) {
            var1.a(h, GameCanvas.ac, var2 - 2, 3);
         }

         this.j.a(var1);
         this.k.a(var1);
         if (this.t) {
            this.l.a(var1);
            this.m.a(var1);
         }

         var1.d(0, 0, GameCanvas.aa, GameCanvas.ab);
         boolean var3 = false;
         if (GameCanvas.aa > 200) {
            if (this.j.d().equals("")) {
               if (!this.j.e) {
                  mFont.e.a(var1, TextGame.by, this.j.a + 5, this.j.b + 7, 0);
               } else {
                  mFont.k.a(var1, TextGame.by, this.j.a + 5, this.j.b + 7, 0);
               }
            }

            if (this.k.d().equals("")) {
               if (!this.k.e) {
                  mFont.e.a(var1, TextGame.bz, this.k.a + 5, this.k.b + 7, 0);
               } else {
                  mFont.k.a(var1, TextGame.bz, this.k.a + 5, this.k.b + 7, 0);
               }
            }

            if (this.t) {
               if (this.l.d().equals("")) {
                  if (!this.l.e) {
                     mFont.e.a(var1, TextGame.ca, this.l.a + 5, this.l.b + 7, 0);
                     mFont.e.a(var1, TextGame.bz, this.l.a + 50, this.l.b + 7, 0);
                  } else {
                     mFont.k.a(var1, TextGame.ca, this.l.a + 5, this.l.b + 7, 0);
                     mFont.k.a(var1, TextGame.bz, this.l.a + 50, this.l.b + 7, 0);
                  }
               }

               if (this.m.d().equals("")) {
                  if (!this.m.e) {
                     mFont.e.a(var1, "Email/số di động", this.m.a + 5, this.m.b + 5, 0);
                  } else {
                     mFont.k.a(var1, "Email/số di động", this.m.a + 5, this.m.b + 5, 0);
                  }
               }
            }
         } else {
            if (this.j.d().equals("")) {
               mFont.e.a(var1, TextGame.cb, this.j.a - 35, this.j.b + 7, 0);
            }

            if (this.k.d().equals("")) {
               mFont.e.a(var1, TextGame.cc, this.k.a - 35, this.k.b + 7, 0);
            }

            if (this.t) {
               mFont.e.a(var1, TextGame.cd, this.l.a - 35, this.l.b - 1, 0);
               mFont.e.a(var1, TextGame.cc, this.l.a - 35, this.l.b + 13, 0);
               mFont.e.a(var1, "Email/số di động", this.m.a - 35, this.m.b + 5, 0);
            }
         }
      } else if (this.z != null) {
         for(var2 = 0; var2 < this.z.length; ++var2) {
            mFont.i.a(var1, this.z[var2], GameCanvas.aa / 2, this.j.b - 15 + var2 * 10, 2, mFont.k);
         }
      }

      super.a(var1);
   }

   public final void e() {
      if (GameCanvas.n[5]) {
         GameCanvas.n[5] = false;
         (this.t ? this.w : this.u).a();
         GameCanvas.h();
         return;
      }

      if (GameCanvas.n[2]) {
         --this.o;
         if (this.o < 0) {
            this.o = 3;
         }
      } else if (GameCanvas.n[8]) {
         ++this.o;
         if (this.o > 3) {
            this.o = 0;
         }
      }

      if (GameCanvas.n[2] || GameCanvas.n[8]) {
         GameCanvas.h();
         if (this.o == 1) {
            this.j.e = false;
            this.k.e = true;
            this.l.e = false;
            this.m.e = false;
            super.c = this.k.l;
         } else if (this.o == 0) {
            this.j.e = true;
            this.k.e = false;
            this.l.e = false;
            this.m.e = false;
            super.c = this.j.l;
         } else {
            this.j.e = false;
            this.k.e = false;
            if (this.t) {
               if (this.o == 2) {
                  this.l.e = true;
                  this.m.e = false;
                  super.c = this.l.l;
               } else if (this.o == 3) {
                  this.m.e = true;
                  this.l.e = false;
                  super.c = this.m.l;
               }
            }
         }
      }

      if (GameCanvas.r) {
         if (GameCanvas.b(this.j.a, this.j.b, this.j.c, this.j.d)) {
            this.o = 0;
         } else if (GameCanvas.b(this.k.a, this.k.b, this.k.c, this.k.d)) {
            this.o = 1;
         } else {
            if (this.t) {
               if (GameCanvas.b(this.l.a, this.l.b, this.l.c, this.l.d)) {
                  this.o = 2;
               } else if (GameCanvas.b(this.m.a, this.m.b, this.m.c, this.m.d)) {
                  this.o = 3;
               }
            } else if (GameCanvas.b(this.j.a - 20, GameCanvas.ad + 40, 80, 20)) {
               this.s = !this.s;
            }

            this.o = 2;
         }
      }

      super.e();
      GameCanvas.h();
   }

   public final void a(int var1, Object var2) {
      int var7;
      switch (var1) {
         case 1002:
            this.t = true;
            this.l.e = false;
            this.m.e = false;
            this.k.e = false;
            this.j.e = true;
            super.c = this.j.l;
            super.a = new Command1(TextGame.dd, this, 10021, (Object)null);
            return;
         case 1003:
            try {
               GameMidlet.g.platformRequest("http://ninjaschool.vn");
               return;
            } catch (Exception var6) {
               ;
               return;
            }
         case 1004:
            MyVector var6 = new MyVector();
            var7 = RMS.c("lowGraphic");
            if (!GameCanvas.g) {
               if (var7 == 1) {
                  var6.addElement(new Command1(TextGame.ck, this, 10041, (Object)null));
               } else {
                  var6.addElement(new Command1(TextGame.cl, this, 10042, (Object)null));
               }
            }

            var6.addElement(new Command1(TextGame.ad, this, 1006, (Object)null));
            if (GameCanvas.currentScreen == this) {
               var6.addElement(new Command1(TextGame.ae, this, 1009, (Object)null));
            }

            GameCanvas.af.a(var6);
            return;
         case 1005:
            GameCanvas.a(TextGame.ct, new Command1("3G/Wifi", this, 3000, (Object)null), new Command1("GPRS", this, 3001, (Object)null));
            return;
         case 1006:
            GameCanvas.a(TextGame.ag, new Command1(TextGame.dc, this, 10061, (Object)null), new Command1(TextGame.bu, GameCanvas.gI(), 8882, (Object)null));
            return;
         case 1009:
            RMS.a();
            return;
         case 2000:
            if (!this.j.d().equals("") && !this.k.d().equals("")) {
               SelectServerScr.j = this.j.d();
               SelectServerScr.k = this.k.d();
            }

            GameCanvas.ag.a();
            return;
         case 2001:
            if (this.s) {
               this.s = false;
               return;
            }

            this.s = true;
            return;
         case 2002:
            if (this.j.d().equals("")) {
               GameCanvas.a(TextGame.cm);
            } else {
               char[] var5 = this.j.d().toCharArray();

               for(var7 = 0; var7 < var5.length; ++var7) {
                  if (!TField.a(var5[var7])) {
                     GameCanvas.a(TextGame.cn);
                     return;
                  }
               }

               if (this.k.d().equals("")) {
                  GameCanvas.a(TextGame.co);
               } else if (this.l.d().equals("")) {
                  GameCanvas.a(TextGame.cp);
               } else {
                  this.l.d().equals("");
                  if (this.j.d().length() < 5) {
                     GameCanvas.a(TextGame.cq);
                  } else if (!this.k.d().equals(this.l.d())) {
                     GameCanvas.a(TextGame.cr);
                  } else {
                     if (!this.m.d().equals("")) {
                        GameCanvas.ak.a(TextGame.cs[0] + " " + this.j.d() + ", " + TextGame.cs[1], new Command1(TextGame.dc, this, 4000, (Object)null), (Command1)null, new Command1(TextGame.bu, GameCanvas.instance, 8882, (Object)null));
                        GameCanvas.aj = GameCanvas.ak;
                        return;
                     }

                     GameCanvas.a("Bạn chưa nhập Email/số di động, Email/số di động giúp bạn lấy lại mật khẩu khi mất mật khẩu", new Command1(TextGame.ay, this, 4001, (Object)null), new Command1(TextGame.bu, GameCanvas.instance, 8882, (Object)null));
                  }
               }
            }
            break;
         case 2003:
            GameMidlet.a("http://dd.ninjaschool.vn/app/index.php?for=event&do=resetpass");
            return;
         case 2004:
            GameCanvas.al.a(TextGame.jz, new Command1(TextGame.bx, this, 20041, (Object)null), 0);
            return;
         case 2005:
            GameCanvas.a("Bạn có muốn reset mật khẩu không?", new Command1(TextGame.bx, this, 20052, (Object)null), new Command1(TextGame.bu, GameCanvas.instance, 8882, (Object)null));
            return;
         case 3000:
            b(false);
            GameCanvas.j();
            return;
         case 3001:
            b(true);
            GameCanvas.j();
            return;
         case 4000:
            this.a(this.j.d());
            return;
         case 4001:
            this.a(this.j.d());
            break;
         case 10021:
            this.t = false;
            this.l.e = false;
            this.k.e = false;
            this.j.e = true;
            super.c = this.j.l;
            super.a = this.x;
            return;
         case 10041:
            RMS.a("lowGraphic", 0);
            GameCanvas.a(TextGame.ce, 8885, (Object)null);
            return;
         case 10042:
            RMS.a("lowGraphic", 1);
            GameCanvas.a(TextGame.ce, 8885, (Object)null);
            return;
         case 10061:
            GameCanvas.j();
            LanguageScr.b(-1);
            GameMidlet.g.notifyDestroyed();
            return;
         case 20041:
            this.af = GameCanvas.al.a.d().toString();
            GameCanvas.j();
            if (this.af.equals("")) {
               GameCanvas.a(TextGame.cm);
               return;
            }

            GameCanvas.a(TextGame.cu, new Command1(TextGame.bh, this, 200421, (Object)null), new Command1(TextGame.bu, this, 200422, (Object)null));
            return;
         case 20051:
            GameScr.gI().a();
            return;
         case 20052:
            GameMidlet.a("http://dd.ninjaschool.vn/app/index.php?for=event&do=resetpass");
            return;
         case 200421:
            GameCanvas.j();
            String var4 = this.af;
            Client.ensureServerLoaded(0); GameMidlet.d = GameMidlet.m[0];
            GameCanvas.b(TextGame.dj);
            GameCanvas.a(1);
            GameCanvas.b(TextGame.y);
            Service.gI().requestForgetPass(var4);
            return;
         case 200422:
            GameCanvas.a(TextGame.a(TextGame.pa, this.af));
            return;
      }

   }

}
