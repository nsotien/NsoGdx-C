package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class Paint {
   public static int a = 6562304;
   public static int b = 9581056;
   public static int c = 3937280;
   public static int d = 15224576;
   public static int e = 16777215;
   public static int f = 24;
   private static int g = 0;

   public Paint() {
      int[] var10000 = new int[]{15970400, -844109861, 2250052, 16374659, 15906669, 12931125, 3108954};
   }

   public static void a(mGraphics var0, Command1 var1, Command1 var2, Command1 var3) {
      mFont var4 = GameCanvas.g ? mFont.d : mFont.o;
      int var5 = GameCanvas.g ? 3 : 1;
      if (!GameCanvas.g) {
         if (var1 != null) {
            var4.a(var0, var1.a, 5, GameCanvas.ab - mScreen.f + 4 + var5, 0);
         }

         if (var2 != null) {
            var4.a(var0, var2.a, GameCanvas.ac, GameCanvas.ab - mScreen.f + 4 + var5, 2);
         }

         if (var3 != null) {
            if (var3.e != null) {
               var0.a(var3.e, GameCanvas.aa - 5, GameCanvas.ab - 11, 10);
               return;
            }

            var4.a(var0, var3.a, GameCanvas.aa - 5, GameCanvas.ab - mScreen.f + 4 + var5, 1);
            return;
         }
      } else {
         if (var1 != null && (g = var4.a(var1.a)) > 0) {
            if (var1.f > 0 && var1.g > 0) {
               var1.a(var0);
            } else {
               if (mScreen.g == 0) {
                  var0.a(GameScr.eb, 1, GameCanvas.ab - mScreen.f + 1, 0);
               } else {
                  var0.a(GameScr.ea, 1, GameCanvas.ab - mScreen.f + 1, 0);
               }

               var4.a(var0, var1.a, 35, GameCanvas.ab - mScreen.f + 4 + var5, 2);
            }
         }

         if (var2 != null && (g = var4.a(var2.a)) > 0) {
            if (var2.f > 0 && var2.g > 0) {
               var2.a(var0);
            } else {
               if (mScreen.g == 1) {
                  var0.a(GameScr.eb, GameCanvas.ac - 35, GameCanvas.ab - mScreen.f + 1, 0);
               } else {
                  var0.a(GameScr.ea, GameCanvas.ac - 35, GameCanvas.ab - mScreen.f + 1, 0);
               }

               var4.a(var0, var2.a, GameCanvas.ac, GameCanvas.ab - mScreen.f + 4 + var5, 2);
            }
         }

         if (var3 != null && (g = var4.a(var3.a)) > 0) {
            if (var3.f > 0 && var3.g > 0) {
               var3.a(var0);
               return;
            }

            if (mScreen.g == 2) {
               var0.a(GameScr.eb, GameCanvas.aa - 71, GameCanvas.ab - mScreen.f + 1, 0);
            } else {
               var0.a(GameScr.ea, GameCanvas.aa - 71, GameCanvas.ab - mScreen.f + 1, 0);
            }

            var4.a(var0, var3.a, GameCanvas.aa - 35, GameCanvas.ab - mScreen.f + 4 + var5, 2);
         }
      }

   }

   public static void a(mGraphics var0) {
      if (!GameCanvas.g) {
         var0.a(0);
         var0.c(0, GameCanvas.ab - f, GameCanvas.aa, f + 1);
         var0.a(8947848);
         var0.c(0, GameCanvas.ab - (f - 1), GameCanvas.aa, 1);
      }

   }

   public static void a(mGraphics var0, boolean var1, int var2, int var3, int var4, int var5, int var6, int var7, String var8) {
      var0.a(0);
      int var9;
      if (var1) {
         var0.a(GameScr.dy, 0, 81, 29, 27, 0, var2, var3, 0);
         var0.a(GameScr.dy, 0, 135, 29, 27, 0, var2 + var4 - 29, var3, 0);
         var0.a(GameScr.dy, 0, 108, 29, 27, 0, var2 + var4 - 58, var3, 0);

         for(var9 = 0; var9 < (var4 - 58) / 29; ++var9) {
            var0.a(GameScr.dy, 0, 108, 29, 27, 0, var2 + 29 + var9 * 29, var3, 0);
         }
      } else {
         var0.a(GameScr.dy, 0, 0, 29, 27, 0, var2, var3, 0);
         var0.a(GameScr.dy, 0, 54, 29, 27, 0, var2 + var4 - 29, var3, 0);
         var0.a(GameScr.dy, 0, 27, 29, 27, 0, var2 + var4 - 58, var3, 0);

         for(var9 = 0; var9 < (var4 - 58) / 29; ++var9) {
            var0.a(GameScr.dy, 0, 27, 29, 27, 0, var2 + 29 + var9 * 29, var3, 0);
         }
      }

      var0.d(var2 + 3, var3 + 1, var4 - 4, var5 - 4);
      mFont.o.a(var0, var8, var6, var7, 0);
   }

   public static void a(mGraphics var0, boolean var1, int var2, int var3, int var4, int var5, int var6, String var7) {
      var0.a(0);
      int var8;
      if (var1) {
         var0.a(GameScr.dy, 0, 81, 29, 27, 0, var2, var3, 0);
         var0.a(GameScr.dy, 0, 135, 29, 27, 0, var2 + var4 - 29, var3, 0);
         var0.a(GameScr.dy, 0, 108, 29, 27, 0, var2 + var4 - 58, var3, 0);

         for(var8 = 0; var8 < (var4 - 58) / 29; ++var8) {
            var0.a(GameScr.dy, 0, 108, 29, 27, 0, var2 + 29 + var8 * 29, var3, 0);
         }
      } else {
         var0.a(GameScr.dy, 0, 0, 29, 27, 0, var2, var3, 0);
         var0.a(GameScr.dy, 0, 54, 29, 27, 0, var2 + var4 - 29, var3, 0);
         var0.a(GameScr.dy, 0, 27, 29, 27, 0, var2 + var4 - 58, var3, 0);

         for(var8 = 0; var8 < (var4 - 58) / 29; ++var8) {
            var0.a(GameScr.dy, 0, 27, 29, 27, 0, var2 + 29 + var8 * 29, var3, 0);
         }
      }

      mFont.o.a(var0, var7, var5, var6, 0);
   }

   public final void a(mGraphics var1, int var2, int var3, int var4, int var5, String[] var6, Image var7) {
      int var8;
      if (var7 == null) {
         a(var2, var3, var4, var5, var1);
         var8 = var3 + 20 - mFont.o.c();
         var3 = 0;

         for(var8 = var8; var3 < var6.length; var8 += mFont.o.c()) {
            mFont.o.a(var1, var6[var3], var2 + var4 / 2, var8, 2);
            ++var3;
         }
      } else {
         a(var2, var3 - var7.getHeight(), var4, var5 + var7.getHeight(), var1);
         var1.a(var7, var2 + var4 / 2, var3 + var5 / 2 - 4, 33);
         var8 = var3 + 20 - mFont.o.c();
         var3 = 0;

         for(var8 = var8; var3 < var6.length; var8 += mFont.o.c()) {
            mFont.o.a(var1, var6[var3], var2 + var4 / 2, var8 - var7.getHeight(), 2);
            ++var3;
         }
      }

   }

   public static void a(int var0, int var1, int var2, int var3, mGraphics var4) {
      var4.a(a);
      var4.c(var0, var1, var2, var3);
      var4.a(0);
      var4.b(var0 - 2, var1 - 2, var2 + 3, var3 + 3);
      var4.a(13948116);
      var4.b(var0 - 1, var1 - 1, var2 + 1, var3 + 1);
      var4.a(5720393);
      var4.b(var0, var1, var2 - 1, var3 - 1);
      if (GameCanvas.g) {
         var4.a(GameCanvas.aq[0], var0 - 4, var1 - 3, 20);
         var4.a(GameCanvas.aq[0], 0, 0, GameCanvas.ar, GameCanvas.as, 2, var0 + var2 + 4, var1 - 3, StaticObj.c);
         var4.a(GameCanvas.aq[0], 0, 0, GameCanvas.ar, GameCanvas.as, 1, var0 - 4, var1 + var3 + 3, StaticObj.e);
         var4.a(GameCanvas.aq[0], 0, 0, GameCanvas.ar, GameCanvas.as, 3, var0 + var2 + 4, var1 + var3 + 3, StaticObj.f);
         var4.a(GameCanvas.aq[1], var0 + var2 / 2, var1 - 4, StaticObj.a);
      }

   }

   public static void b(int var0, int var1, int var2, int var3, mGraphics var4) {
      var4.a(0);
      var4.b(var0 - 2, var1 - 2, var2 + 3, var3 + 3);
      var4.a(13948116);
      var4.b(var0 - 1, var1 - 1, var2 + 1, var3 + 1);
      var4.a(5720393);
      var4.b(var0, var1, var2 - 1, var3 - 1);
      if (GameCanvas.g) {
         var4.a(GameCanvas.aq[0], var0 - 4, var1 - 3, 20);
         var4.a(GameCanvas.aq[0], 0, 0, GameCanvas.ar, GameCanvas.as, 2, var0 + var2 + 4, var1 - 3, StaticObj.c);
         var4.a(GameCanvas.aq[0], 0, 0, GameCanvas.ar, GameCanvas.as, 1, var0 - 4, var1 + var3 + 3, StaticObj.e);
         var4.a(GameCanvas.aq[0], 0, 0, GameCanvas.ar, GameCanvas.as, 3, var0 + var2 + 4, var1 + var3 + 3, StaticObj.f);
         var4.a(GameCanvas.aq[1], var0 + var2 / 2, var1 - 4, StaticObj.a);
      }

   }

   public static void c(int var0, int var1, int var2, int var3, mGraphics var4) {
      var4.a(a);
      var4.c(var0, var1, var2, var3);
   }

   public static void d(int var0, int var1, int var2, int var3, mGraphics var4) {
      var4.a(b);
      var4.c(var0, var1, var2, var3);
   }

}
