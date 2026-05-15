package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

public final class TField implements IActionListener {
   public int a;
   public int b;
   public int c;
   public int d;
   public boolean e;
   private boolean m = false;
   private static int n = 2;
   private static final int[] o = new int[]{18, 14, 11, 9, 6, 4, 2};
   private static int p = 0;
   private static String[] q = new String[]{" 0", ".,@?!_1\"/$-():*+<=>;%&~#%^&*{}[];'/1", "abc2áàảãạâấầẩẫậăắằẳẵặ2", "def3đéèẻẽẹêếềểễệ3", "ghi4íìỉĩị4", "jkl5", "mno6óòỏõọôốồổỗộơớờởỡợ6", "pqrs7", "tuv8úùủũụưứừửữự8", "wxyz9ýỳỷỹỵ9", "*", "#"};
   private static String[] r = new String[]{"0", "1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", "0", "0"};
   public String f = "";
   public String g = "";
   private String s = "";
   private String t = "";
   private String u = "";
   private int v = 0;
   private int w = 0;
   private int x = 500;
   private int y = 0;
   private int z = -1984;
   private int aa = 0;
   private int ab = 0;
   private int ac = 10;
   private int ad = 0;
   public static boolean h;
   private static int ae;
   private int af = 0;
   private static int ag;
   public static Canvas i;
   public static MIDlet j;
   public boolean ij;
   public String k = "";
   public Command1 l;
   private Command OK;

   private static boolean isInputShowing = false;

   public final void a() {
      // V8 approach: use LibGDX native text input dialog
      if (com.badlogic.gdx.Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.Desktop) {
         this.e = true;
         return;
      }
      if (isInputShowing) return;
      isInputShowing = true;
      final TField self = this;
      com.badlogic.gdx.Gdx.app.postRunnable(new Runnable() {
         public void run() {
            com.badlogic.gdx.Gdx.input.getTextInput(new com.badlogic.gdx.Input.TextInputListener() {
               public void input(String text) {
                  // Sync đầy đủ: set s, v, gọi f() để tạo t="****" cho password mode
                  if (text == null) text = "";
                  self.a(text);
                  isInputShowing = false;
               }
               public void canceled() {
                  isInputShowing = false;
               }
            }, self.k, self.s, "");
         }
      });
   }

   public final void init() {
      this.a();
      this.k = "chat";
      this.a = 16;
      this.c = MotherCanvas.a.b() - 32;
      this.d = mScreen.d + 2;
      this.e = true;
      this.b(40);
   }

   public static boolean a(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   public TField() {
      this.s = "";
      p = mFont.o.c() + 1;
      this.l = new Command1(TextGame.aw, this, 1000, (Object)null);
      ae = 0;
      if (RMS.c("qwerty") == 1) {
         h = true;
      }

   }

   public final void b() {
      if (this.v > 0 && this.s.length() > 0) {
         this.s = this.s.substring(0, this.v - 1) + this.s.substring(this.v, this.s.length());
         --this.v;
         this.e();
         this.f();
      }

   }

   private void e() {
      if (this.ad == 2) {
         this.u = this.t;
      } else {
         this.u = this.s;
      }

      if (this.y < 0 && mFont.o.a(this.u) + this.y < this.c - 4 - 13) {
         this.y = this.c - 10 - mFont.o.a(this.u);
      }

      if (this.y + mFont.o.a(this.u.substring(0, this.v)) <= 0) {
         this.y = -mFont.o.a(this.u.substring(0, this.v));
         this.y += 40;
      } else if (this.y + mFont.o.a(this.u.substring(0, this.v)) >= this.c - 12) {
         this.y = this.c - 10 - mFont.o.a(this.u.substring(0, this.v)) - 8;
      }

      if (this.y > 0) {
         this.y = 0;
      }

   }

   private void d(int var1) {
      if ((this.ad != 2 && this.ad != 3 || var1 >= 48 && var1 <= 57 || var1 >= 65 && var1 <= 90 || var1 >= 97 && var1 <= 122) && this.s.length() < this.x) {
         String var2 = this.s.substring(0, this.v) + (char)var1;
         if (this.v < this.s.length()) {
            var2 = var2 + this.s.substring(this.v, this.s.length());
         }

         this.s = var2;
         ++this.v;
         this.f();
         this.e();
      }

   }

   public final boolean a(int var1) {
      if (var1 != 8 && var1 != -8 && var1 != 204) {
         if (var1 >= 65 && var1 <= 122 && !h) {
            h = true;
            ae = 0;
            RMS.a("qwerty", 1);
         }

         if (h) {
            if (var1 == 45) {
               if (var1 == this.z && this.aa < o[n]) {
                  this.s = this.s.substring(0, this.v - 1) + '_';
                  this.u = this.s;
                  this.f();
                  this.e();
                  this.z = -1984;
                  return false;
               }

               this.z = 45;
            }

            if (var1 >= 32) {
               this.d(var1);
               return false;
            }
         }

         if (var1 == ag) {
            ++this.af;
            if (this.af > 3) {
               this.af = 0;
            }

            this.aa = 1;
            this.z = var1;
            return false;
         } else {
            if (var1 == 42) {
               var1 = 58;
            }

            if (var1 == 35) {
               var1 = 59;
            }

            if (var1 >= 48 && var1 <= 59) {
               if (this.ad != 0 && this.ad != 2 && this.ad != 3) {
                  if (this.ad == 1) {
                     this.d(var1);
                     this.aa = 1;
                  }
               } else {
                  String[] var2;
                  if (this.ad != 2 && this.ad != 3) {
                     var2 = q;
                  } else {
                     var2 = r;
                  }

                  char var3;
                  String var5;
                  if (var1 == this.z) {
                     this.ab = (this.ab + 1) % var2[var1 - 48].length();
                     var3 = var2[var1 - 48].charAt(this.ab);
                     if (this.af == 0) {
                        var3 = Character.toLowerCase(var3);
                     } else if (this.af == 1) {
                        var3 = Character.toUpperCase(var3);
                     } else if (this.af == 2) {
                        var3 = Character.toUpperCase(var3);
                     } else {
                        var3 = var2[var1 - 48].charAt(var2[var1 - 48].length() - 1);
                     }

                     var5 = this.s.substring(0, this.v - 1) + var3;
                     if (this.v < this.s.length()) {
                        var5 = var5 + this.s.substring(this.v, this.s.length());
                     }

                     this.s = var5;
                     this.aa = o[n];
                     this.f();
                  } else if (this.s.length() < this.x) {
                     if (this.af == 1 && this.z != -1984) {
                        this.af = 0;
                     }

                     this.ab = 0;
                     var3 = var2[var1 - 48].charAt(this.ab);
                     if (this.af == 0) {
                        var3 = Character.toLowerCase(var3);
                     } else if (this.af == 1) {
                        var3 = Character.toUpperCase(var3);
                     } else if (this.af == 2) {
                        var3 = Character.toUpperCase(var3);
                     } else {
                        var3 = var2[var1 - 48].charAt(var2[var1 - 48].length() - 1);
                     }

                     var5 = this.s.substring(0, this.v) + var3;
                     if (this.v < this.s.length()) {
                        var5 = var5 + this.s.substring(this.v, this.s.length());
                     }

                     this.s = var5;
                     this.aa = o[n];
                     ++this.v;
                     this.f();
                     this.e();
                  }

                  this.z = var1;
               }
            } else {
               this.ab = 0;
               this.z = -1984;
               if (var1 == 14) {
                  if (this.v > 0) {
                     --this.v;
                     this.e();
                     this.ac = 10;
                     return false;
                  }
               } else if (var1 == 15) {
                  if (this.v < this.s.length()) {
                     ++this.v;
                     this.e();
                     this.ac = 10;
                     return false;
                  }
               } else {
                  if (var1 == 19) {
                     this.b();
                     return false;
                  }

                  this.z = var1;
               }
            }

            return true;
         }
      } else {
         this.b();
         return true;
      }
   }

   public final boolean e(int var1) {
      if (var1 == 8 || var1 == -8 || var1 == 204 || var1 == 127) {
         this.b();
         return true;
      } else if (var1 == -5 || var1 == 10 || var1 == 13) {
         return false;
      } else if (var1 >= 32 && var1 <= 126) {
         this.z = -1984;
         this.aa = 0;
         this.ab = 0;
         this.d(var1);
         return true;
      } else {
         return false;
      }
   }

   public final void a(mGraphics var1) {
      var1.d(0, 0, GameCanvas.aa, GameCanvas.ab);
      boolean var2 = this.e;
      if (this.ad == 2) {
         this.u = this.t;
      } else {
         this.u = this.s;
      }

      if (this.u.equals("")) {
         this.u = this.g;
      }

      Paint.a(var1, var2, this.a, this.b, this.c, this.d, 4 + this.y + this.a, this.b + (this.d - mFont.o.c()) / 2, this.u);
      var1.d(this.a + 3, this.b + 1, this.c - 4, this.d - 4);
      var1.a(0);
      if (this.e && this.aa == 0 && (this.ac > 0 || this.w / 5 % 2 == 0)) {
         var1.a(11184810);
         var1.c(5 + this.y + this.a + mFont.o.a(this.u.substring(0, this.v)) - 1, this.b + (this.d - p) / 2 + 1, 1, p);
      }

   }

   public final void b(mGraphics var1) {
      boolean var2 = this.e;
      if (this.ad == 2) {
         this.u = this.t;
      } else {
         this.u = this.s;
      }

      if (this.u.equals("")) {
         this.u = this.g;
      }

      Paint.a(var1, var2, this.a, this.b, this.c, 4 + this.y + this.a, this.b + (this.d - mFont.o.c()) / 2, this.u);
      var1.a(0);
      if (this.e && this.aa == 0 && (this.ac > 0 || this.w / 5 % 2 == 0)) {
         var1.a(11184810);
         var1.c(5 + this.y + this.a + mFont.o.a(this.u.substring(0, this.v)) - 1, this.b + (this.d - p) / 2 + 1, 1, p);
      }

   }

   private void f() {
      if (this.ad == 2) {
         this.t = "";

         for(int var1 = 0; var1 < this.s.length(); ++var1) {
            this.t = this.t + "*";
         }

         if (this.aa > 0 && this.v > 0) {
            this.t = this.t.substring(0, this.v - 1) + this.s.charAt(this.v - 1) + this.t.substring(this.v, this.t.length());
         }
      }

   }

   public final void c() {
      ++this.w;
      if (this.aa > 0) {
         --this.aa;
         if (this.aa == 0) {
            this.ab = 0;
            if (this.af == 1 && this.z != ag) {
               this.af = 0;
            }

            this.z = -1984;
            this.f();
         }
      }

      if (this.ac > 0) {
         --this.ac;
      }

      if (GameCanvas.r) {
         if (GameCanvas.currentScreen == RegisterScr.h) {
            if (RegisterScr.h == null) {
               RegisterScr.h = new RegisterScr();
            }

            int var1 = RegisterScr.h.i.b;
            if (!GameCanvas.b(this.a, this.b - var1, this.c, this.d)) {
               this.e = false;
               return;
            }

            this.a();
         } else {
            if (GameCanvas.b(this.a, this.b, this.c, this.d)) {
               this.a();
               return;
            }

            this.e = false;
         }
      }

   }

   public final String d() {
      return this.s;
   }

   public final void a(String var1) {
      if (var1 != null) {
         this.z = -1984;
         this.aa = 0;
         this.ab = 0;
         this.s = var1;
         this.u = var1;
         this.f();
         this.v = var1.length();
         this.e();
      }

   }

   public final void b(int var1) {
      this.x = var1;
   }

   public final void c(int var1) {
      this.ad = var1;
   }

   public final void a(int var1, Object var2) {
      switch (var1) {
         case 1000:
            this.b();
         default:
      }
   }

   static {
      String[] var10000 = new String[]{"abc", "Abc", "ABC", "123"};
      ag = 11;
      int[][] var2 = new int[][]{{32, 48}, {49, 69}, {50, 84}, {51, 85}, {52, 68}, {53, 71}, {54, 74}, {55, 67}, {56, 66}, {57, 77}, {42, 128}, {35, 137}, {33, 113}, {63, 97}, {64, 121, 122}, {46, 111}, {44, 108}};
   }
}
