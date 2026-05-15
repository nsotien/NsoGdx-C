public final class Scroll {
   private int cmtoX;
   private int cmtoY;
   public int cmx;
   public int cmy;
   private int cmvx;
   private int cmvy;
   private int cmdx;
   private int cmdy;
   public int xPos;
   public int yPos;
   public int width;
   public int height;
   private int cmxLim;
   private int cmyLim;
   public static Scroll me;
   private int pointerDownTime;
   private int pointerDownFirstX;
   private int[] pointerDownLastX = new int[3];
   private boolean pointerIsDowning;
   private boolean isDownWhenRunning;
   private int cmRun;
   private int selectedItem;
   public int ITEM_SIZE;
   private int ITEM_PER_LINE;
   private boolean styleUPDOWN = true;

   public final void gameAA() {
      this.cmtoX = 0;
      this.cmtoY = 0;
      this.cmx = 0;
      this.cmy = 0;
      this.cmvx = 0;
      this.cmvy = 0;
      this.cmdx = 0;
      this.cmdy = 0;
      this.cmxLim = 0;
      this.cmyLim = 0;
      this.width = 0;
      this.height = 0;
   }

   public final void gameAA(mGraphics var1, int var2, int var3, int var4, int var5) {
      var1.gameAD(var2, var3, var4, var5 - 1);
      var1.gameAA(-var1.gameAA(), -var1.gameAB());
      var1.gameAA(-this.cmx, -this.cmy);
   }

   public final void gameAA(mGraphics var1) {
      var1.gameAD(this.xPos, this.yPos, this.width, this.height - 1);
      var1.gameAA(-var1.gameAA(), -var1.gameAB());
      var1.gameAA(-this.cmx, -this.cmy);
   }

   public final ScrollResult gameAB() {
      if (this.styleUPDOWN) {
         Scroll var5 = this;
         int var1 = this.xPos;
         int var2 = this.yPos;
         int var3 = this.width;
         int var4 = this.height;
         if (GameCanvas.isPointerDown) {
            if (!this.pointerIsDowning && GameCanvas.gameAC(var1, var2, var3, var4)) {
               for (int var20 = 0; var20 < var5.pointerDownLastX.length; var20++) {
                  var5.pointerDownLastX[0] = GameCanvas.py;
               }

               var5.pointerDownFirstX = GameCanvas.py;
               var5.pointerIsDowning = true;
               var5.selectedItem = -1;
               var5.isDownWhenRunning = var5.cmRun != 0;
               var5.cmRun = 0;
            } else if (this.pointerIsDowning) {
               this.pointerDownTime++;
               if (this.pointerDownTime > 5 && this.pointerDownFirstX == GameCanvas.py && !this.isDownWhenRunning) {
                  this.pointerDownFirstX = -1000;
                  if (this.ITEM_PER_LINE > 1) {
                     var3 = (this.cmtoY + GameCanvas.py - var2) / this.ITEM_SIZE;
                     var4 = (this.cmtoX + GameCanvas.px - var1) / this.ITEM_SIZE;
                     this.selectedItem = var3 * this.ITEM_PER_LINE + var4;
                  } else {
                     this.selectedItem = (this.cmtoY + GameCanvas.py - var2) / this.ITEM_SIZE;
                  }
               }

               if ((var3 = GameCanvas.py - this.pointerDownLastX[0]) != 0 && this.selectedItem != -1) {
                  this.selectedItem = -1;
               }

               for (int var25 = this.pointerDownLastX.length - 1; var25 > 0; var25--) {
                  var5.pointerDownLastX[var25] = var5.pointerDownLastX[var25 - 1];
               }

               var5.pointerDownLastX[0] = GameCanvas.py;
               var5.cmtoY -= var3;
               if (var5.cmtoY < 0) {
                  var5.cmtoY = 0;
               }

               if (var5.cmtoY > var5.cmyLim) {
                  var5.cmtoY = var5.cmyLim;
               }

               if (var5.cmy < 0 || var5.cmy > var5.cmyLim) {
                  var3 /= 2;
               }

               var5.cmy -= var3;
            }
         }

         boolean var7 = false;
         if (GameCanvas.isPointerJustRelease && var5.pointerIsDowning) {
            var4 = GameCanvas.py - var5.pointerDownLastX[0];
            GameCanvas.isPointerJustRelease = false;
            if (Res.abs(var4) < 20 && Res.abs(GameCanvas.py - var5.pointerDownFirstX) < 20 && !var5.isDownWhenRunning) {
               var5.cmRun = 0;
               var5.cmtoY = var5.cmy;
               var5.pointerDownFirstX = -1000;
               if (var5.ITEM_PER_LINE > 1) {
                  var2 = (var5.cmtoY + GameCanvas.py - var2) / var5.ITEM_SIZE;
                  var1 = (var5.cmtoX + GameCanvas.px - var1) / var5.ITEM_SIZE;
                  var5.selectedItem = var2 * var5.ITEM_PER_LINE + var1;
               } else {
                  var5.selectedItem = (var5.cmtoY + GameCanvas.py - var2) / var5.ITEM_SIZE;
               }

               var5.pointerDownTime = 0;
               var7 = true;
            } else if (var5.selectedItem != -1 && var5.pointerDownTime > 5) {
               var5.pointerDownTime = 0;
               var7 = true;
            } else if (var5.selectedItem == -1 && !var5.isDownWhenRunning) {
               if (var5.cmy < 0) {
                  var5.cmtoY = 0;
               } else if (var5.cmy > var5.cmyLim) {
                  var5.cmtoY = var5.cmyLim;
               } else {
                  byte var6;
                  if ((
                        var2 = GameCanvas.py
                           - var5.pointerDownLastX[0]
                           + (var5.pointerDownLastX[0] - var5.pointerDownLastX[1])
                           + (var5.pointerDownLastX[1] - var5.pointerDownLastX[2])
                     )
                     > 10) {
                     var6 = 10;
                  } else if (var2 < -10) {
                     var6 = -10;
                  } else {
                     var6 = 0;
                  }

                  var5.cmRun = -var6 * 100;
               }
            }

            var5.pointerIsDowning = false;
            var5.pointerDownTime = 0;
            GameCanvas.isPointerJustRelease = false;
         }

         ScrollResult var8;
         (var8 = new ScrollResult()).selected = var5.selectedItem;
         var8.isFinish = var7;
         var8.isDowning = var5.pointerIsDowning;
         return var8;
      } else {
         Scroll var5x = this;
         int var1x = this.xPos;
         int var2x = this.yPos;
         int var3x = this.width;
         int var4x = this.height;
         if (GameCanvas.isPointerDown) {
            if (!this.pointerIsDowning && GameCanvas.gameAC(var1x, var2x, var3x, var4x)) {
               for (int var16 = 0; var16 < var5x.pointerDownLastX.length; var16++) {
                  var5x.pointerDownLastX[0] = GameCanvas.px;
               }

               var5x.pointerDownFirstX = GameCanvas.px;
               var5x.pointerIsDowning = true;
               var5x.selectedItem = -1;
               var5x.isDownWhenRunning = var5x.cmRun != 0;
               var5x.cmRun = 0;
            } else if (this.pointerIsDowning) {
               this.pointerDownTime++;
               if (this.pointerDownTime > 5 && this.pointerDownFirstX == GameCanvas.px && !this.isDownWhenRunning) {
                  this.pointerDownFirstX = -1000;
                  this.selectedItem = (this.cmtoX + GameCanvas.px - var1x) / this.ITEM_SIZE;
               }

               if ((var3x = GameCanvas.px - this.pointerDownLastX[0]) != 0 && this.selectedItem != -1) {
                  this.selectedItem = -1;
               }

               for (int var21 = this.pointerDownLastX.length - 1; var21 > 0; var21--) {
                  var5x.pointerDownLastX[var21] = var5x.pointerDownLastX[var21 - 1];
               }

               var5x.pointerDownLastX[0] = GameCanvas.px;
               var5x.cmtoX -= var3x;
               if (var5x.cmtoX < 0) {
                  var5x.cmtoX = 0;
               }

               if (var5x.cmtoX > var5x.cmxLim) {
                  var5x.cmtoX = var5x.cmxLim;
               }

               if (var5x.cmx < 0 || var5x.cmx > var5x.cmxLim) {
                  var3x /= 2;
               }

               var5x.cmx -= var3x;
            }
         }

         boolean var7 = false;
         if (GameCanvas.isPointerJustRelease && var5x.pointerIsDowning) {
            var4x = GameCanvas.px - var5x.pointerDownLastX[0];
            GameCanvas.isPointerJustRelease = false;
            if (Res.abs(var4x) < 20 && Res.abs(GameCanvas.px - var5x.pointerDownFirstX) < 20 && !var5x.isDownWhenRunning) {
               var5x.cmRun = 0;
               var5x.cmtoX = var5x.cmx;
               var5x.pointerDownFirstX = -1000;
               var5x.selectedItem = (var5x.cmtoX + GameCanvas.px - var1x) / var5x.ITEM_SIZE;
               var5x.pointerDownTime = 0;
               var7 = true;
            } else if (var5x.selectedItem != -1 && var5x.pointerDownTime > 5) {
               var5x.pointerDownTime = 0;
               var7 = true;
            } else if (var5x.selectedItem == -1 && !var5x.isDownWhenRunning) {
               if (var5x.cmx < 0) {
                  var5x.cmtoX = 0;
               } else if (var5x.cmx > var5x.cmxLim) {
                  var5x.cmtoX = var5x.cmxLim;
               } else {
                  byte var6;
                  if ((
                        var2x = GameCanvas.px
                           - var5x.pointerDownLastX[0]
                           + (var5x.pointerDownLastX[0] - var5x.pointerDownLastX[1])
                           + (var5x.pointerDownLastX[1] - var5x.pointerDownLastX[2])
                     )
                     > 10) {
                     var6 = 10;
                  } else if (var2x < -10) {
                     var6 = -10;
                  } else {
                     var6 = 0;
                  }

                  var5x.cmRun = -var6 * 100;
               }
            }

            var5x.pointerIsDowning = false;
            var5x.pointerDownTime = 0;
            GameCanvas.isPointerJustRelease = false;
         }

         ScrollResult var8;
         (var8 = new ScrollResult()).selected = var5x.selectedItem;
         var8.isFinish = var7;
         var8.isDowning = var5x.pointerIsDowning;
         return var8;
      }
   }

   public final void gameAC() {
      if (this.cmRun != 0 && !this.pointerIsDowning) {
         if (this.styleUPDOWN) {
            this.cmtoY = this.cmtoY + this.cmRun / 100;
            if (this.cmtoY < 0) {
               this.cmtoY = 0;
            } else if (this.cmtoY > this.cmyLim) {
               this.cmtoY = this.cmyLim;
            } else {
               this.cmy = this.cmtoY;
            }
         } else {
            this.cmtoX = this.cmtoX + this.cmRun / 100;
            if (this.cmtoX < 0) {
               this.cmtoX = 0;
            } else if (this.cmtoX > this.cmxLim) {
               this.cmtoX = this.cmxLim;
            } else {
               this.cmx = this.cmtoX;
            }
         }

         this.cmRun = this.cmRun * 9 / 10;
         if (this.cmRun < 100 && this.cmRun > -100) {
            this.cmRun = 0;
         }
      }

      if (this.cmx != this.cmtoX && !this.pointerIsDowning) {
         this.cmvx = this.cmtoX - this.cmx << 2;
         this.cmdx = this.cmdx + this.cmvx;
         this.cmx = this.cmx + (this.cmdx >> 4);
         this.cmdx &= 15;
      }

      if (this.cmy != this.cmtoY && !this.pointerIsDowning) {
         this.cmvy = this.cmtoY - this.cmy << 2;
         this.cmdy = this.cmdy + this.cmvy;
         this.cmy = this.cmy + (this.cmdy >> 4);
         this.cmdy &= 15;
      }
   }

   public final void gameAA(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, int var8) {
      this.xPos = var3;
      this.yPos = var4;
      this.ITEM_SIZE = var2;
      this.width = var5;
      this.height = var6;
      this.styleUPDOWN = var7;
      this.ITEM_PER_LINE = var8;
      if (var7) {
         this.cmyLim = var1 * var2 - var6;
      } else {
         this.cmxLim = var1 * var2 - var5;
      }

      if (this.cmyLim < 0) {
         this.cmyLim = 0;
      }

      if (this.cmxLim < 0) {
         this.cmxLim = 0;
      }
   }

   public final void gameAA(int var1) {
      if (this.styleUPDOWN) {
         var1 -= (this.height - this.ITEM_SIZE) / 2;
         this.cmtoY = var1;
         if (this.cmtoY < 0) {
            this.cmtoY = 0;
         }

         if (this.cmtoY > this.cmyLim) {
            this.cmtoY = this.cmyLim;
            return;
         }
      } else {
         var1 -= (this.width - this.ITEM_SIZE) / 2;
         this.cmtoX = var1;
         if (this.cmtoX < 0) {
            this.cmtoX = 0;
         }

         if (this.cmtoX > this.cmxLim) {
            this.cmtoX = this.cmxLim;
         }
      }
   }
}
