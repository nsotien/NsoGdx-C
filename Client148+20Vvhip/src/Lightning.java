public final class Lightning extends Effect2 {
   private int[] color = new int[]{16579837, 11188220};
   private MyVector listPos = new MyVector();
   private MyVector[] list;
   private EPosition posangle;
   private long timeDel;
   private boolean isContinue;
   private boolean isRemove = true;
   private int tick;
   private int cou;
   private int dem;
   private int aa = 7;

   public static void gameAA(MyVector var0, EPosition var1, boolean var2, int var3) {
      Lightning var5;
      (var5 = new Lightning()).color[1] = var3;

      for(var3 = 0; var3 < var0.size(); ++var3) {
         EPosition var4;
         if ((var4 = (EPosition)var0.elementAt(var3)) != null && (Res.abs(var4.x - var1.x) >= 100 || Res.abs(var4.y - var1.y) >= 50)) {
            var0.removeElementAt(var3);
         }
      }

      var5.gameAA(var0, var1, true);
      Effect2.vEffect2.addElement(var5);
   }

   private void gameAA(MyVector var1, EPosition var2, boolean var3) {
      if (var1.size() != 0) {
         this.isContinue = var3;
         MyVector var4;
         int var5;
         int var8;
         EPosition var9;
         int var10;
         EPosition var11;
         if (!var3) {
            var4 = var1;
            var5 = var1.size();

            for(var8 = 0; var8 < var5 - 1; ++var8) {
               var9 = (EPosition)var4.elementAt(var8);

               for(var10 = var8 + 1; var10 < var5; ++var10) {
                  var11 = (EPosition)var4.elementAt(var10);
                  if (var9.x > var11.x) {
                     var4.setElementAt(var9, var10);
                     var4.setElementAt(var11, var8);
                     var9 = var11;
                  }
               }
            }
         }

         this.listPos = var1;
         this.posangle = var2;
         this.list = new MyVector[var1.size()];

         int var16;
         for(var16 = 0; var16 < this.list.length; ++var16) {
            this.list[var16] = new MyVector();
         }

         var2.follow = -1;
         this.list[0].addElement(var2);
         var16 = -1;
         var5 = 0;

         int var6;
         int var12;
         int var13;
         int var14;
         int var15;
         EPosition var18;
         int var19;
         int var20;
         while(var5 < var1.size()) {
            var6 = var2.x;
            int var7 = var2.y;
            if (var3 && var16 != -1) {
               var6 = (var18 = (EPosition)var1.elementAt(var16)).x;
               var7 = var18.y;
            }

            int var10000;
            if (var3) {
               var10000 = var16 + 1;
            } else {
               var4 = var1;
               var8 = 0;

               for(var19 = 0; var19 < var4.size(); ++var19) {
                  if (((EPosition)var4.elementAt(var19)).index == -1) {
                     ++var8;
                  }
               }

               if (var8 != 0) {
                  var8 = Res.gameAD(var8);
                  var19 = 0;
                  var10 = 0;

                  while(true) {
                     if (var10 >= var4.size()) {
                        var10000 = -1;
                        break;
                     }

                     if ((var11 = (EPosition)var4.elementAt(var10)).index == -1) {
                        if (var8 == var19) {
                           var11.index = 0;
                           var10000 = var10;
                           break;
                        }

                        ++var19;
                     }

                     ++var10;
                  }
               } else {
                  var10000 = -1;
               }
            }

            var16 = var10000;
            var8 = this.list[var16].size() - 1;
            var10 = Res.gameAA((var9 = (EPosition)var1.elementAt(var16)).x - var6, -(var9.y - var7));
            var20 = Res.gameAD(15) + 10;
            var12 = 0;

            while(true) {
               var13 = 0;
               if (var12 != 0) {
                  var13 = var10 - 5 + Res.gameAD(10);
               }

               var13 = Res.gameAC(var13);
               var14 = var20 * var12 * Res.gameAB(var13) >> 10;
               var15 = -(var20 * var12 * Res.gameAA(var13)) >> 10;
               EPosition var22 = new EPosition(var6 + var14, var7 + var15, var8++);
               this.list[var16].addElement(var22);
               if (Res.gameAA(var6, var7, var6 + var14, var7 + var15) >= Res.gameAA(var6, var7, var9.x, var9.y) - 20) {
                  ++var5;
                  break;
               }

               ++var12;
            }
         }

         for(var5 = 0; var5 < this.list.length; ++var5) {
            var6 = this.list[var5].size();
            EPosition var17;
            (var17 = (EPosition)var1.elementAt(var5)).follow = (byte)(this.list[var5].size() - 1);
            var17.index = -1;
            (var18 = new EPosition(var17.x, var17.y, var17.follow)).index = -1;
            this.list[var5].addElement(var18);

            for(var19 = 1; var19 < var6; ++var19) {
               EPosition var21 = (EPosition)this.list[var5].elementAt(var19);
               var20 = Res.gameAD(2);

               for(var12 = 0; var12 < var20; ++var12) {
                  var13 = 180 + Res.gameAD(180);
                  var15 = (var14 = 5 + Res.gameAD(10)) * Res.gameAB(Res.gameAC(var13)) >> 10;
                  var13 = -(var14 * Res.gameAA(Res.gameAC(var13))) >> 10;
                  (var2 = new EPosition(var21.x + var15, var21.y + var13, var19)).index = 0;
                  this.list[var5].addElement(var2);
               }
            }
         }

      }
   }

   public final void gameAA() {
      if (this.posangle == null) {
         Effect2.vRemoveEffect2.addElement(this);
      } else {
         try {
            if (GameCanvas.gameTick % 2 == 1) {
               this.posangle.follow = -1;
               this.posangle.index = -1;

               for(int var1 = 0; var1 < this.listPos.size(); ++var1) {
                  EPosition var2;
                  (var2 = (EPosition)this.listPos.elementAt(var1)).index = -1;
                  var2.follow = -1;
               }

               if (this.isContinue && this.isRemove && this.listPos.size() > 1 && System.currentTimeMillis() / 10L - this.timeDel > 30L) {
                  this.timeDel = System.currentTimeMillis() / 10L;
                  this.posangle = (EPosition)this.listPos.elementAt(0);
                  this.listPos.removeElementAt(0);
               }

               this.gameAA(this.listPos, this.posangle, this.isContinue);
               if (this.tick > 3) {
                  this.aa = 7;
                  Effect2.vEffect2.removeElement(this);
               }

               ++this.tick;
            }

         } catch (Exception var3) {
         }
      }
   }

   public final void gameAA(mGraphics var1) {
      this.dem = 0;
      ++this.cou;
      if (this.cou >= 12) {
         this.cou = 0;
      }

      if (this.list != null) {
         for(int var2 = 0; var2 < this.list.length; ++var2) {
            for(int var3 = 0; var3 < this.list[var2].size(); ++var3) {
               EPosition var4;
               if ((var4 = (EPosition)this.list[var2].elementAt(var3)).follow >= 0 && var4.follow < this.list[var2].size()) {
                  EPosition var5 = (EPosition)this.list[var2].elementAt(var4.follow);
                  if (GameCanvas.gameAE(var4.x, var4.y) && GameCanvas.gameAE(var5.x, var5.y)) {
                     var1.gameAA(this.color[0]);
                     var1.gameAB(var4.x, var4.y, var5.x, var5.y);
                     if (var4.index == -1) {
                        var1.gameAA(this.color[1]);
                        var1.gameAB(var4.x - 1, var4.y, var5.x - 1, var5.y);
                        if (this.isContinue && this.isRemove) {
                           var1.gameAB(var4.x + 1, var4.y, var5.x + 1, var5.y);
                        }
                     }
                  }

                  if (this.isContinue && this.isRemove) {
                     ++this.dem;
                     if (this.dem >= this.aa) {
                        this.aa += 7;
                        return;
                     }
                  }
               }
            }

            EPosition var8;
            (var8 = (EPosition)this.listPos.elementAt(var2)).count = (byte)(var8.count + 1);
            if (var8.count >= 12) {
               var8.count = 0;
            }
         }

      }
   }
}
