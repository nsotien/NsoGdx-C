import javax.microedition.lcdui.Image;

public final class AnimateEffect extends Effect2 {
   private static FrameImage gameAA;
   private static FrameImage gameAB;
   private static Image gameAG = GameCanvas.gameAC("/u/tuyet.png");
   private static Image gameAH = GameCanvas.gameAC("/u/cobay.png");
   private byte gameAI = 0;
   private int gameAJ = 0;
   private MyVector gameAK = new MyVector();

   public AnimateEffect(byte var1, int var2) {
      this.gameAI = var1;
      this.gameAJ = var2;
      switch(var1) {
      case 1:
         var2 = 10;
         if (gameAA == null) {
            gameAA = new FrameImage(gameAH, 16, 10);
         }
      case 2:
      default:
         break;
      case 3:
         if (gameAB == null) {
            gameAB = new FrameImage(gameAG, 5, 5);
         }
      }

      for(int var3 = 0; var3 < var2; ++var3) {
         Position var4 = new Position((GameScr.cmx - 20 + Res.gameAD((GameCanvas.w + 40) / 5) * 5) * 10, (GameScr.cmy - 20 + Res.gameAD(GameCanvas.h / 5) * 5) * 10);
         if (var1 == 3) {
            var4.gameAD = Res.gameAD(3);
         } else {
            var4.gameAD = Res.gameAD(4);
         }

         var4.gameAF = 16 + (Res.gameAD(3) << 2);
         var4.gameAC = Res.gameAB(-1, 1);
         var4.gameAE = Res.gameAD(var4.gameAF);
         this.gameAK.addElement(var4);
      }

   }

   public final void gameAA(mGraphics var1) {
      var1.gameAA(-var1.gameAA(), -var1.gameAB());
      var1.gameAE(0, -200, GameCanvas.w, 200 + GameCanvas.h);
      int var2;
      Position var3;
      switch(this.gameAI) {
      case 1:
         for(var2 = 0; var2 < this.gameAJ; ++var2) {
            var3 = (Position)this.gameAK.elementAt(var2);
            gameAA.gameAA(var3.gameAE / (var3.gameAF / 4), var3.x / 10 - GameScr.cmx, var3.y / 10 - GameScr.cmy, 0, 3, var1);
         }

         return;
      case 2:
      default:
         return;
      case 3:
         for(var2 = 0; var2 < this.gameAJ; ++var2) {
            if ((var3 = (Position)this.gameAK.elementAt(var2)).gameAD > 0) {
               int var4 = Scroll.gameAD().cmx * (2 - var3.gameAD) * 20 / 120 - GameScr.cmx;
               gameAB.gameAA(var3.gameAD, var4 + var3.x / 10, var3.y / 10 - GameScr.cmy, 2, 0, var1);
            }
         }

      }
   }

   public final void gameAA() {
      Position var10000;
      AnimateEffect var2;
      int var3;
      Position var4;
      switch(this.gameAI) {
      case 1:
         var2 = this;
         var3 = 0;

         for(; var3 < var2.gameAJ; ++var3) {
            var10000 = var4 = (Position)var2.gameAK.elementAt(var3);
            var10000.y += 10;
            var4.x += var4.gameAC * 10;
            if (++var4.gameAE >= var4.gameAF) {
               var4.gameAE = 0;
            }

            if (var4.y / 10 > GameScr.cmy + GameCanvas.h - (3 - var4.gameAD) * 40 || var4.x / 10 < GameScr.cmx - GameCanvas.hw || var4.x / 10 > GameScr.cmx + GameCanvas.w + GameCanvas.hw) {
               var2.gameAA(var4);
            }
         }

         return;
      case 2:
      default:
         return;
      case 3:
         var2 = this;

         for(var3 = 0; var3 < var2.gameAJ; ++var3) {
            var10000 = var4 = (Position)var2.gameAK.elementAt(var3);
            var10000.y += (var4.gameAD + 1) * 5;
            var4.x += var4.gameAD + 1 << 1;
            if (var4.y / 10 > GameScr.cmy + GameCanvas.h - (3 - var4.gameAD) * 30) {
               var2.gameAA(var4);
            }

            int var1 = GameScr.cmx * (2 - var4.gameAD) * 20 / 120;
            if (var4.x / 10 + var1 < GameScr.cmx - 10) {
               var4.x += (GameCanvas.w + 20) * 10;
            }

            if (var4.x / 10 + var1 > GameScr.cmx + GameCanvas.w + 10) {
               var4.x -= (GameCanvas.w + 20) * 10;
            }
         }

      }
   }

   private void gameAA(Position var1) {
      var1.x = (GameScr.cmx - 20 + Res.gameAD((GameCanvas.w + 40) / 5) * 5) * 10;
      var1.y = (GameScr.cmy - GameCanvas.hh + Res.gameAD(GameCanvas.h / 5) * 5) * 10;
      if (this.gameAI == 3) {
         var1.gameAD = Res.gameAD(3);
      } else {
         var1.gameAD = Res.gameAD(4);
      }
   }
}
