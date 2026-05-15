public final class SplashScr extends mScreen {
   public static int splashScrStat;

   public final void gameAC() {
      if (splashScrStat++ > 5) {
         if (RMS.gameAD("indLanguage") >= 0) {
            GameCanvas.gameAD();
            GameCanvas.selectsvScr.gameAB();
            return;
         }

         GameCanvas.gameAD();
         GameCanvas.languageScr.gameAB();
      }

   }
}
