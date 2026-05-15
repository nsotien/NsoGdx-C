package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoPkam extends Auto {
   private static long w = 0L;
   private boolean y = false;
   public static Auto a;

   public void runPkamExp() {
      super.reset();
      this.khu_auto = menu_pkam.khudpk;
      this.map_auto = menu_pkam.map;
   }

   protected void auto() {
      long var1 = (Char.getMyChar().cExpDown > 0L ? Char.getMyChar().cExpDown : Char.getMyChar().ae) * 100L / GameScr.exps[Char.getMyChar().cLevel];
      if ((Char.getMyChar().cExpDown <= 0L || Math.abs(var1) > 15L) && (Char.getMyChar().cExpDown > 0L || Math.abs(var1) < 0L)) {
         Service.gI().z(0);
         Code.popup_chat("Đã pk xong!!");
         if (a != null) {
            Code.mode = a;
            a = null;
            return;
         }

         Code.remode();
      } else {
         if (Char.getMyChar().cPk <= 10 && !this.y) {
            if (check_dead(Char.getMyChar())) {
               hoisinh(true);
               return;
            }

            if (TileMap.mapID == menu_pkam.map && TileMap.zoneID == menu_pkam.khucpk) {
               if (Char.getMyChar().cx1 == menu_pkam.x && Char.getMyChar().cy1 == menu_pkam.y) {
                  if (System.currentTimeMillis() - w >= 300L) {
                     MyVector var4 = new MyVector();

                     for(int var2 = 0; var2 < GameScr.vCharInMap.size(); ++var2) {
                        Char var3;
                        if ((var3 = (Char)GameScr.vCharInMap.elementAt(var2)).cHP > 0 && Math.abs(Char.getMyChar().cx1 - var3.cx1) <= 50 && Math.abs(Char.getMyChar().cy1 - var3.cy1) <= 50 && var4.size() <= my_skill.maxFight) {
                           var4.addElement(var3);
                           if (var3.cHP > 0 && Math.abs(Char.getMyChar().cx1 - var3.cx1) <= 50 && Math.abs(Char.getMyChar().cy1 - var3.cy1) <= 50) {
                              Service.gI().sendPlayerAttack(new MyVector(), var4, 2);
                              w = System.currentTimeMillis();
                           }
                        }
                     }
                  }

                  phong.sleep(100L);
                  return;
               }

               Service.gI().z(3);
               if (menu_pkam.x != -1 && menu_pkam.y != -1) {
                  Char.move(menu_pkam.x, menu_pkam.y);
               } else {
                  menu_pkam.x = Char.getMyChar().cx1;
                  menu_pkam.y = Char.getMyChar().cy1;
               }

               phong.sleep(500L);
               return;
            }

            this.remap(menu_pkam.map, menu_pkam.khucpk, -1, -1);
            return;
         }

         this.y = Char.getMyChar().cPk > 6;
         if (check_dead(Char.getMyChar())) {
            hoisinh(true);
            return;
         }

         if (TileMap.mapID != menu_pkam.map || TileMap.zoneID != menu_pkam.khudpk) {
            this.remap(menu_pkam.map, menu_pkam.khudpk, -1, -1);
            return;
         }

         if (Char.getMyChar().cx1 != menu_pkam.x || Char.getMyChar().cy1 != menu_pkam.y) {
            Service.gI().z(3);
            if (menu_pkam.x != -1 && menu_pkam.y != -1) {
               Char.move(menu_pkam.x, menu_pkam.y);
            } else {
               menu_pkam.x = Char.getMyChar().cx1;
               menu_pkam.y = Char.getMyChar().cy1;
            }

            phong.sleep(500L);
            return;
         }

         Code.gkn();
      }

   }

   public String toString() {
      return "Auto PK âm";
   }

}
