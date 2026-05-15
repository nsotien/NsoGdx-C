public final class TaThu extends Auto {
   private TaskOrder gameAY;
   public int gameAV;
   public static boolean gameAW;
   public static long gameAX;

   public final void gameAC() {
      super.gameAC();
      this.gameAY = Char.gameAM(1);
      if (this.gameAY != null) {
         this.gameAV = this.gameAY.killId;
         super.mapID = this.gameAY.mapId;
         if (TileMap.mapID == this.gameAY.mapId && TileMap.zoneID % 5 == 0) {
            super.zoneID = TileMap.zoneID;
            return;
         }
      }

      super.zoneID = 5;
      gameAW = false;
   }

   public final void gameAC(int var1, int var2) {
      super.gameAC();
      this.gameAY = null;
      this.gameAV = var2;
      super.mapID = var1;
      if (TileMap.mapID == var1 && TileMap.zoneID % 5 == 0) {
         super.zoneID = TileMap.zoneID;
      } else {
         super.zoneID = 5;
      }
   }

   public final void gameAD() {
      this.gameAY = Char.gameAM(1);
      super.gameAD();
   }

   public final void gameAK() {
      if (super.mapID < 0 || super.reAB instanceof Stanima && System.currentTimeMillis() - super.gameAI >= 3600000L) {
         Code.gameAC();
      } else {
         boolean var1;
         int var4;
         if (Auto.reAC()) {
            label87: {
               if (Char.DanhNhom && TileMap.mapID == super.mapID && TileMap.zoneID == super.zoneID && Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.hp < Char.getMyChar().mobFocus.maxHp / 20) {
                  for(var4 = 0; var4 < GameScr.vParty.size(); ++var4) {
                     Party var5;
                     if ((var5 = (Party)GameScr.vParty.elementAt(var4)).c != null && var5.c.cHP > 0) {
                        var1 = true;
                        break label87;
                     }
                  }
               }

               var1 = false;
            }

            if (!var1) {
               Auto.gameAA(true);
               return;
            }
         } else {
            if (TileMap.mapID != super.mapID || TileMap.zoneID != super.zoneID) {
               this.gameAA(super.mapID, super.zoneID, super.gameAE, super.gameAF);
               return;
            }

            if (this.gameAY != null && this.gameAY.count >= this.gameAY.maxCount) {
               GameScr.gameAC("Xong Tà Thú");
               Code.gameAC();
               return;
            }

            if (Char.getMyChar().cName.equals(Code.gameAH)) {
               if (Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.hp < Char.getMyChar().mobFocus.maxHp / 10) {
                  if (!LockGame.gameBG()) {
                     Service.gI().gameAK("waitGr");
                     LockGame.gameAA(200000L);
                     Service.gI().gameAK("notifyGr");
                  }

                  var1 = false;
               } else {
                  var1 = false;
               }
            } else {
               if (gameAW && System.currentTimeMillis() - gameAX > 120000L) {
                  gameAW = false;
               }

               var1 = gameAW;
            }

            if (!var1) {
               this.gameAB(this.gameAV, 8);
            }

            if (Char.getMyChar().cMP < Char.getMyChar().cMaxMP * Char.aMpValue / 100) {
               Char.getMyChar().gameAE(17);
            }

            if (Char.getMyChar().cHP < Char.getMyChar().cMaxHP * Char.aHpValue / 100) {
               var4 = (int)(System.currentTimeMillis() / 1000L);

               for(int var2 = 0; var2 < Char.getMyChar().vEff.size(); ++var2) {
                  Effect var3;
                  if ((var3 = (Effect)Char.getMyChar().vEff.elementAt(var2)).template.id == 21 && var3.timeLenght - (var4 - var3.timeStart) >= 2) {
                     return;
                  }
               }

               Char.getMyChar().gameAE(16);
               return;
            }
         }
      }

   }

   public final String toString() {
      return "Auto Tà Thú";
   }
}
