package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class Command1 {
   public String a;
   public String[] b;
   public IActionListener c;
   public int d;
   private Image l;
   private Image m;
   public Image e;
   public int f = 0;
   public int g = 0;
   public int h;
   public int i;
   public boolean j;
   public Object k;

   public Command1(String var1, IActionListener var2, int var3, Object var4, int var5, int var6) {
      this.h = mScreen.e;
      this.i = mScreen.f;
      this.j = false;
      this.a = var1;
      this.d = var3;
      this.c = var2;
      this.k = var4;
      this.f = var5;
      this.g = var6;
      this.h = mScreen.e;
      this.i = mScreen.f;
      this.l = null;
      this.m = null;
   }

   public Command1(String var1, IActionListener var2, int var3, Object var4) {
      this.h = mScreen.e;
      this.i = mScreen.f;
      this.j = false;
      this.a = var1;
      this.d = var3;
      this.c = var2;
      this.k = var4;
   }

   public Command1(String var1, int var2, Object var3) {
      this.h = mScreen.e;
      this.i = mScreen.f;
      this.j = false;
      this.a = var1;
      this.d = var2;
      this.k = var3;
   }

   public Command1(String var1, int var2) {
      this.h = mScreen.e;
      this.i = mScreen.f;
      this.j = false;
      this.a = var1;
      this.d = var2;
   }

   public Command1(String var1, int var2, int var3, int var4) {
      this.h = mScreen.e;
      this.i = mScreen.f;
      this.j = false;
      this.a = var1;
      this.d = 0;
      this.f = var3;
      this.g = var4;
   }

   public final void a() {
      if (this.d > 0) {
         if (this.c != null) {
            this.c.a(this.d, this.k);
            return;
         }

         GameScr.gI().b(this.d, this.k);
      }

   }

   public final void a(mGraphics var1) {
      if (this.e != null) {
         var1.a(this.e, this.f + mGraphics.a(this.e) / 2, this.g + mGraphics.b(this.e) / 2, 3);
      } else {
         if (this.a != "") {
            if (!this.j) {
               var1.a(GameScr.ea, this.f, this.g, 0);
            } else {
               var1.a(GameScr.eb, this.f, this.g, 0);
            }
         }

         mFont.d.a(var1, this.a, this.f + 36, this.g + 6, 2);
      }

   }

   public final boolean b() {
      this.j = false;
      if (GameCanvas.b(this.f - 3, this.g - 3, this.h + 6, this.i + 6)) {
         if (GameCanvas.p) {
            this.j = true;
         }

         if (GameCanvas.r && GameCanvas.q) {
            return true;
         }
      }

      return false;
   }

   public final void c() {
      if (this.f > 0 && this.g > 0 && this.b()) {
         this.a();
         GameCanvas.p = false;
         this.j = false;
      }

   }

}
