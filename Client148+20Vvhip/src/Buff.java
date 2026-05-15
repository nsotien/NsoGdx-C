public final class Buff extends Auto {
   private boolean gameAV;
   private boolean gameAW;
   private long gameAX = 0L;

   public final void gameAA(int var1, int var2, boolean var3, boolean var4) {
      super.gameAC();
      super.mapID = var1;
      super.zoneID = var2;
      super.gameAD = TileMap.gameAG(var1);
      this.gameAV = var3;
      this.gameAW = var4;
      super.gameAA = true;
   }

   public final void gameAK() {
      if (Auto.reAC()) {
         Auto.gameAA(true);
      } else if (super.mapID == TileMap.mapID && (TileMap.gameAG(super.mapID) || super.zoneID == TileMap.zoneID)) {
         Char var1 = Char.getMyChar();
         int var2;
         int var3;
         int var4;
         Char var5;
         int var6;
         Skill var7;
         if (this.gameAW && (GameScr.vParty.size() > 1 || Code.gameAJ.size() > 0) && var1.nClass.classId == 6) {
            label301:
            for(var6 = 0; var6 < var1.vSkillFight.size(); ++var6) {
               if ((var7 = (Skill)var1.vSkillFight.elementAt(var6)) != null && var7.template.type == 4) {
                  if (System.currentTimeMillis() - this.gameAX <= 3000L) {
                     break;
                  }

                  for(var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
                     Party var8;
                     if ((var8 = (Party)GameScr.vParty.elementAt(var2)).charId != var1.charID && var8.c != null && var8.c.cHP <= 0) {
                        try {
                           var3 = var1.cx;
                           var4 = var1.cy;
                           var5 = var8.c;
                           Char.gameAC(var8.c.cx, var5.cy);
                           Thread.sleep(500L);
                           if (Auto.gameAB(var5)) {
                              this.gameAX = System.currentTimeMillis();
                              Service.gI().gameAX(var8.charId);
                              var7.lastTimeUseThisSkill = System.currentTimeMillis();
                              var7.paintCanNotUseSkill = true;
                              var1.gameAB(GameScr.sks[var7.template.id], 0);
                              Thread.sleep(1000L);
                           }

                           Char.gameAC(var3, var4);
                           return;
                        } catch (InterruptedException var11) {
                           var11.printStackTrace();
                        }
                     }
                  }

                  var2 = 0;

                  while(true) {
                     if (var2 >= GameScr.vCharInMap.size()) {
                        break label301;
                     }

                     if ((var5 = (Char)GameScr.vCharInMap.elementAt(var2)) != null && Auto.gameAB(var5) && Code.gameAA(var5.cName)) {
                        try {
                           var3 = var1.cx;
                           var4 = var1.cy;
                           Char.gameAC(var5.cx, var5.cy);
                           Thread.sleep(500L);
                           if (Auto.gameAB(var5)) {
                              this.gameAX = System.currentTimeMillis();
                              Service.gI().gameAX(var5.charID);
                              var7.lastTimeUseThisSkill = System.currentTimeMillis();
                              var7.paintCanNotUseSkill = true;
                              var1.gameAB(GameScr.sks[var7.template.id], 0);
                              Thread.sleep(1000L);
                           }

                           Char.gameAC(var3, var4);
                           return;
                        } catch (InterruptedException var10) {
                           var10.printStackTrace();
                        }
                     }

                     ++var2;
                  }
               }
            }
         }

         var5 = GameScr.vParty.size() > 0 ? ((Party)GameScr.vParty.firstElement()).c : null;
         if (this.gameAV && this.gameAG() && var5 != null && var1.nClass.classId == 6) {
            for(var6 = 0; var6 < var1.vSkillFight.size(); ++var6) {
               if ((var7 = (Skill)var1.vSkillFight.elementAt(var6)) != null && !var7.gameAA() && var7.template.type == 2 && (var7.template.id < 67 || var7.template.id > 72) && (var7.template.id != 47 || var5.cHP < var5.cMaxHP * Char.aHpValue / 100)) {
                  try {
                     for(var3 = 0; var3 < var5.vEff.size(); ++var3) {
                        var5.vEff.elementAt(var3);
                     }

                     var3 = var1.cx;
                     var4 = var1.cy;
                     Char.gameAC(var5.cx, var5.cy);
                     Service.gI().gameAG(var7.template.id);
                     Service.gI().gameAR();
                     var7.lastTimeUseThisSkill = System.currentTimeMillis();
                     var7.paintCanNotUseSkill = true;
                     var1.gameAB(GameScr.sks[var7.template.id], 0);
                     Thread.sleep(1000L);
                     Char.gameAC(var3, var4);
                     return;
                  } catch (InterruptedException var9) {
                     var9.printStackTrace();
                  }
               }
            }
         }

         if (Code.gameBO) {
            Char var12 = var1.charFocus;
            if ((var1.charFocus == null || !SavePk.gameAC(var12.cName) && !Auto.gameAA(var1, var12)) && (var12 = this.gameAA(var1, -1)) == null) {
               var12 = Auto.gameAD(var1);
            }

            boolean var13 = var12 != null && SavePk.gameAC(var12.cName);
            if (var12 == null && super.gameAU) {
               Service.gI().gameAZ(0);
               super.gameAU = false;
            }

            if (var1.cPk >= 5 && System.currentTimeMillis() - super.gameAT > 5000L) {
               Item var14;
               if ((var14 = Char.gameAF(257)) != null && var14.template.id == 257) {
                  Service.gI().useItem(var14.indexUI);
               }

               super.gameAT = System.currentTimeMillis();
            }

            if (var12 != null && var12 != null && !Auto.gameAB(var12) && (var13 || Auto.gameAA(var1, var12))) {
               Skill var15 = Auto.skill1;
               if (var13) {
                  if ((var15.template.type == 1 || var15.template.type == 3) && (Res.abs(var1.cx - var12.cx) > var15.dx + 30 || Res.abs(var1.cy - var12.cy) > var15.dy + 30) && System.currentTimeMillis() - super.gameAS > 1500L) {
                     Auto.gameAC(var12);
                     super.gameAS = System.currentTimeMillis();
                  }

                  if (var12.killCharId != var1.charID && var12.cTypePk != 3) {
                     super.gameAU = true;
                     Service.gI().gameAZ(3);
                  }
               }

               var3 = var15.dx;
               var4 = var15.dy;
               Auto.reAE.removeAllElements();
               Auto.reAF.removeAllElements();
               Auto.reAF.addElement(var12);

               for(var2 = 0; var2 < GameScr.vCharInMap.size() && Auto.reAE.size() + Auto.reAF.size() < var15.maxFight; ++var2) {
                  if ((var5 = (Char)GameScr.vCharInMap.elementAt(var2)).cHP > 0 && var5.statusMe != 14 && var5.statusMe != 5 && var5.statusMe != 15 && !var5.equals(var12) && (var5.cTypePk == 3 || var1.cTypePk == 3 || var5.cTypePk == 1 && var1.cTypePk == 1 || var1.killCharId >= 0 && var1.killCharId == var5.charID || var1.testCharId >= 0 && var1.testCharId == var5.charID) && !Code.gameAD(var5.cName) && var12.cx - var3 <= var5.cx && var5.cx <= var12.cx + var3 && var12.cy - var4 <= var5.cy && var5.cy <= var12.cy + var4) {
                     Auto.reAF.addElement(var5);
                  }
               }

               Service.gI().gameAA((MyVector)Auto.reAE, (MyVector)Auto.reAF, (int)2);
               if (System.currentTimeMillis() - var15.lastTimeUseThisSkill >= (long)var15.coolDown) {
                  var15.lastTimeUseThisSkill = System.currentTimeMillis();
                  var15.paintCanNotUseSkill = true;
                  if (!Code.timBG) {
                     var1.gameAB(GameScr.sks[var15.template.id], 0);
                  }
               }

               super.gameAR = System.currentTimeMillis();
               return;
            }
         }

      } else {
         this.gameAA(super.mapID, super.zoneID, -1, -1);
      }
   }

   public final String toString() {
      if (this.gameAV && this.gameAW) {
         return "Buff HS Xa";
      } else {
         return this.gameAW ? "HSinh Xa" : "Buff Xa";
      }
   }
}
