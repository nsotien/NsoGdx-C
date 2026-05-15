package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Npc extends Char {
   public NpcTemplate npcTemplate;
   public static NpcTemplate[] arrNpcTemplate;

   public Npc(int var1, int var2, int var3, int var4, int var5) {
      super.cx1 = var3;
      super.cy1 = var4;
      super.statusMe = var2;
      this.npcTemplate = arrNpcTemplate[var5];
   }

   public static void phong_ae() {
      for(int var0 = 0; var0 < GameScr.vNpc.size(); ++var0) {
         Npc var1;
         (var1 = (Npc)GameScr.vNpc.elementAt(var0)).ev = null;
         var1.eu = -1;
      }

   }

   public final void h() {
      if (super.ev == null) {
         label47: {
            label53: {
               byte[] var1 = new byte[]{-1, 9, 9, 10, 10, 11, 11};
               if (Char.getMyChar().ctaskId >= 9 && Char.getMyChar().ctaskId <= 10 && Char.getMyChar().nClass.a > 0 && var1[Char.getMyChar().nClass.a] == this.npcTemplate.npcTemplateId) {
                  if (Char.getMyChar().ca != null) {
                     if (Char.getMyChar().ca == null || Char.getMyChar().ca.a + 1 != Char.getMyChar().ca.e.length) {
                        break label47;
                     }

                     super.ev = GameScr.ad[62];
                     break label53;
                  }
               } else {
                  GameScr.gI();
                  byte var2 = GameScr.af();
                  if (Char.getMyChar().ca != null || var2 != this.npcTemplate.npcTemplateId) {
                     if (Char.getMyChar().ca == null || var2 != this.npcTemplate.npcTemplateId) {
                        break label47;
                     }

                     if (Char.getMyChar().ca.a + 1 == Char.getMyChar().ca.e.length) {
                        super.ev = GameScr.ad[62];
                        break label53;
                     }
                  }
               }

               super.ev = GameScr.ad[57];
            }

            super.eu = 0;
         }
      }

      super.h();
   }

   public final void a(mGraphics var1) {
      if (this.q() && super.statusMe != 15) {
         if (super.cTypePk != 0) {
            super.a(var1);
         } else if (this.npcTemplate != null) {
            if (this.npcTemplate.npcTemplateId == 13) {
               if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                  SmallImage.a(var1, 988, super.cx1, super.cy1 - super.bg - 1, 0, 33);
               }

               SmallImage.a(var1, 1060, super.cx1, super.cy1, 0, 33);
               mFont.i.a(var1, String.valueOf(TileMap.zoneID), super.cx1, super.cy1 - 10 - 2 - mFont.g.c(), 2);
            } else if (this.npcTemplate.npcTemplateId == 31) {
               if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                  SmallImage.a(var1, 988, super.cx1, super.cy1 - super.bg - 1, 0, 33);
               }

               SmallImage.a(var1, 1291, super.cx1, super.cy1, 0, 33);
            } else if (this.npcTemplate.npcTemplateId == 27) {
               if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                  SmallImage.a(var1, 988, super.cx1, super.cy1 - super.bg - 1, 0, 33);
               }

               SmallImage.a(var1, 1224, super.cx1, super.cy1, 0, 33);
            } else {
               Part var2 = GameScr.ac[this.npcTemplate.headId];
               Part var3 = GameScr.ac[this.npcTemplate.legId];
               Part var4 = GameScr.ac[this.npcTemplate.bodyId];
               if (super.cdir == 1) {
                  SmallImage.a(var1, var2.a[Char.ea[super.bm][0][0]].a, super.cx1 + Char.ea[super.bm][0][1] + var2.a[Char.ea[super.bm][0][0]].b, super.cy1 - Char.ea[super.bm][0][2] + var2.a[Char.ea[super.bm][0][0]].c, 0, 0);
                  SmallImage.a(var1, var3.a[Char.ea[super.bm][1][0]].a, super.cx1 + Char.ea[super.bm][1][1] + var3.a[Char.ea[super.bm][1][0]].b, super.cy1 - Char.ea[super.bm][1][2] + var3.a[Char.ea[super.bm][1][0]].c, 0, 0);
                  SmallImage.a(var1, var4.a[Char.ea[super.bm][2][0]].a, super.cx1 + Char.ea[super.bm][2][1] + var4.a[Char.ea[super.bm][2][0]].b, super.cy1 - Char.ea[super.bm][2][2] + var4.a[Char.ea[super.bm][2][0]].c, 0, 0);
               } else {
                  SmallImage.a(var1, var2.a[Char.ea[super.bm][0][0]].a, super.cx1 - Char.ea[super.bm][0][1] - var2.a[Char.ea[super.bm][0][0]].b, super.cy1 - Char.ea[super.bm][0][2] + var2.a[Char.ea[super.bm][0][0]].c, 2, 24);
                  SmallImage.a(var1, var3.a[Char.ea[super.bm][1][0]].a, super.cx1 - Char.ea[super.bm][1][1] - var3.a[Char.ea[super.bm][1][0]].b, super.cy1 - Char.ea[super.bm][1][2] + var3.a[Char.ea[super.bm][1][0]].c, 2, 24);
                  SmallImage.a(var1, var4.a[Char.ea[super.bm][2][0]].a, super.cx1 - Char.ea[super.bm][2][1] - var4.a[Char.ea[super.bm][2][0]].b, super.cy1 - Char.ea[super.bm][2][2] + var4.a[Char.ea[super.bm][2][0]].c, 2, 24);
               }

               if (super.eu >= 0 && super.ev != null && super.cTypePk == 0) {
                  SmallImage.a(var1, super.ev.b[super.eu].c, super.cx1 + super.ev.b[super.eu].a, super.cy1 + super.ev.b[super.eu].b, 0, 3);
                  if (GameCanvas.w % 2 == 0) {
                     ++super.eu;
                     if (super.eu >= super.ev.b.length) {
                        super.eu = 0;
                     }
                  }
               }

               if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                  mFont.j.a(var1, this.npcTemplate.name, super.cx1, super.cy1 - super.bg - mFont.g.c() - 7, 2, mFont.k);
                  SmallImage.a(var1, 988, super.cx1, super.cy1 - super.bg - 2, 0, 33);
               } else {
                  mFont.j.a(var1, this.npcTemplate.name, super.cx1, super.cy1 - super.bg - 3 - mFont.g.c(), 2, mFont.k);
               }
            }
         }
      }

   }

}
