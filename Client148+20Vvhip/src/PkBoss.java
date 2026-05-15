public final class PkBoss extends Auto {
   private int gameAV;
   private int gameAW;

   public PkBoss(int var1) {
      super.gameAC();
      super.mapID = var1;
      super.zoneID = -2;
      this.gameAV = 0;
   }

   private static boolean gameAA(ItemTemplate var0) {
      if (var0.type == 19) {
         return false;
      } else if (var0.type != 16 && var0.type != 17) {
         if (var0.type == 26) {
            return var0.level >= 6;
         } else if (var0.gameAA()) {
            return var0.level >= 70;
         } else if (var0.gameAB()) {
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
      } else {
         return false;
      }
   }

   private static void gameAL() {
      Char var0 = Char.getMyChar();

      for(int var1 = 0; var1 < GameScr.vItemMap.size(); ++var1) {
         ItemMap var2;
         if (gameAA((var2 = (ItemMap)GameScr.vItemMap.elementAt(var1)).template) && Res.gameAA(var0.cx, var0.cy, var2.xEnd, var2.yEnd) <= 100 && (Char.gameBG() > 2 || var2.template.isUpToUp && Char.gameAJ(var2.template.id))) {
            try {
               Service.gI().gameAQ(var2.itemMapID);
               Thread.sleep(50L);
            } catch (InterruptedException var3) {
               var3.printStackTrace();
            }
         }
      }

   }

   protected final boolean gameAH() {
      Char var1 = Char.getMyChar();

      for(int var2 = 0; var2 < GameScr.vItemMap.size(); ++var2) {
         ItemMap var3;
         if (gameAA((var3 = (ItemMap)GameScr.vItemMap.elementAt(var2)).template) && Res.gameAA(var1.cx, var1.cy, var3.xEnd, var3.yEnd) <= 100 && (Char.gameBG() > 2 || var3.template.isUpToUp && Char.gameAJ(var3.template.id))) {
            return true;
         }
      }

      return false;
   }

   private void gameAM() {
      Char var1 = Char.getMyChar();
      if (!Auto.gameAJ()) {
         Mob var2 = var1.mobFocus;
         Char var3 = var1.charFocus;
         if (Code.gameBO && (var3 == null || Code.gameAC(var3.cName) || !Auto.gameAA(var1, var3))) {
            var3 = Auto.gameAD(var1);
         }

         int var4;
         Mob var13;
         if (var3 == null && var2 == null || !var2.isBoss || System.currentTimeMillis() - super.gameAR > 60000L) {
            MyVector var5 = GameScr.vMob;
            var4 = 0;

            while(true) {
               if (var4 >= var5.size()) {
                  var13 = null;
                  break;
               }

               Mob var6;
               if ((var6 = (Mob)var5.elementAt(var4)) != null && var6.isBoss && var6.templateId != 223 && var6.hp > 0 && var6.status != 0 && var6.status != 1) {
                  var13 = var6;
                  break;
               }

               ++var4;
            }

            var2 = var13;
            if (var13 == null && (System.currentTimeMillis() - super.gameAR > 60000L || System.currentTimeMillis() - super.gameAR > 10000L && !this.gameAH())) {
               Code.gameAC();
               return;
            }

            this.gameAC(var13);
         }

         int var14;
         Skill var15;
         Char var16;
         if (GameScr.vParty.size() > 0 && var1.nClass.classId == 6 && var1.cHP > 0) {
            label496:
            for(var4 = 0; var4 < var1.vSkillFight.size(); ++var4) {
               if ((var15 = (Skill)var1.vSkillFight.elementAt(var4)) != null && var15.template.type == 4) {
                  if (var15.gameAA()) {
                     break;
                  }

                  var14 = 0;

                  while(true) {
                     if (var14 >= GameScr.vParty.size()) {
                        break label496;
                     }

                     Party var7;
                     if ((var7 = (Party)GameScr.vParty.elementAt(var14)).charId != var1.charID && var7.c != null && var7.c.cHP <= 0) {
                        try {
                           var16 = var7.c;
                           if (Math.abs(var1.cx - var16.cx) > 50 || Math.abs(var1.cy - var16.cy) > 50) {
                              Char.gameAC(var16.cx, var16.cy);
                           }

                           Thread.sleep(500L);
                           Service.gI().gameAX(var7.charId);
                           var15.lastTimeUseThisSkill = System.currentTimeMillis();
                           var15.paintCanNotUseSkill = true;
                           var1.gameAB(GameScr.sks[var15.template.id], 0);
                           Thread.sleep(1000L);
                           return;
                        } catch (InterruptedException var12) {
                           var12.printStackTrace();
                        }
                     }

                     ++var14;
                  }
               }
            }
         }

         if (Auto.skill1 != null) {
            var15 = Auto.skill1;
            int var8;
            int var18;
            if (Auto.skill1.gameAA() && Char.DungHoTro) {
               label463:
               for(var18 = 0; var18 < var1.vSkillFight.size(); ++var18) {
                  Skill var17;
                  if ((var17 = (Skill)var1.vSkillFight.elementAt(var18)) != null && System.currentTimeMillis() - var17.lastTimeUseThisSkill >= (long)var17.coolDown - 300L) {
                     try {
                        if (var17.template.type == 2) {
                           if ((var1.gameAD != null || !Char.DungPhanThan) && var17.template.id >= 67 && var17.template.id <= 72 || !Char.KhienMana && var17.template.id == 31 || var17.template.id == 15 && (var1.cHP >= var1.cMaxHP * Char.aHpValue / 100 || !var1.isHuman) || var17.template.id == 6 && !var1.isHuman) {
                              continue;
                           }

                           var8 = (int)(System.currentTimeMillis() / 1000L);

                           for(var14 = 0; var14 < var1.vEff.size(); ++var14) {
                              Effect var9;
                              if ((var9 = (Effect)var1.vEff.elementAt(var14)) != null && (var9.template.iconId == var17.template.iconId || var17.template.id == 58 && var9.template.type == 7) && var9.timeLenght - (var8 - var9.timeStart) >= 2) {
                                 continue label463;
                              }
                           }
                        } else if (var17.template.type == 3 && var2 != null && var2.levelBoss == 0 && var2.hp > var2.maxHp / 2) {
                           if (var17.template.id == 4 && (!Char.DotQuai || var1.cHP >= var1.cMaxHP * Char.aHpValue / 100)) {
                              continue;
                           }
                        } else if (var17.template.id != 7 && var17.template.id != 16 && var17.template.id != 25 && var17.template.id != 34 && var17.template.id != 43 || var2 == null || var2.levelBoss == 0 && var2.hp < var2.maxHp / 2 || (var17.template.id == 7 || var17.template.id == 16) && var2.isFire || (var17.template.id == 25 || var17.template.id == 34) && !var2.isIce || var17.template.id == 43 && !var2.isWind) {
                           continue;
                        }

                        var15 = var17;
                        Thread.sleep(500L);
                        break;
                     } catch (InterruptedException var11) {
                        var11.printStackTrace();
                     }
                  }
               }
            }

            Service.gI().gameAG(var15.template.id);
            if (var15.template.type == 2) {
               Service.gI().gameAR();
            } else if (Code.gameBO && var3 != null && !Auto.gameAB(var3) && Auto.gameAA(var1, var3)) {
               var18 = var15.dx;
               var14 = var15.dy;
               Auto.reAE.removeAllElements();
               Auto.reAF.removeAllElements();
               Auto.reAF.addElement(var3);

               for(var8 = 0; var8 < GameScr.vCharInMap.size() && Auto.reAE.size() + Auto.reAF.size() < var15.maxFight; ++var8) {
                  if ((var16 = (Char)GameScr.vCharInMap.elementAt(var8)).cHP > 0 && var16.statusMe != 14 && var16.statusMe != 5 && var16.statusMe != 15 && !var16.equals(var3) && (var16.cTypePk == 3 || var1.cTypePk == 3 || var16.cTypePk == 1 && var1.cTypePk == 1 || var1.killCharId >= 0 && var1.killCharId == var16.charID || var1.testCharId >= 0 && var1.testCharId == var16.charID || var16.killCharId == var1.charID) && !Code.gameAD(var16.cName) && var3.cx - var18 <= var16.cx && var16.cx <= var3.cx + var18 && var3.cy - var14 <= var16.cy && var16.cy <= var3.cy + var14) {
                     Auto.reAF.addElement(var16);
                  }
               }

               for(var8 = 0; var8 < GameScr.vMob.size() && Auto.reAE.size() + Auto.reAF.size() < var15.maxFight; ++var8) {
                  if ((var13 = (Mob)GameScr.vMob.elementAt(var8)).status != 0 && var13.status != 1 && var13.isBoss && var3.cx - var18 <= var13.x && var13.x <= var3.cx + var18 && var3.cy - var14 <= var13.y && var13.y <= var3.cy + var14) {
                     Auto.reAE.addElement(var13);
                  }
               }

               Service.gI().gameAA((MyVector)Auto.reAE, (MyVector)Auto.reAF, (int)2);
            } else {
               if (var2 == null || var2 == null || !var2.isBoss || var2.status == 0 || var2.hp <= 0) {
                  return;
               }

               if ((var15.template.type == 1 || var15.template.type == 3) && (Res.abs(var1.cx - var2.xFirst) > var15.dx + 30 || Res.abs(var1.cy - var2.yFirst) > var15.dy + 30)) {
                  this.gameAC(var2);
               }

               var18 = var15.dx;
               var14 = var15.dy;
               Auto.reAE.removeAllElements();
               Auto.reAF.removeAllElements();
               Auto.reAE.addElement(var2);

               for(var8 = 0; var8 < GameScr.vMob.size() && Auto.reAE.size() + Auto.reAF.size() < var15.maxFight; ++var8) {
                  if ((var13 = (Mob)GameScr.vMob.elementAt(var8)).status != 0 && var13.status != 1 && !var13.equals(var2) && var13.isBoss && var2.xFirst - 100 <= var13.xFirst && var13.xFirst <= var2.xFirst + 100 && var2.yFirst - 50 <= var13.yFirst && var13.yFirst <= var2.yFirst + 50) {
                     Auto.reAE.addElement(var13);
                  }
               }

               for(var8 = 0; var8 < GameScr.vCharInMap.size() && Auto.reAE.size() + Auto.reAF.size() < var15.maxFight; ++var8) {
                  if ((var16 = (Char)GameScr.vCharInMap.elementAt(var8)).cHP > 0 && var16.statusMe != 14 && var16.statusMe != 5 && var16.statusMe != 15 && (var16.cTypePk == 3 || var1.cTypePk == 3 || var16.cTypePk == 1 && var1.cTypePk == 1 || var1.killCharId >= 0 && var1.killCharId == var16.charID || var1.testCharId >= 0 && var1.testCharId == var16.charID || var16.killCharId == var1.charID) && !Code.gameAD(var16.cName) && var2.x - var18 <= var16.cx && var16.cx <= var2.x + var18 && var2.y - var14 <= var16.cy && var16.cy <= var2.y + var14) {
                     Auto.reAF.addElement(var16);
                  }
               }

               Service.gI().gameAA((MyVector)Auto.reAE, (MyVector)Auto.reAF, (int)1);
            }

            if (System.currentTimeMillis() - var15.lastTimeUseThisSkill >= (long)var15.coolDown) {
               var15.lastTimeUseThisSkill = System.currentTimeMillis();
               var15.paintCanNotUseSkill = true;
               if (!Code.timBG) {
                  var1.gameAB(GameScr.sks[var15.template.id], 0);
               }
            }

            super.gameAR = System.currentTimeMillis();
            if (var15.template.id == 15) {
               try {
                  Thread.sleep(2000L);
                  return;
               } catch (InterruptedException var10) {
                  var10.printStackTrace();
               }
            }
         }
      }

   }

   public final void gameAK() {
      int var7;
      if (Auto.reAC()) {
         boolean var5;
         if (!Char.ReMap) {
            var5 = true;
         } else {
            label138: {
               if (TileMap.mapID == super.mapID && TileMap.zoneID == super.zoneID) {
                  label136: {
                     Party var8;
                     for(var7 = 0; var7 < GameScr.vParty.size(); ++var7) {
                        if ((var8 = (Party)GameScr.vParty.elementAt(var7)).c != null && var8.c.cHP > 0) {
                           break label136;
                        }
                     }

                     for(var7 = 0; var7 < GameScr.vParty.size(); ++var7) {
                        if ((var8 = (Party)GameScr.vParty.elementAt(var7)).c != null) {
                           if (!var8.name.equals(Char.getMyChar().cName)) {
                              break label136;
                           }
                           break;
                        }
                     }

                     var5 = true;
                     break label138;
                  }
               }

               var5 = false;
            }
         }

         if (!var5) {
            Auto.gameAA(true);
         }

      } else {
         Char var1 = Char.getMyChar();
         boolean var2 = Code.gameAH == null || var1.cName.equals(Code.gameAH);
         int var3;
         if (super.zoneID == -2) {
            if (super.mapID != TileMap.mapID) {
               this.gameAA(super.mapID, -2, -1, -1);
               return;
            }

            if (var2) {
               this.gameAW = (this.gameAW - 1) % 30;
               if (this.gameAW < 0) {
                  this.gameAW = 29;
               }

               Auto.gameAA(this.gameAW);

               for(var3 = 0; var3 < GameScr.vMob.size(); ++var3) {
                  Mob var6;
                  if ((var6 = (Mob)GameScr.vMob.elementAt(var3)).isBoss && var6.hp > 0 && var6.status != 0) {
                     Service.gI().gameAK("pkm " + super.mapID);
                     Service.gI().gameAK("pkk " + (super.zoneID = TileMap.zoneID));
                     break;
                  }
               }

               if (this.gameAW == 15 && ++this.gameAV == 2) {
                  Service.gI().gameAK("pke");
                  Code.gameAC();
                  return;
               }
            }
         } else if (super.mapID == TileMap.mapID && super.zoneID == TileMap.zoneID) {
            this.gameAM();
            gameAL();
            if (var1.cMP < var1.cMaxMP * Char.aMpValue / 100) {
               var1.gameAE(17);
            }

            if (var1.cHP < var1.cMaxHP * Char.aHpValue / 100) {
               var3 = (int)(System.currentTimeMillis() / 1000L);

               for(var7 = 0; var7 < var1.vEff.size(); ++var7) {
                  Effect var4;
                  if ((var4 = (Effect)var1.vEff.elementAt(var7)).template.id == 21 && var4.timeLenght - (var3 - var4.timeStart) >= 2) {
                     return;
                  }
               }

               Char.getMyChar().gameAE(16);
               return;
            }
         } else {
            this.gameAA(super.mapID, super.zoneID, super.gameAE, super.gameAF);
         }

      }
   }

   public final String toString() {
      return "PK Boss";
   }
}
