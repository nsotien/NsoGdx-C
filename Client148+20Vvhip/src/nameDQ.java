public final class nameDQ {
   private int gameAA;
   private String gameAB;
   private MyVector gameAC;
   private String gameAD;
   private String gameAE;
   private String gameAF;

   public nameDQ(int var1, String var2, String var3, String var4, String var5) {
      this.gameAA = var1;
      this.gameAB = var2;
      this.gameAD = var3;
      this.gameAE = var4;
      this.gameAF = var5;
      this.gameAC = new MyVector();
   }

   public final void gameAA(nameDP var1) {
      this.gameAC.addElement(var1);
   }

   public final void gameAA(mGraphics var1) {
      int var2 = GameScr.popupX;
      int var3 = GameScr.popupY;
      int var4 = GameScr.gameGC;
      int var5 = GameScr.gameGD;
      int var6 = GameScr.gameBL;
      gameAB(var1);
      Paint.gameAA(var2, var3, var4, var5, var1);
      String var8 = this.gameAB;
      int var9 = GameScr.gW / 2;
      var1.gameAA(Paint.COLORDARK);
      var1.gameAB(var9 - mFont.tahoma_8b.gameAA(var8) / 2 - 12, GameScr.popupY + 5, mFont.tahoma_8b.gameAA(var8) + 22, 24, 6, 6);
      var1.gameAA(Paint.COLORFOCUS);
      var1.gameAA(var9 - mFont.tahoma_8b.gameAA(var8) / 2 - 12, GameScr.popupY + 5, mFont.tahoma_8b.gameAA(var8) + 22, 24, 6, 6);
      mFont.tahoma_8b.gameAA(var1, var8, var9, GameScr.popupY + 9, 2);
      if (this.gameAD != null && !this.gameAD.equals("")) {
         mFont.tahoma_7b_white.gameAA(var1, this.gameAD, var2 + 10, var3 + 30, 0);
      }

      if (this.gameAE != null && !this.gameAE.equals("")) {
         mFont.tahoma_7b_white.gameAA(var1, this.gameAE, var2 + var4 - 10, var3 + 30, 1);
      }

      var1.gameAA(0);
      var1.gameAD(var2 + 4, var3 + 44, var4 - 7, var6 + 3);
      var1.gameAA(12281361);
      var1.gameAC(var2 + 5, var3 + 45, var4 - 10, var6);
      var1.gameAA(Paint.COLORBORDER);
      var1.gameAC(var2 + 5, var3 + 48 + var6, var4 - 10, var5 - 64 - var6);
      int var7 = this.gameAC.size();
      GameScr.gameGA = var2 + 5;
      GameScr.gameGB = var3 + 45;
      GameScr.gameBU.gameAA(var7, var6 + 2, GameScr.gameGA + 1, GameScr.gameGB, var4 - 12, var6 + 2, false, 1);
      GameScr.gameBU.gameAA(var1);

      for(var3 = 0; var3 < var7; ++var3) {
         nameDP var11 = (nameDP)this.gameAC.elementAt(var3);
         SmallImage.gameAB(var1, var11.gameAD, GameScr.gameGA + var3 * (var6 + 2) + var6 / 2, GameScr.gameGB + var6 / 2, 0, mGraphics.gameAD | mGraphics.gameAC);
         if (var11.gameAE > 0 && var11.gameAE <= 16) {
            GameScr.gI().gameAA(GameScr.gameGA + var3 * (var6 + 2) + var6 / 2, GameScr.gameGB + var6 / 2, var11.gameAE, var1);
         }

         if (var3 == GameScr.gameBM) {
            var1.gameAA(16777215);
            var1.gameAC(GameScr.gameGA + var3 * (var6 + 2) + 2, GameScr.gameGB + 2, var6 - 4, var6 - 4);
            GameScr.gameAA(GameScr.gameGA + var3 * (var6 + 2), GameScr.gameGB, var1);
         }
      }

      GameScr.gameGA += 8;
      GameScr.gameGB += 6;
      if (GameScr.gameBM >= 0) {
         gameAB(var1);
         nameDP var10 = (nameDP)this.gameAC.elementAt(GameScr.gameBM);
         GameScr.gameBO = 4 + var10.gameAC.length;
         var7 = GameScr.gameGB + var6 + 2;
         var4 -= 6;
         var5 = var5 - 70 - var6;
         GameScr.gameBT.gameAA(var1, var2, var7, var4, var5);
         GameScr.gI().gameGE = GameScr.gameGB + 18;
         if (var10 != null) {
            mFont var10000 = mFont.tahoma_7b_white;
            String var10002 = var10.gameAB;
            int var10003 = GameScr.gameGA + 5;
            GameScr var10004 = GameScr.gI();
            var10000.gameAA(var1, var10002, var10003, var10004.gameGE += 12, 0);

            for(var6 = 0; var6 < var10.gameAC.length; ++var6) {
               var10000 = mFont.tahoma_7_white;
               var10002 = var10.gameAC[var6];
               var10003 = GameScr.gameGA + 5;
               var10004 = GameScr.gI();
               var10000.gameAA(var1, var10002, var10003, var10004.gameGE += 12, 0);
            }
         }

         GameScr.gameBT.gameAA(GameScr.gameBO, 12, var2, var7, var4, var5, true, 1);
         if (GameScr.indexRow >= 0) {
            SmallImage.gameAB(var1, 942, GameScr.gameGA + 2, GameScr.gameGB + 32 + GameScr.indexRow * 12, 0, StaticObj.TOP_RIGHT);
         }

      }
   }

   private static void gameAB(mGraphics var0) {
      var0.gameAA(-var0.gameAA(), -var0.gameAB());
      var0.gameAE(0, -200, GameCanvas.w, 200 + GameCanvas.h);
   }

   public final void gameAA() {
      if (GameScr.gameAQ && GameCanvas.currentDialog == null) {
         if (!GameCanvas.keyPressedz[8]) {
            if (GameCanvas.keyPressedz[4]) {
               GameScr.indexRow = -1;
               if (--GameScr.gameBM < 0) {
                  GameScr.gameBM = this.gameAC.size() - 1;
               }

               GameScr.gI().left = GameScr.gI().center = null;
               this.gameAC();
               GameScr.gameBU.gameAA(GameScr.gameBM * GameScr.gameBU.ITEM_SIZE);
               GameScr.gameBT.gameAA();
               GameScr.indexRow = 0;
            } else if (GameCanvas.keyPressedz[6]) {
               GameScr.indexRow = -1;
               if (++GameScr.gameBM >= this.gameAC.size()) {
                  GameScr.gameBM = 0;
               }

               GameScr.gI().left = GameScr.gI().center = null;
               this.gameAC();
               GameScr.gameBU.gameAA(GameScr.gameBM * GameScr.gameBU.ITEM_SIZE);
               GameScr.gameBT.gameAA();
               GameScr.indexRow = 0;
            }
         }

         if (GameCanvas.isTouch) {
            ScrollResult var2;
            if (!(var2 = GameScr.gameBU.gameAB()).isDowning && !var2.isFinish) {
               ScrollResult var1;
               if (((var1 = GameScr.gameBT.gameAB()).isDowning || var1.isFinish) && GameScr.indexRow != var1.selected) {
                  GameScr.indexRow = var1.selected;
               }
            } else if (GameScr.gameBM != var2.selected) {
               if ((GameScr.gameBM = var2.selected) >= this.gameAC.size()) {
                  GameScr.gameBM = -1;
               }

               GameScr.gI().left = GameScr.gI().center = null;
               this.gameAC();
               GameScr.gameBT.gameAA();
               GameScr.indexRow = 0;
            }
         }

         GameCanvas.gameAK();
         GameCanvas.gameAJ();
      }
   }

   public final void gameAB() {
      GameScr.setSize(175, 200);
      this.gameAC();
      GameScr.gI().gameGR = this;
      GameScr.gameAQ = true;
   }

   private void gameAC() {
      GameScr.gI().center = null;
      GameScr.gI().left = null;
      if (this.gameAF != null && !this.gameAF.equals("")) {
         GameScr.gI().left = new Command(this.gameAF, 990003);
      }

      nameDP var1;
      if ((var1 = (nameDP)this.gameAC.elementAt(GameScr.gameBM)) != null && var1.gameAF != null && !var1.gameAF.equals("")) {
         GameScr.gI().center = new Command(var1.gameAF, 990002, var1);
      }

      GameScr.gI().right = new Command(mResources.CLOSE, 990001);
   }

   public final void gameAA(int var1, Object var2) {
      switch(var1) {
      case 990001:
         GameScr.gameAQ = false;
         GameScr.gI().gameGR = null;
         GameScr.gI().center = null;
         GameScr.gI().left = GameScr.gI().gameFT;
         GameScr.gI().right = null;
      default:
         return;
      case 990002:
         nameDP var3 = (nameDP)var2;
         Service.gI().gameAE(1, this.gameAA, var3.gameAA);
         return;
      case 990003:
         Service.gI().gameAE(2, this.gameAA, -1);
      }
   }
}
