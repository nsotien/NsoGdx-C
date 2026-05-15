package com.monkey.nso;

import base.game1.Code;
import base.game1.GameMidlet;
import base.game1.MotherCanvas;
import base.game1.RMS;
import base.lib.mGraphics;
import com.badlogic.gdx.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.monkey.nso.lib.*;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.IntBuffer;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class NSO extends Game implements ApplicationListener {

    public static byte a = 1;
    public static byte b = 0;
    public static int c = 14444;
    public static String d = "";
    public static byte e = 0;
    public static String f;
    public static Canvas gameCanvas;
    public MenuCustom menuCustom;
    public static NSO instance;
    public static byte h = 0;
    public static boolean i = false;
    public static String j = "";
    public static String k = "";
    private static String s = "Local:127.0.0.1:14444:0:0";
    private static String t = "Local:127.0.0.1:14444:0:0";
    public static String[] l;
    public static String[] m;
    public static short[] n;
    public static byte[] o;
    public static byte[] p;
    public static byte[] q;
    public static String ww = "";
    public OrthographicCamera camera;
    public Viewport viewport;
    public InputMultiplexer inputMultiplexer;
    private MyInputProcessor inputProcessor;
    private MyGestureHandler gestureHandler;

    public static int WIDTH = 380;
    public static int HEIGHT;
    private static int SAFE_ZONE_TOP;
    private static int SAFE_ZONE_BOTTOM;
    public Graphics graphics;
    public static String kz = " 0123456789+-*='\"\\/_?.,ˋˊ~ˀ:;|<>[]{}!@#$%^&*()aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
    public static KeyBoard keyBoard;
    public static boolean showKeyBoard = false;
    private static Hashtable dz = new Hashtable();
    public static Vector<Image> vecCleanIm = new Vector();
    public static Vector<Image> vImageNeedCreate = new Vector();

    public static int zoomLevel;
    private boolean isZoom;
    public static PlatformConfig platformConfig;
    public static int[] enabledClientTypes = {0, 1, 2};
    public static int lockedTypeClient = -1;

    public static void doitab(int c) {
        if (c == 1) {
            base.game1.MotherCanvas.gI().zoomLevel = zoomLevel;
            new base.game1.GameMidlet(0);
        } else if (c == 2) {
            base.game2.MotherCanvas.gI().zoomLevel = zoomLevel;
            new base.game2.GameMidlet(1);
        }
    }

    public void create() {
        int typeClient = RMS.gameAC("typeClient");
        if (typeClient <= 0) {
            typeClient = 0;
        }

        System.setErr(new PrintStream(new OutputStream() {
            public void write(int b) {
            }
        }));
        System.setOut(new PrintStream(new OutputStream() {
            public void write(int b) {
            }
        }));

        dz.put(8, 8);
        dz.put(22, 22);
        dz.put(127, 127);

        for (int var0 = 0; var0 < kz.length(); ++var0) {
            char var1 = kz.charAt(var0);
            dz.put(Integer.valueOf(var1), Integer.valueOf(var1));
        }
        if (!Objects.equals(Thread.currentThread().getName(), "Main")) {
            Thread.currentThread().setName("Main");
        }
        PlatformConfig cfg = PlatformConfig.detect(typeClient);
        platformConfig = cfg;

        SAFE_ZONE_TOP = Gdx.graphics.getSafeInsetTop();
        SAFE_ZONE_BOTTOM = Gdx.graphics.getSafeInsetBottom();

        if (cfg.platform == PlatformConfig.Platform.DESKTOP) {
            if (typeClient == 2) {
                Gdx.graphics.setWindowedMode(700, 900);
            } else if (typeClient == 1) {
                Gdx.graphics.setWindowedMode(960, 540);
            }
        }

        int baseW = Gdx.graphics.getWidth();
        int baseH = Gdx.graphics.getHeight() - SAFE_ZONE_TOP - SAFE_ZONE_BOTTOM;

        if (cfg.rotateForPortrait) {
            int tmp = baseW; baseW = baseH; baseH = tmp;
        }

        double divisor;
        if (cfg.targetShortEdge > 0) {
            int shorter = Math.min(baseW, baseH);
            divisor = shorter / (double) cfg.targetShortEdge;
            if (divisor < 1.0) divisor = 1.0;
        } else {
            divisor = cfg.divisor;
        }

        WIDTH = (int)(baseW / divisor);
        HEIGHT = (int)(baseH / divisor);
        zoomLevel = cfg.zoomLevel;
        this.zoomLevel = cfg.zoomLevel;
        this.isZoom = (divisor > 1.0);
        Image.zoomLevel = mGraphics.zoomLevel = MotherCanvas.gI().zoomLevel = cfg.zoomLevel;

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(true);
        if (cfg.rotateForPortrait) {
            this.camera.rotate(90.0F);
            this.viewport = new ExtendViewport((float) HEIGHT, (float) WIDTH, this.camera);
        } else {
            this.viewport = new ExtendViewport((float) WIDTH, (float) HEIGHT, this.camera);
        }

        // this.viewport = new ExtendViewport(WIDTH, HEIGHT, camera);
        this.viewport.apply();
        camera.update();
        SpriteBatch batch = new SpriteBatch();
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        graphics = new Graphics(batch);
        initaliseInputProcessors();
        MyInputProcessor inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
        MapKey.load();
        instance = this;
        KeyBoard.imgBoard = new TextureBoard(TextureService.instance.loadTexture("keyboard.jpg"), 4, 6);
        LicenseVerifier.loadFromConfig();
        new base.game1.GameMidlet(0);
        showKeyBoard = typeClient == 2;
        /*
         * dh0.a().a(an0.a());
         * gameCanvas = new a0();
         * gameCanvas.c();
         * gameCanvas.sizeChange();
         * f = "0";
         * e = 0;
         * f = this.readStr("agent.txt");
         * e = Byte.parseByte(this.readStr("provider.txt"));
         * // f = this.b("agent.txt");
         * // e = Byte.parseByte(this.b("provider.txt"));
         * System.out.println("AGENT: " + f + ", PROVIDER: " + e);
         * cj0.a = 0;
         * a0.E = new cj0();
         */
    }

    public void initaliseInputProcessors() {
        this.inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(this.inputMultiplexer);
        this.inputProcessor = new MyInputProcessor();
        this.gestureHandler = new MyGestureHandler();
        this.inputMultiplexer.addProcessor(new GestureDetector(this.gestureHandler));
        this.inputMultiplexer.addProcessor(this.inputProcessor);
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public boolean paint = false;

    public float e(float f, float f2) {
        BigDecimal roundedValue = new BigDecimal(f + f2).setScale(2, RoundingMode.HALF_UP);
        return roundedValue.floatValue();

    }

    public static Color[] getColorRange(Color minColor, Color maxColor, int steps) {
        Color[] colors = new Color[steps];
        for (int i = 0; i < steps; i++) {
            float t = i / (float) (steps - 1);
            colors[i] = interpolate(minColor, maxColor, t);
        }
        return colors;
    }

    private static Color interpolate(Color start, Color end, float t) {
        float r = start.r + t * (end.r - start.r);
        float g = start.g + t * (end.g - start.g);
        float b = start.b + t * (end.b - start.b);
        float a = start.a + t * (end.a - start.a);
        return new Color(r, g, b, a);
    }

    public void paint() {
        if (paint) {
            return;
        }
        paint = true;
        Vector v = new Vector();

        /*
         * for (float i = 0; i <= 255; i = e(i, 0.001f)) {
         * 
         * for (float i1 = 0; i1 <= 1f; i1 = e(i1, 0.001f)) {
         * 
         * for (float i2 = 0; i2 <= 1f; i2 = e(i2, 0.001f)) {
         * int colorz = Color.rgb888(i, i1, 12);
         * if (!v.contains(colorz)) {
         * v.add(colorz);
         * Pixmap pixmap = new Pixmap(32, 32, Pixmap.Format.RGBA8888);
         * pixmap.setColor(new Color(colorz));
         * pixmap.fill();
         * System.out.println(color++ + ": " + i + "-" + i1 + "-" + i2);
         * PixmapIO.writePNG(Gdx.files.local("Nso/"+"color\\" + colorz + ".png"),
         * pixmap);
         * }
         * }
         * }
         * }
         */
        // Define the number of steps for each channel
        int numSteps = 5;

        // Iterate through all combinations of R, G, B, A values
        for (int r = 0; r < numSteps; r++) {
            for (int g = 0; g < numSteps; g++) {
                for (int b = 0; b < numSteps; b++) {
                    for (int a = 0; a < numSteps; a++) {
                        // Convert steps to float values between 0.0f and 1.0f
                        float red = r / (float) (numSteps - 1);
                        float green = g / (float) (numSteps - 1);
                        float blue = b / (float) (numSteps - 1);
                        float alpha = a / (float) (numSteps - 1);

                        // Create the color
                        Color color = new Color(red, green, blue, alpha);
                        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
                        pixmap.setColor(new Color(color));
                        pixmap.fill();
                        PixmapIO.writePNG(Gdx.files.local("Nso/" + "color\\" + color.toString() + ".png"), pixmap);
                        System.out
                                .println(String.format("R: %.2f, G: %.2f, B: %.2f, A: %.2f", red, green, blue, alpha));
                    }
                }
            }
        }

    }

    public int floatToColorInt(float value) {
        // Clamp the value to ensure it's within the range [0, 1]
        value = Math.min(1.0f, Math.max(0.0f, value));

        // Convert the float value to an integer in the range [0, 255]
        return Math.round(value * 255);
    }

    public int rgbaToInt(float red, float green, float blue, float alpha) {

        // Ensure each color component is within the valid range of 0-255
        red = floatToColorInt(red);
        green = floatToColorInt(green);
        blue = floatToColorInt(blue);
        alpha = floatToColorInt(alpha);

        // Combine the components into a single integer
        return ((int) alpha << 24) | ((int) red << 16) | ((int) green << 8) | (int) blue;
    }

    public Color rgba8888ToColor(int rgba8888) {
        Color color = new Color();
        color.r = (float) ((rgba8888 & -16777216) >>> 24) / 255.0F;
        color.g = (float) ((rgba8888 & 16711680) >>> 16) / 255.0F;
        color.b = (float) ((rgba8888 & '\uff00') >>> 8) / 255.0F;
        color.a = (float) (rgba8888 & 255) / 255.0F;
        return color;
    }

    public static int colorToRgb(Color color) {
        int r = Math.round(color.r * 255.0f);
        int g = Math.round(color.g * 255.0f);
        int b = Math.round(color.b * 255.0f);
        return (r << 16) | (g << 8) | b;
    }

    public static Color setColor(int rgb) {
        float R = (float) (rgb >> 16 & 255);
        float G = (float) (rgb >> 8 & 255);
        float B = (float) (rgb & 255);
        float b = B / 256.0F;
        float g = G / 256.0F;
        float r = R / 256.0F;
        return new Color(r, g, b, 1.0F);
    }

    public void render() {
        long var1 = System.currentTimeMillis();
        try {
            for (int i = 0; i < vecCleanIm.size(); i++) {
                Image image = vecCleanIm.get(i);
                if (System.currentTimeMillis() - image.lastTimeGet > 120_000) {
                    image.clean();
                    vecCleanIm.remove(i);
                    i--;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            for (int i = 0; i < vImageNeedCreate.size(); i++) {
                Image image = vImageNeedCreate.remove(i);
                if (image.texture == null) {
                    image.getTexture();
                }
                i--;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // paint();
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glClear(16384);
        this.graphics.graphics.setProjectionMatrix(this.camera.combined);
        camera.position.set(WIDTH / 2f, (HEIGHT - SAFE_ZONE_TOP) / 2f, 0);
        camera.update();
        if (menuCustom != null && menuCustom.isVisible) {
            menuCustom.render();
        } else {
            this.graphics.begin();
            if (gameCanvas != null) {
                try {
                    try {
                        if (base.game1.GameCanvas.bRun) {
                            base.game1.MotherCanvas.gI().update();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        if (base.game2.GameCanvas.bRun) {
                            base.game2.MotherCanvas.gI().update();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gameCanvas.paint(this.graphics);
                if (showKeyBoard) {
                    if (keyBoard != null) {
                        keyBoard.paint(new mGraphics(this.graphics));
                    }
                }
            } else {
                graphics.setColor(Color.valueOf("ffbf00bf"));
                graphics.fillRect(0, 0, WIDTH, HEIGHT);
                graphics.endShader();
            }

            this.graphics.end();
        }
        long var3 = System.currentTimeMillis() - var1;
        try {
            Thread.sleep(var3 < (long) Code.speedGame ? (long) Code.speedGame - var3 : 1L);
        } catch (InterruptedException var6) {
        }
    }

    public void dispose() {
        System.gc();
        instance.graphics.graphics.dispose();
        if (menuCustom != null) {
            menuCustom.dispose();
        }
        System.exit(0);
    }

    public void resize(int width, int height) {
        viewport.update(width, height);

        if (menuCustom != null) {
            if (menuCustom.isVisible) {
                menuCustom.resize(width, height);
            }
        }
    }

    public void pause() {
    }

    public void resume() {
    }

    public void exitApp() {
        Gdx.app.exit();
    }

    private Color rgba(float i, float i0, float i1, float d) {
        return new com.badlogic.gdx.graphics.Color(i / 255f, i0 / 255f, i1 / 255f, 1);
    }

    private Color rgba2(float i, float i0, float i1, float d) {
        return new com.badlogic.gdx.graphics.Color(i, i0, i1, 1);
    }

    public class MyInputProcessor implements InputProcessor {

        MyInputProcessor() {
        }

        public boolean keyDown(int keycode) {
            int k = MapKey.map(keycode);
            if ((Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) && keycode == 9) {
                k = 64;
            }
            if (gameCanvas != null) {
                gameCanvas.keyPressed(k);
                return false;
            }
            return false;
        }

        public boolean keyUp(int keycode) {
            int k = MapKey.map(keycode);

            if (gameCanvas != null) {
                gameCanvas.keyReleased(k);
            }
            return false;
        }

        public boolean keyTyped(char character) {

            return false;
        }

        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            int rotation = Gdx.input.getRotation();
            rotation = 0;
            if (rotation == 90) {
                screenX = screenY;
                screenY = Gdx.graphics.getHeight() - screenX;
            } else if (rotation == 270) {
                screenY = screenX;
                screenX = Gdx.graphics.getWidth() - screenY;
            }
            Vector3 touch = new Vector3(screenX, screenY, 0.0f);
            NSO.this.camera.unproject(touch);
            int delX = ((int) touch.x) - screenX;
            int delY = ((int) touch.y) - screenY;
            if (pointer < 2 && gameCanvas != null) {
                if (isZoom) {
                    int x = screenX + delX;
                    int y = screenY + delY;
                    gameCanvas.pointerPressed(x, y);
                } else {
                    int x = screenX + delX / zoomLevel;
                    int y = screenY + delY / zoomLevel;
                    gameCanvas.pointerPressed(x, y);
                }
                return false;
            }
            return false;
        }

        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            int rotation = Gdx.input.getRotation();
            rotation = 0;
            if (rotation == 90) {
                screenX = screenY;
                screenY = Gdx.graphics.getHeight() - screenX;
            } else if (rotation == 270) {
                screenY = screenX;
                screenX = Gdx.graphics.getWidth() - screenY;
            }
            Vector3 touch = new Vector3(screenX, screenY, 0.0f);
            NSO.this.camera.unproject(touch);
            int delX = ((int) touch.x) - screenX;
            int delY = ((int) touch.y) - screenY;
            if (pointer < 2 && gameCanvas != null) {
                if (isZoom) {

                    int x = screenX + delX;
                    int y = screenY + delY;
                    gameCanvas.pointerReleased(x, y);
                } else {
                    int x = screenX + delX / zoomLevel;
                    int y = screenY + delY / zoomLevel;
                    gameCanvas.pointerReleased(x, y);
                }
                return false;
            }
            return false;
        }

        public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        public boolean touchDragged(int screenX, int screenY, int pointer) {
            int rotation = Gdx.input.getRotation();
            rotation = 0;
            if (rotation == 90) {
                screenX = screenY;
                screenY = Gdx.graphics.getHeight() - screenX;
            } else if (rotation == 270) {
                screenY = screenX;
                screenX = Gdx.graphics.getWidth() - screenY;
            }
            Vector3 touch = new Vector3(screenX, screenY, 0.0f);
            NSO.this.camera.unproject(touch);
            int delX = ((int) touch.x) - screenX;
            int delY = ((int) touch.y) - screenY;
            if (pointer < 2 && gameCanvas != null) {
                if (isZoom) {

                    int x = screenX + delX;
                    int y = screenY + delY;
                    gameCanvas.pointerDragged(x, y);
                } else {
                    int x = screenX + delX / zoomLevel;
                    int y = screenY + delY / zoomLevel;
                    gameCanvas.pointerDragged(x, y);
                }
                return false;
            }
            return false;
        }

        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        public boolean scrolled(float amountX, float amountY) {
            return false;
        }

        public boolean scrolled(int i) {
            return false;
        }
    }

    public class MyGestureHandler implements GestureDetector.GestureListener {

        public float initialScale = 1.0f;

        MyGestureHandler() {
        }

        public boolean touchDown(float x, float y, int pointer, int button) {
            return false;
        }

        public boolean zoom(float initialDistance, float distance) {
            float f = initialDistance / distance;
            return true;
        }

        public void pinchStop() {
        }

        public boolean tap(float x, float y, int count, int button) {
            return false;
        }

        public boolean longPress(float x, float y) {
            return false;
        }

        public boolean fling(float velocityX, float velocityY, int button) {
            return false;
        }

        public boolean pan(float x, float y, float deltaX, float deltaY) {
            return false;
        }

        public boolean panStop(float x, float y, int pointer, int button) {
            return false;
        }

        public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
            return false;
        }
    }

    private String b(String var1) {
        InputStream var5 = this.getClass().getResourceAsStream(var1);

        String var3;
        try {
            byte[] var4 = new byte[var5.available()];
            var5.read(var4);
            var3 = new String(var4, "UTF-8");
        } catch (Exception var2) {
            var3 = "";
        }

        return var3;
    }

    private String readStr(String filenam) {
        FileHandle fileHandle = Gdx.files.internal("Nso/" + filenam);

        // ??c n?i dung c?a file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileHandle.read()))) {

            String line = reader.readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int e() {
        byte var0 = 0;
        if (i) {
            var0 = 1;
        }

        for (int var1 = 0; var1 <= p.length - 1; ++var1) {
            if (p[var1] == var0) {
                return var1;
            }
        }

        return 0;
    }

    public static int f() {
        for (int var0 = 0; var0 <= p.length - 1; ++var0) {
            if (p[var0] == 1) {
                return var0 - 1;
            }
        }

        return 0;
    }

    private static String c(String var0) {
        if (!ww.isEmpty()) {
            return ww;
        }

        final CountDownLatch latch = new CountDownLatch(1);

        Net.HttpRequest httpGet = new Net.HttpRequest(Net.HttpMethods.GET);
        httpGet.setUrl(var0);

        Gdx.net.sendHttpRequest(httpGet, new Net.HttpResponseListener() {

            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                ww = httpResponse.getResultAsString();
                latch.countDown();
            }

            public void failed(Throwable t) {
                latch.countDown();
            }

            public void cancelled() {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ww;
    }
}
