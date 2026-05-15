package base.game1;

public class TraNV extends Auto {
   private int oldTaskId;

   public void run() {
      super.reset();
      this.oldTaskId = Char.getMyChar().ctaskId;
   }

   protected void auto() {
      Char c = Char.getMyChar();
      if (c.ctaskId != this.oldTaskId) {
         Code.popup_chat("Tra NV xong!");
         Code.mode = null;
         return;
      }

      if (isDead()) {
         hoisinh(false);
         return;
      }

      int mapId = GameScr.ae();
      byte npcId = GameScr.af();
      if (mapId < 0 || npcId < 0) {
         Code.popup_chat("Khong tim thay NPC NV!");
         Code.mode = null;
         return;
      }

      if (TileMap.mapID != mapId) {
         this.remap(mapId, -2, -1, -1);
      } else {
         GameScr.npc_b(npcId, 0, 0);
         Service.gI().b(npcId, 0, -1);
         phong1.o();
      }
   }

   public String toString() {
      return "Tra NV";
   }
}
