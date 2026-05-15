package base.game1.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game1.Code;
import base.game1.DebugLog;
import base.game1.RMS;

public class MenuHangDong implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private CheckBox cbAutoDan, cbAutoHD, cbAutoLenhBai, cbTheoNhom, cbLayRuong;
    private TextField tfGio, tfPhut, tfGioLB, tfPhutLB, tfMapNhom, tfKhuNhom;

    public boolean isVisible = false;

    public MenuHangDong() {
        stage = UIKit.newStage();
        build();
        if (DebugLog.DEBUG) DebugLog.log("UI", "MenuHangDong created");
    }

    private void build() {
        panel = UIKit.panel("Menu Hang Động");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table content = new Table();
        content.defaults().pad(UIKit.ROW_PAD);

        // Checkbox group
        Table cbs = new Table();
        cbs.defaults().pad(4f);
        cbAutoDan     = UIKit.cb("Auto Đan",           Code.autoDan);
        cbAutoHD      = UIKit.cb("Hang động",          base.game1.MenuHangDong.autohd);
        cbAutoLenhBai = UIKit.cb("Lệnh bài hd",        base.game1.MenuHangDong.autohd_lbhd);
        cbTheoNhom    = UIKit.cb("Hang động theo nhóm", base.game1.MenuHangDong.theoNhom);
        cbLayRuong    = UIKit.cb("Lấy rương (hd9x)",   base.game1.MenuHangDong.layRuong);

        if (UIKit.isPortrait()) {
            cbs.add(cbAutoDan).left().row();
            cbs.add(cbAutoHD).left().row();
            cbs.add(cbAutoLenhBai).left().row();
            cbs.add(cbTheoNhom).left().row();
            cbs.add(cbLayRuong).left().row();
        } else {
            cbs.add(cbAutoDan).left().padRight(16f);
            cbs.add(cbAutoHD).left().padRight(16f);
            cbs.add(cbAutoLenhBai).left().row();
            cbs.add(cbTheoNhom).left().padRight(16f);
            cbs.add(cbLayRuong).left();
        }
        UIKit.addFullRow(content, cbs).padBottom(8f);

        UIKit.addRow(content, "Giờ hang động",        tfGio     = UIKit.tfDigits(String.valueOf(base.game1.MenuHangDong.gio_hd)));
        UIKit.addRow(content, "Phút hang động",       tfPhut    = UIKit.tfDigits(String.valueOf(base.game1.MenuHangDong.phut_hd)));
        UIKit.addRow(content, "Giờ hd (lệnh bài)",    tfGioLB   = UIKit.tfDigits(String.valueOf(base.game1.MenuHangDong.gio_hd_lbhd)));
        UIKit.addRow(content, "Phút hd (lệnh bài)",   tfPhutLB  = UIKit.tfDigits(String.valueOf(base.game1.MenuHangDong.phut_hd_lbhd)));
        UIKit.addRow(content, "Map tập trung (nhóm)", tfMapNhom = UIKit.tfDigits(String.valueOf(base.game1.MenuHangDong.map_nhom)));
        UIKit.addRow(content, "Khu tập trung (nhóm)", tfKhuNhom = UIKit.tfDigits(String.valueOf(base.game1.MenuHangDong.khu_nhom)));

        ScrollPane sp = UIKit.wrapScroll(content);
        panel.add(sp).colspan(2).expandX().fillX().maxHeight(380f).padBottom(4f);
        panel.row();

        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(10f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { saveDataHD(); hide(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    public void saveDataHD() {
        try {
            base.game1.MenuHangDong.gio_hd       = Integer.parseInt(tfGio.getText());
            base.game1.MenuHangDong.phut_hd      = Integer.parseInt(tfPhut.getText());
            base.game1.MenuHangDong.gio_hd_lbhd  = Integer.parseInt(tfGioLB.getText());
            base.game1.MenuHangDong.phut_hd_lbhd = Integer.parseInt(tfPhutLB.getText());
            base.game1.MenuHangDong.map_nhom     = Integer.parseInt(tfMapNhom.getText());
            base.game1.MenuHangDong.khu_nhom     = Integer.parseInt(tfKhuNhom.getText());
            Code.autoDan                         = cbAutoDan.isChecked();
            base.game1.MenuHangDong.autohd       = cbAutoHD.isChecked();
            base.game1.MenuHangDong.autohd_lbhd  = cbAutoLenhBai.isChecked();
            base.game1.MenuHangDong.theoNhom     = cbTheoNhom.isChecked();
            base.game1.MenuHangDong.layRuong     = cbLayRuong.isChecked();

            RMS.a("autodan",      Code.autoDan                           ? 1 : -1);
            RMS.a("autohd",       base.game1.MenuHangDong.autohd         ? 1 : -1);
            RMS.a("autohd_lbhd",  base.game1.MenuHangDong.autohd_lbhd    ? 1 : -1);
            RMS.a("theoNhom_hd",  base.game1.MenuHangDong.theoNhom       ? 1 : -1);
            RMS.a("layRuong_hd",  base.game1.MenuHangDong.layRuong       ? 1 : -1);
            RMS.a("SettingCave",
                    base.game1.MenuHangDong.gio_hd + ";" + base.game1.MenuHangDong.phut_hd + ";"
                  + base.game1.MenuHangDong.gio_hd_lbhd + ";" + base.game1.MenuHangDong.phut_hd_lbhd + ";"
                  + base.game1.MenuHangDong.map_nhom + ";" + base.game1.MenuHangDong.khu_nhom + ";"
                  + base.game1.MenuHangDong.autohd + ";" + base.game1.MenuHangDong.autohd_lbhd + ";"
                  + Code.autoDan + ";" + base.game1.MenuHangDong.theoNhom + ";"
                  + base.game1.MenuHangDong.layRuong);
            Code.popup_chat("Lưu cài đặt thành công");
            if (DebugLog.DEBUG) DebugLog.log("UI", "MenuHangDong saved autoDan=" + Code.autoDan
                    + " autohd=" + base.game1.MenuHangDong.autohd + " lbhd=" + base.game1.MenuHangDong.autohd_lbhd
                    + " theoNhom=" + base.game1.MenuHangDong.theoNhom + " layRuong=" + base.game1.MenuHangDong.layRuong);
        } catch (NumberFormatException ex) {
            if (DebugLog.DEBUG) DebugLog.error("MenuHangDong save parse failed: " + ex.getMessage(), ex);
        }
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
        UIKit.logResize("MenuHangDong", stage, w, h);
    }
    @Override public void show() { isVisible = true; UIKit.mountStage(stage); }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
