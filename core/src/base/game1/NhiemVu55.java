package base.game1;

public class NhiemVu55 extends Auto {
   private static int old;
   private static boolean sudung;

   public void run() {
      super.reset();
      this.map_auto = 24;
      this.khu_auto = 0;
      old = Char.getQuantityItem(220);
      sudung = true;
   }

   protected void auto() {
      if (Auto.isDead()) {
         hoisinh(true);
      } else if (this.map_auto == TileMap.mapID) {
         if (Char.getQuantityItem(220) < 150) {
            if (Char.getMyChar().cx1 == 365 && Char.getMyChar().cy1 == 335) {
               if (sudung) {
                  Service.gI().useItem(Char.getItem(219).indexUI);
                  phong.sleep(1000L);
                  sudung = false;
               }

               if (Char.getQuantityItem(220) > old) {
                  old = Char.getQuantityItem(220);
                  sudung = true;
               }
            } else {
               Char.move(365, 335);
            }
         } else {
            Code.popup_chat("Xong!");
            Code.mode = null;
         }
      } else {
         this.remap(24, -1, -1, -1);
      }

   }

   public String toString() {
      return "Auto NV 55";
   }
}
