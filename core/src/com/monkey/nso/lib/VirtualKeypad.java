package com.monkey.nso.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;

import com.monkey.nso.NSO;

/**
 * Bàn phím ảo cho Java Dọc (typeClient=2): 4×4 keypad ở 1/3 chiều cao đáy màn.
 *
 * Layout:
 *   1   2   3   ↖↑↗
 *   4   5   6   ←F→
 *   7   8   9   ↙↓↘
 *   *   0   #
 *
 * Render trực tiếp lên screen pixel (không qua viewport game) để ổn định kích thước.
 * Touch sample được fire qua NSO trước khi truyền xuống gameCanvas.
 */
public class VirtualKeypad {
    public static boolean enabled = false;
    public static int heightPx = 0;       // chiều cao panel keypad (pixel screen)
    public static int topY = 0;           // y-top panel (pixel screen, từ trên xuống)

    private static final int COLS = 6;
    private static final int ROWS = 4;
    // Layout giống ảnh demo: 4 hàng × 6 cột.
    // Hàng 1, panel điều hướng: F1 ở cột 4, trống ở cột 5, F2 ở cột 6.
    private static final String[][] LABELS = {
        {"1","2","3","F1","",  "F2"},
        {"4","5","6","↖","↑", "↗"},
        {"7","8","9","←","OK","→"},
        {"*","0","#","↙","↓", "↘"}
    };
    // Keycode J2ME:
    //   0-9 → 48-57, * → 42, # → 35
    //   F1 (softLeft) → -6, F2 (softRight) → -7, OK (ENTER) → -5
    //   ↑↓←→ → -1, -2, -3, -4
    //   ↖↗↙↘ = số 1 3 7 9 → 49 51 55 57 (J2ME convention)
    //   ô trống: code = 0
    private static final int[][] CODES = {
        {49, 50, 51, -6,  0, -7},
        {52, 53, 54, 49, -1, 51},
        {55, 56, 57, -3, -5, -4},
        {42, 48, 35, 55, -2, 57}
    };

    private static SpriteBatch batch;
    private static ShapeRenderer shapes;
    private static BitmapFont font;
    private static Texture pixel;
    private static GlyphLayout layout;
    private static Matrix4 uiMatrix;
    private static int pressedR = -1, pressedC = -1;

    public static void init() {
        if (batch == null) {
            batch = new SpriteBatch();
            shapes = new ShapeRenderer();
            font = new BitmapFont();
            font.getData().setScale(2.0f);
            layout = new GlyphLayout();
            uiMatrix = new Matrix4();

            Pixmap pm = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            pm.setColor(1f, 1f, 1f, 1f);
            pm.fill();
            pixel = new Texture(pm);
            pm.dispose();
        }
    }

    /** Recompute panel height = 1/3 screen pixel height (gọi từ NSO.recomputeLayout). */
    public static void recompute() {
        int screenH = Gdx.graphics.getHeight();
        heightPx = screenH / 3;
        topY = screenH - heightPx;
    }

    public static void render() {
        if (!enabled || heightPx <= 0) return;
        init();
        int sw = Gdx.graphics.getWidth();
        int sh = Gdx.graphics.getHeight();
        Gdx.gl.glViewport(0, 0, sw, sh);
        uiMatrix.setToOrtho2D(0, 0, sw, sh);
        shapes.setProjectionMatrix(uiMatrix);
        batch.setProjectionMatrix(uiMatrix);
        int top = topY;
        int colW = sw / COLS;
        int rowH = heightPx / ROWS;

        // Background panel — bán trong suốt
        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(0.85f, 0.85f, 0.88f, 0.95f);
        shapes.rect(0, sh - top - heightPx, sw, heightPx); // y-up gdx
        shapes.end();

        // Highlight ô đang bấm
        if (pressedR >= 0) {
            shapes.begin(ShapeRenderer.ShapeType.Filled);
            shapes.setColor(0.6f, 0.7f, 0.9f, 1f);
            int yGdx = sh - top - (pressedR + 1) * rowH;
            shapes.rect(pressedC * colW + 4, yGdx + 4, colW - 8, rowH - 8);
            shapes.end();
        }

        // Đường viền ô
        shapes.begin(ShapeRenderer.ShapeType.Line);
        shapes.setColor(0.4f, 0.4f, 0.45f, 1f);
        for (int r = 0; r <= ROWS; r++) {
            float y = sh - top - r * rowH;
            shapes.line(0, y, sw, y);
        }
        for (int c = 0; c <= COLS; c++) {
            float x = c * colW;
            shapes.line(x, sh - top - heightPx, x, sh - top);
        }
        shapes.end();

        // Vẽ label text (chỉ chữ + số) bằng font; vẽ mũi tên bằng triangles
        batch.begin();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int x = c * colW;
                int yGdx = sh - top - (r + 1) * rowH;
                String label = LABELS[r][c];
                if (label.isEmpty()) continue;
                if (isArrow(label)) continue; // vẽ sau bằng shapes
                font.setColor(0.15f, 0.15f, 0.2f, 1f);
                layout.setText(font, label);
                float tx = x + (colW - layout.width) / 2f;
                float ty = yGdx + (rowH + layout.height) / 2f;
                font.draw(batch, label, tx, ty);
            }
        }
        batch.end();

        // Vẽ mũi tên bằng triangles (BitmapFont default không hỗ trợ unicode arrows)
        shapes.begin(ShapeRenderer.ShapeType.Filled);
        shapes.setColor(0.35f, 0.45f, 0.7f, 1f);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                String label = LABELS[r][c];
                if (!isArrow(label)) continue;
                int x = c * colW;
                int yGdx = sh - top - (r + 1) * rowH;
                drawArrow(label, x + colW / 2f, yGdx + rowH / 2f, Math.min(colW, rowH) * 0.35f);
            }
        }
        shapes.end();
    }

    private static boolean isArrow(String s) {
        if (s == null || s.isEmpty()) return false;
        char ch = s.charAt(0);
        return ch == '←' || ch == '→' || ch == '↑' || ch == '↓'
            || ch == '↖' || ch == '↗' || ch == '↙' || ch == '↘';
    }

    /** Vẽ mũi tên hướng xác định bằng 1 triangle (đầu) + 1 line (đuôi). */
    private static void drawArrow(String dir, float cx, float cy, float size) {
        // dx, dy: chiều mũi tên trong không gian Gdx (y-up). Trong screen y-down "↑" = đi lên màn = y-up trong Gdx
        float dx = 0, dy = 0;
        switch (dir.charAt(0)) {
            case '←': dx = -1; dy =  0; break;
            case '→': dx =  1; dy =  0; break;
            case '↑': dx =  0; dy =  1; break;
            case '↓': dx =  0; dy = -1; break;
            case '↖': dx = -1; dy =  1; break;
            case '↗': dx =  1; dy =  1; break;
            case '↙': dx = -1; dy = -1; break;
            case '↘': dx =  1; dy = -1; break;
            default: return;
        }
        // Normalize diagonal
        float len = (float) Math.sqrt(dx * dx + dy * dy);
        dx /= len; dy /= len;
        // Đuôi (tail) đến đầu (tip)
        float tailX = cx - dx * size, tailY = cy - dy * size;
        float tipX  = cx + dx * size, tipY  = cy + dy * size;
        float head = size * 0.55f;
        // Vector vuông góc cho 2 cánh đầu mũi tên
        float px = -dy * head * 0.7f, py = dx * head * 0.7f;
        float baseX = tipX - dx * head, baseY = tipY - dy * head;
        // Triangle đầu mũi tên
        shapes.triangle(tipX, tipY, baseX + px, baseY + py, baseX - px, baseY - py);
        // Đuôi: vẽ rectangle thin từ tail tới base
        float thick = head * 0.25f;
        // Cạnh dày dọc theo perp
        float qx = -dy * thick, qy = dx * thick;
        shapes.triangle(tailX + qx, tailY + qy, tailX - qx, tailY - qy, baseX + qx, baseY + qy);
        shapes.triangle(tailX - qx, tailY - qy, baseX - qx, baseY - qy, baseX + qx, baseY + qy);
    }

    /** Trả true nếu touch đã được xử lý bởi keypad (không cho game nhận). */
    public static boolean handleTouchDown(int screenX, int screenY) {
        if (!enabled || heightPx <= 0) return false;
        if (screenY < topY) return false;
        int sw = Gdx.graphics.getWidth();
        int colW = sw / COLS;
        int rowH = heightPx / ROWS;
        int c = screenX / colW;
        int r = (screenY - topY) / rowH;
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS) return false;
        int code = CODES[r][c];
        if (code == 0) return true; // ô trống: nuốt touch nhưng không fire keyPressed
        pressedR = r; pressedC = c;
        try {
            if (NSO.gameCanvas != null) NSO.gameCanvas.keyPressed(code);
        } catch (Throwable ignore) {}
        return true;
    }

    public static boolean handleTouchUp(int screenX, int screenY) {
        if (!enabled || pressedR < 0) return false;
        int code = CODES[pressedR][pressedC];
        pressedR = pressedC = -1;
        try {
            if (NSO.gameCanvas != null) NSO.gameCanvas.keyReleased(code);
        } catch (Throwable ignore) {}
        // Xét lại toạ độ — nếu cú nhấc tay rơi trong vùng keypad thì nuốt
        return screenY >= topY;
    }

    public static void dispose() {
        if (batch != null) { batch.dispose(); batch = null; }
        if (shapes != null) { shapes.dispose(); shapes = null; }
        if (font != null) { font.dispose(); font = null; }
        if (pixel != null) { pixel.dispose(); pixel = null; }
    }
}
