import javax.microedition.lcdui.Image;

public final class GameData {
   public static mHashtable listImgIcon = new mHashtable();
   public static mHashtable listbyteData = new mHashtable();

   public static EffectData gameAA(short var0) {
      EffectData var1;
      if ((var1 = (EffectData) listbyteData.get(String.valueOf(var0))) == null) {
         var1 = new EffectData();
         listbyteData.put(String.valueOf(var0), var1);
         Service.gI().gameBQ(var0);
      }

      return var1;
   }

   public static ImageIcon gameAB(short var0) {
      try {
         ImageIcon var1;
         if ((var1 = (ImageIcon) listImgIcon.get(String.valueOf(var0))) == null || var1 != null && var1.img == null) {
            if (var1 == null) {
               var1 = new ImageIcon();
               listImgIcon.put(String.valueOf(var0), var1);
            }

            var1.img = Controller.gameAA(RMS.gameAB("effect ".concat(String.valueOf(var0))));
            if (var1.img == null && System.currentTimeMillis() / 1000L - var1.timeGetBack > 10L) {
               var1.timeGetBack = (long)((int)(System.currentTimeMillis() / 1000L));
               if (var0 >= 0) {
                  var1.img = GameCanvas.gameAC("/eff_auto/" + var0 + ".png");
               }

               if (var1.img == null && Session_ME.gameAA().gameAF) {
                  Service.gI().gameAC(var0);
                  var1.timeGetBack = (long)((int)(System.currentTimeMillis() / 1000L));
               }
            }
         }

         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   public static void gameAA(short var0, byte[] var1) {
      try {
         ImageIcon var2;
         if ((var2 = (ImageIcon) listImgIcon.get(String.valueOf(var0))) == null) {
            var2 = new ImageIcon();
         }

         listImgIcon.put(String.valueOf(var0), var2);
         if (var1.length <= 0) {
            var2.timeGetBack = (long)((int)(System.currentTimeMillis() / 1000L));
            return;
         }

         var2.img = Image.createImage(var1, 0, var1.length);
      } catch (Exception var3) {
      }

   }
}
