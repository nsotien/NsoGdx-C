public final class InfoDlg {
   public int gameAA;
   public int gameAB;
   public int gameAC;
   public int gameAD;
   private int gameAG;
   private int gameAH;
   private int gameAI;
   private int gameAJ;
   private int gameAK = 28;
   private int gameAL;
   private int gameAM;
   private int gameAN;
   private int gameAO;
   private int gameAP;
   private boolean gameAQ = false;
   public static boolean gameAE;
   private static String gameAR;
   private static String gameAS;
   private static int gameAT;
   public static boolean gameAF;

   private static boolean gameAE() {
      if (Char.getMyChar().statusMe != 3) {
         for(int var0 = 2; var0 > 0; --var0) {
            int var1;
            try {
               if (Res.abs(GameCanvas.arrPos[var0].x - GameCanvas.arrPos[var0 - 1].x) <= 2) {
                  continue;
               }

               var1 = Res.abs(GameCanvas.arrPos[var0].y - GameCanvas.arrPos[var0 - 1].y);
            } catch (Exception var2) {
               var2.printStackTrace();
               return true;
            }

            if (var1 > 2) {
               return false;
            }
         }
      }

      return true;
   }

   private static void gameAF() {
      GameCanvas.keyHold[1] = false;
      GameCanvas.keyHold[2] = false;
      GameCanvas.keyHold[3] = false;
      GameCanvas.keyHold[4] = false;
      GameCanvas.keyHold[6] = false;
   }

   public final void gameAA() {
      if (GameCanvas.isPointerDown && !GameCanvas.isPointerJustRelease) {
         this.gameAG = GameCanvas.pxLast;
         this.gameAH = GameCanvas.pyLast;
         if (this.gameAG <= (GameCanvas.w >> 1) - 100 && this.gameAH >= GameCanvas.h >> 1) {
            if (!this.gameAQ) {
               this.gameAA = this.gameAC = this.gameAG;
               this.gameAB = this.gameAD = this.gameAH;
            }

            this.gameAQ = true;
            this.gameAM = GameCanvas.px - this.gameAA;
            this.gameAN = GameCanvas.py - this.gameAB;
            this.gameAO = this.gameAM * this.gameAM + this.gameAN * this.gameAN;
            this.gameAL = Res.gameAF(this.gameAO);
            if (Math.abs(this.gameAM) > 4 || Math.abs(this.gameAN) > 4) {
               this.gameAP = Res.gameAA(this.gameAM, this.gameAN);
               if (!GameCanvas.gameAB(this.gameAA - this.gameAK, this.gameAB - this.gameAK, this.gameAK << 1, this.gameAK << 1)) {
                  if (this.gameAL != 0) {
                     this.gameAD = this.gameAN * this.gameAK / this.gameAL;
                     this.gameAC = this.gameAM * this.gameAK / this.gameAL;
                     this.gameAC += this.gameAA;
                     this.gameAD += this.gameAB;
                     if (!Res.gameAA(this.gameAA - this.gameAK, this.gameAB - this.gameAK, this.gameAK << 1, this.gameAK << 1, this.gameAC, this.gameAD)) {
                        this.gameAC = this.gameAI;
                        this.gameAD = this.gameAJ;
                     } else {
                        this.gameAI = this.gameAC;
                        this.gameAJ = this.gameAD;
                     }
                  } else {
                     this.gameAC = this.gameAI;
                     this.gameAD = this.gameAJ;
                  }
               } else {
                  this.gameAC = GameCanvas.px;
                  this.gameAD = GameCanvas.py;
               }

               gameAF();
               if (!gameAE()) {
                  gameAF();
                  return;
               }

               if (this.gameAP <= 360 && this.gameAP > 340 || this.gameAP > 0 && this.gameAP <= 90) {
                  GameScr.gameFW = 0;
                  GameCanvas.keyHold[6] = true;
                  GameCanvas.keyPressedz[6] = true;
                  return;
               }

               if (this.gameAP > 290 && this.gameAP <= 340) {
                  GameScr.gameFW = 0;
                  GameCanvas.keyHold[3] = true;
                  GameCanvas.keyPressedz[3] = true;
                  return;
               }

               if (this.gameAP > 250 && this.gameAP <= 290) {
                  GameScr.gameFW = 0;
                  GameCanvas.keyHold[2] = true;
                  GameCanvas.keyPressedz[2] = true;
                  return;
               }

               if (this.gameAP > 200 && this.gameAP <= 250) {
                  GameScr.gameFW = 0;
                  GameCanvas.keyHold[1] = true;
                  GameCanvas.keyPressedz[1] = true;
                  return;
               }

               if (this.gameAP > 90 && this.gameAP <= 200) {
                  GameScr.gameFW = 0;
                  GameCanvas.keyHold[4] = true;
                  GameCanvas.keyPressedz[4] = true;
                  return;
               }
            }
         }
      } else {
         this.gameAA = this.gameAC = 50;
         this.gameAB = this.gameAD = GameCanvas.h - 50;
         this.gameAQ = false;
         gameAF();
      }

   }

   public static void gameAA(String var0, String var1, int var2) {
      if (var0 != null) {
         gameAE = true;
         gameAR = var0;
         gameAS = var1;
         gameAT = var2;
      }

   }

   public static void gameAB() {
      gameAA(mResources.gameBG, (String)null, 5000);
      gameAF = true;
   }

   public static void gameAA(String var0) {
      gameAA(var0, (String)null, 5000);
      gameAF = true;
   }

   public static void gameAA(mGraphics var0) {
      String var1 = gameAR;
      if (TileMap.gameAJ != null) {
         var1 = TileMap.gameAJ;
      }

      if (gameAE && (!gameAF || gameAT <= 4990) && !GameScr.gameDI) {
         Paint.gameAA(GameCanvas.hw - 64, 10, 128, 40, var0);
         if (gameAF) {
            GameCanvas.gameAA(GameCanvas.hw - mFont.tahoma_8b.gameAA(var1) / 2 - 10, 30, var0);
            mFont.tahoma_8b.gameAA(var0, var1, GameCanvas.hw + 5, 23, 2);
            return;
         }

         if (gameAS != null) {
            mFont.tahoma_8b.gameAA(var0, var1, GameCanvas.hw, 18, 2);
            mFont.tahoma_7_white.gameAA(var0, gameAS, GameCanvas.hw, 32, 2);
            return;
         }

         mFont.tahoma_8b.gameAA(var0, var1, GameCanvas.hw, 23, 2);
      }

   }

   public static void gameAC() {
      if (gameAT > 0 && --gameAT == 0) {
         gameAD();
      }

   }

   public static void gameAD() {
      gameAR = "";
      gameAS = null;
      gameAF = false;
      gameAT = 0;
      gameAE = false;
   }
}
