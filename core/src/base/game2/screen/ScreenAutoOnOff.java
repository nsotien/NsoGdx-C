package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.Code;
import base.game2.RMS;

public class ScreenAutoOnOff implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private CheckBox cbBat;
    private TextField tfOffHour, tfOffMin, tfOnHour, tfOnMin;

    public boolean isVisible = false;

    public ScreenAutoOnOff() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Auto On-Off");
        panel.defaults().pad(UIKit.ROW_PAD);

        UIKit.addFullRow(panel, UIKit.label("Cài đặt hẹn giờ tắt/bật")).padBottom(6f);

        cbBat = UIKit.cb("Bật Auto On-Off", Code.autoOnOff);
        UIKit.addFullRow(panel, cbBat).padBottom(8f);

        UIKit.addRow(panel, "Giờ off",  tfOffHour = UIKit.tfDigits(Code.onoffOffHour >= 0 ? String.valueOf(Code.onoffOffHour) : ""));
        UIKit.addRow(panel, "Phút off", tfOffMin  = UIKit.tfDigits(String.valueOf(Code.onoffOffMin)));
        UIKit.addRow(panel, "Giờ on",   tfOnHour  = UIKit.tfDigits(Code.onoffOnHour >= 0 ? String.valueOf(Code.onoffOnHour) : ""));
        UIKit.addRow(panel, "Phút on",  tfOnMin   = UIKit.tfDigits(String.valueOf(Code.onoffOnMin)));

        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(10f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { save(); hide(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    private int parseInt(TextField f, int def) {
        try {
            String t = f.getText().trim();
            if (t.isEmpty()) return def;
            return Integer.parseInt(t);
        } catch (Exception e) { return def; }
    }

    private void save() {
        Code.onoffOffHour = parseInt(tfOffHour, -1);
        Code.onoffOffMin  = parseInt(tfOffMin, 0);
        Code.onoffOnHour  = parseInt(tfOnHour, -1);
        Code.onoffOnMin   = parseInt(tfOnMin, 0);
        Code.autoOnOff    = cbBat.isChecked();
        Code.muaDaMua     = 0;
        String s = Code.onoffOffHour + ";" + Code.onoffOffMin + ";" + Code.onoffOnHour + ";" + Code.onoffOnMin;
        RMS.a("autoOnOff", s);
        Code.popup_chat("Auto On-Off: " + (Code.autoOnOff
                ? "Bật (" + Code.onoffOffHour + "h" + Code.onoffOffMin + " → " + Code.onoffOnHour + "h" + Code.onoffOnMin + ")"
                : "Tắt"));
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
    }
    @Override public void show() { isVisible = true; UIKit.mountStage(stage); }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
