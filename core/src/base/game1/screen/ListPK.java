package base.game1.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game1.DebugLog;

public final class ListPK implements ScreenChild {

    private final Stage stage;
    private Window panel;
    private TextField tfUser;
    private Table listTable;
    private ScrollPane scroll;

    public boolean isVisible = false;

    public static ListPK instance = new ListPK();
    public static ListPK gI() { if (instance == null) instance = new ListPK(); return instance; }

    public ListPK() {
        stage = UIKit.newStage();
        build();
        if (DebugLog.DEBUG) DebugLog.log("UI", "ListPK created");
    }

    private void build() {
        panel = UIKit.panel("Danh sách PK");
        panel.defaults().pad(UIKit.ROW_PAD);

        // Input row: TextField + Thêm
        Table inputRow = new Table();
        tfUser = UIKit.tfText("");
        tfUser.setMessageText("username...");
        TextButton btnAdd = UIKit.btnGold("Thêm");
        inputRow.add(tfUser).expandX().fillX().height(UIKit.FIELD_H).padRight(8f);
        inputRow.add(btnAdd).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(inputRow).colspan(2).expandX().fillX().minWidth(UIKit.LIST_MIN_W).padBottom(8f);
        panel.row();

        // List area (scrollable) — prefHeight reserve chỗ dù empty
        listTable = new Table();
        listTable.top().left();
        scroll = UIKit.wrapScroll(listTable);
        panel.add(scroll).colspan(2).expandX().fillX()
                .minWidth(UIKit.LIST_MIN_W)
                .prefHeight(UIKit.LIST_PREF_H)
                .minHeight(UIKit.LIST_MIN_H)
                .padBottom(6f);
        panel.row();

        // Exit button
        Table buttons = new Table();
        TextButton exitBtn = UIKit.btnWood("Thoát");
        buttons.add(exitBtn).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(2).padTop(8f).center();

        btnAdd.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { doAdd(); }
        });
        exitBtn.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
        rebuildList();
    }

    private void doAdd() {
        String name = tfUser.getText().trim();
        if (name.isEmpty()) return;
        for (int i = 0; i < base.game1.ListPK.k.size(); i++) {
            if (((String) base.game1.ListPK.k.elementAt(i)).equalsIgnoreCase(name)) {
                tfUser.setText("");
                return;
            }
        }
        base.game1.ListPK.k.addElement(name);
        base.game1.ListPK.saveList();
        tfUser.setText("");
        rebuildList();
        if (DebugLog.DEBUG) DebugLog.log("UI", "ListPK add '" + name + "' size=" + base.game1.ListPK.k.size());
    }

    private void rebuildList() {
        listTable.clear();
        for (int i = 0; i < base.game1.ListPK.k.size(); i++) {
            final int index = i;
            String name = (String) base.game1.ListPK.k.elementAt(i);
            UIKit.addListRow(listTable, name, new Runnable() {
                @Override public void run() {
                    if (index >= 0 && index < base.game1.ListPK.k.size()) {
                        base.game1.ListPK.k.removeElementAt(index);
                        base.game1.ListPK.saveList();
                        rebuildList();
                        if (DebugLog.DEBUG) DebugLog.log("UI", "ListPK remove idx=" + index + " size=" + base.game1.ListPK.k.size());
                    }
                }
            });
        }
        listTable.invalidateHierarchy();
        scroll.layout();
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
        UIKit.logResize("ListPK", stage, w, h);
    }
    @Override public void show() { isVisible = true; rebuildList(); UIKit.mountStage(stage); }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
