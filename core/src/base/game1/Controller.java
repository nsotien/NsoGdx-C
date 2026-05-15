package base.game1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class Controller implements Runnable {
   private static Controller a;
   private Message b;
   private static String[] c = new String[]{"Bạn chỉ có thể vào lại game sau ", " giây nữa"};
   private static String d = "Bạn chưa thể đi đến khu vực này.Hãy hoàn thành nhiệm vụ trước.";
   private static String e = "Cửa này vẫn chưa được mở.";
   private static String f = "Cửa này chỉ chứa được tối đa 2 người.";
   private static String g = "Số nhóm của khu vực này";
   private static String h = "Khu vực này đã đầy.";
   private static String i = "Thao tác quá nhanh.";
   private static boolean isStart;
   public static boolean isVersion;
   public static MyVector listTextBlock = new MyVector();
   private static boolean isSend;

   public static Controller a() {
      if (a == null) {
         a = new Controller();
      }

      return a;
   }

   public final void b() {
      if (Code.mode != null) {
         phong.onDisconnect();
      } else {
         GameCanvas.a(TextGame.dy, 8884, (Object)null);
      }

   }

   private static void b(Message var0) {
      try {
         int var1 = var0.b().readUnsignedByte();
         Item var4;
         (var4 = GameScr.currentCharViewInfo.arrItemBody[var1]).expires = var0.b().readLong();
         var4.saleCoinLock = var0.b().readInt();
         var4.sys = var0.b().readByte();
         var4.options = new MyVector();

         try {
            while(true) {
               var4.options.addElement(new ItemOption(var0.b().readUnsignedByte(), var0.b().readInt()));
            }
         } catch (Exception var42) {
         }
      } catch (Exception var5) {
         ;
      }

   }

   private static void c(Message var0) {
      try {
         Item var1 = null;
         int var2 = var0.b().readInt();

         for(int var3 = 0; var3 < GameScr.cf.length; ++var3) {
            if (GameScr.cf[var3].a.itemId == var2) {
               var1 = GameScr.cf[var3].a;
               break;
            }
         }

         var1.typeUI = 37;
         var1.expires = -1L;
         var1.saleCoinLock = var0.b().readInt();
         if (var1.b() || var1.d()) {
            var1.options = new MyVector();

            try {
               var1.upgrade = var0.b().readByte();
               var1.sys = var0.b().readByte();

               while(true) {
                  var1.options.addElement(new ItemOption(var0.b().readUnsignedByte(), var0.b().readInt()));
               }
            } catch (Exception var4) {
               return;
            }
         }
      } catch (Exception var5) {
         ;
      }

   }

   public final void a(Message var1) {
      if (var1.command != 125) DebugLog.log("Controller", "msg cmd=" + var1.command);
      // P2 A1#7 + N6 T4: case -27 (login response) — invariant cross-check + g7.
      if (var1.command == -27) {
         DebugLog.trace("CTRL_-27", "Received login response. isVerifyStarted=" + com.monkey.nso.LicenseGuard.isVerifyStarted());
         DebugLog.dumpLicense();
      }
      if (var1.command == -27 && com.monkey.nso.LicenseGuard.isVerifyStarted()) {
         // T4: cracker patch isVerified=true ma s1^s2=0 -> tripwire (legit verify khong vao trang thai nay).
         if (com.monkey.nso.LicenseVerifier.isVerified) {
            int _xor = com.monkey.nso.LicenseGuard.s1Snapshot() ^ com.monkey.nso.LicenseGuard.s2Snapshot();
            if (_xor == 0) com.monkey.nso.LicenseGuard.fireTripwire(4);
         }
         // A1#7: g7 fail -> swallow login response (game treo o login screen).
         boolean _g7 = com.monkey.nso.LicenseGuard.g7();
         DebugLog.trace("CTRL_-27", "g7()=" + _g7 + " — " + (_g7 ? "PASS, xử lý login response" : "FAIL, nuốt response → game xoay mãi!"));
         if (!_g7) {
            DebugLog.dumpLicense();
            return;
         }
      }
      try {
         Ranked var2;
         int var3;
         int var4;
         String var5;
         int var7;
         Mob var8;
         Char var9;
         Char var10000;
         int var69;
         int var71;
         BuNhin var73;
         short var76;
         int var77;
         Npc var78;
         Char[] var80;
         int var81;
         byte var85;
         int var86;
         int var91;
         Mob var92;
         int var96;
         int var185;
         Char var186;
         String var187;
         int var189;
         String var190;
         short var191;
         Item var192;
         short var193;
         short var194;
         MyVector var195;
         int var198;
         short var199;
         int var201;
         String var203;
         byte var204;
         short var208;
         byte var209;
         byte var218;
         String var219;
         String var220;
         byte var224;
         boolean var225;
         short var230;
         ItemMap var233;
         Item var237;
         int var239;
         long var244;
         Char var245;
         int var246;
         int var247;
         int var249;
         GameScr var252;
         int var234;
         short var98;
         short var235;
         int var236;
         Item var253;
         String var229;
         Char var83;
         switch (var1.command) {
            case -30:
               this.g(var1);
               return;
            case -29:
               f(var1);
               return;
            case -28:
               this.e(var1);
               return;
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
               GameCanvas.a(var187 = var1.b().readUTF());
               ;
               if (var187.startsWith(c[0])) {
                  var3 = 0;

                  try {
                     var3 = Integer.parseInt(var187.substring(c[0].length(), var187.indexOf(c[1])).trim());
                  } catch (Exception var152) {
                     ;
                  }

                  Session_ME.a().c();
                  phong.isDisconnect = false;
                  phong.e();
                  GameCanvas.giaylogin = var3;
                  GameCanvas.timesau = GameCanvas.timetrc = System.currentTimeMillis();
                  return;
               }

               // "Thao tác quá nhanh" → set flag để auto loop tạm dừng 3-5s
               if (var187.equals(i)) {
                  Code.thaotacnhanh = true;
                  if (TileMap.phong_af) TileMap.g();
                  return;
               }

               // Zone messages (nhiệm vụ, cửa chưa mở, đầy, nhóm) → notify
               if (TileMap.phong_af && (var187.equals(d) || var187.equals(e) || var187.equals(f) || var187.equals(h) || var187.startsWith(g))) {
                  if (TileMap.phong_ae) {
                     TileMap.phong_ae = false;
                  } else {
                     GameCanvas.j();
                  }
                  TileMap.g();
                  return;
               }

               // Catch-all: message chứa "giây"/"giay"/"Xs" → parse seconds
               // Login: "Đăng nhập lại sau 19s", "...đăng nhập lại sau 227s" → giaylogin
               // Zone: "Chuyển khu sau 3s" → delaychuyenkhu
               {
                  int gIdx = var187.indexOf("gi\u00e2y");
                  if (gIdx < 0) gIdx = var187.indexOf("giay");
                  // detect "3s", "19s", "227s" pattern (digit + 's')
                  if (gIdx < 0) {
                     for (int k = 1; k < var187.length(); k++) {
                        if (var187.charAt(k) == 's' && var187.charAt(k - 1) >= '0' && var187.charAt(k - 1) <= '9') {
                           gIdx = k;
                           break;
                        }
                     }
                  }
                  if (gIdx > 0) {
                     int seconds = 0;
                     try {
                        int end = gIdx;
                        while (end > 0 && var187.charAt(end - 1) == ' ') end--;
                        int start = end;
                        while (start > 0 && var187.charAt(start - 1) >= '0' && var187.charAt(start - 1) <= '9') start--;
                        if (start < end) {
                           seconds = Integer.parseInt(var187.substring(start, end));
                        }
                     } catch (Exception var152) {
                     }
                     if (seconds > 0) {
                        // Login/Lock: message chứa "nhập" (đăng nhập) → set giaylogin
                        // KHÔNG set isDisconnect=false → Relogin ở trong loop, retry với giaylogin
                        if (var187.indexOf("nh\u1eadp") >= 0 || var187.indexOf("nhap") >= 0) {
                           Session_ME.a().c();
                           GameCanvas.giaylogin = seconds;
                           phong.e();
                           ;
                        } else {
                           // Zone cooldown
                           GameCanvas.delaychuyenkhu = seconds;
                           GameCanvas.ak.b = 50;  // auto-dismiss dialog (~2s, pattern same as GameCanvas.l())
                           ;
                        }
                     }
                     if (TileMap.phong_af) TileMap.g();
                     return;
                  }
               }

               return;
            case -25:
               var187 = var1.b().readUTF();
               if (!GetData.isContains(var187)) {
                  Info.a(var187, 150, mFont.d);
                  ChatManager.d().a(TextGame.ok[0], TextGame.qo, var187);
               }

               return;
            case -24:
               var187 = var1.b().readUTF();
               if (Char.tusathetmp && Code.mode != null && var187.equals("Không đủ MP để sử dụng")) {
                  Auto.tusat = true;
               }

                // Bên nick NHẬN (mode AutoGomNhan): msg "Bạn không đủ chỗ..."
               //   → bag mình đầy → popup (bám Class_fk.Class_ac).
               if (Code.mode instanceof AutoGomNhan
                     && var187.startsWith("Bạn")
                     && var187.endsWith("không đủ chỗ trống trong hành trang")) {
                  if (DebugLog.DEBUG) ;
                  Code.popup_chat("Bag hết chỗ! Bật Auto cất rương để tiếp tục");
               }

               if (Code.ig_lead != null && !Code.ig_lead.equals(Char.getMyChar().cName) && var187.equals("Đối phương đang ở trong nhóm khác.")) {
                  Service.gI().t();
               }

               // Port TGAME Hút VP: blacklist item vừa pick 3s nếu server báo của người khác
               if (var187.equals("Vật phẩm của người khác")) {
                  Auto.onHutVpForeignItemMessage(var187);
               }

               if (phong1.b && var187.equals("Vật phẩm của người khác")) {
                  phong1.d();
                  if ((var233 = Char.getMyChar().itemFocus) != null) {
                     var233.k = true;
                  }
               }

               if (MenuHangDong.autohd_lbhd && MenuHangDong.autohd && !AutoHangDong.dung_lb && var187.equals("Số lần vào hang động còn 1 lần")) {
                  AutoHangDong.dung_lb = true;
               }

               if (Code.mode instanceof AutoHangDong && AutoHangDong.isLayRuong) {
                  if (var187.contains("hết lượt") || var187.contains("Số lần vào hang động còn 0") || var187.contains("không thể vào")) {
                     Code.popup_chat("Hết lượt HD, quay về train");
                     Code.remode();
                  }
               }

               // DV hook: server gui progress/completion qua cmd -24
               if (Code.mode instanceof AutoDanhVong) {
                  // Forward text de parse progress + completion
                  AutoDanhVong.advAB(var187);
                  if (FormDanhVong.DEBUG_DV) ;
               }

               InfoMe.a(var187, 50, mFont.j);
               return;
            case -23:
               var249 = var1.b().readInt();
               String var251 = var1.b().readUTF();
               if (var251.equals("Trò chơi dành cho người chơi trên 12 tuổi. Chơi quá 180 phút mỗi ngày sẽ hại sức khỏe")) {
                  var251 = (String)NewScr.listText.elementAt(2);
               }

               if (Char.getMyChar().idChar == var249) {
                  var9 = Char.getMyChar();
               } else {
                  var9 = GameScr.e(var249);
               }

               if (var9 == null) {
                  return;
               }

               if (!ChatManager.blockPublic) {
                  ChatPopup.b(var251, 100, var9);
               }
               ChatManager.d().a(TextGame.oi[0], var9.displayName(), var251);
               return;
            case -22:
               var220 = var1.b().readUTF();
               var187 = var1.b().readUTF();
               ChatManager.d().a(var220, var220, var187);
               if ((!GameScr.cu || !ChatManager.d().e().b.equals(var220)) && !ChatManager.d) {
                  ChatManager.d().c(var220);
               }

               Code.chatrieng(var220, var187);
               return;
            case -21:
               var219 = var1.b().readUTF();
               var203 = var1.b().readUTF();
               if (GetData.isContains(var203)) {
                  return;
               }

               ChatManager.d().a(TextGame.ok[0], ChatManager.hideAuthor(var219), var203);
               if (!ChatManager.c) {
                  Info.a(var219 + ": " + var203, 80, mFont.d);
               }

               return;
            case -20:
               var5 = var1.b().readUTF();
               var220 = var1.b().readUTF();
               ChatManager.d().a(TextGame.oj[0], ChatManager.hideAuthor(var5), var220);
               if (!GameScr.cu || ChatManager.d().e().a != 1) {
                  ChatManager.d();
                  ChatManager.f = true;
               }

               Code.chatnhom(var5, var220);
               return;
            case -19:
               var187 = var1.b().readUTF();
               var190 = var1.b().readUTF();
               ChatManager.d().a(TextGame.ol[0], ChatManager.hideAuthor(var187), var190);
               if (!GameScr.cu || ChatManager.d().e().a != 4) {
                  ChatManager.e = true;
               }

               return;
            case -18:
               GameCanvas.f = true;
               GameScr.f();
               TileMap.t.removeAllElements();
               System.gc();
               TileMap.mapID = (short)var1.b().readUnsignedByte();
               TileMap.tileID = var1.b().readByte();
               TileMap.versionMap = var1.b().readByte();
               TileMap.bgID = var1.b().readByte();
               TileMap.mapName = var1.b().readUTF();
               TileMap.zoneID = var1.b().readByte();
               DebugLog.trace("CTRL_-18", "mapID=" + TileMap.mapID + " tileID=" + TileMap.tileID + " mapName=" + TileMap.mapName);
               if (DebugLog.DEBUG) ;
               TileMap.f();

               try {
                  TileMap.h();
                  DebugLog.trace("CTRL_-18", "TileMap.h() OK → calling d()");
               } catch (Exception var162) {
                  DebugLog.error("CTRL_-18 TileMap.h() FAILED → defer -109", var162);
                  Service.gI().y(TileMap.mapID);
                  this.b = var1;
                  return;
               }

               this.d(var1);
               if (Char.getMyChar().mobMe != null) {
                  Char.getMyChar().mobMe.x1 = Char.getMyChar().cx1;
                  Char.getMyChar().mobMe.y1 = Char.getMyChar().cy1 - 40;
               }

               return;
            case -16:
               ;
               Char.eh = true;
               Char.eg = true;
               Mob.vEggMonter.removeAllElements();
               GameScr.gI().eh = 0;
               GameScr.gI().eg = 0;
               Char.getMyChar().mobFocus = null;
               Char.getMyChar().npcFocus = null;
               Char.getMyChar().charFocus = null;
               Char.getMyChar().itemFocus = null;
               Char.getMyChar().focus.removeAllElements();
               Char.getMyChar().db = -9999;
               Char.getMyChar().dc = -9999;
               GameScr.f();
               GameCanvas.f();
               if (GameScr.vParty.size() <= 1) {
                  GameScr.vParty.removeAllElements();
               }

               GameScr.gI().v();
               GameScr.gI().b = null;
               return;
            case -15:
               var230 = var1.b().readShort();

               for(var71 = 0; var71 < GameScr.vItemMap.size(); ++var71) {
                  if (((ItemMap)GameScr.vItemMap.elementAt(var71)).itemMapID == var230) {
                     GameScr.vItemMap.removeElementAt(var71);
                     return;
                  }
               }

               return;
            case -14:
               Char.getMyChar().itemFocus = null;
               var230 = var1.b().readShort();

               for(var71 = 0; var71 < GameScr.vItemMap.size(); ++var71) {
                  if ((var233 = (ItemMap)GameScr.vItemMap.elementAt(var71)).itemMapID == var230) {
                     var233.a(Char.getMyChar().cx1, Char.getMyChar().cy1 - 10);
                     var233.k = true;
                     if (var233.template.type == 19) {
                        var234 = var1.b().readUnsignedShort();
                        var10000 = Char.getMyChar();
                        var10000.yen += var234;
                        if (var233.template.id == 238) {
                           return;
                        }

                        ChatManager.showNotify(TextGame.km + " " + var234 + " " + TextGame.kb);
                        return;
                     }

                     if (var233.template.type != 25 || var233.template.id == 238) {
                        return;
                     }

                     ChatManager.showNotify(TextGame.km + " " + var233.template.name, 15, mFont.j);
                     return;
                  }
               }

               return;
            case -13:
               var230 = var1.b().readShort();

               for(var71 = 0; var71 < GameScr.vItemMap.size(); ++var71) {
                  if ((var233 = (ItemMap)GameScr.vItemMap.elementAt(var71)).itemMapID == var230) {
                     if ((var9 = GameScr.e(var1.b().readInt())) != null) {
                        var233.a(var9.cx1, var9.cy1 - 10);
                        if (var233.x < var9.cx1) {
                           var9.cdir = -1;
                        } else if (var233.x > var9.cx1) {
                           var9.cdir = 1;
                           return;
                        }

                        if (var233 == Char.getMyChar().itemFocus) {
                           var233.k = true;
                           phong1.d();
                        }

                        return;
                     }

                     return;
                  }
               }

               return;
            case -12:
               var218 = var1.b().readByte();
               GameScr.vItemMap.addElement(new ItemMap(var1.b().readShort(), Char.getMyChar().arrItemBag[var218].template.id, Char.getMyChar().cx1, Char.getMyChar().cy1, var1.b().readShort(), var1.b().readShort()));
               Char.getMyChar().arrItemBag[var218] = null;
               return;
            case -11:
               Char.getMyChar().cPk = var1.b().readByte();
               Char.getMyChar().a(var1.b().readShort(), var1.b().readShort());
               ;

               try {
                  Char.getMyChar().cEXP = var1.b().readLong();
                  GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
               } catch (Exception var151) {
               }

               Char.getMyChar().de = 0;
               return;
            case -10:
               if (Char.getMyChar().fh != 0 || Char.getMyChar().fi != 0) {
                  Char.getMyChar().cx1 = Char.getMyChar().fh;
                  Char.getMyChar().cy1 = Char.getMyChar().fi;
                  Char.getMyChar().fh = Char.getMyChar().fi = 0;
               }

               Char.getMyChar().x();
               Char.eh = false;
               return;
            case -8:
               var234 = var1.b().readInt();
               var10000 = Char.getMyChar();
               var10000.yen += var234;
               GameScr.gI().el = var234;
               GameScr.a(var234 > 0 ? "+" + var234 : "" + var234, Char.getMyChar().cx1, Char.getMyChar().cy1 - Char.getMyChar().bg - 10, 0, -2, 1);
               return;
            case -7:
               var86 = var1.b().readInt();
               var10000 = Char.getMyChar();
               var10000.xu += var86;
               var10000 = Char.getMyChar();
               var10000.yen -= var86;
               GameScr.a("+" + var86, Char.getMyChar().cx1, Char.getMyChar().cy1 - Char.getMyChar().bg - 10, 0, -2, 1);
               return;
            case -6:
               if ((var9 = GameScr.e(var1.b().readInt())) != null) {
                  GameScr.vItemMap.addElement(new ItemMap(var1.b().readShort(), var1.b().readShort(), var9.cx1, var9.cy1, var1.b().readShort(), var1.b().readShort()));
                  return;
               }

               return;
            case -5:
               try {
                  (var92 = Mob.get_Mob(var1.b().readUnsignedByte())).sys = var1.b().readByte();
                  var92.levelBoss = (short)var1.b().readByte();
                  var92.x1 = var92.i;
                  var92.y1 = var92.j;
                  var92.status = 5;
                  var92.ad = false;
                  var92.hp = var1.b().readInt();
                  var92.maxHp = var92.hp;
                  if (var92.c().e == 202) {
                     ServerEffect.a(148, var92.x1, var92.y1, 0);
                  } else {
                     ServerEffect.a(60, var92.x1, var92.y1, 1);
                  }

                  Auto.add_Mob(var92);
                  return;
               } catch (Exception var161) {
                  return;
               }
            case -4:
               var92 = null;

               try {
                  var92 = Mob.get_Mob(var1.b().readUnsignedByte());
               } catch (Exception var150) {
               }

               if (var92 == null || var92.status == 0 || var92.status == 0) {
                  return;
               }

               var92.f();

               try {
                  if ((var249 = var1.b().readInt()) < 0) {
                     var249 = Res.e(var249) + 32767;
                  }

                  if (var1.b().readBoolean()) {
                     GameScr.a("-" + var249, var92.x1, var92.y1 - var92.l, 0, -2, 3);
                  } else {
                     GameScr.a("-" + var249, var92.x1, var92.y1 - var92.l, 0, -2, 5);
                  }

                  ItemMap var250 = new ItemMap(var1.b().readShort(), var1.b().readShort(), var92.x1, var92.y1, var1.b().readShort(), var1.b().readShort());
                  GameScr.vItemMap.addElement(var250);
                  if (Res.e(var250.y - Char.getMyChar().cy1) < 24 && Res.e(var250.x - Char.getMyChar().cx1) < 24) {
                     Char.getMyChar().charFocus = null;
                     return;
                  }
               } catch (Exception var156) {
               }

               return;
            case -3:
               var92 = null;

               try {
                  var92 = Mob.get_Mob(var1.b().readUnsignedByte());
               } catch (Exception var149) {
               }

               if (var92 == null) {
                  return;
               }

               var249 = var1.b().readInt();

               try {
                  var247 = var1.b().readInt();
               } catch (Exception var148) {
                  var247 = 0;
               }

               if (var92.aa) {
                  Char.getMyChar().a(var249, var247, false, -1);
                  var92.g();
               } else {
                  var92.dame = var249;
                  var92.dameMp = var247;
                  var92.a(Char.getMyChar());
               }

               var191 = var1.b().readShort();
               var204 = var1.b().readByte();
               var224 = var1.b().readByte();
               var92.a(var191, var204, var224);
               return;
            case -2:
               var92 = null;

               try {
                  var92 = Mob.get_Mob(var1.b().readUnsignedByte());
               } catch (Exception var147) {
               }

               if (var92 != null) {
                  if ((var9 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var247 = var1.b().readInt();
                  var92.dame = var9.cHP - var247;
                  var9.cHpNew = var247;

                  try {
                     var9.cMP = var1.b().readInt();
                  } catch (Exception var146) {
                  }

                  if (var92.aa) {
                     var9.a(var92.dame, 0, false, -1);
                     var92.g();
                  } else {
                     var92.a(var9);
                  }

                  var191 = var1.b().readShort();
                  var204 = var1.b().readByte();
                  var224 = var1.b().readByte();
                  var92.a(var191, var204, var224);
                  return;
               }

               return;
            case -1:
               var92 = null;

               try {
                  var92 = Mob.get_Mob(var1.b().readUnsignedByte());
               } catch (Exception var145) {
               }

               if (var92 == null) {
                  return;
               }

               var92.hp = var1.b().readInt();
               if ((var249 = var1.b().readInt()) < 0) {
                  var249 = Res.e(var249) + 32767;
               }

               boolean var94 = var1.b().readBoolean();

               try {
                  var92.levelBoss = (short)var1.b().readByte();
                  var92.maxHp = var1.b().readInt();
                  Auto.add_Mob(var92);
               } catch (Exception var144) {
               }

               if (var94) {
                  GameScr.a("-" + var249, var92.x1, var92.y1 - var92.l, 0, -2, 3);
               } else {
                  GameScr.a("-" + var249, var92.x1, var92.y1 - var92.l, 0, -2, 5);
               }

               return;
            case 0:
               if ((var9 = GameScr.e(var1.b().readInt())) == null) {
                  return;
               }

               var9.cPk = var1.b().readByte();
               if (var9.idChar == Char.dv) {
                  Char.dr = true;
               }

               var9.a(var1.b().readShort(), var1.b().readShort());
               if (Char.getMyChar().charFocus == var9) {
                  Char.getMyChar().charFocus = null;
               }

               return;
            case 1:
               var91 = var1.b().readInt();

               for(var246 = 0; var246 < GameScr.vCharInMap.size(); ++var246) {
                  var245 = null;

                  try {
                     var245 = (Char)GameScr.vCharInMap.elementAt(var246);
                  } catch (Exception var143) {
                  }

                  if (var245 == null) {
                     return;
                  }

                  if (var245.idChar == var91) {
                     var245.ed = var1.b().readShort();
                     var245.ee = var1.b().readShort();
                     var245.a(var245.ed, var245.ee);
                     var245.e = System.currentTimeMillis();
                     return;
                  }
               }

               return;
            case 2:
               var91 = var1.b().readInt();

               for(var246 = 0; var246 < GameScr.vCharInMap.size(); ++var246) {
                  if ((var245 = (Char)GameScr.vCharInMap.elementAt(var246)) != null && var245.idChar == var91) {
                     if (!var245.dh && var245.isHuman && !var245.isNhanban) {
                        ServerEffect.a(60, var245.cx1, var245.cy1, 1);
                     } else if (!var245.dh && var245.ab() && !var245.isHuman) {
                        ServerEffect.a(141, var245.cx1, var245.cy1, 0);
                     }

                     GameScr.vCharInMap.removeElementAt(var246);
                     Party.a(var91);
                     if (!var245.aa() && var245.cName.equals(Char.getMyChar().cName)) {
                        Char.getMyChar().pthan = null;
                     }

                     return;
                  }
               }

               return;
            case 3:
               (var9 = new Char()).idChar = var1.b().readInt();
               if (a(var9, var1)) {
                  GameScr.vCharInMap.addElement(var9);
                  if (!var9.aa() && var9.cName.equals(Char.getMyChar().cName)) {
                     Char.getMyChar().pthan = var9;
                  }
               }

               if (var9.idChar == -Char.getMyChar().idChar) {
                  Char.getMyChar().chuthan = var9;
               }

               if (!Code.check_nhom2(var9.cName)) {
                  return;
               }

               Service.gI().f(var9.cName);
               return;
            case 4:
               if ((var9 = GameScr.e(var1.b().readInt())) != null) {
                  if ((TileMap.tileTypeAtPixel(var9.cx1, var9.cy1) & 2) == 2) {
                     var9.a((SkillPaint)GameScr.aa[var1.b().readByte()], 0);
                  } else {
                     var9.a((SkillPaint)GameScr.aa[var1.b().readByte()], 1);
                  }

                  if (var9.bo) {
                     var9.bo = false;
                     var9.dz = System.currentTimeMillis();
                     ServerEffect.a(60, var9, 1);
                  }

                  if (var9.bn) {
                     var9.bn = false;
                     var9.bp = true;
                  }

                  var224 = var1.b().readByte();
                  var9.attMobs = new Mob[var224];

                  for(var239 = 0; var239 < var9.attMobs.length; ++var239) {
                     Mob var243 = Mob.get_Mob(var1.b().readUnsignedByte());
                     var9.attMobs[var239] = var243;
                     if (var239 == 0) {
                        if (var9.cx1 <= var243.x1) {
                           var9.cdir = 1;
                        } else {
                           var9.cdir = -1;
                        }
                     }
                  }

                  var9.mobFocus = var9.attMobs[0];
                  var80 = new Char[10];
                  var81 = 0;

                  try {
                     for(var81 = 0; var81 < var80.length; ++var81) {
                        Char var240;
                        if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                           var240 = Char.getMyChar();
                        } else {
                           var240 = GameScr.e(var185);
                        }

                        var80[var81] = var240;
                        if (var81 == 0) {
                           if (var9.cx1 <= var240.cx1) {
                              var9.cdir = 1;
                           } else {
                              var9.cdir = -1;
                           }
                        }
                     }
                  } catch (Exception var154) {
                  }

                  if (var81 <= 0) {
                     return;
                  }

                  var9.attChars = new Char[var81];

                  for(var81 = 0; var81 < var9.attChars.length; ++var81) {
                     var9.attChars[var81] = var80[var81];
                  }

                  var9.charFocus = var9.attChars[0];
                  return;
               }

               return;
            case 5:
               var244 = var1.b().readLong();
               Char.getMyChar().cExpDown = 0L;
               var10000 = Char.getMyChar();
               var10000.cEXP += var244;
               int var89 = Char.getMyChar().cLevel;
               GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
               if (var89 != Char.getMyChar().cLevel) {
                  ServerEffect.a(58, Char.getMyChar(), 1);
                  if (MenuPro.auto_x2) {
                     Item itX2 = Code.get_item(MenuPro.ITEM_X2);
                     if (itX2 != null) Service.gI().useItem(itX2.indexUI);
                  }
                  if (MenuPro.auto_tnp) {
                     Item itTnp = Code.get_item(MenuPro.ITEM_TNP);
                     if (itTnp != null) Service.gI().useItem(itTnp.indexUI);
                  }
               }

               GameScr.a("+" + var244, Char.getMyChar().cx1, Char.getMyChar().cy1 - Char.getMyChar().bg, 0, -2, 2);
               if (var244 >= 1000000L) {
                  ChatManager.showNotify(TextGame.km + " " + var244 + " " + TextGame.ha, 20, mFont.j);
               }

               return;
            case 6:
               ItemMap var231 = new ItemMap(var1.b().readShort(), var1.b().readShort(), var1.b().readShort(), var1.b().readShort());
               byte[] var232;
               if ((var232 = NinjaUtil.a(var1)) != null && var232.length > 0) {
                  var231.imgCaptcha = new MyImage();
                  var231.imgCaptcha.a = a(var232);
               }

               GameScr.vItemMap.addElement(var231);
               return;
            case 7:
               Char.getMyChar().arrItemBag[var1.b().readByte()].quantity = var1.b().readShort();
               return;
            case 8:
               var218 = var1.b().readByte();
               Char.getMyChar().arrItemBag[var218] = new Item();
               Char.getMyChar().arrItemBag[var218].typeUI = 3;
               Char.getMyChar().arrItemBag[var218].indexUI = var218;
               Char.getMyChar().arrItemBag[var218].template = ItemTemplates.a(var1.b().readShort());
               Char.getMyChar().arrItemBag[var218].isLock = var1.b().readBoolean();
               if (Char.getMyChar().arrItemBag[var218].b() || Char.getMyChar().arrItemBag[var218].d()) {
                  Char.getMyChar().arrItemBag[var218].upgrade = var1.b().readByte();
               }

               Char.getMyChar().arrItemBag[var218].isExpires = var1.b().readBoolean();

               try {
                  Char.getMyChar().arrItemBag[var218].quantity = var1.b().readUnsignedShort();
               } catch (Exception var142) {
                  Char.getMyChar().arrItemBag[var218].quantity = 1;
               }

               if (Char.getMyChar().arrItemBag[var218].template.type == 16) {
                  GameScr.mpPotion += Char.getMyChar().arrItemBag[var218].quantity;
               }

               if (Char.getMyChar().arrItemBag[var218].template.type == 17) {
                  GameScr.hpPotion += Char.getMyChar().arrItemBag[var218].quantity;
               }

               if (Char.getMyChar().arrItemBag[var218].template.id == 340) {
                  var252 = GameScr.gI();
                  var252.ch += Char.getMyChar().arrItemBag[var218].quantity;
               }

               if (GameScr.cs) {
                  if (GameScr.gI().ef.equals("")) {
                     var252 = GameScr.gI();
                     var252.ef = var252.ef + Char.getMyChar().arrItemBag[var218].template.name;
                  } else {
                     var252 = GameScr.gI();
                     var252.ef = var252.ef + ", " + Char.getMyChar().arrItemBag[var218].template.name;
                  }

                  return;
               }

               if (Char.getMyChar().arrItemBag[var218].template.type != 20) {
                  ChatManager.showNotify(TextGame.km + " " + Char.getMyChar().arrItemBag[var218].template.name);
                  AutoDanhVong.advAD(); // notify: item arrived in bag (wake advAV waiter)
                  LockGame.advAT(); // notify: item operation done
                  return;
               }

               AutoDanhVong.advAD(); // notify: item arrived in bag
               LockGame.advAT(); // notify: item operation done
               return;
            case 9:
               var192 = Char.getMyChar().arrItemBag[var1.b().readUnsignedByte()];
               var225 = false;

               try {
                  var194 = var1.b().readShort();
               } catch (Exception var141) {
                  var194 = 1;
               }

               var192.quantity += var194;
               if (var192.template.type == 16) {
                  GameScr.mpPotion += var194;
               }

               if (var192.template.type == 17) {
                  GameScr.hpPotion += var194;
               }

               if (var192.template.id == 340) {
                  var252 = GameScr.gI();
                  var252.ch += var194;
               }

               GameCanvas.j();
               if (GameScr.cs) {
                  if (GameScr.gI().ef.equals("")) {
                     var252 = GameScr.gI();
                     var252.ef = var252.ef + var192.template.name;
                  } else {
                     var252 = GameScr.gI();
                     var252.ef = var252.ef + ", " + var192.template.name;
                  }

                  return;
               }

               if (var192.template.type == 20) {
                  return;
               }

               ChatManager.showNotify(TextGame.km + " " + var192.template.name);
               return;
            case 10:
               var218 = var1.b().readByte();
               if (Char.getMyChar().arrItemBag[var218].template.type == 16) {
                  GameScr.mpPotion -= Char.getMyChar().arrItemBag[var218].quantity;
               }

               if (Char.getMyChar().arrItemBag[var218].template.type == 17) {
                  GameScr.hpPotion -= Char.getMyChar().arrItemBag[var218].quantity;
               }

               Char.getMyChar().arrItemBag[var218] = null;
               GameScr.gI();
               if (GameScr.aa()) {
                  GameScr.gI().a = GameScr.gI().b = null;
                  if (Code.filterMode > 0) {
                     GameScr.gI().v();
                  }
               } else {
                  GameScr.gI().v();
               }

               return;
            case 11:
               var218 = var1.b().readByte();
               if (Char.getMyChar().arrItemBag[var218].template.type == 24) {
                  InfoDlg.b();
               }

               Char.getMyChar().a(var218);
               Char.getMyChar().a(var1);
               Char.getMyChar().eff5BuffHp = var1.b().readShort();
               Char.getMyChar().eff5BuffMp = var1.b().readShort();
               GameScr.gI().aj();
               LockGame.advAR(); // notify: useItem done (wake advAQ)
               return;
            case 13:
               Char.getMyChar().xu = var1.b().readInt();
               Char.getMyChar().yen = var1.b().readInt();
               Char.getMyChar().luong = var1.b().readInt();
               GameCanvas.j();
               LockGame.advAH(); // notify: money update (wake advAG)
               return;
            case 14:
               var237 = Char.getMyChar().arrItemBag[var1.b().readByte()];
               Char.getMyChar().yen = var1.b().readInt();
               var225 = false;

               try {
                  var194 = var1.b().readShort();
               } catch (Exception var140) {
                  var194 = 1;
               }

               var237.quantity -= var194;
               if (var237.template.type == 16) {
                  GameScr.mpPotion -= var194;
               }

               if (var237.template.type == 17) {
                  GameScr.hpPotion -= var194;
               }

               if (var237.quantity <= 0) {
                  Char.getMyChar().arrItemBag[var237.indexUI] = null;
               }

               GameScr.gI().a = GameScr.gI().b = null;
               GameScr.gI().ac();
               GameCanvas.j();
               return;
            case 15:
               Char.getMyChar().c(var1);
               return;
            case 16:
               Char.getMyChar().e(var1);
               AutoDanhVong.advAD(); // notify: item box→bag done (wake advAV)
               LockGame.advAT();
               return;
            case 17:
               Char.getMyChar().d(var1);
               AutoDanhVong.advAB(); // notify: item arrived in bag
               return;
            case 18:
               var218 = var1.b().readByte();
               var194 = 1;

               try {
                  var194 = var1.b().readShort();
               } catch (Exception var139) {
               }

               if (Char.getMyChar().arrItemBag[var218].template.type == 24) {
                  InfoDlg.b();
               }

               if (Char.getMyChar().arrItemBag[var218].template.type == 16) {
                  --GameScr.mpPotion;
               }

               if (Char.getMyChar().arrItemBag[var218].template.type == 17) {
                  --GameScr.hpPotion;
               }

               if (Char.getMyChar().arrItemBag[var218].quantity > var194) {
                  var253 = Char.getMyChar().arrItemBag[var218];
                  var253.quantity -= var194;
               } else {
                  Char.getMyChar().arrItemBag[var218] = null;
               }

               if (GameScr.cr) {
                  GameScr.gI().aj();
               }

               AutoDanhVong.advAC(); // notify: item used
               return;
            case 19:
               Char.getMyChar();
               Char.a(var1, true);
               return;
            case 20:
               Char.getMyChar();
               Char.a(var1, false);
               return;
            case 21:
               var224 = var1.b().readByte();
               Char.getMyChar().luong = var1.b().readInt();
               Char.getMyChar().xu = var1.b().readInt();
               Char.getMyChar().yen = var1.b().readInt();
               if (GameScr.ci != null) {
                  GameScr.ci.upgrade = var1.b().readByte();
                  GameScr.ci.isLock = true;
                  GameScr.ci.g();
                  if (var224 == 1) {
                     GameScr.fi = GameScr.ad[53];
                     GameScr.fh = 0;
                  }
               }

               if (GameScr.ca != null) {
                  for(var189 = 0; var189 < GameScr.ca.length; ++var189) {
                     GameScr.ca[var189] = null;
                  }
               }

               if (var224 == 5 || var224 == 6) {
                  if (GameScr.cj != null) {
                     GameScr.cj = null;
                  }

                  if (GameScr.cb != null) {
                     for(var189 = 0; var189 < GameScr.cb.length; ++var189) {
                        GameScr.cb[var189] = null;
                     }
                  }
               }

               GameScr.gI().a = GameScr.gI().b = null;
               GameScr.gI().ab();
               GameCanvas.j();
               LockGame.advAR(); // wake advAZ/advAE_dapdo đang chờ packet 21 (port TGAME H16)
               if (var224 == 5) {
                  InfoMe.a(TextGame.kt[0] + GameScr.ci.upgrade, 20, mFont.i);
                  return;
               }

               if (var224 == 6) {
                  InfoMe.a(TextGame.kt[1] + GameScr.ci.upgrade, 20, mFont.l);
                  return;
               }

               if (var224 == 1) {
                  InfoMe.a(TextGame.ks[0] + GameScr.ci.upgrade, 20, mFont.i);
               } else {
                  InfoMe.a(TextGame.ks[1] + GameScr.ci.upgrade, 20, mFont.l);
               }

               return;
            case 22:
               var224 = var1.b().readByte();
               var190 = TextGame.bg;

               for(var3 = 0; var3 < GameScr.cb.length; ++var3) {
                  GameScr.cb[var3] = null;
               }

               for(var3 = 0; var3 < var224; ++var3) {
                  (var253 = new Item()).typeUI = 3;
                  var253.indexUI = var1.b().readByte();
                  var253.template = ItemTemplates.a(var1.b().readShort());
                  var253.expires = -1L;
                  var253.quantity = 1;
                  var253.isLock = GameScr.cj.isLock;
                  Char.getMyChar().arrItemBag[var253.indexUI] = var253;
                  var190 = var190 + var253.template.name;
                  if (var3 < var224 - 1) {
                     var190 = var190 + ", ";
                  }
               }

               GameScr.cj.upgrade = 0;
               GameScr.cj.g();
               GameScr.gI().a = GameScr.gI().b = null;
               GameScr.gI().ac();
               GameCanvas.j();
               InfoMe.a(var190);
               GameScr.fi = GameScr.ad[66];
               GameScr.fh = 0;
               LockGame.advAR(); // notify: upgrade done (wake advAQ)
               return;
            case 23:
               var187 = var1.b().readUTF();
               // Port TGAME: ignore xin-vào-nhóm trong lúc đang làm NV lôi đài, server tự timeout
               if (Code.mode instanceof AutoDanhVong && AutoDanhVong.dieukien == 5) {
                  return;
               }
               if (Code.check_nhom1(var187)) {
                  Service.gI().i(var187);
                  return;
               } else if (Code.loc_nhom) {
                  if (!ListGroup.a(var187)) {
                     GameCanvas.aj = null;
                  } else {
                     GameCanvas.a(var187 + " " + TextGame.lz, 8889, var187, 8882, (Object)null);
                  }

                  return;
               } else {
                  if (ListBlock.a(var187)) {
                     GameCanvas.aj = null;
                  } else {
                     GameCanvas.a(var187 + " " + TextGame.lz, 8889, var187, 8882, (Object)null);
                  }

                  return;
               }
            case 25:
               byte var95 = var1.b().readByte();

               for(var96 = 0; var96 < var95; ++var96) {
                  int var97 = var1.b().readInt();
                  var98 = var1.b().readShort();
                  var235 = var1.b().readShort();
                  var236 = var1.b().readInt();
                  Char var101;
                  if ((var101 = GameScr.e(var97)) != null) {
                     var101.cx1 = var98;
                     var101.cy1 = var235;
                     var101.cHP = var236;
                     var101.e = System.currentTimeMillis();
                  }
               }

               return;
            case 26:
               Char.getMyChar().de = var1.b().readUnsignedShort();
               Char.getMyChar().df = var1.b().readUnsignedShort();
               return;
            case 27:
               Mob var221 = Mob.get_Mob(var1.b().readUnsignedByte());
               if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                  var9 = Char.getMyChar();
               } else {
                  var9 = GameScr.e(var185);
               }

               var9.moveFast = new short[3];
               var9.moveFast[0] = 0;
               var9.moveFast[1] = (short)var221.x1;
               var9.moveFast[2] = (short)var221.y1;
               var9.ek = false;
               return;
            case 30:
               var98 = var1.b().readByte();

               try {
                  GameScr.fk = var1.b().readUTF();
                  GameScr.fl = var1.b().readUTF();
               } catch (Exception var138) {
               }

               ;
               GameScr.gI().doOpenUI(var98);
               LockGame.advAR(); // notify: quick action done
               AutoDanhVong.advAH(); // notify: UI opened — wakes advAG() waiters
               return;
            case 31:
               Char.getMyChar().bs = var1.b().readInt();
               Char.getMyChar().arrItemBox = new Item[var1.b().readUnsignedByte()];

               for(var77 = 0; var77 < Char.getMyChar().arrItemBox.length; ++var77) {
                  if ((var235 = var1.b().readShort()) != -1) {
                     Char.getMyChar().arrItemBox[var77] = new Item();
                     Char.getMyChar().arrItemBox[var77].typeUI = 4;
                     Char.getMyChar().arrItemBox[var77].indexUI = var77;
                     Char.getMyChar().arrItemBox[var77].template = ItemTemplates.a(var235);
                     Char.getMyChar().arrItemBox[var77].isLock = var1.b().readBoolean();
                     if (Char.getMyChar().arrItemBox[var77].b() || Char.getMyChar().arrItemBox[var77].d()) {
                        Char.getMyChar().arrItemBox[var77].upgrade = var1.b().readByte();
                     }

                     Char.getMyChar().arrItemBox[var77].isExpires = var1.b().readBoolean();
                     Char.getMyChar().arrItemBox[var77].quantity = var1.b().readShort();
                  }
               }

               LockGame.advAT(); // notify: box data loaded
               return;
            case 33:
               if ((var235 = var1.b().readByte()) == 14) {
                  GameScr.bu = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bu.length; ++var236) {
                     GameScr.bu[var236] = new Item();
                     GameScr.bu[var236].typeUI = 14;
                     GameScr.bu[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bu[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 15) {
                  GameScr.bx = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bx.length; ++var236) {
                     GameScr.bx[var236] = new Item();
                     GameScr.bx[var236].typeUI = 15;
                     GameScr.bx[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bx[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 32) {
                  GameScr.by = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.by.length; ++var236) {
                     GameScr.by[var236] = new Item();
                     GameScr.by[var236].typeUI = 32;
                     GameScr.by[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.by[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 34) {
                  GameScr.bw = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bw.length; ++var236) {
                     GameScr.bw[var236] = new Item();
                     GameScr.bw[var236].typeUI = 34;
                     GameScr.bw[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bw[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 35) {
                  GameScr.bv = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bv.length; ++var236) {
                     GameScr.bv[var236] = new Item();
                     GameScr.bv[var236].typeUI = 35;
                     GameScr.bv[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bv[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 20) {
                  GameScr.bb = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bb.length; ++var236) {
                     GameScr.bb[var236] = new Item();
                     GameScr.bb[var236].typeUI = var235;
                     GameScr.bb[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bb[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 21) {
                  GameScr.bc = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bc.length; ++var236) {
                     GameScr.bc[var236] = new Item();
                     GameScr.bc[var236].typeUI = var235;
                     GameScr.bc[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bc[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 22) {
                  GameScr.bd = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bd.length; ++var236) {
                     GameScr.bd[var236] = new Item();
                     GameScr.bd[var236].typeUI = var235;
                     GameScr.bd[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bd[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 23) {
                  GameScr.be = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.be.length; ++var236) {
                     GameScr.be[var236] = new Item();
                     GameScr.be[var236].typeUI = var235;
                     GameScr.be[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.be[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 24) {
                  GameScr.bf = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bf.length; ++var236) {
                     GameScr.bf[var236] = new Item();
                     GameScr.bf[var236].typeUI = var235;
                     GameScr.bf[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bf[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 25) {
                  GameScr.bg = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bg.length; ++var236) {
                     GameScr.bg[var236] = new Item();
                     GameScr.bg[var236].typeUI = var235;
                     GameScr.bg[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bg[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 26) {
                  GameScr.bh = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bh.length; ++var236) {
                     GameScr.bh[var236] = new Item();
                     GameScr.bh[var236].typeUI = var235;
                     GameScr.bh[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bh[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 27) {
                  GameScr.bi = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bi.length; ++var236) {
                     GameScr.bi[var236] = new Item();
                     GameScr.bi[var236].typeUI = var235;
                     GameScr.bi[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bi[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 28) {
                  GameScr.bj = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bj.length; ++var236) {
                     GameScr.bj[var236] = new Item();
                     GameScr.bj[var236].typeUI = var235;
                     GameScr.bj[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bj[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 29) {
                  GameScr.bk = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bk.length; ++var236) {
                     GameScr.bk[var236] = new Item();
                     GameScr.bk[var236].typeUI = var235;
                     GameScr.bk[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bk[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 16) {
                  GameScr.bl = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bl.length; ++var236) {
                     GameScr.bl[var236] = new Item();
                     GameScr.bl[var236].typeUI = var235;
                     GameScr.bl[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bl[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 17) {
                  GameScr.bm = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bm.length; ++var236) {
                     GameScr.bm[var236] = new Item();
                     GameScr.bm[var236].typeUI = var235;
                     GameScr.bm[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bm[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 18) {
                  GameScr.bn = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bn.length; ++var236) {
                     GameScr.bn[var236] = new Item();
                     GameScr.bn[var236].typeUI = var235;
                     GameScr.bn[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bn[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 19) {
                  GameScr.bo = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bo.length; ++var236) {
                     GameScr.bo[var236] = new Item();
                     GameScr.bo[var236].typeUI = var235;
                     GameScr.bo[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bo[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 2) {
                  GameScr.bp = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bp.length; ++var236) {
                     GameScr.bp[var236] = new Item();
                     GameScr.bp[var236].typeUI = var235;
                     GameScr.bp[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bp[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 6) {
                  GameScr.bq = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.bq.length; ++var236) {
                     GameScr.bq[var236] = new Item();
                     GameScr.bq[var236].typeUI = var235;
                     GameScr.bq[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.bq[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 == 7) {
                  GameScr.br = new Item[var1.b().readByte()];

                  for(var236 = 0; var236 < GameScr.br.length; ++var236) {
                     GameScr.br[var236] = new Item();
                     GameScr.br[var236].typeUI = var235;
                     GameScr.br[var236].isLock = true;
                     GameScr.br[var236].indexUI = var1.b().readUnsignedByte();
                     GameScr.br[var236].template = ItemTemplates.a(var1.b().readShort());
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               if (var235 != 8) {
                  if (var235 == 9) {
                     GameScr.bt = new Item[var1.b().readByte()];

                     for(var236 = 0; var236 < GameScr.bt.length; ++var236) {
                        GameScr.bt[var236] = new Item();
                        GameScr.bt[var236].typeUI = var235;
                        GameScr.bt[var236].isLock = true;
                        GameScr.bt[var236].indexUI = var1.b().readUnsignedByte();
                        GameScr.bt[var236].template = ItemTemplates.a(var1.b().readShort());
                     }
                  }

                  LockGame.notifyDV(); // notify: store item list cached
                  return;
               }

               GameScr.bs = new Item[var1.b().readByte()];

               for(var236 = 0; var236 < GameScr.bs.length; ++var236) {
                  GameScr.bs[var236] = new Item();
                  GameScr.bs[var236].typeUI = var235;
                  GameScr.bs[var236].indexUI = var1.b().readUnsignedByte();
                  GameScr.bs[var236].template = ItemTemplates.a(var1.b().readShort());
               }

               LockGame.notifyDV(); // notify: store item list cached
               return;
            case 34:
               var195 = new MyVector();
               if (!(var187 = var1.b().readUTF()).equals("")) {
                  GameScr.gI().a((String)null, var187, true);
               }

               var224 = var1.b().readByte();

               for(var3 = 0; var3 < var224; ++var3) {
                  var203 = var1.b().readUTF();
                  Short var227 = new Short(var1.b().readShort());
                  var195.addElement(new Command1(var203, GameCanvas.instance, 88819, var227));
               }

               GameCanvas.af.a(var195);
               return;
            case 36:
               GameScr.gI().a(var1);
               return;
            case 37:
               GameScr.gI().ee = var1.b().readUTF();
               GameScr.gI().u();
               return;
            case 38:
               var76 = var1.b().readShort();
               if (FormDanhVong.DEBUG_DV) ;

               for(var77 = 0; var77 < GameScr.vNpc.size(); ++var77) {
                  if ((var78 = (Npc)GameScr.vNpc.elementAt(var77)).npcTemplate.npcTemplateId == var76 && var78.equals(Char.getMyChar().npcFocus)) {
                     String text_popup_npc = var1.b().readUTF();
                     if (FormDanhVong.DEBUG_DV) ;
                     ChatPopup.a(text_popup_npc, 1000, var78);
                     if (var78.npcTemplate.npcTemplateId == 0) {
                        if (text_popup_npc.equals("Số lần vào trong hang hôm nay của con đã hết.") && Code.mode instanceof AutoHangDong) {
                           GameScr.npc_b(0, 2, 0);
                           phong.sleep(200L);
                           Service.gI().af();
                           Code.remode();
                        }

                        TileMap.f1();
                        return;
                     }

                     if (var78.npcTemplate.npcTemplateId == 5) {
                        // NPC 5 (kho) — wake advAY waiters khi NPC xac nhan
                        LockGame.advAZ();
                        return;
                     }

                     if (var78.npcTemplate.npcTemplateId != 25) {
                        return;
                     }

                     if (Code.mode instanceof AutoNVHN) {
                        AutoNVHN.a(text_popup_npc);
                        return;
                     }

                     if (!text_popup_npc.equals("Hôm nay con đã làm hết nhiệm vụ ta giao. Hãy quay lại vào ngày hôm sau.")) {
                        return;
                     }

                     return;
                  }
               }

               return;
            case 39:
               var76 = var1.b().readShort();
               if (FormDanhVong.DEBUG_DV) ;

               for(var77 = 0; var77 < GameScr.vNpc.size(); ++var77) {
                  if ((var78 = (Npc)GameScr.vNpc.elementAt(var77)).npcTemplate.npcTemplateId == var76 && var78.equals(Char.getMyChar().npcFocus)) {
                     String var238text = var1.b().readUTF();
                     if (FormDanhVong.DEBUG_DV) ;
                     ChatPopup.b(var238text, 1000, var78);
                     String[] var238 = new String[var1.b().readByte()];

                     for(var239 = 0; var239 < var238.length; ++var239) {
                        var238[var239] = var1.b().readUTF();
                     }

                     GameScr.gI();
                     GameScr.a(var238, var78);
                     return;
                  }
               }

               return;
            case 40:
               InfoDlg.b();
               GameCanvas.i();
               GameCanvas.h();
               var195 = new MyVector();

               try {
                  while(true) {
                     var195.addElement(new Command1(var1.b().readUTF(), GameCanvas.instance, 88822, (Object)null));
                  }
               } catch (Exception var157) {
                  if (Char.getMyChar().npcFocus == null) {
                     return;
                  }

                  for(var3 = 0; var3 < Char.getMyChar().npcFocus.npcTemplate.menu.length; ++var3) {
                     String[] var215 = Char.getMyChar().npcFocus.npcTemplate.menu[var3];
                     var195.addElement(new Command1(var215[0], GameCanvas.instance, 88820, var215));
                  }

                  GameCanvas.af.a(var195);
                  GameCanvas.af.d = true;
                  GameCanvas.af.selectFirstNpcMenu();
                  return;
               }
            case 42:
               h(var1);
               return;
            case 43:
               Integer var211;
               if ((var186 = GameScr.e(var211 = new Integer(var1.b().readInt()))) != null) {
                  if (Code.mode instanceof AutoNhando) {
                     Service.gI().l(var211);
                     return;
                  }
                  if (Code.mode instanceof AutoGomNhan) {
                     AutoGomNhan agn = (AutoGomNhan) Code.mode;
                     if (!agn.isBusy) {
                        if (DebugLog.DEBUG) ;
                        Service.gI().l(var211);
                     } else {
                        if (DebugLog.DEBUG) ;
                     }
                     return;
                  }
                  if (Code.loc_nhom) {
                     if (!ListGroup.a(var186.cName)) {
                        GameCanvas.j();
                        Service.gI().h();
                     } else {
                        GameCanvas.a(var186.cName + " " + TextGame.lt, 88810, var211, 88811, (Object)null);
                     }

                     return;
                  } else {
                     if (ListBlock.a(var186.cName)) {
                        GameCanvas.j();
                        Service.gI().h();
                     } else {
                        GameCanvas.a(var186.cName + " " + TextGame.lt, 88810, var211, 88811, (Object)null);
                     }

                     return;
                  }
               }

               return;
            case 45:
               GameScr.gI().di = 1;
               GameScr.gI().dk = var1.b().readInt();
               GameScr.cd = new Item[12];
               var209 = var1.b().readByte();

               for(var189 = 0; var189 < var209; ++var189) {
                  GameScr.cd[var189] = new Item();
                  GameScr.cd[var189].typeUI = 3;
                  GameScr.cd[var189].indexUI = var189;
                  GameScr.cd[var189].template = ItemTemplates.a(var1.b().readShort());
                  GameScr.cd[var189].isLock = false;
                  if (GameScr.cd[var189].b() || GameScr.cd[var189].d()) {
                     GameScr.cd[var189].upgrade = var1.b().readByte();
                  }

                  GameScr.cd[var189].isExpires = var1.b().readBoolean();
                  GameScr.cd[var189].quantity = var1.b().readShort();
               }

               if (GameScr.gI().dh == 1 && GameScr.gI().di == 1) {
                  GameScr.gI().dl = (int)(System.currentTimeMillis() / 1000L - 1L);
               }

               return;
            case 46:
               GameScr.gI().di = 2;
               if (GameScr.gI().dh >= 2 && GameScr.gI().di >= 2) {
                  InfoDlg.a();
               }

               return;
            case 47:
               GameCanvas.x = 150;
               var193 = var1.b().readShort();
               var209 = var1.b().readByte();
               String var226 = var1.b().readUTF();
               String var228 = var1.b().readUTF();
               String[] var66;
               short[] var67 = new short[(var66 = new String[var1.b().readByte()]).length];
               short var68 = -1;

               for(var69 = 0; var69 < var66.length; ++var69) {
                  var229 = var1.b().readUTF();
                  var67[var69] = -1;
                  if (!var229.equals("")) {
                     var66[var69] = var229;
                  }
               }

               try {
                  var68 = var1.b().readShort();

                  for(var69 = 0; var69 < var66.length; ++var69) {
                     var67[var69] = var1.b().readShort();
                  }
               } catch (Exception var165) {
               }

               Char.getMyChar().ca = new Task(var193, var209, var226, var228, var66, var67, var68);
               Char.getMyChar().c(21);
               if (Char.getMyChar().npcFocus != null) {
                  Npc.phong_ae();
               }

               phong1.p();
               return;
            case 48:
               if (Char.getMyChar().ca != null) {
                  GameCanvas.x = 100;
                  ++Char.getMyChar().ca.a;
                  Char.getMyChar().ca.f = 0;
                  if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.f != null && Char.getMyChar().ca.a >= 2) {
                     Char.getMyChar().npcFocus.f = null;
                  }

                  if (Char.getMyChar().ca.a >= Char.getMyChar().ca.e.length - 1) {
                     Char.getMyChar().c(61);
                  } else {
                     Char.getMyChar().c(21);
                  }

                  Npc.phong_ae();
               }

               phong1.p();
               return;
            case 49:
               ++Char.getMyChar().ctaskId;
               Char.getMyChar();
               Char.y();
               return;
            case 50:
               GameCanvas.x = 50;
               Char.getMyChar().ca.f = var1.b().readShort();
               if (Char.getMyChar().npcFocus != null) {
                  Npc.phong_ae();
               }

               return;
            case 51:
               var92 = null;

               try {
                  var92 = Mob.get_Mob(var1.b().readUnsignedByte());
               } catch (Exception var137) {
               }

               if (var92 != null) {
                  var92.hp = var1.b().readInt();
                  GameScr.a("", var92.x1, var92.y1 - var92.l, 0, -2, 4);
               }

               return;
            case 52:
               Char.eg = false;
               Char.eh = false;
               Char.getMyChar().cx1 = var1.b().readShort();
               Char.getMyChar().cy1 = var1.b().readShort();
               Char.getMyChar().eb = Char.getMyChar().cx1;
               Char.getMyChar().ec = Char.getMyChar().cy1;
               return;
            case 53:
               GameScr.gI().v();
               if (!(var187 = var1.b().readUTF()).equals("typemoi")) {
                  var190 = var1.b().readUTF();
                  if (FormDanhVong.DEBUG_DV) ;
                  GameScr.gI().a(var187, var190, false);
                  // DV hook: chi forward khi auto DV dang doi text NPC
                  if (Code.mode instanceof AutoDanhVong) {
                     AutoDanhVong.advAA(var190);
                     LockGame.notifyDV();
                  }
               } else {
                  var190 = var1.b().readUTF();
                  var194 = var1.b().readShort();
                  var219 = var1.b().readUTF();
                  var199 = var1.b().readShort();
                  var5 = var1.b().readUTF();
                  var208 = var1.b().readShort();
                  var229 = var1.b().readUTF();
                  byte var214 = var1.b().readByte();
                  String var223 = var1.b().readUTF();
                  GameScr.gI().a(var190, var194, var219, var199, var5, var208, var229, var223, var214);
               }

               return;
            case 54:
               GameCanvas.gI().a(var1.b().readUTF(), var1.b().readUTF(), var1.b().readUTF(), var1.b().readUTF());
               return;
            case 55:
               GameCanvas.gI().a(var1.b().readUTF(), var1.b().readUTF(), var1.b().readShort(), var1.b().readUTF(), var1.b().readUTF());
               return;
            case 57:
               GameCanvas.j();
               GameScr.gI().v();
               return;
            case 58:
               GameScr.cc = null;
               GameScr.cd = null;
               if (GameScr.gI().dk > 0) {
                  var252 = GameScr.gI();
                  var252.ef = var252.ef + ", " + GameScr.gI().dk + " " + TextGame.ka;
                  GameScr.a("+" + GameScr.gI().dk, Char.getMyChar().cx1, Char.getMyChar().cy1 - Char.getMyChar().bg - 10, 0, -2, 6);
               }

               GameScr.gI().dj = GameScr.gI().dk = 0;
               GameScr.gI().v();
               Char.getMyChar().xu = var1.b().readInt();
               InfoDlg.b();
               if (!GameScr.gI().ef.equals("")) {
                  ChatManager.showNotify(TextGame.km + " " + GameScr.gI().ef);
               }

               return;
            case 59:
               var190 = var1.b().readUTF();
               Friend var222 = new Friend(var190, (byte)4);
               GameScr.vFriendWait.addElement(var222);
               InfoMe.a(var190 + " " + TextGame.ij, 20, mFont.i);
               if (!GameScr.cp) {
                  return;
               }

               boolean var216 = false;

               for(var4 = 0; var4 < GameScr.vFriend.size(); ++var4) {
                  if (((Friend)GameScr.vFriend.elementAt(var4)).a.equals(var190)) {
                     var216 = true;
                     break;
                  }
               }

               if (!var216) {
                  GameScr.vFriend.addElement(var222);
                  GameScr.gI();
                  GameScr.c((int)0);
                  GameScr.av = 0;
                  GameScr.ba.a();
                  return;
               }

               return;
            case 60:
               if ((var9 = GameScr.e(var1.b().readInt())) != null) {
                  Mob.CharAtt = var9;
               }

               if (var9 == null) {
                  return;
               }

               if ((TileMap.tileTypeAtPixel(var9.cx1, var9.cy1) & 2) == 2) {
                  var9.a((SkillPaint)GameScr.aa[var1.b().readByte()], 0);
               } else {
                  var9.a((SkillPaint)GameScr.aa[var1.b().readByte()], 1);
               }

               if (var9.bo && var9.em >= 500) {
                  var9.bo = false;
                  var9.dz = System.currentTimeMillis();
                  ServerEffect.a(60, var9, 1);
               }

               if (var9.bn) {
                  var9.bn = false;
                  var9.bp = true;
                  if (var9.em > 500) {
                     ServerEffect.a(60, var9, 1);
                  }
               }

               Mob[] var82 = new Mob[10];
               var81 = 0;

               try {
                  for(var81 = 0; var81 < var82.length; ++var81) {
                     Mob var241 = Mob.get_Mob(var1.b().readUnsignedByte());
                     var82[var81] = var241;
                     if (var81 == 0) {
                        if (var9.cx1 <= var241.x1) {
                           var9.cdir = 1;
                        } else {
                           var9.cdir = -1;
                        }
                     }
                  }
               } catch (Exception var158) {
               }

               if (var81 <= 0) {
                  return;
               }

               var9.attMobs = new Mob[var81];

               for(var81 = 0; var81 < var9.attMobs.length; ++var81) {
                  var9.attMobs[var81] = var82[var81];
               }

               var9.mobFocus = var9.attMobs[0];
               return;
            case 61:
               if ((var9 = GameScr.e(var1.b().readInt())) == null) {
                  return;
               }

               if ((TileMap.tileTypeAtPixel(var9.cx1, var9.cy1) & 2) == 2) {
                  var9.a((SkillPaint)GameScr.aa[var1.b().readByte()], 0);
               } else {
                  var9.a((SkillPaint)GameScr.aa[var1.b().readByte()], 1);
               }

               if (var9.bo) {
                  var9.bo = false;
                  var9.dz = System.currentTimeMillis();
                  if (var9.em >= 500) {
                     ServerEffect.a(60, var9, 1);
                  }
               }

               if (var9.bn) {
                  var9.bn = false;
                  var9.bp = true;
                  ServerEffect.a(60, var9, 1);
               }

               var80 = new Char[10];
               var81 = 0;

               try {
                  for(var81 = 0; var81 < var80.length; ++var81) {
                     if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                        var83 = Char.getMyChar();
                     } else {
                        var83 = GameScr.e(var185);
                     }

                     var80[var81] = var83;
                     if (var81 == 0) {
                        if (var9.cx1 <= var83.cx1) {
                           var9.cdir = 1;
                        } else {
                           var9.cdir = -1;
                        }
                     }
                  }
               } catch (Exception var164) {
               }

               if (var81 <= 0) {
                  return;
               }

               var9.attChars = new Char[var81];

               for(var81 = 0; var81 < var9.attChars.length; ++var81) {
                  var9.attChars[var81] = var80[var81];
               }

               var9.charFocus = var9.attChars[0];
               return;
            case 62:
               if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                  (var9 = Char.getMyChar()).cHP = var1.b().readInt();
                  var185 = var1.b().readInt();
                  var189 = 0;

                  try {
                     var9.cMP = var1.b().readInt();
                     var189 = var1.b().readInt();
                  } catch (Exception var136) {
                  }

                  if ((var185 += var189) == 0) {
                     GameScr.a("", var9.cx1, var9.cy1 - var9.bg, 0, -2, 7);
                     return;
                  }

                  if (var185 < 0) {
                     var185 = -var185;
                     GameScr.a("-" + var185, var9.cx1, var9.cy1 - var9.bg, 0, -2, 8);
                  } else {
                     GameScr.a("-" + var185, var9.cx1, var9.cy1 - var9.bg, 0, -2, 0);
                  }

                  return;
               }

               if ((var9 = GameScr.e(var185)) == null) {
                  return;
               }

               var9.cHP = var1.b().readInt();
               var185 = var1.b().readInt();
               var189 = 0;

               try {
                  var9.cMP = var1.b().readInt();
                  var189 = var1.b().readInt();
               } catch (Exception var135) {
               }

               if ((var185 += var189) == 0) {
                  GameScr.a("", var9.cx1, var9.cy1 - var9.bg, 0, -2, 4);
                  return;
               }

               if (var185 < 0) {
                  var185 = -var185;
                  GameScr.a("-" + var185, var9.cx1, var9.cy1 - var9.bg, 0, -2, 3);
               } else {
                  GameScr.a("-" + var185, var9.cx1, var9.cy1 - var9.bg, 0, -2, 5);
               }

               return;
            case 63:
               var195 = new MyVector();

               while(true) {
                  try {
                     var195.addElement(new Command1(var1.b().readUTF(), GameCanvas.instance, 88817, (Object)null));
                  } catch (Exception var153) {
                     GameCanvas.af.a(var195);
                     GameCanvas.af.selectFirstNpcMenu();
                     AutoDanhVong.advAF(); // notify: quest menu items received
                     return;
                  }
               }
            case 64:
               if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                  var186 = Char.getMyChar();
               } else {
                  var186 = GameScr.e(var185);
               }

               var186.moveFast = new short[3];
               var186.moveFast[0] = 0;
               var191 = var1.b().readShort();
               var193 = var1.b().readShort();
               var186.moveFast[1] = var191;
               var186.moveFast[2] = var193;
               var186.ek = false;

               try {
                  if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                     var186 = Char.getMyChar();
                  } else {
                     var186 = GameScr.e(var185);
                  }

                  var186.cx1 = var191;
                  var186.cy1 = var193;
               } catch (Exception var134) {
                  ;
               }

               return;
            case 65:
               if ((var186 = GameScr.e(var1.b().readInt())) != null) {
                  if (Code.loc_nhom) {
                     if (!ListGroup.a(var186.cName)) {
                        GameCanvas.aj = null;
                     } else {
                        GameCanvas.a(var186.cName + " " + TextGame.lw, 88812, var186, 8882, (Object)null);
                     }

                     return;
                  } else {
                     if (ListBlock.a(var186.cName)) {
                        GameCanvas.aj = null;
                     } else {
                        GameCanvas.a(var186.cName + " " + TextGame.lw, 88812, var186, 8882, (Object)null);
                     }

                     return;
                  }
               }

               return;
            case 66:
               var3 = var1.b().readInt();
               var189 = var1.b().readInt();
               if (var3 != Char.getMyChar().idChar && var189 != Char.getMyChar().idChar) {
                  GameScr.e(var3).db = var189;
                  GameScr.e(var189).db = var3;
                  return;
               }

               if (var3 == Char.getMyChar().idChar) {
                  Char.getMyChar().db = var189;
                  Char.getMyChar().npcFocus = null;
                  Char.getMyChar().mobFocus = null;
                  Char.getMyChar().itemFocus = null;
                  Char.getMyChar().charFocus = GameScr.e(Char.getMyChar().db);
                  Char.getMyChar().charFocus.db = Char.getMyChar().idChar;
                  GameScr.gI().dn = GameScr.gI().dm;
                  GameScr.gI().dm = var189;
                  Char.fg = true;
                  return;
               }

               if (var189 != Char.getMyChar().idChar) {
                  return;
               }

               Char.getMyChar().db = var3;
               Char.getMyChar().npcFocus = null;
               Char.getMyChar().mobFocus = null;
               Char.getMyChar().itemFocus = null;
               Char.getMyChar().charFocus = GameScr.e(Char.getMyChar().db);
               Char.getMyChar().charFocus.db = Char.getMyChar().idChar;
               GameScr.gI().dn = GameScr.gI().dm;
               GameScr.gI().dm = var3;
               Char.fg = true;
               return;
            case 67:
               var3 = var1.b().readInt();
               var189 = var1.b().readInt();
               var185 = 0;

               try {
                  var185 = var1.b().readInt();
               } catch (Exception var133) {
               }

               if (var3 == Char.getMyChar().idChar) {
                  var9 = GameScr.e(var189);
                  if (var185 > 0) {
                     InfoMe.a(TextGame.a(TextGame.iy, var9.cName));
                     Char.getMyChar().cHP = var185;
                     Char.getMyChar().dd = 29;
                     if (var9 != null) {
                        var9.dd = 89;
                     }
                  } else {
                     if (var9 != null) {
                        var9.dd = 59;
                     }

                     Char.getMyChar().dd = 59;
                     InfoMe.a(TextGame.a(TextGame.iz, var9.cName));
                  }

                  Char.getMyChar().db = -9999;
                  Char.getMyChar().charFocus = null;
                  if (GameScr.gI().dn >= 0) {
                     GameScr.gI().dm = GameScr.gI().dn;
                     GameScr.gI().dn = -1;
                  } else {
                     GameScr.gI().dm = -1;
                  }

                  if (var9 == null) {
                     return;
                  }

                  var9.db = -9999;
                  return;
               }

               if (var189 == Char.getMyChar().idChar) {
                  var9 = GameScr.e(var3);
                  if (var185 > 0) {
                     if (var9 != null) {
                        var9.cHP = var185;
                     }

                     if (var9 != null) {
                        var9.dd = 29;
                     }

                     Char.getMyChar().dd = 89;
                     InfoMe.a(TextGame.a(TextGame.ix, var9.cName));
                  } else {
                     if (var9 != null) {
                        var9.dd = 59;
                     }

                     Char.getMyChar().dd = 59;
                     InfoMe.a(TextGame.a(TextGame.iz, var9.cName));
                  }

                  if (var9 != null) {
                     var9.db = -9999;
                  }

                  Char.getMyChar().db = -9999;
                  Char.getMyChar().charFocus = null;
                  if (GameScr.gI().dn >= 0) {
                     GameScr.gI().dm = GameScr.gI().dn;
                     GameScr.gI().dn = -1;
                  } else {
                     GameScr.gI().dm = -1;
                  }

                  return;
               }

               var83 = GameScr.e(var3);
               Char var200 = GameScr.e(var189);
               if (var185 > 0) {
                  if (var83 != null) {
                     var83.cHP = var185;
                  }

                  if (var83 != null) {
                     var83.dd = 29;
                  }

                  if (var200 != null) {
                     var200.dd = 89;
                  }
               } else {
                  if (var83 != null) {
                     var83.dd = 59;
                  }

                  if (var200 != null) {
                     var200.dd = 59;
                  }
               }

               if (var83 != null) {
                  var83.db = -9999;
               }

               if (var200 == null) {
                  return;
               }

               var200.db = -9999;
               return;
            case 68:
               if ((var9 = GameScr.e(var1.b().readInt())) != null) {
                  var9.dc = Char.getMyChar().idChar;
                  Char.getMyChar().npcFocus = null;
                  Char.getMyChar().mobFocus = null;
                  Char.getMyChar().itemFocus = null;
                  Char.getMyChar().charFocus = var9;
                  Char.fg = true;
                  InfoMe.a(var9.cName + TextGame.jb, 20, mFont.l);
               }

               return;
            case 69:
               Char.getMyChar().dc = var1.b().readInt();
               Char.getMyChar().npcFocus = null;
               Char.getMyChar().mobFocus = null;
               Char.getMyChar().itemFocus = null;
               Char.getMyChar().charFocus = GameScr.e(Char.getMyChar().dc);
               Char.fg = true;
               return;
            case 70:
               var9 = Char.getMyChar();

               try {
                  var9 = GameScr.e(var1.b().readInt());
               } catch (Exception var132) {
               }

               var9.dc = -9999;
               return;
            case 71:
               var244 = var1.b().readLong();
               var10000 = Char.getMyChar();
               var10000.cExpDown -= var244;
               GameScr.a("+" + var244, Char.getMyChar().cx1, Char.getMyChar().cy1 - Char.getMyChar().bg, 0, -2, 2);
               return;
            case 72:
               Char.getMyChar().cPk = var1.b().readByte();
               Char.getMyChar().a(var1.b().readShort(), var1.b().readShort());
               Char.getMyChar().cEXP = GameScr.b(Char.getMyChar().cLevel - 1);
               Char.getMyChar().cExpDown = var1.b().readLong();
               GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
               return;
            case 75:
               var73 = new BuNhin(var1.b().readUTF(), var1.b().readShort(), var1.b().readShort());
               GameScr.vBuNhin.addElement(var73);
               ServerEffect.a(60, var73.a, var73.b, 1);
               return;
            case 76:
               Mob var74;
               if ((var74 = Mob.get_Mob(var1.b().readUnsignedByte())) == null) {
                  return;
               }

               if ((var73 = GameScr.f(var1.b().readShort())) != null) {
                  var189 = var1.b().readShort();
                  var204 = var1.b().readByte();
                  var194 = (short)var1.b().readByte();
                  var74.a(var73);
                  var74.a((short)var189, var204, (byte)var194);
                  return;
               }

               return;
            case 77:
               var73 = (BuNhin)GameScr.vBuNhin.elementAt(var1.b().readShort());
               GameScr.vBuNhin.removeElement(var73);
               ServerEffect.a(60, var73.a, var73.b, 1);
               return;
            case 78:
               var92 = null;

               try {
                  var92 = Mob.get_Mob(var1.b().readUnsignedByte());
               } catch (Exception var131) {
               }

               if (var92 != null && var92.status != 0 && var92.status != 0) {
                  var92.status = 0;
                  ServerEffect.a(60, var92.x1, var92.y1, 1);
                  ItemMap var93 = new ItemMap(var1.b().readShort(), var1.b().readShort(), var92.x1, var92.y1, var1.b().readShort(), var1.b().readShort());
                  GameScr.vItemMap.addElement(var93);
                  if (Res.e(var93.y - Char.getMyChar().cy1) < 24 && Res.e(var93.x - Char.getMyChar().cx1) < 24) {
                     Char.getMyChar().charFocus = null;
                     return;
                  }
               }

               return;
            case 79:
               var3 = var1.b().readInt();
               var203 = var1.b().readUTF();
               // Port TGAME: reject lời mời nhóm trong lúc đang làm NV lôi đài
               if (Code.mode instanceof AutoDanhVong && AutoDanhVong.dieukien == 5) {
                  Service.gI().u(var3);
                  return;
               }
               // === AUTO NHÓM: MEMBER + bật auto + sai tên → auto reject, ẩn dialog ===
               if (Code.autoPtOn && Code.autoPtRole == 1 && Code.ig_lead != null
                     && Code.ig_lead.length() > 0 && !var203.equals(Code.ig_lead)) {
                  Service.gI().u(var3);
                  if (DebugLog.DEBUG) ;
                  return;
               }
               if (!var203.equals(Code.ig_lead) && !Code.check_nhom1(var203)) {
                  if (Code.loc_nhom) {
                     if (ListGroup.a(var203)) {
                        GameCanvas.a(var203 + " " + TextGame.ly, 8887, new Integer(var3), 8888, new Integer(var3));
                     } else {
                        Service.gI().u(var3);
                        GameCanvas.j();
                     }
                  } else if (ListBlock.a(var203)) {
                     Service.gI().u(var3);
                     GameCanvas.j();
                  } else {
                     GameCanvas.a(var203 + " " + TextGame.ly, 8887, new Integer(var3), 8888, new Integer(var3));
                  }
                  break;
               }

               if (DebugLog.DEBUG) ;
               Service.gI().t(var3);
               return;
            case 82:
               GameScr.vParty.removeAllElements();
               boolean var205 = var1.b().readBoolean();

               try {
                  for(var201 = 0; var201 < 6; ++var201) {
                     GameScr.vParty.addElement(new Party(var1.b().readInt(), var1.b().readByte(), var1.b().readUTF(), var205));
                  }
               } catch (Exception var163) {
               }

               GameScr.gI().t();
               var203 = ((Party)GameScr.vParty.firstElement()).d;
               if (Code.ig_lead == null) {
                  Code.ig_lead = var203;
               } else if (!var203.equals(Code.ig_lead)) {
                  Service.gI().t();
                  return;
               }

               return;
            case 83:
               GameScr.vParty.removeAllElements();
               GameScr.gI().t();
               return;
            case 84:
               Friend var213 = new Friend(var1.b().readUTF(), var1.b().readByte());
               GameScr.gI();
               GameScr.a(var213.a);
               if (var213.b == 0) {
                  InfoMe.a(TextGame.ik + " " + var213.a + " " + TextGame.il);
                  GameScr.vFriend.addElement(var213);
               } else if (var213.b == 1) {
                  for(var7 = 0; var7 < GameScr.vFriend.size(); ++var7) {
                     if (((Friend)GameScr.vFriend.elementAt(var7)).a.equals(var213.a)) {
                        GameScr.vFriend.removeElementAt(var7);
                        break;
                     }
                  }

                  InfoMe.a(TextGame.im + " " + var213.a + " " + TextGame.ec);
                  var213.b = 3;
                  GameScr.vFriend.insertElementAt(var213, 0);
               }

               if (GameScr.cp) {
                  GameScr.gI();
                  GameScr.c((int)0);
                  GameScr.av = 0;
                  GameScr.ba.a();
               }

               return;
            case 85:
               if ((var8 = Mob.get_Mob(var1.b().readUnsignedByte())) != null) {
                  var8.n = var1.b().readBoolean();
               }

               return;
            case 86:
               if ((var8 = Mob.get_Mob(var1.b().readUnsignedByte())) != null) {
                  var8.o = var1.b().readBoolean();
               }

               return;
            case 87:
               if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                  var9 = Char.getMyChar();
               } else {
                  var9 = GameScr.e(var185);
               }

               if (var9 == null) {
                  return;
               }

               var7 = var1.b().readUnsignedByte();
               var189 = var1.b().readShort();
               var204 = var1.b().readByte();
               var194 = (short)var1.b().readByte();
               var199 = 0;
               var198 = -1;

               try {
                  if ((var199 = (short)var1.b().readByte()) == 1) {
                     var198 = var1.b().readInt();
                  }
               } catch (Exception var130) {
                  ;
               }

               if (var9.mobMe != null) {
                  if (var199 == 0) {
                     Mob var210 = Mob.get_Mob(var7);
                     var9.mobMe.a(var210);
                  } else {
                     Char var212 = GameScr.e(var198);
                     var9.mobMe.b(var212);
                  }
               }

               var9.mobMe.a((short)var189, var204, (byte)var194);
               return;
            case 88:
               if ((var185 = var1.b().readInt()) == Char.getMyChar().idChar) {
                  var9 = Char.getMyChar();
               } else if ((var9 = GameScr.e(var185)) == null) {
                  return;
               }

               var9.cHP = var9.cMaxHP;
               var9.cMP = var9.cMaxMP;
               var9.cx1 = var1.b().readShort();
               var9.cy1 = var1.b().readShort();
               var9.x();
               return;
            case 89:
               if ((var8 = Mob.get_Mob(var1.b().readUnsignedByte())) != null) {
                  var8.p = var1.b().readBoolean();
               }

               return;
            case 90:
               if ((var8 = Mob.get_Mob(var1.b().readUnsignedByte())) != null) {
                  var8.q = var1.b().readBoolean();
                  if (!var8.q) {
                     ServerEffect.a(77, var8.x1, var8.y1 - 9, 1);
                     return;
                  }
               }

               return;
            case 91:
               if ((var8 = Mob.get_Mob(var1.b().readUnsignedByte())) != null) {
                  var8.r = var1.b().readBoolean();
               }

               return;
            case 92:
               var187 = var1.b().readUTF();
               Short var197 = new Short(var1.b().readShort());
               GameCanvas.al.a(var187, new Command1(TextGame.dc, GameCanvas.instance, 88818, var197), 0);
               return;
            case 93:
               var185 = var1.b().readInt();
               GameScr.currentCharViewInfo = new Char();
               if (Char.getMyChar().idChar == var185) {
                  GameScr.currentCharViewInfo = Char.getMyChar();
               } else {
                  if ((var9 = GameScr.e(var185)) == null) {
                     GameScr.currentCharViewInfo = new Char();
                  } else {
                     GameScr.currentCharViewInfo = var9;
                  }

                  GameScr.currentCharViewInfo.idChar = var185;
                  GameScr.currentCharViewInfo.statusMe = 1;
                  GameScr.gI().al();
               }

               GameScr.currentCharViewInfo.cName = fix_vip(var1.b().readUTF());
               GameScr.currentCharViewInfo.head = var1.b().readShort();
               GameScr.currentCharViewInfo.cgender = var1.b().readByte();
               var69 = var1.b().readByte();
               GameScr.currentCharViewInfo.nClass = GameScr.nClasss[var69];
               GameScr.currentCharViewInfo.cPk = var1.b().readByte();
               GameScr.currentCharViewInfo.cHP = var1.b().readInt();
               GameScr.currentCharViewInfo.cMaxHP = var1.b().readInt();
               GameScr.currentCharViewInfo.cMP = var1.b().readInt();
               GameScr.currentCharViewInfo.cMaxMP = var1.b().readInt();
               GameScr.currentCharViewInfo.cspeed = var1.b().readByte();
               GameScr.currentCharViewInfo.cResFire = var1.b().readShort();
               GameScr.currentCharViewInfo.cResIce = var1.b().readShort();
               GameScr.currentCharViewInfo.cResWind = var1.b().readShort();
               GameScr.currentCharViewInfo.cdame = var1.b().readInt();
               GameScr.currentCharViewInfo.cdameDown = var1.b().readInt();
               GameScr.currentCharViewInfo.cExactly = var1.b().readShort();
               GameScr.currentCharViewInfo.cMiss = var1.b().readShort();
               GameScr.currentCharViewInfo.cFatal = var1.b().readShort();
               GameScr.currentCharViewInfo.cReactDame = var1.b().readShort();
               GameScr.currentCharViewInfo.sysUp = var1.b().readShort();
               GameScr.currentCharViewInfo.sysDown = var1.b().readShort();
               GameScr.currentCharViewInfo.cLevel = var1.b().readUnsignedByte();
               GameScr.currentCharViewInfo.pointUydanh = var1.b().readShort();
               GameScr.currentCharViewInfo.cClanName = var1.b().readUTF();
               if (!GameScr.currentCharViewInfo.cClanName.equals("")) {
                  GameScr.currentCharViewInfo.ctypeClan = var1.b().readByte();
               }

               GameScr.currentCharViewInfo.pointUydanh = var1.b().readShort();
               GameScr.currentCharViewInfo.pointNon = var1.b().readShort();
               GameScr.currentCharViewInfo.pointAo = var1.b().readShort();
               GameScr.currentCharViewInfo.pointGangtay = var1.b().readShort();
               GameScr.currentCharViewInfo.pointQuan = var1.b().readShort();
               GameScr.currentCharViewInfo.pointGiay = var1.b().readShort();
               GameScr.currentCharViewInfo.pointVukhi = var1.b().readShort();
               GameScr.currentCharViewInfo.pointLien = var1.b().readShort();
               GameScr.currentCharViewInfo.pointNhan = var1.b().readShort();
               GameScr.currentCharViewInfo.pointNgocboi = var1.b().readShort();
               GameScr.currentCharViewInfo.pointPhu = var1.b().readShort();
               GameScr.currentCharViewInfo.countFinishDay = var1.b().readByte();
               GameScr.currentCharViewInfo.countLoopBoos = var1.b().readByte();
               GameScr.currentCharViewInfo.countPB = var1.b().readByte();
               GameScr.currentCharViewInfo.limitTiemnangso = var1.b().readByte();
               GameScr.currentCharViewInfo.limitKynangso = var1.b().readByte();
               GameScr.currentCharViewInfo.arrItemBody = new Item[32];

               int var70;
               ItemTemplate var72;
               try {
                  GameScr.currentCharViewInfo.j();

                  for(var70 = 0; var70 < 16; ++var70) {
                     if ((var71 = var1.b().readShort()) > -1) {
                        var208 = (short)(var72 = ItemTemplates.a((short)var71)).type;
                        GameScr.currentCharViewInfo.arrItemBody[var208] = new Item();
                        GameScr.currentCharViewInfo.arrItemBody[var208].indexUI = var208;
                        GameScr.currentCharViewInfo.arrItemBody[var208].typeUI = 5;
                        GameScr.currentCharViewInfo.arrItemBody[var208].template = var72;
                        GameScr.currentCharViewInfo.arrItemBody[var208].isLock = true;
                        GameScr.currentCharViewInfo.arrItemBody[var208].upgrade = var1.b().readByte();
                        GameScr.currentCharViewInfo.arrItemBody[var208].sys = var1.b().readByte();
                        if (var208 == 1) {
                           GameScr.currentCharViewInfo.weapon = GameScr.currentCharViewInfo.arrItemBody[var208].template.part;
                        } else if (var208 == 2) {
                           GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[var208].template.part;
                        } else if (var208 == 6) {
                           GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[var208].template.part;
                        }
                     }
                  }
               } catch (Exception var159) {
               }

               try {
                  for(var70 = 0; var70 < 16; ++var70) {
                     if ((var71 = var1.b().readShort()) > -1) {
                        var201 = (var72 = ItemTemplates.a((short)var71)).type + 16;
                        GameScr.currentCharViewInfo.arrItemBody[var201] = new Item();
                        GameScr.currentCharViewInfo.arrItemBody[var201].indexUI = var201;
                        GameScr.currentCharViewInfo.arrItemBody[var201].typeUI = 5;
                        GameScr.currentCharViewInfo.arrItemBody[var201].template = var72;
                        GameScr.currentCharViewInfo.arrItemBody[var201].isLock = true;
                        GameScr.currentCharViewInfo.arrItemBody[var201].upgrade = var1.b().readByte();
                        GameScr.currentCharViewInfo.arrItemBody[var201].sys = var1.b().readByte();
                        if (var201 == 1) {
                           GameScr.currentCharViewInfo.weapon = GameScr.currentCharViewInfo.arrItemBody[var201].template.part;
                        } else if (var201 == 2) {
                           GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[var201].template.part;
                        } else if (var201 == 6) {
                           GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[var201].template.part;
                        }
                     }
                  }

                  return;
               } catch (Exception var155) {
                  return;
               }
            case 94:
               b(var1);
               return;
            case 95:
               int var84 = var1.b().readInt();
               var10000 = Char.getMyChar();
               var10000.xu += var84;
               GameScr.a(var84 > 0 ? "+" + var84 : "" + var84, Char.getMyChar().cx1, Char.getMyChar().cy1 - Char.getMyChar().bg - 10, 0, -2, 1);
               return;
            case 96:
               Char.getMyChar().dw.addElement(new TaskOrder(var1.b().readByte(), var1.b().readInt(), var1.b().readInt(), var1.b().readUTF(), var1.b().readUTF(), var1.b().readUnsignedByte(), var1.b().readUnsignedByte()));
               Char.getMyChar().c(21);
               return;
            case 97:
               var85 = var1.b().readByte();

               for(var86 = 0; var86 < Char.getMyChar().dw.size(); ++var86) {
                  TaskOrder var87;
                  if ((var87 = (TaskOrder)Char.getMyChar().dw.elementAt(var86)).a == var85) {
                     var87.b = var1.b().readInt();
                     if (var87.b == var87.c) {
                        Char.getMyChar().c(61);
                     }

                     if (var87.a == 0) {
                        AutoNVHN.a = false;
                     }

                     return;
                  }
               }

               return;
            case 98:
               var85 = var1.b().readByte();
               var86 = 0;

               while(true) {
                  if (var86 < Char.getMyChar().dw.size()) {
                     if (((TaskOrder)Char.getMyChar().dw.elementAt(var86)).a != var85) {
                        ++var86;
                        continue;
                     }

                     Char.getMyChar().dw.removeElementAt(var86);
                  }

                  Char.getMyChar().c(21);
                  return;
               }
            case 99:
               if ((var186 = GameScr.e(var1.b().readInt())) != null) {
                  // Auto accept invite cho AutoLoiLoss (doi thu moi loi dai)
                  if (Code.mode instanceof AutoLoiLoss && FormDanhVong.advAB != null
                      && var186.cName != null && var186.cName.equals(FormDanhVong.advAB)) {
                     ((AutoLoiLoss) Code.mode).advAB = var186.idChar;
                     if (FormDanhVong.DEBUG_DV) ;
                     return;
                  }
                  if (Code.loc_nhom) {
                     if (!ListGroup.a(var186.cName)) {
                        GameCanvas.aj = null;
                     } else {
                        GameCanvas.a(var186.cName + " " + TextGame.lx, 88840, var186, 8882, (Object)null);
                     }

                     return;
                  } else {
                     if (ListBlock.a(var186.cName)) {
                        GameCanvas.aj = null;
                     } else {
                        GameCanvas.a(var186.cName + " " + TextGame.lx, 88840, var186, 8882, (Object)null);
                     }

                     return;
                  }
               }

               return;
            case 100:
               GameScr.vList.removeAllElements();
               var194 = (short)var1.b().readByte();
               var2 = null;

               for(var3 = 0; var3 < var194; ++var3) {
                  try {
                     DunItem var196;
                     (var196 = new DunItem()).a = var1.b().readByte();
                     var196.b = var1.b().readUTF();
                     var196.c = var1.b().readUTF();
                     GameScr.vList.addElement(var196);
                  } catch (Exception var129) {
                  }
               }

               GameScr.gI().r();
               return;
            case 101:
               try {
                  GameScr.currentCharViewInfo.as = var1.b().readInt();
                  GameScr.currentCharViewInfo.ax = var1.b().readByte();
                  GameScr.currentCharViewInfo.ay = var1.b().readByte();
               } catch (Exception var128) {
                  ;
               }

               return;
            case 102:
               if ((var237 = Char.getMyChar().arrItemBag[var1.b().readByte()]) != null) {
                  GameScr.ck = var237;
               }

               Char.getMyChar().xu = var1.b().readInt();
               if (GameScr.ck != null) {
                  if (GameScr.ck.template.type == 16) {
                     GameScr.mpPotion -= GameScr.ck.quantity;
                  }

                  if (GameScr.ck.template.type == 17) {
                     GameScr.hpPotion -= GameScr.ck.quantity;
                  }

                  Char.getMyChar().arrItemBag[GameScr.ck.indexUI] = null;
                  GameScr.ck = null;
                  GameScr.gI().v();
                  InfoMe.a(TextGame.qe);
               }

               GameCanvas.j();
               return;
            case 103:
               GameScr.aw = var1.b().readByte();
               GameScr.cf = new ItemStands[var1.b().readInt()];

               for(int var79 = 0; var79 < GameScr.cf.length; ++var79) {
                  GameScr.cf[var79] = new ItemStands();
                  GameScr.cf[var79].a = new Item();
                  GameScr.cf[var79].a.itemId = var1.b().readInt();
                  GameScr.cf[var79].d = (int)(System.currentTimeMillis() / 1000L);
                  GameScr.cf[var79].c = var1.b().readInt();
                  GameScr.cf[var79].a.quantity = var1.b().readUnsignedShort();
                  GameScr.cf[var79].e = var1.b().readUTF();
                  GameScr.cf[var79].b = var1.b().readInt();
                  GameScr.cf[var79].a.template = ItemTemplates.a(var1.b().readShort());
               }

               GameScr.gI().doOpenUI(37);
               return;
            case 104:
               c(var1);
               return;
            case 106:
               if ((var186 = GameScr.e(var1.b().readInt())) != null) {
                  GameCanvas.a(var186.cName + " " + TextGame.qs, 88841, var186, 8882, (Object)null);
               }

               return;
            case 107:
               var204 = var1.b().readByte();
               String var107text = var1.b().readUTF();
               // DV hook: auto confirm huy NV khi auto DV dang chay
               if (Code.mode instanceof AutoDanhVong && var204 == 8) {
                  Service.gI().o(var204); // auto confirm cancel quest
                  if (FormDanhVong.DEBUG_DV) ;
                  return;
               }
               GameCanvas.a(var107text, 8890, new Integer(var204), 8891, (Object)null);
               return;
            case 108:
               Char.getMyChar().b(var1);
               return;
            case 109:
               InfoDlg.b();
               GameCanvas.i();
               GameCanvas.h();
               var195 = new MyVector();

               try {
                  var204 = var1.b().readByte();

                  for(var4 = 0; var4 < var204; ++var4) {
                     String[] var64 = new String[var1.b().readByte()];

                     for(int var65 = 0; var65 < var64.length; ++var65) {
                        var64[var65] = var1.b().readUTF();
                     }

                     var195.addElement(new Command1(var64[0], GameCanvas.instance, 88820, var64));
                  }
               } catch (Exception var166) {
               }

               if (Char.getMyChar().npcFocus == null) {
                  return;
               }

               GameCanvas.af.a(var195);
               GameCanvas.af.selectFirstNpcMenu();
               return;
            case 112:
               (var192 = Char.getMyChar().arrItemBag[var1.b().readByte()]).upgrade = var1.b().readByte();
               var192.expires = 0L;
               return;
            case 114:
               GameScr.gI().em = var1.b().readByte();
               return;
            case 116:
               if ((var9 = GameScr.e(var1.b().readInt())) != null) {
                  a(var9, var1);
               }

               return;
            case 117:
               if ((var191 = (short)var1.b().readByte()) == -1) {
                  GameCanvas.l.a(var1);
               } else if (!GameCanvas.a) {
                  try {
                     Mob.vEggMonter.removeAllElements();
                     TileMap.w.clear();
                     GameScr.ep.removeAllElements();
                     GameScr.eq.removeAllElements();
                     GameScr.eo.removeAllElements();

                     for(var3 = 0; var3 < var191; ++var3) {
                        var4 = var1.b().readShort();
                        var5 = String.valueOf(var4);
                        byte[] var6 = new byte[var1.b().readInt()];
                        var1.b().read(var6);
                        Image var188 = a(var6);
                        TileMap.w.a(var5, var188);
                     }

                     var185 = var1.b().readUnsignedByte();

                     ItemTree var202;
                     for(var3 = 0; var3 < var185; ++var3) {
                        var4 = var1.b().readUnsignedByte();
                        var198 = var1.b().readUnsignedByte();
                        var201 = var1.b().readUnsignedByte();
                        (var202 = new ItemTree(var198, var201)).a = var4;
                        GameScr.ep.addElement(var202);
                     }

                     var185 = var1.b().readUnsignedByte();

                     for(var3 = 0; var3 < var185; ++var3) {
                        var4 = var1.b().readUnsignedByte();
                        var198 = var1.b().readUnsignedByte();
                        var201 = var1.b().readUnsignedByte();
                        (var202 = new ItemTree(var198, var201)).a = var4;
                        GameScr.eq.addElement(var202);
                     }

                     var185 = var1.b().readUnsignedByte();

                     for(var3 = 0; var3 < var185; ++var3) {
                        var4 = var1.b().readUnsignedByte();
                        var198 = var1.b().readUnsignedByte();
                        var201 = var1.b().readUnsignedByte();
                        (var202 = new ItemTree(var198, var201)).a = var4;
                        GameScr.eo.addElement(var202);
                     }

                     return;
                  } catch (Exception var160) {
                     ;
                     return;
                  }
               }

               return;
            case 118:
               var190 = var1.b().readUTF();
               RMS.a("acc", var190);
               var187 = var1.b().readUTF();
               RMS.a("pass", var187);
               SelectServerScr.h = var190;
               SelectServerScr.i = var187;
               SelectServerScr.j = "";
               SelectServerScr.k = "";
               if (!var190.startsWith("tmpusr")) {
                  GameScr.gI().a();
               }

               return;
            case 119:
               if ((var193 = (short)var1.b().readByte()) == -1) {
                  GameScr.ex = true;
                  GameScr.a(true);
                  if ((GameScr.fo = var1.b().readInt()) > 360) {
                     GameScr.ey = true;
                  } else {
                     GameScr.ey = false;
                     GameScr.fm = Char.getMyChar().cx1;
                     GameScr.fn = Char.getMyChar().cy1;
                  }

                  return;
               }

               if (var193 == 0) {
                  if ((var186 = GameScr.e(var1.b().readInt())) != null) {
                     ServerEffect.a(141, var186.cx1, var186.cy1, 2);
                     var189 = var1.b().readShort();
                     var186.ed = var189;
                     var193 = var1.b().readShort();
                     var186.ee = var193;
                     ServerEffect.a(141, var186.cx1, var186.cy1, 2);
                     return;
                  }
               } else {
                  GameScr.ex = false;
                  GameScr.fb = 0;
               }

               return;
            case 121:
               GameScr.vList.removeAllElements();
               var185 = var1.b().readUnsignedByte();
               var2 = null;

               for(var3 = 0; var3 < var185; ++var3) {
                  try {
                     (var2 = new Ranked()).b = var1.b().readUTF();
                     var2.a = var1.b().readInt();
                     var2.c = var1.b().readUTF();
                     GameScr.vList.addElement(var2);
                  } catch (Exception var127) {
                  }
               }

               GameScr.gI().q();
               return;
            case 122:
               if ((var185 = var1.b().readByte()) == 0) {
                  i(var1);
                  return;
               }

               if (var185 == 1) {
                  j(var1);
                  return;
               }

               if (var185 == 2) {
                  l(var1);
                  return;
               }

               if (var185 != 3) {
                  return;
               }

               k(var1);
               return;
            case 123:
               if ((var185 = var1.b().readByte()) != 0) {
                  if (var185 == 1) {
                     return;
                  }

                  return;
               }

               return;
            case 124:
               m(var1);
               return;
            case 125:
               if ((var185 = var1.b().readByte()) == 0) {
                  n(var1);
                  return;
               }

               if (var185 == 1) {
                  o(var1);
                  return;
               }

               if (var185 != 2) {
                  return;
               }

               p(var1);
               return;
            case 126:
               var96 = var1.b().readByte();
               GameCanvas.j();
               if (var96 != 0) {
                  return;
               }

               GameScr.instance.v();
               return;
         }
      } catch (Exception var167) {
         ;
         ;
         return;
      } finally {
         if (var1 != null) {
            var1.d();
         }

      }

   }

   private static void a(DataInputStream var0) {
      try {
         GameScr.dt = var0.readByte();
         GameScr.ay = new ItemOptionTemplate[var0.readUnsignedByte()];

         for(int var1 = 0; var1 < GameScr.ay.length; ++var1) {
            GameScr.ay[var1] = new ItemOptionTemplate();
            GameScr.ay[var1].a = var1;
            GameScr.ay[var1].b = var0.readUTF();
            GameScr.ay[var1].c = var0.readByte();
         }

         short var4 = var0.readShort();

         for(int var2 = 0; var2 < var4; ++var2) {
            ItemTemplates.a(new ItemTemplate((short)var2, var0.readByte(), var0.readByte(), var0.readUTF(), var0.readUTF(), var0.readByte(), var0.readShort(), var0.readShort(), var0.readBoolean()));
         }
      } catch (IOException var3) {
         ;
      }

   }

   private static void b(DataInputStream var0) {
      try {
         GameScr.ds = var0.readByte();
         GameScr.az = new SkillOptionTemplate[var0.readByte()];

         int var1;
         for(var1 = 0; var1 < GameScr.az.length; ++var1) {
            GameScr.az[var1] = new SkillOptionTemplate();
            GameScr.az[var1].a = var1;
            GameScr.az[var1].b = var0.readUTF();
         }

         GameScr.nClasss = new NClass[var0.readUnsignedByte()];

         for(var1 = 0; var1 < GameScr.nClasss.length; ++var1) {
            GameScr.nClasss[var1] = new NClass();
            GameScr.nClasss[var1].a = var1;
            GameScr.nClasss[var1].b = var0.readUTF();
            GameScr.nClasss[var1].c = new SkillTemplate[var0.readByte()];

            for(int var2 = 0; var2 < GameScr.nClasss[var1].c.length; ++var2) {
               GameScr.nClasss[var1].c[var2] = new SkillTemplate();
               GameScr.nClasss[var1].c[var2].id = var0.readByte();
               GameScr.nClasss[var1].c[var2].b = var0.readUTF();
               GameScr.nClasss[var1].c[var2].maxPoint = var0.readByte();
               GameScr.nClasss[var1].c[var2].type = var0.readByte();
               GameScr.nClasss[var1].c[var2].e = var0.readShort();
               int var3 = 150;
               if (GameCanvas.aa == 128 || GameCanvas.ab <= 208) {
                  var3 = 100;
               }

               GameScr.nClasss[var1].c[var2].f = mFont.i.b(var0.readUTF(), var3);
               GameScr.nClasss[var1].c[var2].g = new Skill[var0.readByte()];

               for(var3 = 0; var3 < GameScr.nClasss[var1].c[var2].g.length; ++var3) {
                  GameScr.nClasss[var1].c[var2].g[var3] = new Skill();
                  GameScr.nClasss[var1].c[var2].g[var3].skillId = var0.readShort();
                  GameScr.nClasss[var1].c[var2].g[var3].template = GameScr.nClasss[var1].c[var2];
                  GameScr.nClasss[var1].c[var2].g[var3].point = var0.readByte();
                  GameScr.nClasss[var1].c[var2].g[var3].level = var0.readByte();
                  GameScr.nClasss[var1].c[var2].g[var3].manaUse = var0.readShort();
                  GameScr.nClasss[var1].c[var2].g[var3].coolDown = var0.readInt();
                  GameScr.nClasss[var1].c[var2].g[var3].dx = var0.readShort();
                  GameScr.nClasss[var1].c[var2].g[var3].dy = var0.readShort();
                  GameScr.nClasss[var1].c[var2].g[var3].maxFight = var0.readByte();
                  GameScr.nClasss[var1].c[var2].g[var3].k = new SkillOption[var0.readByte()];

                  for(int var4 = 0; var4 < GameScr.nClasss[var1].c[var2].g[var3].k.length; ++var4) {
                     GameScr.nClasss[var1].c[var2].g[var3].k[var4] = new SkillOption();
                     GameScr.nClasss[var1].c[var2].g[var3].k[var4].a = var0.readShort();
                     GameScr.nClasss[var1].c[var2].g[var3].k[var4].b = GameScr.az[var0.readByte()];
                  }

                  Skills.a(GameScr.nClasss[var1].c[var2].g[var3]);
               }
            }
         }
      } catch (IOException var5) {
         ;
      }

   }

   private static void c(DataInputStream var0) {
      try {
         GameScr.dr = var0.readByte();
         TileMap.u = new String[var0.readUnsignedByte()];

         int var2;
         for(var2 = 0; var2 < TileMap.u.length; ++var2) {
            TileMap.u[var2] = var0.readUTF();
         }

         Npc.arrNpcTemplate = new NpcTemplate[var0.readByte()];

         short var4;
         for(var4 = 0; var4 < Npc.arrNpcTemplate.length; var4 = (short)((byte)(var4 + 1))) {
            Npc.arrNpcTemplate[var4] = new NpcTemplate();
            Npc.arrNpcTemplate[var4].npcTemplateId = var4;
            Npc.arrNpcTemplate[var4].name = var0.readUTF() + "(" + Npc.arrNpcTemplate[var4].npcTemplateId + ")";
            Npc.arrNpcTemplate[var4].headId = var0.readShort();
            Npc.arrNpcTemplate[var4].bodyId = var0.readShort();
            Npc.arrNpcTemplate[var4].legId = var0.readShort();
            Npc.arrNpcTemplate[var4].menu = new String[var0.readByte()][];

            for(var2 = 0; var2 < Npc.arrNpcTemplate[var4].menu.length; ++var2) {
               Npc.arrNpcTemplate[var4].menu[var2] = new String[var0.readByte()];

               for(int var3 = 0; var3 < Npc.arrNpcTemplate[var4].menu[var2].length; ++var3) {
                  Npc.arrNpcTemplate[var4].menu[var2][var3] = var0.readUTF();
               }
            }
         }

         Mob.b = new MobTemplate[var4 = var0.readShort()];

         for(var2 = 0; var2 < var4; ++var2) {
            Mob.b[var2] = new MobTemplate();
            Mob.b[var2].e = (short)var2;
            Mob.b[var2].c = var0.readByte();
            Mob.b[var2].g = var0.readUTF();
            Mob.b[var2].f = var0.readInt();
            Mob.b[var2].a = var0.readByte();
            Mob.b[var2].b = var0.readByte();
         }
      } catch (IOException var4) {
         ;
      }

   }

   private static void d(DataInputStream var0) {
      try {
         GameScr.dq = var0.readByte();
         RMS.a("nj_arrow", NinjaUtil.a(var0));
         RMS.a("nj_effect", NinjaUtil.a(var0));
         RMS.a("nj_image", NinjaUtil.a(var0));
         RMS.a("nj_part", NinjaUtil.a(var0));
         RMS.a("nj_skill", NinjaUtil.a(var0));
         GameScr.dp = new byte[(GameScr.doa = new byte[var0.readByte()][]).length][];

         int var1;
         for(var1 = 0; var1 < GameScr.doa.length; ++var1) {
            GameScr.doa[var1] = new byte[var0.readByte()];
            GameScr.dp[var1] = new byte[GameScr.doa[var1].length];

            for(int var2 = 0; var2 < GameScr.doa[var1].length; ++var2) {
               GameScr.doa[var1][var2] = var0.readByte();
               GameScr.dp[var1][var2] = var0.readByte();
            }
         }

         GameScr.exps = new long[var0.readUnsignedByte()];

         for(var1 = 0; var1 < GameScr.exps.length; ++var1) {
            GameScr.exps[var1] = var0.readLong();
         }

         GameScr.cx = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.cx.length; ++var1) {
            GameScr.cx[var1] = var0.readInt();
         }

         GameScr.cy = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.cy.length; ++var1) {
            GameScr.cy[var1] = var0.readInt();
         }

         GameScr.cz = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.cz.length; ++var1) {
            GameScr.cz[var1] = var0.readInt();
         }

         GameScr.da = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.da.length; ++var1) {
            GameScr.da[var1] = var0.readInt();
         }

         GameScr.db = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.db.length; ++var1) {
            GameScr.db[var1] = var0.readInt();
         }

         GameScr.dc = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.dc.length; ++var1) {
            GameScr.dc[var1] = var0.readInt();
         }

         GameScr.dd = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.dd.length; ++var1) {
            GameScr.dd[var1] = var0.readInt();
         }

         GameScr.de = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.de.length; ++var1) {
            GameScr.de[var1] = var0.readInt();
         }

         GameScr.dg = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.dg.length; ++var1) {
            GameScr.dg[var1] = var0.readInt();
         }

         GameScr.df = new int[var0.readByte()];

         for(var1 = 0; var1 < GameScr.df.length; ++var1) {
            GameScr.df[var1] = var0.readInt();
         }

         Effect.a = new EffectTemplate[var0.readByte()];

         for(var1 = 0; var1 < Effect.a.length; ++var1) {
            Effect.a[var1] = new EffectTemplate();
            Effect.a[var1].a = var0.readByte();
            Effect.a[var1].b = var0.readByte();
            var0.readUTF();
            Effect.a[var1].c = var0.readShort();
         }
      } catch (IOException var3) {
         ;
      }

   }

   public static Image a(byte[] var0) {
      try {
         return Image.createImage(var0, 0, var0.length);
      } catch (Exception var2) {
         return null;
      }
   }

   private void d(Message var1) {
      DebugLog.trace("CTRL_D", "d() START — mapID=" + TileMap.mapID + " tileID=" + TileMap.tileID);
      try {
         Auto.removeall_Mob();
         Auto.removeall_Pk();
         Char var10000 = Char.getMyChar();
         var10000.chuthan = null;
         var10000.cx1 = var10000.eb = var1.b().readShort();
         var10000.cy1 = var10000.ec = var1.b().readShort();
         DebugLog.trace("CTRL_D", "charPos=" + var10000.cx1 + "," + var10000.cy1);
         byte var10 = var1.b().readByte();

         int var2;
         for(var2 = 0; var2 < var10; ++var2) {
            TileMap.t.addElement(new Waypoint(var1.b().readShort(), var1.b().readShort(), var1.b().readShort(), var1.b().readShort()));
         }

         Auto.removeall_Mob();
         var10 = var1.b().readByte();
         DebugLog.trace("CTRL_D", "mob count=" + var10);
         byte var11;
         for(var11 = 0; var11 < var10; ++var11) {
            Mob var3 = new Mob((short)var11, var1.b().readBoolean(), var1.b().readBoolean(), var1.b().readBoolean(), var1.b().readBoolean(), var1.b().readBoolean(), var1.b().readShort(), var1.b().readByte(), var1.b().readInt(), var1.b().readUnsignedByte(), var1.b().readInt(), var1.b().readShort(), var1.b().readShort(), var1.b().readByte(), var1.b().readByte(), var1.b().readBoolean(), false);
            if (Mob.b[var3.s].c != 0) {
               if (var11 % 3 == 0) {
                  var3.dir = -1;
               } else {
                  var3.dir = 1;
               }

               var3.x1 += 10 - var11 % 20;
            }

            Auto.add_Mob(var3);
            MobTemplate mob_template = Mob.b[var3.s];
            if (!phong2.listquai.contains(mob_template) && !var3.isBoss && (var3.s != 179 && var3.s != 175 && var3.s != 202 || var3.status != 8)) {
               phong2.listquai.addElement(mob_template);
            }

            GameScr.vMob.addElement(var3);
         }

         var10 = var1.b().readByte();
         DebugLog.trace("CTRL_D", "buNhin count=" + var10);
         for(var11 = 0; var11 < var10; ++var11) {
            GameScr.vBuNhin.addElement(new BuNhin(var1.b().readUTF(), var1.b().readShort(), var1.b().readShort()));
         }

         var10 = var1.b().readByte();
         DebugLog.trace("CTRL_D", "npc count=" + var10);
         for(var2 = 0; var2 < var10; ++var2) {
            GameScr.vNpc.addElement(new Npc(var2, var1.b().readByte(), var1.b().readShort(), var1.b().readShort(), var1.b().readByte()));
         }

         var10 = var1.b().readByte();
         DebugLog.trace("CTRL_D", "itemMap count=" + var10);

         int var5;
         for(var2 = 0; var2 < var10; ++var2) {
            ItemMap var12 = new ItemMap(var1.b().readShort(), var1.b().readShort(), var1.b().readShort(), var1.b().readShort());
            boolean var4 = false;

            for(var5 = 0; var5 < GameScr.vItemMap.size(); ++var5) {
               if (((ItemMap)GameScr.vItemMap.elementAt(var5)).itemMapID == var12.itemMapID) {
                  var4 = true;
                  break;
               }
            }

            if (!var4) {
               GameScr.vItemMap.addElement(var12);
            }
         }

         GameScr.a(false);

         try {
            TileMap.mapName1 = null;
            TileMap.mapName = TileMap.mapName1 = var1.b().readUTF();
         } catch (Exception var110) {
         }

         try {
            TileMap.v.clear();
            var2 = var1.b().readUnsignedByte();

            for(int var13 = 0; var13 < var2; ++var13) {
               int var14 = var1.b().readUnsignedByte();
               var5 = var1.b().readUnsignedByte();
               String var6 = String.valueOf((short)(var5 * TileMap.tmw + var14));
               TileMap.v.a(var6, "location");
            }
         } catch (Exception var131) {
            ;
         }

         TileMap.loadMap(TileMap.tileID);
         Char.getMyChar().k = 0;
         Char.getMyChar().statusMe = 4;
         GameScr.gI().p();
         if (DebugLog.DEBUG) ;
         try {
            GameCanvas.b(TileMap.versionMap);
            if (DebugLog.DEBUG) ;
         } catch (Exception exBg) {
            if (DebugLog.DEBUG) ;
            ;
         }
         Char.eh = false;
         Char.eg = false;
         try {
            GameCanvas.i();
            if (DebugLog.DEBUG) ;
         } catch (Exception exI) {
            if (DebugLog.DEBUG) ;
            ;
         }
         try {
            GameCanvas.h();
            if (DebugLog.DEBUG) ;
         } catch (Exception exH) {
            if (DebugLog.DEBUG) ;
            ;
         }
         if (!TileMap.phong_ae || TileMap.phong_ad == TileMap.mapID) {
            GameScr.gI().a();
            InfoDlg.b();
            InfoDlg.a(TileMap.mapName, TextGame.mc + " " + TileMap.zoneID, 30);
            Party.a();
            GameCanvas.j();
         }

         DebugLog.trace("CTRL_ENTER_MAP", "GameCanvas.f = false → tắt loading screen, vào map OK");
         GameCanvas.f = false;
      } catch (Exception var12) {
         DebugLog.error("CTRL_D EXCEPTION — map load failed", var12);
      }

      TileMap.g();
   }

   private void e(Message var1) {
      try {
         try {
            Char var2;
            int var3;
            short var5;
            int var6;
            String var7;
            int var33;
            String var34;
            int var36;
            short var40;
            byte var41;
            int var42;
            byte[] var53;
            switch (var1.b().readByte()) {
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
                  var41 = var1.b().readByte();
                  LoginScr.i = false;
                  SelectCharScr var46;
                  (var46 = SelectCharScr.f()).n = new String[3];
                  var46.i = new int[3];
                  var46.j = new int[3];
                  var46.k = new int[3];
                  var46.l = new int[3];
                  var46.m = new int[3];
                  var46.o = new String[3];
                  var46.p = new byte[3];
                  if (GameCanvas.g) {
                     var46.h = -1;
                  } else {
                     var46.h = 0;
                  }

                  GameScr.gI();
                  GameScr.j();
                  SmallImage.d();

                  for(byte var54 = 0; var54 < var41; ++var54) {
                     SelectCharScr.f().p[var54] = var1.b().readByte();
                     SelectCharScr.f().n[var54] = var1.b().readUTF();
                     SelectCharScr.f().o[var54] = var1.b().readUTF();
                     SelectCharScr.f().m[var54] = var1.b().readUnsignedByte();
                     SelectCharScr.f().i[var54] = var1.b().readShort();
                     SelectCharScr.f().l[var54] = var1.b().readShort();
                     SelectCharScr.f().k[var54] = var1.b().readShort();
                     SelectCharScr.f().j[var54] = var1.b().readShort();
                     if (SelectCharScr.f().l[var54] == -1) {
                        SelectCharScr.f().l[var54] = 15;
                     }

                     if (SelectCharScr.f().k[var54] == -1) {
                        if (SelectCharScr.f().p[var54] == 0) {
                           SelectCharScr.f().k[var54] = 10;
                        } else {
                           SelectCharScr.f().k[var54] = 1;
                        }
                     }

                     if (SelectCharScr.f().j[var54] == -1) {
                        if (SelectCharScr.f().p[var54] == 0) {
                           SelectCharScr.f().j[var54] = 9;
                        } else {
                           SelectCharScr.f().j[var54] = 0;
                        }
                     }
                  }

                  SelectCharScr.f().a();
                  GameCanvas.j();
                  phong.e();  // notify Relogin đang wait char list → thoát sớm
                  return;
               case -123:
                  GameScr.du = var1.b().readByte();
                  GameScr.dv = var1.b().readByte();
                  GameScr.dw = var1.b().readByte();
                  GameScr.dx = var1.b().readByte();
                  ;
                  ;
                  ;
                  ;
                  if (GameScr.du != GameScr.dq) {
                     Service.gI().m();
                  } else {
                     try {
                        d(new DataInputStream(new ByteArrayInputStream(RMS.a("data"))));
                     } catch (Exception var48) {
                        GameScr.dq = -1;
                        Service.gI().m();
                     }
                  }

                  if (GameScr.dv != GameScr.dr) {
                     Service.gI().n();
                  } else {
                     try {
                        c(new DataInputStream(new ByteArrayInputStream(RMS.a("map"))));
                     } catch (Exception var47) {
                        GameScr.dr = -1;
                        Service.gI().n();
                     }
                  }

                  if (GameScr.dw != GameScr.ds) {
                     Service.gI().o();
                  } else {
                     try {
                        b(new DataInputStream(new ByteArrayInputStream(RMS.a("skill"))));
                     } catch (Exception var436) {
                        GameScr.ds = -1;
                        Service.gI().o();
                     }
                  }

                  if (GameScr.dx != GameScr.dt) {
                     Service.gI().p();
                  } else {
                     try {
                        a(new DataInputStream(new ByteArrayInputStream(RMS.a("item"))));
                     } catch (Exception var45) {
                        GameScr.dt = -1;
                        Service.gI().p();
                     }
                  }

                  if (GameScr.du == GameScr.dq && GameScr.dv == GameScr.dr && GameScr.dw == GameScr.ds && GameScr.dx == GameScr.dt) {
                     GameScr.gI();
                     GameScr.k();
                     GameScr.gI();
                     GameScr.l();
                     GameScr.gI();
                     GameScr.m();
                     Service.gI().q();
                  }

                  CharPartInfo.a(var1);
                  return;
               case -122:
                  ;
                  var1.b().mark(100000);
                  d(var1.b());
                  var1.b().reset();
                  byte[] var52 = new byte[var1.b().available()];
                  var1.b().readFully(var52);
                  RMS.a("data", var52);
                  byte[] var50 = new byte[]{GameScr.dq};
                  RMS.a("dataVersion", var50);
                  if (GameScr.du != GameScr.dq || GameScr.dv != GameScr.dr || GameScr.dw != GameScr.ds || GameScr.dx != GameScr.dt) {
                     return;
                  }

                  GameScr.gI();
                  GameScr.k();
                  GameScr.gI();
                  GameScr.l();
                  GameScr.gI();
                  GameScr.m();
                  Service.gI().q();
                  return;
               case -121:
                  ;
                  var1.b().mark(100000);
                  c(var1.b());
                  var1.b().reset();
                  var53 = new byte[var1.b().available()];
                  var1.b().readFully(var53);
                  RMS.a("map", var53);
                  byte[] var55 = new byte[]{GameScr.dr};
                  RMS.a("mapVersion", var55);
                  if (GameScr.du == GameScr.dq && GameScr.dv == GameScr.dr && GameScr.dw == GameScr.ds && GameScr.dx == GameScr.dt) {
                     GameScr.gI();
                     GameScr.k();
                     GameScr.gI();
                     GameScr.l();
                     GameScr.gI();
                     GameScr.m();
                     Service.gI().q();
                     return;
                  }

                  return;
               case -120:
                  ;
                  var1.b().mark(100000);
                  b(var1.b());
                  var1.b().reset();
                  byte[] var56 = new byte[var1.b().available()];
                  var1.b().readFully(var56);
                  if (Char.getMyChar().aa()) {
                     RMS.a("skill", var56);
                  } else {
                     RMS.a("skillnhanban", var56);
                  }

                  byte[] var58 = new byte[]{GameScr.ds};
                  RMS.a("skillVersion", var58);
                  if (GameScr.du == GameScr.dq && GameScr.dv == GameScr.dr && GameScr.dw == GameScr.ds && GameScr.dx == GameScr.dt) {
                     GameScr.gI();
                     GameScr.k();
                     GameScr.gI();
                     GameScr.l();
                     GameScr.gI();
                     GameScr.m();
                     Service.gI().q();
                     return;
                  }

                  return;
               case -119:
                  ;
                  var1.b().mark(100000);
                  a(var1.b());
                  var1.b().reset();
                  var53 = new byte[var1.b().available()];
                  var1.b().readFully(var53);
                  RMS.a("item", var53);
                  byte[] var44 = new byte[]{GameScr.dt};
                  RMS.a("itemVersion", var44);
                  if (GameScr.du == GameScr.dq && GameScr.dv == GameScr.dr && GameScr.dw == GameScr.ds && GameScr.dx == GameScr.dt) {
                     GameScr.gI();
                     GameScr.k();
                     GameScr.gI();
                     GameScr.l();
                     GameScr.gI();
                     GameScr.m();
                     Service.gI().q();
                     return;
                  }

                  return;
               case -117:
                  Char.getMyChar().cPk = var1.b().readByte();
                  Info.a(TextGame.ifa + " " + Char.getMyChar().cPk, 15, mFont.j);
                  Char.getMyChar().c(21);
                  return;
               case -116:
                  Char.getMyChar().xu = var1.b().readInt();
                  Char.be.g = var1.b().readInt();
                  return;
               case -115:
                  var33 = var1.b().readInt();
                  byte[] var49 = NinjaUtil.b(var1);
                  SmallImage.a(var33, var49);
                  return;
               case -114:
                  if (Char.be == null) {
                     Char.be = new Clan();
                  }

                  Char.be.a(var1.b().readUTF());
                  return;
               case -113:
                  if (Char.be == null) {
                     Char.be = new Clan();
                  }

                  Char.be.a = var1.b().readUTF();
                  Char.be.j = var1.b().readUTF();
                  var1.b().readUTF();
                  Char.be.n = var1.b().readShort();
                  Char.be.f = var1.b().readByte();
                  Char.be.d = var1.b().readByte();
                  Char.be.b = var1.b().readInt();
                  Char.be.c = var1.b().readInt();
                  Char.be.g = var1.b().readInt();
                  Char.be.h = var1.b().readInt();
                  Char.be.i = var1.b().readInt();
                  Char.be.k = var1.b().readUTF();
                  Char.be.m = var1.b().readUTF();
                  Char.be.o = var1.b().readInt();
                  Char.be.e = var1.b().readByte();
                  return;
               case -112:
                  GameScr.vClan.removeAllElements();
                  var40 = var1.b().readShort();

                  for(var36 = 0; var36 < var40; ++var36) {
                     GameScr.vClan.addElement(new Member(var1.b().readByte(), var1.b().readByte(), var1.b().readByte(), var1.b().readUTF(), var1.b().readInt(), var1.b().readBoolean()));
                  }

                  try {
                     for(var36 = 0; var36 < var40; ++var36) {
                        ((Member)GameScr.vClan.elementAt(var36)).g = var1.b().readInt();
                     }
                  } catch (Exception var495) {
                  }

                  GameScr.gI();
                  GameScr.y();
                  return;
               case -111:
                  Char.be.p = new Item[30];
                  var41 = var1.b().readByte();

                  for(var33 = 0; var33 < var41; ++var33) {
                     Char.be.p[var33] = new Item();
                     Char.be.p[var33].typeUI = 39;
                     Char.be.p[var33].indexUI = var33;
                     Char.be.p[var33].quantity = var1.b().readShort();
                     Char.be.p[var33].template = ItemTemplates.a(var1.b().readShort());
                  }

                  GameScr.gI().ao();
                  byte var43 = var1.b().readByte();

                  for(var36 = 0; var36 < var43; ++var36) {
                     String var47 = var1.b().readUTF();
                     short var48 = var1.b().readShort();
                     var5 = var1.b().readShort();
                     var6 = var1.b().readInt();
                     var7 = "";
                     MyVector var8 = new MyVector();
                     int var9 = -1;
                     int var10 = -1;
                     byte var11 = var1.b().readByte();
                     if (var6 >= 0) {
                        var7 = var1.b().readUTF();
                     } else {
                        for(int var12 = 0; var12 < var11; ++var12) {
                           String var51 = var1.b().readUTF();
                           var8.addElement(var51);
                        }

                        var9 = var1.b().readInt();
                        var10 = var1.b().readInt();
                     }

                     byte var57 = var1.b().readByte();
                     GameScr.gI().a(new Clan_ThanThu(var47, var57, var48, var5, var6, var7, var8, var9, var10));
                  }

                  return;
               case -109:
                  if (DebugLog.DEBUG) ;
                  try {
                     boolean var45 = false;
                     GameCanvas.f = true;
                     TileMap.maps = null;
                     TileMap.types = null;
                     System.gc();
                     TileMap.a(TileMap.mapID, var1.b());
                     TileMap.h();
                     if (DebugLog.DEBUG) ;
                     var1 = this.b;
                     this.d(var1);
                     if (DebugLog.DEBUG) ;
                  } catch (Exception var434) {
                     if (DebugLog.DEBUG) ;
                     ;
                  }

                  var1.d();
                  this.b.d();
                  var1 = this.b = null;
                  return;
               case -108:
                  var40 = var1.b().readShort();

                  try {
                     var36 = var1.b().readByte();
                     Mob.b[var40].d = (byte)var36;
                  } catch (Exception var435) {
                  }

                  var36 = var1.b().readByte();
                  Mob.b[var40].h = new Image[var36];
                  if (var40 != 98 && var40 != 99) {
                     for(var36 = 0; var36 < Mob.b[var40].h.length; ++var36) {
                        Mob.b[var40].h[var36] = a(NinjaUtil.b(var1));
                     }
                  } else {
                     Mob.b[var40].h = new Image[3];
                     Image var39 = a(NinjaUtil.b(var1));

                     for(var3 = 0; var3 < Mob.b[var40].h.length; ++var3) {
                        Mob.b[var40].h[var3] = var39;
                     }
                  }

                  if (var1.b().readBoolean()) {
                     var41 = var1.b().readByte();
                     Mob.b[var40].k = new byte[var41];

                     for(var3 = 0; var3 < var41; ++var3) {
                        Mob.b[var40].k[var3] = var1.b().readByte();
                     }

                     var41 = var1.b().readByte();
                     Mob.b[var40].l = new byte[var41][];

                     for(var3 = 0; var3 < var41; ++var3) {
                        Mob.b[var40].l[var3] = new byte[var1.b().readByte()];

                        for(var42 = 0; var42 < Mob.b[var40].l[var3].length; ++var42) {
                           Mob.b[var40].l[var3][var42] = var1.b().readByte();
                        }
                     }
                  }

                  if (var1.b().readInt() > 0) {
                     if (var40 < 236) {
                        a(var1, var40);
                     } else {
                        b(var1, var40);
                     }

                     return;
                  }

                  return;
               case -106:
                  GameScr.ei = var1.b().readByte();
                  return;
               case -99:
                  GameCanvas.am.a(TextGame.ao, TextGame.ap);
                  var34 = var1.b().readUTF();
                  GameCanvas.am.a(var34, new Command1(TextGame.ah, GameCanvas.instance, 8882, (Object)null), new Command1(TextGame.at, GameCanvas.instance, 88816, (Object)null), 0, 1);
                  return;
               case -98:
                  Char.getMyChar();
                  Char.y();
                  return;
               case -97:
                  GameCanvas.f = false;
                  GameCanvas.j();
                  Integer var38 = new Integer(var1.b().readInt());
                  GameCanvas.al.a(TextGame.dx, new Command1(TextGame.bx, GameCanvas.instance, 88829, var38), 0);
                  return;
               case -96:
                  Char.getMyChar().cClanName = var1.b().readUTF();
                  Char.getMyChar().ctypeClan = 4;
                  Char.getMyChar().luong = var1.b().readInt();
                  Char.getMyChar().c(21);
                  return;
               case -95:
                  if (Char.be != null) {
                     Char.be.m = var1.b().readUTF();
                  }

                  return;
               case -93:
                  if ((var33 = var1.b().readInt()) == Char.getMyChar().idChar) {
                     GameScr.vClan.removeAllElements();
                     Char.getMyChar().cClanName = "";
                     Char.getMyChar().ctypeClan = -1;
                     Char.be = null;
                  } else {
                     GameScr.vClan.removeAllElements();
                     Char var37;
                     (var37 = GameScr.e(var33)).cClanName = "";
                     var37.ctypeClan = -1;
                  }

                  return;
               case -90:
                  Char.getMyChar().xu = var1.b().readInt();
                  GameScr.gI().v();
                  return;
               case -88:
                  GameScr.gI().v();
                  Item var35;
                  (var35 = Char.getMyChar().arrItemBag[var1.b().readByte()]).g();
                  var35.isLock = true;
                  var35.upgrade = var1.b().readByte();
                  (var35 = Char.getMyChar().arrItemBag[var1.b().readByte()]).g();
                  var35.isLock = true;
                  var35.upgrade = var1.b().readByte();
                  Info.a(TextGame.ma, 20, mFont.d);
                  return;
               case -86:
                  GameCanvas.j();
                  GameScr.gI().v();
                  InfoMe.a(var1.b().readUTF(), 20, mFont.j);
                  Code.ig_lead = null;
                  return;
               case -84:
                  Char.dx = var1.b().readShort();
                  return;
               case -83:
                  var3 = var1.b().readShort();
                  var42 = var1.b().readShort();
                  var5 = (short)var1.b().readByte();
                  var6 = var1.b().readShort();
                  if (var3 == 0) {
                     GameScr.gI().a(TextGame.dt, "          " + TextGame.no, false);
                  } else {
                     var7 = TextGame.di + ": " + var3 + "\n\n";
                     if (var42 == 0) {
                        var7 = var7 + TextGame.dl + "\n\n";
                     } else {
                        var7 = var7 + TextGame.dm + ": " + NinjaUtil.b(var42) + "\n\n";
                     }

                     var7 = var7 + TextGame.dn + ": " + var5 + "\n\n";
                     var7 = var7 + TextGame.ef + ": " + var6 + " " + TextGame.eg + "\n\n";
                     GameScr.gI().a(TextGame.dt, var7, false);
                     if (var6 > 0) {
                        GameScr.gI().a = new Command1(TextGame.ef, 1000);
                        return;
                     }
                  }

                  return;
               case -81:
                  Char.dy = var1.b().readShort();
                  return;
               case -80:
                  GameScr.gI().a(TextGame.ds, var1.b().readUTF(), false);
                  if (var1.b().readBoolean()) {
                     GameScr.gI().a = new Command1(TextGame.ef, 2000);
                  }

                  return;
               case -77:
                  GameCanvas.b(TileMap.versionMap = var1.b().readByte());
                  return;
               case -72:
                  GameScr.gI().en = new String[9];
                  GameScr.cg = new short[9];
                  if (GameScr.indexSelect < 0 || GameScr.indexSelect > 8) {
                     GameScr.ax = 0;
                     GameScr.indexSelect = 0;
                  }

                  for(var33 = 0; var33 < 9; ++var33) {
                     GameScr.cg[var33] = var1.b().readShort();
                     GameScr.gI().en[var33] = GameScr.gI().ek[NinjaUtil.a(9)];
                  }

                  GameScr.gI().a = new Command1(TextGame.ay, (IActionListener)null, 1506, (Object)null);
                  GameScr.gI().ej = System.currentTimeMillis();
                  --GameScr.gI().ch;
                  GameCanvas.j();
                  return;
               case -70:
                  var34 = var1.b().readUTF();
                  GameCanvas.a(NinjaUtil.a(TextGame.qw, "#", var34), new Command1(TextGame.bh, GameCanvas.instance, 88842, (Object)null), new Command1(TextGame.bu, GameCanvas.instance, 8882, (Object)null));
                  return;
               case -67:
                  Mob var4 = null;

                  try {
                     var4 = Mob.get_Mob(var1.b().readUnsignedByte());
                  } catch (Exception var426) {
                  }

                  if (var4 != null) {
                     if ((var33 = var1.b().readInt()) == Char.getMyChar().idChar) {
                        GameScr.vMobSoul.addElement(new MobSoul(var4.x1, var4.y1, Char.getMyChar()));
                     } else if ((var2 = GameScr.e(var33)) != null) {
                        GameScr.vMobSoul.addElement(new MobSoul(var4.x1, var4.y1, var2));
                        return;
                     }

                     return;
                  }

                  return;
               case -66:
                  var33 = var1.b().readInt();
                  if (Char.getMyChar().idChar == var33) {
                     GameScr.vMobSoul.addElement(new MobSoul(Char.getMyChar().cx1, Char.getMyChar().cy1));
                  } else if ((var2 = GameScr.e(var33)) != null) {
                     GameScr.vMobSoul.addElement(new MobSoul(var2.cx1, var2.cy1));
                     return;
                  }

                  return;
               case -62:
                  Char.be.e = var1.b().readByte();
            }
         } catch (Exception var50) {
         }

      } finally {
         if (var1 != null) {
            var1.d();
         }

      }
   }

   private static void f(Message var0) {
      try {
         switch (var0.b().readByte()) {
            case -124:
               ;
               String var1 = var0.b().readUTF();
               Class_eb.a(var0.b().readUTF(), "sms://" + var1, new Command1("", GameCanvas.gI(), 88825, (Object)null), new Command1("", GameCanvas.gI(), 88826, (Object)null));
               break;
            case 2:
               RMS.a();
         }
      } catch (Exception var5) {
      } finally {
         if (var0 != null) {
            var0.d();
         }

      }

   }

   private void g(Message var1) {
      try {
         try {
            int var42 = var1.b().readByte();
            boolean var2 = false;
            EffectTemplate var65;
            Skill skill;
            int var4;
            byte var69;
            Service var72;
            GameScr var73;
            Char var74;
            byte var10000;
            int var43;
            short[] var44;
            ItemTemplate var45;
            Char var48;
            int var49;
            short var51;
            short var52;
            short var53;
            byte var54;
            byte var56;
            Integer var57;
            Effect var58;
            Effect var61;
            short var62;
            String var63;
            switch (var42) {
               case -128:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
                  var48.cLevel = var1.b().readUnsignedByte();
                  return;
               case -127:
                  GameScr.vCharInMap.removeAllElements();
                  GameScr.vItemMap.removeAllElements();
                  GameScr.ad();
                  GameScr.currentCharViewInfo = Char.getMyChar();
                  Char.getMyChar().idChar = var1.b().readInt();
                  Char.getMyChar().cClanName = var1.b().readUTF();
                  if (!Char.getMyChar().cClanName.equals("")) {
                     Char.getMyChar().ctypeClan = var1.b().readByte();
                  }

                  Char.getMyChar().ctaskId = var1.b().readByte();
                  Char.getMyChar().cgender = var1.b().readByte();
                  Char.getMyChar().head = var1.b().readShort();
                  Char.getMyChar().cspeed = var1.b().readByte();
                  Char.getMyChar().cName = fix_vip(var1.b().readUTF());
                  Char.getMyChar().cPk = var1.b().readByte();
                  Char.getMyChar().cTypePk = var1.b().readByte();
                  Char.getMyChar().cMaxHP = var1.b().readInt();
                  Char.getMyChar().cHP = var1.b().readInt();
                  Char.getMyChar().cMaxMP = var1.b().readInt();
                  Char.getMyChar().cMP = var1.b().readInt();
                  Char.getMyChar().cEXP = var1.b().readLong();
                  Char.getMyChar().cExpDown = var1.b().readLong();
                  GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                  Char.getMyChar().eff5BuffHp = var1.b().readShort();
                  Char.getMyChar().eff5BuffMp = var1.b().readShort();
                  Char.getMyChar().nClass = GameScr.nClasss[var1.b().readByte()];
                  Char.getMyChar().pPoint = var1.b().readShort();
                  Char.getMyChar().potential[0] = var1.b().readShort();
                  Char.getMyChar().potential[1] = var1.b().readShort();
                  Char.getMyChar().potential[2] = var1.b().readInt();
                  Char.getMyChar().potential[3] = var1.b().readInt();
                  Char.getMyChar().sPoint = var1.b().readShort();
                  Char.getMyChar().vSkill.removeAllElements();
                  Char.getMyChar().vSkillFight.removeAllElements();
                  var52 = (short)var1.b().readByte();

                  for(var54 = 0; var54 < var52; ++var54) {
                     skill = Skills.get(var1.b().readShort());
                     if (Char.getMyChar().myskill == null) {
                        Char.getMyChar().myskill = skill;
                     }

                     if (Code.mode != null && Auto.my_skill != null && skill.template.id == Auto.my_skill.template.id) {
                        Auto.my_skill = skill;
                     }

                     Char.getMyChar().vSkill.addElement(skill);
                     if ((skill.template.type == 1 || skill.template.type == 4 || skill.template.type == 2 || skill.template.type == 3) && (skill.template.maxPoint == 0 || skill.template.maxPoint > 0 && skill.point > 0)) {
                        var10000 = skill.template.id;
                        Char.getMyChar();
                        if (var10000 == 0) {
                           var72 = Service.gI();
                           Char.getMyChar();
                           var72.selectSkill(0);
                        }

                        Char.getMyChar().vSkillFight.addElement(skill);
                     }
                  }

                  GameScr.gI();
                  GameScr.sortSkill();
                  Char.getMyChar().xu = var1.b().readInt();
                  Char.getMyChar().yen = var1.b().readInt();
                  Char.getMyChar().luong = var1.b().readInt();
                  Char.getMyChar().arrItemBag = new Item[var1.b().readUnsignedByte()];
                  GameScr.hpPotion = 0;
                  GameScr.mpPotion = 0;
                  var4 = 0;

                  short[] var68;
                  while(true) {
                     if (var4 >= Char.getMyChar().arrItemBag.length) {
                        Code.update_tinhluyen();
                        Char.getMyChar().arrItemBody = new Item[32];

                        try {
                           Char.getMyChar().j();

                           for(var4 = 0; var4 < 16; ++var4) {
                              if ((var62 = var1.b().readShort()) != -1) {
                                 ItemTemplate var70;
                                 var69 = (var70 = ItemTemplates.a(var62)).type;
                                 Char.getMyChar().arrItemBody[var69] = new Item();
                                 Char.getMyChar().arrItemBody[var69].indexUI = var69;
                                 Char.getMyChar().arrItemBody[var69].typeUI = 5;
                                 Char.getMyChar().arrItemBody[var69].template = var70;
                                 Char.getMyChar().arrItemBody[var69].isLock = true;
                                 Char.getMyChar().arrItemBody[var69].upgrade = var1.b().readByte();
                                 Char.getMyChar().arrItemBody[var69].sys = var1.b().readByte();
                                 if (var69 == 1) {
                                    Char.getMyChar().weapon = Char.getMyChar().arrItemBody[var69].template.part;
                                 } else if (var69 == 2) {
                                    Char.getMyChar().body = Char.getMyChar().arrItemBody[var69].template.part;
                                 } else if (var69 == 6) {
                                    Char.getMyChar().leg = Char.getMyChar().arrItemBody[var69].template.part;
                                 }
                              }
                           }
                        } catch (Exception var369) {
                           ;
                        }

                        Char.getMyChar().isHuman = var1.b().readBoolean();
                        Char.getMyChar().isNhanban = var1.b().readBoolean();
                        if ((var68 = new short[]{var1.b().readShort(), var1.b().readShort(), var1.b().readShort(), var1.b().readShort()})[0] > -1) {
                           Char.getMyChar().head = var68[0];
                        }

                        if (var68[1] > -1) {
                           Char.getMyChar().weapon = var68[1];
                        }

                        if (var68[2] > -1) {
                           Char.getMyChar().body = var68[2];
                        }
                        break;
                     }

                     if ((var62 = var1.b().readShort()) != -1) {
                        Char.getMyChar().arrItemBag[var4] = new Item();
                        Char.getMyChar().arrItemBag[var4].typeUI = 3;
                        Char.getMyChar().arrItemBag[var4].indexUI = var4;
                        Char.getMyChar().arrItemBag[var4].template = ItemTemplates.a(var62);
                        Char.getMyChar().arrItemBag[var4].isLock = var1.b().readBoolean();
                        if (Char.getMyChar().arrItemBag[var4].b() || Char.getMyChar().arrItemBag[var4].c() || Char.getMyChar().arrItemBag[var4].d()) {
                           Char.getMyChar().arrItemBag[var4].upgrade = var1.b().readByte();
                        }

                        Char.getMyChar().arrItemBag[var4].isExpires = var1.b().readBoolean();
                        Char.getMyChar().arrItemBag[var4].quantity = var1.b().readUnsignedShort();
                        if (Char.getMyChar().arrItemBag[var4].template.type == 16) {
                           GameScr.mpPotion += Char.getMyChar().arrItemBag[var4].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var4].template.type == 17) {
                           GameScr.hpPotion += Char.getMyChar().arrItemBag[var4].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var4].template.id == 340) {
                           var73 = GameScr.gI();
                           var73.ch += Char.getMyChar().arrItemBag[var4].quantity;
                        }
                     }

                     ++var4;
                  }

                  if (var68[3] > -1) {
                     Char.getMyChar().leg = var68[3];
                  }

                  var44 = new short[10];

                  try {
                     for(var43 = 0; var43 < 10; ++var43) {
                        var44[var43] = var1.b().readShort();
                     }
                  } catch (Exception var71) {
                     debugFashion("setThoiTrang(myChar-login) readError err=" + var71.getMessage());
                     var44 = null;
                  }

                  if (var44 != null) {
                     debugFashion("setThoiTrang(myChar-login) values=[" + var44[0] + "," + var44[1] + "," + var44[2] + "," + var44[3] + "," + var44[4] + "," + var44[5] + "," + var44[6] + "," + var44[7] + "," + var44[8] + "," + var44[9] + "]");
                     Char.getMyChar().setThoiTrang(var44);
                  }

                  try {
                     for(var43 = 0; var43 < 16; ++var43) {
                        if ((var62 = var1.b().readShort()) != -1) {
                           var49 = (var45 = ItemTemplates.a(var62)).type + 16;
                           Char.getMyChar().arrItemBody[var49] = new Item();
                           Char.getMyChar().arrItemBody[var49].indexUI = var49;
                           Char.getMyChar().arrItemBody[var49].typeUI = 5;
                           Char.getMyChar().arrItemBody[var49].template = var45;
                           Char.getMyChar().arrItemBody[var49].isLock = true;
                           Char.getMyChar().arrItemBody[var49].upgrade = var1.b().readByte();
                           Char.getMyChar().arrItemBody[var49].sys = var1.b().readByte();
                           if (var49 == 1) {
                              Char.getMyChar().weapon = Char.getMyChar().arrItemBody[var49].template.part;
                           } else if (var49 == 2) {
                              Char.getMyChar().body = Char.getMyChar().arrItemBody[var49].template.part;
                           } else if (var49 == 6) {
                              Char.getMyChar().leg = Char.getMyChar().arrItemBody[var49].template.part;
                           }
                        }
                     }
                  } catch (Exception var70) {
                     ;
                  }

                  var2 = false;

                  try {
                     var52 = var1.b().readShort();
                  } catch (Exception var568) {
                     var52 = -1;
                  }

                  Char.getMyChar().ff = var52;
                  if (Char.getMyChar().isHuman) {
                     GameScr.gI();
                     GameScr.loadSkillShortcut();
                  } else if (Char.getMyChar().isNhanban) {
                     GameScr.gI();
                     GameScr.loadSkillShortcutNhanban();
                  }

                  Char.getMyChar().statusMe = 4;
                  GameScr.cl = RMS.c(Char.getMyChar().cName + "vci") >= 1;
                  if (Char.getMyChar().aa()) {
                     b(new DataInputStream(new ByteArrayInputStream(RMS.a("skill"))));
                  } else {
                     b(new DataInputStream(new ByteArrayInputStream(RMS.a("skillnhanban"))));
                  }

                  Service.gI().m("KSkill");
                  Service.gI().m("OSkill");
                  Service.gI().m("CSkill");
                  return;
               case -126:
                  Char.getMyChar().a(var1);
                  Char.getMyChar().potential[0] = var1.b().readShort();
                  Char.getMyChar().potential[1] = var1.b().readShort();
                  Char.getMyChar().potential[2] = var1.b().readInt();
                  Char.getMyChar().potential[3] = var1.b().readInt();
                  Char.getMyChar().c(61);
                  Char.getMyChar().nClass = GameScr.nClasss[var1.b().readByte()];
                  Char.getMyChar().sPoint = var1.b().readShort();
                  Char.getMyChar().pPoint = var1.b().readShort();
                  Char.getMyChar().vSkill.removeAllElements();
                  Char.getMyChar().vSkillFight.removeAllElements();
                  Char.getMyChar().myskill = null;
                  return;
               case -125:
                  Char.getMyChar().a(var1);
                  if (Char.getMyChar().statusMe != 14 && Char.getMyChar().statusMe != 5) {
                     Char.getMyChar().cHP = Char.getMyChar().cMaxHP;
                     Char.getMyChar().cMP = Char.getMyChar().cMaxMP;
                  }

                  try {
                     Char.getMyChar().sPoint = var1.b().readShort();
                     Char.getMyChar().vSkill.removeAllElements();
                     Char.getMyChar().vSkillFight.removeAllElements();
                     var52 = (short)var1.b().readByte();

                     for(var69 = 0; var69 < var52; ++var69) {
                        skill = Skills.get(var1.b().readShort());
                        if (Char.getMyChar().myskill == null) {
                           Char.getMyChar().myskill = skill;
                        } else if (skill.template.equals(Char.getMyChar().myskill.template)) {
                           Char.getMyChar().myskill = skill;
                        }

                        if (Code.mode != null && Auto.my_skill != null && skill.template.id == Auto.my_skill.template.id) {
                           Auto.my_skill = skill;
                        }

                        Char.getMyChar().vSkill.addElement(skill);
                        if ((skill.template.type == 1 || skill.template.type == 4 || skill.template.type == 2 || skill.template.type == 3) && (skill.template.maxPoint == 0 || skill.template.maxPoint > 0 && skill.point > 0)) {
                           var10000 = skill.template.id;
                           Char.getMyChar();
                           if (var10000 == 0) {
                              var72 = Service.gI();
                              Char.getMyChar();
                              var72.selectSkill(0);
                           }

                           Char.getMyChar().vSkillFight.addElement(skill);
                        }
                     }

                     GameScr.gI();
                     GameScr.sortSkill();
                     if (!GameScr.cr) {
                        return;
                     }

                     GameScr.av = -1;
                     GameScr.gI().aj();
                     return;
                  } catch (Exception var67) {
                     ;
                     return;
                  }
               case -124:
                  Char.getMyChar().a(var1);
                  Char.getMyChar().cEXP = var1.b().readLong();
                  GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                  Char.getMyChar().sPoint = var1.b().readShort();
                  Char.getMyChar().pPoint = var1.b().readShort();
                  Char.getMyChar().potential[0] = var1.b().readShort();
                  Char.getMyChar().potential[1] = var1.b().readShort();
                  Char.getMyChar().potential[2] = var1.b().readInt();
                  Char.getMyChar().potential[3] = var1.b().readInt();
                  return;
               case -123:
                  Char.getMyChar().xu = var1.b().readInt();
                  Char.getMyChar().yen = var1.b().readInt();
                  Char.getMyChar().luong = var1.b().readInt();
                  Char.getMyChar().cHP = var1.b().readInt();
                  Char.getMyChar().cMP = var1.b().readInt();
                  if (var1.b().readByte() == 1) {
                     GameScr.gI().an();
                     Char.getMyChar().d = true;
                  } else {
                     Char.getMyChar().d = false;
                  }

                  return;
               case -122:
                  Char.getMyChar().cHP = var1.b().readInt();
                  return;
               case -121:
                  Char.getMyChar().cMP = var1.b().readInt();
                  return;
               case -120:
                  if ((var48 = GameScr.e(var1.b().readInt())) != null) {
                     a(var48, var1);
                  }

                  return;
               case -119:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
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
                  if ((var48 = GameScr.e(var1.b().readInt())) != null) {
                     var48.cHP = var1.b().readInt();
                     var48.cMaxHP = var1.b().readInt();
                     var48.eff5BuffHp = var1.b().readShort();
                     var48.eff5BuffMp = var1.b().readShort();
                     var48.weapon = var1.b().readShort();
                     if (var48.weapon == -1) {
                        var48.k();
                     }

                     return;
                  }

                  return;
               case -116:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
                  var48.eff5BuffHp = var1.b().readShort();
                  var48.eff5BuffMp = var1.b().readShort();
                  var48.body = var1.b().readShort();
                  if (var48.body == -1) {
                     var48.l();
                  }

                  return;
               case -113:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
                  var48.eff5BuffHp = var1.b().readShort();
                  var48.eff5BuffMp = var1.b().readShort();
                  var48.leg = var1.b().readShort();
                  if (var48.leg == -1) {
                     var48.m();
                  }

                  return;
               case -112:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
                  var48.eff5BuffHp = var1.b().readShort();
                  var48.eff5BuffMp = var1.b().readShort();
                  return;
               case -111:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  return;
               case -110:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
                  var48.cx1 = var48.ed = var1.b().readShort();
                  var48.cy1 = var48.ee = var1.b().readShort();
                  var48.statusMe = 1;
                  ServerEffect.a(20, var48, 2);
                  return;
               case -109:
                  Char.getMyChar().a(var1);
                  if (Char.getMyChar().statusMe != 14 && Char.getMyChar().statusMe != 5) {
                     Char.getMyChar().cHP = Char.getMyChar().cMaxHP;
                     Char.getMyChar().cMP = Char.getMyChar().cMaxMP;
                  }

                  Char.getMyChar().pPoint = var1.b().readShort();
                  Char.getMyChar().potential[0] = var1.b().readShort();
                  Char.getMyChar().potential[1] = var1.b().readShort();
                  Char.getMyChar().potential[2] = var1.b().readInt();
                  Char.getMyChar().potential[3] = var1.b().readInt();
                  phong1.x();
                  return;
               case -107:
                  Char.getMyChar().f();
                  return;
               case -106:
                  Char.getMyChar().g();
                  return;
               case -105:
                  var42 = var1.b().readInt();
                  var74 = Char.getMyChar();
                  var74.xu -= var42;
                  var74 = Char.getMyChar();
                  var74.bs += var42;
                  return;
               case -104:
                  var49 = var1.b().readInt();
                  var74 = Char.getMyChar();
                  var74.bs -= var49;
                  var74 = Char.getMyChar();
                  var74.xu += var49;
                  return;
               case -102:
                  Char.getMyChar().arrItemBag[var1.b().readByte()] = null;
                  skill = Skills.get(var1.b().readShort());
                  Char.getMyChar().vSkill.addElement(skill);
                  if ((skill.template.type == 1 || skill.template.type == 4 || skill.template.type == 2 || skill.template.type == 3) && (skill.template.maxPoint == 0 || skill.template.maxPoint > 0 && skill.point > 0)) {
                     var10000 = skill.template.id;
                     Char.getMyChar();
                     if (var10000 == 0) {
                        var72 = Service.gI();
                        Char.getMyChar();
                        var72.selectSkill(0);
                     }

                     Char.getMyChar().vSkillFight.addElement(skill);
                  }

                  GameScr.gI();
                  GameScr.sortSkill();
                  GameScr.gI().a(skill);
                  GameScr.gI().aj();
                  InfoMe.a(TextGame.pf + " " + skill.template.b);
                  return;
               case -101:
                  var61 = new Effect(var1.b().readByte(), (int)(System.currentTimeMillis() / 1000L) - var1.b().readInt(), var1.b().readInt(), var1.b().readShort());
                  Char.getMyChar().by.addElement(var61);
                  if (var61.e.b == 7) {
                     var74 = Char.getMyChar();
                     var74.cMiss += var61.d;
                     return;
                  }

                  if (var61.e.b != 12 && var61.e.b != 11) {
                     if (var61.e.b == 14) {
                        GameCanvas.h();
                        GameCanvas.i();
                        Char.getMyChar().cx1 = var1.b().readShort();
                        Char.getMyChar().cy1 = var1.b().readShort();
                        Char.getMyChar().statusMe = 1;
                        Char.getMyChar().ei = true;
                        ServerEffect.b(76, Char.getMyChar(), var61.c);
                        return;
                     }

                     if (var61.e.b == 1) {
                        ServerEffect.b(48, Char.getMyChar(), var61.c);
                        return;
                     }

                     if (var61.e.b == 2) {
                        GameCanvas.h();
                        GameCanvas.i();
                        Char.getMyChar().cx1 = var1.b().readShort();
                        Char.getMyChar().cy1 = var1.b().readShort();
                        Char.getMyChar().statusMe = 1;
                        Char.getMyChar().ei = true;
                        Char.getMyChar().ej = true;
                     } else if (var61.e.b == 3) {
                        GameCanvas.h();
                        GameCanvas.i();
                        Char.getMyChar().cx1 = var1.b().readShort();
                        Char.getMyChar().cy1 = var1.b().readShort();
                        Char.getMyChar().statusMe = 1;
                        Char.eh = true;
                        ServerEffect.b(43, Char.getMyChar(), var61.c);
                        return;
                     }

                     return;
                  }

                  Char.getMyChar().dh = true;
                  ServerEffect.a(60, Char.getMyChar().cx1, Char.getMyChar().cy1, 1);
                  return;
               case -100:
                  var65 = Effect.a[var1.b().readByte()];

                  for(var49 = 0; var49 < Char.getMyChar().by.size(); ++var49) {
                     if ((var58 = (Effect)Char.getMyChar().by.elementAt(var49)).e.b == var65.b) {
                        if (var58.e.b == 7) {
                           var74 = Char.getMyChar();
                           var74.cMiss -= var58.d;
                        }

                        var58.e = var65;
                        var58.b = (int)(System.currentTimeMillis() / 1000L) - var1.b().readInt();
                        var58.c = var1.b().readInt() / 1000;
                        var58.d = var1.b().readShort();
                        if (var58.e.b == 7) {
                           var74 = Char.getMyChar();
                           var74.cMiss += var58.d;
                        }
                        break;
                     }
                  }

                  // Bug 1 fix: case -100 chỉ update field effect trong char.by — không có lý do đóng panel.
                  // v() reset super.b = null → F1 menu mất visual khi effect tick/refresh trong combat.

                  return;
               case -99:
                  var56 = var1.b().readByte();
                  var58 = null;

                  for(var43 = 0; var43 < Char.getMyChar().by.size(); ++var43) {
                     if ((var58 = (Effect)Char.getMyChar().by.elementAt(var43)).e.a == var56) {
                        if (var58.e.b == 7) {
                           var74 = Char.getMyChar();
                           var74.cMiss -= var58.d;
                        }

                        Char.getMyChar().by.removeElementAt(var43);
                        break;
                     }
                  }

                  if (var58.e.b != 0 && var58.e.b != 12) {
                     if (var58.e.b != 4 && var58.e.b != 13 && var58.e.b != 17) {
                        if (var58.e.b == 23) {
                           Char.getMyChar().cHP = var1.b().readInt();
                           Char.getMyChar().cMaxHP = var1.b().readInt();
                           return;
                        }

                        if (var58.e.b == 11) {
                           Char.getMyChar().dh = false;
                           ServerEffect.a(60, Char.getMyChar().cx1, Char.getMyChar().cy1, 1);
                           return;
                        }

                        if (var58.e.b == 14) {
                           Char.getMyChar().ei = false;
                           return;
                        }

                        if (var58.e.b == 2) {
                           Char.getMyChar().ei = false;
                           Char.getMyChar().ej = false;
                           ServerEffect.a(77, Char.getMyChar().cx1, Char.getMyChar().cy1 - 9, 1);
                           return;
                        }

                        if (var58.e.b != 3) {
                           return;
                        }

                        Char.eh = false;
                        return;
                     }

                     Char.getMyChar().cHP = var1.b().readInt();
                     return;
                  }

                  Char.getMyChar().cHP = var1.b().readInt();
                  Char.getMyChar().cMP = var1.b().readInt();
                  if (var58.e.b == 0) {
                     InfoMe.a(TextGame.mx);
                  } else if (var58.e.b == 12) {
                     Char.getMyChar().dh = false;
                     ServerEffect.a(60, Char.getMyChar().cx1, Char.getMyChar().cy1, 1);
                     return;
                  }

                  return;
               case -98:
                  try {
                     if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                        return;
                     }

                     var61 = new Effect(var1.b().readByte(), (int)(System.currentTimeMillis() / 1000L) - var1.b().readInt(), var1.b().readInt(), var1.b().readShort());
                     var48.by.addElement(var61);
                     if (var61.e.b != 12 && var61.e.b != 11) {
                        if (var61.e.b == 14) {
                           var48.cx1 = var48.ed = var1.b().readShort();
                           var48.cy1 = var48.ee = var1.b().readShort();
                           var48.statusMe = 1;
                           ServerEffect.b(76, var48, var61.c);
                           return;
                        }

                        if (var61.e.b == 1) {
                           ServerEffect.b(48, var48, var61.c);
                           return;
                        }

                        if (var61.e.b == 2) {
                           var48.cx1 = var48.ed = var1.b().readShort();
                           var48.cy1 = var48.ee = var1.b().readShort();
                           var48.statusMe = 1;
                           var48.ej = true;
                           return;
                        }

                        if (var61.e.b != 3) {
                           return;
                        }

                        var48.cx1 = var48.ed = var1.b().readShort();
                        var48.cy1 = var48.ee = var1.b().readShort();
                        var48.statusMe = 1;
                        ServerEffect.b(43, var48, var61.c);
                        return;
                     }

                     var48.dh = true;
                     ServerEffect.a(60, var48.cx1, var48.cy1, 1);
                     return;
                  } catch (Exception var668) {
                     return;
                  }
               case -97:
                  try {
                     if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                        return;
                     }

                     var65 = Effect.a[var1.b().readByte()];

                     for(var49 = 0; var49 < var48.by.size(); ++var49) {
                        var58 = (Effect)var48.by.elementAt(var49);
                        if (var65.b == var65.b) {
                           var58.e = var65;
                           var58.b = (int)(System.currentTimeMillis() / 1000L) - var1.b().readInt();
                           var58.c = var1.b().readInt() / 1000;
                           var58.d = var1.b().readShort();
                           return;
                        }
                     }

                     return;
                  } catch (Exception var66) {
                     return;
                  }
               case -96:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var56 = var1.b().readByte();
                  var61 = null;
                  var4 = 0;

                  while(true) {
                     if (var4 < var48.by.size()) {
                        if ((var61 = (Effect)var48.by.elementAt(var4)).e.a != var56) {
                           ++var4;
                           continue;
                        }

                        var48.by.removeElementAt(var4);
                     }

                     if (var61 == null) {
                        return;
                     }

                     if (var61.e.b == 0) {
                        var48.cHP = var1.b().readInt();
                        var48.cMP = var1.b().readInt();
                        return;
                     }

                     if (var61.e.b == 11) {
                        var48.cx1 = var48.ed = var1.b().readUnsignedShort();
                        var48.cy1 = var48.ee = var1.b().readUnsignedShort();
                        var48.dh = false;
                        ServerEffect.a(60, var48.cx1, var48.cy1, 1);
                        return;
                     }

                     if (var61.e.b == 12) {
                        var48.cHP = var1.b().readInt();
                        var48.cMP = var1.b().readInt();
                        var48.dh = false;
                        ServerEffect.a(60, var48.cx1, var48.cy1, 1);
                        return;
                     }

                     if (var61.e.b != 4 && var61.e.b != 13 && var61.e.b != 17) {
                        if (var61.e.b == 23) {
                           Char.getMyChar().cHP = var1.b().readInt();
                           Char.getMyChar().cMaxHP = var1.b().readInt();
                           return;
                        }

                        if (var61.e.b != 2) {
                           return;
                        }

                        var48.ej = false;
                        ServerEffect.a(77, var48.cx1, var48.cy1 - 9, 1);
                        return;
                     }

                     var48.cHP = var1.b().readInt();
                     return;
                  }
               case -95:
                  GameScr.gI().eg = var1.b().readInt();
                  GameScr.gI().eh = (int)(System.currentTimeMillis() / 1000L);
                  return;
               case -94:
                  var54 = var1.b().readByte();
                  Npc var71;
                  (var71 = (Npc)GameScr.vNpc.elementAt(var54)).statusMe = var1.b().readByte();
                  if (var71.npcTemplate.npcTemplateId == 31 && var71.statusMe == 15) {
                     GameScr.a(var71.cx1, var71.cy1);
                  }

                  return;
               case -92:
                  if ((var42 = var1.b().readInt()) == Char.getMyChar().idChar) {
                     var48 = Char.getMyChar();
                  } else {
                     var48 = GameScr.e(var42);
                  }

                  if (var48 != null) {
                     var48.cTypePk = var1.b().readByte();
                     if (var48 == Char.getMyChar()) {
                        if (var48.cTypePk == 4) {
                           GameScr.tilemap_fi = true;
                        } else if (var48.cExactly == 5) {
                           GameScr.tilemap_fi = false;
                           return;
                        }

                        return;
                     }
                  }

                  return;
               case -91:
                  Item[] var66 = new Item[var1.b().readUnsignedByte()];

                  for(var42 = 0; var42 < Char.getMyChar().arrItemBag.length; ++var42) {
                     var66[var42] = Char.getMyChar().arrItemBag[var42];
                  }

                  Char.getMyChar().arrItemBag = var66;
                  Char.getMyChar().arrItemBag[var1.b().readUnsignedByte()] = null;
                  InfoMe.a(TextGame.eh + " " + Char.getMyChar().arrItemBag.length + " " + TextGame.fb);
                  return;
               case -90:
                  var42 = 0;

                  while(true) {
                     if (var42 < GameScr.vNpc.size()) {
                        Npc var60;
                        if ((var60 = (Npc)GameScr.vNpc.elementAt(var42)).statusMe != 15) {
                           ++var42;
                           continue;
                        }

                        var60.statusMe = 1;
                     }

                     if ((var69 = var1.b().readByte()) == 1) {
                        InfoMe.a(TextGame.ei, 20, mFont.j);
                     } else if (var69 == 2) {
                        InfoMe.a(TextGame.ej, 20, mFont.j);
                        return;
                     }

                     return;
                  }
               case -89:
                  GameCanvas.f = false;

                  try {
                     InfoMe.a(var1.b().readUTF(), 20, mFont.j);
                  } catch (Exception var571) {
                  }

                  InfoDlg.b();
                  GameCanvas.j();
                  return;
               case -87:
                  var52 = (short)var1.b().readByte();
                  Party var67 = (Party)GameScr.vParty.elementAt(var52);
                  GameScr.vParty.setElementAt(GameScr.vParty.elementAt(0), var52);
                  GameScr.vParty.setElementAt(var67, 0);
                  GameScr.gI().t();
                  InfoMe.a(var67.d + TextGame.ny, 20, mFont.j);
                  return;
               case -86:
                  GameScr.vParty.removeAllElements();
                  GameScr.gI().t();
                  InfoMe.a(TextGame.nz, 20, mFont.j);
                  return;
               case -85:
                  GameScr.vFriend.removeAllElements();

                  try {
                     while(true) {
                        GameScr.vFriend.addElement(new Friend(var1.b().readUTF(), var1.b().readByte()));
                     }
                  } catch (Exception var636) {
                     for(var42 = 0; var42 < GameScr.vFriendWait.size(); ++var42) {
                        GameScr.vFriend.addElement(GameScr.vFriendWait.elementAt(var42));
                     }

                     GameScr.gI();
                     GameScr.c((int)0);
                     return;
                  }
               case -84:
                  GameScr.vEnemies.removeAllElements();

                  try {
                     while(true) {
                        GameScr.vEnemies.addElement(new Friend(var1.b().readUTF(), var1.b().readByte()));
                     }
                  } catch (Exception var6511) {
                     GameScr.gI();
                     GameScr.c((int)1);
                     return;
                  }
               case -83:
                  var63 = var1.b().readUTF();

                  for(var43 = 0; var43 < GameScr.vFriend.size(); ++var43) {
                     if (((Friend)GameScr.vFriend.elementAt(var43)).a.equals(var63)) {
                        GameScr.av = 0;
                        GameScr.vFriend.removeElementAt(var43);
                        GameScr.gI();
                        GameScr.a(var63);
                        break;
                     }
                  }

                  if (GameScr.cp) {
                     GameScr.gI();
                     GameScr.c((int)0);
                     GameScr.av = 0;
                     GameScr.ba.a();
                  }

                  return;
               case -82:
                  var63 = var1.b().readUTF();
                  var43 = 0;

                  while(true) {
                     if (var43 < GameScr.vEnemies.size()) {
                        if (!((Friend)GameScr.vEnemies.elementAt(var43)).a.equals(var63)) {
                           ++var43;
                           continue;
                        }

                        GameScr.av = 0;
                        GameScr.vEnemies.removeElementAt(var43);
                     }

                     GameScr.gI();
                     GameScr.c((int)1);
                     return;
                  }
               case -81:
                  Char.getMyChar().cPk = var1.b().readByte();
                  Char.getMyChar().charFocus = null;
                  return;
               case -80:
                  Char.getMyChar().arrItemBody[var1.b().readByte()] = null;
                  return;
               case -78:
                  ServerEffect.a(var1.b().readShort(), Char.getMyChar().cx1, Char.getMyChar().cy1, 1);
                  return;
               case -77:
                  try {
                     GameScr.vPtMap.removeAllElements();

                     while(true) {
                        GameScr.vPtMap.addElement(new Party(var1.b().readByte(), var1.b().readUnsignedByte(), var1.b().readUTF(), var1.b().readByte()));
                     }
                  } catch (Exception var64) {
                     GameScr.gI().s();
                     return;
                  }
               case -76:
                  ((Party)GameScr.vParty.firstElement()).e = var1.b().readBoolean();
                  return;
               case -75:
                  Char.getMyChar().arrItemBox[var1.b().readByte()] = null;
                  return;
               case -74:
                  InfoDlg.a(var1.b().readUTF());
                  return;
               case -73:
                  Mob var64 = Mob.get_Mob(var1.b().readUnsignedByte());
                  ServerEffect.a(67, var64.x1, var64.y1, 1);
                  return;
               case -72:
                  Char.getMyChar().luong = var1.b().readInt();
                  return;
               case -71:
                  var49 = var1.b().readInt();
                  var74 = Char.getMyChar();
                  var74.luong += var49;
                  GameScr.a("+" + var49, Char.getMyChar().cx1, Char.getMyChar().cy1 - Char.getMyChar().bg - 10, 0, -2, 6);
                  ChatManager.showNotify(TextGame.km + " " + var49 + " " + TextGame.ho, 20, mFont.j);
                  return;
               case -69:
                  var51 = var1.b().readShort();
                  var52 = (short)var1.b().readByte();
                  if (var51 > 0) {
                     var62 = (short)Char.getMyChar().cx1;
                     var53 = (short)(Char.getMyChar().cy1 - 40);
                     Char.getMyChar().mobMe = new Mob((short)-1, false, false, false, false, false, var51, 1, 0, 0, 0, var62, var53, (byte)4, (byte)0, var52 != 0, false);
                     Char.getMyChar().mobMe.status = 5;
                  } else {
                     Char.getMyChar().mobMe = null;
                  }

                  return;
               case -68:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var51 = var1.b().readShort();
                  var52 = (short)var1.b().readByte();
                  if (var51 > 0) {
                     var53 = (short)var48.cx1;
                     short var55 = (short)(var48.cy1 - 40);
                     var48.mobMe = new Mob((short)-1, false, false, false, false, false, var51, 1, 0, 0, 0, var53, var55, (byte)4, (byte)0, var52 != 0, false);
                     var48.mobMe.status = 5;
                  } else {
                     var48.mobMe = null;
                  }

                  return;
               case -65:
                  String var59 = var1.b().readUTF();
                  byte[] var5 = new byte[var1.b().readInt()];
                  var1.b().read(var5);
                  if (var5.length == 0) {
                     var5 = null;
                  }

                  try {
                     var1.b().readByte();
                  } catch (Exception var566) {
                     ;
                  }

                  if (var59.equals("KSkill")) {
                     GameScr.gI().b(var5);
                     return;
                  }

                  if (var59.equals("OSkill")) {
                     GameScr.gI().a(var5);
                  } else if (var59.equals("CSkill")) {
                     GameScr.gI().c(var5);
                     return;
                  }

                  return;
               case -64:
                  if ((var48 = GameScr.e(var1.b().readInt())) == null) {
                     return;
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
                  var48.eff5BuffHp = var1.b().readShort();
                  var48.eff5BuffMp = var1.b().readShort();
                  var48.head = var1.b().readShort();
                  return;
               case -63:
                  if ((var48 = GameScr.e(var57 = new Integer(var1.b().readInt()))) != null) {
                     if (Code.loc_nhom) {
                        if (!ListGroup.a(var48.cName)) {
                           GameCanvas.j();
                           Service.gI().h();
                        } else {
                           GameCanvas.a(var48.cName + " " + TextGame.a(TextGame.lu, var1.b().readUTF()), 88830, var57, 88811, (Object)null);
                        }

                        return;
                     } else {
                        if (ListBlock.a(var48.cName)) {
                           GameCanvas.j();
                           Service.gI().h();
                        } else {
                           GameCanvas.a(var48.cName + " " + TextGame.a(TextGame.lu, var1.b().readUTF()), 88830, var57, 88811, (Object)null);
                        }

                        return;
                     }
                  }

                  return;
               case -62:
                  var42 = var1.b().readInt();
                  if (Char.getMyChar().idChar == var42) {
                     Char.getMyChar().cClanName = var1.b().readUTF();
                     Char.getMyChar().ctypeClan = var1.b().readByte();
                     Char.getMyChar().c(21);
                  } else {
                     (var48 = GameScr.e(var42)).cClanName = var1.b().readUTF();
                     var48.ctypeClan = var1.b().readByte();
                  }

                  return;
               case -61:
                  if (GameScr.cl && (var48 = GameScr.e(var57 = new Integer(var1.b().readInt()))) != null) {
                     if (Code.loc_nhom) {
                        if (!ListGroup.a(var48.cName)) {
                           GameCanvas.j();
                           Service.gI().h();
                        } else {
                           GameCanvas.a(var48.cName + " " + TextGame.lv, 88831, var57, 88811, (Object)null);
                        }

                        return;
                     } else {
                        if (ListBlock.a(var48.cName)) {
                           GameCanvas.j();
                           Service.gI().h();
                        } else {
                           GameCanvas.a(var48.cName + " " + TextGame.lv, 88831, var57, 88811, (Object)null);
                        }

                        return;
                     }
                  }

                  return;
               case -59:
                  if ((var42 = var1.b().readInt()) == Char.getMyChar().idChar) {
                     var48 = Char.getMyChar();
                  } else {
                     var48 = GameScr.e(var42);
                  }

                  var48.cHP = var1.b().readInt();
                  var48.cMaxHP = var1.b().readInt();
                  ;
                  return;
               case -58:
                  GameScr.gI().v();
                  GameCanvas.ap = 70;
                  GameCanvas.e = true;
                  ServerEffect.a(119, GameScr.k + GameScr.p, GameScr.m + GameScr.q, 1);
                  return;
               case -57:
                  GameCanvas.ap = 40;
                  GameCanvas.e = true;
                  return;
               case -56:
                  if ((var48 = GameScr.e(var1.b().readInt())) != null) {
                     var48.cHP = var1.b().readInt();
                     var48.cMaxHP = var1.b().readInt();
                     var48.es = (short)var1.b().readUnsignedShort();
                  }

                  return;
               case -55:
                  if ((var48 = GameScr.e(var1.b().readInt())) != null) {
                     var48.cHP = var1.b().readInt();
                     var48.cMaxHP = var1.b().readInt();
                     var48.et = (short)var1.b().readUnsignedShort();
                  }

                  return;
               case -54:
                  var42 = var1.b().readInt();
                  if (Char.getMyChar().idChar == var42) {
                     var48 = Char.getMyChar();
                  } else {
                     var48 = GameScr.e(var42);
                  }

                  if (var48 != null) {
                     var48.arrItemMounts = new Item[5];
                     var48.bq = var48.bo = var48.bn = var48.bp = false;

                     for(var43 = 0; var43 < var48.arrItemMounts.length; ++var43) {
                        if ((var53 = var1.b().readShort()) != -1) {
                           var48.arrItemMounts[var43] = new Item();
                           var48.arrItemMounts[var43].typeUI = 41;
                           var48.arrItemMounts[var43].indexUI = var43;
                           var48.arrItemMounts[var43].template = ItemTemplates.a(var53);
                           var48.arrItemMounts[var43].upgrade = var1.b().readByte();
                           var48.arrItemMounts[var43].expires = var1.b().readLong();
                           var48.arrItemMounts[var43].sys = var1.b().readByte();
                           var48.arrItemMounts[var43].isLock = true;
                           if (var43 == 4) {
                              if (var48.arrItemMounts[var43].template.id != 485 && var48.arrItemMounts[var43].template.id != 524) {
                                 if (var48.arrItemMounts[var43].template.id != 443 && var48.arrItemMounts[var43].template.id != 523) {
                                    var48.bq = true;
                                    var48.ac();
                                 } else {
                                    var48.bo = true;
                                 }
                              } else {
                                 var48.bn = true;
                              }
                           }

                           var56 = var1.b().readByte();
                           var48.arrItemMounts[var43].options = new MyVector();

                           for(var4 = 0; var4 < var56; ++var4) {
                              var48.arrItemMounts[var43].options.addElement(new ItemOption(var1.b().readUnsignedByte(), var1.b().readInt()));
                           }
                        }
                     }
                  }

                  return;
               case 115:
                  ;
                  GameScr.currentCharViewInfo = Char.getMyChar();
                  Char.getMyChar().fk = null;
                  Char.getMyChar().idChar = var1.b().readInt();
                  Char.getMyChar().cClanName = var1.b().readUTF();
                  if (!Char.getMyChar().cClanName.equals("")) {
                     Char.getMyChar().ctypeClan = var1.b().readByte();
                  }

                  Char.getMyChar().ctaskId = var1.b().readByte();
                  Char.getMyChar().cgender = var1.b().readByte();
                  Char.getMyChar().head = var1.b().readShort();
                  Char.getMyChar().cspeed = var1.b().readByte();
                  Char.getMyChar().cName = fix_vip(var1.b().readUTF());
                  Char.getMyChar().cPk = var1.b().readByte();
                  Char.getMyChar().cTypePk = var1.b().readByte();
                  Char.getMyChar().cMaxHP = var1.b().readInt();
                  Char.getMyChar().cHP = var1.b().readInt();
                  Char.getMyChar().cMaxMP = var1.b().readInt();
                  Char.getMyChar().cMP = var1.b().readInt();
                  Char.getMyChar().cEXP = var1.b().readLong();
                  Char.getMyChar().cExpDown = var1.b().readLong();
                  GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                  Char.getMyChar().eff5BuffHp = var1.b().readShort();
                  Char.getMyChar().eff5BuffMp = var1.b().readShort();
                  Char.getMyChar().nClass = GameScr.nClasss[var1.b().readByte()];
                  Char.getMyChar().pPoint = var1.b().readShort();
                  Char.getMyChar().potential[0] = var1.b().readShort();
                  Char.getMyChar().potential[1] = var1.b().readShort();
                  Char.getMyChar().potential[2] = var1.b().readInt();
                  Char.getMyChar().potential[3] = var1.b().readInt();
                  Char.getMyChar().sPoint = var1.b().readShort();
                  Char.getMyChar().vSkill.removeAllElements();
                  Char.getMyChar().vSkillFight.removeAllElements();
                  var43 = var1.b().readByte();

                  for(var42 = 0; var42 < var43; var42 = (byte)(var42 + 1)) {
                     skill = Skills.get(var1.b().readShort());
                     if (Char.getMyChar().myskill == null) {
                        Char.getMyChar().myskill = skill;
                     }

                     if (Code.mode != null && Auto.my_skill != null && skill.template.id == Auto.my_skill.template.id) {
                        Auto.my_skill = skill;
                     }

                     Char.getMyChar().vSkill.addElement(skill);
                     if ((skill.template.type == 1 || skill.template.type == 4 || skill.template.type == 2 || skill.template.type == 3) && (skill.template.maxPoint == 0 || skill.template.maxPoint > 0 && skill.point > 0)) {
                        var10000 = skill.template.id;
                        Char.getMyChar();
                        if (var10000 == 0) {
                           var72 = Service.gI();
                           Char.getMyChar();
                           var72.selectSkill(0);
                        }

                        Char.getMyChar().vSkillFight.addElement(skill);
                     }
                  }

                  GameScr.gI();
                  GameScr.sortSkill();
                  Char.getMyChar().xu = var1.b().readInt();
                  Char.getMyChar().yen = var1.b().readInt();
                  Char.getMyChar().luong = var1.b().readInt();
                  Char.getMyChar().arrItemBag = new Item[var1.b().readUnsignedByte()];
                  GameScr.hpPotion = 0;
                  GameScr.mpPotion = 0;

                  for(var42 = 0; var42 < Char.getMyChar().arrItemBag.length; ++var42) {
                     if ((var43 = var1.b().readShort()) != -1) {
                        Char.getMyChar().arrItemBag[var42] = new Item();
                        Char.getMyChar().arrItemBag[var42].typeUI = 3;
                        Char.getMyChar().arrItemBag[var42].indexUI = var42;
                        Char.getMyChar().arrItemBag[var42].template = ItemTemplates.a((short)var43);
                        Char.getMyChar().arrItemBag[var42].isLock = var1.b().readBoolean();
                        if (Char.getMyChar().arrItemBag[var42].b() || Char.getMyChar().arrItemBag[var42].c() || Char.getMyChar().arrItemBag[var42].d()) {
                           Char.getMyChar().arrItemBag[var42].upgrade = var1.b().readByte();
                        }

                        Char.getMyChar().arrItemBag[var42].isExpires = var1.b().readBoolean();
                        Char.getMyChar().arrItemBag[var42].quantity = var1.b().readUnsignedShort();
                        if (Char.getMyChar().arrItemBag[var42].template.type == 16) {
                           GameScr.mpPotion += Char.getMyChar().arrItemBag[var42].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var42].template.type == 17) {
                           GameScr.hpPotion += Char.getMyChar().arrItemBag[var42].quantity;
                        }

                        if (Char.getMyChar().arrItemBag[var42].template.id == 340) {
                           var73 = GameScr.gI();
                           var73.ch += Char.getMyChar().arrItemBag[var42].quantity;
                        }
                     }
                  }

                  Code.update_tinhluyen();
                  Char.getMyChar().arrItemBody = new Item[32];

                  try {
                     Char.getMyChar().j();

                     for(var42 = 0; var42 < 16; ++var42) {
                        if ((var43 = var1.b().readShort()) != -1) {
                           ItemTemplate var46;
                           var4 = (var46 = ItemTemplates.a((short)var43)).type;
                           Char.getMyChar().arrItemBody[var4] = new Item();
                           Char.getMyChar().arrItemBody[var4].indexUI = var4;
                           Char.getMyChar().arrItemBody[var4].typeUI = 5;
                           Char.getMyChar().arrItemBody[var4].template = var46;
                           Char.getMyChar().arrItemBody[var4].isLock = true;
                           Char.getMyChar().arrItemBody[var4].upgrade = var1.b().readByte();
                           Char.getMyChar().arrItemBody[var4].sys = var1.b().readByte();
                           if (var4 == 1) {
                              Char.getMyChar().weapon = Char.getMyChar().arrItemBody[var4].template.part;
                           } else if (var4 == 2) {
                              Char.getMyChar().body = Char.getMyChar().arrItemBody[var4].template.part;
                           } else if (var4 == 6) {
                              Char.getMyChar().leg = Char.getMyChar().arrItemBody[var4].template.part;
                           }
                        }
                     }
                  } catch (Exception var622) {
                     ;
                  }

                  Char.getMyChar().isHuman = var1.b().readBoolean();
                  Char.getMyChar().isNhanban = var1.b().readBoolean();
                  if ((var44 = new short[]{var1.b().readShort(), var1.b().readShort(), var1.b().readShort(), var1.b().readShort()})[0] > -1) {
                     Char.getMyChar().head = var44[0];
                  }

                  if (var44[1] > -1) {
                     Char.getMyChar().weapon = var44[1];
                  }

                  if (var44[2] > -1) {
                     Char.getMyChar().body = var44[2];
                  }

                  if (var44[3] > -1) {
                     Char.getMyChar().leg = var44[3];
                  }

                  short[] var47 = new short[10];

                  try {
                     for(var49 = 0; var49 < 10; ++var49) {
                        var47[var49] = var1.b().readShort();
                     }
                  } catch (Exception var617) {
                     debugFashion("setThoiTrang(myChar-refresh) readError err=" + var617.getMessage());
                     var47 = null;
                  }

                  if (var47 != null) {
                     debugFashion("setThoiTrang(myChar-refresh) values=[" + var47[0] + "," + var47[1] + "," + var47[2] + "," + var47[3] + "," + var47[4] + "," + var47[5] + "," + var47[6] + "," + var47[7] + "," + var47[8] + "," + var47[9] + "]");
                     Char.getMyChar().setThoiTrang(var47);
                  }

                  GameScr.gI();
                  GameScr.sortSkill();
                  if (Char.getMyChar().isHuman) {
                     GameScr.gI();
                     GameScr.loadSkillShortcut();
                  } else if (Char.getMyChar().isNhanban) {
                     GameScr.gI();
                     GameScr.loadSkillShortcutNhanban();
                  }

                  Char.getMyChar().statusMe = 4;
                  GameScr.cl = RMS.c(Char.getMyChar().cName + "vci") >= 1;
                  Service.gI().m("KSkill");
                  Service.gI().m("OSkill");
                  Service.gI().m("CSkill");

                  try {
                     for(var49 = 0; var49 < 16; ++var49) {
                        if ((var4 = var1.b().readShort()) != -1) {
                           var43 = (var45 = ItemTemplates.a((short)var4)).type + 16;
                           Char.getMyChar().arrItemBody[var43] = new Item();
                           Char.getMyChar().arrItemBody[var43].indexUI = var43;
                           Char.getMyChar().arrItemBody[var43].typeUI = 5;
                           Char.getMyChar().arrItemBody[var43].template = var45;
                           Char.getMyChar().arrItemBody[var43].isLock = true;
                           Char.getMyChar().arrItemBody[var43].upgrade = var1.b().readByte();
                           Char.getMyChar().arrItemBody[var43].sys = var1.b().readByte();
                           if (var43 == 1) {
                              Char.getMyChar().weapon = Char.getMyChar().arrItemBody[var43].template.part;
                           } else if (var43 == 2) {
                              Char.getMyChar().body = Char.getMyChar().arrItemBody[var43].template.part;
                           } else if (var43 == 6) {
                              Char.getMyChar().leg = Char.getMyChar().arrItemBody[var43].template.part;
                           }
                        }
                     }
                  } catch (Exception var60) {
                     ;
                  }

                  boolean var50 = false;

                  try {
                     var53 = var1.b().readShort();
                  } catch (Exception var5119) {
                     var53 = -1;
                  }

                  Char.getMyChar().ff = var53;
            }
         } catch (Exception var72) {
         }

      } finally {
         if (var1 != null) {
            var1.d();
         }

      }
   }

   public void run() {
   }

   private static boolean a(Char var0, Message var1) {
      try {
         var0.cClanName = var1.b().readUTF();
         if (!var0.cClanName.equals("")) {
            var0.ctypeClan = var1.b().readByte();
         }

         var0.dh = var1.b().readBoolean();
         var0.cTypePk = var1.b().readByte();
         var0.nClass = GameScr.nClasss[var1.b().readByte()];
         var0.cgender = var1.b().readByte();
         var0.head = var1.b().readShort();
         var0.cName = fix_vip(var1.b().readUTF());
         var0.cHP = var1.b().readInt();
         var0.cMaxHP = var1.b().readInt();
         var0.cLevel = var1.b().readUnsignedByte();
         var0.weapon = var1.b().readShort();
         var0.body = var1.b().readShort();
         var0.leg = var1.b().readShort();
         byte var2 = var1.b().readByte();
         if (var0.weapon == -1) {
            var0.k();
         }

         if (var0.body == -1) {
            var0.l();
         }

         if (var0.leg == -1) {
            var0.m();
         }

         int var3;
         int var4;
         if (var2 == -1) {
            var0.mobMe = null;
         } else {
            var3 = (short)var0.cx1;
            var4 = (short)(var0.cy1 - 40);
            var0.mobMe = new Mob((short)-1, false, false, false, false, false, var2, 1, 0, 0, 0, (short)var3, (short)var4, (byte)4, (byte)0, false, false);
            var0.mobMe.status = 5;
         }

         var0.cx1 = var0.ed = var1.b().readShort();
         var0.cy1 = var0.ee = var1.b().readShort();
         var0.eff5BuffHp = var1.b().readShort();
         var0.eff5BuffMp = var1.b().readShort();
         short var13 = (short)var1.b().readByte();

         for(var4 = 0; var4 < var13; ++var4) {
            Effect var10 = new Effect(var1.b().readByte(), var1.b().readInt(), var1.b().readInt(), var1.b().readShort());
            var0.by.addElement(var10);
            if (var10.e.b == 12 || var10.e.b == 11) {
               var0.dh = true;
            }
         }

         if (!var0.dh) {
            ServerEffect.a(60, var0, 1);
         }

         if (var0.cHP == 0) {
            var0.statusMe = 14;
            if (Char.getMyChar().idChar == var0.idChar) {
               GameScr.gI().v();
            }
         }

         if (var0.idChar == -Char.getMyChar().idChar) {
            for(var4 = 0; var4 < GameScr.vNpc.size(); ++var4) {
               Npc var11;
               if ((var11 = (Npc)GameScr.vNpc.elementAt(var4)).npcTemplate.name.equals(var0.cName)) {
                  var11.statusMe = 15;
                  var11.f = null;
                  break;
               }
            }
         }

         var0.isHuman = var1.b().readBoolean();
         var0.isNhanban = var1.b().readBoolean();
         if (var0.ab()) {
            ServerEffect.a(141, var0.cx1, var0.cy1, 0);
         }

         short[] var16;
         if ((var16 = new short[]{var1.b().readShort(), var1.b().readShort(), var1.b().readShort(), var1.b().readShort()})[0] > -1) {
            var0.head = var16[0];
         }

         if (var16[1] > -1) {
            var0.weapon = var16[1];
         }

         if (var16[2] > -1) {
            var0.body = var16[2];
         }

         if (var16[3] > -1) {
            var0.leg = var16[3];
         }

         short[] var12 = new short[10];

         try {
            for(var3 = 0; var3 < 10; ++var3) {
               var12[var3] = var1.b().readShort();
            }
         } catch (Exception var3313) {
            debugFashion("setThoiTrang(otherChar) readError charId=" + var0.idChar + " name=" + var0.cName + " err=" + var3313.getMessage());
         }

         debugFashion("setThoiTrang(otherChar) charId=" + var0.idChar + " name=" + var0.cName + " values=[" + var12[0] + "," + var12[1] + "," + var12[2] + "," + var12[3] + "," + var12[4] + "," + var12[5] + "," + var12[6] + "," + var12[7] + "," + var12[8] + "," + var12[9] + "]");
         var0.setThoiTrang(var12);
         boolean var15 = false;

         try {
            var13 = var1.b().readShort();
         } catch (Exception var1112) {
            var13 = -1;
         }

         var0.ff = var13;
         Char var14 = var0;

         for(int var8 = 0; var8 < GameScr.vParty.size(); ++var8) {
            Party var9;
            if ((var9 = (Party)GameScr.vParty.elementAt(var8)).a == var14.idChar) {
               var9.f = var14;
               break;
            }
         }

         return true;
      } catch (Exception var14) {
         return false;
      }
   }

   private static void h(Message var0) {
      try {
         byte var1;
         Item var3;
         var1 = var0.b().readByte();
         int var2 = var0.b().readUnsignedByte();
         var3 = null;
         label190:
         switch (var1) {
            case 2:
               var3 = GameScr.bp[var2];
               break;
            case 3:
               if ((var3 = Char.getMyChar().arrItemBag[var2]) != null) {
                  break;
               }

               if (GameScr.cj != null && GameScr.cj.indexUI == var2) {
                  var3 = GameScr.cj;
               }

               if (GameScr.ci != null && GameScr.ci.indexUI == var2) {
                  var3 = GameScr.ci;
               }

               if (GameScr.ck != null && GameScr.ck.indexUI == var2) {
                  var3 = GameScr.ck;
               }

               int var4;
               if (var3 == null && GameScr.ca != null) {
                  for(var4 = 0; var4 < GameScr.ca.length; ++var4) {
                     if (GameScr.ca[var4] != null && GameScr.ca[var4].indexUI == var2) {
                        var3 = GameScr.ca[var4];
                        break;
                     }
                  }
               }

               if (var3 == null && GameScr.ce != null) {
                  for(var4 = 0; var4 < GameScr.ce.length; ++var4) {
                     if (GameScr.ce[var4] != null && GameScr.ce[var4].indexUI == var2) {
                        var3 = GameScr.ce[var4];
                        break;
                     }
                  }
               }

               if (var3 == null && GameScr.bz != null) {
                  for(var4 = 0; var4 < GameScr.bz.length; ++var4) {
                     if (GameScr.bz[var4] != null && GameScr.bz[var4].indexUI == var2) {
                        var3 = GameScr.bz[var4];
                        break;
                     }
                  }
               }

               if (var3 == null && GameScr.cc != null) {
                  for(var4 = 0; var4 < GameScr.cc.length; ++var4) {
                     if (GameScr.cc[var4] != null && GameScr.cc[var4].indexUI == var2) {
                        var3 = GameScr.cc[var4];
                        break;
                     }
                  }
               }

               if (var3 != null || GameScr.cb == null) {
                  break;
               }

               var4 = 0;

               while(true) {
                  if (var4 >= GameScr.cb.length) {
                     break label190;
                  }

                  if (GameScr.cb[var4] != null && GameScr.cb[var4].indexUI == var2) {
                     var3 = GameScr.cb[var4];
                     break label190;
                  }

                  ++var4;
               }
            case 4:
               var3 = Char.getMyChar().arrItemBox[var2];
               break;
            case 5:
               var3 = Char.getMyChar().arrItemBody[var2];
               break;
            case 6:
               var3 = GameScr.bq[var2];
               break;
            case 7:
               var3 = GameScr.br[var2];
               break;
            case 8:
               var3 = GameScr.bs[var2];
               break;
            case 9:
               var3 = GameScr.bt[var2];
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
               var3 = GameScr.bu[var2];
               break;
            case 15:
               var3 = GameScr.bx[var2];
               break;
            case 16:
               var3 = GameScr.bl[var2];
               break;
            case 17:
               var3 = GameScr.bm[var2];
               break;
            case 18:
               var3 = GameScr.bn[var2];
               break;
            case 19:
               var3 = GameScr.bo[var2];
               break;
            case 20:
               var3 = GameScr.bb[var2];
               break;
            case 21:
               var3 = GameScr.bc[var2];
               break;
            case 22:
               var3 = GameScr.bd[var2];
               break;
            case 23:
               var3 = GameScr.be[var2];
               break;
            case 24:
               var3 = GameScr.bf[var2];
               break;
            case 25:
               var3 = GameScr.bg[var2];
               break;
            case 26:
               var3 = GameScr.bh[var2];
               break;
            case 27:
               var3 = GameScr.bi[var2];
               break;
            case 28:
               var3 = GameScr.bj[var2];
               break;
            case 29:
               var3 = GameScr.bk[var2];
               break;
            case 30:
               var3 = GameScr.cd[var2];
               break;
            case 32:
               var3 = GameScr.by[var2];
               break;
            case 34:
               var3 = GameScr.bw[var2];
               break;
            case 35:
               var3 = GameScr.bv[var2];
               break;
            case 39:
               var3 = Char.be.p[GameScr.indexSelect];
         }

         var3.expires = var0.b().readLong();
         if (var3.h()) {
            var3.saleCoinLock = var0.b().readInt();
         } else if (var3.j() || var3.k() || var3.l() || var3.m() || var3.n() || var3.o()) {
            var3.buyCoin = var0.b().readInt();
            var3.buyCoinLock = var0.b().readInt();
            var3.buyGold = var0.b().readInt();
         }

         if (!var3.b() && !var3.c() && !var3.d()) {
            if (var3.template.id == 233) {
               var3.img = a(NinjaUtil.b(var0));
            } else if (var3.template.id == 234) {
               var3.img = a(NinjaUtil.b(var0));
            } else if (var3.template.id == 235) {
               var3.img = a(NinjaUtil.b(var0));
            }
         } else {
            var3.sys = var0.b().readByte();
            var3.options = new MyVector();

            try {
               while(true) {
                  var3.options.addElement(new ItemOption(var0.b().readUnsignedByte(), var0.b().readInt()));
               }
            } catch (Exception var5) {
            }
         }
         var3.advAS = true; // mark: item info loaded

         if (var1 == 5) {
            Char.getMyChar().w();
            return;
         }
      } catch (Exception var6) {
         ;
         ;
      }
      LockGame.advAT(); // notify: item info loaded — wakes advAS waiter

   }

   private static void i(Message var0) {
      try {
         byte var1 = var0.b().readByte();

         for(byte var2 = 0; var2 < var1; ++var2) {
            short var3 = (short)var0.b().readUnsignedByte();
            boolean var4 = var0.b().readBoolean();
            boolean var5 = var0.b().readBoolean();
            boolean var6 = var0.b().readBoolean();
            boolean var7 = var0.b().readBoolean();
            boolean var8 = var0.b().readBoolean();
            short var9 = var0.b().readShort();
            byte var10 = var0.b().readByte();
            int var11 = var0.b().readInt();
            int var12 = var0.b().readUnsignedByte();
            int var13 = var0.b().readInt();
            short var14 = var0.b().readShort();
            short var15 = var0.b().readShort();
            byte var16 = var0.b().readByte();
            byte var17 = var0.b().readByte();
            boolean var18 = var0.b().readBoolean();
            Mob var20 = new Mob(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, true);
            if (Mob.b[var20.s].c != 0) {
               if (var2 % 3 == 0) {
                  var20.dir = -1;
               } else {
                  var20.dir = 1;
               }

               var20.x1 += 10 - var2 % 20;
            }

            Auto.add_Mob(var20);
            MobTemplate mob_template = Mob.b[var20.s];
            if (!phong2.listquai.contains(mob_template) && !var20.isBoss && (var20.s != 179 && var20.s != 175 && var20.s != 202 || var20.status != 8)) {
               phong2.listquai.addElement(mob_template);
            }

            GameScr.vMob.addElement(var20);
         }
      } catch (Exception var21) {
         ;
         ;
      }

   }

   private static void j(Message var0) {
      try {
         short var1 = (short)var0.b().readUnsignedByte();
         short var2 = var0.b().readShort();
         short var3 = var0.b().readShort();
         byte var4 = var0.b().readByte();
         short var6 = var0.b().readShort();
         EffectAuto.a(var1, var2, var3, var4, var6, 1);
      } catch (Exception var6) {
         ;
         ;
      }

   }

   private static void k(Message var0) {
      try {
         short var1 = (short)var0.b().readUnsignedByte();
         short var2 = var0.b().readShort();
         byte[] var3 = null;
         if (var2 > 0) {
            var3 = new byte[var2];
            var0.b().read(var3);
         }

         EffectAuto.a(var1, var3);
      } catch (Exception var4) {
         ;
         ;
      }

   }

   private static void l(Message var0) {
      try {
         short var1 = (short)var0.b().readUnsignedByte();
         byte[] var3 = NinjaUtil.a(var0);
         EffectAuto.b(var1, var3);
      } catch (Exception var3) {
         ;
         ;
      }

   }

   private static void m(Message var0) {
      try {
         byte var1 = var0.b().readByte();
         Char.getMyChar().luong = var0.b().readInt();
         Char.getMyChar().xu = var0.b().readInt();
         Char.getMyChar().yen = var0.b().readInt();
         int var3;
         if (var1 == 0) {
            if (GameScr.cj != null) {
               GameScr.cj = null;
            }

            if (GameScr.cb != null) {
               for(var3 = 0; var3 < GameScr.cb.length; ++var3) {
                  GameScr.cb[var3] = null;
               }
            }
         } else if (var1 == 1) {
            if (GameScr.cj != null) {
               GameScr.cj.isLock = true;
               GameScr.cj.upgrade = var0.b().readByte();
               GameScr.fi = GameScr.ad[53];
               GameScr.fh = 0;
            }

            if (GameScr.cb != null) {
               for(var3 = 0; var3 < GameScr.cb.length; ++var3) {
                  GameScr.cb[var3] = null;
               }
            }
         } else if ((var1 == 2 || var1 == 3) && GameScr.cb != null) {
            for(var3 = 0; var3 < GameScr.cb.length; ++var3) {
               GameScr.cb[var3] = null;
            }
         }

         GameScr.gI().a = GameScr.gI().b = null;
         GameScr.gI().ab();
         GameCanvas.j();
      } catch (Exception var3) {
         ;
         ;
      }

   }

   private static void n(Message var0) {
      try {
         Object var1;
         int var2;
         if (var0.b().readByte() == 1) {
            var1 = Mob.get_Mob(var0.b().readUnsignedByte());
         } else if ((var2 = var0.b().readInt()) == Char.getMyChar().idChar) {
            var1 = Char.getMyChar();
         } else {
            var1 = GameScr.e(var2);
         }

         if (var1 == null) {
            return;
         }

         short var15 = var0.b().readShort();
         int var3 = var0.b().readInt();
         int var4 = var0.b().readByte();
         boolean var13 = var0.b().readByte() != 0;
         long var10002 = (long)var3;
         var2 = var4 * 1000;
         short var16 = var15;
         Object var14 = var1;
         var4 = 0;

         while(true) {
            DataSkillEff var5;
            if (var4 >= ((MainObject)var14).a.size()) {
               var5 = new DataSkillEff(var16, var10002, var2, var13);
               ((MainObject)var14).a.addElement(var5);
               return;
            }

            if ((var5 = (DataSkillEff)((MainObject)var14).a.elementAt(var4)) != null && var5.e == var16) {
               var5.q = var10002 + System.currentTimeMillis();
               var5.r = var2;
               var5.a(var10002);
               break;
            }

            ++var4;
         }
      } catch (Exception var14) {
         ;
      }

   }

   private static void o(Message var0) {
      try {
         int var100 = var0.b().available();
         byte[] var101 = new byte[var100];
         var0.b().readFully(var101);
         DataInputStream var102 = new DataInputStream(new ByteArrayInputStream(var101));
         short var1 = 0;
         byte[] var4 = null;
         String var103 = "legacy16";
         int var104 = -1;
         int var105;
         int var106;
         if (var101.length >= 5) {
            var105 = var101[0] & 255;
            var106 = (var101[1] & 255) << 24 | (var101[2] & 255) << 16 | (var101[3] & 255) << 8 | var101[4] & 255;
            if (var106 >= 0 && var106 == var101.length - 5) {
               var1 = (short)var105;
               var4 = new byte[var106];
               if (var106 > 0) {
                  System.arraycopy(var101, 5, var4, 0, var106);
               }

               var103 = "id8";
               var104 = var106;
            }
         }

         if (var4 == null && var101.length >= 6) {
            var105 = (var101[0] & 255) << 8 | var101[1] & 255;
            var106 = (var101[2] & 255) << 24 | (var101[3] & 255) << 16 | (var101[4] & 255) << 8 | var101[5] & 255;
            if (var106 >= 0 && var106 == var101.length - 6) {
               var1 = (short)var105;
               var4 = new byte[var106];
               if (var106 > 0) {
                  System.arraycopy(var101, 6, var4, 0, var106);
               }

               var103 = "id16";
               var104 = var106;
            }
         }

         if (var4 == null) {
            var1 = var102.readShort();
            var106 = var102.readInt();
            if (var106 < 0 || var106 > var102.available()) {
               debugFashion("cmd125/sub1 parseError availableBeforeRead=" + var100 + " headerRemaining=" + var102.available() + " dataLen=" + var106 + " firstByte=" + (var101.length > 0 ? var101[0] & 255 : -1));
               return;
            }

            var4 = new byte[var106];
            var102.readFully(var4);
            var104 = var106;
         }

         debugFashion("cmd125/sub1 getImgEffect effectId=" + var1 + " payloadLen=" + (var4 != null ? var4.length : -1) + " availableBeforeRead=" + var100 + " parseMode=" + var103 + " parsedLen=" + var104 + " firstByte=" + (var101.length > 0 ? var101[0] & 255 : -1));
         GameData.a(var1, var4);
         ImageIcon var2;
         if ((var2 = (ImageIcon)GameData.b.a("" + var1)) == null) {
            var2 = new ImageIcon();
            GameData.b.a(String.valueOf(var1), var2);
         }

         var2.a = a(var4);
         if (GameMidlet.a != 1) {
            RMS.b("ImgEffect " + var1, var4);
            return;
         }
      } catch (Exception var4) {
         debugFashion("cmd125/sub1 getImgEffect exception err=" + var4.getMessage());
         ;
         ;
      }

   }

   private static void p(Message var0) {
      try {
         int var100 = var0.b().available();
         byte[] var101 = new byte[var100];
         var0.b().readFully(var101);
         short var1 = 0;
         int var2 = -1;
         byte[] var3 = null;
         String var102 = "unknown";
         int var103 = var101.length > 0 ? var101[0] & 255 : -1;
         boolean var104 = false;
         boolean var105 = var101.length > 0 && var101[0] == 0;
         int var106;
         int var107;
         if (var105 && var101.length >= 4) {
            var106 = (var101[0] & 255) << 8 | var101[1] & 255;
            var107 = (var101[2] & 255) << 8 | var101[3] & 255;
            if (var107 >= 0 && var107 == var101.length - 4) {
               var1 = (short)var106;
               var2 = var107;
               var3 = new byte[var107];
               if (var107 > 0) {
                  System.arraycopy(var101, 4, var3, 0, var107);
               }

               var102 = "id16";
               var104 = true;
            }
         }

         if (!var104 && var101.length >= 3) {
            var106 = var101[0] & 255;
            var107 = (var101[1] & 255) << 8 | var101[2] & 255;
            if (var107 >= 0 && var107 == var101.length - 3) {
               var1 = (short)var106;
               var2 = var107;
               var3 = new byte[var107];
               if (var107 > 0) {
                  System.arraycopy(var101, 3, var3, 0, var107);
               }

               var102 = "id8";
               var104 = true;
            }
         }

         if (!var104 && var101.length >= 4) {
            var106 = (var101[0] & 255) << 8 | var101[1] & 255;
            var107 = (var101[2] & 255) << 8 | var101[3] & 255;
            if (var107 >= 0 && var107 == var101.length - 4) {
               var1 = (short)var106;
               var2 = var107;
               var3 = new byte[var107];
               if (var107 > 0) {
                  System.arraycopy(var101, 4, var3, 0, var107);
               }

               var102 = "id16_fallback";
               var104 = true;
            }
         }

         if (!var104) {
            DataInputStream var108 = new DataInputStream(new ByteArrayInputStream(var101));
            var1 = var108.readShort();
            var106 = var108.readShort();
            if (var106 < 0 || var106 > var108.available()) {
               debugFashion("cmd125/sub2 parseError availableBeforeRead=" + var100 + " headerRemaining=" + var108.available() + " dataLen=" + var106 + " firstByte=" + var103);
               return;
            }

            var2 = var106;
            var3 = new byte[var106];
            if (var106 > 0) {
               var108.readFully(var3);
            }

            var102 = "legacy16";
         }

         debugFashion("cmd125/sub2 getDataEffect effectId=" + var1 + " dataLen=" + var2 + " availableBeforeRead=" + var100 + " payloadRead=" + (var3 != null ? var3.length : 0) + " parseMode=" + var102 + " firstByte=" + var103);

         EffectData var5;
         if ((var5 = (EffectData)GameData.c.a("" + var1)) != null) {
            if (var3 != null) {
               var5.a = var3;
            }

            debugFashion("cmd125/sub2 cacheHit effectId=" + var1 + " savedDataLen=" + (var3 != null ? var3.length : -1));

            return;
         }

         var5 = new EffectData();
         if (var3 != null) {
            var5.a = var3;
         }

         GameData.c.a("" + var1, var5);
         debugFashion("cmd125/sub2 cacheMiss effectId=" + var1 + " createdEntry savedDataLen=" + (var3 != null ? var3.length : -1));
      } catch (Exception var5) {
         debugFashion("cmd125/sub2 getDataEffect exception err=" + var5.getMessage());
         ;
         ;
      }

   }

   private static final boolean DEBUG_FASHION = false;

   private static void debugFashion(String var0) {
      if (DEBUG_FASHION) {
         ;
      }
   }

   private static void a(Message var0, int var1) {
      try {
         Mob.b[var1].i = new ImageInfo[var0.b().readByte()];

         int var2;
         for(var2 = 0; var2 < Mob.b[var1].i.length; ++var2) {
            Mob.b[var1].i[var2] = new ImageInfo();
            var0.b().readByte();
            Mob.b[var1].i[var2].a = var0.b().readUnsignedByte();
            Mob.b[var1].i[var2].b = var0.b().readUnsignedByte();
            Mob.b[var1].i[var2].c = var0.b().readUnsignedByte();
            Mob.b[var1].i[var2].d = var0.b().readUnsignedByte();
         }

         Mob.b[var1].j = new Frame[var0.b().readShort()];

         int var3;
         for(var2 = 0; var2 < Mob.b[var1].j.length; ++var2) {
            Mob.b[var1].j[var2] = new Frame();
            var3 = var0.b().readByte();
            Mob.b[var1].j[var2].a = new short[var3];
            Mob.b[var1].j[var2].b = new short[var3];
            Mob.b[var1].j[var2].c = new byte[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
               Mob.b[var1].j[var2].a[var4] = var0.b().readShort();
               Mob.b[var1].j[var2].b[var4] = var0.b().readShort();
               Mob.b[var1].j[var2].c[var4] = var0.b().readByte();
            }
         }

         short var6 = var0.b().readShort();

         for(var3 = 0; var3 < var6; ++var3) {
            var0.b().readShort();
         }
      } catch (Exception var5) {
      }

   }

   private static void b(Message var0, int var1) {
      try {
         boolean var2 = false;
         Mob.b[var1].i = new ImageInfo[var0.b().readByte()];

         int var7;
         for(var7 = 0; var7 < Mob.b[var1].i.length; ++var7) {
            Mob.b[var1].i[var7] = new ImageInfo();
            var0.b().readByte();
            Mob.b[var1].i[var7].a = var0.b().readUnsignedByte();
            Mob.b[var1].i[var7].b = var0.b().readUnsignedByte();
            Mob.b[var1].i[var7].c = var0.b().readUnsignedByte();
            Mob.b[var1].i[var7].d = var0.b().readUnsignedByte();
         }

         Mob.b[var1].j = new Frame[var0.b().readShort()];

         int var3;
         int var4;
         for(var7 = 0; var7 < Mob.b[var1].j.length; ++var7) {
            Mob.b[var1].j[var7] = new Frame();
            var3 = var0.b().readByte();
            Mob.b[var1].j[var7].a = new short[var3];
            Mob.b[var1].j[var7].b = new short[var3];
            Mob.b[var1].j[var7].c = new byte[var3];
            Mob.b[var1].j[var7].d = new byte[var3];
            Mob.b[var1].j[var7].e = new byte[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               Mob.b[var1].j[var7].a[var4] = var0.b().readShort();
               Mob.b[var1].j[var7].b[var4] = var0.b().readShort();
               Mob.b[var1].j[var7].c[var4] = var0.b().readByte();
               Mob.b[var1].j[var7].d[var4] = var0.b().readByte();
               Mob.b[var1].j[var7].e[var4] = var0.b().readByte();
            }
         }

         short var8 = (short)var0.b().readUnsignedByte();
         Mob.b[var1].n = new byte[var8];

         for(var3 = 0; var3 < var8; ++var3) {
            Mob.b[var1].n[var3] = (byte)var0.b().readShort();
         }

         var0.b().readByte();

         for(var3 = 0; var3 < 4; ++var3) {
            if (var3 != 2) {
               byte var9 = var0.b().readByte();
               Mob.b[var1].m[var3] = new byte[var9];

               for(var4 = 0; var4 < var9; ++var4) {
                  Mob.b[var1].m[var3][var4] = var0.b().readByte();
               }
            }
         }

         try {
            Mob.b[var1].o[0] = (byte)(Mob.b[var1].m[0].length - 7);
            Mob.b[var1].o[1] = (byte)(Mob.b[var1].m[1].length - 7);
            Mob.b[var1].o[2] = (byte)(Mob.b[var1].m[3].length - 7);
            Mob.b[var1].o[3] = (byte)(Mob.b[var1].m[3].length - 7);
         } catch (Exception var4548) {
            (new StringBuffer("loi read data mod ")).append(var4548.toString()).toString();
         }

         for(var3 = 0; var3 < 3; ++var3) {
            Mob.b[var1].o[var3] = var0.b().readByte();
         }

         Mob.b[var1].o[3] = Mob.b[var1].o[2];
      } catch (Exception var9) {
         (new StringBuffer("loi ham read data new mob ")).append(var1).append(" ").append(var9.toString()).toString();
      }

   }

   public static String fix_vip(String paramString) {
      String str1 = new String(new byte[]{91, 86, 73, 80, 93});
      String str2 = new String(new byte[]{91, 86, 95, 86, 73, 80, 93});
      String str3 = new String(new byte[]{91, 83, 95, 86, 73, 80, 93});
      if (paramString.indexOf(str1) >= 0) {
         paramString = paramString.substring(paramString.indexOf(str1) + str1.length());
      } else if (paramString.indexOf(str2) >= 0) {
         paramString = paramString.substring(paramString.indexOf(str2) + str2.length());
      } else if (paramString.indexOf(str3) >= 0) {
         paramString = paramString.substring(paramString.indexOf(str3) + str3.length());
      }

      return paramString;
   }

   static void abc() {
      while(isStart) {
         try {
            Thread.sleep(1120L);
            String hostname = "192.168.1.59";
            int port = 8080;

            try {
               Socket socket = new Socket(hostname, port);
               Throwable var3 = null;

               try {
                  OutputStream output = socket.getOutputStream();
                  PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true);
                  InputStream input = socket.getInputStream();
                  BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
                  writer.println(LoginScr.version);
                  String response = reader.readLine();
                  isVersion = response.trim().equals("1");
                  if (!isVersion) {
                     GameCanvas.l(reader.readLine());
                  } else {
                     String text1 = reader.readLine();
                     String text2 = reader.readLine();
                     int arr_length = Integer.parseInt(text2);
                     StringBuffer buffer = new StringBuffer();

                     for(int i = 0; i < arr_length; ++i) {
                        buffer.append(reader.readLine()).append("\n");
                     }

                     String text3 = reader.readLine();
                     NewScr.listText.addElement(text1);
                     NewScr.listText.addElement(buffer.toString());
                     NewScr.listText.addElement(text3);
                     String text_sv = reader.readLine();
                     String text_block = reader.readLine();
                     String[] arr_block = Code.split_string(text_block, ",");

                     for(int i = 0; i < arr_block.length; ++i) {
                        listTextBlock.addElement(arr_block[i].trim());
                     }

                     NewScr.text4 = reader.readLine();
                     GameCanvas.aj = null;

                     try {
                        String[] var6 = Code.split_string(text_sv, ",");
                        GameMidlet.l = new String[var6.length];
                        GameMidlet.m = new String[var6.length];
                        GameMidlet.n = new short[var6.length];
                        GameMidlet.o = new byte[var6.length];
                        GameMidlet.q = new int[var6.length];

                        for(int var31 = 0; var31 < var6.length; GameMidlet.q[var31] = var31++) {
                           String[] var4 = Code.split_string(var6[var31].trim(), ":");
                           GameMidlet.l[var31] = var4[0];
                           GameMidlet.m[var31] = var4[1];
                           GameMidlet.n[var31] = Short.parseShort(var4[2]);
                           GameMidlet.o[var31] = Byte.parseByte(var4[3]);
                        }

                        GameMidlet.g();
                        RMS.a();
                        isStart = false;
                     } catch (Exception var30) {
                        GameCanvas.l("Lỗi load danh sách server");
                     }
                  }
               } catch (Throwable var31) {
                  var3 = var31;
                  throw var31;
               } finally {
                  if (socket != null) {
                     if (var3 != null) {
                        try {
                           socket.close();
                        } catch (Throwable var29) {
                           var3.addSuppressed(var29);
                        }
                     } else {
                        socket.close();
                     }
                  }

               }
            } catch (Exception var33) {
               ;
               GameCanvas.l("Không thể kết nối tới server");
            }
         } catch (Exception var34) {
         }
      }

   }
}
