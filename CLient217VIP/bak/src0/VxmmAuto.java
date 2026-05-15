public final class VxmmAuto extends Auto {
   public static int configXu;
   private byte gp;
   private long lastEndMs;
   private int lastRemain;
   private boolean placed;
   private long lastPlaceMs;
   private long lastOpenMs;

   public VxmmAuto(short id) {
      super.fieldAD();
      this.gp = (byte)(id == 100 ? 1 : 0);
      this.lastEndMs = 0L;
      this.lastRemain = 0;
      this.placed = false;
      this.lastPlaceMs = 0L;
      this.lastOpenMs = 0L;
   }

   public static void setXu(int xu) {
      configXu = xu;
   }

   private boolean ready(int remain) {
      if (configXu <= 0) {
         GameCanvas.setText("VXMM: Chưa cấu hình xu");
         return false;
      } else if (Char.getMyChar().xu < configXu) {
         GameCanvas.setText("VXMM: Không đủ xu để đặt");
         return false;
      } else {
         return remain <= 0 ? false : !this.placed;
      }
   }

   protected final void fieldAA() {
      if (Auto.fieldAF()) {
         Auto.fieldAA(true);
      } else {
         long now = System.currentTimeMillis();
         if ((this.lastOpenMs == 0L || GameScr.gameGP != this.gp) && now - this.lastOpenMs > 500L) {
            Service.gI().luckyDraw((short)102, "", this.gp);
            this.lastOpenMs = now;
         }

         long endMs = GameScr.gameLW();
         int remain = GameScr.gameLV();
         if (endMs - this.lastEndMs > 3000L || remain > this.lastRemain + 3) {
            this.lastEndMs = endMs;
            this.placed = false;
         }

         this.lastRemain = remain;
         if (!this.placed && now - this.lastPlaceMs > 4000L && this.ready(remain)) {
            try {
               Service.gI().luckyDraw((short)100, String.valueOf(configXu), this.gp);
               Auto.fieldAA(200L);
               Service.gI().luckyDraw((short)101, "", this.gp);
               Auto.fieldAA(200L);
               GameCanvas.setText("VXMM: Phiên mới, đặt xu=" + configXu + (this.gp == 1 ? " (VIP)" : " (Thường)"));
               this.placed = true;
               this.lastPlaceMs = now;
               this.lastEndMs = endMs;
            } catch (Exception var7) {
               GameCanvas.setText("VXMM: Lỗi đặt, thử lại sau");
            }
         }

         Auto.fieldAA(100L);
      }
   }

   public final String toString() {
      return "Auto VXMM";
   }
}
