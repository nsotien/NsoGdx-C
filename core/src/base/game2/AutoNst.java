package base.game2;

// =====================================================================
// AutoNst — pha "di chuyen toi map+khu cai dat" cho lenh chat `nst`.
// Khi toi dung map+khu -> remode sang AutoTansat (ts/tsn).
//
// Chien luoc: goMap block multi-hop trong main tick thread se khien auto()
// khong chay lai -> dead-check khong kich hoat khi chet giua duong.
// => chay goMap trong 1 WORKER THREAD; auto() tick chinh chi:
//   - check dead moi tick, neu dead thi set TileMap.phong_ae=false
//     (ngat vong walk cua goMap) + hoisinh -> tick ke relaunch worker.
//   - kiem arrival, neu OK thi handoff ts/tsn.
// Plan: plan/PLAN_PORT_TGAME_BATCH2.md Muc 5 (port tu TGAME).
// =====================================================================
public final class AutoNst extends Auto {

   private boolean groupLeader;
   private boolean groupMember;
   private boolean needZoneMatch;
   private long    startedAt;

   private volatile Thread  worker;
   private volatile boolean workerBusy;
   private volatile boolean cancelWorker;
   private volatile boolean handedOff;

   public void start() {
      super.reset();

      this.map_auto = AutoMapKhu.cfgMapId == -1 ? TileMap.mapID : AutoMapKhu.cfgMapId;

      // Target khu de AutoNst travel toi. KHONG ghi vao Code.dck/arr_dck/index_dck
      // (state user). Override se duoc apply sau handoff qua AutoMapKhu.applyNstOverride().
      if (AutoMapKhu.cfgZones != null && AutoMapKhu.cfgZones.length > 1) {
         this.khu_auto = AutoMapKhu.cfgZones[0];
         this.needZoneMatch = true;
      } else if (AutoMapKhu.cfgZones != null && AutoMapKhu.cfgZones.length == 1 && AutoMapKhu.cfgZones[0] != -1) {
         this.khu_auto = AutoMapKhu.cfgZones[0];
         this.needZoneMatch = true;
      } else {
         this.khu_auto = TileMap.zoneID;
         this.needZoneMatch = false;
      }

      this.groupLeader = GameScr.vParty.size() > 0 && Auto.isLeader();
      this.groupMember = GameScr.vParty.size() > 0 && !this.groupLeader;
      this.startedAt = System.currentTimeMillis();
      this.handedOff = false;
   }

   private boolean isArrived() {
      return TileMap.mapID == this.map_auto
            && (!this.needZoneMatch || TileMap.zoneID == this.khu_auto);
   }

   private void cancelCurrentWorker(String reason) {
      if (this.worker != null && this.workerBusy) {
         this.cancelWorker = true;
         TileMap.phong_ae = false;
         try { this.worker.interrupt(); } catch (Throwable t) {}
      }
   }

   private void launchWorker() {
      if (this.workerBusy) return;
      this.cancelWorker = false;
      this.workerBusy = true;
      final int tMap = this.map_auto;
      final int tKhu = this.khu_auto;
      final boolean needZone = this.needZoneMatch;
      this.worker = new Thread(new Runnable() {
         public void run() {
            try {
               if (TileMap.mapID != tMap) {
                  try { TileMap.goMap(tMap); } catch (Throwable t) {
                  }
               }
               if (!cancelWorker && needZone && TileMap.mapID == tMap && TileMap.zoneID != tKhu) {
                  try { (new chuyenkhu(tKhu)).run(); } catch (Throwable t) {
                  }
               }
            } catch (Throwable t) {
            } finally {
               workerBusy = false;
            }
         }
      });
      this.worker.setDaemon(true);
      this.worker.start();
   }

   protected void auto() {
      if (this.handedOff) return;

      Char me = Char.getMyChar();
      if (me == null) return;

      boolean dead = Auto.check_dead(me);

      // 1. Dead -> ngat worker + hoisinh. Tick ke se relaunch worker khi song lai.
      if (dead) {
         this.cancelCurrentWorker("dead");
         if (TileMap.isTruong(TileMap.mapID) || TileMap.isLang(TileMap.mapID)) {
            Auto.hoisinh_public(false);
         } else {
            Auto.hoisinh_public(true);
         }
         return;
      }

      // 2. Da toi -> handoff.
      if (this.isArrived()) {
         this.cancelCurrentWorker("arrived");
         this.handedOff = true;

         if (this.groupMember) {
            Code.popup_chat("Chờ trưởng nhóm gọi (map " + this.map_auto + ")");
            Code.mode = null;
            return;
         }

         Code.mode = null;
         Code.run_ts(-1, this.map_auto);
         // Code.run_ts da reset override -> apply ngay sau de autoTansat
         // tick ke doc dung cau hinh cfgZones.
         AutoMapKhu.applyNstOverride();
         Code.autoTansat.khu_auto = this.needZoneMatch ? this.khu_auto : TileMap.zoneID;

         if (this.groupLeader) {
            Code.autoTansat.danh_nhom = true;
            Service.gI().j("ts " + Code.autoTansat.map_auto + " "
                  + Code.autoTansat.khu_auto + " " + Code.autoTansat.id);
            Code.popup_chat("Tàn sát nhóm map " + this.map_auto);
         } else {
            Code.popup_chat("Tàn sát map " + this.map_auto);
         }
         return;
      }

      // 3. Chua toi, chua chet -> dam bao co worker chay.
      if (!this.workerBusy) {
         this.launchWorker();
      }
   }

   public String toString() {
      return "Auto Nst -> map " + this.map_auto + (this.needZoneMatch ? (" khu " + this.khu_auto) : "");
   }
}
