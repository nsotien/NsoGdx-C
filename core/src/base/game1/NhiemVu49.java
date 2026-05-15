package base.game1;

public class NhiemVu49 extends Auto {
   public final void run() {
      super.reset();
   }

   protected void auto() {
      if (Char.getMyChar().cHP <= 0) {
         hoisinh(true);
      } else {
         if (Char.getMyChar().getIndexBag(267) == -1) {
            if (Char.getMyChar().getIndexBag(266) == -1) {
               GameScr.npc_b(20, 0, 0);
               Service.gI().b(20, 0, 0);
               phong.sleep(1000L);
            } else {
               Char.move(GameScr.getNpc(20).cx1, GameScr.getNpc(20).cy1 + 168);
               phong.sleep(500L);
               Service.gI().useItem(Char.getItem(266).indexUI);
               phong.sleep(2500L);
            }
         } else {
            Code.popup_chat("Xong!");
            Code.mode = null;
         }

      }
   }

   public String toString() {
      return "Auto Nhiệm vụ 49";
   }
}
