package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Class_es {
   long a;
   public String b;
   public boolean c;
   public short d;
   public short e;
   private byte f;

   public Class_es(short var1, short var2, long var3, String var5, byte var6) {
      this.a = System.currentTimeMillis() + var3 * 1000L;
      this.b = var5;
      this.d = var1;
      this.e = var2;
      this.f = var6;
      if (this.f == 0) {
         this.a = var3;
      }

   }

   public final void a(mGraphics var1, int var2, int var3) {
      if (this.e == -1) {
         if (this.f != 1) {
            mFont.g.a(var1, this.b, var2 + 1, var3 + 1, 1);
            mFont.i.a(var1, this.b, var2, var3, 1);
            return;
         }

         int var4;
         if ((var4 = (int)((this.a - System.currentTimeMillis()) / 1000L)) > 0) {
            mFont.g.a(var1, this.b + " : " + a(var4), var2 - 5, var3 + 1, 1);
            mFont.i.a(var1, this.b + " : " + a(var4), var2 - 4, var3, 1);
            return;
         }
      } else {
         MyImage var7;
         if ((var7 = (MyImage)SmallImage.b.get(String.valueOf(this.d))) == null) {
            var7 = new MyImage();
            SmallImage.b.put(String.valueOf(this.d), var7);
            var7.a = Controller.a(RMS.a(String.valueOf(this.d)));
            if (var7.a == null) {
               var7.b = System.currentTimeMillis();
               Service.gI().ae(this.d);
            }
         } else if (var7.a == null && System.currentTimeMillis() - var7.b > 60000L) {
            var7.b = System.currentTimeMillis();
            Service.gI().ae(this.d);
         }

         if (var7 != null && var7.a != null) {
            int var5;
            if (this.f == 0) {
               var5 = mFont.g.a(this.b + " : ");
               var1.a(var7.a, var2 - var5 - (var7.a.getWidth() << 1), var3 + mGraphics.b(var7.a) / 4, 0);
               mFont.g.a(var1, this.b, var2 - var5 - (var7.a.getWidth() << 1) + 1 + mGraphics.a(var7.a), var3 + 1 + mGraphics.b(var7.a) / 4, 0);
               mFont.i.a(var1, this.b, var2 - var5 - (var7.a.getWidth() << 1) + mGraphics.a(var7.a), var3 + mGraphics.b(var7.a) / 4, 0);
               return;
            }

            if (this.f == 1) {
               var5 = (int)((this.a - System.currentTimeMillis()) / 1000L);
               int var6 = mFont.g.a(a(var5) + ":");
               var1.a(var7.a, var2 - var6 - (var7.a.getWidth() << 1), var3 + mGraphics.b(var7.a) / 4, 0);
               mFont.g.a(var1, " : " + a(var5), var2 - var6 - (var7.a.getWidth() << 1) + 1 + mGraphics.a(var7.a), var3 + 1 + mGraphics.b(var7.a) / 4, 0);
               mFont.i.a(var1, " : " + a(var5), var2 - var6 - (var7.a.getWidth() << 1) + mGraphics.a(var7.a), var3 + mGraphics.b(var7.a) / 4, 0);
            }
         }
      }

   }

   public final void a() {
      if (this.f == 1 && System.currentTimeMillis() - this.a >= 0L) {
         this.c = true;
      }

   }

   private static String a(int var0) {
      int var1 = var0 % 60;
      int var2 = (var0 /= 60) % 60;
      if ((var0 /= 60) > 0) {
         return var0 + ":" + var2;
      } else if (var2 > 0) {
         return var2 + ":" + var1;
      } else {
         return var1 < 0 ? "0:" + var1 : String.valueOf(var1);
      }
   }

}
