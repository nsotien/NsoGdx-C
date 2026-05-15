package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class Dialog {
   Command1 c;
   Command1 d;
   Command1 e;

   public void a(mGraphics var1) {
      var1.a(-var1.a(), -var1.b());
      var1.d(0, 0, GameCanvas.aa, GameCanvas.ab);
      Paint.a(var1);
      Paint.a(var1, this.c, this.d, this.e);
   }

   public void a(int var1) {
      switch (var1) {
         case -39:
         case -2:
            GameCanvas.o[8] = true;
            GameCanvas.n[8] = true;
            return;
         case -38:
         case -1:
            GameCanvas.o[2] = true;
            GameCanvas.n[2] = true;
            return;
         case -22:
         case -7:
            GameCanvas.o[13] = true;
            GameCanvas.n[13] = true;
            return;
         case -21:
         case -6:
            GameCanvas.o[12] = true;
            GameCanvas.n[12] = true;
            return;
         case -5:
         case 10:
            GameCanvas.o[5] = true;
            GameCanvas.n[5] = true;
            return;
         default:
      }
   }

   public void b() {
      if (this.d != null && (GameCanvas.n[5] || mScreen.a(this.d))) {
         GameCanvas.n[5] = false;
         GameCanvas.q = false;
         mScreen.g = -1;
         GameCanvas.r = false;
         if (this.d != null) {
            this.d.a();
         }

         mScreen.g = -1;
      }

      if (this.c != null && (GameCanvas.n[12] || mScreen.a(this.c))) {
         GameCanvas.n[12] = false;
         GameCanvas.q = false;
         mScreen.g = -1;
         GameCanvas.r = false;
         if (this.c != null) {
            this.c.a();
         }

         mScreen.g = -1;
      }

      if (this.e != null && (GameCanvas.n[13] || mScreen.a(this.e))) {
         GameCanvas.n[13] = false;
         GameCanvas.q = false;
         GameCanvas.r = false;
         mScreen.g = -1;
         if (this.e != null) {
            this.e.a();
         }

         mScreen.g = -1;
      }

      GameCanvas.h();
      GameCanvas.i();
   }

}
