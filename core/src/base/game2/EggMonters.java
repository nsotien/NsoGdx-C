package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class EggMonters {
   public int a;
   public int b;
   public int c = 0;
   public byte d = 0;
   public int e;
   public static Mob f;

   public final boolean a() {
      if (this.a < GameScr.p) {
         return false;
      } else if (this.a > GameScr.p + GameScr.i) {
         return false;
      } else if (this.b < GameScr.q) {
         return false;
      } else if (this.b > GameScr.q + GameScr.j + 30) {
         return false;
      } else {
         return f == null || f.status != 8;
      }
   }

   public EggMonters(int var1, int var2) {
      this.a = var1;
      this.b = var2;

      for(int var3 = 0; var3 < GameScr.vMob.size(); ++var3) {
         Mob var4;
         if ((var4 = (Mob)GameScr.vMob.elementAt(var3)).s == 202) {
            f = var4;
         }
      }

   }

}
