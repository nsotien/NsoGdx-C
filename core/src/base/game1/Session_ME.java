package base.game1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.io.SocketConnection;

public final class Session_ME {
   protected static Session_ME a = new Session_ME();
   public boolean b = false;
   private DataOutputStream q;
   public DataInputStream c;
   public Controller d;
   public SocketConnection e;
   public boolean f;
   public boolean g;
   private final Class_ar r = new Class_ar(this);
   public Thread h;
   public Thread i;
   public Thread l1;
   public Thread l2;
   public int j;
   public int k;
   boolean l;
   public byte[] m = null;
   private byte s;
   private byte t;
   long n;
   public String o = "";
   public static boolean p;
   private MyVector u;

   public static Session_ME a() {
      return a;
   }

   public final boolean b() {
      return this.f;
   }

   public final void a(Controller var1) {
      this.d = var1;
   }

   public final void a(String var1) {
      DebugLog.log("Session", "connect to " + var1 + ":" + GameMidlet.c + " connected=" + this.f + " connecting=" + this.g);
      if (!this.f && !this.g) {
         this.l = false;
         this.e = null;
         this.h = new Thread(new Class_bu(this, var1));
         Class_eb.a();
      }

   }

   private static int _packetSendCounter = 0;
   public final void a(Message var1) {
      // P2 A1#4: g4 cross-check moi 100 packet — fail thi corrupt 1 byte trong packet (server kick).
      if (com.monkey.nso.LicenseGuard.isVerifyStarted() && (++_packetSendCounter % 100) == 0
              && !com.monkey.nso.LicenseGuard.g4()) {
         try {
            byte[] payload = var1.a();
            if (payload != null && payload.length > 0) payload[0] ^= 0x5A;
         } catch (Throwable ignored) {}
      }
      // P2 N6 D1: shouldDegrade -> 5% drop packet random (game lag bat thuong, khong crash).
      if (com.monkey.nso.LicenseGuard.shouldDegrade() && Math.random() < 0.05) {
         return; // skip queue add
      }
      this.r.a.u.addElement(var1);
   }

   private synchronized void b(Message var1) {
      byte[] var2 = var1.a();

      try {
         int var3;
         if (this.l) {
            var3 = this.a(var1.command);
            this.q.writeByte(var3);
         } else {
            this.q.writeByte(var1.command);
         }

         (new StringBuffer("cmd send ---> ")).append(var1.command).toString();
         if (var2 == null) {
            this.q.writeShort(0);
            this.j += 5;
         } else {
            var3 = var2.length;
            int var5;
            if (var1.command != -31 && this.l) {
               var5 = this.a((byte)(var3 >> 8));
               this.q.writeByte(var5);
               var5 = this.a((byte)var3);
               this.q.writeByte(var5);
            } else {
               this.q.writeShort(var3);
            }

            if (this.l) {
               for(var5 = 0; var5 < var2.length; ++var5) {
                  var2[var5] = this.a(var2[var5]);
               }
            }

            this.q.write(var2);
            this.j += 5 + var2.length;
         }

         this.q.flush();
      } catch (IOException var5) {
         ;
      }

   }

   private byte a(byte var1) {
      byte[] var10000 = this.m;
      byte var10003 = this.t;
      this.t = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (this.t >= this.m.length) {
         this.t = (byte)(this.t % this.m.length);
      }

      return var1;
   }

   public final void c() {
      Code.get_code.stop();
      this.d();
   }

   private void d() {
      this.m = null;
      this.s = 0;
      this.t = 0;
      this.l = false;
      this.f = false;
      this.g = false;
      this.u.removeAllElements();

      try {
         if (this.e != null) {
            this.e.close();
            this.e = null;
         }

         if (this.q != null) {
            this.q.close();
            this.q = null;
         }

         if (this.c != null) {
            this.c.close();
            this.c = null;
         }

         if (this.l1 != null) {
            if (this.l1.isAlive()) {
               this.l1.interrupt();
            }

            this.l1 = null;
         }

         if (this.l2 != null) {
            if (this.l2.isAlive()) {
               this.l2.interrupt();
            }

            this.l2 = null;
         }

         if (this.h != null) {
            if (this.h.isAlive()) {
               this.h.interrupt();
            }

            this.h = null;
         }

         if (this.i != null) {
            if (this.i.isAlive()) {
               this.i.interrupt();
            }

            this.i = null;
         }

         System.gc();
      } catch (Exception var2) {
         ;
      }

   }

   static void a(Session_ME var0, DataOutputStream var1) {
      var0.q = var1;
   }

   static Class_ar a(Session_ME var0) {
      return var0.r;
   }

   static void a(Session_ME var0, Message var1) {
      var0.b(var1);
   }

   static void a(Session_ME var0, MyVector var1) {
      var0.u = var1;
   }

   static MyVector b(Session_ME var0) {
      return var0.u;
   }

   static void c(Session_ME var0) {
      var0.d();
   }

   static byte a(Session_ME var0, byte var1) {
      byte[] var10000 = var0.m;
      byte var10003 = var0.s;
      var0.s = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (var0.s >= var0.m.length) {
         var0.s = (byte)(var0.s % var0.m.length);
      }

      return var1;
   }

}
