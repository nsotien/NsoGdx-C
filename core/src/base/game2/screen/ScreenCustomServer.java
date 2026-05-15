package base.game2.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import base.game2.CustomServerStore;
import base.game2.GameMidlet;
import base.game2.RMS;
import base.game2.SelectServerScr;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class ScreenCustomServer implements ScreenChild {

    private final Stage stage;
    private Window panel;
    private Table listTable;
    private ScrollPane scroll;

    private int selectedIndex = -1;
    public boolean isVisible = false;

    public ScreenCustomServer() {
        stage = UIKit.newStage();
        build();
    }

    private void build() {
        panel = UIKit.panel("Server Tự Thêm");
        panel.defaults().pad(UIKit.ROW_PAD);

        listTable = new Table();
        listTable.top().left();
        scroll = UIKit.wrapScroll(listTable);
        panel.add(scroll).colspan(3).expandX().fillX()
                .minWidth(UIKit.LIST_MIN_W)
                .prefHeight(UIKit.LIST_PREF_H)
                .minHeight(UIKit.LIST_MIN_H)
                .padBottom(8f);
        panel.row();

        Table buttons = new Table();
        TextButton btnThem  = UIKit.btnGold("Thêm");
        TextButton btnXoa   = UIKit.btnWood("Xóa");
        TextButton btnThoat = UIKit.btnWood("Thoát");

        float p = 6f;
        buttons.add(btnThem).padRight(p).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(btnXoa).padRight(p).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(btnThoat).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(3).padTop(6f).center();

        btnThem.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { showAddDialog(); }
        });
        btnXoa.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                if (selectedIndex >= 0 && selectedIndex < CustomServerStore.entries.size()) {
                    CustomServerStore.remove(selectedIndex);
                    selectedIndex = -1;
                    rebuildArrays();
                    refreshList();
                }
            }
        });
        btnThoat.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    private void refreshList() {
        listTable.clearChildren();
        CustomServerStore.load();
        if (CustomServerStore.entries.size() == 0) {
            listTable.add(UIKit.label("(Chưa có server tự thêm)")).padLeft(8f).left();
            return;
        }
        for (int i = 0; i < CustomServerStore.entries.size(); i++) {
            final int idx = i;
            String[] e = (String[]) CustomServerStore.entries.elementAt(i);
            String name = (e[0] == null || e[0].length() == 0) ? "(no name)" : e[0];
            String display = name + "  " + e[1] + ":" + e[2];
            final TextButton row = (i == selectedIndex) ? UIKit.btnGold(display) : UIKit.btnWood(display);
            row.getLabel().setAlignment(com.badlogic.gdx.utils.Align.left);
            row.pad(0f, 16f, 0f, 12f);
            row.addListener(new ChangeListener() {
                @Override public void changed(ChangeEvent ev, Actor a) {
                    selectedIndex = idx;
                    refreshList();
                }
            });
            listTable.add(row).growX().height(UIKit.BTN_H).padBottom(4f).row();
        }
    }

    private void showAddDialog() {
        final TextField tfName = UIKit.tfText("");
        final TextField tfIp   = UIKit.tfText("");
        final TextField tfPort = UIKit.tfDigits("");

        final Window dlg = UIKit.panel("Thêm Server");
        dlg.defaults().pad(UIKit.ROW_PAD);
        UIKit.addRow(dlg, "Tên:", tfName);
        UIKit.addRow(dlg, "IP:", tfIp);
        UIKit.addRow(dlg, "Port:", tfPort);

        Table btns = new Table();
        TextButton btnLuu = UIKit.btnGold("Lưu");
        TextButton btnHuy = UIKit.btnWood("Hủy");
        btns.add(btnLuu).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        btns.add(btnHuy).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        dlg.add(btns).colspan(2).padTop(10f).center();

        btnLuu.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                String ip   = tfIp.getText().trim();
                String port = tfPort.getText().trim();
                if (ip.length() > 0 && port.length() > 0) {
                    String name = tfName.getText().trim();
                    CustomServerStore.add(name, ip, port);
                    rebuildArrays();
                    refreshList();
                    dlg.remove();
                }
            }
        });
        btnHuy.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { dlg.remove(); }
        });

        stage.addActor(dlg);
        UIKit.layoutPanel(stage, dlg);
    }

    private void rebuildArrays() {
        try {
            byte[] data = RMS.a("NJlink");
            if (data != null && data.length > 0) {
                DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
                int len = dis.readByte() & 0xff;
                GameMidlet.l        = new String[len];
                GameMidlet.m        = new String[len];
                GameMidlet.n        = new short[len];
                GameMidlet.o        = new byte[len];
                GameMidlet.q        = new int[len];
                GameMidlet.language = new byte[len];
                for (int i = 0; i < len; i++) {
                    GameMidlet.l[i] = dis.readUTF();
                    GameMidlet.m[i] = dis.readUTF();
                    GameMidlet.n[i] = dis.readShort();
                    GameMidlet.o[i] = dis.readByte();
                    GameMidlet.q[i] = dis.readInt();
                    dis.readByte();
                    GameMidlet.language[i] = 0;
                }
                dis.close();
            }
        } catch (Exception ex) { /* keep existing arrays */ }
        CustomServerStore.merge();
        SelectServerScr.f();
    }

    @Override public void show() {
        isVisible = true;
        selectedIndex = -1;
        refreshList();
        UIKit.layoutPanel(stage, panel);
        UIKit.mountStage(stage);
    }

    @Override public void hide() {
        isVisible = false;
        UIKit.restoreInput();
    }

    @Override public void render() {
        if (!isVisible) return;
        stage.act(com.badlogic.gdx.Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
    }

    @Override public boolean isVisible() { return isVisible; }
}
