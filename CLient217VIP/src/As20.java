public class As20 extends As10 {
   private int fieldAV;
   private static int[] fieldAW;
   private static int[] fieldAX;
   private static int[] fieldAY;
   private static int[] fieldAZ;
   private static int[] fieldBA;
   private static int[] fieldBB;
   private static int[] fieldBC;

   private static int at(int[] a, int i) {
      if (a != null && a.length != 0) {
         if (i < 0) {
            i = 0;
         }

         if (i >= a.length) {
            i = a.length - 1;
         }

         return a[i];
      } else {
         return 0;
      }
   }

   private static void fieldAM() {
      fieldAW = new int[]{0, 1, 1, 72, 72, 27, 27};
      fieldAX = new int[]{0, 9, 9, 10, 10, 11, 11};
      fieldAY = new int[]{0, 0, 1, 0, 1, 0, 1};
      fieldAZ = new int[]{0, 94, 114, 99, 109, 105, 119};
      fieldBA = new int[]{-1, 40, 49, 58, 67, 76, 85};
      fieldBB = new int[]{-1, 41, 50, 59, 68, 77, 86};
      fieldBC = new int[]{-1, 42, 51, 60, 69, 78, 87};
   }

   public As20(int var1) {
      super.fieldAD();
      this.fieldAV = var1;
   }

   public boolean fieldAA(Char var1) {
      return var1.clevel >= 20;
   }

   public void fieldAA(Char var1, byte var2, byte var3) {
      if (var1.ctaskId < 9) {
         super.fieldAA(var1, var2, var3);
      } else {
         switch (var1.ctaskId) {
            case 9:
               if (var1.nClass.classId != 0) {
                  if (TileMap.mapID == 28) {
                     this.fieldAC(-1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(28, -1, -1, -1);
                  return;
               }

               if (this.fieldAV == 0) {
                  GameScr.fieldAC("Hãy vào lớp!");
                  Code.fieldAG();
                  return;
               }

               int var20x = fieldAW[this.fieldAV];
               if (TileMap.mapID != var20x) {
                  this.fieldAA(var20x, -2, -1, -1);
                  return;
               }

               GameScr.fieldAB(5, 1, 0);

               for (int var5 = 0; var5 < var1.arrItemBag.length; var5++) {
                  Item var11xx;
                  if ((var11xx = var1.arrItemBag[var5]) != null && (var11xx.template.type == 22 || var11xx.template.type == 27)) {
                     Service.gI().useItem(var11xx.indexUI);
                  }
               }

               CUONGNSO.sleep(1000L);
               Item var21;
               if ((var21 = var1.arrItemBody[1]) != null) {
                  Service.gI().sendAttackMobFast(var21.template.type);
                  LockGame.fieldAQ();
               }

               GameScr.fieldAB(fieldAX[this.fieldAV], 1, fieldAY[this.fieldAV]);

               do {
                  CUONGNSO.sleep(1000L);
               } while (Char.fieldAF(fieldAZ[this.fieldAV]) == null);

               if ((var21 = Char.fieldAF(fieldBA[this.fieldAV])) != null) {
                  Service.gI().useItem(var21.indexUI);
               }

               if ((var21 = Char.fieldAF(fieldAZ[this.fieldAV])) != null) {
                  Service.gI().useItem(var21.indexUI);
               }

               CUONGNSO.sleep(1000L);
               GameScr.fieldAB(4, 0, 0);

               for (int var15 = 0; var15 < var1.arrItemBag.length; var15++) {
                  if ((var21 = var1.arrItemBag[var15]) != null
                     && (var21.template.type < 10 || var21.template.type == 16 || var21.template.type == 17 || var21.template.id == 23)) {
                     Service.gI().saleItem1(var21.indexUI, var21.indexUI);
                  }
               }

               Service.gI().bagSort();
               LockGame.fieldAS();
               return;
            case 10:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 28) {
                     this.fieldAC(-1);
                     this.fieldAB(5, 1);
                     return;
                  }

                  this.fieldAA(28, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  if (TileMap.mapID == 4) {
                     this.fieldAC(-1);
                     this.fieldAB(6, 1);
                     return;
                  }

                  this.fieldAA(4, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 2) {
                  if (TileMap.mapID == 46) {
                     this.fieldAC(-1);
                     this.fieldAB(7, 1);
                     return;
                  }

                  this.fieldAA(46, -1, -1, -1);
                  return;
               }
               break;
            case 11:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 28) {
                     this.fieldAC(-1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(28, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  for (int var20 = 0; var20 < GameScr.vCharInMap.size(); var20++) {
                     Char var23;
                     if ((var23 = (Char)GameScr.vCharInMap.elementAt(var20)) != null) {
                        Service.gI().requestForgetPass(var23.cName);
                     }
                  }

                  int var15 = super.fieldAC;
                  GameScr var19 = GameScr.gI();
                  Npc var22;
                  if ((var22 = GameScr.fieldAI(13)) != null && var22.statusMe != 15) {
                     if (Math.abs(var22.cx - Char.getMyChar().cx) > 22 || Math.abs(var22.cy - Char.getMyChar().cy) > 22) {
                        Char.fieldAC(var22.cx, var22.cy);
                     }

                     Service.gI().openUIZone();
                     LockGame.fieldAE();
                     int var41 = -1;
                     if (var15 < 0) {
                        var15 = var19.zones.length - 1;
                     } else if (var15 >= var19.zones.length) {
                        var15 = 0;
                     }

                     int var5 = 0;

                     for (int var18 = (var15 + 1) % var19.zones.length; var18 != var15; var18 = (var18 + 1) % var19.zones.length) {
                        if (var19.zones[var18] < 20 && var19.zones[var18] > var5) {
                           var41 = var18;
                           var5 = var19.zones[var18];
                        }
                     }

                     super.fieldAC = var41;
                     Service.gI().requestChangeZone(var41, -1);
                     TileMap.fieldAF();
                     CUONGNSO.sleep(100L);
                     return;
                  }

                  super.fieldAC = TileMap.zoneID;
                  return;
               }
               break;
            case 12:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 3) {
                     this.fieldAC(-1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(3, -1, -1, -1);
                  return;
               }

               boolean var16 = false;
               int var5xxx = -1;
               Item var11xx = null;
               if (var1.taskMaint.index == 1) {
                  var16 = true;
                  var5xxx = new int[]{194, 94, 114, 99, 109, 105, 119}[var1.nClass.classId];
                  if ((var11xx = var1.arrItemBody[1]) == null) {
                     var16 = false;
                     var11xx = Char.fieldAF(var5xxx);
                  }
               } else if (var1.taskMaint.index == 2) {
                  var16 = true;
                  var5xxx = 174;
                  if ((var11xx = var1.arrItemBody[9]) == null) {
                     var16 = false;
                     var11xx = Char.fieldAF(174);
                  }
               } else if (var1.taskMaint.index == 3) {
                  var16 = true;
                  var5xxx = var1.cgender == 1 ? 124 : 125;
                  if ((var11xx = var1.arrItemBody[8]) == null) {
                     var16 = false;
                     var11xx = Char.fieldAF(var5xxx);
                  }
               }

               if (var11xx == null) {
                  if (TileMap.mapID == 4) {
                     this.fieldAC(var5xxx);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(4, -1, -1, -1);
                  return;
               }

               int var13x = 0;
               int var18x = 0;
               if (var11xx.isTypeClothe()) {
                  var13x = at(GameScr.upClothe, var11xx.upgrade) / 2;
                  var18x = at(GameScr.coinUpClothes, var11xx.upgrade);
               } else if (var11xx.isTypeAdorn()) {
                  var13x = at(GameScr.upAdorn, var11xx.upgrade) / 2;
                  var18x = at(GameScr.coinUpAdorns, var11xx.upgrade);
               } else if (var11xx.isTypeWeapon()) {
                  var13x = at(GameScr.upWeapon, var11xx.upgrade) / 2;
                  var18x = at(GameScr.coinUpWeapons, var11xx.upgrade);
               }

               if (var13x << 1 <= Char.fieldBE() && var18x << 1 <= var1.yen) {
                  if (TileMap.mapID != 22) {
                     this.fieldAA(22, -2, -1, -1);
                     return;
                  }

                  if (var16) {
                     Service.gI().itemBodyToBag(var11xx.template.type);
                     LockGame.fieldAQ();
                  }

                  int var7 = var11xx.upgrade;
                  GameScr.fieldAB(6, 0, 0);
                  LockGame.fieldAQ();
                  GameScr.itemUpGrade = var11xx;

                  for (int var8 = 0; var8 < 2 && var11xx.upgrade == var7; var8++) {
                     GameScr.arrItemUpGrade = new Item[18];
                     int var9x = 0;
                     int var24 = 0;

                     for (int var20xx = 0; var20xx < var1.arrItemBag.length && var24 < var13x; var20xx++) {
                        Item var21x;
                        if ((var21x = var1.arrItemBag[var20xx]) != null && var21x.template.type == 26 && var21x.template.id <= 3) {
                           var1.arrItemBag[var20xx] = null;
                           GameScr.arrItemUpGrade[var9x++] = var21x;
                           var24 += at(GameScr.upClothe, var21x.template.id);
                        }
                     }

                     do {
                        CUONGNSO.sleep(3000L);
                        Service.gI().upgradeItem(var11xx, GameScr.arrItemUpGrade, false);
                        LockGame.fieldAQ();
                     } while (GameScr.arrItemUpGrade[0] != null);
                  }

                  GameScr.itemUpGrade = null;
                  Service.gI().useItem(var11xx.indexUI);
                  if (var11xx.upgrade > var7) {
                     LockGame.fieldAO();
                     return;
                  }
                  break;
               }

               if (TileMap.mapID == 46) {
                  this.fieldAC(1);
                  this.fieldAB(-1, 1);
                  return;
               }

               this.fieldAA(46, -1, -1, -1);
               return;
            case 13:
               Item var4;
               if ((var4 = var1.arrItemBody[1]) != null && var4.upgrade < 2) {
                  int var5x = at(GameScr.upWeapon, var4.upgrade) / 2;
                  int var15x = at(GameScr.coinUpWeapons, var4.upgrade);
                  if (var5x << 1 <= Char.fieldBE() && var15x << 1 <= var1.yen) {
                     if (TileMap.mapID != 22) {
                        this.fieldAA(22, -2, -1, -1);
                        return;
                     }

                     Service.gI().itemBodyToBag(var4.template.type);
                     LockGame.fieldAQ();
                     var13x = var4.upgrade;
                     GameScr.fieldAB(6, 0, 0);
                     LockGame.fieldAQ();
                     GameScr.itemUpGrade = var4;

                     for (var18x = 0; var18x < 2 && var4.upgrade == var13x; var18x++) {
                        GameScr.arrItemUpGrade = new Item[18];
                        int var7 = 0;
                        int var8 = 0;

                        for (int var9 = 0; var9 < var1.arrItemBag.length && var8 < var5x; var9++) {
                           Item var10;
                           if ((var10 = var1.arrItemBag[var9]) != null && var10.template.type == 26 && var10.template.id <= 3) {
                              var1.arrItemBag[var9] = null;
                              GameScr.arrItemUpGrade[var7++] = var10;
                              var8 += at(GameScr.upClothe, var10.template.id);
                           }
                        }

                        do {
                           CUONGNSO.sleep(3000L);
                           Service.gI().upgradeItem(var4, GameScr.arrItemUpGrade, false);
                           LockGame.fieldAQ();
                        } while (GameScr.arrItemUpGrade[0] != null);
                     }

                     GameScr.itemUpGrade = null;
                     Service.gI().useItem(var4.indexUI);
                     return;
                  }

                  if (TileMap.mapID == 4) {
                     this.fieldAC(1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(4, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 4) {
                     this.fieldAC(-1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(4, -1, -1, -1);
                  return;
               }

               int var5xx = var1.taskMaint.index == 1 ? 56 : (var1.taskMaint.index == 2 ? 0 : 73);
               if (TileMap.mapID != var5xx) {
                  if (TileMap.mapID != var2) {
                     super.fieldAA(var2, -2, -1, -1);
                     return;
                  }

                  if (GameScr.hpPotion < 10 && var1.yen >= 300 * (10 - GameScr.hpPotion)) {
                     GameScr.fieldAB(3, 0, 0);
                     Service.gI().buyItem(7, 1, 10 - GameScr.hpPotion);
                     LockGame.fieldAG();
                     return;
                  }

                  GameScr.fieldAB(var3, 0, 0);
                  Service.gI().getTask(var3, 0, -1);
                  TileMap.fieldAF();
                  return;
               }

               if (var1.cHP < var1.cMaxHP / 2 && var1.cHP > 0) {
                  var1.gameAE(16);
               }

               if (var1.cMP < var1.cMaxMP / 2 && var1.cHP > 0) {
                  var1.gameAE(17);
               }

               Char var14;
               if (GameScr.vCharInMap.size() > 0 && (var14 = (Char)GameScr.vCharInMap.elementAt(0)) != null) {
                  Skill var17 = Auto.fieldAL;
                  if (Res.abs(var1.cx - var14.cx) > var17.dx || Res.abs(var1.cy - var14.cy) > var17.dy) {
                     Char.fieldAC(var14.cx < TileMap.pxw ? var14.cx : TileMap.pxw - 50, var14.cy);
                  }

                  Auto.fieldAP.removeAllElements();
                  Auto.fieldAQ.removeAllElements();
                  Auto.fieldAQ.addElement(var14);
                  Service.gI().sendPlayerAttack(Auto.fieldAP, Auto.fieldAQ, 1);
                  if (System.currentTimeMillis() - var17.lastTimeUseThisSkill >= var17.coolDown) {
                     var17.lastTimeUseThisSkill = System.currentTimeMillis();
                     var17.paintCanNotUseSkill = true;
                     var1.gameAB(GameScr.sks[var17.template.id], 0);
                     return;
                  }
               }
               break;
            case 14:
               Item var11x;
               if (var1.clevel >= 15 && (var11x = Char.fieldAF(fieldBB[var1.nClass.classId])) != null) {
                  GameScr.fieldAC("Học sách kĩ năng");
                  Service.gI().useItem(var11x.indexUI);
                  CUONGNSO.sleep(1000L);
               }

               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 29) {
                     this.fieldAC(-1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(29, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  if (TileMap.mapID == 29 && super.fieldAC == TileMap.zoneID) {
                     int var5 = Code.fieldAM < 0 ? -1 : Code.fieldAM * Code.fieldAM;
                     ItemMap var12 = null;

                     for (int var13 = 0; var13 < GameScr.vItemMap.size(); var13++) {
                        ItemMap var6;
                        int var7 = Math.abs((var6 = (ItemMap)GameScr.vItemMap.elementAt(var13)).x - var1.cx);
                        int var8 = Math.abs(var6.y - var1.cy);
                        int var9 = var7 * var7 + var8 * var8;
                        if (!var6.fieldAK && var6.template.id == 212 && (Char.fieldBF() > 2 || Char.fieldAJ(212)) && (var5 < 0 || var9 < var5)) {
                           var5 = var9;
                           var12 = var6;
                        }
                     }

                     if (var12 == null) {
                        super.fieldAC = (super.fieldAC + 1) % 30;
                        return;
                     }

                     Char.fieldAC(var12.xEnd, var12.yEnd);
                     Service.gI().pickItem(var12.itemMapID);
                     int var33 = 0;

                     while (var33 < 5 && !LockGame.fieldAC()) {
                        var33++;
                     }

                     var12.fieldAK = true;
                     return;
                  }

                  this.fieldAA(29, super.fieldAC, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 2) {
                  if (TileMap.mapID == 40) {
                     this.fieldAB(15, 1);
                     this.fieldAC(213);
                     return;
                  }

                  this.fieldAA(40, -1, -1, -1);
                  return;
               }
               break;
            case 15:
               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 8) {
                     this.fieldAC(-1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(8, -1, -1, -1);
                  return;
               }

               if (TileMap.mapID != var2) {
                  super.fieldAA(var2, -2, -1, -1);
                  return;
               }

               GameScr.fieldAB(var3, 0, 0);
               LockGame.fieldAO();
               Auto.fieldAH();
               return;
            case 16:
               Item var11;
               if (var1.clevel >= 20 && (var11 = Char.fieldAF(fieldBC[var1.nClass.classId])) != null) {
                  GameScr.fieldAC("Học sách kĩ năng");
                  Service.gI().useItem(var11.indexUI);
                  CUONGNSO.sleep(1000L);
               }

               if (var1.taskMaint.index == 0) {
                  if (TileMap.mapID == 8) {
                     this.fieldAC(-1);
                     this.fieldAB(-1, 1);
                     return;
                  }

                  this.fieldAA(8, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 1) {
                  if (TileMap.mapID == 63) {
                     this.fieldAC(-1);
                     this.fieldAB(23, 1);
                     return;
                  }

                  this.fieldAA(63, -1, -1, -1);
                  return;
               }

               if (var1.taskMaint.index == 2) {
                  if (TileMap.mapID == 47) {
                     this.fieldAC(-1);
                     this.fieldAB(24, 1);
                     return;
                  }

                  this.fieldAA(47, -1, -1, -1);
               }
         }
      }
   }

   public String toString() {
      return "Auto Nhiệm Vụ 20";
   }

   static {
      fieldAM();
   }
}
