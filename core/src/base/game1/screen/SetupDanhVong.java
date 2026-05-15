package base.game1.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game1.Code;
import base.game1.DebugLog;
import base.game1.FormDanhVong;
import base.game1.RMS;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class SetupDanhVong implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private CheckBox cbEnable;
    private TextField tfDoiThu;
    private TextField tfMapLD, tfKhuLD;
    private TextField tfMapDV, tfKhuDV;
    private TextField tfXuCuoc;
    private TextField tfGioAuto, tfPhutAuto;
    private TextField tfMapLTD;
    private TextField tfDVPhu;
    private TextField tfMaxNangCap, tfChiDap;
    private SelectBox<String> sbNVNangCap, sbAutoMuaDo, sbThieuItem, sbNVDanhQuai;
    private CheckBox cbHuyTA, cbHuyTL, cbHuyLoiDai, cbAccPhuLogout;

    public boolean isVisible = false;

    public SetupDanhVong() {
        stage = UIKit.newStage();
        build();
        if (DebugLog.DEBUG) DebugLog.log("UI", "SetupDanhVong created");
    }

    private void build() {
        panel = UIKit.panel("Cài Đặt Danh Vọng");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table content = new Table();
        content.defaults().pad(UIKit.ROW_PAD);

        cbEnable = UIKit.cb("Tự đi làm DV", FormDanhVong.isADanhVong);
        UIKit.addFullRow(content, cbEnable).padBottom(6f);

        UIKit.addRow(content, "Giờ Auto DV",      tfGioAuto    = UIKit.tfDigits(String.valueOf(FormDanhVong.advAH)));
        UIKit.addRow(content, "Phút Auto DV",     tfPhutAuto   = UIKit.tfDigits(String.valueOf(FormDanhVong.advAI)));
        UIKit.addRow(content, "Đối thủ",          tfDoiThu     = UIKit.tfText(FormDanhVong.advAB));
        UIKit.addRow(content, "Xu cược LD",       tfXuCuoc     = UIKit.tfDigits(String.valueOf(FormDanhVong.advAG)));
        UIKit.addRow(content, "Map Lôi Đài",      tfMapLD      = UIKit.tfDigits(String.valueOf(FormDanhVong.advAC)));
        UIKit.addRow(content, "Khu Lôi Đài",      tfKhuLD      = UIKit.tfDigits(String.valueOf(FormDanhVong.advAD)));
        UIKit.addRow(content, "Map Danh Vọng",    tfMapDV      = UIKit.tfDigits(String.valueOf(FormDanhVong.advAE)));
        UIKit.addRow(content, "Khu Danh Vọng",    tfKhuDV      = UIKit.tfDigits(String.valueOf(FormDanhVong.advAF)));
        UIKit.addRow(content, "Map LTD (nv quái)", tfMapLTD    = UIKit.tfDigits(String.valueOf(FormDanhVong.advAJ)));

        UIKit.addRow(content, "Auto mua đồ",
                sbAutoMuaDo = UIKit.selectBox(
                        new String[]{"Ko tự mua", "Dưới 4X", "Dưới 5X", "Dưới 6X", "Dưới 7X", "Mua tất cả"},
                        FormDanhVong.advAN));

        UIKit.addRow(content, "NV nâng cấp TB",
                sbNVNangCap = UIKit.selectBox(
                        new String[]{"Hủy nhiệm vụ", "Dừng auto", "Nhận và làm"},
                        FormDanhVong.advAK));

        UIKit.addRow(content, "Nâng cấp max",     tfMaxNangCap = UIKit.tfDigits(String.valueOf(FormDanhVong.advAL)));
        UIKit.addRow(content, "Chỉ đập đồ + <=",  tfChiDap     = UIKit.tfDigits(String.valueOf(FormDanhVong.advAM)));

        UIKit.addRow(content, "Nếu thiếu item",
                sbThieuItem = UIKit.selectBox(
                        new String[]{"Dừng auto", "Hủy nhiệm vụ"},
                        FormDanhVong.advAO));

        UIKit.addRow(content, "NV đánh quái",
                sbNVDanhQuai = UIKit.selectBox(
                        new String[]{"Bỏ qua boss", "Bem hết"},
                        FormDanhVong.advAP));

        cbHuyTA = UIKit.cb("Hủy nv đánh TA", FormDanhVong.advAS);
        UIKit.addFullRow(content, cbHuyTA).padTop(4f);
        cbHuyTL = UIKit.cb("Hủy nv đánh TL", FormDanhVong.advAT);
        UIKit.addFullRow(content, cbHuyTL);
        cbHuyLoiDai = UIKit.cb("Hủy nv lôi đài", FormDanhVong.huyNvLoiDai);
        UIKit.addFullRow(content, cbHuyLoiDai);

        UIKit.addRow(content, "DV Phụ (0-6)",     tfDVPhu = UIKit.tfDigits(String.valueOf(FormDanhVong.advAR)));

        cbAccPhuLogout = UIKit.cb("Acc phụ thua LD: tự thoát", FormDanhVong.advAQ);
        UIKit.addFullRow(content, cbAccPhuLogout).padTop(4f);

        // Auto cất đồ luôn ON (ẩn UI theo yêu cầu user)
        Code.advCA = true;

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
            FormDanhVong.isADanhVong = cbEnable.isChecked();
            FormDanhVong.advAB = tfDoiThu.getText().trim();
            FormDanhVong.advAC = Integer.parseInt(tfMapLD.getText());
            FormDanhVong.advAD = Integer.parseInt(tfKhuLD.getText());
            FormDanhVong.advAE = Integer.parseInt(tfMapDV.getText());
            FormDanhVong.advAF = Integer.parseInt(tfKhuDV.getText());
            FormDanhVong.advAG = Integer.parseInt(tfXuCuoc.getText());
            FormDanhVong.advAH = Integer.parseInt(tfGioAuto.getText());
            FormDanhVong.advAI = Integer.parseInt(tfPhutAuto.getText());
            FormDanhVong.advAJ = Short.parseShort(tfMapLTD.getText());
            FormDanhVong.advAN = (byte) sbAutoMuaDo.getSelectedIndex();
            FormDanhVong.advAK = (byte) sbNVNangCap.getSelectedIndex();
            FormDanhVong.advAL = Byte.parseByte(tfMaxNangCap.getText());
            FormDanhVong.advAM = Integer.parseInt(tfChiDap.getText());
            FormDanhVong.advAO = (byte) sbThieuItem.getSelectedIndex();
            FormDanhVong.advAP = (byte) sbNVDanhQuai.getSelectedIndex();
            FormDanhVong.advAS = cbHuyTA.isChecked();
            FormDanhVong.advAT = cbHuyTL.isChecked();
            FormDanhVong.huyNvLoiDai = cbHuyLoiDai.isChecked();
            FormDanhVong.advAR = Byte.parseByte(tfDVPhu.getText());
            FormDanhVong.advAQ = cbAccPhuLogout.isChecked();

            if (FormDanhVong.advAR > 6) FormDanhVong.advAR = 6;

            Code.advCA = true;
            RMS.a("saveItem", 1);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(FormDanhVong.advAB);
            dos.writeInt(FormDanhVong.advAC);
            dos.writeInt(FormDanhVong.advAD);
            dos.writeInt(FormDanhVong.advAE);
            dos.writeInt(FormDanhVong.advAF);
            dos.writeInt(FormDanhVong.advAG);
            dos.writeInt(FormDanhVong.advAH);
            dos.writeInt(FormDanhVong.advAI);
            dos.writeBoolean(FormDanhVong.isADanhVong);
            dos.writeShort(FormDanhVong.advAJ);
            dos.writeByte(FormDanhVong.advAN);
            dos.writeByte(FormDanhVong.advAK);
            dos.writeByte(FormDanhVong.advAL);
            dos.writeByte(FormDanhVong.advAO);
            dos.writeInt(FormDanhVong.advAM);
            dos.writeByte(FormDanhVong.advAP);
            dos.writeBoolean(FormDanhVong.advAQ);
            dos.writeByte(FormDanhVong.advAR);
            dos.writeBoolean(FormDanhVong.advAS);
            dos.writeBoolean(FormDanhVong.advAT);
            dos.writeBoolean(FormDanhVong.huyNvLoiDai);
            RMS.saveRMS("chipAutodv", baos.toByteArray());
            dos.close();
            baos.close();

            Code.popup_chat("Lưu cài đặt DV thành công");
            if (DebugLog.DEBUG) DebugLog.log("UI", "SetupDanhVong saved isADV=" + FormDanhVong.isADanhVong
                    + " doithu=" + FormDanhVong.advAB + " time=" + FormDanhVong.advAH + ":" + FormDanhVong.advAI
                    + " advCA=" + Code.advCA);
        } catch (Exception e) {
            Code.popup_chat("Lỗi: kiểm tra lại cài đặt!");
            if (DebugLog.DEBUG) DebugLog.error("SetupDanhVong save failed: " + e.getMessage(), e);
        }
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
        UIKit.logResize("SetupDanhVong", stage, w, h);
    }
    @Override public void show() { isVisible = true; UIKit.mountStage(stage); }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
