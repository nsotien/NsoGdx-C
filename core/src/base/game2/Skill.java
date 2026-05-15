package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Skill {
   public SkillTemplate template;
   public short skillId;
   public int point;
   public int level;
   public int coolDown;
   public long lastTimeUseThisSkill;
   public int dx;
   public int dy;
   public int maxFight;
   public int manaUse;
   public SkillOption[] k;
   public boolean l = false;

   public final void a(int var1, int var2, mGraphics var3) {
      SmallImage.a(var3, this.template.e, var1, var2, 0, StaticObj.g);
      long var6;
      if ((var6 = System.currentTimeMillis() - this.lastTimeUseThisSkill) < (long)this.coolDown) {
         var3.a(3355443);
         if (this.l && GameCanvas.w % 6 > 2) {
            var3.a(4473924);
         }

         int var8 = (int)(var6 * 18L / (long)this.coolDown);
         var3.c(var1 - 9, var2 - 9 + var8, 18, 18 - var8);
      } else {
         this.l = false;
      }

   }

   public final boolean a() {
      return System.currentTimeMillis() - this.lastTimeUseThisSkill < (long)this.coolDown;
   }

   public final int ngang() {
      return Code.fake_ngang ? Code.ngang : this.dx;
   }

   public final int cao() {
      return Code.fake_cao ? Code.cao : this.dy;
   }

}
