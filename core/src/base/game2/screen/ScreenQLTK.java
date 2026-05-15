package base.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

// QLTK dùng chung data với game1 (theo SOURCE_IOS_V8.md): đọc/ghi base.game1.*
import base.game1.RMS;
import base.game1.GameMidlet;
import base.game1.SelectServerScr;
import base.game2.GameCanvas;
import base.game2.Service;
import base.game2.Session_ME;

import java.util.ArrayList;

public class ScreenQLTK implements ScreenChild {

    private final Stage stage;
    private Window panel;

    private ArrayList<String[]> accounts = new ArrayList<String[]>();
    private int selectedIndex = -1;

    private Table listTable;
    private ScrollPane scroll;

    public boolean isVisible = false;

    public ScreenQLTK() {
        stage = UIKit.newStage();
        build();
        loadAccounts();
        refreshList();
    }

    private void build() {
        panel = UIKit.panel("Quản Lý Tài Khoản");
        panel.defaults().pad(UIKit.ROW_PAD);

        listTable = new Table();
        listTable.top().left();
        scroll = UIKit.wrapScroll(listTable);
        panel.add(scroll).colspan(5).expandX().fillX()
                .minWidth(UIKit.LIST_MIN_W)
                .prefHeight(UIKit.LIST_PREF_H)
                .minHeight(UIKit.LIST_MIN_H)
                .padBottom(8f);
        panel.row();

        Table buttons = new Table();
        TextButton btnThem    = UIKit.btnGold("Thêm");
        TextButton btnSua     = UIKit.btnWood("Sửa");
        TextButton btnXoa     = UIKit.btnWood("Xóa");
        TextButton btnDangNhap= UIKit.btnGold("Đăng nhập");
        TextButton btnThoat   = UIKit.btnWood("Thoát");

        float btnPad = 6f;
        buttons.add(btnThem).padRight(btnPad).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(btnSua).padRight(btnPad).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(btnXoa).padRight(btnPad).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(btnDangNhap).padRight(btnPad).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        buttons.add(btnThoat).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        panel.add(buttons).colspan(5).padTop(6f).center();

        btnThem.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { showAddDialog(); }
        });
        btnSua.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                if (selectedIndex >= 0 && selectedIndex < accounts.size()) showEditDialog(selectedIndex);
            }
        });
        btnXoa.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                if (selectedIndex >= 0 && selectedIndex < accounts.size()) showDeleteConfirm(selectedIndex);
            }
        });
        btnDangNhap.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { selectAccount(selectedIndex); }
        });
        btnThoat.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { hide(); }
        });

        stage.addActor(panel);
        UIKit.layoutPanel(stage, panel);
    }

    private String[] getServerList() {
        if (GameMidlet.l == null || GameMidlet.l.length == 0) return new String[]{"Default"};
        return GameMidlet.l;
    }

    private SelectBox<String> createServerSelect(String selected) {
        String[] servers = getServerList();
        int selectIdx = 0;
        for (int i = 0; i < servers.length; i++) {
            if (servers[i].equals(selected)) { selectIdx = i; break; }
        }
        return UIKit.selectBox(servers, selectIdx);
    }

    private void loadAccounts() {
        accounts.clear();
        String data = RMS.b("qltk_data");
        if (data == null || data.isEmpty()) return;
        String[] lines = data.split("\n");
        if (lines.length >= 3 && lines.length % 3 == 0) {
            for (int i = 0; i + 2 < lines.length; i += 3) {
                accounts.add(new String[]{lines[i], lines[i + 1], lines[i + 2]});
            }
        } else {
            String defaultServer = (GameMidlet.l != null && GameMidlet.l.length > 0) ? GameMidlet.l[0] : "Default";
            for (int i = 0; i + 1 < lines.length; i += 2) {
                accounts.add(new String[]{lines[i], lines[i + 1], defaultServer});
            }
            saveAccounts();
        }
        if (!accounts.isEmpty() && selectedIndex < 0) selectedIndex = 0;
    }

    private void saveAccounts() {
        StringBuilder sb = new StringBuilder();
        for (String[] acc : accounts) {
            sb.append(acc[0]).append("\n").append(acc[1]).append("\n")
              .append(acc.length > 2 ? acc[2] : "").append("\n");
        }
        RMS.a("qltk_data", sb.toString());
    }

    private void refreshList() {
        listTable.clear();
        if (accounts.isEmpty()) {
            listTable.add(UIKit.label("Chưa có tài khoản nào")).pad(16f);
            return;
        }
        for (int i = 0; i < accounts.size(); i++) {
            final int idx = i;
            String[] acc = accounts.get(i);
            String serverInfo = acc.length > 2 ? acc[2] : "";
            String labelText = (i + 1) + " - " + acc[0] + " [" + serverInfo + "]";
            final TextButton row = (i == selectedIndex) ? UIKit.btnGold(labelText) : UIKit.btnWood(labelText);
            // Align text trái + padding để row "thẳng hàng từ đầu", không center
            row.getLabel().setAlignment(com.badlogic.gdx.utils.Align.left);
            row.pad(0f, 16f, 0f, 12f);
            row.addListener(new ChangeListener() {
                @Override public void changed(ChangeEvent e, Actor a) {
                    selectedIndex = idx;
                    refreshList();
                }
            });
            listTable.add(row).growX().height(UIKit.BTN_H).padBottom(4f).row();
        }
    }

    private void showAddDialog() {
        String currentServer = RMS.b("serverName");
        if (currentServer == null || currentServer.isEmpty()) {
            currentServer = (GameMidlet.l != null && GameMidlet.l.length > 0) ? GameMidlet.l[0] : "Default";
        }
        showAccountDialog("Thêm tài khoản", "", "", currentServer, new AccountCallback() {
            @Override public void onConfirm(String u, String p, String s) { addAccount(u, p, s); }
        });
    }

    private void showEditDialog(final int index) {
        String[] acc = accounts.get(index);
        String savedServer = acc.length > 2 ? acc[2] : "";
        showAccountDialog("Sửa tài khoản", acc[0], acc[1], savedServer, new AccountCallback() {
            @Override public void onConfirm(String u, String p, String s) { editAccount(index, u, p, s); }
        });
    }

    private void showAccountDialog(String title, String user, String pass, String server, final AccountCallback cb) {
        final Window dlg = UIKit.panel(title);
        dlg.defaults().pad(UIKit.ROW_PAD);

        final TextField tfUser = UIKit.tfText(user);
        final TextField tfPass = UIKit.tfText(pass);
        // Hiện plain text — user yêu cầu không mask
        final SelectBox<String> sbServer = createServerSelect(server);

        UIKit.addRow(dlg, "Tài khoản", tfUser);
        UIKit.addRow(dlg, "Mật khẩu",  tfPass);
        UIKit.addRow(dlg, "Server",    sbServer);

        Table btns = new Table();
        TextButton btnOk  = UIKit.btnGold("Lưu");
        TextButton btnCancel = UIKit.btnWood("Hủy");
        btns.add(btnOk).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        btns.add(btnCancel).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        dlg.add(btns).colspan(2).padTop(10f).center();

        btnOk.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                String u = tfUser.getText().trim();
                String p = tfPass.getText().trim();
                String s = sbServer.getSelected();
                if (!u.isEmpty() && !p.isEmpty()) {
                    cb.onConfirm(u, p, s);
                    dlg.remove();
                }
            }
        });
        btnCancel.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { dlg.remove(); }
        });

        stage.addActor(dlg);
        UIKit.layoutPanel(stage, dlg);
    }

    private void addAccount(String user, String pass, String server) {
        for (String[] acc : accounts) {
            if (acc[0].equals(user)) {
                acc[1] = pass;
                if (acc.length > 2) acc[2] = server;
                saveAccounts();
                refreshList();
                return;
            }
        }
        accounts.add(new String[]{user, pass, server});
        selectedIndex = accounts.size() - 1;
        saveAccounts();
        refreshList();
    }

    private void editAccount(int index, String user, String pass, String server) {
        accounts.set(index, new String[]{user, pass, server});
        saveAccounts();
        refreshList();
    }

    private void showDeleteConfirm(final int index) {
        String username = accounts.get(index)[0];
        final Window dlg = UIKit.panel("Xóa tài khoản");
        dlg.defaults().pad(UIKit.ROW_PAD);
        UIKit.addFullRow(dlg, UIKit.label("Xóa tài khoản \"" + username + "\" ?")).padBottom(8f);

        Table btns = new Table();
        TextButton btnDel = UIKit.btnGold("Xóa");
        TextButton btnCancel = UIKit.btnWood("Hủy");
        btns.add(btnDel).padRight(12f).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        btns.add(btnCancel).minWidth(UIKit.BTN_MIN_W).height(UIKit.BTN_H);
        dlg.add(btns).colspan(2).padTop(6f).center();

        btnDel.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) {
                removeAccount(index);
                dlg.remove();
            }
        });
        btnCancel.addListener(new ChangeListener() {
            @Override public void changed(ChangeEvent e, Actor a) { dlg.remove(); }
        });

        stage.addActor(dlg);
        UIKit.layoutPanel(stage, dlg);
    }

    private void removeAccount(int index) {
        accounts.remove(index);
        if (selectedIndex >= accounts.size()) selectedIndex = accounts.size() - 1;
        saveAccounts();
        refreshList();
    }

    public void selectAccount(int index) {
        if (index < 0 || index >= accounts.size()) return;
        String[] acc = accounts.get(index);
        SelectServerScr.h = acc[0];
        SelectServerScr.i = acc[1];
        SelectServerScr.j = "";
        SelectServerScr.k = "";
        RMS.a("acc",  acc[0]);
        RMS.a("pass", acc[1]);

        if (acc.length > 2 && acc[2] != null && !acc[2].isEmpty()) {
            String serverName = acc[2];
            for (int i = 0; i < GameMidlet.l.length; i++) {
                if (GameMidlet.l[i].equals(serverName)) {
                    SelectServerScr.b(i);
                    break;
                }
            }
        }

        hide();

        // Force close session cũ nếu đang connect → tránh login packet đi sai server
        if (Session_ME.a().f) {
            try { Session_ME.a().c(); } catch (Throwable ignored) {}
        }
        GameCanvas.a(5);
        GameCanvas.k();
        Service.gI().login(acc[0], acc[1], "2.5.1");
    }

    private interface AccountCallback { void onConfirm(String user, String pass, String server); }

    @Override public void resize(int w, int h) {
        stage.getViewport().update(w, h, true);
        UIKit.layoutPanel(stage, panel);
    }
    @Override public void show() {
        isVisible = true;
        loadAccounts();
        refreshList();
        UIKit.mountStage(stage);
    }
    @Override public void hide() { isVisible = false; UIKit.restoreInput(); }
    @Override public void render() { stage.act(Gdx.graphics.getDeltaTime()); stage.draw(); }
    @Override public boolean isVisible() { return isVisible; }
}
