package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class phong1 {
   private static boolean c = false;
   public static boolean a = false;
   public static boolean b = false;
   private static boolean d = false;
   private static boolean e = false;
   private static boolean f = false;
   private static boolean g = false;
   private static boolean h = false;
   private static boolean i = false;
   private static boolean j = false;
   private static boolean k = false;
   private static boolean l = false;
   private static boolean m = false;
   private static boolean n = false;
   private static boolean o = false;
   private static boolean p = false;
   private static boolean q = false;
   private static Object r = new Object();
   private static int s;

   public static void a() {
      c = true;
      synchronized(r) {
         try {
            r.wait(2000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void aWait(long l) {
      synchronized(r) {
         try {
            r.wait(l);
         } catch (InterruptedException var5) {
         }

      }
   }

   public static void b() {
      if (c) {
         synchronized(r) {
            r.notifyAll();
         }

         c = false;
      }

   }

   public static boolean c() {
      b = true;
      long var0 = System.currentTimeMillis();
      synchronized(r) {
         try {
            r.wait(350L);
         } catch (InterruptedException var5) {
         }
      }

      return System.currentTimeMillis() - var0 < 350L;
   }

   public static void d() {
      if (b) {
         synchronized(r) {
            r.notifyAll();
         }

         b = false;
      }

   }

   public static void e() {
      d = true;
      synchronized(r) {
         try {
            r.wait(2000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void f() {
      if (d) {
         synchronized(r) {
            r.notifyAll();
         }

         d = false;
      }

   }

   public static void g() {
      e = true;
      synchronized(r) {
         try {
            r.wait(2000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void h() {
      if (e) {
         synchronized(r) {
            r.notifyAll();
         }

         e = false;
      }

   }

   public static void i() {
      j = true;
      synchronized(r) {
         try {
            r.wait();
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void j() {
      if (j) {
         synchronized(r) {
            r.notifyAll();
         }

         j = false;
      }

   }

   public static void k() {
      f = true;
      synchronized(r) {
         try {
            r.wait(2000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void l() {
      if (f) {
         synchronized(r) {
            r.notifyAll();
         }

         f = false;
      }

   }

   public static void m() {
      g = true;
      synchronized(r) {
         try {
            r.wait(2000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void n() {
      if (g) {
         synchronized(r) {
            r.notifyAll();
         }

         g = false;
      }

   }

   public static void o() {
      h = true;
      synchronized(r) {
         try {
            r.wait(2000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void p() {
      if (h) {
         synchronized(r) {
            r.notifyAll();
         }

         h = false;
      }

   }

   public static boolean q() {
      i = true;
      long var0 = System.currentTimeMillis();
      synchronized(r) {
         try {
            r.wait(2000L);
         } catch (InterruptedException var5) {
         }
      }

      return System.currentTimeMillis() - var0 < 2000L;
   }

   public static void r() {
      if (i) {
         synchronized(r) {
            r.notifyAll();
         }

         i = false;
      }

   }

   public static boolean s() {
      k = true;
      long var0 = System.currentTimeMillis();
      synchronized(r) {
         try {
            r.wait(7000L);
         } catch (InterruptedException var5) {
         }
      }

      return System.currentTimeMillis() - var0 < 7000L;
   }

   public static void t() {
      if (k) {
         synchronized(r) {
            r.notifyAll();
         }

         k = false;
      }

   }

   public static boolean u() {
      s = Auto.my_skill != null ? Auto.my_skill.point : 0;
      l = true;
      synchronized(r) {
         try {
            r.wait(3000L);
         } catch (InterruptedException var3) {
         }
      }

      return Auto.my_skill == null || Auto.my_skill.point > s;
   }

   public static void v() {
      if (l) {
         synchronized(r) {
            r.notifyAll();
         }

         l = false;
      }

   }

   public static void w() {
      m = true;
      synchronized(r) {
         try {
            r.wait(3000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void x() {
      if (m) {
         synchronized(r) {
            r.notifyAll();
         }

         m = false;
      }

   }

   public static boolean y() {
      n = true;
      long var0 = System.currentTimeMillis();
      synchronized(r) {
         try {
            r.wait(5000L);
         } catch (InterruptedException var5) {
         }
      }

      return System.currentTimeMillis() - var0 < 5000L;
   }

   public static void z() {
      if (n) {
         synchronized(r) {
            r.notifyAll();
         }

         n = false;
      }

   }

   public static void ab() {
      if (o) {
         synchronized(r) {
            r.notifyAll();
         }

         o = false;
      }

   }

   public static void ac() {
      p = true;
      synchronized(r) {
         try {
            r.wait(500L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void ad() {
      if (p) {
         synchronized(r) {
            r.notifyAll();
         }

         p = false;
      }

   }

   public static boolean ae() {
      ;
      q = true;
      long var0 = System.currentTimeMillis();
      synchronized(r) {
         try {
            r.wait(10000L);
         } catch (InterruptedException var5) {
         }
      }

      return System.currentTimeMillis() - var0 < 10000L;
   }

   public static void af() {
      ;
      if (q) {
         synchronized(r) {
            r.notifyAll();
         }

         q = false;
      }

   }

   public static boolean ag() {
      int var0 = 0;

      label31:
      while(var0 < Code.listParty.size()) {
         String var1 = (String)Code.listParty.elementAt(var0);

         for(int var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
            Party var3;
            if ((var3 = (Party)GameScr.vParty.elementAt(var2)).d.equals(var1)) {
               if (var3.f == null || Res.a(Char.getMyChar().cx1, Char.getMyChar().cy1, var3.f.cx1, var3.f.cy1) > 100) {
                  return false;
               }

               ++var0;
               continue label31;
            }
         }

         return false;
      }

      return true;
   }

   public static boolean ah() {
      label24:
      for(int var0 = 0; var0 < Code.listParty.size(); ++var0) {
         String var1 = (String)Code.listParty.elementAt(var0);

         for(int var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
            if (((Party)GameScr.vParty.elementAt(var2)).d.equals(var1)) {
               continue label24;
            }
         }

         return false;
      }

      return true;
   }

   public static void a(long var0) {
      if (Code.ig_lead != null) {
         long var2 = System.currentTimeMillis();

         while(!ag() && System.currentTimeMillis() - var2 < var0) {
            phong.sleep(2000L);
         }
      }

   }

   public static void ai() {
      if (Code.ig_lead != null) {
         long var2 = System.currentTimeMillis();

         while(true) {
            int var0 = 0;

            boolean var10000;
            label37:
            while(true) {
               if (var0 >= Code.listParty.size()) {
                  var10000 = true;
                  break;
               }

               String var1 = (String)Code.listParty.elementAt(var0);

               for(int var4 = 0; var4 < GameScr.vParty.size(); ++var4) {
                  Party var5;
                  if ((var5 = (Party)GameScr.vParty.elementAt(var4)).d.equals(var1)) {
                     if (var5.f == null) {
                        var10000 = false;
                        break label37;
                     }

                     ++var0;
                     continue label37;
                  }
               }

               var10000 = false;
               break;
            }

            if (var10000 || System.currentTimeMillis() - var2 >= 300000L) {
               return;
            }

            phong.sleep(2000L);
         }
      }
   }

   public static void aj() {
      if (Code.ig_lead != null) {
         long var0 = System.currentTimeMillis();

         while(!ah() && System.currentTimeMillis() - var0 < 60000L) {
            phong.sleep(2000L);
         }
      }

   }

   public static void ak() {
      synchronized(r) {
         r.notifyAll();
      }

      b = false;
      d = false;
      e = false;
      f = false;
      g = false;
      h = false;
      j = false;
      c = false;
      i = false;
      a = false;
      k = false;
      l = false;
      m = false;
      n = false;
      o = false;
      p = false;
      TileMap.phong_ae = false;
      TileMap.g();
   }

}
