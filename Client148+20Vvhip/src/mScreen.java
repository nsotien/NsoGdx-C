public class mScreen {
   public Command left;
   public Command center;
   public Command right;
   public static int ITEM_HEIGHT;
   public static int cmdW;
   public static int cmdH;
   public static int keyTouch;

   public void gameAB() {
      GameCanvas.gameAJ();
      GameCanvas.gameAK();
      if (GameCanvas.currentScreen != null) {
         GameCanvas.currentScreen.gameBM();
      }

      GameCanvas.currentScreen = this;
      MotherCanvas.instance.setFullScreenMode(true);
   }

   public void gameBM() {
   }

   public static void gameBP() {
      if (GameCanvas.isTouch) {
         cmdH = 26;
      } else {
         cmdH = 24;
      }
   }

   public void gameAA(int var1) {
   }

   public void gameAC() {
   }

   public void gameAD() {
      if (GameCanvas.keyPressedz[5] || gameAA(GameCanvas.currentScreen.center)) {
         GameCanvas.keyPressedz[5] = false;
         keyTouch = -1;
         GameCanvas.isPointerJustRelease = false;
         if (this.center != null) {
            this.center.gameAA();
         }
      }

      if (GameCanvas.keyPressedz[12] || gameAA(GameCanvas.currentScreen.left)) {
         GameCanvas.keyPressedz[12] = false;
         keyTouch = -1;
         GameCanvas.isPointerJustRelease = false;
         if (ChatTextField.gameAA().isShow) {
            if (ChatTextField.gameAA().left != null) {
               ChatTextField.gameAA().left.gameAA();
            }
         } else if (this.left != null) {
            this.left.gameAA();
         }
      }

      if (GameCanvas.keyPressedz[13] || gameAA(GameCanvas.currentScreen.right)) {
         GameCanvas.keyPressedz[13] = false;
         keyTouch = -1;
         GameCanvas.isPointerJustRelease = false;
         if (ChatTextField.gameAA().isShow) {
            if (ChatTextField.gameAA().right != null) {
               ChatTextField.gameAA().right.gameAA();
               return;
            }
         } else if (this.right != null) {
            this.right.gameAA();
         }
      }

   }

   public static boolean gameAA(Command var0) {
      if (var0 == null) {
         return false;
      } else if (var0.x != 0 && var0.y != 0) {
         return var0.gameAB();
      } else {
         if (GameCanvas.currentDialog != null) {
            if (GameCanvas.currentDialog.center != null && GameCanvas.gameAB(GameCanvas.w - cmdW >> 1, GameCanvas.h - cmdH - 5, cmdW, cmdH + 10)) {
               keyTouch = 1;
               if (var0 == GameCanvas.currentDialog.center && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                  return true;
               }
            }

            if (GameCanvas.currentDialog.left != null && GameCanvas.gameAB(0, GameCanvas.h - cmdH - 5, cmdW, cmdH + 10)) {
               keyTouch = 0;
               if (var0 == GameCanvas.currentDialog.left && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                  return true;
               }
            }

            if (GameCanvas.currentDialog.right != null && GameCanvas.gameAB(GameCanvas.w - cmdW, GameCanvas.h - cmdH - 5, cmdW, cmdH + 10)) {
               keyTouch = 2;
               if ((var0 == GameCanvas.currentDialog.right || var0 == ChatTextField.gameAA().right) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                  return true;
               }
            }
         } else {
            if (var0 == GameCanvas.currentScreen.left && GameCanvas.gameAB(0, GameCanvas.h - cmdH - 5, cmdW, cmdH + 10)) {
               keyTouch = 0;
               if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                  return true;
               }
            }

            if (var0 == GameCanvas.currentScreen.right && GameCanvas.gameAB(GameCanvas.w - cmdW, GameCanvas.h - cmdH - 5, cmdW, cmdH + 10)) {
               keyTouch = 2;
               if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                  return true;
               }
            }

            if ((var0 == GameCanvas.currentScreen.center || ChatPopup.currentMultilineChatPopup != null) && GameCanvas.gameAB(GameCanvas.w - cmdW >> 1, GameCanvas.h - cmdH - 5, cmdW, cmdH + 10)) {
               keyTouch = 1;
               if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public void gameAA(mGraphics var1) {
      var1.gameAA(-var1.gameAA(), -var1.gameAB());
      var1.gameAE(0, 0, GameCanvas.w, GameCanvas.h + 1);
      Paint.gameAA(var1);
      if (ChatPopup.currentMultilineChatPopup != null) {
         Paint.gameAA(var1, (Command)null, ChatPopup.currentMultilineChatPopup.cmdNextLine, (Command)null);
      } else if (ChatTextField.gameAA().isShow) {
         Paint.gameAA(var1, ChatTextField.gameAA().left, ChatTextField.gameAA().gameAF, ChatTextField.gameAA().right);
      } else {
         if (GameCanvas.currentDialog == null && !GameCanvas.menu.showMenu) {
            Paint.gameAA(var1, this.left, this.center, this.right);
         }

      }
   }

   static {
      ITEM_HEIGHT = mFont.tahoma_8b.gameAC() + 8;
      cmdW = 70 * mGraphics.zoomLevel;
      cmdH = 22;
      keyTouch = -1;
   }
}
