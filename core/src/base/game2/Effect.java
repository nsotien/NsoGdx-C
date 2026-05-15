package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Effect {
   public static EffectTemplate[] a;
   public int b;
   public int c;
   public short d;
   public EffectTemplate e;

   public Effect(byte var1, int var2, int var3, short var4) {
      this.e = a[var1];
      this.b = var2;
      this.c = var3 / 1000;
      this.d = var4;
   }

}
