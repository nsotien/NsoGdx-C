package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class ServerEffect extends Effect2 {
   private EffectCharPaint e;
   private int f;
   private int g;
   private int h;
   private int i = 1;
   private Char j;
   private short k = 0;
   private long l = 0L;

   public static void a(int var0, int var1, int var2, int var3) {
      ServerEffect var4;
      (var4 = new ServerEffect()).e = GameScr.ad[var0];
      var4.g = var1;
      var4.h = var2;
      var4.k = (short)var3;
      Effect2.a.addElement(var4);
   }

   public static void a(int var0, int var1, int var2, int var3, byte var4) {
      ServerEffect var5;
      (var5 = new ServerEffect()).e = GameScr.ad[var0];
      var5.g = var1;
      var5.h = var2;
      var5.k = (short)var3;
      var5.i = var4;
      Effect2.a.addElement(var5);
   }

   public static void a(int var0, Char var1, int var2) {
      ServerEffect var3;
      (var3 = new ServerEffect()).e = GameScr.ad[var0];
      var3.j = var1;
      var3.k = (short)var2;
      Effect2.a.addElement(var3);
   }

   public static void b(int var0, Char var1, int var2) {
      ServerEffect var3;
      (var3 = new ServerEffect()).e = GameScr.ad[var0];
      var3.j = var1;
      var3.l = System.currentTimeMillis() + (long)(var2 * 1000);
      Effect2.a.addElement(var3);
   }

   public final void a(mGraphics var1) {
      if (this.j != null) {
         this.g = this.j.cx1;
         this.h = this.j.cy1;
      }

      int var2 = this.g + this.e.b[this.f].a * this.i;
      int var3 = this.h + this.e.b[this.f].b;
      if (GameCanvas.e(var2, var3)) {
         SmallImage.a(var1, this.e.b[this.f].c, var2, var3, this.i == 1 ? 0 : 2, 3);
      }

   }

   public final void a() {
      if (this.l != 0L) {
         ++this.f;
         if (this.f >= this.e.b.length) {
            this.f = 0;
         }

         if (System.currentTimeMillis() - this.l > 0L) {
            if (this.e.a == 120) {
               GameCanvas.e = false;
            }

            Effect2.a.removeElement(this);
         }
      } else {
         ++this.f;
         if (this.f >= this.e.b.length) {
            --this.k;
            if (this.k <= 0) {
               if (this.e.a == 120) {
                  GameCanvas.e = false;
               }

               Effect2.a.removeElement(this);
            } else {
               this.f = 0;
            }
         }
      }

      if (GameCanvas.w % 11 == 0 && this.j != null && this.j != Char.getMyChar() && !GameScr.vCharInMap.contains(this.j)) {
         Effect2.a.removeElement(this);
      }

   }

}
