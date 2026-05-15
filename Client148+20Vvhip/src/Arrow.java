public final class Arrow {
   public int gameAA = 0;
   public int gameAB;
   public int gameAC;
   private int gameAD;
   private int gameAE;
   private int gameAF;
   private int gameAG;
   private int gameAH;
   private int gameAI;
   private Char gameAJ;
   private mResources gameAK = null;
   private static byte[] gameAL = new byte[]{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0};
   private static int[] gameAM = new int[]{0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370};
   private static int[] gameAN = new int[]{0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1};

   public Arrow(Char var1, mResources var2) {
      this.gameAJ = var1;
      this.gameAK = var2;
   }

   public final void gameAA() {
      if (this.gameAJ.mobFocus != null || this.gameAJ.charFocus != null) {
         if (this.gameAJ.mobFocus != null) {
            this.gameAD = this.gameAJ.mobFocus.x;
            this.gameAE = this.gameAJ.mobFocus.y - this.gameAJ.mobFocus.gameAL / 4;
         } else if (this.gameAJ.charFocus != null) {
            this.gameAD = this.gameAJ.charFocus.cx;
            this.gameAE = this.gameAJ.charFocus.cy - this.gameAJ.charFocus.ch / 4;
         }

         int var1 = this.gameAD - this.gameAB;
         int var2 = this.gameAE - this.gameAC;
         byte var3 = 4;
         if (var1 + var2 < 60) {
            var3 = 3;
         } else if (var1 + var2 < 30) {
            var3 = 2;
         }

         if (this.gameAB != this.gameAD) {
            if (var1 > 0 && var1 < 5) {
               this.gameAB = this.gameAD;
            } else if (var1 < 0 && var1 > -5) {
               this.gameAB = this.gameAD;
            } else {
               this.gameAF = this.gameAD - this.gameAB << 2;
               this.gameAH += this.gameAF;
               this.gameAB += this.gameAH >> var3;
               this.gameAH &= 15;
            }
         }

         if (this.gameAC != this.gameAE) {
            if (var2 > 0 && var2 < 5) {
               this.gameAC = this.gameAE;
            } else if (var2 < 0 && var2 > -5) {
               this.gameAC = this.gameAE;
            } else {
               this.gameAG = this.gameAE - this.gameAC << 2;
               this.gameAI += this.gameAG;
               this.gameAC += this.gameAI >> var3;
               this.gameAI &= 15;
            }
         }

         var1 = 0;
         var2 = 0;
         int var5 = 0;
         int var4 = 0;
         if (this.gameAJ.mobFocus != null) {
            var1 = this.gameAD - this.gameAJ.mobFocus.gameAK / 4;
            var5 = this.gameAD + this.gameAJ.mobFocus.gameAK / 4;
            var2 = this.gameAE - this.gameAJ.mobFocus.gameAL / 4;
            var4 = this.gameAE + this.gameAJ.mobFocus.gameAL / 4;
         } else if (this.gameAJ.charFocus != null) {
            var1 = this.gameAD - this.gameAJ.charFocus.cw / 4;
            var5 = this.gameAD + this.gameAJ.charFocus.cw / 4;
            var2 = this.gameAE - this.gameAJ.charFocus.ch / 4;
            var4 = this.gameAE + this.gameAJ.charFocus.ch / 4;
         }

         if (this.gameAA > 0) {
            --this.gameAA;
         }

         if (this.gameAA != 0 && (this.gameAB < var1 || this.gameAB > var5 || this.gameAC < var2 || this.gameAC > var4)) {
            return;
         }
      }

      this.gameAJ.arr = null;
      this.gameAB = this.gameAC = this.gameAD = this.gameAE = this.gameAF = this.gameAG = this.gameAH = this.gameAI = 0;
      this.gameAJ.gameAR();
      if (this.gameAJ.me) {
         this.gameAJ.gameAM();
      }

   }

   public final void gameAA(mGraphics var1) {
      int var2 = this.gameAD - this.gameAB;
      int var3 = this.gameAE - this.gameAC;
      var2 = Res.gameAA(var2, -var3);
      var3 = 0;

      while(true) {
         if (var3 >= gameAM.length - 1) {
            var2 = 0;
            break;
         }

         if (var2 >= gameAM[var3] && var2 <= gameAM[var3 + 1]) {
            var2 = var3 >= 16 ? 0 : var3;
            break;
         }

         ++var3;
      }

      try {
         SmallImage.gameAB(var1, this.gameAK.imgId[gameAL[var2]], this.gameAB, this.gameAC, gameAN[var2], 3);
      } catch (Exception var4) {
      }
   }
}
