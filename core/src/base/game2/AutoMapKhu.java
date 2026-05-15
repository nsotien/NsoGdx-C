package base.game2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

// =====================================================================
// AutoMapKhu — bang cai map + khu up cua nick (luu RMS).
// Sau nay can ve map up hay goi toi AutoMapKhu.goToConfig()
// Port tu TGAME, plan: plan/PLAN_PORT_TGAME_BATCH2.md Muc 5.
// =====================================================================
public final class AutoMapKhu {
   public static int cfgMapId = -1;
   public static int[] cfgZones = new int[]{-1};
   public static boolean configured = true;
   public static boolean showUpInfo = RMS.c("isShow") == 1;

   // =====================================================================
   // Override layer — chi active khi nst duoc trigger + handoff sang
   // autoTansat. KHONG dung state user (Char.chuyenmap, Code.dck,
   // Code.arr_dck, Code.index_dck). Auto.java + Code.run_ts doc qua
   // cac getter ben duoi.
   // Code.run_ts reset override -> moi khi user chat "ts"/"tsn" truc tiep
   // se tu dong ve behavior user tick.
   // =====================================================================
   public static boolean nstOverrideActive   = false;
   public static boolean nstForceChuyenmap   = false;
   public static boolean nstBlockChuyenmap   = false;
   public static boolean nstOverrideDck      = false;
   public static int[]   nstZones            = new int[]{-1};
   public static int     nstIndexDck         = 0;

   // Override chi apply khi Code.mode la AutoTansat (tuc sau handoff tu AutoNst).
   // Neu user chuyen sang auto khac (AutoNv10, AutoDanhVong, AutoTaThu, ...),
   // cac auto do van doc Char.chuyenmap / Code.dck / arr_dck / index_dck goc
   // cua user, khong bi override cua nst anh huong nham.
   private static boolean overrideApplies() {
      return nstOverrideActive && (Code.mode instanceof AutoTansat);
   }

   public static boolean effectiveChuyenmap() {
      if (overrideApplies()) {
         if (nstForceChuyenmap) return true;
         if (nstBlockChuyenmap) return false;
      }
      return Char.chuyenmap;
   }

   public static boolean effectiveDck() {
      if (overrideApplies() && nstOverrideDck) return true;
      return Code.dck;
   }

   public static int[] effectiveArrDck() {
      if (overrideApplies() && nstOverrideDck) return nstZones;
      return Code.arr_dck;
   }

   public static int effectiveIndexDck() {
      if (overrideApplies() && nstOverrideDck) return nstIndexDck;
      return Code.index_dck;
   }

   public static void setEffectiveIndexDck(int v) {
      if (overrideApplies() && nstOverrideDck) nstIndexDck = v;
      else Code.index_dck = v;
   }

   // Goi boi AutoNst sau khi da handoff autoTansat (xem AutoNst.auto()).
   // Cau hinh override theo cfgZones:
   //   - cfgZones = {-1}             -> khong override, dung state user
   //   - cfgZones = {K} (1 khu)      -> block chuyenmap (ep off)
   //   - cfgZones = {K1,K2,...}      -> force chuyenmap + dck cycle nstZones
   public static void applyNstOverride() {
      int[] z = cfgZones;
      if (z == null || z.length == 0 || (z.length == 1 && z[0] == -1)) {
         resetNstOverride();
         return;
      }
      nstOverrideActive = true;
      if (z.length == 1) {
         nstForceChuyenmap = false;
         nstBlockChuyenmap = true;
         nstOverrideDck    = false;
         nstZones          = new int[]{-1};
         nstIndexDck       = 0;
      } else {
         nstForceChuyenmap = true;
         nstBlockChuyenmap = false;
         nstOverrideDck    = true;
         nstZones          = z;
         nstIndexDck       = 0;
      }
   }

   public static void resetNstOverride() {
      nstOverrideActive = false;
      nstForceChuyenmap = false;
      nstBlockChuyenmap = false;
      nstOverrideDck    = false;
      nstZones          = new int[]{-1};
      nstIndexDck       = 0;
   }

   public static boolean setConfig(int mapId, int[] zones, boolean show) {
      if (mapId != -1 && !isValidMapId(mapId)) {
         return false;
      }
      if (zones == null || zones.length == 0) {
         zones = new int[]{-1};
      }
      cfgMapId = mapId;
      cfgZones = zones;
      showUpInfo = show;
      configured = true;
      save();
      return true;
   }

   private static void save() {
      try {
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         DataOutputStream out = new DataOutputStream(baos);
         out.writeInt(cfgMapId);
         out.writeInt(cfgZones.length);
         for (int i = 0; i < cfgZones.length; i++) {
            out.writeInt(cfgZones[i]);
         }
         out.writeBoolean(showUpInfo);
         out.flush();
         RMS.a("SettingCaiUp", baos.toByteArray());
         RMS.a("isShow", showUpInfo ? 1 : -1);
         out.close();
         baos.close();
      } catch (Exception e) {
      }
   }

   public static void load() {
      byte[] b = RMS.a("SettingCaiUp");
      if (b == null) {
         return;
      }
      try {
         ByteArrayInputStream bais = new ByteArrayInputStream(b);
         DataInputStream in = new DataInputStream(bais);
         cfgMapId = in.readInt();
         int n = in.readInt();
         if (n < 0 || n > 64) {
            return;
         }
         cfgZones = new int[n];
         for (int i = 0; i < n; i++) {
            cfgZones[i] = in.readInt();
         }
         showUpInfo = in.readBoolean();
         configured = true;
         in.close();
         bais.close();
      } catch (Exception e) {
      }
   }

   public static void activate() {
      if (!configured) {
         Code.popup_chat("Chua cai Cai up, vao Menu vip -> Cai up");
         return;
      }
      if (cfgMapId != -1 && !isValidMapId(cfgMapId)) {
         Code.popup_chat("ID map Cai up khong hop le");
         return;
      }
      if (Code.giuKetNoi) {
         Code.giuKetNoi = false;
         Code.popup_chat("Tat auto giu ket noi");
      }

      AutoNst an = new AutoNst();
      an.start();
      Code.mode = an;
   }

   public static void goToConfig() {
      if (!configured) {
         return;
      }
      AutoNst an = new AutoNst();
      an.start();
      Code.mode = an;
   }

   public static boolean atConfigLocation() {
      if (!configured) {
         return false;
      }
      if (cfgMapId != -1 && cfgMapId != TileMap.mapID) {
         return false;
      }
      if (cfgZones.length == 1 && cfgZones[0] != -1 && cfgZones[0] != TileMap.zoneID) {
         return false;
      }
      return true;
   }

   public static int[] parseZones(String raw) {
      if (raw == null) {
         return new int[]{-1};
      }
      String s = raw.trim();
      if (s.length() == 0) {
         return new int[]{-1};
      }
      String[] parts = Code.split_string(s, ",");
      int[] result = new int[parts.length];
      for (int i = 0; i < parts.length; i++) {
         result[i] = Integer.parseInt(parts[i].trim());
      }
      return result;
   }

   public static boolean isValidMapId(int mapId) {
      return TileMap.u != null && mapId >= 0 && mapId < TileMap.u.length;
   }
}
