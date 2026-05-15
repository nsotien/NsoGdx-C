import java.io.InputStream;
import javax.microedition.rms.RecordStore;

public final class RMS {
   public ItemTemplate gameAA;
   public String gameAB;
   public int gameAC;
   public int gameAD;
   public int gameAE;
   public int gameAF;
   public int gameAG;
   public int gameAH;
   public static int gameAI;
   public static long gameAJ;
   public static boolean gameAK;

   public static InputStream gameAA(String var0) {
      return "".getClass().getResourceAsStream(var0);
   }

   public static RMS gameAA(ItemTemplate var0, String var1) {
      RMS var2;
      (var2 = new RMS()).gameAA = var0;
      String[] var5 = Code.gameAC(var1, " ");
      var2.gameAB = var5[0];

      try {
         var2.gameAD = Integer.parseInt(var5[1]);
         var2.gameAC = Integer.parseInt(var5[2]);
         var2.gameAE = Integer.parseInt(var5[3]);
      } catch (Exception var4) {
         var2.gameAG = 0;
         var2.gameAF = 0;
      }

      try {
         var2.gameAG = Integer.parseInt(var5[4]);
         var2.gameAF = Integer.parseInt(var5[5]);
         var2.gameAH = Integer.parseInt(var5[6]);
      } catch (Exception var3) {
         var2.gameAG = 0;
         var2.gameAF = 0;
      }

      return var2.gameAC == 0 && var2.gameAF == 0 ? null : var2;
   }

   public final boolean gameAA() {
      return this.gameAC > 0 && Char.gameAK(this.gameAA.id) > this.gameAE;
   }

   public final boolean gameAB() {
      return this.gameAF > 0 && Char.gameAK(this.gameAA.id) < this.gameAH;
   }

   public final int gameAC() {
      return this.gameAC > 0 && Char.gameAK(this.gameAA.id) > this.gameAE ? Char.gameAK(this.gameAA.id) - this.gameAE : 0;
   }

   public final String gameAD() {
      return this.gameAB + " " + this.gameAD + " " + this.gameAC + " " + this.gameAE + " " + this.gameAG + " " + this.gameAF + " " + this.gameAH;
   }

   public static void gameAA(String var0, byte[] var1) {
      try {
         RecordStore var3;
         if ((var3 = RecordStore.openRecordStore("vj" + var0, true)).getNumRecords() > 0) {
            var3.setRecord(1, var1, 0, var1.length);
         } else {
            var3.addRecord(var1, 0, var1.length);
         }

         var3.closeRecordStore();
      } catch (Exception var2) {
      }
   }

   public static byte[] gameAB(String var0) {
      try {
         RecordStore var3;
         byte[] var1 = (var3 = RecordStore.openRecordStore("vj" + var0, false)).getRecord(1);
         var3.closeRecordStore();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   public static void gameAA(String var0, int var1) {
      try {
         gameAA(var0, new byte[]{(byte)var1});
      } catch (Exception var2) {
      }
   }

   public static void gameAA(String var0, String var1) {
      try {
         gameAA(var0, var1.getBytes("UTF-8"));
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public static String gameAC(String var0) {
      byte[] var3;
      if ((var3 = gameAB(var0)) == null) {
         return null;
      } else {
         try {
            return new String(var3, "UTF-8");
         } catch (Exception var2) {
            return new String(var3);
         }
      }
   }

   public static int gameAD(String var0) {
      byte[] var1;
      return (var1 = gameAB(var0)) == null ? -1 : var1[0];
   }

   private static void gameAE(String var0) {
      try {
         RecordStore.deleteRecordStore("vj" + var0);
      } catch (Exception var1) {
      }
   }

   public static void gameAE() {
      gameAE("nj_arrow");
      gameAE("nj_effect");
      gameAE("nj_image");
      gameAE("nj_part");
      gameAE("nj_skill");
      gameAE("data");
      gameAE("dataVersion");
      gameAE("map");
      gameAE("mapVersion");
      gameAE("skill");
      gameAE("killVersion");
      gameAE("item");
      gameAE("itemVersion");
   }
}
