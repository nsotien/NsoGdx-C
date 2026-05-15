public final class EPosition {
   public byte follow;
   public short index = -1;
   public int y;
   public int x;
   public byte count;

   public EPosition(int var1, int var2) {
      this.x = var1;
      this.y = var2;
   }

   public EPosition(int var1, int var2, int var3) {
      this.x = var1;
      this.y = var2;
      this.follow = (byte)var3;
   }

   public EPosition() {
   }
}
