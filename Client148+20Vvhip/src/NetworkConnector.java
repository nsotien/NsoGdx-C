import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

public final class NetworkConnector implements Runnable {
   private final String gameAB;
   public final Session_ME gameAA;

   public NetworkConnector(Session_ME var1, String var2) {
      this.gameAA = var1;
      this.gameAB = var2;
   }

   public final void run() {
      try {
         Session_ME.gameAA(this.gameAA, new Thread(new ConnectionMonitor(this)));
         Session_ME.gameAB(this.gameAA).start();
         this.gameAA.gameAJ = System.currentTimeMillis();
         this.gameAA.gameAG = true;
         this.gameAA.gameAF = true;
         this.gameAA.gameAE = (SocketConnection)Connector.open(this.gameAB);
         this.gameAA.gameAB = this.gameAA.gameAE.openDataOutputStream();
         this.gameAA.gameAC = this.gameAA.gameAE.openDataInputStream();
         Session_ME.gameAB(this.gameAA, new Thread(Session_ME.gameAC(this.gameAA)));
         Session_ME.gameAC(this.gameAA, new Thread(Session_ME.gameAD(this.gameAA)));
         Session_ME.gameAE(this.gameAA).start();
         Session_ME.gameAF(this.gameAA).start();
         Session_ME.gameAA(this.gameAA, System.currentTimeMillis());
         Session_ME.gameAA(this.gameAA, new Message((byte)-27));
         this.gameAA.gameAG = false;
         this.gameAA.gameAD.onConnectOK();
      } catch (Exception var1) {
         this.gameAA.gameAB();
         if (this.gameAA.gameAD != null) {
            this.gameAA.gameAD.gameAA();
         }

      }
   }
}
