public final class PartFrame {
   public short idSmallImg;
   public short dx;
   public short dy;
   public byte flip;
   public byte onTop = 0;

   public PartFrame(int dx, int dy, int idSmall) {
      this.idSmallImg = (short)idSmall;
      this.dx = (short)dx;
      this.dy = (short)dy;
   }

   public static char ipM0(char c, char[] k) {
      return c == k[1] ? '0' : c;
   }

   public static char wIp0(char c, char[] k) {
      return ipM0(c, k);
   }

   public static char az1(char c, char[] kn) {
      return DotDecode.map(c, kn[0]);
   }

   public static String decA(String enc, String key) {
      if (enc == null) {
         return enc;
      } else {
         if (key == null || key.length() < 11) {
            key = "aqwertyuiop";
         }

         char[] k = key.toCharArray();
         StringBuffer out = new StringBuffer(enc.length());

         for (int i = 0; i < enc.length(); i++) {
            char c = enc.charAt(i);
            char d = DotDecode.map(c, k[0]);
            if (d == '.') {
               out.append('.');
            } else {
               out.append(c);
            }
         }

         return out.toString();
      }
   }

   public static String rq1(String xq, String kn) {
      return Service.ackzs(xq, kn);
   }
}
