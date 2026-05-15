import java.io.DataInputStream;
import javax.microedition.lcdui.Image;

public final class mFont {
   private int gameAU;
   private int gameAV;
   private Image gameAW;
   private String gameAX;
   private int[][] gameAY;
   private static String gameAZ = " 0123456789+-*='_?.,<>/[]{}!@#$%^&*():aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
   public static mFont tahoma_7b_red;
   public static mFont tahoma_7b_blue;
   public static mFont tahoma_7b_purple;
   public static mFont tahoma_7b_yellow;
   public static mFont tahoma_7b_white;
   public static mFont tahoma_7b_green;
   public static mFont tahoma_7;
   public static mFont tahoma_7_blue1;
   public static mFont tahoma_7_white;
   public static mFont tahoma_7_yellow;
   public static mFont tahoma_7_grey;
   public static mFont tahoma_7_red;
   public static mFont tahoma_7_blue;
   public static mFont tahoma_7_green;
   public static mFont tahoma_8b;
   public static mFont number_yellow;
   public static mFont number_red;
   public static mFont number_green;
   public static mFont number_white;
   public static mFont number_orange;
   private String gameBA;

   private mFont(String var1, String var2, String var3, int var4) {
      try {
         this.gameAX = var1;
         this.gameAU = var4;
         this.gameBA = var2;
         this.gameAA();

         try {
            DataInputStream var7 = new DataInputStream(this.getClass().getResourceAsStream(var3));
            this.gameAY = new int[var7.readShort()][];

            for(int var8 = 0; var8 < this.gameAY.length; ++var8) {
               this.gameAY[var8] = new int[4];
               this.gameAY[var8][0] = var7.readShort();
               this.gameAY[var8][1] = var7.readShort();
               this.gameAY[var8][2] = var7.readShort();
               this.gameAY[var8][3] = var7.readShort();
               int var9 = this.gameAY[var8][3];
               this.gameAV = var9;
            }

            var7.close();
         } catch (Exception var5) {
            return;
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public final void gameAA() {
      this.gameAW = GameCanvas.gameAC(this.gameBA);
   }

   public final void gameAB() {
      this.gameAW = null;
   }

   public final int gameAC() {
      return this.gameAV;
   }

   public final int gameAA(String var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         int var4;
         if ((var4 = this.gameAX.indexOf(var1.charAt(var3))) == -1) {
            var4 = 0;
         }

         var2 += this.gameAY[var4][2] + this.gameAU;
      }

      return var2;
   }

   public final void gameAA(mGraphics var1, String var2, int var3, int var4, int var5) {
      int var6 = var2.length();
      if (var5 == 0) {
         var5 = var3;
      } else if (var5 == 1) {
         var5 = var3 - this.gameAA(var2);
      } else {
         var5 = var3 - (this.gameAA(var2) >> 1);
      }

      for(int var7 = 0; var7 < var6; ++var7) {
         if ((var3 = this.gameAX.indexOf(var2.charAt(var7))) == -1) {
            var3 = 0;
         }

         if (var3 >= 0) {
            var1.gameAA(this.gameAW, this.gameAY[var3][0], this.gameAY[var3][1], this.gameAY[var3][2], this.gameAY[var3][3], 0, var5, var4, 20);
         }

         var5 += this.gameAY[var3][2] + this.gameAU;
      }

   }

   public final void gameAA(mGraphics var1, String var2, int var3, int var4, int var5, mFont var6) {
      int var7 = var2.length();
      if (var5 == 0) {
         var5 = var3;
      } else if (var5 == 1) {
         var5 = var3 - this.gameAA(var2);
      } else {
         var5 = var3 - (this.gameAA(var2) >> 1);
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         if ((var3 = this.gameAX.indexOf(var2.charAt(var8))) == -1) {
            var3 = 0;
         }

         if (var3 >= 0) {
            var1.gameAA(var6.gameAW, this.gameAY[var3][0], this.gameAY[var3][1], this.gameAY[var3][2], this.gameAY[var3][3], 0, var5 + 1, var4, 20);
            var1.gameAA(var6.gameAW, this.gameAY[var3][0], this.gameAY[var3][1], this.gameAY[var3][2], this.gameAY[var3][3], 0, var5, var4 + 1, 20);
            var1.gameAA(this.gameAW, this.gameAY[var3][0], this.gameAY[var3][1], this.gameAY[var3][2], this.gameAY[var3][3], 0, var5, var4, 20);
         }

         var5 += this.gameAY[var3][2] + this.gameAU;
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
               int var6;
               for(var6 = var4.length() - 1; var6 >= 0 && var4.charAt(var6) != ' '; --var6) {
               }

               if (var6 < 0) {
                  var6 = var4.length() - 1;
               }

               var3.addElement(var4.substring(0, var6));
               var5 = var5 - (var4.length() - var6) + 1;
               var4 = "";
            }

            if (var5 == var1.length() - 1 && !var4.trim().equals("")) {
               var3.addElement(var4);
            }
         }
      }

      return var3;
   }

   public final String[] gameAB(String var1, int var2) {
      MyVector var4;
      String[] var5 = new String[(var4 = this.gameAA(var1, var2)).size()];

      for(int var3 = 0; var3 < var4.size(); ++var3) {
         var5[var3] = var4.elementAt(var3).toString();
      }

      return var5;
   }

   static {
      tahoma_7b_red = new mFont(gameAZ, "/font/tahoma_7b_red.png", "/font/tahoma_7b", 0);
      tahoma_7b_blue = new mFont(gameAZ, "/font/tahoma_7b_blue.png", "/font/tahoma_7b", 0);
      tahoma_7b_purple = new mFont(gameAZ, "/font/tahoma_7b_purple.png", "/font/tahoma_7b", 0);
      tahoma_7b_yellow = new mFont(gameAZ, "/font/tahoma_7b_yellow.png", "/font/tahoma_7b", 0);
      tahoma_7b_white = new mFont(gameAZ, "/font/tahoma_7b_white.png", "/font/tahoma_7b", 0);
      tahoma_7b_green = new mFont(gameAZ, "/font/tahoma_7b_green.png", "/font/tahoma_7b", 0);
      tahoma_7 = new mFont(gameAZ, "/font/tahoma_7.png", "/font/tahoma_7", 0);
      tahoma_7_blue1 = new mFont(gameAZ, "/font/tahoma_7_blue1.png", "/font/tahoma_7", 0);
      tahoma_7_white = new mFont(gameAZ, "/font/tahoma_7_white.png", "/font/tahoma_7", 0);
      tahoma_7_yellow = new mFont(gameAZ, "/font/tahoma_7_yellow.png", "/font/tahoma_7", 0);
      tahoma_7_grey = new mFont(gameAZ, "/font/tahoma_7_grey.png", "/font/tahoma_7", 0);
      tahoma_7_red = new mFont(gameAZ, "/font/tahoma_7_red.png", "/font/tahoma_7", 0);
      tahoma_7_blue = new mFont(gameAZ, "/font/tahoma_7_blue.png", "/font/tahoma_7", 0);
      tahoma_7_green = new mFont(gameAZ, "/font/tahoma_7_green.png", "/font/tahoma_7", 0);
      tahoma_8b = new mFont(gameAZ, "/font/tahoma_8b.png", "/font/tahoma_8b", -1);
      number_yellow = new mFont(" 0123456789+-", "/font/number_yellow.png", "/font/number", 0);
      number_red = new mFont(" 0123456789+-", "/font/number_red.png", "/font/number", 0);
      number_green = new mFont(" 0123456789+-", "/font/number_green.png", "/font/number", 0);
      number_white = new mFont(" 0123456789+-", "/font/number_white.png", "/font/number", 0);
      number_orange = new mFont(" 0123456789+-", "/font/number_orange.png", "/font/number", 0);
   }
}
