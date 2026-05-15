package base.game2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.lcdui.Image;

public final class SmallImage {
   public static int[][] a;
   private static Image[] g;
   public static Hashtable b = new Hashtable();
   public short c;
   public short d;
   public short e;
   public short f;

   public SmallImage(int var1, int var2, int var3, int var4, int var5) {
      this.c = (short)var2;
      this.d = (short)var3;
      this.e = (short)var4;
      this.f = (short)var5;
   }

   public static void a() {
      try {
         Enumeration var0 = b.keys();

         while(var0.hasMoreElements()) {
            String var1 = (String)var0.nextElement();
            MyImage var2 = (MyImage)b.get(var1);
            if (System.currentTimeMillis() - var2.c > 180000L) {
               b.remove(var1);
            }
         }
      } catch (Exception var3) {
      }

   }

   public static void b() {
      g = null;
      System.gc();
   }

   public static void c() {
      g = null;
      System.gc();
      g = new Image[]{GameCanvas.c("/img/Big0.png"), GameCanvas.c("/img/Big1.png"), GameCanvas.c("/img/Big2.png"), GameCanvas.c("/img/Big3.png"), GameCanvas.c("/img/Big4.png")};
      Image.createRGBImage(new int[]{-2013265920}, 1, 1, true);
   }

   public SmallImage() {
      e();
   }

   public static void d() {
      new SmallImage();
   }

   private static void e() {
      try {
         DataInputStream var0;
         short var1;
         a = new int[var1 = (var0 = new DataInputStream(new ByteArrayInputStream(RMS.a("nj_image")))).readShort()][5];

         for(int var2 = 0; var2 < var1; ++var2) {
            a[var2][0] = var0.readUnsignedByte();
            a[var2][1] = var0.readShort();
            a[var2][2] = var0.readShort();
            a[var2][3] = var0.readShort();
            a[var2][4] = var0.readShort();
         }
      } catch (Exception var3) {
         ;
      }

   }

   public static void a(int var0, byte[] var1) {
      MyImage var2;
      if ((var2 = (MyImage)b.get(String.valueOf(var0))) == null) {
         var2 = new MyImage();
         b.put(String.valueOf(var0), var2);
      }

      var2.a = Controller.a(var1);
      if (GameMidlet.a != 1) {
         RMS.b(String.valueOf(var0), var1);
      }

   }

   public static boolean a(int var0) {
      if (var0 >= a.length || a[var0][1] >= g[a[var0][0]].getWidth() || a[var0][3] >= g[a[var0][0]].getWidth() || a[var0][2] >= g[a[var0][0]].getHeight() || a[var0][4] >= g[a[var0][0]].getHeight()) {
         MyImage var1;
         if ((var1 = (MyImage)b.get(String.valueOf(var0))) == null) {
            var1 = new MyImage();
            b.put(String.valueOf(var0), var1);
            var1.a = Controller.a(RMS.a(String.valueOf(var0)));
            if (var1.a == null) {
               var1.b = System.currentTimeMillis();
               Service.gI().ae(var0);
            }

            return false;
         }

         if (var1.a != null) {
            return true;
         }

         if (var1.a == null && System.currentTimeMillis() - var1.b > 60000L) {
            var1.b = System.currentTimeMillis();
            Service.gI().ae(var0);
            return false;
         }
      }

      return true;
   }

   public static int b(int var0) {
      return a[var0][4];
   }

   public static void a(mGraphics var0, int var1, int var2, int var3, int var4, int var5) {
      if (var1 < a.length && a[var1][1] < g[a[var1][0]].getWidth() && a[var1][3] < g[a[var1][0]].getWidth() && a[var1][2] < g[a[var1][0]].getHeight() && a[var1][4] < g[a[var1][0]].getHeight()) {
         var0.a(g[a[var1][0]], a[var1][1], a[var1][2], a[var1][3], a[var1][4], var4, var2, var3, var5);
      } else {
         MyImage var6;
         if ((var6 = (MyImage)b.get(String.valueOf(var1))) == null) {
            var6 = new MyImage();
            b.put(String.valueOf(var1), var6);
            var6.a = Controller.a(RMS.a(String.valueOf(var1)));
            if (var6.a == null) {
               var6.b = System.currentTimeMillis();
               Service.gI().ae(var1);
            }
         } else if (var6.a == null && System.currentTimeMillis() - var6.b > 60000L) {
            var6.b = System.currentTimeMillis();
            Service.gI().ae(var1);
         }

         if (var6 != null) {
            if (var6.a != null) {
               var0.a(var6.a, 0, 0, var6.a.getWidth(), var6.a.getHeight(), var4, var2, var3, var5);
            }

            var6.c = System.currentTimeMillis();
            return;
         }
      }

   }

   public static void a(mGraphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var1 < a.length && a[var1][1] < g[a[var1][0]].getWidth() && a[var1][3] < g[a[var1][0]].getWidth() && a[var1][2] < g[a[var1][0]].getHeight() && a[var1][4] < g[a[var1][0]].getHeight()) {
         var0.a(g[a[var1][0]], a[var1][1], a[var1][2], a[var1][3], a[var1][4], 0, var2, var3, 3);
      } else {
         MyImage var7;
         if ((var7 = (MyImage)b.get(String.valueOf(var1))) == null) {
            var7 = new MyImage();
            b.put(String.valueOf(var1), var7);
            var7.a = Controller.a(RMS.a(String.valueOf(var1)));
            if (var7.a == null) {
               var7.b = System.currentTimeMillis();
               Service.gI().ae(var1);
            }
         } else if (var7.a == null && System.currentTimeMillis() - var7.b > 60000L) {
            var7.b = System.currentTimeMillis();
            Service.gI().ae(var1);
         }

         if (var7 != null) {
            if (var7.a != null) {
               if (var7.a.getHeight() > 35) {
                  var1 = var7.a.getWidth();
                  var5 = var7.a.getHeight() / 3;
                  var0.a(var7.a, 0, var6 * var5, var1, var5, 0, var2, var3, 3);
               } else {
                  var0.a(var7.a, 0, 0, var7.a.getWidth(), var7.a.getHeight(), 0, var2, var3, 3);
               }
            }

            var7.c = System.currentTimeMillis();
            return;
         }
      }

   }

}
