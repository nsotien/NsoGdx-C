package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class SkillOption {
   public int a;
   public SkillOptionTemplate b;
   private String c;

   public final String a() {
      if (this.c == null) {
         if (this.b.a != 62 && this.b.a != 64 && this.b.a != 70) {
            this.c = NinjaUtil.a(this.b.b, "#", String.valueOf(this.a));
         } else {
            float var1 = (float)this.a / 1000.0F;
            this.c = NinjaUtil.a(this.b.b, "#", String.valueOf(var1));
         }
      }

      return this.c;
   }

}
