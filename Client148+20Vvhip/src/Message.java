import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class Message {
   public byte gameAA;
    ByteArrayOutputStream gameAB = null;
    DataOutputStream gameAC = null;
    private ByteArrayInputStream gameAD = null;
    DataInputStream gameAE = null;

   public Message() {
   }

   public Message(byte var1) {
      this.gameAA = var1;
      this.gameAB = new ByteArrayOutputStream();
      this.gameAC = new DataOutputStream(this.gameAB);
   }

   public Message(byte var1, byte[] var2) {
      this.gameAA = var1;
      this.gameAD = new ByteArrayInputStream(var2);
      this.gameAE = new DataInputStream(this.gameAD);
   }

   public final byte[] gameAA() {
      return this.gameAB.toByteArray();
   }

   public final DataInputStream gameAB() {
      return this.gameAE;
   }

   public final DataOutputStream gameAC() {
      return this.gameAC;
   }

   public final void gameAD() {
      try {
         if (this.gameAE != null) {
            this.gameAE.close();
         }

         if (this.gameAC != null) {
            this.gameAC.close();
         }

      } catch (IOException var1) {
      }
   }
}
