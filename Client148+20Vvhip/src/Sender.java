public final class Sender implements Runnable {
   private MyVector gameAA;
   private Session_ME gameAB;

   public Sender(Session_ME var1) {
      this.gameAB = var1;
      this.gameAA = new MyVector();
   }

   public final void gameAA() {
      this.gameAA.removeAllElements();
   }

   public final void gameAA(Message var1) {
      this.gameAA.addElement(var1);
   }

   public final void run() {
      try {
         for(; this.gameAB.gameAF; Thread.sleep(10L)) {
            if (Session_ME.gameAG(this.gameAB)) {
               while(this.gameAA.size() > 0) {
                  Message var1 = (Message)this.gameAA.elementAt(0);
                  this.gameAA.removeElementAt(0);
                  Session_ME.gameAA(this.gameAB, var1);
               }
            }
         }

      } catch (InterruptedException var2) {
      }
   }
}
