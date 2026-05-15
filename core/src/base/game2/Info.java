package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Info {
   private static MyVector b = new MyVector();
   private static InfoItem c;
   private static int d = 5;
   private static int e;
   private static int f;
   private static int g;
   private static int h = 2;
   public static int a = 15;

   public static void a(mGraphics var0) {
      int var1 = GameCanvas.av ? 16 : 0;
      int var2 = GameCanvas.aa;
      if (c != null) {
         var0.d(0, 0, GameCanvas.aa, GameCanvas.ab);
         if (!GameCanvas.g) {
            Paint.a(-6, var1 - 4, var2 + 10, a + 8, var0);
         } else {
            var0.a(0);
            var0.c(0, var1, var2, a);
         }

         var0.d(0, var1, var2, a + 5);
         c.b.a(var0, c.a, f, var1 + 5, 0);
      }

   }

   public static void a() {
      if (GameCanvas.g) {
         a = 20;
      }

      if (d == 0) {
         if ((f += (h - f) / 3) - h < 3) {
            f = h + 2;
            d = 2;
            e = 0;
            return;
         }
      } else if (d == 2) {
         if (++e > c.c) {
            d = 3;
            e = 0;
            return;
         }
      } else if (d == 3) {
         if (f + g < h + GameCanvas.aa - 160) {
            f -= 6;
         } else {
            f -= 2;
         }

         if (f + g < h) {
            d = 4;
            e = 0;
            return;
         }
      } else if (d == 4) {
         if (++e > 10) {
            d = 5;
            e = 0;
            return;
         }
      } else if (d == 5) {
         if (b.size() > 0) {
            InfoItem var0 = (InfoItem)b.firstElement();
            b.removeElementAt(0);
            if (c != null && var0.a.equals(c.a)) {
               return;
            }

            c = var0;
            g = var0.b.a(c.a);
            e = 0;
            d = 0;
            f = GameCanvas.aa;
            return;
         }

         c = null;
         if (GameCanvas.g) {
            a = 0;
         }
      }

   }

   public static void a(String var0, int var1, mFont var2) {
      String var3 = var0;
      boolean var10000;
      if (c != null && c.a != null && var0.equals(c.a)) {
         var10000 = true;
      } else if (b.size() > 0 && var0.equals(((InfoItem)b.lastElement()).a)) {
         var10000 = true;
      } else {
         label96: {
            if (var0.length() >= 8) {
               String var4;
               String var5;
               if (c != null && c.a != null && d < 3 && c.a.length() >= 8) {
                  var4 = var0.substring(0, 8);
                  var5 = c.a.substring(0, 8);
                  if (var4.equals(var5)) {
                     int var8;
                     for(var8 = 7; var8 < var3.length() && var8 < c.a.length() && var3.charAt(var8) == c.a.charAt(var8); ++var8) {
                     }

                     var5 = var3.substring(var8, var3.length());
                     InfoItem var9 = c;
                     var9.a = var9.a + ", " + var5;
                     d = 2;
                     e = 0;
                     var10000 = true;
                     break label96;
                  }
               }

               if (b.size() > 0 && (var4 = ((InfoItem)b.lastElement()).a).length() >= 8) {
                  var5 = var0.substring(0, 8);
                  String var6 = var4.substring(0, 8);
                  if (var5.equals(var6)) {
                     int var7;
                     for(var7 = 7; var7 < var3.length() && var7 < var4.length() && var3.charAt(var7) == var4.charAt(var7); ++var7) {
                     }

                     var3 = var3.substring(var7, var3.length());
                     (new StringBuffer(String.valueOf(var4))).append(", ").append(var3).toString();
                     var10000 = true;
                     break label96;
                  }
               }
            }

            var10000 = false;
         }
      }

      if (!var10000) {
         if (GameCanvas.aa == 128) {
            h = 1;
         }

         if (b.size() > 10) {
            b.removeElementAt(0);
         }

         b.addElement(new InfoItem(var0, var2, var1));
      }

   }

}
