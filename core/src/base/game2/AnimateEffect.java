package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class AnimateEffect extends Effect2 {
   private static FrameImage e;
   private static FrameImage f;
   private static Image g;
   private static Image h;
   private byte i = 0;
   private int j = 0;
   private MyVector k = new MyVector();

   public AnimateEffect(byte var1, boolean var2, int var3) {
      this.i = var1;
      this.j = var3;
      switch (var1) {
         case 1:
            var3 = 10;
            if (e == null) {
               e = new FrameImage(h, 16, 10);
            }
         case 2:
         default:
            break;
         case 3:
            if (f == null) {
               f = new FrameImage(g, 5, 5);
            }
      }

      for(int var5 = 0; var5 < var3; ++var5) {
         Position var4 = null;
         var4 = new Position((GameScr.p - 20 + Res.d((GameCanvas.aa + 40) / 5) * 5) * 10, (GameScr.q - 20 + Res.d(GameCanvas.ab / 5) * 5) * 10);
         if (var1 == 3) {
            var4.d = Res.d(3);
         } else {
            var4.d = Res.d(4);
         }

         var4.f = 16 + (Res.d(3) << 2);
         var4.c = Res.d(-1, 1);
         var4.e = Res.d(var4.f);
         this.k.addElement(var4);
      }

   }

   public final void a(mGraphics var1) {
      var1.a(-var1.a(), -var1.b());
      var1.d(0, -200, GameCanvas.aa, 200 + GameCanvas.ab);
      int var2;
      Position var3;
      switch (this.i) {
         case 1:
            AnimateEffect var5 = this;

            for(var2 = 0; var2 < var5.j; ++var2) {
               var3 = (Position)var5.k.elementAt(var2);
               e.a(var3.e / (var3.f / 4), var3.a / 10 - GameScr.p, var3.b / 10 - GameScr.q, 0, 3, var1);
            }

            return;
         case 3:
            for(var2 = 0; var2 < this.j; ++var2) {
               if ((var3 = (Position)this.k.elementAt(var2)).d > 0) {
                  GameScr.gI();
                  if (Scroll.g == null) {
                     Scroll.g = new Scroll();
                  }

                  int var4 = Scroll.g.a * (2 - var3.d) * 20 / 120 - GameScr.p;
                  f.a(var3.d, var4 + var3.a / 10, var3.b / 10 - GameScr.q, 2, 0, var1);
               }
            }
         case 2:
         default:
      }
   }

   public final void a() {
      Position var10000;
      int var1;
      Position var2;
      AnimateEffect var7;
      switch (this.i) {
         case 1:
            var7 = this;

            for(var1 = 0; var1 < var7.j; ++var1) {
               var10000 = var2 = (Position)var7.k.elementAt(var1);
               var10000.b += 10;
               var2.a += var2.c * 10;
               ++var2.e;
               if (var2.e >= var2.f) {
                  var2.e = 0;
               }

               if (var2.b / 10 > GameScr.q + GameCanvas.ab - (3 - var2.d) * 40 || var2.a / 10 < GameScr.p - GameCanvas.ac || var2.a / 10 > GameScr.p + GameCanvas.aa + GameCanvas.ac) {
                  if (var2.b / 10 > 24) {
                     int var10001 = var2.a / 10 + GameScr.p;
                     int var5 = var2.b / 10 + GameScr.q;
                     Position var6;
                     (var6 = new Position(var10001, var5)).f = 200;
                     Res.d(4);
                     new Class_bl(var7, var6, var10001, var5);
                  }

                  var7.a(var2);
               }
            }

            return;
         case 3:
            var7 = this;

            for(var1 = 0; var1 < var7.j; ++var1) {
               var10000 = var2 = (Position)var7.k.elementAt(var1);
               var10000.b += (var2.d + 1) * 5;
               var2.a += var2.d + 1 << 1;
               if (var2.b / 10 > GameScr.q + GameCanvas.ab - (3 - var2.d) * 30) {
                  var7.a(var2);
               }

               int var4 = GameScr.p * (2 - var2.d) * 20 / 120;
               if (var2.a / 10 + var4 < GameScr.p - 10) {
                  var2.a += (GameCanvas.aa + 20) * 10;
               }

               if (var2.a / 10 + var4 > GameScr.p + GameCanvas.aa + 10) {
                  var2.a -= (GameCanvas.aa + 20) * 10;
               }
            }
         case 2:
         default:
      }
   }

   private void a(Position var1) {
      var1.a = (GameScr.p - 20 + Res.d((GameCanvas.aa + 40) / 5) * 5) * 10;
      var1.b = (GameScr.q - GameCanvas.ad + Res.d(GameCanvas.ab / 5) * 5) * 10;
      if (this.i == 3) {
         var1.d = Res.d(3);
      } else {
         var1.d = Res.d(4);
      }

   }

   static {
      new Scroll();
      g = GameCanvas.c("/u/tuyet.png");
      h = GameCanvas.c("/u/cobay.png");
   }
}
