package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.rms.RecordStore;

public final class ListKO implements CommandListener {
   private Command a;
   private Command b;
   private Command c;
   private Command d;
   private Command e;
   private List f;
   private Form g;
   private Form h;
   private TextField i;
   private Image j;
   public static Vector k = new Vector();
   public static ListKO abc = new ListKO();

   public static ListKO gI() {
      if (abc == null) {
         abc = new ListKO();
      }

      return abc;
   }

   public ListKO() {
      b();
      this.a = new Command("Xong", 7, 1);
      this.b = new Command("Thêm", 1, 1);
      this.c = new Command("Xóa", 1, 2);
      this.d = new Command("OK", 4, 1);
      this.e = new Command("Hủy", 7, 1);
   }

   public final void a() {
      if (k.size() <= 0) {
         this.h = new Form("Danh sách không PK");
         this.h.addCommand(this.a);
         this.h.addCommand(this.b);
         this.h.setCommandListener(this);
         Display.getDisplay(GameMidlet.g).setCurrent(this.h);
      } else {
         try {
            this.j = Image.createImage("/x1/kt.png");
         } catch (Exception var3) {
         }

         this.f = new List("Danh sách không PK", 3);

         for(int var2 = 0; var2 < k.size(); ++var2) {
            String var1 = (String)k.elementAt(var2);
            this.f.append(var1, this.j);
         }

         this.f.addCommand(this.a);
         this.f.addCommand(this.b);
         this.f.addCommand(this.c);
         this.f.setCommandListener(this);
         Display.getDisplay(GameMidlet.g).setCurrent(this.f);
      }

   }

   public final void commandAction(Command var1, Displayable var2) {
      int var4;
      String var8;
      if (var1 == this.a) {
         b("iuList");
         if (k.size() <= 0) {
            a(1, "");
         } else {
            StringBuffer var7 = new StringBuffer();

            for(var4 = 0; var4 < k.size(); ++var4) {
               var8 = (String)k.elementAt(var4);
               var7.append(var8 + "-");
            }

            a(1, var7.toString());
         }

         Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
         Code.popup_chat("Đã lưu thành công!");
      }

      if (var1 == this.b) {
         this.g = new Form("Thêm ingame bạn không muốn PK");
         this.g.append(this.i = new TextField("Tên:", (String)null, 5000, 0));
         this.g.addCommand(this.d);
         this.g.addCommand(this.e);
         this.g.setCommandListener(this);
         Display.getDisplay(GameMidlet.g).setCurrent(this.g);
      }

      String var5;
      if (var1 != this.c) {
         if (var1 == this.e) {
            this.a();
         }

         if (var1 == this.d) {
            if (!(var5 = this.i.getString()).equals("")) {
               k.addElement(var5);
            }

            this.a();
            return;
         }
      } else {
         var4 = this.f.getSelectedIndex();
         var8 = this.f.getString(var4);
         this.f.delete(var4);

         for(int var9 = 0; var9 < k.size(); ++var9) {
            var5 = (String)k.elementAt(var9);
            if (var8.equals(var5)) {
               k.removeElementAt(var9);
               return;
            }
         }
      }

   }

   private static void b() {
      String var0;
      if (!(var0 = b(1, "null")).equals("null")) {
         String var1 = "-";
         Vector var2 = new Vector();
         String var3 = var1;
         if (!var0.endsWith(var1)) {
            var0 = var0 + var1;
         }

         int var4 = 0;

         int var5;
         for(var5 = var0.indexOf(var1); var5 != -1; var5 = var0.indexOf(var3, var4)) {
            var2.addElement(var0.substring(var4, var5));
            var4 = var5 + var3.length();
         }

         String[] var6 = new String[var2.size()];
         var2.copyInto(var6);

         for(var5 = 0; var5 < var6.length; ++var5) {
            k.addElement(var6[var5]);
         }
      }

   }

   private static void b(String var0) {
      try {
         RecordStore.deleteRecordStore(var0);
      } catch (Exception var2) {
      }

   }

   private static void a(int var0, String var1) {
      try {
         RecordStore var2;
         int var3;
         byte[] var6;
         if ((var3 = (var2 = RecordStore.openRecordStore("iuList", true)).getNumRecords()) <= 0) {
            var6 = new byte[0];

            for(int var4 = 0; var4 < 1 - var3; ++var4) {
               var2.addRecord(var6, 0, 0);
            }
         }

         var6 = var1.getBytes("UTF-8");
         var2.setRecord(1, var6, 0, var6.length);
      } catch (Exception var6) {
      }

   }

   private static String b(int var0, String var1) {
      try {
         byte[] var3 = RecordStore.openRecordStore("iuList", true).getRecord(1);
         return new String(var3, "UTF-8");
      } catch (Exception var3) {
         return var1;
      }
   }

   public static boolean a(String var0) {
      return k.contains(Controller.fix_vip(var0));
   }

   public static void saveList() {
      b("iuList");
      if (k.size() <= 0) {
         a(1, "");
      } else {
         StringBuffer sb = new StringBuffer();
         for(int i = 0; i < k.size(); ++i) {
            sb.append((String)k.elementAt(i) + "-");
         }
         a(1, sb.toString());
      }
   }

}
