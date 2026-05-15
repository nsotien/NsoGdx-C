package base.game2;

public final class NLWatchdog {

   public static boolean debugLog = false;
   public static long stuckThresholdMs = 60000L;
   public static long reloginGraceMs = 10000L;
   public static long egStuckThresholdMs = 8000L;

   private String tag;
   private int lastMapID = -1;
   private int lastZoneID = -1;
   private int lastHP = -1;
   private int lastX = -1;
   private int lastY = -1;
   private long lastProgressTime;
   private long lastTusatTime = 0L;
   private long lastDebugLogTime = 0L;
   private long egSetTime = 0L;
   private boolean lastEg = false;

   public NLWatchdog(String tag) {
      this.tag = tag;
      this.lastProgressTime = System.currentTimeMillis();
   }

   public void reset() {
      this.lastMapID = -1;
      this.lastZoneID = -1;
      this.lastHP = -1;
      this.lastX = -1;
      this.lastY = -1;
      this.lastProgressTime = System.currentTimeMillis();
      this.lastTusatTime = 0L;
      this.egSetTime = 0L;
      this.lastEg = false;
      log("reset");
   }

   public void tick() {
      Char me = Char.getMyChar();
      if (me == null) return;

      int mapID = TileMap.mapID;
      int zoneID = TileMap.zoneID;
      int hp = me.cHP;
      int x = me.cx1;
      int y = me.cy1;

      boolean progressed = false;
      if (mapID != this.lastMapID) progressed = true;
      else if (zoneID != this.lastZoneID) progressed = true;
      else if (hp != this.lastHP) progressed = true;
      else if (x != this.lastX) progressed = true;
      else if (y != this.lastY) progressed = true;

      long now = System.currentTimeMillis();

      boolean eg = Char.eg;
      if (eg && !this.lastEg) {
         this.egSetTime = now;
      } else if (!eg) {
         this.egSetTime = 0L;
      }
      this.lastEg = eg;

      if (eg && this.egSetTime != 0L && this.lastTusatTime == 0L) {
         long egMs = now - this.egSetTime;
         if (egMs >= egStuckThresholdMs) {
            log("EG-STUCK " + egMs + "ms map=" + mapID + " zone=" + zoneID + " hp=" + hp + " -> tusat_vdmq");
            this.lastTusatTime = now;
            this.lastProgressTime = now;
            this.egSetTime = 0L;
            try {
               Auto.tusat_vdmq_public();
            } catch (Throwable t) {
               log("tusat error: " + t);
            }
            return;
         }
      }

      if (progressed) {
         if (debugLog && this.lastMapID != -1) {
            log("progress map=" + this.lastMapID + ">" + mapID
               + " zone=" + this.lastZoneID + ">" + zoneID
               + " hp=" + this.lastHP + ">" + hp
               + " pos=(" + this.lastX + "," + this.lastY + ")>(" + x + "," + y + ")");
         }
         this.lastMapID = mapID;
         this.lastZoneID = zoneID;
         this.lastHP = hp;
         this.lastX = x;
         this.lastY = y;
         this.lastProgressTime = now;
         return;
      }

      long stuckMs = now - this.lastProgressTime;

      if (debugLog && now - this.lastDebugLogTime > 5000L) {
         this.lastDebugLogTime = now;
         log("idle " + stuckMs + "ms map=" + mapID + " zone=" + zoneID + " hp=" + hp + " pos=(" + x + "," + y + ")");
      }

      if (stuckMs >= stuckThresholdMs) {
         if (this.lastTusatTime == 0L) {
            log("STUCK " + stuckMs + "ms map=" + mapID + " zone=" + zoneID + " hp=" + hp + " -> tusat_vdmq");
            this.lastTusatTime = now;
            try {
               Auto.tusat_vdmq_public();
            } catch (Throwable t) {
               log("tusat error: " + t);
            }
            this.lastProgressTime = now;
         } else if (now - this.lastTusatTime >= reloginGraceMs) {
            log("STILL STUCK after tusat -> scheduleRelogin");
            this.lastTusatTime = 0L;
            this.lastProgressTime = now;
            try {
               phong.scheduleRelogin();
            } catch (Throwable t) {
               log("relogin error: " + t);
            }
         }
      }
   }

   private void log(String s) {
      
   }
}
