package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class FrameImage {
   private int a;
   private int b;
   private int c;
   private Image d;
   private int[] e;
   private int f;

   public FrameImage(Image var1, int var2, int var3) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.f = var1.getHeight();
      this.c = this.f / var3;
      this.e = new int[this.c];

      for(int var4 = 0; var4 < this.c; ++var4) {
         this.e[var4] = var4 * var3;
      }

   }

   public final void a(int var1, int var2, int var3, int var4, int var5, mGraphics var6) {
      if (var1 >= 0 && var1 < this.c) {
         var6.a(this.d, 0, this.e[var1], this.a, this.b, var4, var2, var3, var5);
      }

   }

}
