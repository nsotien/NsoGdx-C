package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.TimeZone;

public class AutoHangDong extends Auto {
   public static boolean xong_hd = false;
   private long time_hd6x;
   private long p;
   public static boolean xongmap1;
   public static boolean xongmap2;
   public static boolean xongmap3;
   public static boolean yenmap1;
   public static boolean yenmap2;
   public static boolean yenmap3;
   public static boolean lan1;
   public static boolean lan2;
   public static boolean dung_lb;
   public static boolean isLayRuong = false;
   private long time_cho_nhom;
   private int lastCallMap;
   private int lastCallZone;
   private long lastCallTime;
   private long timeRemapBoss4 = 0L;

   public static int map() {
      if (Char.getMyChar().cLevel >= 30 && Char.getMyChar().cLevel <= 39) {
         return 91;
      } else if (Char.getMyChar().cLevel >= 40 && Char.getMyChar().cLevel <= 49) {
         return 94;
      } else if (Char.getMyChar().cLevel >= 50 && Char.getMyChar().cLevel <= 59) {
         return 105;
      } else if (Char.getMyChar().cLevel >= 60 && Char.getMyChar().cLevel <= 69) {
         return 114;
      } else if (Char.getMyChar().cLevel >= 70 && Char.getMyChar().cLevel <= 89) {
         return 125;
      } else {
         return Char.getMyChar().cLevel >= 90 ? 157 : -1;
      }
   }

   public static int gettime(int var0) {
      Calendar var1 = Calendar.getInstance();
      var1.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
      return var1.get(var0);
   }

   public static String name() {
      if (Char.getMyChar().cLevel >= 30 && Char.getMyChar().cLevel <= 39) {
         return "35";
      } else if (Char.getMyChar().cLevel >= 40 && Char.getMyChar().cLevel <= 49) {
         return "45";
      } else if (Char.getMyChar().cLevel >= 50 && Char.getMyChar().cLevel <= 59) {
         return "55";
      } else if (Char.getMyChar().cLevel >= 60 && Char.getMyChar().cLevel <= 69) {
         return "65";
      } else if (Char.getMyChar().cLevel >= 70 && Char.getMyChar().cLevel <= 89) {
         return "75";
      } else {
         return Char.getMyChar().cLevel >= 90 ? "95" : "";
      }
   }

   public void start() {
      super.reset();
      this.map_auto = map();
      this.isPhoban = TileMap.isPhuBan(map());
      this.khu_auto = -2;
      isLayRuong = false;
      xong_hd = false;
      this.time_hd6x = System.currentTimeMillis();
      xongmap1 = false;
      xongmap2 = false;
      xongmap3 = false;
      yenmap1 = false;
      yenmap2 = false;
      yenmap3 = false;
      if (dung_lb) {
         dung_lb = false;
      }
      lastCallMap = 0;
      lastCallZone = 0;
      lastCallTime = 0L;
   }

   public void startLayRuong() {
      super.reset();
      this.map_auto = MenuHangDong.theoNhom && MenuHangDong.map_nhom > 0
         ? MenuHangDong.map_nhom : 157;
      this.khu_auto = MenuHangDong.theoNhom && MenuHangDong.map_nhom > 0
         ? MenuHangDong.khu_nhom : -2;
      this.isPhoban = TileMap.isPhuBan(this.map_auto);
      isLayRuong = true;
      xong_hd = false;
      xongmap1 = false;
      xongmap2 = false;
      xongmap3 = false;
      yenmap1 = false;
      yenmap2 = false;
      yenmap3 = false;
      time_cho_nhom = System.currentTimeMillis();
      if (dung_lb) dung_lb = false;
      lastCallMap = 0;
      lastCallZone = 0;
      lastCallTime = 0L;
      this.timeRemapBoss4 = 0L;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         hoisinh(false);
         return;
      }

      if (!MenuHangDong.theoNhom && GameScr.vParty.size() > 1) {
         Service.gI().t();
      }

      if (map() == 157) {
         if (isLayRuong) {
            this.hang9x_layruong();
         } else {
            this.hang9x();
         }
      } else {
         if (TileMap.mapID == this.map_auto) {
            this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
            return;
         }
         this.remap(this.map_auto, this.khu_auto, -1, -1);
      }
   }

   private void callHdGroup(int map, int id) {
      if (!MenuHangDong.theoNhom) return;
      if (!Auto.isLeader()) return;
      if (GameScr.vParty.size() <= 1) return;
      if (TileMap.mapID != map) return;
      int zone = TileMap.zoneID;
      long now = System.currentTimeMillis();
      if (lastCallMap == map && lastCallZone == zone && now - lastCallTime < 5000L) return;
      lastCallMap = map;
      lastCallZone = zone;
      lastCallTime = now;
      Code.callGroupTsRemote(map, zone, id);
   }

   private void hang9x() {
      int gio = gettime(11);
      int phut = gettime(12);
      if ((TileMap.mapID == 157 || TileMap.mapID == 158 || TileMap.mapID == 159) && Char.dx == 0 && (xongmap1 || xongmap2 || xongmap3 || yenmap1 || yenmap2 || yenmap3)) {
         xongmap1 = false;
         xongmap2 = false;
         xongmap3 = false;
         yenmap1 = false;
         yenmap2 = false;
         yenmap3 = false;
         this.map_auto = 157;
      }

      if (!xongmap1 && !xongmap2 && !xongmap3) {
         if (TileMap.mapID == 157) {
            if (!phongdz1() && yenmap1) {
               xongmap1 = true;
               phong.sleep(250L);
               return;
            }

            if (!yenmap1 && !phongdz1()) {
               callHdGroup(157, 199);
               this.attack(199, -1);
               return;
            }

            if (phongdz1()) {
               yenmap1 = true;
               phongdz();
               return;
            }
         } else {
            this.remap(157, -2, -1, -1);
         }
      } else if (xongmap1 && !xongmap2 && !xongmap3) {
         if (TileMap.mapID == 158) {
            if (!phongdz1() && yenmap2) {
               xongmap2 = true;
               phong.sleep(250L);
               return;
            }

            if (!yenmap2 && !phongdz1()) {
               callHdGroup(158, 200);
               this.attack(200, -1);
               return;
            }

            if (phongdz1()) {
               yenmap2 = true;
               phongdz();
               return;
            }
         } else {
            this.remap(158, -2, -1, -1);
         }
      } else if (xongmap1 && xongmap2 && !xongmap3) {
         if (TileMap.mapID == 159) {
            if (yenmap3 && !phongdz1()) {
               xongmap3 = true;
               phong.sleep(250L);
               return;
            }

            if (!yenmap3 && !phongdz1()) {
               callHdGroup(159, 198);
               if (gio != MenuHangDong.gio_hd && (gio != MenuHangDong.gio_hd + 1 || phut >= MenuHangDong.phut_hd)) {
                  this.attack(198, -1);
               } else {
                  if (Char.dx < 61) {
                     this.attack(198, -1);
                     return;
                  }

                  if (System.currentTimeMillis() - this.p >= 30000L) {
                     Code.popup_chat("Xong 3 boss!!");
                     this.p = System.currentTimeMillis();
                     lan1();
                     lan2();
                  }
               }
            }

            if (phongdz1()) {
               yenmap3 = true;
               phongdz();
               return;
            }
         } else {
            this.remap(159, -2, -1, -1);
         }
      } else if (xongmap1 && xongmap2 && xongmap3) {
         if (TileMap.mapID != 157 && TileMap.mapID != 158 && TileMap.mapID != 159) {
            this.remap(157, -2, -1, -1);
            return;
         }

         if (System.currentTimeMillis() - this.p >= 30000L) {
            Code.popup_chat("Xong 3 boss");
            this.p = System.currentTimeMillis();
            lan1();
            lan2();
         }
      }

   }

   public static void lan1() {
      int gio = gettime(11);
      int phut = gettime(12);
      if (lan1 && !lan2 && gio == MenuHangDong.gio_hd + 1 && phut == 1) {
         MyVector locale = new MyVector();
         locale.addElement(Char.getMyChar());
         Service.gI().sendPlayerAttack(new MyVector(), locale, 2);
         lan1 = false;
         Code.remode();
      }
   }

   public static void lan2() {
      if (lan2 && !lan1) {
         Code.remode();
         phong.sleep(1000L);
         phong.onDisconnect();
         lan2 = false;
      }

   }

   public static boolean phongdz1() {
      for(int i1 = 0; i1 < GameScr.vItemMap.size(); ++i1) {
         if (((ItemMap)GameScr.vItemMap.elementAt(i1)).template.type == 19) {
            return true;
         }
      }

      return false;
   }

   public static void phongdz() {
      int i1 = 115;
      ItemMap localObject = null;
      Char localdh = Char.getMyChar();

      for(int i2 = 0; i2 < GameScr.vItemMap.size(); ++i2) {
         ItemMap localbt = (ItemMap)GameScr.vItemMap.elementAt(i2);
         int i3 = a(localdh.cx1, localdh.cy1, localbt.xEnd, localbt.yEnd);
         if ((i1 == -1 || i3 < i1) && (Code.check_nhatdo(localbt.template) || localdh.nClass.a == 1 && localbt.template.id == 218) && (Code.solg_hanhtrang() > 2 || localbt.template.type == 19 || localbt.template.isUpToUp && Code.check_item(localbt.template.id))) {
            i1 = i3;
            localObject = localbt;
         }
      }

      if (localObject != null) {
         Service.gI().pickItem(localObject.itemMapID);
      }

   }

   public static int a(int var0, int var1, int var2, int var3) {
      if ((var0 = (var0 - var2) * (var0 - var2) + (var1 - var3) * (var1 - var3)) <= 0) {
         return 0;
      } else {
         var1 = (var0 + 1) / 2;

         do {
            var2 = var1;
            var1 = var1 / 2 + var0 / (var1 << 1);
         } while(Math.abs(var2 - var1) > 1);

         return var1;
      }
   }

   private void hang9x_layruong() {
      // Reset flags khi bị server đẩy ra (dx == 0) giống hang9x()
      if ((TileMap.mapID == 157 || TileMap.mapID == 158 || TileMap.mapID == 159)
         && Char.dx == 0 && (xongmap1 || xongmap2 || xongmap3 || yenmap1 || yenmap2 || yenmap3)) {
         xongmap1 = false;
         xongmap2 = false;
         xongmap3 = false;
         yenmap1 = false;
         yenmap2 = false;
         yenmap3 = false;
         this.timeRemapBoss4 = 0L;
      }

      // Đánh 3 map 157→158→159 (giống hang9x nhưng KHÔNG có lan1/lan2)
      if (!xongmap1 && !xongmap2 && !xongmap3) {
         if (TileMap.mapID == 157) {
            if (!phongdz1() && yenmap1) { xongmap1 = true; phong.sleep(250L); return; }
            if (!yenmap1 && !phongdz1()) { callHdGroup(157, 199); this.attack(199, -1); return; }
            if (phongdz1()) { yenmap1 = true; phongdz(); return; }
         } else {
            this.remap(157, -2, -1, -1);
         }
      } else if (xongmap1 && !xongmap2) {
         if (TileMap.mapID == 158) {
            if (!phongdz1() && yenmap2) { xongmap2 = true; phong.sleep(250L); return; }
            if (!yenmap2 && !phongdz1()) { callHdGroup(158, 200); this.attack(200, -1); return; }
            if (phongdz1()) { yenmap2 = true; phongdz(); return; }
         } else {
            this.remap(158, -2, -1, -1);
         }
      } else if (xongmap1 && xongmap2 && !xongmap3) {
         if (TileMap.mapID == 159) {
            if (yenmap3 && !phongdz1()) { xongmap3 = true; phong.sleep(250L); return; }
            if (!yenmap3 && !phongdz1()) { callHdGroup(159, 198); this.attack(198, -1); return; }
            if (phongdz1()) { yenmap3 = true; phongdz(); return; }
         } else {
            this.remap(159, -2, -1, -1);
         }
      } else if (xongmap1 && xongmap2 && xongmap3) {
         long now = System.currentTimeMillis();

         // mapID ngoài 3 map cửa = server đẩy ra = WIN
         if (TileMap.mapID != 157 && TileMap.mapID != 158 && TileMap.mapID != 159) {
            if (MenuHangDong.theoNhom) {
               int mapTT = MenuHangDong.map_nhom > 0 ? MenuHangDong.map_nhom : 157;
               int khuTT = MenuHangDong.map_nhom > 0 ? MenuHangDong.khu_nhom : -2;
               if (TileMap.mapID != mapTT) {
                  this.remap(mapTT, khuTT, -1, -1);
                  return;
               }
               if (checkPartyReady()) {
                  xongmap1 = false; xongmap2 = false; xongmap3 = false;
                  yenmap1 = false; yenmap2 = false; yenmap3 = false;
                  time_cho_nhom = now;
                  this.timeRemapBoss4 = 0L;
                  this.remap(157, -2, -1, -1);
                  return;
               }
               if (now - time_cho_nhom >= 10000L) {
                  Code.popup_chat("Chờ đồng đội...");
                  time_cho_nhom = now;
               }
               return;
            }
            // Solo: WIN -> nhận thưởng
            if (now - this.p >= 30000L) {
               Code.popup_chat("Win hang -> nhan ruong");
               this.p = now;
               lan1();
               lan2();
            }
            return;
         }

         // Đang trong 3 map -> săn boss 4 hồi sinh random
         // Chờ 3s sau remap trước khi check (tránh false positive map chưa load mob)
         if (now - this.timeRemapBoss4 < 3000L) return;

         // Có yên/rương trên map -> nhặt trước
         if (phongdz1()) { phongdz(); return; }

         // Có quái sống -> đánh
         if (coQuaiSong()) {
            this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
            return;
         }

         // Không quái không yên -> luân phiên sang map kế
         int nextMap = (TileMap.mapID == 157) ? 158
                     : (TileMap.mapID == 158) ? 159 : 157;
         this.timeRemapBoss4 = now;
         this.remap(nextMap, -2, -1, -1);
      }
   }

   private static boolean coQuaiSong() {
      for (int i = 0; i < GameScr.vMob.size(); ++i) {
         Mob m = (Mob) GameScr.vMob.elementAt(i);
         if (m.status != 0 && m.status != 1) return true;
      }
      return false;
   }

   public static boolean checkPartyReady() {
      if (GameScr.vParty.size() <= 1) return true;
      for (int i = 0; i < GameScr.vParty.size(); ++i) {
         Party p = (Party) GameScr.vParty.elementAt(i);
         if (p.f == null || p.f == Char.getMyChar()) continue;
         String memberName = p.f.cName;
         boolean found = false;
         for (int j = 0; j < GameScr.vCharInMap.size(); ++j) {
            Char c = (Char) GameScr.vCharInMap.elementAt(j);
            if (c.cName.equals(memberName)) { found = true; break; }
         }
         if (!found) return false;
      }
      return true;
   }

   public String toString() {
      return "Auto hang động " + name();
   }
}
