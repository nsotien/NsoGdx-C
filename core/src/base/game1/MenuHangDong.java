package base.game1;

import java.io.BufferedReader;
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

public class MenuHangDong extends Form implements CommandListener {
   private TextField a;
   private TextField b;
   private TextField c;
   private TextField d;
   private TextField e;
   private TextField f_field;
   private Command z;
   private ChoiceGroup aa;
   public static int phut_hd;
   public static int gio_hd;
   public static int phut_hd_lbhd = 15;
   public static int gio_hd_lbhd = 2;
   public static boolean autohd = RMS.c("autohd") == -1 ? false : RMS.c("autohd") == 1;
   public static boolean autohd_lbhd = RMS.c("autohd_lbhd") == 1;
   public static boolean theoNhom = RMS.c("theoNhom_hd") == 1;
   public static boolean layRuong = RMS.c("layRuong_hd") == 1;
   public static int map_nhom;
   public static int khu_nhom = 1;

   public MenuHangDong() {
      super("Cài đặt hang động");
      this.append(this.aa = new ChoiceGroup("Auto", 2, new String[]{"Đan", "Hang động", "Lệnh bài hd", "Hang động theo nhóm", "Lấy rương (hd9x)"}, (Image[])null));
      this.append(this.a = new TextField("Giờ hang động", String.valueOf(gio_hd), 9, 2));
      this.append(this.b = new TextField("Phút hang động", String.valueOf(phut_hd), 9, 2));
      this.append(this.c = new TextField("Giờ hang động (lệnh bài)", String.valueOf(gio_hd_lbhd), 9, 2));
      this.append(this.d = new TextField("Phút hang động (lệnh bài)", String.valueOf(phut_hd_lbhd), 9, 2));
      this.append(this.e = new TextField("Map tập trung (nhóm)", String.valueOf(map_nhom), 9, 2));
      this.append(this.f_field = new TextField("Khu tập trung (nhóm)", String.valueOf(khu_nhom), 9, 2));
      this.addCommand(this.z = new Command("Save", 4, 0));
      this.addCommand(new Command("Cancel", 7, 0));
      this.setCommandListener(this);
      this.aa.setSelectedIndex(0, Code.autoDan);
      this.aa.setSelectedIndex(1, autohd);
      this.aa.setSelectedIndex(2, autohd_lbhd);
      this.aa.setSelectedIndex(3, theoNhom);
      this.aa.setSelectedIndex(4, layRuong);
   }

   public void a() {
      Display.getDisplay(GameMidlet.g).setCurrent(this);
   }

   public void commandAction(Command arg0, Displayable arg1) {
      if (arg0 == this.z) {
         try {
            gio_hd = Integer.parseInt(this.a.getString());
            phut_hd = Integer.parseInt(this.b.getString());
            gio_hd_lbhd = Integer.parseInt(this.c.getString());
            phut_hd_lbhd = Integer.parseInt(this.d.getString());
            map_nhom = Integer.parseInt(this.e.getString());
            khu_nhom = Integer.parseInt(this.f_field.getString());
            Code.autoDan = this.aa.isSelected(0);
            autohd = this.aa.isSelected(1);
            autohd_lbhd = this.aa.isSelected(2);
            theoNhom = this.aa.isSelected(3);
            layRuong = this.aa.isSelected(4);
            RMS.a("autoDan", Code.autoDan ? 1 : -1);
            RMS.a("autohd", autohd ? 1 : -1);
            RMS.a("autohd_lbhd", autohd_lbhd ? 1 : -1);
            RMS.a("theoNhom_hd", theoNhom ? 1 : -1);
            RMS.a("layRuong_hd", layRuong ? 1 : -1);
            RMS.a("SettingCave", gio_hd + ";" + phut_hd + ";" + gio_hd_lbhd + ";" + phut_hd_lbhd + ";" + map_nhom + ";" + khu_nhom + ";" + autohd + ";" + autohd_lbhd + ";" + Code.autoDan + ";" + theoNhom + ";" + layRuong);
            Code.popup_chat("Lưu cài đặt thành công");
         } catch (NumberFormatException var4) {
         }
      }

      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }

}
