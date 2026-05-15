package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Lightning extends Effect2 {
   private int[] e = new int[]{16579837, 11188220};
   private MyVector f = new MyVector();
   private MyVector[] g;
   private EPosition h;
   private long i = 0L;
   private boolean j = false;
   private boolean k = true;
   private int l = 0;
   private int m = 0;
   private int n = 0;
   private int o = 7;

   public static void a(MyVector var0, EPosition var1, boolean var2, int var3) {
      Lightning var5;
      (var5 = new Lightning()).e[1] = var3;

      for(var3 = 0; var3 < var0.size(); ++var3) {
         EPosition var4;
         if ((var4 = (EPosition)var0.elementAt(var3)) != null && (Res.e(var4.a - var1.a) >= 100 || Res.e(var4.b - var1.b) >= 50)) {
            var0.removeElementAt(var3);
         }
      }

      var5.a(var0, var1, true);
      Effect2.a.addElement(var5);
   }

   private void a(MyVector var1, EPosition var2, boolean var3) {
      if (var1.size() != 0) {
         this.j = var3;
         MyVector var4;
         int var8;
         int var9;
         EPosition var10;
         int var11;
         if (!var3) {
            var4 = var1;
            var8 = var1.size();

            for(var9 = 0; var9 < var8 - 1; ++var9) {
               var10 = (EPosition)var4.elementAt(var9);

               for(var11 = var9 + 1; var11 < var8; ++var11) {
                  EPosition var5 = (EPosition)var4.elementAt(var11);
                  if (var10.a > var5.a) {
                     var4.setElementAt(var10, var11);
                     var4.setElementAt(var5, var9);
                     var10 = var5;
                  }
               }
            }
         }

         this.f = var1;
         this.h = var2;
         this.g = new MyVector[var1.size()];

         int var16;
         for(var16 = 0; var16 < this.g.length; ++var16) {
            this.g[var16] = new MyVector();
         }

         var2.c = -1;
         this.g[0].addElement(var2);
         var16 = -1;

         int var17;
         int var6;
         int var12;
         int var14;
         int var15;
         EPosition var19;
         int var23;
         for(var17 = 0; var17 < var1.size(); ++var17) {
            var6 = var2.a;
            int var7 = var2.b;
            if (var3 && var16 != -1) {
               var6 = (var19 = (EPosition)var1.elementAt(var16)).a;
               var7 = var19.b;
            }

            int var20;
            if (var3) {
               ++var16;
            } else {
               var4 = var1;
               var8 = 0;

               for(var9 = 0; var9 < var4.size(); ++var9) {
                  if (((EPosition)var4.elementAt(var9)).e == -1) {
                     ++var8;
                  }
               }

               int var10000;
               if (var8 != 0) {
                  var8 = Res.d(var8);
                  var9 = 0;
                  var20 = 0;

                  while(true) {
                     if (var20 >= var4.size()) {
                        var10000 = -1;
                        break;
                     }

                     EPosition var22;
                     if ((var22 = (EPosition)var4.elementAt(var20)).e == -1) {
                        if (var8 == var9) {
                           var22.e = 0;
                           var10000 = var20;
                           break;
                        }

                        ++var9;
                     }

                     ++var20;
                  }
               } else {
                  var10000 = -1;
               }

               var16 = var10000;
            }

            var8 = this.g[var16].size() - 1;
            EPosition var21;
            var20 = Res.a((var21 = (EPosition)var1.elementAt(var16)).a - var6, -(var21.b - var7));
            var11 = Res.d(15) + 10;
            var12 = 0;
            boolean var13 = false;

            while(true) {
               var23 = 0;
               if (var12 != 0) {
                  var23 = var20 - 5 + Res.d(10);
               }

               var23 = Res.c(var23);
               var14 = var11 * var12 * Res.b(var23) >> 10;
               var15 = -(var11 * var12 * Res.a(var23)) >> 10;
               EPosition var24 = new EPosition(var6 + var14, var7 + var15, var8++);
               this.g[var16].addElement(var24);
               if (Res.a(var6, var7, var6 + var14, var7 + var15) >= Res.a(var6, var7, var21.a, var21.b) - 20) {
                  break;
               }

               ++var12;
            }
         }

         for(var17 = 0; var17 < this.g.length; ++var17) {
            var6 = this.g[var17].size();
            EPosition var18;
            (var18 = (EPosition)var1.elementAt(var17)).c = (byte)(this.g[var17].size() - 1);
            var18.e = -1;
            (var19 = new EPosition(var18.a, var18.b, var18.c)).e = -1;
            this.g[var17].addElement(var19);

            for(var9 = 1; var9 < var6; ++var9) {
               var10 = (EPosition)this.g[var17].elementAt(var9);
               var11 = Res.d(2);

               for(var12 = 0; var12 < var11; ++var12) {
                  var23 = 180 + Res.d(180);
                  var15 = (var14 = 5 + Res.d(10)) * Res.b(Res.c(var23)) >> 10;
                  var23 = -(var14 * Res.a(Res.c(var23))) >> 10;
                  (var2 = new EPosition(var10.a + var15, var10.b + var23, var9)).e = 0;
                  this.g[var17].addElement(var2);
               }
            }
         }
      }

   }

   public final void a() {
      if (this.h == null) {
         Effect2.b.addElement(this);
      } else {
         try {
            if (GameCanvas.w % 2 == 1) {
               this.h.c = -1;
               this.h.e = -1;

               for(int var1 = 0; var1 < this.f.size(); ++var1) {
                  EPosition var2;
                  (var2 = (EPosition)this.f.elementAt(var1)).e = -1;
                  var2.c = -1;
               }

               if (this.j && this.k && this.f.size() > 1 && System.currentTimeMillis() / 10L - this.i > 30L) {
                  this.i = System.currentTimeMillis() / 10L;
                  this.h = (EPosition)this.f.elementAt(0);
                  this.f.removeElementAt(0);
               }

               this.a(this.f, this.h, this.j);
               if (this.l > 3) {
                  this.o = 7;
                  Effect2.a.removeElement(this);
               }

               ++this.l;
               return;
            }
         } catch (Exception var3) {
            ;
         }
      }

   }

   public final void a(mGraphics var1) {
      this.n = 0;
      ++this.m;
      if (this.m >= 12) {
         this.m = 0;
      }

      if (this.g != null) {
         for(int var2 = 0; var2 < this.g.length; ++var2) {
            for(int var3 = 0; var3 < this.g[var2].size(); ++var3) {
               EPosition var4;
               if ((var4 = (EPosition)this.g[var2].elementAt(var3)).c >= 0 && var4.c < this.g[var2].size()) {
                  EPosition var5 = (EPosition)this.g[var2].elementAt(var4.c);
                  if (GameCanvas.e(var4.a, var4.b) && GameCanvas.e(var5.a, var5.b)) {
                     var1.a(this.e[0]);
                     var1.a(var4.a, var4.b, var5.a, var5.b);
                     if (var4.e == -1) {
                        var1.a(this.e[1]);
                        var1.a(var4.a - 1, var4.b, var5.a - 1, var5.b);
                        if (this.j && this.k) {
                           var1.a(var4.a + 1, var4.b, var5.a + 1, var5.b);
                        }
                     }
                  }

                  if (this.j && this.k) {
                     ++this.n;
                     if (this.n >= this.o) {
                        this.o += 7;
                        return;
                     }
                  }
               }
            }

            EPosition var8;
            ++(var8 = (EPosition)this.f.elementAt(var2)).d;
            if (var8.d >= 12) {
               var8.d = 0;
            }
         }
      }

   }

}
