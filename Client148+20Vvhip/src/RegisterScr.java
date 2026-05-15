public final class RegisterScr extends mScreen implements IActionListener {
   public static RegisterScr gameAA;
   private int gameAC;
   private int gameAD;
   private int gameAE;
   private int gameAF;
   private int gameAG;
   private int gameAH;
   private int gameAI;
   private TField[] gameAJ = new TField[7];
   private String[] gameAK = new String[]{"Họ và tên", "Ngày, tháng, năm sinh", "Địa chỉ thường trú", "CMND", "Ngày cấp", "Nơi cấp", "Số điện thoại, địa chỉ thư điện tử (nếu có).", "* Dưới 18 tuổi chỉ có thể chơi 180p 1 ngày"};
   private String[] gameAL = new String[]{"Nguyen Van A", "17-03-1991", "34 Phan A p.12 q.BT", "987654321", "01-01-2011", "TP.Hồ Chí Minh", "abc@gmail.com", ""};
   public Scroll gameAB = new Scroll();

   public RegisterScr() {
      gameAA = this;
      this.gameAC = GameCanvas.hw - 100;
      this.gameAD = 10;
      this.gameAE = 200;
      this.gameAF = GameCanvas.h - 40;
      this.gameAG = this.gameAE - 40;
      this.gameAH = GameCanvas.hw - this.gameAG / 2;

      for(int var1 = 0; var1 < this.gameAJ.length; ++var1) {
         this.gameAJ[var1] = new TField();
         this.gameAJ[var1].name = this.gameAK[var1];
         this.gameAJ[var1].x = this.gameAH;
         this.gameAJ[var1].y = (var1 + 1) * 50;
         this.gameAJ[var1].width = this.gameAG;
         this.gameAJ[var1].height = mScreen.ITEM_HEIGHT + 2;
         this.gameAJ[var1].isFocus = false;
         this.gameAJ[var1].gameAC(3);
         this.gameAJ[var1].gameAA(this.gameAL[var1]);
         if (var1 == 0) {
            this.gameAJ[var1].isFocus = true;
         }
      }

      super.left = new Command(mResources.gameDQ, this, 1, (Object)null);
   }

   public final void gameAC() {
      super.gameAC();
      if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
         GameScr.cmx = 100;
      }

      int var1;
      for(var1 = 0; var1 < this.gameAJ.length; ++var1) {
         this.gameAJ[var1].gameAC();
      }

      new ScrollResult();
      ScrollResult var2;
      if ((var2 = this.gameAB.gameAB()).isDowning || var2.isFinish) {
         this.gameAI = (byte)var2.selected;
      }

      this.gameAB.gameAC();
      if (this.gameAI == -1) {
         for(var1 = 0; var1 < this.gameAJ.length; ++var1) {
            this.gameAJ[var1].isFocus = false;
         }
      }

   }

   public final void gameAA(int var1) {
      super.gameAA(var1);

      for(int var2 = 0; var2 < this.gameAJ.length; ++var2) {
         if (this.gameAJ[var2].isFocus) {
            this.gameAJ[var2].gameAA(var1);
         }
      }

   }

   public final void gameAD() {
      if (GameCanvas.keyPressedz[2]) {
         --this.gameAI;
         if (this.gameAI < 0) {
            this.gameAI = this.gameAK.length;
         }

         this.gameAB.gameAA(this.gameAI * this.gameAB.ITEM_SIZE);
      } else if (GameCanvas.keyPressedz[8]) {
         ++this.gameAI;
         if (this.gameAI > this.gameAK.length) {
            this.gameAI = 0;
         }

         this.gameAB.gameAA(this.gameAI * this.gameAB.ITEM_SIZE);
      }

      int var1;
      if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[8]) {
         GameCanvas.gameAJ();

         for(var1 = 0; var1 < this.gameAJ.length; ++var1) {
            this.gameAJ[var1].isFocus = false;
         }

         if (this.gameAI < this.gameAJ.length) {
            this.gameAJ[this.gameAI].isFocus = true;
         }

         this.gameAB.gameAA(this.gameAI * this.gameAB.ITEM_SIZE);
      }

      if (GameCanvas.gameAB(this.gameAC, this.gameAD, this.gameAE, this.gameAF) && GameCanvas.isPointerJustRelease) {
         for(var1 = 0; var1 < this.gameAJ.length; ++var1) {
            if (GameCanvas.gameAB(this.gameAJ[var1].x, this.gameAJ[var1].y, this.gameAJ[var1].width, this.gameAJ[var1].height)) {
               this.gameAI = var1;
            }
         }
      }

      super.gameAD();
      GameCanvas.gameAJ();
   }

   public final void gameAA(mGraphics var1) {
      var1.gameAA(0);
      var1.gameAD(0, 0, GameCanvas.w, GameCanvas.h);
      GameCanvas.gameAA(var1);
      Paint.gameAA(this.gameAC, this.gameAD, this.gameAE, this.gameAF, var1);
      mFont.tahoma_7b_white.gameAA(var1, mResources.gameDQ, GameCanvas.hw, this.gameAD + 10, 2);
      this.gameAB.gameAA(this.gameAK.length, 50, this.gameAC, this.gameAD + 25, this.gameAE, this.gameAF - 25, true, 0);
      this.gameAB.gameAA(var1, this.gameAC, this.gameAD + 25, this.gameAE, this.gameAF - 25);

      int var2;
      for(var2 = 0; var2 < this.gameAK.length; ++var2) {
         if (var2 != this.gameAK.length - 1) {
            mFont.tahoma_7_yellow.gameAA(var1, this.gameAK[var2], GameCanvas.hw, (var2 + 1) * 50 - 13, 2);
         } else {
            mFont.tahoma_7_red.gameAA(var1, this.gameAK[var2], GameCanvas.hw, (var2 + 1) * 50 - 13, 2);
         }
      }

      for(var2 = 0; var2 < this.gameAJ.length; ++var2) {
         this.gameAJ[var2].gameAB(var1);
      }

      super.gameAA(var1);
   }

   public final void gameAB() {
      super.gameAB();
      this.gameAB.gameAA();
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 1:
         Service.gI().gameAA(this.gameAJ[0].gameAD(), this.gameAJ[1].gameAD(), this.gameAJ[2].gameAD(), this.gameAJ[3].gameAD(), this.gameAJ[4].gameAD(), this.gameAJ[5].gameAD(), this.gameAJ[6].gameAD());
         GameCanvas.gameBS = false;
         GameScr.gI().gameAB();
      default:
      }
   }
}
