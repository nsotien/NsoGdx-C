public final class AutoNvhn extends Auto {
   public static boolean fieldAV;
   private static String[] fieldAW;
   private static int fieldAX;
   private TaskOrder fieldAY;

   private static void fieldAM() {
      fieldAV = false;
      fieldAW = new String[]{
         "Hôm nay con đã làm hết nhiệm vụ ta giao. Hãy quay lại vào ngày hôm sau.",
         "Đây là lần nhận nhiệm vụ thứ ",
         " trong ngày hôm nay. Mỗi ngày được nhận tối đa 20 lần con nhé."
      };
   }

   public static void fieldAA(String var0) {
      if (var0.equals(fieldAW[0])) {
         fieldAX = 21;
         LockGame.fieldAL();
      } else {
         int var1;
         if ((var1 = var0.indexOf(fieldAW[1])) >= 0) {
            var0 = var0.substring(var1 + fieldAW[1].length(), var0.indexOf(fieldAW[2])).trim();

            try {
               fieldAX = Integer.parseInt(var0);
               return;
            } catch (NumberFormatException var3) {
            }
         }
      }
   }

   public final void fieldAD() {
      fieldAX = 0;
      this.fieldAY = Char.fieldAM(0);
      super.fieldAD();
   }

   public final void fieldAE() {
      this.fieldAY = Char.fieldAM(0);
   }

   public final void fieldAA() {
      if (fieldAX <= 20 && (!(super.fieldAJ instanceof Stanima) || System.currentTimeMillis() - super.fieldAI < 3600000L)) {
         if (Char.getMyChar().cHP <= 0) {
            Auto.fieldAA(false);
            return;
         }

         if (TileMap.isTruong(TileMap.mapID)) {
            if (this.fieldAY == null) {
               GameScr.fieldAC("Nhận NV " + (fieldAX + 1) + "/20");
               GameScr.fieldAB(25, GameScr.fieldGH, 0);
               LockGame.fieldAK();
               this.fieldAY = Char.fieldAM(0);
               return;
            }

            if (this.fieldAY.count >= this.fieldAY.maxCount) {
               if (Char.fieldBF() <= 0) {
                  GameScr.fieldAC("Hành trang đầy");
                  return;
               }

               GameScr.fieldAC("Hoàn thành NV " + fieldAX + "/20");
               GameScr.fieldAB(25, GameScr.fieldGH, 2);
               this.fieldAY = null;
               return;
            }

            GameScr.fieldAC("Đi làm NV " + fieldAX + "/20");
            GameScr.fieldAB(25, GameScr.fieldGH, 3);
            TileMap.fieldAF();
            this.fieldAB(super.fieldAC);
            return;
         }

         if (this.fieldAY != null && TileMap.mapID == this.fieldAY.mapId) {
            if (this.fieldAY.count >= this.fieldAY.maxCount) {
               Auto.fieldAH();
               return;
            }

            this.fieldAB(this.fieldAY.killId, 1);
            this.fieldAC(-1);
            if (fieldAV) {
               GameScr.fieldAC(
                  "Nhiệm vụ " + fieldAX + "/20: " + this.fieldAY.count + "/" + this.fieldAY.maxCount + " " + Mob.arrMobTemplate[this.fieldAY.killId].name
               );
               fieldAV = false;
               return;
            }
         }
      } else {
         GameScr.fieldAC("Hoàn thành!");
         Code.fieldAC();
      }
   }

   public final String toString() {
      return "Auto Nvhn: " + fieldAX + "/20";
   }

   static {
      fieldAM();
   }
}
