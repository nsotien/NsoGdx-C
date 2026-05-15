package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class SplashScr extends mScreen {
   public static int splashScrStat;

   public final void d() {
      if (splashScrStat > 5) {
         if (LanguageScr.f() >= 0) {
            GameCanvas.b();
            GameCanvas.ag.a();
         } else {
            GameCanvas.b();
            GameCanvas.ai.a();
         }
      }

      ++splashScrStat;
   }

}
