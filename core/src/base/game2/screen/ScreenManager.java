package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.monkey.nso.NSO;

public class ScreenManager {
    public static ScreenManager instance = new ScreenManager();
    public ScreenChild screenChild;

    public static menu_pkam menuPkam;
    public static Setting setting;
    public static KichYen kichYen;
    public static ListBlock listBlock;
    public static ListGroup listGroup;
    public static ListKO listKO;
    public static ListPK listPK;
    public static MenuHangDong menuHangDong;
    public static SetupVxmm setupVxmm;
    public static ScreenQLTK screenQLTK;
    public static ScreenCustomServer screenCustomServer;
    public static ScreenSettingSkill screenSettingSkill;
    public static ScreenAutoMuaItem screenAutoMuaItem;
    public static ScreenAutoNPC screenAutoNPC;
    public static ScreenAutoOnOff screenAutoOnOff;

    public static void show(ScreenChild screen) {
        if (instance.screenChild != null) {
            instance.screenChild.hide();
        }
        instance.screenChild = screen;
        screen.show();
    }

    public static void showOnGL(final Runnable createAndShow) {
        Gdx.app.postRunnable(createAndShow);
    }

    public static void hide() {
        if (instance.screenChild != null) {
            instance.screenChild.hide();
            instance.screenChild = null;
        }
        if (NSO.instance != null && NSO.instance.inputMultiplexer != null) {
            Gdx.input.setInputProcessor(NSO.instance.inputMultiplexer);
        }
    }

    public static void render() {
        if (instance.screenChild != null && instance.screenChild.isVisible()) {
            instance.screenChild.render();
        }
    }

    public static void resize(int w, int h) {
        if (instance.screenChild != null) {
            instance.screenChild.resize(w, h);
        }
    }

    public static boolean isShowing() {
        return instance.screenChild != null && instance.screenChild.isVisible();
    }
}
