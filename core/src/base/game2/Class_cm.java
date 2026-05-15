package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public final class Class_cm extends mScreen {
   public static int h;

   public final void d() {
      if (h > 5) {
         if (LanguageScr.f() >= 0) {
            GameCanvas.b();
            GameCanvas.ag.a();
         } else {
            GameCanvas.b();
            GameCanvas.ai.a();
         }
      }

      ++h;
   }

}
