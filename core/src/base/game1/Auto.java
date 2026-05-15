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
import base.game1.screen.ScreenSettingSkill;

public abstract class Auto {
   public boolean danh_nhom;
   public boolean isPhoban;
   public int map_auto;
   public int khu_auto;
   public static Skill my_skill;
   public static Skill fix_skill;
   public int x_auto;
   public int y_auto;
   public long l;
   private int x_temp;
   private int y_temp;
   public Auto mode_temp;
   public static MyVector vect_mons = new MyVector();
   public static MyVector vect_player = new MyVector();
   public static MyVector vect_item_map = new MyVector();
   // Port TGAME Hút VP: state blacklist 16 slot + last pick time + last item pick id
   private static long hutvpLastPickTime = 0L;
   private static int hutvpLastItemMapID = -1;
   private static int[] hutvpIgnoreItemMapIDs = new int[16];
   private static long[] hutvpIgnoreUntilTimes = new long[16];
   private static boolean chohoisinh = false;
   private static long time_chohoisinh = 0L;
   public static MyVector listMob = new MyVector();
   public static MyVector listPk = new MyVector();
   protected long s = 0L;
   public static boolean tusat = false;
   public static long lastChangeZone = 0L;
   public int yen_before;
   public long level_before;
   public long time_start_auto;
   private int id_skill;
   private long time_skill;
   private long time_tele;
   public static boolean check_human;
   private byte ac;
   private ByteArrayInputStream ad;
   private DataInputStream ae;
   private boolean bat_pk;
   private long time_hlct;

   public final void a(byte var1) {
      this.ac = var1;
   }

   public final void a(byte[] var1) {
      this.ad = new ByteArrayInputStream(var1);
      this.ae = new DataInputStream(this.ad);
   }

   protected final void g() {
      try {
         switch (this.ac) {
            case 60:
            case 61:
               if (Char.getMyChar().myskill != null && Char.getMyChar().idChar == this.ae.readInt() && Char.getMyChar().cMP > Char.getMyChar().myskill.manaUse) {
                  Char var10000 = Char.getMyChar();
                  var10000.cMP -= Char.getMyChar().myskill.manaUse;
               }
         }
      } catch (Exception var2) {
      }

   }

   public void reset() {
      this.map_auto = -1;
      this.khu_auto = -1;
      this.mode_temp = null;
      my_skill = Char.getMyChar().myskill;
      fix_skill = Char.getMyChar().myskill;
      ScreenSettingSkill.applyConfiguredSkills();
      Code.index_dcvt = -1;
      Code.index_dck = 0;
      this.yen_before = Char.getMyChar().yen;
      this.level_before = Char.getMyChar().cEXP;
      this.time_start_auto = System.currentTimeMillis();
      tusat = false;
      this.danh_nhom = false;
      check_human = Char.getMyChar().isHuman;
      this.resetAfterLogin();
   }

   protected void resetAfterLogin() {
   }

   public final int a(boolean var1, boolean var2, boolean var3) {
      if (this.isPhoban) {
         return -1;
      } else {
         int var4 = 0;
         if (var1) {
            var4 = 1;
         }

         if (var2) {
            var4 |= 2;
         }

         if (var3) {
            var4 |= 4;
         }

         return var4;
      }
   }

   public static void add_Mob(Mob var0) {
      if (var0.isBoss || var0.status != 0 && var0.levelBoss != 3 && var0.maxHp != var0.c().f) {
         if (!var0.isBoss && var0.levelBoss == 0) {
            if (var0.maxHp == 10 * var0.c().f) {
               var0.levelBoss = 1;
            } else {
               if (var0.maxHp != 100 * var0.c().f && var0.s != 89) {
                  return;
               }

               var0.levelBoss = 2;
            }
         }

         if (!listMob.contains(var0)) {
            listMob.addElement(var0);
         }
      }

   }

   public static void remove_Mob(Mob var0) {
      listMob.removeElement(var0);
   }

   public static void removeall_Mob() {
      listMob.removeAllElements();
   }

   public static void add_Pk(Char var0) {
      if (var0 != Char.getMyChar()) {
         if (listPk.contains(var0)) {
            if (var0.cTypePk != 3 && var0.dc != Char.getMyChar().idChar) {
               listPk.removeElement(var0);
               return;
            }
         } else if (var0.cTypePk == 3 || var0.dc == Char.getMyChar().idChar) {
            listPk.addElement(var0);
         }
      }

   }

   public static void removeall_Pk() {
      listPk.removeAllElements();
   }

   protected static boolean isDead() {
      return check_dead(Char.getMyChar());
   }

   public static boolean check_dead(Char var0) {
      return var0.cHP <= 0 || var0.statusMe == 14 || var0.statusMe == 5;
   }

   public void remap(int param_map, int param_khu, int param_x, int param_y) {
      if ((param_map < 139 || param_map > 148) && TileMap.mapID >= 139 && TileMap.mapID <= 148) {
         tusat_vdmq();
      } else if (TileMap.mapID != param_map) {
         if (!TileMap.goMap(param_map)) {
            if (TileMap.isLangCo(param_map)) {
               phong.sleep(100L);
            }

            return;
         }

         phong.sleep(100L);
      } else if (TileMap.zoneID != param_khu) {
         if (param_khu == -1) {
            if (Code.dck) {
               int[] var5 = Code.arr_dck;
               Code.index_dck = 0;
               this.chuyenkhu1(this.khu_auto = var5[0]);
            } else {
               this.chuyenkhu2(param_khu);
            }
         } else if (param_khu >= 0) {
            this.chuyenkhu1(param_khu);
         }
      } else if (param_x > 0 && param_y > 0) {
         if (this instanceof AutoTuDanh) {
            Char.move(param_x, param_y);
            return;
         }

         this.get_mob_focus(get_dxdy_mob(param_x, param_y));
      }

   }

   protected static void tusat_vdmq() {
      Char var0 = Char.getMyChar();
      if (!Code.check_item(37) && !Code.check_item(35)) {
         Npc var1;
         if ((var1 = GameScr.npc_i(13)) != null && Math.abs(var1.cx1 - var0.cx1) <= 400 && Math.abs(var1.cy1 - var0.cy1) <= 400) {
            Char.move(var1.cx1 > 400 ? var1.cx1 - 400 : var1.cx1 + 400, var1.cy1);
         }

         Service.gI().e();
      } else {
         Char.move(var0.cx1, TileMap.pxh);
      }

      long var3 = System.currentTimeMillis();

      while(var0.cHP > 0 && System.currentTimeMillis() - var3 < 5000L) {
         phong.sleep(100L);
      }

   }

   public static void tusat_vdmq_public() {
      tusat_vdmq();
   }

   // Port TGAME Muc 5: wrapper public de AutoNst (class ngoai package) goi duoc.
   public static void hoisinh_public(boolean var0) {
      hoisinh(var0);
   }

   protected static void hoisinh(boolean var0) {
      Char var1 = Char.getMyChar();
      if (Code.hsl && var1.luong > 0) {
         listMob.removeAllElements();
         tusat = false;
         phong1.a = true;
         Service.gI().l();
         phong1.a = false;
      } else {
         if (var0) {
            if (chohoisinh) {
               if (System.currentTimeMillis() - time_chohoisinh < 2000L) {
                  return;
               }

               chohoisinh = false;
            } else if (Char.danhtheonhom && GameScr.vParty.size() > 0) {
               for(int var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
                  Party var3;
                  if ((var3 = (Party)GameScr.vParty.elementAt(var2)).a != var1.idChar && var3.f != null && var3.f.cHP > 0 && var3.f.nClass.a == 6) {
                     Code.popup_chat("Chờ hồi sinh");
                     time_chohoisinh = System.currentTimeMillis();
                     chohoisinh = true;
                     return;
                  }
               }
            }
         }

         listMob.removeAllElements();
         tusat = false;
         phong1.a = true;
         Service.gI().k();
         TileMap.f1();
         phong1.a = false;
      }

   }

   protected void syncLeaderTarget() {
      if (!this.danh_nhom) return;
      if (this instanceof AutoBuff) return;
      if (GameScr.vParty.size() == 0) return;
      Party party = (Party)GameScr.vParty.firstElement();
      Char me = Char.getMyChar();
      if (me.idChar == party.a) return;
      Char leader = party.f;
      if (leader == null || leader.cHP <= 0) return;
      Mob leaderMob = leader.mobFocus;
      if (leaderMob == null || leaderMob.hp <= 0 || leaderMob.status == 0) return;
      me.mobFocus = leaderMob;
   }

   protected void chuyenkhu1(int var0) {
      // P2 A1#10 + N6 T5: g10 cross-check + tripwire mismatch.
      if (com.monkey.nso.LicenseGuard.isVerifyStarted()) {
         // T5: cracker patch isVerified=true ma g10()=false (state khong nhat quan) -> tripwire.
         boolean _g = com.monkey.nso.LicenseGuard.g10();
         if (com.monkey.nso.LicenseVerifier.isVerified != _g) {
            com.monkey.nso.LicenseGuard.fireTripwire(5);
         }
         // A1#10: g10 fail -> 50% skip zone change random (auto roi loan, khong crash).
         if (!_g && Math.random() < 0.5) return;
      }
      if (TileMap.zoneID == var0) {
         return;
      }
      int kdl;
      if ((kdl = Code.index_item(37)) == -1) {
         kdl = Code.index_item(35);
      }

      Npc var1 = GameScr.npc_i(13);
      if (var1 != null && var1.statusMe != 15) {
         if (kdl == -1 && (Math.abs(var1.cx1 - Char.getMyChar().cx1) > 22 || Math.abs(var1.cy1 - Char.getMyChar().cy1) > 22)) {
            Char.move(var1.cx1, var1.cy1);
            phong.sleep(100L);
         }
      } else {
         if (TileMap.mapID != 99 && TileMap.mapID != 103 && TileMap.mapID != 134 && TileMap.mapID != 135 && TileMap.mapID != 136 && TileMap.mapID != 137) {
            return;
         }
         if (kdl < 0) {
            return;
         }
      }

      Service.gI().a(var0, kdl);
      TileMap.f2(10000L);
   }

   protected final void chuyenkhu2(int var1) {
      if (!this.danh_nhom || Code.ig_lead == null || Char.getMyChar().cName.equals(Code.ig_lead)) {
         int kdl;
         if ((kdl = Code.index_item(37)) == -1) {
            kdl = Code.index_item(35);
         }

         GameScr var2 = GameScr.gI();
         Npc var3 = GameScr.npc_i(13);
         if (var3 != null && var3.statusMe != 15) {
            if (kdl == -1 && (Math.abs(var3.cx1 - Char.getMyChar().cx1) > 22 || Math.abs(var3.cy1 - Char.getMyChar().cy1) > 22)) {
               Char.move(var3.cx1, var3.cy1);
               phong.sleep(100L);
            }
         } else if (TileMap.mapID != 99 && TileMap.mapID != 103 && TileMap.mapID != 134 && TileMap.mapID != 135 && TileMap.mapID != 136 && TileMap.mapID != 137) {
            this.khu_auto = TileMap.zoneID;
            return;
         }

         if (kdl != -1) {
            GameScr.gI().fh();
         } else {
            Service.gI().e();
         }

         int khu;
         for(khu = 0; khu < 50; ++khu) {
            phong.sleep(100L);
            if (GameScr.gI().iu != null) {
               break;
            }
         }

         if (GameScr.gI().iu == null) {
            this.khu_auto = TileMap.zoneID;
            return;
         }

         khu = -1;
         if (var1 < 0) {
            var1 = var2.iu.length - 1;
         } else if (var1 >= var2.iu.length) {
            var1 = 0;
         }

         if (this instanceof AutoTaThu) {
            khu = (var1 / 5 + 1) * 5 % var2.iu.length;
         } else {
            int var5 = -1;

            for(int var6 = (var1 + 1) % var2.iu.length; var6 != var1; var6 = (var6 + 1) % var2.iu.length) {
               if (var5 == -1 || var2.iu[var6] < var5) {
                  khu = var6;
                  var5 = var2.iu[var6];
               }
            }
         }

         Service.gI().a(khu, kdl);
         TileMap.f2(10000L);
         this.khu_auto = khu;
         if (this.n()) {
            Service.gI().j("khu " + khu);
         }
      }

   }

   private boolean n() {
      return this.danh_nhom && GameScr.vParty.size() > 0 && ((Party)GameScr.vParty.firstElement()).a == Char.getMyChar().idChar;
   }

   public static boolean isLeader() {
      return GameScr.vParty.size() > 0 && ((Party)GameScr.vParty.firstElement()).a == Char.getMyChar().idChar;
   }

   protected final void get_mob_focus(Mob var1) {
      if (var1 != null) {
         int var2 = var1.i;
         int var3 = var1.j;
         Char var4 = Char.getMyChar();
         if (TileMap.mapID == 35) {
            if (var1.i == 1428 && var1.j == 528) {
               var2 = 1452;
               var3 = 552;
            } else if (var1.i == 1284 && var1.j == 528) {
               var2 = 1308;
               var3 = 552;
            } else if (var1.i == 1836 && var1.j == 648) {
               var2 = 1812;
               var3 = 672;
            }
         } else if (TileMap.mapID == 37) {
            if ((var1.i == 876 || var1.i == 900) && var1.j == 408) {
               var2 = 900;
               var3 = 432;
            } else if ((var1.i == 828 || var1.i == 852) && var1.j == 360) {
               var2 = 852;
               var3 = 384;
            } else if ((var1.i == 924 || var1.i == 876) && var1.j == 624) {
               var2 = 924;
               var3 = 648;
            } else if (var1.i == 732 && var1.j == 600 || var1.i == 756 && var1.j == 576) {
               var2 = 756;
               var3 = 600;
            }
         }

         if (Char.d(var2, TileMap.d(var2, var3))) {
            this.x_temp = this.x_auto;
            this.y_temp = this.y_auto;
            this.x_auto = var4.cx1;
            this.y_auto = var4.cy1;
            var4.mobFocus = var1;
            // [TOI-UU-TANSAT A] port từ trungduc Class_ad:561 — giảm 100L → 50L
            // Sau Char.d() cx1/cy1 đã cập nhật tới mob, 50ms đủ cho server ACK.
            phong.sleep(50L);
            if (DebugLog.DEBUG) DebugLog.log("TS", "focus mobS=" + var1.s + " xy=" + var2 + "," + var3);
            return;
         }

         var4.mobFocus = null;
      }

   }

   private boolean check_thulinh(int var1, int var2, int var3) {
      if (var1 >= 4) {
         return false;
      } else {
         for(int var4 = 0; var4 < listMob.size(); ++var4) {
            Mob var5;
            if ((var5 = (Mob)listMob.elementAt(var4)).levelBoss != 0 && var5.hp > 0 && var5.status != 0) {
               boolean var6;
               if (var5.levelBoss == 3) {
                  var6 = false;
               } else if (var5.isBoss && (var1 & 6) != 6 || var5.levelBoss == 1 && (var1 & 2) == 0 || var5.levelBoss == 2 && (var1 & 4) == 0) {
                  var6 = true;
               } else {
                  var6 = false;
               }

               if (var6 && Res.e(var2 - var5.i) <= 200 && Res.e(var3 - var5.j) <= 100) {
                  return true;
               }
            } else {
               listMob.removeElement(var5);
               --var4;
            }
         }

         return false;
      }
   }

   private boolean check_nepk(int var1, int var2) {
      if (Char.nepk) {
         for(int var3 = 0; var3 < listPk.size(); ++var3) {
            Char var4;
            if (!check_dead(var4 = (Char)listPk.elementAt(var3)) && Res.e(var1 - var4.cx1) <= 300 && Res.e(var2 - var4.cy1) <= 300) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   protected final void dcvt(int var1, boolean var2) {
      if (Code.index_dcvt < 0 || Code.index_dcvt >= Code.x_dcvt[TileMap.mapID].size()) {
         Code.index_dcvt = 0;
      }

      while(true) {
         int var3 = (Integer)Code.x_dcvt[TileMap.mapID].elementAt(Code.index_dcvt);
         int var4 = (Integer)Code.y_dcvt[TileMap.mapID].elementAt(Code.index_dcvt);
         Mob var5 = get_dxdy_mob(var3, var4);
         if (!this.check_thulinh(var1, var3, var4) && !this.check_nepk(var3, var4) && var5 != null && !this.check_thulinh(var1, var5.x1, var5.y1)) {
            this.x_temp = Char.getMyChar().cx1;
            this.y_temp = Char.getMyChar().cy1;
            Char.move(var3, var4);
            Char.getMyChar().mobFocus = var5;
            Service.gI().b(var5.m);
            phong.sleep(50L);
            return;
         }

         phong.sleep(50L);
         if (++Code.index_dcvt == Code.x_dcvt[TileMap.mapID].size()) {
            Code.index_dcvt = 0;
            if (AutoMapKhu.effectiveChuyenmap() && var2) {
               this.chuyenkhu3();
            }
         }
      }
   }

   // Port TGAME Muc 5: doc state qua AutoMapKhu.effectiveXxx() de override layer
   // cua AutoNst/AutoMapKhu co the ep chuyenmap / dck / arr_dck trong doi autoTansat
   // kich hoat boi chat "nst" — ma KHONG ghi de setting user goc.
   private void chuyenkhu3() {
      if (AutoMapKhu.effectiveDck()) {
         int[] arr = AutoMapKhu.effectiveArrDck();
         int idx = AutoMapKhu.effectiveIndexDck();
         if (arr == null || arr.length == 0) {
            this.chuyenkhu2(TileMap.zoneID);
            return;
         }
         if (idx < 0 || idx >= arr.length) idx = 0;
         int khu_next = arr[idx];
         if (TileMap.zoneID != khu_next) {
            if (DebugLog.DEBUG && (TileMap.mapID == 35 || TileMap.mapID == 37)) DebugLog.log("TS", "[MAP35/37] chuyenkhu3 doi khu_auto " + this.khu_auto + "->" + khu_next + " zoneID=" + TileMap.zoneID);
            this.chuyenkhu1(this.khu_auto = khu_next);
            if (this.n()) {
               Service.gI().j("khu " + this.khu_auto);
            }

            return;
         }

         ++idx;
         if (idx >= arr.length) {
            idx = 0;
         }
         AutoMapKhu.setEffectiveIndexDck(idx);
      } else {
         this.chuyenkhu2(TileMap.zoneID);
      }

   }

   protected static Mob get_dxdy_mob(int var0, int var1) {
      Mob var2 = null;
      Char var3 = Char.getMyChar();
      int var4 = var0 - var3.ae() - 10;
      int var5 = var0 + var3.ae() + 10;
      int var6 = var1 - var3.af() - (var3.nClass.a != 0 && var3.nClass.a != 1 && var3.nClass.a != 3 && var3.nClass.a != 5 ? 0 : 40);
      int var12;
      if ((var12 = var1 + var3.af()) > var1 + 30) {
         var12 = var1 + 30;
      }

      int var7 = -1;

      for(int var8 = 0; var8 < GameScr.vMob.size(); ++var8) {
         Mob var9 = (Mob)GameScr.vMob.elementAt(var8);
         int var10 = Math.abs(var0 - var9.x1);
         int var11 = Math.abs(var1 - var9.y1);
         var10 = var10 > var11 ? var10 : var11;
         if (var4 <= var9.x1 && var9.x1 <= var5 && var6 <= var9.y1 && var9.y1 <= var12 && var9.status != 0 && var9.status != 1 && (var7 == -1 || var10 < var7)) {
            var2 = var9;
            var7 = var10;
         }
      }

      return var2;
   }

   private static boolean check_quai1(Mob var0, int var1) {
      if ((var0.s != 202 || var0.status != 8) && var0.s != 225) {
         if (Code.danhTheoID && var1 == -1) {
            if (!Code.hasMobIDFilter()) {
               return true;
            }

            for (int i = 0; i < Code.mobIDFilter.length; i++) {
               if (Code.mobIDFilter[i] > 0 && var0.s == Code.mobIDFilter[i]) {
                  return true;
               }
            }
            return false;
         }
         return var1 < 0 || var0.s == var1;
      } else {
         return false;
      }
   }

   private static boolean check_quai2(int var0, int var1) {
      return var1 < 0 || var0 == 0 && (var1 & 1) > 0 || var0 == 1 && (var1 & 2) > 0 || var0 == 2 && (var1 & 4) > 0 || var0 == 3 && (var1 & 8) > 0;
   }

   protected Mob get_mob(Char var1, int var2, int var3, Char var4, boolean var5) {
      if (Code.dcvt && Code.x_dcvt[TileMap.mapID].size() > 0) {
         this.dcvt(var3, var5);
         return get_dxdy_mob(var1.cx1, var1.cy1);
      } else {
         Char var6 = var4;
         int var7 = var3;
         int var8 = var2;
         var3 = var1.cy1;
         var2 = var1.cx1;
         Auto var9 = this;
         int var10 = -1;
         int var11 = -1;
         int var12 = -1;
         Mob var13 = null;
         MyVector var14 = GameScr.vMob;
         int var15 = 0;

         Mob var16;
         while(true) {
            if (var15 >= var14.size()) {
               var16 = var13;
               break;
            }

            Mob var18;
            if ((var18 = (Mob)var14.elementAt(var15)) != null && var18.hp > 0 && var18.status != 0 && var18.status != 1 && check_quai1(var18, var8) && check_quai2(var18.levelBoss, var7) && !KichYen.checkMob(var18) && (var6 == null || var6.idChar == Char.getMyChar().idChar || Res.a(var18.i, var18.j, var6.cx1, var6.cy1) <= 1000) && !var9.check_thulinh(var7, var18.x1, var18.y1) && !var9.check_nepk(var18.x1, var18.y1)) {
               if (var9.isPhoban) {
                  if (var9.map_auto != 157 && var9.map_auto != 158 && var9.map_auto != 159) {
                     if (var10 == -1 || var18.levelBoss < var12 || var18.j < var10 || var18.j == var10 && var18.i < var11) {
                        var12 = var18.levelBoss;
                        var10 = var18.j;
                        var11 = var18.i;
                        var13 = var18;
                     }
                  } else if (var18.isBoss) {
                     var16 = var18;
                     break;
                  }
               } else if (Code.kcts == -1 || Res.a(Code.x_kts, Code.y_kts, var18.i, var18.j) <= Code.kcts) {
                  int var17 = var7;
                  int var19 = var8;
                  MyVector var20 = var14;
                  Mob var21 = var18;
                  int var22 = 0;

                  int var23;
                  for(var23 = 0; var23 < var20.size(); ++var23) {
                     Mob var24;
                     if ((var24 = (Mob)var20.elementAt(var23)) != null && var24.hp > 0 && var24.status != 0 && var24.status != 1 && check_quai1(var21, var19) && check_quai2(var21.levelBoss, var17) && !KichYen.checkMob(var21) && Res.e(var24.x1 - var21.x1) <= 100 && Res.e(var24.y1 - var21.y1) <= 50) {
                        ++var22;
                     }
                  }

                  if (var22 > my_skill.maxFight) {
                     var22 = my_skill.maxFight;
                  }

                  var22 = var21.levelBoss << 4 | var22 & 15;
                  var23 = var6 != null && var6.idChar != Char.getMyChar().idChar ? Res.a(var6.cx1, var6.cy1, var18.i, var18.j) : Res.a(var2, var3, var18.i, var18.j);
                  if (var22 > var12 || var22 == var12 && var23 < var10) {
                     var12 = var22;
                     var10 = var23;
                     var13 = var18;
                  }
               }
            }

            ++var15;
         }

         if (var16 != null) {
            if (TileMap.isLangCo(TileMap.mapID)) {
               if (!var16.isBoss) {
                  this.get_mob_focus(var16);
                  return var16;
               } else {
                  var16 = null;
                  return null;
               }
            } else {
               this.get_mob_focus(var16);
               return var16;
            }
         } else {
            if (System.currentTimeMillis() - this.s >= 1000L && !this.check_itemmap()) {
               if (this.isPhoban) {
                  int var22;
                  if ((var22 = TileMap.h(TileMap.mapID)) >= 0) {
                     this.map_auto = var22;
                  }

                  this.x_auto = this.y_auto = -1;
               } else if (var5 && AutoMapKhu.effectiveChuyenmap()) {
                  if (DebugLog.DEBUG && (TileMap.mapID == 35 || TileMap.mapID == 37)) DebugLog.log("TS", "[MAP35/37] get_mob null -> chuyenkhu3 khu_auto=" + this.khu_auto + " zoneID=" + TileMap.zoneID + " dck=" + AutoMapKhu.effectiveDck());
                  this.chuyenkhu3();
               }
            }

            if (DebugLog.DEBUG && (TileMap.mapID == 35 || TileMap.mapID == 37)) DebugLog.log("TS", "[MAP35/37] get_mob=null vMob=" + GameScr.vMob.size() + " listMob=" + listMob.size() + " var2=" + var7 + " isPhoban=" + this.isPhoban);
            return null;
         }
      }
   }
 
   protected boolean check_itemmap() {
      Char var1 = Char.getMyChar();
      // Port TGAME Hút VP: khi bật hút VP dùng hutvpRange, ngược lại giữ kc_nhat cũ
      int var2 = Code.isHutVp ? Code.hutvpRange : (Code.kc_nhat < 0 ? -1 : Code.kc_nhat);

      for(int var3 = 0; var3 < GameScr.vItemMap.size(); ++var3) {
         ItemMap var4;
         if (!(var4 = (ItemMap)GameScr.vItemMap.elementAt(var3)).k && (var1.nClass.a == 1 && var4.template.id == 218 || var4.template.type == 19 || Code.check_nhatdo(var4.template) && (Code.solg_hanhtrang() > 2 || var4.template.isUpToUp && Code.check_item(var4.template.id))) && (var2 < 0 || Res.a(var1.cx1, var1.cy1, var4.xEnd, var4.yEnd) < var2) && !this.check_nepk(var4.xEnd, var4.yEnd)) {
            return true;
         }
      }

      return false;
   }

   static Char CharCanPK() {
      for(int i = 0; i < GameScr.vCharInMap.size(); ++i) {
         Char char_ = (Char)GameScr.vCharInMap.elementAt(i);
         if (char_ != null && !char_.ab() && (char_.cTypePk == 3 || Char.getMyChar().idChar == char_.dc || char_.cTypePk == 1)) {
            return char_;
         }
      }

      return null;
   }

   protected final void attack(int var1, int var2) {
      Char var3 = Char.getMyChar();
      if (!isTanghinh()) {
         Char var4 = this.danh_nhom && GameScr.vParty.size() > 0 ? ((Party)GameScr.vParty.firstElement()).f : null;
         boolean var5 = !this.danh_nhom || Code.ig_lead == null || var3.cName.equals(Code.ig_lead);
         Mob var6 = var3.mobFocus;
         if (Code.dcvt && Code.x_dcvt[TileMap.mapID].size() > 0 && Code.index_dcvt < 0) {
            this.dcvt(var2, var5);
            return;
         }

         boolean var16 = false;
         boolean avoidThulinh = this.check_thulinh(var2, var3.cx1, var3.cy1);
         boolean avoidPk = this.check_nepk(var3.cx1, var3.cy1);
         boolean avoidFocusThulinh = var6 != null && this.check_thulinh(var2, var6.x1, var6.y1);
         if (avoidThulinh || avoidPk || avoidFocusThulinh) {
            Code.popup_chat("Né");
            // Port TGAME: AutoDanhVong / AutoNVHN gap thu linh trong vung check san co
            // -> bo focus va scan mob khac cung khu, KHONG chuyenkhu3 ngay (tranh loan task).
            // Ne PK van giu logic chuyenkhu3 cu.
            if ((avoidThulinh || avoidFocusThulinh) && (this instanceof AutoDanhVong || this instanceof AutoNVHN)) {
               var16 = false;
            } else if (AutoMapKhu.effectiveChuyenmap() && var5) {
               this.chuyenkhu3();
               var16 = true;
            } else {
               var16 = false;
            }

            if (var16) {
               return;
            }

            var16 = true;
            var6 = null;
         }

         if (var6 == null || var6.status == 0 || var6.hp <= 0 || KichYen.checkMob(var6) || !check_quai1(var6, var1) || !check_quai2(var6.levelBoss, var2) || System.currentTimeMillis() - this.s > 5000L) {
            var6 = this.get_mob(var3, var1, var2, var4, var5);
         }

         if (var6 == null && var16 && this.x_temp > 0 && this.y_temp > 0) {
            Char.move(this.x_temp, this.y_temp);
         }

         int var13;
         if (Char.danhtheonhom && GameScr.vParty.size() > 0 && var3.nClass.a == 6 && var3.cHP > 0) {
            for(int var10 = 0; var10 < var3.vSkillFight.size(); ++var10) {
               Skill var11;
               if ((var11 = (Skill)var3.vSkillFight.elementAt(var10)) != null && var11.template.type == 4) {
                  if (!var11.a()) {
                     for(var13 = 0; var13 < GameScr.vParty.size(); ++var13) {
                        Party var14;
                        if ((var14 = (Party)GameScr.vParty.elementAt(var13)).a != var3.idChar && var14.f != null && var14.f.cHP <= 0) {
                           Char var20 = var14.f;
                           if (Math.abs(var3.cx1 - var20.cx1) > 50 || Math.abs(var3.cy1 - var20.cy1) > 50) {
                              Char.move(var20.cx1, var20.cy1);
                           }

                           phong.sleep(500L);
                           Service.gI().x(var14.a);
                           var11.lastTimeUseThisSkill = System.currentTimeMillis();
                           var11.l = true;
                           var3.b(GameScr.aa[var11.template.id], 0);
                           phong.sleep(1000L);
                           return;
                        }
                     }
                  }
                  break;
               }
            }
         }

         if (DebugLog.DEBUG && (TileMap.mapID == 35 || TileMap.mapID == 37)) DebugLog.log("TS", "[MAP35/37] attack: var6=" + (var6 != null ? "s"+var6.s+"/lb"+var6.levelBoss : "null") + " var2=" + var2 + " santatl=" + Char.santatl + " isPhoban=" + this.isPhoban + " listMob=" + listMob.size());
         if (Char.santatl && !this.isPhoban && (var6 == null || var6.levelBoss == 0 && (var2 & 6) != 0)) {
            boolean var17 = (var2 & 2) != 0;
            var5 = (var2 & 4) != 0;

            for(var13 = 0; var13 < listMob.size(); ++var13) {
               Mob var19;
               if ((var19 = (Mob)listMob.elementAt(var13)).hp > 0 && var19.status != 0 && var19.status != 1 && !this.check_thulinh(var2, var19.x1, var19.y1) && !this.check_nepk(var19.x1, var19.y1) && check_quai1(var19, var1) && (var17 && var19.levelBoss == 1 || var5 && var19.levelBoss == 2) && !KichYen.checkMob(var19)) {
                  var6 = var19;
                  this.get_mob_focus(var19);
                  break;
               }
            }
         }

         if (my_skill != null) {
            Skill var14 = my_skill;
            if (var14.a()) {
               Skill var22;
               int i;
               if (Code.check_item(545) && Char.dung_pthan) {
                  for(i = 0; i < var3.vSkill.size(); ++i) {
                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id >= 67 && var22.template.id <= 72 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                        var14 = var22;
                        break;
                     }
                  }
               }

               if (Char.dunghotro) {
                  if (var3.nClass.a == 6) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.type == 2 && (var22.template.id < 67 || var22.template.id > 72) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var14 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 4) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.type == 2 && var22.template.type != 31 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var14 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 3) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 25 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var14 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 2) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && (var22.template.id == 13 || var22.template.id == 16) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var14 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 1) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 7 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var14 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 5) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && (var22.template.id == 42 || var22.template.id == 43) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var14 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }
               }
            }

            if (System.currentTimeMillis() - var14.lastTimeUseThisSkill >= (long)var14.coolDown) {
               if (var14.template.type == 2) {
                  Service.gI().selectSkill(var14.template.id);
                  Service.gI().r();
                  var14.lastTimeUseThisSkill = System.currentTimeMillis();
                  var14.l = true;
                  phong.sleep(100L);
               } else {
                  if (var6 != null && var6.hp > 0 && check_quai1(var6, var1) && check_quai2(var6.levelBoss, var2)) {
                     if (var14.template.type != 1 && var14.template.type != 3 || Res.e(var3.cx1 - var6.i) <= var14.dx + 30 && Res.e(var3.cy1 - var6.j) <= var14.dy + 30) {
                        int var27 = var14.dx;
                        int var15 = var14.dy;
                        vect_mons.removeAllElements();
                        vect_player.removeAllElements();
                        vect_mons.addElement(var6);

                        int var26;
                        for(var26 = 0; var26 < GameScr.vMob.size() && vect_mons.size() + vect_player.size() < var14.maxFight; ++var26) {
                           Mob var24;
                           if ((var24 = (Mob)GameScr.vMob.elementAt(var26)).status != 0 && var24.status != 1 && !var24.equals(var6) && var6.i - 100 <= var24.i && var24.i <= var6.i + 100 && var6.j - 50 <= var24.j && var24.j <= var6.j + 50 && check_quai2(var24.levelBoss, var2) && check_quai1(var24, var1)) {
                              vect_mons.addElement(var24);
                           }
                        }

                        for(var26 = 0; var26 < GameScr.vCharInMap.size() && vect_mons.size() + vect_player.size() < var14.maxFight; ++var26) {
                           Char var23;
                           if ((var23 = (Char)GameScr.vCharInMap.elementAt(var26)).cHP > 0 && var23.statusMe != 14 && var23.statusMe != 5 && var23.statusMe != 15 && (var23.cTypePk == 3 || var3.cTypePk == 3 || var23.cTypePk == 1 && var3.cTypePk == 1 || var3.dc >= 0 && var3.dc == var23.idChar || var3.db >= 0 && var3.db == var23.idChar || var23.dc == var3.idChar) && !Code.check_nhom3(var23.cName) && var6.x1 - var27 <= var23.cx1 && var23.cx1 <= var6.x1 + var27 && var6.y1 - var15 <= var23.cy1 && var23.cy1 <= var6.y1 + var15) {
                              vect_player.addElement(var23);
                           }
                        }

                        Service.gI().selectSkill(var14.template.id);
                        Service.gI().sendPlayerAttack(vect_mons, new MyVector(), 1);
                        var14.lastTimeUseThisSkill = System.currentTimeMillis();
                        var14.l = true;
                        if (!Code.dongbang_skill) {
                           int skillAnim = (Code.fakeSkill && Code.fakeSkillId > 0 && Code.fakeSkillId < GameScr.aa.length) ? Code.fakeSkillId : var14.template.id;
                           var3.b(GameScr.aa[skillAnim], 0);
                        }

                        this.s = System.currentTimeMillis();
                        if (DebugLog.DEBUG) DebugLog.log("TS", "fire mobS=" + var6.s + " skill=" + var14.template.id + " aoe=" + vect_mons.size());
                        return;
                     }

                     // [TOI-UU-TANSAT B] skill ngoài range → áp sát lại thay vì mất focus.
                     // Tránh regression loop: null focus → frame sau phải get_mob() scan
                     // toàn bộ vMob + sleep get_mob_focus lần nữa. var6 đã check non-null
                     // + hp>0 + quai1/quai2 ở điều kiện ngoài nên vẫn hợp lệ.
                     // get_mob_focus() tự xử null nếu Char.d() pathfinding fail.
                     if (DebugLog.DEBUG) DebugLog.log("TS", "refocus OUT-OF-RANGE mobS=" + var6.s
                        + " skill_dx=" + var14.dx + " skill_dy=" + var14.dy
                        + " dx=" + Res.e(var3.cx1 - var6.i) + " dy=" + Res.e(var3.cy1 - var6.j));
                     this.get_mob_focus(var6);
                     return;
                  }

                  return;
               }
            }
         }
      }

   }

   private void selectSkill(int var1) {
      if (this.id_skill >= -1 && var1 == this.id_skill) {
         if (my_skill != null && var1 == my_skill.template.id && System.currentTimeMillis() - this.time_skill > 10000L) {
            Service.gI().selectSkill(this.id_skill = var1);
            this.time_skill = System.currentTimeMillis();
         }
      } else {
         Service.gI().selectSkill(this.id_skill = var1);
      }

   }

   public void nhatdo(int id) {
      Char var2 = Char.getMyChar();
      if (!isTanghinh()) {
         // Port TGAME: nếu đang bật Hút VP thì rẽ sang nhánh direct-pick (không move)
         if (Code.isHutVp) {
            this.nhatdoHutVp(var2, id);
            return;
         }

         vect_item_map.removeAllElements();
         int var3 = this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh);

         int var4;
         for(var4 = 0; var4 < GameScr.vItemMap.size(); ++var4) {
            ItemMap var5;
            if (!(var5 = (ItemMap)GameScr.vItemMap.elementAt(var4)).k && (var2.nClass.a == 1 && var5.template.id == 218 || (Code.check_nhatdo(var5.template) || var5.template.id == id || this instanceof AutoDanhVong && AutoDanhVong.dieukien == 4 && var5.template.type == 26) && (Code.solg_hanhtrang() > 2 || var5.template.type == 19 || var5.template.isUpToUp && Code.check_item(var5.template.id))) && !this.check_thulinh(var3, var5.xEnd, var5.yEnd) && !this.check_nepk(var5.xEnd, var5.yEnd) && (Code.kc_nhat < 0 || Res.a(var2.cx1, var2.cy1, var5.xEnd, var5.yEnd) < Code.kc_nhat)) {
               vect_item_map.addElement(var5);
            }
         }

         if (vect_item_map.size() > 0) {
            var4 = var2.cx1;
            int var9 = var2.cy1;
            Mob var6 = var2.mobFocus;

            label57:
            for(var3 = 0; var3 < vect_item_map.size(); ++var3) {
               ItemMap var7;
               Char.move((var7 = (ItemMap)vect_item_map.elementAt(var3)).xEnd, TileMap.d(var7.xEnd, var7.yEnd));
               var2.itemFocus = var7;

               for(int var8 = 0; var8 < 4 && var7.status != 2 && !var7.k; ++var8) {
                  Service.gI().pickItem(var7.itemMapID);
                  Service.gI().pickItem(var7.itemMapID);
                  if (phong1.c()) {
                     break;
                  }

                  if (this.check_nepk(var2.cx1, var2.cy1) || var2.cHP <= 0) {
                     break label57;
                  }
               }

               var7.k = true;
               var7.l = System.currentTimeMillis();
            }

            Char.move(var4, var9);
            var2.mobFocus = var6;
         }
      }

   }

   // Port TGAME: nhánh Hút VP - không move, chọn item hợp lệ gần nhất trong tầm Code.hutvpRange rồi gửi thẳng pickItem
   private void nhatdoHutVp(Char var1, int var2) {
      long var3 = System.currentTimeMillis();
      if (var3 - hutvpLastPickTime >= Code.hutvpPickDelay) {
         int var5 = this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh);
         ItemMap var6 = null;
         int var7 = Code.hutvpRange + 1;
         int var10 = GameScr.vItemMap.size();

         for (int var11 = 0; var11 < var10; ++var11) {
            ItemMap var12;
            if (this.isValidHutVpItem(var1, var2, var5, var12 = (ItemMap) GameScr.vItemMap.elementAt(var11))) {
               if (isHutVpItemIgnored(var12.itemMapID, var3)) {
                  continue;
               }

               int var13 = Res.a(var1.cx1, var1.cy1, var12.xEnd, var12.yEnd);
               if (var13 <= Code.hutvpRange && var13 < var7) {
                  var7 = var13;
                  var6 = var12;
               }
            }
         }

         if (var6 != null) {
            hutvpLastItemMapID = var6.itemMapID;
            var1.itemFocus = var6;
            Service.gI().pickItem(var6.itemMapID);
            hutvpLastPickTime = var3;
            ignoreHutVpItem(var6.itemMapID, var3, 500L);
         }
      }
   }

   private boolean isValidHutVpItem(Char var1, int var2, int var3, ItemMap var4) {
      return var4 != null
            && !var4.k
            && (var1.nClass.a == 1 && var4.template.id == 218
                  || (Code.check_nhatdo(var4.template) || var4.template.id == var2
                        || this instanceof AutoDanhVong && AutoDanhVong.dieukien == 4 && var4.template.type == 26)
                  && (Code.solg_hanhtrang() > 2 || var4.template.type == 19
                        || var4.template.isUpToUp && Code.check_item(var4.template.id)))
            && !this.check_thulinh(var3, var4.xEnd, var4.yEnd)
            && !this.check_nepk(var4.xEnd, var4.yEnd);
   }

   private static boolean isHutVpItemIgnored(int var0, long var1) {
      for (int var3 = 0; var3 < hutvpIgnoreItemMapIDs.length; ++var3) {
         if (hutvpIgnoreItemMapIDs[var3] == var0 && var1 < hutvpIgnoreUntilTimes[var3]) {
            return true;
         }
      }
      return false;
   }

   private static void ignoreHutVpItem(int var0, long var1, long var3) {
      int var5 = 0;

      for (int var6 = 0; var6 < hutvpIgnoreItemMapIDs.length; ++var6) {
         if (hutvpIgnoreItemMapIDs[var6] == var0 || var1 >= hutvpIgnoreUntilTimes[var6]) {
            var5 = var6;
            break;
         }

         if (hutvpIgnoreUntilTimes[var6] < hutvpIgnoreUntilTimes[var5]) {
            var5 = var6;
         }
      }

      hutvpIgnoreItemMapIDs[var5] = var0;
      long var7 = var1 + var3;
      if (var7 > hutvpIgnoreUntilTimes[var5]) {
         hutvpIgnoreUntilTimes[var5] = var7;
      }
   }

   // Gọi từ Controller khi nhận thông báo "Vật phẩm của người khác" để blacklist item vừa pick 3s
   public static void onHutVpForeignItemMessage(String var0) {
      if (Code.isHutVp && hutvpLastItemMapID >= 0) {
         long var1 = System.currentTimeMillis();
         ignoreHutVpItem(hutvpLastItemMapID, var1, 3000L);
         hutvpLastItemMapID = -1;
      }
   }

   protected static boolean isTanghinh() {
      Char var0;
      if ((var0 = Char.getMyChar()).isHuman) {
         for(int var1 = 0; var1 < var0.by.size(); ++var1) {
            Effect var2;
            if ((var2 = (Effect)var0.by.elementAt(var1)) != null && var2.e.b == 12) {
               return true;
            }
         }
      }

      return false;
   }

   public static void kobiet(SkillPaint var0) {
      if (vect_mons.size() > 0 || vect_player.size() > 0) {
         EffectPaint[] var1 = new EffectPaint[vect_mons.size() + vect_player.size()];

         int var2;
         for(var2 = 0; var2 < vect_mons.size(); ++var2) {
            var1[var2] = new EffectPaint();
            var1[var2].d = GameScr.ad[var0.a - 1];
            var1[var2].b = (Mob)vect_mons.elementAt(var2);
         }

         for(var2 = 0; var2 < vect_player.size(); ++var2) {
            var1[var2 + vect_mons.size()] = new EffectPaint();
            var1[var2 + vect_mons.size()].d = GameScr.ad[var0.a - 1];
            var1[var2 + vect_mons.size()].c = (Char)vect_player.elementAt(var2);
         }

         if (var1.length > 1) {
            EPosition var4 = new EPosition();
            if (var1[0].b != null) {
               var4 = new EPosition(var1[0].b.x1, var1[0].b.y1);
            } else if (var1[0].c != null) {
               var4 = new EPosition(var1[0].c.cx1, var1[0].c.cy1);
            }

            MyVector var5 = new MyVector();

            for(int var3 = 1; var3 < var1.length; ++var3) {
               if (var1[var3].b != null) {
                  var5.addElement(new EPosition(var1[var3].b.x1, var1[var3].b.y1));
               } else if (var1[var3].c != null) {
                  var5.addElement(new EPosition(var1[var3].c.cx1, var1[var3].c.cy1));
               }

               if (var3 > 5) {
                  break;
               }
            }

            Lightning.a(var5, var4, true, Char.getMyChar().t());
         }

         Char.getMyChar().hi = var1;
      }

   }

   protected final void switchPthan() {
      if (TileMap.mapID != 22) {
         this.remap(22, -2, -1, -1);
      } else {
         Char var1;
         if ((var1 = Char.getMyChar()).pthan != null) {
            GameScr.npc_b(12, 3, 0);
            phong1.aWait(500L);
         } else {
            for(int var2 = 0; var2 < var1.vSkillFight.size(); ++var2) {
               Skill var3;
               if ((var3 = (Skill)var1.vSkillFight.elementAt(var2)) != null && !var3.a() && var3.template.id >= 67 && var3.template.id <= 72) {
                  Service.gI().selectSkill(var3.template.id);
                  Service.gI().r();
                  phong1.aWait(500L);
                  break;
               }
            }

            phong.sleep(200L);
         }
      }

   }

   private static boolean check_pk(Char var0, Char var1) {
      return var1.statusMe != 14 && var1.statusMe != 5 && var1.statusMe != 15 && (var1.cTypePk == 3 || var0.cTypePk == 3 || var1.cTypePk == 1 && var0.cTypePk == 1 || var1.cTypePk == 5 && var0.cTypePk == 4 || var1.cTypePk == 4 && var0.cTypePk == 5 || var0.dc >= 0 && var0.dc == var1.idChar || var0.db >= 0 && var0.db == var1.idChar || var1.dc >= 0 && var1.dc == var0.idChar);
   }

   private static Char d(Char var0) {
      Char var1 = var0;
      int var2 = var0.cx1;
      int var3 = var0.cy1;
      var0 = null;
      Char var4 = Char.getMyChar();
      int var5 = var2 - var4.ae() - 10;
      int var6 = var2 + var4.ae() + 10;
      int var7 = var3 - var4.af() - (var4.nClass.a != 0 && var4.nClass.a != 1 && var4.nClass.a != 3 && var4.nClass.a != 5 ? 0 : 40);
      int var8 = var3 + var4.af() + (var4.nClass.a != 0 && var4.nClass.a != 1 && var4.nClass.a != 3 && var4.nClass.a != 5 ? 0 : 40);
      int var9 = -1;

      for(int var10 = 0; var10 < GameScr.vCharInMap.size(); ++var10) {
         Char var11 = (Char)GameScr.vCharInMap.elementAt(var10);
         int var12 = Math.abs(var2 - var11.cx1);
         int var13 = Math.abs(var3 - var11.cy1);
         var12 = var12 > var13 ? var12 : var13;
         if (var11 != null && var5 <= var11.cx1 && var11.cx1 <= var6 && var7 <= var11.cy1 && var11.cy1 <= var8 && !check_dead(var11) && check_pk(var4, var11) && !Code.check_nhom3(var11.cName) && !ListKO.a(var11.cName) && (var9 == -1 || var12 < var9)) {
            var0 = var11;
            var9 = var12;
         }
      }

      return var1.charFocus = var0;
   }

   private static Char get_char_fullmap() {
      Char var1 = Char.getMyChar();
      Char var2 = null;

      for(int var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
         Char var12;
         if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName)) {
            if (TileMap.isMapPK()) {
               if (check_pk(var1, var12)) {
                  var2 = var12;
               }
            } else {
               var2 = var12;
            }
         }
      }

      return var1.charFocus = var2;
   }

   private static Char get_char_fullmap_2() {
      Char var1 = Char.getMyChar();
      Char var2 = null;

      for(int var7 = 0; var7 < GameScr.vCharInMap.size(); ++var7) {
         Char var12;
         if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && ListPK.a(var12.cName)) {
            var2 = var12;
         }
      }

      return var1.charFocus = var2;
   }

   private static void tele_char(Char var0, long time_delay) {
      if (var0 != null) {
         Char var1 = Char.getMyChar();
         Char.move(var0.cx1, TileMap.d(var0.cx1, var0.cy1));
         var1.charFocus = var0;
         phong.sleep(time_delay);
      }

   }

   public static void CharFocus(Char var0) {
      Char.getMyChar().mobFocus = null;
      Char.getMyChar().v();
      Char.getMyChar().itemFocus = null;
      Char.getMyChar();
      Char.fg = true;
      Char.getMyChar().charFocus = var0;
   }

   private static boolean check_dan(ItemTemplate var28) {
      Char var3 = Char.getMyChar();

      for(int var8 = 0; var8 < var3.by.size(); ++var8) {
         Effect var10;
         if ((var10 = (Effect)var3.by.elementAt(var8)) != null && var10.e.c == var28.iconID) {
            return true;
         }
      }

      return false;
   }

   public static void autodan() {
      if (!check_dan(ItemTemplates.a((short)275)) && Code.get_item(275) != null) {
         Service.gI().useItem(Code.get_item(275).indexUI);
         phong.sleep(200L);
         check_dan(ItemTemplates.a((short)275));
      } else if (!check_dan(ItemTemplates.a((short)276)) && Code.get_item(276) != null) {
         Service.gI().useItem(Code.get_item(276).indexUI);
         phong.sleep(200L);
         check_dan(ItemTemplates.a((short)276));
      } else if (!check_dan(ItemTemplates.a((short)277)) && Code.get_item(277) != null) {
         Service.gI().useItem(Code.get_item(277).indexUI);
         phong.sleep(200L);
         check_dan(ItemTemplates.a((short)277));
      } else if (!check_dan(ItemTemplates.a((short)278)) && Code.get_item(278) != null) {
         Service.gI().useItem(Code.get_item(278).indexUI);
         phong.sleep(200L);
         check_dan(ItemTemplates.a((short)278));
      }
   }

   public static void d(Mob var0) {
      MyVector var1 = new MyVector();
      if (var0 != null && Char.move(var0.x1, var0.y1)) {
         Char.getMyChar().mobFocus = var0;
         var1.addElement(Char.getMyChar().mobFocus);
         Skill var2 = Char.getMyChar().myskill;
         if (System.currentTimeMillis() - var2.lastTimeUseThisSkill >= (long)var2.coolDown) {
            var2.lastTimeUseThisSkill = System.currentTimeMillis();
            Service.gI().sendPlayerAttack(var1, new MyVector(), 1);
            var2.l = true;
            Char var10000 = Char.getMyChar();
            var10000.cMaxMP -= var2.manaUse;
            if (var10000.cMaxMP < 0) {
               var10000.cMaxMP = 0;
            }

            if (!Code.dongbang_skill) {
               var10000.b(GameScr.aa[var2.template.id], 0);
            }
         }
      }

   }

   protected void akn(int type) {
      Char var3 = Char.getMyChar();
      if (!isTanghinh() && !isNoWar()) {
         Char var4 = var3.charFocus;
         if (var4 == null && this.bat_pk) {
            this.bat_pk = false;
            Service.gI().z(0);
         }

         if (var3.charFocus == null) {
            if (type == 1) {
               get_char_fullmap();
            } else if (type == 0) {
               d(var3);
            } else if (type == 2 || type == 3) {
               get_char_fullmap_2();
            }

            if (type == 3 && var3.charFocus == null) {
               this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
               return;
            }
         } else if (my_skill != null) {
            CharFocus(var4);
            Skill var5;
            if (type == 1) {
               var5 = Char.getMyChar().myskill;
            } else {
               var5 = my_skill;
            }

            int i;
            if (my_skill.a() && type != 1) {
               Skill var22;
               if (var3.nClass.a == 3) {
                  for(i = 0; i < var3.vSkill.size(); ++i) {
                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 25 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                        var5 = var22;
                        phong.sleep(500L);
                     }

                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 24 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown) {
                        vect_player.removeAllElements();
                        vect_player.addElement(var4);
                        var5 = var22;
                        Service.gI().selectSkill(var22.template.id);
                        Service.gI().sendPlayerAttack(new MyVector(), vect_player, 2);
                        var22.lastTimeUseThisSkill = System.currentTimeMillis();
                        var22.l = true;
                        if (!Code.dongbang_skill) {
                           var3.b(GameScr.aa[var22.template.id], 0);
                        }
                     }
                  }
               }

               if (var3.nClass.a == 1) {
                  for(i = 0; i < var3.vSkill.size(); ++i) {
                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 7 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                        var5 = var22;
                        phong.sleep(500L);
                     }
                  }
               }

               // [FIX 13-A] Xóa block class 2 ép skill 16 khi skill chính cooldown (không check dunghotro)
               // Class 2 muốn dùng skill phụ phải bật dunghotro — fallback ở nhánh bên dưới

               if (var3.nClass.a == 4) {
                  for(i = 0; i < var3.vSkill.size(); ++i) {
                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 34 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                        var5 = var22;
                        phong.sleep(500L);
                     }
                  }
               }

               if (var3.nClass.a == 5) {
                  for(i = 0; i < var3.vSkill.size(); ++i) {
                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 43 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                        var5 = var22;
                        phong.sleep(500L);
                     }
                  }
               }

               if (var3.nClass.a == 6) {
                  for(i = 0; i < var3.vSkill.size(); ++i) {
                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.type == 2 && (var22.template.id < 67 || var22.template.id > 72) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                        var5 = var22;
                        phong.sleep(500L);
                     }
                  }
               }
            }

            if (var5.template.type == 2) {
               if (System.currentTimeMillis() - var5.lastTimeUseThisSkill >= (long)var5.coolDown) {
                  Service.gI().selectSkill(var5.template.id);
                  Service.gI().r();
                  var5.lastTimeUseThisSkill = System.currentTimeMillis();
                  var5.l = true;
                  phong.sleep(100L);
                  return;
               }
            } else {
               if ((var5.template.type == 1 || var5.template.type == 3) && (Math.abs(var3.cx1 - var4.cx1) > var5.dx || Math.abs(var3.cy1 - var4.cy1) > var5.dy)) {
                  if (type != 1 && type != 2 && type != 3 && type != -1) {
                     return;
                  }

                  if (System.currentTimeMillis() - this.time_tele >= 300L) {
                     tele_char(var4, 25L);
                     this.time_tele = System.currentTimeMillis();
                     return;
                  }
               }

               if (ListPK.a(var4.cName) && (type == 2 || type == 3)) {
                  if (!Code.isCuuSat) {
                     if (var3.cTypePk != 3 && var4.cTypePk != 3) {
                        Service.gI().z(3);
                        this.bat_pk = true;
                     }
                  } else if (Char.getMyChar().dc != var4.idChar || Char.getMyChar().idChar != var4.dc) {
                     Service.gI().w(var4.idChar);
                  }
               }

               int var6 = var5.dx;
               i = var5.dy;
               vect_player.removeAllElements();
               vect_mons.removeAllElements();
               vect_player.addElement(var4);

               for(int var7 = 0; var7 < GameScr.vCharInMap.size() && vect_mons.size() + vect_player.size() < var5.maxFight; ++var7) {
                  Char var12;
                  if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var4) && (var12.cTypePk == 3 || var3.cTypePk == 3 || var12.cTypePk == 1 && var3.cTypePk == 1 || var3.dc >= 0 && var3.dc == var12.idChar || var3.db >= 0 && var3.db == var12.idChar || var12.dc == var3.idChar) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && var4.cx1 - var6 <= var12.cx1 && var12.cx1 <= var4.cx1 + var6 && var4.cy1 - i <= var12.cy1 && var12.cy1 <= var4.cy1 + i) {
                     vect_player.addElement(var12);
                  }
               }

               for(int var26 = 0; var26 < GameScr.vMob.size() && vect_mons.size() + vect_player.size() < var5.maxFight; ++var26) {
                  Mob var24;
                  if ((var24 = (Mob)GameScr.vMob.elementAt(var26)).status != 0 && var24.status != 1 && var4.cx1 - 100 <= var24.i && var24.i <= var4.cx1 + 100 && var4.cy1 - 50 <= var24.j && var24.j <= var4.cy1 + 50 && check_quai2(var24.levelBoss, 8)) {
                     vect_mons.addElement(var24);
                  }
               }

               this.a(var5.template.id);
               Service.gI().sendPlayerAttack(vect_mons, vect_player, 2);
            }

            if (System.currentTimeMillis() - var5.lastTimeUseThisSkill >= (long)var5.coolDown) {
               var5.lastTimeUseThisSkill = System.currentTimeMillis();
               var5.l = true;
            }
         }
      }

   }

   static boolean isContainPK() {
      for(int i = 0; i < GameScr.vCharInMap.size(); ++i) {
         Char var1 = (Char)GameScr.vCharInMap.elementAt(i);
         if (ListPK.a(var1.cName)) {
            return true;
         }
      }

      return false;
   }

   private static Char get_char_focus() {
      Char char_ = null;
      Char getMyChar = Char.getMyChar();

      for(int i = 0; i < GameScr.vCharInMap.size(); ++i) {
         Char var1 = (Char)GameScr.vCharInMap.elementAt(i);
         if (var1 != null && !check_dead(var1) && var1 != Char.getMyChar()) {
            if (TileMap.isMapPK()) {
               if (!var1.ab() && !ListKO.a(var1.cName) && (getMyChar.cTypePk == 4 && var1.cTypePk == 5 || getMyChar.cTypePk == 5 && var1.cTypePk == 4)) {
                  if (!isContainPK()) {
                     Char.getMyChar().charFocus = var1;
                     return var1;
                  }

                  if (ListPK.a(var1.cName)) {
                     Char.getMyChar().charFocus = var1;
                     return var1;
                  }
               }
            } else if (!Code.check_nhom3(var1.cName) && !ListKO.a(var1.cName)) {
               if (Setting.mode_1 == 2) {
                  if (var1.cTypePk == 3 || Char.getMyChar().idChar == var1.dc || var1.cTypePk == 1) {
                     if (Setting.mode_3 == 1) {
                        if (Setting.mode_2 == 1) {
                           if (ListPK.a(var1.cName) && checkKCPK(var1)) {
                              Char.getMyChar().charFocus = var1;
                              return var1;
                           }
                        } else if (ListPK.a(var1.cName)) {
                           Char.getMyChar().charFocus = var1;
                           return var1;
                        }
                     } else {
                        if (Setting.mode_2 != 1) {
                           Char.getMyChar().charFocus = var1;
                           return var1;
                        }

                        if (checkKCPK(var1)) {
                           Char.getMyChar().charFocus = var1;
                           return var1;
                        }
                     }
                  }
               } else if (Setting.mode_3 == 1) {
                  if (Setting.mode_2 == 1) {
                     if (ListPK.a(var1.cName) && checkKCPK(var1)) {
                        Char.getMyChar().charFocus = var1;
                        return var1;
                     }
                  } else if (ListPK.a(var1.cName)) {
                     Char.getMyChar().charFocus = var1;
                     return var1;
                  }
               } else {
                  if (Setting.mode_2 != 1) {
                     Char.getMyChar().charFocus = var1;
                     return var1;
                  }

                  if (checkKCPK(var1)) {
                     Char.getMyChar().charFocus = var1;
                     return var1;
                  }
               }
            }
         }
      }

      return null;
   }

   private static boolean checkKCPK(Char var0) {
      Char var4 = Char.getMyChar();
      int var2 = var4.cx1;
      int var3 = var4.cy1;
      int var5 = var2 - var4.ae();
      int var6 = var2 + var4.ae();
      int var7 = var3 - var4.af();
      int var8 = var3 + var4.af();
      int var9 = -1;
      int var12 = Math.abs(var2 - var0.cx1);
      int var13 = Math.abs(var3 - var0.cy1);
      var12 = var12 > var13 ? var12 : var13;
      return var0 != null && var5 <= var0.cx1 && var0.cx1 <= var6 && var7 <= var0.cy1 && var0.cy1 <= var8 && (var9 == -1 || var12 < var9);
   }

   private static boolean checkKCPK(Char var0, Char var1) {
      return Math.abs(var0.cx1 - var1.cx1) <= 50 && Math.abs(var0.cy1 - var1.cy1) <= 50;
   }

   protected static boolean isNoWar() {
      Char var0;
      if ((var0 = Char.getMyChar()).isHuman) {
         for(int var1 = 0; var1 < var0.by.size(); ++var1) {
            Effect var2;
            if ((var2 = (Effect)var0.by.elementAt(var1)) != null && var2.e.b == 10 && var2.e.a == 14) {
               return true;
            }
         }
      }

      return false;
   }

   protected final void autopk() {
      Char var3 = Char.getMyChar();
      if (var3.cPk >= Setting.hieuchien && Setting.hlct && System.currentTimeMillis() - this.time_hlct >= 1500L && Code.get_item(257) != null) {
         this.time_hlct = System.currentTimeMillis();
         Service.gI().useItem(Code.get_item(257).indexUI);
      }

      if (!isTanghinh() && !isNoWar()) {
         Char var4 = var3.charFocus;
         vect_player.removeAllElements();
         vect_mons.removeAllElements();
         if (var4 == null) {
            if (Char.getMyChar().cTypePk == 3 && Setting.mode_1 != 3) {
               Service.gI().z(0);
            }

            var4 = get_char_focus();
            if (var4 == null && Setting.mode_4 == 0) {
               this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
               return;
            }

            phong.CharFocus(var4);
            if (Setting.mode_2 == 0) {
               tele_char(var4, 10L);
            }

            return;
         }

         if (Setting.mode_2 == 1 && !checkKCPK(var4)) {
            var3.charFocus = null;
            return;
         }

         if (ListKO.a(var4.cName)) {
            var3.charFocus = null;
            return;
         }

         if (Setting.mode_3 == 1 && !ListPK.a(var4.cName)) {
            var3.charFocus = null;
            return;
         }

         if (System.currentTimeMillis() - this.time_tele >= Code.time_tele_1 && Setting.mode_2 == 0) {
            tele_char(var4, Code.delay_tele);
            this.time_tele = System.currentTimeMillis();
         }

         Skill var5 = null;
         if (Char.dunghotro) {
            var5 = my_skill;
         } else {
            var5 = Char.getMyChar().myskill;
         }

         if (var5 != null) {
            int i;
            if (var5.a()) {
               Skill var22;
               if (Code.check_item(545) && Char.dung_pthan && Char.getMyChar().pthan == null) {
                  for(i = 0; i < var3.vSkill.size(); ++i) {
                     if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id >= 67 && var22.template.id <= 72 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                        var5 = var22;
                        phong.sleep(500L);
                     }
                  }
               }

               if (Char.dunghotro) {
                  if (var3.nClass.a == 3) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 24 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown) {
                           vect_player.removeAllElements();
                           vect_player.addElement(var4);
                           var5 = var22;
                           Service.gI().selectSkill(var22.template.id);
                           Service.gI().sendPlayerAttack(new MyVector(), vect_player, 2);
                           var22.lastTimeUseThisSkill = System.currentTimeMillis();
                           var22.l = true;
                           if (!Code.dongbang_skill) {
                              var3.b(GameScr.aa[var22.template.id], 0);
                           }
                        }
                     }
                  }

                  if (var3.nClass.a == 6) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.type == 2 && (var22.template.id < 67 || var22.template.id > 72) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var5 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 4) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.type == 2 && var22.template.type != 31 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var5 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 3) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 25 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var5 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 2) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && (var22.template.id == 13 || var22.template.id == 16) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var5 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 1) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && var22.template.id == 7 && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var5 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }

                  if (var3.nClass.a == 5) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && (var22.template.id == 42 || var22.template.id == 43) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var5 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }
               } else {
                  // [FIX 13-B] Xóa block class 2 ép skill 16 khi dunghotro=false
                  // Khi tắt hỗ trợ: class 2 giữ skill chính, không ép skill 16
                  // Chỉ giữ class 6 fallback (giống havan)

                  if (var3.nClass.a == 6) {
                     for(i = 0; i < var3.vSkill.size(); ++i) {
                        if ((var22 = (Skill)var3.vSkill.elementAt(i)) != null && (var22.template.id == 51 || var22.template.id == 52) && System.currentTimeMillis() - var22.lastTimeUseThisSkill >= (long)var22.coolDown - 300L) {
                           var5 = var22;
                           phong.sleep(500L);
                        }
                     }
                  }
               }
            }

            i = var5.dx;
            int var11 = var5.dy;
            if (var5.template.type == 2) {
               Service.gI().selectSkill(var5.template.id);
               Service.gI().r();
               var5.lastTimeUseThisSkill = System.currentTimeMillis();
               var5.l = true;
               if (!Code.dongbang_skill) {
                  var3.b(GameScr.aa[var5.template.id], 0);
               }

               phong.sleep(500L);
               return;
            }

            if (!TileMap.isMapPK()) {
               label718: {
                  switch (Setting.mode_1) {
                     case 0:
                        if (Char.getMyChar().dc != var4.idChar || Char.getMyChar().idChar != var4.dc) {
                           Service.gI().w(var4.idChar);
                           break label718;
                        }
                     case 1:
                        if (Char.getMyChar().cTypePk == 3 && var4.cTypePk == 3) {
                           break;
                        }

                        Service.gI().z(3);
                     case 2:
                     default:
                        break label718;
                     case 3:
                  }

                  if (Char.getMyChar().cTypePk != 3) {
                     Service.gI().z(3);
                  }
               }
            }

            vect_player.removeAllElements();
            vect_player.addElement(var4);
            int var7;
            Char var12;
            if (Setting.mode_3 == 1) {
               if (Setting.mode_2 != 1) {
                  for(var7 = 0; var7 < GameScr.vCharInMap.size() && vect_player.size() < var5.maxFight; ++var7) {
                     if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var4) && (var12.cTypePk == 3 || var3.cTypePk == 3 || var12.cTypePk == 1 && var3.cTypePk == 1 || var3.dc >= 0 && var3.dc == var12.idChar || var3.db >= 0 && var3.db == var12.idChar) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && ListPK.a(var12.cName)) {
                        vect_player.addElement(var12);
                     }
                  }
               } else {
                  for(var7 = 0; var7 < GameScr.vCharInMap.size() && vect_player.size() < var5.maxFight; ++var7) {
                     if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var3) && (var12.cTypePk == 3 || var3.cTypePk == 3 || var12.cTypePk == 1 && var3.cTypePk == 1 || var3.dc >= 0 && var3.dc == var12.idChar || var3.db >= 0 && var3.db == var12.idChar) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && checkKCPK(var12) && ListPK.a(var12.cName)) {
                        vect_player.addElement(var12);
                     }
                  }

                  for(var7 = 0; var7 < GameScr.vCharInMap.size() && vect_player.size() < var5.maxFight; ++var7) {
                     if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var4) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && checkKCPK(var12, var4)) {
                        vect_player.addElement(var12);
                     }
                  }
               }
            } else if (Setting.mode_2 != 1) {
               for(var7 = 0; var7 < GameScr.vCharInMap.size() && vect_player.size() < var5.maxFight; ++var7) {
                  if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var4) && (var12.cTypePk == 3 || var3.cTypePk == 3 || var12.cTypePk == 1 && var3.cTypePk == 1 || var3.dc >= 0 && var3.dc == var12.idChar || var3.db >= 0 && var3.db == var12.idChar) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && var4.cx1 - i <= var12.cx1 && var12.cx1 <= var4.cx1 + i && var4.cy1 - var11 <= var12.cy1 && var12.cy1 <= var4.cy1 + var11) {
                     vect_player.addElement(var12);
                  }
               }

               for(var7 = 0; var7 < GameScr.vCharInMap.size() && vect_player.size() < var5.maxFight; ++var7) {
                  if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var4) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && checkKCPK(var12, var4)) {
                     vect_player.addElement(var12);
                  }
               }
            } else {
               for(var7 = 0; var7 < GameScr.vCharInMap.size() && vect_player.size() < var5.maxFight; ++var7) {
                  if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var3) && (var12.cTypePk == 3 || var3.cTypePk == 3 || var12.cTypePk == 1 && var3.cTypePk == 1 || var3.dc >= 0 && var3.dc == var12.idChar || var3.db >= 0 && var3.db == var12.idChar) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && checkKCPK(var12)) {
                     vect_player.addElement(var12);
                  }
               }

               for(var7 = 0; var7 < GameScr.vCharInMap.size() && vect_player.size() < var5.maxFight; ++var7) {
                  if ((var12 = (Char)GameScr.vCharInMap.elementAt(var7)).cHP > 0 && var12.statusMe != 14 && var12.statusMe != 5 && var12.statusMe != 15 && !var12.equals(var4) && !Code.check_nhom3(var12.cName) && !ListKO.a(var12.cName) && checkKCPK(var12, var4)) {
                     vect_player.addElement(var12);
                  }
               }
            }

            if (vect_player.size() > 0 && System.currentTimeMillis() - var5.lastTimeUseThisSkill >= (long)var5.coolDown) {
               Service.gI().selectSkill(var5.template.id);
               Service.gI().sendPlayerAttack(new MyVector(), vect_player, 2);
               var5.lastTimeUseThisSkill = System.currentTimeMillis();
               var5.l = true;
               if (!Code.dongbang_skill) {
                  var3.b(GameScr.aa[var5.template.id], 0);
               }
            }
         }
      }

   }

   protected abstract void auto();

   public abstract String toString();

}
