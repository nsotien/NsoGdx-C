package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class CharPartInfo {
   public static mHashtable a = new mHashtable();
   public static mHashtable b = new mHashtable();
   public static mHashtable c = new mHashtable();
   public static mHashtable d = new mHashtable();
   public static mHashtable e = new mHashtable();
   public static mHashtable f = new mHashtable();
   private static mHashtable l = new mHashtable();
   public mHashtable g = new mHashtable();
   public static mHashtable h = new mHashtable();
   public int i = 0;
   public int j = 0;
   public int k;

   public static void a(Message var0) {
      try {
         c.a.clear();
         a.a.clear();
         b.a.clear();
         f.a.clear();
         d.a.clear();
         e.a.clear();
         h.a.clear();
         int var1 = var0.b().readUnsignedByte();

         int var2;
         int var3;
         short var4;
         int var5;
         CharPartInfo var6;
         short var7;
         int var8;
         short var9;
         CharPartInfo var10;
         for(var2 = 0; var2 < var1; ++var2) {
            var3 = var0.b().readByte();
            var4 = var0.b().readShort();
            var5 = var0.b().readShort();
            (var6 = new CharPartInfo()).k = var5;

            for(var5 = 0; var5 < var3 - 2; var5 += 3) {
               var7 = var0.b().readShort();
               var8 = var0.b().readShort();
               var9 = var0.b().readShort();
               (var10 = new CharPartInfo()).i = var8;
               var10.j = var9;
               var6.g.a(String.valueOf(var7), var10);
            }

            a.a(String.valueOf(var4), var6);
         }

         short var13;
         for(var2 = 0; var2 < var1; ++var2) {
            var3 = var0.b().readByte();
            var4 = var0.b().readShort();
            var13 = var0.b().readShort();
            (var6 = new CharPartInfo()).k = var13;

            for(var5 = 0; var5 < var3 - 2; var5 += 3) {
               var7 = var0.b().readShort();
               var8 = var0.b().readShort();
               var9 = var0.b().readShort();
               (var10 = new CharPartInfo()).i = var8;
               var10.j = var9;
               var6.g.a(String.valueOf(var7), var10);
            }

            b.a(String.valueOf(var4), var6);
         }

         for(var2 = 0; var2 < var1; ++var2) {
            var3 = var0.b().readByte();
            var4 = var0.b().readShort();
            var13 = var0.b().readShort();
            (var6 = new CharPartInfo()).k = var13;

            for(var5 = 0; var5 < var3 - 2; var5 += 3) {
               var7 = var0.b().readShort();
               var8 = var0.b().readShort();
               var9 = var0.b().readShort();
               (var10 = new CharPartInfo()).i = var8;
               var10.j = var9;
               var6.g.a(String.valueOf(var7), var10);
            }

            c.a(String.valueOf(var4), var6);
         }

         var1 = var0.b().readUnsignedByte();

         for(var2 = 0; var2 < var1; var2 += 2) {
            var3 = var0.b().readShort();
            var4 = var0.b().readShort();
            CharPartInfo var15;
            (var15 = new CharPartInfo()).k = var4;
            l.a(String.valueOf(var3), var15);
         }

         var1 = var0.b().readUnsignedByte();

         byte var12;
         for(var2 = 0; var2 < var1; ++var2) {
            var12 = var0.b().readByte();
            var4 = var0.b().readShort();
            var13 = var0.b().readShort();
            (var6 = new CharPartInfo()).k = var13;

            for(var5 = 0; var5 < var12 - 2; var5 += 3) {
               var7 = var0.b().readShort();
               var8 = var0.b().readShort();
               var9 = var0.b().readShort();
               (var10 = new CharPartInfo()).i = var8;
               var10.j = var9;
               var6.g.a(String.valueOf(var7), var10);
            }

            d.a(String.valueOf(var4), var6);
         }

         for(var2 = 0; var2 < var1; ++var2) {
            var12 = var0.b().readByte();
            var4 = var0.b().readShort();
            var13 = var0.b().readShort();
            (var6 = new CharPartInfo()).k = var13;

            for(var5 = 0; var5 < var12 - 2; var5 += 3) {
               var7 = var0.b().readShort();
               var8 = var0.b().readShort();
               var9 = var0.b().readShort();
               (var10 = new CharPartInfo()).i = var8;
               var10.j = var9;
               var6.g.a(String.valueOf(var7), var10);
            }

            e.a(String.valueOf(var4), var6);
         }

         for(var2 = 0; var2 < var1; ++var2) {
            var12 = var0.b().readByte();
            var4 = var0.b().readShort();
            var13 = var0.b().readShort();
            (var6 = new CharPartInfo()).k = var13;

            for(var5 = 0; var5 < var12 - 2; var5 += 3) {
               var7 = var0.b().readShort();
               var8 = var0.b().readShort();
               var9 = var0.b().readShort();
               (var10 = new CharPartInfo()).i = var8;
               var10.j = var9;
               var6.g.a(String.valueOf(var7), var10);
            }

            f.a(String.valueOf(var4), var6);
         }

         byte var14 = var0.b().readByte();

         for(var3 = 0; var3 < var14; ++var3) {
            var4 = var0.b().readShort();
            int[][] var16 = new int[6][];

            for(var5 = 0; var5 < 6; ++var5) {
               byte var17 = var0.b().readByte();
               var16[var5] = new int[var17];

               for(var8 = 0; var8 < var17; ++var8) {
                  var16[var5][var8] = var0.b().readShort();
               }
            }

            h.a(String.valueOf(var4), var16);
         }
      } catch (Exception var16) {
      }

   }

}
