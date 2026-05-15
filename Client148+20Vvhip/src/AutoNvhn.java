public final class AutoNvhn extends Auto {
   public static boolean gameAV = false;
   private static String[] gameAW = new String[]{"Hôm nay con đã làm hết nhiệm vụ ta giao. Hãy quay lại vào ngày hôm sau.", "Đây là lần nhận nhiệm vụ thứ ", " trong ngày hôm nay. Mỗi ngày được nhận tối đa 20 lần con nhé."};
   private static int gameAX;
   private TaskOrder gameAY;

   public static void gameAA(String var0) {
      if (var0.equals(gameAW[0])) {
         gameAX = 21;
         LockGame.gameAL();
      } else {
         int var1;
         if ((var1 = var0.indexOf(gameAW[1])) >= 0) {
            var0 = var0.substring(var1 + gameAW[1].length(), var0.indexOf(gameAW[2])).trim();

            try {
               gameAX = Integer.parseInt(var0);
               return;
            } catch (NumberFormatException var2) {
            }
         }

      }
   }

   public final void gameAC() {
      gameAX = 0;
      this.gameAY = Char.gameAM(0);
      super.gameAC();
   }

   public final void gameAD() {
      this.gameAY = Char.gameAM(0);
   }

   public final void gameAK() {
      if (gameAX <= 20 && (!(super.reAB instanceof Stanima) || System.currentTimeMillis() - super.gameAI < 3600000L)) {
         if (Char.getMyChar().cHP <= 0) {
            Auto.gameAA(false);
            return;
         }

         if (TileMap.gameAF(TileMap.mapID)) {
            if (this.gameAY == null) {
               GameScr.gameAC("Nhận NV " + (gameAX + 1) + "/20");
               GameScr.gameAB(25, GameScr.gameGP, 0);
               LockGame.gameAK();
               this.gameAY = Char.gameAM(0);
               return;
            }

            if (this.gameAY.count >= this.gameAY.maxCount) {
               if (Char.gameBG() <= 0) {
                  GameScr.gameAC("Hành trang đầy");
                  return;
               }

               GameScr.gameAC("Hoàn thành NV " + gameAX + "/20");
               GameScr.gameAB(25, GameScr.gameGP, 2);
               this.gameAY = null;
               return;
            }

            GameScr.gameAC("Đi làm NV " + gameAX + "/20");
            GameScr.gameAB(25, GameScr.gameGP, 3);
            TileMap.gameAF();
            this.gameAB(super.zoneID);
            return;
         }

         if (this.gameAY != null && TileMap.mapID == this.gameAY.mapId) {
            if (this.gameAY.count >= this.gameAY.maxCount) {
               Auto.reAD();
               return;
            }

            this.gameAB(this.gameAY.killId, 1);
            this.gameAC(-1);
            if (gameAV) {
               GameScr.gameAC("Nhiệm vụ " + gameAX + "/20: " + this.gameAY.count + "/" + this.gameAY.maxCount + " " + Mob.arrMobTemplate[this.gameAY.killId].name);
               gameAV = false;
               return;
            }
         }
      } else {
         GameScr.gameAC("Hoàn thành!");
         Code.gameAC();
      }

   }

   public final String toString() {
      return "Auto NVHN: " + gameAX + "/20";
   }
}
