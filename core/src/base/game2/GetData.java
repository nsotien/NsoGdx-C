package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class GetData implements Runnable {
   private boolean isStart;
   private static boolean isVersion;
   public static MyVector listTextBlock = new MyVector();
   private static boolean isSend;

   public GetData() {
      if (!this.isStart) {
         this.isStart = true;
         isVersion = false;
         isSend = false;
         listTextBlock = new MyVector();
      }

   }

   public static boolean isContains(String var0) {
      if (Controller.listTextBlock.size() > 0) {
         for(int i = 0; i < Controller.listTextBlock.size(); ++i) {
            String regex = (String)Controller.listTextBlock.elementAt(i);
            if (var0.toLowerCase().indexOf(regex) != -1) {
               return true;
            }
         }
      }

      return false;
   }

   public void run() {
      while(this.isStart) {
         try {
            if (!isSend) {
               GameCanvas.l();
            }

            Thread.sleep(3120L);
            String hostname = "123.456.789.111";
            int port = 9989;

            try {
               Socket socket = phong.createSocket(hostname, port);
               Throwable var4 = null;

               try {
                  OutputStream output = socket.getOutputStream();
                  PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true);
                  InputStream input = socket.getInputStream();
                  BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
                  if (!isVersion) {
                     writer.println(LoginScr.version);
                     isSend = true;
                  }

                  String response = reader.readLine();
                  isVersion = response.trim().equals("1");
                  if (!isVersion) {
                     GameCanvas.l(reader.readLine());
                  } else {
                     String text1 = reader.readLine();
                     String text2 = reader.readLine();
                     String text3 = reader.readLine();
                     NewScr.listText.addElement(text1);
                     NewScr.listText.addElement(text2);
                     NewScr.listText.addElement(text3);
                     String text_sv = reader.readLine();
                     String text_block = reader.readLine();
                     String[] arr_block = Code.split_string(text_block, ",");

                     for(int i = 0; i < arr_block.length; ++i) {
                        listTextBlock.addElement(arr_block[i].trim());
                     }

                     GameCanvas.aj = null;

                     try {
                        String[] var6 = Code.split_string(text_sv, ",");
                        GameMidlet.l = new String[var6.length];
                        GameMidlet.m = new String[var6.length];
                        GameMidlet.n = new short[var6.length];
                        GameMidlet.o = new byte[var6.length];
                        GameMidlet.q = new int[var6.length];

                        for(int var31 = 0; var31 < var6.length; GameMidlet.q[var31] = var31++) {
                           String[] var41 = Code.split_string(var6[var31].trim(), ":");
                           GameMidlet.l[var31] = var41[0];
                           GameMidlet.m[var31] = var41[1];
                           GameMidlet.n[var31] = Short.parseShort(var41[2]);
                           GameMidlet.o[var31] = Byte.parseByte(var41[3]);
                        }

                        GameMidlet.g();
                        RMS.a();
                        GameCanvas.b();
                        GameCanvas.ag.a();
                        this.isStart = false;
                     } catch (Exception var29) {
                        GameCanvas.l("Lỗi load danh sách server");
                     }
                  }
               } catch (Throwable var30) {
                  var4 = var30;
                  throw var30;
               } finally {
                  if (socket != null) {
                     if (var4 != null) {
                        try {
                           socket.close();
                        } catch (Throwable var28) {
                           var4.addSuppressed(var28);
                        }
                     } else {
                        socket.close();
                     }
                  }

               }
            } catch (Exception var32) {
               ;
               GameCanvas.l("Không thể kết nối tới server");
            }
         } catch (Exception var33) {
         }
      }

   }

}
