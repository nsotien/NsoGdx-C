public final class AutoNpc implements Runnable {
   private final int gameAA;
   private final int gameAB;
   private final int gameAC;

   public AutoNpc(int var1, int var2, int var3) {
      this.gameAA = var1;
      this.gameAB = var2;
      this.gameAC = var3;
   }

   public final void run() {
      GameScr.gameAH(33);
      Service.gI().gameAH(33);

      for(int var1 = 0; var1 < this.gameAA; ++var1) {
         Service.gI().gameAC(33, this.gameAB, this.gameAC);

         try {
            Thread.sleep(20L);
         } catch (InterruptedException var2) {
         }
      }

   }
}
