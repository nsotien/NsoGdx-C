package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class Class_bu implements Runnable {
   private final String a;
   private Session_ME b;



   Class_bu(Session_ME var1, String var2) {
      this.b = var1;
      this.a = var2;
//      this.a = "socket://112.213.94.135:14444";
   }




   public final void run() {
      (this.b.l1 = new Thread(new Class_dx())).start();
      this.b.g = true;
      this.b.f = true;

      try {
         String var2 = this.a;
         this.b.e = (SocketConnection)Connector.open(var2);
         Session_ME.a(this.b, this.b.e.openDataOutputStream());
         this.b.c = this.b.e.openDataInputStream();
         (this.b.l2 = new Thread(Session_ME.a(this.b))).start();
         this.b.i = new Thread(new Class_dr(this.b));
         this.b.i.start();
         this.b.n = System.currentTimeMillis();
         Session_ME.a(this.b, new Message((byte)-27));
         this.b.g = false;
         Controller var1 = this.b.d;
         ;
      } catch (Exception var4) {
         try {
            Thread.sleep(500L);
         } catch (InterruptedException var3) {
         }

         this.b.c();
         if (this.b.d != null) {
            this.b.d.b();
         }
      }

   }

}
