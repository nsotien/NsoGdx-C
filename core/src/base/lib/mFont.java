package base.lib;

import base.game1.GameCanvas;
import base.game1.RMS;
import com.monkey.nso.lib.SysTemFont;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Image;

import static com.monkey.nso.NSO.zoomLevel;

public final class mFont {
   private int gameAU;
   private int gameAV;
   private Image imgFont;
   private String strFont;
   private int[][] fImages;
   private static String st = " 0123456789+-*='_?.,<>/[]{}!@#$%^&*():aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
   public static mFont tahoma_7b_orange;
   public static mFont tahoma_7b_blue;
   public static mFont tahoma_7b_black;
   public static mFont tahoma_7b_yellow;
   public static mFont tahoma_7b_violet;
   public static mFont tahoma_7b_white;
   public static mFont tahoma_7b_green;
   public static mFont tahoma_7b_red;
   public static mFont tahoma_7b_red3;
   public static mFont tahoma_7b_red2;
   public static mFont tahoma_7b_brown;
   public static mFont tahoma_7_black;
   public static mFont tahoma_7_white;
   public static mFont tahoma_7_yellow;
   public static mFont tahoma_7_orange;
   public static mFont tahoma_7_red;
   public static mFont tahoma_7_blue;
   public static mFont tahoma_7_green;
   public static mFont tahoma_7_violet;
   public static mFont number_yellow;
   public static mFont number_red;
   public static mFont number_green;
   public static mFont number_white;
   public static mFont number_orange;
   public static mFont number_Yellow_Small;
   public static mFont tahoma_8b_brown;
   public static mFont tahoma_8b_black;
   public static mFont mfont_tile;
   public static mFont smallFont;
   public static mFont number_staccato_black;
   public static mFont number_staccato_red;
   public static mFont number_staccato_Yellow;
   public static mFont mfont_tile_Android;
   public static mFont name_Black;
   public static mFont name_White;
   public static mFont number_Black;
   public static mFont font_lv;
   public static mFont font_money_White;
   public static mFont font_money_Black;
   public static mFont tahoma_7_gray;

   public static mFont tahoma_7b_purple;
   public static mFont tahoma_7;
   public static mFont tahoma_7_blue1;
   public static mFont tahoma_7_grey;
   public static mFont tahoma_8b;
   private String gameBA;
   public SysTemFont f;


   static {
      reload();
   }

   public static void reload() {
      tahoma_7b_red = new mFont(st, "/font/tahoma_7b_red.png", "/font/tahoma_7b", 0, (byte)0);
      tahoma_7b_blue = new mFont(st, "/font/tahoma_7b_blue.png", "/font/tahoma_7b", 0, (byte)0);
      tahoma_7b_purple = new mFont(st, "/font/tahoma_7b_purple.png", "/font/tahoma_7b", 0, (byte)0);
      tahoma_7b_yellow = new mFont(st, "/font/tahoma_7b_yellow.png", "/font/tahoma_7b", 0, (byte)0);
      tahoma_7b_white = new mFont(st, "/font/tahoma_7b_white.png", "/font/tahoma_7b", 0, (byte)0);
      tahoma_7b_green = new mFont(st, "/font/tahoma_7b_green.png", "/font/tahoma_7b", 0, (byte)0);
      tahoma_7 = new mFont(st, "/font/tahoma_7.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_7_blue1 = new mFont(st, "/font/tahoma_7_blue1.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_7_white = new mFont(st, "/font/tahoma_7_white.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_7_yellow = new mFont(st, "/font/tahoma_7_yellow.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_7_grey = new mFont(st, "/font/tahoma_7_grey.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_7_red = new mFont(st, "/font/tahoma_7_red.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_7_blue = new mFont(st, "/font/tahoma_7_blue.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_7_green = new mFont(st, "/font/tahoma_7_green.png", "/font/tahoma_7", 0, (byte)0);
      tahoma_8b = new mFont(st, "/font/tahoma_8b.png", "/font/tahoma_8b", -1, (byte)0);
      number_yellow = new mFont(" 0123456789+-", "/font/number_yellow.png", "/font/number", 0, (byte)0);
      number_red = new mFont(" 0123456789+-", "/font/number_red.png", "/font/number", 0, (byte)0);
      number_green = new mFont(" 0123456789+-", "/font/number_green.png", "/font/number", 0, (byte)0);
      number_white = new mFont(" 0123456789+-", "/font/number_white.png", "/font/number", 0, (byte)0);
      number_orange = new mFont(" 0123456789+-", "/font/number_orange.png", "/font/number", 0, (byte)0);
      tahoma_7b_red2 = new mFont(8, -65536);
      tahoma_7b_red3 = new mFont(8, -65536);
      if (zoomLevel >=2) {
         tahoma_7b_orange = new mFont(0, -90838);
         tahoma_7b_blue = new mFont(1, -9265665);
         tahoma_7b_black = new mFont(2, -15527149);
         tahoma_7b_yellow = new mFont(3, -197061);
         tahoma_7b_violet = new mFont(4, -4947201);
         tahoma_7b_white = new mFont(5, -1);
         tahoma_7b_green = new mFont(6, -10035407);
         tahoma_7b_brown = new mFont(7, -6338290);
         tahoma_7b_red = new mFont(2907, -65536);
         tahoma_7b_red3 = new mFont(8, -65536);
         tahoma_7 = tahoma_7_black = new mFont(9, -15527149);
         tahoma_7_white = new mFont(10, -1);
         tahoma_7_yellow = new mFont(11, -197061);
         tahoma_7_orange = new mFont(12, -90838);
         tahoma_7_red = new mFont(13, -65536);
         tahoma_7_blue = new mFont(14, -9265665);
         tahoma_7_green = new mFont(15, -10035407);
         tahoma_7_violet = new mFont(21, -4947201);
         name_Black = new mFont(23, -15527149);
         name_White = new mFont(24, -1);
         number_yellow = new mFont(16, -197061);
         number_red = new mFont(17, -65536);
         number_green = new mFont(18, -10035407);
         number_white = new mFont(19, -1);
         number_orange = new mFont(100,  -197061);
         number_Yellow_Small = new mFont(22, -197061);
         number_Black = new mFont(19, -16777216);
         tahoma_8b = tahoma_8b_brown = new mFont(30, -4819663);
         tahoma_8b_black = new mFont(31, -15527149);
         mfont_tile = new mFont(7, -412571);
         smallFont = new mFont(-1, -65625);
         number_staccato_red = new mFont(100, -65536);
         number_staccato_red = new mFont(100, -65536);
         number_staccato_black = new mFont(101, -16777216);
         font_lv = new mFont(25, -1);
         font_money_White = new mFont(26, -1);
         font_money_Black = new mFont(26, -16777216);
         tahoma_7_gray = new mFont(10, -10000537);
      }
   }

   public mFont(int ID, int color) {
      this.f = new SysTemFont(ID, color);
      gameAV = this.f.getHeight();
   }

   private mFont(String var1, String var2, String var3, int var4, byte var5) {
      try {
         this.strFont = var1;
         this.gameAU = var4;
         this.gameBA = var2;
         DataInputStream var11 = null;
         this.gameAA();

         try {

            var11 = new DataInputStream(RMS.fieldAA(var3));
            this.fImages = new int[var11.readShort()][];

            for(int var9 = 0; var9 < this.fImages.length; ++var9) {
               this.fImages[var9] = new int[4];
               this.fImages[var9][0] = var11.readShort();
               this.fImages[var9][1] = var11.readShort();
               this.fImages[var9][2] = var11.readShort();
               this.fImages[var9][3] = var11.readShort();
               int var10 = this.fImages[var9][3];
               this.gameAV = var10;
            }

         } catch (Exception var7) {
            ;
            try {
               var11.close();
            } catch (IOException var6) {
               ;
            }
         }
      } catch (Exception var8) {
         ;
      }
   }

   public final void gameAA() {
      this.imgFont = GameCanvas.gameAC(this.gameBA);
   }

   public final void gameAB() {
      this.imgFont = null;
   }

   public final int gameAC() {
      return this.gameAV;
   }

   public final int gameAA(String var1) {
      int var2 = 0;
      if (this.f != null) {
         return this.f.getWidth(var1);
      }
      if (tahoma_7_white != null && tahoma_7_white.f != null) {
         return tahoma_7_white.gameAA(var1);
      }

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         int var3;
         if ((var3 = this.strFont.indexOf(var1.charAt(var4))) == -1) {
            var3 = 0;
         }

         var2 += this.fImages[var3][2] + this.gameAU;
      }

      return var2;
   }

   public final void gameAA(mGraphics var1, String var2, int var3, int var4, int var5) {
      if (this.f != null) {
         this.f.drawString(var1, var2, var3, var4, var5, false);
         return;

      } else {
         if (tahoma_7_white != null && tahoma_7_white.f != null) {
            tahoma_7_white.gameAA(var1, var2, var3, var4, var5);
            return;
         }
      }

      int var6 = var2.length();
      if (var5 == 0) {
         var5 = var3;
      } else if (var5 == 1) {
         var5 = var3 - this.gameAA(var2);
      } else {
         var5 = var3 - (this.gameAA(var2) >> 1);
      }

      for(int var7 = 0; var7 < var6; ++var7) {
         if ((var3 = this.strFont.indexOf(var2.charAt(var7))) == -1) {
            var3 = 0;
         }

         if (var3 > -1) {
            var1.gameAA(this.imgFont, this.fImages[var3][0], this.fImages[var3][1], this.fImages[var3][2], this.fImages[var3][3], 0, var5, var4, 20);
         }

         var5 += this.fImages[var3][2] + this.gameAU;
      }

   }

   public final void gameAA(mGraphics var1, String var2, int var3, int var4, int var5, mFont var6) {
      if (this.f != null) {
         this.f.drawString(var1, var2, var3, var4, var5, false);
         return;
      } else {
         if (tahoma_7_white != null && tahoma_7_white.f != null) {
            tahoma_7_white.gameAA(var1, var2, var3, var4, var5);
            return;
         }
      }

      int var7 = var2.length();
      if (var5 == 0) {
         var5 = var3;
      } else if (var5 == 1) {
         var5 = var3 - this.gameAA(var2);
      } else {
         var5 = var3 - (this.gameAA(var2) >> 1);
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         if ((var3 = this.strFont.indexOf(var2.charAt(var8))) == -1) {
            var3 = 0;
         }

         if (var3 > -1) {
            var1.gameAA(var6.imgFont, this.fImages[var3][0], this.fImages[var3][1], this.fImages[var3][2], this.fImages[var3][3], 0, var5 + 1, var4, 20);
            var1.gameAA(var6.imgFont, this.fImages[var3][0], this.fImages[var3][1], this.fImages[var3][2], this.fImages[var3][3], 0, var5, var4 + 1, 20);
            var1.gameAA(this.imgFont, this.fImages[var3][0], this.fImages[var3][1], this.fImages[var3][2], this.fImages[var3][3], 0, var5, var4, 20);
         }

         var5 += this.fImages[var3][2] + this.gameAU;
      }

   }

   public final MyVector gameAA(String var1, int var2) {
      MyVector var3 = new MyVector();
      String var4 = "";

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         if (var1.charAt(var5) == '\n') {
            var3.addElement(var4);
            var4 = "";
         } else {
            var4 = var4 + var1.charAt(var5);
            if (this.gameAA(var4) > var2) {
               boolean var6 = false;

               int var7;
               for(var7 = var4.length() - 1; var7 >= 0 && var4.charAt(var7) != ' '; --var7) {
               }

               if (var7 < 0) {
                  var7 = var4.length() - 1;
               }

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
   public Vector splitFontVector(String src, int lineWidth) {
      if (f == null) {
         if (tahoma_7_white.f != null)
            return tahoma_7_white.splitFontVector(src, lineWidth);
         return gameAA(src, lineWidth);
      }
      return this.f.splitFontVector(src, lineWidth);
   }

   public String[] splitFontArray(String src, int lineWidth) {
      Vector lines = this.splitFontVector(src, lineWidth);
      String[] arr = new String[lines.size()];

      for (int i = 0; i < lines.size(); ++i) {
         arr[i] = lines.elementAt(i).toString();
      }

      return arr;
   }

   public final String[] gameAB(String var1, int var2) {
      if (this.f != null) {
         return splitFontArray(var1, var2);

      }
      if (f == null && tahoma_7_white.f !=null) {
         return tahoma_7_white.splitFontArray(var1, var2);
      }
      MyVector var3;
      String[] var4 = new String[(var3 = this.gameAA(var1, var2)).size()];

      for(var2 = 0; var2 < var3.size(); ++var2) {
         var4[var2] = var3.elementAt(var2).toString();
      }

      return var4;
   }
}
