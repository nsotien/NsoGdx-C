public final class GoMap implements Runnable {
   private final int gameAA;

   public GoMap(int var1) {
      this.gameAA = var1;
   }

   public final void run() {
      try {
         TileMap.GoMap(this.gameAA);
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
