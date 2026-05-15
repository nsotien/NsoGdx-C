package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class Menu implements IActionListener {
   public boolean a;
   private MyVector f;
   public int b;
   private int g;
   private int h;
   private int i;
   private int j;
   public int k;
   private static int l;
   private static int m;
   private static int n;
   private static int o;
   private Command1 p;
   private Command1 q;
   private Command1 r;
   private static Image s = GameCanvas.c("/hd/btnlBig0.png");
   private static Image t = GameCanvas.c("/hd/btnlBig1.png");
   boolean c;
   public boolean d;
   private int u;
   private int v;
   private int w;
   private int[] x;
   private boolean y;
   private boolean z;
   private int aa;
   private int ab;
   public byte e;
   private int ac;
   private int ad;

   public Menu() {
      this.p = new Command1(TextGame.doa, 0);
      this.q = GameCanvas.g ? null : new Command1(TextGame.ah, 0, GameCanvas.aa - 71, GameCanvas.ab - mScreen.f + 1);
      this.r = null;
      this.x = new int[3];
   }

   public final void a(MyVector var1) {
      this.c = false;
      this.d = false;
      ChatPopup.f = null;
      InfoDlg.b();
      if (var1.size() != 0) {
         this.f = var1;
         this.i = 60;
         this.j = 60;

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            Command1 var3 = (Command1)var1.elementAt(var2);
            if (mFont.j.a(var3.a) > this.i - 8) {
               var3.b = mFont.j.b(var3.a, this.i - 8);
            }
         }

         this.g = (GameCanvas.aa - var1.size() * this.i) / 2;
         if (this.g < 1) {
            this.g = 1;
         }

         this.h = GameCanvas.ab - this.j - (Paint.f + 1);
         if (GameCanvas.g) {
            this.h -= 3;
         }

         this.k = this.h;
         this.a = true;
         this.b = 0;
         if ((n = this.f.size() * this.i - GameCanvas.aa) < 0) {
            n = 0;
         }

         l = 0;
         m = 0;
         o = 50;
         this.u = var1.size() * this.i - 1;
         if (this.u > GameCanvas.aa - 2) {
            this.u = GameCanvas.aa - 2;
         }

         if (GameCanvas.g) {
            this.b = -1;
         }
      }

   }

   public final void selectFirstNpcMenu() {
      if (GameCanvas.g && this.f != null && this.f.size() > 0) {
         this.b = 0;
      }
   }

   public final void a() {
      if (this.a) {
         if (this.e > 0) {
            --this.e;
         }

         boolean var1 = false;
         if (!GameCanvas.n[2] && !GameCanvas.n[4]) {
            if (!GameCanvas.n[8] && !GameCanvas.n[6]) {
               if (GameCanvas.n[5]) {
                  if (this.r != null) {
                     if (this.r.d > 0) {
                        if (this.r.c == GameScr.gI()) {
                           GameScr.gI().b(this.r.d, this.r.k);
                        } else {
                           this.a(this.r.d, this.r.k);
                        }
                     }
                  } else {
                     this.aa = 2;
                  }
               } else if (GameCanvas.n[12]) {
                  if (this.p.d > 0) {
                     this.a(this.p.d, this.p.k);
                  } else {
                     this.aa = 2;
                  }
               } else if (!this.c && (GameCanvas.n[13] || mScreen.a(this.q))) {
                  this.a = false;
                  InfoDlg.b();
                  if (this.d) {
                     Service.gI().menu((byte)1, Char.getMyChar().npcFocus.npcTemplate.npcTemplateId, -1, 0);
                     this.d = false;
                  }
               }
            } else {
               var1 = true;
               ++this.b;
               if (this.b > this.f.size() - 1) {
                  this.b = 0;
               }
            }
         } else {
            var1 = true;
            --this.b;
            if (this.b < 0) {
               this.b = this.f.size() - 1;
            }
         }

         this.r = null;
         if (GameScr.cm && !GameCanvas.g) {
            ChatTab var2 = null;
            Command1 var3 = null;
            if (this.b != -1) {
               var3 = (Command1)this.f.elementAt(this.b);
               if ((var2 = ChatManager.d().a(var3.a)) != null && var2.a == 2) {
                  this.r = new Command1(TextGame.ai, this, 1000, var2);
               }
            }
         }

         if (var1) {
            if ((l = this.b * this.i + this.i - GameCanvas.aa / 2) > n) {
               l = n;
            }

            if (l < 0) {
               l = 0;
            }

            if (this.b == this.f.size() - 1 || this.b == 0) {
               m = l;
            }
         }

         if (this.e <= 0 && !this.c && GameCanvas.r && !GameCanvas.c(this.g, this.h, this.u, this.j) && !this.y) {
            this.v = this.w = 0;
            this.y = false;
            this.a = false;
            GameCanvas.r = false;
         } else {
            int var4;
            int var5;
            if (GameCanvas.p) {
               if (!this.y && GameCanvas.c(this.g, this.h, this.u, this.j)) {
                  for(var4 = 0; var4 < this.x.length; ++var4) {
                     this.x[0] = GameCanvas.s;
                  }

                  this.w = GameCanvas.s;
                  this.y = true;
                  this.z = this.ab != 0;
                  this.ab = 0;
               } else if (this.y) {
                  ++this.v;
                  if (this.v > 5 && this.w == GameCanvas.s && !this.z) {
                     this.w = -1000;
                     this.b = (l + GameCanvas.s - this.g) / this.i;
                  }

                  if ((var4 = GameCanvas.s - this.x[0]) != 0 && this.b != -1) {
                     this.b = -1;
                  }

                  for(var5 = this.x.length - 1; var5 > 0; --var5) {
                     this.x[var5] = this.x[var5 - 1];
                  }

                  this.x[0] = GameCanvas.s;
                  if ((l -= var4) < 0) {
                     l = 0;
                  }

                  if (l > n) {
                     l = n;
                  }

                  if (m < 0 || m > n) {
                     var4 /= 2;
                  }

                  m -= var4;
               }
            }

            if (GameCanvas.r && this.y) {
               var4 = GameCanvas.s - this.x[0];
               GameCanvas.r = false;
               if (Res.e(var4) < 20 && Res.e(GameCanvas.s - this.w) < 20 && !this.z) {
                  this.ab = 0;
                  l = m;
                  this.w = -1000;
                  this.b = (l + GameCanvas.s - this.g) / this.i;
                  this.v = 0;
                  this.aa = 10;
               } else if (this.b != -1 && this.v > 5) {
                  this.v = 0;
                  this.aa = 1;
               } else if (this.b == -1 && !this.z) {
                  if (m < 0) {
                     l = 0;
                  } else if (m > n) {
                     l = n;
                  } else {
                     byte var6;
                     if ((var5 = GameCanvas.s - this.x[0] + (this.x[0] - this.x[1]) + (this.x[1] - this.x[2])) > 10) {
                        var6 = 10;
                     } else if (var5 < -10) {
                        var6 = -10;
                     } else {
                        var6 = 0;
                     }

                     this.ab = -var6 * 100;
                  }
               }

               this.y = false;
               this.v = 0;
               GameCanvas.r = false;
            }

            GameCanvas.h();
            GameCanvas.i();
         }
      }

   }

   public final void a(mGraphics var1) {
      try {
         var1.a(-var1.a(), -var1.b());
         var1.a(-m, 0);
         int var2;
         String[] var3;
         int var4;
         int var5;
         if (GameCanvas.g) {
            for(var2 = 0; var2 < this.f.size(); ++var2) {
               if (var2 == this.b) {
                  var1.a(t, this.g + var2 * this.i + 1, this.k + 1, 0);
               } else {
                  var1.a(s, this.g + var2 * this.i + 1, this.k + 1, 0);
               }

               if ((var3 = ((Command1)this.f.elementAt(var2)).b) == null) {
                  var3 = new String[]{((Command1)this.f.elementAt(var2)).a};
               }

               var4 = this.k + (this.j - var3.length * 14) / 2 + 1;

               for(var5 = 0; var5 < var3.length; ++var5) {
                  if (GameScr.cm) {
                     if (ChatManager.d().d(var3[var5])) {
                        if (GameCanvas.w % 10 > 5) {
                           mFont.l.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                        } else {
                           mFont.j.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                        }
                     } else {
                        mFont.j.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                     }
                  } else {
                     mFont.j.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                  }
               }
            }
         } else {
            for(var2 = 0; var2 < this.f.size(); ++var2) {
               if (var2 == this.b) {
                  var1.a(t, this.g + var2 * this.i + 1, this.k + 1 - 23, 0);
               } else {
                  var1.a(s, this.g + var2 * this.i + 1, this.k + 1 - 23, 0);
               }

               if ((var3 = ((Command1)this.f.elementAt(var2)).b) == null) {
                  var3 = new String[]{((Command1)this.f.elementAt(var2)).a};
               }

               var4 = this.k + (this.j - var3.length * 14) / 2 + 1 - 23;

               for(var5 = 0; var5 < var3.length; ++var5) {
                  if (GameScr.cm) {
                     if (ChatManager.d().d(var3[var5])) {
                        if (GameCanvas.w % 10 > 5) {
                           mFont.l.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                        } else {
                           mFont.j.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                        }
                     } else {
                        mFont.j.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                     }
                  } else {
                     mFont.j.a(var1, var3[var5], this.g + var2 * this.i + this.i / 2 - 2, var4 + var5 * 14, 2);
                  }
               }
            }
         }

         var1.a(-var1.a(), -var1.b());
      } catch (Exception var6) {
         ;
      }

   }

   public final void b() {
      if (this.ab != 0 && !this.y) {
         if ((l += this.ab / 100) < 0) {
            l = 0;
         } else if (l > n) {
            l = n;
         } else {
            m = l;
         }

         this.ab = this.ab * 9 / 10;
         if (this.ab < 100 && this.ab > -100) {
            this.ab = 0;
         }
      }

      if (m != l && !this.y) {
         this.ac = l - m << 2;
         this.ad += this.ac;
         m += this.ad >> 4;
         this.ad &= 15;
      }

      if (this.k > this.h) {
         int var1;
         if ((var1 = this.k - this.h >> 1) < 1) {
            var1 = 1;
         }

         this.k -= var1;
      }

      if (o != 0 && (o >>= 1) < 0) {
         o = 0;
      }

      if (this.aa > 0) {
         --this.aa;
         GameScr.cm = false;
         if (this.aa == 0) {
            this.a = false;
            Command1 var2;
            if (this.b >= 0 && (var2 = (Command1)this.f.elementAt(this.b)) != null) {
               var2.a();
            }
         }
      }

   }

   public final void a(int var1, Object var2) {
      if (var1 == 1000) {
         ChatTab var4 = (ChatTab)var2;
         this.f.removeAllElements();
         ChatManager.d().e(var4.b);
         ChatManager.d().a.removeElement(var4);

         for(var1 = 0; var1 < ChatManager.d().a.size(); ++var1) {
            ChatTab var5 = (ChatTab)ChatManager.d().a.elementAt(var1);
            this.f.addElement(new Command1(var5.b, (IActionListener)null, 12001, new Integer(var1)));
         }

         this.f.addElement(new Command1(TextGame.pr, (IActionListener)null, 12008, (Object)null));

         for(var1 = 0; var1 < this.f.size(); ++var1) {
            Command1 var6 = (Command1)this.f.elementAt(var1);
            if (mFont.j.a(var6.a) > this.i - 8) {
               var6.b = mFont.j.b(var6.a, this.i - 8);
            }
         }

         n = this.f.size() * this.i - GameCanvas.aa;
         if ((l = this.b * this.i + this.i - GameCanvas.aa / 2) > n) {
            l = n;
         }

         if (l < 0) {
            l = 0;
         }

         if (this.b == this.f.size() - 1 || this.b == 0) {
            m = l;
         }
      }

   }

}
