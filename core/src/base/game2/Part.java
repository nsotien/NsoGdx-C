package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Part {
   public PartImage[] a;

   public Part(int var1) {
      if (var1 == 0) {
         this.a = new PartImage[8];
      }

      if (var1 == 1) {
         this.a = new PartImage[18];
      }

      if (var1 == 2) {
         this.a = new PartImage[10];
      }

      if (var1 == 3) {
         this.a = new PartImage[2];
      }

   }

}
