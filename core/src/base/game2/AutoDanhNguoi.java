package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoDanhNguoi extends Auto {
   public int type_akn;

   public void start(int type) {
      super.reset();
      this.map_auto = TileMap.mapID;
      this.khu_auto = TileMap.zoneID;
      this.type_akn = type;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         hoisinh(true);
      } else {
         if (Char.remap && (TileMap.mapID != this.map_auto || TileMap.zoneID != this.khu_auto)) {
            this.remap(this.map_auto, this.khu_auto, -1, -1);
            return;
         }

         this.akn(this.type_akn);
      }

   }

   public String toString() {
      return "Auto đánh người(" + (this.type_akn == 1 ? "Tele" : "Di chuyển") + ")";
   }

}
