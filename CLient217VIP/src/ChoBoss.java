public final class ChoBoss extends Auto {
   private int bossLevel;

   public ChoBoss(int var1) {
      this.bossLevel = var1;
   }

   public final void fieldAA(String mapName) {
      if (mapName.startsWith("Thần thú đã xuất hiện tại")) {
         short mapId = -1;
         if (this.bossLevel >= 40 && this.bossLevel < 50) {
            if (mapName.indexOf("Đảo Hebi") > 0) {
               mapId = 34;
            }

            if (mapName.indexOf("Hang Meiro") > 0) {
               mapId = 35;
            }

            if (mapName.indexOf("Rừng Kappa") > 0) {
               mapId = 52;
            }

            if (mapName.indexOf("Rừng Aokigahara") > 0) {
               mapId = 14;
            }

            if (mapName.indexOf("Vách núi Ito") > 0) {
               mapId = 15;
            }

            if (mapName.indexOf("Núi Anzen") > 0) {
               mapId = 68;
            }

            if (mapName.indexOf("Thung lũng Taira") > 0) {
               mapId = 16;
            }
         }

         if (this.bossLevel >= 50 && this.bossLevel < 60) {
            if (mapName.indexOf("Núi Ontake") > 0) {
               mapId = 67;
            }

            if (mapName.indexOf("Đỉnh Okama") > 0) {
               mapId = 44;
            }
         }

         if (this.bossLevel >= 60 && this.bossLevel < 70) {
            if (mapName.indexOf("Khu đá đỏ Akai") > 0) {
               mapId = 41;
            }

            if (mapName.indexOf("Mũi Hone") > 0) {
               mapId = 59;
            }

            if (mapName.indexOf("Đỉnh Ichidai") > 0) {
               mapId = 24;
            }

            if (mapName.indexOf("Hang núi Kurai") > 0) {
               mapId = 45;
            }
         }

         if (this.bossLevel >= 70 && this.bossLevel < 80) {
            if (mapName.indexOf("Ngôi đền Orochi") > 0) {
               mapId = 19;
            }

            if (mapName.indexOf("Đồng Kisei") > 0) {
               mapId = 36;
            }

            if (mapName.indexOf("Đền Harumoto") > 0) {
               mapId = 54;
            }
         }

         if (this.bossLevel >= 90 && this.bossLevel < 100 && mapName.indexOf("Đoạn Sơn") > 0) {
            mapId = 141;
         }

         if (this.bossLevel >= 100 && this.bossLevel < 110 && mapName.indexOf("Đảo Quỷ") > 0) {
            mapId = 142;
         }

         if (this.bossLevel >= 110 && mapName.indexOf("Sinh Tử Kiều") > 0) {
            mapId = 143;
         }

         if (mapId > 0) {
            Code.fieldAA(new PkBoss(mapId));
         }
      }
   }

   protected final void fieldAA() {
   }

   public final String toString() {
      return "Chờ boss " + this.bossLevel;
   }
}
