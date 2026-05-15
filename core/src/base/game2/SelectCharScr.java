package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class SelectCharScr extends mScreen implements IActionListener {
   private static SelectCharScr r;
   private int s;
   private int t;
   private int u;
   private int v;
   private int w;
   public int h;
   public int[] i;
   public int[] j;
   public int[] k;
   public int[] l;
   public int[] m;
   public String[] n;
   public String[] o;
   public byte[] p;
   private Command1 x;
   private int y;
   public boolean q = true;
   private int z;
   private int aa;
   public static String ig_login = "";

   public static SelectCharScr f() {
      if (r == null) {
         r = new SelectCharScr();
      }

      return r;
   }

   public SelectCharScr() {
      this.z = GameCanvas.ab / 2 - 2;
      this.aa = GameCanvas.ab / 2 + 2;
      this.s = 48;
      this.t = 85;
      if (GameCanvas.aa < 160) {
         this.s = 32;
      }

      this.u = 7;
      this.v = (GameCanvas.aa - 3 * this.s >> 1) - 5;
      this.w = GameCanvas.ad - (this.t >> 1) + 10;
      if (GameCanvas.g && GameCanvas.aa > 200) {
         this.s = 74;
         this.u = 25;
         this.t = 110;
         this.v = (GameCanvas.aa - 3 * this.s >> 1) - 20;
         this.w = GameCanvas.ad - (this.t >> 1);
         if (GameCanvas.aa < 320) {
            this.u = 6;
            this.v = (GameCanvas.aa - 3 * this.s >> 1) - 6;
         }
      }

      super.a = null;
      this.x = new Command1(TextGame.doa, this, 1000, (Object)null);
      super.b = new Command1("", this, 1000, (Object)null);
      super.c = new Command1(TextGame.bv, this, 1001, (Object)null);
      super.a = this.x;
      if (GameCanvas.g) {
         super.b = null;
         super.a = null;
      }

      if (GameCanvas.g && GameCanvas.aa >= 320) {
         super.c.f = GameCanvas.aa / 2 + 88;
         super.c.g = GameCanvas.ab - 26;
      }

   }

   private void g() {
      if (this.n[this.h] != null) {
         ig_login = this.n[this.h];
         Service.gI().b(this.n[this.h]);
         GameCanvas.b(TextGame.y);
         GameCanvas.f = true;
      } else {
         CreateCharScr.f().a();
      }

   }

   public final void e() {
      super.e();
      if (GameCanvas.n[6]) {
         ++this.h;
         if (this.h >= 3) {
            this.h = 0;
         }
      }

      if (GameCanvas.n[4]) {
         --this.h;
         if (this.h < 0) {
            this.h = 2;
         }
      }

      if (GameCanvas.p && GameCanvas.b(this.v, this.w, 3 * (this.s + this.u), this.t)) {
         int var1;
         if ((var1 = (GameCanvas.s - this.v) / (this.s + this.u)) > 2) {
            var1 = 2;
         }

         if (var1 < 0) {
            var1 = 0;
         }

         this.h = var1;
      }

      if (GameCanvas.r) {
         if (GameCanvas.b(this.v, this.w, 3 * (this.s + this.u), this.t)) {
            this.y = 5;
         } else {
            this.h = -1;
         }
      }

      GameCanvas.i();
      GameCanvas.h();
   }

   public final void d() {
      if (++GameScr.p > GameCanvas.aa * 3 + 100) {
         GameScr.p = 100;
      }

      if (this.y > 0) {
         --this.y;
         if (this.y == 0 && this.h >= 0) {
            this.g();
         }
      }

   }

   public final void a() {
      TileMap.c();
      System.gc();
      super.a();

      for(int var1 = 0; var1 < this.n.length; ++var1) {
         if (this.n[var1] != null) {
            this.q = false;
            break;
         }
      }

      if (this.q) {
         CreateCharScr.f().a();
      }

   }

   public final void a(mGraphics var1) {
      GameCanvas.a(var1);

      int var2;
      for(var2 = 0; var2 < 3; ++var2) {
         if (this.h == var2) {
            Paint.d(this.v + var2 * (this.s + this.u), this.w, this.s, this.t, var1);
         } else {
            Paint.c(this.v + var2 * (this.s + this.u), this.w, this.s, this.t, var1);
         }

         Paint.b(this.v + var2 * (this.s + this.u), this.w, this.s, this.t, var1);
      }

      for(var2 = 0; var2 < 3; ++var2) {
         if (this.n[var2] != null) {
            Part var3 = GameScr.ac[this.i[var2]];
            Part var4 = GameScr.ac[this.j[var2]];
            Part var5 = GameScr.ac[this.k[var2]];
            Part var6 = GameScr.ac[this.l[var2]];
            int var7;
            if (var3.a != null && var3.a.length >= 8) {
               for(var7 = 0; var7 < var3.a.length; ++var7) {
                  if (var3.a[var7] == null || !SmallImage.a(var3.a[var7].a)) {
                     Char.getMyChar();
                     var3 = Char.b(this.p[var2]);
                     break;
                  }
               }
            } else {
               Char.getMyChar();
               var3 = Char.b(this.p[var2]);
            }

            var7 = this.v + var2 * (this.s + this.u) + this.s / 2;
            boolean var8 = false;
            int var9;
            if (!GameCanvas.g) {
               var9 = this.w + this.t / 2 + 16;
               SmallImage.a(var1, var6.a[Char.ea[0][3][0]].a, var7 + Char.ea[0][3][1] + var6.a[Char.ea[0][3][0]].b, var9 - Char.ea[0][3][2] + var6.a[Char.ea[0][3][0]].c, 0, 0);
               SmallImage.a(var1, var4.a[Char.ea[0][1][0]].a, var7 + Char.ea[0][1][1] + var4.a[Char.ea[0][1][0]].b, var9 - Char.ea[0][1][2] + var4.a[Char.ea[0][1][0]].c, 0, 0);
               SmallImage.a(var1, var5.a[Char.ea[0][2][0]].a, var7 + Char.ea[0][2][1] + var5.a[Char.ea[0][2][0]].b, var9 - Char.ea[0][2][2] + var5.a[Char.ea[0][2][0]].c, 0, 0);
               SmallImage.a(var1, var3.a[Char.ea[0][0][0]].a, var7 + Char.ea[0][0][1] + var3.a[Char.ea[0][0][0]].b, var9 - Char.ea[0][0][2] + var3.a[Char.ea[0][0][0]].c, 0, 0);
               if (this.h == var2) {
                  mFont.o.a(var1, TextGame.mq[0] + ": " + this.n[var2], GameCanvas.ac, this.w - 45, 2);
                  mFont.e.a(var1, TextGame.mq[1] + ": " + this.m[var2], GameCanvas.ac, this.w - 28, 2, mFont.b);
                  mFont.e.a(var1, this.o[var2], GameCanvas.ac, this.w - 16, 2, mFont.b);
               }
            } else {
               var9 = this.w + this.t / 2 - 5;
               SmallImage.a(var1, var6.a[Char.ea[0][3][0]].a, var7 + Char.ea[0][3][1] + var6.a[Char.ea[0][3][0]].b, var9 - Char.ea[0][3][2] + var6.a[Char.ea[0][3][0]].c, 0, 0);
               SmallImage.a(var1, var4.a[Char.ea[0][1][0]].a, var7 + Char.ea[0][1][1] + var4.a[Char.ea[0][1][0]].b, var9 - Char.ea[0][1][2] + var4.a[Char.ea[0][1][0]].c, 0, 0);
               SmallImage.a(var1, var5.a[Char.ea[0][2][0]].a, var7 + Char.ea[0][2][1] + var5.a[Char.ea[0][2][0]].b, var9 - Char.ea[0][2][2] + var5.a[Char.ea[0][2][0]].c, 0, 0);
               SmallImage.a(var1, var3.a[Char.ea[0][0][0]].a, var7 + Char.ea[0][0][1] + var3.a[Char.ea[0][0][0]].b, var9 - Char.ea[0][0][2] + var3.a[Char.ea[0][0][0]].c, 0, 0);
               mFont.o.a(var1, this.n[var2], var7, this.w + this.t / 2 + 5, 2);
               mFont.e.a(var1, TextGame.mq[1] + ": " + this.m[var2], var7, this.w + this.t / 2 + 22, 2);
               if (GameCanvas.aa > 200) {
                  mFont.e.a(var1, this.o[var2], var7, this.w + this.t / 2 + 34, 2);
               }
            }
         }
      }

      super.a(var1);
   }

   public final void a(int var1, Object var2) {
      switch (var1) {
         case 1000:
            this.g();
            return;
         case 1001:
            Session_ME.a().c();
            GameCanvas.instance.n();
         default:
      }
   }

}
