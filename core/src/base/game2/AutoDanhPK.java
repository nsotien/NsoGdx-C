package base.game2;

// Port TGAME: Auto đánh PK - bot phụ bay tới map/khu đánh PK + toạ độ, attack target cTypePk==3 trong 50px
public class AutoDanhPK extends Auto {
   private static long lastAttackTime;

   public void runDanhPK() {
      super.reset();
      this.map_auto = menu_pkam.map;
      this.khu_auto = menu_pkam.khudpk;
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

      this.attackPkTargets();
      Code.gkn();
   }

   private void attackPkTargets() {
      if (System.currentTimeMillis() - lastAttackTime < 300L) {
         return;
      }

      int maxFight = my_skill != null ? my_skill.maxFight : 1;
      MyVector targets = new MyVector();
      Char me = Char.getMyChar();

      for (int i = 0; i < GameScr.vCharInMap.size() && targets.size() < maxFight; ++i) {
         Char target = (Char) GameScr.vCharInMap.elementAt(i);
         if (target != null
               && target.idChar != me.idChar
               && target.cHP > 0
               && target.statusMe != 14
               && target.statusMe != 5
               && target.statusMe != 15
               && target.cTypePk == 3
               && Math.abs(me.cx1 - target.cx1) <= 50
               && Math.abs(me.cy1 - target.cy1) <= 50
               && !Code.check_nhom3(target.cName)
               && !ListKO.a(target.cName)) {
            targets.addElement(target);
         }
      }

      if (targets.size() > 0) {
         Service.gI().sendPlayerAttack(new MyVector(), targets, 2);
         lastAttackTime = System.currentTimeMillis();
      }
   }

   public String toString() {
      return "Auto đánh PK";
   }
}
