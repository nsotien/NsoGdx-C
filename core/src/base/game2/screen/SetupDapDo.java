package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.Char;
import base.game2.Code;
import base.game2.phong;

public class SetupDapDo implements ScreenChild {

    private final Stage stage;
    private Window panel;
    private CheckBox cbEnable;
    private SelectBox<String> sbMaxNangCap;
    private SelectBox<String> sbDaCap8;
    private Cell rowDaCap8Label;
    private Cell rowDaCap8Box;

    public boolean isVisible = false;

    public SetupDapDo() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài Đặt Auto Đập Đồ");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table content = new Table();
        content.defaults().pad(UIKit.ROW_PAD);

        cbEnable = UIKit.cb("Bật Auto Đập Đồ", Code.isADapDo);
        UIKit.addFullRow(content, cbEnable).padBottom(6f);

        String[] capDos = new String[]{"+4","+5","+6","+7","+8","+9","+10","+11","+12","+13","+14","+15","+16"};
        sbMaxNangCap = UIKit.selectBox(capDos, Math.max(0, Math.min(Code.CapDoValue - 4, 12)));
        UIKit.addRow(content, "Max nâng cấp", sbMaxNangCap);

        // Đá dùng cho +8: chỉ hiển thị khi maxCap >= +8 (index >= 4), mirror TGAME FormDapDo
        sbDaCap8 = UIKit.selectBox(new String[]{"Đá 6", "Đá 7"}, Code.advCI == 6 ? 1 : 0);
        Label labelDaCap8 = UIKit.label("Đá dùng cho +8");
        content.add(labelDaCap8);
        rowDaCap8Label = content.getCell(labelDaCap8);
        content.add(sbDaCap8);
        rowDaCap8Box = content.getCell(sbDaCap8);
        content.row();
        updateDaCap8Visibility(sbMaxNangCap.getSelectedIndex() >= 4);

        sbMaxNangCap.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                updateDaCap8Visibility(sbMaxNangCap.getSelectedIndex() >= 4);
            }
        });

        Label note = UIKit.label(
            "- Không bật song song Auto Danh Vọng / Lọc đồ\n" +
            "- Chỉ tích Nhặt đá, KHÔNG tích Luyện đá");
        UIKit.addFullRow(content, note).padTop(6f);

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
            @Override public void changed(ChangeEvent e, Actor a) { saveConfig(); hide(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    private void updateDaCap8Visibility(boolean visible) {
        if (rowDaCap8Label == null || rowDaCap8Box == null) return;
        rowDaCap8Label.getActor().setVisible(visible);
        rowDaCap8Box.getActor().setVisible(visible);
        if (visible) {
            rowDaCap8Label.minWidth(UIKit.LABEL_MIN_W).height(UIKit.FIELD_H).pad(UIKit.ROW_PAD).padRight(10f);
            rowDaCap8Box.minWidth(UIKit.FIELD_MIN_W).height(UIKit.FIELD_H).pad(UIKit.ROW_PAD);
        } else {
            rowDaCap8Label.size(0, 0).pad(0);
            rowDaCap8Box.size(0, 0).pad(0);
        }
        if (rowDaCap8Label.getTable() != null) rowDaCap8Label.getTable().invalidateHierarchy();
    }

    private void saveConfig() {
        try {
            boolean newIsADapDo = cbEnable.isChecked();
            // Auto-coordinate flag khi toggle ON (mirror TGAME FormDapDo)
            if (newIsADapDo && !Code.isADapDo) {
                Char.luyen_da = false;
                Char.nhat_da  = true;
                phong.save_auto();
            }
            Code.isADapDo   = newIsADapDo;
            Code.CapDoValue = sbMaxNangCap.getSelectedIndex() + 4;
            Code.advCI      = (sbMaxNangCap.getSelectedIndex() >= 4 && sbDaCap8.getSelectedIndex() == 1) ? 6 : 5;
            Code.saveADapDoRMS();
            Code.popup_chat("Lưu cài đặt Auto Đập Đồ thành công");
        } catch (Exception e) {
            Code.popup_chat("Lỗi: kiểm tra lại cài đặt!");
        }
    }

    @Override public void resize(int w, int h) { stage.getViewport().update(w, h, true); UIKit.layoutPanel(stage, panel); }
    @Override public void show()    { isVisible = true;  UIKit.mountStage(stage); }
    @Override public void hide()    { isVisible = false; UIKit.restoreInput(); }
    @Override public void render()  { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
