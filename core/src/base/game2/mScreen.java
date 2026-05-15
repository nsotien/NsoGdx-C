package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class mScreen {
   public Command1 a;
   public Command1 b;
   public Command1 c;
   public static int d;
   public static int e;
   public static int f;
   public static int g;
   private static Random random = new Random();
   public static int count = 0;

   private static mFont getRandomFont() {
      mFont[] arr = new mFont[]{mFont.a, mFont.b, mFont.c, mFont.d, mFont.e, mFont.f};
      return arr[random.nextInt(arr.length)];
   }

   public void a() {
      GameCanvas.h();
      GameCanvas.i();
      if (GameCanvas.currentScreen != null) {
         GameCanvas.currentScreen.b();
      }

      GameCanvas.currentScreen = this;
      boolean var1 = true;
      MotherCanvas.a.setFullScreenMode(true);
   }

   public void b() {
   }

   public static void c() {
      if (GameCanvas.g) {
         f = 26;
      } else {
         f = 24;
      }

   }

   public void a(int var1) {
   }

   public void d() {
   }

   public void e() {
      if (GameCanvas.n[5] || a(GameCanvas.currentScreen.b)) {
         GameCanvas.n[5] = false;
         g = -1;
         GameCanvas.r = false;
         if (this.b != null) {
            this.b.a();
         }
      }

      if (GameCanvas.n[12] || a(GameCanvas.currentScreen.a)) {
         GameCanvas.n[12] = false;
         g = -1;
         GameCanvas.r = false;
         if (ChatTextField.a().b) {
            if (ChatTextField.a().d != null) {
               ChatTextField.a().d.a();
            }
         } else if (this.a != null) {
            this.a.a();
         }
      }

      if (GameCanvas.n[13] || a(GameCanvas.currentScreen.c)) {
         GameCanvas.n[13] = false;
         g = -1;
         GameCanvas.r = false;
         if (ChatTextField.a().b) {
            if (ChatTextField.a().e != null) {
               ChatTextField.a().e.a();
               return;
            }
         } else if (this.c != null) {
            this.c.a();
         }
      }

   }

   public static boolean a(Command1 var0) {
      if (var0 == null) {
         return false;
      } else if (var0.f != 0 && var0.g != 0) {
         return var0.b();
      } else {
         if (GameCanvas.aj != null) {
            if (GameCanvas.aj.d != null && GameCanvas.b(GameCanvas.aa - e >> 1, GameCanvas.ab - f - 5, e, f + 10)) {
               g = 1;
               if (var0 == GameCanvas.aj.d && GameCanvas.q && GameCanvas.r) {
                  return true;
               }
            }

            if (GameCanvas.aj.c != null && GameCanvas.b(0, GameCanvas.ab - f - 5, e, f + 10)) {
               g = 0;
               if (var0 == GameCanvas.aj.c && GameCanvas.q && GameCanvas.r) {
                  return true;
               }
            }

            if (GameCanvas.aj.e != null && GameCanvas.b(GameCanvas.aa - e, GameCanvas.ab - f - 5, e, f + 10)) {
               g = 2;
               if ((var0 == GameCanvas.aj.e || var0 == ChatTextField.a().e) && GameCanvas.q && GameCanvas.r) {
                  return true;
               }
            }
         } else {
            if (var0 == GameCanvas.currentScreen.a && GameCanvas.b(0, GameCanvas.ab - f - 5, e, f + 10)) {
               g = 0;
               if (GameCanvas.q && GameCanvas.r) {
                  return true;
               }
            }

            if (var0 == GameCanvas.currentScreen.c && GameCanvas.b(GameCanvas.aa - e, GameCanvas.ab - f - 5, e, f + 10)) {
               g = 2;
               if (GameCanvas.q && GameCanvas.r) {
                  return true;
               }
            }

            if ((var0 == GameCanvas.currentScreen.b || ChatPopup.f != null) && GameCanvas.b(GameCanvas.aa - e >> 1, GameCanvas.ab - f - 5, e, f + 10)) {
               g = 1;
               if (GameCanvas.q && GameCanvas.r) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private static mFont abc(int var0) {
      if (var0 >= 0 && var0 < 10) {
         return mFont.a;
      } else if (var0 >= 10 && var0 < 20) {
         return mFont.b;
      } else if (var0 >= 20 && var0 < 30) {
         return mFont.c;
      } else if (var0 >= 30 && var0 < 40) {
         return mFont.d;
      } else if (var0 >= 40 && var0 < 50) {
         return mFont.e;
      } else {
         return var0 >= 50 && var0 < 60 ? mFont.f : mFont.f;
      }
   }

   public void a(mGraphics var1) {
      var1.a(-var1.a(), -var1.b());
      var1.d(0, 0, GameCanvas.aa, GameCanvas.ab + 1);
      Paint.a(var1);
      if (ChatPopup.f != null) {
         Paint.a(var1, (Command1)null, ChatPopup.f.e, (Command1)null);
      } else if (ChatTextField.a().b) {
         Paint.a(var1, ChatTextField.a().d, ChatTextField.a().f, ChatTextField.a().e);
      } else if (GameCanvas.aj == null && !GameCanvas.af.a) {
         Paint.a(var1, this.a, this.b, this.c);
      }

      if (GameCanvas.currentScreen instanceof GameScr) {
         mFont.j.a(var1, "Map: " + TileMap.mapID, TileMap.posMiniMapX + 5, TileMap.posMiniMapY + 5, 0, mFont.k);
         mFont.j.a(var1, "Khu: " + TileMap.zoneID, TileMap.posMiniMapX + 5, TileMap.posMiniMapY + 15, 0, mFont.k);
         mFont.j.a(var1, "XY: " + Char.getMyChar().cx1 + "/" + Char.getMyChar().cy1, TileMap.posMiniMapX + 5, TileMap.posMiniMapY + 25, 0, mFont.k);
      }

   }

   static {
      d = mFont.o.c() + 8;
      e = 70 * mGraphics.b;
      f = 22;
      g = -1;
   }
}
