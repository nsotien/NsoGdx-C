package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class InfoDlg {
   static boolean a;
   private static String d;
   private static String e;
   public static int b;
   public static boolean c;

   public static void a(String var0, String var1, int var2) {
      if (var0 != null) {
         a = true;
         d = var0;
         e = var1;
         b = var2;
      }

   }

   public static void a() {
      a(TextGame.y, (String)null, 5000);
      c = true;
   }

   public static void a(String var0) {
      a(var0, (String)null, 5000);
      c = true;
   }

   public static void a(mGraphics var0) {
      String var1 = d;
      if (TileMap.mapName1 != null) {
         var1 = TileMap.mapName1;
      }

      if (a && (!c || b <= 4990) && !GameScr.co) {
         Paint.a(GameCanvas.ac - 64, 10, 128, 40, var0);
         if (c) {
            GameCanvas.a(GameCanvas.ac - mFont.o.a(var1) / 2 - 10, 30, var0, false);
            mFont.o.a(var0, var1, GameCanvas.ac + 5, 23, 2);
         } else if (e != null) {
            mFont.o.a(var0, var1, GameCanvas.ac, 18, 2);
            mFont.i.a(var0, e, GameCanvas.ac, 32, 2);
         } else {
            mFont.o.a(var0, var1, GameCanvas.ac, 23, 2);
         }
      }

   }

   public static void b() {
      d = "";
      e = null;
      c = false;
      b = 0;
      a = false;
   }

}
