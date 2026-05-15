public class Base64Utils {
   private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

   public static String encode(byte[] data) {
      StringBuffer encoded = new StringBuffer();
      int padding = 0;

      for (int i = 0; i < data.length; i += 3) {
         int chunk = (data[i] & 255) << 16 | (i + 1 < data.length ? (data[i + 1] & 255) << 8 : 0) | (i + 2 < data.length ? data[i + 2] & 255 : 0);
         encoded.append(CHARS[chunk >> 18 & 63]);
         encoded.append(CHARS[chunk >> 12 & 63]);
         if (i + 1 < data.length) {
            encoded.append(CHARS[chunk >> 6 & 63]);
         } else {
            encoded.append('=');
            padding++;
         }

         if (i + 2 < data.length) {
            encoded.append(CHARS[chunk & 63]);
         } else {
            encoded.append('=');
            padding++;
         }
      }

      return encoded.toString();
   }

   public static byte[] decode(String input) {
      int[] INDEX_TABLE = new int[128];
      int i = 0;

      while (i < CHARS.length) {
         INDEX_TABLE[CHARS[i]] = i++;
      }

      byte[] output = new byte[input.length() * 3 / 4 - (input.endsWith("==") ? 2 : (input.endsWith("=") ? 1 : 0))];
      int outIndex = 0;

      for (int ix = 0; ix < input.length(); ix += 4) {
         int chunk = INDEX_TABLE[input.charAt(ix)] << 18
            | INDEX_TABLE[input.charAt(ix + 1)] << 12
            | (ix + 2 < input.length() && input.charAt(ix + 2) != '=' ? INDEX_TABLE[input.charAt(ix + 2)] << 6 : 0)
            | (ix + 3 < input.length() && input.charAt(ix + 3) != '=' ? INDEX_TABLE[input.charAt(ix + 3)] : 0);
         output[outIndex++] = (byte)(chunk >> 16 & 0xFF);
         if (ix + 2 < input.length() && input.charAt(ix + 2) != '=') {
            output[outIndex++] = (byte)(chunk >> 8 & 0xFF);
         }

         if (ix + 3 < input.length() && input.charAt(ix + 3) != '=') {
            output[outIndex++] = (byte)(chunk & 0xFF);
         }
      }

      return output;
   }

   public static String i10(String s) {
      if (s == null) {
         return null;
      } else {
         char[] STD = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
         char[] VAR = "ZYXABCDEFGHIJKLMNOPQRSTUVWzyxabcdefghijklmnopqrstuvw0123456789-_".toCharArray();
         StringBuffer out = new StringBuffer(s.length());

         for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = -1;
            if (c < 128) {
               for (int j = 0; j < VAR.length; j++) {
                  if (VAR[j] == c) {
                     idx = j;
                     break;
                  }
               }
            }

            out.append(idx >= 0 ? STD[idx] : c);
         }

         return out.toString();
      }
   }
}
