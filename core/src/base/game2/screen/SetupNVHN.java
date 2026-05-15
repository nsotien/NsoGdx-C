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

public class SetupNVHN implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private CheckBox cbEnable;
    private TextField tfGio, tfPhut;

    public boolean isVisible = false;

    public SetupNVHN() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài Đặt NVHN");
        panel.defaults().pad(UIKit.ROW_PAD);

        cbEnable = UIKit.cb("Bật Auto NVHN", Code.isAutoNVHN);
        UIKit.addFullRow(panel, cbEnable).padBottom(8f);

        UIKit.addRow(panel, "Giờ",  tfGio  = UIKit.tfDigits(String.valueOf(Code.nvhnHour)));
        UIKit.addRow(panel, "Phút", tfPhut = UIKit.tfDigits(String.valueOf(Code.nvhnMin)));

        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(10f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { saveSettings(); hide(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    private void saveSettings() {
        try {
            int gio  = Integer.parseInt(tfGio.getText().trim());
            int phut = Integer.parseInt(tfPhut.getText().trim());
            if (gio < 0 || gio > 23)   { Code.popup_chat("Giờ từ 0 đến 23!"); return; }
            if (phut < 0 || phut > 59) { Code.popup_chat("Phút từ 0 đến 59!"); return; }
            Code.isAutoNVHN = cbEnable.isChecked();
            Code.nvhnHour   = gio;
            Code.nvhnMin    = phut;
            Code.nvhnCC     = -1;

            String data = (Code.isAutoNVHN ? "1" : "0") + ";" + Code.nvhnHour + ";" + Code.nvhnMin;
            RMS.a("setupNVHN", data);
            Code.popup_chat("Lưu NVHN: " + (Code.isAutoNVHN ? "Bật" : "Tắt") + " " + gio + "h" + phut);
        } catch (Exception e) {
            Code.popup_chat("Lỗi: kiểm tra lại cài đặt!");
        }
    }

    public static void loadSettings() {
        String data = RMS.b("setupNVHN");
        if (data != null && data.length() > 0) {
            try {
                String[] parts = data.split(";");
                if (parts.length >= 3) {
                    Code.isAutoNVHN = parts[0].equals("1");
                    Code.nvhnHour   = Integer.parseInt(parts[1]);
                    Code.nvhnMin    = Integer.parseInt(parts[2]);
                }
            } catch (Exception e) {
                ;
            }
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
