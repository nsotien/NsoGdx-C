package base.game2;

public class NhiemVu53 extends Auto {
   private static int index = 0;
   private int[] x = new int[]{535, 760};
   private int[] y = new int[]{528, 504};
   private int[] x_nam = new int[]{503, 745};
   private int[] y_nam = new int[]{528, 480};
   private static int nam_old;

   public void run() {
      super.reset();
      this.map_auto = 42;
      this.khu_auto = 0;
      nam_old = Char.getQuantityItem(347);
   }

   protected void auto() {
      if (Auto.isDead()) {
         hoisinh(true);
      } else if (this.map_auto == TileMap.mapID) {
         if (Char.getQuantityItem(347) < 99) {
            if (Char.getMyChar().cx1 == this.x[index] && Char.getMyChar().cy1 == this.y[index]) {
               this.pickItem();
               if (Char.getQuantityItem(347) > nam_old) {
                  nam_old = Char.getQuantityItem(347);
                  ++index;
                  if (index >= this.x.length) {
                     index = 0;
                     ++this.khu_auto;
                     if (this.khu_auto > 29) {
                        this.khu_auto = 0;
                     }

                     this.chuyenkhu1(this.khu_auto);
                  }
               }
            } else {
               Char.move(this.x[index], this.y[index]);
            }
         } else {
            Code.popup_chat("Xong!");
            Code.mode = null;
         }
      } else {
         this.remap(42, -1, -1, -1);
      }

   }

   void pickItem() {
      for(int var4 = 0; var4 < GameScr.vItemMap.size(); ++var4) {
         ItemMap var5;
         if ((var5 = (ItemMap)GameScr.vItemMap.elementAt(var4)) != null && !var5.k && var5.template.id == 347 && var5.xEnd == this.x_nam[index] && var5.yEnd == this.y_nam[index]) {
            Char.getMyChar().itemFocus = var5;
            Service.gI().pickItem(var5.itemMapID);
         }
      }

   }

   public String toString() {
      return "Auto NV 53";
   }
}
