package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.Char;
import base.game2.Code;
import base.game2.MyVector;

/**
 * Popup "Cài đặt Auto nhóm" — Scene2D overlay.
 * 2 role (mời / xin vào) hot-swap panel dưới.
 */
public final class ScreenAutoNhom implements ScreenChild {

    private static final int LEADER_SLOTS = 5;

    // Scroll constraints local — dynamicPanel cuộn trong prefH, button bar giữ cố định dưới
    private static final float DYN_PREF_H = 180f;
    private static final float DYN_MIN_H  = 100f;

    private static ScreenAutoNhom instance;
    public static ScreenAutoNhom gI() {
        if (instance == null) instance = new ScreenAutoNhom();
        return instance;
    }

    private final Stage stage;
    private Window panel;

    private CheckBox cbBat, cbTat;
    private CheckBox cbMoi, cbXin;

    private Table dynamicPanel;
    private Table leaderPanel;
    private final TextField[] leaderFields = new TextField[LEADER_SLOTS];

    private Table memberPanel;
    private TextField tfLeaderName;

    private boolean isVisible = false;

    private ScreenAutoNhom() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Cài đặt Auto nhóm");
        panel.defaults().pad(UIKit.ROW_PAD);

        // UIKit.addFullRow(panel, UIKit.label("PT theo danh sách dưới")).padBottom(2f);
        // UIKit.addFullRow(panel, UIKit.label("(thành viên thì không cần điền)")).padBottom(6f);

        // Radio Bật / Tắt
        cbBat = UIKit.cb("Bật", false);
        cbTat = UIKit.cb("Tắt", false);
        ButtonGroup<CheckBox> bgToggle = new ButtonGroup<CheckBox>(cbBat, cbTat);
        bgToggle.setMinCheckCount(1); bgToggle.setMaxCheckCount(1);
        Table rowToggle = new Table();
        rowToggle.add(cbBat).left().padRight(20f);
        rowToggle.add(cbTat).left();
        UIKit.addFullRow(panel, rowToggle).padBottom(6f);

        // Radio Mời / Xin
        cbMoi = UIKit.cb("Mời thành viên", false);
        cbXin = UIKit.cb("Xin vào nhóm",   false);
        ButtonGroup<CheckBox> bgRole = new ButtonGroup<CheckBox>(cbMoi, cbXin);
        bgRole.setMinCheckCount(1); bgRole.setMaxCheckCount(1);
        Table rowRole = new Table();
        rowRole.add(cbMoi).left().padRight(20f);
        rowRole.add(cbXin).left();
        UIKit.addFullRow(panel, rowRole).padBottom(6f);

        cbMoi.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { if (cbMoi.isChecked()) swapRolePanel(0); }
        });
        cbXin.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { if (cbXin.isChecked()) swapRolePanel(1); }
        });

        // Dynamic panel wrap trong ScrollPane với style ẨN SCROLLBAR (không overlay che text).
        // User scroll bằng drag chuột / touch kéo khi role=Mời có 5 rows.
        buildLeaderPanel();
        buildMemberPanel();

        dynamicPanel = new Table();
        dynamicPanel.top();

        ScrollPane.ScrollPaneStyle invisible = new ScrollPane.ScrollPaneStyle();
        // Tất cả drawable = null → scrollbar không render, không chiếm space.
        ScrollPane dynScroll = new ScrollPane(dynamicPanel, invisible);
        dynScroll.setFadeScrollBars(false);
        dynScroll.setScrollingDisabled(true, false);  // chỉ cuộn dọc
        dynScroll.setOverscroll(false, false);

        // Min width: tối thiểu 560 nếu màn rộng, auto-shrink xuống (NSO.WIDTH - 40) nếu màn hẹp
        // → Android tablet portrait không tràn, iPhone landscape vẫn rộng đẹp.
        float minW = Math.min(560f, Math.max(280f, com.monkey.nso.NSO.WIDTH - 40f));
        panel.add(dynScroll).colspan(2).expandX().fillX()
                .minWidth(minW)
                .prefHeight(DYN_PREF_H)
                .minHeight(DYN_MIN_H)
                .padBottom(6f);
        panel.row();

        // Button bar — colspan 2
        Table buttons = new Table();
        TextButton saveBtn = UIKit.btnGold("Lưu");
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(saveBtn).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(8f).center();

        saveBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { save(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    /** Row label + field width cố định — panel pack nhỏ gọn "size vuông". */
    private static void addRowLocal(Table t, String labelText, TextField tf) {
        t.add(UIKit.label(labelText)).right().padRight(10f).minWidth(150f);
        t.add(tf).left().width(220f).height(UIKit.FIELD_H);
        t.row();
    }

    private void buildLeaderPanel() {
        leaderPanel = new Table();
        leaderPanel.top();
        leaderPanel.pad(0f, 12f, 0f, 8f);
        leaderPanel.defaults().pad(UIKit.ROW_PAD);
        for (int i = 0; i < LEADER_SLOTS; i++) {
            leaderFields[i] = UIKit.tfText("");
            leaderFields[i].setMessageText("Tên thành viên...");
            addRowLocal(leaderPanel, "Thành viên " + (i + 1), leaderFields[i]);
        }
    }

    private void buildMemberPanel() {
        memberPanel = new Table();
        memberPanel.top();
        memberPanel.pad(0f, 12f, 0f, 8f);
        memberPanel.defaults().pad(UIKit.ROW_PAD);
        tfLeaderName = UIKit.tfText("");
        tfLeaderName.setMessageText("Tên trưởng nhóm...");
        addRowLocal(memberPanel, "Tên chủ nhóm", tfLeaderName);
    }

    private void swapRolePanel(int role) {
        dynamicPanel.clear();
        if (role == 0) {
            dynamicPanel.add(leaderPanel).growX().top();
        } else {
            dynamicPanel.add(memberPanel).growX().top();
        }
        dynamicPanel.invalidateHierarchy();
    }

    private static boolean containsCI(MyVector v, String s) {
        for (int i = 0; i < v.size(); i++) {
            if (((String) v.elementAt(i)).equalsIgnoreCase(s)) return true;
        }
        return false;
    }

    private void save() {
        boolean newOn = cbBat.isChecked();
        int newRole = cbMoi.isChecked() ? 0 : 1;

        if (newRole == 0) {
            Char my = Char.getMyChar();
            if (my == null || my.cName == null) {
                Code.popup_chat("Vào game trước khi lưu");
                return;
            }
            Code.ig_lead = my.cName;
            MyVector newList = new MyVector();
            for (int i = 0; i < LEADER_SLOTS; i++) {
                String n = leaderFields[i].getText().trim();
                if (n.length() > 0 && !containsCI(newList, n)) {
                    newList.addElement(n);
                }
            }
            Code.listParty = newList;
        } else {
            String leaderName = tfLeaderName.getText().trim();
            if (leaderName.length() == 0) {
                Code.popup_chat("Chưa nhập tên trưởng nhóm");
                return;
            }
            Code.ig_lead = leaderName;
            Code.listParty.removeAllElements();
        }

        Code.autoPtOn = newOn;
        Code.autoPtRole = newRole;

        Code.saveAutoPt();
        Code.saveGroupData();

        Code.popup_chat("Đã lưu Auto nhóm");
        hide();
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
    }

    @Override public void show() {
        Code.loadAutoPt();
        cbBat.setChecked(Code.autoPtOn);
        cbTat.setChecked(!Code.autoPtOn);
        cbMoi.setChecked(Code.autoPtRole == 0);
        cbXin.setChecked(Code.autoPtRole == 1);
        for (int i = 0; i < LEADER_SLOTS; i++) {
            if (i < Code.listParty.size()) {
                leaderFields[i].setText((String) Code.listParty.elementAt(i));
            } else {
                leaderFields[i].setText("");
            }
        }
        if (Code.autoPtRole == 1 && Code.ig_lead != null) {
            tfLeaderName.setText(Code.ig_lead);
        } else {
            tfLeaderName.setText("");
        }
        swapRolePanel(Code.autoPtRole);
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

    @Override public boolean isVisible() { return isVisible; }
}
