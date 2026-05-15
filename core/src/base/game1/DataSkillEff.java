package base.game1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class DataSkillEff {
   private static final boolean DEBUG_FASHION = false;
   public long a;
   public MyVector b = new MyVector();
   private SmallImage[] t;
   private byte[][] u;
   public byte[] c;
   private byte v;
   private byte w;
   public boolean d;
   public short e;
   private byte x;
   private byte[] y;
   private boolean z;
   public boolean f;
   public byte[] g;
   public byte[] h;
   public byte[] i;
   public byte[] j;
   public byte[] k;
   public byte[] l;
   public byte[] m;
   public byte n;
   public byte o;
   public byte p;
   private MyVector aa;
   private MyVector ab;
   private MyVector ac;
   private MyVector ad;
   private MyVector ae;
   private MyVector af;
   private MyVector ag;
   public long q;
   private long ah;
   public int r;
   public boolean s;
   private boolean ai;
   private long debugAt;

   private static void debug(String var0) {
      if (DEBUG_FASHION) {
         ;
      }
   }

   public DataSkillEff() {
      new MyVector();
      this.u = new byte[4][];
      new MyVector();
      this.e = 0;
      this.x = 0;
      this.y = new byte[4];
      this.f = false;
      this.aa = new MyVector();
      this.ab = new MyVector();
      this.ac = new MyVector();
      this.ad = new MyVector();
      this.ae = new MyVector();
      this.af = new MyVector();
      this.ag = new MyVector();
      new MyVector();
   }

   public DataSkillEff(short var1, boolean var2) {
      new MyVector();
      this.u = new byte[4][];
      new MyVector();
      this.e = 0;
      this.x = 0;
      this.y = new byte[4];
      this.f = false;
      this.aa = new MyVector();
      this.ab = new MyVector();
      this.ac = new MyVector();
      this.ad = new MyVector();
      this.ae = new MyVector();
      this.af = new MyVector();
      this.ag = new MyVector();
      new MyVector();
      this.e = var1;
      this.z = var2;
      debug("ctor effectId=" + this.e + " isHorseProfile=" + this.z);
      this.a((byte[])null);
   }

   public void recheck() {
      if (!this.d) {
         EffectData var1 = (EffectData)GameData.c.a("" + this.e);
         int var2 = var1 != null && var1.a != null ? var1.a.length : -1;
         debug("recheck effectId=" + this.e + " ready=false cachedDataLen=" + var2);
         this.a((byte[])null);
      }
   }

   private void a(byte[] var1) {
      try {
         EffectData var2;
         if ((var2 = (EffectData)GameData.c.a("" + this.e)) != null && var2.a != null) {
            var1 = var2.a;
            debug("loadFromCache effectId=" + this.e + " dataLen=" + var1.length);
         }

         if (var2 == null) {
            var2 = new EffectData();
            GameData.c.a("" + this.e, var2);
            debug("requestEffectData effectId=" + this.e + " (create cache entry)");
            Service.gI().ar(this.e);
            System.currentTimeMillis();
         }

         if (var1 != null && var1.length > 0) {
            debug("parseEffectData effectId=" + this.e + " dataLen=" + var1.length);
            this.b(var1);
            return;
         }

         debug("effectDataMissing effectId=" + this.e + " cacheEntry=" + (var2 != null));
      } catch (Exception var3) {
         debug("loadException effectId=" + this.e + " err=" + var3.getMessage());
         ;
      }

   }

   private void b(byte[] var1) {
      if (var1 != null) {
         DataInputStream var2 = null;

         try {
            this.b.removeAllElements();
            this.t = null;
            short var18 = (short)(var2 = new DataInputStream(new ByteArrayInputStream(var1))).readByte();
            this.t = new SmallImage[var18];

            int var3;
            for(var3 = 0; var3 < var18; ++var3) {
               this.t[var3] = new SmallImage(var2.readUnsignedByte(), var2.readUnsignedByte(), var2.readUnsignedByte(), var2.readUnsignedByte(), var2.readUnsignedByte());
            }

            var18 = var2.readShort();

            int var4;
            for(var3 = 0; var3 < var18; ++var3) {
               var4 = var2.readByte();
               MyVector var5 = new MyVector();
               MyVector var6 = new MyVector();

               for(int var7 = 0; var7 < var4; ++var7) {
                  PartFrame var8;
                  (var8 = new PartFrame(var2.readShort(), var2.readShort(), var2.readByte())).d = var2.readByte();
                  var8.e = var2.readByte();
                  if (var8.e == 0) {
                     var5.addElement(var8);
                  } else {
                     var6.addElement(var8);
                  }
               }

               this.b.addElement(new FrameEff(var5, var6));
            }

            short var19 = (short)var2.readUnsignedByte();
            this.c = new byte[var19];
            var4 = 0;

            int var21;
            for(var21 = 0; var21 < var19; ++var21) {
               this.c[var21] = (byte)var2.readShort();
               if (this.z) {
                  if (var4 == 2 && this.c[var21] != -1) {
                     this.aa.addElement(String.valueOf(this.c[var21]));
                  }

                  if (var4 == 3 && this.c[var21] != -1) {
                     this.ab.addElement(String.valueOf(this.c[var21]));
                  }

                  if (var4 == 4 && this.c[var21] != -1) {
                     this.ac.addElement(String.valueOf(this.c[var21]));
                  }

                  if (var4 == 5 && this.c[var21] != -1) {
                     this.ad.addElement(String.valueOf(this.c[var21]));
                  }

                  if (var4 == 6 && this.c[var21] != -1) {
                     this.ae.addElement(String.valueOf(this.c[var21]));
                  }

                  if (var4 == 7 && this.c[var21] != -1) {
                     this.af.addElement(String.valueOf(this.c[var21]));
                  }

                  if (var4 == 8 && this.c[var21] != -1) {
                     this.ag.addElement(String.valueOf(this.c[var21]));
                  }

                  if (this.c[var21] == -1) {
                     ++var4;
                  }
               }
            }

            if (this.z) {
               this.n = this.c[0];
               this.o = this.c[2];
               this.p = this.c[3];
               this.k = a(this.aa);
               this.g = a(this.ab);
               this.h = a(this.ac);
               this.i = a(this.ad);
               this.j = a(this.ae);
               this.l = a(this.af);
               if (this.l == null || this.l.length == 0) {
                  this.l = new byte[this.n];
               }

               this.m = a(this.ag);
               if (this.m == null || this.m.length == 0) {
                  this.m = new byte[this.n];
               }

               this.aa.removeAllElements();
               this.ab.removeAllElements();
               this.ac.removeAllElements();
               this.ad.removeAllElements();
               this.ae.removeAllElements();
               this.af.removeAllElements();
               this.ag.removeAllElements();
            }

            var2.readByte();
            byte var20 = var2.readByte();
            this.u[0] = new byte[var20];

            for(var21 = 0; var21 < var20; ++var21) {
               this.u[0][var21] = var2.readByte();
            }

            var20 = var2.readByte();
            this.u[1] = new byte[var20];

            for(var21 = 0; var21 < var20; ++var21) {
               this.u[1][var21] = var2.readByte();
            }

            var20 = var2.readByte();
            this.u[3] = new byte[var20];

            for(var21 = 0; var21 < var20; ++var21) {
               this.u[3][var21] = var2.readByte();
            }

            this.d = true;

            try {
               this.y[0] = (byte)(this.u[0].length - 7);
               this.y[1] = (byte)(this.u[1].length - 7);
               this.y[2] = (byte)(this.u[3].length - 7);
               this.y[3] = (byte)(this.u[3].length - 7);
            } catch (Exception var191) {
            }

            this.y[0] = var2.readByte();
            this.y[1] = var2.readByte();
            this.y[2] = var2.readByte();
            this.y[3] = this.y[2];
            debug("parseDone effectId=" + this.e + " ready=" + this.d + " frameCount=" + this.b.size() + " dirFrames=" + (this.c != null ? this.c.length : 0));
         } catch (Exception var20) {
            debug("parseException effectId=" + this.e + " err=" + var20.getMessage());
            ;
         } finally {
            try {
               var2.close();
            } catch (Exception var18) {
            }

         }
      }

   }

   public DataSkillEff(short var1, long var2, int var4, boolean var5) {
      new MyVector();
      this.u = new byte[4][];
      new MyVector();
      this.e = 0;
      this.x = 0;
      this.y = new byte[4];
      this.f = false;
      this.aa = new MyVector();
      this.ab = new MyVector();
      this.ac = new MyVector();
      this.ad = new MyVector();
      this.ae = new MyVector();
      this.af = new MyVector();
      this.ag = new MyVector();
      new MyVector();
      this.e = var1;
      this.q = var2;
      this.r = var4;
      this.f = var5;
      this.a((byte[])null);
      if (var2 == -1L) {
         this.x = 3;
      } else if (var2 == 0L) {
         this.x = 1;
      } else {
         this.q += System.currentTimeMillis();
         this.x = 2;
      }

   }

   public final void a(long var1) {
      if (var1 == -1L) {
         this.x = 3;
      } else if (var1 == 0L) {
         this.x = 1;
      } else {
         this.x = 2;
      }

   }

   private static byte[] a(MyVector var0) {
      Object var1 = null;
      byte[] var3 = new byte[var0.size()];

      for(int var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = Byte.parseByte((String)var0.elementAt(var2));
      }

      return var3;
   }

   private boolean b() {
      if (this.d) {
         return true;
      } else {
         long var1 = System.currentTimeMillis();
         if (var1 - this.debugAt > 1500L) {
            this.debugAt = var1;
            EffectData var3 = (EffectData)GameData.c.a("" + this.e);
            debug("paintWhenNotReady effectId=" + this.e + " cachedData=" + (var3 != null) + " cachedDataLen=" + (var3 != null && var3.a != null ? var3.a.length : -1));
         }

         this.a((byte[])null);
         return false;
      }
   }

   public final void a(mGraphics var1, int var2, int var3, int var4, int var5) {
      if (this.b() && var4 < this.b.size()) {
         FrameEff var17 = (FrameEff)this.b.elementAt(var4);

         try {
            MyVector var18 = var17.b;

            for(int var6 = 0; var6 < var18.size(); ++var6) {
               PartFrame var7 = (PartFrame)var18.elementAt(var6);
               SmallImage var8 = this.t[var7.a];
               ImageIcon var9;
               if ((var9 = GameData.a(this.e)) != null && var9.a != null) {
                  int var10 = var7.b;
                  int var11 = var8.e;
                  int var12 = var8.f;
                  short var13 = var8.c;
                  short var19 = var8.d;
                  int var14 = var9.a.getWidth();
                  int var15 = var9.a.getHeight();
                  if (var13 > var14) {
                     var13 = 0;
                  }

                  if (var19 > var15) {
                     var19 = 0;
                  }

                  if (var13 + var11 > var14) {
                     var11 = var14 - var13;
                  }

                  if (var19 + var12 > var15) {
                     var12 = var15 - var19;
                  }

                  var14 = var7.d == 1 ? 2 : 0;
                  if (var5 == 2 || var5 == 6) {
                     if (var14 == 2) {
                        var14 = 0;
                     } else {
                        var14 = 2;
                     }

                     var10 = -(var10 + var11);
                  }

                  var1.a(var9.a, var13, var19, var11, var12, var14, var2 + var10, var3 + var7.c, 0);
               }
            }

            return;
         } catch (Exception var19) {
            ;
         }
      }

   }

   public final void b(mGraphics var1, int var2, int var3, int var4, int var5) {
      if (this.b() && var4 < this.b.size()) {
         FrameEff var17 = (FrameEff)this.b.elementAt(var4);

         try {
            MyVector var18 = var17.a;

            for(int var6 = 0; var6 < var18.size(); ++var6) {
               PartFrame var7 = (PartFrame)var18.elementAt(var6);
               SmallImage var8 = this.t[var7.a];
               ImageIcon var9;
               if ((var9 = GameData.a(this.e)) != null && var9.a != null) {
                  int var10 = var7.b;
                  int var11 = var8.e;
                  int var12 = var8.f;
                  short var13 = var8.c;
                  short var19 = var8.d;
                  int var14 = var9.a.getWidth();
                  int var15 = var9.a.getHeight();
                  if (var13 > var14) {
                     var13 = 0;
                  }

                  if (var19 > var15) {
                     var19 = 0;
                  }

                  if (var13 + var11 > var14) {
                     var11 = var14 - var13;
                  }

                  if (var19 + var12 > var15) {
                     var12 = var15 - var19;
                  }

                  var14 = var7.d == 1 ? 2 : 0;
                  if (var5 == 2 || var5 == 6) {
                     if (var14 == 2) {
                        var14 = 0;
                     } else {
                        var14 = 2;
                     }

                     var10 = -(var10 + var11);
                  }

                  var1.a(var9.a, var13, var19, var11, var12, var14, var2 + var10, var3 + var7.c, 0);
               }
            }

            return;
         } catch (Exception var19) {
            ;
         }
      }

   }

   public final void a(mGraphics var1, int var2, int var3) {
      try {
         if (!this.b()) {
            return;
         }

         if (this.ai) {
            return;
         }

         if (this.v < this.b.size()) {
            MyVector var4 = ((FrameEff)this.b.elementAt(this.v)).a;

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               PartFrame var6 = (PartFrame)var4.elementAt(var5);
               SmallImage var7 = this.t[var6.a];
               ImageIcon var8;
               if ((var8 = GameData.a(this.e)) != null && var8.a != null) {
                  short var9 = var6.b;
                  int var10 = var7.e;
                  int var11 = var7.f;
                  short var12 = var7.c;
                  short var14 = var7.d;
                  if (var12 > var8.a.getWidth()) {
                     var12 = 0;
                  }

                  if (var14 > var8.a.getHeight()) {
                     var14 = 0;
                  }

                  if (var12 + var10 > var8.a.getWidth()) {
                     var10 = var8.a.getWidth() - var12;
                  }

                  if (var14 + var11 > var8.a.getHeight()) {
                     var11 = var8.a.getHeight() - var14;
                  }

                  var1.a(var8.a, var12, var14, var10, var11, var6.d == 1 ? 2 : 0, var2 + var9, var3 + var6.c, 0);
               }
            }

            return;
         }
      } catch (Exception var14) {
         ;
         ;
      }

   }

   public final void b(mGraphics var1, int var2, int var3) {
      try {
         if (!this.b()) {
            return;
         }

         if (this.ai) {
            return;
         }

         if (this.v < this.b.size()) {
            MyVector var4 = ((FrameEff)this.b.elementAt(this.v)).b;

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               PartFrame var6 = (PartFrame)var4.elementAt(var5);
               SmallImage var7 = this.t[var6.a];
               ImageIcon var8;
               if ((var8 = GameData.a(this.e)) != null && var8.a != null) {
                  short var9 = var6.b;
                  int var10 = var7.e;
                  int var11 = var7.f;
                  short var12 = var7.c;
                  short var14 = var7.d;
                  if (var12 > var8.a.getWidth()) {
                     var12 = 0;
                  }

                  if (var14 > var8.a.getHeight()) {
                     var14 = 0;
                  }

                  if (var12 + var10 > var8.a.getWidth()) {
                     var10 = var8.a.getWidth() - var12;
                  }

                  if (var14 + var11 > var8.a.getHeight()) {
                     var11 = var8.a.getHeight() - var14;
                  }

                  var1.a(var8.a, var12, var14, var10, var11, var6.d == 1 ? 2 : 0, var2 + var9, var3 + var6.c, 0);
               }
            }

            return;
         }
      } catch (Exception var14) {
         ;
         ;
      }

   }

   private void a(boolean var1) {
      if (this.r > 0) {
         this.ai = var1;
         if (this.ai) {
            this.ah = System.currentTimeMillis() + (long)this.r;
            return;
         }
      } else {
         this.ai = false;
      }

   }

   public final void a() {
      if (this.b.size() > 0) {
         try {
            if (!this.ai) {
               switch (this.x) {
                  case 0:
                     ++this.w;
                     if (this.w > this.c.length) {
                        this.s = true;
                        this.w = 0;
                     }

                     this.v = this.c[this.w];
                     return;
                  case 1:
                     ++this.w;
                     if (this.w > this.c.length) {
                        this.w = 0;
                        this.s = true;
                     }

                     this.v = this.c[this.w];
                     return;
                  case 2:
                     ++this.w;
                     if (this.q - System.currentTimeMillis() < 0L) {
                        this.s = true;
                     }

                     if (this.w > this.c.length) {
                        this.w = 0;
                     }

                     this.v = this.c[this.w];
                     return;
                  case 3:
                     ++this.w;
                     if (this.w > this.c.length) {
                        this.w = 0;
                        this.a(true);
                     }

                     this.v = this.c[this.w];
                     return;
                  default:
                     return;
               }
            }

            if (this.ah - System.currentTimeMillis() < 0L) {
               this.a(false);
               return;
            }
         } catch (Exception var2) {
         }
      }

   }

   static {
      new mHashtable();
   }
}
