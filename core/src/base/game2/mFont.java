package base.game2;

import com.monkey.nso.lib.SysTemFont;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Image;

import static com.monkey.nso.NSO.zoomLevel;

/**
 * Hybrid mFont: TGAME field names (a, b, c...) + V8 SysTemFont for zoom >= 2.
 * TGAME code calls mFont.e.a(g, text, x, y, align) — unchanged.
 * When zoomLevel >= 2, SysTemFont renders TTF instead of bitmap.
 */
public final class mFont {
   private int u;         // letter spacing
   private int v;         // char height
   private Image w;       // font image (bitmap mode)
   private String x;      // charset string
   private int[][] y;     // glyph positions [index][x, y, w, h]
   private String aa;     // image path
   public SysTemFont sysFont;   // V8 SysTemFont (TTF mode, null if bitmap)

   private static String z = " 0123456789+-*='_?.,<>/[]{}!@#$%^&*():aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";

   // === TGAME static font fields (a-t) ===
   public static mFont a;  // tahoma_7b_red
   public static mFont b;  // tahoma_7b_blue
   public static mFont c;  // tahoma_7b_purple
   public static mFont d;  // tahoma_7b_yellow
   public static mFont e;  // tahoma_7b_white
   public static mFont f;  // tahoma_7b_green (renamed to avoid conflict with SysTemFont f field)
   public static mFont g;  // tahoma_7
   public static mFont h;  // tahoma_7_blue1
   public static mFont i;  // tahoma_7_white
   public static mFont j;  // tahoma_7_yellow
   public static mFont k;  // tahoma_7_grey
   public static mFont l;  // tahoma_7_red
   public static mFont m;  // tahoma_7_blue
   public static mFont n;  // tahoma_7_green
   public static mFont o;  // tahoma_8b
   public static mFont p;  // number_yellow
   public static mFont q;  // number_red
   public static mFont r;  // number_green
   public static mFont s;  // number_white
   public static mFont t;  // number_orange

   // === Constructors ===

   /** Bitmap font constructor (x1) */
   private mFont(String var1, String var2, String var3, int var4, byte var5) {
      try {
         this.x = var1;
         this.u = var4;
         this.aa = var2;
         DataInputStream var11 = null;
         this.a();

         try {
            java.io.InputStream resStream = RMS.fieldAA(var3);
            if (resStream == null) {
               return;
            }
            var11 = new DataInputStream(resStream);
            this.y = new int[var11.readShort()][];

            for (int var9 = 0; var9 < this.y.length; ++var9) {
               this.y[var9] = new int[4];
               this.y[var9][0] = var11.readShort();
               this.y[var9][1] = var11.readShort();
               this.y[var9][2] = var11.readShort();
               this.y[var9][3] = var11.readShort();
               this.v = this.y[var9][3];
            }
         } catch (Exception var10) {
            try {
               if (var11 != null) var11.close();
            } catch (IOException var9) {
            }
         }
      } catch (Exception var11) {
      }
   }

   /** SysTemFont constructor (TTF, for zoom >= 2) */
   public mFont(int ID, int color) {
      this.sysFont = new SysTemFont(ID, color);
      this.v = this.sysFont.getHeight();
   }

   // === Image loading ===

   /** Load/reload font image — always from x1 */
   public final void a() {
      try {
         this.w = Image.createImage("/x1" + this.aa);
      } catch (Exception e) {
         this.w = GameCanvas.c(this.aa);
      }
   }

   /** Clear font image */
   public final void b() {
      this.w = null;
   }

   /** Get char height */
   public final int c() {
      if (this.sysFont != null) return this.sysFont.getHeight();
      return this.v;
   }

   // === Text measurement ===

   /** Get text width in pixels */
   public final int a(String var1) {
      if (this.sysFont != null) return this.sysFont.getWidth(var1);
      if (this.y == null) return 0;

      int var2 = 0;
      for (int var4 = 0; var4 < var1.length(); ++var4) {
         int var3;
         if ((var3 = this.x.indexOf(var1.charAt(var4))) == -1) {
            var3 = 0;
         }
         var2 += this.y[var3][2] + this.u;
      }
      return var2;
   }

   // === Text rendering ===

   /** Paint text (single color) */
   public final void a(mGraphics var1, String var2, int var3, int var4, int var5) {
      // SysTemFont mode — delegate to TTF renderer
      if (this.sysFont != null) {
         // Wrap game1.mGraphics → lib.mGraphics for SysTemFont
         base.lib.mGraphics libG = new base.lib.mGraphics(var1.a);
         this.sysFont.drawString(libG, var2, var3, var4, var5, false);
         return;
      }

      // Bitmap fallback
      if (this.w == null || this.y == null) return;
      int var6 = var2.length();
      if (var5 == 0) {
         var5 = var3;
      } else if (var5 == 1) {
         var5 = var3 - this.a(var2);
      } else {
         var5 = var3 - (this.a(var2) >> 1);
      }

      int scale = mGraphics.b;
      for (int var7 = 0; var7 < var6; ++var7) {
         if ((var3 = this.x.indexOf(var2.charAt(var7))) == -1) {
            var3 = 0;
         }
         if (var3 > -1) {
            var1.a.drawRegionScaled(this.w.getTexture(),
               this.y[var3][0], this.y[var3][1], this.y[var3][2], this.y[var3][3],
               var5 * scale, var4 * scale, scale);
         }
         var5 += this.y[var3][2] + this.u;
      }
   }

   /** Paint text with shadow */
   public final void a(mGraphics var1, String var2, int var3, int var4, int var5, mFont var6) {
      // SysTemFont mode
      if (this.sysFont != null) {
         base.lib.mGraphics libG = new base.lib.mGraphics(var1.a);
         this.sysFont.drawString(libG, var2, var3, var4, var5, false);
         return;
      }

      // Bitmap fallback with shadow
      if (this.w == null || this.y == null) return;
      int var7 = var2.length();
      if (var5 == 0) {
         var5 = var3;
      } else if (var5 == 1) {
         var5 = var3 - this.a(var2);
      } else {
         var5 = var3 - (this.a(var2) >> 1);
      }

      int scale = mGraphics.b;
      for (int var8 = 0; var8 < var7; ++var8) {
         if ((var3 = this.x.indexOf(var2.charAt(var8))) == -1) {
            var3 = 0;
         }
         if (var3 > -1) {
            var1.a.drawRegionScaled(var6.w.getTexture(),
               this.y[var3][0], this.y[var3][1], this.y[var3][2], this.y[var3][3],
               (var5 + 1) * scale, var4 * scale, scale);
            var1.a.drawRegionScaled(var6.w.getTexture(),
               this.y[var3][0], this.y[var3][1], this.y[var3][2], this.y[var3][3],
               var5 * scale, (var4 + 1) * scale, scale);
            var1.a.drawRegionScaled(this.w.getTexture(),
               this.y[var3][0], this.y[var3][1], this.y[var3][2], this.y[var3][3],
               var5 * scale, var4 * scale, scale);
         }
         var5 += this.y[var3][2] + this.u;
      }
   }

   // === Text wrapping ===

   public final MyVector a(String var1, int var2) {
      if (this.sysFont != null) {
         Vector v = this.sysFont.splitFontVector(var1, var2);
         MyVector mv = new MyVector();
         for (int ii = 0; ii < v.size(); ii++) mv.addElement(v.elementAt(ii));
         return mv;
      }

      MyVector var3 = new MyVector();
      String var4 = "";
      for (int var5 = 0; var5 < var1.length(); ++var5) {
         if (var1.charAt(var5) == '\n') {
            var3.addElement(var4);
            var4 = "";
         } else {
            var4 = var4 + var1.charAt(var5);
            if (this.a(var4) > var2) {
               int var7;
               for (var7 = var4.length() - 1; var7 >= 0 && var4.charAt(var7) != ' '; --var7) {
               }
               if (var7 < 0) var7 = var4.length() - 1;
               var3.addElement(var4.substring(0, var7));
               var5 = var5 - (var4.length() - var7) + 1;
               var4 = "";
            }
            if (var5 == var1.length() - 1 && !var4.trim().equals("")) {
               var3.addElement(var4);
            }
         }
      }
      return var3;
   }

   public final String[] b(String var1, int var2) {
      if (this.sysFont != null) {
         Vector lines = this.sysFont.splitFontVector(var1, var2);
         String[] arr = new String[lines.size()];
         for (int i = 0; i < lines.size(); ++i) {
            arr[i] = lines.elementAt(i).toString();
         }
         return arr;
      }

      MyVector var3;
      String[] var4 = new String[(var3 = this.a(var1, var2)).size()];
      for (var2 = 0; var2 < var3.size(); ++var2) {
         var4[var2] = var3.elementAt(var2).toString();
      }
      return var4;
   }

   // === Static initialization ===

   static {
      reload();
   }

   public static void reload() {
      // Always create bitmap fonts first (fallback)
      a = new mFont(z, "/font/tahoma_7b_red.png", "/font/tahoma_7b", 0, (byte)0);
      b = new mFont(z, "/font/tahoma_7b_blue.png", "/font/tahoma_7b", 0, (byte)0);
      c = new mFont(z, "/font/tahoma_7b_purple.png", "/font/tahoma_7b", 0, (byte)0);
      d = new mFont(z, "/font/tahoma_7b_yellow.png", "/font/tahoma_7b", 0, (byte)0);
      e = new mFont(z, "/font/tahoma_7b_white.png", "/font/tahoma_7b", 0, (byte)0);
      f = new mFont(z, "/font/tahoma_7b_green.png", "/font/tahoma_7b", 0, (byte)0);
      g = new mFont(z, "/font/tahoma_7.png", "/font/tahoma_7", 0, (byte)0);
      h = new mFont(z, "/font/tahoma_7_blue1.png", "/font/tahoma_7", 0, (byte)0);
      i = new mFont(z, "/font/tahoma_7_white.png", "/font/tahoma_7", 0, (byte)0);
      j = new mFont(z, "/font/tahoma_7_yellow.png", "/font/tahoma_7", 0, (byte)0);
      k = new mFont(z, "/font/tahoma_7_grey.png", "/font/tahoma_7", 0, (byte)0);
      l = new mFont(z, "/font/tahoma_7_red.png", "/font/tahoma_7", 0, (byte)0);
      m = new mFont(z, "/font/tahoma_7_blue.png", "/font/tahoma_7", 0, (byte)0);
      n = new mFont(z, "/font/tahoma_7_green.png", "/font/tahoma_7", 0, (byte)0);
      o = new mFont(z, "/font/tahoma_8b.png", "/font/tahoma_8b", -1, (byte)0);
      p = new mFont(" 0123456789+-", "/font/number_yellow.png", "/font/number", 0, (byte)0);
      q = new mFont(" 0123456789+-", "/font/number_red.png", "/font/number", 0, (byte)0);
      r = new mFont(" 0123456789+-", "/font/number_green.png", "/font/number", 0, (byte)0);
      s = new mFont(" 0123456789+-", "/font/number_white.png", "/font/number", 0, (byte)0);
      t = new mFont(" 0123456789+-", "/font/number_orange.png", "/font/number", 0, (byte)0);

      // Override with SysTemFont (TTF) when zoom >= 2
      if (zoomLevel >= 2) {
         a = new mFont(2907, -65536);       // tahoma_7b_red
         b = new mFont(1, -9265665);        // tahoma_7b_blue
         c = new mFont(4, -4947201);        // tahoma_7b_purple
         d = new mFont(3, -197061);         // tahoma_7b_yellow
         e = new mFont(5, -1);              // tahoma_7b_white
         f = new mFont(6, -10035407);  // tahoma_7b_green
         g = new mFont(9, -15527149);       // tahoma_7
         h = new mFont(14, 65535);          // tahoma_7_blue1 (#00FFFF)
         i = new mFont(10, -1);             // tahoma_7_white
         j = new mFont(11, -197061);        // tahoma_7_yellow
         k = new mFont(10, -10000537);      // tahoma_7_grey
         l = new mFont(13, -65536);         // tahoma_7_red
         m = new mFont(14, -9265665);       // tahoma_7_blue
         n = new mFont(15, -10035407);      // tahoma_7_green
         o = new mFont(30, -4819663);       // tahoma_8b
         p = new mFont(16, -197061);        // number_yellow
         q = new mFont(17, -65536);         // number_red
         r = new mFont(18, -10035407);      // number_green
         s = new mFont(19, -1);             // number_white
         t = new mFont(100, -197061);       // number_orange
      }
   }
}
