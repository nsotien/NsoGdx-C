public final class ChoBoss extends Auto {
   private int gameAV;

   public ChoBoss(int var1) {
      this.gameAV = var1;
   }

   public final void gameAA(String var1) {
      if (var1.startsWith("Thần thú đã xuất hiện tại")) {
         short var2 = -1;
         if (this.gameAV >= 40 && this.gameAV < 50) {
            if (var1.indexOf("Đảo Hebi") > 0) {
               var2 = 34;
            }

            if (var1.indexOf("Hang Meiro") > 0) {
               var2 = 35;
            }

            if (var1.indexOf("Rừng Kappa") > 0) {
               var2 = 52;
            }

            if (var1.indexOf("Rừng Aokigahara") > 0) {
               var2 = 14;
            }

            if (var1.indexOf("Vách núi Ito") > 0) {
               var2 = 15;
            }

            if (var1.indexOf("Núi Anzen") > 0) {
               var2 = 68;
            }

            if (var1.indexOf("Thung lũng Taira") > 0) {
               var2 = 16;
            }
         }

         if (this.gameAV >= 50 && this.gameAV < 60) {
            if (var1.indexOf("Núi Ontake") > 0) {
               var2 = 67;
            }

            if (var1.indexOf("Đỉnh Okama") > 0) {
               var2 = 44;
            }
         }

         if (this.gameAV >= 60 && this.gameAV < 70) {
            if (var1.indexOf("Khu đá đỏ Akai") > 0) {
               var2 = 41;
            }

            if (var1.indexOf("Mũi Hone") > 0) {
               var2 = 59;
            }

            if (var1.indexOf("Đỉnh Ichidai") > 0) {
               var2 = 24;
            }

            if (var1.indexOf("Hang núi Kurai") > 0) {
               var2 = 45;
            }
         }

         if (this.gameAV >= 70 && this.gameAV < 80) {
            if (var1.indexOf("Ngôi đền Orochi") > 0) {
               var2 = 19;
            }

            if (var1.indexOf("Đồng Kisei") > 0) {
               var2 = 36;
            }

            if (var1.indexOf("Đền Harumoto") > 0) {
               var2 = 54;
            }
         }

         if (this.gameAV >= 90 && this.gameAV < 100 && var1.indexOf("Đoạn Sơn") > 0) {
            var2 = 141;
         }

         if (this.gameAV >= 100 && this.gameAV < 110 && var1.indexOf("Đảo Quỷ") > 0) {
            var2 = 142;
         }

         if (this.gameAV >= 110 && var1.indexOf("Sinh Tử Kiều") > 0) {
            var2 = 143;
         }

         if (var2 > 0) {
            Code.gameAA((Auto)(new PkBoss(var2)));
         }
      }

   }

   public final void gameAK() {
   }

   public final String toString() {
      return "Chờ boss " + this.gameAV;
   }
}
