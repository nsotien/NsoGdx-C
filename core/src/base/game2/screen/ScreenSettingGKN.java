package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.AutoTansat;
import base.game2.Code;

public class ScreenSettingGKN implements ScreenChild {

    private final Stage stage;
    private Window panel;
    private CheckBox cbBat;
    private SelectBox<String> sbMode;

    public boolean isVisible = false;

    public ScreenSettingGKN() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Auto Giữ Kết Nối");
        panel.defaults().pad(UIKit.ROW_PAD);

        UIKit.addFullRow(panel, UIKit.label("Chat \"b\" để mở lại")).padBottom(6f);

        cbBat = UIKit.cb("Bật giữ kết nối", Code.giuKetNoi);
        UIKit.addFullRow(panel, cbBat).padBottom(8f);

        sbMode = UIKit.selectBox(new String[]{"Tại chỗ", "Sang map (sv kunai)"}, Code.giuKetNoiMode);
        UIKit.addRow(panel, "Chế độ:", sbMode);

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

    private void save() {
        int mode = sbMode.getSelectedIndex();
        if (!cbBat.isChecked()) {
            if (Code.giuKetNoi) {
                Code.giuKetNoi = false;
                Code.popup_chat("Tắt auto giữ kết nối");
            }
        } else {
            if (Code.mode instanceof AutoTansat) {
                Code.popup_chat("Tắt tàn sát");
                Code.mode = null;
            }
            Code.giuKetNoi = true;
            Code.giuKetNoiMode = mode;
            Code.gkn_resetTimers();
            String modeName = mode == 0 ? "tại chỗ" : "sang map";
            Code.popup_chat("Bật auto giữ kết nối (" + modeName + ")");
        }
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
