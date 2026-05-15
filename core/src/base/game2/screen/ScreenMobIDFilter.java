package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.Code;
import base.game2.RMS;

public class ScreenMobIDFilter implements ScreenChild {

    private final Stage stage;
    private Window panel;
    private CheckBox cbBat;
    private final TextField[] fields = new TextField[5];

    public boolean isVisible = false;

    public ScreenMobIDFilter() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Đánh theo ID Quái");
        panel.defaults().pad(UIKit.ROW_PAD);

        cbBat = UIKit.cb("Bật đánh theo ID", Code.danhTheoID);
        UIKit.addFullRow(panel, cbBat).padBottom(8f);

        for (int i = 0; i < 5; i++) {
            fields[i] = UIKit.tfDigits(String.valueOf(Code.mobIDFilter[i]));
            UIKit.addRow(panel, "ID Quái " + (i + 1) + ":", fields[i]);
        }

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
        Code.danhTheoID = cbBat.isChecked();
        for (int i = 0; i < 5; i++) {
            try {
                Code.mobIDFilter[i] = Code.normalizeMobIDFilter(Integer.parseInt(fields[i].getText().trim()));
            } catch (Exception e) {
                Code.mobIDFilter[i] = -1;
            }
        }
        String s = (Code.danhTheoID ? "1" : "0");
        for (int i = 0; i < Code.mobIDFilter.length; i++) s += ";" + Code.mobIDFilter[i];
        RMS.a("mobIDFilter", s);
        Code.popup_chat("Lưu cài đặt ID quái thành công");
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
