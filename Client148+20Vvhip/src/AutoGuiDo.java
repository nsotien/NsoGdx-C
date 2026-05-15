public final class AutoGuiDo extends Auto {
   private boolean gameAD;
   private String gameAE;
   public static boolean gameAA;
   public static boolean gameAB;
   public static boolean gameAC;

   public AutoGuiDo(int var1, int var2, String var3) {
      super.gameAC();
      this.gameAD = false;
      super.mapID = var1;
      super.zoneID = var2;
      this.gameAE = var3;
   }

   public final void gameAK() {
      if (Char.getMyChar().cHP <= 0) {
         Auto.gameAA(true);
      } else {
        if (super.mapID == TileMap.mapID && super.zoneID == TileMap.zoneID) {
            if (!this.gameAD) {
               AutoSell.gameAV = false;
               gameAA = false;
               gameAC = false;
               if (SetGomDo.itemgd.equals("")) {
                  GameScr.gameAC("Hãy Thêm Item Cần Giao Dịch!");
                  Code.gameAC();
                  return;
               }

               while(true) {
                  int var7;
                  int var8;
                  Item var9;
                  if (gamezAE() <= 0 && gamezAF() > 0) {
                     for(var7 = 0; var7 < Code.gameAC(SetGomDo.itemgd, ",").length; ++var7) {
                        GameScr.gI().gameAD((int)4);

                        for(var8 = 0; var8 < Char.getMyChar().arrItemBox.length; ++var8) {
                           var9 = Char.getMyChar().arrItemBox[var8];
                           if (var9 != null && var9.template.id ==  Integer.parseInt(Code.gameAC(SetGomDo.itemgd, ",")[var7]) && !var9.isLock) {
                              Service.gI().gameAD(var9.indexUI);
                           }
                        }
                     }
                  }

                  Auto.Sleep(1000L);
                  AutoNhan.gameAA(this.gameAE);
                  if (gamezAE() <= 0) {
                     if (gamezAF() <= 0) {
                        break;
                     }

                     for(var7 = 0; var7 < Code.gameAC(SetGomDo.itemgd, ",").length; ++var7) {
                        GameScr.gI().gameAD((int)4);

                        for(var8 = 0; var8 < Char.getMyChar().arrItemBox.length; ++var8) {
                           var9 = Char.getMyChar().arrItemBox[var8];
                           if (var9 != null && var9.template.id ==  Integer.parseInt(Code.gameAC(SetGomDo.itemgd, ",")[var7]) && !var9.isLock) {
                              Service.gI().gameAD(var9.indexUI);
                           }
                        }
                     }
                  }

                  if (gameAC) {
                     break;
                  }

                  if (gameAA) {
                     GameScr.gameAC("Hành trang đối phương không còn đủ chỗ trống!");
                     break;
                  }

                  for(var7 = 0; var7 < 30; ++var7) {
                     Auto.Sleep((long)(AutoNhan.gameAH.nextInt(1200) + 1000));
                     GameScr.gameAC("Chờ " + (30 - var7) + " s để gd tiếp !");
                  }
               }

               if (!gameAA) {
                  GameScr.gameAC("Đã hết vp cần gd trong hành trang, Hoặc đối phương k có trong khu vực này ! !");
               }

               this.gameAD = true;
            } else if (Res.gameAB().get(12) != AutoNhan.phutnhan) {
               Code.gameAC();
            }
         } else if (gamezAE() + gamezAF() < 2 || super.mapID == TileMap.mapID && super.zoneID == TileMap.zoneID) {
            Code.gameAC();

            for(int var1 = 0; var1 < Code.gameAC(AutoNhan.nguoinhan, ",").length; ++var1) {
               Service.gI().gameAA(Code.gameAC(AutoNhan.nguoinhan, ",")[var1], "Chưa có đồ em ơi !");
            }
         } else {
            this.gameAA(super.mapID, super.zoneID, -1, -1);
         }

      }
   }

   public final String toString() {
      return "Auto Send";
   }

   public static int gamezAE() {
      Item[] var7 = Char.getMyChar().arrItemBag;
      int var0 = 0;

      for(int var1 = 0; var1 < Code.gameAC(SetGomDo.itemgd, ",").length; ++var1) {
         for(int var2 = 0; var2 < var7.length; ++var2) {
            Item var8;
            if ((var8 = var7[var2]) != null && var8.template.id ==  Integer.parseInt(Code.gameAC(SetGomDo.itemgd, ",")[var1]) && !var8.isLock) {
               if (var8.template.isUpToUp) {
                  var0 += var8.quantity;
               } else {
                  ++var0;
               }
            }
         }
      }

      return var0;
   }

   public static int gamezAF() {
      Item[] var7 = Char.getMyChar().arrItemBox;
      int var0 = 0;

      for(int var1 = 0; var1 < Code.gameAC(SetGomDo.itemgd, ",").length; ++var1) {
         for(int var2 = 0; var2 < var7.length; ++var2) {
            Item var8;
            if ((var8 = var7[var2]) != null && var8.template.id ==  Integer.parseInt(Code.gameAC(SetGomDo.itemgd, ",")[var1]) && !var8.isLock) {
               if (var8.template.isUpToUp) {
                  var0 += var8.quantity;
               } else {
                  ++var0;
               }
            }
         }
      }

      return var0;
   }

   public static int gameaAA(int var0) {
      Item[] var5 = Char.getMyChar().arrItemBox;
      int var7 = 0;

      for(int var9 = 0; var9 < var5.length; ++var9) {
         Item var6;
         if ((var6 = var5[var9]) != null && var6.template.id == var0 && !var6.isLock) {
            ++var7;
         }
      }

      return var7;
   }

   public static void gameaAB(int var0) {
      for(int var7 = 0; var7 < Char.getMyChar().arrItemBox.length; ++var7) {
         Item var8 = Char.getMyChar().arrItemBox[var7];
         if (var8 != null && var8.template.id == var0 && !var8.isLock) {
            Service.gI().gameAD(var8.indexUI);
         }
      }

   }
}
