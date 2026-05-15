package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class MovePoint {
   public int a;
   public int b;
   public int c;

   public MovePoint(int var1, int var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public MovePoint(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

}
