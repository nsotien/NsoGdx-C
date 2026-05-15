package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.AutoMapKhu;
import base.game2.Code;
import base.game2.DebugLog;
import base.game2.GameCanvas;
import base.game2.MenuPro;

// Form "Cai up" — port tu TGAME FormCaiUp (J2ME Form) sang Scene2D UIKit.
// Plan: plan/PLAN_PORT_TGAME_BATCH2.md Muc 5.
public class FormCaiUp implements ScreenChild {

    private final Stage stage;
    public boolean isVisible = false;

    private CheckBox  cbShowInfo;
    private CheckBox  cbAllowCheck;
    private CheckBox  cbAutoX2;
    private CheckBox  cbAutoTnp;
    private CheckBox  cbHpOffPk;   // [FIX 15]
    private TextField tfHpOffPk;   // [FIX 15]
    private TextField tfMapId;
    private TextField tfZones;

    private Window panel;

    public FormCaiUp() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài đặt up yên");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table content = new Table();
        content.defaults().pad(UIKit.ROW_PAD);

        cbShowInfo = UIKit.cb("Hiện thông tin up", AutoMapKhu.showUpInfo);
        UIKit.addFullRow(content, cbShowInfo).padBottom(6f);

        cbAllowCheck = UIKit.cb("Cho phép check yên/xu", MenuPro.allow_check);
        UIKit.addFullRow(content, cbAllowCheck).padBottom(6f);

        cbAutoX2 = UIKit.cb("Tự dùng x2 khi lên cấp", MenuPro.auto_x2);
        UIKit.addFullRow(content, cbAutoX2).padBottom(6f);

        cbAutoTnp = UIKit.cb("Tự dùng TNP khi lên cấp", MenuPro.auto_tnp);
        UIKit.addFullRow(content, cbAutoTnp).padBottom(6f);

        cbHpOffPk = UIKit.cb("Remap khi HP <= %", MenuPro.hpOffPk > 0); // [FIX 15]
        UIKit.addFullRow(content, cbHpOffPk).padBottom(6f);

        tfHpOffPk = UIKit.tfDigits(String.valueOf(MenuPro.hpOffPk > 0 ? MenuPro.hpOffPk : 30)); // [FIX 15]
        UIKit.addRow(content, "% HP REMAP", tfHpOffPk);

        tfMapId = UIKit.tfDigits(String.valueOf(AutoMapKhu.cfgMapId));
        UIKit.addRow(content, "ID map (-1=giữ map hiện tại)", tfMapId);

        tfZones = new TextField(zonesToString(AutoMapKhu.cfgZones), UIKit.skin());
        UIKit.addRow(content, "Khu (-1=giữ, 12,24,11=đánh CK)", tfZones);

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
            @Override public void changed(ChangeEvent e, Actor a) {
                saveConfig();
            }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                hide();
            }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    private void saveConfig() {
        int mapId;
        int[] zones;
        try {
            mapId = Integer.parseInt(tfMapId.getText().trim());
        } catch (Exception ex) {
            GameCanvas.a("ID map sai");
            return;
        }
        try {
            zones = AutoMapKhu.parseZones(tfZones.getText());
        } catch (Exception ex) {
            GameCanvas.a("Khu up sai");
            return;
        }
        boolean show = cbShowInfo.isChecked();
        if (!AutoMapKhu.setConfig(mapId, zones, show)) {
            GameCanvas.a("ID map sai");
            return;
        }
        MenuPro.allow_check = cbAllowCheck.isChecked();
        MenuPro.auto_x2     = cbAutoX2.isChecked();
        MenuPro.auto_tnp    = cbAutoTnp.isChecked();
        // [FIX 15] checkbox: nếu không tích → tắt (hpOffPk=0), nếu tích → lấy giá trị ô nhập
        if (!cbHpOffPk.isChecked()) {
            MenuPro.hpOffPk = 0;
        } else {
            try {
                int hp = Integer.parseInt(tfHpOffPk.getText().trim());
                MenuPro.hpOffPk = (hp > 0 && hp <= 100) ? hp : 30;
            } catch (Exception e) {
                MenuPro.hpOffPk = 30;
            }
        }
        MenuPro.save();
        Code.popup_chat("Đã lưu Cài up");
        if (DebugLog.DEBUG) DebugLog.log("UI", "FormCaiUp saved mapId=" + mapId + " zones.len=" + zones.length + " show=" + show);
        hide();
    }

    private static String zonesToString(int[] zones) {
        if (zones == null || zones.length == 0) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zones.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(zones[i]);
        }
        return sb.toString();
    }

    @Override public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

    @Override public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override public boolean isVisible() {
        return isVisible;
    }
}
