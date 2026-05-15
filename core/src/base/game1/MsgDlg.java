package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class MsgDlg extends Dialog {
   private String[] f;
   public boolean a;
   public int b;
   private int g;
   private int h = 30;

   public MsgDlg() {
      if (GameCanvas.aa <= 176) {
         this.h = 10;
      }

   }

   public final void a() {
      this.a(TextGame.y, (Command1)null, (Command1)null, (Command1)null);
      GameCanvas.aj = this;
   }

   public final void a(String var1, Command1 var2, Command1 var3, Command1 var4) {
      this.f = mFont.o.b(var1, GameCanvas.aa - ((this.h << 1) + 40));
      super.c = var2;
      super.d = var3;
      super.e = var4;
      if (var3 != null) {
         super.d.f = GameCanvas.aa / 2 - 35;
         super.d.g = GameCanvas.ab - 26;
         if (var2 != null) {
            super.c.f = GameCanvas.aa / 2 - 115;
            super.c.g = GameCanvas.ab - 26;
         }

         if (var4 != null) {
            super.e.f = GameCanvas.aa / 2 + 45;
            super.e.g = GameCanvas.ab - 26;
         }
      } else {
         if (var2 != null) {
            super.c.f = GameCanvas.aa / 2 - 80;
            super.c.g = GameCanvas.ab - 26;
         }

         if (var4 != null) {
            super.e.f = GameCanvas.aa / 2 + 10;
            super.e.g = GameCanvas.ab - 26;
         }
      }

      this.a = false;
      this.g = 80;
      if (this.f.length >= 5) {
         this.g = this.f.length * mFont.o.c() + 20;
      }

   }

   public final void a(mGraphics var1) {
      int var2 = GameCanvas.ab - this.g - 38;
      Paint.a(this.h, var2, GameCanvas.aa - (this.h << 1), this.g, var1);
      var2 = var2 + (this.g - this.f.length * mFont.o.c()) / 2 - 2;
      if (this.a) {
         var2 += 8;
         GameCanvas.a(GameCanvas.ac, var2 - 12, var1, false);
      }

      int var3 = 0;

      for(var2 = var2; var3 < this.f.length; var2 += mFont.o.c()) {
         mFont.o.a(var1, this.f[var3], GameCanvas.ac, var2, 2);
         ++var3;
      }

      super.a(var1);
   }

   public final void b() {
      if (this.b > 0) {
         --this.b;
         if (this.b == 1) {
            GameCanvas.j();
            this.b = 0;
         }
      }

      super.b();
   }

}
