public final class Readmsg {
   public final void gameAA(Message var1) {
      try {
         switch (var1.reader().readByte()) {
            case 0:
               Message var20 = var1;

               try {
                  Message var22x = null;
                  int var22xx = var20.reader().readInt();
                  Char var23x;
                  if (Char.getMyChar().charID == var22xx) {
                     var23x = Char.getMyChar();
                  } else {
                     var23x = GameScr.gameAE(var22xx);
                  }

                  if (var23x != null) {
                     var23x.arrItemViThu = new Item[5];

                     for (int var25 = 0; var25 < var23x.arrItemViThu.length; var25++) {
                        short var27;
                        if ((var27 = var20.reader().readShort()) > -1) {
                           var23x.arrItemViThu[var25] = new Item();
                           var23x.arrItemViThu[var25].indexUI = var25;
                           var23x.arrItemViThu[var25].typeUI = 51;
                           var23x.arrItemViThu[var25].template = ItemTemplates.gameAA(var27);
                           var23x.arrItemViThu[var25].upgrade = var20.reader().readByte();
                           var23x.arrItemViThu[var25].expires = var20.reader().readLong();
                           var23x.arrItemViThu[var25].sys = var20.reader().readByte();
                           byte var28 = var20.reader().readByte();
                           var23x.arrItemViThu[var25].options = new MyVector();

                           for (int var30 = 0; var30 < var28; var30++) {
                              var23x.arrItemViThu[var25].options.addElement(new ItemOption(var20.reader().readUnsignedByte(), var20.reader().readInt()));
                           }
                        }
                     }
                  }
                  break;
               } catch (Exception var17) {
                  return;
               }
            case 1:
               Message var20x = var1;

               try {
                  Message var211 = null;
                  int var22 = var20x.reader().readInt();
                  Char var23;
                  if (Char.getMyChar().charID == var22) {
                     var23 = Char.getMyChar();
                  } else {
                     var23 = GameScr.gameAE(var22);
                  }

                  if (var23 != null) {
                     short var24 = var20x.reader().readShort();
                     byte var26 = var20x.reader().readByte();
                     if (var24 > 0) {
                        short var5 = (short)var23.cx;
                        short var29 = (short)(var23.cy - 40);
                        var23.mobVithu = new Mob(
                           (short)-1, false, false, false, false, false, var24, 1, 0, 0, 0, var5, var29, (byte)4, (byte)0, var26 != 0, false
                        );
                        var23.mobVithu.status = 5;
                     } else {
                        var23.mobVithu = null;
                     }
                  }
                  break;
               } catch (Exception var16) {
                  var16.printStackTrace();
                  return;
               }
            case 2:
               var1 = var1;

               try {
                  short var2 = var1.reader().readShort();
                  String var3 = var1.reader().readUTF();
                  int var4 = var1.reader().readInt();
                  short var5 = var1.reader().readShort();
                  byte var6 = var1.reader().readByte();
                  if (var4 >= 0) {
                     short var21x = var2;
                     int var13 = 0;

                     CharCountDown var10000;
                     while (true) {
                        if (var13 >= GameScr.gameAX.size()) {
                           var10000 = null;
                           break;
                        }

                        CharCountDown var14;
                        if ((var14 = (CharCountDown)GameScr.gameAX.elementAt(var13)) != null && var14.gameAD == var21x) {
                           var10000 = var14;
                           break;
                        }

                        var13++;
                     }

                     CharCountDown var19x = var10000;
                     if (var10000 == null) {
                        var19x = new CharCountDown(var2, var5, var4, var3, var6);
                        GameScr.gameAX.addElement(var19x);
                     }

                     if (var19x != null) {
                        var19x.gameAB = var3;
                        var19x.gameAE = var5;
                        long var31 = var4;
                        var19x.gameAA = System.currentTimeMillis() + var31 * 1000L;
                        if (var6 == -2) {
                           var19x.WantDestroy = true;
                           break;
                        }
                     }
                  }
               } catch (Exception var18) {
               }

               return;
            default:
               return;
         }
      } catch (Exception var191) {
      }
   }
}
