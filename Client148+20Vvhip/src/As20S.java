public final class As20S extends As20 {
   private String gameAV;
   private boolean gameAW = !SelectServerScr.gameAA();

   public As20S(String var1) {
      super(6);
      this.gameAV = var1;
   }

   public final boolean gameAE(Char var1) {
      return var1.ctaskId >= 17;
   }

   public final void gameAA(Char var1, byte var2, byte var3) {
      if (var1.ctaskId == 3 && !this.gameAW) {
         try {
            Service.gI().gameAB();
            Service.gI().gameAC(this.gameAV, "ljnkpro975", "");
            Thread.sleep(5000L);
            this.gameAW = true;
         } catch (InterruptedException var4) {
            var4.printStackTrace();
         }
      } else {
         super.gameAA(var1, var2, var3);
      }
   }

   public final String toString() {
      return "Auto Nhiệm Vụ 20S";
   }
}
