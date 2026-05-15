package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class goto_map implements Runnable {
   private final int a;

   goto_map(int var1) {
      this.a = var1;
   }

   public final void run() {
      try {
         TileMap.goMap(this.a);
      } catch (Exception var2) {
         ;
      }

      System.gc();
      if (Session_ME.a().f) {
         GameScr.gI().a();
      }

      GameCanvas.j();
      GameCanvas.f = false;
   }

}
