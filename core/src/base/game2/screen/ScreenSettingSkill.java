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

import base.game2.Auto;
import base.game2.Char;
import base.game2.Code;
import base.game2.GameScr;
import base.game2.RMS;
import base.game2.Skill;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ScreenSettingSkill implements ScreenChild {

    public static int[] skillIds = {-1, -1, -1, -1, -1};

    private final Stage stage;
    private final TextField[] fields = new TextField[5];
    private Window panel;

    public boolean isVisible = false;

    public ScreenSettingSkill() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài Đặt Skill");
        panel.defaults().pad(UIKit.ROW_PAD);

        for (int i = 0; i < 5; i++) {
            fields[i] = UIKit.tfDigits(String.valueOf(skillIds[i]));
            UIKit.addRow(panel, "ID Skill " + (i + 1) + ":", fields[i]);
        }

        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(10f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { saveFromUI(); hide(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    private void saveFromUI() {
        for (int i = 0; i < 5; i++) {
            try {
                skillIds[i] = Integer.parseInt(fields[i].getText().trim());
            } catch (Exception e) {
                skillIds[i] = -1;
            }
        }
        saveSettings();
        Code.popup_chat("Lưu cài đặt skill thành công");
    }

    public static void loadSettings() {
        byte[] data = RMS.a("settingSkill");
        if (data == null) return;
        try {
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
            for (int i = 0; i < 5; i++) skillIds[i] = dis.readInt();
            dis.close();
        } catch (Exception e) {
            // [FIX 14] log lỗi để debug khi RMS corrupt sau bảo trì
            Code.popup_chat("Loi load skill setting: " + e.getMessage());
        }
    }

    public static void saveSettings() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            for (int i = 0; i < 5; i++) dos.writeInt(skillIds[i]);
            dos.flush();
            RMS.a("settingSkill", bos.toByteArray());
        } catch (Exception e) {
            // ignore
        }
    }

    public static void applyConfiguredSkills() {
        Char my = Char.getMyChar();
        if (my == null || my.vSkillFight == null) return;

        for (int i = 0; i < skillIds.length; i++) {
            int sid = skillIds[i];
            if (sid == -1) continue;
            Skill skill = my.findSkillById(sid);
            if (skill == null) continue;
            Skill current = GameScr.getFightSkillShortcut(i);
            if (current == null || current.template.id != sid) {
                Object[] args = new Object[2];
                args[0] = skill;
                args[1] = String.valueOf(i);
                GameScr.gI().b(11120, args);
            }
            if (i == 0 && (my.myskill == null || my.myskill.template.id != sid || Auto.my_skill == null || Auto.my_skill.template.id != sid)) {
                my.myskill = skill;
                my.fk = skill;
                Auto.my_skill = skill;
                Auto.fix_skill = skill;
            }
        }
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
    }
    @Override public void show() {
        isVisible = true;
        for (int i = 0; i < 5; i++) fields[i].setText(String.valueOf(skillIds[i]));
        UIKit.mountStage(stage);
    }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
