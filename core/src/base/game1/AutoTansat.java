package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoTansat extends Auto {
   public int id;

   public void run(int idquai, int map, int khu) {
      super.reset();
      this.map_auto = map;
      this.khu_auto = khu;
      this.id = idquai;
      this.isPhoban = TileMap.isPhuBan(map);
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         if (Char.remap) {
            hoisinh(true);
         }
      } else {
         if (MenuHangDong.autohd) {
            if (AutoHangDong.gettime(11) == MenuHangDong.gio_hd && AutoHangDong.gettime(12) == MenuHangDong.phut_hd) {
               if (AutoHangDong.map() == 157) {
                  if (MenuHangDong.layRuong) {
                     AutoHangDong.lan1 = true;
                     AutoHangDong.lan2 = false;
                     Code.aDong.startLayRuong();
                     Code.addmode(Code.aDong);
                     return;
                  } else {
                     AutoHangDong.lan1 = true;
                     AutoHangDong.lan2 = false;
                  }
               }

               Code.aDong.start();
               Code.addmode(Code.aDong);
               return;
            }

            if (!MenuHangDong.layRuong && AutoHangDong.gettime(11) == MenuHangDong.gio_hd + 1 && AutoHangDong.gettime(12) == MenuHangDong.phut_hd && AutoHangDong.map() == 157) {
               AutoHangDong.lan1 = false;
               AutoHangDong.lan2 = true;
               Code.aDong.start();
               Code.addmode(Code.aDong);
               return;
            }

            if (MenuHangDong.autohd_lbhd) {
               if (AutoHangDong.dung_lb) {
                  if (AutoHangDong.map() == 157 && MenuHangDong.layRuong) {
                     Code.aDong.startLayRuong();
                  } else {
                     Code.aDong.start();
                  }
                  Code.addmode(Code.aDong);
                  return;
               }

               if (AutoHangDong.gettime(11) == MenuHangDong.gio_hd_lbhd && AutoHangDong.gettime(12) == MenuHangDong.phut_hd_lbhd && Code.check_item(280) && !AutoHangDong.dung_lb) {
                  Service.gI().useItem(Code.get_item(280).indexUI);
                  phong.sleep(200L);
               }
            }
         }

         if (this.map_auto == TileMap.mapID && this.khu_auto == TileMap.zoneID) {
            if (Char.luyen_da && !Code.isADapDo && Code.check_solg_da() && Code.solg_hanhtrang() <= 5 && !TileMap.isLangCo(TileMap.mapID)) {
               Auto.tusat_vdmq();
               return;
            }

            // [TOI-UU-TANSAT C] chỉ scan + nhặt khi thật sự có item hợp lệ trên map.
            // check_itemmap() trả true ngay khi tìm thấy item đầu tiên passes filter,
            // tránh build vect_item_map + sort mỗi frame khi map trống đồ.
            if (this.check_itemmap()) {
               if (DebugLog.DEBUG) DebugLog.log("TS", "nhatdo called mapID=" + TileMap.mapID);
               this.nhatdo(-1);
            }
            if (Code.isApk && CharCanPK() != null) {
               Char.getMyChar().charFocus = CharCanPK();
               this.akn(-1);
               return;
            }

            this.syncLeaderTarget();
            this.attack(this.id, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
            return;
         }

         if (DebugLog.DEBUG && (TileMap.mapID == 35 || TileMap.mapID == 37)) DebugLog.log("TS", "[MAP35/37] remap branch: map_auto=" + this.map_auto + " khu_auto=" + this.khu_auto + " mapID=" + TileMap.mapID + " zoneID=" + TileMap.zoneID);
         this.remap(this.map_auto, this.khu_auto, this.x_auto, this.y_auto);
      }

   }

   public String toString() {
      String var1 = Code.pkam ? " pk" : "";
      return this.id > 0 && this.id < Mob.b.length ? "Tàn sát " + Mob.b[this.id].g + var1 : "Tàn sát" + var1;
   }

}
