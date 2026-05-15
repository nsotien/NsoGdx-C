package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class AutoNv20 extends AutoNv10 {
   private int a;
   private static int[] w = new int[]{0, 1, 1, 72, 72, 27, 27};
   private static int[] x = new int[]{0, 9, 9, 10, 10, 11, 11};
   private static int[] y = new int[]{0, 0, 1, 0, 1, 0, 1};
   private static int[] z = new int[]{0, 94, 114, 99, 109, 105, 119};
   private static int[] aa = new int[]{-1, 40, 49, 58, 67, 76, 85};
   private static int[] ab = new int[]{-1, 41, 50, 59, 68, 77, 86};
   private static int[] ac = new int[]{-1, 42, 51, 60, 69, 78, 87};

   private static int af() {
      Item[] var0 = Char.getMyChar().arrItemBag;
      int var1 = 0;

      for(int var2 = 0; var2 < var0.length; ++var2) {
         Item var3;
         if ((var3 = var0[var2]) != null && var3.template.type == 26 && var3.template.id <= 4) {
            var1 += GameScr.cy[var3.template.id];
         }
      }

      return var1;
   }

   public AutoNv20() {
      super.reset();
      this.a = 0;
   }

   public boolean checkTask(Char var1) {
      return var1.ctaskId >= 17;
   }

   public void a(Char var1, int var2, byte var3) {
      if (var1.ctaskId < 9) {
         super.a(var1, (byte)var2, var3);
      } else {
         int var5;
         Item var11;
         int var18;
         switch (var1.ctaskId) {
            case 9:
               if (var1.nClass.a != 0) {
                  if (TileMap.mapID == 28) {
                     this.nhatdo(-1);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(28, -1, -1, -1);
                  return;
               }

               if (this.a == 0) {
                  Code.popup_chat("Hãy vào lớp!");
                  Code.mode = null;
                  return;
               }
            case 10:
               if (var1.ca.a == 0) {
                  if (TileMap.mapID == 28) {
                     this.nhatdo(-1);
                     this.attack(5, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(28, -1, -1, -1);
                  return;
               }

               if (var1.ca.a == 1) {
                  if (TileMap.mapID == 4) {
                     this.nhatdo(-1);
                     this.attack(6, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(4, -1, -1, -1);
                  return;
               }

               if (var1.ca.a == 2) {
                  if (TileMap.mapID == 46) {
                     this.nhatdo(-1);
                     this.attack(7, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(46, -1, -1, -1);
                  return;
               }
               break;
            case 11:
               if (var1.ca.a == 0) {
                  if (TileMap.mapID == 28) {
                     this.nhatdo(-1);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(28, -1, -1, -1);
                  return;
               }

               if (var1.ca.a == 1) {
                  for(var18 = 0; var18 < GameScr.vCharInMap.size(); ++var18) {
                     Char var21;
                     if ((var21 = (Char)GameScr.vCharInMap.elementAt(var18)) != null) {
                        Service.gI().e(var21.cName);
                     }
                  }
               }
               break;
            case 12:
               if (var1.ca.a == 0) {
                  if (TileMap.mapID == 3) {
                     this.nhatdo(-1);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(3, -1, -1, -1);
                  return;
               }

               boolean var14 = false;
               var5 = -1;
               var11 = null;
               if (var1.ca.a == 1) {
                  var14 = true;
                  var5 = (new int[]{194, 94, 114, 99, 109, 105, 119})[var1.nClass.a];
                  if ((var11 = var1.arrItemBody[1]) == null) {
                     var14 = false;
                     var11 = Code.get_item(var5);
                  }
               } else if (var1.ca.a == 2) {
                  var14 = true;
                  var5 = 174;
                  if ((var11 = var1.arrItemBody[9]) == null) {
                     var14 = false;
                     var11 = Code.get_item(174);
                  }
               } else if (var1.ca.a == 3) {
                  var14 = true;
                  var5 = var1.cgender == 1 ? 124 : 125;
                  if ((var11 = var1.arrItemBody[8]) == null) {
                     var14 = false;
                     var11 = Code.get_item(var5);
                  }
               }

               if (var11 == null) {
                  if (TileMap.mapID == 4) {
                     this.nhatdo(var5);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(4, -1, -1, -1);
                  return;
               }

               var3 = 0;
               int var16 = 0;
               if (var11.r()) {
                  var3 = (byte)(GameScr.cy[var11.upgrade] / 2);
                  var16 = GameScr.dc[var11.upgrade];
               } else if (var11.s()) {
                  var3 = (byte)(GameScr.cz[var11.upgrade] / 2);
                  var16 = GameScr.dd[var11.upgrade];
               } else if (var11.t()) {
                  var3 = (byte)(GameScr.da[var11.upgrade] / 2);
                  var16 = GameScr.de[var11.upgrade];
               }

               if (var3 << 1 <= af() && var16 << 1 <= var1.yen) {
                  if (TileMap.mapID != 22) {
                     this.remap(22, -2, -1, -1);
                     return;
                  }

                  if (var14) {
                     Service.gI().b((int)var11.template.type);
                     phong1.q();
                  }

                  int var7 = var11.upgrade;
                  GameScr.npc_b(6, 0, 0);
                  phong1.q();
                  GameScr.ci = var11;

                  for(int var8 = 0; var8 < 2 && var11.upgrade == var7; ++var8) {
                     GameScr.ca = new Item[18];
                     int var9 = 0;
                     int var22 = 0;

                     for(var18 = 0; var18 < var1.arrItemBag.length && var22 < var3; ++var18) {
                        Item var19;
                        if ((var19 = var1.arrItemBag[var18]) != null && var19.template.type == 26 && var19.template.id <= 3) {
                           var1.arrItemBag[var18] = null;
                           GameScr.ca[var9++] = var19;
                           var22 += GameScr.cy[var19.template.id];
                        }
                     }

                     do {
                        phong.sleep(1000L);
                        Service.gI().a(GameScr.ci, GameScr.ca, false);
                        phong1.q();
                     } while(GameScr.ca[0] != null);
                  }

                  GameScr.ci = null;
                  Service.gI().useItem(var11.indexUI);
                  if (var11.upgrade > var7) {
                     phong1.o();
                     return;
                  }
                  break;
               }

               if (TileMap.mapID == 46) {
                  this.nhatdo(1);
                  this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                  return;
               }

               this.remap(46, -1, -1, -1);
               return;
            case 13:
               if (var1.ca.a == 0) {
                  if (TileMap.mapID == 4) {
                     this.nhatdo(-1);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(4, -1, -1, -1);
                  return;
               }

               var5 = var1.ca.a == 1 ? 56 : (var1.ca.a == 2 ? 0 : 73);
               if (TileMap.mapID != var5) {
                  if (TileMap.mapID != var2) {
                     this.remap(var2, -2, -1, -1);
                     return;
                  }

                  if (GameScr.mpPotion < 10 && var1.yen >= 300 * (10 - GameScr.mpPotion)) {
                     GameScr.npc_b(3, 0, 0);
                     Service.gI().a(7, 1, 10 - GameScr.mpPotion);
                     phong1.g();
                     return;
                  }

                  GameScr.npc_b(var3, 0, 0);
                  Service.gI().j(var3, 0);
                  TileMap.f1();
                  return;
               }

               if (var1.cHP < var1.cMaxHP / 2 && var1.cHP > 0) {
                  var1.e(16);
               }

               if (var1.cMP < var1.cMaxMP / 2 && var1.cHP > 0) {
                  var1.e(17);
               }

               Char var13;
               if (GameScr.vCharInMap.size() > 0 && (var13 = (Char)GameScr.vCharInMap.elementAt(0)) != null) {
                  Skill var15 = Auto.my_skill;
                  if (Res.e(var1.cx1 - var13.cx1) > var15.dx || Res.e(var1.cy1 - var13.cy1) > var15.dy) {
                     if (var1.ca.a == 2) {
                        if (!Char.a(var13)) {
                           Char.move(974, 240);
                           phong.sleep(500L);
                           MotherCanvas.a.b.c(-1);
                           phong.sleep(250L);
                           MotherCanvas.a.b.d(-1);
                           phong.sleep(500L);
                           return;
                        }

                        Char.move(var13.cx1 < TileMap.pxw ? var13.cx1 : TileMap.pxw - 50, var13.cy1);
                     } else {
                        Char.move(var13.cx1 < TileMap.pxw ? var13.cx1 : TileMap.pxw - 50, var13.cy1);
                     }
                  }

                  Auto.vect_mons.removeAllElements();
                  Auto.vect_player.removeAllElements();
                  Auto.vect_player.addElement(var13);
                  Service.gI().sendPlayerAttack(Auto.vect_mons, Auto.vect_player, 1);
                  if (System.currentTimeMillis() - var15.lastTimeUseThisSkill >= (long)var15.coolDown) {
                     var15.lastTimeUseThisSkill = System.currentTimeMillis();
                     var15.l = true;
                     return;
                  }
               }
               break;
            case 14:
               if (var1.cLevel >= 15 && (var11 = Code.get_item(ab[var1.nClass.a])) != null) {
                  Code.popup_chat("Học sách kĩ năng");
                  Service.gI().useItem(var11.indexUI);
                  phong.sleep(1000L);
               }

               if (var1.ca.a == 0) {
                  if (TileMap.mapID == 29) {
                     this.nhatdo(-1);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(29, -1, -1, -1);
                  return;
               }

               if (var1.ca.a == 1) {
                  if (TileMap.mapID == 29) {
                     if (Code.solg_hanhtrang() > 1) {
                        if (phong.checkItemExist(212)) {
                           this.nhatdo(212);
                           return;
                        }

                        this.chuyenkhu2(TileMap.zoneID);
                     } else {
                        Code.popup_chat("Hành trang đầy, dừng auto");
                        Code.mode = null;
                     }
                  }

                  this.remap(29, super.khu_auto, -1, -1);
                  return;
               }

               if (var1.ca.a == 2) {
                  if (TileMap.mapID == 40) {
                     this.attack(15, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     this.nhatdo(213);
                     return;
                  }

                  this.remap(40, -1, -1, -1);
                  return;
               }
               break;
            case 15:
               if (var1.ca.a == 0) {
                  if (TileMap.mapID == 63) {
                     this.nhatdo(-1);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  } else {
                     this.remap(63, -1, -1, -1);
                     return;
                  }
               } else if (TileMap.mapID != var2) {
                  this.remap(var2, -2, -1, -1);
                  return;
               } else {
                  GameScr.npc_b(var3, 0, 0);
                  phong1.o();
                  Auto.tusat_vdmq();
                  return;
               }
            case 16:
               if (var1.cLevel >= 20 && (var11 = Code.get_item(ac[var1.nClass.a])) != null) {
                  Code.popup_chat("Học sách kĩ năng");
                  Service.gI().useItem(var11.indexUI);
                  phong.sleep(1000L);
               }

               if (var1.ca.a == 0) {
                  if (TileMap.mapID == 63) {
                     this.nhatdo(-1);
                     this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(63, -1, -1, -1);
                  return;
               }

               if (var1.ca.a == 1) {
                  if (TileMap.mapID == 63) {
                     this.nhatdo(-1);
                     this.attack(23, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(63, -1, -1, -1);
                  return;
               }

               if (var1.ca.a == 2) {
                  if (TileMap.mapID == 47) {
                     this.nhatdo(-1);
                     this.attack(24, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                     return;
                  }

                  this.remap(47, -1, -1, -1);
               }
         }
      }

   }

   public String toString() {
      return "Auto NV 20";
   }

}
