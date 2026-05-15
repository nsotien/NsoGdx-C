public final class EggMonters {
   public static Mob ownerEgg;
   public int x;
   public int y;
   public int frame = 0;
   public byte status = 0;
   public int vy;

   public EggMonters(int var1, int var2) {
      this.x = var1;
      this.y = var2;
   }

   public final boolean gameAA() {
      return this.x >= GameScr.cmx && this.x <= GameScr.cmx + GameScr.gW && this.y >= GameScr.cmy && this.y <= GameScr.cmy + GameScr.gH + 30 && (ownerEgg == null || ownerEgg.status != 8);
   }
}
