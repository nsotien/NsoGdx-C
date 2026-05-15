public final class ReLogin implements Runnable {
   private Session_ME fieldAA;

   ReLogin(Session_ME var1) {
      this.fieldAA = var1;
   }

   public final void run() {
      long varDelay = 5000L;

      do {
         try {
            GameCanvas.gameAL();
            if (!this.fieldAA.connected && !this.fieldAA.connecting) {
               this.fieldAA.gameAC();
               Thread.sleep(varDelay);
               this.fieldAA.gameAA11(GameMidlet.IP, GameMidlet.PORT);
               GameMidlet.serverLogin = Session_ME.fieldAO;
               Service.gI().login(SelectServerScr.uname, SelectServerScr.pass, "2.1.7");
            }

            Session_ME.fieldAA(5000L);
            GameCanvas.gameAJ();
            String var1 = SelectCharScr.fieldAK;
            if (var1 == null || var1.length() == 0) {
               SelectCharScr var2 = SelectCharScr.gameAF();
               if (var2 != null && var2.name != null) {
                  for (int var3 = 0; var3 < var2.name.length; var3++) {
                     if (var2.name[var3] != null && var2.name[var3].length() > 0) {
                        var1 = var2.name[var3];
                        break;
                     }
                  }
               }
            }

            if (var1 != null && var1.length() > 0) {
               Service.gI().selectCharToPlay(var1);
            }

            if (GameCanvas.currentScreen != GameScr.instance) {
               Session_ME.fieldAA(10000L);
            }
         } catch (Exception var6) {
         }
      } while (GameCanvas.currentScreen != GameScr.instance);
   }
}
