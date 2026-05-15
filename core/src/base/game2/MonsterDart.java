package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public final class MonsterDart extends Effect2 {
   private int e;
   private int f;
   private int g;
   private short h = 256;
   private int i;
   private int j;
   private int k;
   private boolean l = false;
   private int m;
   private int n;
   private int o;
   private Char p;
   private BuNhin q;
   private boolean r;
   private int s;
   private int t = 1;
   private static int u;
   private static Vector v = new Vector();
   private static int w = 0;
   private int x = 0;
   private int y;
   private static byte[] z = new byte[]{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0};
   private static int[] aa = new int[]{0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1};
   private static int[] ab = new int[]{0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370};

   private void a(int var1) {
      this.e = var1;
      this.f = this.h * Res.b(var1) >> 10;
      this.g = this.h * Res.a(var1) >> 10;
   }

   public static void a(int var0, int var1, boolean var2, short var3, int var4, int var5, int var6, Char var7) {
      u = var3;
      Effect2.a.addElement(new MonsterDart(var0, var1, var2, var3, var4, var5, var6, var7));
   }

   public static void a(int var0, int var1, BuNhin var2) {
      Effect2.a.addElement(new MonsterDart(var0, var1, var2));
   }

   private MonsterDart(int var1, int var2, boolean var3, short var4, int var5, int var6, int var7, Char var8) {
      this.o = 0;
      this.i = var1;
      this.j = var2;
      this.r = var3;
      this.s = var5;
      this.m = var6;
      this.n = var7;
      this.p = var8;
      if (var3) {
         this.a(this.t * 90);
         ++this.t;
         if (this.t > 3) {
            this.t = 1;
            return;
         }
      } else {
         if (var1 > var8.cx1) {
            this.a(240);
            return;
         }

         this.a(300);
      }

   }

   private MonsterDart(int var1, int var2, BuNhin var3) {
      this.o = 1;
      this.i = var1;
      this.j = var2;
      this.q = var3;
      if (var1 > var3.a) {
         this.a(240);
      } else {
         this.a(300);
      }

      this.h = 256;
      this.e = 180;
      this.f = this.h * Res.b(this.e) >> 10;
      this.g = this.h * Res.a(this.e) >> 10;
   }

   public final void a() {
      Domsang var1;
      if (u > 100) {
         var1 = new Domsang(this.i, this.j, 2);
         v.addElement(var1);
      } else if (u > 50 && u <= 100) {
         var1 = new Domsang(this.i, this.j, 5);
         v.addElement(var1);
      } else if (u > 30 && u <= 50) {
         var1 = new Domsang(this.i, this.j, 4);
         v.addElement(var1);
      } else if (u > 0 && u <= 30) {
         var1 = new Domsang(this.i, this.j, 3);
         v.addElement(var1);
      }

      int var2;
      int var3;
      int var4;
      int var5;
      if (this.p != null) {
         var2 = this.p.cx1 - this.i;
         var3 = this.p.cy1 - (this.p.bg >> 1) - this.j;
         ++this.k;
         if ((Res.e(var2) >= 16 || Res.e(var3) >= 16) && this.k <= 60) {
            if (Math.abs((var4 = Res.a(var2, var3)) - this.e) < 90 || var2 * var2 + var3 * var3 > 4096) {
               if (Math.abs(var4 - this.e) < 15) {
                  this.e = var4;
               } else if ((var4 - this.e < 0 || var4 - this.e >= 180) && var4 - this.e >= -180) {
                  this.e = Res.c(this.e - 15);
               } else {
                  this.e = Res.c(this.e + 15);
               }
            }

            if (this.h < 8192) {
               this.h = (short)(this.h + 1024);
            }

            this.f = this.h * Res.b(this.e) >> 10;
            this.g = this.h * Res.a(this.e) >> 10;
            var2 = var2 + this.f >> 10;
            this.i += var2;
            var3 = var3 + this.g >> 10;
            this.j += var3;
            var2 = Res.a(var2, -var3);
            var3 = 0;

            while(true) {
               if (var3 >= ab.length - 1) {
                  var5 = 0;
                  break;
               }

               if (var2 >= ab[var3] && var2 <= ab[var3 + 1]) {
                  var5 = var3 >= 16 ? 0 : var3;
                  break;
               }

               ++var3;
            }

            this.y = var5;
            this.x = z[this.y];
            w = aa[this.y];
         }
      }

      var4 = 0;
      var2 = 0;
      if (this.o != 0) {
         if (this.o == 1) {
            var4 = this.q.a - this.i;
            var2 = this.q.b - 10 - this.j;
            ++this.k;
            if (Res.e(var4) < 16 && Res.e(var2) < 16 || this.k > 60) {
               this.q.d = true;
               Effect2.a.removeElement(this);
               return;
            }
         }
      } else {
         var4 = this.p.cx1 - this.i;
         var2 = this.p.cy1 - 10 - this.j;
         ++this.k;
         if (this.p.statusMe == 5 || this.p.statusMe == 14) {
            this.i += (this.p.cx1 - this.i) / 2;
            this.j += (this.p.cy1 - this.j) / 2;
         }

         if (Res.e(var4) < 16 && Res.e(var2) < 16 || this.k > 60) {
            this.p.a(this.m, this.n, this.r, this.s);
            Effect2.a.removeElement(this);
            return;
         }
      }

      if (Math.abs((var3 = Res.a(var4, var2)) - this.e) < 90 || var4 * var4 + var2 * var2 > 4096) {
         if (Math.abs(var3 - this.e) < 15) {
            this.e = var3;
         } else if ((var3 - this.e < 0 || var3 - this.e >= 180) && var3 - this.e >= -180) {
            this.e = Res.c(this.e - 15);
         } else {
            this.e = Res.c(this.e + 15);
         }
      }

      var4 = var4 + this.f >> 10;
      this.i += var4;
      var4 = var2 + this.g >> 10;
      this.j += var4;

      for(var5 = 0; var5 < v.size(); ++var5) {
         (var1 = (Domsang)v.elementAt(var5)).a();
         if (var1.a > 3) {
            v.removeElementAt(var5);
         }
      }

   }

   public final void a(mGraphics var1) {
      int var2;
      if (this.r) {
         var2 = 7;
         var2 = GameCanvas.w % var2;
         if (this.s == 114) {
            if (var2 < 4) {
               SmallImage.a(var1, 1299, this.i, this.j, 0, 3);
               return;
            }

            SmallImage.a(var1, 1307, this.i, this.j, 0, 3);
            return;
         }

         byte var4;
         if (this.s == 115) {
            var4 = 20;
            if ((var2 = GameCanvas.w % var4) < 4) {
               SmallImage.a(var1, 1379, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.a(var1, 1380, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.a(var1, 1379, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.a(var1, 1382, this.i, this.j, 0, 3);
               return;
            }
         } else if (this.s == 116) {
            var4 = 17;
            if ((var2 = GameCanvas.w % var4) < 4) {
               SmallImage.a(var1, 1399, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.a(var1, 1400, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.a(var1, 1401, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.a(var1, 1402, this.i, this.j, 0, 3);
               return;
            }
         } else if (this.s == 139) {
            var4 = 20;
            if ((var2 = GameCanvas.w % var4) < 4) {
               SmallImage.a(var1, 1459, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.a(var1, 1380, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.a(var1, 1461, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.a(var1, 1382, this.i, this.j, 0, 3);
               return;
            }
         } else if (this.s == 144 || this.s == 163) {
            var4 = 20;
            if ((var2 = GameCanvas.w % var4) < 4) {
               SmallImage.a(var1, 1459, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 8) {
               SmallImage.a(var1, 1380, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 12) {
               SmallImage.a(var1, 1461, this.i, this.j, 0, 3);
               return;
            }

            if (var2 < 16) {
               SmallImage.a(var1, 1382, this.i, this.j, 0, 3);
               return;
            }
         }
      } else {
         if (u > 100) {
            var1.a(GameScr.es, 0, this.x * 23, 31, 23, w, this.i, this.j, 0);
         } else if (u > 50 && u <= 100) {
            var1.a(GameScr.es, 0, 0, 14, 14, w, this.i, this.j, 0);
         } else if (u > 30 && u <= 50) {
            var1.a(GameScr.es, 0, 0, 8, 8, w, this.i, this.j, 0);
         } else if (u > 0 && u <= 30) {
            var1.a(GameScr.es, 0, 0, 8, 8, w, this.i, this.j, 0);
         }

         for(var2 = 0; var2 < v.size(); ++var2) {
            Domsang var5;
            if ((var5 = (Domsang)v.elementAt(var2)) != null) {
               var5.a(var1);
            }
         }
      }

   }

}
