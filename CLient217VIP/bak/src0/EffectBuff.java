public final class EffectBuff {
   public static EffectTemplate[] effTemplates;
   public int timeStart;
   public int timeLenght;
   public short param;
   public EffectTemplate template;

   public EffectBuff(byte var1, int var2, int var3, short var4) {
      this.template = effTemplates[var1];
      this.timeStart = var2;
      this.timeLenght = var3 / 1000;
      this.param = var4;
   }
}
