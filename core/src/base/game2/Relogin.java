package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Relogin implements Runnable {
   public static int[] time = new int[2];

   Relogin() {
      if (time[0] == -1) {
         time[1] = 3;  // disconnect bất ngờ: 3s (server có CD riêng)
      } else {
         time[1] = 1;  // từ countdown: đã chờ đủ rồi, connect luôn
      }

   }

   public void run() {
      int attempt = 0;
      do {
         attempt++;
         if (attempt > 10) {
            ;
            break;
         }
         try {
            ;
            GameCanvas.l();
            ;
            Session_ME.a().c();
            ;
            phong.sleep((long)time[1] * 1000L);
            ;
            GameCanvas.a(5);
            ;
            Service.gI().login(SelectServerScr.h, SelectServerScr.i, "2.5.1");
            ;
            phong.a(15000L);
            if (GameCanvas.giaylogin <= 0) {
               // Login accepted → select char + wait map
               ;
               String charName = phong.getReloginCharName();
               if (charName != null && charName.length() > 0) {
                  Service.gI().b(charName);
                  ;
                  phong.a(5000L);
               } else {
                  Code.popup_chat("NO_CHAR_TO_LOGIN");
                  phong.isDisconnect = false;
               }
            } else {
               ;
            }
         } catch (Exception var2) {
            ;
            ;
         }
         // Hybrid retry: nếu fail, dùng giaylogin từ server hoặc fallback 3s
         if (phong.isDisconnect && GameCanvas.currentScreen != GameScr.instance) {
            if (GameCanvas.giaylogin > 0) {
               time[1] = GameCanvas.giaylogin;  // sleep đúng server cooldown
               GameCanvas.giaylogin = 0;
               ;
            } else {
               time[1] = 3;  // Fallback 3s
               ;
            }
         }
         ;
      } while(phong.isDisconnect && GameCanvas.currentScreen != GameScr.instance);

      ;
      phong.isDisconnect = false;
   }

}
