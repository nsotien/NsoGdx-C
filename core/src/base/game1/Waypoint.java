package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Waypoint {
   public short a;
   public short b;
   public short c;
   public short d;

   public Waypoint(short var1, short var2, short var3, short var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

}
