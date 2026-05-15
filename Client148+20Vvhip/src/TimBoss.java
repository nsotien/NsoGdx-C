public final class TimBoss implements Runnable {
   public final void run() {
      for(int var1 = 0; var1 < 30; ++var1) {
         Npc var2;
         if (TileMap.zoneID != var1 && (var2 = GameScr.gameAI(13)) != null) {
            if (Math.abs(var2.cx - Char.getMyChar().cx) > 22 || Math.abs(var2.cy - Char.getMyChar().cy) > 22) {
               Char.gameAC(var2.cx, var2.cy);
            }

            Service.gI().gameAA((int)var1, (int)-1);
            TileMap.gameAF();

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var4) {
            }
         }

         for(int var5 = 0; var5 < GameScr.vMob.size(); ++var5) {
            Mob var3;
            if ((var3 = (Mob)GameScr.vMob.elementAt(var5)).isBoss && var3.hp > 0 && var3.status != 0) {
               return;
            }
         }
      }

   }
}
