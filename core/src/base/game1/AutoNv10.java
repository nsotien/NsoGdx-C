package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoNv10 extends Auto {

   public AutoNv10() {
      super.reset();
   }

   public boolean checkTask(Char var1) {
      return var1.ctaskId >= 9;
   }

   public void a(Char var1, int var2, byte var3) {
      Item var7;
      switch (var1.ctaskId) {
         case 0:
            NpcTemplate var5 = Npc.arrNpcTemplate[var3];

            for(var2 = 0; var2 < var5.menu.length; ++var2) {
               if (var5.menu[var2][0].equals("Nói chuyện")) {
                  GameScr.npc_b(var3, var2, 0);
                  phong1.o();
                  return;
               }
            }

            return;
         case 1:
            if (var1.ca.a == 0) {
               GameScr.npc_b(var3, 0, 0);
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 1) {
               Service.gI().b(var3, 0, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 2) {
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 3) {
               Service.gI().b(var3, 2, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 4) {
               Service.gI().b(var3, 0, -1);
               phong1.o();
               return;
            }
            break;
         case 2:
            if (var1.ca.a == 0) {
               for(var2 = 0; var2 < var1.arrItemBag.length; ++var2) {
                  if ((var7 = var1.arrItemBag[var2]) != null && var7.template.id == 194) {
                     Service.gI().useItem(var7.indexUI);
                     break;
                  }
               }

               phong1.o();
               return;
            }

            if (var1.ca.a == 1) {
               if (TileMap.mapID == 22) {
                  this.nhatdo(-1);
                  this.attack(0, 1);
                  return;
               }

               this.remap(22, -1, -1, -1);
               return;
            }
            break;
         case 3:
            if (var1.ca.a == 0) {
               phong.sleep(2000L);
               GameScr.npc_b(4, 0, 0);
               Service.gI().a(9, 0, 3);
               phong1.o();
               return;
            }

            if (var1.ca.a == 1) {
               for(var2 = 0; var2 < var1.arrItemBag.length; ++var2) {
                  if ((var7 = var1.arrItemBag[var2]) != null && var7.template.id == 23) {
                     Service.gI().useItem(var7.indexUI);
                     break;
                  }
               }

               phong1.o();
               return;
            }

            if (var1.ca.a == 2) {
               if (TileMap.mapID == 23) {
                  this.nhatdo(-1);
                  this.attack(1, 1);
                  return;
               }

               this.remap(23, -1, -1, -1);
               return;
            }

            if (var1.ca.a == 3) {
               if (TileMap.mapID == 23) {
                  this.nhatdo(-1);
                  this.attack(2, 1);
                  return;
               }

               this.remap(23, -1, -1, -1);
               return;
            }
            break;
         case 4:
            if (var1.ca.a == 0) {
               if (TileMap.mapID == 21) {
                  this.nhatdo(-1);
                  this.attack(-1, 1);
                  return;
               }

               this.remap(21, -1, -1, -1);
               return;
            }

            if (var1.ca.a == 1) {
               if (TileMap.mapID == 21) {
                  this.nhatdo(209);
                  this.attack(3, 1);
                  return;
               }

               this.remap(21, -1, -1, -1);
               return;
            }

            if (var1.ca.a == 2) {
               if (TileMap.mapID == 23) {
                  this.nhatdo(210);
                  this.attack(4, 1);
                  return;
               }

               this.remap(23, -1, -1, -1);
               return;
            }
            break;
         case 5:
            if (var1.ca.a == 0) {
               if (TileMap.mapID == 20) {
                  this.nhatdo(-1);
                  this.attack(3, 1);
                  return;
               }

               this.remap(20, -1, -1, -1);
               return;
            }

            if (var1.ca.a == 1) {
               if (TileMap.mapID == 20) {
                  this.nhatdo(211);
                  this.attack(54, 1);
                  return;
               }

               this.remap(20, -1, -1, -1);
               return;
            }
            break;
         case 6:
            if (var1.ca.a == 0) {
               if (TileMap.mapID == 26) {
                  this.nhatdo(-1);
                  this.attack(-1, 1);
                  return;
               }

               this.remap(26, -1, -1, -1);
               return;
            }

            if (var1.ca.a == 1) {
               this.remap(2, -2, -1, -1);
               phong.sleep(500L);
               return;
            }

            if (var1.ca.a == 2) {
               this.remap(71, -2, -1, -1);
               phong.sleep(500L);
               return;
            }

            if (var1.ca.a == 3) {
               this.remap(26, -2, -1, -1);
               phong.sleep(500L);
               return;
            }
            break;
         case 7:
            if (var1.ca.a == 0) {
               if (TileMap.mapID == 71) {
                  this.nhatdo(-1);
                  this.attack(-1, 1);
                  return;
               }

               this.remap(71, -1, -1, -1);
               return;
            }

            if (var1.ca.a == 1) {
               this.remap(var2, -2, -1, -1);
               GameScr.npc_b(var3, 0, 0);
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 2) {
               Service.gI().b(var3, 0, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 3) {
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 4) {
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 5) {
               Service.gI().b(var3, 2, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 6) {
               GameScr.npc_b(var3, 0, 0);
               Service.gI().b(var3, 2, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 7) {
               Service.gI().b(var3, 0, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 8) {
               Service.gI().b(var3, 2, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 9) {
               Service.gI().b(var3, 2, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 10) {
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 11) {
               GameScr.npc_b(var3, 0, 0);
               Service.gI().b(var3, 0, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 12) {
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 13) {
               Service.gI().b(var3, 2, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 14) {
               Service.gI().b(var3, 2, -1);
               phong1.o();
               return;
            }

            if (var1.ca.a == 15) {
               Service.gI().b(var3, 1, -1);
               phong1.o();
               return;
            }
            break;
         case 8:
            if (var1.ca.a == 0) {
               if (TileMap.mapID == 26) {
                  this.nhatdo(-1);
                  this.attack(-1, 1);
                  return;
               }

               this.remap(26, -1, -1, -1);
               return;
            }

            this.remap(var2, -2, -1, -1);
            GameScr.npc_h(var3);
            NpcTemplate var6 = Npc.arrNpcTemplate[var3];

            for(int var4 = 0; var4 < var6.menu.length; ++var4) {
               if (var6.menu[var4][0].equals("Nói chuyện")) {
                  GameScr.npc_b(var3, var4, 0);
                  phong1.o();
                  phong.sleep(1000L);
                  return;
               }
            }
      }

   }

   protected void auto() {
      Char var1 = Char.getMyChar();
      if (this.checkTask(var1)) {
         Code.popup_chat("Xong!");
         Code.mode = null;
      } else {
         byte var2 = GameScr.ae();
         byte var3 = GameScr.af();
         if (check_dead(var1)) {
            hoisinh(false);
         } else if (var1.ca == null) {
            if (TileMap.mapID != var2) {
               this.remap(var2, -2, -1, -1);
            } else {
               GameScr.npc_b(var3, 0, 0);
               Service.gI().b(var3, 0, -1);
               phong1.o();
               super.khu_auto = -1;
            }
         } else if (var1.ca.a >= var1.ca.e.length - 1) {
            if (TileMap.mapID != var2) {
               this.remap(var2, -2, -1, -1);
            } else {
               GameScr.npc_b(var3, 0, 0);
               Service.gI().b(var3, 0, -1);
               phong1.o();
               super.khu_auto = -1;
            }
         } else {
            this.a(var1, var2, var3);
         }
      }

   }

   public String toString() {
      return "Auto NV 10";
   }

}
