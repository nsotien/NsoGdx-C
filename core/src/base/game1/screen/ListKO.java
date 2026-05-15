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

public final class ListKO implements ScreenChild {

    private final Stage stage;
    private Window panel;
    private TextField tfUser;
    private Table listTable;
    private ScrollPane scroll;

    public boolean isVisible = false;

    public static ListKO instance = new ListKO();
    public static ListKO gI() { if (instance == null) instance = new ListKO(); return instance; }

    public ListKO() {
        stage = UIKit.newStage();
        build();
        if (DebugLog.DEBUG) DebugLog.log("UI", "ListKO created");
    }

    private void build() {
        panel = UIKit.panel("Danh sách không PK");
        panel.defaults().pad(UIKit.ROW_PAD);

        Table inputRow = new Table();
        tfUser = UIKit.tfText("");
        tfUser.setMessageText("username...");
        TextButton btnAdd = UIKit.btnGold("Thêm");
        inputRow.add(tfUser).expandX().fillX().height(UIKit.FIELD_H).padRight(8f);
        inputRow.add(btnAdd).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(inputRow).colspan(2).expandX().fillX().minWidth(UIKit.LIST_MIN_W).padBottom(8f);
        panel.row();

        listTable = new Table();
        listTable.top().left();
        scroll = UIKit.wrapScroll(listTable);
        panel.add(scroll).colspan(2).expandX().fillX()
                .minWidth(UIKit.LIST_MIN_W)
                .prefHeight(UIKit.LIST_PREF_H)
                .minHeight(UIKit.LIST_MIN_H)
                .padBottom(6f);
        panel.row();

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
        for (int i = 0; i < base.game1.ListKO.k.size(); i++) {
            if (((String) base.game1.ListKO.k.elementAt(i)).equalsIgnoreCase(name)) {
                tfUser.setText("");
                return;
            }
        }
        base.game1.ListKO.k.addElement(name);
        base.game1.ListKO.saveList();
        tfUser.setText("");
        rebuildList();
        if (DebugLog.DEBUG) DebugLog.log("UI", "ListKO add '" + name + "' size=" + base.game1.ListKO.k.size());
    }

    private void rebuildList() {
        listTable.clear();
        for (int i = 0; i < base.game1.ListKO.k.size(); i++) {
            final int index = i;
            String name = (String) base.game1.ListKO.k.elementAt(i);
            UIKit.addListRow(listTable, name, new Runnable() {
                @Override public void run() {
                    if (index >= 0 && index < base.game1.ListKO.k.size()) {
                        base.game1.ListKO.k.removeElementAt(index);
                        base.game1.ListKO.saveList();
                        rebuildList();
                        if (DebugLog.DEBUG) DebugLog.log("UI", "ListKO remove idx=" + index + " size=" + base.game1.ListKO.k.size());
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
        UIKit.logResize("ListKO", stage, w, h);
    }
    @Override public void show() { isVisible = true; rebuildList(); UIKit.mountStage(stage); }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
