package base.game1;

/**
 * Client utility — server list bootstrap (qua LicenseVerifier).
 *
 * Phase 5: bo loadChatFromMultipleLinks() — announcements gop chung vao response
 * cua LicenseVerifier.verify() (do Laravel tra kem 5 field text1/text2/text3/hdsd/banquyen).
 * Khong goi API rieng -> KHONG lo URL `apinst.nstmod.com` trong APK decompile.
 *
 * Con giu:
 *   - fakeStart() : nap server list tu LicenseVerifier.serverList sau khi verify
 *   - sendDataMessage()/startActive() : no-op stub giu tuong thich case 2024/2042001 trong GameCanvas
 *   - hdsdContent/banquyenContent : LicenseVerifier set sau verify OK
 */
public class Client {

   public static Client gI = new Client();
   public static String hdsdContent = null;
   public static String banquyenContent = null;
   // Phase 5 Task 7 — update notice (soft, hien popup truoc khi vao game neu version cu).
   // Set boi LicenseVerifier sau verify OK, KHONG sign rieng (RSA da ky toan response).
   public static String updateNoticeMsg  = null;
   public static String updateNoticeLink = null;

   /** Phase 5 Task 7 — action ID xu ly OK button cua popup update notice. */
   public static final int ACTION_UPDATE_OK = 7771;

   public static void fakeStart() {
      String text_sv;
      // F0e: gate that la LicenseGuard.ensureReady() (cross-check 4 state).
      // isVerified la decoy — patch isVerified=true khong qua duoc.
      if (com.monkey.nso.LicenseGuard.ensureReady()
              && com.monkey.nso.LicenseVerifier.serverList != null
              && !com.monkey.nso.LicenseVerifier.serverList.isEmpty()) {
         text_sv = com.monkey.nso.LicenseVerifier.serverList;
      } else {
         String errMsg = com.monkey.nso.LicenseVerifier.errorMessage;
         if (errMsg == null || errMsg.isEmpty()) errMsg = "Không thể xác thực. Vui lòng kiểm tra mạng.";
         try { com.monkey.nso.ClientErrorReporter.report("fakeStart", "LICENSE_GUARD_FAIL",
                 com.monkey.nso.ClientErrorReporter.ctx(
                         "user_message_shown", errMsg,
                         "is_verified", new Boolean(com.monkey.nso.LicenseVerifier.isVerified),
                         "server_list_empty", new Boolean(com.monkey.nso.LicenseVerifier.serverList == null || com.monkey.nso.LicenseVerifier.serverList.isEmpty()))); } catch (Throwable t) {}
         GameCanvas.l(errMsg);
         return;
      }

      // Phase 5 Task 7 — show update notice (soft, 1 nut OK) truoc khi vao game.
      // Khi user bam OK -> GameCanvas.a(ACTION_UPDATE_OK) -> continueAfterUpdateNotice() -> fakeStart() lai.
      if (updateNoticeMsg != null && updateNoticeMsg.length() > 0) {
         String full = updateNoticeMsg;
         if (updateNoticeLink != null && updateNoticeLink.length() > 0) {
            full = full + "\nLink: " + updateNoticeLink;
         }
         try { com.monkey.nso.ClientErrorReporter.report("fakeStart", "UPDATE_MISMATCH",
                 com.monkey.nso.ClientErrorReporter.ctx(
                         "user_message_shown", full,
                         "update_link", updateNoticeLink == null ? "" : updateNoticeLink)); } catch (Throwable t) {}
         GameCanvas.l(full, new Command1("OK", GameCanvas.instance, ACTION_UPDATE_OK, null));
         return;
      }

      // Phase 5: announcements da duoc LicenseVerifier.verify() set tu response.
      // Khong goi API rieng -> KHONG lo URL trong APK decompile.

      NewScr.text4 = "";
      GameCanvas.aj = null;

      try {
         String[] var6 = Code.split_string(text_sv, ",");
         GameMidlet.l = new String[var6.length];
         GameMidlet.m = new String[var6.length];
         GameMidlet.n = new short[var6.length];
         GameMidlet.o = new byte[var6.length];
         GameMidlet.q = new int[var6.length];
         GameMidlet.language = new byte[var6.length];

         // P3D N2 lazy: ho tro CA 2 format
         //   - Format cu (5 field): "Name:IP:Port:Type:Lang" — backward compat truoc Phase 3D Worker upgrade
         //   - Format moi (2 field): "id:Name" — IP/Port lazy fetch qua LicenseVerifier.fetchServer
         for (int var3 = 0; var3 < var6.length; ++var3) {
            String[] var4 = Code.split_string(var6[var3].trim(), ":");
            if (var4.length >= 4) {
               // Old full format
               GameMidlet.l[var3] = var4[0];
               GameMidlet.m[var3] = var4[1];
               GameMidlet.n[var3] = Short.parseShort(var4[2]);
               GameMidlet.o[var3] = Byte.parseByte(var4[3]);
               GameMidlet.language[var3] = (var4.length > 4) ? Byte.parseByte(var4[4]) : 0;
               GameMidlet.q[var3] = var3;
            } else if (var4.length == 2) {
               // P3D lazy: "id:name" — IP/port empty, populate when select
               GameMidlet.q[var3] = Integer.parseInt(var4[0]);
               GameMidlet.l[var3] = var4[1];
               GameMidlet.m[var3] = "";
               GameMidlet.n[var3] = 0;
               GameMidlet.o[var3] = 0;
               GameMidlet.language[var3] = 0;
            } else {
               // Format khong hop le, skip
               GameMidlet.l[var3] = "?";
               GameMidlet.m[var3] = "";
               GameMidlet.q[var3] = var3;
            }
         }

         GameMidlet.g();
         RMS.a();
         GameCanvas.b();
         GameCanvas.ag.a();
      } catch (Exception var4) {
         try { com.monkey.nso.ClientErrorReporter.reportException("fakeStart", "SERVER_LIST_PARSE_FAIL", var4,
                 com.monkey.nso.ClientErrorReporter.ctx("server_list_preview", text_sv == null ? "" : (text_sv.length() > 200 ? text_sv.substring(0, 200) : text_sv))); } catch (Throwable t) {}
         GameCanvas.l("Lỗi load danh sách server " + var4.getMessage());
      }
   }

   /**
    * P3D N2 lazy: dam bao server[idx] da co IP/Port truoc khi connect.
    * Goi tu SelectServerScr.applyServer + LoginScr pre-select. Block call (HTTP fetch).
    * Tra true neu OK, false neu fetch fail.
    */
   public static boolean ensureServerLoaded(int idx) {
      if (idx < 0 || GameMidlet.m == null || idx >= GameMidlet.m.length) return false;
      String ip = GameMidlet.m[idx];
      if (ip != null && !ip.isEmpty()) return true; // da loaded
      int sid = (GameMidlet.q != null && idx < GameMidlet.q.length) ? GameMidlet.q[idx] : idx;
      String detail = com.monkey.nso.LicenseVerifier.fetchServer(sid);
      if (detail == null || detail.isEmpty()) return false;
      String[] var4 = Code.split_string(detail, ":");
      if (var4.length < 4) return false;
      try {
         GameMidlet.l[idx] = var4[0]; // refresh name (server might have renamed)
         GameMidlet.m[idx] = var4[1];
         GameMidlet.n[idx] = Short.parseShort(var4[2]);
         GameMidlet.o[idx] = Byte.parseByte(var4[3]);
         GameMidlet.language[idx] = (var4.length > 4) ? Byte.parseByte(var4[4]) : 0;
         return true;
      } catch (Exception e) {
         return false;
      } 
   }

   // [Phase 5 REMOVED] loadChatFromMultipleLinks() — gop vao response cua LicenseVerifier.verify()
   // text1/text2/text3/hdsd/banquyen do Laravel tra kem trong /api/v1/pb/verify -> Worker encrypt+ky -> game decrypt set qua LicenseVerifier.

   /** Phase 5 Task 7 — goi tu GameCanvas.a(ACTION_UPDATE_OK) sau khi user bam OK popup update notice. */
   public static void continueAfterUpdateNotice() {
      updateNoticeMsg  = null;
      updateNoticeLink = null;
      fakeStart();
   }

   public void sendDataMessage() {
   }

   public void startActive() {
   }
}
