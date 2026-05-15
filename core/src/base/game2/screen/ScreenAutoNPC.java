package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.Code;
import base.game2.RMS;

public class ScreenAutoNPC implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private TextField tfNpcID, tfMenu1, tfMenu2;

    public boolean isVisible = false;

    public ScreenAutoNPC() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Auto NPC");
        panel.defaults().pad(UIKit.ROW_PAD);

        UIKit.addFullRow(panel, UIKit.label("Cài đặt Auto NPC")).padBottom(4f);
        UIKit.addFullRow(panel, UIKit.label("Lưu xong chat \"anpc [số lần]\" để chạy")).padBottom(8f);

        UIKit.addRow(panel, "ID NPC", tfNpcID = UIKit.tfDigits(Code.autoNpcID > 0 ? String.valueOf(Code.autoNpcID) : ""));
        UIKit.addRow(panel, "Menu 1", tfMenu1 = UIKit.tfDigits(String.valueOf(Code.autoNpcMenu1)));
        UIKit.addRow(panel, "Menu 2", tfMenu2 = UIKit.tfDigits(String.valueOf(Code.autoNpcMenu2)));

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
        Code.autoNpcID    = parseInt(tfNpcID, 0);
        Code.autoNpcMenu1 = parseInt(tfMenu1, 0);
        Code.autoNpcMenu2 = parseInt(tfMenu2, 0);
        String s = Code.autoNpcID + ";" + Code.autoNpcMenu1 + ";" + Code.autoNpcMenu2;
        RMS.a("autoNPC", s);
        Code.popup_chat("Đã lưu. Chat \"anpc [số lần]\" để chạy");
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
