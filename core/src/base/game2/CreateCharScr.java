package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class CreateCharScr extends mScreen implements IActionListener {
   private static CreateCharScr h;
   private static TField i;
   private static int j;
   private static int k;
   private static int l;
   private static int[][] m = new int[][]{{11, 26, 27, 28}, {2, 23, 24, 25}};
   private static int[] n = new int[]{9, 0};
   private static int[] o = new int[]{10, 1};
   private Command1 p;
   private Command1 q;
   private int r = 0;

   public static CreateCharScr f() {
      if (h == null) {
         h = new CreateCharScr();
      }

      return h;
   }

   public CreateCharScr() {
      if (GameCanvas.aa == 128) {
         GameScr.b(128, 120);
         GameScr.fe = (GameCanvas.aa - 128) / 2;
         GameScr.fd = 0;
      } else {
         GameScr.b(170, 190);
         GameScr.fe = (GameCanvas.aa - 170) / 2;
         GameScr.fd = (GameCanvas.ab - 220) / 2;
      }

      j = 1;
      (i = new TField()).k = TextGame.ea;
      i.c = 100;
      i.a = GameScr.fe + 45;
      i.a = GameScr.fe + GameScr.ff / 2 - i.c / 2;
      i.b = GameScr.fd + 62;
      if (GameCanvas.aa == 128) {
         i.c = 60;
      }

      i.d = 26;
      i.e = true;
      i.c(0);
      j = 1;
      k = 0;
      super.b = new Command1(TextGame.dz, this, 8000, (Object)null);
      super.a = new Command1(TextGame.ee, this, 8001, (Object)null);
      this.p = new Command1("", this, 8002, (Object)null, GameScr.fe + GameScr.ff / 2 - mScreen.e / 2, GameScr.fd + 70 + 30);
      this.q = new Command1("", this, 8003, (Object)null, GameScr.fe + GameScr.ff / 2 - mScreen.e / 2, GameScr.fd + 70 + 70);
      super.c = i.l;
   }

   public final void a() {
      j = GameCanvas.w % 2;
      k = GameCanvas.w % 4;
      super.a();
   }

   public final void a(int var1) {
      i.a(var1);
   }

   public final void d() {
      if (++GameScr.p > GameCanvas.aa * 3 + 100) {
         GameScr.p = 100;
      }

      if (GameCanvas.g && GameCanvas.aa >= 320) {
         if (super.a != null) {
            super.a.f = GameCanvas.aa / 2 - 160;
            super.a.g = GameCanvas.ab - 26;
         }

         if (super.b != null) {
            super.b.f = GameCanvas.aa / 2 - 35;
            super.b.g = GameCanvas.ab - 26;
         }

         if (super.c != null) {
            super.c.f = GameCanvas.aa / 2 + 88;
            super.c.g = GameCanvas.ab - 26;
         }
      }

      if (this.q != null) {
         this.q.c();
      }

      if (this.p != null) {
         this.p.c();
      }

   }

   public final void e() {
      if (GameCanvas.n[2] && --l < 0) {
         l = TextGame.it.length - 1;
      }

      if (GameCanvas.n[8] && ++l >= TextGame.it.length) {
         l = 0;
      }

      if (l == 0) {
         super.c = i.l;
         i.c();
      }

      if (l == 1) {
         if (GameCanvas.n[4] && --j < 0) {
            j = TextGame.iu.length - 1;
         }

         if (GameCanvas.n[6] && ++j > TextGame.iu.length - 1) {
            j = 0;
         }

         super.c = null;
      }

      if (l == 2) {
         if (GameCanvas.n[4] && --k < 0) {
            k = TextGame.ff[0].length - 1;
         }

         if (GameCanvas.n[6] && ++k > TextGame.ff[0].length - 1) {
            k = 0;
         }
      }

      if (GameCanvas.r && GameCanvas.b(GameScr.fe + 5, GameScr.fd + 65, GameScr.ff - 5, mScreen.d)) {
         l = 0;
      }

      super.e();
      GameCanvas.i();
      GameCanvas.h();
   }

   public final void a(mGraphics var1) {
      byte var2 = 0;

      try {
         GameCanvas.a(var1);
         boolean var10 = true;
         Paint.a(GameScr.fe, GameScr.fd, GameScr.ff, GameScr.fg, var1);
         byte var3 = 40;
         if (GameCanvas.aa == 128) {
            var3 = 20;
         }

         var10 = true;
         int var4 = m[j][k];
         int var5 = n[j];
         int var6 = o[j];
         var10 = true;
         Part var11 = GameScr.ac[var4];
         Part var12 = GameScr.ac[var5];
         Part var13 = GameScr.ac[var6];
         int var7 = GameCanvas.aa / 2;
         int var8 = GameScr.fd + 50;
         var10 = true;
         SmallImage.a(var1, var12.a[Char.ea[0][1][0]].a, var7 + Char.ea[0][1][1] + var12.a[Char.ea[0][1][0]].b, var8 - Char.ea[0][1][2] + var12.a[Char.ea[0][1][0]].c, 0, 0);
         SmallImage.a(var1, var13.a[Char.ea[0][2][0]].a, var7 + Char.ea[0][2][1] + var13.a[Char.ea[0][2][0]].b, var8 - Char.ea[0][2][2] + var13.a[Char.ea[0][2][0]].c, 0, 0);
         SmallImage.a(var1, var11.a[Char.ea[0][0][0]].a, var7 + Char.ea[0][0][1] + var11.a[Char.ea[0][0][0]].b, var8 - Char.ea[0][0][2] + var11.a[Char.ea[0][0][0]].c, 0, 0);
         var10 = true;
         if (!GameCanvas.g) {
            for(var4 = 0; var4 < TextGame.it.length; ++var4) {
               if (l == var4) {
                  var5 = var4 > 0 ? -5 : 0;
                  SmallImage.a(var1, 989, GameScr.fe + 10 + (GameCanvas.w % 7 > 3 ? 1 : 0), GameScr.fd + 76 + var4 * var3 + var5, 2, StaticObj.g);
                  SmallImage.a(var1, 989, GameScr.fe + GameScr.ff - 15 - (GameCanvas.w % 7 > 3 ? 1 : 0), GameScr.fd + 76 + var4 * var3 + var5, 0, StaticObj.g);
               }
            }
         }

         var10 = true;
         if (GameCanvas.g) {
            this.p.a = TextGame.iu[j];
            this.p.a(var1);
            this.q.a = TextGame.ff[j][k];
            this.q.a(var1);
         } else {
            Paint.b(this.p.f, this.p.g, this.p.h, this.p.i, var1);
            if (l == 1) {
               var1.a(Paint.b);
               var1.c(this.p.f, this.p.g, this.p.h, this.p.i);
               Paint.b(this.p.f, this.p.g, this.p.h, this.p.i, var1);
            }

            Paint.b(this.q.f, this.q.g, this.q.h, this.q.i, var1);
            if (l == 2) {
               var1.a(Paint.b);
               var1.c(this.q.f, this.q.g, this.q.h, this.q.i);
               Paint.b(this.q.f, this.q.g, this.q.h, this.q.i, var1);
            }

            mFont.e.a(var1, TextGame.iu[j], GameScr.fe + 85, GameScr.fd + 66 + var3 * 1, 2);
            mFont.e.a(var1, TextGame.ff[j][k], GameScr.fe + 85, GameScr.fd + 66 + var3 * 2, 2);
         }

         i.a = GameScr.fe + GameScr.ff / 2 - i.c / 2;
         i.b = GameScr.fd + 62;
         i.g = TextGame.ea;
         i.a(var1);
         super.a(var1);
         var1.a(0);
      } catch (Exception var13) {
         ;
         ;
      }

   }

   public final void a(int var1, Object var2) {
      switch (var1) {
         case 8000:
            Service.gI().a(i.d(), j, m[j][k]);
            return;
         case 8001:
            if (SelectCharScr.f().q) {
               GameCanvas.ag.a();
               return;
            }

            SelectCharScr.f().a();
            return;
         case 8002:
            this.r = 1;
            l = 1;
            if (this.r == l && --j < 0) {
               j = TextGame.iu.length - 1;
               return;
            }
            break;
         case 8003:
            this.r = 2;
            l = 2;
            if (this.r == l && ++k > TextGame.ff[0].length - 1) {
               k = 0;
            }
      }

   }

}
