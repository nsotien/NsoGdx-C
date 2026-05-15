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

import base.game1.Controller;
import base.game1.DebugLog;
import base.game1.RMS;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;

public final class ListGroup implements ScreenChild {

    public static String packageName = "list";
    private static Vector<String> k = new Vector<String>();

    private final Stage stage;
    private Window panel;
    private TextField tfUser;
    private Table listTable;
    private ScrollPane scroll;

    public boolean isVisible = false;

    public static ListGroup abc;
    public static ListGroup gI() { if (abc == null) abc = new ListGroup(); return abc; }

    public ListGroup() {
        stage = UIKit.newStage();
        loadDataBlock();
        build();
        if (DebugLog.DEBUG) DebugLog.log("UI", "ListGroup created size=" + k.size());
    }

    private void build() {
        panel = UIKit.panel("Danh sách ưu tiên");
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
        for (int i = 0; i < k.size(); i++) {
            if (k.elementAt(i).equalsIgnoreCase(name)) {
                tfUser.setText("");
                return;
            }
        }
        k.addElement(name);
        saveDataBlock();
        tfUser.setText("");
        rebuildList();
        if (DebugLog.DEBUG) DebugLog.log("UI", "ListGroup add '" + name + "' size=" + k.size());
    }

    private void rebuildList() {
        listTable.clear();
        for (int i = 0; i < k.size(); i++) {
            final int index = i;
            String name = k.elementAt(i);
            UIKit.addListRow(listTable, name, new Runnable() {
                @Override public void run() {
                    if (index >= 0 && index < k.size()) {
                        k.removeElementAt(index);
                        saveDataBlock();
                        rebuildList();
                        if (DebugLog.DEBUG) DebugLog.log("UI", "ListGroup remove idx=" + index + " size=" + k.size());
                    }
                }
            });
        }
        listTable.invalidateHierarchy();
        scroll.layout();
    }

    public void saveDataBlock() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(k.size());
            for (int i = 0; i < k.size(); i++) dos.writeUTF(k.elementAt(i));
            RMS.a("grList", baos.toByteArray());
            baos.close();
            dos.close();
        } catch (Exception e) {
            if (DebugLog.DEBUG) DebugLog.error("ListGroup save failed: " + e.getMessage(), e);
        }
    }

    private void loadDataBlock() {
        try {
            byte[] data = RMS.a("grList");
            if (data != null) {
                DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
                int count = dis.readInt();
                for (int i = 0; i < count; i++) k.addElement(dis.readUTF());
                dis.close();
            }
        } catch (Exception ex) {
            if (DebugLog.DEBUG) DebugLog.error("ListGroup load failed: " + ex.getMessage(), ex);
        }
    }

    /** Kiểm tra nick có trong group list không. Giữ nguyên API cũ (Controller gọi). */
    public static boolean a(String var0) {
        return k.contains(Controller.fix_vip(var0));
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
        UIKit.logResize("ListGroup", stage, w, h);
    }
    @Override public void show() { isVisible = true; rebuildList(); UIKit.mountStage(stage); }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
