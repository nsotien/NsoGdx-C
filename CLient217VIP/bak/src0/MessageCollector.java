import java.io.IOException;

final class MessageCollector implements Runnable {
   private Session_ME instance;

   MessageCollector(Session_ME var1) {
      this.instance = var1;
   }

   public final void run() {
      while (true) {
         try {
            if (this.instance.gameAB()) {
               MessageCollector var10 = this;
               byte var2 = this.instance.dis.readByte();
               if (this.instance.getKeyComplete) {
                  var2 = Session_ME.gameAA(this.instance, var2);
               }

               int var3;
               if (var2 == -32) {
                  var2 = this.instance.dis.readByte();
                  if (this.instance.getKeyComplete) {
                     var2 = Session_ME.gameAA(this.instance, var2);
                  }

                  byte var4 = Session_ME.gameAA(this.instance, this.instance.dis.readByte());
                  byte var5 = Session_ME.gameAA(this.instance, this.instance.dis.readByte());
                  byte var6 = Session_ME.gameAA(this.instance, this.instance.dis.readByte());
                  byte var7 = Session_ME.gameAA(this.instance, this.instance.dis.readByte());
                  var3 = (var4 & 255) << 24 | (var5 & 255) << 16 | (var6 & 255) << 8 | var7 & 255;
               } else if (this.instance.getKeyComplete) {
                  byte var4 = this.instance.dis.readByte();
                  byte var5 = this.instance.dis.readByte();
                  var3 = (Session_ME.gameAA(this.instance, var4) & 255) << 8 | Session_ME.gameAA(this.instance, var5) & 255;
               } else {
                  var3 = this.instance.dis.readUnsignedShort();
               }

               byte[] var12 = new byte[var3];
               int var13 = 0;
               int var14 = 0;

               while (var13 != -1 && var14 < var3) {
                  if ((var13 = var10.instance.dis.read(var12, var14, var3 - var14)) > 0) {
                     var14 += var13;
                     Session_ME var10000 = var10.instance;
                     var10000.recvByteCount += var14 + 5;
                     int var15x = Session_ME.gI().recvByteCount + Session_ME.gI().sendByteCount;
                     var10.instance.gameAO = var15x / 1024 + "." + var15x % 1024 / 102 + "Kb";
                  }
               }

               if (var10.instance.getKeyComplete) {
                  for (int var15x = 0; var15x < var12.length; var15x++) {
                     var12[var15x] = Session_ME.gameAA(var10.instance, var12[var15x]);
                  }
               }

               Message var11 = new Message(var2, var12);
               long now = System.currentTimeMillis();
               if (this.instance.lastRecvTs > 0L) {
                  this.instance.pingMs = (int)(now - this.instance.lastRecvTs);
               }

               this.instance.lastRecvTs = now;

               try {
                  if (var11.command == -27) {
                     this.gameAA(var11);
                     continue;
                  }

                  this.instance.messageHandler.gameAA(var11);
               } catch (Exception var14x) {
                  var14x.printStackTrace();
               }
               continue;
            }
         } catch (Exception var151) {
         }

         if (this.instance.connected) {
            if (this.instance.messageHandler != null) {
               if (System.currentTimeMillis() - this.instance.gameAN > 500L) {
                  Controller var1 = this.instance.messageHandler;
                  var1.fieldAD();
               } else {
                  this.instance.messageHandler.gameAB();
               }
            }

            if (this.instance.fieldAE != null) {
               Session_ME.gameAC(this.instance);
            }
         }

         return;
      }
   }

   private void gameAA(Message var1) {
      try {
         byte var2 = var1.reader().readByte();
         this.instance.key = new byte[var2];

         for (int var3 = 0; var3 < var2; var3++) {
            this.instance.key[var3] = var1.reader().readByte();
         }

         for (int var6 = 0; var6 < this.instance.key.length - 1; var6++) {
            byte[] var10000 = this.instance.key;
            var10000[var6 + 1] = (byte)(var10000[var6 + 1] ^ this.instance.key[var6]);
         }

         this.instance.getKeyComplete = true;
      } catch (IOException var5) {
         var5.printStackTrace();
      }
   }
}
