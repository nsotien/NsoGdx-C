package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class AutoBuff extends Auto {
   private boolean isBuff;
   private boolean isHoiSinh;
   private long x = 0L;

   public final void a(int var1, int var2, boolean var3, boolean var4) {
      super.reset();
      super.map_auto = var1;
      super.khu_auto = var2;
      super.isPhoban = TileMap.isPhuBan(var1);
      this.isBuff = var3;
      this.isHoiSinh = var4;
      this.danh_nhom = true;
   }

   public boolean notLeader() {
      return this.danh_nhom && GameScr.vParty.size() > 0 && ((Party)GameScr.vParty.firstElement()).a != Char.getMyChar().idChar;
   }

   public final void auto() {
      if (Auto.check_dead(Char.getMyChar())) {
         Auto.hoisinh(true);
      } else if (super.map_auto != TileMap.mapID || !super.isPhoban && super.khu_auto != TileMap.zoneID) {
         this.remap(super.map_auto, super.khu_auto, -1, -1);
      } else {
         Code.gkn();
         Char var1 = Char.getMyChar();
         int var5;
         int var6;
         int var10;
         Skill var3;
         if (this.isHoiSinh && GameScr.vParty.size() > 1 && var1.nClass.a == 6) {
            for(var10 = 0; var10 < var1.vSkill.size(); ++var10) {
               if ((var3 = (Skill)var1.vSkill.elementAt(var10)) != null && var3.template.type == 4) {
                  if (System.currentTimeMillis() - this.x > 3000L) {
                     for(int var4 = 0; var4 < GameScr.vParty.size(); ++var4) {
                        Party var8;
                        if ((var8 = (Party)GameScr.vParty.elementAt(var4)).a != var1.idChar && var8.f != null && var8.f.cHP <= 0) {
                           var5 = var1.cx1;
                           var6 = var1.cy1;
                           Char var14;
                           Char.move((var14 = var8.f).cx1, var14.cy1);
                           phong.sleep(500L);
                           if (Auto.check_dead(var14)) {
                              this.x = System.currentTimeMillis();
                              Service.gI().x(var8.a);
                              var3.lastTimeUseThisSkill = System.currentTimeMillis();
                              var3.l = true;
                              var1.b(GameScr.aa[var3.template.id], 0);
                              phong.sleep(1000L);
                           }

                           Char.move(var5, var6);
                           return;
                        }
                     }
                  }
                  break;
               }
            }
         }

         Char var9 = GameScr.vParty.size() > 0 ? ((Party)GameScr.vParty.firstElement()).f : null;
         if (this.isBuff && this.notLeader() && var9 != null && var1.nClass.a == 6) {
            for(var10 = 0; var10 < var1.vSkill.size(); ++var10) {
               // Port TGAME fix buff xịt: bỏ filter riêng skill 47 theo HP<90% để logic chọn skill giống demo
               if ((var3 = (Skill)var1.vSkill.elementAt(var10)) != null && !var3.a() && var3.template.type == 2 && (var3.template.id < 67 || var3.template.id > 72)) {
                  System.currentTimeMillis();

                  for(var5 = 0; var5 < var9.vSkill.size(); ++var5) {
                     var9.vSkill.elementAt(var5);
                  }

                  var5 = var1.cx1;
                  var6 = var1.cy1;
                  // Port TGAME fix buff xịt: move -> sleep 200ms -> move lại theo toạ độ trưởng nhóm mới nhất -> cast
                  Char.move(var9.cx1, var9.cy1);
                  phong.sleep(200L);
                  Char.move(var9.cx1, var9.cy1);
                  Service.gI().selectSkill(var3.template.id);
                  Service.gI().r();
                  var3.lastTimeUseThisSkill = System.currentTimeMillis();
                  var3.l = true;
                  var1.b(GameScr.aa[var3.template.id], 0);
                  phong.sleep(1500L);
                  Char.move(var5, var6);
                  return;
               }
            }
         }
      }

   }

   public final String toString() {
      if (this.isBuff && this.isHoiSinh) {
         return "Buff HS Xa";
      } else {
         return this.isHoiSinh ? "HSinh Xa" : "Buff Xa";
      }
   }

}
