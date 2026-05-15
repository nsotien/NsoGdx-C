package base.game1;

public class AutoGiaoDich extends Auto {
   private String ingame;
   private int idvp;
   private long lastmoi;
   private long lastTradeEnd = 0;
   private static final long GOM_TRADE_CLOSE_TIMEOUT = 15000L;
   private static final long POST_TRADE_DELAY = 0L;

   public AutoGiaoDich(String ig, int id) {
      super.reset();
      this.ingame = ig;
      this.idvp = id;
   }

   public AutoGiaoDich(String ig) {
      super.reset();
      this.ingame = ig;
      this.idvp = -1;
      if (DebugLog.DEBUG) ;
   }

   private boolean hasAnyUnlocked() {
      Item[] bag = Char.getMyChar().arrItemBag;
      for (int i = 0; i < bag.length; ++i) {
         if (bag[i] != null && !bag[i].isLock) return true;
      }
      return false;
   }

   private int countUnlocked() {
      Item[] bag = Char.getMyChar().arrItemBag;
      int n = 0;
      for (int i = 0; i < bag.length; ++i) {
         if (bag[i] != null && !bag[i].isLock) ++n;
      }
      return n;
   }

   private int countTradeableById(int id) {
      Item[] bag = Char.getMyChar().arrItemBag;
      int n = 0;
      for (int i = 0; i < bag.length; ++i) {
         Item it = bag[i];
         if (it != null && !it.isLock && it.template.id == id) {
            if (it.template.isUpToUp) n += it.quantity;
            else ++n;
         }
      }
      return n;
   }

   private int countTradeItems(Item[] items) {
      int n = 0;
      if (items == null) return 0;
      for (int i = 0; i < items.length; ++i) {
         if (items[i] != null) ++n;
      }
      return n;
   }

   private boolean isGomTrade() {
      return this.mode_temp instanceof AutoGom && this.idvp != -1;
   }

   private void reportGomTrade(boolean ok, String reason, int sentCount) {
      if (!isGomTrade()) return;
      CaiGom.lastTradeId = this.idvp;
      CaiGom.lastTradeCount = sentCount;
      if (ok) {
         CaiGom.tradeFailCount = 0;
         if (DebugLog.DEBUG) ;
      } else {
         ++CaiGom.tradeFailCount;
         if (CaiGom.runningGdIdx > 0) --CaiGom.runningGdIdx;
         if (DebugLog.DEBUG) ;
      }
   }

   private void stopGomTradeFail(String reason, int sentCount, boolean closeTrade) {
      reportGomTrade(false, reason, sentCount);
      if (closeTrade && GameScr.cs) {
         GameScr.gI().v();
      }
      Code.mode = null;
   }

   public Item[] getItemTrade(int amount, int idvp) {
      Item[] var0 = Char.getMyChar().arrItemBag;
      Item[] var1 = new Item[12];
      int index = 0;

      for(int var2 = 0; var2 < var0.length; ++var2) {
         if (var0[var2] != null && !var0[var2].isLock && amount > 0
               && (idvp == -1 || var0[var2].template.id == idvp)) {
            var1[index++] = var0[var2];
            --amount;
         }
      }

      return var1;
   }

   protected void auto() {
      boolean gomTrade = isGomTrade();
      boolean hasItem = this.idvp == -1 ? this.hasAnyUnlocked() : this.countTradeableById(this.idvp) > 0;
      if (check_dead(Char.getMyChar())) {
         hoisinh(false);
      } else if (hasItem) {
         Item[] class_byArr = new Item[12];
         Char local;
         if ((local = phong.CharInMap(this.ingame)) != null) {
            if (Math.abs(local.cx1 - Char.getMyChar().cx1) <= 50 && Math.abs(local.cy1 - Char.getMyChar().cy1) <= 50) {
               if (System.currentTimeMillis() - this.lastmoi >= 500L
                     && (this.lastTradeEnd == 0 || System.currentTimeMillis() - this.lastTradeEnd >= POST_TRADE_DELAY)) {
                  Service.gI().s(local.idChar);
                  this.lastmoi = System.currentTimeMillis();
               }
            } else {
               Char.move(local.cx1, local.cy1);
            }
         }

         if (GameScr.cs) {
            int total = this.idvp == -1 ? this.countUnlocked() : this.countTradeableById(this.idvp);
            int xxx = total >= 12 ? 12 : total;
            if (DebugLog.DEBUG && this.idvp == -1) ;
            GameScr.gI().dj = 0;
            class_byArr = this.getItemTrade(xxx, this.idvp);
            int sentCount = countTradeItems(class_byArr);
            if (sentCount <= 0) {
               if (gomTrade) Code.mode = null;
               return;
            }
            GameScr.cc = class_byArr;
            Service.gI().a((int)0, (Item[])GameScr.cc);
            GameScr.gI().dh = 1;
            long ll = System.currentTimeMillis();

            while(System.currentTimeMillis() - ll < 300L) {
               phong.sleep(100L);
               if (!GameScr.cs) {
                  if (gomTrade) stopGomTradeFail("trade closed before confirm", sentCount, false);
                  return;
               }
            }

            Service.gI().j();
            GameScr.gI().dh = 1;

            if (!gomTrade) {
               for(int var0 = 0; var0 < 12; ++var0) {
                  if (class_byArr[var0] != null) {
                     int var10001 = class_byArr[var0].indexUI;
                     Char.getMyChar().arrItemBag[var10001] = null;
                  }
               }
            }

            if (gomTrade) {
               ll = System.currentTimeMillis();
               while(GameScr.cs && System.currentTimeMillis() - ll < GOM_TRADE_CLOSE_TIMEOUT) {
                  phong.sleep(200L);
               }
               if (GameScr.cs) {
                  stopGomTradeFail("timeout waiting close", sentCount, true);
                  return;
               }
               // Trade đóng bình thường (không timeout) = thành công.
               // Không check di: di bị reset về 0 ngay khi cs=false (GameScr.reset()).
               for(int var0 = 0; var0 < 12; ++var0) {
                  if (class_byArr[var0] != null) {
                     int var10001 = class_byArr[var0].indexUI;
                     Char.getMyChar().arrItemBag[var10001] = null;
                  }
               }
               reportGomTrade(true, "closed", sentCount);
               this.lastTradeEnd = System.currentTimeMillis();
               if (DebugLog.DEBUG) ;
            } else {
               while(GameScr.cs) {
                  phong.sleep(200L);
               }
            }
         }
      } else {
         if (DebugLog.DEBUG && this.idvp == -1) ;
         Code.popup_chat("Đã giao dịch hết vp");
         Code.mode = null;
      }

   }

   public String toString() {
      if (this.idvp == -1) return "Auto GD tất cả VP không khóa/" + this.ingame;
      return "Auto giao dịch: " + this.idvp + "/" + this.ingame;
   }

}
