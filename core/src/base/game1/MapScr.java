package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class MapScr extends mScreen implements IActionListener {
   private static MapScr h;
   private boolean i;
   private static Image j = null;
   private static Image k;
   private static Image l;
   private static int m;
   private static int n;
   private static int o;
   private static int p;
   private static int q;
   private static int r;
   private static int s;
   private static int t;
   private static int u;
   private static int v;
   private static int w;
   private static int x;
   private static int y;
   private static int z;
   private static int aa;
   private static int ab;
   private static int ac;
   private static int ad = 0;
   private static int ae = 0;
   private static int[] af = new int[]{1, 156, 140, 174, 196, 195, 125, 148, 156, 173, 199, 203, 222, 264, 283, 277, 298, 307, 311, 315, 116, 90, 59, 31, 252, 55, 81, 111, 148, 187, 219, 253, 278, 304, 311, 310, 284, 309, 294, 62, 92, 117, 99, 134, 154, 175, 34, 52, 40, 78, 59, 82, 114, 179, 158, 142, 1, 215, 291, 242, 147, 301, 71, 23, 116, 126, 305, 286, 264, 20, 46, 70, 78, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
   private static int[] ag = new int[]{1, 68, 75, 88, 80, 107, 87, 114, 136, 160, 168, 196, 216, 219, 248, 265, 276, 260, 232, 204, 111, 82, 79, 59, 168, 33, 28, 34, 45, 20, 54, 44, 19, 40, 60, 100, 175, 165, 134, 181, 199, 208, 221, 220, 219, 221, 195, 217, 246, 244, 250, 263, 262, 241, 252, 244, 2, 240, 197, 139, 16, 18, 208, 223, 239, 186, 120, 119, 135, 107, 125, 126, 148, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
   private int ah;
   private int ai;
   private int aj;
   private int ak;
   private boolean al = false;
   private int am;
   private int an;
   private static int ao;

   public MapScr() {
      super.c = new Command1(TextGame.ah, this, 1000, (Object)null);
      super.b = new Command1(TextGame.fa, this, 1001, (Object)null);
      super.a = new Command1("Chuyển đến", this, 14004, (Object)null);
      ao = -1;
   }

   private void g() {
      if (this.i) {
         super.a = null;
      } else {
         super.a = new Command1("Chuyển đến", this, 14004, (Object)null);
      }

      int var1 = mGraphics.a(TileMap.imgWaterfall);
      this.aj = (GameCanvas.aa - var1) / 2;
      this.ak = (GameCanvas.ab - 20 - mGraphics.b(TileMap.imgWaterfall)) / 2;
      if (this.aj < 0) {
         this.aj = 0;
      }

      if (this.ak < 0) {
         this.ak = 0;
      }

      if (this.i) {
         aa = var1 + 20 - GameCanvas.aa;
         ab = mGraphics.b(TileMap.imgWaterfall) + 40 - GameCanvas.ab;
         this.ah = var1 + 20;
         this.ai = var1 + 40;
         if (this.ai < GameCanvas.ab - 26) {
            this.ai = GameCanvas.ab - 26;
         }

         if (this.ah < GameCanvas.aa) {
            this.ah = GameCanvas.aa;
         }

         o = this.aj + Char.getMyChar().cx1 / 12;
         p = this.ak + Char.getMyChar().cy1 / 12;
      } else {
         aa = 340 - GameCanvas.aa;
         ab = 340 - GameCanvas.ab;
         o = af[TileMap.mapID] + ad;
         p = ag[TileMap.mapID] + ae;
         this.ah = 330 + ad;
         this.ai = 310 + ae;
      }

      this.ah -= 10;
      this.ai -= 10;
      if (aa < 0) {
         aa = 0;
      }

      if (ab < 0) {
         ab = 0;
      }

      z = 0;
      y = 0;
      t = 0;
      s = 0;
      s = o - GameCanvas.ac;
      t = p - GameCanvas.ad;
   }

   public static MapScr f() {
      if (h == null) {
         h = new MapScr();
      }

      return h;
   }

   public final void a() {
      super.a();
      SmallImage.b();
      TileMap.c();
      super.c = new Command1(TextGame.ah, this, 1000, (Object)null);
      super.b = new Command1(TextGame.fa, this, 1001, (Object)null);
      super.a = new Command1("Chuyển đến", this, 14004, (Object)null);
      if (j == null) {
         j = GameCanvas.c("/wm.png");
         k = GameCanvas.c("/u/x.png");
         l = GameCanvas.c("/u/wpt1.png");
         m = mGraphics.b(j);
         n = mGraphics.b(j);
      }

      if (GameCanvas.aa > m) {
         ad = GameCanvas.ac - m / 2 - 12;
      }

      if (GameCanvas.ab > n) {
         ae = GameCanvas.ad - n / 2;
      }

      this.g();
      h();
      mFont.r.b();
      mFont.t.b();
      mFont.q.b();
      mFont.s.b();
      mFont.s.b();
      mFont.p.b();
      mFont.g.b();
      mFont.m.b();
      mFont.h.b();
      mFont.n.b();
      mFont.l.b();
      mFont.b.b();
      mFont.c.b();
      mFont.a.b();
      mFont.e.b();
      System.gc();
      ao = -1;
      TileMap.phong_p = TileMap.mapID;
   }

   public final void b() {
      super.b();
      j = null;
      k = null;
      System.gc();
      TileMap.f();
      SmallImage.c();
      mFont.r.a();
      mFont.t.a();
      mFont.q.a();
      mFont.s.a();
      mFont.s.a();
      mFont.p.a();
      mFont.g.a();
      mFont.m.a();
      mFont.h.a();
      mFont.n.a();
      mFont.l.a();
      mFont.b.a();
      mFont.c.a();
      mFont.a.a();
      mFont.e.a();
   }

   public final void a(mGraphics var1) {
      boolean var2 = false;
      var1.a(0);
      var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
      var1.a(10, 10);
      var1.a(-y, -z);
      int var3;
      int var4;
      int var5;
      int var11;
      int var12;
      if (this.i) {
         var1.a(TileMap.imgWaterfall, this.aj, this.ak, 0);

         for(var5 = 0; var5 < GameScr.vMob.size(); ++var5) {
            Mob var6;
            var3 = (var6 = (Mob)GameScr.vMob.elementAt(var5)).x1 / 12;
            var4 = var6.y1 / 12;
            if (var6.level < Char.getMyChar().cLevel - 2) {
               var1.a(11184810);
            } else if (var6.level > Char.getMyChar().cLevel + 2) {
               var1.a(16711680);
            } else {
               var1.a(16776960);
            }

            var1.c(this.aj + var3 - 1, this.ak + var4 - 1, 3, 3);
         }

         for(var5 = 0; var5 < GameScr.vParty.size(); ++var5) {
            Party var9;
            if ((var9 = (Party)GameScr.vParty.elementAt(var5)).f != null && var9.f != Char.getMyChar()) {
               var3 = var9.f.cx1 / 12;
               var4 = var9.f.cy1 / 12;
               if (GameCanvas.w % 10 < 8) {
                  var1.a(16777215);
                  var1.c(this.aj + var3 - 2, this.ak + var4 - 2, 5, 5);
                  var1.a(65280);
                  var1.c(this.aj + var3 - 1, this.ak + var4 - 1, 3, 3);
               }
            }
         }

         GameScr.gI();
         GameScr.af();

         for(var11 = 0; var11 < GameScr.vNpc.size(); ++var11) {
            Npc var7;
            var3 = (var7 = (Npc)GameScr.vNpc.elementAt(var11)).cx1 / 12;
            var4 = var7.cy1 / 12;
            var1.a(16777215);
            var1.c(this.aj + var3 - 2, this.ak + var4 - 2, 5, 5);
            var1.a(65280);
            var1.c(this.aj + var3 - 1, this.ak + var4 - 1, 3, 3);
            var1.a(k, this.aj + var3, this.ak + var4, 3);
            var2 = true;
         }

         for(var12 = 0; var12 < TileMap.t.size(); var12 = (byte)(var12 + 1)) {
            Waypoint var8;
            var3 = ((var8 = (Waypoint)TileMap.t.elementAt(var12)).a + var8.c) / 2 / 12;
            var4 = (var8.b + var8.d) / 2 / 12;
            if (GameCanvas.w % 10 < 8) {
               var1.a(0);
               var1.c(this.aj + var3 - 2, this.ak + var4 - 2, 5, 5);
               var1.a(16777215);
               var1.c(this.aj + var3 - 1, this.ak + var4 - 1, 3, 3);
            }
         }

         var3 = Char.getMyChar().cx1 / 12;
         var4 = Char.getMyChar().cy1 / 12;
         var1.a(16777215);
         var1.c(this.aj + var3 - 2, this.ak + var4 - 2, 5, 5);
         if (GameCanvas.w % 10 > 5) {
            var1.a(255);
            var1.c(this.aj + var3 - 1, this.ak + var4 - 1, 3, 3);
         }

         var1.a(l, o - 2, p, 0);
         super.a(var1);
         if (!var2) {
            mFont.i.a(var1, TileMap.mapName, 10, GameCanvas.ab - 17, 0);
         }
      } else {
         if (GameCanvas.aa > m && GameCanvas.ab > n) {
            var1.a(j, GameCanvas.ac, GameCanvas.ad, StaticObj.g);
         } else if (GameCanvas.aa > m) {
            var1.a(j, GameCanvas.ac, 0, StaticObj.a);
         } else if (GameCanvas.ab > n) {
            var1.a(j, 0, GameCanvas.ad, StaticObj.h);
         } else {
            var1.a(j, 0, 0, 0);
         }

         if (TileMap.mapID < TileMap.u.length && TileMap.mapID >= 0) {
            var3 = 0;
            if (af[TileMap.mapID] != 1 || ag[TileMap.mapID] != 1) {
               var3 = af[TileMap.mapID] < 100 ? 0 : (af[TileMap.mapID] > 200 ? 1 : 2);
               GameCanvas.a(af[TileMap.mapID] + ad, ag[TileMap.mapID] + ae, var1, false);
            }

            var5 = 0;
            if (ac >= 0) {
               var3 = af[ac] < 100 ? 0 : (af[ac] > 200 ? 1 : 2);
               mFont.i.a(var1, TileMap.u[ac], af[ac] + ad, ag[ac] + ae - 20, var3, mFont.k);
               var1.a(k, af[ac] + ad, ag[ac] + ae, 3);
               var2 = true;
               var5 = ag[ac] - 20;
            } else if (af[TileMap.mapID] != 1 || ag[TileMap.mapID] != 1) {
               var5 = ag[TileMap.mapID] - 20;
               mFont.j.a(var1, TileMap.u[TileMap.mapID], af[TileMap.mapID] + ad, ag[TileMap.mapID] + ae - 20, var3, mFont.k);
            }

            for(var11 = 0; var11 < Char.getMyChar().dw.size(); ++var11) {
               TaskOrder var10;
               if ((var10 = (TaskOrder)Char.getMyChar().dw.elementAt(var11)).g >= 0 && var10.g < af.length) {
                  var1.a(k, af[var10.g] + ad, ag[var10.g] + ae, 3);
               }
            }

            if (q >= 0 && (ac < 0 && TileMap.mapID != q || ac >= 0 && q != ac)) {
               var3 = af[q] < 100 ? 0 : (af[q] > 200 ? 1 : 2);
               var11 = af[q];
               if ((var4 = ag[q] - 20) > var5 && var4 - var5 < 30) {
                  var4 += 40;
               }

               if (var4 < var5 && var5 - var4 < 20) {
                  var4 -= 5;
               }

               mFont.j.a(var1, TileMap.u[q], var11 + ad, var4 + ae, var3, mFont.k);
            }
         }

         var1.a(l, o - 2, p, 0);
         var1.a(-var1.a(), -var1.b());
         super.a(var1);
      }

      if (q > 0) {
         var12 = var2 ? 18 : 5;
         mFont.j.a(var1, "Map ID: " + q, 5, var12, 0, mFont.k);
      }

      if (var2) {
         var1.a(k, 10, 10, 3);
         mFont.i.a(var1, TextGame.hx, 20, 5, 0);
      }

   }

   public final void e() {
      super.e();
      if (++r > 10000) {
         r = 0;
      }

      if (y != s || z != t) {
         u = s - y << 1;
         v = t - z << 1;
         w += u;
         y += w >> 4;
         w &= 15;
         x += v;
         z += x >> 4;
         x &= 15;
         if (y < 0) {
            y = 0;
         }

         if (y > aa) {
            y = aa;
         }

         if (z < 0) {
            z = 0;
         }

         if (z > ab) {
            z = ab;
         }
      }

      boolean var1 = false;
      if (GameCanvas.o[2]) {
         if ((p -= 4) < ae - 10) {
            p = ae - 10;
         }

         var1 = true;
      }

      if (GameCanvas.o[8]) {
         if ((p += 4) > this.ai) {
            p = this.ai;
         }

         var1 = true;
      }

      if (GameCanvas.o[4]) {
         if ((o -= 4) < ad - 10) {
            o = ad - 10;
         }

         var1 = true;
      }

      if (GameCanvas.o[6]) {
         if ((o += 4) > this.ah) {
            o = this.ah;
         }

         var1 = true;
      }

      if (var1) {
         s = o - GameCanvas.ac;
         t = p - GameCanvas.ad;
         h();
      }

      GameScr.gI();
      ac = GameScr.ae();
      if (GameCanvas.q && GameCanvas.t < GameCanvas.ab - mScreen.f) {
         GameCanvas.q = false;
         this.al = true;
         this.am = GameCanvas.s;
         this.an = GameCanvas.t;
      } else if (GameCanvas.p && this.al) {
         s -= GameCanvas.s - this.am;
         t -= GameCanvas.t - this.an;
         if (s < 0) {
            s = 0;
         }

         if (t < 0) {
            t = 0;
         }

         if (s > aa) {
            s = aa;
         }

         if (t > ab) {
            t = ab;
         }

         y = s;
         z = t;
         this.am = GameCanvas.s;
         this.an = GameCanvas.t;
      }

      if (GameCanvas.r) {
         int var3 = GameCanvas.u - GameCanvas.s;
         int var2 = GameCanvas.v - GameCanvas.t;
         if (var3 < 10 && var2 < 10) {
            o = y + GameCanvas.u - 8;
            p = z + GameCanvas.v - 8;
            h();
         }

         this.al = false;
         GameCanvas.r = false;
      }

      if (GameCanvas.g && GameCanvas.aa >= 320) {
         super.a.f = GameCanvas.aa / 2 - 160;
         super.b.f = GameCanvas.aa / 2 - 35;
         super.c.f = GameCanvas.aa / 2 + 88;
         super.a.g = super.b.g = super.c.g = GameCanvas.ab - 26;
      }

   }

   private static void h() {
      ao = q;
      q = -1;

      for(int var0 = 0; var0 < af.length; ++var0) {
         if (Res.e(o - (af[var0] + ad)) < 10 && Res.e(p - (ag[var0] + ae)) < 10) {
            q = var0;
            if (ao != -1 && ao == q) {
               Service.gI().ad(q);
               ao = -1;
               q = -1;
               return;
            }
            break;
         }
      }

   }

   public final void a(int var1, Object var2) {
      switch (var1) {
         case 1000:
            if (Char.getMyChar().cHP <= 0 || Char.getMyChar().statusMe == 14) {
               super.b = GameScr.gI().fj;
               Char.getMyChar().cHP = 0;
            }

            GameScr.gI().a();
            return;
         case 1001:
            this.i = !this.i;
            this.g();
            return;
         case 14004:
            (new Thread(new goto_map(q))).start();
         default:
      }
   }

}
