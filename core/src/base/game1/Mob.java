package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Image;

public final class Mob extends MainObject {
   public static MobTemplate[] b;
   public int hp;
   public int maxHp;
   public int x1;
   public int y1;
   private int frame;
   public int dir = 1;
   private int dirV = 1;
   public int status;
   private int ag;
   private int ah;
   private int ai;
   public int i;
   public int j;
   public int k;
   public int l;
   private int aj;
   public short m;
   public boolean n;
   public boolean o;
   public boolean p;
   public boolean q;
   public boolean r;
   private MyVector ak = new MyVector();
   public int s;
   private Char al;
   private BuNhin am;
   public int dame;
   public int dameMp;
   public int sys;
   private int typeAtt;
   public short levelBoss;
   public short level;
   public boolean isBoss;
   private long timeStartDie = 0L;
   private int frameIndex = 0;
   public static Char CharAtt;
   public static MyVector vEggMonter = new MyVector();
   private static EggMonters egg;
   private static long as;
   private boolean at;
   public boolean aa = true;
   private long au;
   public Char ab;
   private boolean av;
   private boolean aw;
   public Char ac;
   public boolean ad;
   private Mob ax;
   private Char ay;
   private short az;
   private byte ba;
   private byte bb;
   private byte bc;
   private static byte[][] bd = new byte[][]{{3, 4, 5, 6}, new byte[1], {2, 2, 2, 2, 3, 3, 3, 3}, {0, 1}, {0, 1}, {3, 4, 5}, new byte[1], {3, 3, 4, 4, 5, 5}, new byte[1], {3, 4, 5}, {0, 1, 2, 3, 4}, {3, 4, 5}, {4, 5, 6}, new byte[1], {0, 1}, {0, 1}, {3, 3, 4, 4, 5, 5}, {0, 1, 2}, {0, 1, 2}, {5, 6, 7, 8}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {3, 4, 5, 6}, {0, 1, 2}, {0, 1, 2, 3}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, new byte[1], new byte[1], new byte[1], new byte[1], {0, 1, 2}, new byte[1], new byte[1], {0, 0, 1, 1, 2, 2}, {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 1}, {0, 1}, new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1]};
   private static byte[][] be = new byte[][]{{0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, new byte[1]};
   private static byte[][] bf = new byte[][]{{5, 4, 3, 2, 1}, new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], {5, 4, 3, 2, 1}, {5, 4, 3, 2, 1}, {5, 4, 3, 2, 1}, new byte[0], {5, 4, 3, 2, 1}, new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, new byte[1]};
   private int bg;

   public Mob(short var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, int var7, int var8, int var9, int var10, int var11, short var12, short var13, byte var14, byte var15, boolean var16, boolean var17) {
      byte[] var10000 = new byte[]{-1, 1};
      this.ad = false;
      this.bc = -1;
      this.bg = 0;
      this.n = var2;
      this.o = var3;
      this.p = var4;
      this.q = var5;
      this.r = var6;
      this.sys = var8;
      this.m = var1;
      this.s = var7;
      this.hp = var9;
      this.level = (short)var10;
      this.i = this.x1 = var12;
      this.j = this.y1 = var13;
      if (var7 != 168 && var7 != 179 && var7 != 175 && var7 != 177 && var7 != 202) {
         this.status = var14;
      } else {
         this.status = 8;
      }

      this.maxHp = var11;
      this.levelBoss = (short)var15;
      this.isBoss = var16;
      if (var7 == 202) {
         egg = new EggMonters(this.i, this.j - 100);
         vEggMonter.addElement(egg);
         EggMonters.f = this;
      }

      if (b[var7].h == null) {
         b[var7].h = new Image[0];
         Service.gI().a(var7);
      }

      as = (long)Res.d(2000, 3500);
      this.at = var17;
   }

   public final void a() {
      boolean var10000;
      if (b[this.s] == null) {
         var10000 = false;
      } else if (b[this.s].h == null) {
         var10000 = false;
      } else {
         label990: {
            if (!this.isBoss) {
               if (this.frame >= b[this.s].h.length) {
                  var10000 = false;
                  break label990;
               }

               if (b[this.s].h[this.frame] == null) {
                  var10000 = false;
                  break label990;
               }
            }

            var10000 = this.status != 0;
         }
      }

      if (var10000) {
         if (this.al == null && (this.s == 168 || this.s == 179 || this.s == 175)) {
            this.status = 8;
         }

         if (this.ak != null || b[this.s].a == 0) {
            if (this.status != 3 && this.aa) {
               if (this.al != null) {
                  this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                  this.al = null;
               }

               this.aa = false;
            }

            if (this.hp <= 0 && this.m != -1) {
               this.status = 1;
            }

            int var10001;
            Mob var5;
            int var2;
            label920:
            switch (this.status) {
               case 1:
                  this.n = false;
                  this.o = false;
                  this.p = false;
                  this.q = false;
                  this.r = false;
                  if (this.s != 98 && this.s != 99) {
                     ++this.ag;
                     this.y1 += this.ag;
                     if (CharAtt != null) {
                        if (CharAtt.myskill != null) {
                           if (CharAtt.myskill.template.id > 72) {
                              if (GameCanvas.w % 9 == 0) {
                                 if (this.ah > 1) {
                                    this.ah += 5;
                                 } else if (this.ah < -1) {
                                    this.ah -= 5;
                                 }
                              }
                           } else if (GameCanvas.w % 2 == 0) {
                              if (this.ah > 1) {
                                 --this.ah;
                              } else if (this.ah < -1) {
                                 ++this.ah;
                              }
                           }
                        }
                     } else if (Char.getMyChar() != null && Char.getMyChar().myskill != null) {
                        if (Char.getMyChar().myskill.template.id > 72) {
                           if (GameCanvas.w % 9 == 0) {
                              if (this.ah > 1) {
                                 this.ah += 5;
                              } else if (this.ah < -1) {
                                 this.ah -= 5;
                              }
                           }
                        } else if (GameCanvas.w % 2 == 0) {
                           if (this.ah > 1) {
                              --this.ah;
                           } else if (this.ah < -1) {
                              ++this.ah;
                           }
                        }
                     }

                     this.x1 += this.ah;
                     if (this.s != 209 && this.s != 210) {
                        if (this.s != 168 && this.s != 176 && this.s != 177 && this.s != 179 && this.s != 180 && this.s != 191) {
                           if (this.s != 178 && this.s != 181 && this.s != 183 && this.s != 185 && this.s != 188 && this.s != 192 && this.s != 194) {
                              if (this.s != 173 && this.s != 184) {
                                 if (this.s == 175) {
                                    var5 = this;
                                    var10001 = 8;
                                 } else if (this.s != 170 && this.s != 195 && this.s != 196 && this.s != 197 && this.s != 186 && this.s != 189 && this.s != 190) {
                                    if (this.s == 187) {
                                       var5 = this;
                                       var10001 = 9;
                                    } else if (this.s == 193) {
                                       var5 = this;
                                       var10001 = 5;
                                    } else if (this.s == 174) {
                                       var5 = this;
                                       var10001 = 10;
                                    } else {
                                       var5 = this;
                                       var10001 = this.isBoss ? 10 : 2;
                                    }
                                 } else {
                                    var5 = this;
                                    var10001 = 3;
                                 }
                              } else {
                                 var5 = this;
                                 var10001 = 6;
                              }
                           } else {
                              var5 = this;
                              var10001 = 4;
                           }
                        } else {
                           var5 = this;
                           var10001 = 7;
                        }
                     } else {
                        var5 = this;
                        var10001 = 6;
                     }

                     var5.frame = var10001;
                     if (this.y1 > GameScr.gssye * 24 || this.x1 < GameScr.gssx * 24 || this.x1 > GameScr.gssxe * 24) {
                        this.ag = 0;
                        this.ah = 0;
                        this.x1 = this.y1 = 0;
                        this.hp = this.c().f;
                        this.status = 0;
                        if (this.s < 168) {
                           this.frame = 0;
                        } else {
                           this.frame = this.c(GameCanvas.w);
                        }

                        this.aj = 0;
                        return;
                     }

                     if (this.ai == 0 && (TileMap.tileTypeAtPixel(this.x1, this.y1) & 2) == 2) {
                        this.ag = this.ag > 4 ? -4 : -this.ag;
                        this.ai = 16;
                     }

                     if (this.ai > 0) {
                        --this.ai;
                     }
                  } else if (System.currentTimeMillis() - this.timeStartDie > 1200L) {
                     this.status = 0;
                  }
                  break;
               case 2:
                  this.aj = 0;
                  if (this.isBoss && this.s > 210) {
                     if (b[this.s].k != null) {
                        ++this.ag;
                        if (GameCanvas.w % 2 == 0) {
                           ++this.frameIndex;
                        }

                        if (this.frameIndex >= b[this.s].k.length) {
                           this.frameIndex = 0;
                        }

                        this.frame = b[this.s].k[this.frameIndex];
                        if (this.ag > 10 + this.m % 10 && System.currentTimeMillis() - (this.au + as) >= 0L) {
                           this.status = 5;
                           this.ag = 0;
                        }
                     }
                  } else {
                     switch (b[this.s].c) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                           if (this.s != 209 && this.s != 210) {
                              if (this.s != 173 && this.s != 175 && this.s != 176 && this.s != 177 && this.s != 179 && this.s != 180 && this.s != 181 && this.s != 183 && this.s != 184 && this.s != 185) {
                                 if (this.s != 168 && this.s != 179) {
                                    if (this.s == 174) {
                                       this.frame = 4;
                                    } else {
                                       var2 = this.s;
                                       boolean var6 = true;
                                       this.frame = 0;
                                    }
                                 } else {
                                    this.frame = 6;
                                 }
                              } else {
                                 this.frame = 1;
                              }
                           } else {
                              this.frame = 1;
                           }

                           ++this.ag;
                           if (this.ag > 10 + this.m % 10 && System.currentTimeMillis() - (this.au + as) >= 0L) {
                              this.status = 5;
                           }

                           if (this.isBoss) {
                              this.frame = GameCanvas.w % 101 > 1 ? 0 : 1;
                           }
                           break label920;
                        case 4:
                        case 5:
                           if (!this.isBoss) {
                              if (this.s < 168) {
                                 this.frame = GameCanvas.w % 4 > 1 ? 0 : 1;
                              } else {
                                 this.frame = this.b(GameCanvas.w);
                              }
                           } else {
                              this.frame = b[this.s].k[this.frameIndex];
                           }

                           ++this.ag;
                           if (this.ag > this.m % 3) {
                              this.status = 5;
                           }
                     }
                  }
                  break;
               case 3:
                  if (this.ax == null && this.ay == null) {
                     if (this.az < 0) {
                        int var3;
                        if (this.isBoss && this.s > 210) {
                           if (b[this.s].l != null) {
                              if (this.ag == 0) {
                                 var2 = 0;
                                 var3 = 0;
                                 if (this.typeAtt == 0) {
                                    var2 = this.al.cx1;
                                    var3 = this.al.cy1;
                                 } else if (this.typeAtt == 1) {
                                    var2 = this.am.a;
                                    var3 = this.am.b;
                                 }

                                 if (GameCanvas.w % 2 == 0) {
                                    ++this.frameIndex;
                                 }

                                 if (Res.e(var2 - this.x1) >= 48 && Res.e(var3 - this.y1) >= 10) {
                                    if (this.frameIndex >= b[this.s].l[1].length) {
                                       this.ag = 1;
                                       this.frameIndex = 0;
                                    }

                                    this.frame = b[this.s].l[1][this.frameIndex];
                                 } else {
                                    if (this.frameIndex >= b[this.s].l[0].length) {
                                       this.ag = 1;
                                       this.frameIndex = 0;
                                    }

                                    this.frame = b[this.s].l[0][this.frameIndex];
                                 }
                              } else if (this.ag == 1) {
                                 if (b[this.s].c != 0 && !this.o && !this.q && !this.r) {
                                    this.x1 += (this.i - this.x1) / 4;
                                    this.y1 += (this.j - this.y1) / 4;
                                 }

                                 if (Res.e(this.i - this.x1) < 5 && Res.e(this.j - this.y1) < 5) {
                                    this.status = 2;
                                    this.frameIndex = 0;
                                    this.ag = 0;
                                    this.ah = 0;
                                 }
                              }
                           }
                        } else {
                           if (this.s != 209 && this.s != 210) {
                              if (this.s != 176 && this.s != 177 && this.s != 179) {
                                 if (this.s == 175) {
                                    var5 = this;
                                    var10001 = 7;
                                 } else if (this.s != 180 && this.s != 181 && this.s != 183 && this.s != 184 && this.s != 173 && this.s != 188 && this.s != 192 && this.s != 194 && this.s != 202) {
                                    if (this.s == 193) {
                                       var5 = this;
                                       var10001 = 4;
                                    } else if (this.s != 187 && this.s != 168 && this.s != 175 && this.s != 176 && this.s != 179 && this.s != 174) {
                                       var5 = this;
                                       var10001 = GameCanvas.w % 4 > 1 ? (b[this.s].c == 5 ? 3 : 0) : 1;
                                    } else {
                                       var5 = this;
                                       var10001 = this.d(GameCanvas.w);
                                    }
                                 } else {
                                    var5 = this;
                                    var10001 = 3;
                                 }
                              } else {
                                 var5 = this;
                                 var10001 = 6;
                              }
                           } else {
                              var5 = this;
                              var10001 = 6;
                           }

                           var5.frame = var10001;
                           if (this.ag == 0) {
                              var2 = 0;
                              var3 = 0;
                              if (this.typeAtt == 0) {
                                 var2 = this.al.cx1;
                                 var3 = this.al.cy1;
                              } else if (this.typeAtt == 1) {
                                 var2 = this.am.a;
                                 var3 = this.am.b;
                              }

                              if (Res.e(var2 - this.x1) < 24 || Res.e(var2 - this.x1) < 5 || b[this.s].c == 0) {
                                 if (this.s != 168 && this.s != 176 && this.s != 177 && this.s != 179) {
                                    if (this.s == 175) {
                                       var5 = this;
                                       var10001 = 7;
                                    } else {
                                       label1048: {
                                          if (this.s != 180 && this.s != 181 && this.s != 183 && this.s != 184 && this.s != 173 && this.s != 202) {
                                             if (this.s == 187 || this.s == 168 || this.s == 179 || this.s == 174) {
                                                var5 = this;
                                                var10001 = this.d(GameCanvas.w);
                                                break label1048;
                                             }

                                             var5 = this;
                                             if (b[this.s].h.length == 3) {
                                                var10001 = 0;
                                                break label1048;
                                             }
                                          } else {
                                             var5 = this;
                                          }

                                          var10001 = 3;
                                       }
                                    }
                                 } else {
                                    var5 = this;
                                    var10001 = 6;
                                 }

                                 var5.frame = var10001;
                              }

                              if (this.isBoss && (Res.e(var2 - this.x1) < 48 || Res.e(var2 - this.x1) < 10 || b[this.s].c == 0)) {
                                 this.frame = b[this.s].h.length == 3 ? 0 : 3;
                              }

                              if (this.isBoss) {
                                 ++this.frameIndex;
                                 if (Res.e(var2 - this.x1) >= 48 && Res.e(var3 - this.y1) >= 10) {
                                    if (this.frameIndex >= b[this.s].l[1].length) {
                                       this.frameIndex = 0;
                                    }

                                    this.frame = b[this.s].l[1][this.frameIndex];
                                 } else {
                                    if (this.frameIndex >= b[this.s].l[0].length) {
                                       this.frameIndex = 0;
                                    }

                                    this.frame = b[this.s].l[0][this.frameIndex];
                                 }
                              }

                              if (this.frame == 3 || this.frame == 6 || this.frame == 7) {
                                 this.ag = 1;
                              }

                              if (b[this.s].c != 0 && !this.o && this.q && this.r) {
                                 this.x1 += (var2 - this.x1) / 3;
                              }

                              if (this.x1 > this.i + b[this.s].a) {
                                 this.ag = 1;
                              }

                              if (this.x1 < this.i - b[this.s].a) {
                                 this.ag = 1;
                              }

                              if ((b[this.s].c == 4 || b[this.s].c == 5) && !this.o) {
                                 this.y1 += (var3 - this.y1) / 20;
                              }

                              ++this.ah;
                              if (this.isBoss && Res.e(var2 - this.x1) < 48 && Res.e(var3 - this.y1) < 15 || Res.e(var2 - this.x1) < 12 && Res.e(var3 - this.y1) < 12 || this.ah > 12 || this.ag == 1 || b != null && b[this.s].l != null && this.frameIndex == b[this.s].l[0].length - 2 && (this.c().e == 166 || this.c().e == 167)) {
                                 label1062: {
                                    this.ag = 1;
                                    if (this.typeAtt == 0) {
                                       if (this.isBoss && Res.e(var2 - this.x1) < 48 && Res.e(var3 - this.y1) < 15) {
                                          this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                          this.aa = false;
                                          if (this.c().e == 210) {
                                             if (this.al.cx1 > this.x1) {
                                                ServerEffect.a(142, this.x1, this.y1, 1);
                                             } else {
                                                ServerEffect.a(142, this.x1, this.y1, 1, (byte)-1);
                                             }
                                             break label1062;
                                          }

                                          if (this.c().e == 209) {
                                             if (this.al.cx1 > this.x1) {
                                                ServerEffect.a(108, this.x1, this.y1, 1);
                                             } else {
                                                ServerEffect.a(108, this.x1, this.y1, 1, (byte)-1);
                                             }
                                             break label1062;
                                          }

                                          if (this.c().e == 114) {
                                             ServerEffect.a(79, this.al, 3);
                                             break label1062;
                                          }

                                          if (this.c().e == 115) {
                                             if (this.al == Char.getMyChar()) {
                                                GameScr.ez = 1;
                                             }

                                             GameScr.fa = 0;
                                             ServerEffect.a(81, this.al.cx1, this.j + TileMap.size, 2);
                                             ServerEffect.a(81, this.al.cx1 - 40, this.j + TileMap.size, 2);
                                             ServerEffect.a(81, this.al.cx1 + 40, this.j + TileMap.size, 2);
                                             break label1062;
                                          }

                                          if (this.c().e == 116) {
                                             if (this.al == Char.getMyChar()) {
                                                GameScr.ez = 1;
                                                GameScr.fa = 0;
                                             }

                                             if (this.al.cx1 > this.x1) {
                                                ServerEffect.a(86, this.x1, this.y1 - this.l / 2 + 5, 1);
                                             } else {
                                                ServerEffect.a(88, this.x1, this.y1 - this.l / 2 + 5, 1);
                                             }

                                             ServerEffect.a(87, this.al.cx1, this.al.cy1 - this.al.bg / 2, 2);
                                             ServerEffect.a(87, this.al.cx1 - 40, this.al.cy1 - this.al.bg / 2, 2);
                                             ServerEffect.a(87, this.al.cx1 + 40, this.al.cy1 - this.al.bg / 2, 2);
                                             break label1062;
                                          }

                                          if (this.c().e == 138) {
                                             if (this.al.cx1 > this.x1) {
                                                ServerEffect.a(89, this.x1 + this.k / 2, this.y1 - this.l / 2 - 5, 1);
                                             } else {
                                                ServerEffect.a(89, this.x1 - this.k / 2, this.y1 - this.l / 2 - 5, 1, (byte)-1);
                                             }

                                             ServerEffect.a(90, this.al, 2);
                                             break label1062;
                                          }

                                          if (this.c().e == 139) {
                                             if (this.al == Char.getMyChar()) {
                                                GameScr.ez = 1;
                                                GameScr.fa = 0;
                                             }

                                             ServerEffect.a(91, this.al, 2);
                                             break label1062;
                                          }

                                          if (this.c().e != 140 && this.c().e != 161) {
                                             if (this.c().e != 141 && this.c().e != 162) {
                                                if (this.c().e != 144 && this.c().e != 163) {
                                                   if (this.c().e == 160) {
                                                      if (this.al.cx1 > this.x1) {
                                                         ServerEffect.a(123, this.x1 + this.k / 2, this.y1 - 5, 1);
                                                      } else {
                                                         ServerEffect.a(123, this.x1 - this.k / 2, this.y1 - 5, 1, (byte)-1);
                                                      }

                                                      ServerEffect.a(91, this.al, 1);
                                                      break label1062;
                                                   }

                                                   if (this.c().e != 164 && this.c().e != 165) {
                                                      if (this.c().e == 167) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(125, this.x1 + this.k / 2, this.y1, 1);
                                                         } else {
                                                            ServerEffect.a(125, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                         }
                                                      } else if (this.c().e == 166) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(108, this.x1 + this.k / 2, this.y1, 1);
                                                         } else {
                                                            ServerEffect.a(108, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                         }
                                                      } else if (this.c().e == 198) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(143, this.x1 + this.k / 2, this.y1, 1);
                                                         } else {
                                                            ServerEffect.a(143, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                         }
                                                      } else if (this.c().e == 199) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(144, this.x1 + this.k / 2, this.y1, 1);
                                                         } else {
                                                            ServerEffect.a(144, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                         }
                                                      } else if (this.c().e == 200) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(142, this.x1 + this.k / 2, this.y1, 1);
                                                         } else {
                                                            ServerEffect.a(142, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                         }
                                                      } else if (this.c().e == 201) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(144, this.x1 + this.k / 2, this.y1, 1);
                                                         } else {
                                                            ServerEffect.a(144, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                         }
                                                      } else if (this.c().e == 203) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(159, this.x1 + this.k / 2, this.y1, 1);
                                                            ServerEffect.a(156, this.al.cx1, this.al.cy1, 1);
                                                         } else {
                                                            ServerEffect.a(159, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                            ServerEffect.a(156, this.al.cx1, this.al.cy1, -1);
                                                         }
                                                      } else if (this.c().e == 204) {
                                                         if (this.al.cx1 > this.x1) {
                                                            ServerEffect.a(159, this.x1 + this.k / 2, this.y1, 1);
                                                            ServerEffect.a(173, this.al.cx1, this.al.cy1, 1);
                                                         } else {
                                                            ServerEffect.a(159, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                            ServerEffect.a(173, this.al.cx1, this.al.cy1, -1);
                                                         }
                                                      }
                                                      break label1062;
                                                   }

                                                   if (this.al.cx1 > this.x1) {
                                                      ServerEffect.a(125, this.x1 + this.k / 2, this.y1, 1);
                                                   } else {
                                                      ServerEffect.a(125, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                                   }

                                                   ServerEffect.a(90, this.al, 1);
                                                   break label1062;
                                                }

                                                if (this.al == Char.getMyChar()) {
                                                   GameScr.ez = 1;
                                                   GameScr.fa = 0;
                                                }

                                                ServerEffect.a(112, this.al, 2);
                                                ServerEffect.a(109, this.al.cx1 - 40, this.al.cy1 - 40, 1);
                                                ServerEffect.a(109, this.al.cx1 + 40, this.al.cy1 - 40, 1);
                                                ServerEffect.a(109, this.al.cx1 - 20, this.al.cy1, 2);
                                                ServerEffect.a(109, this.al.cx1 + 20, this.al.cy1, 2);
                                                break label1062;
                                             }

                                             if (this.al.cx1 > this.x1) {
                                                ServerEffect.a(108, this.x1 + this.k / 2, this.y1, 1);
                                             } else {
                                                ServerEffect.a(108, this.x1 - this.k / 2, this.y1, 1, (byte)-1);
                                             }

                                             ServerEffect.a(122, this.x1, this.y1, 1, (byte)this.dir);
                                             ServerEffect.a(91, this.al, 1);
                                             break label1062;
                                          }

                                          if (this.al == Char.getMyChar()) {
                                             GameScr.ez = 1;
                                             GameScr.fa = 0;
                                          }

                                          ServerEffect.a(112, this.al, 2);
                                          ServerEffect.a(109, this.al.cx1 - 40, this.al.cy1 - 40, 1);
                                          ServerEffect.a(109, this.al.cx1 + 40, this.al.cy1 - 40, 1);
                                          ServerEffect.a(109, this.al.cx1 - 20, this.al.cy1, 2);
                                          ServerEffect.a(109, this.al.cx1 + 20, this.al.cy1, 2);
                                          break label1062;
                                       }

                                       if (Res.e(var2 - this.x1) >= 24 || Res.e(var3 - this.y1) >= 15) {
                                          if (this.isBoss) {
                                             if (this.c().e == 210) {
                                                if (this.al.cx1 > this.x1) {
                                                   ServerEffect.a(178, this.al.cx1, this.al.cy1, 1);
                                                } else {
                                                   ServerEffect.a(178, this.al.cx1, this.al.cy1, 1, (byte)-1);
                                                }
                                             } else if (this.c().e == 209) {
                                                if (this.al.cx1 > this.x1) {
                                                   ServerEffect.a(179, this.al.cx1, this.al.cy1, 1);
                                                } else {
                                                   ServerEffect.a(179, this.al.cx1, this.al.cy1, 1, (byte)-1);
                                                }
                                             } else if (this.c().e != 114 && this.c().e != 115) {
                                                if (this.c().e == 116) {
                                                   ServerEffect.a(84, this.al, 2);
                                                   this.aa = false;
                                                   this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                } else if (this.c().e == 138) {
                                                   if (this.al == Char.getMyChar()) {
                                                      GameScr.ez = 1;
                                                      GameScr.fa = 0;
                                                   }

                                                   ServerEffect.a(83, this.al, 2);
                                                   this.aa = false;
                                                   this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                } else if (this.c().e == 139) {
                                                   MonsterDart.a(this.x1 + (this.dir - 1) * 30, this.y1 - 30, this.isBoss, this.levelBoss, this.c().e, this.dame, this.dameMp, this.al);
                                                } else if (this.c().e != 140 && this.c().e != 161) {
                                                   if (this.c().e != 141 && this.c().e != 162) {
                                                      if (this.c().e != 144 && this.c().e != 163) {
                                                         if (this.c().e == 160) {
                                                            ServerEffect.a(124, this.al, 2);
                                                            this.aa = false;
                                                            this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                         } else if (this.c().e != 164 && this.c().e != 165) {
                                                            if (this.c().e == 167) {
                                                               ServerEffect.a(112, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(112, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(112, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            } else if (this.c().e == 166) {
                                                               ServerEffect.a(92, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(92, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(92, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            } else if (this.c().e == 198) {
                                                               ServerEffect.a(142, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(142, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(142, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            } else if (this.c().e == 199) {
                                                               ServerEffect.a(143, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(143, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(143, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            } else if (this.c().e == 200) {
                                                               ServerEffect.a(144, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(144, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(144, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            } else if (this.c().e == 201) {
                                                               ServerEffect.a(108, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(108, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(108, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            } else if (this.c().e == 203) {
                                                               ServerEffect.a(149, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(149, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(149, this.al, 1);
                                                               ServerEffect.a(156, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            } else if (this.c().e == 204) {
                                                               ServerEffect.a(153, this.al.cx1 + 5, this.al.cy1, 1);
                                                               ServerEffect.a(153, this.al.cx1 - 5, this.al.cy1, 1);
                                                               ServerEffect.a(153, this.al, 1);
                                                               ServerEffect.a(173, this.al, 1);
                                                               this.aa = false;
                                                               this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                            }
                                                         } else {
                                                            ServerEffect.a(126, this.al, 1);
                                                            this.aa = false;
                                                            this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                         }
                                                      } else {
                                                         MonsterDart.a(this.x1 + (this.dir - 1) * 15, this.y1 - 20, this.isBoss, this.levelBoss, this.c().e, this.dame, this.dameMp, this.al);
                                                      }
                                                   } else {
                                                      if (this.al == Char.getMyChar()) {
                                                         GameScr.ez = 1;
                                                         GameScr.fa = 0;
                                                      }

                                                      ServerEffect.a(121, this.al, 1);
                                                      this.aa = false;
                                                      this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                   }
                                                } else {
                                                   if (this.al == Char.getMyChar()) {
                                                      GameScr.ez = 1;
                                                      GameScr.fa = 0;
                                                   }

                                                   ServerEffect.a(110, this.al, 2);
                                                   ServerEffect.a(104, this.al.cx1 - 20, this.al.cy1, 2);
                                                   ServerEffect.a(104, this.al.cx1 + 20, this.al.cy1, 2);
                                                   this.aa = false;
                                                   this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                                }
                                             } else {
                                                MonsterDart.a(this.x1 + (this.dir - 1) * 15, this.y1 - 20, this.isBoss, this.levelBoss, this.c().e, this.dame, this.dameMp, this.al);
                                             }
                                          } else {
                                             MonsterDart.a(this.x1 - 5, this.y1 + this.dir * 10, this.isBoss, this.level, this.c().e, this.dame, this.dameMp, this.al);
                                          }

                                          this.aa = false;
                                          break label1062;
                                       }

                                       this.al.a(this.dame, this.dameMp, this.isBoss, this.c().e);
                                    } else {
                                       if (this.typeAtt != 1) {
                                          break label1062;
                                       }

                                       if (Res.e(var2 - this.x1) < 24 && Res.e(var3 - this.y1) < 15) {
                                          this.am.d = true;
                                       } else if (this.isBoss) {
                                          MonsterDart.a(this.x1 - 5, this.y1 + this.dir * 10 - 20, this.am);
                                       } else {
                                          MonsterDart.a(this.x1 - 5, this.y1 + this.dir * 10, this.am);
                                       }
                                    }

                                    this.aa = false;
                                 }
                              }

                              this.dir = this.x1 < var2 ? 1 : -1;
                           } else if (this.ag == 1) {
                              if (b[this.s].c != 0 && !this.o && !this.q && !this.r) {
                                 this.x1 += (this.i - this.x1) / 4;
                                 this.y1 += (this.j - this.y1) / 4;
                              }

                              if (Res.e(this.i - this.x1) < 5 && Res.e(this.j - this.y1) < 5) {
                                 this.status = 2;
                                 this.ag = 0;
                                 this.ah = 0;
                              }
                           }
                        }
                     } else {
                        this.i();
                     }
                  } else {
                     this.l();
                  }
                  break;
               case 4:
                  this.aj = 0;
                  this.frame = 0;
                  ++this.ag;
                  if (this.ag > 40 + this.m % 5) {
                     this.y1 -= 2;
                     this.status = 5;
                     this.ag = 0;
                  }
                  break;
               case 5:
                  try {
                     if (GameCanvas.w % 4 == 0 && this.isBoss) {
                        ++this.frameIndex;
                        if (this.frameIndex > b[this.s].k.length - 1) {
                           this.frameIndex = 0;
                        }
                     }
                  } catch (Exception var6) {
                  }

                  this.aj = 0;
                  this.j();
                  break;
               case 6:
                  this.aj = 0;
                  ++this.ag;
                  this.y1 += this.ag;
                  if (this.y1 >= this.j) {
                     this.y1 = this.j;
                     this.ag = 0;
                     this.status = 5;
                  }
                  break;
               case 7:
                  this.h();
                  break;
               case 8:
                  this.frame = 0;
                  break;
               case 9:
                  this.frame = this.e(GameCanvas.w);
                  if (this.frame == 1) {
                     this.status = 8;
                  }
            }

            this.k();
            if (this.at && this.hp <= 0) {
               GameScr.vMob.removeElement(this);
               if (this.levelBoss > 0) {
                  Auto.remove_Mob(this);
               }
            }

            this.a((byte)1, this.status);
         }
      }

   }

   public final void b() {
      if (this.hp > 0) {
         this.aj = 4;
         this.status = 7;
      }

   }

   public final void a(Char var1) {
      this.aa = true;
      this.al = var1;
      this.ag = 0;
      this.ah = 0;
      this.status = 3;
      if (this.s != 209 && this.s != 210) {
         if (this.s != 168 && this.s != 176 && this.s != 177 && this.s != 179) {
            if (this.s != 169 && this.s != 171 && this.s != 172 && this.s != 182) {
               if (this.s == 175) {
                  this.frameIndex = 7;
               } else if (this.s != 181 && this.s != 185 && this.s != 188 && this.s != 194 && this.s != 192) {
                  if (this.s != 183 && this.s != 170 && this.s != 193) {
                     if (this.s != 187 && this.s != 168 && this.s != 175 && this.s != 176 && this.s != 179 && this.s != 174) {
                        this.frameIndex = 0;
                     } else {
                        this.frameIndex = this.d(GameCanvas.w);
                     }
                  } else {
                     this.frameIndex = 4;
                  }
               } else {
                  this.frameIndex = 3;
               }
            } else {
               this.frameIndex = 2;
            }
         } else {
            this.frameIndex = 6;
         }
      } else {
         this.frameIndex = 0;
      }

      this.typeAtt = 0;
   }

   public final void a(BuNhin var1) {
      this.am = var1;
      this.ag = 0;
      this.ah = 0;
      this.status = 3;
      this.typeAtt = 1;
   }

   private void h() {
      if (!Code.dongbang_quai) {
         this.frame = this.isBoss ? (this.c().e == 204 ? 9 : (this.c().e == 203 ? 9 : (this.c().e == 139 ? 4 : (this.c().e == 160 ? 12 : 10)))) : 2;
         if (this.c().e != 209 && this.c().e != 210) {
            if (this.c().e == 141) {
               this.frame = 13;
            } else if (this.c().e != 169 && this.c().e != 170 && this.c().e != 171 && this.c().e != 172 && this.c().e != 182) {
               if (this.c().e != 168 && this.c().e != 176 && this.c().e != 177 && this.c().e != 179 && this.c().e != 180) {
                  if (this.c().e != 173 && this.c().e != 184) {
                     if (this.c().e != 181 && this.c().e != 178 && this.c().e != 185 && this.c().e != 202) {
                        if (this.c().e == 174) {
                           this.frame = 10;
                        } else if (this.c().e == 183) {
                           this.frame = 5;
                        } else if (this.c().e == 175) {
                           this.frame = 8;
                        }
                     } else {
                        this.frame = 4;
                     }
                  } else {
                     this.frame = 6;
                  }
               } else {
                  this.frame = 7;
               }
            } else {
               this.frame = 3;
            }
         } else {
            this.frame = 3;
         }

         --this.aj;
         if (this.aj > 0) {
            if (b[this.s].c != 0 && this.x1 > this.i - b[this.s].a) {
               b[this.s].getClass();
            }
         } else {
            if ((this.ac == null || !this.ad) && this.hp != 0) {
               this.status = 5;
               if (this.ac != null) {
                  this.dir = -this.ac.cdir;
                  if (Res.e(this.x1 - this.ac.cx1) < 24) {
                     this.status = 2;
                  }
               }

               this.ag = this.ah = this.ai = 0;
               this.aj = 0;
            } else {
               this.status = 1;
               this.ah = this.ac.cdir << 3;
               this.ag = -5;
               this.ai = 0;
            }

            this.ac = null;
         }

      }
   }

   private void i() {
      if (this.ag == 0) {
         boolean var1 = false;
         boolean var2 = false;
         int var3 = this.al.cx1;
         int var4 = this.al.cy1;
         this.typeAtt = this.ba;
         if (b[this.s].b > 0) {
            this.dir = this.x1 >= var3 ? 0 : 1;
         }

         if (this.isBoss) {
            ++this.frameIndex;
            if (this.frameIndex >= b[this.s].l[this.typeAtt].length) {
               this.frameIndex = 0;
               this.status = 2;
               this.ax = null;
               this.ay = null;
               this.ag = 0;
               this.ah = 0;
            }

            if (this.frameIndex == b[this.s].l[this.typeAtt].length - 1) {
               if (this.bb == 0) {
                  ServerEffect.a(this.az, var3, var4, 1, (byte)(this.dir == 0 ? -1 : 1));
               } else if (this.bb == 1 && this.az > -1) {
                  EffectAuto.a(this.az, var3, var4, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
               }
            }

            this.frame = b[this.s].l[this.ba][this.frameIndex];
         } else {
            ServerEffect.a(this.az, var3, var4, 1, (byte)(this.dir == 0 ? -1 : 1));
         }

         if (b[this.s].c != 0 && !this.o && this.q && this.r) {
            this.x1 += (var3 - this.x1) / 3;
         }

         if (this.x1 > this.i + b[this.s].a) {
            this.ag = 1;
         }

         if (this.x1 < this.i - b[this.s].a) {
            this.ag = 1;
            return;
         }
      } else if (this.ag == 1) {
         if (b[this.s].c != 0 && !this.o && !this.q && !this.r) {
            this.x1 += (this.i - this.x1) / 4;
            this.y1 += (this.j - this.y1) / 4;
         }

         if (Res.e(this.i - this.x1) < 5 && Res.e(this.j - this.y1) < 5) {
            this.status = 2;
            this.frameIndex = 0;
            this.ag = 0;
            this.ah = 0;
         }
      }

   }

   public static int a(int var0, int var1, int var2, int var3) {
      int var10000 = var0 - var2;
      var1 -= var3;
      if ((var0 = var10000 * var10000 + var1 * var1) <= 0) {
         return 0;
      } else {
         var1 = (var0 + 1) / 2;

         do {
            var2 = var1;
            var1 = var1 / 2 + var0 / (var1 * 2);
         } while(Math.abs(var2 - var1) > 1);

         return var1;
      }
   }

   private void j() {
      try {
         if (!Code.dongbang_quai) {
            if (this.ad) {
               this.status = 1;
               this.ah = this.ac.cdir << 3;
               this.ag = -5;
               this.ai = 0;
            }

            if (!this.q) {
               if (!this.o && !this.r) {
                  byte var1;
                  switch (b[this.s].c) {
                     case 0:
                        if (this.s == 176) {
                           this.status = 9;
                        }

                        this.frame = 0;
                        return;
                     case 1:
                     case 2:
                     case 3:
                        if ((var1 = b[this.s].b) == 1) {
                           if (GameCanvas.w % 2 == 1) {
                              return;
                           }
                        } else if (var1 > 2) {
                           var1 = (byte)(var1 + this.m % 2);
                        } else if (GameCanvas.w % 2 == 1 && b[this.s].b != 0) {
                           --var1;
                        }

                        this.x1 += var1 * this.dir;
                        if (Res.d(0, b[this.s].a) == b[this.s].a / 3) {
                           this.status = 2;
                           this.au = System.currentTimeMillis();
                        }

                        if (this.x1 > this.i + b[this.s].a) {
                           this.dir = -1;
                           if (this.s == 168 || this.s == 177) {
                              this.status = 9;
                              this.ag = 0;
                           }
                        } else if (this.x1 < this.i - b[this.s].a) {
                           this.dir = 1;
                           if (this.s == 168 || this.s == 177) {
                              this.status = 9;
                              this.ag = 0;
                           }
                        }

                        if (!this.isBoss) {
                           if (this.s < 168) {
                              this.frame = GameCanvas.w % 4 > 1 ? 0 : 1;
                              return;
                           }

                           this.frame = this.b(GameCanvas.w);
                           return;
                        }

                        this.frame = b[this.s].k[this.frameIndex];
                        return;
                     case 4:
                        if (this.s < 236) {
                           var1 = (byte)(b[this.s].b + this.m % 2);
                           this.x1 += var1 * this.dir;
                           if (GameCanvas.w % 10 > 2 && this.s != 205 && this.s != 206 && this.s != 207 && this.s != 208) {
                              this.bc = -1;
                              this.y1 += var1 * this.dirV;
                           }

                           if (this.x1 > this.i + b[this.s].a) {
                              this.dir = -1;
                              if (this.s == 179 || this.s == 175) {
                                 this.status = 9;
                              }

                              this.ag = 0;
                           } else if (this.x1 < this.i - b[this.s].a) {
                              this.dir = 1;
                              if (this.s == 179 || this.s == 175) {
                                 this.status = 9;
                              }

                              this.ag = 0;
                           }

                           if (this.y1 > this.j + 24) {
                              this.dirV = -1;
                           } else if (this.y1 < this.j - (20 + GameCanvas.w % 10)) {
                              this.dirV = 1;
                           }

                           if (this.isBoss) {
                              this.frame = b[this.s].k[this.frameIndex];
                              return;
                           }

                           if (this.s < 168) {
                              this.frame = GameCanvas.w % 4 > 1 ? 0 : 1;
                           } else {
                              this.frame = this.b(GameCanvas.w);
                           }

                           return;
                        } else {
                           if (this.ab != null) {
                              var1 = b[this.s].b;
                              byte var2 = b[this.s].b;
                              if (this.ab.statusMe != 1 && this.ab.statusMe != 6 && a(this.x1, this.y1, this.ab.cx1, this.ab.cy1) > b[this.s].a) {
                                 var1 = (byte)(b[this.s].b + 2);
                              }

                              var1 = (byte)(var1 + this.m % 2);
                              var2 = (byte)(var2 + this.m % 2);
                              if (this.ab.statusMe != 1 && this.ab.statusMe != 6) {
                                 this.aw = false;
                                 this.av = false;
                                 if (this.x1 <= this.i + b[this.s].a) {
                                    if (this.x1 < this.i - b[this.s].a) {
                                       this.dir = 1;
                                       if (this.s == 179 || this.s == 175) {
                                          this.status = 9;
                                       }

                                       this.ag = 0;
                                    }
                                 } else {
                                    this.dir = -1;
                                    if (this.s == 179 || this.s == 175) {
                                       this.status = 9;
                                    }

                                    this.ag = 0;
                                 }
                              } else if (this.x1 - this.i >= b[this.s].a) {
                                 this.av = true;
                                 this.aw = false;
                              } else if (this.i - this.x1 >= b[this.s].a) {
                                 this.aw = true;
                                 this.av = false;
                              }

                              if (this.av) {
                                 this.dir = -1;
                              }

                              if (this.aw) {
                                 this.dir = 1;
                              }

                              this.x1 += var1 * this.dir;
                              if (GameCanvas.w % 10 > 2 && this.s != 205 && this.s != 206 && this.s != 207 && this.s != 208) {
                                 this.bc = -1;
                                 this.y1 += var2 * this.dirV;
                              }

                              if (this.y1 > this.j + 24) {
                                 this.dirV = -1;
                              } else if (this.y1 < this.j - (20 + GameCanvas.w % 10)) {
                                 this.dirV = 1;
                              }

                              if (!this.isBoss) {
                                 if (this.s < 168) {
                                    this.frame = GameCanvas.w % 4 > 1 ? 0 : 1;
                                    return;
                                 }

                                 this.frame = this.b(GameCanvas.w);
                              }
                           }

                           return;
                        }
                     case 5:
                        var1 = (byte)(b[this.s].b + this.m % 2);
                        this.x1 += var1 * this.dir;
                        var1 = (byte)(var1 + (GameCanvas.w + this.m) % 2);
                        if (GameCanvas.w % 10 > 2) {
                           this.y1 += var1 * this.dirV;
                        }

                        if (this.x1 > this.i + b[this.s].a) {
                           this.dir = -1;
                           if (this.s != 179 && this.s != 175) {
                              this.status = 2;
                           } else {
                              this.status = 9;
                           }

                           this.ag = 0;
                        } else if (this.x1 < this.i - b[this.s].a) {
                           this.dir = 1;
                           if (this.s != 179 && this.s != 175) {
                              this.status = 2;
                           } else {
                              this.status = 9;
                           }

                           this.ag = 0;
                        }

                        if (this.y1 > this.j + 24) {
                           this.dirV = -1;
                        } else if (this.y1 < this.j - (20 + GameCanvas.w % 10)) {
                           this.dirV = 1;
                        }

                        if (TileMap.tileTypeAt(this.x1, this.y1, 2)) {
                           if (GameCanvas.w % 10 > 5) {
                              this.y1 = TileMap.tileYofPixel(this.y1);
                              this.status = 4;
                              this.ag = 0;
                           }

                           this.dirV = -1;
                        }

                        if (!this.isBoss) {
                           if (this.s < 168) {
                              this.frame = GameCanvas.w % 4 > 1 ? 3 : 1;
                              return;
                           }

                           this.frame = this.b(GameCanvas.w);
                           return;
                        } else {
                           this.frame = b[this.s].k[this.frameIndex];
                        }
                     default:
                  }
               } else {
                  this.frame = 0;
               }
            }
         }
      } catch (Exception var3) {
      }
   }

   public final MobTemplate c() {
      return b[this.s];
   }

   public final boolean d() {
      if (this.x1 < GameScr.p) {
         return false;
      } else if (this.x1 > GameScr.p + GameScr.i) {
         return false;
      } else if (this.y1 < GameScr.q) {
         return false;
      } else if (this.y1 > GameScr.q + GameScr.j + 30) {
         return false;
      } else if (b[this.s] == null) {
         return false;
      } else {
         if (!this.isBoss) {
            if (this.frame >= b[this.s].h.length) {
               return false;
            }

            if (b[this.s].h[this.frame] == null) {
               return false;
            }

            if (this.s != 179 && this.s != 175 && this.s != 202) {
               if (this.s == 176 && (this.frame == 1 || this.frame == 0)) {
                  return false;
               }
            } else if (this.status == 8) {
               return false;
            }
         }

         return this.status != 0;
      }
   }

   protected static boolean check() {
      return Char.getMyChar().cHpNew <= 0 || Char.getMyChar().statusMe == 14 || Char.getMyChar().statusMe == 5;
   }

   public static Mob getMob() {
      Mob var0 = null;

      for(int var1 = 0; var1 < GameScr.vMob.size(); ++var1) {
         if (((Mob)GameScr.vMob.elementAt(var1)).status != 0 && ((Mob)GameScr.vMob.elementAt(var1)).status != 1 && ((Mob)GameScr.vMob.elementAt(var1)).hp > 0 && ((Mob)GameScr.vMob.elementAt(var1)).level != 3) {
            var0 = (Mob)GameScr.vMob.elementAt(var1);
         }
      }

      if (!var0.isBoss && var0.level != 3) {
         Auto.d(var0);
      }

      return var0;
   }

   public final void a(mGraphics var1) {
      if (this.d()) {
         int var2 = this.y1;
         if (this.s == 205 || this.s == 206 || this.s == 207 || this.s == 208) {
            ++this.bc;
            if (this.bc > Char.en.length - 1) {
               this.bc = 0;
            }
         }

         if (this.bc > -1) {
            var2 += Char.en[this.bc];
         }

         MobTemplate var3 = b[this.s];
         if (!this.isBoss) {
            if (this.k == 0) {
               this.k = mGraphics.a(var3.h[0]);
            }

            if (this.l == 0) {
               this.l = mGraphics.b(var3.h[0]);
            }
         } else {
            this.k = 40;
            this.l = 40;
         }

         this.b(var1, this.x1, var2, 0);

         int var4;
         int var6;
         byte var22;
         try {
            var4 = this.dir > 0 ? 0 : 2;
            if (this.s == 219) {
               var4 = 0;
            }

            if ((this.s == 98 || this.s == 99) && this.status == 1) {
               long var20;
               if ((var20 = System.currentTimeMillis()) - this.timeStartDie < 400L) {
                  var1.a(var3.h[this.frame], 0, 0, mGraphics.a(var3.h[this.frame]), mGraphics.b(var3.h[this.frame]), var4, this.x1, var2, StaticObj.d);
               } else if (var20 - this.timeStartDie < 800L) {
                  var1.a(var3.h[this.frame], 0, 0, mGraphics.a(var3.h[this.frame]), 3 * mGraphics.b(var3.h[this.frame]) / 5, var4, this.x1, var2, StaticObj.d);
               } else if (var20 - this.timeStartDie < 1200L) {
                  var1.a(var3.h[this.frame], 0, 0, mGraphics.a(var3.h[this.frame]), mGraphics.b(var3.h[this.frame]) / 3, var4, this.x1, var2, StaticObj.d);
               }

               if (GameCanvas.w % 8 < 2) {
                  SmallImage.a(var1, 457, this.x1, var2, 0, StaticObj.d);
               } else if (GameCanvas.w % 8 < 4) {
                  SmallImage.a(var1, 458, this.x1, var2, 0, StaticObj.d);
               } else if (GameCanvas.w % 8 < 6) {
                  SmallImage.a(var1, 459, this.x1, var2, 0, StaticObj.d);
               }
            } else if (this.isBoss) {
               if (this.c().j != null) {
                  Frame var5;
                  MobTemplate var10000;
                  if (this.s < 236) {
                     var5 = this.c().j[this.frame];

                     for(var6 = 0; var6 < var5.a.length; ++var6) {
                        var10000 = this.c();
                        var22 = var5.c[var6];
                        ImageInfo var17 = var10000.i[var22];
                        if (this.dir > 0) {
                           var1.a(this.c().h[0], var17.a, var17.b, var17.c, var17.d, 0, this.x1 + var5.a[var6], var2 + var5.b[var6] - 1, 20);
                        } else {
                           var1.a(this.c().h[0], var17.a, var17.b, var17.c, var17.d, 2, this.x1 - var5.a[var6], var2 + var5.b[var6] - 1, 24);
                        }
                     }
                  } else {
                     mGraphics var19 = var1;
                     Mob var16 = this;

                     try {
                        if (GameCanvas.w % 2 == 0 && var16.status != 3) {
                           ++var16.bg;
                           if (var16.bg > var16.c().k.length - 1) {
                              var16.bg = 0;
                           }

                           var16.frame = var16.c().k[var16.bg];
                        }

                        var5 = var16.c().j[var16.frame];

                        for(var6 = 0; var6 < var5.a.length; ++var6) {
                           if (var5.e[var6] != 0) {
                              var10000 = var16.c();
                              int var8 = var5.c[var6];
                              ImageInfo var7;
                              var8 = (var7 = var10000.i[var8]).a;
                              int var9 = var7.b;
                              int var10 = var7.c;
                              int var23 = var7.d;
                              int var11 = var5.a[var6];
                              short var12 = var5.b[var6];
                              if (var8 > var16.c().h[0].getWidth()) {
                                 var8 = 0;
                              }

                              if (var9 > var16.c().h[0].getHeight()) {
                                 var9 = 0;
                              }

                              if (var8 + var10 > var16.c().h[0].getWidth()) {
                                 var10 = var16.c().h[0].getWidth() - var8;
                              }

                              if (var9 + var23 > var16.c().h[0].getHeight()) {
                                 var23 = var16.c().h[0].getHeight() - var9;
                              }

                              int var13 = var5.d[var6] == 1 ? 2 : 0;
                              if (var16.dir == 1) {
                                 if (var13 == 2) {
                                    var13 = 0;
                                    var11 += var10;
                                 } else {
                                    var13 = 2;
                                    var11 = -(var11 + var10);
                                 }
                              }

                              var19.a(var16.c().h[0], var8, var9, var10, var23, var13, var16.x1 + var11, var16.y1 + var12, 0);
                           }
                        }
                     } catch (Exception var18) {
                        ;
                        ;
                     }

                     this.b(var1);
                  }
               }
            } else if (this.s == 168 && this.status != 8) {
               var1.a(var3.h[this.frame], 0, 0, mGraphics.a(var3.h[this.frame]), mGraphics.b(var3.h[this.frame]), var4, this.x1, var2, StaticObj.d);
            } else {
               var1.a(var3.h[this.frame], 0, 0, mGraphics.a(var3.h[this.frame]), mGraphics.b(var3.h[this.frame]), var4, this.x1, var2, StaticObj.d);
            }

            this.a(var1, this.x1, var2, 0);
         } catch (Exception var19) {
            ;
         }

         var4 = var2;
         int var21;
         if (Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.equals(this) && this.status != 1) {
            int var18;
            if (this.isBoss) {
               if ((var21 = this.maxHp) < this.hp) {
                  var21 = this.hp;
               }

               var6 = (int)((long)this.hp * 100L / (long)var21);
               var18 = this.k;
               var22 = 4;
               if (this.levelBoss == 1 || this.levelBoss == 2 || this.levelBoss == 3 || this.isBoss) {
                  var22 = 6;
                  var18 += var18 / 2;
               }

               var18 += 2;
               if ((var6 = var18 * var6 / 100) < 2) {
                  var6 = 2;
               }

               if (this.s == 140 || this.s == 160) {
                  var4 = var2 - 20;
               }

               if (this.s != 142 && this.s != 143) {
                  var1.a(16777215);
                  var1.c(this.x1 - var18 / 2 - 1, var4 - this.l - 12, var18, var22);
                  var1.a(this.e());
                  var1.c(this.x1 - var18 / 2 - 1, var4 - this.l - 12, var6, var22);
                  var1.a(0);
                  var1.b(this.x1 - var18 / 2 - 1, var4 - this.l - 12, var18, var22);
               } else {
                  SmallImage.a(var1, 988, this.x1, var4 - this.l, 0, 33);
               }
            } else {
               if ((var21 = this.maxHp) < this.hp) {
                  var21 = this.hp;
               }

               var6 = (int)((long)this.hp * 100L / (long)var21);
               var18 = this.k;
               if (this.s > 167) {
                  var18 = this.k / 2;
               }

               var22 = 4;
               if (this.levelBoss == 1 || this.levelBoss == 2 || this.levelBoss == 3 || this.isBoss) {
                  var22 = 6;
                  var18 += var18 / 2;
               }

               var18 += 2;
               if ((var6 = var18 * var6 / 100) < 2) {
                  var6 = 2;
               }

               if (this.s == 140 || this.s == 160) {
                  var4 = var2 - 20;
               }

               if (this.s != 142 && this.s != 143) {
                  var1.a(16777215);
                  var1.c(this.x1 - var18 / 2 - 1, var4 - this.l - 12, var18, var22);
                  var1.a(this.e());
                  var1.c(this.x1 - var18 / 2 - 1, var4 - this.l - 12, var6, var22);
                  var1.a(0);
                  var1.b(this.x1 - var18 / 2 - 1, var4 - this.l - 12, var18, var22);
               } else {
                  SmallImage.a(var1, 988, this.x1, var4 - this.l, 0, 33);
               }
            }

            if (this.levelBoss > 0) {
               if (this.levelBoss == 1) {
                  mFont.j.a(var1, TextGame.ja[this.levelBoss], this.x1, var4 - this.l - 26, 2, mFont.k);
               } else if (this.levelBoss == 2) {
                  mFont.j.a(var1, TextGame.ja[this.levelBoss], this.x1, var4 - this.l - 26, 2, mFont.k);
               } else if (this.levelBoss == 3) {
                  mFont.h.a(var1, TextGame.ja[this.levelBoss], this.x1, var4 - this.l - 26, 2, mFont.k);
               }

               if (this.n) {
                  SmallImage.a(var1, 494, this.x1, var4 - this.l - 28, 0, 33);
               }
            } else if (this.n) {
               SmallImage.a(var1, 494, this.x1, var4 - this.l - 15, 0, 33);
            }
         } else if (this.levelBoss > 0) {
            if (this.levelBoss == 1) {
               mFont.j.a(var1, TextGame.ja[this.levelBoss], this.x1, var2 - this.l - 20, 2, mFont.k);
            } else if (this.levelBoss == 2) {
               mFont.j.a(var1, TextGame.ja[this.levelBoss], this.x1, var2 - this.l - 20, 2, mFont.k);
            } else if (this.levelBoss == 3) {
               mFont.h.a(var1, TextGame.ja[this.levelBoss], this.x1, var2 - this.l - 20, 2, mFont.k);
            }

            if (this.n) {
               SmallImage.a(var1, 494, this.x1, var2 - this.l - 22, 0, 33);
            }
         } else if (this.n) {
            SmallImage.a(var1, 494, this.x1, var2 - this.l - 5, 0, 33);
         }

         if (this.o) {
            if (GameCanvas.w % 2 == 0) {
               SmallImage.a(var1, 1082, this.x1, var2 - this.l / 2, 0, 3);
            } else {
               SmallImage.a(var1, 1084, this.x1, var2 - this.l / 2, 0, 3);
            }
         }

         if (this.q) {
            SmallImage.a(var1, 290, this.x1, var2, 0, 33);
         }

         if (this.r) {
            if ((var21 = GameCanvas.w % 6) != 0 && var21 != 1) {
               if (var21 != 2 && var21 != 3) {
                  if (var21 == 4 || var21 == 5) {
                     SmallImage.a(var1, 1000, this.x1, var2 - this.l - 5, 0, 3);
                  }
               } else {
                  SmallImage.a(var1, 999, this.x1, var2 - this.l - 5, 0, 3);
               }
            } else {
               SmallImage.a(var1, 998, this.x1, var2 - this.l - 5, 0, 3);
            }
         }

         if (this.p) {
            if ((var21 = GameCanvas.w % 16) == 0) {
               SmallImage.a(var1, 1013, this.x1 - this.k / 2, var2 - this.l + this.l / 4, 0, 3);
               return;
            }

            if (var21 == 1) {
               SmallImage.a(var1, 1014, this.x1 - this.k / 2, var2 - this.l + this.l / 4, 0, 3);
               return;
            }

            if (var21 == 2) {
               SmallImage.a(var1, 1015, this.x1 - this.k / 2, var2 - this.l + this.l / 4, 0, 3);
               return;
            }

            if (var21 == 3) {
               SmallImage.a(var1, 1016, this.x1 - this.k / 2, var2 - this.l + this.l / 4, 0, 3);
               return;
            }

            if (var21 == 4) {
               SmallImage.a(var1, 1013, this.x1 + this.k / 2, var2 - this.l, 0, 3);
               return;
            }

            if (var21 == 5) {
               SmallImage.a(var1, 1014, this.x1 + this.k / 2, var2 - this.l, 0, 3);
               return;
            }

            if (var21 == 6) {
               SmallImage.a(var1, 1015, this.x1 + this.k / 2, var2 - this.l, 0, 3);
               return;
            }

            if (var21 == 7) {
               SmallImage.a(var1, 1016, this.x1 + this.k / 2, var2 - this.l, 0, 3);
               return;
            }

            if (var21 == 8) {
               SmallImage.a(var1, 1013, this.x1 - this.k / 2, var2, 0, 3);
               return;
            }

            if (var21 == 9) {
               SmallImage.a(var1, 1014, this.x1 - this.k / 2, var2, 0, 3);
               return;
            }

            if (var21 == 10) {
               SmallImage.a(var1, 1015, this.x1 - this.k / 2, var2, 0, 3);
               return;
            }

            if (var21 == 11) {
               SmallImage.a(var1, 1016, this.x1 - this.k / 2, var2, 0, 3);
               return;
            }

            if (var21 == 12) {
               SmallImage.a(var1, 1013, this.x1 + this.k / 2, var2 - this.l / 4, 0, 3);
               return;
            }

            if (var21 == 13) {
               SmallImage.a(var1, 1014, this.x1 + this.k / 2, var2 - this.l / 4, 0, 3);
               return;
            }

            if (var21 == 14) {
               SmallImage.a(var1, 1015, this.x1 + this.k / 2, var2 - this.l / 4, 0, 3);
               return;
            }

            if (var21 == 15) {
               SmallImage.a(var1, 1016, this.x1 + this.k / 2, var2 - this.l / 4, 0, 3);
            }
         }
      }

   }

   public final int e() {
      if (this.sys <= 1) {
         return 16711680;
      } else if (this.sys == 2) {
         return 33023;
      } else {
         return this.sys == 3 ? 7443811 : 16711680;
      }
   }

   public final void f() {
      this.hp = 0;
      this.timeStartDie = System.currentTimeMillis();
      if (this.ac != null) {
         this.ad = true;
      } else {
         this.ad = true;
         this.hp = 0;
         this.status = 1;
         this.ag = -5;
         this.ah = -this.dir << 2;
         this.ai = 0;
      }

   }

   public final void a(Mob var1) {
      this.ax = var1;
   }

   public final void b(Char var1) {
      this.ay = var1;
   }

   private void k() {
      int var1;
      int var2;
      if (this.ax != null) {
         if (this.isBoss) {
            this.status = 3;
         } else {
            var1 = this.ax.x1 - this.x1;
            var2 = this.ax.y1 - this.y1;
            this.x1 += var1 / 4;
            this.y1 += var2 / 4;
            this.dir = this.x1 >= this.ax.x1 ? 0 : 1;
            if (this.ax.status == 1 || this.ax.status == 0 || Res.e(var1) < 20 && Res.e(var2) < 20) {
               if (this.bb == 0) {
                  ServerEffect.a(this.az == -1 ? 59 : this.az, this.ax.x1, this.ax.y1, this.dir == 0 ? -1 : 1);
               } else if (this.bb == 1 && this.az > -1) {
                  EffectAuto.a(this.az, this.ax.x1, this.ax.y1, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
               }

               this.ax = null;
            }
         }
      }

      if (this.ay != null) {
         if (this.isBoss) {
            this.status = 3;
            return;
         }

         var1 = this.ay.cx1 - this.x1;
         var2 = this.ay.cy1 - this.y1;
         this.x1 += var1 / 4;
         this.y1 += var2 / 4;
         this.dir = this.x1 >= this.ay.cx1 ? 0 : 1;
         if (this.ay.statusMe == 5 || this.ay.statusMe == 14 || Res.e(var1) < 20 && Res.e(var2) < 20) {
            if (this.bb == 0) {
               ServerEffect.a(this.az == -1 ? 59 : this.az, this.ay.cx1, this.ay.cy1, this.dir == 0 ? -1 : 1);
            } else if (this.bb == 1 && this.az > -1) {
               EffectAuto.a(this.az, this.ay.cx1, this.ay.cy1, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
            }

            this.ay = null;
         }
      }

   }

   public final void a(short var1, byte var2, byte var3) {
      this.az = var1;
      this.ba = var2;
      this.bb = var3;
   }

   public final void g() {
      if (this.s == 116) {
         ServerEffect.a(84, Char.getMyChar(), 1);
      } else if (this.s == 115) {
         ServerEffect.a(81, Char.getMyChar(), 1);
      } else if (this.s == 138) {
         ServerEffect.a(90, Char.getMyChar(), 1);
      } else if (this.s == 139) {
         ServerEffect.a(91, Char.getMyChar(), 1);
      } else if (this.s != 140 && this.s != 161) {
         if (this.s != 141 && this.s != 162) {
            if (this.s != 144 && this.s != 163) {
               if (this.s == 160) {
                  ServerEffect.a(124, Char.getMyChar(), 1);
               } else if (this.s != 164 && this.s != 165) {
                  if (this.s == 166) {
                     ServerEffect.a(103, this.al, 1);
                  } else if (this.s == 166) {
                     ServerEffect.a(105, this.al, 1);
                  }
               } else {
                  ServerEffect.a(126, this.al, 1);
               }
            } else {
               ServerEffect.a(121, Char.getMyChar(), 1);
            }
         } else {
            ServerEffect.a(121, Char.getMyChar(), 1);
         }
      } else {
         ServerEffect.a(110, Char.getMyChar(), 2);
      }

   }

   private int b(int var1) {
      try {
         var1 %= bd[this.s - 168].length;
         return this.s != 198 && this.s != 199 && this.s != 200 && this.s != 201 && this.s != 203 && this.s != 204 ? bd[this.s - 168][var1] : 0;
      } catch (Exception var3) {
         return 0;
      }
   }

   private int c(int var1) {
      try {
         var1 %= be[this.s - 168].length;
         return be[this.s - 168][var1];
      } catch (Exception var3) {
         return 0;
      }
   }

   private int d(int var1) {
      var1 %= 5;
      if (this.s == 178) {
         switch (var1) {
            case 0:
               return 5;
            case 1:
               return 6;
            case 2:
               return 7;
            case 3:
               return 8;
         }
      } else if (this.s == 168) {
         switch (var1) {
            case 0:
               return 1;
            case 1:
               return 2;
            case 2:
               return 3;
            case 3:
               return 4;
            case 4:
               return 5;
         }
      } else if (this.s == 179) {
         switch (var1) {
            case 0:
               return 0;
            case 1:
               return 2;
            case 2:
               return 3;
            case 3:
               return 4;
            case 4:
               return 5;
         }
      } else if (this.s == 175) {
         switch (var1) {
            case 0:
               return 0;
            case 1:
               return 2;
            case 2:
               return 3;
            case 3:
               return 4;
            case 4:
               return 5;
         }
      } else if (this.s == 176) {
         switch (var1) {
            case 0:
               return 2;
            case 1:
               return 3;
            case 2:
               return 4;
            case 3:
               return 5;
            case 4:
               return 6;
         }
      } else if (this.s == 177) {
         switch (var1) {
            case 0:
               return 1;
            case 1:
               return 2;
            case 2:
               return 3;
            case 3:
               return 4;
            case 4:
               return 5;
         }
      } else if (this.s == 174) {
         switch (var1) {
            case 0:
               return 5;
            case 1:
               return 6;
            case 2:
               return 7;
            case 3:
               return 8;
            case 4:
               return 9;
         }
      }

      return 0;
   }

   private int e(int var1) {
      try {
         var1 %= bf[this.s - 168].length;
         return bf[this.s - 168][var1];
      } catch (Exception var3) {
         return 0;
      }
   }

   private void l() {
      if (this.ag == 0) {
         int var1 = 0;
         int var2 = 0;
         if (this.ax != null) {
            var1 = this.ax.x1;
            var2 = this.ax.y1;
         }

         if (this.ay != null) {
            var1 = this.ay.cx1;
            var2 = this.ay.cy1;
         }

         this.typeAtt = this.ba;
         this.dir = this.x1 >= var1 ? 0 : 1;
         if (this.isBoss) {
            ++this.frameIndex;
            if (this.frameIndex >= b[this.s].l[this.typeAtt].length) {
               this.frameIndex = 0;
               this.status = 2;
               this.ax = null;
               this.ay = null;
               this.ag = 0;
               this.ah = 0;
            }

            if (this.frameIndex == b[this.s].l[this.typeAtt].length - 2) {
               if (this.bb == 0) {
                  ServerEffect.a(this.az == -1 ? 59 : this.az, var1, var2, 1, (byte)(this.dir == 0 ? -1 : 1));
               } else if (this.bb == 1 && this.az > -1) {
                  EffectAuto.a(this.az, var1, var2, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
               }
            }

            this.frame = b[this.s].l[this.ba][this.frameIndex];
         }

         if (b[this.s].c != 0 && !this.o && this.q && this.r) {
            this.x1 += (var1 - this.x1) / 3;
         }

         if (this.x1 > this.i + b[this.s].a) {
            this.ag = 1;
         }

         if (this.x1 < this.i - b[this.s].a) {
            this.ag = 1;
            return;
         }
      } else if (this.ag == 1) {
         if (b[this.s].c != 0 && !this.o && !this.q && !this.r) {
            this.x1 += (this.i - this.x1) / 4;
            this.y1 += (this.j - this.y1) / 4;
         }

         if (Res.e(this.i - this.x1) < 5 && Res.e(this.j - this.y1) < 5) {
            this.status = 2;
            this.frameIndex = 0;
            this.ag = 0;
            this.ah = 0;
         }
      }

   }

   public static Mob get_Mob(int var0) {
      for(int var1 = GameScr.vMob.size() - 1; var1 >= 0; --var1) {
         Mob var2;
         if ((var2 = (Mob)GameScr.vMob.elementAt(var1)) != null && var2.m == var0) {
            return var2;
         }
      }

      return null;
   }

   public final void a(mGraphics var1, int var2, int var3) {
      try {
         if (GameCanvas.w % 2 == 0 && this.status != 3) {
            ++this.bg;
            if (this.bg > this.c().k.length - 1) {
               this.bg = 0;
            }

            this.frame = this.c().k[this.bg];
         }

         Frame var4 = this.c().j[this.frame];

         for(int var5 = 0; var5 < var4.a.length; ++var5) {
            if (var4.e[var5] != 0) {
               MobTemplate var10000 = this.c();
               int var7 = var4.c[var5];
               ImageInfo var6;
               var7 = (var6 = var10000.i[var7]).a;
               int var8 = var6.b;
               int var9 = var6.c;
               int var13 = var6.d;
               int var10 = var4.a[var5];
               short var11 = var4.b[var5];
               if (var7 > this.c().h[0].getWidth()) {
                  var7 = 0;
               }

               if (var8 > this.c().h[0].getHeight()) {
                  var8 = 0;
               }

               if (var7 + var9 > this.c().h[0].getWidth()) {
                  var9 = this.c().h[0].getWidth() - var7;
               }

               if (var8 + var13 > this.c().h[0].getHeight()) {
                  var13 = this.c().h[0].getHeight() - var8;
               }

               var10 = -(var10 + var9);
               var1.a(this.c().h[0], var7, var8, var9, var13, 2, var2 + var10, var3 + var11, 0);
            }
         }
      } catch (Exception var14) {
         ;
         ;
      }

   }

   public final void b(mGraphics var1, int var2, int var3) {
      try {
         Frame var4 = this.c().j[this.frame];

         for(int var5 = 0; var5 < var4.a.length; ++var5) {
            if (var4.e[var5] == 0) {
               MobTemplate var10000 = this.c();
               int var7 = var4.c[var5];
               ImageInfo var6;
               var7 = (var6 = var10000.i[var7]).a;
               int var8 = var6.b;
               int var9 = var6.c;
               int var13 = var6.d;
               int var10 = var4.a[var5];
               short var11 = var4.b[var5];
               if (var7 > this.c().h[0].getWidth()) {
                  var7 = 0;
               }

               if (var8 > this.c().h[0].getHeight()) {
                  var8 = 0;
               }

               if (var7 + var9 > this.c().h[0].getWidth()) {
                  var9 = this.c().h[0].getWidth() - var7;
               }

               if (var8 + var13 > this.c().h[0].getHeight()) {
                  var13 = this.c().h[0].getHeight() - var8;
               }

               var10 = -(var10 + var9);
               var1.a(this.c().h[0], var7, var8, var9, var13, 2, var2 + var10, var3 + var11, 0);
            }
         }
      } catch (Exception var14) {
         ;
         ;
      }

   }

   private void b(mGraphics var1) {
      try {
         Frame var2 = this.c().j[this.frame];

         for(int var3 = 0; var3 < var2.a.length; ++var3) {
            if (var2.e[var3] == 0) {
               MobTemplate var10000 = this.c();
               int var5 = var2.c[var3];
               ImageInfo var4;
               var5 = (var4 = var10000.i[var5]).a;
               int var6 = var4.b;
               int var7 = var4.c;
               int var12 = var4.d;
               int var8 = var2.a[var3];
               short var9 = var2.b[var3];
               if (var5 > this.c().h[0].getWidth()) {
                  var5 = 0;
               }

               if (var6 > this.c().h[0].getHeight()) {
                  var6 = 0;
               }

               if (var5 + var7 > this.c().h[0].getWidth()) {
                  var7 = this.c().h[0].getWidth() - var5;
               }

               if (var6 + var12 > this.c().h[0].getHeight()) {
                  var12 = this.c().h[0].getHeight() - var6;
               }

               int var10 = var2.d[var3] == 1 ? 2 : 0;
               if (this.dir == 1) {
                  if (var10 == 2) {
                     var10 = 0;
                     var8 += var7;
                  } else {
                     var10 = 2;
                     var8 = -(var8 + var7);
                  }
               }

               var1.a(this.c().h[0], var5, var6, var7, var12, var10, this.x1 + var8, this.y1 + var9, 0);
            }
         }
      } catch (Exception var13) {
         ;
         ;
      }

   }

   public static Mob b123(int var0) {
      for(int var1 = GameScr.vMob.size() - 1; var1 >= 0; --var1) {
         Mob var2;
         if ((var2 = (Mob)GameScr.vMob.elementAt(var1)) != null && var2.level == var0 && !var2.isBoss) {
            return var2;
         }
      }

      return null;
   }

}
