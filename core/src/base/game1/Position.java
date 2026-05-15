package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Position {
   public int a;
   public int b;
   public int c;
   public int d;
   public int e = 0;
   public int f;

   public Position() {
      this.a = 0;
      this.b = 0;
   }

   public Position(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

}
