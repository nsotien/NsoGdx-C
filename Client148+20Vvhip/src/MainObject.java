public class MainObject {
   public MyVector vecEFfect = new MyVector();

   public final void gameAA(mGraphics var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.vecEFfect.size(); ++var4) {
         DataSkillEff var5;
         if ((var5 = (DataSkillEff)this.vecEFfect.elementAt(var4)) != null) {
            var5.gameAA(var1, var2, var3);
         }
      }

   }

   public final void gameAB(mGraphics var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.vecEFfect.size(); ++var4) {
         DataSkillEff var5;
         if ((var5 = (DataSkillEff)this.vecEFfect.elementAt(var4)) != null) {
            var5.gameAB(var1, var2, var3);
         }
      }

   }

   public final void gameAA(byte var1, int var2) {
      for(int var3 = 0; var3 < this.vecEFfect.size(); ++var3) {
         DataSkillEff var4;
         if ((var4 = (DataSkillEff)this.vecEFfect.elementAt(var3)) != null) {
            var4.gameAA();
            if (var4.wantDetroy) {
               this.vecEFfect.removeElement(var4);
            }
         }
      }

      if (var1 == 0 && var2 == 14) {
         this.vecEFfect.removeAllElements();
      }

      if (var1 == 1 && var2 == 0) {
         this.vecEFfect.removeAllElements();
      }

   }
}
