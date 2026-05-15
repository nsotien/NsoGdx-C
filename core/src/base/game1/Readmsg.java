package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Readmsg {

   public final void a(Message var1) {
      try {
         int var2;
         short var5;
         int var6;
         Message var20;
         Char var22;
         int var23;
         short var24;
         switch (var1.b().readByte()) {
            case 0:
               var20 = var1;

               try {
                  var1 = null;
                  var2 = var20.b().readInt();
                  if (Char.getMyChar().idChar == var2) {
                     var22 = Char.getMyChar();
                  } else {
                     var22 = GameScr.e(var2);
                  }

                  if (var22 != null) {
                     var22.cf = new Item[5];

                     for(var23 = 0; var23 < var22.cf.length; ++var23) {
                        if ((var24 = var20.b().readShort()) > -1) {
                           var22.cf[var23] = new Item();
                           var22.cf[var23].indexUI = var23;
                           var22.cf[var23].typeUI = 51;
                           var22.cf[var23].template = ItemTemplates.a(var24);
                           var22.cf[var23].upgrade = var20.b().readByte();
                           var22.cf[var23].expires = var20.b().readLong();
                           var22.cf[var23].sys = var20.b().readByte();
                           byte var25 = var20.b().readByte();
                           var22.cf[var23].options = new MyVector();

                           for(var6 = 0; var6 < var25; ++var6) {
                              var22.cf[var23].options.addElement(new ItemOption(var20.b().readUnsignedByte(), var20.b().readInt()));
                           }
                        }
                     }
                  }
                  break;
               } catch (Exception var18) {
                  return;
               }
            case 1:
               var20 = var1;

               try {
                  var1 = null;
                  var2 = var20.b().readInt();
                  if (Char.getMyChar().idChar == var2) {
                     var22 = Char.getMyChar();
                  } else {
                     var22 = GameScr.e(var2);
                  }

                  if (var22 != null) {
                     var23 = var20.b().readShort();
                     var24 = (short)var20.b().readByte();
                     if (var23 > 0) {
                        var5 = (short)var22.cx1;
                        var6 = (short)(var22.cy1 - 40);
                        var22.mobVithu = new Mob((short)-1, false, false, false, false, false, var23, 1, 0, 0, 0, var5, (short)var6, (byte)4, (byte)0, var24 != 0, false);
                        var22.mobVithu.status = 5;
                     } else {
                        var22.mobVithu = null;
                     }
                  }
                  break;
               } catch (Exception var17) {
                  ;
                  return;
               }
            case 2:
               var1 = var1;

               try {
                  var2 = var1.b().readShort();
                  String var3 = var1.b().readUTF();
                  int var4 = var1.b().readInt();
                  var5 = var1.b().readShort();
                  var6 = var1.b().readByte();
                  if (var4 >= 0) {
                     short var21 = (short)var2;
                     int var13 = 0;

                     Class_es var10000;
                     Class_es var19;
                     while(true) {
                        if (var13 >= GameScr.x.size()) {
                           var10000 = null;
                           break;
                        }

                        if ((var19 = (Class_es)GameScr.x.elementAt(var13)) != null && var19.d == var21) {
                           var10000 = var19;
                           break;
                        }

                        ++var13;
                     }

                     var19 = var10000;
                     if (var10000 == null) {
                        var19 = new Class_es((short)var2, var5, (long)var4, var3, (byte)var6);
                        GameScr.x.addElement(var19);
                     }

                     if (var19 != null) {
                        var19.b = var3;
                        var19.e = var5;
                        long var26 = (long)var4;
                        var19.a = System.currentTimeMillis() + var26 * 1000L;
                        if (var6 == -2) {
                           var19.c = true;
                           break;
                        }
                     }
                  }
               } catch (Exception var19) {
               }

               return;
            default:
               return;
         }
      } catch (Exception var20) {
      }

   }

}
