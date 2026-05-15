package base.game2;

// Port TGAME: Auto chờ PK - bot phụ bay tới map/khu chờ PK + toạ độ cài sẵn, giữ kết nối
public class AutoChoPK extends Auto {
   public void runChoPK() {
      super.reset();
      this.map_auto = menu_pkam.map;
      this.khu_auto = menu_pkam.khucpk;
      this.x_auto = menu_pkam.x;
      this.y_auto = menu_pkam.y;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         hoisinh(true);
         return;
      }

      if (TileMap.mapID != this.map_auto || TileMap.zoneID != this.khu_auto) {
         this.remap(this.map_auto, this.khu_auto, -1, -1);
         return;
      }

      if (Char.getMyChar().cx1 != menu_pkam.x || Char.getMyChar().cy1 != menu_pkam.y) {
         if (menu_pkam.x != -1 && menu_pkam.y != -1) {
            Char.move(menu_pkam.x, menu_pkam.y);
         } else {
            menu_pkam.x = Char.getMyChar().cx1;
            menu_pkam.y = Char.getMyChar().cy1;
         }

         phong.sleep(500L);
         return;
      }

      Code.gkn();
   }

   public String toString() {
      return "Auto chờ PK";
   }
}
