package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class LanguageScr extends mScreen implements IActionListener {
   private int h;
   private int i;
   private int j;
   private int k;
   private int l = -1;

   public final void a() {
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
      this.h = 170;
      this.i = 175;
      if (GameCanvas.aa == 128 || GameCanvas.ab <= 208) {
         this.h = 126;
         this.i = 160;
      }

      this.j = GameCanvas.aa / 2 - this.h / 2;
      this.k = GameCanvas.ab / 2 - this.i / 2;
      if (GameCanvas.ab <= 250) {
         this.k -= 10;
      }

      super.b = new Command1(GameCanvas.g ? "" : TextGame.bx, this, 1000, (Object)null);
      super.c = new Command1(TextGame.bv, GameCanvas.instance, 8885, (Object)null);
      this.l = -1;
      if (!GameCanvas.g) {
         this.l = 0;
      }

      if (GameCanvas.g && GameCanvas.aa >= 320) {
         super.b.f = GameCanvas.aa / 2 - 35;
         super.c.f = GameCanvas.aa / 2 + 88;
         super.b.g = super.c.g = GameCanvas.ab - 26;
      }

   }

   public final void a(mGraphics var1) {
      var1.a(0);
      var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
      GameCanvas.a(var1);
      Paint.a(this.j, this.k, this.h, this.i, var1);
      var1.a(Paint.c);
      var1.b(GameCanvas.ac - mFont.o.a(TextGame.ad) / 2 - 12, this.k + 7, mFont.o.a(TextGame.ad) + 22, 24, 6, 6);
      var1.a(Paint.b);
      var1.a(GameCanvas.ac - mFont.o.a(TextGame.ad) / 2 - 12, this.k + 7, mFont.o.a(TextGame.ad) + 22, 24, 6, 6);
      mFont.o.a(var1, TextGame.ad, GameCanvas.ac, this.k + 12, 2);
      String[] var2 = TextGame.af;
      int var3 = this.k + 50;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         var1.a(Paint.c);
         var1.c(this.j + 10, var3 + var4 * 35, this.h - 20, 28);
         var1.a(5720393);
         var1.b(this.j + 10, var3 + var4 * 35, this.h - 20, 28);
         if (var4 == this.l) {
            var1.a(Paint.b);
            var1.c(this.j + 10, var3 + var4 * 35, this.h - 20, 28);
            var1.a(11053224);
            var1.b(this.j + 10, var3 + var4 * 35, this.h - 20, 28);
         }

         mFont.e.a(var1, var2[var4], this.j + this.h / 2, var3 + var4 * 35 + 8, 2);
      }

      super.a(var1);
      Paint.a(var1, super.a, super.b, super.c);
   }

   public static void b(int var0) {
      RMS.a("indLanguage", var0);
   }

   public static int f() {
      boolean var0 = false;
      return RMS.c("indLanguage");
   }

   public final void d() {
      if (++GameScr.p > GameCanvas.aa * 3 + 100) {
         GameScr.p = 100;
      }

      super.d();
   }

   public final void e() {
      if (GameCanvas.n[2] || GameCanvas.n[4] || GameCanvas.n[6] || GameCanvas.n[8]) {
         this.l = this.l == 0 ? 1 : 0;
      }

      if (GameCanvas.r && GameCanvas.b(this.j + 10, this.k + 45, this.h - 10, 70)) {
         if (GameCanvas.q) {
            this.l = (GameCanvas.t - (this.k + 45)) / 35;
         }

         this.a(1000, (Object)null);
      }

      super.e();
      GameCanvas.h();
   }

   public final void a(int var1, Object var2) {
      switch (var1) {
         case 1000:
            GameCanvas.aj = null;
            RMS.a();
            GameCanvas.b();
            SelectServerScr.b(0);
            GameCanvas.ag.a();
         default:
      }
   }

}
