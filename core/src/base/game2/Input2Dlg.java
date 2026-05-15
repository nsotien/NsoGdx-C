package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class Input2Dlg extends Dialog implements IActionListener {
   private String[] f;
   public TField a;
   public TField b;
   private int g;
   private int h;
   private int i;
   private int j;

   public Input2Dlg() {
      new Command1("", 1000, (Object)null);
      this.a = new TField();
      this.b = new TField();
   }

   public final void a(String var1, String var2) {
      this.j = mFont.o.a(var1) > mFont.o.a(var2) ? mFont.o.a(var1) : mFont.o.a(var2);
      this.g = 40;
      this.h = 0;
      if (GameCanvas.aa <= 176) {
         this.g = 10;
      }

      this.a.a = this.g + this.j + 10;
      this.a.b = GameCanvas.ab - 2 * mScreen.d - 50;
      this.a.c = GameCanvas.aa - 2 * this.g - this.j - 20;
      this.a.d = mScreen.d + 2;
      this.a.e = true;
      this.a.f = var1;
      this.b.a = this.g + this.j + 10;
      this.b.b = GameCanvas.ab - mScreen.d - 43;
      this.b.c = GameCanvas.aa - 2 * this.g - this.j - 20;
      this.b.d = mScreen.d + 2;
      this.b.f = var2;
      super.e = this.a.l;
   }

   public final void a(String var1, Command1 var2, Command1 var3, int var4, int var5) {
      this.a.a("");
      this.a.c(var4);
      this.b.a("");
      this.b.c(var5);
      this.f = mFont.o.b(var1, GameCanvas.aa - this.g * 3);
      MyVector var6 = mFont.o.a(var1, GameCanvas.aa - this.g * 3);
      this.i = var6.size();
      super.c = var2;
      super.d = var3;
      GameCanvas.aj = this;
   }

   public final void a(mGraphics var1) {
      GameCanvas.an.a(var1, this.g, GameCanvas.ab - 85 - mScreen.f - this.i * 13, GameCanvas.aa - (this.g << 1), 80 + this.i * 13, this.f, (Image)null);
      mFont.o.a(var1, this.a.f + ": ", this.a.a - this.j - 5, this.a.b + 5, 0);
      this.a.a(var1);
      var1.d(0, 0, GameCanvas.aa, GameCanvas.ab);
      mFont.o.a(var1, this.b.f + ": ", this.b.a - this.j - 5, this.b.b + 5, 0);
      this.b.a(var1);
      super.a(var1);
   }

   public final void a(int var1) {
      if (this.h == 0) {
         this.a.a(var1);
      } else {
         this.b.a(var1);
      }

      super.a(var1);
   }

   public final void b() {
      if (GameCanvas.n[2]) {
         this.h = 0;
      }

      if (GameCanvas.n[8]) {
         this.h = 1;
      }

      if (this.h == 0) {
         this.a.e = true;
         this.b.e = false;
         super.e = this.a.l;
         this.a.c();
      } else {
         this.a.e = false;
         this.b.e = true;
         super.e = this.b.l;
         this.b.c();
      }

      if (GameCanvas.g && GameCanvas.r && GameCanvas.q) {
         if (GameCanvas.b(this.a.a, this.a.b, this.a.c, this.a.d)) {
            this.h = 0;
         }

         if (GameCanvas.b(this.b.a, this.b.b, this.b.c, this.b.d)) {
            this.h = 1;
         }
      }

      if (super.c != null) {
         super.c.f = GameCanvas.aa / 2 - 160;
         super.c.g = GameCanvas.ab - 26;
      }

      if (super.d != null) {
         super.d.f = GameCanvas.aa / 2 - 35;
         super.d.g = GameCanvas.ab - 26;
      }

      if (super.e != null) {
         super.e.f = GameCanvas.aa / 2 + 88;
         super.e.g = GameCanvas.ab - 26;
      }

      super.b();
   }

   public final void a(int var1, Object var2) {
   }

}
