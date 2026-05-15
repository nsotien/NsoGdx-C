package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Scroll {
   private int i;
   private int j;
   public int a;
   public int b;
   private int k;
   private int l;
   private int m;
   private int n;
   public int c;
   public int d;
   public int e;
   public int f;
   private int o;
   private int p;
   public static Scroll g;
   private int q;
   private int r;
   private int[] s = new int[3];
   private boolean t;
   private boolean u;
   private int v;
   private int w;
   public int h;
   private int x;
   private boolean y = true;

   public final void a() {
      this.i = 0;
      this.j = 0;
      this.a = 0;
      this.b = 0;
      this.k = 0;
      this.l = 0;
      this.m = 0;
      this.n = 0;
      this.o = 0;
      this.p = 0;
      this.e = 0;
      this.f = 0;
   }

   public final void a(mGraphics var1, int var2, int var3, int var4, int var5) {
      var1.d(var2, var3, var4, var5 - 1);
      var1.a(-var1.a(), -var1.b());
      var1.a(-this.a, -this.b);
   }

   public final void a(mGraphics var1) {
      var1.d(this.c, this.d, this.e, this.f - 1);
      var1.a(-var1.a(), -var1.b());
      var1.a(-this.a, -this.b);
   }

   public final ScrollResult b() {
      int var1;
      int var2;
      int var3;
      int var4;
      Scroll var5;
      byte var6;
      boolean var7;
      ScrollResult var8;
      if (this.y) {
         var5 = this;
         var1 = this.c;
         var2 = this.d;
         var3 = this.e;
         var4 = this.f;
         if (GameCanvas.p) {
            // FIX: chỉ pickup tracking khi touch DOWN (q=true) trong area, KHÔNG pickup mid-drag.
            // Trước: drag từ ngoài area vào area cũng start tracking → 2 scroll panel cùng pickup
            // 1 drag (vd: kéo info panel bên phải, finger lấn sang list bên trái → cả 2 cuộn).
            if (!this.t && GameCanvas.q && GameCanvas.c(var1, var2, var3, var4)) {
               for(var3 = 0; var3 < var5.s.length; ++var3) {
                  var5.s[0] = GameCanvas.t;
               }

               var5.r = GameCanvas.t;
               var5.t = true;
               var5.w = -1;
               var5.u = var5.v != 0;
               var5.v = 0;
            } else if (this.t) {
               ++this.q;
               if (this.q > 5 && this.r == GameCanvas.t && !this.u) {
                  this.r = -1000;
                  if (this.x > 1) {
                     var3 = (this.j + GameCanvas.t - var2) / this.h;
                     var4 = (this.i + GameCanvas.s - var1) / this.h;
                     this.w = var3 * this.x + var4;
                  } else {
                     this.w = (this.j + GameCanvas.t - var2) / this.h;
                  }
               }

               if ((var3 = GameCanvas.t - this.s[0]) != 0 && this.w != -1) {
                  this.w = -1;
               }

               for(var4 = this.s.length - 1; var4 > 0; --var4) {
                  var5.s[var4] = var5.s[var4 - 1];
               }

               var5.s[0] = GameCanvas.t;
               var5.j -= var3;
               if (var5.j < 0) {
                  var5.j = 0;
               }

               if (var5.j > var5.p) {
                  var5.j = var5.p;
               }

               if (var5.b < 0 || var5.b > var5.p) {
                  var3 /= 2;
               }

               var5.b -= var3;
            }
         }

         var7 = false;
         if (GameCanvas.r && var5.t) {
            var4 = GameCanvas.t - var5.s[0];
            GameCanvas.r = false;
            if (Res.e(var4) < 20 && Res.e(GameCanvas.t - var5.r) < 20 && !var5.u) {
               var5.v = 0;
               var5.j = var5.b;
               var5.r = -1000;
               if (var5.x > 1) {
                  var2 = (var5.j + GameCanvas.t - var2) / var5.h;
                  var1 = (var5.i + GameCanvas.s - var1) / var5.h;
                  var5.w = var2 * var5.x + var1;
               } else {
                  var5.w = (var5.j + GameCanvas.t - var2) / var5.h;
               }

               var5.q = 0;
               var7 = true;
            } else if (var5.w != -1 && var5.q > 5) {
               var5.q = 0;
               var7 = true;
            } else if (var5.w == -1 && !var5.u) {
               if (var5.b < 0) {
                  var5.j = 0;
               } else if (var5.b > var5.p) {
                  var5.j = var5.p;
               } else {
                  if ((var2 = GameCanvas.t - var5.s[0] + (var5.s[0] - var5.s[1]) + (var5.s[1] - var5.s[2])) > 10) {
                     var6 = 10;
                  } else if (var2 < -10) {
                     var6 = -10;
                  } else {
                     var6 = 0;
                  }

                  var5.v = -var6 * 100;
               }
            }

            var5.t = false;
            var5.q = 0;
            GameCanvas.r = false;
         }

         (var8 = new ScrollResult()).b = var5.w;
         var8.c = var7;
         var8.a = var5.t;
         return var8;
      } else {
         var5 = this;
         var1 = this.c;
         var2 = this.d;
         var3 = this.e;
         var4 = this.f;
         if (GameCanvas.p) {
            // FIX: chỉ pickup tracking khi touch DOWN (q=true), tránh pickup mid-drag từ panel khác.
            if (!this.t && GameCanvas.q && GameCanvas.c(var1, var2, var3, var4)) {
               for(var3 = 0; var3 < var5.s.length; ++var3) {
                  var5.s[0] = GameCanvas.s;
               }

               var5.r = GameCanvas.s;
               var5.t = true;
               var5.w = -1;
               var5.u = var5.v != 0;
               var5.v = 0;
            } else if (this.t) {
               ++this.q;
               if (this.q > 5 && this.r == GameCanvas.s && !this.u) {
                  this.r = -1000;
                  this.w = (this.i + GameCanvas.s - var1) / this.h;
               }

               if ((var3 = GameCanvas.s - this.s[0]) != 0 && this.w != -1) {
                  this.w = -1;
               }

               for(var4 = this.s.length - 1; var4 > 0; --var4) {
                  var5.s[var4] = var5.s[var4 - 1];
               }

               var5.s[0] = GameCanvas.s;
               var5.i -= var3;
               if (var5.i < 0) {
                  var5.i = 0;
               }

               if (var5.i > var5.o) {
                  var5.i = var5.o;
               }

               if (var5.a < 0 || var5.a > var5.o) {
                  var3 /= 2;
               }

               var5.a -= var3;
            }
         }

         var7 = false;
         if (GameCanvas.r && var5.t) {
            var4 = GameCanvas.s - var5.s[0];
            GameCanvas.r = false;
            if (Res.e(var4) < 20 && Res.e(GameCanvas.s - var5.r) < 20 && !var5.u) {
               var5.v = 0;
               var5.i = var5.a;
               var5.r = -1000;
               var5.w = (var5.i + GameCanvas.s - var1) / var5.h;
               var5.q = 0;
               var7 = true;
            } else if (var5.w != -1 && var5.q > 5) {
               var5.q = 0;
               var7 = true;
            } else if (var5.w == -1 && !var5.u) {
               if (var5.a < 0) {
                  var5.i = 0;
               } else if (var5.a > var5.o) {
                  var5.i = var5.o;
               } else {
                  if ((var2 = GameCanvas.s - var5.s[0] + (var5.s[0] - var5.s[1]) + (var5.s[1] - var5.s[2])) > 10) {
                     var6 = 10;
                  } else if (var2 < -10) {
                     var6 = -10;
                  } else {
                     var6 = 0;
                  }

                  var5.v = -var6 * 100;
               }
            }

            var5.t = false;
            var5.q = 0;
            GameCanvas.r = false;
         }

         (var8 = new ScrollResult()).b = var5.w;
         var8.c = var7;
         var8.a = var5.t;
         return var8;
      }
   }

   public final void c() {
      if (this.v != 0 && !this.t) {
         if (this.y) {
            this.j += this.v / 100;
            if (this.j < 0) {
               this.j = 0;
            } else if (this.j > this.p) {
               this.j = this.p;
            } else {
               this.b = this.j;
            }
         } else {
            this.i += this.v / 100;
            if (this.i < 0) {
               this.i = 0;
            } else if (this.i > this.o) {
               this.i = this.o;
            } else {
               this.a = this.i;
            }
         }

         this.v = this.v * 9 / 10;
         if (this.v < 100 && this.v > -100) {
            this.v = 0;
         }
      }

      if (this.a != this.i && !this.t) {
         this.k = this.i - this.a << 2;
         this.m += this.k;
         this.a += this.m >> 4;
         this.m &= 15;
      }

      if (this.b != this.j && !this.t) {
         this.l = this.j - this.b << 2;
         this.n += this.l;
         this.b += this.n >> 4;
         this.n &= 15;
      }

   }

   public final void a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, int var8) {
      this.c = var3;
      this.d = var4;
      this.h = var2;
      this.e = var5;
      this.f = var6;
      this.y = var7;
      this.x = var8;
      if (var7) {
         this.p = var1 * var2 - var6;
      } else {
         this.o = var1 * var2 - var5;
      }

      if (this.p < 0) {
         this.p = 0;
      }

      if (this.o < 0) {
         this.o = 0;
      }

   }

   public final void a(int var1) {
      if (this.y) {
         var1 -= (this.f - this.h) / 2;
         this.j = var1;
         if (this.j < 0) {
            this.j = 0;
         }

         if (this.j > this.p) {
            this.j = this.p;
            return;
         }
      } else {
         var1 -= (this.e - this.h) / 2;
         this.i = var1;
         if (this.i < 0) {
            this.i = 0;
         }

         if (this.i > this.o) {
            this.i = this.o;
         }
      }

   }

}
