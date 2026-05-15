import java.util.Random;

public final class LatHinh implements Runnable {
   public static long time = 10L;
   public final int solanlat;
   public static int lap;
   public static int check;
   public static int id;
   public static boolean bat;
   public static boolean chay;
   public static Random random = new Random();

   LatHinh(int a) {
      this.solanlat = a;
   }

   public final void run() {
      int n6 = 0;
      if (TileMap.mapID != 72) {
         GameScr.gameAC("Đứng ở Okaza để auto");
         GameScr.gameAC(String.valueOf(check));
      } else {
         n6 = 0;
         GameScr.gameAB(30, 0, 0);

         do {
            ++n6;
            Service.gI().gameBH();
            GameCanvas.gameAM();

            try {
               Thread.sleep(time);
            } catch (InterruptedException var3) {
               var3.printStackTrace();
            }
         } while(n6 <= this.solanlat);

      }
   }
}
