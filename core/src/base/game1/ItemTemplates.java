package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class ItemTemplates {
   public static mHashtable a = new mHashtable();

   public static void a(ItemTemplate var0) {
      a.a(new Short(var0.id), var0);
   }

   public static ItemTemplate a(short var0) {
      return (ItemTemplate)a.a(new Short(var0));
   }

   public static short b(short var0) {
      return a(var0).iconID;
   }

}
