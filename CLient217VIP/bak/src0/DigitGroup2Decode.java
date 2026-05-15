public final class DigitGroup2Decode {
   public static char map(char c, char[] key) {
      for (int d = 5; d <= 9; d++) {
         if (c == key[d + 1]) {
            return (char)(48 + d);
         }
      }

      return c;
   }
}
