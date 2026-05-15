import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

public class UpdateServer {

    public static int[] listPort;
    public static String[] listIP;
    public static int[] serverST;
    public static String[] listName;
    public static byte[] serverLoginList;
    public static String fakeip;
    public static String realurl;
    private static boolean isInit = false;

    // Danh sach server duoc tool "CuongNSO Version Manager" ghi truoc moi lan build.
    // Format: Name:IP:Port:LoginType:Lang,Name2:IP2:Port2:...
    private static final String SERVER_LIST = "HacAnh:cc2.hacanhninja.com:14444:0:0,Local:127.0.0.1:0:0:0";

    public static void initMidlet(GameMidlet midlet) {
        if (isInit) {
            return;
        }
        isInit = true;
        Session_ME.gameAA().gameAD = Controller.gameAD();
        UpdateServer.a();
        GameMidlet.clientAgent = readFile("agent.txt");
        GameMidlet.userProvider = Byte.parseByte(readFile("provider.txt"));
        System.out.println("AGENT: " + GameMidlet.clientAgent + ", PROVIDER: " + GameMidlet.userProvider);
        SplashScr.splashScrStat = 0;
        GameCanvas.currentScreen = new SplashScr();
        MotherCanvas.gI().gameAB = GameCanvas.gameAB();
        if (!MotherCanvas.gameAC) {
            (new Thread(MotherCanvas.gI())).start();
        }
    }

    public static void platformRequest(String url) {
        if (url == null || url.length() <= 0) {
            return;
        }
        try {
            GameMidlet.instance.platformRequest(url);
            GameMidlet.instance.notifyDestroyed();
        } catch (Exception e) {
        }
    }

    public static String readFile(String name) {
        InputStream is = RMS.gameAA("/" + name);
        try {
            byte[] data = new byte[is.available()];
            is.read(data);
            return new String(data, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(String s) {
        StringBuffer result = new StringBuffer();
        HttpConnection httpConnection = null;
        InputStream openInputStream = null;
        InputStreamReader reader = null;

        try {
            httpConnection = (HttpConnection) Connector.open(s);
            int responseCode = httpConnection.getResponseCode();
            System.out.println("[UpdateServer] HTTP " + responseCode + " " + s);

            // Handle redirects (301 / 302) — GitHub raw URLs may redirect to CDN
            if (responseCode == HttpConnection.HTTP_MOVED_PERM
                    || responseCode == HttpConnection.HTTP_MOVED_TEMP) {
                String newUrl = httpConnection.getHeaderField("Location");
                httpConnection.close();
                System.out.println("[UpdateServer] Redirect -> " + newUrl);
                httpConnection = (HttpConnection) Connector.open(newUrl);
                responseCode = httpConnection.getResponseCode();
                System.out.println("[UpdateServer] HTTP (after redirect) " + responseCode);
                if (responseCode != 200) {
                    throw new IOException("Redirect target status: " + responseCode);
                }
            } else if (responseCode != 200) {
                throw new IOException("HTTP " + responseCode + " "
                    + httpConnection.getResponseMessage());
            }

            openInputStream = httpConnection.openInputStream();
            reader = new InputStreamReader(openInputStream, "UTF-8");

            int read;
            char[] buffer = new char[256];
            while ((read = reader.read(buffer)) != -1) {
                result.append(buffer, 0, read);
            }
        } catch (Exception ex) {
            System.out.println("[UpdateServer] Fetch error: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (openInputStream != null)
                    openInputStream.close();
                if (httpConnection != null)
                    httpConnection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }

    public static boolean a() {
        String[] stringArray = UpdateServer.a(SERVER_LIST.trim(), ",", 0);
        UpdateServer.listName = new String[stringArray.length];
        UpdateServer.listIP = new String[stringArray.length];
        UpdateServer.listPort = new int[stringArray.length];
        UpdateServer.serverLoginList = new byte[stringArray.length];
        UpdateServer.serverST = new int[stringArray.length];
        int n = 0;
        while (n < stringArray.length) {
            String[] stringArray2 = UpdateServer.a(stringArray[n].trim(), ":", 0);
            UpdateServer.listName[n] = stringArray2[0];
            UpdateServer.listIP[n] = stringArray2[1];
            UpdateServer.listPort[n] = Integer.parseInt(stringArray2[2]);
            UpdateServer.serverLoginList[n] = Byte.parseByte(stringArray2[3]);
            UpdateServer.serverST[n] = n;
            ++n;
        }
        UpdateServer.c();
        return true;
    }

    public static boolean b1() {
        String[] var5 = a(fakeip.trim(), ",", 0);
        UpdateServer.listName = new String[var5.length];
        UpdateServer.listIP = new String[var5.length];
        UpdateServer.listPort = new int[var5.length];
        UpdateServer.serverLoginList = new byte[var5.length];
        UpdateServer.serverST = new int[var5.length];

        for (int var6 = 0; var6 < var5.length; ++var6) {
            String[] var2 = a(var5[var6].trim(), ":", 0);
            UpdateServer.listName[var6] = var2[0];
            UpdateServer.listIP[var6] = var2[1];
            UpdateServer.listPort[var6] = Integer.parseInt(var2[2]);
            UpdateServer.serverLoginList[var6] = Byte.parseByte(var2[3]);
            UpdateServer.serverST[var6] = var6;
        }

        c();
        return true;
    }

    public static void b() {
        try {
            ByteArrayInputStream var0 = new ByteArrayInputStream(RMS.gameAB("abcdip"));
            DataInputStream var1 = new DataInputStream(var0);
            if (var0.available() > 0) {
                int var7 = var1.readInt();
                UpdateServer.listName = new String[var7];
                UpdateServer.listIP = new String[var7];
                UpdateServer.listPort = new int[var7];
                UpdateServer.serverLoginList = new byte[var7];
                UpdateServer.serverST = new int[var7];

                for (int var3 = 0; var3 < var7; ++var3) {
                    UpdateServer.listName[var3] = var1.readUTF();
                    UpdateServer.listIP[var3] = var1.readUTF();
                    UpdateServer.listPort[var3] = var1.readInt();
                    UpdateServer.serverLoginList[var3] = var1.readByte();
                    UpdateServer.serverST[var3] = var3;
                }

                var0.close();
                var1.close();
                return;
            }
        } catch (Exception var4) {
        }

        String[] var5 = a(fakeip.trim(), ",", 0);
        UpdateServer.listName = new String[var5.length];
        UpdateServer.listIP = new String[var5.length];
        UpdateServer.listPort = new int[var5.length];
        UpdateServer.serverLoginList = new byte[var5.length];
        UpdateServer.serverST = new int[var5.length];

        for (int var6 = 0; var6 < var5.length; ++var6) {
            String[] var2 = a(var5[var6].trim(), ":", 0);
            UpdateServer.listName[var6] = var2[0];
            UpdateServer.listIP[var6] = var2[1];
            UpdateServer.listPort[var6] = Integer.parseInt(var2[2]);
            UpdateServer.serverLoginList[var6] = Byte.parseByte(var2[3]);
            UpdateServer.serverST[var6] = var6;
        }

        c();
    }

    public static String[] a(String string, String string2, int n) {
        String[] stringArray;
        int n2 = string.indexOf(string2);
        if (n2 >= 0) {
            stringArray = UpdateServer.a(string.substring(n2 + string2.length()), string2, n + 1);
        } else {
            stringArray = new String[n + 1];
            n2 = string.length();
        }
        stringArray[n] = string.substring(0, n2);
        return stringArray;
    }

    public static void c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            int n = UpdateServer.listIP.length;
            dataOutputStream.writeInt(n);
            int n2 = 0;
            while (n2 < n) {
                dataOutputStream.writeUTF(UpdateServer.listName[n2]);
                dataOutputStream.writeUTF(UpdateServer.listIP[n2]);
                dataOutputStream.writeInt(UpdateServer.listPort[n2]);
                dataOutputStream.writeByte(UpdateServer.serverLoginList[n2]);
                ++n2;
            }
            dataOutputStream.flush();
            byteArrayOutputStream.flush();
            RMS.gameAA("abcdip", byteArrayOutputStream.toByteArray());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static {
        fakeip = "SGFjQW5oOmNjMS5oYWNhY2huaW5qYS5jb206MTQ0NDQ6MDow";
        realurl = "SGFjQW5oOjE1Ny42Ni44MC4yMDM6MTQ0NDQ6MDow";
    }
}
