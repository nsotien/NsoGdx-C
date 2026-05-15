public final class AutoSell extends Auto {
   private int gameAW;
   private int gameAX;
   private boolean gameAY;
   private boolean gameAZ;
   private boolean gameBA;
   private String gameBB;
   private MyVector gameBC;
   private MyVector gameBD;
   private long gameBE;
   public static boolean gameAV;

   public final void gameAA(String var1, int var2) {
      if (ChatSell.gameAC()) {
         Service.gI().gameAL(var2);
         this.gameBB = var1;
         this.gameBA = true;
         this.gameAZ = true;
         this.gameBC = null;
         this.gameBD = null;
         this.gameAY = true;
      } else {
         Service.gI().gameAH();
         Code.gameAA(var1, "<Hiện mk ko mua vp nào>");
      }
   }

   public final void gameAA(String var1, String var2) {
      String[] var15 = Code.gameAC(var2, " ");
      if (this.gameAY) {
         if (!GameScr.isPaintTrade) {
            Code.gameAA(var1, "<Đang giao dịch với người khác. Mong bạn chờ giây lát>");
            return;
         }
      } else {
         MyVector var3;
         MyVector var4;
         int var5;
         int var6;
         int var7;
         String var8;
         String var9;
         RMS var10;
         int var11;
         int var12;
         if (var15[0].toLowerCase().equals("buy")) {
            var3 = new MyVector();
            var4 = new MyVector();
            var5 = 0;
            var6 = 1;

            for(var7 = var15.length - 1; var6 <= var7; var6 += 2) {
               var8 = var15[var6];
               var9 = var15[var6 + 1];
               if ((var10 = ChatSell.gameAA(var8)) != null && var10.gameAC > 0) {
                  if (var10.gameAC > 0 && Char.gameAK(var10.gameAA.id) <= var10.gameAE) {
                     Code.gameAA(var1, "<" + var8 + " hết hàng>");
                  } else {
                     try {
                        var11 = Integer.parseInt(var9);
                     } catch (Exception var13) {
                        Code.gameAA(var1, "<" + var8 + " số lượng lỗi>");
                        continue;
                     }

                     if (var10.gameAC() < var11) {
                        Code.gameAA(var1, "<" + var8 + " số lượng Item này hiện không đủ>");
                     } else {
                        var12 = var10.gameAA.isUpToUp ? 1 : var11;
                        if (var5 + var12 > 12) {
                           Code.gameAA(var1, "<" + var8 + " số lượng đầy. VP sau sẽ k dc tính>");
                           break;
                        }

                        var5 += var12;
                        var3.addElement(var10);
                        var4.addElement(new Integer(var11));
                     }
                  }
               } else {
                  Code.gameAA(var1, "<" + var8 + " ko tồn tại hoặc mk ko bán vp này>");
               }
            }

            if (var3.size() == 0) {
               Code.gameAA(var1, "<Giao dịch rỗng>");
               return;
            }

            this.gameBB = var1;
            this.gameBA = false;
            this.gameBC = var3;
            this.gameBD = var4;
            this.gameAY = true;
            return;
         }

         if (!var15[0].toLowerCase().equals("mua")) {
            if (var15[0].toLowerCase().equals("donate")) {
               this.gameBB = var1;
               this.gameBA = false;
               this.gameBC = null;
               this.gameBD = null;
               this.gameAY = true;
               return;
            }

            if (var15[0].toLowerCase().equals("sell")) {
               if (ChatSell.gameAC()) {
                  this.gameBB = var1;
                  this.gameBA = true;
                  this.gameAZ = false;
                  this.gameBC = null;
                  this.gameBD = null;
                  this.gameAY = true;
                  return;
               }

               Code.gameAA(var1, "<Hiện mk ko mua vp nào>");
               return;
            }

            Code.gameAA(var1, "<Bán hàng tự động v4 By Leo>");
            Code.gameAA(var1, "<Danh sách hàng>");
            ChatSell.gameAB(var1);
            Code.gameAA(var1, "<-------------------------->");
            ChatSell.gameAC(var1);
            Code.gameAA(var1, "<-------------------------->");
            return;
         }

         var3 = new MyVector();
         var4 = new MyVector();
         var5 = 0;
         var6 = 1;

         for(var7 = var15.length - 1; var6 <= var7; var6 += 2) {
            var8 = var15[var6];
            if ((var10 = ChatSell.gameAA(var9 = var15[var6 + 1])) != null && var10.gameAC > 0) {
               if (var10.gameAC > 0 && Char.gameAK(var10.gameAA.id) <= var10.gameAE) {
                  Code.gameAA(var1, "<" + var9 + " hết hàng>");
               } else {
                  try {
                     var11 = Integer.parseInt(var8);
                  } catch (Exception var14) {
                     Code.gameAA(var1, "<" + var9 + " số lượng lỗi>");
                     continue;
                  }

                  if (var10.gameAC() < var11) {
                     Code.gameAA(var1, "<" + var9 + " số lượng Item này hiện không đủ>");
                  } else {
                     var12 = var10.gameAA.isUpToUp ? 1 : var11;
                     if (var5 + var12 > 12) {
                        Code.gameAA(var1, "<" + var9 + " số lượng đầy. VP sau sẽ k dc tính>");
                        break;
                     }

                     var5 += var12;
                     var3.addElement(var10);
                     var4.addElement(new Integer(var11));
                  }
               }
            } else {
               Code.gameAA(var1, "<" + var9 + " ko tồn tại hoặc mk ko bán vp này>");
            }
         }

         if (var3.size() == 0) {
            Code.gameAA(var1, "<Giao dịch rỗng>");
            return;
         }

         this.gameBB = var1;
         this.gameBA = false;
         this.gameBC = var3;
         this.gameBD = var4;
         this.gameAY = true;
      }

   }

   public final void gameAC() {
      super.gameAC();
      super.mapID = TileMap.mapID;
      super.zoneID = TileMap.zoneID;
      this.gameAW = Char.getMyChar().cx;
      this.gameAX = Char.getMyChar().cy;
      this.gameBE = 0L;
      this.gameAY = false;
      ChatSell.gameAA = -1;
   }

   private void gameAE(Char var1) {
      Item[] var2 = new Item[12];
      gameAV = false;
      long var3;
      if (!this.gameAZ) {
         if (!Char.gameAD(var1.cx, var1.cy)) {
            Code.gameAA(this.gameBB, "<Hãy đứng ở nơi dễ GD>");
            return;
         }

         Service.gI().gameAS(var1.charID);
         if (!LockGame.gameBA()) {
            if (GameScr.isPaintTrade) {
               try {
                  Service.gI().gameAI();
                  Thread.sleep(1000L);
               } catch (InterruptedException var8) {
                  var8.printStackTrace();
               }
            }

            Code.gameAA(this.gameBB, "<Hãy đồng ý giao dịch>");
            return;
         }
      } else {
         var3 = System.currentTimeMillis();

         while(!GameScr.isPaintTrade || System.currentTimeMillis() - var3 >= 10000L) {
            try {
               Thread.sleep(1000L);
            } catch (InterruptedException var13) {
               var13.printStackTrace();
            }
         }
      }

      var3 = System.currentTimeMillis();

      while(GameScr.gI().typeTradeOrder != 1) {
         try {
            if (gameAV || System.currentTimeMillis() - var3 >= 20000L) {
               if (GameScr.isPaintTrade) {
                  Service.gI().gameAI();
                  Thread.sleep(1000L);
               }

               Code.gameAA(this.gameBB, "<Hãy giao dịch lại>");
               return;
            }

            Thread.sleep(200L);
         } catch (InterruptedException var15) {
            var15.printStackTrace();
         }
      }

      MyVector var16 = new MyVector();
      MyVector var17 = new MyVector();

      int var4;
      int var5;
      int var6;
      RMS var7;
      for(var4 = 0; var4 < GameScr.gameCX.length; ++var4) {
         if (GameScr.gameCX[var4] != null) {
            if ((var7 = ChatSell.gameAA(GameScr.gameCX[var4].template.id)) == null || !var7.gameAB()) {
               if (GameScr.isPaintTrade) {
                  try {
                     Service.gI().gameAI();
                     Thread.sleep(1000L);
                  } catch (InterruptedException var9) {
                     var9.printStackTrace();
                  }
               }

               Code.gameAA(this.gameBB, "<Item " + var4 + ": bạn đã GD vp mk ko mua>");
               return;
            }

            var6 = GameScr.gameCX[var4].template.isUpToUp ? GameScr.gameCX[var4].indexUI : 1;
            if (var16.contains(var7)) {
               var5 = var16.indexOf(var7);
               var6 += ((Integer)var17.elementAt(var5)).intValue();
               var17.setElementAt(new Integer(var6), var5);
            } else {
               var16.addElement(var7);
               var17.addElement(new Integer(var6));
            }
         }
      }

      if (var16.size() == 0) {
         if (GameScr.isPaintTrade) {
            try {
               Service.gI().gameAI();
               Thread.sleep(1000L);
            } catch (InterruptedException var10) {
               var10.printStackTrace();
            }
         }

         Code.gameAA(this.gameBB, "<Giao dịch trống>");
      } else {
         var4 = 0;

         for(var6 = 0; var6 < var16.size(); ++var6) {
            var7 = (RMS)var16.elementAt(var6);
            var5 = ((Integer)var17.elementAt(var6)).intValue();
            if (Char.gameAK(var7.gameAA.id) + var5 > var7.gameAH) {
               if (GameScr.isPaintTrade) {
                  try {
                     Service.gI().gameAI();
                     Thread.sleep(1000L);
                  } catch (InterruptedException var11) {
                     var11.printStackTrace();
                  }
               }

               Code.gameAA(this.gameBB, "<" + var7.gameAA.name + " bạn đá bán quá số mk cần mua>");
               return;
            }

            var4 += var5 * var7.gameAG * 1000 / var7.gameAF;
         }

         if (var4 > Char.getMyChar().xu) {
            if (GameScr.isPaintTrade) {
               Service.gI().gameAI();
            }

            Code.gameAA(this.gameBB, "<Hiện mk ko đủ xu, xin bạn quay lại sau>");
         } else {
            GameScr.gI().gameEE = var4;
            GameScr.gameCW = var2;
            Service.gI().gameAA(var4, var2);
            GameScr.gI().gameEC = 1;
            var3 = System.currentTimeMillis();

            while(System.currentTimeMillis() - var3 < 5000L) {
               try {
                  if (gameAV) {
                     Code.gameAA(this.gameBB, "<Hãy giao dịch lại>");
                     return;
                  }

                  Thread.sleep(200L);
               } catch (InterruptedException var12) {
                  var12.printStackTrace();
               }
            }

            Service.gI().gameAJ();
            GameScr.gI().gameEC = 2;

            while(GameScr.gI().gameEE < 2) {
               try {
                  if (gameAV || System.currentTimeMillis() - var3 >= 20000L) {
                     if (GameScr.isPaintTrade) {
                        Service.gI().gameAI();
                        Thread.sleep(1000L);
                     }

                     Code.gameAA(this.gameBB, "<Hãy giao dịch lại>");
                     return;
                  }

                  Thread.sleep(200L);
               } catch (InterruptedException var14) {
                  var14.printStackTrace();
               }
            }

         }
      }
   }

   private void gameAF(Char var1) {
      Item[] var2 = new Item[12];
      int var3 = 0;
      int var4 = 0;
      boolean var5 = false;
      int var6;
      int var7;
      if (this.gameBC != null) {
         for(var6 = 0; var6 < this.gameBC.size(); ++var6) {
            RMS var8 = (RMS)this.gameBC.elementAt(var6);
            var7 = ((Integer)this.gameBD.elementAt(var6)).intValue();
            if (var8.gameAA.isUpToUp) {
               Item var9;
               if ((var9 = Char.gameAF(var8.gameAA.id)) == null) {
                  Code.gameAA(this.gameBB, "<Xin lỗi, có lỗi chọn item>");
                  return;
               }

               Service.gI().gameAK(var9.indexUI, var7);
               LockGame.gameAS();
               if ((var9 = Char.gameAB(var8.gameAA.id, var7)) == null) {
                  Code.gameAA(this.gameBB, "<Xin lỗi, có lỗi chọn item>");
                  return;
               }

               var2[var3++] = var9;
               var5 = true;
            } else {
               Char var21 = Char.getMyChar();
               int var10 = 0;
               if (var7 > 0) {
                  for(; var10 < var21.arrItemBag.length; ++var10) {
                     Item var18;
                     if ((var18 = var21.arrItemBag[var10]) != null && var18.template.id == var8.gameAA.id) {
                        var2[var3++] = var18;
                     }
                  }

                  Code.gameAA(this.gameBB, "<Xin lỗi, có lỗi chọn item>");
                  return;
               }
            }

            var4 += var7 * var8.gameAD * 1000 / var8.gameAC;
         }

         if (var4 == 0) {
            var4 = 1;
         }
      }

      gameAV = false;
      if (!Char.gameAD(var1.cx, var1.cy)) {
         Code.gameAA(this.gameBB, "<Hãy đứng ở nơi dễ GD>");
         if (var5) {
            Service.gI().gameAF();
            LockGame.gameAS();
         }
      } else {
         Service.gI().gameAS(var1.charID);
         if (!LockGame.gameBA()) {
            if (GameScr.isPaintTrade) {
               try {
                  Service.gI().gameAI();
                  Thread.sleep(1000L);
               } catch (InterruptedException var11) {
                  var11.printStackTrace();
               }
            }

            if (var5) {
               Service.gI().gameAF();
               LockGame.gameAS();
            }

            Code.gameAA(this.gameBB, "<Hãy đồng ý giao dịch>");
         } else {
            GameScr.gI().gameEE = 0;
            GameScr.gameCW = new Item[12];

            for(var6 = 0; var6 < 12; ++var6) {
               GameScr.gameCW[var6] = var2[var6];
               if (var2[var6] != null && var2[var6].indexUI >= 0 && var2[var6].indexUI < Char.getMyChar().arrItemBag.length) {
                  int var19 = var2[var6].indexUI;
                  Char.getMyChar().arrItemBag[var19] = null;
               }
            }

            Service.gI().gameAA((int)0, (Item[])var2);
            GameScr.gI().gameEC = 1;
            long var20 = System.currentTimeMillis();

            while(GameScr.gI().typeTradeOrder != 1) {
               try {
                  if (gameAV || System.currentTimeMillis() - var20 >= 20000L) {
                     if (GameScr.isPaintTrade) {
                        try {
                           Service.gI().gameAI();
                           Thread.sleep(1000L);
                        } catch (InterruptedException var15) {
                           var15.printStackTrace();
                        }
                     }

                     if (var5) {
                        Service.gI().gameAF();
                        LockGame.gameAS();
                     }

                     Code.gameAA(this.gameBB, "<Hãy giao dịch lại>");
                     return;
                  }

                  Thread.sleep(200L);
               } catch (InterruptedException var17) {
                  var17.printStackTrace();
               }
            }

            var20 = System.currentTimeMillis();
            if (GameScr.gI().gameEF < var4) {
               if (GameScr.isPaintTrade) {
                  try {
                     Service.gI().gameAI();
                     Thread.sleep(1000L);
                  } catch (InterruptedException var12) {
                     var12.printStackTrace();
                  }
               }

               if (var5) {
                  Service.gI().gameAF();
                  LockGame.gameAS();
               }

               Code.gameAA(this.gameBB, "<Không đủ xu>");
            } else {
               for(var7 = 0; var7 < GameScr.gameCX.length; ++var7) {
                  if (GameScr.gameCX[var7] != null && ChatSell.gameAA(GameScr.gameCX[var7].template.id) == null) {
                     if (GameScr.isPaintTrade) {
                        try {
                           Service.gI().gameAI();
                           Thread.sleep(1000L);
                        } catch (InterruptedException var13) {
                           var13.printStackTrace();
                        }
                     }

                     if (var5) {
                        Service.gI().gameAF();
                        LockGame.gameAS();
                     }

                     Code.gameAA(this.gameBB, "<Chỉ GD xu>");
                     return;
                  }
               }

               while(System.currentTimeMillis() - var20 < 6000L) {
                  try {
                     if (gameAV) {
                        if (var5) {
                           Service.gI().gameAF();
                           LockGame.gameAS();
                        }

                        Code.gameAA(this.gameBB, "<Hãy giao dịch lại>");
                        return;
                     }

                     Thread.sleep(200L);
                  } catch (InterruptedException var14) {
                     var14.printStackTrace();
                  }
               }

               Service.gI().gameAJ();
               GameScr.gI().gameEC = 2;

               while(GameScr.gI().typeTradeOrder < 2) {
                  try {
                     if (gameAV || System.currentTimeMillis() - var20 >= 20000L) {
                        if (GameScr.isPaintTrade) {
                           Service.gI().gameAI();
                           Thread.sleep(1000L);
                        }

                        if (var5) {
                           Service.gI().gameAF();
                           LockGame.gameAS();
                        }

                        Code.gameAA(this.gameBB, "<Hãy giao dịch lại>");
                        return;
                     }

                     Thread.sleep(200L);
                  } catch (InterruptedException var16) {
                     var16.printStackTrace();
                  }
               }

            }
         }
      }
   }

   public final void gameAK() {
      if (Auto.reAC()) {
         Auto.gameAA(true);
      } else {
         if (super.mapID == TileMap.mapID && super.zoneID == TileMap.zoneID) {
            String var1;
            if (!this.gameAY) {
               if (Char.getMyChar().cx != this.gameAW || Char.getMyChar().cy != this.gameAX) {
                  try {
                     Char.gameAC(this.gameAW, this.gameAX);
                     Thread.sleep(500L);
                  } catch (InterruptedException var4) {
                     var4.printStackTrace();
                  }
               }

               if (System.currentTimeMillis() - this.gameBE >= 5000L && !(var1 = ChatSell.gameAB()).equals("")) {
                  Service.gI().gameAC(var1);
                  this.gameBE = System.currentTimeMillis();
               }

               return;
            }

            var1 = this.gameBB;

            Char var3;
            Char var6;
            label64: {
               for(int var2 = 0; var2 < GameScr.vCharInMap.size(); ++var2) {
                  if ((var3 = (Char)GameScr.vCharInMap.elementAt(var2)).cName.equals(var1)) {
                     var6 = var3;
                     break label64;
                  }
               }

               var6 = null;
            }

            var3 = var6;
            if (var6 == null) {
               if (this.gameBB != null) {
                  Code.gameAA(this.gameBB, "<Hãy đến " + TileMap.mapNames[TileMap.mapID] + " khu " + TileMap.zoneID + " để giao dịch>");
               }

               this.gameAY = false;
            } else {
               try {
                  if (this.gameBA) {
                     this.gameAE(var3);
                  } else {
                     this.gameAF(var3);
                  }

                  Thread.sleep(500L);
                  this.gameAY = false;
               } catch (InterruptedException var5) {
                  var5.printStackTrace();
                  return;
               }
            }
         } else {
            this.gameAA(super.mapID, super.zoneID, -1, -1);
         }

      }
   }

   public final String toString() {
      return "Auto Sell";
   }
}
