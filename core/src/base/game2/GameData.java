package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class GameData {
   public static int a = 0;
   public static mHashtable b = new mHashtable();
   public static mHashtable c = new mHashtable();

   public static ImageIcon a(short var0) {
      try {
         ImageIcon var1;
         if ((var1 = (ImageIcon)b.a(String.valueOf(var0))) == null || var1 != null && var1.a == null) {
            if (var1 == null) {
               var1 = new ImageIcon();
               b.a(String.valueOf(var0), var1);
            }

            var1.a = Controller.a(RMS.a("effect " + var0));
            if (var1.a == null && System.currentTimeMillis() / 1000L - var1.b > 10L) {
               var1.b = (long)((int)(System.currentTimeMillis() / 1000L));
               if (var0 >= 0) {
                  var1.a = GameCanvas.c("/eff_auto/" + var0 + ".png");
               }

               if (var1.a == null && Session_ME.a().b()) {
                  Service.gI().c(var0);
                  var1.b = (long)((int)(System.currentTimeMillis() / 1000L));
               }

               System.currentTimeMillis();
            }
         } else {
            System.currentTimeMillis();
         }

         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   public static void a(short var0, byte[] var1) {
      try {
         ImageIcon var2;
         if ((var2 = (ImageIcon)b.a(String.valueOf(var0))) == null) {
            var2 = new ImageIcon();
         }

         b.a(String.valueOf(var0), var2);
         if (var1.length > 0) {
            var2.a = Image.createImage(var1, 0, var1.length);
         } else {
            var2.b = (long)((int)(System.currentTimeMillis() / 1000L));
         }

         System.currentTimeMillis();
      } catch (Exception var3) {
      }

   }

}
