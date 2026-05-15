import javax.microedition.lcdui.Image;

public final class AnimateEffect extends EffectAnimation {
   private static FrameImage img;
   private static FrameImage imgSnow;
   private static Image imgTuyet = GameCanvas.loadImage("/u/tuyet.png");
   private static Image imgCoBay = GameCanvas.loadImage("/u/cobay.png");
   private byte type = 0;
   private int number = 0;
   private MyVector list = new MyVector();

   public AnimateEffect(byte var1, boolean var2, int var3) {
      this.type = var1;
      this.number = var3;
      switch (var1) {
         case 1:
            var3 = 10;
            if (img == null) {
               img = new FrameImage(imgCoBay, 16, 10);
            }
         case 2:
         default:
            break;
         case 3:
            if (imgSnow == null) {
               imgSnow = new FrameImage(imgTuyet, 5, 5);
            }
      }

      for (int var5 = 0; var5 < var3; var5++) {
         Position var4 = null;
         var4 = new Position((GameScr.cmx - 20 + Res.gameAD((GameCanvas.w + 40) / 5) * 5) * 10, (GameScr.cmy - 20 + Res.gameAD(GameCanvas.h / 5) * 5) * 10);
         if (var1 == 3) {
            var4.h = Res.gameAD(3);
         } else {
            var4.h = Res.gameAD(4);
         }

         var4.limitY = 16 + (Res.gameAD(3) << 2);
         var4.v = Res.gameAD(-1, 1);
         var4.color = Res.gameAD(var4.limitY);
         this.list.addElement(var4);
      }
   }

   public final void paint(mGraphics var1) {
      var1.gameAA(-var1.gameAA(), -var1.gameAB());
      var1.gameAD(0, -200, GameCanvas.w, 200 + GameCanvas.h);
      switch (this.type) {
         case 1:
            var1 = var1;
            AnimateEffect var5 = this;

            for (int var2 = 0; var2 < var5.number; var2++) {
               Position var3 = (Position)var5.list.elementAt(var2);
               img.gameAA(var3.color / (var3.limitY / 4), var3.x / 10 - GameScr.cmx, var3.y / 10 - GameScr.cmy, 0, 3, var1);
            }

            return;
         case 3:
            for (int var2 = 0; var2 < this.number; var2++) {
               Position var3;
               if ((var3 = (Position)this.list.elementAt(var2)).h > 0) {
                  GameScr.gI();
                  if (Scroll.me == null) {
                     Scroll.me = new Scroll();
                  }

                  int var4 = Scroll.me.cmx * (2 - var3.h) * 20 / 120 - GameScr.cmx;
                  imgSnow.gameAA(var3.h, var4 + var3.x / 10, var3.y / 10 - GameScr.cmy, 2, 0, var1);
               }
            }
         case 2:
      }
   }

   public final void update() {
      switch (this.type) {
         case 1:
            AnimateEffect var7 = this;

            for (int var1 = 0; var1 < var7.number; var1++) {
               Position var2;
               Position var10000 = var2 = (Position)var7.list.elementAt(var1);
               var10000.y += 10;
               var2.x = var2.x + var2.v * 10;
               var2.color++;
               if (var2.color >= var2.limitY) {
                  var2.color = 0;
               }

               if (var2.y / 10 > GameScr.cmy + GameCanvas.h - (3 - var2.h) * 40
                  || var2.x / 10 < GameScr.cmx - GameCanvas.hw
                  || var2.x / 10 > GameScr.cmx + GameCanvas.w + GameCanvas.hw) {
                  if (var2.y / 10 > 24) {
                     int var10001 = var2.x / 10 + GameScr.cmx;
                     int var5 = var2.y / 10 + GameScr.cmy;
                     Position var6;
                     (var6 = new Position(var10001, var5)).limitY = 200;
                     Res.gameAD(4);
                     new EffectPosition(var7, var6, var10001, var5);
                  }

                  var7.gameAA(var2);
               }
            }

            return;
         case 3:
            var7 = this;

            for (int var1 = 0; var1 < var7.number; var1++) {
               Position var2x;
               Position var10000x = var2x = (Position)var7.list.elementAt(var1);
               var10000x.y = var10000x.y + (var2x.h + 1) * 5;
               var2x.x = var2x.x + (var2x.h + 1 << 1);
               if (var2x.y / 10 > GameScr.cmy + GameCanvas.h - (3 - var2x.h) * 30) {
                  var7.gameAA(var2x);
               }

               int var4 = GameScr.cmx * (2 - var2x.h) * 20 / 120;
               if (var2x.x / 10 + var4 < GameScr.cmx - 10) {
                  var2x.x = var2x.x + (GameCanvas.w + 20) * 10;
               }

               if (var2x.x / 10 + var4 > GameScr.cmx + GameCanvas.w + 10) {
                  var2x.x = var2x.x - (GameCanvas.w + 20) * 10;
               }
            }
         case 2:
      }
   }

   private void gameAA(Position var1) {
      var1.x = (GameScr.cmx - 20 + Res.gameAD((GameCanvas.w + 40) / 5) * 5) * 10;
      var1.y = (GameScr.cmy - GameCanvas.hh + Res.gameAD(GameCanvas.h / 5) * 5) * 10;
      if (this.type == 3) {
         var1.h = Res.gameAD(3);
      } else {
         var1.h = Res.gameAD(4);
      }
   }

   static {
      new Scroll();
   }
}
