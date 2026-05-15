package base.game2;

public class AutoCatDo extends Auto {
   private int idvp;

   public AutoCatDo(int id) {
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
         if (Code.solg_ruong() > 0) {
            for(int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
               Item itembag = Char.getMyChar().arrItemBag[i];
               if (this.idvp == -1) {
                  if (itembag != null) {
                     Service.gI().e(itembag.indexUI);
                     phong.sleep(10L);
                  }
               } else if (itembag != null && itembag.template.id == this.idvp) {
                  Service.gI().e(itembag.indexUI);
                  phong.sleep(10L);
               }
            }
         }

         phong.sleep(1000L);
         Code.mode = null;
      }

   }

   public String toString() {
      return "Cất đồ";
   }
}
