package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.Code;
import base.game2.GameCanvas;

public class SetupVxmm implements ScreenChild {

    private final Stage stage;
    private TextField tfXuMin, tfXuMax;
    private Window panel;

    public boolean isVisible = false;

    public SetupVxmm() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài đặt chung Vxmm");
        panel.defaults().pad(UIKit.ROW_PAD);

        tfXuMin = UIKit.tfDigits(String.valueOf(Code.xuMin));
        tfXuMax = UIKit.tfDigits(String.valueOf(Code.xuMax));
        UIKit.addRow(panel, "Xu min", tfXuMin);
        UIKit.addRow(panel, "Xu max", tfXuMax);

        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(10f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                saveDataPro();
                hide();
            }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    public void saveDataPro() {
        try {
            Code.xuMin = Integer.parseInt(tfXuMin.getText());
            Code.xuMax = Integer.parseInt(tfXuMax.getText());
            GameCanvas.a("Lưu cài đặt thành công");
        } catch (Exception ex) {
        }
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
    }
    @Override public void show() {
        isVisible = true;
        UIKit.mountStage(stage);
    }
    @Override public void hide() {
        isVisible = false;
        UIKit.restoreInput();
    }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
