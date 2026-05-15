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

import base.game2.GameCanvas;
import base.game2.RMS;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class KichYen implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private CheckBox cbKichYen;
    private CheckBox cbMobThuong, cbMobTinhAnh, cbMobThuLinh;
    private TextField tfHpThuong, tfHpTinhAnh, tfHpThuLinh;

    public boolean isVisible = false;

    public KichYen() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài Đặt Kích Yên");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table cbs = new Table();
        cbs.defaults().pad(4f);
        cbKichYen    = UIKit.cb("Kích yên",        base.game2.KichYen.active);
        cbMobThuong  = UIKit.cb("Quái thường",     base.game2.KichYen.isMobThuong);
        cbMobTinhAnh = UIKit.cb("Quái Tinh Anh",   base.game2.KichYen.isMobTinhAnh);
        cbMobThuLinh = UIKit.cb("Quái Thủ Lĩnh",   base.game2.KichYen.isMobThuLinh);

        if (UIKit.isPortrait()) {
            cbs.add(cbKichYen).left().row();
            cbs.add(cbMobThuong).left().row();
            cbs.add(cbMobTinhAnh).left().row();
            cbs.add(cbMobThuLinh).left().row();
        } else {
            cbs.add(cbKichYen).left().padRight(20f);
            cbs.add(cbMobThuong).left().row();
            cbs.add(cbMobTinhAnh).left().padRight(20f);
            cbs.add(cbMobThuLinh).left();
        }
        UIKit.addFullRow(panel, cbs).padBottom(8f);

        UIKit.addRow(panel, "HP quái thường (%)", tfHpThuong  = UIKit.tfDigits(String.valueOf(base.game2.KichYen.hpMobNomal)));
        UIKit.addRow(panel, "HP tinh anh (%)",    tfHpTinhAnh = UIKit.tfDigits(String.valueOf(base.game2.KichYen.hpMobTa)));
        UIKit.addRow(panel, "HP thủ lĩnh (%)",    tfHpThuLinh = UIKit.tfDigits(String.valueOf(base.game2.KichYen.hpMobTL)));

        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(10f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { saveDataPro(); hide(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    public void saveDataPro() {
        try {
            base.game2.KichYen.active       = cbKichYen.isChecked();
            base.game2.KichYen.isMobThuong  = cbMobThuong.isChecked();
            base.game2.KichYen.isMobTinhAnh = cbMobTinhAnh.isChecked();
            base.game2.KichYen.isMobThuLinh = cbMobThuLinh.isChecked();
            base.game2.KichYen.hpMobNomal   = Integer.parseInt(tfHpThuong.getText());
            base.game2.KichYen.hpMobTa      = Integer.parseInt(tfHpTinhAnh.getText());
            base.game2.KichYen.hpMobTL      = Integer.parseInt(tfHpThuLinh.getText());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeBoolean(base.game2.KichYen.active);
            dos.writeBoolean(base.game2.KichYen.isMobThuong);
            dos.writeBoolean(base.game2.KichYen.isMobTinhAnh);
            dos.writeBoolean(base.game2.KichYen.isMobThuLinh);
            dos.writeInt(base.game2.KichYen.hpMobNomal);
            dos.writeInt(base.game2.KichYen.hpMobTa);
            dos.writeInt(base.game2.KichYen.hpMobTL);
            RMS.a("Nsotien_kichyen", baos.toByteArray());
            dos.flush();
            baos.flush();
            GameCanvas.a("Lưu cài đặt thành công");
        } catch (Exception ex) {
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
