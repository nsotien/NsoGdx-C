package base.game2;

public class AutoGomNhan extends Auto {
   private static final int STATE_MOVE = 0;
   private static final int STATE_WAIT = 1;
   private static final int STATE_CAT  = 2;

   private final int mapDich;
   private final int zoneDich;
   private int state = STATE_MOVE;
   private int tradeCount = 0;
   public volatile boolean isBusy = false;

   public AutoGomNhan(int map, int zone) {
      super.reset();
      this.mapDich = map;
      this.zoneDich = zone;
      this.map_auto = map;
      this.khu_auto = zone;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         hoisinh(false);
         return;
      }

      switch (state) {
         case STATE_MOVE: doMove(); break;
         case STATE_WAIT: doWait(); break;
         case STATE_CAT:  doCat();  break;
      }
   }

   private void doMove() {
      if (TileMap.mapID != mapDich || TileMap.zoneID != zoneDich) {
         this.remap(mapDich, zoneDich, -1, -1);
         return;
      }
      state = STATE_WAIT;
   }

   private void doWait() {
      if (TileMap.mapID != mapDich || TileMap.zoneID != zoneDich) {
         state = STATE_MOVE;
         return;
      }
      if (!GameScr.cs) {
         return;
      }

      GameScr.gI().dj = 0;
      GameScr.cc = new Item[12];
      Service.gI().a((int) 0, (Item[]) GameScr.cc);
      GameScr.gI().dh = 1;

      long t0 = System.currentTimeMillis();
      while (GameScr.gI().di != 1) {
         phong.sleep(100L);
         if (!GameScr.cs) return;
         if (System.currentTimeMillis() - t0 > 10000L) return;
      }

      long t1 = System.currentTimeMillis();
      while (System.currentTimeMillis() - t1 < 2000L) {
         phong.sleep(100L);
         if (!GameScr.cs) return;
      }

      Service.gI().j();
      GameScr.gI().dh = 2;

      long t2 = System.currentTimeMillis();
      while (GameScr.cs) {
         phong.sleep(100L);
         if (System.currentTimeMillis() - t2 > 10000L) break;
      }

      if (GameScr.cs) return; // trade vẫn mở sau timeout → không cất

      tradeCount++;
      Code.popup_chat("Đã nhận đồ (lần " + tradeCount + ")");

      if (CaiGom.autoCat) {
         isBusy = true;
         state = STATE_CAT;
      }
   }

   private void doCat() {
      if (TileMap.mapID != mapDich || TileMap.zoneID != zoneDich) {
         isBusy = false;
         state = STATE_MOVE;
         return;
      }
      if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
         isBusy = false;
         state = STATE_WAIT;
         return;
      }

      if (GameScr.npc_i(5) != null && (Math.abs(GameScr.npc_i(5).cx1 - Char.getMyChar().cx1) > 22
            || Math.abs(GameScr.npc_i(5).cy1 - Char.getMyChar().cy1) > 22)) {
         Char.move(GameScr.npc_i(5).cx1, GameScr.npc_i(5).cy1);
         return; // còn di chuyển → giữ isBusy=true
      }

      GameScr.gI().doOpenUI(4);
      int[] catIds = CaiGom.itemCatIds();
      int cat = 0;
      if (Code.solg_ruong() > 0) {
         Item[] bag = Char.getMyChar().arrItemBag;
         for (int i = 0; i < bag.length; i++) {
            Item it = bag[i];
            if (it == null) continue;
            if (catIds.length == 0 || matchId(it.template.id, catIds)) {
               Service.gI().e(it.indexUI);
               phong.sleep(10L);
               cat++;
            }
         }
      }

      phong.sleep(1000L);
      isBusy = false;
      state = STATE_WAIT;
   }

   private static boolean matchId(int id, int[] list) {
      for (int i = 0; i < list.length; i++) {
         if (list[i] == id) return true;
      }
      return false;
   }

   public String toString() {
      return "Auto gom (nhận)";
   }
}
