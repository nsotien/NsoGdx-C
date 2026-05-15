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

import base.game2.CaiGom;
import base.game2.Code;

public class ScreenCaiGom implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private CheckBox cbEnable, cbAutoCat;
    private TextField tfName, tfItemGD, tfItemCat;
    private TextField tfGio, tfPhut, tfMap, tfZone;

    public boolean isVisible = false;

    public ScreenCaiGom() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài Đặt Auto Gom Đồ");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table content = new Table();
        content.defaults().pad(UIKit.ROW_PAD);

        cbEnable = UIKit.cb("Bật Auto Gom", CaiGom.enabled);
        UIKit.addFullRow(content, cbEnable).padBottom(6f);

        UIKit.addRow(content, "Tên nhận đồ",       tfName    = UIKit.tfText(CaiGom.receiverName == null ? "" : CaiGom.receiverName));
        UIKit.addRow(content, "Item GD (id,id,...)", tfItemGD  = UIKit.tfText(CaiGom.itemGDStr == null ? "" : CaiGom.itemGDStr));
        UIKit.addRow(content, "Giờ nhận đồ",       tfGio     = UIKit.tfDigits(String.valueOf(CaiGom.gioNhan)));
        UIKit.addRow(content, "Phút nhận đồ",      tfPhut    = UIKit.tfDigits(String.valueOf(CaiGom.phutNhan)));
        UIKit.addRow(content, "Map nhận đồ",       tfMap     = UIKit.tfDigits(String.valueOf(CaiGom.mapNhan)));
        UIKit.addRow(content, "Khu vực nhận",      tfZone    = UIKit.tfDigits(String.valueOf(CaiGom.zoneNhan)));

        cbAutoCat = UIKit.cb("Auto cất rương sau khi nhận", CaiGom.autoCat);
        UIKit.addFullRow(content, cbAutoCat).padTop(4f);

        UIKit.addRow(content, "Item Cất (id,id,...)", tfItemCat = UIKit.tfText(CaiGom.itemCatStr == null ? "" : CaiGom.itemCatStr));

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

    private void saveConfig() {
        try {
            CaiGom.enabled      = cbEnable.isChecked();
            CaiGom.autoCat      = cbAutoCat.isChecked();
            CaiGom.receiverName = tfName.getText().trim();
            CaiGom.itemGDStr    = tfItemGD.getText().trim();
            CaiGom.itemCatStr   = tfItemCat.getText().trim();
            CaiGom.gioNhan      = Integer.parseInt(tfGio.getText().trim());
            CaiGom.phutNhan     = Integer.parseInt(tfPhut.getText().trim());
            CaiGom.mapNhan      = Integer.parseInt(tfMap.getText().trim());
            CaiGom.zoneNhan     = Integer.parseInt(tfZone.getText().trim());
            CaiGom.gomCC        = -1;
            CaiGom.save();
            Code.popup_chat("Lưu cài đặt Auto Gom thành công");
        } catch (Exception e) {
            Code.popup_chat("Lỗi: kiểm tra lại cài đặt!");
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
