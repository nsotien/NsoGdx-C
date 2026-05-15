package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoNhando extends Auto {

   AutoNhando() {
      super.reset();
      this.map_auto = TileMap.mapID;
      this.khu_auto = TileMap.zoneID;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         hoisinh(false);
      } else if (this.map_auto == TileMap.mapID && this.khu_auto == TileMap.zoneID) {
         if (GameScr.cs) {
            GameScr.gI().dj = 0;
            GameScr.cc = new Item[12];
            Service.gI().a((int)0, (Item[])GameScr.cc);
            GameScr.gI().dh = 1;

            while(GameScr.gI().di != 1) {
               phong.sleep(100L);
               if (!GameScr.cs) {
                  return;
               }
            }

            long i = System.currentTimeMillis();

            while(System.currentTimeMillis() - i < 5000L) {
               phong.sleep(100L);
               if (!GameScr.cs) {
                  return;
               }
            }

            Service.gI().j();
            GameScr.gI().dh = 2;

            while(GameScr.cs) {
               phong.sleep(100L);
            }
         }
      } else {
         this.remap(this.map_auto, this.khu_auto, -1, -1);
      }

   }

   public String toString() {
      return "Auto nhận đồ";
   }

}
