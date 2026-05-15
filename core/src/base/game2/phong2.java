package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;
import javax.microedition.lcdui.Display;
import base.game2.screen.ScreenManager;
import base.game2.screen.ScreenSettingSkill;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application;

public class phong2 {
   private static phong2 getphong2;
   public static MyVector listquai = new MyVector();
   public static boolean isItemDel = false;
   public static boolean isItemPick = false;
   public static int solgmoall = 0;
   public static long speedAll = 100L;

   // [SIZE-PC] Size cua so PC — luu/doc o cwd
   public static String pcSizeLabel = "1280x720";
   public static int pcPendingW = 0;
   public static int pcPendingH = 0;

   public static phong2 gI() {
      if (getphong2 == null) {
         getphong2 = new phong2();
      }

      return getphong2;
   }

   public static void show_menuauto() {
      MyVector vector = new MyVector();
      if (Code.mode != null) {
         vector.addElement(new Command1("Tắt Auto", 103));
      } else {
         vector.addElement(new Command1("Tàn sát", 106));
      }

      vector.addElement(new Command1("NPC", 114));
      vector.addElement(new Command1("Lọc Đồ: " + Code.filterModeText(), 136));

      vector.addElement(new Command1("Item Nhặt", 119));
      vector.addElement(new Command1("Item Del", 118));
      vector.addElement(new Command1("Chặn Spam", 140));
      vector.addElement(new Command1("Ưu Tiên", 141));
      vector.addElement(new Command1("Độ Trễ Tele: " + Code.delay_tele + "ms", 151));
      vector.addElement(new Command1("KC 2 Lần Tele: " + Code.time_tele_1 + "ms", 152));
      vector.addElement(new Command1(Code.kc_nhat > 0 ? "KC Nhặt: " + Code.kc_nhat : "KC Nhặt", 121));
      vector.addElement(new Command1(Code.kcts > 0 ? "KC Đánh: " + Code.kcts : "KC Đánh", 122));
      vector.addElement(new Command1("Đánh CVT: " + (Code.dcvt ? "Bật" : "Tắt"), 123));
      vector.addElement(new Command1("Đánh CK: " + (Code.dck ? "Bật" : "Tắt"), 124));
      vector.addElement(new Command1("SPNextMap: " + Code.tdnm, 126));
      vector.addElement(new Command1("Speed game: " + Code.speedGame, 12700));
      vector.addElement(new Command1(TextGame.nr[7], 1100068));
      GameCanvas.af.a(vector);
   }

   private static void show_setting() {
      MyVector vector = new MyVector();
      vector.addElement(new Command1("PK Âm", 128));
      vector.addElement(new Command1("PK Người", 154));
      vector.addElement(new Command1("List PK", 139));
      vector.addElement(new Command1("List Không PK", 138));
      GameCanvas.af.a(vector);
   }

   public static void menu_nvct() {
      MyVector vector = new MyVector();
      vector.addElement(new Command1("AUTO 10", 1111));
      vector.addElement(new Command1("AUTO 20", 1112));
      vector.addElement(new Command1("AUTO 49", 1113));
      vector.addElement(new Command1("AUTO 53", 1114));
      vector.addElement(new Command1("AUTO 55", 1115));
      GameCanvas.af.a(vector);
   }

   public static void menu_lau() {
      MyVector vector = new MyVector();
      vector.addElement(new Command1("Auto Lật Hình", 158));
      vector.addElement(new Command1("Auto Mua Item", 1805));
      vector.addElement(new Command1("Auto NPC", 1806));
      vector.addElement(new Command1("Auto On-Off", 1807));
      vector.addElement(new Command1("Mở Item: " + speedAll + "ms", 150));
      vector.addElement(new Command1("Time Sleep: " + com.monkey.nso.SleepManager.timeoutMinutes + "phút", 1600));
      // [SIZE-PC] lop 1: chi add nut tren Desktop, dat ngay sau Time Sleep
      if (Gdx.app != null && Gdx.app.getType() == Application.ApplicationType.Desktop) {
         vector.addElement(new Command1("Chọn size PC: " + pcSizeLabel, 1905));
      }
      vector.addElement(new Command1("Hiện Tinh Luyện: " + (Code.isShowTL ? "Bật" : "Tắt"), 156));
      // vector.addElement(new Command1("Giao Diện", 157));
      vector.addElement(new Command1("Fake Skill" + (Code.fakeSkill ? " [" + Code.fakeSkillId + "]" : ""), 1803));
      vector.addElement(new Command1("Chặn tin nhắn", 12006));
      GameCanvas.af.a(vector);
   }

   // [SIZE-PC] Menu con 3 preset
   public static void show_menu_size_pc() {
      MyVector vector = new MyVector();
      vector.addElement(new Command1("Nhỏ (1020x597)", 1906));
      vector.addElement(new Command1("Vừa (1280x720)", 1907));
      vector.addElement(new Command1("Lớn (1600x900)", 1908));
      GameCanvas.af.a(vector);
   }

   // [SIZE-PC] Ghi file pcWindowSize.txt o cwd
   private static boolean writePcWindowSize(int w, int h) {
      try {
         java.io.File f = new java.io.File("pcWindowSize.txt");
         java.io.FileWriter wr = new java.io.FileWriter(f, false);
         wr.write(w + "x" + h);
         wr.close();
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   // [SIZE-PC] Doc label size hien tai tu file
   private static String readPcSizeLabel() {
      try {
         java.io.File f = new java.io.File("pcWindowSize.txt");
         if (!f.exists()) return "1280x720";
         java.io.BufferedReader r = new java.io.BufferedReader(new java.io.FileReader(f));
         String line = r.readLine();
         r.close();
         if (line == null) return "1280x720";
         line = line.trim().toLowerCase();
         int x = line.indexOf('x');
         if (x <= 0) return "1280x720";
         int w = Integer.parseInt(line.substring(0, x).trim());
         int h = Integer.parseInt(line.substring(x + 1).trim());
         if (w < 640 || h < 360 || w > 4096 || h > 2160) return "1280x720";
         return w + "x" + h;
      } catch (Exception e) {
         return "1280x720";
      }
   }

   // [SIZE-PC] Xu ly click preset: so sanh, ghi file, show confirm dialog
   private static void handlePcSizePick(int w, int h) {
      if (Gdx.app == null || Gdx.app.getType() != Application.ApplicationType.Desktop) return;
      String newLabel = w + "x" + h;
      if (newLabel.equals(pcSizeLabel)) {
         Code.popup_chat("Size không đổi");
         return;
      }
      if (!writePcWindowSize(w, h)) {
         Code.popup_chat("Lỗi ghi file size");
         return;
      }
      pcSizeLabel = newLabel;
      IActionListener closeListener = new IActionListener() {
         public void a(int cmd, Object obj) {
            GameCanvas.aj = null;
         }
      };
      IActionListener exitListener = new IActionListener() {
         public void a(int cmd, Object obj) {
            System.exit(0);
         }
      };
      Command1 closeBtn = new Command1("Để sau", closeListener, 1, (Object)null);
      Command1 exitBtn = new Command1("Thoát game", exitListener, 1, (Object)null);
      GameCanvas.a("Phiên bản đã nhận size " + newLabel + ".\nThoát game bây giờ để áp dụng?", closeBtn, exitBtn);
      closeBtn.f = 5;
      exitBtn.f = GameCanvas.aa - exitBtn.h - 5;
   }

   public static void menu_fakeskill() {
      MyVector vector = new MyVector();
      if (Code.fakeSkill) {
         vector.addElement(new Command1("Tắt Fake Skill", 1810));
      }
      vector.addElement(new Command1("Tiêu", 1811));
      vector.addElement(new Command1("Kiếm", 1812));
      vector.addElement(new Command1("Quạt", 1813));
      vector.addElement(new Command1("Đao", 1814));
      vector.addElement(new Command1("Kunai", 1815));
      vector.addElement(new Command1("Cung", 1816));
      GameCanvas.af.a(vector);
   }

   public static void menu_fakeskill_sub(String name, int id7x, int id8x, int id10x) {
      MyVector vector = new MyVector();
      vector.addElement(new Command1(name + " 7x (ID:" + id7x + ")", 1820 + id7x));
      vector.addElement(new Command1(name + " 8x (ID:" + id8x + ")", 1820 + id8x));
      vector.addElement(new Command1(name + " 10x (ID:" + id10x + ")", 1820 + id10x));
      GameCanvas.af.a(vector);
   }

   public static void menu_vip() {
      // P2 A1#9: g9 cross-check khi mo menu vip — fail thi return menu trong.
      if (com.monkey.nso.LicenseGuard.isVerifyStarted() && !com.monkey.nso.LicenseGuard.g9()) {
         return;
      }
      MyVector vector = new MyVector();
      vector.addElement(new Command1("Cài Up", 7777));
      vector.addElement(new Command1("Danh Vọng", 1370));
      vector.addElement(new Command1("Đập Đồ",   1371));
      vector.addElement(new Command1("Kích Yên", 159));
      vector.addElement(new Command1("Hang Động", 153));
      vector.addElement(new Command1("Cài Skill", 1801));
      vector.addElement(new Command1("ID Quái", 1802));
      vector.addElement(new Command1("NVHN", 1804));
      vector.addElement(new Command1("Auto Nhóm", 1808));
      vector.addElement(new Command1("Auto Gom", 1809));
      GameCanvas.af.a(vector);
   }

   public static void show_theme() {
      MyVector vector = new MyVector();
      vector.addElement(new Command1("Thường", 1571));
      vector.addElement(new Command1("Đen", 1572));
      vector.addElement(new Command1("GDL", 1573));
      GameCanvas.af.a(vector);
   }

   public static void showMenuLh() {
      MyVector vector = new MyVector();
      vector.addElement(new Command1("Lật Hình", 1574));
      vector.addElement(new Command1("Tốc Độ Lật Hình " + Code.speedLh, 1575));
      GameCanvas.af.a(vector);
   }

   private static void show_menu_sell_item() {
      MyVector vector = new MyVector();
      vector.addElement(new Command1("Bán", 132));
      vector.addElement(new Command1("Bán nhiều", 133));
      vector.addElement(new Command1("Bán hết", 134));
      GameCanvas.af.a(vector);
   }

   public boolean game_perform(int num_case, Object obj) {
      if (num_case > 1820 && num_case <= 1904) {
         int skillId = num_case - 1820;
         Code.fakeSkill = true;
         Code.fakeSkillId = skillId;
         Code.popup_chat("Fake Skill ID: " + skillId);
         GameCanvas.j();
         return true;
      }
      Npc var25;
      switch (num_case) {
         case 99:
            Npc var24;
            if ((var24 = GameScr.npc_i(5)) != null && (Math.abs(var24.cx1 - Char.getMyChar().cx1) > 22 || Math.abs(var24.cy1 - Char.getMyChar().cy1) > 22)) {
               Char.move(var24.cx1, var24.cy1);
            }

            GameScr.gI().doOpenUI(4);
            return true;
         case 100:
            show_menuauto();
            return true;
         case 103:
            Code.popup_chat("Tắt auto");
            Code.mode = null;
            return true;
         case 106:
            MyVector vect;
            (vect = new MyVector()).addElement(new Command1("Tàn sát all", 107, (Object)null));

            for(int indexts = 0; indexts < listquai.size(); ++indexts) {
               MobTemplate mobtemp = (MobTemplate)listquai.elementAt(indexts);
               vect.addElement(new Command1(mobtemp.g, 108, mobtemp));
            }

            GameCanvas.af.a(vect);
            return true;
         case 107:
            Code.run_ts(-1, TileMap.mapID);
            Code.popup_chat("Tàn sát all");
            return true;
         case 108:
            MobTemplate mob1 = (MobTemplate)obj;
            Code.run_ts(mob1.e, TileMap.mapID);
            return true;
         case 109:
            Item var231;
            if ((var231 = GameScr.k(3)) != null) {
               Code.tudung_remove(var231.template.id);
            }

            return true;
         case 110:
            Item var241;
            if ((var241 = GameScr.k(3)) != null) {
               Code.tudung_add(var241.template.id);
            }

            return true;
         case 111:
            (new Thread(new Open_All(GameScr.k(3)))).start();
            return true;
         case 114:
            MyVector var31 = new MyVector();
            MyVector var171 = new MyVector();

            for(int var18 = 0; var18 < GameScr.vNpc.size(); ++var18) {
               var25 = (Npc)GameScr.vNpc.elementAt(var18);
               if (!var171.contains(var25.npcTemplate)) {
                  var171.addElement(var25.npcTemplate);
                  var31.addElement(new Command1(var25.npcTemplate.name, 115, var25));
               }
            }

            GameCanvas.af.a(var31);
            return true;
         case 115:
            Npc var161;
            if ((var161 = (Npc)obj) != null) {
               if (Math.abs(var161.cx1 - Char.getMyChar().cx1) > 22) {
                  Char.move(var161.cx1, var161.cy1);
               }

               Service.gI().openMenu(var161.npcTemplate.npcTemplateId);
            }

            return true;
         case 118:
            GameScr.gI().c = GameScr.gI().ne;
            GameScr.aw = 0;
            isItemDel = true;
            GameScr.b(175, 200);
            return true;
         case 119:
            GameScr.gI().c = GameScr.gI().ne;
            GameScr.aw = 0;
            isItemPick = true;
            GameScr.b(175, 200);
            return true;
         case 120:
            if ((var25 = GameScr.npc_i(13)) != null && (Math.abs(var25.cx1 - Char.getMyChar().cx1) > 22 || Math.abs(var25.cy1 - Char.getMyChar().cy1) > 22)) {
               Char.move(var25.cx1, var25.cy1);
            }

            Service.gI().e();
            return true;
         case 121:
            GameCanvas.al.a("KC Nhặt", new Command1("Đặt", 1211), 1);
            GameCanvas.al.a.a(String.valueOf(Code.kc_nhat));
            return true;
         case 122:
            GameCanvas.al.a("KC Tàn sát", new Command1("Đặt", 1221), 1);
            GameCanvas.al.a.a(String.valueOf(Code.kcts));
            return true;
         case 123:
            if (Code.dcvt) {
               RMS.a("phongdcvt", -1);
               Code.popup_chat("Tắt đánh chuyển vị trí");
            } else {
               RMS.a("phongdcvt", 1);
               Code.popup_chat("Bật đánh chuyển vị trí");
            }

            Code.dcvt = !Code.dcvt;
            return true;
         case 124:
            if (Code.dck = !Code.dck) {
               GameCanvas.al.a("Khu-Mỗi khu cách nhau bằng dấu cách", new Command1("Đặt", 1241), 0);
               GameCanvas.al.a.a(Code.k());
            }

            return true;
         case 125:
            if (Code.pkam) {
               RMS.a("Phongpkam", -1);
               Code.popup_chat("Tắt giữ lv và pk âm");
            } else {
               RMS.a("Phongpkam", 1);
               Code.popup_chat("Bật giữ lv và pk âm");
            }

            Code.pkam = !Code.pkam;
            return true;
         case 126:
            GameCanvas.al.a("Tốc độ next map(milis)", new Command1("Đặt", 1261), 1);
            GameCanvas.al.a.a(String.valueOf(Code.tdnm));
            return true;
         case 12700:
            GameCanvas.al.a("Speed game (ms/frame)", new Command1("Đặt", 12701), 1);
            GameCanvas.al.a.a(String.valueOf(Code.speedGame));
            return true;
         case 127:
            show_setting();
            return true;
         case 128:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.menu_pkam()); } });
            return true;
         case 131:
            if (Char.getMyChar().arrItemBag[GameScr.indexSelect].quantity > 1) {
               show_menu_sell_item();
            } else {
               Service.gI().g(GameScr.indexSelect, 1);
            }

            return true;
         case 132:
            Service.gI().g(GameScr.indexSelect, 1);
            return true;
         case 133:
            GameCanvas.al.a("Số lượng cần bán", new Command1("Đặt", 1331), 1);
            GameCanvas.al.a.a("");
            return true;
         case 134:
            Service.gI().g(GameScr.indexSelect, Char.getMyChar().arrItemBag[GameScr.indexSelect].quantity);
            return true;
         case 135:
            if (Code.show_dcvt) {
               RMS.a("show_dcvt", -1);
            } else {
               RMS.a("show_dcvt", 1);
            }

            Code.show_dcvt = !Code.show_dcvt;
            return true;
         case 136:
            MyVector _opts = new MyVector();
            _opts.addElement(new Command1((Code.filterMode == 0 ? "@ " : "  ") + "Tắt lọc đồ", 1360));
            _opts.addElement(new Command1((Code.filterMode == 1 ? "@ " : "  ") + "Vứt tại chỗ", 1361));
            _opts.addElement(new Command1((Code.filterMode == 2 ? "@ " : "  ") + "Bán ở trường/làng", 1362));
            _opts.addElement(new Command1((Code.filterMode == 3 ? "@ " : "  ") + "Vứt 5 yên/Bán nhiều yên", 1363));
            GameCanvas.af.a(_opts);
            return true;
         case 1360:
            Code.filterMode = 0;
            RMS.a("filterMode", 0);
            GameCanvas.a("Tắt lọc đồ");
            return true;
         case 1361:
            Code.filterMode = 1;
            RMS.a("filterMode", 1);
            GameCanvas.a("Lọc đồ: Vứt tại chỗ");
            return true;
         case 1362:
            Code.filterMode = 2;
            RMS.a("filterMode", 2);
            GameCanvas.a("Lọc đồ: Bán ở làng/trường");
            return true;
         case 1363:
            Code.filterMode = 3;
            RMS.a("filterMode", 3);
            GameCanvas.a("Lọc đồ: Vứt 5y/Bán nhiều yên");
            return true;

         case 1370:
            // Mo thang SetupDanhVong (ben trong da co checkbox Auto cat do)
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.SetupDanhVong()); } });
            return true;
         case 1371:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.SetupDapDo()); } });
            return true;
         case 137:
            Char char_ = (Char)GameScr.vCharInMap.elementAt(GameScr.av);
            Char.move(char_.cx1, char_.cy1);
            Char.getMyChar().charFocus = char_;
            return true;
         case 138:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(base.game2.screen.ListKO.gI()); } });
            return true;
         case 139:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(base.game2.screen.ListPK.gI()); } });
            return true;
         case 140:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(base.game2.screen.ListBlock.gI()); } });
            return true;
         case 141:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(base.game2.screen.ListGroup.gI()); } });
            return true;
         case 143:
            Code.add_tinhluyen(Char.getMyChar().arrItemBag[GameScr.indexSelect]);
            return true;
         case 144:
            Code.xoa_tinhluyen(Char.getMyChar().arrItemBag[GameScr.indexSelect]);
            return true;
         case 145:
            Code.ThemItemNhat(Char.getMyChar().arrItemBag[GameScr.indexSelect].template.id);
            return true;
         case 146:
            Code.DelItemNhat(Char.getMyChar().arrItemBag[GameScr.indexSelect].template.id);
            return true;
         case 147:
            Code.ThemItemDel(Char.getMyChar().arrItemBag[GameScr.indexSelect].template.id);
            return true;
         case 148:
            Code.DelItemDel(Char.getMyChar().arrItemBag[GameScr.indexSelect].template.id);
            return true;
         case 149:
            GameCanvas.al.a("Số lượng cần ăn", new Command1("Đặt", 1491), 1);
            GameCanvas.al.a.a(String.valueOf(solgmoall));
            return true;
         case 150:
            GameCanvas.al.a("Tốc độ sử dụng vp(milis)", new Command1("Đặt", 15011), 1);
            GameCanvas.al.a.a(String.valueOf(speedAll));
            return true;
         case 1600:
            GameCanvas.al.a("Time Sleep (phút)", new Command1("Đặt", 16001), 1);
            GameCanvas.al.a.a(String.valueOf(com.monkey.nso.SleepManager.timeoutMinutes));
            return true;
         case 16001:
            try {
               int slpMin = Integer.parseInt(GameCanvas.al.a.d().trim());
               if (slpMin >= 1) {
                  com.monkey.nso.SleepManager.timeoutMinutes = slpMin;
                  RMS.a("sleepMinutes", String.valueOf(slpMin));
                  Code.popup_chat("Time Sleep: " + slpMin + "phut");
                  ;
               } else {
                  Code.popup_chat("Nhap so nguyen >= 1");
               }
            } catch (Exception var16sleep) {
               Code.popup_chat("Chỉ nhập số nguyên");
               ;
            }
            GameCanvas.j();
            return true;
         // [SIZE-PC] 5 case — lop 2 guard trong handler
         case 1905:
            if (Gdx.app == null || Gdx.app.getType() != Application.ApplicationType.Desktop) return true;
            show_menu_size_pc();
            return true;
         case 1906:
            handlePcSizePick(1020, 597);
            return true;
         case 1907:
            handlePcSizePick(1280, 720);
            return true;
         case 1908:
            handlePcSizePick(1600, 900);
            return true;
         case 151:
            GameCanvas.al.a("Delay tele(ms)", new Command1("Đặt", 15111), 1);
            GameCanvas.al.a.a(String.valueOf(Code.delay_tele));
            return true;
         case 152:
            GameCanvas.al.a("Delay giữa 2 lần tele", new Command1("Đặt", 15211), 1);
            GameCanvas.al.a.a(String.valueOf(Code.time_tele_1));
            return true;
         case 153:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.MenuHangDong()); } });
            return true;
         case 154:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.Setting()); } });
            return true;
         case 155:
            String hdsd = Client.hdsdContent != null ? Client.hdsdContent : "Không thể tải hướng dẫn.";
            GameScr.gI().a("Hướng dẫn", hdsd, false);
            return true;
         case 156:
            Code.isShowTL = phong.changeBoolean(Code.isShowTL, "hiện tinh luyện đồ", "isShowTL");
            return true;
         case 157:
            show_theme();
            return true;
         case 158:
            showMenuLh();
            return true;
         case 1805:
            ScreenManager.showOnGL(new Runnable() { public void run() {
               if (ScreenManager.screenAutoMuaItem == null) ScreenManager.screenAutoMuaItem = new base.game2.screen.ScreenAutoMuaItem();
               ScreenManager.show(ScreenManager.screenAutoMuaItem);
            } });
            return true;
         case 1806:
            ScreenManager.showOnGL(new Runnable() { public void run() {
               if (ScreenManager.screenAutoNPC == null) ScreenManager.screenAutoNPC = new base.game2.screen.ScreenAutoNPC();
               ScreenManager.show(ScreenManager.screenAutoNPC);
            } });
            return true;
         case 1807:
            ScreenManager.showOnGL(new Runnable() { public void run() {
               if (ScreenManager.screenAutoOnOff == null) ScreenManager.screenAutoOnOff = new base.game2.screen.ScreenAutoOnOff();
               ScreenManager.show(ScreenManager.screenAutoOnOff);
            } });
            return true;
         case 159:
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.KichYen()); } });
            return true;
         case 1111:
            Code.addmode(new AutoNv10());
            Code.popup_chat("Auto level 10");
            return true;
         case 1112:
            Code.addmode(new AutoNv20());
            Code.popup_chat("Auto level 20");
            return true;
         case 1113:
            Code.n49.run();
            Code.addmode(Code.n49);
            Code.popup_chat("Auto nv 49");
            return true;
         case 1114:
            Code.n53.run();
            Code.addmode(Code.n53);
            Code.popup_chat("Auto nv 53");
            return true;
         case 1115:
            Code.n55.run();
            Code.addmode(Code.n55);
            Code.popup_chat("Auto nv 55");
            return true;
         case 1181:
            Code.DelItemDel(Code.arrItemDel[GameScr.indexSelect]);
            return true;
         case 1182:
            Code.SapXepItemDel();
            return true;
         case 1183:
            Code.ThemItemDel(Char.getMyChar().arrItemBag[GameScr.indexSelect].template.id);
            return true;
         case 1191:
            Code.DelItemNhat(Code.arrItemNhat[GameScr.indexSelect]);
            return true;
         case 1192:
            Code.SapXepItemNhat();
            return true;
         case 1193:
            Code.ThemItemNhat(Char.getMyChar().arrItemBag[GameScr.indexSelect].template.id);
            return true;
         case 1211:
            try {
               Code.kc_nhat = Integer.parseInt(GameCanvas.al.a.d());
            } catch (Exception var21) {
            }

            GameCanvas.j();
            return true;
         case 1217:
            menu_nvct();
            return true;
         case 1221:
            try {
               Code.kcts = Integer.parseInt(GameCanvas.al.a.d());
            } catch (Exception var20) {
            }

            GameCanvas.j();
            return true;
         case 1241:
            Code.e(GameCanvas.al.a.d());
            GameCanvas.j();
            return true;
         case 1261:
            try {
               Code.tdnm = (long)Integer.parseInt(GameCanvas.al.a.d());
            } catch (Exception var19) {
            }

            RMS.a("nextmap", String.valueOf(Code.tdnm));
            GameCanvas.j();
            return true;
         case 12701:
            try {
               Code.speedGame = Integer.parseInt(GameCanvas.al.a.d());
            } catch (Exception var20) {
            }

            RMS.a("speedGame", String.valueOf(Code.speedGame));
            GameCanvas.j();
            return true;
         case 1272:
            menu_lau();
            return true;
         case 1800:
            menu_vip();
            return true;
         case 1801:
            ScreenManager.showOnGL(new Runnable() {
               public void run() {
                  if (ScreenManager.screenSettingSkill == null) {
                     ScreenManager.screenSettingSkill = new ScreenSettingSkill();
                  }
                  ScreenManager.show(ScreenManager.screenSettingSkill);
               }
            });
            return true;
         case 1802:
            ScreenManager.showOnGL(new Runnable() {
               public void run() {
                  ScreenManager.show(new base.game2.screen.ScreenMobIDFilter());
               }
            });
            return true;
         case 1804:
            ScreenManager.showOnGL(new Runnable() {
               public void run() {
                  ScreenManager.show(new base.game2.screen.SetupNVHN());
               }
            });
            return true;
         case 1808:
            // AUTO-PT: mở popup Auto nhóm
            ScreenManager.showOnGL(new Runnable() {
               public void run() {
                  ScreenManager.show(base.game2.screen.ScreenAutoNhom.gI());
               }
            });
            return true;
         case 1809:
            // AUTO-GOM: mở popup cài Auto gom
            ScreenManager.showOnGL(new Runnable() {
               public void run() {
                  ScreenManager.show(new base.game2.screen.ScreenCaiGom());
               }
            });
            return true;
         case 1803:
            menu_fakeskill();
            return true;
         case 1810:
            Code.fakeSkill = false;
            Code.fakeSkillId = 0;
            Code.popup_chat("Tắt Fake Skill");
            GameCanvas.j();
            return true;
         case 1811:
            menu_fakeskill_sub("Tiêu", 62, 78, 83);
            return true;
         case 1812:
            menu_fakeskill_sub("Kiếm", 61, 73, 79);
            return true;
         case 1813:
            menu_fakeskill_sub("Quạt", 66, 77, 84);
            return true;
         case 1814:
            menu_fakeskill_sub("Đao", 65, 74, 80);
            return true;
         case 1815:
            menu_fakeskill_sub("Kunai", 63, 75, 81);
            return true;
         case 1816:
            menu_fakeskill_sub("Cung", 64, 76, 82);
            return true;
         case 7777:
            // Port TGAME Muc 5: mo form Cai up (Scene2D)
            ScreenManager.showOnGL(new Runnable() { public void run() { ScreenManager.show(new base.game2.screen.FormCaiUp()); } });
            return true;
         case 1331:
            int num = 0;

            try {
               num = Integer.parseInt(GameCanvas.al.a.d());
            } catch (Exception var18) {
            }

            Service.gI().g(GameScr.indexSelect, num);
            GameCanvas.j();
            return true;
         case 1491:
            try {
               solgmoall = Integer.parseInt(GameCanvas.al.a.d());
            } catch (Exception var17) {
            }

            GameCanvas.j();
            (new Thread(new MoAll1(GameScr.k(3)))).start();
            return true;
         case 1571:
            Code.currentBG = 0;
            RMS.a("currentBG", String.valueOf(Code.currentBG));
            GameCanvas.a("Vui lòng thoát hẳn giả lập và mở lại game");
            return true;
         case 1572:
            Code.currentBG = 1;
            RMS.a("currentBG", String.valueOf(Code.currentBG));
            GameCanvas.a("Vui lòng thoát hẳn giả lập và mở lại game");
            return true;
         case 1573:
            Code.currentBG = 2;
            RMS.a("currentBG", String.valueOf(Code.currentBG));
            GameCanvas.a("Vui lòng thoát hẳn giả lập và mở lại game");
            return true;
         case 1574:
            GameCanvas.al.a("Nhập số phiếu cần lật", new Command1("OK", 1577), 1);
            GameCanvas.al.a.a(Code.countLh > 0 ? String.valueOf(Code.countLh) : "");
            return true;
         case 1575:
            GameCanvas.al.a("Tốc Độ Lật Hình ", new Command1("OK", 1576), 1);
            GameCanvas.al.a.a(String.valueOf(Code.speedLh));
            return true;
         case 1576:
            Code.speedLh = (long)Integer.parseInt(GameCanvas.al.a.d());
            Code.popup_chat("Tốc Độ Lật Hình Của Bạn Là : " + Code.speedLh);
            RMS.a("time_lat_hinh", String.valueOf(Code.speedLh));
            GameCanvas.j();
            return true;
         case 1577:
            Code.countLh = Integer.parseInt(GameCanvas.al.a.d());
            GameScr.gI().doOpenUI(38);
            (new Thread(new AutoLatHinh(Code.countLh))).start();
            Code.popup_chat("Auto Lật " + Code.countLh + " Phiếu");
            GameCanvas.j();
            return true;
         case 15011:
            try {
               speedAll = Long.parseLong(GameCanvas.al.a.d());
            } catch (Exception var16) {
            }

            GameCanvas.j();
            return true;
         case 15111:
            try {
               Code.delay_tele = Long.parseLong(GameCanvas.al.a.d());
            } catch (Exception var15) {
            }

            RMS.a("delay_tele", String.valueOf(Code.delay_tele));
            GameCanvas.j();
            return true;
         case 15140:
            Char.lv_tbi = 1;
            return true;
         case 15141:
            Char.lv_tbi = 10;
            return true;
         case 15142:
            Char.lv_tbi = 20;
            return true;
         case 15143:
            Char.lv_tbi = 30;
            return true;
         case 15144:
            Char.lv_tbi = 40;
            return true;
         case 15145:
            Char.lv_tbi = 50;
            return true;
         case 15146:
            Char.lv_tbi = 60;
            return true;
         case 15150:
            Char.lv_hpmp = 1;
            return true;
         case 15151:
            Char.lv_hpmp = 10;
            return true;
         case 15152:
            Char.lv_hpmp = 30;
            return true;
         case 15153:
            Char.lv_hpmp = 50;
            return true;
         case 15154:
            Char.lv_hpmp = 70;
            return true;
         case 15161:
            Char.lv_da = 1;
            return true;
         case 15162:
            Char.lv_da = 2;
            return true;
         case 15163:
            Char.lv_da = 3;
            return true;
         case 15164:
            Char.lv_da = 4;
            return true;
         case 15165:
            Char.lv_da = 5;
            return true;
         case 15166:
            Char.lv_da = 6;
            return true;
         case 15167:
            Char.lv_da = 7;
            return true;
         case 15174:
            Char.lv_luyenda = 5;
            return true;
         case 15175:
            Char.lv_luyenda = 6;
            return true;
         case 15176:
            Char.lv_luyenda = 7;
            return true;
         case 15177:
            Char.lv_luyenda = 8;
            return true;
         case 15178:
            Char.lv_luyenda = 9;
            return true;
         case 15179:
            Char.lv_luyenda = 10;
            return true;
         case 15211:
            try {
               Code.time_tele_1 = Long.parseLong(GameCanvas.al.a.d());
            } catch (Exception var14) {
            }

            RMS.a("time_tele_1", String.valueOf(Code.time_tele_1));
            GameCanvas.j();
            return true;
         case 110020:
            new Thread() { public void run() { Auto.tusat_vdmq(); Auto.hoisinh_public(false); } }.start();
            return true;
         default:
            return false;
      }
   }

   static {
      if (RMS.b("speedAll") != null) {
         try {
            speedAll = Long.parseLong(RMS.b("speedAll"));
         } catch (Exception var1) {
            speedAll = 100L;
         }
      }
      if (RMS.b("sleepMinutes") != null) {
         try {
            com.monkey.nso.SleepManager.timeoutMinutes = Integer.parseInt(RMS.b("sleepMinutes"));
            ;
         } catch (Exception var2) {
            ;
         }
      }
      // [SIZE-PC] load label hien tai tu file
      pcSizeLabel = readPcSizeLabel();
   }
}
