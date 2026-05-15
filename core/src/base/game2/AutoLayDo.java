package base.game2;

public class AutoLayDo extends Auto {
   private int idvp;

   public AutoLayDo(int id) {
      this.reset();
      this.idvp = id;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         hoisinh(false);
      } else {
         if (GameScr.npc_i(5) != null && (Math.abs(GameScr.npc_i(5).cx1 - Char.getMyChar().cx1) > 22 || Math.abs(GameScr.npc_i(5).cy1 - Char.getMyChar().cy1) > 22)) {
            Char.move(GameScr.npc_i(5).cx1, GameScr.npc_i(5).cy1);
         }

         GameScr.gI().doOpenUI(4);
         if (Code.solg_hanhtrang() > 0) {
            for(int i = 0; i < Char.getMyChar().arrItemBox.length; ++i) {
               Item itembox = Char.getMyChar().arrItemBox[i];
               if (this.idvp == -1) {
                  if (itembox != null) {
                     Service.gI().d(itembox.indexUI);
                     phong.sleep(10L);
                  }
               } else if (itembox != null && itembox.template.id == this.idvp) {
                  Service.gI().d(itembox.indexUI);
                  phong.sleep(10L);
               }
            }
         }

         phong.sleep(1000L);
         Code.mode = null;
      }

   }

   public String toString() {
      return "Lấy đồ";
   }
}
