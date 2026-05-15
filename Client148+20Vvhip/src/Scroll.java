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
   private static Scroll me;
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
      var1.gameAE(var2, var3, var4, var5 - 1);
      var1.gameAA(-var1.gameAA(), -var1.gameAB());
      var1.gameAA(-this.cmx, -this.cmy);
   }

   public final void gameAA(mGraphics var1) {
      var1.gameAE(this.xPos, this.yPos, this.width, this.height - 1);
      var1.gameAA(-var1.gameAA(), -var1.gameAB());
      var1.gameAA(-this.cmx, -this.cmy);
   }

   public final ScrollResult gameAB() {
      Scroll var1;
      int var2;
      int var3;
      int var4;
      int var5;
      boolean var6;
      ScrollResult var7;
      if (this.styleUPDOWN) {
         var1 = this;
         var2 = this.xPos;
         var3 = this.yPos;
         var4 = this.width;
         var5 = this.height;
         if (GameCanvas.isPointerDown) {
            if (!this.pointerIsDowning && GameCanvas.gameAC(var2, var3, var4, var5)) {
               for(var4 = 0; var4 < var1.pointerDownLastX.length; ++var4) {
                  var1.pointerDownLastX[0] = GameCanvas.py;
               }

               var1.pointerDownFirstX = GameCanvas.py;
               var1.pointerIsDowning = true;
               var1.selectedItem = -1;
               var1.isDownWhenRunning = var1.cmRun != 0;
               var1.cmRun = 0;
            } else if (this.pointerIsDowning) {
               ++this.pointerDownTime;
               if (this.pointerDownTime > 5 && this.pointerDownFirstX == GameCanvas.py && !this.isDownWhenRunning) {
                  this.pointerDownFirstX = -1000;
                  if (this.ITEM_PER_LINE > 1) {
                     var4 = (this.cmtoY + GameCanvas.py - var3) / this.ITEM_SIZE;
                     var5 = (this.cmtoX + GameCanvas.px - var2) / this.ITEM_SIZE;
                     this.selectedItem = var4 * this.ITEM_PER_LINE + var5;
                  } else {
                     this.selectedItem = (this.cmtoY + GameCanvas.py - var3) / this.ITEM_SIZE;
                  }
               }

               if ((var4 = GameCanvas.py - this.pointerDownLastX[0]) != 0 && this.selectedItem != -1) {
                  this.selectedItem = -1;
               }

               for(var5 = this.pointerDownLastX.length - 1; var5 > 0; --var5) {
                  var1.pointerDownLastX[var5] = var1.pointerDownLastX[var5 - 1];
               }

               var1.pointerDownLastX[0] = GameCanvas.py;
               var1.cmtoY -= var4;
               if (var1.cmtoY < 0) {
                  var1.cmtoY = 0;
               }

               if (var1.cmtoY > var1.cmyLim) {
                  var1.cmtoY = var1.cmyLim;
               }

               if (var1.cmy < 0 || var1.cmy > var1.cmyLim) {
                  var4 /= 2;
               }

               var1.cmy -= var4;
            }
         }

         var6 = false;
         if (GameCanvas.isPointerJustRelease && var1.pointerIsDowning) {
            var5 = GameCanvas.py - var1.pointerDownLastX[0];
            GameCanvas.isPointerJustRelease = false;
            if (Res.abs(var5) < 20 && Res.abs(GameCanvas.py - var1.pointerDownFirstX) < 20 && !var1.isDownWhenRunning) {
               var1.cmRun = 0;
               var1.cmtoY = var1.cmy;
               var1.pointerDownFirstX = -1000;
               if (var1.ITEM_PER_LINE > 1) {
                  var3 = (var1.cmtoY + GameCanvas.py - var3) / var1.ITEM_SIZE;
                  var2 = (var1.cmtoX + GameCanvas.px - var2) / var1.ITEM_SIZE;
                  var1.selectedItem = var3 * var1.ITEM_PER_LINE + var2;
               } else {
                  var1.selectedItem = (var1.cmtoY + GameCanvas.py - var3) / var1.ITEM_SIZE;
               }

               var1.pointerDownTime = 0;
               var6 = true;
            } else if (var1.selectedItem != -1 && var1.pointerDownTime > 5) {
               var1.pointerDownTime = 0;
               var6 = true;
            } else if (var1.selectedItem == -1 && !var1.isDownWhenRunning) {
               if (var1.cmy < 0) {
                  var1.cmtoY = 0;
               } else if (var1.cmy > var1.cmyLim) {
                  var1.cmtoY = var1.cmyLim;
               } else {
                  var3 = (var3 = GameCanvas.py - var1.pointerDownLastX[0] + (var1.pointerDownLastX[0] - var1.pointerDownLastX[1]) + (var1.pointerDownLastX[1] - var1.pointerDownLastX[2])) > 10 ? 10 : (var3 < -10 ? -10 : 0);
                  var1.cmRun = -var3 * 100;
               }
            }

            var1.pointerIsDowning = false;
            var1.pointerDownTime = 0;
            GameCanvas.isPointerJustRelease = false;
         }

         (var7 = new ScrollResult()).selected = var1.selectedItem;
         var7.isFinish = var6;
         var7.isDowning = var1.pointerIsDowning;
         return var7;
      } else {
         var1 = this;
         var2 = this.xPos;
         var3 = this.yPos;
         var4 = this.width;
         var5 = this.height;
         if (GameCanvas.isPointerDown) {
            if (!this.pointerIsDowning && GameCanvas.gameAC(var2, var3, var4, var5)) {
               for(var4 = 0; var4 < var1.pointerDownLastX.length; ++var4) {
                  var1.pointerDownLastX[0] = GameCanvas.px;
               }

               var1.pointerDownFirstX = GameCanvas.px;
               var1.pointerIsDowning = true;
               var1.selectedItem = -1;
               var1.isDownWhenRunning = var1.cmRun != 0;
               var1.cmRun = 0;
            } else if (this.pointerIsDowning) {
               ++this.pointerDownTime;
               if (this.pointerDownTime > 5 && this.pointerDownFirstX == GameCanvas.px && !this.isDownWhenRunning) {
                  this.pointerDownFirstX = -1000;
                  this.selectedItem = (this.cmtoX + GameCanvas.px - var2) / this.ITEM_SIZE;
               }

               if ((var4 = GameCanvas.px - this.pointerDownLastX[0]) != 0 && this.selectedItem != -1) {
                  this.selectedItem = -1;
               }

               for(var5 = this.pointerDownLastX.length - 1; var5 > 0; --var5) {
                  var1.pointerDownLastX[var5] = var1.pointerDownLastX[var5 - 1];
               }

               var1.pointerDownLastX[0] = GameCanvas.px;
               var1.cmtoX -= var4;
               if (var1.cmtoX < 0) {
                  var1.cmtoX = 0;
               }

               if (var1.cmtoX > var1.cmxLim) {
                  var1.cmtoX = var1.cmxLim;
               }

               if (var1.cmx < 0 || var1.cmx > var1.cmxLim) {
                  var4 /= 2;
               }

               var1.cmx -= var4;
            }
         }

         var6 = false;
         if (GameCanvas.isPointerJustRelease && var1.pointerIsDowning) {
            var5 = GameCanvas.px - var1.pointerDownLastX[0];
            GameCanvas.isPointerJustRelease = false;
            if (Res.abs(var5) < 20 && Res.abs(GameCanvas.px - var1.pointerDownFirstX) < 20 && !var1.isDownWhenRunning) {
               var1.cmRun = 0;
               var1.cmtoX = var1.cmx;
               var1.pointerDownFirstX = -1000;
               var1.selectedItem = (var1.cmtoX + GameCanvas.px - var2) / var1.ITEM_SIZE;
               var1.pointerDownTime = 0;
               var6 = true;
            } else if (var1.selectedItem != -1 && var1.pointerDownTime > 5) {
               var1.pointerDownTime = 0;
               var6 = true;
            } else if (var1.selectedItem == -1 && !var1.isDownWhenRunning) {
               if (var1.cmx < 0) {
                  var1.cmtoX = 0;
               } else if (var1.cmx > var1.cmxLim) {
                  var1.cmtoX = var1.cmxLim;
               } else {
                  var3 = (var3 = GameCanvas.px - var1.pointerDownLastX[0] + (var1.pointerDownLastX[0] - var1.pointerDownLastX[1]) + (var1.pointerDownLastX[1] - var1.pointerDownLastX[2])) > 10 ? 10 : (var3 < -10 ? -10 : 0);
                  var1.cmRun = -var3 * 100;
               }
            }

            var1.pointerIsDowning = false;
            var1.pointerDownTime = 0;
            GameCanvas.isPointerJustRelease = false;
         }

         (var7 = new ScrollResult()).selected = var1.selectedItem;
         var7.isFinish = var6;
         var7.isDowning = var1.pointerIsDowning;
         return var7;
      }
   }

   public final void gameAC() {
      if (this.cmRun != 0 && !this.pointerIsDowning) {
         if (this.styleUPDOWN) {
            this.cmtoY += this.cmRun / 100;
            if (this.cmtoY < 0) {
               this.cmtoY = 0;
            } else if (this.cmtoY > this.cmyLim) {
               this.cmtoY = this.cmyLim;
            } else {
               this.cmy = this.cmtoY;
            }
         } else {
            this.cmtoX += this.cmRun / 100;
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
         this.cmdx += this.cmvx;
         this.cmx += this.cmdx >> 4;
         this.cmdx &= 15;
      }

      if (this.cmy != this.cmtoY && !this.pointerIsDowning) {
         this.cmvy = this.cmtoY - this.cmy << 2;
         this.cmdy += this.cmvy;
         this.cmy += this.cmdy >> 4;
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

   public static Scroll gameAD() {
      if (me == null) {
         me = new Scroll();
      }

      return me;
   }
}
