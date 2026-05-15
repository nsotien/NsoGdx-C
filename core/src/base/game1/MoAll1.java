package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MoAll1 implements Runnable {
   int count = 0;
   Item item;
   private long time;

   public MoAll1(Item it) {
      this.item = it;
   }

   public void run() {
      while(this.count < phong2.solgmoall && GameCanvas.currentScreen instanceof GameScr && Code.solg_hanhtrang() > 0) {
         if (System.currentTimeMillis() - this.time >= phong2.speedAll) {
            Service.gI().useItem(this.item.indexUI);
            ++this.count;
            phong.sleep(phong2.speedAll);
            this.time = System.currentTimeMillis();
         }
      }

   }

}
