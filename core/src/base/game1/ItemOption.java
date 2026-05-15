package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class ItemOption {
   public int a;
   public byte b;
   public ItemOptionTemplate c;

   public ItemOption() {
   }

   public ItemOption(int var1, int var2) {
      this.a = var2;
      this.c = GameScr.ay[var1];
   }

   public final String a() {
      if (this.c.c == 9) {
         String var1 = a(this.a);
         return NinjaUtil.a(this.c.b, "#", var1);
      } else {
         return NinjaUtil.a(this.c.b, "#", String.valueOf(this.a));
      }
   }

   private static String a(int var0) {
      if (var0 % 100 == 0) {
         return String.valueOf(var0 / 100);
      } else {
         return var0 % 10 == 0 ? var0 / 100 + "." + var0 % 100 / 10 : var0 / 100 + "." + var0 % 100 / 10 + var0 % 10;
      }
   }

   public final String b() {
      String var1 = null;
      boolean var2 = false;
      int var3;
      if (this.c.a != 0 && this.c.a != 1 && this.c.a != 21 && this.c.a != 22 && this.c.a != 23 && this.c.a != 24 && this.c.a != 25 && this.c.a != 26) {
         if (this.c.a != 6 && this.c.a != 7 && this.c.a != 8 && this.c.a != 9 && this.c.a != 19) {
            if (this.c.a != 2 && this.c.a != 3 && this.c.a != 4 && this.c.a != 5 && this.c.a != 10 && this.c.a != 11 && this.c.a != 12 && this.c.a != 13 && this.c.a != 14 && this.c.a != 15 && this.c.a != 17 && this.c.a != 18 && this.c.a != 20) {
               if (this.c.a == 16) {
                  var3 = this.a - 3 + 1;
                  var1 = NinjaUtil.a(this.c.b, "#", String.valueOf(this.a)) + " (" + var3 + "-" + this.a + ")";
               } else if (this.c.c == 9) {
                  var1 = a(this.a);
                  var1 = NinjaUtil.a(this.c.b, "#", var1);
               } else {
                  var1 = NinjaUtil.a(this.c.b, "#", String.valueOf(this.a));
               }
            } else {
               var3 = this.a - 5 + 1;
               var1 = NinjaUtil.a(this.c.b, "#", String.valueOf(this.a)) + " (" + var3 + "-" + this.a + ")";
            }
         } else {
            var3 = this.a - 10 + 1;
            var1 = NinjaUtil.a(this.c.b, "#", String.valueOf(this.a)) + " (" + var3 + "-" + this.a + ")";
         }
      } else {
         var3 = this.a - 50 + 1;
         var1 = NinjaUtil.a(this.c.b, "#", String.valueOf(this.a)) + " (" + var3 + "-" + this.a + ")";
      }

      return var1;
   }

}
