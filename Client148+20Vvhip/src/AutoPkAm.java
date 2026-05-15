public final class AutoPkAm extends Auto {
   private static long gameAW = 0L;
   private long gameAX = 0L;
   private boolean gameAY = false;
   public static Auto gameAV;

   public final void gameAL() {
      super.gameAC();
      if (Code.gameBW == -1 || Code.gameBX == -1 || Code.gameBY == -1) {
         Code.gameBW = 70;
         Code.gameBX = 1500;
         Code.gameBY = 528;
      }

      this.mapID = Code.gameBW;
      this.zoneID = Code.gameBV;
      this.gameAD = TileMap.gameAG(Code.gameBW);
   }

   public final void gameAK() {
      long var1 = (Char.getMyChar().cExpDown > 0L ? Char.getMyChar().cExpDown : Char.getMyChar().autoUpHp) * 100L / GameScr.exps[Char.getMyChar().clevel];
      if ((Char.getMyChar().cExpDown <= 0L || Math.abs(var1) > 15L) && (Char.getMyChar().cExpDown > 0L || Math.abs(var1) < 0L)) {
         Service.gI().gameAZ(0);
         GameScr.gameAC("Đã pk xong!!");
         if (gameAV != null) {
            LockGame.gameBK();
            Code.gameAB = gameAV;
            gameAV = null;
         } else {
            Code.gameAC();
         }
      } else if (Char.getMyChar().cPk <= 10 && !this.gameAY) {
         if (reAC()) {
            gameAA(true);

            try {
               Thread.sleep(1500L);
            } catch (InterruptedException var4) {
            }
         } else if (TileMap.mapID == Code.gameBW && TileMap.zoneID == Code.gameBU) {
            if (Char.getMyChar().cx == Code.gameBX && Char.getMyChar().cy == Code.gameBY) {
               if (System.currentTimeMillis() - gameAW >= 300L) {
                  MyVector var8 = new MyVector();

                  for(int var2 = 0; var2 < GameScr.vCharInMap.size(); ++var2) {
                     Char var3;
                     if ((var3 = (Char)GameScr.vCharInMap.elementAt(var2)).cHP > 0 && Math.abs(Char.getMyChar().cx - var3.cx) <= 50 && Math.abs(Char.getMyChar().cy - var3.cy) <= 50 && var8.size() <= skill1.maxFight) {
                        var8.addElement(var3);
                        if (var3.cHP > 0 && Math.abs(Char.getMyChar().cx - var3.cx) <= 50 && Math.abs(Char.getMyChar().cy - var3.cy) <= 50) {
                           Service.gI().gameAA((MyVector)(new MyVector()), (MyVector)var8, (int)2);
                           gameAW = System.currentTimeMillis();
                        }
                     }
                  }
               }

               try {
                  Thread.sleep(100L);
               } catch (InterruptedException var5) {
               }
            } else {
               Service.gI().gameAZ(3);
               if (Code.gameBX != -1 && Code.gameBY != -1) {
                  Char.gameAC(Code.gameBX, Code.gameBY);
               } else {
                  Code.gameBX = Char.getMyChar().cx;
                  Code.gameBY = Char.getMyChar().cy;
               }

               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var6) {
               }
            }
         } else {
            this.gameAA(Code.gameBW, Code.gameBU, -1, -1);
         }
      } else {
         this.gameAY = Char.getMyChar().cPk > 6;
         if (reAC()) {
            gameAA(true);
         } else if (TileMap.mapID == Code.gameBW && TileMap.zoneID == Code.gameBV) {
            if (Char.getMyChar().cx == Code.gameBX && Char.getMyChar().cy == Code.gameBY) {
               Code.gameAO();
               if (System.currentTimeMillis() - this.gameAX >= 30000L) {
                  Code var10000 = Code.gameAA;
                  Code.gameAH("buon nhu cho can");
                  this.gameAX = System.currentTimeMillis();
               }
            } else {
               Service.gI().gameAZ(3);
               if (Code.gameBX != -1 && Code.gameBY != -1) {
                  Char.gameAC(Code.gameBX, Code.gameBY);
               } else {
                  Code.gameBX = Char.getMyChar().cx;
                  Code.gameBY = Char.getMyChar().cy;
               }

               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var7) {
               }
            }
         } else {
            this.gameAA(Code.gameBW, Code.gameBV, -1, -1);
         }
      }
   }

   public final String toString() {
      return "Auto pk âm";
   }
}
