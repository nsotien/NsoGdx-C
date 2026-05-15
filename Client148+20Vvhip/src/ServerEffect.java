public final class ServerEffect extends Effect2 {
   private EffectCharPaint gameAA;
   private int gameAB;
   private int gameAG;
   private int gameAH;
   private int gameAI = 1;
   private Char gameAJ;
   private short gameAK = 0;
   private long gameAL = 0L;

   public static void gameAA(int var0, int var1, int var2, int var3) {
      ServerEffect var4;
      (var4 = new ServerEffect()).gameAA = GameScr.efs[var0];
      var4.gameAG = var1;
      var4.gameAH = var2;
      var4.gameAK = (short)var3;
      Effect2.vEffect2.addElement(var4);
   }

   public static void gameAA(int var0, int var1, int var2, int var3, byte var4) {
      ServerEffect var5;
      (var5 = new ServerEffect()).gameAA = GameScr.efs[var0];
      var5.gameAG = var1;
      var5.gameAH = var2;
      var5.gameAK = (short)var3;
      var5.gameAI = var4;
      Effect2.vEffect2.addElement(var5);
   }

   public static void gameAA(int var0, Char var1, int var2) {
      ServerEffect var3;
      (var3 = new ServerEffect()).gameAA = GameScr.efs[var0];
      var3.gameAJ = var1;
      var3.gameAK = (short)var2;
      Effect2.vEffect2.addElement(var3);
   }

   public static void gameAA(int var0, Char var1, long var2) {
      ServerEffect var4;
      (var4 = new ServerEffect()).gameAA = GameScr.efs[var0];
      var4.gameAJ = var1;
      var4.gameAL = System.currentTimeMillis() + var2 * 1000L;
      Effect2.vEffect2.addElement(var4);
   }

   public final void gameAA(mGraphics var1) {
      if (this.gameAJ != null) {
         this.gameAG = this.gameAJ.cx;
         this.gameAH = this.gameAJ.cy;
      }

      int var2 = this.gameAG + this.gameAA.arrEfInfo[this.gameAB].dx * this.gameAI;
      int var3 = this.gameAH + this.gameAA.arrEfInfo[this.gameAB].dy;
      if (GameCanvas.gameAE(var2, var3)) {
         SmallImage.gameAB(var1, this.gameAA.arrEfInfo[this.gameAB].idImg, var2, var3, this.gameAI == 1 ? 0 : 2, 3);
      }

   }

   public final void gameAA() {
      if (this.gameAL != 0L) {
         ++this.gameAB;
         if (this.gameAB >= this.gameAA.arrEfInfo.length) {
            this.gameAB = 0;
         }

         if (System.currentTimeMillis() - this.gameAL > 0L) {
            if (this.gameAA.idEf == 120) {
               GameCanvas.gameAD = false;
            }

            Effect2.vEffect2.removeElement(this);
         }
      } else {
         ++this.gameAB;
         if (this.gameAB >= this.gameAA.arrEfInfo.length) {
            --this.gameAK;
            if (this.gameAK <= 0) {
               if (this.gameAA.idEf == 120) {
                  GameCanvas.gameAD = false;
               }

               Effect2.vEffect2.removeElement(this);
            } else {
               this.gameAB = 0;
            }
         }
      }

      if (GameCanvas.gameTick % 11 == 0 && this.gameAJ != null && this.gameAJ != Char.getMyChar() && !GameScr.vCharInMap.contains(this.gameAJ)) {
         Effect2.vEffect2.removeElement(this);
      }

   }
}
