import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class ResourceCrypto {
   private static final byte[] MAGIC = new byte[]{69, 78, 67, 49};

   private static byte[] sha256(byte[] data) {
      return SHA256.digest(data);
   }

   private static byte[] hmac(byte[] key, byte[] data) {
      return HmacSha256.hmac(key, data);
   }

   private static byte[] concat(byte[] a, byte[] b) {
      byte[] r = new byte[a.length + b.length];
      System.arraycopy(a, 0, r, 0, a.length);
      System.arraycopy(b, 0, r, a.length, b.length);
      return r;
   }

   private static byte[] keystream(String path, int length) {
      byte[] pk = concat(SecurityConfig.key(), path.getBytes());
      int blocks = (length + 31) / 32;
      byte[] out = new byte[blocks * 32];

      for (int i = 0; i < blocks; i++) {
         byte[] ib = new byte[]{(byte)(i >>> 24), (byte)(i >>> 16), (byte)(i >>> 8), (byte)i};
         byte[] dig = sha256(concat(pk, ib));
         System.arraycopy(dig, 0, out, i * 32, 32);
      }

      if (out.length != length) {
         byte[] trimmed = new byte[length];
         System.arraycopy(out, 0, trimmed, 0, length);
         return trimmed;
      } else {
         return out;
      }
   }

   public static byte[] decryptIfNeeded(String path, byte[] in) {
      if (in != null && in.length >= MAGIC.length + 32) {
         for (int i = 0; i < MAGIC.length; i++) {
            if (in[i] != MAGIC[i]) {
               return in;
            }
         }

         byte[] tag = new byte[32];
         System.arraycopy(in, MAGIC.length, tag, 0, 32);
         int off = MAGIC.length + 32;
         int len = in.length - off;
         byte[] ks = keystream(path, len);
         byte[] plain = new byte[len];

         for (int ix = 0; ix < len; ix++) {
            plain[ix] = (byte)(in[off + ix] ^ ks[ix]);
         }

         byte[] calc = hmac(SecurityConfig.key(), concat(path.getBytes(), plain));
         boolean ok = true;

         for (int ix = 0; ix < 32; ix++) {
            if (calc[ix] != tag[ix]) {
               ok = false;
               break;
            }
         }

         return !ok ? in : plain;
      } else {
         return in;
      }
   }

   public static byte[] readResource(String path) {
      InputStream is = null;

      try {
         is = "".getClass().getResourceAsStream(path);
         if (is == null) {
            return null;
         } else {
            int avail = is.available();
            byte[] buf = new byte[avail];
            int read = 0;

            while (read < avail) {
               int r = is.read(buf, read, avail - read);
               if (r < 0) {
                  break;
               }

               read += r;
            }

            is.close();
            return decryptIfNeeded(path, buf);
         }
      } catch (Exception var7) {
         try {
            if (is != null) {
               is.close();
            }
         } catch (Exception var6) {
         }

         return null;
      }
   }

   public static InputStream open(String path) {
      byte[] data = readResource(path);
      return data == null ? null : new ByteArrayInputStream(data);
   }

   public static byte[] k3(byte[] in) {
      if (in.length == 0) {
         return in;
      } else {
         byte[] out = new byte[in.length];
         System.arraycopy(in, 0, out, 0, in.length);
         return out;
      }
   }

   public static String i3(String s) {
      return s;
   }
}
