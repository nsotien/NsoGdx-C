package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class EPosition {
   public int a;
   public int b;
   public byte c;
   public byte d = 0;
   public short e = -1;

   public EPosition(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public EPosition(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = (byte)var3;
   }

   public EPosition() {
   }

}
