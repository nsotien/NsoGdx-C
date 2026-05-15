package javax.microedition.lcdui;

import base.game1.screen.ScreenChild;
import base.game1.screen.ScreenManager;
import com.monkey.nso.NSO;
import javax.microedition.midlet.MIDlet;

/**
 * J2ME Display stub for LibGDX.
 * setCurrent(Form) → opens Scene2D popup via ScreenManager
 * setCurrent(Canvas) → sets NSO.gameCanvas
 */
public class Display {
    private static Display instance = new Display();

    public static Display getDisplay(MIDlet midlet) {
        return instance;
    }

    public void setCurrent(Canvas canvas) {
        if (canvas != null) {
            // Close any open popup and return to game
            ScreenManager.hide();
            NSO.gameCanvas = canvas;
        }
    }

    public void setCurrent(Object displayable) {
        if (displayable instanceof Canvas) {
            setCurrent((Canvas) displayable);
        } else if (displayable instanceof ScreenChild) {
            // LibGDX Scene2D popup
            ScreenManager.show((ScreenChild) displayable);
        } else {
            // J2ME Form — try to find matching Scene2D popup
            String className = displayable.getClass().getSimpleName();
            ;
            try {
                openPopupByName(className, displayable);
            } catch (Exception e) {
                ;
                ;
            }
        }
    }

    private void openPopupByName(final String name, Object form) {
        // Must create Scene2D popup on GL thread
        com.badlogic.gdx.Gdx.app.postRunnable(new Runnable() {
            public void run() {
                try {
                    ScreenChild popup = null;
                    switch (name) {
                        case "menu_pkam":
                            if (ScreenManager.menuPkam == null) ScreenManager.menuPkam = new base.game1.screen.menu_pkam();
                            popup = ScreenManager.menuPkam;
                            break;
                        case "Setting":
                            if (ScreenManager.setting == null) ScreenManager.setting = new base.game1.screen.Setting();
                            popup = ScreenManager.setting;
                            break;
                        case "KichYen":
                            if (ScreenManager.kichYen == null) ScreenManager.kichYen = new base.game1.screen.KichYen();
                            popup = ScreenManager.kichYen;
                            break;
                        case "MenuHangDong":
                            if (ScreenManager.menuHangDong == null) ScreenManager.menuHangDong = new base.game1.screen.MenuHangDong();
                            popup = ScreenManager.menuHangDong;
                            break;
                        case "SettingGKN":
                            if (ScreenManager.setting == null) ScreenManager.setting = new base.game1.screen.Setting();
                            popup = ScreenManager.setting;
                            break;
                        case "FormSetupVxmm":
                            if (ScreenManager.setupVxmm == null) ScreenManager.setupVxmm = new base.game1.screen.SetupVxmm();
                            popup = ScreenManager.setupVxmm;
                            break;
                    }
                    if (popup != null) {
                        ScreenManager.show(popup);
                        ;
                    } else {
                        ;
                    }
                } catch (Exception e) {
                    ;
                    ;
                }
            }
        });
    }
}
