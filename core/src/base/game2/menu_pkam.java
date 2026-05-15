package base.game2;

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

public class menu_pkam extends Form implements CommandListener {
   public static int khucpk = 20;
   public static int khudpk = 23;
   public static int map = 2;
   public static int x = 100;
   public static int y = 216;
   public static long ptpk = 80L;
   private TextField a;
   private TextField b;
   private TextField c;
   private TextField d;
   private TextField e;
   private TextField f;
   private Command z;
   private ChoiceGroup g;
   private ChoiceGroup m;
   private ChoiceGroup n;
   public static boolean isShow = RMS.c("isShow") == 1;

   public menu_pkam() {
      super("Menu pk âm kinh nghiệm");
      this.append(this.g = new ChoiceGroup("Menu pk", 1, new String[]{"Bật", "Tắt"}, (Image[])null));
      this.append(this.n = new ChoiceGroup("Hiện thông tin up", 1, new String[]{"Bật", "Tắt"}, (Image[])null));
      this.append(this.a = new TextField("Khu chờ pk ", String.valueOf(khucpk), 9, 2));
      this.append(this.b = new TextField("Khu đánh pk ", String.valueOf(khudpk), 9, 2));
      this.append(this.c = new TextField("ID map PK", String.valueOf(map), 9, 2));
      this.append(this.d = new TextField("Tọa độ X", String.valueOf(x), 9, 2));
      this.append(this.e = new TextField("Tọa độ Y", String.valueOf(y), 9, 2));
      this.append(this.f = new TextField("Bao nhiêu % thì pk", String.valueOf(ptpk), 9, 2));
      this.append("Lưu ý: ae tự thay tọa độ của riêng mình vào trước khi bật pk");
      this.addCommand(this.z = new Command("Lưu", 4, 0));
      this.addCommand(new Command("Thoát", 7, 0));
      this.setCommandListener(this);
      this.g.setSelectedIndex(Code.pkam ? 0 : 1, true);
//      this.n.setSelectedIndex(isShow ? 0 : 1, true);
      isShow = true;
      this.n.setSelectedIndex(0, true);
   }

   static void load_pkam() {
      byte[] a2;
      if ((a2 = RMS.a("SettingPKam")) != null) {
         ByteArrayInputStream in = new ByteArrayInputStream(a2);
         DataInputStream dataInputStream = new DataInputStream(in);

         try {
            khucpk = dataInputStream.readInt();
            khudpk = dataInputStream.readInt();
            map = dataInputStream.readInt();
            x = dataInputStream.readInt();
            y = dataInputStream.readInt();
            ptpk = dataInputStream.readLong();
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
            Code.pkam = this.g.getSelectedIndex() == 0;
            RMS.a("Phongpkam", Code.pkam ? 1 : -1);
            khucpk = Integer.parseInt(this.a.getString());
            khudpk = Integer.parseInt(this.b.getString());
            map = Integer.parseInt(this.c.getString());
            x = Integer.parseInt(this.d.getString());
            y = Integer.parseInt(this.e.getString());
            ptpk = Long.parseLong(this.f.getString());
            isShow = this.n.getSelectedIndex() == 0;
            RMS.a("isShow", isShow ? 1 : -1);
            var2.writeInt(khucpk);
            var2.writeInt(khudpk);
            var2.writeInt(map);
            var2.writeInt(x);
            var2.writeInt(y);
            var2.writeLong(ptpk);
            RMS.a("SettingPKam", ((ByteArrayOutputStream)var1).toByteArray());
            var2.flush();
            var1.flush();
            Code.popup_chat("Lưu cài đặt thành công");
         } catch (Exception var6) {
         }
      }

      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }

}
