import java.io.IOException;

public final class MessageCollector implements Runnable {
   private Session_ME gameAA;

   MessageCollector(Session_ME var1) {
      this.gameAA = var1;
   }

   public final void run() {
      try {
         while(this.gameAA.gameAF) {
            byte var1 = this.gameAA.gameAC.readByte();
            if (Session_ME.gameAG(this.gameAA)) {
               var1 = Session_ME.gameAA(this.gameAA, var1);
            }

            byte var2;
            byte var3;
            int var8;
            if (var1 == -32) {
               var1 = this.gameAA.gameAC.readByte();
               if (Session_ME.gameAG(this.gameAA)) {
                  var1 = Session_ME.gameAA(this.gameAA, var1);
               }

               var2 = Session_ME.gameAA(this.gameAA, this.gameAA.gameAC.readByte());
               var3 = Session_ME.gameAA(this.gameAA, this.gameAA.gameAC.readByte());
               byte var4 = Session_ME.gameAA(this.gameAA, this.gameAA.gameAC.readByte());
               byte var5 = Session_ME.gameAA(this.gameAA, this.gameAA.gameAC.readByte());
               var8 = (var2 & 255) << 24 | (var3 & 255) << 16 | (var4 & 255) << 8 | var5 & 255;
            } else if (Session_ME.gameAG(this.gameAA)) {
               var2 = this.gameAA.gameAC.readByte();
               var3 = this.gameAA.gameAC.readByte();
               var8 = (Session_ME.gameAA(this.gameAA, var2) & 255) << 8 | Session_ME.gameAA(this.gameAA, var3) & 255;
            } else {
               var8 = this.gameAA.gameAC.readUnsignedShort();
            }

            byte[] var11 = new byte[var8];
            int var12 = 0;
            int var10 = 0;

            int var6;
            while(var10 != -1 && var12 < var8) {
               if ((var10 = this.gameAA.gameAC.read(var11, var12, var8 - var12)) > 0) {
                  var12 += var10;
                  Session_ME var10000 = this.gameAA;
                  var10000.gameAI += var12 + 5;
                  var6 = this.gameAA.gameAI + this.gameAA.gameAH;
                  this.gameAA.gameAL = var6 / 1024 + "." + var6 % 1024 / 102 + "Kb";
               }
            }

            if (Session_ME.gameAG(this.gameAA)) {
               for(var6 = 0; var6 < var11.length; ++var6) {
                  var11[var6] = Session_ME.gameAA(this.gameAA, var11[var6]);
               }
            }

            this.gameAA.gameAJ = System.currentTimeMillis();
            Message var9;
            if ((var9 = new Message(var1, var11)).gameAA == -27) {
               this.gameAA(var9);
            } else {
               this.gameAA.gameAD.gameAA(var9);
            }
         }

      } catch (Exception var7) {
         if (this.gameAA.gameAF) {
            if (this.gameAA.gameAE != null) {
               this.gameAA.gameAC();
            }

            if (this.gameAA.gameAD != null) {
               if (System.currentTimeMillis() - Session_ME.gameAH(this.gameAA) > 500L) {
                  this.gameAA.gameAD.onDisconnected();
                  return;
               }

               this.gameAA.gameAD.gameAA();
            }
         }

      }
   }

   private void gameAA(Message var1) {
      try {
         byte var2 = var1.gameAB().readByte();
         this.gameAA.gameAK = new byte[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.gameAA.gameAK[var3] = var1.gameAB().readByte();
         }

         for(var3 = 0; var3 < this.gameAA.gameAK.length - 1; ++var3) {
            byte[] var10000 = this.gameAA.gameAK;
            var10000[var3 + 1] ^= this.gameAA.gameAK[var3];
         }

         Session_ME.gameAI(this.gameAA);
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }
}
