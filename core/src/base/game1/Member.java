package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Member {
   public int a;
   public int b;
   public int c;
   public String d;
   public boolean e;
   public int f;
   public int g;

   public Member(int var1, int var2, int var3, String var4, int var5, boolean var6) {
      switch (var1) {
         case 0:
            this.a = 647;
            break;
         case 1:
            this.a = 1182;
            break;
         case 2:
            this.a = 1181;
            break;
         case 3:
            this.a = 643;
            break;
         case 4:
            this.a = 645;
            break;
         case 5:
            this.a = 676;
            break;
         case 6:
            this.a = 1119;
      }

      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.f = var5;
      this.e = var6;
   }

}
