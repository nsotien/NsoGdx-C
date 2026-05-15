package base.game2;

public class CaiGom {
   public static boolean enabled = false;
   public static String receiverName = "";
   public static String itemGDStr = "";
   public static String itemCatStr = "";
   public static boolean autoCat = false;
   public static int gioNhan = 0;
   public static int phutNhan = 0;
   public static int mapNhan = 22;
   public static int zoneNhan = 1;

   public static int gomCC = -1;

   public static volatile int runningState = -1;
   public static volatile int runningGdIdx = 0;
   public static volatile long runningStart = 0L;
   public static volatile int runningFindRetry = 0;
   public static volatile Auto runningModeTemp = null;
   public static volatile int lastTradeId = -1;
   public static volatile int lastTradeCount = 0;
   public static volatile int tradeFailCount = 0;

   public static void resetTradeFail() {
      lastTradeId = -1;
      lastTradeCount = 0;
      tradeFailCount = 0;
   }

   public static int[] parseIds(String csv) {
      if (csv == null || csv.trim().length() == 0) return new int[0];
      String[] arr = Code.split_string(csv, ",");
      int[] out = new int[arr.length];
      int n = 0;
      for (int i = 0; i < arr.length; i++) {
         String s = arr[i].trim();
         if (s.length() == 0) continue;
         try { out[n++] = Integer.parseInt(s); } catch (Exception e) {}
      }
      if (n == arr.length) return out;
      int[] trim = new int[n];
      System.arraycopy(out, 0, trim, 0, n);
      return trim;
   }

   public static int[] itemGDIds() { return parseIds(itemGDStr); }
   public static int[] itemCatIds() { return parseIds(itemCatStr); }

   public static void save() {
      StringBuilder sb = new StringBuilder();
      sb.append(enabled).append(';');
      sb.append(receiverName == null ? "" : receiverName).append(';');
      sb.append(itemGDStr == null ? "" : itemGDStr).append(';');
      sb.append(itemCatStr == null ? "" : itemCatStr).append(';');
      sb.append(autoCat).append(';');
      sb.append(gioNhan).append(';');
      sb.append(phutNhan).append(';');
      sb.append(mapNhan).append(';');
      sb.append(zoneNhan);
      RMS.a("autoGom", sb.toString());
      gomCC = -1;
   }

   public static void load() {
      String raw = RMS.b("autoGom");
      if (raw == null || raw.length() == 0) {
         return;
      }
      try {
         String[] arr = Code.split_string(raw, ";");
         int i = 0;
         if (arr.length > i) enabled = arr[i++].equals("true");
         if (arr.length > i) receiverName = arr[i++];
         if (arr.length > i) itemGDStr = arr[i++];
         if (arr.length > i) itemCatStr = arr[i++];
         if (arr.length > i) autoCat = arr[i++].equals("true");
         if (arr.length > i) gioNhan = Integer.parseInt(arr[i++]);
         if (arr.length > i) phutNhan = Integer.parseInt(arr[i++]);
         if (arr.length > i) mapNhan = Integer.parseInt(arr[i++]);
         if (arr.length > i) zoneNhan = Integer.parseInt(arr[i++]);
      } catch (Exception e) {
      }
   }
}
