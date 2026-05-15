public final class PkBossS extends Auto {
   public int gameAV;
   public int gameAW;
   private int gameAX;
   private MyVector gameAY;
   private MyVector gameAZ;
   private long gameBA;

   public PkBossS(MyVector var1, MyVector var2, int var3) {
      this.gameAV = 0;
      this.gameAW = -1;
      this.gameAX = var3;
      this.gameAY = var1;
      this.gameAZ = var2;
   }

   public PkBossS(int var1) {
      this.gameAV = 1;
      this.gameAW = -1;
      this.gameAX = var1;
      this.gameBA = System.currentTimeMillis();
   }

   public final void gameAK() {
      if (Char.getMyChar().cHP <= 0) {
         Auto.gameAA(true);
      } else {
         switch(this.gameAV) {
         case 0:
            if (TileMap.mapID == 38 && TileMap.zoneID == 21) {
               LockGame.gameBJ();
               this.gameAV = 2;
               return;
            } else {
               this.gameAA(38, 21, -1, -1);
               return;
            }
         case 1:
            if (System.currentTimeMillis() - this.gameBA > 180000L) {
               Code.gameAC();
               return;
            }

            if (TileMap.mapID == 38 && TileMap.zoneID == 21) {
               break;
            }

            this.gameAA(38, 21, -1, -1);
            return;
         case 2:
            if (this.gameAY.size() > 0) {
               int var1 = this.gameAY.size() - 1;
               super.mapID = ((Integer)this.gameAY.elementAt(var1)).intValue();
               this.gameAW = ((Integer)this.gameAZ.elementAt(var1)).intValue();
               this.gameAY.removeElementAt(var1);
               this.gameAZ.removeElementAt(var1);
               this.gameAV = 3;
               Service.gI().gameAK("pkms " + super.mapID + " " + this.gameAW);
               return;
            }

            this.gameAV = 4;
            Service.gI().gameAK("pkes");
            return;
         case 3:
            if (this.gameAW > 0) {
               if (TileMap.mapID != this.gameAW) {
                  this.gameAA(this.gameAW, -2, -1, -1);
                  return;
               }

               GameScr.gameAB(5, 1, 0);
               if (LockGame.gameAY()) {
                  this.gameAV = 5;
                  Code.gameAA((Auto)(new PkBoss(super.mapID)));
                  return;
               }
            }
            break;
         case 4:
            if (this.gameAX <= 0) {
               this.gameAX = 22;
               return;
            }

            if (TileMap.mapID != this.gameAX) {
               this.gameAA(this.gameAX, -2, -1, -1);
               return;
            }

            GameScr.gameAB(5, 1, 0);
            if (LockGame.gameAY()) {
               Code.gameAC();
               return;
            }
            break;
         case 5:
            try {
               Thread.sleep(10000L);
            } catch (InterruptedException var2) {
               var2.printStackTrace();
            }

            if (Code.gameAH != null && !Char.getMyChar().cName.equals(Code.gameAH)) {
               this.gameAV = 1;
               this.gameBA = System.currentTimeMillis();
               return;
            }

            this.gameAV = 2;
            return;
         }

      }
   }

   public final String toString() {
      return "PKBoss S";
   }
}
