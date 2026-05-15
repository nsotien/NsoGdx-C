public class As20 extends As10 {
   private int gameAV;
   private static int[] gameAW = new int[]{0, 1, 1, 72, 72, 27, 27};
   private static int[] gameAX = new int[]{0, 9, 9, 10, 10, 11, 11};
   private static int[] gameAY = new int[]{0, 0, 1, 0, 1, 0, 1};
   private static int[] gameAZ = new int[]{0, 94, 114, 99, 109, 105, 119};
   private static int[] gameBA = new int[]{-1, 40, 49, 58, 67, 76, 85};
   private static int[] gameBB = new int[]{-1, 41, 50, 59, 68, 77, 86};
   private static int[] gameBC = new int[]{-1, 42, 51, 60, 69, 78, 87};

   public As20(int var1) {
      super.gameAC();
      this.gameAV = var1;
   }

   public boolean gameAE(Char var1) {
      return var1.clevel >= 20;
   }

   public void gameAA(Char var1, byte var2, byte var3) {
      if (var1.ctaskId < 9) {
         super.gameAA(var1, var2, var3);
      } else {
         try {
            int var4;
            int var5;
            Item var6;
            int var7;
            int var9;
            int var12;
            int var13;
            Item var16;
            int var21;
            switch(var1.ctaskId) {
            case 9:
               if (var1.nClass.classId != 0) {
                  if (TileMap.mapID == 28) {
                     this.gameAC(-1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(28, -1, -1, -1);
                  return;
               }

               if (this.gameAV == 0) {
                  GameScr.gameAC("Hãy vào lớp!");
                  Code.gameAF();
                  return;
               }

               var9 = gameAW[this.gameAV];
               if (TileMap.mapID != var9) {
                  this.gameAA(var9, -2, -1, -1);
                  return;
               }

               GameScr.gameAB(5, 1, 0);

               for(var4 = 0; var4 < var1.arrItemBag.length; ++var4) {
                  if ((var6 = var1.arrItemBag[var4]) != null && (var6.template.type == 22 || var6.template.type == 27)) {
                     Service.gI().useItem(var6.indexUI);
                  }
               }

               Thread.sleep(1000L);
               if ((var16 = var1.arrItemBody[1]) != null) {
                  Service.gI().gameAB((short)var16.template.type);
                  LockGame.gameAQ();
               }

               GameScr.gameAB(gameAX[this.gameAV], 1, gameAY[this.gameAV]);

               do {
                  Thread.sleep(1000L);
               } while(Char.gameAF(gameAZ[this.gameAV]) == null);

               if ((var16 = Char.gameAF(gameBA[this.gameAV])) != null) {
                  Service.gI().useItem(var16.indexUI);
               }

               if ((var16 = Char.gameAF(gameAZ[this.gameAV])) != null) {
                  Service.gI().useItem(var16.indexUI);
               }

               Thread.sleep(1000L);
               GameScr.gameAB(4, 0, 0);

               for(var12 = 0; var12 < var1.arrItemBag.length; ++var12) {
                  if ((var16 = var1.arrItemBag[var12]) != null && (var16.template.type < 10 || var16.template.type == 16 || var16.template.type == 17 || var16.template.id == 23)) {
                     Service.gI().gameAH(var16.indexUI, var16.indexUI);
                  }
               }

               Service.gI().gameAF();
               LockGame.gameAS();
               return;
            case 10:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 28) {
                     this.gameAC(-1);
                     this.gameAB(5, 1);
                     return;
                  }

                  this.gameAA(28, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  if (TileMap.mapID == 4) {
                     this.gameAC(-1);
                     this.gameAB(6, 1);
                     return;
                  }

                  this.gameAA(4, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 2) {
                  if (TileMap.mapID == 46) {
                     this.gameAC(-1);
                     this.gameAB(7, 1);
                     return;
                  }

                  this.gameAA(46, -1, -1, -1);
                  return;
               }
               break;
            case 11:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 28) {
                     this.gameAC(-1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(28, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  for(var9 = 0; var9 < GameScr.vCharInMap.size(); ++var9) {
                     Char var18;
                     if ((var18 = (Char)GameScr.vCharInMap.elementAt(var9)) != null) {
                        Service.gI().gameAA(var18.cName);
                     }
                  }

                  var12 = super.zoneID;
                  GameScr var19 = GameScr.gI();
                  Npc var23;
                  if ((var23 = GameScr.gameAI(13)) != null && var23.statusMe != 15) {
                     if (Math.abs(var23.cx - Char.getMyChar().cx) > 22 || Math.abs(var23.cy - Char.getMyChar().cy) > 22) {
                        Char.gameAC(var23.cx, var23.cy);
                     }

                     Service.gI().gameAE();
                     LockGame.gameAE();
                     var9 = -1;
                     if (var12 < 0) {
                        var12 = var19.zones.length - 1;
                     } else if (var12 >= var19.zones.length) {
                        var12 = 0;
                     }

                     var4 = 0;

                     for(var21 = (var12 + 1) % var19.zones.length; var21 != var12; var21 = (var21 + 1) % var19.zones.length) {
                        if (var19.zones[var21] < 20 && var19.zones[var21] > var4) {
                           var9 = var21;
                           var4 = var19.zones[var21];
                        }
                     }

                     super.zoneID = var9;
                     Service.gI().gameAA((int)var9, (int)-1);
                     TileMap.gameAF();
                     Thread.sleep(100L);
                     return;
                  }

                  super.zoneID = TileMap.zoneID;
                  return;
               }
               break;
            case 12:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 3) {
                     this.gameAC(-1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(3, -1, -1, -1);
                  return;
               }

               boolean var14 = false;
               var4 = -1;
               var6 = null;
               if (var1.taskMaint.index == 1) {
                  var14 = true;
                  var4 = (new int[]{194, 94, 114, 99, 109, 105, 119})[var1.nClass.classId];
                  if ((var6 = var1.arrItemBody[1]) == null) {
                     var14 = false;
                     var6 = Char.gameAF(var4);
                  }
               } else if (var1.taskMaint.index == 2) {
                  var14 = true;
                  var4 = 174;
                  if ((var6 = var1.arrItemBody[9]) == null) {
                     var14 = false;
                     var6 = Char.gameAF(174);
                  }
               } else if (var1.taskMaint.index == 3) {
                  var14 = true;
                  var4 = var1.cgender == 1 ? 124 : 125;
                  if ((var6 = var1.arrItemBody[8]) == null) {
                     var14 = false;
                     var6 = Char.gameAF(var4);
                  }
               }

               if (var6 == null) {
                  if (TileMap.mapID == 4) {
                     this.gameAC(var4);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(4, -1, -1, -1);
                  return;
               }

               var7 = 0;
               var21 = 0;
               if (var6.gameAR()) {
                  var7 = GameScr.upClothe[var6.upgrade] / 2;
                  var21 = GameScr.coinUpClothes[var6.upgrade];
               } else if (var6.gameAS()) {
                  var7 = GameScr.upAdorn[var6.upgrade] / 2;
                  var21 = GameScr.coinUpAdorns[var6.upgrade];
               } else if (var6.gameAT()) {
                  var7 = GameScr.upWeapon[var6.upgrade] / 2;
                  var21 = GameScr.coinUpWeapons[var6.upgrade];
               }

               if (var7 << 1 > Char.reAA() || var21 << 1 > var1.yen) {
                  if (TileMap.mapID == 46) {
                     this.gameAC(1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(46, -1, -1, -1);
                  return;
               }

               if (TileMap.mapID != 22) {
                  this.gameAA(22, -2, -1, -1);
                  return;
               }

               if (var14) {
                  Service.gI().gameAB((int)var6.template.type);
                  LockGame.gameAQ();
               }

               var12 = var6.upgrade;
               GameScr.gameAB(6, 0, 0);
               LockGame.gameAQ();
               GameScr.arritemup = var6;

               for(var13 = 0; var13 < 2 && var6.upgrade == var12; ++var13) {
                  GameScr.upitem = new Item[18];
                  var5 = 0;
                  int var22 = 0;

                  for(var9 = 0; var9 < var1.arrItemBag.length && var22 < var7; ++var9) {
                     if ((var16 = var1.arrItemBag[var9]) != null && var16.template.type == 26 && var16.template.id <= 3) {
                        var1.arrItemBag[var9] = null;
                        GameScr.upitem[var5++] = var16;
                        var22 += GameScr.upClothe[var16.template.id];
                     }
                  }

                  do {
                     Thread.sleep(3000L);
                     Service.gI().gameAA(var6, GameScr.upitem);
                     LockGame.gameAQ();
                  } while(GameScr.upitem[0] != null);
               }

               GameScr.arritemup = null;
               Service.gI().useItem(var6.indexUI);
               if (var6.upgrade > var12) {
                  LockGame.gameAO();
                  return;
               }
               break;
            case 13:
               Item var10;
               if ((var10 = var1.arrItemBody[1]) != null && var10.upgrade < 2) {
                  var4 = GameScr.upWeapon[var10.upgrade] / 2;
                  var12 = GameScr.coinUpWeapons[var10.upgrade];
                  if (var4 << 1 <= Char.reAA() && var12 << 1 <= var1.yen) {
                     if (TileMap.mapID != 22) {
                        this.gameAA(22, -2, -1, -1);
                        return;
                     }

                     Service.gI().gameAB((int)var10.template.type);
                     LockGame.gameAQ();
                     var7 = var10.upgrade;
                     GameScr.gameAB(6, 0, 0);
                     LockGame.gameAQ();
                     GameScr.arritemup = var10;

                     for(var21 = 0; var21 < 2 && var10.upgrade == var7; ++var21) {
                        GameScr.upitem = new Item[18];
                        var12 = 0;
                        var13 = 0;

                        for(var5 = 0; var5 < var1.arrItemBag.length && var13 < var4; ++var5) {
                           if ((var6 = var1.arrItemBag[var5]) != null && var6.template.type == 26 && var6.template.id <= 3) {
                              var1.arrItemBag[var5] = null;
                              GameScr.upitem[var12++] = var6;
                              var13 += GameScr.upClothe[var6.template.id];
                           }
                        }

                        do {
                           Thread.sleep(3000L);
                           Service.gI().gameAA(var10, GameScr.upitem, false);
                           LockGame.gameAQ();
                        } while(GameScr.upitem[0] != null);
                     }

                     GameScr.arritemup = null;
                     Service.gI().useItem(var10.indexUI);
                     return;
                  }

                  if (TileMap.mapID == 4) {
                     this.gameAC(1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(4, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 4) {
                     this.gameAC(-1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(4, -1, -1, -1);
                  return;
               }

               var4 = var1.taskMaint.index == 1 ? 56 : (var1.taskMaint.index == 2 ? 0 : 73);
               if (TileMap.mapID != var4) {
                  if (TileMap.mapID != var2) {
                     super.gameAA(var2, -2, -1, -1);
                     return;
                  }

                  if (GameScr.gameAS < 10 && var1.yen >= 300 * (10 - GameScr.gameAS)) {
                     GameScr.gameAB(3, 0, 0);
                     Service.gI().gameAA(7, 1, 10 - GameScr.gameAS);
                     LockGame.gameAG();
                     return;
                  }

                  GameScr.gameAB(var3, 0, 0);
                  Service.gI().gameAJ(var3, 0);
                  TileMap.gameAF();
                  return;
               }

               if (var1.cHP < var1.cMaxHP / 2 && var1.cHP > 0) {
                  var1.gameAE(16);
               }

               if (var1.cMP < var1.cMaxMP / 2 && var1.cHP > 0) {
                  var1.gameAE(17);
               }

               Char var17;
               if (GameScr.vCharInMap.size() > 0 && (var17 = (Char)GameScr.vCharInMap.elementAt(0)) != null) {
                  Skill var20 = Auto.skill1;
                  if (Res.abs(var1.cx - var17.cx) > var20.dx || Res.abs(var1.cy - var17.cy) > var20.dy) {
                     Char.gameAC(var17.cx < TileMap.pxw ? var17.cx : TileMap.pxw - 50, var17.cy);
                  }

                  Auto.reAE.removeAllElements();
                  Auto.reAF.removeAllElements();
                  Auto.reAF.addElement(var17);
                  Service.gI().gameAA((MyVector)Auto.reAE, (MyVector)Auto.reAF, (int)1);
                  if (System.currentTimeMillis() - var20.lastTimeUseThisSkill >= (long)var20.coolDown) {
                     var20.lastTimeUseThisSkill = System.currentTimeMillis();
                     var20.paintCanNotUseSkill = true;
                     var1.gameAB(GameScr.sks[var20.template.id], 0);
                     return;
                  }

                  return;
               }
               break;
            case 14:
               if (var1.clevel >= 15 && (var6 = Char.gameAF(gameBB[var1.nClass.classId])) != null) {
                  GameScr.gameAC("Học sách kĩ năng");
                  Service.gI().useItem(var6.indexUI);
                  Thread.sleep(1000L);
               }

               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 29) {
                     this.gameAC(-1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(29, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  if (TileMap.mapID == 29 && super.zoneID == TileMap.zoneID) {
                     var4 = Code.gameAM < 0 ? -1 : Code.gameAM * Code.gameAM;
                     ItemMap var8 = null;

                     for(var7 = 0; var7 < GameScr.vItemMap.size(); ++var7) {
                        ItemMap var15;
                        var12 = Math.abs((var15 = (ItemMap)GameScr.vItemMap.elementAt(var7)).x - var1.cx);
                        var13 = Math.abs(var15.y - var1.cy);
                        var5 = var12 * var12 + var13 * var13;
                        if (!var15.gameAK && var15.template.id == 212 && (Char.gameBG() > 2 || Char.gameAJ(212)) && (var4 < 0 || var5 < var4)) {
                           var4 = var5;
                           var8 = var15;
                        }
                     }

                     if (var8 == null) {
                        super.zoneID = (super.zoneID + 1) % 30;
                        return;
                     }

                     Char.gameAC(var8.xEnd, var8.yEnd);
                     Service.gI().gameAQ(var8.itemMapID);

                     for(var7 = 0; var7 < 5 && !LockGame.gameAC(); ++var7) {
                     }

                     var8.gameAK = true;
                     return;
                  }

                  this.gameAA(29, super.zoneID, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 2) {
                  if (TileMap.mapID == 40) {
                     this.gameAB(15, 1);
                     this.gameAC(213);
                     return;
                  }

                  this.gameAA(40, -1, -1, -1);
                  return;
               }
               break;
            case 15:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 8) {
                     this.gameAC(-1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(8, -1, -1, -1);
                  return;
               }

               if (TileMap.mapID != var2) {
                  super.gameAA(var2, -2, -1, -1);
                  return;
               }

               GameScr.gameAB(var3, 0, 0);
               LockGame.gameAO();
               Auto.reAD();
               return;
            case 16:
               if (var1.clevel >= 20 && (var6 = Char.gameAF(gameBC[var1.nClass.classId])) != null) {
                  GameScr.gameAC("Học sách kĩ năng");
                  Service.gI().useItem(var6.indexUI);
                  Thread.sleep(1000L);
               }

               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 8) {
                     this.gameAC(-1);
                     this.gameAB(-1, 1);
                     return;
                  }

                  this.gameAA(8, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  if (TileMap.mapID == 63) {
                     this.gameAC(-1);
                     this.gameAB(23, 1);
                     return;
                  }

                  this.gameAA(63, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 2) {
                  if (TileMap.mapID == 47) {
                     this.gameAC(-1);
                     this.gameAB(24, 1);
                     return;
                  }

                  this.gameAA(47, -1, -1, -1);
               }
            }

         } catch (InterruptedException var11) {
            var11.printStackTrace();
         }
      }
   }

   public String toString() {
      return "Auto Nhiệm Vụ 20";
   }
}
