import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public final class DataSkillEff {
   public MyVector gameAA = new MyVector();
   public SmallImage[] smallImage;
   public byte[][] frameChar;
   public byte[] sequence;
   private byte Frame;
   private byte f;
   private boolean IsStop;
   public short gameAE;
   private byte gameAO;
   public byte[] gameAF;
   public long gameAG;
   private long gameAP;
   public int gameAH;
   public boolean wantDetroy;
   private boolean gameAQ;
   public int gameAJ;
   public int gameAK;

   public DataSkillEff() {
      new MyVector();
      this.frameChar = new byte[4][];
      new MyVector();
      this.gameAE = 0;
      this.gameAO = 0;
      this.gameAF = new byte[4];
      new MyVector();
   }

   private void gameAB() {
      try {
         EffectData var1;
         if ((var1 = (EffectData)GameData.listbyteData.get("" + this.gameAE)) == null) {
            DataInputStream var4;
            if ((var4 = Res.gameAA("/effdata/" + this.gameAE)) != null) {
               byte[] var2 = new byte[(short)var4.available()];
               var4.read(var2, 0, var2.length);
               this.gameAA(var2);
            } else {
               GameData.gameAA(this.gameAE);
            }
         } else if (var1 != null && var1.isLoad) {
            this.gameAA = var1.gameAA;
            this.smallImage = var1.smallImage;
            this.gameAJ = var1.fw;
            this.gameAK = var1.fh;
            this.sequence = var1.sequence;
            this.gameAF = var1.indexStartSkill;
            this.frameChar = var1.frameChar;
            this.IsStop = var1.isLoad;
         }
      } catch (Exception var3) {
         var3.printStackTrace();
         GameData.gameAA(this.gameAE);
      }
   }

   public final void gameAA(byte[] var1) {
      if (var1 != null) {
         DataInputStream var2 = null;

         try {
            this.gameAA.removeAllElements();
            this.smallImage = null;
            byte var20 = (var2 = new DataInputStream(new ByteArrayInputStream(var1))).readByte();
            this.smallImage = new SmallImage[var20];

            int var3;
            for(var3 = 0; var3 < var20; ++var3) {
               SmallImage[] var4 = this.smallImage;
               var2.readUnsignedByte();
               SmallImage var5 = new SmallImage(var2.readUnsignedByte(), var2.readUnsignedByte(), var2.readUnsignedByte(), var2.readUnsignedByte());
               var4[var3] = var5;
            }

            var3 = 0;
            short var22 = var2.readShort();

            for(int var23 = 0; var23 < var22; ++var23) {
               var20 = var2.readByte();
               MyVector var6 = new MyVector();
               MyVector var7 = new MyVector();

               for(int var8 = 0; var8 < var20; ++var8) {
                  PartFrame var9;
                  (var9 = new PartFrame(var2.readShort(), var2.readShort(), var2.readByte())).flip = var2.readByte();
                  var9.onTop = var2.readByte();
                  if (var9.onTop == 0) {
                     var6.addElement(var9);
                  } else {
                     var7.addElement(var9);
                  }

                  if (var3 < Res.abs(var9.dy)) {
                     var3 = Res.abs(var9.dy);
                  }
               }

               this.gameAA.addElement(new FrameEff(var6, var7));
            }

            this.gameAJ = this.smallImage[0].gameAD;
            this.gameAK = (short)var3;
            short var24 = (short)var2.readUnsignedByte();
            this.sequence = new byte[var24];

            int var21;
            for(var21 = 0; var21 < var24; ++var21) {
               this.sequence[var21] = (byte)var2.readShort();
            }

            var2.readByte();
            byte var25 = var2.readByte();
            this.frameChar[0] = new byte[var25];

            for(var21 = 0; var21 < var25; ++var21) {
               this.frameChar[0][var21] = var2.readByte();
            }

            var25 = var2.readByte();
            this.frameChar[1] = new byte[var25];

            for(var21 = 0; var21 < var25; ++var21) {
               this.frameChar[1][var21] = var2.readByte();
            }

            var25 = var2.readByte();
            this.frameChar[3] = new byte[var25];

            for(var21 = 0; var21 < var25; ++var21) {
               this.frameChar[3][var21] = var2.readByte();
            }

            this.IsStop = true;

            try {
               this.gameAF[0] = (byte)(this.frameChar[0].length - 7);
               this.gameAF[1] = (byte)(this.frameChar[1].length - 7);
               this.gameAF[2] = (byte)(this.frameChar[3].length - 7);
               this.gameAF[3] = (byte)(this.frameChar[3].length - 7);
            } catch (Exception var17) {
            }

            this.gameAF[0] = var2.readByte();
            this.gameAF[1] = var2.readByte();
            this.gameAF[2] = var2.readByte();
            this.gameAF[3] = this.gameAF[2];
            return;
         } catch (Exception var18) {
         } finally {
            try {
               var2.close();
            } catch (Exception var16) {
            }

         }

      }
   }

   public DataSkillEff(short var1, long var2, int var4) {
      new MyVector();
      this.frameChar = new byte[4][];
      new MyVector();
      this.gameAE = 0;
      this.gameAO = 0;
      this.gameAF = new byte[4];
      new MyVector();
      this.gameAE = var1;
      this.gameAG = var2;
      this.gameAH = var4;
      this.gameAB();
      if (var2 == -1L) {
         this.gameAO = 3;
      } else if (var2 == 0L) {
         this.gameAO = 1;
      } else {
         this.gameAO = 2;
      }
   }

   private boolean gameAC() {
      if (this.IsStop) {
         return true;
      } else {
         this.gameAB();
         return false;
      }
   }

   public final void gameAA(mGraphics var1, int var2, int var3) {
      try {
         if (this.gameAC()) {
            if (!this.gameAQ) {
               if (this.Frame < this.gameAA.size()) {
                  MyVector var4 = ((FrameEff)this.gameAA.elementAt(this.Frame)).listPartTop;

                  for(int var5 = 0; var5 < var4.size(); ++var5) {
                     PartFrame var6 = (PartFrame)var4.elementAt(var5);
                     SmallImage var7 = this.smallImage[var6.idSmallImg];
                     ImageIcon var8;
                     if ((var8 = GameData.gameAB(this.gameAE)) != null && var8.img != null) {
                        short var9 = var6.dx;
                        int var10 = var7.gameAD;
                        int var11 = var7.gameAE;
                        short var12 = var7.gameAB;
                        short var14 = var7.gameAC;
                        if (var12 > var8.img.getWidth()) {
                           var12 = 0;
                        }

                        if (var14 > var8.img.getHeight()) {
                           var14 = 0;
                        }

                        if (var12 + var10 > var8.img.getWidth()) {
                           var10 = var8.img.getWidth() - var12;
                        }

                        if (var14 + var11 > var8.img.getHeight()) {
                           var11 = var8.img.getHeight() - var14;
                        }

                        var1.gameAA(var8.img, var12, var14, var10, var11, var6.flip == 1 ? 2 : 0, var2 + var9, var3 + var6.dy, 0);
                     }
                  }

               }
            }
         }
      } catch (Exception var13) {
         var13.printStackTrace();
         System.err.println("Err DataSkillEff  paintBottomEff:" + this.gameAE);
      }
   }

   public final void gameAB(mGraphics var1, int var2, int var3) {
      try {
         if (this.gameAC()) {
            if (!this.gameAQ) {
               if (this.Frame < this.gameAA.size()) {
                  MyVector var4 = ((FrameEff)this.gameAA.elementAt(this.Frame)).listPartBottom;

                  for(int var5 = 0; var5 < var4.size(); ++var5) {
                     PartFrame var6 = (PartFrame)var4.elementAt(var5);
                     SmallImage var7 = this.smallImage[var6.idSmallImg];
                     ImageIcon var8;
                     if ((var8 = GameData.gameAB(this.gameAE)) != null && var8.img != null) {
                        short var9 = var6.dx;
                        int var10 = var7.gameAD;
                        int var11 = var7.gameAE;
                        short var12 = var7.gameAB;
                        short var14 = var7.gameAC;
                        if (var12 > var8.img.getWidth()) {
                           var12 = 0;
                        }

                        if (var14 > var8.img.getHeight()) {
                           var14 = 0;
                        }

                        if (var12 + var10 > var8.img.getWidth()) {
                           var10 = var8.img.getWidth() - var12;
                        }

                        if (var14 + var11 > var8.img.getHeight()) {
                           var11 = var8.img.getHeight() - var14;
                        }

                        var1.gameAA(var8.img, var12, var14, var10, var11, var6.flip == 1 ? 2 : 0, var2 + var9, var3 + var6.dy, 0);
                     }
                  }

               }
            }
         }
      } catch (Exception var13) {
         var13.printStackTrace();
         System.err.println("Err DataSkillEff  paintBottomEff:" + this.gameAE);
      }
   }

   private void gameAA(boolean var1) {
      if (this.gameAH > 0) {
         this.gameAQ = var1;
         if (this.gameAQ) {
            this.gameAP = System.currentTimeMillis() + (long)this.gameAH;
            return;
         }
      } else {
         this.gameAQ = false;
      }

   }

   public final void gameAA() {
      if (this.gameAA.size() > 0) {
         try {
            if (!this.gameAQ) {
               switch(this.gameAO) {
               case 0:
                  ++this.f;
                  if (this.f > this.sequence.length) {
                     this.wantDetroy = true;
                     this.f = 0;
                  }

                  this.Frame = this.sequence[this.f];
                  return;
               case 1:
                  ++this.f;
                  if (this.f > this.sequence.length) {
                     this.f = 0;
                     this.wantDetroy = true;
                  }

                  this.Frame = this.sequence[this.f];
                  return;
               case 2:
                  ++this.f;
                  if (this.f == (byte)(this.sequence.length - 1) && this.gameAG - System.currentTimeMillis() < 0L) {
                     this.wantDetroy = true;
                  }

                  if (this.f > this.sequence.length) {
                     this.f = 0;
                     this.gameAA(true);
                  }

                  this.Frame = this.sequence[this.f];
                  return;
               case 3:
                  ++this.f;
                  if (this.f > this.sequence.length) {
                     this.f = 0;
                     this.gameAA(true);
                  }

                  this.Frame = this.sequence[this.f];
                  return;
               default:
                  return;
               }
            }

            if (this.gameAP - System.currentTimeMillis() < 0L) {
               this.gameAA(false);
               return;
            }

            return;
         } catch (Exception var1) {
         }
      }

   }
}
