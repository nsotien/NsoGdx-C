public final class NextMap implements Runnable {
   private final int gameAA;

   public NextMap(int var1) {
      this.gameAA = var1;
   }

   public final void run() {
      try {
         int var1 = this.gameAA;
         if (this.gameAA < 0) {
            var1 = 0;
         }

         if (var1 >= TileMap.vGo.size()) {
            var1 = TileMap.vGo.size() - 1;
         }

         TileMap.gameAJ(var1);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      System.gc();
      if (Session_ME.gameAA().gameAF) {
         GameScr.gI().gameAB();
      }

      GameCanvas.endDlg();
      GameCanvas.isLoading = false;
   }
}
