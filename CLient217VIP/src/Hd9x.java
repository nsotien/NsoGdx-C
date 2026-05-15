public final class Hd9x extends Auto {
   private int fieldAV;
   private int fieldAW;
   private boolean[] fieldAX;

   public Hd9x() {
      super.fieldAD();
      super.fieldAD = true;
      super.fieldAC = -2;
      this.fieldAV = 199;
      this.fieldAW = 0;
      this.fieldAX = new boolean[3];
      super.fieldAB = TileMap.mapID;
   }

   public final void fieldAA() {
      if (Auto.fieldAF()) {
         Auto.fieldAA(true);
      } else {
         super.fieldAB = TileMap.mapID;
         Char var2 = Char.getMyChar();
         Mob var3 = null;
         MyVector var4 = GameScr.vMob;

         for (int var5 = 0; var5 < var4.size(); var5++) {
            Mob var6 = (Mob)var4.elementAt(var5);
            if (var6 != null && var6.hp > 0 && var6.status != 0 && var6.status != 1 && !var6.isBoss) {
               var3 = var6;
               break;
            }
         }

         if (Auto.fieldAL != null && var3 != null) {
            Skill var12 = Auto.fieldAL;
            if ((var12.template.type == 1 || var12.template.type == 3)
               && (Res.abs(var2.cx - var3.xFirst) > var12.dx || Res.abs(var2.cy - var3.yFirst) > var12.dy)) {
               this.fieldAC(var3);
            }

            Service.gI().selectSkill(var12.template.id);
            if (var12.template.type == 2) {
               Service.gI().sendUseSkillMyBuff();
            } else {
               Auto.fieldAP.removeAllElements();
               Auto.fieldAQ.removeAllElements();
               Auto.fieldAP.addElement(var3);

               for (int var7 = 0; var7 < GameScr.vMob.size() && Auto.fieldAP.size() + Auto.fieldAQ.size() < var12.maxFight; var7++) {
                  Mob var6 = (Mob)GameScr.vMob.elementAt(var7);
                  if (var6.status != 0
                     && var6.status != 1
                     && !var6.equals(var3)
                     && !var6.isBoss
                     && var3.xFirst - 100 <= var6.xFirst
                     && var6.xFirst <= var3.xFirst + 100
                     && var3.yFirst - 50 <= var6.yFirst
                     && var6.yFirst <= var3.yFirst + 50) {
                     Auto.fieldAP.addElement(var6);
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

            if (System.currentTimeMillis() - var12.lastTimeUseThisSkill >= var12.coolDown) {
               var12.lastTimeUseThisSkill = System.currentTimeMillis();
               var12.paintCanNotUseSkill = true;
               if (!Code.fieldBF) {
                  var2.gameAB(GameScr.sks[var12.template.id], 0);
               }
            }

            super.fieldAR = System.currentTimeMillis();
         }

         this.fieldAC(-1);
      }
   }

   public final String toString() {
      return "AuTo HĐ9x " + this.fieldAW;
   }
}
