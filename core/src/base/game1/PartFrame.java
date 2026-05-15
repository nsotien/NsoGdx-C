package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class PartFrame {
   public short a;
   public short b;
   public short c;
   public byte d;
   public byte e = 0;

   public PartFrame(int var1, int var2, int var3) {
      this.a = (short)var3;
      this.b = (short)var1;
      this.c = (short)var2;
   }

}
