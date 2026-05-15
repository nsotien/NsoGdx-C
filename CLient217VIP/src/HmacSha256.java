public final class HmacSha256 {
   private static final int BLOCK = 64;

   public static byte[] hmac(byte[] key, byte[] data) {
      byte[] k = key;
      if (key.length > 64) {
         k = SHA256.digest(key);
      }

      byte[] kip = new byte[64];
      byte[] kop = new byte[64];

      int i;
      for (i = 0; i < k.length; i++) {
         kip[i] = (byte)(k[i] ^ 54);
         kop[i] = (byte)(k[i] ^ 92);
      }

      while (i < 64) {
         kip[i] = 54;
         kop[i] = 92;
         i++;
      }

      byte[] inner = new byte[64 + data.length];
      System.arraycopy(kip, 0, inner, 0, 64);
      System.arraycopy(data, 0, inner, 64, data.length);
      byte[] innerHash = SHA256.digest(inner);
      byte[] outer = new byte[64 + innerHash.length];
      System.arraycopy(kop, 0, outer, 0, 64);
      System.arraycopy(innerHash, 0, outer, 64, innerHash.length);
      return SHA256.digest(outer);
   }

   public static byte[] k2(byte[] in) {
      byte[] out = new byte[in.length];

      for (int i = 0; i < in.length; i++) {
         out[i] = (byte)(in[i] ^ 0);
      }

      return out;
   }

   public static String i2(String s) {
      return s;
   }
}
