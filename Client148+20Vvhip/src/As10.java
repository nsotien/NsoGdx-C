public class As10 extends Auto {
   public As10() {
      super.gameAC();
   }

   public boolean gameAE(Char var1) {
      return var1.ctaskId >= 9;
   }

   public void gameAA(Char var1, byte var2, byte var3) {
      switch(var1.ctaskId) {
      case 0:
         NpcTemplate var11 = Npc.arrNpcTemplate[var3];

         for(int var13 = 0; var13 < var11.menu.length; ++var13) {
            if (var11.menu[var13][0].equals("Nói chuyện")) {
               GameScr.gameAB(var3, var13, 0);
               LockGame.gameAO();
               return;
            }
         }

         return;
      case 1:
         if (var1.taskMaint.index == 0) {
            GameScr.gameAB(var3, 0, 0);
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 1) {
            Service.gI().gameAJ(var3, 0);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 2) {
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 3) {
            Service.gI().gameAJ(var3, 2);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 4) {
            Service.gI().gameAJ(var3, 0);
            LockGame.gameAO();
            return;
         }
         break;
      case 2:
         if (var1.taskMaint.index == 0) {
            if (var1.arrItemBag[0] != null) {
               Service.gI().useItem(0);
            }

            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 1) {
            if (TileMap.mapID == 22) {
               this.gameAC(-1);
               this.gameAB(0, 1);
               return;
            }

            this.gameAA(22, -1, -1, -1);
            return;
         }
         break;
      case 3:
         if (var1.taskMaint.index == 0) {
            try {
               Thread.sleep(2000L);
               GameScr.gameAB(4, 0, 0);
               Service.gI().gameAA(9, 0, 3);
               LockGame.gameAO();
               return;
            } catch (InterruptedException var6) {
               var6.printStackTrace();
            }
         }

         if (var1.taskMaint.index == 1) {
            if (var1.arrItemBag[0] != null) {
               Service.gI().useItem(0);
            }

            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 2) {
            if (TileMap.mapID == 23) {
               this.gameAC(-1);
               this.gameAB(1, 1);
               return;
            }

            this.gameAA(23, -1, -1, -1);
            return;
         }

         if (var1.taskMaint.index == 3) {
            if (TileMap.mapID == 23) {
               this.gameAC(-1);
               this.gameAB(2, 1);
               return;
            }

            this.gameAA(23, -1, -1, -1);
            return;
         }
         break;
      case 4:
         if (var1.taskMaint.index == 0) {
            if (TileMap.mapID == 21) {
               this.gameAC(-1);
               this.gameAB(-1, 1);
               return;
            }

            this.gameAA(21, -1, -1, -1);
            return;
         }

         if (var1.taskMaint.index == 1) {
            if (TileMap.mapID == 21) {
               this.gameAC(209);
               this.gameAB(3, 1);
               return;
            }

            this.gameAA(21, -1, -1, -1);
            return;
         }

         if (var1.taskMaint.index == 2) {
            if (TileMap.mapID == 23) {
               this.gameAC(210);
               this.gameAB(4, 1);
               return;
            }

            this.gameAA(23, -1, -1, -1);
            return;
         }
         break;
      case 5:
         if (var1.taskMaint.index == 0) {
            if (TileMap.mapID == 20) {
               this.gameAC(-1);
               this.gameAB(3, 1);
               return;
            }

            this.gameAA(20, -1, -1, -1);
            return;
         }

         if (var1.taskMaint.index == 1) {
            if (TileMap.mapID == 20) {
               this.gameAC(211);
               this.gameAB(54, 1);
               return;
            }

            this.gameAA(20, -1, -1, -1);
            return;
         }
         break;
      case 6:
         if (var1.taskMaint.index == 0) {
            if (TileMap.mapID == 26) {
               this.gameAC(-1);
               this.gameAB(-1, 1);
               return;
            }

            this.gameAA(26, -1, -1, -1);
            return;
         }

         if (var1.taskMaint.index == 1) {
            try {
               super.gameAA(2, -2, -1, -1);
               Thread.sleep(500L);
               return;
            } catch (InterruptedException var8) {
               var8.printStackTrace();
            }
         }

         if (var1.taskMaint.index == 2) {
            try {
               super.gameAA(71, -2, -1, -1);
               Thread.sleep(500L);
               return;
            } catch (InterruptedException var7) {
               var7.printStackTrace();
            }
         }

         if (var1.taskMaint.index == 3) {
            try {
               super.gameAA(26, -2, -1, -1);
               Thread.sleep(500L);
               return;
            } catch (InterruptedException var5) {
               var5.printStackTrace();
               return;
            }
         }
         break;
      case 7:
         if (var1.taskMaint.index == 0) {
            if (TileMap.mapID == 71) {
               this.gameAC(-1);
               this.gameAB(-1, 1);
               return;
            }

            this.gameAA(71, -1, -1, -1);
            return;
         }

         if (var1.taskMaint.index == 1) {
            super.gameAA(var2, -2, -1, -1);
            GameScr.gameAB(var3, 0, 0);
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 2) {
            Service.gI().gameAJ(var3, 0);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 3) {
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 4) {
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 5) {
            Service.gI().gameAJ(var3, 2);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 6) {
            GameScr.gameAB(var3, 0, 0);
            Service.gI().gameAJ(var3, 2);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 7) {
            Service.gI().gameAJ(var3, 0);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 8) {
            Service.gI().gameAJ(var3, 2);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 9) {
            Service.gI().gameAJ(var3, 2);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 10) {
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 11) {
            GameScr.gameAB(var3, 0, 0);
            Service.gI().gameAJ(var3, 0);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 12) {
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 13) {
            Service.gI().gameAJ(var3, 2);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 14) {
            Service.gI().gameAJ(var3, 2);
            LockGame.gameAO();
            return;
         }

         if (var1.taskMaint.index == 15) {
            Service.gI().gameAJ(var3, 1);
            LockGame.gameAO();
            return;
         }
         break;
      case 8:
         if (var1.taskMaint.index == 0) {
            if (TileMap.mapID == 26) {
               this.gameAC(-1);
               this.gameAB(-1, 1);
               return;
            }

            this.gameAA(26, -1, -1, -1);
            return;
         }

         super.gameAA(var2, -2, -1, -1);
         GameScr.gameAH(var3);
         NpcTemplate var12 = Npc.arrNpcTemplate[var3];
         int var10 = 0;

         for(; var10 < var12.menu.length; ++var10) {
            if (var12.menu[var10][0].equals("Nói chuyện")) {
               try {
                  GameScr.gameAB(var3, var10, 0);
                  LockGame.gameAO();
                  Thread.sleep(1000L);
                  return;
               } catch (InterruptedException var9) {
                  var9.printStackTrace();
               }
            }
         }
      }

   }

   public final void gameAK() {
      Char var1 = Char.getMyChar();
      if (this.gameAE(var1)) {
         GameScr.gameAC("Xong!");
         Code.gameAF();
      } else {
         byte var2 = GameScr.gameBD();
         byte var3 = GameScr.gameBE();
         if (Char.getMyChar().cHP <= 0) {
            Auto.gameAA(false);
         } else if (var1.taskMaint == null) {
            if (TileMap.mapID != var2) {
               super.gameAA(var2, -2, -1, -1);
            } else {
               GameScr.gameAB(var3, 0, 0);
               Service.gI().gameAJ(var3, 0);
               LockGame.gameAO();
               super.zoneID = -1;
            }
         } else if (var1.taskMaint.index >= var1.taskMaint.subNames.length - 1) {
            if (TileMap.mapID != var2) {
               super.gameAA(var2, -2, -1, -1);
            } else {
               GameScr.gameAB(var3, 0, 0);
               Service.gI().gameAJ(var3, 0);
               LockGame.gameAO();
               super.zoneID = -1;
            }
         } else {
            this.gameAA(var1, var2, var3);
         }
      }
   }

   public String toString() {
      return "Auto Nhiệm Vụ 10";
   }
}
