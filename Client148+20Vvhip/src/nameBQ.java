public final class nameBQ {
   public final void gameAA(Message var1) {
      try {
         int var2;
         Char var10;
         switch(var1.gameAB().readByte()) {
         case 0:
            var1 = var1;

            try {
               var2 = var1.gameAB().readInt();
               if ((var10 = Char.getMyChar().charID != var2 ? GameScr.gameAE(var2) : Char.getMyChar()) == null) {
                  break;
               }

               var10.arrItemViThu = new Item[5];

               for(int var11 = 0; var11 < var10.arrItemViThu.length; ++var11) {
                  short var12;
                  if ((var12 = var1.gameAB().readShort()) >= 0) {
                     var10.arrItemViThu[var11] = new Item();
                     var10.arrItemViThu[var11].indexUI = var11;
                     var10.arrItemViThu[var11].typeUI = 51;
                     var10.arrItemViThu[var11].template = ItemTemplates.gameAA(var12);
                     var10.arrItemViThu[var11].upgrade = var1.gameAB().readByte();
                     var10.arrItemViThu[var11].expires = var1.gameAB().readLong();
                     var10.arrItemViThu[var11].sys = var1.gameAB().readByte();
                     byte var13 = var1.gameAB().readByte();
                     var10.arrItemViThu[var11].options = new MyVector();

                     for(int var14 = 0; var14 < var13; ++var14) {
                        var10.arrItemViThu[var11].options.addElement(new ItemOption(var1.gameAB().readUnsignedByte(), var1.gameAB().readInt()));
                     }
                  }
               }

               return;
            } catch (Exception var8) {
               return;
            }
         case 1:
            var1 = var1;

            try {
               var2 = var1.gameAB().readInt();
               if ((var10 = Char.getMyChar().charID != var2 ? GameScr.gameAE(var2) : Char.getMyChar()) == null) {
                  return;
               }

               short var3 = var1.gameAB().readShort();
               byte var4 = var1.gameAB().readByte();
               if (var3 <= 0) {
                  var10.mobVithu = null;
                  return;
               }

               short var5 = (short)var10.cx;
               short var6 = (short)(var10.cy - 40);
               var10.mobVithu = new Mob((short)-1, false, false, false, false, false, var3, 1, 0, 0, 0, var5, var6, (byte)4, (byte)0, var4 != 0, false);
               var10.mobVithu.status = 5;
            } catch (Exception var7) {
            }
         }

      } catch (Exception var9) {
      }
   }
}
