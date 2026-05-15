public final class ItemOption {
   public int param;
   public byte active;
   public ItemOptionTemplate optionTemplate;

   public ItemOption(int var1, int var2) {
      this.param = var2;
      this.optionTemplate = GameScr.gameBR[var1];
   }

   public final String gameAA() {
      return NinjaUtil.gameAA(this.optionTemplate.name, "#", String.valueOf(this.param));
   }

   public final String gameAB() {
      int var1;
      String var2;
      if (this.optionTemplate.id != 0 && this.optionTemplate.id != 1 && this.optionTemplate.id != 21 && this.optionTemplate.id != 22 && this.optionTemplate.id != 23 && this.optionTemplate.id != 24 && this.optionTemplate.id != 25 && this.optionTemplate.id != 26) {
         if (this.optionTemplate.id != 6 && this.optionTemplate.id != 7 && this.optionTemplate.id != 8 && this.optionTemplate.id != 9 && this.optionTemplate.id != 19) {
            if (this.optionTemplate.id != 2 && this.optionTemplate.id != 3 && this.optionTemplate.id != 4 && this.optionTemplate.id != 5 && this.optionTemplate.id != 10 && this.optionTemplate.id != 11 && this.optionTemplate.id != 12 && this.optionTemplate.id != 13 && this.optionTemplate.id != 14 && this.optionTemplate.id != 15 && this.optionTemplate.id != 17 && this.optionTemplate.id != 18 && this.optionTemplate.id != 20) {
               if (this.optionTemplate.id == 16) {
                  var1 = this.param - 3 + 1;
                  var2 = NinjaUtil.gameAA(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + var1 + "-" + this.param + ")";
               } else {
                  var2 = NinjaUtil.gameAA(this.optionTemplate.name, "#", String.valueOf(this.param));
               }
            } else {
               var1 = this.param - 5 + 1;
               var2 = NinjaUtil.gameAA(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + var1 + "-" + this.param + ")";
            }
         } else {
            var1 = this.param - 10 + 1;
            var2 = NinjaUtil.gameAA(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + var1 + "-" + this.param + ")";
         }
      } else {
         var1 = this.param - 50 + 1;
         var2 = NinjaUtil.gameAA(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + var1 + "-" + this.param + ")";
      }

      return var2;
   }
}
