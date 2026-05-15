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

public class ScreenAutoMuaItem implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private TextField tfNpcTemplateID, tfNpcID, tfViTri, tfSoLan, tfItemID;

    public boolean isVisible = false;

    public ScreenAutoMuaItem() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Auto Mua Item");
        panel.defaults().pad(UIKit.ROW_PAD);

        UIKit.addFullRow(panel, UIKit.label("Cài đặt Auto Mua Item Shop")).padBottom(4f);
        UIKit.addFullRow(panel, UIKit.label("Lưu xong chat \"buy\" để bật/tắt")).padBottom(8f);

        UIKit.addRow(panel, "NPC ID (trên map)",  tfNpcTemplateID = UIKit.tfDigits(Code.muaNpcTemplateID >= 0 ? String.valueOf(Code.muaNpcTemplateID) : ""));
        UIKit.addRow(panel, "Type cửa hàng",      tfNpcID         = UIKit.tfDigits(Code.muaNpcID         >= 0 ? String.valueOf(Code.muaNpcID) : ""));
        UIKit.addRow(panel, "Vị trí item",        tfViTri         = UIKit.tfDigits(Code.muaViTriItem     >= 0 ? String.valueOf(Code.muaViTriItem) : ""));
        UIKit.addRow(panel, "Số lần mua",         tfSoLan         = UIKit.tfDigits(Code.muaSoLan         >= 0 ? String.valueOf(Code.muaSoLan) : ""));
        UIKit.addRow(panel, "ID item check",      tfItemID        = UIKit.tfDigits(Code.muaItemID        >= 0 ? String.valueOf(Code.muaItemID) : ""));

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
        Code.muaNpcTemplateID = parseInt(tfNpcTemplateID, -1);
        Code.muaNpcID         = parseInt(tfNpcID, -1);
        Code.muaViTriItem     = parseInt(tfViTri, -1);
        Code.muaSoLan         = Math.max(1, parseInt(tfSoLan, 1));
        Code.muaItemID        = parseInt(tfItemID, 0);
        Code.muaDaMua         = 0;
        String s = "0;" + Code.muaNpcTemplateID + ";" + Code.muaNpcID + ";"
                 + Code.muaViTriItem + ";" + Code.muaSoLan + ";" + Code.muaItemID;
        RMS.a("autoMuaItem", s);
        Code.popup_chat("Đã lưu. Chat \"buy\" để bật");
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
