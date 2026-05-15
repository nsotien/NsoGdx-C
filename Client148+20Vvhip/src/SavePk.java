import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public final class SavePk {
   private static MyVector gameAA;

   private static void gameAC() {
      ByteArrayOutputStream var0 = new ByteArrayOutputStream();
      DataOutputStream var1 = new DataOutputStream(var0);

      try {
         var1.writeInt(gameAA.size());

         for(int var2 = 0; var2 < gameAA.size(); ++var2) {
            var1.writeUTF((String)gameAA.elementAt(var2));
         }

         var1.flush();
         var0.flush();
         RMS.gameAA("V6PKS", var0.toByteArray());
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public static MyVector gameAA() {
      MyVector var0 = new MyVector();

      for(int var1 = 0; var1 < gameAA.size(); ++var1) {
         var0.addElement(var1 + ". " + (String)gameAA.elementAt(var1));
      }

      return var0;
   }

   public static void gameAA(String var0) {
      if (!gameAA.contains(var0)) {
         gameAA.addElement(var0);
         gameAC();
      }

   }

   public static void gameAB(String var0) {
      if (gameAA.contains(var0)) {
         gameAA.removeElement(var0);
         gameAC();
      }

   }

   public static void gameAB() {
      gameAA.removeAllElements();
      gameAC();
   }

   public static boolean gameAC(String var0) {
      return gameAA.contains(var0);
   }

   static {
      (gameAA = new MyVector()).removeAllElements();

      try {
         ByteArrayInputStream var0 = new ByteArrayInputStream(RMS.gameAB("V6PKS"));
         DataInputStream var1;
         int var2 = (var1 = new DataInputStream(var0)).readInt();

         for(int var3 = 0; var3 < var2; ++var3) {
            gameAA.addElement(var1.readUTF());
         }

         var1.close();
         var0.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }
}
