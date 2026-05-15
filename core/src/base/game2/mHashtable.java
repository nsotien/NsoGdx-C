package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Hashtable;

public final class mHashtable {
   public Hashtable a = new Hashtable();

   public final Object a(Object var1) {
      return this.a.get(var1);
   }

   public final boolean equals(Object var1) {
      return this.a.equals(var1);
   }

   public final void a(Object var1, Object var2) {
      this.a.put(var1, var2);
   }

}
