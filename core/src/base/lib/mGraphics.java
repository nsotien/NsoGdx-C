package base.lib;

import com.badlogic.gdx.graphics.g2d.Sprite;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class mGraphics {
   public Graphics gameAA;
   public static int zoomLevel = 1;
   public Graphics a;

   public mGraphics(Graphics var1) {
      this.gameAA = var1;
        this.a = this.gameAA;
   }

   public mGraphics() {
   }

   public final void gameAA(Image var1, int var2, int var3, int var4) {
      if(var1 == null) {
         return;
      }
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      this.gameAA.drawImage(var1.getTexture(), var2, var3, var4);
   }
   public final void fieldAE(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.gameAA.drawArc(var1, var2, var3, var4, 0, 360);
   }
   public final void gameAA(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.gameAA.drawLine(var1, var2, var3, var4);
   }

   public final void gameAB(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.gameAA.drawRect(var1, var2, var3, var4);
   }

   public final void gameAA(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var7 *= zoomLevel;
      var8 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      var5 *= zoomLevel;
      this.gameAA.drawRegion(var1.getTexture(), var2, var3, var4, var5, var6, var7, var8, var9);
   }
   public final void gameAA(Sprite var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var7 *= zoomLevel;
      var8 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      var5 *= zoomLevel;
      this.gameAA.drawRegion(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public final void gameAA(int var1, int var2, int var3, int var4, int var5, int var6) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      var5 *= zoomLevel;
      var6 *= zoomLevel;
//      this.gameAA.drawRoundRect(var1, var2, var3, var4, var5, var6);
   }

   public final void gameAC(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.gameAA.fillRect(var1, var2, var3, var4);
   }

   public final void gameAB(int var1, int var2, int var3, int var4, int var5, int var6) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      var5 *= zoomLevel;
      var6 *= zoomLevel;
      this.gameAA.fillRoundRect(var1, var2, var3, var4, var5, var6);
   }

   public final int gameAA() {
      return this.gameAA.getTranslateX() / zoomLevel;
   }

   public final int gameAB() {
      return this.gameAA.getTranslateY() / zoomLevel;
   }

   public final void gameAD(int var1, int var2, int var3, int var4) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      var3 *= zoomLevel;
      var4 *= zoomLevel;
      this.gameAA.setClip(var1, var2, var3, var4);
   }

   public final void gameAA(int var1) {
      this.gameAA.setColor(var1);
   }

   public final void gameAA(int var1, int var2) {
      var1 *= zoomLevel;
      var2 *= zoomLevel;
      this.gameAA.translate(var1, var2);
   }

   public static int gameAA(Image var0) {
      if (var0 == null) {
         return 0;
      }
      return var0.getWidth();
   }

   public static int gameAB(Image var0) {
      if (var0 == null) {
         return 0;
      }
      return var0.getHeight();
   }
}
