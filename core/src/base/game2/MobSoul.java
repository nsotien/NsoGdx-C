package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class MobSoul {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private Char h;
   private int[] i;
   private int[] j;
   private int[] k;

   public MobSoul(int var1, int var2, Char var3) {
      this.a = var1;
      this.b = var2;
      this.c = var1;
      this.d = var2 - (Res.d(40) + 20);
      this.e = 1;
      this.g = 1;
      this.h = var3;
   }

   public MobSoul(int var1, int var2) {
      this.e = 1;
      this.g = 2;
      this.c = var1;
      this.d = var2;
      this.i = new int[5];
      this.j = new int[5];
      this.k = new int[5];
      this.f = 300;

      for(int var3 = 0; var3 < this.i.length; ++var3) {
         this.i[var3] = Res.d(var1 - 20, var1 + 20);
         this.j[var3] = var2 - 10;
         this.k[var3] = var3 % 2 == 0 ? 1 : -1;
      }

   }

   public final void a() {
      if (this.g == 1) {
         if (this.h == null) {
            GameScr.vMobSoul.removeElement(this);
            return;
         }

         if (this.e == 1) {
            if (this.b > this.d) {
               this.b -= 2;
               this.a += 1 - GameCanvas.w % 3;
            } else {
               this.e = 2;
            }

            this.f = 100;
            return;
         }

         --this.f;
         if (Res.e(this.h.cx1 - this.a) >= 50 && Res.e(this.h.cy1 - this.b) >= 50) {
            this.a += (this.h.cx1 - this.a) / 10;
            this.b += (this.h.cy1 - this.b) / 10;
         } else {
            this.a += (this.h.cx1 - this.a) / 4;
            this.b += (this.h.cy1 - this.b) / 4;
         }

         if (this.f < 0) {
            this.a = this.h.cx1;
            this.b = this.h.cy1 - this.h.bg / 2;
            if (this.f < -5) {
               GameScr.vMobSoul.removeElement(this);
               return;
            }
         } else if (Res.e(this.h.cx1 - this.a) < 10 && Res.e(this.h.cy1 - this.b) < 10) {
            GameScr.vMobSoul.removeElement(this);
            return;
         }
      } else if (this.g == 2) {
         for(int var1 = 0; var1 < this.i.length; ++var1) {
            int[] var10000 = this.j;
            var10000[var1] -= GameCanvas.w % 5;
            int var10003;
            if (this.k[var1] == -1) {
               var10003 = this.i[var1]--;
            } else {
               var10003 = this.i[var1]++;
            }

            if (this.i[var1] <= this.c - 20 || this.i[var1] >= this.c + 20) {
               this.k[var1] = -this.k[var1];
            }

            if (this.j[var1] < 0) {
               GameScr.vMobSoul.removeElement(this);
            }
         }
      }

   }

   public final void a(mGraphics var1) {
      if (this.g == 1) {
         if (GameCanvas.w % 5 > 2) {
            SmallImage.a(var1, 1433, this.a, this.b, 0, 3);
         } else {
            SmallImage.a(var1, 1434, this.a, this.b, 0, 3);
         }
      } else {
         for(int var2 = 0; var2 < this.i.length; ++var2) {
            if (GameCanvas.w % 5 > 2) {
               SmallImage.a(var1, 1433, this.i[var2], this.j[var2], 0, 3);
            } else {
               SmallImage.a(var1, 1434, this.i[var2], this.j[var2], 0, 3);
            }
         }
      }

   }

}
