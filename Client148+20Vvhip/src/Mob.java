import javax.microedition.lcdui.Image;

public final class Mob extends MainObject {
   public static MobTemplate[] arrMobTemplate;
   public int hp;
   public int maxHp;
   public int x;
   public int y;
   private int frame;
   public int dir = 1;
   private int dirV = 1;
   public int status;
   private int p1;
   private int p2;
   private int p3;
   public int xFirst;
   public int yFirst;
   public int gameAK;
   public int gameAL;
   private int timeStatus;
   public short mobId;
   public boolean isDisable;
   public boolean isDontMove;
   public boolean isFire;
   public boolean isIce;
   public boolean isWind;
   private MyVector vMobMove = new MyVector();
   public int templateId;
   private Char cFocus;
   private BuNhin bFocus;
   public int dame;
   public int dameMp;
   public int sys;
   private int gameBN;
   public short levelBoss;
   public short level;
   public boolean isBoss;
   private long timeStartDie = 0L;
   private int gameBP = 0;
   public static Char interestChar;
   public static MyVector vEggMonter = new MyVector();
   private static EggMonters egg;
   private static long timewait;
   private boolean removeWhenDie;
   public boolean isBusyAttackSomeOne = true;
   private long gameBT;
   public Char gameBC;
   public boolean gameBD = false;
   private Mob gameBU;
   private Char gameBV;
   private short gameBW;
   private byte gameBX;
   private byte gameBY;
   private byte gameBZ = -1;
   private static byte[][] idframe = new byte[][]{{3, 4, 5, 6}, new byte[1], {2, 2, 2, 2, 3, 3, 3, 3}, {0, 1}, {0, 1}, {3, 4, 5}, new byte[1], {3, 3, 4, 4, 5, 5}, new byte[1], {3, 4, 5}, {0, 1, 2, 3, 4}, {3, 4, 5}, {4, 5, 6}, new byte[1], {0, 1}, {0, 1}, {3, 3, 4, 4, 5, 5}, {0, 1, 2}, {0, 1, 2}, {5, 6, 7, 8}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {3, 4, 5, 6}, {0, 1, 2}, {0, 1, 2, 3}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, new byte[1], new byte[1], new byte[1], new byte[1], {0, 1, 2}, new byte[1], new byte[1], {0, 0, 1, 1, 2, 2}, {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 1}, {0, 1}};
   private static byte[][] idframeAppear = new byte[][]{{0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, new byte[1]};
   private static byte[][] idframeDisappear = new byte[][]{{5, 4, 3, 2, 1}, new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], {5, 4, 3, 2, 1}, {5, 4, 3, 2, 1}, {5, 4, 3, 2, 1}, new byte[0], {5, 4, 3, 2, 1}, new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, {0, 0, 1, 1, 2, 2, 3, 3}, new byte[1]};

   public Mob(short var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, int var7, int var8, int var9, int var10, int var11, short var12, short var13, byte var14, byte var15, boolean var16, boolean var17) {
      this.isDisable = var2;
      this.isDontMove = var3;
      this.isFire = var4;
      this.isIce = var5;
      this.isWind = var6;
      this.sys = var8;
      this.mobId = var1;
      this.templateId = var7;
      this.hp = var9;
      this.level = (short)var10;
      this.xFirst = this.x = var12;
      this.yFirst = this.y = var13;
      if (var7 != 168 && var7 != 179 && var7 != 175 && var7 != 177 && var7 != 202) {
         this.status = var14;
      } else {
         this.status = 8;
      }

      this.maxHp = var11;
      this.levelBoss = (short)var15;
      this.isBoss = var16;
      if (var7 == 202) {
         egg = new EggMonters(this.xFirst, this.yFirst - 100);
         vEggMonter.addElement(egg);
         EggMonters.ownerEgg = this;
      }

      if (arrMobTemplate[var7].imgs == null) {
         arrMobTemplate[var7].imgs = new Image[0];
         Service.gI().gameAA(var7);
      }

      timewait = (long)Res.gameAB(2000, 3500);
      this.removeWhenDie = var17;
   }

   public final void gameAA() {
      if (arrMobTemplate[this.templateId] != null && arrMobTemplate[this.templateId].imgs != null && (this.isBoss || this.frame < arrMobTemplate[this.templateId].imgs.length && arrMobTemplate[this.templateId].imgs[this.frame] != null) && this.status != 0) {
         if (this.cFocus == null && (this.templateId == 168 || this.templateId == 179 || this.templateId == 175)) {
            this.status = 8;
         }

         if (this.vMobMove != null || arrMobTemplate[this.templateId].rangeMove == 0) {
            if (this.status != 3 && this.isBusyAttackSomeOne) {
               if (this.cFocus != null) {
                  this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                  this.cFocus = null;
               }

               this.isBusyAttackSomeOne = false;
            }

            if (this.hp <= 0 && this.mobId != -1) {
               this.status = 1;
            }

            int var1;
            Mob var2;
            int var3;
            label960:
            switch(this.status) {
            case 1:
               this.isDisable = false;
               this.isDontMove = false;
               this.isFire = false;
               this.isIce = false;
               this.isWind = false;
               if (this.templateId != 98 && this.templateId != 99) {
                  ++this.p1;
                  this.y += this.p1;
                  if (interestChar != null) {
                     if (interestChar.myskill != null) {
                        if (interestChar.myskill.template.id > 72) {
                           if (GameCanvas.gameTick % 9 == 0) {
                              if (this.p2 > 1) {
                                 this.p2 += 5;
                              } else if (this.p2 < -1) {
                                 this.p2 -= 5;
                              }
                           }
                        } else if (GameCanvas.gameTick % 2 == 0) {
                           if (this.p2 > 1) {
                              --this.p2;
                           } else if (this.p2 < -1) {
                              ++this.p2;
                           }
                        }
                     }
                  } else if (Char.getMyChar() != null && Char.getMyChar().myskill != null) {
                     if (Char.getMyChar().myskill.template.id > 72) {
                        if (GameCanvas.gameTick % 9 == 0) {
                           if (this.p2 > 1) {
                              this.p2 += 5;
                           } else if (this.p2 < -1) {
                              this.p2 -= 5;
                           }
                        }
                     } else if (GameCanvas.gameTick % 2 == 0) {
                        if (this.p2 > 1) {
                           --this.p2;
                        } else if (this.p2 < -1) {
                           ++this.p2;
                        }
                     }
                  }

                  this.x += this.p2;
                  if (this.templateId != 209 && this.templateId != 210) {
                     if (this.templateId != 168 && this.templateId != 176 && this.templateId != 177 && this.templateId != 179 && this.templateId != 180 && this.templateId != 191) {
                        if (this.templateId != 178 && this.templateId != 181 && this.templateId != 183 && this.templateId != 185 && this.templateId != 188 && this.templateId != 192 && this.templateId != 194) {
                           if (this.templateId != 173 && this.templateId != 184) {
                              if (this.templateId == 175) {
                                 var2 = this;
                                 var1 = 8;
                              } else if (this.templateId != 170 && this.templateId != 195 && this.templateId != 196 && this.templateId != 197 && this.templateId != 186 && this.templateId != 189 && this.templateId != 190) {
                                 if (this.templateId == 187) {
                                    var2 = this;
                                    var1 = 9;
                                 } else if (this.templateId == 193) {
                                    var2 = this;
                                    var1 = 5;
                                 } else if (this.templateId == 174) {
                                    var2 = this;
                                    var1 = 10;
                                 } else {
                                    var2 = this;
                                    var1 = this.isBoss ? 10 : 2;
                                 }
                              } else {
                                 var2 = this;
                                 var1 = 3;
                              }
                           } else {
                              var2 = this;
                              var1 = 6;
                           }
                        } else {
                           var2 = this;
                           var1 = 4;
                        }
                     } else {
                        var2 = this;
                        var1 = 7;
                     }
                  } else {
                     var2 = this;
                     var1 = 6;
                  }

                  var2.frame = var1;
                  if (this.y > GameScr.gssye * 24 || this.x < GameScr.gssx * 24 || this.x > GameScr.gssxe * 24) {
                     this.p1 = 0;
                     this.p2 = 0;
                     this.x = this.y = 0;
                     this.hp = this.getTemplate().hp;
                     this.status = 0;
                     if (this.templateId < 168) {
                        this.frame = 0;
                     } else {
                        var3 = GameCanvas.gameTick % idframeAppear[this.templateId - 168].length;
                        this.frame = idframeAppear[this.templateId - 168][var3];
                     }

                     this.timeStatus = 0;
                     return;
                  }

                  if (this.p3 == 0 && (TileMap.gameAA(this.x, this.y) & 2) == 2) {
                     this.p1 = this.p1 > 4 ? -4 : -this.p1;
                     this.p3 = 16;
                  }

                  if (this.p3 > 0) {
                     --this.p3;
                  }
               } else if (System.currentTimeMillis() - this.timeStartDie > 1200L) {
                  this.status = 0;
               }
               break;
            case 2:
               this.timeStatus = 0;
               switch(arrMobTemplate[this.templateId].type) {
               case 0:
               case 1:
               case 2:
               case 3:
                  if (this.templateId != 209 && this.templateId != 210) {
                     if (this.templateId != 173 && this.templateId != 175 && this.templateId != 176 && this.templateId != 177 && this.templateId != 179 && this.templateId != 180 && this.templateId != 181 && this.templateId != 183 && this.templateId != 184 && this.templateId != 185) {
                        if (this.templateId != 168 && this.templateId != 179) {
                           if (this.templateId == 174) {
                              this.frame = 4;
                           } else {
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

                  ++this.p1;
                  if (this.p1 > 10 + this.mobId % 10 && System.currentTimeMillis() - (this.gameBT + timewait) >= 0L) {
                     this.status = 5;
                  }

                  if (this.isBoss) {
                     this.frame = GameCanvas.gameTick % 101 > 1 ? 0 : 1;
                  }
                  break label960;
               case 4:
               case 5:
                  if (!this.isBoss) {
                     if (this.templateId < 168) {
                        this.frame = GameCanvas.gameTick % 4 > 1 ? 0 : 1;
                     } else {
                        this.frame = this.gameAC(GameCanvas.gameTick);
                     }
                  } else {
                     this.frame = arrMobTemplate[this.templateId].frameBossMove[this.gameBP];
                  }

                  ++this.p1;
                  if (this.p1 > this.mobId % 3) {
                     this.status = 5;
                  }
               default:
                  break label960;
               }
            case 3:
               if (this.gameBU == null && this.gameBV == null) {
                  int var4;
                  if (this.gameBW < 0) {
                     if (this.templateId != 209 && this.templateId != 210) {
                        if (this.templateId != 176 && this.templateId != 177 && this.templateId != 179) {
                           if (this.templateId == 175) {
                              var2 = this;
                              var1 = 7;
                           } else if (this.templateId != 180 && this.templateId != 181 && this.templateId != 183 && this.templateId != 184 && this.templateId != 173 && this.templateId != 188 && this.templateId != 192 && this.templateId != 194 && this.templateId != 202) {
                              if (this.templateId == 193) {
                                 var2 = this;
                                 var1 = 4;
                              } else if (this.templateId != 187 && this.templateId != 168 && this.templateId != 175 && this.templateId != 176 && this.templateId != 179 && this.templateId != 174) {
                                 var2 = this;
                                 var1 = GameCanvas.gameTick % 4 > 1 ? (arrMobTemplate[this.templateId].type == 5 ? 3 : 0) : 1;
                              } else {
                                 var2 = this;
                                 var1 = this.gameAD(GameCanvas.gameTick);
                              }
                           } else {
                              var2 = this;
                              var1 = 3;
                           }
                        } else {
                           var2 = this;
                           var1 = 6;
                        }
                     } else {
                        var2 = this;
                        var1 = 6;
                     }

                     var2.frame = var1;
                     if (this.p1 == 0) {
                        var4 = 0;
                        var3 = 0;
                        if (this.gameBN == 0) {
                           var4 = this.cFocus.cx;
                           var3 = this.cFocus.cy;
                        } else if (this.gameBN == 1) {
                           var4 = this.bFocus.gameAA;
                           var3 = this.bFocus.gameAB;
                        }

                        if (Res.abs(var4 - this.x) < 24 || Res.abs(var4 - this.x) < 5 || arrMobTemplate[this.templateId].type == 0) {
                           if (this.templateId != 168 && this.templateId != 176 && this.templateId != 177 && this.templateId != 179) {
                              if (this.templateId == 175) {
                                 var2 = this;
                                 var1 = 7;
                              } else {
                                 label1060: {
                                    if (this.templateId != 180 && this.templateId != 181 && this.templateId != 183 && this.templateId != 184 && this.templateId != 173 && this.templateId != 202) {
                                       if (this.templateId == 187 || this.templateId == 168 || this.templateId == 179 || this.templateId == 174) {
                                          var2 = this;
                                          var1 = this.gameAD(GameCanvas.gameTick);
                                          break label1060;
                                       }

                                       var2 = this;
                                       if (arrMobTemplate[this.templateId].imgs.length == 3) {
                                          var1 = 0;
                                          break label1060;
                                       }
                                    } else {
                                       var2 = this;
                                    }

                                    var1 = 3;
                                 }
                              }
                           } else {
                              var2 = this;
                              var1 = 6;
                           }

                           var2.frame = var1;
                        }

                        if (this.isBoss && (Res.abs(var4 - this.x) < 48 || Res.abs(var4 - this.x) < 10 || arrMobTemplate[this.templateId].type == 0)) {
                           this.frame = arrMobTemplate[this.templateId].imgs.length == 3 ? 0 : 3;
                        }

                        if (this.isBoss) {
                           ++this.gameBP;
                           if (Res.abs(var4 - this.x) >= 48 && Res.abs(var3 - this.y) >= 10) {
                              if (this.gameBP >= arrMobTemplate[this.templateId].frameBossAttack[1].length) {
                                 this.gameBP = 0;
                              }

                              this.frame = arrMobTemplate[this.templateId].frameBossAttack[1][this.gameBP];
                           } else {
                              if (this.gameBP >= arrMobTemplate[this.templateId].frameBossAttack[0].length) {
                                 this.gameBP = 0;
                              }

                              this.frame = arrMobTemplate[this.templateId].frameBossAttack[0][this.gameBP];
                           }
                        }

                        if (this.frame == 3 || this.frame == 6 || this.frame == 7) {
                           this.p1 = 1;
                        }

                        if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && this.isIce && this.isWind) {
                           this.x += (var4 - this.x) / 3;
                        }

                        if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                           this.p1 = 1;
                        }

                        if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                           this.p1 = 1;
                        }

                        if ((arrMobTemplate[this.templateId].type == 4 || arrMobTemplate[this.templateId].type == 5) && !this.isDontMove) {
                           this.y += (var3 - this.y) / 20;
                        }

                        ++this.p2;
                        if (this.isBoss && Res.abs(var4 - this.x) < 48 && Res.abs(var3 - this.y) < 15 || Res.abs(var4 - this.x) < 12 && Res.abs(var3 - this.y) < 12 || this.p2 > 12 || this.p1 == 1 || arrMobTemplate != null && arrMobTemplate[this.templateId].frameBossAttack != null && this.gameBP == arrMobTemplate[this.templateId].frameBossAttack[0].length - 2 && (this.getTemplate().mobTemplateId == 166 || this.getTemplate().mobTemplateId == 167)) {
                           label1061: {
                              this.p1 = 1;
                              if (this.gameBN == 0) {
                                 if (this.isBoss && Res.abs(var4 - this.x) < 48 && Res.abs(var3 - this.y) < 15) {
                                    this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                    this.isBusyAttackSomeOne = false;
                                    if (this.getTemplate().mobTemplateId == 210) {
                                       if (this.cFocus.cx > this.x) {
                                          ServerEffect.gameAA(142, this.x, this.y, 1);
                                       } else {
                                          ServerEffect.gameAA(142, this.x, this.y, 1, (byte)-1);
                                       }
                                       break label1061;
                                    }

                                    if (this.getTemplate().mobTemplateId == 209) {
                                       if (this.cFocus.cx > this.x) {
                                          ServerEffect.gameAA(108, this.x, this.y, 1);
                                       } else {
                                          ServerEffect.gameAA(108, this.x, this.y, 1, (byte)-1);
                                       }
                                       break label1061;
                                    }

                                    if (this.getTemplate().mobTemplateId == 114) {
                                       ServerEffect.gameAA(79, this.cFocus, 3);
                                       break label1061;
                                    }

                                    if (this.getTemplate().mobTemplateId == 115) {
                                       if (this.cFocus == Char.getMyChar()) {
                                          GameScr.gameFU = 1;
                                       }

                                       GameScr.gameFV = 0;
                                       ServerEffect.gameAA(81, this.cFocus.cx, this.yFirst + TileMap.size, 2);
                                       ServerEffect.gameAA(81, this.cFocus.cx - 40, this.yFirst + TileMap.size, 2);
                                       ServerEffect.gameAA(81, this.cFocus.cx + 40, this.yFirst + TileMap.size, 2);
                                       break label1061;
                                    }

                                    if (this.getTemplate().mobTemplateId == 116) {
                                       if (this.cFocus == Char.getMyChar()) {
                                          GameScr.gameFU = 1;
                                          GameScr.gameFV = 0;
                                       }

                                       if (this.cFocus.cx > this.x) {
                                          ServerEffect.gameAA(86, this.x, this.y - this.gameAL / 2 + 5, 1);
                                       } else {
                                          ServerEffect.gameAA(88, this.x, this.y - this.gameAL / 2 + 5, 1);
                                       }

                                       ServerEffect.gameAA(87, this.cFocus.cx, this.cFocus.cy - this.cFocus.ch / 2, 2);
                                       ServerEffect.gameAA(87, this.cFocus.cx - 40, this.cFocus.cy - this.cFocus.ch / 2, 2);
                                       ServerEffect.gameAA(87, this.cFocus.cx + 40, this.cFocus.cy - this.cFocus.ch / 2, 2);
                                       break label1061;
                                    }

                                    if (this.getTemplate().mobTemplateId == 138) {
                                       if (this.cFocus.cx > this.x) {
                                          ServerEffect.gameAA(89, this.x + this.gameAK / 2, this.y - this.gameAL / 2 - 5, 1);
                                       } else {
                                          ServerEffect.gameAA(89, this.x - this.gameAK / 2, this.y - this.gameAL / 2 - 5, 1, (byte)-1);
                                       }

                                       ServerEffect.gameAA(90, this.cFocus, 2);
                                       break label1061;
                                    }

                                    if (this.getTemplate().mobTemplateId == 139) {
                                       if (this.cFocus == Char.getMyChar()) {
                                          GameScr.gameFU = 1;
                                          GameScr.gameFV = 0;
                                       }

                                       ServerEffect.gameAA(91, this.cFocus, 2);
                                       break label1061;
                                    }

                                    if (this.getTemplate().mobTemplateId != 140 && this.getTemplate().mobTemplateId != 161) {
                                       if (this.getTemplate().mobTemplateId != 141 && this.getTemplate().mobTemplateId != 162) {
                                          if (this.getTemplate().mobTemplateId != 144 && this.getTemplate().mobTemplateId != 163) {
                                             if (this.getTemplate().mobTemplateId == 160) {
                                                if (this.cFocus.cx > this.x) {
                                                   ServerEffect.gameAA(123, this.x + this.gameAK / 2, this.y - 5, 1);
                                                } else {
                                                   ServerEffect.gameAA(123, this.x - this.gameAK / 2, this.y - 5, 1, (byte)-1);
                                                }

                                                ServerEffect.gameAA(91, this.cFocus, 1);
                                                break label1061;
                                             }

                                             if (this.getTemplate().mobTemplateId != 164 && this.getTemplate().mobTemplateId != 165) {
                                                if (this.getTemplate().mobTemplateId == 167) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(125, this.x + this.gameAK / 2, this.y, 1);
                                                   } else {
                                                      ServerEffect.gameAA(125, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                   }
                                                } else if (this.getTemplate().mobTemplateId == 166) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(108, this.x + this.gameAK / 2, this.y, 1);
                                                   } else {
                                                      ServerEffect.gameAA(108, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                   }
                                                } else if (this.getTemplate().mobTemplateId == 198) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(143, this.x + this.gameAK / 2, this.y, 1);
                                                   } else {
                                                      ServerEffect.gameAA(143, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                   }
                                                } else if (this.getTemplate().mobTemplateId == 199) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(144, this.x + this.gameAK / 2, this.y, 1);
                                                   } else {
                                                      ServerEffect.gameAA(144, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                   }
                                                } else if (this.getTemplate().mobTemplateId == 200) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(142, this.x + this.gameAK / 2, this.y, 1);
                                                   } else {
                                                      ServerEffect.gameAA(142, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                   }
                                                } else if (this.getTemplate().mobTemplateId == 201) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(144, this.x + this.gameAK / 2, this.y, 1);
                                                   } else {
                                                      ServerEffect.gameAA(144, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                   }
                                                } else if (this.getTemplate().mobTemplateId == 203) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(159, this.x + this.gameAK / 2, this.y, 1);
                                                      ServerEffect.gameAA(156, this.cFocus.cx, this.cFocus.cy, 1);
                                                   } else {
                                                      ServerEffect.gameAA(159, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                      ServerEffect.gameAA(156, this.cFocus.cx, this.cFocus.cy, -1);
                                                   }
                                                } else if (this.getTemplate().mobTemplateId == 204) {
                                                   if (this.cFocus.cx > this.x) {
                                                      ServerEffect.gameAA(159, this.x + this.gameAK / 2, this.y, 1);
                                                      ServerEffect.gameAA(173, this.cFocus.cx, this.cFocus.cy, 1);
                                                   } else {
                                                      ServerEffect.gameAA(159, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                                      ServerEffect.gameAA(173, this.cFocus.cx, this.cFocus.cy, -1);
                                                   }
                                                }
                                                break label1061;
                                             }

                                             if (this.cFocus.cx > this.x) {
                                                ServerEffect.gameAA(125, this.x + this.gameAK / 2, this.y, 1);
                                             } else {
                                                ServerEffect.gameAA(125, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                             }

                                             ServerEffect.gameAA(90, this.cFocus, 1);
                                             break label1061;
                                          }

                                          if (this.cFocus == Char.getMyChar()) {
                                             GameScr.gameFU = 1;
                                             GameScr.gameFV = 0;
                                          }

                                          ServerEffect.gameAA(112, this.cFocus, 2);
                                          ServerEffect.gameAA(109, this.cFocus.cx - 40, this.cFocus.cy - 40, 1);
                                          ServerEffect.gameAA(109, this.cFocus.cx + 40, this.cFocus.cy - 40, 1);
                                          ServerEffect.gameAA(109, this.cFocus.cx - 20, this.cFocus.cy, 2);
                                          ServerEffect.gameAA(109, this.cFocus.cx + 20, this.cFocus.cy, 2);
                                          break label1061;
                                       }

                                       if (this.cFocus.cx > this.x) {
                                          ServerEffect.gameAA(108, this.x + this.gameAK / 2, this.y, 1);
                                       } else {
                                          ServerEffect.gameAA(108, this.x - this.gameAK / 2, this.y, 1, (byte)-1);
                                       }

                                       ServerEffect.gameAA(122, this.x, this.y, 1, (byte)this.dir);
                                       ServerEffect.gameAA(91, this.cFocus, 1);
                                       break label1061;
                                    }

                                    if (this.cFocus == Char.getMyChar()) {
                                       GameScr.gameFU = 1;
                                       GameScr.gameFV = 0;
                                    }

                                    ServerEffect.gameAA(112, this.cFocus, 2);
                                    ServerEffect.gameAA(109, this.cFocus.cx - 40, this.cFocus.cy - 40, 1);
                                    ServerEffect.gameAA(109, this.cFocus.cx + 40, this.cFocus.cy - 40, 1);
                                    ServerEffect.gameAA(109, this.cFocus.cx - 20, this.cFocus.cy, 2);
                                    ServerEffect.gameAA(109, this.cFocus.cx + 20, this.cFocus.cy, 2);
                                    break label1061;
                                 }

                                 if (Res.abs(var4 - this.x) >= 24 || Res.abs(var3 - this.y) >= 15) {
                                    if (this.isBoss) {
                                       if (this.getTemplate().mobTemplateId == 210) {
                                          if (this.cFocus.cx > this.x) {
                                             ServerEffect.gameAA(178, this.cFocus.cx, this.cFocus.cy, 1);
                                          } else {
                                             ServerEffect.gameAA(178, this.cFocus.cx, this.cFocus.cy, 1, (byte)-1);
                                          }
                                       } else if (this.getTemplate().mobTemplateId == 209) {
                                          if (this.cFocus.cx > this.x) {
                                             ServerEffect.gameAA(179, this.cFocus.cx, this.cFocus.cy, 1);
                                          } else {
                                             ServerEffect.gameAA(179, this.cFocus.cx, this.cFocus.cy, 1, (byte)-1);
                                          }
                                       } else if (this.getTemplate().mobTemplateId != 114 && this.getTemplate().mobTemplateId != 115) {
                                          if (this.getTemplate().mobTemplateId == 116) {
                                             ServerEffect.gameAA(84, this.cFocus, 2);
                                             this.isBusyAttackSomeOne = false;
                                             this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                          } else if (this.getTemplate().mobTemplateId == 138) {
                                             if (this.cFocus == Char.getMyChar()) {
                                                GameScr.gameFU = 1;
                                                GameScr.gameFV = 0;
                                             }

                                             ServerEffect.gameAA(83, this.cFocus, 2);
                                             this.isBusyAttackSomeOne = false;
                                             this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                          } else if (this.getTemplate().mobTemplateId == 139) {
                                             MonsterDart.gameAA(this.x + (this.dir - 1) * 30, this.y - 30, this.isBoss, this.levelBoss, this.getTemplate().mobTemplateId, this.dame, this.dameMp, this.cFocus);
                                          } else if (this.getTemplate().mobTemplateId != 140 && this.getTemplate().mobTemplateId != 161) {
                                             if (this.getTemplate().mobTemplateId != 141 && this.getTemplate().mobTemplateId != 162) {
                                                if (this.getTemplate().mobTemplateId != 144 && this.getTemplate().mobTemplateId != 163) {
                                                   if (this.getTemplate().mobTemplateId == 160) {
                                                      ServerEffect.gameAA(124, this.cFocus, 2);
                                                      this.isBusyAttackSomeOne = false;
                                                      this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                   } else if (this.getTemplate().mobTemplateId != 164 && this.getTemplate().mobTemplateId != 165) {
                                                      if (this.getTemplate().mobTemplateId == 167) {
                                                         ServerEffect.gameAA(112, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(112, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(112, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      } else if (this.getTemplate().mobTemplateId == 166) {
                                                         ServerEffect.gameAA(92, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(92, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(92, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      } else if (this.getTemplate().mobTemplateId == 198) {
                                                         ServerEffect.gameAA(142, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(142, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(142, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      } else if (this.getTemplate().mobTemplateId == 199) {
                                                         ServerEffect.gameAA(143, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(143, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(143, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      } else if (this.getTemplate().mobTemplateId == 200) {
                                                         ServerEffect.gameAA(144, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(144, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(144, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      } else if (this.getTemplate().mobTemplateId == 201) {
                                                         ServerEffect.gameAA(108, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(108, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(108, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      } else if (this.getTemplate().mobTemplateId == 203) {
                                                         ServerEffect.gameAA(149, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(149, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(149, this.cFocus, 1);
                                                         ServerEffect.gameAA(156, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      } else if (this.getTemplate().mobTemplateId == 204) {
                                                         ServerEffect.gameAA(153, this.cFocus.cx + 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(153, this.cFocus.cx - 5, this.cFocus.cy, 1);
                                                         ServerEffect.gameAA(153, this.cFocus, 1);
                                                         ServerEffect.gameAA(173, this.cFocus, 1);
                                                         this.isBusyAttackSomeOne = false;
                                                         this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                      }
                                                   } else {
                                                      ServerEffect.gameAA(126, this.cFocus, 1);
                                                      this.isBusyAttackSomeOne = false;
                                                      this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                                   }
                                                } else {
                                                   MonsterDart.gameAA(this.x + (this.dir - 1) * 15, this.y - 20, this.isBoss, this.levelBoss, this.getTemplate().mobTemplateId, this.dame, this.dameMp, this.cFocus);
                                                }
                                             } else {
                                                if (this.cFocus == Char.getMyChar()) {
                                                   GameScr.gameFU = 1;
                                                   GameScr.gameFV = 0;
                                                }

                                                ServerEffect.gameAA(121, this.cFocus, 1);
                                                this.isBusyAttackSomeOne = false;
                                                this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                             }
                                          } else {
                                             if (this.cFocus == Char.getMyChar()) {
                                                GameScr.gameFU = 1;
                                                GameScr.gameFV = 0;
                                             }

                                             ServerEffect.gameAA(110, this.cFocus, 2);
                                             ServerEffect.gameAA(104, this.cFocus.cx - 20, this.cFocus.cy, 2);
                                             ServerEffect.gameAA(104, this.cFocus.cx + 20, this.cFocus.cy, 2);
                                             this.isBusyAttackSomeOne = false;
                                             this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                                          }
                                       } else {
                                          MonsterDart.gameAA(this.x + (this.dir - 1) * 15, this.y - 20, this.isBoss, this.levelBoss, this.getTemplate().mobTemplateId, this.dame, this.dameMp, this.cFocus);
                                       }
                                    } else {
                                       MonsterDart.gameAA(this.x - 5, this.y + this.dir * 10, this.isBoss, this.level, this.getTemplate().mobTemplateId, this.dame, this.dameMp, this.cFocus);
                                    }

                                    this.isBusyAttackSomeOne = false;
                                    break label1061;
                                 }

                                 this.cFocus.gameAA(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                              } else {
                                 if (this.gameBN != 1) {
                                    break label1061;
                                 }

                                 if (Res.abs(var4 - this.x) < 24 && Res.abs(var3 - this.y) < 15) {
                                    this.bFocus.gameAD = true;
                                 } else if (this.isBoss) {
                                    MonsterDart.gameAA(this.x - 5, this.y + this.dir * 10 - 20, this.bFocus);
                                 } else {
                                    MonsterDart.gameAA(this.x - 5, this.y + this.dir * 10, this.bFocus);
                                 }
                              }

                              this.isBusyAttackSomeOne = false;
                           }
                        }

                        this.dir = this.x < var4 ? 1 : -1;
                     } else if (this.p1 == 1) {
                        if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && !this.isIce && !this.isWind) {
                           this.x += (this.xFirst - this.x) / 4;
                           this.y += (this.yFirst - this.y) / 4;
                        }

                        if (Res.abs(this.xFirst - this.x) < 5 && Res.abs(this.yFirst - this.y) < 5) {
                           this.status = 2;
                           this.p1 = 0;
                           this.p2 = 0;
                        }
                     }
                  } else if (this.p1 == 0) {
                     var4 = this.cFocus.cx;
                     var3 = this.cFocus.cy;
                     this.gameBN = this.gameBX;
                     this.dir = this.x >= var4 ? 0 : 1;
                     if (this.isBoss) {
                        ++this.gameBP;
                        if (this.gameBP >= arrMobTemplate[this.templateId].frameBossAttack[this.gameBN].length) {
                           this.gameBP = 0;
                           this.status = 2;
                           this.gameBU = null;
                           this.gameBV = null;
                           this.p1 = 0;
                           this.p2 = 0;
                        }

                        if (this.gameBP == arrMobTemplate[this.templateId].frameBossAttack[this.gameBN].length - 1) {
                           if (this.gameBY == 0) {
                              ServerEffect.gameAA(this.gameBW, var4, var3, 1, (byte)(this.dir == 0 ? -1 : 1));
                           } else if (this.gameBY == 1 && this.gameBW >= 0) {
                              EffectAuto.gameAA(this.gameBW, var4, var3, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
                           }
                        }

                        this.frame = arrMobTemplate[this.templateId].frameBossAttack[this.gameBX][this.gameBP];
                     } else {
                        ServerEffect.gameAA(this.gameBW, var4, var3, 1, (byte)(this.dir == 0 ? -1 : 1));
                     }

                     if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && this.isIce && this.isWind) {
                        this.x += (var4 - this.x) / 3;
                     }

                     if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                        this.p1 = 1;
                     }

                     if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                        this.p1 = 1;
                     }
                  } else if (this.p1 == 1) {
                     if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && !this.isIce && !this.isWind) {
                        this.x += (this.xFirst - this.x) / 4;
                        this.y += (this.yFirst - this.y) / 4;
                     }

                     if (Res.abs(this.xFirst - this.x) < 5 && Res.abs(this.yFirst - this.y) < 5) {
                        this.status = 2;
                        this.gameBP = 0;
                        this.p1 = 0;
                        this.p2 = 0;
                     }
                  }
               } else {
                  this.gameAK();
               }
               break;
            case 4:
               this.timeStatus = 0;
               this.frame = 0;
               ++this.p1;
               if (this.p1 > 40 + this.mobId % 5) {
                  this.y -= 2;
                  this.status = 5;
                  this.p1 = 0;
               }
               break;
            case 5:
               try {
                  if (GameCanvas.gameTick % 4 == 0 && this.isBoss) {
                     ++this.gameBP;
                     if (this.gameBP > arrMobTemplate[this.templateId].frameBossMove.length - 1) {
                        this.gameBP = 0;
                     }
                  }
               } catch (Exception var5) {
               }

               this.timeStatus = 0;
               this.gameAI();
               break;
            case 6:
               this.timeStatus = 0;
               ++this.p1;
               this.y += this.p1;
               if (this.y >= this.yFirst) {
                  this.y = this.yFirst;
                  this.p1 = 0;
                  this.status = 5;
               }
               break;
            case 7:
               this.gameAH();
               break;
            case 8:
               this.frame = 0;
               break;
            case 9:
               var3 = GameCanvas.gameTick % idframeDisappear[this.templateId - 168].length;
               this.frame = idframeDisappear[this.templateId - 168][var3];
               if (this.frame == 1) {
                  this.status = 8;
               }
            }

            this.gameAJ();
            if (this.removeWhenDie && this.hp <= 0) {
               GameScr.vMob.removeElement(this);
               if (this.levelBoss > 0) {
                  Auto.gameAB(this);
               }
            }

            this.gameAA((byte)1, this.status);
         }
      }

   }

   public final void gameAB() {
      if (this.hp > 0) {
         this.timeStatus = 4;
         this.status = 7;
      }

   }

   public final void gameAA(Char var1) {
      label78: {
         this.isBusyAttackSomeOne = true;
         this.cFocus = var1;
         this.p1 = 0;
         this.p2 = 0;
         this.status = 3;
         if (this.templateId != 209 && this.templateId != 210) {
            label77: {
               if (this.templateId != 168 && this.templateId != 176 && this.templateId != 177 && this.templateId != 179) {
                  if (this.templateId != 169 && this.templateId != 171 && this.templateId != 172 && this.templateId != 182) {
                     if (this.templateId == 175) {
                        this.gameBP = 7;
                        break label78;
                     }

                     if (this.templateId != 181 && this.templateId != 185 && this.templateId != 188 && this.templateId != 194 && this.templateId != 192) {
                        if (this.templateId != 183 && this.templateId != 170 && this.templateId != 193) {
                           if (this.templateId != 187 && this.templateId != 168 && this.templateId != 175 && this.templateId != 176 && this.templateId != 179 && this.templateId != 174) {
                              break label77;
                           }

                           this.gameBP = this.gameAD(GameCanvas.gameTick);
                           break label78;
                        }

                        this.gameBP = 4;
                        break label78;
                     }

                     this.gameBP = 3;
                     break label78;
                  }

                  this.gameBP = 2;
                  break label78;
               }

               this.gameBP = 6;
               break label78;
            }
         }

         this.gameBP = 0;
      }

      this.gameBN = 0;
   }

   public final void gameAA(BuNhin var1) {
      this.bFocus = var1;
      this.p1 = 0;
      this.p2 = 0;
      this.status = 3;
      this.gameBN = 1;
   }

   private void gameAH() {
      if (!Code.gameBE) {
         this.frame = this.isBoss ? (this.getTemplate().mobTemplateId == 204 ? 9 : (this.getTemplate().mobTemplateId == 203 ? 9 : (this.getTemplate().mobTemplateId == 139 ? 4 : (this.getTemplate().mobTemplateId == 160 ? 12 : 10)))) : 2;
         if (this.getTemplate().mobTemplateId != 209 && this.getTemplate().mobTemplateId != 210) {
            if (this.getTemplate().mobTemplateId == 141) {
               this.frame = 13;
            } else if (this.getTemplate().mobTemplateId != 169 && this.getTemplate().mobTemplateId != 170 && this.getTemplate().mobTemplateId != 171 && this.getTemplate().mobTemplateId != 172 && this.getTemplate().mobTemplateId != 182) {
               if (this.getTemplate().mobTemplateId != 168 && this.getTemplate().mobTemplateId != 176 && this.getTemplate().mobTemplateId != 177 && this.getTemplate().mobTemplateId != 179 && this.getTemplate().mobTemplateId != 180) {
                  if (this.getTemplate().mobTemplateId != 173 && this.getTemplate().mobTemplateId != 184) {
                     if (this.getTemplate().mobTemplateId != 181 && this.getTemplate().mobTemplateId != 178 && this.getTemplate().mobTemplateId != 185 && this.getTemplate().mobTemplateId != 202) {
                        if (this.getTemplate().mobTemplateId == 174) {
                           this.frame = 10;
                        } else if (this.getTemplate().mobTemplateId == 183) {
                           this.frame = 5;
                        } else if (this.getTemplate().mobTemplateId == 175) {
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

         --this.timeStatus;
         if (this.timeStatus > 0) {
            if (arrMobTemplate[this.templateId].type != 0) {
               int var1 = -this.gameBC.cdir << 1;
               if (this.x > this.xFirst - arrMobTemplate[this.templateId].rangeMove && this.x < this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                  this.x -= var1;
                  return;
               }

               return;
            }
         } else {
            if ((this.gameBC == null || !this.gameBD) && this.hp != 0) {
               this.status = 5;
               if (this.gameBC != null) {
                  this.dir = -this.gameBC.cdir;
                  if (Res.abs(this.x - this.gameBC.cx) < 24) {
                     this.status = 2;
                  }
               }

               this.p1 = this.p2 = this.p3 = 0;
               this.timeStatus = 0;
            } else {
               this.status = 1;
               this.p2 = this.gameBC.cdir << 3;
               this.p1 = -5;
               this.p3 = 0;
            }

            this.gameBC = null;
         }
      }

   }

   private void gameAI() {
      try {
         if (!Code.gameBE) {
            if (this.gameBD) {
               this.status = 1;
               this.p2 = this.gameBC.cdir << 3;
               this.p1 = -5;
               this.p3 = 0;
            }

            if (!this.isIce) {
               if (!this.isDontMove && !this.isWind) {
                  byte var1;
                  switch(arrMobTemplate[this.templateId].type) {
                  case 0:
                     if (this.templateId == 176) {
                        this.status = 9;
                     }

                     this.frame = 0;
                     return;
                  case 1:
                  case 2:
                  case 3:
                     var1 = arrMobTemplate[this.templateId].speed;
                     if (arrMobTemplate[this.templateId].speed == 1) {
                        if (GameCanvas.gameTick % 2 == 1) {
                           return;
                        }
                     } else if (var1 > 2) {
                        var1 = (byte)(var1 + this.mobId % 2);
                     } else if (GameCanvas.gameTick % 2 == 1) {
                        --var1;
                     }

                     this.x += var1 * this.dir;
                     if (Res.gameAB(0, arrMobTemplate[this.templateId].rangeMove) == arrMobTemplate[this.templateId].rangeMove / 3) {
                        this.status = 2;
                        this.gameBT = System.currentTimeMillis();
                     }

                     if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = -1;
                        if (this.templateId == 168 || this.templateId == 177) {
                           this.status = 9;
                           this.p1 = 0;
                        }
                     } else if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = 1;
                        if (this.templateId == 168 || this.templateId == 177) {
                           this.status = 9;
                           this.p1 = 0;
                        }
                     }

                     if (!this.isBoss) {
                        if (this.templateId < 168) {
                           this.frame = GameCanvas.gameTick % 4 > 1 ? 0 : 1;
                           return;
                        }

                        this.frame = this.gameAC(GameCanvas.gameTick);
                        return;
                     }

                     this.frame = arrMobTemplate[this.templateId].frameBossMove[this.gameBP];
                     return;
                  case 4:
                     var1 = (byte)(arrMobTemplate[this.templateId].speed + this.mobId % 2);
                     this.x += var1 * this.dir;
                     if (GameCanvas.gameTick % 10 > 2 && this.templateId != 205 && this.templateId != 206 && this.templateId != 207 && this.templateId != 208) {
                        this.gameBZ = -1;
                        this.y += var1 * this.dirV;
                     }

                     if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = -1;
                        if (this.templateId == 179 || this.templateId == 175) {
                           this.status = 9;
                        }

                        this.p1 = 0;
                     } else if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = 1;
                        if (this.templateId == 179 || this.templateId == 175) {
                           this.status = 9;
                        }

                        this.p1 = 0;
                     }

                     if (this.y > this.yFirst + 24) {
                        this.dirV = -1;
                     } else if (this.y < this.yFirst - (20 + GameCanvas.gameTick % 10)) {
                        this.dirV = 1;
                     }

                     if (!this.isBoss) {
                        if (this.templateId < 168) {
                           this.frame = GameCanvas.gameTick % 4 > 1 ? 0 : 1;
                           return;
                        }

                        this.frame = this.gameAC(GameCanvas.gameTick);
                        return;
                     }

                     this.frame = arrMobTemplate[this.templateId].frameBossMove[this.gameBP];
                     return;
                  case 5:
                     var1 = (byte)(arrMobTemplate[this.templateId].speed + this.mobId % 2);
                     this.x += var1 * this.dir;
                     var1 = (byte)(var1 + (GameCanvas.gameTick + this.mobId) % 2);
                     if (GameCanvas.gameTick % 10 > 2) {
                        this.y += var1 * this.dirV;
                     }

                     if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = -1;
                        if (this.templateId != 179 && this.templateId != 175) {
                           this.status = 2;
                        } else {
                           this.status = 9;
                        }

                        this.p1 = 0;
                     } else if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = 1;
                        if (this.templateId != 179 && this.templateId != 175) {
                           this.status = 2;
                        } else {
                           this.status = 9;
                        }

                        this.p1 = 0;
                     }

                     if (this.y > this.yFirst + 24) {
                        this.dirV = -1;
                     } else if (this.y < this.yFirst - (20 + GameCanvas.gameTick % 10)) {
                        this.dirV = 1;
                     }

                     if (TileMap.gameAA(this.x, this.y, 2)) {
                        if (GameCanvas.gameTick % 10 > 5) {
                           this.y = TileMap.gameAB(this.y);
                           this.status = 4;
                           this.p1 = 0;
                        }

                        this.dirV = -1;
                     }

                     if (!this.isBoss) {
                        if (this.templateId < 168) {
                           this.frame = GameCanvas.gameTick % 4 > 1 ? 3 : 1;
                           return;
                        }

                        this.frame = this.gameAC(GameCanvas.gameTick);
                        return;
                     } else {
                        this.frame = arrMobTemplate[this.templateId].frameBossMove[this.gameBP];
                     }
                  default:
                  }
               } else {
                  this.frame = 0;
               }
            }
         }
      } catch (Exception var2) {
      }
   }

   public final MobTemplate getTemplate() {
      return arrMobTemplate[this.templateId];
   }

   public final boolean gameAD() {
      if (this.x < GameScr.cmx) {
         return false;
      } else if (this.x > GameScr.cmx + GameScr.gW) {
         return false;
      } else if (this.y < GameScr.cmy) {
         return false;
      } else if (this.y > GameScr.cmy + GameScr.gH + 30) {
         return false;
      } else if (arrMobTemplate[this.templateId] == null) {
         return false;
      } else {
         if (!this.isBoss) {
            if (this.frame >= arrMobTemplate[this.templateId].imgs.length) {
               return false;
            }

            if (arrMobTemplate[this.templateId].imgs[this.frame] == null) {
               return false;
            }

            if (this.templateId != 179 && this.templateId != 175 && this.templateId != 202) {
               if (this.templateId == 176 && (this.frame == 1 || this.frame == 0)) {
                  return false;
               }
            } else if (this.status == 8) {
               return false;
            }
         }

         return this.status != 0;
      }
   }

   public final void gameAA(mGraphics var1) {
      if (this.gameAD()) {
         int var2 = this.y;
         if (this.templateId == 205 || this.templateId == 206 || this.templateId == 207 || this.templateId == 208) {
            ++this.gameBZ;
            if (this.gameBZ > Char.locate.length - 1) {
               this.gameBZ = 0;
            }
         }

         if (this.gameBZ >= 0) {
            var2 += Char.locate[this.gameBZ];
         }

         MobTemplate var3 = arrMobTemplate[this.templateId];
         if (!this.isBoss) {
            if (this.gameAK == 0) {
               this.gameAK = mGraphics.gameAA(var3.imgs[0]);
            }

            if (this.gameAL == 0) {
               this.gameAL = mGraphics.gameAB(var3.imgs[0]);
            }
         } else {
            this.gameAK = 40;
            this.gameAL = 40;
         }

         this.gameAB(var1, this.x, var2);

         int var4;
         int var9;
         try {
            var4 = this.dir > 0 ? 0 : 2;
            if (this.templateId == 219) {
               var4 = 0;
            }

            if ((this.templateId == 98 || this.templateId == 99) && this.status == 1) {
               long var12;
               if ((var12 = System.currentTimeMillis()) - this.timeStartDie < 400L) {
                  var1.gameAA(var3.imgs[this.frame], 0, 0, mGraphics.gameAA(var3.imgs[this.frame]), mGraphics.gameAB(var3.imgs[this.frame]), var4, this.x, var2, StaticObj.gameAD);
               } else if (var12 - this.timeStartDie < 800L) {
                  var1.gameAA(var3.imgs[this.frame], 0, 0, mGraphics.gameAA(var3.imgs[this.frame]), 3 * mGraphics.gameAB(var3.imgs[this.frame]) / 5, var4, this.x, var2, StaticObj.gameAD);
               } else if (var12 - this.timeStartDie < 1200L) {
                  var1.gameAA(var3.imgs[this.frame], 0, 0, mGraphics.gameAA(var3.imgs[this.frame]), mGraphics.gameAB(var3.imgs[this.frame]) / 3, var4, this.x, var2, StaticObj.gameAD);
               }

               if (GameCanvas.gameTick % 8 < 2) {
                  SmallImage.gameAB(var1, 457, this.x, var2, 0, StaticObj.gameAD);
               } else if (GameCanvas.gameTick % 8 < 4) {
                  SmallImage.gameAB(var1, 458, this.x, var2, 0, StaticObj.gameAD);
               } else if (GameCanvas.gameTick % 8 < 6) {
                  SmallImage.gameAB(var1, 459, this.x, var2, 0, StaticObj.gameAD);
               }
            } else if (this.isBoss) {
               if (this.getTemplate().frameBoss != null) {
                  Frame var6 = this.getTemplate().frameBoss[this.frame];

                  for(var9 = 0; var9 < var6.dx.length; ++var9) {
                     MobTemplate var7 = this.getTemplate();
                     byte var5 = var6.idImg[var9];
                     ImageInfo var10 = var7.imginfo[var5];
                     if (this.dir > 0) {
                        var1.gameAA(this.getTemplate().imgs[0], var10.x0, var10.y0, var10.w, var10.h, 0, this.x + var6.dx[var9], var2 + var6.dy[var9] - 1, 20);
                     } else {
                        var1.gameAA(this.getTemplate().imgs[0], var10.x0, var10.y0, var10.w, var10.h, 2, this.x - var6.dx[var9], var2 + var6.dy[var9] - 1, 24);
                     }
                  }
               }
            } else {
               var1.gameAA(var3.imgs[this.frame], 0, 0, mGraphics.gameAA(var3.imgs[this.frame]), mGraphics.gameAB(var3.imgs[this.frame]), var4, this.x, var2, StaticObj.gameAD);
            }

            this.gameAA(var1, this.x, var2);
         } catch (Exception var8) {
            var8.printStackTrace();
         }

         var4 = var2;
         int var13;
         if (Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.equals(this) && this.status != 1) {
            byte var11;
            int var14;
            if (this.isBoss) {
               var13 = this.maxHp;
               if (this.maxHp < this.hp) {
                  var13 = this.hp;
               }

               var9 = (int)((long)this.hp * 100L / (long)var13);
               var14 = this.gameAK;
               var11 = 4;
               if (this.levelBoss == 1 || this.levelBoss == 2 || this.levelBoss == 3 || this.isBoss) {
                  var11 = 6;
                  var14 += var14 / 2;
               }

               var14 += 2;
               if ((var9 = var14 * var9 / 100) < 2) {
                  var9 = 2;
               }

               if (this.templateId == 140 || this.templateId == 160) {
                  var4 = var2 - 20;
               }

               if (this.templateId != 142 && this.templateId != 143) {
                  var1.gameAA(16777215);
                  var1.gameAD(this.x - var14 / 2 - 1, var4 - this.gameAL - 12, var14, var11);
                  var1.gameAA(this.gameAE());
                  var1.gameAD(this.x - var14 / 2 - 1, var4 - this.gameAL - 12, var9, var11);
                  var1.gameAA(0);
                  var1.gameAC(this.x - var14 / 2 - 1, var4 - this.gameAL - 12, var14, var11);
               } else {
                  SmallImage.gameAB(var1, 988, this.x, var4 - this.gameAL, 0, 33);
               }
            } else {
               var13 = this.maxHp;
               if (this.maxHp < this.hp) {
                  var13 = this.hp;
               }

               var9 = (int)((long)this.hp * 100L / (long)var13);
               var14 = this.gameAK;
               if (this.templateId > 167) {
                  var14 = this.gameAK / 2;
               }

               var11 = 4;
               if (this.levelBoss == 1 || this.levelBoss == 2 || this.levelBoss == 3 || this.isBoss) {
                  var11 = 6;
                  var14 += var14 / 2;
               }

               var14 += 2;
               if ((var9 = var14 * var9 / 100) < 2) {
                  var9 = 2;
               }

               if (this.templateId == 140 || this.templateId == 160) {
                  var4 = var2 - 20;
               }

               if (this.templateId != 142 && this.templateId != 143) {
                  var1.gameAA(16777215);
                  var1.gameAD(this.x - var14 / 2 - 1, var4 - this.gameAL - 12, var14, var11);
                  var1.gameAA(this.gameAE());
                  var1.gameAD(this.x - var14 / 2 - 1, var4 - this.gameAL - 12, var9, var11);
                  var1.gameAA(0);
                  var1.gameAC(this.x - var14 / 2 - 1, var4 - this.gameAL - 12, var14, var11);
               } else {
                  SmallImage.gameAB(var1, 988, this.x, var4 - this.gameAL, 0, 33);
               }
            }

            if (this.levelBoss > 0) {
               if (this.levelBoss == 1) {
                  mFont.tahoma_7_yellow.gameAA(var1, mResources.gameNE[this.levelBoss], this.x, var4 - this.gameAL - 26, 2, mFont.tahoma_7_grey);
               } else if (this.levelBoss == 2) {
                  mFont.tahoma_7_yellow.gameAA(var1, mResources.gameNE[this.levelBoss], this.x, var4 - this.gameAL - 26, 2, mFont.tahoma_7_grey);
               } else if (this.levelBoss == 3) {
                  mFont.tahoma_7_blue1.gameAA(var1, mResources.gameNE[this.levelBoss], this.x, var4 - this.gameAL - 26, 2, mFont.tahoma_7_grey);
               }

               if (this.isDisable) {
                  SmallImage.gameAB(var1, 494, this.x, var4 - this.gameAL - 28, 0, 33);
               }
            } else if (this.isDisable) {
               SmallImage.gameAB(var1, 494, this.x, var4 - this.gameAL - 15, 0, 33);
            }
         } else if (this.levelBoss > 0) {
            if (this.levelBoss == 1) {
               mFont.tahoma_7_yellow.gameAA(var1, mResources.gameNE[this.levelBoss], this.x, var2 - this.gameAL - 20, 2, mFont.tahoma_7_grey);
            } else if (this.levelBoss == 2) {
               mFont.tahoma_7_yellow.gameAA(var1, mResources.gameNE[this.levelBoss], this.x, var2 - this.gameAL - 20, 2, mFont.tahoma_7_grey);
            } else if (this.levelBoss == 3) {
               mFont.tahoma_7_blue1.gameAA(var1, mResources.gameNE[this.levelBoss], this.x, var2 - this.gameAL - 20, 2, mFont.tahoma_7_grey);
            }

            if (this.isDisable) {
               SmallImage.gameAB(var1, 494, this.x, var2 - this.gameAL - 22, 0, 33);
            }
         } else if (this.isDisable) {
            SmallImage.gameAB(var1, 494, this.x, var2 - this.gameAL - 5, 0, 33);
         }

         if (this.isDontMove) {
            if (GameCanvas.gameTick % 2 == 0) {
               SmallImage.gameAB(var1, 1082, this.x, var2 - this.gameAL / 2, 0, 3);
            } else {
               SmallImage.gameAB(var1, 1084, this.x, var2 - this.gameAL / 2, 0, 3);
            }
         }

         if (this.isIce) {
            SmallImage.gameAB(var1, 290, this.x, var2, 0, 33);
         }

         if (this.isWind) {
            if ((var13 = GameCanvas.gameTick % 6) != 0 && var13 != 1) {
               if (var13 != 2 && var13 != 3) {
                  if (var13 == 4 || var13 == 5) {
                     SmallImage.gameAB(var1, 1000, this.x, var2 - this.gameAL - 5, 0, 3);
                  }
               } else {
                  SmallImage.gameAB(var1, 999, this.x, var2 - this.gameAL - 5, 0, 3);
               }
            } else {
               SmallImage.gameAB(var1, 998, this.x, var2 - this.gameAL - 5, 0, 3);
            }
         }

         if (this.isFire) {
            if ((var13 = GameCanvas.gameTick % 16) == 0) {
               SmallImage.gameAB(var1, 1013, this.x - this.gameAK / 2, var2 - this.gameAL + this.gameAL / 4, 0, 3);
               return;
            }

            if (var13 == 1) {
               SmallImage.gameAB(var1, 1014, this.x - this.gameAK / 2, var2 - this.gameAL + this.gameAL / 4, 0, 3);
               return;
            }

            if (var13 == 2) {
               SmallImage.gameAB(var1, 1015, this.x - this.gameAK / 2, var2 - this.gameAL + this.gameAL / 4, 0, 3);
               return;
            }

            if (var13 == 3) {
               SmallImage.gameAB(var1, 1016, this.x - this.gameAK / 2, var2 - this.gameAL + this.gameAL / 4, 0, 3);
               return;
            }

            if (var13 == 4) {
               SmallImage.gameAB(var1, 1013, this.x + this.gameAK / 2, var2 - this.gameAL, 0, 3);
               return;
            }

            if (var13 == 5) {
               SmallImage.gameAB(var1, 1014, this.x + this.gameAK / 2, var2 - this.gameAL, 0, 3);
               return;
            }

            if (var13 == 6) {
               SmallImage.gameAB(var1, 1015, this.x + this.gameAK / 2, var2 - this.gameAL, 0, 3);
               return;
            }

            if (var13 == 7) {
               SmallImage.gameAB(var1, 1016, this.x + this.gameAK / 2, var2 - this.gameAL, 0, 3);
               return;
            }

            if (var13 == 8) {
               SmallImage.gameAB(var1, 1013, this.x - this.gameAK / 2, var2, 0, 3);
               return;
            }

            if (var13 == 9) {
               SmallImage.gameAB(var1, 1014, this.x - this.gameAK / 2, var2, 0, 3);
               return;
            }

            if (var13 == 10) {
               SmallImage.gameAB(var1, 1015, this.x - this.gameAK / 2, var2, 0, 3);
               return;
            }

            if (var13 == 11) {
               SmallImage.gameAB(var1, 1016, this.x - this.gameAK / 2, var2, 0, 3);
               return;
            }

            if (var13 == 12) {
               SmallImage.gameAB(var1, 1013, this.x + this.gameAK / 2, var2 - this.gameAL / 4, 0, 3);
               return;
            }

            if (var13 == 13) {
               SmallImage.gameAB(var1, 1014, this.x + this.gameAK / 2, var2 - this.gameAL / 4, 0, 3);
               return;
            }

            if (var13 == 14) {
               SmallImage.gameAB(var1, 1015, this.x + this.gameAK / 2, var2 - this.gameAL / 4, 0, 3);
               return;
            }

            if (var13 == 15) {
               SmallImage.gameAB(var1, 1016, this.x + this.gameAK / 2, var2 - this.gameAL / 4, 0, 3);
            }
         }
      }

   }

   public final int gameAE() {
      if (this.sys > 1) {
         if (this.sys == 2) {
            return 33023;
         }

         if (this.sys == 3) {
            return 7443811;
         }
      }

      return 16711680;
   }

   public final void gameAF() {
      this.hp = 0;
      this.timeStartDie = System.currentTimeMillis();
      if (this.gameBC != null) {
         this.gameBD = true;
      } else {
         this.gameBD = true;
         this.hp = 0;
         this.status = 1;
         this.p1 = -5;
         this.p2 = -this.dir << 2;
         this.p3 = 0;
      }
   }

   public final void gameAA(Mob var1) {
      this.gameBU = var1;
   }

   public final void gameAB(Char var1) {
      this.gameBV = var1;
   }

   private void gameAJ() {
      int var1;
      int var2;
      if (this.gameBU != null) {
         if (this.isBoss) {
            this.status = 3;
         } else {
            var1 = this.gameBU.x - this.x;
            var2 = this.gameBU.y - this.y;
            this.x += var1 / 4;
            this.y += var2 / 4;
            this.dir = this.x >= this.gameBU.x ? 0 : 1;
            if (this.gameBU.status == 1 || this.gameBU.status == 0 || Res.abs(var1) < 20 && Res.abs(var2) < 20) {
               if (this.gameBY == 0) {
                  ServerEffect.gameAA(this.gameBW == -1 ? 59 : this.gameBW, this.gameBU.x, this.gameBU.y, this.dir == 0 ? -1 : 1);
               } else if (this.gameBY == 1 && this.gameBW >= 0) {
                  EffectAuto.gameAA(this.gameBW, this.gameBU.x, this.gameBU.y, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
               }

               this.gameBU = null;
            }
         }
      }

      if (this.gameBV != null) {
         if (this.isBoss) {
            this.status = 3;
            return;
         }

         var1 = this.gameBV.cx - this.x;
         var2 = this.gameBV.cy - this.y;
         this.x += var1 / 4;
         this.y += var2 / 4;
         this.dir = this.x >= this.gameBV.cx ? 0 : 1;
         if (this.gameBV.statusMe == 5 || this.gameBV.statusMe == 14 || Res.abs(var1) < 20 && Res.abs(var2) < 20) {
            if (this.gameBY == 0) {
               ServerEffect.gameAA(this.gameBW == -1 ? 59 : this.gameBW, this.gameBV.cx, this.gameBV.cy, this.dir == 0 ? -1 : 1);
            } else if (this.gameBY == 1 && this.gameBW >= 0) {
               EffectAuto.gameAA(this.gameBW, this.gameBV.cx, this.gameBV.cy, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
            }

            this.gameBV = null;
         }
      }

   }

   public final void gameAA(short var1, byte var2, byte var3) {
      this.gameBW = var1;
      this.gameBX = var2;
      this.gameBY = var3;
   }

   public final void gameAG() {
      if (this.templateId == 116) {
         ServerEffect.gameAA(84, Char.getMyChar(), 1);
      } else if (this.templateId == 115) {
         ServerEffect.gameAA(81, Char.getMyChar(), 1);
      } else if (this.templateId == 138) {
         ServerEffect.gameAA(90, Char.getMyChar(), 1);
      } else if (this.templateId == 139) {
         ServerEffect.gameAA(91, Char.getMyChar(), 1);
      } else {
         if (this.templateId != 140 && this.templateId != 161) {
            if (this.templateId == 141 || this.templateId == 162) {
               ServerEffect.gameAA(121, Char.getMyChar(), 1);
               return;
            }

            if (this.templateId == 144 || this.templateId == 163) {
               ServerEffect.gameAA(121, Char.getMyChar(), 1);
               return;
            }

            if (this.templateId == 160) {
               ServerEffect.gameAA(124, Char.getMyChar(), 1);
               return;
            }

            if (this.templateId == 164 || this.templateId == 165) {
               ServerEffect.gameAA(126, this.cFocus, 1);
               return;
            }

            if (this.templateId == 166) {
               ServerEffect.gameAA(103, this.cFocus, 1);
               return;
            }

            if (this.templateId == 166) {
               ServerEffect.gameAA(105, this.cFocus, 1);
               return;
            }
         } else {
            ServerEffect.gameAA(110, Char.getMyChar(), 2);
         }

      }
   }

   private int gameAC(int var1) {
      var1 %= idframe[this.templateId - 168].length;
      return this.templateId != 198 && this.templateId != 199 && this.templateId != 200 && this.templateId != 201 && this.templateId != 203 && this.templateId != 204 ? idframe[this.templateId - 168][var1] : 0;
   }

   private int gameAD(int var1) {
      var1 %= 5;
      switch(this.templateId) {
      case 168:
         switch(var1) {
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
      case 169:
      case 170:
      case 171:
      case 172:
      case 173:
      default:
         break;
      case 174:
         switch(var1) {
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
         default:
            return 0;
         }
      case 175:
         switch(var1) {
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
         default:
            return 0;
         }
      case 176:
         switch(var1) {
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
         default:
            return 0;
         }
      case 177:
         switch(var1) {
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
         default:
            return 0;
         }
      case 178:
         switch(var1) {
         case 0:
            return 5;
         case 1:
            return 6;
         case 2:
            return 7;
         case 3:
            return 8;
         default:
            return 0;
         }
      case 179:
         switch(var1) {
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
      }

      return 0;
   }

   private void gameAK() {
      if (this.p1 == 0) {
         int var1 = 0;
         int var2 = 0;
         if (this.gameBU != null) {
            var1 = this.gameBU.x;
            var2 = this.gameBU.y;
         }

         if (this.gameBV != null) {
            var1 = this.gameBV.cx;
            var2 = this.gameBV.cy;
         }

         this.gameBN = this.gameBX;
         this.dir = this.x >= var1 ? 0 : 1;
         if (this.isBoss) {
            ++this.gameBP;
            if (this.gameBP >= arrMobTemplate[this.templateId].frameBossAttack[this.gameBN].length) {
               this.gameBP = 0;
               this.status = 2;
               this.gameBU = null;
               this.gameBV = null;
               this.p1 = 0;
               this.p2 = 0;
            }

            if (this.gameBP == arrMobTemplate[this.templateId].frameBossAttack[this.gameBN].length - 2) {
               if (this.gameBY == 0) {
                  ServerEffect.gameAA(this.gameBW == -1 ? 59 : this.gameBW, var1, var2, 1, (byte)(this.dir == 0 ? -1 : 1));
               } else if (this.gameBY == 1 && this.gameBW >= 0) {
                  EffectAuto.gameAA(this.gameBW, var1, var2, (byte)1, (short)-1, this.dir == 0 ? -1 : 1);
               }
            }

            this.frame = arrMobTemplate[this.templateId].frameBossAttack[this.gameBX][this.gameBP];
         }

         if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && this.isIce && this.isWind) {
            this.x += (var1 - this.x) / 3;
         }

         if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
            this.p1 = 1;
         }

         if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
            this.p1 = 1;
         }
      } else {
         if (this.p1 == 1) {
            if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && !this.isIce && !this.isWind) {
               this.x += (this.xFirst - this.x) / 4;
               this.y += (this.yFirst - this.y) / 4;
            }

            if (Res.abs(this.xFirst - this.x) < 5 && Res.abs(this.yFirst - this.y) < 5) {
               this.status = 2;
               this.gameBP = 0;
               this.p1 = 0;
               this.p2 = 0;
            }
         }

      }
   }

   public static Mob gameAA(int var0) {
      for(int var1 = GameScr.vMob.size() - 1; var1 >= 0; --var1) {
         Mob var2;
         if ((var2 = (Mob)GameScr.vMob.elementAt(var1)) != null && var2.mobId == var0) {
            return var2;
         }
      }

      return null;
   }

   public static Mob gameAB(int var0) {
      for(int var1 = GameScr.vMob.size() - 1; var1 >= 0; --var1) {
         Mob var2;
         if ((var2 = (Mob)GameScr.vMob.elementAt(var1)) != null && var2.level == var0 && !var2.isBoss) {
            return var2;
         }
      }

      return null;
   }
}
