package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Class_eb {

   public static void a(String var0, String var1, Command1 var2, Command1 var3) {
      (new Thread(new Class_dy(var1, var0, var1, var2, var3))).start();
   }

   public static void a() {
      Session_ME.a.h.start();
   }

}
