public final class ChoPk extends Auto {
   private long gameAV;

   public final void gameAL() {
      super.gameAC();
      if (Code.gameBW == -1 || Code.gameBX == -1 || Code.gameBY == -1) {
         Code.gameBW = 70;
         Code.gameBX = 1500;
         Code.gameBY = 528;
      }

      this.mapID = Code.gameBW;
      this.zoneID = Code.gameBU;
      this.gameAD = TileMap.gameAG(Code.gameBW);
   }

   public final void gameAK() {
      if (reAC()) {
         gameAA(true);

         try {
            Thread.sleep(1500L);
         } catch (InterruptedException var1) {
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
               } catch (InterruptedException var2) {
                  return;
               }
            }

            Code.gameAO();
            if (System.currentTimeMillis() - this.gameAV >= 30000L) {
               Code var10000 = Code.gameAA;
               Code.gameAH("chao a. e dung day tu chieu");
               this.gameAV = System.currentTimeMillis();
               return;
            }
         } else {
            this.gameAA(this.mapID, this.zoneID, this.gameAE, this.gameAF);
         }

      }
   }

   public final String toString() {
      return "Auto đứng chờ pk";
   }
}
