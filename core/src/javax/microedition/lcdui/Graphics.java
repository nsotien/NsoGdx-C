/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.microedition.lcdui;

import static base.lib.mGraphics.zoomLevel;

import com.monkey.nso.lib.Shader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.monkey.nso.NSO;

import java.util.Hashtable;

public class Graphics {

    public static final int LEFT = 4;
    public static final int TOP = 16;
    public float r;

    public float g;

    public float b;

    public float a;

    public int clipX;

    public int clipY;

    public int clipW;

    public int clipH;

    private int clipTX;

    private int clipTY;

    public boolean isClip;

    private boolean isTranslate = true;

    private int translateX;

    private int translateY;

    public static Hashtable<String, Texture> cachedTextures = new Hashtable<>();

    public Vector2 size = new Vector2(128, 128);
    public SpriteBatch graphics;

    public Graphics(SpriteBatch g) {
        graphics = g;
    }

    public Graphics(Image g) {
        SpriteBatch spriteBatch = new SpriteBatch();
        spriteBatch.begin();
        // spriteBatch.draw(g.texture, 0, 0);
        graphics = spriteBatch;
    }

    public Graphics() {
    }

    private void cache(String key, Texture value) {
        if (cachedTextures.size() > 400) {
            cachedTextures.clear();
        }
        if (value.getWidth() * value.getHeight() < Gdx.graphics.getWidth() * Gdx.graphics.getHeight()) {
            cachedTextures.put(key, value);
        }
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        String key = "fr" + r + g + b + a;
        Texture texture = cachedTextures.get(key);
        if (texture == null) {
            Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            p.setColor(this.r, this.b, this.g, this.a);
            texture = new Texture(p);
            p.dispose();
            cache(key, texture);
        }
        int num3;
        int num4;
        int num5;
        int num6;
        if (isTranslate) {
            x += translateX;
            y += translateY;
        }
        x += width / 2;
        y += height / 2;
        if (this.isClip) {
            num3 = this.clipX;
            num4 = this.clipY;
            num5 = this.clipW;
            num6 = this.clipH;
            Rectangle scissors = new Rectangle();
            if (this.isTranslate) {
                num3 += this.clipTX;
                num4 += this.clipTY;
            }
            Rectangle clipBounds = new Rectangle(num3, num4, num5, num6);
            ScissorStack.calculateScissors(NSO.instance.camera, this.graphics.getTransformMatrix(), clipBounds, scissors);
            ScissorStack.pushScissors(scissors);
        }
        int segments = 3600;  // The number of segments to approximate the arc
        float angleStep = arcAngle / (float) segments;  // Step in degrees between each segment
        float radiusX = width / 2f;  // Horizontal radius of the arc
        float radiusY = height / 2f; // Vertical radius of the arc

        // Calculate the center of the arc
        float centerX = x;
        float centerY = y;

        // Loop through each segment and draw a texture to approximate the arc
        for (int i = 0; i <= segments; i++) {
            // Calculate the current angle in radians
            float angle = (startAngle + i * angleStep) * (float) Math.PI / 180f;

            // Calculate the position of the texture at the current angle
            float posX = centerX + radiusX * (float) Math.cos(angle);
            float posY = centerY + radiusY * (float) Math.sin(angle);

            // Draw the texture at the calculated position
            graphics.draw(texture, posX, posY, 1, 1);
        }
        if (this.isClip) {
            this.graphics.flush();
            ScissorStack.popScissors();
        }

    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    }

    public static Texture createTextureFromRGB(int[] rgbArray, int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = rgbArray[y * width + x];
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int a = 255;
                pixmap.drawPixel(x, y, (r << 24) | (g << 16) | (b << 8) | a);
            }
        }
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

    public static int[] getRGBFromTexture(Texture texture) {
        texture.getTextureData().prepare();
        Pixmap pixmap = texture.getTextureData().consumePixmap();

        int width = pixmap.getWidth();
        int height = pixmap.getHeight();
        int[] rgbArray = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixmap.getPixel(x, y);
                int r = (pixel >> 24) & 0xff;
                int g = (pixel >> 16) & 0xff;
                int b = (pixel >> 8) & 0xff;
                rgbArray[y * width + x] = (r << 16) | (g << 8) | b;
            }
        }
        pixmap.dispose();
        return rgbArray;
    }

    public void translate(int tx, int ty) {
        translateX += tx;
        translateY += ty;
        isTranslate = translateX != 0 || translateY != 0;
    }

    public int getTranslateX() {
        return translateX;
    }

    public int getTranslateY() {
        return translateY;
    }

    public void setClip(int x, int y, int w, int h) {
        clipTX = translateX;
        clipTY = translateY;
        clipX = x;
        clipY = y;
        clipW = w;
        clipH = h;
        isClip = true;
    }

    public void begin() {
        this.graphics.begin();
    }

    public void end() {
        this.translateX = 0;
        this.translateY = 0;
        this.isTranslate = false;
        this.isClip = false;
        this.graphics.end();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        if (y1 == y2) {
            if (x1 > x2) {
                int num = x2;
                x2 = x1;
                x1 = num;
            }
            fillRect(x1, y1, x2 - x1, 1);
            return;
        }
        if (x1 == x2) {
            if (y1 > y2) {
                int num2 = y2;
                y2 = y1;
                y1 = num2;
            }
            fillRect(x1, y1, 1, y2 - y1);
            return;
        }
        if (isTranslate) {
            x1 += translateX;
            y1 += translateY;
            x2 += translateX;
            y2 += translateY;
        }
        Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        p.setColor(this.r, this.b, this.g, this.a);
        p.drawPixel(0, 0);
        Texture texture = new Texture(p);
        p.dispose();
        float xSl = (float) Math.sqrt(((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1)));
        Vector2 start = new Vector2(x1, y1);
        Vector2 end = new Vector2(x2, y2);
        float angle = getAngle(start, end);
        int num3;
        int num4;
        int num5;
        int num6;
        if (this.isClip) {
            num3 = this.clipX;
            num4 = this.clipY;
            num5 = this.clipW;
            num6 = this.clipH;
            Rectangle scissors = new Rectangle();
            if (this.isTranslate) {
                num3 += this.clipTX;
                num4 += this.clipTY;
            }
            Rectangle clipBounds = new Rectangle(num3, num4, num5, num6);
            ScissorStack.calculateScissors(NSO.instance.camera, this.graphics.getTransformMatrix(), clipBounds, scissors);
            ScissorStack.pushScissors(scissors);
        }
        this.graphics.draw(texture, x1, y1, 0.0f, 0.0f, 1.0f, 1.0f, xSl, 1, angle, 0, 0, 1, 1, false, false);
        if (this.isClip) {
            this.graphics.flush();
            ScissorStack.popScissors();
        }
    }

    public float getAngle(Vector2 centerPt, Vector2 target) {
        float angle = (float) Math.toDegrees(Math.atan2(target.y - centerPt.y, target.x - centerPt.x));
        if (angle < 0.0f) {
            angle += 360.0f;
        }
        return angle;
    }

    public void drawRect(int x, int y, int w, int h) {
        int num = 1;
        fillRect(x, y, w, num);
        fillRect(x, y, num, h);
        fillRect(x + w, y, num, h + 1);
        fillRect(x, y + h, w + 1, num);
    }

    public void fillRect(int x, int y, int w, int h) {
        if (w < 0 || h < 0) {
            return;
        }
        if (isTranslate) {
            x += translateX;
            y += translateY;
        }
        String key = "fr" + r + g + b + a;
        Texture texture2D = cachedTextures.get(key);
        if (texture2D == null) {
            Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            p.setColor(this.r, this.b, this.g, this.a);
            p.fillRectangle(0, 0, 1, 1);
            texture2D = new Texture(p);
            p.dispose();
            cache(key, texture2D);
        }
        int num3;
        int num4;
        int num5;
        int num6;
        if (this.isClip) {
            num3 = this.clipX;
            num4 = this.clipY;
            num5 = this.clipW;
            num6 = this.clipH;
            Rectangle scissors = new Rectangle();
            if (this.isTranslate) {
                num3 += this.clipTX;
                num4 += this.clipTY;
            }
            Rectangle clipBounds = new Rectangle(num3, num4, num5, num6);
            ScissorStack.calculateScissors(NSO.instance.camera, this.graphics.getTransformMatrix(), clipBounds, scissors);
            ScissorStack.pushScissors(scissors);
        }
        this.graphics.draw(texture2D, x, y, w, h);
        if (this.isClip) {
            this.graphics.flush();
            ScissorStack.popScissors();
        }
    }

    public void _setColor(float i, float i0, float i1) {
        this.r = i;
        this.g = i0;
        this.b = i1;
        this.a = 1.0f;
    }

    public void _setColor(float i, float i0, float i1, float a) {
        this.r = i;
        this.g = i0;
        this.b = i1;
        this.a = a;
    }

    public void setColor(float i, float i0, float i1) {
        this.r = i / 255.0f;
        this.g = i0 / 255.0f;
        this.b = i1 / 255.0f;
        this.a = 1.0f;
    }

    public void setColor(float i, float i0, float i1, float a) {
        this.r = i / 255.0f;
        this.g = i0 / 255.0f;
        this.b = i1 / 255.0f;
        this.a = a;
    }

    /*
    public void setColor2(float i, float i0, float i1, float a) {
        setColor(toLibGDXColor(i, i0, i1, a));
    }

    public void setColor2(int a) {
        setColor(new Color(a));
    }

    public void setColor2(String a) {
        setColor(Color.valueOf(a));
    }*/
    public static com.badlogic.gdx.graphics.Color toLibGDXColor(float r, float g, float b, float a) {
        // Chia mỗi giá trị RGBA cho 255.0 để chuyển sang dạng float
        float libgdxR = r / 255.0f;
        float libgdxG = g / 255.0f;
        float libgdxB = b / 255.0f;
        float libgdxA = a / 255.0f;

        // Tạo và trả về đối tượng Color của LibGDX
        return new com.badlogic.gdx.graphics.Color(libgdxR, libgdxG, libgdxB, libgdxA);
    }

    public void setColor(Color c) {
        this.r = c.r;
        this.g = c.b;
        this.b = c.g;
        this.a = c.a;
    }

    public final void setHue(float var1) {
        try {
            ShaderProgram var2;
            if ((var2 = Shader.d()).isCompiled()) {
                graphics.end();
                var2.begin();
                var2.setUniformf("hue", var1);
                var2.end();
                graphics.setShader(var2);
                graphics.begin();
            }

        } catch (Exception var3) {
        }
    }

    public final void o() {
        try {
            ShaderProgram var1;
            if ((var1 = Shader.f()).isCompiled()) {
                graphics.end();
                graphics.setShader(var1);
                graphics.begin();
            }

        } catch (Exception var2) {
        }
    }

    public final void setCB(float var1, float var2) {
        try {
            ShaderProgram var3;
            if ((var3 = Shader.b()).isCompiled()) {
                graphics.end();
                var3.begin();
                var3.setUniformf("contrast", var1);
                var3.setUniformf("brightness", var2);
                var3.end();
                graphics.setShader(var3);
                graphics.begin();
            }

        } catch (Exception var4) {
        }
    }

    public final void p() {
        try {
            ShaderProgram var1;
            if ((var1 = Shader.g()).isCompiled()) {
                graphics.end();
                graphics.setShader(var1);
                graphics.begin();
            }

        } catch (Exception var2) {
        }
    }

    public final void endShader() {
        if (graphics.getShader() == null) {
            return;
        }
        graphics.end();
        graphics.setShader((ShaderProgram) null);
        graphics.begin();
    }

    public final void setHue2(float var1) {
        try {
            ShaderProgram var2;
            if ((var2 = Shader.e()).isCompiled()) {
                graphics.end();
                var2.begin();
                var2.setUniformf("hue", var1);
                var2.end();
                graphics.setShader(var2);
                graphics.begin();
            }

        } catch (Exception var3) {
        }
    }

    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16), 1f);
    }

    public void setColor(String hex) {
        Color c = Color.valueOf(hex);

        this.r = c.r;
        this.g = c.g;
        this.b = c.b;
        this.a = c.a;
    }

    public void setColor(int rgb) {
        float R = (rgb >> 16) & 255;
        float B = (rgb >> 8) & 255;
        float G = rgb & 255;
        this.r = R / 256.0f;
        this.g = G / 256.0f;
        this.b = B / 256.0f;
        this.a = 1.0f;

    }

    public void setColor(int rgb, float alpha) {
        float R = (rgb >> 16) & 255;
        float B = (rgb >> 8) & 255;
        float G = rgb & 255;
        this.b = B / 256.0f;
        this.g = G / 256.0f;
        this.r = R / 256.0f;
        this.a = alpha;
    }

    public void drawRegion(Texture arg0, int x0, int y0, int w0, int h0, int transform, int x, int y, int anchor) {
        _drawRegion(arg0, x0, y0, w0, h0, transform, x, y, anchor);
    }

    /** Like drawRegion but dest size = src * scale — fixes bitmap font spacing when mGraphics.b > 1 */
    public void drawRegionScaled(Texture image, int x_src, int y_src, int width, int height, int x_dest, int y_dest, int scale) {
        if (image == null) return;
        if (this.isTranslate) {
            x_dest += this.translateX;
            y_dest += this.translateY;
        }
        int dw = width * scale;
        int dh = height * scale;
        if (this.isClip) {
            int num3 = this.clipX, num4 = this.clipY, num5 = this.clipW, num6 = this.clipH;
            Rectangle scissors = new Rectangle();
            if (this.isTranslate) { num3 += this.clipTX; num4 += this.clipTY; }
            Rectangle clipBounds = new Rectangle(num3, num4, num5, num6);
            ScissorStack.calculateScissors(NSO.instance.camera, this.graphics.getTransformMatrix(), clipBounds, scissors);
            ScissorStack.pushScissors(scissors);
        }
        this.graphics.draw(image, x_dest, y_dest, 0f, 0f, dw, dh, 1f, 1f, 0, x_src, y_src, width, height, false, true);
        if (this.isClip) {
            this.graphics.flush();
            ScissorStack.popScissors();
        }
    }

    public void _drawRegion(Texture image, int x_src, int y_src, int width, int height, int flip, int x_dest, int y_dest, int anchor) {
        if (image == null) {
            return;
        }
        if (this.isTranslate) {
            x_dest += this.translateX;
            y_dest += this.translateY;
        }
        boolean flipX = false;
        boolean flipY = true;
        int ixA = 0;
        int iyA = 0;
        switch (anchor) {
            case 0:
            case 20:
                break;
            case 3:
                ixA = width / 2;
                iyA = height / 2;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height / 2;
                    iyA = width / 2;
                    break;
                }
                break;
            case 6:
                iyA = height / 2;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    iyA = width / 2;
                    break;
                }
                break;
            case 10:
                ixA = width;
                iyA = height / 2;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height;
                    iyA = width / 2;
                    break;
                }
                break;
            case 17:
                ixA = width / 2;
                if (flip == 4 || flip == 6 || flip == 5 || flip == 7) {
                    ixA = height / 2;
                }
                break;
            case 24:
                ixA = width;
                if (flip == 4 || flip == 6 || flip == 5 || flip == 7) {
                    ixA = height;
                }
                break;
            case 33:
                ixA = width / 2;
                iyA = height;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height / 2;
                    iyA = width;
                    break;
                }
                break;
            case 36:
                iyA = height;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    iyA = width;
                    break;
                }
                break;
            case 40:
                ixA = width;
                iyA = height;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height;
                    iyA = width;
                    break;
                }
                break;
        }
        int x_dest2 = x_dest - ixA;
        int y_dest2 = y_dest - iyA;
        int ix = 0;
        int iy = 0;
        switch (flip) {
            case 1:
                flip = 0;
                flipY = false;
                break;
            case 2:
                flip = 0;
                flipX = true;
                break;
            case 3:
                flip = 180;
                iy = -height;
                ix = -width;
                break;
            case 4:
                flip = 90;
                flipY = false;
                ix = -height;
                break;
            case 5:
                flip = 90;
                ix = -height;
                break;
            case 6:
                flip = 90;
                flipY = false;
                flipX = true;
                ix = -height;
                break;
            case 7:
                flip = 90;
                flipX = true;
                ix = -height;
                break;
        }
        if(flip<0){
            flip = -flip;
        }
        int num3;
        int num4;
        int num5;
        int num6;
        if (this.isClip) {
            num3 = this.clipX;
            num4 = this.clipY;
            num5 = this.clipW;
            num6 = this.clipH;
            Rectangle scissors = new Rectangle();
            if (this.isTranslate) {
                num3 += this.clipTX;
                num4 += this.clipTY;
            }
            Rectangle clipBounds = new Rectangle(num3, num4, num5, num6);
            ScissorStack.calculateScissors(NSO.instance.camera, this.graphics.getTransformMatrix(), clipBounds, scissors);
            ScissorStack.pushScissors(scissors);
        }
        this.graphics.draw(image, x_dest2 - ix, y_dest2 - iy, 0.0f, 0.0f, width, height, 1f, 1f, flip, x_src, y_src, width, height, flipX, flipY);
        if (this.isClip) {
            this.graphics.flush();
            ScissorStack.popScissors();
        }
    }
    public void drawRegion(Sprite sprite, int x_src, int y_src, int width, int height, int flip, int x_dest, int y_dest, int anchor) {
        if (sprite == null) {
            return;
        }

        // Lưu trạng thái gốc của sprite
        float originalX = sprite.getX();
        float originalY = sprite.getY();
        float originalRotation = sprite.getRotation();
        boolean originalFlipX = sprite.isFlipX();
        boolean originalFlipY = sprite.isFlipY();

        // Xử lý translation
        if (isTranslate) {
            x_dest += translateX;
            y_dest += translateY;
        }

        // Xử lý anchor point
        int ixA = 0;
        int iyA = 0;
        switch (anchor) {
            case 0:
            case 20:
                break;
            case 3:
                ixA = width / 2;
                iyA = height / 2;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height / 2;
                    iyA = width / 2;
                    break;
                }
                break;
            case 6:
                iyA = height / 2;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    iyA = width / 2;
                    break;
                }
                break;
            case 10:
                ixA = width;
                iyA = height / 2;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height;
                    iyA = width / 2;
                    break;
                }
                break;
            case 17:
                ixA = width / 2;
                if (flip == 4 || flip == 6 || flip == 5 || flip == 7) {
                    ixA = height / 2;
                }
                break;
            case 24:
                ixA = width;
                if (flip == 4 || flip == 6 || flip == 5 || flip == 7) {
                    ixA = height;
                }
                break;
            case 33:
                ixA = width / 2;
                iyA = height;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height / 2;
                    iyA = width;
                    break;
                }
                break;
            case 36:
                iyA = height;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    iyA = width;
                    break;
                }
                break;
            case 40:
                ixA = width;
                iyA = height;
                if (flip == 4 || flip == 7 || flip == 6 || flip == 5) {
                    ixA = height;
                    iyA = width;
                    break;
                }
                break;
        }
        // [Code xử lý anchor giống như trong _drawRegion]

        int x_dest2 = x_dest - ixA;
        int y_dest2 = y_dest - iyA;

        // Xử lý flip và rotation
        boolean flipX = false;
        boolean flipY = true;
        float rotation = 0;
        int ix = 0;
        int iy = 0;

        switch (flip) {
            case 1:
                flipY = false;
                break;
            case 2:
                flipX = true;
                break;
            case 3:
                rotation = 180;
                iy = -height;
                ix = -width;
                break;
            case 4:
                rotation = 90;
                flipY = false;
                ix = -height;
                break;
            case 5:
                rotation = 90;
                ix = -height;
                break;
            case 6:
                rotation = 90;
                flipY = false;
                flipX = true;
                ix = -height;
                break;
            case 7:
                rotation = 90;
                flipX = true;
                ix = -height;
                break;
        }

        // Áp dụng các thuộc tính cho sprite
        sprite.setPosition(x_dest2 - ix, y_dest2 - iy);
        sprite.setRotation(rotation);
        sprite.setFlip(flipX, flipY);
        sprite.setRegion(x_src, y_src, width, height);

        // Xử lý clipping nếu cần
        if (isClip) {
            Rectangle scissors = new Rectangle();
            Rectangle clipBounds = new Rectangle(
                    clipX + (isTranslate ? clipTX : 0),
                    clipY + (isTranslate ? clipTY : 0),
                    clipW,
                    clipH
            );
            ScissorStack.calculateScissors(NSO.instance.camera, graphics.getTransformMatrix(), clipBounds, scissors);
            ScissorStack.pushScissors(scissors);
        }

        // Vẽ sprite
        sprite.draw(graphics);

        // Khôi phục clipping
        if (isClip) {
            graphics.flush();
            ScissorStack.popScissors();
        }

        // Khôi phục trạng thái gốc của sprite
    }

    public void drawImage(Texture image, int x, int y, int anchor) {
        if (image != null) {
            drawRegion(image, 0, 0, getImageWidth(image), getImageHeight(image), 0, x, y, anchor);
        }
    }

    public void drawImage(Texture image, int x, int y) {
        if (image != null) {
            drawRegion(image, 0, 0, getImageWidth(image), getImageHeight(image), 0, x, y, TOP | LEFT);
        }
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        fillRect(x, y, width, height);
    }

    public static int getImageWidth(Texture image) {
        return image.getWidth();
    }

    public static int getImageHeight(Texture image) {
        return image.getHeight();
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        // Simple implementation: draw as regular rect border (no rounded corners)
        // Avoids Pixmap/Texture creation every frame (memory leak + performance)
        drawRect(x, y, width, height);
    }

    // Sửa lỗi NullPointerException trong drawString
    public void drawString(String s, float x, float y, BitmapFont font, int al, boolean useClip) {
        // Kiểm tra null để tránh crash
        if (s == null || font == null) {
            ;
            return;
        }

        // Lọc chuỗi để loại bỏ các ký tự không hợp lệ
        StringBuilder filteredString = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            // Kiểm tra xem ký tự có trong font không
            if (font.getData().hasGlyph(c)) {
                filteredString.append(c);
            } else {
                // Thay thế bằng ký tự mặc định hoặc bỏ qua
                filteredString.append('?'); // hoặc comment dòng này để bỏ qua ký tự
            }
        }

        s = filteredString.toString();

        // Nếu chuỗi rỗng sau khi lọc, không cần vẽ
        if (s.isEmpty()) {
            return;
        }

        x *= (float) zoomLevel;
        y *= (float) zoomLevel;

        if (this.isTranslate) {
            x += this.translateX;
            y += this.translateY;
        }

        // Xử lý clipping như code gốc
        if (this.isClip) {
            int num3 = this.clipX;
            int num4 = this.clipY;
            int num5 = this.clipW;
            int num6 = this.clipH;
            Rectangle scissors = new Rectangle();
            if (this.isTranslate) {
                num3 += this.clipTX;
                num4 += this.clipTY;
            }
            Rectangle clipBounds = new Rectangle(num3, num4, num5, num6);
            ScissorStack.calculateScissors(NSO.instance.camera, this.graphics.getTransformMatrix(), clipBounds, scissors);
            ScissorStack.pushScissors(scissors);
        }

        try {
            font.draw(this.graphics, s, x, y, 0.0F, al, useClip);
        } catch (Exception e) {
            // Log lỗi để debug thay vì crash
            ;

            // Cách tiếp cận an toàn hơn - sử dụng GlyphLayout
            try {
                GlyphLayout layout = new GlyphLayout();
                layout.setText(font, s);
                float drawX = x;
                if (al == 1) { // Center alignment
                    drawX = x - layout.width / 2;
                } else if (al == 2) { // Right alignment
                    drawX = x - layout.width;
                }
                font.draw(graphics, s, drawX, y);
            } catch (Exception e2) {
                ;
            }
        }

        if (this.isClip) {
            this.graphics.flush();
            ScissorStack.popScissors();
        }
    }
}
