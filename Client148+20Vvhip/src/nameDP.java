public final class nameDP {
   public int gameAA;
   public String gameAB;
   public String[] gameAC;
   public short gameAD;
   public int gameAE;
   public String gameAF;

   public nameDP(int var1, String var2, String var3, short var4, int var5, String var6) {
      this.gameAA = var1;
      this.gameAB = var2;
      this.gameAD = var4;
      this.gameAE = var5;
      this.gameAF = var6;
      short var7 = 176;
      if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
         var7 = 100;
      }

      this.gameAC = mFont.tahoma_7_white.gameAB(var3, var7);
   }
}
