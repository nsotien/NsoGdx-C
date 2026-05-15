package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class TaskOrder {
   public int a;
   public int b;
   public int c;
   public String d;
   public String e;
   public int f;
   public int g;

   public TaskOrder(byte var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      this.b = var2;
      this.c = var3;
      this.a = var1;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
   }

}
