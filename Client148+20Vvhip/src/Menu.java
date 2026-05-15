import javax.microedition.lcdui.Image;

public final class Menu implements IActionListener {
   public boolean showMenu;
   private MyVector gameAD;
   public int menuSelectedItem;
   private int gameAE;
   private int gameAF;
   private int gameAG;
   private int gameAH;
   private int gameAI;
   private static int gameAJ;
   private static int gameAK;
   private static int gameAL;
   private static int gameAM;
   private Command gameAN;
   private Command gameAO;
   private Command gameAP;
   private static Image gameAQ = GameCanvas.gameAC("/hd/btnlBig0.png");
   private static Image gameAR = GameCanvas.gameAC("/hd/btnlBig1.png");
   public boolean gameAC;
   private int gameAS;
   private int gameAT;
   private int gameAU;
   private int[] gameAV;
   private boolean gameAW;
   private boolean gameAX;
   private int gameAY;
   private int gameAZ;
   private int gameBA;
   private int gameBB;

   public Menu() {
      this.gameAN = new Command(mResources.SELECT, 0);
      this.gameAO = GameCanvas.isTouch ? null : new Command(mResources.CLOSE, GameCanvas.w - 71, GameCanvas.h - mScreen.cmdH + 1);
      this.gameAP = null;
      this.gameAV = new int[3];
   }

   public final void gameAA(MyVector var1) {
      this.gameAC = false;
      ChatPopup.currentMultilineChatPopup = null;
      InfoDlg.gameAD();
      if (var1.size() != 0) {
         this.gameAD = var1;
         this.gameAG = 60;
         this.gameAH = 60;

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            Command var3 = (Command)var1.elementAt(var2);
            if (mFont.tahoma_7_yellow.gameAA(var3.caption) > this.gameAG - 8) {
               var3.subCaption = mFont.tahoma_7_yellow.gameAB(var3.caption, this.gameAG - 8);
            }
         }

         this.gameAE = (GameCanvas.w - var1.size() * this.gameAG) / 2;
         if (this.gameAE <= 0) {
            this.gameAE = 1;
         }

         this.gameAF = GameCanvas.h - this.gameAH - (Paint.hTab + 1);
         if (GameCanvas.isTouch) {
            this.gameAF -= 3;
         }

         this.gameAI = this.gameAF;
         this.showMenu = true;
         this.menuSelectedItem = 0;
         if ((gameAL = this.gameAD.size() * this.gameAG - GameCanvas.w) < 0) {
            gameAL = 0;
         }

         gameAJ = 0;
         gameAK = 0;
         gameAM = 50;
         this.gameAS = var1.size() * this.gameAG - 1;
         if (this.gameAS > GameCanvas.w - 2) {
            this.gameAS = GameCanvas.w - 2;
         }

         if (GameCanvas.isTouch) {
            this.menuSelectedItem = -1;
         }
      }

   }

   public final void gameAA() {
      if (this.showMenu) {
         boolean var1 = false;
         if (!GameCanvas.keyPressedz[2] && !GameCanvas.keyPressedz[4]) {
            if (!GameCanvas.keyPressedz[8] && !GameCanvas.keyPressedz[6]) {
               if (GameCanvas.keyPressedz[5]) {
                  if (this.gameAP != null) {
                     if (this.gameAP.idAction > 0) {
                        if (this.gameAP.actionListener == GameScr.gI()) {
                           GameScr.gI().gameAB(this.gameAP.idAction, this.gameAP.p);
                        } else {
                           this.perform(this.gameAP.idAction, this.gameAP.p);
                        }
                     }
                  } else {
                     this.gameAY = 2;
                  }
               } else if (GameCanvas.keyPressedz[12]) {
                  if (this.gameAN.idAction > 0) {
                     this.perform(this.gameAN.idAction, this.gameAN.p);
                  } else {
                     this.gameAY = 2;
                  }
               } else if (!this.gameAC && (GameCanvas.keyPressedz[13] || mScreen.gameAA(this.gameAO))) {
                  this.showMenu = false;
                  InfoDlg.gameAD();
               }
            } else {
               var1 = true;
               ++this.menuSelectedItem;
               if (this.menuSelectedItem > this.gameAD.size() - 1) {
                  this.menuSelectedItem = 0;
               }
            }
         } else {
            var1 = true;
            --this.menuSelectedItem;
            if (this.menuSelectedItem < 0) {
               this.menuSelectedItem = this.gameAD.size() - 1;
            }
         }

         this.gameAP = null;
         if (GameScr.gameDG && !GameCanvas.isTouch && this.menuSelectedItem != -1) {
            Command var2 = (Command)this.gameAD.elementAt(this.menuSelectedItem);
            ChatTab var3;
            if ((var3 = ChatManager.gameAD().gameAA(var2.caption)) != null && var3.type == 2) {
               this.gameAP = new Command(mResources.gameBQ, this, 1000, var3);
            }
         }

         if (var1) {
            if ((gameAJ = this.menuSelectedItem * this.gameAG + this.gameAG - GameCanvas.w / 2) > gameAL) {
               gameAJ = gameAL;
            }

            if (gameAJ < 0) {
               gameAJ = 0;
            }

            if (this.menuSelectedItem == this.gameAD.size() - 1 || this.menuSelectedItem == 0) {
               gameAK = gameAJ;
            }
         }

         if (!this.gameAC && GameCanvas.isPointerJustRelease && !GameCanvas.gameAC(this.gameAE, this.gameAF, this.gameAS, this.gameAH) && !this.gameAW) {
            this.gameAT = this.gameAU = 0;
            this.gameAW = false;
            this.showMenu = false;
            GameCanvas.isPointerJustRelease = false;
            return;
         }

         int var4;
         int var6;
         if (GameCanvas.isPointerDown) {
            if (!this.gameAW && GameCanvas.gameAC(this.gameAE, this.gameAF, this.gameAS, this.gameAH)) {
               for(var4 = 0; var4 < this.gameAV.length; ++var4) {
                  this.gameAV[0] = GameCanvas.px;
               }

               this.gameAU = GameCanvas.px;
               this.gameAW = true;
               this.gameAX = this.gameAZ != 0;
               this.gameAZ = 0;
            } else if (this.gameAW) {
               ++this.gameAT;
               if (this.gameAT > 5 && this.gameAU == GameCanvas.px && !this.gameAX) {
                  this.gameAU = -1000;
                  this.menuSelectedItem = (gameAJ + GameCanvas.px - this.gameAE) / this.gameAG;
               }

               if ((var4 = GameCanvas.px - this.gameAV[0]) != 0 && this.menuSelectedItem != -1) {
                  this.menuSelectedItem = -1;
               }

               for(var6 = this.gameAV.length - 1; var6 > 0; --var6) {
                  this.gameAV[var6] = this.gameAV[var6 - 1];
               }

               this.gameAV[0] = GameCanvas.px;
               if ((gameAJ -= var4) < 0) {
                  gameAJ = 0;
               }

               if (gameAJ > gameAL) {
                  gameAJ = gameAL;
               }

               if (gameAK < 0 || gameAK > gameAL) {
                  var4 /= 2;
               }

               gameAK -= var4;
            }
         }

         if (GameCanvas.isPointerJustRelease && this.gameAW) {
            var4 = GameCanvas.px - this.gameAV[0];
            GameCanvas.isPointerJustRelease = false;
            if (Res.abs(var4) < 20 && Res.abs(GameCanvas.px - this.gameAU) < 20 && !this.gameAX) {
               this.gameAZ = 0;
               gameAJ = gameAK;
               this.gameAU = -1000;
               this.menuSelectedItem = (gameAJ + GameCanvas.px - this.gameAE) / this.gameAG;
               this.gameAT = 0;
               this.gameAY = 10;
            } else if (this.menuSelectedItem != -1 && this.gameAT > 5) {
               this.gameAT = 0;
               this.gameAY = 1;
            } else if (this.menuSelectedItem == -1 && !this.gameAX) {
               if (gameAK < 0) {
                  gameAJ = 0;
               } else if (gameAK > gameAL) {
                  gameAJ = gameAL;
               } else {
                  byte var5;
                  if ((var6 = GameCanvas.px - this.gameAV[0] + (this.gameAV[0] - this.gameAV[1]) + (this.gameAV[1] - this.gameAV[2])) > 10) {
                     var5 = 10;
                  } else if (var6 < -10) {
                     var5 = -10;
                  } else {
                     var5 = 0;
                  }

                  this.gameAZ = -var5 * 100;
               }
            }

            this.gameAW = false;
            this.gameAT = 0;
            GameCanvas.isPointerJustRelease = false;
         }

         GameCanvas.gameAJ();
         GameCanvas.gameAK();
      }

   }

   public final void gameAA(mGraphics var1) {
      try {
         var1.gameAA(-var1.gameAA(), -var1.gameAB());
         var1.gameAA(-gameAK, 0);
         int var2;
         String[] var3;
         int var4;
         int var5;
         if (GameCanvas.isTouch) {
            for(var2 = 0; var2 < this.gameAD.size(); ++var2) {
               if (var2 == this.menuSelectedItem) {
                  var1.gameAA(gameAR, this.gameAE + var2 * this.gameAG + 1, this.gameAI + 1, 0);
               } else {
                  var1.gameAA(gameAQ, this.gameAE + var2 * this.gameAG + 1, this.gameAI + 1, 0);
               }

               if ((var3 = ((Command)this.gameAD.elementAt(var2)).subCaption) == null) {
                  var3 = new String[]{((Command)this.gameAD.elementAt(var2)).caption};
               }

               var4 = this.gameAI + (this.gameAH - var3.length * 14) / 2 + 1;

               for(var5 = 0; var5 < var3.length; ++var5) {
                  if (GameScr.gameDG) {
                     if (ChatManager.gameAD().gameAD(var3[var5])) {
                        if (GameCanvas.gameTick % 10 > 5) {
                           mFont.tahoma_7_red.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                        } else {
                           mFont.tahoma_7_yellow.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                        }
                     } else {
                        mFont.tahoma_7_yellow.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                     }
                  } else {
                     mFont.tahoma_7_yellow.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                  }
               }
            }
         } else {
            for(var2 = 0; var2 < this.gameAD.size(); ++var2) {
               if (var2 == this.menuSelectedItem) {
                  var1.gameAA(gameAR, this.gameAE + var2 * this.gameAG + 1, this.gameAI + 1 - 23, 0);
               } else {
                  var1.gameAA(gameAQ, this.gameAE + var2 * this.gameAG + 1, this.gameAI + 1 - 23, 0);
               }

               if ((var3 = ((Command)this.gameAD.elementAt(var2)).subCaption) == null) {
                  var3 = new String[]{((Command)this.gameAD.elementAt(var2)).caption};
               }

               var4 = this.gameAI + (this.gameAH - var3.length * 14) / 2 + 1 - 23;

               for(var5 = 0; var5 < var3.length; ++var5) {
                  if (GameScr.gameDG) {
                     if (ChatManager.gameAD().gameAD(var3[var5])) {
                        if (GameCanvas.gameTick % 10 > 5) {
                           mFont.tahoma_7_red.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                        } else {
                           mFont.tahoma_7_yellow.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                        }
                     } else {
                        mFont.tahoma_7_yellow.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                     }
                  } else {
                     mFont.tahoma_7_yellow.gameAA(var1, var3[var5], this.gameAE + var2 * this.gameAG + this.gameAG / 2 - 2, var4 + var5 * 14, 2);
                  }
               }
            }
         }

         var1.gameAA(-var1.gameAA(), -var1.gameAB());
      } catch (Exception var6) {
         var6.printStackTrace();
      }
   }

   public final void gameAB() {
      if (this.gameAZ != 0 && !this.gameAW) {
         if ((gameAJ += this.gameAZ / 100) < 0) {
            gameAJ = 0;
         } else if (gameAJ > gameAL) {
            gameAJ = gameAL;
         } else {
            gameAK = gameAJ;
         }

         this.gameAZ = this.gameAZ * 9 / 10;
         if (this.gameAZ < 100 && this.gameAZ > -100) {
            this.gameAZ = 0;
         }
      }

      if (gameAK != gameAJ && !this.gameAW) {
         this.gameBA = gameAJ - gameAK << 2;
         this.gameBB += this.gameBA;
         gameAK += this.gameBB >> 4;
         this.gameBB &= 15;
      }

      if (this.gameAI > this.gameAF) {
         int var1;
         if ((var1 = this.gameAI - this.gameAF >> 1) <= 0) {
            var1 = 1;
         }

         this.gameAI -= var1;
      }

      if (gameAM != 0 && (gameAM >>= 1) < 0) {
         gameAM = 0;
      }

      if (this.gameAY > 0) {
         --this.gameAY;
         GameScr.gameDG = false;
         if (this.gameAY == 0) {
            this.showMenu = false;
            Command var2;
            if (this.menuSelectedItem >= 0 && (var2 = (Command)this.gameAD.elementAt(this.menuSelectedItem)) != null) {
               var2.gameAA();
            }
         }
      }

   }

   public final void perform(int var1, Object var2) {
      if (var1 == 1000) {
         ChatTab var3 = (ChatTab)var2;
         this.gameAD.removeAllElements();
         ChatManager.gameAD().gameAE(var3.ownerName);
         ChatManager.gameAD().chatTabs.removeElement(var3);

         for(var1 = 0; var1 < ChatManager.gameAD().chatTabs.size(); ++var1) {
            ChatTab var4 = (ChatTab)ChatManager.gameAD().chatTabs.elementAt(var1);
            this.gameAD.addElement(new Command(var4.ownerName, (IActionListener)null, 12001, new Integer(var1)));
         }

         this.gameAD.addElement(new Command(mResources.gameUV, (IActionListener)null, 12006, (Object)null));
         this.gameAD.addElement(new Command(mResources.gameUW, (IActionListener)null, 12008, (Object)null));

         for(var1 = 0; var1 < this.gameAD.size(); ++var1) {
            Command var5 = (Command)this.gameAD.elementAt(var1);
            if (mFont.tahoma_7_yellow.gameAA(var5.caption) > this.gameAG - 8) {
               var5.subCaption = mFont.tahoma_7_yellow.gameAB(var5.caption, this.gameAG - 8);
            }
         }

         gameAL = this.gameAD.size() * this.gameAG - GameCanvas.w;
         if ((gameAJ = this.menuSelectedItem * this.gameAG + this.gameAG - GameCanvas.w / 2) > gameAL) {
            gameAJ = gameAL;
         }

         if (gameAJ < 0) {
            gameAJ = 0;
         }

         if (this.menuSelectedItem == this.gameAD.size() - 1 || this.menuSelectedItem == 0) {
            gameAK = gameAJ;
         }
      }

   }
}
