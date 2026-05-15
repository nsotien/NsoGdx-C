package base.game2;

public class ChoPk extends Auto {
   private static long p;
   private long o;

   public final void init() {
      super.reset();
      this.khu_auto = menu_pkam.khudpk;
      this.map_auto = menu_pkam.map;
      super.isPhoban = TileMap.isPhuBan(menu_pkam.map);
   }

   protected void auto() {
      if (Char.getMyChar().cHP <= 0) {
         hoisinh(true);
      } else {
         if (super.map_auto == TileMap.mapID && super.khu_auto == TileMap.zoneID) {
            if (Char.getMyChar().cx1 != Code.pkx || Char.getMyChar().cy1 != Code.pky) {
               Char.move(Code.pkx, Code.pky);
               phong.sleep(500L);
               return;
            }

            if (System.currentTimeMillis() - this.o >= 60000L) {
               Code.popup_chat("Mua pb mod hack ninja tại: nsotien.com (có cả IOS)"); // mod khách
               this.o = System.currentTimeMillis();
            }
         } else {
            this.remap(super.map_auto, super.khu_auto, super.x_auto, super.y_auto);
         }

      }
   }

   public String toString() {
      return "Auto Pk ";
   }
}
