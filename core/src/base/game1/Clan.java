package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Clan {
   public String a = "";
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;
   public String j = "";
   public String k = "";
   public String l = "";
   public String m = "";
   public int n;
   public int o;
   public Item[] p;

   public Clan() {
      new MyVector();
   }

   public final void a(String var1) {
      String[] var8 = NinjaUtil.a(var1, "\n");
      this.l = "";

      try {
         for(int var2 = 0; var2 < var8.length; ++var2) {
            String var3;
            if (!(var3 = var8[var2].trim()).equals("")) {
               try {
                  String[] var9;
                  String var4 = (var9 = NinjaUtil.a(var3, ","))[0];
                  int var5;
                  if ((var5 = Integer.parseInt(var9[1])) == 0) {
                     var4 = "c0" + var4;
                     var4 = var4 + TextGame.mj[1] + " " + NinjaUtil.a(var9[2]) + " " + TextGame.mj[0] + " " + var9[3];
                  } else if (var5 == 1) {
                     var4 = "c1" + var4;
                     var4 = var4 + " " + TextGame.mj[2] + " " + NinjaUtil.a(var9[2]) + " " + TextGame.mj[0] + " " + var9[3];
                  } else if (var5 == 2) {
                     var4 = "c2" + var4;
                     var4 = var4 + " " + TextGame.mj[3] + " " + NinjaUtil.a(var9[2]) + " " + TextGame.mj[0] + " " + var9[3];
                  } else if (var5 == 3) {
                     var4 = "c1" + var4;
                     var4 = var4 + " " + TextGame.mj[4] + " " + NinjaUtil.a(var9[2]) + " " + TextGame.mj[0] + " " + var9[3];
                  } else if (var5 == 4) {
                     var4 = "c1" + var4;
                     var4 = var4 + TextGame.mj[5] + " " + NinjaUtil.a(var9[2]) + " " + TextGame.mj[0] + " " + var9[3];
                  } else if (var5 == 5) {
                     var4 = "c2" + var4;
                     var4 = var4 + " " + TextGame.mj[6] + " " + NinjaUtil.a(var9[2]) + " " + TextGame.mj[0] + " " + var9[3];
                  }

                  this.l = this.l + var4 + "\n";
               } catch (Exception var81) {
               }
            }
         }
      } catch (Exception var9) {
      }

   }

}
