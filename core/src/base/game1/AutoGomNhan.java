package base.game1;

// Acc nhận — port Class_ev của 148_lau:
// 1) remap đến map+zone; 2) đứng chờ trade + auto accept;
// 3) nếu CaiGom.autoCat=true → sau nhận xong cất items (theo ItemCat) vào rương,
//    rồi quay lại đợi trade tiếp.
// KHÔNG tự-exit; user tự `.agom` khi dừng.
public class AutoGomNhan extends Auto {
   private static final int STATE_MOVE = 0;
   private static final int STATE_WAIT = 1;
   private static final int STATE_CAT  = 2;

   private final int mapDich;
   private final int zoneDich;
   private int state = STATE_MOVE;
   private int tradeCount = 0;
   // Khóa Controller không auto-accept trade mới trong lúc đang STATE_CAT.
   // Set = true cùng lúc với state=STATE_CAT (không đợi vào doCat()) để bít gap giữa 2 frame.
   public volatile boolean isBusy = false;

   public AutoGomNhan(int map, int zone) {
      super.reset();
      this.mapDich = map;
      this.zoneDich = zone;
      this.map_auto = map;
      this.khu_auto = zone;
      if (DebugLog.DEBUG) ;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         if (DebugLog.DEBUG) ;
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
         if (DebugLog.DEBUG) ;
         this.remap(mapDich, zoneDich, -1, -1);
         return;
      }
      if (DebugLog.DEBUG) ;
      state = STATE_WAIT;
   }

   private void doWait() {
      if (TileMap.mapID != mapDich || TileMap.zoneID != zoneDich) {
         if (DebugLog.DEBUG) ;
         state = STATE_MOVE;
         return;
      }
      if (!GameScr.cs) {
         return;
      }

      if (DebugLog.DEBUG) ;

      GameScr.gI().dj = 0;
      GameScr.cc = new Item[12];
      Service.gI().a((int) 0, (Item[]) GameScr.cc);
      GameScr.gI().dh = 1;

      long t0 = System.currentTimeMillis();
      while (GameScr.gI().di != 1) {
         phong.sleep(100L);
         if (!GameScr.cs) {
            if (DebugLog.DEBUG) ;
            return;
         }
         if (System.currentTimeMillis() - t0 > 10000L) {
            if (DebugLog.DEBUG) ;
            return;
         }
      }

      long t1 = System.currentTimeMillis();
      while (System.currentTimeMillis() - t1 < 2000L) {
         phong.sleep(100L);
         if (!GameScr.cs) {
            if (DebugLog.DEBUG) ;
            return;
         }
      }

      Service.gI().j();
      GameScr.gI().dh = 2;
      if (DebugLog.DEBUG) ;

      long t2 = System.currentTimeMillis();
      while (GameScr.cs) {
         phong.sleep(100L);
         if (System.currentTimeMillis() - t2 > 10000L) {
            if (DebugLog.DEBUG) ;
            break;
         }
      }

      // Trade vẫn chưa đóng sau timeout → không cất, tránh conflict rương vs trade UI.
      if (GameScr.cs) {
         if (DebugLog.DEBUG) ;
         return;
      }

      tradeCount++;
      Code.popup_chat("Đã nhận đồ (lần " + tradeCount + ")");
      if (DebugLog.DEBUG) ;

      if (CaiGom.autoCat) {
         // Khóa ngay cùng frame với state đổi — không để gap frame kế bị xen trade mới.
         isBusy = true;
         state = STATE_CAT;
         if (DebugLog.DEBUG) ;
      }
   }

   private void doCat() {
      if (TileMap.mapID != mapDich || TileMap.zoneID != zoneDich) {
         if (DebugLog.DEBUG) ;
         isBusy = false;
         state = STATE_MOVE;
         return;
      }
      if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
         if (DebugLog.DEBUG) ;
         isBusy = false;
         state = STATE_WAIT;
         return;
      }

      if (GameScr.npc_i(5) != null && (Math.abs(GameScr.npc_i(5).cx1 - Char.getMyChar().cx1) > 22
            || Math.abs(GameScr.npc_i(5).cy1 - Char.getMyChar().cy1) > 22)) {
         if (DebugLog.DEBUG) ;
         Char.move(GameScr.npc_i(5).cx1, GameScr.npc_i(5).cy1);
         return; // còn di chuyển → giữ isBusy=true, quay lại frame sau
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

      if (DebugLog.DEBUG) ;
      phong.sleep(1000L);
      isBusy = false; // cất xong mới unlock → Controller bắt đầu accept trade tiếp
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
