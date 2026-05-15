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

public final class EffectAuto extends Effect2 {
   private short e;
   private MyImage f;
   private int g;
   private int h;
   private int i;
   private int j;
   private byte k = 0;
   private long l = 0L;
   private static EffAutoTemp[] m = new EffAutoTemp[20];
   private static Hashtable n = new Hashtable();
   private static Hashtable o = new Hashtable();
   private boolean p;

   public static void a(short var0, int var1, int var2, byte var3, short var4, int var5) {
      EffectAuto var6;
      (var6 = new EffectAuto()).e = var0;
      var6.g = var1;
      var6.h = var2;
      var6.k = var3;
      if (var6.k < 0) {
         var6.p = true;
      } else {
         var6.p = false;
      }

      if (var4 > 0) {
         var6.l = System.currentTimeMillis() + (long)(var4 * 1000);
      } else {
         var6.l = -1L;
      }

      var6.j = var5;
      Effect2.a.addElement(var6);
   }

   private EffAutoTemp d() {
      return m[this.e];
   }

   public final void a(mGraphics var1) {
      if (this.f != null && this.f.a != null && this.d().c != null) {
         Frame var2 = this.d().b[this.d().c[this.i]];

         for(int var3 = 0; var3 < var2.a.length; ++var3) {
            EffAutoTemp var10000 = this.d();
            byte var5 = var2.c[var3];
            ImageInfo var4 = var10000.a[var5];
            if (this.j > 0) {
               var1.a(this.f.a, var4.a, var4.b, var4.c, var4.d, 0, this.g + var2.a[var3], this.h + var2.b[var3] - 1, 20);
            } else {
               var1.a(this.f.a, var4.a, var4.b, var4.c, var4.d, 2, this.g - var2.a[var3], this.h + var2.b[var3] - 1, 24);
            }
         }
      }

   }

   public final void a() {
      try {
         m[this.e] = (EffAutoTemp)o.get(String.valueOf(this.e));
         if (m[this.e] == null) {
            m[this.e] = new EffAutoTemp();
            o.put(String.valueOf(this.e), m[this.e]);
            this.d().d = System.currentTimeMillis();
            Service.gI().a((byte)1, (short)this.e);
         } else if (this.d().c == null && System.currentTimeMillis() - this.d().d > 3000L) {
            this.d().d = System.currentTimeMillis();
            Service.gI().a((byte)1, (short)this.e);
         }

         if (this.d().c != null) {
            this.f = (MyImage)n.get(String.valueOf(this.e));
            if (this.f == null) {
               this.f = new MyImage();
               n.put(String.valueOf(this.e), this.f);
               this.f.a = Controller.a(RMS.a("effauto " + this.e));
               if (this.f.a == null) {
                  this.f.b = System.currentTimeMillis();
                  Service.gI().a((byte)0, (short)this.e);
               }
            } else if (this.f.a == null && System.currentTimeMillis() - this.f.b > 6000L) {
               this.f.b = System.currentTimeMillis();
               Service.gI().a((byte)0, (short)this.e);
            }
         }

         if (this.f != null && this.f.a != null && this.d().c != null) {
            ++this.i;
            if (this.i >= this.d().c.length) {
               if (this.l != -1L) {
                  if (this.l - System.currentTimeMillis() <= 0L) {
                     Effect2.a.removeElement(this);
                  } else {
                     this.i = 0;
                  }
               } else {
                  label63: {
                     if (!this.p) {
                        --this.k;
                        if (this.k <= 0) {
                           Effect2.a.removeElement(this);
                           break label63;
                        }
                     }

                     this.i = 0;
                  }
               }
            }

            this.f.c = System.currentTimeMillis();
            return;
         }
      } catch (Exception var2) {
         ;
      }

   }

   public static void a(short var0, byte[] var1) {
      if (((EffAutoTemp)o.get(String.valueOf(var0))).c == null) {
         new EffAutoTemp();
         EffAutoTemp var2 = c(var0, var1);
         o.put(String.valueOf(var0), var2);
      }

   }

   private static EffAutoTemp c(short var0, byte[] var1) {
      try {
         EffAutoTemp var6 = new EffAutoTemp();
         ByteArrayInputStream var7 = new ByteArrayInputStream(var1);
         DataInputStream var8 = new DataInputStream(var7);
         var6.a = new ImageInfo[var8.readByte()];

         int var2;
         for(var2 = 0; var2 < var6.a.length; ++var2) {
            var6.a[var2] = new ImageInfo();
            var8.readByte();
            var6.a[var2].a = var8.readUnsignedByte();
            var6.a[var2].b = var8.readUnsignedByte();
            var6.a[var2].c = var8.readUnsignedByte();
            var6.a[var2].d = var8.readUnsignedByte();
         }

         var6.b = new Frame[var8.readShort()];

         int var3;
         for(var2 = 0; var2 < var6.b.length; ++var2) {
            var6.b[var2] = new Frame();
            var3 = var8.readByte();
            var6.b[var2].a = new short[var3];
            var6.b[var2].b = new short[var3];
            var6.b[var2].c = new byte[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
               var6.b[var2].a[var4] = var8.readShort();
               var6.b[var2].b[var4] = var8.readShort();
               var6.b[var2].c[var4] = var8.readByte();
            }
         }

         short var9 = var8.readShort();
         var6.c = new short[var9];

         for(var3 = 0; var3 < var9; ++var3) {
            var6.c[var3] = var8.readShort();
         }

         return var6;
      } catch (Exception var8) {
         return null;
      }
   }

   public static void b(short var0, byte[] var1) {
      MyImage var2;
      if ((var2 = (MyImage)n.get(String.valueOf(var0))) == null) {
         var2 = new MyImage();
         n.put(String.valueOf(var0), var2);
      }

      var2.a = Controller.a(var1);
      if (GameMidlet.a != 1) {
         RMS.b("effauto " + var0, var1);
      }

   }

   public static void b() {
      try {
         Enumeration var0 = n.keys();

         while(var0.hasMoreElements()) {
            String var1 = (String)var0.nextElement();
            MyImage var2 = (MyImage)n.get(var1);
            if (System.currentTimeMillis() - var2.c > 60000L) {
               n.remove(var1);
            }
         }
      } catch (Exception var3) {
      }

   }

   public static void c() {
      try {
         Enumeration var0 = o.keys();

         while(var0.hasMoreElements()) {
            String var1 = (String)var0.nextElement();
            EffAutoTemp var2 = (EffAutoTemp)o.get(var1);
            if (System.currentTimeMillis() - var2.e > 600000L) {
               o.remove(var1);
            }
         }
      } catch (Exception var3) {
      }

   }

}
