package base.game1;

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
      DebugLog.trace("GOTO_MAP", "goMap(" + this.a + ") bắt đầu...");
      try {
         TileMap.goMap(this.a);
         DebugLog.trace("GOTO_MAP", "goMap(" + this.a + ") xong");
      } catch (Exception var2) {
         DebugLog.error("GOTO_MAP goMap exception", var2);
      }

      System.gc();
      if (Session_ME.a().f) {
         GameScr.gI().a();
      }

      GameCanvas.j();
      DebugLog.trace("GOTO_MAP", "GameCanvas.f = false → tắt loading screen");
      GameCanvas.f = false;
   }

}
