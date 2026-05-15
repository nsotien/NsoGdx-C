import java.util.Calendar;

public final class Stanima extends Auto {
   private boolean gameBA;
   private boolean gameBB;
   private int gameBC;
   private boolean gameBD;
   public int gameAV;
   private int gameBE;
   private int gameBF;
   private boolean gameBG;
   private int gameBH;
   private long gameBI;
   public int gameAW;
   private long gameBJ;
   public static boolean gameAX;
   public static boolean gameAY;
   public static boolean gameAZ;

   public final void gameAA(int var1, int var2, int var3, boolean var4, boolean var5) {
      super.gameAC();
      super.mapID = var2;
      super.zoneID = var3;
      this.gameAW = var1;
      this.gameBA = var4;
      this.gameBB = var5;
      this.gameAV = 0;
      this.gameBI = 0L;
      this.gameBD = true;
      this.gameBC = -1;
      Calendar var6 = Res.gameAB();
      this.gameBH = var6.get(11) < 2 ? var6.get(5) - 1 : var6.get(5);
   }

   public final void gameAA(String var1) {
      if (Code.gameAH != null && !TileMap.isLangCo(super.mapID) && var1.startsWith("Thần thú đã xuất hiện tại")) {
         if (Char.getMyChar().cName.equals(Code.gameAH)) {
            int var2 = Char.getMyChar().clevel;
            MyVector var3 = new MyVector();
            MyVector var4 = new MyVector();
            if (var2 >= 40 && var2 <= 60) {
               if (var1.indexOf("Đảo Hebi") > 0) {
                  var3.addElement(new Integer(34));
                  var4.addElement(new Integer(32));
               }

               if (var1.indexOf("Hang Meiro") > 0) {
                  var3.addElement(new Integer(35));
                  var4.addElement(new Integer(32));
               }

               if (var1.indexOf("Rừng Kappa") > 0) {
                  var3.addElement(new Integer(52));
                  var4.addElement(new Integer(48));
               }

               if (var1.indexOf("Rừng Aokigahara") > 0) {
                  var3.addElement(new Integer(14));
                  var4.addElement(new Integer(10));
               }

               if (var1.indexOf("Rừng Aokigahara") > 0) {
                  var3.addElement(new Integer(14));
                  var4.addElement(new Integer(10));
               }

               if (var1.indexOf("Vách núi Ito") > 0) {
                  var3.addElement(new Integer(15));
                  var4.addElement(new Integer(10));
               }

               if (var1.indexOf("Núi Anzen") > 0) {
                  var3.addElement(new Integer(68));
                  var4.addElement(new Integer(38));
               }

               if (var1.indexOf("Thung lũng Taira") > 0) {
                  var3.addElement(new Integer(16));
                  var4.addElement(new Integer(10));
               }
            }

            if (var2 >= 50 && var2 <= 70) {
               if (var1.indexOf("Núi Ontake") > 0) {
                  var3.addElement(new Integer(67));
                  var4.addElement(new Integer(38));
               }

               if (var1.indexOf("Đỉnh Okama") > 0) {
                  var3.addElement(new Integer(44));
                  var4.addElement(new Integer(43));
               }
            }

            if (var2 >= 60 && var2 <= 80) {
               if (var1.indexOf("Khu đá đỏ Akai") > 0) {
                  var3.addElement(new Integer(41));
                  var4.addElement(new Integer(43));
               }

               if (var1.indexOf("Mũi Hone") > 0) {
                  var3.addElement(new Integer(59));
                  var4.addElement(new Integer(38));
               }

               if (var1.indexOf("Đỉnh Ichidai") > 0) {
                  var3.addElement(new Integer(24));
                  var4.addElement(new Integer(38));
               }

               if (var1.indexOf("Hang núi Kurai") > 0) {
                  var3.addElement(new Integer(45));
                  var4.addElement(new Integer(43));
               }
            }

            if (var2 >= 70 && var2 <= 100) {
               if (var1.indexOf("Ngôi đền Orochi") > 0) {
                  var3.addElement(new Integer(19));
                  var4.addElement(new Integer(17));
               }

               if (var1.indexOf("Đồng Kisei") > 0) {
                  var3.addElement(new Integer(36));
                  var4.addElement(new Integer(38));
               }

               if (var1.indexOf("Đền Harumoto") > 0) {
                  var3.addElement(new Integer(54));
                  var4.addElement(new Integer(43));
               }
            }

            if (var2 >= 90) {
               if (var1.indexOf("Sinh Tử Kiều") > 0) {
                  var3.addElement(new Integer(143));
                  var4.addElement(new Integer(this.gameBC));
               }

               if (var1.indexOf("Đoạn Sơn") > 0) {
                  var3.addElement(new Integer(141));
                  var4.addElement(new Integer(this.gameBC));
               }
            }

            if (var3.size() > 0) {
               Code.gameAA((Auto)(new PkBossS(var3, var4, this.gameBC)));
               return;
            }

            return;
         }

         Code.gameAA((Auto)(new PkBossS(this.gameBC)));
      }

   }

   public final void gameAL() {
      if (this.gameAV == 0) {
         this.gameBH = Res.gameAB().get(5);
         if (!TileMap.isLangCo(super.mapID)) {
            this.gameAV = 2;
            this.gameBJ = System.currentTimeMillis();
            this.gameBE = super.mapID;
            this.gameBF = super.zoneID;
            this.gameBG = super.gameAA;
            this.gameBD = false;
            gameAY = false;
            gameAZ = false;
            return;
         }
      } else {
         if (this.gameAV == 1) {
            this.gameAV = 3;
            this.gameBJ = System.currentTimeMillis();
            this.gameBD = false;
            return;
         }

         if (this.gameAV == 2) {
            this.gameAV = 1;
            this.gameBJ = System.currentTimeMillis();
            gameAX = false;
            return;
         }

         if (this.gameAV == 3) {
            this.gameAV = 0;
            this.gameBD = false;
            Code.gameAD();
            return;
         }

         if (this.gameAV == 4) {
            this.gameAV = 0;
            this.gameBD = false;
         }
      }

   }

   public final void gameAD() {
      this.gameBI = 0L;
      super.gameAD();
   }

   public final boolean gameAM() {
      return Code.gameAB instanceof Stanima && this.gameAV == 2 && Char.getMyChar().clevel >= 60 && Char.getMyChar().clevel < 70;
   }

   public final void gameAK() {
      if (Auto.reAC()) {
         Auto.gameAA(true);
      } else {
         Calendar var1;
         int var2 = (var1 = Res.gameAB()).get(5);
         int var3 = var1.get(11);
         int var4 = var1.get(12);
         switch(this.gameAV) {
         case 0:
            if (!this.gameBD && this.gameBC > 0) {
               if (TileMap.mapID != this.gameBC) {
                  this.gameAA(this.gameBC, -2, -1, -1);
                  return;
               }

               GameScr.gameAB(5, 1, 0);
               if (LockGame.gameAY()) {
                  this.gameBD = true;
                  super.mapID = this.gameBE;
                  super.zoneID = this.gameBF;
                  super.gameAA = this.gameBG;
                  super.gameAD = false;
                  return;
               }

               return;
            }

            if (this.gameBC < 0 && (TileMap.gameAD(TileMap.mapID) || TileMap.gameAF(TileMap.mapID))) {
               this.gameBC = TileMap.mapID;
            }

            if (var2 == this.gameBH || var3 < 2 || var4 < 30) {
               if (super.mapID == TileMap.mapID && (super.gameAD || super.zoneID == TileMap.zoneID)) {
                  if (Char.LuyenDa && Code.gameAH() && Char.gameBG() < 5 && !TileMap.isLangCo(TileMap.mapID)) {
                     Auto.reAD();
                     return;
                  }

                  if (!this.gameBB && !this.gameBA) {
                     this.gameAB(this.gameAW, this.gameAA(Char.DanhQuai, Char.DanhTA, Char.DanhTL));
                     this.gameAC(-1);
                  } else {
                     Char var15 = Char.getMyChar();
                     Char var18 = GameScr.vParty.size() > 0 ? ((Party)GameScr.vParty.firstElement()).c : null;
                     Skill var21;
                     if (this.gameBB && GameScr.vParty.size() > 0 && var15.nClass.classId == 6) {
                        label311:
                        for(var3 = 0; var3 < var15.vSkillFight.size(); ++var3) {
                           if ((var21 = (Skill)var15.vSkillFight.elementAt(var3)) != null && var21.template.type == 4) {
                              if (var21.gameAA()) {
                                 break;
                              }

                              var3 = 0;

                              while(true) {
                                 if (var3 >= GameScr.vParty.size()) {
                                    break label311;
                                 }

                                 Party var5;
                                 if ((var5 = (Party)GameScr.vParty.elementAt(var3)).charId != var15.charID && var5.c != null && var5.c.cHP <= 0) {
                                    try {
                                       var3 = var15.cx;
                                       int var6 = var15.cy;
                                       Char var7 = var5.c;
                                       Char.gameAC(var5.c.cx, var7.cy);
                                       Thread.sleep(500L);
                                       Service.gI().gameAX(var5.charId);
                                       var21.lastTimeUseThisSkill = System.currentTimeMillis();
                                       var21.paintCanNotUseSkill = true;
                                       var15.gameAB(GameScr.sks[var21.template.id], 0);
                                       Thread.sleep(1000L);
                                       Char.gameAC(var3, var6);
                                       return;
                                    } catch (InterruptedException var13) {
                                       var13.printStackTrace();
                                    }
                                 }

                                 ++var3;
                              }
                           }
                        }
                     }

                     if (this.gameBA && this.gameAG() && var18 != null && var15.nClass.classId == 6) {
                        for(var3 = 0; var3 < var15.vSkillFight.size(); ++var3) {
                           if ((var21 = (Skill)var15.vSkillFight.elementAt(var3)) != null && !var21.gameAA() && var21.template.type == 2 && (var21.template.id < 67 || var21.template.id > 72) && (var21.template.id != 47 || var18.cHP < var18.cMaxHP * Char.aHpValue / 100)) {
                              try {
                                 int var22;
                                 for(var22 = 0; var22 < var18.vEff.size(); ++var22) {
                                    var18.vEff.elementAt(var22);
                                 }

                                 var22 = var15.cx;
                                 var3 = var15.cy;
                                 Char.gameAC(var18.cx, var18.cy);
                                 Service.gI().gameAG(var21.template.id);
                                 Service.gI().gameAR();
                                 var21.lastTimeUseThisSkill = System.currentTimeMillis();
                                 var21.paintCanNotUseSkill = true;
                                 var15.gameAB(GameScr.sks[var21.template.id], 0);
                                 Thread.sleep(1000L);
                                 Char.gameAC(var22, var3);
                                 break;
                              } catch (InterruptedException var12) {
                                 var12.printStackTrace();
                              }
                           }
                        }
                     }
                  }

                  Item var16;
                  if (System.currentTimeMillis() - this.gameBI > 602000L && Char.gameBG() > 1 && (var16 = Char.gameAF(38)) != null) {
                     Service.gI().useItem(var16.indexUI);
                     this.gameBI = System.currentTimeMillis();
                     return;
                  }

                  return;
               }

               this.gameAA(super.mapID, super.zoneID, super.gameAE, super.gameAF);
               return;
            }
            break;
         case 1:
            if (Code.gameAH != null && System.currentTimeMillis() - this.gameBJ < 3600000L) {
               if (TileMap.mapID == 1 && TileMap.zoneID == 21) {
                  TaskOrder var14 = Char.gameAM(1);
                  boolean var17 = Char.getMyChar().cName.equals(Code.gameAH);
                  if (gameAX && var17) {
                     this.gameAL();
                     Service.gI().gameAK("sts");
                     return;
                  }

                  if (var14 == null) {
                     Npc var20;
                     Char.gameAC((var20 = GameScr.gameAI(25)).cx, var20.cy);
                     LockGame.gameAA(300000L);
                     if (var17) {
                        try {
                           GameScr.gameAB(25, GameScr.gameGP + 1, 0);
                           LockGame.gameAK();
                           Thread.sleep(2000L);
                           return;
                        } catch (InterruptedException var10) {
                           var10.printStackTrace();
                        }
                     }

                     return;
                  }

                  if (var14.count >= var14.maxCount) {
                     try {
                        GameScr.gameAB(25, GameScr.gameGP + 1, 2);
                        LockGame.gameAM();
                        Thread.sleep(2000L);
                        return;
                     } catch (InterruptedException var11) {
                        var11.printStackTrace();
                     }
                  }

                  if (var17) {
                     TaThu var19 = Code.gameAE;
                     Code.gameAE.gameAC();
                     var19.gameAA = true;
                     Code.gameAA((Auto)var19);
                     Service.gI().gameAK("att " + var19.mapID + " " + var19.zoneID + " " + var19.gameAV);
                     return;
                  }

                  return;
               }

               this.gameAA(1, 21, -1, -1);
               return;
            }

            this.gameAL();
            return;
         case 2:
            if (Char.getMyChar().clevel < 30 || System.currentTimeMillis() - this.gameBJ >= 10800000L) {
               this.gameAL();
               return;
            }

            if (!this.gameBD) {
               if (TileMap.mapID != 1 || TileMap.zoneID != 21) {
                  this.gameAA(1, 21, -1, -1);
                  return;
               }

               if (Char.CapFood <= 50) {
                  int var10000 = (var2 = Char.gameAK(Char.CapFood == 50 ? 29 : 23 + Char.CapFood / 10)) >= 2 ? 0 : 2 - var2;
                  var4 = var10000;
                  var2 = var10000;
                  if (var4 > 0) {
                     GameScr.gameAB(4, 0, 0);
                     if (Char.CapFood == 50) {
                        Service.gI().gameAA(9, 7, var2);
                     } else {
                        Service.gI().gameAA(9, Char.CapFood / 10, var2);
                     }

                     LockGame.gameAG();
                  }
               }

               if (var1.get(7) == 2) {
                  try {
                     GameScr.gameAB(24, 1, 0);
                     Thread.sleep(2000L);
                  } catch (InterruptedException var9) {
                     var9.printStackTrace();
                  }
               }

               this.gameBD = true;
               if ((var2 = Char.getMyChar().clevel) >= 90) {
                  LockGame.gameBI();
                  Code.gameAA((Auto)(new Hd9x()));
                  gameAY = true;
                  return;
               }

               super.mapID = var2 < 40 ? 91 : (var2 < 50 ? 94 : (var2 < 60 ? 105 : (var2 < 70 ? 114 : 125)));
               super.gameAD = true;
               super.gameAA = false;
               if (var2 >= 60 && var2 < 70) {
                  if (GameScr.vParty.size() > 1) {
                     Service.gI().gameAT();
                     return;
                  }

                  return;
               }

               if (Code.gameAH != null) {
                  LockGame.gameBI();
                  return;
               }
            } else {
               if (!gameAY) {
                  if (TileMap.mapID == super.mapID) {
                     this.gameAB(-1, -1);
                     this.gameAC(-1);
                     return;
                  }

                  this.gameAA(super.mapID, -2, -1, -1);
                  return;
               }

               if (!TileMap.gameAF(TileMap.mapID)) {
                  return;
               }

               GameScr.gameAB(0, 2, 0);
               Service.gI().gameBF();
               this.gameBD = false;
               gameAY = false;
               if (!gameAZ) {
                  return;
               }
            }
            break;
         case 3:
            if (!this.gameBD) {
               if (TileMap.mapID == 1 && TileMap.zoneID == 21) {
                  GameScr.gameAB(5, 1, 0);
                  if (LockGame.gameAY()) {
                     if (var1.get(7) == 2) {
                        try {
                           GameScr.gameAB(24, 1, 0);
                           Thread.sleep(2000L);
                        } catch (InterruptedException var8) {
                           var8.printStackTrace();
                        }
                     }

                     this.gameBD = true;
                     return;
                  }

                  return;
               }

               this.gameAA(1, 21, -1, -1);
               return;
            }
            break;
         default:
            return;
         }

         this.gameAL();
      }
   }

   public final String toString() {
      if (this.gameBA && this.gameBB) {
         return "Stanima Buff HS";
      } else if (this.gameBA) {
         return "Stanima Buff";
      } else if (this.gameBB) {
         return "Stanima HS";
      } else {
         return this.gameAW >= 0 && this.gameAW < Mob.arrMobTemplate.length ? "Stanima " + Mob.arrMobTemplate[this.gameAW].name : "Stanima";
      }
   }
}
