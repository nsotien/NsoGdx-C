package base.game2;

public class AutoGom extends Auto {
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

      if (CaiGom.runningState < 0) {
         CaiGom.runningState = STATE_MOVEMAP;
         CaiGom.runningGdIdx = 0;
         CaiGom.runningStart = System.currentTimeMillis();
         CaiGom.runningFindRetry = 0;
         CaiGom.resetTradeFail();
      }
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
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
         this.remap(mapDich, zoneDich, -1, -1);
         return;
      }
      CaiGom.runningState = STATE_LAYRUONG;
      CaiGom.runningGdIdx = 0;
   }

   private void doLayRuong() {
      if (itemGDIds.length == 0) {
         CaiGom.runningState = STATE_FIND;
         return;
      }

      if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
         CaiGom.runningState = STATE_FIND;
         return;
      }

      if (CaiGom.runningGdIdx < itemGDIds.length) {
         int id = itemGDIds[CaiGom.runningGdIdx];
         CaiGom.runningGdIdx++;
         Code.addmode(new AutoLayDo(id));
         return;
      }

      CaiGom.runningState = STATE_FIND;
      CaiGom.runningGdIdx = 0;
   }

   private void doFind() {
      if (CaiGom.runningFindRetry == 0) CaiGom.runningStart = System.currentTimeMillis();

      if (receiverName == null || receiverName.trim().length() == 0) {
         Code.popup_chat("Auto gom: chưa cài tên người nhận");
         CaiGom.runningState = STATE_DONE;
         return;
      }

      Char rcv = phong.CharInMap(receiverName);
      if (rcv == null) {
         CaiGom.runningFindRetry++;
         if (CaiGom.runningFindRetry % 10 == 1) {
            Code.popup_chat("Không tìm thấy " + receiverName + " trong map, đợi...");
         }
         if (System.currentTimeMillis() - CaiGom.runningStart > 120000L) {
            Code.popup_chat("Auto gom: quá 2 phút không thấy " + receiverName + ", dừng");
            CaiGom.runningState = STATE_DONE;
         } else {
            phong.sleep(2000L);
         }
         return;
      }

      if (Math.abs(rcv.cx1 - Char.getMyChar().cx1) > 50
       || Math.abs(rcv.cy1 - Char.getMyChar().cy1) > 50) {
         Char.move(rcv.cx1, rcv.cy1);
         phong.sleep(300L);
         return;
      }

      CaiGom.runningState = STATE_TRADE;
      CaiGom.runningGdIdx = 0;
   }

   private void doTrade() {
      if (CaiGom.tradeFailCount >= 2) {
         CaiGom.runningState = STATE_DONE;
         doDone();
         return;
      }

      while (CaiGom.runningGdIdx < itemGDIds.length) {
         int id = itemGDIds[CaiGom.runningGdIdx];
         CaiGom.runningGdIdx++;
         if (Code.check_item(id)) {
            Code.addmode(new AutoGiaoDich(receiverName, id));
            return;
         }
      }
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
      Auto restore = CaiGom.runningModeTemp;
      CaiGom.runningModeTemp = null;
      Code.mode = restore;
   }

   public String toString() {
      return "Auto gom đồ";
   }
}
