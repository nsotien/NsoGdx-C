import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Image;

public final class Controller {
   private static Controller me;
   private Message messWait;
   private static String[] fieldAC = new String[]{"Bạn chỉ có thể vào lại game sau ", " giây nữa"};
   private static String fieldAD = "Bạn chưa thể đi đến khu vực này.Hãy hoàn thành nhiệm vụ trước.";
   private static String fieldAE = "Cửa này vẫn chưa được mở.";
   private static String fieldAF = "Cửa này chỉ chứa được tối đa 2 người.";
   private static String fieldAG = "Số nhóm của khu vực này";
   private static String fieldAH = "Khu vực này đã đầy.";
   private static String fieldAI = "Thao tác quá nhanh.";
   private static boolean autoLoginRetrying;

   private static int[] ensureLen(int[] a, int min) {
      if (a == null) {
         return new int[min];
      } else if (a.length >= min) {
         return a;
      } else {
         int[] b = new int[min];
         int last = a.length > 0 ? a[a.length - 1] : 0;

         for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
         }

         for (int i = a.length; i < b.length; i++) {
            b[i] = last;
         }

         return b;
      }
   }

   public final void fieldAB() {
      System.out.println("Connect ok");
   }

   public static Controller gI() {
      if (me == null) {
         me = new Controller();
      }

      return me;
   }

   public final void gameAB() {
      Session_ME.gI().fieldAD();
   }

   public final void fieldAD() {
      System.out.println("Disconnected");
      Code.fieldAB();
      if (Code.fieldAB instanceof Stanima && Res.fieldAB().get(11) == 3) {
         Stanima.fieldAY = true;
      }

      Session_ME.gI().fieldAD();
   }

   private static void gameAB(Message var0) {
      try {
         int var1 = var0.reader().readUnsignedByte();
         Item var4;
         (var4 = GameScr.currentCharViewInfo.arrItemBody[var1]).expires = var0.reader().readLong();
         var4.saleCoinLock = var0.reader().readInt();
         var4.sys = var0.reader().readByte();
         var4.options = new MyVector();

         try {
            while (true) {
               var4.options.addElement(new ItemOption(var0.reader().readUnsignedByte(), var0.reader().readInt()));
            }
         } catch (Exception var4x) {
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }
   }

   private static void gameAC(Message var0) {
      try {
         Item var1 = null;
         int var2 = var0.reader().readInt();

         for (int var3 = 0; var3 < GameScr.arrItemStands.length; var3++) {
            if (GameScr.arrItemStands[var3].item.itemId == var2) {
               var1 = GameScr.arrItemStands[var3].item;
               break;
            }
         }

         var1.typeUI = 37;
         var1.expires = -1L;
         var1.saleCoinLock = var0.reader().readInt();
         if (var1.isTypeBody() || var1.isTypeNgocKham()) {
            var1.options = new MyVector();

            try {
               var1.upgrade = var0.reader().readByte();
               var1.sys = var0.reader().readByte();

               while (true) {
                  var1.options.addElement(new ItemOption(var0.reader().readUnsignedByte(), var0.reader().readInt()));
               }
            } catch (Exception var41) {
               return;
            }
         }
      } catch (Exception var51) {
         var51.printStackTrace();
      }
   }

   public final void gameAA(Message fieldAB) {
      try {
         try {
            switch (fieldAB.command) {
               case -30:
                  this.gameAG(fieldAB);
                  return;
               case -29:
                  gameAF(fieldAB);
                  return;
               case -28:
                  this.gameAE(fieldAB);
                  break;
               case -27:
               case -17:
               case -9:
               case 12:
               case 24:
               case 28:
               case 29:
               case 32:
               case 35:
               case 41:
               case 44:
               case 56:
               case 73:
               case 74:
               case 80:
               case 81:
               case 105:
               case 110:
               case 111:
               case 113:
               case 115:
               case 120:
               default:
                  return;
               case -26:
                  String utf;
                  GameCanvas.setText(utf = fieldAB.reader().readUTF());
                  boolean equals = false;
                  boolean equals2 = false;
                  if (utf.startsWith(fieldAC[0])) {
                     int int1 = 0;

                     try {
                        int1 = Integer.parseInt(utf.substring(fieldAC[0].length(), utf.indexOf(fieldAC[1])).trim());
                     } catch (Exception var165) {
                        var165.printStackTrace();
                     }

                     Session_ME.gI().gameAC();
                     Session_ME.gameAP = false;
                     Session_ME.fieldAE();
                     GameCanvas.fieldBV = int1;
                     GameCanvas.fieldBX = GameCanvas.fieldBW = System.currentTimeMillis();
                     return;
                  } else {
                     if (utf.equals(Controller.fieldAI)) {
                        LockGame.fieldAR();
                     } else if (TileMap.fieldBF
                        && (
                           utf.equals(fieldAD)
                              || (equals = utf.equals(fieldAE))
                              || (equals2 = utf.equals(fieldAF))
                              || utf.equals(Controller.fieldAH)
                              || utf.startsWith(fieldAG)
                        )) {
                        if (Code.fieldAB != null && TileMap.isHang(TileMap.mapID)) {
                           if (equals) {
                              int fieldAI;
                              if ((fieldAI = TileMap.fieldAI(Code.fieldAB.fieldAB)) > 0) {
                                 Code.fieldAB.fieldAB = fieldAI;
                              }

                              Code.fieldAB.fieldAE = -1;
                           } else if (equals2) {
                              int fieldAH;
                              if ((fieldAH = TileMap.fieldAH(Code.fieldAB.fieldAB)) > 0) {
                                 Code.fieldAB.fieldAB = fieldAH;
                              }

                              Code.fieldAB.fieldAE = -1;
                           }
                        }

                        if (TileMap.fieldBE) {
                           TileMap.fieldBE = false;
                        } else {
                           GameCanvas.gameAJ();
                        }

                        TileMap.fieldAG();
                        return;
                     }

                     return;
                  }
               case -25: {
                  String var188;
                  Info.gameAA(var188 = fieldAB.reader().readUTF(), 150, mFont.tahoma_7b_yellow);
                  ChatManager.gameAD().gameAA(mResources.gameTK[0], mResources.gameVO, var188);
                  if (Code.fieldAB instanceof Stanima) {
                     Code.fieldAC.fieldAA(var188);
                  }

                  if (Code.fieldAB instanceof ChoBoss) {
                     ((ChoBoss)Code.fieldAB).fieldAA(var188);
                  }

                  return;
               }
               case -24:
                  String utf3;
                  if ((utf3 = fieldAB.reader().readUTF()).indexOf("đang đứng nhìn bạn") > 0) {
                     Code.fieldAG(utf3.substring(0, utf3.indexOf("đang đứng nhìn bạn")).trim());
                  } else if (Char.fieldEZ && Code.fieldAB != null && utf3.equals("Không đủ MP để sử dụng")) {
                     Auto.fieldAM = true;
                  } else if (LockGame.fieldAB && utf3.equals("Vật phẩm của người khác")) {
                     LockGame.fieldAD();
                     ItemMap fieldDQ;
                     if ((fieldDQ = Char.getMyChar().itemFocus) != null) {
                        fieldDQ.fieldAK = true;
                     }
                  } else if (Code.fieldAB instanceof Stanima) {
                     if (Code.fieldAC.fieldAV == 2 && utf3.equals("Cửa hang động đã được khép lại.")) {
                        Stanima.fieldAY = true;
                     } else if (Code.fieldAC.fieldAV == 4 && utf3.equals("Chiến trường đã khép lại, xem kết quả tại Npc Rikudou.")) {
                        TileMap.fieldAG();
                     }
                  } else if (Code.fieldAH != null && !Code.fieldAH.equals(Char.getMyChar().cName) && utf3.equals("Đối phương đang ở trong nhóm khác.")) {
                     Service.gI().outParty();
                  }

                  InfoMe.gameAA(utf3, 50, mFont.tahoma_7_yellow);
                  return;
               case -23:
                  int int2 = fieldAB.reader().readInt();
                  String utf4 = fieldAB.reader().readUTF();
                  Char char1;
                  if (Char.getMyChar().charID == int2) {
                     char1 = Char.getMyChar();
                  } else {
                     char1 = GameScr.gameAE(int2);
                  }

                  if (char1 != null) {
                     ChatPopup.addChatPopup(utf4, 100, char1);
                     ChatManager.gameAD().gameAA(mResources.gameTI[0], char1.cName, utf4);
                     return;
                  }

                  return;
               case -22: {
                  String var221 = fieldAB.reader().readUTF();
                  String var188 = fieldAB.reader().readUTF();
                  ChatManager.gameAD().gameAA(var221, var221, var188);
                  if ((!GameScr.isPaintMessage || !ChatManager.gameAD().gameAE().ownerName.equals(var221)) && !ChatManager.blockPrivateChat) {
                     ChatManager.gameAD().gameAC(var221);
                  }

                  Code.fieldAA.fieldAB(var221, var188);
                  return;
               }
               case -21: {
                  String var220 = fieldAB.reader().readUTF();
                  String var206 = fieldAB.reader().readUTF();
                  ChatManager.gameAD().gameAA(mResources.gameTK[0], var220, var206);
                  if (!ChatManager.blockGlobalChat) {
                     Info.gameAA(var220 + ": " + var206, 80, mFont.tahoma_7b_yellow);
                  }

                  return;
               }
               case -20:
                  String var5 = fieldAB.reader().readUTF();
                  String var221 = fieldAB.reader().readUTF();
                  ChatManager.gameAD().gameAA(mResources.gameTJ[0], var5, var221);
                  if (!GameScr.isPaintMessage || ChatManager.gameAD().gameAE().type != 1) {
                     ChatManager.gameAD();
                     ChatManager.isMessagePt = true;
                  }

                  Code.fieldAD(var5, var221);
                  return;
               case -19: {
                  String var188 = fieldAB.reader().readUTF();
                  String var191 = fieldAB.reader().readUTF();
                  ChatManager.gameAD().gameAA(mResources.gameTL[0], var188, var191);
                  if (!GameScr.isPaintMessage || ChatManager.gameAD().gameAE().type != 4) {
                     ChatManager.isMessageClan = true;
                  }

                  return;
               }
               case -18:
                  GameCanvas.isLoading = true;
                  GameScr.setPasswordTest();
                  TileMap.vGo.removeAllElements();
                  System.gc();
                  TileMap.mapID = (short)fieldAB.reader().readUnsignedByte();
                  TileMap.tileID = fieldAB.reader().readByte();
                  TileMap.bgID = fieldAB.reader().readByte();
                  TileMap.typeMap = fieldAB.reader().readByte();
                  TileMap.mapName = fieldAB.reader().readUTF();
                  TileMap.zoneID = fieldAB.reader().readByte();
                  TileMap.gameAF();

                  try {
                     TileMap.gameAE();
                  } catch (Exception var173) {
                     Service.gI().requestMaptemplate(TileMap.mapID);
                     this.messWait = fieldAB;
                     return;
                  }

                  this.gameAD(fieldAB);
                  if (Char.getMyChar().mobMe != null) {
                     Char.getMyChar().mobMe.x = Char.getMyChar().cx;
                     Char.getMyChar().mobMe.y = Char.getMyChar().cy - 40;
                  }

                  return;
               case -16:
                  Char.isLockKey = true;
                  Char.ischangingMap = true;
                  Mob.vEggMonter.removeAllElements();
                  GameScr.gI().timeStartMap = 0;
                  GameScr.gI().timeLengthMap = 0;
                  Char.getMyChar().mobFocus = null;
                  Char.getMyChar().npcFocus = null;
                  Char.getMyChar().charFocus = null;
                  Char.getMyChar().itemFocus = null;
                  Char.getMyChar().focus.removeAllElements();
                  Char.getMyChar().testCharId = -9999;
                  Char.getMyChar().killCharId = -9999;
                  GameScr.setPasswordTest();
                  GameCanvas.setPasswordTest();
                  if (GameScr.vParty.size() <= 1) {
                     GameScr.vParty.removeAllElements();
                  }

                  GameScr.gI().resetButton();
                  GameScr.gI().center = null;
                  return;
               case -15:
                  short var232 = fieldAB.reader().readShort();

                  for (int var234x = 0; var234x < GameScr.vItemMap.size(); var234x++) {
                     if (((ItemMap)GameScr.vItemMap.elementAt(var234x)).itemMapID == var232) {
                        GameScr.vItemMap.removeElementAt(var234x);
                        return;
                     }
                  }

                  return;
               case -14:
                  Char.getMyChar().itemFocus = null;
                  var232 = fieldAB.reader().readShort();

                  for (int var234 = 0; var234 < GameScr.vItemMap.size(); var234++) {
                     ItemMap var236;
                     if ((var236 = (ItemMap)GameScr.vItemMap.elementAt(var234)).itemMapID == var232) {
                        var236.gameAA(Char.getMyChar().cx, Char.getMyChar().cy - 10);
                        var236.fieldAK = true;
                        if (var236.template.type == 19) {
                           int var237 = fieldAB.reader().readUnsignedShort();
                           Char var10000 = Char.getMyChar();
                           var10000.yen += var237;
                           if (var236.template.id == 238) {
                              return;
                           }

                           InfoMe.gameAA(mResources.gamePM + " " + var237 + " " + mResources.gamePB);
                           return;
                        }

                        if (var236.template.type != 25 || var236.template.id == 238) {
                           return;
                        }

                        InfoMe.gameAA(mResources.gamePM + " " + var236.template.name, 15, mFont.tahoma_7_yellow);
                        return;
                     }
                  }

                  LockGame.fieldAD();
                  return;
               case -13:
                  var232 = fieldAB.reader().readShort();

                  for (int var234xx = 0; var234xx < GameScr.vItemMap.size(); var234xx++) {
                     ItemMap var236;
                     if ((var236 = (ItemMap)GameScr.vItemMap.elementAt(var234xx)).itemMapID == var232) {
                        Char var9xxxx;
                        if ((var9xxxx = GameScr.gameAE(fieldAB.reader().readInt())) == null) {
                           return;
                        }

                        var236.gameAA(var9xxxx.cx, var9xxxx.cy - 10);
                        if (var236.x < var9xxxx.cx) {
                           var9xxxx.cdir = -1;
                        } else if (var236.x > var9xxxx.cx) {
                           var9xxxx.cdir = 1;
                           return;
                        }

                        if (var236 == Char.getMyChar().itemFocus) {
                           var236.fieldAK = true;
                           LockGame.fieldAD();
                        }

                        return;
                     }
                  }

                  return;
               case -12: {
                  byte var210 = fieldAB.reader().readByte();
                  GameScr.vItemMap
                     .addElement(
                        new ItemMap(
                           fieldAB.reader().readShort(),
                           Char.getMyChar().arrItemBag[var210].template.id,
                           Char.getMyChar().cx,
                           Char.getMyChar().cy,
                           fieldAB.reader().readShort(),
                           fieldAB.reader().readShort()
                        )
                     );
                  Char.getMyChar().arrItemBag[var210] = null;
                  return;
               }
               case -11:
                  Char.getMyChar().cPk = fieldAB.reader().readByte();
                  Char.getMyChar().gameAA(fieldAB.reader().readShort(), fieldAB.reader().readShort());

                  try {
                     Char.getMyChar().cEXP = fieldAB.reader().readLong();
                     GameScr.gameAA(Char.getMyChar().cEXP, true);
                  } catch (Exception var164) {
                  }

                  Char.getMyChar().countKill = 0;
                  return;
               case -10:
                  if (Char.getMyChar().wdx != 0 || Char.getMyChar().wdy != 0) {
                     Char.getMyChar().cx = Char.getMyChar().wdx;
                     Char.getMyChar().cy = Char.getMyChar().wdy;
                     Char.getMyChar().wdx = Char.getMyChar().wdy = 0;
                  }

                  Char.getMyChar().gameAX();
                  Char.isLockKey = false;
                  return;
               case -8: {
                  int var245 = fieldAB.reader().readInt();
                  Char var10000 = Char.getMyChar();
                  var10000.yen += var245;
                  GameScr.gI().yenTemp = var245;
                  GameScr.gameAA(var245 > 0 ? "+" + var245 : "" + var245, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 1);
                  return;
               }
               case -7: {
                  int var86 = fieldAB.reader().readInt();
                  Char var10000 = Char.getMyChar();
                  var10000.xu += var86;
                  var10000 = Char.getMyChar();
                  var10000.yen -= var86;
                  GameScr.gameAA("+" + var86, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 1);
                  return;
               }
               case -6:
                  Char var9xxxx;
                  if ((var9xxxx = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     GameScr.vItemMap
                        .addElement(
                           new ItemMap(
                              fieldAB.reader().readShort(),
                              fieldAB.reader().readShort(),
                              var9xxxx.cx,
                              var9xxxx.cy,
                              fieldAB.reader().readShort(),
                              fieldAB.reader().readShort()
                           )
                        );
                     return;
                  }

                  return;
               case -5:
                  try {
                     Mob var92;
                     (var92 = Mob.gameAA(fieldAB.reader().readUnsignedByte())).sys = fieldAB.reader().readByte();
                     var92.levelBoss = fieldAB.reader().readByte();
                     var92.x = var92.xFirst;
                     var92.y = var92.yFirst;
                     var92.status = 5;
                     var92.injureThenDie = false;
                     var92.hp = fieldAB.reader().readInt();
                     var92.maxHp = var92.hp;
                     if (var92.getTemplate().mobTemplateId == 202) {
                        ServerEffect.gameAA(148, var92.x, var92.y, 0);
                     } else {
                        ServerEffect.gameAA(60, var92.x, var92.y, 1);
                     }

                     Auto.fieldAA(var92);
                  } catch (Exception var163) {
                     var163.printStackTrace();
                  }

                  return;
               case -4:
                  Mob var92 = null;

                  try {
                     var92 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                  } catch (Exception var162) {
                  }

                  if (var92 != null && var92.status != 0 && var92.status != 0) {
                     var92.gameAF();

                     try {
                        int var252x;
                        if ((var252x = fieldAB.reader().readInt()) < 0) {
                           var252x = Res.abs(var252x) + 32767;
                        }

                        if (fieldAB.reader().readBoolean()) {
                           GameScr.gameAA("-" + var252x, var92.x, var92.y - var92.h, 0, -2, 3);
                        } else {
                           GameScr.gameAA("-" + var252x, var92.x, var92.y - var92.h, 0, -2, 5);
                        }

                        ItemMap var253 = new ItemMap(
                           fieldAB.reader().readShort(),
                           fieldAB.reader().readShort(),
                           var92.x,
                           var92.y,
                           fieldAB.reader().readShort(),
                           fieldAB.reader().readShort()
                        );
                        GameScr.vItemMap.addElement(var253);
                        if (Res.abs(var253.y - Char.getMyChar().cy) < 24 && Res.abs(var253.x - Char.getMyChar().cx) < 24) {
                           Char.getMyChar().charFocus = null;
                           return;
                        }
                     } catch (Exception var161) {
                     }

                     return;
                  }

                  return;
               case -3:
                  Mob varmob92 = null;

                  try {
                     varmob92 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                  } catch (Exception var160) {
                     System.out.println("----err null:NPC_ATTACK_ME");
                  }

                  if (varmob92 != null) {
                     int var252x = fieldAB.reader().readInt();

                     int var250;
                     try {
                        var250 = fieldAB.reader().readInt();
                     } catch (Exception var159) {
                        var250 = 0;
                     }

                     if (varmob92.isBusyAttackSomeOne) {
                        Char.getMyChar().gameAA(var252x, var250, false, -1);
                        varmob92.gameAG();
                     } else {
                        varmob92.dame = var252x;
                        varmob92.dameMp = var250;
                        varmob92.gameAA(Char.getMyChar());
                     }

                     short var190 = fieldAB.reader().readShort();
                     byte var194x = fieldAB.reader().readByte();
                     byte var185xxx = fieldAB.reader().readByte();
                     varmob92.gameAA(var190, var194x, var185xxx);
                     if (Char.getMyChar().cHP < Char.getMyChar().cMaxHP / 2) {
                        if (varmob92.isBoss) {
                           System.out.println("Bi Quai TG Danh");
                           return;
                        } else {
                           if (varmob92.levelBoss == 1) {
                              System.out.println("Bi TA Danh");
                           } else if (varmob92.levelBoss == 2) {
                              System.out.println("Bi TL Danh");
                              return;
                           }

                           return;
                        }
                     }
                  }

                  return;
               case -2:
                  Mob varmob922 = null;

                  try {
                     varmob922 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                  } catch (Exception var158) {
                  }

                  if (varmob922 == null) {
                     return;
                  }

                  Char varchar9x;
                  if ((varchar9x = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     int var250x = fieldAB.reader().readInt();
                     varmob922.dame = varchar9x.cHP - var250x;
                     varchar9x.cHpNew = var250x;

                     try {
                        varchar9x.cMP = fieldAB.reader().readInt();
                     } catch (Exception var157) {
                     }

                     if (varmob922.isBusyAttackSomeOne) {
                        varchar9x.gameAA(varmob922.dame, 0, false, -1);
                        varmob922.gameAG();
                     } else {
                        varmob922.gameAA(varchar9x);
                     }

                     short var190 = fieldAB.reader().readShort();
                     byte var194x = fieldAB.reader().readByte();
                     byte var185xxxx = fieldAB.reader().readByte();
                     varmob922.gameAA(var190, var194x, var185xxxx);
                     return;
                  }

                  return;
               case -1:
                  Mob varmob9222 = null;

                  try {
                     varmob9222 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                  } catch (Exception var156) {
                  }

                  if (varmob9222 != null) {
                     varmob9222.hp = fieldAB.reader().readInt();
                     int var252;
                     if ((var252 = fieldAB.reader().readInt()) < 0) {
                        var252 = Res.abs(var252) + 32767;
                     }

                     boolean var94 = fieldAB.reader().readBoolean();

                     try {
                        varmob9222.levelBoss = fieldAB.reader().readByte();
                        varmob9222.maxHp = fieldAB.reader().readInt();
                     } catch (Exception var155) {
                     }

                     if (var94) {
                        GameScr.gameAA("-" + var252, varmob9222.x, varmob9222.y - varmob9222.h, 0, -2, 3);
                     } else {
                        GameScr.gameAA("-" + var252, varmob9222.x, varmob9222.y - varmob9222.h, 0, -2, 5);
                     }

                     return;
                  }

                  return;
               case 0:
                  Char varcharxxxxx;
                  if ((varcharxxxxx = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     varcharxxxxx.cPk = fieldAB.reader().readByte();
                     if (varcharxxxxx.charID == Char.aCID) {
                        Char.isAFocusDie = true;
                     }

                     varcharxxxxx.gameAA(fieldAB.reader().readShort(), fieldAB.reader().readShort());
                     if (Char.getMyChar().charFocus == varcharxxxxx) {
                        Char.getMyChar().charFocus = null;
                     }

                     return;
                  }

                  return;
               case 1:
                  int var91 = fieldAB.reader().readInt();

                  for (int var249 = 0; var249 < GameScr.vCharInMap.size(); var249++) {
                     Char var248 = null;

                     try {
                        var248 = (Char)GameScr.vCharInMap.elementAt(var249);
                     } catch (Exception var139) {
                        System.out.println("Char null");
                     }

                     if (var248 == null) {
                        return;
                     }

                     if (var248.charID == var91) {
                        var248.cxMoveLast = fieldAB.reader().readShort();
                        var248.cyMoveLast = fieldAB.reader().readShort();
                        var248.gameAA(var248.cxMoveLast, var248.cyMoveLast);
                        var248.lastUpdateTime = System.currentTimeMillis();
                        return;
                     }
                  }

                  return;
               case 2:
                  int varint91 = fieldAB.reader().readInt();

                  for (int var249 = 0; var249 < GameScr.vCharInMap.size(); var249++) {
                     Char var248;
                     if ((var248 = (Char)GameScr.vCharInMap.elementAt(var249)) != null && var248.charID == varint91) {
                        if (!var248.isInvisible && var248.isHuman && !var248.isNhanban) {
                           ServerEffect.gameAA(60, var248.cx, var248.cy, 1);
                        } else if (!var248.isInvisible && var248.gameBB() && !var248.isHuman) {
                           ServerEffect.gameAA(141, var248.cx, var248.cy, 0);
                        }

                        GameScr.vCharInMap.removeElementAt(var249);
                        Party.gameAA(varint91);
                        if (!var248.gameBA() && var248.cName.equals(Char.getMyChar().cName)) {
                           Char.getMyChar().fieldAA = null;
                        }

                        return;
                     }
                  }

                  return;
               case 3:
                  Char var9xx;
                  (var9xx = new Char()).charID = fieldAB.reader().readInt();
                  if (gameAA(var9xx, fieldAB)) {
                     GameScr.vCharInMap.addElement(var9xx);
                     Auto.fieldAB(var9xx);
                     if (!var9xx.gameBA() && var9xx.cName.equals(Char.getMyChar().cName)) {
                        Char.getMyChar().fieldAA = var9xx;
                        LockGame.fieldBD();
                     }

                     if (var9xx.charID == -Char.getMyChar().charID) {
                        Char.getMyChar().fieldAB = var9xx;
                     }

                     if (Code.fieldAB(var9xx.cName) && !Code.fieldAC.fieldAN()) {
                        Service.gI().addParty(var9xx.cName);
                        return;
                     }
                  }

                  return;
               case 4:
                  Char varchar9xxx;
                  if ((varchar9xxx = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     if ((TileMap.gameAA(varchar9xxx.cx, varchar9xxx.cy) & 2) == 2) {
                        varchar9xxx.gameAA(GameScr.sks[fieldAB.reader().readByte()], 0);
                     } else {
                        varchar9xxx.gameAA(GameScr.sks[fieldAB.reader().readByte()], 1);
                     }

                     if (varchar9xxx.isWolf) {
                        varchar9xxx.isWolf = false;
                        varchar9xxx.timeSummon = System.currentTimeMillis();
                        ServerEffect.gameAA(60, varchar9xxx, 1);
                     }

                     if (varchar9xxx.isMoto) {
                        varchar9xxx.isMoto = false;
                        varchar9xxx.isMotoBehind = true;
                     }

                     byte var185xxxx = fieldAB.reader().readByte();
                     varchar9xxx.attMobs = new Mob[var185xxxx];

                     for (int var242 = 0; var242 < varchar9xxx.attMobs.length; var242++) {
                        Mob var246 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                        varchar9xxx.attMobs[var242] = var246;
                        if (var242 == 0) {
                           if (varchar9xxx.cx <= var246.x) {
                              varchar9xxx.cdir = 1;
                           } else {
                              varchar9xxx.cdir = -1;
                           }
                        }
                     }

                     varchar9xxx.mobFocus = varchar9xxx.attMobs[0];
                     Char[] var80 = new Char[10];
                     int var81 = 0;

                     try {
                        for (var81 = 0; var81 < var80.length; var81++) {
                           int var186xxx;
                           Char var243;
                           if ((var186xxx = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                              var243 = Char.getMyChar();
                           } else {
                              var243 = GameScr.gameAE(var186xxx);
                           }

                           var80[var81] = var243;
                           if (var81 == 0) {
                              if (varchar9xxx.cx <= var243.cx) {
                                 varchar9xxx.cdir = 1;
                              } else {
                                 varchar9xxx.cdir = -1;
                              }
                           }
                        }
                     } catch (Exception var170) {
                     }

                     if (var81 > 0) {
                        varchar9xxx.attChars = new Char[var81];

                        for (int var243x = 0; var243x < varchar9xxx.attChars.length; var243x++) {
                           varchar9xxx.attChars[var243x] = var80[var243x];
                        }

                        varchar9xxx.charFocus = varchar9xxx.attChars[0];
                     }

                     return;
                  }

                  return;
               case 5: {
                  long var247 = fieldAB.reader().readLong();
                  Char.getMyChar().cExpDown = 0L;
                  Char var10000 = Char.getMyChar();
                  var10000.cEXP += var247;
                  int var89 = Char.getMyChar().clevel;
                  GameScr.gameAA(Char.getMyChar().cEXP, true);
                  if (var89 != Char.getMyChar().clevel) {
                     ServerEffect.gameAA(58, Char.getMyChar(), 1);
                  }

                  GameScr.gameAA("+" + var247, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch, 0, -2, 2);
                  if (var247 >= 1000000L) {
                     InfoMe.gameAA(mResources.gamePM + " " + var247 + " " + mResources.gameKA, 20, mFont.tahoma_7_yellow);
                  }

                  return;
               }
               case 6:
                  ItemMap var233 = new ItemMap(
                     fieldAB.reader().readShort(), fieldAB.reader().readShort(), fieldAB.reader().readShort(), fieldAB.reader().readShort()
                  );
                  byte[] var235;
                  if ((var235 = NinjaUtil.gameAA(fieldAB)) != null && var235.length > 0) {
                     var233.imgCaptcha = new MyImage();
                     var233.imgCaptcha.img = gameAA(var235);
                  }

                  GameScr.vItemMap.addElement(var233);
                  return;
               case 7:
                  Char.getMyChar().arrItemBag[fieldAB.reader().readByte()].quantity = fieldAB.reader().readShort();
                  return;
               case 8: {
                  byte var210 = fieldAB.reader().readByte();
                  Char.getMyChar().arrItemBag[var210] = new Item();
                  Char.getMyChar().arrItemBag[var210].typeUI = 3;
                  Char.getMyChar().arrItemBag[var210].indexUI = var210;
                  Char.getMyChar().arrItemBag[var210].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                  Char.getMyChar().arrItemBag[var210].isLock = fieldAB.reader().readBoolean();
                  if (Char.getMyChar().arrItemBag[var210].isTypeBody() || Char.getMyChar().arrItemBag[var210].isTypeNgocKham()) {
                     Char.getMyChar().arrItemBag[var210].upgrade = fieldAB.reader().readByte();
                  }

                  Char.getMyChar().arrItemBag[var210].isExpires = fieldAB.reader().readBoolean();

                  try {
                     Char.getMyChar().arrItemBag[var210].quantity = fieldAB.reader().readUnsignedShort();
                  } catch (Exception var154) {
                     Char.getMyChar().arrItemBag[var210].quantity = 1;
                  }

                  if (Char.getMyChar().arrItemBag[var210].template.type == 16) {
                     GameScr.hpPotion = GameScr.hpPotion + Char.getMyChar().arrItemBag[var210].quantity;
                  }

                  if (Char.getMyChar().arrItemBag[var210].template.type == 17) {
                     GameScr.mpPotion = GameScr.mpPotion + Char.getMyChar().arrItemBag[var210].quantity;
                  }

                  if (Char.getMyChar().arrItemBag[var210].template.id == 340) {
                     GameScr var256 = GameScr.gI();
                     var256.numSprinLeft = var256.numSprinLeft + Char.getMyChar().arrItemBag[var210].quantity;
                  }

                  if (GameScr.isPaintTrade) {
                     if (GameScr.gI().tradeItemName.equals("")) {
                        GameScr var256 = GameScr.gI();
                        var256.tradeItemName = var256.tradeItemName + Char.getMyChar().arrItemBag[var210].template.name;
                     } else {
                        GameScr var256 = GameScr.gI();
                        var256.tradeItemName = var256.tradeItemName + ", " + Char.getMyChar().arrItemBag[var210].template.name;
                     }

                     return;
                  } else {
                     if (Char.getMyChar().arrItemBag[var210].template.type != 20) {
                        InfoMe.gameAA(mResources.gamePM + " " + Char.getMyChar().arrItemBag[var210].template.name);
                        LockGame.fieldAT();
                        return;
                     }

                     return;
                  }
               }
               case 9: {
                  Item var193 = Char.getMyChar().arrItemBag[fieldAB.reader().readUnsignedByte()];
                  boolean var226 = false;

                  short var224;
                  try {
                     var224 = fieldAB.reader().readShort();
                  } catch (Exception var153) {
                     var224 = 1;
                  }

                  var193.quantity += var224;
                  if (var193.template.type == 16) {
                     GameScr.hpPotion += var224;
                  }

                  if (var193.template.type == 17) {
                     GameScr.mpPotion += var224;
                  }

                  if (var193.template.id == 340) {
                     GameScr var256 = GameScr.gI();
                     var256.numSprinLeft += var224;
                  }

                  GameCanvas.gameAJ();
                  if (GameScr.isPaintTrade) {
                     if (GameScr.gI().tradeItemName.equals("")) {
                        GameScr var256 = GameScr.gI();
                        var256.tradeItemName = var256.tradeItemName + var193.template.name;
                     } else {
                        GameScr var256 = GameScr.gI();
                        var256.tradeItemName = var256.tradeItemName + ", " + var193.template.name;
                     }

                     return;
                  } else {
                     if (var193.template.type != 20) {
                        InfoMe.gameAA(mResources.gamePM + " " + var193.template.name);
                        return;
                     }

                     return;
                  }
               }
               case 10:
                  byte byte3 = fieldAB.reader().readByte();
                  if (Char.getMyChar().arrItemBag[byte3].template.type == 16) {
                     GameScr.hpPotion = GameScr.hpPotion - Char.getMyChar().arrItemBag[byte3].quantity;
                  }

                  if (Char.getMyChar().arrItemBag[byte3].template.type == 17) {
                     GameScr.mpPotion = GameScr.mpPotion - Char.getMyChar().arrItemBag[byte3].quantity;
                  }

                  Char.getMyChar().arrItemBag[byte3] = null;
                  if (GameScr.gameBA()) {
                     GameScr.gI().center = null;
                     GameScr.gI().left = null;
                  } else {
                     GameScr.gI().resetButton();
                  }

                  return;
               case 11: {
                  byte var210 = fieldAB.reader().readByte();
                  if (Char.getMyChar().arrItemBag[var210].template.type == 24) {
                     InfoDlg.gameAB();
                  }

                  Char.getMyChar().gameAA(var210);
                  Char.getMyChar().gameAA(fieldAB);
                  Char.getMyChar().eff5BuffHp = fieldAB.reader().readShort();
                  Char.getMyChar().eff5BuffMp = fieldAB.reader().readShort();
                  GameScr.gI().gameBJ();
                  LockGame.fieldAR();
                  return;
               }
               case 13:
                  Char.getMyChar().xu = fieldAB.reader().readInt();
                  Char.getMyChar().yen = fieldAB.reader().readInt();
                  Char.getMyChar().luong = fieldAB.reader().readInt();
                  LockGame.fieldAH();
                  GameCanvas.gameAJ();
                  return;
               case 14:
                  Item item3 = Char.getMyChar().arrItemBag[fieldAB.reader().readByte()];
                  Char.getMyChar().yen = fieldAB.reader().readInt();

                  int i10;
                  try {
                     i10 = fieldAB.reader().readShort();
                  } catch (Exception var138) {
                     i10 = 1;
                  }

                  item3.quantity -= i10;
                  if (item3.template.type == 16) {
                     GameScr.hpPotion -= i10;
                  }

                  if (item3.template.type == 17) {
                     GameScr.mpPotion -= i10;
                  }

                  if (item3.quantity <= 0) {
                     Char.getMyChar().arrItemBag[item3.indexUI] = null;
                  }

                  if (GameScr.gameBA()) {
                     GameScr.gI().left = GameScr.gI().center = null;
                     GameScr.gI().gameBB();
                  }

                  GameCanvas.gameAJ();
                  LockGame.fieldAT();
                  return;
               case 15:
                  Char.getMyChar().gameAC(fieldAB);
                  LockGame.fieldAR();
                  return;
               case 16:
                  Char.getMyChar().gameAE(fieldAB);
                  return;
               case 17:
                  Char.getMyChar().gameAD(fieldAB);
                  return;
               case 18: {
                  byte var210 = fieldAB.reader().readByte();
                  short var224 = 1;

                  try {
                     var224 = fieldAB.reader().readShort();
                  } catch (Exception var152) {
                  }

                  if (Char.getMyChar().arrItemBag[var210].template.type == 24) {
                     InfoDlg.gameAB();
                  }

                  if (Char.getMyChar().arrItemBag[var210].template.type == 16) {
                     GameScr.hpPotion--;
                  }

                  if (Char.getMyChar().arrItemBag[var210].template.type == 17) {
                     GameScr.mpPotion--;
                  }

                  if (Char.getMyChar().arrItemBag[var210].quantity > var224) {
                     Item var257 = Char.getMyChar().arrItemBag[var210];
                     var257.quantity -= var224;
                  } else {
                     Char.getMyChar().arrItemBag[var210] = null;
                  }

                  if (GameScr.isPaintInfoMe) {
                     GameScr.gI().gameBJ();
                  }

                  return;
               }
               case 19:
                  Char.getMyChar();
                  Char.gameAA(fieldAB, true);
                  return;
               case 20:
                  Char.getMyChar();
                  Char.gameAA(fieldAB, false);
                  return;
               case 21:
                  byte var185xxx = fieldAB.reader().readByte();
                  Char.getMyChar().luong = fieldAB.reader().readInt();
                  Char.getMyChar().xu = fieldAB.reader().readInt();
                  Char.getMyChar().yen = fieldAB.reader().readInt();
                  if (GameScr.itemUpGrade != null) {
                     GameScr.itemUpGrade.upgrade = fieldAB.reader().readByte();
                     GameScr.itemUpGrade.isLock = true;
                     GameScr.itemUpGrade.clearExpire();
                     if (var185xxx == 1) {
                        GameScr.effUpok = GameScr.efs[53];
                        GameScr.indexEff = 0;
                     }
                  }

                  if (GameScr.arrItemUpGrade != null) {
                     for (int var201 = 0; var201 < GameScr.arrItemUpGrade.length; var201++) {
                        GameScr.arrItemUpGrade[var201] = null;
                     }
                  }

                  if (var185xxx == 5 || var185xxx == 6) {
                     if (GameScr.itemSplit != null) {
                        GameScr.itemSplit = null;
                     }

                     if (GameScr.arrItemSplit != null) {
                        for (int var201 = 0; var201 < GameScr.arrItemSplit.length; var201++) {
                           GameScr.arrItemSplit[var201] = null;
                        }
                     }
                  }

                  GameScr.gI().left = GameScr.gI().center = null;
                  GameScr.gI().gameBB();
                  GameCanvas.gameAJ();
                  if (var185xxx == 5) {
                     InfoMe.gameAA(mResources.gamePT[0] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_white);
                     return;
                  } else if (var185xxx == 6) {
                     InfoMe.gameAA(mResources.gamePT[1] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_red);
                     return;
                  } else {
                     if (var185xxx == 1) {
                        InfoMe.gameAA(mResources.gamePS[0] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_white);
                     } else {
                        InfoMe.gameAA(mResources.gamePS[1] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_red);
                     }

                     return;
                  }
               case 22: {
                  byte var185xxxx = fieldAB.reader().readByte();
                  String var191 = mResources.gameCG;

                  for (int var3 = 0; var3 < GameScr.arrItemSplit.length; var3++) {
                     GameScr.arrItemSplit[var3] = null;
                  }

                  for (int var1991 = 0; var1991 < var185xxxx; var1991++) {
                     Item var218;
                     (var218 = new Item()).typeUI = 3;
                     var218.indexUI = fieldAB.reader().readByte();
                     var218.template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     var218.expires = -1L;
                     var218.quantity = 1;
                     var218.isLock = GameScr.itemSplit.isLock;
                     Char.getMyChar().arrItemBag[var218.indexUI] = var218;
                     var191 = var191 + var218.template.name;
                     if (var1991 < var185xxxx - 1) {
                        var191 = var191 + ", ";
                     }
                  }

                  GameScr.itemSplit.upgrade = 0;
                  GameScr.itemSplit.clearExpire();
                  GameScr.gI().left = GameScr.gI().center = null;
                  GameScr.gI().gameBC();
                  GameCanvas.gameAJ();
                  InfoMe.gameAA(var191);
                  GameScr.effUpok = GameScr.efs[66];
                  GameScr.indexEff = 0;
                  LockGame.fieldAR();
                  return;
               }
               case 23:
                  String utf11;
                  if (Code.fieldAC(utf11 = fieldAB.reader().readUTF())) {
                     Service.gI().acceptPleaseParty(utf11);
                  } else {
                     GameCanvas.gameAA(utf11 + " " + mResources.gameQZ, 8889, utf11, 8882, null);
                  }

                  return;
               case 25:
                  byte var95 = fieldAB.reader().readByte();

                  for (int var255 = 0; var255 < var95; var255++) {
                     int var97 = fieldAB.reader().readInt();
                     short var98 = fieldAB.reader().readShort();
                     short var99 = fieldAB.reader().readShort();
                     int var100 = fieldAB.reader().readInt();
                     Char var101;
                     if ((var101 = GameScr.gameAE(var97)) != null) {
                        var101.cx = var98;
                        var101.cy = var99;
                        var101.cHP = var100;
                        var101.lastUpdateTime = System.currentTimeMillis();
                     }
                  }

                  return;
               case 26:
                  Char.getMyChar().countKill = fieldAB.reader().readUnsignedShort();
                  Char.getMyChar().countKillMax = fieldAB.reader().readUnsignedShort();
                  return;
               case 27:
                  Mob var222 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                  Char vchar0x;
                  int var186;
                  if ((var186 = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                     vchar0x = Char.getMyChar();
                  } else {
                     vchar0x = GameScr.gameAE(var186);
                  }

                  vchar0x.moveFast = new short[3];
                  vchar0x.moveFast[0] = 0;
                  vchar0x.moveFast[1] = (short)var222.x;
                  vchar0x.moveFast[2] = (short)var222.y;
                  vchar0x.isBlinking = false;
                  return;
               case 30:
                  byte var75 = fieldAB.reader().readByte();

                  try {
                     GameScr.svTitle = fieldAB.reader().readUTF();
                     GameScr.svAction = fieldAB.reader().readUTF();
                  } catch (Exception var151) {
                  }

                  GameScr.gI().gameAD(var75);
                  LockGame.fieldAR();
                  return;
               case 31:
                  Char.getMyChar().xuInBox = fieldAB.reader().readInt();
                  Char.getMyChar().arrItemBox = new Item[fieldAB.reader().readUnsignedByte()];

                  for (int var77x = 0; var77x < Char.getMyChar().arrItemBox.length; var77x++) {
                     short var251;
                     if ((var251 = fieldAB.reader().readShort()) != -1) {
                        Char.getMyChar().arrItemBox[var77x] = new Item();
                        Char.getMyChar().arrItemBox[var77x].typeUI = 4;
                        Char.getMyChar().arrItemBox[var77x].indexUI = var77x;
                        Char.getMyChar().arrItemBox[var77x].template = ItemTemplates.gameAA(var251);
                        Char.getMyChar().arrItemBox[var77x].isLock = fieldAB.reader().readBoolean();
                        if (Char.getMyChar().arrItemBox[var77x].isTypeBody() || Char.getMyChar().arrItemBox[var77x].isTypeNgocKham()) {
                           Char.getMyChar().arrItemBox[var77x].upgrade = fieldAB.reader().readByte();
                        }

                        Char.getMyChar().arrItemBox[var77x].isExpires = fieldAB.reader().readBoolean();
                        Char.getMyChar().arrItemBox[var77x].quantity = fieldAB.reader().readShort();
                     }
                  }

                  LockGame.fieldAT();
                  return;
               case 33:
                  byte var238 = fieldAB.reader().readByte();
                  System.out.println("TypeI=" + var238);
                  if (var238 == 14) {
                     GameScr.arrItemStore = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemStore.length; var239++) {
                        GameScr.arrItemStore[var239] = new Item();
                        GameScr.arrItemStore[var239].typeUI = 14;
                        GameScr.arrItemStore[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemStore[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 15) {
                     GameScr.arrItemBook = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemBook.length; var239++) {
                        GameScr.arrItemBook[var239] = new Item();
                        GameScr.arrItemBook[var239].typeUI = 15;
                        GameScr.arrItemBook[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemBook[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 32) {
                     GameScr.arrItemFashion = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemFashion.length; var239++) {
                        GameScr.arrItemFashion[var239] = new Item();
                        GameScr.arrItemFashion[var239].typeUI = 32;
                        GameScr.arrItemFashion[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemFashion[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 34) {
                     GameScr.arrItemClanShop = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemClanShop.length; var239++) {
                        GameScr.arrItemClanShop[var239] = new Item();
                        GameScr.arrItemClanShop[var239].typeUI = 34;
                        GameScr.arrItemClanShop[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemClanShop[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 35) {
                     GameScr.arrItemElites = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemElites.length; var239++) {
                        GameScr.arrItemElites[var239] = new Item();
                        GameScr.arrItemElites[var239].typeUI = 35;
                        GameScr.arrItemElites[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemElites[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 20) {
                     GameScr.arrItemNonNam = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemNonNam.length; var239++) {
                        GameScr.arrItemNonNam[var239] = new Item();
                        GameScr.arrItemNonNam[var239].typeUI = var238;
                        GameScr.arrItemNonNam[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemNonNam[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 21) {
                     GameScr.arrItemNonNu = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemNonNu.length; var239++) {
                        GameScr.arrItemNonNu[var239] = new Item();
                        GameScr.arrItemNonNu[var239].typeUI = var238;
                        GameScr.arrItemNonNu[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemNonNu[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 22) {
                     GameScr.arrItemAoNam = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemAoNam.length; var239++) {
                        GameScr.arrItemAoNam[var239] = new Item();
                        GameScr.arrItemAoNam[var239].typeUI = var238;
                        GameScr.arrItemAoNam[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemAoNam[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 23) {
                     GameScr.arrItemAoNu = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemAoNu.length; var239++) {
                        GameScr.arrItemAoNu[var239] = new Item();
                        GameScr.arrItemAoNu[var239].typeUI = var238;
                        GameScr.arrItemAoNu[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemAoNu[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 24) {
                     GameScr.arrItemGangTayNam = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemGangTayNam.length; var239++) {
                        GameScr.arrItemGangTayNam[var239] = new Item();
                        GameScr.arrItemGangTayNam[var239].typeUI = var238;
                        GameScr.arrItemGangTayNam[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemGangTayNam[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 25) {
                     GameScr.arrItemGangTayNu = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemGangTayNu.length; var239++) {
                        GameScr.arrItemGangTayNu[var239] = new Item();
                        GameScr.arrItemGangTayNu[var239].typeUI = var238;
                        GameScr.arrItemGangTayNu[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemGangTayNu[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 26) {
                     GameScr.arrItemQuanNam = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemQuanNam.length; var239++) {
                        GameScr.arrItemQuanNam[var239] = new Item();
                        GameScr.arrItemQuanNam[var239].typeUI = var238;
                        GameScr.arrItemQuanNam[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemQuanNam[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 27) {
                     GameScr.arrItemQuanNu = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemQuanNu.length; var239++) {
                        GameScr.arrItemQuanNu[var239] = new Item();
                        GameScr.arrItemQuanNu[var239].typeUI = var238;
                        GameScr.arrItemQuanNu[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemQuanNu[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 28) {
                     GameScr.arrItemGiayNam = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemGiayNam.length; var239++) {
                        GameScr.arrItemGiayNam[var239] = new Item();
                        GameScr.arrItemGiayNam[var239].typeUI = var238;
                        GameScr.arrItemGiayNam[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemGiayNam[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 29) {
                     GameScr.arrItemGiayNu = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemGiayNu.length; var239++) {
                        GameScr.arrItemGiayNu[var239] = new Item();
                        GameScr.arrItemGiayNu[var239].typeUI = var238;
                        GameScr.arrItemGiayNu[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemGiayNu[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 16) {
                     GameScr.arrItemLien = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemLien.length; var239++) {
                        GameScr.arrItemLien[var239] = new Item();
                        GameScr.arrItemLien[var239].typeUI = var238;
                        GameScr.arrItemLien[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemLien[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 17) {
                     GameScr.arrItemNhan = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemNhan.length; var239++) {
                        GameScr.arrItemNhan[var239] = new Item();
                        GameScr.arrItemNhan[var239].typeUI = var238;
                        GameScr.arrItemNhan[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemNhan[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 18) {
                     GameScr.arrItemNgocBoi = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemNgocBoi.length; var239++) {
                        GameScr.arrItemNgocBoi[var239] = new Item();
                        GameScr.arrItemNgocBoi[var239].typeUI = var238;
                        GameScr.arrItemNgocBoi[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemNgocBoi[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 19) {
                     GameScr.arrItemPhu = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemPhu.length; var239++) {
                        GameScr.arrItemPhu[var239] = new Item();
                        GameScr.arrItemPhu[var239].typeUI = var238;
                        GameScr.arrItemPhu[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemPhu[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 2) {
                     GameScr.arrItemWeapon = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemWeapon.length; var239++) {
                        GameScr.arrItemWeapon[var239] = new Item();
                        GameScr.arrItemWeapon[var239].typeUI = var238;
                        GameScr.arrItemWeapon[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemWeapon[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 6) {
                     GameScr.arrItemStack = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemStack.length; var239++) {
                        GameScr.arrItemStack[var239] = new Item();
                        GameScr.arrItemStack[var239].typeUI = var238;
                        GameScr.arrItemStack[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemStack[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 == 7) {
                     GameScr.arrItemStackLock = new Item[fieldAB.reader().readByte()];

                     for (int var239 = 0; var239 < GameScr.arrItemStackLock.length; var239++) {
                        GameScr.arrItemStackLock[var239] = new Item();
                        GameScr.arrItemStackLock[var239].typeUI = var238;
                        GameScr.arrItemStackLock[var239].isLock = true;
                        GameScr.arrItemStackLock[var239].indexUI = fieldAB.reader().readUnsignedByte();
                        GameScr.arrItemStackLock[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     }

                     return;
                  }

                  if (var238 != 8) {
                     if (var238 == 9) {
                        GameScr.arrItemGroceryLock = new Item[fieldAB.reader().readByte()];

                        for (int var239 = 0; var239 < GameScr.arrItemGroceryLock.length; var239++) {
                           GameScr.arrItemGroceryLock[var239] = new Item();
                           GameScr.arrItemGroceryLock[var239].typeUI = var238;
                           GameScr.arrItemGroceryLock[var239].isLock = true;
                           GameScr.arrItemGroceryLock[var239].indexUI = fieldAB.reader().readUnsignedByte();
                           GameScr.arrItemGroceryLock[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                        }
                     }

                     LockGame.fieldBF();
                     return;
                  }

                  GameScr.arrItemGrocery = new Item[fieldAB.reader().readByte()];

                  for (int var239 = 0; var239 < GameScr.arrItemGrocery.length; var239++) {
                     GameScr.arrItemGrocery[var239] = new Item();
                     GameScr.arrItemGrocery[var239].typeUI = var238;
                     GameScr.arrItemGrocery[var239].indexUI = fieldAB.reader().readUnsignedByte();
                     GameScr.arrItemGrocery[var239].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                  }

                  return;
               case 34: {
                  MyVector var195 = new MyVector();
                  String var188;
                  if (!(var188 = fieldAB.reader().readUTF()).equals("")) {
                     GameScr.gI().gameAA((String)null, var188, true);
                  }

                  byte var185xxxx = fieldAB.reader().readByte();

                  for (int var3 = 0; var3 < var185xxxx; var3++) {
                     String var206x = fieldAB.reader().readUTF();
                     Short var228 = new Short(fieldAB.reader().readShort());
                     var195.addElement(new Command(var206x, GameCanvas.instance, 88819, var228));
                  }

                  GameCanvas.menu.gameAA(var195);
                  return;
               }
               case 36:
                  GameScr.gI().gameAA(fieldAB);
                  LockGame.fieldAF();
                  return;
               case 37:
                  GameScr.gI().tradeName = fieldAB.reader().readUTF();
                  GameScr.gI().gameAU();
                  LockGame.fieldBB();
                  return;
               case 38:
                  short var76 = fieldAB.reader().readShort();

                  for (int var77 = 0; var77 < GameScr.vNpc.size(); var77++) {
                     Npc var78;
                     if ((var78 = (Npc)GameScr.vNpc.elementAt(var77)).template.npcTemplateId == var76 && var78.equals(Char.getMyChar().npcFocus)) {
                        String utf13;
                        ChatPopup.gameAA(utf13 = fieldAB.reader().readUTF(), var78);
                        if (var78.template.npcTemplateId == 0) {
                           if (utf13.equals("Số lần vào trong hang hôm nay của con đã hết.")) {
                              Stanima.fieldAZ = true;
                              if (Code.fieldAB instanceof Stanima) {
                                 Stanima.fieldAY = true;
                              }

                              if (Code.fieldAB instanceof Hd9x) {
                                 Code.fieldAC();
                              }

                              TileMap.fieldAG();
                              return;
                           }

                           return;
                        } else {
                           if (var78.template.npcTemplateId == 5) {
                              if (utf13.equals("Tốt lắm, ngươi đã chọn nơi này làm nơi trở về khi bị trọng thương")) {
                                 LockGame.fieldAZ();
                                 return;
                              }
                           } else if (var78.template.npcTemplateId == 25) {
                              if (Code.fieldAB == Code.fieldAD) {
                                 AutoNvhn.fieldAA(utf13);
                              } else if (utf13.equals("Hôm nay con đã làm hết nhiệm vụ ta giao. Hãy quay lại vào ngày hôm sau.")) {
                                 Stanima.fieldAX = true;
                                 return;
                              }

                              return;
                           }

                           return;
                        }
                     }
                  }

                  return;
               case 39:
                  short vars9x = fieldAB.reader().readShort();

                  for (int var77xx = 0; var77xx < GameScr.vNpc.size(); var77xx++) {
                     Npc var78;
                     if ((var78 = (Npc)GameScr.vNpc.elementAt(var77xx)).template.npcTemplateId == vars9x && var78.equals(Char.getMyChar().npcFocus)) {
                        ChatPopup.addChatPopup(fieldAB.reader().readUTF(), 1000, var78);
                        String[] var241 = new String[fieldAB.reader().readByte()];

                        for (int var242x = 0; var242x < var241.length; var242x++) {
                           var241[var242x] = fieldAB.reader().readUTF();
                        }

                        GameScr.gI();
                        GameScr.gameAA(var241, var78);
                        return;
                     }
                  }

                  return;
               case 40:
                  InfoDlg.gameAB();
                  GameCanvas.gameAI();
                  GameCanvas.gameAH();
                  MyVector var195 = new MyVector();

                  try {
                     while (true) {
                        var195.addElement(new Command(fieldAB.reader().readUTF(), GameCanvas.instance, 88822, null));
                     }
                  } catch (Exception var172) {
                     if (Char.getMyChar().npcFocus != null) {
                        if (Char.getMyChar().npcFocus.charID == 25) {
                           GameScr.fieldGH = var195.size();
                        }

                        for (int var3x = 0; var3x < Char.getMyChar().npcFocus.template.menu.length; var3x++) {
                           String[] var216 = Char.getMyChar().npcFocus.template.menu[var3x];
                           var195.addElement(new Command(var216[0], GameCanvas.instance, 88820, var216));
                        }

                        GameCanvas.menu.gameAA(var195);
                        return;
                     }

                     return;
                  }
               case 42:
                  gameAH(fieldAB);
                  return;
               case 43:
                  Integer var212 = new Integer(fieldAB.reader().readInt());
                  Char var187;
                  if ((var187 = GameScr.gameAE(var212)) != null) {
                     GameCanvas.gameAA(var187.cName + " " + mResources.gameQT, 88810, var212, 88811, null);
                  }

                  return;
               case 45:
                  GameScr.gI().typeTradeOrder = 1;
                  GameScr.gI().coinTradeOrder = fieldAB.reader().readInt();
                  GameScr.arrItemTradeOrder = new Item[12];
                  byte var202 = fieldAB.reader().readByte();

                  for (int var201 = 0; var201 < var202; var201++) {
                     GameScr.arrItemTradeOrder[var201] = new Item();
                     GameScr.arrItemTradeOrder[var201].typeUI = 3;
                     GameScr.arrItemTradeOrder[var201].indexUI = var201;
                     GameScr.arrItemTradeOrder[var201].template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                     GameScr.arrItemTradeOrder[var201].isLock = false;
                     if (GameScr.arrItemTradeOrder[var201].isTypeBody() || GameScr.arrItemTradeOrder[var201].isTypeNgocKham()) {
                        GameScr.arrItemTradeOrder[var201].upgrade = fieldAB.reader().readByte();
                     }

                     GameScr.arrItemTradeOrder[var201].isExpires = fieldAB.reader().readBoolean();
                     GameScr.arrItemTradeOrder[var201].quantity = fieldAB.reader().readShort();
                  }

                  if (GameScr.gI().typeTrade == 1 && GameScr.gI().typeTradeOrder == 1) {
                     GameScr.gI().timeTrade = (int)(System.currentTimeMillis() / 1000L + 5L);
                  }

                  return;
               case 46:
                  GameScr.gI().typeTradeOrder = 2;
                  if (GameScr.gI().typeTrade >= 2 && GameScr.gI().typeTradeOrder >= 2) {
                     InfoDlg.gameAA();
                     LockGame.fieldBB();
                  }

                  return;
               case 47:
                  GameCanvas.taskTick = 150;
                  short var196 = fieldAB.reader().readShort();
                  byte varb9x = fieldAB.reader().readByte();
                  String var227 = fieldAB.reader().readUTF();
                  String var229 = fieldAB.reader().readUTF();
                  String[] var66;
                  short[] var67 = new short[(var66 = new String[fieldAB.reader().readByte()]).length];
                  short var68 = -1;

                  for (int var230 = 0; var230 < var66.length; var230++) {
                     String var231 = fieldAB.reader().readUTF();
                     var67[var230] = -1;
                     if (!var231.equals("")) {
                        var66[var230] = var231;
                     }
                  }

                  try {
                     var68 = fieldAB.reader().readShort();

                     for (int var403 = 0; var403 < var66.length; var403++) {
                        var67[var403] = fieldAB.reader().readShort();
                     }
                  } catch (Exception var167) {
                  }

                  Char.getMyChar().taskMaint = new Task(var196, varb9x, var227, var229, var66, var67, var68);
                  Char.getMyChar().gameAC(21);
                  if (Char.getMyChar().npcFocus != null) {
                     Npc.npcBE();
                  }

                  LockGame.fieldAP();
                  return;
               case 48:
                  if (Char.getMyChar().taskMaint != null) {
                     GameCanvas.taskTick = 100;
                     Char.getMyChar().taskMaint.index++;
                     Char.getMyChar().taskMaint.count = 0;
                     if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.chatPopup != null && Char.getMyChar().taskMaint.index >= 2) {
                        Char.getMyChar().npcFocus.chatPopup = null;
                     }

                     if (Char.getMyChar().taskMaint.index >= Char.getMyChar().taskMaint.subNames.length - 1) {
                        Char.getMyChar().gameAC(61);
                     } else {
                        Char.getMyChar().gameAC(21);
                     }

                     Npc.npcBE();
                  }

                  LockGame.fieldAP();
                  return;
               case 49:
                  Char.getMyChar().ctaskId++;
                  Char.getMyChar();
                  Char.gameAY();
                  return;
               case 50:
                  GameCanvas.taskTick = 50;
                  Char.getMyChar().taskMaint.count = fieldAB.reader().readShort();
                  if (Char.getMyChar().npcFocus != null) {
                     Npc.npcBE();
                  }

                  return;
               case 51:
                  Mob varmob9xzz = null;

                  try {
                     varmob9xzz = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                  } catch (Exception var150) {
                  }

                  if (varmob9xzz != null) {
                     varmob9xzz.hp = fieldAB.reader().readInt();
                     GameScr.gameAA("", varmob9xzz.x, varmob9xzz.y - varmob9xzz.h, 0, -2, 4);
                  }

                  return;
               case 52:
                  Char.ischangingMap = false;
                  Char.isLockKey = false;
                  Char.getMyChar().cx = fieldAB.reader().readShort();
                  Char.getMyChar().cy = fieldAB.reader().readShort();
                  Char.getMyChar().cxSend = Char.getMyChar().cx;
                  Char.getMyChar().cySend = Char.getMyChar().cy;
                  return;
               case 53: {
                  GameScr.gI().resetButton();
                  String var188;
                  if (!(var188 = fieldAB.reader().readUTF()).equals("typemoi")) {
                     String var191 = fieldAB.reader().readUTF();
                     GameScr.gI().gameAA(var188, var191, false);
                  } else {
                     String var191 = fieldAB.reader().readUTF();
                     short var224 = fieldAB.reader().readShort();
                     String var220 = fieldAB.reader().readUTF();
                     short var4 = fieldAB.reader().readShort();
                     String varstr5x = fieldAB.reader().readUTF();
                     short var219 = fieldAB.reader().readShort();
                     String var209 = fieldAB.reader().readUTF();
                     byte var215 = fieldAB.reader().readByte();
                     String var225 = fieldAB.reader().readUTF();
                     GameScr.gI().gameAA(var191, var224, var220, var4, varstr5x, var219, var209, var225, var215);
                  }

                  return;
               }
               case 54:
                  GameCanvas.gameAA().gameAA(fieldAB.reader().readUTF(), fieldAB.reader().readUTF(), fieldAB.reader().readUTF(), fieldAB.reader().readUTF());
                  return;
               case 55:
                  GameCanvas.gameAA()
                     .gameAA(
                        fieldAB.reader().readUTF(),
                        fieldAB.reader().readUTF(),
                        fieldAB.reader().readShort(),
                        fieldAB.reader().readUTF(),
                        fieldAB.reader().readUTF()
                     );
                  return;
               case 57:
                  GameCanvas.gameAJ();
                  GameScr.gI().resetButton();
                  LockGame.fieldBB();
                  return;
               case 58:
                  GameScr.arrItemTradeMe = null;
                  GameScr.arrItemTradeOrder = null;
                  if (GameScr.gI().coinTradeOrder > 0) {
                     GameScr var256 = GameScr.gI();
                     var256.tradeItemName = var256.tradeItemName + ", " + GameScr.gI().coinTradeOrder + " " + mResources.gamePA;
                     GameScr.gameAA("+" + GameScr.gI().coinTradeOrder, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 6);
                  }

                  GameScr.gI().coinTrade = GameScr.gI().coinTradeOrder = 0;
                  GameScr.gI().resetButton();
                  Char.getMyChar().xu = fieldAB.reader().readInt();
                  InfoDlg.gameAB();
                  if (!GameScr.gI().tradeItemName.equals("")) {
                     InfoMe.gameAA(mResources.gamePM + " " + GameScr.gI().tradeItemName);
                  }

                  LockGame.fieldBB();
                  return;
               case 59:
                  String var191 = fieldAB.reader().readUTF();
                  Friend var223 = new Friend(var191, (byte)4);
                  GameScr.vFriendWait.addElement(var223);
                  InfoMe.gameAA(var191 + " " + mResources.gameMJ, 20, mFont.tahoma_7_white);
                  if (GameScr.isPaintFriend) {
                     boolean var217 = false;

                     for (int var197 = 0; var197 < GameScr.vFriend.size(); var197++) {
                        if (((Friend)GameScr.vFriend.elementAt(var197)).friendName.equals(var191)) {
                           var217 = true;
                           break;
                        }
                     }

                     if (!var217) {
                        GameScr.vFriend.addElement(var223);
                        GameScr.gI();
                        GameScr.sortList(0);
                        GameScr.indexRow = 0;
                        GameScr.scrMain.gameAA();
                        return;
                     }
                  }

                  return;
               case 60:
                  Char var9xxx;
                  if ((var9xxx = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     Mob.interestChar = var9xxx;
                  }

                  if (var9xxx != null) {
                     if ((TileMap.gameAA(var9xxx.cx, var9xxx.cy) & 2) == 2) {
                        var9xxx.gameAA(GameScr.sks[fieldAB.reader().readByte()], 0);
                     } else {
                        var9xxx.gameAA(GameScr.sks[fieldAB.reader().readByte()], 1);
                     }

                     if (var9xxx.isWolf && var9xxx.vitaWolf >= 500) {
                        var9xxx.isWolf = false;
                        var9xxx.timeSummon = System.currentTimeMillis();
                        ServerEffect.gameAA(60, var9xxx, 1);
                     }

                     if (var9xxx.isMoto) {
                        var9xxx.isMoto = false;
                        var9xxx.isMotoBehind = true;
                        if (var9xxx.vitaWolf > 500) {
                           ServerEffect.gameAA(60, var9xxx, 1);
                        }
                     }

                     Mob[] var82 = new Mob[10];
                     int var81 = 0;

                     try {
                        for (var81 = 0; var81 < var82.length; var81++) {
                           Mob var244 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                           var82[var81] = var244;
                           if (var81 == 0) {
                              if (var9xxx.cx <= var244.x) {
                                 var9xxx.cdir = 1;
                              } else {
                                 var9xxx.cdir = -1;
                              }
                           }
                        }
                     } catch (Exception var169) {
                     }

                     if (var81 > 0) {
                        var9xxx.attMobs = new Mob[var81];

                        for (int var241 = 0; var241 < var9xxx.attMobs.length; var241++) {
                           var9xxx.attMobs[var241] = var82[var241];
                        }

                        var9xxx.mobFocus = var9xxx.attMobs[0];
                     }

                     return;
                  }

                  return;
               case 61:
                  Char varci9z;
                  if ((varci9z = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     if ((TileMap.gameAA(varci9z.cx, varci9z.cy) & 2) == 2) {
                        varci9z.gameAA(GameScr.sks[fieldAB.reader().readByte()], 0);
                     } else {
                        varci9z.gameAA(GameScr.sks[fieldAB.reader().readByte()], 1);
                     }

                     if (varci9z.isWolf) {
                        varci9z.isWolf = false;
                        varci9z.timeSummon = System.currentTimeMillis();
                        if (varci9z.vitaWolf >= 500) {
                           ServerEffect.gameAA(60, varci9z, 1);
                        }
                     }

                     if (varci9z.isMoto) {
                        varci9z.isMoto = false;
                        varci9z.isMotoBehind = true;
                        ServerEffect.gameAA(60, varci9z, 1);
                     }

                     Char[] var80 = new Char[10];
                     int var81 = 0;

                     try {
                        for (var81 = 0; var81 < var80.length; var81++) {
                           int var186xx;
                           Char var83;
                           if ((var186xx = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                              var83 = Char.getMyChar();
                           } else {
                              var83 = GameScr.gameAE(var186xx);
                           }

                           var80[var81] = var83;
                           if (var81 == 0) {
                              if (varci9z.cx <= var83.cx) {
                                 varci9z.cdir = 1;
                              } else {
                                 varci9z.cdir = -1;
                              }
                           }
                        }
                     } catch (Exception var168) {
                     }

                     if (var81 > 0) {
                        varci9z.attChars = new Char[var81];

                        for (int var2391 = 0; var2391 < varci9z.attChars.length; var2391++) {
                           varci9z.attChars[var2391] = var80[var2391];
                        }

                        varci9z.charFocus = varci9z.attChars[0];
                     }

                     return;
                  }

                  return;
               case 62:
                  int var186x;
                  if ((var186x = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                     Char varchar9xxxxz;
                     (varchar9xxxxz = Char.getMyChar()).cHP = fieldAB.reader().readInt();
                     var186x = fieldAB.reader().readInt();
                     int var201x = 0;

                     try {
                        varchar9xxxxz.cMP = fieldAB.reader().readInt();
                        var201x = fieldAB.reader().readInt();
                     } catch (Exception var149) {
                     }

                     if ((var186x = var186x + var201x) == 0) {
                        GameScr.gameAA("", varchar9xxxxz.cx, varchar9xxxxz.cy - varchar9xxxxz.ch, 0, -2, 7);
                     } else if (var186x < 0) {
                        var186x = -var186x;
                        GameScr.gameAA("-" + var186x, varchar9xxxxz.cx, varchar9xxxxz.cy - varchar9xxxxz.ch, 0, -2, 8);
                     } else {
                        GameScr.gameAA("-" + var186x, varchar9xxxxz.cx, varchar9xxxxz.cy - varchar9xxxxz.ch, 0, -2, 0);
                     }

                     if (Char.getMyChar().cHP < Char.getMyChar().cMaxHP / 2) {
                        System.out.println("Bi PK: " + var186x);
                     }

                     return;
                  }

                  Char var1243;
                  if ((var1243 = GameScr.gameAE(var186x)) != null) {
                     var1243.cHP = fieldAB.reader().readInt();
                     var186x = fieldAB.reader().readInt();
                     int var201x = 0;

                     try {
                        var1243.cMP = fieldAB.reader().readInt();
                        var201x = fieldAB.reader().readInt();
                     } catch (Exception var148) {
                     }

                     if ((var186x = var186x + var201x) == 0) {
                        GameScr.gameAA("", var1243.cx, var1243.cy - var1243.ch, 0, -2, 4);
                        return;
                     } else {
                        if (var186x < 0) {
                           var186x = -var186x;
                           GameScr.gameAA("-" + var186x, var1243.cx, var1243.cy - var1243.ch, 0, -2, 3);
                        } else {
                           GameScr.gameAA("-" + var186x, var1243.cx, var1243.cy - var1243.ch, 0, -2, 5);
                        }

                        return;
                     }
                  }

                  return;
               case 63:
                  MyVector varvctr9x = new MyVector();

                  while (true) {
                     try {
                        varvctr9x.addElement(new Command(fieldAB.reader().readUTF(), GameCanvas.instance, 88817, null));
                     } catch (Exception var171) {
                        GameCanvas.menu.gameAA(varvctr9x);
                        return;
                     }
                  }
               case 64:
                  int var987256;
                  Char var2653;
                  if ((var987256 = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                     var2653 = Char.getMyChar();
                  } else {
                     var2653 = GameScr.gameAE(var987256);
                  }

                  var2653.moveFast = new short[3];
                  var2653.moveFast[0] = 0;
                  short var190 = fieldAB.reader().readShort();
                  short var2633 = fieldAB.reader().readShort();
                  var2653.moveFast[1] = var190;
                  var2653.moveFast[2] = var2633;
                  var2653.isBlinking = false;

                  try {
                     if ((var987256 = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                        var2653 = Char.getMyChar();
                     } else {
                        var2653 = GameScr.gameAE(var987256);
                     }

                     var2653.cx = var190;
                     var2653.cy = var2633;
                  } catch (Exception var147) {
                     var147.printStackTrace();
                  }

                  return;
               case 65:
                  Char var6528;
                  if ((var6528 = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     GameCanvas.gameAA(var6528.cName + " " + mResources.gameQW, 88812, var6528, 8882, null);
                  }

                  return;
               case 66: {
                  int var3 = fieldAB.reader().readInt();
                  int var201 = fieldAB.reader().readInt();
                  if (var3 != Char.getMyChar().charID && var201 != Char.getMyChar().charID) {
                     GameScr.gameAE(var3).testCharId = var201;
                     GameScr.gameAE(var201).testCharId = var3;
                     return;
                  } else {
                     if (var3 == Char.getMyChar().charID) {
                        Char.getMyChar().testCharId = var201;
                        Char.getMyChar().npcFocus = null;
                        Char.getMyChar().mobFocus = null;
                        Char.getMyChar().itemFocus = null;
                        Char.getMyChar().charFocus = GameScr.gameAE(Char.getMyChar().testCharId);
                        Char.getMyChar().charFocus.testCharId = Char.getMyChar().charID;
                        GameScr.gI().cPreFocusID = GameScr.gI().cLastFocusID;
                        GameScr.gI().cLastFocusID = var201;
                        Char.isManualFocus = true;
                     } else if (var201 == Char.getMyChar().charID) {
                        Char.getMyChar().testCharId = var3;
                        Char.getMyChar().npcFocus = null;
                        Char.getMyChar().mobFocus = null;
                        Char.getMyChar().itemFocus = null;
                        Char.getMyChar().charFocus = GameScr.gameAE(Char.getMyChar().testCharId);
                        Char.getMyChar().charFocus.testCharId = Char.getMyChar().charID;
                        GameScr.gI().cPreFocusID = GameScr.gI().cLastFocusID;
                        GameScr.gI().cLastFocusID = var3;
                        Char.isManualFocus = true;
                        return;
                     }

                     return;
                  }
               }
               case 67: {
                  int var3 = fieldAB.reader().readInt();
                  int var201 = fieldAB.reader().readInt();
                  int var4321 = 0;

                  try {
                     var4321 = fieldAB.reader().readInt();
                  } catch (Exception var146) {
                  }

                  if (var3 == Char.getMyChar().charID) {
                     Char var9 = GameScr.gameAE(var201);
                     if (var4321 > 0) {
                        InfoMe.gameAA(mResources.gameAA(mResources.gameMY, var9.cName));
                        Char.getMyChar().cHP = var4321;
                        Char.getMyChar().resultTest = 29;
                        if (var9 != null) {
                           var9.resultTest = 89;
                        }
                     } else {
                        if (var9 != null) {
                           var9.resultTest = 59;
                        }

                        Char.getMyChar().resultTest = 59;
                        InfoMe.gameAA(mResources.gameAA(mResources.gameMZ, var9.cName));
                     }

                     Char.getMyChar().testCharId = -9999;
                     Char.getMyChar().charFocus = null;
                     if (GameScr.gI().cPreFocusID >= 0) {
                        GameScr.gI().cLastFocusID = GameScr.gI().cPreFocusID;
                        GameScr.gI().cPreFocusID = -1;
                     } else {
                        GameScr.gI().cLastFocusID = -1;
                     }

                     if (var9 != null) {
                        var9.testCharId = -9999;
                        return;
                     }

                     return;
                  } else if (var201 == Char.getMyChar().charID) {
                     Char var9x = GameScr.gameAE(var3);
                     if (var4321 > 0) {
                        if (var9x != null) {
                           var9x.cHP = var4321;
                        }

                        if (var9x != null) {
                           var9x.resultTest = 29;
                        }

                        Char.getMyChar().resultTest = 89;
                        InfoMe.gameAA(mResources.gameAA(mResources.gameMX, var9x.cName));
                     } else {
                        if (var9x != null) {
                           var9x.resultTest = 59;
                        }

                        Char.getMyChar().resultTest = 59;
                        InfoMe.gameAA(mResources.gameAA(mResources.gameMZ, var9x.cName));
                     }

                     if (var9x != null) {
                        var9x.testCharId = -9999;
                     }

                     Char.getMyChar().testCharId = -9999;
                     Char.getMyChar().charFocus = null;
                     if (GameScr.gI().cPreFocusID >= 0) {
                        GameScr.gI().cLastFocusID = GameScr.gI().cPreFocusID;
                        GameScr.gI().cPreFocusID = -1;
                     } else {
                        GameScr.gI().cLastFocusID = -1;
                     }

                     return;
                  } else {
                     Char var208 = GameScr.gameAE(var3);
                     Char var203 = GameScr.gameAE(var201);
                     if (var4321 > 0) {
                        if (var208 != null) {
                           var208.cHP = var4321;
                        }

                        if (var208 != null) {
                           var208.resultTest = 29;
                        }

                        if (var203 != null) {
                           var203.resultTest = 89;
                        }
                     } else {
                        if (var208 != null) {
                           var208.resultTest = 59;
                        }

                        if (var203 != null) {
                           var203.resultTest = 59;
                        }
                     }

                     if (var208 != null) {
                        var208.testCharId = -9999;
                     }

                     if (var203 != null) {
                        var203.testCharId = -9999;
                        return;
                     }

                     return;
                  }
               }
               case 68:
                  Char var9;
                  if ((var9 = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     var9.killCharId = Char.getMyChar().charID;
                     Char.getMyChar().npcFocus = null;
                     Char.getMyChar().mobFocus = null;
                     Char.getMyChar().itemFocus = null;
                     Char.getMyChar().charFocus = var9;
                     Char.isManualFocus = true;
                     InfoMe.gameAA(var9.cName + mResources.gameNB, 20, mFont.tahoma_7_red);
                  }

                  return;
               case 69:
                  Char.getMyChar().killCharId = fieldAB.reader().readInt();
                  Char.getMyChar().npcFocus = null;
                  Char.getMyChar().mobFocus = null;
                  Char.getMyChar().itemFocus = null;
                  Char.getMyChar().charFocus = GameScr.gameAE(Char.getMyChar().killCharId);
                  Char.isManualFocus = true;
                  return;
               case 70:
                  Char var67552 = Char.getMyChar();

                  try {
                     var67552 = GameScr.gameAE(fieldAB.reader().readInt());
                  } catch (Exception var145) {
                  }

                  var67552.killCharId = -9999;
                  return;
               case 71: {
                  long var247 = fieldAB.reader().readLong();
                  Char var10000 = Char.getMyChar();
                  var10000.cExpDown -= var247;
                  GameScr.gameAA("+" + var247, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch, 0, -2, 2);
                  return;
               }
               case 72:
                  Char.getMyChar().cPk = fieldAB.reader().readByte();
                  Char.getMyChar().gameAA(fieldAB.reader().readShort(), fieldAB.reader().readShort());
                  Char.getMyChar().cEXP = GameScr.gameAB(Char.getMyChar().clevel - 1);
                  Char.getMyChar().cExpDown = fieldAB.reader().readLong();
                  GameScr.gameAA(Char.getMyChar().cEXP, true);
                  return;
               case 75: {
                  BuNhin var73 = new BuNhin(fieldAB.reader().readUTF(), fieldAB.reader().readShort(), fieldAB.reader().readShort());
                  GameScr.vBuNhin.addElement(var73);
                  ServerEffect.gameAA(60, var73.x, var73.y, 1);
                  return;
               }
               case 76: {
                  Mob var74;
                  if ((var74 = Mob.gameAA(fieldAB.reader().readUnsignedByte())) == null) {
                     return;
                  }

                  BuNhin var73;
                  if ((var73 = GameScr.gameAF(fieldAB.reader().readShort())) != null) {
                     short vars2625 = fieldAB.reader().readShort();
                     byte var194x = fieldAB.reader().readByte();
                     byte var185xxxx = fieldAB.reader().readByte();
                     var74.gameAA(var73);
                     var74.gameAA(vars2625, var194x, var185xxxx);
                     return;
                  }

                  return;
               }
               case 77: {
                  BuNhin var73 = (BuNhin)GameScr.vBuNhin.elementAt(fieldAB.reader().readShort());
                  GameScr.vBuNhin.removeElement(var73);
                  ServerEffect.gameAA(60, var73.x, var73.y, 1);
                  return;
               }
               case 78:
                  Mob var27656 = null;

                  try {
                     var27656 = Mob.gameAA(fieldAB.reader().readUnsignedByte());
                  } catch (Exception var144) {
                  }

                  if (var27656 != null && var27656.status != 0 && var27656.status != 0) {
                     var27656.status = 0;
                     ServerEffect.gameAA(60, var27656.x, var27656.y, 1);
                     ItemMap var93 = new ItemMap(
                        fieldAB.reader().readShort(),
                        fieldAB.reader().readShort(),
                        var27656.x,
                        var27656.y,
                        fieldAB.reader().readShort(),
                        fieldAB.reader().readShort()
                     );
                     GameScr.vItemMap.addElement(var93);
                     if (Res.abs(var93.y - Char.getMyChar().cy) < 24 && Res.abs(var93.x - Char.getMyChar().cx) < 24) {
                        Char.getMyChar().charFocus = null;
                        return;
                     }
                  }

                  return;
               case 79: {
                  int var3 = fieldAB.reader().readInt();
                  String var206 = fieldAB.reader().readUTF();
                  GameCanvas.gameAA(var206 + " " + mResources.gameQY, 8887, new Integer(var3), 8888, new Integer(var3));
                  return;
               }
               case 82:
                  GameScr.vParty.removeAllElements();
                  boolean var207 = fieldAB.reader().readBoolean();

                  try {
                     for (int var204 = 0; var204 < 6; var204++) {
                        GameScr.vParty.addElement(new Party(fieldAB.reader().readInt(), fieldAB.reader().readByte(), fieldAB.reader().readUTF(), var207));
                     }
                  } catch (Exception var166) {
                  }

                  GameScr.gI().gameAT();
                  String fieldAD3 = ((Party)GameScr.vParty.firstElement()).name;
                  if (Code.fieldAH == null) {
                     Code.fieldAH = fieldAD3;
                  } else if (!fieldAD3.equals(Code.fieldAH)) {
                     Service.gI().outParty();
                     return;
                  }

                  return;
               case 83:
                  GameScr.vParty.removeAllElements();
                  GameScr.gI().gameAT();
                  return;
               case 84:
                  Friend var214 = new Friend(fieldAB.reader().readUTF(), fieldAB.reader().readByte());
                  GameScr.gI();
                  GameScr.setText(var214.friendName);
                  if (var214.type == 0) {
                     InfoMe.gameAA(mResources.gameMK + " " + var214.friendName + " " + mResources.gameML);
                     GameScr.vFriend.addElement(var214);
                  } else if (var214.type == 1) {
                     for (int var7 = 0; var7 < GameScr.vFriend.size(); var7++) {
                        if (((Friend)GameScr.vFriend.elementAt(var7)).friendName.equals(var214.friendName)) {
                           GameScr.vFriend.removeElementAt(var7);
                           break;
                        }
                     }

                     InfoMe.gameAA(mResources.gameMM + " " + var214.friendName + " " + mResources.gameFC);
                     var214.type = 3;
                     GameScr.vFriend.insertElementAt(var214, 0);
                  }

                  if (GameScr.isPaintFriend) {
                     GameScr.gI();
                     GameScr.sortList(0);
                     GameScr.indexRow = 0;
                     GameScr.scrMain.gameAA();
                  }

                  return;
               case 85:
                  Mob var8;
                  if ((var8 = Mob.gameAA(fieldAB.reader().readUnsignedByte())) != null) {
                     var8.isDisable = fieldAB.reader().readBoolean();
                  }

                  return;
               case 86:
                  Mob var1;
                  if ((var1 = Mob.gameAA(fieldAB.reader().readUnsignedByte())) != null) {
                     var1.isDontMove = fieldAB.reader().readBoolean();
                  }

                  return;
               case 87:
                  Char var2;
                  int var3;
                  if ((var3 = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                     var2 = Char.getMyChar();
                  } else {
                     var2 = GameScr.gameAE(var3);
                  }

                  if (var2 != null) {
                     int var7x = fieldAB.reader().readUnsignedByte();
                     short var43 = fieldAB.reader().readShort();
                     byte var194x = fieldAB.reader().readByte();
                     byte var185xxxx = fieldAB.reader().readByte();
                     byte var45 = 0;
                     int var200 = -1;

                     try {
                        if ((var45 = fieldAB.reader().readByte()) == 1) {
                           var200 = fieldAB.reader().readInt();
                        }
                     } catch (Exception var143) {
                        var143.printStackTrace();
                     }

                     if (var2.mobMe != null) {
                        if (var45 == 0) {
                           Mob var211 = Mob.gameAA(var7x);
                           var2.mobMe.gameAA(var211);
                        } else {
                           Char var213 = GameScr.gameAE(var200);
                           var2.mobMe.gameAB(var213);
                        }
                     }

                     var2.mobMe.gameAA(var43, var194x, var185xxxx);
                     return;
                  }

                  return;
               case 88:
                  Char var25651;
                  int var186xxxx;
                  if ((var186xxxx = fieldAB.reader().readInt()) == Char.getMyChar().charID) {
                     var25651 = Char.getMyChar();
                  } else if ((var25651 = GameScr.gameAE(var186xxxx)) == null) {
                     return;
                  }

                  var25651.cHP = var25651.cMaxHP;
                  var25651.cMP = var25651.cMaxMP;
                  var25651.cx = fieldAB.reader().readShort();
                  var25651.cy = fieldAB.reader().readShort();
                  var25651.gameAX();
                  return;
               case 89:
                  Mob var2511;
                  if ((var2511 = Mob.gameAA(fieldAB.reader().readUnsignedByte())) != null) {
                     var2511.isFire = fieldAB.reader().readBoolean();
                  }

                  return;
               case 90:
                  Mob var2223;
                  if ((var2223 = Mob.gameAA(fieldAB.reader().readUnsignedByte())) != null) {
                     var2223.isIce = fieldAB.reader().readBoolean();
                     if (!var2223.isIce) {
                        ServerEffect.gameAA(77, var2223.x, var2223.y - 9, 1);
                        return;
                     }
                  }

                  return;
               case 91:
                  Mob var46;
                  if ((var46 = Mob.gameAA(fieldAB.reader().readUnsignedByte())) != null) {
                     var46.isWind = fieldAB.reader().readBoolean();
                  }

                  return;
               case 92: {
                  String var188 = fieldAB.reader().readUTF();
                  Short var199 = new Short(fieldAB.reader().readShort());
                  GameCanvas.inputDlg.gameAA(var188, new Command(mResources.gameEC, GameCanvas.instance, 88818, var199), 0);
                  return;
               }
               case 93:
                  int var47 = fieldAB.reader().readInt();
                  GameScr.currentCharViewInfo = new Char();
                  if (Char.getMyChar().charID == var47) {
                     GameScr.currentCharViewInfo = Char.getMyChar();
                  } else {
                     Char var48;
                     if ((var48 = GameScr.gameAE(var47)) == null) {
                        GameScr.currentCharViewInfo = new Char();
                     } else {
                        GameScr.currentCharViewInfo = var48;
                     }

                     GameScr.currentCharViewInfo.charID = var47;
                     GameScr.currentCharViewInfo.statusMe = 1;
                     GameScr.gI().gameBL();
                  }

                  GameScr.currentCharViewInfo.cName = fieldAB.reader().readUTF();
                  GameScr.currentCharViewInfo.head = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cgender = fieldAB.reader().readByte();
                  byte var69 = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.nClass = GameScr.nClasss[var69];
                  GameScr.currentCharViewInfo.cPk = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.cHP = fieldAB.reader().readInt();
                  GameScr.currentCharViewInfo.cMaxHP = fieldAB.reader().readInt();
                  GameScr.currentCharViewInfo.cMP = fieldAB.reader().readInt();
                  GameScr.currentCharViewInfo.cMaxMP = fieldAB.reader().readInt();
                  GameScr.currentCharViewInfo.cspeed = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.cResFire = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cResIce = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cResWind = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cdame = fieldAB.reader().readInt();
                  GameScr.currentCharViewInfo.cdameDown = fieldAB.reader().readInt();
                  GameScr.currentCharViewInfo.cExactly = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cMiss = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cFatal = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cReactDame = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.sysUp = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.sysDown = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.clevel = fieldAB.reader().readUnsignedByte();
                  GameScr.currentCharViewInfo.pointUydanh = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.cClanName = fieldAB.reader().readUTF();
                  if (!GameScr.currentCharViewInfo.cClanName.equals("")) {
                     GameScr.currentCharViewInfo.ctypeClan = fieldAB.reader().readByte();
                  }

                  GameScr.currentCharViewInfo.pointUydanh = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointNon = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointAo = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointGangtay = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointQuan = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointGiay = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointVukhi = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointLien = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointNhan = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointNgocboi = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.pointPhu = fieldAB.reader().readShort();
                  GameScr.currentCharViewInfo.countFinishDay = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.countLoopBoos = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.countPB = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.limitTiemnangso = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.limitKynangso = fieldAB.reader().readByte();
                  GameScr.currentCharViewInfo.arrItemBody = new Item[32];

                  try {
                     GameScr.currentCharViewInfo.gameAJ();

                     for (int var70 = 0; var70 < 16; var70++) {
                        short var71;
                        if ((var71 = fieldAB.reader().readShort()) > -1) {
                           ItemTemplate var72;
                           byte var210x = (var72 = ItemTemplates.gameAA(var71)).type;
                           GameScr.currentCharViewInfo.arrItemBody[var210x] = new Item();
                           GameScr.currentCharViewInfo.arrItemBody[var210x].indexUI = var210x;
                           GameScr.currentCharViewInfo.arrItemBody[var210x].typeUI = 5;
                           GameScr.currentCharViewInfo.arrItemBody[var210x].template = var72;
                           GameScr.currentCharViewInfo.arrItemBody[var210x].isLock = true;
                           GameScr.currentCharViewInfo.arrItemBody[var210x].upgrade = fieldAB.reader().readByte();
                           GameScr.currentCharViewInfo.arrItemBody[var210x].sys = fieldAB.reader().readByte();
                           if (var210x == 1) {
                              GameScr.currentCharViewInfo.wp = GameScr.currentCharViewInfo.arrItemBody[var210x].template.part;
                           } else if (var210x == 2) {
                              GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[var210x].template.part;
                           } else if (var210x == 6) {
                              GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[var210x].template.part;
                           }
                        }
                     }
                  } catch (Exception var177) {
                  }

                  try {
                     for (int var70x = 0; var70x < 16; var70x++) {
                        short var71;
                        if ((var71 = fieldAB.reader().readShort()) > -1) {
                           ItemTemplate var72;
                           int var204 = (var72 = ItemTemplates.gameAA(var71)).type + 16;
                           GameScr.currentCharViewInfo.arrItemBody[var204] = new Item();
                           GameScr.currentCharViewInfo.arrItemBody[var204].indexUI = var204;
                           GameScr.currentCharViewInfo.arrItemBody[var204].typeUI = 5;
                           GameScr.currentCharViewInfo.arrItemBody[var204].template = var72;
                           GameScr.currentCharViewInfo.arrItemBody[var204].isLock = true;
                           GameScr.currentCharViewInfo.arrItemBody[var204].upgrade = fieldAB.reader().readByte();
                           GameScr.currentCharViewInfo.arrItemBody[var204].sys = fieldAB.reader().readByte();
                           if (var204 == 1) {
                              GameScr.currentCharViewInfo.wp = GameScr.currentCharViewInfo.arrItemBody[var204].template.part;
                           } else if (var204 == 2) {
                              GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[var204].template.part;
                           } else if (var204 == 6) {
                              GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[var204].template.part;
                           }
                        }
                     }

                     return;
                  } catch (Exception var176) {
                     return;
                  }
               case 94:
                  gameAB(fieldAB);
                  return;
               case 95: {
                  int var84 = fieldAB.reader().readInt();
                  Char var10000 = Char.getMyChar();
                  var10000.xu += var84;
                  GameScr.gameAA(var84 > 0 ? "+" + var84 : "" + var84, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 1);
                  return;
               }
               case 96:
                  Char.getMyChar()
                     .taskOrders
                     .addElement(
                        new TaskOrder(
                           fieldAB.reader().readByte(),
                           fieldAB.reader().readInt(),
                           fieldAB.reader().readInt(),
                           fieldAB.reader().readUTF(),
                           fieldAB.reader().readUTF(),
                           fieldAB.reader().readUnsignedByte(),
                           fieldAB.reader().readUnsignedByte()
                        )
                     );
                  Char.getMyChar().gameAC(21);
                  LockGame.fieldAL();
                  return;
               case 97: {
                  byte var85 = fieldAB.reader().readByte();

                  for (int var86 = 0; var86 < Char.getMyChar().taskOrders.size(); var86++) {
                     TaskOrder var87;
                     if ((var87 = (TaskOrder)Char.getMyChar().taskOrders.elementAt(var86)).taskId == var85) {
                        var87.count = fieldAB.reader().readInt();
                        if (var87.count == var87.maxCount) {
                           Char.getMyChar().gameAC(61);
                        }

                        if (var87.taskId == 0) {
                           AutoNvhn.fieldAV = true;
                        }

                        return;
                     }
                  }

                  return;
               }
               case 98: {
                  byte var85 = fieldAB.reader().readByte();

                  for (int var86 = 0; var86 < Char.getMyChar().taskOrders.size(); var86++) {
                     if (((TaskOrder)Char.getMyChar().taskOrders.elementAt(var86)).taskId == var85) {
                        Char.getMyChar().taskOrders.removeElementAt(var86);
                        break;
                     }
                  }

                  Char.getMyChar().gameAC(21);
                  LockGame.fieldAN();
                  return;
               }
               case 99:
                  Char var48;
                  if ((var48 = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     GameCanvas.gameAA(var48.cName + " " + mResources.gameQX, 88840, var48, 8882, null);
                  }

                  return;
               case 100: {
                  GameScr.vList.removeAllElements();
                  byte var185xxxx = fieldAB.reader().readByte();
                  Ranked var49 = null;

                  for (int var50 = 0; var50 < var185xxxx; var50++) {
                     try {
                        DunItem var198;
                        (var198 = new DunItem()).id = fieldAB.reader().readByte();
                        var198.name1 = fieldAB.reader().readUTF();
                        var198.name2 = fieldAB.reader().readUTF();
                        GameScr.vList.addElement(var198);
                     } catch (Exception var142) {
                     }
                  }

                  GameScr.gI().gameAR();
                  return;
               }
               case 101:
                  try {
                     GameScr.currentCharViewInfo.pointTinhTu = fieldAB.reader().readInt();
                     GameScr.currentCharViewInfo.limitPhongLoi = fieldAB.reader().readByte();
                     GameScr.currentCharViewInfo.limitBangHoa = fieldAB.reader().readByte();
                  } catch (Exception var141) {
                     var141.printStackTrace();
                  }

                  return;
               case 102:
                  Item var240;
                  if ((var240 = Char.getMyChar().arrItemBag[fieldAB.reader().readByte()]) != null) {
                     GameScr.itemSell = var240;
                  }

                  Char.getMyChar().xu = fieldAB.reader().readInt();
                  if (GameScr.itemSell != null) {
                     if (GameScr.itemSell.template.type == 16) {
                        GameScr.hpPotion = GameScr.hpPotion - GameScr.itemSell.quantity;
                     }

                     if (GameScr.itemSell.template.type == 17) {
                        GameScr.mpPotion = GameScr.mpPotion - GameScr.itemSell.quantity;
                     }

                     Char.getMyChar().arrItemBag[GameScr.itemSell.indexUI] = null;
                     GameScr.itemSell = null;
                     GameScr.gI().resetButton();
                     InfoMe.gameAA(mResources.gameVE);
                  }

                  GameCanvas.gameAJ();
                  return;
               case 103:
                  GameScr.indexMenu = fieldAB.reader().readByte();
                  GameScr.arrItemStands = new ItemStands[fieldAB.reader().readInt()];

                  for (int var79 = 0; var79 < GameScr.arrItemStands.length; var79++) {
                     GameScr.arrItemStands[var79] = new ItemStands();
                     GameScr.arrItemStands[var79].item = new Item();
                     GameScr.arrItemStands[var79].item.itemId = fieldAB.reader().readInt();
                     GameScr.arrItemStands[var79].timeStart = (int)(System.currentTimeMillis() / 1000L);
                     GameScr.arrItemStands[var79].timeEnd = fieldAB.reader().readInt();
                     GameScr.arrItemStands[var79].item.quantity = fieldAB.reader().readUnsignedShort();
                     GameScr.arrItemStands[var79].seller = fieldAB.reader().readUTF();
                     GameScr.arrItemStands[var79].price = fieldAB.reader().readInt();
                     GameScr.arrItemStands[var79].item.template = ItemTemplates.gameAA(fieldAB.reader().readShort());
                  }

                  GameScr.gI().gameAD(37);
                  return;
               case 104:
                  gameAC(fieldAB);
                  return;
               case 106:
                  Char var512;
                  if ((var512 = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     GameCanvas.gameAA(var512.cName + " " + mResources.gameVS, 88841, var512, 8882, null);
                  }

                  return;
               case 107: {
                  byte var194 = fieldAB.reader().readByte();
                  GameCanvas.gameAA(fieldAB.reader().readUTF(), 8890, new Integer(var194), 8891, null);
                  return;
               }
               case 108:
                  Char.getMyChar().gameAB(fieldAB);
                  return;
               case 109:
                  InfoDlg.gameAB();
                  GameCanvas.gameAI();
                  GameCanvas.gameAH();
                  MyVector var52 = new MyVector();

                  try {
                     byte var194x = fieldAB.reader().readByte();

                     for (int var197x = 0; var197x < var194x; var197x++) {
                        String[] var64 = new String[fieldAB.reader().readByte()];

                        for (int var65 = 0; var65 < var64.length; var65++) {
                           var64[var65] = fieldAB.reader().readUTF();
                        }

                        var52.addElement(new Command(var64[0], GameCanvas.instance, 88820, var64));
                     }
                  } catch (Exception var175) {
                  }

                  if (Char.getMyChar().npcFocus == null) {
                     return;
                  }

                  GameCanvas.menu.gameAA(var52);
                  return;
               case 112: {
                  Item var193;
                  (var193 = Char.getMyChar().arrItemBag[fieldAB.reader().readByte()]).upgrade = fieldAB.reader().readByte();
                  var193.expires = 0L;
                  return;
               }
               case 114:
                  GameScr.gI().typeba = fieldAB.reader().readByte();
                  return;
               case 116:
                  Char var53;
                  if ((var53 = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                     gameAA(var53, fieldAB);
                  }

                  return;
               case 117:
                  byte var192;
                  if ((var192 = fieldAB.reader().readByte()) == -1) {
                     GameCanvas.readMessenge.gameAA(fieldAB);
                     return;
                  }

                  if (GameCanvas.lowGraphic) {
                     return;
                  }

                  try {
                     Mob.vEggMonter.removeAllElements();
                     TileMap.itemMap.clear();
                     GameScr.vItemTreeBehind.removeAllElements();
                     GameScr.vItemTreeBetwen.removeAllElements();
                     GameScr.vItemTreeFront.removeAllElements();

                     for (int var3x = 0; var3x < var192; var3x++) {
                        short var4 = fieldAB.reader().readShort();
                        String var54 = String.valueOf((int)var4);
                        byte[] var6 = new byte[fieldAB.reader().readInt()];
                        fieldAB.reader().read(var6);
                        Image var189 = gameAA(var6);
                        TileMap.itemMap.gameAA(var54, var189);
                     }

                     int var55 = fieldAB.reader().readUnsignedByte();

                     for (int var1891 = 0; var1891 < var55; var1891++) {
                        int var197x = fieldAB.reader().readUnsignedByte();
                        int var200 = fieldAB.reader().readUnsignedByte();
                        int var204 = fieldAB.reader().readUnsignedByte();
                        ItemTree var205;
                        (var205 = new ItemTree(var200, var204)).idTree = var197x;
                        GameScr.vItemTreeBehind.addElement(var205);
                     }

                     var55 = fieldAB.reader().readUnsignedByte();

                     for (int var1901 = 0; var1901 < var55; var1901++) {
                        int var197x = fieldAB.reader().readUnsignedByte();
                        int var200 = fieldAB.reader().readUnsignedByte();
                        int var204 = fieldAB.reader().readUnsignedByte();
                        ItemTree var205;
                        (var205 = new ItemTree(var200, var204)).idTree = var197x;
                        GameScr.vItemTreeBetwen.addElement(var205);
                     }

                     var55 = fieldAB.reader().readUnsignedByte();

                     for (int var1911 = 0; var1911 < var55; var1911++) {
                        int var197x = fieldAB.reader().readUnsignedByte();
                        int var200 = fieldAB.reader().readUnsignedByte();
                        int var204 = fieldAB.reader().readUnsignedByte();
                        ItemTree var205;
                        (var205 = new ItemTree(var200, var204)).idTree = var197x;
                        GameScr.vItemTreeFront.addElement(var205);
                     }

                     return;
                  } catch (Exception var174) {
                     var174.printStackTrace();
                     return;
                  }
               case 118: {
                  String var62 = fieldAB.reader().readUTF();
                  RMS.gameAA("acc", var62);
                  String var188 = fieldAB.reader().readUTF();
                  RMS.gameAA("pass", var188);
                  SelectServerScr.uname = var62;
                  SelectServerScr.pass = var188;
                  SelectServerScr.unameChange = "";
                  SelectServerScr.passChange = "";
                  if (!var62.startsWith("tmpusr")) {
                     GameScr.gI().update();
                  }

                  Session_ME.fieldAE();
                  return;
               }
               case 119: {
                  byte var194;
                  if ((var194 = fieldAB.reader().readByte()) == -1) {
                     GameScr.isUseitemAuto = true;
                     GameScr.gameAA(true);
                     if ((GameScr.rangeSearch = fieldAB.reader().readInt()) > 360) {
                        GameScr.isAllmap = true;
                     } else {
                        GameScr.isAllmap = false;
                        GameScr.pointCenterX = Char.getMyChar().cx;
                        GameScr.pointCenterY = Char.getMyChar().cy;
                     }

                     return;
                  } else {
                     if (var194 == 0) {
                        Char var56;
                        if ((var56 = GameScr.gameAE(fieldAB.reader().readInt())) != null) {
                           ServerEffect.gameAA(141, var56.cx, var56.cy, 2);
                           short var57 = fieldAB.reader().readShort();
                           var56.cxMoveLast = var57;
                           short var58 = fieldAB.reader().readShort();
                           var56.cyMoveLast = var58;
                           ServerEffect.gameAA(141, var56.cx, var56.cy, 2);
                           return;
                        }
                     } else {
                        GameScr.isUseitemAuto = false;
                        GameScr.auto = 0;
                     }

                     return;
                  }
               }
               case 121: {
                  GameScr.vList.removeAllElements();
                  int var59 = fieldAB.reader().readUnsignedByte();
                  Ranked var60 = null;

                  for (int var61 = 0; var61 < var59; var61++) {
                     try {
                        (var60 = new Ranked()).name = fieldAB.reader().readUTF();
                        var60.id = fieldAB.reader().readInt();
                        var60.stt = fieldAB.reader().readUTF();
                        GameScr.vList.addElement(var60);
                     } catch (Exception var140) {
                     }
                  }

                  GameScr.gI().gameAQ();
                  return;
               }
               case 122:
                  byte var185xx;
                  if ((var185xx = fieldAB.reader().readByte()) == 0) {
                     gameAI(fieldAB);
                     return;
                  } else if (var185xx == 1) {
                     gameAJ(fieldAB);
                     return;
                  } else {
                     if (var185xx == 2) {
                        gameAL(fieldAB);
                     } else if (var185xx == 3) {
                        gameAK(fieldAB);
                        return;
                     }

                     return;
                  }
               case 123:
                  byte var185x;
                  if ((var185x = fieldAB.reader().readByte()) == 0) {
                     GameCanvas.isKiemduyet_info = true;
                     return;
                  } else if (var185x == 1) {
                     GameCanvas.isKiemduyet_info = false;
                     return;
                  } else {
                     if (var185x == 2) {
                        GameCanvas.isKiemduyet = true;
                        RMS.gameAA("isKiemduyet", 0);
                     } else {
                        GameCanvas.isKiemduyet = false;
                        RMS.gameAA("isKiemduyet", 1);
                     }

                     return;
                  }
               case 124:
                  gameAM(fieldAB);
                  return;
               case 125:
                  byte var185;
                  if ((var185 = fieldAB.reader().readByte()) == 0) {
                     gameAN(fieldAB);
                     return;
                  } else {
                     if (var185 == 1) {
                        gameAO(fieldAB);
                     } else if (var185 == 2) {
                        gameAP(fieldAB);
                        return;
                     }

                     return;
                  }
               case 126:
                  byte var96 = fieldAB.reader().readByte();
                  GameCanvas.gameAJ();
                  if (var96 == 0) {
                     GameScr.instance.resetButton();
                     return;
                  }
            }
         } catch (Exception var178) {
            System.out.println("ERROR COMAND: " + fieldAB.command);
            var178.printStackTrace();
         }
      } finally {
         if (fieldAB != null) {
            fieldAB.cleanup();
         }
      }
   }

   private static void gameAA(DataInputStream var0) {
      try {
         GameScr.vcItem = var0.readByte();
         GameScr.iOptionTemplates = new ItemOptionTemplate[var0.readUnsignedByte()];

         for (int var1 = 0; var1 < GameScr.iOptionTemplates.length; var1++) {
            GameScr.iOptionTemplates[var1] = new ItemOptionTemplate();
            GameScr.iOptionTemplates[var1].id = var1;
            GameScr.iOptionTemplates[var1].name = var0.readUTF();
            GameScr.iOptionTemplates[var1].type = var0.readByte();
         }

         short var4 = var0.readShort();

         for (int var2 = 0; var2 < var4; var2++) {
            ItemTemplates.gameAA(
               new ItemTemplate(
                  (short)var2,
                  var0.readByte(),
                  var0.readByte(),
                  var0.readUTF(),
                  var0.readUTF(),
                  var0.readByte(),
                  var0.readShort(),
                  var0.readShort(),
                  var0.readBoolean()
               )
            );
         }
      } catch (IOException var3) {
         var3.printStackTrace();
      }
   }

   private static void gameAB(DataInputStream var0) {
      try {
         GameScr.vcSkill = var0.readByte();
         GameScr.sOptionTemplates = new SkillOptionTemplate[var0.readByte()];

         for (int var1 = 0; var1 < GameScr.sOptionTemplates.length; var1++) {
            GameScr.sOptionTemplates[var1] = new SkillOptionTemplate();
            GameScr.sOptionTemplates[var1].id = var1;
            GameScr.sOptionTemplates[var1].name = var0.readUTF();
         }

         GameScr.nClasss = new NClass[var0.readUnsignedByte()];

         for (int var7 = 0; var7 < GameScr.nClasss.length; var7++) {
            GameScr.nClasss[var7] = new NClass();
            GameScr.nClasss[var7].classId = var7;
            GameScr.nClasss[var7].name = var0.readUTF();
            GameScr.nClasss[var7].skillTemplates = new SkillTemplate[var0.readByte()];

            for (int var2 = 0; var2 < GameScr.nClasss[var7].skillTemplates.length; var2++) {
               GameScr.nClasss[var7].skillTemplates[var2] = new SkillTemplate();
               GameScr.nClasss[var7].skillTemplates[var2].id = var0.readByte();
               GameScr.nClasss[var7].skillTemplates[var2].name = var0.readUTF();
               GameScr.nClasss[var7].skillTemplates[var2].maxPoint = var0.readByte();
               GameScr.nClasss[var7].skillTemplates[var2].type = var0.readByte();
               GameScr.nClasss[var7].skillTemplates[var2].iconId = var0.readShort();
               short var3 = 150;
               if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
                  var3 = 100;
               }

               GameScr.nClasss[var7].skillTemplates[var2].description = mFont.tahoma_7_white.gameAB(var0.readUTF(), var3);
               GameScr.nClasss[var7].skillTemplates[var2].skills = new Skill[var0.readByte()];

               for (int var5 = 0; var5 < GameScr.nClasss[var7].skillTemplates[var2].skills.length; var5++) {
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5] = new Skill();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].skillId = var0.readShort();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].template = GameScr.nClasss[var7].skillTemplates[var2];
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].point = var0.readByte();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].level = var0.readByte();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].manaUse = var0.readShort();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].coolDown = var0.readInt();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].dx = var0.readShort();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].dy = var0.readShort();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].maxFight = var0.readByte();
                  GameScr.nClasss[var7].skillTemplates[var2].skills[var5].options = new SkillOption[var0.readByte()];

                  for (int var4 = 0; var4 < GameScr.nClasss[var7].skillTemplates[var2].skills[var5].options.length; var4++) {
                     GameScr.nClasss[var7].skillTemplates[var2].skills[var5].options[var4] = new SkillOption();
                     GameScr.nClasss[var7].skillTemplates[var2].skills[var5].options[var4].param = var0.readShort();
                     GameScr.nClasss[var7].skillTemplates[var2].skills[var5].options[var4].optionTemplate = GameScr.sOptionTemplates[var0.readByte()];
                  }

                  Skills.gameAA(GameScr.nClasss[var7].skillTemplates[var2].skills[var5]);
               }
            }
         }
      } catch (IOException var6) {
         var6.printStackTrace();
      }
   }

   private static void gameAC(DataInputStream var0) {
      try {
         GameScr.vcMap = var0.readByte();
         TileMap.mapNames = new String[var0.readUnsignedByte()];

         for (int var1 = 0; var1 < TileMap.mapNames.length; var1++) {
            TileMap.mapNames[var1] = var0.readUTF();
         }

         Npc.arrNpcTemplate = new NpcTemplate[var0.readByte()];

         for (byte var4x = 0; var4x < Npc.arrNpcTemplate.length; var4x++) {
            Npc.arrNpcTemplate[var4x] = new NpcTemplate();
            Npc.arrNpcTemplate[var4x].npcTemplateId = var4x;
            Npc.arrNpcTemplate[var4x].name = var0.readUTF();
            Npc.arrNpcTemplate[var4x].headId = var0.readShort();
            Npc.arrNpcTemplate[var4x].bodyId = var0.readShort();
            Npc.arrNpcTemplate[var4x].legId = var0.readShort();
            Npc.arrNpcTemplate[var4x].menu = new String[var0.readByte()][];

            for (int var2 = 0; var2 < Npc.arrNpcTemplate[var4x].menu.length; var2++) {
               Npc.arrNpcTemplate[var4x].menu[var2] = new String[var0.readByte()];

               for (int var3 = 0; var3 < Npc.arrNpcTemplate[var4x].menu[var2].length; var3++) {
                  Npc.arrNpcTemplate[var4x].menu[var2][var3] = var0.readUTF();
               }
            }
         }

         short var5;
         Mob.arrMobTemplate = new MobTemplate[var5 = var0.readShort()];

         for (int var2 = 0; var2 < var5; var2++) {
            Mob.arrMobTemplate[var2] = new MobTemplate();
            Mob.arrMobTemplate[var2].mobTemplateId = (short)var2;
            Mob.arrMobTemplate[var2].type = var0.readByte();
            Mob.arrMobTemplate[var2].name = var0.readUTF();
            Mob.arrMobTemplate[var2].hp = var0.readInt();
            Mob.arrMobTemplate[var2].rangeMove = var0.readByte();
            Mob.arrMobTemplate[var2].speed = var0.readByte();
         }
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }

   private static void gameAD(DataInputStream var0) {
      try {
         GameScr.vcData = var0.readByte();
         RMS.gameAA("nj_arrow", NinjaUtil.gameAA(var0));
         RMS.gameAA("nj_effect", NinjaUtil.gameAA(var0));
         RMS.gameAA("nj_image", NinjaUtil.gameAA(var0));
         RMS.gameAA("nj_part", NinjaUtil.gameAA(var0));
         RMS.gameAA("nj_skill", NinjaUtil.gameAA(var0));
         GameScr.mapTasks = new byte[(GameScr.tasks = new byte[var0.readByte()][]).length][];

         for (int var1 = 0; var1 < GameScr.tasks.length; var1++) {
            GameScr.tasks[var1] = new byte[var0.readByte()];
            GameScr.mapTasks[var1] = new byte[GameScr.tasks[var1].length];

            for (int var2 = 0; var2 < GameScr.tasks[var1].length; var2++) {
               GameScr.tasks[var1][var2] = var0.readByte();
               GameScr.mapTasks[var1][var2] = var0.readByte();
            }
         }

         GameScr.exps = new long[var0.readUnsignedByte()];

         for (int var4 = 0; var4 < GameScr.exps.length; var4++) {
            GameScr.exps[var4] = var0.readLong();
         }

         GameScr.crystals = new int[var0.readByte()];

         for (int var5 = 0; var5 < GameScr.crystals.length; var5++) {
            GameScr.crystals[var5] = var0.readInt();
         }

         GameScr.upClothe = new int[var0.readByte()];

         for (int var6 = 0; var6 < GameScr.upClothe.length; var6++) {
            GameScr.upClothe[var6] = var0.readInt();
         }

         GameScr.upClothe = ensureLen(GameScr.upClothe, 21);
         GameScr.upAdorn = new int[var0.readByte()];

         for (int var7 = 0; var7 < GameScr.upAdorn.length; var7++) {
            GameScr.upAdorn[var7] = var0.readInt();
         }

         GameScr.upAdorn = ensureLen(GameScr.upAdorn, 21);
         GameScr.upWeapon = new int[var0.readByte()];

         for (int var8 = 0; var8 < GameScr.upWeapon.length; var8++) {
            GameScr.upWeapon[var8] = var0.readInt();
         }

         GameScr.upWeapon = ensureLen(GameScr.upWeapon, 21);
         GameScr.coinUpCrystals = new int[var0.readByte()];

         for (int var9 = 0; var9 < GameScr.coinUpCrystals.length; var9++) {
            GameScr.coinUpCrystals[var9] = var0.readInt();
         }

         GameScr.coinUpClothes = new int[var0.readByte()];

         for (int var10 = 0; var10 < GameScr.coinUpClothes.length; var10++) {
            GameScr.coinUpClothes[var10] = var0.readInt();
         }

         GameScr.coinUpClothes = ensureLen(GameScr.coinUpClothes, 21);
         GameScr.coinUpAdorns = new int[var0.readByte()];

         for (int var11 = 0; var11 < GameScr.coinUpAdorns.length; var11++) {
            GameScr.coinUpAdorns[var11] = var0.readInt();
         }

         GameScr.coinUpAdorns = ensureLen(GameScr.coinUpAdorns, 21);
         GameScr.coinUpWeapons = new int[var0.readByte()];

         for (int var12 = 0; var12 < GameScr.coinUpWeapons.length; var12++) {
            GameScr.coinUpWeapons[var12] = var0.readInt();
         }

         GameScr.coinUpWeapons = ensureLen(GameScr.coinUpWeapons, 21);
         GameScr.goldUps = new int[var0.readByte()];

         for (int var13 = 0; var13 < GameScr.goldUps.length; var13++) {
            GameScr.goldUps[var13] = var0.readInt();
         }

         GameScr.goldUps = ensureLen(GameScr.goldUps, 21);
         GameScr.maxPercents = new int[var0.readByte()];

         for (int var14 = 0; var14 < GameScr.maxPercents.length; var14++) {
            GameScr.maxPercents[var14] = var0.readInt();
         }

         GameScr.maxPercents = ensureLen(GameScr.maxPercents, 21);
         EffectBuff.effTemplates = new EffectTemplate[var0.readByte()];

         for (int var15 = 0; var15 < EffectBuff.effTemplates.length; var15++) {
            EffectBuff.effTemplates[var15] = new EffectTemplate();
            EffectBuff.effTemplates[var15].id = var0.readByte();
            EffectBuff.effTemplates[var15].type = var0.readByte();
            var0.readUTF();
            EffectBuff.effTemplates[var15].iconId = var0.readShort();
         }
      } catch (IOException var3) {
         var3.printStackTrace();
      }
   }

   public static Image gameAA(byte[] var0) {
      try {
         return Image.createImage(var0, 0, var0.length);
      } catch (Exception var2) {
         return null;
      }
   }

   private void gameAD(Message var1) {
      try {
         Auto.fieldAB();
         Auto.fieldAC();
         Auto.fieldAM = false;
         Char fieldAG;
         (fieldAG = Char.getMyChar()).fieldAB = null;
         Char var10000 = Char.getMyChar();
         Char.getMyChar();
         var10000.cx = fieldAG.cxSend = var1.reader().readShort();
         Char.getMyChar();
         fieldAG.cy = fieldAG.cySend = var1.reader().readShort();
         byte var10 = var1.reader().readByte();

         for (int var2 = 0; var2 < var10; var2++) {
            TileMap.vGo.addElement(new Waypoint(var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort()));
         }

         Auto.fieldAB();
         var10 = var1.reader().readByte();

         for (byte byte2 = 0; byte2 < var10; byte2++) {
            GameScr.fieldAA(
               new Mob(
                  byte2,
                  var1.reader().readBoolean(),
                  var1.reader().readBoolean(),
                  var1.reader().readBoolean(),
                  var1.reader().readBoolean(),
                  var1.reader().readBoolean(),
                  var1.reader().readShort(),
                  var1.reader().readByte(),
                  var1.reader().readInt(),
                  var1.reader().readUnsignedByte(),
                  var1.reader().readInt(),
                  var1.reader().readShort(),
                  var1.reader().readShort(),
                  var1.reader().readByte(),
                  var1.reader().readByte(),
                  var1.reader().readBoolean(),
                  false
               ),
               byte2
            );
         }

         var10 = var1.reader().readByte();

         for (int var11 = 0; var11 < var10; var11++) {
            GameScr.vBuNhin.addElement(new BuNhin(var1.reader().readUTF(), var1.reader().readShort(), var1.reader().readShort()));
         }

         var10 = var1.reader().readByte();

         for (int var18 = 0; var18 < var10; var18++) {
            GameScr.vNpc.addElement(new Npc(var18, var1.reader().readByte(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readByte()));
         }

         var10 = var1.reader().readByte();

         for (int var19 = 0; var19 < var10; var19++) {
            ItemMap var12 = new ItemMap(var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort());
            boolean var4 = false;

            for (int var5 = 0; var5 < GameScr.vItemMap.size(); var5++) {
               if (((ItemMap)GameScr.vItemMap.elementAt(var5)).itemMapID == var12.itemMapID) {
                  var4 = true;
                  break;
               }
            }

            if (!var4) {
               GameScr.vItemMap.addElement(var12);
            }
         }

         GameScr.gameAA(false);

         try {
            TileMap.mapName1 = null;
            TileMap.mapName = TileMap.mapName1 = var1.reader().readUTF();
         } catch (Exception var11) {
         }

         try {
            TileMap.locationStand.clear();
            int var20 = var1.reader().readUnsignedByte();

            for (int var13x = 0; var13x < var20; var13x++) {
               int var14 = var1.reader().readUnsignedByte();
               int var5x = var1.reader().readUnsignedByte();
               String var6 = String.valueOf((short)(var5x * TileMap.tmw + var14));
               TileMap.locationStand.gameAA(var6, "location");
            }
         } catch (Exception var12) {
            var12.printStackTrace();
         }

         TileMap.gameAA(TileMap.tileID);
         Char.getMyChar().cvx = 0;
         Char.getMyChar().statusMe = 4;
         GameScr.gI().gameAP();
         GameCanvas.setMaxTextLenght(TileMap.bgID);
         Char.isLockKey = false;
         Char.ischangingMap = false;
         GameCanvas.gameAI();
         GameCanvas.gameAH();
         if (!TileMap.fieldBE || TileMap.fieldBD == TileMap.mapID) {
            GameScr.gI().update();
            InfoDlg.gameAB();
            InfoDlg.gameAA(TileMap.mapName, mResources.gameRC + " " + TileMap.zoneID, 30);
            Party.gameAA();
            GameCanvas.gameAJ();
         }

         Session_ME.fieldAE();
         GameCanvas.isLoading = false;
      } catch (Exception var13) {
      }

      TileMap.fieldAG();
   }

   private void gameAE(Message var1) {
      try {
         short var42;
         switch (var1.reader().readByte()) {
            case -127:
            case -125:
            case -124:
            case -118:
            case -110:
            case -107:
            case -105:
            case -104:
            case -103:
            case -102:
            case -101:
            case -100:
            case -94:
            case -92:
            case -91:
            case -89:
            case -87:
            case -85:
            case -82:
            case -79:
            case -78:
            case -76:
            case -75:
            case -74:
            case -73:
            case -71:
            case -69:
            case -68:
            case -65:
            case -64:
            case -63:
            case -61:
            case -60:
            default:
               return;
            case -126:
               byte var36 = var1.reader().readByte();
               LoginScr.isLoggingIn = false;
               SelectCharScr var49;
               (var49 = SelectCharScr.gameAF()).name = new String[3];
               var49.parthead = new int[3];
               var49.partleg = new int[3];
               var49.partbody = new int[3];
               var49.partWp = new int[3];
               var49.level = new int[3];
               var49.phai = new String[3];
               var49.gender = new byte[3];
               if (GameCanvas.isTouch) {
                  var49.indexSelect = -1;
               } else {
                  var49.indexSelect = 0;
               }

               GameScr.gI();
               GameScr.gameAJ();
               SmallImage.gameAD();

               for (byte var57 = 0; var57 < var36; var57++) {
                  SelectCharScr.gameAF().gender[var57] = var1.reader().readByte();
                  SelectCharScr.gameAF().name[var57] = var1.reader().readUTF();
                  SelectCharScr.gameAF().phai[var57] = var1.reader().readUTF();
                  SelectCharScr.gameAF().level[var57] = var1.reader().readUnsignedByte();
                  SelectCharScr.gameAF().parthead[var57] = var1.reader().readShort();
                  SelectCharScr.gameAF().partWp[var57] = var1.reader().readShort();
                  SelectCharScr.gameAF().partbody[var57] = var1.reader().readShort();
                  SelectCharScr.gameAF().partleg[var57] = var1.reader().readShort();
                  if (SelectCharScr.gameAF().partWp[var57] == -1) {
                     SelectCharScr.gameAF().partWp[var57] = 15;
                  }

                  if (SelectCharScr.gameAF().partbody[var57] == -1) {
                     if (SelectCharScr.gameAF().gender[var57] == 0) {
                        SelectCharScr.gameAF().partbody[var57] = 10;
                     } else {
                        SelectCharScr.gameAF().partbody[var57] = 1;
                     }
                  }

                  if (SelectCharScr.gameAF().partleg[var57] == -1) {
                     if (SelectCharScr.gameAF().gender[var57] == 0) {
                        SelectCharScr.gameAF().partleg[var57] = 9;
                     } else {
                        SelectCharScr.gameAF().partleg[var57] = 0;
                     }
                  }
               }

               SelectCharScr.gameAF().update();
               GameCanvas.gameAJ();
               Session_ME.fieldAE();
               String varSel = SelectCharScr.fieldAK;
               if (varSel == null || varSel.length() == 0) {
                  SelectCharScr varSC = SelectCharScr.gameAF();
                  if (varSC != null && varSC.name != null) {
                     for (int i = 0; i < varSC.name.length; i++) {
                        if (varSC.name[i] != null && varSC.name[i].length() > 0) {
                           varSel = varSC.name[i];
                           break;
                        }
                     }
                  }
               }

               if (varSel != null && varSel.length() > 0) {
                  Service.gI().selectCharToPlay(varSel);
               }

               return;
            case -123:
               GameScr.vsData = var1.reader().readByte();
               GameScr.vsMap = var1.reader().readByte();
               GameScr.vsSkill = var1.reader().readByte();
               GameScr.vsItem = var1.reader().readByte();
               System.out.println("****** DATA VERSION: Server " + GameScr.vsData + " Client " + GameScr.vcData);
               System.out.println("****** MAP VERSION: Server " + GameScr.vsMap + " Client " + GameScr.vcMap);
               System.out.println("****** SKILL VERSION: Server " + GameScr.vsSkill + " Client " + GameScr.vcSkill);
               System.out.println("****** ITEM VERSION: Server " + GameScr.vsItem + " Client " + GameScr.vcItem);
               if (GameScr.vsData != GameScr.vcData) {
                  Service.gI().updateData();
               } else {
                  try {
                     gameAD(new DataInputStream(new ByteArrayInputStream(RMS.gameAA("data"))));
                  } catch (Exception var48) {
                     GameScr.vcData = -1;
                     Service.gI().updateData();
                  }
               }

               if (GameScr.vsMap != GameScr.vcMap) {
                  Service.gI().updateMap();
               } else {
                  try {
                     gameAC(new DataInputStream(new ByteArrayInputStream(RMS.gameAA("map"))));
                  } catch (Exception var471) {
                     GameScr.vcMap = -1;
                     Service.gI().updateMap();
                  }
               }

               if (GameScr.vsSkill != GameScr.vcSkill) {
                  Service.gI().updateSkill();
               } else {
                  try {
                     gameAB(new DataInputStream(new ByteArrayInputStream(RMS.gameAA("skill"))));
                  } catch (Exception var46) {
                     GameScr.vcSkill = -1;
                     Service.gI().updateSkill();
                  }
               }

               if (GameScr.vsItem != GameScr.vcItem) {
                  Service.gI().updateItem();
               } else {
                  try {
                     gameAA(new DataInputStream(new ByteArrayInputStream(RMS.gameAA("item"))));
                  } catch (Exception var45) {
                     GameScr.vcItem = -1;
                     Service.gI().updateItem();
                  }
               }

               if (GameScr.vsData == GameScr.vcData && GameScr.vsMap == GameScr.vcMap && GameScr.vsSkill == GameScr.vcSkill && GameScr.vsItem == GameScr.vcItem
                  )
                {
                  GameScr.gI();
                  GameScr.gameAK();
                  GameScr.gI();
                  GameScr.gameAL();
                  GameScr.gI();
                  GameScr.gameAM();
                  Service.gI().clientOk();
               }

               CharPartInfo.gameAA(var1);
               return;
            case -122:
               System.out.println("GET UPDATE_DATA " + var1.reader().available() + " bytes");
               var1.reader().mark(100000);
               gameAD(var1.reader());
               var1.reader().reset();
               byte[] var55 = new byte[var1.reader().available()];
               var1.reader().readFully(var55);
               RMS.gameAA("data", var55);
               byte[] var53 = new byte[]{GameScr.vcData};
               RMS.gameAA("dataVersion", var53);
               if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem
                  )
                {
                  return;
               }

               GameScr.gI();
               GameScr.gameAK();
               GameScr.gI();
               GameScr.gameAL();
               GameScr.gI();
               GameScr.gameAM();
               Service.gI().clientOk();
               return;
            case -121:
               System.out.println("GET UPDATE_MAP " + var1.reader().available() + " bytes");
               var1.reader().mark(100000);
               gameAC(var1.reader());
               var1.reader().reset();
               byte[] var56 = new byte[var1.reader().available()];
               var1.reader().readFully(var56);
               RMS.gameAA("map", var56);
               byte[] var58 = new byte[]{GameScr.vcMap};
               RMS.gameAA("mapVersion", var58);
               if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem
                  )
                {
                  return;
               }

               GameScr.gI();
               GameScr.gameAK();
               GameScr.gI();
               GameScr.gameAL();
               GameScr.gI();
               GameScr.gameAM();
               Service.gI().clientOk();
               return;
            case -120:
               System.out.println("GET UPDATE_SKILL " + var1.reader().available() + " bytes");
               var1.reader().mark(100000);
               gameAB(var1.reader());
               var1.reader().reset();
               byte[] var59 = new byte[var1.reader().available()];
               var1.reader().readFully(var59);
               if (Char.getMyChar().gameBA()) {
                  RMS.gameAA("skill", var59);
               } else {
                  RMS.gameAA("skillnhanban", var59);
               }

               byte[] var61 = new byte[]{GameScr.vcSkill};
               RMS.gameAA("skillVersion", var61);
               if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem
                  )
                {
                  return;
               }

               GameScr.gI();
               GameScr.gameAK();
               GameScr.gI();
               GameScr.gameAL();
               GameScr.gI();
               GameScr.gameAM();
               Service.gI().clientOk();
               return;
            case -119:
               System.out.println("GET UPDATE_ITEM " + var1.reader().available() + " bytes");
               var1.reader().mark(100000);
               gameAA(var1.reader());
               var1.reader().reset();
               byte[] var63 = new byte[var1.reader().available()];
               var1.reader().readFully(var63);
               RMS.gameAA("item", var63);
               byte[] var47 = new byte[]{GameScr.vcItem};
               RMS.gameAA("itemVersion", var47);
               if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem
                  )
                {
                  return;
               }

               GameScr.gI();
               GameScr.gameAK();
               GameScr.gI();
               GameScr.gameAL();
               GameScr.gI();
               GameScr.gameAM();
               Service.gI().clientOk();
               return;
            case -117:
               Char.getMyChar().cPk = var1.reader().readByte();
               Info.gameAA(mResources.gameMF + " " + Char.getMyChar().cPk, 15, mFont.tahoma_7_yellow);
               Char.getMyChar().gameAC(21);
               return;
            case -116:
               Char.getMyChar().xu = var1.reader().readInt();
               Char.clan.coin = var1.reader().readInt();
               return;
            case -115:
               int var33xx = var1.reader().readInt();
               byte[] var52 = NinjaUtil.gameAB(var1);
               SmallImage.gameAA(var33xx, var52);
               return;
            case -114:
               if (Char.clan == null) {
                  Char.clan = new Clan();
               }

               Char.clan.gameAA(var1.reader().readUTF());
               return;
            case -113:
               if (Char.clan == null) {
                  Char.clan = new Clan();
               }

               Char.clan.name = var1.reader().readUTF();
               Char.clan.main_name = var1.reader().readUTF();
               var1.reader().readUTF();
               Char.clan.total = var1.reader().readShort();
               Char.clan.openDun = var1.reader().readByte();
               Char.clan.level = var1.reader().readByte();
               Char.clan.exp = var1.reader().readInt();
               Char.clan.expNext = var1.reader().readInt();
               Char.clan.coin = var1.reader().readInt();
               Char.clan.freeCoin = var1.reader().readInt();
               Char.clan.coinUp = var1.reader().readInt();
               Char.clan.reg_date = var1.reader().readUTF();
               Char.clan.alert = var1.reader().readUTF();
               Char.clan.use_card = var1.reader().readInt();
               Char.clan.itemLevel = var1.reader().readByte();
               return;
            case -112:
               GameScr.vClan.removeAllElements();
               var42 = var1.reader().readShort();

               for (int var41 = 0; var41 < var42; var41++) {
                  GameScr.vClan
                     .addElement(
                        new Member(
                           var1.reader().readByte(),
                           var1.reader().readByte(),
                           var1.reader().readByte(),
                           var1.reader().readUTF(),
                           var1.reader().readInt(),
                           var1.reader().readBoolean()
                        )
                     );
               }

               try {
                  for (int var72 = 0; var72 < var42; var72++) {
                     ((Member)GameScr.vClan.elementAt(var72)).pointClanWeek = var1.reader().readInt();
                  }
               } catch (Exception var491) {
               }

               GameScr.gI();
               GameScr.gameAY();
               return;
            case -111:
               Char.clan.items = new Item[30];
               byte var36x = var1.reader().readByte();

               for (int var33xxx = 0; var33xxx < var36x; var33xxx++) {
                  Char.clan.items[var33xxx] = new Item();
                  Char.clan.items[var33xxx].typeUI = 39;
                  Char.clan.items[var33xxx].indexUI = var33xxx;
                  Char.clan.items[var33xxx].quantity = var1.reader().readShort();
                  Char.clan.items[var33xxx].template = ItemTemplates.gameAA(var1.reader().readShort());
               }

               GameScr.gI().gameBO();
               byte var44 = var1.reader().readByte();

               for (int var41 = 0; var41 < var44; var41++) {
                  String var50x = var1.reader().readUTF();
                  short var43x = var1.reader().readShort();
                  short var45 = var1.reader().readShort();
                  int var51 = var1.reader().readInt();
                  String var7x = "";
                  MyVector var8 = new MyVector();
                  int var9 = -1;
                  int var10 = -1;
                  byte var11 = var1.reader().readByte();
                  if (var51 >= 0) {
                     var7x = var1.reader().readUTF();
                  } else {
                     for (int var12 = 0; var12 < var11; var12++) {
                        String var54 = var1.reader().readUTF();
                        var8.addElement(var54);
                     }

                     var9 = var1.reader().readInt();
                     var10 = var1.reader().readInt();
                  }

                  byte var60 = var1.reader().readByte();
                  GameScr.gI().gameAA(new Clan_ThanThu(var50x, var60, var43x, var45, var51, var7x, var8, var9, var10));
               }

               return;
            case -109:
               try {
                  GameCanvas.isLoading = true;
                  TileMap.maps = null;
                  TileMap.types = null;
                  System.gc();
                  TileMap.fieldAA(TileMap.mapID, var1.reader());
                  TileMap.gameAE();
                  this.gameAD(this.messWait);
               } catch (Exception var441) {
                  var441.printStackTrace();
               }

               var1.cleanup();
               this.messWait.cleanup();
               var1 = this.messWait = null;
               return;
            case -108:
               var42 = var1.reader().readShort();

               try {
                  byte var64 = var1.reader().readByte();
                  Mob.arrMobTemplate[var42].typeFly = var64;
               } catch (Exception var431) {
               }
               break;
            case -106:
               GameScr.typeActive = var1.reader().readByte();
               return;
            case -99: {
               GameCanvas.input2Dlg.gameAA(mResources.gameBO, mResources.gameBP);
               String var34 = var1.reader().readUTF();
               GameCanvas.input2Dlg
                  .gameAA(
                     var34,
                     new Command(mResources.gameBH, GameCanvas.instance, 8882, null),
                     new Command(mResources.gameBT, GameCanvas.instance, 88816, null),
                     0,
                     1
                  );
               return;
            }
            case -98:
               Char.getMyChar();
               Char.gameAY();
               return;
            case -97:
               GameCanvas.isLoading = false;
               GameCanvas.gameAJ();
               Integer var38 = new Integer(var1.reader().readInt());
               GameCanvas.inputDlg.gameAA(mResources.gameEX, new Command(mResources.gameCX, GameCanvas.instance, 88829, var38), 0);
               return;
            case -96:
               Char.getMyChar().cClanName = var1.reader().readUTF();
               Char.getMyChar().ctypeClan = 4;
               Char.getMyChar().luong = var1.reader().readInt();
               Char.getMyChar().gameAC(21);
               return;
            case -95:
               if (Char.clan != null) {
                  Char.clan.alert = var1.reader().readUTF();
               }

               return;
            case -93:
               int var33;
               if ((var33 = var1.reader().readInt()) == Char.getMyChar().charID) {
                  GameScr.vClan.removeAllElements();
                  Char.getMyChar().cClanName = "";
                  Char.getMyChar().ctypeClan = -1;
                  Char.clan = null;
               } else {
                  GameScr.vClan.removeAllElements();
                  Char var37;
                  (var37 = GameScr.gameAE(var33)).cClanName = "";
                  var37.ctypeClan = -1;
               }

               return;
            case -90:
               Char.getMyChar().xu = var1.reader().readInt();
               GameScr.gI().resetButton();
               return;
            case -88:
               GameScr.gI().resetButton();
               Item var35;
               (var35 = Char.getMyChar().arrItemBag[var1.reader().readByte()]).clearExpire();
               var35.isLock = true;
               var35.upgrade = var1.reader().readByte();
               (var35 = Char.getMyChar().arrItemBag[var1.reader().readByte()]).clearExpire();
               var35.isLock = true;
               var35.upgrade = var1.reader().readByte();
               Info.gameAA(mResources.gameRA, 20, mFont.tahoma_7b_yellow);
               return;
            case -86:
               GameCanvas.gameAJ();
               GameScr.gI().resetButton();
               InfoMe.gameAA(var1.reader().readUTF(), 20, mFont.tahoma_7_yellow);
               return;
            case -84:
               Char.pointPB = var1.reader().readShort();
               return;
            case -83:
               short var3 = var1.reader().readShort();
               short var43 = var1.reader().readShort();
               byte var5 = var1.reader().readByte();
               short var6 = var1.reader().readShort();
               if (var3 == 0) {
                  GameScr.gI().gameAA(mResources.gameET, "          " + mResources.gameSO, false);
                  return;
               }

               String var7 = mResources.gameEI + ": " + var3 + "\n\n";
               if (var43 == 0) {
                  var7 = var7 + mResources.gameEL + "\n\n";
               } else {
                  var7 = var7 + mResources.gameEM + ": " + NinjaUtil.gameAB(var43) + "\n\n";
               }

               var7 = var7 + mResources.gameEN + ": " + var5 + "\n\n";
               var7 = var7 + mResources.gameFF + ": " + var6 + " " + mResources.gameFG + "\n\n";
               GameScr.gI().gameAA(mResources.gameET, var7, false);
               if (var6 <= 0) {
                  return;
               }

               GameScr.gI().left = new Command(mResources.gameFF, 1000);
               return;
            case -81:
               Char.pointChienTruong = var1.reader().readShort();
               return;
            case -80:
               GameScr.gI().gameAA(mResources.gameES, var1.reader().readUTF(), false);
               if (var1.reader().readBoolean()) {
                  GameScr.gI().left = new Command(mResources.gameFF, 2000);
                  LockGame.fieldAZ();
               }

               return;
            case -77:
               GameCanvas.setMaxTextLenght(TileMap.bgID = var1.reader().readByte());
               return;
            case -72:
               GameScr.gI().yenValue = new String[9];
               GameScr.arrItemSprin = new short[9];
               if (GameScr.indexSelect < 0 || GameScr.indexSelect > 8) {
                  GameScr.indexCard = 0;
                  GameScr.indexSelect = 0;
               }

               for (int var33x = 0; var33x < 9; var33x++) {
                  GameScr.arrItemSprin[var33x] = var1.reader().readShort();
                  GameScr.gI().yenValue[var33x] = GameScr.gI().YenCards[NinjaUtil.gameAA(9)];
               }

               GameScr.gI().left = new Command(mResources.gameBY, (IActionListener)null, 1506, null);
               GameScr.gI().timePoint = System.currentTimeMillis();
               GameScr.gI().numSprinLeft--;
               GameCanvas.gameAJ();
               return;
            case -70: {
               String var34 = var1.reader().readUTF();
               GameCanvas.gameAA(
                  NinjaUtil.replace(mResources.gameVW, "#", var34),
                  new Command(mResources.gameCH, GameCanvas.instance, 88842, null),
                  new Command(mResources.gameCU, GameCanvas.instance, 8882, null)
               );
               return;
            }
            case -67:
               Mob var4 = null;

               try {
                  var4 = Mob.gameAA(var1.reader().readUnsignedByte());
               } catch (Exception var42x) {
               }

               if (var4 == null) {
                  return;
               }

               int var33x;
               if ((var33x = var1.reader().readInt()) == Char.getMyChar().charID) {
                  GameScr.vMobSoul.addElement(new MobSoul(var4.x, var4.y, Char.getMyChar()));
                  return;
               }

               Char var2;
               if ((var2 = GameScr.gameAE(var33x)) == null) {
                  return;
               }

               GameScr.vMobSoul.addElement(new MobSoul(var4.x, var4.y, var2));
               return;
            case -66:
               int var645 = var1.reader().readInt();
               if (Char.getMyChar().charID == var645) {
                  GameScr.vMobSoul.addElement(new MobSoul(Char.getMyChar().cx, Char.getMyChar().cy));
                  return;
               }

               Char var66;
               if ((var66 = GameScr.gameAE(var645)) == null) {
                  return;
               }

               GameScr.vMobSoul.addElement(new MobSoul(var66.cx, var66.cy));
               return;
            case -62:
               Char.clan.itemLevel = var1.reader().readByte();
               return;
         }

         byte var36x = var1.reader().readByte();
         Mob.arrMobTemplate[var42].imgs = new Image[var36x];
         if (var42 != 98 && var42 != 99) {
            for (int var41 = 0; var41 < Mob.arrMobTemplate[var42].imgs.length; var41++) {
               Mob.arrMobTemplate[var42].imgs[var41] = gameAA(NinjaUtil.gameAB(var1));
            }
         } else {
            Mob.arrMobTemplate[var42].imgs = new Image[3];
            Image var39 = gameAA(NinjaUtil.gameAB(var1));

            for (int var40 = 0; var40 < Mob.arrMobTemplate[var42].imgs.length; var40++) {
               Mob.arrMobTemplate[var42].imgs[var40] = var39;
            }
         }

         if (var1.reader().readBoolean()) {
            var36x = var1.reader().readByte();
            Mob.arrMobTemplate[var42].frameBossMove = new byte[var36x];

            for (int var40 = 0; var40 < var36x; var40++) {
               Mob.arrMobTemplate[var42].frameBossMove[var40] = var1.reader().readByte();
            }

            var36x = var1.reader().readByte();
            Mob.arrMobTemplate[var42].frameBossAttack = new byte[var36x][];

            for (int var69 = 0; var69 < var36x; var69++) {
               Mob.arrMobTemplate[var42].frameBossAttack[var69] = new byte[var1.reader().readByte()];

               for (int var46 = 0; var46 < Mob.arrMobTemplate[var42].frameBossAttack[var69].length; var46++) {
                  Mob.arrMobTemplate[var42].frameBossAttack[var69][var46] = var1.reader().readByte();
               }
            }
         }

         if (var1.reader().readInt() > 0) {
            if (var42 < 236) {
               gameAA(var1, var42);
            } else {
               gameAB(var1, var42);
            }
         }
      } catch (Exception var50) {
      } finally {
         if (var1 != null) {
            var1.cleanup();
         }
      }
   }

   private static void gameAF(Message var0) {
      try {
         switch (var0.reader().readByte()) {
            case -124:
               System.out.println("SEND SMS");
               String var1 = var0.reader().readUTF();
               SendSMS.gameAA(
                  var0.reader().readUTF(),
                  "sms://" + var1,
                  new Command("", GameCanvas.gameAA(), 88825, null),
                  new Command("", GameCanvas.gameAA(), 88826, null)
               );
               break;
            case 2:
               RMS.gameAA();
         }
      } catch (Exception var5) {
      } finally {
         if (var0 != null) {
            var0.cleanup();
         }
      }
   }

   private void gameAG(Message var1) {
      try {
         try {
            byte var42 = var1.reader().readByte();
            boolean var2 = false;
            switch (var42) {
               case -128:
                  Char var50xx;
                  if ((var50xx = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var50xx.cHP = var1.reader().readInt();
                     var50xx.cMaxHP = var1.reader().readInt();
                     var50xx.clevel = var1.reader().readUnsignedByte();
                     return;
                  }

                  return;
               case -127: {
                  GameScr.vCharInMap.removeAllElements();
                  GameScr.vItemMap.removeAllElements();
                  GameScr.gameBD();
                  GameScr.currentCharViewInfo = Char.getMyChar();
                  Char.getMyChar().charID = var1.reader().readInt();
                  Char.getMyChar().cClanName = var1.reader().readUTF();
                  if (!Char.getMyChar().cClanName.equals("")) {
                     Char.getMyChar().ctypeClan = var1.reader().readByte();
                  }

                  Char.getMyChar().ctaskId = var1.reader().readByte();
                  Char.getMyChar().cgender = var1.reader().readByte();
                  Char.getMyChar().head = var1.reader().readShort();
                  Char.getMyChar().cspeed = var1.reader().readByte();
                  Char.getMyChar().cName = var1.reader().readUTF();
                  Char.getMyChar().cPk = var1.reader().readByte();
                  Char.getMyChar().cTypePk = var1.reader().readByte();
                  Char.getMyChar().cMaxHP = var1.reader().readInt();
                  Char.getMyChar().cHP = var1.reader().readInt();
                  Char.getMyChar().cMaxMP = var1.reader().readInt();
                  Char.getMyChar().cMP = var1.reader().readInt();
                  Char.getMyChar().cEXP = var1.reader().readLong();
                  Char.getMyChar().cExpDown = var1.reader().readLong();
                  GameScr.gameAA(Char.getMyChar().cEXP, true);
                  Char.getMyChar().eff5BuffHp = var1.reader().readShort();
                  Char.getMyChar().eff5BuffMp = var1.reader().readShort();
                  Char.getMyChar().nClass = GameScr.nClasss[var1.reader().readByte()];
                  Char.getMyChar().pPoint = var1.reader().readShort();
                  Char.getMyChar().potential[0] = var1.reader().readShort();
                  Char.getMyChar().potential[1] = var1.reader().readShort();
                  Char.getMyChar().potential[2] = var1.reader().readInt();
                  Char.getMyChar().potential[3] = var1.reader().readInt();
                  Char.getMyChar().sPoint = var1.reader().readShort();
                  Char.getMyChar().vSkill.removeAllElements();
                  Char.getMyChar().vSkillFight.removeAllElements();
                  byte var44 = var1.reader().readByte();

                  for (byte var4 = 0; var4 < var44; var4++) {
                     Skill var3x = Skills.gameAA(var1.reader().readShort());
                     if (Char.getMyChar().myskill == null) {
                        Char.getMyChar().myskill = var3x;
                     }

                     if (Code.fieldAB != null && Auto.fieldAL != null && var3x.template.id == Auto.fieldAL.template.id) {
                        Auto.fieldAL = var3x;
                     }

                     Char.getMyChar().vSkill.addElement(var3x);
                     if ((var3x.template.type == 1 || var3x.template.type == 4 || var3x.template.type == 2 || var3x.template.type == 3)
                        && (var3x.template.maxPoint == 0 || var3x.template.maxPoint > 0 && var3x.point > 0)) {
                        byte var10000 = var3x.template.id;
                        Char.getMyChar();
                        if (var10000 == 0) {
                           Service var73x = Service.gI();
                           Char.getMyChar();
                           var73x.selectSkill(0);
                        }

                        Char.getMyChar().vSkillFight.addElement(var3x);
                     }
                  }

                  GameScr.gI();
                  GameScr.gameAZ();
                  Char.getMyChar().xu = var1.reader().readInt();
                  Char.getMyChar().yen = var1.reader().readInt();
                  Char.getMyChar().luong = var1.reader().readInt();
                  Char.getMyChar().arrItemBag = new Item[var1.reader().readUnsignedByte()];
                  GameScr.mpPotion = 0;
                  GameScr.hpPotion = 0;

                  for (int var54 = 0; var54 < Char.getMyChar().arrItemBag.length; var54++) {
                     short var64;
                     if ((var64 = var1.reader().readShort()) != -1) {
                        Char.getMyChar().arrItemBag[var54] = new Item();
                        Char.getMyChar().arrItemBag[var54].typeUI = 3;
                        Char.getMyChar().arrItemBag[var54].indexUI = var54;
                        Char.getMyChar().arrItemBag[var54].template = ItemTemplates.gameAA(var64);
                        Char.getMyChar().arrItemBag[var54].isLock = var1.reader().readBoolean();
                        if (Char.getMyChar().arrItemBag[var54].isTypeBody()
                           || Char.getMyChar().arrItemBag[var54].isTypeMounts()
                           || Char.getMyChar().arrItemBag[var54].isTypeNgocKham()) {
                           Char.getMyChar().arrItemBag[var54].upgrade = var1.reader().readByte();
                        }

                        Char.getMyChar().arrItemBag[var54].isExpires = var1.reader().readBoolean();
                        Char.getMyChar().arrItemBag[var54].quantity = var1.reader().readUnsignedShort();
                        if (Char.getMyChar().arrItemBag[var54].template.type == 16) {
                           GameScr.hpPotion = GameScr.hpPotion + Char.getMyChar().arrItemBag[var54].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var54].template.type == 17) {
                           GameScr.mpPotion = GameScr.mpPotion + Char.getMyChar().arrItemBag[var54].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var54].template.id == 340) {
                           GameScr var74 = GameScr.gI();
                           var74.numSprinLeft = var74.numSprinLeft + Char.getMyChar().arrItemBag[var54].quantity;
                        }
                     }
                  }

                  Code.fieldAL();
                  Char.getMyChar().arrItemBody = new Item[32];

                  try {
                     Char.getMyChar().gameAJ();

                     for (int var160 = 0; var160 < 16; var160++) {
                        short var64;
                        if ((var64 = var1.reader().readShort()) != -1) {
                           ItemTemplate var71;
                           var42 = (var71 = ItemTemplates.gameAA(var64)).type;
                           Char.getMyChar().arrItemBody[var42] = new Item();
                           Char.getMyChar().arrItemBody[var42].indexUI = var42;
                           Char.getMyChar().arrItemBody[var42].typeUI = 5;
                           Char.getMyChar().arrItemBody[var42].template = var71;
                           Char.getMyChar().arrItemBody[var42].isLock = true;
                           Char.getMyChar().arrItemBody[var42].upgrade = var1.reader().readByte();
                           Char.getMyChar().arrItemBody[var42].sys = var1.reader().readByte();
                           if (var42 == 1) {
                              Char.getMyChar().wp = Char.getMyChar().arrItemBody[var42].template.part;
                           } else if (var42 == 2) {
                              Char.getMyChar().body = Char.getMyChar().arrItemBody[var42].template.part;
                           } else if (var42 == 6) {
                              Char.getMyChar().leg = Char.getMyChar().arrItemBody[var42].template.part;
                           }
                        }
                     }
                  } catch (Exception var661) {
                     var661.printStackTrace();
                  }

                  Char.getMyChar().isHuman = var1.reader().readBoolean();
                  Char.getMyChar().isNhanban = var1.reader().readBoolean();
                  short[] var70;
                  if ((var70 = new short[]{var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort()})[0] > -1
                     )
                   {
                     Char.getMyChar().head = var70[0];
                  }

                  if (var70[1] > -1) {
                     Char.getMyChar().wp = var70[1];
                  }

                  if (var70[2] > -1) {
                     Char.getMyChar().body = var70[2];
                  }

                  if (var70[3] > -1) {
                     Char.getMyChar().leg = var70[3];
                  }

                  short[] var46x = new short[10];

                  try {
                     for (int var53x = 0; var53x < 10; var53x++) {
                        var46x[var53x] = var1.reader().readShort();
                     }
                  } catch (Exception var651) {
                     var46x = null;
                  }

                  if (var46x != null) {
                     Char.getMyChar().gameAA(var46x);
                  }

                  try {
                     for (int var53x = 0; var53x < 16; var53x++) {
                        short var64x;
                        if ((var64x = var1.reader().readShort()) != -1) {
                           ItemTemplate var47;
                           int var51xx = (var47 = ItemTemplates.gameAA(var64x)).type + 16;
                           Char.getMyChar().arrItemBody[var51xx] = new Item();
                           Char.getMyChar().arrItemBody[var51xx].indexUI = var51xx;
                           Char.getMyChar().arrItemBody[var51xx].typeUI = 5;
                           Char.getMyChar().arrItemBody[var51xx].template = var47;
                           Char.getMyChar().arrItemBody[var51xx].isLock = true;
                           Char.getMyChar().arrItemBody[var51xx].upgrade = var1.reader().readByte();
                           Char.getMyChar().arrItemBody[var51xx].sys = var1.reader().readByte();
                           if (var51xx == 1) {
                              Char.getMyChar().wp = Char.getMyChar().arrItemBody[var51xx].template.part;
                           } else if (var51xx == 2) {
                              Char.getMyChar().body = Char.getMyChar().arrItemBody[var51xx].template.part;
                           } else if (var51xx == 6) {
                              Char.getMyChar().leg = Char.getMyChar().arrItemBody[var51xx].template.part;
                           }
                        }
                     }
                  } catch (Exception var641) {
                     var641.printStackTrace();
                  }

                  var2 = false;

                  short var45;
                  try {
                     var45 = var1.reader().readShort();
                  } catch (Exception var601) {
                     var45 = -1;
                  }

                  Char.getMyChar().ID_SUSANO = var45;
                  if (Char.getMyChar().isHuman) {
                     GameScr.gI();
                     GameScr.gameAG();
                  } else if (Char.getMyChar().isNhanban) {
                     GameScr.gI();
                     GameScr.gameAH();
                  }

                  Char.getMyChar().statusMe = 4;
                  GameScr.isViewClanInvite = RMS.gameAC(Char.getMyChar().cName + "vci") >= 1;
                  if (Char.getMyChar().gameBA()) {
                     gameAB(new DataInputStream(new ByteArrayInputStream(RMS.gameAA("skill"))));
                  } else {
                     gameAB(new DataInputStream(new ByteArrayInputStream(RMS.gameAA("skillnhanban"))));
                  }

                  Service.gI().loadRMS("KSkill");
                  Service.gI().loadRMS("OSkill");
                  Service.gI().loadRMS("CSkill");
                  return;
               }
               case -126:
                  Char.getMyChar().gameAA(var1);
                  Char.getMyChar().potential[0] = var1.reader().readShort();
                  Char.getMyChar().potential[1] = var1.reader().readShort();
                  Char.getMyChar().potential[2] = var1.reader().readInt();
                  Char.getMyChar().potential[3] = var1.reader().readInt();
                  Char.getMyChar().gameAC(61);
                  Char.getMyChar().nClass = GameScr.nClasss[var1.reader().readByte()];
                  Char.getMyChar().sPoint = var1.reader().readShort();
                  Char.getMyChar().pPoint = var1.reader().readShort();
                  Char.getMyChar().vSkill.removeAllElements();
                  Char.getMyChar().vSkillFight.removeAllElements();
                  Char.getMyChar().myskill = null;
                  return;
               case -125:
                  Char.getMyChar().gameAA(var1);
                  if (Char.getMyChar().statusMe != 14 && Char.getMyChar().statusMe != 5) {
                     Char.getMyChar().cHP = Char.getMyChar().cMaxHP;
                     Char.getMyChar().cMP = Char.getMyChar().cMaxMP;
                  }

                  try {
                     Char.getMyChar().sPoint = var1.reader().readShort();
                     Char.getMyChar().vSkill.removeAllElements();
                     Char.getMyChar().vSkillFight.removeAllElements();
                     byte var44x = var1.reader().readByte();

                     for (byte var77 = 0; var77 < var44x; var77++) {
                        Skill var3xx = Skills.gameAA(var1.reader().readShort());
                        if (Char.getMyChar().myskill == null) {
                           Char.getMyChar().myskill = var3xx;
                        } else if (var3xx.template.equals(Char.getMyChar().myskill.template)) {
                           Char.getMyChar().myskill = var3xx;
                        }

                        if (Code.fieldAB != null && Auto.fieldAL != null && var3xx.template.id == Auto.fieldAL.template.id) {
                           Auto.fieldAL = var3xx;
                        }

                        Char.getMyChar().vSkill.addElement(var3xx);
                        if ((var3xx.template.type == 1 || var3xx.template.type == 4 || var3xx.template.type == 2 || var3xx.template.type == 3)
                           && (var3xx.template.maxPoint == 0 || var3xx.template.maxPoint > 0 && var3xx.point > 0)) {
                           byte var10000 = var3xx.template.id;
                           Char.getMyChar();
                           if (var10000 == 0) {
                              Service var73x = Service.gI();
                              Char.getMyChar();
                              var73x.selectSkill(0);
                           }

                           Char.getMyChar().vSkillFight.addElement(var3xx);
                        }
                     }

                     GameScr.gI();
                     GameScr.gameAZ();
                     if (GameScr.isPaintInfoMe) {
                        GameScr.indexRow = -1;
                        GameScr.gI().gameBJ();
                     }

                     System.out.println("LOAD XONG ME LOAD SKILL " + Char.getMyChar().vSkill.size());
                  } catch (Exception var671) {
                     var671.printStackTrace();
                  }

                  LockGame.fieldAV();
                  return;
               case -124:
                  Char.getMyChar().gameAA(var1);
                  Char.getMyChar().cEXP = var1.reader().readLong();
                  GameScr.gameAA(Char.getMyChar().cEXP, true);
                  Char.getMyChar().sPoint = var1.reader().readShort();
                  Char.getMyChar().pPoint = var1.reader().readShort();
                  Char.getMyChar().potential[0] = var1.reader().readShort();
                  Char.getMyChar().potential[1] = var1.reader().readShort();
                  Char.getMyChar().potential[2] = var1.reader().readInt();
                  Char.getMyChar().potential[3] = var1.reader().readInt();
                  return;
               case -123:
                  Char.getMyChar().xu = var1.reader().readInt();
                  Char.getMyChar().yen = var1.reader().readInt();
                  Char.getMyChar().luong = var1.reader().readInt();
                  Char.getMyChar().cHP = var1.reader().readInt();
                  Char.getMyChar().cMP = var1.reader().readInt();
                  if (var1.reader().readByte() == 1) {
                     GameScr.gI().gameBN();
                     Char.getMyChar().isCaptcha = true;
                  } else {
                     Char.getMyChar().isCaptcha = false;
                  }

                  LockGame.fieldAJ();
                  return;
               case -122:
                  Char.getMyChar().cHP = var1.reader().readInt();
                  return;
               case -121:
                  Char.getMyChar().cMP = var1.reader().readInt();
                  return;
               case -120:
                  System.out.println("PLAYER LOAD ALL");
                  Char var50x;
                  if ((var50x = GameScr.gameAE(var1.reader().readInt())) != null) {
                     gameAA(var50x, var1);
                  }

                  return;
               case -119:
                  Char var67;
                  if ((var67 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var67.cHP = var1.reader().readInt();
                     var67.cMaxHP = var1.reader().readInt();
                     return;
                  }

                  return;
               case -118:
               case -115:
               case -114:
               case -108:
               case -103:
               case -93:
               case -88:
               case -79:
               case -70:
               case -67:
               case -66:
               case -60:
               case -53:
               case -52:
               case -51:
               case -50:
               case -49:
               case -48:
               case -47:
               case -46:
               case -45:
               case -44:
               case -43:
               case -42:
               case -41:
               case -40:
               case -39:
               case -38:
               case -37:
               case -36:
               case -35:
               case -34:
               case -33:
               case -32:
               case -31:
               case -30:
               case -29:
               case -28:
               case -27:
               case -26:
               case -25:
               case -24:
               case -23:
               case -22:
               case -21:
               case -20:
               case -19:
               case -18:
               case -17:
               case -16:
               case -15:
               case -14:
               case -13:
               case -12:
               case -11:
               case -10:
               case -9:
               case -8:
               case -7:
               case -6:
               case -5:
               case -4:
               case -3:
               case -2:
               case -1:
               case 0:
               case 1:
               case 2:
               case 3:
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
               case 9:
               case 10:
               case 11:
               case 12:
               case 13:
               case 14:
               case 15:
               case 16:
               case 17:
               case 18:
               case 19:
               case 20:
               case 21:
               case 22:
               case 23:
               case 24:
               case 25:
               case 26:
               case 27:
               case 28:
               case 29:
               case 30:
               case 31:
               case 32:
               case 33:
               case 34:
               case 35:
               case 36:
               case 37:
               case 38:
               case 39:
               case 40:
               case 41:
               case 42:
               case 43:
               case 44:
               case 45:
               case 46:
               case 47:
               case 48:
               case 49:
               case 50:
               case 51:
               case 52:
               case 53:
               case 54:
               case 55:
               case 56:
               case 57:
               case 58:
               case 59:
               case 60:
               case 61:
               case 62:
               case 63:
               case 64:
               case 65:
               case 66:
               case 67:
               case 68:
               case 69:
               case 70:
               case 71:
               case 72:
               case 73:
               case 74:
               case 75:
               case 76:
               case 77:
               case 78:
               case 79:
               case 80:
               case 81:
               case 82:
               case 83:
               case 84:
               case 85:
               case 86:
               case 87:
               case 88:
               case 89:
               case 90:
               case 91:
               case 92:
               case 93:
               case 94:
               case 95:
               case 96:
               case 97:
               case 98:
               case 99:
               case 100:
               case 101:
               case 102:
               case 103:
               case 104:
               case 105:
               case 106:
               case 107:
               case 108:
               case 109:
               case 110:
               case 111:
               case 112:
               case 113:
               case 114:
               default:
                  return;
               case -117:
                  Char var68;
                  if ((var68 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var68.cHP = var1.reader().readInt();
                     var68.cMaxHP = var1.reader().readInt();
                     var68.eff5BuffHp = var1.reader().readShort();
                     var68.eff5BuffMp = var1.reader().readShort();
                     var68.wp = var1.reader().readShort();
                     if (var68.wp == -1) {
                        var68.gameAK();
                     }

                     return;
                  }

                  return;
               case -116:
                  Char var69;
                  if ((var69 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var69.cHP = var1.reader().readInt();
                     var69.cMaxHP = var1.reader().readInt();
                     var69.eff5BuffHp = var1.reader().readShort();
                     var69.eff5BuffMp = var1.reader().readShort();
                     var69.body = var1.reader().readShort();
                     if (var69.body == -1) {
                        var69.gameAL();
                     }

                     return;
                  }

                  return;
               case -113:
                  Char var70;
                  if ((var70 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var70.cHP = var1.reader().readInt();
                     var70.cMaxHP = var1.reader().readInt();
                     var70.eff5BuffHp = var1.reader().readShort();
                     var70.eff5BuffMp = var1.reader().readShort();
                     var70.leg = var1.reader().readShort();
                     if (var70.leg == -1) {
                        var70.gameAM();
                     }

                     return;
                  }

                  return;
               case -112:
                  Char var71;
                  if ((var71 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var71.cHP = var1.reader().readInt();
                     var71.cMaxHP = var1.reader().readInt();
                     var71.eff5BuffHp = var1.reader().readShort();
                     var71.eff5BuffMp = var1.reader().readShort();
                     return;
                  }

                  return;
               case -111:
                  Char var72;
                  if ((var72 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var72.cHP = var1.reader().readInt();
                     return;
                  }

                  return;
               case -110:
                  Char var73;
                  if ((var73 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var73.cHP = var1.reader().readInt();
                     var73.cMaxHP = var1.reader().readInt();
                     var73.cx = var73.cxMoveLast = var1.reader().readShort();
                     var73.cy = var73.cyMoveLast = var1.reader().readShort();
                     var73.statusMe = 1;
                     ServerEffect.gameAA(20, var73, 2);
                     return;
                  }

                  return;
               case -109:
                  Char.getMyChar().gameAA(var1);
                  if (Char.getMyChar().statusMe != 14 && Char.getMyChar().statusMe != 5) {
                     Char.getMyChar().cHP = Char.getMyChar().cMaxHP;
                     Char.getMyChar().cMP = Char.getMyChar().cMaxMP;
                  }

                  Char.getMyChar().pPoint = var1.reader().readShort();
                  Char.getMyChar().potential[0] = var1.reader().readShort();
                  Char.getMyChar().potential[1] = var1.reader().readShort();
                  Char.getMyChar().potential[2] = var1.reader().readInt();
                  Char.getMyChar().potential[3] = var1.reader().readInt();
                  LockGame.fieldAX();
                  return;
               case -107:
                  Char.getMyChar().gameAF();
                  return;
               case -106:
                  Char.getMyChar().gameAG();
                  return;
               case -105: {
                  int var43 = var1.reader().readInt();
                  Char var75 = Char.getMyChar();
                  var75.xu -= var43;
                  var75 = Char.getMyChar();
                  var75.xuInBox += var43;
                  return;
               }
               case -104: {
                  int var51 = var1.reader().readInt();
                  Char var75 = Char.getMyChar();
                  var75.xuInBox -= var51;
                  var75 = Char.getMyChar();
                  var75.xu += var51;
                  return;
               }
               case -102:
                  Char.getMyChar().arrItemBag[var1.reader().readByte()] = null;
                  Skill var3xx = Skills.gameAA(var1.reader().readShort());
                  Char.getMyChar().vSkill.addElement(var3xx);
                  if ((var3xx.template.type == 1 || var3xx.template.type == 4 || var3xx.template.type == 2 || var3xx.template.type == 3)
                     && (var3xx.template.maxPoint == 0 || var3xx.template.maxPoint > 0 && var3xx.point > 0)) {
                     byte var10000 = var3xx.template.id;
                     Char.getMyChar();
                     if (var10000 == 0) {
                        Service var73x = Service.gI();
                        Char.getMyChar();
                        var73x.selectSkill(0);
                     }

                     Char.getMyChar().vSkillFight.addElement(var3xx);
                  }

                  GameScr.gI();
                  GameScr.gameAZ();
                  GameScr.gI().gameAA(var3xx);
                  GameScr.gI().gameBJ();
                  InfoMe.gameAA(mResources.gameUF + " " + var3xx.template.name);
                  return;
               case -101:
                  EffectBuff var63 = new EffectBuff(
                     var1.reader().readByte(),
                     (int)(System.currentTimeMillis() / 1000L) - var1.reader().readInt(),
                     var1.reader().readInt(),
                     var1.reader().readShort()
                  );
                  Char.getMyChar().vEff.addElement(var63);
                  if (var63.template.type == 7) {
                     Char var75x = Char.getMyChar();
                     var75x.cMiss = (short)(var75x.cMiss + var63.param);
                     return;
                  } else if (var63.template.type == 12 || var63.template.type == 11) {
                     Char.getMyChar().isInvisible = true;
                     ServerEffect.gameAA(60, Char.getMyChar().cx, Char.getMyChar().cy, 1);
                     return;
                  } else if (var63.template.type == 14) {
                     GameCanvas.gameAH();
                     GameCanvas.gameAI();
                     Char.getMyChar().cx = var1.reader().readShort();
                     Char.getMyChar().cy = var1.reader().readShort();
                     Char.getMyChar().statusMe = 1;
                     Char.getMyChar().isLockMove = true;
                     ServerEffect.gameAB(76, Char.getMyChar(), var63.timeLenght);
                     return;
                  } else if (var63.template.type == 1) {
                     ServerEffect.gameAB(48, Char.getMyChar(), var63.timeLenght);
                     return;
                  } else {
                     if (var63.template.type == 2) {
                        GameCanvas.gameAH();
                        GameCanvas.gameAI();
                        Char.getMyChar().cx = var1.reader().readShort();
                        Char.getMyChar().cy = var1.reader().readShort();
                        Char.getMyChar().statusMe = 1;
                        Char.getMyChar().isLockMove = true;
                        Char.getMyChar().isLockAttack = true;
                     } else if (var63.template.type == 3) {
                        GameCanvas.gameAH();
                        GameCanvas.gameAI();
                        Char.getMyChar().cx = var1.reader().readShort();
                        Char.getMyChar().cy = var1.reader().readShort();
                        Char.getMyChar().statusMe = 1;
                        Char.isLockKey = true;
                        ServerEffect.gameAB(43, Char.getMyChar(), var63.timeLenght);
                        return;
                     }

                     return;
                  }
               case -100: {
                  EffectTemplate var74 = EffectBuff.effTemplates[var1.reader().readByte()];

                  for (int var51 = 0; var51 < Char.getMyChar().vEff.size(); var51++) {
                     EffectBuff var60;
                     if ((var60 = (EffectBuff)Char.getMyChar().vEff.elementAt(var51)).template.type == var74.type) {
                        if (var60.template.type == 7) {
                           Char var75x = Char.getMyChar();
                           var75x.cMiss = (short)(var75x.cMiss - var60.param);
                        }

                        var60.template = var74;
                        var60.timeStart = (int)(System.currentTimeMillis() / 1000L) - var1.reader().readInt();
                        var60.timeLenght = var1.reader().readInt() / 1000;
                        var60.param = var1.reader().readShort();
                        if (var60.template.type == 7) {
                           Char var75x = Char.getMyChar();
                           var75x.cMiss = (short)(var75x.cMiss + var60.param);
                        }
                        break;
                     }
                  }

                  if (!GameScr.isPaintInfoMe) {
                     GameScr.gI().resetButton();
                  }

                  return;
               }
               case -99:
                  byte var58 = var1.reader().readByte();
                  EffectBuff var60 = null;

                  for (int var53xxxx = 0; var53xxxx < Char.getMyChar().vEff.size(); var53xxxx++) {
                     if ((var60 = (EffectBuff)Char.getMyChar().vEff.elementAt(var53xxxx)).template.id == var58) {
                        if (var60.template.type == 7) {
                           Char var75x = Char.getMyChar();
                           var75x.cMiss = (short)(var75x.cMiss - var60.param);
                        }

                        Char.getMyChar().vEff.removeElementAt(var53xxxx);
                        break;
                     }
                  }

                  if (var60.template.type == 0 || var60.template.type == 12) {
                     Char.getMyChar().cHP = var1.reader().readInt();
                     Char.getMyChar().cMP = var1.reader().readInt();
                     if (var60.template.type == 0) {
                        InfoMe.gameAA(mResources.gameRX);
                     } else if (var60.template.type == 12) {
                        Char.getMyChar().isInvisible = false;
                        ServerEffect.gameAA(60, Char.getMyChar().cx, Char.getMyChar().cy, 1);
                        return;
                     }

                     return;
                  } else if (var60.template.type == 4 || var60.template.type == 13 || var60.template.type == 17) {
                     Char.getMyChar().cHP = var1.reader().readInt();
                     return;
                  } else if (var60.template.type == 23) {
                     Char.getMyChar().cHP = var1.reader().readInt();
                     Char.getMyChar().cMaxHP = var1.reader().readInt();
                     return;
                  } else if (var60.template.type == 11) {
                     Char.getMyChar().isInvisible = false;
                     ServerEffect.gameAA(60, Char.getMyChar().cx, Char.getMyChar().cy, 1);
                     return;
                  } else if (var60.template.type == 14) {
                     Char.getMyChar().isLockMove = false;
                     return;
                  } else {
                     if (var60.template.type == 2) {
                        Char.getMyChar().isLockMove = false;
                        Char.getMyChar().isLockAttack = false;
                        ServerEffect.gameAA(77, Char.getMyChar().cx, Char.getMyChar().cy - 9, 1);
                     } else if (var60.template.type == 3) {
                        Char.isLockKey = false;
                        return;
                     }

                     return;
                  }
               case -98:
                  try {
                     Char var75;
                     if ((var75 = GameScr.gameAE(var1.reader().readInt())) != null) {
                        EffectBuff var63x = new EffectBuff(
                           var1.reader().readByte(),
                           (int)(System.currentTimeMillis() / 1000L) - var1.reader().readInt(),
                           var1.reader().readInt(),
                           var1.reader().readShort()
                        );
                        var75.vEff.addElement(var63x);
                        if (var63x.template.type != 12 && var63x.template.type != 11) {
                           if (var63x.template.type == 14) {
                              var75.cx = var75.cxMoveLast = var1.reader().readShort();
                              var75.cy = var75.cyMoveLast = var1.reader().readShort();
                              var75.statusMe = 1;
                              ServerEffect.gameAB(76, var75, var63x.timeLenght);
                              return;
                           } else if (var63x.template.type == 1) {
                              ServerEffect.gameAB(48, var75, var63x.timeLenght);
                              return;
                           } else {
                              if (var63x.template.type == 2) {
                                 var75.cx = var75.cxMoveLast = var1.reader().readShort();
                                 var75.cy = var75.cyMoveLast = var1.reader().readShort();
                                 var75.statusMe = 1;
                                 var75.isLockAttack = true;
                              } else if (var63x.template.type == 3) {
                                 var75.cx = var75.cxMoveLast = var1.reader().readShort();
                                 var75.cy = var75.cyMoveLast = var1.reader().readShort();
                                 var75.statusMe = 1;
                                 ServerEffect.gameAB(43, var75, var63x.timeLenght);
                                 return;
                              }

                              return;
                           }
                        }

                        var75.isInvisible = true;
                        ServerEffect.gameAA(60, var75.cx, var75.cy, 1);
                        return;
                     }

                     return;
                  } catch (Exception var3333) {
                     return;
                  }
               case -97:
                  try {
                     Char var77;
                     if ((var77 = GameScr.gameAE(var1.reader().readInt())) == null) {
                        return;
                     }

                     EffectTemplate var78 = EffectBuff.effTemplates[var1.reader().readByte()];

                     for (int var51xx = 0; var51xx < var77.vEff.size(); var51xx++) {
                        EffectBuff var799 = (EffectBuff)var77.vEff.elementAt(var51xx);
                        if (var78.type == var78.type) {
                           var799.template = var78;
                           var799.timeStart = (int)(System.currentTimeMillis() / 1000L) - var1.reader().readInt();
                           var799.timeLenght = var1.reader().readInt() / 1000;
                           var799.param = var1.reader().readShort();
                           return;
                        }
                     }

                     return;
                  } catch (Exception var721) {
                     return;
                  }
               case -96:
                  Char var80;
                  if ((var80 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     byte var81 = var1.reader().readByte();
                     EffectBuff var63x = null;

                     for (int var54x = 0; var54x < var80.vEff.size(); var54x++) {
                        if ((var63x = (EffectBuff)var80.vEff.elementAt(var54x)).template.id == var81) {
                           var80.vEff.removeElementAt(var54x);
                           break;
                        }
                     }

                     if (var63x != null) {
                        if (var63x.template.type == 0) {
                           var80.cHP = var1.reader().readInt();
                           var80.cMP = var1.reader().readInt();
                           return;
                        } else if (var63x.template.type == 11) {
                           var80.cx = var80.cxMoveLast = var1.reader().readUnsignedShort();
                           var80.cy = var80.cyMoveLast = var1.reader().readUnsignedShort();
                           var80.isInvisible = false;
                           ServerEffect.gameAA(60, var80.cx, var80.cy, 1);
                           return;
                        } else if (var63x.template.type == 12) {
                           var80.cHP = var1.reader().readInt();
                           var80.cMP = var1.reader().readInt();
                           var80.isInvisible = false;
                           ServerEffect.gameAA(60, var80.cx, var80.cy, 1);
                           return;
                        } else if (var63x.template.type == 4 || var63x.template.type == 13 || var63x.template.type == 17) {
                           var80.cHP = var1.reader().readInt();
                           return;
                        } else {
                           if (var63x.template.type == 23) {
                              Char.getMyChar().cHP = var1.reader().readInt();
                              Char.getMyChar().cMaxHP = var1.reader().readInt();
                           } else if (var63x.template.type == 2) {
                              var80.isLockAttack = false;
                              ServerEffect.gameAA(77, var80.cx, var80.cy - 9, 1);
                              return;
                           }

                           return;
                        }
                     }

                     return;
                  }

                  return;
               case -95:
                  GameScr.gI().timeLengthMap = var1.reader().readInt();
                  GameScr.gI().timeStartMap = (int)(System.currentTimeMillis() / 1000L);
                  return;
               case -94:
                  byte var4 = var1.reader().readByte();
                  Npc var84;
                  (var84 = (Npc)GameScr.vNpc.elementAt(var4)).statusMe = var1.reader().readByte();
                  if (var84.template.npcTemplateId == 31 && var84.statusMe == 15) {
                     GameScr.gameAA(var84.cx, var84.cy);
                  }

                  return;
               case -92: {
                  int var43;
                  Char var50;
                  if ((var43 = var1.reader().readInt()) == Char.getMyChar().charID) {
                     var50 = Char.getMyChar();
                  } else {
                     var50 = GameScr.gameAE(var43);
                  }

                  if (var50 != null) {
                     var50.cTypePk = var1.reader().readByte();
                     Auto.fieldAB(var50);
                     if (var50 == Char.getMyChar()) {
                        if (var50.cTypePk == 4) {
                           GameScr.fieldGI = true;
                        } else if (var50.cTypePk == 5) {
                           GameScr.fieldGI = false;
                           return;
                        }

                        return;
                     }
                  }

                  return;
               }
               case -91: {
                  Item[] var82 = new Item[var1.reader().readUnsignedByte()];

                  for (int var43 = 0; var43 < Char.getMyChar().arrItemBag.length; var43++) {
                     var82[var43] = Char.getMyChar().arrItemBag[var43];
                  }

                  Char.getMyChar().arrItemBag = var82;
                  Char.getMyChar().arrItemBag[var1.reader().readUnsignedByte()] = null;
                  InfoMe.gameAA(mResources.gameFH + " " + Char.getMyChar().arrItemBag.length + " " + mResources.gameGB);
                  return;
               }
               case -90: {
                  for (int var43 = 0; var43 < GameScr.vNpc.size(); var43++) {
                     Npc var62;
                     if ((var62 = (Npc)GameScr.vNpc.elementAt(var43)).statusMe == 15) {
                        var62.statusMe = 1;
                        break;
                     }
                  }

                  if ((var42 = var1.reader().readByte()) == 1) {
                     InfoMe.gameAA(mResources.gameFI, 20, mFont.tahoma_7_yellow);
                  } else if (var42 == 2) {
                     InfoMe.gameAA(mResources.gameFJ, 20, mFont.tahoma_7_yellow);
                     return;
                  }

                  return;
               }
               case -89:
                  GameCanvas.isLoading = false;

                  try {
                     InfoMe.gameAA(var1.reader().readUTF(), 20, mFont.tahoma_7_yellow);
                  } catch (Exception var591) {
                  }

                  InfoDlg.gameAB();
                  GameCanvas.gameAJ();
                  return;
               case -87: {
                  byte var44 = var1.reader().readByte();
                  Party var85 = (Party)GameScr.vParty.elementAt(var44);
                  GameScr.vParty.setElementAt(GameScr.vParty.elementAt(0), var44);
                  GameScr.vParty.setElementAt(var85, 0);
                  GameScr.gI().gameAT();
                  InfoMe.gameAA(var85.name + mResources.gameSY, 20, mFont.tahoma_7_yellow);
                  return;
               }
               case -86:
                  GameScr.vParty.removeAllElements();
                  GameScr.gI().gameAT();
                  InfoMe.gameAA(mResources.gameSZ, 20, mFont.tahoma_7_yellow);
                  Code.fieldAH = null;
                  return;
               case -85:
                  GameScr.vFriend.removeAllElements();

                  try {
                     while (true) {
                        GameScr.vFriend.addElement(new Friend(var1.reader().readUTF(), var1.reader().readByte()));
                     }
                  } catch (Exception var681) {
                     for (int var43x = 0; var43x < GameScr.vFriendWait.size(); var43x++) {
                        GameScr.vFriend.addElement(GameScr.vFriendWait.elementAt(var43x));
                     }

                     GameScr.gI();
                     GameScr.sortList(0);
                     return;
                  }
               case -84:
                  GameScr.vEnemies.removeAllElements();

                  try {
                     while (true) {
                        GameScr.vEnemies.addElement(new Friend(var1.reader().readUTF(), var1.reader().readByte()));
                     }
                  } catch (Exception var70x) {
                     GameScr.gI();
                     GameScr.sortList(1);
                     return;
                  }
               case -83:
                  String var65 = var1.reader().readUTF();

                  for (int var53 = 0; var53 < GameScr.vFriend.size(); var53++) {
                     if (((Friend)GameScr.vFriend.elementAt(var53)).friendName.equals(var65)) {
                        GameScr.indexRow = 0;
                        GameScr.vFriend.removeElementAt(var53);
                        GameScr.gI();
                        GameScr.setText(var65);
                        break;
                     }
                  }

                  if (GameScr.isPaintFriend) {
                     GameScr.gI();
                     GameScr.sortList(0);
                     GameScr.indexRow = 0;
                     GameScr.scrMain.gameAA();
                  }

                  return;
               case -82:
                  String var87 = var1.reader().readUTF();

                  for (int var53xxx = 0; var53xxx < GameScr.vEnemies.size(); var53xxx++) {
                     if (((Friend)GameScr.vEnemies.elementAt(var53xxx)).friendName.equals(var87)) {
                        GameScr.indexRow = 0;
                        GameScr.vEnemies.removeElementAt(var53xxx);
                        break;
                     }
                  }

                  GameScr.gI();
                  GameScr.sortList(1);
                  return;
               case -81:
                  Char.getMyChar().cPk = var1.reader().readByte();
                  Char.getMyChar().charFocus = null;
                  return;
               case -80:
                  Char.getMyChar().arrItemBody[var1.reader().readByte()] = null;
                  return;
               case -78:
                  ServerEffect.gameAA(var1.reader().readShort(), Char.getMyChar().cx, Char.getMyChar().cy, 1);
                  return;
               case -77: {
                  try {
                     GameScr.vPtMap.removeAllElements();

                     while (true) {
                        GameScr.vPtMap
                           .addElement(new Party(var1.reader().readByte(), var1.reader().readUnsignedByte(), var1.reader().readUTF(), var1.reader().readByte()));
                     }
                  } catch (Exception var691) {
                     GameScr.gI().gameAS();
                     return;
                  }
               }
               case -76:
                  ((Party)GameScr.vParty.firstElement()).isLock = var1.reader().readBoolean();
                  return;
               case -75:
                  Char.getMyChar().arrItemBox[var1.reader().readByte()] = null;
                  return;
               case -74:
                  InfoDlg.showWait(var1.reader().readUTF());
                  return;
               case -73: {
                  Mob var66 = Mob.gameAA(var1.reader().readUnsignedByte());
                  ServerEffect.gameAA(67, var66.x, var66.y, 1);
                  return;
               }
               case -72:
                  Char.getMyChar().luong = var1.reader().readInt();
                  return;
               case -71: {
                  int var51 = var1.reader().readInt();
                  Char var75 = Char.getMyChar();
                  var75.luong += var51;
                  GameScr.gameAA("+" + var51, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 6);
                  InfoMe.gameAA(mResources.gamePM + " " + var51 + " " + mResources.gameKO, 20, mFont.tahoma_7_yellow);
                  return;
               }
               case -69: {
                  short var52 = var1.reader().readShort();
                  byte var44 = var1.reader().readByte();
                  if (var52 > 0) {
                     short var64 = (short)Char.getMyChar().cx;
                     short var56 = (short)(Char.getMyChar().cy - 40);
                     Char.getMyChar().mobMe = new Mob(
                        (short)-1, false, false, false, false, false, var52, 1, 0, 0, 0, var64, var56, (byte)4, (byte)0, var44 != 0, false
                     );
                     Char.getMyChar().mobMe.status = 5;
                  } else {
                     Char.getMyChar().mobMe = null;
                  }

                  return;
               }
               case -68:
                  Char var88;
                  if ((var88 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     short var52 = var1.reader().readShort();
                     byte var44x = var1.reader().readByte();
                     if (var52 > 0) {
                        short var56 = (short)var88.cx;
                        short var57 = (short)(var88.cy - 40);
                        var88.mobMe = new Mob(
                           (short)-1, false, false, false, false, false, var52, 1, 0, 0, 0, var56, var57, (byte)4, (byte)0, var44x != 0, false
                        );
                        var88.mobMe.status = 5;
                     } else {
                        var88.mobMe = null;
                     }

                     return;
                  }

                  return;
               case -65:
                  String var61 = var1.reader().readUTF();
                  byte[] var5 = new byte[var1.reader().readInt()];
                  var1.reader().read(var5);
                  if (var5.length == 0) {
                     var5 = null;
                  }

                  try {
                     var1.reader().readByte();
                  } catch (Exception var581) {
                     var581.printStackTrace();
                  }

                  if (var61.equals("KSkill")) {
                     GameScr.gI().gameAB(var5);
                     return;
                  } else {
                     if (var61.equals("OSkill")) {
                        GameScr.gI().gameAA(var5);
                     } else if (var61.equals("CSkill")) {
                        GameScr.gI().gameAC(var5);
                        return;
                     }

                     return;
                  }
               case -64:
                  Char var99;
                  if ((var99 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var99.cHP = var1.reader().readInt();
                     var99.cMaxHP = var1.reader().readInt();
                     var99.eff5BuffHp = var1.reader().readShort();
                     var99.eff5BuffMp = var1.reader().readShort();
                     var99.head = var1.reader().readShort();
                     return;
                  }

                  return;
               case -63:
                  Integer var59 = new Integer(var1.reader().readInt());
                  Char var50;
                  if ((var50 = GameScr.gameAE(var59)) != null) {
                     GameCanvas.gameAA(var50.cName + " " + mResources.gameAA(mResources.gameQU, var1.reader().readUTF()), 88830, var59, 88811, null);
                  }

                  return;
               case -62: {
                  int var43 = var1.reader().readInt();
                  if (Char.getMyChar().charID == var43) {
                     Char.getMyChar().cClanName = var1.reader().readUTF();
                     Char.getMyChar().ctypeClan = var1.reader().readByte();
                     Char.getMyChar().gameAC(21);
                  } else {
                     Char var98;
                     (var98 = GameScr.gameAE(var43)).cClanName = var1.reader().readUTF();
                     var98.ctypeClan = var1.reader().readByte();
                  }

                  return;
               }
               case -61:
                  Integer var987 = new Integer(var1.reader().readInt());
                  Char var976;
                  if (GameScr.isViewClanInvite && (var976 = GameScr.gameAE(var987)) != null) {
                     GameCanvas.gameAA(var976.cName + " " + mResources.gameQV, 88831, var987, 88811, null);
                  }

                  return;
               case -59: {
                  int var43;
                  Char var9875;
                  if ((var43 = var1.reader().readInt()) == Char.getMyChar().charID) {
                     var9875 = Char.getMyChar();
                  } else {
                     var9875 = GameScr.gameAE(var43);
                  }

                  var9875.cHP = var1.reader().readInt();
                  var9875.cMaxHP = var1.reader().readInt();
                  return;
               }
               case -58:
                  GameScr.gI().resetButton();
                  GameCanvas.timeBallEffect = 70;
                  GameCanvas.isBallEffect = true;
                  ServerEffect.gameAA(119, GameScr.gW2 + GameScr.cmx, GameScr.gH2 + GameScr.cmy, 1);
                  return;
               case -57:
                  GameCanvas.timeBallEffect = 40;
                  GameCanvas.isBallEffect = true;
                  return;
               case -56:
                  Char var981;
                  if ((var981 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var981.cHP = var1.reader().readInt();
                     var981.cMaxHP = var1.reader().readInt();
                     var981.coat = (short)var1.reader().readUnsignedShort();
                  }

                  return;
               case -55:
                  Char var980;
                  if ((var980 = GameScr.gameAE(var1.reader().readInt())) != null) {
                     var980.cHP = var1.reader().readInt();
                     var980.cMaxHP = var1.reader().readInt();
                     var980.glove = (short)var1.reader().readUnsignedShort();
                  }

                  return;
               case -54: {
                  int var43 = var1.reader().readInt();
                  Char var98455;
                  if (Char.getMyChar().charID == var43) {
                     var98455 = Char.getMyChar();
                  } else {
                     var98455 = GameScr.gameAE(var43);
                  }

                  if (var98455 != null) {
                     var98455.arrItemMounts = new Item[5];
                     var98455.isNewMount = var98455.isWolf = var98455.isMoto = var98455.isMotoBehind = false;

                     for (int var53xx = 0; var53xx < var98455.arrItemMounts.length; var53xx++) {
                        short var56;
                        if ((var56 = var1.reader().readShort()) != -1) {
                           var98455.arrItemMounts[var53xx] = new Item();
                           var98455.arrItemMounts[var53xx].typeUI = 41;
                           var98455.arrItemMounts[var53xx].indexUI = var53xx;
                           var98455.arrItemMounts[var53xx].template = ItemTemplates.gameAA(var56);
                           var98455.arrItemMounts[var53xx].upgrade = var1.reader().readByte();
                           var98455.arrItemMounts[var53xx].expires = var1.reader().readLong();
                           var98455.arrItemMounts[var53xx].sys = var1.reader().readByte();
                           var98455.arrItemMounts[var53xx].isLock = true;
                           if (var53xx == 4) {
                              if (var98455.arrItemMounts[var53xx].template.id == 485 || var98455.arrItemMounts[var53xx].template.id == 524) {
                                 var98455.isMoto = true;
                              } else if (var98455.arrItemMounts[var53xx].template.id != 443 && var98455.arrItemMounts[var53xx].template.id != 523) {
                                 var98455.isNewMount = true;
                                 var98455.gameBC();
                              } else {
                                 var98455.isWolf = true;
                              }
                           }

                           byte varzzz = var1.reader().readByte();
                           var98455.arrItemMounts[var53xx].options = new MyVector();

                           for (int var54x = 0; var54x < varzzz; var54x++) {
                              var98455.arrItemMounts[var53xx].options.addElement(new ItemOption(var1.reader().readUnsignedByte(), var1.reader().readInt()));
                           }
                        }
                     }
                  }

                  return;
               }
               case 115: {
                  System.out.println("UPDATE INFO ME");
                  GameScr.currentCharViewInfo = Char.getMyChar();
                  Char.getMyChar().gameGK = null;
                  Char.getMyChar().charID = var1.reader().readInt();
                  Char.getMyChar().cClanName = var1.reader().readUTF();
                  if (!Char.getMyChar().cClanName.equals("")) {
                     Char.getMyChar().ctypeClan = var1.reader().readByte();
                  }

                  Char.getMyChar().ctaskId = var1.reader().readByte();
                  Char.getMyChar().cgender = var1.reader().readByte();
                  Char.getMyChar().head = var1.reader().readShort();
                  Char.getMyChar().cspeed = var1.reader().readByte();
                  Char.getMyChar().cName = var1.reader().readUTF();
                  Char.getMyChar().cPk = var1.reader().readByte();
                  Char.getMyChar().cTypePk = var1.reader().readByte();
                  Char.getMyChar().cMaxHP = var1.reader().readInt();
                  Char.getMyChar().cHP = var1.reader().readInt();
                  Char.getMyChar().cMaxMP = var1.reader().readInt();
                  Char.getMyChar().cMP = var1.reader().readInt();
                  Char.getMyChar().cEXP = var1.reader().readLong();
                  Char.getMyChar().cExpDown = var1.reader().readLong();
                  GameScr.gameAA(Char.getMyChar().cEXP, true);
                  Char.getMyChar().eff5BuffHp = var1.reader().readShort();
                  Char.getMyChar().eff5BuffMp = var1.reader().readShort();
                  Char.getMyChar().nClass = GameScr.nClasss[var1.reader().readByte()];
                  Char.getMyChar().pPoint = var1.reader().readShort();
                  Char.getMyChar().potential[0] = var1.reader().readShort();
                  Char.getMyChar().potential[1] = var1.reader().readShort();
                  Char.getMyChar().potential[2] = var1.reader().readInt();
                  Char.getMyChar().potential[3] = var1.reader().readInt();
                  Char.getMyChar().sPoint = var1.reader().readShort();
                  Char.getMyChar().vSkill.removeAllElements();
                  Char.getMyChar().vSkillFight.removeAllElements();
                  byte var44 = var1.reader().readByte();

                  for (byte var751 = 0; var751 < var44; var751++) {
                     Skill var3 = Skills.gameAA(var1.reader().readShort());
                     if (Char.getMyChar().myskill == null) {
                        Char.getMyChar().myskill = var3;
                     }

                     if (Code.fieldAB != null && Auto.fieldAL != null && var3.template.id == Auto.fieldAL.template.id) {
                        Auto.fieldAL = var3;
                     }

                     Char.getMyChar().vSkill.addElement(var3);
                     if ((var3.template.type == 1 || var3.template.type == 4 || var3.template.type == 2 || var3.template.type == 3)
                        && (var3.template.maxPoint == 0 || var3.template.maxPoint > 0 && var3.point > 0)) {
                        byte var10000 = var3.template.id;
                        Char.getMyChar();
                        if (var10000 == 0) {
                           Service var73x = Service.gI();
                           Char.getMyChar();
                           var73x.selectSkill(0);
                        }

                        Char.getMyChar().vSkillFight.addElement(var3);
                     }
                  }

                  GameScr.gI();
                  GameScr.gameAZ();
                  Char.getMyChar().xu = var1.reader().readInt();
                  Char.getMyChar().yen = var1.reader().readInt();
                  Char.getMyChar().luong = var1.reader().readInt();
                  Char.getMyChar().arrItemBag = new Item[var1.reader().readUnsignedByte()];
                  GameScr.mpPotion = 0;
                  GameScr.hpPotion = 0;

                  for (int var43 = 0; var43 < Char.getMyChar().arrItemBag.length; var43++) {
                     short var45;
                     if ((var45 = var1.reader().readShort()) != -1) {
                        Char.getMyChar().arrItemBag[var43] = new Item();
                        Char.getMyChar().arrItemBag[var43].typeUI = 3;
                        Char.getMyChar().arrItemBag[var43].indexUI = var43;
                        Char.getMyChar().arrItemBag[var43].template = ItemTemplates.gameAA(var45);
                        Char.getMyChar().arrItemBag[var43].isLock = var1.reader().readBoolean();
                        if (Char.getMyChar().arrItemBag[var43].isTypeBody()
                           || Char.getMyChar().arrItemBag[var43].isTypeMounts()
                           || Char.getMyChar().arrItemBag[var43].isTypeNgocKham()) {
                           Char.getMyChar().arrItemBag[var43].upgrade = var1.reader().readByte();
                        }

                        Char.getMyChar().arrItemBag[var43].isExpires = var1.reader().readBoolean();
                        Char.getMyChar().arrItemBag[var43].quantity = var1.reader().readUnsignedShort();
                        if (Char.getMyChar().arrItemBag[var43].template.type == 16) {
                           GameScr.hpPotion = GameScr.hpPotion + Char.getMyChar().arrItemBag[var43].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var43].template.type == 17) {
                           GameScr.mpPotion = GameScr.mpPotion + Char.getMyChar().arrItemBag[var43].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var43].template.id == 340) {
                           GameScr var74 = GameScr.gI();
                           var74.numSprinLeft = var74.numSprinLeft + Char.getMyChar().arrItemBag[var43].quantity;
                        }
                     }
                  }

                  Code.fieldAL();
                  Char.getMyChar().arrItemBody = new Item[32];

                  try {
                     Char.getMyChar().gameAJ();

                     for (int var105 = 0; var105 < 16; var105++) {
                        short var45;
                        if ((var45 = var1.reader().readShort()) != -1) {
                           ItemTemplate var48;
                           byte varvcz = (var48 = ItemTemplates.gameAA(var45)).type;
                           Char.getMyChar().arrItemBody[varvcz] = new Item();
                           Char.getMyChar().arrItemBody[varvcz].indexUI = varvcz;
                           Char.getMyChar().arrItemBody[varvcz].typeUI = 5;
                           Char.getMyChar().arrItemBody[varvcz].template = var48;
                           Char.getMyChar().arrItemBody[varvcz].isLock = true;
                           Char.getMyChar().arrItemBody[varvcz].upgrade = var1.reader().readByte();
                           Char.getMyChar().arrItemBody[varvcz].sys = var1.reader().readByte();
                           if (varvcz == 1) {
                              Char.getMyChar().wp = Char.getMyChar().arrItemBody[varvcz].template.part;
                           } else if (varvcz == 2) {
                              Char.getMyChar().body = Char.getMyChar().arrItemBody[varvcz].template.part;
                           } else if (varvcz == 6) {
                              Char.getMyChar().leg = Char.getMyChar().arrItemBody[varvcz].template.part;
                           }
                        }
                     }
                  } catch (Exception var631) {
                     var631.printStackTrace();
                  }

                  Char.getMyChar().isHuman = var1.reader().readBoolean();
                  Char.getMyChar().isNhanban = var1.reader().readBoolean();
                  short[] var46;
                  if ((var46 = new short[]{var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort()})[0] > -1
                     )
                   {
                     Char.getMyChar().head = var46[0];
                  }

                  if (var46[1] > -1) {
                     Char.getMyChar().wp = var46[1];
                  }

                  if (var46[2] > -1) {
                     Char.getMyChar().body = var46[2];
                  }

                  if (var46[3] > -1) {
                     Char.getMyChar().leg = var46[3];
                  }

                  short[] var49 = new short[10];

                  try {
                     for (int var51x = 0; var51x < 10; var51x++) {
                        var49[var51x] = var1.reader().readShort();
                     }
                  } catch (Exception var62) {
                     var49 = null;
                  }

                  if (var49 != null) {
                     Char.getMyChar().gameAA(var49);
                  }

                  GameScr.gI();
                  GameScr.gameAZ();
                  if (Char.getMyChar().isHuman) {
                     GameScr.gI();
                     GameScr.gameAG();
                  } else if (Char.getMyChar().isNhanban) {
                     GameScr.gI();
                     GameScr.gameAH();
                  }

                  Char.getMyChar().statusMe = 4;
                  GameScr.isViewClanInvite = RMS.gameAC(Char.getMyChar().cName + "vci") >= 1;
                  Service.gI().loadRMS("KSkill");
                  Service.gI().loadRMS("OSkill");
                  Service.gI().loadRMS("CSkill");

                  try {
                     for (int var51x = 0; var51x < 16; var51x++) {
                        short var52;
                        if ((var52 = var1.reader().readShort()) != -1) {
                           ItemTemplate var47;
                           int var53 = (var47 = ItemTemplates.gameAA(var52)).type + 16;
                           Char.getMyChar().arrItemBody[var53] = new Item();
                           Char.getMyChar().arrItemBody[var53].indexUI = var53;
                           Char.getMyChar().arrItemBody[var53].typeUI = 5;
                           Char.getMyChar().arrItemBody[var53].template = var47;
                           Char.getMyChar().arrItemBody[var53].isLock = true;
                           Char.getMyChar().arrItemBody[var53].upgrade = var1.reader().readByte();
                           Char.getMyChar().arrItemBody[var53].sys = var1.reader().readByte();
                           if (var53 == 1) {
                              Char.getMyChar().wp = Char.getMyChar().arrItemBody[var53].template.part;
                           } else if (var53 == 2) {
                              Char.getMyChar().body = Char.getMyChar().arrItemBody[var53].template.part;
                           } else if (var53 == 6) {
                              Char.getMyChar().leg = Char.getMyChar().arrItemBody[var53].template.part;
                           }
                        }
                     }
                  } catch (Exception var61x) {
                     var61x.printStackTrace();
                  }

                  boolean var55 = false;

                  short var56;
                  try {
                     var56 = var1.reader().readShort();
                  } catch (Exception var57) {
                     var56 = -1;
                  }

                  Char.getMyChar().ID_SUSANO = var56;
               }
            }
         } catch (Exception var731) {
         }
      } finally {
         if (var1 != null) {
            var1.cleanup();
         }
      }
   }

   private static boolean gameAA(Char var0, Message var1) {
      try {
         var0.cClanName = var1.reader().readUTF();
         if (!var0.cClanName.equals("")) {
            var0.ctypeClan = var1.reader().readByte();
         }

         var0.isInvisible = var1.reader().readBoolean();
         var0.cTypePk = var1.reader().readByte();
         var0.nClass = GameScr.nClasss[var1.reader().readByte()];
         var0.cgender = var1.reader().readByte();
         var0.head = var1.reader().readShort();
         var0.cName = var1.reader().readUTF();
         var0.cHP = var1.reader().readInt();
         var0.cMaxHP = var1.reader().readInt();
         var0.clevel = var1.reader().readUnsignedByte();
         var0.wp = var1.reader().readShort();
         var0.body = var1.reader().readShort();
         var0.leg = var1.reader().readShort();
         byte var2 = var1.reader().readByte();
         if (var0.wp == -1) {
            var0.gameAK();
         }

         if (var0.body == -1) {
            var0.gameAL();
         }

         if (var0.leg == -1) {
            var0.gameAM();
         }

         if (var2 == -1) {
            var0.mobMe = null;
         } else {
            short var3 = (short)var0.cx;
            short var4 = (short)(var0.cy - 40);
            var0.mobMe = new Mob((short)-1, false, false, false, false, false, var2, 1, 0, 0, 0, var3, var4, (byte)4, (byte)0, false, false);
            var0.mobMe.status = 5;
         }

         var0.cx = var0.cxMoveLast = var1.reader().readShort();
         var0.cy = var0.cyMoveLast = var1.reader().readShort();
         var0.eff5BuffHp = var1.reader().readShort();
         var0.eff5BuffMp = var1.reader().readShort();
         byte var13 = var1.reader().readByte();

         for (int var16 = 0; var16 < var13; var16++) {
            EffectBuff var10 = new EffectBuff(var1.reader().readByte(), var1.reader().readInt(), var1.reader().readInt(), var1.reader().readShort());
            var0.vEff.addElement(var10);
            if (var10.template.type == 12 || var10.template.type == 11) {
               var0.isInvisible = true;
            }
         }

         if (!var0.isInvisible) {
            ServerEffect.gameAA(60, var0, 1);
         }

         if (var0.cHP == 0) {
            var0.statusMe = 14;
            if (Char.getMyChar().charID == var0.charID) {
               GameScr.gI().resetButton();
            }
         }

         if (var0.charID == -Char.getMyChar().charID) {
            for (int var171 = 0; var171 < GameScr.vNpc.size(); var171++) {
               Npc var11;
               if ((var11 = (Npc)GameScr.vNpc.elementAt(var171)).template.name.equals(var0.cName)) {
                  var11.statusMe = 15;
                  var11.chatPopup = null;
                  break;
               }
            }
         }

         var0.isHuman = var1.reader().readBoolean();
         var0.isNhanban = var1.reader().readBoolean();
         if (var0.gameBB()) {
            ServerEffect.gameAA(141, var0.cx, var0.cy, 0);
         }

         short[] var18;
         if ((var18 = new short[]{var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort(), var1.reader().readShort()})[0] > -1) {
            var0.head = var18[0];
         }

         if (var18[1] > -1) {
            var0.wp = var18[1];
         }

         if (var18[2] > -1) {
            var0.body = var18[2];
         }

         if (var18[3] > -1) {
            var0.leg = var18[3];
         }

         short[] var12 = new short[10];

         try {
            for (int var15 = 0; var15 < 10; var15++) {
               var12[var15] = var1.reader().readShort();
            }
         } catch (Exception var13x) {
         }

         var0.gameAA(var12);
         boolean var17x = false;

         short var3;
         try {
            var3 = var1.reader().readShort();
         } catch (Exception var12x) {
            var3 = -1;
         }

         var0.ID_SUSANO = var3;
         Char var14x = var0;

         for (int var8 = 0; var8 < GameScr.vParty.size(); var8++) {
            Party var9;
            if ((var9 = (Party)GameScr.vParty.elementAt(var8)).charId == var14x.charID) {
               var9.c = var14x;
               break;
            }
         }

         return true;
      } catch (Exception var141) {
         return false;
      }
   }

   private static void gameAH(Message var0) {
      try {
         byte var1;
         Item var3;
         var1 = var0.reader().readByte();
         int var2 = var0.reader().readUnsignedByte();
         var3 = null;
         label190:
         switch (var1) {
            case 2:
               var3 = GameScr.arrItemWeapon[var2];
               break;
            case 3:
               if ((var3 = Char.getMyChar().arrItemBag[var2]) != null) {
                  break;
               }

               if (GameScr.itemSplit != null && GameScr.itemSplit.indexUI == var2) {
                  var3 = GameScr.itemSplit;
               }

               if (GameScr.itemUpGrade != null && GameScr.itemUpGrade.indexUI == var2) {
                  var3 = GameScr.itemUpGrade;
               }

               if (GameScr.itemSell != null && GameScr.itemSell.indexUI == var2) {
                  var3 = GameScr.itemSell;
               }

               if (var3 == null && GameScr.arrItemUpGrade != null) {
                  for (int var4 = 0; var4 < GameScr.arrItemUpGrade.length; var4++) {
                     if (GameScr.arrItemUpGrade[var4] != null && GameScr.arrItemUpGrade[var4].indexUI == var2) {
                        var3 = GameScr.arrItemUpGrade[var4];
                        break;
                     }
                  }
               }

               if (var3 == null && GameScr.arrItemConvert != null) {
                  for (int var4x = 0; var4x < GameScr.arrItemConvert.length; var4x++) {
                     if (GameScr.arrItemConvert[var4x] != null && GameScr.arrItemConvert[var4x].indexUI == var2) {
                        var3 = GameScr.arrItemConvert[var4x];
                        break;
                     }
                  }
               }

               if (var3 == null && GameScr.arrItemUpPeal != null) {
                  for (int var4xx = 0; var4xx < GameScr.arrItemUpPeal.length; var4xx++) {
                     if (GameScr.arrItemUpPeal[var4xx] != null && GameScr.arrItemUpPeal[var4xx].indexUI == var2) {
                        var3 = GameScr.arrItemUpPeal[var4xx];
                        break;
                     }
                  }
               }

               if (var3 == null && GameScr.arrItemTradeMe != null) {
                  for (int var4xxx = 0; var4xxx < GameScr.arrItemTradeMe.length; var4xxx++) {
                     if (GameScr.arrItemTradeMe[var4xxx] != null && GameScr.arrItemTradeMe[var4xxx].indexUI == var2) {
                        var3 = GameScr.arrItemTradeMe[var4xxx];
                        break;
                     }
                  }
               }

               if (var3 == null && GameScr.arrItemSplit != null) {
                  for (int var4xxxx = 0; var4xxxx < GameScr.arrItemSplit.length; var4xxxx++) {
                     if (GameScr.arrItemSplit[var4xxxx] != null && GameScr.arrItemSplit[var4xxxx].indexUI == var2) {
                        var3 = GameScr.arrItemSplit[var4xxxx];
                        break label190;
                     }
                  }
               }
               break;
            case 4:
               var3 = Char.getMyChar().arrItemBox[var2];
               break;
            case 5:
               var3 = Char.getMyChar().arrItemBody[var2];
               break;
            case 6:
               var3 = GameScr.arrItemStack[var2];
               break;
            case 7:
               var3 = GameScr.arrItemStackLock[var2];
               break;
            case 8:
               var3 = GameScr.arrItemGrocery[var2];
               break;
            case 9:
               var3 = GameScr.arrItemGroceryLock[var2];
            case 10:
            case 11:
            case 12:
            case 13:
            case 31:
            case 33:
            case 36:
            case 37:
            case 38:
            default:
               break;
            case 14:
               var3 = GameScr.arrItemStore[var2];
               break;
            case 15:
               var3 = GameScr.arrItemBook[var2];
               break;
            case 16:
               var3 = GameScr.arrItemLien[var2];
               break;
            case 17:
               var3 = GameScr.arrItemNhan[var2];
               break;
            case 18:
               var3 = GameScr.arrItemNgocBoi[var2];
               break;
            case 19:
               var3 = GameScr.arrItemPhu[var2];
               break;
            case 20:
               var3 = GameScr.arrItemNonNam[var2];
               break;
            case 21:
               var3 = GameScr.arrItemNonNu[var2];
               break;
            case 22:
               var3 = GameScr.arrItemAoNam[var2];
               break;
            case 23:
               var3 = GameScr.arrItemAoNu[var2];
               break;
            case 24:
               var3 = GameScr.arrItemGangTayNam[var2];
               break;
            case 25:
               var3 = GameScr.arrItemGangTayNu[var2];
               break;
            case 26:
               var3 = GameScr.arrItemQuanNam[var2];
               break;
            case 27:
               var3 = GameScr.arrItemQuanNu[var2];
               break;
            case 28:
               var3 = GameScr.arrItemGiayNam[var2];
               break;
            case 29:
               var3 = GameScr.arrItemGiayNu[var2];
               break;
            case 30:
               var3 = GameScr.arrItemTradeOrder[var2];
               break;
            case 32:
               var3 = GameScr.arrItemFashion[var2];
               break;
            case 34:
               var3 = GameScr.arrItemClanShop[var2];
               break;
            case 35:
               var3 = GameScr.arrItemElites[var2];
               break;
            case 39:
               var3 = Char.clan.items[GameScr.indexSelect];
         }

         var3.expires = var0.reader().readLong();
         if (var3.isTypeUIMe()) {
            var3.saleCoinLock = var0.reader().readInt();
         } else if (var3.isTypeUIShop()
            || var3.isTypeUIShopLock()
            || var3.isTypeUIStore()
            || var3.isTypeUIBook()
            || var3.isTypeUIFashion()
            || var3.isTypeUIClanShop()) {
            var3.buyCoin = var0.reader().readInt();
            var3.buyCoinLock = var0.reader().readInt();
            var3.buyGold = var0.reader().readInt();
         }

         if (var3.isTypeBody() || var3.isTypeMounts() || var3.isTypeNgocKham()) {
            var3.sys = var0.reader().readByte();
            var3.options = new MyVector();

            try {
               while (true) {
                  var3.options.addElement(new ItemOption(var0.reader().readUnsignedByte(), var0.reader().readInt()));
               }
            } catch (Exception var5) {
            }
         } else if (var3.template.id == 233) {
            var3.img = gameAA(NinjaUtil.gameAB(var0));
         } else if (var3.template.id == 234) {
            var3.img = gameAA(NinjaUtil.gameAB(var0));
         } else if (var3.template.id == 235) {
            var3.img = gameAA(NinjaUtil.gameAB(var0));
         }

         if (var1 == 5) {
            Char.getMyChar().gameAW();
            return;
         }
      } catch (Exception var61) {
         var61.printStackTrace();
         System.out.println("Controller.requestItemInfo()");
      }
   }

   private static void gameAI(Message message) {
      try {
         byte byte1 = message.reader().readByte();

         for (byte b = 0; b < byte1; b++) {
            GameScr.fieldAA(
               new Mob(
                  (short)message.reader().readUnsignedByte(),
                  message.reader().readBoolean(),
                  message.reader().readBoolean(),
                  message.reader().readBoolean(),
                  message.reader().readBoolean(),
                  message.reader().readBoolean(),
                  message.reader().readUnsignedByte(),
                  message.reader().readByte(),
                  message.reader().readInt(),
                  message.reader().readUnsignedByte(),
                  message.reader().readInt(),
                  message.reader().readShort(),
                  message.reader().readShort(),
                  message.reader().readByte(),
                  message.reader().readByte(),
                  message.reader().readBoolean(),
                  true
               ),
               b
            );
         }
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("err addMob");
      }
   }

   private static void gameAJ(Message var0) {
      try {
         short var1 = (short)var0.reader().readUnsignedByte();
         short var2 = var0.reader().readShort();
         short var3 = var0.reader().readShort();
         byte var4 = var0.reader().readByte();
         short var6x = var0.reader().readShort();
         EffectAuto.gameAA(var1, var2, var3, var4, var6x, 1);
      } catch (Exception var61) {
         var61.printStackTrace();
         System.out.println("err add effAuto");
      }
   }

   private static void gameAK(Message var0) {
      try {
         short var1 = (short)var0.reader().readUnsignedByte();
         short var2 = var0.reader().readShort();
         byte[] var3 = null;
         if (var2 > 0) {
            var3 = new byte[var2];
            var0.reader().read(var3);
         }

         EffectAuto.gameAA(var1, var3);
      } catch (Exception var41) {
         var41.printStackTrace();
         System.out.println("err add effAuto");
      }
   }

   private static void gameAL(Message var0) {
      try {
         short var1 = (short)var0.reader().readUnsignedByte();
         byte[] var3x = NinjaUtil.gameAA(var0);
         EffectAuto.gameAB(var1, var3x);
      } catch (Exception var31) {
         var31.printStackTrace();
         System.out.println("err getImgEffAuto");
      }
   }

   private static void gameAM(Message var0) {
      try {
         byte var1 = var0.reader().readByte();
         Char.getMyChar().luong = var0.reader().readInt();
         Char.getMyChar().xu = var0.reader().readInt();
         Char.getMyChar().yen = var0.reader().readInt();
         if (var1 == 0) {
            if (GameScr.itemSplit != null) {
               GameScr.itemSplit = null;
            }

            if (GameScr.arrItemSplit != null) {
               for (int var3x = 0; var3x < GameScr.arrItemSplit.length; var3x++) {
                  GameScr.arrItemSplit[var3x] = null;
               }
            }
         } else if (var1 == 1) {
            if (GameScr.itemSplit != null) {
               GameScr.itemSplit.isLock = true;
               GameScr.itemSplit.upgrade = var0.reader().readByte();
               GameScr.effUpok = GameScr.efs[53];
               GameScr.indexEff = 0;
            }

            if (GameScr.arrItemSplit != null) {
               for (int var3x = 0; var3x < GameScr.arrItemSplit.length; var3x++) {
                  GameScr.arrItemSplit[var3x] = null;
               }
            }
         } else if ((var1 == 2 || var1 == 3) && GameScr.arrItemSplit != null) {
            for (int var3x = 0; var3x < GameScr.arrItemSplit.length; var3x++) {
               GameScr.arrItemSplit[var3x] = null;
            }
         }

         GameScr.gI().left = GameScr.gI().center = null;
         GameScr.gI().gameBB();
         GameCanvas.gameAJ();
      } catch (Exception var31) {
         var31.printStackTrace();
         System.out.println("err getImgEffAuto");
      }
   }

   private static void gameAN(Message var0) {
      try {
         Object var1;
         if (var0.reader().readByte() == 1) {
            var1 = Mob.gameAA(var0.reader().readUnsignedByte());
         } else {
            int var2;
            if ((var2 = var0.reader().readInt()) == Char.getMyChar().charID) {
               var1 = Char.getMyChar();
            } else {
               var1 = GameScr.gameAE(var2);
            }
         }

         if (var1 == null) {
            return;
         }

         short var15x = var0.reader().readShort();
         int var3 = var0.reader().readInt();
         byte var4 = var0.reader().readByte();
         boolean var13 = var0.reader().readByte() != 0;
         long var10002 = var3;
         int var2x = var4 * 1000;
         short var16 = var15x;
         Object var14 = var1;
         int var18 = 0;

         while (true) {
            if (var18 >= ((MainObject)var14).vecEFfect.size()) {
               DataSkillEff var19 = new DataSkillEff(var16, var10002, var2x, var13);
               ((MainObject)var14).vecEFfect.addElement(var19);
               return;
            }

            DataSkillEff var5;
            if ((var5 = (DataSkillEff)((MainObject)var14).vecEFfect.elementAt(var18)) != null && var5.gameAE == var16) {
               var5.gameAQ = var10002 + System.currentTimeMillis();
               var5.gameAR = var2x;
               var5.gameAA(var10002);
               break;
            }

            var18++;
         }
      } catch (Exception var151) {
         var151.printStackTrace();
      }
   }

   private static void gameAO(Message var0) {
      try {
         short var1 = (short)var0.reader().readUnsignedByte();
         byte[] var4x = NinjaUtil.gameAA(var0);
         GameData.gameAA(var1, var4x);
         ImageIcon var2;
         if ((var2 = (ImageIcon)GameData.listImgIcon.gameAA("" + var1)) == null) {
            var2 = new ImageIcon();
            GameData.listImgIcon.gameAA(String.valueOf((int)var1), var2);
         }

         var2.img = gameAA(var4x);
         if (GameMidlet.CLIENT_TYPE != 1) {
            RMS.gameAB("ImgEffect " + var1, var4x);
            return;
         }
      } catch (Exception var41) {
         var41.printStackTrace();
         System.out.println("err getImgEffect");
      }
   }

   private static void gameAP(Message var0) {
      try {
         short var1 = (short)var0.reader().readUnsignedByte();
         short var2 = var0.reader().readShort();
         byte[] var3 = null;
         if (var2 > 0) {
            var3 = new byte[var2];
            var0.reader().read(var3);
         }

         EffectData var5x;
         if ((var5x = (EffectData)GameData.listbyteData.gameAA("" + var1)) != null) {
            if (var3 != null) {
               var5x.data = var3;
            }

            return;
         }
      } catch (Exception var51) {
         var51.printStackTrace();
         System.out.println("err getDataEffect ");
      }
   }

   private static void gameAA(Message var0, int var1) {
      try {
         Mob.arrMobTemplate[var1].imginfo = new ImageInfo[var0.reader().readByte()];

         for (int var2 = 0; var2 < Mob.arrMobTemplate[var1].imginfo.length; var2++) {
            Mob.arrMobTemplate[var1].imginfo[var2] = new ImageInfo();
            var0.reader().readByte();
            Mob.arrMobTemplate[var1].imginfo[var2].x0 = var0.reader().readUnsignedByte();
            Mob.arrMobTemplate[var1].imginfo[var2].y0 = var0.reader().readUnsignedByte();
            Mob.arrMobTemplate[var1].imginfo[var2].w = var0.reader().readUnsignedByte();
            Mob.arrMobTemplate[var1].imginfo[var2].h = var0.reader().readUnsignedByte();
         }

         Mob.arrMobTemplate[var1].frameBoss = new Frame[var0.reader().readShort()];

         for (int var61 = 0; var61 < Mob.arrMobTemplate[var1].frameBoss.length; var61++) {
            Mob.arrMobTemplate[var1].frameBoss[var61] = new Frame();
            byte var3 = var0.reader().readByte();
            Mob.arrMobTemplate[var1].frameBoss[var61].dx = new short[var3];
            Mob.arrMobTemplate[var1].frameBoss[var61].dy = new short[var3];
            Mob.arrMobTemplate[var1].frameBoss[var61].idImg = new byte[var3];

            for (int var4 = 0; var4 < var3; var4++) {
               Mob.arrMobTemplate[var1].frameBoss[var61].dx[var4] = var0.reader().readShort();
               Mob.arrMobTemplate[var1].frameBoss[var61].dy[var4] = var0.reader().readShort();
               Mob.arrMobTemplate[var1].frameBoss[var61].idImg[var4] = var0.reader().readByte();
            }
         }

         short var6 = var0.reader().readShort();

         for (int var7 = 0; var7 < var6; var7++) {
            var0.reader().readShort();
         }
      } catch (Exception var5) {
      }
   }

   private static void gameAB(Message var0, int var1) {
      try {
         boolean var2 = false;
         Mob.arrMobTemplate[var1].imginfo = new ImageInfo[var0.reader().readByte()];

         for (int var7 = 0; var7 < Mob.arrMobTemplate[var1].imginfo.length; var7++) {
            Mob.arrMobTemplate[var1].imginfo[var7] = new ImageInfo();
            var0.reader().readByte();
            Mob.arrMobTemplate[var1].imginfo[var7].x0 = var0.reader().readUnsignedByte();
            Mob.arrMobTemplate[var1].imginfo[var7].y0 = var0.reader().readUnsignedByte();
            Mob.arrMobTemplate[var1].imginfo[var7].w = var0.reader().readUnsignedByte();
            Mob.arrMobTemplate[var1].imginfo[var7].h = var0.reader().readUnsignedByte();
         }

         Mob.arrMobTemplate[var1].frameBoss = new Frame[var0.reader().readShort()];

         for (int var10 = 0; var10 < Mob.arrMobTemplate[var1].frameBoss.length; var10++) {
            Mob.arrMobTemplate[var1].frameBoss[var10] = new Frame();
            byte var3 = var0.reader().readByte();
            Mob.arrMobTemplate[var1].frameBoss[var10].dx = new short[var3];
            Mob.arrMobTemplate[var1].frameBoss[var10].dy = new short[var3];
            Mob.arrMobTemplate[var1].frameBoss[var10].idImg = new byte[var3];
            Mob.arrMobTemplate[var1].frameBoss[var10].flip = new byte[var3];
            Mob.arrMobTemplate[var1].frameBoss[var10].onTop = new byte[var3];

            for (int var4 = 0; var4 < var3; var4++) {
               Mob.arrMobTemplate[var1].frameBoss[var10].dx[var4] = var0.reader().readShort();
               Mob.arrMobTemplate[var1].frameBoss[var10].dy[var4] = var0.reader().readShort();
               Mob.arrMobTemplate[var1].frameBoss[var10].idImg[var4] = var0.reader().readByte();
               Mob.arrMobTemplate[var1].frameBoss[var10].flip[var4] = var0.reader().readByte();
               Mob.arrMobTemplate[var1].frameBoss[var10].onTop[var4] = var0.reader().readByte();
            }
         }

         short var9x = (short)var0.reader().readUnsignedByte();
         Mob.arrMobTemplate[var1].sequence = new byte[var9x];

         for (int var8 = 0; var8 < var9x; var8++) {
            Mob.arrMobTemplate[var1].sequence[var8] = (byte)var0.reader().readShort();
         }

         var0.reader().readByte();

         for (int var13 = 0; var13 < 4; var13++) {
            if (var13 != 2) {
               byte var10 = var0.reader().readByte();
               Mob.arrMobTemplate[var1].frameChar[var13] = new byte[var10];

               for (int var4 = 0; var4 < var10; var4++) {
                  Mob.arrMobTemplate[var1].frameChar[var13][var4] = var0.reader().readByte();
               }
            }
         }

         try {
            Mob.arrMobTemplate[var1].indexSplash[0] = (byte)(Mob.arrMobTemplate[var1].frameChar[0].length - 7);
            Mob.arrMobTemplate[var1].indexSplash[1] = (byte)(Mob.arrMobTemplate[var1].frameChar[1].length - 7);
            Mob.arrMobTemplate[var1].indexSplash[2] = (byte)(Mob.arrMobTemplate[var1].frameChar[3].length - 7);
            Mob.arrMobTemplate[var1].indexSplash[3] = (byte)(Mob.arrMobTemplate[var1].frameChar[3].length - 7);
         } catch (Exception var81) {
            new StringBuffer("loi read data mod ").append(var81.toString()).toString();
         }

         for (int var14 = 0; var14 < 3; var14++) {
            Mob.arrMobTemplate[var1].indexSplash[var14] = var0.reader().readByte();
         }

         Mob.arrMobTemplate[var1].indexSplash[3] = Mob.arrMobTemplate[var1].indexSplash[2];
      } catch (Exception var91) {
         new StringBuffer("loi ham read data new mob ").append(var1).append(" ").append(var91.toString()).toString();
      }
   }
}
