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
   public static String m;
   public static String[] listKey;
   public static long expEpoch;
   public static boolean permanent;

   private static String readMz() {
      try {
         String[] paths = new String[]{"/" + deriveName(), "/mz"};

         for (int i = 0; i < paths.length; i++) {
            String path = paths[i];
            byte[] b = ResourceCrypto.readResource(path);
            if (b != null) {
               String content = new String(b, "UTF-8").trim();
               if (content.length() != 0) {
                  if (containsHangul(content)) {
                     mResources.languageID = 1;
                     RMS.gameAA("indLanguage", 1);
                     mResources.gameAA();
                  }

                  String verified = SignedConfig.verify(content);
                  if (verified != null) {
                     if (verified.startsWith("ENCX:")) {
                        verified = encryptDecrypt(verified.substring(5));
                     }

                     return verified;
                  }

                  if (content.startsWith("ENCX:")) {
                     return encryptDecrypt(content.substring(5));
                  }
               }
            }
         }

         return null;
      } catch (Exception var6) {
         return null;
      }
   }

   private static long parseEpochField(String f) {
      if (f != null && f.length() != 0) {
         StringBuffer digits = new StringBuffer(f.length());

         for (int i = 0; i < f.length(); i++) {
            char c = f.charAt(i);
            if (c >= '0' && c <= '9') {
               digits.append(c);
            }
         }

         if (digits.length() == 0) {
            return 0L;
         } else {
            try {
               return Long.parseLong(digits.toString());
            } catch (Exception var4) {
               return 0L;
            }
         }
      } else {
         return 0L;
      }
   }

   private static String deriveName() {
      String mid = "GameMidlet";
      byte[] key = SecurityConfig.key();
      byte[] data = new byte[key.length + mid.length()];
      System.arraycopy(key, 0, data, 0, key.length);
      byte[] mb = mid.getBytes();
      System.arraycopy(mb, 0, data, key.length, mb.length);
      byte[] dig = SHA256.digest(data);
      char[] hex = new char[16];

      for (int i = 0; i < 8; i++) {
         int b = dig[i] & 255;
         int hi = b >>> 4 & 15;
         int lo = b & 15;
         hex[i * 2] = (char)(hi < 10 ? 48 + hi : 97 + (hi - 10));
         hex[i * 2 + 1] = (char)(lo < 10 ? 48 + lo : 97 + (lo - 10));
      }

      String h = new String(hex);
      return "cfg_" + h;
   }

   private static boolean containsHangul(String s) {
      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         if (c >= '가' && c <= '\ud7af') {
            return true;
         }

         if (c >= 4352 && c <= 4607) {
            return true;
         }

         if (c >= 12592 && c <= 12687) {
            return true;
         }
      }

      return false;
   }

   private static String fp() {
      String p = System.getProperty("microedition.platform");
      String s = (p == null ? "" : p) + "|" + mGraphics.nxZ() + "|" + GameCanvas.nxC() + "|" + TField.nxK();
      byte[] dig = SHA256.digest(s.getBytes());
      return Service.nx(dig);
   }

   private static String encUrl(String s) {
      if (s == null) {
         return "";
      } else {
         StringBuffer sb = new StringBuffer();

         for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean ok = c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c == '-' || c == '_' || c == '.' || c == '~';
            if (ok) {
               sb.append(c);
            } else {
               int b = c;
               if (c < 0) {
                  b = c + 256;
               }

               int hi = b >>> 4 & 15;
               int lo = b & 15;
               sb.append('%');
               sb.append((char)(hi < 10 ? 48 + hi : 65 + (hi - 10)));
               sb.append((char)(lo < 10 ? 48 + lo : 65 + (lo - 10)));
            }
         }

         return sb.toString();
      }
   }

   private static boolean checkExpiry(long expEpoch) {
      return true;
   }

   public static boolean isExpired() {
      return false;
   }

   public static String remainLabel() {
      return "Chào mừng bạn đến với Đảo Quốc NINJA";
   }

   public static String a(String s) {
      StringBuffer result = new StringBuffer();
      HttpConnection httpConnection = null;
      InputStream openInputStream = null;
      InputStreamReader reader = null;

      Object buffer;
      try {
         httpConnection = (HttpConnection)Connector.open(s);
         if (httpConnection.getResponseCode() != 200) {
            throw new IOException(httpConnection.getResponseMessage());
         }

         openInputStream = httpConnection.openInputStream();
         reader = new InputStreamReader(openInputStream, new String(new char[]{'U', 'T', 'F', '-', '8'}));
         char[] bufferx = new char[256];

         int read;
         while ((read = reader.read(bufferx)) != -1) {
            result.append(bufferx, 0, read);
         }

         return result.toString();
      } catch (Exception var16) {
         var16.printStackTrace();
         buffer = null;
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
         } catch (IOException var15) {
            var15.printStackTrace();
         }
      }

      return (String)buffer;
   }

   public static boolean a() {
      String src = readMz();
      if (src == null) {
         return false;
      } else {
         src = src.trim();
         String[] stringArray = a(src, new String(new char[]{','}), 0);
         if (stringArray.length == 0) {
            return false;
         } else {
            listName = new String[stringArray.length];
            listIP = new String[stringArray.length];
            listPort = new int[stringArray.length];
            serverLoginList = new byte[stringArray.length];
            serverST = new int[stringArray.length];
            listKey = new String[stringArray.length];

            for (int n = 0; n < stringArray.length; serverST[n] = n++) {
               String[] stringArray2 = a(stringArray[n].trim(), new String(new char[]{'x'}), 0);
               listName[n] = "Server " + (n + 1);
               int keyIdx = stringArray2.length >= 5 ? 1 : (stringArray2.length > 3 ? 3 : -1);
               int portIdx = stringArray2.length >= 5 ? 2 : (stringArray2.length > 1 ? 1 : -1);
               int loginIdx = stringArray2.length >= 5 ? 3 : (stringArray2.length > 2 ? 2 : -1);
               if (stringArray2.length >= 5 && stringArray2[4].length() > 0) {
                  stringArray2[4].charAt(0);
               } else {
                  byte var10000 = 86;
               }

               if (portIdx < 0 || loginIdx < 0) {
                  return false;
               }

               String kraw = keyIdx >= 0 ? stringArray2[keyIdx] : null;
               if (n == 0) {
                  permanent = kraw != null && kraw.equalsIgnoreCase("vv");
               }

               String k = kraw;
               if (kraw != null && kraw.equalsIgnoreCase("vv")) {
                  k = "aqwertyuiop";
               }

               listKey[n] = k;
               String encIp = Base64Utils.i10(
                  TileMap.i9(Code.i8(i7(NinjaUtil.i6(Service.i5(SHA256.i4(ResourceCrypto.i3(HmacSha256.i2(SignedConfig.i1(stringArray2[0])))))))))
               );
               listIP[n] = Service.px9(encIp, k);
               String encPort = Base64Utils.i10(
                  TileMap.i9(Code.i8(i7(NinjaUtil.i6(Service.i5(SHA256.i4(ResourceCrypto.i3(HmacSha256.i2(SignedConfig.i1(stringArray2[portIdx])))))))))
               );
               String portDec = Service.px9(encPort, k);
               listPort[n] = Integer.parseInt(portDec);
               serverLoginList[n] = Byte.parseByte(stringArray2[loginIdx]);
            }

            long expEpoch = 0L;
            if (stringArray.length > 0) {
               String[] t0 = a(stringArray[0].trim(), new String(new char[]{'x'}), 0);
               if (t0.length >= 5) {
                  expEpoch = parseEpochField(t0[4]);
               }
            }

            UpdateServer.expEpoch = expEpoch;
            if (!checkExpiry(expEpoch)) {
               return false;
            } else {
               c();
               return true;
            }
         }
      }
   }

   public static byte[] k7(byte[] in) {
      byte[] out = new byte[in.length];
      System.arraycopy(in, 0, out, 0, in.length);
      return out;
   }

   public static String i7(String s) {
      if (s == null) {
         return null;
      } else {
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
   }

   public static boolean b1() {
      String src = readMz();
      if (src == null) {
         return false;
      } else {
         src = src.trim();
         String[] var5 = a(src, new String(new char[]{','}), 0);
         listName = new String[var5.length];
         listIP = new String[var5.length];
         listPort = new int[var5.length];
         serverLoginList = new byte[var5.length];
         serverST = new int[var5.length];
         listKey = new String[var5.length];

         for (int var6 = 0; var6 < var5.length; serverST[var6] = var6++) {
            String[] var2 = a(var5[var6].trim(), new String(new char[]{'x'}), 0);
            listName[var6] = "Server " + (var6 + 1);
            int keyIdx = var2.length >= 5 ? 1 : (var2.length > 3 ? 3 : -1);
            int portIdx = var2.length >= 5 ? 2 : (var2.length > 1 ? 1 : -1);
            int loginIdx = var2.length >= 5 ? 3 : (var2.length > 2 ? 2 : -1);
            if (var2.length >= 5 && var2[4].length() > 0) {
               var2[4].charAt(0);
            } else {
               byte var10000 = 86;
            }

            if (portIdx < 0 || loginIdx < 0) {
               return false;
            }

            String kraw = keyIdx >= 0 ? var2[keyIdx] : null;
            if (var6 == 0) {
               permanent = kraw != null && kraw.equalsIgnoreCase("vv");
            }

            String k = kraw;
            if (kraw != null && kraw.equalsIgnoreCase("vv")) {
               k = "aqwertyuiop";
            }

            listKey[var6] = k;
            String encIp = Base64Utils.i10(
               TileMap.i9(Code.i8(i7(NinjaUtil.i6(Service.i5(SHA256.i4(ResourceCrypto.i3(HmacSha256.i2(SignedConfig.i1(var2[0])))))))))
            );
            listIP[var6] = Service.px9(encIp, k);
            String encPort = Base64Utils.i10(
               TileMap.i9(Code.i8(i7(NinjaUtil.i6(Service.i5(SHA256.i4(ResourceCrypto.i3(HmacSha256.i2(SignedConfig.i1(var2[portIdx])))))))))
            );
            String portDec = Service.px9(encPort, k);
            listPort[var6] = Integer.parseInt(portDec);
            serverLoginList[var6] = Byte.parseByte(var2[loginIdx]);
         }

         long expEpoch = 0L;
         if (var5.length > 0) {
            String[] t0 = a(var5[0].trim(), new String(new char[]{'x'}), 0);
            if (t0.length >= 5) {
               expEpoch = parseEpochField(t0[4]);
            }
         }

         UpdateServer.expEpoch = expEpoch;
         if (!checkExpiry(expEpoch)) {
            return false;
         } else {
            c();
            return true;
         }
      }
   }

   public static void b() {
      try {
         ByteArrayInputStream var0 = new ByteArrayInputStream(RMS.gameAA(new String(new char[]{'a', 'b', 'c', 'd', 'i', 'p'})));
         DataInputStream var1 = new DataInputStream(var0);
         if (var0.available() > 0) {
            int var7 = var1.readInt();
            listName = new String[var7];
            listIP = new String[var7];
            listPort = new int[var7];
            serverLoginList = new byte[var7];
            serverST = new int[var7];
            listKey = new String[var7];

            for (int var3 = 0; var3 < var7; serverST[var3] = var3++) {
               listName[var3] = var1.readUTF();
               listIP[var3] = var1.readUTF();
               listPort[var3] = var1.readInt();
               serverLoginList[var3] = var1.readByte();
            }

            var0.close();
            var1.close();
            return;
         }
      } catch (Exception var13) {
      }

      String src = readMz();
      if (src != null) {
         src = src.trim();
         String[] var5 = a(src, new String(new char[]{','}), 0);
         listName = new String[var5.length];
         listIP = new String[var5.length];
         listPort = new int[var5.length];
         serverLoginList = new byte[var5.length];
         serverST = new int[var5.length];

         for (int var6 = 0; var6 < var5.length; serverST[var6] = var6++) {
            String[] var2 = a(var5[var6].trim(), new String(new char[]{'x'}), 0);
            listName[var6] = "Server " + (var6 + 1);
            int keyIdx = var2.length >= 5 ? 1 : (var2.length > 3 ? 3 : -1);
            int portIdx = var2.length >= 5 ? 2 : (var2.length > 1 ? 1 : -1);
            int loginIdx = var2.length >= 5 ? 3 : (var2.length > 2 ? 2 : -1);
            if (var2.length >= 5 && var2[4].length() > 0) {
               var2[4].charAt(0);
            } else {
               byte var10000 = 86;
            }

            if (portIdx < 0 || loginIdx < 0) {
               return;
            }

            String kraw = keyIdx >= 0 ? var2[keyIdx] : null;
            if (var6 == 0) {
               permanent = kraw != null && kraw.equalsIgnoreCase("vv");
            }

            String k = kraw;
            if (kraw != null && kraw.equalsIgnoreCase("vv")) {
               k = "aqwertyuiop";
            }

            listKey[var6] = k;
            String encIp2 = Base64Utils.i10(
               TileMap.i9(Code.i8(i7(NinjaUtil.i6(Service.i5(SHA256.i4(ResourceCrypto.i3(HmacSha256.i2(SignedConfig.i1(var2[0])))))))))
            );
            listIP[var6] = Service.px9(encIp2, k);
            String encPort2 = Base64Utils.i10(
               TileMap.i9(Code.i8(i7(NinjaUtil.i6(Service.i5(SHA256.i4(ResourceCrypto.i3(HmacSha256.i2(SignedConfig.i1(var2[portIdx])))))))))
            );
            String portDec = Service.px9(encPort2, k);
            listPort[var6] = Integer.parseInt(portDec);
            serverLoginList[var6] = Byte.parseByte(var2[loginIdx]);
         }

         long expEpoch2 = 0L;
         if (var5.length > 0) {
            String[] t0 = a(var5[0].trim(), new String(new char[]{'x'}), 0);
            if (t0.length >= 5) {
               expEpoch2 = parseEpochField(t0[4]);
            }
         }

         expEpoch = expEpoch2;
         if (checkExpiry(expEpoch2)) {
            c();
         }
      }
   }

   public static String encryptDecrypt(String input) {
      char key = 'K';
      StringBuffer output = new StringBuffer();

      for (int i = 0; i < input.length(); i++) {
         output.append((char)(input.charAt(i) ^ key));
      }

      return output.toString();
   }

   public static String[] a(String string, String string2, int n) {
      int n2 = string.indexOf(string2);
      String[] stringArray;
      if (n2 >= 0) {
         stringArray = a(string.substring(n2 + string2.length()), string2, n + 1);
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

   public static void c() {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

      try {
         int n = listIP.length;
         dataOutputStream.writeInt(n);

         for (int n2 = 0; n2 < n; n2++) {
            dataOutputStream.writeUTF(listName[n2]);
            dataOutputStream.writeUTF(listIP[n2]);
            dataOutputStream.writeInt(listPort[n2]);
            dataOutputStream.writeByte(serverLoginList[n2]);
         }

         dataOutputStream.flush();
         byteArrayOutputStream.flush();
         RMS.gameAA(new String(new char[]{'a', 'b', 'c', 'd', 'i', 'p'}), byteArrayOutputStream.toByteArray());
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   static {
      String mz = readMz();
      m = mz;
   }
}
