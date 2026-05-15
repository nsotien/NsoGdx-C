package base.game2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Display;
import base.game2.screen.ScreenManager;
import base.game2.screen.ScreenSettingSkill;

public class Code implements Runnable {
   // V8 bridge: NSO.render() uses Code.speedGame for frame timing
   public static int speedGame = 35;  // tốc độ game

   public static Code get_code = new Code();
   public static boolean isStart = false;
   private static Thread current;
   public static Auto mode;
   public static AutoTansat autoTansat = new AutoTansat();
   private static AutoPkam mode_pkam = new AutoPkam();
   public static boolean dck = false;
   public static int[] arr_dck = new int[0];
   public static int index_dck = 0;
   public static String ig_lead = null;
   private static long timemoinhom = 0L;
   public static MyVector listParty = new MyVector();
   // === Auto nhóm — master switch + role, persist qua RMS "autoPt" ===
   public static boolean autoPtOn = true;   // default BẬT
   public static int autoPtRole = 0;        // 0 = LEADER (mời), 1 = MEMBER (xin vào)
   public static boolean dcvt = RMS.c("phongdcvt") == 1;
   public static int index_dcvt = 0;
   public static MyVector[] x_dcvt = new MyVector[200];
   public static MyVector[] y_dcvt = new MyVector[200];
   public static int x_kts = 0;
   public static int y_kts = 0;
   public static int kcts = -1;
   private static long timeAutoUse = 0L;
   public static MyVector listItemAutoUse = new MyVector();
   public static boolean dongbang_skill = false;
   public static boolean dongbang_quai = false;
   public static boolean fake_cao;
   public static boolean fake_ngang;
   public static int cao;
   public static int ngang;
   public static boolean fakeSkill;
   public static int fakeSkillId;
   public static boolean pkam = RMS.c("Phongpkam") == 1;
   private static long bw;
   public static short[] arrItemNhat = new short[120];
   public static short[] arrItemDel = new short[120];
   public static int filterMode = 0;  // 0=tắt, 1=vứt, 2=bán, 3=5y/bán nhiều yên
   private static boolean filterReturnToSell = false;
   private static long filterReturnLastTime = 0L;
   // Plan FIX_2_BUG §5.1.1b: timeout safety net cho hold filter.
   // Nếu hold quá FILTER_HOLD_TIMEOUT_MS mà bag không giảm → break hold + log để debug.
   private static long filterHoldStartTime = 0L;
   private static int filterHoldStartFreeSlots = 0;
   private static final long FILTER_HOLD_TIMEOUT_MS = 30000L;
   public static boolean DEBUG_FILTER = false;
   // Smart filter dùng Char.lv_tbi (0=tắt, N=lọc trang bị dưới N option)
   public static boolean danhTheoID = false;
   public static int[] mobIDFilter = new int[]{0, 0, 0, 0, 0};

   public static int normalizeMobIDFilter(int var0) {
      return var0 > 0 ? var0 : -1;
   }

   public static boolean hasMobIDFilter() {
      for(int var0 = 0; var0 < mobIDFilter.length; ++var0) {
         if (mobIDFilter[var0] > 0) {
            return true;
         }
      }

      return false;
   }
   public static int kc_nhat = -1;
   // Port TGAME Hút VP: mặc định bật, chat "hutvp"/"nhatxa" để đổi mode
   public static boolean isHutVp = false;
   public static int hutvpRange = 100;
   public static long hutvpPickDelay = 25L;
   public static int hutvpMaxRetry = 1;
   public static long tdnm = 1500L;
   public static volatile boolean thaotacnhanh;
   public static volatile long lastManualMoveTime = 0L;
   public static final long MANUAL_MOVE_AUTO_GAP_MS = 600L;
   public static boolean show_dcvt = RMS.c("show_dcvt") == 1;
   private static AutoTuDanh aTuDanh = new AutoTuDanh();
   private static long bj;
   public static boolean isFakeRun = false;
   public static int fakeRun = 8;
   public static boolean hsl = RMS.c("hsl") == 1;
   public static boolean loc_nhom = RMS.c("loc_nhom") == 1;
   private static AutoBuff autoBuff = new AutoBuff();
   public static MyVector listItemTL = new MyVector();
   // Auto luyện ngọc — port từ NSOZ
   public static MyVector luyenngoc = new MyVector();
   private static long time_luyen_ngoc = 0L;
   public static boolean isCuuSat = RMS.c("isCuuSat") == 1;
   public static boolean autoDan = RMS.c("autoDan") == -1 ? false : RMS.c("autoDan") == 1;
   public static int hc_hlct = 0;
   private long time_ktg;
   private long time_hlct;
   public static boolean isApk = RMS.c("isApk") == 1;
   // === Auto đập đồ (port từ TGAME) ===
   public static boolean isADapDo;
   public static int CapDoValue = 7;
   public static int advCI = 5;
   public static int advCH = -1;
   public static boolean dapDoWaitingUnequip;
   private static long dapDoReturnLastTime = 0L;
   private static final long DAPDO_RETURN_COOLDOWN_MS = 60000L;
   static boolean dapDoHoldActive = false;
   static long    dapDoLastProgressTime = 0L;
   private static int     dapDoLastProgressSig  = 0;
   private static final long DAPDO_HOLD_TIMEOUT_MS = 30000L;
   public static long delay_tele = 50L;
   public static long time_tele_1 = 200L;
   public static AutoHangDong aDong = new AutoHangDong();
   static Auto_VPSK aVpsk = new Auto_VPSK();
   public static AutoDanhNguoi autoDanhNguoi = new AutoDanhNguoi();
   public static boolean isShowTL = RMS.c("isShowTL") == 1;
   private static AutoNVHN autoNVHN = new AutoNVHN();
   private static AutoTaThu autoTaThu = new AutoTaThu();
   private static AutoPK autoPK = new AutoPK();
   // Port TGAME: 2 auto mới bot chờ / đánh PK - dùng cùng toạ độ menu_pkam.x/y, khác khu
   private static AutoChoPK autoChoPK = new AutoChoPK();
   private static AutoDanhPK autoDanhPK = new AutoDanhPK();
   public static boolean advCA = false;        // Auto cat do flag
   private static AutoDanhVong advCO;          // DV instance
   public static AutoLoiWin advAG;             // Loi Win instance
   public static AutoLoiLoss advAH;            // Loi Loss instance
   public static int advCC = -1;                // Ngay cuoi cung da chay auto DV (-1 = chua chay)
   public static int nvhnCC = -1;               // Ngay cuoi cung da chay NVHN
   public static boolean isAutoNVHN = false;     // Bat/tat schedule NVHN
   public static int nvhnHour = -1;              // Gio chay NVHN (0-23, -1=tat)
   public static int nvhnMin = -1;               // Phut chay NVHN (0-59, -1=tat)

   // === Auto Mua Item Shop ===
   public static boolean autoMuaItem = false;
   public static int muaNpcTemplateID = -1;
   public static int muaNpcID = -1;
   public static int muaViTriItem = -1;
   public static int muaSoLan = 1;
   public static int muaItemID = 0;
   public static int muaDaMua = 0;
   private static long muaLastTime = 0;
   private static long muaCheckLastTime = 0;
   private static boolean muaChoMua = false;

   // === Auto NPC ===
   public static int autoNpcID = 0;
   public static int autoNpcMenu1 = 0;
   public static int autoNpcMenu2 = 0;
   private static volatile boolean autoNpcRunning = false;

   // === Auto On-Off ===
   public static boolean autoOnOff = false;
   public static int onoffOffHour = -1;
   public static int onoffOffMin = 0;
   public static int onoffOnHour = -1;
   public static int onoffOnMin = 0;

   // Tinh ngay "logic" theo gio cai dat: chua den gio → ngay-1, da qua gio → ngay hom nay
   public static int advCC_calcDay(int setHour, int setMin) {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.setTimeZone(java.util.TimeZone.getTimeZone("GMT+7"));
      if (setHour >= 0 && setMin >= 0) {
         int curHour = cal.get(java.util.Calendar.HOUR_OF_DAY);
         int curMin = cal.get(java.util.Calendar.MINUTE);
         if (setHour == 0) {
            return (curHour == 0 && curMin < setMin) ? cal.get(java.util.Calendar.DAY_OF_MONTH) - 1 : cal.get(java.util.Calendar.DAY_OF_MONTH);
         } else {
            return (curHour < setHour || (curHour == setHour && curMin < setMin)) ? cal.get(java.util.Calendar.DAY_OF_MONTH) - 1 : cal.get(java.util.Calendar.DAY_OF_MONTH);
         }
      }
      return cal.get(java.util.Calendar.DAY_OF_MONTH);
   }
   public static NhiemVu53 n53 = new NhiemVu53();
   public static NhiemVu55 n55 = new NhiemVu55();
   public static NhiemVu49 n49 = new NhiemVu49();
   public static int currentBG = 0;
   public static long speedLh = 50L;
   public static int countLh;
   public static boolean connect = RMS.c("nstconnect") == 1;
   public static volatile boolean giuKetNoi = false;
   public static int giuKetNoiMode = 0;  // 0=tại chỗ, 1=sang map
   static boolean GKN_LOG = false; 
   // Mode 0: tại chỗ
   static long lastSelectSkillKA = 0L;
   static long lastAttackKA = 0L;
   // Mode 1: sang map
   static long lastGknKeepAlive = 0L;
   private static int gknSavedMapID;
   private static int gknSavedZoneID;
   private static int gknSavedX;
   private static int gknSavedY;
   private static ChoPk bd;
   public static int khuPk = 5;
   public static int mapPk = 23;
   public static int khuChoPk = 6;
   public static int pkx;
   public static int pky;
   private static int perCx;
   private static int perCy;
   private static long lastTimeCheck;
   private static ChoPk choPk = new ChoPk();
   // VXMM bot
   public static boolean isAutoVxmm;
   public static int xuMin = 0;
   public static int xuMax = 0;

   // Port TGAME: nền đen toàn client, chỉ áp dụng cho Java Ngang / Java Dọc (typeClient != 0 = "Bản Đẹp")
   // Giá trị được cập nhật bởi NSO.create() sau khi đọc lockedTypeClient từ RMS
   public static boolean hideBackground = false;

   public static void popup_chat(String nd) {
      ChatPopup.a("[nsotien.com] " + nd, 0, Char.getMyChar()); // mod khách
   }

   public static void loadADapDoRMS() {
      try {
         byte[] b = RMS.loadRMS("chipADapDo");
         if (b == null) return;
         java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.ByteArrayInputStream(b));
         isADapDo   = dis.readBoolean();
         CapDoValue = dis.readInt();
         advCI      = dis.readInt();
         if (CapDoValue < 4 || CapDoValue > 16) CapDoValue = 7;
         if (advCI != 5 && advCI != 6) advCI = 5;
      } catch (Exception e) { RMS.deleteRMS("chipADapDo"); }
   }

   public static void saveADapDoRMS() {
      try {
         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
         java.io.DataOutputStream dos = new java.io.DataOutputStream(baos);
         dos.writeBoolean(isADapDo);
         dos.writeInt(CapDoValue);
         dos.writeInt(advCI);
         RMS.saveRMS("chipADapDo", baos.toByteArray());
      } catch (Exception e) {}
   }

   // Port TGAME: clear hiệu ứng skill đang chạy của bản thân + toàn bộ char trong map khi bật đóng băng
   public static void clearDongBangSkillEffects() {
      try {
         Char var0 = Char.getMyChar();
         if (var0 != null) {
            var0.clearSkillVisualOnly();
         }

         for (int var1 = 0; var1 < GameScr.vCharInMap.size(); ++var1) {
            Char var2 = (Char) GameScr.vCharInMap.elementAt(var1);
            if (var2 != null) {
               var2.clearSkillVisualOnly();
            }
         }
      } catch (Exception var3) {
      }
   }

   public static boolean isDongBangSkillEffective() {
      return dongbang_skill;
   }

   public static boolean isZoneNpc(Npc npc) {
      return npc != null && npc.npcTemplate != null && npc.npcTemplate.npcTemplateId == 13;
   }

   // Port TGAME: bay tới focus hiện tại theo thứ tự charFocus -> npcFocus -> mobFocus -> itemFocus
   public static boolean moveToCurrentFocus(boolean showPopup) {
      Char var0 = Char.getMyChar();
      if (var0 == null) {
         return false;
      }
      if (var0.charFocus != null) {
         if (Math.abs(var0.charFocus.cx1 - var0.cx1) <= 50
             && Math.abs(var0.charFocus.cy1 - var0.cy1) <= 50) {
            return true;
         }
         if (showPopup) {
            popup_chat("MoveTo " + var0.charFocus.cName);
         }
         Char.move(var0.charFocus.cx1, var0.charFocus.cy1);
         lastManualMoveTime = System.currentTimeMillis();
         return true;
      } else if (var0.npcFocus != null) {
         if (isZoneNpc(var0.npcFocus)) {
            return false;
         }
         if (showPopup) {
            popup_chat("MoveTo " + var0.npcFocus.cName);
         }
         Char.move(var0.npcFocus.cx1, var0.npcFocus.cy1);
         lastManualMoveTime = System.currentTimeMillis();
         return true;
      } else if (var0.mobFocus != null) {
         if (showPopup) {
            popup_chat("MoveTo " + var0.mobFocus.c().g);
         }
         Char.move(var0.mobFocus.i, var0.mobFocus.j);
         lastManualMoveTime = System.currentTimeMillis();
         return true;
      } else if (var0.itemFocus != null) {
         if (showPopup) {
            popup_chat("MoveTo " + var0.itemFocus.template.name);
         }
         Char.move(var0.itemFocus.x, var0.itemFocus.y);
         lastManualMoveTime = System.currentTimeMillis();
         return true;
      } else {
         return false;
      }
   }

   // VXMM - giao dịch xu cho bot
   public static void checkBot(String var0) {
      Char var1 = Char.getMyChar();
      Char var10 = phong.CharInMap(var0);

      if (var10 == null) {
         popup_chat("Bot " + var0 + " lỗi. Bỏ qua");
      } else {
         if (Math.abs(var1.cx1 - var10.cx1) > 50 || Math.abs(var1.cy1 - var10.cy1) > 50) {
            Char.move(var10.cx1, var10.cy1);
            phong.sleep(100L);
         }

         Service.gI().s(var10.idChar);
         long var5 = System.currentTimeMillis();

         while (!GameScr.cs) {
            if (System.currentTimeMillis() - var5 >= 2000L) {
               popup_chat("Bot " + var10.cName + " lỗi. Bỏ qua");
               return;
            }
            phong.sleep(100L);
         }

         int var11 = NinjaUtil.randomRange(Code.xuMin, Code.xuMax);
         GameScr.gI().dj = var11;
         GameScr.cc = new Item[12];
         Service.gI().a((int)var11, (Item[])GameScr.cc);
         GameScr.gI().dh = 1;
         long var8 = System.currentTimeMillis();

         while (GameScr.gI().di != 1) {
            if (System.currentTimeMillis() - var8 >= 2000L) {
               Service.gI().i();
               popup_chat("Bot " + var10.cName + " lỗi. Bỏ qua");
               return;
            }
            phong.sleep(100L);
         }

         Service.gI().j();
         var8 = System.currentTimeMillis();

         while (GameScr.gI().di != 2) {
            if (System.currentTimeMillis() - var8 >= 1000L) {
               Service.gI().i();
               return;
            }
            phong.sleep(100L);
         }
      }
   }

   static void gknLog(String msg) {
      if (GKN_LOG) ;
   }

   public static void gkn_resetTimers() {
      lastSelectSkillKA = 0L;
      lastAttackKA = 0L;
      lastGknKeepAlive = System.currentTimeMillis();
   }

   private static void gkn_openSetting() {
      ScreenManager.showOnGL(new Runnable() { public void run() {
         ScreenManager.show(new base.game2.screen.ScreenSettingGKN());
      } });
   }

   // === AUTO GIỮ KẾT NỐI v3 — dispatch theo mode ===
   private static void gkn_run() {
      if (giuKetNoiMode == 0) {
         gkn_taiCho();
      } else if (giuKetNoiMode == 1) {
         long now = System.currentTimeMillis();
         if (now - lastGknKeepAlive >= 600000L) {
            gkn_sangMap();
         }
      }
   }

   // Mode 0: Tại chỗ — port từ TOOL_VXMM Class_cg.a()
   private static void gkn_taiCho() {
      long nowKA = System.currentTimeMillis();

      // Tìm mob đầu tiên != null (giống Class_cg line 21-27)
      Mob mobKA = null;
      if (GameScr.vMob != null) {
         for (int i = 0; i < GameScr.vMob.size(); ++i) {
            Mob tmp = (Mob) GameScr.vMob.elementAt(i);
            if (tmp != null) {
               mobKA = tmp;
               break;
            }
         }
      }

      if (mobKA != null) {
         // Lấy chiêu 1x từ vSkillFight (giống Class_cg: player.vSkillFight)
         Skill skillFight = null;
         if (Char.getMyChar().vSkillFight != null && Char.getMyChar().vSkillFight.size() > 0) {
            skillFight = (Skill) Char.getMyChar().vSkillFight.elementAt(0);
         }
         if (skillFight == null) return;

         // selectSkill mỗi 60s (giống Class_cg line 32-36)
         if (nowKA - lastSelectSkillKA >= 60000L) {
            lastSelectSkillKA = nowKA;
            Service.gI().selectSkill(skillFight.template.id);
            gknLog("[GKN_TACHO] selectSkill(" + skillFight.template.id + ") name=" + skillFight.template.b);
         }

         // sendPlayerAttack mỗi cooldown+3s (giống Class_cg line 39-46)
         long atkInterval = (long) skillFight.coolDown + 3000L;
         if (nowKA - lastAttackKA >= atkInterval) {
            lastAttackKA = nowKA;
            MyVector vec = new MyVector();
            vec.addElement(mobKA);
            Service.gI().sendPlayerAttack(vec, new MyVector(), 1);
            gknLog("[GKN_TACHO] attack mob.m=" + mobKA.m + " cooldown=" + skillFight.coolDown + "ms interval=" + atkInterval + "ms");
         }
      }
   }

   // Mode 1: Sang map — đánh 1 con quái thật rồi quay về
   private static void gkn_sangMap() {
      long startTime = System.currentTimeMillis();

      // Bước 1: Lưu context
      gknSavedMapID = TileMap.mapID;
      gknSavedZoneID = TileMap.zoneID;
      gknSavedX = Char.getMyChar().cx1;
      gknSavedY = Char.getMyChar().cy1;
      gknLog("[GKN_MAP] === START === map=" + gknSavedMapID + " zone=" + gknSavedZoneID + " pos=(" + gknSavedX + "," + gknSavedY + ")");

      // Bước 2: Chuyển map trái (mapID - 1)
      int targetMap = gknSavedMapID - 1;
      if (targetMap < 0) {
         targetMap = gknSavedMapID + 1;
         gknLog("[GKN_MAP] mapID-1 < 0, thử mapID+1=" + targetMap);
      }

      long t1 = System.currentTimeMillis();
      if (!TileMap.goMap(targetMap)) {
         gknLog("[GKN_MAP] goMap(" + targetMap + ") FAIL, skip");
         lastGknKeepAlive = System.currentTimeMillis();
         return;
      }
      phong.sleep(500L);
      gknLog("[GKN_MAP] goMap(" + targetMap + ") done " + (System.currentTimeMillis() - t1) + "ms currentMap=" + TileMap.mapID);

      // Bước 3: Tìm mob + đánh
      {
         Mob mobGKN = null;
         if (GameScr.vMob != null) {
            for (int i = 0; i < GameScr.vMob.size(); ++i) {
               Mob tmp = (Mob) GameScr.vMob.elementAt(i);
               if (tmp != null && tmp.status != 0 && tmp.status != 1) {
                  mobGKN = tmp;
                  break;
               }
            }
         }

         if (mobGKN != null) {
            Skill sk = Char.getMyChar().myskill;
            if (sk != null) {
               Service.gI().selectSkill(sk.template.id);
               gknLog("[GKN_MAP] selectSkill(" + sk.template.id + ")");
            }
            Char.move(mobGKN.i, mobGKN.j);
            phong.sleep(500L);
            MyVector vec = new MyVector();
            vec.addElement(mobGKN);
            // Đánh 2 lần liên tiếp (phòng né)
            Service.gI().sendPlayerAttack(vec, new MyVector(), 1);
            gknLog("[GKN_MAP] attack #1 mob.m=" + mobGKN.m + " at (" + mobGKN.i + "," + mobGKN.j + ")");
            phong.sleep(500L);
            Service.gI().sendPlayerAttack(vec, new MyVector(), 1);
            gknLog("[GKN_MAP] attack #2 mob.m=" + mobGKN.m);
            phong.sleep(300L);
         } else {
            gknLog("[GKN_MAP] WARN no mob on map " + TileMap.mapID);
         }
      }

      // Bước 4: Chuyển về map cũ
      t1 = System.currentTimeMillis();
      if (!TileMap.goMap(gknSavedMapID)) {
         gknLog("[GKN_MAP] goMapBack(" + gknSavedMapID + ") FAIL");
      } else {
         phong.sleep(500L);
         gknLog("[GKN_MAP] goMapBack(" + gknSavedMapID + ") done " + (System.currentTimeMillis() - t1) + "ms");
      }

      // Bước 5: Chuyển khu nếu khác (dùng logic giống Auto.chuyenkhu1)
      if (TileMap.zoneID != gknSavedZoneID) {
         gknLog("[GKN_MAP] changeZone " + TileMap.zoneID + " -> " + gknSavedZoneID);
         int kdl;
         if ((kdl = Code.index_item(37)) == -1) {
            kdl = Code.index_item(35);
         }
         if (kdl == -1) {
            // Không có item chuyển khu, tìm NPC
            Npc npcCK = GameScr.npc_i(13);
            if (npcCK != null && npcCK.statusMe != 15) {
               if (Math.abs(npcCK.cx1 - Char.getMyChar().cx1) > 22 || Math.abs(npcCK.cy1 - Char.getMyChar().cy1) > 22) {
                  Char.move(npcCK.cx1, npcCK.cy1);
                  phong.sleep(100L);
               }
            } else {
               gknLog("[GKN_MAP] WARN no NPC & no item chuyenkhu, skip");
            }
         }
         int ckItem = kdl == -1 ? -1 : kdl;
         Service.gI().a(gknSavedZoneID, ckItem);
         TileMap.f2(3000L);
         // Retry khi khu đầy — spam tới khi vào được, không giới hạn
         int retryCount = 0;
         while (TileMap.zoneID != gknSavedZoneID) {
            retryCount++;
            if (GameCanvas.delaychuyenkhu > 0) {
               int cd = GameCanvas.delaychuyenkhu;
               GameCanvas.delaychuyenkhu = 0;
               gknLog("[GKN_MAP] changeZone retry " + retryCount + " sleep " + cd + "s (server cooldown)");
               phong.sleep((long)cd * 1000L);
            } else {
               gknLog("[GKN_MAP] changeZone retry " + retryCount + " sleep 3s");
               phong.sleep(3000L);
            }
            Service.gI().a(gknSavedZoneID, ckItem);
            TileMap.f2(3000L);
         }
         gknLog("[GKN_MAP] changeZone done, current=" + TileMap.zoneID + " retries=" + retryCount);
      }

      // Bước 6: Về vị trí cũ
      Char.move(gknSavedX, gknSavedY);
      gknLog("[GKN_MAP] moveTo(" + gknSavedX + "," + gknSavedY + ") done");

      // Bước 7: Reset timer
      lastGknKeepAlive = System.currentTimeMillis();
      gknLog("[GKN_MAP] === DONE === total=" + (System.currentTimeMillis() - startTime) + "ms");
   }

   public void stop() {
      isStart = false;
      if (current != null) {
         current.interrupt();
      }

   }

   public void start() {
      if (!isStart) {
         if (mode != null) {
            mode.resetAfterLogin();
         }

         // Fix C3: set lastChangeZone sau login → chờ 2-3s trước khi chuyển khu đầu tiên
         Auto.lastChangeZone = System.currentTimeMillis();

         isStart = true;
         base.game2.screen.ScreenSettingSkill.loadSettings();
         base.game2.screen.SetupNVHN.loadSettings();
         (current = new Thread(this)).start();
         this.time_ktg = System.currentTimeMillis();
         if (!NewScr.listText.isEmpty()) {
            Info.a("ADMIN: " + (String)NewScr.listText.firstElement(), 80, mFont.d);
         }
//         GameScr.gI().a("ADMIN", (String)NewScr.listText.elementAt(1), false);
      }

   }

   public static void addmode(Auto mo) {
      mo.mode_temp = mode;
      mode = mo;
   }

   public static void remode() {
      LockGame.advBK();  // cleanup locks truoc khi restore (giong source goc Class_fq.ak())
      mode = mode.mode_temp;
   }

   // Port TGAME: gom scheduler + chat "anv" ve chung entry; request tu sat ve truong truoc tien.
   public static void startAutoNVHN() {
      autoNVHN.a();
      autoNVHN.requestFastReturnOnStart();
      addmode(autoNVHN);
   }

   // Port TGAME: bật/tắt Bot chờ PK qua chat command hoặc CheckBox trong menu_pkam
   public static void toggleAutoChoPK() {
      if (mode instanceof AutoChoPK) {
         mode = null;
         popup_chat("Tắt auto chờ PK");
      } else {
         autoChoPK.runChoPK();
         addmode(autoChoPK);
         popup_chat("Bật auto chờ PK");
      }
   }

   // Port TGAME: bật/tắt Bot đánh PK qua chat command hoặc CheckBox trong menu_pkam
   public static void toggleAutoDanhPK() {
      if (mode instanceof AutoDanhPK) {
         mode = null;
         popup_chat("Tắt auto đánh PK");
      } else {
         autoDanhPK.runDanhPK();
         addmode(autoDanhPK);
         popup_chat("Bật auto đánh PK");
      }
   }

   public static void run_ts(int idquai, int map) {
      // Port TGAME Muc 5: moi khi user chat "ts"/"tsn" truc tiep -> reset override nst
      // de behavior quay ve dung state user (Char.chuyenmap, Code.dck, Code.arr_dck).
      AutoMapKhu.resetNstOverride();
      autoTansat.run(idquai, map, TileMap.zoneID);
      addmode(autoTansat);
   }

   // Gui group payload "ts <map> <khu> <id>" cho member trong nhom remap theo
   // ma KHONG local run_ts tren leader. Dung khi leader can giu mode rieng
   // (vd AutoDanhVong) nhung van muon keo nhom sang map/khu ho tro.
   public static void callGroupTsRemote(int map, int khu, int id) {
      Service.gI().j("ts " + map + " " + khu + " " + id);
   }

   private static void runBuff(boolean var0, boolean var1) {
      autoBuff.a(TileMap.mapID, TileMap.zoneID, var0, var1);
      addmode(autoBuff);
   }

   public static void a(byte var0, byte[] var1) {
      if (mode != null) {
         try {
            mode.a(var0);
            mode.a(var1);
            mode.g();
            return;
         } catch (Exception var3) {
         }
      }

   }

   public static boolean check_tinhluyen(Item var0) {
      return listItemTL.contains(var0);
   }

   public static void add_tinhluyen(Item var0) {
      if (!listItemTL.contains(var0)) {
         listItemTL.addElement(var0);
      }

   }

   public static void xoa_tinhluyen(Item var0) {
      listItemTL.removeElement(var0);
   }

   public static void update_tinhluyen() {
      Char var0 = Char.getMyChar();

      for(int var1 = 0; var1 < listItemTL.size(); ++var1) {
         Item var2;
         if ((var2 = (Item)listItemTL.elementAt(var1)).indexUI >= 0 && var2.indexUI < var0.arrItemBag.length) {
            if (var0.arrItemBag[var2.indexUI] != null && (var0.arrItemBag[var2.indexUI].lvTL() >= 0 && var0.arrItemBag[var2.indexUI].lvTL() < 9 || var0.arrItemBag[var2.indexUI].lvTL() == -1)) {
               listItemTL.setElementAt(var0.arrItemBag[var2.indexUI], var1);
            } else {
               listItemTL.removeElementAt(var1--);
            }
         }
      }

   }

   public static MyVector h(int var0) {
      Item[] var1 = Char.getMyChar().arrItemBag;
      MyVector var2 = new MyVector();

      for(int var3 = 0; var3 < var1.length; ++var3) {
         Item var4;
         if ((var4 = var1[var3]) != null && var4.template.id == var0) {
            var2.addElement(var4);
         }
      }

      return var2;
   }

   private static void tinhluyen() {
      if (listItemTL.size() > 0) {
         int[] var17 = new int[]{150000, 247500, 408375, 673819, 1111801, 2056832, 4010822, 7420021, 12243035};
         byte[] var8 = new byte[]{3, 5, 9, 4, 7, 10, 5, 7, 9};

         for(int var10 = 0; var10 < listItemTL.size(); ++var10) {
            Item var20;
            int var5 = (var20 = (Item)listItemTL.elementAt(var10)).lvTL();
            if (var5 == -1) {
               var20.y_tl = System.currentTimeMillis() - 1500L;
               var20.w_tl = true;
               Service.gI().c(3, var20.indexUI);
            } else if (var20.w_tl) {
               if (System.currentTimeMillis() - var20.y_tl > 2000L || var20.x_tl < var5) {
                  var20.w_tl = false;
               }
            } else if (var5 >= 0 && var5 < 9) {
               MyVector var11 = h(var5 < 3 ? 455 : (var5 < 6 ? 456 : 457));
               int var12 = var17[var5];
               byte var13 = var8[var5];
               if (Char.getMyChar().yen >= var12 && var11.size() >= var13) {
                  Item[] var23 = new Item[24];

                  for(var12 = 0; var12 < var13; ++var12) {
                     Item var14 = (Item)var11.elementAt(var11.size() - 1);
                     var23[var12] = var14;
                     Char.getMyChar().arrItemBag[var14.indexUI] = null;
                     var11.removeElementAt(var11.size() - 1);
                  }

                  Service.gI().a(var20, var23);
                  var20.w_tl = true;
                  var20.x_tl = var5;
                  var20.y_tl = System.currentTimeMillis();
                  var20.options.removeAllElements();
               }
            } else {
               listItemTL.removeElementAt(var10--);
            }
         }
      }

   }

   private static int check_thucan(int var0) {
      int var1 = 0;
      Char var2 = Char.getMyChar();

      for(int var3 = 0; var3 < var2.arrItemBag.length; ++var3) {
         Item var4;
         if ((var4 = var2.arrItemBag[var3]) != null && var4.template.type == 18 && var4.template.level == var0) {
            ++var1;
         }
      }

      return var1;
   }

   public static int solg_hanhtrang() {
      Item[] arr = Char.getMyChar().arrItemBag;
      int i1 = 0;

      for(int i2 = 0; i2 < arr.length; ++i2) {
         if (arr[i2] == null) {
            ++i1;
         }
      }

      return i1;
   }

   public static int solg_ruong() {
      Item[] arr = Char.getMyChar().arrItemBox;
      int i1 = 0;

      for(int i2 = 0; i2 < arr.length; ++i2) {
         if (arr[i2] == null) {
            ++i1;
         }
      }

      return i1;
   }

   public static boolean check_nhom1(String var0) {
      for(int var1 = 0; var1 < listParty.size(); ++var1) {
         if (var0.equals(listParty.elementAt(var1))) {
            return true;
         }
      }

      return false;
   }

   public static boolean check_nhom2(String var0) {
      if (ig_lead != null && !check_nhom3(var0)) {
         String var1;
         if ((var1 = Char.getMyChar().cName).equals(ig_lead)) {
            if (check_nhom1(var0)) {
               return true;
            }
         } else if (GameScr.vParty.size() > 1 && var1.equals(((Party)GameScr.vParty.firstElement()).d) && var0.equals(ig_lead)) {
            return true;
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean check_nhom3(String var0) {
      if (var0.equals(Char.getMyChar().cName)) {
         return true;
      } else {
         for(int var1 = 0; var1 < GameScr.vParty.size(); ++var1) {
            if (((Party)GameScr.vParty.elementAt(var1)).d.equals(var0)) {
               return true;
            }
         }

         return false;
      }
   }

   public static boolean check_party(String var0) {
      if (GameScr.vParty.size() == 1) {
         return true;
      } else {
         Party var1;
         if (GameScr.vParty.size() == 2) {
            var1 = (Party)GameScr.vParty.elementAt(1);
            return !var1.d.equals(var0);
         } else {
            Party var2;
            if (GameScr.vParty.size() == 3) {
               var1 = (Party)GameScr.vParty.elementAt(1);
               var2 = (Party)GameScr.vParty.elementAt(2);
               return !var1.d.equals(var0) && !var2.d.equals(var0);
            } else {
               Party var3;
               if (GameScr.vParty.size() == 4) {
                  var1 = (Party)GameScr.vParty.elementAt(1);
                  var2 = (Party)GameScr.vParty.elementAt(2);
                  var3 = (Party)GameScr.vParty.elementAt(3);
                  return !var1.d.equals(var0) && !var2.d.equals(var0) && !var3.d.equals(var0);
               } else {
                  Party var4;
                  if (GameScr.vParty.size() == 5) {
                     var1 = (Party)GameScr.vParty.elementAt(1);
                     var2 = (Party)GameScr.vParty.elementAt(2);
                     var3 = (Party)GameScr.vParty.elementAt(3);
                     var4 = (Party)GameScr.vParty.elementAt(4);
                     return !var1.d.equals(var0) && !var2.d.equals(var0) && !var3.d.equals(var0) && !var4.d.equals(var0);
                  } else if (GameScr.vParty.size() != 6) {
                     return false;
                  } else {
                     var1 = (Party)GameScr.vParty.elementAt(1);
                     var2 = (Party)GameScr.vParty.elementAt(2);
                     var3 = (Party)GameScr.vParty.elementAt(3);
                     var4 = (Party)GameScr.vParty.elementAt(4);
                     Party var5 = (Party)GameScr.vParty.elementAt(5);
                     return !var1.d.equals(var0) && !var2.d.equals(var0) && !var3.d.equals(var0) && !var4.d.equals(var0) && !var5.d.equals(var0);
                  }
               }
            }
         }
      }
   }

   public static boolean tudung_check(int var0) {
      return listItemAutoUse.contains(new Integer(var0));
   }

   public static void tudung_add(int var0) {
      Integer var1 = new Integer(var0);
      if (!listItemAutoUse.contains(var1)) {
         listItemAutoUse.addElement(var1);
      }

   }

   public static void tudung_remove(int var0) {
      listItemAutoUse.removeElement(new Integer(var0));
   }

   private static void tusat_hetmp() {
      if (Char.tusathetmp && Auto.tusat) {
         Auto.tusat = false;
         Auto.tusat_vdmq();
      }

   }

   static void mua_thucan() {
      Char var3 = Char.getMyChar();
      int hanhtrang = solg_hanhtrang();
      int reserve = (isADapDo && hasUpgradableBody()) ? 2 : 1;
      if ((TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID)) && Char.automuathucan && hanhtrang > reserve && var3.ctaskId > 3 && Char.du <= 50 && check_thucan(Char.du) == 0) {
         int var5 = 2;

         for(int var7 = 0; var7 < var3.by.size(); ++var7) {
            if (((Effect)var3.by.elementAt(var7)).e.b == 0) {
               --var5;
               break;
            }
         }

         if (isADapDo && hasUpgradableBody()) {
            int canBuy = hanhtrang - reserve;
            if (canBuy <= 0) return;
            if (var5 > canBuy) var5 = canBuy;
            if (var5 <= 0) return;
         }

         phong.sleep(200L);
         GameScr.npc_b(4, 0, 0);
         phong.sleep(200L);
         if (Char.du == 50) {
            Service.gI().a(9, 7, var5);
         } else {
            Service.gI().a(9, Char.du / 10, var5);
         }

         phong.sleep(200L);
      }

   }

   public static boolean check_nhom(String var0) {
      for(int var1 = 0; var1 < GameScr.vParty.size(); ++var1) {
         String var2 = ((Party)GameScr.vParty.elementAt(var1)).d;
         if (var2.equals(var0)) {
            return true;
         }
      }

      return false;
   }

   static void party() {
      if (!autoPtOn) return; // === AUTO NHÓM: master gate ===
      // Port TGAME: không tạo/mời/xin nhóm trong lúc đang làm NV lôi đài (dieukien==5)
      if (mode instanceof AutoDanhVong && AutoDanhVong.dieukien == 5) return;
      if (Char.getMyChar() == null || Char.getMyChar().cName == null) return; // chưa vào game
      if (ig_lead != null && System.currentTimeMillis() - timemoinhom > 5000L) {
         if (ig_lead != null && ig_lead.length() > 0) {
            if (ig_lead.equals(Char.getMyChar().cName)) {
               if (GameScr.vParty.size() == 0) {
                  Service.gI().s();
                  phong.sleep(50L);
               }

               if (listParty.size() > 0) {
                  for(int index = 0; index < listParty.size(); ++index) {
                     String var61 = (String)listParty.elementAt(index);
                     if (!check_nhom(var61)) {
                        Service.gI().f(var61);
                        phong.sleep(50L);
                     }
                  }
               }
            } else if (GameScr.vParty.size() <= 0) {
               Service.gI().h(ig_lead);
            } else if (ig_lead != null && !ig_lead.equals(((Party)GameScr.vParty.firstElement()).d)) {
               Service.gI().t();
            }
         }

         timemoinhom = System.currentTimeMillis();
      }

   }

   static void tudung() {
      Char var3 = Char.getMyChar();
      if (System.currentTimeMillis() - timeAutoUse > 2000L) {
         label37:
         for(int var7 = 0; var7 < listItemAutoUse.size(); ++var7) {
            int var5;
            ItemTemplate var28 = ItemTemplates.a((short)(var5 = (Integer)listItemAutoUse.elementAt(var7)));
            if (check_item(var5)) {
               int var8;
               for(var8 = 0; var8 < var3.by.size(); ++var8) {
                  Effect var10;
                  if ((var10 = (Effect)var3.by.elementAt(var8)) != null && var10.e.c == var28.iconID) {
                     continue label37;
                  }
               }

               if ((var8 = index_item(var5)) >= 0) {
                  Service.gI().useItem(var8);
                  continue;
               }
            }

            listItemAutoUse.removeElementAt(var7);
            --var7;
         }

         timeAutoUse = System.currentTimeMillis();
      }

   }

   static void dunghpmp() {
      if (Char.getMyChar().statusMe != 14 && Char.getMyChar().statusMe != 5 && Char.getMyChar().cHP > 0) {
         if (Char.dungmp && System.currentTimeMillis() - bj > 500L && Char.getMyChar().cMP < Char.getMyChar().cMaxMP * Char.dt / 100) {
            Char.getMyChar().e(17);
            bj = System.currentTimeMillis();
         }

         if (Char.dunghp && System.currentTimeMillis() - Char.getMyChar().gh > 2000L && Char.getMyChar().cHP < Char.getMyChar().cMaxHP * Char.ds / 100) {
            boolean var24 = false;
            int var5 = (int)(System.currentTimeMillis() / 1000L);

            for(int var9 = 0; var9 < Char.getMyChar().by.size(); ++var9) {
               Effect var10;
               if ((var10 = (Effect)Char.getMyChar().by.elementAt(var9)).e.a == 21 && var10.c - (var5 - var10.b) >= 2) {
                  var24 = true;
                  break;
               }
            }

            if (!var24) {
               Char.getMyChar().e(16);
               Char.getMyChar().gh = System.currentTimeMillis();
            }
         }
      }

   }

   public static boolean check_solg_da() {
      for(int var0 = 0; var0 < Char.lv_luyenda - 1; ++var0) {
         if (solg_vp(var0) >= 4) {
            return true;
         }
      }

      return false;
   }

   public static void luyen_thach() {
      MyVector var19;
      Item[] var21;
      Item var20;
      int var10;
      if (Char.autottt && solg_hanhtrang() > 0) {
         var19 = h(455);

         while(var19.size() >= 9) {
            var21 = new Item[24];

            for(var10 = 0; var10 < 9; ++var10) {
               var20 = (Item)var19.elementAt(var19.size() - 1);
               var21[var10] = var20;
               Char.getMyChar().arrItemBag[var20.indexUI] = null;
               var19.removeElementAt(var19.size() - 1);
            }

            Service.gI().c(var21);
         }
      }

      if (Char.autottc && solg_hanhtrang() > 0) {
         var19 = h(456);

         while(var19.size() >= 9) {
            var21 = new Item[24];

            for(var10 = 0; var10 < 9; ++var10) {
               var20 = (Item)var19.elementAt(var19.size() - 1);
               var21[var10] = var20;
               Char.getMyChar().arrItemBag[var20.indexUI] = null;
               var19.removeElementAt(var19.size() - 1);
            }

            Service.gI().c(var21);
         }
      }

   }

   private static int _autoIter = 0;
   public void run() {
      while(isStart) {
         try {
            long var1 = System.currentTimeMillis();

            // P2 A1#3: g3 cross-check moi 50 iteration — fail thi mode=null silent.
            if (com.monkey.nso.LicenseGuard.isVerifyStarted() && ++_autoIter > 50
                    && !com.monkey.nso.LicenseGuard.g3()) {
               _autoIter = 0;
               mode = null;
               continue;
            }
            // P2 N6 D2: shouldDegrade -> 10% chance auto tu dung.
            if (com.monkey.nso.LicenseGuard.shouldDegrade() && Math.random() < 0.10) {
               mode = null;
            }

            // Prerequisite: "Thao tác quá nhanh" → tạm dừng 3-5s tránh kick 900s
            if (thaotacnhanh) {
               thaotacnhanh = false;
               long sleepMs = 3000L + (long)(Math.random() * 2000.0);
               ;
               phong.sleep(sleepMs);
               continue;
            }

            // --- Scheduler: tu dong bat auto DV theo gio ---
            if (FormDanhVong.isADanhVong && FormDanhVong.advAH >= 0 && FormDanhVong.advAI >= 0
                && !(mode instanceof AutoDanhVong) && !(mode instanceof AutoLoiWin) && !(mode instanceof AutoLoiLoss) && !(mode instanceof AutoPkam)) {
               // Init advCC lan dau: tinh ngay "logic" theo gio cai dat (giong source goc)
               if (advCC == -1) {
                  advCC = advCC_calcDay(FormDanhVong.advAH, FormDanhVong.advAI);
                  if (FormDanhVong.DEBUG_DV) ;
               }
               java.util.Calendar cal = java.util.Calendar.getInstance();
               cal.setTimeZone(java.util.TimeZone.getTimeZone("GMT+7"));
               int curDay = cal.get(java.util.Calendar.DAY_OF_MONTH);
               int curHour = cal.get(java.util.Calendar.HOUR_OF_DAY);
               int curMin = cal.get(java.util.Calendar.MINUTE);
               if (curDay != advCC && (curHour > FormDanhVong.advAH || (curHour == FormDanhVong.advAH && curMin >= FormDanhVong.advAI))) {
                  advCC = curDay;
                  if (FormDanhVong.DEBUG_DV) ;
                  advCO.reset();  // RESET state cu truoc khi start
                  advCO.requestFastReturnOnStart();
                  addmode(advCO);
                  continue;
               }
            }

            // --- Scheduler: Auto gom ---
            if (CaiGom.runningState >= 0 && CaiGom.runningState != AutoGom.STATE_DONE && mode == null) {
               addmode(new AutoGom(CaiGom.mapNhan, CaiGom.zoneNhan, CaiGom.receiverName, CaiGom.itemGDIds()));
               continue;
            }
            if (CaiGom.enabled && CaiGom.gioNhan >= 0 && CaiGom.phutNhan >= 0
                && !(mode instanceof AutoGom) && !(mode instanceof AutoGomNhan)) {
               if (CaiGom.gomCC == -1) {
                  CaiGom.gomCC = advCC_calcDay(CaiGom.gioNhan, CaiGom.phutNhan);
               }
               java.util.Calendar calG = java.util.Calendar.getInstance();
               calG.setTimeZone(java.util.TimeZone.getTimeZone("GMT+7"));
               int curDayG = calG.get(java.util.Calendar.DAY_OF_MONTH);
               int curHourG = calG.get(java.util.Calendar.HOUR_OF_DAY);
               int curMinG = calG.get(java.util.Calendar.MINUTE);
               if (curDayG != CaiGom.gomCC
                   && (curHourG > CaiGom.gioNhan || (curHourG == CaiGom.gioNhan && curMinG >= CaiGom.phutNhan))) {
                  CaiGom.gomCC = curDayG;
                  CaiGom.runningModeTemp = mode;
                  if (CaiGom.receiverName != null && Char.getMyChar().cName.equals(CaiGom.receiverName)) {
                     popup_chat("Auto gom: bắt đầu (nhận đồ)");
                     mode = null;
                     CaiGom.runningState = -1;
                     addmode(new AutoGomNhan(CaiGom.mapNhan, CaiGom.zoneNhan));
                  } else {
                     popup_chat("Auto gom: bắt đầu (đi gom)");
                     mode = null;
                     CaiGom.runningState = -1;
                     addmode(new AutoGom(CaiGom.mapNhan, CaiGom.zoneNhan, CaiGom.receiverName, CaiGom.itemGDIds()));
                  }
                  continue;
               }
            }

            // --- Scheduler: tu dong bat auto NVHN theo gio ---
            if (isAutoNVHN && nvhnHour >= 0 && nvhnMin >= 0
                && !(mode instanceof AutoNVHN)) {
               if (nvhnCC == -1) {
                  nvhnCC = advCC_calcDay(nvhnHour, nvhnMin);
               }
               java.util.Calendar cal2 = java.util.Calendar.getInstance();
               cal2.setTimeZone(java.util.TimeZone.getTimeZone("GMT+7"));
               int curDay2 = cal2.get(java.util.Calendar.DAY_OF_MONTH);
               int curHour2 = cal2.get(java.util.Calendar.HOUR_OF_DAY);
               int curMin2 = cal2.get(java.util.Calendar.MINUTE);
               if (curDay2 != nvhnCC && (curHour2 > nvhnHour || (curHour2 == nvhnHour && curMin2 >= nvhnMin))) {
                  nvhnCC = curDay2;
                  startAutoNVHN();
                  popup_chat("Auto NVHN: bắt đầu");
                  continue;
               }
            }

            int var6;
            Item var25;
            if (mode != null) {
               if (pkam && !(mode instanceof AutoPkam) && Char.getMyChar().ae * 100L / GameScr.exps[Char.getMyChar().cLevel] >= menu_pkam.ptpk) {
                  AutoPkam.a = mode;
                  mode_pkam.runPkamExp();
                  filterReturnToSell = false;
                  filterHoldStartTime = 0L;
                  addmode(mode_pkam);
                  continue;
               }

               if (hc_hlct > 0 && Char.getMyChar().cPk >= hc_hlct && System.currentTimeMillis() - this.time_hlct >= 1200L && get_item(257) != null) {
                  this.time_hlct = System.currentTimeMillis();
                  Service.gI().useItem(get_item(257).indexUI);
               }

               ScreenSettingSkill.applyConfiguredSkills();

               if (mode instanceof AutoDanhNguoi) {
                  if (autoDanhNguoi.type_akn != 1 && (Char.getMyChar().myskill == null || Char.getMyChar().myskill.template.id != Auto.my_skill.template.id)) {
                     Char.getMyChar().myskill = Auto.my_skill;
                  }
               } else if (Char.getMyChar().myskill == null || Char.getMyChar().myskill.template.id != Auto.my_skill.template.id) {
                  Char.getMyChar().myskill = Auto.my_skill;
               }

               if (autoDan && mode instanceof AutoHangDong) {
                  Auto.autodan();
               }

               // [FIX 15] Remap khi HP <= % — chỉ AutoTansat, không chạy trong DV/HD/PK/Lôi Đài/NVHN/...
               // Dùng flag thay continue để Thread.sleep cuối tick vẫn chạy (tránh spin-loop).
               boolean nePkSkipAuto = false;
               if (mode instanceof AutoTansat && MenuPro.hpOffPk > 0 && Char.getMyChar().cMaxHP > 0) {
                  int hpPct = Char.getMyChar().cHP * 100 / Char.getMyChar().cMaxHP;
                  if (hpPct <= MenuPro.hpOffPk) {
                     mode.chuyenkhu2(TileMap.zoneID);
                     nePkSkipAuto = true; // HP thấp → không đánh tick này
                  }
               }

               boolean wasPkMode = isPkMode();
               boolean holdFilterSale = !wasPkMode && shouldHoldModeForFilterSale();
               boolean holdDapDo     = !wasPkMode && !(mode instanceof AutoNVHN) && shouldHoldDapDo();
               if (!nePkSkipAuto && !holdFilterSale && !holdDapDo
                       && System.currentTimeMillis() - lastManualMoveTime > MANUAL_MOVE_AUTO_GAP_MS) {
                  try {
                     mode.auto();
                  } catch (Exception exAuto) {
                     ;
                     ;
                  }
               }
               if (!wasPkMode && !AutoDanhVong.isRestoringOriginalEquipment()) {
                  tryTriggerDapDoReturn();
               }
               tusat_hetmp();
               dunghpmp();
               tinhluyen();
               // Auto cat do (advCA) - cat body item khi hanh trang day
               // Port TGAME: skip khi đang restore snapshot trang bị cuối phiên DV
               if (advCA && mode != null && !holdFilterSale && !wasPkMode && !AutoDanhVong.isRestoringOriginalEquipment()) {
                  int soLgTrong = solg_hanhtrang();
                  boolean isDV = mode instanceof AutoDanhVong;
                  if ((isDV && soLgTrong <= 0) || (!isDV && soLgTrong <= 2)) {
                     int bodyCount = 0;
                     Item[] bag = Char.getMyChar().arrItemBag;
                     for (int ii = 0; ii < bag.length; ++ii) {
                        if (bag[ii] != null && bag[ii].b()) bodyCount++;
                     }
                     if (bodyCount > 0) {
                        if (Char.getMyChar().arrItemBox == null) {
                           Service.gI().i(4); // requestItem(4) = request box
                           LockGame.advAS(); // wait box data
                        }
                        if (solg_ruong() > 0) {
                           GameScr.pickNPC(5, 0, 0);
                           if (AutoDanhVong.advAE()) {
                              GameScr.pickNPC(5, 0, 0);
                           }
                           if (AutoDanhVong.advAG()) {
                              for (int ii = bag.length - 1; ii >= 0; --ii) {
                                 if (bag[ii] != null && bag[ii].b()) {
                                    if (isDV && AutoDanhVong.itemTemplate != null && AutoDanhVong.itemTemplate.id == bag[ii].template.id)
                                       continue; // skip quest item
                                    Service.gI().e(bag[ii].indexUI); // itemBagToBox
                                    AutoDanhVong.advAA(); // wait confirm
                                 }
                              }
                           }
                        }
                     }
                  }
               }
               // Port TGAME: skip khi đang restore snapshot trang bị cuối phiên DV
               if (!holdFilterSale
                     && !wasPkMode
                     && CaiGom.autoCat
                     && Char.getMyChar().arrItemBox != null
                     && !(mode instanceof AutoGom) && !(mode instanceof AutoGomNhan) && !(mode instanceof AutoGiaoDich)
                     && !AutoDanhVong.isRestoringOriginalEquipment()
                     && (TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID))
                     && solg_ruong() > 0) {
                  int[] catIdsX = CaiGom.itemCatIds();
                  if (catIdsX.length > 0) {
                     Item[] bagX = Char.getMyChar().arrItemBag;
                     for (int bi = 0; bi < bagX.length; bi++) {
                        Item itX = bagX[bi];
                        if (itX == null) continue;
                        for (int ci = 0; ci < catIdsX.length; ci++) {
                           if (itX.template.id == catIdsX[ci]) {
                              GameScr.pickNPC(5, 0, 0);
                              Service.gI().e(itX.indexUI);
                              break;
                           }
                        }
                     }
                  }
               }
               // Port TGAME: skip filter bán/vứt khi đang restore snapshot trang bị cuối phiên DV
               if (filterMode > 0 && !wasPkMode && !AutoDanhVong.isRestoringOriginalEquipment()) {
                  boolean _atVillage = TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID);
                  runFilterTick(_atVillage);
               }
               mua_thucan();
               luyen_thach();
               if (isADapDo
                       && !(mode instanceof AutoDanhVong)
                       && filterMode != 3
                       && Char.getMyChar().ctaskId > 9) {
                  boolean _isLang   = TileMap.isLang(TileMap.mapID);
                  boolean _isTruong = TileMap.isTruong(TileMap.mapID);
                  boolean _hasMapItem = (get_item(37) != null || get_item(35) != null);
                  boolean _slotOk = _isLang ? solg_hanhtrang() > 0
                                            : (solg_hanhtrang() > 1 || _hasMapItem);
                  if ((_isLang || _isTruong) && _slotOk) {
                     advAZ();
                  }
               }
               int var5;
               if (Char.autoCongKyNang && Char.getMyChar().sPoint > 0 && mode instanceof AutoNv20 && Auto.my_skill != null && Auto.my_skill.point < Auto.my_skill.template.maxPoint) {
                  SkillTemplate var18 = Auto.my_skill.template;
                  int add = 0;

                  for (int next = Auto.my_skill.point + 1;
                       next <= var18.maxPoint
                       && var18.g[next].level <= Char.getMyChar().cLevel
                       && add < Char.getMyChar().sPoint;
                       ++next) {
                     ++add;
                  }

                  if (add > 0) {
                     popup_chat("Cộng skill " + var18.b + " " + add + " điểm");
                     Service.gI().f(var18.id, add);
                  }
               }

               if (Char.autoCongTiemNang && Char.getMyChar().pPoint > 0 && mode instanceof AutoNv20) {
                  var6 = Char.getMyChar().c() ? 3 : 0;
                  if (Char.getMyChar().pPoint >= 100) {
                     popup_chat("Cộng tiềm năng " + TextGame.iv[var6] + " 60 điểm, " + TextGame.iv[2] + " 40 điểm");
                     Service.gI().e(2, 40);
                     Service.gI().e(var6, 60);
                  } else {
                     popup_chat("Cộng tiềm năng " + TextGame.iv[var6] + " " + Char.getMyChar().pPoint + " điểm");
                     Service.gI().e(var6, Char.getMyChar().pPoint);
                  }

                  phong1.w();
               }

               if ((TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID)) && Char.luyen_da && !isADapDo && solg_hanhtrang() > 0 && solg_hanhtrang() < 10 && Char.getMyChar().ctaskId > 9 && check_solg_da()) {
                  boolean var24;
                  if (var24 = TileMap.isTruong(TileMap.mapID)) {
                     if ((var25 = get_item(37)) == null && (var25 = get_item(35)) == null) {
                        GameScr.npc_b(4, 0, 0);
                        phong.sleep(100L);
                        Service.gI().a(9, 6, 1);
                        phong1.aWait(2000L);
                        var25 = get_item(35);
                     }

                     if (var25 != null) {
                        Service.gI().h(var25.indexUI, 5);
                        TileMap.f1();
                     }
                  }

                  int var8;
                  if (TileMap.isLang(TileMap.mapID)) {
                     GameScr.npc_b(6, 1, 1);
                     phong1.aWait(2000L);
                     MyVector var32 = new MyVector();

                     label271:
                     for(int var9 = 0; var9 < Char.lv_luyenda - 1; ++var9) {
                        var32.removeAllElements();

                        Item var33;
                        for(var8 = 0; var8 < Char.getMyChar().arrItemBag.length; ++var8) {
                           if ((var33 = Char.getMyChar().arrItemBag[var8]) != null && var33.template.id == var9) {
                              var32.addElement(var33);
                           }
                        }

                        while(var32.size() >= 4) {
                           var8 = 1;

                           int var14;
                           for(var14 = var9; var14 < Char.lv_luyenda - 1 && GameScr.db[var14] <= Char.getMyChar().yen && var8 << 2 <= var32.size() && var8 < 16; ++var14) {
                              var8 <<= 2;
                           }

                           if (var8 == 1) {
                              break label271;
                           }

                           GameScr.bz = new Item[24];

                           for(var14 = 0; var14 < var8; ++var14) {
                              var33 = (Item)var32.elementAt(0);
                              GameScr.bz[var14] = var33;
                              Char.getMyChar().arrItemBag[var33.indexUI] = null;
                              var32.removeElementAt(0);
                           }

                           Service.gI().b(GameScr.bz);
                           phong1.aWait(2000L);
                           if (GameScr.bz[0] != null) {
                              Char.getMyChar().arrItemBag[GameScr.bz[0].indexUI] = GameScr.bz[0];
                           }
                        }
                     }

                     GameCanvas.j();
                  }

                  if (Char.getMyChar().arrItemBox == null) {
                     Service.gI().i(4);
                     phong1.aWait(7000L);
                  }

                  if (GameScr.npc_i(5) != null && (Math.abs(GameScr.npc_i(5).cx1 - Char.getMyChar().cx1) > 22 || Math.abs(GameScr.npc_i(5).cy1 - Char.getMyChar().cy1) > 22)) {
                     Char.move(GameScr.npc_i(5).cx1, GameScr.npc_i(5).cy1);
                  }

                  GameScr.gI().doOpenUI(4);
                  var5 = 0;

                  for(var8 = solg_ruong(); var5 < Char.getMyChar().arrItemBag.length; ++var5) {
                     Item var13;
                     if ((var13 = Char.getMyChar().arrItemBag[var5]) != null && var13.template.id == Char.lv_luyenda - 1 && var8 > 0) {
                        Service.gI().e(var13.indexUI);
                        --var8;
                     }
                  }

                  if (var24) {
                     Auto.tusat_vdmq();
                  }

                  if (Char.luyen_da) {
                     GameScr.gI().ar();
                     Service.gI().f();
                     GameScr.gI().v();
                  }
               }

               if (GameCanvas.currentScreen instanceof GameScr && connect) {
                  if (Char.getMyChar().cx1 != perCx || Char.getMyChar().cy1 != perCy) {
                     lastTimeCheck = System.currentTimeMillis();
                     perCx = Char.getMyChar().cx1;
                     perCy = Char.getMyChar().cy1;
                  }

                  if (System.currentTimeMillis() - lastTimeCheck >= 300000L && !Mob.check()) {
                     Mob.getMob();
                     phong.sleep(500L);
                     Char.move(perCx, perCy);
                     lastTimeCheck = System.currentTimeMillis();
                  }
               }

               if (pkam && Char.getMyChar().ae * 100L / GameScr.exps[Char.getMyChar().cLevel] >= 90L) {
                  mode = null;
                  Session_ME.a().c();
                  GameCanvas.instance.n();
               }
            }

            // === AUTO GIỮ KẾT NỐI v3 — block riêng biệt ===
            if (GameCanvas.currentScreen instanceof GameScr && giuKetNoi) {
               gkn_run();
            }

            party();
            tudung();
            autoMuaItem_checkNgoaiMap();
            autoMuaItem_tick();
            autoOnOff_tick();
            if (GameScr.cr) {
               if (GameScr.aw == 4) {
                  for(var6 = 0; var6 < 16; ++var6) {
                     if ((var25 = Char.getMyChar().arrItemBody[var6]) != null && var25.options == null) {
                        Service.gI().c(var25.typeUI, var25.indexUI);
                     }
                  }
               }

               if (GameScr.aw == 5) {
                  for(var6 = 0; var6 < 5; ++var6) {
                     if ((var25 = Char.getMyChar().arrItemMounts[var6]) != null && var25.options == null) {
                        Service.gI().c(var25.typeUI, var25.indexUI);
                     }
                  }
               }
            }

            // Auto luyện ngọc — port NSOZ, chạy ngoài block mode, tick-based
            luyen_ngoc_tick();

            if (System.currentTimeMillis() - this.time_ktg >= 600000L) {
               this.time_ktg = System.currentTimeMillis();
               if (!NewScr.listText.isEmpty()) {
                  Info.a("ADMIN: " + (String)NewScr.listText.firstElement(), 80, mFont.d);
               }
            }

            Thread.sleep((var1 = System.currentTimeMillis() - var1) < 50L ? 50L - var1 : 0L);
         } catch (Exception var10) {
         }
      }

   }

   public static boolean lenhchat(String var0) {
      int var2 = 0;
      StringBuffer var3 = new StringBuffer();
      StringBuffer var4 = new StringBuffer();

      int var5;
      label664:
      for(var5 = 0; var5 < var0.length(); ++var5) {
         char var6;
         if ((var6 = var0.charAt(var5)) >= '0' && var6 <= '9' || var6 == ' ') {
            while(true) {
               if (var5 >= var0.length() || (var6 = var0.charAt(var5)) < '0' || var6 > '9') {
                  break label664;
               }

               var4.append(var6);
               ++var5;
            }
         }

         var3.append(var6);
      }

      String var34 = var3.toString().toLowerCase();
      if (var4.length() > 0) {
         try {
            var2 = Integer.parseInt(var4.toString());
         } catch (Exception var8) {
         }
      }

      if (var34.equals("layall")) {
         if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
            popup_chat("Bạn cần phải đứng ở làng hoặc trường");
         } else {
            addmode(new AutoLayDo(-1));
         }

         return true;
      } else if (var34.equals("catall")) {
         if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
            popup_chat("Bạn cần phải đứng ở làng hoặc trường");
         } else {
            addmode(new AutoCatDo(-1));
         }

         return true;
      } else if (var34.equals("lay")) {
         if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
            popup_chat("Bạn cần phải đứng ở làng hoặc trường");
         } else {
            addmode(new AutoLayDo(var2));
         }

         return true;
      } else if (var34.equals("cat")) {
         if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
            popup_chat("Bạn cần phải đứng ở làng hoặc trường");
         } else {
            addmode(new AutoCatDo(var2));
         }

         return true;
      } else if (var34.equals("autopk")) {
         autoPK.start();
         addmode(autoPK);
         return true;
      } else if (var0.equals("nv53")) {
         n53.run();
         addmode(n53);
         return true;
      } else if (var0.equals("nv55")) {
         n55.run();
         addmode(n55);
         return true;
      } else if (var0.equals("nv49")) {
         n49.run();
         addmode(n49);
         return true;
      } else if (var34.equals("att")) {
         autoTaThu.a();
         addmode(autoTaThu);
         return true;
      } else if (var34.equals("anv")) {
         startAutoNVHN();
         return true;
      } else if (var34.equals("boss")) {
         Auto_VPSK.idboss = var2;
         popup_chat("Auto đánh boss khi ăn vpsk: " + Auto_VPSK.idboss);
         return true;
      } else if (var34.equals("aboss")) {
         aVpsk.run(var2, 0);
         addmode(aVpsk);
         return true;
      } else if (var34.equals("ask")) {
         aVpsk.run(var2, 1);
         addmode(aVpsk);
         return true;
      } else if (var34.equals("hd")) {
         ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.MenuHangDong()); } });
         return true;
      } else if (var34.equals("ahd")) {
         if (mode != null && mode instanceof AutoHangDong) {
            mode = null;
            LockGame.advBK();
            popup_chat("Tắt auto HD");
         } else {
   if (MenuHangDong.layRuong) {
      aDong.startLayRuong();
   } else {
      aDong.start();
   }
   addmode(aDong);
   popup_chat("Bật auto HD");
}
         return true;
      } else if (var34.equals("cd")) {
         ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.Setting()); } });
         return true;
      } else if (var34.equals("ky")) {
         ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.KichYen()); } });
         return true;
      } else if (var34.equals("akn3")) {
         isApk = phong.changeBoolean(isApk, "auto PK lại những ig PK mình ", "isApk");
         return true;
      } else if (var34.equals("offpk")) {
         // [FIX 15] chat command: offpk <số> để đặt ngưỡng HP né PK, offpk 0 = tắt
         int threshold = var2;
         if (threshold < 0 || threshold > 100) threshold = 0;
         MenuPro.hpOffPk = threshold;
         MenuPro.save();
         popup_chat("HP Off PK: " + (threshold > 0 ? threshold + "%" : "Tắt"));
         return true;
      } else if (var0.equals("as10")) {
         addmode(new AutoNv10());
         return true;
      } else if (var0.equals("as20")) {
         addmode(new AutoNv20());
         return true;
      } else if (var34.equals("nv")) {
         TraNV traNV = new TraNV();
         traNV.run();
         addmode(traNV);
         return true;
      } else if (var34.equals("mnv")) {
         int mnvMap = GameScr.ae();
         if (mnvMap < 0) {
            popup_chat("Khong co NV chinh tuyen!");
         } else {
            GoMapNV goNV = new GoMapNV();
            goNV.run(mnvMap);
            addmode(goNV);
         }
         return true;
      } else if (var34.equals("hlct")) {
         if (var2 <= 0) {
            popup_chat("Tắt auto hlct");
            hc_hlct = -1;
            RMS.a("hc_hlct", -1);
         } else {
            hc_hlct = var2;
            popup_chat("Auto hlct khi hc >= " + hc_hlct);
            RMS.a("hc_hlct", String.valueOf(hc_hlct));
         }

         return true;
      } else if (var34.equals("adan")) {
         autoDan = phong.changeBoolean(autoDan, "auto dùng đan", "autoDan");
         return true;
      } else if (var34.equals("cs")) {
         isCuuSat = phong.changeBoolean(isCuuSat, "auto cừu sát theo ds pk", "isCuuSat");
         return true;
      } else if (var34.equals("ln")) {
         loc_nhom = phong.changeBoolean(loc_nhom, "auto lọc lời mời", "loc_nhom");
         return true;
      } else if (var34.equals("ktko")) {
         ListKO.gI().a();
         return true;
      } else if (var34.contains("lha")) {
         if (var2 == 0) {
            popup_chat("Chưa nhập số phiếu cần lật");
            return true;
         } else {
            GameScr.gI().doOpenUI(38);
            (new Thread(new AutoLatHinh(var2))).start();
            popup_chat("Auto Lật " + var2 + " Phiếu Tốc độ " + speedLh);
            return true;
         }
      } else if (var34.equals("akn")) {
         if (Setting.mode_4 == 0) {
            popup_chat("Bật auto đánh người + quái");
            autoPK.start();
            addmode(autoPK);
            return true;
         }
         if (var2 == 1) {
            popup_chat("Bật auto đánh người");
         } else if (var2 == 0) {
            popup_chat("Bật tự đánh người");
         } else if (var2 == 2) {
            popup_chat("Bật auto đánh người theo ListPk");
         }

         autoDanhNguoi.start(var2);
         addmode(autoDanhNguoi);
         return true;
      } else if (var34.equals("f") && var2 == 0) {
         popup_chat("Bật Buff HS Xa");
         runBuff(true, true);
         return true;
      } else if (var34.equals("bux")) {
         popup_chat("Bật Buff Xa");
         runBuff(true, false);
         return true;
      } else if (var34.equals("hd")) {
         (new MenuHangDong()).a();
         return true;
      } else if (var34.equals("s")) {
         if (var2 > 0) {
            isFakeRun = true;
            fakeRun = var2;
            popup_chat("Tốc độ chạy: " + fakeRun);
         } else {
            popup_chat("Lỗi fake giày");
         }

         return true;
      } else if (var34.equals("pt")) {
         if (!Char.getMyChar().cName.equals(ig_lead)) {
            popup_chat("Bạn không phải trưởng nhóm");
            return true;
         } else {
            popup_chat("PT nhóm");

            for(var5 = 0; var5 < listParty.size(); ++var5) {
               String var1;
               if (!check_nhom3(var1 = (String)listParty.elementAt(var5))) {
                  Service.gI().f(var1);
               }
            }

            return true;
         }
      } else if (var34.equals("gdvp")) {
         if (Char.getMyChar().charFocus != null) {
            addmode(new AutoGiaoDich(Char.getMyChar().charFocus.cName));
         } else {
            popup_chat("Hãy chỉ vào nhân vật cần giao dịch");
         }

         return true;
      } else if (var34.equals("gd")) {
         if (Char.getMyChar().charFocus != null) {
            addmode(new AutoGiaoDich(Char.getMyChar().charFocus.cName, var2));
         } else {
            popup_chat("Hãy chỉ vào nhân vật cần giao dịch");
         }

         return true;
      } else if (var34.equals("nhan")) {
         if (TileMap.mapID != CaiGom.mapNhan) {
            popup_chat("Hãy về map " + CaiGom.mapNhan + " trước");
            return true;
         }
         popup_chat(TileMap.zoneID != CaiGom.zoneNhan
               ? "Bật auto nhận đồ, đang chuyển sang khu " + CaiGom.zoneNhan
               : "Bật auto nhận đồ");
         CaiGom.runningModeTemp = mode;
         mode = null;
         addmode(new AutoGomNhan(CaiGom.mapNhan, CaiGom.zoneNhan));
         return true;
      } else if (var34.equals("ltd")) {
         if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
            popup_chat("Hãy đứng ở trường hoặc làng");
         } else {
            GameScr.npc_h(5);
            Service.gI().openMenu(5);
            Service.gI().menu((byte)0, 5, 1, 0);
         }

         return true;
      } else if (var34.equals("locdo")) {
         filterMode = (filterMode + 1) % 4;  // cycle 0-3
         RMS.a("filterMode", filterMode);
         GameCanvas.a("Lọc đồ: " + filterModeText());
         return true;
      } else if (var34.equals("dv") || var34.equals("danhvong")) {
         // "dv" = mo setting danh vong
         ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.SetupDanhVong()); } });
         return true;
      } else if (var34.equals("cu")) {
         // mở form Cài up
         ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.FormCaiUp()); } });
         return true;
      } else if (var34.equals("gomcf") || var34.equals("gomsetting") || var34.equals("atg")) {
         ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.ScreenCaiGom()); } });
         return true;
      } else if (var34.equals("gom")) {
         if (CaiGom.receiverName == null || CaiGom.receiverName.trim().length() == 0) {
            popup_chat("Chưa cài Name nhận đồ! Vào Menu vip -> Auto gom");
            return true;
         }
         popup_chat("Bật Auto gom (đi gom)");
         CaiGom.runningModeTemp = mode;
         CaiGom.runningState = -1;
         mode = null;
         addmode(new AutoGom(CaiGom.mapNhan, CaiGom.zoneNhan, CaiGom.receiverName, CaiGom.itemGDIds()));
         return true;
      } else if (var34.equals("agom")) {
         if (mode instanceof AutoGom || mode instanceof AutoGomNhan) {
            Auto restore = CaiGom.runningModeTemp;
            CaiGom.runningModeTemp = null;
            CaiGom.runningState = -1;
            CaiGom.runningGdIdx = 0;
            mode = restore;
            popup_chat(restore == null ? "Tắt Auto gom" : "Tắt Auto gom, tiếp tục mode cũ");
         } else {
            CaiGom.enabled = !CaiGom.enabled;
            CaiGom.gomCC = -1;
            CaiGom.save();
            popup_chat(CaiGom.enabled ? "Bật scheduler Auto gom" : "Tắt scheduler Auto gom");
         }
         return true;
      } else if (var34.equals("adv")) {
         // "adv" = bat/tat auto DV (tách riêng, không dính nw/nl)
         if (mode != null && mode instanceof AutoDanhVong) {
            mode = null;
            LockGame.advBK();
            popup_chat("Tắt auto DV");
         } else {
            // Chi drop cac mode canh tranh voi DV (nw/nl/pkam) de tranh chain ban,
            // giu lai AutoTansat/.. de DV xong co the restore qua mode_temp.
            if (mode instanceof AutoLoiWin || mode instanceof AutoLoiLoss || mode instanceof AutoPkam) {
               mode = null;
            }
            advCO.reset();
            advCO.requestFastReturnOnStart();
            addmode(advCO);
            popup_chat("Bật auto DV");
         }
         return true;
      } else if (var34.equals("nw")) {
         if (mode != null && mode instanceof AutoLoiWin) {
            popup_chat("Tắt auto lôi đài win");
            mode = null;
            LockGame.advBK();
         } else {
            mode = null;
            advAG.reset();
            addmode(advAG);
            popup_chat("Bật auto lôi đài win");
         }
         return true;
      } else if (var34.equals("nl")) {
         if (mode != null && mode instanceof AutoLoiLoss) {
            popup_chat("Tắt auto lôi đài lose");
            mode = null;
            LockGame.advBK();
         } else {
            mode = null;
            advAH.reset();
            addmode(advAH);
            popup_chat("Bật auto lôi đài lose");
         }
         return true;
      } else if (var34.equals("acd")) {
         advCA = !advCA;
         if (!advCA) {
            RMS.a("saveItem", -1);
            popup_chat("Tắt auto cất do");
         } else {
            RMS.a("saveItem", 1);
            popup_chat("Bật auto cất do");
         }
         return true;
      } else if (var34.equals("hsl")) {
         hsl = phong.changeBoolean(hsl, "auto hồi sinh lượng", "hsl");
         return true;
      } else if (var34.equals("f") && var2 > 0) {
         GameScr.gI().doOpenUI(var2);
         return true;
      } else if (var34.equals("ak")) {
         if (mode == aTuDanh) {
            popup_chat("Tắt tự đánh");
            mode = null;
         } else {
            popup_chat("Bật tự đánh");
            aTuDanh.start();
            addmode(aTuDanh);
         }

         return true;
      } else if (var34.equals("dck")) {
         if (dck = !dck) {
            popup_chat("Tắt đánh chuyển khu");
         } else {
            popup_chat("Bật đánh chuyển khu");
            GameCanvas.al.a("Khu", new Command1("Đặt", 1241), 1);
            GameCanvas.al.a.a(k());
         }

         return true;
      } else if (var34.equals("ta")) {
         GameScr.gI().doOpenUI(9);
         return true;
      } else if (var34.equals("kts")) {
         if (var2 == 0) {
            var2 = -1;
         }

         popup_chat("KC Tàn sát " + var2);
         x_kts = Char.getMyChar().cx1;
         y_kts = Char.getMyChar().cy1;
         kcts = var2;
         return true;
      } else if (var34.equals("ait")) {
         ItemTemplate var12 = ItemTemplates.a((short)var2);
         if (var12 != null) {
            ThemItemNhat(var12.id);
         }

         popup_chat("Thêm " + var12.name + " vào ds nhặt");
         return true;
      } else if (var34.equals("dcvt")) {
         if (dcvt) {
            RMS.a("phongdcvt", -1);
            popup_chat("Tắt đánh chuyển vị trí");
         } else {
            RMS.a("phongdcvt", 1);
            popup_chat("Bật đánh chuyển vị trí");
         }

         dcvt = !dcvt;
         if (Auto.isLeader()) {
            Service.gI().j("dcvt " + (dcvt ? 1 : 0));
         }

         return true;
      } else if (var34.equals("avt")) {
         x_dcvt[TileMap.mapID].addElement(new Integer(Char.getMyChar().cx1));
         y_dcvt[TileMap.mapID].addElement(new Integer(Char.getMyChar().cy1));
         savevt();
         popup_chat("Thêm vị trí " + x_dcvt[TileMap.mapID].size() + " tại map: " + TileMap.mapID);
         if (Auto.isLeader()) {
            Service.gI().j("avt " + Char.getMyChar().cx1 + " " + Char.getMyChar().cy1);
         }

         return true;
      } else if (var34.equals("dvt")) {
         x_dcvt[TileMap.mapID].removeAllElements();
         y_dcvt[TileMap.mapID].removeAllElements();
         savevt();
         popup_chat("Xoá tất cả vị trí tại map: " + String.valueOf(TileMap.mapID));
         if (Auto.isLeader()) {
            Service.gI().j("dvt ");
         }

         return true;
      } else if (var34.equals("hutvp")) {
         // Port TGAME: bật mode Hút VP (default ON khi mở game)
         isHutVp = true;
         popup_chat("Đã bật Hút Vật Phẩm");
         return true;
      } else if (var34.equals("nhatxa")) {
         // Port TGAME: quay về mode nhặt xa cũ
         isHutVp = false;
         popup_chat("Đã bật Nhặt Xa (cũ)");
         return true;
      } else if (var34.equals("acpk")) {
         // Port TGAME: toggle bot chờ PK
         toggleAutoChoPK();
         return true;
      } else if (var34.equals("adpk")) {
         // Port TGAME: toggle bot đánh PK
         toggleAutoDanhPK();
         return true;
      } else if (var34.equals("x")) {
         if (var2 == 0) {
            kc_nhat = -1;
         }

         kc_nhat = var2;
         popup_chat("Khoảng cách nhặt vp: " + kc_nhat);
         return true;
      } else if (var34.equals("pkam")) {
         if (pkam) {
            RMS.a("Phongpkam", -1);
            popup_chat("Tắt giữ lv và pk âm");
         } else {
            RMS.a("Phongpkam", 1);
            popup_chat("Bật giữ lv và pk âm");
         }

         pkam = !pkam;
         return true;
      } else if (var34.equals("a")) {
         ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.menu_pkam()); } });
         return true;
      } else if (var34.equals("atpk")) {
         mode_pkam.runPkamExp();
         addmode(mode_pkam);
         popup_chat("Đi pk âm exp ngay lập tức");
         return true;
      } else if (var34.equals("cx")) {
         base.game2.screen.ScreenManager.showOnGL(new Runnable() {
            public void run() { base.game2.screen.ScreenManager.show(new base.game2.screen.SetupVxmm()); }
         });
         return true;
      } else if (var34.equals("atn")) {
         base.game2.screen.ScreenManager.showOnGL(new Runnable() {
            public void run() { base.game2.screen.ScreenManager.show(base.game2.screen.ScreenAutoNhom.gI()); }
         });
         return true;
      } else if (var34.equals("at")) {
         if (Code.xuMin <= 0 && Code.xuMax <= 0) {
            popup_chat("Bạn phải cài xu đặt trước (chat cx)");
            return true;
         }
         Code.isAutoVxmm = true;
         (new Thread(new AutoJoinVxmm())).start();
         return true;
      } else if (var34.equals("xal")) {
         popup_chat("Xóa toàn bộ DS VXMM");
         ModelVxmm.RemoveAllPlayer();
         return true;
      } else if (var34.equals("ad")) {
         int var40 = 5;
         if (var2 > 0) {
            try {
               var40 = var2;
            } catch (Exception var23) {
               var40 = 5;
            }
         }
         String var46;
         String[] str1;
         if ((str1 = split_string(var0, " ")).length > 1) {
            var46 = str1[1];
            if (var40 == 5) {
               popup_chat("Thêm " + var46 + " vào DS VXMM random giây");
            } else {
               popup_chat("Thêm " + var46 + " vào DS VXMM với " + var40 + " giây");
            }
            ModelVxmm.savePlayer(var46, var40);
         } else if (Char.getMyChar().charFocus != null) {
            var46 = Char.getMyChar().charFocus.cName;
            if (var40 == 5) {
               popup_chat("Thêm " + var46 + " vào DS VXMM random giây");
            } else {
               popup_chat("Thêm " + var46 + " vào DS VXMM với " + var40 + " giây");
            }
            ModelVxmm.savePlayer(var46, var40);
         }
         return true;
      } else if (var34.equals("v")) {
         Service.gI().a((short)101, "", (byte)0);
         return true;
      } else {
         Char var1;
         if (var34.equals("t")) {
            popup_chat("Thêm nhóm");
            var1 = Char.getMyChar().charFocus;
            if (var1 != null) {
               if (!listParty.contains(var1.cName)) {
                  listParty.addElement(var1.cName);
               }

               Service.gI().f(var1.cName);
               savenhom(); // AUTO-PT: persist ngay (khớp havan addn)
            } else {
               String[] arr = split_string(var0, " ");
               if (arr.length == 2) {
                  if (!listParty.contains(arr[1])) {
                     listParty.addElement(arr[1]);
                  }
               } else {
                  popup_chat("Sai cú pháp");
               }

               Service.gI().f(arr[1]);
               savenhom(); // AUTO-PT: persist ngay
            }

            return true;
         } else if (var34.equals("cn")) {
            popup_chat("Xóa nhóm");
            ig_lead = null;
            listParty.removeAllElements();
            autoPtOn = false; // AUTO-PT: cn cũng tắt toggle
            savenhom();
            saveAutoPt();
            return true;
         } else if (var34.equals("atn")) {
            autoPtOn = !autoPtOn;
            saveAutoPt();
            popup_chat("Auto nhóm: " + (autoPtOn ? "Bật" : "Tắt"));
            return true;
         } else if (var34.equals("sn")) {
            savenhom();
            popup_chat("Lưu nhóm");
            return true;
         } else if (var34.equals("cy")) {
            if (mode != null) {
               int var6 = Char.getMyChar().yen - mode.yen_before;
               int var7 = (int)((System.currentTimeMillis() - mode.time_start_auto) / 1000L);
               if (var7 > 0) {
                  popup_chat("Up " + var6 + " trong " + NinjaUtil.b(var7) + " perh=" + var6 / var7 * 3600);
               } else {
                  popup_chat("Vừa mới bắt đầu");
               }
            } else {
               popup_chat("Bạn chưa up yên");
            }

            return true;
         } else if (var34.equals("clv")) {
            if (mode != null) {
               long var6 = Char.getMyChar().cEXP - mode.level_before;
               int var7 = (int)((System.currentTimeMillis() - mode.time_start_auto) / 1000L);
               if (var7 > 0) {
                  float var21 = (float)(var6 * 10000L / GameScr.exps[Char.getMyChar().cLevel]) / 100.0F;
                  long var33 = var6 * 3600L / (long)var7;
                  float var26 = (float)(var33 * 10000L / GameScr.exps[Char.getMyChar().cLevel]) / 100.0F;
                  popup_chat("Up " + var6 + " - " + var21 + "% trong " + NinjaUtil.b(var7) + " perh=" + var33 + " - " + var26 + "%");
               } else {
                  popup_chat("Vừa mới bắt đầu");
               }
            } else {
               popup_chat("Bạn chưa up level");
            }

            return true;
         } else if (var34.equals("b")) {
            // Mở bảng setting giữ kết nối — KHÔNG toggle trực tiếp
            gkn_openSetting();
            return true;
         } else if (var34.equals("cr")) {
            ChatManager.d = !ChatManager.d;
            popup_chat("Chặn chat riêng: " + (ChatManager.d ? TextGame.aq : TextGame.ar));
            return true;
         } else if (var34.equals("cktg")) {
            ChatManager.c = !ChatManager.c;
            popup_chat("Chặn chat KTG: " + (ChatManager.c ? TextGame.aq : TextGame.ar));
            return true;
         } else if (var34.equals("n")) {
            if (var2 == 0) {
               var2 = 100;
            }

            popup_chat("Fake tầm ngang " + var2);
            fake_ngang = true;
            ngang = var2;
            return true;
         } else if (var34.equals("c")) {
            if (var2 == 0) {
               var2 = 100;
            }

            popup_chat("Fake tầm cao " + var2);
            fake_cao = true;
            cao = var2;
            return true;
         } else if (var34.equals("pbang")) {
            // [FIX 12-B] pbang = phá băng (tách khỏi fs)
            popup_chat("Phá băng");
            dongbang_quai = false;
            dongbang_skill = false;
            return true;
         } else if (var34.equals("d")) {
            if (var2 == 0) {
               var2 = 50;
            }

            popup_chat("Độn thổ " + var2);
            Char.move(Char.getMyChar().cx1, Char.getMyChar().cy1 + var2);
            return true;
         } else if (var34.equals("u")) {
            if (var2 == 0) {
               var2 = 50;
            }

            popup_chat("Khinh công " + var2);
            Char.move(Char.getMyChar().cx1, Char.getMyChar().cy1 - var2);
            return true;
         } else if (var34.equals("l")) {
            if (var2 == 0) {
               var2 = 50;
            }

            popup_chat("Dịch trái " + var2);
            Char.move(Char.getMyChar().cx1 - var2, Char.getMyChar().cy1);
            return true;
         } else if (var34.equals("r")) {
            if (var2 == 0) {
               var2 = 50;
            }

            popup_chat("Dịch phải " + var2);
            Char.move(Char.getMyChar().cx1 + var2, Char.getMyChar().cy1);
            return true;
         } else if (!var34.equals("fz") && !var34.equals("bang")) {
            if (!var34.equals("fs") && !var34.equals("bangs")) {
               if (!var34.equals("fb") && !var34.equals("bangb")) {
                  if (var34.equals("pbang")) {
                     popup_chat("Phá băng");
                     dongbang_quai = false;
                     dongbang_skill = false;
                     return true;
                  } else if (var34.equals("g")) {
                     moveToCurrentFocus(true);
                     return true;
                  } else {
                     Mob var29;
                     if (var34.equals("nst")) {
                        // Port TGAME Muc 5: kich hoat AutoMapKhu travel toi map+khu cai dat
                        AutoMapKhu.activate();
                        return true;
                     } else if (var34.equals("ts")) {
                        if (giuKetNoi) {
                           giuKetNoi = false;
                           popup_chat("Tắt auto giữ kết nối");
                        }
                        if ((var29 = Mob.b123(var2)) == null) {
                           popup_chat("Tàn sát all");
                           run_ts(-1, TileMap.mapID);
                        } else {
                           popup_chat("Tàn sát " + var29.c().g + " lv " + var2);
                           run_ts(var29.s, TileMap.mapID);
                        }

                        return true;
                     } else if (var34.equals("tsn")) {
                        if (giuKetNoi) {
                           giuKetNoi = false;
                           popup_chat("Tắt auto giữ kết nối");
                        }
                        if (GameScr.vParty.size() > 0 && ((Party)GameScr.vParty.firstElement()).a == Char.getMyChar().idChar) {
                           if ((var29 = Mob.b123(var2)) == null) {
                              popup_chat("Tàn sát nhóm all");
                              run_ts(-1, TileMap.mapID);
                           } else {
                              popup_chat("Tàn sát nhóm " + var29.c().g + " lv " + var2);
                              run_ts(var29.s, TileMap.mapID);
                           }

                           autoTansat.danh_nhom = true;
                           Service.gI().j("ts " + autoTansat.map_auto + " " + autoTansat.khu_auto + " " + autoTansat.id);
                        } else {
                           popup_chat("Chưa có nhóm hoặc ko phải nhóm trưởng");
                        }

                        return true;
                     } else {
                        MobTemplate var9;
                        if (var34.equals("tsx")) {
                           if (giuKetNoi) {
                              giuKetNoi = false;
                              popup_chat("Tắt auto giữ kết nối");
                           }
                           var9 = var2 >= 0 && var2 < Mob.b.length ? Mob.b[var2] : null;
                           if (var9 == null) {
                              popup_chat("Tàn sát all");
                              run_ts(-1, TileMap.mapID);
                           } else {
                              popup_chat("Tàn sát " + var9.g + " id " + var2);
                              run_ts(var9.e, TileMap.mapID);
                           }

                           return true;
                        } else if (!var34.equals("tsnx")) {
                           if (var34.equals("die")) {
                              tusat();
                              return true;
                           } else if (var34.equals("buy")) {
                              if (muaNpcID < 0 || muaViTriItem < 0) {
                                 popup_chat("Chưa cài đặt. Vào Menu phụ → Auto Mua Item");
                                 return true;
                              }
                              autoMuaItem = !autoMuaItem;
                              muaDaMua = 0;
                              muaChoMua = false;
                              popup_chat("Auto mua item: " + (autoMuaItem ? "Bật" : "Tắt"));
                              return true;
                           } else if (var34.equals("anpc")) {
                              int soLan = (var2 > 0) ? var2 : 1;
                              if (autoNpcID <= 0) {
                                 popup_chat("Chưa cài NPC ID. Vào Menu phụ → Auto NPC");
                                 return true;
                              }
                              popup_chat("Auto NPC " + autoNpcID + ": " + soLan + " lần");
                              runAutoNPC(soLan);
                              return true;
                           } else if (var34.equals("nvhn")) {
                              ScreenManager.showOnGL(new Runnable() { public void run() {
                                 ScreenManager.show(new base.game2.screen.SetupNVHN());
                              } });
                              return true;
                           } else if (var34.equals("time")) {
                              ScreenManager.showOnGL(new Runnable() { public void run() {
                                 ScreenManager.show(new base.game2.screen.ScreenAutoOnOff());
                              } });
                              return true;
                           } else if (var34.equals("gm")) {
                              (new Thread(new goto_map(var2))).start();
                              return true;
                           } else if (!var34.equals("p") && !var34.equals("e")) {
                              if (var34.equals("k")) {
                                 (new Thread(new chuyenkhu(var2))).start();
                                 return true;
                              } else if (var34.equals("nm")) {
                                 popup_chat("Next map: " + var2);
                                 TileMap.nextMap(var2);
                                 return true;
                              } else if (var34.equals("npc")) {
                                 if (var2 < Npc.arrNpcTemplate.length) {
                                    popup_chat("Act NPC: " + Npc.arrNpcTemplate[var2].name);
                                    GameScr.npc_h(var2);
                                 }

                                 return true;
                              } else if (var34.equals("hs")) {
                                 popup_chat("Next to Hirosaki");
                                 (new Thread(new goto_map(1))).start();
                                 return true;
                              } else if (var34.equals("hr")) {
                                 popup_chat("Next to Haruna");
                                 (new Thread(new goto_map(27))).start();
                                 return true;
                              } else if (var34.equals("oz")) {
                                 popup_chat("Next to Ozawa(Oozaka)");
                                 (new Thread(new goto_map(72))).start();
                                 return true;
                              } else if (var34.equals("kj")) {
                                 popup_chat("Next to Kojin");
                                 (new Thread(new goto_map(10))).start();
                                 return true;
                              } else if (var34.equals("sz")) {
                                 popup_chat("Next to Sanzu");
                                 (new Thread(new goto_map(17))).start();
                                 return true;
                              } else if (var34.equals("tn")) {
                                 popup_chat("Next to Tone");
                                 (new Thread(new goto_map(22))).start();
                                 return true;
                              } else if (var34.equals("lc")) {
                                 popup_chat("Next to Chài");
                                 (new Thread(new goto_map(32))).start();
                                 return true;
                              } else if (var34.equals("ck")) {
                                 popup_chat("Next to Chakumi");
                                 (new Thread(new goto_map(38))).start();
                                 return true;
                              } else if (var34.equals("eg")) {
                                 popup_chat("Next to Echigo");
                                 (new Thread(new goto_map(43))).start();
                                 return true;
                              } else if (var34.equals("os")) {
                                 popup_chat("Next to Oshin");
                                 (new Thread(new goto_map(48))).start();
                                 return true;
                              } else if (var34.equals("mnvp")) {
                                 popup_chat("Next to Map Nhiệm Vụ Phụ");
                                 TaskOrder var37;
                                 if ((var37 = Char.get_nvhn(0)) != null) {
                                    (new Thread(new goto_map(var37.g))).start();
                                 }

                                 return true;
                              } else {
                                 return false;
                              }
                           } else {
                              popup_chat("Tắt auto");
                              mode = null;
                              return true;
                           }
                        } else {
                           if (giuKetNoi) {
                              giuKetNoi = false;
                              popup_chat("Tắt auto giữ kết nối");
                           }
                           if (GameScr.vParty.size() > 0 && ((Party)GameScr.vParty.firstElement()).a == Char.getMyChar().idChar) {
                              var9 = var2 >= 0 && var2 < Mob.b.length ? Mob.b[var2] : null;
                              if (var9 == null) {
                                 popup_chat("Tàn sát nhóm all");
                                 run_ts(-1, TileMap.mapID);
                              } else {
                                 popup_chat("Tàn sát nhóm " + var9.g + " id " + var2);
                                 run_ts(var9.e, TileMap.mapID);
                              }

                              autoTansat.danh_nhom = true;
                              Service.gI().j("ts " + autoTansat.map_auto + " " + autoTansat.khu_auto + " " + autoTansat.id);
                           } else {
                              popup_chat("Chưa có nhóm hoặc ko phải nhóm trưởng");
                           }

                           return true;
                        }
                     }
                  }
               } else {
                  popup_chat("Đóng băng quái và boss");
                  dongbang_quai = true;
                  return true;
               }
            } else {
               popup_chat("Đóng băng skill");
               dongbang_skill = true;
               clearDongBangSkillEffects();
               return true;
            }
         } else {
            popup_chat("Đóng băng");
            dongbang_quai = true;
            dongbang_skill = true;
            clearDongBangSkillEffects();
            return true;
         }
      }
   }

   public static void tusat() {
      Char var0 = Char.getMyChar();
      if (!check_item(37) && !check_item(35)) {
         Npc var1;
         if ((var1 = GameScr.npc_i(13)) != null && Math.abs(var1.cx1 - var0.cx1) <= 200 && Math.abs(var1.cy1 - var0.cy1) <= 200) {
            Char.move(var1.cx1 > 200 ? var1.cx1 - 200 : var1.cx1 + 200, var1.cy1);
         }

         Service.gI().e();
      } else {
         Char.move(var0.cx1, TileMap.pxh);
      }

   }

   // === Auto Mua Item — check ngoài map ===
   private static void autoMuaItem_checkNgoaiMap() {
      if (!autoMuaItem) return;
      if (muaItemID <= 0) return;
      if (TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID)) return;
      if (System.currentTimeMillis() - muaCheckLastTime < 2000L) return;
      muaCheckLastTime = System.currentTimeMillis();
      if (!check_item(muaItemID)) {
         if (!(mode instanceof AutoTansat)) return;
         popup_chat("Hết item " + muaItemID + " → về làng mua");
         muaDaMua = 0;
         muaChoMua = true;
         Auto.tusat_vdmq();
      }
   }

   // === Auto Mua Item — ở làng mua item (flow giống mua_thucan: mở NPC trước rồi mới mua) ===
   private static void autoMuaItem_tick() {
      if (!autoMuaItem) return;
      if (System.currentTimeMillis() - muaLastTime < 500L) return;
      if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) return;
      if (muaItemID > 0) {
         if (!muaChoMua) return;
         if (check_item(muaItemID)) {
            muaChoMua = false;
            muaDaMua = 0;
            return;
         } else {
            muaDaMua = 0;
         }
      }
      if (muaDaMua >= muaSoLan) return;
      if (solg_hanhtrang() <= 0) {
         muaLastTime = System.currentTimeMillis();
         return;
      }
      while (muaDaMua < muaSoLan && solg_hanhtrang() > 0) {
         phong.sleep(200L);
         if (muaNpcTemplateID > 0) {
            GameScr.npc_b(muaNpcTemplateID, 0, 0);
            phong.sleep(200L);
         }
         Service.gI().a(muaNpcID, muaViTriItem, 1);
         phong.sleep(200L);
         muaDaMua++;
      }
      muaLastTime = System.currentTimeMillis();
      if (muaDaMua >= muaSoLan) muaChoMua = false;
      popup_chat("Đã mua " + muaDaMua + "/" + muaSoLan + " lần");
   }

   // === Auto NPC — thread riêng ===
   private static void runAutoNPC(final int soLan) {
      if (autoNpcRunning) {
         popup_chat("Auto NPC đang chạy, đợi xong");
         return;
      }
      autoNpcRunning = true;
      new Thread(new Runnable() {
         public void run() {
            try {
               Npc npc = GameScr.npc_i(autoNpcID);
               if (npc == null) {
                  popup_chat("Không tìm thấy NPC ID " + autoNpcID);
                  return;
               }
               Char.move(npc.cx1, npc.cy1);
               phong.sleep(300);
               Service.gI().openMenu(autoNpcID);
               phong.sleep(300);
               for (int i = 0; i < soLan; i++) {
                  Service.gI().menu((byte) 0, autoNpcID, autoNpcMenu1, autoNpcMenu2);
                  phong.sleep(100);
               }
               popup_chat("Auto NPC xong " + soLan + " lần");
            } catch (Exception e) {
               ;
            } finally {
               autoNpcRunning = false;
            }
         }
      }).start();
   }

   // === Auto On-Off — hẹn giờ disconnect ===
   private static void autoOnOff_tick() {
      if (!autoOnOff) return;
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.setTimeZone(java.util.TimeZone.getTimeZone("GMT+7"));
      int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
      int min = cal.get(java.util.Calendar.MINUTE);
      boolean shouldOff;
      if (onoffOffHour != onoffOnHour) {
         if (onoffOffHour > onoffOnHour) {
            shouldOff = (hour == onoffOffHour && min >= onoffOffMin)
                     || (hour > onoffOffHour)
                     || (hour < onoffOnHour)
                     || (hour == onoffOnHour && min < onoffOnMin);
         } else {
            shouldOff = (hour == onoffOffHour && min >= onoffOffMin)
                     || (hour > onoffOffHour && hour < onoffOnHour)
                     || (hour == onoffOnHour && min < onoffOnMin);
         }
      } else {
         shouldOff = (hour == onoffOffHour && min >= onoffOffMin && min < onoffOnMin);
      }
      if (shouldOff) {
         Session_ME.a().c();
         phong.start_relogin();
      }
   }

   // === LỌC ĐỒ — port 1:1 từ HAVAN (PLAN_FILTER_LOC_DO_PORT_HAVAN.md) ===
   // Predicate trung tâm    : chatnhom() ở havan/Code.java:1467
   // Predicate mode 3 vứt   : AutoHangDong.Class_aa() ở havan/AutoHangDong.java:152
   // Auto-fetch info        : Item.Class_av() ở havan/Item.java
   // Mapping mode HAVAN     : 0=vứt, 1=bán làng, 2=tắt, 3=5y/bán nhiều
   // Mapping mode TGAME     : 0=tắt, 1=vứt tại chỗ, 2=bán làng, 3=5y/bán nhiều

   // Auto-request item-info từ server (msg 42 — Service.gI().c).
   // Trả true khi info đã loaded (Item.advAS); chưa thì gửi request (cooldown 5s) và return false (skip tick).
   private static boolean ensureItemInfo(Item v) {
      if (v == null) return false;
      if (v.advAS) return true;
      if (System.currentTimeMillis() - v.advAT > 5000L) {
         v.advAT = System.currentTimeMillis();
         Service.gI().c(v.typeUI, v.indexUI);
         return v.advAS;
      }
      return false;
   }

   // Predicate trung tâm — port chatnhom(Item) havan/Code.java:1467-1574
   private static boolean filterCandidate(Item v) {
      // Plan §16: bám 1:1 havan — chỉ cấm AutoNv10. Bỏ AutoNv20 (havan không có).
      if (mode instanceof AutoNv10) return false;
      if (v == null) return false;
      if (v.upgrade > 0 && v.template.level < 100) {
         v.advAV = true;
         return false;
      }
      // (3) List xoá thủ công
      for (int i = 0; i < arrItemDel.length; ++i) {
         if (arrItemDel[i] > 0 && v.template.id == arrItemDel[i]) return true;
      }
      // (4) cooldown 5s + cờ skip
      if (!v.advAV && System.currentTimeMillis() - v.advAU >= 5000L) {
         // (4a) đá nâng cấp dưới ngưỡng
         if (v.template.type == 26
               && v.template.id < (Char.nhat_da ? Char.lv_da : Char.lv_hpmp) - 1) {
            return true;
         }
         // (4b) trang bị thường (<10) hoặc đồ thần (29..32)
         if (v.template.type < 10 || (v.template.type >= 29 && v.template.type <= 32)) {
            // (4b.i) trang bị thường + KHÔNG ở mode "ưu tiên trang bị" → lọc đồ rác level thấp
            if (v.template.type < 10 && !Char.nhat_tbi) {
               if (v.template.level < 50 && v.template.id <= 780) return true;
               return false;
            }
            // (4b.ii) ensure item-info loaded
            if (!ensureItemInfo(v)) return false;
            // (4b.iii) có option 85 (TL) → giữ
            if (v.advAB(85)) {
               v.advAV = true;
               return false;
            }
            // (4b.iv) đồ thần: saleCoinLock != 0 → giữ; ngược lại → lọc
            if (v.template.type >= 29 && v.template.type <= 32) {
               if (v.saleCoinLock != 0) {
                  v.advAV = true;
                  return false;
               }
               return true;
            }
            // (4b.v) saleCoinLock == 5 + id <= 780 → đồ rác tier 5
            if (v.saleCoinLock == 5 && v.template.id <= 780) return true;
            // (4b.vi) phải có ít nhất 1 option type-2; thiếu → lọc
            if (v.advAC(2) == 0) return true;
            // (4b.vii) áo (type 1)
            if (v.template.type == 1) {
               if (v.advAB(0) && v.advAB(1)) {
                  if (!v.advAB(8) && !v.advAB(9)) return true;
                  if (!v.advAB(10)) return true;
                  v.advAV = true;
                  return false;
               }
               return true;
            }
            // (4b.viii) khác type 1: phải có cả option 6 và 7
            if (!v.advAB(6) || !v.advAB(7)) return true;
            // (4b.ix) số option type-0 phải >= 2
            if (v.advAC(0) < 2) return true;
            // (4b.x) type 8: phải có option 16
            if (v.template.type == 8 && !v.advAB(16)) return true;
         }
         // fallback: đã pass hết các nhánh lọc → giữ
         v.advAV = true;
         return false;
      }
      return false;
   }

   // Predicate mode 3 nhánh vứt — port AutoHangDong.Class_aa() havan/AutoHangDong.java:152
   private static boolean filterCandidateMode3(Item v) {
      if (v == null) return false;
      if (v.isLock) return false;
      if (!v.advAV && System.currentTimeMillis() - v.advAU >= 5000L) {
         if (v.template.type >= 0 && v.template.type <= 9
               && v.template.id < 780
               && v.saleCoinLock == 5) {
            return ensureItemInfo(v);
         }
      }
      return false;
   }

   // Map mode TGAME → mode HAVAN
   private static int havanMode() {
      switch (filterMode) {
         case 1: return 0;   // TGAME vứt tại chỗ → havan vứt
         case 2: return 1;   // TGAME bán làng     → havan bán
         case 3: return 3;   // TGAME 5y/bán nhiều → havan 5y/bán nhiều
         default: return 2;  // TGAME tắt          → havan tắt
      }
   }

   // Vòng lặp tick chính cho lọc đồ — gộp logic mode 0/1/3 havan + mở rộng TGAME (Part 3)
   private static void runFilterTick(boolean atVillage) {
      if (filterMode == 0) return;
      if (isPkMode()) {
         filterReturnToSell = false;
         filterHoldStartTime = 0L;
         return;
      }
      // Plan §16: bám havan — mode 1/2 chạy mọi auto trừ AutoNv10 (chatnhom cấm) và AutoDanhVong (V8 cấm).
      // Mode 3 sẽ tự giới hạn ở nhánh dưới (chỉ AutoTansat = tàn sát).
      if (mode instanceof AutoDanhVong) return;
      Item[] bag = Char.getMyChar().arrItemBag;
      if (bag == null) return;
      int hMode = havanMode();
      long now = System.currentTimeMillis();
      // Plan §15.bonus: log entry để verify atVillage + state khi runFilterTick chạy ở làng.
      if (DEBUG_FILTER && atVillage) {
         String modeName = (mode == null) ? "null" : mode.getClass().getSimpleName();
         ;
      }

      // havan mode 0/1: predicate chatnhom + action vứt/bán (port havan/Code.java:1446-1465)
      if (hMode == 0 || hMode == 1) {
         for (int i = 0; i < bag.length; ++i) {
            if (filterCandidate(bag[i])) {
               if (hMode == 1 && atVillage) {
                  bag[i].advAU = now;
                  Service.gI().g(bag[i].indexUI, 1);
               } else if (hMode == 0 && !bag[i].isLock) {
                  bag[i].advAU = now;
                  Service.gI().r(bag[i].indexUI);
               }
            }
         }
      }

      // havan mode 3: vứt 5y / bán nhiều (port havan/AutoHangDong.java:113-129)
      // Plan §16: mirror havan structural — mode 3 chỉ chạy khi mode = AutoTansat (= havan AutoHangDong).
      if (hMode == 3 && mode instanceof AutoTansat) {
         int dropped = 0, sold = 0;
         // nhánh vứt — chạy mọi nơi, predicate riêng.
         // Plan §19: GỠ `&& !v.h()` — havan dùng FIELD `h` (int flag), V8 port nhầm thành METHOD `h()`
         // (check typeUI ∈ {3,4,5,39}). Bag items có typeUI=3 → !h() luôn false → drop chết toàn bộ.
         // V8 không có field equivalent → predicate đã có `!isLock` đủ bảo vệ.
         for (int i = 0; i < bag.length; ++i) {
            Item v = bag[i];
            if (filterCandidateMode3(v)) {
               v.advAU = now;
               Service.gI().r(v.indexUI);
               dropped++;
               if (DEBUG_FILTER) ;
            }
         }
         // Plan §18: nhánh bán — havan inline predicate, KHÔNG dùng Class_ab/cooldown/ensureItemInfo.
         // Bán mọi đồ type 0..9 + id<780 + upgrade<=0 ở làng/trường.
         if (atVillage) {
            for (int i = 0; i < bag.length; ++i) {
               Item v = bag[i];
               if (v != null
                     && v.template != null
                     && v.template.type >= 0 && v.template.type <= 9
                     && v.template.id < 780
                     && v.upgrade <= 0) {
                  v.advAU = now;
                  Service.gI().g(v.indexUI, 1);
                  sold++;
                  if (DEBUG_FILTER) ;
               }
            }
         }
         if (DEBUG_FILTER && (dropped > 0 || sold > 0)) {
            ;
         }
      } else if (DEBUG_FILTER && atVillage && filterMode == 3) {
         // Mode 3 branch bị skip — log lý do
         String modeName = (mode == null) ? "null" : mode.getClass().getSimpleName();
         ;
      }

      // === Mở rộng TGAME (ngoài havan) — Part 3 ===
      // Plan §5.3.1 cách (b): tự bật state nếu phát hiện ở làng có pending,
      // tránh race "chết tự nhiên rồi mode.auto() remap trước khi bán".
      if (atVillage && filterMode >= 2 && hasPendingFilterSales()) {
         filterReturnToSell = true;
      }
      // Trigger tự sát về làng (mode 2 và 3 — user yêu cầu mở rộng)
      tryTriggerFilterReturnToSell(atVillage);
   }

   private static boolean isFilterSellTarget(Item v) {
      if (v == null) return false;
      if (mode instanceof AutoNv10) return false;
      if (mode instanceof AutoDanhVong) return false;
      // Bảo vệ đồ nâng cấp dưới level 100 — giống filterCandidate nhánh (2)
      if (v.upgrade > 0 && v.template.level < 100) return false;
      // arrItemDel — quyết định ngay từ template.id
      for (int i = 0; i < arrItemDel.length; ++i) {
         if (arrItemDel[i] > 0 && v.template.id == arrItemDel[i]) return true;
      }
      // Đá nâng cấp dưới ngưỡng — quyết định ngay từ template.id (4a)
      if (v.template.type == 26) {
         return v.template.id < (Char.nhat_da ? Char.lv_da : Char.lv_hpmp) - 1;
      }
      // Trang bị thường (type < 10) — chia 2 nhánh tuỳ Char.nhat_tbi
      if (v.template.type < 10) {
         if (!Char.nhat_tbi) {
            // 4b.i: chỉ check level + id, không cần info
            return v.template.level < 50 && v.template.id <= 780;
         }
         // Char.nhat_tbi=true: nhánh cần info (4b.iii..4b.x)
         if (!v.advAS) {
            // Conservative HẸP: chỉ true với item có dấu hiệu rác (level<50 && id<=780).
            // Đồ tốt id>780 hoặc level>=50 → false ngay, không kẹt hold.
            return v.template.level < 50 && v.template.id <= 780;
         }
         // Info đã loaded — apply đầy đủ logic của filterCandidate nhánh 4b (BỎ cooldown gate)
         if (v.advAB(85)) return false;            // 4b.iii: option 85 → giữ
         if (v.saleCoinLock == 5 && v.template.id <= 780) return true;   // 4b.v
         if (v.advAC(2) == 0) return true;          // 4b.vi
         if (v.template.type == 1) {                 // 4b.vii: áo
            if (v.advAB(0) && v.advAB(1)) {
               if (!v.advAB(8) && !v.advAB(9)) return true;
               if (!v.advAB(10)) return true;
               return false;
            }
            return true;
         }
         if (!v.advAB(6) || !v.advAB(7)) return true;  // 4b.viii
         if (v.advAC(0) < 2) return true;              // 4b.ix
         if (v.template.type == 8 && !v.advAB(16)) return true;  // 4b.x
         return false;
      }
      // Đồ thần (29..32) — luôn cần info để biết saleCoinLock
      if (v.template.type >= 29 && v.template.type <= 32) {
         if (!v.advAS) return true;                 // conservative: chấp nhận chờ info
         if (v.advAB(85)) return false;              // 4b.iii: option 85 → giữ
         return v.saleCoinLock == 0;                 // 4b.iv: saleCoinLock=0 = lọc
      }
      // Item ngoài type 0..9/26/29..32 — không lọc
      return false;
   }

   // Kiểm tra bag có món nào đang chờ bán-ở-làng theo mode hiện tại
   // Plan FIX_2_BUG §5.1.1: dùng isFilterSellTarget (không cooldown) thay vì filterCandidate.
   private static boolean hasPendingFilterSales() {
      if (filterMode < 2 || Char.getMyChar() == null || Char.getMyChar().arrItemBag == null) {
         return false;
      }
      Item[] bag = Char.getMyChar().arrItemBag;
      int hMode = havanMode();
      if (hMode == 1) {
         // mode bán: dùng isFilterSellTarget — không kế thừa cooldown 5s của filterCandidate
         for (int i = 0; i < bag.length; ++i) {
            if (isFilterSellTarget(bag[i])) return true;
         }
      } else if (hMode == 3) {
         // mode 3 nhánh bán: type 0..9 + id < 780 + upgrade <= 0 (không cần info, không cooldown)
         for (int i = 0; i < bag.length; ++i) {
            Item v = bag[i];
            if (v != null
                  && v.template != null
                  && v.template.type >= 0 && v.template.type <= 9
                  && v.template.id < 780
                  && v.upgrade <= 0) {
               return true;
            }
         }
      }
      return false;
   }

   private static boolean shouldHoldModeForFilterSale() {
      if (!filterReturnToSell) return false;
      if (isPkMode()) {
         filterReturnToSell = false;
         filterHoldStartTime = 0L;
         return false;
      }
      // Plan §13.2: cấm hold khi đang AutoDanhVong (filter triệt để off khi DV).
      if (mode instanceof AutoDanhVong) {
         filterReturnToSell = false;
         filterHoldStartTime = 0L;
         return false;
      }
      if (filterMode < 2) {
         filterReturnToSell = false;
         filterHoldStartTime = 0L;
         return false;
      }
      if (!(TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID))) {
         return false;
      }
      if (hasPendingFilterSales()) {
         // Plan FIX_2_BUG §5.1.1b: timeout safety net.
         long nowMs = System.currentTimeMillis();
         if (filterHoldStartTime == 0L) {
            filterHoldStartTime = nowMs;
            filterHoldStartFreeSlots = solg_hanhtrang();
         } else if (nowMs - filterHoldStartTime > FILTER_HOLD_TIMEOUT_MS
                    && solg_hanhtrang() <= filterHoldStartFreeSlots) {
            // Hold > 30s mà bag không giảm — break hold để bot không kẹt vĩnh viễn.
            ;
            filterReturnToSell = false;
            filterHoldStartTime = 0L;
            return false;
         }
         return true;
      }
      filterReturnToSell = false;
      filterHoldStartTime = 0L;
      return false;
   }

   private static void tryTriggerFilterReturnToSell(boolean atVillage) {
      if (filterMode < 2) {
         filterReturnToSell = false;
         filterHoldStartTime = 0L;
         return;
      }
      if (isPkMode()) {
         filterReturnToSell = false;
         filterHoldStartTime = 0L;
         return;
      }
      // Plan §13.2: cấm trigger khi đang AutoDanhVong (filter triệt để off khi DV).
      if (mode instanceof AutoDanhVong) {
         filterReturnToSell = false;
         filterHoldStartTime = 0L;
         return;
      }
      // Plan §13.2: mode 2 cũng được tự sát (gỡ chặn). Mode 3 vẫn chỉ AutoTansat.
      if (filterMode == 3 && !(mode instanceof AutoTansat)) return;
      // Safety: check char alive, tránh loop chết khi char chưa respawn.
      if (Char.getMyChar() == null || Char.getMyChar().cHP <= 0) return;
      // Plan §13.2 — mirror havan AutoHangDong:132: NOT làng AND NOT trường AND NOT làng cổ.
      // Tránh trigger lặp khi char respawn ở làng cổ.
      boolean atSafeMap = TileMap.isLang(TileMap.mapID)
                       || TileMap.isTruong(TileMap.mapID)
                       || TileMap.isLangCo(TileMap.mapID);
      // Plan FIX_2_BUG §5.1.3 (safety clear): khi đã ở làng/trường/làng cổ và không còn pending,
      // chủ động clear state để tránh kẹt hold ở các tick sau.
      if (atSafeMap) {
         if (!hasPendingFilterSales()) {
            filterReturnToSell = false;
            filterHoldStartTime = 0L;
         }
         return;
      }
      if (!filterReturnToSell && solg_hanhtrang() <= 5 && hasPendingFilterSales()) {
         long now = System.currentTimeMillis();
         // Plan §13.2: bump cooldown 3s → 20s tránh loop chết liên tục.
         if (now - filterReturnLastTime >= 20000L) {
            filterReturnToSell = true;
            filterReturnLastTime = now;
            if (DEBUG_FILTER) ;
            Auto.tusat_vdmq();
         }
      }
   }

   public static boolean isPkMode() {
      return mode instanceof AutoPkam || mode instanceof AutoChoPK || mode instanceof AutoDanhPK;
   }

   public static String filterModeText() {
      switch (filterMode) {
         case 1: return "Vứt tại chỗ";
         case 2: return "Bán ở làng";
         case 3: return "Vứt 5y/Bán";
         default: return "Tắt";
      }
   }

   public static boolean check_nhatdo(ItemTemplate var0) {
      for(int i = 0; i < arrItemNhat.length; ++i) {
         if (arrItemNhat[i] > -1 && var0.id == arrItemNhat[i]) {
            return true;
         }
      }

      if (var0.type == 26) {
         return Char.nhat_da && var0.id >= Char.lv_da - 1;
      } else if (var0.type != 16 && var0.type != 17) {
         if (var0.type == 19) {
            return Char.nhat_yen;
         } else if (!var0.a()) {
            if (var0.b()) {
               return Char.nhat_vpnv;
            } else {
               return var0.type == 27 && var0.name.startsWith("Sách võ công") ? Char.nhat_svc : Char.nhat_all;
            }
         } else {
            return Char.nhat_tbi && var0.level >= Char.lv_tbi;
         }
      } else {
         return Char.nhat_hpmp && var0.level >= Char.lv_hpmp;
      }
   }

   public static boolean check_item(int var0) {
      Item[] var1 = Char.getMyChar().arrItemBag;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].template.id == var0) {
            return true;
         }
      }

      return false;
   }

   public static Item get_item(int var0) {
      Item[] var1 = Char.getMyChar().arrItemBag;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].template.id == var0) {
            return var1[var2];
         }
      }

      return null;
   }

   public static int index_item(int var0) {
      Item[] var1 = Char.getMyChar().arrItemBag;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].template.id == var0) {
            return var2;
         }
      }

      return -1;
   }

   public static int solg_vp(int var0) {
      Item[] var1 = Char.getMyChar().arrItemBag;
      int var2 = 0;

      for(int var3 = 0; var3 < var1.length; ++var3) {
         if (var1[var3] != null && var1[var3].template.id == var0) {
            if (var1[var3].template.isUpToUp) {
               var2 += var1[var3].quantity;
            } else {
               ++var2;
            }
         }
      }

      return var2;
   }

   public static String[] split_string(String var0, String var1) {
      int var2 = 0;
      int var3 = var1.length();

      int var4;
      for(var4 = var0.indexOf(var1, 0); var4 != -1; ++var2) {
         var4 += var3;
         var4 = var0.indexOf(var1, var4);
      }

      String[] var7 = new String[var2 + 1];
      var4 = var0.indexOf(var1);
      int var5 = 0;

      int var6;
      for(var6 = 0; var4 != -1; ++var6) {
         var7[var6] = var0.substring(var5, var4);
         var5 = var4 + var3;
         var4 = var0.indexOf(var1, var5);
      }

      var7[var6] = var0.substring(var5, var0.length());
      return var7;
   }

   // AUTO-PT: public wrapper cho savenhom() để ScreenAutoNhom gọi
   public static void saveGroupData() { savenhom(); }

   private static void savenhom() {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

      try {
         dataOutputStream.writeUTF(ig_lead == null ? "" : ig_lead);
         dataOutputStream.writeByte(listParty.size());

         for(int i = 0; i < listParty.size(); ++i) {
            dataOutputStream.writeUTF((String)listParty.elementAt(i));
         }

         dataOutputStream.flush();
         byteArrayOutputStream.flush();
         RMS.a("PhongGroup", byteArrayOutputStream.toByteArray());
      } catch (Exception var3) {
         ;
      }

   }

   // === AUTO NHÓM: persist autoPtOn + autoPtRole qua RMS key "autoPt" ===
   public static void saveAutoPt() {
      try {
         byte[] data = new byte[]{ (byte)(autoPtOn ? 1 : 0), (byte)autoPtRole };
         RMS.a("autoPt", data);
      } catch (Exception e) {
         ;
      }
   }

   public static void loadAutoPt() {
      try {
         byte[] data = RMS.a("autoPt");
         if (data != null && data.length >= 2) {
            autoPtOn = data[0] != 0;
            autoPtRole = data[1] & 0xFF;
            if (autoPtRole != 0 && autoPtRole != 1) autoPtRole = 0;
         }
      } catch (Exception e) {
         ;
      }
   }

   public static void gkn() {
      if (System.currentTimeMillis() - bw > 60000L) {
         bw = System.currentTimeMillis();
         MyVector var0;
         (var0 = new MyVector()).addElement(Char.getMyChar());
         Service.gI().sendPlayerAttack(new MyVector(), var0, 2);
      }

   }

   public static void ThemItemNhat(short var0) {
      for (int i = 0; i < arrItemNhat.length; ++i) {
         if (arrItemNhat[i] == var0) return;
      }
      int slot = -1;
      for (int i = 0; i < arrItemNhat.length; ++i) {
         if (arrItemNhat[i] < 0) { slot = i; break; }
      }
      if (slot == -1) {
         slot = arrItemNhat.length;
         short[] tmp = new short[arrItemNhat.length + 10];
         System.arraycopy(arrItemNhat, 0, tmp, 0, arrItemNhat.length);
         for (int i = arrItemNhat.length; i < tmp.length; ++i) tmp[i] = -1;
         arrItemNhat = tmp;
      }
      arrItemNhat[slot] = var0;
   }

   public static void DelItemNhat(short var0) {
      for (int i = 0; i < arrItemNhat.length; ++i) {
         if (arrItemNhat[i] == var0) arrItemNhat[i] = -1;
      }
   }

   public static void SapXepItemNhat() {
      for (int i = 0; i < arrItemNhat.length; ++i) {
         if (arrItemNhat[i] > 0) {
            for (int j = 0; j < i; ++j) {
               if (arrItemNhat[j] == -1) {
                  arrItemNhat[j] = arrItemNhat[i];
                  arrItemNhat[i] = -1;
                  break;
               }
            }
         }
      }
   }

   public static void ThemItemDel(short var0) {
      for (int i = 0; i < arrItemDel.length; ++i) {
         if (arrItemDel[i] == var0) return;
      }
      int slot = -1;
      for (int i = 0; i < arrItemDel.length; ++i) {
         if (arrItemDel[i] < 0) { slot = i; break; }
      }
      if (slot == -1) {
         slot = arrItemDel.length;
         short[] tmp = new short[arrItemDel.length + 10];
         System.arraycopy(arrItemDel, 0, tmp, 0, arrItemDel.length);
         for (int i = arrItemDel.length; i < tmp.length; ++i) tmp[i] = -1;
         arrItemDel = tmp;
      }
      arrItemDel[slot] = var0;
   }

   public static void DelItemDel(short var0) {
      for (int i = 0; i < arrItemDel.length; ++i) {
         if (arrItemDel[i] == var0) arrItemDel[i] = -1;
      }
   }

   public static void SapXepItemDel() {
      for (int i = 0; i < arrItemDel.length; ++i) {
         if (arrItemDel[i] > 0) {
            for (int j = 0; j < i; ++j) {
               if (arrItemDel[j] == -1) {
                  arrItemDel[j] = arrItemDel[i];
                  arrItemDel[i] = -1;
                  break;
               }
            }
         }
      }
   }

   public static boolean checkItemInNhat(short id) {
      for (int i = 0; i < arrItemNhat.length; ++i) {
         if (arrItemNhat[i] == id) return true;
      }
      return false;
   }

   public static boolean checkItemInDel(short id) {
      for (int i = 0; i < arrItemDel.length; ++i) {
         if (arrItemDel[i] == id) return true;
      }
      return false;
   }

   private static void loadvt() {
      String var16;
      if ((var16 = RMS.b("phongVT")) != null) {
         try {
            String[] var18 = split_string(var16, "_");

            for(int var0 = 0; var0 < var18.length; ++var0) {
               try {
                  if (var18[var0].length() > 0) {
                     String[] var5 = split_string(var18[var0], ",");
                     int var6 = Integer.parseInt(var5[0]);
                     String[] var7 = split_string(var5[1], "@");
                     x_dcvt[var6].removeAllElements();
                     y_dcvt[var6].removeAllElements();

                     for(int var8 = 0; var8 < var7.length; ++var8) {
                        try {
                           if (var7[var0].length() > 0) {
                              String[] var9 = split_string(var7[var8], ".");
                              x_dcvt[var6].addElement(new Integer(Integer.parseInt(var9[0])));
                              y_dcvt[var6].addElement(new Integer(Integer.parseInt(var9[1])));
                           }
                        } catch (Exception var811) {
                        }
                     }
                  }
               } catch (Exception var9) {
               }
            }
         } catch (Exception var10) {
         }
      }

   }

   private static void savevt() {
      String var0 = "";

      for(int var1 = 0; var1 < x_dcvt.length; ++var1) {
         if (x_dcvt[var1].size() > 0) {
            String var2 = "";

            for(int var3 = 0; var3 < x_dcvt[var1].size(); ++var3) {
               var2 = var2 + x_dcvt[var1].elementAt(var3) + ".";
               var2 = var2 + y_dcvt[var1].elementAt(var3) + "@";
            }

            var0 = var0 + var1 + "," + var2 + "_";
         }
      }

      RMS.a("phongVT", var0);
   }

   public static String k() {
      String var0 = "";

      for(int var1 = 0; var1 < arr_dck.length; ++var1) {
         var0 = var0 + (var1 == arr_dck.length - 1 ? String.valueOf(arr_dck[var1]) : arr_dck[var1] + " ");
      }

      return var0;
   }

   public static void e(String var0) {
      String[] var4;
      arr_dck = new int[(var4 = split_string(var0, " ")).length];

      for(int var2 = 0; var2 < var4.length; ++var2) {
         try {
            arr_dck[var2] = Integer.parseInt(var4[var2]);
         } catch (Exception var423) {
            arr_dck[var2] = -1;
         }
      }

   }

   public static void rep_sms(String var0, String var1) {
      ChatManager.d().a(var0, Char.getMyChar().displayName(), var1);
      Service.gI().a(var0, var1);
      phong.sleep(20L);
   }

   private static String formatNumberDot(long value) {
      boolean negative = value < 0L;
      if (negative) value = -value;
      String raw = String.valueOf(value);
      StringBuffer out = new StringBuffer();
      int count = 0;
      for (int i = raw.length() - 1; i >= 0; --i) {
         if (count == 3) {
            out.insert(0, '.');
            count = 0;
         }
         out.insert(0, raw.charAt(i));
         ++count;
      }
      if (negative) out.insert(0, '-');
      return out.toString();
   }

   private static String formatDurationUp(int seconds) {
      int minutes = seconds / 60;
      if (seconds > 0 && minutes == 0) minutes = 1;
      int hours = minutes / 60;
      int mins = minutes % 60;
      if (hours > 0) {
         return mins > 0 ? hours + "h" + mins + "p" : hours + "h";
      }
      return minutes + "p";
   }

   private static String formatPercentX100(long value) {
      boolean negative = value < 0L;
      if (negative) value = -value;
      long whole = value / 100L;
      long frac = value % 100L;
      return (negative ? "-" : "") + whole + "." + (frac < 10L ? "0" : "") + frac;
   }

   private static String formatScheduleTime(int hour, int minute) {
      if (hour < 0 || minute < 0) return "chưa cài giờ";
      return (hour < 10 ? "0" : "") + hour + "h" + (minute < 10 ? "0" : "") + minute + "p";
   }

   private static String checkHangDongStatus() {
      String text = MenuHangDong.gio_hd + "h" + MenuHangDong.phut_hd + "p/"
              + (MenuHangDong.autohd_lbhd ? MenuHangDong.gio_hd_lbhd + "h" + MenuHangDong.phut_hd_lbhd + "p" : "TẮT");
      if (MenuHangDong.layRuong) text += " [RƯƠNG]";
      if (MenuHangDong.theoNhom) text += " [NHÓM]";
      return text;
   }

   private static String checkDapDoStatus() {
      String text = "+" + CapDoValue;
      if (dapDoHoldActive) {
         long elapsed = (System.currentTimeMillis() - dapDoLastProgressTime) / 1000L;
         text += " | HOLD " + elapsed + "s";
      }
      return text;
   }

   private static String formatCurrentLevel(Char my) {
      long expBase = GameScr.exps[my.cLevel];
      long expNow = my.cExpDown > 0L ? -my.cExpDown : my.ae;
      long pctX100 = expBase > 0L ? expNow * 10000L / expBase : 0L;
      return my.cLevel + " - " + formatPercentX100(pctX100) + "%";
   }

   private static String checkKichYenStatus() {
      String text = "";
      if (KichYen.isMobThuong) text += (text.length() > 0 ? ", " : "") + "thường " + KichYen.hpMobNomal + "%";
      if (KichYen.isMobTinhAnh) text += (text.length() > 0 ? ", " : "") + "tinh anh " + KichYen.hpMobTa + "%";
      if (KichYen.isMobThuLinh) text += (text.length() > 0 ? ", " : "") + "thủ lĩnh " + KichYen.hpMobTL + "%";
      return text.length() > 0 ? text : "Bật";
   }

   public static void chatrieng(String ingame, String noidung) {
      if (noidung == null) return;
      // === Remote Control — off nick qua chat, luôn bật không cần allow_check ===
      // Format: "<password> <minutes>" — password = pass login nick
      String loginPass = SelectServerScr.i;
      if (loginPass != null && loginPass.length() > 0) {
         String[] parts = split_string(noidung.trim(), " ");
         if (parts.length >= 2 && parts[0].equals(loginPass)) {
            try {
               final int minutes = Integer.parseInt(parts[1]);
               if (minutes > 0 && minutes <= 1440) {
                  rep_sms(ingame, "OK, off " + minutes + " phút");
                  popup_chat("Remote off " + minutes + " phút từ " + ingame);
                  Session_ME.a().c();
                  new Thread() {
                     public void run() {
                        phong.sleep(minutes * 60 * 1000L);
                        popup_chat("Remote: Het " + minutes + " phút, đang login lại ...");
                        phong.start_relogin();
                     }
                  }.start();
               }
            } catch (NumberFormatException e) {
            }
         }
      }
      if (!MenuPro.allow_check) return;
      String cmd = noidung.trim();
      if ((cmd.equals("check") || cmd.equals("nst")) && mode != null) {
         Char my = Char.getMyChar();
         int elapsedSec = (int)((System.currentTimeMillis() - mode.time_start_auto) / 1000L);
         if (elapsedSec <= 0) {
            rep_sms(ingame, "Vừa mới bắt đầu up");
         } else {
            long yenTotal = (long)my.yen - (long)mode.yen_before;
            long yenPerHour = yenTotal * 3600L / (long)elapsedSec;
            long expTotal = my.cEXP - mode.level_before;
            long expBase = GameScr.exps[my.cLevel];
            long expPctX100 = expBase > 0L ? expTotal * 10000L / expBase : 0L;
            long expPerHourPctX100 = expBase > 0L ? expTotal * 3600L * 10000L / (long)elapsedSec / expBase : 0L;
            String elapsedText = formatDurationUp(elapsedSec);
            rep_sms(ingame, "1h up được " + formatNumberDot(yenPerHour) + " yên");
            rep_sms(ingame, "1h up được " + formatPercentX100(expPerHourPctX100) + "%");
            rep_sms(ingame, "Tổng up được " + formatNumberDot(yenTotal) + " yên trong " + elapsedText);
            rep_sms(ingame, "Tổng up được " + formatPercentX100(expPctX100) + "% exp trong " + elapsedText);
         }
         rep_sms(ingame, "Map up: " + TileMap.mapName + " khu " + TileMap.zoneID);
         rep_sms(ingame, "Yên hiện tại: " + formatNumberDot(my.yen));
         rep_sms(ingame, "Level hiện tại: " + formatCurrentLevel(my));
         if (pkam) {
            rep_sms(ingame, "Auto PK âm: " + menu_pkam.ptpk + "%");
         }
         if (mode instanceof AutoBuff) {
            rep_sms(ingame, "Auto buff: " + mode.toString());
         }
         if (MenuHangDong.autohd) {
            rep_sms(ingame, "Auto hang động: " + checkHangDongStatus());
         }
         if (KichYen.active) {
            rep_sms(ingame, "Kích yên: " + checkKichYenStatus());
         }
         if (FormDanhVong.isADanhVong) {
            rep_sms(ingame, "Auto danh vọng: " + formatScheduleTime(FormDanhVong.advAH, FormDanhVong.advAI));
         }
         if (isAutoNVHN) {
            rep_sms(ingame, "Auto NVHN: " + formatScheduleTime(nvhnHour, nvhnMin));
         }
         if (isADapDo) {
            rep_sms(ingame, "Auto đập đồ: " + checkDapDoStatus());
         }
         return;
      }
      if (noidung.equals("nst") && mode != null) {
         int var6 = Char.getMyChar().yen - mode.yen_before;
         int var7 = (int)((System.currentTimeMillis() - mode.time_start_auto) / 1000L);
         rep_sms(ingame, "Tôi 1h up được " + var6 / var7 * 3600 + " yên");
         long var8 = Char.getMyChar().cEXP - mode.level_before;
         int var15 = (int)((System.currentTimeMillis() - mode.time_start_auto) / 1000L);
         long var10 = var8 * 3600L / (long)var15;
         float var3 = (float)(var10 * 10000L / GameScr.exps[Char.getMyChar().cLevel]) / 100.0F;
         rep_sms(ingame, "Tôi 1h up được " + var3 + "%");
         rep_sms(ingame, "Map up: " + TileMap.mapName + " khu " + TileMap.zoneID);
         rep_sms(ingame, "Auto PK âm: " + (pkam ? "Có" : "Không"));
         rep_sms(ingame, "Auto hang động: " + (MenuHangDong.autohd ? "Có" : "Không"));
         rep_sms(ingame, String.format("Yên hiện tại: %,d", Char.getMyChar().yen));
         rep_sms(ingame, "Lever hiện tại: " + Char.getMyChar().cLevel);
      }
   }

   public static void chatnhom(String ingame, String noidung) {
      String[] arr = split_string(noidung, " ");
      if (!Auto.isLeader()) {
         if (arr[0].equals("ts")) {
            if (Char.getMyChar().cLevel < 90
                  && phong.Str2int(arr[1]) >= 157
                  && phong.Str2int(arr[1]) <= 159) {
               return;
            }

            if (mode instanceof AutoBuff
                  && (phong.Str2int(arr[1]) < 157 || phong.Str2int(arr[1]) > 159)) {
               mode.map_auto = phong.Str2int(arr[1]);
               mode.khu_auto = phong.Str2int(arr[2]);
               return;
            }

            autoTansat.run(phong.Str2int(arr[3]), phong.Str2int(arr[1]), phong.Str2int(arr[2]));
            autoTansat.danh_nhom = true; // member di theo nhom dung nghia (Kich Yen/AutoTansat thuong)
            addmode(autoTansat);
            return;
         }

         if (arr[0].equals("f")) {
            if (Char.getMyChar().nClass.a == 6) {
               runBuff(true, true);
            }
            return;
         }
         if (arr[0].equals("bux")) {
            if (Char.getMyChar().nClass.a == 6) {
               runBuff(true, false);
            }
            return;
         }

         if (arr[0].equals("dcvt")) {
            dcvt = Integer.parseInt(arr[1]) == 1;
            return;
         }

         if (arr[0].equals("avt")) {
            popup_chat("Thêm vị trí " + x_dcvt[TileMap.mapID].size() + " tại map " + TileMap.mapID);
            x_dcvt[TileMap.mapID].addElement(Integer.valueOf(arr[1]));
            y_dcvt[TileMap.mapID].addElement(Integer.valueOf(arr[2]));
            savevt();
            return;
         }

         if (arr[0].equals("dvt")) {
            popup_chat("Xoá tất cả vị trí tại map " + String.valueOf(TileMap.mapID));
            x_dcvt[TileMap.mapID].removeAllElements();
            y_dcvt[TileMap.mapID].removeAllElements();
            savevt();
            return;
         }

         if (mode != null) {
            if (arr[0].equals("khu")) {
               mode.khu_auto = phong.Str2int(arr[1]);
               return;
            }

            if (arr[0].equals("map")) {
               mode.map_auto = phong.Str2int(arr[1]);
               return;
            }
         }
      }

   }

   static {
      if (RMS.a("PhongGroup") != null) {
         try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(RMS.a("PhongGroup"));
            DataInputStream dataInputStream;
            if ((ig_lead = (dataInputStream = new DataInputStream(byteArrayInputStream)).readUTF()).equals("")) {
               ig_lead = null;
            }

            byte byte1 = dataInputStream.readByte();

            for(byte b = 0; b < byte1; ++b) {
               listParty.addElement(dataInputStream.readUTF());
            }

            dataInputStream.close();
            byteArrayInputStream.close();
         } catch (Exception var11) {
         }
      }

      loadAutoPt(); // AUTO-PT: load toggle+role từ RMS "autoPt"

      int var15;
      for(var15 = 0; var15 < arrItemDel.length; ++var15) {
         arrItemDel[var15] = -1;
      }

      for(var15 = 0; var15 < arrItemNhat.length; ++var15) {
         arrItemNhat[var15] = -1;
      }

      for(var15 = 0; var15 < x_dcvt.length; ++var15) {
         x_dcvt[var15] = new MyVector();
         y_dcvt[var15] = new MyVector();
      }

      if (RMS.b("nextmap") != null) {
         try {
            tdnm = Long.parseLong(RMS.b("nextmap"));
         } catch (Exception var10) {
         }
      }
      if (tdnm == 3000L) {
         tdnm = 200L;
         RMS.a("nextmap", "200");
      }

      if (RMS.b("speedGame") != null) {
         try {
            speedGame = Integer.parseInt(RMS.b("speedGame"));
         } catch (Exception var11) {
         }
      }

      if (RMS.b("hc_hlct") != null) {
         try {
            hc_hlct = Integer.parseInt(RMS.b("hc_hlct"));
         } catch (Exception var9) {
         }
      }

      if (RMS.b("delay_tele") != null) {
         try {
            delay_tele = Long.parseLong(RMS.b("delay_tele"));
         } catch (Exception var8) {
         }
      }

      if (RMS.b("time_tele_1") != null) {
         try {
            time_tele_1 = Long.parseLong(RMS.b("time_tele_1"));
         } catch (Exception var7) {
         }
      }

      if (RMS.b("time_lat_hinh") != null) {
         try {
            speedLh = Long.parseLong(RMS.b("time_lat_hinh"));
         } catch (Exception var6) {
         }
      }

      if (RMS.b("currentBG") != null) {
         try {
            currentBG = Integer.parseInt(RMS.b("currentBG"));
         } catch (Exception var5) {
         }
      }

      int savedFilterMode = RMS.c("filterMode");
      if (savedFilterMode >= 0 && savedFilterMode <= 3) {
         filterMode = savedFilterMode;
      } else {
         filterMode = 0;
         RMS.a("filterMode", 0);
      }

      if (RMS.b("SettingCave") != null) {
         String[] arr = split_string(RMS.b("SettingCave"), ";");

         try {
            MenuHangDong.gio_hd = Integer.parseInt(arr[0]);
            MenuHangDong.phut_hd = Integer.parseInt(arr[1]);
            MenuHangDong.gio_hd_lbhd = Integer.parseInt(arr[2]);
            MenuHangDong.phut_hd_lbhd = Integer.parseInt(arr[3]);
            if (arr.length >= 11) {
               MenuHangDong.map_nhom = Integer.parseInt(arr[4]);
               MenuHangDong.khu_nhom = Integer.parseInt(arr[5]);
               MenuHangDong.autohd = arr[6].equals("true");
               MenuHangDong.autohd_lbhd = arr[7].equals("true");
               autoDan = arr[8].equals("true");
               MenuHangDong.theoNhom = arr[9].equals("true");
               MenuHangDong.layRuong = arr[10].equals("true");
            }
         } catch (Exception var4) {
         }
      }

      loadvt();
      menu_pkam.load_pkam();
      AutoMapKhu.load();
      Setting.load();
      MenuPro.load();
      KichYen.loadKichYen();
      CaiGom.load();

      if (RMS.b("mobIDFilter") != null) {
         try {
            String[] mf = split_string(RMS.b("mobIDFilter"), ";");
            danhTheoID = mf[0].equals("1");
            for (int mi = 0; mi < mobIDFilter.length && mi + 1 < mf.length; mi++) {
               mobIDFilter[mi] = normalizeMobIDFilter(Integer.parseInt(mf[mi + 1]));
            }
         } catch (Exception e) {}
      }

      // DV init
      advCA = RMS.c("saveItem") == 1;
      FormDanhVong.advAA(); // Load DV config from RMS
      loadADapDoRMS();
      advCO = new AutoDanhVong();
      advAG = new AutoLoiWin();
      advAH = new AutoLoiLoss();

      // Auto Mua Item load
      try {
         String ami = RMS.b("autoMuaItem");
         if (ami != null && ami.length() > 0) {
            String[] ap = split_string(ami, ";");
            autoMuaItem = false; // luon tat khi mo game
            if (ap.length > 1) muaNpcTemplateID = Integer.parseInt(ap[1]);
            if (ap.length > 2) muaNpcID = Integer.parseInt(ap[2]);
            if (ap.length > 3) muaViTriItem = Integer.parseInt(ap[3]);
            if (ap.length > 4) muaSoLan = Integer.parseInt(ap[4]);
            if (ap.length > 5) muaItemID = Integer.parseInt(ap[5]);
         }
      } catch (Exception e) {}

      // Auto NPC load
      try {
         String anp = RMS.b("autoNPC");
         if (anp != null && anp.length() > 0) {
            String[] ap = split_string(anp, ";");
            if (ap.length > 0) autoNpcID = Integer.parseInt(ap[0]);
            if (ap.length > 1) autoNpcMenu1 = Integer.parseInt(ap[1]);
            if (ap.length > 2) autoNpcMenu2 = Integer.parseInt(ap[2]);
         }
      } catch (Exception e) {}

      // Auto On-Off load
      try {
         String aoo = RMS.b("autoOnOff");
         if (aoo != null && aoo.length() > 0) {
            String[] ap = split_string(aoo, ";");
            if (ap.length > 0) onoffOffHour = Integer.parseInt(ap[0]);
            if (ap.length > 1) onoffOffMin = Integer.parseInt(ap[1]);
            if (ap.length > 2) onoffOnHour = Integer.parseInt(ap[2]);
            if (ap.length > 3) onoffOnMin = Integer.parseInt(ap[3]);
         }
      } catch (Exception e) {}
   }

   // ======== Auto luyện ngọc — port NSOZ Code.java L928-965 ========
   public static boolean isLuyenNgoc(Item item) {
      return luyenngoc.contains(item);
   }

   public static void addLuyenNgoc(Item item) {
      if (item != null && !luyenngoc.contains(item)) {
         luyenngoc.addElement(item);
      }
   }

   public static void removeLuyenNgoc(Item item) {
      if (item != null) {
         luyenngoc.removeElement(item);
      }
   }

   private static void luyen_ngoc_tick() {
      if (luyenngoc.size() == 0) return;
      if (System.currentTimeMillis() - time_luyen_ngoc < 700L) return;
      if (Char.getMyChar() == null || Char.getMyChar().arrItemBag == null) return;

      if (GameScr.isOtherUIOpen_luyenngoc()
          || GameCanvas.af.a || GameCanvas.aj != null) {
         return;
      }

      Item[] _bag = Char.getMyChar().arrItemBag;

      for (int i = 0; i < luyenngoc.size(); ++i) {
         Item target = (Item) luyenngoc.elementAt(i);

         if (target == null || target.upgrade >= 10) {
            luyenngoc.removeElementAt(i--);
            continue;
         }

         if (target.indexUI < 0 || target.indexUI >= _bag.length
                 || _bag[target.indexUI] != target) {
            luyenngoc.removeElementAt(i--);
            continue;
         }

         int countRac = 0;
         for (int k = 0; k < _bag.length; ++k) {
            Item it = _bag[k];
            if (it != null && it != target
                    && (it.template.id == 652 || it.template.id == 653
                        || it.template.id == 654 || it.template.id == 655)
                    && it.upgrade == 1 && !it.isLock) {
               countRac++;
            }
         }

         if (countRac == 0) {
            luyenngoc.removeElementAt(i--);
            continue;
         }

         GameScr.gI().doOpenUI(46);
         GameScr.cj = target;
         GameScr.cb = new Item[24];

         int i1 = 0;
         for (int j = 0; j < _bag.length && i1 < 24; ++j) {
            Item it = _bag[j];
            if (it == null || it == target || it.upgrade != 1 || it.isLock) continue;
            if (it.template.id != 652 && it.template.id != 653
                && it.template.id != 654 && it.template.id != 655) continue;
            GameScr.cb[i1++] = it;
            _bag[it.indexUI] = null;
         }

         phong.sleep(600L);
         Service.gI().a((byte) 1, (Item) null, GameScr.cj, GameScr.cb);
         time_luyen_ngoc = System.currentTimeMillis();
         return;
      }
   }

   // ============================================================
   // AUTO ĐẬP ĐỒ — port từ TGAME
   // ============================================================

   private static boolean isItemDapDoOK(Item var0) {
      if (var0.template.type >= 0 && var0.template.type <= 9 && var0.template.id <= 780) {
         return var0.upgrade < CapDoValue && var0.q() >= CapDoValue && var0.upgrade < var0.q();
      } else {
         return false;
      }
   }

   private static boolean hasUpgradableBody() {
      Char c = Char.getMyChar();
      if (c == null || c.arrItemBody == null) return false;
      for (int i = 0; i < c.arrItemBody.length; ++i) {
         if (c.arrItemBody[i] != null && isItemDapDoOK(c.arrItemBody[i])) return true;
      }
      return false;
   }

   private static int[] getDapDoStoneTier(Item item) {
      int u = item.upgrade;
      upgrade_2 cs = upgrade_2.advAB();
      if (u == 15) {
         if ((item.r() || item.s()) && !item.t()) return new int[]{7};
         if (item.t())                            return new int[]{8};
         return null;
      }
      if (u >= 11 && u <= 14)   return new int[]{7};
      if (u == cs.advAK - 1)    return new int[]{cs.advAI};
      if (u == cs.advAN + 1)    return new int[]{cs.advAI};
      if (u == cs.advAM)        return new int[]{advCI};
      int lo, hi;
      if (u == cs.advAN) {
         if (item.r()) { lo = cs.advAI;      hi = cs.advAM; }
         else          { lo = cs.advAO - 10; hi = cs.advAI; }
      } else if (u == cs.advAI) {
         lo = cs.advAJ;         hi = cs.advAO - 10;
      } else if (u == cs.advAJ + 1) {
         lo = cs.advAJ;
         hi = item.r() ? cs.advAO - 10 : cs.advAJ;
      } else if (u == cs.advAJ) {
         lo = cs.advAH - 10;    hi = cs.advAJ;
      } else if (u == cs.advAH - 10) {
         lo = cs.advAL;         hi = cs.advAJ;
      } else if (u == cs.advAL) {
         lo = item.r() ? cs.advAG + 1 : cs.advAG;
         hi = cs.advAJ;
      } else {
         lo = cs.advAG;         hi = cs.advAJ;
      }
      int[] result = new int[hi - lo + 1];
      for (int i = 0; i < result.length; ++i) result[i] = lo + i;
      return result;
   }

   private static boolean canDapDoBatchProgress(int targetUpgrade, int stoneId) {
      Char c = Char.getMyChar();
      if (c == null || c.arrItemBody == null || c.arrItemBag == null) return false;
      upgrade_2 cs = upgrade_2.advAB();
      int matsSum = 0;
      int yenSum  = 0;
      int itemCount = 0;
      for (int i = 0; i < c.arrItemBody.length; ++i) {
         Item item = c.arrItemBody[i];
         if (item == null || item.upgrade != targetUpgrade || !isItemDapDoOK(item)) continue;
         ++itemCount;
         yenSum += new upgrade_1(item).advAB;
         int u = targetUpgrade;
         int contrib = 0;
         if (u == 15) {
            if      (item.r() && stoneId == 7) contrib = 4;
            else if (item.s() && stoneId == 7) contrib = 5;
            else if (item.t() && stoneId == 8) contrib = 4;
         } else if (u == 14) {
            if      (item.r()) contrib = 2;
            else if (item.s()) contrib = 3;
            else if (item.t()) contrib = 7;
         } else if (u == 13) {
            if      (item.r()) contrib = 1;
            else if (item.s()) contrib = 2;
            else if (item.t()) contrib = 5;
         } else if (u == 12) {
            if      (item.r()) contrib = 1;
            else if (item.s()) contrib = 2;
            else if (item.t()) contrib = 4;
         } else if (u == 11) {
            if      (item.r()) contrib = 1;
            else if (item.s()) contrib = 2;
            else if (item.t()) contrib = 5;
         } else if (u == cs.advAK - 1) {
            if      (item.t()) contrib = cs.advAG + 1;
            else if (item.s()) contrib = cs.advAL;
            else if (item.r()) contrib = cs.advAJ;
         } else if (u == cs.advAN + 1) {
            if (!item.t() && !item.s() && item.r()) contrib = cs.advAH - 10;
            else if (item.t() || item.s())           contrib = cs.advAL - 1;
         } else if (u == cs.advAM) {
            if (stoneId == cs.advAI) {
               if (!item.t() && !item.s() && item.r()) contrib = cs.advAL;
               else                                      contrib = cs.advAG + 1;
            } else if (item.t()) contrib = cs.advAL;
            else if (item.s())   contrib = cs.advAH - 10;
            else if (item.r())   contrib = cs.advAM;
         }
         matsSum += contrib;
      }
      if (itemCount == 0 || matsSum <= 0) return false;
      if (yenSum > c.yen)                  return false;
      int stoneCount = 0;
      for (int i = 0; i < c.arrItemBag.length; ++i) {
         Item bag = c.arrItemBag[i];
         if (bag != null && bag.template != null
                 && bag.template.type == 26 && bag.template.id == stoneId) {
            ++stoneCount;
         }
      }
      return stoneCount >= matsSum;
   }

   private static boolean canDapDoMakeProgress() {
      if (!isADapDo) return false;
      Char c = Char.getMyChar();
      if (c == null || c.arrItemBody == null || c.arrItemBag == null) return false;
      if (c.ctaskId <= 9) return false;
      if (solg_hanhtrang() <= 0) return false;
      Item target = null;
      for (int i = 0; i < c.arrItemBody.length; ++i) {
         Item it = c.arrItemBody[i];
         if (it != null && isItemDapDoOK(it)) {
            if (target == null || it.upgrade < target.upgrade) target = it;
         }
      }
      if (target == null) return false;
      int[] tier = getDapDoStoneTier(target);
      if (tier == null || tier.length == 0) return false;
      upgrade_2 cs = upgrade_2.advAB();
      int u = target.upgrade;
      boolean isThreshold = (u == 15)
                         || (u >= 11 && u <= 14)
                         || (u == cs.advAK - 1)
                         || (u == cs.advAN + 1)
                         || (u == cs.advAM);
      if (isThreshold) {
         for (int j = 0; j < tier.length; ++j) {
            if (canDapDoBatchProgress(u, tier[j])) return true;
         }
      } else {
         upgrade_1 cost = new upgrade_1(target);
         int owned = 0;
         for (int i = 0; i < c.arrItemBag.length; ++i) {
            Item bag = c.arrItemBag[i];
            if (bag == null || bag.template == null || bag.template.type != 26) continue;
            for (int j = 0; j < tier.length; ++j) {
               if (bag.template.id == tier[j]) {
                  owned += GameScr.cx[bag.template.id];
                  break;
               }
            }
         }
         if (cost.advAA > 0
                 && (long) owned * 100L >= (long) cost.advAA * (long) cost.advAC
                 && cost.advAB <= c.yen) {
            return true;
         }
      }
      int minTier = Integer.MAX_VALUE;
      for (int j = 0; j < tier.length; ++j) if (tier[j] < minTier) minTier = tier[j];
      if (minTier > 0) {
         for (int level = 0; level < minTier; ++level) {
            int stoneCount = 0;
            for (int i = 0; i < c.arrItemBag.length; ++i) {
               Item bag = c.arrItemBag[i];
               if (bag != null && bag.template != null
                       && bag.template.type == 26 && bag.template.id == level) {
                  stoneCount += bag.template.isUpToUp ? bag.quantity : 1;
               }
            }
            if (stoneCount >= 4 && level < GameScr.db.length && c.yen >= GameScr.db[level]) {
               return true;
            }
         }
      }
      return false;
   }

   private static boolean dapDoVerifyEquip(int slot, short tmplId, boolean lock, boolean expires, long deadline) {
      while (System.currentTimeMillis() < deadline) {
         Item body = Char.getMyChar().arrItemBody[slot];
         if (body != null && body.template != null && body.template.type == slot
                 && body.template.id == tmplId && body.isLock == lock && body.isExpires == expires) {
            return true;
         }
         try { Thread.sleep(150L); } catch (Throwable t) {}
      }
      return false;
   }

   private static int findInBagByFingerprint(int slot, short tmplId, boolean lock, boolean expires) {
      Item[] bag = Char.getMyChar().arrItemBag;
      for (int i = 0; i < bag.length; ++i) {
         Item it = bag[i];
         if (it != null && it.template != null && it.template.type == slot
                 && it.template.id == tmplId && it.isLock == lock && it.isExpires == expires) {
            return it.indexUI;
         }
      }
      return -1;
   }

   private static int computeDapDoProgressSig() {
      Char c = Char.getMyChar();
      if (c == null || c.arrItemBody == null || c.arrItemBag == null) return 0;
      int upSum = 0;
      for (int i = 0; i < c.arrItemBody.length; ++i) {
         Item it = c.arrItemBody[i];
         if (it != null) upSum += it.upgrade;
      }
      int stoneCount = 0;
      for (int i = 0; i < c.arrItemBag.length; ++i) {
         Item bag = c.arrItemBag[i];
         if (bag != null && bag.template != null && bag.template.type == 26) {
            stoneCount += bag.template.isUpToUp ? bag.quantity : 1;
         }
      }
      return upSum + stoneCount * 1000;
   }

   private static boolean shouldHoldDapDo() {
      if (!dapDoHoldActive) return false;
      if (!isADapDo)                    { dapDoHoldActive = false; return false; }
      if (mode instanceof AutoDanhVong) { dapDoHoldActive = false; return false; }
      if (filterMode == 3)              { dapDoHoldActive = false; return false; }
      if (isPkMode())                   { dapDoHoldActive = false; return false; }
      if (!(TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID))) return false;
      if (!canDapDoMakeProgress()) {
         dapDoHoldActive = false;
         return false;
      }
      long nowMs = System.currentTimeMillis();
      int sig = computeDapDoProgressSig();
      if (sig != dapDoLastProgressSig) {
         dapDoLastProgressTime = nowMs;
         dapDoLastProgressSig = sig;
         return true;
      }
      if (nowMs - dapDoLastProgressTime > DAPDO_HOLD_TIMEOUT_MS) {
         dapDoHoldActive = false;
         return false;
      }
      return true;
   }

   private static void tryTriggerDapDoReturn() {
      if (!isADapDo) return;
      if (mode instanceof AutoDanhVong) return;
      if (filterMode == 3) return;
      if (isPkMode()) return;
      Char c = Char.getMyChar();
      if (c == null || c.cHP <= 0) return;
      if (c.ctaskId <= 9) return;
      if (TileMap.isLang(TileMap.mapID)
              || TileMap.isTruong(TileMap.mapID)
              || TileMap.isLangCo(TileMap.mapID)) return;
      if (solg_hanhtrang() > 3) return;
      if (!canDapDoMakeProgress()) return;
      long now = System.currentTimeMillis();
      if (now - dapDoReturnLastTime < DAPDO_RETURN_COOLDOWN_MS) return;
      dapDoReturnLastTime = now;
      dapDoHoldActive = true;
      dapDoLastProgressTime = now;
      dapDoLastProgressSig = computeDapDoProgressSig();
      Auto.tusat_vdmq();
      Auto.hoisinh(false);     // [FIX 7] về luôn không chờ quạt, mirror AutoDanhVong:1229
   }

   private static void buyDa(int targetTier, boolean forceLuyen) {
      Char c = Char.getMyChar();
      if (c == null || c.arrItemBag == null) return;
      if (solg_hanhtrang() <= 0 || c.ctaskId <= 9) return;
      // Guard: chỉ tiếp tục nếu có ít nhất 1 tier đá đủ 4 viên để luyện (mirror TGAME var10000 check)
      boolean hasEnough = false;
      for (int ti = 0; ti < targetTier; ++ti) {
         int cnt = 0;
         for (int i = 0; i < c.arrItemBag.length; ++i) {
            Item it = c.arrItemBag[i];
            if (it != null && it.template.id == ti) {
               cnt += (it.template.isUpToUp ? it.quantity : 1);
            }
         }
         if (cnt >= 4) { hasEnough = true; break; }
      }
      if (!hasEnough) return;
      boolean wasTruong = TileMap.isTruong(TileMap.mapID);
      // Nếu ở Trường và có đá đủ: dùng item tốc hành sang Làng trước (port TGAME buyDa Trường branch)
      if (wasTruong) {
         Item tpItem = null;
         for (int i = 0; i < c.arrItemBag.length; ++i) {
            Item it = c.arrItemBag[i];
            if (it != null && it.template.id == 37) { tpItem = it; break; }
         }
         if (tpItem == null) {
            for (int i = 0; i < c.arrItemBag.length; ++i) {
               Item it = c.arrItemBag[i];
               if (it != null && it.template.id == 35) { tpItem = it; break; }
            }
         }
         if (tpItem == null) {
            GameScr.npc_b(4, 0, 0);
            Service.gI().a(9, 6, 1);
            LockGame.advAG();
            phong1.aWait(100L);
            for (int i = 0; i < c.arrItemBag.length; ++i) {
               Item it = c.arrItemBag[i];
               if (it != null && it.template.id == 35) { tpItem = it; break; }
            }
         }
         if (tpItem != null) {
            Service.gI().h(tpItem.indexUI, 5);
            phong1.aWait(2000L);
         }
      }
      if (!TileMap.isLang(TileMap.mapID)) return;
      GameScr.npc_b(6, 1, 1);
      phong1.aWait(2000L);
      MyVector var32 = new MyVector();
      for (int var9 = 0; var9 < targetTier; ++var9) {
         var32.removeAllElements();
         Item var33;
         for (int var8 = 0; var8 < c.arrItemBag.length; ++var8) {
            if ((var33 = c.arrItemBag[var8]) != null && var33.template.id == var9) {
               var32.addElement(var33);
            }
         }
         while (var32.size() >= 4) {
            int mult = 1;
            int var14;
            for (var14 = var9; var14 < targetTier && GameScr.db[var14] <= c.yen && mult << 2 <= var32.size() && mult < 16; ++var14) {
               mult <<= 2;
            }
            if (mult == 1) break;
            GameScr.bz = new Item[24];
            for (var14 = 0; var14 < mult; ++var14) {
               var33 = (Item) var32.elementAt(0);
               GameScr.bz[var14] = var33;
               c.arrItemBag[var33.indexUI] = null;
               var32.removeElementAt(0);
            }
            Service.gI().b(GameScr.bz);
            phong1.aWait(2000L);
            if (GameScr.bz[0] != null) {
               c.arrItemBag[GameScr.bz[0].indexUI] = GameScr.bz[0];
            }
         }
      }
      GameCanvas.j();
      if (forceLuyen && solg_ruong() > 0) {
         if (c.arrItemBox == null) {
            Service.gI().i(4);
            phong1.aWait(7000L);
         }
         for (int var5 = 0; var5 < c.arrItemBag.length; ++var5) {
            Item var13;
            if ((var13 = c.arrItemBag[var5]) != null && var13.template.id == targetTier && solg_ruong() > 0) {
               Service.gI().e(var13.indexUI);
               phong1.aWait(2000L);
            }
         }
         GameCanvas.j();
      }
      Service.gI().f();
      phong1.aWait(2000L);
      if (forceLuyen && c.luyen_da) {
         GameScr.gI().ar();
         Service.gI().f();
         GameScr.gI().v();
      }
      if (wasTruong) Auto.tusat_vdmq();
   }

   private static void advAE_dapdo(int var0, int var1) {
      MyVector var2 = new MyVector();
      int var3 = 0;
      int var4 = 0;
      for (int var5 = 0; var5 < Char.getMyChar().arrItemBody.length; ++var5) {
         Item var6 = Char.getMyChar().arrItemBody[var5];
         if (var6 != null && var6.upgrade == var0 && isItemDapDoOK(var6)) {
            var2.addElement(var6);
            upgrade_1 var7 = new upgrade_1(var6);
            var4 += var7.advAB;
            if (var0 == 15) {
               if (var6.r() && var1 == 7)      var3 += 4;
               else if (var6.s() && var1 == 7) var3 += 5;
               else if (var6.t() && var1 == 8) var3 += 4;
            }
            if (var0 == 14) {
               if (var6.r())      var3 += 2;
               else if (var6.s()) var3 += 3;
               else if (var6.t()) var3 += 7;
            }
            if (var0 == 13) {
               if (var6.r())      ++var3;
               else if (var6.s()) var3 += 2;
               else if (var6.t()) var3 += 5;
            }
            if (var0 == 12) {
               if (var6.r())      ++var3;
               else if (var6.s()) var3 += 2;
               else if (var6.t()) var3 += 4;
            }
            if (var0 == 11) {
               if (var6.r())      ++var3;
               else if (var6.s()) var3 += 2;
               else if (var6.t()) var3 += 5;
            }
            if (var0 == upgrade_2.advAB().advAK - 1) {
               if (var6.t())      var3 += upgrade_2.advAB().advAG + 1;
               else if (var6.s()) var3 += upgrade_2.advAB().advAL;
               else if (var6.r()) var3 += upgrade_2.advAB().advAJ;
            } else if (var0 == upgrade_2.advAB().advAN + 1) {
               if (!var6.t() && !var6.s() && var6.r()) var3 += upgrade_2.advAB().advAH - 10;
               else if (var6.t() || var6.s())           var3 += upgrade_2.advAB().advAL - 1;
            } else if (var0 == upgrade_2.advAB().advAM) {
               if (var1 == upgrade_2.advAB().advAI) {
                  if (!var6.t() && !var6.s() && var6.r()) var3 += upgrade_2.advAB().advAL;
                  else                                      var3 += upgrade_2.advAB().advAG + 1;
               } else if (var6.t()) var3 += upgrade_2.advAB().advAL;
               else if (var6.s())   var3 += upgrade_2.advAB().advAH - 10;
               else if (var6.r())   var3 += upgrade_2.advAB().advAM;
            }
         }
      }
      int var8 = 0;
      for (int var9 = 0; var9 < Char.getMyChar().arrItemBag.length; ++var9) {
         Item var10 = Char.getMyChar().arrItemBag[var9];
         if (var10 != null && var10.template.type == 26 && var10.template.id == var1) {
            ++var8;
         }
      }
      if (var3 > 0 && var8 >= var3 && var4 <= Char.getMyChar().yen) {
         if (TileMap.isTruong(TileMap.mapID)) {
            Item var6t = null;
            for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
               Item it = Char.getMyChar().arrItemBag[i];
               if (it != null && it.template.id == 37) { var6t = it; break; }
            }
            if (var6t == null) {
               for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
                  Item it = Char.getMyChar().arrItemBag[i];
                  if (it != null && it.template.id == 35) { var6t = it; break; }
               }
            }
            if (var6t == null) {
               GameScr.npc_b(4, 0, 0);
               Service.gI().a(9, 6, 1);
               LockGame.advAG();
               phong.sleep(100L);
               for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
                  Item it = Char.getMyChar().arrItemBag[i];
                  if (it != null && it.template.id == 35) { var6t = it; break; }
               }
            }
            if (var6t != null) {
               Service.gI().h(var6t.indexUI, 5);
               phong1.aWait(2000L);
            }
         }
         if (TileMap.isLang(TileMap.mapID)) {
            for (int vi = 0; vi < var2.size(); ++vi) {
               Item var6 = (Item) var2.elementAt(vi);
               upgrade_1 var11 = new upgrade_1(var6);
               int var4b = var11.advAA;
               int var5b = var11.advAB;
               int var3b = var11.advAC;
               int var8b = 0;
               for (int var9 = 0; var9 < Char.getMyChar().arrItemBag.length; ++var9) {
                  Item var10 = Char.getMyChar().arrItemBag[var9];
                  if (var10 != null && var10.template.type == 26 && var10.template.id == var1) {
                     var8b += GameScr.cx[var10.template.id];
                  }
               }
               if (var4b > 0 && (float) (var8b * 100 / var4b) >= (float) var3b && var5b <= Char.getMyChar().yen) {
                  GameScr.indexSelect = var6.indexUI;
                  dapDoWaitingUnequip = true;
                  Service.gI().b(var6.indexUI);
                  Item var12;
                  if (!LockGame.advAQ() || advCH < 0 || (var12 = Char.getMyChar().arrItemBag[advCH]) == null) {
                     if (advCH >= 0) {
                        var12 = Char.getMyChar().arrItemBag[advCH];
                        advCH = -1;
                        if (var12 != null && var12.template.id == var6.template.id) {
                           Service.gI().useItem(var12.indexUI);
                           LockGame.advAQ();
                        }
                     }
                     return;
                  }
                  advCH = -1;
                  GameScr.npc_b(6, 0, 0);
                  LockGame.advAQ();
                  GameScr.ci = var12;
                  Char.getMyChar().arrItemBag[var12.indexUI] = null;
                  GameScr.ca = new Item[18];
                  int var5c = 0;
                  int var13 = 0;
                  float var14 = 0.0F;
                  for (int var9 = 0; var9 < Char.getMyChar().arrItemBag.length; ++var9) {
                     Item var10 = Char.getMyChar().arrItemBag[var9];
                     if (var10 != null && var10.template.type == 26 && var10.template.id == var1) {
                        GameScr.indexSelect = var10.indexUI;
                        GameScr.ca[var5c] = var10;
                        Char.getMyChar().arrItemBag[var9] = null;
                        var13 += GameScr.cx[var10.template.id];
                        var14 = (float) (var13 * 100 / var4b);
                        if (var14 >= (float) var3b || var5c >= 17) {
                           break;
                        }
                        ++var5c;
                     }
                  }
                  if (var14 > 0.0F) {
                     phong.sleep(1000L);
                     Service.gI().a(GameScr.ci, GameScr.ca, false);
                     if (LockGame.advAQ()) {
                        phong.sleep(1000L);
                     }
                  }
                  if (GameScr.aa()) {
                     GameScr.gI().v();
                  }
                  Item wearItem = Char.getMyChar().arrItemBag[var12.indexUI];
                  if (wearItem != null) {
                     int expectSlot = wearItem.template.type;
                     short expectTmplId = wearItem.template.id;
                     boolean expectLock = wearItem.isLock;
                     boolean expectExpires = wearItem.isExpires;
                     GameScr.indexSelect = wearItem.indexUI;
                     Service.gI().useItem(wearItem.indexUI);
                     LockGame.advAQ();
                     boolean ok = dapDoVerifyEquip(expectSlot, expectTmplId, expectLock, expectExpires, System.currentTimeMillis() + 2500L);
                     for (int retry = 0; !ok && retry < 2; ++retry) {
                        int bagIdx = findInBagByFingerprint(expectSlot, expectTmplId, expectLock, expectExpires);
                        if (bagIdx < 0) {
                           ok = dapDoVerifyEquip(expectSlot, expectTmplId, expectLock, expectExpires, System.currentTimeMillis() + 500L);
                           break;
                        }
                        GameScr.indexSelect = bagIdx;
                        Service.gI().useItem(bagIdx);
                        LockGame.advAQ();
                        ok = dapDoVerifyEquip(expectSlot, expectTmplId, expectLock, expectExpires, System.currentTimeMillis() + 2000L);
                     }
                     if (!ok) return;
                     phong.sleep(1000L);
                  }
               }
            }
         }
      } else {
         buyDa(var1, false);
      }
   }

   private static void advAZ() {
      advCH = -1;
      dapDoWaitingUnequip = false;
      while (true) {
         int var7 = 0;
         Item var10000;
         while (true) {
            if (var7 >= Char.getMyChar().arrItemBody.length) {
               var10000 = null;
               break;
            }
            if (Char.getMyChar().arrItemBody[var7] != null && isItemDapDoOK(Char.getMyChar().arrItemBody[var7])) {
               Item var8 = Char.getMyChar().arrItemBody[var7];
               for (int var9 = var7 + 1; var9 < Char.getMyChar().arrItemBody.length; ++var9) {
                  if (Char.getMyChar().arrItemBody[var9] != null && isItemDapDoOK(Char.getMyChar().arrItemBody[var9])
                          && Char.getMyChar().arrItemBody[var9].upgrade < var8.upgrade) {
                     var8 = Char.getMyChar().arrItemBody[var9];
                  }
               }
               var10000 = var8;
               break;
            }
            ++var7;
         }
         Item var0 = var10000;
         if (var10000 == null) {
            if (Char.luyen_da) {
               buyDa(Char.lv_luyenda - 1, true);
            }
            return;
         }
         if (var0.upgrade == 15) {
            if ((var0.r() || var0.s()) && !var0.t()) advAE_dapdo(var0.upgrade, 7);
            if (var0.t())                            advAE_dapdo(var0.upgrade, 8);
            return;
         }
         if (var0.upgrade >= 11 && var0.upgrade <= 14) {
            advAE_dapdo(var0.upgrade, 7);
            return;
         }
         if (var0.upgrade == upgrade_2.advAB().advAK - 1) {
            advAE_dapdo(var0.upgrade, upgrade_2.advAB().advAI);
            return;
         }
         if (var0.upgrade == upgrade_2.advAB().advAN + 1) {
            advAE_dapdo(var0.upgrade, upgrade_2.advAB().advAI);
            return;
         }
         if (var0.upgrade == upgrade_2.advAB().advAM) {
            advAE_dapdo(var0.upgrade, advCI);
            return;
         }
         int var2;
         int var3;
         if (var0.upgrade == upgrade_2.advAB().advAN) {
            if (var0.r()) {
               var2 = upgrade_2.advAB().advAI;
               var3 = upgrade_2.advAB().advAM;
            } else {
               var2 = upgrade_2.advAB().advAO - 10;
               var3 = upgrade_2.advAB().advAI;
            }
         } else if (var0.upgrade == upgrade_2.advAB().advAI) {
            var2 = upgrade_2.advAB().advAJ;
            var3 = upgrade_2.advAB().advAO - 10;
         } else if (var0.upgrade == upgrade_2.advAB().advAJ + 1) {
            var2 = upgrade_2.advAB().advAJ;
            var3 = var0.r() ? upgrade_2.advAB().advAO - 10 : upgrade_2.advAB().advAJ;
         } else if (var0.upgrade == upgrade_2.advAB().advAJ) {
            var2 = upgrade_2.advAB().advAH - 10;
            var3 = upgrade_2.advAB().advAJ;
         } else if (var0.upgrade == upgrade_2.advAB().advAH - 10) {
            var2 = upgrade_2.advAB().advAL;
            var3 = upgrade_2.advAB().advAJ;
         } else if (var0.upgrade == upgrade_2.advAB().advAL) {
            var2 = var0.r() ? upgrade_2.advAB().advAG + 1 : upgrade_2.advAB().advAG;
            var3 = upgrade_2.advAB().advAJ;
         } else {
            var2 = upgrade_2.advAB().advAG;
            var3 = upgrade_2.advAB().advAJ;
         }
         upgrade_1 var1 = new upgrade_1(var0);
         int var4 = var1.advAA;
         int var5 = var1.advAB;
         int var6 = var1.advAC;
         int var15 = 0;
         for (int var9 = 0; var9 < Char.getMyChar().arrItemBag.length; ++var9) {
            Item var10 = Char.getMyChar().arrItemBag[var9];
            if (var10 != null && var10.template.type == 26 && var10.template.id >= var2 && var10.template.id <= var3) {
               var15 += GameScr.cx[var10.template.id];
            }
         }
         if (var4 > 0 && (float) (var15 * 100 / var4) >= (float) var6 && var5 <= Char.getMyChar().yen) {
            GameScr.indexSelect = var0.indexUI;
            dapDoWaitingUnequip = true;
            Service.gI().b(var0.indexUI);
            Item var12;
            if (LockGame.advAQ() && advCH >= 0 && (var12 = Char.getMyChar().arrItemBag[advCH]) != null) {
               advCH = -1;
               if (TileMap.isTruong(TileMap.mapID)) {
                  Item teleItem = null;
                  for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
                     Item it = Char.getMyChar().arrItemBag[i];
                     if (it != null && it.template.id == 37) { teleItem = it; break; }
                  }
                  if (teleItem == null) {
                     for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
                        Item it = Char.getMyChar().arrItemBag[i];
                        if (it != null && it.template.id == 35) { teleItem = it; break; }
                     }
                  }
                  if (teleItem == null) {
                     GameScr.npc_b(4, 0, 0);
                     Service.gI().a(9, 6, 1);
                     LockGame.advAG();
                     phong.sleep(100L);
                     for (int i = 0; i < Char.getMyChar().arrItemBag.length; ++i) {
                        Item it = Char.getMyChar().arrItemBag[i];
                        if (it != null && it.template.id == 35) { teleItem = it; break; }
                     }
                  }
                  if (teleItem != null) {
                     Service.gI().h(teleItem.indexUI, 5);
                     phong1.aWait(2000L);
                  }
               }
               if (TileMap.isLang(TileMap.mapID)) {
                  GameScr.npc_b(6, 0, 0);
                  LockGame.advAQ();
                  GameScr.ci = var12;
                  Char.getMyChar().arrItemBag[var12.indexUI] = null;
                  GameScr.ca = new Item[18];
                  int var13 = 0;
                  var5 = 0;
                  float var14 = 0.0F;
                  for (int var9 = 0; var9 < Char.getMyChar().arrItemBag.length; ++var9) {
                     Item var16 = Char.getMyChar().arrItemBag[var9];
                     if (var16 != null && var16.template.type == 26 && var16.template.id >= var2 && var16.template.id <= var3) {
                        GameScr.indexSelect = var16.indexUI;
                        GameScr.ca[var13] = var16;
                        Char.getMyChar().arrItemBag[var9] = null;
                        var5 += GameScr.cx[var16.template.id];
                        var14 = (float) (var5 * 100 / var4);
                        if (var14 >= (float) var6 || var13 >= 17) {
                           break;
                        }
                        ++var13;
                     }
                  }
                  if (var14 > 0.0F) {
                     phong.sleep(1000L);
                     Service.gI().a(GameScr.ci, GameScr.ca, false);
                     if (LockGame.advAQ()) {
                        phong.sleep(1000L);
                     }
                  }
                  if (GameScr.aa()) {
                     GameScr.gI().v();
                  }
                  Item wearItem = Char.getMyChar().arrItemBag[var12.indexUI];
                  if (wearItem != null) {
                     int expectSlot = wearItem.template.type;
                     short expectTmplId = wearItem.template.id;
                     boolean expectLock = wearItem.isLock;
                     boolean expectExpires = wearItem.isExpires;
                     GameScr.indexSelect = wearItem.indexUI;
                     Service.gI().useItem(wearItem.indexUI);
                     LockGame.advAQ();
                     boolean ok = dapDoVerifyEquip(expectSlot, expectTmplId, expectLock, expectExpires, System.currentTimeMillis() + 2500L);
                     for (int retry = 0; !ok && retry < 2; ++retry) {
                        int bagIdx = findInBagByFingerprint(expectSlot, expectTmplId, expectLock, expectExpires);
                        if (bagIdx < 0) {
                           ok = dapDoVerifyEquip(expectSlot, expectTmplId, expectLock, expectExpires, System.currentTimeMillis() + 500L);
                           break;
                        }
                        GameScr.indexSelect = bagIdx;
                        Service.gI().useItem(bagIdx);
                        LockGame.advAQ();
                        ok = dapDoVerifyEquip(expectSlot, expectTmplId, expectLock, expectExpires, System.currentTimeMillis() + 2000L);
                     }
                     if (!ok) return;
                     phong.sleep(1000L);
                     continue;
                  }
                  return;
               }
            } else if (advCH >= 0) {
               Item var12r = Char.getMyChar().arrItemBag[advCH];
               advCH = -1;
               if (var12r != null && var12r.template.id == var0.template.id) {
                  Service.gI().useItem(var12r.indexUI);
                  LockGame.advAQ();
                  return;
               }
            }
         } else if (var2 > 0) {
            buyDa(var2, false);
         }
         return;
      }
   }
}
