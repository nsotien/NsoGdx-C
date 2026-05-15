public final class ConnectionMonitor implements Runnable {
   private NetworkConnector gameAA;

   public ConnectionMonitor(NetworkConnector var1) {
      this.gameAA = var1;
   }

   public final void run() {
      try {
         Thread.sleep(20000L);
      } catch (InterruptedException var2) {
      }

      try {
         if (this.gameAA.gameAA.gameAG) {
            Session_ME.gameAA(this.gameAA.gameAA).interrupt();
         }
      } catch (Exception var1) {
      }
   }
}
