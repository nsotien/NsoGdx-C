import java.util.Vector;

public final class MonsterDart extends Effect2 {
   private int gameAA;
   private int gameAB;
   private int gameAG;
   private short gameAH = 256;
   private int gameAI;
   private int gameAJ;
   private int gameAK;
   private int gameAL;
   private int gameAM;
   private int gameAN;
   private Char gameAO;
   private BuNhin gameAP;
   private boolean gameAQ;
   private int gameAR;
   private int gameAS = 1;
   private static int gameAT;
   private static Vector gameAU = new Vector();
   private static int gameAV = 0;
   private int gameAW = 0;
   private int gameAX;
   private static byte[] gameAY = new byte[]{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0};
   private static int[] gameAZ = new int[]{0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1};
   private static int[] gameBA = new int[]{0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370};

   private void gameAA(int var1) {
      this.gameAA = var1;
      this.gameAB = this.gameAH * Res.gameAB(var1) >> 10;
      this.gameAG = this.gameAH * Res.gameAA(var1) >> 10;
   }

   public static void gameAA(int var0, int var1, boolean var2, short var3, int var4, int var5, int var6, Char var7) {
      gameAT = var3;
      Effect2.vEffect2.addElement(new MonsterDart(var0, var1, var2, var4, var5, var6, var7));
   }

   public static void gameAA(int var0, int var1, BuNhin var2) {
      Effect2.vEffect2.addElement(new MonsterDart(var0, var1, var2));
   }

   private MonsterDart(int var1, int var2, boolean var3, int var4, int var5, int var6, Char var7) {
      this.gameAN = 0;
      this.gameAI = var1;
      this.gameAJ = var2;
      this.gameAQ = var3;
      this.gameAR = var4;
      this.gameAL = var5;
      this.gameAM = var6;
      this.gameAO = var7;
      if (var3) {
         this.gameAA(this.gameAS * 90);
         ++this.gameAS;
         if (this.gameAS > 3) {
            this.gameAS = 1;
            return;
         }
      } else {
         if (var1 > var7.cx) {
            this.gameAA(240);
            return;
         }

         this.gameAA(300);
      }

   }

   private MonsterDart(int var1, int var2, BuNhin var3) {
      this.gameAN = 1;
      this.gameAI = var1;
      this.gameAJ = var2;
      this.gameAP = var3;
      if (var1 > var3.gameAA) {
         this.gameAA(240);
      } else {
         this.gameAA(300);
      }

      this.gameAH = 256;
      this.gameAA = 180;
      this.gameAB = this.gameAH * Res.gameAB(this.gameAA) >> 10;
      this.gameAG = this.gameAH * Res.gameAA(this.gameAA) >> 10;
   }

   public final void gameAA() {
      DomSang var1;
      if (gameAT > 100) {
         var1 = new DomSang(this.gameAI, this.gameAJ, 2);
         gameAU.addElement(var1);
      } else if (gameAT > 50 && gameAT <= 100) {
         var1 = new DomSang(this.gameAI, this.gameAJ, 5);
         gameAU.addElement(var1);
      } else if (gameAT > 30 && gameAT <= 50) {
         var1 = new DomSang(this.gameAI, this.gameAJ, 4);
         gameAU.addElement(var1);
      } else if (gameAT > 0 && gameAT <= 30) {
         var1 = new DomSang(this.gameAI, this.gameAJ, 3);
         gameAU.addElement(var1);
      }

      int var2;
      int var3;
      int var4;
      if (this.gameAO != null) {
         var3 = this.gameAO.cx - this.gameAI;
         var4 = this.gameAO.cy - (this.gameAO.ch >> 1) - this.gameAJ;
         ++this.gameAK;
         if ((Res.abs(var3) >= 16 || Res.abs(var4) >= 16) && this.gameAK <= 60) {
            if (Math.abs((var2 = Res.gameAA(var3, var4)) - this.gameAA) < 90 || var3 * var3 + var4 * var4 > 4096) {
               if (Math.abs(var2 - this.gameAA) < 15) {
                  this.gameAA = var2;
               } else if ((var2 - this.gameAA < 0 || var2 - this.gameAA >= 180) && var2 - this.gameAA >= -180) {
                  this.gameAA = Res.gameAC(this.gameAA - 15);
               } else {
                  this.gameAA = Res.gameAC(this.gameAA + 15);
               }
            }

            if (this.gameAH < 8192) {
               this.gameAH = (short)(this.gameAH + 1024);
            }

            this.gameAB = this.gameAH * Res.gameAB(this.gameAA) >> 10;
            this.gameAG = this.gameAH * Res.gameAA(this.gameAA) >> 10;
            var3 = var3 + this.gameAB >> 10;
            this.gameAI += var3;
            var4 = var4 + this.gameAG >> 10;
            this.gameAJ += var4;
            var3 = Res.gameAA(var3, -var4);
            var4 = 0;

            while(true) {
               if (var4 >= gameBA.length - 1) {
                  var3 = 0;
                  break;
               }

               if (var3 >= gameBA[var4] && var3 <= gameBA[var4 + 1]) {
                  var3 = var4 >= 16 ? 0 : var4;
                  break;
               }

               ++var4;
            }

            this.gameAX = var3;
            this.gameAW = gameAY[this.gameAX];
            gameAV = gameAZ[this.gameAX];
         }
      }

      var2 = 0;
      var3 = 0;
      if (this.gameAN != 0) {
         if (this.gameAN == 1) {
            var2 = this.gameAP.gameAA - this.gameAI;
            var3 = this.gameAP.gameAB - 10 - this.gameAJ;
            ++this.gameAK;
            if (Res.abs(var2) < 16 && Res.abs(var3) < 16 || this.gameAK > 60) {
               this.gameAP.gameAD = true;
               Effect2.vEffect2.removeElement(this);
               return;
            }
         }
      } else {
         var2 = this.gameAO.cx - this.gameAI;
         var3 = this.gameAO.cy - 10 - this.gameAJ;
         ++this.gameAK;
         if (this.gameAO.statusMe == 5 || this.gameAO.statusMe == 14) {
            this.gameAI += (this.gameAO.cx - this.gameAI) / 2;
            this.gameAJ += (this.gameAO.cy - this.gameAJ) / 2;
         }

         if (Res.abs(var2) < 16 && Res.abs(var3) < 16 || this.gameAK > 60) {
            this.gameAO.gameAA(this.gameAL, this.gameAM, this.gameAQ, this.gameAR);
            Effect2.vEffect2.removeElement(this);
            return;
         }
      }

      if (Math.abs((var4 = Res.gameAA(var2, var3)) - this.gameAA) < 90 || var2 * var2 + var3 * var3 > 4096) {
         if (Math.abs(var4 - this.gameAA) < 15) {
            this.gameAA = var4;
         } else if ((var4 - this.gameAA < 0 || var4 - this.gameAA >= 180) && var4 - this.gameAA >= -180) {
            this.gameAA = Res.gameAC(this.gameAA - 15);
         } else {
            this.gameAA = Res.gameAC(this.gameAA + 15);
         }
      }

      var2 = var2 + this.gameAB >> 10;
      this.gameAI += var2;
      var2 = var3 + this.gameAG >> 10;
      this.gameAJ += var2;

      for(var2 = 0; var2 < gameAU.size(); ++var2) {
         (var1 = (DomSang)gameAU.elementAt(var2)).gameAA();
         if (var1.frame > 3) {
            gameAU.removeElementAt(var2);
         }
      }

   }

   public final void gameAA(mGraphics var1) {
      int var2;
      if (this.gameAQ) {
         var2 = GameCanvas.gameTick % 7;
         if (this.gameAR == 114) {
            if (var2 < 4) {
               SmallImage.gameAB(var1, 1299, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            SmallImage.gameAB(var1, 1307, this.gameAI, this.gameAJ, 0, 3);
            return;
         }

         if (this.gameAR == 115) {
            if ((var2 = GameCanvas.gameTick % 20) < 4) {
               SmallImage.gameAB(var1, 1379, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.gameAB(var1, 1380, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.gameAB(var1, 1379, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.gameAB(var1, 1382, this.gameAI, this.gameAJ, 0, 3);
               return;
            }
         } else if (this.gameAR == 116) {
            if ((var2 = GameCanvas.gameTick % 17) < 4) {
               SmallImage.gameAB(var1, 1399, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.gameAB(var1, 1400, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.gameAB(var1, 1401, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.gameAB(var1, 1402, this.gameAI, this.gameAJ, 0, 3);
               return;
            }
         } else if (this.gameAR == 139) {
            if ((var2 = GameCanvas.gameTick % 20) < 4) {
               SmallImage.gameAB(var1, 1459, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.gameAB(var1, 1380, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.gameAB(var1, 1461, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.gameAB(var1, 1382, this.gameAI, this.gameAJ, 0, 3);
               return;
            }
         } else if (this.gameAR == 144 || this.gameAR == 163) {
            if ((var2 = GameCanvas.gameTick % 20) < 4) {
               SmallImage.gameAB(var1, 1459, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.gameAB(var1, 1380, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.gameAB(var1, 1461, this.gameAI, this.gameAJ, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.gameAB(var1, 1382, this.gameAI, this.gameAJ, 0, 3);
               return;
            }
         }
      } else {
         if (gameAT > 100) {
            var1.gameAA(GameScr.gameFM, 0, this.gameAW * 23, 31, 23, gameAV, this.gameAI, this.gameAJ, 0);
         } else if (gameAT > 50 && gameAT <= 100) {
            var1.gameAA(GameScr.gameFM, 0, 0, 14, 14, gameAV, this.gameAI, this.gameAJ, 0);
         } else if (gameAT > 30 && gameAT <= 50) {
            var1.gameAA(GameScr.gameFM, 0, 0, 8, 8, gameAV, this.gameAI, this.gameAJ, 0);
         } else if (gameAT > 0 && gameAT <= 30) {
            var1.gameAA(GameScr.gameFM, 0, 0, 8, 8, gameAV, this.gameAI, this.gameAJ, 0);
         }

         for(var2 = 0; var2 < gameAU.size(); ++var2) {
            DomSang var3;
            if ((var3 = (DomSang)gameAU.elementAt(var2)) != null) {
               var3.gameAA(var1);
            }
         }
      }

   }
}
