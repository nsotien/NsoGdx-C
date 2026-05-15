package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class InfoMe {
   private static MyVector a = new MyVector();
   private static InfoItem b;
   private static int c = 5;
   private static int d;
   private static int e;
   private static int f;
   private static int g = 2;
   private static int h = 20;

   public static void a(mGraphics var0) {
      int var1 = g;
      int var2 = GameCanvas.ab - 23;
      int var3 = GameCanvas.aa;
      if (GameCanvas.g) {
         if (GameCanvas.aa >= 450) {
            var1 = 130;
            var3 = GameCanvas.aa - 260;
         } else {
            var1 = 80;
            var3 = GameCanvas.aa - 160 - 10;
         }

         var2 = GameCanvas.ab - 60;
         g = var1 + 2;
      }

      if (b != null && (GameCanvas.aj == null || GameCanvas.aj.d == null)) {
         var0.d(0, 0, GameCanvas.aa, GameCanvas.ab);
         if (GameCanvas.g) {
            Paint.a(var1, var2 - 4, var3 + 10, h + 8, var0);
         } else {
            var0.a(0);
            var0.c(var1 - 2, var2, var3 + 2, h);
         }

         var0.d(var1, var2, var3, h);
         b.b.a(var0, b.a, e, var2 + 3, 0);
      }

   }

   public static void a() {
      if (c == 0) {
         if ((e += (g - e) / 3) - g < 3) {
            e = g + 2;
            c = 2;
            d = 0;
            return;
         }
      } else if (c == 2) {
         if (++d > b.c) {
            c = 3;
            d = 0;
            return;
         }
      } else if (c == 3) {
         if (e + f < g + GameCanvas.aa - 20) {
            e -= 6;
         } else {
            e -= 2;
         }

         if (e + f < g) {
            c = 4;
            d = 0;
            return;
         }
      } else if (c == 4) {
         if (++d > 10) {
            c = 5;
            d = 0;
            return;
         }
      } else if (c == 5) {
         if (a.size() > 0) {
            InfoItem var0 = (InfoItem)a.firstElement();
            a.removeElementAt(0);
            if (b != null && var0.a.equals(b.a)) {
               return;
            }

            b = var0;
            f = var0.b.a(b.a);
            d = 0;
            c = 0;
            e = GameCanvas.aa;
            return;
         }

         b = null;
      }

   }

   public static void a(String var0) {
      // Port TGAME: chặn tầng cuối nếu blockNotify đang bật (gom mọi call InfoMe.a trực tiếp)
      if (ChatManager.shouldBlockNotify(var0)) {
         return;
      }

      if (!b(var0)) {
         if (GameCanvas.aa == 128) {
            g = 1;
         }

         if (a.size() > 10) {
            a.removeElementAt(0);
         }

         a.addElement(new InfoItem(var0));
      }

   }

   private static boolean b(String var0) {
      if (b != null && b.a != null && var0.equals(b.a)) {
         return true;
      } else if (a.size() > 0 && var0.equals(((InfoItem)a.lastElement()).a)) {
         return true;
      } else if (var0.length() < 8) {
         return false;
      } else {
         String var1;
         String var2;
         if (b != null && b.a != null && c < 3 && b.a.length() >= 8) {
            var1 = var0.substring(0, 8);
            var2 = b.a.substring(0, 8);
            if (var1.equals(var2)) {
               int var5;
               for(var5 = 7; var5 < var0.length() && var5 < b.a.length() && (var0.charAt(var5) < '0' || var0.charAt(var5) > '9') && var0.charAt(var5) == b.a.charAt(var5); ++var5) {
               }

               var2 = var0.substring(var5, var0.length());
               InfoItem var10000 = b;
               var10000.a = var10000.a + ", " + var2;
               c = 2;
               d = 0;
               return true;
            }
         }

         if (a.size() > 0 && (var1 = ((InfoItem)a.lastElement()).a).length() >= 8) {
            var2 = var0.substring(0, 8);
            String var3 = var1.substring(0, 8);
            if (var2.equals(var3)) {
               int var4;
               for(var4 = 7; var4 < var0.length() && var4 < var1.length() && (var0.charAt(var4) < '0' || var0.charAt(var4) > '9') && var0.charAt(var4) == var1.charAt(var4); ++var4) {
               }

               var0 = var0.substring(var4, var0.length());
               (new StringBuffer(String.valueOf(var1))).append(", ").append(var0).toString();
               return true;
            }
         }

         return false;
      }
   }

   public static void a(String var0, int var1, mFont var2) {
      // Port TGAME: chặn tầng cuối nếu blockNotify đang bật (gom mọi call InfoMe.a trực tiếp)
      if (ChatManager.shouldBlockNotify(var0)) {
         return;
      }

      if (!b(var0)) {
         if (GameCanvas.aa == 128) {
            g = 1;
         }

         if (a.size() > 10) {
            a.removeElementAt(0);
         }

         a.addElement(new InfoItem(var0, var2, var1));
      }

   }

   public static boolean b() {
      return c == 5 && a.size() == 0;
   }

}
