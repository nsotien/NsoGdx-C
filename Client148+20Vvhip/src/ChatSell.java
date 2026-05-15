public final class ChatSell {
   private static MyVector gameAB = new MyVector();
   public static int gameAA = -1;

   public static void gameAA(ItemTemplate var0, String var1) {
      RMS var3;
      if ((var3 = RMS.gameAA(var0, var1)) != null) {
         for(int var2 = 0; var2 < gameAB.size(); ++var2) {
            if (((RMS)gameAB.elementAt(var2)).gameAA.id == var0.id) {
               gameAB.setElementAt(var3, var2);
               return;
            }
         }

         gameAB.addElement(var3);
      }

   }

   public static void gameAA(ItemTemplate var0) {
      for(int var1 = 0; var1 < gameAB.size(); ++var1) {
         if (((RMS)gameAB.elementAt(var1)).gameAA.id == var0.id) {
            gameAB.removeElementAt(var1);
            return;
         }
      }

   }

   public static RMS gameAA(short var0) {
      for(int var1 = 0; var1 < gameAB.size(); ++var1) {
         RMS var2;
         if ((var2 = (RMS)gameAB.elementAt(var1)).gameAA.id == var0) {
            return var2;
         }
      }

      return null;
   }

   public static RMS gameAA(String var0) {
      for(int var1 = 0; var1 < gameAB.size(); ++var1) {
         RMS var2;
         if ((var2 = (RMS)gameAB.elementAt(var1)).gameAB.equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   public static MyVector gameAA() {
      MyVector var0 = new MyVector();

      for(int var1 = 0; var1 < gameAB.size(); ++var1) {
         RMS var2 = (RMS)gameAB.elementAt(var1);
         var0.addElement(var1 + ". " + var2.gameAA.name + " id " + var2.gameAB);
         if (var2.gameAF > 0) {
            var0.addElement("Mua " + var2.gameAG + "k/" + var2.gameAF + " max " + var2.gameAH);
         }

         if (var2.gameAC > 0) {
            var0.addElement("Bán " + var2.gameAD + "k/" + var2.gameAC + " min " + var2.gameAE);
         }
      }

      return var0;
   }

   public static String gameAB() {
      if (gameAB.size() == 0) {
         return "";
      } else {
         if (gameAA >= gameAB.size() || gameAA < 0) {
            gameAA = 0;
         }

         int var0 = gameAA;

         do {
            RMS var1;
            boolean var2 = (var1 = (RMS)gameAB.elementAt(gameAA = (gameAA + 1) % gameAB.size())).gameAA();
            boolean var3 = var1.gameAB();
            if (var2 && var3) {
               return "@" + Char.getMyChar().cName + " bán " + var1.gameAB + " " + var1.gameAD + "k " + var1.gameAC + " cái, mua " + var1.gameAG + "k " + var1.gameAF + " cai, mua bán pm";
            }

            if (var2) {
               return "@" + Char.getMyChar().cName + " bán " + var1.gameAB + " " + var1.gameAD + "k " + var1.gameAC + " cái, mua pm";
            }

            if (var3) {
               return "@" + Char.getMyChar().cName + " mua " + var1.gameAB + " " + var1.gameAG + "k " + var1.gameAF + " cái, bán pm hoặc gd";
            }
         } while(var0 != gameAA);

         return "";
      }
   }

   public static void gameAB(String var0) {
      for(int var1 = 0; var1 < gameAB.size(); ++var1) {
         RMS var2;
         if (Char.gameAF((var2 = (RMS)gameAB.elementAt(var1)).gameAA.id) != null) {
            boolean var3 = var2.gameAA();
            boolean var4 = var2.gameAB();
            if (var3 && var4) {
               Code.gameAA(var0, "id: " + var2.gameAB + " " + var2.gameAA.name + " bán: " + var2.gameAD + "k/" + var2.gameAC + "cái, mua: " + var2.gameAG + "k/" + var2.gameAF + " cái. Còn " + var2.gameAC() + " cái.");
            } else if (var3) {
               Code.gameAA(var0, "id: " + var2.gameAB + " " + var2.gameAA.name + " bán: " + var2.gameAD + "k/" + var2.gameAC + "cái. Còn " + var2.gameAC() + " cái.");
            } else if (var4) {
               Code.gameAA(var0, "id: " + var2.gameAB + " " + var2.gameAA.name + " mua: " + var2.gameAG + "k/" + var2.gameAF + " cái. Còn mua: " + (var2.gameAF > 0 && Char.gameAK(var2.gameAA.id) < var2.gameAH ? var2.gameAH - Char.gameAK(var2.gameAA.id) : 0));
            }
         }
      }

   }

   public static boolean gameAC() {
      for(int var0 = 0; var0 < gameAB.size(); ++var0) {
         if (((RMS)gameAB.elementAt(var0)).gameAB()) {
            return true;
         }
      }

      return false;
   }

   public static void gameAC(String var0) {
      MyVector var1 = new MyVector();

      RMS var2;
      for(int var3 = 0; var3 < gameAB.size(); ++var3) {
         if ((var2 = (RMS)gameAB.elementAt(var3)).gameAA()) {
            var1.addElement(var2);
         }
      }

      if (var1.size() > 0) {
         RMS var4;
         if (var1.size() == 1) {
            var4 = (RMS)var1.firstElement();
            Code.gameAA(var0, "- Để mua hàng chat buy idvp solg hoặc mua solg idvp");
            Code.gameAA(var0, "     Vd mua 12 " + var4.gameAA.name);
            Code.gameAA(var0, "     chat mua 12 " + var4.gameAB + " hoặc buy " + var4.gameAB + " 12");
         } else {
            var4 = (RMS)var1.elementAt(0);
            var2 = (RMS)var1.elementAt(1);
            Code.gameAA(var0, "- Để mua hàng chat buy idvp1 solg1 idvp2 solg2.... hoặc mua solg1 idvp1 solg2 idvp2...");
            Code.gameAA(var0, "     Vd mua 5 " + var4.gameAA.name + " 5 " + var2.gameAA.name);
            Code.gameAA(var0, "     chat mua 5 " + var4.gameAB + " 5 " + var2.gameAB + " hoặc buy " + var4.gameAB + " 5 " + var2.gameAB + " 5");
         }
      }

      if (gameAC()) {
         Code.gameAA(var0, "- Để bán hàng chat sell hoặc giao dịch");
      }

      Code.gameAA(var0, "- Để Donate chat donate. Thank");
   }
}
