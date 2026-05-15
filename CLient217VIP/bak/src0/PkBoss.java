public final class PkBoss extends Auto {
   private int fieldAV;
   private int fieldAW;
   private long fieldAX;

   public PkBoss(int var1) {
      super.fieldAD();
      super.fieldAB = var1;
      super.fieldAC = -2;
      this.fieldAV = 0;
   }

   private static boolean fieldAA(ItemTemplate var0) {
      if (var0.type == 19) {
         return false;
      } else if (var0.type == 16 || var0.type == 17) {
         return false;
      } else if (var0.type == 26) {
         return var0.level >= 6;
      } else if (var0.fieldAA()) {
         return var0.level >= 70;
      } else if (var0.fieldAB()) {
         return false;
      } else {
         if (var0.type == 27) {
            if (var0.id == 38 || var0.description.startsWith("Vật phẩm sự kiện") || var0.description.startsWith("Vật phẩm Sự kiện")) {
               return false;
            }

            if (var0.name.startsWith("Sách võ công")) {
               if (var0.level == 100) {
                  return true;
               }

               return false;
            }
         }

         return true;
      }
   }

   private static void fieldAM() {
      Char var0 = Char.getMyChar();

      for (int var1 = 0; var1 < GameScr.vItemMap.size(); var1++) {
         ItemMap var2;
         if (fieldAA((var2 = (ItemMap)GameScr.vItemMap.elementAt(var1)).template)
            && Res.gameAA(var0.cx, var0.cy, var2.xEnd, var2.yEnd) <= 100
            && (Char.fieldBF() > 2 || var2.template.isUpToUp && Char.fieldAJ(var2.template.id))) {
            Service.gI().pickItem(var2.itemMapID);
            cuong.sleep(50L);
         }
      }
   }

   private static boolean hasAliveBoss() {
      for (int i = 0; i < GameScr.vMob.size(); i++) {
         Mob m = (Mob)GameScr.vMob.elementAt(i);
         if (m != null && m.isBoss && m.hp > 0 && m.status != 0) {
            return true;
         }
      }

      return false;
   }

   private static void lootAll() {
      Char me = Char.getMyChar();

      for (int i = 0; i < GameScr.vItemMap.size(); i++) {
         ItemMap im = (ItemMap)GameScr.vItemMap.elementAt(i);
         if (im != null && fieldAA(im.template) && (Char.fieldBF() > 2 || im.template.isUpToUp && Char.fieldAJ(im.template.id))) {
            if (Res.gameAA(me.cx, me.cy, im.xEnd, im.yEnd) > 100) {
               Char.fieldAC(im.xEnd, im.yEnd);
               cuong.sleep(300L);
            }

            Service.gI().pickItem(im.itemMapID);
            cuong.sleep(80L);
         }
      }
   }

   protected final boolean fieldAJ() {
      Char var1 = Char.getMyChar();

      for (int var2 = 0; var2 < GameScr.vItemMap.size(); var2++) {
         ItemMap var3;
         if (fieldAA((var3 = (ItemMap)GameScr.vItemMap.elementAt(var2)).template)
            && Res.gameAA(var1.cx, var1.cy, var3.xEnd, var3.yEnd) <= 100
            && (Char.fieldBF() > 2 || var3.template.isUpToUp && Char.fieldAJ(var3.template.id))) {
            return true;
         }
      }

      return false;
   }

   private void fieldAN() {
      Char var1 = Char.getMyChar();
      if (!Auto.fieldAL()) {
         Mob var2 = var1.mobFocus;
         Char var3 = var1.charFocus;
         if (Code.fieldBO && (var3 == null || Code.fieldAC(var3.cName) || !Auto.fieldAA(var1, var3))) {
            var3 = Auto.fieldAE(var1);
         }

         if (var3 == null && var2 == null || !var2.isBoss || System.currentTimeMillis() - super.fieldAR > 60000L) {
            MyVector var10 = GameScr.vMob;
            int var4 = 0;

            Mob var10000;
            while (true) {
               if (var4 >= var10.size()) {
                  var10000 = null;
                  break;
               }

               Mob var5;
               if ((var5 = (Mob)var10.elementAt(var4)) != null && var5.isBoss && var5.hp > 0 && var5.status != 0 && var5.status != 1) {
                  var10000 = var5;
                  break;
               }

               var4++;
            }

            var2 = var10000;
            if (var10000 == null
               && (System.currentTimeMillis() - super.fieldAR > 60000L || System.currentTimeMillis() - super.fieldAR > 10000L && !this.fieldAJ())) {
               Code.fieldAC();
               return;
            }

            this.fieldAC(var10000);
         }

         if (GameScr.vParty.size() > 0 && var1.nClass.classId == 6 && var1.cHP > 0) {
            for (int var4 = 0; var4 < var1.vSkillFight.size(); var4++) {
               Skill var12;
               if ((var12 = (Skill)var1.vSkillFight.elementAt(var4)) != null && var12.template.type == 4) {
                  if (!var12.gameAA()) {
                     for (int var6 = 0; var6 < GameScr.vParty.size(); var6++) {
                        Party var7;
                        if ((var7 = (Party)GameScr.vParty.elementAt(var6)).charId != var1.charID && var7.c != null && var7.c.cHP <= 0) {
                           Char var8 = var7.c;
                           if (Math.abs(var1.cx - var8.cx) > 50 || Math.abs(var1.cy - var8.cy) > 50) {
                              Char.fieldAC(var8.cx, var8.cy);
                           }

                           cuong.sleep(500L);
                           Service.gI().buffLive(var7.charId);
                           var12.lastTimeUseThisSkill = System.currentTimeMillis();
                           var12.paintCanNotUseSkill = true;
                           var1.gameAB(GameScr.sks[var12.template.id], 0);
                           cuong.sleep(1000L);
                           return;
                        }
                     }
                  }
                  break;
               }
            }
         }

         if (Auto.fieldAL != null) {
            Skill var11;
            var11 = Auto.fieldAL;
            label497:
            if (Auto.fieldAL.gameAA() && Char.isABuff) {
               int var13 = 0;

               Skill var14;
               label493:
               while (true) {
                  if (var13 >= var1.vSkillFight.size()) {
                     break label497;
                  }

                  if ((var14 = (Skill)var1.vSkillFight.elementAt(var13)) != null
                     && System.currentTimeMillis() - var14.lastTimeUseThisSkill >= var14.coolDown - 300L) {
                     if (var14.template.type == 2) {
                        if ((var1.fieldAA == null && Char.fieldEG || var14.template.id < 67 || var14.template.id > 72)
                           && (Char.fieldEH || var14.template.id != 31)
                           && (var14.template.id != 15 || var1.cHP < var1.cMaxHP * Char.aHpValue / 100 && var1.isHuman)
                           && (var14.template.id != 6 || var1.isHuman)) {
                           int var15 = (int)(System.currentTimeMillis() / 1000L);
                           int var16 = 0;

                           while (true) {
                              if (var16 >= var1.vEff.size()) {
                                 break label493;
                              }

                              EffectBuff var9;
                              if ((var9 = (EffectBuff)var1.vEff.elementAt(var16)) != null
                                 && (var9.template.iconId == var14.template.iconId || var14.template.id == 58 && var9.template.type == 7)
                                 && var9.timeLenght - (var15 - var9.timeStart) >= 2) {
                                 break;
                              }

                              var16++;
                           }
                        }
                     } else if (var14.template.type == 3 && var2 != null && var2.levelBoss == 0 && var2.hp > var2.maxHp / 2
                        ? var14.template.id != 4 || Char.fieldEI && var1.cHP < var1.cMaxHP * Char.aHpValue / 100
                        : (var14.template.id == 7 || var14.template.id == 16 || var14.template.id == 25 || var14.template.id == 34 || var14.template.id == 43)
                           && var2 != null
                           && (var2.levelBoss != 0 || var2.hp >= var2.maxHp / 2)
                           && (var14.template.id != 7 && var14.template.id != 16 || !var2.isFire)
                           && (var14.template.id != 25 && var14.template.id != 34 || var2.isIce)
                           && (var14.template.id != 43 || var2.isWind)) {
                        break;
                     }
                  }

                  var13++;
               }

               var11 = var14;
               cuong.sleep(500L);
            }

            Service.gI().selectSkill(var11.template.id);
            if (var11.template.type == 2) {
               Service.gI().sendUseSkillMyBuff();
            } else if (Code.fieldBO && var3 != null && !Auto.fieldAC(var3) && Auto.fieldAA(var1, var3)) {
               int var13 = var11.dx;
               int var6x = var11.dy;
               Auto.fieldAP.removeAllElements();
               Auto.fieldAQ.removeAllElements();
               Auto.fieldAQ.addElement(var3);

               for (int var15 = 0; var15 < GameScr.vCharInMap.size() && Auto.fieldAP.size() + Auto.fieldAQ.size() < var11.maxFight; var15++) {
                  Char var8;
                  if ((var8 = (Char)GameScr.vCharInMap.elementAt(var15)).cHP > 0
                     && var8.statusMe != 14
                     && var8.statusMe != 5
                     && var8.statusMe != 15
                     && !var8.equals(var3)
                     && (
                        var8.cTypePk == 3
                           || var1.cTypePk == 3
                           || var8.cTypePk == 1 && var1.cTypePk == 1
                           || var1.killCharId >= 0 && var1.killCharId == var8.charID
                           || var1.testCharId >= 0 && var1.testCharId == var8.charID
                           || var8.killCharId == var1.charID
                     )
                     && !Code.fieldAD(var8.cName)
                     && var3.cx - var13 <= var8.cx
                     && var8.cx <= var3.cx + var13
                     && var3.cy - var6x <= var8.cy
                     && var8.cy <= var3.cy + var6x) {
                     Auto.fieldAQ.addElement(var8);
                  }
               }

               for (int var28 = 0; var28 < GameScr.vMob.size() && Auto.fieldAP.size() + Auto.fieldAQ.size() < var11.maxFight; var28++) {
                  Mob var17;
                  if ((var17 = (Mob)GameScr.vMob.elementAt(var28)).status != 0
                     && var17.status != 1
                     && var17.isBoss
                     && var3.cx - var13 <= var17.x
                     && var17.x <= var3.cx + var13
                     && var3.cy - var6x <= var17.y
                     && var17.y <= var3.cy + var6x) {
                     Auto.fieldAP.addElement(var17);
                  }
               }

               if (Char.getMyChar().arrItemMounts != null
                  && Char.getMyChar().arrItemMounts[4] != null
                  && !Char.getMyChar().isMoto
                  && !Char.getMyChar().isNewMount
                  && !Char.getMyChar().isMotoBehind) {
                  Char.getMyChar().isMotoBehind = true;
                  ServerEffect.gameAA(60, Char.getMyChar(), 1);
               }

               if (Char.getMyChar().isMoto && !Char.getMyChar().isMotoBehind) {
                  Char.getMyChar().isMoto = false;
                  Char.getMyChar().isMotoBehind = true;
                  ServerEffect.gameAA(60, Char.getMyChar(), 1);
               }

               if (Char.getMyChar().isNewMount && !Char.getMyChar().isMotoBehind) {
                  Char.getMyChar().isNewMount = false;
                  Char.getMyChar().isMotoBehind = true;
                  ServerEffect.gameAA(60, Char.getMyChar(), 1);
               }

               Service.gI().sendPlayerAttack(Auto.fieldAP, Auto.fieldAQ, 2);
            } else {
               if (var2 == null || var2 == null || !var2.isBoss || var2.status == 0 || var2.hp <= 0) {
                  return;
               }

               if ((var11.template.type == 1 || var11.template.type == 3)
                  && (Res.abs(var1.cx - var2.xFirst) > var11.dx + 30 || Res.abs(var1.cy - var2.yFirst) > var11.dy + 30)) {
                  this.fieldAC(var2);
               }

               int var13 = var11.dx;
               int var6x = var11.dy;
               Auto.fieldAP.removeAllElements();
               Auto.fieldAQ.removeAllElements();
               Auto.fieldAP.addElement(var2);

               for (int var15x = 0; var15x < GameScr.vMob.size() && Auto.fieldAP.size() + Auto.fieldAQ.size() < var11.maxFight; var15x++) {
                  Mob var17;
                  if ((var17 = (Mob)GameScr.vMob.elementAt(var15x)).status != 0
                     && var17.status != 1
                     && !var17.equals(var2)
                     && var17.isBoss
                     && var2.xFirst - 100 <= var17.xFirst
                     && var17.xFirst <= var2.xFirst + 100
                     && var2.yFirst - 50 <= var17.yFirst
                     && var17.yFirst <= var2.yFirst + 50) {
                     Auto.fieldAP.addElement(var17);
                  }
               }

               for (int var26 = 0; var26 < GameScr.vCharInMap.size() && Auto.fieldAP.size() + Auto.fieldAQ.size() < var11.maxFight; var26++) {
                  Char var8;
                  if ((var8 = (Char)GameScr.vCharInMap.elementAt(var26)).cHP > 0
                     && var8.statusMe != 14
                     && var8.statusMe != 5
                     && var8.statusMe != 15
                     && (
                        var8.cTypePk == 3
                           || var1.cTypePk == 3
                           || var8.cTypePk == 1 && var1.cTypePk == 1
                           || var1.killCharId >= 0 && var1.killCharId == var8.charID
                           || var1.testCharId >= 0 && var1.testCharId == var8.charID
                           || var8.killCharId == var1.charID
                     )
                     && !Code.fieldAD(var8.cName)
                     && var2.x - var13 <= var8.cx
                     && var8.cx <= var2.x + var13
                     && var2.y - var6x <= var8.cy
                     && var8.cy <= var2.y + var6x) {
                     Auto.fieldAQ.addElement(var8);
                  }
               }

               if (Char.getMyChar().arrItemMounts != null
                  && Char.getMyChar().arrItemMounts[4] != null
                  && !Char.getMyChar().isMoto
                  && !Char.getMyChar().isNewMount
                  && !Char.getMyChar().isMotoBehind) {
                  Char.getMyChar().isMotoBehind = true;
                  ServerEffect.gameAA(60, Char.getMyChar(), 1);
               }

               if (Char.getMyChar().isMoto && !Char.getMyChar().isMotoBehind) {
                  Char.getMyChar().isMoto = false;
                  Char.getMyChar().isMotoBehind = true;
                  ServerEffect.gameAA(60, Char.getMyChar(), 1);
               }

               if (Char.getMyChar().isNewMount && !Char.getMyChar().isMotoBehind) {
                  Char.getMyChar().isNewMount = false;
                  Char.getMyChar().isMotoBehind = true;
                  ServerEffect.gameAA(60, Char.getMyChar(), 1);
               }

               Service.gI().sendPlayerAttack(Auto.fieldAP, Auto.fieldAQ, 1);
            }

            if (System.currentTimeMillis() - var11.lastTimeUseThisSkill >= var11.coolDown) {
               var11.lastTimeUseThisSkill = System.currentTimeMillis();
               var11.paintCanNotUseSkill = true;
               if (!Code.fieldBF) {
                  var1.gameAB(GameScr.sks[var11.template.id], 0);
               }
            }

            super.fieldAR = System.currentTimeMillis();
            if (var11.template.id == 15) {
               cuong.sleep(2000L);
            }
         }
      }
   }

   public final void fieldAA() {
      if (Auto.fieldAF()) {
         Service.gI().returnTownFromDead();
         cuong.sleep(1200L);
         Service.gI().wakeUpFromDead();
         cuong.sleep(300L);
         super.fieldAC = -2;
         this.fieldAW = 0;
      } else {
         Char var1 = Char.getMyChar();
         if (var1.cHP > 0 && var1.statusMe != 14 && var1.statusMe != 5) {
            boolean var2 = Code.fieldAH == null || var1.cName.equals(Code.fieldAH);
            if (super.fieldAC == -2) {
               if (super.fieldAB != TileMap.mapID) {
                  this.fieldAA(super.fieldAB, -2, -1, -1);
                  return;
               }

               if (var2) {
                  Auto.fieldAA(this.fieldAW);

                  for (int var6 = 0; var6 < GameScr.vMob.size(); var6++) {
                     Mob var3;
                     if ((var3 = (Mob)GameScr.vMob.elementAt(var6)).isBoss && var3.hp > 0 && var3.status != 0) {
                        super.fieldAC = TileMap.zoneID;
                        break;
                     }
                  }

                  if (super.fieldAC == -2) {
                     this.fieldAW++;
                     if (this.fieldAW > 30) {
                        Code.fieldAC();
                        return;
                     }
                  }
               }
            } else if (super.fieldAB == TileMap.mapID && super.fieldAC == TileMap.zoneID) {
               if (var1.cHP <= 0) {
                  Service.gI().wakeUpFromDead();
                  cuong.sleep(800L);
                  if (var1.cHP <= 0) {
                     Service.gI().returnTownFromDead();
                     cuong.sleep(1200L);
                     Service.gI().wakeUpFromDead();
                     cuong.sleep(300L);
                     super.fieldAC = -2;
                     this.fieldAW = 0;
                     return;
                  }
               }

               this.fieldAN();
               fieldAM();
               if (!hasAliveBoss()) {
                  lootAll();
                  if (System.currentTimeMillis() - this.fieldAX > 2000L) {
                     Code.fieldAC();
                     this.fieldAX = System.currentTimeMillis();
                  }
               }

               if (var1.cMP < var1.cMaxMP * Char.aMpValue / 100) {
                  var1.gameAE(17);
               }

               if (var1.cHP < var1.cMaxHP * Char.aHpValue / 100) {
                  int var6x = (int)(System.currentTimeMillis() / 1000L);

                  for (int var8 = 0; var8 < var1.vEff.size(); var8++) {
                     EffectBuff var4;
                     if ((var4 = (EffectBuff)var1.vEff.elementAt(var8)).template.id == 21 && var4.timeLenght - (var6x - var4.timeStart) >= 2) {
                        return;
                     }
                  }

                  Char.getMyChar().gameAE(16);
                  return;
               }
            } else {
               this.fieldAA(super.fieldAB, super.fieldAC, super.fieldAE, super.fieldAF);
            }
         } else {
            Service.gI().returnTownFromDead();
            cuong.sleep(1200L);
            Service.gI().wakeUpFromDead();
            cuong.sleep(300L);
            super.fieldAC = -2;
            this.fieldAW = 0;
         }
      }
   }

   public final String toString() {
      return "PK Boss";
   }
}
