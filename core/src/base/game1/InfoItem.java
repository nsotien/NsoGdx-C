package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class InfoItem {
   public String a;
   mFont b;
   public int c;

   public InfoItem(String var1) {
      this.b = mFont.i;
      this.a = var1;
      this.c = 20;
   }

   public InfoItem(String var1, mFont var2, int var3) {
      this.b = var2;
      this.a = var1;
      this.c = var3;
   }

}
