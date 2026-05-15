package base.game2;
public final class upgrade_1 {
   int advAA, advAB, advAC;
   public upgrade_1(Item var1) {
      if (var1.r())      { advAA = GameScr.cy[var1.upgrade]; advAB = GameScr.dc[var1.upgrade]; }
      else if (var1.s()) { advAA = GameScr.cz[var1.upgrade]; advAB = GameScr.dd[var1.upgrade]; }
      else if (var1.t()) { advAA = GameScr.da[var1.upgrade]; advAB = GameScr.de[var1.upgrade]; }
      else               { advAA = 0; advAB = 0; }
      advAC = GameScr.df[var1.upgrade];
   }
}
