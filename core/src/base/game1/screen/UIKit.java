package base.game1.screen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.monkey.nso.NSO;

import base.game1.DebugLog;

public final class UIKit {

    public static final float BASE_W = 800f;
    public static final float BASE_H = 480f;

    // Text colors
    private static final Color COLOR_GOLD       = new Color(1f,    0.85f, 0.40f, 1f);
    private static final Color COLOR_WHITE       = new Color(0.95f, 0.90f, 0.80f, 1f);  // warm white
    private static final Color COLOR_DARK_BROWN  = new Color(0.12f, 0.06f, 0.01f, 1f);
    private static final Color COLOR_CURSOR      = new Color(1f,    0.85f, 0.40f, 0.95f);
    private static final Color COLOR_SELECTION   = new Color(1f,    0.85f, 0.40f, 0.40f);

    private static final String FONT_TTF = "Nso/FontSys/x2/Nokia Standard_.ttf";

    private static final String VN_EXTRA_CHARS =
            "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúý"
          + "ĂăĐđĨĩŨũƠơƯư"
          + "ẠạẢảẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặ"
          + "ẸẹẺẻẼẽẾếỀềỂểỄễỆệ"
          + "ỈỉỊị"
          + "ỌọỎỏỐốỒồỔổỖỗỘộỚớỜờỞởỠỡỢợ"
          + "ỤụỦủỨứỪừỬửỮữỰự"
          + "ỲỳỴỵỶỷỸỹ";

    private static Skin       skin;
    private static BitmapFont fontTitle, fontBody, fontChat;

    // File-loaded Unity assets (TextField + Checkbox only)
    private static Texture tField;        // tf.png   — textfield sprite sheet
    private static Texture tCheckSheet;   // check.png — checkbox sprite sheet

    // Programmatic Pixmap textures
    private static Texture tPanel;        // dark panel with gold frame — generated
    private static Texture tBtnWood, tBtnWoodDn;
    private static Texture tBtnGold, tBtnGoldDn;
    private static Texture tBtnDark;
    private static Texture tCbOff, tCbOn;
    private static Texture tPixel;

    private UIKit() {}

    // ---- Viewport / stage ----

    public static Stage newStage() {
        return new Stage(new ExtendViewport(BASE_W, BASE_H));
    }

    public static boolean isPortrait() {
        return Gdx.graphics.getHeight() > Gdx.graphics.getWidth();
    }

    public static boolean isDesktop() {
        return Gdx.app.getType() == Application.ApplicationType.Desktop;
    }

    // ---- Skin singleton ----

    public static Skin skin() {
        if (skin != null) return skin;
        long t0 = System.currentTimeMillis();
        skin = new Skin();
        loadFonts();
        loadDrawables();
        buildStyles();
        if (DebugLog.DEBUG) DebugLog.log("UI", "skin-v8 loaded in " + (System.currentTimeMillis() - t0) + "ms");
        return skin;
    }

    // ---- Fonts — flat sans-serif, no outline ----

    private static void loadFonts() {
        FreeTypeFontGenerator gen = null;
        try {
            gen = new FreeTypeFontGenerator(Gdx.files.internal(FONT_TTF));
            String chars = FreeTypeFontGenerator.DEFAULT_CHARS + VN_EXTRA_CHARS;

            FreeTypeFontParameter p = new FreeTypeFontParameter();
            p.characters    = chars;
            p.magFilter     = TextureFilter.Linear;
            p.minFilter     = TextureFilter.Linear;
            p.borderWidth   = 0f;

            // Body
            p.size        = 20;
            fontBody = gen.generateFont(p);
            skin.add("body", fontBody);

            // Title
            p.size        = 24;
            fontTitle = gen.generateFont(p);
            skin.add("title", fontTitle);

            // Chat
            p.size        = 18;
            fontChat = gen.generateFont(p);
            skin.add("chat", fontChat);

            if (DebugLog.DEBUG) DebugLog.log("UI", "fonts OK body=20 title=24 chat=18 (flat, no outline)");
        } catch (Throwable t) {
            if (DebugLog.DEBUG) DebugLog.error("UI loadFonts failed: " + t.getMessage(), t);
            throw new RuntimeException("UIKit.loadFonts failed", t);
        } finally {
            if (gen != null) gen.dispose();
        }
    }

    // ---- Drawables ----

    private static void loadDrawables() {
        // === Panel: 3-layer dark frame — Pixmap 15x15 ===
        // Layer 0 (outer 2px): amber border
        // Layer 1 (next 2px): bright gold ring — điểm nhấn "game frame"
        // Layer 2 (center):   very dark interior
        // NinePatch[4,4,4,4] → stretch only the dark center
        tPanel = mkPanelTex();
        skin.add("panel", new NinePatch(new TextureRegion(tPanel), 4, 4, 4, 4));

        // === TextField: tf.png slice — lấy state đầu tiên (y=0..53, 58x54) ===
        // tf.png là sprite sheet 58x324 với 6 states mỗi 54px
        // State 0 (normal): border mờ dần ~3-4px, interior near-black (48,26,15)
        tField = linTex("Nso/skin/v8/tf.png");
        TextureRegion tfRegion = new TextureRegion(tField, 0, 0, 58, 54);
        skin.add("field-bg",       new NinePatch(tfRegion, 4, 4, 4, 4));
        // State 1 (focused): dùng slice thứ 2 (y=55..108)
        TextureRegion tfFocused = new TextureRegion(tField, 0, 55, 58, 54);
        skin.add("field-focused",  new NinePatch(tfFocused, 4, 4, 4, 4));

        // === Checkbox: check.png — 28x56 sprite sheet (off: y=0..27, on: y=28..55) ===
        tCheckSheet = nearTex("Nso/skin/v8/check.png");
        skin.add("cb-off", new TextureRegion(tCheckSheet, 0,  0, 28, 28));
        skin.add("cb-on",  new TextureRegion(tCheckSheet, 0, 28, 28, 28));

        // === Buttons: Pixmap 3D (bevel highlight/mid/shadow) ===
        // Wood button (secondary)
        tBtnWood   = btn3d(0.30f,0.17f,0.03f,  0.72f,0.44f,0.12f,  0.58f,0.34f,0.08f,  0.35f,0.20f,0.04f);
        tBtnWoodDn = btn3d(0.22f,0.12f,0.02f,  0.52f,0.32f,0.08f,  0.44f,0.26f,0.06f,  0.28f,0.16f,0.03f);
        skin.add("btn-wood",    np12(tBtnWood));
        skin.add("btn-wood-dn", np12(tBtnWoodDn));

        // Gold button (primary action)
        tBtnGold   = btn3d(0.45f,0.28f,0.02f,  0.98f,0.80f,0.25f,  0.88f,0.64f,0.10f,  0.58f,0.40f,0.05f);
        tBtnGoldDn = btn3d(0.32f,0.20f,0.02f,  0.75f,0.58f,0.16f,  0.68f,0.48f,0.08f,  0.42f,0.28f,0.03f);
        skin.add("btn-gold",    np12(tBtnGold));
        skin.add("btn-gold-dn", np12(tBtnGoldDn));

        // Dark button (subtle)
        tBtnDark = btn3d(0.15f,0.09f,0.02f,  0.30f,0.18f,0.04f,  0.22f,0.13f,0.03f,  0.12f,0.07f,0.01f);
        skin.add("btn-dark", np12(tBtnDark));

        // 1x1 white pixel for cursor/selection
        tPixel = mkPixel();
        skin.add("pixel", new TextureRegion(tPixel));

        if (DebugLog.DEBUG) DebugLog.log("UI",
                "drawables: panel=chat.png[19] tf.png[4] check.png[split] + 3 btn pixmap");
    }

    /** Panel texture 15×15: outer amber 2px → gold ring 2px → dark interior. */
    private static Texture mkPanelTex() {
        Pixmap pm = new Pixmap(15, 15, Pixmap.Format.RGBA8888);
        pm.setColor(0.58f, 0.36f, 0.07f, 1f); pm.fill();                    // outer amber border
        pm.setColor(0.92f, 0.68f, 0.18f, 1f); pm.fillRectangle(2, 2, 11, 11); // bright gold ring
        pm.setColor(0.07f, 0.04f, 0.01f, 1f); pm.fillRectangle(4, 4, 7,  7);  // dark interior
        Texture t = new Texture(pm);
        t.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        pm.dispose();
        return t;
    }

    /**
     * Tạo button texture 12x12 với 3-zone bevel:
     * border(2px) | highlight(2px) | mid(4px — stretches) | shadow(2px) | border(2px)
     * params: border_rgb, highlight_rgb, mid_rgb, shadow_rgb
     */
    private static Texture btn3d(float br, float bg, float bb,
                                  float hr, float hg, float hb,
                                  float mr, float mg, float mb,
                                  float sr, float sg, float sb) {
        Pixmap pm = new Pixmap(12, 12, Pixmap.Format.RGBA8888);
        // Border (outer 2px all sides)
        pm.setColor(br, bg, bb, 1f); pm.fill();
        // Highlight top band (y=2..3, inside border)
        pm.setColor(hr, hg, hb, 1f); pm.fillRectangle(2, 2, 8, 2);
        // Mid center (y=4..7 — este zone stretches vertically)
        pm.setColor(mr, mg, mb, 1f); pm.fillRectangle(2, 4, 8, 4);
        // Shadow bottom band (y=8..9, inside border)
        pm.setColor(sr, sg, sb, 1f); pm.fillRectangle(2, 8, 8, 2);
        Texture t = new Texture(pm);
        t.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        pm.dispose();
        return t;
    }

    /** NinePatch cho btn3d: border[2,2], top=4(border+hl), bottom=4(shadow+border). */
    private static NinePatch np12(Texture t) {
        return new NinePatch(new TextureRegion(t), 2, 2, 4, 4);
    }

    private static Texture linTex(String path) {
        Texture t = new Texture(Gdx.files.internal(path));
        t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        return t;
    }

    private static Texture nearTex(String path) {
        Texture t = new Texture(Gdx.files.internal(path));
        t.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        return t;
    }

    private static Texture mkPixel() {
        Pixmap pm = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pm.setColor(Color.WHITE); pm.fill();
        Texture t = new Texture(pm);
        pm.dispose();
        return t;
    }

    // ---- Styles ----

    private static void buildStyles() {
        // Labels
        skin.add("default", new Label.LabelStyle(fontBody,  COLOR_WHITE));
        skin.add("title",   new Label.LabelStyle(fontTitle, COLOR_GOLD));
        skin.add("gold",    new Label.LabelStyle(fontBody,  COLOR_GOLD));
        skin.add("chat",    new Label.LabelStyle(fontChat,  COLOR_WHITE));

        // Window
        Window.WindowStyle winStyle = new Window.WindowStyle();
        winStyle.background     = skin.getDrawable("panel");
        winStyle.titleFont      = fontTitle;
        winStyle.titleFontColor = COLOR_GOLD;
        skin.add("default", winStyle);

        // Button wood (secondary / Thoát)
        TextButton.TextButtonStyle btnWood = new TextButton.TextButtonStyle();
        btnWood.up        = skin.getDrawable("btn-wood");
        btnWood.down      = skin.getDrawable("btn-wood-dn");
        btnWood.over      = skin.getDrawable("btn-wood");
        btnWood.font      = fontBody;
        btnWood.fontColor = COLOR_WHITE;
        skin.add("default", btnWood);
        skin.add("wood",    btnWood);

        // Button dark
        TextButton.TextButtonStyle btnDark = new TextButton.TextButtonStyle();
        btnDark.up        = skin.getDrawable("btn-dark");
        btnDark.down      = skin.getDrawable("btn-dark");
        btnDark.over      = skin.getDrawable("btn-dark");
        btnDark.font      = fontBody;
        btnDark.fontColor = COLOR_GOLD;
        skin.add("dark", btnDark);

        // Button gold (primary / Lưu)
        TextButton.TextButtonStyle btnGold = new TextButton.TextButtonStyle();
        btnGold.up        = skin.getDrawable("btn-gold");
        btnGold.down      = skin.getDrawable("btn-gold-dn");
        btnGold.over      = skin.getDrawable("btn-gold");
        btnGold.font      = fontBody;
        btnGold.fontColor = COLOR_DARK_BROWN;
        skin.add("gold", btnGold);

        // TextField: bình thường + focused khác màu viền
        TextField.TextFieldStyle tfStyle = new TextField.TextFieldStyle();
        tfStyle.font              = fontBody;
        tfStyle.fontColor         = COLOR_WHITE;
        tfStyle.background        = skin.getDrawable("field-bg");
        tfStyle.focusedBackground = skin.getDrawable("field-focused");
        tfStyle.cursor            = skin.newDrawable("pixel", COLOR_CURSOR);
        tfStyle.selection         = skin.newDrawable("pixel", COLOR_SELECTION);
        tfStyle.messageFont       = fontBody;
        tfStyle.messageFontColor  = new Color(0.6f, 0.55f, 0.45f, 0.8f);
        skin.add("default", tfStyle);

        // CheckBox: dùng check.png unity trực tiếp
        CheckBox.CheckBoxStyle cbStyle = new CheckBox.CheckBoxStyle();
        cbStyle.checkboxOff = skin.getDrawable("cb-off");
        cbStyle.checkboxOn  = skin.getDrawable("cb-on");
        cbStyle.font        = fontBody;
        cbStyle.fontColor   = COLOR_WHITE;
        skin.add("default", cbStyle);

        // List (dropdown items) — nền tối, selection gold
        List.ListStyle listStyle = new List.ListStyle();
        listStyle.font              = fontBody;
        listStyle.fontColorSelected = COLOR_DARK_BROWN;
        listStyle.fontColorUnselected = COLOR_WHITE;
        listStyle.selection         = skin.newDrawable("pixel", COLOR_GOLD);
        listStyle.background        = skin.getDrawable("field-bg");
        skin.add("default", listStyle);

        // ScrollPane — fade scrollbar tối
        ScrollPane.ScrollPaneStyle spStyle = new ScrollPane.ScrollPaneStyle();
        spStyle.vScroll        = skin.newDrawable("pixel", new Color(0f, 0f, 0f, 0.25f));
        spStyle.vScrollKnob    = skin.newDrawable("pixel", COLOR_GOLD);
        spStyle.hScroll        = skin.newDrawable("pixel", new Color(0f, 0f, 0f, 0.25f));
        spStyle.hScrollKnob    = skin.newDrawable("pixel", COLOR_GOLD);
        skin.add("default", spStyle);

        // SelectBox — dùng btn-wood cho nút mở, field-bg cho list nền
        SelectBox.SelectBoxStyle sbStyle = new SelectBox.SelectBoxStyle();
        sbStyle.font                 = fontBody;
        sbStyle.fontColor            = COLOR_WHITE;
        sbStyle.background           = skin.getDrawable("btn-wood");
        sbStyle.backgroundOpen       = skin.getDrawable("btn-wood-dn");
        sbStyle.backgroundOver       = skin.getDrawable("btn-wood");
        sbStyle.scrollStyle          = spStyle;
        sbStyle.listStyle            = listStyle;
        skin.add("default", sbStyle);

        if (DebugLog.DEBUG) DebugLog.log("UI", "styles built OK");
    }

    // ---- Factory widgets ----

    public static Label label(String text) {
        return new Label(text == null ? "" : text, skin());
    }

    public static Label title(String text) {
        return new Label(text == null ? "" : text, skin(), "title");
    }

    public static TextButton btnWood(String text) { return new TextButton(text == null ? "" : text, skin(), "wood"); }
    public static TextButton btnDark(String text) { return new TextButton(text == null ? "" : text, skin(), "dark"); }
    public static TextButton btnGold(String text) { return new TextButton(text == null ? "" : text, skin(), "gold"); }

    public static TextField tfText(String value) {
        return new TextField(value == null ? "" : value, skin());
    }

    public static TextField tfDigits(String value) {
        TextField tf = tfText(value);
        tf.setTextFieldFilter((field, c) -> Character.isDigit(c) || c == '-');
        return tf;
    }

    public static CheckBox cb(String text, boolean checked) {
        CheckBox c = new CheckBox(text == null ? "" : text, skin());
        c.setChecked(checked);
        // check.png là 28x28 per state — ở ExtendViewport 800x480 dùng 30x30 world units
        c.getImageCell().size(30f, 30f).padRight(10f);
        return c;
    }

    public static SelectBox<String> selectBox(String[] items, int selectedIndex) {
        SelectBox<String> sb = new SelectBox<String>(skin());
        if (items != null) {
            Array<String> arr = new Array<String>(items);
            sb.setItems(arr);
        }
        if (selectedIndex >= 0 && items != null && selectedIndex < items.length) {
            sb.setSelectedIndex(selectedIndex);
        }
        return sb;
    }

    /** Wrap nội dung `content` vào ScrollPane chỉ cho phép cuộn dọc, không fade scrollbar. */
    public static ScrollPane wrapScroll(Table content) {
        ScrollPane sp = new ScrollPane(content, skin());
        sp.setFadeScrollBars(false);
        sp.setScrollingDisabled(true, false);
        sp.setForceScroll(false, false);
        return sp;
    }

    // ---- Layout constants (1 chỗ chỉnh ăn toàn bộ screens) ----

    public static final float FIELD_H       = 36f;   // TextField + SelectBox default height
    public static final float BTN_H         = 46f;   // Button height
    public static final float BTN_MIN_W     = 120f;  // Button min width
    public static final float LABEL_MIN_W   = 210f;  // Label column min width (đủ cho "Map tập trung (nhóm)", "Bao nhiêu % thì pk"...)
    public static final float FIELD_MIN_W   = 140f;  // Field column min width
    public static final float ROW_PAD       = 6f;    // Row padding
    public static final float PANEL_MAX_W   = 780f;  // Panel absolute max width
    public static final float PANEL_MAX_W_FRAC = 0.94f; // Panel max = stageW * this
    public static final float PANEL_MAX_H_FRAC = 0.96f; // Panel max = stageH * this

    // List panel dimensions (ListPK/ListKO/ListBlock/ListGroup/ScreenQLTK)
    // Panel list cần rộng hơn form đơn để nhập nick + hiển thị list thoải mái,
    // và ScrollPane cell phải có prefHeight (không chỉ maxHeight) vì list có thể empty
    // khi pack → nếu không set prefHeight sẽ thành 0 → list mới add không render.
    public static final float LIST_MIN_W    = 520f;  // panel tối thiểu ~ form AutoOnOff
    public static final float LIST_PREF_H   = 260f;  // scroll prefHeight: luôn reserve chỗ dù empty
    public static final float LIST_MIN_H    = 120f;  // scroll minHeight tuyệt đối

    /**
     * Thêm 1 row label + field vào table: label right-align minWidth 160, field expandX fillX minWidth 140.
     * Tự co giãn theo width panel, label dài không bị cắt, field stretch lấp chỗ còn lại.
     */
    public static Cell<?> addRow(Table t, String labelText, Actor field) {
        t.add(label(labelText)).right().padRight(10f).minWidth(LABEL_MIN_W);
        Cell<?> c = t.add(field).left().expandX().fillX().minWidth(FIELD_MIN_W).height(FIELD_H);
        t.row();
        return c;
    }

    /** Thêm 1 row chỉ có 1 actor, full-width 2 columns. */
    public static Cell<?> addFullRow(Table t, Actor actor) {
        Cell<?> c = t.add(actor).colspan(2).left().expandX().fillX();
        t.row();
        return c;
    }

    /**
     * Row hiển thị 1 mục trong list: nick label + nút Xóa.
     * onDelete.run() được gọi khi user tap Xóa (screen tự chịu trách nhiệm xóa + refresh).
     */
    public static void addListRow(Table list, String text, final Runnable onDelete) {
        Table row = new Table();
        row.left();
        row.add(label(text)).left().expandX().fillX().pad(4f).padLeft(8f);
        TextButton btnDel = btnWood("Xóa");
        btnDel.addListener(new com.badlogic.gdx.scenes.scene2d.utils.ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                if (onDelete != null) onDelete.run();
            }
        });
        row.add(btnDel).minWidth(90f).height(36f).padRight(6f);
        list.add(row).expandX().fillX().padBottom(4f).row();
    }

    /**
     * Căn panel responsive:
     * - pack() để đo content thực
     * - min(preferred, stageW * 0.94, 780) — không vượt màn, không quá rộng vô dụng
     * - center trên stage
     */
    public static void layoutPanel(Stage stage, Window panel) {
        panel.pack();
        float maxW = Math.min(stage.getWidth()  * PANEL_MAX_W_FRAC, PANEL_MAX_W);
        float maxH = stage.getHeight() * PANEL_MAX_H_FRAC;
        float pw = Math.min(panel.getWidth(),  maxW);
        float ph = Math.min(panel.getHeight(), maxH);
        panel.setSize(pw, ph);
        panel.setPosition((stage.getWidth() - pw) / 2f, (stage.getHeight() - ph) / 2f);
    }

    public static Window panel(String titleText) {
        Window w = new Window(titleText == null ? "" : titleText, skin());
        w.padTop(40f);
        w.padLeft(16f).padRight(16f).padBottom(14f);
        w.setMovable(false);
        w.setKeepWithinStage(true);
        return w;
    }

    // ---- Input management ----

    public static void mountStage(Stage stage) {
        InputMultiplexer mux = new InputMultiplexer();
        mux.addProcessor(stage);
        if (NSO.instance != null && NSO.instance.inputMultiplexer != null) {
            mux.addProcessor(NSO.instance.inputMultiplexer);
        }
        Gdx.input.setInputProcessor(mux);
        if (DebugLog.DEBUG) DebugLog.log("UI", "mountStage: swap input → stage+NSO mux");
    }

    public static void restoreInput() {
        InputProcessor restore = null;
        if (NSO.instance != null && NSO.instance.inputMultiplexer != null) {
            restore = NSO.instance.inputMultiplexer;
        }
        Gdx.input.setInputProcessor(restore);
        if (DebugLog.DEBUG) DebugLog.log("UI", "restoreInput: → " + (restore == null ? "null" : "NSO mux"));
    }

    public static void logResize(String tag, Stage stage, int w, int h) {
        if (!DebugLog.DEBUG) return;
        DebugLog.log("UI", tag + ".resize screen=" + w + "x" + h
                + " world=" + stage.getViewport().getWorldWidth()
                + "x" + stage.getViewport().getWorldHeight()
                + " orientation=" + (isPortrait() ? "portrait" : "landscape"));
    }

    // ---- Cleanup ----

    public static void dispose() {
        if (skin != null) { skin.dispose(); skin = null; }
        Texture[] all = {tPanel, tField, tCheckSheet,
                         tBtnWood, tBtnWoodDn, tBtnGold, tBtnGoldDn, tBtnDark, tPixel};
        for (Texture t : all) { if (t != null) t.dispose(); }
        tPanel=tField=tCheckSheet=tBtnWood=tBtnWoodDn=tBtnGold=tBtnGoldDn=tBtnDark=tCbOff=tCbOn=tPixel=null;
        fontTitle = fontBody = fontChat = null;
        if (DebugLog.DEBUG) DebugLog.log("UI", "dispose: all released");
    }
}
