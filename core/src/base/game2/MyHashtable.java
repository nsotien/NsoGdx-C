package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Hashtable;

public final class MyHashtable extends Hashtable {

   public final synchronized Object a(String var1, Object var2) {
      return super.put(var1, var2);
   }

   public final synchronized void clear() {
      super.clear();
   }

   public final synchronized Object remove(Object var1) {
      return super.remove(var1);
   }

   public final synchronized Object a(String var1) {
      return super.get(var1);
   }

}
