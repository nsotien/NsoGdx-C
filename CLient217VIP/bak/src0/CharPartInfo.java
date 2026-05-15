public final class CharPartInfo {
   public static mHashtable gameAA = new mHashtable();
   public static mHashtable gameAB = new mHashtable();
   public static mHashtable gameAC = new mHashtable();
   public static mHashtable gameAD = new mHashtable();
   public static mHashtable gameAE = new mHashtable();
   public static mHashtable gameAF = new mHashtable();
   private static mHashtable gameAL = new mHashtable();
   public mHashtable gameAG = new mHashtable();
   public static mHashtable gameAH = new mHashtable();
   public int gameAI = 0;
   public int gameAJ = 0;
   public int gameAK;

   public static void gameAA(Message var0) {
      try {
         gameAC.gameAA.clear();
         gameAA.gameAA.clear();
         gameAB.gameAA.clear();
         gameAF.gameAA.clear();
         gameAD.gameAA.clear();
         gameAE.gameAA.clear();
         gameAH.gameAA.clear();
         int var1 = var0.reader().readUnsignedByte();

         for (int var2 = 0; var2 < var1; var2++) {
            byte var3 = var0.reader().readByte();
            short var4 = var0.reader().readShort();
            short var5 = var0.reader().readShort();
            CharPartInfo var6;
            (var6 = new CharPartInfo()).gameAK = var5;

            for (int var13 = 0; var13 < var3 - 2; var13 += 3) {
               short var7 = var0.reader().readShort();
               short var8 = var0.reader().readShort();
               short var9 = var0.reader().readShort();
               CharPartInfo var10;
               (var10 = new CharPartInfo()).gameAI = var8;
               var10.gameAJ = var9;
               var6.gameAG.gameAA(String.valueOf((int)var7), var10);
            }

            gameAA.gameAA(String.valueOf((int)var4), var6);
         }

         for (int var20 = 0; var20 < var1; var20++) {
            byte var3 = var0.reader().readByte();
            short var4 = var0.reader().readShort();
            short var5 = var0.reader().readShort();
            CharPartInfo var6;
            (var6 = new CharPartInfo()).gameAK = var5;

            for (int var13 = 0; var13 < var3 - 2; var13 += 3) {
               short var7 = var0.reader().readShort();
               short var8 = var0.reader().readShort();
               short var9 = var0.reader().readShort();
               CharPartInfo var10;
               (var10 = new CharPartInfo()).gameAI = var8;
               var10.gameAJ = var9;
               var6.gameAG.gameAA(String.valueOf((int)var7), var10);
            }

            gameAB.gameAA(String.valueOf((int)var4), var6);
         }

         for (int var21 = 0; var21 < var1; var21++) {
            byte var3 = var0.reader().readByte();
            short var4 = var0.reader().readShort();
            short var5 = var0.reader().readShort();
            CharPartInfo var6;
            (var6 = new CharPartInfo()).gameAK = var5;

            for (int var13 = 0; var13 < var3 - 2; var13 += 3) {
               short var7 = var0.reader().readShort();
               short var8 = var0.reader().readShort();
               short var9 = var0.reader().readShort();
               CharPartInfo var10;
               (var10 = new CharPartInfo()).gameAI = var8;
               var10.gameAJ = var9;
               var6.gameAG.gameAA(String.valueOf((int)var7), var10);
            }

            gameAC.gameAA(String.valueOf((int)var4), var6);
         }

         var1 = var0.reader().readUnsignedByte();

         for (int var22 = 0; var22 < var1; var22 += 2) {
            short var12 = var0.reader().readShort();
            short var4 = var0.reader().readShort();
            CharPartInfo var16;
            (var16 = new CharPartInfo()).gameAK = var4;
            gameAL.gameAA(String.valueOf((int)var12), var16);
         }

         var1 = var0.reader().readUnsignedByte();

         for (int var23 = 0; var23 < var1; var23++) {
            byte var3 = var0.reader().readByte();
            short var4 = var0.reader().readShort();
            short var5 = var0.reader().readShort();
            CharPartInfo var6;
            (var6 = new CharPartInfo()).gameAK = var5;

            for (int var13 = 0; var13 < var3 - 2; var13 += 3) {
               short var7 = var0.reader().readShort();
               short var8 = var0.reader().readShort();
               short var9 = var0.reader().readShort();
               CharPartInfo var10;
               (var10 = new CharPartInfo()).gameAI = var8;
               var10.gameAJ = var9;
               var6.gameAG.gameAA(String.valueOf((int)var7), var10);
            }

            gameAD.gameAA(String.valueOf((int)var4), var6);
         }

         for (int var24 = 0; var24 < var1; var24++) {
            byte var3 = var0.reader().readByte();
            short var4 = var0.reader().readShort();
            short var5 = var0.reader().readShort();
            CharPartInfo var6;
            (var6 = new CharPartInfo()).gameAK = var5;

            for (int var13 = 0; var13 < var3 - 2; var13 += 3) {
               short var7 = var0.reader().readShort();
               short var8 = var0.reader().readShort();
               short var9 = var0.reader().readShort();
               CharPartInfo var10;
               (var10 = new CharPartInfo()).gameAI = var8;
               var10.gameAJ = var9;
               var6.gameAG.gameAA(String.valueOf((int)var7), var10);
            }

            gameAE.gameAA(String.valueOf((int)var4), var6);
         }

         for (int var25 = 0; var25 < var1; var25++) {
            byte var3 = var0.reader().readByte();
            short var4 = var0.reader().readShort();
            short var5 = var0.reader().readShort();
            CharPartInfo var6;
            (var6 = new CharPartInfo()).gameAK = var5;

            for (int var13 = 0; var13 < var3 - 2; var13 += 3) {
               short var7 = var0.reader().readShort();
               short var8 = var0.reader().readShort();
               short var9 = var0.reader().readShort();
               CharPartInfo var10;
               (var10 = new CharPartInfo()).gameAI = var8;
               var10.gameAJ = var9;
               var6.gameAG.gameAA(String.valueOf((int)var7), var10);
            }

            gameAF.gameAA(String.valueOf((int)var4), var6);
         }

         byte var15 = var0.reader().readByte();

         for (int var14 = 0; var14 < var15; var14++) {
            short var4 = var0.reader().readShort();
            int[][] var17x = new int[6][];

            for (int var13 = 0; var13 < 6; var13++) {
               byte var18 = var0.reader().readByte();
               var17x[var13] = new int[var18];

               for (int var19 = 0; var19 < var18; var19++) {
                  var17x[var13][var19] = var0.reader().readShort();
               }
            }

            gameAH.gameAA(String.valueOf((int)var4), var17x);
         }
      } catch (Exception var171) {
      }
   }
}
