package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Open_All implements Runnable {
   private Item a;
   private long time;

   Open_All(Item var1) {
      this.a = var1;
   }

   public final void run() {
      try {
         int var1 = 0;

         do {
            if (!(GameCanvas.currentScreen instanceof GameScr)) {
               return;
            }

            if (System.currentTimeMillis() - this.time >= phong2.speedAll) {
               Service.gI().useItem(this.a.indexUI);
               Thread.sleep(phong2.speedAll);
               this.time = System.currentTimeMillis();
               ++var1;
               if (var1 >= this.a.quantity) {
                  break;
               }
            }
         } while(Code.solg_hanhtrang() > 0);
      } catch (InterruptedException var2) {
      }

   }

}
