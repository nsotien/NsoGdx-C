public final class DanhPk extends Auto {
   private long gameAV;
   private static long gameAW;

   public final void gameAL() {
      super.gameAC();
      if (Code.gameBW == -1 || Code.gameBX == -1 || Code.gameBY == -1) {
         Code.gameBW = 70;
         Code.gameBX = 1500;
         Code.gameBY = 528;
      }

      this.mapID = Code.gameBW;
      this.zoneID = Code.gameBV;
      this.gameAD = TileMap.gameAG(Code.gameBW);
   }

   public final void gameAK() {
      if (reAC()) {
         gameAA(true);

         try {
            Thread.sleep(1500L);
         } catch (InterruptedException var4) {
         }
      } else {
         if (this.mapID == TileMap.mapID && this.zoneID == TileMap.zoneID) {
            if (Char.getMyChar().cx != Code.gameBX || Char.getMyChar().cy != Code.gameBY) {
               if (Code.gameBX != -1 && Code.gameBY != -1) {
                  Char.gameAC(Code.gameBX, Code.gameBY);
               } else {
                  Code.gameBX = Char.getMyChar().cx;
                  Code.gameBY = Char.getMyChar().cy;
               }

               try {
                  Thread.sleep(500L);
                  return;
               } catch (InterruptedException var5) {
                  return;
               }
            }

            if (System.currentTimeMillis() - gameAW >= 300L) {
               MyVector var1 = new MyVector();

               for(int var2 = 0; var2 < GameScr.vCharInMap.size(); ++var2) {
                  Char var3;
                  if ((var3 = (Char)GameScr.vCharInMap.elementAt(var2)).cHP > 0 && var3.cTypePk == 3 && Math.abs(Char.getMyChar().cx - var3.cx) <= 50 && Math.abs(Char.getMyChar().cy - var3.cy) <= 50 && var1.size() <= skill1.maxFight) {
                     var1.addElement(var3);
                     if (var3.cHP > 0 && var3.cTypePk == 3 && Math.abs(Char.getMyChar().cx - var3.cx) <= 50) {
                        Service.gI().gameAA((MyVector)(new MyVector()), (MyVector)var1, (int)2);
                        gameAW = System.currentTimeMillis();
                     }
                  }
               }
            }

            Code.gameAO();
            if (System.currentTimeMillis() - this.gameAV >= 30000L) {
               Code var10000 = Code.gameAA;
               Code.gameAH("chao e. a dung day tu chieu");
               this.gameAV = System.currentTimeMillis();
               return;
            }
         } else {
            this.gameAA(this.mapID, this.zoneID, this.gameAE, this.gameAF);
         }

      }
   }

   public final String toString() {
      return "Auto đánh pk";
   }
}
