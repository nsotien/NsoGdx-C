public final class CreateCharScr extends mScreen implements IActionListener {
   private static CreateCharScr instance;
   private static TField tAddName;
   private static int indexGender;
   private static int indexHair;
   private static int selected;
   private static int[][] hairID = new int[][]{{11, 26, 27, 28}, {2, 23, 24, 25}};
   private static int[] defaultLeg = new int[]{9, 0};
   private static int[] defaultBody = new int[]{10, 1};
   private Command cmdGender;
   private Command cmdHair;
   private int curIndex = 0;

   public static CreateCharScr gameAA() {
      if (instance == null) {
         instance = new CreateCharScr();
      }

      return instance;
   }

   public CreateCharScr() {
      if (GameCanvas.w == 128) {
         GameScr.setSize(128, 120);
         GameScr.popupX = (GameCanvas.w - 128) / 2;
         GameScr.popupY = 0;
      } else {
         GameScr.setSize(170, 190);
         GameScr.popupX = (GameCanvas.w - 170) / 2;
         GameScr.popupY = (GameCanvas.h - 220) / 2;
      }

      indexGender = 1;
      (tAddName = new TField()).name = mResources.CHARNAME;
      tAddName.width = 100;
      tAddName.x = GameScr.popupX + 45;
      tAddName.x = GameScr.popupX + GameScr.gameGC / 2 - tAddName.width / 2;
      tAddName.y = GameScr.popupY + 62;
      if (GameCanvas.w == 128) {
         tAddName.width = 60;
      }

      tAddName.height = 26;
      tAddName.isFocus = true;
      tAddName.gameAC(0);
      indexGender = 1;
      indexHair = 0;
      super.center = new Command(mResources.gameFG, this, 8000, null);
      super.left = new Command(mResources.gameFL, this, 8001, null);
      this.cmdGender = new Command("", this, 8002, GameScr.popupX + GameScr.gameGC / 2 - mScreen.cmdW / 2, GameScr.popupY + 70 + 30);
      this.cmdHair = new Command("", this, 8003, GameScr.popupX + GameScr.gameGC / 2 - mScreen.cmdW / 2, GameScr.popupY + 70 + 70);
      super.right = tAddName.cmdClear;
   }

   public final void gameAB() {
      indexGender = GameCanvas.gameTick % 2;
      indexHair = GameCanvas.gameTick % 4;
      super.gameAB();
   }

   public final void gameAA(int var1) {
      tAddName.gameAA(var1);
   }

   public final void gameAC() {
      if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
         GameScr.cmx = 100;
      }

      if (GameCanvas.isTouch && GameCanvas.w >= 320) {
         if (super.left != null) {
            super.left.x = GameCanvas.w / 2 - 160;
            super.left.y = GameCanvas.h - 26;
         }

         if (super.center != null) {
            super.center.x = GameCanvas.w / 2 - 35;
            super.center.y = GameCanvas.h - 26;
         }

         if (super.right != null) {
            super.right.x = GameCanvas.w / 2 + 88;
            super.right.y = GameCanvas.h - 26;
         }
      }

      if (this.cmdHair != null) {
         this.cmdHair.gameAC();
      }

      if (this.cmdGender != null) {
         this.cmdGender.gameAC();
      }

   }

   public final void gameAD() {
      if (GameCanvas.keyPressedz[2] && --selected < 0) {
         selected = mResources.gameMX.length - 1;
      }

      if (GameCanvas.keyPressedz[8] && ++selected >= mResources.gameMX.length) {
         selected = 0;
      }

      if (selected == 0) {
         super.right = tAddName.cmdClear;
         tAddName.gameAC();
      }

      if (selected == 1) {
         if (GameCanvas.keyPressedz[4] && --indexGender < 0) {
            indexGender = mResources.MENUGENDER.length - 1;
         }

         if (GameCanvas.keyPressedz[6] && ++indexGender > mResources.MENUGENDER.length - 1) {
            indexGender = 0;
         }

         super.right = null;
      }

      if (selected == 2) {
         if (GameCanvas.keyPressedz[4] && --indexHair < 0) {
            indexHair = mResources.HAIR_STYLE[0].length - 1;
         }

         if (GameCanvas.keyPressedz[6] && ++indexHair > mResources.HAIR_STYLE[0].length - 1) {
            indexHair = 0;
         }
      }

      if (GameCanvas.isPointerJustRelease && GameCanvas.gameAB(GameScr.popupX + 5, GameScr.popupY + 65, GameScr.gameGC - 5, mScreen.ITEM_HEIGHT)) {
         selected = 0;
      }

      super.gameAD();
      GameCanvas.gameAK();
      GameCanvas.gameAJ();
   }

   public final void gameAA(mGraphics var1) {
      try {
         GameCanvas.gameAA(var1);
         Paint.gameAA(GameScr.popupX, GameScr.popupY, GameScr.gameGC, GameScr.gameGD, var1);
         byte var2 = 40;
         if (GameCanvas.w == 128) {
            var2 = 20;
         }

         int var3 = hairID[indexGender][indexHair];
         int var4 = defaultLeg[indexGender];
         int var5 = defaultBody[indexGender];
         Part var9 = GameScr.parts[var3];
         Part var10 = GameScr.parts[var4];
         Part var11 = GameScr.parts[var5];
         int var6 = GameCanvas.w / 2;
         int var7 = GameScr.popupY + 50;
         SmallImage.gameAB(var1, var9.pi[Char.CharInfo[0][0][0]].id, var6 + Char.CharInfo[0][0][1] + var9.pi[Char.CharInfo[0][0][0]].dx, var7 - Char.CharInfo[0][0][2] + var9.pi[Char.CharInfo[0][0][0]].dy, 0, 0);
         SmallImage.gameAB(var1, var10.pi[Char.CharInfo[0][1][0]].id, var6 + Char.CharInfo[0][1][1] + var10.pi[Char.CharInfo[0][1][0]].dx, var7 - Char.CharInfo[0][1][2] + var10.pi[Char.CharInfo[0][1][0]].dy, 0, 0);
         SmallImage.gameAB(var1, var11.pi[Char.CharInfo[0][2][0]].id, var6 + Char.CharInfo[0][2][1] + var11.pi[Char.CharInfo[0][2][0]].dx, var7 - Char.CharInfo[0][2][2] + var11.pi[Char.CharInfo[0][2][0]].dy, 0, 0);
         if (!GameCanvas.isTouch) {
            for(var3 = 0; var3 < mResources.gameMX.length; ++var3) {
               if (selected == var3) {
                  var4 = var3 > 0 ? -5 : 0;
                  SmallImage.gameAB(var1, 989, GameScr.popupX + 10 + (GameCanvas.gameTick % 7 > 3 ? 1 : 0), GameScr.popupY + 76 + var3 * var2 + var4, 2, StaticObj.VCENTER_HCENTER);
                  SmallImage.gameAB(var1, 989, GameScr.popupX + GameScr.gameGC - 15 - (GameCanvas.gameTick % 7 > 3 ? 1 : 0), GameScr.popupY + 76 + var3 * var2 + var4, 0, StaticObj.VCENTER_HCENTER);
               }
            }
         }

         if (GameCanvas.isTouch) {
            this.cmdGender.caption = mResources.MENUGENDER[indexGender];
            this.cmdGender.gameAA(var1);
            this.cmdHair.caption = mResources.HAIR_STYLE[indexGender][indexHair];
            this.cmdHair.gameAA(var1);
         } else {
            Paint.gameAB(this.cmdGender.x, this.cmdGender.y, this.cmdGender.w, this.cmdGender.h, var1);
            if (selected == 1) {
               var1.gameAA(Paint.COLORLIGHT);
               var1.gameAD(this.cmdGender.x, this.cmdGender.y, this.cmdGender.w, this.cmdGender.h);
               Paint.gameAB(this.cmdGender.x, this.cmdGender.y, this.cmdGender.w, this.cmdGender.h, var1);
            }

            Paint.gameAB(this.cmdHair.x, this.cmdHair.y, this.cmdHair.w, this.cmdHair.h, var1);
            if (selected == 2) {
               var1.gameAA(Paint.COLORLIGHT);
               var1.gameAD(this.cmdHair.x, this.cmdHair.y, this.cmdHair.w, this.cmdHair.h);
               Paint.gameAB(this.cmdHair.x, this.cmdHair.y, this.cmdHair.w, this.cmdHair.h, var1);
            }

            mFont.tahoma_7b_white.gameAA(var1, mResources.MENUGENDER[indexGender], GameScr.popupX + 85, GameScr.popupY + 66 + var2, 2);
            mFont.tahoma_7b_white.gameAA(var1, mResources.HAIR_STYLE[indexGender][indexHair], GameScr.popupX + 85, GameScr.popupY + 66 + (var2 << 1), 2);
         }

         tAddName.x = GameScr.popupX + GameScr.gameGC / 2 - tAddName.width / 2;
         tAddName.y = GameScr.popupY + 62;
         tAddName.title_Null = mResources.CHARNAME;
         tAddName.gameAA(var1);
         super.gameAA(var1);
         var1.gameAA(0);
      } catch (Exception var8) {
         System.out.println("CreateCharScr.paint(): 0");
         var8.printStackTrace();
      }
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 8000:
         Service.gI().gameAA(tAddName.gameAD(), indexGender, hairID[indexGender][indexHair]);
         return;
      case 8001:
         if (SelectCharScr.gameAA().isNullChar) {
            GameCanvas.selectsvScr.gameAB();
            return;
         }

         SelectCharScr.gameAA().gameAB();
         return;
      case 8002:
         this.curIndex = 1;
         selected = 1;
         if (this.curIndex == selected && --indexGender < 0) {
            indexGender = mResources.MENUGENDER.length - 1;
            return;
         }
         break;
      case 8003:
         this.curIndex = 2;
         selected = 2;
         if (this.curIndex == selected && ++indexHair > mResources.HAIR_STYLE[0].length - 1) {
            indexHair = 0;
         }
      }

   }
}
