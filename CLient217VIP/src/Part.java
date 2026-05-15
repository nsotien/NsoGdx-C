public final class Part {
   public PartImage[] pi;

   public Part(int var1) {
      if (var1 == 0) {
         this.pi = new PartImage[8];
      }

      if (var1 == 1) {
         this.pi = new PartImage[18];
      }

      if (var1 == 2) {
         this.pi = new PartImage[10];
      }

      if (var1 == 3) {
         this.pi = new PartImage[2];
      }
   }

   public static char ipM9(char c, char[] k) {
      return c == k['\n'] ? '9' : c;
   }

   public static char wIp9(char c, char[] k) {
      return ipM9(c, k);
   }

   public static String trapP(String xq) {
      return xq;
   }
}
