public final class MoAll implements Runnable {
   private final Item gameAA;

   public MoAll(Item var1) {
      this.gameAA = var1;
   }

   public final void run() {
      try {
         for(int var1 = 0; var1 < this.gameAA.quantity && Char.gameBG() > 0; ++var1) {
            if (!(GameCanvas.currentScreen instanceof GameScr)) {
               return;
            }

            Service.gI().useItem(this.gameAA.indexUI);
            Thread.sleep(1L);
         }

      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }
   }
}
