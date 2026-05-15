package base.game1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class phong {
   private static Object aa = new Object();
   public static boolean isDisconnect = false;
   private static Thread reloginThread;
   private static String reloginCharName = "";
   public static boolean enableLog = false;

   public static void initLog() {
      if (!enableLog) return;
      try {
         PrintStream ps = new PrintStream(new FileOutputStream("log.txt"), true, "UTF-8");
         System.setOut(ps);
         System.setErr(ps);
      } catch (Exception e) {
      }
   }
   public static MyVector textBan = new MyVector();
   public static TField tField;

   public static Char CharInMap(String ingame) {
      for(int var26 = 0; var26 < GameScr.vCharInMap.size(); ++var26) {
         Char var23 = (Char)GameScr.vCharInMap.elementAt(var26);
         if (var23.cName.equals(ingame)) {
            return var23;
         }
      }

      return null;
   }

   public static void CharFocus(Char var0) {
      Char.getMyChar().mobFocus = null;
      Char.getMyChar().v();
      Char.getMyChar().itemFocus = null;
      Char.getMyChar();
      Char.fg = true;
      Char.getMyChar().charFocus = var0;
   }

   public static boolean changeBoolean(boolean var0, String var1, String name_save) {
      if (var0) {
         RMS.a(name_save, -1);
         Code.popup_chat("Tắt " + var1);
      } else {
         RMS.a(name_save, 1);
         Code.popup_chat("Bật " + var1);
      }

      return !var0;
   }

   public static void scheduleRelogin() {
      start_relogin();
   }

   static void start_relogin() {
      cacheReloginCharName();
      // P2 A1#5: g5 cross-check truoc relogin — fail thi return KHONG relogin.
      if (com.monkey.nso.LicenseGuard.isVerifyStarted() && !com.monkey.nso.LicenseGuard.g5()) {
         return;
      }
      if (GameCanvas.currentScreen != GameCanvas.ag) {
         GameCanvas.instance.kobiet();
      }

      isDisconnect = true;
      if (reloginThread != null && reloginThread.isAlive()) {
         
         e();
      } else {
         
         reloginThread = new Thread(new Relogin());
         reloginThread.start();
      }

   }

   private static void cacheReloginCharName() {
      try {
         if (SelectCharScr.ig_login != null && SelectCharScr.ig_login.length() > 0) {
            reloginCharName = SelectCharScr.ig_login;
            return;
         }

         Char me = Char.getMyChar();
         if (me != null && me.cName != null && me.cName.length() > 0) {
            reloginCharName = me.cName;
            SelectCharScr.ig_login = reloginCharName;
         }
      } catch (Exception e) {
      }
   }

   public static String getReloginCharName() {
      if (SelectCharScr.ig_login != null && SelectCharScr.ig_login.length() > 0) {
         return SelectCharScr.ig_login;
      }
      return reloginCharName;
   }

   public static void onDisconnect() {
      try {
         com.monkey.nso.ClientErrorReporter.report("runtime", "SERVER_KICK",
                 com.monkey.nso.ClientErrorReporter.ctx(
                         "reconnect", new Boolean(Code.mode != null && Char.reconnect),
                         "giuKetNoi", new Boolean(Code.giuKetNoi)));
      } catch (Throwable t) {}
      if ((Code.mode != null && Char.reconnect) || Code.giuKetNoi) {

         Relogin.time[0] = -1;
         start_relogin();
      } else {
         GameCanvas.instance.n();
      }

   }

   public static void sleep(long l) {
      try {
         Thread.sleep(l);
      } catch (Exception var3) {
      }

   }

   public static int Str2int(String var0) {
      try {
         return Integer.parseInt(var0);
      } catch (Exception var2) {
         return -1;
      }
   }

   public static void e() {
      synchronized(aa) {
         aa.notifyAll();
      }
   }

   static void a(long var0) {
      synchronized(aa) {
         try {
            aa.wait(var0);
         } catch (Exception var5) {
         }

      }
   }

   public static boolean checkItemExist(int id) {
      for(int var3 = 0; var3 < GameScr.vItemMap.size(); ++var3) {
         ItemMap var6 = (ItemMap)GameScr.vItemMap.elementAt(var3);
         if (var6 != null && var6.template.id == id) {
            return true;
         }
      }

      return false;
   }

   public static void save_auto() {
      ByteArrayOutputStream var0 = new ByteArrayOutputStream();
      DataOutputStream var1 = new DataOutputStream(var0);

      try {
         var1.writeBoolean(Char.dunghp);
         var1.writeInt(Char.ds);
         var1.writeBoolean(Char.dungmp);
         var1.writeInt(Char.dt);
         var1.writeBoolean(Char.dungthucan);
         var1.writeInt(Char.du);
         var1.writeBoolean(Char.dunghotro);
         var1.writeBoolean(Char.nhat_yen);
         var1.writeBoolean(Char.nhat_hpmp);
         var1.writeInt(Char.lv_hpmp);
         var1.writeBoolean(Char.nhat_da);
         var1.writeInt(Char.lv_da);
         var1.writeBoolean(Char.luyen_da);
         var1.writeInt(Char.lv_luyenda);
         var1.writeBoolean(Char.nhat_tbi);
         var1.writeInt(Char.lv_tbi);
         var1.writeBoolean(Char.nhat_vpnv);
         var1.writeBoolean(Char.nhat_svc);
         var1.writeBoolean(Char.remap);
         var1.writeBoolean(Char.automuathucan);
         var1.writeBoolean(Char.tusathetmp);
         var1.writeBoolean(Char.reconnect);
         var1.writeBoolean(Char.chuyenmap);
         var1.writeBoolean(Char.santatl);
         var1.writeBoolean(Char.quaithuong);
         var1.writeBoolean(Char.quaitinhanh);
         var1.writeBoolean(Char.quaithulinh);
         var1.writeBoolean(Char.nepk);
         var1.writeBoolean(Char.danhtheonhom);
         int var2 = 0;

         int var3;
         for(var3 = 0; var3 < Code.arrItemDel.length; ++var3) {
            if (Code.arrItemDel[var3] >= 0) {
               ++var2;
            }
         }

         var1.writeInt(var2);

         for(var3 = 0; var3 < Code.arrItemDel.length; ++var3) {
            if (Code.arrItemDel[var3] >= 0) {
               var1.writeShort(Code.arrItemDel[var3]);
            }
         }

         var2 = 0;

         for(var3 = 0; var3 < Code.arrItemNhat.length; ++var3) {
            if (Code.arrItemNhat[var3] >= 0) {
               ++var2;
            }
         }

         var1.writeInt(var2);

         for(var3 = 0; var3 < Code.arrItemNhat.length; ++var3) {
            if (Code.arrItemNhat[var3] >= 0) {
               var1.writeShort(Code.arrItemNhat[var3]);
            }
         }

         var1.writeBoolean(Char.autottt);
         var1.writeBoolean(Char.autottc);
         var1.writeBoolean(Char.autocl);
         var1.writeBoolean(Char.automuacl);
         var1.writeBoolean(Char.dung_pthan);
         var1.writeBoolean(Char.nhat_all);
         var1.writeBoolean(Char.autoCongTiemNang);
         var1.writeBoolean(Char.autoCongKyNang);
         var1.flush();
         var0.flush();
         RMS.a("PhongSetting", var0.toByteArray());
      } catch (Exception var4) {
      }

   }

   public static void load_auto() {
      if (RMS.a("PhongSetting") != null) {
         ByteArrayInputStream var0 = new ByteArrayInputStream(RMS.a("PhongSetting"));
         DataInputStream var1 = new DataInputStream(var0);

         try {
            Char.dunghp = var1.readBoolean();
            Char.ds = var1.readInt();
            Char.dungmp = var1.readBoolean();
            Char.dt = var1.readInt();
            Char.dungthucan = var1.readBoolean();
            Char.du = var1.readInt();
            Char.dunghotro = var1.readBoolean();
            Char.nhat_yen = var1.readBoolean();
            Char.nhat_hpmp = var1.readBoolean();
            Char.lv_hpmp = var1.readInt();
            Char.nhat_da = var1.readBoolean();
            Char.lv_da = var1.readInt();
            Char.luyen_da = var1.readBoolean();
            Char.lv_luyenda = var1.readInt();
            Char.nhat_tbi = var1.readBoolean();
            Char.lv_tbi = var1.readInt();
            Char.nhat_vpnv = var1.readBoolean();
            Char.nhat_svc = var1.readBoolean();
            Char.remap = var1.readBoolean();
            Char.automuathucan = var1.readBoolean();
            Char.tusathetmp = var1.readBoolean();
            Char.reconnect = var1.readBoolean();
            Char.chuyenmap = var1.readBoolean();
            Char.santatl = var1.readBoolean();
            Char.quaithuong = var1.readBoolean();
            Char.quaitinhanh = var1.readBoolean();
            Char.quaithulinh = var1.readBoolean();
            Char.nepk = var1.readBoolean();
            Char.danhtheonhom = var1.readBoolean();
            int var2 = var1.readInt();
            if (Code.arrItemDel.length < var2) {
               Code.arrItemDel = new short[10 * (var2 / 10 + 1)];
            }

            int var3;
            for(var3 = 0; var3 < var2; ++var3) {
               Code.arrItemDel[var3] = var1.readShort();
            }

            var2 = var1.readInt();
            if (Code.arrItemNhat.length < var2) {
               Code.arrItemNhat = new short[10 * (var2 / 10 + 1)];
            }

            for(var3 = 0; var3 < var2; ++var3) {
               Code.arrItemNhat[var3] = var1.readShort();
            }

            Char.autottt = var1.readBoolean();
            Char.autottc = var1.readBoolean();
            Char.autocl = var1.readBoolean();
            Char.automuacl = var1.readBoolean();
            Char.dung_pthan = var1.readBoolean();
            try {
               Char.nhat_all = var1.readBoolean();
            } catch (java.io.EOFException eofNa) {
               Char.nhat_all = false;
            }
            try {
               Char.autoCongTiemNang = var1.readBoolean();
               Char.autoCongKyNang = var1.readBoolean();
            } catch (java.io.EOFException eof) {
               Char.autoCongTiemNang = false;
               Char.autoCongKyNang = false;
            }
            var0.close();
            var1.close();
         } catch (Exception var4) {
         }

      }
   }

   public static void muacl() {
      GameScr.npc_b(26, 0, 0);
      phong1.g();
      if (GameScr.bu != null) {
         for(int i = 0; i < GameScr.bu.length; ++i) {
            if (GameScr.bu[i].template.id == 490) {
               Service.gI().a(GameScr.bu[i].typeUI, GameScr.bu[i].indexUI, 1);
               phong1.g();
               GameScr.gI().v();
            }
         }
      }

   }

   public static Socket createSocket(String host, int port) {
      try {
         return new Socket(host, port);
      } catch (Exception var3) {
         return null;
      }
   }

}
