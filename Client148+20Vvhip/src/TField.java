import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.TextBox;

public final class TField implements IActionListener {
   public int x;
   public int y;
   public int width;
   public int height;
   public boolean isFocus;
   private static int gameAL = 2;
   private static final int[] gameAM = new int[]{18, 14, 11, 9, 6, 4, 2};
   private static int gameAN = 0;
   private static String[] gameAO = new String[]{" 0", ".,@?!_1\"/$-():*+<=>;%&~#%^&*{}[];'/1", "abc2áàảãạâấầẩẫậăắằẳẵặ2", "def3đéèẻẽẹêếềểễệ3", "ghi4íìỉĩị4", "jkl5", "mno6óòỏõọôốồổỗộơớờởỡợ6", "pqrs7", "tuv8úùủũụưứừửữự8", "wxyz9ýỳỷỹỵ9", "*", "#"};
   private static String[] gameAP = new String[]{"0", "1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", "0", "0"};
   public String title = "";
   public String title_Null = "";
   private String gameAQ = "";
   private String gameAR = "";
   private String gameAS = "";
   private int gameAT = 0;
   private int gameAU = 0;
   private int gameAV = 500;
   private int gameAW = 0;
   private int gameAX = -1984;
   private int gameAY = 0;
   private int gameAZ = 0;
   private int gameBA = 10;
   private int gameBB = 0;
   public static boolean isQwerty;
   private int gameBC = 0;
   private static int gameBD = 11;
   public boolean gameAI;
   public String name = "";
   public Command cmdClear;

   public final void gameAA() {
      TextBox var1;
      (var1 = new TextBox(this.name, "", this.gameAV, 0)).addCommand(new javax.microedition.lcdui.Command(mResources.OK, 4, 0));
      var1.addCommand(new javax.microedition.lcdui.Command("Cancel", 3, 0));
      var1.setCommandListener(new CommandHandler(this, var1));

      try {
         if (this.gameBB == 2) {
            var1.setConstraints(65536);
         } else if (this.gameBB == 1) {
            var1.setConstraints(2);
         } else {
            var1.setConstraints(0);
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      var1.setString(this.gameAQ);
      var1.setMaxSize(this.gameAV);
      Display.getDisplay(GameMidlet.instance).setCurrent(var1);
   }

   public static boolean gameAA(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   public TField() {
      this.gameAQ = "";
      gameAN = mFont.tahoma_8b.gameAC() + 1;
      this.cmdClear = new Command(mResources.DELETE, this, 1000, (Object)null);
      if (RMS.gameAD("qwerty") == 1) {
         isQwerty = true;
      }

   }

   public final void gameAB() {
      if (this.gameAT > 0 && this.gameAQ.length() > 0) {
         this.gameAQ = this.gameAQ.substring(0, this.gameAT - 1) + this.gameAQ.substring(this.gameAT, this.gameAQ.length());
         --this.gameAT;
         this.gameAE();
         this.gameAF();
      }

   }

   private void gameAE() {
      if (this.gameBB == 2) {
         this.gameAS = this.gameAR;
      } else {
         this.gameAS = this.gameAQ;
      }

      if (this.gameAW < 0 && mFont.tahoma_8b.gameAA(this.gameAS) + this.gameAW < this.width - 4 - 13) {
         this.gameAW = this.width - 10 - mFont.tahoma_8b.gameAA(this.gameAS);
      }

      if (this.gameAW + mFont.tahoma_8b.gameAA(this.gameAS.substring(0, this.gameAT)) <= 0) {
         this.gameAW = -mFont.tahoma_8b.gameAA(this.gameAS.substring(0, this.gameAT));
         this.gameAW += 40;
      } else if (this.gameAW + mFont.tahoma_8b.gameAA(this.gameAS.substring(0, this.gameAT)) >= this.width - 12) {
         this.gameAW = this.width - 10 - mFont.tahoma_8b.gameAA(this.gameAS.substring(0, this.gameAT)) - 8;
      }

      if (this.gameAW > 0) {
         this.gameAW = 0;
      }

   }

   private void gameAD(int var1) {
      if ((this.gameBB != 2 && this.gameBB != 3 || var1 >= 48 && var1 <= 57 || var1 >= 65 && var1 <= 90 || var1 >= 97 && var1 <= 122) && this.gameAQ.length() < this.gameAV) {
         String var2 = this.gameAQ.substring(0, this.gameAT) + (char)var1;
         if (this.gameAT < this.gameAQ.length()) {
            var2 = var2 + this.gameAQ.substring(this.gameAT, this.gameAQ.length());
         }

         this.gameAQ = var2;
         ++this.gameAT;
         this.gameAF();
         this.gameAE();
      }

   }

   public final boolean gameAA(int var1) {
      if (var1 != 8 && var1 != -8 && var1 != 204) {
         if (var1 >= 65 && var1 <= 122 && !isQwerty) {
            isQwerty = true;
            RMS.gameAA("qwerty", 1);
         }

         if (isQwerty) {
            if (var1 == 45) {
               if (var1 == this.gameAX && this.gameAY < gameAM[gameAL]) {
                  this.gameAQ = this.gameAQ.substring(0, this.gameAT - 1) + '_';
                  this.gameAS = this.gameAQ;
                  this.gameAF();
                  this.gameAE();
                  this.gameAX = -1984;
                  return false;
               }

               this.gameAX = 45;
            }

            if (var1 >= 32) {
               this.gameAD(var1);
               return false;
            }
         }

         if (var1 == gameBD) {
            ++this.gameBC;
            if (this.gameBC > 3) {
               this.gameBC = 0;
            }

            this.gameAY = 1;
            this.gameAX = var1;
            return false;
         } else {
            if (var1 == 42) {
               var1 = 58;
            }

            if (var1 == 35) {
               var1 = 59;
            }

            if (var1 >= 48 && var1 <= 59) {
               if (this.gameBB != 0 && this.gameBB != 2 && this.gameBB != 3) {
                  if (this.gameBB == 1) {
                     this.gameAD(var1);
                     this.gameAY = 1;
                  }
               } else {
                  String[] var2;
                  if (this.gameBB != 2 && this.gameBB != 3) {
                     var2 = gameAO;
                  } else {
                     var2 = gameAP;
                  }

                  char var3;
                  String var4;
                  if (var1 == this.gameAX) {
                     this.gameAZ = (this.gameAZ + 1) % var2[var1 - 48].length();
                     var3 = var2[var1 - 48].charAt(this.gameAZ);
                     if (this.gameBC == 0) {
                        var3 = Character.toLowerCase(var3);
                     } else if (this.gameBC == 1) {
                        var3 = Character.toUpperCase(var3);
                     } else if (this.gameBC == 2) {
                        var3 = Character.toUpperCase(var3);
                     } else {
                        var3 = var2[var1 - 48].charAt(var2[var1 - 48].length() - 1);
                     }

                     var4 = this.gameAQ.substring(0, this.gameAT - 1) + var3;
                     if (this.gameAT < this.gameAQ.length()) {
                        var4 = var4 + this.gameAQ.substring(this.gameAT, this.gameAQ.length());
                     }

                     this.gameAQ = var4;
                     this.gameAY = gameAM[gameAL];
                     this.gameAF();
                  } else if (this.gameAQ.length() < this.gameAV) {
                     if (this.gameBC == 1 && this.gameAX != -1984) {
                        this.gameBC = 0;
                     }

                     this.gameAZ = 0;
                     var3 = var2[var1 - 48].charAt(this.gameAZ);
                     if (this.gameBC == 0) {
                        var3 = Character.toLowerCase(var3);
                     } else if (this.gameBC == 1) {
                        var3 = Character.toUpperCase(var3);
                     } else if (this.gameBC == 2) {
                        var3 = Character.toUpperCase(var3);
                     } else {
                        var3 = var2[var1 - 48].charAt(var2[var1 - 48].length() - 1);
                     }

                     var4 = this.gameAQ.substring(0, this.gameAT) + var3;
                     if (this.gameAT < this.gameAQ.length()) {
                        var4 = var4 + this.gameAQ.substring(this.gameAT, this.gameAQ.length());
                     }

                     this.gameAQ = var4;
                     this.gameAY = gameAM[gameAL];
                     ++this.gameAT;
                     this.gameAF();
                     this.gameAE();
                  }

                  this.gameAX = var1;
               }
            } else {
               this.gameAZ = 0;
               this.gameAX = -1984;
               if (var1 == 14) {
                  if (this.gameAT > 0) {
                     --this.gameAT;
                     this.gameAE();
                     this.gameBA = 10;
                     return false;
                  }
               } else if (var1 == 15) {
                  if (this.gameAT < this.gameAQ.length()) {
                     ++this.gameAT;
                     this.gameAE();
                     this.gameBA = 10;
                     return false;
                  }
               } else {
                  if (var1 == 19) {
                     this.gameAB();
                     return false;
                  }

                  this.gameAX = var1;
               }
            }

            return true;
         }
      } else {
         this.gameAB();
         return true;
      }
   }

   public final void gameAA(mGraphics var1) {
      var1.gameAE(0, 0, GameCanvas.w, GameCanvas.h);
      boolean var2 = this.isFocus;
      if (this.gameBB == 2) {
         this.gameAS = this.gameAR;
      } else {
         this.gameAS = this.gameAQ;
      }

      if (this.gameAS.equals("")) {
         this.gameAS = this.title_Null;
      }

      Paint.gameAA(var1, var2, this.x, this.y, this.width, this.height, 4 + this.gameAW + this.x, this.y + (this.height - mFont.tahoma_8b.gameAC()) / 2, this.gameAS);
      var1.gameAE(this.x + 3, this.y + 1, this.width - 4, this.height - 4);
      var1.gameAA(0);
      if (this.isFocus && this.gameAY == 0 && (this.gameBA > 0 || this.gameAU / 5 % 2 == 0)) {
         var1.gameAA(11184810);
         var1.gameAD(5 + this.gameAW + this.x + mFont.tahoma_8b.gameAA(this.gameAS.substring(0, this.gameAT)) - 1, this.y + (this.height - gameAN) / 2 + 1, 1, gameAN);
      }

   }

   public final void gameAB(mGraphics var1) {
      boolean var2 = this.isFocus;
      if (this.gameBB == 2) {
         this.gameAS = this.gameAR;
      } else {
         this.gameAS = this.gameAQ;
      }

      if (this.gameAS.equals("")) {
         this.gameAS = this.title_Null;
      }

      Paint.gameAA(var1, var2, this.x, this.y, this.width, 4 + this.gameAW + this.x, this.y + (this.height - mFont.tahoma_8b.gameAC()) / 2, this.gameAS);
      var1.gameAA(0);
      if (this.isFocus && this.gameAY == 0 && (this.gameBA > 0 || this.gameAU / 5 % 2 == 0)) {
         var1.gameAA(11184810);
         var1.gameAD(5 + this.gameAW + this.x + mFont.tahoma_8b.gameAA(this.gameAS.substring(0, this.gameAT)) - 1, this.y + (this.height - gameAN) / 2 + 1, 1, gameAN);
      }

   }

   private void gameAF() {
      if (this.gameBB == 2) {
         this.gameAR = "";

         for(int var1 = 0; var1 < this.gameAQ.length(); ++var1) {
            this.gameAR = this.gameAR + "*";
         }

         if (this.gameAY > 0 && this.gameAT > 0) {
            this.gameAR = this.gameAR.substring(0, this.gameAT - 1) + this.gameAQ.charAt(this.gameAT - 1) + this.gameAR.substring(this.gameAT, this.gameAR.length());
         }
      }

   }

   public final void gameAC() {
      ++this.gameAU;
      if (this.gameAY > 0) {
         --this.gameAY;
         if (this.gameAY == 0) {
            this.gameAZ = 0;
            if (this.gameBC == 1 && this.gameAX != gameBD) {
               this.gameBC = 0;
            }

            this.gameAX = -1984;
            this.gameAF();
         }
      }

      if (this.gameBA > 0) {
         --this.gameBA;
      }

      if (GameCanvas.isPointerJustRelease) {
         if (GameCanvas.currentScreen == RegisterScr.gameAA) {
            if (RegisterScr.gameAA == null) {
               RegisterScr.gameAA = new RegisterScr();
            }

            int var1 = RegisterScr.gameAA.gameAB.cmy;
            if (!GameCanvas.gameAB(this.x, this.y - var1, this.width, this.height)) {
               this.isFocus = false;
               return;
            }

            this.gameAA();
            return;
         }

         if (GameCanvas.gameAB(this.x, this.y, this.width, this.height)) {
            this.gameAA();
            return;
         }

         this.isFocus = false;
      }

   }

   public final String gameAD() {
      return this.gameAQ;
   }

   public final void gameAA(String var1) {
      if (var1 != null) {
         this.gameAX = -1984;
         this.gameAY = 0;
         this.gameAZ = 0;
         this.gameAQ = var1;
         this.gameAS = var1;
         this.gameAF();
         this.gameAT = var1.length();
         this.gameAE();
      }

   }

   public final void gameAB(int var1) {
      this.gameAV = var1;
   }

   public final void gameAC(int var1) {
      this.gameBB = var1;
   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 1000:
         this.gameAB();
      default:
      }
   }
}
