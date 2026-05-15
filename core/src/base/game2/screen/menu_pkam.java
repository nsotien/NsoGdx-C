package base.game2.screen;

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

import base.game2.AutoChoPK;
import base.game2.AutoDanhPK;
import base.game2.AutoMapKhu;
import base.game2.Code;
import base.game2.GameCanvas;
import base.game2.RMS;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class menu_pkam implements ScreenChild {

    private final Stage stage;
    public boolean isVisible = false;

    private TextField tfKhuChoPk;
    private TextField tfKhuDanhPk;
    private TextField tfIdMapPk;
    private TextField tfToaDoX;
    private TextField tfToaDoY;
    private TextField tfPtPk;
    private CheckBox  cbMenuPk;
    private CheckBox  cbShowInfo;
    // Port TGAME: 2 CheckBox bot chờ/đánh PK (exclusive nhau, cả 2 có thể cùng false)
    private CheckBox  cbBotChoPK;
    private CheckBox  cbBotDanhPK;

    private Window panel;

    public menu_pkam() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Menu PK âm kinh nhiệm");
        panel.defaults().pad(UIKit.ROW_PAD);

        // Content đi vào Table riêng, wrap ScrollPane để cuộn khi dài
        Table content = new Table();
        content.defaults().pad(UIKit.ROW_PAD);
        buildCheckboxRows(content);
        buildFieldRows(content);

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
                saveDataPk();
                hide();
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

    // Mỗi checkbox 1 hàng riêng. "Menu pk / Bot chờ PK / Bot đánh PK" là 3 mode loại trừ nhau.
    // "Hiện thông tin up" độc lập.
    private void buildCheckboxRows(Table p) {
        cbMenuPk    = UIKit.cb("Menu pk",           Code.pkam);
        cbShowInfo  = UIKit.cb("Hiện thông tin up", AutoMapKhu.showUpInfo);
        cbBotChoPK  = UIKit.cb("Bot chờ PK",        Code.mode instanceof AutoChoPK);
        cbBotDanhPK = UIKit.cb("Bot đánh PK",       Code.mode instanceof AutoDanhPK);

        // State ban đầu có thể lệch: cbMenuPk bật (pkam=true) nhưng mode cũng đang AutoChoPK/DanhPK.
        // Normalize: ưu tiên mode runtime > pkam flag, khớp logic mutex.
        if (cbBotChoPK.isChecked() || cbBotDanhPK.isChecked()) {
            cbMenuPk.setChecked(false);
        }

        wireModeExclusive();

        UIKit.addFullRow(p, cbMenuPk).padBottom(4f);
        UIKit.addFullRow(p, cbBotChoPK).padBottom(4f);
        UIKit.addFullRow(p, cbBotDanhPK).padBottom(4f);
        UIKit.addFullRow(p, cbShowInfo).padBottom(8f);
    }

    private void buildFieldRows(Table p) {
        UIKit.addRow(p, "Khu chờ pk",        tfKhuChoPk  = UIKit.tfDigits(String.valueOf(base.game2.menu_pkam.khucpk)));
        UIKit.addRow(p, "Khu đánh pk",       tfKhuDanhPk = UIKit.tfDigits(String.valueOf(base.game2.menu_pkam.khudpk)));
        UIKit.addRow(p, "ID map PK",         tfIdMapPk   = UIKit.tfDigits(String.valueOf(base.game2.menu_pkam.map)));
        UIKit.addRow(p, "Tọa độ X",          tfToaDoX    = UIKit.tfDigits(String.valueOf(base.game2.menu_pkam.x)));
        UIKit.addRow(p, "Tọa độ Y",          tfToaDoY    = UIKit.tfDigits(String.valueOf(base.game2.menu_pkam.y)));
        UIKit.addRow(p, "Bao nhiêu % thì pk", tfPtPk     = UIKit.tfDigits(String.valueOf(base.game2.menu_pkam.ptpk)));
    }

    // 3 CheckBox mode loại trừ nhau: tick 1 trong Menu pk / Bot chờ PK / Bot đánh PK → uncheck 2 cái còn lại.
    // Cho phép cả 3 cùng false (= không chạy mode nào). "Hiện thông tin up" không đụng vào đây.
    private void wireModeExclusive() {
        cbMenuPk.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                if (cbMenuPk.isChecked()) {
                    cbBotChoPK.setChecked(false);
                    cbBotDanhPK.setChecked(false);
                }
            }
        });
        cbBotChoPK.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                if (cbBotChoPK.isChecked()) {
                    cbMenuPk.setChecked(false);
                    cbBotDanhPK.setChecked(false);
                }
            }
        });
        cbBotDanhPK.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                if (cbBotDanhPK.isChecked()) {
                    cbMenuPk.setChecked(false);
                    cbBotChoPK.setChecked(false);
                }
            }
        });
    }

    public void saveDataPk() {
        OutputStream var1 = new ByteArrayOutputStream();
        DataOutputStream var2 = new DataOutputStream(var1);
        try {
            Code.pkam = this.cbMenuPk.isChecked();
            RMS.a("Phongpkam", Code.pkam ? 1 : -1);
            base.game2.menu_pkam.khucpk = Integer.parseInt(this.tfKhuChoPk.getText());
            base.game2.menu_pkam.khudpk = Integer.parseInt(this.tfKhuDanhPk.getText());
            base.game2.menu_pkam.map   = Integer.parseInt(this.tfIdMapPk.getText());
            base.game2.menu_pkam.x     = Integer.parseInt(this.tfToaDoX.getText());
            base.game2.menu_pkam.y     = Integer.parseInt(this.tfToaDoY.getText());
            base.game2.menu_pkam.ptpk  = Long.parseLong(this.tfPtPk.getText());
            AutoMapKhu.showUpInfo = this.cbShowInfo.isChecked();
            RMS.a("isShow", AutoMapKhu.showUpInfo ? 1 : -1);
            var2.writeInt(base.game2.menu_pkam.khucpk);
            var2.writeInt(base.game2.menu_pkam.khudpk);
            var2.writeInt(base.game2.menu_pkam.map);
            var2.writeInt(base.game2.menu_pkam.x);
            var2.writeInt(base.game2.menu_pkam.y);
            var2.writeLong(base.game2.menu_pkam.ptpk);
            RMS.a("SettingPKam", ((ByteArrayOutputStream) var1).toByteArray());
            var2.flush();
            var1.flush();

            // Port TGAME: dispatch toggle bot chờ/đánh PK theo trạng thái CheckBox mới (sau khi đã save toạ độ)
            boolean wantChoPK  = this.cbBotChoPK != null && this.cbBotChoPK.isChecked();
            boolean wantDanhPK = this.cbBotDanhPK != null && this.cbBotDanhPK.isChecked();
            boolean isChoPK    = Code.mode instanceof AutoChoPK;
            boolean isDanhPK   = Code.mode instanceof AutoDanhPK;
            if (wantChoPK != isChoPK) {
                Code.toggleAutoChoPK();
            }
            isDanhPK = Code.mode instanceof AutoDanhPK;
            if (wantDanhPK != isDanhPK) {
                Code.toggleAutoDanhPK();
            }

            GameCanvas.a("Lưu cài đặt thành công");
        } catch (Exception ex) {
        }
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
