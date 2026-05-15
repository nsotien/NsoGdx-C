package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainObject {
   public MyVector a = new MyVector();

   public final void a(mGraphics var1, int var2, int var3, int var4) {
      for(int var5 = 0; var5 < this.a.size(); ++var5) {
         DataSkillEff var6;
         if ((var6 = (DataSkillEff)this.a.elementAt(var5)) != null) {
            int var7 = var3;
            if (var6.f) {
               var7 = var3 + var4 + 4;
            }

            var6.a(var1, var2, var7);
         }
      }

   }

   public final void b(mGraphics var1, int var2, int var3, int var4) {
      for(int var5 = 0; var5 < this.a.size(); ++var5) {
         DataSkillEff var6;
         if ((var6 = (DataSkillEff)this.a.elementAt(var5)) != null) {
            int var7 = var3;
            if (var6.f) {
               var7 = var3 + var4 + 4;
            }

            var6.b(var1, var2, var7);
         }
      }

   }

   public final void a(byte var1, int var2) {
      for(int var3 = 0; var3 < this.a.size(); ++var3) {
         DataSkillEff var4;
         if ((var4 = (DataSkillEff)this.a.elementAt(var3)) != null) {
            var4.a();
            if (var4.s) {
               this.a.removeElement(var4);
            }
         }
      }

      if (var1 == 0 && var2 == 14) {
         this.a.removeAllElements();
      }

      if (var1 == 1 && var2 == 0) {
         this.a.removeAllElements();
      }

   }

   public final void a1(byte var1, int var2) {
      for(int var3 = 0; var3 < this.a.size(); ++var3) {
         DataSkillEff var4;
         if ((var4 = (DataSkillEff)this.a.elementAt(var3)) != null) {
            var4.a();
            if (var4.s) {
               this.a.removeElement(var4);
            }
         }
      }

      if (var1 == 0 && var2 == 14) {
         this.a.removeAllElements();
      }

      if (var1 == 1 && var2 == 0) {
         this.a.removeAllElements();
      }

   }

}
