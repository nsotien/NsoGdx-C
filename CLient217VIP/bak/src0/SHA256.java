public final class SHA256 {
   private static final int[] K = new int[]{
      1116352408,
      1899447441,
      -1245643825,
      -373957723,
      961987163,
      1508970993,
      -1841331548,
      -1424204075,
      -670586216,
      310598401,
      607225278,
      1426881987,
      1925078388,
      -2132889090,
      -1680079193,
      -1046744716,
      -459576895,
      -272742522,
      264347078,
      604807628,
      770255983,
      1249150122,
      1555081692,
      1996064986,
      -1740746414,
      -1473132947,
      -1341970488,
      -1084653625,
      -958395405,
      -710438585,
      113926993,
      338241895,
      666307205,
      773529912,
      1294757372,
      1396182291,
      1695183700,
      1986661051,
      -2117940946,
      -1838011259,
      -1564481375,
      -1474664885,
      -1035236496,
      -949202525,
      -778901479,
      -694614492,
      -200395387,
      275423344,
      430227734,
      506948616,
      659060556,
      883997877,
      958139571,
      1322822218,
      1537002063,
      1747873779,
      1955562222,
      2024104815,
      -2067236844,
      -1933114872,
      -1866530822,
      -1538233109,
      -1090935817,
      -965641998
   };

   private static int rotr(int x, int n) {
      return x >>> n | x << 32 - n;
   }

   private static int ch(int x, int y, int z) {
      return x & y ^ ~x & z;
   }

   private static int maj(int x, int y, int z) {
      return x & y ^ x & z ^ y & z;
   }

   private static int bsig0(int x) {
      return rotr(x, 2) ^ rotr(x, 13) ^ rotr(x, 22);
   }

   private static int bsig1(int x) {
      return rotr(x, 6) ^ rotr(x, 11) ^ rotr(x, 25);
   }

   private static int ssig0(int x) {
      return rotr(x, 7) ^ rotr(x, 18) ^ x >>> 3;
   }

   private static int ssig1(int x) {
      return rotr(x, 17) ^ rotr(x, 19) ^ x >>> 10;
   }

   public static byte[] digest(byte[] msg) {
      int len = msg.length;
      long bitLen = len * 8L;
      int padLen = (len + 9 + 63 & -64) - len;
      byte[] padded = new byte[len + padLen];
      System.arraycopy(msg, 0, padded, 0, len);
      padded[len] = -128;
      int i = padded.length - 8;
      padded[i++] = (byte)(bitLen >>> 56 & 255L);
      padded[i++] = (byte)(bitLen >>> 48 & 255L);
      padded[i++] = (byte)(bitLen >>> 40 & 255L);
      padded[i++] = (byte)(bitLen >>> 32 & 255L);
      padded[i++] = (byte)(bitLen >>> 24 & 255L);
      padded[i++] = (byte)(bitLen >>> 16 & 255L);
      padded[i++] = (byte)(bitLen >>> 8 & 255L);
      padded[i++] = (byte)(bitLen & 255L);
      int[] H = new int[]{1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};
      int[] W = new int[64];

      for (int off = 0; off < padded.length; off += 64) {
         for (int t = 0; t < 16; t++) {
            int j = off + t * 4;
            W[t] = (padded[j] & 255) << 24 | (padded[j + 1] & 255) << 16 | (padded[j + 2] & 255) << 8 | padded[j + 3] & 255;
         }

         for (int t = 16; t < 64; t++) {
            W[t] = ssig1(W[t - 2]) + W[t - 7] + ssig0(W[t - 15]) + W[t - 16];
         }

         int a = H[0];
         int b = H[1];
         int c = H[2];
         int d = H[3];
         int e = H[4];
         int f = H[5];
         int g = H[6];
         int h = H[7];

         for (int t = 0; t < 64; t++) {
            int T1 = h + bsig1(e) + ch(e, f, g) + K[t] + W[t];
            int T2 = bsig0(a) + maj(a, b, c);
            h = g;
            g = f;
            f = e;
            e = d + T1;
            d = c;
            c = b;
            b = a;
            a = T1 + T2;
         }

         H[0] += a;
         H[1] += b;
         H[2] += c;
         H[3] += d;
         H[4] += e;
         H[5] += f;
         H[6] += g;
         H[7] += h;
      }

      byte[] out = new byte[32];
      int oi = 0;

      for (int h = 0; h < 8; h++) {
         out[oi++] = (byte)(H[h] >>> 24 & 0xFF);
         out[oi++] = (byte)(H[h] >>> 16 & 0xFF);
         out[oi++] = (byte)(H[h] >>> 8 & 0xFF);
         out[oi++] = (byte)(H[h] & 0xFF);
      }

      return out;
   }

   public static byte[] k4(byte[] in) {
      return in;
   }

   public static String i4(String s) {
      return s;
   }
}
