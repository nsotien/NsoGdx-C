package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class MobAttack {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private static int[] j;

   public final void a() {
      if (this.i > 0 && this.i < 4) {
         this.a += this.c;
         this.b += this.d;
         this.d += 2;
         if (this.c < -2) {
            ++this.c;
         }

         if (this.c > 2) {
            --this.c;
         }

         if (this.d == 6) {
            if (this.i == 2) {
               this.i = 0;
            } else {
               this.i = 4;
            }

            this.h = 11;
            this.c = Res.b(Res.a(this.f - this.a, this.g - this.b), this.h);
            this.d = Res.c(Res.a(this.f - this.a, this.g - this.b), this.h);
         }
      } else {
         Char var1 = null;
         var1 = (Char)GameScr.vCharInMap.elementAt(0);
         this.f = var1.cx1;
         this.g = var1.cy1 - var1.bi;
         this.a += this.c;
         this.b += this.d;
         ++this.h;
         this.c = Res.b(Res.a(this.f - this.a, this.g - this.b), this.h);
         this.d = Res.c(Res.a(this.f - this.a, this.g - this.b), this.h);
         ++this.e;
         if (this.e == j[0]) {
            this.e = 0;
         }

         if (this.a < this.f + var1.bh && this.a > this.f - var1.bh && this.b < this.g + var1.bi && this.b > this.g - var1.bi) {
            GameScr.vMobAttack.removeElement(this);
         }
      }

   }

   static {
      int[] var10000 = new int[]{10, 5, 11};
      var10000 = new int[]{10, 5, 11};
      j = new int[]{4, 1, 4};
   }
}
