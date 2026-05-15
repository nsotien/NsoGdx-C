package base.game2;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ModelVxmm {
    private static MyVector players;

    private static void SaveList() {
        ByteArrayOutputStream var0 = new ByteArrayOutputStream();
        DataOutputStream var1 = new DataOutputStream(var0);

        try {
            var1.writeInt(players.size());

            for (int var2 = 0; var2 < players.size(); ++var2) {
                var1.writeUTF((String) players.elementAt(var2));
            }

            var1.flush();
            var0.flush();
            RMS.a("VXMMLIST", var0.toByteArray());
        } catch (Exception var3) {
            ;
        }
    }

    public static MyVector GetPlayer() {
        MyVector var0 = new MyVector();

        for (int var1 = 0; var1 < players.size(); ++var1) {
            int var3;
            String var2 = (var3 = (var2 = (String) players.elementAt(var1)).indexOf(":")) >= 0 ? var2.substring(0, var3) : var2;
            var0.addElement(var1 + 1 + ". " + var2);
        }

        return var0;
    }

    public static void savePlayer(String var0, int var1) {
        CheckPlayer(var0);
        players.addElement(var0 + ":" + var1);
        SaveList();
    }

    public static void CheckPlayer(String var0) {
        for (int var1 = 0; var1 < players.size(); ++var1) {
            String var2;
            if ((var2 = (String) players.elementAt(var1)).startsWith(var0 + ":") || var2.equals(var0)) {
                players.removeElementAt(var1);
                SaveList();
                return;
            }
        }

    }

    public static void RemoveAllPlayer() {
        players.removeAllElements();
        SaveList();
    }

    public static int getSeconds(String var0) {
        for (int var1 = 0; var1 < players.size(); ++var1) {
            String var2;
            int var3;
            if ((var2 = (String) players.elementAt(var1)).startsWith(var0 + ":") && (var3 = var2.indexOf(":")) >= 0 && var3 < var2.length() - 1) {
                try {
                    return Integer.parseInt(var2.substring(var3 + 1));
                } catch (Exception var4) {
                    return 120;
                }
            }
        }

        return 120;
    }

    static {
        (players = new MyVector()).removeAllElements();

        try {
            byte[] vxmmlists = RMS.a("VXMMLIST");
            if (vxmmlists != null) {
                ByteArrayInputStream var0 = new ByteArrayInputStream(vxmmlists);
                DataInputStream var1;
                int var2 = (var1 = new DataInputStream(var0)).readInt();

                for (int var3 = 0; var3 < var2; ++var3) {
                    players.addElement(var1.readUTF());
                }

                var1.close();
                var0.close();
            }

        } catch (Exception var4) {
            ;
        }
    }

}
