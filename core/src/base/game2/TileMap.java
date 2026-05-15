package base.game2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
import javax.microedition.lcdui.Image;

public final class TileMap {
   public static int tmw;
   public static int tmh;
   public static int pxw;
   public static int pxh;
   public static int tileID;
   public static char[] maps;
   public static int[] types;
   private static Image imgTileSmall;
   private static Image imgMiniMap;
   public static Image imgWaterfall;
   private static Image imgTopWaterfall;
   private static Image imgWaterflow;
   private static Image imgLeaf;
   private static Image imgflowRiver;
   private static Image ak;
   public static byte size = 24;
   private static int bx;
   private static int dbx;
   private static int fx;
   private static int dfx;
   public static String mapName1 = null;
   public static String mapName = "";
   public static byte zoneID;
   public static byte versionMap;
   public static byte bgID;
   public static short mapID;
   public static short phong_p = 0;
   private static int ap;
   private static int aq;
   private static int ar;
   private static int as;
   private static int at;
   private static int au;
   private static int av;
   private static int aw;
   public static int wMiniMap;
   public static int hMiniMap;
   public static int posMiniMapX;
   public static int posMiniMapY;
   public static Vector t = new Vector();
   public static String[] u;
   public static MyHashtable v = new MyHashtable();
   public static MyHashtable w = new MyHashtable();
   private static int ax;
   public static int sizeMiniMap = 2;
   public static int y;
   public static int z;
   public static int aa;
   public static int ab;
   public static int ac;
   public static int ad;
   private static int[] ay = new int[]{5257738, 8807192};
   private static short[][] az = new short[160][];
   private static boolean[] ba = new boolean[160];
   private static int[] bb = new int[160];
   private static short[] bc = new short[160];
   public static int phong_ad;
   public static boolean phong_ae;
   public static boolean phong_af;
   private static Object bd;
   private static byte[][] be;
   private static Image[] bf;
   private static Image[] bg;

   public static void setPosMiniMap(int var0, int var1, int var2, int var3) {
      wMiniMap = var2;
      hMiniMap = var3;
      posMiniMapX = var0;
      posMiniMapY = var1;
   }

   public static void updateMiniMap() {
      at = Char.getMyChar().cx1 / 12;
      ap = Char.getMyChar().cy1 / 12;
      if (at > tmw * sizeMiniMap - wMiniMap / 2) {
         at = tmw * sizeMiniMap - wMiniMap;
      } else if (at < wMiniMap / 2) {
         at = 0;
      } else {
         at -= wMiniMap / 2;
      }

      if (ap < hMiniMap / 2) {
         ap = 0;
      } else {
         ap -= hMiniMap / 2;
      }

      if (ap > tmh * sizeMiniMap - hMiniMap) {
         ap = tmh * sizeMiniMap - hMiniMap;
      }

   }

   public static void updateCmMiniMap() {
      if (tmw * sizeMiniMap >= wMiniMap || tmh * sizeMiniMap >= hMiniMap) {
         if (aq != ap) {
            as = ap - aq << 2;
            ar += as;
            aq += ar >> 4;
            ar &= 15;
         }

         if (au != at) {
            aw = at - au << 2;
            av += aw;
            au += av >> 4;
            av &= 15;
         }
      }

   }

   public static void c() {
      imgTileSmall = null;
      System.gc();
   }

   static final void loadTileImage() {
      if (imgflowRiver == null) {
         imgflowRiver = GameCanvas.c("/t/uwt.png");
      }

      if (imgTopWaterfall == null) {
         imgTopWaterfall = GameCanvas.c("/t/wtf.png");
      }

      if (imgWaterflow == null) {
         imgWaterflow = GameCanvas.c("/t/twtf.png");
      }

      if (imgLeaf == null) {
         imgLeaf = GameCanvas.c("/t/wts.png");
      }

      if (ak == null) {
         ak = GameCanvas.c("/t/wts1.png");
      }

      System.gc();
   }

   public static void loadMap(int var0) {
      pxh = tmh * size;
      pxw = tmw * size;

      try {
         for(int var1 = 0; var1 < tmw * tmh; ++var1) {
            int[] var10000;
            if (v != null && v.a(String.valueOf(var1)) != null) {
               var10000 = types;
               var10000[var1] |= 2;
            }

            if (var0 == 5) {
               if (maps[var1] == 6 || maps[var1] == 7 || maps[var1] == 8
                     || maps[var1] == '$' || maps[var1] == '2' || maps[var1] == '3'
                     || maps[var1] == '7' || maps[var1] == '8' || maps[var1] == '9'
                     || maps[var1] == ':' || maps[var1] == ';'
                     || maps[var1] == 'D' || maps[var1] == 'F'
                     || maps[var1] == 'I' || maps[var1] == 'J' || maps[var1] == 'K'
                     || maps[var1] == 'M' || maps[var1] == 'N'
                     || maps[var1] == 'u' || maps[var1] == 'v' || maps[var1] == 130) {
                  var10000 = types;
                  var10000[var1] |= 2;
               }

               if (maps[var1] == 6 || maps[var1] == 'u') {
                  var10000 = types;
                  var10000[var1] |= 4;
               }

               if (maps[var1] == 7 || maps[var1] == 'u') {
                  var10000 = types;
                  var10000[var1] |= 8;
               }

               if (maps[var1] == 10 || maps[var1] == 11) {
                  var10000 = types;
                  var10000[var1] |= 32;
               }

               if (maps[var1] == 12 || maps[var1] == 13) {
                  var10000 = types;
                  var10000[var1] |= 64;
               }
            }

            if (var0 == 4) {
               if (maps[var1] == 1 || maps[var1] == 2 || maps[var1] == 3 || maps[var1] == 4 || maps[var1] == 5 || maps[var1] == 6 || maps[var1] == '\t' || maps[var1] == '\n' || maps[var1] == 'O' || maps[var1] == 'P' || maps[var1] == '\r' || maps[var1] == 14 || maps[var1] == '+' || maps[var1] == ',' || maps[var1] == '-' || maps[var1] == '2') {
                  var10000 = types;
                  var10000[var1] |= 2;
               }

               if (maps[var1] == '\t' || maps[var1] == 11) {
                  var10000 = types;
                  var10000[var1] |= 4;
               }

               if (maps[var1] == '\n' || maps[var1] == '\f') {
                  var10000 = types;
                  var10000[var1] |= 8;
               }

               if (maps[var1] == '\r' || maps[var1] == 14) {
                  var10000 = types;
                  var10000[var1] |= 1024;
               }

               if (maps[var1] == 'L' || maps[var1] == 'M') {
                  var10000 = types;
                  var10000[var1] |= 64;
                  if (maps[var1] == 'N') {
                     var10000 = types;
                     var10000[var1] |= 4096;
                  }
               }
            }

            if (var0 == 1) {
               if (maps[var1] == 22) {
                  ax = maps[var1] - 1;
               }

               if (maps[var1] == 1 || maps[var1] == 2 || maps[var1] == 3 || maps[var1] == 4 || maps[var1] == 5 || maps[var1] == 6 || maps[var1] == 7 || maps[var1] == '$' || maps[var1] == '%' || maps[var1] == '6' || maps[var1] == '[' || maps[var1] == '\\' || maps[var1] == ']' || maps[var1] == '^' || maps[var1] == 'I' || maps[var1] == 'J' || maps[var1] == 'a' || maps[var1] == 'b' || maps[var1] == 't' || maps[var1] == 'u' || maps[var1] == 'v' || maps[var1] == 'x' || maps[var1] == '=') {
                  var10000 = types;
                  var10000[var1] |= 2;
               }

               if (maps[var1] == 2 || maps[var1] == 3 || maps[var1] == 4 || maps[var1] == 5 || maps[var1] == 6 || maps[var1] == 20 || maps[var1] == 21 || maps[var1] == 22 || maps[var1] == 23 || maps[var1] == '$' || maps[var1] == '%' || maps[var1] == '&' || maps[var1] == '\'' || maps[var1] == '=') {
                  var10000 = types;
                  var10000[var1] |= 4096;
               }

               if (maps[var1] == '\b' || maps[var1] == '\t' || maps[var1] == '\n' || maps[var1] == '\f' || maps[var1] == '\r' || maps[var1] == 14 || maps[var1] == 30) {
                  var10000 = types;
                  var10000[var1] |= 16;
               }

               if (maps[var1] == 17) {
                  var10000 = types;
                  var10000[var1] |= 32;
               }

               if (maps[var1] == 18) {
                  var10000 = types;
                  var10000[var1] |= 128;
               }

               if (maps[var1] == '%' || maps[var1] == '&' || maps[var1] == '=') {
                  var10000 = types;
                  var10000[var1] |= 4;
               }

               if (maps[var1] == '$' || maps[var1] == '\'' || maps[var1] == '=') {
                  var10000 = types;
                  var10000[var1] |= 8;
               }

               if (maps[var1] == 19) {
                  var10000 = types;
                  var10000[var1] |= 64;
                  if ((types[var1 - tmw] & 4096) == 4096) {
                     var10000 = types;
                     var10000[var1] |= 4096;
                  }
               }

               if (maps[var1] == '#') {
                  var10000 = types;
                  var10000[var1] |= 2048;
               }

               if (maps[var1] == 7) {
                  var10000 = types;
                  var10000[var1] |= 1024;
               }

               if (maps[var1] == ' ' || maps[var1] == '!' || maps[var1] == '"') {
                  var10000 = types;
                  var10000[var1] |= 256;
               }
            }

            if (var0 == 2) {
               if (maps[var1] == 22 || maps[var1] == 'g' || maps[var1] == 'o') {
                  ax = maps[var1] - 1;
               }

               if (maps[var1] == 1 || maps[var1] == 2 || maps[var1] == 3 || maps[var1] == 4 || maps[var1] == 5 || maps[var1] == 6 || maps[var1] == 7 || maps[var1] == '$' || maps[var1] == '%' || maps[var1] == '6' || maps[var1] == '=' || maps[var1] == 'I' || maps[var1] == 'L' || maps[var1] == 'M' || maps[var1] == 'N' || maps[var1] == 'O' || maps[var1] == 'R' || maps[var1] == 'S' || maps[var1] == 'b' || maps[var1] == 'c' || maps[var1] == 'd' || maps[var1] == 'f' || maps[var1] == 'g' || maps[var1] == 'l' || maps[var1] == 'm' || maps[var1] == 'n' || maps[var1] == 'p' || maps[var1] == 'q' || maps[var1] == 't' || maps[var1] == 'u' || maps[var1] == '}' || maps[var1] == '~' || maps[var1] == 127 || maps[var1] == 129 || maps[var1] == 130) {
                  var10000 = types;
                  var10000[var1] |= 2;
               }

               if (maps[var1] == 1 || maps[var1] == 3 || maps[var1] == 4 || maps[var1] == 5 || maps[var1] == 6 || maps[var1] == 20 || maps[var1] == 21 || maps[var1] == 22 || maps[var1] == 23 || maps[var1] == '$' || maps[var1] == '%' || maps[var1] == '&' || maps[var1] == '\'' || maps[var1] == '7' || maps[var1] == 'm' || maps[var1] == 'o' || maps[var1] == 'p' || maps[var1] == 'q' || maps[var1] == 'r' || maps[var1] == 's' || maps[var1] == 't' || maps[var1] == 127 || maps[var1] == 129 || maps[var1] == 130) {
                  var10000 = types;
                  var10000[var1] |= 4096;
               }

               if (maps[var1] == '\b' || maps[var1] == '\t' || maps[var1] == '\n' || maps[var1] == '\f' || maps[var1] == '\r' || maps[var1] == 14 || maps[var1] == 30 || maps[var1] == 135) {
                  var10000 = types;
                  var10000[var1] |= 16;
               }

               if (maps[var1] == 17) {
                  var10000 = types;
                  var10000[var1] |= 32;
               }

               if (maps[var1] == 18) {
                  var10000 = types;
                  var10000[var1] |= 128;
               }

               if (maps[var1] == '=' || maps[var1] == '%' || maps[var1] == '&' || maps[var1] == 127 || maps[var1] == 130 || maps[var1] == 131) {
                  var10000 = types;
                  var10000[var1] |= 4;
               }

               if (maps[var1] == '=' || maps[var1] == '$' || maps[var1] == '\'' || maps[var1] == 127 || maps[var1] == 129 || maps[var1] == 132) {
                  var10000 = types;
                  var10000[var1] |= 8;
               }

               if (maps[var1] == 19) {
                  var10000 = types;
                  var10000[var1] |= 64;
                  if ((types[var1 - tmw] & 4096) == 4096) {
                     var10000 = types;
                     var10000[var1] |= 4096;
                  }
               }

               if (maps[var1] == 134) {
                  var10000 = types;
                  var10000[var1] |= 64;
                  if ((types[var1 - tmw] & 4096) == 4096) {
                     var10000 = types;
                     var10000[var1] |= 4096;
                  }
               }

               if (maps[var1] == '#') {
                  var10000 = types;
                  var10000[var1] |= 2048;
               }

               if (maps[var1] == 7) {
                  var10000 = types;
                  var10000[var1] |= 1024;
               }

               if (maps[var1] == ' ' || maps[var1] == '!' || maps[var1] == '"') {
                  var10000 = types;
                  var10000[var1] |= 256;
               }

               if (maps[var1] == '=' || maps[var1] == 127) {
                  var10000 = types;
                  var10000[var1] |= 8192;
               }
            }

            if (var0 == 3) {
               if (maps[var1] == '\f' || maps[var1] == '3' || maps[var1] == 'X' || maps[var1] == 't' || maps[var1] == 128) {
                  ax = maps[var1] - 1;
               }

               if (maps[var1] == 'm' || maps[var1] == 'n') {
                  ax = maps[var1];
               }

               if (maps[var1] == 1 || maps[var1] == 2 || maps[var1] == 3 || maps[var1] == 4 || maps[var1] == 5 || maps[var1] == 6 || maps[var1] == 7 || maps[var1] == 11 || maps[var1] == 14 || maps[var1] == 17 || maps[var1] == '+' || maps[var1] == '3' || maps[var1] == '?' || maps[var1] == 'A' || maps[var1] == 'C' || maps[var1] == 'D' || maps[var1] == 'G' || maps[var1] == 'H' || maps[var1] == 'S' || maps[var1] == 'T' || maps[var1] == 'U' || maps[var1] == 'W' || maps[var1] == '[' || maps[var1] == '^' || maps[var1] == 'a' || maps[var1] == 'b' || maps[var1] == 'j' || maps[var1] == 'k' || maps[var1] == 'o' || maps[var1] == 'q' || maps[var1] == 'u' || maps[var1] == 'v' || maps[var1] == 'w' || maps[var1] == '}' || maps[var1] == '~' || maps[var1] == 129 || maps[var1] == 130 || maps[var1] == 131 || maps[var1] == 133 || maps[var1] == 136 || maps[var1] == 138 || maps[var1] == 139 || maps[var1] == 142) {
                  var10000 = types;
                  var10000[var1] |= 2;
               }

               if (maps[var1] == '|' || maps[var1] == 't' || maps[var1] == '{' || maps[var1] == ',' || maps[var1] == '\f' || maps[var1] == 15 || maps[var1] == 16 || maps[var1] == '-' || maps[var1] == '\n' || maps[var1] == '\t') {
                  var10000 = types;
                  var10000[var1] |= 4096;
               }

               if (maps[var1] == 23) {
                  var10000 = types;
                  var10000[var1] |= 32;
               }

               if (maps[var1] == 24) {
                  var10000 = types;
                  var10000[var1] |= 128;
               }

               if (maps[var1] == 6 || maps[var1] == 15 || maps[var1] == '3' || maps[var1] == '_' || maps[var1] == 'a' || maps[var1] == 'j' || maps[var1] == 'o' || maps[var1] == '{' || maps[var1] == '}' || maps[var1] == 138 || maps[var1] == 140) {
                  var10000 = types;
                  var10000[var1] |= 4;
               }

               if (maps[var1] == 7 || maps[var1] == 16 || maps[var1] == '3' || maps[var1] == '`' || maps[var1] == 'b' || maps[var1] == 'k' || maps[var1] == 'o' || maps[var1] == '|' || maps[var1] == '~' || maps[var1] == 139 || maps[var1] == 141) {
                  var10000 = types;
                  var10000[var1] |= 8;
               }

               if (maps[var1] == 25) {
                  var10000 = types;
                  var10000[var1] |= 64;
                  if ((types[var1 - tmw] & 4096) == 4096) {
                     var10000 = types;
                     var10000[var1] |= 4096;
                  }
               }

               if (maps[var1] == '"') {
                  var10000 = types;
                  var10000[var1] |= 2048;
               }

               if (maps[var1] == 17) {
                  var10000 = types;
                  var10000[var1] |= 1024;
               }

               if (maps[var1] == '!' || maps[var1] == 'g' || maps[var1] == 'h' || maps[var1] == 'i' || maps[var1] == 26 || maps[var1] == '!') {
                  var10000 = types;
                  var10000[var1] |= 256;
               }

               if (maps[var1] == '3' || maps[var1] == 'o' || maps[var1] == 'D') {
                  var10000 = types;
                  var10000[var1] |= 8192;
               }

               if (maps[var1] == 'R' || maps[var1] == 'n' || maps[var1] == 143) {
                  var10000 = types;
                  var10000[var1] |= 16384;
               }

               if (maps[var1] == 'q') {
                  var10000 = types;
                  var10000[var1] |= 65536;
               }

               if (maps[var1] == 142) {
                  var10000 = types;
                  var10000[var1] |= 32768;
               }

               if (maps[var1] == '(' || maps[var1] == ')') {
                  var10000 = types;
                  var10000[var1] |= 131072;
               }

               if (maps[var1] == 'n') {
                  var10000 = types;
                  var10000[var1] |= 262144;
               }

               if (maps[var1] == 143) {
                  var10000 = types;
                  var10000[var1] |= 524288;
               }
            }
         }

         // Create minimap using Pixmap (V8 approach — works on any thread)
         imgWaterfall = null;
         final int _tmw = tmw, _tmh = tmh;
         final java.util.concurrent.atomic.AtomicReference<Image> texHolder = new java.util.concurrent.atomic.AtomicReference<>();
         final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
         com.badlogic.gdx.Gdx.app.postRunnable(new Runnable() {
            public void run() {
               try {
                  com.badlogic.gdx.graphics.Pixmap pixmap = new com.badlogic.gdx.graphics.Pixmap(
                     _tmw * sizeMiniMap * mGraphics.b, _tmh * sizeMiniMap * mGraphics.b,
                     com.badlogic.gdx.graphics.Pixmap.Format.RGBA8888);
                  pixmap.setColor(0);
                  pixmap.setBlending(com.badlogic.gdx.graphics.Pixmap.Blending.None);
                  pixmap.fill();
                  for (int i = 0; i < _tmw; ++i) {
                     for (int j = 0; j < _tmh; ++j) {
                        int k;
                        if ((k = maps[j * _tmw + i] - 1) != -1 && imgMiniMap != null && imgMiniMap.pixmap != null) {
                           int size = sizeMiniMap * mGraphics.b;
                           pixmap.drawPixmap(imgMiniMap.pixmap, 0, k * sizeMiniMap * mGraphics.b, size, size,
                              i * size, j * size, size, size);
                        }
                     }
                  }
                  texHolder.set(Image.createImage(new com.badlogic.gdx.graphics.Texture(pixmap)));
               } catch (Exception e) {
                  DebugLog.error("Minimap creation failed", e);
               }
               latch.countDown();
            }
         });
         try { latch.await(); } catch (InterruptedException e) {}
         imgWaterfall = texHolder.get();

         if (!GameCanvas.a) {
            if (mapID == 0 || mapID <= 4 || mapID >= 16 && mapID <= 18 || mapID >= 24 && mapID <= 27 || mapID == 22 || mapID == 33 || mapID == 34 || mapID == 38 || mapID == 57 || mapID == 58 || mapID == 60 || mapID == 68 || mapID >= 70 && mapID <= 75 || mapID == 81) {
               Effect2.d.addElement(new AnimateEffect((byte)1, true, 10));
            }

            if (mapID >= 39 && mapID <= 44 || mapID >= 46 && mapID <= 48 || mapID == 56 || mapID >= 62 && mapID <= 65) {
               Effect2.d.addElement(new AnimateEffect((byte)3, true, Res.d(150, 200)));
               return;
            }
         }
      } catch (Exception var4) {
         ;
         ;
         GameMidlet.g.a();
      }

   }

   public static final void paintTilemapLOW(mGraphics var0) {
      for(int var2 = GameScr.gssx; var2 < GameScr.gssxe; ++var2) {
         for(int var3 = GameScr.gssy; var3 < GameScr.gssye; ++var3) {
            int var1 = maps[var3 * tmw + var2] - 1;
            if ((tileTypeAt(var2, var3) & 256) != 256) {
               if (tileID == 4 && (tileTypeAt(var2, var3) & 64) == 64) {
                  var1 = var3 - 1;
                  if ((var1 = maps[var1 * tmw + var2] - 1) == 15) {
                     var0.a(imgTileSmall, 0, 17 * size, 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if (var1 == 5) {
                     var0.a(imgTileSmall, 0, 7 * size, 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if (var1 == 18 || var1 == 22 || var1 == 15) {
                     var0.a(imgTileSmall, 0, 17 * size, 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if (var1 == 44 || var1 == 52 || var1 == 51) {
                     var0.a(imgTileSmall, 0, 56 * size, 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if (var1 == 24 || var1 == 23 || var1 == 20 || var1 == 21 || var1 == 19 || var1 == 12 || var1 == 13) {
                     continue;
                  }

                  if (var1 != -1) {
                     var0.a(imgTileSmall, 0, var1 * size, 24, 24, 0, var2 * size, var3 * size, 0);
                  } else if (var1 == -1) {
                     continue;
                  }
               }

               if (tileID == 1) {
                  if ((tileTypeAt(var2, var3) & 32) == 32) {
                     var0.a(imgTopWaterfall, 0, 24 * (GameCanvas.w % 4), 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if ((tileTypeAt(var2, var3) & 64) == 64 || (tileTypeAt(var2, var3) & 2048) == 2048) {
                     if ((tileTypeAt(var2, var3 - 1) & 32) == 32) {
                        var0.a(imgTopWaterfall, 0, 24 * (GameCanvas.w % 4), 24, 24, 0, var2 * size, var3 * size, 0);
                        continue;
                     }

                     if ((tileTypeAt(var2, var3 - 1) & 4096) == 4096) {
                        var0.a(imgTileSmall, 0, 504, 24, 24, 0, var2 * size, var3 * size, 0);
                        continue;
                     }
                  }
               }

               if (tileID == 2) {
                  if ((tileTypeAt(var2, var3) & 32) == 32) {
                     var0.a(imgTopWaterfall, 0, 24 * (GameCanvas.w % 8 >> 1), 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if (var1 == 17) {
                     var0.a(imgWaterflow, 0, 24 * (GameCanvas.w % 8 >> 1), 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if (var1 == 133) {
                     var0.a(imgTileSmall, 0, 132 * size, 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if ((tileTypeAt(var2, var3) & 64) == 64 || (tileTypeAt(var2, var3) & 2048) == 2048) {
                     if ((tileTypeAt(var2, var3 - 1) & 32) == 32) {
                        var0.a(imgTopWaterfall, 0, 24 * (GameCanvas.w % 4), 24, 24, 0, var2 * size, var3 * size, 0);
                        continue;
                     }

                     if ((tileTypeAt(var2, var3 - 1) & 4096) == 4096) {
                        if ((var1 = tileAt(var2, var3 - 1)) == 55) {
                           var1 = 54;
                        } else if (var1 != 19 && var1 != 35) {
                           if (var1 < 40) {
                              var1 = 21;
                           } else {
                              var1 = 110;
                           }
                        } else if ((var1 = tileAt(var2, var3 - 2)) == 55) {
                           var1 = 54;
                        } else if (var1 < 40) {
                           var1 = 21;
                        }

                        var0.a(imgTileSmall, 0, var1 * 24, 24, 24, 0, var2 * size, var3 * size, 0);
                        continue;
                     }
                  }
               }

               if (tileID == 3) {
                  if ((tileTypeAt(var2, var3) & 32) == 32) {
                     var0.a(imgTopWaterfall, 0, 24 * (GameCanvas.w % 8 >> 1), 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if (var1 == 23) {
                     var0.a(imgWaterflow, 0, 24 * (GameCanvas.w % 8 >> 1), 24, 24, 0, var2 * size, var3 * size, 0);
                     continue;
                  }

                  if ((tileTypeAt(var2, var3) & 64) == 64 || (tileTypeAt(var2, var3) & 2048) == 2048) {
                     if ((tileTypeAt(var2, var3 - 1) & 32) == 32) {
                        var0.a(imgTopWaterfall, 0, 24 * (GameCanvas.w % 4), 24, 24, 0, var2 * size, var3 * size, 0);
                        continue;
                     }

                     if ((tileTypeAt(var2, var3 - 1) & 4096) == 4096) {
                        if ((var1 = tileAt(var2, var3 - 1)) == 25) {
                           var1 = tileAt(var2, var3 - 2);
                        }

                        if (var1 == 45) {
                           var1 = 44;
                        }

                        --var1;
                        var0.a(imgTileSmall, 0, var1 * 24, 24, 24, 0, var2 * size, var3 * size, 0);
                        continue;
                     }
                  }
               }

               if ((tileTypeAt(var2, var3) & 16) == 16) {
                  dbx = (bx = var2 * size - GameScr.p) - GameScr.k;
                  fx = (dfx = (size - 2) * dbx / size) + GameScr.k;
                  var0.a(imgTileSmall, 0, var1 * size, 24, 24, 0, fx + GameScr.p, var3 * size, 0);
               } else if ((tileTypeAt(var2, var3) & 512) == 512) {
                  if (var1 != -1) {
                     var0.a(imgTileSmall, 0, var1 * size, 24, 1, 0, var2 * size, var3 * size, 0);
                     var0.a(imgTileSmall, 0, var1 * size, 24, 24, 0, var2 * size, var3 * size + 1, 0);
                  }
               } else if (var1 != -1) {
                  var0.a(imgTileSmall, 0, var1 * size, 24, 24, 0, var2 * size, var3 * size, 0);
               }
            }
         }
      }

   }

   public static final void paintMiniMap(mGraphics var0) {
      if (imgWaterfall == null) return; // Skip if minimap not loaded (GL thread issue)
      if (GameCanvas.aa > 176) {
         Res.a(var0);
         var0.a(posMiniMapX + 1, posMiniMapY + 2);
         var0.a(0);
         var0.c(-2, -2, wMiniMap + 2, hMiniMap);
         var0.d(-2, -2, wMiniMap + 4, hMiniMap + 4);

         int var1;
         for(var1 = 0; var1 < 2; ++var1) {
            var0.a(ay[var1]);
            var0.b(var1 - 2, var1 - 2, wMiniMap + 2 - (var1 << 1), hMiniMap - (var1 << 1));
         }

         var0.d(0, 0, wMiniMap - 2, hMiniMap - 3);
         if (mGraphics.a(imgWaterfall) > wMiniMap || mGraphics.b(imgWaterfall) > hMiniMap) {
            var0.a(-au, -aq);
         }

         var0.a(imgWaterfall, 0, 0, 0);

         int var2;
         int var3;
         for(var3 = 0; var3 < Auto.listMob.size(); ++var3) {
            Mob var4;
            var1 = (var4 = (Mob)Auto.listMob.elementAt(var3)).x1 / 12;
            var2 = var4.y1 / 12;
            if (var1 < au) {
               var1 = au;
            }

            if (var2 < aq) {
               var2 = aq;
            }

            if (var1 > au + wMiniMap) {
               var1 = au + wMiniMap;
            }

            if (var2 > aq + hMiniMap) {
               var2 = aq + hMiniMap;
            }

            if (GameCanvas.w % 10 < 8) {
               var0.a(16777215);
               var0.c(var1 - 2, var2 - 2, 5, 5);
               var0.a(var4.levelBoss == 1 ? 255 : (var4.levelBoss == 2 ? 16711935 : '\uffff'));
               var0.c(var1 - 1, var2 - 1, 3, 3);
            }
         }

         var1 = Char.getMyChar().cx1 / 12;
         var2 = Char.getMyChar().cy1 / 12;
         var0.a(16777215);
         var0.c(var1 - 2, var2 - 2, 5, 5);
         var0.a(16711680);
         var0.c(var1 - 1, var2 - 1, 3, 3);
         if (Code.dcvt) {
            for(var3 = 0; var3 < Code.x_dcvt[mapID].size(); ++var3) {
               var1 = (Integer)Code.x_dcvt[mapID].elementAt(var3) / 12;
               var2 = (Integer)Code.y_dcvt[mapID].elementAt(var3) / 12;
               if (Code.index_dcvt == var3) {
                  var0.a(16777215);
                  var0.c(var1 - 2, var2 - 2, 5, 5);
               }

               var0.a(16777215);
               var0.c(var1 - 1, var2 - 1, 3, 3);
            }
         }

         for(var3 = 0; var3 < GameScr.vParty.size(); ++var3) {
            Party var4;
            if ((var4 = (Party)GameScr.vParty.elementAt(var3)).f != null && var4.f != Char.getMyChar()) {
               var2 = var4.f.cx1 / 12;
               var1 = var4.f.cy1 / 12;
               if (var2 < au) {
                  var2 = au;
               }

               if (var1 < aq) {
                  var1 = aq;
               }

               if (var2 > au + wMiniMap) {
                  var2 = au + wMiniMap;
               }

               if (var1 > aq + hMiniMap) {
                  var1 = aq + hMiniMap;
               }

               if (GameCanvas.w % 10 < 8) {
                  var0.a(16777215);
                  var0.c(var2 - 2, var1 - 2, 5, 5);
                  var0.a(65280);
                  var0.c(var2 - 1, var1 - 1, 3, 3);
               }
            }
         }

         Res.a(var0);
         if (GameCanvas.g) {
            var0.a(GameScr.dz, posMiniMapX - 1, posMiniMapY, 0);
         }
      }

   }

   public static final void paintOutTilemap(mGraphics var0) {
      if (!GameCanvas.a) {
         int var1;
         int var2;
         for(var1 = GameScr.gssx; var1 < GameScr.gssxe; ++var1) {
            for(var2 = GameScr.gssy; var2 < GameScr.gssye; ++var2) {
               Image var3 = null;
               if (tileID == 4) {
                  var3 = ak;
               } else {
                  var3 = imgLeaf;
               }

               if ((tileTypeAt(var1, var2) & 2048) == 2048) {
                  var0.a(imgflowRiver, var1, var2, 0);
               }

               if ((tileTypeAt(var1, var2) & 64) == 64) {
                  var0.a(var3, 0, (GameCanvas.w % 8 >> 2) * 24, 24, 24, 0, var1 * size, var2 * size, 0);
               }

               if ((tileTypeAt(var1, var2) & 256) == 256) {
                  var0.a(imgTileSmall, 0, (maps[var2 * tmw + var1] - 1) * size, 24, 24, 0, var1 * size, var2 * size, 0);
               }
            }
         }

         if (tileID != 4 && GameCanvas.g && GameCanvas.h && GameScr.gssye >= tmh - 2) {
            for(var1 = GameScr.gssx; var1 < GameScr.gssxe; ++var1) {
               var2 = tmh - 2;
               int var5 = maps[var2 * tmw + var1] - 1;
               int var4;
               if ((tileTypeAt(var1, var2) & 32) == 32) {
                  for(var4 = 1; var4 <= 4; ++var4) {
                     var0.a(imgTopWaterfall, 0, 24 * (GameCanvas.w % 4), 24, 24, 0, var1 * size, (var2 + var4) * size, 0);
                  }
               } else {
                  if (mapID == 64) {
                     ax = 115;
                  }

                  if ((tileTypeAt(var1, var2) & 2) == 2 || (tileTypeAt(var1, var2) & 64) == 64) {
                     var5 = ax;
                  }

                  if (var5 >= 0) {
                     for(var4 = 1; var4 <= 4; ++var4) {
                        var0.a(imgTileSmall, 0, var5 * size, 24, 24, 0, var1 * size, (var2 + var4) * size, 0);
                     }
                  }
               }
            }
         }
      }

   }

   private static int tileAt(int var0, int var1) {
      try {
         return maps[var1 * tmw + var0];
      } catch (Exception var3) {
         return 1000;
      }
   }

   private static int tileTypeAt(int var0, int var1) {
      try {
         return types[var1 * tmw + var0];
      } catch (Exception var3) {
         return 1000;
      }
   }

   public static final int tileTypeAtPixel(int var0, int var1) {
      try {
         return types[var1 / size * tmw + var0 / size];
      } catch (Exception var3) {
         return 1000;
      }
   }

   public static final boolean tileTypeAt(int var0, int var1, int var2) {
      try {
         return (types[var1 / size * tmw + var0 / size] & var2) == var2;
      } catch (Exception var4) {
         return false;
      }
   }

   public static final void setTileTypeAtPixel(int var0, int var1, int var2) {
      int[] var10000 = types;
      int var10001 = var1 / size * tmw + var0 / size;
      var10000[var10001] |= 512;
   }

   public static final void c(int var0, int var1, int var2) {
      int[] var10000 = types;
      int var10001 = var1 / size * tmw + var0 / size;
      var10000[var10001] &= -513;
   }

   public static final int tileYofPixel(int var0) {
      return var0 / size * size;
   }

   public static final int tileXofPixel(int var0) {
      return var0 / size * size;
   }

   public static void e1() {
      if (GameCanvas.w % 700 == 0 && mapID != 0 && mapID > 4 && (mapID < 16 || mapID > 18) && (mapID < 24 || mapID > 27) && mapID != 22 && mapID != 33 && mapID != 34 && mapID != 38 && mapID != 57 && mapID != 58 && mapID != 60 && mapID != 68 && (mapID < 70 || mapID > 75) && mapID != 81) {
         if (mapID >= 39 && mapID <= 44 || mapID >= 46 && mapID <= 48 || mapID == 56 || mapID >= 62 && mapID <= 65) {
            return;
         }

         if (mapID == 29 || mapID == 35) {
            return;
         }

         if (mapID == 50 || mapID == 51 || mapID == 52) {
            return;
         }

         if (mapID == 64) {
            if (Res.d(0, 8) % 2 == 0) {
               return;
            }

            return;
         }
      }

   }

   public static boolean isLang(int var0) {
      return var0 == 10 || var0 == 17 || var0 == 22 || var0 == 32 || var0 == 38 || var0 == 43 || var0 == 48 || var0 == 138;
   }

   public static boolean isLangCo(int var0) {
      return var0 >= 134 && var0 <= 138;
   }

   public static boolean isTruong(int var0) {
      return var0 == 1 || var0 == 27 || var0 == 72;
   }

   public static boolean isPhuBan(int var0) {
      return var0 == 91 || var0 == 92 || var0 == 93 || var0 == 94 || var0 == 95 || var0 == 96 || var0 == 97 || var0 == 105 || var0 == 106 || var0 == 107 || var0 == 108 || var0 == 109 || var0 == 114 || var0 == 115 || var0 == 116 || var0 == 125 || var0 == 126 || var0 == 127 || var0 == 128 || var0 == 157 || var0 == 158 || var0 == 159;
   }

   public static int h(int var0) {
      if (isPhuBan(var0)) {
         switch (var0) {
            case 91:
               return 92;
            case 92:
               return 93;
            case 93:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            default:
               break;
            case 94:
               return 95;
            case 95:
               return 96;
            case 96:
               return 97;
            case 105:
               return 106;
            case 106:
               return 107;
            case 107:
               return 108;
            case 108:
               return 109;
            case 114:
               return 115;
            case 115:
               return 116;
            case 125:
               return 126;
            case 126:
               return 127;
            case 127:
               return 128;
            case 157:
               return 158;
            case 158:
               return 159;
            case 159:
               return 157;
         }
      }

      return -1;
   }

   public static int i(int var0) {
      if (isPhuBan(var0)) {
         switch (var0) {
            case 92:
               return 91;
            case 93:
               return 92;
            case 94:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            default:
               break;
            case 95:
               return 94;
            case 96:
               return 95;
            case 97:
               return 96;
            case 106:
               return 105;
            case 107:
               return 106;
            case 108:
               return 107;
            case 109:
               return 108;
            case 115:
               return 114;
            case 116:
               return 115;
            case 126:
               return 125;
            case 127:
               return 126;
            case 128:
               return 127;
            case 158:
               return 157;
            case 159:
               return 158;
         }
      }

      return -1;
   }

   public static void nextMap(int var0) {
      Waypoint var3;
      int var1 = (var3 = (Waypoint)t.elementAt(var0)).a;
      int var2 = var3.b;
      if (var3.b != 0 && var3.d < pxh - 24) {
         if (var3.c <= pxw / 2) {
            var1 = var3.c + 12;
            var2 = var3.d;
         } else if (var3.a >= pxw / 2) {
            var1 = var3.a - 12;
            var2 = var3.d;
         }
      } else if (var3.d <= pxh / 2) {
         var1 = (var3.c + var3.a) / 2;
         var2 = var3.d + 24;
      } else if (var3.b >= pxh / 2) {
         var1 = (var3.c + var3.a) / 2 + 24;
         var2 = var3.d - 48;
      }

      if (mapID != 114 && mapID != 115 && mapID != 116) {
         Char.move(var1, var2);
      } else {
         Char.e(var1, var2);
      }

      phong.sleep(10L);
      Service.gI().c();
   }

   public static boolean goMap(int var0) {
      short var10000 = mapID;
      phong_ad = var0;
      short var2 = var10000;
      int var4;
      int var5;
      int var6;
      int var11;
      MyVector var20;
      int var7;
      if (var10000 >= 0 && var10000 < az.length && var0 >= 0 && var0 < az.length) {
         if (az[var10000].length <= 0) {
            var20 = null;
         } else {
            TaskOrder var3 = Char.get_nvhn(0);

            for(var4 = 0; var4 < ba.length; ++var4) {
               ba[var4] = true;
               bb[var4] = -1;
               bc[var4] = -1;
            }

            bb[var10000] = 0;

            label375:
            while(true) {
               do {
                  do {
                     if (!ba[var0]) {
                        MyVector var18;
                        (var18 = new MyVector()).addElement(new Integer(var0));

                        for(var6 = var0; var6 != var2; var6 = bc[var6]) {
                           byte var13;
                           if (isLang(var7 = bc[var6])) {
                              if (isLang(var6) && var6 != 138) {
                                 var13 = 1;
                                 if (var6 == 10) {
                                    var13 = 1;
                                 } else if (var6 == 17) {
                                    var13 = 2;
                                 } else if (var6 == 22) {
                                    var13 = 3;
                                 } else if (var6 == 32) {
                                    var13 = 4;
                                 } else if (var6 == 38) {
                                    var13 = 5;
                                 } else if (var6 == 43) {
                                    var13 = 6;
                                 } else if (var6 == 48) {
                                    var13 = 7;
                                 }

                                 var7 = var7 | Integer.MIN_VALUE | 117440512 | var13 << 20 & 15728640;
                              } else if (var6 == 139) {
                                 var7 = var7 | Integer.MIN_VALUE | 83886080 | 2097152;
                              }
                           } else if (isTruong(var7)) {
                              if (isTruong(var6)) {
                                 var13 = 0;
                                 if (var6 == 1) {
                                    var13 = 0;
                                 } else if (var6 == 27) {
                                    var13 = 1;
                                 } else if (var6 == 72) {
                                    var13 = 2;
                                 }

                                 var7 = var7 | Integer.MIN_VALUE | 134217728 | var13 << 20 & 15728640;
                              } else if (var3 != null && var6 == var3.g) {
                                 var11 = GameScr.phong_tilemap;
                                 var7 = var7 | Integer.MIN_VALUE | 419430400 | var11 << 20 & 15728640 | 196608;
                              } else {
                                 switch (var6) {
                                    case 80:
                                       var7 = var7 | Integer.MIN_VALUE | 1048576 | 65536;
                                       break;
                                    case 91:
                                       var7 = var7 | Integer.MIN_VALUE | 2097152 | 65536;
                                       break;
                                    case 94:
                                       var7 = var7 | Integer.MIN_VALUE | 2097152 | 131072;
                                       break;
                                    case 98:
                                       var11 = GameScr.phong_tilemap + 2;
                                       var7 = var7 | Integer.MIN_VALUE | 419430400 | var11 << 20 & 15728640;
                                       break;
                                    case 104:
                                       var11 = GameScr.phong_tilemap + 2;
                                       var7 = var7 | Integer.MIN_VALUE | 419430400 | var11 << 20 & 15728640 | 65536;
                                       break;
                                    case 105:
                                       var7 = var7 | Integer.MIN_VALUE | 2097152 | 196608;
                                       break;
                                    case 113:
                                       var11 = GameScr.phong_tilemap + 3;
                                       var7 = var7 | Integer.MIN_VALUE | 419430400 | var11 << 20 & 15728640;
                                       break;
                                    case 114:
                                       var7 = var7 | Integer.MIN_VALUE | 2097152 | 262144;
                                       break;
                                    case 125:
                                       var7 = var7 | Integer.MIN_VALUE | 2097152 | 327680;
                                       break;
                                    case 139:
                                       var7 = var7 | Integer.MIN_VALUE | 83886080 | 2097152;
                                       break;
                                    case 157:
                                       var7 = var7 | Integer.MIN_VALUE | 2097152 | 393216;
                                 }
                              }
                           }

                           var18.addElement(new Integer(var7));
                        }

                        MyVector var19 = new MyVector();

                        for(var4 = var18.size() - 1; var4 >= 0; --var4) {
                           var19.addElement(var18.elementAt(var4));
                        }

                        var20 = var19;
                        break label375;
                     }

                     var5 = -1;
                     var6 = -1;

                     for(var4 = 0; var4 < az.length; ++var4) {
                        if (ba[var4] && bb[var4] != -1 && (bb[var4] < var5 || var5 == -1)) {
                           var5 = bb[var4];
                           var6 = (short)var4;
                        }
                     }

                     if (var6 == -1) {
                        var20 = null;
                        break label375;
                     }

                     ba[var6] = false;
                     boolean var17 = isTruong(var6);
                     short[] var1 = az[var6];

                     for(var4 = 0; var4 < var1.length; ++var4) {
                        var7 = var1[var4];
                        if (ba[var7]) {
                           boolean var21;
                           label339: {
                              if (Char.getMyChar().isHuman) {
                                 int var9 = Char.getMyChar().ctaskId;
                                 if ((var7 == 1 || var7 == 27 || var7 == 72) && var9 < 6) {
                                    var21 = false;
                                    break label339;
                                 }

                                 if ((var7 == 10 || var7 == 32 || var7 == 48) && var9 < 17) {
                                    var21 = false;
                                    break label339;
                                 }

                                 if (var7 == 38 && var9 < 28) {
                                    var21 = false;
                                    break label339;
                                 }

                                 if (var7 == 43 && var9 < 33) {
                                    var21 = false;
                                    break label339;
                                 }

                                 if (var7 == 17 && var9 < 38) {
                                    var21 = false;
                                    break label339;
                                 }

                                 if (var7 == 7 && var9 < 15) {
                                    var21 = false;
                                    break label339;
                                 }
                              }

                              var21 = true;
                           }

                           if (var21 && (!var17 || !isTruong(var7) || Char.getMyChar().ctaskId >= 9) && (bb[var7] == -1 || bb[var7] > bb[var6] + 1)) {
                              bb[var7] = bb[var6] + 1;
                              bc[var7] = (short)var6;
                           }
                        }
                     }

                     if (var17 && var3 != null && ba[var3.g] && (bb[var3.g] == -1 || bb[var3.g] > bb[var6] + 1)) {
                        bb[var3.g] = bb[var6] + 1;
                        bc[var3.g] = (short)var6;
                     }

                     if (var17) {
                        var7 = (short)(GameScr.tilemap_fi ? 98 : 104);
                        if (bb[var7] == -1 || bb[var7] > bb[var6] + 1) {
                           bb[var7] = bb[var6] + 1;
                           bc[var7] = (short)var6;
                        }
                     }
                  } while(!Char.autocl);
               } while(bb[138] != -1 && bb[138] <= bb[var6] + 1);

               bb[138] = bb[var6] + 1;
               bc[138] = (short)var6;
            }
         }
      } else {
         var20 = null;
      }

      MyVector var12 = var20;
      if (var20 == null) {
         ;
         return false;
      } else {
         phong_ae = true;

         try {
            var6 = mapID;

            for(var11 = 1; var11 < var12.size() && phong_ae && var6 == mapID; ++var11) {
               var5 = (Integer)var12.elementAt(var11 - 1);
               var6 = (Integer)var12.elementAt(var11) & '\uffff';
               boolean gateNav = false;
               int gateIdx = -1;
               if (var5 < 0) {
                  var7 = var5 >> 24 & 127;
                  var4 = var5 >> 20 & 15;
                  var5 = var5 >> 16 & 15;
                  GameScr.npc_b(var7, var4, var5);
               } else if ((var5 < 134 || var5 > 138) && var6 == 138) {
                  if (Char.getMyChar().cPk > 0) {
                     ;
                     return false;
                  }

                  Item var16;
                  if ((var16 = Code.get_item(490)) == null) {
                     if (Char.automuacl && Char.getMyChar().luong >= 10) {
                        phong.muacl();
                        f2(1000L);
                        return false;
                     }

                     ;
                     return false;
                  }

                  ;
                  Service.gI().useItem(var16.indexUI);
               } else if (var5 != 0 && var5 != 56 && var5 != 73) {
                  var4 = -1;

                  for(var7 = 0; var7 < az[var5].length; ++var7) {
                     if (az[var5][var7] == var6) {
                        var4 = var7;
                        break;
                     }
                  }

                  if (var4 == -1) {
                     ;
                     return false;
                  }

                  gateNav = true;
                  gateIdx = var4;
                  nextMap(var4);
               } else {
                  Npc var14;
                  if ((var14 = (Npc)GameScr.vNpc.elementAt(0)) != null && var14.statusMe != 15) {
                     Char.move(var14.cx1, var14.cy1);
                     Char.getMyChar().npcFocus = var14;
                     Service.gI().i(var14.npcTemplate.npcTemplateId);
                     Service.gI().menu((byte)0, var14.npcTemplate.npcTemplateId, 0, 0);
                     Service.gI().b(var14.npcTemplate.npcTemplateId, 0, 0);
                  }
               }

               long mapChangeStart = System.currentTimeMillis();
               if (mapID != var6) {
                  f1();
                  // Fix B3: Hybrid retry khi map chưa đổi (chỉ cho gate navigation)
                  if (gateNav) {
                     int retryCount = 0;
                     while (mapID != var6 && retryCount < 5) {
                        retryCount++;
                        if (GameCanvas.delaychuyenkhu > 0) {
                           int cd = GameCanvas.delaychuyenkhu;
                           GameCanvas.delaychuyenkhu = 0;
                           Thread.sleep((long)cd * 1000L);
                        } else {
                           Thread.sleep(3000L);
                        }
                        ;
                        nextMap(gateIdx);
                        f1();
                     }
                  }
                  // Fix B5: smart delay - tính f1 đã tốn, chỉ sleep phần còn thiếu
                  if (mapID == var6) {
                     long elapsed = System.currentTimeMillis() - mapChangeStart;
                     long remaining = Code.tdnm - elapsed;
                     if (remaining > 0) {
                        Thread.sleep(remaining);
                     }
                  }
               } else {
                  Thread.sleep(100L);
               }
            }
         } catch (Exception var14) {
            ;
            return false;
         }

         phong_ae = false;
         return mapID == var0;
      }
   }

   public static int d(int var0, int var1) {
      var1 = tileYofPixel(var1);
      if (!tileTypeAt(var0, var1, 2)) {
         for(int var2 = 0; var2 < 7; ++var2) {
            int var3;
            if ((var3 = var1 - 48 + var2 * 24) > 0 && var3 < pxh && tileTypeAt(var0, var3, 2)) {
               return var3;
            }
         }
      }

      return var1;
   }

   public static int e(int var0, int var1) {
      if ((tileTypeAtPixel(var0, var1 - 16) & 16386) != 0) {
         var1 = tileYofPixel(var1);

         int var2;
         int var3;
         for(var2 = 24; var2 < 240; var2 += 24) {
            var3 = tileTypeAtPixel(var0, var1 - var2);
            if (var1 - var2 > 0 && (var3 & 16386) == 0) {
               return var1 - var2 + 24;
            }
         }

         for(var2 = 24; var2 < 120; var2 += 24) {
            var3 = tileTypeAtPixel(var0, var1 + var2);
            if (var1 + var2 < pxh && (var3 & 16386) == 0) {
               return var1 + var2;
            }
         }
      }

      return var1;
   }

   public static boolean a(int var0, int var1, int[] var2) {
      var1 = tileYofPixel(var1);
      // Stage 1: chi check truc tiep (x, y) — bam sat demo Class_mi.d (offset 0-37).
      // Da bo vong narrow 5x5 don dieu trai->phai cu, vi Stage 2 (alternating ±) la superset:
      // cung N=5 hang x N=5 cot step=24, nhung thu tu cot uu tien gan x truoc -> tranh chon
      // diem "vap da" o cuc trai (x-48) o Kingu, nguyen nhan goc cua bug map 137.
      if (tileTypeAt(var0, var1, 2)) {
         var2[0] = var0;
         var2[1] = var1;
         return true;
      }

      // Stage 1 fail -> fallback ports tu demo Class_mi.d (5-stage, global, no map guard)
      // Demo constants: N=5 (Stage 2/3 outer+inner), M=3 (Stage 4/5 outer), step=24
      if (DebugLog.DEBUG && mapID == 137) DebugLog.log("map137", "stage1 fail in=(" + var0 + "," + var1 + ")");

      // Stage 2: scan XUONG, outer N=5 hang, inner N=5 cot alternating ±
      if (scanVerticalAlt(var0, var1, +1, var2)) {
         if (DebugLog.DEBUG && mapID == 137) DebugLog.log("map137", "stage2 down ok out=(" + var2[0] + "," + var2[1] + ") dx=" + (var2[0]-var0) + " dy=" + (var2[1]-var1));
         return true;
      }
      // Stage 3: scan LEN, outer N=5 hang, inner N=5 cot alternating ±
      if (scanVerticalAlt(var0, var1, -1, var2)) {
         if (DebugLog.DEBUG && mapID == 137) DebugLog.log("map137", "stage3 up ok out=(" + var2[0] + "," + var2[1] + ") dx=" + (var2[0]-var0) + " dy=" + (var2[1]-var1));
         return true;
      }
      // Stage 4: tu y-step di xuong M=3 hang, cot LEFT only (xC = x - i*step, i=0..N-1)
      if (scanHorizontalSide(var0, var1 - 24, -1, var2)) {
         if (DebugLog.DEBUG && mapID == 137) DebugLog.log("map137", "stage4 left ok out=(" + var2[0] + "," + var2[1] + ") dx=" + (var2[0]-var0) + " dy=" + (var2[1]-var1));
         return true;
      }
      // Stage 5: tu y-step di xuong M=3 hang, cot RIGHT only (xC = x + i*step, i=0..N-1)
      if (scanHorizontalSide(var0, var1 - 24, +1, var2)) {
         if (DebugLog.DEBUG && mapID == 137) DebugLog.log("map137", "stage5 right ok out=(" + var2[0] + "," + var2[1] + ") dx=" + (var2[0]-var0) + " dy=" + (var2[1]-var1));
         return true;
      }

      if (DebugLog.DEBUG && mapID == 137) DebugLog.log("map137", "ALL FAIL in=(" + var0 + "," + var1 + ") -> bot ket");
      return false;
   }

   // Helper Stage 2/3: scan doc theo dir (+1 xuong, -1 len). N=5 hang x N=5 cot.
   // Cot alternating: xLoop chan -> +xLoop*24, le -> -xLoop*24 (gan x goc thu truoc).
   private static boolean scanVerticalAlt(int x, int y, int dir, int[] out) {
      final int N = 5, step = 24;
      for (int yLoop = 0; yLoop < N; ++yLoop) {
         int yC = y + dir * yLoop * step;
         if (yC < 0 || yC >= pxh) continue;
         for (int xLoop = 0; xLoop < N; ++xLoop) {
            int xC = (xLoop % 2 == 0) ? x + xLoop * step : x - xLoop * step;
            if (xC <= 24 || xC >= pxw - 24) continue;
            if (tileTypeAt(xC, yC, 2)) {
               out[0] = xC;
               out[1] = yC;
               return true;
            }
         }
      }
      return false;
   }

   // Helper Stage 4/5: tu yAnchor di xuong M=3 hang, cot 1 chieu (sign=-1 LEFT, +1 RIGHT). N=5 cot.
   private static boolean scanHorizontalSide(int x, int yAnchor, int sign, int[] out) {
      final int N = 5, M = 3, step = 24;
      for (int yLoop = 0; yLoop < M; ++yLoop) {
         int yC = yAnchor + yLoop * step;
         if (yC < 0 || yC >= pxh) continue;
         for (int xLoop = 0; xLoop < N; ++xLoop) {
            int xC = x + sign * xLoop * step;
            if (xC <= 24 || xC >= pxw - 24) continue;
            if (tileTypeAt(xC, yC, 2)) {
               out[0] = xC;
               out[1] = yC;
               return true;
            }
         }
      }
      return false;
   }

   public static void a(int var0, InputStream var1) {
      try {
         if (be.length <= var0) {
            byte[][] var2 = new byte[var0 + 10][];
            System.arraycopy(be, 0, var2, 0, be.length);
            be = var2;
         }

         be[var0] = new byte[var1.available()];
         var1.read(be[var0]);
      } catch (Exception var3) {
      }

   }

   public static void h() {
      ByteArrayInputStream var0 = new ByteArrayInputStream(be[mapID]);

      try {
         DataInputStream var2;
         tmw = (char)(var2 = new DataInputStream(var0)).readUnsignedByte();
         tmh = (char)var2.readUnsignedByte();
         maps = new char[var2.available()];

         for(int var1 = 0; var1 < tmw * tmh; ++var1) {
            maps[var1] = (char)var2.readUnsignedByte();
         }

         types = new int[maps.length];
      } catch (IOException var3) {
         ;
      }

   }

   public static void i() {
      // P2 A1#8: g8 cross-check khi load tile assets — fail thi set mapID=-1.
      if (com.monkey.nso.LicenseGuard.isVerifyStarted() && !com.monkey.nso.LicenseGuard.g8()) {
         mapID = -1;
      }
      for(int var0 = 1; var0 < bf.length; ++var0) {
         bf[var0] = GameCanvas.c("/t/" + var0 + ".png");
         bg[var0] = GameCanvas.c("/t/mini_" + var0 + ".png");
      }

   }

   public static void f() {
      imgTileSmall = null;
      System.gc();
      imgTileSmall = bf[tileID];
      imgMiniMap = bg[tileID];
   }

   public static void f1() {
      phong_af = true;
      synchronized(bd) {
         try {
            bd.wait(5000L);
         } catch (InterruptedException var3) {
         }

      }
   }

   public static void f2(long var0) {
      phong_af = true;
      synchronized(bd) {
         try {
            bd.wait(var0);
         } catch (InterruptedException var5) {
         }

      }
   }

   public static boolean isMapPK() {
      return mapID == 111 || mapID >= 120 && mapID <= 124 || mapID >= 99 && mapID <= 103 || mapID == 149;
   }

   public static boolean isHD(int var0) {
      return var0 == 91 || var0 == 92 || var0 == 93 || var0 == 94 || var0 == 95 || var0 == 96 || var0 == 97 || var0 == 105 || var0 == 106 || var0 == 107 || var0 == 108 || var0 == 109 || var0 == 114 || var0 == 115 || var0 == 116 || var0 == 125 || var0 == 126 || var0 == 127 || var0 == 128 || var0 == 157 || var0 == 158 || var0 == 159;
   }

   public static void g() {
      if (phong_af) {
         phong_af = false;
         synchronized(bd) {
            bd.notifyAll();
         }
      }

   }

   static {
      az[0] = new short[]{27};
      az[1] = new short[]{2, 3, 27, 72, 91, 94, 105, 114, 125, 157, 139, 113, 80};
      az[2] = new short[]{6, 1};
      az[3] = new short[]{1, 4};
      az[4] = new short[]{3, 5};
      az[5] = new short[]{7, 4};
      az[6] = new short[]{7, 2, 20, 21};
      az[7] = new short[]{6, 5, 8};
      az[8] = new short[]{7, 9};
      az[9] = new short[]{8, 10};
      az[10] = new short[]{9, 11, 17, 22, 32, 38, 43, 48, 139};
      az[11] = new short[]{12, 10};
      az[12] = new short[]{11, 57};
      az[13] = new short[]{57, 14};
      az[14] = new short[]{13, 15};
      az[15] = new short[]{14, 16};
      az[16] = new short[]{15, 17};
      az[17] = new short[]{16, 18, 10, 22, 32, 38, 43, 48, 139};
      az[18] = new short[]{17, 19};
      az[19] = new short[]{18, 58};
      az[20] = new short[]{6};
      az[21] = new short[]{22, 6};
      az[22] = new short[]{23, 21, 10, 17, 32, 38, 43, 48, 139};
      az[23] = new short[]{22, 69, 25};
      az[24] = new short[]{59, 36};
      az[25] = new short[]{23, 26};
      az[26] = new short[]{27, 25};
      az[27] = new short[]{26, 28, 1, 72, 91, 94, 105, 114, 125, 157, 139, 113, 80};
      az[28] = new short[]{27, 60};
      az[29] = new short[]{60, 30};
      az[30] = new short[]{29, 31};
      az[31] = new short[]{32, 30};
      az[32] = new short[]{31, 61, 10, 17, 22, 38, 43, 48, 139};
      az[33] = new short[]{61, 34};
      az[34] = new short[]{35, 33};
      az[35] = new short[]{34, 66};
      az[36] = new short[]{37, 24};
      az[37] = new short[]{36};
      az[38] = new short[]{67, 68, 10, 17, 22, 32, 43, 48, 139};
      az[39] = new short[]{72, 46, 40};
      az[40] = new short[]{39, 65, 41};
      az[41] = new short[]{42, 40, 43};
      az[42] = new short[]{62, 41};
      az[43] = new short[]{41, 44, 10, 17, 22, 32, 38, 48, 139};
      az[44] = new short[]{43, 45};
      az[45] = new short[]{44, 53};
      az[46] = new short[]{63, 39, 47};
      az[47] = new short[]{46, 48};
      az[48] = new short[]{47, 50, 10, 17, 22, 32, 38, 43, 139};
      az[49] = new short[]{50, 51};
      az[50] = new short[]{48, 49};
      az[51] = new short[]{52, 49};
      az[52] = new short[]{51, 64};
      az[53] = new short[]{54, 45};
      az[54] = new short[]{55, 53};
      az[55] = new short[]{54};
      az[56] = new short[]{72};
      az[57] = new short[]{12, 13};
      az[58] = new short[]{19};
      az[59] = new short[]{68, 24};
      az[60] = new short[]{28, 29};
      az[61] = new short[]{33, 32};
      az[62] = new short[]{42};
      az[63] = new short[]{46};
      az[64] = new short[]{52};
      az[65] = new short[]{40};
      az[66] = new short[]{67, 35};
      az[67] = new short[]{66, 38};
      az[68] = new short[]{59, 38};
      az[69] = new short[]{70, 23};
      az[70] = new short[]{69, 71};
      az[71] = new short[]{72, 70};
      az[72] = new short[]{71, 39, 1, 27, 91, 94, 105, 114, 125, 157, 139, 113, 80};
      az[73] = new short[]{1};
      az[74] = new short[0];
      az[75] = new short[0];
      az[76] = new short[0];
      az[77] = new short[0];
      az[78] = new short[0];
      az[79] = new short[0];
      az[80] = new short[]{81, 82, 83};
      az[81] = new short[]{80, 84};
      az[82] = new short[]{80, 85};
      az[83] = new short[]{80, 86};
      az[84] = new short[]{81, 87};
      az[85] = new short[]{82, 88};
      az[86] = new short[]{83, 89};
      az[87] = new short[]{84, 90};
      az[88] = new short[]{85, 90};
      az[89] = new short[]{86, 90};
      az[90] = new short[0];
      az[91] = new short[]{92};
      az[92] = new short[]{91, 93};
      az[93] = new short[]{92};
      az[94] = new short[]{95};
      az[95] = new short[]{94, 96};
      az[96] = new short[]{95, 97};
      az[97] = new short[]{96};
      az[98] = new short[]{99, 120};
      az[99] = new short[]{98, 101, 100, 102};
      az[100] = new short[]{99, 103};
      az[101] = new short[]{99, 103};
      az[102] = new short[]{99, 103};
      az[103] = new short[]{101, 102, 104, 100};
      az[104] = new short[]{103, 124};
      az[105] = new short[]{107, 106, 108};
      az[106] = new short[]{105, 109};
      az[107] = new short[]{105, 109};
      az[108] = new short[]{105, 109};
      az[109] = new short[]{106, 107, 108};
      az[110] = new short[0];
      az[111] = new short[0];
      az[112] = new short[]{113};
      az[113] = new short[]{112};
      az[114] = new short[]{115};
      az[115] = new short[]{114, 116};
      az[116] = new short[]{115};
      az[117] = new short[0];
      az[118] = new short[0];
      az[119] = new short[0];
      az[120] = new short[]{121, 122, 123, 98};
      az[121] = new short[]{120, 124};
      az[122] = new short[]{120, 124};
      az[123] = new short[]{120, 124};
      az[124] = new short[]{123, 122, 121, 104};
      az[125] = new short[]{126};
      az[126] = new short[]{125, 127};
      az[127] = new short[]{126, 128};
      az[128] = new short[]{127};
      az[129] = new short[0];
      az[130] = new short[0];
      az[131] = new short[0];
      az[132] = new short[0];
      az[133] = new short[0];
      az[134] = new short[]{138};
      az[135] = new short[]{138};
      az[136] = new short[]{138};
      az[137] = new short[]{138};
      az[138] = new short[]{134, 135, 136, 137};
      az[139] = new short[]{140};
      az[140] = new short[]{139, 141};
      az[141] = new short[]{140, 142};
      az[142] = new short[]{141, 143};
      az[143] = new short[]{142, 144};
      az[144] = new short[]{143, 145};
      az[145] = new short[]{144, 146};
      az[146] = new short[]{145, 147};
      az[147] = new short[]{146, 148};
      az[148] = new short[]{147};
      az[149] = new short[0];
      az[150] = new short[0];
      az[151] = new short[0];
      az[152] = new short[0];
      az[153] = new short[0];
      az[154] = new short[0];
      az[155] = new short[0];
      az[156] = new short[0];
      az[157] = new short[]{158, 159};
      az[158] = new short[]{157, 159};
      az[159] = new short[]{158, 157};
      phong_ad = -1;
      phong_ae = false;
      phong_af = false;
      bd = new Object();
      be = new byte[160][];

      for(int var0 = 0; var0 < 160; ++var0) {
         int var1 = var0;
         InputStream var2 = null;

         try {
            var2 = RMS.fieldAA("/map/" + var1);
            if (var2 == null) continue;
            be[var1] = new byte[var2.available()];
            var2.read(be[var1]);
            var2.close();
         } catch (Exception var12) {
            ;
         } finally {
            try {
               if (var2 != null) var2.close();
            } catch (Exception var11) {
            }

         }
      }

      bf = new Image[6];
      bg = new Image[6];
   }
}
