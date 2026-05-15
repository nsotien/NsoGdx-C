package base.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Lưu danh sách server tự thêm vào 1 file DÙNG CHUNG giữa game1 và game2.
 * Path: Nso/SharedCustomServers (nằm ngoài thư mục Monkey.game1/Monkey.game2)
 * → cả 2 tab đọc/ghi cùng 1 file → thêm ở tab nào cũng ăn cả 2.
 *
 * Format file: mỗi entry 1 dòng "name|ip|port", phân tách "\n".
 * KHÔNG đụng RMS "NJlink" (worker list, license guard hash trên đó).
 *
 * Pipeline load:
 *   Worker trả -> Client.fakeStart() parse vào GameMidlet.l/m/n/o
 *   -> GameMidlet.g() ghi RMS "NJlink"
 *   -> CustomServerStore.load() + merge()  ← hook ngay trước SelectServerScr.f() trong g()
 *   -> SelectServerScr.f() reload UI
 */
public final class CustomServerStore {

    private static final String SHARED_PATH = "Nso/SharedCustomServers";

    private CustomServerStore() {}

    /** Danh sách custom entries: mỗi phần tử là String[3] {name, ip, port} */
    public static MyVector entries = new MyVector();

    // ------------------------------------------------------------------ load/save

    public static void load() {
        entries.removeAllElements();
        try {
            FileHandle f = Gdx.files.external(SHARED_PATH);
            if (!f.exists()) return;
            String data = f.readString("UTF-8");
            if (data == null || data.length() == 0) return;
            String[] lines = splitStr(data, "\n");
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i].trim();
                if (line.length() == 0) continue;
                String[] parts = splitStr(line, "|");
                if (parts.length >= 3 && parts[0].length() > 0 && parts[1].length() > 0) {
                    entries.addElement(new String[]{parts[0], parts[1], parts[2]});
                }
            }
        } catch (Exception e) { /* ignore */ }
    }

    public static void save() {
        try {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < entries.size(); i++) {
                String[] e = (String[]) entries.elementAt(i);
                if (i > 0) sb.append("\n");
                sb.append(e[0]).append("|").append(e[1]).append("|").append(e[2]);
            }
            Gdx.files.external(SHARED_PATH).writeString(sb.toString(), false, "UTF-8");
        } catch (Exception e) { /* ignore */ }
    }

    public static void add(String name, String ip, String port) {
        entries.addElement(new String[]{name, ip, port});
        save();
    }

    public static void remove(int idx) {
        if (idx >= 0 && idx < entries.size()) {
            entries.removeElementAt(idx);
            save();
        }
    }

    // ------------------------------------------------------------------ merge

    /**
     * Append custom servers vào cuối GameMidlet.l/m/n/o/q/language (chỉ in-memory).
     * GỌI SAU GameMidlet ghi RMS "NJlink" — custom KHÔNG bao giờ vào NJlink.
     */
    public static void merge() {
        if (entries.size() == 0) return;
        if (GameMidlet.l == null) return;

        int oldLen = GameMidlet.l.length;
        int addLen = entries.size();
        int newLen = oldLen + addLen;

        String[] newL    = new String[newLen];
        String[] newM    = new String[newLen];
        short[]  newN    = new short[newLen];
        byte[]   newO    = new byte[newLen];
        int[]    newQ    = new int[newLen];
        byte[]   newLang = new byte[newLen];

        for (int i = 0; i < oldLen; i++) {
            newL[i]    = GameMidlet.l[i];
            newM[i]    = GameMidlet.m[i];
            newN[i]    = GameMidlet.n[i];
            newO[i]    = GameMidlet.o[i];
            newQ[i]    = GameMidlet.q[i];
            newLang[i] = (GameMidlet.language != null && i < GameMidlet.language.length)
                         ? GameMidlet.language[i] : 0;
        }

        for (int i = 0; i < addLen; i++) {
            String[] e  = (String[]) entries.elementAt(i);
            int idx     = oldLen + i;
            newL[idx]   = e[0];
            newM[idx]   = e[1];
            try { newN[idx] = Short.parseShort(e[2]); } catch (Exception ex) { newN[idx] = 0; }
            newO[idx]    = 0;
            newQ[idx]    = idx;
            newLang[idx] = 0;
        }

        GameMidlet.l        = newL;
        GameMidlet.m        = newM;
        GameMidlet.n        = newN;
        GameMidlet.o        = newO;
        GameMidlet.q        = newQ;
        GameMidlet.language = newLang;
    }

    // ------------------------------------------------------------------ helper

    private static String[] splitStr(String s, String sep) {
        MyVector v = new MyVector();
        int from = 0, idx;
        while ((idx = s.indexOf(sep, from)) != -1) {
            v.addElement(s.substring(from, idx));
            from = idx + sep.length();
        }
        v.addElement(s.substring(from));
        String[] arr = new String[v.size()];
        for (int i = 0; i < v.size(); i++) arr[i] = (String) v.elementAt(i);
        return arr;
    }
}
