package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class AutoTaThu extends Auto {
   private TaskOrder y;
   public int a;
   public static boolean w;
   public static long x;

   public final void a() {
      super.reset();
      this.y = Char.get_nvhn(1);
      if (this.y != null) {
         this.a = this.y.f;
         super.map_auto = this.y.g;
         if (TileMap.mapID == this.y.g && TileMap.zoneID % 5 == 0) {
            super.khu_auto = TileMap.zoneID;
            return;
         }
      }

      super.khu_auto = 5;
   }

   public void resetAfterLogin() {
      this.y = Char.get_nvhn(1);
      super.resetAfterLogin();
   }

   public final void auto() {
      if (this.y == null) {
         if (TileMap.isTruong(TileMap.mapID)) {
            GameScr.npc_b(25, 2, 0);
            phong.a(2000L);
            this.y = Char.get_nvhn(1);
            this.a = this.y.f;
            super.map_auto = this.y.g;
            if (TileMap.mapID == this.y.g && TileMap.zoneID % 5 == 0) {
               super.khu_auto = TileMap.zoneID;
               return;
            }

            return;
         }

         this.remap(1, -2, -1, -1);
      }

      if (super.map_auto >= 0) {
         if (Auto.check_dead(Char.getMyChar())) {
            if (Char.remap) {
               Auto.hoisinh(true);
               return;
            }
         } else if (TileMap.mapID == super.map_auto && TileMap.zoneID == super.khu_auto) {
            if (this.y != null && this.y.b >= this.y.c) {
               Code.popup_chat("Xong Tà Thú");
               Code.remode();
               return;
            }

            this.attack(this.a, 8);
            if (Char.getMyChar().cMP < Char.getMyChar().cMaxMP * Char.dt / 100) {
               Char.getMyChar().e(17);
            }

            if (Char.getMyChar().cHP < Char.getMyChar().cMaxHP * Char.ds / 100) {
               int var1 = (int)(System.currentTimeMillis() / 1000L);

               for(int var4 = 0; var4 < Char.getMyChar().by.size(); ++var4) {
                  Effect var3;
                  if ((var3 = (Effect)Char.getMyChar().by.elementAt(var4)).e.a == 21 && var3.c - (var1 - var3.b) >= 2) {
                     return;
                  }
               }

               Char.getMyChar().e(16);
               return;
            }
         } else {
            this.remap(super.map_auto, super.khu_auto, super.x_auto, super.y_auto);
         }
      } else {
         Code.remode();
      }

   }

   public final String toString() {
      return "Auto Tà Thú";
   }

}
