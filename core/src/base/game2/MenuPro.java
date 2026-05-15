package base.game2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MenuPro {
   public static boolean allow_check = true;
   public static boolean auto_x2    = false;
   public static boolean auto_tnp   = false;
   // [FIX 15] Remap khi HP <= ngưỡng %, 0 = tắt
   public static int hpOffPk = 0;

   public static final short ITEM_X2  = 248;
   public static final short ITEM_TNP = 538;

   public static void save() {
      try {
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         DataOutputStream out = new DataOutputStream(baos);
         out.writeBoolean(allow_check);
         out.writeBoolean(auto_x2);
         out.writeBoolean(auto_tnp);
         out.writeInt(hpOffPk); // [FIX 15]
         out.flush();
         RMS.a("MenuPro", baos.toByteArray());
      } catch (Exception e) {}
   }

   public static void load() {
      byte[] b = RMS.a("MenuPro");
      if (b == null) {
         allow_check = true;
         return;
      }
      try {
         DataInputStream in = new DataInputStream(new ByteArrayInputStream(b));
         allow_check = in.readBoolean();
         auto_x2     = in.readBoolean();
         auto_tnp    = in.readBoolean();
         if (in.available() >= 4) hpOffPk = in.readInt(); // [FIX 15] backward compat
         in.close();
      } catch (Exception e) {
         allow_check = true;
      }
   }
}
