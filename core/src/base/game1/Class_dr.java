package base.game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

final class Class_dr implements Runnable {
   private Session_ME a;

   Class_dr(Session_ME var1) {
      this.a = var1;
   }

   public final void run() {
      label88:
      while(true) {
         while(true) {
            try {
               if (!this.a.b()) {
                  break label88;
               }

               Class_dr var10 = this;
               byte var2 = this.a.c.readByte();
               if (this.a.l) {
                  var2 = Session_ME.a(this.a, var2);
               }

               int var3;
               byte var4;
               int var5;
               int var6;
               int var7;
               if (var2 == -32) {
                  var2 = this.a.c.readByte();
                  if (this.a.l) {
                     var2 = Session_ME.a(this.a, var2);
                  }

                  var4 = Session_ME.a(this.a, this.a.c.readByte());
                  var5 = Session_ME.a(this.a, this.a.c.readByte());
                  var6 = Session_ME.a(this.a, this.a.c.readByte());
                  var7 = Session_ME.a(this.a, this.a.c.readByte());
                  var3 = (var4 & 255) << 24 | (var5 & 255) << 16 | (var6 & 255) << 8 | var7 & 255;
               } else if (this.a.l) {
                  var4 = this.a.c.readByte();
                  var5 = this.a.c.readByte();
                  var3 = (Session_ME.a(this.a, var4) & 255) << 8 | Session_ME.a(this.a, (byte)var5) & 255;
               } else {
                  var3 = this.a.c.readUnsignedShort();
               }

               byte[] var12 = new byte[var3];
               var5 = 0;
               var6 = 0;

               while(var5 != -1 && var6 < var3) {
                  if ((var5 = var10.a.c.read(var12, var6, var3 - var6)) > 0) {
                     var6 += var5;
                     Session_ME var10000 = var10.a;
                     var10000.k += var6 + 5;
                     var7 = Session_ME.a().k + Session_ME.a().j;
                     var10.a.o = var7 / 1024 + "." + var7 % 1024 / 102 + "Kb";
                  }
               }

               if (var10.a.l) {
                  for(var7 = 0; var7 < var12.length; ++var7) {
                     var12[var7] = Session_ME.a(var10.a, var12[var7]);
                  }
               }

               Message var11 = new Message(var2, var12);

               try {
                  if (var11.command == -27) {
                     this.a(var11);
                  } else {
                     this.a.d.a(var11);
                  }
               } catch (Exception var1111) {
                  ;
               }
            } catch (Exception var12) {
               break label88;
            }
         }
      }

      if (this.a.f) {
         if (this.a.d != null) {
            if (System.currentTimeMillis() - this.a.n > 500L) {
               Controller var1 = this.a.d;
               phong.onDisconnect();
            } else {
               this.a.d.b();
            }
         }

         if (this.a.e != null) {
            Session_ME.c(this.a);
         }
      }

   }

   private void a(Message var1) {
      try {
         byte var2 = var1.b().readByte();
         this.a.m = new byte[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.a.m[var3] = var1.b().readByte();
         }

         for(var3 = 0; var3 < this.a.m.length - 1; ++var3) {
            byte[] var10000 = this.a.m;
            var10000[var3 + 1] ^= this.a.m[var3];
         }

         this.a.l = true;
      } catch (IOException var5) {
         ;
      }

   }

}
