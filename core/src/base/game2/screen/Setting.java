package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.Code;
import base.game2.RMS;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class Setting implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private CheckBox attackAll, attackHuman;                       // mode_4
    private CheckBox cuuSat, doSat, humanDosat, alwayOnDosat;      // mode_1
    private CheckBox dichChuyen, danhTrongTam;                     // mode_2
    private CheckBox danhTatCa, danhTrongListPK;                   // mode_3
    private CheckBox hoiSinhLuong, hoanLuong;                      // hsl, hlct
    private TextField tfHieuChien;

    public boolean isVisible = false;

    public Setting() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Menu auto PK người");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table content = new Table();
        content.defaults().pad(UIKit.ROW_PAD);

        // --- Tàn sát (mode_4) ---
        content.add(UIKit.title("Tàn sát")).colspan(2).left().padTop(4f);
        content.row();
        attackAll   = UIKit.cb("Đánh cả quái lẫn người", false);
        attackHuman = UIKit.cb("Đánh người",             false);
        ButtonGroup<CheckBox> gTs = new ButtonGroup<CheckBox>(attackAll, attackHuman);
        gTs.setMaxCheckCount(1); gTs.setMinCheckCount(1);
        if (base.game2.Setting.mode_4 == 1) attackHuman.setChecked(true); else attackAll.setChecked(true);
        content.add(attackAll).colspan(2).left().row();
        content.add(attackHuman).colspan(2).left().padBottom(6f).row();

        // --- Option 1 (mode_1) ---
        content.add(UIKit.title("Tùy chọn")).colspan(2).left().padTop(4f);
        content.row();
        cuuSat       = UIKit.cb("Cừu sát",            false);
        doSat        = UIKit.cb("Đồ sát",             false);
        humanDosat   = UIKit.cb("Khi họ bật đồ sát",  false);
        alwayOnDosat = UIKit.cb("Đồ sát (luôn bật)",  false);
        ButtonGroup<CheckBox> g1 = new ButtonGroup<CheckBox>(cuuSat, doSat, humanDosat, alwayOnDosat);
        g1.setMaxCheckCount(1); g1.setMinCheckCount(1);
        switch (base.game2.Setting.mode_1) {
            case 1: doSat.setChecked(true); break;
            case 2: humanDosat.setChecked(true); break;
            case 3: alwayOnDosat.setChecked(true); break;
            default: cuuSat.setChecked(true); break;
        }
        content.add(cuuSat).colspan(2).left().row();
        content.add(doSat).colspan(2).left().row();
        content.add(humanDosat).colspan(2).left().row();
        content.add(alwayOnDosat).colspan(2).left().padBottom(6f).row();

        // --- Option 2 (mode_2) ---
        content.add(UIKit.title("Di chuyển")).colspan(2).left().padTop(4f);
        content.row();
        dichChuyen   = UIKit.cb("Dịch chuyển",        false);
        danhTrongTam = UIKit.cb("Đánh khi ở trong tầm", false);
        ButtonGroup<CheckBox> g2 = new ButtonGroup<CheckBox>(dichChuyen, danhTrongTam);
        g2.setMaxCheckCount(1); g2.setMinCheckCount(1);
        if (base.game2.Setting.mode_2 == 1) danhTrongTam.setChecked(true); else dichChuyen.setChecked(true);
        content.add(dichChuyen).colspan(2).left().row();
        content.add(danhTrongTam).colspan(2).left().padBottom(6f).row();

        // --- Option 3 (mode_3) ---
        content.add(UIKit.title("Mục tiêu")).colspan(2).left().padTop(4f);
        content.row();
        danhTatCa       = UIKit.cb("Đánh tất cả",      false);
        danhTrongListPK = UIKit.cb("Đánh trong ListPK", false);
        ButtonGroup<CheckBox> g3 = new ButtonGroup<CheckBox>(danhTatCa, danhTrongListPK);
        g3.setMaxCheckCount(1); g3.setMinCheckCount(1);
        if (base.game2.Setting.mode_3 == 1) danhTrongListPK.setChecked(true); else danhTatCa.setChecked(true);
        content.add(danhTatCa).colspan(2).left().row();
        content.add(danhTrongListPK).colspan(2).left().padBottom(6f).row();

        // --- Option 4 (hồi sinh) ---
        content.add(UIKit.title("Hồi sinh")).colspan(2).left().padTop(4f);
        content.row();
        hoiSinhLuong = UIKit.cb("Hồi sinh lượng",      base.game2.Setting.hsl);
        hoanLuong    = UIKit.cb("Hoàn lương chi thảo", base.game2.Setting.hlct);
        content.add(hoiSinhLuong).colspan(2).left().row();
        content.add(hoanLuong).colspan(2).left().padBottom(6f).row();

        // Hiếu chiến field
        tfHieuChien = UIKit.tfDigits(String.valueOf(base.game2.Setting.hieuchien));
        UIKit.addRow(content, "Dùng hlct khi hiếu chiến", tfHieuChien);

        ScrollPane sp = UIKit.wrapScroll(content);
        panel.add(sp).colspan(2).expandX().fillX().maxHeight(400f).padBottom(4f);
        panel.row();

        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(10f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { saveSetting(); hide(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    public void saveSetting() {
        OutputStream var1 = new ByteArrayOutputStream();
        DataOutputStream var2 = new DataOutputStream(var1);
        try {
            base.game2.Setting.mode_4 = attackHuman.isChecked() ? 1 : 0;
            if (doSat.isChecked())            base.game2.Setting.mode_1 = 1;
            else if (humanDosat.isChecked())  base.game2.Setting.mode_1 = 2;
            else if (alwayOnDosat.isChecked()) base.game2.Setting.mode_1 = 3;
            else                               base.game2.Setting.mode_1 = 0;
            base.game2.Setting.mode_2    = danhTrongTam.isChecked() ? 1 : 0;
            base.game2.Setting.mode_3    = danhTrongListPK.isChecked() ? 1 : 0;
            base.game2.Setting.hsl       = hoiSinhLuong.isChecked();
            base.game2.Setting.hlct      = hoanLuong.isChecked();
            base.game2.Setting.hieuchien = Integer.parseInt(tfHieuChien.getText());

            var2.writeInt(base.game2.Setting.mode_1);
            var2.writeInt(base.game2.Setting.mode_2);
            var2.writeInt(base.game2.Setting.mode_3);
            var2.writeInt(base.game2.Setting.hieuchien);
            var2.writeBoolean(base.game2.Setting.hsl);
            var2.writeBoolean(base.game2.Setting.hlct);
            var2.writeInt(base.game2.Setting.mode_4);
            RMS.a("SettingPK", ((ByteArrayOutputStream) var1).toByteArray());
            var2.flush();
            var1.flush();
            Code.popup_chat("Lưu cài đặt thành công");
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
