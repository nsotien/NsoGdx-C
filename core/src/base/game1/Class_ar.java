package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

final class Class_ar implements Runnable {
   final Session_ME a;

   public Class_ar(Session_ME var1) {
      this.a = var1;
      Session_ME.a(var1, new MyVector());
   }

   public final void run() {
      while(this.a.f) {
         try {
            if (this.a.l) {
               while(Session_ME.b(this.a).size() > 0) {
                  Message var1 = (Message)Session_ME.b(this.a).elementAt(0);
                  Session_ME.b(this.a).removeElementAt(0);
                  Session_ME.a(this.a, var1);
               }
            }

            try {
               Thread.sleep(10L);
            } catch (InterruptedException var2) {
            }
         } catch (Exception var3) {
            ;
         }
      }

   }

}
