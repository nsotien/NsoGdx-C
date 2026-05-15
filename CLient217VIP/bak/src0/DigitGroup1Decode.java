public final class DigitGroup1Decode {
   public static char map(char c, char[] key) {
      for (int d = 0; d <= 4; d++) {
         if (c == key[d + 1]) {
            return (char)(48 + d);
         }
      }

      return c;
   }
}
