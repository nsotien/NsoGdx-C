package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoTuDanh extends Auto {

   public final void start() {
      super.reset();
      super.map_auto = TileMap.mapID;
      super.khu_auto = TileMap.zoneID;
      super.x_auto = Char.getMyChar().cx1;
      super.y_auto = Char.getMyChar().cy1;
   }

   public final void auto() {
      if (check_dead(Char.getMyChar())) {
         if (Char.remap) {
            hoisinh(true);
            return;
         }
      } else {
         if (Char.remap && (super.map_auto != TileMap.mapID || super.khu_auto != TileMap.zoneID)) {
            this.remap(super.map_auto, super.khu_auto, super.x_auto, super.y_auto);
            return;
         }

         this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
         this.nhatdo(-1);
      }

   }

   protected final Mob get_mob(Char var1, int var2, int var3, Char var4, boolean var5) {
      if (Code.dcvt && Code.x_dcvt[TileMap.mapID].size() > 0) {
         this.dcvt(var3, var5);
         return Auto.get_dxdy_mob(var1.cx1, var1.cy1);
      } else {
         return Auto.get_dxdy_mob(var1.cx1, var1.cy1);
      }
   }

   public final String toString() {
      return "Tự đánh";
   }

}
