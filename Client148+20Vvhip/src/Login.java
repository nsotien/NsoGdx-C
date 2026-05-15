public final class Login implements Runnable {
   private Session_ME gameAA;

   public Login(Session_ME var1) {
      this.gameAA = var1;
   }

   public final void run() {
      do {
         try {
            GameCanvas.gameAN();
            this.gameAA.gameAB();
            Thread.sleep(5000L);
            this.gameAA.gameAA(Session_ME.gameAM, Session_ME.gameAN);
            GameMidlet.serverLogin = Session_ME.gameAO;
            Service.gI().gameAA(SelectServerScr.uname, SelectServerScr.pass, "1.8.8");
            Session_ME.gameAA(10000L);
            Service.gI().gameAB(SelectCharScr.gameAK);
            Session_ME.gameAA(5000L);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }
      } while(Session_ME.gameAP && GameCanvas.currentScreen != GameScr.instance);

   }
}
