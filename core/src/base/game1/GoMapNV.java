package base.game1;

public class GoMapNV extends Auto {
   private int targetMap;

   public void run(int mapId) {
      super.reset();
      this.targetMap = mapId;
   }

   protected void auto() {
      if (TileMap.mapID == this.targetMap) {
         Code.popup_chat("Den map NV " + this.targetMap + "!");
         Code.mode = null;
         return;
      }

      this.remap(this.targetMap, -2, -1, -1);
   }

   public String toString() {
      return "Di Map NV";
   }
}
