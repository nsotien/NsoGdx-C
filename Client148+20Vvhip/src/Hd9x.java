public final class Hd9x extends Auto {
   private int gameAV;
   private int gameAW;
   private boolean[] gameAX;

   public Hd9x() {
      super.gameAC();
      super.mapID = 157;
      super.gameAD = true;
      super.zoneID = -2;
      this.gameAV = 199;
      this.gameAW = 0;
      this.gameAX = new boolean[3];
   }

   public final void gameAK() {
      if (Auto.reAC()) {
         Auto.gameAA(true);
      } else if (super.mapID != TileMap.mapID) {
         this.gameAA(super.mapID, super.zoneID, super.gameAE, super.gameAF);
      } else {
         Char var1 = Char.getMyChar();
         if (!Auto.gameAJ()) {
            label416: {
               Mob var2 = var1.mobFocus;
               int var3;
               Mob var4;
               if (var1.mobFocus == null || var2.status == 0 || !var2.isBoss || System.currentTimeMillis() - super.gameAR > 5000L) {
                  Hd9x var5 = this;
                  MyVector var6 = GameScr.vMob;
                  var3 = 0;

                  while(true) {
                     if (var3 >= var6.size()) {
                        var4 = null;
                        break;
                     }

                     if ((var4 = (Mob)var6.elementAt(var3)) != null && var4.hp > 0 && var4.status != 0 && var4.status != 1 && var4.templateId == var5.gameAV && var4.levelBoss == var5.gameAW) {
                        var4 = var4;
                        break;
                     }

                     ++var3;
                  }

                  var2 = var4;
                  if (var4 == null && System.currentTimeMillis() - super.gameAR > 1000L && !this.gameAH()) {
                     var6 = GameScr.vMob;
                     var3 = 0;

                     boolean var17;
                     while(true) {
                        if (var3 >= var6.size()) {
                           var17 = true;
                           break;
                        }

                        if ((var4 = (Mob)var6.elementAt(var3)) != null && var4.hp > 0 && var4.status != 0 && var4.status != 1) {
                           var17 = false;
                           break;
                        }

                        ++var3;
                     }

                     if (var17) {
                        this.gameAX[this.gameAV - 198] = true;
                        if (this.gameAX[0] && this.gameAX[1] && this.gameAX[2]) {
                           Code.gameAC();
                           break label416;
                        }
                     }

                     switch(this.gameAV) {
                     case 198:
                        this.gameAV = 199;
                        super.mapID = 157;
                        if (this.gameAW == 0) {
                           this.gameAW = 4;
                        }
                        break label416;
                     case 199:
                        this.gameAV = 200;
                        super.mapID = 158;
                        break label416;
                     case 200:
                        this.gameAV = 198;
                        super.mapID = 159;
                     default:
                        break label416;
                     }
                  }
               }

               int var13;
               Skill var15;
               if (Char.DanhNhom && GameScr.vParty.size() > 0 && var1.nClass.classId == 6 && var1.cHP > 0) {
                  label325:
                  for(int var12 = 0; var12 < var1.vSkillFight.size(); ++var12) {
                     if ((var15 = (Skill)var1.vSkillFight.elementAt(var12)) != null && var15.template.type == 4) {
                        if (var15.gameAA()) {
                           break;
                        }

                        var13 = 0;

                        while(true) {
                           if (var13 >= GameScr.vParty.size()) {
                              break label325;
                           }

                           Party var7;
                           if ((var7 = (Party)GameScr.vParty.elementAt(var13)).charId != var1.charID && var7.c != null && var7.c.cHP <= 0) {
                              try {
                                 Char var8 = var7.c;
                                 if (Math.abs(var1.cx - var8.cx) > 50 || Math.abs(var1.cy - var8.cy) > 50) {
                                    Char.gameAC(var8.cx, var8.cy);
                                 }

                                 Thread.sleep(500L);
                                 Service.gI().gameAX(var7.charId);
                                 var15.lastTimeUseThisSkill = System.currentTimeMillis();
                                 var15.paintCanNotUseSkill = true;
                                 var1.gameAB(GameScr.sks[var15.template.id], 0);
                                 Thread.sleep(1000L);
                                 break label416;
                              } catch (InterruptedException var11) {
                                 var11.printStackTrace();
                              }
                           }

                           ++var13;
                        }
                     }
                  }
               }

               if (Auto.skill1 != null && var2 != null && var2.isBoss && var2.templateId == this.gameAV && var2.levelBoss == this.gameAW) {
                  Skill var14 = Auto.skill1;
                  if (Auto.skill1.gameAA() && Char.DungHoTro) {
                     label283:
                     for(var3 = 0; var3 < var1.vSkillFight.size(); ++var3) {
                        if ((var15 = (Skill)var1.vSkillFight.elementAt(var3)) != null && System.currentTimeMillis() - var15.lastTimeUseThisSkill >= (long)var15.coolDown - 300L) {
                           try {
                              if (var15.template.type == 2) {
                                 if ((var1.gameAD != null || !Char.DungPhanThan) && var15.template.id >= 67 && var15.template.id <= 72 || !Char.KhienMana && var15.template.id == 31 || var15.template.id == 15 && var1.cHP >= var1.cMaxHP * Char.aHpValue / 100) {
                                    continue;
                                 }

                                 var13 = (int)(System.currentTimeMillis() / 1000L);

                                 for(int var16 = 0; var16 < var1.vEff.size(); ++var16) {
                                    Effect var18;
                                    if ((var18 = (Effect)var1.vEff.elementAt(var16)) != null && (var18.template.iconId == var15.template.iconId || var15.template.id == 58 && var18.template.type == 7) && var18.timeLenght - (var13 - var18.timeStart) >= 2) {
                                       continue label283;
                                    }
                                 }
                              } else if (var15.template.type == 3 && var2.levelBoss == 0 && var2.hp > var2.maxHp / 2) {
                                 if (var15.template.id == 4 && (!Char.DotQuai || var1.cHP >= var1.cMaxHP * Char.aHpValue / 100)) {
                                    continue;
                                 }
                              } else if (var15.template.id != 7 && var15.template.id != 16 && var15.template.id != 25 && var15.template.id != 34 && var15.template.id != 43 || var2.levelBoss == 0 && var2.hp < var2.maxHp / 2 || (var15.template.id == 7 || var15.template.id == 16) && var2.isFire || (var15.template.id == 25 || var15.template.id == 34) && !var2.isIce || var15.template.id == 43 && !var2.isWind) {
                                 continue;
                              }

                              var14 = var15;
                              Thread.sleep(500L);
                              break;
                           } catch (InterruptedException var10) {
                              var10.printStackTrace();
                           }
                        }
                     }
                  }

                  if ((var14.template.type == 1 || var14.template.type == 3) && (Res.abs(var1.cx - var2.xFirst) > var14.dx || Res.abs(var1.cy - var2.yFirst) > var14.dy)) {
                     this.gameAC(var2);
                  }

                  Service.gI().gameAG(var14.template.id);
                  if (var14.template.type == 2) {
                     Service.gI().gameAR();
                  } else {
                     Auto.reAE.removeAllElements();
                     Auto.reAF.removeAllElements();
                     if (var2 != null) {
                        Auto.reAE.addElement(var2);

                        for(var3 = 0; var3 < GameScr.vMob.size() && Auto.reAE.size() + Auto.reAF.size() < var14.maxFight; ++var3) {
                           if ((var4 = (Mob)GameScr.vMob.elementAt(var3)).status != 0 && var4.status != 1 && !var4.equals(var2) && var2.xFirst - 100 <= var4.xFirst && var4.xFirst <= var2.xFirst + 100 && var2.yFirst - 50 <= var4.yFirst && var4.yFirst <= var2.yFirst + 50) {
                              Auto.reAE.addElement(var4);
                           }
                        }
                     }

                     Service.gI().gameAA((MyVector)Auto.reAE, (MyVector)Auto.reAF, (int)1);
                  }

                  if (System.currentTimeMillis() - var14.lastTimeUseThisSkill >= (long)var14.coolDown) {
                     var14.lastTimeUseThisSkill = System.currentTimeMillis();
                     var14.paintCanNotUseSkill = true;
                     if (!Code.timBG) {
                        var1.gameAB(GameScr.sks[var14.template.id], 0);
                     }
                  }

                  super.gameAR = System.currentTimeMillis();
                  if (var14.template.id == 15) {
                     try {
                        Thread.sleep(2000L);
                     } catch (InterruptedException var9) {
                        var9.printStackTrace();
                     }
                  }
               }
            }
         }

         this.gameAC(-1);
      }
   }

   public final String toString() {
      return "Hang 9x Lvl " + this.gameAW;
   }
}
