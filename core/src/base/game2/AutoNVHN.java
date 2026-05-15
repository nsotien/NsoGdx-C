package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class AutoNVHN extends Auto {
   public static boolean a;
   private static String[] w;
   private static int x;
   private TaskOrder y;
   private boolean fastReturnOnStart;
   private int schoolMapId = 1;
   private long lastTusatForReturn = 0L;

   private static void m() {
      a = false;
      w = new String[]{"Hôm nay con đã làm hết nhiệm vụ ta giao. Hãy quay lại vào ngày hôm sau.", "Đây là lần nhận nhiệm vụ thứ ", " trong ngày hôm nay. Mỗi ngày được nhận tối đa 20 lần con nhé."};
   }

   public static void a(String var0) {
      if (var0.equals(w[0])) {
         x = 21;
         phong1.l();
      } else {
         int var1;
         if ((var1 = var0.indexOf(w[1])) >= 0) {
            var0 = var0.substring(var1 + w[1].length(), var0.indexOf(w[2])).trim();

            try {
               x = Integer.parseInt(var0);
               return;
            } catch (NumberFormatException var3) {
            }
         }
      }

   }

   public final void a() {
      x = 0;
      super.reset();
      this.schoolMapId = TileMap.isTruong(TileMap.mapID) ? TileMap.mapID : 1;
      this.lastTusatForReturn = 0L;
      this.y = Char.get_nvhn(0);
      this.updateTargetMap();
   }

   public final void resetAfterLogin() {
      if (TileMap.isTruong(TileMap.mapID)) this.schoolMapId = TileMap.mapID;
      this.y = Char.get_nvhn(0);
      this.updateTargetMap();
   }

   public final void requestFastReturnOnStart() {
      this.fastReturnOnStart = true;
   }

   private void updateTargetMap() {
      if (this.y != null) {
         super.map_auto = this.y.g;
         super.isPhoban = TileMap.isPhuBan(this.y.g);
      } else if (TileMap.isTruong(TileMap.mapID)) {
         super.map_auto = TileMap.mapID;
         super.isPhoban = false;
      } else {
         super.map_auto = 1;
         super.isPhoban = false;
      }
   }

   private boolean tryFastReturnOnStart() {
      if (!this.fastReturnOnStart) {
         return false;
      }

      if (TileMap.isTruong(TileMap.mapID) || TileMap.isLang(TileMap.mapID)) {
         this.fastReturnOnStart = false;
         return false;
      }

      Auto.tusat_vdmq();
      return true;
   }

   private void ensureFightSkill() {
      if (Auto.my_skill != null && Auto.my_skill.template.type != 2 && Auto.my_skill.template.type != 4) {
         return;
      }

      Char var1 = Char.getMyChar();
      for (int var2 = 0; var2 < var1.vSkillFight.size(); ++var2) {
         Skill var3;
         if ((var3 = (Skill)var1.vSkillFight.elementAt(var2)) != null) {
            Auto.my_skill = var3;
            Auto.fix_skill = var3;
            var1.myskill = var3;
            Service.gI().selectSkill(var3.template.id);
            return;
         }
      }
   }

   public final void auto() {
      if (x <= 20) {
         if (check_dead(Char.getMyChar())) {
            Auto.hoisinh(false);
            return;
         }

         if (this.tryFastReturnOnStart()) {
            return;
         }

         // Port pattern AutoDanhVong: khi NV đủ count → về trường trả qua 3 bước
         if (this.y != null && this.y.b >= this.y.c) {
            // Step 1: không ở làng/trường → tự sát về điểm lưu (throttle 8s tránh spam)
            if (!TileMap.isTruong(TileMap.mapID) && !TileMap.isLang(TileMap.mapID)) {
               long now = System.currentTimeMillis();
               if (now - this.lastTusatForReturn > 8000L) {
                  this.lastTusatForReturn = now;
                  Auto.tusat_vdmq();
                  phong.sleep(500L);
               }
               return;
            }
            // Step 2: hồi sinh ở làng → remap tới trường đã lưu khi khởi động
            if (TileMap.isLang(TileMap.mapID)) {
               this.remap(this.schoolMapId, -2, -1, -1);
               return;
            }
            // Step 3: isTruong → fall-through xuống flow isTruong bên dưới
         }

         if (TileMap.isTruong(TileMap.mapID)) {
            if (this.y == null) {
               Code.popup_chat("Nhận NV " + (x + 1) + "/20");
               GameScr.npc_b(25, 1, 0);
               phong1.k();
               this.y = Char.get_nvhn(0);
               this.updateTargetMap();
               return;
            }

            if (this.y.b >= this.y.c) {
               if (Code.solg_hanhtrang() <= 0) {
                  Code.popup_chat("Hành trang đầy");
                  return;
               }

               Code.popup_chat("Hoàn thành NV " + x + "/20");
               GameScr.npc_b(25, 1, 2);
               phong.sleep(1000L);
               if (Code.solg_hanhtrang() < 6) {
                  Code.popup_chat("Hành trang dưới 6 ô, dừng Auto NVHN");
                  Code.remode();
                  return;
               }

               this.y = null;
               return;
            }

            Code.popup_chat("Đi làm NV " + x + "/20");
            GameScr.npc_b(25, 1, 3);
            TileMap.f();
            for (int var1 = 0; var1 < 40 && TileMap.mapID != this.y.g; ++var1) {
               phong.sleep(100L);
            }

            if (TileMap.mapID != this.y.g) {
               this.remap(this.y.g, -2, -1, -1);
            }

            return;
         }

         if (this.y != null && TileMap.mapID == this.y.g) {
            this.ensureFightSkill();
            this.attack(this.y.f, 3);
            if (a) {
               Code.popup_chat("Nhiệm vụ " + x + "/20: " + this.y.b + "/" + this.y.c + " " + Mob.b[this.y.f].g);
               a = false;
               return;
            }

            return;
         }

         if (TileMap.mapID != super.map_auto) {
            if (this.y != null) {
               this.updateTargetMap();
               this.remap(this.y.g, -2, -1, -1);
            } else {
               if (!TileMap.isTruong(super.map_auto)) {
                  super.map_auto = 1;
               }

               this.remap(super.map_auto, -2, -1, -1);
            }
            return;
         }
      } else {
         Code.popup_chat("Hoàn thành!");
         Code.remode();
      }

   }

   public final String toString() {
      return "Auto Nhiệm vụ hằng ngày: " + x + "/20";
   }

   static {
      m();
   }
}
