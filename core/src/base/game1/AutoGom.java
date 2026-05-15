package base.game1;

// State machine RESUMABLE — state được lưu trong CaiGom.runningState/runningGdIdx
// vì addmode(AutoLayDo/AutoGiaoDich) thay thế mode; khi Auto con xong set mode=null,
// scheduler tại Code.run() sẽ tạo lại AutoGom và load state từ CaiGom.
public class AutoGom extends Auto {
   // Thứ tự bám Class_fk.Class_ad của 148_lau: di chuyển đến map đích TRƯỚC, mới mở rương lấy đồ tại đó.
   public static final int STATE_MOVEMAP = 0;
   public static final int STATE_LAYRUONG = 1;
   public static final int STATE_FIND = 2;
   public static final int STATE_TRADE = 3;
   public static final int STATE_DONE = 4;

   private final int mapDich;
   private final int zoneDich;
   private final String receiverName;
   private final int[] itemGDIds;

   public AutoGom(int map, int zone, String receiver, int[] gdIds) {
      super.reset();
      this.mapDich = map;
      this.zoneDich = zone;
      this.receiverName = receiver;
      this.itemGDIds = gdIds == null ? new int[0] : gdIds;

      // init state nếu lần đầu; resume nếu đã đang chạy
      if (CaiGom.runningState < 0) {
         CaiGom.runningState = STATE_MOVEMAP;
         CaiGom.runningGdIdx = 0;
         CaiGom.runningStart = System.currentTimeMillis();
         CaiGom.runningFindRetry = 0;
         CaiGom.resetTradeFail();
         if (DebugLog.DEBUG) ;
      } else {
         if (DebugLog.DEBUG) ;
      }
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         if (DebugLog.DEBUG) ;
         hoisinh(false);
         return;
      }

      switch (CaiGom.runningState) {
         case STATE_MOVEMAP:  doMoveMap();  break;
         case STATE_LAYRUONG: doLayRuong(); break;
         case STATE_FIND:     doFind();     break;
         case STATE_TRADE:    doTrade();    break;
         case STATE_DONE:
         default:             doDone();     break;
      }
   }

   private void doMoveMap() {
      if (TileMap.mapID != mapDich || TileMap.zoneID != zoneDich) {
         if (DebugLog.DEBUG) ;
         this.remap(mapDich, zoneDich, -1, -1);
         return;
      }
      if (DebugLog.DEBUG) ;
      CaiGom.runningState = STATE_LAYRUONG;
      CaiGom.runningGdIdx = 0;
   }

   private void doLayRuong() {
      if (itemGDIds.length == 0) {
         if (DebugLog.DEBUG) ;
         CaiGom.runningState = STATE_FIND;
         return;
      }

      if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
         // Map đích không phải làng/trường → không mở rương được, bỏ qua bước lấy rương.
         // Bám 148_lau: nó check cùng map+zone rồi mới lấy; nếu map không có NPC rương thì bỏ qua là hợp lý.
         if (DebugLog.DEBUG) ;
         CaiGom.runningState = STATE_FIND;
         return;
      }

      if (CaiGom.runningGdIdx < itemGDIds.length) {
         int id = itemGDIds[CaiGom.runningGdIdx];
         int before = CaiGom.runningGdIdx;
         CaiGom.runningGdIdx++;
         if (DebugLog.DEBUG) ;
         Code.addmode(new AutoLayDo(id));
         return;
      }

      if (DebugLog.DEBUG) ;
      CaiGom.runningState = STATE_FIND;
      CaiGom.runningGdIdx = 0;
   }

   private void doFind() {
      // Reset đồng hồ khi lần đầu vào FIND (runningFindRetry=0), tránh MOVEMAP+LAYRUONG cắt bớt cửa sổ 2 phút.
      if (CaiGom.runningFindRetry == 0) CaiGom.runningStart = System.currentTimeMillis();

      if (receiverName == null || receiverName.trim().length() == 0) {
         Code.popup_chat("Auto gom: chưa cài tên người nhận");
         if (DebugLog.DEBUG) ;
         CaiGom.runningState = STATE_DONE;
         return;
      }

      Char rcv = phong.CharInMap(receiverName);
      if (rcv == null) {
         CaiGom.runningFindRetry++;
         if (CaiGom.runningFindRetry % 10 == 1) {
            Code.popup_chat("Không tìm thấy " + receiverName + " trong map, đợi...");
            if (DebugLog.DEBUG) ;
         }
         if (System.currentTimeMillis() - CaiGom.runningStart > 120000L) {
            Code.popup_chat("Auto gom: quá 2 phút không thấy " + receiverName + ", dừng");
            if (DebugLog.DEBUG) ;
            CaiGom.runningState = STATE_DONE;
         } else {
            phong.sleep(2000L);
         }
         return;
      }

      if (Math.abs(rcv.cx1 - Char.getMyChar().cx1) > 50
       || Math.abs(rcv.cy1 - Char.getMyChar().cy1) > 50) {
         if (DebugLog.DEBUG) ;
         Char.move(rcv.cx1, rcv.cy1);
         phong.sleep(300L);
         return;
      }

      if (DebugLog.DEBUG) ;
      CaiGom.runningState = STATE_TRADE;
      CaiGom.runningGdIdx = 0;
   }

   private void doTrade() {
      if (CaiGom.tradeFailCount >= 2) {
         if (DebugLog.DEBUG) ;
         CaiGom.runningState = STATE_DONE;
         doDone();
         return;
      }

      while (CaiGom.runningGdIdx < itemGDIds.length) {
         int id = itemGDIds[CaiGom.runningGdIdx];
         int curIdx = CaiGom.runningGdIdx;
         CaiGom.runningGdIdx++;
         if (Code.check_item(id)) {
            if (DebugLog.DEBUG) ;
            Code.addmode(new AutoGiaoDich(receiverName, id));
            return;
         } else {
            if (DebugLog.DEBUG) ;
         }
      }
      if (DebugLog.DEBUG) ;
      CaiGom.runningState = STATE_DONE;
   }

   private void doDone() {
      if (CaiGom.tradeFailCount >= 2) {
         Code.popup_chat("Auto gom: nick nhan khong nhan duoc do, dung");
      } else {
         Code.popup_chat("Auto gom xong");
      }
      CaiGom.runningState = -1;
      CaiGom.runningGdIdx = 0;
      CaiGom.runningFindRetry = 0;
      CaiGom.resetTradeFail();
      // Restore mode gốc (tàn sát/DV/...) — bám Class_fk.Class_ad của 148_lau (gọi Class_fd.Class_ai()).
      // CaiGom.runningModeTemp được set bởi scheduler trong Code.run() tại lúc trigger lần đầu.
      Auto restore = CaiGom.runningModeTemp;
      CaiGom.runningModeTemp = null;
      if (restore != null) {
         if (DebugLog.DEBUG) ;
         Code.mode = restore;
      } else {
         if (DebugLog.DEBUG) ;
         Code.mode = null;
      }
   }

   public String toString() {
      return "Auto gom đồ";
   }
}
