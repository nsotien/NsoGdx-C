package base.game1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;

public class Setting extends Form implements CommandListener {
   private ChoiceGroup a;
   private ChoiceGroup b;
   private ChoiceGroup c;
   private ChoiceGroup e;
   private ChoiceGroup f;
   private TextField d;
   private Command z;
   public static int mode_1;
   public static int mode_2;
   public static int mode_3;
   public static int mode_4;
   public static int hieuchien = 5;
   public static boolean hlct = false;
   public static boolean hsl = false;

   public Setting() {
      super("Menu auto PK người");
      this.append(this.f = new ChoiceGroup("Tàn sát", 1, new String[]{"Đánh cả quái lẫn người", "Đánh người"}, (Image[])null));
      this.append(this.a = new ChoiceGroup("Option 1", 1, new String[]{"Cừu sát", "Đồ sát", "Khi họ bật đồ sát", "Đồ sát (luôn bật)"}, (Image[])null));
      this.append(this.b = new ChoiceGroup("Option 2", 1, new String[]{"Dịch chuyển", "Đánh khi ở trong tầm"}, (Image[])null));
      this.append(this.c = new ChoiceGroup("Option 3", 1, new String[]{"Đánh tất cả", "Đánh trong ListPK"}, (Image[])null));
      this.append(this.e = new ChoiceGroup("Option 4", 2, new String[]{"Hồi sinh lượng", "Hoàn lương chi thảo"}, (Image[])null));
      this.append(this.d = new TextField("Sẽ dùng hlct khi hiếu chiến", String.valueOf(hieuchien), 9, 2));
      this.addCommand(this.z = new Command("Lưu", 4, 0));
      this.addCommand(new Command("Thoát", 7, 0));
      this.setCommandListener(this);
      this.a.setSelectedIndex(mode_1, true);
      this.b.setSelectedIndex(mode_2, true);
      this.c.setSelectedIndex(mode_3, true);
      this.e.setSelectedIndex(0, hsl);
      this.e.setSelectedIndex(1, hlct);
      this.f.setSelectedIndex(mode_4, true);
   }

   static void load() {
      byte[] a2;
      if ((a2 = RMS.a("SettingPK")) != null) {
         ByteArrayInputStream in = new ByteArrayInputStream(a2);
         DataInputStream dataInputStream = new DataInputStream(in);

         try {
            mode_1 = dataInputStream.readInt();
            mode_2 = dataInputStream.readInt();
            mode_3 = dataInputStream.readInt();
            hieuchien = dataInputStream.readInt();
            hsl = dataInputStream.readBoolean();
            hlct = dataInputStream.readBoolean();
            mode_4 = dataInputStream.readInt();
            dataInputStream.close();
            in.close();
         } catch (Exception var4) {
         }
      }

   }

   public void commandAction(Command arg0, Displayable arg1) {
      if (arg0 == this.z) {
         OutputStream var1 = new ByteArrayOutputStream();
         DataOutputStream var2 = new DataOutputStream(var1);

         try {
            mode_1 = this.a.getSelectedIndex();
            mode_2 = this.b.getSelectedIndex();
            mode_3 = this.c.getSelectedIndex();
            hieuchien = Integer.parseInt(this.d.getString());
            hsl = this.e.isSelected(0);
            hlct = this.e.isSelected(1);
            mode_4 = this.f.getSelectedIndex();
            var2.writeInt(mode_1);
            var2.writeInt(mode_2);
            var2.writeInt(mode_3);
            var2.writeInt(hieuchien);
            var2.writeBoolean(hsl);
            var2.writeBoolean(hlct);
            var2.writeInt(mode_4);
            RMS.a("SettingPK", ((ByteArrayOutputStream)var1).toByteArray());
            var2.flush();
            var1.flush();
            Code.popup_chat("Lưu cài đặt thành công");
         } catch (Exception var6) {
         }
      }

      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }

}
