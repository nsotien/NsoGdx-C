package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoPK extends Auto {

   public void start() {
      this.reset();
      this.map_auto = TileMap.mapID;
      this.khu_auto = TileMap.zoneID;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         if (Char.remap) {
            hoisinh(true);
         }
      } else if (TileMap.mapID == this.map_auto && TileMap.zoneID == this.khu_auto) {
         this.autopk();
      } else {
         this.remap(this.map_auto, this.khu_auto, this.x_auto, this.y_auto);
      }

   }

   public String toString() {
      String var1 = Setting.mode_2 == 0 ? "Tele đánh người" : "Đánh trong tầm";
      return "Auto PK: (" + var1 + ")";
   }

}
