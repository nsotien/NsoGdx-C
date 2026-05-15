public final class DanTre extends Auto {
   public DanTre() {
      super.gameAC();
      super.zoneID = TileMap.zoneID;
   }

   private static void gameAE(Char var0) {
      if (var0 != null) {
         try {
            Char var1 = Char.getMyChar();
            Char.gameAC(var0.cx, var0.cy);
            var1.charFocus = var0;
            Thread.sleep(100L);
            return;
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }
      }

   }

   public final void gameAK() {
      if (Char.getMyChar().cHP <= 0) {
         Auto.gameAA(true);
      } else if (TileMap.mapID != 33) {
         this.gameAA(33, super.zoneID, -1, -1);
      } else {
         Char var1;
         if ((var1 = Char.getMyChar()).ctaskId == 17 && var1.taskMaint.index < var1.taskMaint.subNames.length - 1) {
            if (var1.gameAE == null) {
               try {
                  GameScr.gameAB(17, 0, 0);
                  Thread.sleep(2000L);
                  return;
               } catch (InterruptedException var9) {
                  var9.printStackTrace();
               }
            }

            if (Res.gameAA(var1.cx, var1.cy, var1.gameAE.cx, var1.gameAE.cy) > 200) {
               gameAE(var1.gameAE);
            }

            Char var2 = Char.getMyChar();
            Skill var10 = Auto.skill1;
            int var3;
            if (Char.DungHoTro) {
               for(var3 = 0; var3 < var2.vSkillFight.size(); ++var3) {
                  Skill var4;
                  if ((var4 = (Skill)var2.vSkillFight.elementAt(var3)) != null && !var4.gameAA() && var4.template.type == 2 && (var4.template.id != 47 || var2.cHP < var2.cMaxHP * Char.aHpValue / 100)) {
                     boolean var5 = false;

                     for(int var6 = 0; var6 < var2.vEff.size(); ++var6) {
                        Effect var7;
                        if ((var7 = (Effect)var2.vEff.elementAt(var6)) != null && var7.template.iconId == var4.template.iconId) {
                           var5 = true;
                           break;
                        }
                     }

                     if (!var5) {
                        try {
                           var10 = var4;
                           Thread.sleep(500L);
                           break;
                        } catch (InterruptedException var8) {
                           var8.printStackTrace();
                        }
                     }
                  }
               }
            }

            label180: {
               if (var10.template.type == 2) {
                  Service.gI().gameAR();
               } else {
                  Char var11;
                  MyVector var12;
                  int var14;
                  Char var15;
                  label177: {
                     if ((var11 = Char.getMyChar()).gameAE != null) {
                        var12 = GameScr.vCharInMap;

                        for(var14 = 0; var14 < var12.size(); ++var14) {
                           Char var16;
                           if ((var16 = (Char)var12.elementAt(var14)) != null && var16.statusMe != 14 && var16.statusMe != 5 && var16.statusMe != 15 && (var16.cTypePk == 3 || var11.cTypePk == 3 || var16.cTypePk == 1 && var11.cTypePk == 1 || var11.killCharId >= 0 && var11.killCharId == var16.charID || var11.testCharId >= 0 && var11.testCharId == var16.charID) && Res.gameAA(var16.cx, var16.cy, var11.gameAE.cx, var11.gameAE.cy) < 200) {
                              var15 = var16;
                              break label177;
                           }
                        }
                     }

                     var15 = null;
                  }

                  if (var15 != null) {
                     if (Res.gameAA(var15.cx, var15.cy, var2.gameAE.cx, var2.gameAE.cy) < 200 && (Res.abs(var2.cx - var15.cx) > var10.dx || Res.abs(var2.cy - var15.cy) > var10.dy)) {
                        gameAE(var15);
                     }

                     Service.gI().gameAG(var10.template.id);
                     Auto.reAE.removeAllElements();
                     Auto.reAF.removeAllElements();
                     Auto.reAF.addElement(var15);
                     Service.gI().gameAA((MyVector)Auto.reAE, (MyVector)Auto.reAF, (int)2);
                  } else {
                     Mob var18;
                     label135: {
                        if ((var11 = Char.getMyChar()).gameAE != null) {
                           var12 = GameScr.vMob;

                           for(var14 = 0; var14 < var12.size(); ++var14) {
                              Mob var19;
                              if ((var19 = (Mob)var12.elementAt(var14)) != null && var19.hp > 0 && var19.status != 0 && var19.status != 1 && Res.gameAA(var19.x, var19.y, var11.gameAE.cx, var11.gameAE.cy) < 200) {
                                 var18 = var19;
                                 break label135;
                              }
                           }
                        }

                        var18 = null;
                     }

                     if (var18 == null) {
                        break label180;
                     }

                     if (Res.gameAA(var18.x, var18.y, var2.gameAE.cx, var2.gameAE.cy) < 200 && (Res.abs(var2.cx - var18.x) > var10.dx || Res.abs(var2.cy - var18.y) > var10.dy)) {
                        this.gameAC(var18);
                     }

                     Service.gI().gameAG(var10.template.id);
                     Auto.reAE.removeAllElements();
                     Auto.reAF.removeAllElements();
                     Auto.reAE.addElement(var18);
                     Service.gI().gameAA((MyVector)Auto.reAE, (MyVector)Auto.reAF, (int)1);
                  }
               }

               if (System.currentTimeMillis() - var10.lastTimeUseThisSkill >= (long)var10.coolDown) {
                  var10.lastTimeUseThisSkill = System.currentTimeMillis();
                  var10.paintCanNotUseSkill = true;
                  if (!Code.timBG) {
                     var2.gameAB(GameScr.sks[var10.template.id], 0);
                  }
               }
            }

            if (Char.getMyChar().cMP < Char.getMyChar().cMaxMP * Char.aMpValue / 100) {
               Char.getMyChar().gameAE(17);
            }

            if (Char.getMyChar().cHP < Char.getMyChar().cMaxHP * Char.aHpValue / 100) {
               var3 = (int)(System.currentTimeMillis() / 1000L);

               for(int var13 = 0; var13 < Char.getMyChar().vEff.size(); ++var13) {
                  Effect var17;
                  if ((var17 = (Effect)Char.getMyChar().vEff.elementAt(var13)).template.id == 21 && var17.timeLenght - (var3 - var17.timeStart) >= 2) {
                     return;
                  }
               }

               Char.getMyChar().gameAE(16);
            }
         } else {
            Code.gameAF();
         }
      }
   }

   public final String toString() {
      return "Dẫn trẻ";
   }
}
