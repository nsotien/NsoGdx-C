import java.util.Calendar;

public class CodePhu {
   public static int fieldAC;
   public static int fieldAD;
   public static int fieldAE;
   public static long fieldAF;
   public static boolean fieldAG = fieldAB("adv");
   public static boolean fieldAH = fieldAB("locdo");
   public static boolean fieldAI = fieldAB("hsl");
   public static boolean fieldAV = fieldAB("htl");
   public static boolean fieldAW = fieldAB("atb");
   public static int fieldAJ = 1;
   public static int fieldAK = -1;
   public static boolean fieldAL;
   public static int fieldAM;
   public static int fieldAN;
   public static int fieldAO;
   public static int fieldAP;
   public static int fieldAQ;
   public static int fieldAR;
   public static long fieldAS;
   public static boolean fieldAT;
   public static long fieldAU;

   public static void fieldAA() {
      if (fieldAI && Char.getMyChar().luong > 0) {
         Service.gI().wakeUpFromDead();
         fieldAA(800);
      } else {
         Service.gI().returnTownFromDead();
         TileMap.fieldAF();
         fieldAA(800);
      }

      if (Char.getMyChar().cHP <= 0 || Char.getMyChar().statusMe == 14 || Char.getMyChar().statusMe == 5) {
         Service.gI().wakeUpFromDead();
         fieldAA(300);
      }
   }

   public static void fieldAA(int var0) {
      try {
         Thread.sleep(var0);
      } catch (Exception var2) {
      }
   }

   public static void fieldAB() {
      Calendar var0;
      int var1 = (var0 = Res.fieldAB()).get(11);
      int var2 = var0.get(12);
      if (fieldAL) {
         if (fieldAO == fieldAM) {
            if (var1 != fieldAO || var2 < fieldAP || var2 > fieldAN) {
               return;
            }
         } else if ((var1 != fieldAO || var2 < fieldAP) && (var1 <= fieldAO || var1 >= fieldAM) && (var1 != fieldAM || var2 >= fieldAN)) {
            return;
         }

         Controller.gI().fieldAD();
      }
   }

   public static void fieldAA(String var0) {
      if (var0.endsWith(mResources.gameMJ)) {
         int var1 = var0.indexOf(" ");
         Service.gI().addFriend(var0.substring(0, var1));
         fieldAA(100);
      }
   }

   public static boolean fieldAA(mGraphics var0) {
      int var1 = fieldAK;
      if (var1 != -1) {
         var0.gameAA(var1);
         var0.gameAC(0, 0, GameCanvas.w, GameCanvas.h);
         return true;
      } else {
         return false;
      }
   }

   public static boolean fieldAB(String var0) {
      return RMS.gameAC(var0) == 1;
   }

   public static void fieldAD() {
      for (int var0 = 0; Char.getMyChar().cName.equals(Code.fieldAH) && var0 < Code.fieldAI.size(); var0++) {
         if (!Code.fieldAD((String)Code.fieldAI.elementAt(var0))) {
            Service.gI().addParty((String)Code.fieldAI.elementAt(var0));
         }
      }
   }

   public static void fieldAE() {
      if (fieldAT && System.currentTimeMillis() - fieldAU >= 1000L) {
         Char var0 = Char.getMyChar().charFocus;
         if (var0 != null) {
            if (!Code.fieldAC(var0.cName)) {
               Code.fieldAI.addElement(var0.cName);
               Service.gI().addFriend(var0.cName);
            } else if (!Code.fieldAD(var0.cName)) {
               Service.gI().addParty(var0.cName);
            } else {
               fieldAT = false;
            }
         }

         fieldAU = System.currentTimeMillis();
      }
   }

   public static boolean fieldAC(String var0) {
      if (var0.equals("locdo")) {
         RMS.gameAA("locdo", (fieldAH = !fieldAH) ? 1 : 0);
         GameScr.fieldAC("Lọc đồ: " + (fieldAH ? "Bật" : "Tắt"));
         return true;
      } else if (var0.equals("hsl")) {
         RMS.gameAA("hsl", (fieldAI = !fieldAI) ? 1 : 0);
         GameScr.fieldAC("HS bằng lượng: " + (fieldAI ? "Bật" : "Tắt"));
         return true;
      } else if (var0.equals("htl")) {
         RMS.gameAA("htl", (fieldAV = !fieldAV) ? 1 : 0);
         GameScr.fieldAC("Hiện thông tin + và tinh luyện: " + (fieldAV ? "Bật" : "Tắt"));
         return true;
      } else if (var0.equals("atb")) {
         RMS.gameAA("atb", (fieldAW = !fieldAW) ? 1 : 0);
         GameScr.fieldAC("Ẩn thông báo dưới: " + (fieldAW ? "Bật" : "Tắt"));
         return true;
      } else if (var0.equals("xdel")) {
         int c = Code.deleteAllItemdelInBag();
         GameScr.fieldAC("Đã xóa " + c + " vật phẩm theo itemdel");
         return true;
      } else if (var0.equals("addn")) {
         if (Char.getMyChar().charFocus != null) {
            fieldAT = true;
            GameScr.fieldAC("Thêm nhóm: " + Char.getMyChar().charFocus.cName);
         } else {
            GameScr.fieldAC("Chưa trỏ vào nhân vật cần thêm nhóm");
         }

         return true;
      } else if (var0.equals("cn")) {
         if (fieldAT) {
            fieldAT = false;
            GameScr.fieldAC("Huỷ pt nhóm");
         } else {
            GameScr.fieldAC("Xóa nhóm");
            Code.fieldAH = null;
            Code.fieldAI.removeAllElements();
            Code.fieldAI();
         }

         return true;
      } else {
         return false;
      }
   }

   static {
      Code.fieldAY = fieldAB("glv");
      String var0;
      if ((var0 = RMS.loadRMSString("nextmap")) != null) {
         try {
            fieldAJ = Integer.parseInt(var0);
         } catch (NumberFormatException var4) {
         }
      }

      String var1;
      if ((var1 = RMS.loadRMSString("background")) != null) {
         try {
            fieldAK = Integer.parseInt(var1);
         } catch (NumberFormatException var3) {
         }
      }
   }
}
