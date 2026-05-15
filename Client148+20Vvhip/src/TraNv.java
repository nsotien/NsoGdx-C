public final class TraNv extends As10 {
   private int gameAV;

   public TraNv() {
      this.gameAV = Char.getMyChar().ctaskId;
   }

   public final boolean gameAE(Char var1) {
      return var1.ctaskId > this.gameAV;
   }

   public final void gameAA(Char var1, byte var2, byte var3) {
   }

   public final String toString() {
      return "Trả NV";
   }
}
