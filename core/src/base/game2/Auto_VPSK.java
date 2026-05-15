package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Auto_VPSK extends Auto {
   private int idvp;
   static MyVector id_file = new MyVector();
   private int type;
   public static int idboss;
   public static boolean isPhanThan;
   public static boolean isChuThan;

   public void run(int id, int ty) {
      super.reset();
      this.idvp = id;
      this.map_auto = TileMap.mapID;
      this.khu_auto = TileMap.zoneID;
      this.type = ty;
   }

   void locdo() {
      Char var3 = Char.getMyChar();

      for(int var7 = 0; var7 < var3.arrItemBag.length; ++var7) {
         Item var25 = var3.arrItemBag[var7];

         for(int var1 = 0; var1 < Code.arrItemDel.length; ++var1) {
            if (var25 != null && Code.arrItemDel[var1] > 0 && var25.template.id == Code.arrItemDel[var1] && !var25.isLock) {
               Service.gI().r(var25.indexUI);
               phong.sleep(50L);
            }
         }
      }

   }

   boolean checkdel() {
      Char var3 = Char.getMyChar();

      for(int var7 = 0; var7 < var3.arrItemBag.length; ++var7) {
         Item var25 = var3.arrItemBag[var7];

         for(int var1 = 0; var1 < Code.arrItemDel.length; ++var1) {
            if (var25 != null && Code.arrItemDel[var1] > 0 && var25.template.id == Code.arrItemDel[var1] && !var25.isLock) {
               return true;
            }
         }
      }

      return false;
   }

   private static Mob boss() {
      Mob local = null;

      for(int var26 = 0; var26 < GameScr.vMob.size(); ++var26) {
         Mob var24;
         if ((var24 = (Mob)GameScr.vMob.elementAt(var26)).status != 0 && var24.status != 1 && var24.s == idboss) {
            local = var24;
         }
      }

      return local;
   }

   protected void auto() {
      if (check_dead(Char.getMyChar())) {
         if (Char.remap) {
            hoisinh(false);
         }
      } else {
         if (Char.getMyChar().isHuman && Char.dung_pthan) {
            this.switchPthan();
            return;
         }

         if (this.map_auto == TileMap.mapID && this.khu_auto == TileMap.zoneID) {
            if (Code.solg_hanhtrang() <= 5) {
               if (this.checkdel()) {
                  this.locdo();
                  phong.sleep(200L);
               }

               return;
            }

            if (this.type == 0) {
               if (Code.check_item(this.idvp)) {
                  if (boss() == null) {
                     Service.gI().useItem(Code.get_item(this.idvp).indexUI);
                     phong.sleep(300L);
                  } else {
                     this.attack(idboss, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                  }
               } else {
                  Code.popup_chat("Đã hết vật phẩm cần sử dụng");
                  Code.mode = null;
               }
            }

            if (this.type == 1) {
               if (Code.check_item(this.idvp)) {
                  Service.gI().useItem(Code.get_item(this.idvp).indexUI);
                  phong.sleep(25L);
               } else {
                  Code.popup_chat("Đã hết vật phẩm cần sử dụng");
                  Code.mode = null;
               }
            }
         } else {
            this.remap(this.map_auto, this.khu_auto, -1, -1);
         }
      }

   }

   public String toString() {
      return "Auto vpsk";
   }

}
