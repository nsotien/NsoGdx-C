import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public final class MotherCanvas extends Canvas implements Runnable {
   public static MotherCanvas instance;
   public GameGraphics gameAB;
   private int gameAD = 1;
   public static boolean gameAC;

   public MotherCanvas() {
      this.setFullScreenMode(true);
      mGraphics.zoomLevel = this.gameAD = 1;
   }

   public static MotherCanvas gI() {
      if (instance == null) {
         instance = new MotherCanvas();
      }

      return instance;
   }

   protected final void paint(Graphics var1) {
      this.gameAB.gameAA(var1);
   }

   protected final void keyPressed(int var1) {
      this.gameAB.gameAA(var1);
   }

   protected final void keyReleased(int var1) {
      this.gameAB.gameAB(var1);
   }

   protected final void pointerDragged(int var1, int var2) {
      var1 /= this.gameAD;
      var2 /= this.gameAD;
      this.gameAB.setSize(var1, var2);
   }

   protected final void pointerPressed(int var1, int var2) {
      var1 /= this.gameAD;
      var2 /= this.gameAD;
      this.gameAB.gameAA(var1, var2);
   }

   protected final void pointerReleased(int var1, int var2) {
      var1 /= this.gameAD;
      var2 /= this.gameAD;
      this.gameAB.gameAC(var1, var2);
   }

   public final int gameAB() {
      return this.gameAD == 1 ? this.getHeight() : 0;
   }

   public final int gameAC() {
      return this.gameAD == 1 ? this.getWidth() : 0;
   }

   public final void run() {
      try {
         Thread.sleep(10L);
      } catch (InterruptedException var8) {
      }

      gameAC = true;

      while(gameAC) {
         try {
            long var1 = System.currentTimeMillis();
            this.gameAB.gameAA();
            long var3 = System.currentTimeMillis() - var1;

            try {
               Thread.sleep(var3 < (long)Char.speedGame ? (long)Char.speedGame - var3 : 1L);
            } catch (InterruptedException var6) {
            }
         } catch (Exception var7) {
            try {
               Thread.sleep(1000L);
            } catch (InterruptedException var5) {
               var5.printStackTrace();
            }

            var7.printStackTrace();
         }
      }

   }
}
