package base.game1;

final class chuyenkhu implements Runnable {
   private final int targetZone;

   chuyenkhu(int var2) {
      this.targetZone = var2;
   }

   public final void run() {
      if (TileMap.zoneID == this.targetZone) {
         return;
      }

      int kdl;
      if ((kdl = Code.index_item(37)) == -1) {
         kdl = Code.index_item(35);
      }

      Npc var1 = GameScr.npc_i(13);
      if (var1 != null && var1.statusMe != 15) {
         if (kdl == -1 && (Math.abs(var1.cx1 - Char.getMyChar().cx1) > 22 || Math.abs(var1.cy1 - Char.getMyChar().cy1) > 22)) {
            Char.move(var1.cx1, var1.cy1);
            phong.sleep(200L);
         }
      } else {
         if (TileMap.mapID != 99 && TileMap.mapID != 103 && TileMap.mapID != 134 && TileMap.mapID != 135 && TileMap.mapID != 136 && TileMap.mapID != 137) {
            return;
         }
         if (kdl == -1) {
            return;
         }
      }

      Service.gI().a(this.targetZone, kdl);
      TileMap.f2(10000L);
   }
}
