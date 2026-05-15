package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Skills {
   private static mHashtable a = new mHashtable();

   public static void a(Skill var0) {
      a.a(new Short(var0.skillId), var0);
   }

   public static Skill get(short var0) {
      return (Skill)a.a(new Short(var0));
   }

}
