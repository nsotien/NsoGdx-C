public final class SignedConfig {
   public static String sign(String data) {
      byte[] payload;
      try {
         payload = data.getBytes("UTF-8");
      } catch (Exception var5) {
         payload = data.getBytes();
      }

      byte[] tag = HmacSha256.hmac(SecurityConfig.key(), payload);
      String t = Base64Utils.encode(tag);
      StringBuffer sb = new StringBuffer(data.length() + 1 + t.length());
      sb.append(data);
      sb.append('|');
      sb.append(t);
      return sb.toString();
   }

   public static String verify(String content) {
      int p = content.indexOf(124);
      if (p < 0) {
         return null;
      } else {
         String data = content.substring(0, p);
         String tagB64 = content.substring(p + 1).trim();

         byte[] payload;
         try {
            payload = data.getBytes("UTF-8");
         } catch (Exception var7) {
            payload = data.getBytes();
         }

         byte[] tag = HmacSha256.hmac(SecurityConfig.key(), payload);
         String calc = Base64Utils.encode(tag);
         return calc.equals(tagB64) ? data : null;
      }
   }

   public static String k1() {
      char[] t = new char[]{'M', 'j', 'E', '3', 'd', 'j', 'Q', 't', 'a', '2', 'V', '5', 'L', 'T', 'A', 'x'};
      return new String(t);
   }

   public static String i1(String s) {
      return s;
   }
}
