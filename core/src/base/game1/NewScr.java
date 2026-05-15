package base.game1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public class NewScr extends mScreen {
   private static NewScr b;
   private static Image c;
   private static String d = null;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private String j = "";
   private int k = 0;
   private long l = 0L;
   public static long a = 0L;
   public static MyVector listText = new MyVector();
   public static String text4 = "";

   public static NewScr gI() {
      c = a(getByteFromFile("x1/tt.png", 0));
      LoginScr.h = a(getByteFromFile("x1/tt.png", 1));
      listText = new MyVector();
      startGetData();
      if (b == null) {
         b = new NewScr();
      }

      return b;
   }

   private static byte[] getByteFromFile(String var0, int index) {
      if (GameMidlet.b(var0) == null) {
         return null;
      } else {
         String[] text = GameMidlet.b(var0).split("_nsotien_");
         if (index >= text.length) return null;
         String[] text_2 = text[index].split(",");
         byte[] arr = new byte[text_2.length];

         for(int i = 0; i < text_2.length; ++i) {
            if (!text_2[i].equals("")) {
               try {
                  arr[i] = Byte.parseByte(text_2[i]);
               } catch (Exception var7) {
               }
            }
         }

         return arr;
      }
   }

   private static Image a(byte[] var0) {
      if (var0 == null) return null;
      ByteArrayInputStream var1 = new ByteArrayInputStream(var0);

      try {
         return Image.createImage(var1);
      } catch (Exception var3) {
         return null;
      }
   }

   public final void a() {
      GameScr.j = GameCanvas.ab;
      if (GameCanvas.at == 2) {
         GameCanvas.b(0);
      } else {
         GameCanvas.b(TileMap.versionMap);
      }

      super.a();
      if (GameScr.instance != null) {
         GameScr.instance = null;
      }

      if ((TileMap.versionMap = (byte)((int)(System.currentTimeMillis() % 9L))) == 5 || TileMap.versionMap == 6) {
         TileMap.versionMap = 4;
      }

      GameScr.a(true);
      GameScr.p = 100;
      this.f = 120;
      this.g = 38;
      this.h = GameCanvas.aa / 2 - this.f / 2;
      this.i = GameCanvas.ab / 2 - this.g / 2 + 22;
      this.e = 0;
      if (d == null) {
         d = "NsoTien Tv";
      }

      // Fetch server list from remote URL (TGAME original flow)
      Client.fakeStart();
   }


   // tắt
   public final void a(mGraphics var1) {
//      var1.a(0);
//      var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
//      GameCanvas.a(var1);
//      var1.a(c, GameCanvas.ac, this.e, 3);
//      Paint.a(this.h, this.i, this.f, this.g, var1);
//      var1.a(Paint.c);
//      var1.b(GameCanvas.ac - mFont.o.a("Khu Vực") / 2 - 22, this.i + 7, mFont.o.a("Khu Vực") + 40, 24, 6, 6);
//      var1.a(Paint.b);
//      var1.a(GameCanvas.ac - mFont.o.a("Khu Vực") / 2 - 22, this.i + 7, mFont.o.a("Khu Vực") + 40, 24, 6, 6);
//      mFont.o.a(var1, this.j, GameCanvas.ac, this.i + 12, 2);
//      super.a(var1);
//      if (GameCanvas.aj == null) {
//         Paint.a(var1, super.a, super.b, super.c);
//      }

   }

   public final void show() {
      // BYPASS activation key — go directly
      DebugLog.log("NewScr", "show() called");
   }

   public final void d() {
//      if (this.k < d.length() && System.currentTimeMillis() - this.l >= 100L) {
//         this.j = this.j + d.charAt(this.k);
//         ++this.k;
//         this.l = System.currentTimeMillis();
//      }
//
//      if ((this.e += 2) >= this.i - 60) {
//         this.e = this.i - 60;
//         if (a == 0L) {
//            a = System.currentTimeMillis();
//            byte[] dataKey = RMS.a("data_key");
//            if (dataKey != null) {
//               Client.gI.startActive();
//            } else {
//               GameCanvas.al.a1("Nhập key kích hoạt", new Command1("OK", GameCanvas.instance, 2042001, (Object)null), 0);
//               GameCanvas.al.a.a("");
//            }
//         }
//      }
//
//      if (++GameScr.p > GameCanvas.aa * 3 + 100) {
//         GameScr.p = 100;
//      }

      super.d();
   }

   private static void startGetData() {
      (new Thread(new Controller())).start();
   }

}
