package javax.microedition.lcdui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.monkey.nso.NSO;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
//import lib.LibSysTem;
//import lib.mGraphics;
//import lib.mSystem;

public class Image {

    public Texture texture;
    public Pixmap pixmap;
    public TextureRegion tRegion;
    public int width;
    public int height;
    public long lastTimeGet;
    private boolean clean;

    public static Image createRGBImage(int[] encodedData, int w, int h, boolean ispaint) {
        Image img = new Image();

        try {
            Pixmap p = new Pixmap(w, h, Format.RGBA8888);

            for (int i = 0; i < w; ++i) {
                for (int j = 0; j < h; ++j) {
                    p.setColor(setColor(encodedData[j * w + i]));
                    p.drawPixel(i, j);
                }
            }

            byte[] a = int2byte(encodedData);
            img.pixmap = p;
            //   img.texture = new Texture(p);
            img.width = img.pixmap.getWidth();
            img.height = img.pixmap.getHeight();
        } catch (Exception var8) {
        }

        return img;
    }

    public static int zoomLevel = 1;

    public static Image createImage(Texture t) {
        Image img = new Image();

        try {

            img.texture = t;
            img.width = img.texture.getWidth();
            img.height = img.texture.getHeight();
        } catch (Exception var3) {
        }

        return img;
    }

    public static HashMap<String, Image> hash = new HashMap<>();
    public static HashMap<Integer, Image> hash2 = new HashMap<>();

    public static Image _createImage(String url) {
        // Strip leading "/" to avoid double-slash
        if (url != null && url.startsWith("/")) {
            url = url.substring(1);
        }
        Image _img = hash.get(url);
        if (hash.get(url) != null) {
            return _img;
        }
        Image img = new Image();

        try {
            Texture t = null;
            img.strFile = url;
            if (zoomLevel == 1) {
                //  t = new Texture(Gdx.files.internal("Nso/" + url), Format.RGBA4444, false);
            } else {
                // t = new Texture(Gdx.files.internal("Nso/" + url));
            }

            img.pixmap = new Pixmap(Gdx.files.internal("Nso/" + url));
            img.texture = t;
            img.width = img.pixmap.getWidth();
            img.height = img.pixmap.getHeight();
        } catch (Exception var3) {

        }
        if (img.pixmap != null) {
            hash.put(url, img);
        }

        return img.pixmap == null ? null : img;
    }

    public static Image createImage(String url) {
        return _createImage(url);
    }

    public boolean notzoom;
    private String strFile;
    private int h;
    private int w;

    public int getWidth() {
        return this.width / zoomLevel;
    }

    public int getHeight() {
        return this.height / zoomLevel;
    }

    public int _getWidth() {
        return this.width;
    }

    public int _getHeight() {
        return this.height;
    }

    public static Image createImageTextureRegion() {
        Image img = new Image();
        img.tRegion = new TextureRegion();
        img.tRegion.flip(false, true);
        return img;
    }

    public static Image createImage(int w, int h) {

        return _createImage(w, h);
    }

    public static Image _createImage(int w, int h) {
        Image img = new Image();
        img.w = w;
        img.h = h;
        img.pixmap = new Pixmap(w, h, Format.RGBA4444);
        //Texture t = new Texture(w, h, Format.RGBA4444);
        //img.texture = t;
        img.width = img.pixmap.getWidth();
        img.height = img.pixmap.getHeight();
        return img;
    }

    public byte[] arrayTemp = null;

    public static Image _createImage(byte[] encodedData, int offset, int len) {
        int hashCode =encodedData.hashCode();
        Image _img = hash2.get(hashCode);
        if (hash2.get(hashCode) != null) {
            return _img;
        }
        Image img = new Image();

        try {
            img.pixmap = new Pixmap(encodedData, offset, len);
            //img.texture = new Texture(new Pixmap(encodedData, offset, len));
            img.width = img.pixmap.getWidth();
            img.height = img.pixmap.getHeight();
            img.clean = true;
            img.arrayTemp = encodedData;

        } catch (Exception var5) {
        }
        if( img.pixmap!=null)
            hash2.put(hashCode,img);
        return img.pixmap == null ? null : img;
    }

    public static Image createImage(byte[] encodedData, int offset, int len) {

        return _createImage(encodedData, offset, len);
    }

    // J2ME compat: createImage from InputStream
    public static Image createImage(java.io.InputStream is) {
        try {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            byte[] buf = new byte[4096];
            int n;
            while ((n = is.read(buf)) != -1) {
                baos.write(buf, 0, n);
            }
            byte[] data = baos.toByteArray();
            return createImage(data, 0, data.length);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] int2byte(int[] src) {
        int srcLength = src.length;
        byte[] dst = new byte[srcLength << 2];

        for (int i = 0; i < srcLength; ++i) {
            int x = src[i];
            int j = i << 2;
            dst[j++] = (byte) (x >>> 0 & 255);
            dst[j++] = (byte) (x >>> 8 & 255);
            dst[j++] = (byte) (x >>> 16 & 255);
            dst[j++] = (byte) (x >>> 24 & 255);
        }

        return dst;
    }

    public static Color setColor(int rgb) {
        float R = rgb >> 16 & 0xFF;
        float G = rgb >> 8 & 0xFF;
        float B = rgb & 0xFF;

        float b = B / 256.0F;
        float g = G / 256.0F;
        float r = R / 256.0F;

        return new Color(r, g, b, 1.0F);
    }

    public static Image createImage(int[] encodedData, int w, int h) {
        Image img = new Image();

        try {
            Pixmap p = new Pixmap(w, h, Format.RGBA8888);

            for (int i = 0; i < w; ++i) {
                for (int j = 0; j < h; ++j) {
                    p.setColor(setColor(encodedData[j * w + i]));
                    p.drawPixel(i, j);
                }
            }

            byte[] a = int2byte(encodedData);
            img.pixmap = p;
            //img.texture = new Texture(p);
            img.width = img.pixmap.getWidth();
            img.height = img.pixmap.getHeight();
        } catch (Exception var7) {
        }

        return img;
    }

    public static InputStream getResourceAsStream(String path) {
        // Strip leading "/" to avoid double-slash in path
        if (path != null && path.startsWith("/")) {
            path = path.substring(1);
        }
        try {
            InputStream in = Gdx.files.internal("Nso/" + path).read();
            if (in == null) {
                ;
            }
            return in;
        } catch (Exception e) {
            ;
            return null;
        }
    }

    public static DataInputStream openFile(String path) {
        DataInputStream is = new DataInputStream(getResourceAsStream(path));
        return is;
    }

    public static int argb(int alpha, int red, int green, int blue) {
        return alpha << 24 | red << 16 | green << 8 | blue;
    }

    public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
        if (this.texture == null) {
            throw new IllegalArgumentException("texture Image getRGB is NULL-----------.");
        } else {
            try {
                TextureData tData = this.texture.getTextureData();
                if (!tData.isPrepared()) {
                    tData.prepare();
                }

                Pixmap a = tData.consumePixmap();
                boolean isRGB888 = false;
                if (a.getFormat() == Format.RGB888) {
                }

                int[] r = new int[width * height];
                Color color = new Color();

                int i;
                for (i = 0; i < width; ++i) {
                    for (int j = 0; j < height; ++j) {
                        int val = a.getPixel(i + x, j + y);
                        if (isRGB888) {
                            Color.rgb888ToColor(color, val);
                        } else {
                            Color.rgba8888ToColor(color, val);
                        }

                        int R = (int) (color.r * 255.0F);
                        int G = (int) (color.g * 255.0F);
                        int B = (int) (color.b * 255.0F);
                        int A = (int) (color.a * 255.0F);
                        if (isRGB888) {
                            A = 255;
                        }

                        r[j * width + i] = argb(A, R, G, B);
                    }
                }

                for (i = 0; i < rgbData.length; ++i) {
                    rgbData[i] = r[i];
                }
            } catch (Exception var20) {
            }

        }
    }

    public static String getLink(String str) {
        return str;
    }

    public static String replaceImg(String str) {
        String tam = str.replace(".img", ".png");
        return tam;
    }

    public static int getImageWidth(Image image) {
        return image == null ? 0 : image._getWidth() / 1;
    }

    public static int getImageHeight(Image image) {
        return image == null ? 0 : image._getHeight() / 1;
    }

    public static Image createImage(Pixmap px) {
        Image img = new Image();

        try {
            Texture t = null;
            img.pixmap = px;
            if (zoomLevel == 1) {
                // t = new Texture(px, Format.RGBA4444, false);
            } else {
                //  t = new Texture(px);
            }

            img.texture = t;
            img.width = img.pixmap.getWidth();
            img.height = img.pixmap.getHeight();
        } catch (Exception var3) {
        }

        return img;
    }

    public Graphics getGraphics() {
        // Return a Graphics wrapper for drawing on this image
        // For LibGDX, this is a no-op stub since off-screen rendering
        // uses different approach. Return main graphics as fallback.
        return com.monkey.nso.NSO.instance != null ? com.monkey.nso.NSO.instance.graphics : null;
    }


    public Texture getTexture() {
        this.lastTimeGet = System.currentTimeMillis();
        if (this.texture == null) {
            if (pixmap == null) {
                if (arrayTemp == null)
                    return null;
                pixmap = new Pixmap(arrayTemp, 0, arrayTemp.length);
            }
            this.texture = new Texture(pixmap);
            pixmap.dispose();
            pixmap = null;
            if (clean) {
                if (!NSO.vecCleanIm.contains(this))
                    NSO.vecCleanIm.add(this);
            }
        }
        return texture;

    }

    public void clean() {
        if (texture != null) {
            texture.dispose();
            texture = null;
        }
    }
}
