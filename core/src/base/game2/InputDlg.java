package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class InputDlg extends Dialog {
   private String[] b;
   public TField a;
   private int f = 40;

   public InputDlg() {
      if (GameCanvas.aa <= 176) {
         this.f = 10;
      }

      this.a = new TField();
      this.a.a = this.f + 10;
      this.a.b = GameCanvas.ab - mScreen.d - 43;
      this.a.c = GameCanvas.aa - 2 * (this.f + 10);
      this.a.d = mScreen.d + 2;
      this.a.e = true;
      super.e = this.a.l;
   }

   public final void a(String var1, Command1 var2, int var3) {
      try {
         this.a.a("");
         this.a.c(var3);
         this.b = mFont.o.b(var1, GameCanvas.aa - (this.f << 1));
         super.c = new Command1(TextGame.ah, GameCanvas.gI(), 8882, (Object)null);
         super.d = var2;
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

         GameCanvas.aj = this;
      } catch (Exception var5) {
         ;
      }

   }

   public final void a1(String var1, Command1 var2, int var3) {
      try {
         this.a.a("");
         this.a.c(var3);
         this.b = mFont.o.b(var1, GameCanvas.aa - (this.f << 1));
         this.d = var2;
         this.e = null;
         if (this.d != null) {
            this.d.f = GameCanvas.aa / 2 - 35;
            this.d.g = GameCanvas.ab - 26;
         }

         GameCanvas.aj = this;
      } catch (Exception var5) {
         ;
      }

   }

   public final void a(mGraphics var1) {
      GameCanvas.an.a(var1, this.f, GameCanvas.ab - 77 - mScreen.f, GameCanvas.aa - (this.f << 1), 69, this.b, (Image)null);
      this.a.a(var1);
      super.a(var1);
   }

   public final void a(int var1) {
      this.a.a(var1);
      super.a(var1);
   }

   public final void b() {
      this.a.c();
      super.b();
   }

}
