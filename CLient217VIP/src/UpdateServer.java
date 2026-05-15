import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import java.util.Vector;

public class UpdateServer {

    public static int[] listPort;
    public static String[] listIP;
    public static int[] serverST;
    public static String[] listName;
    public static byte[] serverLoginList;
    public static String m;
    public static String url;
    public static String branding = "NSO217VIP";
    public static String tennguoibuild = "CUONGNSO";
    public static String thongbaochao = "Chao Mung Ban Toi Voi nsoC";

    public static String remainLabel() {
        return new String(new char[]{'C','h','\u00e0','o',' ','m','\u1eeb','n','g',' ','b','\u1ea1','n',' ','\u0111','\u1ebf','n',' ','v','\u1edb','i',' ','N','i','n','j','a',' ','S','c','h','o','o','l'});
    }

    // Ham tai file (ho tro redirect)
    public static String a(String s) {
        StringBuffer result = new StringBuffer();
        HttpConnection httpConnection = null;
        InputStream openInputStream = null;
        InputStreamReader reader = null;

        try {
            httpConnection = (HttpConnection) Connector.open(s);
            int responseCode = httpConnection.getResponseCode();

            if (responseCode == HttpConnection.HTTP_MOVED_PERM || responseCode == HttpConnection.HTTP_MOVED_TEMP) {
                String newUrl = httpConnection.getHeaderField("Location");
                if (httpConnection != null) {
                    httpConnection.close();
                }
                System.out.println("Bi chuyen huong! Dang thu lai tai: " + newUrl);
                httpConnection = (HttpConnection) Connector.open(newUrl);
                if (httpConnection.getResponseCode() != 200) {
                    throw new IOException(httpConnection.getResponseMessage());
                }
            } else if (responseCode != 200) {
                throw new IOException(httpConnection.getResponseMessage());
            }

            openInputStream = httpConnection.openInputStream();
            reader = new InputStreamReader(openInputStream, new String(new char[]{'U', 'T', 'F', '-', '8'}));

            int read;
            char[] buffer = new char[256];
            while ((read = reader.read(buffer)) != -1) {
                result.append(buffer, 0, read);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (httpConnection != null) {
                    httpConnection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    // ===== HAM CHINH: TAI VA PARSE SERVER LIST =====
    public static boolean a() {
        String fileContent = null;
        try {
            // 1. Giai ma URL va tai file modip.txt
            String realUrl = new String(decrypt(url));
            System.out.println("Bat dau tai server list tu: " + realUrl);
            fileContent = UpdateServer.a(realUrl);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Tai file server list THAT BAI!");
        }

        String[] stringArray;

        // 2. Kiem tra ket qua tai file
        if (fileContent == null || fileContent.equals(new String(new char[]{}))) {
            // LOI: Tai file that bai -> Dung list 'm' du phong (Base64)
            System.out.println("Loi! Su dung server list du phong (bien 'm').");
            String string = decrypt(m);
            if (string.equals(new String(new char[]{}))) return false;
            // Tach list du phong bang dau phay ','
            stringArray = UpdateServer.a(string.trim(), new String(new char[]{','}), 0);

        } else {
            // THANH CONG: Tai file thanh cong -> Parse file plain text
            System.out.println("Tai file server list thanh cong! Dang phan tich...");

            // Tach file thanh cac dong (dung ham split, tach bang \n)
            String[] lines = UpdateServer.a(fileContent.trim(), "\n", 0);

            Vector validServerStrings = new Vector();
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i].trim();

                // Bo qua dong trong hoac dong comment (bat dau bang #)
                if (line.length() == 0 || line.startsWith("#")) {
                    continue;
                }

                validServerStrings.addElement(line);
            }

            // Chuyen Vector thanh mang String[]
            stringArray = new String[validServerStrings.size()];
            validServerStrings.copyInto(stringArray);
        }

        // 3. Goi ham parse chung
        return parseServerArray(stringArray);
    }
    // =======================================================

    // ===== PARSE SERVER ARRAY =====
    private static boolean parseServerArray(String[] stringArray) {
        try {
            UpdateServer.listName = new String[stringArray.length];
            UpdateServer.listIP = new String[stringArray.length];
            UpdateServer.listPort = new int[stringArray.length];
            UpdateServer.serverLoginList = new byte[stringArray.length];
            UpdateServer.serverST = new int[stringArray.length];

            System.out.println("Tim thay " + stringArray.length + " server.");

            int n = 0;
            while (n < stringArray.length) {
                // Tach thong tin server bang dau ':'
                String[] stringArray2 = UpdateServer.a(stringArray[n].trim(), new String(new char[]{':'}), 0);

                UpdateServer.listName[n] = stringArray2[0];
                UpdateServer.listIP[n] = stringArray2[1];
                UpdateServer.listPort[n] = Integer.parseInt(stringArray2[2]);
                UpdateServer.serverLoginList[n] = Byte.parseByte(stringArray2[3]);

                UpdateServer.serverST[n] = n;
                ++n;
            }
            UpdateServer.c();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi khi phan tich (parse) server list!");
            return false;
        }
    }
    // =======================================================

    public static boolean b1() {
        String decryptedM = decrypt(m);
        String[] var5 = a(decryptedM.trim(), new String(new char[]{','}), 0);
        return parseServerArray(var5);
    }

    public static void b() {
        try {
            ByteArrayInputStream var0 = new ByteArrayInputStream(RMS.gameAA(new String(new char[]{'a', 'b', 'c', 'd', 'i', 'p'})));
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

        // Fallback khi doc RMS loi
        String decryptedM = decrypt(m);
        String[] var5 = a(decryptedM.trim(), new String(new char[]{','}), 0);
        parseServerArray(var5);
    }

    public static String encryptDecrypt(String input) {
        char key = 'K';
        StringBuffer output = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key));
        }

        return output.toString();
    }

    // Ham split (tach chuoi) tuy chinh
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

    public static String encrypt(String input) {
        return Base64Utils.encode(input.getBytes());
    }

    public static String decrypt(String input) {
        return new String(Base64Utils.decode(input));
    }

    public static byte[] k7(byte[] in) {
        byte[] out = new byte[in.length];
        System.arraycopy(in, 0, out, 0, in.length);
        return out;
    }

    public static String i7(String s) {
        if (s == null)
            return null;
        char[] STD = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        char[] VAR = "ZYXABCDEFGHIJKLMNOPQRSTUVWzyxabcdefghijklmnopqrstuvw0123456789-_".toCharArray();
        StringBuffer out = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = -1;
            if (c < 128) {
                for (int j = 0; j < STD.length; j++) {
                    if (STD[j] == c) {
                        idx = j;
                        break;
                    }
                }
            }
            out.append(idx >= 0 ? VAR[idx] : c);
        }
        return out.toString();
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
            RMS.gameAA(new String(new char[]{'a', 'b', 'c', 'd', 'i', 'p'}), byteArrayOutputStream.toByteArray());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // ===== LIST DU PHONG - BASE64 =====
    static {
        m = "bG9jYWw6MTI3LjAuMC4xOjE0NDQ0OjA6MCxIYWNBbmg6Y2MyLmhhY2FuaG5pbmphLmNvbToxNDQ0NDowOjA=";
    }

    // URL de trong => fetch fail ngay => code tu dung field m (Base64 list).
    // Danh sach server duoc tool "CuongNSO Version Manager" ghi vao field m.
    static {
        url = "";
    }
}
