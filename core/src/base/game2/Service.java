package base.game2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Service {
   private Session_ME a = Session_ME.a();
   private static Service b;
   private int c;
   private int d;

   public static Service gI() {
      if (b == null) {
         b = new Service();
      }

      return b;
   }

   private static Message messageNotLogin(byte var0) {
      Message var1 = new Message((byte)-29);
      (new StringBuffer("CMD NOT_LOGIN ----> ")).append(var0).toString();

      try {
         var1.c().writeByte(var0);
      } catch (IOException var3) {
         ;
      }

      return var1;
   }

   private static Message messageNotMap(byte var0) {
      Message var1 = new Message((byte)-28);
      (new StringBuffer("CMD NOT MAP ----> ")).append(var0).toString();

      try {
         var1.c().writeByte(var0);
      } catch (IOException var3) {
         ;
      }

      return var1;
   }

   private static Message messageSubCommand(byte var0) {
      Message var1 = new Message((byte)-30);
      (new StringBuffer("CMD SUB_COMMAND ----> ")).append(var0).toString();

      try {
         var1.c().writeByte(var0);
      } catch (IOException var3) {
         ;
      }

      return var1;
   }

   public final void setClientType() {
      DebugLog.log("Service", "setClientType() w=" + GameCanvas.aa + " h=" + GameCanvas.ab + " zoom=" + mGraphics.b);
      try {
         Message var1;
         (var1 = messageNotLogin((byte)-125)).c().writeByte(GameMidlet.a);
         var1.c().writeByte(mGraphics.b);
         var1.c().writeBoolean(GameCanvas.d);
         var1.c().writeInt(GameCanvas.aa);
         var1.c().writeInt(GameCanvas.ab);
         var1.c().writeBoolean(TField.h);
         var1.c().writeBoolean(GameCanvas.g);
         String _platform = System.getProperty("microedition.platform");
         var1.c().writeUTF(_platform != null ? _platform : "LibGDX");
         var1.c().writeByte(0);
         var1.c().writeInt(0);
         var1.c().writeByte(TextGame.a);
         var1.c().writeInt(0);
         var1.c().writeUTF("0");
         this.a.a(var1);
         var1.d();
      } catch (IOException var2) {
         ;
      }

   }

   public final void login(String var1, String var2, String var3) {
      DebugLog.log("Service", "login() user=" + var1 + " server=" + var3);
      // P2 N6 T2: invariant tripwire — verify that set ca isVerified VA verifyStarted dong thoi.
      if (com.monkey.nso.LicenseVerifier.isVerified && !com.monkey.nso.LicenseGuard.isVerifyStarted()) {
         com.monkey.nso.LicenseGuard.fireTripwire(2);
      }
      // P2 A1#1: g1 cross-check truoc login. Fail -> delay 45-75s roi return KHONG login.
      if (com.monkey.nso.LicenseGuard.isVerifyStarted() && !com.monkey.nso.LicenseGuard.g1()) {
         new Thread(new Runnable() { public void run() {
            try { Thread.sleep(45000L + (long)(Math.random() * 30000L)); } catch (Exception e) {}
         }}).start();
         return;
      }
      gI().setClientType();

      try {
         Message var4;
         (var4 = messageNotLogin((byte)-127)).c().writeUTF(var1);
         var4.c().writeUTF(var2);
         var4.c().writeUTF(var3);
         var4.c().writeUTF("");
         var4.c().writeUTF("");
         var4.c().writeUTF(RMS.b("random"));
         var4.c().writeByte(GameMidlet.h);
         this.a.a(var4);
         var4.d();
      } catch (IOException var5) {
         ;
      }

   }

   public final void requestRegisterNew(String var1, String var2, String var3) {
      try {
         Message var4;
         (var4 = new Message((byte)118)).c().writeUTF(var1);
         var4.c().writeUTF(var2);
         var4.c().writeUTF(var3);
         this.a.a(var4);
         var4.d();
      } catch (Exception var5) {
         ;
      }

   }

   public final void requestForgetPass(String var1) {
      try {
         Message var2;
         (var2 = messageNotLogin((byte)-122)).c().writeUTF(var1);
         this.a.a(var2);
         var2.d();
      } catch (IOException var3) {
         ;
      }

   }

   public final void c() {
      Message var1 = new Message((byte)-17);
      this.a.a(var1);
      var1.d();
   }

   public final void a(int var1, int var2) {
      Message var3 = new Message((byte)28);

      try {
         var3.c().writeByte(var1);
         var3.c().writeByte(var2);
         this.a.a(var3);
         var3.d();
      } catch (Exception var5) {
      }

   }

   public final void b(int var1, int var2) {
      try {
         Message var3;
         (var3 = new Message((byte)1)).c().writeShort(var1);
         var3.c().writeShort(var2);
         this.c = var1;
         this.d = var2;
         this.a.a(var3);
         var3.d();
      } catch (Exception var4) {
         ;
      }

   }

   public final void b(String var1) {
      Message var2 = new Message((byte)-28);

      try {
         var2.c().writeByte(-126);
         var2.c().writeUTF(var1);
      } catch (Exception var4) {
         ;
      }

      this.a.a(var2);
   }

   public final void a(String var1, int var2, int var3) {
      Message var4 = new Message((byte)-28);

      try {
         var4.c().writeByte(-125);
         var4.c().writeUTF(var1);
         var4.c().writeByte(var2);
         var4.c().writeByte(var3);
      } catch (Exception var6) {
         ;
      }

      this.a.a(var4);
   }

   public final void a(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-108)).c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void c(int var1, int var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)42)).c().writeByte(var1);
         var3.c().writeByte(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void d(int var1, int var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)94)).c().writeInt(var1);
         var3.c().writeByte(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void e(int var1, int var2) {
      Message var3 = null;

      try {
         (var3 = messageSubCommand((byte)-109)).c().writeByte(var1);
         var3.c().writeShort(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void f(int var1, int var2) {
      Message var3 = null;

      try {
         (var3 = messageSubCommand((byte)-108)).c().writeShort(var1);
         var3.c().writeByte(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void b(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)15)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void c(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)108)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void d(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)16)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void e(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)17)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void useItem(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)11)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

      if (Char.getMyChar().arrItemBag[var1] != null && Char.getMyChar().arrItemBag[var1].template.type == 24) {
         GameScr.gI().v();
         InfoDlg.a("");
      }

   }

   public final void g(int var1, int var2) {
      if (!TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
         GameCanvas.a("Đứng ở trường hoặc làng để bán đồ");
      } else {
         GameCanvas.ak.a();
         Message var3 = null;

         try {
            (var3 = new Message((byte)14)).c().writeByte(var1);
            if (var2 > 1) {
               var3.c().writeInt(var2);
            } else {
               var3.c().writeInt(1);
            }

            this.a.a(var3);
         } catch (Exception var8) {
            ;
         } finally {
            var3.d();
         }
      }

   }

   public final void a(int var1, int var2, int var3) {
      GameCanvas.ak.a();
      Message var4 = null;

      try {
         (var4 = new Message((byte)13)).c().writeByte(var1);
         var4.c().writeByte(var2);
         if (var3 > 1) {
            var4.c().writeShort(var3);
         }

         this.a.a(var4);
      } catch (Exception var9) {
         ;
      } finally {
         var4.d();
      }

   }

   public final void selectSkill(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)41)).c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void sendFakeSkill(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)104)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void d() {
      Message var1 = null;

      try {
         var1 = messageSubCommand((byte)-77);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void e() {
      Message var1 = null;

      try {
         var1 = new Message((byte)36);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void h(int var1, int var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)12)).c().writeByte(var1);
         var3.c().writeByte(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void openMenu(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)40)).c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void menu(byte var1, int var2, int var3, int var4) {
      Message var5 = null;

      try {
         (var5 = new Message((byte)29)).c().writeByte(var1);
         var5.c().writeByte(var2);
         var5.c().writeByte(var3);
         var5.c().writeByte(var4);
         this.a.a(var5);
      } catch (Exception var10) {
         ;
      } finally {
         var5.d();
      }

   }

   public final void a(short var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)34)).c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(short var1, String var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)92)).c().writeShort(var1);
         var3.c().writeUTF(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void i(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-103)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void f() {
      Message var1 = null;

      try {
         var1 = messageSubCommand((byte)-107);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void g() {
      Message var1 = null;

      try {
         var1 = messageSubCommand((byte)-106);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void j(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-105)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void k(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-104)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(Item[] var1) {
      GameCanvas.ak.a();
      Message var2 = null;

      try {
         var2 = new Message((byte)19);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3] != null) {
               var2.c().writeByte(var1[var3].indexUI);
            }
         }

         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(Item var1, Item[] var2, boolean var3) {
      GameCanvas.ak.a();
      Message var4 = null;

      try {
         (var4 = new Message((byte)21)).c().writeBoolean(var3);
         var4.c().writeByte(var1.indexUI);

         for(int var9 = 0; var9 < var2.length; ++var9) {
            if (var2[var9] != null) {
               var4.c().writeByte(var2[var9].indexUI);
            }
         }

         this.a.a(var4);
      } catch (Exception var9) {
         ;
      } finally {
         var4.d();
      }

   }

   public final void b(Item[] var1) {
      GameCanvas.ak.a();
      Message var2 = null;

      try {
         var2 = new Message((byte)20);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3] != null) {
               var2.c().writeByte(var1[var3].indexUI);
            }
         }

         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(Item var1) {
      GameCanvas.ak.a();
      Message var2 = null;

      try {
         (var2 = new Message((byte)22)).c().writeByte(var1.indexUI);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void l(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)44)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void m(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)99)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void n(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)106)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void o(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)107)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void p(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)66)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void h() {
      Message var1 = null;

      try {
         var1 = new Message((byte)56);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void i() {
      Message var1 = null;

      try {
         var1 = new Message((byte)57);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void j() {
      Message var1 = null;

      try {
         var1 = new Message((byte)46);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void a(int var1, Item[] var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)45)).c().writeInt(var1);
         var1 = 0;

         int var4;
         for(var4 = 0; var4 < var2.length; ++var4) {
            if (var2[var4] != null) {
               ++var1;
            }
         }

         var3.c().writeByte(var1);

         for(var4 = 0; var4 < var2.length; ++var4) {
            if (var2[var4] != null) {
               var3.c().writeByte(var2[var4].indexUI);
            }
         }

         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void sendPlayerAttack(MyVector mob, MyVector vChar, int type) {
      Message var4 = null;
      if (type != 0) {
         try {
            Mob var5;
            Char var7;
            if (mob.size() > 0 && vChar.size() > 0) {
               if (type == 1) {
                  var4 = new Message((byte)4);
               } else if (type == 2) {
                  var4 = new Message((byte)73);
               }

               var4.c().writeByte(mob.size());

               for(type = 0; type < mob.size(); ++type) {
                  var5 = (Mob)mob.elementAt(type);
                  var4.c().writeByte(var5.m);
               }

               for(type = 0; type < vChar.size(); ++type) {
                  if ((var7 = (Char)vChar.elementAt(type)) != null) {
                     var4.c().writeInt(var7.idChar);
                  } else {
                     var4.c().writeInt(-1);
                  }
               }
            } else if (mob.size() > 0) {
               var4 = new Message((byte)60);

               for(type = 0; type < mob.size(); ++type) {
                  var5 = (Mob)mob.elementAt(type);
                  var4.c().writeByte(var5.m);
               }
            } else if (vChar.size() > 0) {
               var4 = new Message((byte)61);

               for(type = 0; type < vChar.size(); ++type) {
                  var7 = (Char)vChar.elementAt(type);
                  var4.c().writeInt(var7.idChar);
               }
            }

            if (var4 != null) {
               this.a.a(var4);
            }
         } catch (Exception var7) {
         }
      }

   }

   public final void pickItem(int var1) {
      Message var2 = null;

      for(int var3 = 0; var3 < GameScr.vItemMap.size(); ++var3) {
         GameScr.vItemMap.elementAt(var3);
      }

      try {
         (var2 = new Message((byte)-14)).c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void r(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-12)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void k() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-9);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void l() {
      Message var1 = null;

      try {
         var1 = new Message((byte)-10);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void b(int var1, int var2, int var3) {
      Message var8 = null;

      try {
         (var8 = new Message((byte)47)).c().writeByte(var1);
         var8.c().writeByte(var2);
         this.a.a(var8);
      } catch (Exception var9) {
         ;
      } finally {
         var8.d();
      }

   }

   public final void c(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-23)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void d(String var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-78)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void m() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-122);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void n() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-121);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void o() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-120);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void p() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-119);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void q() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-101);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void s(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)43)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void e(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)59)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void t(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)80)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void u(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)81)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void v(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)65)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void w(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)68)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void x(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-79)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void f(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)79)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void y(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-109)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void z(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-93)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void aa(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-87)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ab(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-86)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void r() {
      Message var1 = null;

      try {
         (var1 = new Message((byte)74)).c().writeByte(Char.getMyChar().cdir);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void s() {
      Message var1 = null;

      try {
         var1 = messageSubCommand((byte)-88);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void a(boolean var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-76)).c().writeBoolean(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void t() {
      Message var1 = null;

      try {
         var1 = new Message((byte)83);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void u() {
      Message var1 = null;

      try {
         var1 = messageSubCommand((byte)-85);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void ac(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)100)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(MyVector var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)25)).c().writeByte(var1.size());

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            Char var4 = (Char)var1.elementAt(var3);
            var2.c().writeInt(var4.idChar);
         }

         this.a.a(var2);
      } catch (Exception var8) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void v() {
      Message var1 = null;

      try {
         var1 = messageSubCommand((byte)-84);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void g(String var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-83)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void h(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)23)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void i(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)24)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(String var1, int var2) {
      Message var7 = null;

      try {
         (var7 = new Message((byte)93)).c().writeUTF(var1);
         var7.c().writeByte(0);
         this.a.a(var7);
      } catch (Exception var8) {
         ;
      } finally {
         var7.d();
      }

   }

   public final void j(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-20)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void k(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-21)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(String var1, String var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)-22)).c().writeUTF(var1);
         var3.c().writeUTF(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void l(String var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)-19)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void b(String var1, String var2) {
      Message var3 = null;

      try {
         (var3 = messageNotMap((byte)-99)).c().writeUTF(var1);
         var3.c().writeUTF(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void a(String var1, byte[] var2, byte var3) {
      Message var4 = null;

      try {
         (var4 = messageSubCommand((byte)-67)).c().writeUTF(var1);
         var4.c().writeInt(var2.length);
         var4.c().write(var2);
         var4.c().write(var3);
         this.a.a(var4);
      } catch (Exception var9) {
         ;
      } finally {
         var4.d();
      }

   }

   public final void m(String var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-65)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ad(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-70)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void b(String var1, int var2) {
      Message var3 = null;

      try {
         (var3 = messageNotMap((byte)-97)).c().writeInt(var2);
         var3.c().writeUTF(var1);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void ae(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-115)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void w() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-113);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void x() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-112);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void y() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-111);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void z() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-114);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void af(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-63)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ag(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-61)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ah(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-62)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ai(int var1) {
      Message var2 = null;

      try {
         (var2 = messageSubCommand((byte)-60)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void n(String var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-95)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void c(String var1, int var2) {
      Message var3 = null;

      try {
         (var3 = messageNotMap((byte)-94)).c().writeUTF(var1);
         var3.c().writeByte(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void o(String var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-93)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void aa() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-92);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void aj(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-90)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ak(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-89)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ab() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-91);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void c(int var1, int var2, int var3) {
      Message var4 = null;

      try {
         (var4 = messageNotMap((byte)-88)).c().writeByte(var1);
         var4.c().writeByte(var2);
         var4.c().writeByte(var3);
         this.a.a(var4);
      } catch (Exception var9) {
         ;
      } finally {
         var4.d();
      }

   }

   public final void p(String var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-87)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void q(String var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-70)).c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ac() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-68);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void ad() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-69);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void ae() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-62);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void i(int var1, int var2) {
      Message var3 = null;

      try {
         (var3 = messageNotMap((byte)-85)).c().writeByte(var1);
         var3.c().writeInt(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void al(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-105)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void am(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-102)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void j(int var1, int var2) {
      Message var3 = null;

      try {
         (var3 = messageNotMap((byte)-104)).c().writeInt(var1);
         var3.c().writeInt(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void an(int var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-103)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void af() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-82);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void ag() {
      Message var1 = null;

      try {
         var1 = messageNotMap((byte)-79);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void a(Item var1, int var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)102)).c().writeByte(var1.indexUI);
         var3.c().writeInt(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void ao(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)104)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ap(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)105)).c().writeInt(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void selectCard() {
      Message var1 = null;

      try {
         (var1 = messageNotMap((byte)-72)).c().writeByte(GameScr.indexSelect);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void r(String var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)-61)).c().writeByte(GameScr.indexSelect);
         var2.c().writeUTF(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ai() {
      Message var1 = null;

      try {
         (var1 = messageNotMap((byte)-60)).c().writeByte(GameScr.indexSelect);
         this.a.a(var1);
      } catch (Exception var6) {
         ;
      } finally {
         var1.d();
      }

   }

   public final void c(Item[] var1) {
      Message var2 = null;

      try {
         var2 = new Message((byte)110);

         int var3;
         for(var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3] != null && (var1[var3].template.id == 10 || var1[var3].template.id == 11)) {
               var2.c().writeByte(var1[var3].indexUI);
               break;
            }
         }

         for(var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3] != null && (var1[var3].template.id == 455 || var1[var3].template.id == 456)) {
               var2.c().writeByte(var1[var3].indexUI);
            }
         }

         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(Item var1, Item[] var2) {
      ;
      GameCanvas.ak.a();
      Message var3 = null;
      ;

      try {
         (var3 = new Message((byte)111)).c().writeByte(var1.indexUI);

         for(int var8 = 0; var8 < var2.length; ++var8) {
            if (var2[var8] != null && (var2[var8].template.id == 455 || var2[var8].template.id == 456 || var2[var8].template.id == 457)) {
               var3.c().writeByte(var2[var8].indexUI);
            }
         }

         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

      ;
   }

   public final void b(Item var1, Item[] var2) {
      GameCanvas.ak.a();
      Message var3 = null;

      try {
         (var3 = new Message((byte)112)).c().writeByte(var1.indexUI);
         int var9 = 0;

         for(int var4 = 0; var4 < var2.length; ++var4) {
            if (var2[var4] != null && var2[var4].template.id == 454) {
               var3.c().writeByte(var2[var4].indexUI);
               ++var9;
            }
         }

         if (var9 >= 20) {
            this.a.a(var3);
            return;
         }

         GameCanvas.a(TextGame.rs);
      } catch (Exception var9) {
         ;
         return;
      } finally {
         var3.d();
      }

   }

   public final void aq(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)113)).c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(String var1, String var2, byte var3) {
      Message var4 = null;
      var1 = var1 + " " + var2;

      try {
         (var4 = new Message((byte)-21)).c().writeUTF(var1);
         var4.c().writeByte(var3);
         this.a.a(var4);
      } catch (Exception var9) {
      } finally {
         var4.d();
      }

   }

   public final void b(short var1, String var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)118)).c().writeUTF(var2);
         var3.c().writeShort(var1);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void b(short var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)119)).c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(byte var1, String var2) {
      Message var3 = null;

      try {
         (var3 = new Message((byte)121)).c().writeByte(var1);
         var3.c().writeUTF(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void a(byte var1, short var2) {
      Message var3 = null;

      try {
         (var3 = messageNotMap((byte)122)).c().writeByte(var1);
         var3.c().writeByte(var2);
         this.a.a(var3);
      } catch (Exception var8) {
         ;
      } finally {
         var3.d();
      }

   }

   public final void a(short var1, String var2, byte var3) {
      Message var4 = null;

      try {
         (var4 = new Message((byte)92)).c().writeShort(var1);
         var4.c().writeUTF(var2);
         var4.c().writeByte(var3);
         this.a.a(var4);
      } catch (Exception var9) {
         ;
      } finally {
         var4.d();
      }

   }

   public final void a(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      try {
         Message var8;
         (var8 = new Message((byte)123)).c().writeUTF(var1);
         var8.c().writeUTF(var2);
         var8.c().writeUTF(var3);
         var8.c().writeUTF(var4);
         var8.c().writeUTF(var5);
         var8.c().writeUTF(var6);
         var8.c().writeUTF(var7);
         this.a.a(var8);
         var8.d();
      } catch (Exception var9) {
         ;
      }

   }

   public final void a(byte var1) {
      Message var2 = null;

      try {
         (var2 = messageNotMap((byte)122)).c().writeByte(4);
         var2.c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void a(byte var1, Item var2, Item var3, Item[] var4) {
      GameCanvas.ak.a();
      Message var5 = null;

      try {
         (var5 = new Message((byte)124)).c().writeByte(var1);
         if (var1 == 0) {
            var5.c().writeByte(var2.indexUI);
            var5.c().writeByte(var3.indexUI);

            for(var1 = 0; var1 < var4.length; ++var1) {
               if (var4[var1] != null) {
                  var5.c().writeByte(var4[var1].indexUI);
               }
            }
         } else if (var1 == 1) {
            var5.c().writeByte(var3.indexUI);

            for(var1 = 0; var1 < var4.length; ++var1) {
               if (var4[var1] != null) {
                  var5.c().writeByte(var4[var1].indexUI);
               }
            }
         } else if (var1 == 2 || var1 == 3) {
            var5.c().writeByte(var3.indexUI);
         }

         this.a.a(var5);
      } catch (Exception var10) {
         ;
      } finally {
         var5.d();
      }

   }

   public final void d(Item[] var1) {
      GameCanvas.ak.a();
      Message var2 = null;

      try {
         var2 = new Message((byte)126);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3] != null) {
               var2.c().writeByte(var1[var3].indexUI);
            }
         }

         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void c(short var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)125)).c().writeByte(1);
         var2.c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void ar(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)125)).c().writeByte(2);
         var2.c().writeShort(var1);
         this.a.a(var2);
      } catch (Exception var7) {
         ;
      } finally {
         var2.d();
      }

   }

   public final void as(int var1) {
      Message var2 = null;

      try {
         (var2 = new Message((byte)117)).c().writeByte(0);
         var2.c().writeByte(var1);
         this.a.a(var2);
      } catch (Exception var4) {
         ;
      }

   }

}
