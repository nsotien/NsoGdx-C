package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class ChatPopup extends Effect2 implements IActionListener {
   private int g = 100;
   private int h;
   private int i;
   private String[] j;
   private int k;
   private int l;
   private int m;
   private Char n;
   private boolean o = false;
   private int p;
   private String[] q;
   public Command1 e;
   public static ChatPopup f;

   public static void a(String var0, int var1, Char var2) {
      String[] var3;
      if ((var3 = Res.a(var0, "\n", 0)).length == 1) {
         b(var3[0], 1000, var2);
      } else {
         (f = b(var3[0], 1000, var2)).p = 0;
         f.q = var3;
         f.e = new Command1(TextGame.bb, f, 8000, (Object)null);
      }

   }

   public static ChatPopup b(String var0, int var1, Char var2) {
      ChatPopup var3 = new ChatPopup();
      if (var0.length() < 10) {
         var3.g = 64;
      }

      if (GameCanvas.aa == 128) {
         var3.g = 128;
      }

      var3.j = mFont.l.b(var0, var3.g - 10);
      var3.h = var1;
      var3.n = var2;
      var3.k = var2.cx1;
      var3.l = var2.cy1;
      var2.f = var3;
      var3.i = 7;
      Effect2.a.addElement(var3);
      return var3;
   }

   public final void a() {
      if (this.n != null) {
         this.k = this.n.cx1;
         this.l = this.n.cy1;
         this.m = this.n.bg + 10;
      }

      if (this.h > 0) {
         --this.h;
      }

      if (this.i > 1) {
         --this.i;
      }

      if (this.n != null && this.n.f != null && this.n.f != this || this.n != null && this.n.f == null || this.h == 0) {
         Effect2.c.removeElement(this);
         Effect2.a.removeElement(this);
      }

   }

   public final void a(mGraphics var1) {
      int var2 = this.k;
      int var3 = this.l;
      var1.a(16777215);
      var1.b(var2 - this.g / 2 - 1, var3 - this.m - 15 + this.i - this.j.length * 12 - 10, this.g + 2, (this.j.length + 1) * 12 + 1, 12, 12);
      var1.a(0);
      var1.a(var2 - this.g / 2 - 1, var3 - this.m - 15 + this.i - this.j.length * 12 - 10, this.g + 1, (this.j.length + 1) * 12, 12, 12);
      SmallImage.a(var1, 941, var2 - 3, var3 - this.m - 15 + this.i + 2, 0, 17);

      for(int var4 = 0; var4 < this.j.length; ++var4) {
         mFont.g.a(var1, this.j[var4], var2, var3 - this.m - 15 + this.i + var4 * 12 - this.j.length * 12 - 4, 2);
      }

   }

   public final void a(int var1, Object var2) {
      if (var1 == 8000) {
         int var3 = f.p;
         ++var3;
         if (var3 >= f.q.length) {
            f.n.f = null;
            f = null;
            return;
         }

         ChatPopup var4;
         (var4 = b(f.q[var3], f.h, f.n)).p = var3;
         var4.q = f.q;
         var4.e = f.e;
         f = var4;
      }

   }

}
