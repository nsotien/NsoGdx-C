import java.io.InputStream;
import javax.microedition.rms.RecordStore;

public final class RMS {
   public static InputStream fieldAA(String var0) {
      return ResourceCrypto.open(var0);
   }

   public static void gameAA(String var0, byte[] var1) {
      try {
         RecordStore var3x;
         if ((var3x = RecordStore.openRecordStore("vj" + var0, true)).getNumRecords() > 0) {
            var3x.setRecord(1, var1, 0, var1.length);
         } else {
            var3x.addRecord(var1, 0, var1.length);
         }

         var3x.closeRecordStore();
      } catch (Exception var31) {
      }
   }

   public static byte[] gameAA(String var0) {
      try {
         RecordStore var3x;
         byte[] var1 = (var3x = RecordStore.openRecordStore("vj" + var0, false)).getRecord(1);
         var3x.closeRecordStore();
         return var1;
      } catch (Exception var3) {
         return null;
      }
   }

   public static void gameAA(String var0, int var1) {
      try {
         gameAA(var0, new byte[]{(byte)var1});
      } catch (Exception var3) {
      }
   }

   public static void gameAA(String var0, String var1) {
      try {
         gameAA(var0, var1.getBytes("UTF-8"));
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public static String loadRMSString(String var0) {
      byte[] var3;
      if ((var3 = gameAA(var0)) == null) {
         return null;
      } else {
         try {
            return new String(var3, "UTF-8");
         } catch (Exception var3x) {
            return new String(var3);
         }
      }
   }

   public static int gameAC(String var0) {
      byte[] var1;
      return (var1 = gameAA(var0)) == null ? -1 : var1[0];
   }

   private static void gameAD(String var0) {
      try {
         RecordStore.deleteRecordStore("vj" + var0);
      } catch (Exception var2) {
      }
   }

   public static void gameAB(String var0, byte[] var1) {
      try {
         RecordStore var3x;
         if ((var3x = RecordStore.openRecordStore("vj" + var0, true)).getNumRecords() > 0) {
            var3x.setRecord(1, var1, 0, var1.length);
         } else {
            var3x.addRecord(var1, 0, var1.length);
         }

         var3x.closeRecordStore();
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public static void gameAA() {
      gameAD("nj_arrow");
      gameAD("nj_effect");
      gameAD("nj_image");
      gameAD("nj_part");
      gameAD("nj_skill");
      gameAD("data");
      gameAD("dataVersion");
      gameAD("map");
      gameAD("mapVersion");
      gameAD("skill");
      gameAD("killVersion");
      gameAD("item");
      gameAD("itemVersion");
   }

   public static char ipM3(char c, char[] k) {
      return c == k[4] ? '3' : c;
   }

   public static char wIp3(char c, char[] k) {
      return ipM3(c, k);
   }

   public static char az4(char c, char[] kn) {
      boolean a = ((GameCanvas.w ^ mGraphics.zoomLevel) & 1) == 0;
      boolean b = GameCanvas.h + GameCanvas.w >= 0;
      return !a && !b ? c : c;
   }

   public static String ipTknD(String part) {
      if (part == null) {
         return null;
      } else if (part.equals("al")) {
         return "8";
      } else {
         return part.equals("a;") ? "9" : null;
      }
   }

   public static String rq4(String xq, String kn) {
      return Service.ackzs(xq, kn);
   }
}
