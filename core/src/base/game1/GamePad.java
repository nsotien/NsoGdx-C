package base.game1;

public class GamePad {
   public int xC;
   public int yC;
   public int xM;
   public int yM;
   private int xMLast;
   private int yMLast;
   private static final int R = 28;
   private boolean isGamePad;

   public GamePad() {
      xM = xC = 50;
      yM = yC = GameCanvas.ab - 50;
      xMLast = xM;
      yMLast = yM;
   }

   public void update() {
      if (!GameCanvas.isAnalog) {
         return;
      }

      if (GameCanvas.p) {
         int xTemp = GameCanvas.s;
         int yTemp = GameCanvas.t;
         if (xTemp > (GameCanvas.aa >> 1) - 100 || yTemp < GameCanvas.ab >> 1) {
            return;
         }

         if (!isGamePad) {
            xC = xM = xTemp;
            yC = yM = yTemp;
            xMLast = xM;
            yMLast = yM;
         }
         isGamePad = true;

         int deltaX = GameCanvas.s - xC;
         int deltaY = GameCanvas.t - yC;
         long sq = (long) deltaX * deltaX + (long) deltaY * deltaY;
         int d = (int) Math.sqrt(sq);

         if (Math.abs(deltaX) <= 4 && Math.abs(deltaY) <= 4) {
            return;
         }

         int angle = (int) Math.toDegrees(Math.atan2(deltaY, deltaX));
         if (angle < 0) {
            angle += 360;
         }

         if (!GameCanvas.b(xC - R, yC - R, R << 1, R << 1)) {
            if (d != 0) {
               xM = deltaX * R / d + xC;
               yM = deltaY * R / d + yC;
               xMLast = xM;
               yMLast = yM;
            } else {
               xM = xMLast;
               yM = yMLast;
            }
         } else {
            xM = GameCanvas.s;
            yM = GameCanvas.t;
         }

         resetHold();

         if ((angle > 340 && angle <= 360) || (angle >= 0 && angle <= 90)) {
            GameCanvas.o[6] = true;
         } else if (angle > 290 && angle <= 340) {
            GameCanvas.o[3] = true;
         } else if (angle > 250 && angle <= 290) {
            GameCanvas.o[2] = true;
         } else if (angle > 200 && angle <= 250) {
            GameCanvas.o[1] = true;
         } else if (angle > 90 && angle <= 200) {
            GameCanvas.o[4] = true;
         }
      } else {
         xM = xC = 50;
         yM = yC = GameCanvas.ab - 50;
         xMLast = xM;
         yMLast = yM;
         isGamePad = false;
         resetHold();
      }
   }

   private static void resetHold() {
      GameCanvas.o[1] = false;
      GameCanvas.o[2] = false;
      GameCanvas.o[3] = false;
      GameCanvas.o[4] = false;
      GameCanvas.o[6] = false;
   }

   public void paint(mGraphics g) {
      if (!GameCanvas.isAnalog) {
         return;
      }
      if (GameScr.imgAnalog1 != null) {
         g.a(GameScr.imgAnalog1, xC, yC, 3);
      }
      if (GameScr.imgAnalog2 != null) {
         g.a(GameScr.imgAnalog2, xM, yM, 3);
      }
   }
}
