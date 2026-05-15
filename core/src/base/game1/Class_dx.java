package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

final class Class_dx implements Runnable {

   public final void run() {
      try {
         Thread.sleep(20000L);
      } catch (InterruptedException var3) {
      }

      if (Session_ME.a.g) {
         try {
            Session_ME.a.e.close();
         } catch (Exception var2) {
         }

         Session_ME.p = true;
         Session_ME.a.g = false;
         Session_ME.a.f = false;
         Session_ME.a.d.b();
      }

   }

}
